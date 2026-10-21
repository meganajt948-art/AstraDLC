package dev.dj.cortim.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.dj.cortim.Cortim;
import dev.dj.cortim.gui.ItemSelector;
import dev.dj.cortim.gui.LootPickerScreen;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.WorldChunk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class AutoEnd extends Module implements ItemSelector {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("cortim_autoend_loot.json");

    private static final List<String> KEYS_DEPOSIT = List.of("сбор", "сброс");
    private static final List<String> KEYS_SPEED = List.of("скорост");
    private static final List<String> KEYS_INVIS = List.of("инвиз", "невидим");
    private static final List<String> KEYS_FOOD = List.of("еда", "еды", "food");

    private static final Predicate<BlockState> POT_TEST = s -> s.isOf(Blocks.DECORATED_POT);
    private static final Predicate<BlockState> SAND_TEST =
            s -> s.isOf(Blocks.SUSPICIOUS_SAND) || s.isOf(Blocks.SUSPICIOUS_GRAVEL);
    private static final Predicate<BlockState> PORTAL_TEST = s -> s.isOf(Blocks.END_PORTAL);

    /** Точки на блоке, куда пробуем навести прицел, если первая закрыта. */
    private static final double[][] AIM = {
            {0, 0, 0}, {0, 0.28, 0}, {0.28, 0, 0.28}, {-0.28, 0, 0.28}, {0.28, 0, -0.28}, {-0.28, 0, -0.28}
    };

    private final Set<String> selected = new LinkedHashSet<>();

    // ---------- настройки ----------
    private final IntSetting maxVases = add(new IntSetting("Макс. ваз",
            "Сколько ваз разбить за заход", 30, 1, 30));

    private final ButtonSetting lootList = add(new ButtonSetting("Список лута",
            "Предметы, которые сдавать в сундук", this::openPicker) {
        @Override public String display() { return "+" + selected.size(); }
    });

    private final BoolSetting useBrush = add(new BoolSetting("Использовать кисть",
            "Подбирать выпавшую кисть и расчищать подозрительный песок", false));
    private final BoolSetting takeSpeed = add(new BoolSetting("Брать скорость",
            "Брать зелье скорости из сундука со знаком Скорость", false));
    private final BoolSetting takeInvis = add(new BoolSetting("Брать инвиз",
            "Брать зелье невидимости из сундука со знаком Инвиз", false));
    private final BoolSetting takeFood = add(new BoolSetting("Брать еду",
            "Брать еду из сундука со знаком Еда", false));

    private final TextSetting saveAn = add(new TextSetting("Сейв Энд",
            "Анархия, где сундуки (например an507)", "an507"));
    private final TextSetting lootAn = add(new TextSetting("Лут Энд",
            "Анархия, где лутаются вазы (например an508)", "an508"));

    private final ModeSetting tpMode = add(new ModeSetting("Способ ТП",
            "Как попасть к порталу в Энд", 0, "Хом", "Варп").asSegmented());

    private final TextSetting warpName = add(new TextSetting("Название варпа",
            "Имя варпа для /warp", "end") {
        @Override public boolean isVisible() { return tpMode.get() == 1; }
    });

    private final IntSetting lookSpeed = add(new IntSetting("Скорость взгляда",
            "Потолок поворота за тик: меньше = медленнее", 5, 2, 30) {
        @Override public String display() { return get() + "°"; }
    });

    // ---------- состояние ----------
    private enum Phase { START, SAVE_WAIT, SUPPLIES, LOOT_AN_WAIT, PORTAL, LOOT, BACK_WAIT, DEPOSIT }
    private enum Sub { CENTER, SEARCH, POT, COLLECT, SAND }
    private enum Kind { SPEED, INVIS, FOOD, DEPOSIT }
    private record Task(List<String> keys, Kind kind) {}
    private record SignInfo(BlockPos pos, String text) {}

    private Phase phase = Phase.START;
    private Sub sub = Sub.CENTER;
    private boolean wasOn = false;

    private long until = 0L, lastAct = 0L, waitStart = 0L, changedAt = 0L;
    private long taskStart = 0L, usingUntil = 0L, nextUse = 0L, nextHit = 0L;
    private long subStart = 0L, lastProgress = 0L, scanAt = 0L;

    private ClientWorld worldBefore = null;
    private Vec3d tpFrom = Vec3d.ZERO;
    private boolean tpDone = false, portalDirect = false;
    private long portalStart = 0L;

    private final List<Task> tasks = new ArrayList<>();
    private int taskIdx = 0;
    private BlockPos taskChest = null;
    private long chestScanAt = 0L;
    private int lastSlotId = -1, lastCount = -1, stuck = 0;

    private int broken = 0;
    private BlockPos targetPot = null, pendingBreak = null, targetSand = null;
    private int hitAttempts = 0;
    private long potStart = 0L, sandStart = 0L, collectUntil = 0L, chaseStart = 0L;
    private int chaseId = -1;
    private boolean brushing = false;
    private final Set<BlockPos> skipped = new HashSet<>();
    private final Set<Integer> skippedItems = new HashSet<>();
    private final List<Vec3d> waypoints = new ArrayList<>();
    private int wpIdx = 0;
    private long wpStart = 0L;

    // ---------- взгляд ----------
    private float tYaw = 0f, tPitch = 0f;
    private boolean lookActive = false;
    private float yawVel = 0f, pitchVel = 0f, accY = 0f, accP = 0f;
    private long lookFreezeUntil = 0L;

    private BlockPos aimBlockPos = null;
    private int aimIdx = 0;
    private long aimIdxAt = 0L, aimSettleAt = 0L;

    // ---------- ходьба и путь ----------
    private final List<BlockPos> path = new ArrayList<>();
    private int pathIdx = 0;
    private boolean goalSet = false;
    private double gTx, gTy, gTz, gR;
    private boolean gThree;
    private long nextPlan = 0L;
    private int failPlans = 0, replans = 0;
    private final BlockPos.Mutable mp = new BlockPos.Mutable();

    private long chkAt = 0L, strafeUntil = 0L;
    private double chkX = 0, chkZ = 0;
    private int stuckCount = 0, strafeDir = 1;
    private boolean moveBlocked = false;

    // ---------- «живая» ходьба: прыжки, кривизна, взгляды по сторонам ----------
    private long nextHop = 0L;                       // когда прыгнуть в следующий раз
    private long nextMicro = 0L, microUntil = 0L;    // короткие шаги в сторону
    private int microDir = 1;
    private long nextGlance = 0L, glanceUntil = 0L;  // взгляд «по сторонам»
    private float glanceYaw = 0f, glancePitch = 0f;
    private long nextSlow = 0L, slowUntil = 0L;      // иногда идём без спринта
    private long nextWobble = 0L;                    // плавное «рыскание» курса
    private float wobble = 0f, wobbleGoal = 0f, wobbleP = 0f, wobblePGoal = 0f;
    private int jitterIdx = -1;                      // смещение внутри блока для узла пути
    private double jitX = 0, jitZ = 0;

    public AutoEnd() {
        super("AutoEnd", Category.PLAYER);
        loadItems();
    }

    // ================= выбор лута =================
    @Override public Set<String> getSelected() { return selected; }
    @Override public void toggleItem(String id) { if (!selected.remove(id)) selected.add(id); saveItems(); }
    @Override public void clearItems() { selected.clear(); saveItems(); }

    private void openPicker() {
        MinecraftClient mc = MinecraftClient.getInstance();
        mc.setScreen(new LootPickerScreen(this, mc.currentScreen));
    }

    private void saveItems() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(new LinkedHashSet<>(selected)));
        } catch (IOException e) { Cortim.LOG.warn("autoend save failed", e); }
    }

    private void loadItems() {
        try {
            if (Files.exists(FILE)) {
                Set<String> s = GSON.fromJson(Files.readString(FILE), new TypeToken<LinkedHashSet<String>>(){}.getType());
                if (s != null) for (String id : s) if (LootCatalog.byId(id) != null) selected.add(id);
                return;
            }
        } catch (Exception e) { Cortim.LOG.warn("autoend load failed", e); }
        for (LootCatalog.Entry e : LootCatalog.ALL) selected.add(e.id());
    }

    private boolean isLoot(ItemStack st) { return LootCatalog.matchesAny(selected, st); }

    private boolean wantItem(ItemStack st) {
        return isLoot(st) || (useBrush.get() && st.isOf(Items.BRUSH));
    }

    private boolean hasLoot(ClientPlayerEntity p) {
        for (int i = 0; i < 36; i++) if (isLoot(p.getInventory().getStack(i))) return true;
        return false;
    }

    // ================= главный тик =================
    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity p = mc.player;

        if (!isEnabled() || p == null || mc.world == null || mc.interactionManager == null) {
            if (wasOn) {
                wasOn = false;
                lookActive = false;
                if (p != null) releaseAll(mc);
            }
            return;
        }
        wasOn = true;

        if (mc.currentScreen != null && !(mc.currentScreen instanceof GenericContainerScreen)) {
            releaseAll(mc);
            return;
        }
        if (!p.isAlive()) { releaseAll(mc); return; }

        long now = System.currentTimeMillis();
        lookActive = false;                       // шаги ниже сами включат, если нужен взгляд
        step(mc, p, now);
        if (lookActive && mc.currentScreen == null) smoothLook(mc, p, now);
        else { yawVel *= 0.6f; pitchVel *= 0.6f; }
    }

    private void step(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (usingUntil > 0 && now >= usingUntil) { mc.options.useKey.setPressed(false); usingUntil = 0; }
        if (now < until) { lookActive = true; return; }

        switch (phase) {
            case START -> {
                if (inEnd(mc)) { startLoot(now); phase = Phase.LOOT; return; }
                if (findChestBySign(mc, p, KEYS_DEPOSIT) != null) {
                    buildTasks();
                    phase = hasLoot(p) ? Phase.DEPOSIT : Phase.SUPPLIES;
                    return;
                }
                cmd(p, saveAn.get());
                beginSwitch(mc, now);
                phase = Phase.SAVE_WAIT;
            }
            case SAVE_WAIT -> {
                if (arrivedAfterSwitch(mc, now)) {
                    buildTasks();
                    phase = Phase.SUPPLIES;
                    until = now + 500 + rnd(500);
                }
            }
            case SUPPLIES -> {
                if (taskIdx >= tasks.size()) {
                    releaseAll(mc);
                    cmd(p, lootAn.get());
                    beginSwitch(mc, now);
                    phase = Phase.LOOT_AN_WAIT;
                } else if (chestTask(mc, p, tasks.get(taskIdx), now)) {
                    taskIdx++;
                    resetTask();
                }
            }
            case LOOT_AN_WAIT -> {
                if (arrivedAfterSwitch(mc, now)) {
                    if (tpMode.get() == 0) cmd(p, "home");
                    else cmd(p, "warp " + warpName.get().trim());
                    tpFrom = new Vec3d(p.getX(), p.getY(), p.getZ());
                    tpDone = false;
                    portalDirect = false;
                    waitStart = now;
                    phase = Phase.PORTAL;
                    until = now + 1200 + rnd(600);
                }
            }
            case PORTAL -> portalTick(mc, p, now);
            case LOOT -> lootTick(mc, p, now);
            case BACK_WAIT -> {
                if (arrivedAfterSwitch(mc, now)) {
                    resetTask();
                    tasks.clear();
                    phase = Phase.DEPOSIT;
                    until = now + 500 + rnd(500);
                }
            }
            case DEPOSIT -> {
                if (chestTask(mc, p, new Task(KEYS_DEPOSIT, Kind.DEPOSIT), now)) {
                    buildTasks();
                    phase = Phase.SUPPLIES;
                }
            }
        }
    }

    private void beginSwitch(MinecraftClient mc, long now) {
        worldBefore = mc.world;
        waitStart = now;
        changedAt = 0L;
        until = now + 1500;
    }

    private boolean arrivedAfterSwitch(MinecraftClient mc, long now) {
        if (mc.world != worldBefore) {
            if (changedAt == 0L) changedAt = now;
            return now - changedAt > 1800;
        }
        return now - waitStart > 10000;
    }

    private void buildTasks() {
        tasks.clear();
        taskIdx = 0;
        resetTask();
        if (takeSpeed.get()) tasks.add(new Task(KEYS_SPEED, Kind.SPEED));
        if (takeInvis.get()) tasks.add(new Task(KEYS_INVIS, Kind.INVIS));
        if (takeFood.get()) tasks.add(new Task(KEYS_FOOD, Kind.FOOD));
    }

    private void resetTask() {
        taskChest = null; taskStart = 0; lastSlotId = -1; lastCount = -1; stuck = 0; nextUse = 0;
        aimBlockPos = null;
        resetWalk();
    }

    // ================= сундуки =================
    private boolean chestTask(MinecraftClient mc, ClientPlayerEntity p, Task t, long now) {
        if (taskStart == 0) taskStart = now;
        if (now - taskStart > 35000) {
            say("не вышло: " + t.kind());
            releaseAll(mc);
            if (mc.currentScreen instanceof GenericContainerScreen) p.closeHandledScreen();
            return true;
        }

        if (mc.currentScreen instanceof GenericContainerScreen gs) {
            stopMove(mc);
            if (now - lastAct < 110 + rnd(150)) return false;
            lastAct = now;
            boolean done = act(mc, p, gs, t.kind());
            if (done) { p.closeHandledScreen(); until = now + 250 + rnd(250); }
            return done;
        }

        if (taskChest == null) {
            stopMove(mc);
            if (now - chestScanAt > 600) {
                chestScanAt = now;
                taskChest = findChestBySign(mc, p, t.keys());
                resetWalk();
            }
            return false;
        }

        Vec3d c = Vec3d.ofCenter(taskChest);
        boolean there = goTo(mc, p, c.x, c.y, c.z, 3.2, true, now);
        if (moveBlocked) { taskChest = null; chestScanAt = now + 1500; return false; }
        if (!there) return false;

        BlockHitResult hit = aimBlock(mc, p, taskChest, now);
        if (hit == null || now < nextUse) return false;
        mc.interactionManager.interactBlock(p, Hand.MAIN_HAND, hit);
        p.swingHand(Hand.MAIN_HAND);
        nextUse = now + 800 + rnd(300);
        return false;
    }

    private boolean act(MinecraftClient mc, ClientPlayerEntity p, GenericContainerScreen gs, Kind kind) {
        List<Slot> slots = gs.getScreenHandler().slots;
        int sync = gs.getScreenHandler().syncId;

        if (kind == Kind.DEPOSIT) {
            for (Slot s : slots) {
                if (s.inventory != p.getInventory()) continue;
                if (!isLoot(s.getStack())) continue;
                int count = s.getStack().getCount();
                if (s.id == lastSlotId && count == lastCount && ++stuck >= 5) { say("сундук полон?"); return true; }
                if (s.id != lastSlotId || count != lastCount) stuck = 0;
                lastSlotId = s.id; lastCount = count;
                mc.interactionManager.clickSlot(sync, s.id, 0, SlotActionType.QUICK_MOVE, p);
                return false;
            }
            return true;
        }

        Predicate<ItemStack> want = switch (kind) {
            case SPEED -> AutoEnd::isSpeedPotion;
            case INVIS -> AutoEnd::isInvisPotion;
            default -> st -> !st.isEmpty() && st.contains(DataComponentTypes.FOOD);
        };
        for (Slot s : slots) {
            if (s.inventory == p.getInventory()) continue;
            if (!want.test(s.getStack())) continue;
            mc.interactionManager.clickSlot(sync, s.id, 0, SlotActionType.QUICK_MOVE, p);
            return true;
        }
        say("в сундуке пусто: " + kind);
        return true;
    }

    private BlockPos findChestBySign(MinecraftClient mc, ClientPlayerEntity p, List<String> keys) {
        List<SignInfo> signs = new ArrayList<>();
        List<BlockPos> chests = new ArrayList<>();
        int pcx = p.getBlockX() >> 4, pcz = p.getBlockZ() >> 4;

        for (int cx = pcx - 4; cx <= pcx + 4; cx++) {
            for (int cz = pcz - 4; cz <= pcz + 4; cz++) {
                WorldChunk ch = mc.world.getChunkManager().getWorldChunk(cx, cz);
                if (ch == null) continue;
                for (BlockEntity be : new ArrayList<>(ch.getBlockEntities().values())) {
                    if (be instanceof SignBlockEntity sbe) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < 4; i++) {
                            sb.append(sbe.getFrontText().getMessage(i, false).getString()).append(' ');
                            sb.append(sbe.getBackText().getMessage(i, false).getString()).append(' ');
                        }
                        signs.add(new SignInfo(be.getPos().toImmutable(), sb.toString()));
                    } else if (be instanceof ChestBlockEntity || be instanceof BarrelBlockEntity) {
                        chests.add(be.getPos().toImmutable());
                    }
                }
            }
        }
        if (signs.isEmpty() || chests.isEmpty()) return null;

        BlockPos best = null;
        double bd = Double.MAX_VALUE;
        for (SignInfo s : signs) {
            if (!matches(s.text(), keys)) continue;
            for (BlockPos c : chests) {
                double ds = distSq(c, s.pos());
                if (ds > 36) continue;
                boolean mine = true;
                for (SignInfo o : signs) {
                    if (o != s && distSq(c, o.pos()) < ds - 0.01) { mine = false; break; }
                }
                if (!mine) continue;
                double dp = distSq(c, p.getBlockPos());
                if (dp < bd) { bd = dp; best = c; }
            }
        }
        if (best != null) return best;

        for (SignInfo s : signs) {
            if (!matches(s.text(), keys)) continue;
            for (BlockPos c : chests) {
                double ds = distSq(c, s.pos());
                if (ds > 36) continue;
                if (ds < bd) { bd = ds; best = c; }
            }
        }
        return best;
    }

    private static boolean matches(String text, List<String> keys) {
        String n = text.toLowerCase(Locale.ROOT).replace('ё', 'е');
        for (String token : n.split("[^\\p{L}]+")) {
            if (token.isEmpty()) continue;
            for (String k : keys) if (token.startsWith(k)) return true;
        }
        return false;
    }

    private static double distSq(BlockPos a, BlockPos b) {
        double dx = a.getX() - b.getX(), dy = a.getY() - b.getY(), dz = a.getZ() - b.getZ();
        return dx * dx + dy * dy + dz * dz;
    }

    // ================= портал в Энд =================
    private void portalTick(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (inEnd(mc)) { releaseAll(mc); startLoot(now); phase = Phase.LOOT; return; }

        if (!tpDone) {
            double dx = p.getX() - tpFrom.x, dy = p.getY() - tpFrom.y, dz = p.getZ() - tpFrom.z;
            double moved = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (moved > 6 || now - waitStart > 9000) {
                tpDone = true;
                portalStart = now;
                resetWalk();
                until = now + 600 + rnd(500);
            }
            return;
        }

        if (now - portalStart > 45000) {
            releaseAll(mc);
            say("не нашёл портал в Энд, выключаюсь");
            setEnabled(false);
            return;
        }

        BlockPos portal = findNearest(mc, p, PORTAL_TEST, 6, null);
        if (portal == null) { stopMove(mc); return; }

        double px = portal.getX() + 0.5, pz = portal.getZ() + 0.5;
        double hd = Math.hypot(px - p.getX(), pz - p.getZ());

        if (!portalDirect) {
            boolean there = goTo(mc, p, px, portal.getY(), pz, 3.0, false, now);
            if (there || moveBlocked) portalDirect = true;
            return;
        }
        // последние метры: прямо в портал, прыжок в него
        walkDirect(mc, p, px, pz, 0.15, now, false);
        if (hd < 2.2 && p.isOnGround()) mc.options.jumpKey.setPressed(true);
    }

    // ================= лутание ваз =================
    private void startLoot(long now) {
        broken = 0;
        targetPot = null; pendingBreak = null; targetSand = null;
        sub = Sub.CENTER; subStart = now; lastProgress = now; scanAt = 0;
        skipped.clear(); skippedItems.clear();
        waypoints.clear(); wpIdx = 0; wpStart = now;
        chaseId = -1; brushing = false; aimBlockPos = null;
        resetWalk();
    }

    private void lootTick(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (!inEnd(mc)) { releaseAll(mc); phase = Phase.START; until = now + 1000; return; }

        boolean full = p.getInventory().getEmptySlot() == -1;
        if (broken >= maxVases.get() || full || now - lastProgress > 150000) {
            releaseAll(mc);
            say("разбито ваз: " + broken + (full ? " (инвентарь полон)" : ""));
            cmd(p, saveAn.get());
            beginSwitch(mc, now);
            phase = Phase.BACK_WAIT;
            return;
        }

        if (usingUntil == 0 && sub != Sub.SAND && drinkIfNeeded(mc, p, now)) return;

        switch (sub) {
            case CENTER -> {
                boolean arrived = goTo(mc, p, 0.5, p.getY(), 0.5, 3.5, false, now);
                if (arrived || moveBlocked || now - subStart > 60000) toSearch(mc, now);
            }
            case SEARCH -> searchTick(mc, p, now);
            case POT -> potTick(mc, p, now);
            case COLLECT -> collectTick(mc, p, now);
            case SAND -> sandTick(mc, p, now);
        }
    }

    private void toSearch(MinecraftClient mc, long now) {
        stopMove(mc);
        sub = Sub.SEARCH; subStart = now; scanAt = 0;
        resetWalk();
    }

    private void searchTick(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (now >= scanAt) {
            scanAt = now + 400 + rnd(250);

            if (useBrush.get() && hasBrush(p)) {
                BlockPos s = findNearest(mc, p, SAND_TEST, 7, pos -> !skipped.contains(pos));
                if (s != null) {
                    targetSand = s; sandStart = now; sub = Sub.SAND; resetWalk();
                    return;
                }
            }
            BlockPos pot = findNearest(mc, p, POT_TEST, 7, pos -> !skipped.contains(pos));
            if (pot != null) {
                targetPot = pot; potStart = now; hitAttempts = 0; pendingBreak = null; aimBlockPos = null;
                sub = Sub.POT; resetWalk();
                return;
            }
        }

        if (waypoints.isEmpty() || wpIdx >= waypoints.size()) {
            buildWaypoints();
            wpStart = now;
            resetWalk();
        }
        Vec3d w = waypoints.get(wpIdx);
        boolean arrived = goTo(mc, p, w.x, p.getY(), w.z, 3.5, false, now);
        if (arrived || moveBlocked || now - wpStart > 25000) {
            wpIdx++; wpStart = now; resetWalk();
        }
    }

    private void buildWaypoints() {
        waypoints.clear();
        wpIdx = 0;
        double a0 = rnd(360);
        for (int r = 16; r <= 100; r += 14) {
            int n = Math.max(6, (int) (2 * Math.PI * r / 18));
            for (int i = 0; i < n; i++) {
                double a = Math.toRadians(a0 + i * 360.0 / n);
                waypoints.add(new Vec3d(Math.cos(a) * r + rnd(7) - 3, 0, Math.sin(a) * r + rnd(7) - 3));
            }
        }
    }

    private void potTick(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (targetPot == null) { sub = Sub.SEARCH; return; }

        if (!mc.world.getBlockState(targetPot).isOf(Blocks.DECORATED_POT)) {
            boolean ours = pendingBreak != null && pendingBreak.equals(targetPot);
            targetPot = null; pendingBreak = null; aimBlockPos = null;
            stopMove(mc);
            if (ours) {
                broken++;
                lastProgress = now;
                sub = Sub.COLLECT;
                collectUntil = now + 700 + rnd(300);
                chaseId = -1;
                resetWalk();
            } else {
                sub = Sub.SEARCH; scanAt = 0;
            }
            return;
        }

        if (now - potStart > 25000 || hitAttempts > 10) {
            skipped.add(targetPot);
            targetPot = null; pendingBreak = null;
            toSearch(mc, now);
            return;
        }

        Vec3d c = Vec3d.ofCenter(targetPot);
        boolean there = goTo(mc, p, c.x, c.y, c.z, 3.3, true, now);
        if (moveBlocked) {
            skipped.add(targetPot);
            targetPot = null;
            toSearch(mc, now);
            return;
        }
        if (!there) { pendingBreak = null; return; }

        BlockHitResult hit = aimBlock(mc, p, targetPot, now);
        if (hit == null || now < nextHit) return;

        mc.interactionManager.attackBlock(targetPot, hit.getSide());
        p.swingHand(Hand.MAIN_HAND);
        pendingBreak = targetPot;
        hitAttempts++;
        nextHit = now + 300 + rnd(250);
    }

    private void collectTick(MinecraftClient mc, ClientPlayerEntity p, long now) {
        ItemEntity it = nearestWanted(mc, p);
        if (it != null) {
            lastProgress = now;
            if (chaseId != it.getId()) { chaseId = it.getId(); chaseStart = now; resetWalk(); }
            if (now - chaseStart > 7000) { skippedItems.add(it.getId()); chaseId = -1; return; }
            goTo(mc, p, it.getX(), it.getY(), it.getZ(), 0.6, false, now);
            if (moveBlocked) { skippedItems.add(it.getId()); chaseId = -1; }
            return;
        }
        stopMove(mc);
        if (now < collectUntil) return;
        toSearch(mc, now);
    }

    private void sandTick(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (targetSand == null) { endBrush(mc); toSearch(mc, now); return; }

        if (!SAND_TEST.test(mc.world.getBlockState(targetSand))) {
            endBrush(mc);
            targetSand = null; aimBlockPos = null;
            lastProgress = now;
            sub = Sub.COLLECT;
            collectUntil = now + 1100 + rnd(400);
            chaseId = -1;
            resetWalk();
            return;
        }

        if (!hasBrush(p) || now - sandStart > 30000) {
            endBrush(mc);
            skipped.add(targetSand);
            targetSand = null;
            toSearch(mc, now);
            return;
        }

        if (!holdBrush(mc, p, now)) { endBrush(mc); stopMove(mc); return; }

        Vec3d c = Vec3d.ofCenter(targetSand);
        boolean there = goTo(mc, p, c.x, c.y, c.z, 3.2, true, now);
        if (moveBlocked) {
            endBrush(mc);
            skipped.add(targetSand);
            targetSand = null;
            toSearch(mc, now);
            return;
        }
        if (!there) { endBrush(mc); return; }

        BlockHitResult hit = aimBlock(mc, p, targetSand, now);
        if (hit != null) { mc.options.useKey.setPressed(true); brushing = true; }
        else endBrush(mc);
    }

    private void endBrush(MinecraftClient mc) {
        if (brushing) mc.options.useKey.setPressed(false);
        brushing = false;
    }

    private static boolean hasBrush(ClientPlayerEntity p) {
        for (int i = 0; i < 36; i++) if (p.getInventory().getStack(i).isOf(Items.BRUSH)) return true;
        return false;
    }

    private boolean holdBrush(MinecraftClient mc, ClientPlayerEntity p, long now) {
        if (p.getMainHandStack().isOf(Items.BRUSH)) return true;

        int hb = findHotbar(p, s -> s.isOf(Items.BRUSH));
        if (hb >= 0) {
            p.getInventory().setSelectedSlot(hb);
            until = now + 120 + rnd(100);
            return false;
        }
        for (int i = 9; i < 36; i++) {
            if (!p.getInventory().getStack(i).isOf(Items.BRUSH)) continue;
            int hs = -1;
            for (int k = 0; k < 9; k++) if (p.getInventory().getStack(k).isEmpty()) { hs = k; break; }
            if (hs < 0) hs = 8;
            p.getInventory().setSelectedSlot(hs);
            mc.interactionManager.clickSlot(p.playerScreenHandler.syncId, InvUtil.handlerSlot(i), hs,
                    SlotActionType.SWAP, p);
            until = now + 250 + rnd(150);
            return false;
        }
        return false;
    }

    private ItemEntity nearestWanted(MinecraftClient mc, ClientPlayerEntity p) {
        List<ItemEntity> l = mc.world.getEntitiesByClass(ItemEntity.class,
                new Box(p.getBlockPos()).expand(10),
                e -> !skippedItems.contains(e.getId()) && wantItem(e.getStack()));
        ItemEntity best = null;
        double bd = Double.MAX_VALUE;
        for (ItemEntity e : l) {
            double d = e.squaredDistanceTo(p);
            if (d < bd) { bd = d; best = e; }
        }
        return best;
    }

    private BlockPos findNearest(MinecraftClient mc, ClientPlayerEntity p, Predicate<BlockState> test,
                                 int chunkRadius, Predicate<BlockPos> accept) {
        int pcx = p.getBlockX() >> 4, pcz = p.getBlockZ() >> 4;
        BlockPos best = null;
        double bd = Double.MAX_VALUE;
        BlockPos.Mutable m = new BlockPos.Mutable();

        for (int cx = pcx - chunkRadius; cx <= pcx + chunkRadius; cx++) {
            for (int cz = pcz - chunkRadius; cz <= pcz + chunkRadius; cz++) {
                WorldChunk ch = mc.world.getChunkManager().getWorldChunk(cx, cz);
                if (ch == null) continue;
                ChunkSection[] secs = ch.getSectionArray();
                int bottom = ch.getBottomSectionCoord();
                for (int i = 0; i < secs.length; i++) {
                    ChunkSection s = secs[i];
                    if (s == null || !s.hasAny(test)) continue;
                    int by = (bottom + i) << 4;
                    for (int x = 0; x < 16; x++) {
                        for (int y = 0; y < 16; y++) {
                            for (int z = 0; z < 16; z++) {
                                if (!test.test(s.getBlockState(x, y, z))) continue;
                                m.set((cx << 4) + x, by + y, (cz << 4) + z);
                                if (accept != null && !accept.test(m)) continue;
                                double dx = m.getX() + 0.5 - p.getX();
                                double dy = m.getY() + 0.5 - p.getY();
                                double dz = m.getZ() + 0.5 - p.getZ();
                                double d = dx * dx + dy * dy + dz * dz;
                                if (d < bd) { bd = d; best = m.toImmutable(); }
                            }
                        }
                    }
                }
            }
        }
        return best;
    }

    // ================= еда и зелья =================
    private boolean drinkIfNeeded(MinecraftClient mc, ClientPlayerEntity p, long now) {
        int slot = -1;
        if (takeSpeed.get() && !p.hasStatusEffect(StatusEffects.SPEED))
            slot = findHotbar(p, AutoEnd::isSpeedPotion);
        if (slot < 0 && takeInvis.get() && !p.hasStatusEffect(StatusEffects.INVISIBILITY))
            slot = findHotbar(p, AutoEnd::isInvisPotion);
        if (slot < 0 && p.getHungerManager().getFoodLevel() <= 14)
            slot = findHotbar(p, s -> s.contains(DataComponentTypes.FOOD));
        if (slot < 0) return false;

        stopMove(mc);
        p.getInventory().setSelectedSlot(slot);
        mc.options.useKey.setPressed(true);
        usingUntil = now + 1900;
        until = now + 1900;
        return true;
    }

    private static int findHotbar(ClientPlayerEntity p, Predicate<ItemStack> f) {
        for (int i = 0; i < 9; i++) {
            ItemStack s = p.getInventory().getStack(i);
            if (!s.isEmpty() && f.test(s)) return i;
        }
        return -1;
    }

    private static boolean hasEffect(ItemStack st, RegistryEntry<StatusEffect> eff) {
        if (st.isEmpty() || !st.isOf(Items.POTION)) return false;
        PotionContentsComponent c = st.get(DataComponentTypes.POTION_CONTENTS);
        if (c == null) return false;
        for (StatusEffectInstance e : c.getEffects()) if (e.getEffectType().equals(eff)) return true;
        return false;
    }

    private static boolean nameHas(ItemStack st, String... keys) {
        String n = st.getName().getString().toLowerCase(Locale.ROOT);
        for (String k : keys) if (n.contains(k)) return true;
        return false;
    }

    private static boolean isSpeedPotion(ItemStack st) {
        return hasEffect(st, StatusEffects.SPEED) || (st.isOf(Items.POTION) && nameHas(st, "скорост"));
    }

    private static boolean isInvisPotion(ItemStack st) {
        return hasEffect(st, StatusEffects.INVISIBILITY)
                || (st.isOf(Items.POTION) && nameHas(st, "невидим", "инвиз"));
    }

    // ================= взгляд =================
    private void aimAt(ClientPlayerEntity p, Vec3d t, boolean react) {
        Vec3d e = p.getEyePos();
        double dx = t.x - e.x, dy = t.y - e.y, dz = t.z - e.z;
        double h = Math.sqrt(dx * dx + dz * dz);
        float ny = (float) (Math.toDegrees(Math.atan2(dz, dx)) - 90.0);
        float np = MathHelper.clamp((float) -Math.toDegrees(Math.atan2(dy, h)), -89f, 89f);
        if (react && Math.abs(MathHelper.wrapDegrees(ny - p.getYaw())) > 25f
                && Math.abs(MathHelper.wrapDegrees(ny - tYaw)) > 8f) {
            lookFreezeUntil = System.currentTimeMillis() + 100 + rnd(180);   // «реакция» на новую цель
        }
        tYaw = ny;
        tPitch = np;
        lookActive = true;
    }

    private boolean aimed(ClientPlayerEntity p, float tol) {
        return Math.abs(MathHelper.wrapDegrees(tYaw - p.getYaw())) < tol
                && Math.abs(tPitch - p.getPitch()) < tol;
    }

    /**
     * Наводится на блок. Возвращает попадание, только когда прицел реально стоит на блоке
     * и продержался немного. Если блок закрыт, пробует другие точки на нём.
     */
    private BlockHitResult aimBlock(MinecraftClient mc, ClientPlayerEntity p, BlockPos pos, long now) {
        if (!pos.equals(aimBlockPos)) {
            aimBlockPos = pos.toImmutable();
            aimIdx = 0; aimIdxAt = now; aimSettleAt = 0;
        }
        double[] o = AIM[aimIdx];
        aimAt(p, new Vec3d(pos.getX() + 0.5 + o[0], pos.getY() + 0.5 + o[1], pos.getZ() + 0.5 + o[2]), true);

        if (mc.crosshairTarget instanceof BlockHitResult b
                && b.getType() == HitResult.Type.BLOCK && b.getBlockPos().equals(pos)) {
            if (aimSettleAt == 0L) aimSettleAt = now + 90 + rnd(170);
            if (now >= aimSettleAt) return b;
        } else {
            aimSettleAt = 0L;
            if (aimed(p, 2f) && now - aimIdxAt > 700) {
                aimIdx = (aimIdx + 1) % AIM.length;
                aimIdxAt = now;
            }
        }
        return null;
    }

    /**
     * Поворот как у мыши: критически демпфированная пружина (как SmoothDamp в Unity).
     * Скорость нарастает и спадает по плавной кривой: никаких рывков, дрожи и случайного шума.
     * Шаг по-прежнему кратен чувствительности мыши. Медленнее = меньше «Скорость взгляда».
     */
    private void smoothLook(MinecraftClient mc, ClientPlayerEntity p, long now) {
        final float dt = 0.05f;                              // один тик
        float errY = MathHelper.wrapDegrees(tYaw - p.getYaw());
        float errP = tPitch - p.getPitch();

        float stepY, stepP;
        if (now < lookFreezeUntil) {
            // «реакция» на новую цель: не обрываем движение, а плавно гасим скорость
            yawVel *= 0.8f;
            pitchVel *= 0.8f;
            stepY = yawVel * dt;
            stepP = pitchVel * dt;
        } else {
            float maxY = lookSpeed.get();                    // потолок, °/тик
            float maxP = maxY * 0.6f;

            float[] ry = damp(errY, yawVel, 0.42f, dt);
            float[] rp = damp(errP, pitchVel, 0.55f, dt);

            stepY = MathHelper.clamp(ry[0], -maxY, maxY);
            stepP = MathHelper.clamp(rp[0], -maxP, maxP);
            yawVel = (stepY != ry[0]) ? stepY / dt : ry[1];
            pitchVel = (stepP != rp[0]) ? stepP / dt : rp[1];
        }

        accY += stepY;
        accP += stepP;

        double f = mc.options.getMouseSensitivity().getValue() * 0.6 + 0.2;
        double gcd = f * f * f * 8.0 * 0.15;
        float oy, op;
        if (gcd > 1e-4) {
            double sy = Math.rint(accY / gcd) * gcd;
            double sp = Math.rint(accP / gcd) * gcd;
            accY -= (float) sy; accP -= (float) sp;
            oy = (float) sy; op = (float) sp;
        } else {
            oy = accY; op = accP; accY = 0f; accP = 0f;
        }
        p.setYaw(p.getYaw() + oy);
        p.setPitch(MathHelper.clamp(p.getPitch() + op, -90f, 90f));
    }

    /** Один шаг SmoothDamp: возвращает {шаг за тик, новая скорость (°/с)}. */
    private static float[] damp(float err, float vel, float smoothTime, float dt) {
        float omega = 2f / smoothTime;
        float x = omega * dt;
        float exp = 1f / (1f + x + 0.48f * x * x + 0.235f * x * x * x);
        float change = -err;
        float temp = (vel + omega * change) * dt;
        float newVel = (vel - omega * temp) * exp;
        float step = err + (change + temp) * exp;
        return new float[]{step, newVel};
    }

    // ================= поиск пути =================
    private static final class PNode {
        final int x, y, z;
        double g, f;
        PNode parent;
        PNode(int x, int y, int z) { this.x = x; this.y = y; this.z = z; }
    }

    private boolean passable(ClientWorld w, int x, int y, int z) {
        mp.set(x, y, z);
        BlockState s = w.getBlockState(mp);
        if (!s.getFluidState().isEmpty()) return false;
        if (s.isOf(Blocks.FIRE) || s.isOf(Blocks.SOUL_FIRE) || s.isOf(Blocks.COBWEB)
                || s.isOf(Blocks.END_PORTAL) || s.isOf(Blocks.END_GATEWAY)) return false;
        return s.getCollisionShape(w, mp).isEmpty();
    }

    private boolean floorOk(ClientWorld w, int x, int y, int z) {
        mp.set(x, y, z);
        BlockState s = w.getBlockState(mp);
        if (!s.getFluidState().isEmpty()) return false;
        if (s.isOf(Blocks.MAGMA_BLOCK) || s.isOf(Blocks.CACTUS)) return false;
        VoxelShape sh = s.getCollisionShape(w, mp);
        return !sh.isEmpty() && sh.getMax(Direction.Axis.Y) <= 1.0;
    }

    private boolean standable(ClientWorld w, int x, int y, int z) {
        return passable(w, x, y, z) && passable(w, x, y + 1, z) && floorOk(w, x, y - 1, z);
    }

    private double hVal(int x, int y, int z) {
        double ex = x + 0.5 - gTx, ez = z + 0.5 - gTz;
        if (gThree) {
            double ey = y + 1.62 - gTy;
            return Math.max(0, Math.sqrt(ex * ex + ey * ey + ez * ez) - gR);
        }
        return Math.max(0, Math.hypot(ex, ez) - gR);
    }

    private void plan(MinecraftClient mc, ClientPlayerEntity p) {
        path.clear();
        pathIdx = 0;
        jitterIdx = -1;
        ClientWorld w = mc.world;

        PNode start = new PNode(p.getBlockX(), p.getBlockY(), p.getBlockZ());
        start.f = hVal(start.x, start.y, start.z);

        PriorityQueue<PNode> open = new PriorityQueue<>(Comparator.comparingDouble((PNode n) -> n.f));
        Map<Long, PNode> best = new HashMap<>();
        Set<Long> closed = new HashSet<>();
        open.add(start);
        best.put(BlockPos.asLong(start.x, start.y, start.z), start);

        PNode bestH = start;
        double bestHv = hVal(start.x, start.y, start.z);
        PNode goal = null;
        int expanded = 0;
        final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int[] dys = {0, 1, -1, -2, -3};

        while (!open.isEmpty() && expanded < 5000) {
            PNode n = open.poll();
            if (!closed.add(BlockPos.asLong(n.x, n.y, n.z))) continue;
            expanded++;

            double hv = hVal(n.x, n.y, n.z);
            if (hv <= 0) { goal = n; break; }
            if (hv < bestHv) { bestHv = hv; bestH = n; }

            for (int[] d : dirs) {
                int nx = n.x + d[0], nz = n.z + d[1];
                for (int dy : dys) {
                    int ny = n.y + dy;
                    if (!standable(w, nx, ny, nz)) continue;
                    if (dy == 1 && !passable(w, n.x, n.y + 2, n.z)) continue;
                    if (dy < 0) {
                        boolean ok = true;
                        for (int yy = ny + 2; yy <= n.y + 1; yy++) {
                            if (!passable(w, nx, yy, nz)) { ok = false; break; }
                        }
                        if (!ok) continue;
                    }
                    long k = BlockPos.asLong(nx, ny, nz);
                    if (!closed.contains(k)) {
                        double g = n.g + 1.0 + (dy != 0 ? 0.6 : 0.0);
                        PNode ex = best.get(k);
                        if (ex == null || g < ex.g) {
                            PNode nn = new PNode(nx, ny, nz);
                            nn.g = g;
                            nn.parent = n;
                            nn.f = g + hVal(nx, ny, nz) * 1.3;
                            best.put(k, nn);
                            open.add(nn);
                        }
                    }
                    break;
                }
            }
        }

        PNode end = goal != null ? goal : bestH;
        if (end == start) {
            if (bestHv <= 0) path.add(new BlockPos(start.x, start.y, start.z));
            return;
        }
        for (PNode n = end; n != null && n != start; n = n.parent) path.add(new BlockPos(n.x, n.y, n.z));
        Collections.reverse(path);
    }

    private static boolean reached(ClientPlayerEntity p, double tx, double ty, double tz, double r, boolean three) {
        if (three) return p.getEyePos().distanceTo(new Vec3d(tx, ty, tz)) <= r;
        return Math.hypot(tx - p.getX(), tz - p.getZ()) <= r;
    }

    /**
     * Идёт к цели по найденному пути. true = дошёл.
     * moveBlocked = true, если пути нет или застрял несколько раз подряд.
     *
     * Ходит «по-человечески»: курс слегка рыскает, узлы пути проходятся не по центру блока,
     * иногда взгляд уходит в сторону, бывают короткие шаги влево/вправо, прыжки на ходу
     * и участки без спринта.
     */
    private boolean goTo(MinecraftClient mc, ClientPlayerEntity p, double tx, double ty, double tz,
                         double r, boolean three, long now) {
        moveBlocked = false;
        if (reached(p, tx, ty, tz, r, three)) {
            stopMove(mc);
            path.clear(); pathIdx = 0; goalSet = false;
            return true;
        }

        boolean same = goalSet && Math.abs(tx - gTx) < 0.6 && Math.abs(ty - gTy) < 0.6
                && Math.abs(tz - gTz) < 0.6 && r == gR && three == gThree;
        if (!same) {
            gTx = tx; gTy = ty; gTz = tz; gR = r; gThree = three;
            goalSet = true;
            path.clear(); pathIdx = 0;
            nextPlan = 0L; replans = 0; failPlans = 0;
        }

        if (pathIdx >= path.size()) {
            if (now < nextPlan) { stopMove(mc); return false; }
            nextPlan = now + 300;
            plan(mc, p);
            if (path.isEmpty()) {
                stopMove(mc);
                if (++failPlans >= 2) { failPlans = 0; moveBlocked = true; }
                return false;
            }
            failPlans = 0;
        }

        // пропускаем достигнутые узлы
        for (int guard = 0; guard < 3 && pathIdx < path.size(); guard++) {
            BlockPos n = path.get(pathIdx);
            double hd = Math.hypot(n.getX() + 0.5 - p.getX(), n.getZ() + 0.5 - p.getZ());
            if (hd < 0.45 && Math.abs(n.getY() - p.getY()) < 1.4) { pathIdx++; replans = 0; }
            else break;
        }
        if (pathIdx >= path.size()) return false;

        BlockPos n = path.get(pathIdx);

        // каждый узел проходим с небольшим случайным смещением внутри блока, а не по центру
        if (pathIdx != jitterIdx) {
            jitterIdx = pathIdx;
            jitX = (rnd(500) - 250) / 1000.0;   // ±0.25 блока
            jitZ = (rnd(500) - 250) / 1000.0;
        }
        double cx = n.getX() + 0.5 + jitX, cz = n.getZ() + 0.5 + jitZ;
        double hd = Math.hypot(cx - p.getX(), cz - p.getZ());

        // чуть смотрим вперёд по пути, чтобы повороты были плавными
        double ax = cx, az = cz;
        if (hd < 1.0 && pathIdx + 1 < path.size()) {
            BlockPos nx = path.get(pathIdx + 1);
            ax = (cx + nx.getX() + 0.5) / 2.0;
            az = (cz + nx.getZ() + 0.5) / 2.0;
        }

        // «далеко» = не у цели и не у поворота: только тогда добавляем человеческие огрехи
        double goalDist = Math.hypot(gTx - p.getX(), gTz - p.getZ());
        boolean far = goalDist > gR + 4.0 && hd > 0.8;

        // плавное рыскание курса (до ±8°) и лёгкий дрейф по высоте взгляда
        if (far) {
            if (now >= nextWobble) {
                wobbleGoal = (float) ((rnd(2001) - 1000) / 1000.0 * (3 + rnd(6)));
                wobblePGoal = (float) ((rnd(2001) - 1000) / 1000.0 * 3.0);
                nextWobble = now + 700 + rnd(1800);
            }
            wobble += (wobbleGoal - wobble) * 0.05f;
            wobbleP += (wobblePGoal - wobbleP) * 0.05f;
            if (p.horizontalCollision) wobble *= 0.5f;

            // изредка быстрый взгляд в сторону
            if (nextGlance == 0L) nextGlance = now + 2500 + rnd(4000);
            if (now >= nextGlance) {
                glanceYaw = (rnd(2) == 0 ? -1 : 1) * (4 + rnd(6));
                glancePitch = (float) ((rnd(2001) - 1000) / 1000.0 * 4.0);
                glanceUntil = now + 500 + rnd(600);
                nextGlance = now + 3500 + rnd(6500);
            }
        } else {
            wobble *= 0.8f;
            wobbleP *= 0.8f;
        }
        boolean glancing = far && now < glanceUntil;

        tYaw = (float) (Math.toDegrees(Math.atan2(az - p.getZ(), ax - p.getX())) - 90.0)
                + wobble + (glancing ? glanceYaw : 0f);
        tPitch = 6f + wobbleP + (glancing ? glancePitch : 0f);
        lookActive = true;

        float diff = Math.abs(MathHelper.wrapDegrees(tYaw - p.getYaw()));
        boolean go = diff < 40f;

        if (chkAt == 0L) { chkAt = now; chkX = p.getX(); chkZ = p.getZ(); }
        if (now - chkAt > 1200) {
            double moved = Math.hypot(p.getX() - chkX, p.getZ() - chkZ);
            if (go && moved < 0.3) {
                stuckCount++;
                strafeUntil = now + 350 + rnd(250);
                strafeDir = rnd(2) == 0 ? -1 : 1;
                if (stuckCount >= 3) {
                    stuckCount = 0;
                    path.clear(); pathIdx = 0;          // перепланировать с этого места
                    nextPlan = now + 150;
                    if (++replans >= 3) { replans = 0; stopMove(mc); moveBlocked = true; chkAt = 0L; return false; }
                }
            } else if (moved >= 0.3) {
                stuckCount = 0;
            }
            chkAt = now; chkX = p.getX(); chkZ = p.getZ();
        }

        boolean strafing = now < strafeUntil;

        // короткие шаги в сторону на ходу
        if (nextMicro == 0L) nextMicro = now + 1500 + rnd(3500);
        if (far && go && !strafing && now >= nextMicro) {
            microDir = rnd(2) == 0 ? -1 : 1;
            microUntil = now + 160 + rnd(300);
            nextMicro = now + 2500 + rnd(5500);
        }
        boolean micro = now < microUntil;

        // прыжок по ходу дела; иногда два-три подряд
        if (nextHop == 0L) nextHop = now + 1200 + rnd(3500);
        boolean hop = false;
        if (far && go && p.isOnGround() && !p.horizontalCollision && now >= nextHop) {
            hop = true;
            nextHop = rnd(4) == 0 ? now + 350 + rnd(200) : now + 1800 + rnd(5200);
        }

        // иногда на короткое время идём без спринта
        if (nextSlow == 0L) nextSlow = now + 6000 + rnd(9000);
        if (far && now >= nextSlow) {
            slowUntil = now + 300 + rnd(900);
            nextSlow = now + 9000 + rnd(14000);
        }
        boolean slow = now < slowUntil;

        boolean up = n.getY() - Math.floor(p.getY() + 0.01) >= 1;
        boolean sprint = go && diff < 12f && !slow && p.getHungerManager().getFoodLevel() > 6;
        mc.options.forwardKey.setPressed(go);
        mc.options.sprintKey.setPressed(sprint);
        mc.options.leftKey.setPressed((strafing && strafeDir < 0) || (micro && microDir < 0));
        mc.options.rightKey.setPressed((strafing && strafeDir > 0) || (micro && microDir > 0));
        mc.options.jumpKey.setPressed(go && p.isOnGround()
                && (hop || (up && hd < 1.6) || p.horizontalCollision));
        return false;
    }

    // ================= прямая ходьба (последние метры к порталу) =================
    private void walkDirect(MinecraftClient mc, ClientPlayerEntity p, double tx, double tz,
                            double stopDist, long now, boolean checkVoid) {
        double dx = tx - p.getX(), dz = tz - p.getZ();
        double dist = Math.sqrt(dx * dx + dz * dz);
        if (dist < stopDist) { stopMove(mc); return; }

        tYaw = (float) (Math.toDegrees(Math.atan2(dz, dx)) - 90.0);
        tPitch = 8f;
        lookActive = true;
        float diff = Math.abs(MathHelper.wrapDegrees(tYaw - p.getYaw()));
        boolean go = diff < 35f;
        mc.options.forwardKey.setPressed(go);
        mc.options.sprintKey.setPressed(false);
        mc.options.jumpKey.setPressed(go && p.isOnGround() && p.horizontalCollision);
    }

    private void resetWalk() {
        chkAt = 0L; stuckCount = 0; strafeUntil = 0L; moveBlocked = false;
        path.clear(); pathIdx = 0; goalSet = false; failPlans = 0; replans = 0; nextPlan = 0L;
        jitterIdx = -1;
    }

    private void stopMove(MinecraftClient mc) {
        mc.options.forwardKey.setPressed(false);
        mc.options.sprintKey.setPressed(false);
        mc.options.jumpKey.setPressed(false);
        mc.options.leftKey.setPressed(false);
        mc.options.rightKey.setPressed(false);
    }

    private void releaseAll(MinecraftClient mc) {
        stopMove(mc);
        mc.options.useKey.setPressed(false);
        brushing = false;
        usingUntil = 0;
    }

    // ================= утилиты =================
    private static boolean inEnd(MinecraftClient mc) {
        return mc.world != null && mc.world.getRegistryKey() == World.END;
    }

    private static void cmd(ClientPlayerEntity p, String raw) {
        if (raw == null) return;
        String s = raw.trim();
        if (s.startsWith("/")) s = s.substring(1);
        if (!s.isEmpty()) p.networkHandler.sendChatCommand(s);
    }

    private static int rnd(int bound) { return ThreadLocalRandom.current().nextInt(bound); }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        yawVel = pitchVel = accY = accP = 0f;
        lookActive = false;
        wobble = wobbleGoal = wobbleP = wobblePGoal = 0f;
        if (v) {
            phase = Phase.START;
            until = 0;
            targetPot = null; pendingBreak = null; targetSand = null;
            resetTask();
        }
    }

    private static void say(String msg) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) mc.player.sendMessage(Text.literal("§7[AutoEnd] §f" + msg), false);
    }
}