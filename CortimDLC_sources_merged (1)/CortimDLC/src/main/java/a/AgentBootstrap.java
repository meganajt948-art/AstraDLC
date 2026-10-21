/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dse;
import flow.dev.StringDecryptor;
import java.io.File;
import java.io.FileWriter;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalTime;

public final class AgentBootstrap {
    private static volatile boolean dsi = false;
    private static volatile String dsj = null;
    private static /* synthetic */ int dsk;
    private static /* synthetic */ int dsl;

    private AgentBootstrap() {
    }

    public static void premain(String string, Instrumentation instrumentation) {
        AgentBootstrap.dsm(AgentBootstrap.dsr());
    }

    public static void agentmain(String string, Instrumentation instrumentation) {
        AgentBootstrap.dsm(AgentBootstrap.dsr());
    }

    public static void nativeStart(String string) {
        AgentBootstrap.dsm(string);
    }

    private static void dsm(String string) {
        Thread thread = new Thread(() -> AgentBootstrap.dsn(string), "Flow2-Agent-Bootstrap");
        thread.setDaemon(true);
        thread.start();
    }

    private static synchronized void dsn(String string) {
        if (dsi) {
            return;
        }
        dsj = new File(new File(string).getAbsoluteFile().getParent(), "flow2_agent.log").getPath();
        AgentBootstrap.dss("bootstrap start, jar=" + string);
        try {
            ClassLoader classLoader = AgentBootstrap.dsp(120000L);
            if (classLoader == null) {
                AgentBootstrap.dss("ERROR: Knot class loader not found — is this a Fabric client?");
                return;
            }
            AgentBootstrap.dss("found Knot loader: " + classLoader.getClass().getName());
            URL uRL = new File(string).toURI().toURL();
            URLClassLoader uRLClassLoader = AgentBootstrap.dso(uRL, classLoader);
            Class<?> clazz = Class.forName("flow.Flow", true, uRLClassLoader);
            AgentBootstrap.dss("loaded flow.Flow via " + clazz.getClassLoader());
            Object object = clazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("start", new Class[0]).invoke(object, new Object[0]);
            try {
                clazz.getMethod("injected", new Class[0]).invoke(object, new Object[0]);
            }
            catch (Throwable throwable) {
                AgentBootstrap.dss("splash request failed: " + throwable);
            }
            dsi = true;
            AgentBootstrap.dss("bootstrap complete — press Right Shift in game for the GUI");
        }
        catch (Throwable throwable) {
            Throwable throwable2 = throwable instanceof InvocationTargetException && throwable.getCause() != null ? throwable.getCause() : throwable;
            AgentBootstrap.dss("ERROR: bootstrap failed: " + throwable2);
            AgentBootstrap.dst(throwable2);
        }
    }

    private static URLClassLoader dso(URL uRL, ClassLoader classLoader) {
        return new dse(new URL[]{uRL}, classLoader);
    }

    private static ClassLoader dsp(long l) throws InterruptedException {
        ClassLoader classLoader;
        long l2 = System.currentTimeMillis() + l;
        while ((classLoader = AgentBootstrap.dsq()) == null && System.currentTimeMillis() < l2) {
            Thread.sleep(100L);
        }
        return classLoader;
    }

    private static ClassLoader dsq() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            for (ClassLoader classLoader = thread.getContextClassLoader(); classLoader != null; classLoader = classLoader.getParent()) {
                if (!classLoader.getClass().getName().toLowerCase().contains("knot")) continue;
                return classLoader;
            }
        }
        return null;
    }

    private static String dsr() {
        try {
            return new File(AgentBootstrap.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        }
        catch (Throwable throwable) {
            return "flow2.jar";
        }
    }

    private static void dss(String string) {
        String string2 = "[" + LocalTime.now() + "] " + string;
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
                fileWriter.write("    at " + stackTraceElement + System.lineSeparator());
            }
            for (object = throwable.getCause(); object != null; object = ((Throwable)object).getCause()) {
                fileWriter.write("Caused by: " + object + System.lineSeparator());
                for (StackTraceElement stackTraceElement : ((Throwable)object).getStackTrace()) {
                    fileWriter.write("    at " + stackTraceElement + System.lineSeparator());
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

