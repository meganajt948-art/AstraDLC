package dev.dj.cortim.mixin;

import net.minecraft.client.input.Input;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.Vec2f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Input.class)
public interface InputAccessorMixin {

    @Accessor("playerInput")
    void cortim$setPlayerInput(PlayerInput value);

    @Accessor("movementVector")
    void cortim$setMovementVector(Vec2f value);
}