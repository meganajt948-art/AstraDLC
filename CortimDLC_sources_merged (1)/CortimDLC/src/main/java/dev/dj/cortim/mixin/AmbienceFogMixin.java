package dev.dj.cortim.mixin;

import dev.dj.cortim.Cortim;
import dev.dj.cortim.module.Ambience;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.DefaultFramebufferSet;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.Pool;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class AmbienceFogMixin {

    @Shadow private Pool pool;

    @Unique private static PostEffectProcessor cortim$fogProcessor = null;
    @Unique private static boolean cortim$fogLoadFailed = false;

    private static Ambience amb() {
        return Cortim.getAmbience();
    }

    @Inject(method = "renderWorld", at = @At("TAIL"))
    private void cortim$ambienceFog(RenderTickCounter tickCounter, CallbackInfo ci) {
        Ambience a = amb();
        if (a == null || !a.isEnabled() || !a.isFogEnabled()) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.getFramebuffer() == null) return;

        if (cortim$fogProcessor == null && !cortim$fogLoadFailed) {
            try {
                cortim$fogProcessor = mc.getShaderLoader()
                        .loadPostEffect(Identifier.of("cortim", "ambience_fog"),
                                DefaultFramebufferSet.MAIN_ONLY);
            } catch (Throwable t) {
                Cortim.LOG.warn("AmbienceFog load failed", t);
                cortim$fogLoadFailed = true;
                return;
            }
        }
        if (cortim$fogProcessor == null) return;

        try {
            cortim$fogProcessor.render(mc.getFramebuffer(), this.pool);
        } catch (Throwable t) {
            Cortim.LOG.warn("AmbienceFog render failed", t);
        }
    }
}