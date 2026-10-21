/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import flow.dev.StringDecryptor;
import java.util.List;

public final class TitleLayoutSetting {
    public static final BoolSetting TITLE = new BoolSetting("title", false);
    public static final ModeSetting POSITION = new ModeSetting("position", "Left", "Left", "Center", "Right");
    public static final ModeSetting BUTTONS = new ModeSetting("buttons", "Glass", "Glass", "Dark", "Light", "Outline");
    public static final NumberSetting BLUR = new NumberSetting("blur", 0.0, 0.0, 1.0, 0.05).percent();
    public static final NumberSetting ROUND = new NumberSetting("round", 0.55, 0.0, 1.0, 0.05).percent();
    public static final NumberSetting DIM = new NumberSetting("dim", 0.0, 0.0, 0.6, 0.05).percent();
    public static final BoolSetting PARTICLES = new BoolSetting("particles", true);
    public static final BoolSetting PARALLAX = new BoolSetting("parallax", true);
    public static final List<Setting> ALL = List.of(TITLE, POSITION, BUTTONS, BLUR, ROUND, DIM, PARTICLES, PARALLAX);
    private static /* synthetic */ String kbn;
    private static /* synthetic */ long kbo;

    private TitleLayoutSetting() {
    }

    public static void reset() {
        TITLE.reset();
        POSITION.reset();
        BUTTONS.reset();
        BLUR.reset();
        ROUND.reset();
        DIM.reset();
        PARTICLES.reset();
        PARALLAX.reset();
    }

    private static /* synthetic */ int ark(int n, int n2) {
        return n + n2 + 607260005;
    }
}

