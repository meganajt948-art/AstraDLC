package a;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;

record kdv(Screen screen, ClickableWidget widget, float delay) implements Drawable {
   private final Screen kdw;
   private final ClickableWidget kdx;
   private final float kdy;

   private kdv(Screen screen, ClickableWidget widget, float delay) {
      this.kdw = screen;
      this.kdx = widget;
      this.kdy = delay;
   }

   public void method_25394(DrawContext var1, int var2, int var3, float var4) {
      if (this.kdw.method_25396().contains(this.kdx)) {
         kej.ket(var1, this.kdx, var2, var3, var4, this.kdy);
      }
   }

   public Screen screen() {
      return this.kdw;
   }

   public ClickableWidget widget() {
      return this.kdx;
   }

   public float delay() {
      return this.kdy;
   }
}
