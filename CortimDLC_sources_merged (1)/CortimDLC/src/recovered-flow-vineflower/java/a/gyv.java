package a;

import flow.dev.a;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;

public final class gyv {
   private static final boolean gyw = System.getenv(a.d("П綤\uf774椝\ue2af摳\ude2c埞증䌡쓠㺊끊⧳ꎲ╊鼊თ試ి", 976739528, -1374365563)) != null;
   private static final float[] gyx = gyw
      ? new float[]{0.6F, 2.5F, 5.3F, 5.9F, 6.5F, 7.2F, 8.2F, 9.2F, 10.0F, 10.6F}
      : new float[]{0.15F, 0.35F, 0.6F, 0.9F, 1.2F, 1.55F, 1.95F, 2.35F, 2.8F, 3.6F, 4.6F, 5.35F, 5.75F, 6.05F, 6.35F};
   private static int gyy;
   private static long gyz;
   private static int gza;
   private static int gzb;

   private gyv() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.b("ங爢\uf8f2暛\ued09殤톪塍옛䲠쭡\u3101뿀♶", -1289942031))
         && a.c(-158508991, "場ↆꭉ㔵뻰㡚").equals(System.getenv(a.b("ꟷ\ude4c咜쫵䅇잛緄\uf423橵\ue0ce朏鵯Ꭾ記@蚽㳢댵⦍꿗", 1698539429)))) {
         ClientTickEvents.END_CLIENT_TICK.register(gyv::gzf);
      }
   }

   private static float gze() {
      return (float)(System.nanoTime() - gyz) / 1.0E9F;
   }

   private static void gzf(MinecraftClient var0) {
      switch (gyy) {
         case 0:
            if (var0.getOverlay() instanceof FlowSplash) {
               gyz = System.nanoTime();
               gyy = 1;
            }
            break;
         case 1:
            if (var0.getOverlay() == null) {
               System.out.println(a.c(1738700540, "皫༙藖᮪遯ᛅ곞╻묵㆒뙆䱣싶孊턙埳\uede8扶\uf8dc纞\uf77e贱Ώ顆Ṡ银ⵍꌝ㧡뿵㐇쫑䂌\ud96c弨헋") + gze() + a.b("变⨺", 16536570));
               gyy = 2;
               gzb = 0;
            }
            break;
         case 2:
            if (var0.world != null && var0.player != null && var0.currentScreen == null && var0.getOverlay() == null) {
               if (++gzb == 1) {
                  gzh();
               }

               if (gzb > 60) {
                  if (gyw) {
                     gzg(false);
                  }

                  Splash.preview(var0, 5.0F, true);
                  gyz = System.nanoTime();
                  gza = 0;
                  gyy = 3;
               }
            }
            break;
         case 3:
            float var2 = gze();
            if (gza < gyx.length && var2 >= gyx[gza]) {
               gzi(var0, a.d("ꃳ\ud941厎췲䘷삝窋", 1799572683, 1687022668) + gza, var2);
               gza++;
            }

            if (gza >= gyx.length && var0.getOverlay() == null) {
               System.out.println(a.b("ⴷ咅\ude4a䀶쯳䵙\uf742继\ue0a9樎\uedda\u17ff饸Ë誏౭똽㧠ꍁ╇곷횮堜쏆䗼콬盘\uf89b扽\ue43b濚", -7721637) + var2 + a.c(1490806940, "\ue8be酜"));
               if (gyw) {
                  gzi(var0, a.c(-305119411, "㼫䚙챖刪\ud9ef彅\ue553泸\uf2b5砍\uffd1֬譹ዀ飛Ṵꐫ⯫녏㜞뻢"), var2);
                  gzg(true);
                  var0.setScreen(null);
               }

               gyy = 4;
               gzb = 0;
            } else if (var2 > 20.0F) {
               System.out.println(a.b("ꔐ\udca2噭접䏔앾罥\uf6c0梎\ue229旽鿘ᅩ裟ʄ葰㹟놂⭡괲ⓒ庐퀼䯡춌䜊ﻪ炼\uea56氂\ue7b1\u192c錶ૂ賁ر맡㎂땀⳦ꛫ\ud808剙헸佼", -1703434930));
               gyy = 9;
               var0.scheduleStop();
            }
            break;
         case 4:
            if (++gzb > 30) {
               Splash.requestAfterInject();
               gyz = System.nanoTime();
               gyy = 5;
            }
            break;
         case 5:
            float var1 = gze();
            if (var0.getOverlay() instanceof FlowSplash && gzb > 0) {
               gzb = -1;
               System.out.println(a.d("悉᤻鏴ඈ虍ç뫼㍙괗➰ꁤ婁퓄䵢융䇉\ufbca瑉\ueeed梵\ue141鬞ᖨ踽ࠃ苗㭯딡⿒ꦒ∠", 1124949631, 1472544410));
            }

            if (gzb < 0 && var0.getOverlay() == null) {
               System.out
                  .println(
                     a.b("ﵜ蓮ม遝ᮘ鴲✩꺌ヂ멥㶱잔䤳킓嫒\udc23易\ue9ce猯\uf569粚ۆ蠹Ꮊ闒Ἂꚺ⣥눗㐂뿾䄶쭪劌퓁幽\ue1b2殚\ued0e璷ﻩ耓ਅ践ᜥ饆₄ꨢⰿ", -825754338)
                        + var1
                        + a.d("\udedfꜽ", -1053383851, -1439793752)
                  );
               gyy = 9;
               var0.scheduleStop();
            } else if (var1 > 40.0F) {
               System.out.println(a.b("튢\uab10⇟뾣㑦닌ࣗ腲Ἴ閛\u124f\ue86a曛ｭ甶\uf3c2䧭옰峑\uda97卤⤸Ꟈ㱄먬ヴ襄ܛ鷩᯦遏", -281423154) + var0.getOverlay());
               gyy = 9;
               var0.scheduleStop();
            }
      }
   }

   private static void gzg(boolean var0) {
      try {
         Field var1 = wap.class.getDeclaredField(a.d("硞Ǥ謰ᕝ麜ᠦ", -1349352270, 1268251785));
         var1.setAccessible(true);
         var1.setBoolean(null, var0);
      } catch (ReflectiveOperationException var2) {
         System.out.println(a.b("렓송䭮픒廗\ud87d扦\uebc3疍Ｊ磾苛\u0c4f闼ᾠ餘⌄겁㙡뀦㧀䏅촢囯킝娉\ue3f6涪\uf752焊磌Ѯ踧។釂ᬠꓰ⺔ꡒㇲ믲씙", 1209382986) + var2);
      }
   }

   private static void gzh() {
      try {
         Field var0 = gtq.class.getDeclaredField(a.c(-503078855, "ꁏ\ud9f9匿쵛䚝"));
         var0.setAccessible(true);
         var0.setInt(null, 99);
      } catch (ReflectiveOperationException var1) {
         System.out.println(a.c(805425130, "쾿똍㳂ꊾ⥻꿑ᗊ鱯ȡ袆དྷ\uf577篣\ue250栌\ueeb4咨\udb2d䇎잎乪㐢뫚⅟Ꜽⷠ鐖ᨔ胵ڭ贔玃輦恸\ue63d沋팒她") + var1);
      }
   }

   private static void gzi(MinecraftClient var0, String var1, float var2) {
      System.out
         .println(
            a.b("ᬛ抩\ue866瘚\ufddf筵셮䣋횅尢\udbf6⇓", -1286661276)
               + var1
               + a.c(441512652, "\uf2ef謊Ɛ")
               + var2
               + a.c(135231358, "睝ຌ萿")
               + var0.getCurrentFps()
               + a.c(1389960858, "Ế杉\ued8c現")
         );
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory, a.d("\ueaf1鍊ᦚ蟳ౡ諏", 2062906485, -2022662428) + var1 + a.b("蛜Ｓ痾\ueb86", 391350006), var0.getFramebuffer(), 1, var0x -> {}
      );
   }
}
