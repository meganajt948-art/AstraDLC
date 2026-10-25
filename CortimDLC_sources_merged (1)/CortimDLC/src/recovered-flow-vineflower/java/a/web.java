package a;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;

final class web extends ChannelOutboundHandlerAdapter {
   web() {
   }

   public void write(ChannelHandlerContext var1, Object var2, ChannelPromise var3) throws Exception {
      if (var2 instanceof HandSwingC2SPacket) {
         wee.weh++;
      }

      super.write(var1, var2, var3);
   }
}
