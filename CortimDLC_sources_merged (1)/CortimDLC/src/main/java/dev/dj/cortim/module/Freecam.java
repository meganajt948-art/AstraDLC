package dev.dj.cortim.module;

import dev.dj.cortim.util.Dbg;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class Freecam extends Module {

    public static Vec3d cameraPos = Vec3d.ZERO;
    /** Позиция прошлого тика, нужна для плавной интерполяции между тиками. */
    public static Vec3d prevCameraPos = Vec3d.ZERO;
    public static float cameraYaw = 0f;
    public static float cameraPitch = 0f;
    public static boolean active = false;

    private static Vec3d targetPos = Vec3d.ZERO;

    private final FloatSetting speed = add(new FloatSetting("Скорость",
            "Скорость полёта камеры, блоков в секунду", 10f, 1f, 50f, 1f) {
        @Override public String display() { return Math.round(get()) + " бл/с"; }
    });

    private final IntSetting smoothness = add(new IntSetting("Плавность",
            "Сглаживание движения камеры, %", 50, 0, 95) {
        @Override public String display() { return get() + "%"; }
    });

    private final BoolSetting lookFly = add(new BoolSetting("Лететь по взгляду",
            "Вперёд = туда, куда смотришь (иначе только по горизонтали)", false));

    private final BoolSetting stopOnHurt = add(new BoolSetting("Выкл при уроне",
            "Выключать фрикам, когда тебя бьют", true));

    public Freecam() { super("Freecam", Category.PLAYER); }

    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;

        if (player == null || mc.world == null) {
            active = false;
            return;
        }

        if (!isEnabled()) {
            active = false;
            return;
        }

        if (active && stopOnHurt.get() && player.hurtTime > 0) {
            setEnabled(false);
            return;
        }

        if (!active) {
            cameraPos = player.getEyePos();
            prevCameraPos = cameraPos;
            targetPos = cameraPos;
            cameraYaw = player.getYaw();
            cameraPitch = player.getPitch();
            active = true;
            Dbg.every("fc-on", 0, "freecam ACTIVE pos={}", cameraPos);
        }

        // тело игрока стоит на месте благодаря KeyboardInputMixin;
        // движение камеры читаем, только когда не открыт чат/инвентарь/меню
        if (mc.currentScreen == null) {
            Vec3d forward = lookFly.get()
                    ? Vec3d.fromPolar(cameraPitch, cameraYaw)
                    : Vec3d.fromPolar(0, cameraYaw);
            Vec3d right = Vec3d.fromPolar(0, cameraYaw + 90);

            long win = mc.getWindow().getHandle();
            double sp = speed.get() / 20.0; // блоков/сек -> блоков/тик
            if (GLFW.glfwGetKey(win, GLFW.GLFW_KEY_LEFT_CONTROL) == GLFW.GLFW_PRESS) sp *= 3.0;

            if (mc.options.forwardKey.isPressed()) targetPos = targetPos.add(forward.multiply(sp));
            if (mc.options.backKey.isPressed())    targetPos = targetPos.add(forward.multiply(-sp));
            if (mc.options.leftKey.isPressed())    targetPos = targetPos.add(right.multiply(-sp));
            if (mc.options.rightKey.isPressed())   targetPos = targetPos.add(right.multiply(sp));
            if (mc.options.jumpKey.isPressed())    targetPos = targetPos.add(0, sp, 0);
            if (mc.options.sneakKey.isPressed())   targetPos = targetPos.add(0, -sp, 0);
        }

        // сглаживание: доля пути до цели за тик (0% = мгновенно, 95% = очень плавно)
        prevCameraPos = cameraPos;
        double lerp = 1.0 - (smoothness.get() / 100.0) * 0.9;
        cameraPos = cameraPos.lerp(targetPos, Math.max(0.05, lerp));

        // поворотом камеры управляет MouseMixin
    }

    /** Позиция для рендера: плавная между тиками. */
    public static Vec3d getRenderPos(float tickDelta) {
        return prevCameraPos.lerp(cameraPos, tickDelta);
    }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        if (!v) active = false;
    }

    public static void reset() {
        active = false;
        cameraPos = Vec3d.ZERO;
        prevCameraPos = Vec3d.ZERO;
        targetPos = Vec3d.ZERO;
    }
}