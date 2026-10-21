/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10017
 *  net.minecraft.class_10042
 *  net.minecraft.class_10151
 *  net.minecraft.class_10789
 *  net.minecraft.class_10799
 *  net.minecraft.class_11658
 *  net.minecraft.class_11659
 *  net.minecraft.class_11684
 *  net.minecraft.class_12075
 *  net.minecraft.class_276
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_761
 *  org.jspecify.annotations.Nullable
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.uki;
import a.ScreenProjection;
import a.VertexFormats;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_10151;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_11658;
import net.minecraft.class_11659;
import net.minecraft.class_11684;
import net.minecraft.class_12075;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_761;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;

public final class FxPipeline {
    public static final int ESP = 0;
    public static final int FRIENDS = 1;
    public static final int PLAIN = 2;
    public static final int VANILLA = 3;
    public static final int MOBS = 4;
    private static final int ukm = 5;
    private static final int ukn = 128;
    private static final int uko = 4144;
    private static final int ukp = 5;
    private static final RenderPipeline ukq = FxPipeline.une("fx_mask", null, "OutlineSampler");
    private static final RenderPipeline ukr = FxPipeline.une("fx_down", null, "InSampler");
    private static final RenderPipeline uks = FxPipeline.une("fx_up", null, "InSampler");
    private static final RenderPipeline ukt = FxPipeline.une("fx_composite", BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA, "OutlineSampler", "GlowSampler");
    private static final RenderPipeline uku = FxPipeline.une("fx_fade", BlendFunction.TRANSLUCENT, "OutlineSampler", "OutlineDepthSampler", "DepthSampler", "BackSampler");
    private static final uki[] ukv = new uki[5];
    private static final class_10017[] ukw = new class_10017[128];
    private static final int[] ukx = new int[128];
    private static final int[] uky = new int[128];
    private static final int[] ukz = new int[128];
    private static final float[] ula = new float[128];
    private static final List<class_10017> ulb = new ArrayList<class_10017>();
    private static int ulc;
    private static int uld;
    private static boolean ule;
    private static @Nullable class_12075 ulf;
    private static boolean ulg;
    private static boolean ulh;
    private static final float[] uli;
    private static final float[] ulj;
    private static boolean ulk;
    private static boolean ull;
    private static final float[] ulm;
    public static boolean noScissor;
    public static int devMode;
    private static final class_2960 uln;
    private static @Nullable Map<Object, Object> ulo;
    private static @Nullable Object ulp;
    private static boolean ulq;
    private static boolean ulr;
    private static final GpuBuffer[] uls;
    private static final GpuTexture[] ult;
    private static final GpuTextureView[] ulu;
    private static final GpuTexture[] ulv;
    private static final GpuTextureView[] ulw;
    private static @Nullable GpuTexture ulx;
    private static @Nullable GpuTextureView uly;
    private static int ulz;
    private static int uma;
    private static Field[] umb;
    private static boolean umc;
    private static boolean umd;
    private static Field ume;
    private static Field umf;
    private static /* synthetic */ boolean umg;
    private static /* synthetic */ long umh;

    private FxPipeline() {
    }

    public static boolean canFade() {
        return ulg && !umd && !ulh;
    }

    public static void fadeHookReady() {
        ulg = true;
    }

    public static uki style(int n) {
        uki uki2 = ukv[n];
        uki2.on = true;
        return uki2;
    }

    public static void paint(class_10017 class_100172, int n, int n2, int n3) {
        int n4 = FxPipeline.umi(class_100172);
        if (n4 >= 0) {
            FxPipeline.ukx[n4] = n;
            FxPipeline.uky[n4] = n2;
            FxPipeline.ukz[n4] = n3;
        }
    }

    public static void fade(class_10017 class_100172, float f) {
        int n = FxPipeline.umi(class_100172);
        if (n >= 0) {
            FxPipeline.ula[n] = Math.min(ula[n], Math.max(0.0f, Math.min(1.0f, f)));
        }
    }

