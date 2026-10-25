package a;

import java.util.Random;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public final class tvz {
   private static final double twa = 0.12;
   private static final double twb = 0.03;
   private static final int twc = 10;
   public final txs model;
   private final txv twd;
   private final Random twe = new Random();
   private final double[] twf = new double[txl.N];
   private final double[] twg = new double[9];
   private final double[] twh = new double[txv.YAW.length];
   private final double[] twi = new double[txv.PITCH.length];
   private final txi twj = new txi();
   private final tvw twk = new tvw();
   private tzg twl;
   private World twm;
   private int twn;
   private int two;
   private int twp;
   private int twq;
   private long twr;
   private float tws;
   private float twt;
   private double twu;
   private double twv;
   private int tww = 0;
   private boolean twx;
   private boolean twy;
   private boolean twz;
   private int txa = 20;
   private double txb;
   private int txc;

   public tvz(txs var1) {
      this.model = var1;
      this.twd = var1.net.copy();
   }

   public double speed() {
      return this.txc < 40 ? -1.0 : this.txb / this.txc * 20.0;
   }

   public void reset() {
      this.twr = 0L;
      this.tww = 0;
      this.twx = false;
      this.twy = false;
      this.twz = false;
      this.txa = 20;
   }

   public tvw decide(World var1, PlayerEntity var2, tvt var3, int var4, float var5, float var6, boolean var7) {
      long var8 = System.currentTimeMillis();
      boolean var10 = var8 - this.twr > 140L;
      this.twr = var8;
      int var11 = (int)Math.floor(var2.getX());
      int var12 = (int)Math.floor(var2.getY() + 0.001);
      int var13 = (int)Math.floor(var2.getZ());
      if (this.twl == null || var1 != this.twm || var11 != this.twn || var12 != this.two || var13 != this.twp || ++this.twq >= 10) {
         this.twl = txf.snap(var1, var11, var12, var13);
         this.twm = var1;
         this.twn = var11;
         this.two = var12;
         this.twp = var13;
         this.twq = 0;
      }

      double var14 = var10 ? 0.0 : tvt.wrap(var5 - this.tws);
      double var16 = var10 ? 0.0 : var6 - this.twt;
      this.twj.dyaw2 = var10 ? 0.0 : this.twu;
      this.twj.dpitch2 = var10 ? 0.0 : this.twv;
      this.twj.dyaw1 = var14;
      this.twj.dpitch1 = var16;
      this.twu = var14;
      this.twv = var16;
      this.tws = var5;
      this.twt = var6;
      if (var10) {
         this.tww = 0;
         this.txa = 20;
         this.twy = false;
         this.twz = false;
      } else {
         this.txa = this.twy && !this.twz ? 0 : Math.min(20, this.txa + 1);
         this.twz = this.twy;
      }

      this.twj.x = var2.getX();
      this.twj.y = var2.getY();
      this.twj.z = var2.getZ();
      this.twj.yaw = var5;
      this.twj.pitch = var6;
      this.twj.vx = var2.getX() - var2.lastX;
      this.twj.vy = var2.getY() - var2.lastY;
      this.twj.vz = var2.getZ() - var2.lastZ;
      this.twj.ground = var2.isOnGround();
      this.twj.water = var2.isTouchingWater();
      this.twj.climb = var2.isClimbing();
      this.twj.collide = var2.horizontalCollision;
      this.twj.sprinting = var2.isSprinting();
      double var18 = var2.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
      this.twj.speed = var2.isSprinting() ? var18 / 1.3 : var18;
      this.twj.sinceJump = this.txa;
      txl.features(this.twj, var3, var4, this.twl, this.twf, 0);
      double[] var20 = this.twd.forward(this.twf);
      txv.softmax(var20, 0, 9, 1.0, this.twg);
      int var21 = 0;

      for (int var22 = 1; var22 < 9; var22++) {
         if (this.twg[var22] > this.twg[var21]) {
            var21 = var22;
         }
      }

      double var35 = this.tww == 0 ? 0.03 : 0.12;
      if (var21 != this.tww && this.twg[var21] < this.twg[this.tww] + var35) {
         var21 = this.tww;
      }

      this.tww = var21;
      double var24 = txv.sigmoid(var20[9]);
      double var26 = txv.sigmoid(var20[10]);
      this.twx = this.twx ? var26 > 0.42 : var26 > 0.58;
      double var28 = txv.pick(txv.YAW, var20, 11, this.model.yawTemp, this.model.yawJitter, this.twh, this.twe);
      double var30 = txv.pick(txv.PITCH, var20, txv.PITCH0, this.model.pitchTemp, this.model.pitchJitter, this.twi, this.twe);
      tvw var32 = this.twk;
      var32.forward = txv.FWD[this.tww] > 0;
      var32.back = txv.FWD[this.tww] < 0;
      var32.left = txv.LEFT[this.tww] > 0;
      var32.right = txv.LEFT[this.tww] < 0;
      var32.jump = var24 > this.model.jumpThreshold;
      var32.sprint = this.twx && var7 && var32.forward;
      var32.dyaw = var28;
      var32.dpitch = Math.max(-90.0 - var6, Math.min(90.0 - var6, var30));
      this.twy = var32.jump;
      double var33 = Math.hypot(this.twj.vx, this.twj.vz);
      if (this.twj.ground && this.tww != 0 && var33 > 0.05) {
         if (this.txc >= 2000) {
            this.txb *= 0.5;
            this.txc /= 2;
         }

         this.txb += var33;
         this.txc++;
      }

      return var32;
   }

   public void jumped(boolean var1) {
      this.twy = var1;
   }
}
