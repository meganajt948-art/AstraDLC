/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.GradePass;
import a.ModeSetting;
import a.NumberSetting;
import net.minecraft.class_310;

public class ColorGrading
extends Module {
    private final ModeSetting rml = this.add(new ModeSetting("Look", "Soft", "Soft", "Vivid", "Warm", "Cold", "Cinema", "Custom"));
    private final NumberSetting rmm = this.add(new NumberSetting("Colour", 1.15, 0.5, 1.8, 0.05).percent());
    private final NumberSetting rmn = this.add(new NumberSetting("Contrast", 1.05, 0.7, 1.4, 0.01).percent());
    private final NumberSetting rmo = this.add(new NumberSetting("Warmth", 0.1, -1.0, 1.0, 0.05).percent());
    private final NumberSetting rmp = this.add(new NumberSetting("Vignette", 0.25, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rmq = this.add(new NumberSetting("Sharpen", 0.3, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rmr = this.add(new NumberSetting("Glow", 0.25, 0.0, 1.0, 0.05).percent());
    private static final float[][] rms = new float[][]{{1.12f, 1.04f, 0.08f, 0.22f, 0.25f, 0.2f}, {1.38f, 1.1f, 0.05f, 0.25f, 0.35f, 0.25f}, {1.15f, 1.05f, 0.5f, 0.3f, 0.25f, 0.3f}, {1.1f, 1.06f, -0.45f, 0.25f, 0.25f, 0.2f}, {0.92f, 1.16f, 0.2f, 0.55f, 0.2f, 0.35f}};
    private static /* synthetic */ long rmt;
    private static /* synthetic */ long rmu;

    public ColorGrading() {
        super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 's'}), "Richer colour, soft glow, crisp image", ModuleCategory.RENDER);
        for (NumberSetting vmc2 : new NumberSetting[]{this.rmm, this.rmn, this.rmo, this.rmp, this.rmq, this.rmr}) {
            vmc2.visibleWhen(() -> this.rml.is("Custom"));
        }
    }

    @Override
    protected void onDisable() {
        GradePass.release();
    }

    @Override
    public void onWorldRenderLate(class_310 class_3102) {
        int n = this.rml.index();
        float[] fArray = n < rms.length ? rms[n] : new float[]{(float)this.rmm.get(), (float)this.rmn.get(), (float)this.rmo.get(), (float)this.rmp.get(), (float)this.rmq.get(), (float)this.rmr.get()};
        GradePass.apply(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5], 1.0f);
    }

    private static /* synthetic */ int bzs(int n, int n2) {
        return n ^ n2 ^ 0xD3CF1C73;
    }

    private static /* synthetic */ int bzt(int n, int n2) {
        return n * n2 | 0x5BD0A776;
    }

    private static /* synthetic */ int bzu(int n, int n2) {
        return ColorGrading.bzs(n, n2) * n2;
    }
}

