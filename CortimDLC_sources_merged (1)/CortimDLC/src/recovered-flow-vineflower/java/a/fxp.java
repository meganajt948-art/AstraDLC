package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

final class fxp {
   static final int fxq = 40;
   static final int fxr = 120;
   static final int fxs = 200;
   static final int fxt = 280;
   static final int fxu = 360;
   static OtherClientPlayerEntity fxv;
   static int fxw;

   fxp() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfx var2 = Flow.getInstance().getModuleManager();
      kfe var3 = var2.getByName(a.b("딳첾䙷\ud81f叡핆漖", -2097236633));
      if (var1 == 1) {
         fyg(var0, a.b("\uf380訷è麑ᕎ鏽⦥ꁕ㹏뒽㍿줙䟊\ude6e吠틎梒", 1738470390));
         fyg(var0, a.b("齫\ue6c7氐\uf269移９䕜첼劷\ud810必ꖴ⭣", 1007001362));
         fyg(var0, a.c(1002655668, "俎㙭벺⋞ꤕ⾩闭ᱎ艒࣬輶畃ﮇ"));
         fyg(var0, a.c(2059212729, "៌湿\ue4a9竘\uf143瞒췤䐫\uda5b僧휽ⵙꏖ㨷끠㚖賒̅馧ῥ阕\uec56披鷺罐\uf583䰿쉥增\udef7"));
         fyg(var0, a.d("ℒ墬퉺䰋자䅿ﭿ犖\uecdc昳\ue1beᮑ销\u0ca9蚤\u001e멄㗋꼳⥷ꃞ\udac9呢쿾䦅썓竫\uf4bc湚\ue818掬鵯ᝮ軖ࢂ舨㷾랄ㅭ꣡⊮屄혝冤쭫", -2038915320, -1933132207));
         fyg(var0, a.b("쐠붞㝈ꤹ⊢ꑍṍ鞥৮茁ҝ\ufefd灴\ue983揈\ue567彻킴䨔찛䖡㿣넎⪙곾♢鿕ᆃ譿ന蚊硈\uf200毣\uedfe朇\ud8c7劷푟䷆잁륰㌠", -741161875));
         fyg(var0, a.c(-1161171553, "\uedd3鑭ẻ胊\u0b51趾㞠빂⁃ꪽ⵿흐姁쁨䩥쳞皅金援\ue5b6氟ᘈ颣̿蕄ྒ똪㡽ꊛⓙ꽭冮\udbaf䈆쑛仳\uf134筿ﶄ搭\uee72邀"));
         fyg(var0, a.d("ೆ畸ﾮ懟\uea44沫횫彆섈䯧챸㘛뢒Ⅵꬮⶁ鞁ᡁ芬ұ赔\uf75b禮\ue267摕\uee80圴\ud96e䎟엟乿납㫴ꍋ╅꿿ါ驂Ვ蔣ཧ熗\ufbcf", -1276858182, 1699068977));
         var0.options.setPerspective(Perspective.FIRST_PERSON);
         izx.TARGET.enabled.set(false);
         fyd(var3, a.d("ۏ罙\uf587毣\ue03d", 1073549776, -1348921527), a.d("鹷\ue7ed洳\uf350碇", -1888879784, 1472423277));
         fyd(var3, a.b("Ự杸\ueda7珐\uf801约", 1969692326), a.c(1151542322, "⑧巭휷䥕슔䐲"));
         ((vkl)fye(var3, a.c(1187056185, "\u0a79珩露杜\uecd2樮큩姁쟊䵮쪮ナ븟➿귫"))).set(false);
         ((vkl)fye(var3, a.c(21345384, "됡춲䝬\ud90c"))).set(true);
         var3.setEnabled(true);
      }

      if (var1 == 20) {
         fyf(var0, 0.0F, 12.0F);
      }

      if (var1 >= 40 && var1 < 280) {
         fyf(var0, 0.0F, 12.0F);
      }

      if (var1 == 34) {
         fxv = fyb(var0, a.d("淍ᑃ麚ü謶ඃ", -1956033962, -728487989), 3.6);
      }

      if (var1 == 38 && fxv != null) {
         fxv.swingHand(Hand.MAIN_HAND);
      }

      if (var1 == 40) {
         fya(fxv, false);
      }

      fxz(var0, var1, 40, a.b("㑛䷨윾奏", -720554956), new int[]{4, 10, 18, 27, 33, 44});
      if (var1 == 62) {
         fyc(var0, fxv);
      }

      if (var1 == 114) {
         fxv = fyb(var0, a.d("◭屧횯䣏쌐", -1442629553, -1582883341), 3.6);
      }

      if (var1 == 120) {
         fya(fxv, true);
      }

      fxz(var0, var1, 120, a.c(1899136404, "藥ﱏ皇\ue8e7挸"), new int[]{6, 18, 28, 40});
      if (var1 == 176) {
         fyc(var0, fxv);
      }

      if (var1 == 192) {
         fyd(var3, a.c(-1565606375, "빏쟇䴘퍯墾\ude19"), a.d("脐\uf897牓\uec25柤", 777564224, -634965738));
         fxv = fyb(var0, a.d("嗅ⱂꚆ㣰댱", 234749729, 653830818), 3.6);
      }

      if (var1 == 200) {
         fya(fxv, false);
      }

