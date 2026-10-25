/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ign;
import a.kfa;
import a.kfe;
import a.lex;
import a.lqq;
import a.nfl;
import a.tck;
import a.tiq;
import a.ttb;
import a.txs;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vlq;
import a.vmu;
import flow.Flow;
import flow.config.ConfigManager;
import flow.dev.a;

public class lfa
extends kfe {
    private static lfa lfb;
    private static tiq lfc;
    private static String lfd;
    private final vkw lfe = this.add(new vkw(a.d("\u3e58\u47ce\ucd1c\u537c\ud8a6\u5e11", 1125465510, -1174142037), new vkq(a.c(-1758046623, "\u5625\u2fab\ua56d\u3b17\ub08e\u366c\u8c38\u05c8\u9b86\u113a\u96ef"), vhz.LAYERS, ign::open)));
    private final vmu lff = this.add(new vmu(a.b("\uc3dd\uba4e\u3080\uaef8\u2520\ua394\u19ce", 722125706), "", 32));
    private final vkl lfg = this.add(new vkl(a.c(-987561507, "\u0194\u7811\uf2c3\u6ca9\ue75c\u61c9\udb9d\u5267"), true));
    private final vkl lfh = this.add(new vkl(a.d("\ucbc5\ub240\u3892\ua6f8\u2d05\uab9f\u11c6", -1771926427, -791263258), true));
    private final vkl lfi = this.add(new vkl(a.d("\u15f1\u6c74\ue6a6\u78cc\uf323\u75a4\ucfe4\u4603\ud85d\u52e7", -38231102, 769767032), true));
    private final vlq lfj = this.add(new vlq(a.b("\u7108\u089e\u8256\u1c38\u97bf\u115d\uab09\u22ed\ubcbd\u3606\ub1c2", 737177936), 269));
    private final vmu lfk = this.add(new vmu(a.d("\ub63a\ucfaf\u457b\udb01\u5093\ud672\u6c23\ue5cf\u7b99\uf127\u76f1\u8c89", -628552157, -1278101416), "", 32));
    private final vmu lfl = this.add(new vmu(a.c(-903150683, "\u03fe\u7a79\uf0a7\u6ed1\ue54d\u63ac\ud9fd\u5011\uce47\u44f9\uc32f\u3957"), "", 32));
    private static tiq lfm;
    private static String lfn;
    private static tiq lfo;
    private static String lfp;
    private static /* synthetic */ int lfq;
    private static /* synthetic */ int lfr;

    public lfa() {
        super(a.c(910706515, "\u4710\u3e8a\ub449\u2a3f\ua1f5\u2779\u9d17\u14fd\u8ab7\u0013\u87dd\u7daa\uf37c"), a.c(311183862, "\u4991\u3016\ubadf\u24a9\uaf2c\u29d2\u9399\u1a71\u8460\u0e85\u8950\u7332\ufded\u645b\uee03\u68f3\ud2f8\u5d7b\uc7d5\u419f\uc87d\ub239\u3c97\ua740\u213e\uaba1\u1254\u9c0c\u06e6\u80e5\u0b37\uf5d2\u7f9c\ue676\u6007\uea92\u5542\udf38\u59a2\uc01f\u4a21\u34e4\ubeb6\u391c\ua3e1\u2dbb\u9462\u1e97\u9899\u0347\u8d3e\u77ab\ufe7d\u7818\ue2ea\u6ca0\ud727\u51c0\udba0\u4267\uccd1\ub68b"), kfa.COMBAT);
        lfb = this;
        this.lff.visibleWhen(() -> false);
        this.lfk.visibleWhen(() -> false);
        this.lfl.visibleWhen(() -> false);
    }

    public static tiq walkProfile() {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return null;
        }
        String string = lfa2.lfl.get();
        if (string == null || string.isBlank()) {
            lfo = null;
            lfp = "";
            return null;
        }
        if (lfo == null || !string.equals(lfp)) {
            lfp = string;
            lfo = tiq.open(string);
        }
        return lfo;
    }

    public static void activateWalk(tiq tiq2) {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa2.lfl.set(tiq2 == null ? "" : tiq2.name);
        lfo = tiq2;
        lfp = tiq2 == null ? "" : tiq2.name;
        ConfigManager.autoSaveLater();
    }

    public static void useForWalk(tiq tiq2) {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa.activateWalk(tiq2);
        lfa2.lfh.set(true);
        lfa2.lfi.set(true);
        if (!lfa2.isEnabled()) {
            lfa2.setEnabled(true);
        }
    }

    public static boolean walksWith(tiq tiq2) {
        lfa lfa2 = lfb;
        return lfa2 != null && tiq2 != null && (lfa2.lfh.get() || lfa2.lfi.get()) && lfa.walkProfile() == tiq2;
    }

    public static txs walkModel(lex lex2) {
        lfa lfa2 = lfb;
        if (lfa2 == null || !lfa2.lft(lex2)) {
            return null;
        }
        tiq tiq2 = lfa.walkProfile();
        return tiq2 == null || !tiq2.walk() ? null : tiq2.walkModel();
    }

    public static tiq mineProfile() {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return null;
        }
        String string = lfa2.lfk.get();
        if (string == null || string.isBlank()) {
            lfm = null;
            lfn = "";
            return null;
        }
        if (lfm == null || !string.equals(lfn)) {
            lfn = string;
            lfm = tiq.open(string);
        }
        return lfm;
    }

    public static void activateMine(tiq tiq2) {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa2.lfk.set(tiq2 == null ? "" : tiq2.name);
        lfm = tiq2;
        lfn = tiq2 == null ? "" : tiq2.name;
        ConfigManager.autoSaveLater();
    }

    public static void useForMine(tiq tiq2) {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa.activateMine(tiq2);
        lfa2.lfg.set(true);
        if (!lfa2.isEnabled()) {
            lfa2.setEnabled(true);
        }
    }

    public static boolean minesWith(tiq tiq2) {
        lfa lfa2 = lfb;
        return lfa2 != null && tiq2 != null && lfa2.lfg.get() && lfa.mineProfile() == tiq2;
    }

    public static double mineBoost() {
        tiq tiq2 = lfa.mineProfile();
        return tiq2 == null ? 0.0 : (double)tiq2.mineBoost() / 100.0;
    }

    public static ttb mineModel() {
        lfa lfa2 = lfb;
        if (lfa2 == null || !lfa2.lfg.get()) {
            return null;
        }
        tiq tiq2 = lfa.mineProfile();
        return tiq2 == null || !tiq2.mine() ? null : tiq2.mineModel();
    }

    @Override
    public boolean isHidden() {
        return true;
    }

    public static lfa get() {
        return lfb;
    }

    public static tiq activeProfile() {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return null;
        }
        String string = lfa2.lff.get();
        if (string == null || string.isBlank()) {
            lfc = null;
            lfd = "";
            return null;
        }
        if (lfc == null || !string.equals(lfd)) {
            lfd = string;
            lfc = tiq.open(string);
        }
        return lfc;
    }

    public static void activate(tiq tiq2) {
        lfa lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa2.lff.set(tiq2 == null ? "" : tiq2.name);
        lfc = tiq2;
        lfd = tiq2 == null ? "" : tiq2.name;
        ConfigManager.autoSaveLater();
    }

    public static int stopKey() {
        lfa lfa2 = lfb;
        return lfa2 == null ? 269 : lfa2.lfj.get();
    }

    public static tck model(lex lex2) {
        lfa lfa2 = lfb;
        if (lfa2 == null || !lfa2.lft(lex2)) {
            return null;
        }
        tiq tiq2 = lfa.activeProfile();
        return tiq2 == null || tiq2.aura() || tiq2.mine() || tiq2.walk() ? null : tiq2.model();
    }

    public static tck modelOr1(lex lex2) {
        tck tck2 = lfa.model(lex2);
        return tck2 != null ? tck2 : tck.profile1();
    }

    public static boolean turning() {
        return lfa.lfs(a.c(1962348833, "\u1169\u68f0\ue227\u7c7a\uf79f\u712e\ucb67\u428c\udcd4")) || lfa.lfs(a.c(-2086043640, "\u8041\uf9c4\u7316\ued7c\u6689\ue01c\u5a48\ud3b2")) || lfa.lfs(a.d("\ubd4a\uc4cf\u4e1d\ud077\u5b8a\udd10\u6749", 332989849, -1704609643)) || lfa.lfs(a.c(1571927494, "\ub58d\ucc08\u46da\ud8b0\u535f\ud5d8\u6f98\ue67f\u7821\uf29b")) || nfl.busy() || lqq.busy();
    }

    private static boolean lfs(String string) {
        Flow flow = Flow.getInstance();
        kfe kfe2 = flow.getModuleManager() == null ? null : flow.getModuleManager().getByName(string);
        return kfe2 != null && kfe2.isEnabled();
    }

    private boolean lft(lex lex2) {
        return switch (lex2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> this.lfg.get();
            case 1 -> this.lfh.get();
            case 2 -> this.lfi.get();
        };
    }

    static {
        lfd = "";
        lfn = "";
        lfp = "";
    }

    private static /* synthetic */ int awf(int n, int n2) {
        return n - n2 + 2045997961;
    }

    private static /* synthetic */ int awg(int n, int n2) {
        return lfa.awf(n, n2) ^ 0x8311F5B5;
    }

    private static /* synthetic */ int awh(int n, int n2) {
        return lfa.awf(n, n2) + n;
    }
}

