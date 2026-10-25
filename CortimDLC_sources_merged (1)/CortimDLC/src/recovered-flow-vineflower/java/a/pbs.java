package a;

import flow.dev.a;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;

enum pbs {
   DRAGON_TRAP(a.c(438606992, "颋\ue16e母\uf5b6繥\uf8d7䋵쬇儷\udfe4堵ꈴⳬ땘㼁"), 30000L, Items.NETHERITE_SCRAP, true, new int[]{7, 7, 7}, new int[]{7, 7, 6}),
   TRAP(
      a.c(-558032212, "Ẉ杛\uedf8玆\uf854绯"), 15000L, Items.NETHERITE_SCRAP, true, new int[]{5, 5, 5}, new int[]{5, 5, 4}, new int[]{5, 6, 5}, new int[]{5, 6, 4}
   ),
   DRAGON_PLAST(a.b("冨⡍ꋮ㲕띆ㇴ订ɒ頔ᚺ酭欗\ue5b1簃", 574903730), 20000L, Items.DRIED_KELP, true, new int[]{7, 7, 2}, new int[]{7, 7, 1}),
   PLAST(a.d("沽ᔨ鿰ǰ訤", 1833275932, 1677195963), 20000L, Items.DRIED_KELP, true, new int[]{5, 5, 2}, new int[]{5, 5, 1}),
   ACCORDION(a.c(1079872998, "觼\uf069窱\ue4b1潥"), 20000L, Items.DRIED_KELP, false, new int[]{5, 5, 5}, new int[]{5, 6, 5});

   final String title;
   final long duration;
   final Item icon;
   final boolean hollow;
   final int[][] sizes;

   pbs(String var3, long var4, Item var6, boolean var7, int[]... var8) {
      this.title = var3;
      this.duration = var4;
      this.icon = var6;
      this.hollow = var7;
      this.sizes = new int[var8.length][];

      for (int var9 = 0; var9 < var8.length; var9++) {
         this.sizes[var9] = (int[])var8[var9].clone();
         Arrays.sort(this.sizes[var9]);
      }
   }

   boolean matches(BlockBox var1, List<BlockPos> var2) {
      int[] var3 = new int[]{var1.getBlockCountX(), var1.getBlockCountY(), var1.getBlockCountZ()};
      Arrays.sort(var3);

      for (int[] var7 : this.sizes) {
         if (Arrays.equals(var3, var7)) {
            return this.hollow == var2.stream().noneMatch(var1x -> pbv(var1, var1x));
         }
      }

      return false;
   }

   static boolean pbv(BlockBox var0, BlockPos var1) {
      return var1.getX() > var0.getMinX()
         && var1.getX() < var0.getMaxX()
         && var1.getY() > var0.getMinY()
         && var1.getY() < var0.getMaxY()
         && var1.getZ() > var0.getMinZ()
         && var1.getZ() < var0.getMaxZ();
   }
}
