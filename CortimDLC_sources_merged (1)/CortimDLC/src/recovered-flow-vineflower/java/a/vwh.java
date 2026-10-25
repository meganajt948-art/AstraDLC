package a;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import java.util.ArrayDeque;
import net.minecraft.network.packet.c2s.play.BundleItemSelectedC2SPacket;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientTickEndC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.util.PlayerInput;

final class vwh extends ChannelOutboundHandlerAdapter {
   final Channel channel;
   final ArrayDeque<vwt> vwi = new ArrayDeque<>();
   ChannelHandlerContext vwj;
   boolean vwk;
   boolean vwl;
   boolean vwm;
   int vwn;

   vwh(Channel var1, PlayerInput var2, boolean var3) {
      this.channel = var1;
      this.reset(var2, var3);
   }

   void reset(PlayerInput var1, boolean var2) {
      this.vwk = vwy.vxk(var1);
      this.vwl = var1.sneak();
      this.vwm = var2;
   }

   public void handlerAdded(ChannelHandlerContext var1) {
      this.vwj = var1;
   }

   public void handlerRemoved(ChannelHandlerContext var1) {
      this.vwi.clear();
      this.vwj = null;
      if (vwy.vxe == this) {
         vwy.vxe = null;
         vwy.vxd = false;
      }
   }

   public void write(ChannelHandlerContext var1, Object var2, ChannelPromise var3) throws Exception {
      this.vwq(var2);
      if (!vwy.vxc
         || !(var2 instanceof ClickSlotC2SPacket) && !(var2 instanceof CloseHandledScreenC2SPacket) && !(var2 instanceof BundleItemSelectedC2SPacket)
         || this.vwi.isEmpty() && !this.vwr()) {
         var1.write(var2, var3);
         if (var2 instanceof ClientTickEndC2SPacket && !this.vwi.isEmpty() && (!this.vwr() || ++this.vwn >= 4)) {
            this.vws(var1);
         }
      } else {
         this.vwi.add(new vwt(var2, var3));
         vwy.vxd = true;
      }
   }

   void release(boolean var1) {
      ChannelHandlerContext var2 = this.vwj;
      if (var2 != null && !this.vwi.isEmpty() && (var1 || !vwy.vxc || !this.vwr())) {
         this.vws(var2);
      }
   }

   void vwq(Object var1) {
      if (var1 instanceof PlayerInputC2SPacket var2) {
         this.vwk = vwy.vxk(var2.input());
         this.vwl = var2.input().sneak();
      } else if (var1 instanceof ClientCommandC2SPacket var3) {
         if (var3.getMode() == Mode.START_SPRINTING) {
            this.vwm = true;
         } else if (var3.getMode() == Mode.STOP_SPRINTING) {
            this.vwm = false;
         }
      }
   }

   boolean vwr() {
      return this.vwk || this.vwl && !vwy.vxf || this.vwm;
   }

   void vws(ChannelHandlerContext var1) {
      vwt var2;
      while ((var2 = this.vwi.poll()) != null) {
         var1.write(var2.msg(), var2.promise());
      }

      var1.flush();
      this.vwn = 0;
      vwy.vxd = false;
   }
}
