package a;

import java.util.Arrays;

final class qmr {
   float[] qms = new float[1024];
   int[] qmt = new int[1024];
   int qmu;

   qmr() {
   }

   void clear() {
      this.qmu = 0;
   }

   boolean isEmpty() {
      return this.qmu == 0;
   }

   float topKey() {
      return this.qms[0];
   }

   void push(float var1, int var2) {
      if (this.qmu == this.qms.length) {
         this.qms = Arrays.copyOf(this.qms, this.qmu * 2);
         this.qmt = Arrays.copyOf(this.qmt, this.qmu * 2);
      }

      int var3 = this.qmu++;

      while (var3 > 0) {
         int var4 = var3 - 1 >> 1;
         if (this.qms[var4] <= var1) {
            break;
         }

         this.qms[var3] = this.qms[var4];
         this.qmt[var3] = this.qmt[var4];
         var3 = var4;
      }

      this.qms[var3] = var1;
      this.qmt[var3] = var2;
   }

   int pop() {
      int var1 = this.qmt[0];
      this.qmu--;
      if (this.qmu > 0) {
         float var2 = this.qms[this.qmu];
         int var3 = this.qmt[this.qmu];
         int var4 = 0;

         while (true) {
            int var5 = var4 * 2 + 1;
            if (var5 >= this.qmu) {
               break;
            }

            int var6 = var5 + 1;
            int var7 = var6 < this.qmu && this.qms[var6] < this.qms[var5] ? var6 : var5;
            if (this.qms[var7] >= var2) {
               break;
            }

            this.qms[var4] = this.qms[var7];
            this.qmt[var4] = this.qmt[var7];
            var4 = var7;
         }

         this.qms[var4] = var2;
         this.qmt[var4] = var3;
      }

      return var1;
   }
}
