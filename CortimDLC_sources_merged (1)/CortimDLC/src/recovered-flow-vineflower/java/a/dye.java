package a;

import java.util.Arrays;
import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.LightType;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.WorldChunk;

final class dye {
   dxv scene;
   ClientWorld world;
   final Mutable pos = new Mutable();
   final Mutable light = new Mutable();
   long chunkKey = Long.MIN_VALUE;
   WorldChunk chunk;
   int chunkTop;
   ChunkSection[] sections;
   int sectionBase;
   double hitDistance;
   final long[] lightKeys = new long[2048];
   final int[] lightValues = new int[2048];
   final long[] tintKeys = new long[1024];
   final int[] tintValues = new int[1024];
   final Object[] tintStates = new Object[1024];
   BlockState lastState;
   dxq lastLook;

   dye() {
   }

   void begin(dxv var1, boolean var2) {
      if (this.world != var1.world || var2) {
         Arrays.fill(this.lightKeys, 0L);
         Arrays.fill(this.tintKeys, 0L);
         Arrays.fill(this.tintStates, null);
      }

      this.scene = var1;
      this.world = var1.world;
      this.chunkKey = Long.MIN_VALUE;
      this.chunk = null;
      this.sections = null;
      this.lastState = null;
      this.lastLook = null;
   }

   ChunkSection section(int var1, int var2, int var3) {
      if (var2 >= this.scene.bottomY && var2 <= this.scene.topY) {
         int var4 = var1 >> 4;
         int var5 = var3 >> 4;
         long var6 = (long)var4 << 32 ^ var5 & 4294967295L;
         if (var6 != this.chunkKey) {
            this.chunkKey = var6;
            this.chunk = this.world.getChunkManager().getWorldChunk(var4, var5, false);
            this.sections = this.chunk == null ? null : this.chunk.getSectionArray();
            this.chunkTop = this.chunk == null ? this.scene.topY + 1 : this.scene.top(var6, this.chunk);
            this.sectionBase = this.world.getBottomSectionCoord();
         }

         if (this.sections == null) {
            return null;
         }

         int var8 = (var2 >> 4) - this.sectionBase;
         return var8 >= 0 && var8 < this.sections.length ? this.sections[var8] : null;
      } else {
         return null;
      }
   }

   int sky(double var1) {
      double var3 = MathHelper.clamp(var1 * 1.6 + 0.15, 0.0, 1.0);
      return dyh.mix(this.scene.skyHorizon, this.scene.skyTop, var3);
   }

