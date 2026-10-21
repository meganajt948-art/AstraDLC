package dev.dj.cortim.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import dev.dj.cortim.Cortim;
import dev.dj.cortim.module.Ambience;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.state.WorldRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {

    @Shadow private WorldRenderState worldRenderState;

    // ─── твой существующий код для NoRender — оставь здесь как было ───

    @Inject(method = "renderSky", at = @At("HEAD"), require = 0)
    private void cortim$skyColor(FrameGraphBuilder builder, Camera camera,
                                 GpuBufferSlice fogBuffer, CallbackInfo ci) {
        Ambience a = Cortim.getAmbience();
        if (a == null || !a.isEnabled() || !a.isWorldColorEnabled()) return;
        if (worldRenderState == null || worldRenderState.skyRenderState == null) return;

        int rgb = a.getWorldColor() & 0xFFFFFF;
        worldRenderState.skyRenderState.skyColor = 0xFF000000 | rgb;
    }
}