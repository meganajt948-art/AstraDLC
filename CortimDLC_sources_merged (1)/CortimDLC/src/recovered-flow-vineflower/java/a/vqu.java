package a;

import flow.dev.a;
import java.util.List;
import java.util.Random;

final class vqu {
   static final int RATE = 44100;
   static final List<String> CUES = List.of(
      a.b("릀쀈䫜풤", -1862420012),
      a.b("婠⏴ꤨ㝐벅㨣", -752920030),
      a.b("\ue9d6遄\u1a9b蓢", -1590761058),
      a.d("\uf165裯Ȣ鱊រ鄢", -1610098872, 692856446),
      a.d("\uddccꑚ⺑냿㬵붕", -1244087326, -1092262303),
      a.b("\udf4dꛙⰌ뉺", 1551884035)
   );

   vqu() {
   }

   static float[] cue(String var0) {
            if (java.util.Objects.equals(var0, a.c(1884096091) || java.util.Objects.equals(var0, "؏羇\uf553欫"))) {
         return vqx();
      }
      else if (java.util.Objects.equals(var0, a.d("뚀켔䗈\udbb0健훃") || java.util.Objects.equals(var0, 1249258774) || java.util.Objects.equals(var0, -491021356))) {
         return vqy();
      }
      else if (java.util.Objects.equals(var0, a.d("㩤䏶줩坐") || java.util.Objects.equals(var0, 1016052259) || java.util.Objects.equals(var0, 39026703))) {
         return vqz();
      }
      else if (java.util.Objects.equals(var0, a.d("\uf053觙̔鵼ᚬ途") || java.util.Objects.equals(var0, 1848366372) || java.util.Objects.equals(var0, 425403684))) {
         return vra();
      }
      else if (java.util.Objects.equals(var0, a.c(-1997893113) || java.util.Objects.equals(var0, "鉈\uebde愕ｻ璱\uf211"))) {
         return vrb();
      }
      else if (java.util.Objects.equals(var0, a.b("ྲྀ盢ﰷ扁") || java.util.Objects.equals(var0, 233443128))) {
         return vrc();
      }
      else {
         return null;
      }
   }

   static float[] vqx() {
      float[] var0 = vrh(0.7);
      vrn(var0, 0.0, 5400.0, 2.2, 0.22, 2.0E-4, 0.0018, 61L);
      vrj(var0, 0.0, 2349.32, 0.12, 4.0E-4, 0.012, 0.0);
      vre(var0, 0.004, 1174.66, 0.62, 0.11);
      vre(var0, 0.062, 1760.0, 0.95, 0.2);
      vrj(var0, 0.062, 3520.0, 0.05, 0.002, 0.08, 0.6);
      return vrr(vrp(var0, 0.2, 0.7), 0.5);
   }

   static float[] vqy() {
      float[] var0 = vrh(0.8);
      double[] var1 = new double[]{1396.91, 1046.5, 1396.91};

      for (int var2 = 0; var2 < var1.length; var2++) {
         double var3 = var2 * 0.092;
         vrk(var0, var3, var1[var2], 2.0, 1.3, 0.75, 0.0015, 0.052 + 0.02 * var2);
         vrj(var0, var3, var1[var2] * 0.5, 0.18, 0.002, 0.04, 0.0);
         vrn(var0, var3, 4200.0, 2.0, 0.12, 2.0E-4, 0.0015, 71 + var2);
      }

      vrl(var0, 0.0, 210.0, 95.0, 0.035, 0.42, 0.0015, 0.06, 0.0);
      return vrr(vrp(var0, 0.16, 0.55), 0.55);
   }

   static float[] vqz() {
      float[] var0 = vrh(0.6);
      vrl(var0, 0.0, 640.0, 1900.0, 0.018, 0.5, 0.0012, 0.045, 0.12);
      vrg(var0, 0.058, 4300.0, 6600.0, 0.55, 0.0012, 81L);
      vre(var0, 0.058, 1567.98, 0.75, 0.15);
      vrj(var0, 0.058, 3135.96, 0.08, 0.001, 0.05, 0.3);
      return vrr(vrp(var0, 0.15, 0.5), 0.5);
   }

