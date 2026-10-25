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
    private final Random usk = Random.method_43047();
    private static /* synthetic */ long usl;
    private static /* synthetic */ boolean usm;

    public usj(EntityRendererFactory.Context context) {
        super(context);
    }

    public ItemEntityRenderState method_62469() {
        return new usg();
    }

    public void method_62470(ItemEntity itemEntity, ItemEntityRenderState itemEntityRenderState, float f) {
        super.method_62470(itemEntity, itemEntityRenderState, f);
        if (itemEntityRenderState instanceof usg) {
            usg usg2 = (usg)itemEntityRenderState;
            usg2.onGround = itemEntity.method_24828();
            usg2.inWater = itemEntity.method_5799();
            usg2.id = itemEntity.method_5628();
        }
    }

    public void method_3996(ItemEntityRenderState itemEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        usg usg2;
        block8: {
            block7: {
                if (!rfp.on() || !(itemEntityRenderState instanceof usg)) break block7;
                usg2 = (usg)itemEntityRenderState;
                if (!itemEntityRenderState.field_55310.method_65606()) break block8;
            }
            super.method_3996(itemEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
            return;
        }
        Box box = itemEntityRenderState.field_55310.method_72173();
        boolean bl = box.method_17941() <= 0.0625;
        float f = (float)usg2.id * 137.508f % 360.0f;
        int n = Math.max(1, itemEntityRenderState.field_55311);
        matrixStack.method_22903();
        if (usg2.onGround && !usg2.inWater) {
            if (bl) {
                float f2 = (float)(box.method_17941() * 0.5) + (float)(n - 1) * 0.046875f + 0.004f;
                matrixStack.method_46416(0.0f, f2, 0.0f);
                matrixStack.method_22907((Quaternionfc)RotationAxis.field_40716.rotationDegrees(f));
                matrixStack.method_22907((Quaternionfc)RotationAxis.field_40713.rotationDegrees(90.0f));
                matrixStack.method_46416((float)(-box.method_1005().field_1352), (float)(-box.method_1005().field_1351), 0.0f);
            } else {
                matrixStack.method_46416(0.0f, (float)(-box.field_1322), 0.0f);
                matrixStack.method_22907((Quaternionfc)RotationAxis.field_40716.rotationDegrees(f));
            }
        } else {
            float f3 = itemEntityRenderState.field_53328 * (usg2.inWater ? 4.0f : 14.0f) * rfp.spin();
            matrixStack.method_46416(0.0f, (float)(-box.field_1322 + 0.0625), 0.0f);
            matrixStack.method_22907((Quaternionfc)RotationAxis.field_40716.rotationDegrees(f + f3));
            matrixStack.method_22907((Quaternionfc)RotationAxis.field_40714.rotationDegrees(f3 * 0.8f));
        }
        ItemEntityRenderer.method_72986((MatrixStack)matrixStack, (OrderedRenderCommandQueue)orderedRenderCommandQueue, (int)itemEntityRenderState.field_61820, (ItemStackEntityRenderState)itemEntityRenderState, (Random)this.usk, (Box)box);
        matrixStack.method_22909();
    }

    private static /* synthetic */ int dam(int n, int n2) {
        return n + n2 + 1674332874;
    }
}