   int trace(double var1, double var3, double var5, double var7, double var9, double var11) {
      double var13 = 0.0;
      double var15 = 0.0;
      double var17 = 0.0;
      double var19 = 1.0;
      boolean var21 = false;
      double var22 = 0.0;
      int var24 = MathHelper.floor(var1);
      int var25 = MathHelper.floor(var3);
      int var26 = MathHelper.floor(var5);
      int var27 = var7 > 0.0 ? 1 : -1;
      int var28 = var9 > 0.0 ? 1 : -1;
      int var29 = var11 > 0.0 ? 1 : -1;
      double var30 = Math.abs(1.0 / var7);
      double var32 = Math.abs(1.0 / var9);
      double var34 = Math.abs(1.0 / var11);
      double var36 = (var7 > 0.0 ? var24 + 1 - var1 : var1 - var24) * var30;
      double var38 = (var9 > 0.0 ? var25 + 1 - var3 : var3 - var25) * var32;
      double var40 = (var11 > 0.0 ? var26 + 1 - var5 : var5 - var26) * var34;
      byte var42 = -1;
      this.hitDistance = 56.0;

      while (var22 < 56.0 && (var25 >= this.scene.bottomY || !(var9 <= 0.0)) && (var25 <= this.scene.topY || !(var9 >= 0.0))) {
         ChunkSection var43 = this.section(var24, var25, var26);
         double var44 = -1.0;
         if (var43 != null && !var43.isEmpty()) {
            if (var25 >= this.chunkTop) {
               double var46 = this.columnExit(var24, var26, var1, var5, var7, var11);
               if (var9 < 0.0) {
                  var46 = Math.min(var46, (this.chunkTop - var3) / var9);
               }

               if (var46 > var22 + 0.001) {
                  var44 = var46;
               }
            }
         } else {
            if (var43 == null && this.sections == null && var25 >= this.scene.bottomY && var25 <= this.scene.topY) {
               break;
            }

            var44 = this.sectionExit(var24, var25, var26, var1, var3, var5, var7, var9, var11);
         }

         if (var44 >= 0.0) {
            if (var21) {
               var21 = false;
            }

            if (var44 >= 56.0) {
               break;
            }

            var22 = var44 + 1.0E-4;
            double var64 = var1 + var7 * var22;
            double var65 = var3 + var9 * var22;
            double var68 = var5 + var11 * var22;
            int var70 = MathHelper.floor(var64);
            int var72 = MathHelper.floor(var65);
            int var74 = MathHelper.floor(var68);
            var42 = (byte)(var70 != var24 ? 0 : (var72 != var25 ? 1 : 2));
            var24 = var70;
            var25 = var72;
            var26 = var74;
            var36 = var22 + (var7 > 0.0 ? var24 + 1 - var64 : var64 - var24) * var30;
            var38 = var22 + (var9 > 0.0 ? var25 + 1 - var65 : var65 - var25) * var32;
            var40 = var22 + (var11 > 0.0 ? var26 + 1 - var68 : var68 - var26) * var34;
         } else {
            BlockState var63 = var43.getBlockState(var24 & 15, var25 & 15, var26 & 15);
            dxq var47;
            if (var63.isAir()) {
               var47 = null;
            } else if (var63 == this.lastState) {
               var47 = this.lastLook;
            } else {
               var47 = dyh.dym.computeIfAbsent(var63, dxq::new);
               this.lastState = var63;
               this.lastLook = var47;
            }

            double var48 = Math.min(var36, Math.min(var38, var40));
            if (var47 != null && !var47.air) {
               if (var47.water && var47.fluidOnly) {
                  if (!var21) {
                     int var66 = this.surface(var47, var63, var24, var25, var26, var42, var1, var3, var5, var7, var9, var11, var22);
                     double var69 = 0.45;
                     var13 += (var66 >> 16 & 0xFF) * var69 * var19;
                     var15 += (var66 >> 8 & 0xFF) * var69 * var19;
                     var17 += (var66 & 0xFF) * var69 * var19;
                     var19 *= 1.0 - var69;
                     var21 = true;
                  }

                  double var67 = Math.max(0.0, var48 - var22);
                  double var52 = Math.exp(-0.12 * var67);
                  double var73 = 1.0 - var52;
                  int var77 = dyh.scale(this.scene.waterTint, 0.55);
                  var13 += (var77 >> 16 & 0xFF) * var73 * var19;
                  var15 += (var77 >> 8 & 0xFF) * var73 * var19;
                  var17 += (var77 & 0xFF) * var73 * var19;
                  var19 *= var52;
               } else {
                  var21 = false;
                  double var51 = var22;
                  int var50;
                  if (!var47.fullCube && !var47.fluidOnly) {
                     this.pos.set(var24, var25, var26);

                     VoxelShape var53;
                     try {
                        var53 = var63.getOutlineShape(this.world, this.pos);
                     } catch (Throwable var59) {
                        var53 = null;
                     }

                     var50 = -1;
                     if (var53 != null && !var53.isEmpty()) {
                        Vec3d var54 = new Vec3d(var1 + var7 * (var22 - 0.001), var3 + var9 * (var22 - 0.001), var5 + var11 * (var22 - 0.001));
                        Vec3d var55 = new Vec3d(var1 + var7 * (var48 + 0.001), var3 + var9 * (var48 + 0.001), var5 + var11 * (var48 + 0.001));
                        BlockHitResult var56 = var53.raycast(var54, var55, this.pos);
                        if (var56 != null) {
                           Vec3d var57 = var56.getPos();
                           var51 = Math.sqrt((var57.x - var1) * (var57.x - var1) + (var57.y - var3) * (var57.y - var3) + (var57.z - var5) * (var57.z - var5));
                           var50 = this.shade(var47, var63, var24, var25, var26, var56.getSide(), var57.x, var57.y, var57.z);
                        }
                     }
                  } else {
                     var50 = this.surface(var47, var63, var24, var25, var26, var42, var1, var3, var5, var7, var9, var11, var22);
                  }

                  if (var50 != -1 && var50 >>> 24 != 0) {
                     double var71 = (var50 >>> 24) / 255.0;
                     if (var47.lava) {
                        var71 = 1.0;
                     }

                     double var75 = Math.min(1.0, var51 / 56.0);
                     var75 *= var75;
                     int var78 = this.sky(var9);
                     int var58 = dyh.mix(var50, var78, var75);
                     var13 += (var58 >> 16 & 0xFF) * var71 * var19;
                     var15 += (var58 >> 8 & 0xFF) * var71 * var19;
                     var17 += (var58 & 0xFF) * var71 * var19;
                     var19 *= 1.0 - var71;
                     if (var19 < 0.04) {
                        this.hitDistance = var51;
                        break;
                     }

                     if (this.hitDistance >= 56.0 && var71 > 0.5) {
                        this.hitDistance = var51;
                     }
                  }
               }
            } else if (var21) {
               var21 = false;
            }

            if (var36 < var38 && var36 < var40) {
               var24 += var27;
               var22 = var36;
               var36 += var30;
               var42 = 0;
            } else if (var38 < var40) {
               var25 += var28;
               var22 = var38;
               var38 += var32;
               var42 = 1;
            } else {
               var26 += var29;
               var22 = var40;
               var40 += var34;
               var42 = 2;
            }
         }
      }

      if (var19 > 0.0) {
         int var60 = this.sky(var9);
         var13 += (var60 >> 16 & 0xFF) * var19;
         var15 += (var60 >> 8 & 0xFF) * var19;
         var17 += (var60 & 0xFF) * var19;
      }

      int var61 = (int)Math.min(255.0, var13);
      int var62 = (int)Math.min(255.0, var15);
      int var45 = (int)Math.min(255.0, var17);
      return 0xFF000000 | var61 << 16 | var62 << 8 | var45;
   }

