package a;

import flow.config.ConfigManager;
import flow.config.ConfigShare;
import flow.dev.a;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class hvq extends imn {
   static final float hvr = 30.0F;
   static final float hvs = 3.0F;
   static final float hvt = 18.0F;
   static final vhz[] hvu = new vhz[]{vhz.DOWNLOAD, vhz.SAVE, vhz.PENCIL, vhz.SHARE, vhz.TRASH};
   static final int hvv = 3;
   static final int hvw = 4;
   static final SimpleDateFormat hvx = new SimpleDateFormat(a.d("㋅䬰솎忿퐨勸\ue8a7愾｡疢\uf226ࡗ", 1038541595, -666906186), Locale.ROOT);
   static final SimpleDateFormat hvy = new SimpleDateFormat(
      a.d("\uf4c1贴ފ駻ሬ铼⺣Ꜻ㥥뎦㐢칓", 1156223964, -2001901707), Locale.forLanguageTag(a.d("쥏냹", -107638558, 48650717))
   );
   final hur hvz;
   List<ConfigManager.Info> hwa = new ArrayList<>();
   Map<String, String> hwb = new HashMap<>();
   String hwc;
   int hwd = -1;
   long hwe;
   final Map<String, hvn> hwf = new HashMap<>();
   String hwg;
   long hwh;

   static String hwk(int var0, String var1) {
      return switch (var0) {
         case 0 -> wap.s(a.d("횀꼒●뮻〨뛍ಂ蕲ᬷ釕ᙅ\uec38拮ﭗ焋\uf7f4", 2141701512, -1699409068), a.c(820253083, "ᖙ氏\ue6df磝\uf309痌쾐䘛\ud84a嚗픩⽗ꇼ㠱똀㓫躠Ų鮸ᶕ鑩"));
         case 1 -> wap.s(
            a.b("㶨䐠컠傆\udb54巠\ue7a8湄\uf00a竾ﵺܕ觟ၲ驩\u1cccꚟ⥃뎵㖧뱆옐䢣퍥唑\udfda昽\ue83f狞\uf49e缭臡ன鉑ᐖ", -1458946620),
            a.b("镫\uecf0晖\uf852率\uf531佭욛墽퉽嗜꾣┘룋㋯됑ว臼ᬾ鵫ᒘ櫑\ue07f箣ﶭ睿컎䃡\uda11屃ퟺ⤧ꍬ", -1598713515)
         );
         case 2 -> wap.s(
            a.d("箜Ț裂ᚼ鵧ᯞꇈ⡭똩㳗뭐䄽쿧嘓\udc0e嫰\ue0b3潪\uf59c玄充聫ຌ镁ጳ馧⁒긌㓷늯㤔잁䶏푽刣\ud88b杏", 1874400341, 12808126),
            a.d("\uf217讌Ī鼮ᓴ鉁⠛ꇢ㾾딃㋒죑䘈\udbd5喔흷椠\ue6f5簵︋珤\u09ba茞᳐骮ၺꦽ⎃뵦㭎냾乒", 1590920027, -639142541)
         );
         case 3 -> var1 != null
            ? wap.s(
               a.c(-1376058180, "Ӻ絧\uf7bf槏\ue25d") + var1 + a.b("ꎜ\uda37傧컚䔒쎪禠\uf018湚\ue4bf挭饓ណ蹻ѻ芜㣘뜃ⷴ꯬∆堃훤䴮쬞䆎\uf87c癫\uec88櫂\ue17dᾧ闢", 963158919),
               a.b("嗦ⱳꚪ㳏", -110800392) + var1 + a.b("\ue55d鳶ቄ豎ޝ脭㭹닰ⳑꙬ↽\udbbe啧좺䛱쐘穉\uf5e4漪\ue904悃\u1ad0鑩࿂観\u070e목㒌깸⡙ꎚ", -831527560)
            )
            : wap.s(
               a.b("⸱垻\udd61䌃죃中\uf464緒\ue38f椯\ueea8ᒘ騎ϼ覣ཙ딗㪃ꁶ☮꿄헇嬵삥䚜챙痱ﮬ慐\ue70b", 275721852), a.b("\uf36e諾'鹗ᖎ錼⤕ꃪ㺸됇㞡췊䜂\udeb2哤퉭栦\ue788絁ﬞ皅࣎虹ᶢ鿉ᄌꢰ⚕렍㩈놏佝앢岐", -517343405)
            );
         default -> wap.s(
            a.c(236876979, "瓨൸螢᧚鈜ᒼ꺪❓륇㏹됯乔삋奱퍣喔\uefdd怄練粯\uf50c轆ƺ騨ᱛ隋⼰ꅮ㮂뷌㘻"),
            a.b("ᘟ澹\ue56e笔\uf0c0瘋챖䇋\udf9c儸훦ⲑꉌ㯹뇐㝖褌ˈ頇Ṏ鏈\uedf9挺\uf8ec窄\uf441䷽쏘嵀\udf0e咼ꩧ⁞맟㾋땏૮肝ُ鿶ᖬ欪\ue51f", -1462693353)
         );
      };
   }

   hvq(hur var1) {
      super(null);
      this.hvz = var1;
   }

   List<ConfigManager.Info> hwl() {
      long var1 = System.currentTimeMillis();
      if (this.hwd != ConfigManager.version() || var1 - this.hwe > 1500L) {
         this.hwd = ConfigManager.version();
         this.hwe = var1;
         this.hwa = ConfigManager.list();
         this.hwb = ConfigShare.codes();
      }

      return this.hwa;
   }

   @Override
   float height() {
      int var1 = this.hwl().size();
      return var1 == 0 ? 58.0F : 2.0F + var1 * 33.0F;
   }

   float hwm(int var1) {
      return this.y + 2.0F + var1 * 33.0F;
   }

   float hwn(int var1) {
      return this.x + this.w - 8.0F - (hvu.length - var1) * 22.0F + 4.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = this.hwl();
      if (var6.isEmpty()) {
         this.hwo(var1);
      } else {
         if (this.hwg != null && System.currentTimeMillis() > this.hwh) {
            this.hwg = null;
         }

         String var7 = ConfigManager.active();
         float var8 = iov.r(6.0F);

         for (int var9 = 0; var9 < var6.size(); var9++) {
            ConfigManager.Info var10 = (ConfigManager.Info)var6.get(var9);
            hvn var11 = this.hwf.computeIfAbsent(var10.name(), var0 -> new hvn());
            float var12 = this.hwm(var9);
            float var13 = vcq.outCubic(var11.appear.step(1.0F, var5));
            boolean var14 = var2.canHover() && irr.inside(var3, var4, this.x, var12, this.w, 30.0F);
            float var15 = var11.hover.step(var14, var5);
            boolean var16 = var10.name().equals(var7);
            uut.pushAlpha(var13);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate((1.0F - var13) * 18.0F, 0.0F);
            int var17 = var16 ? iov.accent(26) : ujt.withAlpha(iov.hover, (int)(ujt.alpha(iov.hover) * (0.6F + 1.4F * var15)));
            uut.round(var1, this.x, var12, this.w, 30.0F, var8, var17);
            if (var16 || var15 > 0.01F) {
               uut.outline(
                  var1, this.x, var12, this.w, 30.0F, var8, 1.0F, var16 ? iov.accent(110) : ujt.withAlpha(iov.stroke, (int)(ujt.alpha(iov.stroke) * var15))
               );
            }

            float var18 = this.x + 15.0F;
            float var19 = var12 + 15.0F;
            if (var16) {
               uut.shadow(var1, var18 - 9.0F, var19 - 9.0F, 18.0F, 18.0F, 9.0F, 5.0F, iov.accent(80));
               uut.gradient(var1, var18 - 9.0F, var19 - 9.0F, 18.0F, 18.0F, 9.0F, iov.accent(), iov.accent2(), iov.accent2(), iov.accent());
            } else {
               uut.circle(var1, var18, var19, 9.0F, iov.field);
            }

            vjf.draw(var1, vhz.LAYERS, var18, var19, 8.0F, var16 ? iov.onAccent() : ujt.lerp(iov.textMuted, iov.textDim, var15));
            float var20 = this.x + 31.0F;
            float var21 = this.hwn(0) - var20 - 8.0F;
            String var22 = irr.CARD_TITLE.ellipsize(var10.name(), var21 - (var16 ? 36.0F : 0.0F));
            float var23 = irr.CARD_TITLE.draw(var1, var22, var20, irr.CARD_TITLE.centerTop(var19 - 4.5F), iov.text);
            if (var16) {
               uut.round(var1, var23 + 5.0F, var19 - 9.0F, 30.0F, 9.0F, 4.5F, iov.accent(45));
               irr.SMALL
                  .drawCentered(
                     var1, wap.s(a.b("\ue776黥ᐡ詍ƅ蜧", -1333401807), a.c(926177532, "峫╰꿛㇐먍㲻蛠")), var23 + 20.0F, irr.SMALL.centerTop(var19 - 4.5F), iov.accent()
                  );
            }

            String var24 = this.hwb.get(var10.name());
            String var25 = (wap.ru() ? hvy : hvx).format(new Date(var10.modified()))
               + a.d("쀎릿㏻괝⛊", -533055473, -170854364)
               + var10.enabled()
               + wap.s(a.d("쏫먕ハ껸", 596163630, 1642233825), a.b("頤\ue58d潑\uf537", -2012112896))
               + var10.modules()
               + wap.s(a.b("䯚㈤룶", 1674005497), a.c(-1960707270, "ﬞ蚽౦鈖"))
               + (var24 != null ? wap.s(a.b("琉聽ਹ铟Ἀ駺⎥꩟㐁뻵", -1084818970), a.b("\ud81dꆬ⯨딎㻙뱲إ连ᖕ", -1959274444)) + var24 : "");
            irr.SMALL.draw(var1, irr.SMALL.ellipsize(var25, var21), var20, irr.SMALL.centerTop(var19 + 5.5F), iov.textMuted);
            float var26 = 0.45F + 0.55F * var15;

            for (int var27 = 0; var27 < hvu.length; var27++) {
               float var28 = this.hwn(var27);
               float var29 = var19 - 9.0F;
               boolean var30 = var2.canHover() && irr.inside(var3, var4, var28, var29, 18.0F, 18.0F);
               float var31 = var11.buttons[var27].step(var30, var5);
               boolean var32 = var27 == 4 && var10.name().equals(this.hwg);
               boolean var33 = var27 == 3 && var10.name().equals(this.hwc);
               irr.iconButton(var1, hvu[var27], var28, var29, 18.0F, var33 ? 1.0F : var31, var32, !var32 && !var33 ? var26 : 1.0F);
               if (var30) {
                  var2.hint(
                     var32
                        ? wap.s(
                           a.d("\u0e7e矠ﴶ捍\ue892湨푺嶍쏔䥭캹㒆먅⎯꦳⼆镈᪐耪٪辌\uf598嬗", 392938758, 117492524) + var10.name() + a.b("䳃", 1432055007),
                           a.b("江ᗃ鼖ŭ誾\u0c75뙑㮵ꇿ⬲곹勹\ud84e䆏쯛䤱\uf372磄\ue272摟\ueda7鞌ᵔ苦Ӯ踻㞃맑⍜ꔃ⫝̸풆", -548837278) + var10.name() + a.c(-1671697380, "\ueca6")
                        )
                        : hwk(var27, var24)
                  );
               }
            }

            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }
      }
   }

   void hwo(DrawContext var1) {
      float var2 = this.x + this.w * 0.5F;
      uut.circle(var1, var2, this.y + 17.0F, 12.0F, iov.hover);
      vjf.draw(var1, vhz.LAYERS, var2, this.y + 17.0F, 11.0F, iov.textMuted);
      irr.LABEL
         .drawCentered(
            var1,
            wap.s(a.c(994929135, "榯ဿ骣ґ轊৺뎡㩟ꐎ⺫꤫匃\uddc8䑨"), a.d("哣\u2d76Ꞧ㦮눅㒿軡ܜ鵑\u13ff鐭湘\ue085紤\uf36a疓쾫", -95405072, -1713804520)),
            var2,
            irr.LABEL.centerTop(this.y + 38.0F),
            iov.textDim
         );
      irr.SMALL
         .drawCentered(
            var1,
            wap.s(
               a.d("⡨凴\udb2e䕊컘䠨\uf23a箅\ue5d5潨\ue8b3ኇ鰑֣追क덉㳝\ua62fⁱꦌ펙嵺용䃁쨆玵ﶷ朳\ue150櫴鐶", 1626428713, -1909490379),
               a.d("饂\ue0d3樇\uf477羬不䍃캧哠\ude55姵\ua7eb\u2d2e듦㺶렺٠趩ጂ酎ᢴ拣\uec5a瞏\uf18a第욊䡐혭偣\udbab╿꽀㚼냪㨡藸\u0b7e", -1919986973, 975294357)
            ),
            var2,
            irr.SMALL.centerTop(this.y + 49.0F),
            iov.textMuted
         );
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      List var5 = this.hwl();

      for (int var6 = 0; var6 < var5.size(); var6++) {
         float var7 = this.hwm(var6);
         if (irr.inside(var2, var3, this.x, var7, this.w, 30.0F)) {
            String var8 = ((ConfigManager.Info)var5.get(var6)).name();
            float var9 = var7 + 15.0F;

            for (int var10 = 0; var10 < hvu.length; var10++) {
               if (var4 == 0 && irr.inside(var2, var3, this.hwn(var10), var9 - 9.0F, 18.0F, 18.0F)) {
                  this.hwp(var1, var10, var8);
                  return true;
               }
            }

            this.hvz.name.setText(var8);
            return true;
         }
      }

      return false;
   }

   void hwp(hlc var1, int var2, String var3) {
      try {
         switch (var2) {
            case 0:
               ConfigManager.load(var3);
               var1.toast(
                  wap.s(a.b("攣Ჱ陬࠘菎վ뽩ᚤ", -603101849) + var3 + a.b("㾀", -1952964708), a.b("\ud8c9ꅟ⮏떍㹙뢝ˍ謴ᅶ魌", -791028524) + var3 + a.b("Ⱉ", -1716376413)),
                  vhz.DOWNLOAD,
                  false
               );
               break;
            case 1:
               ConfigManager.save(var3);
               var1.toast(
                  wap.s(a.b("\uf2b1謲Ƕ龔ᑂ銷ࣘ", 926151397) + var3 + a.c(1338369250, "쓾"), a.b("憷᠙銱\u0cc5蝢Ǟ뮅㉼갠⊏ꗗ", -461019747) + var3 + a.c(-2038834614, "\udaf0")),
                  vhz.SAVE,
                  false
               );
               break;
            case 2:
               String var4 = ConfigManager.sanitize(this.hvz.name.text);
               if (var4 != null && !var4.equals(var3)) {
                  ConfigManager.rename(var3, var4);
                  this.hwf.put(var4, this.hwf.remove(var3));
                  var1.toast(
                     wap.s(
                        a.b("є緒\uf70a楴\ue2af搖\ude44埱짺䍐쓌ẁ", 1033503754) + var4 + a.b("ߐ", 74983372),
                        a.c(-1895126636, "궛퐀度삢䭸췍瞗\ufe6e怲\uea8f浞霢ᷨ聋ช衰") + var4 + a.c(1540901174, "䦌")
                     ),
                     vhz.PENCIL,
                     false
                  );
                  break;
               }

               this.hvz.name.error();
               var1.focus(this.hvz.name);
               var1.toast(
                  wap.s(
                     a.d("ଭ犱\uf86b昏\ued9d歸턷壋웑䰮쯶㆕뼕⛪겶⩋逌ᾘ蕢̴認\uf088縧\ue5fb揁\ue956僪\udeb7䑉숐䧧띷㴻\ua4c7⊍\ua82fឱ鷌ᭋ苦ࢴ癎ﱓ箲\ue167漁후屵\uda69䇬쾃㕟벭㪬ꁊ⸐関፹餏", 629420773, 610220455),
                     a.c(-75414233, "䄅㢔뉀ⰰ\ua7eb℠鬄ᛠ貢ؐ臏箲\uf56e棊\ue681恴\uda48凶콗䴔샼몬㐚꿅\u2dafꍬ᪦铴\u0e7e谺Α菱眊\ueef6梣\ue218巋ퟀ兤쳀䊅㱾뙝㆜ꭆ┾鳩ᘠ")
                  ),
                  vhz.PENCIL,
                  true
               );
               return;
            case 3:
               this.hwq(var1, var3);
               break;
            case 4:
               if (!var3.equals(this.hwg)) {
                  this.hwg = var3;
                  this.hwh = System.currentTimeMillis() + 2500L;
                  return;
               }

               this.hwg = null;
               ConfigManager.delete(var3);
               this.hwf.remove(var3);
               var1.toast(
                  wap.s(a.d("害∣꣹㚁뵇㯧膵ࠀ뙣", 147312879, -899970287) + var3 + a.c(612171318, "\ude2a"), a.b("怍ᦫ鍼ആ蚻f븨㝒", 211969062) + var3 + a.b("㨴", 1207188110)),
                  vhz.TRASH,
                  false
               );
         }
      } catch (IOException | RuntimeException var5) {
         var1.toast(wap.s(a.d("ᧁ恗\uea8c瓸Ｆ禖쎛䩰", -141036065, 1725164624), a.d("Ꭱ橆\ue0e5纝\uf541珺춣䑈", -891043748, 258856939)) + var5.getMessage(), vhz.INFO, true);
      }

      this.hwd = -1;
   }

   void hwq(hlc var1, String var2) {
      if (this.hwc == null) {
         this.hwc = var2;
         ConfigShare.share(var2)
            .whenCompleteAsync(
               (var2x, var3) -> {
                  this.hwc = null;
                  this.hwd = -1;
                  if (var3 != null) {
                     var1.toast(ConfigShare.describe(var3), vhz.INFO, true);
                  } else {
                     MinecraftClient.getInstance().keyboard.setClipboard(var2x);
                     var1.toast(
                        wap.s(
                           a.d("颶\ue12b毳\uf583縑\uf8e3䊼쭒唔\udfa9塻ꉔⲙ", 987904556, 1637982932) + var2x,
                           a.d("䌢㪷끮⨋ꖽ⍷餠ა躈с菬禑\uf744滸\ue0ac晇", -1479171144, -584850288) + var2x
                        ),
                        vhz.SHARE,
                        false
                     );
                  }
               },
               MinecraftClient.getInstance()
            );
      }
   }
}
