/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.hlc;
import a.iov;
import a.kfa;
import a.kfe;
import a.rhs;
import a.unf;
import a.uut;
import a.vcj;
import a.vdn;
import a.veo;
import a.vkl;
import a.vla;
import a.vmc;
import a.wap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class qyk
extends kfe {
    private static qyk qyl;
    private final vmc qym = this.add(new vmc("Range", 64.0, 8.0, 256.0, 8.0).suffix("m"));
    private final vmc qyn = this.add(new vmc("Radius", 44.0, 20.0, 140.0, 2.0));
    private final vmc qyo = this.add(new vmc("Size", 1.0, 0.6, 1.8, 0.05).percent());
    private final vla qyp = this.add(new vla("Color", "Theme"));
    private final vkl qyq = this.add(new vkl("Friends", true));
    private final vla qyr = this.add(new vla("Friend color", "Mint"));
    private final vkl qys = this.add(new vkl("Distance", false));
    private final vkl qyt = this.add(new vkl("Mobs", false));
    private final vmc qyu = this.add(new vmc("Mob range", 64.0, 8.0, 256.0, 8.0).suffix("m"));
    private static final vdn qyv;
    private final Map<Integer, vcj> qyw = new HashMap<Integer, vcj>();
    private final Set<Integer> qyx = new HashSet<Integer>();
    private long qyy = -1L;
    private static /* synthetic */ long qyz;
    private static /* synthetic */ long qza;

    public qyk() {
        super(new String(new char[]{'A', 'r', 'r', 'o', 'w', 's'}), "Arrows pointing at players and mobs around you", kfa.RENDER);
        qyl = this;
        this.qyr.visibleWhen(this.qyq::get);
        this.qyu.visibleWhen(this.qyt::get);
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        qyk qyk2 = qyl;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (qyk2 == null || !qyk2.isEnabled() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            if (qyk2 != null) {
                qyk2.qyw.clear();
            }
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == qyk2.qyy) {
            return;
        }
        qyk2.qyy = unf.frame();
        qyk2.qzb(drawContext, minecraftClient, renderTickCounter.method_60637(true), unf.delta());
    }

    private void qzb(DrawContext drawContext, MinecraftClient minecraftClient, float f, float f2) {
        Camera camera = minecraftClient.field_1773.method_19418();
        Vec3d vec3d = camera.method_71156();
        float f3 = camera.method_19330();
        float f4 = (float)drawContext.method_51421() * 0.5f;
        float f5 = (float)drawContext.method_51443() * 0.5f;
        double d = this.qym.get();
        float f6 = (float)this.qyo.get();
        iov.update(f2);
        uut.beginFrame();
        this.qyx.clear();
        for (PlayerEntity playerEntity : minecraftClient.field_1687.method_18456()) {
            boolean bl;
            if (playerEntity == minecraftClient.field_1724 || playerEntity == minecraftClient.method_1560() || playerEntity.method_7325() || !playerEntity.method_5805() || (bl = hhf.isFriend((Entity)playerEntity)) && !this.qyq.get()) continue;
            int n = bl ? this.qyr.color() : this.qyp.color();
            this.qzc(drawContext, (Entity)playerEntity, f, vec3d, f3, f4, f5, d, f6, f2, n);
        }
        rhs rhs2 = rhs.get();
        if (this.qyt.get() && rhs2 != null) {
            double d2 = this.qyu.get();
            double d3 = (d2 + 4.0) * (d2 + 4.0);
            for (Entity entity : minecraftClient.field_1687.method_18112()) {
                if (entity == minecraftClient.method_1560() || !(entity.method_5707(vec3d) <= d3) || !rhs2.picks(entity)) continue;
                this.qzc(drawContext, entity, f, vec3d, f3, f4, f5, d2, f6, f2, rhs2.colorOf(entity));
            }
        }
        this.qyw.keySet().retainAll(this.qyx);
    }

    private void qzc(DrawContext drawContext, Entity entity, float f, Vec3d vec3d, float f2, float f3, float f4, double d, float f5, float f6, int n2) {
        Vec3d vec3d2 = entity.method_30950(f);
        double d2 = vec3d2.field_1352 - vec3d.field_1352;
        double d3 = vec3d2.field_1350 - vec3d.field_1350;
        double d4 = Math.sqrt(d2 * d2 + d3 * d3 + (vec3d2.field_1351 - vec3d.field_1351) * (vec3d2.field_1351 - vec3d.field_1351));
        vcj vcj2 = this.qyw.computeIfAbsent(entity.method_5628(), n -> new vcj(10.0f));
        this.qyx.add(entity.method_5628());
        float f7 = vcj2.step(d4 <= d, f6);
        if (f7 <= 0.01f) {
            return;
        }
        double d5 = Math.toRadians(Math.toDegrees(Math.atan2(d3, d2)) - 90.0 - (double)f2);
        float f8 = (float)Math.max(0.25, 1.0 - d4 / Math.max(1.0, d));
        qyk.qzd(drawContext, f3, f4, (float)d5, (float)this.qyn.get(), f5, n2 | 0xFF000000, f7 * (0.45f + 0.55f * f8));
        if (this.qys.get()) {
            String string = Math.round(d4) + wap.unit("m");
            float f9 = (float)this.qyn.get() + 10.0f * f5;
            float f10 = f3 + (float)Math.sin(d5) * f9;
            float f11 = f4 - (float)Math.cos(d5) * f9;
            float f12 = qyv.width(string);
            uut.pushAlpha(f7);
            qyv.draw(drawContext, string, f10 - f12 * 0.5f + 0.5f, qyv.centerTop(f11) + 0.5f, -1946157056);
            qyv.draw(drawContext, string, f10 - f12 * 0.5f, qyv.centerTop(f11), -419430401);
            uut.popAlpha();
        }
    }

    private static void qzd(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f, f2);
        drawContext.method_51448().rotate(f3);
        drawContext.method_51448().translate(0.0f, -f4);
        uut.pushAlpha(f6);
        float f7 = 5.2f * f5;
        float f8 = 4.2f * f5;
        float f9 = 1.8f * f5;
        uut.shadow(drawContext, -f7, -f8, f7 * 2.0f, f8 * 2.0f, f8, 3.0f * f5, 0x46000000);
        uut.line(drawContext, -f7, f8 * 0.5f, 0.0f, -f8 * 0.5f, f9, n);
        uut.line(drawContext, f7, f8 * 0.5f, 0.0f, -f8 * 0.5f, f9, n);
        uut.popAlpha();
        drawContext.method_51448().popMatrix();
    }

    static {
        qyv = veo.semibold(5.6f);
    }

    private static /* synthetic */ int bwr(int n, int n2) {
        return n * n2 | 0xB0F61228;
    }
}

