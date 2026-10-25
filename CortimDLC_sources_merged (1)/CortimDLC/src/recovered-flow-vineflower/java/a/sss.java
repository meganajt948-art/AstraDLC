package a;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.util.Random;

public final class sss {
   private final Random sst = new Random();
   private final float[] ssu = new float[16];
   private final float[] ssv = new float[16];
   private final float[] ssw = new float[16];
   private final float[] ssx = new float[16];
   private final float[] ssy = new float[16];
   private final float[] ssz = new float[16];
   private final boolean[] sta = new boolean[16];
   private float stb;

   public void clear() {
      for (int var1 = 0; var1 < 16; var1++) {
         this.sta[var1] = false;
      }

      this.stb = 0.0F;
   }

   public void update(float var1, float var2, float var3) {
      this.stb += var2 * var1;

      while (this.stb >= 1.0F) {
         this.stb--;
         this.ste();
      }

      for (int var4 = 0; var4 < 16; var4++) {
         if (this.sta[var4]) {
            this.ssx[var4] = this.ssx[var4] + var1 * (1.0F + var3 * 3.0F);
            if (this.ssz[var4] > 0.0F && this.ssx[var4] > 0.4F) {
               this.ssz[var4] = this.ssz[var4] + var1 * 0.05F;
               this.ssv[var4] = this.ssv[var4] - this.ssz[var4] * var1;
            }

            if (this.ssx[var4] >= this.ssy[var4] || this.ssv[var4] < -0.05F) {
               this.sta[var4] = false;
            }
         }
      }
   }

   private void ste() {
      int var1 = -1;
      float var2 = -1.0F;

      for (int var3 = 0; var3 < 16; var3++) {
         if (!this.sta[var3]) {
            var1 = var3;
            break;
         }

         float var4 = this.ssx[var3] / this.ssy[var3];
         if (var4 > var2) {
            var2 = var4;
            var1 = var3;
         }
      }

      this.ssu[var1] = 0.06F + 0.88F * this.sst.nextFloat();
      this.ssv[var1] = 0.12F + 0.84F * this.sst.nextFloat();
      float var5 = this.sst.nextFloat();
      this.ssw[var1] = 0.018F + 0.05F * var5 * var5;
      this.ssx[var1] = 0.0F;
      this.ssy[var1] = 1.8F + 2.8F * this.sst.nextFloat();
      this.ssz[var1] = this.ssw[var1] > 0.013F && this.sst.nextFloat() < 0.55F ? 0.015F + 0.04F * this.sst.nextFloat() : 0.0F;
      this.sta[var1] = true;
   }

   public int count() {
      return 16;
   }

   public boolean any() {
      for (boolean var4 : this.sta) {
         if (var4) {
            return true;
         }
      }

      return false;
   }

   public void write(Std140Builder var1) {
      for (int var2 = 0; var2 < 16; var2++) {
         if (!this.sta[var2]) {
            var1.putVec4(0.0F, 0.0F, 0.0F, 0.0F);
         } else {
            float var3 = this.ssx[var2] / this.ssy[var2];
            float var4 = Math.min(1.0F, this.ssx[var2] / 0.12F);
            float var5 = 1.0F - Math.max(0.0F, (var3 - 0.65F) / 0.35F);
            var1.putVec4(this.ssu[var2], this.ssv[var2], this.ssw[var2], 0.95F * var4 * var5 * var5);
         }
      }
   }
}
