package a;

import flow.dev.a;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class iah {
   static final IntPredicate ANY = var0 -> var0 >= 32 && var0 != 127;
   static final IntPredicate NUMBER = var0 -> var0 >= 48 && var0 <= 57 || var0 == 45 || var0 == 46;
   final String placeholder;
   final vhz icon;
   private final int iai;
   private final IntPredicate iaj;
   String text = "";
   iah next;
   Runnable onSubmit;
   Consumer<String> onChange;
   private float iak;
   private int ial;
   private boolean iam;
   private final vcj ian = new vcj(16.0F);
   private final vcj iao = new vcj(16.0F);
   private final vcj iap = new vcj(28.0F);
   private final vcj iaq = new vcj(20.0F);
   private long iar;
   float x;
   float y;
   float w;
   float h = 16.0F;
   String prefix;

   iah(String var1, vhz var2, int var3, IntPredicate var4) {
      this.placeholder = var1;
      this.icon = var2;
      this.iai = var3;
      this.iaj = var4;
   }

   void setText(String var1) {
      this.text = var1 == null ? "" : var1;
      this.ial = this.text.length();
      this.iam = false;
      if (this.onChange != null) {
         this.onChange.accept(this.text);
      }
   }

   void error() {
      this.iak = 1.0F;
   }

   boolean contains(float var1, float var2) {
      return irr.inside(var1, var2, this.x, this.y, this.w, this.h);
   }

   private float iau() {
      if (this.icon != null) {
         return this.x + 18.0F;
      } else {
         return this.prefix != null ? this.x + 7.0F + irr.SMALL.width(this.prefix) + 5.0F : this.x + 7.0F;
      }
   }

   private float iav() {
      return this.w - (this.iau() - this.x) - 6.0F;
   }

   void render(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      boolean var6 = var2.focusedField() == this;
      float var7 = this.ian.step(var6, var5);
      float var8 = this.iao.step(var2.canHover() && this.contains(var3, var4), var5);
      this.iak = Math.max(0.0F, this.iak - var5 * 1.6F);
      float var9 = iov.r(5.0F);
      uut.round(var1, this.x, this.y, this.w, this.h, var9, ujt.lerp(iov.field, iov.fieldHover, Math.max(var8, var7)));
      int var10 = ujt.lerp(ujt.lerp(iov.stroke, iov.textMuted, var8 * 0.4F), iov.accent(170), var7);
      uut.outline(var1, this.x, this.y, this.w, this.h, var9, 1.0F, ujt.lerp(var10, -1750963, this.iak));
      ukf.inset(var1, this.x, this.y, this.w, this.h, var9, iov.lightness());
      float var11 = this.y + this.h * 0.5F;
      if (this.icon != null) {
         vjf.draw(var1, this.icon, this.x + 9.5F, var11, 7.0F, ujt.lerp(iov.textMuted, iov.accent(), var7));
      } else if (this.prefix != null) {
         irr.SMALL.draw(var1, this.prefix, this.x + 7.0F, irr.SMALL.centerTop(var11), ujt.lerp(iov.textMuted, iov.accent(), var7));
      }

      float var12 = this.iau();
      float var13 = this.iav();
      String var14 = this.text.substring(0, Math.min(this.ial, this.text.length()));
      float var15 = irr.LABEL.width(var14);
      float var16 = Math.max(0.0F, Math.min(var15 - var13 + 4.0F, irr.LABEL.width(this.text) - var13 + 4.0F));
      float var17 = this.iaq.step(Math.max(0.0F, var16), var5);
      uut.pushScissor(var1, var12 - 1.0F, this.y, var13 + 2.0F, this.h);
      if (this.text.isEmpty()) {
         irr.LABEL.draw(var1, wap.t(this.placeholder), var12, irr.LABEL.centerTop(var11), ujt.mulAlpha(iov.textMuted, 1.0F - 0.4F * var7));
      } else {
         if (this.iam && var6) {
            uut.round(var1, var12 - var17 - 1.0F, var11 - 5.0F, irr.LABEL.width(this.text) + 2.0F, 10.0F, 2.0F, iov.accent(70));
         }

         irr.LABEL.draw(var1, this.text, var12 - var17, irr.LABEL.centerTop(var11), iov.text);
      }

      if (var6) {
         float var18 = this.iap.step(var12 - var17 + var15, var5);
         boolean var19 = System.currentTimeMillis() - this.iar < 500L || System.currentTimeMillis() / 530L % 2L == 0L;
         if (var19 && !this.iam) {
            uut.round(var1, var18, var11 - 4.5F, 1.0F, 9.0F, 0.5F, iov.accent());
         }
      } else {
         this.iap.set(var12 - var17 + var15);
      }

      uut.popScissor(var1);
   }

   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (!this.contains(var2, var3)) {
         return false;
      } else {
         var1.focus(this);
         if (var4 == 1) {
            this.setText("");
            return true;
         } else {
            this.iam = false;
            float var5 = var2 - this.iau() + this.iaq.get();
            int var6 = this.text.length();

            for (int var7 = 0; var7 <= this.text.length(); var7++) {
               if (irr.LABEL.width(this.text.substring(0, var7)) >= var5 - 2.0F) {
                  var6 = var7;
                  break;
               }
            }

            this.ial = var6;
            return true;
         }
      }
   }

   boolean keyPressed(hlc var1, int var2, int var3) {
      boolean var4 = (var3 & 2) != 0;
      this.iar = System.currentTimeMillis();
      switch (var2) {
         case 65:
            if (!var4) {
               return false;
            }

            this.iam = !this.text.isEmpty();
            break;
         case 67:
            if (!var4) {
               return false;
            }

            MinecraftClient.method_1551().field_1774.method_1455(this.text);
            break;
         case 86:
            if (!var4) {
               return false;
            }

            String var5 = MinecraftClient.method_1551().field_1774.method_1460();
            if (var5 != null) {
               this.iaw(var5.replace(a.d("㘄", -2127784439, 425762822), a.d("㴅", -775079790, 171640246)).replace(a.d("ࣜ", -445323027, 128704573), ""));
            }
            break;
         case 256:
            var1.focus(null);
            break;
         case 257:
         case 335:
            if (this.onSubmit != null) {
               this.onSubmit.run();
            } else {
               var1.focus(this.next);
            }
            break;
         case 258:
            var1.focus(this.next);
            break;
         case 259:
            if (this.iam || var4) {
               this.iax("", 0);
            } else if (this.ial > 0) {
               this.iax(this.text.substring(0, this.ial - 1) + this.text.substring(this.ial), this.ial - 1);
            }
            break;
         case 261:
            if (this.iam) {
               this.iax("", 0);
            } else if (this.ial < this.text.length()) {
               this.iax(this.text.substring(0, this.ial) + this.text.substring(this.ial + 1), this.ial);
            }
            break;
         case 262:
            this.ial = this.iam ? this.text.length() : Math.min(this.text.length(), this.ial + 1);
            this.iam = false;
            break;
         case 263:
            this.ial = this.iam ? 0 : Math.max(0, this.ial - 1);
            this.iam = false;
            break;
         case 268:
            this.ial = 0;
            this.iam = false;
            break;
         case 269:
            this.ial = this.text.length();
            this.iam = false;
            break;
         default:
            return false;
      }

      return true;
   }

   void charTyped(String var1) {
      this.iar = System.currentTimeMillis();
      this.iaw(var1);
   }

   private void iaw(String var1) {
      StringBuilder var2 = new StringBuilder();
      var1.codePoints().filter(this.iaj).forEach(var2::appendCodePoint);
      if (!var2.isEmpty()) {
         String var3 = this.iam ? "" : this.text;
         int var4 = this.iam ? 0 : this.ial;
         String var5 = var3.substring(0, var4) + var2 + var3.substring(var4);
         if (var5.length() <= this.iai) {
            this.iax(var5, var4 + var2.length());
         }
      }
   }

   private void iax(String var1, int var2) {
      this.text = var1;
      this.ial = Math.max(0, Math.min(var1.length(), var2));
      this.iam = false;
      if (this.onChange != null) {
         this.onChange.accept(this.text);
      }
   }

   void focusGained() {
      this.ial = this.text.length();
      this.iam = false;
      this.iar = System.currentTimeMillis();
   }
}
