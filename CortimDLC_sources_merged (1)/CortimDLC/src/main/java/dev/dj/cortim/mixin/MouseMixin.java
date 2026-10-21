package dev.dj.cortim.mixin;

import dev.dj.cortim.Cortim;
import dev.dj.cortim.module.AimAssist;
import dev.dj.cortim.module.Freecam;
import dev.dj.cortim.util.Dbg;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseMixin {

    private double cortim$lastX = Double.NaN;
    private double cortim$lastY = Double.NaN;

    /** Пока активен Freecam: крутим камеру мышью сами и не даём ванили повернуть игрока. */
    @Inject(method = "updateMouse", at = @At("HEAD"), cancellable = true)
    private void cortim$freecamLook(CallbackInfo ci) {
        if (!Freecam.active) {
            cortim$lastX = Double.NaN;
            cortim$lastY = Double.NaN;
            return;
        }

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.currentScreen != null || client.getWindow() == null) return;

        long win = client.getWindow().getHandle();
        double[] xArr = new double[1], yArr = new double[1];
        GLFW.glfwGetCursorPos(win, xArr, yArr);
        double x = xArr[0], y = yArr[0];

        if (Double.isNaN(cortim$lastX)) {
            cortim$lastX = x;
            cortim$lastY = y;
        }

        double dx = x - cortim$lastX;
        double dy = y - cortim$lastY;
        cortim$lastX = x;
        cortim$lastY = y;

        Dbg.every("mouse", 1000, "mouse hook dx={} dy={} yaw={}", dx, dy, Freecam.cameraYaw);

        double sensValue = client.options.getMouseSensitivity().getValue();
        double sens = sensValue * 0.6 + 0.2;
        double factor = sens * sens * sens * 1.2;

        Freecam.cameraYaw = (float) (Freecam.cameraYaw + dx * factor);
        Freecam.cameraPitch = (float) Math.max(-90, Math.min(90, Freecam.cameraPitch + dy * factor));

        ci.cancel();
    }

    /** Каждый кадр после обработки мыши: плавная наводка AimAssist (не во фрикаме). */
    @Inject(method = "updateMouse", at = @At("TAIL"))
    private void cortim$aimFrame(CallbackInfo ci) {
        if (Freecam.active) return;
        AimAssist a = Cortim.getAimAssist();
        if (a != null) {
            try { a.onFrame(); } catch (Throwable t) { Cortim.LOG.warn("aim frame", t); }
        }
    }
}