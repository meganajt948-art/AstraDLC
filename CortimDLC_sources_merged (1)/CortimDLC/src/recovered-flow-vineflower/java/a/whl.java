package a;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage.Format;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class whl {
   public static final String PREFIX = "video:";
   private static final int whm = 4;
   private static final int whn = 64;
   private static final boolean who = false;
   private static final long whp = 2000000000L;
   private static final long whq = 4000000000L;
   private static final long whr = 250000000L;
   private static final long whs = 1000000000L;
   private static final Map<String, whl> wht = new HashMap<>();
   private static final List<uok> whu = new ArrayList<>();
   private static final List<Long> whv = new ArrayList<>();
   private static boolean whw;
   private final String whx;
   private volatile long why;
   private volatile boolean whz;
   private volatile whh/* @Nullable */ wia;
   private long wib;
   private whh/* @Nullable */ wic;
   private long wid;
   private @Nullable GpuTexture wie;
   private @Nullable GpuTexture wif;
   private @Nullable GpuTextureView wig;
   private @Nullable GpuTextureView wih;
   private int wii;
   private int wij;
   private long wik;
   private @Nullable uok wil;
   private long wim = -1L;
   private @Nullable uok win;
   private long wio = -1L;
   private @Nullable uok wip;
   private long wiq = -1L;
   private long wir;
   private final float[] wis = new float[4];
   private int wit;
   private @Nullable GpuBuffer wiu;
   private boolean wiv;

   private whl(String var1) {
      this.whx = var1;
   }

   public static whl get(String var0) {
      return wht.computeIfAbsent(var0, whl::new);
   }

   public static boolean is(String var0) {
      return var0 != null && var0.startsWith("video:");
   }

   public static String poster(String var0) {
      return "/flow/video/" + var0 + ".jpg";
   }

   public static void warm(String... var0) {
      for (String var4 : var0) {
         if (!whw && is(var4) && wjh.available()) {
            whw = true;
            Thread var5 = new Thread(get(var4.substring("video:".length()))::wiy, "Flow2 video warm-up");
            var5.setDaemon(true);
            var5.setPriority(1);
            var5.start();
         }
      }
   }

   private void wiy() {
      boolean var1 = false;

      try {
         wet.startThread();
         var1 = true;

         try (wet var2 = new wet(this.wjg(), false)) {
            var2.read(ByteBuffer.allocateDirect(var2.width * var2.height), ByteBuffer.allocateDirect(var2.width * var2.height / 2));
         }
      } catch (Throwable var12) {
      } finally {
         if (var1) {
            wet.endThread();
         }
      }
   }

   public @Nullable uok frame() {
      if (!this.wiz()) {
         return null;
      }

      if (this.wil == null || this.wil.width != this.wii || this.wil.height != this.wij) {
         wjf(this.wil);
         this.wil = uok.target("video " + this.whx, this.wii, this.wij);
         this.wim = -1L;
      }

      if (this.wim != this.wik) {
         if (!this.wjc(this.wil, 0.0F, 0.0F, 1.0F, 1.0F)) {
            return null;
         }

         this.wim = this.wik;
      }

      return this.wil;
   }

   public @Nullable GpuTextureView fitted(int var1, int var2) {
      uok var3 = this.fittedImage(var1, var2);
      return var3 == null ? null : var3.view;
   }

   public @Nullable uok fittedImage(int var1, int var2) {
      if (var1 >= 4 && var2 >= 4 && this.wiz()) {
         if (this.win == null || this.win.width != var1 || this.win.height != var2) {
            wjf(this.win);
            this.win = uok.target("video fit " + this.whx, var1, var2);
            this.wio = -1L;
         }

         if (this.wio != this.wik) {
            float var3 = (float)this.wii / this.wij;
            float var4 = (float)var1 / var2;
            float var5 = var4 < var3 ? (1.0F - var4 / var3) * 0.5F : 0.0F;
            float var6 = var4 < var3 ? 0.0F : (1.0F - var3 / var4) * 0.5F;
            if (!this.wjc(this.win, var5, var6, 1.0F - var5, 1.0F - var6)) {
               return null;
            }

            this.wio = this.wik;
         }

         return this.win;
      } else {
         return null;
      }
   }

   public @Nullable GpuTextureView placed(int var1, int var2, float var3, float var4, float var5, int var6) {
      if (var1 >= 4 && var2 >= 4 && this.wiz()) {
         if (this.wip == null || this.wip.width != var1 || this.wip.height != var2) {
            wjf(this.wip);
            this.wip = uok.target("video placed " + this.whx, var1, var2);
            this.wiq = -1L;
         }

         long var7 = Float.floatToIntBits(var3) * 31L + Float.floatToIntBits(var4) * 17L + Float.floatToIntBits(var5) + var6 + var1 * 7919L + var2 * 104729L;
         if (this.wiq != this.wik || this.wir != var7) {
            this.wis[0] = var3;
            this.wis[1] = var4;
            this.wis[2] = var5;
            this.wis[3] = 0.3F;
            this.wit = var6;
            float var9 = var5 * var2;
            float var10 = var9 * ((float)this.wii / Math.max(1, this.wij));
            float var11 = var3 * var1 - var10 * 0.5F;
            float var12 = var4 * var2 - var9 * 0.5F;
            boolean var13 = this.wjc(this.wip, -var11 / var10, -var12 / var9, (var1 - var11) / var10, (var2 - var12) / var9);
            this.wis[2] = 0.0F;
            if (!var13) {
               return null;
            }

            this.wiq = this.wik;
            this.wir = var7;
         }

         return this.wip.view;
      } else {
         return null;
      }
   }

   public static void tick() {
      long var0 = System.nanoTime();
      MinecraftClient var2 = MinecraftClient.getInstance();
      boolean var3 = var2 != null && !var2.isWindowFocused();

      for (whl var5 : wht.values()) {
         whh var6 = var5.wia;
         if (var3 && var6 != null && !var6.done && var0 - var5.why < 2000000000L) {
            var5.why = var0;
         }

         if ((var6 == null || var6.done) && var0 - var5.why > 4000000000L) {
            var5.wjd();
         }
      }

      long var7 = unf.frame();

      for (int var8 = whu.size() - 1; var8 >= 0; var8--) {
         if (var7 - whv.get(var8) > 3L) {
            whu.remove(var8).close();
            whv.remove(var8);
         }
      }
   }

   public static void stopAll() {
      for (whl var1 : wht.values()) {
         var1.whz = true;

         try {
            var1.wjd();
         } catch (Throwable var4) {
         }
      }

      for (uok var6 : whu) {
         try {
            var6.close();
         } catch (Throwable var3) {
         }
      }

      whu.clear();
      whv.clear();
   }

   private boolean wiz() {
      long var1 = System.nanoTime();
      this.why = var1;
      if (!this.whz) {
         whh var3 = this.wia;
         if ((var3 == null || var3.done) && var1 - this.wib > 1000000000L) {
            this.wib = var1;
            var3 = new whh(this);
            this.wia = var3;
            Thread var4 = new Thread(var3, "Flow2 video " + this.whx);
            var4.setDaemon(true);
            var4.start();
         }

         if (var3 != null) {
            this.wja(var3, var1);
         }
      }

      return this.wig != null && uvq.ensure(uvq.VIDEO);
   }

   private void wja(whh var1, long var2) {
      whe var4 = null;

      whe var5;
      while ((var5 = var1.ready.peek()) != null) {
         if (this.wic != var1) {
            this.wic = var1;
            this.wid = var2 - var5.pts;
         }

         long var6 = this.wid + var5.pts;
         if (var2 - var6 > 250000000L || var6 - var2 > 2000000000L) {
            this.wid = var2 - var5.pts;
            var6 = var2;
         }

         if (var6 > var2) {
            break;
         }

         var1.ready.poll();
         if (var4 != null) {
            var1.free.offer(var4);
         }

         var4 = var5;
      }

      if (var4 != null) {
         try {
            this.wjb(var4);
         } finally {
            var1.free.offer(var4);
         }
      }
   }

   private void wjb(whe var1) {
      GpuDevice var2 = RenderSystem.getDevice();
      if (this.wie == null || this.wii != var1.width || this.wij != var1.height) {
         this.wje();
         this.wii = var1.width;
         this.wij = var1.height;
         byte var3 = 5;
         this.wie = var2.createTexture(() -> "Flow2 video luma", var3, TextureFormat.RED8, this.wii, this.wij, 1, 1);
         this.wif = var2.createTexture(() -> "Flow2 video chroma", var3, TextureFormat.RED8, this.wii, this.wij / 2, 1, 1);
         this.wig = var2.createTextureView(this.wie);
         this.wih = var2.createTextureView(this.wif);
      }

      CommandEncoder var4 = var2.createCommandEncoder();
      var4.writeToTexture(this.wie, var1.y.clear(), Format.LUMINANCE, 0, 0, 0, 0, this.wii, this.wij);
      var4.writeToTexture(this.wif, var1.uv.clear(), Format.LUMINANCE, 0, 0, 0, 0, this.wii, this.wij / 2);
      this.wik++;
   }

   private boolean wjc(uok var1, float var2, float var3, float var4, float var5) {
      try {
         GpuDevice var6 = RenderSystem.getDevice();
         if (this.wiu == null) {
            this.wiu = var6.createBuffer(() -> "Flow2 video", 136, 64L);
         }

         CommandEncoder var7 = var6.createCommandEncoder();
         MemoryStack var8 = MemoryStack.stackPush();

         try {
            var7.writeToBuffer(
               this.wiu.slice(),
               Std140Builder.onStack(var8, 64)
                  .putVec4(this.wii, this.wij, var1.width, var1.height)
                  .putVec4(var2, var3, var4, var5)
                  .putVec4(this.wis[0], this.wis[1], Math.max(0.01F, this.wis[2]), this.wis[3])
                  .putVec4((this.wit >> 16 & 0xFF) / 255.0F, (this.wit >> 8 & 0xFF) / 255.0F, (this.wit & 0xFF) / 255.0F, this.wis[2] > 0.0F ? 1.0F : 0.0F)
                  .get()
            );
         } catch (Throwable var14) {
            if (var8 != null) {
               try {
                  var8.close();
               } catch (Throwable var12) {
                  var14.addSuppressed(var12);
               }
            }

            throw var14;
         }

         if (var8 != null) {
            var8.close();
         }

         try (RenderPass var16 = var7.createRenderPass(() -> "Flow2 video", var1.view, OptionalInt.empty())) {
            var16.setPipeline(uvq.VIDEO);
            var16.bindTexture("YSampler", this.wig, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
            var16.bindTexture("UVSampler", this.wih, RenderSystem.getSamplerCache().get(FilterMode.NEAREST));
            var16.setUniform("FlowVideo", this.wiu);
            var16.draw(0, 3);
         }

         return true;
      } catch (Throwable var15) {
         this.whz = true;
         System.out.println("video " + this.whx + " can't be drawn: " + var15);
         return false;
      }
   }

   private void wjd() {
      if (this.wie != null || this.wil != null || this.win != null || this.wip != null || this.wiu != null) {
         this.wje();
         if (this.wil != null) {
            this.wil.close();
            this.wil = null;
         }

         if (this.win != null) {
            this.win.close();
            this.win = null;
         }

         if (this.wip != null) {
            this.wip.close();
            this.wip = null;
         }

         this.wiq = -1L;
         if (this.wiu != null) {
            this.wiu.close();
            this.wiu = null;
         }

         this.wim = this.wio = -1L;
      }
   }

   private void wje() {
      if (this.wig != null) {
         this.wig.close();
         this.wih.close();
         this.wie.close();
         this.wif.close();
      }

      this.wig = this.wih = null;
      this.wie = this.wif = null;
   }

   private static void wjf(@Nullable uok var0) {
      if (var0 != null) {
         whu.add(var0);
         whv.add(unf.frame());
      }
   }

   private byte[] wjg() throws IOException {
      return eul.bytes("video/" + this.whx + ".mp4");
   }
}
