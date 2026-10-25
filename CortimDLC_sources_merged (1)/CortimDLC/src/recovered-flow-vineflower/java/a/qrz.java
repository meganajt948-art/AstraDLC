package a;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import net.minecraft.util.math.BlockPos;

final class qrz {
   final LongArrayList ores = new LongArrayList();
   double x;
   double y;
   double z;

   private qrz() {
   }

   void center() {
      double var1 = 0.0;
      double var3 = 0.0;
      double var5 = 0.0;

      for (int var7 = 0; var7 < this.ores.size(); var7++) {
         long var8 = this.ores.getLong(var7);
         var1 += BlockPos.unpackLongX(var8) + 0.5;
         var3 += BlockPos.unpackLongY(var8) + 0.5;
         var5 += BlockPos.unpackLongZ(var8) + 0.5;
      }

      int var10 = Math.max(1, this.ores.size());
      this.x = var1 / var10;
      this.y = var3 / var10;
      this.z = var5 / var10;
   }
}
