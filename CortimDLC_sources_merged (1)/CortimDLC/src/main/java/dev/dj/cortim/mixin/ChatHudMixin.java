package dev.dj.cortim.mixin;

import dev.dj.cortim.module.Enchancer;
import dev.dj.cortim.module.ModuleRegistry;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChatHud.class)
public class ChatHudMixin {

    @ModifyConstant(method = "addVisibleMessage", constant = @Constant(intValue = 100), require = 0)
    private int cortim$infiniteChat(int original) {
        Enchancer e = (Enchancer) ModuleRegistry.byName("Enchancer");
        if (e != null && e.isEnabled() && e.infiniteChat()) return 16384;
        return original;
    }
}