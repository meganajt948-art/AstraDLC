package a;

import io.netty.channel.ChannelPromise;

final class vwt {
   final Object vwu;
   final ChannelPromise vwv;

   vwt(Object msg, ChannelPromise promise) {
      this.vwu = msg;
      this.vwv = promise;
   }

   public Object msg() {
      return this.vwu;
   }

   public ChannelPromise promise() {
      return this.vwv;
   }
}
