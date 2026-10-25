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

final class urt
extends Record
implements SimpleGuiElementRenderState {
    private final RenderPipeline uru;
    private final float[] urv;
    private final int urw;
    private final int urx;
    private final int ury;
    private final int urz;
    private final float usa;
    private final float usb;
    private final @Nullable ScreenRect usc;
    private final @Nullable ScreenRect usd;
    private static /* synthetic */ int use;
    private static /* synthetic */ long usf;

    urt(RenderPipeline renderPipeline, float[] fArray, int n, int n2, int n3, int n4, float f, float f2, @Nullable ScreenRect screenRect, @Nullable ScreenRect screenRect2) {
        this.uru = renderPipeline;
        this.urv = fArray;
        this.urw = n;
        this.urx = n2;
        this.ury = n3;
        this.urz = n4;
        this.usa = f;
        this.usb = f2;
        this.usc = screenRect;
        this.usd = screenRect2;
    }

    public TextureSetup comp_4056() {
        return TextureSetup.method_70899();
    }

    public void method_70917(VertexConsumer vertexConsumer) {
        int n = this.urx >> 16 & 0xFF;
        int n2 = this.urx >> 8 & 0xFF;
        int n3 = this.urx & 0xFF;
        int n4 = Math.max(0, Math.min(255, Math.round(this.usa * 255.0f)));
        int n5 = n << 8 | n2;
        int n6 = n3 << 8 | n4;
        for (int i = 0; i < 4; ++i) {
            int n7 = i * 5;
            float f = this.urv[n7 + 4];
            vertexConsumer.method_22912(this.urv[n7], this.urv[n7 + 1], this.usb).method_39415(this.urw).method_22913(this.urv[n7 + 2] * f, this.urv[n7 + 3] * f).method_60796(this.ury, this.urz).method_22921(n5, n6).method_75298(f);
        }
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{urt.class, "pipeline;corners;color;color2;pattern;flags;param;time;scissorArea;bounds", "uru", "urv", "urw", "urx", "ury", "urz", "usa", "usb", "usc", "usd"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{urt.class, "pipeline;corners;color;color2;pattern;flags;param;time;scissorArea;bounds", "uru", "urv", "urw", "urx", "ury", "urz", "usa", "usb", "usc", "usd"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{urt.class, "pipeline;corners;color;color2;pattern;flags;param;time;scissorArea;bounds", "uru", "urv", "urw", "urx", "ury", "urz", "usa", "usb", "usc", "usd"}, this, object);
    }

    public RenderPipeline comp_4055() {
        return this.uru;
    }

    public float[] corners() {
        return this.urv;
    }

    public int color() {
        return this.urw;
    }

    public int color2() {
        return this.urx;
    }

    public int pattern() {
        return this.ury;
    }

    public int flags() {
        return this.urz;
    }

    public float param() {
        return this.usa;
    }

    public float time() {
        return this.usb;
    }

    public @Nullable ScreenRect comp_4069() {
        return this.usc;
    }

    public @Nullable ScreenRect comp_4274() {
        return this.usd;
    }

    private static /* synthetic */ int dae(int n, int n2) {
        return n - n2 + 1693846022;
    }
}

