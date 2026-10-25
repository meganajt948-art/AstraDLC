package a;

import flow.dev.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;

final class ild extends imn {
   private static final float ile = 26.0F;
   private static final float ilf = 3.0F;
   private static final float ilg = 16.0F;
   private static final float ilh = 18.0F;
   private static final float ili = 24.0F;
   private static final float ilj = 58.0F;
   private final Map<String, vcj[]> ilk = new HashMap<>();
   private final vcj ill = new vcj(16.0F);
   private String ilm;
   private long iln;

   ild() {
      super(null);
   }

   private static List<ubg> ilq() {
      return ucg.invites();
   }

   private static List<ubm> ilr() {
      return ucg.inParty() ? ucg.members() : List.of();
   }

   @Override
   float height() {
      int var1 = ilq().size() + ilr().size();
      return var1 == 0 ? 58.0F : 2.0F + var1 * 29.0F + (ucg.inParty() ? 24.0F : 0.0F);
   }

   private float ils(int var1) {
      return this.y + 2.0F + var1 * 29.0F;
   }

   private vcj[] ilt(String var1) {
      return this.ilk.computeIfAbsent(var1, var0 -> new vcj[]{new vcj(9.0F), new vcj(14.0F), new vcj(18.0F), new vcj(18.0F)});
   }

   private float ilu() {
      return this.x + this.w - 6.0F - 18.0F;
   }

   private float ilv() {
      return this.ilu() - 18.0F - 3.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = ilq();
      List var7 = ilr();
      if (var6.isEmpty() && var7.isEmpty()) {
         this.ilk.clear();
         float var13 = this.x + this.w * 0.5F;
         uut.circle(var1, var13, this.y + 17.0F, 12.0F, iov.hover);
         vjf.draw(var1, vhz.FRIENDS, var13, this.y + 17.0F, 11.0F, iov.textMuted);
         irr.LABEL
            .drawCentered(
               var1,
               wap.s(a.d("胬良珠\uedc1昇\ue0a5嫰파䴊쟢䀭멍", -1523322881, -1523617967), a.c(-1303843131, "\uead7鍉᧨蟣ࠬ誂バ뤥❰꧑⨟큦廆")),
               var13,
               irr.LABEL.centerTop(this.y + 38.0F),
               iov.textDim
            );
         irr.SMALL
            .drawCentered(
               var1,
               wap.s(
                  a.d("瑧\u0df1蜺ᥔ銞ᐾ긨➘릆㍱뒶仜쀇妽폤啑\uef5c悖塚籹\uf592迎ű骻Ზ阄⾻ꇡ㬗", -179794489, -1511654924),
                  a.c(807734794, "ਉ珧樓朶\uece9橓큱姹쟜䴚컜ス븚➨궋⭹锦Ứ葚ؕ请\uf1a0缞\ue0d1抴\ue861凘\udffe")
               ),
               var13,
               irr.SMALL.centerTop(this.y + 49.0F),
               iov.textMuted
            );
      } else {
         if (this.ilm != null && System.currentTimeMillis() > this.iln) {
            this.ilm = null;
         }

         int var8 = 0;

         for (ubg var10 : var6) {
            this.ilw(var1, var2, var10, this.ils(var8++), var3, var4, var5);
         }

         for (ubm var16 : var7) {
            this.ilx(var1, var2, var16, this.ils(var8++), var3, var4, var5);
         }

         if (ucg.inParty()) {
            float var15 = this.ils(var8) + 2.0F;
            float var17 = Math.min(this.w, 110.0F);
            float var11 = this.x + (this.w - var17) * 0.5F;
            float var12 = this.ill.step(var2.canHover() && irr.inside(var3, var4, var11, var15, var17, 17.0F), var5);
            irr.secondaryButton(
               var1,
               wap.s(a.b("ѯ緷\uf720楆\ue282摶\ude75垕짙䍮쒰", -1211890648), a.c(682252374, "屉□꼀ㄊ몧㠎虅ྻ闳᭝鲁暂\ue82f")),
               vhz.LOGIN,
               var11,
               var15,
               var17,
               17.0F,
               var12,
               0.0F
            );
         }
      }
   }

