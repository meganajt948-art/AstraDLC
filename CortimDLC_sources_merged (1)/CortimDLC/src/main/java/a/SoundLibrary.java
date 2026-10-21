/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Sounds;
import a.voq;
import a.vow;
import a.vpd;
import a.vpi;
import flow.config.ConfigManager;
import flow.dev.StringDecryptor;
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

public final class SoundLibrary {
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

    private SoundLibrary() {
    }

    public static Path dir() {
        return ConfigManager.gameDir().resolve("flow2").resolve("sounds");
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
            int n = SoundLibrary.vqf(path).compareToIgnoreCase(SoundLibrary.vqf(path2));
            return n != 0 ? n : vpp.indexOf(SoundLibrary.vqg(path)) - vpp.indexOf(SoundLibrary.vqg(path2));
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
            String string2 = SoundLibrary.vqf(path3);
            String string3 = SoundLibrary.vqd(string2);
            Boolean bl = null;
            if (string3.endsWith("_on")) {
                bl = Boolean.TRUE;
                string3 = string3.substring(0, string3.length() - 3);
                string2 = string2.substring(0, string2.length() - 3);
            } else if (string3.endsWith("_off")) {
                bl = Boolean.FALSE;
                string3 = string3.substring(0, string3.length() - 4);
                string2 = string2.substring(0, string2.length() - 4);
            }
            if (string3.isEmpty() || string3.equals("off") || string3.equals("readme")) continue;
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
            String string5 = objectArray != null ? SoundLibrary.vqd(string4) : string3;
            vow vow2 = object2.getOrDefault(string5, new vow(string4, null, null, null));
            object2.put(string5, vow2.with(bl, path3));
        }
        arrayList2.sort(String.CASE_INSENSITIVE_ORDER);
        vpu = new voq(string, Map.copyOf(object2), List.copyOf(arrayList2));
        ++vpv;
        if (!arrayList.isEmpty()) {
            System.out.println("sound files: " + object2.keySet());
        }
        return true;
    }

    static vpd find(String string, boolean bl) {
        Path path;
        vow vow2 = vpu.sounds().get(SoundLibrary.vqd(string));
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
            vpt.putIfAbsent(SoundLibrary.vqd(string2), new Object[]{string, bl});
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
                throw new IOException("too big");
            }
            return SoundLibrary.decode(Files.readAllBytes(path));
        }
        catch (Exception exception) {
            if (vpx.add(path.getFileName() + "|" + exception.getMessage())) {
                System.out.println("can't play " + path.getFileName() + ": " + exception.getMessage());
            }
            return null;
        }
    }

    static vpi decode(byte[] byArray) throws Exception {
        vpi vpi2;
        if (SoundLibrary.vqn(byArray, 0, "RIFF") && SoundLibrary.vqn(byArray, 8, "WAVE")) {
            vpi2 = SoundLibrary.vqh(byArray);
        } else if (SoundLibrary.vqn(byArray, 0, "FORM") && (SoundLibrary.vqn(byArray, 8, "AIFF") || SoundLibrary.vqn(byArray, 8, "AIFC"))) {
            vpi2 = SoundLibrary.vqi(byArray, SoundLibrary.vqn(byArray, 8, "AIFC"));
        } else if (SoundLibrary.vqn(byArray, 0, "caff")) {
            vpi2 = SoundLibrary.vqj(byArray);
        } else if (SoundLibrary.vqn(byArray, 0, "OggS")) {
            vpi2 = SoundLibrary.vqk(byArray);
        } else {
            throw new IOException("not WAV, AIFF, CAF or OGG inside (MP3 / M4A: convert it to WAV)");
        }
        if (vpi2.data().length == 0) {
            throw new IOException("no sound in it");
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
            int n8 = SoundLibrary.vqp(byArray, n7 + 4);
            int n9 = n7 + 8;
            if (SoundLibrary.vqn(byArray, n7, "fmt ") && n9 + 16 <= byArray.length) {
                n = SoundLibrary.vqo(byArray, n9);
                n2 = SoundLibrary.vqo(byArray, n9 + 2);
                n3 = SoundLibrary.vqp(byArray, n9 + 4);
                n4 = SoundLibrary.vqo(byArray, n9 + 14);
                if (n == 65534 && n8 >= 26 && n9 + 26 <= byArray.length) {
                    n = SoundLibrary.vqo(byArray, n9 + 24);
                }
            } else if (SoundLibrary.vqn(byArray, n7, "data")) {
                n5 = n9;
                n6 = n8 < 0 || n8 > byArray.length - n9 ? byArray.length - n9 : n8;
                break;
            }
            if (n8 < 0 || n8 > byArray.length) break;
            n7 = n9 + n8 + (n8 & 1);
        }
        if (n5 < 0 || n2 <= 0 || n3 <= 0) {
            throw new IOException("broken WAV");
        }
        return switch (n) {
            case 1 -> SoundLibrary.vql(byArray, n5, n6, n2, n4, true, false, n4 == 8, n3);
            case 3 -> SoundLibrary.vql(byArray, n5, n6, n2, n4, true, true, false, n3);
            default -> throw new IOException("WAV format " + n + " (only plain PCM or float): convert it");
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
            throw new IOException(n4 + "-bit samples");
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
        return SoundLibrary.vqo(byArray, n) | SoundLibrary.vqo(byArray, n + 2) << 16;
    }

    private static int vqq(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF;
    }

    private static int vqr(byte[] byArray, int n) {
        return SoundLibrary.vqq(byArray, n) << 16 | SoundLibrary.vqq(byArray, n + 2);
    }

    private static long vqs(byte[] byArray, int n) {
        return (long)SoundLibrary.vqr(byArray, n) << 32 | (long)SoundLibrary.vqr(byArray, n + 4) & 0xFFFFFFFFL;
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
        vqa = "Flow2 - звуки / sounds\n======================\n\nПоложи сюда файлы звуков - ClientSounds будет играть их вместо своих.\nФорматы: WAV, AIFF, CAF, OGG. MP3/M4A - переведи в WAV.\n\nИмя файла = звук (регистр и расширение не важны): drop, pop, ripple, dew, bloop, plink, soda, celestial, bubble, twinkle\nТолько для включения / выключения: <имя>_on / <имя>_off (например bubble_off.wav).\nБез своего _off выключение играет тот же звук на тон ниже.\nЛюбой другой файл (например my-sound.wav) появится в списке звуков под своим именем.\nПока меню открыто, файлы подхватываются сами (или кнопка \"Обновить\" в ClientSounds).\n\nPut sound files here and ClientSounds plays them instead of its own. WAV, AIFF, CAF, OGG.\nFile name = sound: drop, pop, ripple, dew, bloop, plink, soda, celestial, bubble, twinkle. <name>_on / <name>_off for one half only.\nAny other file becomes a sound of its own, under its name.\n";
        vpp = List.of("wav", "aiff", "aif", "aifc", "caf", "ogg");
        vpt = new HashMap<String, Object[]>();
        for (String string : Sounds.BUILT_IN) {
            SoundLibrary.vqe(string, null, SoundLibrary.vqd(string));
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

