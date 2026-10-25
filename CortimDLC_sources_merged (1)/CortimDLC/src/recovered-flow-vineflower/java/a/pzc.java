package a;

import flow.dev.a;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

public final class pzc {
   private static final int pzd = 40;
   private static final int pze = 26;
   private static final int pzf = 8;
   private static final Map<Block, Boolean> pzg = new IdentityHashMap<>();
   public final int minX;
   public final int minY;
   public final int minZ;
   public final int maxX;
   public final int maxY;
   public final int maxZ;
   public final int ores;

   public pzc(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.minX = var1;
      this.minY = var2;
      this.minZ = var3;
      this.maxX = var4;
      this.maxY = var5;
      this.maxZ = var6;
      this.ores = var7;
   }

   public static pzc empty(BlockPos var0) {
      return new pzc(var0.getX(), var0.getY(), var0.getZ(), var0.getX() - 1, var0.getY() - 1, var0.getZ() - 1, 0);
   }

   public boolean contains(int var1, int var2, int var3) {
      return var1 >= this.minX && var1 <= this.maxX && var2 >= this.minY && var2 <= this.maxY && var3 >= this.minZ && var3 <= this.maxZ;
   }

   public boolean contains(BlockPos var1) {
      return this.contains(var1.getX(), var1.getY(), var1.getZ());
   }

   public int volume() {
      return (this.maxX - this.minX + 1) * (this.maxY - this.minY + 1) * (this.maxZ - this.minZ + 1);
   }

   public boolean covers(pzc var1) {
      return var1.minX >= this.minX
         && var1.maxX <= this.maxX
         && var1.minY >= this.minY
         && var1.maxY <= this.maxY
         && var1.minZ >= this.minZ
         && var1.maxZ <= this.maxZ;
   }

   public Vec3d center() {
      return new Vec3d((this.minX + this.maxX + 1) * 0.5, this.maxY + 1.0, (this.minZ + this.maxZ + 1) * 0.5);
   }

   public double distanceTo(Vec3d var1) {
      double var2 = Math.max(0.0, Math.max(this.minX - var1.x, var1.x - (this.maxX + 1)));
      double var4 = Math.max(0.0, Math.max(this.minY - var1.y, var1.y - (this.maxY + 1)));
      double var6 = Math.max(0.0, Math.max(this.minZ - var1.z, var1.z - (this.maxZ + 1)));
      return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   @Override
   public String toString() {
      return a.c(-1685265731, "\ue2e7")
         + this.minX
         + a.d("꧔", -2033143432, -1439295347)
         + this.minY
         + a.b("댓", -236080334)
         + this.minZ
         + a.b("꓆\udd79垪징", 1605477602)
         + this.maxX
         + a.c(1034582923, "箪")
         + this.maxY
         + a.d("\uf486", 597257731, 1448188580)
         + this.maxZ
         + a.d("\uf31a論", 732030834, 355669047)
         + this.ores
         + a.c(-691344193, "\uec9a镤ᾪ臌\u0a0d");
   }

   public static boolean isOre(BlockState var0) {
      Block var1 = var0.getBlock();
      Boolean var2 = pzg.get(var1);
      if (var2 == null) {
         String var3 = Registries.BLOCK.getId(var1).getPath();
         var2 = var3.endsWith(a.d("觇\uf046窈\ue4ee", 677064703, -1548704157)) || var3.equals(a.d("\ue6d2齬ᖲ诉\u0012蚨㳡딻⭟ꇯ☻\udc5a劖쬽", 1293802267, -383828570));
         pzg.put(var1, var2);
      }

      return var2;
   }

   public static boolean loaded(World var0, Vec3d var1) {
      int var2 = (int)Math.floor(var1.x);
      int var3 = (int)Math.floor(var1.z);

      for (int var4 = var2 - 40 >> 4; var4 <= var2 + 40 >> 4; var4++) {
         for (int var5 = var3 - 40 >> 4; var5 <= var3 + 40 >> 4; var5++) {
            if (!var0.isChunkLoaded(var4, var5)) {
               return false;
            }
         }
      }

      return true;
   }

   public static pzc detect(World var0, Vec3d var1) {
      int var2 = (int)Math.floor(var1.x);
      int var3 = (int)Math.floor(var1.y);
      int var4 = (int)Math.floor(var1.z);
      byte var5 = 81;
      byte var6 = 35;
      int[] var7 = new int[var5];
      int[] var8 = new int[var5];
      int[] var9 = new int[var6];
      int var10 = 0;
      Mutable var11 = new Mutable();

      for (int var12 = 0; var12 < var5; var12++) {
         for (int var13 = 0; var13 < var5; var13++) {
            int var14 = var2 - 40 + var12;
            int var15 = var4 - 40 + var13;
            if (var0.isChunkLoaded(var14 >> 4, var15 >> 4)) {
               for (int var16 = 0; var16 < var6; var16++) {
                  var11.set(var14, var3 - 26 + var16, var15);
                  if (isOre(var0.getBlockState(var11))) {
                     var7[var12]++;
                     var8[var13]++;
                     var9[var16]++;
                     var10++;
                  }
               }
            }
         }
      }

      if (var10 < 12) {
         return null;
      }

      int[] var23 = pzj(var7);
      int[] var24 = pzj(var8);
      int[] var25 = pzj(var9);
      if (var23 != null && var24 != null && var25 != null) {
         int var26 = var23[1] - var23[0] + 1;
         int var27 = var24[1] - var24[0] + 1;
         int var17 = var25[1] - var25[0] + 1;
         if (var26 >= 4 && var27 >= 4 && var26 <= 90 && var27 <= 90 && var17 >= 1 && var17 <= 32) {
            pzc var18 = new pzc(
               var2 - 40 + var23[0], var3 - 26 + var25[0], var4 - 40 + var24[0], var2 - 40 + var23[1], var3 - 26 + var25[1], var4 - 40 + var24[1], 0
            );
            int var19 = 0;

            for (int var20 = var18.minX; var20 <= var18.maxX; var20++) {
               for (int var21 = var18.minZ; var21 <= var18.maxZ; var21++) {
                  for (int var22 = var18.minY; var22 <= var18.maxY; var22++) {
                     if (isOre(var0.getBlockState(var11.set(var20, var22, var21)))) {
                        var19++;
                     }
                  }
               }
            }

            return !(var19 < var10 * 0.6) && var19 >= 10 ? new pzc(var18.minX, var18.minY, var18.minZ, var18.maxX, var18.maxY, var18.maxZ, var19) : null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static int[] pzj(int[] var0) {
      int var1 = 0;

      for (int var5 : var0) {
         var1 = Math.max(var1, var5);
      }

      int var12 = Math.max(2, (int)Math.ceil(var1 * 0.12));
      int var13 = -1;
      int var14 = -1;
      long var15 = 0L;
      int var7 = -1;
      long var8 = 0L;

      for (int var10 = 0; var10 <= var0.length; var10++) {
         boolean var11 = var10 < var0.length && var0[var10] >= var12;
         if (var11) {
            if (var7 < 0) {
               var7 = var10;
               var8 = 0L;
            }

            var8 += var0[var10];
         } else if (var7 >= 0) {
            if (var8 > var15) {
               var15 = var8;
               var13 = var7;
               var14 = var10 - 1;
            }

            var7 = -1;
         }
      }

      return var13 < 0 ? null : new int[]{var13, var14};
   }
}
