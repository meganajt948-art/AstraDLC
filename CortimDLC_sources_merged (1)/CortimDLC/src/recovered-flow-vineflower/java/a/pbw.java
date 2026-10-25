package a;

import java.util.List;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;

final class pbw {
   final pbs kind;
   final BlockBox box;
   final List<BlockPos> blocks;
   final long created;
   final ItemStack icon;
   final vcj shown = new vcj(14.0F);
   ClientBossBar bar;
   long deadAt;

   pbw(pbs var1, BlockBox var2, List<BlockPos> var3, long var4) {
      this.kind = var1;
      this.box = var2;
      this.blocks = var3;
      this.created = var4;
      this.icon = new ItemStack(var1.icon);
   }

   long left(long var1) {
      return this.kind.duration - (var1 - this.created);
   }
}
