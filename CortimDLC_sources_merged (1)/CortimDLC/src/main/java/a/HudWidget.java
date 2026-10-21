/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.Spring;
import a.BoolSetting;
import a.Setting;
import flow.dev.StringDecryptor;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_332;

public abstract class HudWidget {
    public final String id;
    public final String name;
    public final BoolSetting enabled;
    private final int jct;
    private final int jcu;
    private final float jcv;
    private final float jcw;
    int ax;
    int ay;
    float ox;
    float oy;
    float size = 1.0f;
    float scale = 1.0f;
    static final float MIN_SIZE = 0.5f;
    static final float MAX_SIZE = 2.0f;
    final Spring shown = new Spring(9.0f);
    final Spring push = new Spring(10.0f);
    float x;
    float y;
    float w;
    float h;
    private static /* synthetic */ long jcx;
    private static /* synthetic */ int jcy;

    HudWidget(String string, String string2, boolean bl, int n, int n2, float f, float f2) {
        this.id = string;
        this.name = string2;
        this.enabled = new BoolSetting(string2, bl);
        this.jct = n;
        this.jcu = n2;
        this.jcv = f;
        this.jcw = f2;
        this.resetPosition();
    }

    public List<Setting> settings() {
        return List.of();
    }

    abstract void update(float var1, boolean var2);

    abstract boolean hasContent(boolean var1);

    abstract float width();

    abstract float height();

    abstract void draw(class_332 var1, float var2, boolean var3);

    boolean mouseClicked(float f, float f2, int n) {
        return false;
    }

    boolean canGhost() {
        return false;
    }

    boolean isSample() {
        return false;
    }

    void place(float f, float f2, float f3, float f4, float f5) {
        float f6 = switch (this.ax) {
            case 0 -> this.ox;
            case 1 -> (f - f3) * 0.5f + this.ox;
            default -> f - f3 - this.ox;
        };
        float f7 = switch (this.ay) {
            case 0 -> this.oy;
            case 1 -> (f2 - f4) * 0.5f + this.oy;
            default -> f2 - f4 - this.oy;
        };
        f6 = Math.max(0.0f, Math.min(f - f3, f6));
        f7 = Math.max(0.0f, Math.min(f2 - f4, f7));
        this.x = (float)Math.round(f6 * f5) / f5;
        this.y = (float)Math.round(f7 * f5) / f5;
        this.w = f3;
        this.h = f4;
    }

    void moveTo(float f, float f2, float f3, float f4) {
        float f5 = f + this.w * 0.5f;
        float f6 = f2 + this.h * 0.5f;
        int n = f5 < f3 / 3.0f ? 0 : (this.ax = f5 > f3 * 2.0f / 3.0f ? 2 : 1);
        this.ay = f6 < f4 / 3.0f ? 0 : (f6 > f4 * 2.0f / 3.0f ? 2 : 1);
        this.ox = switch (this.ax) {
            case 0 -> f;
            case 1 -> f - (f3 - this.w) * 0.5f;
            default -> f3 - this.w - f;
        };
        this.oy = switch (this.ay) {
            case 0 -> f2;
            case 1 -> f2 - (f4 - this.h) * 0.5f;
            default -> f4 - this.h - f2;
        };
        this.x = f;
        this.y = f2;
    }

    void resetPosition() {
        this.ax = this.jct;
        this.ay = this.jcu;
        this.ox = this.jcv;
        this.oy = this.jcw;
        this.size = 1.0f;
    }

    float pivotX() {
        return this.ax == 0 ? 0.0f : (this.ax == 1 ? this.w * 0.5f : this.w);
    }

    float pivotY() {
        return this.ay == 0 ? 0.0f : (this.ay == 1 ? this.h * 0.5f : this.h);
    }

    float slideSide() {
        return this.ax == 2 ? 1.0f : -1.0f;
    }

    String savePosition() {
        return String.format(Locale.ROOT, "%d,%d,%.2f,%.2f,%.3f", this.ax, this.ay, Float.valueOf(this.ox), Float.valueOf(this.oy), Float.valueOf(this.size));
    }

    void loadPosition(String string) {
        try {
            String[] stringArray = string.split(",");
            int n = Integer.parseInt(stringArray[0].trim());
            int n2 = Integer.parseInt(stringArray[1].trim());
            if (n < 0 || n > 2 || n2 < 0 || n2 > 2) {
                return;
            }
            this.ax = n;
            this.ay = n2;
            this.ox = Float.parseFloat(stringArray[2].trim());
            this.oy = Float.parseFloat(stringArray[3].trim());
            if (stringArray.length > 4) {
                this.size = Math.max(0.5f, Math.min(2.0f, Float.parseFloat(stringArray[4].trim())));
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    private static /* synthetic */ int alq(int n, int n2) {
        return n + n2 + 1821713736;
    }

    private static /* synthetic */ int alr(int n, int n2) {
        return HudWidget.alq(n, n2) ^ 0xE9010C8D;
    }

    private static /* synthetic */ int als(int n, int n2) {
        return n - n2 + 1833352654;
    }
}

