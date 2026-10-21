package dev.dj.cortim.mixin;

import dev.dj.cortim.CortimConfig;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SimpleOption.class)
public class SimpleOptionMixin {

    @ModifyArg(
            method = "of",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/option/SimpleOption;of(Ljava/lang/String;Lnet/minecraft/client/option/SimpleOption$TooltipFactory;Lnet/minecraft/client/option/SimpleOption$ValueSet;Lnet/minecraft/client/option/SimpleOption$Callbacks;Ljava/lang/Object;)Lnet/minecraft/client/option/SimpleOption;"),
            index = 4,
            require = 0
    )
    private static Object cortim$gammaMax(Object original) {
        if (CortimConfig.brightnessEnabled && original instanceof Double d) {
            if (d == 1.0D) return 10.0D;
        }
        return original;
    }
}