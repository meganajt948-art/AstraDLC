package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;

public class lxp extends kfe {
   private static final Field lxq = vxr.find(
      LivingEntity.class,
      a.c(-241501356, "ﬢ芘࡚陱ᷥ魐℄ꣾ㚧밇㯇솱佴횟岁\uda7f怽\ueffe畍\uf330窩ú蹊ᖒ"),
      a.d("䟠㹞뒁⫹ꄦ➬鶖ᑣ証\u0087", -1290091562, -794459046),
      a.d("鏱", 225365363, 564092618)
   );
   private static lxp lxr;

   public lxp() {
      super(a.d("悼\u192c鏚ඔ虛÷몐㍀괖➪ꁡ", -639606957, 800866218), a.d("\udd41\ua4cf⸄끨㯯봟݊躽ც驜᷁\ue7e4椯\uf093窅ﰽ䙵즹匍핉岱⛺ꠝ㎕뗼㼷蛑࣌鈶ᑨ鿑", -1951112554, -424755326), kfa.MOVEMENT);
      lxr = this;
   }

   public static boolean active() {
      return lxr != null && lxr.isEnabled();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (vxr.getInt(lxq, var1.player, 0) > 0) {
         vxr.setInt(lxq, var1.player, 0);
      }
   }
}
