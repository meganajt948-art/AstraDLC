package a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

final class gec {
   final int id;
   final int cx;
   final int cz;
   final int y0;
   final boolean armor;
   final String[] tiers;
   int tierAt;
   long refreshAt;
   final long period;
   final List<Entity> labels = new ArrayList<>();
   BlockPos warp;
   BlockPos spawn;
   int refreshes;
   int mined;
   int minedOres;
   int minedDiamonds;
   final List<String> events = new ArrayList<>();

   gec(int var1, int var2, int var3, int var4, boolean var5, long var6, long var8, String... var10) {
      this.id = var1;
      this.cx = var2;
      this.cz = var3;
      this.y0 = var4;
      this.armor = var5;
      this.refreshAt = var6;
      this.period = var8;
      this.tiers = var10;
   }

   boolean inMine(BlockPos var1) {
      return var1.method_10263() >= this.cx - 8
         && var1.method_10263() <= this.cx + 8
         && var1.method_10260() >= this.cz - 8
         && var1.method_10260() <= this.cz + 8
         && var1.method_10264() >= this.y0 - gef.gen
         && var1.method_10264() <= this.y0 - 1;
   }

   String tier() {
      return this.tiers[this.tierAt % this.tiers.length];
   }
}