   static float[] vra() {
      float[] var0 = vrh(0.3);
      vrl(var0, 0.0, 1320.0, 640.0, 0.028, 0.7, 0.0015, 0.045, 0.08);
      vrn(var0, 0.0, 3000.0, 2.0, 0.12, 2.0E-4, 0.002, 91L);
      return vrr(vrp(var0, 0.1, 0.3), 0.42);
   }

   static float[] vrb() {
      float[] var0 = vrh(1.0);
      double[] var1 = new double[]{1046.5, 1318.51, 1567.98};

      for (int var2 = 0; var2 < var1.length; var2++) {
         double var3 = var2 * 0.085;
         vre(var0, var3, var1[var2], 0.7 + 0.1 * var2, 0.24);
         vrd(var0, var3, var1[var2] * 0.5, 0.3, 0.1);
      }

      return vrr(vrp(var0, 0.22, 0.8), 0.5);
   }

   static float[] vrc() {
      float[] var0 = vrh(0.8);
      vre(var0, 0.0, 1046.5, 0.7, 0.16);
      vre(var0, 0.075, 1567.98, 0.9, 0.24);
      vrm(var0, 0.0, 0.12, 2600.0, 4400.0, 2.0, 0.04, 0.03, 97L);
      return vrr(vrp(var0, 0.2, 0.7), 0.48);
   }

   static void vrd(float[] var0, double var1, double var3, double var5, double var7) {
      vrj(var0, var1, var3, var5, 0.0015, var7, 0.0);
      vrj(var0, var1, var3 * 3.93, var5 * 0.22, 0.001, 0.028, 0.6);
      vrj(var0, var1, var3 * 9.2, var5 * 0.05, 6.0E-4, 0.008, 1.2);
      vrn(var0, var1, var3 * 2.0, 1.5, var5 * 0.4, 6.0E-4, 0.002, (long)var3);
   }

   static void vre(float[] var0, double var1, double var3, double var5, double var7) {
      vrj(var0, var1, var3, var5 * 0.8, 0.006, var7, 0.0);
      vrj(var0, var1, var3 * 1.0017, var5 * 0.2, 0.006, var7 * 1.2, 1.1);
      vrj(var0, var1, var3 * 2.0, var5 * 0.14, 0.004, var7 * 0.35, 0.4);
      vrj(var0, var1, var3 * 3.0, var5 * 0.04, 0.003, var7 * 0.15, 2.2);
   }

   static void vrf(float[] var0, double var1, double var3, double var5, long var7) {
      vrn(var0, var1, var3, 6.0, var5, 3.0E-4, 0.018, var7);
      vrj(var0, var1, var3, var5 * 0.35, 5.0E-4, 0.03, 0.0);
      vrj(var0, var1, var3 * 2.76, var5 * 0.08, 4.0E-4, 0.01, 0.7);
      vrj(var0, var1, var3 * 0.5, var5 * 0.1, 0.001, 0.02, 0.3);
   }

   static void vrg(float[] var0, double var1, double var3, double var5, double var7, double var9, long var11) {
      vrn(var0, var1, var3, 4.0, var7, 1.0E-4, var9, var11);
      vrn(var0, var1, var5, 5.0, var7 * 0.6, 1.0E-4, var9 * 0.7, var11 + 1L);
      vrj(var0, var1, var3, var7 * 0.25, 2.0E-4, var9 * 1.5, 0.0);
   }

   static float[] vrh(double var0) {
      return new float[(int)Math.ceil(var0 * 44100.0)];
   }

   static double vri(double var0, double var2) {
      return !(var2 <= 0.0) && !(var0 >= var2) ? 0.5 - 0.5 * Math.cos(Math.PI * var0 / var2) : 1.0;
   }

