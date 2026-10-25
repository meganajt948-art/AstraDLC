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

record keb(Screen screen, EntryListWidget<?> list) implements Drawable {
   private final Screen kec;
   private final EntryListWidget<?> ked;

   private keb(Screen screen, EntryListWidget<?> list) {
      this.kec = screen;
      this.ked = list;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void method_25394(DrawContext var1, int var2, int var3, float var4) {
      if (this.kec.method_25396().contains(this.ked)) {
         ArrayList var5 = new ArrayList();
         List var6 = this.ked.method_25396();

         for (int var7 = 0; var7 < var6.size(); var7++) {
            if (var6.get(var7) instanceof ParentElement var8
               && this.ked.method_25319(var7) >= this.ked.method_46427()
               && this.ked.method_25337(var7) <= this.ked.method_55443()) {
               for (Element var10 : var8.method_25396()) {
                  if (var10 instanceof ClickableWidget var11 && kej.kes(var11)) {
                     var5.add(var11);
                  }
               }
            }
         }

         float[] var22 = new float[var5.size()];

         for (int var23 = 0; var23 < var22.length; var23++) {
            var22[var23] = ((ClickableWidget)var5.get(var23)).method_75798();
            ((ClickableWidget)var5.get(var23)).method_25350(0.0F);
         }

         boolean var19 = false /* VF: Semaphore variable */;

         try {
            var19 = true;
            this.ked.method_25394(var1, var2, var3, var4);
            var19 = false;
         } finally {
            if (var19) {
               for (int var13 = 0; var13 < var22.length; var13++) {
                  ((ClickableWidget)var5.get(var13)).method_25350(var22[var13]);
               }
            }
         }

         for (int var24 = 0; var24 < var22.length; var24++) {
            ((ClickableWidget)var5.get(var24)).method_25350(var22[var24]);
         }

         uut.pushScissor(var1, this.ked.method_46426(), this.ked.method_46427(), this.ked.method_25368(), this.ked.method_25364());

         try {
            for (int var25 = 0; var25 < var22.length; var25++) {
               ClickableWidget var27 = (ClickableWidget)var5.get(var25);
               if (var27.field_22764) {
                  kej.keu(var1, var27, var2, var3, var22[var25], Math.min(var25, 14) * 0.012F);
               }
            }
         } finally {
            uut.popScissor(var1);
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
