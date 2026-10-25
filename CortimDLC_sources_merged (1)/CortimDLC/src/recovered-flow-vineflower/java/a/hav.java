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

final class hav {
   private static final int haw = 560;
   private static final String hax = System.getenv(a.d("薠ﰛ盋\ue8a2挐\ue5cc従홤䠣슒䕉뼯ㇹꡐ∑", 1348907992, 1368667697));
   private static final String hay = System.getenv()
      .getOrDefault(a.c(1052766470, "\uf154裯ȿ鱖៤鄸⭧ꊐ㳗뙦ㆽ쯛䔁\udcbe囩퀌橎\ue59a缴泌"), a.d("\ud81bꆂ⭐딬㻧롎", 1311960287, 346961039));
   private static final haj[] haz = new haj[]{
      new haj(0, a.b("붯쐟仌킼嬨\uddc7枌\uee6f", 1730854345), 6000L, 20.0F, -35.0F, 2, true),
      new haj(60, a.c(-1250528478, "獀૰耣ṓ闇ጨꥣ₀뺋㑸뎢䧓"), 6000L, 20.0F, -35.0F, 2, false),
      new haj(120, a.c(2103949630, "륜샬䨿푏忛\ud92f捻\uea97瓓ﹱ禷菇"), 6000L, 20.0F, -4.0F, 2, true),
      new haj(150, a.c(370769509, "縃\u07b3赠ጐ预Ṩꐪⷔ"), 6000L, 0.0F, -25.0F, 2, true),
      new haj(180, a.b("筟˯蠼ᙌ鷘ᬱꅧ", -1618642122), 6000L, 110.0F, -80.0F, 2, true),
      new haj(240, a.d("喋ⰸ꛶㢛덋㗽辧\u061c頝ኪ镢", -315705304, 1683484101), 1000L, -90.0F, -14.0F, 2, true),
      new haj(300, a.d("칷럄㴊ꍧ⢷긁ᑛ鷠ϡ襖ພ\uf4ac稹\ue381槒", 831321394, 1505377063), 1000L, -90.0F, -14.0F, 2, false),
      new haj(360, a.c(926335586, "숃뮰ㅾ꼓Ⓝꉵᠯ醔ྕ蔾ˠ\uf890"), 1000L, -20.0F, -4.0F, 2, true),
      new haj(420, a.b("ཞ盭ﰣ扎\ue99e漨핲峉싏䡸쾼㗍묌", -2123690178), 600L, -90.0F, -6.0F, 2, true),
      new haj(480, a.d("쓳뵄㞌ꧠ∡ꒁ", 147622881, -102084761), 12300L, 90.0F, -8.0F, 2, true),
      new haj(540, a.c(-1773026547, "썴뫃》깧▦ꌆᤌ邿\u0ee9葘"), 12300L, 90.0F, -8.0F, 2, false),
      new haj(600, a.b("䌉㪾끶⸚ꗛ⍻饱\u10cf躓Р菻", 1323713393), 12300L, -90.0F, -12.0F, 2, true),
      new haj(660, a.b("ⷀ呹\udea9䃐쬆䶼\uf7ac縘\ue046櫹\ued25", -699454036), 11500L, 90.0F, -2.0F, 30, true),
      new haj(720, a.b("\ude99ꜳⷩ뎝㡁뻨ҿ贐ጊ馺ṧ\ue419", 1023401702), 6000L, 30.0F, 50.0F, 60, true),
      new haj(780, a.c(1911884212, "য়灩華擊\uef01"), 18000L, 20.0F, -25.0F, 2, true),
      new haj(840, a.b("⦀倲\udaec䒄콀䦹\uf3a4穚\ue406溭\ue96fጉ", 175057389), 7000L, 20.0F, 25.0F, 260, true),
      new haj(900, a.c(-2092010399, "琁භ蜧ᤘ鋀ᑲ긻⟛릓"), 6000L, 20.0F, 0.0F, 170, true),
      new haj(960, a.c(-1176433532, "ೲ畐ﾋ懽"), 6000L, 20.0F, -20.0F, 2, true, a.d("\ufafd荟\u0984韲", 401680025, -1705321454)),
      new haj(1080, a.d("莤切烄\ueea1攽\ue3cd妝클", 2003681537, 45236957), 6000L, 20.0F, -30.0F, 2, true, a.c(-373607180, "㒒䴬쟶妃퉇"), a.c(-713203076, "戳ᮡ酪")),
      new haj(
         1180,
         a.d("怨ᦌ鍈ഭ蚱@먛㏫궹✔ꃟ", 331392141, 1608762590),
         6000L,
         20.0F,
         -30.0F,
         2,
         true,
         a.d("㍻䫅쀟幪햮", -1770025454, -1143161585),
         a.b("ᘿ澦\ue574笈\uf0c3癪", 1478497908)
      ),
      new haj(1280, a.c(1740664733, "濤ᙀ鲄ˡ襽ྉ뗛㰤ꉴ"), 6000L, 20.0F, -30.0F, 2, true, a.c(627887870, "캘뜦㷼ꎉ⡍"), a.d("\ue8e3酳ᮮ藐", -1769312283, 586450762)),
      new haj(1380, a.b("䪼㌘맜➹갥⫖邌\u197d", 1375488708), 6000L, 20.0F, -30.0F, 2, false, a.d("ь緲\uf728楝\ue299", 534657431, 1913470397), a.b("䤭ゴ멦␚꿑⥸", 1085950310))
   };
   private static final String[] hba = new String[]{
      a.b("\ud90fꂍ⩇됶㿏륎̆諹ᒩ鸄", 1648679235),
      a.d("鱆\ue5ce漞\uf176窹ﰀ䙂쾵凱\udb4a岼ꛤ⠻", 2074228230, -696210917),
      a.b("殆ሌ飖ڢ赴\u0bd2놀", 1224305618),
      a.c(1310775573, "\ud94fꃅ⨟둫㾽뤛ͩ誠ᓭ"),
      a.d("䌠㪳끻⸗ꗆ⍶餉ზ躐Ц", -1950737812, 1473992971)
   };
   private static boolean[] hbb;
   private static volatile BlockPos hbc;
   private static volatile boolean hbd;
   private static int hbe = -1;
   private static int hbf = 2;

