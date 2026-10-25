package a;

import flow.dev.a;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.gui.DrawContext;

public abstract class jcs {
   public final String id;
   public final String name;
   public final vkl enabled;
   private final int jct;
   private final int jcu;
   private final float jcv;
   private final float jcw;
   int ax;
   int ay;
   float ox;
   float oy;
   float size = 1.0F;
   float scale = 1.0F;
   static final float MIN_SIZE = 0.5F;
   static final float MAX_SIZE = 2.0F;
   final vcj shown = new vcj(9.0F);
   final vcj push = new vcj(10.0F);
   float x;
   float y;
   float w;
   float h;

   jcs(String var1, String var2, boolean var3, int var4, int var5, float var6, float var7) {
      this.id = var1;
      this.name = var2;
      this.enabled = new vkl(var2, var3);
      this.jct = var4;
      this.jcu = var5;
      this.jcv = var6;
      this.jcw = var7;
      this.resetPosition();
   }

   public List<vmo> settings() {
      return List.of();
   }

   abstract void update(float var1, boolean var2);

   abstract boolean hasContent(boolean var1);

   abstract float width();

   abstract float height();

   abstract void draw(DrawContext var1, float var2, boolean var3);

   boolean mouseClicked(float var1, float var2, int var3) {
      return false;
   }

   boolean canGhost() {
      return false;
   }

   boolean isSample() {
      return false;
   }

   void place(float var1, float var2, float var3, float var4, float var5) {
      float var6 = switch (this.ax) {
         case 0 -> this.ox;
         case 1 -> (var1 - var3) * 0.5F + this.ox;
         default -> var1 - var3 - this.ox;
      };

      float var7 = switch (this.ay) {
         case 0 -> this.oy;
         case 1 -> (var2 - var4) * 0.5F + this.oy;
         default -> var2 - var4 - this.oy;
      };
      var6 = Math.max(0.0F, Math.min(var1 - var3, var6));
      var7 = Math.max(0.0F, Math.min(var2 - var4, var7));
      this.x = Math.round(var6 * var5) / var5;
      this.y = Math.round(var7 * var5) / var5;
      this.w = var3;
      this.h = var4;
   }

   void moveTo(float var1, float var2, float var3, float var4) {
      float var5 = var1 + this.w * 0.5F;
      float var6 = var2 + this.h * 0.5F;
      this.ax = var5 < var3 / 3.0F ? 0 : (var5 > var3 * 2.0F / 3.0F ? 2 : 1);
      this.ay = var6 < var4 / 3.0F ? 0 : (var6 > var4 * 2.0F / 3.0F ? 2 : 1);

      this.ox = switch (this.ax) {
         case 0 -> var1;
         case 1 -> var1 - (var3 - this.w) * 0.5F;
         default -> var3 - this.w - var1;
      };

      this.oy = switch (this.ay) {
         case 0 -> var2;
         case 1 -> var2 - (var4 - this.h) * 0.5F;
         default -> var4 - this.h - var2;
      };
      this.x = var1;
      this.y = var2;
   }

   void resetPosition() {
      this.ax = this.jct;
      this.ay = this.jcu;
      this.ox = this.jcv;
      this.oy = this.jcw;
      this.size = 1.0F;
   }

   float pivotX() {
      return this.ax == 0 ? 0.0F : (this.ax == 1 ? this.w * 0.5F : this.w);
   }

   float pivotY() {
      return this.ay == 0 ? 0.0F : (this.ay == 1 ? this.h * 0.5F : this.h);
   }

   float slideSide() {
      return this.ax == 2 ? 1.0F : -1.0F;
   }

   String savePosition() {
      return String.format(Locale.ROOT, a.d("疘౨蛳ᢋ錝ᗤ꾾♄렇㋢땻伃쇟塲퉵哎\uee88慒ﯼ緸", 1515066362, -1595251117), this.ax, this.ay, this.ox, this.oy, this.size);
   }

   void loadPosition(String var1) {
      try {
         String[] var2 = var1.split(a.d("턳", 523518673, 1761842127));
         int var3 = Integer.parseInt(var2[0].trim());
         int var4 = Integer.parseInt(var2[1].trim());
         if (var3 < 0 || var3 > 2 || var4 < 0 || var4 > 2) {
            return;
         }

         this.ax = var3;
         this.ay = var4;
         this.ox = Float.parseFloat(var2[2].trim());
         this.oy = Float.parseFloat(var2[3].trim());
         if (var2.length > 4) {
            this.size = Math.max(0.5F, Math.min(2.0F, Float.parseFloat(var2[4].trim())));
         }
      } catch (RuntimeException var5) {
      }
   }
}
