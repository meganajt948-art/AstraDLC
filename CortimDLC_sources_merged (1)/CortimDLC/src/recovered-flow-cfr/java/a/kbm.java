/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import flow.dev.a;
import java.util.List;

public final class kbm {
    public static final vkl TITLE = new vkl(a.c(-863354905, "\u3f96\u463a\uccf4\u529d\ud943"), false);
    public static final vlv POSITION = new vlv(a.b("\udcc8\ua566\u2fa9\ub1c2\u3a08\ubca4\u06f1\u8f01", -1349133136), a.c(373756639, "\u1297\u6b0f\ue1df\u7fbc"), a.c(1813437214, "\udb56\ua2ce\u281e\ub67d"), a.d("\u8bd4\uf243\u789b\ue6f0\u6d36\ueb90", 1395788748, -255950755), a.b("\ube9c\uc716\u4dcb\ud3b5\u587e", -1449083189));
    public static final vlv BUTTONS = new vlv(a.d("\u4ab9\u331f\ub9cd\u27bc\uac70\u2ac0\u908e", 1104814711, -1701091157), a.d("\uc8a5\ub13f\u3be1\ua582\u2e55", 29292174, -1649131927), a.c(-2119748357, "\u34b9\u4d23\uc7fd\u599e\ud249"), a.c(-1282769139, "\u7f4d\u06d9\u8c19\u1271"), a.c(-350027891, "\uffc4\u8650\u0c8d\u92f3\u1938"), a.b("\ub6e1\ucf6a\u45b8\udbd1\u5003\ud6b5\u6ced", -260852055));
    public static final vmc BLUR = new vmc(a.b("\ud7ee\uae51\u249b\ubaed", -1010051192), 0.0, 0.0, 1.0, 0.05).percent();
    public static final vmc ROUND = new vmc(a.b("\ud854\ua1f8\u2b31\ub55b\u3e86", 1586944035), 0.55, 0.0, 1.0, 0.05).percent();
    public static final vmc DIM = new vmc(a.c(-1035119985, "\u52e8\u2b54\ua183"), 0.0, 0.0, 0.6, 0.05).percent();
    public static final vkl PARTICLES = new vkl(a.b("\u37e4\u4e44\uc484\u5af3\ud139\u5782\uedde\u6426\ufa6f", 1500133277), true);
    public static final vkl PARALLAX = new vkl(a.c(1018353912, "\ud880\ua120\u2be0\ub582\u3e58\ub8e9\u02b7\u8b5f"), true);
    public static final List<vmo> ALL = List.of(TITLE, POSITION, BUTTONS, BLUR, ROUND, DIM, PARTICLES, PARALLAX);
    private static /* synthetic */ String kbn;
    private static /* synthetic */ long kbo;

    private kbm() {
    }

    public static void reset() {
        TITLE.reset();
        POSITION.reset();
        BUTTONS.reset();
        BLUR.reset();
        ROUND.reset();
        DIM.reset();
        PARTICLES.reset();
        PARALLAX.reset();
    }

    private static /* synthetic */ int ark(int n, int n2) {
        return n + n2 + 607260005;
    }
}

