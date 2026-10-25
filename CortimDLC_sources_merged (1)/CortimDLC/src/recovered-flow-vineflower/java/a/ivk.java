package a;

import flow.dev.a;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class ivk extends imn {
   static final float ivl = 30.0F;
   static final float ivm = 3.0F;
   static final float ivn = 18.0F;
   final iui ivo;
   final Map<wkq, ivh> ivp = new IdentityHashMap<>();
   wkq ivq;
   long ivr;

   ivk(iui var1) {
      super(null);
      this.ivo = var1;
   }

   @Override
   float height() {
      int var1 = wlk.inWorld().size();
      return var1 == 0 ? 58.0F : 2.0F + var1 * 33.0F;
   }

   float ivu(int var1) {
      return this.y + 2.0F + var1 * 33.0F;
   }

   float ivv(int var1) {
      return this.x + this.w - 6.0F - (3 - var1) * 21.0F + 3.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = wlk.inWorld();
      this.ivp.keySet().retainAll(var6);
      if (var6.isEmpty()) {
         float var33 = this.x + this.w * 0.5F;
         uut.circle(var1, var33, this.y + 17.0F, 12.0F, iov.hover);
         vjf.draw(var1, vhz.PIN, var33, this.y + 17.0F, 11.0F, iov.textMuted);
         irr.LABEL
            .drawCentered(
               var1,
               wap.s(a.b("\udf20ꚰⰬ눊㧋뽢Ը賖\u128f頹\u1ff0\ue586欂\uf2ea碥﹅", -823861378), a.b("㇡䡹식峐휃喨\uebe4戔ﱏ直\uf537\u0b5b薄᱂", -1351862797)),
               var33,
               irr.LABEL.centerTop(this.y + 38.0F),
               iov.textDim
            );
         irr.SMALL
            .drawCentered(
               var1,
               wap.s(
                  a.d("ࣉ煝ﮎ斻\uee23梓틋孿앷俘젖㉻볤━꽎⦲鎸ᰯ蚕Ù褱\uf32d緑\ue601怰\ueab5匚\udd46䟴쇩䩓뒁㻜", 1899867577, -188635888),
                  a.b("説\uf337秫\ue79b汎\uea81僜\ud95a䌐췆䩧끣㻁ꝲ⤶ꮣᆖ鸹Ӷ苘ཌ煼ﾵ摪\ue212棁", -1888842078)
               ),
               var33,
               irr.SMALL.centerTop(this.y + 49.0F),
               iov.textMuted
            );
      } else {
         if (this.ivq != null && System.currentTimeMillis() > this.ivr) {
            this.ivq = null;
         }

         MinecraftClient var7 = MinecraftClient.getInstance();
         String var8 = wlk.dimensionId();
         float var9 = iov.r(6.0F);

         for (int var10 = 0; var10 < var6.size(); var10++) {
            wkq var11 = (wkq)var6.get(var10);
            ivh var12 = this.ivp.computeIfAbsent(var11, var0 -> new ivh());
            float var13 = this.ivu(var10);
            float var14 = vcq.outCubic(var12.appear.step(1.0F, var5));
            boolean var15 = var2.canHover() && irr.inside(var3, var4, this.x, var13, this.w, 30.0F);
            float var16 = var12.hover.step(var15, var5);
            float var17 = var12.shown.step(var11.visible, var5);
            int var18 = wlk.colorOf(var11);
            uut.pushAlpha(var14 * (0.5F + 0.5F * var17));
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate((1.0F - var14) * 18.0F, 0.0F);
            uut.round(var1, this.x, var13, this.w, 30.0F, var9, ujt.withAlpha(iov.hover, (int)(ujt.alpha(iov.hover) * (0.6F + 1.4F * var16))));
            float var19 = var13 + 15.0F;
            wkw.pin(var1, this.x + 12.0F, var19 - 0.8F * var16, 15.0F, var18, 0.5F + 0.5F * var16);
            float var20 = this.x + 24.0F;
            float var21 = this.ivv(0) - var20 - 6.0F;
            irr.CARD_TITLE.draw(var1, irr.CARD_TITLE.ellipsize(var11.name, var21), var20, irr.CARD_TITLE.centerTop(var19 - 4.5F), iov.text);
            String var22 = (int)Math.floor(var11.x)
               + a.b("\uf4c0赱", 738063586)
               + (int)Math.floor(var11.y)
               + a.d("뛕콤", 2006775910, 1945194129)
               + (int)Math.floor(var11.z);
            boolean var23 = var8 != null && var8.equals(var11.dimension);
            if (!var23) {
               var22 = var22 + a.c(813644720, "㮕䈤졠嚆\udd51") + wlk.dimensionName(var11.dimension);
            }

            irr.SMALL.draw(var1, irr.SMALL.ellipsize(var22, var21), var20, irr.SMALL.centerTop(var19 + 5.5F), iov.textMuted);
            wkq var24 = var23 ? var11 : wlk.here(var11);
            if (var16 < 0.99F && var24 != null && var7.player != null) {
               double var25 = Math.sqrt(var7.player.squaredDistanceTo(var24.cx(), var24.cy(), var24.cz()));
               uut.pushAlpha(1.0F - var16);
               irr.drawChip(
                  var1,
                  wkw.formatDistance(var25),
                  this.x + this.w - 6.0F + var16 * 6.0F,
                  var19,
                  ujt.lerp(var18, iov.text, 0.5F),
                  ujt.withAlpha(var18, 90),
                  0.0F
               );
               uut.popAlpha();
            }

            vhz[] var34 = new vhz[]{var11.visible ? vhz.RENDER : vhz.EYE_OFF, vhz.PENCIL, vhz.TRASH};
            String[] var26 = new String[]{
               var11.visible
                  ? wap.s(a.c(996516290, "ꆙ\ud809勗첧䜵쇂箅\uf269水\ue6c8慏鬢ᗸ谌؈胡㪳땼⿇"), a.b("ᘽ澗\ue53e筄\uf09a瘥젚䗹\udfb4儙훎ⳇꉥ", 1688015377))
                  : wap.s(a.c(1212135405, "랯츥䓱\uda98儘ퟠ涴\ue40b稀\uf0ad睳赇χ驮ဠ雏Ⲉ"), a.b("꾪혺峭슖䥆쿰痑ﰮ昝\ue8be歿锒ᯁ興\u082e", 1342090170)),
               wap.s(a.c(-1421312624, "緅ѕ躋ყ魤ᶜꟈ\u2e77끼㫑봏䜻즪倒\uda5c岲"), a.c(-546415474, "墆℘ꯀ㖸빧㣓苺ଅ鄶ᾕ鱔扁\uecec産，秴")),
               wap.s(
                  a.c(-1456040334, "阩\uefb9散\ufb1b烝\uf67d䱫얒宆털囮겕≊뮰ㆢ띕ജ苅ᡱ鹮៍涇\ue37b磩ﺚ瑊췱䎯\ud943弍퓺"),
                  a.c(-2070238671, "긹힟嵈쌲䣦츭瑰吝枺\ue91e滀钷ᩪ菟৶轰ㄪ뫮‡Ꙩ⯮嗟\udb1c䃊슢䱧\uf5db篾\ue566木\uec9aቁ顸ǹ螭൩니㢻빩⟐궊파崹")
               )
            };

            for (int var27 = 0; var27 < 3; var27++) {
               float var28 = this.ivv(var27) + (1.0F - var16) * 6.0F;
               float var29 = var19 - 9.0F;
               boolean var30 = var2.canHover() && irr.inside(var3, var4, var28, var29, 18.0F, 18.0F);
               float var31 = var12.buttons[var27].step(var30, var5);
               boolean var32 = var27 == 2 && var11 == this.ivq;
               irr.iconButton(var1, var34[var27], var28, var29, 18.0F, var31, var32, var32 ? 1.0F : var16);
               if (var30 && var16 > 0.5F) {
                  var2.hint(
                     var32
                        ? wap.s(
                           a.b("\ud9c3ꁝ⪋듰㼯맕χ訰ᑩ黐ᤄ\ue33b涸\uf412縎\uf8bb䋵촭垗퇗報∥貪", -1241327209) + var11.name + a.c(533813574, "祚"),
                           a.d("잰븬㓹ꪂ⅑Ꞛᶾ遚ਐ胝ܖ烙玡\uea60怴\ue2de墝팫䦝쾰䙈㱣뚻⤉꼁◔鱬ሾ袳\u0eec脳罩", 1614911967, 1155881554) + var11.name + a.d("ઢ", -1919796334, -760401526)
                        )
                        : var26[var27]
                  );
               }
            }

            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      List var5 = wlk.inWorld();

      for (int var6 = 0; var6 < var5.size(); var6++) {
         float var7 = this.ivu(var6);
         if (irr.inside(var2, var3, this.x, var7, this.w, 30.0F)) {
            wkq var8 = (wkq)var5.get(var6);
            float var9 = var7 + 15.0F;

            for (int var10 = 0; var10 < 3; var10++) {
               if (var4 == 0 && irr.inside(var2, var3, this.ivv(var10), var9 - 9.0F, 18.0F, 18.0F)) {
                  switch (var10) {
                     case 0:
                        var8.visible = !var8.visible;
                        wlk.changed();
                        break;
                     case 1:
                        this.ivo.edit(var8);
                        break;
                     default:
                        if (var8 != this.ivq) {
                           this.ivq = var8;
                           this.ivr = System.currentTimeMillis() + 2500L;
                        } else {
                           this.ivq = null;
                           wlk.remove(var8);
                           var1.toast(
                              wap.s(
                                 a.d("ݼ绬\uf436橎\ue188木\udd7a哏\ueaac", -1332382556, -163220587) + var8.name + a.c(-28143291, "녙"),
                                 a.c(981076501, "฿瞙﵎挴\ue8ed湔퐊姫윿") + var8.name + a.d("匛", 409985954, 1701818371)
                              ),
                              vhz.TRASH,
                              false
                           );
                        }
                  }

                  return true;
               }
            }

            if (var4 == 0) {
               this.ivo.edit(var8);
            }

            return true;
         }
      }

      return false;
   }
}
