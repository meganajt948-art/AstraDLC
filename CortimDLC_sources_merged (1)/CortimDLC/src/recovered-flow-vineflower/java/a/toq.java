package a;

import java.util.Arrays;
import java.util.Random;
import java.util.function.LongPredicate;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class toq {
   private static final double tor = 0.6;
   private static final double tos = 0.12;
   private static final double tot = 0.0016666666666666668;
   public final ttb model;
   private final Random tou = new Random();
   private final float[] tov = new float[3];
   private final float[] tow = new float[3];
   private final int[] tox = new int[2];
   private final int[] toy = new int[2];
   private final double[] toz = new double[71];
   private final double[] tpa = new double[11];
   private int tpb;
   private tvn tpc;
   private tvn tpd;
   private double tpe;
   private int tpf = 0;
   private boolean tpg;
   private boolean tph;
   public long farmed;
   public long farmedDia;
   private long tpi;
   private double tpj;
   private double tpk = -1.0;

   public toq(ttb var1) {
      this.model = var1;
   }

   public void boost(double var1) {
      this.tpe = Math.max(0.0, Math.min(0.3, var1));
   }

   public double turnRate() {
      return Math.max(8.0, this.model.style.turnRate * (1.0 + this.tpe));
   }

   public void reset() {
      this.tpb = 0;
      this.tpd = null;
      this.tpc = null;
      this.tpf = 0;
   }

   public void tick(World var1, ClientPlayerEntity var2, pzc var3) {
      this.tov[2] = this.tov[1];
      this.tov[1] = this.tov[0];
      this.tov[0] = var2.getYaw();
      this.tow[2] = this.tow[1];
      this.tow[1] = this.tow[0];
      this.tow[0] = var2.getPitch();
      this.tpb++;
      this.tpc = tsh.snap(var1, var2, var2.getBlockPos(), var3, null, null);
      Vec3d var4 = var2.getEyePos();
      trd.diff(this.tpd, this.tpc, var4.x, var4.y, var4.z, this.tox);
      this.farmed = this.farmed + this.tox[0];
      this.farmedDia = this.farmedDia + this.tox[1];
      trd.reach(this.tpc, var4.x, var4.y, var4.z, this.toy);
      if (this.toy[0] >= 8) {
         double var5 = trd.value(this.tox[0], this.tox[1]);
         this.tpi++;
         this.tpj += var5;
         if (this.tpi < 400L) {
            this.tpk = this.tpj / this.tpi * 1200.0;
         } else {
            this.tpk = this.tpk + (var5 * 1200.0 - this.tpk) * 0.0016666666666666668;
         }
      }

      this.tpd = this.tpc;
   }

   public double rate() {
      return this.tpi < 100L ? -1.0 : this.tpk;
   }

   public double ratio() {
      double var1 = this.rate();
      double var3 = this.model.style.activeRate;
      return !(var1 < 0.0) && !(var3 <= 0.0) ? var1 / var3 : Double.NaN;
   }

   public boolean hasLegs() {
      return this.model.legs != null;
   }

   public void planLegs(World var1, ClientPlayerEntity var2, BlockPos var3) {
      if (this.model.legs != null && this.tpc != null) {
         trg var4 = new trg();
         var4.px = var2.getX();
         var4.py = var2.getY();
         var4.pz = var2.getZ();
         var4.eyeY = var2.getEyeY();
         var4.yaw = var2.getYaw();
         var4.pitch = var2.getPitch();
         var4.vx = var2.getX() - var2.lastX;
         var4.vy = var2.getY() - var2.lastY;
         var4.vz = var2.getZ() - var2.lastZ;
         var4.ground = var2.isOnGround();
         var4.feetY = tsh.standing(var1, var2).getY();
         if (var3 != null) {
            var4.hasTarget = true;
            var4.tx = var3.getX();
            var4.ty = var3.getY();
            var4.tz = var3.getZ();
         }

         trj.features(this.tpc, var4, this.toz, 0);
         this.model.legs.decide(this.toz, this.tpa);
         int var5 = 0;

         for (int var6 = 1; var6 < 9; var6++) {
            if (this.tpa[var6] > this.tpa[var5]) {
               var5 = var6;
            }
         }

         if (var5 != this.tpf && this.tpa[var5] < this.tpa[this.tpf] + 0.12) {
            var5 = this.tpf;
         }

         this.tpf = var5;
         this.tpg = this.tpa[9] > 0.5;
         this.tph = this.tpa[10] > 0.5;
      } else {
         this.tpf = 0;
         this.tpg = false;
         this.tph = false;
      }
   }

   public void stopLegs() {
      this.tpf = 0;
      this.tpg = false;
      this.tph = false;
   }

   public int move() {
      return this.tpf;
   }

   public boolean jump() {
      return this.tpg;
   }

   public boolean sprint() {
      return this.tph;
   }

   public long[] rank(World var1, ClientPlayerEntity var2, pzc var3, LongPredicate var4, LongPredicate var5, BlockPos var6, int var7) {
      tvn var8 = tsh.snap(var1, var2, var2.getBlockPos(), var3, var4, var5);
      tra var9 = new tra();
      Vec3d var10 = var2.getEyePos();
      var9.ex = var10.x;
      var9.ey = var10.y;
      var9.ez = var10.z;
      var9.yaw = var2.getYaw();
      var9.pitch = var2.getPitch();
      if (this.tpb >= 3) {
         var9.vyaw = (float)(tbp.wrap(this.tov[0] - this.tov[2]) * 0.5);
         var9.vpitch = (this.tow[0] - this.tow[2]) * 0.5F;
      } else if (this.tpb == 2) {
         var9.vyaw = (float)tbp.wrap(this.tov[0] - this.tov[1]);
         var9.vpitch = this.tow[0] - this.tow[1];
      }

      var9.vx = var2.getX() - var2.lastX;
      var9.vz = var2.getZ() - var2.lastZ;
      var9.ground = var2.isOnGround();
      var9.feetY = tsh.standing(var1, var2).getY();
      if (var6 != null) {
         var9.hasPrev = true;
         var9.px = var6.getX();
         var9.py = var6.getY();
         var9.pz = var6.getZ();
      }

      tpn var11 = tpn.of(var8, var9);
      int var12 = var11.n;
      if (var12 == 0) {
         return new long[0];
      }

      double[] var13 = this.model.brain.scores(var11);
      double var14 = 0.6 - this.tpe;
      double var16 = this.tpe * 3.0;

      for (int var18 = 0; var18 < var12; var18++) {
         int var19 = var18 * 32;
         double var20 = (var11.f[var19 + 16] * 8.0 + 4.0 * var11.f[var19 + 17] * 3.0 + 6.0 * var11.f[var19 + 11]) / 10.0;
         var13[var18] = var13[var18] / var14 + var16 * var20;
      }

      double var32 = Double.NEGATIVE_INFINITY;

      for (double var23 : var13) {
         var32 = Math.max(var32, var23);
      }

      double[] var34 = new double[var12];
      double var35 = 0.0;

      for (int var36 = 0; var36 < var12; var36++) {
         var34[var36] = Math.exp(var13[var36] - var32);
         var35 += var34[var36];
      }

      double var37 = this.tou.nextDouble() * var35;
      int var25 = var12 - 1;

      for (int var26 = 0; var26 < var12; var26++) {
         var37 -= var34[var26];
         if (var37 <= 0.0) {
            var25 = var26;
            break;
         }
      }

      Integer[] var38 = new Integer[var12];

      for (int var27 = 0; var27 < var12; var27++) {
         var38[var27] = var27;
      }

      Arrays.sort(var38, (var1x, var2x) -> Double.compare(var13[var2x], var13[var1x]));
      int var39 = Math.min(var7, var12);
      long[] var28 = new long[var39];
      var28[0] = BlockPos.asLong(var11.x[var25], var11.y[var25], var11.z[var25]);
      int var29 = 1;

      for (int var30 = 0; var30 < var12 && var29 < var39; var30++) {
         int var31 = var38[var30];
         if (var31 != var25) {
            var28[var29++] = BlockPos.asLong(var11.x[var31], var11.y[var31], var11.z[var31]);
         }
      }

      return var28;
   }
}
