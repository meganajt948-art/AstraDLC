package a;

import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class dte extends ClassLoader {
   final Map<String, byte[]> dtf;
   final Map<String, byte[]> dtg;

   public dte(ClassLoader var1, HashMap<String, byte[]> var2, HashMap<String, byte[]> var3) {
      super(var1);
      this.dtf = var2;
      this.dtg = var3;
   }

   @Override
   protected Class<?> loadClass(String var1, boolean var2) throws ClassNotFoundException {
      synchronized (this.getClassLoadingLock(var1)) {
         Class var4 = this.findLoadedClass(var1);
         if (var4 == null) {
            if (var1.startsWith(a.d("⹁基\udd2a䍃죍", -1475103080, 135174330))) {
               try {
                  var4 = this.findClass(var1);
               } catch (ClassNotFoundException var7) {
                  var4 = super.loadClass(var1, false);
               }
            } else {
               var4 = super.loadClass(var1, false);
            }
         }

         if (var2) {
            this.resolveClass(var4);
         }

         return var4;
      }
   }

   @Override
   protected Class<?> findClass(String var1) throws ClassNotFoundException {
      byte[] var2 = this.dtf != null ? this.dtf.get(var1) : null;
      if (var2 == null) {
         throw new ClassNotFoundException(var1);
      } else {
         return this.defineClass(var1, var2, 0, var2.length);
      }
   }

   @Override
   protected URL findResource(String var1) {
      if (var1 == null) {
         return null;
      }

      String var2 = var1.startsWith(a.d("풰", 1063486810, -435662396)) ? var1.substring(1) : var1;
      final byte[] var3 = this.dtg != null ? this.dtg.get(var2) : null;
      if (var3 == null) {
         return super.findResource(var1);
      }

      try {
         return new URL(a.d("뽣웘䰈퉡姳\udf1d敆\uecbf", -1337683116, 172239961), "", -1, a.c(-1697411817, "费") + var2, new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL var1) {
               return new URLConnection(var1) {
                  @Override
                  public void connect() {
                  }

                  @Override
                  public InputStream getInputStream() {
                     return new ByteArrayInputStream(var3);
                  }

                  @Override
                  public int getContentLength() {
                     return var3.length;
                  }
               };
            }
         });
      } catch (Exception var5) {
         return null;
      }
   }

   @Override
   public InputStream getResourceAsStream(String var1) {
      if (var1 == null) {
         return null;
      }

      String var2 = var1.startsWith(a.d("鹞", -1661489860, 1897280332)) ? var1.substring(1) : var1;
      byte[] var3 = this.dtg != null ? this.dtg.get(var2) : null;
      return var3 != null ? new ByteArrayInputStream(var3) : super.getResourceAsStream(var1);
   }

   @Override
   protected Enumeration<URL> findResources(String var1) throws IOException {
      URL var2 = this.findResource(var1);
      if (var2 == null) {
         Enumeration var3 = super.getResources(var1);
         return var3 != null ? var3 : Collections.emptyEnumeration();
      } else {
         return Collections.enumeration(Collections.singletonList(var2));
      }
   }

   public static void installStdoutFilter() {
      try {
         System.setOut(dtj(System.out));
         System.setErr(dtj(System.err));
      } catch (Throwable var1) {
      }
   }

   static PrintStream dtj(final PrintStream var0) {
      return new PrintStream(new OutputStream() {
         final StringBuilder dtb = new StringBuilder(128);

         @Override
         public void write(int var1) {
            if (var1 == 10) {
               String var2 = this.dtb.toString();
               this.dtb.setLength(0);
               if (!var2.startsWith(a.c(1801309061, "쯘뉴㢍\ua6ffⴰꯄ"))) {
                  var0.println(var2);
               }
            } else if (var1 != 13) {
               this.dtb.append((char)(var1 & 0xFF));
            }
         }

         @Override
         public void write(byte[] var1, int var2, int var3) {
            for (int var4 = 0; var4 < var3; var4++) {
               this.write(var1[var2 + var4]);
            }
         }
      }, true, StandardCharsets.UTF_8);
   }
}
