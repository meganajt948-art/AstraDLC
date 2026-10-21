/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.Theme;
import a.Hud;
import a.TimedWidget;
import a.jfn;
import a.ney;
import a.AutoMines;
import a.MineRarity;
import a.ColorUtil;
import a.DrawUtil;
import a.Icon;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_332;

public final class MinesWidget
extends TimedWidget<jfn> {
    private static final float jfx = 12.0f;
    private static final int jfy = -4932924;
    private static final int jfz = -4160260;
    private static final int jga = -278748;
    private static /* synthetic */ int jgb;
    private static /* synthetic */ boolean jgc;

    MinesWidget() {
        super("mines", "Mines", Icon.CLOCK, true, 2, 1, 6.0f, 0.0f);
    }

    @Override
    List<jfn> items(boolean bl) {
        ArrayList<jfn> arrayList = new ArrayList<jfn>();
        String string = AutoMines.hudStatus();
        if (string == null) {
            if (bl) {
                long l = System.currentTimeMillis();
                arrayList.add(new jfn("status", Lang.s("Waiting for Mythic · 0:19", "Жду Мифическая · 0:19"), 0, null, 0L, false));
                arrayList.add(new jfn("108", null, 108, MineRarity.MYTHIC, l + 19000L, true));
                arrayList.add(new jfn("112", null, 112, MineRarity.LEGENDARY, l + 95000L, false));
                arrayList.add(new jfn("109", null, 109, MineRarity.COMMON, l + 141000L, false));
            }
            return arrayList;
        }
        arrayList.add(new jfn("status", string, 0, null, 0L, false));
        for (ney ney2 : AutoMines.hudRows()) {
            arrayList.add(new jfn(String.valueOf(ney2.id()), null, ney2.id(), ney2.tier(), ney2.refreshAt(), ney2.focus()));
        }
        return arrayList;
    }

    @Override
    String key(jfn jfn2) {
        return jfn2.jfo;
    }

    @Override
    float rowHeight() {
        return 12.0f;
    }

    @Override
    long refreshNanos() {
        return 250000000L;
    }

    @Override
    float rowWidth(jfn jfn2) {
        if (jfn2.jfp != null) {
            return 8.0f + Hud.TEXT.width(jfn2.jfp);
        }
        return 8.0f + Hud.TEXT.width("000") + 8.0f + Hud.TEXT.width(Lang.value(jfn2.jfr.title())) + 14.0f + Hud.VALUE.width("00:00");
    }

    @Override
    void drawRow(class_332 class_3322, jfn jfn2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 + f4 * 0.5f;
        if (jfn2.jfp != null) {
            DrawUtil.circle(class_3322, f + 1.8f, f7, 1.7f, Theme.accent());
            Hud.TEXT.draw(class_3322, Hud.TEXT.ellipsize(jfn2.jfp, f3 - 8.0f), f + 7.0f, Hud.TEXT.centerTop(f7), Theme.text);
            return;
        }
        if (jfn2.jft) {
            DrawUtil.shadow(class_3322, f - 0.2f, f7 - 2.0f, 4.0f, 4.0f, 2.0f, 3.0f, Theme.accent(90));
            DrawUtil.circle(class_3322, f + 1.8f, f7, 1.7f, Theme.accent());
        }
        String string = String.valueOf(jfn2.jfq);
        float f8 = f + 7.0f;
        Hud.TEXT.draw(class_3322, string, f8, Hud.TEXT.centerTop(f7), jfn2.jft ? Theme.text : Theme.textDim);
        f8 += Hud.TEXT.width("000") + 8.0f;
        int n = switch (jfn2.jfr) {
            case MineRarity.LEGENDARY -> -278748;
            case MineRarity.MYTHIC -> -4160260;
            default -> -4932924;
        };
        Hud.TEXT.draw(class_3322, Lang.value(jfn2.jfr.title()), f8, Hud.TEXT.centerTop(f7), n);
        long l = jfn2.jfs - System.currentTimeMillis();
        String string2 = l > 0L ? AutoMines.clock(l) : Lang.s("now", "сейчас");
        int n2 = MinesWidget.expiring(jfn2.jft ? Theme.text : ColorUtil.lerp(Theme.textDim, Theme.text, 0.4f), (float)l / 1000.0f);
        Hud.VALUE.draw(class_3322, string2, f + f3 - Hud.VALUE.width(string2), Hud.VALUE.centerTop(f7), n2);
    }

    private static /* synthetic */ int anb(int n, int n2) {
        return n * n2 + 1479854141;
    }

    private static /* synthetic */ int anc(int n, int n2) {
        return MinesWidget.anb(n, n2) ^ 0x8CE21767;
    }

    private static /* synthetic */ int and(int n, int n2) {
        return MinesWidget.anc(n, n2) + n;
    }
}

