package a;

import flow.dev.a;
import java.util.Arrays;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.MapColor.Brightness;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.chunk.WorldChunk;

public final class eip {
   public static final int SIZE = 96;
   private static final int eiq = 12;
   private static final MinecraftClient eir = MinecraftClient.method_1551();
   private final dtv eis;
   private final int[] eit = new int[9216];
   private final Mutable eiu = new Mutable();
   private elb eiv;
   private boolean eiw;
   private int eix;
   private int eiy;
   private int eiz;
   private int eja;
   private int ejb;
   private boolean ejc;
   private long ejd;
   private MapIdComponent eje;
   private long ejf;
   private elb ejg;
   private boolean ejh;

   eip(dtv var1) {
      this.eis = var1;
   }

   public void demand() {
      this.ejd = System.currentTimeMillis() + 1000L;
   }

   void reset() {
      this.eix = 0;
      this.ejc = false;
      Arrays.fill(this.eit, 0);
      this.eiw = true;
      this.eje = null;
   }

   void onChunk(WorldChunk var1) {
   }

   void onMap(MapIdComponent var1) {
      this.eje = var1;
      this.ejf = System.currentTimeMillis();
      this.ejh = true;
   }

   void tick() {
      if (System.currentTimeMillis() <= this.ejd) {
         ClientPlayerEntity var1 = eir.field_1724;
         ClientWorld var2 = eir.field_1687;
         if (var1 != null && var2 != null) {
            if (this.eix == 0) {
               this.eiy = var1.method_31477();
               this.eiz = var1.method_31479();
            }

            int var3 = var1.method_31478();
            int var4 = var2.method_31607();
            int var5 = Math.min(96, this.eix + 12);

            for (int var6 = this.eix; var6 < var5; var6++) {
               int var7 = this.eiz + var6 - 48;

               for (int var8 = 0; var8 < 96; var8++) {
                  int var9 = this.eiy + var8 - 48;
                  this.eit[var6 * 96 + var8] = this.ejk(var2, var9, var7, var3, var4);
               }
            }

            this.eix = var5;
            if (this.eix >= 96) {
               this.eix = 0;
               this.eja = this.eiy;
               this.ejb = this.eiz;
               this.ejc = true;
               this.eiw = true;
            }
         }
      }
   }

   private int ejk(ClientWorld var1, int var2, int var3, int var4, int var5) {
      WorldChunk var6 = var1.method_2935().method_12126(var2 >> 4, var3 >> 4, false);
      if (var6 == null) {
         return 0;
      } else {
         int var7 = var6.method_12005(Type.field_13202, var2 & 15, var3 & 15);
         int var8 = Math.min(var7, var4 + 6);
         int var9 = Math.max(var5, var8 - 40);

         for (int var10 = var8; var10 >= var9; var10--) {
            this.eiu.method_10103(var2, var10, var3);
            BlockState var11 = var6.method_8320(this.eiu);
            if (!var11.method_26215()) {
               MapColor var12 = var11.method_26205(var1, this.eiu);
               if (var12 != MapColor.field_16008) {
                  int var13 = var10 - var4;
                  Brightness var14 = var13 > 1
                     ? Brightness.field_34761
                     : (var13 >= -2 ? Brightness.field_34760 : (var13 >= -8 ? Brightness.field_34759 : Brightness.field_34762));
                  return var12.method_15820(var14);
               }
            }
         }

         return 0;
      }
   }

   public elb texture() {
      if (!this.ejc) {
         return null;
      } else {
         if (this.eiv == null) {
            this.eiv = new elb(a.c(-1093687452, "꜓\udeb1呧쨓䇗"), 96, 96);
            this.eiw = true;
         }

         if (this.eiw) {
            for (int var1 = 0; var1 < 96; var1++) {
               for (int var2 = 0; var2 < 96; var2++) {
                  this.eiv.set(var2, var1, this.eit[var1 * 96 + var2]);
               }
            }

            this.eiv.upload();
            this.eiw = false;
         }

         return this.eiv;
      }
   }

   public int getCenterX() {
      return this.eja;
   }

   public int getCenterZ() {
      return this.ejb;
   }

   public elb mapTexture() {
      ClientWorld var1 = this.eis.getWorld();
      if (this.eje != null && var1 != null && System.currentTimeMillis() - this.ejf <= 120000L) {
         MapState var2 = var1.method_17891(this.eje);
         if (var2 == null) {
            return null;
         } else {
            if (this.ejg == null) {
               this.ejg = new elb(a.c(-847230806, "䣄ㅹ뮻"), 128, 128);
               this.ejh = true;
            }

            if (this.ejh) {
               for (int var3 = 0; var3 < 16384; var3++) {
                  this.ejg.set(var3 % 128, var3 / 128, MapColor.method_38480(var2.field_122[var3]));
               }

               this.ejg.upload();
               this.ejh = false;
            }

            return this.ejg;
         }
      } else {
         return null;
      }
   }

   void close() {
      if (this.eiv != null) {
         this.eiv.close();
         this.eiv = null;
      }

      if (this.ejg != null) {
         this.ejg.close();
         this.ejg = null;
      }
   }
}
