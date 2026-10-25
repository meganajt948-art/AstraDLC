package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

final class iqp extends imn {
   static final float iqq = 54.0F;
   static final float iqr = 6.0F;
   static final float iqs = 27.0F;
   static final float iqt = 10.0F;
   static final float iqu = 13.0F;
   static final String[] iqv = new String[]{
      a.b("䈎㮕녅⼬", -1947778484),
      a.d("零\uef62斢\ufbca", -2137659388, -1690468686),
      a.d("鰖\ue58b潛\uf129竤ﱒ", -737654130, -1916217635),
      a.b("ﰀ薔ཉ鄷\u1afc", 1556610121),
      a.c(-728604230, "懻ᡯ銲ೌ蜇Ǣ뮷㉀걘⛢ꄼ孟했"),
      a.d("赖\uf4d1縄\ue072殾\ued0d", 744460765, 1977556174)
   };
   final int[] iqw;
   final vcj[] iqx;
   final vcj[] iqy;

   iqp() {
      super(iov.PRESET);
      ArrayList var1 = new ArrayList();

      for (String var5 : iqv) {
         if (var5.equals(a.b("\udfe6ꙡⲴ닂㤎뾽", -572334173))) {
            var1.add(-1);
         } else {
            for (int var6 = 0; var6 < iov.PRESETS.length; var6++) {
               if (iov.PRESETS[var6].group().equals(var5)) {
                  var1.add(var6);
               }
            }
         }
      }

      this.iqw = var1.stream().mapToInt(Integer::intValue).toArray();
      this.iqx = new vcj[this.iqw.length];
      this.iqy = new vcj[this.iqw.length];

      for (int var7 = 0; var7 < this.iqw.length; var7++) {
         this.iqx[var7] = new vcj(16.0F);
         this.iqy[var7] = new vcj(14.0F, this.irc(var7).equals(iov.PRESET.get()) ? 1.0F : 0.0F);
      }
   }

   iom irb(int var1) {
      return this.iqw[var1] < 0 ? iov.custom() : iov.PRESETS[this.iqw[var1]];
   }

   String irc(int var1) {
      return this.iqw[var1] < 0 ? a.b("琥ජ蝷ᤁ鋍ᑾ", -86936480) : iov.PRESETS[this.iqw[var1]].name();
   }

   String ird(int var1) {
      return this.iqw[var1] < 0 ? a.d("⠃冄\udb51䔧컫䡘", -42394172, -972999294) : iov.PRESETS[this.iqw[var1]].group();
   }

