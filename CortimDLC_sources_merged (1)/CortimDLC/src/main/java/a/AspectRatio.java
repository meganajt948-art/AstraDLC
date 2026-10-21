/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10789
 *  net.minecraft.class_276
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 *  org.lwjgl.system.MemoryStack
 */
package a;

import a.PanicShutdown;
import a.ModuleCategory;
import a.Module;
import a.VertexFormats;
import a.NumberSetting;
import a.FormatUtil;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.OptionalInt;
import net.minecraft.class_10789;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_9779;
import org.lwjgl.system.MemoryStack;

public class AspectRatio
extends Module {
    private static AspectRatio qzf;
    private final NumberSetting qzg = this.add(new NumberSetting("Ratio", 1.33, 0.5, 3.0, 0.01).format(d -> FormatUtil.fixed(d, 2) + " : 1"));
    private static final RenderPipeline qzh;
    private GpuTexture qzi;
    private GpuTextureView qzj;
    private GpuBuffer qzk;
    private int qzl = -1;
    private int qzm = -1;
    private boolean qzn;
    private static /* synthetic */ long qzo;
    private static /* synthetic */ String qzp;

    public AspectRatio() {
        super("AspectRatio", "Stretched resolution: change the screen's width with a slider", ModuleCategory.RENDER);
        qzf = this;
    }

    @Override
    protected void onDisable() {
        this.qzs();
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        AspectRatio qze2 = qzf;
        if (qze2 != null && qze2.isEnabled() && !qze2.qzn && !PanicShutdown.armed()) {
            qze2.qzq();
        }
    }

    private void qzq() {
        class_310 class_3102 = class_310.method_1551();
        class_276 class_2762 = class_3102.method_1522();
        if (class_3102.field_1687 == null || class_2762 == null || class_2762.method_30277() == null || class_2762.field_1482 < 4 || class_2762.field_1481 < 4) {
            return;
        }
        float f = (float)class_2762.field_1482 / (float)class_2762.field_1481;
        float f2 = (float)this.qzg.get();
        if (Math.abs(f2 - f) < 0.005f || !VertexFormats.ensure(qzh)) {
            return;
        }
        float f3 = Math.min(1.0f, f2 / f);
        float f4 = Math.min(1.0f, f / f2);
        try {
            GpuDevice gpuDevice = RenderSystem.getDevice();
            this.qzr(gpuDevice, class_2762.field_1482, class_2762.field_1481);
            CommandEncoder commandEncoder = gpuDevice.createCommandEncoder();
            commandEncoder.copyTextureToTexture(class_2762.method_30277(), this.qzi, 0, 0, 0, 0, 0, class_2762.field_1482, class_2762.field_1481);
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                commandEncoder.writeToBuffer(this.qzk.slice(), Std140Builder.onStack((MemoryStack)memoryStack, (int)16).putVec4((1.0f - f3) * 0.5f, (1.0f - f4) * 0.5f, f3, f4).get());
            }
            memoryStack = commandEncoder.createRenderPass(() -> "Flow2 aspect ratio", class_2762.method_71639(), OptionalInt.empty());
            try {
                memoryStack.setPipeline(qzh);
                memoryStack.bindTexture("InSampler", this.qzj, RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR));
                memoryStack.setUniform("FlowStretch", this.qzk);
                memoryStack.draw(0, 3);
            }
            finally {
                if (memoryStack != null) {
                    memoryStack.close();
                }
            }
        }
        catch (Throwable throwable) {
            this.qzn = true;
            System.out.println("[Flow2] aspect ratio unavailable: " + throwable);
        }
    }

    private void qzr(GpuDevice gpuDevice, int n, int n2) {
        if (this.qzk == null) {
            this.qzk = gpuDevice.createBuffer(() -> "Flow2 aspect ratio", 136, 16L);
        }
        if (this.qzj != null && n == this.qzl && n2 == this.qzm) {
            return;
        }
        this.qzs();
        int n3 = 5;
        this.qzi = gpuDevice.createTexture(() -> "Flow2 aspect ratio", n3, TextureFormat.RGBA8, n, n2, 1, 1);
        this.qzj = gpuDevice.createTextureView(this.qzi);
        this.qzl = n;
        this.qzm = n2;
    }

    private void qzs() {
        if (this.qzj != null) {
            this.qzj.close();
            this.qzj = null;
        }
        if (this.qzi != null) {
            this.qzi.close();
            this.qzi = null;
        }
        this.qzl = -1;
        this.qzm = -1;
    }

    static {
        qzh = RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(class_2960.method_60655((String)"flow2", (String)"pipeline/stretch")).withVertexShader(class_2960.method_60655((String)"flow2", (String)"core/blur")).withFragmentShader(class_2960.method_60655((String)"flow2", (String)"core/stretch")).withSampler("InSampler").withUniform("FlowStretch", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).build();
    }

    private static /* synthetic */ int bwu(int n, int n2) {
        return n * n2 + -982455206;
    }

    private static /* synthetic */ int bwv(int n, int n2) {
        return n - n2 ^ 0x5B4AA5FC;
    }
}

