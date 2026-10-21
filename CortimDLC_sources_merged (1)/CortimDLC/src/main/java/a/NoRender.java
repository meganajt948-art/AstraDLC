/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_11400
 *  net.minecraft.class_11401
 *  net.minecraft.class_11658
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1802
 *  net.minecraft.class_2394
 *  net.minecraft.class_2940
 *  net.minecraft.class_310
 *  net.minecraft.class_4061
 *  net.minecraft.class_638
 *  net.minecraft.class_7283
 *  net.minecraft.class_7284
 *  net.minecraft.class_746
 *  net.minecraft.class_758
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.rkc;
import a.BoolSetting;
import a.Reflect;
import a.OptionOverride;
import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.class_10017;
import net.minecraft.class_11400;
import net.minecraft.class_11401;
import net.minecraft.class_11658;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1802;
import net.minecraft.class_2394;
import net.minecraft.class_2940;
import net.minecraft.class_310;
import net.minecraft.class_4061;
import net.minecraft.class_638;
import net.minecraft.class_7283;
import net.minecraft.class_7284;
import net.minecraft.class_746;
import net.minecraft.class_758;

public class NoRender
extends Module {
    private static NoRender rki;
    public final BoolSetting fire = this.add(new BoolSetting("Fire", true));
    public final BoolSetting lava = this.add(new BoolSetting("Lava", true));
    public final BoolSetting scoreboard = this.add(new BoolSetting("Scoreboard", false));
    public final BoolSetting hurtShake = this.add(new BoolSetting("Hurt shake", true));
    public final BoolSetting walkShake = this.add(new BoolSetting("View bobbing", false));
    public final BoolSetting darkness = this.add(new BoolSetting("Darkness", true));
    public final BoolSetting blindness = this.add(new BoolSetting("Blindness", false));
    public final BoolSetting nausea = this.add(new BoolSetting("Nausea", true));
    public final BoolSetting attackIndicator = this.add(new BoolSetting("Attack indicator", false));
    public final BoolSetting effects = this.add(new BoolSetting("Effects", false));
    public final BoolSetting bossBar = this.add(new BoolSetting("Boss bar", false));
    public final BoolSetting bubbles = this.add(new BoolSetting("Bubbles", false));
    public final BoolSetting glowing = this.add(new BoolSetting("Glowing", false));
    public final BoolSetting rain = this.add(new BoolSetting("Rain", false));
    public final BoolSetting vignette = this.add(new BoolSetting("Vignette", true));
    public final BoolSetting pumpkin = this.add(new BoolSetting("Pumpkin", true));
    private static final OptionOverride<Double> rkj;
    private static final OptionOverride<Boolean> rkk;
    private static final OptionOverride<class_4061> rkl;
    private static final OptionOverride<Double> rkm;
    private static boolean rkn;
    private static class_2940<List<class_2394>> rko;
    private static boolean rkp;
    private static /* synthetic */ boolean rkq;
    private static /* synthetic */ int rkr;

    public NoRender() {
        super(new String(new char[]{'N', 'o', 'R', 'e', 'n', 'd', 'e', 'r'}), "Hides effects and HUD parts you pick", ModuleCategory.RENDER);
        rki = this;
    }

    private static boolean rks(BoolSetting vkl2) {
        return rki != null && rki.isEnabled() && vkl2.get();
    }

    public static boolean hidesScoreboard() {
        return rki != null && NoRender.rks(NoRender.rki.scoreboard);
    }

    public static boolean hidesBossBar() {
        return rki != null && NoRender.rks(NoRender.rki.bossBar);
    }

    public static boolean hidesAir() {
        return rki != null && NoRender.rks(NoRender.rki.bubbles);
    }

    public static boolean hidesEffectIcons() {
        return rki != null && NoRender.rks(NoRender.rki.effects);
    }

    public static boolean hidesPumpkin(class_310 class_3102) {
        return rki != null && NoRender.rks(NoRender.rki.pumpkin) && class_3102.field_1724 != null && class_3102.field_1690.method_31044().method_31034() && class_3102.field_1724.method_6118(class_1304.field_6169).method_31574(class_1802.field_17519);
    }

    @Override
    protected void onEnable() {
        NoRender.rkx();
    }

    @Override
    protected void onDisable() {
        rkj.release();
        rkk.release();
        rkl.release();
        rkm.release();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        if (this.effects.get()) {
            NoRender.rkw(class_3102.field_1687);
        }
        this.rkt(class_3102);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        this.rkt(class_3102);
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        if (this.fire.get()) {
            NoRender.rkv(class_3102);
        }
    }

    private void rkt(class_310 class_3102) {
        NoRender.rkx();
        boolean bl = OptionOverride.suspended(class_3102);
        NoRender.rku(rkj, this.hurtShake.get() && !bl, 0.0);
        NoRender.rku(rkk, this.walkShake.get() && !bl, false);
        NoRender.rku(rkl, this.attackIndicator.get() && !bl, class_4061.field_18151);
        NoRender.rku(rkm, this.darkness.get() && !bl, 0.0);
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        if (this.fire.get()) {
            NoRender.rkv(class_3102);
        }
        if (this.nausea.get()) {
            class_7462.field_44911 = 0.0f;
            class_7462.field_44912 = 0.0f;
        }
        if (this.rain.get() && class_3102.field_1687 != null) {
            class_3102.field_1687.method_8519(0.0f);
            class_3102.field_1687.method_8496(0.0f);
        }
        if (this.vignette.get()) {
            class_3102.field_1705.field_2013 = 0.0f;
        }
    }

    private static <T> void rku(OptionOverride<T> wbu2, boolean bl, T t) {
        if (bl) {
            wbu2.override(t);
        } else {
            wbu2.release();
        }
    }

    private static void rkv(class_310 class_3102) {
        if (class_3102.field_1724 != null && class_3102.field_1724.method_5809()) {
            class_3102.field_1724.method_33572(false);
        }
    }

    private static void rkw(class_638 class_6382) {
        if (class_6382 == null) {
            return;
        }
        if (!rkp) {
            rkp = true;
            Field field = Reflect.find(class_1309.class, "net.minecraft.class_1309", "field_49792", "Lnet/minecraft/class_2940;");
            try {
                rko = field == null ? null : (class_2940)field.get(null);
            }
            catch (ReflectiveOperationException | RuntimeException exception) {
                rko = null;
            }
        }
        if (rko == null) {
            return;
        }
        for (class_1297 class_12972 : class_6382.method_18112()) {
            class_1309 class_13092;
            if (!(class_12972 instanceof class_1309) || ((List)(class_13092 = (class_1309)class_12972).method_5841().method_12789(rko)).isEmpty()) continue;
            class_13092.method_5841().method_12778(rko, List.of());
        }
    }

    public static void afterExtraction(class_11658 class_116582) {
        if (rki == null || !NoRender.rks(NoRender.rki.glowing)) {
            return;
        }
        for (class_10017 class_100172 : class_116582.field_61735) {
            class_100172.field_61821 = 0;
        }
    }

    private static void rkx() {
        if (rkn) {
            return;
        }
        rkn = true;
        try {
            Field field = Reflect.find(class_758.class, "net.minecraft.class_758", "field_60586", "Ljava/util/List;");
            if (field == null) {
                return;
            }
            List list = (List)field.get(null);
            for (int i = 0; i < list.size(); ++i) {
                class_11400 class_114002 = (class_11400)list.get(i);
                if (class_114002 instanceof class_11401) {
                    list.set(i, new rkc(class_114002, () -> rki != null && NoRender.rks(NoRender.rki.lava)));
                    continue;
                }
                if (class_114002 instanceof class_7283) {
                    list.set(i, new rkc(class_114002, () -> rki != null && NoRender.rks(NoRender.rki.blindness)));
                    continue;
                }
                if (!(class_114002 instanceof class_7284)) continue;
                list.set(i, new rkc(class_114002, () -> rki != null && NoRender.rks(NoRender.rki.darkness)));
            }
        }
        catch (Throwable throwable) {
            System.out.println("fog rules can't be changed: " + throwable);
        }
    }

    static {
        rkj = new OptionOverride(class_3102 -> class_3102.field_1690.method_48974());
        rkk = new OptionOverride(class_3102 -> class_3102.field_1690.method_42448());
        rkl = new OptionOverride(class_3102 -> class_3102.field_1690.method_42565());
        rkm = new OptionOverride(class_3102 -> class_3102.field_1690.method_42472());
    }

    private static /* synthetic */ int bzl(int n, int n2) {
        return n ^ n2 | 0x420899D6;
    }
}

