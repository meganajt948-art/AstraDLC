/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RotationAxis
 *  org.joml.Quaternionfc
 */
package a;

import a.kfa;
import a.kfe;
import a.rhf;
import a.vgj;
import a.vhs;
import a.vhu;
import a.vkl;
import a.vlv;
import a.vmc;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionfc;

public class rug
extends kfe
implements vhs {
    private static final float ruh = (float)Math.PI;
    private final vkl rui = this.add(new vkl("Only main hand", true));
    private final vlv ruj = this.add(new vlv("Mode", "Smooth", "Smooth", "Static", "Down", "Poke", "SelfBack", "Feast", "ToBack", "Block", "Akrien", "Break", "Pander", "Slant"));
    private final vmc ruk = this.add(new vmc("Strength", 1.2, 0.1, 3.0, 0.01).unit("x"));
    private final vkl rul = this.add(new vkl("Mace charge", true));
    private float rum;
    private long run;
    private static /* synthetic */ int ruo;
    private static /* synthetic */ boolean rup;

    public rug() {
        super(new String(new char[]{'S', 'w', 'i', 'n', 'g', 'A', 'n', 'i', 'm', 'a', 't', 'i', 'o', 'n', 's'}), "Swing animations for the held item", kfa.RENDER);
        vhu.register(this);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        vgj.ensureInstalled(minecraftClient);
    }

    @Override
    public boolean active() {
        return this.isEnabled();
    }

    @Override
    public boolean handles(AbstractClientPlayerEntity abstractClientPlayerEntity, Hand hand, ItemStack itemStack) {
        if (itemStack.isEmpty() || itemStack.isOf(Items.FILLED_MAP)) {
            return false;
        }
        if (this.rui.get() && hand != Hand.MAIN_HAND) {
            return false;
        }
        return !abstractClientPlayerEntity.isUsingItem() || abstractClientPlayerEntity.getActiveHand() != hand;
    }

    @Override
    public void apply(MatrixStack matrixStack, AbstractClientPlayerEntity abstractClientPlayerEntity, Arm arm, Hand hand, float f, ItemStack itemStack, float f2) {
        int n;
        int n2 = n = arm == Arm.RIGHT ? 1 : -1;
        if (itemStack.isOf(Items.MACE)) {
            this.rur(matrixStack, abstractClientPlayerEntity, n, System.nanoTime());
        }
        this.ruq(matrixStack, n, f, (float)this.ruk.get());
        matrixStack.translate(-0.56f * (float)n, 0.52f, 0.72f);
    }

    private void ruq(MatrixStack matrixStack, int n, float f, float f2) {
        float f3 = MathHelper.sin((double)(f * f * (float)Math.PI));
        float f4 = MathHelper.sin((double)(MathHelper.sqrt((float)f) * (float)Math.PI));
        float f5 = MathHelper.sin((double)(f * (float)Math.PI));
        switch (this.ruj.get()) {
            case "Static": {
                matrixStack.translate((float)n * 0.56f, -0.42f, -0.72f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * -60.0f * f2));
                matrixStack.translate(0.0f, -0.1f, 0.0f);
                break;
            }
            case "Down": {
                matrixStack.translate((float)n * 0.56f, -0.32f, -0.72f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(76.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f4 * -5.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.NEGATIVE_X.rotationDegrees(f4 * -100.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * -155.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-100.0f));
                break;
            }
            case "Poke": {
                matrixStack.translate((float)n * 0.56f, -0.52f, -0.72f);
                matrixStack.translate(0.0f, 0.0f, f2 / 3.0f * -f5);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(75.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees((-75.0f * (f2 / 4.0f) * f5 - 60.0f) * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-75.0f));
                break;
            }
            case "SelfBack": {
                matrixStack.translate(0.65f * (float)n, -0.3f, -0.8f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(90.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees(-70.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-100.0f - 60.0f * f2 * f5));
                break;
            }
            case "Feast": {
                matrixStack.translate((float)n * 0.56f, -0.32f, -0.72f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(30.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f4 * 75.0f * (float)n * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * -65.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(30.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-80.0f));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(35.0f * (float)n));
                break;
            }
            case "ToBack": {
                matrixStack.translate(0.65f * (float)n, -0.45f, -0.9f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(50.0f));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees((-30.0f * (1.0f - f4 * f2) - 30.0f) * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees(110.0f * (float)n));
                break;
            }
            case "Block": {
                if (f > 0.0f) {
                    matrixStack.translate(0.56f * (float)n, -0.5f, -0.7f);
                    matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(45.0f * (float)n));
                    matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * -85.0f * f2));
                    matrixStack.translate(-0.1f * (float)n, 0.28f, 0.2f);
                    matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-85.0f));
                    break;
                }
                matrixStack.translate(0.56f * (float)n, -0.52f, -0.72f);
                break;
            }
            case "Akrien": {
                matrixStack.translate((float)n * 0.65f, -0.32f, -0.72f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(76.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f4 * -5.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.NEGATIVE_X.rotationDegrees(f4 * -100.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * -155.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-100.0f));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(f4 * 25.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.NEGATIVE_X.rotationDegrees(f4 * -25.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.NEGATIVE_X.rotationDegrees(f3 * 15.0f * f2));
                matrixStack.translate(f4 * 0.18f * f2, f4 * 0.59f * f2, 0.0f);
                break;
            }
            case "Break": {
                matrixStack.translate(0.66f * (float)n, -0.3f, -0.38f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(270.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * 10.0f * f2));
                matrixStack.scale(0.5f, 0.5f, 0.5f);
                matrixStack.translate(-0.1f * (float)n, 0.2f, 0.0f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(-10.0f * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(90.0f));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(-105.0f * (float)n));
                break;
            }
            case "Pander": {
                matrixStack.translate((float)n * 0.56f, -0.52f, -0.72f);
                matrixStack.translate((0.3f - f5 * 0.15f) * (float)n, 0.08f, -0.15f - f5 * 0.13f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees((76.0f - 10.0f * f5) * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees((-16.0f - 8.0f * f5) * (float)n));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-83.0f - 26.0f * f5));
                break;
            }
            case "Slant": {
                float f6 = 35.0f * f2;
                matrixStack.translate((float)n * 0.56f, -0.52f, -0.72f);
                matrixStack.translate(0.0f, 0.0f, -0.3f * f5 * f2);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f5 * -f6));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees(f5 * f6));
                break;
            }
            default: {
                matrixStack.translate(0.56f * (float)n, -0.52f, -0.72f);
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees((float)n * (45.0f + f3 * -20.0f * f2)));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees((float)n * f4 * -20.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(f4 * -80.0f * f2));
                matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees((float)n * -45.0f));
            }
        }
    }

    private void rur(MatrixStack matrixStack, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, long l) {
        float f2 = this.run == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.run) / 1.0E9f);
        this.run = l;
        float f3 = 0.0f;
        if (this.rul.get() && !abstractClientPlayerEntity.isOnGround() && !abstractClientPlayerEntity.isGliding() && abstractClientPlayerEntity.fallDistance > 1.5) {
            f3 = 0.25f + 0.75f * Math.min(1.0f, rhf.smashBonus(abstractClientPlayerEntity.fallDistance) / 22.0f);
        }
        this.rum += (f3 - this.rum) * (1.0f - (float)Math.exp((double)(-f2) * (f3 > this.rum ? 9.0 : 14.0)));
        if (this.rum < 0.005f) {
            this.rum = 0.0f;
            return;
        }
        float f4 = this.rum;
        float f5 = f4 > 0.92f ? MathHelper.sin((double)((float)l / 1.0E9f * 46.0f)) * (f4 - 0.92f) * 14.0f : 0.0f;
        matrixStack.translate(-0.03f * f * f4, 0.07f * f4, -0.08f * f4);
        matrixStack.translate(0.56f * f, -0.52f, -0.72f);
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-12.0f * f4));
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees(f * (-5.0f * f4 + f5)));
        matrixStack.translate(-0.56f * f, 0.52f, 0.72f);
    }

    private static /* synthetic */ int cbr(int n, int n2) {
        return n * n2 + 1589528203;
    }
}

