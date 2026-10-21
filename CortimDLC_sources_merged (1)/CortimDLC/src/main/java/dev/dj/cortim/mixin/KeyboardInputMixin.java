package dev.dj.cortim.mixin;

import dev.dj.cortim.module.Freecam;
import dev.dj.cortim.util.Dbg;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.Vec2f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin {

    /** Пока активен Freecam: обнуляем ввод движения, чтобы тело игрока стояло на месте. */
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void cortim$freecamStop(CallbackInfo ci) {
        if (!Freecam.active) return;

        Dbg.every("kbd", 1000, "kbd neutral");

        InputAccessorMixin in = (InputAccessorMixin) (Object) this;
        in.cortim$setPlayerInput(PlayerInput.DEFAULT);
        in.cortim$setMovementVector(Vec2f.ZERO);
        ci.cancel();
    }
}