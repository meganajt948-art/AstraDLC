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
 *  net.minecraft.class_12137
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.jza;
import a.kam;
import a.FrameDelta;
import a.GpuTexture;
import a.DrawUtil;
import a.VertexFormats;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import net.minecraft.class_12137;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class MenuSceneRenderer {
    private static final int kaq = 144;
    private static final float kar = 0.3f;
    private static final long kas = System.nanoTime();
    public static final float F_HEIGHT = 0.435f;
    private static final float kat = 0.016f;
    private static final float kau = -0.011f;
    private @Nullable GpuTexture kav;
    private @Nullable GpuTexture kaw;
    private @Nullable GpuTexture kax;
    private @Nullable GpuTexture kay;
    private long kaz;
    private @Nullable GpuBuffer kba;
    private @Nullable GpuBuffer kbb;
    private boolean kbc;
    private static final float[] kbd = new float[]{1.0f, 1.0f, 0.0f, 0.0f};
    private static final List<GpuTexture> kbe = new ArrayList<GpuTexture>();
    private static final List<Long> kbf = new ArrayList<Long>();
    private static /* synthetic */ String kbg;
    private static /* synthetic */ int kbh;

    public static float clock() {
        return (float)((double)(System.nanoTime() - kas) / 1.0E9 % 3000.0);
    }

    public boolean draw(class_332 class_3322, jza jza2, kam kam2, float f, float f2, float f3, boolean bl) {
        if (!this.kbi(jza2, kam2, bl)) {
            return false;
        }
        DrawUtil.image(class_3322, this.kav.view, 0.0f, 0.0f, f, f2, 0.0f, MenuSceneRenderer.kbl(f3));
        return true;
    }

    public @Nullable GpuTextureView frost() {
        return this.kaw != null && !this.kbc ? this.kaw.view : null;
    }

    public void frosted(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7, int n) {
        GpuTextureView gpuTextureView = this.frost();
        if (gpuTextureView == null) {
            return;
        }
        this.frosted(class_3322, f, f2, f3, f4, f5, f, f2, f6, f7, n);
    }

    public void frosted(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n) {
        GpuTextureView gpuTextureView = this.frost();
        if (gpuTextureView == null) {
            return;
        }
        DrawUtil.imageRegion(class_3322, gpuTextureView, f, f2, f3, f4, f5, f6 / f8, f7 / f9, (f6 + f3) / f8, (f7 + f4) / f9, n, false);
    }

    private boolean kbi(jza jza2, kam kam2, boolean bl) {
        MenuSceneRenderer.collect();
        if (this.kbc || !VertexFormats.ensure(VertexFormats.MENU_SCENE)) {
            return false;
        }
        class_310 class_3102 = class_310.method_1551();
        int n = Math.max(4, class_3102.method_22683().method_4489());
        int n2 = Math.max(4, class_3102.method_22683().method_4506());
        try {
            this.kbk(n, n2);
            GpuDevice gpuDevice = RenderSystem.getDevice();
            if (this.kba == null) {
                this.kba = gpuDevice.createBuffer(() -> "Flow2 menu scene", 136, 144L);
                this.kbb = gpuDevice.createBuffer(() -> "Flow2 menu frost", 136, 144L);
            }
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            MenuSceneRenderer.kbj(commandEncoder, this.kba, this.kav, jza2, kam2, kam2.blur, kam2.dim, kam2.motion);
            if (bl) {
                MenuSceneRenderer.kbj(commandEncoder, this.kbb, this.kaw, jza2, kam2, 1.0f, kam2.dim, 0.35f * kam2.motion);
            }
            return true;
        }
        catch (Throwable throwable) {
            this.kbc = true;
            System.out.println("menu background failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    private static void kbj(CommandEncoder commandEncoder, GpuBuffer gpuBuffer, GpuTexture uok2, jza jza2, kam kam2, float f, float f2, float f3) {
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
        memoryStack = commandEncoder.createRenderPass(() -> "Flow2 menu scene", uok2.view, OptionalInt.empty());
        try {
            memoryStack.setPipeline(VertexFormats.MENU_SCENE);
            class_12137 class_121372 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
            memoryStack.bindTexture("InSampler", jza2.sharp().view, class_121372);
            memoryStack.bindTexture("BlurSampler", jza2.blur().view, class_121372);
            memoryStack.setUniform("FlowScene", gpuBuffer);
            memoryStack.draw(0, 3);
        }
        finally {
            if (memoryStack != null) {
                memoryStack.close();
            }
        }
    }

    private void kbk(int n, int n2) {
        long l = FrameDelta.frame();
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
        this.kav = GpuTexture.target("menu scene", n, n2);
        this.kaw = GpuTexture.target("menu frost", Math.max(4, n / 4), Math.max(4, n2 / 4));
    }

    public void close() {
        for (GpuTexture uok2 : new GpuTexture[]{this.kav, this.kaw, this.kax, this.kay}) {
            if (uok2 == null) continue;
            kbe.add(uok2);
            kbf.add(FrameDelta.frame());
        }
        this.kay = null;
        this.kax = null;
        this.kaw = null;
        this.kav = null;
        for (GpuTexture uok2 : new GpuBuffer[]{this.kba, this.kbb}) {
            if (uok2 == null) continue;
            uok2.close();
        }
        this.kbb = null;
        this.kba = null;
    }

    public static void collect() {
        long l = FrameDelta.frame();
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

