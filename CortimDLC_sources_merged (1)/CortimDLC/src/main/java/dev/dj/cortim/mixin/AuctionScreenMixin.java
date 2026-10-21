package dev.dj.cortim.mixin;

import dev.dj.cortim.module.AuctionHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public abstract class AuctionScreenMixin {

    @Shadow protected int x;
    @Shadow protected int y;

    @Inject(method = "render", at = @At("TAIL"))
    private void cortim$auctionHighlight(DrawContext ctx, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!((Object) this instanceof GenericContainerScreen gs)) return;
        AuctionHelper.render(ctx, this.x, this.y, gs.getScreenHandler());
    }
}