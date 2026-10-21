package dev.dj.cortim.module;

import dev.dj.cortim.CortimConfig;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    private final String name;
    private final Category category;
    private boolean enabled;
    private int boundKey = -1;
    private boolean hudVisible = false;

    private final List<Setting<?>> settings = new ArrayList<>();

    protected Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() { return name; }
    public Category getCategory() { return category; }
    public boolean isEnabled() { return enabled && !CortimConfig.isPanic(); }
    public void setEnabled(boolean v) { this.enabled = v; }
    public void toggle() { setEnabled(!this.enabled); }

    public int getBoundKey() { return boundKey; }
    public void setBoundKey(int key) { this.boundKey = key; }
    public void clearBind() { this.boundKey = -1; }

    public boolean isHudVisible() { return hudVisible; }
    public void setHudVisible(boolean v) { this.hudVisible = v; }

    public List<Setting<?>> getSettings() { return settings; }

    public List<Setting<?>> getVisibleSettings() {
        List<Setting<?>> out = new ArrayList<>();
        for (Setting<?> s : settings) {
            if (s.isVisible()) out.add(s);
        }
        return out;
    }

    @SuppressWarnings("unchecked")
    protected <T extends Setting<?>> T add(T s) { settings.add(s); return s; }

    public void onTick() {}
    public void onRender(float tickDelta) {}

    public enum Category {
        COMBAT("Combat"), VISUAL("Visual"), MOVEMENT("Movement"),
        PLAYER("Player"), RENDER("Render"), CLIENT("Client"), MISC("Misc");
        public final String label;
        Category(String label) { this.label = label; }
    }

    public static abstract class Setting<T> {
        private final String name;
        private final String desc;
        protected T value;
        public Setting(String name, String desc, T def) {
            this.name = name; this.desc = desc; this.value = def;
        }
        public String getName() { return name; }
        public String getDesc() { return desc; }
        public T get() { return value; }
        public void set(T v) { this.value = v; }

        public boolean isVisible() { return true; }

        public abstract void adjust(int direction);
        public abstract String display();
    }

    public static class BoolSetting extends Setting<Boolean> {
        public BoolSetting(String name, String desc, boolean def) { super(name, desc, def); }
        @Override public void adjust(int dir) { value = !value; }
        @Override public String display() { return value ? "ON" : "OFF"; }
    }

    public static class FloatSetting extends Setting<Float> {
        private final float min, max, step;
        public FloatSetting(String name, String desc, float def, float min, float max, float step) {
            super(name, desc, def);
            this.min = min; this.max = max; this.step = step;
        }
        public float min() { return min; }
        public float max() { return max; }
        public float step() { return step; }
        @Override public void adjust(int dir) {
            value = Math.max(min, Math.min(max, value + step * dir));
        }
        @Override public String display() { return String.format("%.3f", value); }
    }

    public static class IntSetting extends Setting<Integer> {
        private final int min, max;
        public IntSetting(String name, String desc, int def, int min, int max) {
            super(name, desc, def); this.min = min; this.max = max;
        }
        public int min() { return min; }
        public int max() { return max; }
        @Override public void adjust(int dir) {
            value = Math.max(min, Math.min(max, value + dir));
        }
        @Override public String display() { return Integer.toString(value); }
    }

    public static class ModeSetting extends Setting<Integer> {
        private final String[] options;
        private boolean segmented = false;
        public ModeSetting(String name, String desc, int def, String... options) {
            super(name, desc, def);
            this.options = options;
        }
        /** Рисовать в меню как плашку из кнопок (иначе при 3+ вариантах — выпадающий список). */
        public ModeSetting asSegmented() { this.segmented = true; return this; }
        public boolean isSegmented() { return segmented; }
        public String[] options() { return options; }
        public String current() { return options[Math.max(0, Math.min(options.length - 1, value))]; }
        @Override public void adjust(int dir) {
            value = Math.max(0, Math.min(options.length - 1, value + dir));
        }
        @Override public String display() { return current(); }
    }

    public static class MultiSetting extends Setting<int[]> {
        private final String[] options;
        public MultiSetting(String name, String desc, int defaultMask, String... options) {
            super(name, desc, new int[]{defaultMask});
            this.options = options;
        }
        public String[] options() { return options; }
        public boolean isOn(int index) { return (value[0] & (1 << index)) != 0; }
        public void toggle(int index) { value[0] ^= (1 << index); }
        @Override public void adjust(int dir) { }
        @Override public String display() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < options.length; i++) {
                if (isOn(i)) {
                    if (sb.length() > 0) sb.append(", ");
                    sb.append(options[i]);
                }
            }
            return sb.length() == 0 ? "Нет" : sb.toString();
        }
    }

    public static class ButtonSetting extends Setting<Runnable> {
        public ButtonSetting(String name, String desc, Runnable onClick) {
            super(name, desc, onClick);
        }
        @Override public void adjust(int direction) { value.run(); }
        @Override public String display() { return "●"; }
    }

    /** Клавиша (код GLFW), -1 = не назначена. Меняется кликом по строке в меню. */
    public static class KeySetting extends Setting<Integer> {
        public KeySetting(String name, String desc, int defaultKey) {
            super(name, desc, defaultKey);
        }
        public int getKey() { return value; }

        /** Зажата ли клавиша (код GLFW) или кнопка мыши (1000 + номер). */
        public boolean isDown() {
            if (value < 0) return false;
            long win = MinecraftClient.getInstance().getWindow().getHandle();
            if (value >= 1000) {
                return GLFW.glfwGetMouseButton(win, value - 1000) == GLFW.GLFW_PRESS;
            }
            return GLFW.glfwGetKey(win, value) == GLFW.GLFW_PRESS;
        }

        @Override public void adjust(int direction) {}
        @Override public String display() { return value < 0 ? "None" : Integer.toString(value); }
    }

    public static class ColorSetting extends Setting<Integer> {
        public ColorSetting(String name, String desc, int defaultColor) {
            super(name, desc, defaultColor);
        }
        public int getColor() { return value; }
        public void setColor(int c) { value = c; }
        @Override public void adjust(int direction) {}
        @Override public String display() { return String.format("#%06X", value & 0xFFFFFF); }
    }

    /** Текстовое поле, например для команды. Редактируется кликом по плашке в меню. */
    public static class TextSetting extends Setting<String> {
        public TextSetting(String name, String desc, String def) { super(name, desc, def); }
        @Override public void adjust(int direction) {}
        @Override public String display() { return value == null ? "" : value; }
    }
}