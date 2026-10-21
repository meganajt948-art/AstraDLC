/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_10017
 *  net.minecraft.class_10042
 *  net.minecraft.class_10055
 *  net.minecraft.class_11658
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_634
 *  net.minecraft.class_640
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.Theme;
import a.MobEsp;
import a.HealthBar;
import a.svi;
import a.TextSegmenter;
import a.svy;
import a.swb;
import a.SceneCapture;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.Easing;
import a.vek;
import a.Icon;
import a.IconRenderer;
import a.FormatUtil;
import a.Lang;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_10055;
import net.minecraft.class_11658;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_634;
import net.minecraft.class_640;
import net.minecraft.class_9779;

public final class HealthBars {
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
    private static final class_1304[] sxh = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166, class_1304.field_6173, class_1304.field_6171};
    private static final int sxi = 14;
    private static final float[] sxj = HealthBars.sxq();
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

    private HealthBars() {
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        if (class_310.method_1551().field_1755 instanceof ClickGuiScreen) {
            return;
        }
        DrawUtil.beginFrame();
        HealthBars.sxu(class_3322, class_97792.method_60637(true));
    }

    public static void renderInMenu(class_332 class_3322) {
        HealthBars.sxu(class_3322, class_310.method_1551().method_61966().method_60637(true));
    }

    public static void hideVanilla(class_11658 class_116582) {
        HealthBar rjy2 = HealthBar.get();
        class_310 class_3102 = class_310.method_1551();
        if (rjy2 == null || !rjy2.isEnabled() || class_3102.field_1687 == null) {
            return;
        }
        boolean bl = rjy2.mobs.get() && HealthBars.sxr();
        for (class_10017 class_100172 : class_116582.field_61735) {
            if (class_100172 instanceof class_10055) {
                class_1657 class_16572;
                class_1297 class_12972;
                class_10055 class_100552 = (class_10055)class_100172;
                if ((class_100552.field_53337 != null || class_100552.field_53525 != null) && (class_12972 = class_3102.field_1687.method_8469(class_100552.field_53528)) instanceof class_1657 && rjy2.shows(class_3102, class_16572 = (class_1657)class_12972)) {
                    class_100552.field_53337 = null;
                    class_100552.field_53525 = null;
                    continue;
                }
            }
            if (!bl || class_100172.field_53337 == null || !(class_100172 instanceof class_10042) || class_100172 instanceof class_10055 || !HealthBars.sxs(class_100172)) continue;
            class_100172.field_53337 = null;
        }
    }

    private static boolean sxr() {
        for (svy svy2 : sxm.values()) {
            if (!svy2.mob) continue;
            return true;
        }
        return false;
    }

    private static boolean sxs(class_10017 class_100172) {
        for (svy svy2 : sxm.values()) {
            if (!svy2.mob || svy2.player.method_5864() != class_100172.field_58171) continue;
            double d = svy2.player.method_23317() - class_100172.field_53325;
            double d2 = svy2.player.method_23321() - class_100172.field_53327;
            double d3 = svy2.player.method_23318() - class_100172.field_53326;
            if (!(d * d + d3 * d3 + d2 * d2 < 1.0)) continue;
            return true;
        }
        return false;
    }

    private static boolean sxt(HealthBar rjy2, class_310 class_3102, class_1309 class_13092) {
        if (class_13092 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_13092;
            return rjy2.shows(class_3102, class_16572);
        }
        MobEsp rhs2 = MobEsp.get();
        return rhs2 != null && rjy2.showsMob(class_3102, class_13092) && rhs2.picks((class_1297)class_13092);
    }

    private static void sxu(class_332 class_3322, float f) {
        Object object;
        Object object2;
        class_1309 class_13092;
        Object object322;
        ScreenProjection usn2;
        class_310 class_3102 = class_310.method_1551();
        HealthBar rjy2 = HealthBar.get();
        if (rjy2 == null || !rjy2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842) {
            sxm.clear();
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == sxn) {
            return;
        }
        sxn = FrameDelta.frame();
        float f2 = FrameDelta.delta() * (float)Theme.ANIMATION.get();
        Theme.update(f2);
        float f3 = class_3322.method_51421();
        float f4 = class_3322.method_51443();
        try {
            usn2 = ScreenProjection.capture(f, f3, f4);
        }
        catch (Throwable throwable) {
            return;
        }
        sxm.values().removeIf(svy2 -> svy2.player.method_31481() || class_3102.field_1687.method_8469(svy2.player.method_5628()) != svy2.player);
        for (Object object322 : class_3102.field_1687.method_18456()) {
            if (!rjy2.shows(class_3102, (class_1657)object322)) continue;
            sxm.computeIfAbsent(object322.method_5628(), arg_0 -> HealthBars.lambda$draw$1((class_1657)object322, arg_0));
        }
        if (rjy2.mobs.get() && MobEsp.get() != null) {
            for (Object object322 : class_3102.field_1687.method_18112()) {
                if (!(object322 instanceof class_1309)) continue;
                class_13092 = (class_1309)object322;
                if (object322 instanceof class_1657 || !HealthBars.sxt(rjy2, class_3102, class_13092)) continue;
                sxm.computeIfAbsent(class_13092.method_5628(), n -> new svy(class_13092));
            }
        }
        Iterator iterator = new ArrayList();
        object322 = new ArrayList();
        for (Map.Entry<Integer, svy> object4 : sxm.entrySet()) {
            object2 = object4.getValue();
            object = ((svy)object2).player;
            class_243 class_2432 = object.method_30950(f);
            double d = class_2432.field_1352;
            double d2 = class_2432.field_1351 + (double)object.method_17682() + 0.3;
            double d3 = class_2432.field_1350;
            boolean bl = HealthBars.sxt(rjy2, class_3102, object);
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
        class_13092 = object322.iterator();
        while (class_13092.hasNext()) {
            Integer n2 = (Integer)class_13092.next();
            sxm.remove(n2);
        }
        if (iterator.isEmpty()) {
            return;
        }
        iterator.sort((svy2, svy3) -> Double.compare(svy3.distance, svy2.distance));
        HealthBars.sxv(iterator);
        class_13092 = null;
        if (rjy2.glass() && SceneCapture.TAGS.capture(class_3322, rjy2.blur.getInt(), null)) {
            class_13092 = SceneCapture.TAGS.result(class_3322);
        }
        float f6 = Math.max(1, class_3102.method_22683().method_4495());
        object2 = iterator.iterator();
        while (object2.hasNext()) {
            object = (svy)object2.next();
            if (object.folded) continue;
            HealthBars.sxx(class_3322, class_3102, rjy2, (svy)object, (GpuTextureView)class_13092, f2, f6);
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
            svy2.crowdText = svy2.crowd > 1 ? "×" + svy2.crowd : null;
        }
    }

    private static float sxw(HealthBar rjy2, double d) {
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
    private static void sxx(class_332 class_3322, class_310 class_3102, HealthBar rjy2, svy svy2, GpuTextureView gpuTextureView, float f, float f2) {
        int n;
        class_1309 class_13092 = svy2.player;
        step = HealthBars.stepFor(HealthBars.sxw(rjy2, svy2.distance));
        float f3 = sxj[step];
        long l = class_3102.field_1687.method_75260();
        svy2.info(class_3102, l);
        boolean bl = rjy2.friends.get() && svy2.friend;
        List<svi> list = svy2.name(l);
        boolean bl2 = svy2.reading.unknown();
        HealthBars.syd(svy2, svy2.reading.fraction(), f);
        int n2 = bl2 ? -1258291201 : HealthBars.healthColor(svy2.health.get());
        String string = svy2.hpLabel;
        String string2 = svy2.absText;
        String string3 = rjy2.distance.get() ? svy2.distance(svy2.distance) : null;
        int n3 = rjy2.ping.get() ? svy2.ping : -1;
        String string4 = n3 >= 0 ? svy2.pingText : null;
        List<Object> list2 = rjy2.items.is("Off") ? List.of() : svy2.gear;
        boolean bl3 = rjy2.items.is("Inline") && !list2.isEmpty();
        boolean bl4 = rjy2.showsHealthBar();
        if (svy2.widthStep != step || svy2.widthTick != l) {
            svy2.widthStep = step;
            svy2.widthTick = l;
            svy2.nameW = TextSegmenter.width(list, NAME, NAME_BOLD);
            svy2.hpTextW = NAME.width(string) + (string2 != null ? 2.0f + sxk.width(string2) : 0.0f) + 5.0f;
        }
        float f4 = svy2.nameW;
        float f5 = rjy2.showsHealthText() ? svy2.hpTextW : 0.0f;
        int n4 = n = svy2.mob && MobEsp.get() != null ? MobEsp.get().colorOf((class_1297)class_13092) : 0;
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
        float f15 = Easing.outCubic(f14);
        float f16 = f14 * (class_13092.method_5767() ? 0.55f : 1.0f);
        float f17 = (float)Math.round(svy2.screen[0] * f2) / f2;
        float f18 = (float)Math.round(svy2.screen[1] * f2) / f2;
        float f19 = f3 * (0.86f + 0.14f * f15);
        float f20 = (bl3 || list2.isEmpty() ? f11 : f11 - 2.0f - 10.0f) - 2.0f;
        float f21 = f18 + (1.0f - f15) * 4.0f;
        if (f17 + (f10 - 2.0f) * f19 > (float)class_3322.method_51421() || f17 - (f10 - 2.0f) * f19 < 0.0f || f21 + f20 * f19 > (float)class_3322.method_51443() || f21 + 4.0f * f19 < 0.0f) {
            return;
        }
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f17, f18 + (1.0f - f15) * 4.0f);
        class_3322.method_51448().scale(f19, f19);
        DrawUtil.pushAlpha(f16);
        try {
            float f22;
            boolean bl5 = rjy2.background.is("None");
            HealthBars.sxy(class_3322, rjy2, gpuTextureView, f10, f11, f7, f9, f13);
            int n5 = ColorUtil.withAlpha(0, bl5 ? 170 : 110);
            if (bl) {
                HealthBars.sxz(class_3322, f10 + 2.6f, f12);
            } else if (n != 0) {
                DrawUtil.circle(class_3322, f10 + 5.5f + 2.4f, f12, 2.4f, n);
            }
            float f23 = f10 + f6;
            f23 = TextSegmenter.draw(class_3322, list, f23, f12, NAME, NAME_BOLD, n5);
            if (string5 != null) {
                f23 += 3.6000001f;
                f23 = sxk.draw(class_3322, string5, f23, sxk.centerTop(f12), n != 0 ? n : -1258291201);
            }
            if (f5 > 0.0f) {
                f22 = NAME.capHeight() + 4.2f;
                DrawUtil.round(class_3322, f23 += 4.5f, f12 - f22 * 0.5f, f5, f22, Math.min(f22 * 0.5f, 2.6f), ColorUtil.withAlpha(n2, 44));
                float f24 = f23 + 2.5f;
                float f25 = NAME.centerTop(f12);
                NAME.draw(class_3322, string, f24 + 0.55f, f25 + 0.55f, n5);
                f24 = NAME.draw(class_3322, string, f24, f25, n2);
                if (string2 != null) {
                    sxk.draw(class_3322, string2, f24 + 2.0f, sxk.centerTop(f12), -670639);
                }
                f23 += f5;
            }
            if (string3 != null) {
                f23 += 4.5f;
                f23 = sxk.draw(class_3322, string3, f23, sxk.centerTop(f12), -1258291201);
            }
            if (string4 != null) {
                f23 += 3.6000001f;
                f23 = sxk.draw(class_3322, string4, f23, sxk.centerTop(f12), HealthBars.syf(n3));
            }
            if (bl3) {
                HealthBars.sya(class_3322, list2, f23 += 4.5f, f12 - 5.0f, f16);
            } else if (!list2.isEmpty()) {
                f22 = (float)list2.size() * 10.0f + (float)(list2.size() - 1) * 1.4f;
                HealthBars.sya(class_3322, list2, -f22 * 0.5f, f11 - 2.0f - 10.0f, f16);
            }
            if (bl4) {
                HealthBars.syb(class_3322, svy2, f10 + f13 * 0.5f + 2.0f, -2.5f, f7 - f13 - 4.0f, bl2);
            }
        }
        finally {
            DrawUtil.popAlpha();
            class_3322.method_51448().popMatrix();
        }
    }

    /*
     * Exception decompiling
     */
    private static void sxy(class_332 var0, HealthBar var1_1, GpuTextureView var2_2, float var3_3, float var4_4, float var5_5, float var6_6, float var7_7) {
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

    private static void sxz(class_332 class_3322, float f, float f2) {
        float f3 = f2 - 4.5f;
        float f4 = f + 4.5f;
        float f5 = 4.5f;
        DrawUtil.shadow(class_3322, f, f3 + 0.6f, 9.0f, 9.0f, f5, 3.2f, ColorUtil.withAlpha(-15368131, 150));
        DrawUtil.gradientV(class_3322, f, f3, 9.0f, 9.0f, f5, -11870592, -15368131);
        DrawUtil.outlineGradientV(class_3322, f, f3, 9.0f, 9.0f, f5, 0.6f, -2130706433, 0x10FFFFFF);
        HealthBars.syc(class_3322, Icon.FRIEND_BADGE, f4, f2 + 0.45f, 6.2999997f, 1342516758);
        HealthBars.syc(class_3322, Icon.FRIEND_BADGE, f4, f2 + 0.1f, 6.2999997f, -1);
    }

    private static void sya(class_332 class_3322, List<class_1799> list, float f, float f2, float f3) {
        float f4 = 0.625f * Math.min(1.0f, f3 * 2.5f);
        for (class_1799 class_17992 : list) {
            float f5;
            if (f4 > 0.02f) {
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f + 5.0f, f2 + 5.0f);
                class_3322.method_51448().scale(f4, f4);
                class_3322.method_51427(class_17992, -8, -8);
                class_3322.method_51448().popMatrix();
            }
            if (class_17992.method_7963() && class_17992.method_7986() && class_17992.method_7936() > 0) {
                float f6 = 1.0f - (float)class_17992.method_7919() / (float)class_17992.method_7936();
                f5 = 8.0f;
                DrawUtil.round(class_3322, f + 1.0f, f2 + 10.0f + 0.6f, f5, 1.1f, 0.55f, 0x66000000);
                DrawUtil.round(class_3322, f + 1.0f, f2 + 10.0f + 0.6f, Math.max(1.1f, f5 * f6), 1.1f, 0.55f, HealthBars.healthColor(f6));
            }
            if (class_17992.method_7947() > 1) {
                String string = String.valueOf(class_17992.method_7947());
                f5 = f + 10.0f + 0.8f - sxl.width(string);
                float f7 = sxl.centerTop(f2 + 10.0f - 1.4f);
                sxl.draw(class_3322, string, f5 + 0.5f, f7 + 0.5f, -1073741824);
                sxl.draw(class_3322, string, f5, f7, -1);
            }
            f += 11.4f;
        }
    }

    private static void syb(class_332 class_3322, svy svy2, float f, float f2, float f3, boolean bl) {
        DrawUtil.round(class_3322, f, f2, f3, 1.4f, 0.7f, 0x30FFFFFF);
        if (bl) {
            return;
        }
        float f4 = svy2.health.get();
        float f5 = svy2.trail.get();
        if (f5 > f4 + 0.002f) {
            DrawUtil.round(class_3322, f, f2, Math.max(1.4f, f3 * f5), 1.4f, 0.7f, ColorUtil.withAlpha(-1096636, 150));
        }
        DrawUtil.round(class_3322, f, f2, Math.max(1.4f, f3 * f4), 1.4f, 0.7f, HealthBars.healthColor(f4));
    }

    private static void syc(class_332 class_3322, Icon vhz2, float f, float f2, float f3, int n) {
        float f4 = sxj[step];
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(1.0f / f4, 1.0f / f4);
        IconRenderer.draw(class_3322, vhz2, f * f4, f2 * f4, f3 * f4, n);
        class_3322.method_51448().popMatrix();
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
            return ColorUtil.lerp(-340971, -11870592, (f - 0.75f) / 0.25f);
        }
        if (f >= 0.5f) {
            return ColorUtil.lerp(-38357, -340971, (f - 0.5f) / 0.25f);
        }
        return ColorUtil.lerp(-1096636, -38357, Math.max(0.0f, f) / 0.5f);
    }

    private static int sye(class_310 class_3102, class_1657 class_16572) {
        class_634 class_6342 = class_3102.method_1562();
        class_640 class_6402 = class_6342 != null ? class_6342.method_2871(class_16572.method_5667()) : null;
        return class_6402 != null ? class_6402.method_2959() : -1;
    }

    private static int syf(int n) {
        return n < 80 ? -11870592 : (n < 160 ? -340971 : -1096636);
    }

    private static String syg(double d) {
        String string = Lang.unit("m");
        return d < 10.0 ? FormatUtil.fixed(d, 1) + string : Math.round(d) + string;
    }

    private static /* synthetic */ svy lambda$draw$1(class_1657 class_16572, Integer n) {
        return new svy((class_1309)class_16572);
    }

    private static /* synthetic */ int chp(int n, int n2) {
        return n - n2 | 0x725BC1F4;
    }

    private static /* synthetic */ int chq(int n, int n2) {
        return HealthBars.chp(n, n2) ^ 0x36FC6E00;
    }
}

