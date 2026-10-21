package dev.dj.cortim.module;

import dev.dj.cortim.gui.CortimScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.BookEditScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class GuiMove extends Module {

    private final BoolSetting ctrlSprint = add(new BoolSetting("Бег на Ctrl",
            "Спринт по кнопке спринта в открытых окнах", true));
    private final BoolSetting jump = add(new BoolSetting("Прыжок",
            "Прыжок в открытых окнах", true));
    private final BoolSetting inClient = add(new BoolSetting("В меню клиента",
            "Двигаться, пока открыто меню клиента", true));
    private final BoolSetting bypass = add(new BoolSetting("Обход MultiActions",
            "Не двигаться в тик, когда зажата кнопка мыши в инвентаре (клик и движение не совпадают)", true));

    public GuiMove() { super("GuiMove", Category.MOVEMENT); }

    @Override
    public void onTick() {
        if (!isEnabled()) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        Screen s = mc.currentScreen;
        if (s == null || !screenAllowed(s)) return;

        long win = mc.getWindow().getHandle();

        boolean blocked = bypass.get() && s instanceof HandledScreen<?>
                && (GLFW.glfwGetMouseButton(win, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS
                || GLFW.glfwGetMouseButton(win, GLFW.GLFW_MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS);

        apply(mc.options.forwardKey, win, !blocked);
        apply(mc.options.backKey, win, !blocked);
        apply(mc.options.leftKey, win, !blocked);
        apply(mc.options.rightKey, win, !blocked);
        apply(mc.options.jumpKey, win, !blocked && jump.get());
        apply(mc.options.sprintKey, win, !blocked && ctrlSprint.get());
    }

    public boolean screenAllowed(Screen s) {
        if (s instanceof CortimScreen) return inClient.get();
        if (s instanceof ChatScreen || s instanceof AbstractSignEditScreen || s instanceof BookEditScreen) {
            return false;
        }
        return !(s.getFocused() instanceof TextFieldWidget); // поиск, наковальня и т.п.
    }

    private void apply(KeyBinding kb, long win, boolean allowed) {
        kb.setPressed(allowed && isDown(kb, win));
    }

    private boolean isDown(KeyBinding kb, long win) {
        String key = kb.getBoundKeyTranslationKey();
        if (!key.startsWith("key.keyboard.")) return false; // кнопки мыши не трогаем
        int code = InputUtil.fromTranslationKey(key).getCode();
        return code > 0 && GLFW.glfwGetKey(win, code) == GLFW.GLFW_PRESS;
    }
}