    private static int umi(class_10017 class_100172) {
        int n;
        for (n = 0; n < ulc; ++n) {
            if (ukw[n] != class_100172) continue;
            return n;
        }
        if (ulc >= 128) {
            return -1;
        }
        n = ulc++;
        FxPipeline.ukw[n] = class_100172;
        FxPipeline.ukx[n] = 2;
        FxPipeline.uky[n] = -1;
        FxPipeline.ukz[n] = -1;
        FxPipeline.ula[n] = 1.0f;
        return n;
    }

    public static void afterExtraction(class_11658 class_116582) {
        uki[] ukiArray;
        boolean bl;
        uld = 0;
        ulb.clear();
        ulf = null;
        class_310 class_3102 = class_310.method_1551();
        boolean bl2 = bl = !ulh && class_3102.field_1769 != null && FxPipeline.umz(class_3102.field_1769) != null;
        if (ulc == 0 || !bl) {
            FxPipeline.umj();
            FxPipeline.unb(false);
            FxPipeline.umm(false);
            return;
        }
        FxPipeline.umm(devMode == 0);
        ule = false;
        for (class_10017 class_100172 : class_116582.field_61735) {
            if (class_100172.field_61821 == 0 || FxPipeline.umo(class_100172) >= 0) continue;
            ule = true;
            break;
        }
        boolean bl3 = ulg && FxPipeline.unb(true);
        for (int i = 0; i < ulc; ++i) {
            ukiArray = ukw[i];
            ukiArray.field_61821 = FxPipeline.ump(i);
            if (bl3 && ula[i] < 0.995f && class_116582.field_61735.remove(ukiArray)) {
                ulb.add((class_10017)ukiArray);
                continue;
            }
            FxPipeline.ula[i] = 1.0f;
        }
        ScreenProjection usn2 = null;
        try {
            ukiArray = class_3102.method_1522();
            usn2 = ScreenProjection.fresh(class_3102.method_61966().method_60637(true), ukiArray.field_1482, ukiArray.field_1481);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        ulk = noScissor || ule || usn2 == null || !FxPipeline.umk(usn2, Arrays.asList(ukw).subList(0, ulc), uli);
        boolean bl4 = ull = noScissor || usn2 == null || !FxPipeline.umk(usn2, ulb, ulj);
        if (!bl3) {
            FxPipeline.unb(false);
        }
        class_116582.field_61736 = true;
        ulf = class_116582.field_63082;
        for (uki uki2 : ukv) {
            uki2.shown = uki2.on;
        }
        uld = ulc;
        FxPipeline.umj();
    }

    private static void umj() {
        for (int i = 0; i < ulc; ++i) {
            FxPipeline.ukw[i] = null;
        }
        ulc = 0;
        for (uki uki2 : ukv) {
            uki2.on = false;
        }
        FxPipeline.ukv[3].on = true;
    }

    private static boolean umk(ScreenProjection usn2, List<class_10017> list, float[] fArray) {
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = -3.4028235E38f;
        float f4 = -3.4028235E38f;
        for (class_10017 class_100172 : list) {
            double d = (double)class_100172.field_53329 * 0.5 + 0.6;
            for (int i = 0; i < 8; ++i) {
                double d2;
                double d3 = (i & 1) == 0 ? class_100172.field_53325 - d : class_100172.field_53325 + d;
                double d4 = (i & 2) == 0 ? class_100172.field_53326 - 0.2 : class_100172.field_53326 + (double)class_100172.field_53330 + 0.4;
                double d5 = d2 = (i & 4) == 0 ? class_100172.field_53327 - d : class_100172.field_53327 + d;
                if (usn2.depth(d3, d4, d2) <= 0.05f || !usn2.project(d3, d4, d2, ulm)) {
                    return false;
                }
                f = Math.min(f, ulm[0]);
                f2 = Math.min(f2, ulm[1]);
                f3 = Math.max(f3, ulm[0]);
                f4 = Math.max(f4, ulm[1]);
            }
        }
        fArray[0] = f;
        fArray[1] = f2;
        fArray[2] = f3;
        fArray[3] = f4;
        return true;
    }

    private static void uml(RenderPass renderPass, float[] fArray, float f, float f2, int n, int n2) {
        int n3 = Math.max(0, (int)Math.floor((fArray[0] - f) * f2));
        int n4 = Math.min(n, (int)Math.ceil((fArray[2] + f) * f2));
        int n5 = (int)Math.floor((fArray[1] - f) * f2);
        int n6 = (int)Math.ceil((fArray[3] + f) * f2);
        int n7 = Math.max(0, n2 - n6);
        int n8 = Math.min(n2, n2 - n5);
        renderPass.enableScissor(n3, n7, Math.max(0, n4 - n3), Math.max(0, n8 - n7));
    }

    public static void restoreVanilla() {
        FxPipeline.umm(false);
        FxPipeline.unb(false);
    }

    private static void umm(boolean bl) {
        if (ulr || bl == ulq) {
            return;
        }
        try {
            if (bl) {
                Map<Object, Object> map = FxPipeline.umn();
                if (map == null) {
                    ulr = true;
                    return;
                }
                ulp = map.get(uln);
                map.put(uln, Optional.empty());
                ulo = map;
            } else if (ulo != null) {
                Optional optional;
                Object object = ulo.get(uln);
                if (object instanceof Optional && (optional = (Optional)object).isEmpty()) {
                    if (ulp != null) {
                        ulo.put(uln, ulp);
                    } else {
                        ulo.remove(uln);
                    }
                }
                ulo = null;
                ulp = null;
            }
            ulq = bl;
        }
        catch (Throwable throwable) {
            ulr = true;
            System.out.println("vanilla outline pass can't be skipped: " + throwable);
        }
    }

    private static @Nullable Map<Object, Object> umn() throws IllegalAccessException {
        class_10151 class_101512 = class_310.method_1551().method_62887();
        for (Field field : class_101512.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || field.getType().getDeclaringClass() != class_10151.class) continue;
            field.setAccessible(true);
            Object object = field.get(class_101512);
            if (object == null) continue;
            for (Field field2 : object.getClass().getDeclaredFields()) {
                if (Modifier.isStatic(field2.getModifiers()) || !Map.class.isAssignableFrom(field2.getType())) continue;
                field2.setAccessible(true);
                return (Map)field2.get(object);
            }
        }
        return null;
    }

