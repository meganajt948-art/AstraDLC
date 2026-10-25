package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.Remove;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents.AllowMouseScroll;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.lwjgl.glfw.GLFW;

public class owo extends kfe {
   private static owo owp;
   private final vkl owq = this.add(new vkl(a.c(677360224, "눹쮳䅡\udf1f哚툿栨\ue1cf羃\uf534"), true));
   private final vkl owr = this.add(new vkl(a.d("備⤗ꏉ㶸뙦", -1305334915, 1830058934), true));
   private final vmc ows = this.add(new vmc(a.d("ɰ篢\uf124潕\ue483", -84827491, -172187461), 2.0, 1.0, 6.0, 1.0).suffix(a.d("潫ᚁ鱏ȴ觫", 1449612396, -627295443)));
   private final ArrayDeque<Integer> owt = new ArrayDeque<>();
   private final Set<Integer> owu = new HashSet<>();
   private int owv = -1;
   private boolean oww;

   public owo() {
      super(a.b("舦ﮪ煨\uef11擸\ue279堻퇗例씺䋠뢆", -1402961309), a.c(1765240970, "烺॰莢ᷜ阙ჼꫫ⌌뵀㟷끣䩓쒋崰휧冁\uebd1損ﺾ磦\uf15d識װ鹮ᡜ銏⬥ꕧ㿕맗㉣첧䛪\udf13奘"), kfa.PLAYER);
      owp = this;
   }

   public static void attach(Screen var0) {
      if (var0 instanceof HandledScreen var1 && !(var0 instanceof CreativeInventoryScreen)) {
         ScreenMouseEvents.allowMouseScroll(var0).register((AllowMouseScroll)(var1x, var2, var4, var6, var8) -> owp == null || !owp.owz(var1, var8));
         ScreenEvents.afterRender(var0).register((AfterRender)(var1x, var2, var3, var4, var5) -> {
            if (owp != null) {
               owp.oxa(var1);
            }
         });
         ScreenEvents.remove(var0).register((Remove)var0x -> {
            if (owp != null) {
               owp.owt.clear();
               owp.owu.clear();
               owp.oww = false;
            }
         });
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (!this.owt.isEmpty()) {
         if (var1.field_1755 instanceof HandledScreen var2 && var1.field_1724 != null && var2.method_17577().field_7763 == this.owv) {
            ScreenHandler var6 = var2.method_17577();

            for (int var4 = 0; var4 < this.ows.getInt() && !this.owt.isEmpty(); var4++) {
               int var5 = this.owt.poll();
               if (var5 >= 0 && var5 < var6.field_7761.size() && ((Slot)var6.field_7761.get(var5)).method_7681() && var6.method_34255().method_7960()) {
                  var1.field_1761.method_2906(var6.field_7763, var5, 0, SlotActionType.field_7794, var1.field_1724);
               }
            }
         } else {
            this.owt.clear();
         }
      }
   }

   private boolean owz(HandledScreen<?> var1, double var2) {
      if (this.isEnabled() && this.owr.get() && var2 != 0.0) {
         Slot var4 = vxl.hovered(var1);
         if (var4 != null && var4.method_7681()) {
            this.oxb(var1, var4);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void oxa(HandledScreen<?> var1) {
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (this.isEnabled() && this.owq.get() && var2.method_22683() != null) {
         long var3 = var2.method_22683().method_4490();
         boolean var5 = GLFW.glfwGetKey(var3, 340) == 1 || GLFW.glfwGetKey(var3, 344) == 1;
         boolean var6 = GLFW.glfwGetMouseButton(var3, 0) == 1;
         if (var5 && var6 && var1.method_17577().method_34255().method_7960()) {
            Slot var7 = vxl.hovered(var1);
            if (!this.oww) {
               this.oww = true;
               this.owu.clear();
               if (var7 != null) {
                  this.owu.add(var7.field_7874);
               }
            } else {
               if (var7 != null && var7.method_7681() && this.owu.add(var7.field_7874)) {
                  this.oxb(var1, var7);
               }
            }
         } else {
            this.oww = false;
            this.owu.clear();
         }
      } else {
         this.oww = false;
      }
   }

   private void oxb(HandledScreen<?> var1, Slot var2) {
      int var3 = var1.method_17577().field_7763;
      if (var3 != this.owv) {
         this.owt.clear();
         this.owv = var3;
      }

      if (!this.owt.contains(var2.field_7874)) {
         this.owt.add(var2.field_7874);
      }
   }
}
