package a;

import flow.Flow;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;

public final class fzl {
   static final String fzm = System.getenv(a.d("ᚱ漊\ue5da箳\uf001盝첕䕥\udb29冑화Ⱒꋱ㭏넚㟼", -847691455, -847423578));

   fzl() {
   }

   public static boolean intercept(Flow var0) {
      if (fzm != null && !fzm.isBlank()) {
         long var1;
         int var3;
         try {
            var1 = Long.parseLong(fzm.trim());
            var3 = Integer.parseInt(
               System.getenv().getOrDefault(a.d("鵸\ue4c3渓\uf07a篈ﴔ䝜캬僠\uda58嶝\ua7eb⤸낆㫓밵ٱ覬ጄ镒Ჾ曨", 706754157, -1394627771), a.c(-1506575550, "筳ˁ")).trim()
            );
         } catch (NumberFormatException var5) {
            return false;
         }

         Thread var4 = new Thread(
            () -> {
               fzp(var1);
               long var4x = System.currentTimeMillis();
               System.out.println(a.d("捕\u1ae5逥ข薜̪륽ゃ껚⑼ꏡ妊휎亸쓾䈜\uf855矘\ued6a欲\ue28a飒ᙡ跶\u0bdd脐㢮뚺Ⰺ꩝⇢\udf3b唶첓䪓쁶羽\uf5d6猒\ueaa7惽", 515757330, 1529525770));
               var0.start();
               var0.injected();
               System.out
                  .println(
                     a.b("\ued2d钝ṝ聺\u0be4赒㜅뻻₢ꨄ\u2d99ퟲ奶샀䪆챤瘭裂挒\ue54a沶᛬頖π薻ཥ뛐㢖ꉰ␠꿟儏\udb49䋪쒮与\uf1d8箮ﵡ擛\uee85逰ᨢ鶔ݑ褱ヵ먖", -1174606471)
                        + (System.currentTimeMillis() - var4x)
                        + a.c(360838496, "\uf55c負٭顏᎐镽⼲ꛎ㣔눩㗹쾆䅔\ud8e4加퐃清\ue1ce笮ﴻ瓇ທ耯ᮻ鶊\u175a껱\u20fe")
                  );
               MinecraftClient var6 = MinecraftClient.getInstance();

               for (int var7 = 0; var7 < var3; var7++) {
                  fzp(1000L);
                  int var8 = var7;
                  var6.execute(
                     () -> ScreenshotRecorder.saveScreenshot(
                        var6.runDirectory,
                        a.b("赫\uf4d0縀\ue069毻\ued55坂\udeb4䃯쩑䶄럢㥬", 1400147200) + var8 + a.c(2027250248, "扢ᮍ酀༸"),
                        var6.getFramebuffer(),
                        1,
                        var0xxx -> {}
                     )
                  );
               }
            },
            a.d("指᪷遷๐藎\u0378뤯パ꺈\u242e", -1122929840, 1716129849)
         );
         var4.setDaemon(true);
         var4.start();
         return true;
      } else {
         return false;
      }
   }

   static void fzp(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         Thread.currentThread().interrupt();
      }
   }
}
