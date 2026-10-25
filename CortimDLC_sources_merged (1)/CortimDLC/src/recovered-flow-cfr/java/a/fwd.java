/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.hlc;
import a.iov;
import a.isv;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ScreenshotRecorder;

final class fwd {
    private static String fwe;
    private static String fwf;
    private static /* synthetic */ boolean fwg;
    private static /* synthetic */ String fwh;

    private fwd() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) throws Exception {
        switch (n) {
            case 1: {
                minecraftClient.method_1562().method_45730(a.c(-1837125820, "\uaf3d\ud691\u5c46\uc23f\u49ad\ucf4f\u750a\ufcea\u62e1\ue846\u6f93\u95e2\u1b35"));
                fwe = iov.PRESET.get();
                fwf = isv.selected();
                fwd.fwi(a.d("\ubec5\uc75e\u4d8e\ud3e7\u5867\udeb4\u64c9\ued35\u7368\uf9d1", 1537582006, -447734465), a.d("\uf155\u88fb\u0225\u9c55\u1788\u916c\u2b63\ua298\u3cc4\ub66d\u31e4\ucbdc\u450e\udcac\u56e6", -605365332, 390146688));
                fwd.fwj(minecraftClient, a.c(177141704, "\uf78d\u8e10\u04c1\u9abf\u116b\u97cf"));
                break;
            }
            case 70: {
                fwd.fwk(minecraftClient, a.d("\u4b66\u32dd\ub80d\u2664\uada8\u2b1a\u9149\u18bc\u86a5\u0c5b\u8b86\u71fa\uff2f\u6696\uec83\u6a3c\ud07f\u5fac\uc510\u4342\ucaa0", -1225834257, 78121978));
                break;
            }
            case 72: {
                fwd.fwj(minecraftClient, a.b("\u5b86\u2200\ua8d8\u36a3\ubd75\u3bd3", -122987566));
                break;
            }
            case 110: {
                fwd.fwk(minecraftClient, a.b("\ue641\u9ffa\u152a\u8b43\u008f\u863d\u3c6e\ub59b\u2b82\ua17c\u26a1\udcdd\u5208\ucbb1\u41a4\uc70a\u7d52\uf288\u6831\uee61\u6781", -950344142));
                break;
            }
            case 112: {
                fwd.fwj(minecraftClient, a.d("\u320b\u4b86\uc158\u5f21\ud4fe", -204718692, 873664454));
                break;
            }
            case 150: {
                fwd.fwk(minecraftClient, a.b("\ue566\u9cdd\u160d\u8864\u03a8\u851a\u3f49\ub6bc\u28a5\ua25b\u2586\udffa\u512f\uc896\u4283\uc42b\u7e78\uf1a4\u6b1f\ued46", 433251604));
                break;
            }
            case 152: {
                fwd.fwi(a.d("\ud6ec\uaf77\u25a7\ubbce\u304e\ub688\u0ce4\u8514\u1b56\u91f6", 124097605, 1559118565), a.b("\uecca\u9564\u1fba\u81ca\u0a17\u8cf3\u36fc\ubf07\u215b\uabf2\u2c7b\ud64b\u5899\uc126\u4b7a\ucd97", -1980044116));
                fwd.fwj(minecraftClient, a.b("\ub91f\uc082\u4a53\ud42d\u5ff9\ud95d", 1097578842));
                break;
            }
            case 210: {
                fwd.fwk(minecraftClient, a.d("\u164f\u6ff4\ue524\u7b4d\uf081\u7633\ucc60\u4595\udb8c\u5167\ud6ab\u2cdb\ua211\u3bb1\ub1aa\u3715\u8d56\u0285\u9839\u1e6b\u9789", -1073400419, 1628971937));
                break;
            }
            case 212: {
                fwd.fwi(a.b("\uf575\u8cee\u063e\u9857\u13d7\u9504\u2f79\ua685\u38d8\ub261", -142019271), a.d("\udca7\ua509\u2fd7\ub1a7\u3a7a\ubc9e\u0691\u8f6a\u1136\u9b9f\u1c16\ue62e\u68fc\uf15e\u7b14", -1845516047, -576752593));
                minecraftClient.method_1507(null);
                break;
            }
            case 250: {
                fwd.fwk(minecraftClient, a.d("\u2daa\u5411\udec1\u40a8\ucb64\u4dd6\uf785\u7e70\ue069\u6a9d\ued53\u1733\u99adS\u8a0e\u0cf2\ub6bf\u3966", 1822696234, -1019736332));
                break;
            }
            case 252: {
                fwd.fwi(a.d("\u5b96\u220d\ua8dd\u36b4\ubd34\u3bf2\u819e\u086e\u962c\u1c8c", 815031173, 493697119), a.d("\u5fd2\u267c\uaca2\u32d2\ub90f\u3feb\u85e4\u0c1f\u9243\u18ea\u9f63\u6553\ueb81\u723e\uf862\u7e8f", -1173383069, -1547778089));
                break;
            }
            case 290: {
                fwd.fwk(minecraftClient, a.d("\ub3c9\uca72\u40a2\udecb\u5507\ud3b5\u69e6\ue013\u7e0a\uf4fe\u7330\u8950\u07ce\u9e25\u1469\u9299\u28cb\ua70b", -1085501129, -178511222));
                break;
            }
            case 292: {
                iov.PRESET.set(fwe);
                isv.select(fwf);
                break;
            }
        }
        return n >= 300;
    }

    private static void fwi(String string, String string2) {
        iov.PRESET.set(string);
        iov.ACCENT.set(a.c(218628386, "\u0167\u78e2\uf230\u6c5a"));
        isv.select(string2);
    }

    private static void fwj(MinecraftClient minecraftClient, String string) throws Exception {
        Field field = hlc.class.getDeclaredField(a.c(-1569552764, "\u86f6\uff52\u7582\uebda\u6023\ue68e"));
        field.setAccessible(true);
        field.set(null, string);
        for (String string2 : new String[]{a.c(-257517948, "\u96f4\uef5b\u658f\ufbf4\u7028\uf681\u4cfd"), a.b("\u86d4\uff7b\u75af\uebd4\u6008\ue6a1\u5cdc", -1750694236)}) {
            Field field2 = hlc.class.getDeclaredField(string2);
            field2.setAccessible(true);
            field2.setFloat(null, Float.NaN);
        }
        Field field3 = hlc.class.getDeclaredField(a.b("\u601f\u19be\u937c\u0d10\u86c4u\uba39", -1194762165));
        field3.setAccessible(true);
        ((Map)field3.get(null)).clear();
        minecraftClient.method_1507((Screen)new hlc());
    }

    private static void fwk(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\u874c\ufeeb\u7431\uea4a\u61db\ue73e\u5d7c\ud49b\u4ac3\uc026", -369326283) + string + a.b("\u1adc\u630d\ue9be", 944577279) + minecraftClient.method_47599() + a.d("\ub6b6\ucf41\u4584\udbf6", 507106358, 565535396));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.d("\u163f\u6f84\ue554\u7b3d\uf0af\u7601", 817397468, -991270781) + string + a.d("\u873f\ufed0\u741d\uea65", 1964396508, 1584449737)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int rr(int n, int n2) {
        return n * n2 + -1608125436;
    }
}

