/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2761
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.NumberSetting;
import a.PacketHooks;
import java.util.Locale;
import net.minecraft.class_2596;
import net.minecraft.class_2761;
import net.minecraft.class_310;
import net.minecraft.class_638;

public class TimeChanger
extends Module {
    private static final long rde = 24000L;
    private final NumberSetting rdf = this.add(new NumberSetting("Time", 12.0, 0.0, 24.0, 0.25).format(TimeChanger::rdr));
    private static volatile boolean rdg;
    private static volatile long rdh;
    private static volatile long rdi;
    private static volatile boolean rdj;
    private static volatile long rdk;
    private static /* synthetic */ boolean rdl;
    private static /* synthetic */ int rdm;

    public TimeChanger() {
        super(new String(new char[]{'C', 'u', 's', 't', 'o', 'm', 'T', 'i', 'm', 'e'}), "Your own time of day, on your screen", ModuleCategory.RENDER);
        PacketHooks.rewrite(TimeChanger::rdo);
    }

    @Override
    protected void onEnable() {
        class_638 class_6382 = this.mc.field_1687;
        if (class_6382 != null) {
            rdi = class_6382.method_8532();
            rdj = true;
            rdk = class_6382.method_75260();
            PacketHooks.ensure(this.mc);
        }
        rdh = this.rdq();
        rdg = true;
        TimeChanger.rdn(this.mc);
    }

    @Override
    protected void onDisable() {
        rdg = false;
        class_638 class_6382 = this.mc.field_1687;
        if (class_6382 != null) {
            long l = rdj ? Math.max(0L, class_6382.method_75260() - rdk) : 0L;
            class_6382.method_29089(class_6382.method_75260(), rdi + l, rdj);
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        PacketHooks.ensure(class_3102);
        rdh = this.rdq();
        TimeChanger.rdn(class_3102);
    }

    private static void rdn(class_310 class_3102) {
        class_638 class_6382 = class_3102.field_1687;
        if (class_6382 == null) {
            return;
        }
        long l = TimeChanger.rdp(class_6382.method_8532());
        if (class_6382.method_8532() != l) {
            class_6382.method_29089(class_6382.method_75260(), l, false);
        }
    }

    private static class_2596<?> rdo(class_2596<?> class_25962) {
        if (!rdg || !(class_25962 instanceof class_2761)) {
            return class_25962;
        }
        class_2761 class_27612 = (class_2761)class_25962;
        rdi = class_27612.comp_3220();
        rdj = class_27612.comp_3221();
        rdk = class_27612.comp_3219();
        return new class_2761(class_27612.comp_3219(), TimeChanger.rdp(class_27612.comp_3220()), false);
    }

    private static long rdp(long l) {
        return Math.floorDiv(l, 24000L) * 24000L + rdh;
    }

    private long rdq() {
        return Math.floorMod(Math.round((this.rdf.get() - 6.0) * 1000.0), 24000L);
    }

    private static String rdr(double d) {
        int n = (int)Math.round(d * 60.0) % 1440;
        return String.format(Locale.ROOT, "%02d:%02d", n / 60, n % 60);
    }

    static {
        rdj = true;
    }

    private static /* synthetic */ int bxl(int n, int n2) {
        return n * n2 | 0x34EFBC0D;
    }

    private static /* synthetic */ int bxm(int n, int n2) {
        return n - n2 + 1913111389;
    }
}

