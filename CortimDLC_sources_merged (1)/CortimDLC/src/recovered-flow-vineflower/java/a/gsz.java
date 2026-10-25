package a;

import com.mojang.datafixers.util.Pair;
import flow.Flow;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.biome.BiomeKeys;
import org.lwjgl.glfw.GLFW;

final class gsz {
   private static final gsp[] gta = new gsp[]{
      new gsp(
         a.d("浶ᓙ鸍f讠ആ", -878195154, -1436900567),
         BiomeKeys.field_34471,
         a.b("뇋졄䊐\udcfb圽톛", 874033562),
         a.d("⡲凥\udb2d䕁캀䠠", 371511944, 1487469231),
         23200L,
         22,
         12.0F
      ),
      new gsp(
         a.d("ᨣ掑\ue940眪ﳺ穂", 422327074, 1503996276),
         BiomeKeys.field_42720,
         a.d("嶆␔껅ク뭿㷇", 979024687, -598022404),
         a.d("尒▌꽜ㄷ뫱㱗", -1801127239, -2080987410),
         2500L,
         24,
         18.0F
      ),
      new gsp(a.c(-1523574204, "ᨱ掆\ue94d眼ﳣ穅"), BiomeKeys.field_9455, a.b("㍴䫣쀨幙햆匠", -1463864543), a.d("\ue39e騉Ⴡ躭լ菌", -1146735706, 1428541549), 11900L, 14, 12.0F),
      new gsp(a.c(-564303336, "橿Ꮪ餈ݸ買ਅ"), BiomeKeys.field_9412, a.b("࿙癜ﲎ拾\ue931澃", -866512994), a.d("뛣콴䖼\udbd0們횱", -412317646, 1636646532), 11400L, 12, 14.0F)
   };
   private static final float[] gtb = new float[]{0.0F, 45.0F, 90.0F, 135.0F, 180.0F, 225.0F, 270.0F, 315.0F};
   private static final int gtc = 760;
   private static final int gtd = 30;
   private static int gte = -1;
   private static int gtf;
   private static volatile BlockPos gtg;
   private static volatile boolean gth;

