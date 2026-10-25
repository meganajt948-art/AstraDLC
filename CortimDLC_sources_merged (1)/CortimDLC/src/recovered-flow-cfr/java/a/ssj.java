/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.entity.EntityRenderer
 *  net.minecraft.client.render.entity.LivingEntityRenderer
 *  net.minecraft.client.render.entity.model.BipedEntityModel
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.LivingEntityRenderState
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.RotationAxis
 *  org.joml.Matrix3f
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.spg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.jspecify.annotations.Nullable;

final class ssj {
    private static final float ssk = 0.9375f;
    private static /* synthetic */ long ssl;
    private static /* synthetic */ int ssm;

    private ssj() {
    }

    static @Nullable List<spg> capture(MinecraftClient minecraftClient, LivingEntity livingEntity, float f, double[] dArray) {
        try {
            EntityRenderer entityRenderer = minecraftClient.method_1561().method_3953((Entity)livingEntity);
            if (!(entityRenderer instanceof LivingEntityRenderer)) {
                return null;
            }
            LivingEntityRenderer livingEntityRenderer = (LivingEntityRenderer)entityRenderer;
            EntityRenderState entityRenderState = entityRenderer.method_62425((Entity)livingEntity, f);
            if (!(entityRenderState instanceof LivingEntityRenderState)) {
                return null;
            }
            LivingEntityRenderState livingEntityRenderState = (LivingEntityRenderState)entityRenderState;
            EntityModel entityModel = livingEntityRenderer.method_4038();
            ssj.ssr(entityModel, livingEntityRenderState);
            boolean bl = entityModel instanceof BipedEntityModel;
            boolean bl2 = livingEntity instanceof PlayerEntity;
            MatrixStack matrixStack = ssj.sso(livingEntityRenderState.field_53453, livingEntityRenderState.field_53446, bl2 ? 0.9375f : 1.0f);
            ArrayList arrayList = new ArrayList();
            entityModel.method_63512().method_35745(matrixStack, (entry, string, n, cuboid) -> {
                if (bl && string.lastIndexOf(47) > 0) {
                    return;
                }
                arrayList.add(ssj.ssp(entry.method_23761(), entry.method_23762(), cuboid.field_3645, cuboid.field_3644, cuboid.field_3643, cuboid.field_3648, cuboid.field_3647, cuboid.field_3646, ssj.ssq(livingEntity, string, bl)));
            });
            entityModel.method_63514();
            dArray[0] = livingEntityRenderState.field_53325;
            dArray[1] = livingEntityRenderState.field_53326;
            dArray[2] = livingEntityRenderState.field_53327;
            return arrayList.isEmpty() || arrayList.size() > 64 ? null : arrayList;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static List<spg> steve(float f, float f2) {
        MatrixStack matrixStack = ssj.sso(1.0f, f, 0.9375f * f2);
        ArrayList<spg> arrayList = new ArrayList<spg>();
        ssj.ssn(arrayList, matrixStack, 0.0f, 0.0f, 0.0f, -4.0f, -8.0f, -4.0f, 4.0f, 0.0f, 4.0f);
        ssj.ssn(arrayList, matrixStack, 0.0f, 0.0f, 0.0f, -4.0f, 0.0f, -2.0f, 4.0f, 12.0f, 2.0f);
        ssj.ssn(arrayList, matrixStack, -5.0f, 2.0f, 0.0f, -3.0f, -2.0f, -2.0f, 1.0f, 10.0f, 2.0f);
        ssj.ssn(arrayList, matrixStack, 5.0f, 2.0f, 0.0f, -1.0f, -2.0f, -2.0f, 3.0f, 10.0f, 2.0f);
        ssj.ssn(arrayList, matrixStack, -1.9f, 12.0f, 0.0f, -2.0f, 0.0f, -2.0f, 2.0f, 12.0f, 2.0f);
        ssj.ssn(arrayList, matrixStack, 1.9f, 12.0f, 0.0f, -2.0f, 0.0f, -2.0f, 2.0f, 12.0f, 2.0f);
        return arrayList;
    }

    private static void ssn(List<spg> list, MatrixStack matrixStack, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        matrixStack.method_22903();
        matrixStack.method_46416(f / 16.0f, f2 / 16.0f, f3 / 16.0f);
        MatrixStack.Entry entry = matrixStack.method_23760();
        list.add(ssj.ssp(entry.method_23761(), entry.method_23762(), f4, f5, f6, f7, f8, f9, 0.6f));
        matrixStack.method_22909();
    }

    private static MatrixStack sso(float f, float f2, float f3) {
        MatrixStack matrixStack = new MatrixStack();
        matrixStack.method_22905(f, f, f);
        matrixStack.method_22907((Quaternionfc)RotationAxis.field_40716.rotationDegrees(180.0f - f2));
        matrixStack.method_22905(-1.0f, -1.0f, 1.0f);
        matrixStack.method_22905(f3, f3, f3);
        matrixStack.method_46416(0.0f, -1.501f, 0.0f);
        return matrixStack;
    }

    private static spg ssp(Matrix4f matrix4f, Matrix3f matrix3f, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f).translate((f + f4) / 32.0f, (f2 + f5) / 32.0f, (f3 + f6) / 32.0f);
        float f8 = f7 / 16.0f;
        return new spg(matrix4f2, new Matrix3f((Matrix3fc)matrix3f), (f4 - f) / 32.0f + f8, (f5 - f2) / 32.0f + f8, (f6 - f3) / 32.0f + f8);
    }

    private static float ssq(LivingEntity livingEntity, String string, boolean bl) {
        EquipmentSlot equipmentSlot;
        if (!bl) {
            return 0.35f;
        }
        switch (string) {
            case "/head": {
                EquipmentSlot equipmentSlot2 = EquipmentSlot.field_6169;
                break;
            }
            case "/body": 
            case "/right_arm": 
            case "/left_arm": {
                EquipmentSlot equipmentSlot2 = EquipmentSlot.field_6174;
                break;
            }
            case "/right_leg": 
            case "/left_leg": {
                EquipmentSlot equipmentSlot2 = EquipmentSlot.field_6172;
                break;
            }
            default: {
                EquipmentSlot equipmentSlot2 = equipmentSlot = null;
            }
        }
        if (equipmentSlot == null) {
            return 0.6f;
        }
        boolean bl2 = !livingEntity.method_6118(equipmentSlot).method_7960() || equipmentSlot == EquipmentSlot.field_6172 && !livingEntity.method_6118(EquipmentSlot.field_6166).method_7960();
        return bl2 ? 1.1f : 0.6f;
    }

    private static void ssr(EntityModel entityModel, LivingEntityRenderState livingEntityRenderState) {
        entityModel.method_2819((Object)livingEntityRenderState);
    }

    private static /* synthetic */ int cfy(int n, int n2) {
        return n - n2 + 285986961;
    }

    private static /* synthetic */ int cfz(int n, int n2) {
        return n + n2 ^ 0xE42D6525;
    }
}

