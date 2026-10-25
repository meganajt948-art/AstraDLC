package a;

import flow.dev.a;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SkinTextures;

final class hyj extends imn {
   private static final float hyk = 26.0F;
   private static final float hyl = 3.0F;
   private static final float hym = 16.0F;
   private static final float hyn = 18.0F;
   static final int HERE = -11870592;
   private final Map<String, hyg> hyo = new HashMap<>();
   private String hyp;
   private long hyq;

   hyj() {
      super(null);
   }

   @Override
   float height() {
      int var1 = hhf.all().size();
      return var1 == 0 ? 58.0F : 2.0F + var1 * 29.0F;
   }

   private float hyt(int var1) {
      return this.y + 2.0F + var1 * 29.0F;
   }

   private float hyu() {
      return this.x + this.w - 6.0F - 18.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = hhf.all();
      if (var6.isEmpty()) {
         this.hyo.clear();
         float var28 = this.x + this.w * 0.5F;
         uut.circle(var1, var28, this.y + 17.0F, 12.0F, iov.hover);
         vjf.draw(var1, vhz.FRIENDS, var28, this.y + 17.0F, 11.0F, iov.textMuted);
         irr.LABEL
            .drawCentered(
               var1,
               wap.s(a.c(1328258349, "鵭\ue4fd湡\uf056箕﴿䝠캚像\uda69巩ꟁ⤊낪"), a.b("핸겝♍롈㎝딠୪蚄ᣚ鉯ᖶ\uebd7愝\uf8a4犀", -59256477)),
               var28,
               irr.LABEL.centerTop(this.y + 38.0F),
               iov.textDim
            );
         irr.SMALL
            .drawCentered(
               var1,
               wap.s(
                  a.d("Ţ磷\uf229汘\ue787愿\udb29力쳋䙿솦㯟땃ⲳꚡ 驓ᖏ輤३肉惘琹\uefa7槅\ue346媴퓠丗젂䏰뵠㝡꺟⣀ꉹ", 1790305760, 1216275691),
                  a.c(-2121429595, "覚\uf010竅\ue088潀\ue9f0垽\uda54䐀컂䥯댚㶴ꁦ⸭\ua8dfና饚߽膦࡞爎ﲿ朐\ue161毇홡尭웟䂌")
               ),
               var28,
               irr.SMALL.centerTop(this.y + 49.0F),
               iov.textMuted
            );
      } else {
         if (this.hyp != null && System.currentTimeMillis() > this.hyq) {
            this.hyp = null;
         }

         MinecraftClient var7 = MinecraftClient.getInstance();
         float var8 = iov.r(6.0F);

         for (int var9 = 0; var9 < var6.size(); var9++) {
            hhc var10 = (hhc)var6.get(var9);
            String var11 = var10.name.toLowerCase(Locale.ROOT);
            hyg var12 = this.hyo.computeIfAbsent(var11, var0 -> new hyg());
            float var13 = this.hyt(var9);
            float var14 = vcq.outCubic(var12.appear.step(1.0F, var5));
            boolean var15 = var2.canHover() && irr.inside(var3, var4, this.x, var13, this.w, 26.0F);
            float var16 = var12.hover.step(var15, var5);
            uut.pushAlpha(var14);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate((1.0F - var14) * 18.0F, 0.0F);
            uut.round(var1, this.x, var13, this.w, 26.0F, var8, ujt.withAlpha(iov.hover, (int)(ujt.alpha(iov.hover) * (0.6F + 1.4F * var16))));
            float var17 = var13 + 13.0F;
            PlayerEntity var18 = hhf.inWorld(var10.name);
            boolean var19 = var18 != null || hhf.listEntry(var10.name) != null;
            face(var1, var10.name, hhf.skinOf(var10.name), this.x + 5.0F, var17 - 8.0F, var19);
            float var20 = this.x + 5.0F + 16.0F + 7.0F;
            float var21 = this.hyu() - var20 - 4.0F;
            irr.CARD_TITLE.draw(var1, irr.CARD_TITLE.ellipsize(var10.name, var21), var20, irr.CARD_TITLE.centerTop(var17 - 4.0F), iov.text);
            String var22;
            int var23;
            if (var18 != null && var7.player != null) {
               double var24 = Math.sqrt(var7.player.squaredDistanceTo(var18));
               var22 = var18 == var7.player
                  ? wap.s(a.b("\uef67雠ᰩ", 189722429), a.d("趂\uf46a", 1976972903, 737656821))
                  : wap.s(a.c(1935009727, "\ue7fe鹢ᒦ諀Œ蟣㴧둁⨞"), a.d("\uf2b1譯Ǉ龼ᑩ雄ⲗꗱ㬹놈", -89447506, -1989290699))
                     + Math.round(var24)
                     + wap.unit(a.d("ᄊ", 784601002, -1815666996));
               var23 = -11870592;
            } else if (var19) {
               var22 = wap.s(a.b("ﵚ蓊ป遯ᮿ鴅", 1460010259), a.d("ɛ翘\uf16a潯\ue4cf戄", 1713360781, 2099300802));
               var23 = ujt.lerp(-11870592, iov.textDim, 0.4F);
            } else {
               var22 = wap.s(a.b("\ue851釁ᬉ蔬ຳ蠏㉋뮭", 1814882327), a.d("뢈섑俗햱幥\ud8d5拲\ueb0e", -1388248135, 1804844836));
               var23 = iov.textMuted;
            }

            uut.circle(var1, var20 + 1.6F, var17 + 5.0F, 1.6F, var23);
            irr.SMALL.draw(var1, var22, var20 + 5.5F, irr.SMALL.centerTop(var17 + 5.0F), var23);
            boolean var29 = var11.equals(this.hyp);
            float var25 = this.hyu() + (1.0F - var16) * 6.0F;
            boolean var26 = var2.canHover() && irr.inside(var3, var4, var25, var17 - 9.0F, 18.0F, 18.0F);
            float var27 = var12.button.step(var26, var5);
            irr.iconButton(var1, vhz.TRASH, var25, var17 - 9.0F, 18.0F, var27, var29, var29 ? 1.0F : var16);
            if (var26 && var16 > 0.5F) {
               var2.hint(
                  var29
                     ? wap.s(
                           a.b("촗뒉㹟ꀤ⯻괁ᜓ黤½訄ැ\uf7ef祬\ue0c6櫚\uec79嘡\ud9f8䍉씁䳥㛱", -1223570110),
                           a.d("荒龜瀛\uee60斳\ue378奜풸仲쐿䏴뷴㝃꺂ⓖ\ua63c᱿韉ൿ譒ʪ碁\uf259淫\uebe3愶\ud88e囜챑䨎엑", 906817708, -1380812804)
                        )
                        + var10.name
                     : wap.s(a.b("緡ѧ躼\u10cf鬁ᶣꞵ⸂끉㫥봴䜈즙值\uda74岉\ue6cd椖\uf3b2", 527072672), a.c(-796968597, "㵙䓿츨偒\udb86嵍\ue710檍\uf0ca穴聆ߕ襶Ⴤ髣ᰐꙓ"))
               );
            }

            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }
      }
   }

