/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.Theme;
import a.UiKit;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import net.minecraft.class_310;
import net.minecraft.class_332;

final class TextField {
    static final IntPredicate ANY = n -> n >= 32 && n != 127;
    static final IntPredicate NUMBER = n -> n >= 48 && n <= 57 || n == 45 || n == 46;
    final String placeholder;
    final Icon icon;
    private final int iai;
    private final IntPredicate iaj;
    String text = "";
    TextField next;
    Runnable onSubmit;
    Consumer<String> onChange;
    private float iak;
    private int ial;
    private boolean iam;
    private final Spring ian = new Spring(16.0f);
    private final Spring iao = new Spring(16.0f);
    private final Spring iap = new Spring(28.0f);
    private final Spring iaq = new Spring(20.0f);
    private long iar;
    float x;
    float y;
    float w;
    float h = 16.0f;
    String prefix;
    private static /* synthetic */ long ias;
    private static /* synthetic */ int iat;

    TextField(String string, Icon vhz2, int n, IntPredicate intPredicate) {
        this.placeholder = string;
        this.icon = vhz2;
        this.iai = n;
        this.iaj = intPredicate;
    }

    void setText(String string) {
        this.text = string == null ? "" : string;
        this.ial = this.text.length();
        this.iam = false;
        if (this.onChange != null) {
            this.onChange.accept(this.text);
        }
    }

    void error() {
        this.iak = 1.0f;
    }

    boolean contains(float f, float f2) {
        return UiKit.inside(f, f2, this.x, this.y, this.w, this.h);
    }

    private float iau() {
        if (this.icon != null) {
            return this.x + 18.0f;
        }
        return this.prefix != null ? this.x + 7.0f + UiKit.SMALL.width(this.prefix) + 5.0f : this.x + 7.0f;
    }

