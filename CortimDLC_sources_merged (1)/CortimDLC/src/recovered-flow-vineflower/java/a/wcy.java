package a;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import java.util.ArrayDeque;

final class wcy extends ChannelOutboundHandlerAdapter {
   volatile long until;
   final ArrayDeque<Object> wcz = new ArrayDeque<>();
   volatile ChannelHandlerContext wda;
   boolean wdb;

   wcy() {
   }

   public void handlerAdded(ChannelHandlerContext var1) {
      this.wda = var1;
   }

   public void handlerRemoved(ChannelHandlerContext var1) {
      this.until = 0L;
      this.wde(var1);
   }

   public void write(ChannelHandlerContext var1, Object var2, ChannelPromise var3) {
      if (System.nanoTime() < this.until) {
         this.wcz.add(var2);
         this.wcz.add(var3);
      } else {
         this.wde(var1);
         var1.write(var2, var3);
      }
   }

   public void flush(ChannelHandlerContext var1) {
      if (System.nanoTime() < this.until) {
         this.wdb = true;
      } else {
         this.wde(var1);
         var1.flush();
      }
   }

   public void close(ChannelHandlerContext var1, ChannelPromise var2) throws Exception {
      this.until = 0L;
      this.wde(var1);
      super.close(var1, var2);
   }

   void wake() {
      ChannelHandlerContext var1 = this.wda;
      if (var1 != null) {
         var1.executor().execute(() -> {
            if (System.nanoTime() >= this.until) {
               this.wde(var1);
            }
         });
      }
   }

   void wde(ChannelHandlerContext var1) {
      if (!this.wcz.isEmpty() || this.wdb) {
         while (!this.wcz.isEmpty()) {
            var1.write(this.wcz.poll(), (ChannelPromise)this.wcz.poll());
         }

         this.wdb = false;
         var1.flush();
      }
   }
}
