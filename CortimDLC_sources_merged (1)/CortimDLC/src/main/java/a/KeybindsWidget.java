/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.Theme;
import a.UiKit;
import a.Hud;
import a.jdz;
import a.TimedWidget;
import a.Module;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Icon;
import a.ModeSetting;
import a.Setting;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_332;

public final class KeybindsWidget
extends TimedWidget<jdz> {
    public static final ModeSetting SHOW = new ModeSetting("Show", "Active", "Active");
    private static final float jeg = 13.0f;
    private static final float jeh = 9.5f;
    private final Map<String, Spring> jei = new HashMap<String, Spring>();
    private static /* synthetic */ long jej;
    private static /* synthetic */ String jek;

    KeybindsWidget() {
        super("keybinds", "Keybinds", Icon.KEYBOARD, true, 0, 1, 6.0f, -30.0f);
    }

    @Override
    public List<Setting> settings() {
        return List.of(SHOW);
    }

    @Override
    List<jdz> items(boolean bl) {
        ArrayList<jdz> arrayList = new ArrayList<jdz>();
        for (Module kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            if (kfe2.getKey() == -1 || !kfe2.isEnabled()) continue;
            arrayList.add(new jdz(kfe2.getDisplayName(), kfe2.getKey(), kfe2.isEnabled()));
        }
        return arrayList;
    }

    @Override
    String key(jdz jdz2) {
        return jdz2.jea;
    }

    @Override
    float rowHeight() {
        return 13.0f;
    }

    private static float jem(String string) {
        return Math.max(14.0f, Hud.SMALL.width(string) + 8.0f);
    }

    @Override
    float rowWidth(jdz jdz2) {
        return 6.0f + Hud.TEXT.width(jdz2.jea) + 12.0f + KeybindsWidget.jem(UiKit.keyName(jdz2.jeb));
    }

    @Override
    void drawRow(class_332 class_3322, jdz jdz2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.jei.computeIfAbsent(jdz2.jea, string -> new Spring(12.0f, jdz2.jec ? 1.0f : 0.0f)).step(jdz2.jec, f6);
        float f8 = f2 + f4 * 0.5f;
        if (f7 > 0.01f) {
            DrawUtil.shadow(class_3322, f - 0.2f, f8 - 2.0f, 4.0f, 4.0f, 2.0f, 3.0f, Theme.accent((int)(90.0f * f7)));
            DrawUtil.circle(class_3322, f + 1.8f, f8, 1.7f * f7, Theme.accent());
        }
        Hud.TEXT.draw(class_3322, Hud.TEXT.ellipsize(jdz2.jea, f3 - 30.0f), f + 6.0f * f7, Hud.TEXT.centerTop(f8), ColorUtil.lerp(Theme.textDim, Theme.text, f7));
        String string2 = UiKit.keyName(jdz2.jeb);
        float f9 = KeybindsWidget.jem(string2);
        float f10 = f + f3 - f9;
        float f11 = Theme.r(3.0f);
        DrawUtil.round(class_3322, f10, f8 - 4.75f, f9, 9.5f, f11, ColorUtil.lerp(Theme.field, Theme.accent(60), f7 * 0.5f));
        DrawUtil.outline(class_3322, f10, f8 - 4.75f, f9, 9.5f, f11, 1.0f, ColorUtil.lerp(Theme.stroke, Theme.accent(150), f7));
        Hud.SMALL.drawCentered(class_3322, string2, f10 + f9 * 0.5f, Hud.SMALL.centerTop(f8), ColorUtil.lerp(Theme.textDim, Theme.text, f7));
    }

    private static /* synthetic */ int ame(int n, int n2) {
        return n * n2 ^ 0xEB040A2E;
    }

    private static /* synthetic */ int amf(int n, int n2) {
        return n - n2 | 0x2E4CD5AB;
    }

    private static /* synthetic */ int amg(int n, int n2) {
        return n * n2 ^ 0x56FB7105;
    }
}

