/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dse;
import flow.dev.a;
import java.io.File;
import java.io.FileWriter;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalTime;

public final class dsh {
    private static volatile boolean dsi = false;
    private static volatile String dsj = null;
    private static /* synthetic */ int dsk;
    private static /* synthetic */ int dsl;

    private dsh() {
    }

    public static void premain(String string, Instrumentation instrumentation) {
        dsh.dsm(dsh.dsr());
    }

    public static void agentmain(String string, Instrumentation instrumentation) {
        dsh.dsm(dsh.dsr());
    }

    public static void nativeStart(String string) {
        dsh.dsm(string);
    }

    private static void dsm(String string) {
        Thread thread = new Thread(() -> dsh.dsn(string), a.c(524070978, "\ub011\uc98a\u435a\udd33\u56a1\ud00f\u6a30\ue3e7\u7dba\uf700\u70c9\u8ae1\u0459\u9dc5\u1796\u917c\u2b34\ua4e2\u3e57\ub815\u31f3"));
        thread.setDaemon(true);
        thread.start();
    }

    private static synchronized void dsn(String string) {
        if (dsi) {
            return;
        }
        dsj = new File(new File(string).getAbsoluteFile().getParent(), a.d("\u83b8\ufa03\u70d3\ueeba\u6528\ue3f4\u5999\ud06e\u4e33\uc489\u4340\ub96b\u37fe\uae4c\u2417", 391933290, -887492933)).getPath();
        dsh.dss(a.d("\uad1e\ud4a2\u5e71\uc01b\u4bcb\ucd7d\u7728\ufeca\u6084\uea65\u6de5\u9793\u1951\u80f3\u0aa6\u8c0f\u364c\ub9d7\u236f\ua52d\u2c95", 804981490, 613001115) + string);
        try {
            ClassLoader classLoader = dsh.dsp(120000L);
            if (classLoader == null) {
                dsh.dss(a.b("\u33a5\u4a03\uc0d0\u5ebc\ud576\u53af\ue9e6\u607c\ufe06\u74b6\uf37e\u095b\u87cf\u1e71\u942f\u12cc\ua883\u2701\ubdfe\u3bac\ub255\uc801\u46b3\udd75\u5b58\ud1c7\u6875\ue63f\u7c9c\ufa8b\u7131\u8ffa\u05ae\u9c55\u1a42\ub0c7\u2f24\ua51c\u23d5\uba37\u303c\u4ed1\uc483\u4328\ud9ac\u579c\uee0e\u64d9\ue2b1\u7963\uf700\u0dca\u8477\u0265\u98d5\u168b\uad31\u2bec\ua194\u385f\ub6a3", 898905053));
                return;
            }
            dsh.dss(a.d("\u826b\ufbd3\u711a\uef70\u64ad\ue258\u5860\ud1b4\u4fea\uc540\u42c7\ub8fa\u362e\uaf91\u25c7\ua337\u196f\u96f6\u0c5f", 2019273705, -1252840969) + classLoader.getClass().getName());
            URL uRL = new File(string).toURI().toURL();
            URLClassLoader uRLClassLoader = dsh.dso(uRL, classLoader);
            Class<?> clazz = Class.forName(a.c(110402551, "\u9b98\ue223\u68f3\uf69a\u7d14\ufbcd\u41b4\uc846\u5601"), true, uRLClassLoader);
            dsh.dss(a.b("\u3f58\u46ea\ucc37\u5243\ud995\u5f25\ue532\u6c85\uf2d0\u7862\uffa9\u0581\u8b3e\u12a5\u98f5\u1e1c\ua404\u2b83\ub12f\u3776\ubec0", -20431071) + clazz.getClassLoader());
            Object object = clazz.getMethod(a.d("\ub43c\ucd8f\u474d\ud901\u52f1\ud45d\u6e09\ue7ed\u79bd\uf301\u74d4", -1156288550, 281140106), new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod(a.c(1800717013, "\uc2a3\ubb15\u31d3\uafb1\u2460"), new Class[0]).invoke(object, new Object[0]);
            try {
                clazz.getMethod(a.d("\uc7f9\ube4f\u3498\uaae6\u2137\ua791\u1dd3\u9423", 516419444, 2062887148), new Class[0]).invoke(object, new Object[0]);
            }
            catch (Throwable throwable) {
                dsh.dss(a.d("\ua177\ud8c5\u520a\ucc76\u47b3\uc119\u7b02\uf2a1\u6ce9\ue64c\u619b\u9bfa\u153b\u8c8d\u068a\u803d\u3a75\ub5ac\u2f1a\ua942\u20b4\u5abb\ud412", 1271646240, -597268173) + throwable);
            }
            dsi = true;
            dsh.dss(a.b("\uc1a9\ub815\u32c6\uacac\u277c\ua1ca\u1b9f\u927d\u0c33\u86d2\u0142\ufb3f\u75ea\uec46\u6609\ue0f1\u5aaf\ud56f\u4f99\ue9fc\u403f\u3a3e\ub48f\u2f49\ua920\u23f1\u9a11\u1432\u8efe\u08a1\u831d\u7dd0\uf7cb\u6e49\ue821\u6291\udd49\u572a\ud1ad\u4855\uc20d\ubcb2\u36a6\ub111\u2bca\ua5b3\u1c25\u96d2\u1094\u8b58\u0579\ufffc\u7657\uf00b\u6abd\ue48b\u5f26\ud9eb", 2043920881));
        }
        catch (Throwable throwable) {
            Throwable throwable2 = throwable instanceof InvocationTargetException && throwable.getCause() != null ? throwable.getCause() : throwable;
            dsh.dss(a.d("\ue62d\u9f8b\u1558\u8b34\u00fe\u8627\u3c6e\ub5dd\u2b8f\ua13e\u26f6\udc80\u5250\ucbe7\u41a7\uc747\u7d58\uf2cf\u687b\uee22\u67d0\u1d88\u933a\u08b5\u8ed0", 38728212, -420408219) + throwable2);
            dsh.dst(throwable2);
        }
    }

    private static URLClassLoader dso(URL uRL, ClassLoader classLoader) {
        return new dse(new URL[]{uRL}, classLoader);
    }

    private static ClassLoader dsp(long l) throws InterruptedException {
        ClassLoader classLoader;
        long l2 = System.currentTimeMillis() + l;
        while ((classLoader = dsh.dsq()) == null && System.currentTimeMillis() < l2) {
            Thread.sleep(100L);
        }
        return classLoader;
    }

    private static ClassLoader dsq() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            for (ClassLoader classLoader = thread.getContextClassLoader(); classLoader != null; classLoader = classLoader.getParent()) {
                if (!classLoader.getClass().getName().toLowerCase().contains(a.d("\u0ed9\u776d\ufdbf\u63d5", -1341219301, -63336275))) continue;
                return classLoader;
            }
        }
        return null;
    }

    private static String dsr() {
        try {
            return new File(dsh.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        }
        catch (Throwable throwable) {
            return a.c(-1770437632, "\u446f\u3dd4\ub704\u296d\ua2ff\u2452\u9e45\u17bf\u89f3");
        }
    }

    private static void dss(String string) {
        String string2 = a.b("\ua12e", 1587061108) + LocalTime.now() + a.d("\u0d2c\u74e0", 2117880671, -1439676884) + string;
        System.out.println("" + string);
        if (dsj == null) {
            return;
        }
        try (FileWriter fileWriter = new FileWriter(dsj, true);){
            fileWriter.write(string2 + System.lineSeparator());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void dst(Throwable throwable) {
        if (dsj == null) {
            throwable.printStackTrace();
            return;
        }
        try (FileWriter fileWriter = new FileWriter(dsj, true);){
            fileWriter.write(throwable.toString() + System.lineSeparator());
            Object object = throwable.getStackTrace();
            int n = ((StackTraceElement[])object).length;
            for (int i = 0; i < n; ++i) {
                StackTraceElement stackTraceElement = object[i];
                fileWriter.write(a.c(606053892, "\ua623\udf92\u5541\ucb30\u40a6\uc602\u7c05") + stackTraceElement + System.lineSeparator());
            }
            for (object = throwable.getCause(); object != null; object = ((Throwable)object).getCause()) {
                fileWriter.write(a.d("\uf175\u88e6\u0221\u9c56\u1797\u9127\u2b30\ua283\u3cc7\ub635\u31fc", 1410461897, -1382088204) + object + System.lineSeparator());
                for (StackTraceElement stackTraceElement : ((Throwable)object).getStackTrace()) {
                    fileWriter.write(a.b("\u0b6a\u72db\uf808\u6679\uedef\u6b4b\ud14c", -56882355) + stackTraceElement + System.lineSeparator());
                }
            }
        }
        catch (Throwable throwable2) {
            // empty catch block
        }
    }

    private static /* synthetic */ int o(int n, int n2) {
        return n * n2 + 1892825539;
    }
}

