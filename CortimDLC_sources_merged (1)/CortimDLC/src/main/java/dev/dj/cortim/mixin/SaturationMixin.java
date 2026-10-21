package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.Saturation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.DefaultFramebufferSet;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.Pool; // ← может быть другой пакет, см. ниже
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class SaturationMixin {

    @Shadow
    private Pool pool;

    @Unique
    private static PostEffectProcessor cortim$processor = null;
    @Unique
    private static String cortim$currentPreset = null;

    private static Saturation sat() {
        return (Saturation) ModuleRegistry.byName("Saturation");
    }

    @Inject(method = "renderWorld", at = @At("TAIL"))
    private void cortim$saturationWorld(RenderTickCounter tickCounter, CallbackInfo ci) {
        Saturation s = sat();
        if (s == null || !s.isEnabled()) return;
        if (!s.isWorldOnly()) return;
        cortim$apply();
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void cortim$saturationFull(RenderTickCounter tickCounter, boolean renderWorld, CallbackInfo ci) {
        Saturation s = sat();
        if (s == null || !s.isEnabled()) return;
        if (s.isWorldOnly()) return;
        cortim$apply();
    }

    @Unique
    private void cortim$apply() {
        Saturation s = sat();
        if (s == null) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.getFramebuffer() == null) return;

        String preset = s.getPresetId();
        if (cortim$processor == null || !preset.equals(cortim$currentPreset)) {
            try {
                cortim$processor = mc.getShaderLoader()
                        .loadPostEffect(Identifier.of("cortim", preset),
                                DefaultFramebufferSet.MAIN_ONLY);
                cortim$currentPreset = preset;
            } catch (Throwable t) {
                return;
            }
        }

        if (cortim$processor == null) return;

        try {
            // pool теперь — прямое поле через @Shadow, не reflection
            cortim$processor.render(mc.getFramebuffer(), this.pool);
        } catch (Throwable t) {
            System.out.println("[CORTIM-SAT] render FAILED: " + t);
        }
    }
}