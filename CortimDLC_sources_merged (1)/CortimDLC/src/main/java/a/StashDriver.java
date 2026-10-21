/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_3532
 */
package a;

import a.ply;
import a.plz;
import a.pmc;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_3532;

public final class StashDriver {
    private static final int pmg = 6;
    private final Predicate<class_1799> pmh;
    private final class_1661 pmi;
    private final Random pmj;
    private final int pmk;
    private plz pml = plz.PICK;
    private int pmm;
    private int pmn;
    private int pmo;
    private int pmp;
    private int pmq;
    private long pmr;
    private boolean pms;
    private static /* synthetic */ long pmt;
    private static /* synthetic */ long pmu;

    private StashDriver(Predicate<class_1799> predicate, class_1661 class_16612, Random random, int n, int n2, int n3) {
        this.pmh = predicate;
        this.pmi = class_16612;
        this.pmj = random;
        this.pmk = Math.max(1, n);
        this.pmm = n2;
        this.pmn = n3;
    }

    public static StashDriver plan(class_1703 class_17032, class_1661 class_16612, Predicate<class_1799> predicate, int n, Random random, long l) {
        int n2 = StashDriver.pmz(class_17032, class_16612, predicate, random);
        if (n2 == -1) {
            return null;
        }
        int n3 = StashDriver.pna(class_17032, class_16612, ((class_1735)class_17032.field_7761.get(n2)).method_7677(), random);
        if (n3 == -1) {
            return null;
        }
        StashDriver pmf2 = new StashDriver(predicate, class_16612, random, n, n2, n3);
        pmf2.pmr = l + StashDriver.travelDelay(random);
        return pmf2;
    }

    public pmc drive(class_1703 class_17032, long l, ply ply2) {
        if (this.pml == plz.DONE) {
            return this.pms ? pmc.GAVE_UP : pmc.DONE;
        }
        if (l < this.pmr) {
            return pmc.WAIT;
        }
        if (this.pmq > this.pmk + 2 + 6) {
            if (class_17032.method_34255().method_7960() || this.pmp >= 8) {
                return this.pmv(true);
            }
            ++this.pmp;
            this.pml = plz.RETURN;
        }
        class_1799 class_17992 = class_17032.method_34255();
        switch (this.pml.ordinal()) {
            case 0: {
                if (!class_17992.method_7960()) {
                    this.pml = plz.RETURN;
                    return pmc.WAIT;
                }
                if (!this.pmx(class_17032, this.pmm)) {
                    this.pmm = StashDriver.pmz(class_17032, this.pmi, this.pmh, this.pmj);
                    if (this.pmm == -1) {
                        return this.pmv(true);
                    }
                }
                int n = ((class_1735)class_17032.field_7761.get(this.pmm)).method_7677().method_7947();
                this.pmw(ply2, this.pmm, 0, l);
                this.pml = n <= this.pmk ? plz.PLACE_ALL : plz.PLACE_ONE;
                return pmc.CLICKED;
            }
            case 1: 
            case 2: {
                if (class_17992.method_7960()) {
                    if (++this.pmp > 2) {
                        return this.pmv(true);
                    }
                    this.pml = plz.PICK;
                    this.pmr = l + StashDriver.clickDelay(this.pmj);
                    return pmc.WAIT;
                }
                if (!this.pmh.test(class_17992)) {
                    this.pml = plz.RETURN;
                    return pmc.WAIT;
                }
                if (!StashDriver.pmy(class_17032, this.pmi, this.pmn, class_17992)) {
                    this.pmn = StashDriver.pna(class_17032, this.pmi, class_17992, this.pmj);
                    if (this.pmn == -1) {
                        this.pml = plz.RETURN;
                        return pmc.WAIT;
                    }
                }
                if (this.pml == plz.PLACE_ALL) {
                    this.pmw(ply2, this.pmn, 0, l);
                    this.pml = plz.VERIFY;
                    this.pmr = l + StashDriver.settleDelay(this.pmj);
                } else {
                    this.pmw(ply2, this.pmn, 1, l);
                    if (++this.pmo >= this.pmk) {
                        this.pml = plz.RETURN;
                    }
                }
                return pmc.CLICKED;
            }
            case 3: {
                if (class_17992.method_7960()) {
                    this.pml = plz.VERIFY;
                    this.pmr = l + StashDriver.settleDelay(this.pmj);
                    return pmc.WAIT;
                }
                int n = StashDriver.stashSlot(class_17032, this.pmi, class_17992, this.pmm);
                if (n == -1) {
                    return this.pmv(true);
                }
                this.pmw(ply2, n, 0, l);
                this.pml = plz.VERIFY;
                this.pmr = l + StashDriver.settleDelay(this.pmj);
                return pmc.CLICKED;
            }
            case 4: {
                if (!class_17992.method_7960()) {
                    if (++this.pmp > 3) {
                        return this.pmv(true);
                    }
                    this.pml = plz.RETURN;
                    this.pmr = l + StashDriver.clickDelay(this.pmj);
                    return pmc.WAIT;
                }
                return this.pmv(false);
            }
        }
        return this.pmv(true);
    }

    public void abort() {
        if (this.pml != plz.DONE) {
            this.pml = plz.RETURN;
            this.pmr = 0L;
        }
    }

    public boolean isDone() {
        return this.pml == plz.DONE;
    }

