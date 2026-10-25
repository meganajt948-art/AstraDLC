/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.Style
 *  net.minecraft.text.StyleSpriteSource
 *  net.minecraft.text.Text
 *  net.minecraft.text.TextColor
 *  net.minecraft.util.Formatting
 */
package a;

import a.svi;
import a.swb;
import a.uut;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

final class svp {
    private static final int svq = -1;
    private static final float svr = 7.0f;
    private static /* synthetic */ int svs;
    private static /* synthetic */ String svt;

    private svp() {
    }

    static List<svi> of(Text text, swb swb2) {
        ArrayList<svi> arrayList = new ArrayList<svi>();
        text.visit((style, string) -> {
            svp.svu(arrayList, style, string, swb2);
            return Optional.empty();
        }, Style.EMPTY);
        return arrayList;
    }

    private static void svu(List<svi> list, Style style, String string, swb swb2) {
        int n = style.getColor() != null ? 0xFF000000 | style.getColor().getRgb() : -1;
        boolean bl = style.getFont() != null && !StyleSpriteSource.DEFAULT.equals((Object)style.getFont());
        int n2 = n;
        boolean bl2 = style.isBold();
        boolean bl3 = style.isObfuscated();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int n3 = 0;
        while (n3 < string.length()) {
            boolean bl4;
            int n4 = string.codePointAt(n3);
            if (n4 == 167 && (n3 += Character.charCount(n4)) < string.length()) {
                Formatting formatting;
                svp.svv(list, stringBuilder, stringBuilder2, style, n2, bl2);
                if ((formatting = Formatting.byCode((char)string.charAt(n3++))) == null) continue;
                if (formatting == Formatting.RESET) {
                    n2 = n;
                    bl2 = style.isBold();
                    bl3 = style.isObfuscated();
                    continue;
                }
                if (formatting.isColor() && formatting.getColorValue() != null) {
                    n2 = 0xFF000000 | formatting.getColorValue();
                    bl2 = false;
                    bl3 = false;
                    continue;
                }
                if (formatting == Formatting.BOLD) {
                    bl2 = true;
                    continue;
                }
                if (formatting != Formatting.OBFUSCATED) continue;
                bl3 = true;
                continue;
            }
            boolean bl5 = bl4 = bl || bl3 || svp.svw(n4) || !swb2.font().canDisplay(n4);
            if (bl4) {
                if (!stringBuilder.isEmpty()) {
                    svp.svv(list, stringBuilder, null, style, n2, bl2);
                }
                stringBuilder2.appendCodePoint(n4);
                continue;
            }
            if (!stringBuilder2.isEmpty()) {
                svp.svv(list, null, stringBuilder2, style, n2, bl2);
            }
            stringBuilder.appendCodePoint(n4);
        }
        svp.svv(list, stringBuilder, stringBuilder2, style, n2, bl2);
    }

    private static void svv(List<svi> list, StringBuilder stringBuilder, StringBuilder stringBuilder2, Style style, int n, boolean bl) {
        if (stringBuilder != null && !stringBuilder.isEmpty()) {
            list.add(new svi(stringBuilder.toString(), n, bl, null));
            stringBuilder.setLength(0);
        }
        if (stringBuilder2 != null && !stringBuilder2.isEmpty()) {
            Style style2 = style.withColor(TextColor.fromRgb((int)(n & 0xFFFFFF))).withBold(Boolean.valueOf(bl));
            list.add(new svi(stringBuilder2.toString(), n, bl, (Text)Text.literal((String)stringBuilder2.toString()).setStyle(style2)));
            stringBuilder2.setLength(0);
        }
    }

    private static boolean svw(int n) {
        return Character.getType(n) == 18;
    }

    private static float svx(swb swb2) {
        return swb2.capHeight() * 1.2f / 7.0f;
    }

    static float width(List<svi> list, swb swb2, swb swb3) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        float f = 0.0f;
        for (svi svi2 : list) {
            f += svi2.svm != null ? (float)textRenderer.getWidth((StringVisitable)svi2.svm) * svp.svx(swb2) : (svi2.svl ? swb3 : swb2).width(svi2.svj);
        }
        return f;
    }

    static float draw(DrawContext drawContext, List<svi> list, float f, float f2, swb swb2, swb swb3, int n) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        float f3 = f2 + swb2.capHeight() * 0.5f;
        for (svi svi2 : list) {
            if (svi2.svm != null) {
                float f4 = svp.svx(swb2);
                drawContext.getMatrices().pushMatrix();
                drawContext.getMatrices().translate(f, f3 - 7.0f * f4);
                drawContext.getMatrices().scale(f4, f4);
                drawContext.drawText(textRenderer, svi2.svm, 0, 0, uut.fade(-1), false);
                drawContext.getMatrices().popMatrix();
                f += (float)textRenderer.getWidth((StringVisitable)svi2.svm) * f4;
                continue;
            }
            swb swb4 = svi2.svl ? swb3 : swb2;
            float f5 = swb4.centerTop(f2);
            if (n >>> 24 != 0) {
                swb4.draw(drawContext, svi2.svj, f + 0.55f, f5 + 0.55f, n);
            }
            f = swb4.draw(drawContext, svi2.svj, f, f5, svi2.svk);
        }
        return f;
    }

    private static /* synthetic */ int chd(int n, int n2) {
        return n + n2 ^ 0x31D9716E;
    }

    private static /* synthetic */ int che(int n, int n2) {
        return svp.chd(n, n2) + n;
    }

    private static /* synthetic */ int chf(int n, int n2) {
        return svp.che(n, n2) ^ 0xE88A898E;
    }
}

