package a;

import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class pyd {
   private static final int pye = 14;
   private static final int pyf = 5;
   private static final int pyg = 4;
   public final pve stride = new pve();
   private final Random pyh = new Random();
   private tvz pyi;
   private psf pyj;
   private Vec3d pyk;
   private int pyl;
   private psf pym;
   private int pyn;
   private boolean pyo;
   private double pyp;
   private double pyq;
   private double pyr = Double.NaN;
   private boolean pys;
   private int pyt;
   private double pyu;
   private int pyv;
   private int pyw;
   private int pyx;
   private long pyy = -1L;
   private boolean pyz;

   public void personalize(long var1) {
      this.stride.personalize(var1);
   }

   public psc style() {
      return this.stride.routeStyle();
   }

   public void reset() {
      this.stride.reset();
      this.pyj = null;
      this.pyk = null;
      this.pyo = false;
      this.pys = false;
      this.pyt = 0;
      this.pyv = 0;
      this.pyy = -1L;
      if (this.pyi != null) {
         this.pyi.reset();
      }
   }

   public void beginTick() {
      this.pym = null;
      this.pys = false;
      this.pyo = false;
      this.pyr = Double.NaN;
   }

   public boolean drove() {
      return this.pys;
   }

   public boolean neural() {
      return this.pys && this.pyz;
   }

   public psf shown() {
      return this.pym;
   }

   public int shownAt() {
      return this.pyn;
   }

   public double moveYaw(double var1) {
      return Double.isNaN(this.pyr) ? var1 : this.pyr;
   }

   public boolean takeTurn(double[] var1) {
      if (!this.pyo) {
         return false;
      } else {
         this.pyo = false;
         var1[0] = this.pyp;
         var1[1] = this.pyq;
         return true;
      }
   }

   public tvz brain() {
      return this.pyi;
   }

   public double remaining(psf var1) {
      if (var1 == null) {
         return 0.0;
      } else {
         return this.stride.route() == var1 ? var1.track.length() - this.stride.progress() : var1.track.length();
      }
   }

   public psf plan(World var1, PlayerEntity var2, List<BlockPos> var3, BlockPos var4, prz var5) {
      if (var3 != null && !var3.isEmpty()) {
         try {
            return psf.of(var1, var2, var2.method_73189(), var3, var4, this.style(), var5, this.pyh);
         } catch (RuntimeException var7) {
            return null;
         }
      } else {
         return null;
      }
   }

   public int walkTo(MinecraftClient var1, PlayerEntity var2, World var3, Vec3d var4, float var5, float var6, Vec3d var7, boolean var8, boolean var9, txs var10) {
      this.pyl++;
      if (this.pyj == null || this.pyk == null || this.pyk.method_1025(var4) > 0.36 || this.pyl > 60) {
         this.pyj = psf.direct(var3, var2, var2.method_73189(), var4);
         this.pyk = var4;
         this.pyl = 0;
      }

      if (this.pyj == null) {
         return 1;
      } else {
         int var11 = this.follow(var1, var2, var3, this.pyj, var5, var6, var7, var8, var9, var10);
         if (var11 == 2) {
            this.pyj = null;
         }

         return var11;
      }
   }

   public int follow(MinecraftClient var1, PlayerEntity var2, World var3, psf var4, float var5, float var6, Vec3d var7, boolean var8, boolean var9, txs var10) {
      int var11 = this.stride.track(var2, var4);
      this.pym = var4;
      this.pyn = this.stride.at();
      if (var4.id != this.pyy) {
         this.pyy = var4.id;
         this.pyu = this.stride.progress();
         this.pyv = 0;
         this.pyw = 0;
         this.pyx = 0;
      }

      if (var11 == 0 && !var9) {
         this.pys = true;
         boolean var12 = var2.method_7344().method_7586() > 6 && !var2.method_6115();
         if (var10 != null && this.pyt <= 0) {
            if (this.pyi == null || this.pyi.model != var10) {
               this.pyi = new tvz(var10);
            }

            tvw var13 = this.pyi.decide(var3, var2, var4.track, this.stride.at(), var5, var6, var12);
            double var14 = this.stride.progress();
            double var16 = Math.hypot(var2.method_23317() - var2.field_6014, var2.method_23321() - var2.field_5969);
            if (var14 > this.pyu + 0.3) {
               this.pyu = var14;
               this.pyv = 0;
            } else if (++this.pyv > 14) {
               this.pyv = 0;
               this.pyt = 40;
            }

            this.pyw = var16 < 0.02 ? this.pyw + 1 : 0;
            if (this.pyw >= 5 && var4.track.length() - var14 > 1.0) {
               this.pyw = 0;
               this.pyt = 30;
            }

            boolean var18 = Math.abs(tvt.wrap(this.stride.aheadYaw(var2, 1.6) - (var5 + var13.dyaw))) > 110.0;
            this.pyx = var18 && !var13.forward ? this.pyx + 1 : 0;
            if (this.pyx >= 4) {
               this.pyx = 0;
               this.pyt = 25;
            }

            if (this.pyt <= 0 && this.stride.safe(var2, var3, var13.forward, var13.back, var13.left, var13.right, var13.sprint, var13.jump, var5 + var13.dyaw)) {
               float var19 = var13.forward ? 1.0F : (var13.back ? -1.0F : 0.0F);
               float var20 = var13.left ? 1.0F : (var13.right ? -1.0F : 0.0F);
               this.pyr = var19 == 0.0F && var20 == 0.0F ? var5 : Math.toDegrees(pud.inputDirection((float)(var5 + var13.dyaw), var19, var20));
               boolean var21 = var13.jump || (var19 != 0.0F || var20 != 0.0F) && this.stride.mustJump(var2, this.pyr);
               apply(var1, var13.forward, var13.back, var13.left, var13.right, var21, var13.sprint);
               this.pyi.jumped(var21);
               this.pyp = var13.dyaw;
               this.pyq = var13.dpitch;
               this.pyo = true;
               this.pyz = true;
               return 0;
            }

            if (this.pyt <= 0) {
               this.pyt = 12;
            }
         }

         if (this.pyt > 0) {
            this.pyt--;
         }

         pvb var22 = this.stride.drive(var2, var3, var5, var6, var7, var8, var12);
         if (!this.stride.safe(var2, var3, var22.forward, var22.back, var22.left, var22.right, var22.sprint, var22.jump, var5 + var22.dyaw)) {
            var22 = this.stride.cautious(var2, var3, var5);
         }

         apply(var1, var22.forward, var22.back, var22.left, var22.right, var22.jump, var22.sprint);
         if (this.pyi != null) {
            this.pyi.jumped(var22.jump);
         }

         this.pyp = var22.dyaw;
         this.pyq = var22.dpitch;
         this.pyo = true;
         this.pyz = false;
         this.pyr = var22.moveYaw;
         return 0;
      } else {
         return var11;
      }
   }

   public static void apply(MinecraftClient var0, boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      GameOptions var7 = var0.field_1690;
      if (var7 != null) {
         var7.field_1894.method_23481(var1);
         var7.field_1881.method_23481(var2);
         var7.field_1913.method_23481(var3);
         var7.field_1849.method_23481(var4);
         var7.field_1903.method_23481(var5);
         setSprint(var7, var6);
      }
   }

   public static void setSprint(GameOptions var0, boolean var1) {
      KeyBinding var2 = var0.field_1867;
      if ((Boolean)var0.method_42450().method_41753()) {
         if (var1 != var2.method_1434()) {
            var2.method_23481(true);
         }
      } else {
         var2.method_23481(var1);
      }
   }
}
