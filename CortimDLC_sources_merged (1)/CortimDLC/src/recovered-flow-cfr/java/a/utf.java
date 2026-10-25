/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.gui.render.state.SimpleGuiElementRenderState
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.texture.TextureSetup
 *  org.jspecify.annotations.Nullable
 */
package a;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.jspecify.annotations.Nullable;

final class utf
extends Record
implements SimpleGuiElementRenderState {
    private final RenderPipeline utg;
    private final float uth;
    private final float uti;
    private final float utj;
    private final float utk;
    private final float utl;
    private final float utm;
    private final float utn;
    private final float uto;
    private final int utp;
    private final int utq;
    private final int utr;
    private final int uts;
    private final @Nullable ScreenRect utt;
    private final @Nullable ScreenRect utu;
    private static /* synthetic */ String utv;
    private static /* synthetic */ int utw;

    utf(RenderPipeline renderPipeline, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4, @Nullable ScreenRect screenRect, @Nullable ScreenRect screenRect2) {
        this.utg = renderPipeline;
        this.uth = f;
        this.uti = f2;
        this.utj = f3;
        this.utk = f4;
        this.utl = f5;
        this.utm = f6;
        this.utn = f7;
        this.uto = f8;
        this.utp = n;
        this.utq = n2;
        this.utr = n3;
        this.uts = n4;
        this.utt = screenRect;
        this.utu = screenRect2;
    }

    public TextureSetup textureSetup() {
        return TextureSetup.empty();
    }

    public void setupVertices(VertexConsumer vertices) {
        vertices.vertex(this.uth, this.uti, 0.0f).color(this.utp);
        vertices.vertex(this.utj, this.utk, 0.0f).color(this.utq);
        vertices.vertex(this.utl, this.utm, 0.0f).color(this.utr);
        vertices.vertex(this.utn, this.uto, 0.0f).color(this.uts);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{utf.class, "pipeline;x0;y0;x1;y1;x2;y2;x3;y3;c0;c1;c2;c3;scissorArea;bounds", "utg", "uth", "uti", "utj", "utk", "utl", "utm", "utn", "uto", "utp", "utq", "utr", "uts", "utt", "utu"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{utf.class, "pipeline;x0;y0;x1;y1;x2;y2;x3;y3;c0;c1;c2;c3;scissorArea;bounds", "utg", "uth", "uti", "utj", "utk", "utl", "utm", "utn", "uto", "utp", "utq", "utr", "uts", "utt", "utu"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{utf.class, "pipeline;x0;y0;x1;y1;x2;y2;x3;y3;c0;c1;c2;c3;scissorArea;bounds", "utg", "uth", "uti", "utj", "utk", "utl", "utm", "utn", "uto", "utp", "utq", "utr", "uts", "utt", "utu"}, this, object);
    }

    public RenderPipeline pipeline() {
        return this.utg;
    }

    public float x0() {
        return this.uth;
    }

    public float y0() {
        return this.uti;
    }

    public float x1() {
        return this.utj;
    }

    public float y1() {
        return this.utk;
    }

    public float x2() {
        return this.utl;
    }

    public float y2() {
        return this.utm;
    }

    public float x3() {
        return this.utn;
    }

    public float y3() {
        return this.uto;
    }

    public int c0() {
        return this.utp;
    }

    public int c1() {
        return this.utq;
    }

    public int c2() {
        return this.utr;
    }

    public int c3() {
        return this.uts;
    }

    public @Nullable ScreenRect scissorArea() {
        return this.utt;
    }

    public @Nullable ScreenRect bounds() {
        return this.utu;
    }

    private static /* synthetic */ int dat(int n, int n2) {
        return n ^ n2 ^ 0xD95FAE7;
    }
}

