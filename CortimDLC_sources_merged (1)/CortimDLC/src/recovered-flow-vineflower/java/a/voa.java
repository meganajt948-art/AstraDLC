package a;

import flow.dev.a;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;

public final class voa {
   public static final List<String> BUILT_IN = vnb.NAMES;
   static final float vob = 0.8909F;
   static final int voc = 8;
   static final int vod = 787;
   static final BlockingQueue<vnl> voe = new ArrayBlockingQueue<>(32);
   static final vnl vof = new vnl("", true, 0.0F, 0L, "", 0.0F, 0.0F);
   static Thread vog;
   static volatile boolean voh;
   static final String voi = a.d("\ueb40鋧ᠤ蘊", -827944839, 702184286);
   static long voj;
   static volatile String vok = "";

   voa() {
   }

   public static void shutdown() {
      Thread var0;
      synchronized (voa.class) {
         var0 = vog;
         voh = true;
      }

      if (var0 != null) {
         voe.clear();
         voe.offer(vof);

         try {
            var0.join(1000L);
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
         }
      }
   }

   public static void play(String var0, boolean var1, float var2) {
      von(var0, var1, var2, 0.0F, 0.0F);
   }

   public static void cue(String var0, float var1, float var2, float var3) {
      von(a.b("\u09db灼謹撑", 2134706620) + var0, true, var1, var2, var3);
   }

   public static void menu(String var0, boolean var1, float var2) {
      von(var0, var1, var2, 0.0F, 0.0F);
   }

   static void von(String var0, boolean var1, float var2, float var3, float var4) {
      if (!voh && !(var2 <= 0.001F) && var0 != null) {
         voo();
         long var5 = 0L;
         String var7 = "";

         try {
            var5 = ALC10.alcGetCurrentContext();
            MinecraftClient var8 = MinecraftClient.getInstance();
            if (var8.options != null) {
               var7 = var8.options.getSoundDevice().getValue();
            }
         } catch (Throwable var9) {
         }

         voe.offer(new vnl(var0, var1, Math.min(2.0F, var2), var5, var7 == null ? "" : var7, var3, var4));
      }
   }

   static synchronized void voo() {
      if (vog == null) {
         vog = new Thread(voa::vop, a.d("̼窧\uf077渞\ue58c振\ud92f僂캇䐭쏴㦒", 1969676732, -1719541046));
         vog.setDaemon(true);
         vog.start();
      }
   }

   static void vop() {
      vne var0 = null;
      long var1 = 0L;
      String var3 = null;

      while (true) {
         vnl var4;
         try {
            var4 = voe.poll(2L, TimeUnit.SECONDS);
         } catch (InterruptedException var10) {
            break;
         }

         if (var4 == vof) {
            break;
         }

         try {
            if (var4 == null) {
               if (var0 != null && !var0.connected()) {
                  var0.close();
                  var0 = null;
               }
            } else {
               boolean var5 = var1 != 0L && var4.gameContext() != 0L && var4.gameContext() != var1;
               if (var0 != null && (var5 || !var4.device().equals(var3) || !var0.connected())) {
                  var0.close();
                  var0 = null;
               }

               if (var4.gameContext() != 0L) {
                  var1 = var4.gameContext();
               }

               if (var0 == null) {
                  var3 = var4.device();
                  var0 = vne.open(var3);
               }

               var0.play(var4.sound(), var4.on(), var4.gain(), var4.x(), var4.z());
               vok = var4.sound()
                  + (var4.on() ? a.c(1974901056, "饣\ue09d橏") : a.c(-470882698, "\ue652龬ᕶ謇"))
                  + a.d("\ue99c遽᪲蓎༁覠㏴먌␉", -2115848914, -1670620005)
                  + var0.playing()
                  + a.b("撍ᵰ鞦্舝ҽ뻥㜟\ua957⎩", 1388995751)
                  + AL10.alGetListenerf(4106)
                  + a.c(1301170145, "䟇㸱들⪝ꅍ➯")
                  + var4.gain();
            }
         } catch (Throwable var11) {
            if (var0 != null) {
               try {
                  var0.close();
               } catch (Throwable var9) {
               }

               var0 = null;
            }

            if (var11 instanceof LinkageError || var11 instanceof NullPointerException || var11 instanceof UnsupportedOperationException) {
               voh = true;
               System.out.println(a.d("⥧僙\uda0f䑲쾮䤅\uf302窠\ue4e3湈\ue980ᏻ鴻ә軟࠵뉵㶳ꜗⅎꢼ틠屐잏䇹쭷狞", 1273839578, -1471408443) + var11);
               break;
            }

            long var6 = System.currentTimeMillis();
            if (var6 - voj > 30000L) {
               voj = var6;
               System.out.println(a.c(228425904, "胆兩玮\uedd3昏\ue0a4媣팁䵂쟩䀡멚㓉괾❪ꆓᯙ鐁ຳ袼ő") + var11);
            }
         }
      }

      if (var0 != null) {
         try {
            var0.close();
         } catch (Throwable var8) {
         }
      }
   }

   public static String report() {
      return vok;
   }
}
