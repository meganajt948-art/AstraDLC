package a;

import flow.dev.a;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.DyeColor;
import net.minecraft.util.collection.DefaultedList;

public class pbe extends kfe {
   private static pbe pbf;
   private final vmc pbg = this.add(new vmc(a.b("唢ⲩꙩ㠇", -1053993611), 1.0, 0.6, 1.6, 0.05).unit(a.b("\uf0cd", -1699745612)));
   private final vkl pbh = this.add(new vkl(a.b("譑\uf2cd砉\ue620涴\ueb09兙\ud8ab䛩", 998804250), true));
   private final vkl pbi = this.add(new vkl(a.b("ꚁ\udf1c嗍쮡䁧월粐", -648567099), false));
   private static final vdn pbj = veo.semibold(6.5F);
   private static final vdn pbk = veo.medium(5.5F);
   private static final float pbl = 18.0F;
   private static final float pbm = 5.0F;
   private static final float pbn = 13.0F;
   private final DefaultedList<ItemStack> pbo = DefaultedList.method_10213(27, ItemStack.field_8037);

   public pbe() {
      super(a.c(-1436817267, "\ue8d0酚ᮔ藼ฬ袓㋗묄╹꿟⠟퉱岪씉"), a.d("煸ࣿ般ᰘ鞆ᄰꭾ⊕볇㙷뇡䯑앇岥훭倁\uea57斁＼祺\uf0df諁ѳ鿬\u19db錍⪧ꓥ㸅", -2057239957, 1035236189), kfa.PLAYER);
      pbf = this;
   }

   public static void attach(Screen var0) {
      if (var0 instanceof HandledScreen var1) {
         ScreenEvents.afterRender(var0).register((AfterRender)(var1x, var2, var3, var4, var5) -> {
            pbe var6 = pbf;
            if (var6 != null && var6.isEnabled()) {
               var6.pbr(var1, var2, var3, var4);
            }
         });
      }
   }

   private void pbr(HandledScreen<?> var1, DrawContext var2, int var3, int var4) {
      if (var1.method_17577().method_34255().method_7960()) {
         Slot var5 = vxl.hovered(var1);
         if (var5 != null && var5.method_7681()) {
            ItemStack var6 = var5.method_7677();
            if (var6.method_7909() instanceof BlockItem var7 && var7.method_7711() instanceof ShulkerBoxBlock var8) {
               ContainerComponent var34 = (ContainerComponent)var6.method_58694(DataComponentTypes.field_49622);

               for (int var10 = 0; var10 < this.pbo.size(); var10++) {
                  this.pbo.set(var10, ItemStack.field_8037);
               }

               if (var34 != null) {
                  var34.method_57492(this.pbo);
               }

               int var35 = 0;
               int var11 = 0;

               for (int var12 = 0; var12 < 27; var12++) {
                  if (!((ItemStack)this.pbo.get(var12)).method_7960()) {
                     var35++;
                     var11 = var12 / 9;
                  }
               }

               int var36 = this.pbi.get() ? Math.max(1, var11 + 1) : 3;
               float var13 = 172.0F;
               float var14 = 18.0F + var36 * 18.0F + 5.0F;
               float var15 = (float)this.pbg.get();
               int var16 = var2.method_51421();
               int var17 = var2.method_51443();
               float var18 = Math.max(2.0F, Math.min(var16 - var13 * var15 - 2.0F, var3 + 10.0F));
               float var19 = var4 - 18.0F - var14 * var15;
               if (var19 < 2.0F) {
                  var19 = Math.min(var17 - var14 * var15 - 2.0F, var4 + 22.0F);
               }

               DyeColor var20 = var8.method_10528();
               int var21 = var20 != null ? 0xFF000000 | var20.method_7787() : -6522701;
               int var22 = this.pbh.get() ? ujt.lerp(-15592938, var21, 0.22F) : iov.window | 0xFF000000;
               int var23 = this.pbh.get() ? ujt.lerp(var21, -1, 0.25F) : iov.stroke;
               int var24 = ujt.withAlpha(ujt.lerp(var22, -1, 0.07F), 235);
               float var25 = 6.0F;
               uut.beginFrame();
               var2.method_51448().pushMatrix();
               var2.method_51448().translate(var18, var19);
               var2.method_51448().scale(var15, var15);
               uut.shadow(var2, 0.0F, 2.0F, var13, var14, var25, 10.0F, 1879048192);
               uut.round(var2, 0.0F, 0.0F, var13, var14, var25, ujt.withAlpha(var22, 245));
               uut.outline(var2, 0.0F, 0.0F, var13, var14, var25, 1.0F, ujt.withAlpha(var23, 150));
               String var26 = var6.method_7964().getString();
               String var27 = var35 + a.b("숩뮅ㅓ", -1330724347);
               pbj.draw(var2, pbj.ellipsize(var26, var13 - 10.0F - pbk.width(var27) - 8.0F), 6.0F, pbj.centerTop(8.5F), -855307);
               pbk.draw(var2, var27, var13 - 5.0F - pbk.width(var27), pbk.centerTop(8.5F), ujt.withAlpha(var23, 220));

               for (int var28 = 0; var28 < var36; var28++) {
                  for (int var29 = 0; var29 < 9; var29++) {
                     uut.round(var2, 5.0F + var29 * 18.0F + 0.5F, 18.0F + var28 * 18.0F + 0.5F, 17.0F, 17.0F, 3.0F, var24);
                  }
               }

               MinecraftClient var37 = MinecraftClient.method_1551();

               for (int var38 = 0; var38 < var36 * 9; var38++) {
                  ItemStack var30 = (ItemStack)this.pbo.get(var38);
                  if (!var30.method_7960()) {
                     int var31 = Math.round(5.0F + var38 % 9 * 18.0F + 1.0F);
                     int var32 = Math.round(18.0F + var38 / 9 * 18.0F + 1.0F);
                     var2.method_51427(var30, var31, var32);
                     var2.method_51431(var37.field_1772, var30, var31, var32);
                  }
               }

               var2.method_51448().popMatrix();
            }
         }
      }
   }
}
