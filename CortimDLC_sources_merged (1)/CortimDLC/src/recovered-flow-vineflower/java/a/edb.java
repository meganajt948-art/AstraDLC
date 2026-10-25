package a;

import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.OffThreadException;
import net.minecraft.network.listener.ClientLoginPacketListener;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.common.DisconnectS2CPacket;
import net.minecraft.text.Text;

final class edb extends ClientConnection {
   private final dtv edc;
   private final ConcurrentLinkedQueue<Packet<?>> edd = new ConcurrentLinkedQueue<>();
   private volatile Channel ede;

   edb(dtv var1) {
      super(NetworkSide.field_11942);
      this.edc = var1;
   }

   public void channelActive(ChannelHandlerContext var1) throws Exception {
      this.ede = var1.channel();
      super.channelActive(var1);
   }

   void runInLoop(Runnable var1) {
      Channel var2 = this.ede;
      if (var2 != null && !var2.eventLoop().inEventLoop()) {
         var2.eventLoop().execute(var1);
      } else {
         var1.run();
      }
   }

   public void method_60924(DisconnectionInfo var1) {
      Channel var2 = this.ede;
      if (var2 != null && !var2.eventLoop().inEventLoop()) {
         var2.eventLoop().execute(() -> this.edh(var1));
      } else {
         super.method_60924(var1);
      }
   }

   private void edh(DisconnectionInfo var1) {
      super.method_60924(var1);
   }

   protected void method_10770(ChannelHandlerContext var1, Packet<?> var2) {
      PacketListener var3 = this.method_10744();
      if (var3 == null || var3 instanceof ClientLoginPacketListener) {
         super.method_10770(var1, var2);
      } else if (var2 instanceof DisconnectS2CPacket var4) {
         this.method_10747(var4.comp_2325());
      } else {
         if (this.method_10758()) {
            this.edd.add(var2);
            this.edc.onPacketReceived();
         }
      }
   }

   public void channelInactive(ChannelHandlerContext var1) {
      this.method_10747(Text.method_43471(a.c(1077229057, "㙳俏씆孧킼嘌\uec5f斥ﯼ煚\uf6d3೩舵ᮎ釶ᜮ굔⊢렗㹑랢췿")));
   }

   void drain(long var1) {
      long var3 = System.nanoTime();

      Packet var5;
      while ((var5 = this.edd.poll()) != null) {
         PacketListener var6 = this.method_10744();
         if (var6 == null || !this.method_10758()) {
            this.edd.clear();
            return;
         }

         if (var6.method_52413(var5)) {
            this.edc.beforePacket(var5);

            try {
               edi(var5, var6);
            } catch (OffThreadException var8) {
            } catch (RejectedExecutionException var9) {
               this.method_10747(
                  Text.method_43471(a.d("丛㞲뵸⌑\ua8db\u2e73鐼᷀莇प軮瓃艹揢\ue9ab潊픉嫙쁪䘰쿁떇㭮ꃢ⚋걍ᗺ鮸Ř蜤\u0cbb\uf271砣\ue1d3析\ued2a勥\ud88d", 553167652, 2043929972))
               );
               return;
            } catch (ClassCastException var10) {
               this.method_10747(Text.method_43471(a.b("퀤ꦍ⍇봮㛤끌ਃ菿ᶸ霕ბ\ueafc摡\ufddd瞔\uf175䬶쓦幕\ud80f凾⮸ꕑ㻇뢿㉶诒֎齼ᤠ銨汖\ue608翻裂猟쳙", 662032492)));
               return;
            } catch (Throwable var11) {
               this.edc.onPacketError(var5, var11);
            }
         }

         if (System.nanoTime() - var3 > var1) {
            return;
         }
      }
   }

   int pending() {
      return this.edd.size();
   }

   private static <T extends PacketListener> void edi(Packet<T> var0, PacketListener var1) {
      var0.method_65081(var1);
   }
}