   private hav() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.b("ⶍ后\uded9䂽쭶䷊\uf78e", 399125981));
      if (var1 == 1) {
         hbb = new boolean[hba.length];

         for (int var8 = 0; var8 < hba.length; var8++) {
            kfe var10 = Flow.getInstance().getModuleManager().getByName(hba[var8]);
            hbb[var8] = var10 != null && var10.isEnabled();
            if (hbb[var8]) {
               var10.setEnabled(false);
            }
         }

         var0.field_1690.field_1842 = true;
         var0.field_1690.field_1837 = false;
         var0.field_1690.method_42503().method_41748(12);
         var0.field_1690.method_41808().method_41748(70);
         hbo(var0, a.d("䝁㻶됩⩐ꆏ✼鵤ᒔ誎|螾緘\uf30b檯\ue0e1昏\udc53", -1572610255, -1307994106));
         hbo(var0, a.d("⏴婃킜以씥䎓慄瀡\uee3b擎\ue316᥌鞾ท葑ʥ룤㜺궕⯳ꈾ\ud875囉촑䬫솼砈\uf654沼\ueafb", -1818013770, -2041680837));
         hbo(var0, a.b("仒㝥붺⏃ꠃ⺵铿ᴇ茝২踰瑹煮挩\ue96f澂헀娆삄䛯켂땜㯦ꁲ♋겝ᔣ魭ƌ", -1012248920));
         hbo(var0, a.d("↋堨틿䲛읐䇬ﮨ爋\uec17暩\ue173ᬆ闂", -1765912565, -1984794118));
         GLFW.glfwSetWindowSize(var0.method_22683().method_4490(), 1920, 1080);
         hbj(var0);
         return false;
      } else if (var1 < 10) {
         return false;
      } else if (hbe < 0) {
         if (!hbd) {
            return false;
         } else if (hbc == null) {
            System.out.println(a.d("䟈㹿뒴⫅ꄚ➼鷮ᐇ詊¸蝱絎\uf398橦\ue073暋\udcd9匟즺俬왏뱘㋢ꤩ⽍ꖖ", 424227595, -1101826902));
            return true;
         } else {
            System.out.println(a.c(655411913, "쪷대㧋Ꞻⱥ\uaac3႑饸ܵ距\u0a4f\uf02b纨") + hbc.method_23854());
            hbi(var0, 2);
            hbo(var0, a.c(-1938870532, "⺅圩\uddfe䎇정价\uf4b2絒\ue359槾\uee2bᑚ骍"));
            ((vlv)hbn(var2, a.c(793307129, "\ue7ac鸫ᓼ誟Ŕ蟤"))).set(a.d("\udb92ꈅ⣎뚿㵠믆", -1953456993, 1671513944));
            ((vlv)hbn(var2, a.b("Č碙\uf25e氢\ue7f0慜\udb02", -576454310))).set(hay);
            ((vmc)hbn(var2, a.c(-796938429, "꼚횚屚숭䧧콜甀ﳸ抱"))).set(0.6);
            ((vmc)hbn(var2, a.b("桪ᇭ鬦Տ躁ࠩ뉼", -1262655442))).set(0.5);
            ((vmc)hbn(var2, a.c(-988393300, "僷⥠ꎨ㶗똒グ諻̀"))).set(0.7);
            ((vmc)hbn(var2, a.d("㺸䜬췱厏\ud844庡\ue4a1测\uf31d禫﹪М", -1869731792, -976611640))).set(0.6);
            ((vkl)hbn(var2, a.c(178064093, "ઓ猍利架\uec70檅킅奯윹䶍쩕〼뻯"))).set(true);
            ((vkl)hbn(var2, a.d("䮰㈭룽⚏굂⯴釵ᡃ蘉ಫ譽焍", -1451883717, -1811855164))).set(true);
            var2.setEnabled(true);
            uze.timing(true);
            hbe = var1;
            return false;
         }
      } else {
         var0.field_1724.method_31549().field_7479 = true;
         if (var0.field_1755 != null) {
            var0.method_1507(null);
         }

         int var3 = var1 - hbe - 560;
         if (var3 == -40) {
            uze.gpuMillis();
         }

         if (var3 == -1) {
            System.out.println(a.b("Ǆ硳\uf2b8泉\ue716憰\udbe2刋챆䚮섺㭜떎ⱪ", -1134165575) + uze.gpuMillis() + a.c(1190163248, "猓૯耢"));
         }

         for (haj var7 : haz) {
            if (hax == null || var7.hal.startsWith(hax)) {
               if (var3 == var7.hak - 50) {
                  hbo(var0, a.c(-82440434, "ཱི盟ﰈ扱\ue9e3漁필岤슯") + var7.ham);
                  hbo(var0, a.b("㤎䂭쩺吞\udfd5奩\ue32d檎", 1222785393) + var7.har);
                  if (var7.hap != hbf) {
                     hbi(var0, var7.hap);
                  }

                  var2.setEnabled(var7.haq);
                  ((vlv)hbn(var2, a.d("峯╺꾽㇁먓㲿蛡", 1006273857, -1823942152))).set(var7.has);
                  hbm(var0, var7.han, var7.hao);
               } else if (var3 == var7.hak - 20) {
                  uze.gpuMillis();
                  hbm(var0, var7.han, var7.hao);
               } else if (var7.hal.endsWith(a.c(-1933322089, "\ud8e4ꅄ⮘")) && var3 > var7.hak - 25 && var3 < var7.hak) {
                  hbm(var0, var7.han + (var3 - (var7.hak - 25)) * 1.6F, var7.hao);
               } else if (var3 == var7.hak - 2) {
                  hbm(var0, var7.han, var7.hao);
               } else if (var3 == var7.hak) {
                  System.out
                     .println(
                        a.b("ꟷ\ude40咋쫺䄥잃緑\uf438橵\ue09d", 399157134) + var7.hal + a.b("엡밗㛓ꢧ⌥", -1349007932) + uze.gpuMillis() + a.c(-772547484, "\udc47ꖻ⽶")
                     );
                  hbp(var0, a.c(694147488, "\ud9d9ꁮ⪥듔㼋릭Ͽ訖ᑛ麾") + var7.hal);
               }
            }
         }

         if (var3 > haz[haz.length - 1].hak + 10) {
            uze.timing(false);
            hbo(var0, a.c(2008863721, "펓ꨰ⃧뺃㕈돴র耓ḏ钱፫\ue91e柚"));
            var0.field_1690.field_1842 = false;

            for (int var9 = 0; var9 < hba.length; var9++) {
               kfe var11 = Flow.getInstance().getModuleManager().getByName(hba[var9]);
               if (var11 != null) {
                  var11.setEnabled(hbb[var9]);
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   private static void hbi(MinecraftClient var0, int var1) {
      hbf = var1;
      BlockPos var2 = hbc;
      hbo(
         var0,
         a.b("桱ᇄ魇Ֆ躲ࡐ", -1251710973)
            + var2.method_10263()
            + a.b("\uf435", -1131416556)
            + (var2.method_10264() + var1)
            + a.b("舁", 706380320)
            + var2.method_10260()
      );
   }

   private static void hbj(MinecraftClient var0) {
      hbc = null;
      hbd = false;
      IntegratedServer var1 = var0.method_1576();
      BlockPos var2 = var0.field_1724.method_24515();
      var1.execute(() -> {
         try {
            ServerWorld var2x = var1.method_30002();
            Pair var3 = var2x.method_42108(var0xx -> var0xx.method_40225(BiomeKeys.field_9409), var2, 6400, 32, 64);
            if (var3 != null) {
               BlockPos var4 = (BlockPos)var3.getFirst();
               BlockPos var5 = null;
               int var6 = -1;

               for (byte var7 = -64; var7 <= 64; var7 += 4) {
                  for (byte var8 = -64; var8 <= 64; var8 += 4) {
                     int var9 = var4.method_10263() + var8;
                     int var10 = var4.method_10260() + var7;
                     int var11 = hbl(var2x, var9, var10);
                     if (var11 > var6) {
                        var6 = var11;
                        var5 = new BlockPos(var9, hbk(var2x, Type.field_13197, var9, var10), var10);
                     }
                  }
               }

               hbc = var5;
            }
         } catch (Throwable var12) {
            System.out.println(a.c(64572735, "䵕㓢븩⁘ꮇⴡ靳ẚ胗ਿ趠矒契悺\ueafc氜혖妁쌵䕬첞뛆㡴ꏻ▞") + var12);
         }

         hbd = true;
      });
   }

   private static int hbk(ServerWorld var0, Type var1, int var2, int var3) {
      var0.method_8497(var2 >> 4, var3 >> 4);
      return var0.method_8624(var1, var2, var3);
   }

   private static int hbl(ServerWorld var0, int var1, int var2) {
      int var3 = 0;
      int var4 = 0;

      for (byte var5 = -12; var5 <= 12; var5 += 2) {
         for (byte var6 = -12; var6 <= 12; var6 += 2) {
            int var7 = hbk(var0, Type.field_13197, var1 + var6, var2 + var5);
            int var8 = hbk(var0, Type.field_13203, var1 + var6, var2 + var5);
            boolean var9 = Math.abs((int)var6) <= 4 && Math.abs((int)var5) <= 4;
            if (var7 == var8) {
               if (var9) {
                  var3++;
               }
            } else if (!var9) {
               var4++;
            }
         }
      }

      return var3 == 25 ? 100 + Math.min(var4, 60) : var3;
   }

   private static void hbm(MinecraftClient var0, float var1, float var2) {
      var0.field_1724.method_36456(var1);
      var0.field_1724.method_36457(var2);
      var0.field_1724.field_5982 = var1;
      var0.field_1724.field_6004 = var2;
   }

   private static vmo hbn(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.c(1185857171, "뺻읂䶘폻塿\ude80擒\ued6c") + var1);
   }

   private static void hbo(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void hbp(MinecraftClient var0, String var1) {
      System.out
         .println(
            a.b("讼\uf21b磁\ue6ba洫\uebce册\ud86b䘳쳖", 387877829)
               + var1
               + a.d("놆졗䋤", -2081660703, -1918774972)
               + var0.method_47599()
               + a.b("\uf4b2赅ހ駲", -1447955306)
         );
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.b("꼿횄屔숽䦯켁", -1107120289) + var1 + a.c(2121033031, "敭ᲂ陏࠷"),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
