/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.GpuQuery
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.VertexFormats;
import a.SkyStyle;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.GpuQuery;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayDeque;
import java.util.OptionalInt;
import java.util.OptionalLong;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class SkyPass {
    private static final int uxj = 128;
    private static @Nullable GpuBuffer uxk;
    private static boolean uxl;
    private static boolean uxm;
    private static final ArrayDeque<GpuQuery> uxn;
    private static long uxo;
    private static int uxp;
    private static /* synthetic */ boolean uxq;
    private static /* synthetic */ String uxr;

    private SkyPass() {
    }

    public static boolean draw(Matrix4f matrix4f, SkyStyle uxt2, float f, float f2, float f3, int n, int n2, int n3, float f4) {
        if (uxl || !VertexFormats.ensure(VertexFormats.SKY)) {
            return false;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        GpuBufferSlice gpuBufferSlice2 = RenderSystem.getShaderFog();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        GpuTextureView gpuTextureView2 = class_2762.method_71640();
        if (gpuBufferSlice == null || gpuBufferSlice2 == null || gpuTextureView == null || gpuTextureView2 == null || class_2762.field_1482 < 4 || class_2762.field_1481 < 4) {
            return false;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            if (uxk == null) {
                uxk = gpuDevice.createBuffer(() -> "Flow2 sky", 136, 128L);
            }
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                commandEncoder.writeToBuffer(uxk.slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)128).putVec4((float)class_2762.field_1482, (float)class_2762.field_1481, 1.0f / (float)class_2762.field_1482, 1.0f / (float)class_2762.field_1481).putMat4f((Matrix4fc)matrix4f).putVec4((float)uxt2.id(), f, f2, f3).putVec4(SkyPass.r(n), SkyPass.g(n), SkyPass.b(n), (float)n3).putVec4(SkyPass.r(n2), SkyPass.g(n2), SkyPass.b(n2), f4).get());
            }
            memoryStack = uxm ? commandEncoder.timerQueryBegin() : null;
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 sky", gpuTextureView, OptionalInt.empty());){
                renderPass.setPipeline(VertexFormats.SKY);
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("Fog", gpuBufferSlice2);
                renderPass.setUniform("FlowSky", uxk);
                renderPass.draw(0, 3);
            }
            if (memoryStack != null) {
                commandEncoder.timerQueryEnd((GpuQuery)memoryStack);
                uxn.add((GpuQuery)memoryStack);
            }
            SkyPass.uxs();
            return true;
        }
        catch (Throwable throwable) {
            uxl = true;
            System.out.println("shader sky failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    public static void timing(boolean bl) {
        uxm = bl;
        uxo = 0L;
        uxp = 0;
    }

    public static double gpuMillis() {
        SkyPass.uxs();
        double d = uxp == 0 ? -1.0 : (double)uxo / 1000000.0 / (double)uxp;
        uxo = 0L;
        uxp = 0;
        return d;
    }

    private static void uxs() {
        while (!uxn.isEmpty()) {
            OptionalLong optionalLong = uxn.peek().getValue();
            if (optionalLong.isEmpty()) {
                if (uxn.size() < 8) {
                    return;
                }
                uxn.poll().close();
                continue;
            }
            uxn.poll().close();
            uxo += optionalLong.getAsLong();
            ++uxp;
        }
    }

    public static void release() {
        uxl = false;
    }

    static float r(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    static float g(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    static float b(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    static {
        uxn = new ArrayDeque();
    }

    private static /* synthetic */ int dbt(int n, int n2) {
        return n - n2 + -1462873358;
    }

    private static /* synthetic */ int dbu(int n, int n2) {
        return n + n2 + 1173750610;
    }

    private static /* synthetic */ int dbv(int n, int n2) {
        return SkyPass.dbu(n, n2) ^ 0xCF131026;
    }
}

