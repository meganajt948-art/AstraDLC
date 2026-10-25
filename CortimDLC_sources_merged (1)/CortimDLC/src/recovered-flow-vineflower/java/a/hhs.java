package a;

import flow.dev.a;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

final class hhs extends imn {
   private static final float hht = 22.0F;
   private static final float hhu = 12.0F;
   private final vcj[] hhv;
   private final vcj[] hhw;

   hhs() {
      super(iov.ACCENT);
      int var1 = iov.ACCENT.getModes().size();
      this.hhv = new vcj[var1];
      this.hhw = new vcj[var1];

      for (int var2 = 0; var2 < var1; var2++) {
         this.hhv[var2] = new vcj(16.0F);
         this.hhw[var2] = new vcj(14.0F, var2 == iov.ACCENT.index() ? 1.0F : 0.0F);
      }
   }

   @Override
   float height() {
      return 22.0F;
   }

   private float hhz(int var1, int var2) {
      float var3 = (this.w - 12.0F * var2) / (var2 - 1);
      return this.x + 6.0F + var1 * (12.0F + var3);
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      List var6 = iov.ACCENT.getModes();
      int var7 = var6.size();
      float var8 = this.y + 11.0F;
      int var9 = -1;
      iom var10 = iov.preset();

      for (int var11 = 0; var11 < var7; var11++) {
         float var12 = this.hhz(var11, var7);
         boolean var13 = var2.canHover() && irr.inside(var3, var4, var12 - 6.0F - 2.0F, var8 - 6.0F - 2.0F, 16.0F, 16.0F);
         if (var13) {
            var9 = var11;
         }

         float var14 = this.hhv[var11].step(var13, var5);
         float var15 = this.hhw[var11].step(var11 == iov.ACCENT.index(), var5);
         float var16 = 6.0F + var14 * 0.8F - var15 * 1.2F;
         boolean var17 = var11 == var7 - 1;
         boolean var18 = var11 == 0;
         int[] var19 = iov.accentPair(var11, var10);
         if (var15 > 0.01F) {
            uut.circleOutline(var1, var12, var8, 7.8F, 1.2F, ujt.mulAlpha(iov.text, var15 * 0.9F));
         }

         if (var17) {
            uut.gradient(var1, var12 - var16, var8 - var16, var16 * 2.0F, var16 * 2.0F, var16, -45715, -11930, -16329056, -11698945);
            uut.circle(var1, var12, var8, var16 * 0.5F, var19[0]);
         } else if (var18) {
            uut.circle(var1, var12, var8, var16, ujt.withAlpha(iov.window, 255));
            uut.circleOutline(var1, var12, var8, var16, 0.8F, iov.stroke);
            uut.gradient(var1, var12 - var16 * 0.55F, var8 - var16 * 0.55F, var16 * 1.1F, var16 * 1.1F, var16 * 0.55F, var19[0], var19[1], var19[1], var19[0]);
         } else {
            uut.gradient(var1, var12 - var16, var8 - var16, var16 * 2.0F, var16 * 2.0F, var16, var19[0], var19[1], var19[1], var19[0]);
         }
      }

      if (var9 >= 0) {
         var2.hint(
            var9 == 0
               ? wap.s(a.b("䳄㕁뾓⇹ꩡⳐ阔ὲ脭ை谇登\uf8e9愌\ueb43涿ퟸ堡싐䓕쵱띯㧄ꈌ\u243d꺭\u171c饍μ藦๏", 552815770), a.b("㋚䭉쇪忧퀮嚟\uec5b攽ﭢ痃\uf21aࠗ蚳Ἂ锦឵ꦛ☻버㫗댧쵯䞾\udc18婮탈", 13711056))
               : wap.value((String)var6.get(var9))
         );
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (var4 != 0) {
         return false;
      }

      List var5 = iov.ACCENT.getModes();
      int var6 = var5.size();
      float var7 = this.y + 11.0F;

      for (int var8 = 0; var8 < var6; var8++) {
         float var9 = this.hhz(var8, var6);
         if (irr.inside(var2, var3, var9 - 6.0F - 2.0F, var7 - 6.0F - 2.0F, 16.0F, 16.0F)) {
            iov.ACCENT.set((String)var5.get(var8));
            return true;
         }
      }

      return false;
   }
}
