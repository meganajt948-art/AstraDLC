/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.class_310
 *  net.minecraft.class_642
 */
package a;

import a.CloudSync;
import a.Theme;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.Waypoint;
import a.wlh;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.class_310;
import net.minecraft.class_642;

public final class Waypoints {
    public static final BoolSetting ENABLED;
    public static final ModeSetting COLOR;
    public static final ModeSetting COORDS;
    public static final BoolSetting DISTANCE;
    public static final NumberSetting SCALE;
    public static final BoolSetting CHAT;
    public static final List<Setting> DISPLAY;
    public static final List<Setting> ALL;
    private static final String wll;
    public static final int[] COLORS;
    private static final Gson wlm;
    private static final List<Waypoint> wln;
    private static boolean wlo;
    private static int wlp;
    private static final Map<Waypoint, Waypoint> wlq;
    private static /* synthetic */ String wlr;
    private static /* synthetic */ String wls;

    private Waypoints() {
    }

    public static int version() {
        return wlp;
    }

    public static List<Waypoint> inWorld() {
        Waypoints.wlu();
        String string = Waypoints.worldId();
        ArrayList<Waypoint> arrayList = new ArrayList<Waypoint>();
        for (Waypoint wkq2 : wln) {
            if (string != null && !string.equals(wkq2.world)) continue;
            arrayList.add(wkq2);
        }
        return arrayList;
    }

    public static List<Waypoint> drawable() {
        Waypoints.wlu();
        String string = Waypoints.worldId();
        String string2 = Waypoints.dimensionId();
        ArrayList<Waypoint> arrayList = new ArrayList<Waypoint>();
        if (string == null || string2 == null) {
            return arrayList;
        }
        for (Waypoint wkq3 : wln) {
            if (!wkq3.visible || !string.equals(wkq3.world)) continue;
            if (string2.equals(wkq3.dimension)) {
                arrayList.add(wkq3);
                continue;
            }
            Waypoint wkq4 = Waypoints.wlt(wkq3);
            if (wkq4 == null) continue;
            arrayList.add(wkq4);
        }
        wlq.keySet().removeIf(wkq2 -> !wln.contains(wkq2));
        return arrayList;
    }

    private static Waypoint wlt(Waypoint wkq3) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null || !"minecraft:overworld".equals(wkq3.dimension) || class_3102.field_1687.method_8597().comp_646() <= 1.0) {
            return null;
        }
        double d = class_3102.field_1687.method_8597().comp_646();
        int n = class_3102.field_1687.method_31607();
        int n2 = n + class_3102.field_1687.method_8597().comp_653() - 2;
        Waypoint wkq4 = wlq.computeIfAbsent(wkq3, wkq2 -> new Waypoint());
        wkq4.name = wkq3.name + "  ·  " + Waypoints.dimensionName(wkq3.dimension);
        wkq4.x = Math.floor(wkq3.x / d);
        wkq4.y = Math.max((double)(n + 1), Math.min((double)n2, wkq3.y));
        wkq4.z = Math.floor(wkq3.z / d);
        wkq4.color = wkq3.color;
        wkq4.ownColor = wkq3.ownColor;
        wkq4.world = wkq3.world;
        wkq4.dimension = Waypoints.dimensionId();
        wkq4.visible = true;
        wkq4.created = wkq3.created;
        return wkq4;
    }

    public static Waypoint here(Waypoint wkq2) {
        String string = Waypoints.dimensionId();
        if (string == null) {
            return null;
        }
        return string.equals(wkq2.dimension) ? wkq2 : Waypoints.wlt(wkq2);
    }

    public static boolean exists(double d, double d2, double d3) {
        Waypoints.wlu();
        String string = Waypoints.worldId();
        String string2 = Waypoints.dimensionId();
        for (Waypoint wkq2 : wln) {
            if (!Objects.equals(string, wkq2.world) || !Objects.equals(string2, wkq2.dimension) || Math.floor(wkq2.x) != Math.floor(d) || Math.floor(wkq2.y) != Math.floor(d2) || Math.floor(wkq2.z) != Math.floor(d3)) continue;
            return true;
        }
        return false;
    }

    public static int colorOf(Waypoint wkq2) {
        return COLOR.is("Theme") && !wkq2.ownColor ? Theme.accent() | 0xFF000000 : wkq2.color | 0xFF000000;
    }

    public static Waypoint add(String string, double d, double d2, double d3, int n) {
        Waypoints.wlu();
        Waypoint wkq2 = new Waypoint(string, d, d2, d3, n, Waypoints.worldId(), Waypoints.dimensionId());
        wln.add(wkq2);
        Waypoints.changed();
        return wkq2;
    }

    public static void remove(Waypoint wkq2) {
        wln.remove(wkq2);
        Waypoints.changed();
    }

    public static void changed() {
        ++wlp;
        Waypoints.wlv();
    }

    public static String worldId() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null) {
            return null;
        }
        try {
            if (class_3102.method_1542() && class_3102.method_1576() != null) {
                return "sp:" + class_3102.method_1576().method_27728().method_150();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        class_642 class_6422 = class_3102.method_1558();
        return class_6422 != null ? "mp:" + class_6422.field_3761 : "unknown";
    }

    public static String dimensionId() {
        class_310 class_3102 = class_310.method_1551();
        return class_3102.field_1687 == null ? null : class_3102.field_1687.method_27983().method_29177().toString();
    }

    /*
     * Exception decompiling
     */
    public static String dimensionName(String var0) {
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

    private static void wlu() {
        if (wlo) {
            return;
        }
        wlo = true;
        String string = CloudSync.get("waypoints");
        if (string == null || string.isBlank()) {
            return;
        }
        try {
            List list = (List)wlm.fromJson(string, new wlh().getType());
            if (list != null) {
                for (Waypoint wkq2 : list) {
                    if (wkq2 == null || wkq2.name == null) continue;
                    wln.add(wkq2);
                }
            }
        }
        catch (Exception exception) {
            System.out.println("can't read waypoints: " + exception);
        }
    }

    private static void wlv() {
        CloudSync.put("waypoints", wlm.toJson(wln));
    }

    static {
        wll = "minecraft:overworld";
        ENABLED = new BoolSetting("Show waypoints", true);
        COLOR = new ModeSetting("Colour", "Theme", "Theme", "Own");
        COORDS = new ModeSetting("Coordinates", "Always", "Always", "On aim", "Off");
        DISTANCE = new BoolSetting("Distance", true);
        SCALE = new NumberSetting("Size", 1.0, 0.6, 1.6, 0.05).percent();
        CHAT = new BoolSetting("Chat coordinates", true);
        DISPLAY = List.of(COLOR, COORDS, DISTANCE, SCALE, CHAT);
        ALL = List.of(ENABLED, COLOR, COORDS, DISTANCE, SCALE, CHAT);
        COLORS = new int[]{-7643914, -12877066, -14494738, -14498466, -340971, -429290, -1096636, -1292135};
        wlm = new GsonBuilder().setPrettyPrinting().create();
        wln = new ArrayList<Waypoint>();
        wlq = new IdentityHashMap<Waypoint, Waypoint>();
    }

    private static /* synthetic */ int drx(int n, int n2) {
        return n - n2 ^ 0x29BDCE49;
    }
}