    private static int umo(class_10017 class_100172) {
        for (int i = 0; i < ulc; ++i) {
            if (ukw[i] != class_100172) continue;
            return i;
        }
        return -1;
    }

    private static int ump(int n) {
        return 0xFF070000 | n << 8 | 0xB3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean invisible(class_10017 class_100172) {
        if (!(class_100172 instanceof class_10042)) return false;
        class_10042 class_100422 = (class_10042)class_100172;
        if (!class_100422.field_53461) return false;
        return true;
    }

    public static void afterEntities() {
        if (ulb.isEmpty() || ulf == null || ulh) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        ArrayList<class_10017> arrayList = new ArrayList<class_10017>(ulb);
        ulb.clear();
        try {
            class_276 class_2762 = class_3102.method_1522();
            class_276 class_2763 = FxPipeline.umz(class_3102.field_1769);
            class_11684 class_116842 = FxPipeline.una(class_3102.field_1769);
            if (class_2763 == null || class_116842 == null || !VertexFormats.ensure(uku) || !VertexFormats.ensure(VertexFormats.BLUR_COPY) || class_2762.method_71639() == null || class_2762.method_71640() == null || class_2763.method_71639() == null || class_2763.method_71640() == null) {
                FxPipeline.umq(class_3102, arrayList, class_116842);
                return;
            }
            class_3102.method_22940().method_23000().method_22993();
            GpuDevice gpuDevice = RenderSystem.getDevice();
            FxPipeline.umx(gpuDevice, class_2762.field_1482, class_2762.field_1481);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 fx back", uly, OptionalInt.empty());){
                if (!ull) {
                    FxPipeline.uml(renderPass, ulj, 4.0f, 1.0f, class_2762.field_1482, class_2762.field_1481);
                }
                renderPass.setPipeline(VertexFormats.BLUR_COPY);
                renderPass.bindTexture("InSampler", class_2762.method_71639(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.draw(0, 3);
            }
            FxPipeline.umq(class_3102, arrayList, class_116842);
            FxPipeline.umt(commandEncoder, 0, class_2762.field_1482, class_2762.field_1481, 0.0f);
            renderPass = commandEncoder.createRenderPass(() -> "Flow2 fx fade", class_2762.method_71639(), OptionalInt.empty());
            try {
                if (!ull) {
                    FxPipeline.uml(renderPass, ulj, 4.0f, 1.0f, class_2762.field_1482, class_2762.field_1481);
                }
                renderPass.setPipeline(uku);
                renderPass.bindTexture("OutlineSampler", class_2763.method_71639(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("OutlineDepthSampler", class_2763.method_71640(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("DepthSampler", class_2762.method_71640(), RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.bindTexture("BackSampler", uly, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
                renderPass.setUniform("FlowFx", uls[0]);
                renderPass.draw(0, 3);
            }
            finally {
                if (renderPass != null) {
                    renderPass.close();
                }
            }
        }
        catch (Throwable throwable) {
            ulh = true;
            System.out.println("entity fx fade failed, turned off: " + throwable);
        }
    }

    private static void umq(class_310 class_3102, List<class_10017> list, @Nullable class_11684 class_116842) {
        if (class_116842 == null) {
            return;
        }
        class_12075 class_120752 = ulf;
        class_4587 class_45872 = new class_4587();
        for (class_10017 class_100172 : list) {
            class_3102.method_1561().method_72976(class_100172, class_120752, class_100172.field_53325 - class_120752.field_63078.field_1352, class_100172.field_53326 - class_120752.field_63078.field_1351, class_100172.field_53327 - class_120752.field_63078.field_1350, class_45872, (class_11659)class_116842.method_73003());
        }
        class_116842.method_73002();
        class_3102.method_22940().method_23000().method_22993();
        class_3102.method_22940().method_23003().method_23285();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void endMain() {
        class_276 class_2762;
        if (uld == 0 || ulh) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        class_276 class_2763 = class_3102.method_1522();
        class_276 class_2764 = class_2762 = class_3102.field_1769 == null ? null : FxPipeline.umz(class_3102.field_1769);
        if (class_2762 == null || class_2762.method_30277() == null || class_2763.method_71639() == null) {
            return;
        }
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            if (devMode != 1 && VertexFormats.ensure(ukq) && VertexFormats.ensure(ukr) && VertexFormats.ensure(uks) && VertexFormats.ensure(ukt)) {
                FxPipeline.umx(gpuDevice, class_2763.field_1482, class_2763.field_1481);
                float f = (float)(System.nanoTime() / 1000000L % 3600000L) / 1000.0f;
                for (int i = 0; i < 5; ++i) {
                    uki uki2 = ukv[i];
                    if (!uki2.visible() || i == 3 && !ule) continue;
                    FxPipeline.umt(commandEncoder, i, class_2763.field_1482, class_2763.field_1481, f);
                    FxPipeline.umr(commandEncoder, i, uki2, class_2762.method_71639(), class_2763.method_71639(), class_2763.field_1482, class_2763.field_1481);
                }
            }
            commandEncoder.clearColorTexture(class_2762.method_30277(), 0);
        }
        catch (Throwable throwable) {
            ulh = true;
            System.out.println("entity fx failed, turned off: " + throwable);
        }
        finally {
            uld = 0;
        }
    }

    private static void umr(CommandEncoder commandEncoder, int n, uki uki2, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, int n2, int n3) {
        int n4 = Math.max(2, Math.min(4, 2 + Math.round(uki2.spread * 2.0f)));
        float f = (float)(4 << n4) + Math.min(uki2.width * Math.max(1.0f, (float)n3 / 1080.0f), 6.0f) + 4.0f;
        if (!ulk) {
            commandEncoder.clearColorTexture(ult[0], 0);
        }
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 fx mask", ulu[0], OptionalInt.empty());){
            if (!ulk) {
                FxPipeline.uml(renderPass, uli, f, 0.5f, Math.max(1, n2 / 2), Math.max(1, n3 / 2));
            }
            renderPass.setPipeline(ukq);
            renderPass.bindTexture("OutlineSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
            renderPass.setUniform("FlowFx", uls[n]);
            renderPass.draw(0, 3);
        }
        for (int i = 1; i <= n4; ++i) {
            FxPipeline.ums(commandEncoder, ukr, ulu[i - 1], ulu[i]);
        }
        GpuTextureView gpuTextureView3 = ulu[n4];
        for (int i = n4 - 1; i >= 0; --i) {
            FxPipeline.ums(commandEncoder, uks, gpuTextureView3, ulw[i]);
            gpuTextureView3 = ulw[i];
        }
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 fx composite", gpuTextureView2, OptionalInt.empty());){
            if (!ulk) {
                FxPipeline.uml(renderPass, uli, f, 1.0f, n2, n3);
            }
            renderPass.setPipeline(ukt);
            renderPass.bindTexture("OutlineSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.NEAREST));
            renderPass.bindTexture("GlowSampler", gpuTextureView3, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            renderPass.setUniform("FlowFx", uls[n]);
            renderPass.draw(0, 3);
        }
    }

    private static void ums(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 fx glow", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
            renderPass.draw(0, 3);
        }
    }

    private static void umt(CommandEncoder commandEncoder, int n, int n2, int n3, float f) {
        uki uki2 = ukv[n];
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            Std140Builder std140Builder = Std140Builder.onStack((MemoryStack)memoryStack, (int)4144).putVec4((float)n2, (float)n3, 1.0f / (float)n2, 1.0f / (float)n3).putVec4(uki2.fill, uki2.line, uki2.width * Math.max(1.0f, (float)n3 / 1080.0f), uki2.glow).putVec4(uki2.spread, f * uki2.speed, (float)n, 3.0f);
            for (int i = 0; i < 128; ++i) {
                int n4 = i < uld ? uky[i] : 0;
                int n5 = i < uld ? ukz[i] : 0;
                std140Builder.putVec4(FxPipeline.umu(n4), FxPipeline.umv(n4), FxPipeline.umw(n4), i < uld ? ula[i] : 1.0f);
                std140Builder.putVec4(FxPipeline.umu(n5), FxPipeline.umv(n5), FxPipeline.umw(n5), i < uld ? (float)ukx[i] : 2.0f);
            }
            ByteBuffer byteBuffer = std140Builder.get();
            commandEncoder.writeToBuffer(uls[n].slice(), byteBuffer);
        }
    }

    private static float umu(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    private static float umv(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    private static float umw(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static void umx(GpuDevice gpuDevice, int n, int n2) {
        int n3;
        int n4;
        for (n4 = 0; n4 < 5; ++n4) {
            if (uls[n4] != null) continue;
            n3 = n4;
            FxPipeline.uls[n4] = gpuDevice.createBuffer(() -> "Flow2 fx " + n3, 136, 4144L);
        }
        if (uly != null && n == ulz && n2 == uma) {
            return;
        }
        FxPipeline.umy();
        n4 = 12;
        ulx = gpuDevice.createTexture(() -> "Flow2 fx back", n4, TextureFormat.RGBA8, n, n2, 1, 1);
        uly = gpuDevice.createTextureView(ulx);
        for (n3 = 0; n3 < 5; ++n3) {
            int n5 = 2 << n3;
            int n6 = n3;
            FxPipeline.ult[n3] = gpuDevice.createTexture(() -> "Flow2 fx down " + n6, n4, TextureFormat.RGBA8, Math.max(1, n / n5), Math.max(1, n2 / n5), 1, 1);
            FxPipeline.ulu[n3] = gpuDevice.createTextureView(ult[n3]);
            if (n3 >= 4) continue;
            FxPipeline.ulv[n3] = gpuDevice.createTexture(() -> "Flow2 fx up " + n6, n4, TextureFormat.RGBA8, Math.max(1, n / n5), Math.max(1, n2 / n5), 1, 1);
            FxPipeline.ulw[n3] = gpuDevice.createTextureView(ulv[n3]);
        }
        ulz = n;
        uma = n2;
    }

    private static void umy() {
        if (uly != null) {
            uly.close();
            ulx.close();
            uly = null;
            ulx = null;
        }
        for (int i = 0; i < 5; ++i) {
            if (ulu[i] != null) {
                ulu[i].close();
                ult[i].close();
                FxPipeline.ulu[i] = null;
                FxPipeline.ult[i] = null;
            }
            if (i >= 4 || ulw[i] == null) continue;
            ulw[i].close();
            ulv[i].close();
            FxPipeline.ulw[i] = null;
            FxPipeline.ulv[i] = null;
        }
        ulz = -1;
        uma = -1;
    }

    private static @Nullable class_276 umz(class_761 class_7612) {
        try {
            if (umf == null) {
                for (Field field : class_761.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || field.getType() != class_276.class) continue;
                    field.setAccessible(true);
                    umf = field;
                    break;
                }
                if (umf == null) {
                    ulh = true;
                    return null;
                }
            }
            return (class_276)umf.get(class_7612);
        }
        catch (Throwable throwable) {
            ulh = true;
            return null;
        }
    }

    private static @Nullable class_11684 una(class_761 class_7612) throws IllegalAccessException {
        if (ume == null) {
            for (Field field : class_761.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != class_11684.class) continue;
                field.setAccessible(true);
                ume = field;
                break;
            }
            if (ume == null) {
                return null;
            }
        }
        return (class_11684)ume.get(class_7612);
    }

    private static boolean unb(boolean bl) {
        if (umd || bl == umc) {
            return !umd && umc;
        }
        try {
            if (umb == null) {
                umb = FxPipeline.unc();
            }
            for (RenderPipeline renderPipeline : new RenderPipeline[]{class_10799.field_56842, class_10799.field_56843}) {
                umb[0].set(renderPipeline, bl ? DepthTestFunction.LEQUAL_DEPTH_TEST : DepthTestFunction.NO_DEPTH_TEST);
                umb[1].setBoolean(renderPipeline, bl);
            }
            umc = bl;
            return bl;
        }
        catch (Throwable throwable) {
            umd = true;
            System.out.println("outline depth unavailable, transparency off: " + throwable);
            return false;
        }
    }

    private static Field[] unc() throws ReflectiveOperationException {
        RenderPipeline renderPipeline = FxPipeline.und(false);
        RenderPipeline renderPipeline2 = FxPipeline.und(true);
        Field field = null;
        Field field2 = null;
        for (Field field3 : RenderPipeline.class.getDeclaredFields()) {
            if (Modifier.isStatic(field3.getModifiers())) continue;
            field3.setAccessible(true);
            if (field3.getType() == DepthTestFunction.class) {
                field = field3;
                continue;
            }
            if (field3.getType() != Boolean.TYPE || field3.getBoolean(renderPipeline) == field3.getBoolean(renderPipeline2)) continue;
            field2 = field3;
        }
        if (field == null || field2 == null) {
            throw new IllegalStateException("render pipeline layout");
        }
        return new Field[]{field, field2};
    }

    private static RenderPipeline und(boolean bl) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/probe_" + bl)).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/blur_copy")).withDepthWrite(bl).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    }

    private static RenderPipeline une(String string, @Nullable BlendFunction blendFunction, String ... stringArray) {
        RenderPipeline.Builder builder = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(VertexFormats.id("pipeline/" + string)).withVertexShader(VertexFormats.id("core/blur")).withFragmentShader(VertexFormats.id("core/" + string)).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379);
        for (String string2 : stringArray) {
            builder.withSampler(string2);
        }
        if (!string.equals("fx_down") && !string.equals("fx_up")) {
            builder.withUniform("FlowFx", class_10789.field_60031);
        }
        if (blendFunction != null) {
            builder.withBlend(blendFunction);
        }
        return builder.build();
    }

    static {
        uli = new float[4];
        ulj = new float[4];
        ulk = true;
        ull = true;
        ulm = new float[2];
        uln = class_2960.method_60656((String)"entity_outline");
        uls = new GpuBuffer[5];
        ult = new GpuTexture[5];
        ulu = new GpuTextureView[5];
        ulv = new GpuTexture[4];
        ulw = new GpuTextureView[4];
        ulz = -1;
        uma = -1;
        for (int i = 0; i < 5; ++i) {
            FxPipeline.ukv[i] = new uki();
        }
        ukv[3].set(0.0f, 1.0f, 1.5f, 0.0f, 0.3f, 0.0f);
    }

    private static /* synthetic */ int cyh(int n, int n2) {
        return n - n2 | 0x12AA0B03;
    }

    private static /* synthetic */ int cyi(int n, int n2) {
        return FxPipeline.cyh(n, n2) * n2;
    }

    private static /* synthetic */ int cyj(int n, int n2) {
        return (n ^ n2) + -1264508871;
    }
}

