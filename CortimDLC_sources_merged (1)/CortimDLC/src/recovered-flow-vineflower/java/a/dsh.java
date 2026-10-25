package a;

import flow.dev.a;
import java.io.File;
import java.io.FileWriter;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalTime;

public final class dsh {
   static volatile boolean dsi = false;
   static volatile String dsj = null;

   dsh() {
   }

   public static void premain(String var0, Instrumentation var1) {
      dsm(dsr());
   }

   public static void agentmain(String var0, Instrumentation var1) {
      dsm(dsr());
   }

   public static void nativeStart(String var0) {
      dsm(var0);
   }

   static void dsm(String var0) {
      Thread var1 = new Thread(() -> dsn(var0), a.c(524070978, "뀑즊䍚\udd33嚡퀏樰\ue3e7綺\uf700烉諡љ鷅ព酼⬴ꓢ㹗렕ㇳ"));
      var1.setDaemon(true);
      var1.start();
   }

   static synchronized void dsn(String var0) {
      if (!dsi) {
         dsj = new File(new File(var0).getAbsoluteFile().getParent(), a.d("莸糖烓\ueeba攨\ue3f4妙큮丳쒉䍀륫㟾까␗", 391933290, -887492933)).getPath();
         dss(a.d("괞풢幱쀛䯋쵽眨ﻊ悄\uea65淥鞓ᥑ胳દ谏㙌맗⍯ꔭⲕ", 804981490, 613001115) + var0);

         try {
            ClassLoader var1 = dsp(120000L);
            if (var1 == null) {
               dss(a.b("㎥䨃샐庼핶厯\ue9e6恼︆璶\uf37eज़蟏ṱ鐯ዌꢃ✁뷾㮬뉕적䚳\udd75存퇇桵\ue63f粜懲焱迺֮鱕ᩂ냇⼤ꔜ⏕먷〼仑쒃䌨\ud9ac垜\uee0e擙\ue2b1祣\uf700්葷ɥ飕ᚋ괱⯬ꆔ㡟뚣", 898905053));
               return;
            }

            dss(a.d("艫ﯓ焚\uef70播\ue258塠톴俪앀䋇룺㘮꾑◇ꌷ\u196f零\u0c5f", 2019273705, -1252840969) + var1.getClass().getName());
            URL var9 = new File(var0).toURI().toURL();
            URLClassLoader var3 = dso(var9, var1);
            Class var4 = Class.forName(a.c(110402551, "鮘\ue223棳\uf69a純\ufbcd䆴졆嘁"), true, var3);
            dss(a.b("㽘䛪찷剃\ud995弥\ue532沅\uf2d0硢ﾩց謾እ飵Ḝꐄ⮃넯㝶뻀", -20431071) + var4.getClassLoader());
            Object var5 = var4.getMethod(a.d("됼춏䝍\ud901勱푝渉\ue7ed禽\uf301瓔", -1156288550, 281140106)).invoke(null);
            var4.getMethod(a.c(1800717013, "슣묕㇓꾱①")).invoke(var5);

            try {
               var4.getMethod(a.d("쟹빏㒘ꫦℷꞑᷓ鐣", 516419444, 2062887148)).invoke(var5);
            } catch (Throwable var7) {
               dss(a.d("ꅷ\ud8c5刊챶䞳섙笂\uf2a1泩\ue64c憛鯺ᔻ貍ڊ耽㩵떬⼚ꥂ₴媻퐒", 1271646240, -597268173) + var7);
            }

            dsi = true;
            dss(a.b("솩렕㋆견❼ꇊᮟ鉽ళ蛒ł\ufb3f痪\uec46昉\ue0f1媯핯侙\ue9fc䀿㨾뒏⽉ꤠ⏱騑ᐲ軾ࢡ茝緐\uf7cb湉\ue821抑\udd49圪톭䡕숍벲㚦넑⯊ꖳᰥ雒႔識չ￼癗\uf00b檽\ue48b弦\ud9eb", 2043920881));
         } catch (Throwable var8) {
            Throwable var2 = var8 instanceof InvocationTargetException && var8.getCause() != null ? var8.getCause() : var8;
            dss(a.d("\ue62d龋ᕘ謴þ蘧㱮뗝⮏ꄾ⛶\udc80剐쯧䆧읇絘\uf2cf桻\uee22某ᶈ錺ࢵ軐", 38728212, -420408219) + var2);
            dst(var2);
         }
      }
   }

   static URLClassLoader dso(URL var0, ClassLoader var1) {
      return new URLClassLoader(new URL[]{var0}, var1) {
         @Override
         protected Class<?> loadClass(String var1, boolean var2) throws ClassNotFoundException {
            synchronized (this.getClassLoadingLock(var1)) {
               Class var4 = this.findLoadedClass(var1);
               if (var4 == null) {
                  if (var1.startsWith(a.c(-1664531012, "䗟㱤뚴⣝ꍓ"))) {
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
      };
   }

   static ClassLoader dsp(long var0) throws InterruptedException {
      long var2 = System.currentTimeMillis() + var0;

      ClassLoader var4;
      while ((var4 = dsq()) == null && System.currentTimeMillis() < var2) {
         Thread.sleep(100L);
      }

      return var4;
   }

   static ClassLoader dsq() {
      for (Thread var1 : Thread.getAllStackTraces().keySet()) {
         for (ClassLoader var2 = var1.getContextClassLoader(); var2 != null; var2 = var2.getParent()) {
            if (var2.getClass().getName().toLowerCase().contains(a.d("໙睭ﶿ揕", -1341219301, -63336275))) {
               return var2;
            }
         }
      }

      return null;
   }

   static String dsr() {
      try {
         return new File(dsh.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
      } catch (Throwable var1) {
         return a.c(-1770437632, "䑯㷔뜄⥭ꋿ\u2452鹅ឿ觳");
      }
   }

   static void dss(String var0) {
      String var1 = a.b("ꄮ", 1587061108) + LocalTime.now() + a.d("ബ瓠", 2117880671, -1439676884) + var0;
      System.out.println("" + var0);
      if (dsj != null) {
         try (FileWriter var2 = new FileWriter(dsj, true)) {
            var2.write(var1 + System.lineSeparator());
         } catch (Throwable var7) {
         }
      }
   }

   static void dst(Throwable var0) {
      if (dsj == null) {
         var0.printStackTrace();
      } else {
         try (FileWriter var1 = new FileWriter(dsj, true)) {
            var1.write(var0.toString() + System.lineSeparator());

            for (StackTraceElement var5 : var0.getStackTrace()) {
               var1.write(a.c(606053892, "꘣\udf92啁쬰䂦옂簅") + var5 + System.lineSeparator());
            }

            for (Throwable var10 = var0.getCause(); var10 != null; var10 = var10.getCause()) {
               var1.write(a.d("\uf175裦ȡ鱖ភ鄧⬰ꊃ㳇똵ㇼ", 1410461897, -1382088204) + var10 + System.lineSeparator());

               for (StackTraceElement var6 : var10.getStackTrace()) {
                  var1.write(a.b("୪狛\uf808晹\uedef歋테", -56882355) + var6 + System.lineSeparator());
               }
            }
         } catch (Throwable var9) {
         }
      }
   }
}