   private gsz() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      if (var1 == 1) {
         var0.field_1690.field_1842 = true;
         var0.field_1690.method_42503().method_41748(14);
         var0.field_1690.method_41808().method_41748(80);
         gto(var0, a.c(1156041940, "첡딖㿉ꆰ⩯곜ᚄ齴Ů讌\u0c5c\uf638磩\ue14f欉\ueded垹\ud875"));
         gto(var0, a.d("뚒켥䗺\udb83偃훵沿\ue547筝\uf1a8癰谪˘魱ᄷ韃ⶂꉜ㣳뺕㝘䴓쎯塷\ude4d哚\ued6e挲栗羝", 2120442414, -1230515003));
         gto(var0, a.c(84599634, "\ue328骟၀踹\u05f9荏㤅냽⻧ꐒ⏊\ud983坦컓䒕쉸砺\uf7fc浾\ueb15拸ᢦ阜ඈ讱ŧ룙㚗걶"));
         gto(var0, a.b("㠝䆾쭩唍\udec6塺\ue23e殝\uf581缿\uf8e5ʐ豔", 201799783));
         GLFW.glfwSetWindowSize(var0.method_22683().method_4490(), 2560, 1440);
         return false;
      } else if (var1 < 30) {
         return false;
      } else if (gte >= 0 && var1 - gtf <= 760 + 30 * (gtb.length + 1)) {
         gsp var2 = gta[gte];
         int var3 = var1 - gtf;
         if (var3 == 1 && !gth) {
            gtf++;
            return false;
         } else {
            if (var3 == 2) {
               BlockPos var4 = gtg;
               if (var4 == null) {
                  System.out.println(a.b("\ue277鯖ᄃ轹ҥ舃㡛뇩⾬ꕓ⊁\ud8bf", 1677648392) + var2.gsq + a.d("둤춗䝏\ud938勭푔湂\ue7f5禣\uf308瓀躻", -1552266980, 754122068));
                  gtf = gtf - (760 + 30 * (gtb.length + 2));
                  return false;
               }

               System.out.println(a.d("䟢㹃뒖⫬ꄰ➖鷎ᑦ", -1604960081, 296814390) + var2.gsq + a.b("㏥䨕샓延", -1964428351) + var4.method_23854());
               gto(
                  var0,
                  a.b("ঠ瀕殺撇\uef63榁", 1543768530)
                     + var4.method_10263()
                     + a.d("嘂", -1117605996, -1561200201)
                     + (var4.method_10264() + var2.gsv)
                     + a.b("䣠", 1602439361)
                     + var4.method_10260()
               );
               gto(var0, a.b("䗊㱦뚱⣈ꍚ▸鿽ᘝ蠖", 258622903) + var2.gsu);
               kfe var5 = Flow.getInstance().getModuleManager().getByName(a.c(-2115444146, "\ue21e鮝ᅊ輮ӥ艙㠝"));
               ((vlv)gtn(var5, a.b("렘솟䭈픫廠\ud850", -63457203))).set(var2.gss);
               ((vmc)gtn(var5, a.c(-616545494, "䍳㫳뀳⹄ꖎ⌵饩႑軘"))).set(0.0);
               var5.setEnabled(true);
               kfe var6 = Flow.getInstance().getModuleManager().getByName(a.d("ﾦ蘬\u0cf6銂ᥔ鿲▀걉㈄", 537509517, 989413745));
               ((vlv)gtn(var6, a.b("ࠆ熏פֿ", 1877084246))).set(var2.gst);
               var6.setEnabled(true);
               gtm(var0, gtb[0], var2.gsw);
            }

            String var7 = System.getenv(a.b("矕\u0e6e蒾\u1ad7酥ឹ귦␇멞ヤ뜼䵚쎆娱큤嚍\uecd4", 1040283522));

            for (int var8 = 0; var8 < gtb.length; var8++) {
               if (var7 == null || var7.equals(String.valueOf((int)gtb[var8]))) {
                  if (var3 == 760 + 30 * var8 - 12) {
                     gtm(var0, gtb[var8], var2.gsw);
                  } else if (var3 == 760 + 30 * var8) {
                     gtp(var0, a.d("ꓲ\udd53垆짼䈠쒆绞\uf77b", -718130612, 915510981) + var2.gsq + a.b("꽓", 1538830207) + (int)gtb[var8]);
                  }
               }
            }

            return false;
         }
      } else {
         gte = gtk(gte);
         if (gte >= gta.length) {
            var0.field_1690.field_1842 = false;
            return true;
         } else {
            gtf = var1;
            gtl(var0, gta[gte]);
            return false;
         }
      }
   }

   private static int gtk(int var0) {
      String var1 = System.getenv(a.b("嚟⼤ꗴ㮝뀯㛳責Ս鬔ᆮ陶氐\ue2cc", -1269737772));

      for (int var2 = var0 + 1; var2 < gta.length; var2++) {
         if (var1 == null || var1.contains(gta[var2].gsq)) {
            return var2;
         }
      }

      return gta.length;
   }

   private static void gtl(MinecraftClient var0, gsp var1) {
      gtg = null;
      gth = false;
      IntegratedServer var2 = var0.method_1576();
      BlockPos var3 = var0.field_1724.method_24515();
      var2.execute(() -> {
         try {
            ServerWorld var3x = var2.method_30002();
            Pair var4 = var3x.method_42108(var1xx -> var1xx.method_40225(var1.gsr), var3, 6400, 32, 64);
            if (var4 != null) {
               BlockPos var5 = (BlockPos)var4.getFirst();
               var3x.method_8500(var5);
               int var6 = var3x.method_8624(Type.field_13197, var5.method_10263(), var5.method_10260());
               gtg = new BlockPos(var5.method_10263(), var6, var5.method_10260());
            }
         } catch (Throwable var7) {
            System.out.println(a.d("춷됖㻃ꂹ⭥귃ល鸳 誒്\uf73e秼\ue05c橊\uecfd嚵\ud96c䏚얂䱴㙻룒", -27897094, 1537711913) + var7);
         }

         gth = true;
      });
   }

   private static void gtm(MinecraftClient var0, float var1, float var2) {
      var0.field_1724.method_36456(var1);
      var0.field_1724.method_36457(var2);
      var0.field_1724.field_5982 = var1;
      var0.field_1724.field_6004 = var2;
   }

   private static vmo gtn(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.b("캜띥㶿ꏜ⡘꺧ᓵ鵋", -64762188) + var1);
   }

   private static void gto(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void gtp(MinecraftClient var0, String var1) {
      System.out
         .println(
            a.b("ഄ璥ﹰ怊\uebd6浰휨庀", 2146307455)
               + var1
               + a.c(2123466663, "螆")
               + var0.method_22683().method_4489()
               + a.d("깳", 1458510976, -200953206)
               + var0.method_22683().method_4506()
         );
      ScreenshotRecorder.method_22690(
         var0.field_1697, a.d("届◱꼡ㅈ뫚㱴", 1654742764, -1083571514) + var1 + a.c(958105761, "袋\uf164箩\ue5d1"), var0.method_1522(), 1, var0x -> {}
      );
   }
}
