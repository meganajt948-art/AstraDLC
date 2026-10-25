package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

final class svy {
   final LivingEntity player;
   final boolean mob;
   int crowd = 1;
   boolean folded;
   int crowdShown = 1;
   String crowdText;
   final vcj shown = new vcj(9.0F);
   final vcj health = new vcj(8.0F, -1.0F);
   final vcj trail = new vcj(3.5F, -1.0F);
   long trailHold;
   final float[] screen = new float[2];
   double distance;
   List<svi> name;
   long nameTick = Long.MIN_VALUE;
   long infoTick = Long.MIN_VALUE;
   boolean friend;
   vyd reading;
   final List<ItemStack> gear = new ArrayList<>(swh.sxh.length);
   int ping = -1;
   String hpText;
   String hpLabel;
   String absText;
   String pingText;
   int widthStep = -1;
   long widthTick = Long.MIN_VALUE;
   float nameW;
   float hpTextW;
   long distKey = Long.MIN_VALUE;
   String distText;

   svy(LivingEntity var1) {
      this.player = var1;
      this.mob = !(var1 instanceof PlayerEntity);
   }

   List<svi> name(long var1) {
      if (this.name == null || var1 != this.nameTick) {
         this.name = svp.of(lsx.protect(this.player.getDisplayName()), swh.NAME);
         this.nameTick = var1;
      }

      return this.name;
   }

   void info(MinecraftClient var1, long var2) {
      if (var2 != this.infoTick || this.reading == null) {
         this.infoTick = var2;
         this.friend = !this.mob && hhf.isFriend(this.player);
         this.reading = vyk.of(this.player);
         this.ping = this.player instanceof PlayerEntity var4 ? swh.sye(var1, var4) : -1;
         this.pingText = this.ping >= 0 ? this.ping + wap.unit(a.c(29984147, "藼ﱓ")) : null;
         this.gear.clear();

         for (EquipmentSlot var7 : swh.sxh) {
            ItemStack var8 = this.player.getEquippedStack(var7);
            if (!var8.isEmpty()) {
               this.gear.add(var8);
            }
         }

         boolean var10 = this.reading.unknown();
         String var12 = var10 ? a.b("顄", 794138746) : String.valueOf((int)Math.ceil(this.reading.health()));
         if (!var12.equals(this.hpText)) {
            this.hpText = var12;
            this.hpLabel = var12 + a.b("䥎ョ", 1803372804);
         }

         float var13 = this.reading.absorption();
         this.absText = !var10 && var13 >= 0.5F ? a.c(1799716651, "缁") + Math.round(var13) : null;
      }
   }

   String distance(double var1) {
      long var3 = var1 < 10.0 ? Math.round(var1 * 10.0) : 1000L + Math.round(var1);
      if (var3 != this.distKey || this.distText == null) {
         this.distKey = var3;
         this.distText = swh.syg(var1);
      }

      return this.distText;
   }
}
