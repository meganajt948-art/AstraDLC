package a;

import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class lkh {
   private static final MinecraftClient lki = MinecraftClient.getInstance();
   private static final double lkj = 33.5;
   private static final double lkk = 15.0;
   private static final double lkl = 0.021321961620469083;
   private static final double lkm = 0.8;
   private static final double lkn = 1.25;
   private static final int lko = 24;
   private static final double lkp = 1.5;
   private static final int lkq = 12;
   private static final int lkr = 2;
   private static final double lks = 0.4;
   private static final long lkt = 50L;
   private final ljx lku;
   private final lka lkv = new lka();
   private final float[] lkw = new float[16];
   private final float[] lkx = new float[16];
   private double lky;
   private long lkz;
   private double lla;
   private double llb;
   private float llc;
   private float lld;
   private int lle = -1;

   public lkh(ljx var1) {
      this.lku = var1;
   }

   public String debug() {
      return String.format(Locale.ROOT, a.b("㗙䱹욿墒퍝喭\uefba昙\uf855狱\uf533༚臕ᡯ鈠ᒅ꺌ℐ뮧㷬됛츄䂯\udb75崕힓", 533607846), this.lle, this.lla, this.llb);
   }

   public float yaw() {
      return this.llc;
   }

   public float pitch() {
      return this.lld;
   }

   public boolean rotate(float var1, float var2) {
      if (lki.player != null && this.lku.target != null) {
         double var3 = 1.0;
         if (this.lku.attackReady) {
            var3 = 0.5;
         }

         float var5 = MathHelper.wrapDegrees(this.lku.yawToTarget - var1);
         float var6 = MathHelper.clamp(this.lku.pitchToTarget - var2, -90.0F, 90.0F);
         var5 += Math.signum(var5) * 25.0F;
         double var7 = this.llh(var1, var2, var3);
         float var9 = (float)(Math.sin(var7) * 33.5 * var3 + var5 * 0.2);
         float var10 = (float)(Math.cos(var7) * 15.0 * var3 + var6 * 0.1);
         this.llc = var1 + this.lkv.fix(var9, true);
         this.lld = MathHelper.clamp(var2 + this.lkv.fix(var10, false), -90.0F, 90.0F);
         return true;
      } else {
         return false;
      }
   }

   private double llh(float var1, float var2, double var3) {
      if (this.lkz == 0L) {
         this.lkz = System.currentTimeMillis();
         this.lky = this.lkz * 0.021321961620469083;
         return this.lky;
      }

      double var5 = 1.0660980810234542;
      int var7 = this.llk();
      this.lle = var7;
      this.lll(Math.min(var7 + 2, 15));
      double var8 = this.llm(true);
      double var10 = this.llm(false);
      this.lli(var5, var1, var2, var3, var7, var7, var8, var10);
      if (this.llb > 0.0) {
         this.lli(var5, var1, var2, var3, var7, var7 + 2, var8, var10);
      }

      this.lky = this.lky + var5 * this.lla;
      return this.lky;
   }

   private void lli(double var1, float var3, float var4, double var5, int var7, int var8, double var9, double var11) {
      double var13 = 1.0;
      double var15 = Double.MAX_VALUE;
      double var17 = Double.MAX_VALUE;

      for (int var19 = 0; var19 <= 24; var19++) {
         double var20 = 0.8 + 0.44999999999999996 * var19 / 24.0;
         double var22 = this.llj(var1 * var20, var3, var4, var5, var7, var8, var9, var11);
         double var24 = var22 + Math.abs(var20 - 1.0) * 1.5;
         if (var24 < var15) {
            var15 = var24;
            var13 = var20;
            var17 = var22;
         }
      }

      this.lla = var13;
      this.llb = var17;
   }

   private double llj(double var1, float var3, float var4, double var5, int var7, int var8, double var9, double var11) {
      double var13 = this.lky;
      float var15 = var3;
      float var16 = var4;
      double var17 = Double.MAX_VALUE;

      for (int var19 = 0; var19 <= var8; var19++) {
         var13 += var1;
         double var20 = var19 >= var7 ? Math.min(var5, 0.5) : var5;
         float var22 = MathHelper.wrapDegrees(this.lkw[var19] - var15);
         float var23 = MathHelper.clamp(this.lkx[var19] - var16, -90.0F, 90.0F);
         var15 += (float)(Math.sin(var13) * 33.5 * var20 + (var22 + Math.signum(var22) * 25.0F) * 0.2);
         var16 = MathHelper.clamp(var16 + (float)(Math.cos(var13) * 15.0 * var20 + var23 * 0.1), -90.0F, 90.0F);
         if (var19 >= var7) {
            double var24 = Math.max(0.0, Math.abs(MathHelper.wrapDegrees(this.lkw[var19] - var15)) - var9);
            double var26 = Math.max(0.0, Math.abs(this.lkx[var19] - var16) - var11);
            var17 = Math.min(var17, var24 + var26);
         }
      }

      return var17;
   }

   private int llk() {
      return MathHelper.clamp(this.lku.strikeIn, 0, 12);
   }

   private void lll(int var1) {
      this.lkw[0] = this.lku.yawToTarget;
      this.lkx[0] = this.lku.pitchToTarget;

      for (int var2 = 1; var2 <= var1; var2++) {
         Vec3d var3 = this.lku.eyeAt[var2];
         Vec3d var4 = this.lku.targetAt[var2];
         if (var3 != null && var4 != null) {
            double var5 = var4.x - var3.x;
            double var7 = var4.y - var3.y;
            double var9 = var4.z - var3.z;
            this.lkw[var2] = (float)(Math.toDegrees(Math.atan2(var9, var5)) - 90.0);
            this.lkx[var2] = (float)(-Math.toDegrees(Math.atan2(var7, Math.hypot(var5, var9))));
         } else {
            this.lkw[var2] = this.lkw[var2 - 1];
            this.lkx[var2] = this.lkx[var2 - 1];
         }
      }
   }

   private double llm(boolean var1) {
      Box var2 = this.lku.box;
      double var3 = var1 ? Math.min(var2.getLengthX(), var2.getLengthZ()) : var2.getLengthY();
      Vec3d var5 = lki.player.getEyePos();
      Vec3d var6 = var2.getCenter();
      double var7 = Math.max(0.05, Math.hypot(var6.x - var5.x, var6.z - var5.z));
      return Math.toDegrees(Math.atan2(var3 * 0.4, var7));
   }

   public void enabled() {
      this.lkv.reset();
      this.lkz = 0L;
   }

   public void targetNull() {
      this.lkv.reset();
      this.lkz = 0L;
   }
}
