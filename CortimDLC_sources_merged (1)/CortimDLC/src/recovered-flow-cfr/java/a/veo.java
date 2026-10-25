/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vdn;
import a.vek;
import a.vfk;
import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class veo {
    private static final Map<vek, Font> vep = new EnumMap<vek, Font>(vek.class);
    private static final Map<vek, Boolean> veq = new EnumMap<vek, Boolean>(vek.class);
    private static final Map<Long, vdn> ver = new HashMap<Long, vdn>();
    private static /* synthetic */ int ves;
    private static /* synthetic */ String vet;

    private veo() {
    }

    public static vdn get(vek vek2, float f) {
        long l2 = (long)vek2.ordinal() << 32 | (long)Float.floatToIntBits(f) & 0xFFFFFFFFL;
        return ver.computeIfAbsent(l2, l -> new vdn(vek2.name().toLowerCase() + " " + f, () -> veo.veu(vek2), f, vfk.TEXT_CHARSET, false));
    }

    public static List<vdn> all() {
        return new ArrayList<vdn>(ver.values());
    }

    public static vdn regular(float f) {
        return veo.get(vek.REGULAR, f);
    }

    public static vdn medium(float f) {
        return veo.get(vek.MEDIUM, f);
    }

    public static vdn semibold(float f) {
        return veo.get(vek.SEMIBOLD, f);
    }

    public static vdn bold(float f) {
        return veo.get(vek.BOLD, f);
    }

    private static synchronized Font veu(vek vek2) {
        Font font = vep.get((Object)vek2);
        if (font != null || veq.containsKey((Object)vek2)) {
            return font;
        }
        try (InputStream inputStream = veo.class.getResourceAsStream(vek2.vel);){
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
        return veo.ddw(n, n2) ^ 0x84646FC2;
    }

    private static /* synthetic */ int ddy(int n, int n2) {
        return veo.ddw(n, n2) ^ 0xEAE4CC58;
    }
}

