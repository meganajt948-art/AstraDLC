/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet
 *  net.minecraft.class_1767
 *  net.minecraft.class_1922
 *  net.minecraft.class_1923
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2480
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_265
 *  net.minecraft.class_2672
 *  net.minecraft.class_2680
 *  net.minecraft.class_2806
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_638
 *  net.minecraft.class_7923
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.qzt;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.BoolSetting;
import a.ColorSetting;
import a.vlg;
import a.ListSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.PacketHooks;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1767;
import net.minecraft.class_1922;
import net.minecraft.class_1923;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2480;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_265;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_2806;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_638;
import net.minecraft.class_7923;
import net.minecraft.class_9779;

public class OreEsp
extends Module {
    private static OreEsp raf;
    private final ListSetting rag = this.add(new ListSetting("Blocks", vlg.BLOCKS, "minecraft:diamond_ore", "minecraft:deepslate_diamond_ore", "minecraft:ancient_debris", "minecraft:emerald_ore", "minecraft:deepslate_emerald_ore", "minecraft:gold_ore", "minecraft:deepslate_gold_ore", "minecraft:spawner", "minecraft:chest", "minecraft:trapped_chest", "minecraft:ender_chest", "minecraft:barrel"));
    private final ModeSetting rah = this.add(new ModeSetting("Mode", "Box", "Box", "Corners", "Fill"));
    private final BoolSetting rai = this.add(new BoolSetting("Block colors", true));
    private final ColorSetting raj = this.add(new ColorSetting("Color", "Theme"));
    private final NumberSetting rak = this.add(new NumberSetting("Range", 48.0, 16.0, 128.0, 8.0).suffix("blocks"));
    private final NumberSetting ral = this.add(new NumberSetting("Fill", 0.18, 0.0, 0.6, 0.02).percent());
    private final NumberSetting ram = this.add(new NumberSetting("Width", 1.0, 0.5, 2.5, 0.1));
    private final NumberSetting ran = this.add(new NumberSetting("Limit", 300.0, 50.0, 1000.0, 50.0));
    private static final long rao = 1500000L;
    private final Long2IntOpenHashMap rap = new Long2IntOpenHashMap();
    private static final int[][] raq;
    private final Long2ObjectOpenHashMap<List<qzt>> rar = new Long2ObjectOpenHashMap();
    private final LongLinkedOpenHashSet ras = new LongLinkedOpenHashSet();
    private final LongLinkedOpenHashSet rat = new LongLinkedOpenHashSet();
    private static final Set<Long> rau;
    private boolean[] rav = new boolean[0];
    private int raw = -1;
    private class_638 rax;
    private final List<qzt> ray = new ArrayList<qzt>();
    private int raz;
    private long rba = -1L;
    private final double[][] rbb = new double[8][3];
    private final float[][] rbc = new float[8][2];
    private final boolean[] rbd = new boolean[8];
    private final boolean[] rbe = new boolean[6];
    private final float[] rbf = new float[4];
    private final float[] rbg = new float[2];
    private static final int[][] rbh;
    private static final int[][] rbi;
    private boolean rbj;
    private static /* synthetic */ String rbk;
    private static /* synthetic */ int rbl;

    public OreEsp() {
        super(new String(new char[]{'B', 'l', 'o', 'c', 'k', 'E', 'S', 'P'}), "Chosen blocks seen through walls", ModuleCategory.RENDER);
        raf = this;
        PacketHooks.listen(OreEsp::rbm);
        this.raj.visibleWhen(() -> !this.rai.get());
        this.ral.visibleWhen(() -> this.rah.is("Fill") || this.rah.is("Box"));
        this.ram.visibleWhen(() -> !this.rah.is("Fill"));
    }

    private static void rbm(class_2596<?> class_25962) {
        OreEsp rae2 = raf;
        if (rae2 == null || !rae2.isEnabled()) {
            return;
        }
        if (class_25962 instanceof class_2626) {
            class_2626 class_26262 = (class_2626)class_25962;
            class_2338 class_23383 = class_26262.method_11309();
            rau.add(class_1923.method_8331((int)(class_23383.method_10263() >> 4), (int)(class_23383.method_10260() >> 4)));
        } else if (class_25962 instanceof class_2637) {
            class_2637 class_26372 = (class_2637)class_25962;
            long[] lArray = new long[]{Long.MIN_VALUE};
            class_26372.method_30621((class_23382, class_26802) -> {
                long l = class_1923.method_8331((int)(class_23382.method_10263() >> 4), (int)(class_23382.method_10260() >> 4));
                if (l != lArray[0]) {
                    lArray[0] = l;
                    rau.add(l);
                }
            });
        } else if (class_25962 instanceof class_2672) {
            class_2672 class_26722 = (class_2672)class_25962;
            rau.add(class_1923.method_8331((int)class_26722.method_11523(), (int)class_26722.method_11524()));
        }
    }

    @Override
    protected void onEnable() {
        this.rbn();
    }

    @Override
    protected void onDisable() {
        this.rbn();
    }

    private void rbn() {
        this.rar.clear();
        this.ras.clear();
        this.rat.clear();
        this.ray.clear();
        this.rap.clear();
        rau.clear();
        this.raw = -1;
    }

    private void rbo() {
        boolean[] blArray = new boolean[class_7923.field_41175.method_10204()];
        for (String string : this.rag.ids()) {
            class_2248 class_22482;
            int n;
            class_2960 class_29602 = class_2960.method_12829((String)string);
            if (class_29602 == null || !class_7923.field_41175.method_10250(class_29602) || (n = class_7923.field_41175.method_10206((Object)(class_22482 = (class_2248)class_7923.field_41175.method_63535(class_29602)))) < 0 || n >= blArray.length) continue;
            blArray[n] = true;
        }
        this.rav = blArray;
        this.raw = this.rag.version();
    }

    private boolean rbp(class_2680 class_26802) {
        int n = class_7923.field_41175.method_10206((Object)class_26802.method_26204());
        return n >= 0 && n < this.rav.length && this.rav[n];
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        long l;
        long l2;
        PacketHooks.ensure(class_3102);
        if (class_3102.field_1687 != this.rax) {
            this.rax = class_3102.field_1687;
            this.rbn();
        }
        if (this.raw != this.rag.version()) {
            this.rbn();
            this.rbo();
        }
        int n = class_3102.field_1724.method_31477() >> 4;
        int n2 = class_3102.field_1724.method_31479() >> 4;
        int n3 = (int)Math.ceil(this.rak.get() / 16.0) + 1;
        Object object = this.rar.keySet().iterator();
        while (object.hasNext()) {
            l2 = object.nextLong();
            if (Math.abs(class_1923.method_8325((long)l2) - n) <= n3 + 1 && Math.abs(class_1923.method_8332((long)l2) - n2) <= n3 + 1) continue;
            object.remove();
        }
        object = this.rat.iterator();
        while (object.hasNext()) {
            l2 = object.nextLong();
            if (Math.abs(class_1923.method_8325((long)l2) - n) <= n3 + 1 && Math.abs(class_1923.method_8332((long)l2) - n2) <= n3 + 1) continue;
            object.remove();
        }
        for (Long l3 : rau) {
            rau.remove(l3);
            if (!this.rat.remove(l3.longValue())) continue;
            this.ras.add(l3.longValue());
        }
        for (int i = -n3; i <= n3; ++i) {
            for (int j = -n3; j <= n3; ++j) {
                l = class_1923.method_8331((int)(n + j), (int)(n2 + i));
                if (this.rat.contains(l)) continue;
                this.ras.add(l);
            }
        }
        long l4 = System.nanoTime();
        this.rbj = false;
        while (!this.ras.isEmpty() && System.nanoTime() - l4 < 1500000L) {
            class_2818 class_28182;
            l = this.ras.removeFirstLong();
            if (Math.abs(class_1923.method_8325((long)l) - n) > n3 || Math.abs(class_1923.method_8332((long)l) - n2) > n3 || (class_28182 = class_3102.field_1687.method_2935().method_2857(class_1923.method_8325((long)l), class_1923.method_8332((long)l), class_2806.field_12803, false)) == null) continue;
            this.rbq(class_3102.field_1687, class_28182, l);
            this.rat.add(l);
        }
        if (--this.raz <= 0 || this.rbj) {
            this.raz = 10;
            this.rbs(class_3102);
        }
    }

    private void rbq(class_638 class_6382, class_2818 class_28182, long l) {
        ArrayList<qzt> arrayList = null;
        class_2826[] class_2826Array = class_28182.method_12006();
        int n = class_28182.method_32891();
        int n2 = class_1923.method_8325((long)l) << 4;
        int n3 = class_1923.method_8332((long)l) << 4;
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = 0; i < class_2826Array.length; ++i) {
            class_2826 class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292() || !class_28262.method_19523(this::rbp)) continue;
            int n4 = n + i << 4;
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 < 16; ++i2) {
                        class_2680 class_26802 = class_28262.method_12254(i2, j, k);
                        if (!this.rbp(class_26802)) continue;
                        class_23392.method_10103(n2 + i2, n4 + j, n3 + k);
                        if (arrayList == null) {
                            arrayList = new ArrayList<qzt>();
                        }
                        arrayList.add(this.rbr(class_6382, (class_2338)class_23392, class_26802));
                    }
                }
            }
        }
        if (arrayList == null) {
            this.rbj |= this.rar.remove(l) != null;
        } else {
            this.rar.put(l, arrayList);
            this.rbj = true;
        }
    }

    private qzt rbr(class_638 class_6382, class_2338 class_23382, class_2680 class_26802) {
        class_238 class_2383 = new class_238(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        try {
            class_265 class_2652 = class_26802.method_26218((class_1922)class_6382, class_23382);
            if (!class_2652.method_1110()) {
                class_2383 = class_2652.method_1107();
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return new qzt(class_23382.method_10063(), this.rbu(class_26802), (float)class_2383.field_1323, (float)class_2383.field_1322, (float)class_2383.field_1321, (float)class_2383.field_1320, (float)class_2383.field_1325, (float)class_2383.field_1324);
    }

    private void rbs(class_310 class_3102) {
        this.ray.clear();
        double d = this.rak.get();
        double d2 = d * d;
        class_243 class_2432 = class_3102.field_1724.method_33571();
        ArrayList<qzt> arrayList = new ArrayList<qzt>();
        for (Iterator<qzt> iterator : this.rar.values()) {
            Iterator object2 = iterator.iterator();
            while (object2.hasNext()) {
                double d3;
                double d4;
                qzt qzt2 = (qzt)object2.next();
                double d5 = (double)class_2338.method_10061((long)qzt2.qzu) + 0.5 - class_2432.field_1352;
                if (!(d5 * d5 + (d4 = (double)class_2338.method_10071((long)qzt2.qzu) + 0.5 - class_2432.field_1351) * d4 + (d3 = (double)class_2338.method_10083((long)qzt2.qzu) + 0.5 - class_2432.field_1350) * d3 <= d2)) continue;
                arrayList.add(qzt2);
            }
        }
        int n3 = this.ran.getInt();
        if (arrayList.size() > n3) {
            int n4;
            Iterator<qzt> iterator;
            iterator = (Iterator<qzt>)new double[arrayList.size()];
            Integer[] integerArray = new Integer[arrayList.size()];
            for (n4 = 0; n4 < arrayList.size(); ++n4) {
                qzt qzt3 = (qzt)arrayList.get(n4);
                double d6 = (double)class_2338.method_10061((long)qzt3.qzu) - class_2432.field_1352;
                double d7 = (double)class_2338.method_10071((long)qzt3.qzu) - class_2432.field_1351;
                double d8 = (double)class_2338.method_10083((long)qzt3.qzu) - class_2432.field_1350;
                iterator[n4] = (Iterator<qzt>)(d6 * d6 + d7 * d7 + d8 * d8);
                integerArray[n4] = n4;
            }
            Arrays.sort(integerArray, (n, n2) -> Double.compare(iterator[n], iterator[n2]));
            for (n4 = 0; n4 < n3; ++n4) {
                this.ray.add((qzt)arrayList.get(integerArray[n4]));
            }
        } else {
            this.ray.addAll(arrayList);
        }
        this.rap.clear();
        for (qzt qzt4 : this.ray) {
            if (!qzt4.fullCube()) continue;
            this.rap.put(qzt4.qzu, qzt4.qzv);
        }
    }

    private boolean rbt(long l, int n, int n2, int n3, int n4, boolean bl) {
        long l2 = class_2338.method_10096((long)l, (int)n, (int)n2, (int)n3);
        return this.rap.containsKey(l2) && (bl || this.rap.get(l2) == n4);
    }

    private int rbu(class_2680 class_26802) {
        class_2248 class_22482 = class_26802.method_26204();
        if (class_22482 instanceof class_2480) {
            class_2480 class_24802 = (class_2480)class_22482;
            class_1767 class_17672 = class_24802.method_10528();
            return class_17672 != null ? 0xFF000000 | class_17672.method_7787() : -4944682;
        }
        String string = class_7923.field_41175.method_10221((Object)class_22482).method_12832();
        if (string.contains("diamond")) {
            return -11541505;
        }
        if (string.contains("emerald")) {
            return -12723068;
        }
        if (string.contains("gold") || string.equals("gilded_blackstone")) {
            return -11443;
        }
        if (string.contains("ancient_debris") || string.contains("netherite")) {
            return -4158870;
        }
        if (string.contains("iron")) {
            return -1521234;
        }
        if (string.contains("redstone")) {
            return -45747;
        }
        if (string.contains("lapis")) {
            return -11699201;
        }
        if (string.contains("copper")) {
            return -26022;
        }
        if (string.contains("coal")) {
            return -7697770;
        }
        if (string.contains("quartz")) {
            return -856604;
        }
        if (string.contains("spawner")) {
            return -41334;
        }
        if (string.equals("ender_chest")) {
            return -5018625;
        }
        if (string.contains("chest") || string.contains("barrel")) {
            return -1529776;
        }
        if (string.contains("beacon") || string.contains("conduit")) {
            return -8587265;
        }
        int n = class_22482.method_26403().field_16011;
        int n2 = 0xFF000000 | n;
        return ColorUtil.luminance(n2) < 0.4f ? ColorUtil.lerp(n2, -1, 0.45f) : n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        OreEsp rae2 = raf;
        class_310 class_3102 = class_310.method_1551();
        if (rae2 == null || !rae2.isEnabled() || rae2.ray.isEmpty() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rae2.rba) {
            return;
        }
        rae2.rba = FrameDelta.frame();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        class_243 class_2432 = usn2.camera();
        int n = rae2.raj.color() | 0xFF000000;
        boolean bl = rae2.rah.is("Fill");
        boolean bl2 = rae2.rah.is("Corners");
        float f = (float)rae2.ral.get();
        float f2 = (float)rae2.ram.get();
        boolean bl3 = !rae2.rai.get();
        float f3 = usn2.width();
        float f4 = usn2.height();
        float[] fArray = rae2.rbg;
        DrawUtil.beginBatch();
        try {
            for (qzt qzt2 : rae2.ray) {
                float f5;
                double d;
                double d2;
                double d3;
                double d4;
                double d5 = class_2338.method_10061((long)qzt2.qzu);
                double d6 = d5 + (double)(qzt2.qzw + qzt2.qzz) * 0.5;
                float f6 = usn2.depth(d6, d4 = (d3 = (double)class_2338.method_10071((long)qzt2.qzu)) + (double)(qzt2.qzx + qzt2.raa) * 0.5, d2 = (d = (double)class_2338.method_10083((long)qzt2.qzu)) + (double)(qzt2.qzy + qzt2.rab) * 0.5);
                if (f6 < -1.0f || f6 > 2.0f && usn2.project(d6, d4, d2, fArray) && (fArray[0] < -(f5 = usn2.unitsPerBlock(d6, d4, d2) * 0.9f) || fArray[1] < -f5 || fArray[0] > f3 + f5 || fArray[1] > f4 + f5)) continue;
                int n2 = bl3 ? n : qzt2.qzv;
                rae2.rbv(class_3322, usn2, class_2432, qzt2, d5, d3, d, n2, bl, bl2, f, f2, bl3);
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    private void rbv(class_332 class_3322, ScreenProjection usn2, class_243 class_2432, qzt qzt2, double d, double d2, double d3, int n, boolean bl, boolean bl2, float f, float f2, boolean bl3) {
        int n2;
        boolean bl4 = qzt2.fullCube();
        int n3 = 0;
        if (bl4) {
            for (int i = 0; i < 6; ++i) {
                int[] nArray = raq[i];
                if (!this.rbt(qzt2.qzu, nArray[0], nArray[1], nArray[2], qzt2.qzv, bl3)) continue;
                n3 |= 1 << i;
            }
        }
        double d4 = 0.003;
        double d5 = d + (double)qzt2.qzw - d4;
        double d6 = d2 + (double)qzt2.qzx - d4;
        double d7 = d3 + (double)qzt2.qzy - d4;
        double d8 = d + (double)qzt2.qzz + d4;
        double d9 = d2 + (double)qzt2.raa + d4;
        double d10 = d3 + (double)qzt2.rab + d4;
        for (n2 = 0; n2 < 8; ++n2) {
            this.rbb[n2][0] = (n2 & 1) == 0 ? d5 : d8;
            this.rbb[n2][1] = (n2 & 2) == 0 ? d6 : d9;
            this.rbb[n2][2] = (n2 & 4) == 0 ? d7 : d10;
            this.rbd[n2] = usn2.depth(this.rbb[n2][0], this.rbb[n2][1], this.rbb[n2][2]) > 0.05f && usn2.project(this.rbb[n2][0], this.rbb[n2][1], this.rbb[n2][2], this.rbc[n2]);
        }
        this.rbe[0] = class_2432.field_1351 < d6;
        this.rbe[1] = class_2432.field_1351 > d9;
        this.rbe[2] = class_2432.field_1350 < d7;
        this.rbe[3] = class_2432.field_1350 > d10;
        this.rbe[4] = class_2432.field_1352 < d5;
        boolean bl5 = this.rbe[5] = class_2432.field_1352 > d8;
        if ((bl || !bl2) && f > 0.005f) {
            n2 = ColorUtil.withAlpha(n, Math.round(255.0f * f));
            for (int i = 0; i < 6; ++i) {
                int[] nArray = rbh[i];
                if (!this.rbe[i] || (n3 & 1 << i) != 0 || !this.rbd[nArray[0]] || !this.rbd[nArray[1]] || !this.rbd[nArray[2]] || !this.rbd[nArray[3]]) continue;
                DrawUtil.quad(class_3322, this.rbc[nArray[0]][0], this.rbc[nArray[0]][1], n2, this.rbc[nArray[1]][0], this.rbc[nArray[1]][1], n2, this.rbc[nArray[2]][0], this.rbc[nArray[2]][1], n2, this.rbc[nArray[3]][0], this.rbc[nArray[3]][1], n2);
            }
        }
        if (bl) {
            return;
        }
        n2 = ColorUtil.withAlpha(n, 230);
        for (int[] nArray : rbi) {
            if (bl4 && n3 != 0 ? !this.rbw(qzt2, nArray[2], nArray[3], n3, bl3) : !this.rbe[nArray[2]] && !this.rbe[nArray[3]]) continue;
            double[] dArray = this.rbb[nArray[0]];
            double[] dArray2 = this.rbb[nArray[1]];
            if (bl2) {
                this.rbx(class_3322, usn2, dArray, dArray2, 0.0, 0.25, f2, n2);
                this.rbx(class_3322, usn2, dArray, dArray2, 0.75, 1.0, f2, n2);
                continue;
            }
            if (this.rbd[nArray[0]] && this.rbd[nArray[1]]) {
                DrawUtil.line(class_3322, this.rbc[nArray[0]][0], this.rbc[nArray[0]][1], this.rbc[nArray[1]][0], this.rbc[nArray[1]][1], f2, n2);
                continue;
            }
            this.rbx(class_3322, usn2, dArray, dArray2, 0.0, 1.0, f2, n2);
        }
    }

    private boolean rbw(qzt qzt2, int n, int n2, int n3, boolean bl) {
        boolean bl2 = (n3 & 1 << n) != 0;
        boolean bl3 = (n3 & 1 << n2) != 0;
        int[] nArray = raq[n];
        int[] nArray2 = raq[n2];
        boolean bl4 = this.rbt(qzt2.qzu, nArray[0] + nArray2[0], nArray[1] + nArray2[1], nArray[2] + nArray2[2], qzt2.qzv, bl);
        if (!(bl2 || bl3 || bl4)) {
            return this.rbe[n] || this.rbe[n2];
        }
        if (bl2 != bl3 && !bl4 || bl2 && bl3 && bl4) {
            return false;
        }
        long l = qzt2.qzu;
        if (bl2) {
            l = Math.min(l, class_2338.method_10096((long)qzt2.qzu, (int)nArray[0], (int)nArray[1], (int)nArray[2]));
        }
        if (bl3) {
            l = Math.min(l, class_2338.method_10096((long)qzt2.qzu, (int)nArray2[0], (int)nArray2[1], (int)nArray2[2]));
        }
        if (bl4) {
            l = Math.min(l, class_2338.method_10096((long)qzt2.qzu, (int)(nArray[0] + nArray2[0]), (int)(nArray[1] + nArray2[1]), (int)(nArray[2] + nArray2[2])));
        }
        return l == qzt2.qzu;
    }

    private void rbx(class_332 class_3322, ScreenProjection usn2, double[] dArray, double[] dArray2, double d, double d2, float f, int n) {
        if (usn2.projectSegment(dArray[0] + (dArray2[0] - dArray[0]) * d, dArray[1] + (dArray2[1] - dArray[1]) * d, dArray[2] + (dArray2[2] - dArray[2]) * d, dArray[0] + (dArray2[0] - dArray[0]) * d2, dArray[1] + (dArray2[1] - dArray[1]) * d2, dArray[2] + (dArray2[2] - dArray[2]) * d2, 0.05f, this.rbf, this.rbg)) {
            DrawUtil.line(class_3322, this.rbf[0], this.rbf[1], this.rbf[2], this.rbf[3], f, n);
        }
    }

    static {
        raq = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
        rau = ConcurrentHashMap.newKeySet();
        rbh = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
        rbi = new int[][]{{0, 1, 0, 2}, {2, 3, 1, 2}, {4, 5, 0, 3}, {6, 7, 1, 3}, {0, 2, 2, 4}, {1, 3, 2, 5}, {4, 6, 3, 4}, {5, 7, 3, 5}, {0, 4, 0, 4}, {1, 5, 0, 5}, {2, 6, 1, 4}, {3, 7, 1, 5}};
    }

    private static /* synthetic */ int bxc(int n, int n2) {
        return n * n2 ^ 0xB05CDDD2;
    }

    private static /* synthetic */ int bxd(int n, int n2) {
        return n - n2 | 0xD0995A3D;
    }
}

