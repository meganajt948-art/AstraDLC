/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.SkinTextures
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.iov;
import a.izx;
import a.jcs;
import a.jjj;
import a.lsx;
import a.ujt;
import a.ukf;
import a.uog;
import a.uut;
import a.vcj;
import a.vcq;
import a.vkl;
import a.vmo;
import a.vxu;
import a.vyd;
import a.vyk;
import a.wap;
import flow.dev.a;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

public final class jjx
extends jcs {
    public static final vkl PLAYERS_ONLY = new vkl(a.b("\u02a6\u7b2b\uf1f5\u6f9c\ue457\u62f1\ud8a3\u5101\ucf11\u45a1\uc270\u3814", -1863122182), true);
    public static final vkl ITEMS = new vkl(a.c(-1917470152, "\uba76\uc3f4\u4938\ud74b\u5c81\uda62\u6070\ue98e\u77db\ufd2e\u7ab5\u80cd\u0e15\u97ae\u1dea"), true);
    public static final List<vmo> OPTIONS = List.of(PLAYERS_ONLY, ITEMS);
    private static final float jjy = 168.0f;
    private static final float jjz = 46.0f;
    private static final float jka = 40.0f;
    private static final float jkb = 8.0f;
    private static final float jkc = 30.0f;
    private static final float jkd = 15.0f;
    private static final float jke = 2.4f;
    private static final float jkf = 10.5f;
    private static final long jkg = 6000L;
    private static final long jkh = 900L;
    private static final double jki = 10.0;
    private static final int jkj = -12595334;
    private static final int jkk = -865972;
    private static final int jkl = -1092784;
    private static final int jkm = -670639;
    private static final EquipmentSlot[] jkn = new EquipmentSlot[]{EquipmentSlot.field_6169, EquipmentSlot.field_6174, EquipmentSlot.field_6172, EquipmentSlot.field_6166};
    private static LivingEntity jko;
    private static long jkp;
    private LivingEntity jkq;
    private long jkr;
    private jjj jks;
    private boolean jkt;
    private int jku;
    private final vcj jkv = new vcj(9.0f, 1.0f);
    private final vcj jkw = new vcj(4.5f, 1.0f);
    private final vcj jkx = new vcj(9.0f);
    private final vcj jky = new vcj(6.0f);
    private final vcj jkz = new vcj(10.0f);
    private final vcj jla = new vcj(9.0f);
    private long jlb;
    private static /* synthetic */ long jlc;
    private static /* synthetic */ int jld;

    jjx() {
        super(a.d("\ub06f\uc9cb\u430b\udd6f\u56ba\ud01a", -1709636020, 78624337), a.b("\u5030\u29b4\ua374\u3d10\ub6c5\u3065", 787959906), true, 1, 1, 0.0f, 44.0f);
    }

    @Override
    public List<vmo> settings() {
        return OPTIONS;
    }

    public static void onAttack(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity;
            jko = livingEntity = (LivingEntity)entity;
            jkp = System.currentTimeMillis();
        }
    }

    @Override
    void update(float f, boolean bl) {
        float f2;
        LivingEntity livingEntity;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        long l = System.currentTimeMillis();
        LivingEntity livingEntity2 = livingEntity = this.enabled.get() ? jjx.jle(minecraftClient, l) : null;
        if (livingEntity != null) {
            this.jkr = l;
            if (livingEntity != this.jkq) {
                if (this.jkq != null) {
                    this.jla.set(1.0f);
                }
                this.jkq = livingEntity;
                this.jku = livingEntity.field_6235;
                vyd vyd2 = vyk.of(livingEntity);
                f2 = vyd2.fraction();
                this.jkv.set(f2);
                this.jkw.set(f2);
                this.jkx.set(vyd2.unknown() ? 0.0f : Math.min(1.0f, vyd2.absorption() / vyd2.max()));
                this.jkz.set(f2 < 0.3f ? 1.0f : 0.0f);
            }
        } else if (!(this.jkq == null || l - this.jkr <= 900L && jjx.jlf(minecraftClient, this.jkq))) {
            this.jkq = null;
        }
        this.jkt = false;
        if (this.jkq != null) {
            this.jks = jjx.jlg(this.jkq, minecraftClient);
        } else if (bl && minecraftClient.field_1724 != null) {
            this.jks = jjx.jlh(minecraftClient.field_1724);
            this.jkt = true;
        }
        if (this.jks == null) {
            return;
        }
        float f3 = this.jks.jjp ? 1.0f : Math.min(1.0f, this.jks.jjm / Math.max(1.0f, this.jks.jjn));
        if (f3 < (f2 = this.jkv.get()) - 0.001f && this.jkw.get() <= f2 + 0.001f) {
            this.jlb = l + 350L;
            this.jkw.set(Math.max(this.jkw.get(), f2));
        }
        this.jkv.step(f3, f);
        if (f3 > this.jkw.get() || l > this.jlb) {
            this.jkw.step(Math.max(f3, this.jkv.get()), f);
        }
        this.jkx.step(this.jks.jjp ? 0.0f : Math.min(1.0f, this.jks.jjo / Math.max(1.0f, this.jks.jjn)), f);
        this.jkz.step(f3 < 0.3f ? 1.0f : 0.0f, f);
        if (this.jkq != null && this.jkq.field_6235 > this.jku) {
            this.jky.set(1.0f);
        }
        this.jku = this.jkq != null ? this.jkq.field_6235 : 0;
        this.jky.step(0.0f, f);
        this.jla.step(0.0f, f);
    }

    private static LivingEntity jle(MinecraftClient minecraftClient, long l) {
        LivingEntity livingEntity;
        if (jko != null && l - jkp < 6000L && jjx.jlf(minecraftClient, jko)) {
            return jko;
        }
        Entity entity = minecraftClient.field_1692;
        if (entity instanceof LivingEntity && !((livingEntity = (LivingEntity)entity) instanceof ArmorStandEntity) && jjx.jlf(minecraftClient, livingEntity)) {
            return livingEntity;
        }
        livingEntity = minecraftClient.field_1724;
        if (livingEntity == null || minecraftClient.field_1687 == null) {
            return null;
        }
        entity = livingEntity.method_33571();
        Vec3d vec3d = livingEntity.method_5828(1.0f);
        PlayerEntity playerEntity = null;
        double d = Math.cos(Math.toRadians(5.0));
        for (PlayerEntity playerEntity2 : minecraftClient.field_1687.method_18456()) {
            double d2;
            Vec3d vec3d2;
            double d3;
            if (playerEntity2 == livingEntity || !jjx.jlf(minecraftClient, (LivingEntity)playerEntity2) || (d3 = (vec3d2 = playerEntity2.method_5829().method_1005().method_1020((Vec3d)entity)).method_1033()) > 10.0 || d3 < 0.01 || !((d2 = vec3d2.method_1021(1.0 / d3).method_1026(vec3d)) > d) || !livingEntity.method_6057((Entity)playerEntity2)) continue;
            d = d2;
            playerEntity = playerEntity2;
        }
        return playerEntity;
    }

    private static boolean jlf(MinecraftClient minecraftClient, LivingEntity livingEntity) {
        if (minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || livingEntity == minecraftClient.field_1724 || !livingEntity.method_5805() || livingEntity.method_31481() || minecraftClient.field_1687.method_8469(livingEntity.method_5628()) != livingEntity) {
            return false;
        }
        if (PLAYERS_ONLY.get() && !(livingEntity instanceof PlayerEntity)) {
            return false;
        }
        return minecraftClient.field_1724.method_5858((Entity)livingEntity) < 576.0;
    }

    private static jjj jlg(LivingEntity livingEntity, MinecraftClient minecraftClient) {
        SkinTextures skinTextures;
        Object object;
        if (livingEntity instanceof AbstractClientPlayerEntity) {
            object = (AbstractClientPlayerEntity)livingEntity;
            skinTextures = object.method_52814();
        } else {
            skinTextures = null;
        }
        SkinTextures skinTextures2 = skinTextures;
        object = vyk.of(livingEntity);
        ItemStack[] itemStackArray = new ItemStack[4];
        for (int i = 0; i < 4; ++i) {
            itemStackArray[i] = livingEntity.method_6118(jkn[i]);
        }
        float f = minecraftClient.field_1724 != null ? (float)Math.sqrt(minecraftClient.field_1724.method_5858((Entity)livingEntity)) : 0.0f;
        return new jjj(lsx.protect(livingEntity.method_5477().getString()), skinTextures2, ((vyd)object).health(), ((vyd)object).max(), ((vyd)object).absorption(), ((vyd)object).unknown(), itemStackArray, livingEntity.method_6047(), livingEntity.method_6079(), f, livingEntity.field_6235);
    }

    private static jjj jlh(ClientPlayerEntity clientPlayerEntity) {
        ItemStack[] itemStackArray = new ItemStack[]{jjx.jli(Items.field_22027, 0.08f), jjx.jli(Items.field_22028, 0.35f), jjx.jli(Items.field_8348, 0.62f), jjx.jli(Items.field_8285, 0.86f)};
        return new jjj(lsx.protect(clientPlayerEntity.method_5477().getString()), clientPlayerEntity.method_52814(), 13.5f, 20.0f, 4.0f, false, itemStackArray, jjx.jli(Items.field_22022, 0.2f), new ItemStack((ItemConvertible)Items.field_8288), 3.4f, 0);
    }

    private static ItemStack jli(Item item, float f) {
        ItemStack itemStack = new ItemStack((ItemConvertible)item);
        if (itemStack.method_7963()) {
            itemStack.method_7974(Math.round((float)itemStack.method_7936() * f));
        }
        return itemStack;
    }

    @Override
    boolean hasContent(boolean bl) {
        return this.jkq != null || bl && this.jks != null;
    }

    @Override
    boolean canGhost() {
        return true;
    }

    @Override
    boolean isSample() {
        return this.jkt;
    }

    @Override
    float width() {
        return 168.0f;
    }

    @Override
    float height() {
        return ITEMS.get() ? 46.0f : 40.0f;
    }

    @Override
    void draw(DrawContext drawContext, float f, boolean bl) {
        jjj jjj2 = this.jks;
        if (jjj2 == null) {
            return;
        }
        float f2 = 168.0f;
        float f3 = this.height();
        float f4 = iov.r(9.0f);
        izx.panel(drawContext, f2, f3, f4);
        float f5 = vcq.outCubic(this.jla.get());
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(0.0f, f3 * 0.5f);
        drawContext.method_51448().scale(1.0f, 1.0f - 0.18f * f5);
        drawContext.method_51448().translate(0.0f, -f3 * 0.5f);
        uut.pushAlpha(1.0f - 0.85f * f5);
        this.jlj(drawContext, jjj2, 8.0f, (f3 - 30.0f) * 0.5f);
        this.jlk(drawContext, jjj2, 46.0f, f3);
        this.jln(drawContext, jjj2, f2 - 8.0f - 15.0f, f3 * 0.5f);
        uut.popAlpha();
        drawContext.method_51448().popMatrix();
    }

    private void jlj(DrawContext drawContext, jjj jjj2, float f, float f2) {
        boolean bl;
        float f3 = Math.min(15.0f, iov.r(7.0f));
        float f4 = vcq.outCubic(this.jky.get());
        float f5 = 1.0f - 0.07f * f4;
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f + 15.0f, f2 + 15.0f);
        drawContext.method_51448().scale(f5, f5);
        float f6 = -15.0f;
        ukf.shadow(drawContext, f6, f6, 30.0f, 30.0f, f3, 0.8f, iov.lightness());
        int n = ujt.lerp(-1, -34182, f4);
        boolean bl2 = bl = jjj2.jjl != null && uog.draw(drawContext, jjj2.jjl, f6, f6, 30.0f, f3, n);
        if (!bl) {
            uut.round(drawContext, f6, f6, 30.0f, 30.0f, f3, iov.field);
            String string = jjj2.jjk.isEmpty() ? a.c(597743189, "\ud66b") : jjj2.jjk.substring(0, 1).toUpperCase(Locale.ROOT);
            izx.RING.drawCentered(drawContext, string, 0.0f, izx.RING.centerTop(0.0f), iov.textDim);
        }
        uut.outlineGradientV(drawContext, f6, f6, 30.0f, 30.0f, f3, 1.0f, 0x38FFFFFF, 0xAFFFFFF);
        drawContext.method_51448().popMatrix();
    }

    private void jlk(DrawContext drawContext, jjj jjj2, float f, float f2) {
        float f3 = 123.0f;
        boolean bl = ITEMS.get();
        float f4 = bl ? 12.5f : f2 * 0.5f - 4.0f;
        String string = wap.unit(a.c(1013091579, "\u8c97"));
        String string2 = jjj2.jjt < 10.0f ? vxu.fixed(jjj2.jjt, 1) + string : Math.round(jjj2.jjt) + string;
        float f5 = izx.SMALL.width(string2);
        String string3 = izx.TITLE.ellipsize(jjj2.jjk, f3 - f - f5 - 5.0f);
        float f6 = izx.TITLE.draw(drawContext, string3, f, izx.TITLE.centerTop(f4), iov.text);
        izx.SMALL.draw(drawContext, string2, f6 + 4.0f, izx.SMALL.centerTop(f4 + 0.4f), iov.textMuted);
        if (!bl) {
            String string4;
            String string5 = jjj2.jjp ? wap.s(a.c(1260143208, "\u4228\u3bbe\ub175\u2f1b\ua4d6\u227d\u9825\u11da\u8f8c"), a.d("\u03cb\u7a52\uf086\u6efd\ue526\u639b\ud9cc\u503b\uce6e", 2016193710, -1402164367)) : (string4 = jjj2.jjo > 0.05f ? wap.s(a.c(-2051821588, "\uafa4\ud636\u5cf4\uc299\u4953\ucff2\u75aa\ufc5c\u620a"), a.d("\u3040\u49d0\uc30e\u5d77\ud6a5\u5063\uea4c\u63b5\ufdef\u7753", -776127170, -600110741)) : "");
            if (!string4.isEmpty()) {
                izx.SUB.draw(drawContext, string4, f, izx.SUB.centerTop(f4 + 9.0f), iov.textMuted);
            }
            return;
        }
        float f7 = 22.5f;
        float f8 = f;
        for (ItemStack itemStack : jjj2.jjq) {
            this.jll(drawContext, itemStack, f8, f7);
            f8 += 12.0f;
        }
        uut.rect(drawContext, (f8 += 2.0f) - 0.5f, f7 + 2.0f, 1.0f, 7.5f, ujt.mulAlpha(iov.textMuted, 0.3f));
        this.jll(drawContext, jjj2.jjr, f8 += 3.5f, f7);
        this.jll(drawContext, jjj2.jjs, f8 += 12.0f, f7);
    }

    private void jll(DrawContext drawContext, ItemStack itemStack, float f, float f2) {
        if (itemStack == null || itemStack.method_7960()) {
            uut.round(drawContext, f + 5.25f - 1.2f, f2 + 5.25f - 1.2f, 2.4f, 2.4f, 1.2f, ujt.mulAlpha(iov.textMuted, 0.35f));
            return;
        }
        float f3 = uut.alpha();
        float f4 = 0.65625f * Math.min(1.0f, f3 * 2.5f);
        if (f4 > 0.02f) {
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate(f + 5.25f, f2 + 5.25f);
            drawContext.method_51448().scale(f4, f4);
            drawContext.method_51427(itemStack, -8, -8);
            drawContext.method_51448().popMatrix();
        }
        if (itemStack.method_7963() && itemStack.method_7936() > 0) {
            float f5 = 1.0f - (float)itemStack.method_7919() / (float)itemStack.method_7936();
            float f6 = 8.5f;
            float f7 = f2 + 10.5f + 2.2f;
            uut.round(drawContext, f + 1.0f, f7, f6, 1.3f, 0.65f, iov.track);
            uut.round(drawContext, f + 1.0f, f7, Math.max(1.3f, f6 * f5), 1.3f, 0.65f, jjx.jlm(f5));
        }
    }

    private static int jlm(float f) {
        return f > 0.5f ? ujt.lerp(-865972, -12595334, (f - 0.5f) * 2.0f) : ujt.lerp(-1092784, -865972, f * 2.0f);
    }

    private void jln(DrawContext drawContext, jjj jjj2, float f, float f2) {
        float f3;
        uut.arc(drawContext, f, f2, 15.0f, 2.4f, 0.0f, 1.0f, ujt.mulAlpha(iov.text, 0.12f));
        if (jjj2.jjp) {
            float f4 = (float)((double)System.nanoTime() / 1.0E9 * 0.6 % 1.0);
            uut.arc(drawContext, f, f2, 15.0f, 2.4f, f4, 0.22f, ujt.mulAlpha(iov.textMuted, 0.9f));
            izx.RING.drawCentered(drawContext, a.c(580886078, "\u9e00"), f, izx.RING.centerTop(f2), iov.text);
            return;
        }
        float f5 = this.jkv.get();
        float f6 = this.jkw.get();
        if (f6 > f5 + 0.002f) {
            uut.arc(drawContext, f, f2, 15.0f, 2.4f, 0.0f, f6, ujt.withAlpha(-1092784, 150));
        }
        int n = ujt.lerp(iov.accent(), -1092784, this.jkz.get());
        uut.arc(drawContext, f, f2, 15.0f, 2.4f, 0.0f, f5, n);
        float f7 = this.jkx.get();
        if (f7 > 0.003f) {
            uut.arc(drawContext, f, f2, 17.6f, 1.1f, 0.0f, f7, -670639);
        }
        String string = (f3 = jjj2.jjm + jjj2.jjo) >= 100.0f || Math.abs(f3 - (float)Math.round(f3)) < 0.05f ? String.valueOf(Math.round(f3)) : vxu.fixed(f3, 1);
        izx.RING.drawCentered(drawContext, string, f, izx.RING.centerTop(f2 - 1.8f), jjj2.jjo > 0.05f ? -670639 : iov.text);
        izx.TINY.drawCentered(drawContext, wap.s(a.d("\uabc5\ud26c", -1149007518, 1856840397), a.c(1542228651, "\u8eec\uf727")), f, izx.TINY.centerTop(f2 + 5.2f), iov.textMuted);
    }

    private static /* synthetic */ int aoj(int n, int n2) {
        return n * n2 + 156495881;
    }

    private static /* synthetic */ int aok(int n, int n2) {
        return jjx.aoj(n, n2) ^ 0x7147DFF6;
    }
}

