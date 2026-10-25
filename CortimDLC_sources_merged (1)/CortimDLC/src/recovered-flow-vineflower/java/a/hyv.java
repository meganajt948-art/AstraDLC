package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import org.jspecify.annotations.Nullable;

public final class hyv {
   public static final vkl ENABLED = new vkl(a.c(740963259, "㏻䩯삤廑픚厦\ue9b1性\ufe53瓯\uf32eय़"), false);
   public static final vlv STYLE = new vlv(
      a.b("굆퓐帎쁪䮴", 432778512),
      a.d("雅\uef51斚ﯯ瀤\uf698", -1451792942, 1049490269),
      a.b("Ꮢ橆\ue08d绸\uf533玏", 69342104),
      a.d("㢸䄽쯳喞\ude4e壮\ue2bc", -262934813, 901305882)
   );
   public static final vmc FROST = new vmc(a.c(-1870044846, "愑ᢔ鉚ష蟧"), 2.0, 0.0, 6.0, 1.0);
   public static final vmc REFRACTION = new vmc(a.b("嶜␚껊ク뭫㷘螜\u0e70逩᪙", -1340187196), 0.7, 0.0, 1.0, 0.01).percent();
   public static final vmc EDGE = new vmc(a.d("騮\ue3be楮\uf71d", 406602611, -1915823844), 12.0, 2.0, 30.0, 1.0).unit(a.b("\ue068駑", 1718542362));
   public static final vmc DISPERSION = new vmc(a.b("䨪㎶륿✍곏⩩逻᧐螉ഹ", 1609910884), 0.4, 0.0, 1.0, 0.01).percent();
   public static final vmc HIGHLIGHT = new vmc(a.b("䢪ㄺ믧▙깊⣾銣᭝蔞", -134788885), 0.7, 0.0, 1.0, 0.01).percent();
   public static final vmc LIGHT = new vmc(a.c(-285835731, "繪߾责፝颖ṳꑡ\u2d9f돉㥳뺩"), 225.0, 0.0, 355.0, 5.0).unit(a.d("\ue86b", -1112090618, 1348153564));
   public static final vmc VIBRANCY = new vmc(a.c(-1330512706, "ﳠ蕮ྶ釗ᨓ鲭⛳꼘"), 1.15, 0.0, 2.0, 0.05).percent();
   public static final vmc TINT = new vmc(a.b("壓⅟ꮋ㗠", 419846275), 0.8, 0.1, 1.0, 0.01).percent();
   public static final vkl WINDOW = new vkl(a.c(-2051742050, "\ue6cf齀ᖔ误3蚚"), true);
   public static final vkl TABS = new vkl(a.b("膪\uf82e狾\ueccd杊\ue1e2宴퉅", -444694026), true);
   public static final vkl CARDS = new vkl(a.b("ဍ榉\ue347紬\uf6fe瀟쨎䏲\uddba圖탓", 251465793), true);
   public static final vkl POPUPS = new vkl(a.b("ꔓ\udc9d噑젥䏷악", 1307026757), true);
   static final List<vmo> OPTICS = List.of(STYLE, FROST, TINT, REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT, VIBRANCY);
   static final List<vmo> LIQUID_ONLY = List.of(REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT);
   static final List<vmo> TARGETS = List.of(WINDOW, TABS, CARDS, POPUPS);
   static final List<vmo> ALL = List.of(ENABLED, STYLE, FROST, TINT, REFRACTION, EDGE, DISPERSION, HIGHLIGHT, LIGHT, VIBRANCY, WINDOW, TABS, CARDS, POPUPS);
   static boolean hyw;

   hyv() {
   }

   public static boolean liquid() {
      return STYLE.is(a.c(436438085, "萏ﶛ睐\ue925拮\ue452"));
   }

   static void resetAll() {
      ENABLED.reset();
      STYLE.reset();

      for (vmo var1 : OPTICS) {
         if (var1 instanceof vmc var2) {
            var2.reset();
         }
      }

      for (vmo var4 : TARGETS) {
         ((vkl)var4).reset();
      }
   }

   public static void capture(DrawContext var0, int var1, float var2, @Nullable GpuTextureView var3) {
      int var4 = FROST.getInt();
      if (var1 > 0) {
         uij var5 = var1 == var4 && var3 == null ? uij.SCENE : uij.BACKDROP;
         if (var5.capture(var0, var1, null)) {
            uut.glass(var0, var5.result(var0), 0.0F, 0.0F, var0.getScaledWindowWidth(), var0.getScaledWindowHeight(), 0.0F, 0, var2);
         }
      }

      hyw = ENABLED.get() && uij.SCENE.capture(var0, var4, var3);
   }

   public static void skip() {
      hyw = false;
   }

   public static uoy lens(float var0) {
      return new uoy((float)REFRACTION.get(), var0, (float)DISPERSION.get(), (float)HIGHLIGHT.get(), (float)VIBRANCY.get(), (float)LIGHT.get());
   }

   static boolean active(vkl var0) {
      return hyw && ENABLED.get() && var0.get();
   }

   public static boolean surface(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8, vkl var9) {
      if (active(var9)) {
         boolean var10 = liquid()
            ? uut.liquid(var0, var1, var2, var3, var4, var5, var6, 1.0F, lens(var8))
            : uut.glass(var0, var1, var2, var3, var4, var5, var6, 1.0F);
         if (var10) {
            return true;
         }
      }

      uut.round(var0, var1, var2, var3, var4, var5, var7);
      return false;
   }

   public static int tint(int var0, float var1) {
      return ujt.withAlpha(var0, Math.round(255.0F * Math.max(0.0F, Math.min(1.0F, var1))));
   }
}
