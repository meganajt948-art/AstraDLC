package a;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;

public class rby extends kfe {
   private static rby rbz;
   private final vlv rca = this.add(new vlv("Mode", "Box", "Box", "Corners", "Face"));
   private final vla rcb = this.add(new vla("Color", "Theme"));
   private final vmc rcc = this.add(new vmc("Width", 1.2, 0.5, 3.0, 0.1));
   private final vmc rcd = this.add(new vmc("Corner size", 0.25, 0.1, 0.5, 0.01).percent());
   private final vmc rce = this.add(new vmc("Fill", 0.12, 0.0, 0.5, 0.01).percent());
   private final vmc rcf = this.add(new vmc("Glow", 0.5, 0.0, 1.0, 0.05).percent());
   private final vkl rcg = this.add(new vkl("Smooth", true));
   private final double[] rch = new double[6];
   private boolean rci;
   private Direction rcj = Direction.UP;
   private final vcj rck = new vcj(14.0F);
   private long rcl = -1L;
   private final double[][] rcm = new double[8][3];
   private final float[] rcn = new float[4];
   private final float[] rco = new float[3];
   private final float[][] rcp = new float[8][3];
   private final boolean[] rcq = new boolean[8];
   private final boolean[] rcr = new boolean[6];
   private static final int[][] rcs = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
   private static final Direction[] rct = new Direction[]{Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
   private static final int[][] rcu = new int[][]{
      {0, 1, 0, 2},
      {2, 3, 1, 2},
      {4, 5, 0, 3},
      {6, 7, 1, 3},
      {0, 2, 2, 4},
      {1, 3, 2, 5},
      {4, 6, 3, 4},
      {5, 7, 3, 5},
      {0, 4, 0, 4},
      {1, 5, 0, 5},
      {2, 6, 1, 4},
      {3, 7, 1, 5}
   };

   public rby() {
      super(new String(new char[]{'B', 'l', 'o', 'c', 'k', 'O', 'u', 't', 'l', 'i', 'n', 'e'}), "A clean outline on the block you aim at", kfa.RENDER);
      rbz = this;
      this.rcd.visibleWhen(() -> this.rca.is("Corners"));
   }

   public static boolean vanilla() {
      return rbz == null || !rbz.isEnabled();
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rby var2 = rbz;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null && var2.isEnabled() && var3.world != null && var3.player != null && !var3.options.hudHidden && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.rcl) {
            var2.rcl = unf.frame();
            var2.rcx(var0, var3, var1.getTickProgress(true), unf.delta());
         }
      } else {
         if (var2 != null) {
            var2.rci = false;
            var2.rck.set(0.0F);
         }
      }
   }

   private void rcx(DrawContext var1, MinecraftClient var2, float var3, float var4) {
      Box var5 = null;
      if (var2.crosshairTarget instanceof BlockHitResult var6 && var6.getType() == Type.BLOCK) {
         BlockPos var15 = var6.getBlockPos();
         BlockState var8 = var2.world.getBlockState(var15);
         if (!var8.isAir() && var2.world.getWorldBorder().contains(var15)) {
            VoxelShape var9 = var8.getOutlineShape(var2.world, var15, ShapeContext.of(var2.getCameraEntity()));
            if (!var9.isEmpty()) {
               var5 = var9.getBoundingBox().offset(var15);
               this.rcj = var6.getSide();
            }
         }
      }

      float var14 = this.rck.step(var5 != null, var4);
      if (var5 != null) {
         if (this.rci && this.rcg.get() && !(var14 < 0.05F)) {
            double var16 = 1.0 - Math.exp(-var4 * 26.0);
            this.rch[0] = this.rch[0] + (var5.minX - this.rch[0]) * var16;
            this.rch[1] = this.rch[1] + (var5.minY - this.rch[1]) * var16;
            this.rch[2] = this.rch[2] + (var5.minZ - this.rch[2]) * var16;
            this.rch[3] = this.rch[3] + (var5.maxX - this.rch[3]) * var16;
            this.rch[4] = this.rch[4] + (var5.maxY - this.rch[4]) * var16;
            this.rch[5] = this.rch[5] + (var5.maxZ - this.rch[5]) * var16;
         } else {
            this.rdb(var5);
         }

         this.rci = true;
      }

      if (this.rci && !(var14 <= 0.01F)) {
         usn var17;
         try {
            var17 = usn.capture(var3, var1.getScaledWindowWidth(), var1.getScaledWindowHeight());
         } catch (Throwable var13) {
            return;
         }

         double var18 = 0.002;

         for (int var10 = 0; var10 < 8; var10++) {
            this.rcm[var10][0] = (var10 & 1) == 0 ? this.rch[0] - var18 : this.rch[3] + var18;
            this.rcm[var10][1] = (var10 & 2) == 0 ? this.rch[1] - var18 : this.rch[4] + var18;
            this.rcm[var10][2] = (var10 & 4) == 0 ? this.rch[2] - var18 : this.rch[5] + var18;
            this.rcq[var10] = var17.depth(this.rcm[var10][0], this.rcm[var10][1], this.rcm[var10][2]) > 0.05F
               && var17.project3(this.rcm[var10][0], this.rcm[var10][1], this.rcm[var10][2], this.rcp[var10]);
         }

         Vec3d var19 = var17.camera();

         for (int var11 = 0; var11 < 6; var11++) {
            this.rcr[var11] = this.rdc(var11, var19);
         }

         boolean var20 = this.rca.is("Face");
         int var12 = this.rcb.color() | 0xFF000000;
         uut.beginFrame();
         uut.pushAlpha(var14);
         this.rcy(var1, var12, var20);
         this.rcz(var1, var17, var12, var20);
         uut.popAlpha();
      } else {
         this.rci = this.rci && var14 > 0.01F;
      }
   }

   private void rcy(DrawContext var1, int var2, boolean var3) {
      float var4 = (float)this.rce.get();
      if (!(var4 <= 0.005F)) {
         for (int var5 = 0; var5 < 6; var5++) {
            if (this.rcr[var5] && (!var3 || rct[var5] == this.rcj)) {
               int[] var6 = rcs[var5];
               if (this.rcq[var6[0]] && this.rcq[var6[1]] && this.rcq[var6[2]] && this.rcq[var6[3]]) {
                  int var7 = ujt.withAlpha(var2, Math.round(255.0F * var4 * (rct[var5] == this.rcj ? 1.0F : 0.55F)));
                  uut.quad(
                     var1,
                     this.rcp[var6[0]][0],
                     this.rcp[var6[0]][1],
                     var7,
                     this.rcp[var6[1]][0],
                     this.rcp[var6[1]][1],
                     var7,
                     this.rcp[var6[2]][0],
                     this.rcp[var6[2]][1],
                     var7,
                     this.rcp[var6[3]][0],
                     this.rcp[var6[3]][1],
                     var7
                  );
               }
            }
         }
      }
   }

   private void rcz(DrawContext var1, usn var2, int var3, boolean var4) {
      float var5 = (float)this.rcc.get();
      float var6 = (float)this.rcf.get();
      int var7 = ujt.withAlpha(var3, 225);
      int var8 = ujt.withAlpha(var3, Math.round(110.0F * var6));
      boolean var9 = this.rca.is("Corners");
      double var10 = this.rcd.get();

      for (int[] var15 : rcu) {
         boolean var16 = var4
            ? (rct[var15[2]] == this.rcj || rct[var15[3]] == this.rcj) && (this.rcr[var15[2]] || this.rcr[var15[3]])
            : this.rcr[var15[2]] || this.rcr[var15[3]];
         if (var16) {
            double[] var17 = this.rcm[var15[0]];
            double[] var18 = this.rcm[var15[1]];
            if (var9) {
               this.rda(var1, var2, var17, var18, 0.0, var10, var5, var7, var8, var6);
               this.rda(var1, var2, var17, var18, 1.0 - var10, 1.0, var5, var7, var8, var6);
            } else {
               this.rda(var1, var2, var17, var18, 0.0, 1.0, var5, var7, var8, var6);
            }
         }
      }
   }

   private void rda(DrawContext var1, usn var2, double[] var3, double[] var4, double var5, double var7, float var9, int var10, int var11, float var12) {
      double var13 = var3[0] + (var4[0] - var3[0]) * var5;
      double var15 = var3[1] + (var4[1] - var3[1]) * var5;
      double var17 = var3[2] + (var4[2] - var3[2]) * var5;
      double var19 = var3[0] + (var4[0] - var3[0]) * var7;
      double var21 = var3[1] + (var4[1] - var3[1]) * var7;
      double var23 = var3[2] + (var4[2] - var3[2]) * var7;
      if (var2.projectSegment(var13, var15, var17, var19, var21, var23, 0.05F, this.rcn, this.rco)) {
         if (var12 > 0.02F) {
            uut.additive(true);
            uut.softLine(var1, this.rcn[0], this.rcn[1], this.rcn[2], this.rcn[3], var9, 2.5F + 3.5F * var12, var11);
            uut.additive(false);
         }

         uut.line(var1, this.rcn[0], this.rcn[1], this.rcn[2], this.rcn[3], var9, var10);
      }
   }

   private void rdb(Box var1) {
      this.rch[0] = var1.minX;
      this.rch[1] = var1.minY;
      this.rch[2] = var1.minZ;
      this.rch[3] = var1.maxX;
      this.rch[4] = var1.maxY;
      this.rch[5] = var1.maxZ;
   }

   private boolean rdc(int var1, Vec3d var2) {
      return switch (var1) {
         case 0 -> var2.y < this.rch[1];
         case 1 -> var2.y > this.rch[4];
         case 2 -> var2.z < this.rch[2];
         case 3 -> var2.z > this.rch[5];
         case 4 -> var2.x < this.rch[0];
         default -> var2.x > this.rch[3];
      };
   }
}
