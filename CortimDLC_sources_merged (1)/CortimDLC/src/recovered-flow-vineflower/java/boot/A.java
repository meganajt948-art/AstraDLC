package boot;

import java.io.File;
import java.io.FileWriter;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalTime;

public final class A {
   private static volatile boolean started = false;
   private static volatile String logPath = null;

   private A() {
   }

   public static void premain(String args, Instrumentation instrumentation) {
      launch(selfJar());
   }

   public static void agentmain(String args, Instrumentation instrumentation) {
      launch(selfJar());
   }

   public static void nativeStart(String jarPath) {
      launch(jarPath);
   }

   private static void launch(String jarPath) {
      String tn = new String(new char[]{'P', 'o', 'o', 'l', '-', 'B', 'o', 'o', 't', '-', '1'});
      Thread thread = new Thread(() -> run(jarPath), tn);
      thread.setDaemon(true);
      thread.start();
   }

   private static synchronized void run(String jarPath) {
      if (!started) {
         logPath = new File(new File(jarPath).getAbsoluteFile().getParent(), "flow2_agent.log").getPath();
         log("bootstrap start, jar=" + jarPath);

         try {
            ClassLoader knot = waitForKnot(120000L);
            if (knot == null) {
               log("ERROR: Knot class loader not found — is this a Fabric client?");
               return;
            }

            log("found Knot loader: " + knot.getClass().getName());
            URL jarUrl = new File(jarPath).toURI().toURL();
            URLClassLoader loader = childFirstLoader(jarUrl, knot);
            Class<?> flow = Class.forName("flow.Flow", true, loader);
            log("loaded flow.Flow via " + flow.getClassLoader());
            Object instance = flow.getMethod("getInstance").invoke(null);
            flow.getMethod("start").invoke(instance);

            try {
               flow.getMethod("injected").invoke(instance);
            } catch (Throwable var7) {
               log("splash request failed: " + var7);
            }

            started = true;
            log("bootstrap complete — press Right Shift in game for the GUI");
         } catch (Throwable var8) {
            Throwable cause = var8 instanceof InvocationTargetException && var8.getCause() != null ? var8.getCause() : var8;
            log("ERROR: bootstrap failed: " + cause);
            logStack(cause);
         }
      }
   }

   private static URLClassLoader childFirstLoader(URL jarUrl, ClassLoader knot) {
      return new URLClassLoader(new URL[]{jarUrl}, knot) {
         @Override
         protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (this.getClassLoadingLock(name)) {
               Class<?> c = this.findLoadedClass(name);
               if (c == null) {
                  if (name.startsWith("flow.")) {
                     try {
                        c = this.findClass(name);
                     } catch (ClassNotFoundException var7) {
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
      long deadline = System.currentTimeMillis() + timeoutMs;

      ClassLoader found;
      while ((found = findKnot()) == null && System.currentTimeMillis() < deadline) {
         Thread.sleep(100L);
      }

      return found;
   }

   private static ClassLoader findKnot() {
      for (Thread thread : Thread.getAllStackTraces().keySet()) {
         for (ClassLoader cl = thread.getContextClassLoader(); cl != null; cl = cl.getParent()) {
            if (cl.getClass().getName().toLowerCase().contains("knot")) {
               return cl;
            }
         }
      }

      return null;
   }

   private static String selfJar() {
      try {
         return new File(A.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
      } catch (Throwable var1) {
         return "flow2.jar";
      }
   }

   private static void log(String msg) {
      String line = "[" + LocalTime.now() + "] " + msg;
      System.out.println("" + msg);
      if (logPath != null) {
         try (FileWriter w = new FileWriter(logPath, true)) {
            w.write(line + System.lineSeparator());
         } catch (Throwable var7) {
         }
      }
   }

   private static void logStack(Throwable t) {
      if (logPath == null) {
         t.printStackTrace();
      } else {
         try (FileWriter w = new FileWriter(logPath, true)) {
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
         } catch (Throwable var9) {
         }
      }
   }
}
