/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.LivingEntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hlc;
import a.iov;
import a.rhs;
import a.rjy;
import a.svi;
import a.svp;
import a.svy;
import a.swb;
import a.uij;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vcq;
import a.vek;
import a.vhz;
import a.vjf;
import a.vxu;
import a.wap;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public final class swh {
    private static final float swi = 5.5f;
    private static final float swj = 4.5f;
    private static final float swk = 14.0f;
    private static final float swl = 12.5f;
    private static final float swm = 10.0f;
    private static final float swn = 1.4f;
    private static final float swo = 9.0f;
    private static final float swp = 3.0f;
    private static final float swq = 2.6f;
    private static final float swr = 2.4f;
    private static final float sws = 56.0f;
    private static final float swt = 16.0f;
    private static final float swu = 1.4f;
    private static final float swv = 2.4f;
    private static final double sww = 8.0;
    private static final float swx = 0.3f;
    private static final double swy = 0.3;
    private static final int swz = -11870592;
    private static final int sxa = -340971;
    private static final int sxb = -38357;
    private static final int sxc = -1096636;
    private static final int sxd = -670639;
    private static final int sxe = -11870592;
    private static final int sxf = -15368131;
    private static final int sxg = -1258291201;
    private static final EquipmentSlot[] sxh = new EquipmentSlot[]{EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166, EquipmentSlot.field_6173, EquipmentSlot.field_6171};
    private static final int sxi = 14;
    private static final float[] sxj = swh.sxq();
    static int step = 14;
    static final swb NAME = new swb(vek.SEMIBOLD, 7.4f);
    static final swb NAME_BOLD = new swb(vek.BOLD, 7.4f);
    private static final swb sxk = new swb(vek.MEDIUM, 5.4f);
    private static final swb sxl = new swb(vek.BOLD, 5.2f);
    private static final Map<Integer, svy> sxm = new HashMap<Integer, svy>();
    private static long sxn = -1L;
    private static /* synthetic */ long sxo;
    private static /* synthetic */ boolean sxp;

    private static float[] sxq() {
        float[] fArray = new float[26];
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = (float)Math.pow(2.0, (double)(i - 14) / 8.0);
        }
        fArray[14] = 1.0f;
        return fArray;
    }

    private swh() {
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        if (MinecraftClient.method_1551().field_1755 instanceof hlc) {
            return;
        }
        uut.beginFrame();
        swh.sxu(drawContext, renderTickCounter.method_60637(true));
    }

    public static void renderInMenu(DrawContext drawContext) {
        swh.sxu(drawContext, MinecraftClient.method_1551().method_61966().method_60637(true));
    }

    public static void hideVanilla(WorldRenderState worldRenderState) {
        rjy rjy2 = rjy.get();
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rjy2 == null || !rjy2.isEnabled() || minecraftClient.field_1687 == null) {
            return;
        }
        boolean bl = rjy2.mobs.get() && swh.sxr();
        for (EntityRenderState entityRenderState : worldRenderState.field_61735) {
            if (entityRenderState instanceof PlayerEntityRenderState) {
                PlayerEntity playerEntity;
                Entity entity;
                PlayerEntityRenderState playerEntityRenderState = (PlayerEntityRenderState)entityRenderState;
                if ((playerEntityRenderState.field_53337 != null || playerEntityRenderState.field_53525 != null) && (entity = minecraftClient.field_1687.method_8469(playerEntityRenderState.field_53528)) instanceof PlayerEntity && rjy2.shows(minecraftClient, playerEntity = (PlayerEntity)entity)) {
                    playerEntityRenderState.field_53337 = null;
                    playerEntityRenderState.field_53525 = null;
                    continue;
                }
            }
            if (!bl || entityRenderState.field_53337 == null || !(entityRenderState instanceof LivingEntityRenderState) || entityRenderState instanceof PlayerEntityRenderState || !swh.sxs(entityRenderState)) continue;
            entityRenderState.field_53337 = null;
        }
    }

    private static boolean sxr() {
        for (svy svy2 : sxm.values()) {
            if (!svy2.mob) continue;
            return true;
        }
        return false;
    }

    private static boolean sxs(EntityRenderState entityRenderState) {
        for (svy svy2 : sxm.values()) {
            if (!svy2.mob || svy2.player.method_5864() != entityRenderState.field_58171) continue;
            double d = svy2.player.method_23317() - entityRenderState.field_53325;
            double d2 = svy2.player.method_23321() - entityRenderState.field_53327;
            double d3 = svy2.player.method_23318() - entityRenderState.field_53326;
            if (!(d * d + d3 * d3 + d2 * d2 < 1.0)) continue;
            return true;
        }
        return false;
    }

    private static boolean sxt(rjy rjy2, MinecraftClient minecraftClient, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)livingEntity;
            return rjy2.shows(minecraftClient, playerEntity);
        }
        rhs rhs2 = rhs.get();
        return rhs2 != null && rjy2.showsMob(minecraftClient, livingEntity) && rhs2.picks((Entity)livingEntity);
    }

    private static void sxu(DrawContext drawContext, float f) {
        Object object;
        Object object2;
        LivingEntity livingEntity;
        Object object322;
        usn usn2;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        rjy rjy2 = rjy.get();
        if (rjy2 == null || !rjy2.isEnabled() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842) {
            sxm.clear();
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == sxn) {
            return;
        }
        sxn = unf.frame();
        float f2 = unf.delta() * (float)iov.ANIMATION.get();
        iov.update(f2);
        float f3 = drawContext.method_51421();
        float f4 = drawContext.method_51443();
        try {
            usn2 = usn.capture(f, f3, f4);
        }
        catch (Throwable throwable) {
            return;
        }
        sxm.values().removeIf(svy2 -> svy2.player.method_31481() || minecraftClient.field_1687.method_8469(svy2.player.method_5628()) != svy2.player);
        for (Object object322 : minecraftClient.field_1687.method_18456()) {
            if (!rjy2.shows(minecraftClient, (PlayerEntity)object322)) continue;
            sxm.computeIfAbsent(object322.method_5628(), arg_0 -> swh.lambda$draw$1((PlayerEntity)object322, arg_0));
        }
        if (rjy2.mobs.get() && rhs.get() != null) {
            for (Object object322 : minecraftClient.field_1687.method_18112()) {
                if (!(object322 instanceof LivingEntity)) continue;
                livingEntity = (LivingEntity)object322;
                if (object322 instanceof PlayerEntity || !swh.sxt(rjy2, minecraftClient, livingEntity)) continue;
                sxm.computeIfAbsent(livingEntity.method_5628(), n -> new svy(livingEntity));
            }
        }
        Iterator iterator = new ArrayList();
        object322 = new ArrayList();
        for (Map.Entry<Integer, svy> object4 : sxm.entrySet()) {
            object2 = object4.getValue();
            object = ((svy)object2).player;
            Vec3d vec3d = object.method_30950(f);
            double d = vec3d.field_1352;
            double d2 = vec3d.field_1351 + (double)object.method_17682() + 0.3;
            double d3 = vec3d.field_1350;
            boolean bl = swh.sxt(rjy2, minecraftClient, object);
            boolean bl2 = usn2.project(d, d2, d3, ((svy)object2).screen);
            float f5 = ((svy)object2).shown.step(bl && bl2, f2);
            if (f5 <= 0.004f) {
                if (bl) continue;
                object322.add(object4.getKey());
                continue;
            }
            if (!bl2) continue;
            ((svy)object2).distance = usn2.distance(d, d2, d3);
            iterator.add((Object)object2);
        }
        livingEntity = object322.iterator();
        while (livingEntity.hasNext()) {
            Integer n2 = (Integer)livingEntity.next();
            sxm.remove(n2);
        }
        if (iterator.isEmpty()) {
            return;
        }
        iterator.sort((svy2, svy3) -> Double.compare(svy3.distance, svy2.distance));
        swh.sxv(iterator);
        livingEntity = null;
        if (rjy2.glass() && uij.TAGS.capture(drawContext, rjy2.blur.getInt(), null)) {
            livingEntity = uij.TAGS.result(drawContext);
        }
        float f6 = Math.max(1, minecraftClient.method_22683().method_4495());
        object2 = iterator.iterator();
        while (object2.hasNext()) {
            object = (svy)object2.next();
            if (object.folded) continue;
            swh.sxx(drawContext, minecraftClient, rjy2, (svy)object, (GpuTextureView)livingEntity, f2, f6);
        }
        step = 14;
    }

    private static void sxv(List<svy> list) {
        for (svy svy2 : list) {
            svy2.crowd = 1;
            svy2.folded = false;
        }
        block1: for (int i = list.size() - 1; i >= 0; --i) {
            svy svy2;
            svy2 = list.get(i);
            if (!svy2.mob || svy2.player.method_16914()) continue;
            for (int j = list.size() - 1; j > i; --j) {
                svy svy3 = list.get(j);
                if (!svy3.mob || svy3.folded || svy3.player.method_5864() != svy2.player.method_5864() || svy3.player.method_16914() || !(Math.abs(svy3.screen[0] - svy2.screen[0]) < 56.0f) || !(Math.abs(svy3.screen[1] - svy2.screen[1]) < 16.0f)) continue;
                svy2.folded = true;
                ++svy3.crowd;
                continue block1;
            }
        }
        for (svy svy2 : list) {
            if (svy2.crowd == svy2.crowdShown) continue;
            svy2.crowdShown = svy2.crowd;
            svy2.crowdText = svy2.crowd > 1 ? a.c(1988123643, "\u5b2d") + svy2.crowd : null;
        }
    }

    private static float sxw(rjy rjy2, double d) {
        float f = (float)Math.max((double)0.3f, Math.min(1.0, 8.0 / Math.max(0.1, d)));
        float f2 = (float)rjy2.shrink.get();
        return (float)rjy2.size.get() * (1.0f - f2 * (1.0f - f));
    }

    static float stepScale() {
        return sxj[step];
    }

    static int stepFor(float f) {
        double d = Math.log(Math.max(0.01f, f)) / Math.log(2.0) * 8.0;
        return Math.max(0, Math.min(sxj.length - 1, (int)Math.round(d) + 14));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void sxx(DrawContext drawContext, MinecraftClient minecraftClient, rjy rjy2, svy svy2, GpuTextureView gpuTextureView, float f, float f2) {
        int n;
        LivingEntity livingEntity = svy2.player;
        step = swh.stepFor(swh.sxw(rjy2, svy2.distance));
        float f3 = sxj[step];
        long l = minecraftClient.field_1687.method_75260();
        svy2.info(minecraftClient, l);
        boolean bl = rjy2.friends.get() && svy2.friend;
        List<svi> list = svy2.name(l);
        boolean bl2 = svy2.reading.unknown();
        swh.syd(svy2, svy2.reading.fraction(), f);
        int n2 = bl2 ? -1258291201 : swh.healthColor(svy2.health.get());
        String string = svy2.hpLabel;
        String string2 = svy2.absText;
        String string3 = rjy2.distance.get() ? svy2.distance(svy2.distance) : null;
        int n3 = rjy2.ping.get() ? svy2.ping : -1;
        String string4 = n3 >= 0 ? svy2.pingText : null;
        List<Object> list2 = rjy2.items.is(a.b("\u87de\ufe46\u7495", 754091922)) ? List.of() : svy2.gear;
        boolean bl3 = rjy2.items.is(a.d("\u4fe8\u367e\ubcaf\u22db\ua90b\u2fb1", -683901274, -1671155455)) && !list2.isEmpty();
        boolean bl4 = rjy2.showsHealthBar();
        if (svy2.widthStep != step || svy2.widthTick != l) {
            svy2.widthStep = step;
            svy2.widthTick = l;
            svy2.nameW = svp.width(list, NAME, NAME_BOLD);
            svy2.hpTextW = NAME.width(string) + (string2 != null ? 2.0f + sxk.width(string2) : 0.0f) + 5.0f;
        }
        float f4 = svy2.nameW;
        float f5 = rjy2.showsHealthText() ? svy2.hpTextW : 0.0f;
        int n4 = n = svy2.mob && rhs.get() != null ? rhs.get().colorOf((Entity)livingEntity) : 0;
        float f6 = bl ? 14.6f : (n != 0 ? 13.3f : 5.5f);
        String string5 = svy2.crowdText;
        float f7 = f6 + f4;
        if (string5 != null) {
            f7 += 3.6000001f + sxk.width(string5);
        }
        if (f5 > 0.0f) {
            f7 += 4.5f + f5;
        }
        if (string3 != null) {
            f7 += 4.5f + sxk.width(string3);
        }
        if (string4 != null) {
            f7 += 3.6000001f + sxk.width(string4);
        }
        if (bl3) {
            f7 += 4.5f + (float)list2.size() * 10.0f + (float)(list2.size() - 1) * 1.4f;
        }
        float f8 = bl3 ? 14.0f : 12.5f;
        float f9 = f8 + (bl4 ? 2.4f : 0.0f);
        float f10 = -(f7 += 5.5f) * 0.5f;
        float f11 = -f9;
        float f12 = f11 + f8 * 0.5f;
        float f13 = f9 * 0.5f * (float)rjy2.rounding.get();
        float f14 = svy2.shown.get();
        float f15 = vcq.outCubic(f14);
        float f16 = f14 * (livingEntity.method_5767() ? 0.55f : 1.0f);
        float f17 = (float)Math.round(svy2.screen[0] * f2) / f2;
        float f18 = (float)Math.round(svy2.screen[1] * f2) / f2;
        float f19 = f3 * (0.86f + 0.14f * f15);
        float f20 = (bl3 || list2.isEmpty() ? f11 : f11 - 2.0f - 10.0f) - 2.0f;
        float f21 = f18 + (1.0f - f15) * 4.0f;
        if (f17 + (f10 - 2.0f) * f19 > (float)drawContext.method_51421() || f17 - (f10 - 2.0f) * f19 < 0.0f || f21 + f20 * f19 > (float)drawContext.method_51443() || f21 + 4.0f * f19 < 0.0f) {
            return;
        }
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f17, f18 + (1.0f - f15) * 4.0f);
        drawContext.method_51448().scale(f19, f19);
        uut.pushAlpha(f16);
        try {
            float f22;
            boolean bl5 = rjy2.background.is(a.c(297556089, "\u5833\u21a3\uab71\u350b"));
            swh.sxy(drawContext, rjy2, gpuTextureView, f10, f11, f7, f9, f13);
            int n5 = ujt.withAlpha(0, bl5 ? 170 : 110);
            if (bl) {
                swh.sxz(drawContext, f10 + 2.6f, f12);
            } else if (n != 0) {
                uut.circle(drawContext, f10 + 5.5f + 2.4f, f12, 2.4f, n);
            }
            float f23 = f10 + f6;
            f23 = svp.draw(drawContext, list, f23, f12, NAME, NAME_BOLD, n5);
            if (string5 != null) {
                f23 += 3.6000001f;
                f23 = sxk.draw(drawContext, string5, f23, sxk.centerTop(f12), n != 0 ? n : -1258291201);
            }
            if (f5 > 0.0f) {
                f22 = NAME.capHeight() + 4.2f;
                uut.round(drawContext, f23 += 4.5f, f12 - f22 * 0.5f, f5, f22, Math.min(f22 * 0.5f, 2.6f), ujt.withAlpha(n2, 44));
                float f24 = f23 + 2.5f;
                float f25 = NAME.centerTop(f12);
                NAME.draw(drawContext, string, f24 + 0.55f, f25 + 0.55f, n5);
                f24 = NAME.draw(drawContext, string, f24, f25, n2);
                if (string2 != null) {
                    sxk.draw(drawContext, string2, f24 + 2.0f, sxk.centerTop(f12), -670639);
                }
                f23 += f5;
            }
            if (string3 != null) {
                f23 += 4.5f;
                f23 = sxk.draw(drawContext, string3, f23, sxk.centerTop(f12), -1258291201);
            }
            if (string4 != null) {
                f23 += 3.6000001f;
                f23 = sxk.draw(drawContext, string4, f23, sxk.centerTop(f12), swh.syf(n3));
            }
            if (bl3) {
                swh.sya(drawContext, list2, f23 += 4.5f, f12 - 5.0f, f16);
            } else if (!list2.isEmpty()) {
                f22 = (float)list2.size() * 10.0f + (float)(list2.size() - 1) * 1.4f;
                swh.sya(drawContext, list2, -f22 * 0.5f, f11 - 2.0f - 10.0f, f16);
            }
            if (bl4) {
                swh.syb(drawContext, svy2, f10 + f13 * 0.5f + 2.0f, -2.5f, f7 - f13 - 4.0f, bl2);
            }
        }
        finally {
            uut.popAlpha();
            drawContext.method_51448().popMatrix();
        }
    }

    /*
     * Exception decompiling
     */
    private static void sxy(DrawContext var0, rjy var1_1, GpuTextureView var2_2, float var3_3, float var4_4, float var5_5, float var6_6, float var7_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static void sxz(DrawContext drawContext, float f, float f2) {
        float f3 = f2 - 4.5f;
        float f4 = f + 4.5f;
        float f5 = 4.5f;
        uut.shadow(drawContext, f, f3 + 0.6f, 9.0f, 9.0f, f5, 3.2f, ujt.withAlpha(-15368131, 150));
        uut.gradientV(drawContext, f, f3, 9.0f, 9.0f, f5, -11870592, -15368131);
        uut.outlineGradientV(drawContext, f, f3, 9.0f, 9.0f, f5, 0.6f, -2130706433, 0x10FFFFFF);
        swh.syc(drawContext, vhz.FRIEND_BADGE, f4, f2 + 0.45f, 6.2999997f, 1342516758);
        swh.syc(drawContext, vhz.FRIEND_BADGE, f4, f2 + 0.1f, 6.2999997f, -1);
    }

    private static void sya(DrawContext drawContext, List<ItemStack> list, float f, float f2, float f3) {
        float f4 = 0.625f * Math.min(1.0f, f3 * 2.5f);
        for (ItemStack itemStack : list) {
            float f5;
            if (f4 > 0.02f) {
                drawContext.method_51448().pushMatrix();
                drawContext.method_51448().translate(f + 5.0f, f2 + 5.0f);
                drawContext.method_51448().scale(f4, f4);
                drawContext.method_51427(itemStack, -8, -8);
                drawContext.method_51448().popMatrix();
            }
            if (itemStack.method_7963() && itemStack.method_7986() && itemStack.method_7936() > 0) {
                float f6 = 1.0f - (float)itemStack.method_7919() / (float)itemStack.method_7936();
                f5 = 8.0f;
                uut.round(drawContext, f + 1.0f, f2 + 10.0f + 0.6f, f5, 1.1f, 0.55f, 0x66000000);
                uut.round(drawContext, f + 1.0f, f2 + 10.0f + 0.6f, Math.max(1.1f, f5 * f6), 1.1f, 0.55f, swh.healthColor(f6));
            }
            if (itemStack.method_7947() > 1) {
                String string = String.valueOf(itemStack.method_7947());
                f5 = f + 10.0f + 0.8f - sxl.width(string);
                float f7 = sxl.centerTop(f2 + 10.0f - 1.4f);
                sxl.draw(drawContext, string, f5 + 0.5f, f7 + 0.5f, -1073741824);
                sxl.draw(drawContext, string, f5, f7, -1);
            }
            f += 11.4f;
        }
    }

    private static void syb(DrawContext drawContext, svy svy2, float f, float f2, float f3, boolean bl) {
        uut.round(drawContext, f, f2, f3, 1.4f, 0.7f, 0x30FFFFFF);
        if (bl) {
            return;
        }
        float f4 = svy2.health.get();
        float f5 = svy2.trail.get();
        if (f5 > f4 + 0.002f) {
            uut.round(drawContext, f, f2, Math.max(1.4f, f3 * f5), 1.4f, 0.7f, ujt.withAlpha(-1096636, 150));
        }
        uut.round(drawContext, f, f2, Math.max(1.4f, f3 * f4), 1.4f, 0.7f, swh.healthColor(f4));
    }

    private static void syc(DrawContext drawContext, vhz vhz2, float f, float f2, float f3, int n) {
        float f4 = sxj[step];
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().scale(1.0f / f4, 1.0f / f4);
        vjf.draw(drawContext, vhz2, f * f4, f2 * f4, f3 * f4, n);
        drawContext.method_51448().popMatrix();
    }

    private static void syd(svy svy2, float f, float f2) {
        if (svy2.health.get() < 0.0f) {
            svy2.health.set(f);
            svy2.trail.set(f);
        }
        long l = System.currentTimeMillis();
        float f3 = svy2.health.get();
        if (f < f3 - 0.001f && svy2.trail.get() <= f3 + 0.001f) {
            svy2.trailHold = l + 350L;
            svy2.trail.set(Math.max(svy2.trail.get(), f3));
        }
        svy2.health.step(f, f2);
        if (f > svy2.trail.get() || l > svy2.trailHold) {
            svy2.trail.step(Math.max(f, svy2.health.get()), f2);
        }
    }

    static int healthColor(float f) {
        if (f >= 0.75f) {
            return ujt.lerp(-340971, -11870592, (f - 0.75f) / 0.25f);
        }
        if (f >= 0.5f) {
            return ujt.lerp(-38357, -340971, (f - 0.5f) / 0.25f);
        }
        return ujt.lerp(-1096636, -38357, Math.max(0.0f, f) / 0.5f);
    }

    private static int sye(MinecraftClient minecraftClient, PlayerEntity playerEntity) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.method_1562();
        PlayerListEntry playerListEntry = clientPlayNetworkHandler != null ? clientPlayNetworkHandler.method_2871(playerEntity.method_5667()) : null;
        return playerListEntry != null ? playerListEntry.method_2959() : -1;
    }

    private static int syf(int n) {
        return n < 80 ? -11870592 : (n < 160 ? -340971 : -1096636);
    }

    private static String syg(double d) {
        String string = wap.unit(a.b("\ubaca", 866237094));
        return d < 10.0 ? vxu.fixed(d, 1) + string : Math.round(d) + string;
    }

    private static /* synthetic */ svy lambda$draw$1(PlayerEntity playerEntity, Integer n) {
        return new svy((LivingEntity)playerEntity);
    }

    private static /* synthetic */ int chp(int n, int n2) {
        return n - n2 | 0x725BC1F4;
    }

    private static /* synthetic */ int chq(int n, int n2) {
        return swh.chp(n, n2) ^ 0x36FC6E00;
    }
}

