package a;

public final class tpx {
   public static final byte AIR = 0;
   public static final byte STONE = 1;
   public static final byte TARGET = 2;
   public static final byte ORE = 3;
   public static final byte HARD = 4;
   public static final byte FLUID = 5;
   public static final byte PART = 6;
   public static final int TYPE = 7;
   public static final int SLOW = 8;

   tpx() {
   }

   public static int type(byte var0) {
      return var0 & 7;
   }

   public static boolean open(byte var0) {
      int var1 = var0 & 7;
      return var1 == 0 || var1 == 5;
   }

   public static boolean minable(byte var0) {
      int var1 = var0 & 7;
      return var1 == 1 || var1 == 2 || var1 == 3 || var1 == 6;
   }

   public static boolean target(byte var0) {
      return (var0 & 7) == 2;
   }

   public static boolean ore(byte var0) {
      return (var0 & 7) == 3;
   }

   public static boolean slow(byte var0) {
      return (var0 & 8) != 0;
   }
}
