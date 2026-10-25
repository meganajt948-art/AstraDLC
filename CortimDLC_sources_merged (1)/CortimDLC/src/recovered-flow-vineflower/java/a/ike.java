package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class ike extends imn {
   private static final vdn ikf = veo.bold(12.0F);
   private static final float ikg = 26.0F;
   private static final float ikh = 18.0F;
   private final vcj iki = new vcj(16.0F);
   private final vcj ikj = new vcj(16.0F);
   private final vcj ikk = new vcj(16.0F);
   private final vcj ikl = new vcj(6.0F);
   private int ikm = ucg.noticeSeq();
   private long ikn;

   ike() {
      super(null);
   }

   @Override
   float height() {
      return 45.0F;
   }

   private float ikq() {
      return this.x + this.w - 6.0F - 36.0F - 3.0F;
   }

   private float ikr() {
      return this.x + this.w - 6.0F - 18.0F;
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      if (ucg.noticeSeq() != this.ikm) {
         this.ikm = ucg.noticeSeq();
         if (ucg.notice() != null) {
            var2.toast(ucg.notice(), ucg.noticeError() ? vhz.INFO : vhz.FRIENDS, ucg.noticeError());
         }
      }

      float var6 = this.y + 4.0F;
      float var7 = iov.r(6.0F);
      boolean var8 = var2.canHover() && irr.inside(var3, var4, this.x, var6, this.ikq() - this.x - 4.0F, 26.0F);
      float var9 = this.ikk.step(var8, var5);
      uut.round(var1, this.x, var6, this.w, 26.0F, var7, ujt.lerp(iov.field, iov.fieldHover, var9));
      ukf.rim(var1, this.x, var6, this.w, 26.0F, var7, iov.lightness(), 0.6F);
      float var10 = var6 + 13.0F;
      String var11 = ucg.prettyCode();
      float var12 = this.ikl.step(0.0F, var5);
      irr.SMALL
         .draw(var1, wap.s(a.b("ﻧ蝀ඉ鏿ᡚ麈ⓗ괭㍳", 1099497143), a.b("㕼䳏오屝펰唅\uef5c", -595644055)), this.x + 9.0F, irr.SMALL.centerTop(var10 - 6.0F), iov.textMuted);
      if (var11 != null) {
         ikf.drawTracked(
            var1, var11, this.x + 9.0F, ikf.centerTop(var10 + 4.0F), ujt.lerp(iov.text, iov.accent() | 0xFF000000, Math.max(var12, var9 * 0.4F)), 1.2F
         );
      } else {
         ikf.drawTracked(var1, a.b("䅁㣰눣౫ꞅℴ魧", -2034540206), this.x + 9.0F, ikf.centerTop(var10 + 4.0F), iov.textMuted, 1.2F);
      }

      if (var12 > 0.02F) {
         uut.pushAlpha(var12);
         irr.SMALL
            .draw(
               var1,
               wap.s(a.c(2107655129, "䎜㨁냍⺥ꕾ⏎"), a.d("䞄㸮듹⪉ꅙ➐鶽ᑀ訝¡蝱", -1367118235, 1539124683)),
               this.x + 9.0F + ikf.width(var11 != null ? var11 : "") + 14.0F,
               irr.SMALL.centerTop(var10 + 4.0F),
               iov.accent() | 0xFF000000
            );
         uut.popAlpha();
      }

      boolean var13 = var11 != null;
      boolean var14 = var2.canHover() && irr.inside(var3, var4, this.ikq(), var10 - 9.0F, 18.0F, 18.0F);
      boolean var15 = var2.canHover() && irr.inside(var3, var4, this.ikr(), var10 - 9.0F, 18.0F, 18.0F);
      boolean var16 = System.currentTimeMillis() < this.ikn;
      irr.iconButton(var1, vhz.COPY, this.ikq(), var10 - 9.0F, 18.0F, this.iki.step(var14, var5), false, var13 ? 1.0F : 0.35F);
      irr.iconButton(var1, vhz.REFRESH, this.ikr(), var10 - 9.0F, 18.0F, this.ikj.step(var15, var5), var16, var13 ? 1.0F : 0.35F);
      float var17 = var6 + 26.0F + 8.0F;
      if (var2.canHover() && irr.inside(var3, var4, this.x, var17 - 5.0F, this.w, 10.0F) && ucg.fingerprint() != null) {
         var2.hint(
            wap.s(
               a.c(
                  1620938509,
                  "輌\uf68b籂\ue234榱\uef4b唖\udcfb䋽젊俖떠㭾ꋍ⢉깺ᐷ鯽ŉ蜂ຯ瓰逸懀\ue7a4浹퓁媚쁺䙸춘㍟뤐₤ꚾⰒ鎑\u19ae齶ۚ貉\uf22c砫ﾁ攙\ueb31勴\ud85f帗얔䮩녷㣌뺕\u2439ꩲᆎ靓ᴢ蓮ੈ瀊\uf7ee緺\ue37c櫐탗噲\udc3e䏀쥁伷뛱㱉ꉟ⧡꾬ᔜ鲛ʾ衤ู疗ﭓ愳\ue8f9湍퐕"
               ),
               a.d(
                  "瓠\u0d0d螣᧘鉽ᒻ꺚✗륌㟧됦乕샺夶퍣喟\uebce怅覆粓\uf56d轋צ鸹ᱲ雷⽇ꅢ㯮붼㉠좣䋦\udb1b崳힏氺\ue25e撋ﴷ獶\u09e4蟔ѷ麢Ⴋ꤅⎲ꗰ㨿끑䪅쌰䕫\udb92嗙\uea07沥\ue6d1罵\uf1ce讑క艝Პ酈⬞궓⟋렀㚸듑䵷잽姯퉫吵\ueefb杒來瞎\uf5c0蹲©髖ጎ閵⾚",
                  657668333,
                  1755072587
               )
            )
         );
      }

      if (var14 || var8) {
         var2.hint(
            wap.s(
               a.b("猷પ聦Ḟ閐፵ꤺ\u20c6뻜㐮돱䦋읝庩풻剅\ue800枕ﵵ笲\uf2ce袕٢鷺ᮘ鄝⣺ꚰ㰈먘\u31ea콽䔦\udccc媓퀩濴", 659125073),
               a.b("靖莶ॡ霑᳁騈‥꧘㞅뵆㪛쒆之\ud7fe嶧\udf42愕\ueadc瑱\uf25c篖Ǹ輻ᓨ銝ᠶꆋ⮶땕㍰룀䙡챞", 1487797788)
            )
         );
      } else if (var15) {
         var2.hint(
            var16
               ? wap.s(
                  a.d("㩨䏶줠坛\udc84婾\ue06c榛\uf7c2絻絛\u008a蹇អ鷭ᬑꄛ⺅됵㉬믟쇍佲풨勖\ud842憢\ueff4甘\uf356磦虤౼閕Ꮫ饳⚦곐⨊", 172214578, 1700721470),
                  a.c(532332127, "멭쎀䥋퍋峼\uda3d恩\ued95珐ﴀ竐胓\u0e74韎ᷯ鼇⅒꺇㐾뙻㮓䇈켎咪튡塳\ue1b2濮\uf511猷ﳦٗ豨ᖘ鏄ᤉꚬⲯꩲ")
               )
               : wap.s(
                  a.c(-1388815468, "対≤ꢥ㚃봗㮪臲ࠂ阘Ს鬮慃\uef99癭ﱱ窃샄佑햭叽\uda01ꀕ\u2ef5딣㍇릉9踻ᒛ鋒\u197c\ue7b4淹\uf40f牕\uf8aa"),
                  a.c(-2016866094, "ᓩ浻\ue7a4禬\uf209炡컨䜝\ud948埭퀶⸮ꃺ㤹댚㗠违Е骹᳢镠\uef44憃祝籜\uf680伻석很\uddb9噺ꢪ⋪뭧㵆랅\u085c虈")
               )
         );
      }

      float var18 = var6 + 26.0F + 8.0F;
      int var19;
      String var20;
      switch (ucg.status()) {
         case ONLINE:
            var19 = -11870592;
            var20 = (
                  ucg.inParty()
                     ? (
                        ucg.secured()
                           ? wap.s(
                                 a.c(329191542, "ဤ榾\ue360紀\uf6dc灤쨳䏓\udd8d坸킫⩍ꐍ㶼랿ㅟ謃Ӕ鹪ᡢ釚\ueb82敷"), a.b("䒦㴰랛⦚ꈱ⒄麩\u1754褉ε葥稊\uf4dd添\ue73f懎\udf93呐쫼䲢씧뼌㖧", 1541030054)
                              )
                              + ucg.members().size()
                           : wap.s(a.b("챂뗅㼞ꅲ⪸갎ᙔ鿢ǻ譃\u0c8d\uf6ae砭\ue180毞\ued6a坵\ud8b5䈕쑂䶸㞰륈⊗ꓴ", 2016332812), a.d("琅ඖ蜠\u193c雷ᑜ긎➊맜㜊듆亸쀝姖", -345066798, -1438137649))
                     )
                     : wap.s(
                        a.d("鷆\ue45b溉\uf0f8笤ﶓ䟗츷偩\uda9c嵏ꞩ⧩끘㩅벵ڵ褴᎖闔ᰥ晹\ue893猛\uf578羸", 266591093, 852772586),
                        a.b("吚ⶊꝓ㤬닺㐾蹤ߧ馰ጂ郏檾\ue4fe緘\uf78b略켥䂆\uda4f堆헮꾾℉뫒㢽뙱࿊臬", 1211256857)
                     )
               )
               + wap.s(a.d("襌\uf0fd窹\ue45f澈\ue972匯\udac2䓄", -778606602, -1728385389), a.b("\ufe1d螬෨錎ᣙ驲†ꦤ㟲뤤", -1003291081))
               + ucg.fingerprint();
            break;
         case CONNECTING:
            var19 = -340971;
            var20 = wap.s(a.b("\ue5d9鱄ᚖ裧̻薌㿈똤⡼ꋄՖ", 950068625), a.d("읂뻒㐋ꩴ↢Ꝧᴼ钿૨聜ނ\ud9e0", -841583106, 1251391151));
            break;
         case RETRY:
            var19 = -429290;
            var20 = wap.s(a.b("䉶㯦녺⽈꒓∣顰ᆊ迓յ芻磌\uf61a濩\ue5b6挕\ud94d嚍참䩢쎅맓㝩", 1528381999), a.b("\uf890脉\u0bad醾Ḉ飊⋤\uab6d㔽뮘㱇숩䳿핂彡\ud9ec揝", -1800602468))
               + (ucg.lastError() != null ? a.c(1511940016, "徕☤걠㊆륑") + ucg.lastError() : "");
            break;
         case REPLACED:
            var19 = -429290;
            var20 = wap.s(a.b("啈ⳕꘇ㡶뎪㔝轙ڹ飧ሒ閇濢\ue128碛\uf285琵칵䆥\udb0d嵀풺껼”뮋㷲뜯ດ", -370584304), a.c(80172220, "傺⤪ꏳ㶌뙚ゞ諄͇鴐អ鑯樆\ue4de祸\uf73f熺쯶䑗\udee9墿핑\uab18■븂㡶"));
            break;
         case NO_SERVER:
            var19 = iov.textMuted;
            var20 = wap.s(
               a.d("㿲䙵첷劒\ud911徼\ue5e2汖\uf259磹ＹՎ讔ቼ顼ẛ꓃⬖놶㟰빕쑆䫲턪坖\udd9f", 50517084, -1884886041), a.b("욯뼇㗞ꮩ⁰ꚻᲟ酻\u0b45膀ئﰥ狵\ueb31攂\ue7ec嶬툏䣆쪏䝥㴱뎌⡞", 1739375252)
            );
            break;
         default:
            var19 = iov.textMuted;
            var20 = wap.s(a.b("㊛䬛쇛徬푶办\ue884慯｣疝\uf247࠶", 1719415495), a.d("ᬨ抶\ue817瘜陸筰셚䣚횄局\udb9a↙꽆㛴", -156887285, 1135675442));
      }

      uut.circle(var1, this.x + 3.0F, var18, 1.8F, var19);
      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var20, this.w - 12.0F), this.x + 8.0F, irr.SMALL.centerTop(var18), iov.textDim);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return false;
      } else {
         float var5 = this.y + 4.0F + 13.0F;
         String var6 = ucg.prettyCode();
         if (irr.inside(var2, var3, this.ikr(), var5 - 9.0F, 18.0F, 18.0F)) {
            if (var6 == null) {
               return true;
            } else {
               if (System.currentTimeMillis() < this.ikn) {
                  this.ikn = 0L;
                  ucg.newCode();
               } else {
                  this.ikn = System.currentTimeMillis() + 2500L;
               }

               return true;
            }
         } else if (irr.inside(var2, var3, this.x, this.y + 4.0F, this.ikr() - this.x - 2.0F, 26.0F)) {
            if (var6 == null) {
               var1.toast(
                  wap.s(
                     a.c(-1684667425, "\u038b稛\uf087溵\ue56e揔\ud986倲츴䒙썛㥤랩⹖ꐄ⋮飵ᝧ跘ஈ艿\uf825皐\ued56欸\ue1e8"),
                     a.d("祡ô設ᑘ鮟ᤱꍣ⪖듃㩢리䏕쵵傼\udaf5堙\ue25e淸\uf329焙\uf89d花౺鞤", -1722530915, -1382400258)
                  ),
                  vhz.INFO,
                  true
               );
               return true;
            } else {
               MinecraftClient.method_1551().field_1774.method_1455(var6);
               this.ikl.set(1.0F);
               var1.toast(wap.s(a.b("閲\uec2f曷\uf887猕\uf5e7侸왖堐튭啿꽐↝", -401631748), a.c(725901426, "摸ᷭ霴\u0d51苧Э빺㞊꧒⌛꒶廋퀞䦢쟶䄝")) + var6, vhz.COPY, false);
               return true;
            }
         } else {
            return false;
         }
      }
   }
}
