package a;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class lqk {
   private static final int lql = 5;
   private static final double lqm = 0.08;
   private final Box[] lqn = new Box[40];

   public void predict(Entity var1, World var2) {
      Box var3 = var1.method_5829();
      double var4 = var1.method_23317() - var1.field_6014;
      double var6 = var1.method_23318() - var1.field_6036;
      double var8 = var1.method_23321() - var1.field_5969;
      boolean var10 = var1.method_24828();
      if (var10) {
         var6 = 0.0;
      } else {
         var6 = (var6 - 0.08) * 0.98;
      }

      for (int var11 = 0; var11 < this.lqn.length; var11++) {
         this.lqn[var11] = var3;
         double var12 = var11 < 5 ? var4 : 0.0;
         double var14 = var11 < 5 ? var8 : 0.0;
         double var16 = var10 ? 0.0 : var6;
         if (var12 != 0.0 || var16 != 0.0 || var14 != 0.0) {
            Vec3d var18 = Entity.method_20736(var1, new Vec3d(var12, var16, var14), var3, var2, List.of());
            if (!var10) {
               if (var18.field_1351 != var16 && var16 < 0.0) {
                  var10 = true;
                  var6 = 0.0;
               } else {
                  var6 = (var6 - 0.08) * 0.98;
               }
            }

            var3 = var3.method_997(var18);
         }
      }
   }

   public Box box(int var1) {
      return this.lqn[MathHelper.method_15340(var1, 0, this.lqn.length - 1)];
   }
}
