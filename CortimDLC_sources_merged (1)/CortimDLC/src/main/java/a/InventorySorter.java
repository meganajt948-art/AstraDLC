/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10192
 *  net.minecraft.class_1304
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_7923
 *  net.minecraft.class_9334
 */
package a;

import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.AutoLoot;
import a.Icon;
import a.BoolSetting;
import a.KeySetting;
import a.ModeSetting;
import a.NumberSetting;
import a.SlotUtil;
import a.KeyUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_10192;
import net.minecraft.class_1304;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_7923;
import net.minecraft.class_9334;

public class InventorySorter
extends Module {
    private static InventorySorter osr;
    private final KeySetting oss = this.add(new KeySetting("Key", 82));
    private final ModeSetting ost = this.add(new ModeSetting("Order", "Type", "Type", "Name", "Count"));
    private final BoolSetting osu = this.add(new BoolSetting("Merge stacks", true));
    private final NumberSetting osv = this.add(new NumberSetting("Speed", 3.0, 1.0, 8.0, 1.0).suffix("/tick"));
    private final BoolSetting osw = this.add(new BoolSetting("Notify", true));
    private static final int osx = 600;
    private boolean osy;
    private boolean osz;
    private int ota = -1;
    private int otb;
    private static /* synthetic */ int otc;
    private static /* synthetic */ String otd;

    public InventorySorter() {
        super("ChestSorter", "Sorts the open chest on a key", ModuleCategory.PLAYER);
        osr = this;
    }

    public static boolean busy() {
        return osr != null && InventorySorter.osr.osz;
    }

    @Override
    protected void onDisable() {
        this.osz = false;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_465 class_4652;
        class_437 class_4372;
        block10: {
            block9: {
                boolean bl;
                boolean bl2 = class_3102.field_1755 instanceof class_465 && SlotUtil.isStorage(class_3102.field_1755);
                boolean bl3 = bl = bl2 && this.oss.isBound() && KeyUtil.isDown(class_3102, this.oss.get());
                if (bl && !this.osy && !this.osz && !AutoLoot.busy()) {
                    this.ote(class_3102);
                }
                this.osy = bl;
                if (!this.osz) {
                    return;
                }
                class_4372 = class_3102.field_1755;
                if (!(class_4372 instanceof class_465)) break block9;
                class_4652 = (class_465)class_4372;
                if (class_4652.method_17577().field_7763 == this.ota) break block10;
            }
            this.osz = false;
            return;
        }
        class_4372 = class_4652.method_17577();
        List<class_1735> list = SlotUtil.own((class_1703)class_4372, class_3102.field_1724.method_31548());
        for (int i = 0; i < this.osv.getInt() && this.osz; ++i) {
            if (this.otb > 600) {
                this.otf(Lang.s("Sorting stopped", "Сортировка остановлена"), false);
                return;
            }
            if (!class_4372.method_34255().method_7960()) {
                class_1735 class_17352 = InventorySorter.oth(list);
                if (class_17352 == null) {
                    this.otf(Lang.s("Put the item on the cursor down", "Уберите предмет с курсора"), false);
                    return;
                }
                this.otg(class_3102, (class_1703)class_4372, class_17352);
                continue;
            }
            if (this.osu.get() && this.oti(class_3102, (class_1703)class_4372, list) || this.otj(class_3102, (class_1703)class_4372, list)) continue;
            this.otf(Lang.s("Sorted", "Отсортировано") + " · " + this.otb + Lang.s(" clicks", " кликов"), true);
        }
    }

    private void ote(class_310 class_3102) {
        class_465 class_4652 = (class_465)class_3102.field_1755;
        if (!class_4652.method_17577().method_34255().method_7960()) {
            if (this.osw.get()) {
                Hud.alert(this.getName(), Lang.s("Put the item on the cursor down first", "Сначала уберите предмет с курсора"), Icon.INFO, false);
            }
            return;
        }
        this.osz = true;
        this.ota = class_4652.method_17577().field_7763;
        this.otb = 0;
    }

    private void otf(String string, boolean bl) {
        this.osz = false;
        if (this.osw.get()) {
            Hud.alert(this.getName(), string, bl ? Icon.CHECK : Icon.INFO, bl);
        }
    }

    private void otg(class_310 class_3102, class_1703 class_17032, class_1735 class_17352) {
        SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7790);
        ++this.otb;
    }

    private static class_1735 oth(List<class_1735> list) {
        for (class_1735 class_17352 : list) {
            if (class_17352.method_7681()) continue;
            return class_17352;
        }
        return null;
    }

    private boolean oti(class_310 class_3102, class_1703 class_17032, List<class_1735> list) {
        for (int i = 0; i < list.size(); ++i) {
            class_1799 class_17992 = list.get(i).method_7677();
            if (class_17992.method_7960() || class_17992.method_7947() >= class_17992.method_7914()) continue;
            for (int j = list.size() - 1; j > i; --j) {
                class_1799 class_17993 = list.get(j).method_7677();
                if (class_17993.method_7960() || class_17993.method_7947() >= class_17993.method_7914() || !class_1799.method_31577((class_1799)class_17992, (class_1799)class_17993)) continue;
                this.otg(class_3102, class_17032, list.get(j));
                this.otg(class_3102, class_17032, list.get(i));
                if (!class_17032.method_34255().method_7960()) {
                    this.otg(class_3102, class_17032, list.get(j));
                }
                return true;
            }
        }
        return false;
    }

    private boolean otj(class_310 class_3102, class_1703 class_17032, List<class_1735> list) {
        ArrayList<class_1799> arrayList = new ArrayList<class_1799>();
        for (class_1735 class_17352 : list) {
            if (!class_17352.method_7681()) continue;
            arrayList.add(class_17352.method_7677());
        }
        arrayList.sort(this.otl());
        for (int i = 0; i < list.size(); ++i) {
            class_1735 class_17352;
            class_17352 = i < arrayList.size() ? (class_1799)arrayList.get(i) : class_1799.field_8037;
            class_1799 class_17992 = list.get(i).method_7677();
            if (InventorySorter.otk(class_17992, (class_1799)class_17352)) continue;
            if (class_17352.method_7960()) {
                return false;
            }
            for (int j = i + 1; j < list.size(); ++j) {
                if (!InventorySorter.otk(list.get(j).method_7677(), (class_1799)class_17352)) continue;
                this.otg(class_3102, class_17032, list.get(j));
                this.otg(class_3102, class_17032, list.get(i));
                if (!class_17032.method_34255().method_7960()) {
                    this.otg(class_3102, class_17032, list.get(j));
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean otk(class_1799 class_17992, class_1799 class_17993) {
        if (class_17992.method_7960() || class_17993.method_7960()) {
            return class_17992.method_7960() == class_17993.method_7960();
        }
        return class_17992.method_7947() == class_17993.method_7947() && class_1799.method_31577((class_1799)class_17992, (class_1799)class_17993);
    }

    /*
     * Exception decompiling
     */
    private Comparator<class_1799> otl() {
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

    private static int otm(class_1799 class_17992) {
        class_1792 class_17922 = class_17992.method_7909();
        String string = class_7923.field_41178.method_10221((Object)class_17922).method_12832();
        if (string.endsWith("_sword") || string.endsWith("_axe") || class_17922 == class_1802.field_49814 || class_17922 == class_1802.field_8547 || class_17922 == class_1802.field_8102 || class_17922 == class_1802.field_8399 || string.endsWith("_spear")) {
            return 0;
        }
        if (string.endsWith("_pickaxe") || string.endsWith("_shovel") || string.endsWith("_hoe") || class_17922 == class_1802.field_8868 || class_17922 == class_1802.field_8378 || class_17922 == class_1802.field_8884 || class_17922 == class_1802.field_42716) {
            return 1;
        }
        class_10192 class_101922 = (class_10192)class_17992.method_58694(class_9334.field_54196);
        if (class_101922 != null && class_101922.comp_3174() != class_1304.field_6173 && class_101922.comp_3174() != class_1304.field_6171 || class_17922 == class_1802.field_8255 || class_17922 == class_1802.field_8288) {
            return 2;
        }
        if (class_17992.method_57826(class_9334.field_50075)) {
            return 3;
        }
        if (class_17992.method_57826(class_9334.field_49651)) {
            return 4;
        }
        if (class_17922 instanceof class_1747) {
            return 5;
        }
        return 6;
    }

    private static /* synthetic */ int lambda$comparator$1(class_1799 class_17992) {
        return class_7923.field_41178.method_10206((Object)class_17992.method_7909());
    }

    private static /* synthetic */ String lambda$comparator$0(class_1799 class_17992) {
        return class_17992.method_7964().getString().toLowerCase(Locale.ROOT);
    }

    private static /* synthetic */ int bes(int n, int n2) {
        return (n ^ n2) + 189364853;
    }
}

