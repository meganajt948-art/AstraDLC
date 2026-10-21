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
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  net.minecraft.class_1011
 *  net.minecraft.class_1011$class_1012
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.VertexFormats;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.GpuQuery;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.function.Consumer;
import net.minecraft.class_1011;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class FogPass {
    public static final int UNIFORM_SIZE = 624;
    private static final int vag = 256;
    private static @Nullable GpuTexture vah;
    private static @Nullable GpuTextureView vai;
    private static final GpuTexture[] vaj;
    private static final GpuTextureView[] vak;
    private static @Nullable GpuBuffer val;
    private static int vam;
    private static int van;
    private static int vao;
    private static boolean vap;
    private static int vaq;
    private static boolean var;
    private static boolean vas;
    private static final ArrayDeque<GpuQuery> vat;
    private static long vau;
    private static int vav;
    private static /* synthetic */ String vaw;
    private static /* synthetic */ boolean vax;

    private FogPass() {
    }

    public static boolean draw(float f, boolean bl, Consumer<Std140Builder> consumer) {
        if (var || !VertexFormats.ensure(VertexFormats.FOG_MARCH) || !VertexFormats.ensure(VertexFormats.FOG_RESOLVE) || !VertexFormats.ensure(VertexFormats.FOG_COMPOSITE)) {
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
            ByteBuffer byteBuffer;
            Std140Builder std140Builder;
            int n = Math.max(1, Math.round((float)class_2762.field_1482 * f));
            int n2 = Math.max(1, Math.round((float)class_2762.field_1481 * f));
            FogPass.vaz(n, n2);
            GpuDevice gpuDevice = RenderSystem.getDevice();
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            vaq = vaq + 1 & 0x3FF;
            boolean bl2 = vap && bl;
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                std140Builder = Std140Builder.onStack((MemoryStack)memoryStack, (int)624).putVec4((float)n, (float)n2, (float)class_2762.field_1482, (float)class_2762.field_1481).putVec4((float)vaq, bl2 ? 1.0f : 0.0f, 0.0f, 0.0f);
                consumer.accept(std140Builder);
                byteBuffer = std140Builder.get();
                commandEncoder.writeToBuffer(val.slice(), byteBuffer);
            }
            memoryStack = vak[0];
            std140Builder = vak[vao];
            byteBuffer = vak[3 - vao];
            GpuQuery gpuQuery = vas ? commandEncoder.timerQueryBegin() : null;
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 fog march", (GpuTextureView)memoryStack, OptionalInt.empty());){
                renderPass.setPipeline(VertexFormats.FOG_MARCH);
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("NoiseSampler", vai, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("Fog", gpuBufferSlice2);
                renderPass.setUniform("FlowFog", val);
                renderPass.draw(0, 3);
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 fog resolve", (GpuTextureView)byteBuffer, OptionalInt.empty());
            try {
                renderPass.setPipeline(VertexFormats.FOG_RESOLVE);
                renderPass.bindTexture("RawSampler", (GpuTextureView)memoryStack, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("HistorySampler", (GpuTextureView)std140Builder, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowFog", val);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 fog composite", gpuTextureView, OptionalInt.empty());
            try {
                renderPass.setPipeline(VertexFormats.FOG_COMPOSITE);
                renderPass.bindTexture("FogSampler", (GpuTextureView)byteBuffer, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowFog", val);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            if (gpuQuery != null) {
                commandEncoder.timerQueryEnd(gpuQuery);
                vat.add(gpuQuery);
            }
            vao = 3 - vao;
            vap = true;
            FogPass.vay();
            return true;
        }
        catch (Throwable throwable) {
            var = true;
            System.out.println("volumetric fog failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    public static void timing(boolean bl) {
        vas = bl;
        vau = 0L;
        vav = 0;
    }

    public static double gpuMillis() {
        FogPass.vay();
        double d = vav == 0 ? -1.0 : (double)vau / 1000000.0 / (double)vav;
        vau = 0L;
        vav = 0;
        return d;
    }

    private static void vay() {
        while (!vat.isEmpty()) {
            OptionalLong optionalLong = vat.peek().getValue();
            if (optionalLong.isEmpty()) {
                if (vat.size() < 8) {
                    return;
                }
                vat.poll().close();
                continue;
            }
            vat.poll().close();
            vau += optionalLong.getAsLong();
            ++vav;
        }
    }

    public static void release() {
        for (int i = 0; i < vak.length; ++i) {
            if (vak[i] != null) {
                vak[i].close();
                FogPass.vak[i] = null;
            }
            if (vaj[i] == null) continue;
            vaj[i].close();
            FogPass.vaj[i] = null;
        }
        vam = -1;
        van = -1;
        vap = false;
        var = false;
    }

    private static void vaz(int n, int n2) {
        GpuDevice gpuDevice = RenderSystem.getDevice();
        if (val == null) {
            val = gpuDevice.createBuffer(() -> "Flow2 fog", 136, 624L);
        }
        if (vai == null) {
            FogPass.vba(gpuDevice);
        }
        if (vak[0] != null && n == vam && n2 == van) {
            return;
        }
        FogPass.release();
        int n3 = 12;
        for (int i = 0; i < vaj.length; ++i) {
            int n4 = i;
            FogPass.vaj[i] = gpuDevice.createTexture(() -> "Flow2 fog " + n4, n3, TextureFormat.RGBA8, n, n2, 1, 1);
            FogPass.vak[i] = gpuDevice.createTextureView(vaj[i]);
        }
        vam = n;
        van = n2;
    }

    private static void vba(GpuDevice gpuDevice) {
        Random random = new Random(99540742L);
        int[] nArray = new int[65536];
        int[] nArray2 = new int[65536];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = random.nextInt(256);
            nArray2[i] = random.nextInt(256);
        }
        try (class_1011 class_10112 = new class_1011(class_1011.class_1012.field_4997, 256, 256, false);){
            int n;
            for (n = 0; n < 256; ++n) {
                for (int i = 0; i < 256; ++i) {
                    int n2 = (n + 17 & 0xFF) * 256 + (i + 37 & 0xFF);
                    int n3 = n * 256 + i;
                    class_10112.method_61941(i, n, nArray2[n3] << 24 | nArray[n2] << 16 | nArray[n3] << 8 | nArray2[n2]);
                }
            }
            n = 5;
            vah = gpuDevice.createTexture(() -> "Flow2 fog noise", n, TextureFormat.RGBA8, 256, 256, 1, 1);
            vai = gpuDevice.createTextureView(vah);
            gpuDevice.createCommandEncoder().writeToTexture(vah, class_10112);
        }
    }

    static {
        vaj = new GpuTexture[3];
        vak = new GpuTextureView[3];
        vam = -1;
        van = -1;
        vao = 1;
        vat = new ArrayDeque();
    }

    private static /* synthetic */ int dcj(int n, int n2) {
        return n ^ n2 ^ 0x164CEA22;
    }
}

