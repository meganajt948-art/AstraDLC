/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.ColorUtil;
import a.HandRendererHook;
import a.vhe;
import a.HandFx;
import a.BoolSetting;
import a.ColorSetting;
import a.NumberSetting;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_746;
import net.minecraft.class_7923;

public class EnchantGlow
extends Module
implements vhe {
    private final ColorSetting rpu = this.add(new ColorSetting("Color", "Aurora"));
    private final BoolSetting rpv = this.add(new BoolSetting("Item color", false));
    private final NumberSetting rpw = this.add(new NumberSetting("Fill", 0.4, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rpx = this.add(new NumberSetting("Glow", 0.6, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rpy = this.add(new NumberSetting("Edge", 0.7, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rpz = this.add(new NumberSetting("Speed", 1.0, 0.2, 3.0, 0.1).unit("x"));
    private float rqa;
    private long rqb;
    private static /* synthetic */ String rqc;
    private static /* synthetic */ String rqd;

    public EnchantGlow() {
        super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 'H', 'a', 'n', 'd', 's'}), "A soft glow around your hands", ModuleCategory.RENDER);
        HandFx.register(this);
        this.rpu.visibleWhen(() -> !this.rpv.get());
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
    public float time() {
        long l = System.nanoTime();
        if (this.rqb != 0L) {
            this.rqa += Math.min(0.1f, (float)(l - this.rqb) / 1.0E9f) * (float)this.rpz.get();
        }
        this.rqb = l;
        return this.rqa % 3600.0f;
    }

    @Override
    public float fill() {
        return (float)this.rpw.get();
    }

    @Override
    public float glow() {
        return (float)this.rpx.get();
    }

    @Override
    public float rim() {
        return (float)this.rpy.get();
    }

    @Override
    public int[] colors(class_746 class_7462) {
        int n;
        if (this.rpv.get() && (n = EnchantGlow.rqe(class_7462.method_6047().method_7960() ? class_7462.method_6079() : class_7462.method_6047())) != 0) {
            return new int[]{n, ColorUtil.lerp(n, -1, 0.45f)};
        }
        return new int[]{this.rpu.color() | 0xFF000000, this.rpu.color2() | 0xFF000000};
    }

    private static int rqe(class_1799 class_17992) {
        if (class_17992.method_7960()) {
            return 0;
        }
        String string = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
        if (string.contains("netherite")) {
            return -7573584;
        }
        if (string.contains("diamond")) {
            return -11149328;
        }
        if (string.contains("gold")) {
            return -11443;
        }
        if (string.contains("iron")) {
            return -2564890;
        }
        if (string.contains("emerald")) {
            return -12723068;
        }
        if (string.contains("mace") || string.contains("wind")) {
            return -4601601;
        }
        if (string.contains("trident")) {
            return -10559288;
        }
        if (string.contains("totem")) {
            return -8090;
        }
        return 0;
    }

    private static /* synthetic */ int cas(int n, int n2) {
        return n * n2 | 0xC6F65A43;
    }

    private static /* synthetic */ int cat(int n, int n2) {
        return EnchantGlow.cas(n, n2) ^ 0x2D7D1DFD;
    }

    private static /* synthetic */ int cau(int n, int n2) {
        return n ^ n2 | 0xADD2BB5F;
    }
}

