/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.iov;
import a.irr;
import a.izx;
import a.jdz;
import a.jeq;
import a.kfe;
import a.ujt;
import a.uut;
import a.vcj;
import a.vhz;
import a.vlv;
import a.vmo;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.DrawContext;

public final class jef
extends jeq<jdz> {
    public static final vlv SHOW = new vlv(a.c(983627561, "\uf77e\u8ef4\u0420\u9a49"), a.c(-1672653280, "\u5662\u2ffe\ua52d"), a.b("\u8342\ufade\u700d", 1556185856), a.d("\ucf21\ub6b2\u3c76\ua21a\u29d2\uaf70", -2020504048, -1804582538));
    private static final float jeg = 13.0f;
    private static final float jeh = 9.5f;
    private final Map<String, vcj> jei = new HashMap<String, vcj>();
    private static /* synthetic */ long jej;
    private static /* synthetic */ String jek;

    jef() {
        super(a.b("\ud3b6\uaa09\u20c6\ubeac\u3570\ub3c6\u099f\u8079", -1069296683), a.d("\u4718\u3e87\ub448\u2a22\ua1fe\u2748\u9d11\u14f7", -1710557151, 578207610), vhz.KEYBOARD, true, 0, 1, 6.0f, -30.0f);
    }

    @Override
    public List<vmo> settings() {
        return List.of(SHOW);
    }

    @Override
    List<jdz> items(boolean bl) {
        ArrayList<jdz> arrayList = new ArrayList<jdz>();
        for (kfe kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            if (kfe2.getKey() == -1 || !SHOW.is(a.b("\ue11a\u9886\u1255", 862445912)) && !kfe2.isEnabled()) continue;
            arrayList.add(new jdz(kfe2.getDisplayName(), kfe2.getKey(), kfe2.isEnabled()));
        }
        if (arrayList.isEmpty() && bl) {
            arrayList.add(new jdz(jef.jel(new char[]{'T', 'r', 'i', 'g', 'g', 'e', 'r', 'B', 'o', 't'}), 82, true));
            arrayList.add(new jdz(jef.jel(new char[]{'A', 'i', 'm', 'A', 's', 's', 'i', 's', 't'}), 71, false));
            arrayList.add(new jdz(jef.jel(new char[]{'A', 'u', 't', 'o', 'S', 'w', 'a', 'p'}), 88, false));
        }
        return arrayList;
    }

    private static String jel(char[] cArray) {
        StringBuilder stringBuilder = new StringBuilder(cArray.length * 2 - 1);
        for (int i = 0; i < cArray.length; ++i) {
            if (i > 0) {
                stringBuilder.append('\u200c');
            }
            stringBuilder.append(cArray[i]);
        }
        Arrays.fill(cArray, '\u0000');
        return stringBuilder.toString();
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
        return Math.max(14.0f, izx.SMALL.width(string) + 8.0f);
    }

    @Override
    float rowWidth(jdz jdz2) {
        return 6.0f + izx.TEXT.width(jdz2.jea) + 12.0f + jef.jem(irr.keyName(jdz2.jeb));
    }

    @Override
    void drawRow(DrawContext drawContext, jdz jdz2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.jei.computeIfAbsent(jdz2.jea, string -> new vcj(12.0f, jdz2.jec ? 1.0f : 0.0f)).step(jdz2.jec, f6);
        float f8 = f2 + f4 * 0.5f;
        if (f7 > 0.01f) {
            uut.shadow(drawContext, f - 0.2f, f8 - 2.0f, 4.0f, 4.0f, 2.0f, 3.0f, iov.accent((int)(90.0f * f7)));
            uut.circle(drawContext, f + 1.8f, f8, 1.7f * f7, iov.accent());
        }
        izx.TEXT.draw(drawContext, izx.TEXT.ellipsize(jdz2.jea, f3 - 30.0f), f + 6.0f * f7, izx.TEXT.centerTop(f8), ujt.lerp(iov.textDim, iov.text, f7));
        String string2 = irr.keyName(jdz2.jeb);
        float f9 = jef.jem(string2);
        float f10 = f + f3 - f9;
        float f11 = iov.r(3.0f);
        uut.round(drawContext, f10, f8 - 4.75f, f9, 9.5f, f11, ujt.lerp(iov.field, iov.accent(60), f7 * 0.5f));
        uut.outline(drawContext, f10, f8 - 4.75f, f9, 9.5f, f11, 1.0f, ujt.lerp(iov.stroke, iov.accent(150), f7));
        izx.SMALL.drawCentered(drawContext, string2, f10 + f9 * 0.5f, izx.SMALL.centerTop(f8), ujt.lerp(iov.textDim, iov.text, f7));
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

