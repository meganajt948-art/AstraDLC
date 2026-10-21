package dev.dj.cortim.module;

import dev.dj.cortim.CortimConfig;
import net.minecraft.client.MinecraftClient;

public class Smoothness extends Module {

    private float lastYaw, lastPitch;
    private boolean initialized = false;

    public Smoothness() { super("Smoothness", Category.RENDER); }

    @Override
    public void onTick() {
        if (!isEnabled()) { initialized = false; return; }
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        float yaw = client.player.getYaw();
        float pitch = client.player.getPitch();

        if (!initialized) {
            lastYaw = yaw; lastPitch = pitch; initialized = true; return;
        }

        float speed = CortimConfig.rotationSpeed;
        float smoothYaw = lerpAngle(lastYaw, yaw, speed);
        float smoothPitch = lerp(lastPitch, pitch, speed);

        client.player.setYaw(smoothYaw);
        client.player.setPitch(smoothPitch);

        lastYaw = smoothYaw;
        lastPitch = smoothPitch;
    }

    private static float lerp(float a, float b, float t) { return a + (b - a) * t; }

    private static float lerpAngle(float a, float b, float t) {
        float delta = ((b - a + 540) % 360) - 180;
        return a + delta * t;
    }
}