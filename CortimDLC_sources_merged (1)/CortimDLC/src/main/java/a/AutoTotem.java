/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1294
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_746
 *  net.minecraft.class_9334
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.KeyPearl;
import a.ServerHelper;
import a.BoolSetting;
import a.NumberSetting;
import a.IdleTracker;
import a.InventoryClicks;
import flow.dev.StringDecryptor;
import java.util.Arrays;
import java.util.function.Predicate;
import net.minecraft.class_1263;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_746;
import net.minecraft.class_9334;

public class AutoTotem
extends Module {
    private static final int kre = 20;
    private static final int krf = 8;
    private static final int krg = 1;
    private static final int krh = 10;
    private static final float kri = 0.5f;
    private static AutoTotem krj;
    private final NumberSetting krk = this.add(new NumberSetting("Порог здоровья", 6.0, 1.0, 20.0, 0.5).suffix("HP"));
    private final BoolSetting krl = this.add(new BoolSetting("Возвращать предмет", true));
    private final BoolSetting krm = this.add(new BoolSetting("Сначала обычные тотемы", true));
    private final BoolSetting krn = this.add(new BoolSetting("Не во время еды", false));
    private final BoolSetting kro = this.add(new BoolSetting("Умное перемещение", true));
    private final IdleTracker krp = new IdleTracker();
    private final float[] krq = new float[20];
    private class_746 krr;
    private boolean krs;
    private class_1799 krt = class_1799.field_8037;
    private int kru = -1;
    private boolean krv;
    private int krw;
    private int krx = 1;
    private static /* synthetic */ String kry;
    private static /* synthetic */ String krz;

    public AutoTotem() {
        super("AutoTotem", "Keeps a totem in the offhand", ModuleCategory.COMBAT);
        krj = this;
    }

    public static boolean busy() {
        return krj != null && AutoTotem.krj.krv;
    }

    public static boolean needsTotem() {
        return krj != null && krj.isEnabled() && AutoTotem.krj.krs;
    }

    @Override
    protected void onEnable() {
        this.krr = null;
        this.krs = false;
        this.ksl();
        this.krv = false;
        this.krw = 0;
        this.krx = 1;
    }

    @Override
    protected void onDisable() {
        this.ksk();
        this.krs = false;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        int n;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 != this.krr) {
            this.ksb(class_7462);
        }
        this.ksc(class_7462);
        if (this.krx < 1) {
            ++this.krx;
        }
        if (!class_7462.method_5805() || class_7462.method_7325() || class_7462.method_68878()) {
            this.ksk();
            return;
        }
        if (this.krn.get() && AutoTotem.ksf(class_7462)) {
            this.ksk();
            return;
        }
        Boolean bl = this.kse(class_7462);
        if (bl != null) {
            this.krs = bl;
        }
        if ((n = this.ksg(class_7462)) < 0 || this.krx < 1 || !AutoTotem.ksm(class_3102, class_7462) || this.ksa()) {
            this.ksk();
            return;
        }
        if (AutoTotem.ksn(class_7462)) {
            this.ksj(class_3102, class_7462, n);
            return;
        }
        if (++this.krw > 8) {
            this.ksk();
            this.krx = -10;
            return;
        }
        this.krp.hold(class_3102);
        if (class_7462.method_6115()) {
            class_3102.field_1761.method_2897((class_1657)class_7462);
        }
        this.krv = true;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (!this.krv) {
            return;
        }
        class_746 class_7462 = class_3102.field_1724;
        int n = this.ksg(class_7462);
        if (n < 0 || !AutoTotem.ksm(class_3102, class_7462)) {
            this.ksk();
            return;
        }
        if (AutoTotem.ksn(class_7462) && !this.ksa()) {
            this.ksj(class_3102, class_7462, n);
        }
    }

    private boolean ksa() {
        return !this.krs && (ServerHelper.busy() || KeyPearl.busy());
    }

    private void ksb(class_746 class_7462) {
        boolean bl = this.krr != null && this.krr.method_5805();
        this.krr = class_7462;
        Arrays.fill(this.krq, AutoTotem.ksd(class_7462));
        if (!bl) {
            this.krs = false;
            this.ksl();
        }
        this.ksk();
        this.krx = 1;
    }

    private void ksc(class_746 class_7462) {
        System.arraycopy(this.krq, 0, this.krq, 1, 19);
        this.krq[0] = AutoTotem.ksd(class_7462);
    }

    private static float ksd(class_746 class_7462) {
        float f = class_7462.method_6059(class_1294.field_5898) ? class_7462.method_6067() : 0.0f;
        return class_7462.method_6032() + f;
    }

    private Boolean kse(class_746 class_7462) {
        float f;
        if (class_7462.method_7357().method_7904(class_1802.field_8288.method_7854())) {
            return Boolean.FALSE;
        }
        if (this.kro.get() && AutoTotem.ksf(class_7462) && class_7462.method_6030().method_7935((class_1309)class_7462) > 5) {
            int n = class_7462.method_6014();
            if (n < 10) {
                return null;
            }
            float f2 = this.krq[19] - this.krq[0];
            if (n < 30 && f2 / 20.0f * (float)n < this.krq[0]) {
                return null;
            }
        }
        if (this.krq[0] <= (f = (float)this.krk.get())) {
            return Boolean.TRUE;
        }
        return this.krq[0] >= f + 0.5f ? Boolean.FALSE : null;
    }

    private static boolean ksf(class_746 class_7462) {
        class_1799 class_17992 = class_7462.method_6030();
        return class_7462.method_6115() && !class_17992.method_7960() && class_17992.method_58694(class_9334.field_50075) != null;
    }

    private int ksg(class_746 class_7462) {
        return this.krs ? this.ksh(class_7462) : this.ksi(class_7462);
    }

    private int ksh(class_746 class_7462) {
        int n;
        class_1799 class_17993 = class_7462.method_6079();
        boolean bl = this.krm.get();
        boolean bl2 = class_17993.method_31574(class_1802.field_8288);
        if (!(!bl2 || bl && class_17993.method_7958())) {
            return -1;
        }
        int n2 = n = bl ? AutoTotem.kso(class_7462, class_17992 -> class_17992.method_31574(class_1802.field_8288) && !class_17992.method_7958()) : -1;
        if (n < 0 && !bl2) {
            n = AutoTotem.kso(class_7462, class_17992 -> class_17992.method_31574(class_1802.field_8288));
        }
        return n;
    }

    private int ksi(class_746 class_7462) {
        if (this.krt.method_7960()) {
            return -1;
        }
        class_1799 class_17993 = class_7462.method_6079();
        if (!this.krl.get() || !class_17993.method_7960() && !class_17993.method_31574(class_1802.field_8288)) {
            this.ksl();
            return -1;
        }
        class_1661 class_16612 = class_7462.method_31548();
        if (this.kru >= 0 && class_1799.method_31577((class_1799)class_16612.method_5438(this.kru), (class_1799)this.krt)) {
            return this.kru;
        }
        int n = AutoTotem.kso(class_7462, class_17992 -> class_1799.method_31577((class_1799)class_17992, (class_1799)this.krt));
        if (n < 0) {
            n = AutoTotem.kso(class_7462, class_17992 -> class_17992.method_31574(this.krt.method_7909()));
        }
        if (n < 0) {
            this.ksl();
        }
        return n;
    }

    private void ksj(class_310 class_3102, class_746 class_7462, int n) {
        class_1799 class_17992 = class_7462.method_6079();
        if (!this.krs) {
            this.ksl();
        } else if (this.krl.get() && this.krt.method_7960() && !class_17992.method_7960() && !class_17992.method_31574(class_1802.field_8288)) {
            this.krt = class_17992.method_7972();
            this.kru = n;
        }
        class_1703 class_17032 = class_7462.field_7512;
        int n2 = InventoryClicks.slotId(class_17032, (class_1263)class_7462.method_31548(), n);
        if (n2 >= 0) {
            class_3102.field_1761.method_2906(class_17032.field_7763, n2, 40, class_1713.field_7791, (class_1657)class_7462);
            if (class_17032 == class_7462.field_7498) {
                InventoryClicks.close(class_3102);
            }
        }
        this.krx = 0;
        this.ksk();
    }

    private void ksk() {
        if (this.krv || this.krp.isHeld()) {
            this.krp.release(this.mc);
        }
        this.krv = false;
        this.krw = 0;
    }

    private void ksl() {
        this.krt = class_1799.field_8037;
        this.kru = -1;
    }

    private static boolean ksm(class_310 class_3102, class_746 class_7462) {
        class_465 class_4652;
        class_437 class_4372;
        class_1703 class_17032 = class_7462.field_7512;
        if (class_17032 == null || !class_17032.method_34255().method_7960()) {
            return false;
        }
        return class_17032 == class_7462.field_7498 || (class_4372 = class_3102.field_1755) instanceof class_465 && (class_4652 = (class_465)class_4372).method_17577() == class_17032;
    }

    private static boolean ksn(class_746 class_7462) {
        return IdleTracker.serverIdle(class_7462) && !class_7462.method_6115();
    }

    private static int kso(class_746 class_7462, Predicate<class_1799> predicate) {
        int n;
        class_1661 class_16612 = class_7462.method_31548();
        int n2 = class_16612.method_67532();
        for (n = 9; n < 36; ++n) {
            if (!predicate.test(class_16612.method_5438(n))) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (n == n2 || !predicate.test(class_16612.method_5438(n))) continue;
            return n;
        }
        return predicate.test(class_16612.method_5438(n2)) ? n2 : -1;
    }

    private static /* synthetic */ int auj(int n, int n2) {
        return n * n2 + -386924236;
    }
}

