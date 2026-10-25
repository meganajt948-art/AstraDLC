package a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.ParentElement;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.EntryListWidget;

final class keb implements Drawable {
   private final Screen kec;
   private final EntryListWidget<?> ked;

   private keb(Screen screen, EntryListWidget<?> list) {
      this.kec = screen;
      this.ked = list;
   }

   @Override
   public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
      if (this.kec.children().contains(this.ked)) {
         ArrayList var5 = new ArrayList();
         List var6 = this.ked.children();

         for (int var7 = 0; var7 < var6.size(); var7++) {
            if (var6.get(var7) instanceof ParentElement var8
               && this.ked.getRowBottom(var7) >= this.ked.getY()
               && this.ked.getRowTop(var7) <= this.ked.getBottom()) {
               for (Element var10 : var8.children()) {
                  if (var10 instanceof ClickableWidget var11 && kej.kes(var11)) {
                     var5.add(var11);
                  }
               }
            }
         }

         float[] var21 = new float[var5.size()];

         for (int var22 = 0; var22 < var21.length; var22++) {
            var21[var22] = ((ClickableWidget)var5.get(var22)).getAlpha();
            ((ClickableWidget)var5.get(var22)).setAlpha(0.0F);
         }

         try {
            this.ked.render(context, mouseX, mouseY, deltaTicks);
         } finally {
            for (int var13 = 0; var13 < var21.length; var13++) {
               ((ClickableWidget)var5.get(var13)).setAlpha(var21[var13]);
            }
         }

         uut.pushScissor(context, this.ked.getX(), this.ked.getY(), this.ked.getWidth(), this.ked.getHeight());

         try {
            for (int var23 = 0; var23 < var21.length; var23++) {
               ClickableWidget var25 = (ClickableWidget)var5.get(var23);
               if (var25.visible) {
                  kej.keu(context, var25, mouseX, mouseY, var21[var23], Math.min(var23, 14) * 0.012F);
               }
            }
         } finally {
            uut.popScissor(context);
         }
      }
   }

   public Screen screen() {
      return this.kec;
   }

   public EntryListWidget<?> list() {
      return this.ked;
   }
}
