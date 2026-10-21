package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class EntityEffectMixin {

    private boolean cortim$isLocalPlayer() {
        var mc = MinecraftClient.getInstance();
        return mc != null && mc.player != null && mc.player == (Object) this;
    }

    @Inject(method = "hasStatusEffect", at = @At("RETURN"), cancellable = true)
    private void cortim$noVisualEffects(RegistryEntry<StatusEffect> effect, CallbackInfoReturnable<Boolean> cir) {
        if (!Boolean.TRUE.equals(cir.getReturnValue())) return;
        if (!cortim$isLocalPlayer()) return;

        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n == null || !n.isEnabled()) return;

        StatusEffect e = effect.value();
        if (n.blindness_get() && e == StatusEffects.BLINDNESS) cir.setReturnValue(false);
        if (n.nausea_get() && e == StatusEffects.NAUSEA) cir.setReturnValue(false);
        if (n.wardenDarkness_get() && e == StatusEffects.DARKNESS) cir.setReturnValue(false);
    }

    @Inject(method = "getStatusEffect", at = @At("RETURN"), cancellable = true)
    private void cortim$noVisualStatusEffect(RegistryEntry<StatusEffect> effect,
                                             CallbackInfoReturnable<StatusEffectInstance> cir) {
        if (cir.getReturnValue() == null) return;
        if (!cortim$isLocalPlayer()) return;

        NoRender n = (NoRender) ModuleRegistry.byName("NoRender");
        if (n == null || !n.isEnabled()) return;

        StatusEffect e = effect.value();
        if (n.blindness_get() && e == StatusEffects.BLINDNESS) cir.setReturnValue(null);
        if (n.nausea_get() && e == StatusEffects.NAUSEA) cir.setReturnValue(null);
        if (n.wardenDarkness_get() && e == StatusEffects.DARKNESS) cir.setReturnValue(null);
    }
}