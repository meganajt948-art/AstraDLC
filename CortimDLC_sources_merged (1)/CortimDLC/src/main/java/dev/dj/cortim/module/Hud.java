package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hud extends Module {

    // порядок = порядок карточек во вкладке HUD
    private final BoolSetting watermark = add(new BoolSetting("Watermark", "Показывать название софта", true));
    private final BoolSetting target    = add(new BoolSetting("Target", "Цель: голова, броня, руки, HP", true));
    private final BoolSetting armor     = add(new BoolSetting("Armor", "Прочность своей брони", true));
    private final BoolSetting potions   = add(new BoolSetting("Potions", "Активные эффекты", true));
    private final BoolSetting keybinds  = add(new BoolSetting("Keybinds", "Список включённых биндов", true));
    private final BoolSetting cooldowns = add(new BoolSetting("Cooldowns", "Предметы на задержке", true));
    private final BoolSetting items     = add(new BoolSetting("Items", "Количество предметов и клавиша", true));
    private final BoolSetting staff     = add(new BoolSetting("Staff", "Модераторы на сервере", true));

    public Hud() {
        super("Hud", Category.CLIENT);
        setEnabled(true);
    }

    public boolean showWatermark() { return watermark.get(); }
    public boolean showTarget()    { return target.get(); }
    public boolean showArmor()     { return armor.get(); }
    public boolean showPotions()   { return potions.get(); }
    public boolean showKeybinds()  { return keybinds.get(); }
    public boolean showCooldowns() { return cooldowns.get(); }
    public boolean showItems()     { return items.get(); }
    public boolean showStaff()     { return staff.get(); }

    public static final Map<String, float[]> HUD_POS = new HashMap<>();
    public static final Map<String, float[]> HUD_ANIM = new HashMap<>();
    public static final Map<String, Float> HUD_SCALE = new HashMap<>();

    static {
        HUD_POS.put("watermark", new float[]{0.5f, 0.03f});
        HUD_POS.put("target",    new float[]{0.5f, 0.40f});
        HUD_POS.put("keybinds",  new float[]{0.16f, 0.30f});
        HUD_POS.put("staff",     new float[]{0.78f, 0.06f});
        HUD_POS.put("cooldowns", new float[]{0.78f, 0.35f});
        HUD_POS.put("potions",   new float[]{0.78f, 0.60f});
        HUD_POS.put("items",     new float[]{0.5f, 0.88f});
        HUD_POS.put("armor",     new float[]{0.90f, 0.90f});

        for (String k : HUD_POS.keySet()) HUD_SCALE.put(k, 1.0f);
    }

    private static double lastX = 0, lastY = 0, lastZ = 0;
    private static long lastBpsMs = 0;
    private static double bps = 0;

    public static void updateBps(MinecraftClient client) {
        if (client.player == null) return;
        long now = System.currentTimeMillis();
        if (lastBpsMs == 0) {
            lastX = client.player.getX();
            lastY = client.player.getY();
            lastZ = client.player.getZ();
            lastBpsMs = now;
            return;
        }
        long dt = now - lastBpsMs;
        if (dt < 250) return;

        double dx = client.player.getX() - lastX;
        double dy = client.player.getY() - lastY;
        double dz = client.player.getZ() - lastZ;
        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
        bps = dist / (dt / 1000.0);

        lastX = client.player.getX();
        lastY = client.player.getY();
        lastZ = client.player.getZ();
        lastBpsMs = now;
    }

    public static double getBps() { return bps; }

    public String watermarkText(MinecraftClient client) {
        int fps = client.getCurrentFps();
        int ping = 0;
        if (client.getNetworkHandler() != null && client.player != null) {
            var entry = client.getNetworkHandler().getPlayerListEntry(client.player.getUuid());
            if (entry != null) ping = entry.getLatency();
        }
        double tps = 20.0;
        if (client.world != null) {
            try {
                tps = Math.min(20.0, 1000.0 / Math.max(1, client.world.getTickManager().getMillisPerTick()));
            } catch (Throwable ignored) {}
        }
        return String.format("CygnusWare ⚡ %d FPS 🌐 %d ms ⚙ %.1f TPS 🧊 %.1f BPS",
                fps, ping, tps, bps);
    }

    public String cooldownText(MinecraftClient client) {
        if (!isEnabled() || !cooldowns.get()) return null;
        if (client.player == null) return null;
        ItemStack main = client.player.getMainHandStack();
        if (main.isEmpty()) return null;
        float cd = client.player.getAttackCooldownProgress(0.0F);
        if (cd >= 1.0f) return null;
        return "Cooldown · " + (int)(cd * 100) + "%";
    }

    public List<String> potionLines(MinecraftClient client) {
        List<String> out = new ArrayList<>();
        if (!isEnabled() || !potions.get()) return out;
        if (client.player == null) return out;
        for (StatusEffectInstance e : client.player.getStatusEffects()) {
            String name = Text.translatable(e.getTranslationKey()).getString();
            int sec = e.getDuration() / 20;
            int amp = e.getAmplifier() + 1;
            out.add(name + " " + amp + "  " + sec + "s");
        }
        return out;
    }

    /** Включённые модули с биндом: {имя, клавиша}. Пусто — панель биндов не показывается. */
    public List<String[]> bindEntries(MinecraftClient client) {
        List<String[]> out = new ArrayList<>();
        if (!isEnabled() || !keybinds.get()) return out;
        for (Module m : ModuleRegistry.all()) {
            if (m == this) continue;
            if (m.getBoundKey() == -1) continue;
            if (!m.isEnabled()) continue;
            out.add(new String[]{m.getName(), keyName(m.getBoundKey())});
        }
        return out;
    }

    public List<String> bindLines(MinecraftClient client) {
        List<String> out = new ArrayList<>();
        for (String[] e : bindEntries(client)) out.add(e[0] + "  " + e[1]);
        return out;
    }

    public List<String> staffLines(MinecraftClient client) {
        List<String> out = new ArrayList<>();
        if (!isEnabled() || !staff.get()) return out;
        if (client.getNetworkHandler() == null) return out;
        for (PlayerListEntry entry : client.getNetworkHandler().getPlayerList()) {
            Text display = entry.getDisplayName();
            if (display == null) continue;
            String raw = display.getString();
            String low = raw.toLowerCase();
            if (low.contains("админ") || low.contains("admin")
                    || low.contains("модер") || low.contains("moder")
                    || low.contains("хелпер") || low.contains("helper")
                    || low.contains("owner") || low.contains("curator")) {
                out.add(raw);
            }
        }
        if (out.size() > 8) out = out.subList(0, 8);
        return out;
    }

    public ItemStack[] armorStacks(MinecraftClient client) {
        if (client.player == null) return new ItemStack[4];
        return new ItemStack[]{
                client.player.getEquippedStack(EquipmentSlot.HEAD),
                client.player.getEquippedStack(EquipmentSlot.CHEST),
                client.player.getEquippedStack(EquipmentSlot.LEGS),
                client.player.getEquippedStack(EquipmentSlot.FEET),
        };
    }

    public int[] armorPercents(MinecraftClient client) {
        ItemStack[] pieces = armorStacks(client);
        int[] out = new int[4];
        for (int i = 0; i < 4; i++) {
            var s = pieces[i];
            if (s.isEmpty() || !s.isDamageable()) { out[i] = -1; continue; }
            int max = s.getMaxDamage();
            int dmg = s.getDamage();
            out[i] = (int)((1.0f - (float)dmg / max) * 100);
        }
        return out;
    }

    public String armorLine(MinecraftClient client) {
        if (!isEnabled() || !armor.get()) return null;
        if (client.player == null) return null;
        int[] percents = armorPercents(client);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (percents[i] < 0) { sb.append("—   "); continue; }
            sb.append(percents[i]).append("%   ");
        }
        return sb.toString().trim();
    }

    public static String keyName(int key) {
        if (key >= 1000) { // кнопки мыши: 1000 + номер кнопки GLFW
            int b = key - 1000;
            return switch (b) {
                case 0 -> "LMB";
                case 1 -> "RMB";
                case 2 -> "MMB";
                default -> "M" + (b + 1);
            };
        }
        if (key >= GLFW.GLFW_KEY_A && key <= GLFW.GLFW_KEY_Z) {
            return String.valueOf((char)('A' + (key - GLFW.GLFW_KEY_A)));
        }
        if (key >= GLFW.GLFW_KEY_0 && key <= GLFW.GLFW_KEY_9) {
            return String.valueOf((char)('0' + (key - GLFW.GLFW_KEY_0)));
        }
        return switch (key) {
            case GLFW.GLFW_KEY_SPACE         -> "Space";
            case GLFW.GLFW_KEY_LEFT_SHIFT    -> "LShift";
            case GLFW.GLFW_KEY_RIGHT_SHIFT   -> "RShift";
            case GLFW.GLFW_KEY_LEFT_CONTROL  -> "LCtrl";
            case GLFW.GLFW_KEY_RIGHT_CONTROL -> "RCtrl";
            case GLFW.GLFW_KEY_LEFT_ALT      -> "LAlt";
            case GLFW.GLFW_KEY_RIGHT_ALT     -> "RAlt";
            case GLFW.GLFW_KEY_TAB           -> "Tab";
            case GLFW.GLFW_KEY_ENTER         -> "Enter";
            case GLFW.GLFW_KEY_BACKSPACE     -> "Backspace";
            case GLFW.GLFW_KEY_DELETE        -> "Delete";
            case GLFW.GLFW_KEY_INSERT        -> "Insert";
            case GLFW.GLFW_KEY_HOME          -> "Home";
            case GLFW.GLFW_KEY_END           -> "End";
            case GLFW.GLFW_KEY_PAGE_UP       -> "PageUp";
            case GLFW.GLFW_KEY_PAGE_DOWN     -> "PageDown";
            case GLFW.GLFW_KEY_UP            -> "Up";
            case GLFW.GLFW_KEY_DOWN          -> "Down";
            case GLFW.GLFW_KEY_LEFT          -> "Left";
            case GLFW.GLFW_KEY_RIGHT         -> "Right";
            case GLFW.GLFW_KEY_ESCAPE        -> "Esc";
            case GLFW.GLFW_KEY_CAPS_LOCK     -> "Caps";
            case GLFW.GLFW_KEY_F1  -> "F1";  case GLFW.GLFW_KEY_F2  -> "F2";
            case GLFW.GLFW_KEY_F3  -> "F3";  case GLFW.GLFW_KEY_F4  -> "F4";
            case GLFW.GLFW_KEY_F5  -> "F5";  case GLFW.GLFW_KEY_F6  -> "F6";
            case GLFW.GLFW_KEY_F7  -> "F7";  case GLFW.GLFW_KEY_F8  -> "F8";
            case GLFW.GLFW_KEY_F9  -> "F9";  case GLFW.GLFW_KEY_F10 -> "F10";
            case GLFW.GLFW_KEY_F11 -> "F11"; case GLFW.GLFW_KEY_F12 -> "F12";
            case GLFW.GLFW_KEY_MINUS         -> "-";
            case GLFW.GLFW_KEY_EQUAL         -> "=";
            case GLFW.GLFW_KEY_LEFT_BRACKET  -> "[";
            case GLFW.GLFW_KEY_RIGHT_BRACKET -> "]";
            case GLFW.GLFW_KEY_BACKSLASH     -> "\\";
            case GLFW.GLFW_KEY_SEMICOLON     -> ";";
            case GLFW.GLFW_KEY_APOSTROPHE    -> "'";
            case GLFW.GLFW_KEY_GRAVE_ACCENT  -> "`";
            case GLFW.GLFW_KEY_COMMA         -> ",";
            case GLFW.GLFW_KEY_PERIOD        -> ".";
            case GLFW.GLFW_KEY_SLASH         -> "/";
            default -> "K" + key;
        };
    }
}