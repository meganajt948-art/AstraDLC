package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.EndMain;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class fug {
   private static final List<Entity> fuh = new ArrayList<>();
   private static final String[] fui = new String[]{
      a.c(1067002255, "⧖偛\uda85䓬켧䦁\uf3e5稂\ue45e"),
      a.c(-1583623650, "퉘ꯏℏ뽱㒻눉ࡋ膩ῡ镛ኒ\ue8d1昲ﾘ症\uf33d䥸욾"),
      a.b("围⽾ꖪ㯃뀪㚼賷ԙ魜ᇷ阯汐\ue28e", 1994938026),
      a.b("塢⇨ꬲ㕆뺐㠶艟இ闗Ὤ風", -1766893510)
   };
   private static int fuj;
   private static int fuk;
   private static int ful;
   private static boolean fum;

   private fug() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfx var2 = Flow.getInstance().getModuleManager();
      if (!fum) {
         fum = true;
         WorldRenderEvents.END_MAIN.register((EndMain)var0x -> fuj++);
      }

      if (var1 >= 40 && fuj - fuk >= 6) {
         fuk = fuj;
         switch (ful++) {
            case 0:
               fut(var0, 0.0F, 8.0F);
               var0.player.getInventory().setSelectedSlot(0);
               var0.player.getInventory().setStack(0, new ItemStack(Items.DIAMOND_SWORD));
               fuh.add(fuu(var0, a.d("ロ䥷쎯巖형", 960297345, 1409009964), 5.0, 1.8, false));
               fuh.add(fuu(var0, a.b("䝲㻧됷⩓ꆜ", 433932092), 4.0, -0.6, false));
               fuh.add(fuu(var0, a.d("켕뚃㱝ꈭ⧽꽆", -777661067, -532407772), 7.0, -0.9, false));
               fuh.add(fuu(var0, a.d("읍뻓㐇ꩪ↺", 1342501231, 279328352), 6.0, 3.6, true));
               fuh.add(fuu(var0, a.c(970955697, "鯠\ue267梹\uf6c8紖ﮦ"), 10.0, -4.5, false));
               hhf.add(a.d("⺷圢\uddf2䎖졙", 636813956, 56831101));
               break;
            case 1:
               fuw(var0, a.d("趜\uf43b绶\ue0d2歘\uedf5垫\ude52䀊", -693882087, -758530308));
               fuq(var2, a.d("㲽䔰쿮冇\uda4c峪\ue68e潩\uf135", -1227632877, 1779495927), true);
               break;
            case 2:
               fuw(var0, a.c(-1322512275, "ဒ榵\ue378絜\uf6c3灤쨴䎘\udd85圮탼⪕ꑇ㷱랩"));
               kfe var9 = var2.getByName(a.c(417098145, "槸ၵ骫ӂ載য돋㨬ꑰ"));
               fur(var9, a.d("\ue119颃ቓ谺", 1747105783, -2122950995), 1.0);
               fur(var9, a.d("\uf6fe轤ִ鯝ၝ隿\u2cf6ꔔ㭔", 678944814, 930682526), 1.0);
               fur(var9, a.c(670007112, "缊ڔ豂ሳ"), 0.3);
               fur(var9, a.d("揭ᩢ邼ໝ蔖", 1572968588, 1207302963), 3.0);
               break;
            case 3:
               fuw(var0, a.d("偖⧱ꌼ㴘뚇〠詰Ϝ鷝ᝫ邾櫒\ue404綼", 1152760797, -843518987));
               ((vlv)fus(var2.getByName(a.b("㊭䬠쇾得표勺\ue89e慹Ｅ", 182072052)), a.b("쥅냖㨎ꑾ", 257673484))).set(a.b("瘀ྜ蕘", 888698433));
               break;
            case 4:
               fuw(var0, a.c(-541321656, "ᘳ澔\ue559筽\uf0e2癅찕䖹\udba9儕훑"));
               fuq(var2, a.d("瘍ྀ蕞ᬷ郼ᙚ갾◙뮅", -978191945, -875720733), false);
               fuq(var2, a.d("븨잿䵿팁壋\ude79搻\uedd9玑狼绢蒡ੂ鏨ᦷ齍┈\uaace", 1284447576, -576871626), true);
               break;
            case 5:
               fuw(var0, a.b("紫Ҍ蹁ၥ鯹ᵜ꜔⻩낽㨆붜䟶줧", -1535214250));
               fur(var2.getByName(a.c(-146315481, "条Ỷ鐶ੈ膂ܰ뵲㒐\uaad8\u2062Ɜ巨팋䪡샾䘄ﱁ率")), a.b("먳쎤䥤휚峐\uda62怠\ue9c2瞊ﴰ竮肅", -2015249813), 1.0);
               break;
            case 6:
               fuw(var0, a.b("湺៝鴐̴袨ญ둅㶸ꏬ⥗껍咠\uda76䏇", -1967821308));
               fur(var2.getByName(a.b("몸쌯䧯힑屛\udae9悫\ue949省ﶻ穲耱໒靸ᴧ鯝↘깞", -1368933634)), a.d("㶜䐋컋債\udb7f巍\ue78f湭\uf025窟﵁ܪ", 1813872263, -2068167869), 0.0);
               break;
            case 7:
               fuw(var0, a.b("䜭㺊둇⩣ꇿ❚鴒ᓯ誻\u0000螚緶", 724649809));
               fur(var2.getByName(a.b("䗨㱿뚿⣁ꌋ▹鿻ᘙ衑˫蔢罡\uf182栨\ue277撍\udec8儎", -365541970)), a.b("彄⛓갓㉭릧㼕蕗ವ鋽ᡇ龙旲", 1150246684), 0.6);
               fuq(var2, a.d("鲖\ue51c濈\uf1a1穈ﳞ䚕콻儾\udb95屍\ua632⣬", 455276542, 2108320566), true);
               break;
            case 8:
               fuw(var0, a.b("ﴖ蒱\u0e7c遘ᯋ鵽✶께ゝ먶㷮작䥏", -1417413269));
               kfe var8 = var2.getByName(a.d("蕨ﳥ瘻\ue852掙\ue53f彛횼䣠", -286340712, 163597481));
               ((vlv)fus(var8, a.c(1570457914, "䥳ム머⑈"))).set(a.b("㩁䏊줘坱\udca3娕\ue04d", 534592009));
               fur(var8, a.b("갱햫彻섒", 1817554034), 0.5);
               fur(var8, a.b("䉠㯺넪⽃꓃∡顨ᆊ迊", 1108951598), 0.5);
               fur(var8, a.d("糂՜辊ᇻ", 478831465, -586342423), 0.1);
               fur(var8, a.c(1162242021, "枷Ḹ铦ઇ腌"), 1.5);
               fuq(var2, a.b("廏❂궜㏵렾㺘蓼ഛ鍇", -1621074282), true);
               break;
            case 9:
               fuw(var0, a.d("ݽ绚\uf417樳\ue1a8朔\udd47", -1756306687, 1900798987));
               fuq(var2, a.b("۠罪\uf5b0毄\ue012暴\udcdd唅쭕䇮옪", -277477704), true);
               break;
            case 10:
               fuw(var0, a.b("饔\ue0f3樾\uf41a羈擄䍬쪗哟", 1960024365));
               break;
            default:
               for (String var6 : fui) {
                  fuq(var2, var6, false);
               }

               for (Entity var10 : fuh) {
                  var0.world.removeEntity(var10.getId(), RemovalReason.DISCARDED);
               }

               fuh.clear();
               hhf.remove(a.d("㷷䑢캲僖\udb19", -1579901925, -658398814));
               var0.player.getInventory().setStack(0, ItemStack.EMPTY);
               izx.TARGET.enabled.set(true);
               return true;
         }

         return false;
      } else {
         if (var1 == 1) {
            fup(var0, var2);
         }

         return false;
      }
   }

   private static void fup(MinecraftClient var0, kfx var1) {
      for (String var5 : fui) {
         fuq(var1, var5, false);

         for (vmo var7 : var1.getByName(var5).getSettings()) {
            if (var7 instanceof vmc var8) {
               var8.reset();
            } else if (var7 instanceof vlv var9) {
               var9.reset();
            }
         }
      }

      fuv(var0, a.c(-619295671, "䰿㖈뽗℮꫱ⱂ阚Ὺ臰ଂ賀皦\uf875懑\ueb9f浱휭"));
      fuv(var0, a.d("ꙧ\udfcb唜쭥䃷옕籐\uf5b0殻\ue11c曉鲸ቯ", -1507915741, 373665341));
      fuv(var0, a.d("㸻䞘쵏匫\ud8e0幜\ue418涻\uf3a7礙ﻃҶ該", -1082592760, 813288521));
      fuv(var0, a.b("ⶶ合\udede䂯쬴䷛\uf7db縱\ue078檗\ued1a᜵馮\r言ಹ뛠㥯ꎑ◓걺홤壒쌗䔥쿰癄\uf81e拯\ue4af漏釙ᮄ舻г躊ㅆ", -785240587));
      fuv(var0, a.c(1211504919, "ᥔ惪\uea3c瑍ￖ礹쌧䫅퓄師\ud9a6⎑굞㒱뺪㡍艜ශ靠ᅯ飞\ue297汩\uf7bc燄ﬞ䊫쳫嘏큙寸ꕧ⽡뚗ミ멯ֳ"));
      izx.TARGET.enabled.set(false);
   }

   private static void fuq(kfx var0, String var1, boolean var2) {
      var0.getByName(var1).setEnabled(var2);
   }

   private static void fur(kfe var0, String var1, double var2) {
      ((vmc)fus(var0, var1)).set(var2);
   }

   private static vmo fus(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.c(404436688, "㛸企엛宸퀼囃\uec91支") + var1);
   }

   private static void fut(MinecraftClient var0, float var1, float var2) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
   }

   private static PlayerEntity fuu(MinecraftClient var0, String var1, double var2, double var4, boolean var6) {
      OtherClientPlayerEntity var7 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var8 = var0.player.getEntityPos().add(new Vec3d(0.0, 0.0, 1.0).multiply(var2)).add(new Vec3d(-1.0, 0.0, 0.0).multiply(var4));
      var7.refreshPositionAndAngles(var8.x, var0.player.getY(), var8.z, 180.0F, 0.0F);
      var7.setBodyYaw(180.0F);
      var7.setHeadYaw(180.0F);
      var7.lastBodyYaw = 180.0F;
      var7.lastHeadYaw = 180.0F;
      var7.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
      var7.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
      var7.setInvisible(var6);
      var0.world.addEntity(var7);
      return var7;
   }

   private static void fuv(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   private static void fuw(MinecraftClient var0, String var1) {
      System.out
         .println(a.b("닓쭴䆮\udfd5呄튡棣\ue104罜\uf5b9", -2106674518) + var1 + a.b("\u086d熼\ufb0f", -1435236274) + var0.getCurrentFps() + a.c(-1494075902, "㘦俑씔学"));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.d("橫Ꮠ餀ݩ賻\u0a55", -458814974, -1054515191) + var1 + a.d("嬙⋶\ua83b㙃", -1358663236, 183184015),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
