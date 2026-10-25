/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.unf;
import a.uok;
import a.uvq;
import a.uxi;
import a.uxt;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.OptionalInt;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class upi {
    private static final int upj = 64;
    private static @Nullable uok upk;
    private static @Nullable uok upl;
    private static long upm;
    private static @Nullable GpuBuffer upn;
    private static boolean upo;
    private static /* synthetic */ String upp;
    private static /* synthetic */ String upq;

    private upi() {
    }

    public static @Nullable GpuTextureView sky(uxt uxt2, int n, int n2, float f) {
        uok uok2 = upi.upr(n, n2);
        return uok2 != null && upi.ups(uok2, uxt2, null, f, 0.0f, false, uxt2.color1) ? uok2.view : null;
    }

    public static @Nullable GpuTextureView photo(uok uok2, float f, float f2, boolean bl, int n) {
        uok uok3 = upi.upr(uok2.width, uok2.height);
        return uok3 != null && upi.ups(uok3, null, uok2.view, f, f2, bl, n) ? uok3.view : null;
    }

    public static @Nullable uok still(uxt uxt2, int n, int n2, float f) {
        if (upo) {
            return null;
        }
        uok uok2 = uok.target("sky thumb", n, n2);
        if (upi.ups(uok2, uxt2, null, f, 0.0f, false, uxt2.color1)) {
            return uok2;
        }
        uok2.close();
        return null;
    }

    private static @Nullable uok upr(int n, int n2) {
        if (upo || n < 4 || n2 < 4) {
            return null;
        }
        long l = unf.frame();
        if (upl != null && l - upm > 2L) {
            upl.close();
            upl = null;
        }
        if (upk == null || upi.upk.width != n || upi.upk.height != n2) {
            if (upk != null) {
                if (upl != null) {
                    upl.close();
                }
                upl = upk;
                upm = l;
            }
            upk = uok.target("live wallpaper", n, n2);
        }
        return upk;
    }

    private static boolean ups(uok uok2, @Nullable uxt uxt2, @Nullable GpuTextureView gpuTextureView, float f, float f2, boolean bl, int n) {
        RenderPipeline renderPipeline;
        RenderPipeline renderPipeline2 = renderPipeline = uxt2 != null ? uvq.WALL_SKY : uvq.WALL_PHOTO;
        if (!uvq.ensure(renderPipeline)) {
            return false;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            if (upn == null) {
                upn = gpuDevice.createBuffer(() -> "Flow2 live wallpaper", 136, 64L);
            }
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            int n2 = uxt2 != null ? uxt2.color1 : n;
            int n3 = uxt2 != null ? uxt2.color2 : n;
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                commandEncoder.writeToBuffer(upn.slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)64).putVec4((float)uok2.width, (float)uok2.height, (float)uok2.width / (float)uok2.height, 0.0f).putVec4(uxt2 != null ? (float)uxt2.id() : 0.0f, f, f2, bl ? 1.0f : 0.0f).putVec4(uxi.r(n2), uxi.g(n2), uxi.b(n2), 4.0f).putVec4(uxi.r(n3), uxi.g(n3), uxi.b(n3), uxt2 != null ? uxt2.stars : 0.0f).get());
            }
            memoryStack = commandEncoder.createRenderPass(() -> "Flow2 live wallpaper", uok2.view, OptionalInt.empty());
            try {
                memoryStack.setPipeline(renderPipeline);
                if (gpuTextureView != null) {
                    memoryStack.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
                }
                memoryStack.setUniform("FlowWall", upn);
                memoryStack.draw(0, 3);
            }
            finally {
                if (memoryStack != null) {
                    memoryStack.close();
                }
            }
            return true;
        }
        catch (Throwable throwable) {
            upo = true;
            System.out.println("live wallpaper failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    private static /* synthetic */ int czr(int n, int n2) {
        return n - n2 ^ 0x5E7C23ED;
    }
}

