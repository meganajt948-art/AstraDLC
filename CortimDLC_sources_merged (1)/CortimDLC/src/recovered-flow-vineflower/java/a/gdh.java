package a;

import flow.dev.a;
import flow.splash.FlowSplash;
import flow.splash.Splash;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;
import org.lwjgl.glfw.GLFW;

public final class gdh {
   private static final float[] gdi = new float[]{0.5F, 1.5F, 2.9F, 3.5F, 3.8F, 4.2F, 4.8F, 5.5F, 6.5F, 7.5F, 8.5F, 9.5F};
   private static int gdj;
   private static long gdk;
   private static int gdl;
   private static int gdm;
   private static jte gdn;

   private gdh() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.c(-1121156076, "葼ﷇ眗\ue97e括\ue441幏\ud7a8䧾썅䒄뻤〥ꦓ"))
         && a.c(1845459780, "笭ʔ行ᘦ").equals(System.getenv(a.d("쵫듐㸀ꁩ⯛괇\u1758麿é詒ඓ\uf7f3礲\ue084櫜\uec21噾\ud9a9䌑앋", 1660301628, -1630471163)))) {
         ClientTickEvents.END_CLIENT_TICK.register(gdh::gds);
      }
   }

   private static float gdq() {
      return (float)(System.nanoTime() - gdk) / 1.0E9F;
   }

   private static void gdr() {
      gdk = System.nanoTime();
      gdl = 0;
   }

   private static void gds(MinecraftClient var0) {
      gdm++;

      try {
         gdt(var0);
      } catch (Throwable var2) {
         System.out.println(a.d("酷\ue8ce或ﱼ矾\uf11b䭙슾峦혃冶ꯀ┟벫㚎끥", 178343621, 410378191) + var2);
         var2.printStackTrace();
         gdj = 99;
         var0.method_1592();
      }
   }

   private static void gdt(MinecraftClient var0) throws Exception {
      switch (gdj) {
         case 0:
            if (gdm % 100 == 0) {
               System.out
                  .println(
                     a.b("랱츈䓐\udaba儸ퟝ涟\ue478稠\uf0c5睁账Ϲ驕ရ雭ⲫꌧ㦎뾐㙾䰼슘套\udf25嗬\uec06", -890914873)
                        + var0.method_18506()
                        + a.d("錫\uea96怖ﹷ疱\uf317䥄삾庯", 1206376091, -1067039339)
                        + var0.field_1755
                  );
            }

            if (var0.method_18506() == null && var0.field_1755 instanceof AccessibilityOnboardingScreen) {
               var0.field_1690.field_41785 = false;
               var0.method_1507(new TitleScreen());
            }

            if (var0.method_18506() == null && var0.field_1755 instanceof jte && gdm > 60) {
               Splash.preview(var0, 3.0F, true);
               gdr();
               gdj = 1;
            }
            break;
         case 1:
            if (gdl < gdi.length && gdq() >= gdi[gdl]) {
               gdy(var0, a.b("ั瞈ﵐ挺\ue8b5渙푋嶦쎽䤋컂㒵멿⎌", 1286147666) + gdl);
               gdl++;
            }

            if (var0.method_18506() == null && var0.field_1755 instanceof kct) {
               System.out.println(a.d("맺쁃䪛퓱彳\ud996揔\uea33瑫ﺎ礔荢ද鐘Ṗ飨⋨괠㞀뇆㡣䉳쳇圄텪宬\ue24d", 624610583, -1093897061) + gdq() + a.c(355875940, "㱆䖤"));
               gdr();
               gdj = 2;
            } else if (gdq() > 15.0F) {
               throw new IllegalStateException(a.c(844215414, "됏춹䝰\ud907勍퐳渳\ue7c5禇\uf333瓠軝_駫Ᏺ错") + var0.method_18506() + a.c(-833465596, "匥") + var0.field_1755);
            }
            break;
         case 2:
            float var11 = gdq();
            if (gdl == 0 && var11 > 0.25F) {
               gdy(var0, a.d("\u1ad8捡\ue9b9矓ﱜ竰삡䥏흊巩\uda33⁍꺖㜥뵾㯇臌บ", -676252775, 1154623806));
               gdl++;
            } else if (gdl == 1 && var11 > 1.2F) {
               gdv(var0, 0.37F, 0.5F);
               gdl++;
            } else if (gdl == 2 && var11 > 1.7F) {
               gdy(var0, a.b("┝岤홼䠖쎙䔵･皊\ue88f戬\ue5f6ᾈ酓࣠芻Ђ븈㇞ꭴⴶꓖ", 437527909));
               gdl++;
            } else if (gdl == 3 && var11 > 1.8F) {
               gdw(var0.field_1755, a.d("恍᧥錼\u0d45", 26472708, -1684696771), new Class[]{int.class}, 0);
               gdl++;
            } else if (gdl == 4 && var11 > 2.0F) {
               gdy(var0, a.b("ꢿ턆寞어主좗狀ﬨ攭\uef8e桔鈪ᳱ蕂༙覠㎲뱺⛃ꂚ⥣匳", 1752082628));
               gdl++;
            } else if (gdl == 5 && var0.field_1755 instanceof jte var15) {
               gdn = var15;
               gdv(var0, 0.1F, 0.9F);
               gdr();
               gdj = 3;
            } else if (var11 > 8.0F) {
               throw new IllegalStateException(a.c(-905309119, "ᐷ涇\ue71b礧\uf2f8瑂츊䞮\ud9b0匆퓇⺧ꁧ㦄뎃㕮輬¸驛ᰓ问\uefb7慕爵") + var0.field_1755);
            }
            break;
         case 3:
            float var10 = gdq();
            float[] var14 = new float[]{0.3F, 0.7F, 1.2F, 2.0F, 3.5F};
            if (gdl < var14.length && var10 >= var14[gdl]) {
               gdy(var0, a.d("鱕\ue5ec漴\uf15e竑ﱽ䘫쿂凟\udb71岷ꛍ⡙", -248593381, -2102372306) + gdl);
               gdl++;
            } else if (gdl == var14.length && var10 > 3.7F) {
               float var19 = kbp.scale(gdn.field_22789, gdn.field_22790);
               gdv(var0, 0.5F, (gdn.field_22790 * 0.5F + -13.1F * var19) / gdn.field_22790);
               gdl++;
            } else if (gdl == var14.length + 1 && var10 > 4.3F) {
               gdy(var0, a.d("塈⇱ꬩ㕃뻌㡠舵\u0bdf闅έ颹招\uec1b痵\ufff8礓썛䲃혻偣", -1119998022, 1213429643));
               float var18 = kbp.scale(gdn.field_22789, gdn.field_22790);
               gdv(var0, 1.0F - 49.5F * var18 / gdn.field_22789, 22.5F * var18 / gdn.field_22790);
               gdl++;
            } else if (gdl == var14.length + 2 && var10 > 4.9F) {
               gdy(var0, a.c(-2122506847, "ᷜ摥\ueebd烗ﭘ練잠之큑嫧\udd2d❏ꦏち멽㲉"));
               gdx(gdn, a.b("\ue5ce鱦ᚿ裆̟薹㿗똙⡓ꋩ", 367715764), true);
               gdl++;
            } else if (gdl == var14.length + 3 && var10 > 5.6F) {
               gdy(var0, a.d("ꗚ\udc63嚻죑䍞엲義\uf64d桏\ue2e7放齇ᆞ蠸", 1738429643, -1303187086));
               gdx(gdn, a.b("̏窮\uf06c渀\ue5d4捥\ud90e僊캆䐢쏳㦓", -979565712), 240.0F);
               gdl++;
            } else if (gdl == var14.length + 4 && var10 > 6.6F) {
               gdy(var0, a.d("嬉⊰ꡨ㘂붍㬡腺࣑雁ᰭ鯧憜\uef43盼ﲸ稖쀃俄핺匫\udac3", 1068470775, -1942500730));
               gdx(gdn, a.d("쐻붚㝘ꤴ⋠ꑑḺ韾ল茖Ӈﺧ", 1686881132, 1472726824), 0.0F);
               gdr();
               gdj = 4;
            }
            break;
         case 4:
            kbs[] var9 = new kbs[]{
               kbs.byKey(a.d("续݃趝Ꮽ頰Ổ\ua4ceⴼ덲㧐븚䑬쪲", -2041698921, -1897571583)),
               kbs.byKey(a.b("詑\uf3ff礡\ue751沌\uea68偢\ud991䟜쵪䪡냙", 1471908395)),
               kbs.byKey(a.d("\uee49韧ᴹ草\u0894蹰㑺부⏒ꥴ⺧퓝", -518672792, -692961189)),
               kbs.byKey(a.b("㚉伧엹安큔嚰\uecbf敉ﬅ熫", 1666529013))
            };
            int var13 = gdl / 2;
            if (var13 >= var9.length) {
               gdx(gdn, a.d("ꗻ\udc53嚊죳䌪얌翢\uf62c桦\ue2dc", 1877898806, 1494012855), false);
               var0.method_1507(new OptionsScreen(gdn, var0.field_1690));
               gdr();
               gdj = 5;
               return;
            }

            if (gdl % 2 == 0 && gdq() > 0.2F) {
               gdw(gdn, a.b("찀떨㽱ꄈ", -476918668), new Class[]{kbs.class}, var9[(var13 + 1) % var9.length]);
               gdl++;
            } else if (gdl % 2 == 1 && gdq() > 1.6F) {
               gdx(gdn, a.d("鵱\ue4d9渀\uf079箠ﴆ䝨캦僬\uda56", -660637318, 243852401), false);
               gdy(var0, a.b("㏰䩉삑廻해变\ue982恧﹦瓁\uf316ॵ螾Ḏ鐞", 1682715538) + var9[(var13 + 1) % var9.length].key.replace(':', '-'));
               gdl++;
               gdr();
               gdl = var13 * 2 + 2;
            }
            break;
         case 5:
            float var8 = gdq();
            if (gdl == 0 && var8 > 0.15F) {
               gdy(var0, a.b("歙ዠ頸ْ距୰넢㢂ꚑⱢꮮ凛\udf11䚦쳴䨘\uf009羜\ue528", -1768199385));
               gdl++;
            } else if (gdl == 1 && var8 > 0.9F) {
               gdv(var0, 0.32999998F, 0.4F);
               gdl++;
            } else if (gdl == 2 && var8 > 1.5F) {
               gdy(var0, a.c(-495551394, "簣֚轂ᄨ骧ᰊꙘ⿻뇫㬘볔䚡졫凜\udb8e嵢"));
               var0.method_1507(new MultiplayerScreen(gdn));
               gdl++;
            } else if (gdl == 3 && var8 > 2.6F) {
               gdy(var0, a.d("ݯ绖\uf40e橤\ue1eb杆\udd14咶쪧䁖잝㷵댺⪖ꃜ☱鱳Ꮊ褕ན", 1161807441, -1264664249));
               var0.method_1507(new VideoOptionsScreen(gdn, var0, var0.field_1690));
               gdl++;
            } else if (gdl == 4 && var8 > 3.6F) {
               gdy(var0, a.b("孱⋈ꠐ㙺뷵㭘脊ࢯ隹᱓鮟懣\uef35皎", 363748114));
               var0.method_1507(gdn);
               gdl++;
            } else if (gdl == 5 && var8 > 4.0F) {
               gdy(var0, a.d("粁Ը迠ᆊ騅Შ\ua6fa⼖넆㮴뱥䘜", 1363497314, -1842074238));
               gdl++;
            } else if (gdl == 6 && var8 > 5.2F) {
               float var12 = kbp.scale(gdn.field_22789, gdn.field_22790);
               float var17 = (gdn.field_22789 / var12 - 138.0F) * 0.5F + 40.0F;
               float var21 = gdn.field_22790 / var12 * 0.5F - 25.6F + 64.0F + 12.5F;
               gdn.method_25402(new Click(var17 * var12, var21 * var12, new MouseInput(0, 0)), false);
               gdr();
               gdj = 7;
            }
            break;
         case 6:
            float[] var7 = new float[]{0.15F, 0.6F, 1.4F, 2.2F};
            if (gdl < var7.length && gdq() >= var7[gdl]) {
               gdy(var0, a.d("ᨖ掯\ue977眝ﲒ稿쁬䦁힁崧\udafd\u208f깖㟢뷸", -2128300220, -310006480) + gdl);
               gdl++;
            }

            if (gdl >= var7.length && !(var0.method_18506() instanceof FlowSplash)) {
               System.out.println(a.b("叀⩹ꂡ㻋땉㎬觮\t鹑ᒴ錗楷\ue7b2縃\uf42f狒죏䜉\uddb3寡툘ꡌ⚻봭㭚놊࠲蘦Ა髆ᅧ\uefa7旿ﱜ", -882355313) + gdq() + a.d("渀២", -2130805363, -935259217));
               gdj = 99;
               var0.method_1592();
            } else if (gdq() > 12.0F) {
               throw new IllegalStateException(a.b("ﴉ蒯\u0e75逇ᯞ鵪❽껟ょ먫㷽잌䤗탳媥", -2069889676));
            }
            break;
         case 7:
            float var1 = gdq();
            if (gdl == 0 && var1 > 0.08F) {
               gdy(var0, a.c(-547970945, "ꀃ\ud9ba卢초䚇쀪空\uf394涇\ue73b惰高ᑒ跡ޥ腂㬍"));
               gdl++;
            } else if (gdl == 1 && var1 > 0.9F) {
               gdy(var0, a.b("ኀ欹\ue1e1羋\uf404犩죸䄗\udf04喸퉳", 997266150));
               gdl++;
            } else if (gdl == 2 && var1 > 1.1F) {
               if (var0.field_1755 instanceof jos var2) {
                  for (char var6 : a.d("爱ப腺ἓ铧ቧꠢ⇔뾚㔼", -1249154405, -781641498).toCharArray()) {
                     var2.method_25400(new CharInput(var6, 0));
                  }

                  var2.method_25404(new KeyInput(257, 0, 0));
               }

               gdl++;
            } else if (gdl == 3 && var1 > 1.8F) {
               gdy(var0, a.c(647262230, "灪\u09d3茋ᵡ雮၃ꨕ⏽뷮㝒낙䪱쐪嶞ퟍ儽\ueb73"));
               gdu(var0, 60.0F);
               gdl++;
            } else if (gdl == 4 && var1 > 3.0F) {
               gdy(var0, a.d("䌰㪉끑⸻ꖴ⌙饎Ⴇ躴Ј菃秫\uf77d滏\ue494扫\ud823", 2022001575, -2125199125));
               gdu(var0, 242.0F);
               gdl++;
            } else if (gdl == 5 && var1 > 3.3F) {
               gdy(var0, a.c(1038969267, "槍ၴ骬ӆ轉\u09e4뎰㩚ꑉ\u2ef5ꤾ化\udd8f䐲칠䢙\uf2d9紓\ue7bf"));
               gdu(var0, 242.0F);
               gdl++;
            } else if (gdl == 6 && var1 > 3.8F) {
               gdy(var0, a.b("䪊㌳맫➁갎⪣郶ᤝ蜎\u0db2詹灑ﻙ板\ued24毗톁幃쓱", -1632089356));
               var0.method_1507(gdn);
               gdx(gdn, a.b("盙ཀྵ薡ᯍ逐ᚧ곞┐뭚㇠", -153389379), false);
               gdl++;
            } else if (gdl == 7 && var1 > 5.0F) {
               Splash.preview(var0, 2.0F, false);
               gdr();
               gdj = 6;
            }
      }
   }

   private static void gdu(MinecraftClient var0, float var1) {
      if (var0.field_1755 instanceof jos var2) {
         float var6 = kbp.scale(var2.field_22789, var2.field_22790);
         float var4 = (var2.field_22789 / var6 - 268.0F) * 0.5F;
         float var5 = (var2.field_22790 / var6 - 218.0F) * 0.5F + 4.0F;
         var2.method_25402(new Click((var4 + var1) * var6, (var5 + 52.0F + 14.0F) * var6, new MouseInput(0, 0)), false);
      }
   }

   private static void gdv(MinecraftClient var0, float var1, float var2) {
      int[] var3 = new int[1];
      int[] var4 = new int[1];
      GLFW.glfwGetWindowSize(var0.method_22683().method_4490(), var3, var4);
      GLFW.glfwSetCursorPos(var0.method_22683().method_4490(), var1 * var3[0], var2 * var4[0]);
   }

   private static void gdw(Object var0, String var1, Class<?>[] var2, Object... var3) throws Exception {
      Method var4 = var0.getClass().getDeclaredMethod(var1, var2);
      var4.setAccessible(true);
      var4.invoke(var0, var3);
   }

   private static void gdx(Object var0, String var1, Object var2) throws Exception {
      Field var3 = var0.getClass().getDeclaredField(var1);
      var3.setAccessible(true);
      var3.set(var0, var2);
   }

   private static void gdy(MinecraftClient var0, String var1) {
      System.out
         .println(a.b("뗤챝䚅\ud8ef卭했濊\ue62d硵\uf290", 181253507) + var1 + a.d("坂⺓ꐠ", -281767153, -1212038034) + var0.method_47599() + a.b("킥ꥒ⎗뷥", 371642497));
      ScreenshotRecorder.method_22690(
         var0.field_1697, a.d("ﭰ苋ࠛ陲ᷠ魎", 1311239405, 1851987965) + var1 + a.c(660726025, "\ue123飌ሁ豹"), var0.method_1522(), 1, var0x -> {}
      );
   }
}
