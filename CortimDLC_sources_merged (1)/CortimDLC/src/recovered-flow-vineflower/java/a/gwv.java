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
   static final AtomicInteger gww = new AtomicInteger();
   static qdz gwx;
   static final tel gwy = new tel();
   static final qmh gwz = new qmh();
   static BlockPos gxa;
   static volatile BlockPos gxb;
   static int gxc = -1;

   gwv() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      ClientPlayerEntity var2 = var0.player;
      if (var1 == 1) {
         var0.options.pauseOnLostFocus = false;
         var0.getNetworkHandler().sendChatCommand(a.d("퓡굖➉맰㈯뒜ໄ蜴\u192e鏌ᐙ\uee6f悼裸獞\uf5b8俺", 1271200836, -182769453));
         BlockPos var3 = var2.getBlockPos();
         gxa = var3.add(4, 0, 3);
         var0.getServer().execute(() -> {
            IntegratedServer var3x = var0.getServer();
            ServerWorld var4x = var3x.getOverworld();

            for (int var5 = -2; var5 <= 7; var5++) {
               for (int var6 = -2; var6 <= 6; var6++) {
                  var4x.setBlockState(var3.add(var5, -1, var6), Blocks.STONE.getDefaultState());

                  for (int var7 = 0; var7 <= 2; var7++) {
                     var4x.setBlockState(var3.add(var5, var7, var6), Blocks.AIR.getDefaultState());
                  }
               }
            }

            var4x.setBlockState(gxa, Blocks.OAK_STAIRS.getDefaultState());
            var3x.getCommandManager().getDispatcher().register((LiteralArgumentBuilder)CommandManager.literal(a.c(2116723422, "ꊮ\udb05凋")).executes(var0xx -> {
               ServerPlayerEntity var1xx = ((ServerCommandSource)var0xx.getSource()).getPlayerOrThrow();
               gww.incrementAndGet();
               gxb = var1xx.getBlockPos();
               ArmorStandEntity var2xx = new ArmorStandEntity(var1xx.getEntityWorld(), var1xx.getX(), var1xx.getY() - 0.3, var1xx.getZ());
               var2xx.setInvisible(true);
               var2xx.setNoGravity(true);
               var1xx.getEntityWorld().spawnEntity(var2xx);
               var1xx.startRiding(var2xx, true, true);
               return 1;
            }));
            ServerPlayerEntity var8 = var3x.getPlayerManager().getPlayer(var2.getName().getString());
            var3x.getPlayerManager().sendCommandTree(var8);
         });
      }

      if (var1 == 30) {
         gwx = new qdz();
         gwx.onSit(() -> var0.getNetworkHandler().sendChatCommand(a.d("溯ᜄ鷊", 1057153687, 1625656392)));
         gwx.park(pzc.empty(gxa), gxa, true);
         System.out
            .println(
               a.d("恀᧫錥ഀ蚃#멦㎐궁✪ꂪ嫜퐞䶧쟯䄟ﬃ璓\uee35栰", 1777071297, -681011994)
                  + gxa.toShortString()
                  + a.b("ࡗ燪ﭩ攄\ueede桷툸寞엓伣죥㋀", -630519689)
                  + var2.getBlockPos().toShortString()
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
                     + var2.getBlockPos().toShortString()
                     + a.c(1955799927, "⍟媾큼丞에䍯綠炕")
                     + gwx.parked()
                     + a.c(1510448127, "鯖\ue231棱\uf68d絛ﯠ䆼졄噃")
                     + var2.hasVehicle()
                     + a.d("肴稜玟\uedf3昣\ue0dc", -1365753403, 1041678679)
                     + gww.get()
               );
         }

         if (var2.hasVehicle()) {
            gxc = var1;
            gwx.stop(var0);
         }
      }

      if ((gxc <= 0 || var1 != gxc + 10) && var1 <= 530) {
         return false;
      }

      boolean var4 = gxc > 0 && gww.get() >= 1 && gxb != null && (gxb.equals(gxa) || gxb.equals(gxa.up()));
      System.out
         .println(
            a.d("캄뜯㷡ꏄ⡇껧ᒢ鵔ͅ觮า\uf41f竒\ue37e楹\uefdb喂\uda58䃱웴", -221304489, -126359628)
               + gww.get()
               + a.d("\uf479趜݃饡\u12b1鐛⹈Ʝ㦩덙㒟캺", -849370414, 2022332127)
               + (gxb == null ? a.b("兩", -56231596) : gxb.toShortString())
               + a.d("据\u1ad7遟ษ藫͒뤚リ껦", 1856133228, 2128100139)
               + gxa.toShortString()
               + a.d("拪", 462614382, -1590325844)
         );
      System.out.println(a.c(383882426, "铀\ued6b枥呂爃\uf4a3仦윐夛") + (var4 ? a.b("䵇㓧븦⁗", -2077405933) : a.b("璶ഀ蟛\u19af", -2048035596)));
      if (gwx != null) {
         gwx.stop(var0);
      }

      return true;
   }
}
