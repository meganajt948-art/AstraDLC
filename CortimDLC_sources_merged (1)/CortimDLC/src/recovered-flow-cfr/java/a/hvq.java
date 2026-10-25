/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import a.hlc;
import a.hur;
import a.hvn;
import a.imn;
import a.iov;
import a.irr;
import a.ujt;
import a.uut;
import a.vcq;
import a.vhz;
import a.vjf;
import a.wap;
import flow.config.ConfigManager;
import flow.config.ConfigShare;
import flow.dev.a;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

final class hvq
extends imn {
    private static final float hvr = 30.0f;
    private static final float hvs = 3.0f;
    private static final float hvt = 18.0f;
    private static final vhz[] hvu = new vhz[]{vhz.DOWNLOAD, vhz.SAVE, vhz.PENCIL, vhz.SHARE, vhz.TRASH};
    private static final int hvv = 3;
    private static final int hvw = 4;
    private static final SimpleDateFormat hvx = new SimpleDateFormat(a.d("\u32c5\u4b30\uc18e\u5fff\ud428\u52f8\ue8a7\u613e\uff61\u75a2\uf226\u0857", 1038541595, -666906186), Locale.ROOT);
    private static final SimpleDateFormat hvy = new SimpleDateFormat(a.d("\uf4c1\u8d34\u078a\u99fb\u122c\u94fc\u2ea3\ua73a\u3965\ub3a6\u3422\uce53", 1156223964, -2001901707), Locale.forLanguageTag(a.d("\uc94f\ub0f9", -107638558, 48650717)));
    private final hur hvz;
    private List<ConfigManager.Info> hwa = new ArrayList<ConfigManager.Info>();
    private Map<String, String> hwb = new HashMap<String, String>();
    private String hwc;
    private int hwd = -1;
    private long hwe;
    private final Map<String, hvn> hwf = new HashMap<String, hvn>();
    private String hwg;
    private long hwh;
    private static /* synthetic */ long hwi;
    private static /* synthetic */ int hwj;

    private static String hwk(int n, String string) {
        return switch (n) {
            case 0 -> wap.s(a.d("\ud680\uaf12\u25cf\ubbbb\u3028\ub6cd\u0c82\u8572\u1b37\u91d5\u1645\uec38\u62ee\ufb57\u710b\uf7f4", 2141701512, -1699409068), a.c(820253083, "\u1599\u6c0f\ue6df\u78dd\uf309\u75cc\ucf90\u461b\ud84a\u5697\ud529\u2f57\ua1fc\u3831\ub600\u34eb\u8ea0\u0172\u9bb8\u1d95\u9469"));
            case 1 -> wap.s(a.b("\u3da8\u4420\ucee0\u5086\udb54\u5de0\ue7a8\u6e44\uf00a\u7afe\ufd7a\u0715\u89df\u1072\u9a69\u1ccc\ua69f\u2943\ub3b5\u35a7\ubc46\uc610\u48a3\ud365\u5511\udfda\u663d\ue83f\u72de\uf49e\u7f2d\u81e1\u0ba9\u9251\u1416", -1458946620), a.b("\u956b\uecf0\u6656\uf852\u7387\uf531\u4f6d\uc69b\u58bd\ud27d\u55dc\uafa3\u2518\ub8cb\u32ef\ub411\u0e27\u81fc\u1b3e\u9d6b\u1498\u6ad1\ue07f\u7ba3\ufdad\u777f\ucece\u40e1\uda11\u5c43\ud7fa\u2927\ua36c", -1598713515));
            case 2 -> wap.s(a.d("\u7b9c\u021a\u88c2\u16bc\u9d67\u1bde\ua1c8\u286d\ub629\u3cd7\ubb50\u413d\ucfe7\u5613\udc0e\u5af0\ue0b3\u6f6a\uf59c\u7384\ufa74\u806b\u0e8c\u9541\u1333\u99a7\u2052\uae0c\u34f7\ub2af\u3914\uc781\u4d8f\ud47d\u5223\ud88b\u674f", 1874400341, 12808126), a.d("\uf217\u8b8c\u012a\u9f2e\u14f4\u9241\u281b\ua1e2\u3fbe\ub503\u32d2\uc8d1\u4608\udbd5\u5594\ud777\u6920\ue6f5\u7c35\ufe0b\u73e4\u09ba\u831e\u1cd0\u9aae\u107a\ua9bd\u2383\ubd66\u3b4e\ub0fe\u4e52", 1590920027, -639142541));
            case 3 -> {
                if (string != null) {
                    yield wap.s(a.c(-1376058180, "\u04fa\u7d67\uf7bf\u69cf\ue25d") + string + a.b("\ua39c\uda37\u50a7\uceda\u4512\uc3aa\u79a0\uf018\u6e5a\ue4bf\u632d\u9953\u178e\u8e7b\u047b\u829c\u38d8\ub703\u2df4\uabec\u2206\u5803\ud6e4\u4d2e\ucb1e\u418e\uf87c\u766b\uec88\u6ac2\ue17d\u1fa7\u95e2", 963158919), a.b("\u55e6\u2c73\ua6aa\u3ccf", -110800392) + string + a.b("\ue55d\u9cf6\u1244\u8c4e\u079d\u812d\u3b79\ub2f0\u2cd1\ua66c\u21bd\udbbe\u5567\uc8ba\u46f1\uc418\u7a49\uf5e4\u6f2a\ue904\u6083\u1ad0\u9469\u0fc2\u89b3\u070e\ubaa9\u348c\uae78\u2859\ua39a", -831527560));
                }
                yield wap.s(a.b("\u2e31\u57bb\udd61\u4303\uc8c3\u4e2d\uf464\u7dd2\ue38f\u692f\ueea8\u1498\u9a0e\u03fc\u89a3\u0f59\ub517\u3a83\ua076\u262e\uafc4\ud5c7\u5b35\uc0a5\u469c\ucc59\u75f1\ufbac\u6150\ue70b", 275721852), a.b("\uf36e\u8afe'\u9e57\u158e\u933c\u2915\ua0ea\u3eb8\ub407\u37a1\ucdca\u4702\udeb2\u54e4\ud26d\u6826\ue788\u7d41\ufb1e\u7685\u08ce\u8679\u1da2\u9fc9\u110c\ua8b0\u2695\ub80d\u3a48\ub18f\u4f5d\uc562\u5c90", -517343405));
            }
            default -> wap.s(a.c(236876979, "\u74e8\u0d78\u87a2\u19da\u921c\u14bc\uaeaa\u2753\ub947\u33f9\ub42f\u4e54\uc08b\u5971\ud363\u5594\uefdd\u6004\ufab0\u7caf\uf50c\u8f46\u01ba\u9a28\u1c5b\u968b\u2f30\ua16e\u3b82\ubdcc\u363b"), a.b("\u161f\u6fb9\ue56e\u7b14\uf0c0\u760b\ucc56\u41cb\udf9c\u5138\ud6e6\u2c91\ua24c\u3bf9\ub1d0\u3756\u890c\u02c8\u9807\u1e4e\u93c8\uedf9\u633a\uf8ec\u7a84\uf441\u4dfd\uc3d8\u5d40\udf0e\u54bc\uaa67\u205e\ub9df\u3f8b\ub54f\u0aee\u809d\u064f\u9ff6\u15ac\u6b2a\ue51f", -1462693353));
        };
    }

    hvq(hur hur2) {
        super(null);
        this.hvz = hur2;
    }

    private List<ConfigManager.Info> hwl() {
        long l = System.currentTimeMillis();
        if (this.hwd != ConfigManager.version() || l - this.hwe > 1500L) {
            this.hwd = ConfigManager.version();
            this.hwe = l;
            this.hwa = ConfigManager.list();
            this.hwb = ConfigShare.codes();
        }
        return this.hwa;
    }

    @Override
    float height() {
        int n = this.hwl().size();
        return n == 0 ? 58.0f : 2.0f + (float)n * 33.0f;
    }

    private float hwm(int n) {
        return this.y + 2.0f + (float)n * 33.0f;
    }

    private float hwn(int n) {
        return this.x + this.w - 8.0f - (float)(hvu.length - n) * 22.0f + 4.0f;
    }

    @Override
    void render(DrawContext drawContext, hlc hlc2, float f, float f2, float f3) {
        List<ConfigManager.Info> list = this.hwl();
        if (list.isEmpty()) {
            this.hwo(drawContext);
            return;
        }
        if (this.hwg != null && System.currentTimeMillis() > this.hwh) {
            this.hwg = null;
        }
        String string2 = ConfigManager.active();
        float f4 = iov.r(6.0f);
        for (int i = 0; i < list.size(); ++i) {
            ConfigManager.Info info = list.get(i);
            hvn hvn2 = this.hwf.computeIfAbsent(info.name(), string -> new hvn());
            float f5 = this.hwm(i);
            float f6 = vcq.outCubic(hvn2.appear.step(1.0f, f3));
            boolean bl = hlc2.canHover() && irr.inside(f, f2, this.x, f5, this.w, 30.0f);
            float f7 = hvn2.hover.step(bl, f3);
            boolean bl2 = info.name().equals(string2);
            uut.pushAlpha(f6);
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate((1.0f - f6) * 18.0f, 0.0f);
            int n = bl2 ? iov.accent(26) : ujt.withAlpha(iov.hover, (int)((float)ujt.alpha(iov.hover) * (0.6f + 1.4f * f7)));
            uut.round(drawContext, this.x, f5, this.w, 30.0f, f4, n);
            if (bl2 || f7 > 0.01f) {
                uut.outline(drawContext, this.x, f5, this.w, 30.0f, f4, 1.0f, bl2 ? iov.accent(110) : ujt.withAlpha(iov.stroke, (int)((float)ujt.alpha(iov.stroke) * f7)));
            }
            float f8 = this.x + 15.0f;
            float f9 = f5 + 15.0f;
            if (bl2) {
                uut.shadow(drawContext, f8 - 9.0f, f9 - 9.0f, 18.0f, 18.0f, 9.0f, 5.0f, iov.accent(80));
                uut.gradient(drawContext, f8 - 9.0f, f9 - 9.0f, 18.0f, 18.0f, 9.0f, iov.accent(), iov.accent2(), iov.accent2(), iov.accent());
            } else {
                uut.circle(drawContext, f8, f9, 9.0f, iov.field);
            }
            vjf.draw(drawContext, vhz.LAYERS, f8, f9, 8.0f, bl2 ? iov.onAccent() : ujt.lerp(iov.textMuted, iov.textDim, f7));
            float f10 = this.x + 31.0f;
            float f11 = this.hwn(0) - f10 - 8.0f;
            String string3 = irr.CARD_TITLE.ellipsize(info.name(), f11 - (bl2 ? 36.0f : 0.0f));
            float f12 = irr.CARD_TITLE.draw(drawContext, string3, f10, irr.CARD_TITLE.centerTop(f9 - 4.5f), iov.text);
            if (bl2) {
                uut.round(drawContext, f12 + 5.0f, f9 - 9.0f, 30.0f, 9.0f, 4.5f, iov.accent(45));
                irr.SMALL.drawCentered(drawContext, wap.s(a.b("\ue776\u9ee5\u1421\u8a4d\u0185\u8727", -1333401807), a.c(926177532, "\u5ceb\u2570\uafdb\u31d0\uba0d\u3cbb\u86e0")), f12 + 20.0f, irr.SMALL.centerTop(f9 - 4.5f), iov.accent());
            }
            String string4 = this.hwb.get(info.name());
            String string5 = (wap.ru() ? hvy : hvx).format(new Date(info.modified())) + a.d("\uc00e\ub9bf\u33fb\uad1d\u26ca", -533055473, -170854364) + info.enabled() + wap.s(a.d("\uc3eb\uba15\u30cf\uaef8", 596163630, 1642233825), a.b("\u9824\ue58d\u6f51\uf537", -2012112896)) + info.modules() + wap.s(a.b("\u4bda\u3224\ub8f6", 1674005497), a.c(-1960707270, "\ufb1e\u86bd\u0c66\u9216")) + (string4 != null ? wap.s(a.b("\uf9cc\u807d\u0a39\u94df\u1f08\u99fa\u23a5\uaa5f\u3401\ubef5", -1084818970), a.b("\ud81d\ua1ac\u2be8\ub50e\u3ed9\ubc72\u0625\u8fde\u1595", -1959274444)) + string4 : "");
            irr.SMALL.draw(drawContext, irr.SMALL.ellipsize(string5, f11), f10, irr.SMALL.centerTop(f9 + 5.5f), iov.textMuted);
            float f13 = 0.45f + 0.55f * f7;
            for (int j = 0; j < hvu.length; ++j) {
                float f14 = this.hwn(j);
                float f15 = f9 - 9.0f;
                boolean bl3 = hlc2.canHover() && irr.inside(f, f2, f14, f15, 18.0f, 18.0f);
                float f16 = hvn2.buttons[j].step(bl3, f3);
                boolean bl4 = j == 4 && info.name().equals(this.hwg);
                boolean bl5 = j == 3 && info.name().equals(this.hwc);
                irr.iconButton(drawContext, hvu[j], f14, f15, 18.0f, bl5 ? 1.0f : f16, bl4, bl4 || bl5 ? 1.0f : f13);
                if (!bl3) continue;
                hlc2.hint(bl4 ? wap.s(a.d("\u0e7e\u77e0\ufd36\u634d\ue892\u6e68\ud47a\u5d8d\uc3d4\u496d\uceb9\u3486\uba05\u23af\ua9b3\u2f06\u9548\u1a90\u802a\u066a\u8f8c\uf598\u5b17", 392938758, 117492524) + info.name() + a.b("\u4cc3", 1432055007), a.b("\u6c5f\u15c3\u9f16\u016d\u8abe\u0c75\ub651\u3bb5\ua1ff\u2b32\uacf9\u52f9\ud84e\u418f\ucbdb\u4931\uf372\u78c4\ue272\u645f\ueda7\u978c\u1d54\u82e6\u04ee\u8e3b\u3783\ub9d1\u235c\ua503\u2adc\ud486", -548837278) + info.name() + a.c(-1671697380, "\ueca6")) : hvq.hwk(j, string4));
            }
            drawContext.method_51448().popMatrix();
            uut.popAlpha();
        }
    }

    private void hwo(DrawContext drawContext) {
        float f = this.x + this.w * 0.5f;
        uut.circle(drawContext, f, this.y + 17.0f, 12.0f, iov.hover);
        vjf.draw(drawContext, vhz.LAYERS, f, this.y + 17.0f, 11.0f, iov.textMuted);
        irr.LABEL.drawCentered(drawContext, wap.s(a.c(994929135, "\u69af\u103f\u9aa3\u0491\u8f4a\u09fa\ub3a1\u3a5f\ua40e\u2eab\ua92b\u5303\uddc8\u4468"), a.d("\u54e3\u2d76\ua7a6\u39ae\ub205\u34bf\u8ee1\u071c\u9d51\u13ff\u942d\u6e58\ue085\u7d24\uf36a\u7593\ucfab", -95405072, -1713804520)), f, irr.LABEL.centerTop(this.y + 38.0f), iov.textDim);
        irr.SMALL.drawCentered(drawContext, wap.s(a.d("\u2868\u51f4\udb2e\u454a\uced8\u4828\uf23a\u7b85\ue5d5\u6f68\ue8b3\u1287\u9c11\u05a3\u8ffd\u0915\ub349\u3cdd\ua62f\u2071\ua98c\ud399\u5d7a\uc6a9\u40c1\uca06\u73b5\ufdb7\u6733\ue150\u6af4\u9436", 1626428713, -1909490379), a.d("\u9942\ue0d3\u6a07\uf477\u7fac\uf967\u4343\ucea7\u54e0\ude55\u59f5\ua7eb\u2d2e\ub4e6\u3eb6\ub83a\u0660\u8da9\u1302\u914e\u18b4\u62e3\uec5a\u778f\uf18a\u7b2c\uc68a\u4850\ud62d\u5063\udbab\u257f\uaf40\u36bc\ub0ea\u3a21\u85f8\u0b7e", -1919986973, 975294357)), f, irr.SMALL.centerTop(this.y + 49.0f), iov.textMuted);
    }

    @Override
    boolean mouseClicked(hlc hlc2, float f, float f2, int n) {
        List<ConfigManager.Info> list = this.hwl();
        for (int i = 0; i < list.size(); ++i) {
            float f3 = this.hwm(i);
            if (!irr.inside(f, f2, this.x, f3, this.w, 30.0f)) continue;
            String string = list.get(i).name();
            float f4 = f3 + 15.0f;
            for (int j = 0; j < hvu.length; ++j) {
                if (n != 0 || !irr.inside(f, f2, this.hwn(j), f4 - 9.0f, 18.0f, 18.0f)) continue;
                this.hwp(hlc2, j, string);
                return true;
            }
            this.hvz.name.setText(string);
            return true;
        }
        return false;
    }

    private void hwp(hlc hlc2, int n, String string) {
        try {
            switch (n) {
                case 0: {
                    ConfigManager.load(string);
                    hlc2.toast(wap.s(a.b("\u6523\u1cb1\u966c\u0818\u83ce\u057e\ubf69\u16a4", -603101849) + string + a.b("\u3f80", -1952964708), a.b("\ud8c9\ua15f\u2b8f\ub58d\u3e59\ub89d\u02cd\u8b34\u1176\u9b4c", -791028524) + string + a.b("\u2c19", -1716376413)), vhz.DOWNLOAD, false);
                    break;
                }
                case 1: {
                    ConfigManager.save(string);
                    hlc2.toast(wap.s(a.b("\uf2b1\u8b32\u01f6\u9f94\u1442\u92b7\u08d8", 926151397) + string + a.c(1338369250, "\uc4fe"), a.b("\u61b7\u1819\u92b1\u0cc5\u8762\u01de\ubb85\u327c\uac20\u228f\ua5d7", -461019747) + string + a.c(-2038834614, "\udaf0")), vhz.SAVE, false);
                    break;
                }
                case 2: {
                    String string2 = ConfigManager.sanitize(this.hvz.name.text);
                    if (string2 == null || string2.equals(string)) {
                        this.hvz.name.error();
                        hlc2.focus(this.hvz.name);
                        hlc2.toast(wap.s(a.d("\u0b2d\u72b1\uf86b\u660f\ued9d\u6b78\ud137\u58cb\uc6d1\u4c2e\ucbf6\u3195\ubf15\u26ea\uacb6\u2a4b\u900c\u1f98\u8562\u0334\u8a8d\uf088\u7e27\ue5fb\u63c1\ue956\u50ea\udeb7\u4449\uc210\u49e7\ub777\u3d3b\ua4c7\u228d\ua82f\u17b1\u9dcc\u1b4b\u82e6\u08b4\u764e\ufc53\u7bb2\ue167\u6f01\ud6c4\u5c75\uda69\u41ec\ucf83\u355f\ubcad\u3aac\ua04a\u2e10\u95a2\u1379\u990f", 629420773, 610220455), a.c(-75414233, "\u4105\u3894\ub240\u2c30\ua7eb\u2120\u9b04\u16e0\u8ca2\u0610\u81cf\u7bb2\uf56e\u68ca\ue681\u6074\uda48\u51f6\ucf57\u4d14\uc0fc\ubaac\u341a\uafc5\u2daf\ua36c\u1aa6\u94f4\u0e7e\u8c3a\u0391\uf958\u770a\ueef6\u68a3\ue218\u5dcb\ud7c0\u5164\uccc0\u4285\u3c7e\ub65d\u319c\uab46\u253e\u9ce9\u1620")), vhz.PENCIL, true);
                        return;
                    }
                    ConfigManager.rename(string, string2);
                    this.hwf.put(string2, this.hwf.remove(string));
                    hlc2.toast(wap.s(a.b("\u0454\u7dd2\uf70a\u6974\ue2af\u6416\ude44\u57f1\uc9fa\u4350\uc4cc\u1e81", 1033503754) + string2 + a.b("\u07d0", 74983372), a.c(-1895126636, "\uad9b\ud400\u5ea6\uc0a2\u4b78\ucdcd\u7797\ufe6e\u6032\uea8f\u6d5e\u9722\u1de8\u804b\u0e0a\u8870") + string2 + a.c(1540901174, "\u498c")), vhz.PENCIL, false);
                    break;
                }
                case 3: {
                    this.hwq(hlc2, string);
                    break;
                }
                case 4: {
                    if (!string.equals(this.hwg)) {
                        this.hwg = string;
                        this.hwh = System.currentTimeMillis() + 2500L;
                        return;
                    }
                    this.hwg = null;
                    ConfigManager.delete(string);
                    this.hwf.remove(string);
                    hlc2.toast(wap.s(a.d("\u5bb3\u2223\ua8f9\u3681\ubd47\u3be7\u81b5\u0800\ub663", 147312879, -899970287) + string + a.c(612171318, "\ude2a"), a.b("\u600d\u19ab\u937c\u0d06\u86bbf\ube28\u3752", 211969062) + string + a.b("\u3a34", 1207188110)), vhz.TRASH, false);
                    break;
                }
            }
        }
        catch (IOException | RuntimeException exception) {
            hlc2.toast(wap.s(a.d("\u19c1\u6057\uea8c\u74f8\uff26\u7996\uc39b\u4a70", -141036065, 1725164624), a.d("\u13a1\u6a46\ue0e5\u7e9d\uf541\u73fa\ucda3\u4448", -891043748, 258856939)) + exception.getMessage(), vhz.INFO, true);
        }
        this.hwd = -1;
    }

    private void hwq(hlc hlc2, String string2) {
        if (this.hwc != null) {
            return;
        }
        this.hwc = string2;
        ConfigShare.share(string2).whenCompleteAsync((string, throwable) -> {
            this.hwc = null;
            this.hwd = -1;
            if (throwable != null) {
                hlc2.toast(ConfigShare.describe(throwable), vhz.INFO, true);
                return;
            }
            MinecraftClient.method_1551().field_1774.method_1455(string);
            hlc2.toast(wap.s(a.d("\u98b6\ue12b\u6bf3\uf583\u7e11\uf8e3\u42bc\ucb52\u5514\udfa9\u587b\ua254\u2c99", 987904556, 1637982932) + string, a.d("\u4322\u3ab7\ub06e\u2a0b\ua5bd\u2377\u9920\u10d0\u8e88\u0441\u83ec\u7991\uf744\u6ef8\ue0ac\u6647", -1479171144, -584850288) + string), vhz.SHARE, false);
        }, (Executor)MinecraftClient.method_1551());
    }

    private static /* synthetic */ int acz(int n, int n2) {
        return (n ^ n2) + 656459855;
    }
}

