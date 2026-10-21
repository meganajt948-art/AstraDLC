/*
 * Decompiled with CFR 0.152.
 */
package boot;

import java.io.File;
import java.io.FileWriter;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalTime;

public final class AgentBoot {
    private static volatile boolean started = false;
    private static volatile String logPath = null;

    private AgentBoot() {
    }

    public static void premain(String args, Instrumentation instrumentation) {
        AgentBoot.launch(AgentBoot.selfJar());
    }

    public static void agentmain(String args, Instrumentation instrumentation) {
        AgentBoot.launch(AgentBoot.selfJar());
    }

    public static void nativeStart(String jarPath) {
        AgentBoot.launch(jarPath);
    }

    private static void launch(String jarPath) {
        String tn = new String(new char[]{'P', 'o', 'o', 'l', '-', 'B', 'o', 'o', 't', '-', '1'});
        Thread thread = new Thread(() -> AgentBoot.run(jarPath), tn);
        thread.setDaemon(true);
        thread.start();
    }

    private static synchronized void run(String jarPath) {
        if (started) {
            return;
        }
        logPath = new File(new File(jarPath).getAbsoluteFile().getParent(), "flow2_agent.log").getPath();
        AgentBoot.log("bootstrap start, jar=" + jarPath);
        try {
            ClassLoader knot = AgentBoot.waitForKnot(120000L);
            if (knot == null) {
                AgentBoot.log("ERROR: Knot class loader not found \u2014 is this a Fabric client?");
                return;
            }
            AgentBoot.log("found Knot loader: " + knot.getClass().getName());
            URL jarUrl = new File(jarPath).toURI().toURL();
            URLClassLoader loader = AgentBoot.childFirstLoader(jarUrl, knot);
            Class<?> flow = Class.forName("flow.Flow", true, loader);
            AgentBoot.log("loaded flow.Flow via " + flow.getClassLoader());
            Object instance = flow.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            flow.getMethod("start", new Class[0]).invoke(instance, new Object[0]);
            try {
                flow.getMethod("injected", new Class[0]).invoke(instance, new Object[0]);
            }
            catch (Throwable t) {
                AgentBoot.log("splash request failed: " + t);
            }
            started = true;
            AgentBoot.log("bootstrap complete \u2014 press Right Shift in game for the GUI");
        }
        catch (Throwable t) {
            Throwable cause = t instanceof InvocationTargetException && t.getCause() != null ? t.getCause() : t;
            AgentBoot.log("ERROR: bootstrap failed: " + cause);
            AgentBoot.logStack(cause);
        }
    }

    private static URLClassLoader childFirstLoader(URL jarUrl, ClassLoader knot) {
        return new URLClassLoader(new URL[]{jarUrl}, knot){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                Object object = this.getClassLoadingLock(name);
                synchronized (object) {
                    Class<?> c = this.findLoadedClass(name);
                    if (c == null) {
                        if (name.startsWith("flow.")) {
                            try {
                                c = this.findClass(name);
                            }
                            catch (ClassNotFoundException ignored) {
                                c = super.loadClass(name, false);
                            }
                        } else {
                            c = super.loadClass(name, false);
                        }
                    }
                    if (resolve) {
                        this.resolveClass(c);
                    }
                    return c;
                }
            }
        };
    }

    private static ClassLoader waitForKnot(long timeoutMs) throws InterruptedException {
        ClassLoader found;
        long deadline = System.currentTimeMillis() + timeoutMs;
        while ((found = AgentBoot.findKnot()) == null && System.currentTimeMillis() < deadline) {
            Thread.sleep(100L);
        }
        return found;
    }

    private static ClassLoader findKnot() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            for (ClassLoader cl = thread.getContextClassLoader(); cl != null; cl = cl.getParent()) {
                if (!cl.getClass().getName().toLowerCase().contains("knot")) continue;
                return cl;
            }
        }
        return null;
    }

    private static String selfJar() {
        try {
            return new File(AgentBoot.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        }
        catch (Throwable t) {
            return "flow2.jar";
        }
    }

    private static void log(String msg) {
        String line = "[" + LocalTime.now() + "] " + msg;
        System.out.println("" + msg);
        if (logPath == null) {
            return;
        }
        try (FileWriter w = new FileWriter(logPath, true);){
            w.write(line + System.lineSeparator());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void logStack(Throwable t) {
        if (logPath == null) {
            t.printStackTrace();
            return;
        }
        try (FileWriter w = new FileWriter(logPath, true);){
            w.write(t.toString() + System.lineSeparator());
            for (StackTraceElement e : t.getStackTrace()) {
                w.write("    at " + e + System.lineSeparator());
            }
            for (Throwable c = t.getCause(); c != null; c = c.getCause()) {
                w.write("Caused by: " + c + System.lineSeparator());
                for (StackTraceElement e : c.getStackTrace()) {
                    w.write("    at " + e + System.lineSeparator());
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

