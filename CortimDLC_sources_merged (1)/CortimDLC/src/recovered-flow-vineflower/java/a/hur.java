package a;

import flow.config.ConfigManager;
import flow.dev.a;
import java.io.IOException;
import net.minecraft.client.gui.DrawContext;

final class hur extends imn {
   static final float hus = 26.0F;
   static final float hut = 78.0F;
   final iah name = new iah(a.d("ℹ墤퉶䰏쟗䅨ﭼ狃\uec93昮\ue1f5", -557382057, -1569708250), vhz.LAYERS, 32, iah.ANY);
   final vcj huu = new vcj(16.0F);
   final vcj huv = new vcj(9.0F);
   hlc huw;

   hur() {
      super(null);
      this.name.onSubmit = this::save;
   }

   @Override
   float height() {
      return 26.0F;
   }

   float huz() {
      return 17.0F;
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.huw = var2;
      float var6 = this.y + (26.0F - this.huz()) * 0.5F;
      this.name.x = this.x;
      this.name.y = var6;
      this.name.w = this.w - 78.0F - 6.0F;
      this.name.h = this.huz();
      this.name.render(var1, var2, var3, var4, var5);
      float var7 = this.x + this.w - 78.0F;
      float var8 = this.huu.step(var2.canHover() && irr.inside(var3, var4, var7, var6, 78.0F, this.huz()), var5);
      float var9 = this.huv.step(0.0F, var5);
      String var10 = ConfigManager.sanitize(this.name.text);
      boolean var11 = var10 != null && ConfigManager.exists(var10);
      irr.primaryButton(
         var1,
         var11
            ? wap.s(a.c(1450705198, "Ũ磠\uf220汆\ue794愠\udb68劄쳊"), a.c(1116761841, "櫢፹駟ߛ谎સ냤㤒Ꜵⷴ꩕倪"))
            : wap.s(a.c(-236959030, "䪝㌞맚➸"), a.d("ꄃ\ud8ad刅챱䟖셪笼\uf2b7泦", 1350841337, 155162322)),
         vhz.SAVE,
         var7,
         var6,
         78.0F,
         this.huz(),
         var8,
         var9
      );
      if (var8 > 0.5F) {
         var2.hint(
            var11
               ? wap.s(
                  a.c(412155592, "ﺓ蜕ී鎾ᡤ黗⒂괶ፕ") + var10 + a.d("㍧櫫\ue06f縀\uf5ca獧쥼䃙\ude9a否펰⦂ꝃ㻵뒦㉀蠄ߏ鴨ᬪ鋋\ue88b昸ﷴ箌\uf154䣳", 231434180, -1767541595),
                  a.b("હ猯藺枈\uec57櫣탊夵쌆䤼", -39776604) + var10 + a.b("쿈뛢㡓ꙕⶍꭅᄜ颜ۇ豲ྐྵ\uf1d5缏\ue6cf沟\uea6c偝\udf8b䔻썠䪛ノ", -1546334363)
               )
               : wap.s(
                  a.c(666432652, "\uf4ff赼\u07b8駚ቈ钴⻥ꜟ㥑돹㐣칄䃌\ud971危햖濈\ue019窷ﳡ生ཚ膺ᨪ鱚ᚁ꽶Ⅵ뮙㷏뙶䢰"),
                  a.c(-998943165, "剁⯯ꅇ㼳뒔㈨衾ǵ龤ᅹ銶棅\ue618翞\uf5f5猇최䊁\udc2f婳폵ꦧ✖벹㫁뀓ঢ菫ᴄ齍ჯ\uee37摽ﶅ箩")
               )
         );
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      this.huw = var1;
      if (this.name.mouseClicked(var1, var2, var3, var4)) {
         return true;
      } else {
         float var5 = this.y + (26.0F - this.huz()) * 0.5F;
         if (var4 == 0 && irr.inside(var2, var3, this.x + this.w - 78.0F, var5, 78.0F, this.huz())) {
            this.huv.set(1.0F);
            this.save();
            return true;
         } else {
            return false;
         }
      }
   }

   void save() {
      String var1 = ConfigManager.sanitize(this.name.text);
      if (var1 == null) {
         this.name.error();
         if (this.huw != null) {
            this.huw
               .toast(
                  wap.s(
                     a.d("㯕䉉좓囷\udd65宕\ue187核\uf668糕\ufb0eĺ辫ᘓ鱝\u1afeꃥ⼨떖㎂먶쁫仙픀印\ud9af恛\uee4c璴\uf2fe祌螚", 1713511806, 944907999),
                     a.b("㔾䲓왍塋폫啑\uef09拨\uf8a5爔\uf5c0ྰ腫ᢠ銄ၠ긷⇢묢㤜등캤䀔\udbbc嶿흥滕", 1609052420)
                  ),
                  vhz.INFO,
                  true
               );
         }
      } else {
         try {
            ConfigManager.save(var1);
            this.name.setText(var1);
            if (this.huw != null) {
               this.huw.focus(null);
               this.huw
                  .toast(
                     wap.s(
                        a.c(-1487859390, "ᄖ梕\ue251簳\uf7e5焐\ueb7f") + var1 + a.c(-2144138099, "ⲑ"),
                        a.d("\ue89d鄳ᮛ藯่裴㊯뭖┊ꮥ⳽", 1002002394, 772848493) + var1 + a.c(1680293644, "㾶")
                     ),
                     vhz.SAVE,
                     false
                  );
            }
         } catch (IOException var3) {
            if (this.huw != null) {
               this.huw
                  .toast(
                     wap.s(a.b("鷭\ue47e溢\uf09a笞ﷻ䟻츘偐\udaf2嵾꜕", 5414306), a.d("\udd1eꒇ⩁끓㯳뵆ܞ軪\u10ca驶ᧉ\ue7d9楱\uf0bb竭ﱬ䘮짺匳핬壭⊦", 11489627, -1528919986))
                        + var3.getMessage(),
                     vhz.INFO,
                     true
                  );
            }
         }
      }
   }
}
