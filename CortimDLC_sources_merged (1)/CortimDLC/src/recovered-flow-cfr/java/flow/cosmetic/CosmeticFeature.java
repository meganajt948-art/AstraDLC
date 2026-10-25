/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.model.PlayerEntityModel
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.util.math.MatrixStack
 */
package flow.cosmetic;

import flow.cosmetic.Cosmetics;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;

public final class CosmeticFeature
extends FeatureRenderer<PlayerEntityRenderState, PlayerEntityModel> {
    private final boolean lead;

    public CosmeticFeature(FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel> context, boolean lead) {
        super(context);
        this.lead = lead;
    }

    public void render(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, PlayerEntityRenderState state, float limbAngle, float limbDistance) {
        if (this.lead) {
            Cosmetics.renderWorn((PlayerEntityModel)this.getContextModel(), matrices, queue, light, state);
        } else {
            Cosmetics.restoreArms();
        }
    }
}

