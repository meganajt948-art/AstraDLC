package a;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.dev.a;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

final class gwv {
   private static final AtomicInteger gww = new AtomicInteger();
   private static qdz gwx;
   private static final tel gwy = new tel();
   private static final qmh gwz = new qmh();
   private static BlockPos gxa;
   private static volatile BlockPos gxb;
   private static int gxc = -1;

   private gwv() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      ClientPlayerEntity var2 = var0.field_1724;
      if (var1 == 1) {
         var0.field_1690.field_1837 = false;
         var0.method_1562().method_45730(a.d("퓡굖➉맰㈯뒜ໄ蜴\u192e鏌ᐙ\uee6f悼裸獞\uf5b8俺", 1271200836, -182769453));
         BlockPos var3 = var2.method_24515();
         gxa = var3.method_10069(4, 0, 3);
         var0.method_1576().execute(() -> {
            IntegratedServer var3x = var0.method_1576();
            ServerWorld var4x = var3x.method_30002();

            for (int var5 = -2; var5 <= 7; var5++) {
               for (int var6 = -2; var6 <= 6; var6++) {
                  var4x.method_8501(var3.method_10069(var5, -1, var6), Blocks.field_10340.method_9564());

                  for (int var7 = 0; var7 <= 2; var7++) {
                     var4x.method_8501(var3.method_10069(var5, var7, var6), Blocks.field_10124.method_9564());
                  }
               }
            }

            var4x.method_8501(gxa, Blocks.field_10563.method_9564());
            var3x.method_3734().method_9235().register((LiteralArgumentBuilder)CommandManager.method_9247(a.c(2116723422, "ꊮ\udb05凋")).executes(var0xx -> {
               ServerPlayerEntity var1xx = ((ServerCommandSource)var0xx.getSource()).method_9207();
               gww.incrementAndGet();
               gxb = var1xx.method_24515();
               ArmorStandEntity var2xx = new ArmorStandEntity(var1xx.method_51469(), var1xx.method_23317(), var1xx.method_23318() - 0.3, var1xx.method_23321());
               var2xx.method_5648(true);
               var2xx.method_5875(true);
               var1xx.method_51469().method_8649(var2xx);
               var1xx.method_5873(var2xx, true, true);
               return 1;
            }));
            ServerPlayerEntity var8 = var3x.method_3760().method_14566(var2.method_5477().getString());
            var3x.method_3760().method_14576(var8);
         });
      }

      if (var1 == 30) {
         gwx = new qdz();
         gwx.onSit(() -> var0.method_1562().method_45730(a.d("溯ᜄ鷊", 1057153687, 1625656392)));
         gwx.park(pzc.empty(gxa), gxa, true);
         System.out
            .println(
               a.d("恀᧫錥ഀ蚃#멦㎐궁✪ꂪ嫜퐞䶧쟯䄟ﬃ璓\uee35栰", 1777071297, -681011994)
                  + gxa.method_23854()
                  + a.b("ࡗ燪ﭩ攄\ueede桷툸寞엓伣죥㋀", -630519689)
                  + var2.method_24515().method_23854()
            );
      }

      if (gwx != null && gxc < 0) {
         gwy.newTick();
         gwy.use(tck.profile1());
         gwy.tune(1.0, 1.0, 1.0);
         gwy.cap(0.0);
         gwz.cap(110.0);
         gwx.configure(gwz, false, false);
         gwx.startTick(var0, var2);
         gwx.endTick(var0, var2, gwy);
         if (var1 % 10 == 0) {
            System.out
               .println(
                  a.b("\ud847ꇬ⬢딇㺄려ɡ讗ᖜ齹ᣣ", 1533597759)
                     + var1
                     + a.d("㱓䖲콾儓\uda8a", 1269333822, -228506808)
                     + var2.method_24515().method_23854()
                     + a.c(1955799927, "⍟媾큼丞에䍯綠炕")
                     + gwx.parked()
                     + a.c(1510448127, "鯖\ue231棱\uf68d絛ﯠ䆼졄噃")
                     + var2.method_5765()
                     + a.d("肴稜玟\uedf3昣\ue0dc", -1365753403, 1041678679)
                     + gww.get()
               );
         }

         if (var2.method_5765()) {
            gxc = var1;
            gwx.stop(var0);
         }
      }

      if ((gxc <= 0 || var1 != gxc + 10) && var1 <= 530) {
         return false;
      } else {
         boolean var4 = gxc > 0 && gww.get() >= 1 && gxb != null && (gxb.equals(gxa) || gxb.equals(gxa.method_10084()));
         System.out
            .println(
               a.d("캄뜯㷡ꏄ⡇껧ᒢ鵔ͅ觮า\uf41f竒\ue37e楹\uefdb喂\uda58䃱웴", -221304489, -126359628)
                  + gww.get()
                  + a.d("\uf479趜݃饡\u12b1鐛⹈Ʝ㦩덙㒟캺", -849370414, 2022332127)
                  + (gxb == null ? a.b("兩", -56231596) : gxb.method_23854())
                  + a.d("据\u1ad7遟ษ藫͒뤚リ껦", 1856133228, 2128100139)
                  + gxa.method_23854()
                  + a.d("拪", 462614382, -1590325844)
            );
         System.out.println(a.c(383882426, "铀\ued6b枥呂爃\uf4a3仦윐夛") + (var4 ? a.b("䵇㓧븦⁗", -2077405933) : a.b("璶ഀ蟛\u19af", -2048035596)));
         if (gwx != null) {
            gwx.stop(var0);
         }

         return true;
      }
   }
}
