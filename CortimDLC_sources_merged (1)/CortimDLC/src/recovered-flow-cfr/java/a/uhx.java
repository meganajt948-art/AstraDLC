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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.TextureSetup;
import org.jspecify.annotations.Nullable;

final class uhx
implements SimpleGuiElementRenderState {
    private final RenderPipeline uhy;
    private final TextureSetup uhz;
    private final @Nullable ScreenRect uia;
    private final List<SimpleGuiElementRenderState> uib = new ArrayList<SimpleGuiElementRenderState>();
    private int uic = Integer.MAX_VALUE;
    private int uid = Integer.MAX_VALUE;
    private int uie = Integer.MIN_VALUE;
    private int uif = Integer.MIN_VALUE;
    private @Nullable ScreenRect uig;
    private static /* synthetic */ int uih;
    private static /* synthetic */ long uii;

    uhx(SimpleGuiElementRenderState simpleGuiElementRenderState) {
        this.uhy = simpleGuiElementRenderState.pipeline();
        this.uhz = simpleGuiElementRenderState.textureSetup();
        this.uia = simpleGuiElementRenderState.scissorArea();
        this.add(simpleGuiElementRenderState);
    }

    boolean accepts(SimpleGuiElementRenderState simpleGuiElementRenderState) {
        return simpleGuiElementRenderState.pipeline() == this.uhy && Objects.equals(simpleGuiElementRenderState.scissorArea(), this.uia) && simpleGuiElementRenderState.textureSetup().equals((Object)this.uhz);
    }

    void add(SimpleGuiElementRenderState simpleGuiElementRenderState) {
        ScreenRect screenRect = simpleGuiElementRenderState.bounds();
        if (screenRect == null) {
            return;
        }
        this.uib.add(simpleGuiElementRenderState);
        this.uic = Math.min(this.uic, screenRect.getLeft());
        this.uid = Math.min(this.uid, screenRect.getTop());
        this.uie = Math.max(this.uie, screenRect.getRight());
        this.uif = Math.max(this.uif, screenRect.getBottom());
        this.uig = null;
    }

    boolean isEmpty() {
        return this.uib.isEmpty();
    }

    public void setupVertices(VertexConsumer vertices) {
        for (SimpleGuiElementRenderState simpleGuiElementRenderState : this.uib) {
            simpleGuiElementRenderState.setupVertices(vertices);
        }
    }

    public RenderPipeline pipeline() {
        return this.uhy;
    }

    public TextureSetup textureSetup() {
        return this.uhz;
    }

    public @Nullable ScreenRect scissorArea() {
        return this.uia;
    }

    public @Nullable ScreenRect bounds() {
        if (this.uig == null && this.uie > this.uic && this.uif > this.uid) {
            this.uig = new ScreenRect(this.uic, this.uid, this.uie - this.uic, this.uif - this.uid);
        }
        return this.uig;
    }

    private static /* synthetic */ int cxb(int n, int n2) {
        return n * n2 | 0x43EF2CA3;
    }

    private static /* synthetic */ int cxc(int n, int n2) {
        return (n ^ n2) + 557115282;
    }

    private static /* synthetic */ int cxd(int n, int n2) {
        return uhx.cxb(n, n2) + n;
    }
}

