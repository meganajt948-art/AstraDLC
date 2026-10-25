/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.entity.EntityType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.SpawnEggItem
 *  net.minecraft.registry.Registries
 */
package a;

import a.hlc;
import a.iah;
import a.iay;
import a.ijy;
import a.iov;
import a.irr;
import a.ppn;
import a.ppu;
import a.ujt;
import a.ukf;
import a.uut;
import a.vcj;
import a.vcq;
import a.vhz;
import a.vjf;
import a.vlg;
import a.vlj;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;

final class ibf
extends ijy {
    static final float W = 430.0f;
    static final float H = 318.0f;
    private static final float ibg = 12.0f;
    private static final float ibh = 30.0f;
    private static final float ibi = 22.0f;
    private static final float ibj = 22.0f;
    private static final float ibk = 20.0f;
    private static final float ibl = 3.0f;
    private static final float ibm = 16.0f;
    private static final Map<vlg, List<iay>> ibn = new EnumMap<vlg, List<iay>>(vlg.class);
    final vlj setting;
    final iah search = new iah(a.b("\ue7ed\u9e6a\u14bd\u8adf\u0119\u87a3", -1955862600), vhz.SEARCH, 32, iah.ANY);
    private final float ibo;
    private final float ibp;
    private final vcj ibq = new vcj(16.0f);
    private final vcj ibr = new vcj(18.0f);
    private final vcj[] ibs = new vcj[]{new vcj(16.0f), new vcj(16.0f), new vcj(16.0f), new vcj(16.0f), new vcj(16.0f)};
    private final vcj ibt = new vcj(16.0f);
    private float ibu;
    private boolean ibv;
    private boolean ibw;
    private List<iay> ibx = List.of();
    private String iby;
    private String ibz;
    private int ica = -1;
    private final vcj icb = new vcj(20.0f);
    private static /* synthetic */ String icc;
    private static /* synthetic */ int icd;

    ibf(vlj vlj2, float f, float f2) {
        this.setting = vlj2;
        this.ibo = (f - 430.0f) * 0.5f;
        this.ibp = (f2 - 318.0f) * 0.5f;
        this.search.onChange = string -> this.icg();
        this.icg();
    }

    private static List<iay> ice(vlg vlg3) {
        if (vlg3 == vlg.LOOT) {
            ArrayList<iay> arrayList = new ArrayList<iay>();
            for (ppn ppn2 : ppu.entries()) {
                arrayList.add(new iay(ppn2.id, ppn2.icon(), ppn2.shownName(), ppn2.name + a.c(1303515078, "\u0fe7") + ppn2.nameEn + a.b("\uceb5", -420884844) + ppn2.id.replace('_', ' ')));
            }
            return arrayList;
        }
        return ibn.computeIfAbsent(vlg3, vlg2 -> {
            ArrayList<iay> arrayList = new ArrayList<iay>();
            if (vlg2 == vlg.MOBS) {
                for (EntityType entityType : Registries.ENTITY_TYPE) {
                    SpawnEggItem spawnEggItem = SpawnEggItem.forEntity((EntityType)entityType);
                    if (spawnEggItem == null) continue;
                    arrayList.add(ibf.icf(Registries.ENTITY_TYPE.getId((Object)entityType).toString(), new ItemStack((ItemConvertible)spawnEggItem), entityType.getName().getString()));
                }
                arrayList.sort((iay2, iay3) -> iay2.ibb.compareToIgnoreCase(iay3.ibb));
            } else if (vlg2 == vlg.BLOCKS) {
                for (Block block : Registries.BLOCK) {
                    if (block == Blocks.AIR || block == Blocks.CAVE_AIR || block == Blocks.VOID_AIR) continue;
                    Item item = block.asItem();
                    if (block == Blocks.WATER) {
                        item = Items.WATER_BUCKET;
                    } else if (block == Blocks.LAVA) {
                        item = Items.LAVA_BUCKET;
                    } else if (block == Blocks.NETHER_PORTAL || block == Blocks.END_PORTAL) {
                        item = Items.ENDER_EYE;
                    }
                    if (item == Items.AIR) continue;
                    String string = Registries.BLOCK.getId((Object)block).toString();
                    arrayList.add(ibf.icf(string, new ItemStack((ItemConvertible)item), block.getName().getString()));
                }
            } else {
                for (Item item : Registries.ITEM) {
                    if (item == Items.AIR) continue;
                    ItemStack itemStack = new ItemStack((ItemConvertible)item);
                    arrayList.add(ibf.icf(Registries.ITEM.getId((Object)item).toString(), itemStack, itemStack.getName().getString()));
                }
            }
            return arrayList;
        });
    }

    private static iay icf(String string, ItemStack itemStack, String string2) {
        String string3 = string.startsWith(a.c(-467973585, "\u4a48\u33fd\ub929\u2753\uac82\u2a22\u9062\u1994\u87d9\u0d26")) ? string.substring(10) : string;
        return new iay(string, itemStack, string2, string2 + a.d("\u6220", 1869347576, 1312856313) + string3 + a.c(-1647638294, "\u08cb") + string3.replace('_', ' '));
    }

    static ItemStack iconOf(vlg vlg2, String string) {
        for (iay iay2 : ibf.ice(vlg2)) {
            if (!iay2.iaz.equals(string)) continue;
            return iay2.iba;
        }
        return ItemStack.EMPTY;
    }

    private void icg() {
        ArrayList<iay> arrayList = new ArrayList<iay>();
        String string = this.search.text;
        for (iay iay2 : ibf.ice(this.setting.kind())) {
            if (this.ibv && !this.setting.contains(iay2.iaz) || !wap.matches(iay2.ibc, string)) continue;
            arrayList.add(iay2);
        }
        this.ibx = arrayList;
        this.ibu = Math.min(this.ibu, this.icr());
    }

    private float ich() {
        return this.ibo + 12.0f;
    }

    private float ici() {
        return this.ibp + 30.0f + 22.0f + 8.0f;
    }

    private float icj() {
        return 406.0f;
    }

    private float ick() {
        return 318.0f - (this.ici() - this.ibp) - 16.0f - 6.0f;
    }

    private boolean icl() {
        return this.setting.kind() == vlg.LOOT || this.setting.kind() == vlg.MOBS;
    }

    private int icm() {
        return this.icl() ? 2 : Math.max(1, (int)((this.icj() + 3.0f) / 25.0f));
    }

    private float icn() {
        return this.icl() ? (this.icj() - 3.0f) * 0.5f : 22.0f;
    }

    private float ico() {
        return this.icl() ? 20.0f : 22.0f;
    }

    private float icp() {
        int n = this.icm();
        if (this.icl()) {
            return this.icn() + 3.0f;
        }
        return n <= 1 ? 25.0f : (this.icj() - 22.0f) / (float)(n - 1);
    }

    private float icq() {
        int n = (this.ibx.size() + this.icm() - 1) / this.icm();
        return (float)n * (this.ico() + 3.0f);
    }

    private float icr() {
        return Math.max(0.0f, this.icq() - this.ick());
    }

    boolean contains(float f, float f2) {
        return irr.inside(f, f2, this.ibo, this.ibp, 430.0f, 318.0f);
    }

    @Override
    iah field() {
        return this.search;
    }

    @Override
    boolean gone() {
        return this.ibw && this.ibq.get() <= 0.01f;
    }

    @Override
    boolean closing() {
        return this.ibw;
    }

    @Override
    void close() {
        this.ibw = true;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = vcq.outCubic(this.ibq.step(this.ibw ? 0.0f : 1.0f, f3));
        if (f7 <= 0.01f) {
            return;
        }
        boolean bl = !this.ibw;
        float f8 = iov.r(10.0f);
        float f9 = iov.lightness();
        uut.round(drawContext, 0.0f, 0.0f, f4, f5, iov.r(12.0f), ujt.withAlpha(0, Math.round(110.0f * f7)));
        uut.pushAlpha(f7);
        drawContext.getMatrices().pushMatrix();
        float f10 = 0.96f + 0.04f * f7;
        drawContext.getMatrices().translate(this.ibo + 215.0f, this.ibp + 159.0f + (1.0f - f7) * 6.0f);
        drawContext.getMatrices().scale(f10, f10);
        drawContext.getMatrices().translate(-(this.ibo + 215.0f), -(this.ibp + 159.0f));
        uut.shadow(drawContext, this.ibo, this.ibp + 4.0f, 430.0f, 318.0f, f8, 18.0f, iov.shadow);
        uut.round(drawContext, this.ibo, this.ibp, 430.0f, 318.0f, f8, ujt.withAlpha(iov.window, 252));
        uut.round(drawContext, this.ibo, this.ibp, 430.0f, 318.0f, f8, iov.card);
        ukf.sheen(drawContext, this.ibo, this.ibp, 430.0f, 50.0f, f8, 0.8f * (1.0f - 0.7f * f9));
        uut.outline(drawContext, this.ibo, this.ibp, 430.0f, 318.0f, f8, 1.0f, iov.stroke);
        ukf.rim(drawContext, this.ibo, this.ibp, 430.0f, 318.0f, f8, f9, 1.0f);
        vjf.draw(drawContext, this.setting.kind() == vlg.BLOCKS ? vhz.LAYERS : vhz.MISC, this.ibo + 12.0f + 5.0f, this.ibp + 15.0f + 1.0f, 10.0f, iov.accent());
        String string = wap.t(this.setting.getName());
        irr.CARD_TITLE.draw(drawContext, string, this.ibo + 12.0f + 16.0f, irr.CARD_TITLE.centerTop(this.ibp + 15.0f + 1.0f), iov.text);
        String string2 = this.setting.size() + wap.s(a.b("\ud9cd\ua02c\u2ae6\ub49d\u3f42\ub9fd\u03af", -167650838), a.b("\u64c0\u1963\u93c9\u0dc2\u8664\u00a5\ubafb\u3309", -1317706520));
        irr.drawChip(drawContext, string2, this.ibo + 12.0f + 16.0f + irr.CARD_TITLE.width(string) + 8.0f + Math.max(16.0f, irr.SMALL.width(string2) + 9.0f), this.ibp + 15.0f + 1.0f, iov.textDim, iov.stroke, 0.0f);
        float f11 = 16.0f;
        float f12 = this.ibo + 430.0f - 12.0f - f11;
        float f13 = this.ibp + (30.0f - f11) * 0.5f + 1.0f;
        float f14 = this.ibt.step(bl && irr.inside(f, f2, f12, f13, f11, f11), f3);
        irr.iconButton(drawContext, vhz.CLOSE, f12, f13, f11, f14, false, 1.0f);
        float f15 = this.ibp + 30.0f + 2.0f;
        this.search.x = this.ibo + 12.0f;
        this.search.y = f15 + 3.0f;
        this.search.w = 170.0f;
        this.search.h = 16.0f;
        this.search.render(drawContext, hlc2, f, f2, f3);
        float f16 = this.search.x + this.search.w + 8.0f;
        String[] stringArray = new String[]{wap.s(a.c(-2047299948, "\uaed6\ud74a\u5d99"), a.c(-856559916, "\ueac5\u9327\u1980")), wap.s(a.d("\ufc71\u85f6\u0f2c\u9154\u1a85\u9c23\u2661\uaf91", 212294413, 1885579047), a.b("\uf712\u8efa\u0453\u9a53\u11f4\u9748\u2d1b\ua49c\u3abd", 1180889865))};
        float f17 = 128.0f;
        float f18 = 16.0f;
        float f19 = f15 + (22.0f - f18) * 0.5f;
        uut.round(drawContext, f16, f19, f17, f18, iov.r(5.0f), iov.field);
        float f20 = f17 * 0.5f;
        float f21 = this.ibv ? f20 : 0.0f;
        uut.round(drawContext, f16 + f21 + 1.5f, f19 + 1.5f, f20 - 3.0f, f18 - 3.0f, iov.r(4.0f), iov.accent(60));
        for (int i = 0; i < 2; ++i) {
            boolean bl2 = i == 1 == this.ibv;
            f6 = this.ibs[i].step(bl && irr.inside(f, f2, f16 + (float)i * f20, f19, f20, f18), f3);
            irr.VALUE.drawCentered(drawContext, stringArray[i], f16 + (float)i * f20 + f20 * 0.5f, irr.VALUE.centerTop(f19 + f18 * 0.5f), bl2 ? iov.text : ujt.lerp(iov.textMuted, iov.textDim, f6));
        }
        float f22 = (this.ibo + 430.0f - 12.0f - (f16 + f17 + 8.0f) - 6.0f) * 0.5f;
        float f23 = f16 + f17 + 8.0f;
        f6 = f23 + f22 + 6.0f;
        irr.secondaryButton(drawContext, wap.s(a.c(1186083138, "\u3104\u489a\uc240\u5c35\ud7f1"), a.c(770587570, "\u3fa4\u464c\ucce0\u52e8\ud93c\u5ff7\ue5de\u6c21")), vhz.TRASH, f23, f19, f22, f18, this.ibs[2].step(bl && irr.inside(f, f2, f23, f19, f22, f18), f3), 0.0f);
        irr.secondaryButton(drawContext, wap.s(a.d("\udb89\ua20f\u28ca\ub6ad\u3d6b", 300393715, -1186103507), a.c(1302542582, "\u3cd2\u4573\ucfd1\u51de\uda76")), vhz.RESET, f6, f19, f22, f18, this.ibs[3].step(bl && irr.inside(f, f2, f6, f19, f22, f18), f3), 0.0f);
        this.ics(drawContext, f, f2, f3, bl);
        float f24 = this.ibp + 318.0f - 8.0f - 5.0f;
        uut.rect(drawContext, this.ibo + 12.0f, this.ibp + 318.0f - 16.0f - 8.0f, 406.0f, 1.0f, iov.divider);
        if (this.iby != null) {
            irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(this.iby, 236.5f), this.ibo + 12.0f, irr.LABEL.centerTop(f24), iov.text);
            irr.SMALL.draw(drawContext, this.ibz, this.ibo + 430.0f - 12.0f - irr.SMALL.width(this.ibz), irr.SMALL.centerTop(f24), iov.textMuted);
        } else {
            String string3 = this.ibx.isEmpty() ? wap.s(a.d("\u17a9\u6e39\ue4f1\u7a9c\uf14a\u77fc\ucda6\u4410\uda09\u50b1\ud778\u2d12\ua3cf", 820329225, -1529598749), a.b("\u1b5b\u62cf\ue863\u7660\ufdb1\u7b0d\uc540\u48ac\ud6fb\u585f\udb91\u21ed\uaf33\u368f\ubcdd\u3a24\u8068", -461103273)) : wap.s(a.c(-488482956, "\u572c\u2eb2\ua464\u3a1f\ub1c0\u373a\u8d3d\u04d7\u9ac7\u1037\u97e1\u6d90\ue303\u7afd\uf0b3\u7610\ucc0d\u43cb\ud970\u5f23\ud6cd\uac8f\u2279\ub9a8\u3f40\ub506\u0cb5"), a.b("\u7df2\u0462\u8eb2\u10c1\u9f0c\u3989\ua3ee\u2e0b\ub05e\u3ae0\ubd32\u4741\uc99c\u5057\uda0a\u5897\ue6c0\u6912\uf3a2\u71eb\ufc7f\u865c\u089e\u933f\u1532\u9fed\u2232\uac63\u3603\ub0c5\u3b76", 1206352375)) + this.ibx.size() + wap.s(a.c(-1919566204, "\ubea2\uc740\u4d88\ud3fe\u5831\ude99"), a.c(-278559244, "\u85dd\uf873\u72a1\uecd4\u6709\ue1bf\u5beb\ud217\u4c4b"));
            irr.SMALL.draw(drawContext, string3, this.ibo + 12.0f, irr.SMALL.centerTop(f24), iov.textMuted);
        }
        drawContext.getMatrices().popMatrix();
        uut.popAlpha();
    }

    private void ics(DrawContext drawContext, float f, float f2, float f3, boolean bl) {
        float f4 = this.ich();
        float f5 = this.ici();
        float f6 = this.icj();
        float f7 = this.ick();
        float f8 = this.ibr.step(Math.max(0.0f, Math.min(this.ibu, this.icr())), f3);
        int n = this.icm();
        float f9 = this.icp();
        this.iby = null;
        this.ibz = null;
        int n2 = -1;
        uut.pushScissor(drawContext, f4 - 2.0f, f5 - 2.0f, f6 + 4.0f, f7 + 4.0f);
        float f10 = this.icn();
        float f11 = this.ico();
        boolean bl2 = this.icl();
        int n3 = Math.max(0, (int)(f8 / (f11 + 3.0f)));
        int n4 = (int)((f8 + f7) / (f11 + 3.0f)) + 1;
        float f12 = iov.r(5.0f);
        for (int i = n3; i <= n4; ++i) {
            int n5;
            for (int j = 0; j < n && (n5 = i * n + j) < this.ibx.size(); ++j) {
                float f13;
                float f14;
                iay iay2 = this.ibx.get(n5);
                float f15 = f4 + (float)j * f9;
                float f16 = f5 + (float)i * (f11 + 3.0f) - f8;
                boolean bl3 = bl && irr.inside(f, f2, f15, f16, f10, f11) && irr.inside(f, f2, f4, f5, f6, f7);
                boolean bl4 = this.setting.contains(iay2.iaz);
                float f17 = 0.0f;
                if (bl3) {
                    n2 = n5;
                    this.iby = iay2.ibb;
                    this.ibz = iay2.iaz;
                    f17 = bl2 ? 0.0f : this.icb.get();
                }
                int n6 = bl4 ? ujt.lerp(iov.field, iov.accent(), 0.28f) : iov.field;
                uut.round(drawContext, f15, f16 - f17, f10, f11, f12, bl3 ? ujt.lerp(n6, iov.fieldHover, 0.6f) : n6);
                if (bl4) {
                    uut.outline(drawContext, f15, f16 - f17, f10, f11, f12, 1.0f, iov.accent(200));
                }
                drawContext.getMatrices().pushMatrix();
                drawContext.getMatrices().translate(f15 + (bl2 ? 2.0f : 3.0f), f16 + (f11 - 16.0f) * 0.5f - f17);
                drawContext.drawItem(iay2.iba, 0, 0);
                drawContext.getMatrices().popMatrix();
                if (bl2) {
                    f14 = f15 + 21.0f;
                    f13 = f10 - 21.0f - (bl4 ? 14.0f : 4.0f);
                    irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(iay2.ibb, f13), f14, irr.LABEL.centerTop(f16 + f11 * 0.5f), bl4 ? iov.text : iov.textDim);
                }
                if (!bl4) continue;
                f14 = bl2 ? f15 + f10 - 7.0f : f15 + 22.0f - 3.5f;
                f13 = bl2 ? f16 + f11 * 0.5f : f16 + 3.5f - f17;
                uut.circle(drawContext, f14, f13, 3.0f, iov.accent());
                vjf.draw(drawContext, vhz.CHECK, f14, f13, 4.5f, iov.onAccent());
            }
        }
        uut.popScissor(drawContext);
        if (n2 != this.ica) {
            this.ica = n2;
            this.icb.set(0.0f);
        }
        this.icb.step(n2 >= 0 ? 1.5f : 0.0f, f3);
        float f18 = this.icr();
        if (f18 > 0.0f) {
            float f19 = Math.max(18.0f, f7 * f7 / this.icq());
            float f20 = f5 + (f7 - f19) * (f8 / f18);
            uut.round(drawContext, f4 + f6 + 4.0f, f20, 2.5f, f19, 1.25f, ujt.withAlpha(iov.textMuted, 110));
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (this.ibw) {
            return true;
        }
        if (!this.contains(f, f2)) {
            this.close();
            return true;
        }
        float f3 = 16.0f;
        if (n == 0 && irr.inside(f, f2, this.ibo + 430.0f - 12.0f - f3, this.ibp + (30.0f - f3) * 0.5f + 1.0f, f3, f3)) {
            this.close();
            return true;
        }
        if (this.search.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        hlc2.focus(null);
        float f4 = this.ibp + 30.0f + 2.0f;
        float f5 = this.search.x + this.search.w + 8.0f;
        float f6 = 128.0f;
        float f7 = f4 + 3.0f;
        if (n == 0 && irr.inside(f, f2, f5, f7, f6, 16.0f)) {
            this.ibv = f >= f5 + f6 * 0.5f;
            this.ibu = 0.0f;
            this.icg();
            return true;
        }
        float f8 = (this.ibo + 430.0f - 12.0f - (f5 + f6 + 8.0f) - 6.0f) * 0.5f;
        float f9 = f5 + f6 + 8.0f;
        if (n == 0 && irr.inside(f, f2, f9, f7, f8, 16.0f)) {
            this.setting.clear();
            this.icg();
            hlc2.toast(wap.s(a.d("\ube74\uc7e0\u4d29\ud35f\u58dc\ude2e\u6472\ued8a\u73d1\uf973\u7eb7\u84c7", -2126027166, -1186277290), a.b("\u7672\u0fdd\u8509\u1b01\u90a9\u161c\ua855\u25ba\ubb9c\u3152\ub6f0\u4cfd\uc222", -1979026850)), vhz.TRASH, false);
            return true;
        }
        if (n == 0 && irr.inside(f, f2, f9 + f8 + 6.0f, f7, f8, 16.0f)) {
            this.setting.reset();
            this.icg();
            hlc2.toast(wap.s(a.c(-492904007, "\ue1e3\u9871\u12a0\u8cd9\u0745\u81a0\u3be8\ub256\u2c5d\ua6f0\u212e\udb1a\u5589\ucc39\u4669\uc09f\u7ac4\uf50c\u6fa7\ue9a2\u6019\u1a4d\u94e4\u0f32"), a.b("\u809f\uf909\u73af\ueda3\u660a\ue0c3\u5a93\ud77a\u4d44\uc78b\u405f\uba57\u34ff\uad4a\u2303\ua1ed\u1ba3\u906c\u0ebc\u8892\u0167\u7b33\uf5fc\u6e5a\ue828\u62fc\udb39", -107510634)), vhz.RESET, false);
            return true;
        }
        if (n == 0 && irr.inside(f, f2, this.ich(), this.ici(), this.icj(), this.ick()) && this.ica >= 0 && this.ica < this.ibx.size()) {
            iay iay2 = this.ibx.get(this.ica);
            this.setting.toggle(iay2.iaz);
            if (this.ibv && !this.setting.contains(iay2.iaz)) {
                this.icg();
            }
            return true;
        }
        return true;
    }

    @Override
    void scrolled(double d) {
        this.ibu = Math.max(0.0f, Math.min(this.icr(), this.ibu - (float)d * (this.ico() + 3.0f) * 2.0f));
    }

    @Override
    boolean keyPressed(hlc hlc2, int n, int n2) {
        boolean bl;
        if (n == 256) {
            if (hlc2.focusedField() == this.search && !this.search.text.isEmpty()) {
                this.search.setText("");
            } else {
                this.close();
            }
            return true;
        }
        if (hlc2.focusedField() == this.search) {
            this.search.keyPressed(hlc2, n, n2);
            return true;
        }
        boolean bl2 = bl = (n2 & 2) != 0;
        if (bl && n == 70) {
            hlc2.focus(this.search);
        }
        return true;
    }

    static String idPath(String string) {
        return string.toLowerCase(Locale.ROOT).startsWith(a.c(-1261067002, "\ua561\udcd4\u5600\uc87a\u43ab\uc50b\u7f4b\uf6bd\u68f0\ue20f")) ? string.substring(10) : string;
    }

    private static /* synthetic */ int afc(int n, int n2) {
        return (n ^ n2) + -724482325;
    }

    private static /* synthetic */ int afd(int n, int n2) {
        return ibf.afc(n, n2) * n2;
    }

    private static /* synthetic */ int afe(int n, int n2) {
        return ibf.afc(n, n2) + n;
    }
}