      fxz(var0, var1, 200, a.b("\uf5c0豧ڣ飕ጔ", 618460582), new int[]{18, 27, 33, 44});
      if (var1 == 222) {
         fyc(var0, fxv);
      }

      if (var1 == 270) {
         fyd(var3, a.b("䔪㲢뙽⠊ꏛ╼", -577223300), a.b("棊ᅀ鮚\u05f8踹࢟", -1195808609));
         fyf(var0, 0.0F, 8.0F);
         fyg(
            var0,
            a.c(-475689322, "躠\uf717緜\ue3ad桸\ueec8哕\udd69䌲즄乜됫㫭ꍏ⤛꿸ᗹ驨Î蚝ཥ甿ﮀ怔\ue635沺핗存쇱䟪챍㋇뢽Ⅽ꜐ⶩ鈍ᡷ黷܈质\uf3e3禵︍擑\ueaba匧\ud99d征쐞䨓냿㥓뼗◱ꮽင雔ᳳ蕃ஞ燆\uf63d簺\ue2bf欒턗埝\uddaa")
         );
      }

      if (var1 == 280) {
         fyg(var0, a.b("⛎彽햫䯚쁁䚐ﳦ甩\ueb59懥\ue63fᱛ鋔ଵ腢ޔ뷐㈇ꢥ⻧ꜗ\udd54厩져乒쒁紽\uf367榜\ueff5", 1750345403));
      }

      fxz(var0, var1, 280, a.b("詔\uf3f0礡\ue75f沃\uea3e", 727091752), new int[]{8, 20, 28, 36});
      if (rrx.activeGlass() > 0) {
         fxw++;
      }

      if (var1 >= 360) {
         var3.setEnabled(false);
         fyd(var3, a.d("ﯵ艣ࢽ雙ᴇ", 2078330447, -359975444), a.d("舟ﮁ煛\uef28擶", -205464936, 1829460163));
         fyg(var0, a.c(-1474666347, "惗ᥩ鎿\u0dce處º몺㍓괙⟶ꁻ婔퓅䵬읡䇛ﮁ琎\ueef6梲\ue11b鬌ᖧ踻ࡀ芖㬮땹⾟\ua9dd≩\udcaa嚫켁䥚쏰"));
         izx.TARGET.enabled.set(true);
         System.out
            .println(
               a.b("쓵뵏㞑꧲∥\ua4c7Ề霠३菟ј", 687850649)
                  + (fxw > 100 ? a.c(-1828161181, "礷\u0097詖ᐧ") : a.b("鄖\ue8a0扻ﰏ", -476933804))
                  + a.d("語\uf327离\ue7c1氛\ueab8僫\ud949䝅췢䨱끋㻒", 905027743, -836556244)
                  + fxw
                  + a.c(1792759892, "塳↖ꭘ㔣뻼㡕艜")
            );
         return true;
      } else {
         return false;
      }
   }

   static void fxz(MinecraftClient var0, int var1, int var2, String var3, int[] var4) {
      for (int var8 : var4) {
         if (var1 == var2 + var8) {
            fyh(var0, a.c(121960390, "\uf7a7踝Ӄ骠ᅷ鞘") + var3 + a.c(616281542, "뗪") + String.format(a.c(-440113776, "斱ᰕ雄ࣣ"), var8));
         }
      }
   }

   static void fya(OtherClientPlayerEntity var0, boolean var1) {
      if (var0 != null) {
         rrx.onAttack(var0);
         rrx.trigger(var0, var1);
         if (!var1) {
            var0.setHealth(0.0F);
         }
      }
   }

   static OtherClientPlayerEntity fyb(MinecraftClient var0, String var1, double var2) {
      OtherClientPlayerEntity var4 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var5 = var0.player.getEntityPos().add(0.0, 0.0, var2);
      var4.refreshPositionAndAngles(var5.x, var0.player.getY(), var5.z, 160.0F, 0.0F);
      var4.setBodyYaw(160.0F);
      var4.setHeadYaw(170.0F);
      var4.lastBodyYaw = 160.0F;
      var4.lastHeadYaw = 170.0F;
      var4.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
      var4.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
      var0.world.addEntity(var4);
      return var4;
   }

   static void fyc(MinecraftClient var0, Entity var1) {
      if (var1 != null && var0.world.getEntityById(var1.getId()) != null) {
         var0.world.removeEntity(var1.getId(), RemovalReason.DISCARDED);
      }
   }

   static void fyd(kfe var0, String var1, String var2) {
      ((vlv)fye(var0, var1)).set(var2);
   }

   static vmo fye(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.d("\ue85a醣᭹蔚ພ衡㈳뮍", -2056775358, -1550520016) + var1);
   }

   static void fyf(MinecraftClient var0, float var1, float var2) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
   }

   static void fyg(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   static void fyh(MinecraftClient var0, String var1) {
      System.out.println(a.c(-129992095, "稘ο襥\u171e鲏ᩪꀨ⧏랗㵲") + var1 + a.b("琟\u0dce蝽", -861309892) + var0.getCurrentFps() + a.c(1440106112, "䚤㽓떖⯤"));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.d("ϔ穯\uf0bf滖\ue544揪", 1691498866, 1212037830) + var1 + a.d("\uea83鍬ᦡ蟙", 439445360, -1020031527),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
