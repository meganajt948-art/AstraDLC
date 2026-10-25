package a;

import flow.Flow;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.text.Text;

final class fbc {
   fbc() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      switch (var1) {
         case 1:
            fbf(var0, a.c(1882854929, "ᙨ濄\ue513筪\uf0f8瘚챟䖿\udbb4儓훆ⲷꉠ"));
            fbf(var0, a.b("\uebff鉞ᢁ蛭ഭ讛㇅렺♶곑⭆텸徢옛䱇쪰烨Ｄ斈\ue3ca樫ဩ黛ԏ荰\u09e5뀐㹋꒿⋶\ua95a垓\udd8c䐵쉫䣞\uf704絭ﮢ", -538711125));
            fbf(var0, a.d("䝼㻝됂⩮ꆮ✘鵆ᒹ諵R蟅緻\uf321檘\ue0c4昳\udc6b厧줋佉욨벪㉊ꦍ\u2fe3ꔢᲜ鋗ࠣ蹮א\ufb19焏\ue8b2滤\ue44f実톺圯캔䓈㨡끭㟄", 247117332, -193531593));
            kfe var2 = Flow.getInstance().getModuleManager().getByName(a.d("\udf7cꛢⰶ뉃㦘뼼ղ貅ዛ顷", -532445246, -1220388619));

            for (vmo var4 : var2.getSettings()) {
               if (var4 instanceof vmc var5 && a.b("뮾숬䣪횛嵍", -2095858712).equals(var5.getName())) {
                  var5.set(0.5);
               }
            }

            System.out.println(a.d("\uf5cf豱ڥ飐ፊ閯\u2fedꘊ㡒늭㕤콴䆌\ud83a剭풐滊\ue106箳\ufde3琉ซ胷ᬧ鴖៚깴", 1391944567, 547722946) + var2.isEnabled());
            break;
         case 20:
            var0.options.playerListKey.setPressed(true);
            break;
         case 22:
            fbg(var0, a.b("廁❿궫㏞롉㻥蒷൚鍜᧸鸨搖\uea83猭參羑엙䨏킵", -405053773));
            break;
         case 34:
            fbg(var0, a.b("ꆷ\ud809勝첨䜿솓篂\uf22c氪\ue68e慞魠ᗵ豛؝胧", -44654138));
            break;
         case 35:
            var0.options.playerListKey.setPressed(false);
            break;
         case 37:
            fbg(var0, a.b("䅴㣊눞Ⱬꟼ⅐鬀ዯ賩ٍ膝箣\uf53a沄\ue6d4怹\uda6c喺케", 1294287110));
            break;
         case 50:
            var0.inGameHud.getChatHud().addMessage(Text.literal(a.c(2044120767, "컮띲㶨ꏙ⠍껳ᓦ鴃́觲\u0e6c\uf47b窆\ue334楿\uefd5喖\uda0b䂽웫众㔃믿 ꙛ")));
            break;
         case 56:
            var0.inGameHud.getChatHud().addMessage(Text.literal(a.d("氳ᗣ齣Ą諕౨똺㿁ꇚ⬧곱嚇\ud85b䆯쮯䵁\uf70b磗\ue265搢\ued86鞃\u192c苰ӊ蹘㟠릸⍚ꕟ⺹큭", -1398516817, -1926021123)));
            break;
         case 57:
            fbg(var0, a.b("ᐼ涂\ue756礣\uf2b4琘칏䞧\ud9b6匌퓖⺲ꀼ㧓뎟㕫輩õ驁ᰙ", -1112665015));
            break;
         case 70:
            fbg(var0, a.c(292027439, "ﱚ藤༰酅\u1ad2鱾☨꿁㇐뭪㲰월䡚통寰\udd10束\ue896爬\uf47c"));
            break;
         case 80:
            var0.setScreen(new ChatScreen("", false));
            break;
         case 82:
            fbg(var0, a.d("뚽켃䗗\udba2倵횙泌\ue526笷\uf18d癗谳ʽ魎ᄂ韦ⶢꈰ㣜뺖㝻䴰쎄塜", 1090643687, 58413091));
            break;
         case 95:
            fbg(var0, a.b("뫋썵䦡ퟔ屃\udaef悻\ue950睁ﷻ稡聅໋霸ᵴ鮐⇔", 227588795));
            var0.setScreen(null);
            break;
         case 110:
            var0.setScreen(new InventoryScreen(var0.player));
            break;
         case 112:
            fbg(var0, a.b("\ue1ca顴አ賕݂臮㮵뉑ⱊ\ua6fcℷ\udb55喉찢䙪삆竂\uf547澶\ue9f8怚ᩀ铴༢襔", -331095630));
            break;
         case 130:
            fbg(var0, a.b("\ue385騻ჯ躚ԍ莡㧻뀞⸅꒳⍸\ud91a埆칭䐥싉碍\uf708淹\uebb7払᠏", 2061362162));
            var0.setScreen(null);
            break;
         case 140:
            var0.setScreen(new GameMenuScreen(true));
            break;
         case 142:
            fbg(var0, a.c(270715493, "쨐뎮㥺꜏Ⲙꨵၧ馋މ贩૮\uf099繘\ue7a1涭\ueb47儒\uded9䑭숵"));
            break;
         case 160:
            fbg(var0, a.b("ɐ篮\uf13a潏\ue4d8扵\ud826凋쿉䕩슮㣙똘", -629865924));
            break;
         case 170:
            var0.setScreen(null);
            System.out.println(a.b("硩Ǘ謃ᕶ黬᠉ꉋ⮬뗴㼑뢲䋒찗喦", 1386772486));
            return true;
      }

      return false;
   }

   static void fbf(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   static void fbg(MinecraftClient var0, String var1) {
      System.out
         .println(
            a.b("朠ẇ鑝ਦ膷ݒ봐㓷ꪯ⁊", 2029217625)
               + var1
               + a.d("惎\u191f鎬", 1877185048, 1344271093)
               + var0.getCurrentFps()
               + a.d("鹓\ue7a4浡\uf313", 296859215, 1779968056)
         );
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory, a.b("晍ῶ锦\u0b4f胝ٳ", -67082707) + var1 + a.d("뛮켁䗌\udbb4", 1305709896, 1252277132), var0.getFramebuffer(), 1, var0x -> {}
      );
   }
}