   double columnExit(int var1, int var2, double var3, double var5, double var7, double var9) {
      int var11 = var1 & -16;
      int var12 = var2 & -16;
      double var13 = var7 > 0.0 ? (var11 + 16 - var3) / var7 : (var7 < 0.0 ? (var11 - var3) / var7 : Double.MAX_VALUE);
      double var15 = var9 > 0.0 ? (var12 + 16 - var5) / var9 : (var9 < 0.0 ? (var12 - var5) / var9 : Double.MAX_VALUE);
      return Math.min(var13, var15);
   }

   double sectionExit(int var1, int var2, int var3, double var4, double var6, double var8, double var10, double var12, double var14) {
      int var16 = var1 & -16;
      int var17 = var2 & -16;
      int var18 = var3 & -16;
      double var19 = var10 > 0.0 ? (var16 + 16 - var4) / var10 : (var10 < 0.0 ? (var16 - var4) / var10 : Double.MAX_VALUE);
      double var21 = var12 > 0.0 ? (var17 + 16 - var6) / var12 : (var12 < 0.0 ? (var17 - var6) / var12 : Double.MAX_VALUE);
      double var23 = var14 > 0.0 ? (var18 + 16 - var8) / var14 : (var14 < 0.0 ? (var18 - var8) / var14 : Double.MAX_VALUE);
      return Math.min(var19, Math.min(var21, var23));
   }

   int surface(
      dxq var1,
      BlockState var2,
      int var3,
      int var4,
      int var5,
      int var6,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19
   ) {
      double var21 = var7 + var13 * var19;
      double var23 = var9 + var15 * var19;
      double var25 = var11 + var17 * var19;
      Direction var27;
      if (var6 == 0) {
         var27 = var13 > 0.0 ? Direction.WEST : Direction.EAST;
      } else if (var6 == 1) {
         var27 = var15 > 0.0 ? Direction.DOWN : Direction.UP;
      } else if (var6 == 2) {
         var27 = var17 > 0.0 ? Direction.NORTH : Direction.SOUTH;
      } else {
         var27 = Direction.UP;
      }

      return this.shade(var1, var2, var3, var4, var5, var27, var21, var23, var25);
   }

