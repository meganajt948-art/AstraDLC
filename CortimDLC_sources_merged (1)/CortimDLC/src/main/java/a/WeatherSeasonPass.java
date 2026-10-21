/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline
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
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.GpuQuery;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.ArrayDeque;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.function.Consumer;
import net.minecraft.class_1011;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class WeatherSeasonPass {
    public static final int UNIFORM_SIZE = 1328;
    public static final int SEASON_UNIFORM_SIZE = 1408;
    public static final int HEIGHT_SIZE = 128;
    private static @Nullable GpuTexture vbc;
    private static @Nullable GpuTextureView vbd;
    private static @Nullable GpuTexture vbe;
    private static @Nullable GpuTextureView vbf;
    private static @Nullable GpuTexture vbg;
    private static @Nullable GpuTextureView vbh;
    private static @Nullable GpuBuffer vbi;
    private static @Nullable GpuBuffer vbj;
    private static @Nullable GpuTexture vbk;
    private static @Nullable GpuTextureView vbl;
    private static @Nullable GpuTexture vbm;
    private static @Nullable GpuTextureView vbn;
    private static int vbo;
    private static int vbp;
    private static int vbq;
    private static int vbr;
    private static boolean vbs;
    private static boolean vbt;
    private static boolean vbu;
    private static boolean vbv;
    private static boolean vbw;
    private static final ArrayDeque<GpuQuery> vbx;
    private static long vby;
    private static int vbz;
    private static /* synthetic */ long vca;
    private static /* synthetic */ int vcb;

    private WeatherSeasonPass() {
    }

    public static boolean draw(Consumer<Std140Builder> consumer) {
        return WeatherSeasonPass.vcc(VertexFormats.WET, false, 1328, "FlowWet", consumer);
    }

    public static boolean drawSeason(Consumer<Std140Builder> consumer) {
        return WeatherSeasonPass.vcc(VertexFormats.SEASON, true, 1408, "FlowSeason", consumer);
    }

    public static @Nullable GpuTextureView heightView() {
        return vbh;
    }

    public static GpuTextureView noiseView(GpuDevice gpuDevice) {
        if (vbf == null) {
            WeatherSeasonPass.vci(gpuDevice);
        }
        return vbf;
    }

    public static @Nullable GpuTextureView terrainDepthView() {
        return vbl;
    }

    public static @Nullable GpuTextureView entityDepthView() {
        return vbn;
    }

    public static void maskUsed() {
        vbt = false;
        vbu = false;
    }

    public static void wantEntityMask(boolean bl) {
        vbs = bl;
        if (!bl) {
            vbt = false;
            vbu = false;
        }
    }

    public static boolean entityMask() {
        class_276 class_2762 = class_310.method_1551().method_1522();
        return vbt && vbu && vbn != null && vbq == class_2762.field_1482 && vbr == class_2762.field_1481;
    }

    public static void captureDepth(boolean bl) {
        if (!vbs || vbv) {
            return;
        }
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTexture gpuTexture = class_2762.method_30278();
        if (gpuTexture == null || class_2762.field_1482 < 4 || class_2762.field_1481 < 4) {
            return;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            WeatherSeasonPass.vcf(gpuDevice, class_2762.field_1482, class_2762.field_1481);
            gpuDevice.createCommandEncoder().copyTextureToTexture(gpuTexture, bl ? vbm : vbk, 0, 0, 0, 0, 0, class_2762.field_1482, class_2762.field_1481);
            if (bl) {
                vbu = vbt;
            } else {
                vbt = true;
                vbu = false;
            }
        }
        catch (Throwable throwable) {
            vbs = false;
            vbt = false;
            vbu = false;
            System.out.println("weather entity mask failed: " + throwable);
        }
    }

    public static void drawParticles(int n) {
        if (vbv || n <= 0 || vbj == null || !VertexFormats.ensure(VertexFormats.SEASON_PARTICLES)) {
            return;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        GpuTextureView gpuTextureView2 = class_2762.method_71640();
        if (gpuBufferSlice == null || gpuTextureView == null || gpuTextureView2 == null || vbh == null) {
            return;
        }
        try {
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            GpuQuery gpuQuery = vbw ? commandEncoder.timerQueryBegin() : null;
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 season particles", gpuTextureView, OptionalInt.empty(), gpuTextureView2, OptionalDouble.empty());){
                renderPass.setPipeline(VertexFormats.SEASON_PARTICLES);
                renderPass.bindTexture("HeightSampler", vbh, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowSeason", vbj);
                renderPass.draw(0, n * 6);
            }
            if (gpuQuery != null) {
                commandEncoder.timerQueryEnd(gpuQuery);
                vbx.add(gpuQuery);
            }
        }
        catch (Throwable throwable) {
            vbv = true;
            System.out.println("season particles failed: " + throwable);
            throwable.printStackTrace();
        }
    }

    public static void gradeSeason() {
        if (vbv || vbj == null || vbd == null || !VertexFormats.ensure(VertexFormats.SEASON_GRADE) || !VertexFormats.ensure(VertexFormats.BLUR_COPY)) {
            return;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        if (gpuBufferSlice == null || gpuTextureView == null || class_2762.field_1482 != vbo || class_2762.field_1481 != vbp) {
            return;
        }
        try {
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            GpuQuery gpuQuery = vbw ? commandEncoder.timerQueryBegin() : null;
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 season grade copy", vbd, OptionalInt.empty());){
                renderPass.setPipeline(VertexFormats.BLUR_COPY);
                renderPass.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.draw(0, 3);
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 season grade", gpuTextureView, OptionalInt.empty());
            try {
                renderPass.setPipeline(VertexFormats.SEASON_GRADE);
                renderPass.bindTexture("SceneSampler", vbd, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowSeason", vbj);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            if (gpuQuery != null) {
                commandEncoder.timerQueryEnd(gpuQuery);
                vbx.add(gpuQuery);
            }
        }
        catch (Throwable throwable) {
            vbv = true;
            System.out.println("season grade failed: " + throwable);
            throwable.printStackTrace();
        }
    }

    private static boolean vcc(RenderPipeline renderPipeline, boolean bl, int n, String string, Consumer<Std140Builder> consumer) {
        if (vbv || !VertexFormats.ensure(renderPipeline) || !VertexFormats.ensure(VertexFormats.BLUR_COPY)) {
            return false;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        GpuBufferSlice gpuBufferSlice2 = RenderSystem.getShaderFog();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        GpuTextureView gpuTextureView2 = class_2762.method_71640();
        if (gpuBufferSlice == null || gpuBufferSlice2 == null || gpuTextureView == null || gpuTextureView2 == null || class_2762.method_30277() == null || class_2762.field_1482 < 4 || class_2762.field_1481 < 4) {
            return false;
        }
        try {
            Std140Builder std140Builder;
            GpuDevice gpuDevice = RenderSystem.getDevice();
            WeatherSeasonPass.vcg(gpuDevice, class_2762.field_1482, class_2762.field_1481);
            GpuBuffer gpuBuffer = bl ? vbj : vbi;
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                std140Builder = Std140Builder.onStack((MemoryStack)memoryStack, (int)n).putVec4((float)class_2762.field_1482, (float)class_2762.field_1481, 1.0f / (float)class_2762.field_1482, 1.0f / (float)class_2762.field_1481);
                consumer.accept(std140Builder);
                commandEncoder.writeToBuffer(gpuBuffer.slice(), std140Builder.get());
            }
            memoryStack = vbw ? commandEncoder.timerQueryBegin() : null;
            std140Builder = commandEncoder.createRenderPass(() -> "Flow2 weather scene copy", vbd, OptionalInt.empty());
            try {
                std140Builder.setPipeline(VertexFormats.BLUR_COPY);
                std140Builder.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                std140Builder.draw(0, 3);
            }
            finally {
                if (std140Builder != null) {
                    std140Builder.close();
                }
            }
            std140Builder = commandEncoder.createRenderPass(() -> "Flow2 weather", gpuTextureView, OptionalInt.empty());
            try {
                std140Builder.setPipeline(renderPipeline);
                std140Builder.bindTexture("SceneSampler", vbd, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                std140Builder.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                std140Builder.bindTexture("NoiseSampler", vbf, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                std140Builder.bindTexture("HeightSampler", vbh, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                if (bl) {
                    boolean bl2 = WeatherSeasonPass.entityMask();
                    std140Builder.bindTexture("TerrainDepthSampler", bl2 ? vbl : gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                    std140Builder.bindTexture("EntityDepthSampler", bl2 ? vbn : gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                }
                std140Builder.setUniform("Projection", gpuBufferSlice);
                std140Builder.setUniform("Fog", gpuBufferSlice2);
                std140Builder.setUniform(string, gpuBuffer);
                std140Builder.draw(0, 3);
            }
            finally {
                if (std140Builder != null) {
                    std140Builder.close();
                }
            }
            if (bl) {
                vbt = false;
                vbu = false;
            }
            if (memoryStack != null) {
                commandEncoder.timerQueryEnd((GpuQuery)memoryStack);
                vbx.add((GpuQuery)memoryStack);
            }
            WeatherSeasonPass.vcd();
            return true;
        }
        catch (Throwable throwable) {
            vbv = true;
            System.out.println("weather pass failed: " + throwable);
            throwable.printStackTrace();
            return false;
        }
    }

    public static void timing(boolean bl) {
        vbw = bl;
        vby = 0L;
        vbz = 0;
    }

    public static double gpuMillis() {
        WeatherSeasonPass.vcd();
        double d = vbz == 0 ? -1.0 : (double)vby / 1000000.0 / (double)vbz;
        vby = 0L;
        vbz = 0;
        return d;
    }

    private static void vcd() {
        while (!vbx.isEmpty()) {
            OptionalLong optionalLong = vbx.peek().getValue();
            if (optionalLong.isEmpty()) {
                if (vbx.size() < 8) {
                    return;
                }
                vbx.poll().close();
                continue;
            }
            vbx.poll().close();
            vby += optionalLong.getAsLong();
            ++vbz;
        }
    }

    public static void uploadHeights(int[] nArray) {
        if (vbv) {
            return;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            WeatherSeasonPass.vch(gpuDevice);
            try (class_1011 class_10112 = new class_1011(class_1011.class_1012.field_4997, 128, 128, false);){
                for (int i = 0; i < 128; ++i) {
                    for (int j = 0; j < 128; ++j) {
                        class_10112.method_61941(j, i, nArray[i * 128 + j]);
                    }
                }
                gpuDevice.createCommandEncoder().writeToTexture(vbg, class_10112);
            }
        }
        catch (Throwable throwable) {
            vbv = true;
            System.out.println("weather heights failed: " + throwable);
        }
    }

    public static void release() {
        if (vbd != null) {
            vbd.close();
            vbd = null;
        }
        if (vbc != null) {
            vbc.close();
            vbc = null;
        }
        WeatherSeasonPass.vce();
        vbo = -1;
        vbp = -1;
        vbs = false;
        vbt = false;
        vbu = false;
        vbv = false;
    }

    private static void vce() {
        if (vbl != null) {
            vbl.close();
            vbk.close();
            vbl = null;
            vbk = null;
        }
        if (vbn != null) {
            vbn.close();
            vbm.close();
            vbn = null;
            vbm = null;
        }
        vbq = -1;
        vbr = -1;
    }

    private static void vcf(GpuDevice gpuDevice, int n, int n2) {
        if (vbl != null && n == vbq && n2 == vbr) {
            return;
        }
        WeatherSeasonPass.vce();
        int n3 = 5;
        vbk = gpuDevice.createTexture(() -> "Flow2 weather terrain depth", n3, TextureFormat.DEPTH32, n, n2, 1, 1);
        vbl = gpuDevice.createTextureView(vbk);
        vbm = gpuDevice.createTexture(() -> "Flow2 weather entity depth", n3, TextureFormat.DEPTH32, n, n2, 1, 1);
        vbn = gpuDevice.createTextureView(vbm);
        vbq = n;
        vbr = n2;
    }

    private static void vcg(GpuDevice gpuDevice, int n, int n2) {
        if (vbi == null) {
            vbi = gpuDevice.createBuffer(() -> "Flow2 MediaFoundationVideo", 136, 1328L);
        }
        if (vbj == null) {
            vbj = gpuDevice.createBuffer(() -> "Flow2 season", 136, 1408L);
        }
        if (vbf == null) {
            WeatherSeasonPass.vci(gpuDevice);
        }
        WeatherSeasonPass.vch(gpuDevice);
        if (vbd != null && n == vbo && n2 == vbp) {
            return;
        }
        if (vbd != null) {
            vbd.close();
            vbc.close();
        }
        int n3 = 12;
        vbc = gpuDevice.createTexture(() -> "Flow2 weather scene", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        vbd = gpuDevice.createTextureView(vbc);
        vbo = n;
        vbp = n2;
    }

    private static void vch(GpuDevice gpuDevice) {
        if (vbh != null) {
            return;
        }
        int n = 5;
        vbg = gpuDevice.createTexture(() -> "Flow2 weather heights", n, TextureFormat.RGBA8, 128, 128, 1, 1);
        vbh = gpuDevice.createTextureView(vbg);
    }

    private static void vci(GpuDevice gpuDevice) {
        Random random = new Random(65532160L);
        try (class_1011 class_10112 = new class_1011(class_1011.class_1012.field_4997, 256, 256, false);){
            int n;
            for (n = 0; n < 256; ++n) {
                for (int i = 0; i < 256; ++i) {
                    class_10112.method_61941(i, n, random.nextInt());
                }
            }
            n = 5;
            vbe = gpuDevice.createTexture(() -> "Flow2 weather noise", n, TextureFormat.RGBA8, 256, 256, 1, 1);
            vbf = gpuDevice.createTextureView(vbe);
            gpuDevice.createCommandEncoder().writeToTexture(vbe, class_10112);
        }
    }

    static {
        vbo = -1;
        vbp = -1;
        vbq = -1;
        vbr = -1;
        vbx = new ArrayDeque();
    }

    private static /* synthetic */ int dcm(int n, int n2) {
        return n - n2 + -516016664;
    }

    private static /* synthetic */ int dcn(int n, int n2) {
        return WeatherSeasonPass.dcm(n, n2) ^ 0xA7585D94;
    }

    private static /* synthetic */ int dco(int n, int n2) {
        return WeatherSeasonPass.dcn(n, n2) + n;
    }
}

