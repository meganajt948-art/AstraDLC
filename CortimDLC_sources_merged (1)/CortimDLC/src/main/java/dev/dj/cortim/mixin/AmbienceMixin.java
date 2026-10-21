package dev.dj.cortim.mixin;

import dev.dj.cortim.Cortim;
import dev.dj.cortim.module.Ambience;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public abstract class AmbienceMixin {

    @Inject(method = "getTimeOfDay", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$timeOfDay(CallbackInfoReturnable<Long> cir) {
        // только клиентский мир — сервер не трогаем
        if (!((Object)this instanceof net.minecraft.client.world.ClientWorld)) return;

        Ambience a = Cortim.getAmbience();
        if (a == null || !a.isEnabled() || !a.isTimeEnabled()) return;
        cir.setReturnValue(a.getTimeOfDay());
    }
}