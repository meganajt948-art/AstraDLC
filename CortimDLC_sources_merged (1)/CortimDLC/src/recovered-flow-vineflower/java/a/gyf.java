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

final class gyf {
   private static final int gyg = 520;
   private static final String gyh = System.getenv(a.d("㮃䈸죨嚁\udd33寯\ue1b0桜\uf602粫ﭼĕ运", 1365182924, -835505660));
   private static final gxv[] gyi = new gxv[]{
      new gxv(0, a.d("럎칾䒭\udadd光ힽ淩\ue405穁\uf0e3眥赕", 60358362, 1470712182), 6000L, 20.0F, -6.0F, true),
      new gxv(50, a.b("릭쀝䫎풾弪\ud9de掊\uea66琢ﺀ祆茶ජ鑑ḋ飺", 349288915), 6000L, 20.0F, -6.0F, false),
      new gxv(100, a.d("猚પ聹ḉ閝፲ꤹ⃚", 2054751784, -1789037228), 6000L, 20.0F, -40.0F, true),
      new gxv(150, a.b("媏⌿ꧬ㞜밈㫧肬ॏ靄ᶷ驭怜", 31021805), 6000L, 20.0F, -40.0F, false),
      new gxv(200, a.b("扪ᯚ鄉ཹ蓭Ȗ롐ㆼ꿹╓ꊊ", 1711497743), 6000L, 200.0F, 24.0F, true),
      new gxv(250, a.d("姇⁷ꪤ㓔뽀㦩菿", -379485087, -1011163697), 6000L, 110.0F, -80.0F, true),
      new gxv(300, a.b("⭊勽\ud835䙙춘䬸", 2060266303), 12600L, 90.0F, -8.0F, true),
      new gxv(350, a.b("摐ᷧ霯ृ节Т븨㞛꧍⍼", 1983800361), 12600L, 90.0F, -8.0F, false),
      new gxv(400, a.c(-704540110, "鉊\uebfd愵ｙ璘\uf238䠲소忐핣劸"), 12600L, -90.0F, -8.0F, true),
      new gxv(450, a.c(849353471, "᪔挢\ue9ff瞁ﱊ"), 18000L, 20.0F, -10.0F, true),
      new gxv(500, a.d("뛚콬䖱\udbcf倄훬泽\ue505筚", -313265039, 202457804), 18000L, 20.0F, -10.0F, false),
      new gxv(550, a.c(1994568529, "댱쪅䁀\ude28"), 23300L, -90.0F, -8.0F, true),
      new gxv(600, a.b("⥼僖\uda0c䑸쾮䤈\uf35a竵\ue4e9湙\ue98aᏺ", 1480796419), 6000L, 20.0F, -6.0F, true, a.c(1054554636, "㩘䏒줈坼\udcaa娌\ue05e")),
      new gxv(650, a.c(-959936650, "蜚ﺢ瑹\uea42懋\ue77c崴퓘䪑쀱"), 12600L, 90.0F, -8.0F, true, a.c(193987550, "΅稍\uf0dd溵\ue57a揃\ud981偶츲䒉썿㤧럸")),
      new gxv(700, a.b("㒢䴚쟁姺퉮哞\uee8d杽", -1249102644), 6000L, 20.0F, -6.0F, true, a.d("龩\ue621泱\uf299祖\uffef䖭챚刞\ud8a5当ꔋ⯔", -677117518, -1169449408))
   };
   private static final String[] gyj = new String[]{
      a.c(-1930034235, "Ή程\uf0c1溰\ue549揈\ud980偿츯䒂"),
      a.c(-634180919, "⪒匚\ud9ca䞢챭䫔\uf096祡\ue725涞\uea68ူ黯"),
      a.c(1730274806, "\ue5a2鰨ᛲ袆͐藶㾤"),
      a.b("碸Ĳ诨ᖜ鹊ᣬꊞ⭗딚", -382371614),
      a.b("겾픭忥솉䩘쳨皗ｈ愎\uebb8", 41921785)
   };
   private static boolean[] gyk;
   private static volatile BlockPos gyl;
   private static volatile boolean gym;
   private static int gyn = -1;

