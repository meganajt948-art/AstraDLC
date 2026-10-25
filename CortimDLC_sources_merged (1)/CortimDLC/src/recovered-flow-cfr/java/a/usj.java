/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.ItemEntityRenderer
 *  net.minecraft.client.render.entity.state.ItemEntityRenderState
 *  net.minecraft.client.render.entity.state.ItemStackEntityRenderState
 *  net.minecraft.client.render.state.CameraRenderState
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.util.math.random.Random
 *  org.joml.Quaternionfc
 */
package a;

import a.rfp;
import a.usg;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.state.ItemEntityRenderState;
import net.minecraft.client.render.entity.state.ItemStackEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import org.joml.Quaternionfc;

public final class usj
extends ItemEntityRenderer {
    private final Random usk = Random.create();
    private static /* synthetic */ long usl;
    private static /* synthetic */ boolean usm;

    public usj(EntityRendererFactory.Context context) {
        super(context);
    }

    public ItemEntityRenderState createRenderState() {
        return new usg();
    }

    public void updateRenderState(ItemEntity itemEntity, ItemEntityRenderState itemEntityRenderState, float f) {
        super.updateRenderState(itemEntity, itemEntityRenderState, f);
        if (itemEntityRenderState instanceof usg) {
            usg usg2 = (usg)itemEntityRenderState;
            usg2.onGround = itemEntity.isOnGround();
            usg2.inWater = itemEntity.isTouchingWater();
            usg2.id = itemEntity.getId();
        }
    }

    public void render(ItemEntityRenderState itemEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        usg usg2;
        block8: {
            block7: {
                if (!rfp.on() || !(itemEntityRenderState instanceof usg)) break block7;
                usg2 = (usg)itemEntityRenderState;
                if (!itemEntityRenderState.itemRenderState.isEmpty()) break block8;
            }
            super.render(itemEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
            return;
        }
        Box box = itemEntityRenderState.itemRenderState.getModelBoundingBox();
        boolean bl = box.getLengthZ() <= 0.0625;
        float f = (float)usg2.id * 137.508f % 360.0f;
        int n = Math.max(1, itemEntityRenderState.renderedAmount);
        matrixStack.push();
        if (usg2.onGround && !usg2.inWater) {
            if (bl) {
                float f2 = (float)(box.getLengthZ() * 0.5) + (float)(n - 1) * 0.046875f + 0.004f;
                matrixStack.translate(0.0f, f2, 0.0f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f));
                matrixStack.multiply((Quaternionfc)RotationAxis.NEGATIVE_X.rotationDegrees(90.0f));
                matrixStack.translate((float)(-box.getCenter().x), (float)(-box.getCenter().y), 0.0f);
            } else {
                matrixStack.translate(0.0f, (float)(-box.minY), 0.0f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f));
            }
        } else {
            float f3 = itemEntityRenderState.age * (usg2.inWater ? 4.0f : 14.0f) * rfp.spin();
            matrixStack.translate(0.0f, (float)(-box.minY + 0.0625), 0.0f);
            matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f + f3));
            matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f3 * 0.8f));
        }
        ItemEntityRenderer.render((MatrixStack)matrixStack, (OrderedRenderCommandQueue)orderedRenderCommandQueue, (int)itemEntityRenderState.light, (ItemStackEntityRenderState)itemEntityRenderState, (Random)this.usk, (Box)box);
        matrixStack.pop();
    }

    private static /* synthetic */ int dam(int n, int n2) {
        return n + n2 + 1674332874;
    }
}

