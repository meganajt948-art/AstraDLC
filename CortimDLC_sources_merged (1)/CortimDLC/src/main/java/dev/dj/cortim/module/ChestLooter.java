package dev.dj.cortim.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.dj.cortim.Cortim;
import dev.dj.cortim.gui.ItemPickerScreen;
import dev.dj.cortim.gui.ItemSelector;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ChestLooter extends Module implements ItemSelector {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("cortim_chestlooter.json");

    /** Позиции сундуков, которые уже обобрали (для будущей отрисовки меток). */
    public static final Set<BlockPos> MARKED = new HashSet<>();

    private final Set<String> selected = new LinkedHashSet<>();
    private Set<Item> wanted = new HashSet<>();

    private final ButtonSetting itemsBtn = add(new ButtonSetting("Предметы",
            "Выбрать предметы, которые лутать", this::openPicker) {
        @Override public String display() { return selected.size() + " шт."; }
    });

    private final KeySetting lootKey = add(new KeySetting("Кнопка",
            "Кнопка запуска автолута в открытом сундуке", GLFW.GLFW_KEY_G) {
        @Override public String display() {
            int k = get();
            if (k < 0) return "Нет";
            String n = GLFW.glfwGetKeyName(k, 0);
            return n != null ? n.toUpperCase() : Integer.toString(k);
        }
    });

    private final IntSetting delay = add(new IntSetting("Задержка",
            "Пауза между предметами", 85, 0, 500) {
        @Override public String display() { return get() + " мс"; }
    });

    private final BoolSetting closeChest = add(new BoolSetting("Закрывать сундук",
            "Закрыть сундук, когда всё забрано", true));
    private final BoolSetting markChests = add(new BoolSetting("Отмечать сундуки",
            "Запоминать обобранные сундуки", true));
    private final BoolSetting notify = add(new BoolSetting("Уведомления",
            "Писать результат в чат", true));

    private final ButtonSetting clearMarks = add(new ButtonSetting("Снять отметки",
            "Забыть все отмеченные сундуки", () -> {
        MARKED.clear();
        ChestLooter.say("отметки сняты");
    }));

    // состояние
    private boolean wasChest = false;
    private boolean lastDown = false;
    private boolean looting = false;
    private BlockPos chestPos = null;
    private long lastAct = 0L;
    private int taken = 0;
    private int lastSlotId = -1;
    private int lastCount = -1;
    private int stuck = 0;

    public ChestLooter() {
        super("ChestLooter", Category.PLAYER);
        loadItems();
    }

    // ---------------- выбор предметов ----------------
    @Override
    public Set<String> getSelected() { return selected; }

    @Override
    public void toggleItem(String id) {
        if (!selected.remove(id)) selected.add(id);
        rebuild();
        saveItems();
    }

    @Override
    public void clearItems() {
        selected.clear();
        rebuild();
        saveItems();
    }

    private void openPicker() {
        MinecraftClient mc = MinecraftClient.getInstance();
        mc.setScreen(new ItemPickerScreen(this, mc.currentScreen));
    }

    private void rebuild() {
        Set<Item> set = new HashSet<>();
        for (String id : selected) {
            Identifier ident = Identifier.tryParse(id);
            if (ident != null && Registries.ITEM.containsId(ident)) set.add(Registries.ITEM.get(ident));
        }
        wanted = set;
    }

    private void saveItems() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(new LinkedHashSet<>(selected)));
        } catch (IOException e) {
            Cortim.LOG.warn("chestlooter save failed", e);
        }
    }

    private void loadItems() {
        try {
            if (Files.exists(FILE)) {
                Set<String> s = GSON.fromJson(Files.readString(FILE), new TypeToken<LinkedHashSet<String>>(){}.getType());
                if (s != null) selected.addAll(s);
            }
        } catch (Exception e) {
            Cortim.LOG.warn("chestlooter load failed", e);
        }
        rebuild();
    }

    // ---------------- логика ----------------
    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity p = mc.player;
        if (!isEnabled() || p == null || mc.interactionManager == null) { looting = false; wasChest = false; return; }

        boolean chest = mc.currentScreen instanceof GenericContainerScreen;

        if (chest && !wasChest) {
            chestPos = mc.crosshairTarget instanceof BlockHitResult b ? b.getBlockPos() : null;
            looting = false;
            taken = 0;
            lastSlotId = -1;
            stuck = 0;
        }
        if (!chest) { looting = false; wasChest = false; lastDown = false; return; }
        wasChest = true;

        GenericContainerScreen screen = (GenericContainerScreen) mc.currentScreen;

        boolean down = lootKey.isDown();
        if (down && !lastDown) {
            looting = !looting;
            taken = 0;
            lastSlotId = -1;
            stuck = 0;
            if (looting && wanted.isEmpty()) {
                say("не выбраны предметы");
                looting = false;
            }
        }
        lastDown = down;
        if (!looting) return;

        long now = System.currentTimeMillis();
        if (now - lastAct < delay.get()) return;

        Slot target = null;
        List<Slot> slots = screen.getScreenHandler().slots;
        for (Slot s : slots) {
            if (s.inventory == p.getInventory()) continue;
            ItemStack st = s.getStack();
            if (!st.isEmpty() && wanted.contains(st.getItem())) { target = s; break; }
        }

        if (target == null) { finish(p, "забрано предметов: " + taken); return; }

        int count = target.getStack().getCount();
        if (target.id == lastSlotId && count == lastCount) {
            if (++stuck >= 6) { finish(p, "инвентарь полон или клик не прошёл"); return; }
        } else {
            stuck = 0;
        }
        lastSlotId = target.id;
        lastCount = count;

        mc.interactionManager.clickSlot(screen.getScreenHandler().syncId, target.id, 0,
                SlotActionType.QUICK_MOVE, p);
        taken++;
        lastAct = now;
    }

    private void finish(ClientPlayerEntity p, String msg) {
        looting = false;
        if (markChests.get() && chestPos != null) MARKED.add(chestPos);
        if (notify.get()) say(msg);
        if (closeChest.get()) p.closeHandledScreen();
    }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        if (!v) looting = false;
    }

    private static void say(String msg) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) mc.player.sendMessage(Text.literal("§7[ChestLooter] §f" + msg), false);
    }
}