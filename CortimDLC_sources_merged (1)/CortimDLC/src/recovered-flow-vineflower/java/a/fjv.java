package a;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

final class fjv {
   private static final List<List<fjo>> fjw = new ArrayList<>();
   private static final List<List<fjo>> fjx = new ArrayList<>();
   private static final List<String> fjy = new ArrayList<>();
   private static int fjz;
   private static int fka;
   private static int fkb;

   private fjv() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      if (var1 == 1) {
         fkg(var0);
      }

      if (var1 == 10) {
         for (pdr var3 : pej.items()) {
            var3.setActive(
               var3.name().equals(a.c(1127711615, "蝦\ufefe琨\uea5c懷\ue73a嵢킆䪶쁹䞠뷔㌇ꪲ"))
                  || var3.name().equals(a.d("霯\uee82搭飼燵\uf358䴚쓯嫄큵埛궣⌁몲゛똝", -1547564320, 2030541309))
            );
         }

         for (String var5 : new String[]{a.d("\ue86a釅ᬑ蕪ຶ蠟㉣", 310237167, -1419755531), a.b("અ猪茶枅\uec59櫰킍", 1038486261)}) {
            Field var6 = hlc.class.getDeclaredField(var5);
            var6.setAccessible(true);
            var6.setFloat(null, Float.NaN);
         }

         var0.setScreen(new hlc());
      }

      if (var1 == 20) {
         hrt.open();
      }

      if (var1 == 40) {
         fkl(var0, a.c(1696401020, "؏羲\uf562欓\ue0cd智\udc3e嗔쮖䅸웣㲓뉉⯥ꆭ❁"));
         var0.setScreen(null);
      }

      if (var1 == 60) {
         kfe var8 = fke();
         var8.setEnabled(true);

         for (vmo var14 : var8.getSettings()) {
            if (var14 instanceof vkw var16 && var16.getName().equals(a.b("瘴\u0fbd蕳ᬛ", 86472295))) {
               var16.buttons().get(0).action().run();
            }
         }

         fkb = var1;
      }

      if (var1 == 220) {
         fkk(var0);
      }

      if (fkb > 0 && var0.currentScreen instanceof GameMenuScreen) {
         var0.setScreen(null);
      }

      if (var1 > 60 && var1 % 100 == 0) {
         System.out
            .println(
               a.c(-2021947974, "藈ﱵ皥\ue8d4挊\ue5bd忹혓䡑슲䔵뽕㆔ꠢ∥ꒀẆ")
                  + var1
                  + a.d("㲪䕚쾘凩\uda22岚\ue6df潠", -1049685970, -754111316)
                  + fkf(var0, Items.GOLDEN_APPLE)
                  + a.b("㔁䳤올塆펀唹\uef74曋", 1608332585)
                  + fkf(var0, Items.TOTEM_OF_UNDYING)
                  + a.c(1285554454, "ľ磌\uf210汤\ue7b9愀\udb4b勴")
                  + fjz
                  + a.b("\uf72b軉Ќ驹ᆽ霝ⵅ꒹㫰뀏", 1173812993)
                  + fka
            );
      }

