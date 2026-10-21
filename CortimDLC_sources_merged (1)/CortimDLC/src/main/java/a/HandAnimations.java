/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_742
 *  net.minecraft.class_7833
 *  org.joml.Quaternionfc
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.SmashHud;
import a.HandRendererHook;
import a.vhs;
import a.HandHooks;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_742;
import net.minecraft.class_7833;
import org.joml.Quaternionfc;

public class HandAnimations
extends Module
implements vhs {
    private static final float ruh = (float)Math.PI;
    private final BoolSetting rui = this.add(new BoolSetting("Only main hand", true));
    private final ModeSetting ruj = this.add(new ModeSetting("Mode", "Smooth", "Smooth", "Static", "Down", "Poke", "SelfBack", "Feast", "ToBack", "Block", "Akrien", "Break", "Pander", "Slant"));
    private final NumberSetting ruk = this.add(new NumberSetting("Strength", 1.2, 0.1, 3.0, 0.01).unit("x"));
    private final BoolSetting rul = this.add(new BoolSetting("Mace charge", true));
    private float rum;
    private long run;
    private static /* synthetic */ int ruo;
    private static /* synthetic */ boolean rup;

    public HandAnimations() {
        super(new String(new char[]{'S', 'w', 'i', 'n', 'g', 'A', 'n', 'i', 'm', 'a', 't', 'i', 'o', 'n', 's'}), "Swing animations for the held item", ModuleCategory.RENDER);
        HandHooks.register(this);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        HandRendererHook.ensureInstalled(class_3102);
    }

    @Override
    public boolean active() {
        return this.isEnabled();
    }

    @Override
    public boolean handles(class_742 class_7422, class_1268 class_12682, class_1799 class_17992) {
        if (class_17992.method_7960() || class_17992.method_31574(class_1802.field_8204)) {
            return false;
        }
        if (this.rui.get() && class_12682 != class_1268.field_5808) {
            return false;
        }
        return !class_7422.method_6115() || class_7422.method_6058() != class_12682;
    }

    @Override
    public void apply(class_4587 class_45872, class_742 class_7422, class_1306 class_13062, class_1268 class_12682, float f, class_1799 class_17992, float f2) {
        int n;
        int n2 = n = class_13062 == class_1306.field_6183 ? 1 : -1;
        if (class_17992.method_31574(class_1802.field_49814)) {
            this.rur(class_45872, class_7422, n, System.nanoTime());
        }
        this.ruq(class_45872, n, f, (float)this.ruk.get());
        class_45872.method_46416(-0.56f * (float)n, 0.52f, 0.72f);
    }

    private void ruq(class_4587 class_45872, int n, float f, float f2) {
        float f3 = class_3532.method_15374((double)(f * f * (float)Math.PI));
        float f4 = class_3532.method_15374((double)(class_3532.method_15355((float)f) * (float)Math.PI));
        float f5 = class_3532.method_15374((double)(f * (float)Math.PI));
        switch (this.ruj.get()) {
            case "Static": {
                class_45872.method_46416((float)n * 0.56f, -0.42f, -0.72f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * -60.0f * f2));
                class_45872.method_46416(0.0f, -0.1f, 0.0f);
                break;
            }
            case "Down": {
                class_45872.method_46416((float)n * 0.56f, -0.32f, -0.72f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(76.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f4 * -5.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40713.rotationDegrees(f4 * -100.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * -155.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-100.0f));
                break;
            }
            case "Poke": {
                class_45872.method_46416((float)n * 0.56f, -0.52f, -0.72f);
                class_45872.method_46416(0.0f, 0.0f, f2 / 3.0f * -f5);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(75.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((-75.0f * (f2 / 4.0f) * f5 - 60.0f) * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-75.0f));
                break;
            }
            case "SelfBack": {
                class_45872.method_46416(0.65f * (float)n, -0.3f, -0.8f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(90.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(-70.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-100.0f - 60.0f * f2 * f5));
                break;
            }
            case "Feast": {
                class_45872.method_46416((float)n * 0.56f, -0.32f, -0.72f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(30.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f4 * 75.0f * (float)n * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * -65.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(30.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-80.0f));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(35.0f * (float)n));
                break;
            }
            case "ToBack": {
                class_45872.method_46416(0.65f * (float)n, -0.45f, -0.9f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(50.0f));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((-30.0f * (1.0f - f4 * f2) - 30.0f) * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(110.0f * (float)n));
                break;
            }
            case "Block": {
                if (f > 0.0f) {
                    class_45872.method_46416(0.56f * (float)n, -0.5f, -0.7f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(45.0f * (float)n));
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * -85.0f * f2));
                    class_45872.method_46416(-0.1f * (float)n, 0.28f, 0.2f);
                    class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-85.0f));
                    break;
                }
                class_45872.method_46416(0.56f * (float)n, -0.52f, -0.72f);
                break;
            }
            case "Akrien": {
                class_45872.method_46416((float)n * 0.65f, -0.32f, -0.72f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(76.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f4 * -5.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40713.rotationDegrees(f4 * -100.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * -155.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-100.0f));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f4 * 25.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40713.rotationDegrees(f4 * -25.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40713.rotationDegrees(f3 * 15.0f * f2));
                class_45872.method_46416(f4 * 0.18f * f2, f4 * 0.59f * f2, 0.0f);
                break;
            }
            case "Break": {
                class_45872.method_46416(0.66f * (float)n, -0.3f, -0.38f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(270.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * 10.0f * f2));
                class_45872.method_22905(0.5f, 0.5f, 0.5f);
                class_45872.method_46416(-0.1f * (float)n, 0.2f, 0.0f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-10.0f * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(90.0f));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-105.0f * (float)n));
                break;
            }
            case "Pander": {
                class_45872.method_46416((float)n * 0.56f, -0.52f, -0.72f);
                class_45872.method_46416((0.3f - f5 * 0.15f) * (float)n, 0.08f, -0.15f - f5 * 0.13f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((76.0f - 10.0f * f5) * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((-16.0f - 8.0f * f5) * (float)n));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-83.0f - 26.0f * f5));
                break;
            }
            case "Slant": {
                float f6 = 35.0f * f2;
                class_45872.method_46416((float)n * 0.56f, -0.52f, -0.72f);
                class_45872.method_46416(0.0f, 0.0f, -0.3f * f5 * f2);
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f5 * -f6));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f5 * f6));
                break;
            }
            default: {
                class_45872.method_46416(0.56f * (float)n, -0.52f, -0.72f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)n * (45.0f + f3 * -20.0f * f2)));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((float)n * f4 * -20.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4 * -80.0f * f2));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)n * -45.0f));
            }
        }
    }

    private void rur(class_4587 class_45872, class_742 class_7422, float f, long l) {
        float f2 = this.run == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.run) / 1.0E9f);
        this.run = l;
        float f3 = 0.0f;
        if (this.rul.get() && !class_7422.method_24828() && !class_7422.method_6128() && class_7422.field_6017 > 1.5) {
            f3 = 0.25f + 0.75f * Math.min(1.0f, SmashHud.smashBonus(class_7422.field_6017) / 22.0f);
        }
        this.rum += (f3 - this.rum) * (1.0f - (float)Math.exp((double)(-f2) * (f3 > this.rum ? 9.0 : 14.0)));
        if (this.rum < 0.005f) {
            this.rum = 0.0f;
            return;
        }
        float f4 = this.rum;
        float f5 = f4 > 0.92f ? class_3532.method_15374((double)((float)l / 1.0E9f * 46.0f)) * (f4 - 0.92f) * 14.0f : 0.0f;
        class_45872.method_46416(-0.03f * f * f4, 0.07f * f4, -0.08f * f4);
        class_45872.method_46416(0.56f * f, -0.52f, -0.72f);
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-12.0f * f4));
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f * (-5.0f * f4 + f5)));
        class_45872.method_46416(-0.56f * f, 0.52f, 0.72f);
    }

    private static /* synthetic */ int cbr(int n, int n2) {
        return n * n2 + 1589528203;
    }
}

