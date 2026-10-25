package a;

import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;

public final class jip {
   private static final String jiq = a.c(-1106909821, "\ue5ec鱗ᚇ裮ͼ薠㿘똭⡱");
   private static final int jir = 6;
   private static final long[] jis = new long[6];
   private static final long[] jit = new long[6];
   private static int jiu;
   private static int jiv;
   private static Field jiw;
   private static boolean jix;
   private static ClientConnection jiy;
   private static double jiz = Double.NaN;
   private static double jja;
   private static float jjb;
   private static boolean jjc;

   private jip() {
   }

   public static void tick(MinecraftClient var0) {
      ClientPlayNetworkHandler var1 = var0.method_1562();
      ClientConnection var2 = var1 != null ? var1.method_48296() : null;
      if (var2 != jiy) {
         jjf();
         jiy = var2 != null && jjh(var2) ? var2 : null;
      }

      ClientPlayerEntity var3 = var0.field_1724;
      if (var3 == null) {
         jiz = Double.NaN;
         jjb = 0.0F;
      } else {
         if (!Double.isNaN(jiz)) {
            double var4 = var3.method_23317() - jiz;
            double var6 = var3.method_23321() - jja;
            float var8 = (float)Math.sqrt(var4 * var4 + var6 * var6) * 20.0F;
            if (var8 > 400.0F) {
               var8 = jjb;
            }

            jjb = jjb + (var8 - jjb) * 0.45F;
            if (jjb < 0.005F) {
               jjb = 0.0F;
            }
         }

         jiz = var3.method_23317();
         jja = var3.method_23321();
      }
   }

   public static float bps() {
      return jjb;
   }

   public static synchronized float tps() {
      if (jiu < 2) {
         return -1.0F;
      } else {
         int var0 = (jiv - 1 + 6) % 6;
         int var1 = (jiv - jiu + 6) % 6;
         double var2 = (jit[var0] - jit[var1]) / 1.0E9;
         long var4 = jis[var0] - jis[var1];
         if (!(var2 <= 0.05) && var4 > 0L) {
            float var6 = (float)Math.min(20.0, var4 / var2);
            double var7 = (System.nanoTime() - jit[var0]) / 1.0E9;
            if (var7 > 1.5) {
               var6 = (float)Math.min((double)var6, 20.0 / var7);
            }

            return var6;
         } else {
            return -1.0F;
         }
      }
   }

   private static synchronized void jjf() {
      jiu = 0;
      jiv = 0;
   }

   private static synchronized void jjg(long var0) {
      long var2 = System.nanoTime();
      if (jiu > 0 && var0 <= jis[(jiv - 1 + 6) % 6]) {
         jiu = 0;
      }

      jis[jiv] = var0;
      jit[jiv] = var2;
      jiv = (jiv + 1) % 6;
      jiu = Math.min(6, jiu + 1);
   }

   private static boolean jjh(ClientConnection var0) {
      Channel var1 = jji(var0);
      if (var1 == null) {
         return false;
      } else {
         try {
            ChannelPipeline var2 = var1.pipeline();
            if (var2.get(a.b("\uf71c躧ѷ騞ᆌ靐\u2d28ꓝ㪁", 1759836019)) != null) {
               return true;
            } else {
               ChannelHandlerContext var3 = var2.context(var0);
               if (var3 == null) {
                  return false;
               } else {
                  var2.addBefore(var3.name(), a.c(59097505, "쇎롵㊥곌❞ꆂ\u1bfa鈏\u0c53"), new ChannelInboundHandlerAdapter() {
                     public void channelRead(ChannelHandlerContext var1, Object var2x) throws Exception {
                        if (var2x instanceof WorldTimeUpdateS2CPacket var3x) {
                           jip.jjg(var3x.comp_3219());
                        }

                        super.channelRead(var1, var2x);
                     }
                  });
                  return true;
               }
            }
         } catch (Throwable var4) {
            if (!jjc) {
               jjc = true;
               System.out.println(a.c(-1881087198, "\ue371髂သ踦֢荇㥃낤⻮ꑈ⎐\ud9a9圪캇䓙쉭硱\uf7b6洒\ueb47抣ᣥ阃ආ讪į뢁㛔갫⨿ꇙ弍핖䲢쫤䁄ﾅ疧\uf37c檋\ue0d5鹫ᑌ鏹भ蜦㻦둍") + var4);
            }

            return false;
         }
      }
   }

   private static Channel jji(ClientConnection var0) {
      if (jiw == null && !jix) {
         for (Field var4 : ClientConnection.class.getDeclaredFields()) {
            if (Channel.class.isAssignableFrom(var4.getType())) {
               var4.setAccessible(true);
               jiw = var4;
               break;
            }
         }

         jix = jiw == null;
      }

      if (jiw == null) {
         return null;
      } else {
         try {
            return (Channel)jiw.get(var0);
         } catch (IllegalAccessException var5) {
            return null;
         }
      }
   }
}
