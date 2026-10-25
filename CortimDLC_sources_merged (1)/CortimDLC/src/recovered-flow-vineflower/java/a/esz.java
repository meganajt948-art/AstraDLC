package a;

import flow.dev.a;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class esz {
   private static final int eta = 20;
   private static final int etb = 28;
   private static final int etc = 560;
   private static volatile est[] etd;

   private esz() {
   }

   public static eso solve(BufferedImage var0) {
      short var1 = 512;
      int var2 = Math.max(1, Math.round((float)var0.getHeight() * var1 / var0.getWidth()));
      int[] var3 = etg(var0, var1, var2);
      var3 = eth(var3, var1, var2);
      boolean[] var4 = new boolean[var1 * var2];

      for (int var5 = 0; var5 < var3.length; var5++) {
         var4[var5] = var3[var5] < 175;
      }

      var4 = eti(var4, var1, var2, 4);
      int[] var20 = new int[var1 * var2];
      List var6 = etj(var4, var1, var2, var20);
      var6.removeIf(var0x -> var0x[4] < 2000 || var0x[3] < 80 || var0x[3] > 220 || var0x[2] < 20 || var0x[2] > 150);
      if (var6.size() >= 3 && var6.size() <= 8) {
         int var7 = Integer.MAX_VALUE;
         int var8 = Integer.MIN_VALUE;
         int var9 = Integer.MAX_VALUE;
         int var10 = Integer.MIN_VALUE;

         for (int[] var12 : var6) {
            int var13 = var12[0] + var12[2] / 2;
            int var14 = var12[1] + var12[3] / 2;
            if (var13 < var7) {
               var7 = var13;
            }

            if (var13 > var8) {
               var8 = var13;
            }

            if (var14 < var9) {
               var9 = var14;
            }

            if (var14 > var10) {
               var10 = var14;
            }
         }

         if (var10 - var9 > var8 - var7) {
            var6.sort(Comparator.comparingInt(var0x -> var0x[1] + var0x[3] / 2));
         } else {
            var6.sort(Comparator.comparingInt(var0x -> var0x[0] + var0x[2] / 2));
         }

         est[] var21 = etq();
         StringBuilder var22 = new StringBuilder();

         for (int[] var25 : var6) {
            boolean[] var15 = etm(var20, var1, var25);
            float[] var16 = etn(var15, var25[2], var25[3]);
            int var17 = etp(var16, var21);
            if (var17 < 0) {
               return new eso("", a.c(-1434848212, "\uf450跺ܤ饓ና鐤\u2e62ꞛ㧃"));
            }

            var22.append(var17);
         }

         String var24 = var22.toString();
         return var24.matches(a.d("뷩쐳份킘嬫\uddbc枧\uee49瀂\ufaf6", 79705504, -82278376))
            ? new eso(var24, a.d("덽쫈", -1650428880, 1837614880))
            : new eso("", a.c(981521190, "퍚꫰\u202e빙㖙댮२肑ỉ"));
      } else {
         return new eso("", a.c(-1523318181, "ٿ翆\uf100欒\ue0b2昇\udc5f喫쮋䄷슈㳫뉅⮋ꇙ✦鵪\u12c1衼ੁ蟐﷿猰\ue8e5溑"));
      }
   }

   private static int[] etg(BufferedImage var0, int var1, int var2) {
      BufferedImage var3 = new BufferedImage(var1, var2, 1);
      Graphics2D var4 = var3.createGraphics();
      var4.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      var4.setColor(Color.WHITE);
      var4.fillRect(0, 0, var1, var2);
      var4.drawImage(var0, 0, 0, var1, var2, null);
      var4.dispose();
      int[] var5 = new int[var1 * var2];

      for (int var6 = 0; var6 < var2; var6++) {
         for (int var7 = 0; var7 < var1; var7++) {
            int var8 = var3.getRGB(var7, var6);
            var5[var6 * var1 + var7] = ((var8 >> 16 & 0xFF) * 299 + (var8 >> 8 & 0xFF) * 587 + (var8 & 0xFF) * 114) / 1000;
         }
      }

      return var5;
   }

   private static int[] eth(int[] var0, int var1, int var2) {
      int[] var3 = new int[var1 * var2];
      int[] var4 = new int[9];

      for (int var5 = 0; var5 < var2; var5++) {
         for (int var6 = 0; var6 < var1; var6++) {
            int var7 = 0;

            for (int var8 = -1; var8 <= 1; var8++) {
               int var9 = Math.min(Math.max(var5 + var8, 0), var2 - 1);

               for (int var10 = -1; var10 <= 1; var10++) {
                  var4[var7++] = var0[var9 * var1 + Math.min(Math.max(var6 + var10, 0), var1 - 1)];
               }
            }

            Arrays.sort(var4, 0, 9);
            var3[var5 * var1 + var6] = var4[4];
         }
      }

      return var3;
   }

   private static boolean[] eti(boolean[] var0, int var1, int var2, int var3) {
      int var4 = var3 * var3;
      ArrayList var5 = new ArrayList();

      for (int var6 = -var3; var6 <= var3; var6++) {
         for (int var7 = -var3; var7 <= var3; var7++) {
            if (var7 * var7 + var6 * var6 <= var4) {
               var5.add(new int[]{var7, var6});
            }
         }
      }

      int[][] var17 = var5.toArray(int[][]::new);
      boolean[] var18 = new boolean[var1 * var2];

      for (int var8 = 0; var8 < var2; var8++) {
         for (int var9 = 0; var9 < var1; var9++) {
            boolean var10 = true;

            for (int[] var14 : var17) {
               int var15 = var9 + var14[0];
               int var16 = var8 + var14[1];
               if (var15 < 0 || var15 >= var1 || var16 < 0 || var16 >= var2 || !var0[var16 * var1 + var15]) {
                  var10 = false;
                  break;
               }
            }

            var18[var8 * var1 + var9] = var10;
         }
      }

      boolean[] var19 = new boolean[var1 * var2];

      for (int var20 = 0; var20 < var2; var20++) {
         for (int var21 = 0; var21 < var1; var21++) {
            for (int[] var25 : var17) {
               int var26 = var21 + var25[0];
               int var27 = var20 + var25[1];
               if (var26 >= 0 && var26 < var1 && var27 >= 0 && var27 < var2 && var18[var27 * var1 + var26]) {
                  var19[var20 * var1 + var21] = true;
                  break;
               }
            }
         }
      }

      return var19;
   }

   private static List<int[]> etj(boolean[] var0, int var1, int var2, int[] var3) {
      int[] var4 = new int[var1 * var2 + 1];
      int var5 = 1;

      for (int var6 = 0; var6 < var2; var6++) {
         for (int var7 = 0; var7 < var1; var7++) {
            int var8 = var6 * var1 + var7;
            if (var0[var8]) {
               int var9 = 0;

               for (int[] var13 : new int[][]{{var7 - 1, var6}, {var7 - 1, var6 - 1}, {var7, var6 - 1}, {var7 + 1, var6 - 1}}) {
                  if (var13[0] >= 0 && var13[0] < var1 && var13[1] >= 0 && var13[1] < var2) {
                     int var14 = var3[var13[1] * var1 + var13[0]];
                     if (var14 > 0) {
                        int var15 = etk(var4, var14);
                        if (var9 == 0 || var15 < var9) {
                           var9 = var15;
                        }
                     }
                  }
               }

               if (var9 == 0) {
                  var3[var8] = var5;
                  var4[var5] = var5++;
               } else {
                  var3[var8] = var9;

                  for (int[] var28 : new int[][]{{var7 - 1, var6}, {var7 - 1, var6 - 1}, {var7, var6 - 1}, {var7 + 1, var6 - 1}}) {
                     if (var28[0] >= 0 && var28[0] < var1 && var28[1] >= 0 && var28[1] < var2) {
                        int var29 = var3[var28[1] * var1 + var28[0]];
                        if (var29 > 0) {
                           etl(var4, var9, var29);
                        }
                     }
                  }
               }
            }
         }
      }

      HashMap var16 = new HashMap();

      for (int var17 = 0; var17 < var2; var17++) {
         for (int var19 = 0; var19 < var1; var19++) {
            int var21 = var17 * var1 + var19;
            if (var3[var21] > 0) {
               int var24 = etk(var4, var3[var21]);
               var3[var21] = var24;
               int[] var26 = var16.computeIfAbsent(
                  var24, var1x -> new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, var24}
               );
               if (var19 < var26[0]) {
                  var26[0] = var19;
               }

               if (var17 < var26[1]) {
                  var26[1] = var17;
               }

               if (var19 > var26[2]) {
                  var26[2] = var19;
               }

               if (var17 > var26[3]) {
                  var26[3] = var17;
               }

               var26[4]++;
            }
         }
      }

      ArrayList var18 = new ArrayList();

      for (int[] var22 : var16.values()) {
         var18.add(new int[]{var22[0], var22[1], var22[2] - var22[0] + 1, var22[3] - var22[1] + 1, var22[4], var22[5]});
      }

      return var18;
   }

   private static int etk(int[] var0, int var1) {
      while (var0[var1] != var1) {
         var0[var1] = var0[var0[var1]];
         var1 = var0[var1];
      }

      return var1;
   }

   private static void etl(int[] var0, int var1, int var2) {
      int var3 = etk(var0, var1);
      int var4 = etk(var0, var2);
      if (var3 != var4) {
         var0[Math.max(var3, var4)] = Math.min(var3, var4);
      }
   }

   private static boolean[] etm(int[] var0, int var1, int[] var2) {
      int var3 = var2[0];
      int var4 = var2[1];
      int var5 = var2[2];
      int var6 = var2[3];
      int var7 = var2[5];
      boolean[] var8 = new boolean[var5 * var6];

      for (int var9 = 0; var9 < var6; var9++) {
         for (int var10 = 0; var10 < var5; var10++) {
            var8[var9 * var5 + var10] = var0[(var4 + var9) * var1 + var3 + var10] == var7;
         }
      }

      return var8;
   }

   private static float[] etn(boolean[] var0, int var1, int var2) {
      float var3 = Math.min(20.0F / var1, 28.0F / var2);
      int var4 = Math.max(1, Math.round(var1 * var3));
      int var5 = Math.max(1, Math.round(var2 * var3));
      int var6 = (20 - var4) / 2;
      int var7 = (28 - var5) / 2;
      float[] var8 = new float[560];

      for (int var9 = 0; var9 < var5; var9++) {
         int var10 = var2 * var9 / var5;
         int var11 = Math.max(var10 + 1, var2 * (var9 + 1) / var5);

         for (int var12 = 0; var12 < var4; var12++) {
            int var13 = var1 * var12 / var4;
            int var14 = Math.max(var13 + 1, var1 * (var12 + 1) / var4);
            int var15 = 0;
            int var16 = 0;

            for (int var17 = var10; var17 < var11; var17++) {
               for (int var18 = var13; var18 < var14; var18++) {
                  var16++;
                  if (var0[var17 * var1 + var18]) {
                     var15++;
                  }
               }
            }

            var8[(var7 + var9) * 20 + var6 + var12] = var16 > 0 ? (float)var15 / var16 : 0.0F;
         }
      }

      return var8;
   }

   private static float eto(float[] var0) {
      float var1 = 0.0F;

      for (float var5 : var0) {
         var1 += var5 * var5;
      }

      return (float)Math.sqrt(var1);
   }

   private static int etp(float[] var0, est[] var1) {
      float var2 = eto(var0);
      if (var2 < 1.0E-4F) {
         return -1;
      } else {
         float[] var3 = new float[10];
         Arrays.fill(var3, -1.0F);

         for (est var7 : var1) {
            float var8 = 0.0F;
            float[] var9 = var7.esv;

            for (int var10 = 0; var10 < 560; var10++) {
               var8 += var0[var10] * var9[var10];
            }

            float var16 = var8 / (var2 * var7.esw);
            if (var16 > var3[var7.esu]) {
               var3[var7.esu] = var16;
            }
         }

         int var11 = -1;
         float var12 = -1.0F;
         float var13 = -1.0F;

         for (int var14 = 0; var14 < 10; var14++) {
            float var15 = var3[var14];
            if (var15 > var12) {
               var13 = var12;
               var12 = var15;
               var11 = var14;
            } else if (var15 > var13) {
               var13 = var15;
            }
         }

         return !(var12 < 0.55F) && !(var12 - var13 < 0.04F) ? var11 : -1;
      }
   }

   private static est[] etq() {
      est[] var0 = etd;
      if (var0 != null) {
         return var0;
      } else {
         synchronized (esz.class) {
            if (etd != null) {
               return etd;
            } else {
               etd = etr();
               return etd;
            }
         }
      }
   }

   private static est[] etr() {
      String[] var0 = new String[]{
         a.b("銂\ueb00懈ﾱ瑫", 409244358),
         a.b("렣송䭥픂廐\ud86e戲", 90093682),
         a.b("䧲ぶ몬ⓚ꼏⦲", 97405344),
         a.d("ম瀩\ufaf8撁\uef5c榨펎婣", 1199774138, 1290997839),
         a.c(-1217903313, "䕫㳸똦⡒ꎎ┯齧"),
         a.c(875692957, "ϒ穂\uf09e滤\ue504掖\ud990倒칿䓁쌏")
      };
      HashSet var1 = new HashSet<>(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
      ArrayList var2 = new ArrayList();

      for (String var6 : var0) {
         if (var1.contains(var6)) {
            var2.add(new Font(var6, 1, 96));
         }
      }

      var2.add(new Font(a.b("벜씟促톯婘\udcdf暛\uef71無", -901661498), 1, 96));
      var2.add(new Font(a.b("\ue375髩ဲ蹎֚茣", -401022153), 1, 96));
      var2.add(new Font(a.b("꼚횉屛숫䧠콒甐ﳣ抺\ue80a", -810242211), 1, 96));
      double[] var15 = new double[17];

      for (int var16 = 0; var16 < var15.length; var16++) {
         var15[var16] = Math.toRadians(-80 + var16 * 10);
      }

      ArrayList var17 = new ArrayList(var2.size() * 10 * var15.length);

      for (Font var19 : var2) {
         for (int var7 = 0; var7 < 10; var7++) {
            for (double var11 : var15) {
               float[] var13 = ets(var7, var19, var11);
               if (var13 != null) {
                  float var14 = eto(var13);
                  if (var14 > 0.01F) {
                     var17.add(new est((byte)var7, var13, var14));
                  }
               }
            }
         }
      }

      return var17.toArray(new est[0]);
   }

   private static float[] ets(int var0, Font var1, double var2) {
      short var4 = 320;
      BufferedImage var5 = new BufferedImage(var4, var4, 10);
      Graphics2D var6 = var5.createGraphics();
      var6.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var6.setColor(Color.WHITE);
      var6.fillRect(0, 0, var4, var4);
      var6.setColor(Color.BLACK);
      var6.setFont(var1);
      FontMetrics var7 = var6.getFontMetrics();
      String var8 = String.valueOf(var0);
      int var9 = var7.stringWidth(var8);
      AffineTransform var10 = AffineTransform.getRotateInstance(var2, var4 / 2.0, var4 / 2.0);
      var6.setTransform(var10);
      int var11 = var4 / 2 + (var7.getAscent() - var7.getDescent()) / 2;
      var6.drawString(var8, (var4 - var9) / 2, var11);
      var6.dispose();
      byte[] var12 = ((DataBufferByte)var5.getRaster().getDataBuffer()).getData();
      int var13 = var4;
      int var14 = -1;
      int var15 = var4;
      int var16 = -1;

      for (int var17 = 0; var17 < var4; var17++) {
         int var18 = var17 * var4;

         for (int var19 = 0; var19 < var4; var19++) {
            if ((var12[var18 + var19] & 255) < 128) {
               if (var19 < var13) {
                  var13 = var19;
               }

               if (var19 > var14) {
                  var14 = var19;
               }

               if (var17 < var15) {
                  var15 = var17;
               }

               if (var17 > var16) {
                  var16 = var17;
               }
            }
         }
      }

      if (var14 < 0) {
         return null;
      } else {
         int var23 = var14 - var13 + 1;
         int var24 = var16 - var15 + 1;
         boolean[] var25 = new boolean[var23 * var24];

         for (int var20 = 0; var20 < var24; var20++) {
            int var21 = (var15 + var20) * var4 + var13;

            for (int var22 = 0; var22 < var23; var22++) {
               var25[var20 * var23 + var22] = (var12[var21 + var22] & 255) < 128;
            }
         }

         return etn(var25, var23, var24);
      }
   }
}
