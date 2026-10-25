package a;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public final class vgj extends HeldItemRenderer {
   private static Field vgk;
   private static Field vgl;
   private static Field vgm;
   private static Field vgn;
   private static Field vgo;
   private static Field vgp;
   private static Field vgq;
   private static MethodHandle vgr;
   private static boolean vgs;
   private static boolean vgt;
   private static Field vgu;
   private final MinecraftClient vgv;
   private final ItemModelManager vgw;

   private vgj(MinecraftClient var1, EntityRenderManager var2, ItemModelManager var3) {
      super(var1, var2, var3);
      this.vgv = var1;
      this.vgw = var3;
   }

   public static void ensureInstalled(MinecraftClient var0) {
      if (!vgs && var0.field_1773 != null) {
         try {
            Field var1 = vgu;
            if (var1 == null) {
               for (Field var5 : GameRenderer.class.getDeclaredFields()) {
                  if (!Modifier.isStatic(var5.getModifiers()) && var5.getType() == HeldItemRenderer.class) {
                     var1 = var5;
                     break;
                  }
               }

               if (var1 == null) {
                  throw new IllegalStateException("no hand renderer in GameRenderer");
               }

               var1.setAccessible(true);
               vgu = var1;
            }

            Object var12 = var1.get(var0.field_1773);
            if (var12 instanceof vgj) {
               return;
            }

            vgz();
            HeldItemRenderer var13 = (HeldItemRenderer)var12;
            ItemModelManager var14 = (ItemModelManager)vgq.get(var13);
            vgj var15 = new vgj(var0, var0.method_1561(), var14);

            for (Field var9 : HeldItemRenderer.class.getDeclaredFields()) {
               int var10 = var9.getModifiers();
               if (!Modifier.isStatic(var10) && !Modifier.isFinal(var10)) {
                  var9.setAccessible(true);
                  var9.set(var15, var9.get(var13));
               }
            }

            var1.set(var0.field_1773, var15);
            if (!vgt) {
               vgt = true;
               System.out.println("hand renderer ready (view model, hand shaders)");
            }
         } catch (Throwable var11) {
            vgs = true;
            System.out.println("hand tweaks unavailable, the game's hands stay: " + var11);
         }
      }
   }

   private static void vgz() throws ReflectiveOperationException {
      if (vgr == null) {
         ArrayList var0 = new ArrayList();
         ArrayList var1 = new ArrayList();

         for (Field var5 : HeldItemRenderer.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var5.getModifiers())) {
               var5.setAccessible(true);
               if (var5.getType() == ItemStack.class) {
                  var0.add(var5);
               } else if (var5.getType() == float.class) {
                  var1.add(var5);
               } else if (var5.getType() == ItemModelManager.class) {
                  vgq = var5;
               }
            }
         }

         if (var0.size() == 2 && var1.size() == 4 && vgq != null) {
            vgk = (Field)var0.get(0);
            vgl = (Field)var0.get(1);
            vgm = (Field)var1.get(0);
            vgn = (Field)var1.get(1);
            vgo = (Field)var1.get(2);
            vgp = (Field)var1.get(3);
            Method var8 = null;

            for (Method var6 : HeldItemRenderer.class.getDeclaredMethods()) {
               Class[] var7 = var6.getParameterTypes();
               if (var6.getReturnType() == void.class
                  && var7.length == 10
                  && var7[0] == AbstractClientPlayerEntity.class
                  && var7[3] == Hand.class
                  && var7[5] == ItemStack.class
                  && var7[7] == MatrixStack.class
                  && var7[8] == OrderedRenderCommandQueue.class
                  && var7[9] == int.class) {
                  var8 = var6;
                  break;
               }
            }

            if (var8 == null) {
               throw new IllegalStateException("first-person item method not found");
            } else {
               var8.setAccessible(true);
               vgr = MethodHandles.lookup().unreflect(var8);
            }
         } else {
            throw new IllegalStateException("unexpected hand renderer layout: " + var0.size() + " stacks, " + var1.size() + " floats");
         }
      }
   }

   public void method_22976(float var1, MatrixStack var2, OrderedRenderCommandQueue var3, ClientPlayerEntity var4, int var5) {
      if (!vhu.changesHands()) {
         super.method_22976(var1, var2, var3, var4, var5);
         vhf.afterHands(var4, var1);
      } else {
         try {
            this.vha(var1, var2, var3, var4, var5);
         } catch (Throwable var7) {
            vgs = true;
            System.out.println("hand tweaks failed, back to the game's hands: " + var7);
            super.method_22976(var1, var2, var3, var4, var5);
         }

         vhf.afterHands(var4, var1);
      }
   }

   private void vha(float var1, MatrixStack var2, OrderedRenderCommandQueue var3, ClientPlayerEntity var4, int var5) throws Throwable {
      float var6 = var4.method_6055(var1);
      Hand var7 = var4.field_6266 != null ? var4.field_6266 : Hand.field_5808;
      float var8 = var4.method_61414(var1);
      float var9 = MathHelper.method_16439(var1, var4.field_3914, var4.field_3916);
      float var10 = MathHelper.method_16439(var1, var4.field_3931, var4.field_3932);
      var2.method_22907(RotationAxis.field_40714.rotationDegrees((var4.method_5695(var1) - var9) * 0.1F));
      var2.method_22907(RotationAxis.field_40716.rotationDegrees((var4.method_5705(var1) - var10) * 0.1F));
      boolean[] var11 = vhc(var4);
      ItemStack var12 = (ItemStack)vgk.get(this);
      ItemStack var13 = (ItemStack)vgl.get(this);
      if (var11[0]) {
         float var14 = this.vgw.method_75483(var12) * (1.0F - MathHelper.method_16439(var1, vgn.getFloat(this), vgm.getFloat(this)));
         this.vhb(var4, var1, var8, Hand.field_5808, var7 == Hand.field_5808 ? var6 : 0.0F, var12, var14, var2, var3, var5);
      }

      if (var11[1]) {
         float var15 = this.vgw.method_75483(var13) * (1.0F - MathHelper.method_16439(var1, vgp.getFloat(this), vgo.getFloat(this)));
         this.vhb(var4, var1, var8, Hand.field_5810, var7 == Hand.field_5810 ? var6 : 0.0F, var13, var15, var2, var3, var5);
      }

      this.vgv.field_1773.method_72911().method_73002();
      this.vgv.method_22940().method_23000().method_22993();
   }

   private void vhb(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      OrderedRenderCommandQueue var9,
      int var10
   ) throws Throwable {
      Arm var11 = var4 == Hand.field_5808 ? var1.method_6068() : var1.method_6068().method_5928();
      boolean var12 = var6.method_31574(Items.field_49814);
      boolean var13 = vhu.swings(var1, var4, var6);
      var8.method_22903();
      if (!var12) {
         vhu.viewModel(var8, var11);
      }

      if (var13) {
         vhu.swing(var8, var1, var11, var4, var5, var6, var2);
      }

      vgr.invoke(
         (HeldItemRenderer)this,
         (AbstractClientPlayerEntity)var1,
         (float)var2,
         (float)var3,
         (Hand)var4,
         (float)(var13 ? 0.0F : var5),
         (ItemStack)var6,
         (float)(var13 && !var12 ? 0.0F : var7),
         (MatrixStack)var8,
         (OrderedRenderCommandQueue)var9,
         (int)var10
      );
      var8.method_22909();
   }

   private static boolean[] vhc(ClientPlayerEntity var0) {
      ItemStack var1 = var0.method_6047();
      ItemStack var2 = var0.method_6079();
      boolean var3 = var1.method_31574(Items.field_8102) || var2.method_31574(Items.field_8102);
      boolean var4 = var1.method_31574(Items.field_8399) || var2.method_31574(Items.field_8399);
      if (!var3 && !var4) {
         return new boolean[]{true, true};
      } else if (!var0.method_6115()) {
         return new boolean[]{true, !vhd(var1)};
      } else {
         ItemStack var5 = var0.method_6030();
         Hand var6 = var0.method_6058();
         if (!var5.method_31574(Items.field_8102) && !var5.method_31574(Items.field_8399)) {
            boolean var7 = var6 == Hand.field_5808 && vhd(var2);
            return new boolean[]{true, !var7};
         } else {
            return new boolean[]{var6 == Hand.field_5808, var6 == Hand.field_5810};
         }
      }
   }

   private static boolean vhd(ItemStack var0) {
      return var0.method_31574(Items.field_8399) && CrossbowItem.method_7781(var0);
   }
}
