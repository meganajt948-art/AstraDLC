package a;

import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public final class wee {
   private static final String wef = a.b("骦\ue31d槍\uf7a4簶\ufaea䂕쥠圡\udd97婍", 1440979659);
   private static final String weg = a.c(-909658882, "뒀촠䟱\ud988剑퓱溉\ue74f礙\uf3a7瑾踇Ù饿");
   private static volatile int weh;

   private wee() {
   }

   public static int count() {
      return weh;
   }

   public static void ensure(MinecraftClient var0) {
      ClientPlayNetworkHandler var1 = var0.method_1562();
      if (var1 != null && !ejp.isActive()) {
         Channel var2 = wcn.channel(var1.method_48296());
         if (var2 != null && var2.isOpen()) {
            ChannelPipeline var3 = var2.pipeline();
            if (var3.get(a.d("\uef1b隠ᱰ舙ঋ轗㔨볝⊜꠪⿰", -1147047637, -1657364899)) == null && var3.get(a.b("닋쭫䆺\udfc3吚튺棂\ue104罒\uf5ec爵行ڒ鼴", -993611083)) != null) {
               try {
                  var3.addBefore(a.b("ۄ罤\uf5b5毌\ue015暵\udccd唋쭝䇣옺㱃늝⬻", 1545275066), a.d("굏퓴帤쁍䯟촃睼ﺉ惈\uea7e涤", 260390391, -1697410859), new web());
               } catch (RuntimeException var5) {
               }
            }
         }
      }
   }
}
