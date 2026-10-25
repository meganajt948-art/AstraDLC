package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket.Status;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;

final class ehq {
   private final List<ehn> ehr = new ArrayList<>();
   private final Random ehs = new Random();

   void offer(ResourcePackSendS2CPacket var1, ClientConnection var2) {
      String var3 = var1.comp_2159();
      if (var3 != null && (var3.startsWith(a.d("헟걲⚡룔㍉뗭྾", 1891259999, -444169233)) || var3.startsWith(a.c(-975468472, "蠨\uf185策\ue523滷\ue80f剉\udbb8")))) {
         var2.method_10743(new ResourcePackStatusC2SPacket(var1.comp_2158(), Status.field_13016));
         this.ehr.add(new ehn(var1.comp_2158(), 24 + this.ehs.nextInt(46)));
      } else {
         var2.method_10743(new ResourcePackStatusC2SPacket(var1.comp_2158(), Status.field_47667));
      }
   }

   void tick(ClientConnection var1) {
      Iterator var2 = this.ehr.iterator();

      while (var2.hasNext()) {
         ehn var3 = (ehn)var2.next();
         if (--var3.ticks <= 0) {
            if (var3.stage == 0) {
               var1.method_10743(new ResourcePackStatusC2SPacket(var3.id, Status.field_47704));
               var3.stage = 1;
               var3.ticks = 6 + this.ehs.nextInt(14);
            } else {
               var1.method_10743(new ResourcePackStatusC2SPacket(var3.id, Status.field_13017));
               var2.remove();
            }
         }
      }
   }

   void clear() {
      this.ehr.clear();
   }
}
