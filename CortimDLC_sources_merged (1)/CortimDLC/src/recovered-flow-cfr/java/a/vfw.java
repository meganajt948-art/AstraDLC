/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.gui.render.state.SimpleGuiElementRenderState
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.texture.TextureSetup
 *  org.joml.Matrix3x2f
 *  org.joml.Matrix3x2fc
 *  org.jspecify.annotations.Nullable
 */
package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.jspecify.annotations.Nullable;

public final class vfw
extends Record
implements SimpleGuiElementRenderState {
    private final TextureSetup vfx;
    private final Matrix3x2f vfy;
    private final float[] vfz;
    private final int[] vga;
    private final int vgb;
    private final @Nullable ScreenRect vgc;
    private final @Nullable ScreenRect vgd;
    private static /* synthetic */ int vge;
    private static /* synthetic */ long vgf;

    public vfw(TextureSetup textureSetup, Matrix3x2f matrix3x2f, float[] fArray, int[] nArray, int n, @Nullable ScreenRect screenRect, @Nullable ScreenRect screenRect2) {
        this.vfx = textureSetup;
        this.vfy = matrix3x2f;
        this.vfz = fArray;
        this.vga = nArray;
        this.vgb = n;
        this.vgc = screenRect;
        this.vgd = screenRect2;
    }

    public RenderPipeline pipeline() {
        return RenderPipelines.GUI_TEXTURED;
    }

    public void setupVertices(VertexConsumer vertices) {
        for (int i = 0; i < this.vgb; ++i) {
            int n = i * 8;
            float f = this.vfz[n];
            float f2 = this.vfz[n + 1];
            float f3 = this.vfz[n + 2];
            float f4 = this.vfz[n + 3];
            float f5 = this.vfz[n + 4];
            float f6 = this.vfz[n + 5];
            float f7 = this.vfz[n + 6];
            float f8 = this.vfz[n + 7];
            int n2 = this.vga[i];
            vertices.vertex((Matrix3x2fc)this.vfy, f, f2).texture(f5, f6).color(n2);
            vertices.vertex((Matrix3x2fc)this.vfy, f, f4).texture(f5, f8).color(n2);
            vertices.vertex((Matrix3x2fc)this.vfy, f3, f4).texture(f7, f8).color(n2);
            vertices.vertex((Matrix3x2fc)this.vfy, f3, f2).texture(f7, f6).color(n2);
        }
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{vfw.class, "textureSetup;pose;quads;colors;count;scissorArea;bounds", "vfx", "vfy", "vfz", "vga", "vgb", "vgc", "vgd"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{vfw.class, "textureSetup;pose;quads;colors;count;scissorArea;bounds", "vfx", "vfy", "vfz", "vga", "vgb", "vgc", "vgd"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{vfw.class, "textureSetup;pose;quads;colors;count;scissorArea;bounds", "vfx", "vfy", "vfz", "vga", "vgb", "vgc", "vgd"}, this, object);
    }

    public TextureSetup textureSetup() {
        return this.vfx;
    }

    public Matrix3x2f pose() {
        return this.vfy;
    }

    public float[] quads() {
        return this.vfz;
    }

    public int[] colors() {
        return this.vga;
    }

    public int count() {
        return this.vgb;
    }

    public @Nullable ScreenRect scissorArea() {
        return this.vgc;
    }

    public @Nullable ScreenRect bounds() {
        return this.vgd;
    }

    private static /* synthetic */ int den(int n, int n2) {
        return n - n2 ^ 0x75A22607;
    }
}

