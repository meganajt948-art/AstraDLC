package dev.dj.cortim.module;

import dev.dj.cortim.CortimConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.random.Random;

public class Atmosphere extends Module {

    public Atmosphere() { super("Atmosphere", Category.VISUAL); }

    public static void registerParticles() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!CortimConfig.atmosphereEnabled || CortimConfig.isPanic()) return;
            if (!CortimConfig.snowParticles) return;

            ClientWorld world = client.world;
            if (world == null || client.player == null) return;

            int count = (int) (12 * CortimConfig.snowDensity);
            var player = client.player;
            Random rnd = world.random;

            for (int i = 0; i < count; i++) {
                double dx = (rnd.nextDouble() - 0.5) * 24;
                double dy = (rnd.nextDouble() - 0.5) * 12 + 8;
                double dz = (rnd.nextDouble() - 0.5) * 24;
                world.addParticleClient(
                        ParticleTypes.SNOWFLAKE,
                        player.getX() + dx,
                        player.getY() + dy,
                        player.getZ() + dz,
                        0, -0.05, 0
                );
            }
        });
    }

    @Override
    public void onTick() {}
}