/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1684
 *  net.minecraft.class_1753
 *  net.minecraft.class_1764
 *  net.minecraft.class_1771
 *  net.minecraft.class_1776
 *  net.minecraft.class_1779
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1823
 *  net.minecraft.class_1835
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3486
 *  net.minecraft.class_3532
 *  net.minecraft.class_3726
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4537
 *  net.minecraft.class_746
 *  net.minecraft.class_9278
 *  net.minecraft.class_9334
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.rmy;
import a.rnb;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.FontFace;
import a.Fonts;
import a.BoolSetting;
import a.ColorSetting;
import a.FormatUtil;
import a.Lang;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1684;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1771;
import net.minecraft.class_1776;
import net.minecraft.class_1779;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1823;
import net.minecraft.class_1835;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_3726;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4537;
import net.minecraft.class_746;
import net.minecraft.class_9278;
import net.minecraft.class_9334;
import net.minecraft.class_9779;

public class Trajectories
extends Module {
    private static Trajectories rnl;
    private final BoolSetting rnm = this.add(new BoolSetting("Pearls", true));
    private final BoolSetting rnn = this.add(new BoolSetting("Bows", true));
    private final BoolSetting rno = this.add(new BoolSetting("Tridents", true));
    private final BoolSetting rnp = this.add(new BoolSetting("Throwables", true));
    private final BoolSetting rnq = this.add(new BoolSetting("Flying pearls", true));
    private final BoolSetting rnr = this.add(new BoolSetting("Path", true));
    private final BoolSetting rns = this.add(new BoolSetting("Time", false));
    private final ColorSetting rnt = this.add(new ColorSetting("Color", "Theme"));
    private static final int rnu = 240;
    private static final FontFace rnv;
    private static final rnb rnw;
    private static final rnb rnx;
    private static final rnb rny;
    private static final rnb rnz;
    private static final float[] roa;
    private final rmy[] rob = new rmy[]{new rmy(), new rmy(), new rmy()};
    private final List<rmy> roc = new ArrayList<rmy>();
    private boolean rod;
    private int roe = 1;
    private final List<class_1684> rof = new ArrayList<class_1684>();
    private final List<class_1297> rog = new ArrayList<class_1297>();
    private final List<class_238> roh = new ArrayList<class_238>();
    private long roi = Long.MIN_VALUE;
    private rnb roj;
    private boolean rok;
    private int rol;
    private long rom = Long.MIN_VALUE;
    private class_243 ron;
    private class_243 roo;
    private float rop;
    private float roq;
    private boolean ror;
    private long ros = -1L;
    private final float[] rot = new float[2];
    private final float[] rou = new float[4];
    private final float[] rov = new float[2];
    private static /* synthetic */ long row;
    private static /* synthetic */ String rox;

    public Trajectories() {
        super(new String(new char[]{'P', 'r', 'e', 'd', 'i', 'c', 't', 'i', 'o', 'n', 's'}), "Where throws and shots will land", ModuleCategory.RENDER);
        rnl = this;
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        Trajectories rnk2 = rnl;
        class_310 class_3102 = class_310.method_1551();
        if (rnk2 == null || !rnk2.isEnabled() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rnk2.ros) {
            return;
        }
        rnk2.ros = FrameDelta.frame();
        rnk2.roy(class_3322, class_3102, class_97792.method_60637(true));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void roy(class_332 class_3322, class_310 class_3102, float f) {
        ScreenProjection usn2;
        class_746 class_7462 = class_3102.field_1724;
        long l = class_3102.field_1687.method_75260();
        if (l != this.roi) {
            this.roi = l;
            this.rpd(class_3102);
        }
        rnb rnb2 = null;
        class_1799 class_17992 = class_1799.field_8037;
        this.rod = false;
        this.roe = 1;
        for (class_1268 class_12682 : class_1268.values()) {
            class_1799 class_17993 = class_7462.method_5998(class_12682);
            rnb2 = this.rpc(class_7462, class_17993);
            if (rnb2 == null) continue;
            class_17992 = class_17993;
            break;
        }
        if (rnb2 == null && this.roc.isEmpty()) {
            return;
        }
        try {
            usn2 = ScreenProjection.capture(f, class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        DrawUtil.beginBatch();
        try {
            this.roz(class_3322, class_3102, class_7462, usn2, rnb2, f);
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    private void roz(class_332 class_3322, class_310 class_3102, class_746 class_7462, ScreenProjection usn2, rnb rnb2, float f) {
        int n = this.rnt.color() | 0xFF000000;
        for (rmy rmy2 : this.roc) {
            this.rpg(class_3322, usn2, rmy2, ColorUtil.lerp(n, -1, 0.25f), 0.7f, 0);
        }
        if (rnb2 != null) {
            class_243 class_2432 = class_7462.method_5836(f).method_1023(0.0, 0.1, 0.0);
            float f2 = class_7462.method_36455();
            float f3 = class_7462.method_36454();
            class_243 class_2433 = class_7462.method_18798();
            boolean bl = Objects.equals(rnb2, this.roj) && this.rok == this.rod && this.rol == this.roe && this.rom == this.roi && class_2432.equals((Object)this.ron) && class_2433.equals((Object)this.roo) && f2 == this.rop && f3 == this.roq && this.ror == class_7462.method_24828();
            this.roj = rnb2;
            this.rok = this.rod;
            this.rol = this.roe;
            this.rom = this.roi;
            this.ron = class_2432;
            this.roo = class_2433;
            this.rop = f2;
            this.roq = f3;
            this.ror = class_7462.method_24828();
            if (bl) {
                for (int i = 0; i < (this.rod ? this.roe : 1); ++i) {
                    this.rpg(class_3322, usn2, this.rob[i], n, i == 0 ? 1.0f : 0.85f, 3);
                }
                return;
            }
            if (this.rod) {
                class_243 class_2434 = Trajectories.rpa(f2, f3);
                class_243 class_2435 = Trajectories.rpa(f2 - 90.0f, f3);
                for (int i = 0; i < this.roe; ++i) {
                    class_243 class_2436 = Trajectories.rpb(class_2434, class_2435, roa[i] * ((float)Math.PI / 180));
                    this.rpf((class_1937)class_3102.field_1687, (class_1297)class_7462, class_2432, class_2436.method_1021(rnb2.rnc), rnb2, this.rob[i]);
                    this.rpg(class_3322, usn2, this.rob[i], n, i == 0 ? 1.0f : 0.85f, 3);
                }
            } else {
                class_243 class_2437 = Trajectories.rpe(f2 + rnb2.rng, f3, f2);
                class_243 class_2438 = class_2437.method_1021(rnb2.rnc);
                class_2438 = class_2438.method_1031(class_2433.field_1352, class_7462.method_24828() ? 0.0 : class_2433.field_1351, class_2433.field_1350);
                this.rpf((class_1937)class_3102.field_1687, (class_1297)class_7462, class_2432, class_2438, rnb2, this.rob[0]);
                this.rpg(class_3322, usn2, this.rob[0], n, 1.0f, 3);
            }
        }
    }

    private static class_243 rpa(float f, float f2) {
        float f3 = (float)Math.PI / 180;
        float f4 = f * f3;
        float f5 = -f2 * f3;
        float f6 = class_3532.method_15362((double)f5);
        float f7 = class_3532.method_15374((double)f5);
        float f8 = class_3532.method_15362((double)f4);
        float f9 = class_3532.method_15374((double)f4);
        return new class_243((double)(f7 * f8), (double)(-f9), (double)(f6 * f8));
    }

    private static class_243 rpb(class_243 class_2432, class_243 class_2433, float f) {
        if (f == 0.0f) {
            return class_2432;
        }
        double d = Math.cos(f);
        double d2 = Math.sin(f);
        class_243 class_2434 = class_2433.method_1036(class_2432);
        return class_2432.method_1021(d).method_1019(class_2434.method_1021(d2)).method_1019(class_2433.method_1021(class_2433.method_1026(class_2432) * (1.0 - d)));
    }

    private rnb rpc(class_746 class_7462, class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return null;
        }
        if (class_17992.method_7909() instanceof class_1753) {
            if (!this.rnn.get() || !class_7462.method_6115() || class_7462.method_6030() != class_17992) {
                return null;
            }
            float f = class_1753.method_7722((int)class_7462.method_6048());
            return f < 0.1f ? null : new rnb((double)f * 3.0, 0.05, 0.99, 0.6, 0.0f, true);
        }
        if (class_17992.method_7909() instanceof class_1764) {
            if (!this.rnn.get() || !class_1764.method_7781((class_1799)class_17992)) {
                return null;
            }
            class_9278 class_92782 = (class_9278)class_17992.method_58694(class_9334.field_49649);
            if (class_92782 != null && class_92782.method_57438(class_1802.field_8639)) {
                return null;
            }
            this.rod = true;
            this.roe = class_92782 != null && class_92782.method_57437().size() >= 3 ? 3 : 1;
            return new rnb(3.15, 0.05, 0.99, 0.6, 0.0f, true);
        }
        if (class_17992.method_7909() instanceof class_1835) {
            return this.rno.get() && class_7462.method_6115() && class_7462.method_6030() == class_17992 ? rnz : null;
        }
        if (class_17992.method_7909() instanceof class_1776) {
            return this.rnm.get() ? rnw : null;
        }
        if (!this.rnp.get()) {
            return null;
        }
        if (class_17992.method_7909() instanceof class_1823 || class_17992.method_7909() instanceof class_1771) {
            return rnw;
        }
        if (class_17992.method_7909() instanceof class_4537) {
            return rnx;
        }
        if (class_17992.method_7909() instanceof class_1779) {
            return rny;
        }
        return null;
    }

    private void rpd(class_310 class_3102) {
        Object object;
        this.rog.clear();
        this.roh.clear();
        this.rof.clear();
        class_238 class_2383 = class_3102.field_1724.method_5829().method_1009(96.0, 64.0, 96.0);
        for (class_1297 class_12972 : class_3102.field_1687.method_8335((class_1297)class_3102.field_1724, class_2383)) {
            if (class_12972 instanceof class_1309 && (object = (class_1309)class_12972).method_5805() && !class_12972.method_7325() && class_12972.method_5863()) {
                this.rog.add(class_12972);
                this.roh.add(class_12972.method_5829().method_1014(0.3));
                continue;
            }
            if (!(class_12972 instanceof class_1684)) continue;
            class_1684 class_16842 = (class_1684)class_12972;
            if (!this.rnq.get() || class_16842.method_31481()) continue;
            this.rof.add(class_16842);
        }
        while (this.roc.size() < this.rof.size()) {
            this.roc.add(new rmy());
        }
        while (this.roc.size() > this.rof.size()) {
            this.roc.remove(this.roc.size() - 1);
        }
        for (int i = 0; i < this.rof.size(); ++i) {
            class_1297 class_12972;
            class_12972 = this.rof.get(i);
            object = new rnb(0.0, class_12972.method_56989(), 0.99, 0.8, 0.0f, false);
            this.rpf((class_1937)class_3102.field_1687, class_12972.method_24921(), class_12972.method_73189(), class_12972.method_18798(), (rnb)object, this.roc.get(i));
        }
    }

    private static class_243 rpe(float f, float f2, float f3) {
        float f4 = (float)Math.PI / 180;
        double d = -class_3532.method_15374((double)(f2 * f4)) * class_3532.method_15362((double)(f3 * f4));
        double d2 = -class_3532.method_15374((double)(f * f4));
        double d3 = class_3532.method_15362((double)(f2 * f4)) * class_3532.method_15362((double)(f3 * f4));
        return new class_243(d, d2, d3).method_1029();
    }

    private void rpf(class_1937 class_19372, class_1297 class_12972, class_243 class_2432, class_243 class_2433, rnb rnb2, rmy rmy2) {
        rmy2.n = 0;
        rmy2.hit = class_239.class_240.field_1333;
        rmy2.entity = null;
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        double d4 = class_2433.field_1352;
        double d5 = class_2433.field_1351;
        double d6 = class_2433.field_1350;
        rmy2.add(d, d2, d3);
        boolean bl = false;
        int n = class_19372.method_31607() - 32;
        for (int i = 1; i <= 240; ++i) {
            double d7;
            if (!rnb2.rnh) {
                d7 = bl ? rnb2.rnf : rnb2.rne;
                d5 -= rnb2.rnd;
                d4 *= d7;
                d5 *= d7;
                d6 *= d7;
            }
            d7 = d + d4;
            double d8 = d2 + d5;
            double d9 = d3 + d6;
            class_243 class_2434 = new class_243(d, d2, d3);
            class_243 class_2435 = new class_243(d7, d8, d9);
            class_3965 class_39652 = class_19372.method_17742(class_12972 == null ? new class_3959(class_2434, class_2435, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, class_3726.method_16194()) : new class_3959(class_2434, class_2435, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, class_12972));
            double d10 = class_39652.method_17783() == class_239.class_240.field_1333 ? Double.MAX_VALUE : class_39652.method_17784().method_1025(class_2434);
            class_1297 class_12973 = null;
            class_243 class_2436 = null;
            double d11 = Math.min(d, d7);
            double d12 = Math.min(d2, d8);
            double d13 = Math.min(d3, d9);
            double d14 = Math.max(d, d7);
            double d15 = Math.max(d2, d8);
            double d16 = Math.max(d3, d9);
            int n2 = this.rog.size();
            for (int j = 0; j < n2; ++j) {
                double d17;
                Optional optional;
                class_1297 class_12974 = this.rog.get(j);
                if (class_12974 == class_12972 && i < 5) continue;
                class_238 class_2383 = this.roh.get(j);
                if (class_2383.field_1320 < d11 || class_2383.field_1323 > d14 || class_2383.field_1325 < d12 || class_2383.field_1322 > d15 || class_2383.field_1324 < d13 || class_2383.field_1321 > d16 || !(optional = class_2383.method_992(class_2434, class_2435)).isPresent() || !((d17 = ((class_243)optional.get()).method_1025(class_2434)) < d10)) continue;
                d10 = d17;
                class_12973 = class_12974;
                class_2436 = (class_243)optional.get();
            }
            if (class_12973 != null) {
                rmy2.hit = class_239.class_240.field_1331;
                rmy2.entity = class_12973;
                rmy2.hx = class_2436.field_1352;
                rmy2.hy = class_2436.field_1351;
                rmy2.hz = class_2436.field_1350;
                rmy2.add(class_2436.field_1352, class_2436.field_1351, class_2436.field_1350);
                rmy2.ticks = i;
                return;
            }
            if (class_39652.method_17783() != class_239.class_240.field_1333) {
                class_243 class_2437 = class_39652.method_17784();
                rmy2.hit = class_239.class_240.field_1332;
                rmy2.hx = class_2437.field_1352;
                rmy2.hy = class_2437.field_1351;
                rmy2.hz = class_2437.field_1350;
                rmy2.face = class_39652.method_17780();
                rmy2.add(class_2437.field_1352, class_2437.field_1351, class_2437.field_1350);
                rmy2.ticks = i;
                return;
            }
            d = d7;
            d2 = d8;
            d3 = d9;
            rmy2.add(d, d2, d3);
            if (rnb2.rnh) {
                double d18 = bl ? rnb2.rnf : rnb2.rne;
                d4 *= d18;
                d5 *= d18;
                d6 *= d18;
                d5 -= rnb2.rnd;
            }
            bl = class_19372.method_8316(class_2338.method_49637((double)d, (double)d2, (double)d3)).method_15767(class_3486.field_15517);
            if (!(d2 < (double)n)) continue;
            return;
        }
    }

    private void rpg(class_332 class_3322, ScreenProjection usn2, rmy rmy2, int n, float f, int n2) {
        Object object;
        if (rmy2.n < 2) {
            return;
        }
        DrawUtil.pushAlpha(f);
        if (this.rnr.get()) {
            this.rph(class_3322, usn2, rmy2, n, n2);
        }
        if (rmy2.hit == class_239.class_240.field_1332) {
            this.rpi(class_3322, usn2, rmy2.hx, rmy2.hy, rmy2.hz, rmy2.face, 0.32, n);
        } else if (rmy2.hit == class_239.class_240.field_1331 && rmy2.entity != null) {
            object = rmy2.entity.method_73189();
            int n3 = ColorUtil.lerp(n, -45730, 0.65f);
            this.rpi(class_3322, usn2, object.field_1352, object.field_1351 + 0.02, object.field_1350, class_2350.field_11036, (double)rmy2.entity.method_17681() * 0.5 + 0.25, n3);
        }
        if (this.rns.get() && rmy2.hit != class_239.class_240.field_1333 && usn2.project(rmy2.hx, rmy2.hy, rmy2.hz, this.rot)) {
            object = FormatUtil.fixed((double)rmy2.ticks / 20.0, 1) + Lang.unit("s");
            float f2 = rnv.width((String)object);
            rnv.draw(class_3322, (String)object, this.rot[0] - f2 * 0.5f + 0.5f, rnv.centerTop(this.rot[1] + 12.0f) + 0.5f, -1879048192);
            rnv.draw(class_3322, (String)object, this.rot[0] - f2 * 0.5f, rnv.centerTop(this.rot[1] + 12.0f), -268435457);
        }
        DrawUtil.popAlpha();
    }

    private void rph(class_332 class_3322, ScreenProjection usn2, rmy rmy2, int n, int n2) {
        double[] dArray = rmy2.pts;
        double d = 0.0;
        for (int i = Math.max(1, n2); i < rmy2.n; ++i) {
            double d2 = dArray[(i - 1) * 3];
            double d3 = dArray[(i - 1) * 3 + 1];
            double d4 = dArray[(i - 1) * 3 + 2];
            double d5 = dArray[i * 3];
            double d6 = dArray[i * 3 + 1];
            double d7 = dArray[i * 3 + 2];
            d += Math.sqrt((d5 - d2) * (d5 - d2) + (d6 - d3) * (d6 - d3) + (d7 - d4) * (d7 - d4));
            if (!usn2.projectSegment(d2, d3, d4, d5, d6, d7, 0.2f, this.rou, this.rov)) continue;
            float f = (float)Math.min(1.0, d / 3.0);
            float f2 = usn2.unitsPerBlock(d5, d6, d7);
            float f3 = Math.max(0.9f, Math.min(2.0f, f2 * 0.03f));
            DrawUtil.line(class_3322, this.rou[0], this.rou[1], this.rou[2], this.rou[3], f3, ColorUtil.withAlpha(n, Math.round(210.0f * f)));
        }
    }

    private void rpi(class_332 class_3322, ScreenProjection usn2, double d, double d2, double d3, class_2350 class_23502, double d4, int n) {
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13 = switch (class_23502.method_10166()) {
            case class_2350.class_2351.field_11052 -> {
                d12 = 1.0;
                d11 = 0.0;
                d10 = 0.0;
                d9 = 0.0;
                d8 = 0.0;
                yield 1.0;
            }
            case class_2350.class_2351.field_11051 -> {
                d12 = 1.0;
                d11 = 0.0;
                d10 = 0.0;
                d9 = 0.0;
                d8 = 1.0;
                yield 0.0;
            }
            default -> {
                d12 = 0.0;
                d11 = 0.0;
                d10 = 1.0;
                d9 = 0.0;
                d8 = 1.0;
                yield 0.0;
            }
        };
        float f = usn2.unitsPerBlock(d += (double)class_23502.method_10148() * 0.01, d2 += (double)class_23502.method_10164() * 0.01, d3 += (double)class_23502.method_10165() * 0.01);
        if (f <= 0.0f) {
            return;
        }
        float f2 = Math.max(1.1f, Math.min(3.2f, f * 0.05f));
        int n2 = ColorUtil.withAlpha(n, 235);
        int n3 = 36;
        double d14 = 0.0;
        double d15 = 0.0;
        double d16 = 0.0;
        for (int i = 0; i <= n3; ++i) {
            double d17 = Math.PI * 2 * (double)i / (double)n3;
            d7 = d + (Math.cos(d17) * d12 + Math.sin(d17) * d9) * d4;
            d6 = d2 + (Math.cos(d17) * d11 + Math.sin(d17) * d8) * d4;
            d5 = d3 + (Math.cos(d17) * d10 + Math.sin(d17) * d13) * d4;
            if (i > 0 && usn2.projectSegment(d14, d15, d16, d7, d6, d5, 0.1f, this.rou, this.rov)) {
                DrawUtil.line(class_3322, this.rou[0], this.rou[1], this.rou[2], this.rou[3], f2, n2);
            }
            d14 = d7;
            d15 = d6;
            d16 = d5;
        }
        double d18 = d4 * 0.7071;
        for (int i = -1; i <= 1; i += 2) {
            d7 = d + (d12 + d9 * (double)i) * d18;
            d6 = d2 + (d11 + d8 * (double)i) * d18;
            d5 = d3 + (d10 + d13 * (double)i) * d18;
            double d19 = d - (d12 + d9 * (double)i) * d18;
            double d20 = d2 - (d11 + d8 * (double)i) * d18;
            double d21 = d3 - (d10 + d13 * (double)i) * d18;
            if (!usn2.projectSegment(d7, d6, d5, d19, d20, d21, 0.1f, this.rou, this.rov)) continue;
            DrawUtil.line(class_3322, this.rou[0], this.rou[1], this.rou[2], this.rou[3], f2, n2);
        }
    }

    static {
        rnv = Fonts.semibold(6.0f);
        rnw = new rnb(1.5, 0.03, 0.99, 0.8, 0.0f, false);
        rnx = new rnb(0.5, 0.05, 0.99, 0.8, -20.0f, false);
        rny = new rnb(0.7, 0.07, 0.99, 0.8, -20.0f, false);
        rnz = new rnb(2.5, 0.05, 0.99, 0.99, 0.0f, true);
        roa = new float[]{0.0f, -10.0f, 10.0f};
    }

    private static /* synthetic */ int cak(int n, int n2) {
        return n - n2 | 0x1334211B;
    }

    private static /* synthetic */ int cal(int n, int n2) {
        return n - n2 + -287743757;
    }

    private static /* synthetic */ int cam(int n, int n2) {
        return Trajectories.cal(n, n2) ^ 0xC35EAFF3;
    }
}

