package a;

import net.minecraft.client.gui.DrawContext;

final class hiv extends imn {
   static final float hiw = 24.0F;
   static final float hix = 17.0F;
   static final float hiy = 6.0F;
   final hip[] hiz;
   final vcj[] hja;
   final vcj[] hjb;

   hiv(String var1, vhz var2, Runnable var3) {
      this(new hip(var1, var2, var3));
   }

   hiv(hip... var1) {
      this(null, var1);
   }

   hiv(vkw var1) {
      this(var1, var1.buttons().stream().map(var0 -> new hip(var0.label(), var0.icon(), var0.action())).toArray(hip[]::new));
   }

   hiv(vmo var1, hip[] var2) {
      super(var1);
      this.hiz = var2;
      this.hja = new vcj[var2.length];
      this.hjb = new vcj[var2.length];

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.hja[var3] = new vcj(16.0F);
         this.hjb[var3] = new vcj(10.0F);
      }
   }

   @Override
   float height() {
      return 24.0F;
   }

   float hje() {
      return (this.w - 6.0F * (this.hiz.length - 1)) / this.hiz.length;
   }

   float hjf(int var1) {
      return this.x + var1 * (this.hje() + 6.0F);
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float var6 = this.y + 3.5F;
      float var7 = this.hje();

      for (int var8 = 0; var8 < this.hiz.length; var8++) {
         hip var9 = this.hiz[var8];
         float var10 = this.hjf(var8);
         float var11 = this.hja[var8].step(var2.canHover() && irr.inside(var3, var4, var10, var6, var7, 17.0F), var5);
         String var12 = irr.VALUE.ellipsize(wap.t(var9.label()), var7 - 8.0F - (var9.icon() != null ? 11.0F : 0.0F));
         irr.secondaryButton(var1, var12, var9.icon(), var10, var6, var7, 17.0F, var11, this.hjb[var8].step(0.0F, var5));
      }
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      float var5 = this.y + 3.5F;
      if (var4 != 0) {
         return false;
      }

      for (int var6 = 0; var6 < this.hiz.length; var6++) {
         if (irr.inside(var2, var3, this.hjf(var6), var5, this.hje(), 17.0F)) {
            this.hiz[var6].action().run();
            this.hjb[var6].set(1.0F);
            return true;
         }
      }

      return false;
   }
}