    private pmc pmv(boolean bl) {
        this.pml = plz.DONE;
        this.pms = bl;
        return bl ? pmc.GAVE_UP : pmc.DONE;
    }

    private void pmw(ply ply2, int n, int n2, long l) {
        ply2.click(n, n2, class_1713.field_7790);
        ++this.pmq;
        this.pmr = l + StashDriver.clickDelay(this.pmj);
    }

    private boolean pmx(class_1703 class_17032, int n) {
        if (n < 0 || n >= class_17032.field_7761.size()) {
            return false;
        }
        class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
        return class_17352.field_7871 != this.pmi && class_17352.method_7681() && this.pmh.test(class_17352.method_7677());
    }

    private static boolean pmy(class_1703 class_17032, class_1661 class_16612, int n, class_1799 class_17992) {
        if (n < 0 || n >= class_17032.field_7761.size()) {
            return false;
        }
        class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
        if (class_17352.field_7871 != class_16612 || class_17352.method_34266() >= 36) {
            return false;
        }
        if (!class_17352.method_7681()) {
            return true;
        }
        class_1799 class_17993 = class_17352.method_7677();
        return class_1799.method_31577((class_1799)class_17993, (class_1799)class_17992) && class_17993.method_7947() < class_17993.method_7914();
    }

    private static int pmz(class_1703 class_17032, class_1661 class_16612, Predicate<class_1799> predicate, Random random) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(i);
            if (class_17352.field_7871 == class_16612 || !class_17352.method_7681() || !predicate.test(class_17352.method_7677())) continue;
            arrayList.add(i);
        }
        return arrayList.isEmpty() ? -1 : (Integer)arrayList.get(random.nextInt(arrayList.size()));
    }

    private static int pna(class_1703 class_17032, class_1661 class_16612, class_1799 class_17992, Random random) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        for (int i = 0; i < class_17032.field_7761.size(); ++i) {
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(i);
            if (class_17352.field_7871 != class_16612 || class_17352.method_34266() >= 36) continue;
            if (!class_17352.method_7681()) {
                (class_17352.method_34266() < 9 ? arrayList : arrayList2).add(i);
                continue;
            }
            if (!class_1799.method_31577((class_1799)class_17352.method_7677(), (class_1799)class_17992) || class_17352.method_7677().method_7947() >= class_17352.method_7677().method_7914()) continue;
            arrayList3.add(i);
        }
        ArrayList<Integer> arrayList4 = !arrayList.isEmpty() ? arrayList : (!arrayList2.isEmpty() ? arrayList2 : arrayList3);
        return arrayList4.isEmpty() ? -1 : (Integer)arrayList4.get(random.nextInt(arrayList4.size()));
    }

    public static int stashSlot(class_1703 class_17032, class_1661 class_16612, class_1799 class_17992, int n) {
        int n2;
        if (class_17992.method_7960()) {
            return -1;
        }
        if (StashDriver.pnb(class_17032, class_16612, n, class_17992, false)) {
            return n;
        }
        int n3 = -1;
        for (n2 = 0; n2 < class_17032.field_7761.size(); ++n2) {
            class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n2);
            if (class_17352.field_7871 == class_16612) continue;
            if (!class_17352.method_7681()) {
                return n2;
            }
            if (n3 != -1 || !StashDriver.pnb(class_17032, class_16612, n2, class_17992, false)) continue;
            n3 = n2;
        }
        if (n3 != -1) {
            return n3;
        }
        for (n2 = 0; n2 < class_17032.field_7761.size(); ++n2) {
            if (!StashDriver.pnb(class_17032, class_16612, n2, class_17992, true)) continue;
            return n2;
        }
        return -1;
    }

    private static boolean pnb(class_1703 class_17032, class_1661 class_16612, int n, class_1799 class_17992, boolean bl) {
        if (n < 0 || n >= class_17032.field_7761.size()) {
            return false;
        }
        class_1735 class_17352 = (class_1735)class_17032.field_7761.get(n);
        if (class_17352.field_7871 == class_16612 != bl || bl && class_17352.method_34266() >= 36) {
            return false;
        }
        if (!class_17352.method_7681()) {
            return class_17352.method_7680(class_17992);
        }
        class_1799 class_17993 = class_17352.method_7677();
        return class_1799.method_31577((class_1799)class_17993, (class_1799)class_17992) && class_17993.method_7947() < Math.min(class_17993.method_7914(), class_17352.method_7676(class_17993));
    }

    public static long clickDelay(Random random) {
        double d = 72.0 * Math.exp(random.nextGaussian() * 0.28);
        if (random.nextDouble() < 0.05) {
            d += 100.0 + random.nextDouble() * 160.0;
        }
        return Math.round(class_3532.method_15350((double)d, (double)45.0, (double)320.0));
    }

    public static long travelDelay(Random random) {
        return Math.round(class_3532.method_15350((double)(160.0 * Math.exp(random.nextGaussian() * 0.25)), (double)110.0, (double)300.0));
    }

    public static long settleDelay(Random random) {
        return Math.round(class_3532.method_15350((double)(150.0 * Math.exp(random.nextGaussian() * 0.2)), (double)110.0, (double)260.0));
    }

    private static /* synthetic */ int ble(int n, int n2) {
        return n + n2 + 896081784;
    }
}

