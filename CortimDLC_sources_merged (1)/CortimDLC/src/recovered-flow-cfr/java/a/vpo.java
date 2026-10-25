/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.voa;
import a.voq;
import a.vow;
import a.vpd;
import a.vpi;
import flow.config.ConfigManager;
import flow.dev.a;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class vpo {
    private static final List<String> vpp;
    private static final long vpq = 0x1800000L;
    private static final int vpr = 12;
    private static final int vps = 12;
    private static final Map<String, Object[]> vpt;
    private static volatile voq vpu;
    private static volatile int vpv;
    private static boolean vpw;
    private static final Set<String> vpx;
    private static final int[] vpy;
    private static final int[] vpz;
    private static final String vqa;
    private static /* synthetic */ int vqb;
    private static /* synthetic */ String vqc;

    private vpo() {
    }

    public static Path dir() {
        return ConfigManager.gameDir().resolve(a.c(628241496, "\u343b\u4d80\uc750\u5939\ud2ab")).resolve(a.b("\u2304\u5aa9\ud060\u4e0a\uc5d7\u4371", -1625480335));
    }

    public static int version() {
        return vpv;
    }

    public static List<String> extras() {
        return vpu.extras();
    }

    public static synchronized boolean scan() {
        Object object2;
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        arrayList.sort((path, path2) -> {
            int n = vpo.vqf(path).compareToIgnoreCase(vpo.vqf(path2));
            return n != 0 ? n : vpp.indexOf(vpo.vqg(path)) - vpp.indexOf(vpo.vqg(path2));
        });
        for (Object object2 : arrayList) {
            try {
                stringBuilder.append(object2.getFileName()).append('|').append(Files.size((Path)object2)).append('|').append(Files.getLastModifiedTime((Path)object2, new LinkOption[0]).toMillis()).append('\n');
            }
            catch (IOException iOException) {
                stringBuilder.append(object2.getFileName()).append('\n');
            }
        }
        String string = stringBuilder.toString();
        if (string.equals(vpu.signature())) {
            return false;
        }
        object2 = new HashMap();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (Path path3 : arrayList) {
            String string2 = vpo.vqf(path3);
            String string3 = vpo.vqd(string2);
            Boolean bl = null;
            if (string3.endsWith(a.d("\u9f92\ue613\u6cc1", 705246752, 672377326))) {
                bl = Boolean.TRUE;
                string3 = string3.substring(0, string3.length() - 3);
                string2 = string2.substring(0, string2.length() - 3);
            } else if (string3.endsWith(a.c(-335423594, "\ud7cd\uae4c\u2496\ubae7"))) {
                bl = Boolean.FALSE;
                string3 = string3.substring(0, string3.length() - 4);
                string2 = string2.substring(0, string2.length() - 4);
            }
            if (string3.isEmpty() || string3.equals(a.b("\ud256\uabee\u213d", -1041116614)) || string3.equals(a.c(719615023, "\u745b\u0dfd\u872a\u195e\u9280\u1439"))) continue;
            Object[] objectArray = vpt.get(string3);
            String string4 = string2.strip();
            if (objectArray != null) {
                string4 = (String)objectArray[0];
                if (bl == null) {
                    bl = (Boolean)objectArray[1];
                }
            } else if (!object2.containsKey(string3)) {
                if (arrayList2.size() >= 12) continue;
                arrayList2.add(string4);
            }
            String string5 = objectArray != null ? vpo.vqd(string4) : string3;
            vow vow2 = object2.getOrDefault(string5, new vow(string4, null, null, null));
            object2.put(string5, vow2.with(bl, path3));
        }
        arrayList2.sort(String.CASE_INSENSITIVE_ORDER);
        vpu = new voq(string, Map.copyOf(object2), List.copyOf(arrayList2));
        ++vpv;
        if (!arrayList.isEmpty()) {
            System.out.println(a.b("\u5514\u2cb9\ua670\u381a\ub3c7\u3532\u8f27\u06d9\u9883\u123b\u95fe\u6fc6\ue10b", -564963990) + object2.keySet());
        }
        return true;
    }

    static vpd find(String string, boolean bl) {
        Path path;
        vow vow2 = vpu.sounds().get(vpo.vqd(string));
        if (vow2 == null) {
            return null;
        }
        Path path2 = path = bl ? vow2.on() : vow2.off();
        if (path != null) {
            return new vpd(path, true);
        }
        if (vow2.both() != null) {
            return new vpd(vow2.both(), false);
        }
        Path path3 = bl ? vow2.off() : vow2.on();
        return path3 != null ? new vpd(path3, false) : null;
    }

    public static void openFolder() {
    }

    private static String vqd(String string) {
        return string.toLowerCase(Locale.ROOT).strip().replace(' ', '_').replace('-', '_');
    }

    private static void vqe(String string, Boolean bl, String ... stringArray) {
        for (String string2 : stringArray) {
            vpt.putIfAbsent(vpo.vqd(string2), new Object[]{string, bl});
        }
    }

    private static String vqf(Path path) {
        String string = path.getFileName().toString();
        int n = string.lastIndexOf(46);
        return n > 0 ? string.substring(0, n) : string;
    }

    private static String vqg(Path path) {
        String string = path.getFileName().toString();
        int n = string.lastIndexOf(46);
        return n > 0 ? string.substring(n + 1).toLowerCase(Locale.ROOT) : "";
    }

    static vpi decode(Path path) {
        try {
            if (Files.size(path) > 0x1800000L) {
                throw new IOException(a.c(1262043665, "\u4262\u3bc8\ub11b\u2f25\ua4b0\u220a\u9857"));
            }
            return vpo.decode(Files.readAllBytes(path));
        }
        catch (Exception exception) {
            if (vpx.add(path.getFileName() + a.c(-1445792464, "\uf54d") + exception.getMessage())) {
                System.out.println(a.d("\u8697\uff24\u75f8\uebc0\u6044\ue6a1\u5ca2\ud54f\u4b1d\uc1b4\u463e", -595427607, -1781467114) + path.getFileName() + a.b("\u78ce\u0165", -93030154) + exception.getMessage());
            }
            return null;
        }
    }

    static vpi decode(byte[] byArray) throws Exception {
        vpi vpi2;
        if (vpo.vqn(byArray, 0, a.d("\u377a\u4ed0\uc40c\u5a7d", 1510737535, -1430245037)) && vpo.vqn(byArray, 8, a.d("\u02d3\u7b74\uf1b0\u6fd2", 218297335, -439684745))) {
            vpi2 = vpo.vqh(byArray);
        } else if (vpo.vqn(byArray, 0, a.d("\u239d\u5a25\ud0eb\u4e85", -556881577, 118327944)) && (vpo.vqn(byArray, 8, a.d("\u6e05\u17bc\u9d60\u0311", 537474056, -395158968)) || vpo.vqn(byArray, 8, a.b("\uddc3\ua47a\u2ea6\ub0d2", -1010115194)))) {
            vpi2 = vpo.vqi(byArray, vpo.vqn(byArray, 8, a.c(-148082017, "\u72da\u0b63\u81bf\u1fcb")));
        } else if (vpo.vqn(byArray, 0, a.c(1987347617, "\u84c6\ufd75\u77a1\ue9d0"))) {
            vpi2 = vpo.vqj(byArray);
        } else if (vpo.vqn(byArray, 0, a.d("\u55d1\u2c48\ua69b\u38de", 1564389092, 1580661630))) {
            vpi2 = vpo.vqk(byArray);
        } else {
            throw new IOException(a.b("\uc153\ub8e3\u322b\uac0e\u27ae\ua109\u1b4d\u92c6\u0c95\u8645\u019e\ufbe0\u7537\uecec\u66b3\ue021\u5a6c\ud5ba\u4f6f\uc971\u409b\u3a98\ub444\u2f9d\ua9e2\u2354\u9aae\u14f8\u8e12\u0859\u83e7\u7d37\uf73d\u6ec4\ue8f2\u625e\uddea\u5788\ud154\u48ea\uc2d8\ubc50\u3676\ub1bc\u2b71\ua543\u1c9c\u962c\u107b\u8bb9\u05dd\uff0a\u76e9\uf0f1\u6a1f\ue41a\u5ff1\ud93b\u5307\ucaa1\u4400\u3e46\ub9ca", 1946665218));
        }
        if (vpi2.data().length == 0) {
            throw new IOException(a.b("\ue3c5\u9a75\u10e9\u8ecb\u0500\u83ab\u39e3\ub018\u2e03\ua4fb\u232f\ud910\u578e\uce22", -1530207323));
        }
        return vpi2;
    }

    private static vpi vqh(byte[] byArray) throws IOException {
        int n = -1;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = -1;
        int n6 = 0;
        int n7 = 12;
        while (n7 + 8 <= byArray.length) {
            int n8 = vpo.vqp(byArray, n7 + 4);
            int n9 = n7 + 8;
            if (vpo.vqn(byArray, n7, a.d("\u6e11\u17ab\u9d61\u0344", 397683529, -1392491206)) && n9 + 16 <= byArray.length) {
                n = vpo.vqo(byArray, n9);
                n2 = vpo.vqo(byArray, n9 + 2);
                n3 = vpo.vqp(byArray, n9 + 4);
                n4 = vpo.vqo(byArray, n9 + 14);
                if (n == 65534 && n8 >= 26 && n9 + 26 <= byArray.length) {
                    n = vpo.vqo(byArray, n9 + 24);
                }
            } else if (vpo.vqn(byArray, n7, a.c(646063297, "\u24a1\u5d15\ud7d3\u49b7"))) {
                n5 = n9;
                n6 = n8 < 0 || n8 > byArray.length - n9 ? byArray.length - n9 : n8;
                break;
            }
            if (n8 < 0 || n8 > byArray.length) break;
            n7 = n9 + n8 + (n8 & 1);
        }
        if (n5 < 0 || n2 <= 0 || n3 <= 0) {
            throw new IOException(a.d("\u8ef0\uf751\u7d9f\ue3ea\u6833\uee89\u5494\udd12\u435b\uc9fd", -471103408, 1877280456));
        }
        return switch (n) {
            case 1 -> vpo.vql(byArray, n5, n6, n2, n4, true, false, n4 == 8, n3);
            case 3 -> vpo.vql(byArray, n5, n6, n2, n4, true, true, false, n3);
            default -> throw new IOException(a.d("\u42c7\u3b60\ub1a4\u2fa3\ua432\u228a\u98c4\u112a\u8f79\u05dd\u825a", -1771256324, -1848015001) + n + a.b("\u159a\u6c23\ue6b7\u78c7\uf312\u75b6\ucfbc\u461d\ud85e\u52e2\ud539\u2f4f\ua1d6\u3817\ub257\u34a8\u8e8a\u0114\u9bba\u1db9\u9408\uee53\u60e3\ufb3c\u7d56\uf7da\u4e7a\uc031\u5a85\udcd8\u576a\ua9a3\u23ff\uba19\u3c4c\ub6a9\u0937\u835b", 78452124));
        };
    }

    /*
     * Exception decompiling
     */
    private static vpi vqi(byte[] var0, boolean var1_1) throws IOException {
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

    /*
     * Exception decompiling
     */
    private static vpi vqj(byte[] var0) throws IOException {
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

    /*
     * Exception decompiling
     */
    private static vpi vqk(byte[] var0) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    private static vpi vql(byte[] byArray, int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, int n5) throws IOException {
        int n6 = (n4 + 7) / 8;
        if (n6 < 1 || n6 > 8 || bl2 && n6 != 4 && n6 != 8) {
            throw new IOException(n4 + a.d("\ufa4e\u83b0\u0968\u9704\u1c87\u9a65\u2024\ua9d9\u379b\ubd36\u3aec\uc08b", -2090071957, 868807172));
        }
        int n7 = Math.min(2, n3);
        int n8 = Math.min(n2 / (n6 * n3), n5 * 12);
        short[] sArray = new short[n8 * n7];
        for (int i = 0; i < n8; ++i) {
            for (int j = 0; j < n7; ++j) {
                int n9;
                int n10;
                int n11 = n + (i * n3 + j) * n6;
                long l = 0L;
                for (n10 = 0; n10 < n6; ++n10) {
                    n9 = byArray[n11 + (bl ? n6 - 1 - n10 : n10)] & 0xFF;
                    l = l << 8 | (long)n9;
                }
                if (bl2) {
                    double d = n6 == 4 ? (double)Float.intBitsToFloat((int)l) : Double.longBitsToDouble(l);
                    n10 = (int)Math.round(Math.max(-1.0, Math.min(1.0, d)) * 32767.0);
                } else if (bl3) {
                    n10 = (int)(l - 128L) << 8;
                } else {
                    n9 = 64 - n6 * 8;
                    long l2 = l << n9 >> n9;
                    n10 = n6 >= 2 ? (int)(l2 >> n6 * 8 - 16) : (int)(l2 << 8);
                }
                sArray[i * n7 + j] = (short)n10;
            }
        }
        return new vpi(sArray, n7, n5);
    }

    private static vpi vqm(byte[] byArray, int n, int n2, int n3, int n4) {
        int n5 = 34 * n3;
        int n6 = Math.min(n2 / n5, (n4 * 12 + 63) / 64);
        int n7 = Math.min(2, n3);
        short[] sArray = new short[n6 * 64 * n7];
        for (int i = 0; i < n6; ++i) {
            for (int j = 0; j < n7; ++j) {
                int n8 = n + i * n5 + j * 34;
                int n9 = (byArray[n8] & 0xFF) << 8 | byArray[n8 + 1] & 0xFF;
                int n10 = n9 & 0xFF80;
                int n11 = Math.min(88, n9 & 0x7F);
                for (int k = 0; k < 64; ++k) {
                    int n12 = byArray[n8 + 2 + k / 2] & 0xFF;
                    int n13 = (k & 1) == 0 ? n12 & 0xF : n12 >> 4;
                    int n14 = vpy[n11];
                    int n15 = n14 >> 3;
                    if ((n13 & 4) != 0) {
                        n15 += n14;
                    }
                    if ((n13 & 2) != 0) {
                        n15 += n14 >> 1;
                    }
                    if ((n13 & 1) != 0) {
                        n15 += n14 >> 2;
                    }
                    n10 += (n13 & 8) != 0 ? -n15 : n15;
                    n10 = Math.max(Short.MIN_VALUE, Math.min(Short.MAX_VALUE, n10));
                    n11 = Math.max(0, Math.min(88, n11 + vpz[n13]));
                    sArray[(i * 64 + k) * n7 + j] = (short)n10;
                }
            }
        }
        return new vpi(sArray, n7, n4);
    }

    private static boolean vqn(byte[] byArray, int n, String string) {
        if (n + 4 > byArray.length) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            if (byArray[n + i] == (byte)string.charAt(i)) continue;
            return false;
        }
        return true;
    }

    private static int vqo(byte[] byArray, int n) {
        return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8;
    }

    private static int vqp(byte[] byArray, int n) {
        return vpo.vqo(byArray, n) | vpo.vqo(byArray, n + 2) << 16;
    }

    private static int vqq(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF;
    }

    private static int vqr(byte[] byArray, int n) {
        return vpo.vqq(byArray, n) << 16 | vpo.vqq(byArray, n + 2);
    }

    private static long vqs(byte[] byArray, int n) {
        return (long)vpo.vqr(byArray, n) << 32 | (long)vpo.vqr(byArray, n + 4) & 0xFFFFFFFFL;
    }

    private static double vqt(byte[] byArray, int n) {
        int n2 = (byArray[n] & 0x7F) << 8 | byArray[n + 1] & 0xFF;
        long l = 0L;
        for (int i = 0; i < 8; ++i) {
            l = l << 8 | (long)(byArray[n + 2 + i] & 0xFF);
        }
        if (n2 == 0 && l == 0L) {
            return 0.0;
        }
        double d = (double)(l >>> 1) * Math.pow(2.0, n2 - 16383 - 62);
        return (byArray[n] & 0x80) != 0 ? -d : d;
    }

    static {
        vqa = a.d("\uc7e3\ube78\u34a8\uaac1\u2153\ua7f0\u1dae\u9452\u0e1a\u84ae\u030c\uf904\u77d1\uea78\u6024\ue6da\u5cc6\ud30b\u49a2\ucfe8\u4615\u3c53\ub299\u297f\uaf00\u25d1\u9c62\u1233\u88c4\u0e95\u8526\u7bf7\uf1b8\u6849\uee1a\u64ab\udb7c\u510d\ud7de\u4e6f\uc430\ubac1\u3092\ub723\u2df4\ua3b2\u1a61\u94c5\u12ab\u897f\u0709\ufdd0\u7469\uf620\u68b2\ue6ec\u5d29\udbfc\u559f\uc82a\u46e9\u3cb1\ubb40\u3161\uabc5\u2663\u9c35\u1ab5\u909b\u0f2e\u85f1\u0792\ufe40\u74fc\ueacc\u6112\ue740\u5dfd\ud425\u4a4e\uc0a6\u46cb\u3d62\ub3a8\u29d5\ua013\u26f3\u98b3\u173e\u8d18\u0baa\u820c\u7c19\uf6d0\u6d68\ueb4a\u61f5\udff6\u562b\uc8f6\u4ab9\uc135\ubb03\u35a0\uac71\u2a09\ua0ae\u1f1c\u9537\u17d8\u89ea(\ufeeb\u74bc\uf332\u6d08\ue39b\u5e64\ud40d\u52a2\uc961\u473c\u3dbd\ubbe5\u3623\uace8\u22ec\u992b\u1f73\u95b8\u0c67\u8277\u78a8\uff16\u7545\uebde\u618d\ud85f\u5e8e\ud4f8\u4b45\uc1f8\u47c4\u3e3d\ub472\u2aca\ua177\u274b\u9da1\u1393\u8a3c\u008f\u8689\u7d2d\uf3ff\u69a3\ue059\u6217\ud8ae\u570a\ucd30\u4bc6\uc192\ub822\u36f9\ua890\u2b51\ua5f2\u1bda\u923d\u0879\u8eb0\u0543\ufb32\u75f3\uec66\u6a5a\ue4e4\u5ef3\ud556\u53e8\uc9bb\u4043\u3a02\ub0a0\u376c\ua908\u27dc\u9e1a\u1432\u96db\u0c82\u8725\u7de1\ufbb4\u724e\ue860\u66d2\udd03\u5f12\ud1d5\u4c7c\uc64f\ubcce\u3ae8\ub150\u2ff3\ua5fa\u1c40\u9a19\u10af\u8f73\u0111\u83dd\u7a66\uf422\u6ecf\ue49c\u6329\ud9f3\u57f2\uca41\u40e1\uc6aa\ubd21\u3346\ua988\u2026\ua62d\u1cd0\u92d3\u097d\u8fbd\u0590\ufc4f\u72ac\ue8e0\u6f08\ue55b\u5bf6\ud230\u4828\uced7\u44c2\u3b74\ub1b7\u379f\uae42\u24bf\u9ae0\u1110\u9741\u0de9\u8464\u7a1b\uf09a\u76c9\ued7d\u63a9\ud9dd\u504d\ud6f0\u4cf0\uc31d\ub949\u3ffd\ub663\u2c1e\ua28a\u193d\u9f67\u159f\u8bc6\u0210\uf8be\u7ee7\uf51d\u6b0c\ue1b3\u5820\ude48\u548e\ucb3d\u4162\uc79c\ubd84\u343b\uaabe\u20f2\ua71d\u1d49\u93fd\u0a2d\u8055\u06e9\uf970\u7733\uedc7\u6be3\ue224\u58f7\ud298\u4d5f\ucbe1\u41da\u3c64\ub605\u2cdc\uab6a\u214e\u9fb4\u1597\u8c20\u0af4\u80f0\u7b4e\uf1f6\u77a8\uea49\u6061\udedf\u556f\ud349\u49b1\uc794\ube2d\u34fb\ub2fd\u2d57\ua3fc\u19b3\u9446\u1215\u88d7\u0375\uf965\u7f9a\uf5ca\u6c37\ue2e9\u5891\udf5c\u51eb\ucfbe\u4632\u3812\ubec0\u3521\uab5f\u218e\u987b\u1e22\u90f8\u0e84\u8558\u0396\uf9b9\u704c\uee16\u64d2\ue76d\u5d5e\ud39a\u4a3c\uc06b\u4694\u3cce\ub345\u29ba\uafe2\u2611\u9c08\u12e6\u8921\u0f45\u85cb\u7c73\uf206\u6cee\uea9b\u612e\udbe8\u55fa\ucc58\u4a1b\uc0a1\ubf74\u3508\ub7c1\u2e0f\ua46c\u1a94\u90cb\u173c\u89fd\u07f5\ufe53\u74e3\uf2c5\u693d\ue700\u5dd9\ud46f\u5233\uccd1\u4698\u3d20\ubb82\u318d\ua859\u269d\u98ae\u1b3b\u9116\u0fd9\u826a\u7c33\ufac1\u7487\uef21\u65f3\ue3f3\u5a59\ud4f2\u4eb0\uc54c\u470f\u39dc\ub077\u2e05\ua0cb\u2367\u992d\u17f2\u8d82H\u86db\u789b\uf73d\u6d13\ueba3\u6275\udc1f\u56da\ucd19\u4b4b\uc1c8\ubf94\u365c\ua8f4\u2ac3\ua146\u1f18\u95ab\u0863\u8e1a\u00d0\uff6c\u7530\uf3be\u6991\ue024\u5efe\ud4fa\u5755\ucd49\u43ee\u3a6b\ub042\u368f\uad26\u236c\u9999\u1f82\u9668\u0caf\u82cf\u7941\ufffb\u71b5\ue87b\u667b\udcd5\u5b6e\ud143\u4fb1\uc5ec\ub832\u3aff\ub49c\u2f2e\ua5e1\u23b1\u9a39\u1011\u8eaf\u0175\u8333\u79c5\uf7e5\u6e2b\ue4fe\u6281\udd42\u57e2\ucdb2\u444b\uc60e\ub8d8\u377a\uad05\u2bd2\ua199\u1c34\u96ff\u0c8a\u8b54\u01ed\uffb6\u764e\ue803\u6e96\ue150\u5f00\ud5d3\u4c68\uce2b\u40c6\u3e80\ub559\u3399\uada6\u204f\u9e62\u14a9\u9302\u0976\u87ae\u7e61\uf022\u76d9\ue8ec\u672b\uddf3\u5bbe\ud23f\u4c07\uc6a9\ubd7f\u3b04\ub1a6\u2860\ua63d\u1cbe\u9ae4\u112c\u8ff9\u05f6\ufc29\u7a9b\uf0da\u6b64\ue576\u63d6\uda6d\u5038\ucad3\u408a\uc325\ub9f7\u3787\uaa4e\u24e3\ua2b5\u1945\u9715\u0ddf\u8464\u0627\ufcd4\u76bf\ued21\u6bfe\ue18c\u585f\ud6e4\u4ccd\ucb32\u450b\u3bb8\ub679\u281a\uaeb6\u24c8\u9b7e\u11a3\u97df\u0e14\u8480\u7aed\uf108\u7742\uedfb\u643d\uda10\u50c6\ud751\u4d00\uc395\ub9c1\u3013\ub6f6\u2cf2\ua31f\u1956\u9ffc\u1629\u8c1c\u0289\uf937\u7f65\uf59d\u6bd8\ue23a\u58bd\udee1\u5505\ucb43\u41b1\u3821\ube5d\u3486\uab7d\u214f\ua793\u1dc7\u947c\u0aa6\u80cf\u0739\ufd4a\u73e1\uea29\u6052\ue692\u5d70\ud373\u499e\ucfcc\u4665\u3cbc\ub29e\u291d\uafb0\u25ee\u9c17\u1215\u888d\u0f39\u8575\u7b85\uf1c5\u6872\ueea6\u649d\udb03\u51b9\ud7ae\u4e10\uc45c\ubae8\u316a\ub76a\u2d83\ua3c9\u1a38\u90e1\u16e7\u8d22\u0384\uf9a1\u705c\uf66e\u6cd7\ue30f\u597e\udfc7\u567a\ucc56\u4285\u38f1\ubf4a\u35f1\uabcf\u2234\u9865\u1eb3\u9546\u0b79\u8187\u7835\ufe6d\u74db\ueac4\u6104\ue7b9\u5de2\ud456\u4a1c\uc0b0\u4730\u3d5d\ub398\u2a32\ua06b\u26c4\u9c89\u137c\u89b9\u0fd5\u8605\u7c08\uf2b7\u6936\uef5e\u6590\udc7f\u5222\uc88f\u4ec5\uc56f\ubbbe\u31d5\ua80d\u2ef7\ua4aa\u1b21\u9151\u1790\u8e7a\u0421\ufa92\u70cf\uf77d\u6da2\ue3cc\u5a43\ud0fe\u56f9\ucd14\u4342\u39f4\ub03e\u3628\uacd7\u22d5\u997e\u1fa4\u95d2\u0c4e\u82fd\u78ef\uff1a\u7542\uebfc\u623b\ud84f\u5e83\ud4c4\u4b78\uc1eb\u4796\u3e03\ub4a5\u2ae1\ua110\u2741\u9df9\u1463\u8a1e\u009d\u872f\u7d62\uf394\u69de\ue008\u66b2\udca8\u5351\uc91c\u4ffd\uc623\ubc50\u3289\ua961\u2f51\ua596\u1bc6\u923b\u08e5\u8ea5\u0548\ufb49\u71f7\ue82c\u6e55\ue4dd\u5b0d\ud162\u579a\ucdc9\u443e\u3aaf\ub0d7\u3719\uadfa\u23fa\u9a2a\u1052\u96c6\u0d39\u8361\u799f\uffc4\u763d\ueca3\u62d1\ud902\u5fa0\ud5a6\u4c71\uc26b\ub88b\u3f2d\ub527\u2b99\ua1d5\u1878\u9ea6\u14c0\u8b4d\u01ba\u87e6\u7e12\uf44c\u6ab8\ue129\u675f\udd96\u53cb\uca7a\u40a3\uc6c2\ubd40\u33b2\ua9a2\u200e\ua643\u1cea\u9320\u095d\u8fc8\u0634\ufc6c\u72e5\ue8dd\u6f13\ue5a5\u5ba1\ud21f\u4854\ucefc\u4561\u3b1c\ub19a\u2830\uae6d\u249d\u9ad9\u113a\u97bc\u0df0\u8404\u7a06\uf0ff\u7721\ued5e\u6387\uda73\u5006", -1450911383, 1527455158);
        vpp = List.of(a.b("\u2caa\u550d\udfc9", 1895836894), a.b("\u7f41\u06f8\u8c24\u1255", -1964343516), a.c(-9902984, "\ue41a\u9da3\u177f"), a.c(342130811, "\u801e\uf9a7\u737b\ued0f"), a.c(-675841240, "\u7b48\u02fb\u882f"), a.d("\ua1b7\ud80e\u52dd", -1995638541, 153704744));
        vpt = new HashMap<String, Object[]>();
        for (String string : voa.BUILT_IN) {
            vpo.vqe(string, null, vpo.vqd(string));
        }
        vpu = new voq(null, Map.of(), List.of());
        vpx = Collections.synchronizedSet(new HashSet());
        vpy = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, Short.MAX_VALUE};
        vpz = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    }

    private static /* synthetic */ int djm(int n, int n2) {
        return n ^ n2 | 0xB319943;
    }
}

