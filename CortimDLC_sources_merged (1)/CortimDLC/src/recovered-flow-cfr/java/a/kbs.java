/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jsf;
import a.wap;
import a.whl;
import flow.dev.a;
import java.awt.Color;
import java.util.ArrayList;

public final class kbs {
    private static final kbs[] kbt;
    public static final kbs DEFAULT;
    private static kbs kbu;
    public final String key;
    private final String kbv;
    private final String kbw;
    public final int accent;
    public final jsf particles;
    public final int tint;
    public final int fill;
    public final boolean light;
    private int kbx;
    private static /* synthetic */ boolean kby;
    private static /* synthetic */ String kbz;

    private kbs(String string, String string2, String string3, int n, jsf jsf2, int n2, int n3, boolean bl) {
        this.key = string;
        this.kbv = string2;
        this.kbw = string3;
        this.accent = n;
        this.particles = jsf2;
        this.tint = n2;
        this.fill = n3;
        this.light = bl;
    }

    public boolean logo() {
        return this.fill >= 0;
    }

    public String title() {
        return wap.s(this.kbv, this.kbw);
    }

    public int ordinal() {
        return this.kbx;
    }

    public boolean isVideo() {
        return whl.is(this.key);
    }

    public static kbs[] values() {
        return kbt;
    }

    public static kbs selected() {
        return kbu;
    }

    public static void select(kbs kbs2) {
        kbu = kbs2;
    }

    public static void load(String string) {
        kbs kbs2 = kbs.byKey(string);
        if (kbs2 != null) {
            kbu = kbs2;
        }
    }

    public static kbs byKey(String string) {
        for (kbs kbs2 : kbt) {
            if (!kbs2.key.equals(string)) continue;
            return kbs2;
        }
        return null;
    }

    static String resource(String string) {
        if (whl.is(string)) {
            return whl.poster(string.substring(a.d("\u6143\u18ed\u9233\u0c43\u879e\u017a", -1555662234, 2080512853).length()));
        }
        return a.b("\ua8c7\ud13f\u5be6\uc594\u4e5b\uc8b2\u72a3\ufb5a\u650e\uefa4\u682d", 833399011) + string + a.d("\u26e4\u5f11\ud5d8\u4bbe", -731496764, -226617334);
    }

    private static int kca(int n) {
        float[] fArray = Color.RGBtoHSB(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, null);
        float f = Math.max(0.32f, Math.min(0.62f, fArray[1]));
        return Color.HSBtoRGB(fArray[0], f, 1.0f) & 0xFFFFFF;
    }

