package a;

import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import java.util.concurrent.LinkedBlockingQueue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public final class wdf {
   private static final String wdg = a.b("씗벬㙼ꠕ⎇ꕛἽ雏ࢍ舼\u05feﾘ", 1140770173);
   private static final String wdh = a.d("隧\uef07旖ﮯ灶\uf6d6䲮앨嬾톀噙갠⋾뭘", 959061700, -247560163);
   private static final LinkedBlockingQueue<wcy> wdi = new LinkedBlockingQueue<>();
   private static Thread wdj;

   private wdf() {
   }

   public static void hold(MinecraftClient var0, long var1) {
      if (var1 > 0L && !ejp.isActive()) {
         ClientPlayNetworkHandler var3 = var0.method_1562();
         if (var3 != null) {
            Channel var4 = wcn.channel(var3.method_48296());
            if (var4 != null && var4.isOpen()) {
               wcy var5 = wdm(var4.pipeline());
               if (var5 != null) {
                  var5.until = Math.max(var5.until, System.nanoTime() + var1);
                  wdn();
                  wdi.add(var5);
               }
            }
         }
      }
   }

   private static wcy wdm(ChannelPipeline var0) {
      if (var0.get(a.c(-387363752, "䰲㖉뽙ℰꪢⱾ阘Ὺ膨ଙ賛皽")) instanceof wcy var5) {
         return var5;
      } else if (var0.get(a.d("\ue381騡ჰ躉Ր菰㦈끎⸘꒦⍿\ud906埘칾", -1344428306, -1485159151)) == null) {
         return null;
      } else {
         wcy var2 = new wcy();

         try {
            var0.addBefore(a.b("꽊훪尻쉂䦛켻畃ﲅ拓\ue86d澴闍ᬓ芵", 991473460), a.c(-20789793, "억밎㛞ꢷ⌥ꗹᾟ陭\u082f芞՜Ｚ"), var2);
            return var2;
         } catch (RuntimeException var4) {
            return null;
         }
      }
   }

   private static synchronized void wdn() {
      if (wdj == null) {
         wdj = new Thread(wdf::wdo, a.c(-1742451277, "䷤㑿뺯\u20c6ꭔⷷ韗Ḑ聄૿赨睳驪怫\uea78沘훀"));
         wdj.setDaemon(true);
         wdj.start();
      }
   }

   private static void wdo() {
      while (true) {
         try {
            wcy var0 = wdi.take();
            wdp(var0.until);
            var0.wake();
         } catch (InterruptedException var1) {
            return;
         } catch (RuntimeException var2) {
         }
      }
   }

   private static void wdp(long var0) throws InterruptedException {
      long var2;
      while ((var2 = var0 - System.nanoTime()) > 0L) {
         long var4 = var2 / 1000000L - 1L;
         if (var4 > 0L) {
            Thread.sleep(var4 % 10L == 0L ? var4 - 1L : var4);
         } else {
            Thread.onSpinWait();
         }
      }
   }
}
