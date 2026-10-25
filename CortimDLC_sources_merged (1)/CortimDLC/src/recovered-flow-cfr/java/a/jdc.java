/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.iov;
import a.irr;
import a.izx;
import a.jcs;
import a.jcz;
import a.oxi;
import a.oxw;
import a.ujt;
import a.uut;
import a.vcj;
import a.vcq;
import a.vzz;
import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class jdc
extends jcs {
    private static final float jdd = 14.0f;
    private static final float jde = 5.0f;
    private static final float jdf = 9.0f;
    private static final float jdg = 5.0f;
    private static final float jdh = 40.0f;
    private List<jcz> jdi = new ArrayList<jcz>();
    private final Map<String, jcz> jdj = new HashMap<String, jcz>();
    private final vcj jdk = new vcj(13.0f, 40.0f);
    private boolean jdl;
    private boolean jdm;
    private long jdn;
    private boolean jdo;
    private boolean jdp;
    private static /* synthetic */ int jdq;
    private static /* synthetic */ long jdr;

    jdc() {
        super(a.d("\u10fd\u6951\ue393\u7dea\uf623", 2012081028, -2140669163), a.b("\u46f7\u3f7b\ub5b9\u2bc0\ua009", 929056443), true, 1, 2, 0.0f, 72.0f);
    }

    private static List<oxi> jds(boolean bl) {
        ArrayList<oxi> arrayList = new ArrayList<oxi>();
        oxw oxw2 = oxw.get();
        if (oxw2 != null && oxw2.isEnabled()) {
            arrayList.addAll(oxw2.entries(MinecraftClient.method_1551().method_61966().method_60637(true)));
        }
        if (arrayList.isEmpty() && bl) {
            arrayList.add(jdc.jdt(a.d("\u0961\u70c4\ufa10\u6472", 40181496, -368830468), new ItemStack((ItemConvertible)Items.field_8614, 15), 90));
            arrayList.add(jdc.jdt(a.d("\ue670\u9fd0\u1505\u8b73", -940031681, -401496273), new ItemStack((ItemConvertible)Items.field_8479, 20), 89));
            arrayList.add(jdc.jdt(a.b("\u9e3a\ue78d\u6d4d\uf32d", 1707449930), new ItemStack((ItemConvertible)Items.field_22021, 15), 86));
            arrayList.add(jdc.jdt(a.b("\ue7fe\u9e53\u148d\u8aee\u013e", 186640267), new ItemStack((ItemConvertible)Items.field_8551, 18), 66));
            arrayList.add(jdc.jdt(a.b("\ufc58\u85ee\u0f3e\u915a\u1a83\u9c24\u2662\uaf82\u31ca", -341509063), new ItemStack((ItemConvertible)Items.field_8436, 2), vzz.combo(50, 2)));
        }
        return arrayList;
    }

    private static oxi jdt(String string, ItemStack itemStack, int n) {
        return new oxi(a.c(1120294939, "\u5863\u21d0\uab14\u3576\ubebe\u3803\u8242\u0bfe") + string, string, itemStack, itemStack.method_7947(), n, 0.0f, 0L, false);
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
            float f3 = vcq.outCubic(jcz3.appear.step(jcz3.alive, f));
            jcz3.owned.step(jcz3.item.count() > 0, f);
            jcz3.busy.step(jcz3.item.active(), f);
            f2 += (jdc.jdw(jcz3.item) + 5.0f) * f3;
        }
        this.jdi.removeIf(jcz2 -> !jcz2.alive && jcz2.appear.get() <= 0.01f);
        this.jdk.set(Math.max(40.0f, f2 - 5.0f));
    }

    /*
     * WARNING - void declaration
     */
    private void jdu(boolean bl, boolean bl2) {
        void var5_8;
        List<Object> list = bl ? jdc.jds(false) : List.of();
        this.jdm = false;
        if (list.isEmpty() && bl2 && bl) {
            list = jdc.jds(true);
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
        return a.b("\u7122", -1168215717) + oxi2.count();
    }

    private static float jdw(oxi oxi2) {
        return 17.5f + izx.TEXT.width(jdc.jdv(oxi2)) + 6.0f + izx.TEXT.width(irr.keyName(oxi2.key())) + 5.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void draw(DrawContext drawContext, float f, boolean bl) {
        long l = System.currentTimeMillis();
        float f2 = 0.0f;
        for (jcz object : this.jdi) {
            f2 += (jdc.jdw(object.item) + 5.0f) * vcq.outCubic(object.appear.get());
        }
        float f3 = (this.width() - Math.max(0.0f, f2 - 5.0f)) * 0.5f;
        for (jcz jcz2 : this.jdi) {
            float f4 = vcq.outCubic(jcz2.appear.get());
            float f5 = jdc.jdw(jcz2.item);
            if (f4 > 0.02f) {
                uut.pushAlpha(Math.min(1.0f, f4 * 1.2f) * (0.45f + 0.55f * jcz2.owned.get()));
                drawContext.method_51448().pushMatrix();
                float f6 = 0.8f + 0.2f * f4;
                drawContext.method_51448().translate(f3 + f5 * f4 * 0.5f, 7.0f);
                drawContext.method_51448().scale(f6, f6);
                drawContext.method_51448().translate(-f5 * 0.5f, -7.0f);
                try {
                    this.jdx(drawContext, jcz2, f5, f4, l);
                }
                finally {
                    drawContext.method_51448().popMatrix();
                    uut.popAlpha();
                }
            }
            f3 += (f5 + 5.0f) * f4;
        }
    }

    private void jdx(DrawContext drawContext, jcz jcz2, float f, float f2, long l) {
        oxi oxi2 = jcz2.item;
        float f3 = iov.r(4.0f);
        float f4 = Math.max(jcz2.busy.get(), 1.0f - vcq.outCubic(Math.min(1.0f, (float)(l - oxi2.usedAt()) / 700.0f)));
        if (f4 > 0.01f) {
            uut.shadow(drawContext, 0.0f, 0.0f, f, 14.0f, f3, 6.0f, iov.accent((int)(110.0f * f4)));
        }
        izx.chip(drawContext, 0.0f, 0.0f, f, 14.0f, f3);
        if (f4 > 0.01f) {
            uut.round(drawContext, 0.0f, 0.0f, f, 14.0f, f3, iov.accent((int)(45.0f * f4)));
            uut.outline(drawContext, 0.0f, 0.0f, f, 14.0f, f3, 1.0f, iov.accent((int)(190.0f * f4)));
        }
        float f5 = 7.0f;
        float f6 = 0.5625f * f2;
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(9.5f, f5);
        drawContext.method_51448().scale(f6, f6);
        drawContext.method_51427(oxi2.icon(), -8, -8);
        drawContext.method_51448().popMatrix();
        float f7 = jdc.jdy(oxi2);
        float f8 = 17.5f;
        String string = jdc.jdv(oxi2);
        int n = oxi2.count() > 0 ? ujt.lerp(iov.text, iov.textDim, f7 > 0.001f ? 0.6f : 0.0f) : -1096636;
        f8 = izx.TEXT.draw(drawContext, string, f8, izx.TEXT.centerTop(f5), n);
        izx.TEXT.draw(drawContext, irr.keyName(oxi2.key()), f8 + 6.0f, izx.TEXT.centerTop(f5), ujt.lerp(iov.textDim, iov.text, 0.55f + 0.45f * f4));
        if (f7 > 0.001f) {
            float f9 = f - f3 * 2.0f;
            uut.round(drawContext, f3, 11.8f, f9, 1.2f, 0.6f, ujt.withAlpha(0xFFFFFF, 30));
            uut.gradientH(drawContext, f3, 11.8f, Math.max(1.2f, f9 * f7), 1.2f, 0.6f, iov.accent(), iov.accent2());
        }
    }

    private static float jdy(oxi oxi2) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || oxi2.count() <= 0 || oxi2.id().startsWith(a.c(1906302599, "\udeff\ua74c\u2d88\ub3ea\u3822\ube9f\u04de\u8d62"))) {
            return oxi2.cooldown();
        }
        return clientPlayerEntity.method_7357().method_7905(oxi2.icon(), minecraftClient.method_61966().method_60637(true));
    }

    private static /* synthetic */ int aly(int n, int n2) {
        return n - n2 | 0xA2152A6E;
    }
}

