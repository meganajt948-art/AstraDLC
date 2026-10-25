package a;

import flow.dev.a;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public final class qnd {
   public static final byte PASS = 1;
   public static final byte SOLID = 2;
   public static final byte STAND = 4;
   public static final byte BREAK = 8;
   public static final byte DANGER = 16;
   public static final byte LIQUID = 32;
   public static final byte TARGET = 64;
   static final float INF = Float.POSITIVE_INFINITY;
   static final float JUMP = 3.0F;
   static final float FALL = 1.0F;
   static final float DIG_DOWN = 3.0F;
   static final double REACH = 4.2;
   static final double EYE = 1.62;
   static final double LOW = 0.25;
   private static final Set<Block> qne = Set.of(
      Blocks.field_10036,
      Blocks.field_22089,
      Blocks.field_10092,
      Blocks.field_10029,
      Blocks.field_16999,
      Blocks.field_10343,
      Blocks.field_27879,
      Blocks.field_17350,
      Blocks.field_23860,
      Blocks.field_10606,
      Blocks.field_28048,
      Blocks.field_10164
   );
   public int x0;
   public int y0;
   public int z0;
   public int sx;
   public int sy;
   public int sz;
   private byte[] qnf = new byte[0];
   private short[] qng = new short[0];
   private float[] qnh = new float[0];
   private int[] qni = new int[0];
   private int[] qnj = new int[0];
   private float[] qnk = new float[0];
   private int qnl;
   private pzc qnm;
   private final qmr qnn = new qmr();
   private List<Vec3d> qno = List.of();
   private float qnp = 4.6F;
   private float qnq = 4.0F;
   private double qnr = 22.0;
   private float qns;
   private static final int[] qnt = new int[]{1, -1, 0, 0};
   private static final int[] qnu = new int[]{0, 0, 1, -1};
   private static final int[] qnv = new int[]{1, 1, -1, -1};
   private static final int[] qnw = new int[]{1, -1, 1, -1};

   public void tune(float var1, float var2, double var3, float var5) {
      this.qnp = var1;
      this.qnq = var2;
      this.qnr = var3;
      this.qns = var5;
   }

   public void build(World var1, ClientPlayerEntity var2, pzc var3, Predicate<BlockState> var4, LongSet var5, List<Vec3d> var6) {
      this.build(var1, var2, var3, var4, var5, var6, null);
   }

   public void build(World var1, ClientPlayerEntity var2, pzc var3, Predicate<BlockState> var4, LongSet var5, List<Vec3d> var6, BlockPos var7) {
      this.qnm = var3;
      this.qno = var6;
      BlockPos var8 = var2.method_24515();
      int var9 = Math.min(var3.minX - 4, var8.method_10263() - 3);
      int var10 = Math.max(var3.maxX + 4, var8.method_10263() + 3);
      int var11 = Math.min(var3.minZ - 4, var8.method_10260() - 3);
      int var12 = Math.max(var3.maxZ + 4, var8.method_10260() + 3);
      int var13 = Math.min(var3.minY - 1, var8.method_10264() - 4);
      int var14 = Math.max(var3.maxY + 4, var8.method_10264() + 3);
      if (var7 != null) {
         var9 = Math.min(var9, var7.method_10263() - 3);
         var10 = Math.max(var10, var7.method_10263() + 3);
         var11 = Math.min(var11, var7.method_10260() - 3);
         var12 = Math.max(var12, var7.method_10260() + 3);
         var13 = Math.min(var13, var7.method_10264() - 2);
         var14 = Math.max(var14, var7.method_10264() + 3);
      }

      this.x0 = var9;
      this.y0 = var13;
      this.z0 = var11;
      this.sx = Math.min(128, var10 - var9 + 1);
      this.sy = Math.min(56, var14 - var13 + 1);
      this.sz = Math.min(128, var12 - var11 + 1);
      int var15 = this.sx * this.sy * this.sz;
      if (this.qnf.length < var15) {
         this.qnf = new byte[var15];
         this.qng = new short[var15];
         this.qnh = new float[var15];
         this.qni = new int[var15];
      }

      Arrays.fill(this.qnf, 0, var15, (byte)0);
      this.qnl = 0;
      Mutable var16 = new Mutable();

      for (int var17 = 0; var17 < this.sx; var17++) {
         for (int var18 = 0; var18 < this.sz; var18++) {
            int var19 = this.x0 + var17;
            int var20 = this.z0 + var18;
            boolean var21 = var1.method_8393(var19 >> 4, var20 >> 4);

            for (int var22 = 0; var22 < this.sy; var22++) {
               int var23 = (var22 * this.sz + var18) * this.sx + var17;
               if (!var21) {
                  this.qnf[var23] = 2;
               } else {
                  int var24 = this.y0 + var22;
                  var16.method_10103(var19, var24, var20);
                  BlockState var25 = var1.method_8320(var16);
                  byte var26 = 0;
                  boolean var27 = qne.contains(var25.method_26204());
                  if (!var25.method_26227().method_15769()) {
                     var26 = (byte)(var26 | 32);
                  } else {
                     VoxelShape var28 = var25.method_26220(var1, var16);
                     if (!var28.method_1110() && !(var28.method_1105(Axis.field_11052) <= 0.25)) {
                        var26 = (byte)(var26 | 2);
                        double var29 = var28.method_1105(Axis.field_11052);
                        if (var27) {
                           var26 = (byte)(var26 | 16);
                        } else if (var29 > 0.49 && var29 <= 1.01) {
                           var26 = (byte)(var26 | 4);
                        }
                     } else {
                        var26 = (byte)(var26 | (var27 ? 16 : 1));
                     }
                  }

                  if (!var25.method_26215()
                     && (var26 & 32) == 0
                     && var3.contains(var19, var24, var20)
                     && !var5.contains(BlockPos.method_10064(var19, var24, var20))) {
                     float var32 = var25.method_26214(var1, var16);
                     float var33 = var32 < 0.0F ? 0.0F : var25.method_26165(var2, var1, var16);
                     if (var33 > 0.0F) {
                        var26 = (byte)(var26 | 8);
                        this.qng[var23] = (short)Math.min(600, Math.max(1, (int)Math.ceil(1.0F / var33)));
                        if (var4.test(var25)) {
                           var26 = (byte)(var26 | 64);
                           if (this.qnl == this.qnj.length) {
                              this.qnj = Arrays.copyOf(this.qnj, Math.max(64, this.qnl * 2));
                              this.qnk = Arrays.copyOf(this.qnk, this.qnj.length);
                           }

                           this.qnk[this.qnl] = value(var25);
                           this.qnj[this.qnl++] = var23;
                        }
                     }
                  }

                  this.qnf[var23] = var26;
               }
            }
         }
      }
   }

   public int targetCount() {
      return this.qnl;
   }

   public boolean inside(int var1, int var2, int var3) {
      return var1 >= this.x0 && var2 >= this.y0 && var3 >= this.z0 && var1 < this.x0 + this.sx && var2 < this.y0 + this.sy && var3 < this.z0 + this.sz;
   }

   public int index(int var1, int var2, int var3) {
      return ((var2 - this.y0) * this.sz + (var3 - this.z0)) * this.sx + (var1 - this.x0);
   }

   public int flags(int var1, int var2, int var3) {
      return this.inside(var1, var2, var3) ? this.qnf[this.index(var1, var2, var3)] : 2;
   }

   public int ticks(int var1, int var2, int var3) {
      return this.inside(var1, var2, var3) ? this.qng[this.index(var1, var2, var3)] : 0;
   }

   public int wx(int var1) {
      return this.x0 + var1 % this.sx;
   }

   public int wz(int var1) {
      return this.z0 + var1 / this.sx % this.sz;
   }

   public int wy(int var1) {
      return this.y0 + var1 / (this.sx * this.sz);
   }

   float clear(int var1, int var2, int var3) {
      int var4 = this.flags(var1, var2, var3);
      if ((var4 & 48) != 0) {
         return Float.POSITIVE_INFINITY;
      } else if ((var4 & 1) != 0) {
         return 0.0F;
      } else {
         return (var4 & 8) != 0 ? this.ticks(var1, var2, var3) + this.qnq : Float.POSITIVE_INFINITY;
      }
   }

   boolean pass(int var1, int var2, int var3) {
      int var4 = this.flags(var1, var2, var3);
      return (var4 & 1) != 0 && (var4 & 48) == 0;
   }

   boolean stand(int var1, int var2, int var3) {
      int var4 = this.flags(var1, var2, var3);
      return (var4 & 4) != 0 && (var4 & 16) == 0;
   }

   public void search(BlockPos var1) {
      int var2 = this.sx * this.sy * this.sz;
      Arrays.fill(this.qnh, 0, var2, Float.POSITIVE_INFINITY);
      Arrays.fill(this.qni, 0, var2, -1);
      this.qnn.clear();
      if (this.inside(var1.method_10263(), var1.method_10264(), var1.method_10260())) {
         int var3 = this.index(var1.method_10263(), var1.method_10264(), var1.method_10260());
         this.qnh[var3] = 0.0F;
         this.qnn.push(0.0F, var3);

         while (!this.qnn.isEmpty()) {
            float var4 = this.qnn.topKey();
            int var5 = this.qnn.pop();
            if (!(var4 > this.qnh[var5])) {
               int var6 = this.wx(var5);
               int var7 = this.wy(var5);
               int var8 = this.wz(var5);

               for (int var9 = 0; var9 < 4; var9++) {
                  int var10 = qnt[var9];
                  int var11 = qnu[var9];
                  int var12 = var6 + var10;
                  int var13 = var8 + var11;
                  float var14 = this.clear(var12, var7, var13) + this.clear(var12, var7 + 1, var13);
                  if (this.stand(var12, var7 - 1, var13)) {
                     this.qnz(var5, var12, var7, var13, var4 + this.qnp + var14);
                  } else if (this.pass(var12, var7 - 1, var13) && var14 < Float.POSITIVE_INFINITY) {
                     for (int var15 = 1; var15 <= 3 && this.pass(var12, var7 - var15, var13); var15++) {
                        if (this.stand(var12, var7 - var15 - 1, var13)) {
                           this.qnz(var5, var12, var7 - var15, var13, var4 + this.qnp + var15 * 1.0F + var14);
                           break;
                        }
                     }
                  }

                  if (this.stand(var12, var7, var13)) {
                     float var24 = this.clear(var6, var7 + 2, var8) + this.clear(var12, var7 + 1, var13) + this.clear(var12, var7 + 2, var13);
                     this.qnz(var5, var12, var7 + 1, var13, var4 + this.qnp + 3.0F + var24);
                  }
               }

               for (int var16 = 0; var16 < 4; var16++) {
                  int var18 = qnv[var16];
                  int var20 = qnw[var16];
                  int var22 = var6 + var18;
                  int var23 = var8 + var20;
                  if (this.pass(var22, var7, var23)
                     && this.pass(var22, var7 + 1, var23)
                     && this.pass(var6 + var18, var7, var8)
                     && this.pass(var6 + var18, var7 + 1, var8)
                     && this.pass(var6, var7, var8 + var20)
                     && this.pass(var6, var7 + 1, var8 + var20)
                     && this.stand(var22, var7 - 1, var23)) {
                     this.qnz(var5, var22, var7, var23, var4 + this.qnp * 1.414F);
                  }
               }

               int var17 = this.flags(var6, var7 - 1, var8);
               if ((var17 & 8) != 0 && (var17 & 16) == 0) {
                  float var19 = this.ticks(var6, var7 - 1, var8) + this.qnq + 3.0F;
                  if ((this.flags(var6, var7 - 2, var8) & 2) == 0) {
                     for (int var21 = 2; var21 <= 4 && this.pass(var6, var7 - var21, var8); var21++) {
                        if (this.stand(var6, var7 - var21 - 1, var8)) {
                           this.qnz(var5, var6, var7 - var21, var8, var4 + var19 + (var21 - 1) * 1.0F);
                           break;
                        }
                     }
                  } else if (this.stand(var6, var7 - 2, var8) || (this.flags(var6, var7 - 2, var8) & 8) != 0) {
                     this.qnz(var5, var6, var7 - 1, var8, var4 + var19);
                  }
               }
            }
         }
      }
   }

   private void qnz(int var1, int var2, int var3, int var4, float var5) {
      if (var5 != Float.POSITIVE_INFINITY && this.inside(var2, var3, var4) && this.inside(var2, var3 + 1, var4)) {
         for (Vec3d var7 : this.qno) {
            double var8 = var2 + 0.5 - var7.field_1352;
            double var10 = var4 + 0.5 - var7.field_1350;
            double var12 = var3 - var7.field_1351;
            if (var8 * var8 + var10 * var10 < 4.0 && Math.abs(var12) < 2.5) {
               var5 += 25.0F;
               break;
            }
         }

         int var14 = this.index(var2, var3, var4);
         if (var5 < this.qnh[var14]) {
            this.qnh[var14] = var5;
            this.qni[var14] = var1;
            this.qnn.push(var5, var14);
         }
      }
   }

   public long targetKey(int var1) {
      int var2 = this.qnj[var1];
      return BlockPos.method_10064(this.wx(var2), this.wy(var2), this.wz(var2));
   }

   public qmx best(Vec3d var1, Vec3d var2, LongSet var3) {
      return this.best(var1, var2, var3, null);
   }

   public qmx best(Vec3d var1, Vec3d var2, LongSet var3, LongSet var4) {
      double[] var5 = new double[this.qnl];
      ArrayList var6 = new ArrayList();

      for (int var7 = 0; var7 < this.qnl; var7++) {
         int var8 = this.qnj[var7];
         if (var4 == null || var4.contains(BlockPos.method_10064(this.wx(var8), this.wy(var8), this.wz(var8)))) {
            double var9 = this.wx(var8) + 0.5 - var1.field_1352;
            double var11 = this.wy(var8) + 0.5 - var1.field_1351;
            double var13 = this.wz(var8) + 0.5 - var1.field_1350;
            var5[var7] = var9 * var9 + var11 * var11 + var13 * var13;
            var6.add(var7);
         }
      }

      Integer[] var49 = var6.toArray(new Integer[0]);
      Arrays.sort(var49, (var1x, var2x) -> Double.compare(var5[var1x], var5[var2x]));
      int var50 = Math.min(var49.length, 160);
      float var51 = Float.POSITIVE_INFINITY;
      int var10 = -1;
      int var52 = -1;
      float var12 = Float.POSITIVE_INFINITY;

      for (int var53 = 0; var53 < var50; var53++) {
         int var14 = this.qnj[var49[var53]];
         float var15 = this.qnk[var49[var53]];
         int var16 = this.wx(var14);
         int var17 = this.wy(var14);
         int var18 = this.wz(var14);
         if (!var3.contains(BlockPos.method_10064(var16, var17, var18))) {
            double var19 = var16 + 0.5 - var1.field_1352;
            double var21 = var17 + 0.5 - var1.field_1351;
            double var23 = var18 + 0.5 - var1.field_1350;
            double var25 = Math.sqrt(var19 * var19 + var21 * var21 + var23 * var23);
            double var27 = var25 < 0.001 ? 1.0 : (var19 * var2.field_1352 + var21 * var2.field_1351 + var23 * var2.field_1350) / var25;
            var15 -= (float)(Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, var27)))) / this.qnr);
            if (this.qns > 0.0F) {
               var15 += this.qns * this.qoa(var16, var17, var18);
            }

            float var29 = this.qng[var14] + this.qnq;

            for (int var30 = var17 - 5; var30 <= var17 + 3; var30++) {
               for (int var31 = var16 - 4; var31 <= var16 + 4; var31++) {
                  for (int var32 = var18 - 4; var32 <= var18 + 4; var32++) {
                     if (this.inside(var31, var30, var32)) {
                        float var33 = this.qnh[this.index(var31, var30, var32)];
                        if (var33 != Float.POSITIVE_INFINITY && !(var33 + var29 - var15 >= var51)) {
                           double var34 = var31 + 0.5;
                           double var36 = var30 + 1.62;
                           double var38 = var32 + 0.5;
                           double var40 = var16 + 0.5 - var34;
                           double var42 = var17 + 0.5 - var36;
                           double var44 = var18 + 0.5 - var38;
                           if (!(var40 * var40 + var42 * var42 + var44 * var44 > 17.64)) {
                              float var46 = this.rayCost(var34, var36, var38, var16, var17, var18);
                              if (var46 != Float.POSITIVE_INFINITY) {
                                 float var47 = var33 + var29 + var46;
                                 float var48 = var47 - var15;
                                 if (var48 < var51) {
                                    var51 = var48;
                                    var12 = var47;
                                    var10 = var14;
                                    var52 = this.index(var31, var30, var32);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var10 < 0 ? null : new qmx(new BlockPos(this.wx(var10), this.wy(var10), this.wz(var10)), this.qob(var52), var12);
   }

   float rayCost(double var1, double var3, double var5, int var7, int var8, int var9) {
      double var10 = var7 + 0.5;
      double var12 = var8 + 0.5;
      double var14 = var9 + 0.5;
      double var16 = var10 - var1;
      double var18 = var12 - var3;
      double var20 = var14 - var5;
      int var22 = (int)Math.floor(var1);
      int var23 = (int)Math.floor(var3);
      int var24 = (int)Math.floor(var5);
      int var25 = var16 > 0.0 ? 1 : -1;
      int var26 = var18 > 0.0 ? 1 : -1;
      int var27 = var20 > 0.0 ? 1 : -1;
      double var28 = var16 != 0.0 ? (var16 > 0.0 ? var22 + 1 - var1 : var1 - var22) / Math.abs(var16) : Double.MAX_VALUE;
      double var30 = var18 != 0.0 ? (var18 > 0.0 ? var23 + 1 - var3 : var3 - var23) / Math.abs(var18) : Double.MAX_VALUE;
      double var32 = var20 != 0.0 ? (var20 > 0.0 ? var24 + 1 - var5 : var5 - var24) / Math.abs(var20) : Double.MAX_VALUE;
      double var34 = var16 != 0.0 ? 1.0 / Math.abs(var16) : Double.MAX_VALUE;
      double var36 = var18 != 0.0 ? 1.0 / Math.abs(var18) : Double.MAX_VALUE;
      double var38 = var20 != 0.0 ? 1.0 / Math.abs(var20) : Double.MAX_VALUE;
      float var40 = 0.0F;

      for (int var41 = 0; var41 < 24; var41++) {
         if (var28 < var30 && var28 < var32) {
            var22 += var25;
            var28 += var34;
         } else if (var30 < var32) {
            var23 += var26;
            var30 += var36;
         } else {
            var24 += var27;
            var32 += var38;
         }

         if (var22 == var7 && var23 == var8 && var24 == var9) {
            return var40;
         }

         int var42 = this.flags(var22, var23, var24);
         if ((var42 & 1) == 0) {
            if ((var42 & 8) == 0 || (var42 & 48) != 0) {
               return Float.POSITIVE_INFINITY;
            }

            var40 += this.ticks(var22, var23, var24) + this.qnq;
         }
      }

      return Float.POSITIVE_INFINITY;
   }

   private int qoa(int var1, int var2, int var3) {
      int var4 = 0;

      for (int var5 = -1; var5 <= 1; var5++) {
         for (int var6 = -1; var6 <= 1; var6++) {
            for (int var7 = -1; var7 <= 1; var7++) {
               if ((var5 != 0 || var6 != 0 || var7 != 0) && (this.flags(var1 + var5, var2 + var6, var3 + var7) & 64) != 0) {
                  var4++;
               }
            }
         }
      }

      return var4;
   }

   public List<BlockPos> targetsNear(Vec3d var1, double var2) {
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < this.qnl; var5++) {
         int var6 = this.qnj[var5];
         double var7 = this.wx(var6) + 0.5 - var1.field_1352;
         double var9 = this.wy(var6) + 0.5 - var1.field_1351;
         double var11 = this.wz(var6) + 0.5 - var1.field_1350;
         if (var7 * var7 + var9 * var9 + var11 * var11 <= var2 * var2) {
            var4.add(new BlockPos(this.wx(var6), this.wy(var6), this.wz(var6)));
         }
      }

      return var4;
   }

   private int[] qob(int var1) {
      ArrayList var2 = new ArrayList();
      int var3 = var1;

      while (var3 >= 0 && var2.size() < 4096) {
         var2.add(var3);
         var3 = this.qni[var3];
      }

      int[] var6 = new int[var2.size() * 3];

      for (int var4 = 0; var4 < var2.size(); var4++) {
         int var5 = (Integer)var2.get(var2.size() - 1 - var4);
         var6[var4 * 3] = this.wx(var5);
         var6[var4 * 3 + 1] = this.wy(var5);
         var6[var4 * 3 + 2] = this.wz(var5);
      }

      return var6;
   }

   public qmx toward(BlockPos var1, int var2) {
      int var3 = -1;
      double var4 = Double.MAX_VALUE;

      for (int var6 = var1.method_10264() - var2; var6 <= var1.method_10264() + var2; var6++) {
         for (int var7 = var1.method_10263() - var2; var7 <= var1.method_10263() + var2; var7++) {
            for (int var8 = var1.method_10260() - var2; var8 <= var1.method_10260() + var2; var8++) {
               if (this.inside(var7, var6, var8)) {
                  int var9 = this.index(var7, var6, var8);
                  if (this.qnh[var9] != Float.POSITIVE_INFINITY) {
                     double var10 = var7 - var1.method_10263();
                     double var12 = var6 - var1.method_10264();
                     double var14 = var8 - var1.method_10260();
                     double var16 = (var10 * var10 + var12 * var12 * 2.0 + var14 * var14) * 40.0 + this.qnh[var9];
                     if (var16 < var4) {
                        var4 = var16;
                        var3 = var9;
                     }
                  }
               }
            }
         }
      }

      return var3 < 0 ? null : new qmx(var1, this.qob(var3), this.qnh[var3]);
   }

   public float distTo(int var1, int var2, int var3) {
      return this.inside(var1, var2, var3) ? this.qnh[this.index(var1, var2, var3)] : Float.POSITIVE_INFINITY;
   }

   public static float value(BlockState var0) {
      String var1 = Registries.field_41175.method_10221(var0.method_26204()).method_12832();
      if (var1.contains(a.d("솤렘㋃겾❫ꇛᮂ", 1057647661, -675303958))
         || var1.contains(a.b("雷胰ਫ鑍ᾉ餵⍮", 2106325291))
         || var1.contains(a.c(1450707397, "প瀔響撱\uef6a槐펙婃쐧亗쥃㌢뷮⑅"))) {
         return 30.0F;
      } else if (var1.contains(a.b("櫿ፆ首߯", -1309513060))) {
         return 12.0F;
      } else {
         return !var1.contains(a.c(-791654866, "乇㟻봹⍑ꢜ"))
               && !var1.contains(a.b("襡\uf0c7稕\ue473澣\ue909卛\udaa1", -388921061))
               && !var1.contains(a.c(1422084270, "䣃ㅩ뮧◗"))
            ? 0.0F
            : 4.0F;
      }
   }
}
