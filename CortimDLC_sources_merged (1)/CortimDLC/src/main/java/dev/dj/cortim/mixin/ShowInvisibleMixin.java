package dev.dj.cortim.mixin;

import dev.dj.cortim.module.ShowInvisible;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ShowInvisibleMixin {

    /**
     * Ванильный рендер рисует невидимого игрока как полупрозрачного призрака,
     * если для зрителя он «не невидим» (так видят спектаторы и союзники по команде).
     * Подсказываем ему, что невидимые игроки для нас именно такие.
     */
    @Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$showInvisible(PlayerEntity viewer, CallbackInfoReturnable<Boolean> cir) {
        if (!ShowInvisible.active()) return;
        if ((Object) this instanceof PlayerEntity target && target != viewer) {
            cir.setReturnValue(false);
        }
    }
}