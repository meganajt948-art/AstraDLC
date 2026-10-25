package a;

import java.lang.ref.SoftReference;
import java.util.Arrays;

public final class vup {
   static SoftReference<String> vuq;
   static SoftReference<String> vur;
   static SoftReference<String> vus;
   static SoftReference<String> vut;
   static SoftReference<String> vuu;
   static SoftReference<String> vuv;
   static SoftReference<String> vuw;
   static SoftReference<String> vux;
   static SoftReference<String> vuy;
   static SoftReference<String> vuz;
   static SoftReference<String> vva;
   static SoftReference<String> vvb;
   static SoftReference<String> vvc;
   static SoftReference<String> vvd;

   vup() {
   }

   public static String e() {
      String var0 = vvg(vuq);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'E', 'n', 'd'});
      vuq = new SoftReference<>(var0);
      return var0;
   }

   public static String w() {
      String var0 = vvg(vur);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'W', 'a', 'r', 'd', 'e', 'n'});
      vur = new SoftReference<>(var0);
      return var0;
   }

   public static String m() {
      String var0 = vvg(vus);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'M', 'i', 'n', 'e'});
      vus = new SoftReference<>(var0);
      return var0;
   }

   public static String s() {
      String var0 = vvg(vut);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'S', 'w', 'a', 'p'});
      vut = new SoftReference<>(var0);
      return var0;
   }

   public static String t() {
      String var0 = vvg(vuu);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'T', 'o', 't', 'e', 'm'});
      vuu = new SoftReference<>(var0);
      return var0;
   }

   public static String l() {
      String var0 = vvg(vuv);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'T', 'o', 'o', 'l'});
      vuv = new SoftReference<>(var0);
      return var0;
   }

   public static String c() {
      String var0 = vvg(vuw);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'M', 'a', 'c', 'e'});
      vuw = new SoftReference<>(var0);
      return var0;
   }

   public static String o() {
      String var0 = vvg(vux);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'C', 'o', 'l', 'l', 'e', 'c', 't', 'o', 'r'});
      vux = new SoftReference<>(var0);
      return var0;
   }

   public static String a() {
      String var0 = vvg(vuy);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'A', 'c', 'c', 'e', 'p', 't'});
      vuy = new SoftReference<>(var0);
      return var0;
   }

   public static String k() {
      String var0 = vvg(vuz);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'K', 'i', 'l', 'l', 'A', 'u', 'r', 'a'});
      vuz = new SoftReference<>(var0);
      return var0;
   }

   public static String i() {
      String var0 = vvg(vva);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't'});
      vva = new SoftReference<>(var0);
      return var0;
   }

   public static String g() {
      String var0 = vvg(vvb);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'T', 'r', 'i', 'g', 'g', 'e', 'r', 'B', 'o', 't'});
      vvb = new SoftReference<>(var0);
      return var0;
   }

   public static String n() {
      String var0 = vvg(vvc);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'N', 'e', 'u', 'r', 'o', 'A', 'i', 'm'});
      vvc = new SoftReference<>(var0);
      return var0;
   }

   public static String p() {
      String var0 = vvg(vvd);
      if (var0 != null) {
         return var0;
      }

      var0 = vvh(new char[]{'A', 'u', 't', 'o', 'S', 'p', 'r', 'i', 'n', 't'});
      vvd = new SoftReference<>(var0);
      return var0;
   }

   static String vvg(SoftReference<String> var0) {
      return var0 == null ? null : (String)var0.get();
   }

   static String vvh(char[] var0) {
      StringBuilder var1 = new StringBuilder(var0.length * 2 - 1);

      for (int var2 = 0; var2 < var0.length; var2++) {
         if (var2 > 0) {
            var1.append('\u200c');
         }

         var1.append(var0[var2]);
      }

      Arrays.fill(var0, '\u0000');
      return var1.toString();
   }
}
