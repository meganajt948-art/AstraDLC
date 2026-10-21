package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityGlowingMixin {

    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable = true)
    private void cortim$noGlowing(CallbackInfoReturnable<Boolean> cir) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n != null && n.isEnabled() && n.glowing_get()) {
            cir.setReturnValue(false);
        }
    }
}