package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.render.WorldBorderRendering;
import net.minecraft.client.render.state.WorldBorderRenderState;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldBorderRendering.class)
public class WorldBorderRenderingMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$noBorder(WorldBorderRenderState state, Vec3d pos,
                                 double viewDistance, double tickDelta,
                                 CallbackInfo ci) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n != null && n.isEnabled() && n.barrier_get()) {
            ci.cancel();
        }
    }
}