   private gyf() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.c(281520761, "ꨩ펪好윙䳒쩮瀪"));
      if (var1 == 1) {
         gyk = new boolean[gyj.length];

         for (int var14 = 0; var14 < gyj.length; var14++) {
            kfe var16 = Flow.getInstance().getModuleManager().getByName(gyj[var14]);
            gyk[var14] = var16 != null && var16.isEnabled();
            if (gyk[var14]) {
               var16.setEnabled(false);
            }
         }

         var0.options.hudHidden = true;
         var0.options.pauseOnLostFocus = false;
         var0.options.getViewDistance().setValue(12);
         var0.options.getFov().setValue(70);
         gyt(var0, a.d("쌽몊さ긬◳ꍀᤘ部\u0ef2萀ς捻睷\ueed3撝\ue273堯", 1618221021, 822727830));
         gyt(var0, a.c(1050601701, "\ue89c鄫\u1bf4薍ํ裻㊱뭉╓꾦⡾툤峖앿伹짍玌ﱒ曽\ue09b楖ጝ鶡ٹ聃\u0ad4덠㴼\ua7d4↓"));
         gyt(var0, a.c(-988955079, "빃쟴䴫퍒墒\ude24摮\ued96玌凉纡蓨\u0a0d鎸᧾鼓║ꪗ〕뙾㾓䗍쭷僣훚尌\ue5b2毼\uf11d"));
         gyt(var0, a.c(1727764634, "飠\ue143殔\uf5f0縻\uf887䋃쭠啼\udfc2堘ꉭⲩ"));
         GLFW.glfwSetWindowSize(var0.getWindow().getHandle(), 1920, 1080);
         gyq(var0);
         return false;
      } else {
         if (var1 < 10) {
            return false;
         }

         if (gyn < 0) {
            if (!gym) {
               return false;
            } else {
               BlockPos var13 = gyl;
               if (var13 == null) {
                  System.out.println(a.b("\uf632辞Ռ鬥ჶ陟Ⱎꖬ㯩넖㛄쳺䉾\udbd2冀흩洨\ue2a0硑︋矺ඩ茒ᢆ麿ᑧ귎⎄륹", -1958414756));
                  return true;
               } else {
                  System.out.println(a.d("ꘪ\udf86啔쬽䃮왇簆\uf5ae殰\ue114暓", -391784404, 94928510) + var13.toShortString());
                  gyt(
                     var0,
                     a.b("ꉐ\udbe5兦콷䒓쉱", 1153802786) + var13.getX() + a.b("몒", -1421034829) + (var13.getY() + 7) + a.b("\ue034", 1230888981) + var13.getZ()
                  );
                  gyt(var0, a.c(1676439914, "焓ࢿ艨ᰑ鞃ᅡꬤ⋄볏㙨놽䯌씛"));
                  ((vlv)gys(var2, a.c(1458586027, "䇾㡹늮ⳍ꜆↶"))).set(a.d("秲}誩ᓂ鼄ᦢ", 389692322, -4046335));
                  ((vmc)gys(var2, a.c(-1925699973, "☢徢핢䬕샟䙤ﰸ痀\ueb89"))).set(0.6);
                  ((vmc)gys(var2, a.b("\uf3bb訥õ麞ᕘ鏾", -2072513538))).set(0.9);
                  ((vmc)gys(var2, a.b("\uf3f6詫»黂", -2031619151))).set(0.7);
                  ((vkl)gys(var2, a.c(1127850614, "ꈹ\udba4兴켆䓋쉽硼\uf1ca澀\ue522拴预"))).set(true);
                  var2.setEnabled(true);
                  vbb.timing(true);
                  gyn = var1;
                  return false;
               }
            }
         } else {
            var0.player.getAbilities().flying = true;
            if (var0.currentScreen != null) {
               var0.setScreen(null);
            }

            int var3 = var1 - gyn - 520;
            if (var3 == -40) {
               vbb.gpuMillis();
            }

            if (var3 == -1) {
               System.out.println(a.c(-1898928621, "Ꙭ\udfc0唒쭻䂨영籀\uf5e8毰\ue156暀鲤") + vbb.gpuMillis() + a.c(416545865, "ﱪ薖ཛ"));
            }

            for (gxv var7 : gyi) {
               if (gyh == null || var7.gxx.startsWith(gyh)) {
                  if (var3 != var7.gxw - 40) {
                     if (var3 == var7.gxw - 2) {
                        gyr(var0, var7.gxz, var7.gya);
                     } else if (var3 == var7.gxw) {
                        gyu(var0, a.d("闦\uec4a暘\uf8f1猢\uf58b俊왯", -1694075445, 955375702) + var7.gxx);
                     }
                  } else {
                     gyt(var0, a.b("\ue9d0遼᪫蓒ཀ覢㏧먇␌", -2070091347) + var7.gxy);
                     var2.setEnabled(var7.gyb);

                     for (String var11 : gyj) {
                        kfe var12 = Flow.getInstance().getModuleManager().getByName(var11);
                        if (var12 != null) {
                           var12.setEnabled(var11.equals(var7.gyc));
                        }
                     }

                     gyr(var0, var7.gxz, var7.gya);
                  }
               }
            }

            if (var3 > gyi[gyi.length - 1].gxw + 10) {
               vbb.timing(false);
               var0.options.hudHidden = false;

               for (int var15 = 0; var15 < gyj.length; var15++) {
                  kfe var17 = Flow.getInstance().getModuleManager().getByName(gyj[var15]);
                  if (var17 != null) {
                     var17.setEnabled(gyk[var15]);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      }
   }

   private static void gyq(MinecraftClient var0) {
      gyl = null;
      gym = false;
      IntegratedServer var1 = var0.getServer();
      BlockPos var2 = var0.player.getBlockPos();
      var1.execute(() -> {
         try {
            ServerWorld var2x = var1.getOverworld();
            Pair var3 = var2x.locateBiome(var0xx -> var0xx.matchesKey(BiomeKeys.SNOWY_PLAINS), var2, 6400, 32, 64);
            if (var3 != null) {
               BlockPos var4 = (BlockPos)var3.getFirst();
               var2x.getWorldChunk(var4);
               int var5 = var2x.getTopY(Type.MOTION_BLOCKING, var4.getX(), var4.getZ());
               gyl = new BlockPos(var4.getX(), var5, var4.getZ());
            }
         } catch (Throwable var6) {
            System.out.println(a.d("嶶␚껈ァ뭲㷛螚า逡᪓鵌朿\ue9fd灝碑糼운䥭폛喃\udc75ꙺ⣓", -927411646, 1204457360) + var6);
         }

         gym = true;
      });
   }

   private static void gyr(MinecraftClient var0, float var1, float var2) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
   }

   private static vmo gys(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.b("醿\ue846抜ﳿ睻\uf184䯖쉨", 973115799) + var1);
   }

   private static void gyt(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   private static void gyu(MinecraftClient var0, String var1) {
      System.out.println(a.c(-100638969, "彾⛙갃㉸맩㼌蕎\u0ca9鋱᠔") + var1 + a.c(210580171, "㋨䬹솊") + var0.getCurrentFps() + a.d("ﵶ蒁ไ逶", 593010428, 928801710));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.d("碼ć诗ᖾ鸬ᢂ", -97740393, 974643531) + var1 + a.c(672632092, "贶\uf4d9縔\ue06c"),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
