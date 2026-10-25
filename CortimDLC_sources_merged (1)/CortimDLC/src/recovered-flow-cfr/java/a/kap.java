/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.GpuSampler
 *  net.minecraft.client.gui.DrawContext
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.jza;
import a.kam;
import a.unf;
import a.uok;
import a.uut;
import a.uvq;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
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
    private static final float kar = 0.3f;
    private static final long kas = System.nanoTime();
    public static final float F_HEIGHT = 0.435f;
    private static final float kat = 0.016f;
    private static final float kau = -0.011f;
    private @Nullable uok kav;
    private @Nullable uok kaw;
    private @Nullable uok kax;
    private @Nullable uok kay;
    private long kaz;
    private @Nullable GpuBuffer kba;
    private @Nullable GpuBuffer kbb;
    private boolean kbc;
    private static final float[] kbd = new float[]{1.0f, 1.0f, 0.0f, 0.0f};
    private static final List<uok> kbe = new ArrayList<uok>();
    private static final List<Long> kbf = new ArrayList<Long>();
    private static /* synthetic */ String kbg;
    private static /* synthetic */ int kbh;

    public static float clock() {
        return (float)((double)(System.nanoTime() - kas) / 1.0E9 % 3000.0);
    }

    public boolean draw(DrawContext drawContext, jza jza2, kam kam2, float f, float f2, float f3, boolean bl) {
        if (!this.kbi(jza2, kam2, bl)) {
            return false;
        }
        uut.image(drawContext, this.kav.view, 0.0f, 0.0f, f, f2, 0.0f, kap.kbl(f3));
        return true;
    }

    public @Nullable GpuTextureView frost() {
        return this.kaw != null && !this.kbc ? this.kaw.view : null;
    }

    public void frosted(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, float f7, int n) {
        GpuTextureView gpuTextureView = this.frost();
        if (gpuTextureView == null) {
            return;
        }
        this.frosted(drawContext, f, f2, f3, f4, f5, f, f2, f6, f7, n);
    }

    public void frosted(DrawContext drawContext, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n) {
        GpuTextureView gpuTextureView = this.frost();
        if (gpuTextureView == null) {
            return;
        }
        uut.imageRegion(drawContext, gpuTextureView, f, f2, f3, f4, f5, f6 / f8, f7 / f9, (f6 + f3) / f8, (f7 + f4) / f9, n, false);
    }

    private boolean kbi(jza jza2, kam kam2, boolean bl) {
        kap.collect();
        if (this.kbc || !uvq.ensure(uvq.MENU_SCENE)) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        int n = Math.max(4, minecraftClient.method_22683().method_4489());
        int n2 = Math.max(4, minecraftClient.method_22683().method_4506());
        try {
            this.kbk(n, n2);
            GpuDevice gpuDevice = RenderSystem.getDevice();
            if (this.kba == null) {
                this.kba = gpuDevice.createBuffer(() -> a.d("\u313f\u48a4\uc274\u5c1d\ud78f\u512c\ueb32\u62cb\ufc9f\u7635\uf1b3\u0b91\u8556\u1ce1\u96b9\u1043", -1640481002, -1896477057), 136, 144L);
                this.kbb = gpuDevice.createBuffer(() -> a.c(474979023, "\u9a99\ue302\u69d2\uf7bb\u7c29\ufa8a\u4094\uc96d\u5739\udd93\u5a15\ua022\u2ee1\ub74d\u3d02\ubbf4"), 136, 144L);
            }
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            kap.kbj(commandEncoder, this.kba, this.kav, jza2, kam2, kam2.blur, kam2.dim, kam2.motion);
            if (bl) {
                kap.kbj(commandEncoder, this.kbb, this.kaw, jza2, kam2, 1.0f, kam2.dim, 0.35f * kam2.motion);
            }
            return true;
        }
        catch (Throwable throwable) {
            this.kbc = true;
            System.out.println(a.d("\uef39\u9680\u1c58\u8232\u09b0\u8f43\u3513\ubce0\u22b7\ua80a\u2fcc\ud5a0\u5b6d\uc2c7\u489e\uce2b\u7422\ufbf4\u614f\ue71b\u6ee5\u14b5\u9a58\u0193", 304326181, 759056745) + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    private static void kbj(CommandEncoder commandEncoder, GpuBuffer gpuBuffer, uok uok2, jza jza2, kam kam2, float f, float f2, float f3) {
        float[] fArray;
        float[] fArray2 = kam2.fall != null ? kam2.fall : kbd;
        float[] fArray3 = kam2.pool != null ? kam2.pool : kbd;
        float[] fArray4 = fArray = kam2.shape != null ? kam2.shape : kbd;
        if (jza2.video()) {
            f3 *= 0.3f;
        }
        boolean bl = jza2.logo();
        float f4 = kam2.logoSize > 0.0f ? kam2.logoSize : 0.92f;
        float f5 = kam2.logoSize > 0.0f ? kam2.logoX : 0.5f - 0.016f * f4 * (float)uok2.height / (float)uok2.width - kam2.panX * 1.5f;
        float f6 = kam2.logoSize > 0.0f ? kam2.logoY : 0.5f - -0.011f * f4 - kam2.panY * 1.5f;
        int n = bl ? jza2.fill() : 0;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            commandEncoder.writeToBuffer(gpuBuffer.slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)144).putVec4((float)uok2.width, (float)uok2.height, (float)uok2.width / (float)uok2.height, jza2.aspect()).putVec4(kam2.zoom, kam2.panX, kam2.panY, f).putVec4(kam2.time, f3, f2, kam2.grain).putVec4(fArray2[0], fArray2[1], fArray2[2], fArray2[3]).putVec4(fArray3[0], fArray3[1], fArray3[2], fArray3[3]).putVec4((float)(kam2.tint >> 16 & 0xFF) / 255.0f, (float)(kam2.tint >> 8 & 0xFF) / 255.0f, (float)(kam2.tint & 0xFF) / 255.0f, kam2.tintAmount).putVec4(fArray[0], fArray[1], fArray[2], fArray[3]).putVec4(f5, f6, f4, 0.3f).putVec4((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, bl ? 1.0f : 0.0f).get());
        }
        memoryStack = commandEncoder.createRenderPass(() -> a.b("\u864f\uffd4\u7504\ueb6d\u60ff\ue65c\u5c42\ud5bb\u4bef\uc145\u46c3\ubce1\u3226\uab91\u21c9\ua733", -94927335), uok2.view, OptionalInt.empty());
        try {
            memoryStack.setPipeline(uvq.MENU_SCENE);
            GpuSampler gpuSampler = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
            memoryStack.bindTexture(a.b("\uef1c\u968a\u1c64\u8227\u09fc\u8f50\u351f\ubce7\u22af", 1378676572), jza2.sharp().view, gpuSampler);
            memoryStack.bindTexture(a.d("\u85f2\ufc6d\u76a7\ue8d1\u6327\ue5a4\u5ffb\ud617\u4854\uc2ec\u4528", -2025718753, 1751873956), jza2.blur().view, gpuSampler);
            memoryStack.setUniform(a.b("\ua87d\ud1e6\u5b36\uc55f\u4eac\uc82d\u7278\ufb82\u65d6", -1281972174), gpuBuffer);
            memoryStack.draw(0, 3);
        }
        finally {
            if (memoryStack != null) {
                memoryStack.close();
            }
        }
    }

    private void kbk(int n, int n2) {
        long l = unf.frame();
        if (this.kax != null && l - this.kaz > 2L) {
            this.kax.close();
            this.kay.close();
            this.kax = null;
            this.kay = null;
        }
        if (this.kav != null && this.kav.width == n && this.kav.height == n2) {
            return;
        }
        if (this.kav != null) {
            if (this.kax != null) {
                this.kax.close();
                this.kay.close();
            }
            this.kax = this.kav;
            this.kay = this.kaw;
            this.kaz = l;
        }
        this.kav = uok.target(a.d("\udb8e\ua237\u28ef\ub685\u3d07\ubbe5\u01a6\u8851\u1605\u9cbf", 1740778769, -672205064), n, n2);
        this.kaw = uok.target(a.d("\u2d5f\u54e6\ude3e\u4054\ucbd6\u4d21\uf766\u7e8a\ue0c9\u6a7f", -1737079946, -1353683378), Math.max(4, n / 4), Math.max(4, n2 / 4));
    }

    public void close() {
        for (uok uok2 : new uok[]{this.kav, this.kaw, this.kax, this.kay}) {
            if (uok2 == null) continue;
            kbe.add(uok2);
            kbf.add(unf.frame());
        }
        this.kay = null;
        this.kax = null;
        this.kaw = null;
        this.kav = null;
        for (uok uok2 : new GpuBuffer[]{this.kba, this.kbb}) {
            if (uok2 == null) continue;
            uok2.close();
        }
        this.kbb = null;
        this.kba = null;
    }

    public static void collect() {
        long l = unf.frame();
        for (int i = kbe.size() - 1; i >= 0; --i) {
            if (l - kbf.get(i) <= 3L) continue;
            kbe.remove(i).close();
            kbf.remove(i);
        }
    }

    private static int kbl(float f) {
        int n = Math.max(0, Math.min(255, Math.round(f * 255.0f)));
        return n << 24 | 0xFFFFFF;
    }

    private static /* synthetic */ int arh(int n, int n2) {
        return n + n2 ^ 0xEEAF3545;
    }
}

