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
        this.uhy = simpleGuiElementRenderState.comp_4055();
        this.uhz = simpleGuiElementRenderState.comp_4056();
        this.uia = simpleGuiElementRenderState.comp_4069();
        this.add(simpleGuiElementRenderState);
    }

    boolean accepts(SimpleGuiElementRenderState simpleGuiElementRenderState) {
        return simpleGuiElementRenderState.comp_4055() == this.uhy && Objects.equals(simpleGuiElementRenderState.comp_4069(), this.uia) && simpleGuiElementRenderState.comp_4056().equals((Object)this.uhz);
    }

    void add(SimpleGuiElementRenderState simpleGuiElementRenderState) {
        ScreenRect screenRect = simpleGuiElementRenderState.comp_4274();
        if (screenRect == null) {
            return;
        }
        this.uib.add(simpleGuiElementRenderState);
        this.uic = Math.min(this.uic, screenRect.method_49620());
        this.uid = Math.min(this.uid, screenRect.method_49618());
        this.uie = Math.max(this.uie, screenRect.method_49621());
        this.uif = Math.max(this.uif, screenRect.method_49619());
        this.uig = null;
    }

    boolean isEmpty() {
        return this.uib.isEmpty();
    }

    public void method_70917(VertexConsumer vertexConsumer) {
        for (SimpleGuiElementRenderState simpleGuiElementRenderState : this.uib) {
            simpleGuiElementRenderState.method_70917(vertexConsumer);
        }
    }

    public RenderPipeline comp_4055() {
        return this.uhy;
    }

    public TextureSetup comp_4056() {
        return this.uhz;
    }

    public @Nullable ScreenRect comp_4069() {
        return this.uia;
    }

    public @Nullable ScreenRect comp_4274() {
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