   static String ire(String var0) {
      if (var0.equals(a.c(1971397428, "⍶嫭퀽乔"))) {
         return wap.s(;
      }
      else if (var0.equals(a.c(720793190, "渦ឲ鵲̚"))) {
         return wap.s(a.d("叺⩮ꂮ㻆", -232653056, -305484614), a.d("瓃ഁ螿\u19cf鉮ᒡ", 301992293, -382043774));
      }
      else if (var0.equals(a.c(-1815015356, "ခ榜\ue34c紾\uf6f3灅"))) {
         return wap.s(a.c(2021305364, "걑헌弜셮䪣찕"), a.d("霌\ueea9摽嗢燓\uf714䴹", 777457442, 1652923407));
      }
      else if (var0.equals(a.c(-424253658, "杯ỻ鐦\u0a58膓"))) {
         return wap.s(a.c(-115605172, "ą碑\uf24c氲\ue7f9"), a.c(655063855, "缉ګ豿ቹ駗\u1f16ꔻ"));
      }
      else if (var0.equals(a.c(933288361, "\ud9e8ꁼ⪡듟㼔맱Τ詓ᑋ黱\u192f\ue34c涛"))) {
         return wap.s(a.b("ㄵ䢡쉼専\ud7c9儬\ueb79抎ﲖ瘬\uf1f2\u0b91蕆", -2110443148), a.c(-41195568, "握ᩃ邗ຑ蔿Ͼ맓㐷깰⃙ꍫ夙ힹ万쑕䊡"));
      }
      else {
         return wap.s(a.c(-2130336089, "ꛢ\udf65喰쯆䀊욹"), a.c(314247318, "ಳ甑ￎ懎"));
      }
   }

   int irf() {
      float var1 = this.w > 0.0F ? this.w : 376.0F;
      return Math.max(3, (int)((var1 + 6.0F) / 60.0F));
   }

   float irg() {
      int var1 = this.irf();
      return (this.w - 6.0F * (var1 - 1)) / var1;
   }

   float irh(float[] var1, float[] var2) {
      int var3 = this.irf();
      float var4 = this.w > 0.0F ? this.irg() : 54.0F;
      float var5 = 1.0F;
      String var6 = null;
      int var7 = 0;

      for (int var8 = 0; var8 < this.iqw.length; var8++) {
         if (!this.ird(var8).equals(var6)) {
            if (var6 != null) {
               var5 += 45.0F;
            }

            var6 = this.ird(var8);
            var5 += 13.0F;
            var7 = 0;
         } else if (var7 == var3) {
            var5 += 43.0F;
            var7 = 0;
         }

         if (var1 != null) {
            var1[var8] = var7 * (var4 + 6.0F);
            var2[var8] = var5;
         }

         var7++;
      }

      return var5 + 27.0F + 10.0F;
   }

   @Override
   float height() {
      return this.irh(null, null);
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float[] var6 = new float[this.iqw.length];
      float[] var7 = new float[this.iqw.length];
      this.irh(var6, var7);
      float var8 = this.irg();
      String var9 = null;

      for (int var10 = 0; var10 < this.iqw.length; var10++) {
         iom var11 = this.irb(var10);
         boolean var12 = this.iqw[var10] < 0;
         float var13 = this.x + var6[var10];
         float var14 = this.y + var7[var10];
         if (!this.ird(var10).equals(var9)) {
            var9 = this.ird(var10);
            irr.SMALL.draw(var1, ire(var9).toUpperCase(Locale.ROOT), this.x, irr.SMALL.centerTop(var14 - 6.5F), iov.textMuted);
         }

         float var15 = this.iqx[var10].step(var2.canHover() && irr.inside(var3, var4, var13, var14, var8, 37.0F), var5);
         float var16 = this.iqy[var10].step(this.irc(var10).equals(iov.PRESET.get()), var5);
         float var17 = var14 - var15;
         float var18 = iov.r(5.0F);
         int[] var19 = var11.accent();
         if (var16 > 0.01F) {
            uut.shadow(var1, var13, var17, var8, 27.0F, var18, 7.0F, iov.accent((int)(70.0F * var16)));
         }

         String var20 = iov.wallpaperOf(var11.name());
         uok var21 = var20 != null ? iri(var20) : null;
         if (var21 != null) {
            uut.image(var1, var21.view, var13, var17, var8, 27.0F, var18, -1);
            uut.round(var1, var13, var17, var8, 27.0F, var18, ujt.withAlpha(var11.color(0), 70));
         } else if (var11.isGlass()) {
            uok var22 = irj();
            if (var22 != null) {
               uut.image(var1, var22.view, var13, var17, var8, 27.0F, var18, -1);
            } else {
               uut.gradient(var1, var13, var17, var8, 27.0F, var18, -10842642, -4160260, -757066, -13058568);
            }

            uut.round(var1, var13, var17, var8, 27.0F, var18, ujt.withAlpha(var11.color(0), Math.round(204.0F * var11.tintScale())));
         } else {
            uut.round(var1, var13, var17, var8, 27.0F, var18, ujt.withAlpha(var11.color(0), 255));
         }

         float var29 = var8 * 0.3F;
         uut.round(var1, var13, var17, var29, 27.0F, var18, 0.0F, 0.0F, var18, var11.color(1));
         uut.round(var1, var13 + 3.0F, var17 + 5.0F, var29 - 6.0F, 4.0F, 1.5F, ujt.withAlpha(var19[0], 200));
         uut.round(var1, var13 + 3.0F, var17 + 11.0F, var29 - 8.0F, 2.5F, 1.2F, ujt.withAlpha(var11.color(10), 160));
         uut.round(var1, var13 + 3.0F, var17 + 16.0F, var29 - 9.0F, 2.5F, 1.2F, ujt.withAlpha(var11.color(10), 160));
         float var23 = var13 + var29 + 3.0F;
         float var24 = (var8 - var29 - 9.0F) * 0.5F;
         int var25 = ujt.withAlpha(var11.color(2), Math.max(60, ujt.alpha(var11.color(2))));
         uut.round(var1, var23, var17 + 5.0F, var24, 17.0F, 2.0F, var25);
         uut.round(var1, var23 + var24 + 3.0F, var17 + 5.0F, var24, 10.200001F, 2.0F, var25);
         uut.round(var1, var23 + 2.5F, var17 + 8.0F, var24 - 5.0F, 2.0F, 1.0F, ujt.withAlpha(var11.color(8), 150));
         uut.gradientH(var1, var23 + var24 - 7.0F, var17 + 12.0F, 5.0F, 3.0F, 1.5F, var19[0], var19[1]);
         uut.outline(var1, var13, var17, var8, 27.0F, var18, 1.0F, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, var15 * 0.5F), iov.accent(), var16));
         if (var12) {
            vjf.draw(var1, vhz.PENCIL, var13 + var8 - 6.0F, var17 + 27.0F - 6.0F, 6.5F, var11.light() ? -1340071896 : -788529153);
         } else if (var11.isGlass()) {
            vjf.draw(var1, vhz.GLASS, var13 + var8 - 6.0F, var17 + 27.0F - 6.0F, 6.5F, var11.light() ? -1340071896 : -788529153);
         }

         if (var15 > 0.5F) {
            var2.hint(
               var12
                  ? wap.s(
                     a.d("⺪圭\uddf8䎎졂仱\uf4ef紞\ue3d6槰\uee23ᐋ髊͡褵ྖ떚㩇ꃷ⚥꽈픞宬쀢䙑쳅畷שׂ懁\ue7c4氣鋮\u18ac腕\u074b足㉣로㻬ꝫⴲ叄\ud98c帿쒥䪀\uf34f秳ﾴ摭", -247795965, 1082507736),
                     a.b("魖\ue2f4栫\uf62b禓Ｂ䗦첀募\udc7c宭ꆤ⼃늪㲟먚R迴ᔵ靸ẃ惎\uee74疭\uf3a0祰샏亝푤噚\ud9fb⌸ꧼ㒇닇㡺蟜ূ譳ኵ飣\ue61e棆", 1866243932)
                  )
                  : (
                     var20 != null
                        ? iov.shownName(var11.name())
                           + wap.s(
                              a.d("㷉䑸츼僚\udb0d巫\ue7a6湊\uf009竰ﵷܚ觀ဴ騦᳘Ꚑ⥅돺㖾뱘예䣿퍈唝\udfcf晤\ue862狙\uf48b缰臩௩鉚ᐎ麲Ⅴꬒⷋ됾㸵䃘쪆䵲ퟲ妝\ue049櫲\uecb6睿", 1520162173, 1903290534),
                              a.c(-202789497, "궃퐲并삐䭇즗瞥既搓\ueea8椂錄\u19cf葥ำ裏㊍봠⟩ꆿ⡉刚\ud8b5䌂앗侅\uf62e砨\ue6c8悞\uef3dᗲ龹ُ耟બ")
                           )
                        : iov.shownName(var11.name())
                           + (
                              var11.isGlass()
                                 ? wap.s(
                                    a.c(-727182446, "\u139f樮\ue06a續\uf55b玭짵䀉\ude44哵퍵⥐ꞛ㸧둼㊅袕ݞ鶹\u1bf4鈎\ue81a曾ﴹ筋\uf19a䠵왵岓\udad7关꿰◬밆㩒냻༨蔊\u038d騠ၥ溉\ue4c0捣僚"),
                                    a.c(-1793822763, "濒ᙣ鰧ˁ褖ெ놖㠐Ꙁ⳰ꭗ兔\udf83䘿찓亍\uf0a0缆\ue5bc握\uee1c鑗Ỻ蔤͔覃㐨빦⓮ꋁ⤍\ud7af巧쑤䉈죳眦ﴩ篶")
                                 )
                                 : ""
                           )
                  )
            );
         }

         if (var16 > 0.02F) {
            float var26 = var13 + var8 - 5.5F;
            float var27 = var17 + 5.5F;
            float var28 = vcq.outBack(var16);
            uut.pushAlpha(var16);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(var26, var27);
            var1.getMatrices().scale(var28, var28);
            uut.circle(var1, 0.0F, 0.0F, 3.8F, iov.accent());
            vjf.draw(var1, vhz.CHECK, 0.0F, 0.0F, 5.5F, iov.onAccent());
            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }

         irr.SMALL
            .drawCentered(
               var1,
               irr.SMALL.ellipsize(iov.shownName(this.irc(var10)), var8),
               var13 + var8 * 0.5F,
               irr.SMALL.centerTop(var14 + 27.0F + 5.0F + 1.0F),
               ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, var15), iov.text, var16)
            );
      }
   }

   static uok iri(String var0) {
      isn var1 = isv.find(var0);
      return var1 == null ? null : isv.thumbnail(var1);
   }

   static uok irj() {
      isn var0 = isv.find(isv.selected());
      return var0 != null && !var0.isWorld() ? isv.thumbnail(var0) : null;
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return false;
      }

      float[] var5 = new float[this.iqw.length];
      float[] var6 = new float[this.iqw.length];
      this.irh(var5, var6);
      float var7 = this.irg();

      for (int var8 = 0; var8 < this.iqw.length; var8++) {
         if (irr.inside(var2, var3, this.x + var5[var8], this.y + var6[var8], var7, 37.0F)) {
            iov.choose(this.irc(var8));
            return true;
         }
      }

      return false;
   }
}
