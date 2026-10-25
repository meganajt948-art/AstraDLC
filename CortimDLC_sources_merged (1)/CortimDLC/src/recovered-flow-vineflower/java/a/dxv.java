package a;

import flow.dev.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.chunk.WorldChunk;

final class dxv {
   final ClientWorld world;
   final int bottomY;
   final int topY;
   final boolean skyLight;
   final double daylight;
   final int skyTop;
   final int skyHorizon;
   final BlockPos target;
   final int waterTint;
   final Map<Long, Integer> tops = new ConcurrentHashMap<>();

   int top(long var1, WorldChunk var3) {
      Integer var4 = this.tops.get(var1);
      if (var4 != null) {
         return var4;
      } else {
         int var5 = this.bottomY;

         try {
            for (int var6 = 0; var6 < 16; var6++) {
               for (int var7 = 0; var7 < 16; var7++) {
                  var5 = Math.max(var5, var3.method_12005(Type.field_13202, var6, var7) + 1);
               }
            }
         } catch (Throwable var8) {
            var5 = this.topY + 1;
         }

         this.tops.put(var1, var5);
         return var5;
      }
   }

   dxv(ClientWorld var1, ClientPlayerEntity var2, HitResult var3) {
      this.world = var1;
      this.bottomY = var1.method_31607();
      this.topY = var1.method_31600();
      this.skyLight = var1.method_8597().comp_642();
      double var4 = var1.method_8594() / 11.0;
      this.daylight = Math.max(0.25, 1.0 - var4);
      String var6 = var1.method_27983().method_29177().method_12832();
      if (var6.contains(a.b("卢⫘ꀚ㹷떭㌋", -1618849014))) {
         this.skyTop = -12972530;
         this.skyHorizon = -11922416;
      } else if (var6.contains(a.c(595721749, "ﹳ蟉ഐ"))) {
         this.skyTop = -15593960;
         this.skyHorizon = -14804952;
      } else {
         this.skyTop = dyh.scale(-8674049, 0.25 + 0.75 * this.daylight);
         this.skyHorizon = dyh.scale(-3942401, 0.25 + 0.75 * this.daylight);
      }

      this.target = var3 instanceof BlockHitResult var7 && var7.method_17783() == net.minecraft.util.hit.HitResult.Type.field_1332 ? var7.method_17777() : null;

      int var10;
      try {
         var10 = dyh.dyq.method_1505().method_1697(Blocks.field_10382.method_9564(), var1, var2.method_24515(), 0);
      } catch (Throwable var9) {
         var10 = 4159204;
      }

      this.waterTint = 0xFF000000 | (var10 == -1 ? 4159204 : var10);
   }
}
