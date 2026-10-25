/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 */
package a;

import a.dry;
import a.ejp;
import a.izx;
import a.pjd;
import flow.dev.a;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public final class pnr {
    private static final Pattern pns = Pattern.compile(a.c(-782830220, "\uf554\u8cf5\u0678\u9806\u13e3\u957d\u2f77\ua684\u38af\ub226\u35ba\ucfc9\u416b\ud8f5\u52ff"), 2);
    private static final int pnt = 20;
    private static String pnu;
    private static String pnv;
    private static int pnw;
    private static /* synthetic */ boolean pnx;
    private static /* synthetic */ String pny;

    private pnr() {
    }

    public static String anarchy(String string) {
        if (string == null) {
            return null;
        }
        Matcher matcher = pns.matcher(string.trim());
        return matcher.matches() ? matcher.group(1) : null;
    }

    public static boolean allow(String string) {
        String string2 = pnr.anarchy(string);
        if (string2 == null || ejp.isActive() || dry.armed()) {
            return true;
        }
        if (pjd.enter(pjd.MAIN, string2)) {
            pnu = null;
            return true;
        }
        String string3 = string.trim().toLowerCase(Locale.ROOT);
        if (string3.equals(pnu)) {
            pjd.cancel(pjd.MAIN);
            pnu = null;
            izx.notify(a.c(1152969418, "\ueed3\u973b\u1d9a\u839e\u083c\u8e8c\u34a7"), a.d("\u7780\u0e68\u84c9\u1acd\u916f\u17df\uadf4\u2069\uba2b\u3097\ub354\u4964\uc7bc", 1636529083, -891682776) + string2 + a.d("\ua5be\ud811\u52be\uccb1\u476f\uc1d6\u7b8d\uf274\u6c26", 1585140585, 1423701758));
            return false;
        }
        pnu = string3;
        pnv = string2;
        pnw = 0;
        izx.notify(a.b("\u3751\u4eb9\uc418\u5a1c\ud1be\u570e\ued25", -1360121016), a.c(1415886245, "\ub1bd\uc821\u46e2\ud8d2\u530a") + string2 + a.c(-870811422, "\u78c7\u0515\u8fb3\u11c1\u9e03") + 3 + a.d("\u29a4\u5408\uded6\u40df\ucb78\u4db4\uf382\u5a47\ue42c\u6a8b\ued5a\u175c\u9de8E\u8a1f\u0c9a\ub6d6\u3975\ua7d6\u218f", -724402854, -826256182) + pjd.position(pjd.MAIN) + a.c(-361788714, "\u8adf\uf77a\u79b9\ue7cf\u6c16\uee98\u54ea\udd17\u4338\uc9f5\u4e58\ub451\u3e9e\ua335\u2962\uaf91\u15d2\u9a0e\u00b4\u8692\u0b0a\u7157\ufb83\u6057\ue654\u6c8a\ud543\u5f79\uc190\u47bd\ucc70\u32a8\ub8ef\u211b\ua732\u2d8d"));
        return false;
    }

    public static void tick(MinecraftClient minecraftClient) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.method_1562();
        if (clientPlayNetworkHandler == null || minecraftClient.field_1724 == null || minecraftClient.method_1542()) {
            if (clientPlayNetworkHandler == null) {
                pjd.leave(pjd.MAIN);
            }
            pnu = null;
            return;
        }
        pjd.keep(pjd.MAIN);
        if (pnu == null || dry.armed() || ++pnw % 20 != 0) {
            return;
        }
        if (pjd.enter(pjd.MAIN, pnv)) {
            String string = pnu;
            pnu = null;
            izx.notify(a.c(-918229594, "\ue9bf\u9057\u1af6\u84f2\u0f50\u89e0\u33cb"), a.c(-1993731768, "\u155f\u6cc7\ue660\u7812\uf3b9\u7116\ucf58\u46a4\udceb\u561b\ud1c7") + pnv + a.d("\u8bce\uf661\u7ccd\ue2cf\u6914\uefaa\u55f6\udc0d\u425e\uc8ec\u4f3a\ub534\u3bee\ua633\u0c54\uaa91\u14c1\u9b1a\u01dc\u87f8\u0e7f\u7455\ufaee\u614a", -1130124162, 704849800));
            clientPlayNetworkHandler.method_45730(string.startsWith(a.d("\uc333", -1469336528, -1251444947)) ? string.substring(1) : string);
        }
    }

    private static /* synthetic */ int blp(int n, int n2) {
        return n + n2 | 0xC26DDE66;
    }

    private static /* synthetic */ int blq(int n, int n2) {
        return n ^ n2 | 0x54393D3D;
    }
}

