/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.item.Items
 */
package a;

import a.iov;
import a.kfe;
import a.rxa;
import a.ujt;
import a.unf;
import a.uut;
import a.vcj;
import a.vdn;
import a.veo;
import flow.Flow;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.Items;

public final class rhf {
    private static final vdn rhg = veo.semibold(6.0f);
    private static final vcj rhh = new vcj(10.0f);
    private static final vcj rhi = new vcj(12.0f);
    private static final vcj rhj = new vcj(6.0f);
    private static long rhk = -1L;
    private static float rhl;
    private static /* synthetic */ String rhm;
    private static /* synthetic */ long rhn;

    private rhf() {
    }

    private static boolean rho() {
        if (Flow.getInstance().getModuleManager() == null) {
            return false;
        }
        for (kfe kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            rxa rxa2;
            if (!(kfe2 instanceof rxa) || !(rxa2 = (rxa)kfe2).maceCharge()) continue;
            return true;
        }
        return false;
    }

    static float smashBonus(double d) {
        if (d <= 1.5) {
            return 0.0f;
        }
        if (d <= 3.0) {
            return (float)(4.0 * d);
        }
        if (d <= 8.0) {
            return (float)(12.0 + 2.0 * (d - 3.0));
        }
        return (float)(22.0 + (d - 8.0));
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.options.hudHidden || minecraftClient.currentScreen != null || !minecraftClient.options.getPerspective().isFirstPerson()) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rhk) {
            return;
        }
        rhk = unf.frame();
        float f = unf.delta();
        boolean bl = clientPlayerEntity.getMainHandStack().isOf(Items.MACE) && rhf.rho();
        float f2 = renderTickCounter.getTickProgress(true);
        float f3 = bl ? clientPlayerEntity.getAttackCooldownProgress(f2) : 1.0f;
        double d = clientPlayerEntity.fallDistance;
        boolean bl2 = bl && !clientPlayerEntity.isOnGround() && !clientPlayerEntity.isGliding() && d > 1.5;
        rhl = f3 >= 0.999f ? rhl + f : 0.0f;
        boolean bl3 = bl && (f3 < 0.999f || rhl < 0.6f || bl2);
        float f4 = rhh.step(bl3, f);
        float f5 = rhi.step(bl2, f);
        float f6 = rhj.step(f3 >= 0.999f, f);
        if (f4 <= 0.01f) {
            return;
        }
        uut.beginFrame();
        float f7 = (float)drawContext.getScaledWindowWidth() * 0.5f;
        float f8 = (float)drawContext.getScaledWindowHeight() * 0.5f;
        float f9 = 11.0f;
        int n = ujt.lerp(iov.accent() | 0xFF000000, -11443, f5);
        uut.pushAlpha(f4);
        uut.arc(drawContext, f7, f8, f9, 1.6f, 0.0f, 1.0f, 0x40FFFFFF);
        uut.arc(drawContext, f7, f8, f9, 1.6f, 0.0f, Math.max(0.001f, f3), n);
        float f10 = Math.max(f6 * (1.0f - Math.min(1.0f, rhl / 0.6f)), f5);
        if (f10 > 0.02f) {
            uut.additive(true);
            uut.shadow(drawContext, f7 - f9, f8 - f9, f9 * 2.0f, f9 * 2.0f, f9, 5.0f, ujt.withAlpha(n, Math.round(70.0f * f10)));
            uut.additive(false);
        }
        if (f5 > 0.02f) {
            float f11 = rhf.smashBonus(d);
            float f12 = Math.min(1.0f, f11 / 22.0f);
            uut.pushAlpha(f5);
            uut.arc(drawContext, f7, f8, f9 + 3.2f, 1.2f, 0.0f, Math.max(0.001f, f12), ujt.withAlpha(-5720, 230));
            String string = "+" + Math.round(f11);
            rhg.drawCentered(drawContext, string, f7, rhg.centerTop(f8 + f9 + 9.0f), -8054);
            uut.popAlpha();
        }
        uut.popAlpha();
    }

    private static /* synthetic */ int byq(int n, int n2) {
        return n + n2 ^ 0xB5AE2AA3;
    }

    private static /* synthetic */ int byr(int n, int n2) {
        return n * n2 | 0xB0850162;
    }
}

