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
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.GpuSampler
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.Camera
 *  net.minecraft.util.math.Vec3d
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.unf;
import a.uvq;
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
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import org.jspecify.annotations.Nullable;

public final class uij {
    public static final int MAX_ITERATIONS = 6;
    public static final uij SCENE = new uij("scene");
    public static final uij BACKDROP = new uij("backdrop");
    public static final uij HUD = new uij("hud");
    public static final uij TAGS = new uij("tags");
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
    private static uij[] ujc;
    private static /* synthetic */ int ujd;
    private static /* synthetic */ int uje;

    private uij(String string) {
        this.uik = string;
    }

    public boolean capture(DrawContext drawContext, int n, @Nullable GpuTextureView gpuTextureView) {
        GpuTextureView gpuTextureView2;
        unf.observe(drawContext);
        n = Math.max(0, Math.min(6, n));
        long l = unf.frame();
        Framebuffer framebuffer = MinecraftClient.getInstance().getFramebuffer();
        GpuTextureView gpuTextureView3 = gpuTextureView2 = gpuTextureView != null ? gpuTextureView : framebuffer.getColorAttachmentView();
        if (this.uis == l && this.uit == n && this.uiu == gpuTextureView2 && this.uir != null) {
            return true;
        }
        for (uij uij2 : uij.ujf()) {
            if (uij2 == this || uij2.uis != l || uij2.uit != n || uij2.uiu != gpuTextureView2 || uij2.uir == null) continue;
            this.uir = uij2.uir;
            this.uis = l;
            this.uit = n;
            this.uiu = gpuTextureView2;
            this.uiv = true;
            return true;
        }
        if (gpuTextureView == null && this.uir != null && !this.uiv && !this.uiw && this.uis == l - 1L && this.uit == n && this.uiu == gpuTextureView2 && framebuffer.textureWidth == this.uip && framebuffer.textureHeight == this.uiq && this.ujh()) {
            this.uis = l;
            this.uiw = true;
            return true;
        }
        this.uiw = false;
        this.uiv = false;
        this.uir = null;
        if (gpuTextureView2 == null || framebuffer.textureWidth < 4 || framebuffer.textureHeight < 4) {
            return false;
        }
        if (!(uvq.ensure(uvq.BLUR_DOWN) && uvq.ensure(uvq.BLUR_UP) && uvq.ensure(uvq.BLUR_COPY) && uvq.ensure(uvq.GLASS))) {
            return false;
        }
        try {
            this.ujj(framebuffer.textureWidth, framebuffer.textureHeight);
            CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
            GpuSampler gpuSampler = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            if (n == 0) {
                if (this.uio == null) {
                    GpuDevice gpuDevice = RenderSystem.getDevice();
                    int n2 = 12;
                    this.uin = gpuDevice.createTexture(() -> "Flow2 " + this.uik + " copy", n2, TextureFormat.RGBA8, this.uip, this.uiq, 1, 1);
                    this.uio = gpuDevice.createTextureView(this.uin);
                }
                uij.uji(commandEncoder, uvq.BLUR_COPY, gpuTextureView2, this.uio, gpuSampler);
                this.uir = this.uio;
            } else {
                int n3;
                int n4;
                uij uij2;
                for (n4 = n; n4 > 1 && this.uip >> n4 < 2; --n4) {
                }
                uij2 = gpuTextureView2;
                for (n3 = 0; n3 < n4; ++n3) {
                    uij.uji(commandEncoder, uvq.BLUR_DOWN, (GpuTextureView)uij2, this.uim[n3], gpuSampler);
                    uij2 = this.uim[n3];
                }
                for (n3 = n4 - 1; n3 > 0; --n3) {
                    uij.uji(commandEncoder, uvq.BLUR_UP, this.uim[n3], this.uim[n3 - 1], gpuSampler);
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

    private static uij[] ujf() {
        if (ujc == null) {
            ujc = new uij[]{SCENE, BACKDROP, HUD, TAGS};
        }
        return ujc;
    }

    private void ujg() {
        Camera camera = MinecraftClient.getInstance().gameRenderer.getCamera();
        Vec3d vec3d = camera.getCameraPos();
        this.uix = vec3d.x;
        this.uiy = vec3d.y;
        this.uiz = vec3d.z;
        this.uja = camera.getYaw();
        this.ujb = camera.getPitch();
    }

    private boolean ujh() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.gameRenderer == null || minecraftClient.world == null) {
            return false;
        }
        Camera camera = minecraftClient.gameRenderer.getCamera();
        Vec3d vec3d = camera.getCameraPos();
        return vec3d.squaredDistanceTo(this.uix, this.uiy, this.uiz) < 1.0E-6 && Math.abs(camera.getYaw() - this.uja) < 0.01f && Math.abs(camera.getPitch() - this.ujb) < 0.01f;
    }

    public @Nullable GpuTextureView result(DrawContext drawContext) {
        unf.observe(drawContext);
        return this.uis == unf.frame() ? this.uir : null;
    }

    private static void uji(CommandEncoder commandEncoder, RenderPipeline renderPipeline, GpuTextureView gpuTextureView, GpuTextureView gpuTextureView2, GpuSampler gpuSampler) {
        try (RenderPass renderPass = commandEncoder.createRenderPass(() -> "Flow2 blur", gpuTextureView2, OptionalInt.empty());){
            renderPass.setPipeline(renderPipeline);
            renderPass.bindTexture("InSampler", gpuTextureView, gpuSampler);
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

