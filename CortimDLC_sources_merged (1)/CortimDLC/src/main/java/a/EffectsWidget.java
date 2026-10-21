/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10799
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_310
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_4081
 *  net.minecraft.class_6880
 */
package a;

import a.Theme;
import a.Hud;
import a.TimedWidget;
import a.jht;
import a.ColorUtil;
import a.DrawUtil;
import a.Icon;
import a.BoolSetting;
import a.ModeSetting;
import a.Setting;
import a.FormatUtil;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.class_10799;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_4081;
import net.minecraft.class_6880;

public final class EffectsWidget
extends TimedWidget<jht> {
    public static final BoolSetting HIDE_VANILLA = new BoolSetting("Hide vanilla icons", true);
    public static final BoolSetting BARS = new BoolSetting("Time bars", true);
    public static final ModeSetting COLORS = new ModeSetting("Bar colour", "Accent", "Accent", "Effect");
    private static final float jif = 15.0f;
    private static final float jig = 10.0f;
    private final Map<String, Integer> jih = new HashMap<String, Integer>();
    private static /* synthetic */ boolean jii;
    private static /* synthetic */ long jij;

    EffectsWidget() {
        super("potions", "Potions", Icon.POTION, true, 2, 0, 6.0f, 6.0f);
    }

    @Override
    public List<Setting> settings() {
        return List.of(HIDE_VANILLA, BARS, COLORS);
    }

    public static boolean hidesVanilla() {
        return Hud.ENABLED.get() && Hud.POTIONS.enabled.get() && HIDE_VANILLA.get();
    }

    @Override
    List<jht> items(boolean bl) {
        class_310 class_3102 = class_310.method_1551();
        ArrayList<jht> arrayList = new ArrayList<jht>();
        HashSet<String> hashSet = new HashSet<String>();
        if (class_3102.field_1724 != null) {
            for (class_1293 class_12932 : class_3102.field_1724.method_6026()) {
                if (!class_12932.method_5592()) continue;
                String string = class_12932.method_5579().method_55840();
                hashSet.add(string);
                int n = class_12932.method_5584();
                int n2 = Math.max(n, this.jih.getOrDefault(string, 0));
                this.jih.put(string, n2);
                arrayList.add(EffectsWidget.jik(string, (class_6880<class_1291>)class_12932.method_5579(), class_12932.method_5578(), n, class_12932.method_48559(), class_12932.method_48559() ? 1.0f : (float)n / (float)Math.max(1, n2)));
            }
        }
        this.jih.keySet().retainAll(hashSet);
        if (arrayList.isEmpty() && bl) {
            arrayList.add(EffectsWidget.jik("preview:speed", (class_6880<class_1291>)class_1294.field_5904, 1, 1640, false, 0.72f));
            arrayList.add(EffectsWidget.jik("preview:strength", (class_6880<class_1291>)class_1294.field_5910, 0, 780, false, 0.35f));
            arrayList.add(EffectsWidget.jik("preview:fire", (class_6880<class_1291>)class_1294.field_5918, 0, 150, false, 0.08f));
        }
        arrayList.sort(Comparator.comparing(jht2 -> !jht2.jhy).thenComparing(jht2 -> -jht2.jhx));
        return arrayList;
    }

    private static jht jik(String string, class_6880<class_1291> class_68802, int n, int n2, boolean bl, float f) {
        class_1291 class_12912 = (class_1291)class_68802.comp_349();
        String string2 = class_12912.method_5560().getString();
        if (n > 0) {
            string2 = string2 + " " + EffectsWidget.jil(n + 1);
        }
        return new jht(string, class_68802, string2, n2, bl, f, 0xFF000000 | class_12912.method_5556(), class_12912.method_18792() == class_4081.field_18272);
    }

    private static String jil(int n) {
        String[] stringArray = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return n >= 1 && n <= stringArray.length ? stringArray[n - 1] : String.valueOf(n);
    }

    static String time(int n, boolean bl) {
        if (bl) {
            return "∞";
        }
        return FormatUtil.clock(Math.max(0, n / 20));
    }

    @Override
    String key(jht jht2) {
        return jht2.jhu;
    }

    @Override
    float rowHeight() {
        return 15.0f;
    }

    @Override
    float rowWidth(jht jht2) {
        return 14.0f + Hud.TEXT.width(jht2.jhw) + 12.0f + Hud.VALUE.width(EffectsWidget.time(jht2.jhx, jht2.jhy));
    }

    @Override
    void drawRow(class_332 class_3322, jht jht2, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl = BARS.get();
        float f7 = f2 + (bl ? 6.0f : f4 * 0.5f);
        int n = ColorUtil.withAlpha(0xFFFFFF, Math.round(255.0f * DrawUtil.alpha()));
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f7 - 5.0f);
        class_3322.method_51448().scale(0.5555556f, 0.5555556f);
        class_3322.method_52707(class_10799.field_56883, class_329.method_71644(jht2.jhv), 0, 0, 18, 18, n);
        class_3322.method_51448().popMatrix();
        float f8 = f + 10.0f + 4.0f;
        String string = EffectsWidget.time(jht2.jhx, jht2.jhy);
        float f9 = Hud.VALUE.width(string);
        Hud.TEXT.draw(class_3322, Hud.TEXT.ellipsize(jht2.jhw, f3 - (f8 - f) - f9 - 8.0f), f8, Hud.TEXT.centerTop(f7), jht2.jib ? ColorUtil.lerp(Theme.text, -1096636, 0.35f) : Theme.text);
        float f10 = jht2.jhy ? -1.0f : (float)jht2.jhx / 20.0f;
        Hud.VALUE.drawRight(class_3322, string, f + f3, Hud.VALUE.centerTop(f7), EffectsWidget.expiring(Theme.textDim, f10));
        if (bl) {
            int n2;
            int n3;
            if (COLORS.is("Effect")) {
                n3 = jht2.jia;
                n2 = ColorUtil.lerp(jht2.jia, -1, 0.3f);
            } else if (jht2.jib) {
                n3 = -1096636;
                n2 = -429290;
            } else {
                n3 = Theme.accent();
                n2 = Theme.accent2();
            }
            EffectsWidget.bar(class_3322, f8, f2 + f4 - 3.6f, f3 - (f8 - f), jht2.jhy ? 1.0f : jht2.jhz, n3, n2);
        }
    }

    private static /* synthetic */ int ans(int n, int n2) {
        return n * n2 ^ 0x26637ECB;
    }

    private static /* synthetic */ int ant(int n, int n2) {
        return EffectsWidget.ans(n, n2) ^ 0x27C07B03;
    }

    private static /* synthetic */ int anu(int n, int n2) {
        return EffectsWidget.ant(n, n2) + n;
    }
}

