package a;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;

final class kdv implements Drawable {
   private final Screen kdw;
   private final ClickableWidget kdx;
   private final float kdy;

   private kdv(Screen screen, ClickableWidget widget, float delay) {
      this.kdw = screen;
      this.kdx = widget;
      this.kdy = delay;
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      if (this.kdw.children().contains(this.kdx)) {
         kej.ket(context, this.kdx, mouseX, mouseY, deltaTicks, this.kdy);
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
