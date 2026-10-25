package a;

import flow.dev.a;

public final class tvn {
   public static final int RX = 7;
   public static final int DOWN = 3;
   public static final int UP = 7;
   public static final int W = 15;
   public static final int H = 11;
   public static final int SIZE = 2475;
   public final int x0;
   public final int y0;
   public final int z0;
   public final byte[] cells;

   public tvn(int var1, int var2, int var3, byte[] var4) {
      if (var4.length != 2475) {
         throw new IllegalArgumentException(a.d("縪ކ赚ጺ颽ṟꐖⷴ뎴", -1474897051, 358130997));
      } else {
         this.x0 = var1;
         this.y0 = var2;
         this.z0 = var3;
         this.cells = var4;
      }
   }

   public static tvn around(int var0, int var1, int var2, byte[] var3) {
      return new tvn(var0 - 7, var1 - 3, var2 - 7, var3);
   }

   public static int index(int var0, int var1, int var2) {
      return (var0 * 11 + var1) * 15 + var2;
   }

   public boolean inside(int var1, int var2, int var3) {
      int var4 = var1 - this.x0;
      int var5 = var2 - this.y0;
      int var6 = var3 - this.z0;
      return var4 >= 0 && var5 >= 0 && var6 >= 0 && var4 < 15 && var5 < 11 && var6 < 15;
   }

   public byte at(int var1, int var2, int var3) {
      int var4 = var1 - this.x0;
      int var5 = var2 - this.y0;
      int var6 = var3 - this.z0;
      return var4 >= 0 && var5 >= 0 && var6 >= 0 && var4 < 15 && var5 < 11 && var6 < 15 ? this.cells[index(var4, var5, var6)] : 4;
   }
}
