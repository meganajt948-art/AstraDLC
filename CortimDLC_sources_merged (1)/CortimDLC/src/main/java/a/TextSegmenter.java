/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11719
 *  net.minecraft.class_124
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_5251
 *  net.minecraft.class_5348
 */
package a;

import a.svi;
import a.swb;
import a.DrawUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.class_11719;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_5251;
import net.minecraft.class_5348;

final class TextSegmenter {
    private static final int svq = -1;
    private static final float svr = 7.0f;
    private static /* synthetic */ int svs;
    private static /* synthetic */ String svt;

    private TextSegmenter() {
    }

    static List<svi> of(class_2561 class_25612, swb swb2) {
        ArrayList<svi> arrayList = new ArrayList<svi>();
        class_25612.method_27658((class_25832, string) -> {
            TextSegmenter.svu(arrayList, class_25832, string, swb2);
            return Optional.empty();
        }, class_2583.field_24360);
        return arrayList;
    }

    private static void svu(List<svi> list, class_2583 class_25832, String string, swb swb2) {
        int n = class_25832.method_10973() != null ? 0xFF000000 | class_25832.method_10973().method_27716() : -1;
        boolean bl = class_25832.method_27708() != null && !class_11719.field_61972.equals((Object)class_25832.method_27708());
        int n2 = n;
        boolean bl2 = class_25832.method_10984();
        boolean bl3 = class_25832.method_10987();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int n3 = 0;
        while (n3 < string.length()) {
            boolean bl4;
            int n4 = string.codePointAt(n3);
            if (n4 == 167 && (n3 += Character.charCount(n4)) < string.length()) {
                class_124 class_1242;
                TextSegmenter.svv(list, stringBuilder, stringBuilder2, class_25832, n2, bl2);
                if ((class_1242 = class_124.method_544((char)string.charAt(n3++))) == null) continue;
                if (class_1242 == class_124.field_1070) {
                    n2 = n;
                    bl2 = class_25832.method_10984();
                    bl3 = class_25832.method_10987();
                    continue;
                }
                if (class_1242.method_543() && class_1242.method_532() != null) {
                    n2 = 0xFF000000 | class_1242.method_532();
                    bl2 = false;
                    bl3 = false;
                    continue;
                }
                if (class_1242 == class_124.field_1067) {
                    bl2 = true;
                    continue;
                }
                if (class_1242 != class_124.field_1051) continue;
                bl3 = true;
                continue;
            }
            boolean bl5 = bl4 = bl || bl3 || TextSegmenter.svw(n4) || !swb2.font().canDisplay(n4);
            if (bl4) {
                if (!stringBuilder.isEmpty()) {
                    TextSegmenter.svv(list, stringBuilder, null, class_25832, n2, bl2);
                }
                stringBuilder2.appendCodePoint(n4);
                continue;
            }
            if (!stringBuilder2.isEmpty()) {
                TextSegmenter.svv(list, null, stringBuilder2, class_25832, n2, bl2);
            }
            stringBuilder.appendCodePoint(n4);
        }
        TextSegmenter.svv(list, stringBuilder, stringBuilder2, class_25832, n2, bl2);
    }

    private static void svv(List<svi> list, StringBuilder stringBuilder, StringBuilder stringBuilder2, class_2583 class_25832, int n, boolean bl) {
        if (stringBuilder != null && !stringBuilder.isEmpty()) {
            list.add(new svi(stringBuilder.toString(), n, bl, null));
            stringBuilder.setLength(0);
        }
        if (stringBuilder2 != null && !stringBuilder2.isEmpty()) {
            class_2583 class_25833 = class_25832.method_27703(class_5251.method_27717((int)(n & 0xFFFFFF))).method_10982(Boolean.valueOf(bl));
            list.add(new svi(stringBuilder2.toString(), n, bl, (class_2561)class_2561.method_43470((String)stringBuilder2.toString()).method_10862(class_25833)));
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
        class_327 class_3272 = class_310.method_1551().field_1772;
        float f = 0.0f;
        for (svi svi2 : list) {
            f += svi2.svm != null ? (float)class_3272.method_27525((class_5348)svi2.svm) * TextSegmenter.svx(swb2) : (svi2.svl ? swb3 : swb2).width(svi2.svj);
        }
        return f;
    }

    static float draw(class_332 class_3322, List<svi> list, float f, float f2, swb swb2, swb swb3, int n) {
        class_327 class_3272 = class_310.method_1551().field_1772;
        float f3 = f2 + swb2.capHeight() * 0.5f;
        for (svi svi2 : list) {
            if (svi2.svm != null) {
                float f4 = TextSegmenter.svx(swb2);
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(f, f3 - 7.0f * f4);
                class_3322.method_51448().scale(f4, f4);
                class_3322.method_51439(class_3272, svi2.svm, 0, 0, DrawUtil.fade(-1), false);
                class_3322.method_51448().popMatrix();
                f += (float)class_3272.method_27525((class_5348)svi2.svm) * f4;
                continue;
            }
            swb swb4 = svi2.svl ? swb3 : swb2;
            float f5 = swb4.centerTop(f2);
            if (n >>> 24 != 0) {
                swb4.draw(class_3322, svi2.svj, f + 0.55f, f5 + 0.55f, n);
            }
            f = swb4.draw(class_3322, svi2.svj, f, f5, svi2.svk);
        }
        return f;
    }

    private static /* synthetic */ int chd(int n, int n2) {
        return n + n2 ^ 0x31D9716E;
    }

    private static /* synthetic */ int che(int n, int n2) {
        return TextSegmenter.chd(n, n2) + n;
    }

    private static /* synthetic */ int chf(int n, int n2) {
        return TextSegmenter.che(n, n2) ^ 0xE88A898E;
    }
}