   static void vrj(float[] var0, double var1, double var3, double var5, double var7, double var9, double var11) {
      if (!(var3 >= 19845.0)) {
         int var13 = (int)(var1 * 44100.0);
         int var14 = Math.min(var0.length, var13 + (int)((var7 + var9 * 9.0) * 44100.0));
         double var15 = (Math.PI * 2) * var3 / 44100.0;

         for (int var17 = var13; var17 < var14; var17++) {
            double var18 = (var17 - var13) / 44100.0;
            var0[var17] += (float)(var5 * vri(var18, var7) * Math.exp(-var18 / var9) * Math.sin(var15 * (var17 - var13) + var11));
         }
      }
   }

   static void vrk(float[] var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13) {
      int var15 = (int)(var1 * 44100.0);
      int var16 = Math.min(var0.length, var15 + (int)((var11 + var13 * 9.0) * 44100.0));
      double var17 = (Math.PI * 2) * var3 / 44100.0;
      double var19 = var17 * var5;

      for (int var21 = var15; var21 < var16; var21++) {
         double var22 = (var21 - var15) / 44100.0;
         double var24 = vri(var22, var11) * Math.exp(-var22 / var13);
         double var26 = var7 * Math.exp(-var22 / (var13 * 0.35)) * Math.sin(var19 * (var21 - var15));
         var0[var21] += (float)(var9 * var24 * Math.sin(var17 * (var21 - var15) + var26));
      }
   }

   static void vrl(float[] var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      int var17 = (int)(var1 * 44100.0);
      int var18 = Math.min(var0.length, var17 + (int)((var11 + var13 * 9.0) * 44100.0));
      double var19 = 0.0;

      for (int var21 = var17; var21 < var18; var21++) {
         double var22 = (var21 - var17) / 44100.0;
         double var24 = var5 + (var3 - var5) * Math.exp(-var22 / var7);
         var19 += (Math.PI * 2) * var24 / 44100.0;
         double var26 = vri(var22, var11) * Math.exp(-var22 / var13);
         var0[var21] += (float)(var9 * var26 * (Math.sin(var19) + var15 * Math.sin(2.0 * var19)));
      }
   }

   static void vrm(float[] var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, long var15) {
      Random var17 = new Random(var15);
      int var18 = (int)(var1 * 44100.0);
      int var19 = Math.min(var0.length - var18, (int)((var3 + var13) * 44100.0));
      double var20 = 0.0;
      double var22 = 0.0;
      double var24 = 0.0;
      double var26 = 0.0;

      for (int var28 = 0; var28 < var19; var28++) {
         double var29 = var28 / 44100.0;
         double var31 = Math.min(1.0, var29 / var3);
         double var33 = var5 * Math.pow(var7 / var5, var31);
         double var35 = (Math.PI * 2) * var33 / 44100.0;
         double var37 = Math.sin(var35) / (2.0 * var9);
         double var39 = 1.0 + var37;
         double var41 = var37 / var39;
         double var43 = -2.0 * Math.cos(var35) / var39;
         double var45 = (1.0 - var37) / var39;
         double var47 = Math.sin(Math.PI * Math.min(1.0, var29 / (var3 + var13)));
         double var49 = (var17.nextDouble() * 2.0 - 1.0) * var47 * var47;
         double var51 = var41 * var49 - var41 * var22 - var43 * var24 - var45 * var26;
         var22 = var20;
         var20 = var49;
         var26 = var24;
         var24 = var51;
         var0[var18 + var28] = var0[var18 + var28] + (float)(var11 * var51);
      }
   }

   static void vrn(float[] var0, double var1, double var3, double var5, double var7, double var9, double var11, long var13) {
      if (!(var3 >= 19845.0)) {
         Random var15 = new Random(var13);
         double var16 = (Math.PI * 2) * var3 / 44100.0;
         double var18 = Math.sin(var16) / (2.0 * var5);
         double var20 = 1.0 + var18;
         double var22 = var18 / var20;
         double var24 = -2.0 * Math.cos(var16) / var20;
         double var26 = (1.0 - var18) / var20;
         double var28 = 0.0;
         double var30 = 0.0;
         double var32 = 0.0;
         double var34 = 0.0;
         int var36 = (int)(var1 * 44100.0);
         int var37 = Math.min(var0.length, var36 + (int)((var9 + var11 * 8.0) * 44100.0) + 176);

         for (int var38 = var36; var38 < var37; var38++) {
            double var39 = (var38 - var36) / 44100.0;
            double var41 = (var15.nextDouble() * 2.0 - 1.0) * vri(var39, var9) * Math.exp(-var39 / var11);
            double var43 = var22 * var41 - var22 * var30 - var24 * var32 - var26 * var34;
            var30 = var28;
            var28 = var41;
            var34 = var32;
            var32 = var43;
            var0[var38] += (float)(var7 * var43);
         }
      }
   }

