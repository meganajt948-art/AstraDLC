package a;

import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class tel {
   static final double tem = 3.0;
   static final double ten = 8.0;
   static final double teo = 4.0;
   final Random tep = new Random();
   final taf teq = new taf();
   final double[] ter = new double[32];
   final double[] tes = new double[2];
   final tbm tet = new tbm();
   tck teu;
   tai tev;
   double tew = Double.NaN;
   double tex = Double.NaN;
   Object tey;
   boolean tez;
   boolean tfa;
   boolean tfb;
   double tfc = 0.5;
   double tfd;
   double tfe;
   double tff;
   double tfg;
   double tfh;
   double tfi = 0.5;
   double tfj = 1.0;
   double tfk;
   double tfl;
   double tfm = 3.0;
   double tfn = 8.0;
   double tfo;
   double tfp;
   double tfq;
   double tfr;
   double tfs;
   double tft;
   int tfu;
   int tfv;
   int tfw;
   int tfx = -1;
   double tfy = 1.0;
   boolean tfz;
   boolean tga;
   double tgb;
   double tgc;
   double tgd;
   double tge;
   double tgf;
   double tgg;
   double tgh;
   double tgi;
   final double[] tgj = new double[8];
   double tgk;
   double tgl;
   double tgm;
   double tgn;
   int tgo;
   int tgp;
   boolean tgq;
   float tgr;
   float tgs;
   double tgt;
   double tgu;
   double tgv;
   double tgw;
   boolean tgx;
   boolean tgy;
   boolean tgz;
   double tha;
   double thb;
   double thc;
   double thd;
   double the;
   double thf;
   double thg;
   double thh;
   boolean thi;
   float thj;
   float thk;
   double thl;
   double thm;
   long thn;
   double tho = 0.3;
   double thp;
   long thq;

   public void use(tck var1) {
      if (var1 != this.teu) {
         this.teu = var1;
         this.tev = var1 == null ? null : new tai(var1, this.tep);
         this.reset();
      }
   }

   public boolean ready() {
      return this.tev != null;
   }

   public Entity target() {
      return this.tey instanceof Entity var1 ? var1 : null;
   }

   public void tune(double var1, double var3, double var5) {
      this.teq.speed = var1;
      this.teq.texture = var3;
      this.teq.vertical = var5;
   }

   public void height(double var1, double var3) {
      this.tew = Math.min(var1, var3);
      this.tex = Math.max(var1, var3);
   }

   public void verticalAware(boolean var1) {
      this.tgy = var1;
   }

   public boolean aiming() {
      return this.tgz || System.currentTimeMillis() < this.thq;
   }

   public void reset() {
      this.drop();
      this.tgq = false;
      this.thi = false;
      this.thg = this.thh = 0.0;
      this.thl = this.thm = 0.0;
      this.tgv = this.tgw = 0.0;
      this.tgp = 0;
      if (this.tev != null) {
         this.tev.reset();
      }
   }

   public void drop() {
      this.tey = null;
      this.tgz = false;
      this.tga = false;
   }

   public void tick(MinecraftClient var1, ClientPlayerEntity var2, Entity var3, int var4, boolean var5) {
      this.tht(var1, var2, var3, var4, var5);
   }

   public void assist(MinecraftClient var1, ClientPlayerEntity var2, Entity var3, int var4) {
      this.tht(var1, var2, var3, var4, false);
   }

   public double lastPlan() {
      return this.thp;
   }

   public void cap(double var1) {
      this.tfd = var1;
   }

   public void reactionScale(double var1) {
      this.tfj = Math.max(0.0, var1);
   }

   public void newTick() {
      this.tfe = 0.0;
   }

   public double budgetLeft() {
      return this.tfd <= 0.0 ? Double.MAX_VALUE : Math.max(0.0, this.tfd - this.tfe);
   }

   public void spent(double var1) {
      this.tfe += var1;
   }

   public void pointSize(double var1) {
      this.tfc = var1;
   }

   public void assistAt(MinecraftClient var1, ClientPlayerEntity var2, Object var3, Vec3d var4, int var5) {
      if (var3 != null && var4 != null) {
         this.tfa = true;
         this.tff = 0.0;
         this.tfg = 0.5;
         this.tfb = true;

         try {
            double var6 = this.tfc;
            this.thu(var1, var2, var3, new Box(var4.x - var6, var4.y - var6, var4.z - var6, var4.x + var6, var4.y + var6, var4.z + var6), var5, false);
         } finally {
            this.tfa = false;
            this.tfb = false;
         }
      } else {
         this.thu(var1, var2, null, null, var5, false);
      }
   }

   public void assistBlock(MinecraftClient var1, ClientPlayerEntity var2, Object var3, Box var4, Vec3d var5, int var6) {
      if (var3 != null && var4 != null && var5 != null) {
         if (var3 != this.tey) {
            Vec3d var7 = var2.getEyePos();
            this.tfh = tbp.hitU(var7.x, var7.z, (var4.minX + var4.maxX) * 0.5, (var4.minZ + var4.maxZ) * 0.5, (var4.maxX - var4.minX) * 0.5, var5.x, var5.z);
            this.tfi = tbp.hitV(var4.minY, var4.maxY - var4.minY, var5.y);
         }

         this.tfa = true;
         this.tff = this.tfh;
         this.tfg = this.tfi;
         this.tfb = true;

         try {
            this.thu(var1, var2, var3, var4, var6, false);
         } finally {
            this.tfa = false;
            this.tfb = false;
         }
      } else {
         this.thu(var1, var2, null, null, var6, false);
      }
   }

   void tht(MinecraftClient var1, ClientPlayerEntity var2, Entity var3, int var4, boolean var5) {
      this.thu(var1, var2, var3, var3 == null ? null : var3.getBoundingBox(), var4, var5);
   }

   void thu(MinecraftClient var1, ClientPlayerEntity var2, Object var3, Box var4, int var5, boolean var6) {
      this.tgx = var6;
      float var7 = var2.getYaw();
      float var8 = var2.getPitch();
      this.thv(var7, var8);
      double var9 = this.thl;
      double var11 = this.thm;
      this.thl = this.thm = 0.0;
      this.tgz = false;
      if (this.thw(var2, var3, var4, var2.getEyePos(), var5, var6, var9, var11, var7, var8)) {
         double var13 = Math.hypot(this.tha, this.thb);
         if (this.tfd > 0.0 && var13 > this.tfd) {
            this.tha = this.tha * (this.tfd / var13);
            this.thb = this.thb * (this.tfd / var13);
         }

         this.thc = tig(this.tgt, this.tha);
         this.thd = tig(this.tgu, this.thb);
         this.the = this.thf = 0.0;
         this.tgz = Math.abs(this.tha) + Math.abs(this.thb) > 1.0E-6;
         if (this.tgz && this.tho > 0.95) {
            this.tii(var1, var2, this.tha, this.thb);
            this.the = this.tha;
            this.thf = this.thb;
            this.tgz = false;
            this.thj = var2.getYaw();
            this.thk = var2.getPitch();
         }
      }
   }

   public boolean steer(ClientPlayerEntity var1, Object var2, Box var3, Vec3d var4, int var5, float var6, float var7, double[] var8) {
      this.thv(var6, var7);
      this.tgz = false;
      if (!this.thw(var1, var2, var3, var4, var5, false, 0.0, 0.0, var6, var7)) {
         return false;
      }

      var8[0] = this.tha;
      var8[1] = this.thb;
      return true;
   }

   public boolean steerAt(
      ClientPlayerEntity var1, Object var2, Box var3, Vec3d var4, double var5, double var7, int var9, float var10, float var11, double[] var12
   ) {
      this.tfa = true;
      this.tff = var5;
      this.tfg = var7;

      try {
         return this.steer(var1, var2, var3, var4, var9, var10, var11, var12);
      } finally {
         this.tfa = false;
      }
   }

   public boolean steerTo(ClientPlayerEntity var1, Object var2, double var3, double var5, int var7, float var8, float var9, double[] var10) {
      this.tfk = var3;
      this.tfl = var5;
      return this.steer(var1, var2, null, null, var7, var8, var9, var10);
   }

   public boolean steerTo(
      ClientPlayerEntity var1, Object var2, double var3, double var5, double var7, double var9, int var11, float var12, float var13, double[] var14
   ) {
      double var15 = this.tfm;
      double var17 = this.tfn;
      this.tfm = var7;
      this.tfn = var9;

      try {
         return this.steerTo(var1, var2, var3, var5, var11, var12, var13, var14);
      } finally {
         this.tfm = var15;
         this.tfn = var17;
      }
   }

   public void idle(float var1, float var2) {
      this.thv(var1, var2);
      this.tgz = false;
      this.drop();
   }

   public void turned(double var1, double var3) {
      this.tgv += var1;
      this.tgw += var3;
   }

   void thv(float var1, float var2) {
      this.tgt = this.tgq ? this.tgv : 0.0;
      this.tgu = this.tgq ? this.tgw : 0.0;
      if (this.tgq && this.tga) {
         double var3 = tbp.wrap(var1 - this.tgr) - this.tgv;
         double var5 = var2 - this.tgs - this.tgw;

         for (byte var7 = 0; var7 < 8; var7 += 2) {
            this.tgj[var7] = this.tgj[var7] - var3;
            this.tgj[var7 + 1] = this.tgj[var7 + 1] - var5;
         }
      }

      this.tgv = this.tgw = 0.0;
      if (this.tgq && this.tev != null) {
         this.tev.history(this.tgt, this.tgu);
      }

      this.tgr = var1;
      this.tgs = var2;
      this.tgq = true;
   }

   boolean thw(ClientPlayerEntity var1, Object var2, Box var3, Vec3d var4, int var5, boolean var6, double var7, double var9, float var11, float var12) {
      if (this.tev == null || var2 == null) {
         this.drop();
         return false;
      }

      if (this.tgp > 0) {
         this.tgp--;
         this.drop();
         this.tev.settle();
         return false;
      }

      if (var2 != this.tey) {
         this.tfz = var3 == null || this.thx(var4, var3, var11, var12);
         this.thy(var2, var3 == null, var5);
      }

      if (var3 == null) {
         this.thz();
      } else {
         if (this.tfa) {
            this.tfo = this.tff;
            this.tfp = this.tfg;
         } else if (!this.tez) {
            this.tif();
         }

         if (!tbp.aim(
            var4.x,
            var4.y,
            var4.z,
            (var3.minX + var3.maxX) * 0.5,
            var3.minY,
            (var3.minZ + var3.maxZ) * 0.5,
            (var3.maxX - var3.minX) * 0.5,
            var3.maxY - var3.minY,
            this.tfo,
            this.tfp,
            this.tet
         )) {
            this.tga = false;
            return false;
         }
      }

      double var13 = tbp.wrap(this.tet.yaw - var11);
      double var15 = this.tet.pitch - var12;
      if (!this.tga) {
         for (byte var17 = 0; var17 < 8; var17 += 2) {
            this.tgj[var17] = var13;
            this.tgj[var17 + 1] = var15;
         }

         this.tgd = this.tge = this.tgf = this.tgg = this.tgh = this.tgi = 0.0;
      }

      this.tgm = this.tga ? tbp.wrap(this.tet.yaw - this.tgb) : 0.0;
      this.tgn = this.tga ? this.tet.pitch - this.tgc : 0.0;
      this.ter[2] = this.tgj[2];
      this.ter[3] = this.tgj[3];
      this.ter[4] = this.tgj[6];
      this.ter[5] = this.tgj[7];
      this.ter[8] = this.tgd;
      this.ter[9] = this.tge;
      this.ter[10] = this.tgf;
      this.ter[11] = this.tgg;
      this.ter[12] = this.tgh;
      this.ter[13] = this.tgi;
      System.arraycopy(this.tgj, 0, this.tgj, 2, 6);
      this.tgj[0] = var13;
      this.tgj[1] = var15;
      this.tgh = this.tgf;
      this.tgi = this.tgg;
      this.tgf = this.tgd;
      this.tgg = this.tge;
      this.tgd = this.tgm;
      this.tge = this.tgn;
      this.tgb = this.tet.yaw;
      this.tgc = this.tet.pitch;
      this.tga = true;
      this.tgk = this.tet.bw;
      this.tgl = this.tet.bh;
      if (var6) {
         double var21 = Math.hypot(var7, var9);
         double var19 = Math.hypot(var13, var15);
         if (var21 > Math.max(2.5, 1.3 * this.thp) && var7 * var13 + var9 * var15 < -0.25 * var21 * var19) {
            this.tgp = 8 + this.tep.nextInt(7);
            this.drop();
            return false;
         }
      }

      if (this.tgo > 0) {
         this.tgo--;
         return false;
      } else {
         this.ter[0] = var13;
         this.ter[1] = var15;
         this.ter[6] = this.tgm;
         this.ter[7] = this.tgn;
         this.ter[22] = this.tet.bw;
         this.ter[23] = this.tet.bh;
         this.ter[24] = this.tfo;
         this.ter[25] = this.tfp;
         this.ter[26] = this.tet.dist;
         this.ter[27] = var3 != null && !this.tfb ? var1.getAttackCooldownProgress(0.5F) : 1.0;
         this.ter[28] = this.tet.la;
         this.ter[29] = this.tet.ra;
         this.ter[30] = this.tet.ta;
         this.ter[31] = this.tet.ba;
         double var22 = Math.abs(var13) * Math.cos(Math.toRadians(var12));
         this.tev.step(this.ter, this.teq, this.tes, this.tgy && Math.abs(var15) > 1.5 * var22 + 2.0);
         this.tha = this.tes[0];
         this.thb = this.tes[1];
         this.thp = Math.hypot(this.tha, this.thb);
         this.thq = System.currentTimeMillis() + 300L;
         return true;
      }
   }

   boolean thx(Vec3d var1, Box var2, float var3, float var4) {
      tbm var5 = new tbm();
      return !tbp.aim(
            var1.x,
            var1.y,
            var1.z,
            (var2.minX + var2.maxX) * 0.5,
            var2.minY,
            (var2.minZ + var2.maxZ) * 0.5,
            (var2.maxX - var2.minX) * 0.5,
            var2.maxY - var2.minY,
            0.0,
            0.5,
            var5
         )
         ? false
         : Math.hypot(tbp.wrap(var5.yaw - var3), var5.pitch - var4) >= 15.0;
   }

   void thy(Object var1, boolean var2, int var3) {
      this.tey = var1;
      this.tez = var2;
      this.tga = false;
      this.tgd = this.tge = this.tgf = this.tgg = this.tgh = this.tgi = 0.0;
      if (var2) {
         this.tfo = this.tfq = this.tfs = 0.0;
         this.tfp = this.tfr = this.tft = 0.5;
      } else {
         double[] var4 = this.tia();
         this.tfo = this.tfq = this.tfs = var4[0];
         this.tfp = this.tfr = this.tft = var4[1];
      }

      this.tfu = this.tfv = 0;
      this.tfw = 30 + this.tep.nextInt(50);
      if (!var2 && this.tib()) {
         this.tfx = this.tep.nextInt(this.teu.chainU.length);
         this.tfy = this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0;
         this.tfo = this.tfq = this.tfs = this.tic(this.tfx);
         this.tfp = this.tfr = this.tft = this.tid(this.tfx);
      }

      if (var3 < 0) {
         int var5 = this.teu == null ? -1 : this.teu.reaction(this.tep);
         this.tgo = this.tfz ? (var5 >= 0 ? var5 : 1 + this.tep.nextInt(3)) : 0;
         this.tgo = (int)Math.round(this.tgo * this.tfj);
      } else {
         this.tgo = var3 == 0 ? 0 : Math.max(0, (int)Math.round(var3 * (0.7 + this.tep.nextDouble() * 0.6)));
      }

      if (this.tev != null) {
         this.tev.settle();
      }
   }

   void thz() {
      this.tet.yaw = this.tfk;
      this.tet.pitch = this.tfl;
      this.tet.bw = this.tfm;
      this.tet.bh = this.tfn;
      this.tet.la = -this.tfm;
      this.tet.ra = this.tfm;
      this.tet.ta = -this.tfn * 0.5;
      this.tet.ba = this.tfn * 0.5;
      this.tet.dist = 4.0;
   }

   double[] tia() {
      if (!Double.isNaN(this.tew)) {
         double var5 = this.teu != null && this.teu.aimU.length != 0
            ? this.teu.aimU[this.tep.nextInt(this.teu.aimU.length)] * (this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0)
            : this.tep.nextGaussian() * 0.25;
         double var3 = this.tew + this.tep.nextDouble() * (this.tex - this.tew);
         return new double[]{Math.max(-0.9, Math.min(0.9, var5)), Math.max(0.02, Math.min(0.98, var3))};
      } else if (this.teu != null && this.teu.aimU.length != 0) {
         int var1 = this.tep.nextInt(this.teu.aimU.length);
         double var2 = this.teu.aimU[var1] * (this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0);
         return new double[]{Math.max(-0.9, Math.min(0.9, var2)), Math.max(0.1, Math.min(0.95, this.teu.aimV[var1]))};
      } else {
         return new double[]{this.tep.nextGaussian() * 0.25, 0.62 + this.tep.nextDouble() * 0.22};
      }
   }

   boolean tib() {
      return this.teu != null && this.teu.ownAim() && Double.isNaN(this.tew);
   }

   double tic(int var1) {
      return Math.max(-0.95, Math.min(0.95, this.teu.chainU[var1] * this.tfy));
   }

   double tid(int var1) {
      return Math.max(0.02, Math.min(0.98, this.teu.chainV[var1]));
   }

   void tie() {
      if (this.tfu < this.tfv) {
         this.tfu++;
         double var3 = (double)this.tfu / this.tfv;
         this.tfo = this.tfq + (this.tfs - this.tfq) * var3;
         this.tfp = this.tfr + (this.tft - this.tfr) * var3;
      } else {
         int var1 = this.tfx + 1;
         int var2;
         if (var1 < this.teu.chainU.length && this.teu.chainGap[var1] > 0) {
            var2 = this.teu.chainGap[var1];
         } else {
            var1 = this.tep.nextInt(this.teu.chainU.length);
            this.tfy = this.teu.mirror && this.tep.nextBoolean() ? -1.0 : 1.0;
            var2 = this.teu.chainGap[var1] > 0 ? this.teu.chainGap[var1] : 8 + this.tep.nextInt(10);
         }

         this.tfx = var1;
         this.tfq = this.tfo;
         this.tfr = this.tfp;
         this.tfs = this.tic(var1);
         this.tft = this.tid(var1);
         this.tfu = 0;
         this.tfv = Math.max(1, var2);
      }
   }

   void tif() {
      if (this.tib() && this.tfx >= 0 && this.tfx < this.teu.chainU.length) {
         this.tie();
      } else if (this.tfu < this.tfv) {
         this.tfu++;
         double var5 = (double)this.tfu / this.tfv;
         double var3 = var5 * var5 * (3.0 - 2.0 * var5);
         this.tfo = this.tfq + (this.tfs - this.tfq) * var3;
         this.tfp = this.tfr + (this.tft - this.tfr) * var3;
      } else {
         if (--this.tfw <= 0) {
            double[] var1 = this.tia();
            this.tfq = this.tfo;
            this.tfr = this.tfp;
            this.tfs = this.tfo + (var1[0] - this.tfo) * 0.6;
            this.tft = this.tfp + (var1[1] - this.tfp) * 0.6;
            this.tfu = 0;
            this.tfv = 8 + this.tep.nextInt(8);
            this.tfw = 25 + this.tep.nextInt(50);
         }
      }
   }

   static double tig(double var0, double var2) {
      if (var0 * var2 <= 0.0) {
         return 0.0;
      }

      double var4 = 3.0 * Math.abs(var2);
      return Math.abs(var0) > var4 ? Math.copySign(var4, var2) : var0;
   }

   static double tih(double var0, double var2, double var4) {
      double var6 = var0 * var0;
      double var8 = var6 * var0;
      return (var8 - 2.0 * var6 + var0) * var2 + (-2.0 * var8 + 3.0 * var6) * var4 + (var8 - var6) * var4;
   }

   public void frame(MinecraftClient var1, ClientPlayerEntity var2) {
      long var3 = System.nanoTime();
      if (this.thn != 0L) {
         double var5 = Math.min(0.1, (var3 - this.thn) / 1.0E9);
         this.tho = this.tho + (var5 / 0.05 - this.tho) * 0.2;
      }

      this.thn = var3;
      float var30 = var2.getYaw();
      float var6 = var2.getPitch();
      if (this.thi) {
         this.thl = this.thl + tbp.wrap(var30 - this.thj);
         this.thm = this.thm + (var6 - this.thk);
      }

      if (this.tgz) {
         float var7 = var1.getRenderTickCounter().getTickProgress(true);
         double var8 = Math.max(0.5, Math.min(1.0, 1.0 - this.tho * 0.9));
         double var10 = Math.min(1.0, var7 / var8);
         double var12 = tih(var10, this.thc, this.tha) - this.the;
         double var14 = tih(var10, this.thd, this.thb) - this.thf;
         double var16 = tbp.wrap(this.tgb - var30) + this.tgm * this.teq.lead;
         double var18 = this.tgc - var6 + this.tgn * this.teq.lead;
         double var20 = this.tgx ? Math.hypot(var16, var18) : 0.0;
         if (var20 > 1.0E-6) {
            double var22 = var16 / var20;
            double var24 = var18 / var20;
            double var26 = var12 * var22 + var14 * var24;
            double var28 = var20 + 0.18 * (this.tgk * Math.abs(var22) + 0.5 * this.tgl * Math.abs(var24)) + 0.02;
            if (var26 > var28) {
               var12 -= var22 * (var26 - var28);
               var14 -= var24 * (var26 - var28);
            }
         }

         this.tii(var1, var2, var12, var14);
         this.the += var12;
         this.thf += var14;
      }

      this.thj = var2.getYaw();
      this.thk = var2.getPitch();
      this.thi = true;
   }

   public void tickOnly() {
      this.tho = 1.0;
      this.thn = 0L;
   }

   public void forgetFrame() {
      this.thi = false;
      this.thn = 0L;
   }

   void tii(MinecraftClient var1, ClientPlayerEntity var2, double var3, double var5) {
      double var7 = tcz.unit(var1);
      if (!(var7 <= 0.0)) {
         if (this.tfd > 0.0) {
            double var9 = Math.hypot(var3, var5);
            double var11 = Math.max(0.0, this.tfd - this.tfe);
            if (var9 > var11) {
               double var13 = var11 / var9;
               var3 *= var13;
               var5 *= var13;
            }
         }

         this.thg += var3 / var7;
         this.thh += var5 / var7;
         long var15 = (long)this.thg;
         long var16 = (long)this.thh;
         this.thg -= var15;
         this.thh -= var16;
         if (var15 != 0L || var16 != 0L) {
            double var17 = var7 / 0.15;
            var2.changeLookDirection(var15 * var17, var16 * var17);
            this.tgv += var15 * var7;
            this.tgw += var16 * var7;
            this.tfe = this.tfe + Math.hypot(var15 * var7, var16 * var7);
         }
      }
   }
}
