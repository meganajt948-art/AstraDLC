package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.DrawContext;

abstract class jeq<T> extends jcs {
   static final float HEAD = 16.0F;
   static final float PAD = 7.0F;
   static final float jer = 84.0F;
   final vhz jes;
   List<jen<T>> jet = new ArrayList<>();
   List<jen<T>> jeu = new ArrayList<>();
   final Map<String, jen<T>> jev = new HashMap<>();
   final vcj jew = new vcj(13.0F, 84.0F);
   final vcj jex = new vcj(8.0F);
   int jey;
   boolean jez;
   boolean jfa;
   float jfb = 16.0F;
   float jfc = 84.0F;
   long jfd;
   boolean jfe;
   boolean jff;

   jeq(String var1, String var2, vhz var3, boolean var4, int var5, int var6, float var7, float var8) {
      super(var1, var2, var4, var5, var6, var7, var8);
      this.jes = var3;
   }

   abstract List<T> items(boolean var1);

   abstract String key(T var1);

   abstract float rowHeight();

   abstract float rowWidth(T var1);

   abstract void drawRow(DrawContext var1, T var2, float var3, float var4, float var5, float var6, float var7, float var8);

   long refreshNanos() {
      return 50000000L;
   }

   @Override
   void update(float var1, boolean var2) {
      long var3 = System.nanoTime();
      boolean var5 = this.enabled.get();
      if (var3 - this.jfd >= this.refreshNanos() || var2 != this.jfe || var5 != this.jff) {
         this.jfd = var3;
         this.jfe = var2;
         this.jff = var5;
         this.jfi(var5, var2);
      }

      float var6 = 0.0F;

      for (jen var8 : this.jet) {
         float var9 = var8.appear.step(var8.alive, var1);
         var6 += this.rowHeight() * vcq.outCubic(var9);
      }

      if (this.jet.removeIf(var0 -> !var0.alive && var0.appear.get() <= 0.01F)) {
         this.jfc = this.jfj();
      }

      this.jex.step(0.0F, var1);
      this.jew.step(this.jfc, var1);
      this.jfb = 16.0F + (var6 > 0.05F ? var6 + 5.0F : 0.0F);
   }

   void jfi(boolean var1, boolean var2) {
      List var3 = var1 ? this.items(false) : List.of();
      this.jfa = false;
      if (var3.isEmpty() && var2 && var1) {
         var3 = this.items(true);
         this.jfa = !var3.isEmpty();
      }

      this.jev.clear();

      for (jen var5 : this.jet) {
         this.jev.put(var5.key, var5);
      }

      List var8 = this.jeu;
      var8.clear();

      for (Object var6 : var3) {
         jen var7 = this.jev.remove(this.key((T)var6));
         if (var7 == null) {
            var7 = new jen(this.key((T)var6));
         }

         var7.item = (T)var6;
         var7.alive = true;
         var8.add(var7);
      }

      for (int var10 = 0; var10 < this.jet.size(); var10++) {
         jen var12 = this.jet.get(var10);
         if (this.jev.containsKey(var12.key)) {
            var12.alive = false;
            var8.add(Math.min(var10, var8.size()), var12);
         }
      }

      this.jeu = this.jet;
      this.jet = var8;
      int var11 = var3.size();
      if (var11 != this.jey) {
         this.jey = var11;
         this.jex.set(1.0F);
      }

      this.jez = var11 > 0;
      this.jfc = this.jfj();
   }

   float jfj() {
      float var1 = Math.max(84.0F, 28.0F + izx.HEAD.width(wap.t(this.name)) + 22.0F);

      for (jen var3 : this.jet) {
         if (var3.alive) {
            var1 = Math.max(var1, this.rowWidth(var3.item) + 14.0F);
         }
      }

      return var1;
   }

   @Override
   boolean hasContent(boolean var1) {
      return this.jez;
   }

   @Override
   boolean canGhost() {
      return true;
   }

   @Override
   boolean isSample() {
      return this.jfa;
   }

   @Override
   float width() {
      return this.jew.get();
   }

   @Override
   float height() {
      return this.jfb;
   }

   @Override
   void draw(DrawContext var1, float var2, boolean var3) {
      float var4 = this.width();
      float var5 = this.height();
      float var6 = iov.r(6.0F);
      izx.panel(var1, var4, var5, var6);
      float var7 = 8.5F;
      vjf.draw(var1, this.jes, 10.5F, var7, 7.0F, iov.textMuted);
      izx.HEAD.draw(var1, wap.t(this.name), 17.5F, izx.HEAD.centerTop(var7), iov.textDim);
      if (this.jey > 0) {
         String var8 = String.valueOf(this.jey);
         float var9 = this.jex.get();
         float var10 = 1.0F + 0.25F * var9;
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(var4 - 7.0F - izx.SMALL.width(var8) * 0.5F, var7);
         var1.getMatrices().scale(var10, var10);
         izx.SMALL.drawCentered(var1, var8, 0.0F, izx.SMALL.centerTop(0.0F), ujt.lerp(iov.textMuted, iov.text, var9));
         var1.getMatrices().popMatrix();
      }

      if (!(var5 <= 16.5F)) {
         uut.pushScissor(var1, 0.0F, 16.0F, var4, var5 - 16.0F);
         float var14 = 18.5F;
         float var15 = this.rowHeight();

         for (jen var11 : this.jet) {
            float var12 = vcq.outCubic(var11.appear.get());
            float var13 = var15 * var12;
            if (var13 > 0.2F) {
               uut.pushAlpha(Math.min(1.0F, var12 * 1.2F));
               var1.getMatrices().pushMatrix();
               var1.getMatrices().translate((1.0F - var12) * 8.0F * this.slideSide(), 0.0F);
               this.drawRow(var1, var11.item, 7.0F, var14, var4 - 14.0F, var15, var12, var2);
               var1.getMatrices().popMatrix();
               uut.popAlpha();
            }

            var14 += var13;
         }

         uut.popScissor(var1);
      }
   }

   static void bar(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      float var7 = 1.5F;
      uut.round(var0, var1, var2, var3, var7, var7 * 0.5F, iov.track);
      float var8 = Math.max(0.0F, Math.min(1.0F, var4));
      if (var8 > 0.001F) {
         uut.gradientH(var0, var1, var2, Math.max(var7, var3 * var8), var7, var7 * 0.5F, var5, var6);
      }
   }

   static int expiring(int var0, float var1) {
      if (!(var1 > 10.0F) && !(var1 < 0.0F)) {
         float var2 = 0.5F + 0.5F * (float)Math.cos(System.nanoTime() / 1.0E9 * Math.PI * 2.0);
         return ujt.lerp(var0, -1096636, 0.35F + 0.45F * var2);
      } else {
         return var0;
      }
   }
}
