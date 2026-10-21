/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10003
 *  net.minecraft.class_10017
 *  net.minecraft.class_10038
 *  net.minecraft.class_10055
 *  net.minecraft.class_10426
 *  net.minecraft.class_11658
 *  net.minecraft.class_310
 *  net.minecraft.class_4063
 *  net.minecraft.class_4066
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.OptionOverride;
import flow.dev.StringDecryptor;
import java.util.Iterator;
import net.minecraft.class_10003;
import net.minecraft.class_10017;
import net.minecraft.class_10038;
import net.minecraft.class_10055;
import net.minecraft.class_10426;
import net.minecraft.class_11658;
import net.minecraft.class_310;
import net.minecraft.class_4063;
import net.minecraft.class_4066;

public class FpsLimiter
extends Module {
    private final ModeSetting luc = this.add(new ModeSetting("Frame limit", "Unlimited", "Unlimited", "Monitor", "Game"));
    private final BoolSetting lud = this.add(new BoolSetting("No vsync", true));
    private final BoolSetting lue = this.add(new BoolSetting("No entity shadows", true));
    private final BoolSetting luf = this.add(new BoolSetting("No clouds", true));
    private final BoolSetting lug = this.add(new BoolSetting("Fewer particles", true));
    private final BoolSetting luh = this.add(new BoolSetting("No biome blend", true));
    private final BoolSetting lui = this.add(new BoolSetting("No menu blur", true));
    private final BoolSetting luj = this.add(new BoolSetting("No improved transparency", true));
    private final BoolSetting luk = this.add(new BoolSetting("Fewer far entities", true));
    private final BoolSetting lul = this.add(new BoolSetting("Light far players", true));
    private final NumberSetting lum = this.add(new NumberSetting("Light from", 24.0, 8.0, 64.0, 4.0).suffix("blocks"));
    private final BoolSetting lun = this.add(new BoolSetting("Hide far displays", true));
    private final NumberSetting luo = this.add(new NumberSetting("Displays up to", 32.0, 8.0, 96.0, 4.0).suffix("blocks"));
    private final BoolSetting lup = this.add(new BoolSetting("Fast leaves", false));
    private final BoolSetting luq = this.add(new BoolSetting("No smooth lighting", false));
    private static FpsLimiter lur;
    private static final OptionOverride<Integer> lus;
    private static final OptionOverride<Boolean> lut;
    private static final OptionOverride<Boolean> luu;
    private static final OptionOverride<class_4063> luv;
    private static final OptionOverride<class_4066> luw;
    private static final OptionOverride<Integer> lux;
    private static final OptionOverride<Integer> luy;
    private static final OptionOverride<Boolean> luz;
    private static final OptionOverride<Double> lva;
    private static final OptionOverride<Boolean> lvb;
    private static final OptionOverride<Boolean> lvc;
    private static final int lvd = 260;
    private int lve = -1;
    private int lvf = -1;
    private Boolean lvg;
    private static final OptionOverride<?>[] lvh;
    private static /* synthetic */ boolean lvi;
    private static /* synthetic */ long lvj;

    public FpsLimiter() {
        super("Optimization", "More FPS: uncaps frames, heavy effects off", ModuleCategory.MISC);
        lur = this;
        this.lum.visibleWhen(this.lul::get);
        this.luo.visibleWhen(this.lun::get);
        this.setEnabled(true);
    }

    public static void afterExtraction(class_11658 class_116582) {
        FpsLimiter lub2 = lur;
        if (lub2 == null || !lub2.isEnabled() || class_116582 == null) {
            return;
        }
        boolean bl = lub2.lul.get();
        boolean bl2 = lub2.lun.get();
        if (!bl && !bl2) {
            return;
        }
        double d = lub2.lum.get() * lub2.lum.get();
        double d2 = lub2.luo.get() * lub2.luo.get();
        class_310 class_3102 = class_310.method_1551();
        int n = class_3102.field_1724 != null ? class_3102.field_1724.method_5628() : Integer.MIN_VALUE;
        Iterator iterator = class_116582.field_61735.iterator();
        while (iterator.hasNext()) {
            class_10017 class_100172 = (class_10017)iterator.next();
            if (bl2 && class_100172.field_53332 > d2 && (class_100172 instanceof class_10038 || class_100172 instanceof class_10003)) {
                iterator.remove();
                continue;
            }
            if (!bl || !(class_100172.field_53332 > d) || !(class_100172 instanceof class_10426)) continue;
            class_10426 class_104262 = (class_10426)class_100172;
            if (class_100172 instanceof class_10055) {
                class_10055 class_100552 = (class_10055)class_100172;
                if (class_100552.field_53528 == n) continue;
            }
            class_104262.field_55305.method_65605();
            class_104262.field_55307.method_65605();
            class_104262.field_53467.method_65605();
        }
    }

    private static void lvk() {
        for (OptionOverride<?> wbu2 : lvh) {
            wbu2.release();
        }
    }

    @Override
    protected void onDisable() {
        FpsLimiter.lvk();
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null && class_3102.field_1690 != null) {
            this.lvm(class_3102);
            if (this.lve >= 0 && this.lve != FpsLimiter.lvl()) {
                FpsLimiter.lvn(class_3102);
            }
        }
        this.lve = -1;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        int n;
        boolean bl = OptionOverride.suspended(class_3102);
        if (bl) {
            FpsLimiter.lvk();
            this.lvm(class_3102);
            return;
        }
        int n2 = n = class_3102.method_22683() != null ? class_3102.method_22683().method_22092() : 0;
        if (this.luc.is("Unlimited")) {
            FpsLimiter.lvo(lus, true, 260);
        } else {
            FpsLimiter.lvo(lus, this.luc.is("Monitor") && n >= 30, Math.max(30, Math.min(260, n)));
        }
        FpsLimiter.lvo(lut, this.lud.get() || this.luc.is("Unlimited"), false);
        FpsLimiter.lvo(luu, this.lue.get(), false);
        FpsLimiter.lvo(luv, this.luf.get(), class_4063.field_18162);
        FpsLimiter.lvo(luw, this.lug.get() && luw.own() == class_4066.field_18197, class_4066.field_18198);
        FpsLimiter.lvo(luy, this.lui.get(), 0);
        Double d = lva.own();
        FpsLimiter.lvo(lva, this.luk.get() && d != null && d > 0.75, 0.75);
        FpsLimiter.lvo(lux, this.luh.get(), 0);
        FpsLimiter.lvo(luz, this.luj.get(), false);
        FpsLimiter.lvo(lvb, this.lup.get(), false);
        FpsLimiter.lvo(lvc, this.luq.get(), false);
        this.lvm(class_3102);
        int n3 = (Boolean.TRUE.equals(class_3102.field_1690.method_75337().method_41753()) ? 1 : 0) | (Boolean.TRUE.equals(class_3102.field_1690.method_75334().method_41753()) ? 2 : 0) | (Boolean.TRUE.equals(class_3102.field_1690.method_41792().method_41753()) ? 4 : 0);
        if (this.lve < 0) {
            this.lve = FpsLimiter.lvl();
        }
        if (n3 != this.lve) {
            FpsLimiter.lvn(class_3102);
            this.lve = n3;
        }
    }

    private static int lvl() {
        return (Boolean.TRUE.equals(luz.own()) ? 1 : 0) | (Boolean.TRUE.equals(lvb.own()) ? 2 : 0) | (Boolean.TRUE.equals(lvc.own()) ? 4 : 0);
    }

    private void lvm(class_310 class_3102) {
        Boolean bl;
        Integer n = (Integer)class_3102.field_1690.method_42524().method_41753();
        if (n != null && n != this.lvf) {
            this.lvf = n;
            class_3102.method_61964().method_61938(n.intValue());
        }
        if ((bl = (Boolean)class_3102.field_1690.method_42433().method_41753()) != null && !bl.equals(this.lvg) && class_3102.method_22683() != null) {
            this.lvg = bl;
            class_3102.method_22683().method_4497(bl.booleanValue());
        }
    }

    private static void lvn(class_310 class_3102) {
        if (class_3102.field_1769 != null && class_3102.field_1687 != null) {
            class_3102.field_1769.method_3279();
        }
    }

    private static <T> void lvo(OptionOverride<T> wbu2, boolean bl, T t) {
        if (bl) {
            wbu2.override(t);
        } else {
            wbu2.release();
        }
    }

    static {
        lus = new OptionOverride(class_3102 -> class_3102.field_1690.method_42524());
        lut = new OptionOverride(class_3102 -> class_3102.field_1690.method_42433());
        luu = new OptionOverride(class_3102 -> class_3102.field_1690.method_42435());
        luv = new OptionOverride(class_3102 -> class_3102.field_1690.method_42528());
        luw = new OptionOverride(class_3102 -> class_3102.field_1690.method_42475());
        lux = new OptionOverride(class_3102 -> class_3102.field_1690.method_41805());
        luy = new OptionOverride(class_3102 -> class_3102.field_1690.method_57702());
        luz = new OptionOverride(class_3102 -> class_3102.field_1690.method_75337());
        lva = new OptionOverride(class_3102 -> class_3102.field_1690.method_42517());
        lvb = new OptionOverride(class_3102 -> class_3102.field_1690.method_75334());
        lvc = new OptionOverride(class_3102 -> class_3102.field_1690.method_41792());
        lvh = new OptionOverride[]{lus, lut, luu, luv, luw, lux, luy, luz, lva, lvb, lvc};
    }

    private static /* synthetic */ int azn(int n, int n2) {
        return n ^ n2 | 0x8037E1F2;
    }
}

