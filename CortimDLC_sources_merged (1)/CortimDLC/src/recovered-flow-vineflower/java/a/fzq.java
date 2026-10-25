package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;

public final class fzq {
   static int fzr;
   static int fzs;
   static long fzt;
   static int fzu;
   static jte fzv;

   fzq() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.d("ẟ朤\uedf4玝\uf80f红쒬䵋팝妦\ude67␇\uaac6㍰", -1135408864, 1924077527))
         && a.c(-426590231, "뾁옳䳬튕").equals(System.getenv(a.d("\ue78b鸰ᓠ誉Ļ蟧㶸둟⨉ꂲ❳\udd13叒쩤䀼웁粞\uf349槱\uefab", -76430052, 658580165)))) {
         ClientTickEvents.END_CLIENT_TICK.register(fzq::gaa);
      }
   }

   public static void skip() {
      try {
         Field var0 = jte.class.getDeclaredField(a.b("\uf169裃Ȓ鱠ុ鄂⭟ꊯ㳛뙋㆕쯢", -1378160368));
         var0.setAccessible(true);
         var0.set(null, true);
      } catch (Exception var1) {
         System.out.println(a.c(1508476242, "蔭ﲞ療\ue87a揾\ue51b弛훲䢯숇䖄뾡ㅪ꣖⋀ꑽḱ釬ୗ赍ө纨\uf00a毌\uedb3杩\ude8e僅") + var1);
      }
   }

   static float fzy() {
      return (float)(System.nanoTime() - fzt) / 1.0E9F;
   }

   static void fzz() {
      fzt = System.nanoTime();
      fzu = 0;
   }

   static void gaa(MinecraftClient var0) {
      fzs++;

      try {
         gab(var0);
      } catch (Throwable var2) {
         System.out.println(a.c(1116441229, "諱\uf343禜\ue7e5汹\uea9c僞\ud939䝡춄䨱끇㺘Ꜭⴉꯢ") + var2);
         var2.printStackTrace();
         fzr = 99;
         var0.scheduleStop();
      }
   }

   static void gab(MinecraftClient var0) throws Exception {
      switch (fzr) {
         case 0:
            if (var0.getOverlay() == null && var0.currentScreen instanceof AccessibilityOnboardingScreen) {
               var0.options.onboardAccessibility = false;
               var0.setScreen(new TitleScreen());
            }

            if (var0.getOverlay() == null && var0.currentScreen instanceof jte var7 && fzs > 20) {
               fzv = var7;
               if (!gac()) {
                  throw new IllegalStateException(a.c(-1504920801, "뭳싞䠀혴嶮\udb17慏\ue8a5皯ﱑ箝臹༥隟\u1ccd驸\u2062꾨㔙덋㪰䃩칔善"));
               }

               fzz();
               fzr = 1;
            }
            break;
         case 1:
            float[] var6 = new float[]{0.15F, 0.5F, 1.2F, 2.6F};
            if (fzu < var6.length && fzy() >= var6[fzu]) {
               gag(var0, a.c(1387646873, "쿳뙁㲞ꋧ⥶꿚") + fzu + a.d("妝\u2068ꪼ", 520292062, -284008595));
               fzu++;
            } else if (fzu == var6.length) {
               gad(fzv.width * 0.5F, fzv.height - 10.0F);
               fzz();
               fzr = 2;
            }
            break;
         case 2:
            float var5 = fzv.height - 10.0F - Math.min(1.0F, fzy() / 0.4F) * fzv.height * 0.12F;
            gae(fzv.width * 0.5F, var5);
            if (fzy() > 0.45F && fzu == 0) {
               gag(var0, a.b("愶ᢄ鉛ఢ螳Ğ뭌㊠겡☔ꇙ宱핳䲊욇䁨飼痷\uef44", -882155191));
               gaf(fzv.width * 0.5F, var5);
               fzu++;
            } else if (fzu == 1 && fzy() > 1.1F) {
               gag(var0, a.c(-1807498508, "슋묹\u31e6꾟␎ꊣᣰ鄝༜薮ɿ\uf81d盅\uef7d敤\ue3da妖홅䳾"));
               if (!gac()) {
                  throw new IllegalStateException(a.c(-245255457, "늨쭘䇘\udfb2呢틎梛\ue13e缲\uf587牊蠢۠鼔ᔒ鏸⦵ꙧ㳘몁㍸䤨"));
               }

               fzv.keyPressed(new KeyInput(32, 0, 0));
               fzz();
               fzr = 3;
            }
            break;
         case 3:
            float[] var4 = new float[]{0.08F, 0.2F, 0.35F, 0.55F, 0.9F, 1.6F};
            if (fzu < var4.length && fzy() >= var4[fzu]) {
               gag(var0, a.d("豎\uf5fc缣\ue15a櫋\uec65", 983082928, -1054790764) + fzu + a.d("툽ꯔℜ뽯㒻눆\u085d", 1265093157, -2086660046));
               fzu++;
            } else if (fzu == var4.length && fzy() > 2.2F) {
               if (gac()) {
                  throw new IllegalStateException(a.d("糮՜辞ᇭ騼\u1cc8ꛟ⼣녱㯊뱐䙲죱儕\udb5d嶮\ue7e2栿\uf284", -1652866152, 1907506966));
               }

               Method var2 = jte.class.getDeclaredMethod(a.d("⹑埣\udd3c䍅좷丧\uf46c", -1368248741, -1016004511));
               var2.setAccessible(true);
               var2.invoke(fzv);
               fzz();
               fzr = 4;
            }
            break;
         case 4:
            float[] var3 = new float[]{0.2F, 0.6F, 1.6F};
            if (fzu < var3.length && fzy() >= var3[fzu]) {
               gag(var0, a.c(387972665, "\ufe53蟡ാ鍇ᣖ鹹") + fzu + a.c(-815334284, "ﱞ薰ུ鄌\u1ad8鱥☾"));
               fzu++;
            } else if (fzu == var3.length) {
               if (!gac()) {
                  throw new IllegalStateException(a.b("㸴䞆쵙匠\ud8d2幂\ue409涯\uf3b4礈ﻖҭ訳Ꮡ駖Ὣꔧ⫺끁", 1509768779));
               }

               gad(fzv.width * 0.5F, fzv.height * 0.7F);
               fzz();
               fzr = 5;
            }
            break;
         case 5:
            float var1 = fzv.height * 0.7F - Math.min(1.0F, fzy() / 0.3F) * fzv.height * 0.4F;
            gae(fzv.width * 0.5F, var1);
            if (fzu == 0 && fzy() > 0.18F) {
               gag(var0, a.b("\ue25b鯩ᄶ轏Ӟ艶㠡뇍⿌ꕹ⊴\ud8dc嘞쿧䗴쌁祃", 1487987238));
               fzu++;
            } else if (fzu == 1 && fzy() > 0.32F) {
               gaf(fzv.width * 0.5F, var1);
               fzu++;
               fzz();
               fzu = 2;
               fzr = 6;
            }
            break;
         case 6:
            if (fzu == 2 && fzy() > 0.25F) {
               gag(var0, a.d("퓯굝➂맻㉪듂ດ蝹\u1978鏍᐀\uee68悪肋獘\uf5b2俿쀭媒\udccb唾⽨ꇒ", 765567490, 373257878));
               fzu++;
            } else if (fzu == 3 && fzy() > 1.8F) {
               gag(var0, a.d("逮\ue99c捃ﴺ皫\uf003䩖쎸嶧휞僆ꪬ", 1532196534, -33167624));
               if (gac()) {
                  throw new IllegalStateException(a.b("၌榼\ue323絑\uf687瀿쨫䎉\uddd2坽킷⫓ꑁ㶴럪ㄖ譓Ӌ鸫ᠮ醌\uebc6敷ﺥ磖\uf20f", -132378569));
               }

               System.out.println(a.d("ﰟ薭ི鄋᪗鱲☰꿗\u318f뭪㳉용䡬퇝", -985682515, -482651696));
               fzr = 99;
               var0.scheduleStop();
            }
      }
   }

   static boolean gac() throws Exception {
      Field var0 = jte.class.getDeclaredField(a.b("꼧횕届숳䧪콚", 1289203533));
      var0.setAccessible(true);
      return var0.getBoolean(fzv);
   }

   static void gad(float var0, float var1) {
      fzv.mouseClicked(new Click(var0, var1, new MouseInput(0, 0)), false);
   }

   static void gae(float var0, float var1) {
      fzv.mouseDragged(new Click(var0, var1, new MouseInput(0, 0)), 0.0, 0.0);
   }

   static void gaf(float var0, float var1) {
      fzv.mouseReleased(new Click(var0, var1, new MouseInput(0, 0)));
   }

   static void gag(MinecraftClient var0, String var1) {
      System.out.println(a.b("ᄏ梽\ue262簛\uf787煢쬠䋇\udc9f噺", 1941639529) + var1 + a.b("긅ퟔ嵧", 1010937382) + var0.getCurrentFps() + a.c(1821759149, "횉꽾▻믉"));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory, a.d("넀좻䉫\udc02垐턾", -800622465, -670775009) + var1 + a.c(-2005816376, "ꯢ툍壀울"), var0.getFramebuffer(), 1, var0x -> {}
      );
   }
}