   private void ilw(DrawContext var1, hlc var2, ubg var3, float var4, float var5, float var6, float var7) {
      vcj[] var8 = this.ilt(a.c(-120173457, "䰄㗦") + var3.party);
      float var9 = vcq.outCubic(var8[0].step(1.0F, var7));
      boolean var10 = var2.canHover() && irr.inside(var5, var6, this.x, var4, this.w, 26.0F);
      float var11 = var8[1].step(var10, var7);
      uut.pushAlpha(var9);
      float var12 = iov.r(6.0F);
      int var13 = iov.accent() | 0xFF000000;
      uut.round(var1, this.x, var4, this.w, 26.0F, var12, ujt.withAlpha(var13, Math.round(34.0F + 20.0F * var11)));
      uut.outline(var1, this.x, var4, this.w, 26.0F, var12, 1.0F, ujt.withAlpha(var13, 90));
      float var14 = var4 + 13.0F;
      hyj.face(var1, var3.name, hhf.skinOf(var3.name), this.x + 5.0F, var14 - 8.0F, false);
      float var15 = this.x + 5.0F + 16.0F + 7.0F;
      float var16 = this.ilv() - var15 - 4.0F;
      irr.CARD_TITLE.draw(var1, irr.CARD_TITLE.ellipsize(lsx.protect(var3.name), var16), var15, irr.CARD_TITLE.centerTop(var14 - 4.0F), iov.text);
      long var17 = Math.max(0L, (var3.until - System.currentTimeMillis()) / 1000L);
      irr.SMALL
         .draw(
            var1,
            irr.SMALL
               .ellipsize(
                  wap.s(a.c(-139622589, "蜚ﺌ瑇\uea29懣\ue743崆풤䪢쀅䟌뷨㌿ꨙ⃝\ua62c"), a.b("凥⡽ꊢ㲰띴㖧详\u0605鱅\u16fb酚歑\ue19e砯\uf2eb璍컂", 1072911843))
                     + var17
                     + wap.s(a.c(683811894, "⑄"), a.d("ﴶ", -1670501306, -290335440)),
                  var16
               ),
            var15,
            irr.SMALL.centerTop(var14 + 5.0F),
            var13
         );
      boolean var19 = var2.canHover() && irr.inside(var5, var6, this.ilv(), var14 - 9.0F, 18.0F, 18.0F);
      boolean var20 = var2.canHover() && irr.inside(var5, var6, this.ilu(), var14 - 9.0F, 18.0F, 18.0F);
      float var21 = var8[2].step(var19, var7);
      uut.round(var1, this.ilv(), var14 - 9.0F, 18.0F, 18.0F, iov.r(4.0F), ujt.withAlpha(-11870592, Math.round(60.0F + 80.0F * var21)));
      vjf.draw(var1, vhz.CHECK, this.ilv() + 9.0F, var14, 7.5F, -1);
      irr.iconButton(var1, vhz.CLOSE, this.ilu(), var14 - 9.0F, 18.0F, var8[3].step(var20, var7), false, 1.0F);
      if (var10 && !var19 && !var20) {
         var2.hint(
            wap.s(a.b("슚묅㇊꿢⑳ꋍᢙ酡༼薚ɋ\uf838直\uef42攋\ue3ae", 1612038849), a.c(1122027293, "쌓뫾ぐ긫▎ꍈᥩ郤\u0ebf耔ϝ玲眏\ueeb7撓\ue672"))
               + var3.fingerprint
               + wap.s(
                  a.d("┮岅혗䡴쎻䕁ｆ皫\ue8f9所\ue5deΏ鄷ࣉ苙Ф빪ㆳ\uab0fⵅ꒭\udeb1偋쮇", 529235210, -1108191226),
                  a.b("凕⡾ꚲ㣂댔㗚迷ٹ顟ኔ锰歔\ue197硒\uf202璃컏䔎\udba2已퐏긨⃫묽㴷랒อ耆\u1aff", -1083289102)
               )
         );
      }

      if (var19) {
         var2.hint(wap.s(a.b("ꬕ튁塔옢䶻", 942058330), a.b("憸ᡚ銊\u0cfa蝑ǧ믎㈱ꠂ⚡ꕠ嬎헖䰕옼䓕", -1263114822)) + var3.name);
      } else if (var20) {
         var2.hint(wap.s(a.c(737394, "䀱㦡덴ⴊꛘ\u206e騶"), a.d("袊\uf167篌\ue5bc湮\ue8dc劊\udb01䕐", -1946326419, -204216592)));
      }

      uut.popAlpha();
   }

