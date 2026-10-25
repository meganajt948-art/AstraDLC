package a;

import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.PlayerInput;

public final class vwy {
   private static final String vwz = a.d("븛잠䵰팙墋\ude57搼\uedcb玁嵐", 651172504, 963945711);
   private static final String vxa = a.b("ᐽ涝\ue74c礵\uf2ec瑌츴䟲\ud9a4匚퓃⺺ꁤ㧂", -85715901);
   private static final int vxb = 4;
   private static volatile boolean vxc;
   private static volatile boolean vxd;
   private static volatile vwh vxe;
   private static volatile boolean vxf;
   private static volatile int vxg;
   private static ClientPlayerEntity vxh;

   private vwy() {
   }

   public static boolean waiting() {
      return vxd;
   }

   public static void setActive(boolean var0) {
      if (vxc != var0) {
         vxc = var0;
         if (!var0) {
            poke(true);
         }
      }
   }

   public static void ensure(MinecraftClient var0) {
      ClientPlayNetworkHandler var1 = var0.getNetworkHandler();
      ClientPlayerEntity var2 = var0.player;
      if (var1 != null && var2 != null) {
         Channel var3 = wcn.channel(var1.getConnection());
         if (var3 != null && var3.isOpen()) {
            ChannelPipeline var4 = var3.pipeline();
            vwh var5 = vxe;
            if (var4.get(a.d("\uf560賛؋顢Ᏸ锬⽇ꚰ㣺뉚", 123738631, 755494667)) != null) {
               if (var5 != null && var2 != vxh) {
                  vxh = var2;
                  PlayerInput var9 = vyn.lastSent(var2);
                  boolean var7 = wdt.serverSprinting(var2);
                  var3.eventLoop().execute(() -> var5.reset(var9, var7));
               }
            } else if (var4.get(a.c(1048825518, "컐띰㶡ꏘ⠁꺡ᓙ鴟͉觷ฮ\uf457窉\ue32f")) != null) {
               vwh var6 = new vwh(var3, vyn.lastSent(var2), wdt.serverSprinting(var2));

               try {
                  var4.addBefore(a.c(738774851, "켽뚝㱌ꈵ⧬꽌ᔴ鳲ʤ蠚࿃\uf5ba筤\ue2c2"), a.b("Ɀ嗄\udf14䅽쫯䰳\uf658羯\ue1e5歅", 2044079123), var6);
                  vxe = var6;
                  vxh = var2;
               } catch (RuntimeException var8) {
               }
            }
         }
      }
   }

   public static void sneakOk(boolean var0) {
      if (var0) {
         vxg++;
         vxf = true;
      } else if (vxf) {
         int var1 = vxg;
         vwh var2 = vxe;
         if (var2 != null && var2.channel.isOpen()) {
            var2.channel.eventLoop().execute(() -> {
               if (vxg == var1) {
                  vxf = false;
               }
            });
         } else {
            vxf = false;
         }
      }
   }

   public static void poke(boolean var0) {
      vwh var1 = vxe;
      if (var1 != null && var1.channel.isOpen()) {
         var1.channel.eventLoop().execute(() -> var1.release(var0));
      }
   }

   private static boolean vxk(PlayerInput var0) {
      return var0.forward() || var0.backward() || var0.left() || var0.right() || var0.jump();
   }
}
