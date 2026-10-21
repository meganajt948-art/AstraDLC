/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.FilterMode
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  net.minecraft.class_12137
 *  net.minecraft.class_243
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4184
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.FrameDelta;
import a.VertexFormats;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.OptionalInt;
import net.minecraft.class_12137;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4184;
import org.jspecify.annotations.Nullable;

public final class SceneCapture {
    public static final int MAX_ITERATIONS = 6;
    public static final SceneCapture SCENE = new SceneCapture("scene");
    public static final SceneCapture BACKDROP = new SceneCapture("backdrop");
    public static final SceneCapture HUD = new SceneCapture("hud");
    public static final SceneCapture TAGS = new SceneCapture("tags");
    private final String uik;
    private final GpuTexture[] uil = new GpuTexture[6];
    private final GpuTextureView[] uim = new GpuTextureView[6];
    private @Nullable GpuTexture uin;
    private @Nullable GpuTextureView uio;
    private int uip = -1;
    private int uiq = -1;
    private @Nullable GpuTextureView uir;
    private long uis = -1L;
    private int uit;
    private @Nullable Object uiu;
    private boolean uiv;
    private boolean uiw;
    private double uix;
    private double uiy;
    private double uiz;
    private float uja;
    private float ujb;
    private static SceneCapture[] ujc;
    private static /* synthetic */ int ujd;
    private static /* synthetic */ int uje;

    private SceneCapture(String string) {
        this.uik = string;
    }

    public boolean capture(class_332 class_3322, int n, @Nullable GpuTextureView gpuTextureView) {
        GpuTextureView gpuTextureView2;
        FrameDelta.observe(class_3322);
        n = Math.max(0, Math.min(6, n));
        long l = FrameDelta.frame();
        class_276 class_2762 = class_310.method_1551().method_1522();
        GpuTextureView gpuTextureView3 = gpuTextureView2 = gpuTextureView != null ? gpuTextureView : class_2762.method_71639();
        if (this.uis == l && this.uit == n && this.uiu == gpuTextureView2 && this.uir != null) {
            return true;
        }
        for (SceneCapture uij2 : SceneCapture.ujf()) {
            if (uij2 == this || uij2.uis != l || uij2.uit != n || uij2.uiu != gpuTextureView2 || uij2.uir == null) continue;
            this.uir = uij2.uir;
            this.uis = l;
            this.uit = n;
            this.uiu = gpuTextureView2;
            this.uiv = true;
            return true;
        }
        if (gpuTextureView == null && this.uir != null && !this.uiv && !this.uiw && this.uis == l - 1L && this.uit == n && this.uiu == gpuTextureView2 && class_2762.field_1482 == this.uip && class_2762.field_1481 == this.uiq && this.ujh()) {
            this.uis = l;
            this.uiw = true;
            return true;
        }
        this.uiw = false;
        this.uiv = false;
        this.uir = null;
        if (gpuTextureView2 == null || class_2762.field_1482 < 4 || class_2762.field_1481 < 4) {
            return false;
        }
        if (!(VertexFormats.ensure(VertexFormats.BLUR_DOWN) && VertexFormats.ensure(VertexFormats.BLUR_UP) && VertexFormats.ensure(VertexFormats.BLUR_COPY) && VertexFormats.ensure(VertexFormats.GLASS))) {
            return false;
        }
        try {
            this.ujj(class_2762.field_1482, class_2762.field_1481);
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            class_12137 class_121372 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
            if (n == 0) {
                if (this.uio == null) {
                    GpuDevice gpuDevice = RenderSystem.getDevice();
                    int n2 = 12;
                    this.uin = gpuDevice.createTexture(() -> "Flow2 " + this.uik + " copy", n2, TextureFormat.RGBA8, this.uip, this.uiq, 1, 1);
                    this.uio = gpuDevice.createTextureView(this.uin);
                }
                SceneCapture.uji(commandEncoder, VertexFormats.BLUR_COPY, gpuTextureView2, this.uio, class_121372);
                this.uir = this.uio;
            } else {
                int n3;
                int n4;
                SceneCapture uij2;
                for (n4 = n; n4 > 1 && this.uip >> n4 < 2; --n4) {
                }
                uij2 = gpuTextureView2;
                for (n3 = 0; n3 < n4; ++n3) {
                    SceneCapture.uji(commandEncoder, VertexFormats.BLUR_DOWN, (GpuTextureView)uij2, this.uim[n3], class_121372);
                    uij2 = this.uim[n3];
                }
                for (n3 = n4 - 1; n3 > 0; --n3) {
                    SceneCapture.uji(commandEncoder, VertexFormats.BLUR_UP, this.uim[n3], this.uim[n3 - 1], class_121372);
                }
                this.uir = this.uim[0];
            }
            this.uis = l;
            this.uit = n;
            this.uiu = gpuTextureView2;
            this.ujg();
            return true;
        }
        catch (Throwable throwable) {
            System.out.println("blur (" + this.uik + ") failed: " + throwable);
            this.uir = null;
            return false;
        }
    }

