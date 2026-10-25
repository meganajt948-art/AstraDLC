package a;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

final class ktc {
   double velocity;
   boolean ground;
   double fall;

   ktc() {
   }

   void copy(ktc var1) {
      this.velocity = var1.velocity;
      this.ground = var1.ground;
      this.fall = var1.fall;
   }

   void receive(double var1, boolean var3, float var4, boolean var5) {
      if (this.ground && !var3 && var1 > 0.0) {
         this.velocity = Math.max(var4, this.velocity);
      }

      if (var1 < 0.0 && !var5) {
         this.fall -= var1;
      }

      if (var3 || var1 > 0.0 || var5) {
         this.fall = 0.0;
      }

      this.ground = var3;
   }

   void tick(Entity var1, World var2, Box var3, double var4) {
      if (Math.abs(this.velocity) < 0.003) {
         this.velocity = 0.0;
      }

      if (this.velocity != 0.0) {
         boolean var6 = ktf.kuc(var1, var2, var3, this.velocity) != this.velocity;
         this.ground = var6 && this.velocity < 0.0;
         if (var6) {
            this.velocity = 0.0;
         }
      }

      this.velocity = (this.velocity - var4) * 0.98;
   }

   boolean groundsLater(Entity var1, World var2, Box var3, double var4) {
      double var6 = Math.abs(this.velocity) < 0.003 ? 0.0 : this.velocity;
      double var8 = Math.min(var6, (var6 - var4) * 0.98);
      return var8 < 0.0 && ktf.kuc(var1, var2, var3, var8) != var8;
   }
}