   private void ilx(DrawContext var1, hlc var2, ubm var3, float var4, float var5, float var6, float var7) {
      vcj[] var8 = this.ilt(a.d("Ⴋ楍", -1335554178, 1029644218) + var3.code);
      float var9 = vcq.outCubic(var8[0].step(1.0F, var7));
      boolean var10 = var2.canHover() && irr.inside(var5, var6, this.x, var4, this.w, 26.0F);
      float var11 = var8[1].step(var10, var7);
      uut.pushAlpha(var9);
      var1.method_51448().pushMatrix();
      var1.method_51448().translate((1.0F - var9) * 18.0F, 0.0F);
      float var12 = iov.r(6.0F);
      uut.round(var1, this.x, var4, this.w, 26.0F, var12, ujt.withAlpha(iov.hover, (int)(ujt.alpha(iov.hover) * (0.6F + 1.4F * var11))));
      float var13 = var4 + 13.0F;
      boolean var14 = var3.code.equals(ucg.code());
      hyj.face(var1, var3.name, hhf.skinOf(var3.name), this.x + 5.0F, var13 - 8.0F, var3.online);
      uut.round(var1, this.x + 1.5F, var13 - 6.0F, 2.0F, 12.0F, 1.0F, var3.color | 0xFF000000);
      float var15 = this.x + 5.0F + 16.0F + 7.0F;
      float var16 = this.ilu() - var15 - 4.0F;
      boolean var17 = var3.code.equals(ucg.leader());
      float var18 = irr.CARD_TITLE
         .draw(var1, irr.CARD_TITLE.ellipsize(lsx.protect(var3.name), var16 - (var17 ? 12.0F : 0.0F)), var15, irr.CARD_TITLE.centerTop(var13 - 4.0F), iov.text);
      if (var17) {
         vjf.draw(var1, vhz.CROWN, var18 + 6.0F, var13 - 4.0F, 7.0F, -340971);
      }

      PlayerEntity var21 = hhf.inWorld(var3.name);
      MinecraftClient var22 = MinecraftClient.method_1551();
      String var19;
      int var20;
      if (var14) {
         var19 = wap.s(a.c(-378557454, "ꮨ툯壦"), a.d("꺀흨", 414255808, -1320378288));
         var20 = -11870592;
      } else if (var3.sealed) {
         var19 = wap.s(a.b("쭲닢㡾Ꙅ\u2d9dꬰᄺ颒ۑ豱", -1395078346), a.b("ꬸ튡堅숖䷛쭫煍\uf8b5暝", -389697748));
         var20 = -429290;
      } else if (!var3.online) {
         var19 = wap.s(a.b("ꒈ\udd10埃즸䉪쓜纄", 1468835008), a.b("䃵㥬랪ⷉꈌ⃜髻\u137d赘", 1529496801));
         var20 = iov.textMuted;
      } else if (var21 != null && var22.field_1724 != null) {
         var19 = wap.s(a.b("禥9諽ᒛ鼉ᦸꍼ⨚둅", -1075021340), a.b("₣好폕䶮왻䓖ﺅ矣\ue92b掚", 1905468553)) + wkw.formatDistance(Math.sqrt(var22.field_1724.method_5858(var21)));
         var20 = -11870592;
      } else if (ucg.sameWorld(var3)) {
         var19 = wap.s(a.d("\ueefb靫᷶菓࠘躨㓡뵃⍏ꧨ⸬푙媝쌻", 296163623, 1806104477), a.c(-1114316876, "\udba6ꈺ⳹뛥㴽믰ơ豌ᙲ鲷ᬑ\ue112濂\uf606簠"));
         var20 = ujt.lerp(-11870592, iov.textDim, 0.4F);
      } else if (var3.world == null) {
         var19 = wap.s(a.b("̓竓\uf002湶\ue5a6挜\ud90a僻츳䐕쏆㧾뜮⻑ꓖ∻项\u17ed贓\u0b4a芶\uf8fc", -2014117094), a.d("蒢嵐瞓\ue996戶\ue4fd媶퍇䶏잩䁺븙㓜ꥱ⌫ꗒ΅", -1321396043, 488085524));
         var20 = iov.textDim;
      } else {
         var19 = wap.s(a.d("\ude17ꞇⵖ댢㣲빈ў趯፧饁Ẓ", 405513335, 1868200484), a.b("쿢뉡㳓ꋖ⥶꾽ᇶ頇ۏ賩\u0b3a", -968242181)) + ily(var3.world);
         var20 = iov.textDim;
      }

      uut.circle(var1, var15 + 1.6F, var13 + 5.0F, 1.6F, var20);
      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var19, var16 - 6.0F), var15 + 5.5F, irr.SMALL.centerTop(var13 + 5.0F), var20);
      if (var10 && var3.fingerprint != null) {
         var2.hint(
            (
                  var14
                     ? wap.s(a.d("┃岄홍䠻쎾䕄９直\ue8f2", -2101602005, 635976824), a.d("閹\uec2a暁ﲘ獕\uf5e5促옻尃", -1906789718, -1510333688))
                     : wap.s(a.c(1916800255, "ತ画\ufff4懜\uea4d泳횧彟섂䮤챵㘆룊ⅼꬵⶐ"), a.b("㯡䈌좢囙\udd7c宺\ue19b栖\uf64d磦אָş追ᙅ鱡Ẁ", 580272111))
               )
               + var3.fingerprint
               + (
                  var14
                     ? ""
                     : wap.s(
                        a.d("褕\uf0be種\ue453澆\ue92a卨\uda8a䓂츶䦲돝㴗꒺⺡", 1908501749, 1609164245) + var3.name,
                        a.c(1277928117, "ꊃ\udb28喚쮘䁈욌糓\uf52c欄\ue5a0昒頂") + var3.name
                     )
               )
         );
      }

      if (ucg.isLeader() && !var14) {
         boolean var23 = var3.code.equals(this.ilm);
         float var24 = this.ilu() + (1.0F - var11) * 6.0F;
         boolean var25 = var2.canHover() && irr.inside(var5, var6, var24, var13 - 9.0F, 18.0F, 18.0F);
         irr.iconButton(var1, vhz.CLOSE, var24, var13 - 9.0F, 18.0F, var8[2].step(var25, var7), var23, var23 ? 1.0F : var11);
         if (var25 && var11 > 0.5F) {
            var2.hint(
               var23
                  ? wap.s(a.c(-1966408401, "ﵺ蓤า遉ᮖ鵬❾꺉バ멩㶽잂䤁킫媷\udc14晌\ue995猤\uf56c粈ڜ"), a.c(235409942, "ᘚ濷\ue53c缼\uf08b癊찞䇴\udfa7共횧Ⲫꉲ㮹떁㝨赞˴顆Ṣ鞜\uedb2捻\uf8a4窷"))
                     + var3.name
                  : wap.s(a.d("\udd4d\ua4cb⸐끣㮭봏ܙ躮ქ驉ᶘ\ue7a4椧\uf08a竔ﱠ䙿즿匟핈岲", 1296676872, -534878974), a.c(130650745, "陰\uef98攰נּ烢\uf65a䱶엽宬핱嚺계☄뮪ㇶ띵ീ"))
            );
         }
      }

      var1.method_51448().popMatrix();
      uut.popAlpha();
   }

   private static String ily(String var0) {
      if (var0.startsWith(a.c(-988806947, "³礟\uf386"))) {
         return var0.substring(3);
      } else {
         return var0.startsWith(a.b("撊ᴸ鞡", -218471174)) ? wap.s(a.b("䃔㥿뎫ⷓ꘏₷髱ጜ赎ߧ耨穎", 771506347), a.b("ꕉ\udcf2嘭졙䎍악罬\uf690械\ue66e斥鿟ᅻ袺", 1054318969)) : var0;
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return this.hovered(var2, var3);
      } else {
         List var5 = ilq();
         List var6 = ilr();
         int var7 = 0;

         for (ubg var9 : List.copyOf(var5)) {
            float var10 = this.ils(var7++) + 13.0F;
            if (irr.inside(var2, var3, this.ilv(), var10 - 9.0F, 18.0F, 18.0F)) {
               if (!ucg.online()) {
                  var1.toast(
                     wap.s(
                        a.c(-200927750, "ᖕ氅\ue6cd磨\uf37c痁쾓䙢\ud836劁핅⼥ꇳ㠆눁㓫軫Ů鯁ᶝ鐯\uee2e悌פֿ紷\uf7eb丁쀃嫢\udca4圓꧑⎉"),
                        a.d("㚹传얄得퀡団\ueccd敄ﬔ疽\uf60fࠟ芩᭬酊៉궁∥루㺻덐촞䎢\ud801帄", -1739446594, -2024467453)
                     ),
                     vhz.INFO,
                     true
                  );
                  return true;
               }

               ucg.accept(var9);
               return true;
            }

            if (irr.inside(var2, var3, this.ilu(), var10 - 9.0F, 18.0F, 18.0F)) {
               ucg.decline(var9);
               return true;
            }
         }

         for (ubm var13 : List.copyOf(var6)) {
            float var15 = this.ils(var7++) + 13.0F;
            if (ucg.isLeader() && !var13.code.equals(ucg.code()) && irr.inside(var2, var3, this.ilu(), var15 - 9.0F, 18.0F, 18.0F)) {
               if (var13.code.equals(this.ilm)) {
                  this.ilm = null;
                  ucg.kick(var13);
               } else {
                  this.ilm = var13.code;
                  this.iln = System.currentTimeMillis() + 2500L;
               }

               return true;
            }
         }

         if (ucg.inParty()) {
            float var12 = this.ils(var7) + 2.0F;
            float var14 = Math.min(this.w, 110.0F);
            float var16 = this.x + (this.w - var14) * 0.5F;
            if (irr.inside(var2, var3, var16, var12, var14, 17.0F)) {
               ucg.leave();
               return true;
            }
         }

         return this.hovered(var2, var3);
      }
   }
}
