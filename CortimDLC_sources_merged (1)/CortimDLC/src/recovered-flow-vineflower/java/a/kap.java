package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gui.DrawContext;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class kap {
   private static final int kaq = 144;
   private static final float kar = 0.3F;
   private static final long kas = System.nanoTime();
   public static final float F_HEIGHT = 0.435F;
   private static final float kat = 0.016F;
   private static final float kau = -0.011F;
   @Nullable
   private uok kav;
   @Nullable
   private uok kaw;
   @Nullable
   private uok kax;
   @Nullable
   private uok kay;
   private long kaz;
   @Nullable
   private GpuBuffer kba;
   @Nullable
   private GpuBuffer kbb;
   private boolean kbc;
   private static final float[] kbd = new float[]{1.0F, 1.0F, 0.0F, 0.0F};
   private static final List<uok> kbe = new ArrayList<>();
   private static final List<Long> kbf = new ArrayList<>();

   public static float clock() {
      return (float)((System.nanoTime() - kas) / 1.0E9 % 3000.0);
   }

   public boolean draw(DrawContext var1, jza var2, kam var3, float var4, float var5, float var6, boolean var7) {
      if (!this.kbi(var2, var3, var7)) {
         return false;
      } else {
         uut.image(var1, this.kav.view, 0.0F, 0.0F, var4, var5, 0.0F, kbl(var6));
         return true;
      }
   }

   @Nullable
   public GpuTextureView frost() {
      return this.kaw != null && !this.kbc ? this.kaw.view : null;
   }

   public void frosted(DrawContext var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      GpuTextureView var10 = this.frost();
      if (var10 != null) {
         this.frosted(var1, var2, var3, var4, var5, var6, var2, var3, var7, var8, var9);
      }
   }

   public void frosted(DrawContext var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11) {
      GpuTextureView var12 = this.frost();
      if (var12 != null) {
         uut.imageRegion(var1, var12, var2, var3, var4, var5, var6, var7 / var9, var8 / var10, (var7 + var4) / var9, (var8 + var5) / var10, var11, false);
      }
   }

   private boolean kbi(jza var1, kam var2, boolean var3) {
      collect();
      if (!this.kbc && uvq.ensure(uvq.MENU_SCENE)) {
         MinecraftClient var4 = MinecraftClient.method_1551();
         int var5 = Math.max(4, var4.method_22683().method_4489());
         int var6 = Math.max(4, var4.method_22683().method_4506());

         try {
            this.kbk(var5, var6);
            GpuDevice var7 = RenderSystem.getDevice();
            if (this.kba == null) {
               this.kba = var7.createBuffer(() -> a.d("ㄿ䢤쉴尝힏儬\ueb32拋ﲟ瘵\uf1b3\u0b91蕖᳡隹၃", -1640481002, -1896477057), 136, 144L);
               this.kbb = var7.createBuffer(() -> a.c(474979023, "骙\ue302槒\uf7bb簩慠䂔쥭圹\udd93娕ꀢ⻡띍㴂믴"), 136, 144L);
            }

            CommandEncoder var8 = var7.createCommandEncoder();
            kbj(var8, this.kba, this.kav, var1, var2, var2.blur, var2.dim, var2.motion);
            if (var3) {
               kbj(var8, this.kbb, this.kaw, var1, var2, 1.0F, var2.dim, 0.35F * var2.motion);
            }

            return true;
         } catch (Throwable var9) {
            this.kbc = true;
            System.out.println(a.d("\uef39隀᱘舲র轃㔓볠⊷ꠊ⿌햠孭싇䢞츫琢ﯴ慏\ue71b滥ᒵ驘Ɠ", 304326181, 759056745) + var9);
            var9.printStackTrace();
            return false;
         }
      } else {
         return false;
      }
   }

   private static void kbj(CommandEncoder var0, GpuBuffer var1, uok var2, jza var3, kam var4, float var5, float var6, float var7) {
      float[] var8 = var4.fall != null ? var4.fall : kbd;
      float[] var9 = var4.pool != null ? var4.pool : kbd;
      float[] var10 = var4.shape != null ? var4.shape : kbd;
      if (var3.video()) {
         var7 *= 0.3F;
      }

      boolean var11 = var3.logo();
      float var12 = var4.logoSize > 0.0F ? var4.logoSize : 0.92F;
      float var13 = var4.logoSize > 0.0F ? var4.logoX : 0.5F - 0.016F * var12 * var2.height / var2.width - var4.panX * 1.5F;
      float var14 = var4.logoSize > 0.0F ? var4.logoY : 0.5F - -0.011F * var12 - var4.panY * 1.5F;
      int var15 = var11 ? var3.fill() : 0;
      MemoryStack var16 = MemoryStack.stackPush();

      try {
         var0.writeToBuffer(
            var1.slice(),
            Std140Builder.onStack(var16, 144)
               .putVec4(var2.width, var2.height, (float)var2.width / var2.height, var3.aspect())
               .putVec4(var4.zoom, var4.panX, var4.panY, var5)
               .putVec4(var4.time, var7, var6, var4.grain)
               .putVec4(var8[0], var8[1], var8[2], var8[3])
               .putVec4(var9[0], var9[1], var9[2], var9[3])
               .putVec4((var4.tint >> 16 & 0xFF) / 255.0F, (var4.tint >> 8 & 0xFF) / 255.0F, (var4.tint & 0xFF) / 255.0F, var4.tintAmount)
               .putVec4(var10[0], var10[1], var10[2], var10[3])
               .putVec4(var13, var14, var12, 0.3F)
               .putVec4((var15 >> 16 & 0xFF) / 255.0F, (var15 >> 8 & 0xFF) / 255.0F, (var15 & 0xFF) / 255.0F, var11 ? 1.0F : 0.0F)
               .get()
         );
      } catch (Throwable var22) {
         if (var16 != null) {
            try {
               var16.close();
            } catch (Throwable var20) {
               var22.addSuppressed(var20);
            }
         }

         throw var22;
      }

      if (var16 != null) {
         var16.close();
      }

      RenderPass var23 = var0.createRenderPass(() -> a.b("虏ￔ甄\ueb6d惿\ue65c层햻䯯셅䛃볡㈦ꮑ⇉ꜳ", -94927335), var2.view, OptionalInt.empty());

      try {
         var23.setPipeline(uvq.MENU_SCENE);
         GpuSampler var17 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
         var23.bindTexture(a.b("\uef1c隊ᱤ舧ৼ轐㔟볧⊯", 1378676572), var3.sharp().view, var17);
         var23.bindTexture(a.d("藲ﱭ皧\ue8d1挧\ue5a4忻혗䡔심䔨", -2025718753, 1751873956), var3.blur().view, var17);
         var23.setUniform(a.b("\ua87d퇦嬶앟京젭牸ﮂ旖", -1281972174), var1);
         var23.draw(0, 3);
      } catch (Throwable var21) {
         if (var23 != null) {
            try {
               var23.close();
            } catch (Throwable var19) {
               var21.addSuppressed(var19);
            }
         }

         throw var21;
      }

      if (var23 != null) {
         var23.close();
      }
   }

   private void kbk(int var1, int var2) {
      long var3 = unf.frame();
      if (this.kax != null && var3 - this.kaz > 2L) {
         this.kax.close();
         this.kay.close();
         this.kax = null;
         this.kay = null;
      }

      if (this.kav == null || this.kav.width != var1 || this.kav.height != var2) {
         if (this.kav != null) {
            if (this.kax != null) {
               this.kax.close();
               this.kay.close();
            }

            this.kax = this.kav;
            this.kay = this.kaw;
            this.kaz = var3;
         }

         this.kav = uok.target(a.d("\udb8eꈷ⣯뚅㴇믥Ʀ衑ᘅ鲿", 1740778769, -672205064), var1, var2);
         this.kaw = uok.target(a.d("ⵟ哦\ude3e䁔쯖䴡\uf766纊\ue0c9橿", -1737079946, -1353683378), Math.max(4, var1 / 4), Math.max(4, var2 / 4));
      }
   }

   public void close() {
      for (uok var4 : new uok[]{this.kav, this.kaw, this.kax, this.kay}) {
         if (var4 != null) {
            kbe.add(var4);
            kbf.add(unf.frame());
         }
      }

      this.kav = this.kaw = this.kax = this.kay = null;

      for (GpuBuffer var8 : new GpuBuffer[]{this.kba, this.kbb}) {
         if (var8 != null) {
            var8.close();
         }
      }

      this.kba = this.kbb = null;
   }

   public static void collect() {
      long var0 = unf.frame();

      for (int var2 = kbe.size() - 1; var2 >= 0; var2--) {
         if (var0 - kbf.get(var2) > 3L) {
            kbe.remove(var2).close();
            kbf.remove(var2);
         }
      }
   }

   private static int kbl(float var0) {
      int var1 = Math.max(0, Math.min(255, Math.round(var0 * 255.0F)));
      return var1 << 24 | 16777215;
   }
}
