/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.FontFace;
import a.vek;
import a.FontBuilder;
import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Fonts {
    private static final Map<vek, Font> vep = new EnumMap<vek, Font>(vek.class);
    private static final Map<vek, Boolean> veq = new EnumMap<vek, Boolean>(vek.class);
    private static final Map<Long, FontFace> ver = new HashMap<Long, FontFace>();
    private static /* synthetic */ int ves;
    private static /* synthetic */ String vet;

    private Fonts() {
    }

    public static FontFace get(vek vek2, float f) {
        long l2 = (long)vek2.ordinal() << 32 | (long)Float.floatToIntBits(f) & 0xFFFFFFFFL;
        return ver.computeIfAbsent(l2, l -> new FontFace(vek2.name().toLowerCase() + " " + f, () -> Fonts.veu(vek2), f, FontBuilder.TEXT_CHARSET, false));
    }

    public static List<FontFace> all() {
        return new ArrayList<FontFace>(ver.values());
    }

    public static FontFace regular(float f) {
        return Fonts.get(vek.REGULAR, f);
    }

    public static FontFace medium(float f) {
        return Fonts.get(vek.MEDIUM, f);
    }

    public static FontFace semibold(float f) {
        return Fonts.get(vek.SEMIBOLD, f);
    }

    public static FontFace bold(float f) {
        return Fonts.get(vek.BOLD, f);
    }

    private static synchronized Font veu(vek vek2) {
        Font font = vep.get((Object)vek2);
        if (font != null || veq.containsKey((Object)vek2)) {
            return font;
        }
        try (InputStream inputStream = Fonts.class.getResourceAsStream(vek2.vel);){
            if (inputStream == null) {
                throw new IllegalStateException("missing " + vek2.vel);
            }
            font = Font.createFont(0, inputStream);
        }
        catch (Throwable throwable) {
            System.out.println("can't load font " + (Object)((Object)vek2) + ": " + throwable);
            font = null;
        }
        if (font == null) {
            veq.put(vek2, Boolean.TRUE);
        } else {
            vep.put(vek2, font);
        }
        return font;
    }

    private static /* synthetic */ int ddw(int n, int n2) {
        return (n ^ n2) + 1932464164;
    }

    private static /* synthetic */ int ddx(int n, int n2) {
        return Fonts.ddw(n, n2) ^ 0x84646FC2;
    }

    private static /* synthetic */ int ddy(int n, int n2) {
        return Fonts.ddw(n, n2) ^ 0xEAE4CC58;
    }
}