    private float iav() {
        return this.w - (this.iau() - this.x) - 6.0f;
    }

    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        boolean bl = hlc2.focusedField() == this;
        float f4 = this.ian.step(bl, f3);
        float f5 = this.iao.step(hlc2.canHover() && this.contains(f, f2), f3);
        this.iak = Math.max(0.0f, this.iak - f3 * 1.6f);
        float f6 = Theme.r(5.0f);
        DrawUtil.round(class_3322, this.x, this.y, this.w, this.h, f6, ColorUtil.lerp(Theme.field, Theme.fieldHover, Math.max(f5, f4)));
        int n = ColorUtil.lerp(ColorUtil.lerp(Theme.stroke, Theme.textMuted, f5 * 0.4f), Theme.accent(170), f4);
        DrawUtil.outline(class_3322, this.x, this.y, this.w, this.h, f6, 1.0f, ColorUtil.lerp(n, -1750963, this.iak));
        GlassDraw.inset(class_3322, this.x, this.y, this.w, this.h, f6, Theme.lightness());
        float f7 = this.y + this.h * 0.5f;
        if (this.icon != null) {
            IconRenderer.draw(class_3322, this.icon, this.x + 9.5f, f7, 7.0f, ColorUtil.lerp(Theme.textMuted, Theme.accent(), f4));
        } else if (this.prefix != null) {
            UiKit.SMALL.draw(class_3322, this.prefix, this.x + 7.0f, UiKit.SMALL.centerTop(f7), ColorUtil.lerp(Theme.textMuted, Theme.accent(), f4));
        }
        float f8 = this.iau();
        float f9 = this.iav();
        String string = this.text.substring(0, Math.min(this.ial, this.text.length()));
        float f10 = UiKit.LABEL.width(string);
        float f11 = Math.max(0.0f, Math.min(f10 - f9 + 4.0f, UiKit.LABEL.width(this.text) - f9 + 4.0f));
        float f12 = this.iaq.step(Math.max(0.0f, f11), f3);
        DrawUtil.pushScissor(class_3322, f8 - 1.0f, this.y, f9 + 2.0f, this.h);
        if (this.text.isEmpty()) {
            UiKit.LABEL.draw(class_3322, Lang.t(this.placeholder), f8, UiKit.LABEL.centerTop(f7), ColorUtil.mulAlpha(Theme.textMuted, 1.0f - 0.4f * f4));
        } else {
            if (this.iam && bl) {
                DrawUtil.round(class_3322, f8 - f12 - 1.0f, f7 - 5.0f, UiKit.LABEL.width(this.text) + 2.0f, 10.0f, 2.0f, Theme.accent(70));
            }
            UiKit.LABEL.draw(class_3322, this.text, f8 - f12, UiKit.LABEL.centerTop(f7), Theme.text);
        }
        if (bl) {
            boolean bl2;
            float f13 = this.iap.step(f8 - f12 + f10, f3);
            boolean bl3 = bl2 = System.currentTimeMillis() - this.iar < 500L || System.currentTimeMillis() / 530L % 2L == 0L;
            if (bl2 && !this.iam) {
                DrawUtil.round(class_3322, f13, f7 - 4.5f, 1.0f, 9.0f, 0.5f, Theme.accent());
            }
        } else {
            this.iap.set(f8 - f12 + f10);
        }
        DrawUtil.popScissor(class_3322);
    }

    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (!this.contains(f, f2)) {
            return false;
        }
        hlc2.focus(this);
        if (n == 1) {
            this.setText("");
            return true;
        }
        this.iam = false;
        float f3 = f - this.iau() + this.iaq.get();
        int n2 = this.text.length();
        for (int i = 0; i <= this.text.length(); ++i) {
            if (!(UiKit.LABEL.width(this.text.substring(0, i)) >= f3 - 2.0f)) continue;
            n2 = i;
            break;
        }
        this.ial = n2;
        return true;
    }

    boolean keyPressed(ClickGuiScreen hlc2, int n, int n2) {
        boolean bl = (n2 & 2) != 0;
        this.iar = System.currentTimeMillis();
        switch (n) {
            case 256: {
                hlc2.focus(null);
                break;
            }
            case 257: 
            case 335: {
                if (this.onSubmit != null) {
                    this.onSubmit.run();
                    break;
                }
                hlc2.focus(this.next);
                break;
            }
            case 258: {
                hlc2.focus(this.next);
                break;
            }
            case 259: {
                if (this.iam || bl) {
                    this.iax("", 0);
                    break;
                }
                if (this.ial <= 0) break;
                this.iax(this.text.substring(0, this.ial - 1) + this.text.substring(this.ial), this.ial - 1);
                break;
            }
            case 261: {
                if (this.iam) {
                    this.iax("", 0);
                    break;
                }
                if (this.ial >= this.text.length()) break;
                this.iax(this.text.substring(0, this.ial) + this.text.substring(this.ial + 1), this.ial);
                break;
            }
            case 263: {
                this.ial = this.iam ? 0 : Math.max(0, this.ial - 1);
                this.iam = false;
                break;
            }
            case 262: {
                this.ial = this.iam ? this.text.length() : Math.min(this.text.length(), this.ial + 1);
                this.iam = false;
                break;
            }
            case 268: {
                this.ial = 0;
                this.iam = false;
                break;
            }
            case 269: {
                this.ial = this.text.length();
                this.iam = false;
                break;
            }
            case 65: {
                if (!bl) {
                    return false;
                }
                this.iam = !this.text.isEmpty();
                break;
            }
            case 67: {
                if (!bl) {
                    return false;
                }
                class_310.method_1551().field_1774.method_1455(this.text);
                break;
            }
            case 86: {
                if (!bl) {
                    return false;
                }
                String string = class_310.method_1551().field_1774.method_1460();
                if (string == null) break;
                this.iaw(string.replace("\n", " ").replace("\r", ""));
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    void charTyped(String string) {
        this.iar = System.currentTimeMillis();
        this.iaw(string);
    }

    private void iaw(String string) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        string.codePoints().filter(this.iaj).forEach(stringBuilder::appendCodePoint);
        if (stringBuilder.isEmpty()) {
            return;
        }
        String string2 = this.iam ? "" : this.text;
        String string3 = string2.substring(0, n = this.iam ? 0 : this.ial) + stringBuilder + string2.substring(n);
        if (string3.length() > this.iai) {
            return;
        }
        this.iax(string3, n + stringBuilder.length());
    }

    private void iax(String string, int n) {
        this.text = string;
        this.ial = Math.max(0, Math.min(string.length(), n));
        this.iam = false;
        if (this.onChange != null) {
            this.onChange.accept(this.text);
        }
    }

    void focusGained() {
        this.ial = this.text.length();
        this.iam = false;
        this.iar = System.currentTimeMillis();
    }

    private static /* synthetic */ int aeu(int n, int n2) {
        return n + n2 ^ 0x9E79D1C4;
    }

    private static /* synthetic */ int aev(int n, int n2) {
        return n + n2 ^ 0xEDAB2AA5;
    }

    private static /* synthetic */ int aew(int n, int n2) {
        return TextField.aev(n, n2) + n;
    }
}

