/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ServerInfo
 */
package a;

import a.ewk;
import a.iov;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import a.wkq;
import a.wlh;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import flow.dev.a;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public final class wlk {
    public static final vkl ENABLED;
    public static final vlv COLOR;
    public static final vlv COORDS;
    public static final vkl DISTANCE;
    public static final vmc SCALE;
    public static final vkl CHAT;
    public static final List<vmo> DISPLAY;
    public static final List<vmo> ALL;
    private static final String wll;
    public static final int[] COLORS;
    private static final Gson wlm;
    private static final List<wkq> wln;
    private static boolean wlo;
    private static int wlp;
    private static final Map<wkq, wkq> wlq;
    private static /* synthetic */ String wlr;
    private static /* synthetic */ String wls;

    private wlk() {
    }

    public static int version() {
        return wlp;
    }

    public static List<wkq> inWorld() {
        wlk.wlu();
        String string = wlk.worldId();
        ArrayList<wkq> arrayList = new ArrayList<wkq>();
        for (wkq wkq2 : wln) {
            if (string != null && !string.equals(wkq2.world)) continue;
            arrayList.add(wkq2);
        }
        return arrayList;
    }

    public static List<wkq> drawable() {
        wlk.wlu();
        String string = wlk.worldId();
        String string2 = wlk.dimensionId();
        ArrayList<wkq> arrayList = new ArrayList<wkq>();
        if (string == null || string2 == null) {
            return arrayList;
        }
        for (wkq wkq3 : wln) {
            if (!wkq3.visible || !string.equals(wkq3.world)) continue;
            if (string2.equals(wkq3.dimension)) {
                arrayList.add(wkq3);
                continue;
            }
            wkq wkq4 = wlk.wlt(wkq3);
            if (wkq4 == null) continue;
            arrayList.add(wkq4);
        }
        wlq.keySet().removeIf(wkq2 -> !wln.contains(wkq2));
        return arrayList;
    }

    private static wkq wlt(wkq wkq3) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null || !a.d("\uee80\u9735\u1de1\u839b\u084a\u8eea\u34aa\ubd5c\u2311\ua9ee\u2e68\ud400\u5ac4\uc362\u4934\ucfdd\u758f\ufa40\u60fb", 742262319, -1756239663).equals(wkq3.dimension) || minecraftClient.world.getDimension().coordinateScale() <= 1.0) {
            return null;
        }
        double d = minecraftClient.world.getDimension().coordinateScale();
        int n = minecraftClient.world.getBottomY();
        int n2 = n + minecraftClient.world.getDimension().logicalHeight() - 2;
        wkq wkq4 = wlq.computeIfAbsent(wkq3, wkq2 -> new wkq());
        wkq4.name = wkq3.name + a.c(-672317879, "\u3e6c\u47dd\ucd99\u537f\ud8a8") + wlk.dimensionName(wkq3.dimension);
        wkq4.x = Math.floor(wkq3.x / d);
        wkq4.y = Math.max((double)(n + 1), Math.min((double)n2, wkq3.y));
        wkq4.z = Math.floor(wkq3.z / d);
        wkq4.color = wkq3.color;
        wkq4.ownColor = wkq3.ownColor;
        wkq4.world = wkq3.world;
        wkq4.dimension = wlk.dimensionId();
        wkq4.visible = true;
        wkq4.created = wkq3.created;
        return wkq4;
    }

    public static wkq here(wkq wkq2) {
        String string = wlk.dimensionId();
        if (string == null) {
            return null;
        }
        return string.equals(wkq2.dimension) ? wkq2 : wlk.wlt(wkq2);
    }

    public static boolean exists(double d, double d2, double d3) {
        wlk.wlu();
        String string = wlk.worldId();
        String string2 = wlk.dimensionId();
        for (wkq wkq2 : wln) {
            if (!Objects.equals(string, wkq2.world) || !Objects.equals(string2, wkq2.dimension) || Math.floor(wkq2.x) != Math.floor(d) || Math.floor(wkq2.y) != Math.floor(d2) || Math.floor(wkq2.z) != Math.floor(d3)) continue;
            return true;
        }
        return false;
    }

    public static int colorOf(wkq wkq2) {
        return COLOR.is(a.b("\u6173\u18fe\u9220\u0c59\u8786", -48733918)) && !wkq2.ownColor ? iov.accent() | 0xFF000000 : wkq2.color | 0xFF000000;
    }

    public static wkq add(String string, double d, double d2, double d3, int n) {
        wlk.wlu();
        wkq wkq2 = new wkq(string, d, d2, d3, n, wlk.worldId(), wlk.dimensionId());
        wln.add(wkq2);
        wlk.changed();
        return wkq2;
    }

    public static void remove(wkq wkq2) {
        wln.remove(wkq2);
        wlk.changed();
    }

    public static void changed() {
        ++wlp;
        wlk.wlv();
    }

    public static String worldId() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
            return null;
        }
        try {
            if (minecraftClient.isInSingleplayer() && minecraftClient.getServer() != null) {
                return a.d("\u42c0\u3b72\ub1eb", -661889245, 1120214419) + minecraftClient.getServer().getSaveProperties().getLevelName();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        ServerInfo serverInfo = minecraftClient.getCurrentServerEntry();
        return serverInfo != null ? a.c(-1514144637, "\ufced\u8541\u0fd8") + serverInfo.address : a.d("\u8406\ufdac\u777a\ue90e\u62d8\ue471\u5e3b", 773352640, 315484340);
    }

    public static String dimensionId() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        return minecraftClient.world == null ? null : minecraftClient.world.getRegistryKey().getValue().toString();
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
        String string = ewk.get(a.c(1204147723, "\ud675\uafd2\u2519\ubb61\u30a9\ub61e\u0c4a\u85a1\u1bf9"));
        if (string == null || string.isBlank()) {
            return;
        }
        try {
            List list = (List)wlm.fromJson(string, new wlh().getType());
            if (list != null) {
                for (wkq wkq2 : list) {
                    if (wkq2 == null || wkq2.name == null) continue;
                    wln.add(wkq2);
                }
            }
        }
        catch (Exception exception) {
            System.out.println(a.d("\u20cf\u597c\ud3a0\u4d98\uc61c\u40f9\ufaf8\u731e\ued45\u67f1\ue066\u1a40\u9481\u0d28\u8772\u019c\ubbd5\u3403\uaeaa\u28fc\ua142\udb09", 124161895, 1043771357) + exception);
        }
    }

    private static void wlv() {
        ewk.put(a.d("\ud736\uae91\u245a\uba22\u31ea\ub75d\u0d09\u84e2\u1aba", 420154200, -1658463216), wlm.toJson(wln));
    }

    static {
        wll = a.d("\uc29d\ubb28\u31fc\uaf86\u2457\ua2f7\u18b7\u9141\u0f0c\u85f3\u0275\uf81d\u76d9\uef7f\u6529\ue3c0\u5992\ud65d\u4ce6", 1813012103, 533175396);
        ENABLED = new vkl(a.d("\u1796\u6e1c\ue4c8\u7aa1\uf121\u77c7\ucd82\u446b\uda3d\u5093\ud746\u2d30\ua3fd\u3a4b", -1273135039, -1057646710), true);
        COLOR = new vlv(a.d("\udee4\ua779\u2da9\ub3db\u3816\ubea0", -1944053484, 1848690613), a.b("\u046f\u7de2\uf73c\u6945\ue29a", 782828606), a.d("\u6564\u1ce9\u9637\u084e\u8391", -1414680626, -1757099269), a.b("\u7d8e\u0407\u8ecd", 1115061698));
        COORDS = new vlv(a.d("\ua87c\ud1e1\u5b32\uc55e\u4e9f\uc823\u7277\ufb89\u65c3\uef63\u68a6", 479382896, -657889980), a.d("\ub0a5\uc939\u43f1\udd96\u5659\ud0e2", 246819694, -849306740), a.d("\uef52\u96ce\u1c06\u8261\u09ae\u8f15", 744114982, 858498099), a.c(21325353, "\u6660\u1ff0\u956d\u0b5d\u8082\u0637"), a.d("\ufb3c\u82a4\u0877", 244537043, -342184541));
        DISTANCE = new vkl(a.d("\u2e7f\u57e3\udd2a\u435c\uc89e\u4e20\uf47e\u7d89", -849862821, -1279708824), true);
        SCALE = new vmc(a.d("\u9a9d\ue316\u69d6\uf7b8", 2064945152, -419034422), 1.0, 0.6, 1.6, 0.05).percent();
        CHAT = new vkl(a.d("\ud549\uacd3\u2609\ub86d\u33ee\ub51c\u0f43\u86b2\u18f0\u9257\u1589\uefff\u6127\uf883\u72c1\uf426", -1964050937, 595469085), true);
        DISPLAY = List.of(COLOR, COORDS, DISTANCE, SCALE, CHAT);
        ALL = List.of(ENABLED, COLOR, COORDS, DISTANCE, SCALE, CHAT);
        COLORS = new int[]{-7643914, -12877066, -14494738, -14498466, -340971, -429290, -1096636, -1292135};
        wlm = new GsonBuilder().setPrettyPrinting().create();
        wln = new ArrayList<wkq>();
        wlq = new IdentityHashMap<wkq, wkq>();
    }

    private static /* synthetic */ int drx(int n, int n2) {
        return n - n2 ^ 0x29BDCE49;
    }
}

