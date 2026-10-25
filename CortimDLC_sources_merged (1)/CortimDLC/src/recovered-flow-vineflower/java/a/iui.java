package a;

import flow.dev.a;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class iui extends imn {
   private static final float iuj = 17.0F;
   private static final float iuk = 11.0F;
   final iah name = new iah(a.b("ᒃ洝\ue7c2离\uf229璐캄䝪\ud931厝푈⸸ꃠ㥜덊", -219343678), vhz.PIN, 24, iah.ANY);
   final iah fx = new iah("", null, 10, iah.NUMBER);
   final iah fy = new iah("", null, 10, iah.NUMBER);
   final iah fz = new iah("", null, 10, iah.NUMBER);
   private int iul;
   private boolean ium;
   private wkq iun;
   private hlc iuo;
   private final vcj[] iup = new vcj[wlk.COLORS.length];
   private final vcj[] iuq = new vcj[wlk.COLORS.length];
   private final vcj iur = new vcj(16.0F);
   private final vcj ius = new vcj(9.0F);
   private final vcj iut = new vcj(16.0F);
   private final vcj iuu = new vcj(9.0F);
   private final vcj iuv = new vcj(16.0F);
   private final vcj iuw = new vcj(12.0F);

   iui() {
      super(null);
      this.fx.prefix = a.c(-684341383, "유");
      this.fy.prefix = a.b("㧩", -340182607);
      this.fz.prefix = a.b("⇾", -1536941659);
      this.name.next = this.fx;
      this.fx.next = this.fy;
      this.fy.next = this.fz;
      this.fz.next = this.name;
      Runnable var1 = this::ivg;
      this.name.onSubmit = var1;
      this.fx.onSubmit = var1;
      this.fy.onSubmit = var1;
      this.fz.onSubmit = var1;

      for (int var2 = 0; var2 < this.iup.length; var2++) {
         this.iup[var2] = new vcj(16.0F);
         this.iuq[var2] = new vcj(14.0F, var2 == 0 ? 1.0F : 0.0F);
      }
   }

   @Override
   float height() {
      return 91.0F;
   }

   private float iuz(int var1) {
      return switch (var1) {
         case 0 -> this.y + 4.0F;
         case 1 -> this.y + 4.0F + 17.0F + 6.0F;
         case 2 -> this.y + 4.0F + 46.0F + 2.0F;
         default -> this.y + 4.0F + 46.0F + 2.0F + 11.0F + 8.0F;
      };
   }

   private float iva(int var1) {
      int var2 = wlk.COLORS.length;
      float var3 = (this.w - 11.0F * var2) / (var2 - 1);
      return this.x + var1 * (11.0F + var3);
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.iuo = var2;
      if (this.iun != null && !wlk.inWorld().contains(this.iun)) {
         this.ivc();
      }

      float var6 = this.iuw.step(this.iun != null, var5);
      this.name.x = this.x;
      this.name.y = this.iuz(0);
      this.name.w = this.w;
      this.name.h = 17.0F;
      this.name.render(var1, var2, var3, var4, var5);
      float var7 = (this.w - 10.0F) / 3.0F;
      iah[] var8 = new iah[]{this.fx, this.fy, this.fz};

      for (int var9 = 0; var9 < 3; var9++) {
         iah var10 = var8[var9];
         var10.x = this.x + var9 * (var7 + 5.0F);
         var10.y = this.iuz(1);
         var10.w = var7;
         var10.h = 17.0F;
         var10.render(var1, var2, var3, var4, var5);
      }

      float var20 = this.iuz(2);
      boolean var21 = !wlk.COLOR.is(a.c(-1898549601, "滎ᝃ鶝Ϥ蠻")) || this.ium || this.iun != null && this.iun.ownColor;
      uut.pushAlpha(var21 ? 1.0F : 0.65F);

      for (int var11 = 0; var11 < wlk.COLORS.length; var11++) {
         float var12 = this.iva(var11);
         float var13 = this.iup[var11].step(var2.canHover() && irr.inside(var3, var4, var12 - 2.0F, var20 - 2.0F, 15.0F, 15.0F), var5);
         float var14 = this.iuq[var11].step(var11 == this.iul, var5);
         int var15 = wlk.COLORS[var11];
         float var16 = var12 + 5.5F;
         float var17 = var20 + 5.5F;
         if (var14 > 0.01F) {
            uut.circleOutline(var1, var16, var17, 7.5F, 1.2F, ujt.mulAlpha(iov.text, var14));
         }

         float var18 = 3.5F * (0.9F + 0.1F * var13 + 0.08F * vcq.outBack(var14));
         wkw.bead(var1, var16, var17 - 0.5F * var13, var18, var15);
         if (var13 > 0.5F && !var21) {
            var2.hint(
               wap.s(
                  a.c(-331442271, "韊\uee42撛\ufae2煾\uf78e䶜쐮婽탏土굴⎤멇げ뚪\u0cf8荻ᦜ鿑ᘧ汬\ue28c礍ｫ疽챀䈙\ud8a3廻핗⮐ꆚ㠢빬㒉謊Ů螷Ḉ鑁\ueae3惤\ue749經\uf3a7䨠삍䛏\udd16卭꧹\u200fꙜ㲯닸ौ辇֩"),
                  a.d("笔˼衕ᘠ鶂ᭋꅢ⣤늮㱹믞䆨켈勛\udc9c婢\ue059毧\uf539獧\ufaec肺ਐ闝Ꭻ餍\u20c6꺕ぺ똣㦀읔䴖풐励\udc15柜\uedae歰\uf6d1碟٪豌௬鄨ᬻ\ua6f8ⱃꩰ㇒뾩䔇죒䫡큥帽\ue5f5杆", -1889198289, -1373741037)
               )
            );
         }
      }

      uut.popAlpha();
      float var22 = this.iuz(3);
      float var23 = 58.0F;
      float var24 = 58.0F * var6;
      float var25 = this.w - var23 - 6.0F - (var24 > 0.5F ? var24 + 6.0F * var6 : 0.0F);
      float var26 = this.iur.step(var2.canHover() && irr.inside(var3, var4, this.x, var22, var23, 17.0F), var5);
      irr.secondaryButton(
         var1,
         wap.s(a.d("엨뱴㚰꣖", 1061097762, 2053231750), a.d("焊࢘艊ᱏ鞕", 1015722123, 617661843)),
         vhz.LOCATE,
         this.x,
         var22,
         var23,
         17.0F,
         var26,
         this.ius.step(0.0F, var5)
      );
      if (var26 > 0.5F) {
         var2.hint(
            wap.s(
               a.c(417614327, "䦔《뫜⒭꼶⧎鎚ᨥ萮\u0e83襝獩﷼摃\uee13森튩崳쟙䆞졳뉷㲅ꝇℯꮻቛ鰍ۯ肱ଈ\uf5d4羜\ue664恰\uea8e啘"),
               a.d("뙆쿖䔏\udb0b僟혜汍\ue5b6箓\uf12c犓賳Ȯ鮚ᇍ錪⥩ꊥ㠛멚㞷䷢쌭墀\ude81吮\ued9f柒路缟\uf0c7\u0a77耻ᦶ鿣ᔨꪈ", 1271810357, -1402537143)
            )
         );
      }

      float var27 = this.x + var23 + 6.0F;
      float var28 = this.iut.step(var2.canHover() && irr.inside(var3, var4, var27, var22, var25, 17.0F), var5);
      irr.primaryButton(
         var1,
         this.iun != null
            ? wap.s(a.c(-1640862377, "洄ᒐ鹗#诡ു"), a.b("ĳ碭\uf272氀\ue7db慠\udb49劶", -1303378651))
            : wap.s(a.d("媬⌸ꧫ㟞뱞㫹育ॊ霊ᶽ驩怂", -1069881591, 36355560), a.b("讄\uf21f磃\ue6b3浦\uebdd凴\ud80b䈸첕䭏녉㿦\ua62e", -1933340770)),
         this.iun != null ? vhz.SAVE : vhz.PLUS,
         var27,
         var22,
         var25,
         17.0F,
         var28,
         this.iuu.step(0.0F, var5)
      );
      if (var24 > 0.5F) {
         float var29 = var27 + var25 + 6.0F;
         float var19 = this.iuv.step(var2.canHover() && irr.inside(var3, var4, var29, var22, var24, 17.0F), var5);
         uut.pushAlpha(var6);
         irr.secondaryButton(
            var1, var6 > 0.8F ? wap.s(a.c(-1257979527, "센뢯㉳갏⟞ꅦ"), a.b("Ꮃ橞\ue0f3纋\uf554珨", -209905749)) : "", vhz.CLOSE, var29, var22, var24, 17.0F, var19, 0.0F
         );
         uut.popAlpha();
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      this.iuo = var1;

      for (iah var8 : new iah[]{this.name, this.fx, this.fy, this.fz}) {
         if (var8.mouseClicked(var1, var2, var3, var4)) {
            return true;
         }
      }

      if (var4 != 0) {
         return false;
      } else {
         float var11 = this.iuz(2);

         for (int var12 = 0; var12 < wlk.COLORS.length; var12++) {
            if (irr.inside(var2, var3, this.iva(var12) - 2.0F, var11 - 2.0F, 15.0F, 15.0F)) {
               this.iul = var12;
               this.ium = true;
               if (this.iun != null) {
                  this.iun.color = wlk.COLORS[var12];
                  this.iun.ownColor = true;
                  wlk.changed();
               }

               return true;
            }
         }

         float var13 = this.iuz(3);
         float var14 = 58.0F;
         if (irr.inside(var2, var3, this.x, var13, var14, 17.0F)) {
            this.ius.set(1.0F);
            this.ivb();
            return true;
         } else {
            float var15 = this.iun != null ? 58.0F : 0.0F;
            float var9 = this.w - var14 - 6.0F - (var15 > 0.0F ? var15 + 6.0F : 0.0F);
            float var10 = this.x + var14 + 6.0F;
            if (irr.inside(var2, var3, var10, var13, var9, 17.0F)) {
               this.iuu.set(1.0F);
               this.ivg();
               return true;
            } else if (this.iun != null && irr.inside(var2, var3, var10 + var9 + 6.0F, var13, var15, 17.0F)) {
               this.ivc();
               return true;
            } else {
               return false;
            }
         }
      }
   }

   private void ivb() {
      MinecraftClient var1 = MinecraftClient.method_1551();
      if (var1.field_1724 != null) {
         this.fx.setText(String.valueOf(var1.field_1724.method_31477()));
         this.fy.setText(String.valueOf(var1.field_1724.method_31478()));
         this.fz.setText(String.valueOf(var1.field_1724.method_31479()));
      }
   }

   void edit(wkq var1) {
      this.iun = var1;
      this.ium = false;
      this.name.setText(var1.name);
      this.fx.setText(ive(var1.x));
      this.fy.setText(ive(var1.y));
      this.fz.setText(ive(var1.z));
      this.iul = 0;

      for (int var2 = 0; var2 < wlk.COLORS.length; var2++) {
         if ((wlk.COLORS[var2] & 16777215) == (var1.color & 16777215)) {
            this.iul = var2;
         }
      }

      if (this.iuo != null) {
         this.iuo.focus(this.name);
      }
   }

   private void ivc() {
      this.iun = null;
      this.ivd();
   }

   private void ivd() {
      this.ium = false;
      this.name.setText("");
      this.fx.setText("");
      this.fy.setText("");
      this.fz.setText("");
   }

   private static String ive(double var0) {
      return var0 == Math.floor(var0) ? String.valueOf((long)var0) : String.format(Locale.ROOT, a.b("햜갦⛪료", -1164192323), var0);
   }

   private static Double ivf(iah var0) {
      try {
         return var0.text.isBlank() ? null : Double.parseDouble(var0.text.trim());
      } catch (NumberFormatException var2) {
         return null;
      }
   }

   private void ivg() {
      Double var1 = ivf(this.fx);
      Double var2 = ivf(this.fy);
      Double var3 = ivf(this.fz);
      if (var1 != null && var2 != null && var3 != null) {
         String var8 = this.name.text.isBlank()
            ? wap.s(a.c(2130249442, "ڼ缻\uf5f0殈\ue040曷\udca3啈쭃"), a.c(516299036, "ᴆ撞\uee3a瀳ﯮ祏")) + (wlk.inWorld().size() + 1)
            : this.name.text.trim();
         if (this.iun != null) {
            this.iun.name = var8;
            this.iun.x = var1;
            this.iun.y = var2;
            this.iun.z = var3;
            this.iun.color = wlk.COLORS[this.iul];
            this.iun.ownColor = this.iun.ownColor | this.ium;
            wlk.changed();
            this.iun = null;
            if (this.iuo != null) {
               this.iuo
                  .toast(
                     wap.s(a.b("殬ሸ飿ڋ赉௩놻㠎虭", 161442800) + var8 + a.b("ቔ", 193016392), a.c(310255122, "ᨇ掙\ue946眴ﳯ穗쀊䧳힡夀\ude58") + var8 + a.c(1117824997, "ꝟ")),
                     vhz.SAVE,
                     false
                  );
            }
         } else {
            wkq var9 = wlk.add(var8, var1, var2, var3, wlk.COLORS[this.iul]);
            if (this.ium) {
               var9.ownColor = true;
               wlk.changed();
            }

            this.iul = (this.iul + 1) % wlk.COLORS.length;
            if (this.iuo != null) {
               this.iuo
                  .toast(
                     wap.s(a.b("\udad4ꍀ⦓럣㰵뫀₯", 774494866) + var8 + a.b("峵", -1137541911), a.b("\uf521貺٦頖Ꮓ镻⼦ꛟ㢍똬ㅴ", 87224638) + var8 + a.c(421855600, "Ǌ")),
                     vhz.PIN,
                     false
                  );
            }
         }

         this.ivd();
         if (this.iuo != null) {
            this.iuo.focus(null);
         }
      } else {
         for (iah var7 : new iah[]{this.fx, this.fy, this.fz}) {
            if (ivf(var7) == null) {
               var7.error();
            }
         }

         if (this.iuo != null) {
            this.iuo
               .toast(
                  wap.s(
                     a.d("㧑䁋쪂哢\udf22姁\ue3ea橯\uf43c维丹ͮ趶ᐍ鸚ᢑꊨ\u2d75랉㇅론쉡䳐휖兿\udbae扎\uec77皭\uf0eb筏", -540216753, 1248578500),
                     a.d("⑫巺휮䥞슅䑎﹪玎\ueda9杬\ue0b3᪻鐕়蟷ż뭉むꨰⱢꆍ\udfc1兿쪨䳝예翁\uf1e7漅\ue9df曐頢ቬ诩භ菱", -123964942, -814853713)
                  ),
                  vhz.LOCATE,
                  true
               );
         }
      }
   }
}
