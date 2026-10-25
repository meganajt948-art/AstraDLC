package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.util.math.MathHelper;

public final class pud {
   public static final pud INSTANCE = new pud();
   private static final int pue = 5;
   private static final float puf = 40.0F;
   private boolean pug;
   private float puh;
   private float pui;
   private boolean puj;
   private boolean puk;
   private int pul;
   private int pum = 5;
   private float pun;
   private float puo;
   private Object pup;
   private boolean puq;
   private float pur;
   private float pus;
   private float put;
   private float puu;
   private boolean puv;
   private float puw;
   private float pux;

   private pud() {
   }

   public void set(Object var1, float var2, float var3) {
      this.pup = var1;
      this.pug = true;
      this.puh = var2;
      this.pui = MathHelper.method_15363(var3, -90.0F, 90.0F);
      this.puj = true;
      this.puk = false;
   }

   public boolean ownedBy(Object var1) {
      return this.pup == var1 && (this.puj || this.puk);
   }

   public boolean engaged() {
      return this.puj || this.puk;
   }

   public void release(ClientPlayerEntity var1) {
      if (this.pug && (this.puj || this.puk)) {
         if (!this.puk) {
            this.pun = this.puh;
            this.puo = this.pui;
            this.pul = 0;
            this.puk = true;
            this.puj = false;
            float var2 = var1 == null
               ? 0.0F
               : (float)Math.hypot(Math.abs(MathHelper.method_15393(this.pun - var1.method_36454())), Math.abs(this.puo - var1.method_36455()));
            this.pum = MathHelper.method_15340(Math.round(1.875F * var2 / 40.0F), 5, 14);
         }
      } else {
         this.reset();
      }
   }

   public void reset() {
      this.pug = false;
      this.puj = false;
      this.puk = false;
      this.pul = 0;
      this.pup = null;
   }

   public float cameraYaw(ClientPlayerEntity var1) {
      return this.puq ? this.pur : var1.method_36454();
   }

   public float cameraPitch(ClientPlayerEntity var1) {
      return this.puq ? this.pus : var1.method_36455();
   }

   public void begin(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (var2 != null && !this.puq) {
         float var3 = var2.method_36454();
         float var4 = var2.method_36455();
         float var5;
         float var6;
         if (this.puk) {
            this.pul++;
            if (this.pul >= this.pum) {
               this.reset();
               return;
            }

            float var7 = (float)this.pul / this.pum;
            float var8 = var7 * var7 * var7 * (6.0F * var7 * var7 - 15.0F * var7 + 10.0F);
            var5 = this.pun + MathHelper.method_15393(var3 - this.pun) * var8;
            var6 = MathHelper.method_16439(var8, this.puo, var4);
         } else {
            if (!this.puj || !this.pug) {
               return;
            }

            var5 = this.puh;
            var6 = this.pui;
         }

         float[] var9 = prp.apply(var3, var4, var5, var6);
         this.pur = var3;
         this.pus = var4;
         this.put = var2.field_3932;
         this.puu = var2.field_3916;
         this.puq = true;
         var2.method_36456(var9[0]);
         var2.method_36457(var9[1]);
      }
   }

   public void end(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      this.pva(var1);
      if (this.puq) {
         this.puq = false;
         if (var2 != null) {
            var2.method_36456(this.pur);
            var2.method_36457(this.pus);
            var2.field_5982 = this.pur;
            var2.field_6004 = this.pus;
            var2.field_3931 = this.put;
            var2.field_3914 = this.puu;
            var2.field_3932 = this.put + (this.pur - this.put) * 0.5F;
            var2.field_3916 = this.puu + (this.pus - this.puu) * 0.5F;
         }
      }
   }

   public void remapHumanKeys(MinecraftClient var1, float var2, float var3) {
      GameOptions var4 = var1.field_1690;
      float var5 = (vzz.isPhysicallyDown(var1, var4.field_1894) ? 1.0F : 0.0F) - (vzz.isPhysicallyDown(var1, var4.field_1881) ? 1.0F : 0.0F);
      float var6 = (vzz.isPhysicallyDown(var1, var4.field_1913) ? 1.0F : 0.0F) - (vzz.isPhysicallyDown(var1, var4.field_1849) ? 1.0F : 0.0F);
      if (var5 == 0.0F && var6 == 0.0F) {
         this.puw = 0.0F;
         this.pux = 0.0F;
      } else if (Math.abs(MathHelper.method_15393(var3 - var2)) <= 12.0F) {
         this.puw = 0.0F;
         this.pux = 0.0F;
      } else {
         double var7 = MathHelper.method_15338(Math.toDegrees(inputDirection(var2, var5, var6)));
         float var9 = 0.0F;
         float var10 = 0.0F;
         float var11 = Float.MAX_VALUE;

         for (float var12 = -1.0F; var12 <= 1.0F; var12++) {
            for (float var13 = -1.0F; var13 <= 1.0F; var13++) {
               if (var12 != 0.0F || var13 != 0.0F) {
                  double var14 = MathHelper.method_15338(Math.toDegrees(inputDirection(var3, var12, var13)));
                  float var16 = Math.abs(MathHelper.method_15393((float)(var7 - var14)));
                  if (var16 < var11) {
                     var11 = var16;
                     var9 = var12;
                     var10 = var13;
                  }
               }
            }
         }

         if (this.puw != 0.0F || this.pux != 0.0F) {
            double var17 = MathHelper.method_15338(Math.toDegrees(inputDirection(var3, this.puw, this.pux)));
            float var18 = Math.abs(MathHelper.method_15393((float)(var7 - var17)));
            if (var18 <= var11 + 18.0F) {
               var9 = this.puw;
               var10 = this.pux;
            }
         }

         this.puw = var9;
         this.pux = var10;
         var4.field_1894.method_23481(var9 > 0.0F);
         var4.field_1881.method_23481(var9 < 0.0F);
         var4.field_1913.method_23481(var10 > 0.0F);
         var4.field_1849.method_23481(var10 < 0.0F);
         this.puv = true;
      }
   }

   private void pva(MinecraftClient var1) {
      if (this.puv && var1.field_1690 != null) {
         this.puv = false;
         GameOptions var2 = var1.field_1690;
         var2.field_1894.method_23481(vzz.isPhysicallyDown(var1, var2.field_1894));
         var2.field_1881.method_23481(vzz.isPhysicallyDown(var1, var2.field_1881));
         var2.field_1913.method_23481(vzz.isPhysicallyDown(var1, var2.field_1913));
         var2.field_1849.method_23481(vzz.isPhysicallyDown(var1, var2.field_1849));
      }
   }

   public static double inputDirection(float var0, float var1, float var2) {
      float var3 = var1 < 0.0F ? var0 + 180.0F : var0;
      float var4 = var1 < 0.0F ? -0.5F : (var1 > 0.0F ? 0.5F : 1.0F);
      float var5 = var2 > 0.0F ? -90.0F * var4 : (var2 < 0.0F ? 90.0F * var4 : 0.0F);
      return Math.toRadians(var3 + var5);
   }
}
