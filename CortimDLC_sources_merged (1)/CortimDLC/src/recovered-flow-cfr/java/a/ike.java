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
import a.ucd;
import a.ucg;
import a.ujt;
import a.ukf;
import a.uut;
import a.vcj;
import a.vdn;
import a.veo;
import a.vhz;
import a.wap;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class ike
extends imn {
    private static final vdn ikf = veo.bold(12.0f);
    private static final float ikg = 26.0f;
    private static final float ikh = 18.0f;
    private final vcj iki = new vcj(16.0f);
    private final vcj ikj = new vcj(16.0f);
    private final vcj ikk = new vcj(16.0f);
    private final vcj ikl = new vcj(6.0f);
    private int ikm = ucg.noticeSeq();
    private long ikn;
    private static /* synthetic */ boolean iko;
    private static /* synthetic */ boolean ikp;

    ike() {
        super(null);
    }

    @Override
    float height() {
        return 45.0f;
    }

    private float ikq() {
        return this.x + this.w - 6.0f - 36.0f - 3.0f;
    }

    private float ikr() {
        return this.x + this.w - 6.0f - 18.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        int n;
        if (ucg.noticeSeq() != this.ikm) {
            this.ikm = ucg.noticeSeq();
            if (ucg.notice() != null) {
                hlc2.toast(ucg.notice(), ucg.noticeError() ? vhz.INFO : vhz.FRIENDS, ucg.noticeError());
            }
        }
        float f4 = this.y + 4.0f;
        float f5 = iov.r(6.0f);
        boolean bl = hlc2.canHover() && irr.inside(f, f2, this.x, f4, this.ikq() - this.x - 4.0f, 26.0f);
        float f6 = this.ikk.step(bl, f3);
        uut.round(drawContext, this.x, f4, this.w, 26.0f, f5, ujt.lerp(iov.field, iov.fieldHover, f6));
        ukf.rim(drawContext, this.x, f4, this.w, 26.0f, f5, iov.lightness(), 0.6f);
        float f7 = f4 + 13.0f;
        String string = ucg.prettyCode();
        float f8 = this.ikl.step(0.0f, f3);
        irr.SMALL.draw(drawContext, wap.s(a.b("\ufee7\u8740\u0d89\u93ff\u185a\u9e88\u24d7\uad2d\u3373", 1099497143), a.b("\u357c\u4ccf\uc624\u5c5d\ud3b0\u5505\uef5c", -595644055)), this.x + 9.0f, irr.SMALL.centerTop(f7 - 6.0f), iov.textMuted);
        if (string != null) {
            ikf.drawTracked(drawContext, string, this.x + 9.0f, ikf.centerTop(f7 + 4.0f), ujt.lerp(iov.text, iov.accent() | 0xFF000000, Math.max(f8, f6 * 0.4f)), 1.2f);
        } else {
            ikf.drawTracked(drawContext, a.b("\u4141\u38f0\ub223\u0c6b\ua785\u2134\u9b67", -2034540206), this.x + 9.0f, ikf.centerTop(f7 + 4.0f), iov.textMuted, 1.2f);
        }
        if (f8 > 0.02f) {
            uut.pushAlpha(f8);
            irr.SMALL.draw(drawContext, wap.s(a.c(2107655129, "\u439c\u3a01\ub0cd\u2ea5\ua57e\u23ce"), a.d("\u4784\u3e2e\ub4f9\u2a89\ua159\u2790\u9dbd\u1440\u8a1d\u00a1\u8771", -1367118235, 1539124683)), this.x + 9.0f + ikf.width(string != null ? string : "") + 14.0f, irr.SMALL.centerTop(f7 + 4.0f), iov.accent() | 0xFF000000);
            uut.popAlpha();
        }
        boolean bl2 = string != null;
        boolean bl3 = hlc2.canHover() && irr.inside(f, f2, this.ikq(), f7 - 9.0f, 18.0f, 18.0f);
        boolean bl4 = hlc2.canHover() && irr.inside(f, f2, this.ikr(), f7 - 9.0f, 18.0f, 18.0f);
        boolean bl5 = System.currentTimeMillis() < this.ikn;
        irr.iconButton(drawContext, vhz.COPY, this.ikq(), f7 - 9.0f, 18.0f, this.iki.step(bl3, f3), false, bl2 ? 1.0f : 0.35f);
        irr.iconButton(drawContext, vhz.REFRESH, this.ikr(), f7 - 9.0f, 18.0f, this.ikj.step(bl4, f3), bl5, bl2 ? 1.0f : 0.35f);
        float f9 = f4 + 26.0f + 8.0f;
        if (hlc2.canHover() && irr.inside(f, f2, this.x, f9 - 5.0f, this.w, 10.0f) && ucg.fingerprint() != null) {
            hlc2.hint(wap.s(a.c(1620938509, "\u8f0c\uf68b\u7c42\ue234\u69b1\uef4b\u5516\udcfb\u42fd\uc80a\u4fd6\ub5a0\u3b7e\ua2cd\u2889\uae7a\u1437\u9bfd\u0149\u8702\u0eaf\u74f0\ufa25\u61c0\ue7a4\u6d79\ud4c1\u5a9a\uc07a\u4678\ucd98\u335f\ub910\u20a4\ua6be\u2c12\u9391\u19ae\u9f76\u06da\u8c89\uf22c\u782b\uff81\u6519\ueb31\u52f4\ud85f\u5e17\uc594\u4ba9\ub177\u38cc\ube95\u2439\uaa72\u118e\u9753\u1d22\u84ee\u0a48\u700a\uf7ee\u7dfa\ue37c\u6ad0\ud0d7\u5672\udc3e\u43c0\uc941\u4f37\ub6f1\u3c49\ua25f\u29e1\uafac\u151c\u9c9b\u02be\u8864\u0e39\u7597\ufb53\u6133\ue8f9\u6e4d\ud415"), a.d("\u74e0\u0d0d\u87a3\u19d8\u927d\u14bb\uae9a\u2717\ub94c\u37e7\ub426\u4e55\uc0fa\u5936\ud363\u559f\uebce\u6005\ufab7\u7c93\uf56d\u8f4b\u05e6\u9e39\u1c72\u96f7\u2f47\ua162\u3bee\ubdbc\u3260\uc8a3\u42e6\udb1b\u5d33\ud78f\u6c3a\ue25e\u648b\ufd37\u7376\u09e4\u87d4\u0477\u9ea2\u10ab\ua905\u23b2\ua5f0\u3a3f\ub051\u4a85\uc330\u456b\udb92\u55d9\uea07\u6ca5\ue6d1\u7f75\uf1ce\u8b91\u0c15\u825d\u1c9e\u9148\u2b1e\uad93\u27cb\ub800\u36b8\ub4d1\u4d77\uc7bd\u59ef\ud26b\u5435\ueefb\u6752\uf92d\u778e\uf5c0\u8e72\u00a9\u9ad6\u130e\u95b5\u2f9a", 657668333, 1755072587)));
        }
        if (bl3 || bl) {
            hlc2.hint(wap.s(a.b("\u7337\u0aaa\u8066\u1e1e\u9590\u1375\ua93a\u20c6\ubedc\u342e\ub3f1\u498b\uc75d\u5ea9\ud4bb\u5245\ue800\u6795\ufd75\u7b32\uf2ce\u8895\u0662\u9dfa\u1b98\u911d\u28fa\ua6b0\u3c08\uba18\u31ea\ucf7d\u4526\udccc\u5a93\ud029\u6ff4", 659125073), a.b("\ufa1c\u83b6\u0961\u9711\u1cc1\u9a08\u2025\ua9d8\u3785\ubd46\u3a9b\uc486\u4e4b\ud7fe\u5da7\udf42\u6115\ueadc\u7471\uf25c\u7bd6\u01f8\u8f3b\u14e8\u929d\u1836\ua18b\u2bb6\ub555\u3370\ub8c0\u4661\ucc5e", 1487797788)));
        } else if (bl4) {
            hlc2.hint(bl5 ? wap.s(a.d("\u3a68\u43f6\uc920\u575b\udc84\u5a7e\ue06c\u699b\uf7c2\u7d7b\ufaaf\u008a\u8e47\u17a2\u9ded\u1b11\ua11b\u2e85\ub435\u326c\ubbdf\uc1cd\u4f72\ud4a8\u52d6\ud842\u61a2\ueff4\u7518\uf356\u78e6\u8664\u0c7c\u9595\u13db\u9973\u26a6\uacd0\u2a0a", 172214578, 1700721470), a.c(532332127, "\uba6d\uc380\u494b\ud34b\u5cfc\uda3d\u6069\ued95\u73d0\ufd00\u7ad0\u80d3\u0e74\u97ce\u1def\u9f07\u2152\uae87\u343e\ub67b\u3b93\u41c8\ucf0e\u54aa\ud2a1\u5873\ue1b2\u6fee\uf511\u7337\ufce6\u0657\u8c68\u1598\u93c4\u1909\ua6ac\u2caf\uaa72")) : wap.s(a.c(-1388815468, "\u5bfe\u2264\ua8a5\u3683\ubd17\u3baa\u81f2\u0802\u9618\u1ca1\u9b2e\u6143\uef99\u766d\ufc71\u7a83\uc0c4\u4f51\ud5ad\u53fd\uda01\ua015\u2ef5\ub523\u3347\ub9899\u8e3b\u149b\u92d2\u197c\ue7b4\u6df9\uf40f\u7255\uf8aa"), a.c(-2016866094, "\u14e9\u6d7b\ue7a4\u79ac\uf209\u70a1\ucee8\u471d\ud948\u57ed\ud036\u2e2e\ua0fa\u3939\ub31a\u35e0\u8fdd\u0415\u9ab9\u1ce2\u9560\uef44\u6183\ufa51\u7c5c\uf680\u4f3b\uc11d\u5f88\uddb9\u567a\ua8aa\u22ea\ubb67\u3d46\ub785\u085c\u8648")));
        }
        float f10 = f4 + 26.0f + 8.0f;
        String string2 = switch (ucg.status()) {
            case ucd.ONLINE -> {
                n = -11870592;
                yield (ucg.inParty() ? (ucg.secured() ? wap.s(a.c(329191542, "\u1024\u69be\ue360\u7d00\uf6dc\u7064\uca33\u43d3\udd8d\u5778\ud0ab\u2a4d\ua40d\u3dbc\ub7bf\u315f\u8b03\u04d4\u9e6a\u1862\u91da\ueb82\u6577"), a.b("\u44a6\u3d30\ub79b\u299a\ua231\u2484\u9ea9\u1754\u8909\u03b5\u8465\u7a0a\uf4dd\u6dfb\ue73f\u61ce\udf93\u5450\ucafc\u4ca2\uc527\ubf0c\u35a7", 1541030054)) + ucg.members().size() : wap.s(a.b("\ucc42\ub5c5\u3f1e\ua172\u2ab8\uac0e\u1654\u9fe2\u01fb\u8b43\u0c8d\uf6ae\u782d\ue180\u6bde\ued6a\u5775\ud8b5\u4215\uc442\u4db8\u37b0\ub948\u2297\ua4f4", 2016332812), a.d("\u7405\u0d96\u8720\u193c\u96f7\u145c\uae0e\u278a\ub9dc\u370a\ub4c6\u4eb8\uc01d\u59d6", -345066798, -1438137649))) : wap.s(a.d("\u9dc6\ue45b\u6e89\uf0f8\u7b24\ufd93\u47d7\uce37\u5069\uda9c\u5d4f\ua7a9\u29e9\ub058\u3a45\ubcb5\u06b5\u8934\u1396\u95d4\u1c25\u6679\ue893\u731b\uf578\u7fb8", 266591093, 852772586), a.b("\u541a\u2d8a\ua753\u392c\ub2fa\u343e\u8e64\u07e7\u99b0\u1302\u90cf\u6abe\ue4fe\u7dd8\uf78b\u7565\ucf25\u4086\uda4f\u5806\ud5ee\uafbe\u2109\ubad2\u38bd\ub671\u0fca\u81ec", 1211256857))) + wap.s(a.d("\u894c\uf0fd\u7ab9\ue45f\u6f88\ue972\u532f\udac2\u44c4", -778606602, -1728385389), a.b("\ufe1d\u87ac\u0de8\u930e\u18d9\u9a72\u2020\ua9a4\u37f2\ub924", -1003291081)) + ucg.fingerprint();
            }
            case ucd.CONNECTING -> {
                n = -340971;
                yield wap.s(a.b("\ue5d9\u9c44\u1696\u88e7\u033b\u858c\u3fc8\ub624\u287c\ua2c4\u0556", 950068625), a.d("\uc742\ubed2\u340b\uaa74\u21a2\ua766\u1d3c\u94bf\u0ae8\u805c\u0782\ud9e0", -841583106, 1251391151));
            }
            case ucd.RETRY -> {
                n = -429290;
                yield wap.s(a.b("\u4276\u3be6\ub17a\u2f48\ua493\u2223\u9870\u118a\u8fd3\u0575\u82bb\u78cc\uf61a\u6fe9\ue5b6\u6315\ud94d\u568d\ucc38\u4a62\uc385\ub9d3\u3769", 1528381999), a.b("\uf890\u8109\u0bad\u91be\u1e08\u98ca\u22e4\uab6d\u353d\ubb98\u3c47\uc229\u4cff\ud542\u5f61\ud9ec\u63dd", -1800602468)) + (ucg.lastError() != null ? a.c(1511940016, "\u5f95\u2624\uac60\u3286\ub951") + ucg.lastError() : "");
            }
            case ucd.REPLACED -> {
                n = -429290;
                yield wap.s(a.b("\u5548\u2cd5\ua607\u3876\ub3aa\u351d\u8f59\u06b9\u98e7\u1212\u9587\u6fe2\ue128\u789b\uf285\u7435\uce75\u41a5\udb0d\u5d40\ud4ba\uaefc\u201d\ubb8b\u3df2\ub72f\u0e94", -370584304), a.c(80172220, "\u50ba\u292a\ua3f3\u3d8c\ub65a\u309e\u8ac4\u0347\u9d10\u17a2\u946f\u6a06\ue4de\u7978\uf73f\u71ba\ucbf6\u4457\udee9\u58bf\ud551\uab18\u25a0\ube02\u3876"));
            }
            case ucd.NO_SERVER -> {
                n = iov.textMuted;
                yield wap.s(a.d("\u3ff2\u4675\uccb7\u5292\ud911\u5fbc\ue5e2\u6c56\uf259\u78f9\uff39\u054e\u8b94\u127c\u987c\u1e9b\ua4c3\u2b16\ub1b6\u37f0\ube55\uc446\u4af2\ud12a\u5756\udd9f", 50517084, -1884886041), a.b("\uc6af\ubf07\u35de\uaba9\u2070\ua6bb\u1c9f\u917b\u0b45\u8180\u0626\ufc25\u72f5\ueb31\u6502\ue7ec\u5dac\ud20f\u48c6\uca8f\u4765\u3d31\ub38c\u285e", 1739375252));
            }
            default -> {
                n = iov.textMuted;
                yield wap.s(a.b("\u329b\u4b1b\uc1db\u5fac\ud476\u529e\ue884\u616f\uff63\u759d\uf247\u0836", 1719415495), a.d("\u1b28\u62b6\ue817\u761c\uf9d3\u7b70\uc15a\u48da\ud684\u5c40\udb9a\u2199\uaf46\u36f4", -156887285, 1135675442));
            }
        };
        uut.circle(drawContext, this.x + 3.0f, f10, 1.8f, n);
        irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string2, this.w - 12.0f), this.x + 8.0f, irr.SMALL.centerTop(f10), iov.textDim);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        float f3 = this.y + 4.0f + 13.0f;
        String string = ucg.prettyCode();
        if (irr.inside(f, f2, this.ikr(), f3 - 9.0f, 18.0f, 18.0f)) {
            if (string == null) {
                return true;
            }
            if (System.currentTimeMillis() < this.ikn) {
                this.ikn = 0L;
                ucg.newCode();
            } else {
                this.ikn = System.currentTimeMillis() + 2500L;
            }
            return true;
        }
        if (irr.inside(f, f2, this.x, this.y + 4.0f, this.ikr() - this.x - 2.0f, 26.0f)) {
            if (string == null) {
                hlc2.toast(wap.s(a.c(-1684667425, "\u038b\u7a1b\uf087\u6eb5\ue56e\u63d4\ud986\u5032\uce34\u4499\uc35b\u3964\ub7a9\u2e56\ua404\u22ee\u98f5\u1767\u8dd8\u0b88\u827f\uf825\u7690\ued56\u6b38\ue1e8"), a.d("\u7961\u00f4\u8a2d\u1458\u9b9f\u1931\ua363\u2a96\ub4c3\u3a62\ub9ac\u43d5\ucd75\u50bc\udaf5\u5819\ue25e\u6df8\uf329\u7119\uf89d\u82b1\u0c7a\u97a4", -1722530915, -1382400258)), vhz.INFO, true);
                return true;
            }
            MinecraftClient.getInstance().keyboard.setClipboard(string);
            this.ikl.set(1.0f);
            hlc2.toast(wap.s(a.b("\u95b2\uec2f\u66f7\uf887\u7315\uf5e7\u4fb8\uc656\u5810\ud2ad\u557f\uaf50\u219d", -401631748), a.c(725901426, "\u6478\u1ded\u9734\u0d51\u82e7\u042d\ube7a\u378a\ua9d2\u231b\ua4b6\u5ecb\ud01e\u49a2\uc7f6\u411d")) + string, vhz.COPY, false);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int agw(int n, int n2) {
        return n ^ n2 ^ 0xB6EA6526;
    }
}

