/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_10055
 *  net.minecraft.class_11658
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 */
package a;

import a.Friends;
import a.ModuleCategory;
import a.Module;
import a.FxPipeline;
import a.ColorSetting;
import a.NumberSetting;
import flow.cosmetic.Cosmetics;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_11658;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;

public class TransparentFriends
extends Module {
    private static TransparentFriends rwp;
    private final NumberSetting rwq = this.add(new NumberSetting("Transparency", 0.6, 0.0, 1.0, 0.05).percent());
    private final ColorSetting rwr = this.add(new ColorSetting("Color", "Mint"));
    private final NumberSetting rws = this.add(new NumberSetting("Outline", 0.9, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rwt = this.add(new NumberSetting("Width", 1.5, 0.5, 4.0, 0.1));
    private final NumberSetting rwu = this.add(new NumberSetting("Fill", 0.0, 0.0, 0.6, 0.01).percent());
    private final NumberSetting rwv = this.add(new NumberSetting("Glow", 0.35, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rww = this.add(new NumberSetting("Glow size", 0.4, 0.0, 1.0, 0.05).percent());
    private final NumberSetting rwx = this.add(new NumberSetting("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));
    private static /* synthetic */ boolean rwy;
    private static /* synthetic */ long rwz;

    public TransparentFriends() {
        super(new String(new char[]{'T', 'r', 'a', 'n', 's', 'p', 'a', 'r', 'e', 'n', 't', 'F', 'r', 'i', 'e', 'n', 'd', 's'}), "Friends turn see-through", ModuleCategory.RENDER);
        rwp = this;
        this.rwt.visibleWhen(() -> this.rws.get() > 0.0);
        this.rww.visibleWhen(() -> this.rwv.get() > 0.0);
    }

    public static void afterExtraction(class_11658 class_116582) {
        TransparentFriends rwo2 = rwp;
        class_310 class_3102 = class_310.method_1551();
        if (rwo2 == null || !rwo2.isEnabled() || class_3102.field_1687 == null) {
            return;
        }
        FxPipeline.style(1).set((float)rwo2.rwu.get(), (float)rwo2.rws.get(), (float)rwo2.rwt.get(), (float)rwo2.rwv.get(), (float)rwo2.rww.get(), (float)rwo2.rwx.get());
        int n = rwo2.rwr.color() | 0xFF000000;
        int n2 = rwo2.rwr.color2() | 0xFF000000;
        boolean bl = FxPipeline.canFade();
        for (class_10017 class_100172 : class_116582.field_61735) {
            class_1657 class_16572;
            if (!(class_100172 instanceof class_10055)) continue;
            class_10055 class_100552 = (class_10055)class_100172;
            class_1297 class_12972 = class_3102.field_1687.method_8469(class_100552.field_53528);
            if (!(class_12972 instanceof class_1657) || (class_16572 = (class_1657)class_12972) == class_3102.field_1724 || !Friends.isFriend((class_1297)class_16572)) continue;
            boolean bl2 = Cosmetics.hidesBody((class_10017)class_100552);
            if (bl) {
                if (!bl2) {
                    class_100552.field_53333 = false;
                    class_100552.field_53461 = false;
                }
                FxPipeline.fade(class_100172, 1.0f - (float)rwo2.rwq.get());
            } else if (rwo2.rwq.get() > 0.0 && !bl2) {
                class_100552.field_53333 = true;
                class_100552.field_53461 = false;
            }
            FxPipeline.paint(class_100172, 1, n, n2);
        }
    }

    private static /* synthetic */ int ccc(int n, int n2) {
        return n - n2 + -797118068;
    }

    private static /* synthetic */ int ccd(int n, int n2) {
        return n ^ n2 ^ 0xA904A24E;
    }

    private static /* synthetic */ int cce(int n, int n2) {
        return n - n2 | 0xDDCAD6B0;
    }
}