   int shade(dxq var1, BlockState var2, int var3, int var4, int var5, Direction var6, double var7, double var9, double var11) {
      double var13 = var7 - Math.floor(var7);
      double var15 = var9 - Math.floor(var9);
      double var17 = var11 - Math.floor(var11);
      double var19;
      double var21;
      switch (var6) {
         case UP:
            var19 = var13;
            var21 = var17;
            break;
         case DOWN:
            var19 = var13;
            var21 = 1.0 - var17;
            break;
         case NORTH:
            var19 = 1.0 - var13;
            var21 = 1.0 - var15;
            break;
         case SOUTH:
            var19 = var13;
            var21 = 1.0 - var15;
            break;
         case WEST:
            var19 = var17;
            var21 = 1.0 - var15;
            break;
         default:
            var19 = 1.0 - var17;
            var21 = 1.0 - var15;
      }

      int var23 = 0;
      boolean var24 = false;
      dxl[] var25 = var1.faces[var6.ordinal()];
      if (var25 != null) {
         for (dxl var29 : var25) {
            int var30 = var29.dxm.sample(var19, var21);
            int var31 = var30 >>> 24;
            if (var31 != 0) {
               if (var29.dxn >= 0) {
                  var30 = dyh.mul(var30, this.tint(var2, var3, var4, var5, var29.dxn));
               }

               var23 = !var24 ? var30 : dyh.mix(var30 | 0xFF000000, var23, 1.0 - var31 / 255.0) & 16777215 | Math.max(var23 >>> 24, var31) << 24;
               var24 = true;
            }
         }
      }

      if (!var24) {
         if (var25 != null && var25.length > 0) {
            return 0;
         }

         var23 = var1.mapColor;
      }
      double var35 = switch (var6) {
         case UP -> 1.0;
         case DOWN -> 0.5;
         case NORTH, SOUTH -> 0.8;
         default -> 0.62;
      };
      this.light.set(var3 + var6.getOffsetX(), var4 + var6.getOffsetY(), var5 + var6.getOffsetZ());
      double var36;
      if (!var1.lava && var1.luminance < 12) {
         int var37 = this.light(this.light.getX(), this.light.getY(), this.light.getZ());
         int var39 = var37 >> 4;
         int var32 = var37 & 15;
         double var33 = Math.max(var39 * this.scene.daylight, Math.max(var32, var1.luminance));
         var36 = dyh.dys[MathHelper.clamp((int)(var33 * 4.0 + 0.5), 0, 60)];
         if (!this.scene.skyLight) {
            var36 = Math.max(var36, 0.42);
         }
      } else {
         var36 = 1.0;
      }

      double var38 = var35 * var36;
      if (this.scene.target != null && this.scene.target.getX() == var3 && this.scene.target.getY() == var4 && this.scene.target.getZ() == var5) {
         double var40 = Math.min(Math.min(var19, 1.0 - var19), Math.min(var21, 1.0 - var21));
         var38 = var40 < 0.035 ? 0.15 : var38 * 1.15;
      }

      int var41 = var23 >>> 24;
      return dyh.scale(var23, var38) & 16777215 | var41 << 24;
   }

   int light(int var1, int var2, int var3) {
      long var4 = BlockPos.asLong(var1, var2, var3);
      int var6 = (int)(var4 ^ var4 >>> 21 ^ var4 >>> 42) & 2047;
      if (this.lightKeys[var6] == var4 + 1L) {
         return this.lightValues[var6];
      }

      byte var7 = 0;
      byte var8 = 0;

      try {
         this.light.set(var1, var2, var3);
         boolean var9 = false;
         if (this.scene.skyLight) {
            WorldChunk var10 = this.world.getChunkManager().getWorldChunk(var1 >> 4, var3 >> 4, false);
            var9 = var10 != null && var2 > var10.sampleHeightmap(Type.MOTION_BLOCKING, var1 & 15, var3 & 15);
            var7 = (byte)(var9 ? 15 : this.world.getLightLevel(LightType.SKY, this.light));
         }

         var8 = (byte)(var9 && this.scene.daylight > 0.95 ? 0 : this.world.getLightLevel(LightType.BLOCK, this.light));
      } catch (Throwable var11) {
      }

      int var12 = var7 << 4 | var8;
      this.lightKeys[var6] = var4 + 1L;
      this.lightValues[var6] = var12;
      return var12;
   }

   int tint(BlockState var1, int var2, int var3, int var4, int var5) {
      long var6 = BlockPos.asLong(var2 >> 1, var5, var4 >> 1);
      int var8 = (int)(var6 ^ var6 >>> 19 ^ var1.hashCode()) & 1023;
      if (this.tintKeys[var8] == var6 + 1L && this.tintStates[var8] == var1) {
         return this.tintValues[var8];
      }

      int var9;
      try {
         this.pos.set(var2, var3, var4);
         int var10 = dyh.dyq.getBlockColors().getColor(var1, this.world, this.pos, var5);
         var9 = var10 == -1 ? -1 : 0xFF000000 | var10;
      } catch (Throwable var11) {
         var9 = -1;
      }

      this.tintKeys[var8] = var6 + 1L;
      this.tintStates[var8] = var1;
      this.tintValues[var8] = var9;
      return var9;
   }
}
