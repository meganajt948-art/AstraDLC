package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FullBright extends Module {

    public FullBright() { super("FullBright", Category.VISUAL); }

    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null || mc.world == null) return;
        if (!isEnabled()) return;

        StatusEffectInstance current = mc.player.getStatusEffect(StatusEffects.NIGHT_VISION);
        if (current == null || current.getDuration() < 100) {
            mc.player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NIGHT_VISION,
                    Integer.MAX_VALUE,
                    0,
                    false,
                    false,
                    false
            ));
        }
    }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.player == null) return;

        if (!v) {
            mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        }
    }
}