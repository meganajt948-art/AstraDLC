package a;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.ItemGuiElementRenderState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import org.joml.Matrix3x2f;

public final class uor {
   static final Map<ItemStack, uoo> uos = new IdentityHashMap<>();
   static final Map<Item, String> uot = new IdentityHashMap<>();
   static long uou;

   uor() {
   }

   public static void draw(DrawContext var0, ItemStack var1, int var2, int var3) {
      if (!var1.isEmpty()) {
         MinecraftClient var4 = MinecraftClient.getInstance();
         GuiRenderState var5 = uut.state(var0);
         if (var5 != null && var4.world != null && uut.scissor() == null) {
            unf.observe(var0);
            long var6 = unf.frame();
            long var8 = var4.world.getTime();
            uoo var10 = uos.get(var1);
            if (var10 == null) {
               var10 = new uoo();
               uos.put(var1, var10);
            }

            if (var10.tick != var8) {
               var10.tick = var8;
               var4.getItemModelManager().clearAndUpdate(var10.state, var1, ItemDisplayContext.GUI, var4.world, var4.player, 0);
            }

            var10.frame = var6;
            var5.addItem(new ItemGuiElementRenderState(uox(var1.getItem()), new Matrix3x2f(var0.getMatrices()), var10.state, var2, var3, null));
            if (var6 - uou > 120L) {
               uou = var6;
               Iterator var11 = uos.values().iterator();

               while (var11.hasNext()) {
                  if (var6 - ((uoo)var11.next()).frame > 120L) {
                     var11.remove();
                  }
               }
            }
         } else {
            var0.drawItem(var1, var2, var3);
         }
      }
   }

   static String uox(Item var0) {
      return uot.computeIfAbsent(var0, var0x -> var0x.getName().toString());
   }
}
