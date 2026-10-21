/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2874$class_12326
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.CloudHider;
import a.SkyPass;
import a.SkyStyle;
import a.BoolSetting;
import a.ColorSetting;
import a.ModeSetting;
import a.NumberSetting;
import net.minecraft.class_2874;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;

public class SkyShader
extends Module {
    private static final String rqg = "Own";
    private final ModeSetting rqh;
    private final ModeSetting rqi;
    private final ColorSetting rqj;
    private final NumberSetting rqk;
    private final NumberSetting rql;
    private final NumberSetting rqm;
    private final NumberSetting rqn;
    private final BoolSetting rqo;
    private final ModeSetting rqp;
    private final Matrix4f rqq;
    private long rqr;
    private float rqs;
    private static /* synthetic */ int rqt;
    private static /* synthetic */ long rqu;

    public SkyShader() {
        super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 'S', 'k', 'y'}), "Animated shader sky", ModuleCategory.RENDER);
        this.rqh = this.add(new ModeSetting("Sky", SkyStyle.AURORA.title, SkyStyle.titles()));
        this.rqi = this.add(new ModeSetting("Palette", rqg, rqg, "Custom"));
        this.rqj = this.add(new ColorSetting("Colour", "Violet"));
        this.rqk = this.add(new NumberSetting("Brightness", 1.0, 0.3, 1.6, 0.05).percent());
        this.rql = this.add(new NumberSetting("Speed", 1.0, 0.0, 4.0, 0.1).unit("x"));
        this.rqm = this.add(new NumberSetting("Stars", 1.0, 0.0, 2.0, 0.05).percent());
        this.rqn = this.add(new NumberSetting("Horizon blend", 1.0, 0.0, 1.0, 0.05).percent());
        this.rqo = this.add(new BoolSetting("Hide clouds", true));
        this.rqp = this.add(new ModeSetting("Quality", "High", "Low", "High"));
        this.rqq = new Matrix4f();
        this.rqj.visibleWhen(() -> this.rqi.is("Custom"));
        this.rqm.activeWhen(() -> SkyStyle.of((String)this.rqh.get()).stars > 0.0f);
    }

    @Override
    protected void onEnable() {
        this.rqr = 0L;
        SkyPass.release();
    }

    @Override
    protected void onDisable() {
        CloudHider.hide(this, false);
    }

    @Override
    public void onWorldRender(class_310 class_3102) {
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        class_2874.class_12326 class_123262 = class_3102.field_1687.method_8597().comp_5220();
        boolean bl = class_123262 != class_2874.class_12326.field_64385 && class_41842.method_19332() && class_41842.method_19334() == class_5636.field_27888;
        CloudHider.hide(this, bl && this.rqo.get());
        long l = System.nanoTime();
        this.rqs += this.rqr == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.rqr) / 1.0E9f) * (float)this.rql.get();
        this.rqr = l;
        if (!bl) {
            return;
        }
        SkyStyle uxt2 = SkyStyle.of(this.rqh.get());
        int n = uxt2.color1;
        int n2 = uxt2.color2;
        if (this.rqi.is("Custom")) {
            int[] nArray = this.rqj.vivid(new int[]{uxt2.color1, uxt2.color2});
            n = nArray[0];
            n2 = nArray[1];
        }
        this.rqq.rotation((Quaternionfc)class_41842.method_23767());
        float f = class_123262 == class_2874.class_12326.field_64386 ? (float)this.rqn.get() : 0.0f;
        SkyPass.draw(this.rqq, uxt2, 40.0f + this.rqs, (float)this.rqk.get(), f, n, n2, this.rqp.is("Low") ? 3 : 4, uxt2.stars * (float)this.rqm.get());
    }

    private static /* synthetic */ int cax(int n, int n2) {
        return n ^ n2 | 0x7CA23A98;
    }
}

