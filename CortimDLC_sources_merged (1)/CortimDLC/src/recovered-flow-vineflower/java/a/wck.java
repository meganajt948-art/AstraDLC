package a;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.minecraft.network.packet.Packet;

final class wck extends ChannelInboundHandlerAdapter {
   private wck() {
   }

   public void channelRead(ChannelHandlerContext var1, Object var2) throws Exception {
      if (var2 instanceof Packet var3) {
         boolean var4 = ejp.lockMain();

         try {
            wcn.wcw(var3);
            var2 = wcn.wcx(var3);
         } finally {
            if (var4) {
               ejp.unlockMain();
            }
         }
      }

      super.channelRead(var1, var2);
   }
}
