package a;

import flow.dev.a;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class lfu extends kfe {
   private static lfu lfv;

   public lfu() {
      super(a.b("ߕ繅\uf4bf櫺\ue136枋\uddd3吨쩗䃃윜㵡뎰⨃", 2132412309), a.b("覙\uf01e竗\ue4a1漤\ue9dd厏\uda63䐻컙䥄댾㷺ꑘ⸜ꢿኼ鵠ߜ膇࠴爪ﲘ朇\ue13e毻퉓導웲䂩쬍", -43415073), kfa.COMBAT);
      lfv = this;
   }

   public static boolean blocks(Entity var0) {
      return lfv != null && lfv.isEnabled() && var0 instanceof PlayerEntity && hhf.isFriend(var0);
   }
}
