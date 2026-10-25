package a;

import com.sun.management.OperatingSystemMXBean;
import flow.dev.a;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.util.ScreenshotRecorder;
import org.lwjgl.glfw.GLFW;

public final class hem {
   private static final float[] hen = new float[]{0.4F, 1.2F, 1.45F, 2.5F, 4.0F, 5.9F, 6.6F, 8.0F};
   private static final float[] heo = new float[]{1.0F, 1.6F, 3.0F};
   private static int hep;
   private static long heq;
   private static int her;
   private static int hes;
   private static jte het;
   private static kbs heu;
   private static String hev;
   private static int hew = -1;
   private static long hex;
   private static long hey;

   private hem() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.b("と䧓쌃嵪훸偕\uea5b掼\ufdea睑\uf090૰萱ᶇ", 767963136))
         && a.c(1596259544, "ﲫ蔅\u0fdb醫᩶").equals(System.getenv(a.d("휍꺶⑦먏ㆽ띡ാ蓙\u1a8f逴៵\ued95捔\ufae2為\uf647䰘쏏奷\udf2d", -1768064936, -1743671545)))) {
         ClientTickEvents.END_CLIENT_TICK.register(hem::hfd);
      }
   }

   private static float hfb() {
      return (float)(System.nanoTime() - heq) / 1.0E9F;
   }

   private static void hfc() {
      heq = System.nanoTime();
      her = 0;
   }

   private static void hfd(MinecraftClient var0) {
      hes++;

      try {
         hfe(var0);
      } catch (Throwable var2) {
         System.out.println(a.b("仹㝗붉⏹ꠤ⻚铝ᴽ荴ূ蹅瑒廒挻\ue96d濪햿", -1621799266) + var2);
         var2.printStackTrace();
         hep = 99;
         var0.method_1592();
      }
   }

   private static void hfe(MinecraftClient var0) throws Exception {
      switch (hep) {
         case 0:
            if (var0.method_18506() == null && var0.field_1755 instanceof AccessibilityOnboardingScreen) {
               var0.field_1690.field_41785 = false;
               var0.method_1507(new TitleScreen());
            }

            if (var0.method_18506() == null && var0.field_1755 instanceof jte var8 && hes > 60) {
               het = var8;
               heu = kbs.selected();
               hfg(kbs.byKey(a.c(-1424319468, "鱯\ue5c1漟\uf16f窲ﱖ䙌쾾凰\udb52岘ꛮ⠰")));
               hfc();
               hep = 1;
            }
            break;
         case 1:
            if (her < hen.length && hfb() >= hen[her]) {
               hfh(var0, a.c(-2130813552, "巭⑃꺝ロ묰㷃蟐ษ遽\u1ad7鵜") + her);
               her++;
            } else if (her == hen.length && hff(var0, a.d("䟞㹧뒿⫕", 2038568660, 1654280547), 9.0F, 4)) {
               hfc();
               hep = 10;
            }
            break;
         case 2:
            if (var0.field_1755 instanceof CreateWorldScreen var7) {
               Method var10 = CreateWorldScreen.class.getDeclaredMethod(a.c(-1629906922, "顾\ue1de欚\uf56f纭\uf80d䉷쮯嗣\udf41墛"));
               var10.setAccessible(true);
               var10.invoke(var7);
               hes = 0;
               hep = 3;
            }
            break;
         case 3:
            if (var0.field_1687 != null && var0.field_1724 != null && var0.field_1755 == null && hes > 500) {
               hev = isv.selected();
               isv.select(a.d("∏宩텦伒쓝䉱\uf825熀\uef86攵\ue2f3ᢅ", 2106112520, 501848169));
               var0.method_1507(new hlc());
               hfc();
               hep = 30;
            }
            break;
         case 4:
            if (her < heo.length && hfb() >= heo[her]) {
               hfh(var0, a.b("鲖\ue538濦\uf196穋ﲸ䚡콂儁\udbf4", 1382325482) + her);
               her++;
            } else if (her == heo.length && hff(var0, a.b("暌Ἧ闠\u0bd8聙۷벩㕙ꬌ", 731997922), 4.0F, 6)) {
               isv.select(a.d("\uf8d4腲\u0bbd闉Ḇ颪⋾꭛㕝뿮㠨쉞", 660552764, -567229306));
               hfc();
               hep = 5;
            }
            break;
         case 5:
            if (her == 0 && hfb() > 1.5F) {
               hfh(var0, a.b("板ố鐏\u0a7f膢ݑ뵈㒫ꫨ”ꞓ巺팪䪀새", 482240262));
               her++;
            } else if (her == 1 && hff(var0, a.d("촰뒓㹜ꁤ⯣굊\u171e黴°", -1919973888, -258061474), 2.0F, 4)) {
               isv.select(hev);
               var0.method_1507(null);
               System.out.println(a.c(467844086, "뮏숡䣿횏嵒\udbac憫\ue84b瘂ﲴ笳脲\u0ff4陗ᰄ"));
               hep = 99;
               var0.method_1592();
            }
         case 6:
         case 7:
         case 8:
         case 9:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         default:
            break;
         case 10:
            String[] var1 = new String[]{
               a.b("⪋匥\ud9fb䞋챖䪲\uf0b8祂\ue710涶\uea65ဟ", -236573967),
               a.c(-1071065842, "합곇☙롩㎴땐མ蚽ᣣ鉓ᖘ\uefea慾\uf881狐\uf434乼"),
               a.d("ꂫ\ud905叛춫䙶삒窘\uf36b洦\ue790恛騣", 318335887, 2082786142),
               a.c(-708112594, "དྷ盼ﰢ扒\ue98f潫핱岝싃䡪")
            };
            int var2 = her / 2;
            if (var2 >= var1.length) {
               float var3 = kbp.scale(het.field_22789, het.field_22790);
               int[] var4 = new int[1];
               int[] var5 = new int[1];
               GLFW.glfwGetWindowSize(var0.method_22683().method_4490(), var4, var5);
               float var6 = (het.field_22790 * 0.5F + -13.1F * var3) / het.field_22790;
               GLFW.glfwSetCursorPos(var0.method_22683().method_4490(), 0.5F * var4[0], var6 * var5[0]);
               hfc();
               hep = 11;
            } else if (her % 2 == 0) {
               hfg(kbs.byKey(var1[var2]));
               her++;
            } else if (hfb() > 3.0F * (var2 + 1)) {
               hfh(var0, a.c(-1639392780, "\ud989ꀧ⫹뒉㽔릧δ詍ᐙ麳ᤸ") + var1[var2].substring(6));
               her++;
            }
            break;
         case 11:
            if (hfb() > 1.0F) {
               hfh(var0, a.d("䢶ㄘ믆▶깫⢘銋᭲蔦ྌ蠇爳ﳣ敋\uef0b槭", -1005863368, -2004683032));
               hfg(heu);
               CreateWorldScreen.method_64248(var0, () -> var0.method_1507(new TitleScreen()));
               hep = 2;
            }
            break;
         case 30:
            if (hff(var0, a.d("ἳ暐\uec5f牧易罉씝䳷튳塍\udfdc▪ꭾ㋆뢈㹮", 658034700, 845598536), 2.0F, 5)) {
               isv.select(a.b("ﺓ蜽\u0de3鎓ᡎ麪⒰굂㌌릮㹤쐒䫌", -986841368));
               hfc();
               hep = 4;
            }
      }
   }

   private static boolean hff(MinecraftClient var0, String var1, float var2, int var3) {
      int var4 = (int)Math.floor(hfb() - var2);
      if (var4 >= 0 && var4 != hew) {
         hew = var4;
         if (var4 > 0) {
            OperatingSystemMXBean var5 = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
            long var6 = var5.getProcessCpuTime();
            long var8 = System.nanoTime();
            if (hex > 0L) {
               System.out
                  .println(
                     a.b("偪⧄ꌚ㵪뚷ぉ詎ή鷧ᝑ郖櫶\ue425綈\uf7d7焷쬬", 1573343245)
                        + var1
                        + a.b("ꥁ킣婦쐑俊쥺猣殺", -90592919)
                        + var4
                        + a.c(1230948482, "좺넑")
                        + var0.method_47599()
                        + a.d("\uf342誵p鸂ᖊ錷⤴ꃇ㺅됸㏭즊䝝\udebf咯퉍标\ue783", -366423398, -1554308630)
                        + Math.round((var6 - hex) * 1000.0 / (var8 - hey)) / 10.0
                        + a.c(16680704, "蜨ﺜ琀\uea78懩\ue717嵅풿䪥쁗䞈뷤㌤")
                  );
            }

            hex = var6;
            hey = var8;
         }

         if (var4 >= var3) {
            hew = -1;
            hex = 0L;
            her++;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void hfg(kbs var0) throws Exception {
      Method var1 = jte.class.getDeclaredMethod(a.b("٢翊\uf513歪", 1714947606), kbs.class);
      var1.setAccessible(true);
      var1.invoke(het, var0);
   }

   private static void hfh(MinecraftClient var0, String var1) {
      System.out
         .println(
            a.b("譩\uf2c7砙\ue669涴\ueb4a免\ud8ad䛤챒䯕", -1710781676)
               + var1
               + a.c(-1406982674, "◍尜횯")
               + var0.method_47599()
               + a.d("ᮕ扢\ue8a7盕", 808316819, 1487860770)
         );
      ScreenshotRecorder.method_22690(var0.field_1697, a.c(1879829018, "\uea7a鏁ᤑ蝸೪詄") + var1 + a.b("\ue2fc鬓ᇞ辦", 140960470), var0.method_1522(), 1, var0x -> {});
   }
}
