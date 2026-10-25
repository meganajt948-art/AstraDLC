package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public final class ifv {
   static final float ifw = 15.0F;
   static final vcj ifx = new vcj(10.0F);
   static String ify = "";
   static int ifz;

   ifv() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var2.player != null && !var2.options.hudHidden) {
         unf.observe(var0);
         float var3 = unf.delta();
         String var4 = null;
         byte var5 = 0;
         tcw var6 = tcz.mode();
         int var7 = lfa.stopKey();
         String var8 = var7 == -1
            ? wap.s(a.b("ࢨ焞ﯖ斸\uee3f棇튓嬬씧侊졔㉠볤╒꼀⧠鎢ᱵ", 1035405513), a.c(878915876, "㕨䳚왵堅ퟍ啮\ueb2f暿\uf8e3牓\uf5f7ྊ腝"))
            : irr.keyName(var7) + wap.s(a.d("粎┋迬ᇎ騞Ჴ\ua6f8", 1277992433, 1263460696), a.c(807399652, "\uf0c3ꥆΡ馱ብ钨\u2efa"));
         if (var6 == tcw.RECORD && tcz.walkRecorder() != null) {
            tyd var16 = tcz.walkRecorder();
            String var19 = wap.s(a.c(63877830, "늽쬚䇄\udfb2呧틑梋\ue13d罢\uf544爀衱"), a.d("撚ᵐ鞉ঀ航Қ뫙㌨균⟆ꀕ", -933998308, -1116917304))
               + Math.round(var16.meters)
               + wap.s(a.d("䗭㰑", 585274708, -1955671909), a.b("䤁㒬", -1280358109))
               + a.c(-769527480, "\uf16d補ʘ鱾ឩ")
               + wap.s(a.d("霮\uee82摋層燽\uf75a䵚", -1106961150, 1803389529), a.c(-1397820213, "\uf0fd襀ϣ鶚ᙅ郷⪥ꌨ㵻돘"))
               + var16.routes
               + a.b("扵ᯄ醀ས蒱", -2128190896)
               + igd(var16.seconds());
            var4 = var16.paused
               ? wap.s(a.b("突菳द霴Ჳ験⁔ꦣ㟪뵚㫗삼", 793901579), a.c(1567620151, "ﱮ藈༝鄏ệ项≙ꯜ㖄묿㳶")) + reasonText(var16.pauseReason)
               : a.b("䨦㎀륕❇겐", -1857140111) + var19 + a.c(1713187789, "⯨剙\ud81d䛻촬") + var8;
            var5 = (byte)(var16.paused ? 1 : 2);
         } else if (var6 == tcw.RECORD && tcz.mineRecorder() != null) {
            ttl var15 = tcz.mineRecorder();
            String var18 = wap.s(a.b("쭆닳㠧ꙝ\u2dcfꭾᆺ飜ڃ豱\u0bad\uf1d9缄\ue6bd泶\uea54", 2016856891), a.b("쩩뎠㤆ꝰⳕ깴ᐧ鵁Ή褸૱\uf081繕\ue7e6涷\uef5e", -546451919))
               + var15.blocks
               + a.c(-1499994896, "\ue4d5鵤ᜠ视ȑ")
               + wap.s(a.c(-732853537, "誾\uf308秈\ue7a6汹\ueac9僞"), a.c(-1359502122, "ꃢ\ud95e叹췼䙛삖竁\uf333楷"))
               + var15.farmed
               + a.d("ᑠ淑\ue795祳\uf2a4", -1892548186, 292951523)
               + igd(var15.seconds());
            var4 = var15.paused
               ? wap.s(a.c(81517239, "\udae9ꍏ⦚랈㰏몯è褟\u1756鷦ᩫ\ue000"), a.d("㔸䲞왋塙힑儯\ueb0f把ﳒ物\uf5a0", 68495484, 1096883485)) + reasonText(var15.pauseReason)
               : a.b("\ud98aꀬ⫹듫㼼", 1946737117) + var18 + a.c(649424678, "漃ᚲ鳶Ȑ觇") + var8;
            var5 = (byte)(var15.paused ? 1 : 2);
         } else if (var6 == tcw.RECORD && tcz.recorder() != null) {
            tkc var14 = tcz.recorder();
            String var10 = wap.s(a.d("ᠹ憉\ueb47由ﺵ", 1825186910, 1269447690), a.b("權ዌ頛ؚ跆༜", -1735954609))
               + var14.hits
               + a.b("ᖃ氲\ue676碐\uf347", 321131942)
               + wap.s(a.c(-2130787664, "싋뭨ㆷ꿛␐ꊨᣭ酏"), a.b("릈쁍䪗퓥弶\ud9f7柏", -1454195250))
               + var14.samples
               + a.c(-2085325857, "珺ੋ耏ứ锾")
               + wap.s(a.d("䧿ぁ몗⓾꼸⦞鏚ᨪ萱", -42492791, -1800743655), a.d("ᨬ握\ue931眴ﲙ穚쀊䷥", 249803352, 262253634))
               + var14.failures
               + a.b("ꍀ\udaf1債칓䖄", -172645531)
               + igd(var14.seconds());
            var4 = var14.paused
               ? wap.s(a.c(-200470623, "\u0fff癙ﲌ択\ue919澹헾尉쉀䣰콽㔖"), a.d("嚹⼟ꗊ㯘됐㊮袎ċ齓ᇨ阡", 573540466, 117825170)) + reasonText(var14.pauseReason)
               : a.d("䘣㾅땐⭂ꂕ", -372659877, 125628207) + var10 + a.c(1742511268, "鲁\ue530潴\uf192穅") + var8;
            var5 = (byte)(var14.paused ? 1 : 2);
         } else if (var6 == tcw.TEST) {
            var4 = wap.s(a.d("猳\u0a80聘Ḩ闶ጫꤌ⃬뺥㐓", -1928614708, 234020792), a.d("宐∖꣱㚃륖㯛膊ࡱ阯Ა魀", 459144305, -415652920)) + a.b("䥀ヱ몵\u2453꾄", 1683376485) + var8;
            var5 = 3;
         } else if (tcz.fightRecorder() != null && !tcz.fightRecorder().paused) {
            var4 = wap.s(a.b("懡ᡇ銒ಀ蜑Ư믲㈌걏⛹ꅹ嬈핈䱮옽䂄響甆\uefb2榰", 990339495), a.d("慕ᣳ鈦ఴ菲Ռ뼙㋰겯⚉ꇍ宼턈䣎슙䐘﹜痦", -1797200319, 40732500)) + tcz.fightRecorder().hits;
            var5 = 2;
         } else if (tcz.training() && var2.currentScreen == null) {
            tct var9 = tcz.job();
            var4 = wap.s(a.c(1071492648, "깵ퟢ崢썛䢋츽瑩\ufd91掉"), a.c(1429970535, "驰\ue3ee楏\uf73a粟都䁰즌叆"))
               + (var9.progress.epoch + 1)
               + a.b("㪱䌏짓", 2036808338)
               + var9.progress.epochs;
            var5 = 3;
         }

         if (var4 != null) {
            ify = var4;
            ifz = var5;
         }

         float var17 = vcq.outCubic(ifx.step(var4 != null, var3));
         if (!(var17 < 0.01F)) {
            iov.beginHud();
            uut.beginFrame();

            try {
               igc(var0, ify, ifz, var17);
            } finally {
               iov.endHud();
            }
         }
      }
   }

   static void igc(DrawContext var0, String var1, int var2, float var3) {
      float var4 = var0.getScaledWindowWidth();
      float var5 = var2 == 0 ? 0.0F : 9.0F;
      float var6 = 10.0F + var5 + irr.VALUE.width(var1) + 10.0F;
      float var7 = (var4 - var6) * 0.5F;
      float var8 = 30.0F - (1.0F - var3) * 8.0F;
      float var9 = iov.r(6.0F);
      uut.pushAlpha(var3);

      try {
         uut.shadow(var0, var7, var8 + 1.5F, var6, 15.0F, var9, 8.0F, ujt.withAlpha(0, 70));
         uut.round(var0, var7, var8, var6, 15.0F, var9, iov.hudFill(0.82F));
         uut.outline(var0, var7, var8, var6, 15.0F, var9, 1.0F, iov.hudEdge());
         float var10 = var7 + 10.0F;
         float var11 = var8 + 7.5F;
         if (var2 != 0) {
            int var12 = switch (var2) {
               case 1 -> -678620;
               case 2 -> -1750963;
               default -> iov.accent();
            };
            float var13 = var2 == 2 ? 0.55F + 0.45F * (float)Math.abs(Math.sin(System.currentTimeMillis() / 380.0)) : 1.0F;
            uut.circle(var0, var10 + 2.5F, var11, 4.2F, ujt.withAlpha(var12, Math.round(60.0F * var13)));
            uut.circle(var0, var10 + 2.5F, var11, 2.6F, ujt.withAlpha(var12, Math.round(255.0F * var13)));
            var10 += var5;
         }

         irr.VALUE.draw(var0, var1, var10, irr.VALUE.centerTop(var11), iov.text);
      } finally {
         uut.popAlpha();
      }
   }

   static String igd(int var0) {
      return var0 / 60 + a.d("撌", -1382609034, -1644074047) + String.format(a.b("ᑈ淬\ue73d礚", 1418990697), var0 % 60);
   }

   static String reasonText(String var0) {
      if (var0.equals(a.c(-604371034, "ߓ繲\uf4b0櫖\ue101枻"))) {
         return wap.s(a.b("바얭併턟媝\udc63是\uefcb熟", 445824112), a.c(1176743232, "ꥲ킿娔쐟促쥻獔ﺻ擸\uee40榛鎙"));
      }
      else if (var0.equals(a.b("鞡\uee19擆瑱煰", 1246599106))) {
         return wap.s(a.b("씽벒㙆\ua83d⏡ꕈὌ雳ࢭ與րﾷ煩\ue8d4抑\ue466帿퇯", 141280600), a.c(-343942381, "\udf22ꚗⱃ눱㷸뽔ԏ裫ኤ頟ᾴ\ue5bf止\uf2dc碌"));
      }
      else if (var0.equals(a.b("ꨁ펱奦윒", -1991005599))) {
         return wap.s(a.d("哮ⵉꞀ㦤눲㒐軔ݠ饻Ꮛ鐜湨", 375079990, 1334513837), a.b("咨ⴐꎨ㧅뉿㓟躎\u070f", 1442336994));
      }
      else if (var0.equals(a.b("좳넊㯝ꖠ\u2e65꣔ኝ魶Ԯ", 2079508699))) {
         return wap.s(;
      }
      else if (var0.equals(a.c(-847501589, "⚂弿헮䮙"))) {
         return a.c(-145910834, "鎇\uea02惐ﺺ畏\uf3d2䦃쁴");
      }
      else if (var0.equals(a.c(-818004744, "㲑䔴쿦册\uda59峬\ue6b8潂"))) {
         return wap.s(a.c(-939712651, "ἐ暠\uec74爙呂罐씷䳇튃堐\udfe7░ꭍ㊹뢥㹝萒"), a.b("ꄣ\ud8eb剉찹䞛섣笏\uf6e6棘\ue25d斏鿥ᄐ袅ˑ萫", 400270593));
      }
      else if (var0.equals(a.b("\ue640鿶ᔶ識\u0087蘡", -9902560))) {
         return a.c(2075664409, "⁕始팕䵮욵䀏渚玅\uedfd束\ue093\u1aea鐪");
      }
      else if (var0.equals(a.b("ሆ殣\ue167编\uf4c7牴젫", 1306923623))) {
         return a.b("볍안侌퇽娌\udc9f曀", 263109772);
      }
      else if (var0.equals(a.d("\ud7c8깠Ⓓ뫀ㄝ략\u0dfb", -531001151, -604682370))) {
         return wap.s(;
      }
      else if (var0.equals(a.b("鏼\uea4e悝ﻷ", 1272877972))) {
         return wap.s(;
      }
      else if (var0.equals(a.d("◘屴횽䣍쌋", 1484751058, 1111991677))) {
         return wap.s(;
      }
      else if (var0.equals(a.b("\ue552鳡ᘹ衙Η蔯", 1453974841))) {
         return wap.s(;
      }
      else {
         return var0;
      }
   }
}
