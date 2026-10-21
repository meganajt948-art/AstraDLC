package dev.dj.cortim.mixin;

import dev.dj.cortim.module.FakePlayer;
import dev.dj.cortim.module.ModuleRegistry;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerInteractionManager.class)
public class FakePlayerMixin {

    @Inject(method = "attackEntity", at = @At("HEAD"), cancellable = true)
    private void cortim$attackFake(PlayerEntity player, Entity target, CallbackInfo ci) {
        FakePlayer fp = (FakePlayer) ModuleRegistry.byName("FakePlayer");
        if (fp == null || !fp.isEnabled()) return;

        Entity fake = fp.getEntity();
        if (fake == null) return;

        if (target == fake) {
            // не отправляем пакет на сервер
            // но swingHand уже сделает клиент в TriggerBot
            ci.cancel();
            return;
        }
    }
}