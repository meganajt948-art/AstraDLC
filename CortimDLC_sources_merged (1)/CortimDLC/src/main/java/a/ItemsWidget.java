/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_746
 */
package a;

import a.Theme;
import a.UiKit;
import a.Hud;
import a.HudWidget;
import a.jcz;
import a.oxi;
import a.ServerHelper;
import a.ColorUtil;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.KeyUtil;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_746;

public final class ItemsWidget
extends HudWidget {
    private static final float jdd = 14.0f;
    private static final float jde = 5.0f;
    private static final float jdf = 9.0f;
    private static final float jdg = 5.0f;
    private static final float jdh = 40.0f;
    private List<jcz> jdi = new ArrayList<jcz>();
    private final Map<String, jcz> jdj = new HashMap<String, jcz>();
    private final Spring jdk = new Spring(13.0f, 40.0f);
    private boolean jdl;
    private boolean jdm;
    private long jdn;
    private boolean jdo;
    private boolean jdp;
    private static /* synthetic */ int jdq;
    private static /* synthetic */ long jdr;

    ItemsWidget() {
        super("items", "Items", true, 1, 2, 0.0f, 72.0f);
    }

    private static List<oxi> jds(boolean bl) {
        ArrayList<oxi> arrayList = new ArrayList<oxi>();
        ServerHelper oxw2 = ServerHelper.get();
        if (oxw2 != null && oxw2.isEnabled()) {
            arrayList.addAll(oxw2.entries(class_310.method_1551().method_61966().method_60637(true)));
        }
        if (arrayList.isEmpty() && bl) {
            arrayList.add(ItemsWidget.jdt("aura", new class_1799((class_1935)class_1802.field_8614, 15), 90));
            arrayList.add(ItemsWidget.jdt("dust", new class_1799((class_1935)class_1802.field_8479, 20), 89));
            arrayList.add(ItemsWidget.jdt("trap", new class_1799((class_1935)class_1802.field_22021, 15), 86));
            arrayList.add(ItemsWidget.jdt("plast", new class_1799((class_1935)class_1802.field_8551, 18), 66));
            arrayList.add(ItemsWidget.jdt("holywater", new class_1799((class_1935)class_1802.field_8436, 2), KeyUtil.combo(50, 2)));
        }
        return arrayList;
    }

    private static oxi jdt(String string, class_1799 class_17992, int n) {
        return new oxi("preview:" + string, string, class_17992, class_17992.method_7947(), n, 0.0f, 0L, false);
    }

    @Override
    void update(float f, boolean bl) {
        long l = System.nanoTime();
        boolean bl2 = this.enabled.get();
        if (l - this.jdn >= 50000000L || bl != this.jdo || bl2 != this.jdp) {
            this.jdn = l;
            this.jdo = bl;
            this.jdp = bl2;
            this.jdu(bl2, bl);
        }
        float f2 = 0.0f;
        for (jcz jcz3 : this.jdi) {
            float f3 = Easing.outCubic(jcz3.appear.step(jcz3.alive, f));
            jcz3.owned.step(jcz3.item.count() > 0, f);
            jcz3.busy.step(jcz3.item.active(), f);
            f2 += (ItemsWidget.jdw(jcz3.item) + 5.0f) * f3;
        }
        this.jdi.removeIf(jcz2 -> !jcz2.alive && jcz2.appear.get() <= 0.01f);
        this.jdk.set(Math.max(40.0f, f2 - 5.0f));
    }

    /*
     * WARNING - void declaration
     */
    private void jdu(boolean bl, boolean bl2) {
        void var5_8;
        List<Object> list = bl ? ItemsWidget.jds(false) : List.of();
        this.jdm = false;
        if (list.isEmpty() && bl2 && bl) {
            list = ItemsWidget.jds(true);
            this.jdm = !list.isEmpty();
        }
        this.jdj.clear();
        for (jcz object : this.jdi) {
            this.jdj.put(object.id, object);
        }
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            jcz jcz2 = this.jdj.remove(((oxi)object).id());
            if (jcz2 == null) {
                jcz2 = new jcz(((oxi)object).id());
                jcz2.owned.set(((oxi)object).count() > 0 ? 1.0f : 0.0f);
            }
            jcz2.item = object;
            jcz2.alive = true;
            arrayList.add(jcz2);
        }
        boolean bl3 = false;
        while (var5_8 < this.jdi.size()) {
            Object object;
            object = this.jdi.get((int)var5_8);
            if (this.jdj.containsKey(((jcz)object).id)) {
                ((jcz)object).alive = false;
                arrayList.add(Math.min((int)var5_8, arrayList.size()), object);
            }
            ++var5_8;
        }
        this.jdi = arrayList;
        this.jdl = !list.isEmpty();
    }

    @Override
    boolean hasContent(boolean bl) {
        return this.jdl;
    }

    @Override
    boolean canGhost() {
        return true;
    }

    @Override
    boolean isSample() {
        return this.jdm;
    }

    @Override
    float width() {
        return this.jdk.get();
    }

    @Override
    float height() {
        return 14.0f;
    }

    private static String jdv(oxi oxi2) {
        return "x" + oxi2.count();
    }

    private static float jdw(oxi oxi2) {
        return 17.5f + Hud.TEXT.width(ItemsWidget.jdv(oxi2)) + 6.0f + Hud.TEXT.width(UiKit.keyName(oxi2.key())) + 5.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void draw(class_332 class_3322, float f, boolean bl) {
        long l = System.currentTimeMillis();
        float f2 = 0.0f;
        for (jcz object : this.jdi) {
            f2 += (ItemsWidget.jdw(object.item) + 5.0f) * Easing.outCubic(object.appear.get());
        }
        float f3 = (this.width() - Math.max(0.0f, f2 - 5.0f)) * 0.5f;
        for (jcz jcz2 : this.jdi) {
            float f4 = Easing.outCubic(jcz2.appear.get());
            float f5 = ItemsWidget.jdw(jcz2.item);
            if (f4 > 0.02f) {
                DrawUtil.pushAlpha(Math.min(1.0f, f4 * 1.2f) * (0.45f + 0.55f * jcz2.owned.get()));
                class_3322.method_51448().pushMatrix();
                float f6 = 0.8f + 0.2f * f4;
                class_3322.method_51448().translate(f3 + f5 * f4 * 0.5f, 7.0f);
                class_3322.method_51448().scale(f6, f6);
                class_3322.method_51448().translate(-f5 * 0.5f, -7.0f);
                try {
                    this.jdx(class_3322, jcz2, f5, f4, l);
                }
                finally {
                    class_3322.method_51448().popMatrix();
                    DrawUtil.popAlpha();
                }
            }
            f3 += (f5 + 5.0f) * f4;
        }
    }

    private void jdx(class_332 class_3322, jcz jcz2, float f, float f2, long l) {
        oxi oxi2 = jcz2.item;
        float f3 = Theme.r(4.0f);
        float f4 = Math.max(jcz2.busy.get(), 1.0f - Easing.outCubic(Math.min(1.0f, (float)(l - oxi2.usedAt()) / 700.0f)));
        if (f4 > 0.01f) {
            DrawUtil.shadow(class_3322, 0.0f, 0.0f, f, 14.0f, f3, 6.0f, Theme.accent((int)(110.0f * f4)));
        }
        Hud.chip(class_3322, 0.0f, 0.0f, f, 14.0f, f3);
        if (f4 > 0.01f) {
            DrawUtil.round(class_3322, 0.0f, 0.0f, f, 14.0f, f3, Theme.accent((int)(45.0f * f4)));
            DrawUtil.outline(class_3322, 0.0f, 0.0f, f, 14.0f, f3, 1.0f, Theme.accent((int)(190.0f * f4)));
        }
        float f5 = 7.0f;
        float f6 = 0.5625f * f2;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(9.5f, f5);
        class_3322.method_51448().scale(f6, f6);
        class_3322.method_51427(oxi2.icon(), -8, -8);
        class_3322.method_51448().popMatrix();
        float f7 = ItemsWidget.jdy(oxi2);
        float f8 = 17.5f;
        String string = ItemsWidget.jdv(oxi2);
        int n = oxi2.count() > 0 ? ColorUtil.lerp(Theme.text, Theme.textDim, f7 > 0.001f ? 0.6f : 0.0f) : -1096636;
        f8 = Hud.TEXT.draw(class_3322, string, f8, Hud.TEXT.centerTop(f5), n);
        Hud.TEXT.draw(class_3322, UiKit.keyName(oxi2.key()), f8 + 6.0f, Hud.TEXT.centerTop(f5), ColorUtil.lerp(Theme.textDim, Theme.text, 0.55f + 0.45f * f4));
        if (f7 > 0.001f) {
            float f9 = f - f3 * 2.0f;
            DrawUtil.round(class_3322, f3, 11.8f, f9, 1.2f, 0.6f, ColorUtil.withAlpha(0xFFFFFF, 30));
            DrawUtil.gradientH(class_3322, f3, 11.8f, Math.max(1.2f, f9 * f7), 1.2f, 0.6f, Theme.accent(), Theme.accent2());
        }
    }

    private static float jdy(oxi oxi2) {
        class_310 class_3102 = class_310.method_1551();
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null || oxi2.count() <= 0 || oxi2.id().startsWith("preview:")) {
            return oxi2.cooldown();
        }
        return class_7462.method_7357().method_7905(oxi2.icon(), class_3102.method_61966().method_60637(true));
    }

    private static /* synthetic */ int aly(int n, int n2) {
        return n - n2 | 0xA2152A6E;
    }
}

