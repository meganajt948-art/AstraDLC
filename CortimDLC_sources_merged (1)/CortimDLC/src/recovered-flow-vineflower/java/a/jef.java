package a;

import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.DrawContext;

public final class jef extends jeq<jdz> {
   public static final vlv SHOW = new vlv(
      a.c(983627561, "\uf77e軴Р驉"), a.c(-1672653280, "噢\u2ffeꔭ"), a.b("荂\ufade瀍", 1556185856), a.d("켡뚲㱶ꈚ⧒꽰", -2020504048, -1804582538)
   );
   static final float jeg = 13.0F;
   static final float jeh = 9.5F;
   final Map<String, vcj> jei = new HashMap<>();

   jef() {
      super(a.b("펶ꨉ\u20c6뺬㕰돆ট聹", -1069296683), a.d("䜘㺇둈⨢ꇾ❈鴑ᓷ", -1710557151, 578207610), vhz.KEYBOARD, true, 0, 1, 6.0F, -30.0F);
   }

   @Override
   public List<vmo> settings() {
      return List.of(SHOW);
   }

   @Override
   List<jdz> items(boolean var1) {
      ArrayList var2 = new ArrayList();

      for (kfe var4 : Flow.getInstance().getModuleManager().getModules()) {
         if (var4.getKey() != -1 && (SHOW.is(a.b("\ue11a领ቕ", 862445912)) || var4.isEnabled())) {
            var2.add(new jdz(var4.getDisplayName(), var4.getKey(), var4.isEnabled()));
         }
      }

      if (var2.isEmpty() && var1) {
         var2.add(new jdz(jel(new char[]{'T', 'r', 'i', 'g', 'g', 'e', 'r', 'B', 'o', 't'}), 82, true));
         var2.add(new jdz(jel(new char[]{'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't'}), 71, false));
         var2.add(new jdz(jel(new char[]{'A', 'u', 't', 'o', 'S', 'w', 'a', 'p'}), 88, false));
      }

      return var2;
   }

   static String jel(char[] var0) {
      StringBuilder var1 = new StringBuilder(var0.length * 2 - 1);

      for (int var2 = 0; var2 < var0.length; var2++) {
         if (var2 > 0) {
            var1.append('\u200c');
         }

         var1.append(var0[var2]);
      }

      Arrays.fill(var0, '\u0000');
      return var1.toString();
   }

   String key(jdz var1) {
      return var1.jea;
   }

   @Override
   float rowHeight() {
      return 13.0F;
   }

   static float jem(String var0) {
      return Math.max(14.0F, izx.SMALL.width(var0) + 8.0F);
   }

   float rowWidth(jdz var1) {
      return 6.0F + izx.TEXT.width(var1.jea) + 12.0F + jem(irr.keyName(var1.jeb));
   }

   void drawRow(DrawContext var1, jdz var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = this.jei.computeIfAbsent(var2.jea, var1x -> new vcj(12.0F, var2.jec ? 1.0F : 0.0F)).step(var2.jec, var8);
      float var10 = var4 + var6 * 0.5F;
      if (var9 > 0.01F) {
         uut.shadow(var1, var3 - 0.2F, var10 - 2.0F, 4.0F, 4.0F, 2.0F, 3.0F, iov.accent((int)(90.0F * var9)));
         uut.circle(var1, var3 + 1.8F, var10, 1.7F * var9, iov.accent());
      }

      izx.TEXT.draw(var1, izx.TEXT.ellipsize(var2.jea, var5 - 30.0F), var3 + 6.0F * var9, izx.TEXT.centerTop(var10), ujt.lerp(iov.textDim, iov.text, var9));
      String var11 = irr.keyName(var2.jeb);
      float var12 = jem(var11);
      float var13 = var3 + var5 - var12;
      float var14 = iov.r(3.0F);
      uut.round(var1, var13, var10 - 4.75F, var12, 9.5F, var14, ujt.lerp(iov.field, iov.accent(60), var9 * 0.5F));
      uut.outline(var1, var13, var10 - 4.75F, var12, 9.5F, var14, 1.0F, ujt.lerp(iov.stroke, iov.accent(150), var9));
      izx.SMALL.drawCentered(var1, var11, var13 + var12 * 0.5F, izx.SMALL.centerTop(var10), ujt.lerp(iov.textDim, iov.text, var9));
   }
}
