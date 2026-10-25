package a;

import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.client.gui.DrawContext;

final class hwr extends imn {
   private static final float hws = 58.0F;
   private static final float hwt = 6.0F;
   private static final float hwu = 12.0F;
   private static final Map<String, uok> hwv = new HashMap<>();
   private static final Set<String> hww = new HashSet<>();
   private final String hwx;
   private final List<vcj> hwy = new ArrayList<>();
   private final List<vcj> hwz = new ArrayList<>();

   hwr(String var1) {
      super(null);
      this.hwx = var1;
   }

   private List<CosmeticItem> hxc() {
      List var1 = Cosmetics.ofSlot(this.hwx);

      while (this.hwy.size() < var1.size()) {
         this.hwy.add(new vcj(16.0F));
         this.hwz.add(new vcj(14.0F));
      }

      return var1;
   }

   private int hxd() {
      float var1 = this.w > 0.0F ? this.w : 376.0F;
      return Math.max(3, (int)((var1 + 6.0F) / 64.0F));
   }

   private float hxe() {
      int var1 = this.hxd();
      return (this.w - 6.0F * (var1 - 1)) / var1;
   }

   private int hxf() {
      return Math.max(1, (this.hxc().size() + this.hxd() - 1) / this.hxd());
   }

   @Override
   float height() {
      float var1 = this.w > 0.0F ? this.hxe() : 58.0F;
      return 3.0F + this.hxf() * (var1 + 12.0F) + (this.hxf() - 1) * 6.0F;
   }

   private float hxg(int var1) {
      return this.x + var1 % this.hxd() * (this.hxe() + 6.0F);
   }

   private float hxh(int var1) {
      return this.y + 3.0F + var1 / this.hxd() * (this.hxe() + 12.0F + 6.0F);
   }

   static uok thumb(String var0) {
      uok var1 = hwv.get(var0);
      if (var1 == null && !hww.contains(var0)) {
         try (InputStream var2 = ezj.open(a.c(641356438, "劮⭖ꆏ㿽됲㋛裄Ĺ齺ᗕ鈎桮\ue6a4缟\uf55c珱짥䘨\udc86嫏팷ꥷ➘") + var0 + a.b("⣠儏\udbc2䖺", 1931487434))) {
            BufferedImage var3 = var2 == null ? null : ImageIO.read(var2);
            if (var3 == null) {
               hww.add(var0);
               return null;
            } else {
               var1 = uok.upload(a.b("훖꽫▤믋〔뚴\u0cfa蔁ᬝ釸ᘷ\uec5b抔שׁ焻", -636430662) + var0, var3, false, true);
               hwv.put(var0, var1);
               return var1;
            }
         } catch (Exception var7) {
            hww.add(var0);
            return null;
         }
      } else {
         return var1;
      }
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = this.hxc();
      float var7 = this.hxe();
      float var8 = iov.r(6.0F);

      for (int var9 = 0; var9 < var6.size(); var9++) {
         CosmeticItem var10 = (CosmeticItem)var6.get(var9);
         float var11 = this.hxg(var9);
         float var12 = this.hxh(var9);
         boolean var13 = var2.canHover() && irr.inside(var3, var4, var11, var12, var7, var7 + 12.0F);
         float var14 = this.hwy.get(var9).step(var13, var5);
         float var15 = this.hwz.get(var9).step(Cosmetics.isWorn(var10), var5);
         float var16 = var12 - var14;
         if (var13) {
            var2.hint(var10.title() + a.b("浑ᓠ麤B讕", 2105961844) + var10.about());
         }

         int var17 = var10.accent | 0xFF000000;
         if (var15 > 0.01F) {
            uut.shadow(var1, var11, var16, var7, var7, var8, 8.0F, ujt.withAlpha(var17, (int)(90.0F * var15)));
         }

         uut.round(var1, var11, var16, var7, var7, var8, ujt.lerp(iov.field, ujt.lerp(iov.field, var17, 0.18F), Math.max(var15, var14 * 0.5F)));
         uok var18 = thumb(var10.id);
         if (var18 != null) {
            float var19 = 2.0F;
            uut.image(var1, var18.view, var11 + var19, var16 + var19, var7 - var19 * 2.0F, var7 - var19 * 2.0F, var8, -1);
         } else {
            vjf.draw(var1, vhz.CROWN, var11 + var7 * 0.5F, var16 + var7 * 0.5F, 11.0F, iov.textMuted);
         }

         uut.outline(var1, var11, var16, var7, var7, var8, 1.0F, ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, var14 * 0.5F), var17, var15));
         if (var15 > 0.02F) {
            float var22 = var11 + var7 - 6.0F;
            float var20 = var16 + 6.0F;
            float var21 = vcq.outBack(var15);
            uut.pushAlpha(var15);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(var22, var20);
            var1.getMatrices().scale(var21, var21);
            uut.circle(var1, 0.0F, 0.0F, 4.0F, var17);
            vjf.draw(var1, vhz.CHECK, 0.0F, 0.0F, 5.5F, -16052972);
            var1.getMatrices().popMatrix();
            uut.popAlpha();
         }

         irr.SMALL
            .drawCentered(
               var1,
               irr.SMALL.ellipsize(var10.title(), var7),
               var11 + var7 * 0.5F,
               irr.SMALL.centerTop(var12 + var7 + 6.0F + 1.0F),
               ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, var14), iov.text, var15)
            );
      }

      if (var6.isEmpty()) {
         irr.SMALL
            .draw(
               var1,
               wap.s(a.b("氀ᖐ齘ĵ諣ౕ똏㾹ꆮ⬒곖嚰\ud822䇊쮅䵥", -1540789154), a.b("篾ɮ袹ᛂ餅᮫ꆄ⡷똫㳦", -1516339221)),
               this.x,
               irr.SMALL.centerTop(this.y + 12.0F),
               iov.textMuted
            );
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return false;
      }

      List var5 = this.hxc();
      float var6 = this.hxe();

      for (int var7 = 0; var7 < var5.size(); var7++) {
         if (irr.inside(var2, var3, this.hxg(var7), this.hxh(var7), var6, var6 + 12.0F)) {
            Cosmetics.toggle((CosmeticItem)var5.get(var7));
            return true;
         }
      }

      return false;
   }
}
