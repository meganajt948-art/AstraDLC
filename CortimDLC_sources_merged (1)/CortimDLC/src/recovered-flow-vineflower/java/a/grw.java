package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.InactivityFpsLimit;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class grw {
   static final String[] grx = new String[]{
      a.b("鈼\uebb8慸＜瓉\uf269䠋쇬徰", -1853123999),
      a.c(-226916625, "蚡Ｍ痯\ueb96恩\ue6ce岞"),
      a.b("曒Ὄ間௪耬ڈ볝㔸", 408970900),
      a.b("趃\uf410绔\ue0a4歾\uedc5垁\ude6d䀴쪄䵊", -679375400),
      a.c(1961655275, "箬Ȯ製ᚑ鵞ᯫ"),
      a.b("\uec4e闑ἁ腼ણ谶㙟뾯⇨ꭜⲈ훲", 1774382080),
      a.c(-1211053333, "쪡댾㧮ꞓⱌ\uaad3႖饤"),
      a.b("㝖仛쐅婬톧圁\ued65撂\ufade", 1040463631),
      a.c(-1055867935, "뮧숰䣰횎嵄\udbf6憴\ue856瘞ﲤ筭脮\u0fcd陧\u1c38髂₇꽁"),
      a.b("쿉뙇㲌ꋠ⤄꾟ᗗ鰷ɧ裟༚", -1509830776),
      a.d("选\ue984捍ﴥ盛\uf07c䨬", 752462177, 62732604),
      a.d("፨櫢\ue038繌\uf59a猼쥕䂍\udedd呦펢", -1125916194, -286854418),
      a.d("覉\uf007竘\ue4bb潖\ue9c5厝\uda6d䐻", 1581976532, 1096385026),
      a.c(30929469, "\uf27d语ģ齥ᒞ鈬⡼ꆐ"),
      a.c(1064544947, "\uaafa퍠妺쟞䰩쪻烺羅杚\uedf3"),
      a.c(-689713143, "큔꧞⌐뵸㚨뀗\u0a53莀᷽靛ႛ\ueaf5搮ﶍ")
   };
   static final String[][] gry = new String[][]{
      new String[0],
      {a.c(-1996219661, "᪪挧\ue9f9瞐ﱛ竽삙䥾휢")},
      {a.d("힚긗Ⓣ몠ㅫ럍ඩ葎ᨒ", 1152539954, 743738097)},
      new String[0],
      {a.d("\udaa0ꌭ⧳랚㱑뫷\u0093襴ᜨ", -1580600793, 1931028702)},
      {a.d("꿒홟岁싨䤣쾅痡ﰆ扚", 1071476880, -2131566821)},
      new String[0],
      {a.b("\u245c巑휏䥦슭䐋\ufe6f瞈\ue9d4", -469818363), a.c(337061205, "┓岍홒䠫쏭䕉＜盹")},
      grx,
      new String[0]
   };
   static final Set<Integer> grz = Set.of(2, 5);
   static final Set<Integer> gsa = Set.of();
   static final int gsb = 100;
   static final List<Entity> gsc = new ArrayList<>();
   static long gsd;
   static long gse;
   static boolean gsf;

   grw() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfx var2 = Flow.getInstance().getModuleManager();
      if (var1 == 1) {
         gsj(var0, a.d("㒗䴠쟿妆퉙哪\ueeb2杂菱玪\uf468ฎ胝\u1979錷ᗙ꾅", -1829215174, 537809115));
         gsj(var0, a.c(963842908, "ጥ檉\ue05e縧\uf5b5獗줒䃲\udef9呞펋⧺ꜭ"));
         var0.player.setYaw(0.0F);
         var0.player.setPitch(10.0F);

         for (int var3 = 0; var3 < 14; var3++) {
            double var4 = var3 * 0.45;
            gsc.add(gsi(var0, a.b("覅", 1239910868) + var3, 25.0 + var3 * 1.5 * Math.cos(var4), 6.0 * Math.sin(var4)));
         }

         hhf.add(a.c(-748082992, "⢂児"));
         ruv.onAttack(gsc.get(0));

         for (int var12 = 0; var12 < 8; var12++) {
            gsj(
               var0,
               a.d("\ud87bꇌ⬇땶㺣렓Ȏ讲ᗩ齟ᢇ\ue2f0氶\uf594翀藍䌢철嘎큎妱⎭굀", -1565602536, 1064244487)
                  + (var12 - 4)
                  + a.b("萡\ufdce睓\ue93c拰\ue454幙", -645692410)
                  + (5 + var12 % 3)
                  + a.b("붜쑶亗탛嬝\udda4枠\uee10灝\ufae1絬蜅ঝ逨᩼鲆⛏ꤏ㎯뗹㰜䘃죮匲핅徘\ue629桹\uf284璓Ｎư诳መ鑐ỻꅢ", -1788822119)
                  + (var12 + 1)
                  + a.c(-1639075978, "꼟훿屐수䧅콼由ﳅ抮\ue83e濤閘᭗芥ࣿ踏㑅뮕℧Ꜽ")
            );
         }

         gsj(var0, a.d("篵ɋ袝᛬鵷ᮘꆘ⡲똻㳔뭔䄻쿿嘐\udc05嫬\ue0fd潤\uf5c1珎頻耧\u0e85锊ጺ駮⁉깕㒦닰㥈잟䷁퐣剷\ud8d4杍\ued62殼\uf205硖ڥ賷ୌ醠ῡ\ua62fⲉ", -1222931860, 682750415));
         var0.player.getInventory().setStack(0, new ItemStack(Items.ENDER_PEARL, 16));
         var0.player.getInventory().setSelectedSlot(0);
         var0.options.getInactivityFpsLimit().setValue(InactivityFpsLimit.MINIMIZED);
         if (!gsf) {
            gsf = true;
            HudRenderCallback.EVENT.register((HudRenderCallback)(var0x, var1x) -> gsd++);
         }
      }

      if (var1 > 20 && var1 <= 20 + 100 * gry.length) {
         int var13 = (var1 - 21) / 100;
         int var16 = (var1 - 21) % 100;
         if (var16 == 0) {
            List var5 = List.of(gry[var13]);
            boolean var6 = !var5.isEmpty();
            ukl.noScissor = grz.contains(var13);
            ukl.devMode = gsa.contains(var13) ? 1 : (grz.contains(var13) ? 2 : 0);

            for (String var10 : grx) {
               kfe var11 = var2.getByName(var10);
               if (var11 != null) {
                  var11.setEnabled(var5.contains(var10));
               }
            }

            if (var6 && var0.player.isOnGround()) {
               var0.player.jump();
            }
         } else if (var16 == 20) {
            gsd = 0L;
            gse = System.nanoTime();
            if (var13 == 1 || var13 == 2) {
               ScreenshotRecorder.saveScreenshot(
                  var0.runDirectory, a.d("懊ᡱ銡ೈ蝚Ǵ믺㈞걖⛳ꅫ孒햓䰡옯", 200820232, 1278093227) + var13 + a.c(573334041, "戳ᯜ鄑ཀྵ"), var0.getFramebuffer(), 1, var0x -> {}
               );
            }
         } else if (var16 == 99) {
            double var19 = (System.nanoTime() - gse) / 1.0E9;
            String var22 = gry[var13].length == 0
               ? a.d("\uf6fd轅֖", -1479661058, 463069039)
               : (
                  gry[var13] == grx
                     ? a.c(-84850699, "䞗㸫듸")
                     : String.join(a.c(-1642051974, "䙐"), gry[var13])
                        + (grz.contains(var13) ? a.c(20097405, "\ua957탮婺쐈俗줢猦贈撆\uee67") : "")
                        + (gsa.contains(var13) ? a.c(2007089533, "셊룳㉾갘⟀ꅶᬠ鋑ಃ虳ǯﮄ畒\uecfb暭\ue05b娟햋佷줧䃒㪖둵") : "")
               );
            System.out
               .println(
                  a.d("\ue9ab透᫋蒮༿", -519932977, 691837457)
                     + var22
                     + a.c(-628159723, "ଭ犆")
                     + String.format(Locale.ROOT, a.d("垶⸌꓃㫦", 824613083, -1516515508), var19 * 1000.0 / Math.max(1L, gsd))
                     + a.b("㚟佣얮它퀝嚸\uecf8攅ﭒ熦\uf67d", 1289696948)
                     + Math.round(gsd / var19)
                     + a.d("橈Ꮏ饺܈貅", 1742544855, 1514173882)
               );
         }
      }

      if (var1 <= 20 + 100 * gry.length) {
         return false;
      }

      ukl.noScissor = false;
      ukl.devMode = 0;

      for (String var21 : grx) {
         kfe var23 = var2.getByName(var21);
         if (var23 != null) {
            var23.setEnabled(false);
         }
      }

      for (Entity var18 : gsc) {
         var0.world.removeEntity(var18.getId(), RemovalReason.DISCARDED);
      }

      gsc.clear();
      hhf.remove(a.b("㾋䙙", -1709162535));
      gsj(var0, a.c(-398590876, "ﰝ薮ླྀ鄉᪒鱃☵꿺ㆊ묶㳬욈䠇퇢宬\udd4c朋\ue8ea"));
      gsj(var0, a.c(126412072, "\ue564鳚ᘌ衽Ϧ蔉㼉뛣⢪ꉅ◅\udfaa兮좁䊔쑽繬\uf1f5歐\ued5f擻Ặ途\u0b9b趫ݿ뻘ツ\uaa37ⱡꟙ夎퍐䪲쳦䙅隆珤\uf530沚\ue6c4頾"));
      return true;
   }

   static Entity gsi(MinecraftClient var0, String var1, double var2, double var4) {
      OtherClientPlayerEntity var6 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var7 = var0.player.getEntityPos().add(-var4, 0.0, var2);
      var6.refreshPositionAndAngles(var7.x, var0.player.getY(), var7.z, 180.0F, 0.0F);
      var6.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
      var6.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
      var6.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
      var0.world.addEntity(var6);
      return var6;
   }

   static void gsj(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
