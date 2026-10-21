/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_10042
 *  net.minecraft.class_10055
 *  net.minecraft.class_11658
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1311
 *  net.minecraft.class_1321
 *  net.minecraft.class_1496
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_7923
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.FxPipeline;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.BoolSetting;
import a.ColorSetting;
import a.vlg;
import a.ListSetting;
import a.ModeSetting;
import a.NumberSetting;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_10055;
import net.minecraft.class_11658;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1321;
import net.minecraft.class_1496;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_7923;
import net.minecraft.class_9779;

public class MobEsp
extends Module {
    private static MobEsp rht;
    private final ListSetting rhu = this.add(new ListSetting("Mobs", vlg.MOBS, "minecraft:villager", "minecraft:zombie_villager", "minecraft:wandering_trader", "minecraft:iron_golem", "minecraft:snow_golem", "minecraft:magma_cube", "minecraft:wolf", "minecraft:cat", "minecraft:horse", "minecraft:donkey", "minecraft:mule", "minecraft:llama", "minecraft:parrot", "minecraft:allay", "minecraft:axolotl", "minecraft:shulker"));
    private final ModeSetting rhv = this.add(new ModeSetting("Mode", "Outline", "Outline", "Box"));
    private final BoolSetting rhw = this.add(new BoolSetting("Mob colors", true));
    private final ColorSetting rhx = this.add(new ColorSetting("Color", "Theme"));
    private final BoolSetting rhy = this.add(new BoolSetting("Only owned", false));
    private final NumberSetting rhz = this.add(new NumberSetting("Range", 96.0, 16.0, 256.0, 8.0).suffix("blocks"));
    private final NumberSetting ria = this.add(new NumberSetting("Outline", 1.0, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rib = this.add(new NumberSetting("Width", 1.5, 0.5, 4.0, 0.1));
    private final NumberSetting ric = this.add(new NumberSetting("Fill", 0.12, 0.0, 0.6, 0.01).percent());
    private final NumberSetting rid = this.add(new NumberSetting("Glow", 0.4, 0.0, 1.0, 0.05).percent());
    private boolean[] rie = new boolean[0];
    private int rif = -1;
    private long rig = -1L;
    private final double[][] rih = new double[8][3];
    private final float[][] rii = new float[8][2];
    private final boolean[] rij = new boolean[8];
    private final float[] rik = new float[4];
    private final float[] ril = new float[2];
    private static final int[][] rim;
    private static final int[][] rin;
    private static /* synthetic */ boolean rio;
    private static /* synthetic */ String rip;

    public MobEsp() {
        super(new String(new char[]{'M', 'o', 'b', 'E', 'S', 'P'}), "Chosen mobs through walls, each in its colour", ModuleCategory.RENDER);
        rht = this;
        this.rhx.visibleWhen(() -> !this.rhw.get());
        this.ria.visibleWhen(() -> this.rhv.is("Outline"));
        this.rid.visibleWhen(() -> this.rhv.is("Outline"));
    }

    public static MobEsp get() {
        return rht;
    }

    public boolean picks(class_1297 class_12972) {
        int n;
        block6: {
            block5: {
                if (!(class_12972 instanceof class_1309)) break block5;
                class_1309 class_13092 = (class_1309)class_12972;
                if (!(class_12972 instanceof class_1657) && class_13092.method_5805() && !class_12972.method_31481()) break block6;
            }
            return false;
        }
        if (this.rif != this.rhu.version()) {
            this.riq();
        }
        if ((n = class_7923.field_41177.method_10206((Object)class_12972.method_5864())) < 0 || n >= this.rie.length || !this.rie[n]) {
            return false;
        }
        return !this.rhy.get() || MobEsp.rir(class_12972);
    }

    public int colorOf(class_1297 class_12972) {
        return this.rhw.get() ? MobEsp.kindColor(class_12972) : this.rhx.color() | 0xFF000000;
    }

    private void riq() {
        boolean[] blArray = new boolean[class_7923.field_41177.method_10204()];
        for (String string : this.rhu.ids()) {
            int n;
            class_2960 class_29602 = class_2960.method_12829((String)string);
            if (class_29602 == null || !class_7923.field_41177.method_10250(class_29602) || (n = class_7923.field_41177.method_10206((Object)((class_1299)class_7923.field_41177.method_63535(class_29602)))) < 0 || n >= blArray.length) continue;
            blArray[n] = true;
        }
        this.rie = blArray;
        this.rif = this.rhu.version();
    }

    private static boolean rir(class_1297 class_12972) {
        class_1496 class_14962;
        class_1321 class_13212;
        if (class_12972 instanceof class_1321 && (class_13212 = (class_1321)class_12972).method_6181() || class_12972 instanceof class_1496 && (class_14962 = (class_1496)class_12972).method_6727()) {
            return true;
        }
        return class_12972.method_16914() || class_12972 instanceof class_1308 && (class_13212 = (class_1308)class_12972).method_60953();
    }

    public static int kindColor(class_1297 class_12972) {
        class_1299 class_12992 = class_12972.method_5864();
        if (class_12992 == class_1299.field_6077 || class_12992 == class_1299.field_17713) {
            return -12723068;
        }
        if (class_12992 == class_1299.field_6054) {
            return -6563510;
        }
        if (class_12992 == class_1299.field_6102) {
            return -48077;
        }
        if (class_12992 == class_1299.field_6069) {
            return -7607718;
        }
        if (class_12992 == class_1299.field_6147) {
            return -1517372;
        }
        if (class_12992 == class_1299.field_6047) {
            return -1641217;
        }
        if (class_12992 == class_1299.field_6099) {
            return -20163;
        }
        if (class_12992 == class_1299.field_6055 || class_12992 == class_1299.field_16281 || class_12992 == class_1299.field_6081 || class_12992 == class_1299.field_17943) {
            return -15253;
        }
        if (class_12992 == class_1299.field_6139 || class_12992 == class_1299.field_6067 || class_12992 == class_1299.field_6057 || class_12992 == class_1299.field_6074 || class_12992 == class_1299.field_17714 || class_12992 == class_1299.field_40116 || class_12992 == class_1299.field_6075 || class_12992 == class_1299.field_6048) {
            return -3632802;
        }
        if (class_12992 == class_1299.field_6104 || class_12992 == class_1299.field_38384) {
            return -11544321;
        }
        if (class_12992 == class_1299.field_28315) {
            return -29992;
        }
        if (class_12992 == class_1299.field_20346) {
            return -11443;
        }
        if (class_12992 == class_1299.field_6109 || class_12992 == class_1299.field_6091 || class_12992 == class_1299.field_6128) {
            return -5018625;
        }
        if (class_12992 == class_1299.field_22281 || class_12992 == class_1299.field_25751 || class_12992 == class_1299.field_6050) {
            return -11443;
        }
        if (class_12992 == class_1299.field_6085 || class_12992 == class_1299.field_6143) {
            return -4158870;
        }
        if (class_12992 == class_1299.field_6093 || class_12992 == class_1299.field_21973) {
            return -25932;
        }
        if (class_12992 == class_1299.field_6115 || class_12992 == class_1299.field_6132) {
            return -724502;
        }
        if (class_12992 == class_1299.field_6119 || class_12992 == class_1299.field_6116 || class_12992 == class_1299.field_38095) {
            return -53910;
        }
        class_1311 class_13112 = class_12992.method_5891();
        return switch (class_13112) {
            case class_1311.field_6302 -> -41378;
            case class_1311.field_6294 -> -8587360;
            case class_1311.field_6300, class_1311.field_30092, class_1311.field_24460, class_1311.field_34447 -> -11691009;
            case class_1311.field_6303 -> -5197638;
            default -> -1;
        };
    }

    private List<class_1309> ris(class_310 class_3102, class_243 class_2432, double d) {
        ArrayList<class_1309> arrayList = new ArrayList<class_1309>();
        double d2 = d * d;
        for (class_1297 class_12972 : class_3102.field_1687.method_18112()) {
            if (class_12972 == class_3102.method_1560() || !this.picks(class_12972) || !(class_12972.method_5707(class_2432) <= d2)) continue;
            arrayList.add((class_1309)class_12972);
        }
        arrayList.sort((class_13092, class_13093) -> Double.compare(class_13092.method_5707(class_2432), class_13093.method_5707(class_2432)));
        return arrayList;
    }

    public static void afterExtraction(class_11658 class_116582) {
        Object object2;
        MobEsp rhs2 = rht;
        class_310 class_3102 = class_310.method_1551();
        if (rhs2 == null || !rhs2.isEnabled() || !rhs2.rhv.is("Outline") || class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return;
        }
        class_243 class_2432 = class_3102.field_1773.method_19418().method_71156();
        List<class_1309> list = rhs2.ris(class_3102, class_2432, rhs2.rhz.get());
        if (list.isEmpty()) {
            return;
        }
        FxPipeline.style(4).set((float)rhs2.ric.get(), (float)rhs2.ria.get(), (float)rhs2.rib.get(), (float)rhs2.rid.get(), 0.4f, 0.6f);
        IdentityHashMap<class_1299, List> identityHashMap = new IdentityHashMap<class_1299, List>();
        for (Object object2 : class_116582.field_61735) {
            if (!(object2 instanceof class_10042)) continue;
            class_10042 class_100422 = (class_10042)object2;
            if (object2 instanceof class_10055 || ((class_10017)object2).field_58171 == null) continue;
            identityHashMap.computeIfAbsent(((class_10017)object2).field_58171, class_12992 -> new ArrayList()).add(class_100422);
        }
        float f = class_3102.method_61966().method_60637(true);
        object2 = new IdentityHashMap();
        for (class_1309 class_13092 : list) {
            List list2 = (List)identityHashMap.get(class_13092.method_5864());
            if (list2 == null) continue;
            class_243 class_2433 = class_13092.method_30950(f);
            class_10042 class_100423 = null;
            double d = 0.04;
            for (class_10042 class_100424 : list2) {
                double d2 = class_100424.field_53325 - class_2433.field_1352;
                double d3 = class_100424.field_53326 - class_2433.field_1351;
                double d4 = class_100424.field_53327 - class_2433.field_1350;
                double d5 = d2 * d2 + d3 * d3 + d4 * d4;
                if (!(d5 < d) || object2.containsKey(class_100424)) continue;
                d = d5;
                class_100423 = class_100424;
            }
            if (class_100423 == null) continue;
            object2.put(class_100423, Boolean.TRUE);
            int n = rhs2.colorOf((class_1297)class_13092);
            FxPipeline.paint(class_100423, 4, n, ColorUtil.lerp(n, -1, 0.35f));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        MobEsp rhs2 = rht;
        class_310 class_3102 = class_310.method_1551();
        if (rhs2 == null || !rhs2.isEnabled() || !rhs2.rhv.is("Box") || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == rhs2.rig) {
            return;
        }
        rhs2.rig = FrameDelta.frame();
        float f = class_97792.method_60637(true);
        try {
            usn2 = ScreenProjection.capture(f, class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        List<class_1309> list = rhs2.ris(class_3102, usn2.camera(), rhs2.rhz.get());
        if (list.isEmpty()) {
            return;
        }
        DrawUtil.beginFrame();
        DrawUtil.beginBatch();
        try {
            for (int i = list.size() - 1; i >= 0; --i) {
                class_1309 class_13092 = list.get(i);
                rhs2.rit(class_3322, usn2, class_13092, class_13092.method_30950(f), rhs2.colorOf((class_1297)class_13092));
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    private void rit(class_332 class_3322, ScreenProjection usn2, class_1309 class_13092, class_243 class_2432, int n) {
        int n2;
        double d = (double)class_13092.method_17681() * 0.5 + 0.02;
        double d2 = (double)class_13092.method_17682() + 0.02;
        for (int i = 0; i < 8; ++i) {
            this.rih[i][0] = (i & 1) == 0 ? class_2432.field_1352 - d : class_2432.field_1352 + d;
            this.rih[i][1] = (i & 2) == 0 ? class_2432.field_1351 : class_2432.field_1351 + d2;
            this.rih[i][2] = (i & 4) == 0 ? class_2432.field_1350 - d : class_2432.field_1350 + d;
            this.rij[i] = usn2.depth(this.rih[i][0], this.rih[i][1], this.rih[i][2]) > 0.05f && usn2.project(this.rih[i][0], this.rih[i][1], this.rih[i][2], this.rii[i]);
        }
        float f = (float)this.ric.get();
        if (f > 0.005f) {
            class_243 class_2433 = usn2.camera();
            n2 = ColorUtil.withAlpha(n, Math.round(255.0f * f));
            int n3 = ColorUtil.withAlpha(n, Math.round(255.0f * f * 0.25f));
            for (int i = 0; i < 6; ++i) {
                int[] nArray = rin[i];
                if (!this.rij[nArray[0]] || !this.rij[nArray[1]] || !this.rij[nArray[2]] || !this.rij[nArray[3]] || !MobEsp.riu(i, class_2433, class_2432, d, d2)) continue;
                DrawUtil.quad(class_3322, this.rii[nArray[0]][0], this.rii[nArray[0]][1], (nArray[0] & 2) != 0 ? n2 : n3, this.rii[nArray[1]][0], this.rii[nArray[1]][1], (nArray[1] & 2) != 0 ? n2 : n3, this.rii[nArray[2]][0], this.rii[nArray[2]][1], (nArray[2] & 2) != 0 ? n2 : n3, this.rii[nArray[3]][0], this.rii[nArray[3]][1], (nArray[3] & 2) != 0 ? n2 : n3);
            }
        }
        float f2 = (float)this.rib.get();
        n2 = ColorUtil.withAlpha(n, 220);
        for (int[] nArray : rim) {
            double[] dArray = this.rih[nArray[0]];
            double[] dArray2 = this.rih[nArray[1]];
            if (!usn2.projectSegment(dArray[0], dArray[1], dArray[2], dArray2[0], dArray2[1], dArray2[2], 0.05f, this.rik, this.ril)) continue;
            DrawUtil.line(class_3322, this.rik[0], this.rik[1], this.rik[2], this.rik[3], f2, n2);
        }
    }

    private static boolean riu(int n, class_243 class_2432, class_243 class_2433, double d, double d2) {
        return switch (n) {
            case 0 -> {
                if (class_2432.field_1351 < class_2433.field_1351) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (class_2432.field_1351 > class_2433.field_1351 + d2) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (class_2432.field_1350 < class_2433.field_1350 - d) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (class_2432.field_1350 > class_2433.field_1350 + d) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if (class_2432.field_1352 < class_2433.field_1352 - d) {
                    yield true;
                }
                yield false;
            }
            default -> class_2432.field_1352 > class_2433.field_1352 + d;
        };
    }

    static {
        rim = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
        rin = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
    }

    private static /* synthetic */ int byx(int n, int n2) {
        return n + n2 ^ 0x7E9DFB35;
    }
}

