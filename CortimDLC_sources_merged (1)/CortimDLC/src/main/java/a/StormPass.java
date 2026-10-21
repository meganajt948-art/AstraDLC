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
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.VertexFormats;
import a.WeatherSeasonPass;
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
import java.util.Arrays;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Consumer;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class StormPass {
    public static final int UNIFORM_SIZE = 4288;
    public static final int BOLT_SEGMENTS = 80;
    public static final int DROPS = 16;
    private static final int uxy = 512;
    private static final int uxz = 128;
    private static @Nullable GpuBuffer uya;
    private static @Nullable GpuTexture uyb;
    private static @Nullable GpuTextureView uyc;
    private static @Nullable GpuTexture uyd;
    private static @Nullable GpuTextureView uye;
    private static @Nullable GpuTexture uyf;
    private static @Nullable GpuTextureView uyg;
    private static @Nullable GpuTexture uyh;
    private static @Nullable GpuTextureView uyi;
    private static int uyj;
    private static int uyk;
    private static boolean uyl;
    private static boolean uym;
    private static boolean uyn;
    private static final String[] uyo;
    private static final ArrayDeque<GpuQuery> uyp;
    private static final ArrayDeque<Integer> uyq;
    private static final long[] uyr;
    private static long uys;
    private static int uyt;
    private static /* synthetic */ String uyu;
    private static /* synthetic */ String uyv;

    private StormPass() {
    }

    public static boolean upload(Consumer<Std140Builder> consumer) {
        uyl = false;
        if (uym) {
            return false;
        }
        class_276 class_2762 = class_310.method_1551().method_1522();
        if (class_2762.method_71639() == null || class_2762.field_1482 < 4 || class_2762.field_1481 < 4) {
            return false;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            StormPass.uzc(gpuDevice, class_2762.field_1482, class_2762.field_1481);
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                Std140Builder std140Builder = Std140Builder.onStack((MemoryStack)memoryStack, (int)4288).putVec4((float)class_2762.field_1482, (float)class_2762.field_1481, 1.0f / (float)class_2762.field_1482, 1.0f / (float)class_2762.field_1481);
                consumer.accept(std140Builder);
                gpuDevice.createCommandEncoder().writeToBuffer(uya.slice(), std140Builder.get());
            }
            uyl = true;
            if (uyn) {
                ++uyt;
            }
            return true;
        }
        catch (Throwable throwable) {
            StormPass.uza("upload", throwable);
            return false;
        }
    }

    public static void sky(int n) {
        if (!(uyl && VertexFormats.ensure(VertexFormats.STORM_PROBE) && VertexFormats.ensure(VertexFormats.STORM_PROBE_BLUR) && VertexFormats.ensure(VertexFormats.STORM_SKY) && VertexFormats.ensure(VertexFormats.STORM_SKY_COMPOSITE))) {
            return;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        GpuTextureView gpuTextureView2 = class_2762.method_71640();
        if (gpuBufferSlice == null || gpuTextureView == null || gpuTextureView2 == null || uyi == null || class_2762.field_1482 != uyj || class_2762.field_1481 != uyk) {
            return;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            GpuTextureView gpuTextureView3 = WeatherSeasonPass.noiseView(gpuDevice);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            GpuQuery gpuQuery = StormPass.uyy(commandEncoder);
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm probe", uye, OptionalInt.empty());){
                renderPass.setPipeline(VertexFormats.STORM_PROBE);
                renderPass.bindTexture("NoiseSampler", gpuTextureView3, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, 3);
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm probe blur", uyg, OptionalInt.empty());
            try {
                renderPass.setPipeline(VertexFormats.STORM_PROBE_BLUR);
                renderPass.bindTexture("ProbeSampler", uye, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm sky", uyi, OptionalInt.empty());
            try {
                renderPass.setPipeline(VertexFormats.STORM_SKY);
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("NoiseSampler", gpuTextureView3, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm sky composite", gpuTextureView, OptionalInt.empty());
            try {
                renderPass.setPipeline(VertexFormats.STORM_SKY_COMPOSITE);
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("HalfSampler", uyi, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
            if (n > 0 && VertexFormats.ensure(VertexFormats.STORM_BOLT)) {
                renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm bolt", gpuTextureView, OptionalInt.empty());
                try {
                    renderPass.setPipeline(VertexFormats.STORM_BOLT);
                    renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                    renderPass.setUniform("Projection", gpuBufferSlice);
                    renderPass.setUniform("FlowStorm", uya);
                    renderPass.draw(0, 6);
                }
                finally {
                    if (renderPass != null) {
                        renderPass.close();
                    }
                }
            }
            StormPass.uyz(commandEncoder, gpuQuery, 0);
        }
        catch (Throwable throwable) {
            StormPass.uza("sky", throwable);
        }
    }

    public static void MediaFoundationVideo(boolean bl) {
        if (!(uyl && VertexFormats.ensure(VertexFormats.STORM_WET) && VertexFormats.ensure(VertexFormats.BLUR_COPY))) {
            return;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        GpuBufferSlice gpuBufferSlice2 = RenderSystem.getShaderFog();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        GpuTextureView gpuTextureView2 = class_2762.method_71640();
        GpuTextureView gpuTextureView3 = WeatherSeasonPass.heightView();
        if (gpuBufferSlice == null || gpuBufferSlice2 == null || gpuTextureView == null || gpuTextureView2 == null || gpuTextureView3 == null || class_2762.field_1482 != uyj || class_2762.field_1481 != uyk) {
            return;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            GpuQuery gpuQuery = StormPass.uyy(commandEncoder);
            StormPass.uyx(commandEncoder, gpuTextureView);
            GpuTextureView gpuTextureView4 = bl ? WeatherSeasonPass.terrainDepthView() : null;
            GpuTextureView gpuTextureView5 = bl ? WeatherSeasonPass.entityDepthView() : null;
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm MediaFoundationVideo", gpuTextureView, OptionalInt.empty());){
                renderPass.setPipeline(VertexFormats.STORM_WET);
                renderPass.bindTexture("SceneSampler", uyc, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                renderPass.bindTexture("DepthSampler", gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("NoiseSampler", WeatherSeasonPass.noiseView(gpuDevice), RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.bindTexture("HeightSampler", gpuTextureView3, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("ProbeSampler", uye, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.bindTexture("ProbeBlurSampler", uyg, RenderSystem.getSamplerCache().method_75297(FilterMode.LINEAR));
                renderPass.bindTexture("TerrainDepthSampler", gpuTextureView4 != null ? gpuTextureView4 : gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("EntityDepthSampler", gpuTextureView5 != null ? gpuTextureView5 : gpuTextureView2, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("Fog", gpuBufferSlice2);
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, 3);
            }
            WeatherSeasonPass.maskUsed();
            StormPass.uyz(commandEncoder, gpuQuery, 1);
        }
        catch (Throwable throwable) {
            StormPass.uza("MediaFoundationVideo", throwable);
        }
    }

    public static void rain(int n) {
        if (!uyl || n <= 0 || !VertexFormats.ensure(VertexFormats.RAIN)) {
            return;
        }
        GpuBufferSlice gpuBufferSlice = RenderSystem.getProjectionMatrixBuffer();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        GpuTextureView gpuTextureView2 = class_2762.method_71640();
        GpuTextureView gpuTextureView3 = WeatherSeasonPass.heightView();
        if (gpuBufferSlice == null || gpuTextureView == null || gpuTextureView2 == null || gpuTextureView3 == null) {
            return;
        }
        try {
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            GpuQuery gpuQuery = StormPass.uyy(commandEncoder);
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 rain", gpuTextureView, OptionalInt.empty(), gpuTextureView2, OptionalDouble.empty());){
                renderPass.setPipeline(VertexFormats.RAIN);
                renderPass.bindTexture("HeightSampler", gpuTextureView3, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("Projection", gpuBufferSlice);
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, n * 6);
            }
            StormPass.uyz(commandEncoder, gpuQuery, 2);
        }
        catch (Throwable throwable) {
            StormPass.uza("rain", throwable);
        }
    }

    public static void grade() {
        StormPass.uyw(VertexFormats.STORM_GRADE, "grade", 3);
    }

    public static void drops() {
        StormPass.uyw(VertexFormats.STORM_DROPS, "drops", 4);
    }

    private static void uyw(RenderPipeline renderPipeline, String string, int n) {
        if (!(uyl && VertexFormats.ensure(renderPipeline) && VertexFormats.ensure(VertexFormats.BLUR_COPY))) {
            return;
        }
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView = class_2762.method_71639();
        if (gpuTextureView == null || class_2762.field_1482 != uyj || class_2762.field_1481 != uyk) {
            return;
        }
        try {
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            GpuQuery gpuQuery = StormPass.uyy(commandEncoder);
            StormPass.uyx(commandEncoder, gpuTextureView);
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm " + string, gpuTextureView, OptionalInt.empty());){
                renderPass.setPipeline(renderPipeline);
                renderPass.bindTexture("SceneSampler", uyc, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                renderPass.setUniform("FlowStorm", uya);
                renderPass.draw(0, 3);
            }
            StormPass.uyz(commandEncoder, gpuQuery, n);
        }
        catch (Throwable throwable) {
            StormPass.uza(string, throwable);
        }
    }

    private static void uyx(CommandEncoder commandEncoder, GpuTextureView gpuTextureView) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 storm scene copy", uyc, OptionalInt.empty());){
            renderPass.setPipeline(VertexFormats.BLUR_COPY);
            renderPass.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
            renderPass.draw(0, 3);
        }
    }

    private static @Nullable GpuQuery uyy(CommandEncoder commandEncoder) {
        return uyn ? commandEncoder.timerQueryBegin() : null;
    }

    private static void uyz(CommandEncoder commandEncoder, @Nullable GpuQuery gpuQuery, int n) {
        if (gpuQuery != null) {
            commandEncoder.timerQueryEnd(gpuQuery);
            uyp.add(gpuQuery);
            uyq.add(n);
        }
        StormPass.uzb();
    }

    private static void uza(String string, Throwable throwable) {
        uym = true;
        uyl = false;
        System.out.println("storm " + string + " failed: " + throwable);
        throwable.printStackTrace();
    }

    public static void timing(boolean bl) {
        uyn = bl;
        uys = 0L;
        uyt = 0;
        Arrays.fill(uyr, 0L);
    }

    public static String gpuReport() {
        StormPass.uzb();
        StringBuilder stringBuilder = new StringBuilder();
        int n = Math.max(1, uyt);
        stringBuilder.append(String.format(Locale.ROOT, "%.2f ms/frame", (double)uys / 1000000.0 / (double)n));
        for (int i = 0; i < uyo.length; ++i) {
            stringBuilder.append(String.format(Locale.ROOT, " %s %.2f", uyo[i], (double)uyr[i] / 1000000.0 / (double)n));
        }
        uys = 0L;
        uyt = 0;
        Arrays.fill(uyr, 0L);
        return stringBuilder.toString();
    }

    public static double gpuMillis() {
        StormPass.uzb();
        double d = uyt == 0 ? -1.0 : (double)uys / 1000000.0 / (double)uyt;
        uys = 0L;
        uyt = 0;
        Arrays.fill(uyr, 0L);
        return d;
    }

    private static void uzb() {
        while (!uyp.isEmpty()) {
            OptionalLong optionalLong = uyp.peek().getValue();
            if (optionalLong.isEmpty()) {
                if (uyp.size() < 32) {
                    return;
                }
                uyp.poll().close();
                uyq.poll();
                continue;
            }
            uyp.poll().close();
            int n = uyq.poll();
            uys += optionalLong.getAsLong();
            int n2 = n;
            uyr[n2] = uyr[n2] + optionalLong.getAsLong();
        }
    }

    public static void release() {
        if (uyc != null) {
            uyc.close();
            uyb.close();
            uyc = null;
            uyb = null;
        }
        if (uye != null) {
            uye.close();
            uyd.close();
            uye = null;
            uyd = null;
        }
        if (uyg != null) {
            uyg.close();
            uyf.close();
            uyg = null;
            uyf = null;
        }
        StormPass.uzd();
        uyj = -1;
        uyk = -1;
        uyl = false;
        uym = false;
    }

    private static void uzc(GpuDevice gpuDevice, int n, int n2) {
        if (uya == null) {
            uya = gpuDevice.createBuffer(() -> "Flow2 storm", 136, 4288L);
        }
        int n3 = 12;
        if (uye == null) {
            uyd = gpuDevice.createTexture(() -> "Flow2 storm probe", n3, TextureFormat.RGBA8, 512, 128, 1, 1);
            uye = gpuDevice.createTextureView(uyd);
            uyf = gpuDevice.createTexture(() -> "Flow2 storm probe blur", n3, TextureFormat.RGBA8, 128, 32, 1, 1);
            uyg = gpuDevice.createTextureView(uyf);
        }
        if (uyc != null && n == uyj && n2 == uyk) {
            return;
        }
        if (uyc != null) {
            uyc.close();
            uyb.close();
        }
        StormPass.uzd();
        uyb = gpuDevice.createTexture(() -> "Flow2 storm scene", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        uyc = gpuDevice.createTextureView(uyb);
        uyh = gpuDevice.createTexture(() -> "Flow2 storm sky half", n3, TextureFormat.RGBA8, (n + 1) / 2, (n2 + 1) / 2, 1, 1);
        uyi = gpuDevice.createTextureView(uyh);
        uyj = n;
        uyk = n2;
    }

    private static void uzd() {
        if (uyi != null) {
            uyi.close();
            uyh.close();
            uyi = null;
            uyh = null;
        }
    }

    static {
        uyj = -1;
        uyk = -1;
        uyo = new String[]{"sky", "MediaFoundationVideo", "rain", "grade", "drops"};
        uyp = new ArrayDeque();
        uyq = new ArrayDeque();
        uyr = new long[uyo.length];
    }

    private static /* synthetic */ int dcb(int n, int n2) {
        return n + n2 ^ 0x37EE4A7;
    }
}