   static void face(DrawContext var0, String var1, SkinTextures var2, float var3, float var4, boolean var5) {
      float var6 = Math.min(8.0F, iov.r(4.5F));
      ukf.shadow(var0, var3, var4, 16.0F, 16.0F, var6, 0.5F, iov.lightness());
      boolean var7 = var2 != null && uog.draw(var0, var2, var3, var4, 16.0F, var6, var5 ? -1 : -6645086);
      if (!var7) {
         uut.round(var0, var3, var4, 16.0F, 16.0F, var6, iov.field);
         irr.AVATAR.drawCentered(var0, var1.substring(0, 1).toUpperCase(Locale.ROOT), var3 + 8.0F, irr.AVATAR.centerTop(var4 + 8.0F), iov.textDim);
      }

      uut.outlineGradientV(var0, var3, var4, 16.0F, 16.0F, var6, 1.0F, 889192447, 150994943);
      if (var5) {
         float var8 = 5.0F;
         uut.circle(var0, var3 + 16.0F - 1.0F, var4 + 16.0F - 1.0F, var8 * 0.5F + 1.0F, iov.card | 0xFF000000);
         uut.circle(var0, var3 + 16.0F - 1.0F, var4 + 16.0F - 1.0F, var8 * 0.5F, -11870592);
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      List var5 = hhf.all();

      for (int var6 = 0; var6 < var5.size(); var6++) {
         float var7 = this.hyt(var6);
         if (irr.inside(var2, var3, this.x, var7, this.w, 26.0F)) {
            hhc var8 = (hhc)var5.get(var6);
            String var9 = var8.name.toLowerCase(Locale.ROOT);
            float var10 = var7 + 13.0F;
            if (var4 == 0 && irr.inside(var2, var3, this.hyu(), var10 - 9.0F, 18.0F, 18.0F)) {
               if (!var9.equals(this.hyp)) {
                  this.hyp = var9;
                  this.hyq = System.currentTimeMillis() + 2500L;
               } else {
                  this.hyp = null;
                  String var11 = var8.name;
                  hhf.remove(var11);
                  var1.toast(wap.s(a.b("\uf1d9衟ʄ鳷\u1739醛⯉ꉼ", 657781123), a.b("瑜\u0dfa蜭ᥗ鋪ᐷ꩹", 1427206264)) + var11, vhz.TRASH, false);
               }
            }

            return true;
         }
      }

      return false;
   }
}
