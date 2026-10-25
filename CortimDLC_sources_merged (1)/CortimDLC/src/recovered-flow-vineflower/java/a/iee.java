package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

final class iee extends imn {
   private static final float ief = 26.0F;
   private static final float ieg = 66.0F;
   private static final float ieh = 17.0F;
   private static final int iei = 5;
   private final vlj iej;
   private final vcj iek = new vcj(16.0F);
   private final vcj iel = new vcj(10.0F);
   private int iem = -1;
   private final List<ItemStack> ien = new ArrayList<>();

   iee(vlj var1) {
      super(var1);
      this.iej = var1;
   }

   @Override
   float height() {
      return 26.0F;
   }

   private void ieq() {
      if (this.iem != this.iej.version()) {
         this.iem = this.iej.version();
         this.ien.clear();

         for (String var2 : this.iej.ids()) {
            ItemStack var3 = ibf.iconOf(this.iej.kind(), var2);
            if (!var3.method_7960()) {
               this.ien.add(var3);
               if (this.ien.size() >= 5) {
                  break;
               }
            }
         }
      }
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      this.ieq();
      float var6 = this.y + 13.0F;
      float var7 = this.hover.step(this.hovered(var3, var4) && var2.canHover(), var5);
      irr.LABEL.draw(var1, wap.t(this.setting.getName()), this.x, irr.LABEL.centerTop(var6), ujt.lerp(iov.textDim, iov.text, var7));
      float var8 = this.x + this.w - 66.0F;
      float var9 = var6 - 8.5F;
      float var10 = this.iek.step(var2.canHover() && irr.inside(var3, var4, var8, var9, 66.0F, 17.0F), var5);
      irr.secondaryButton(
         var1,
         wap.s(a.c(-2011918299, "遠\ue9fa挮ﵟ皔\uf033"), a.d("勶⬞ꆷ㾷됐㋓袎", -204610555, 125154022)),
         vhz.SEARCH,
         var8,
         var9,
         66.0F,
         17.0F,
         var10,
         this.iel.step(0.0F, var5)
      );
      float var11 = var8 - 6.0F;
      int var12 = this.iej.size();
      if (var12 > this.ien.size()) {
         String var13 = a.c(420731926, "\udc3c") + (var12 - this.ien.size());
         var11 = irr.drawChip(var1, var13, var11, var6, iov.textDim, iov.stroke, var7) - 4.0F;
      } else if (var12 == 0) {
         String var16 = wap.s(a.d("箉ȹ裫ᚑ", -1210004797, -873549536), a.b("灻শ荧ᴕ难", -1063619519));
         irr.SMALL.draw(var1, var16, var11 - irr.SMALL.width(var16), irr.SMALL.centerTop(var6), iov.textMuted);
      }

      float var17 = this.x + irr.LABEL.width(wap.t(this.setting.getName())) + 6.0F;

      for (int var14 = this.ien.size() - 1; var14 >= 0; var14--) {
         float var15 = var11 - 14.0F;
         if (var15 < var17) {
            break;
         }

         var1.method_51448().pushMatrix();
         var1.method_51448().translate(var15, var6 - 6.5F);
         var1.method_51448().scale(0.8125F, 0.8125F);
         var1.method_51427(this.ien.get(var14), 0, 0);
         var1.method_51448().popMatrix();
         var11 = var15 - 1.5F;
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 == 0 && this.hovered(var2, var3)) {
         this.iel.set(1.0F);
         var1.openPicker(this.iej);
         return true;
      } else {
         return false;
      }
   }
}
