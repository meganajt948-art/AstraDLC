package dev.dj.cortim.mixin;

import dev.dj.cortim.module.Enchancer;
import dev.dj.cortim.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugHud.class)
public class DebugHudMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true, require = 0)
    private void cortim$cleanF3(DrawContext ctx, CallbackInfo ci) {
        Enchancer e = (Enchancer) ModuleRegistry.byName("Enchancer");
        if (e == null || !e.isEnabled() || !e.cleanF3.get()) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        // если F3 не нажат — не вмешиваемся
        if (!mc.getDebugHud().shouldShowDebugHud()) return;

        ci.cancel();
        renderCompact(ctx);
    }

    private void renderCompact(DrawContext ctx) {
        var mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        var tr = mc.textRenderer;
        int y = 4;
        int x = 4;
        String[] lines = {
                "FPS: " + mc.getCurrentFps(),
                "XYZ: " + (int) mc.player.getX() + " " + (int) mc.player.getY() + " " + (int) mc.player.getZ(),
                "Ping: " + (mc.getNetworkHandler() != null && mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()) != null
                        ? mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()).getLatency() : 0) + "ms"
        };
        for (String s : lines) {
            ctx.drawTextWithShadow(tr, s, x, y, 0xFFFFFFFF);
            y += 10;
        }
    }
}