    private static SceneCapture[] ujf() {
        if (ujc == null) {
            ujc = new SceneCapture[]{SCENE, BACKDROP, HUD, TAGS};
        }
        return ujc;
    }

    private void ujg() {
        class_4184 class_41842 = class_310.method_1551().field_1773.method_19418();
        class_243 class_2432 = class_41842.method_71156();
        this.uix = class_2432.field_1352;
        this.uiy = class_2432.field_1351;
        this.uiz = class_2432.field_1350;
        this.uja = class_41842.method_19330();
        this.ujb = class_41842.method_19329();
    }

    private boolean ujh() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1773 == null || class_3102.field_1687 == null) {
            return false;
        }
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_71156();
        return class_2432.method_1028(this.uix, this.uiy, this.uiz) < 1.0E-6 && Math.abs(class_41842.method_19330() - this.uja) < 0.01f && Math.abs(class_41842.method_19329() - this.ujb) < 0.01f;
    }

    public @Nullable GpuTextureView result(class_332 class_3322) {
        FrameDelta.observe(class_3322);
        return this.uis == FrameDelta.frame() ? this.uir : null;
    }

    private static void uji(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, class_12137 class_121372) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 blur", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, class_121372);
            renderPass.draw(0, 3);
        }
    }

    private void ujj(int n, int n2) {
        if (n == this.uip && n2 == this.uiq && this.uim[0] != null) {
            return;
        }
        this.ujk();
        GpuDevice gpuDevice = RenderSystem.getDevice();
        int n3 = 12;
        for (int i = 0; i < 6; ++i) {
            int n4 = Math.max(1, n >> i + 1);
            int n5 = Math.max(1, n2 >> i + 1);
            int n6 = i;
            this.uil[i] = gpuDevice.createTexture(() -> "Flow2 " + this.uik + " blur " + n6, n3, TextureFormat.RGBA8, n4, n5, 1, 1);
            this.uim[i] = gpuDevice.createTextureView(this.uil[i]);
        }
        this.uip = n;
        this.uiq = n2;
    }

    private void ujk() {
        if (this.uio != null) {
            this.uio.close();
            this.uio = null;
        }
        if (this.uin != null) {
            this.uin.close();
            this.uin = null;
        }
        for (int i = 0; i < 6; ++i) {
            if (this.uim[i] != null) {
                this.uim[i].close();
                this.uim[i] = null;
            }
            if (this.uil[i] == null) continue;
            this.uil[i].close();
            this.uil[i] = null;
        }
        this.uir = null;
        this.uip = -1;
        this.uiq = -1;
    }

    private static /* synthetic */ int cxg(int n, int n2) {
        return n * n2 | 0xE18F6C63;
    }
}

