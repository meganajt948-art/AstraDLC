package dev.dj.cortim.render;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.dj.cortim.Cortim;
import dev.dj.cortim.CortimConfig;
import dev.dj.cortim.gui.CortimScreen;
import dev.dj.cortim.gui.Lang;
import dev.dj.cortim.module.Hud;
import dev.dj.cortim.module.ModuleRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CortimHud {

    private static final Identifier HUD_ID = Identifier.of("cortim", "hud");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("cortim_hud.json");

    // эти поля используются внешним кодом перетаскивания — не удалять
    public static String draggingName = null;
    public static int dragOffsetX = 0;
    public static int dragOffsetY = 0;

    private static final int PAD = 10;
    private static final int GLASS = 0xB00B0B0F;
    private static final int EDGE = 0x4DFFFFFF;
    private static final int C_TEXT = 0xFFF2F2F5;
    private static final int C_DIM = 0xFF92929C;
    private static final int CORNER = 9;

    // ---------------------------------------------------------------
    // Геометрия панелей (запоминается при отрисовке, нужна для мыши)
    // ---------------------------------------------------------------

    private static final class Rect {
        final float x, y, w, h, bw, bh, scale;
        final boolean centered;

        Rect(float x, float y, float w, float h, float bw, float bh, float scale, boolean centered) {
            this.x = x; this.y = y; this.w = w; this.h = h;
            this.bw = bw; this.bh = bh; this.scale = scale; this.centered = centered;
        }

        boolean contains(double mx, double my) {
            return mx >= x && mx <= x + w && my >= y && my <= y + h;
        }
    }

    private static final Map<String, Rect> RECTS = new LinkedHashMap<>();

    // сглаженное положение панелей: {x, y, scale}
    private static final Map<String, float[]> SMOOTH = new HashMap<>();
    private static long lastNs = 0;

    // true, пока открыт чат: показываем ВСЕ включённые панели (с примером данных), чтобы их можно было расставить
    private static boolean edit = false;
    private static float frameDt = 0.016f;

    private static boolean loaded = false;
    private static boolean dirty = false;
    private static boolean wasDragging = false;
    private static boolean prevDown = false;

    private static String resizeName = null;
    private static int resizeCorner = -1;
    private static float resFixedX, resFixedY;

    public static void register() {
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                HUD_ID,
                (context, tickCounter) -> render(context)
        );
    }

    // ---------------------------------------------------------------
    // Основной рендер
    // ---------------------------------------------------------------

    private static void render(DrawContext ctx) {
        RECTS.clear();

        long nowNs = System.nanoTime();
        frameDt = lastNs == 0 ? 0.016f : Math.min(0.1f, (nowNs - lastNs) / 1_000_000_000f);
        lastNs = nowNs;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.currentScreen instanceof CortimScreen) return;
        if (!CortimConfig.hudEnabled || CortimConfig.isPanic()) return;
        if (client.player == null || client.options.hudHidden) return;

        Hud hud = (Hud) ModuleRegistry.byName("Hud");
        if (hud == null || !hud.isEnabled()) return;

        edit = client.currentScreen instanceof ChatScreen;

        ensureLoaded();
        Hud.updateBps(client);

        int sw = client.getWindow().getScaledWidth();
        int sh = client.getWindow().getScaledHeight();

        if (hud.showWatermark()) drawWatermark(ctx, client, hud, sw, sh);
        if (hud.showTarget())    drawTarget(ctx, client, sw, sh);
        if (hud.showKeybinds())  drawKeybinds(ctx, client, hud, sw, sh);
        if (hud.showStaff())     drawStaff(ctx, client, hud, sw, sh);
        if (hud.showCooldowns()) drawCooldowns(ctx, client, sw, sh);
        if (hud.showPotions())   drawPotions(ctx, client, sw, sh);
        if (hud.showItems())     drawItems(ctx, client, sw, sh);
        if (hud.showArmor())     drawArmor(ctx, client, sw, sh);

        handleMouse(ctx, client, sw, sh);
    }

    // ---------------------------------------------------------------
    // Общие помощники
    // ---------------------------------------------------------------

    private static void begin(DrawContext ctx, String name, int sw, int sh, int w, int h,
                              boolean centered, float defX, float defY) {
        float tScale = Hud.HUD_SCALE.getOrDefault(name, 1.0f);
        float[] pos = Hud.HUD_POS.computeIfAbsent(name, k -> new float[]{defX, defY});

        float tx = pos[0] * sw;
        float ty = pos[1] * sh;

        // плавное движение к целевой позиции (не зависит от FPS)
        float[] s = SMOOTH.computeIfAbsent(name, k -> new float[]{tx, ty, tScale});
        float a = name.equals(resizeName) ? 1f : 1f - (float) Math.exp(-frameDt * 22f);
        s[0] += (tx - s[0]) * a;
        s[1] += (ty - s[1]) * a;
        s[2] += (tScale - s[2]) * a;

        boolean moving = Math.abs(tx - s[0]) > 0.25f || Math.abs(ty - s[1]) > 0.25f
                || Math.abs(tScale - s[2]) > 0.002f;
        if (!moving) {
            s[0] = tx;
            s[1] = ty;
            s[2] = tScale;
        }

        float scale = s[2];
        float ax = moving ? s[0] : Math.round(tx);
        float ay = moving ? s[1] : Math.round(ty);
        float x0 = centered ? ax - w * scale / 2f : ax;
        float y0 = ay;
        if (!moving && centered) x0 = Math.round(x0);

        RECTS.put(name, new Rect(x0, y0, w * scale, h * scale, w, h, scale, centered));

        Matrix3x2fStack m = ctx.getMatrices();
        m.pushMatrix();
        m.translate(x0, y0);
        m.scale(scale, scale);
    }

    private static void end(DrawContext ctx) {
        ctx.getMatrices().popMatrix();
    }

    private static void glass(DrawContext ctx, int w, int h, int r) {
        RenderUtils.drawSmoothRoundedRect(ctx, 0, 0, w, h, r, GLASS);
        RenderUtils.drawRoundedBorder(ctx, 0, 0, w, h, r, 1f, EDGE, EDGE);
    }

    private static void text(DrawContext ctx, String s, int x, int y, int color) {
        CortimFont.draw(ctx, s, x, y, color);
    }

    private static String tr(String en, String ru) {
        return Lang.ru() ? ru : en;
    }

    private interface RowPainter {
        void paint(DrawContext ctx, int x, int y, int w);
    }

    private record Row(int minW, int h, RowPainter painter) {}

    /** Панель со списком строк. Пустой список — панель не рисуется вообще. */
    private static void drawList(DrawContext ctx, String name, int sw, int sh,
                                 float defX, float defY, String title, List<Row> rows) {
        if (rows.isEmpty()) return;

        int inner = CortimFont.width(title);
        int rowsH = 0;
        for (Row r : rows) {
            inner = Math.max(inner, r.minW());
            rowsH += r.h();
        }
        inner = Math.max(inner, 96);

        int w = inner + PAD * 2;
        int h = 26 + rowsH + 6;

        begin(ctx, name, sw, sh, w, h, false, defX, defY);
        glass(ctx, w, h, 12);

        text(ctx, title, PAD, 8, C_DIM);
        ctx.fill(PAD, 21, w - PAD, 22, 0x22FFFFFF);

        int y = 26;
        for (Row r : rows) {
            r.painter().paint(ctx, PAD, y, inner);
            y += r.h();
        }
        end(ctx);
    }

    private static int healthColor(float f) {
        return f > 0.6f ? 0xFF7BFF7B : f > 0.3f ? 0xFFFFB03B : 0xFFFF5C5C;
    }

    private static String fmtTicks(int ticks) {
        int s = Math.max(0, ticks / 20);
        return (s / 60) + ":" + String.format(Locale.ROOT, "%02d", s % 60);
    }

    private static String roman(int n) {
        String[] r = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return n >= 0 && n < r.length ? r[n] : String.valueOf(n);
    }

    // ---------------------------------------------------------------
    // Watermark
    // ---------------------------------------------------------------

    private static void drawWatermark(DrawContext ctx, MinecraftClient client, Hud hud, int sw, int sh) {
        String s = "✦ " + hud.watermarkText(client);
        int w = CortimFont.widthMixed(s) + 24;
        int h = 22;

        begin(ctx, "watermark", sw, sh, w, h, true, 0.5f, 0.03f);
        glass(ctx, w, h, 11);
        CortimFont.drawMixed(ctx, s, 12, 7, C_TEXT, true);
        end(ctx);
    }

    // ---------------------------------------------------------------
    // Keybinds / Staff
    // ---------------------------------------------------------------

    private static void drawKeybinds(DrawContext ctx, MinecraftClient client, Hud hud, int sw, int sh) {
        List<Row> rows = new ArrayList<>();
        List<String[]> entries = hud.bindEntries(client);
        if (entries.isEmpty() && edit) {
            entries = List.of(new String[]{"TriggerBot", "R"}, new String[]{"AimAssist", "G"});
        }
        for (String[] e : entries) {
            String nm = e[0];
            String key = e[1];
            int chipW = CortimFont.width(key) + 10;
            int minW = 10 + CortimFont.width(nm) + 14 + chipW;

            rows.add(new Row(minW, 17, (c, x, y, w) -> {
                RenderUtils.drawSmoothRoundedRect(c, x, y + 5, 5, 5, 2f, 0xFFE7E7EA);
                text(c, nm, x + 10, y + 3, C_TEXT);
                RenderUtils.drawSmoothRoundedRect(c, x + w - chipW, y + 1, chipW, 14, 7f, 0x33FFFFFF);
                text(c, key, x + w - chipW + 5, y + 4, 0xFFD8D8DE);
            }));
        }
        drawList(ctx, "keybinds", sw, sh, 0.16f, 0.30f, tr("Keybinds", "Бинды"), rows);
    }

    private static void drawStaff(DrawContext ctx, MinecraftClient client, Hud hud, int sw, int sh) {
        List<Row> rows = new ArrayList<>();
        List<String> staff = hud.staffLines(client);
        if (staff.isEmpty() && edit) staff = List.of("Admin Steve", "Moder Alex");
        for (String line : staff) {
            rows.add(new Row(CortimFont.width(line), 13, (c, x, y, w) -> text(c, line, x, y + 2, C_TEXT)));
        }
        drawList(ctx, "staff", sw, sh, 0.78f, 0.06f, tr("Staff", "Персонал"), rows);
    }

    // ---------------------------------------------------------------
    // Potions
    // ---------------------------------------------------------------

    private static final Map<Object, Integer> POTION_MAX = new HashMap<>();

    private static void drawPotions(DrawContext ctx, MinecraftClient client, int sw, int sh) {
        List<Row> rows = new ArrayList<>();
        Set<Object> alive = new HashSet<>();

        for (StatusEffectInstance e : client.player.getStatusEffects()) {
            Object key = e.getEffectType();
            alive.add(key);

            int dur = e.getDuration();
            int max = POTION_MAX.merge(key, dur, Math::max);
            boolean inf = e.isInfinite();
            float frac = inf ? 1f : Math.max(0f, Math.min(1f, max <= 0 ? 0f : (float) dur / max));

            String nm = Text.translatable(e.getTranslationKey()).getString();
            int amp = e.getAmplifier() + 1;
            String label = amp > 1 ? nm + " " + roman(amp) : nm;
            String time = inf ? "∞" : fmtTicks(dur);
            int color = 0xFF000000 | e.getEffectType().value().getColor();

            rows.add(new Row(CortimFont.width(label) + 14 + CortimFont.width(time), 19, (c, x, y, w) -> {
                text(c, label, x, y + 2, C_TEXT);
                text(c, time, x + w - CortimFont.width(time), y + 2, C_DIM);
                c.fill(x, y + 13, x + w, y + 15, 0x30FFFFFF);
                c.fill(x, y + 13, x + Math.round(w * frac), y + 15, color);
            }));
        }
        POTION_MAX.keySet().retainAll(alive);

        if (rows.isEmpty() && edit) {
            String label = "Speed II";
            String time = "1:22";
            rows.add(new Row(CortimFont.width(label) + 14 + CortimFont.width(time), 19, (c, x, y, w) -> {
                text(c, label, x, y + 2, C_TEXT);
                text(c, time, x + w - CortimFont.width(time), y + 2, C_DIM);
                c.fill(x, y + 13, x + w, y + 15, 0x30FFFFFF);
                c.fill(x, y + 13, x + Math.round(w * 0.6f), y + 15, 0xFF7CAFC6);
            }));
        }

        drawList(ctx, "potions", sw, sh, 0.78f, 0.60f, tr("Potions", "Зелья"), rows);
    }

    // ---------------------------------------------------------------
    // Cooldowns: предметы из инвентаря, которые сейчас на задержке
    // ---------------------------------------------------------------

    private static final class CdState {
        final long t0;
        final float p0;
        CdState(long t0, float p0) { this.t0 = t0; this.p0 = p0; }
    }

    private static final Map<Item, CdState> CD_STATE = new HashMap<>();

    private static void drawCooldowns(DrawContext ctx, MinecraftClient client, int sw, int sh) {
        var mgr = client.player.getItemCooldownManager();
        PlayerInventory inv = client.player.getInventory();
        long now = System.currentTimeMillis();

        Map<Item, ItemStack> found = new LinkedHashMap<>();
        for (int i = 0; i < inv.size(); i++) {
            ItemStack s = inv.getStack(i);
            if (s.isEmpty() || found.containsKey(s.getItem())) continue;
            if (mgr.isCoolingDown(s)) found.put(s.getItem(), s);
        }
        CD_STATE.keySet().retainAll(found.keySet());

        String sec = tr("s", "с");
        List<Row> rows = new ArrayList<>();

        for (var en : found.entrySet()) {
            ItemStack stack = en.getValue();
            float p = Math.max(0f, Math.min(1f, mgr.getCooldownProgress(stack, 0f)));
            CdState st = CD_STATE.computeIfAbsent(en.getKey(), k -> new CdState(now, p));

            float elapsed = (now - st.t0) / 1000f;
            float used = st.p0 - p;
            String time;
            if (used > 0.04f && elapsed > 0.15f) {
                float rem = p / (used / elapsed);
                time = rem < 10f
                        ? String.format(Locale.ROOT, "%.1f", rem) + sec
                        : (int) rem + sec;
            } else {
                time = "...";
            }

            String nm = stack.getName().getString();
            rows.add(new Row(20 + CortimFont.width(nm) + 12 + CortimFont.width(time), 24, (c, x, y, w) -> {
                c.drawItem(stack, x, y + 1);
                text(c, nm, x + 20, y + 3, C_TEXT);
                text(c, time, x + w - CortimFont.width(time), y + 3, C_DIM);
                c.fill(x + 20, y + 15, x + w, y + 17, 0x30FFFFFF);
                c.fill(x + 20, y + 15, x + 20 + Math.round((w - 20) * p), y + 17, 0xFFE7E7EA);
            }));
        }

        if (rows.isEmpty() && edit) {
            ItemStack stack = new ItemStack(Items.ENDER_PEARL);
            String nm = stack.getName().getString();
            String time = "0.8" + sec;
            rows.add(new Row(20 + CortimFont.width(nm) + 12 + CortimFont.width(time), 24, (c, x, y, w) -> {
                c.drawItem(stack, x, y + 1);
                text(c, nm, x + 20, y + 3, C_TEXT);
                text(c, time, x + w - CortimFont.width(time), y + 3, C_DIM);
                c.fill(x + 20, y + 15, x + w, y + 17, 0x30FFFFFF);
                c.fill(x + 20, y + 15, x + 20 + Math.round((w - 20) * 0.5f), y + 17, 0xFFE7E7EA);
            }));
        }

        drawList(ctx, "cooldowns", sw, sh, 0.78f, 0.35f, tr("Cooldowns", "Кулдауны"), rows);
    }

    // ---------------------------------------------------------------
    // Items: количество предметов + клавиша хотбара
    // ---------------------------------------------------------------

    private static final Item[] TRACKED = {
            Items.ENDER_PEARL, Items.TOTEM_OF_UNDYING, Items.GOLDEN_APPLE,
            Items.ENCHANTED_GOLDEN_APPLE, Items.EXPERIENCE_BOTTLE, Items.FIREWORK_ROCKET
    };

    private static void drawItems(DrawContext ctx, MinecraftClient client, int sw, int sh) {
        PlayerInventory inv = client.player.getInventory();

        int n = TRACKED.length;
        int[] count = new int[n];
        int[] slot = new int[n];
        java.util.Arrays.fill(slot, -1);

        for (int i = 0; i < inv.size(); i++) {
            ItemStack s = inv.getStack(i);
            if (s.isEmpty()) continue;
            for (int k = 0; k < n; k++) {
                if (s.getItem() == TRACKED[k]) {
                    count[k] += s.getCount();
                    if (i < 9 && slot[k] == -1) slot[k] = i;
                }
            }
        }

        List<ItemStack> icons = new ArrayList<>();
        List<String> counts = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        int total = PAD * 2 - 8;

        for (int k = 0; k < n; k++) {
            if (count[k] <= 0) continue;
            String cs = "x" + count[k];
            String key = slot[k] >= 0
                    ? client.options.hotbarKeys[slot[k]].getBoundKeyLocalizedText().getString()
                    : "";
            icons.add(new ItemStack(TRACKED[k]));
            counts.add(cs);
            keys.add(key);
            total += 16 + 3 + CortimFont.width(cs) + (key.isEmpty() ? 0 : 6 + CortimFont.width(key)) + 12;
        }
        if (icons.isEmpty() && edit) {
            Item[] sample = {Items.ENDER_PEARL, Items.TOTEM_OF_UNDYING};
            String[] sc = {"x16", "x2"};
            String[] sk = {"Z", "V"};
            for (int i = 0; i < sample.length; i++) {
                icons.add(new ItemStack(sample[i]));
                counts.add(sc[i]);
                keys.add(sk[i]);
                total += 16 + 3 + CortimFont.width(sc[i]) + 6 + CortimFont.width(sk[i]) + 12;
            }
        }
        if (icons.isEmpty()) return;

        int w = total;
        int h = 26;

        begin(ctx, "items", sw, sh, w, h, true, 0.5f, 0.88f);
        glass(ctx, w, h, 13);

        int x = PAD;
        for (int i = 0; i < icons.size(); i++) {
            ctx.drawItem(icons.get(i), x, 5);
            x += 19;
            text(ctx, counts.get(i), x, 9, C_TEXT);
            x += CortimFont.width(counts.get(i));
            if (!keys.get(i).isEmpty()) {
                x += 6;
                text(ctx, keys.get(i), x, 9, C_DIM);
                x += CortimFont.width(keys.get(i));
            }
            x += 12;
        }
        end(ctx);
    }

    // ---------------------------------------------------------------
    // Armor (своя броня)
    // ---------------------------------------------------------------

    private static void drawArmor(DrawContext ctx, MinecraftClient client, int sw, int sh) {
        ItemStack[] pieces = {
                client.player.getEquippedStack(EquipmentSlot.HEAD),
                client.player.getEquippedStack(EquipmentSlot.CHEST),
                client.player.getEquippedStack(EquipmentSlot.LEGS),
                client.player.getEquippedStack(EquipmentSlot.FEET),
        };
        boolean any = false;
        for (ItemStack s : pieces) if (!s.isEmpty()) any = true;
        if (!any) {
            if (!edit) return;
            pieces = new ItemStack[]{
                    new ItemStack(Items.NETHERITE_HELMET), new ItemStack(Items.NETHERITE_CHESTPLATE),
                    new ItemStack(Items.NETHERITE_LEGGINGS), new ItemStack(Items.NETHERITE_BOOTS)};
        }

        int w = 4 * 22 + 10;
        int h = 36;

        begin(ctx, "armor", sw, sh, w, h, true, 0.90f, 0.90f);
        glass(ctx, w, h, 12);

        Matrix3x2fStack m = ctx.getMatrices();
        for (int i = 0; i < 4; i++) {
            ItemStack s = pieces[i];
            int cx = 5 + i * 22 + 3;

            if (!s.isEmpty()) ctx.drawItem(s, cx, 5);

            int pct = -1;
            if (!s.isEmpty() && s.isDamageable()) {
                pct = (int) ((1.0f - (float) s.getDamage() / s.getMaxDamage()) * 100);
            }
            String str = pct < 0 ? "-" : pct + "%";
            int col = pct < 0 ? 0xFF707070 : healthColor(pct / 100f);

            int tw = (int) (CortimFont.width(str) * 0.7f);
            m.pushMatrix();
            m.translate(cx + 8 - tw / 2f, 24);
            m.scale(0.7f, 0.7f);
            text(ctx, str, 0, 0, col);
            m.popMatrix();
        }
        end(ctx);
    }

    // ---------------------------------------------------------------
    // Target: голова, ник, броня с прочностью, обе руки, кольцо HP
    // ---------------------------------------------------------------

    private static PlayerEntity targetPlayer = null;
    private static long targetSeenMs = 0;

    private static void drawTarget(DrawContext ctx, MinecraftClient client, int sw, int sh) {
        long now = System.currentTimeMillis();
        Entity te = client.targetedEntity;
        if (te instanceof PlayerEntity p && p != client.player) {
            targetPlayer = p;
            targetSeenMs = now;
        }
        if (targetPlayer != null && (now - targetSeenMs > 1500 || targetPlayer.isRemoved())) {
            targetPlayer = null;
        }
        PlayerEntity p = targetPlayer;
        if (p == null && edit) p = client.player; // в режиме расстановки показываем себя как пример
        if (p == null) return;
        int w = 186;
        int h = 44;

        begin(ctx, "target", sw, sh, w, h, true, 0.5f, 0.40f);
        glass(ctx, w, h, 14);

        drawFace(ctx, client, p, 8, 6, 32);

        // ник
        String nm = p.getName().getString();
        while (nm.length() > 1 && CortimFont.width(nm) > 94) nm = nm.substring(0, nm.length() - 1);
        text(ctx, nm, 46, 7, C_TEXT);

        // броня + руки
        ItemStack[] slots = {
                p.getEquippedStack(EquipmentSlot.HEAD),
                p.getEquippedStack(EquipmentSlot.CHEST),
                p.getEquippedStack(EquipmentSlot.LEGS),
                p.getEquippedStack(EquipmentSlot.FEET),
                p.getMainHandStack(),
                p.getOffHandStack(),
        };
        Matrix3x2fStack m = ctx.getMatrices();
        int sx = 46;
        for (int i = 0; i < slots.length; i++) {
            if (i == 4) sx += 6;
            ItemStack s = slots[i];
            if (!s.isEmpty()) {
                m.pushMatrix();
                m.translate(sx, 20);
                m.scale(0.75f, 0.75f);
                ctx.drawItem(s, 0, 0);
                m.popMatrix();

                if (s.isDamageable()) {
                    float f = 1.0f - (float) s.getDamage() / s.getMaxDamage();
                    ctx.fill(sx, 33, sx + 12, 35, 0x66000000);
                    ctx.fill(sx, 33, sx + Math.max(1, Math.round(12 * f)), 35, healthColor(f));
                }
            }
            sx += 15;
        }

        // кольцо здоровья
        float hp = p.getHealth();
        float maxHp = p.getMaxHealth();
        boolean known = !Float.isNaN(hp) && hp > 0f && maxHp > 0f; // иначе HP определить не удалось
        int cx = w - 24;
        int cy = h / 2;

        // подложка кольца — гладкий круг
        RenderUtils.drawRoundedBorder(ctx, cx - 15, cy - 15, 30, 30, 15f, 1f, 0x33FFFFFF, 0x33FFFFFF);

        if (known) {
            float f = Math.max(0f, Math.min(1f, hp / maxHp));
            int col = healthColor(f);

            // дуга здоровья: частые круглые точки по дробным координатам -> ровная окружность без ступенек
            int steps = 96;
            int n = Math.round(steps * f);
            if (n > 0) {
                Matrix3x2fStack mm = ctx.getMatrices();
                for (int i = 0; i <= n; i++) {
                    double ang = -Math.PI / 2 + 2 * Math.PI * i / steps;
                    float dx = (float) (cx + Math.cos(ang) * 13.5) - 1.5f;
                    float dy = (float) (cy + Math.sin(ang) * 13.5) - 1.5f;
                    mm.pushMatrix();
                    mm.translate(dx, dy);
                    RenderUtils.drawSmoothRoundedRect(ctx, 0, 0, 3, 3, 1.5f, col);
                    mm.popMatrix();
                }
            }

            String hs = String.format(Locale.ROOT, "%.1f", hp);
            text(ctx, hs, cx - CortimFont.width(hs) / 2, cy - 4, col);
        } else {
            String q = "?";
            text(ctx, q, cx - CortimFont.width(q) / 2, cy - 4, C_DIM);
        }

        end(ctx);
    }

    /**
     * Голова игрока. Если на этой строке ошибка компиляции — замени тело метода на запасной вариант:
     *   RenderUtils.drawSmoothRoundedRect(ctx, x, y, size, size, 8f, 0xFF2A2A31);
     *   text(ctx, p.getName().getString().substring(0, 1), x + size / 2 - 3, y + size / 2 - 4, C_TEXT);
     */
    private static void drawFace(DrawContext ctx, MinecraftClient client, PlayerEntity p, int x, int y, int size) {
        PlayerListEntry entry = client.getNetworkHandler() != null
                ? client.getNetworkHandler().getPlayerListEntry(p.getUuid())
                : null;
        if (entry != null) {
            PlayerSkinDrawer.draw(ctx, entry.getSkinTextures(), x, y, size);
        } else {
            RenderUtils.drawSmoothRoundedRect(ctx, x, y, size, size, 8f, 0xFF2A2A31);
        }
    }

    // ---------------------------------------------------------------
    // Мышь: растягивание за угол, индикатор угла, автосохранение
    // ---------------------------------------------------------------

    private static int cornerAt(Rect r, double mx, double my) {
        float z = CORNER;
        boolean left = mx >= r.x - 3 && mx <= r.x + z;
        boolean right = mx <= r.x + r.w + 3 && mx >= r.x + r.w - z;
        boolean top = my >= r.y - 3 && my <= r.y + z;
        boolean bottom = my <= r.y + r.h + 3 && my >= r.y + r.h - z;

        if (left && top) return 0;
        if (right && top) return 1;
        if (left && bottom) return 2;
        if (right && bottom) return 3;
        return -1;
    }

    private static void handleMouse(DrawContext ctx, MinecraftClient client, int sw, int sh) {
        boolean chat = client.currentScreen instanceof ChatScreen;
        boolean down = chat && GLFW.glfwGetMouseButton(client.getWindow().getHandle(),
                GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;

        double mx = client.mouse.getX() * sw / (double) client.getWindow().getWidth();
        double my = client.mouse.getY() * sh / (double) client.getWindow().getHeight();

        // начало растягивания
        if (chat && down && !prevDown && resizeName == null && draggingName == null) {
            List<Map.Entry<String, Rect>> list = new ArrayList<>(RECTS.entrySet());
            for (int i = list.size() - 1; i >= 0; i--) {
                int c = cornerAt(list.get(i).getValue(), mx, my);
                if (c >= 0) {
                    Rect r = list.get(i).getValue();
                    resizeName = list.get(i).getKey();
                    resizeCorner = c;
                    resFixedX = (c == 0 || c == 2) ? r.x + r.w : r.x;
                    resFixedY = (c == 0 || c == 1) ? r.y + r.h : r.y;
                    break;
                }
            }
        }

        // процесс растягивания
        if (resizeName != null) {
            Rect r = RECTS.get(resizeName);
            if (!chat || !down || r == null) {
                resizeName = null;
                resizeCorner = -1;
                dirty = true;
            } else {
                float s = (float) ((Math.abs(mx - resFixedX) / r.bw + Math.abs(my - resFixedY) / r.bh) / 2.0);
                s = Math.max(0.4f, Math.min(2.5f, s));

                float nw = r.bw * s;
                float nh = r.bh * s;
                float x0 = (resizeCorner == 0 || resizeCorner == 2) ? resFixedX - nw : resFixedX;
                float y0 = (resizeCorner == 0 || resizeCorner == 1) ? resFixedY - nh : resFixedY;
                float ax = r.centered ? x0 + nw / 2f : x0;

                float[] pos = Hud.HUD_POS.computeIfAbsent(resizeName, k -> new float[]{0.5f, 0.5f});
                pos[0] = ax / sw;
                pos[1] = y0 / sh;
                Hud.HUD_SCALE.put(resizeName, s);
                dirty = true;
            }
        }

        // индикатор угла
        if (chat) {
            int hc = -1;
            Rect hr = null;
            if (resizeName != null) {
                hr = RECTS.get(resizeName);
                hc = resizeCorner;
            } else if (draggingName == null) {
                List<Rect> list = new ArrayList<>(RECTS.values());
                for (int i = list.size() - 1; i >= 0; i--) {
                    int c = cornerAt(list.get(i), mx, my);
                    if (c >= 0) { hr = list.get(i); hc = c; break; }
                }
            }
            if (hr != null && hc >= 0) drawCornerHint(ctx, hr, hc, resizeName != null);
        }

        // автосохранение, когда ничего не тянут
        if (draggingName != null) {
            wasDragging = true;
        } else if (wasDragging) {
            wasDragging = false;
            dirty = true;
        }
        if (dirty && !down && draggingName == null) {
            save();
            dirty = false;
        }
        prevDown = down;
    }

    private static void drawCornerHint(DrawContext ctx, Rect r, int corner, boolean active) {
        int len = 7, th = 2;
        boolean left = corner == 0 || corner == 2;
        boolean top = corner == 0 || corner == 1;
        int x = Math.round(left ? r.x - 2 : r.x + r.w + 2);
        int y = Math.round(top ? r.y - 2 : r.y + r.h + 2);
        int col = active ? 0xFFFFFFFF : 0xC0FFFFFF;

        int hx0 = left ? x : x - len;
        int hy0 = top ? y : y - th;
        ctx.fill(hx0, hy0, hx0 + len, hy0 + th, col);

        int vx0 = left ? x : x - th;
        int vy0 = top ? y : y - len;
        ctx.fill(vx0, vy0, vx0 + th, vy0 + len, col);
    }

    // ---------------------------------------------------------------
    // Внешний API (используется кодом перетаскивания)
    // ---------------------------------------------------------------

    public static void drag(double mx, double my, int sw, int sh) {
        if (draggingName == null) return;
        float[] pos = Hud.HUD_POS.computeIfAbsent(draggingName, k -> new float[]{0.5f, 0.5f});
        pos[0] = Math.max(0f, Math.min(1f, (float) ((mx - dragOffsetX) / sw)));
        pos[1] = Math.max(0f, Math.min(1f, (float) ((my - dragOffsetY) / sh)));
        dirty = true;
    }

    public static boolean handleScroll(MinecraftClient client, double mx, double my, double amount) {
        if (client.player == null) return false;
        String hit = hitTest(client, mx, my);
        if (hit == null) return false;
        float cur = Hud.HUD_SCALE.getOrDefault(hit, 1.0f);
        float next = (float) (cur + amount * 0.1);
        next = Math.max(0.4f, Math.min(2.5f, next));
        Hud.HUD_SCALE.put(hit, next);
        dirty = true;
        return true;
    }

    /** Имя панели под курсором. В зоне угла возвращает null — там работает растягивание. */
    public static String hitTest(MinecraftClient client, double mx, double my) {
        if (client.player == null) return null;
        List<Map.Entry<String, Rect>> list = new ArrayList<>(RECTS.entrySet());
        for (int i = list.size() - 1; i >= 0; i--) {
            Rect r = list.get(i).getValue();
            if (!r.contains(mx, my)) continue;
            if (cornerAt(r, mx, my) >= 0) return null;
            return list.get(i).getKey();
        }
        return null;
    }

    // ---------------------------------------------------------------
    // Сохранение позиций и размеров
    // ---------------------------------------------------------------

    private static void ensureLoaded() {
        if (loaded) return;
        loaded = true;
        if (!Files.exists(FILE)) return;
        try {
            Map<String, float[]> map = GSON.fromJson(Files.readString(FILE),
                    new TypeToken<Map<String, float[]>>() {}.getType());
            if (map == null) return;
            for (var e : map.entrySet()) {
                float[] v = e.getValue();
                if (v == null || v.length < 3) continue;
                Hud.HUD_POS.put(e.getKey(), new float[]{v[0], v[1]});
                Hud.HUD_SCALE.put(e.getKey(), v[2]);
            }
        } catch (Exception e) {
            Cortim.LOG.warn("hud load failed", e);
        }
    }

    private static void save() {
        Map<String, float[]> map = new LinkedHashMap<>();
        for (var e : Hud.HUD_POS.entrySet()) {
            map.put(e.getKey(), new float[]{
                    e.getValue()[0], e.getValue()[1],
                    Hud.HUD_SCALE.getOrDefault(e.getKey(), 1.0f)});
        }
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(map));
        } catch (IOException e) {
            Cortim.LOG.warn("hud save failed", e);
        }
    }
}