      boolean var9 = fkf(var0, Items.GOLDEN_APPLE) >= 16 && fkf(var0, Items.TOTEM_OF_UNDYING) >= 1 && var0.currentScreen == null && mkl.collecting() == null;
      if (fkb > 0 && (var9 || var1 > 2460)) {
         for (String var15 : fjy) {
            System.out.println(a.c(-1205244786, "泼ᕁ龑Ǡ訾ಉ뛍㼧ꅥ⮆갗噫\ud8a6䄅쭙䶴\uf7af") + var15);
         }

         boolean var13 = fjy.size() == 2
            && fjy.contains(a.d("\udb1aꊣ⡳똊㷜뭦Ą裋ᚅ鰴\u1bfb\ue183漑\uf6f8糢﨔䁍쿼唺퍮", -106870202, -771649233))
            && fjy.contains(a.c(-1779214859, "喙ⰳ\ua6fb㢛덄㗇辤ٜ頺ኡ镩漒\ue1d8硹\uf22d瓕컝䅔\udbae差푹깚⃫묺"));
         System.out
            .println(
               a.d("㰩䖔콄儵\udaeb屜\ue618濲\uf1b0筓ﳔڴ衵ᇃ鯄", -1763079091, -1473007608)
                  + (var13 ? a.b("䷞㑾뺿\u20ce", 1075006858) : a.d("想᥅鎞෪", -1889157236, -664346819))
                  + a.d("㓏䴷쟣姜", -967650387, 1239410502)
                  + (var1 - fkb) / 20.0
                  + a.d("ߓ縱\uf4bd櫀\ue154柪\uddbc呇쨐䂹윤", 1152220038, -1171489666)
                  + fjz
                  + a.c(1429745722, "【䧲쌷嵂횆倦\uea7e掂\ufdcb眴")
                  + fka
            );
         fke().setEnabled(false);
         return true;
      } else {
         return false;
      }
   }

   private static kfe fke() {
      for (kfe var1 : Flow.getInstance().getModuleManager().getModules()) {
         if (var1.getName().equals(a.d("䇀㡅늗⳽꜆↛鯋ሺ豬ۛ脟筵\uf5bf", -477235129, -1691174453))) {
            return var1;
         }
      }

      throw new IllegalStateException(a.d("㴟䒯츳倣\udbc0嵰\ue738滥\uf096稤ﷷޏ襞ჸ骰ᱜ", 411646939, -270465350));
   }

   private static int fkf(MinecraftClient var0, Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 41; var3++) {
         ItemStack var4 = var0.player.getInventory().getStack(var3);
         if (var4.isOf(var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   private static void fkg(MinecraftClient var0) {
      var0.options.pauseOnLostFocus = false;
      fjw.clear();
      fjw.add(List.of(new fjo(Items.GOLDEN_APPLE, 16, 100, false), new fjo(Items.GOLDEN_APPLE, 8, 90, false), new fjo(Items.DIAMOND, 1, 5, false)));
      fjw.add(List.of(new fjo(Items.GOLDEN_APPLE, 16, 80, false), new fjo(Items.GOLDEN_APPLE, 64, 10, false)));
      fjw.add(List.of(new fjo(Items.GOLDEN_APPLE, 16, 50, false), new fjo(Items.GOLDEN_APPLE, 16, 120, false)));
      fjx.clear();
      fjx.add(List.of(new fjo(Items.TOTEM_OF_UNDYING, 1, 5, true), new fjo(Items.TOTEM_OF_UNDYING, 1, 300, false)));
      fjx.add(List.of(new fjo(Items.TOTEM_OF_UNDYING, 1, 200, false)));
      fjy.clear();
      var0.getServer()
         .execute(
            () -> var0.getServer()
               .getCommandManager()
               .getDispatcher()
               .register(
                  (LiteralArgumentBuilder)CommandManager.literal(a.c(-394057898, "✵庍"))
                     .then(
                        CommandManager.literal(a.c(1943436757, "綠Ї軐Ⴒ魴᷎"))
                           .then(
                              CommandManager.argument(a.b("\udf93", -140714013), StringArgumentType.greedyString())
                                 .executes(
                                    var0xx -> {
                                       ServerPlayerEntity var1 = ((ServerCommandSource)var0xx.getSource()).getPlayerOrThrow();
                                       fka++;
                                       String var2 = StringArgumentType.getString(var0xx, a.b("珏", -860523585));
                                       List var3 = var2.toLowerCase().contains(a.b("\ud87dꆲ⭫딟㻌롹", -231809996))
                                          ? fjw
                                          : (var2.toLowerCase().contains(a.c(-307971912, "볿씲依톛婅")) ? fjx : new ArrayList());
                                       fkh(var1, var2, var3);
                                       return 1;
                                    }
                                 )
                           )
                     )
               )
         );
      var0.getNetworkHandler().sendChatCommand(a.b("\udf80\ua637⳨늑㥎뿽֥豕\u124f颭ὸ\ue50e毝\uf273砿ﻙ䒛", 1991761910));
      var0.getNetworkHandler().sendChatCommand(a.c(-1101271582, "\ued89鐷ử肘ଡ଼趿㞌빎"));
   }

   private static void fkh(ServerPlayerEntity var0, String var1, List<List<fjo>> var2) {
      var0.getEntityWorld()
         .getServer()
         .execute(
            () -> var0.openHandledScreen(
               new SimpleNamedScreenHandlerFactory(
                  (var2xx, var3, var4) -> new fjf(var2xx, var3, var1, var2), Text.literal(a.d("\ued0d铯ṅ聈\u0be1赖㜆뺁⒵꺟⧗", 948621306, 1188898540) + var1)
               )
            )
         );
   }

   private static ItemStack fki(fjo var0) {
      ItemStack var1 = new ItemStack(var0.item(), var0.count());
      var1.set(
         DataComponentTypes.LORE,
         new LoreComponent(
            List.of(
               Text.literal(a.d("鏇", -793090041, -862782495)),
               Text.literal(
                  a.d("薌ﲬ癭\ue818柉\ue53b嬰횝䢙숲䕦뿕", 1343909004, -1735202389) + String.format(a.c(149046876, "䙺㿂땙"), var0.price() * var0.count()).replace(',', ' ')
               ),
               Text.literal(a.d("ኟ殾\ue545筫\uf0c2癹찮䗝\udb85兇틨⢃꘧㾠뗺㌋襍ڋ", 372596788, -494767586))
            )
         )
      );
      if (var0.glint()) {
         var1.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
      }

      return var1;
   }

   private static ItemStack fkj(Item var0, String var1) {
      ItemStack var2 = new ItemStack(var0);
      var2.set(DataComponentTypes.CUSTOM_NAME, Text.literal(var1));
      return var2;
   }

   private static void fkk(MinecraftClient var0) {
      fkl(var0, a.b("\ue5b4鰉ᛙ袨Ͷ藁㾅뙯⠭ꋃ╜\udf39凸졞䈐쓧纩", -1050810938));
   }

   private static void fkl(MinecraftClient var0, String var1) {
      System.out.println(a.d("룋셬䮶헍幜\ud8b9拻\ueb1c畄ﾡ", -1257100161, -1836018483) + var1);
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(1705350918, "靦\ueedd損賓燶\uf758") + var1 + a.b("\ue0fe餑Ꮬ趤", -612441900),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