    static {
        Object[][] objectArrayArray;
        ArrayList<kbs> arrayList = new ArrayList<kbs>();
        arrayList.add(new kbs(a.c(906118871, "\u46ae\u3f00\ub5de\u2bae\ua073\u2697\u9c98\u1563\u8b3f\u0196\u861f\u7c27\uf2f5\u6b57\ue11d"), a.c(2001845537, "\ubd6d\uc4f6\u4e26\ud04f\u5bcf\udd1c\u6761\uee9d\u70c0\ufa79"), a.c(-1895530086, "\u81d7\uf84c\u729c\uecf5\u6775\ue5c3\u5fe6\ud606\u4824\uc298\u4534"), 14476012, jsf.SILVER, 0xFFFFFF, 263430, false));
        arrayList.add(new kbs(a.b("\u6bf1\u125f\u9881\u06f1\u8d2c\u0bc8\ub1c7\u383c\ua660\u2cc9\uab40\u5170\udfa2\u461d\ucc41\u4aac", -455513193), a.d("\u03e0\u7a7b\uf0ab\u6ec2\ue542\u6384\ud9e8\u5018\uce5a\u44fa", -24606607, -195916835), a.b("\ub439\ucda2\u4772\ud91b\u529b\ud01b\u6a6c\ue393\u7dc7\uf709", -2137410443), 2764342, jsf.INK, 0xFFFFFF, 0xEEEFED, true));
        for (Object[] objectArray : objectArrayArray = new Object[][]{{a.b("\u480a\u31b8\ubb7a\u2518\uaed6\u2860\u923a", 1048266878), a.d("\u50c5\u2957\ua395\u3df7\ub639\u308f\u8ad5", 1040924393, -2084868488), a.b("\u460b\u3fa4\ub578\u2b79\ua0d4\u2664", 1139950124), 15231626, jsf.MOTES}, {a.c(-1363940738, "\uea1b\u93a1\u197f\u8719\u0cce\u8a74"), a.d("\u2ba4\u523e\ud8e0\u4686\ucd51\u4beb\uf1e1\u787c\ue60a\u6cbf\ueb7b\u1119\u9fd8", 994635375, -1251424891), a.b("\ud24b\uabd0\u2173\ubf77\u34cc\ub21e\u0834\u81bb\u1bf1\u955b\u128b\ue883\u6657\uffe8\u75b8", -56043946), 15771864, jsf.PETALS}, {a.d("\uc29e\ubb3b\u31e9\uaf99\u2456\ua2e4\u18f4\u914b\u0f16\u85b2\u0266", 1585797887, -1600481269), a.d("\u9a39\ue3bc\u696e\uf71e\u7cd1\ufa63\u407e\uc9ec\u5791\udd35\u5ae1", -738981844, -972254625), a.d("\u85f3\ufc1d\u76ba\ue8c3\u6314\ue5a0\u5ffe\ud21a\u485f\uc2ea\u4545\ubf4e\u319b\ua828", -1725895089, -1180733524), 15764026, jsf.LEAVES}, {a.d("\uc894\ub127\u3be6\ua590\u2e5f\ua8e7", 1276002115, -1375733838), a.c(-1739735903, "\ubcf6\uc565\u4fa4\ud1d2\u5a1d\udca5\u66b3\uef0b\u7153\ufbac\u7c2b\u8646\u089c\u9168\u1b58\u9d86\u27ca\ua801\u32a3\ub4e5"), a.d("\u1d1e\u6488\uee57\u7024\ufbf7\u795c\uc71d\u4afe\ud0bf\u5a01\uddd8\u27a2\ua97f\u30c4\ubae2", -1254590292, -180461142), 8370408, jsf.MOTES}, {a.b("\ufa28\u8384\u0956\u973f", 13433439), a.b("\u09ea\u707c\ufaa2\u64d3\uef01\u69b7\ud3ed\u5a5b\uc477\u4efb\uc929\u3340", 1449986464), a.c(2016702270, "\u6b17\u12ba\u9861\u0616\u8dcc\u0b7c\ub120\u38d5"), 11131391, jsf.MOTES}, {a.b("\u369b\u4f31\uc5e3\u5bcd\ud044\u56ed\uecac", 1691629300), a.d("\u6f84\u160d\u9ccc\u02e4\u895e\u0fc7\ub590\u3c64\ua230\u2899", 1794294066, 758951663), a.c(-2016359682, "\uceef\ub776\u3da1\ua3d4\u2877\uaeba\u149f\u9d1c\u075a\u89f0\u0e5b\uf45a"), 7321328, jsf.PETALS}, {a.c(1220274029, "\ue70c\u9eb7\u1467\u8a0e\u01cb\u876d\u3d3f"), a.b("\u277d\u5ee2\ud42a\u4a45\uc1de\u4738\ufd75\u7499\ueada\u6023\ue796\u1dcd\u9319\u0ab0\u80f1\u0617\ubc59", -1250744533), a.c(1853126663, "\u7c02\u0592\u8f46\u1146\u9a9a\u1c59\ua600\u2be1\ub1df\u3f0f\ubcba\u46bf\uc86f\u51a9\udb88\u5d75\ue73e"), 15254138, jsf.MOTES}, {a.b("\u431e\u3aa6\ub07f", -1222229128), a.b("\u94ef\ued7b\u67bb\uf9d3\u724f\uf49b\u4ee1\uc71a", 567121059), a.c(390862784, "\u13ed\u6a2f\ue091\u7ee1\uf53b\u73f5\ucdc9\u4055\ude7c\u54ba\ud361\u296c\ua7ba\u3e08\ub451"), 11570431, jsf.FIREFLIES}, {a.d("\ue2d8\u9b7b\u11a4\u8fcd\u041d\u82bf\u38e4", 482750364, 636865840), a.c(1193092083, "\u23b5\u5a32\ud0ee\u4e95\uc543\u43e5\uf9ad\u705b\uee0d\u64fb\ue35b\u1918\u97c3\u0e6a\u843e\u02dc\ub89b"), a.d("\u6ce8\u153a\u9feb\u01ea\u8a30\u0cfd\ub6ad\u3f2c\ua102\u2bbe\uac6a\u566a\ud8bc\u4514\ucb26\u4da6\uf7e5\u784b\ue2fb\u64da\ued24", -892250093, 1969762511), 0xE05050, jsf.MOTES}, {a.d("\u4b1a\u32ac\ub86c\u2602", 1999947131, 1262521859), a.b("\uc368\ubaff\u3037\uae5b\u259a\ua33a\u193d\u90aa\u0ed2\u8470\u03bc", -1515142352), a.b("\u79db{\u8add\u14d0\u9f0b\u1daa\ua3e4\u2a18\ub057\u3ef1\ub925\u435e\ucd83\u5440\ude64", 282164720), 15904842, jsf.MOTES}}) {
            arrayList.add(new kbs(a.c(350859266, "\ub072\uc9dc\u4302\udd72\u56af\ud04b") + objectArray[0], (String)objectArray[1], (String)objectArray[2], kbs.kca((Integer)objectArray[3]), (jsf)((Object)objectArray[4]), 0xFFFFFF, -1, false));
        }
        kbt = arrayList.toArray(new kbs[0]);
        for (int i = 0; i < kbt.length; ++i) {
            kbs.kbt[i].kbx = i;
        }
        kbu = DEFAULT = kbt[0];
    }

    private static /* synthetic */ int arr(int n, int n2) {
        return n * n2 ^ 0x24D0174D;
    }
}

