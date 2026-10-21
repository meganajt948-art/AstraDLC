package dev.dj.cortim.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoRender;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.hud.bar.Bar;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    private static NoRender nr() {
        return (NoRender) ModuleRegistry.byName("NoRender");
    }

    private static boolean on(java.util.function.Supplier<Boolean> flag) {
        NoRender n = nr();
        return n != null && n.isEnabled() && flag.get();
    }

    @Inject(method = "renderVignetteOverlay", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$vignette(DrawContext context, Entity entity, CallbackInfo ci) {
        if (on(nr()::vignette_get)) ci.cancel();
    }

    @Inject(method = "renderScoreboardSidebar", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$scoreboard(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (on(nr()::scoreboard_get)) ci.cancel();
    }

    @Inject(method = "renderStatusEffectOverlay", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$effects(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (on(nr()::effects_get)) ci.cancel();
    }

    @Inject(method = "renderAirBubbles", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$airBubbles(DrawContext context, PlayerEntity player, int x, int y, int height, CallbackInfo ci) {
        if (on(nr()::bubbles_get)) ci.cancel();
    }

    @Inject(method = "renderBossBarHud", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$bossBar(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (on(nr()::bossBar_get)) ci.cancel();
    }

    @Inject(method = "renderNauseaOverlay", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$nausea(DrawContext context, float delta, CallbackInfo ci) {
        if (on(nr()::nausea_get)) ci.cancel();
    }

    @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$portal(DrawContext context, float delta, CallbackInfo ci) {
        if (on(nr()::nausea_get)) ci.cancel();
    }

    @Inject(method = "renderOverlay", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$renderOverlay(DrawContext ctx, Identifier texture, float opacity, CallbackInfo ci) {
        NoRender n = nr();
        if (n == null || !n.isEnabled()) return;
        if (texture == null) return;

        String path = texture.getPath();
        if (path.contains("powder_snow") && n.snowFrost_get()) {
            ci.cancel();
        }
    }

    @Redirect(method = "renderMainHud",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/bar/Bar;renderBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"),
            require = 0)
    private void cortim$xpBar(Bar bar, DrawContext ctx, RenderTickCounter tick) {
        NoRender n = nr();
        if (n != null && n.isEnabled() && n.xpBottles_get()) return;
        bar.renderBar(ctx, tick);
    }

    @Redirect(method = "renderMainHud",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/bar/Bar;drawExperienceLevel(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/font/TextRenderer;I)V"),
            require = 0)
    private void cortim$xpLevel(DrawContext ctx, TextRenderer tr, int level) {
        NoRender n = nr();
        if (n != null && n.isEnabled() && n.xpBottles_get()) return;
        Bar.drawExperienceLevel(ctx, tr, level);
    }

    @ModifyExpressionValue(
            method = "drawHeart",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud$HeartType;getTexture(ZZZ)Lnet/minecraft/util/Identifier;"),
            require = 0)
    private Identifier cortim$witherHeartTexture(Identifier original) {
        NoRender n = nr();
        if (n == null || !n.isEnabled() || !n.witherHearts_get()) return original;
        if (original == null) return null;

        String path = original.getPath();
        if (!path.contains("withered")) return original;

        String replaced = path
                .replace("withered_full_blinking", "full_blinking")
                .replace("withered_half_blinking", "half_blinking")
                .replace("withered_full", "full")
                .replace("withered_half", "half");

        return Identifier.ofVanilla(replaced);
    }
}