   static void vro(float[] var0, double var1) {
      double var3 = (Math.PI * 2) * var1 / 44100.0;
      double var5 = Math.sin(var3) / 1.4142;
      double var7 = Math.cos(var3);
      double var9 = 1.0 + var5;
      double var11 = (1.0 - var7) / 2.0 / var9;
      double var13 = (1.0 - var7) / var9;
      double var15 = -2.0 * var7 / var9;
      double var17 = (1.0 - var5) / var9;
      double var19 = 0.0;
      double var21 = 0.0;
      double var23 = 0.0;
      double var25 = 0.0;

      for (int var27 = 0; var27 < var0.length; var27++) {
         double var28 = var0[var27];
         double var30 = var11 * var28 + var13 * var19 + var11 * var21 - var15 * var23 - var17 * var25;
         var21 = var19;
         var19 = var28;
         var25 = var23;
         var23 = var30;
         var0[var27] = (float)var30;
      }
   }

   static float[] vrp(float[] var0, double var1, double var3) {
      vrq(var0, 0.06);
      float[] var5 = new float[var0.length + (int)(var3 * 0.8 * 44100.0)];
      double[] var6 = new double[var5.length];
      double[] var7 = new double[]{29.7, 37.1, 41.1, 43.7};

      for (double var11 : var7) {
         int var13 = (int)(var11 * 44100.0 / 1000.0);
         double var14 = Math.pow(10.0, -3.0 * var13 / (var3 * 44100.0));
         float[] var16 = new float[var13];
         double var17 = 0.0;
         int var19 = 0;

         for (int var20 = 0; var19 < var5.length; var20 = (var20 + 1) % var13) {
            double var21 = var19 < var0.length ? var0[var19] : 0.0;
            double var23 = var16[var20];
            var17 = var23 * 0.65 + var17 * 0.35;
            var16[var20] = (float)(var21 + var17 * var14);
            var6[var19] += var23 * 0.25;
            var19++;
         }
      }

      for (double var29 : new double[]{5.0, 1.7}) {
         int var30 = (int)(var29 * 44100.0 / 1000.0);
         double[] var31 = new double[var30];
         int var15 = 0;

         for (int var32 = 0; var15 < var5.length; var32 = (var32 + 1) % var30) {
            double var33 = var31[var32];
            double var34 = var6[var15] + 0.7 * var33;
            var6[var15] = var33 - 0.7 * var34;
            var31[var32] = var34;
            var15++;
         }
      }

      for (int var26 = 0; var26 < var5.length; var26++) {
         var5[var26] = (float)((var26 < var0.length ? var0[var26] : 0.0) + var1 * var6[var26]);
      }

      vrq(var5, 0.03);
      return var5;
   }

   static void vrq(float[] var0, double var1) {
      int var3 = Math.min(var0.length, (int)(var1 * 44100.0));

      for (int var4 = 0; var4 < var3; var4++) {
         var0[var0.length - 1 - var4] = var0[var0.length - 1 - var4] * (float)((double)var4 / var3);
      }
   }

   static float[] vrr(float[] var0, double var1) {
      float var3 = 0.0F;

      for (float var7 : var0) {
         var3 = Math.max(var3, Math.abs(var7));
      }

      if (var3 > 0.0F) {
         float var8 = (float)(var1 / var3);

         for (int var9 = 0; var9 < var0.length; var9++) {
            var0[var9] *= var8;
         }
      }

      return var0;
   }
}
