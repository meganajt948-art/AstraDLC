/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.imn;
import a.iov;
import a.irr;
import a.iui;
import a.ivh;
import a.ujt;
import a.uut;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import a.wkq;
import a.wkw;
import a.wlk;
import flow.dev.a;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class ivk
extends imn {
    private static final float ivl = 30.0f;
    private static final float ivm = 3.0f;
    private static final float ivn = 18.0f;
    private final iui ivo;
    private final Map<wkq, ivh> ivp = new IdentityHashMap<wkq, ivh>();
    private wkq ivq;
    private long ivr;
    private static /* synthetic */ int ivs;
    private static /* synthetic */ long ivt;

    ivk(iui iui2) {
        super(null);
        this.ivo = iui2;
    }

    @Override
    float height() {
        int n = wlk.inWorld().size();
        return n == 0 ? 58.0f : 2.0f + (float)n * 33.0f;
    }

    private float ivu(int n) {
        return this.y + 2.0f + (float)n * 33.0f;
    }

    private float ivv(int n) {
        return this.x + this.w - 6.0f - (float)(3 - n) * 21.0f + 3.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<wkq> list = wlk.inWorld();
        this.ivp.keySet().retainAll(list);
        if (list.isEmpty()) {
            float f4 = this.x + this.w * 0.5f;
            uut.circle(drawContext, f4, this.y + 17.0f, 12.0f, iov.hover);
            vjf.draw(drawContext, vhz.PIN, f4, this.y + 17.0f, 11.0f, iov.textMuted);
            irr.LABEL.drawCentered(drawContext, wap.s(a.b("\udf20\ua6b0\u2c2c\ub20a\u39cb\ubf62\u0538\u8cd6\u128f\u9839\u1ff0\ue586\u6b02\uf2ea\u78a5\ufe45", -823861378), a.b("\u31e1\u4879\uc2dd\u5cd0\ud703\u55a8\uebe4\u6214\ufc4f\u76f4\uf537\u0b5b\u8584\u1c42", -1351862797)), f4, irr.LABEL.centerTop(this.y + 38.0f), iov.textDim);
            irr.SMALL.drawCentered(drawContext, wap.s(a.d("\u08c9\u715d\ufb8e\u65bb\uee23\u6893\ud2cb\u5b7f\uc577\u4fd8\uc816\u327b\ubce4\u2501\uaf4e\u29b2\u93b8\u1c2f\u8695\u00d9\u8931\uf32d\u7dd1\ue601\u6030\ueab5\u531a\udd46\u47f4\uc1e9\u4a53\ub481\u3edc", 1899867577, -188635888), a.b("\u8aac\uf337\u79eb\ue79b\u6c4e\uea81\u50dc\ud95a\u4310\ucdc6\u4a67\ub063\u3ec1\ua772\u2936\uaba3\u1196\u9e39\u04f6\u82d8\u0f4c\u717c\uffb5\u646a\ue212\u68c1", -1888842078)), f4, irr.SMALL.centerTop(this.y + 49.0f), iov.textMuted);
            return;
        }
        if (this.ivq != null && System.currentTimeMillis() > this.ivr) {
            this.ivq = null;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        String string = wlk.dimensionId();
        float f5 = iov.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            wkq wkq3;
            boolean bl;
            wkq wkq4 = list.get(i);
            ivh ivh2 = this.ivp.computeIfAbsent(wkq4, wkq2 -> new ivh());
            float f6 = this.ivu(i);
            float f7 = vcq.outCubic(ivh2.appear.step(1.0f, f3));
            boolean bl2 = hlc2.canHover() && irr.inside(f, f2, this.x, f6, this.w, 30.0f);
            float f8 = ivh2.hover.step(bl2, f3);
            float f9 = ivh2.shown.step(wkq4.visible, f3);
            int n = wlk.colorOf(wkq4);
            uut.pushAlpha(f7 * (0.5f + 0.5f * f9));
            drawContext.getMatrices().pushMatrix();
            drawContext.getMatrices().translate((1.0f - f7) * 18.0f, 0.0f);
            uut.round(drawContext, this.x, f6, this.w, 30.0f, f5, ujt.withAlpha(iov.hover, (int)((float)ujt.alpha(iov.hover) * (0.6f + 1.4f * f8))));
            float f10 = f6 + 15.0f;
            wkw.pin(drawContext, this.x + 12.0f, f10 - 0.8f * f8, 15.0f, n, 0.5f + 0.5f * f8);
            float f11 = this.x + 24.0f;
            float f12 = this.ivv(0) - f11 - 6.0f;
            irr.CARD_TITLE.draw(drawContext, irr.CARD_TITLE.ellipsize(wkq4.name, f12), f11, irr.CARD_TITLE.centerTop(f10 - 4.5f), iov.text);
            String string2 = (int)Math.floor(wkq4.x) + a.b("\uf4c0\u8d71", 738063586) + (int)Math.floor(wkq4.y) + a.d("\ub6d5\ucf64", 2006775910, 1945194129) + (int)Math.floor(wkq4.z);
            boolean bl3 = bl = string != null && string.equals(wkq4.dimension);
            if (!bl) {
                string2 = string2 + a.c(813644720, "\u3b95\u4224\uc860\u5686\udd51") + wlk.dimensionName(wkq4.dimension);
            }
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string2, f12), f11, irr.SMALL.centerTop(f10 + 5.5f), iov.textMuted);
            wkq wkq5 = wkq3 = bl ? wkq4 : wlk.here(wkq4);
            if (f8 < 0.99f && wkq3 != null && minecraftClient.player != null) {
                double d = Math.sqrt(minecraftClient.player.squaredDistanceTo(wkq3.cx(), wkq3.cy(), wkq3.cz()));
                uut.pushAlpha(1.0f - f8);
                irr.drawChip(drawContext, wkw.formatDistance(d), this.x + this.w - 6.0f + f8 * 6.0f, f10, ujt.lerp(n, iov.text, 0.5f), ujt.withAlpha(n, 90), 0.0f);
                uut.popAlpha();
            }
            vhz[] vhzArray = new vhz[]{wkq4.visible ? vhz.RENDER : vhz.EYE_OFF, vhz.PENCIL, vhz.TRASH};
            String[] stringArray = new String[]{wkq4.visible ? wap.s(a.c(996516290, "\ua199\ud809\u52d7\ucca7\u4735\uc1c2\u7b85\uf269\u6c34\ue6c8\u614f\u9b22\u15f8\u8c0c\u0608\u80e1\u3ab3\ub57c\u2fc7"), a.b("\u163d\u6f97\ue53e\u7b44\uf09a\u7625\uc81a\u45f9\udfb4\u5119\ud6ce\u2cc7\ua265", 1688015377)) : wap.s(a.c(1212135405, "\ub7af\uce25\u44f1\uda98\u5118\ud7e0\u6db4\ue40b\u7a00\uf0ad\u7773\u8d47\u03c7\u9a6e\u1020\u96cf\u2c88"), a.b("\uafaa\ud63a\u5ced\uc296\u4946\ucff0\u75d1\ufc2e\u661d\ue8be\u6b7f\u9512\u1bc1\u8208\u082e", 1342090170)), wap.s(a.c(-1421312624, "\u7dc5\u0455\u8e8b\u10e7\u9b64\u1d9c\ua7c8\u2e77\ub07c\u3ad1\ubd0f\u473b\uc9aa\u5012\uda5c\u5cb2"), a.c(-546415474, "\u5886\u2118\uabc0\u35b8\ube67\u38d3\u82fa\u0b05\u9136\u1f95\u9c54\u6241\uecec\u7523\uff0c\u79f4")), wap.s(a.c(-1456040334, "\u9629\uefb9\u6563\ufb1b\u70dd\uf67d\u4c6b\uc592\u5b86\ud138\u56ee\uac95\u224a\ubbb0\u31a2\ub755\u0d1c\u82c5\u1871\u9e6e\u17cd\u6d87\ue37b\u78e9\ufe9a\u744a\ucdf1\u43af\ud943\u5f0d\ud4fa"), a.c(-2070238671, "\uae39\ud79f\u5d48\uc332\u48e6\uce2d\u7470\uf9ed\u67ba\ue91e\u6ec0\u94b7\u1a6a\u83df\u09f6\u8f70\u312a\ubaee\u2021\ua668\u2bee\u55df\udb1c\u40ca\uc2a2\u4c67\uf5db\u7bfe\ue566\u6728\uec9a\u1241\u9878\u01f9\u87ad\u0d69\ub2c8\u38bb\ube69\u27d0\uad8a\ud30c\u5d39"))};
            for (int j = 0; j < 3; ++j) {
                float f13 = this.ivv(j) + (1.0f - f8) * 6.0f;
                float f14 = f10 - 9.0f;
                boolean bl4 = hlc2.canHover() && irr.inside(f, f2, f13, f14, 18.0f, 18.0f);
                float f15 = ivh2.buttons[j].step(bl4, f3);
                boolean bl5 = j == 2 && wkq4 == this.ivq;
                irr.iconButton(drawContext, vhzArray[j], f13, f14, 18.0f, f15, bl5, bl5 ? 1.0f : f8);
                if (!bl4 || !(f8 > 0.5f)) continue;
                hlc2.hint(bl5 ? wap.s(a.b("\ud9c3\ua05d\u2a8b\ub4f0\u3f2f\ub9d5\u03c7\u8a30\u1469\u9ed0\u1904\ue33b\u6db8\uf412\u7e0e\uf8bb\u42f5\ucd2d\u5797\ud1d7\u5831\u2225\u8caa", -1241327209) + wkq4.name + a.c(533813574, "\u795a"), a.d("\uc7b0\ube2c\u34f9\uaa82\u2151\ua79a\u1dbe\u905a\u0a10\u80dd\u0716\uf916\u73a1\uea60\u6034\ue2de\u589d\ud32b\u499d\ucfb0\u4648\u3c63\ub6bb\u2909\uaf01\u25d4\u9c6c\u123e\u88b3\u0eec\u8133\u7f69", 1614911967, 1155881554) + wkq4.name + a.d("\u0aa2", -1919796334, -760401526)) : stringArray[j]);
            }
            drawContext.getMatrices().popMatrix();
            uut.popAlpha();
        }
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        List<wkq> list = wlk.inWorld();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.ivu(i);
            if (!irr.inside(f, f2, this.x, f3, this.w, 30.0f)) continue;
            wkq wkq2 = list.get(i);
            float f4 = f3 + 15.0f;
            for (int j = 0; j < 3; ++j) {
                if (n != 0 || !irr.inside(f, f2, this.ivv(j), f4 - 9.0f, 18.0f, 18.0f)) continue;
                switch (j) {
                    case 0: {
                        wkq2.visible = !wkq2.visible;
                        wlk.changed();
                        break;
                    }
                    case 1: {
                        this.ivo.edit(wkq2);
                        break;
                    }
                    default: {
                        if (wkq2 != this.ivq) {
                            this.ivq = wkq2;
                            this.ivr = System.currentTimeMillis() + 2500L;
                            break;
                        }
                        this.ivq = null;
                        wlk.remove(wkq2);
                        hlc2.toast(wap.s(a.d("\u077c\u7eec\uf436\u6a4e\ue188\u6728\udd7a\u54cf\ueaac", -1332382556, -163220587) + wkq2.name + a.c(-28143291, "\ub159"), a.c(981076501, "\u0e3f\u7799\ufd4e\u6334\ue8ed\u6e54\ud40a\u59eb\uc73f") + wkq2.name + a.d("\u531b", 409985954, 1701818371)), vhz.TRASH, false);
                    }
                }
                return true;
            }
            if (n == 0) {
                this.ivo.edit(wkq2);
            }
            return true;
        }
        return false;
    }

    private static /* synthetic */ int akj(int n, int n2) {
        return n + n2 ^ 0x450BF302;
    }

    private static /* synthetic */ int akk(int n, int n2) {
        return ivk.akj(n, n2) + n;
    }
}

