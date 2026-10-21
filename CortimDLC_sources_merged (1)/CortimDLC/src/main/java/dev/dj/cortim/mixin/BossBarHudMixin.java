package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossBarHud.class)
public class BossBarHudMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void cortim$noBossBar(DrawContext context, CallbackInfo ci) {
        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n != null && n.isEnabled() && n.bossBar_get()) ci.cancel();
    }
}