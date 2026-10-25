package a;

import flow.dev.a;

public final class tzg {
   public static final int RX = 6;
   public static final int DOWN = 3;
   public static final int UP = 3;
   public static final int W = 13;
   public static final int H = 7;
   public static final int SIZE = 1183;
   public static final int HEIGHT = 15;
   public static final int FULL = 8;
   public static final int TALL = 9;
   public static final int FLUID = 16;
   public static final int HAZARD = 32;
   public static final int CLIMB = 64;
   public static final int THIN = 128;
   public final int x0;
   public final int y0;
   public final int z0;
   public final byte[] cells;

   public tzg(int var1, int var2, int var3, byte[] var4) {
      if (var4.length != 1183) {
         throw new IllegalArgumentException(a.d("㾑䘶쳨办\ud902忠\ue5ae汐\uf21e磿ｿԔ诐ቾ", 1055866778, 2069823602));
      }

      this.x0 = var1;
      this.y0 = var2;
      this.z0 = var3;
      this.cells = var4;
   }

   public static int index(int var0, int var1, int var2) {
      return (var0 * 7 + var1) * 13 + var2;
   }

   public boolean inside(int var1, int var2, int var3) {
      int var4 = var1 - this.x0;
      int var5 = var2 - this.y0;
      int var6 = var3 - this.z0;
      return var4 >= 0 && var5 >= 0 && var6 >= 0 && var4 < 13 && var5 < 7 && var6 < 13;
   }

   public int at(int var1, int var2, int var3) {
      int var4 = var1 - this.x0;
      int var5 = var2 - this.y0;
      int var6 = var3 - this.z0;
      return var4 >= 0 && var5 >= 0 && var6 >= 0 && var4 < 13 && var5 < 7 && var6 < 13 ? this.cells[index(var4, var5, var6)] & 0xFF : 8;
   }

   public static int height(int var0) {
      return var0 & 15;
   }

   public static boolean solid(int var0) {
      return (var0 & 15) != 0;
   }

   public static float top(int var0) {
      int var1 = var0 & 15;
      return var1 >= 9 ? 1.5F : var1 / 8.0F;
   }
}
