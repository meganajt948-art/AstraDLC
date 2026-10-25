/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.Text
 */
package a;

import a.dry;
import a.evi;
import a.ewk;
import a.hhf;
import a.hhs;
import a.hia;
import a.hip;
import a.hiv;
import a.hjg;
import a.hks;
import a.hkv;
import a.htj;
import a.hur;
import a.hva;
import a.hvq;
import a.hwr;
import a.hxi;
import a.hxv;
import a.hyj;
import a.hyv;
import a.hyz;
import a.hzq;
import a.hzv;
import a.iab;
import a.iah;
import a.ibf;
import a.ict;
import a.ida;
import a.ifj;
import a.ijy;
import a.ike;
import a.iks;
import a.ild;
import a.ilz;
import a.imn;
import a.iov;
import a.iqp;
import a.irk;
import a.irr;
import a.irv;
import a.isv;
import a.iui;
import a.ivk;
import a.ixu;
import a.izx;
import a.jgn;
import a.jjx;
import a.jlx;
import a.kfa;
import a.kfe;
import a.lsg;
import a.swh;
import a.ucg;
import a.ujt;
import a.ujw;
import a.ukf;
import a.unf;
import a.upt;
import a.uqe;
import a.uut;
import a.vcj;
import a.vcq;
import a.vdc;
import a.vdn;
import a.vhz;
import a.vjf;
import a.vla;
import a.vlj;
import a.vlv;
import a.vmo;
import a.vvi;
import a.vzz;
import a.wam;
import a.wap;
import a.wlk;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.Flow;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import flow.util.LoaderInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public class hlc
extends Screen {
    static final float W = 540.0f;
    static final float H = 409.0f;
    private static final float hld = 136.0f;
    private static final float hle = 46.0f;
    private static final float hlf = 14.0f;
    private static final float hlg = 10.0f;
    private static final float hlh = 23.0f;
    private static final float hli = 25.0f;
    private static final float hlj = 62.0f;
    private static final float hlk = 136.0f;
    private static final float hll = 20.0f;
    private static final float hlm = 20.0f;
    private static int hln;
    private static String hlo;
    private static float hlp;
    private static float hlq;
    private static final Map<String, Float> hlr;
    private static final Map<kfe, hjg> hls;
    private static List<hjg> hlt;
    private static List<hjg> hlu;
    private static List<hjg> hlv;
    private static List<hjg> hlw;
    private static List<hjg> hlx;
    private static List<hjg> hly;
    private final List<hkv> hlz = new ArrayList<hkv>();
    private int hma;
    private List<hjg> hmb = new ArrayList<hjg>();
    private final vdc hmc = new vdc(0.3f, 0.0f);
    private final vdc hmd = new vdc(0.42f, 0.0f);
    private final vdc hme = new vdc(0.32f, 1.0f);
    private final vdc hmf = new vdc(0.18f, 1.0f);
    private final vcj hmg = new vcj(16.0f);
    private final List<vcj> hmh = new ArrayList<vcj>();
    private final List<vcj> hmi = new ArrayList<vcj>();
    private final List<vcj> hmj = new ArrayList<vcj>();
    private int[] hmk = new int[0];
    private final vcj hml = new vcj(16.0f);
    private final vcj hmm = new vcj(8.0f);
    private final vcj hmn = new vcj(14.0f);
    private final vcj hmo = new vcj(8.0f);
    private float hmp;
    private float hmq;
    private long hmr;
    private int hms;
    private String hmt = "";
    private String hmu = "";
    private String hmv = "";
    private String hmw = "";
    private boolean hmx;
    private boolean hmy;
    private boolean hmz;
    private float hna;
    private float hnb;
    private imn hnc;
    private hxi hnd;
    private ijy hne;
    private irk hnf;
    private String hng = "";
    private int hnh = -1;
    private String hni = "";
    private vhz hnj = vhz.INFO;
    private boolean hnk;
    private long hnl;
    private String hnm;
    private String hnn;
    private static final long hno = 350L;
    private static final float hnp = 220.0f;
    private static final float hnq = 7.0f;
    private final vcj hnr = new vcj(14.0f);
    private hjg hns;
    private long hnt;
    private hjg hnu;
    private hjg hnv;
    private List<String> hnw = List.of();
    private hjg hnx;
    private wam hny;
    private float hnz;
    private static String hoa;
    private static final Set<hjg> hob;
    private static final int hoc = 4;
    private String hod = "";
    private final iah hoe = new iah(a.c(1134752445, "\uf2e8\u8b6f\u01b8\u9fda\u141c\u92a6"), vhz.SEARCH, 24, iah.ANY);
    private iah hof;
    private final vcj hog = new vcj(16.0f);
    private final vcj hoh = new vcj(14.0f);
    private final vcj[] hoi = new vcj[]{new vcj(16.0f), new vcj(16.0f), new vcj(16.0f), new vcj(16.0f)};
    private long hoj;
    private final vcj hok = new vcj(14.0f);
    private final vcj hol = new vcj(9.0f);
    private final vcj hom = new vcj(13.0f);
    private boolean hon;
    private long hoo = -1L;
    private float hop = 0.016666668f;
    private float hoq = 1.0f;
    private float hor = 1.0f;
    private float hos;
    private float hot;
    private float hou;
    private float hov;
    private GpuTextureView how;
    private static final float hox = 18.0f;
    private static final float hoy = 24.0f;
    private static final float hoz = 7.0f;
    private static final float hpa = 18.0f;
    private static final int hpb = -1750963;
    private static final float hpc = 46.0f;
    private static /* synthetic */ int hpd;
    private static /* synthetic */ boolean hpe;

    public hlc() {
        super((Text)Text.method_43470((String)a.d("\uc518\ubc83\u3653\ua83a\u23a8", -449570389, 2014764272)));
        evi.refresh();
        this.hod = hoa;
        this.hoe.text = hoa;
        this.hoe.onChange = this::hri;
        this.hoe.onSubmit = () -> this.focus(null);
    }

    static String tabKey() {
        return hlo;
    }

    static void setTabKey(String string) {
        hlo = string;
    }

    static Map<String, Float> scrolls() {
        return hlr;
    }

    static float windowX() {
        return hlp;
    }

    static float windowY() {
        return hlq;
    }

    static void setWindowPos(float f, float f2) {
        hlp = f;
        hlq = f2;
    }

    static float contentCenterX() {
        return 0.6259259f;
    }

    static float contentCenterY() {
        return 0.5562347f;
    }

    protected void method_25426() {
        int n;
        if (!this.hlz.isEmpty()) {
            this.hpj();
            return;
        }
        this.hlz.clear();
        this.hmh.clear();
        this.hmi.clear();
        this.hmj.clear();
        for (kfa kfa2 : kfa.values()) {
            this.hlz.add(new hkv(kfa2.title(), hlc.iconFor(kfa2), kfa2, hks.MODULES));
        }
        this.hma = this.hlz.size();
        this.hlz.add(new hkv(a.d("\u2df7\u547a\udea4\u40dd\ucb02", -1645092832, -1342845562), vhz.THEME, null, hks.THEME));
        this.hlz.add(new hkv(a.b("\udba9\ua205\u28c7", 796384226), vhz.LAYOUT, null, hks.HUD));
        this.hlz.add(new hkv(a.c(-1061324256, "\u7a64\u03f9\u892b\u1752\u9c8a\u1a35\ua072"), vhz.LAYERS, null, hks.CONFIGS));
        this.hlz.add(new hkv(a.c(812099683, "\ua83d\ud1ba\u5b71\uc509\u4ec1\uc876\u7222\ufbc9\u6591"), vhz.PIN, null, hks.WAYPOINTS));
        this.hlz.add(new hkv(a.c(3977682, "\ub193\uc816\u42de\udca3\u577f\ud1c4\u6b80"), vhz.FRIENDS, null, hks.FRIENDS));
        this.hlz.add(new hkv(a.d("\uddd8\ua445\u2e8a\ub0e5\u3b3a\ubd9a\u07d4\u8e2f\u1060", -235192492, -2048204090), vhz.CROWN, null, hks.COSMETICS));
        for (n = 0; n < this.hlz.size(); ++n) {
            this.hmh.add(new vcj(16.0f));
            this.hmi.add(new vcj(7.0f));
            this.hmj.add(new vcj(7.0f));
        }
        this.hmk = new int[this.hlz.size()];
        if (hlo != null) {
            for (n = 0; n < this.hlz.size(); ++n) {
                if (!this.hlz.get((int)n).hkw.equals(hlo)) continue;
                hln = n;
            }
        }
        hln = Math.max(0, Math.min(hln, this.hlz.size() - 1));
        hlo = this.hlz.get((int)hlc.hln).hkw;
        for (kfe kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            hls.computeIfAbsent(kfe2, hjg::new);
        }
        if (hlt == null) {
            hlc.hpf();
        }
        isv.rescan();
        this.hpm(false);
        this.hpq();
        this.hmg.set(this.hqa(hln));
        this.hpj();
    }

    private static void hpf() {
        String[][] stringArrayArray;
        Object object;
        hjg hjg2 = new hjg(a.b("\u6ce4\u1569\u9fb7\u01ce\u8a11", 988769461), a.c(-710839456, "\u731b\u0a88\u804c\u1e2b\u95ea\u134a\ua91e\u20b2\ubee3\u3435\ub3cd\u49b1\uc774\u5ec5\ud4c5\u527b\ue835\u67ef\ufd4a\u7b48\uf2f3\u88ab\u0609\u9d8c\u1ba7\u916a\u28d4\ua6c0\u3c67\uba2f\u3196\ucf50\u451e\udce8\u5aac\ud058\u6fdb\ue5b6\u637f\ufad3\u7096\u0e75\u8429")).row(new iqp());
        hjg2.wide = true;
        hjg hjg3 = new hjg(a.c(476446350, "\ufec9\u875a\u0d89\u93fe\u1822\u9e89"), a.c(-1509108493, "\ud49d\uad18\u27ca\ub9a0\u3238\ub4dd\u0e9b\u8760\u1931\u9396\u1416\uee33\u60f8\uf944\u7352\uf5f7\u4fa4\uc078\u5ac3\udc9a\u552f\u2f2a\ua1ca\u3a54\ubc33\u36fb\u8f08\u0157\u9bcf\u1da3\u9642\u68c3\ue295\u7b6e\ufd35\u77cf\uc841\u4226\uc4ef\u5d59\ud754\ua9e6\u23b9\ua40b\u3edf\ub0b4\u0960")).row(new hhs()).settings(List.of(iov.GRADIENT)).row(new ilz().visibleWhen(() -> iov.ACCENT.is(a.b("\u9310\uea97\u6042\ufe34\u75f8\uf34b", 1253675861))));
        hjg3.home = 0;
        hjg hjg4 = new hjg(a.d("\u2294\u5b13\ud1c6\u4fb0\uc47c\u42cf\uf8d1\u7174\uef37\u658b\ue250\u1829", -1355660557, 1751343144), a.d("\u999a\ue018\u6ad8\uf4be\u7f62\uf98a\u439a\uca67\u543b\ude89\u5940\ua336\u2db3\ub44d\u3e17\ub8a0\u02bb\u8d76\u17c8\u91dc\u1866\u623f\uec87\u774d\uf167\u7bf7\uc24b\u4c10\ud6a3\u50a6\udb09\u25d5\uafdf\u3646\ub008\u3aa8\u8515\u0f6a\u89dc\u104c\u9a1e\ue4f2\u6ebc\ue90a\u73d4\ufde2\u4462\uced7\u4886\ud34a\u5d2e\ua7f4\u2e4e\ua809\u32a9\ubcac\u0708\u8196\u0bac\u9260", 1537400249, 802047066)).settings(List.of(iov.PAINT)).row(new htj()).settings(iov.CUSTOM_SLIDERS).row(new hiv(new hip(a.d("\u1797\u6e12\ue4dc\u7aaf\uf135\u77c7\ucd82\u4474\uda2b\u508d\ud755\u2d3e", 1235718949, 1595901176), vhz.LAYERS, iov::customFromCurrent), new hip(a.b("\u658e\u1c08\u96cd\u08aa\u836c", -214604327), vhz.RESET, iov::resetCustom)));
        for (vmo object52 : iov.CUSTOM_SLIDERS) {
            imn imn2 = hjg4.rowFor(object52);
            if (imn2 == null) continue;
            imn2.visibleWhen(() -> iov.PAINT.is(a.d("\u86f5\uff6c\u75b4\uebde", 1460955132, 1895948608)));
        }
        hjg4.home = 1;
        hjg hjg5 = new hjg(a.b("\ue431\u9db6\u1768\u8919\u02d2\u8472\u3e30\ub7d4\u299c", -351673233), a.d("\u11e3\u687a\ue2a2\u7cc8\uf74a\u71b9\ucbe9\u421a\udc4d\u56f0\ud136\u2b5a\ua597\u3c3d\ub664\u30cb\u8a9e\u0503\u9fb5\u19fb\u901f\uea0b\u64eb\uff22\u795f\uf382\u4a27\uc429\u5ed2\ud8ce\u537f\uadb7\u27e7\ube11\u384b\ub2bd\u0d3a\u8753\u0187\u982d\u1269\u6c84", 962982580, 2029183792)).row(new irv()).settings(List.of(isv.FIT, isv.DARKEN, isv.MOTION, isv.PARTICLES));
        hjg5.wide = true;
        for (vmo vmo2 : List.of(isv.FIT, isv.DARKEN, isv.MOTION, isv.PARTICLES)) {
            imn imn3 = hjg5.rowFor(vmo2);
            if (imn3 == null) continue;
            if (vmo2 == isv.DARKEN) {
                imn3.activeWhen(() -> !isv.selected().equals(a.d("\u2c59\u55f0\udf3e\u4151\uca8e", -2140909545, 1649572924)));
                continue;
            }
            if (vmo2 == isv.PARTICLES) {
                imn3.activeWhen(() -> isv.photoSelected() && isv.MOTION.get() > 0.001);
                continue;
            }
            imn3.activeWhen(isv::photoSelected);
        }
        hjg hjg6 = new hjg(a.d("\u052e\u7cba\uf671\u6804\ue3cf\u6573\udf64\u56f2\uc886\u423a\uc5fb\u3f8a", 1183169093, -1892303061), a.d("\ud3ce\uaa48\u2098\ubefd\u3539\ub38a\u09ce\u8022\u1e7b\u94cb\u1356\ue968\u67a6\ufe04\u7440\uf2e3\u48f8\uc735\u5d8b\udb9f\u5238\u2870\ua6c9\u3d0f\ubb71\u31a7\u8803\u0617\u9ca1\u1aff\u9146\u6fd3\ue5c8\u7c25\ufa7b\u708f\ucf0f\u4566\uc3a8\u5a07\ud050", 1121285147, -481362)).toggle(hyv.ENABLED).settings(hyv.OPTICS).row(new hiv(a.b("\uff7b\u86fd\u0c38\u925f\u1999\u9f7c\u2568\uac92\u32c0\ub863\u3fb0", 77397794), vhz.RESET, hyv::resetAll));
        for (vmo vmo3 : hyv.LIQUID_ONLY) {
            object = hjg6.rowFor(vmo3);
            if (object == null) continue;
            ((imn)object).activeWhen(hyv::liquid);
        }
        hjg6.home = 1;
        hjg hjg7 = new hjg(a.b("\u83e5\ufa7f\u70a1\ueec2\u6515\ue3f7\u59f4\ud014\u4e58\uc4ef\u433b", -539262039), a.b("\u08c1\u714f\ufb9d\u65e6\uee3a\u68c3\ud2c0\u5b20\uc56c\u4fdb\uc80f\u322d\ubcbb\u2519\uaf5d\u29e9\u93e1\u1c3b\u8685\u00c6\u8931", -315488125)).settings(hyv.TARGETS);
        hjg7.home = 1;
        hjg hjg8 = new hjg(a.c(-46430020, "\u88fc\uf16a\u7ba3\ue5c3\u6e03\ue8a6\u52f2\udb01\u4558"), a.b("\ua8a1\ud12a\u5bea\uc584\u4e1a\uc8a7\u72b7\ufb4a\u6508\uefa5\u687d\u921b\u1ccd\u8523\u0f7c\u89c0\u338d\ubc47\u26e9\ua0be\u2948\u535b\udde4\u4661\uc002\u4ade\uf328\u7d3e\ue7cf\u6192\uea29\u14bd\u9eb0\u0746\u8118\u0ba8\ub478\u3e03", 555460820)).settings(iov.INTERFACE);
        hjg8.home = 0;
        hlt = List.of(hjg2, hjg3, hjg4, hjg5, hjg8, hjg6, hjg7);
        object = new hjg(a.b("\u8817\uf1bb\u7b79", -365590436), a.b("\u0829\u71bf\ufb22\u6507\ueecc\u6870\ud266\u5bd4\uc580\u4f38\uc8fe\u32c1\ubc0c\u25f9\uafbc\u295e\u9317\u1c81\u8662\"\u89c6\uf391\u7d25\ue6a7\u608c\uea46\u53ba\udda6\u4753\uc11b\u4abb\ub423\u3e60\ua7c3\u218b\uab34\u14ec\u9e81\u1806\u81f3\u0bba\u7558\uff0d\u78fb\ue278\u6c12\ud58e\u5f6c\ud939\u42fb\ucc97", -1757149101)).toggle(izx.ENABLED).settings(izx.LOOK).row(new hiv(new hip(a.b("\u01fc\u786c\uf2b2\u6cde\ue75d\u61a0\udbfe\u5217\ucc5e\u46f5\uc127", 1960444338), vhz.MOVE, izx::openEditor), new hip(a.b("\u675e\u1ed8\u941d\u0a7a\u81bc", 1573283593), vhz.RESET, izx::resetLayout)));
        ((hjg)object).home = 0;
        hjg hjg9 = new hjg(a.d("\ufd7e\u84f9\u0e3f\u905f\u1b9f\u9d31\u276e\uae8c\u30ca", -1177384458, 1691579606), a.d("\ub899\uc13e\u4bee\ud5e0\u5e3b\ud8da\u6290\ueb66\u7530\uffca\u7815\u8210\u0cc3\u9571\u1f5d\u99a0\u23bc\uac6e\u36c8\ub099\u396f\u437a\ucd88\u5656\ud023\u5ab6\ue355\u6d1b\uf7f0\u71bb\ufa15\u04d9\u8e90\u1760\u9171\u1bcc\ua44f\u2e25\ua8e9\u3108\ubb14\uc5e3\u4fbb\uc810\u52c1\udca7", 1801362239, 930948046)).toggle(izx.WATERMARK.enabled).settings(jlx.ISLAND);
        hjg9.home = 0;
        hjg hjg10 = new hjg(a.c(-1673705586, "\u47dc\u3e58\ub498\u2afc\ua129\u2789"), a.c(-1867740893, "\u8959\uf0d7\u7a03\ue43d\u6fb3\ue914\u535d\udaf9\u44ee\uce5e\u4990\ub3b5\u3d2d\ua481\u2e80\ua83d\u1271\u9da0\u0717\u810d\u08bb\u72ff\ufc02\u67c9\ue1fe\u6b22\ud295\u5cc9\uc626\u406b\ucb9c\u3541\ubf4f\u26ad\ua0e1\u2a52\u959f\u1fe9\u9964\u00d9\u8ace\uf436\u7e6a\uf9d1\u6311")).toggle(izx.TARGET.enabled).settings(jjx.OPTIONS);
        hjg10.home = 0;
        hjg hjg11 = new hjg(a.d("\ue72c\u9ea5\u1470\u8a1b\u01c6", -1390041138, -1106427734), a.d("\u6195\u1807\u92cb\u0ca1\u876b\u01d5\ubb99\u323d\uac6e\u26a6\ua14d\u5b33\ud5ee\u4c5e\uc610\u40b9\ufa9b\u7572\uefc7\u698c\ue071\u9a6f\u14d0\u8f40\u097e\u83ed\u3a4e\ub402\u2eed\ua8b8\u231d\udddb\u57c8\uce37\u4807\uc29a\u7d4c\uf727\u71f2\ue85e\u6202\u1cec\u96ec\u1114\u8bc4\u05fb\ubc7c\u36d1\ub093\u2b07\ua537\u5fed\ud653\u5017", -547974978, 1567289678)).toggle(jlx.MUSIC).settings(jlx.MUSIC_SETTINGS).row(new iab(a.c(1206071205, "\u2fe8\u5678\udcb3"), jgn::summary)).row(new hiv(new hip("", vhz.PREV, () -> jgn.command(a.b("\ucd94\ub427\u3ee3\ua081", 965332448))), new hip(a.d("\u069b\u7f16\uf5c8\u6ba1\ue02f\u6691\udccd\u554c\ucb22\u4187\uc652\u3c35", -2103087337, -1488557616), vhz.PLAY, () -> jgn.command(a.d("\u34fe\u4d54\uc78f\u59fe\ud222\u549a", -1171931506, -1780839934))), new hip("", vhz.NEXT, () -> jgn.command(a.c(1313567013, "\u714f\u08f5\u823b\u1c46")))));
        hjg11.home = 1;
        hjg hjg12 = new hjg(a.b("\u65a2\u1c2c\u96e4\u0888\u8359\u05e9\ubfa7", -1613011467), a.d("\u04a1\u7d32\uf7f6\u699a\ue252\u64f0\udee6\u5752\uc90e\u43bf\uc46f\u3e18\ub0d8\u296e\ua36e\u25de\u9f9e\u1045\u8ab2\u0cb7\u855d\uff08\u71b3\uea27\u6c14\ue6cc\u5f7c\ud13f", 1641680279, -152893077)).toggle(izx.POTIONS.enabled).settings(izx.POTIONS.settings());
        hjg12.home = 1;
        hjg hjg13 = new hjg(a.b("\u2cbe\u5521\udfee\u4184\uca58\u4cee\uf6b7\u7f51", 1503079677), a.b("\u267c\u5fef\ud537\u4b57\uc099\u4621\ufc64\u75c6\uebce\u6161\ue6af\u1cc2\u925d\u0bad\u81bf\u0705\ubd44\u3289\ua86d\u2e32\ua7a8\udddd\u5363\uc8b2\u4ec5\uc41d\u7deb\uf3f9\u6901\uef55\u64ec\u9a35\u1031\u8981\u0f93\u856f\u3aba\ub0c0\u3602\uafaa\u25fc\u5b48\ud14f\u56e5\ucc7d\u424e\ufb96\u7120\uf765", -2044123648)).toggle(izx.KEYBINDS.enabled).settings(izx.KEYBINDS.settings());
        hjg13.home = 1;
        hjg hjg14 = new hjg(a.d("\u2e01\u579c\udd4f\u433d\uc8e2\u4e58\uf413\u7dfb\ue3b9", 383224983, 322937564), a.c(536093212, "\u2250\u5bd4\ud103\u4f61\uc4a8\u4206\uf80a\u71f7\uefeb\u6551\ue285\u18e9\u9639\u0f8e\u8582\u037f\ub967\u36a8\uac1c\u2a47\ua3f4\ud9e6\u575e\ucc86\u4aea\uc02e\u799f\uf7d8")).toggle(izx.COOLDOWNS.enabled);
        hjg14.home = 1;
        hjg hjg15 = new hjg(a.c(-874342685, "\u96af\uef23\u65e1\ufb98\u7051"), a.d("\u5f3c\u26bb\uac7f\u320a\ub9ce\u3f68\u8501\u0cdd\u928b\u1826\u9fe0\u6586\ueb03\u72fb\uf8b5\u7e55\uc412\u4b8e\ud176\u5729\udec2\ua499\u2a63\ub1a8\u379e\ubd52\u04f0\u8aa9\u101f\u9642\u1db2\ue36f\u693a\uf0d0\u7699\ufc70\u43ab\uc999\u4f46\ud6f7\u5cab\u2252\ua80a\u2fa3\ub56d\u3b5e\u8281\u087b\u8e3a\u15f7", 1174188374, 834137611)).toggle(izx.ITEMS.enabled);
        hjg15.home = 1;
        hjg hjg16 = new hjg(a.b("\u0828\u71aa\ufb66\u6515\ueedf", -883750804), a.b("\u199e\u6019\uead0\u74a6\uff23\u79d3\uc393\u4a7d\ud420\u5e8b\ud95f\u237c\uadea\u3454\ube0d\u38b8\u82bf\u0d69\u97c2\u11c4\u987e\ue237\u6c92\uf748\u717f\ufbe1\u425b\ucc4c\u56f2\ud0be\u5b59\ua5c1\u2f94\ub636\u3029\uba91\u0545\u8f26", 1217796577)).toggle(izx.ARMOR.enabled).settings(ixu.OPTIONS);
        hjg16.home = 0;
        hlu = List.of(object, hjg9, hjg10, hjg11, hjg12, hjg13, hjg14, hjg15, hjg16);
        hur hur2 = new hur();
        hjg hjg17 = new hjg(a.d("\ubf51\uc6cc\u4c1e\ud267\u59bf\udf00\u6547", 1105821329, 1722597764), a.c(-918286282, "\u1049\u69da\ue302\u7d62\uf6ac\u7014\uca51\u43ff\uddac\u574e\ud08b\u2aeb\ua43c\u3d90\ub7c4\u313c\u8b67\u04e5\u9e17\u1849\u91b4\ueba1\u6550\ufe8a\u78f2\uf229\u4b8d\uc581\u5f78\ud95a\u52d2\uac0a\u2656\ubfb0\u39a6\ub358\u0c8e\u86f4b\u9984\u13c5\u6d29\ue766\u609f\ufa09\u7439\ucda9\u4714\uc150\u5a80")).row(hur2).row(new hva()).row(new hvq(hur2));
        hjg17.wide = true;
        irk irk2 = new irk(a.d("\uec39\u95a0\u1f78\u8112", -1076211280, 909884864), () -> Flow.getInstance().getOpenGuiKey(), n -> Flow.getInstance().setOpenGuiKey(n), false);
        hjg hjg18 = new hjg(a.d("\u4e4d\u37c3\ubd14\u2378\ua8a9\u2e19\u9457", -957799645, 2093116710), a.c(771796920, "\uafce\ud64b\u5c99\uc2f3\u4966\ucf89\u75c8\ufc2e\u6262\ue896\u6f12\u9566\u1baa\u8206\u0844\u8ea3\u34bf\ubb3a\u2195\ua7c9\u2e7b\u546b\udada\u411c\uc77e\u4db0\uf410\u7a04\ue0b0\u66ed\ued5f\u1386\u99c69\u862d\u0ccb\ub303\u397f\ubfa7\u2658\uac53\ud2be\u58e0\udf14\u458e\ucbf7\u722f\uf885\u7e9f\ue50d\u6b71\u91a3\u1808\u9e4f\u04aa")).settings(List.of(ConfigManager.AUTO_SAVE, ConfigManager.LOAD_ON_START)).row(new ict(a.d("\u7c83\u051a\u8fc2\u11a8\u9a2a\u1cd0\ua68d\u2f60", 1150198634, 603512748), irk2));
        hjg18.home = 0;
        hjg hjg19 = new hjg(a.c(2006385436, "\u035a\u7ac4\uf014\u6e7f\ue5b9"), a.b("\ud12f\ua8ac\u2268\ubc0a\u37dc\ub129\u0b2e\u82c4\u1cd4\u963c\u11f9\ueb92\u6542\ufca1\u76b3\uf040\u4a0f\uc5d2\u5f7b\ud931\u50dc\u2ad5\ua46a\u3ff5\ub98b\u3341\u8aee\u04be\u9e4e\u1816\u93e2\u6d60\ue728\u7ec2\uf88c\u722a\ucdfc\u47c9\uc155\u58e5\ud2f4\uac51\u261e\ua1ae\u3b63\ub541\u0ce2\u8640", 729403724)).row(new iab(a.c(-1276006031, "\ub136\uc8a5\u4261\udc0d\u57c5\ud167"), () -> ConfigManager.active() != null ? ConfigManager.active() : wap.t(a.d("\uaad1\ud361\u59b3\uc7c9", -848074203, -1115176802)))).row(new iab(a.c(-1299063529, "\udd41\ua4c2\u2e06\ub064\u3bb2"), () -> String.valueOf(ConfigManager.list().size()))).row(new iab(a.d("\u30d9\u494f\uc389\u5ded\ud63b\u508c", 1763394684, 1760457968), () -> ewk.online() ? wap.s(a.c(-847508880, "\u0a05\u73be\uf97a\u6706\uecd7\u6a67"), a.b("\u2152\u5cf1\ud23c\u4c42\uc79f\u4125\ufb7c\u7282", 2011506024)) : wap.s(a.d("\u7eae\u0716\u8dc5\u13be\u986c\u1eda\ua482", -148016702, 1673727748), a.b("\u2530\u5cfb\ud628\u4826\uc3fa\u4542\uff15", -1322573559)))).row(new hiv(new hip(a.b("\ue228\u9bb3\u1177\u8f0b\u049f\u8260\u3832\ub1db", -1590828429), vhz.FOLDER, hlc::hpg)));
        hjg19.home = 1;
        hjg hjg20 = new hjg(a.b("\ue3fb\u9a6d\u10a5\u8ecb\u0512\u83bf\u39e6", -429005900), a.d("\ue04f\u99d1\u1307\u8d7a\u06a6\u800d\u3a0a\ub3bd\u2df1\ua75b\u2085\udae3\u5429\ucd9e\u47cc\uc120\u7b3c\uf4a2\u6e10\ue80f\u61b3\u1bec\u9543\u0e98\u88ba\u0265\ubbb9\u35c9\uaf35\u2921\ua2d9\u5c06\ud655\u4ffd\uc9ed\u435e\ufc86\u76b9\uf038\u698e\ue3ca\u9d75\u176b\u90d6\u0a0e\u8468\u3de2\ub707\u3154\uaa84\u24f0\ude28\u578b", -687659874, -73087833));
        for (hzq hzq2 : hzv.ALL) {
            hjg20.row(new ict(hzq2.name, hzq2.bind));
        }
        hjg20.home = 0;
        hlv = List.of(hjg17, hjg18, hjg19, hjg20);
        iui iui2 = new iui();
        hjg hjg21 = new hjg(a.b("\u3d53\u44c9\uce08\u502e\udbae\u5d09\ue742\u6eba\uf0fa\u7a4d\ufd99\u07f2", -1933558511), a.d("\uf23a\u8ba7\u0174\u9f18\u14d9\u9265\u2831\ua1cf\u3f85\ub525\u32e0\uc8c2\u465a\udff6\u55f7\ud36e\u690c\ue6ca\u7c6e\ufa74\u738d\u09a8\u872e\u1cfc\u9ac1\u105d\ua9ec\u27a4\ubd40\u3b07\ub0eb\u4e36\uc41c\u5dc6\udb8f\u512f\ueeef\u64cc\ue25e\u7bea\uf1b5\u8f53", 321512269, -1672539874)).row(iui2);
        hjg21.home = 0;
        hjg hjg22 = new hjg(a.b("\u7b7b\u02e7\u882e\u165c\u9d97\u1b2b\ua160", 1808890680), a.b("\u0b4f\u72d2\uf812\u667a\ueda3\u6b05\ud157\u58f5\uc6e3\u4c55\ucbc8\u31ed\ubf26\u269a\uac8c\u2a2a\u907d\u1fb1\u851c\u0345", -1962931434)).toggle(wlk.ENABLED).settings(wlk.DISPLAY);
        hjg22.home = 0;
        hjg hjg23 = new hjg(a.b("\u6247\u1bc0\u910b\u0f73\u84bb\u020c\ub858\u31b3\uafeb", 706634265), a.d("\u7c5a\u05d7\u8f05\u116e\u9aea\u1c0c\ua647\u2fab\ub1ea\u3b53\ubcca\u46b5\uc801\u519f\udbc9\u5d32\ue775\u68ef\uf213\u7443\ufdbf\u87ab\u094c\u9286\u14b6\u9e22\u2790\ua9cc\u3326", 457067506, -140494879)).row(new ivk(iui2));
        hjg23.home = 1;
        hlw = List.of(hjg21, hjg22, hjg23);
        hjg hjg24 = new hjg(a.d("\u2e25\u57b1\udd62\u4357\uc8c6\u4e63\uf42b\u7dd6\ue382\u6939", 593143733, -1572173349), a.c(-1476261834, "\u085a\u71d0\ufb5a\u6565\ueebd\u6800\ud25b\u5be1\uc5b0\u4f6e\uc880\u32a3\ubc39\u258c\uafd2\u2923\u9364\u1cbc\u864aX\u89a0\uf3f4\u7d4d\ue694\u60a0\uea30\u53c2\uddc3\u4728\uc174\u4adf\ub412\u3e4a\ua7e9\u21f3\uab45\u14dc\u9ef9\u1836\u818a\u0b90\u7536\uff7d\u78d1\ue218\u6c61")).row(new hxv());
        hjg24.home = 0;
        hjg hjg25 = new hjg(a.b("\ub74c\uced6\u4401\uda63\u51a4\ud70e", 830191364), a.b("\u8f4b\uf6c6\u7c18\ue271\u69ba\uef1c\u554e\udcec\u42f2\uc850\u4f9e\ub5f5\u3b39\ua282\u2895\uae3d\u1464\u9baf\u0147\u8718\u0e8c\u74f2\ufa44\u619f\ue7e8\u6d72\ud48e\u5ade\uc022\u4636\ucdd1\u331b\ub91b\u20ab\ua6fd\u2c4c\u93df\u19e1\u9f2f\u06cc\u8cc1\uf227\u787c\uffcf\u6501\ueb63", 371887925)).row(new ifj());
        hjg25.home = 0;
        hjg hjg26 = new hjg(a.b("\u0391\u7a0f\uf0d9\u6ea2\ue57d\u6387\ud992\u5077\uce33\u448e\uc356\u392d", -1229585442), a.d("\u8d64\uf4e9\u7e37\ue003\u6b92\ued37\u577f\ude82\u40d6\uca6d\u4dfa\ub7c0\u3919\ua0b4\u2abe\uac0e\u1644\u9995\u0331\u8533\u0c8b\u76c7\uf826\u63a5\ue5cd\u6f14\ud6a5\u58ed\uc209\u444e\ucfae\u312b\ubb78\u2284\ua492\u2e73\u91b8\u1bc4\u9d0f\u04a2\u8eea\uf049\u7a43\ufde4\u6729\ue90d\u509f\uda26\u5c6d\uc7f1\u49c3\ub307\u3aea\ubcb5\u2629\ua851\u13ee\u9563\u1f0a\u8692\u0838\u723d\uf58a\u7fd0\ue115\u68b2\ud2b2\u540d\ude5b\u41f1\ucb3e\u4d4e\ub496\u3e2e", -212839524, 1552408294)).toggle(hhf.CLICK).settings(hhf.CLICK_OPTIONS).row(new ict(a.b("\u8fda\uf65f\u7c97\ue2ea\u6936\uef8d\u559a\udc20\u4271\uc8dc", -1296199786), hzv.friendKey().bind)).unfolded();
        hjg26.home = 0;
        hjg hjg27 = new hjg(a.b("\u085c\u71d2\ufb05\u6569\ueeb8\u6808\ud246", 2098399252), a.b("\u162c\u6fb1\ue560\u7b1e\uf0ca\u766e\ucc69\u45d5\udb88\u5132\ud6f0\u2c98\ua246\u3be1\ub1e1\u375e\u8d1a\u02d8\u9878\u1e3e\u979b\ued8d\u6336\uf8a8\u7e91\uf449\u4de7\uc3e4\u5955\udf10\u54b8\uaa65\u2021\ub9da\u3f9e", 1420826188)).settings(hhf.OPTIONS);
        hjg27.home = 0;
        hjg hjg28 = new hjg(a.b("\u9094\ue911\u63d9\ufda4\u7678\uf0c3\u4a87", 68718805), a.c(1073911263, "\u95b1\uec33\u66f3\uf895\u7349\uf5f6\u4fba\uc646\u580e\ud2a8\u5532\uaf4f\u21da\ub870\u327a\ub4c5\u0e85\u8158\u1be3\u9df9\u1400\u6e39\ue0ad\u7b65\ufd09\u77cf\uce2e\u4030\udac6\u5c9c\ud76a\u29ef\ua3bb\u3a05\ubc04\u36a2\u897d\u030e\u85c4\u1c66\u967c\ue8c4\u628a")).row(new hyj());
        hjg28.home = 1;
        hjg hjg29 = new hjg(a.c(-1729426625, "\u0b6a\u72ea\uf82a\u665d\ued87"), a.b("\ubb8c\uc20b\u48c2\ud6b4\u5d31\udbc3\u619c\ue866\u7638\ufcd6\u7b1f\u813d\u0ffc\u9646\u1c1f\u9aaa\u20ac\uaf60\u3587\ub382\u3a6e\u4070\uce82\u5512\ud32b\u59ee\ue046\u6e1b\uf4e7\u72bc\uf945\u079a\u8dba\u1476\u9277\u188f\ua75f\u2d36\uabfa\u3256\ub818\uc6ac\u4cab\ucb06\u51dc\udfa1\u6669\uecd9", 103463909)).toggle(ucg.ENABLED).row(new ike()).row(new iks());
        hjg29.home = 0;
        hjg hjg30 = new hjg(a.b("\uf5e1\u8c61\u06a1\u98d6\u130c\u95e4\u2ffa\ua603\u3854\ub2ea\u353e\ucf58\u418e", 1993471420), a.b("\u1627\u6fb1\ue57a\u7b14\uf0de\u767e\ucc3b\u4599\udb87\u5139\ud6e0\u2cd5\ua255\u3bfb\ub1af\u3711\u8d17\u02dc\u983c\u1e24\u97d4\uedc5\u6378\uf8c4\u7e97\uf455\u4dff\uc3b6\u5908\udf43\u54a4\uaa69\u202b\ub99f\u3f81\ub53c\u0af8\u8090\u0608\u9ff2\u15a3\u6b4e", 1322456644)).row(new ild());
        hjg30.home = 1;
        hjg hjg31 = new hjg(a.b("\u1100\u6880\ue240\u7c37\uf7ed\u7105\ucb05\u42e2\udcac\u561d\ud1d3\u2ba5\ua57b\u3cde", -1379921570), a.b("\ufd5e\u84c3\u0e03\u906b\u1ba4\u9d48\u2715\uae80\u30f4\uba5f\u3d9b\uc7e4\u493a\ud0ce\u5acd\udc3e\u6666\ue9a1\u7312\uf50a\u7ce7\u06f2\u8844\u139a\u95ec\u1f3f\ua69b\u2896\ub26f\u345b\ubfdb\u4119\ucb41\u52bb\ud4e5\u5e48\ue19e\u6be8\ued32\u74c4\ufed2\u8039\u0a39\u8dcd\u1711\u996a\u20f0\uaa18\u2c4c\ub7df\u39e4\uc33e\u4a83\ucc96\u5620\ud87a\u63c8\ue508\u6f70\uf6a8\u781b\u025b\u85a9", -612958932)).settings(ucg.OPTIONS).row(new ict(a.b("\udeaa\ua737\u2df7\ub39f\u3803\ubef9\u04a4\u8d49", -1450257), hzv.partyMarkKey().bind));
        hjg31.home = 1;
        hlx = List.of(hjg29, hjg24, hjg26, hjg25, hjg27, hjg30, hjg28, hjg31);
        hjg hjg32 = new hjg(a.d("\ua80c\ud191\u5b5e\uc531\u4eee\uc84e\u7200\ufbfb\u65b4", 1017010501, 2128670979), a.b("\u84d0\ufd5f\u778b\ue9f3\u6230\ue4de\u5e81\ud720\u496a\uc3ca\u441e\ube30\u30eb\ua912\u2348\ua5ac\u1fe4\u906a\u0ad5\u8cc6\u0532\u7f61\uf1da\u6a10\uec7e\u66ad\udf16\u515f\ucbfb\u4deb\uc657\u388c\ub287\u2b35\uad64\u27c4\u9806\u1261\u94ef\u0d50\u877c\uf9bb\u73e8\uf452\u6ecb\ue0f3\u5927\ud3d8\u55f1\uce53\u4039\ubae4\u331a\ub54c\u2ff1\ua1f4\u1a57\u9c8b\u16bd\u8f25\u0195\u7bdc\ufc3c\u7666\ue8b3\u6119\udb57\u5dad\ud7a3\u4853\uc28f\u44f4\ubd6f\u379c\ua9d4\u227c\ua472\u1ed5\u971c\u096a\u83f7\u05f6\u7e54\uf096\u6ae7\ue33b", -2072935215)).toggle(Cosmetics.ENABLED).settings(Cosmetics.OPTIONS).row(new hiv(a.c(1437213168, "\u21b7\u5833\ud2ea\u4c95\uc707\u41f3\ufbb3\u7251\uec19\u66a3\ue17d\u1b10\u95c6\u0c70\u862a\u009c\uba9c\u3544\uaff7"), vhz.RESET, Cosmetics::clearAll)).unfolded();
        hjg32.wide = true;
        ArrayList<hjg> arrayList = new ArrayList<hjg>();
        arrayList.add(hjg32);
        for (String[] stringArray : stringArrayArray = new String[][]{{a.b("\ue828\u918e\u1b4a\u852e\u0eec\u884e", 1217325135), a.c(1602922647, "\ua8d1\ud157\u5b93\uc5f7\u4e35\uc897\u72c5"), a.c(-1770745891, "\u8fcc\uf64a\u7c8c\ue2e1\u693b\uef88\u55dd\udc3a\u4236\uc8de\u4f1b\ub570\u3ba0\ua243\u2847\uaea9\u14e1\u9b33\u0189\u879d\u0e3a\u7477\ufac9\u6100\ue763\u6da5\ud444\u5a58\uc0ad\u46f7\ucd45\u339d\ub984\u206f\ua67d\u2cc3\u9313\u1966\u9fb9\u061d\u8c5f\uf2a8\u78fa\uff56\u65de\ueba3\u5220\ud889\u5ed7\uc50c\u4b65\ub1be\u3819\ube1b\u24a9\uaaf7\u1142\u97d7\u1df4\u8434\u0a90\u70c7\uf729\u7d72\ue3b2\u6a0a\ud04f")}, {a.b("\u5c7d\u25d2\uaf06\u317e\ubabd", 2129878031), a.d("\u257a\u5cf5\ud621\u4859\uc39a", 1867974363, 1837179891), a.b("\uc631\ubfaf\u3579\uab02\u20dd\ua627\u1c20\u95ca\u0bda\u813b\u06ed\ufc9d\u721e\uebe0\u61b2\ue701\u5d42\ud2d0\u486c\uce38\u47c5\u3d9c\ub364\u28f4\uae8d\u245a\u9de1\u13b7\u890e\u0f0b\u84a3\u7a3d\uf026\u69c2\uef9b\u6524\udab6\u5088\ud652\u4fe3", 10733146)}, {a.c(380102869, "\ue8a6\u9102\u1bc0"), a.d("\u8320\ufaa4\u7066\uee10", -1938261083, 1757542609), a.b("\u733d\u0ab7\u803d\u1e15\u95d4\u137f\ua92b\u2088\ube84\u342e\ub3fa\u4991\uc75f\u5ee6\ud4b4\u5252\ue843\u679e\ufd62\u7b2e\uf28b\u8888\u063c\u9df6\u1b89\u915f\u28eb\ua6b3\u3c03\uba13\u31a7\ucf64\u453a\udcdc\u5add\ud035\u6ff4\ue59f\u6319\ufae7\u70b9\u0e06\u8401\u03ac\u9976\u1742\uaed6\u2472\ua220\u39eb\ub783\u4d58\uc4b1\u42fa\ud879\u561d\uedb3\u6b36\ue108\u78db\uf667\u8c37\u0b81\u8191\u1f5d\u96e1\u2cab\uaa49", -1681755333)}, {a.d("\u3964\u40dc\uca1a", -1996207927, 2077848006), a.c(1744382818, "\u2b2e\u52b6\ud870\u4606"), a.c(1185687239, "\u2693\u5f03\ud59e\u4bb6\uc077\u46dc\ufc88\u752b\ueb3c\u6180\ue657\u1c23\u92bc\u0b01\u8106\u07f6\ubdbe\u3273\ua8dd\u2edf\ua77f\udd30\u539e\uc853\u4e64\uc4fc\u7d52")}, {a.c(-527808851, "\u46cf\u3f79\ub5a8\u2bdf"), a.b("\ub513\ucc89\u4657\ud834\u53e3\ud544\u6f01", 2003678547), a.d("\ue7ef\u9e7f\u14e2\u8aca\u010b\u87a0\u3df4\ub457\u2a4e\ua0f8\u2729\udd5e\u53c0\uca7d\u4079\uc690\u7cc2\uf30f\u69f2\ueff7\u661b\u1c42\u92f3\u0933\u8f50\u058c\ubc28\u322b\ua88b\u2ec4\ua56a\u5ba7\ud1a0\u4810\uce4c\u44ea\ufb64\u715d\uf787\u6e23", 326968481, 1668203305)}, {a.b("\u19ca\u6078\ueaa9\u74d0", -893314644), a.c(-20869273, "\u8f2c\uf6be\u7c6f\ue216\u69da\uef7a\u552b\udcd2\u4295"), a.b("\u362e\u4fbe\uc523\u5b0b\ud0ca\u5661\uec35\u6596\ufb8b\u7139\uf6e8\u0c91\u8201\u1bbc\u91b8\u1757\uad05\u22c8\ub833\u3e35\ub7dc\ucd8a\u4330\ud8f5\u5ed9\ud447\u6de9\ue3ea\u794a\uff05\u74ab\u8a66.\u99c5\u1f97", -1968949694)}, {a.b("\u2b1d\u52ae\ud86c\u4608", -1660671110), a.c(-1938407675, "\u3f43\u46d0\ucc12\u5276\ud9b7"), a.d("\u421f\u3b81\ub155\u2f20\ua4fb\u225f\u981d\u11ed\u8ff6\u0506\u82da\u78a1\uf632\u6fcf\ue599\u6377\ud92b\u56bf\ucc5a\u4a14\uc3ee\ub9be\u3707\uac99\u2aa5\ua076\u19d4\u9790\u0d71\u8b7f\u00c0\ufe43\u741b\uedff\u6bb0\ue10c\u5ed9\ud4ae\u5238\ucbd0\u4199\u3f72\ub526\u32c5\ua85d\u2634\u9ffe\u1501\u930d\u08de\u86bc\u7c78\uf58a\u738c\ue960\u6730\udc8a\u5a52\ud064\u49e2\uc74d\ubd01\u3aee", 795116135, 772718598)}}) {
            hjg hjg33 = new hjg(stringArray[1], stringArray[2]).row(new hwr(stringArray[0])).unfolded();
            hjg33.wide = true;
            arrayList.add(hjg33);
        }
        hly = List.copyOf(arrayList);
    }

    private static void hpg() {
        Thread thread = new Thread(ewk::flushNow, a.b("\u1002\u6999\ue349\u7d20\uf6b2\u7011\uca01\u43ff\udda3\u5708\ud0ca\u2aff\ua47b\u3dc0\ub784\u3178", -1738993580));
        thread.setDaemon(true);
        thread.start();
    }

    public static vhz iconFor(kfa kfa2) {
        return switch (kfa2) {
            default -> throw new MatchException(null, null);
            case kfa.COMBAT -> vhz.COMBAT;
            case kfa.MOVEMENT -> vhz.MOVEMENT;
            case kfa.PLAYER -> vhz.PLAYER;
            case kfa.RENDER -> vhz.RENDER;
            case kfa.MISC -> vhz.MISC;
        };
    }

    private static int hph(kfa kfa2) {
        int n = 0;
        for (kfe kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            if (!kfe2.isEnabled() || kfe2.isHidden() || kfa2 != null && kfe2.getCategory() != kfa2) continue;
            ++n;
        }
        return n;
    }

    private float hpi() {
        float f = Math.min(((float)this.field_22789 - 16.0f) / 540.0f, ((float)this.field_22790 - 16.0f) / 409.0f);
        return Math.max(0.3f, Math.min((float)iov.SCALE.get(), f));
    }

    private void hpj() {
        if (this.field_22789 < 64 || this.field_22790 < 64) {
            return;
        }
        float f = this.hpi();
        float f2 = 540.0f * f;
        float f3 = 409.0f * f;
        if (Float.isNaN(hlp) || Float.isNaN(hlq)) {
            hlp = ((float)this.field_22789 - f2) * 0.5f;
            hlq = ((float)this.field_22790 - f3) * 0.5f;
        }
        hlp = Math.max(60.0f - f2, Math.min((float)this.field_22789 - 60.0f, hlp));
        hlq = Math.max(0.0f, Math.min((float)this.field_22790 - 30.0f, hlq));
    }

    private static List<kfe> hpk(List<kfe> list) {
        ArrayList<kfe> arrayList = new ArrayList<kfe>(list);
        arrayList.removeIf(kfe::isHidden);
        arrayList.sort(Comparator.comparing(kfe2 -> kfe2.getName().toLowerCase(Locale.ROOT)));
        return arrayList;
    }

    private List<hjg> hpl(hkv hkv2) {
        return switch (hkv2.hkz.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1 -> hlt;
            case 2 -> hlu;
            case 3 -> hlv;
            case 4 -> hlw;
            case 5 -> hlx;
            case 6 -> hly;
            case 0 -> {
                ArrayList<hjg> var2_2 = new ArrayList<hjg>();
                for (kfe var4_4 : hlc.hpk(Flow.getInstance().getModuleManager().getByCategory(hkv2.hky))) {
                    var2_2.add(hls.get(var4_4));
                }
                yield var2_2;
            }
        };
    }

    private void hpm(boolean bl) {
        ArrayList<hjg> arrayList = new ArrayList<hjg>();
        HashSet<hjg> hashSet = new HashSet<hjg>();
        if (!this.hod.isEmpty()) {
            Iterator iterator2 = this.hod.trim();
            ArrayList<hjg> object = new ArrayList<hjg>();
            for (kfe kfe2 : hlc.hpk(Flow.getInstance().getModuleManager().getModules())) {
                object.add(hls.get(kfe2));
            }
            for (List list : List.of(hlt, hlu, hlv, hlw, hlx, hly)) {
                object.addAll(list);
            }
            HashMap hashMap = new HashMap();
            for (hjg hjg3 : object) {
                int n = hlc.hpn(hjg3, iterator2);
                if (n <= 0) continue;
                arrayList.add(hjg3);
                hashMap.put(hjg3, n);
                if (n > 60 || n <= 40 || !hjg3.isCollapsed() && !hob.contains(hjg3)) continue;
                hashSet.add(hjg3);
            }
            if (hashSet.size() > 4) {
                hashSet.clear();
            }
            arrayList.sort(Comparator.comparingInt(hjg2 -> -((Integer)hashMap.get(hjg2)).intValue()));
        } else {
            arrayList.addAll(this.hpl(this.hlz.get(hln)));
        }
        for (hjg hjg4 : hob) {
            if (hashSet.contains(hjg4)) continue;
            hjg4.setCollapsed(true);
        }
        for (hjg hjg5 : hashSet) {
            hjg5.setCollapsed(false);
        }
        hob.clear();
        hob.addAll(hashSet);
        boolean bl2 = !arrayList.equals(this.hmb);
        this.hmb = arrayList;
        this.hpo();
        if (bl2 && bl) {
            this.hmd.restart();
            this.hmp = 0.0f;
            this.hml.set(0.0f);
        }
    }

    private static int hpn(hjg hjg2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        if (hjg2.module != null) {
            stringBuilder.append(wap.both(hjg2.module.getCategory().title()));
        }
        for (imn object2 : hjg2.rows) {
            if (object2.setting == null || object2.targetHeight() <= 0.0f) continue;
            stringBuilder.append(' ').append(wap.both(object2.setting.getName()));
            vmo vmo2 = object2.setting;
            if (!(vmo2 instanceof vlv)) continue;
            vlv vlv2 = (vlv)vmo2;
            if (object2.setting instanceof vla) continue;
            for (String string2 : vlv2.getModes()) {
                stringBuilder.append(' ').append(wap.both(string2));
            }
        }
        String string3 = hjg2.module != null ? hjg2.module.getName() : hjg2.title;
        String string4 = hjg2.module != null ? wap.aliases(string3) : null;
        return wap.score(string, wap.names(string3), string4, stringBuilder.toString(), hjg2.searchDescription());
    }

    private void hpo() {
        int n;
        boolean bl;
        boolean bl2 = bl = this.hod.isEmpty() && this.hlz.get((int)hlc.hln).hkz != hks.MODULES;
        if (bl) {
            for (hjg hjg2 : this.hmb) {
                hjg2.column = Math.max(0, hjg2.home);
            }
            return;
        }
        int n2 = this.hmb.size();
        float f = 0.0f;
        for (hjg hjg3 : this.hmb) {
            f += hjg3.targetHeight() + 10.0f;
        }
        int n3 = n2;
        float f2 = 0.0f;
        float f3 = Float.MAX_VALUE;
        for (n = 0; n <= n2; ++n) {
            float f4 = Math.max(f2, f - f2);
            if (f4 <= f3 + 0.01f) {
                f3 = f4;
                n3 = n;
            }
            if (n >= n2) continue;
            f2 += this.hmb.get(n).targetHeight() + 10.0f;
        }
        for (n = 0; n < n2; ++n) {
            this.hmb.get((int)n).column = n < n3 ? 0 : 1;
        }
    }

    private void hpp() {
        if (this.hod.isEmpty() && !this.hlz.isEmpty()) {
            hlr.put(this.hlz.get((int)hlc.hln).hkw, Float.valueOf(this.hmp));
        }
    }

    private void hpq() {
        float f;
        this.hmp = f = hlr.getOrDefault(this.hlz.get((int)hlc.hln).hkw, Float.valueOf(0.0f)).floatValue();
        this.hml.set(f);
    }

    boolean canHover() {
        return !this.hmx && !this.hpr() && !this.hmz && this.hnc == null && this.hnf == null;
    }

    private boolean hpr() {
        return this.hnd != null && !this.hnd.closing();
    }

    boolean isDragging(imn imn2) {
        return this.hnc == imn2;
    }

    void startDrag(imn imn2) {
        this.hnc = imn2;
    }

    boolean isDropdownFor(vlv vlv2) {
        return this.hnd != null && !this.hnd.closing() && this.hnd.mode == vlv2;
    }

    void openDropdown(vlv vlv2, float f, float f2, float f3, float f4) {
        this.hnd = new hxi(vlv2, f, f2, f3, f4, 403.0f);
    }

    void openPicker(vlj vlj2) {
        this.hnd = null;
        ibf ibf2 = new ibf(vlj2, 540.0f, 409.0f);
        this.hne = ibf2;
        this.focus(ibf2.search);
    }

    void openOverlay(ijy ijy2) {
        this.hnd = null;
        this.hne = ijy2;
        this.focus(ijy2.field());
    }

    private boolean hps() {
        return this.hne != null && !this.hne.closing();
    }

    irk binding() {
        return this.hnf;
    }

    void startBinding(irk irk2) {
        this.hnf = irk2;
        this.hnh = -1;
        this.focus(null);
        this.hng = (irk2.clearable() ? wap.s(a.d("\u2606\u5f95\ud551\u4b36\uc0e1\u4603\ufc11\u75a1\uebb5\u610a\ue6c5\u1ced\u9232\u0be8\u818c\u077b\ubd2a\u32b7\ua80b\u2e55\ua7d1\uddbb\u5309\uc8d7\u4eba\uc43f\u7d83\uf3dd\u694b\uef37\u649c\u9a19\u105d\u89a7\u0fbf\u8500\u3acb\ub0e3\u3667\uafce\u258c\u5b64\ud12f\u56c4\ucc1a\u4224\ufbea\u7109\uf70b\u6cd8\ue2b1\u1866\u91c7\u17d3\u8d62\u0324\ub89a\u3e4b\ub423\u2df3\ua30a\ud91d\u5ee7\ud4ab\u4a36", 176670650, 1154277805), a.b("\ufc37\u85ab\u0f7e\u9105\u1ad6\u9c1d\u2639\uabdd\u3198\ubb2e\u3cfe\uc68e\u485c\ud194\u5fa4\ud95d\u6706\ue8d5\u726e\uf434\u7dc0\u038f\u8d5f\u16b9\u90c0\u1a0f\ua3f0\u2dae\ub756\u3174\ubafc\u442c\uce6c\u578f\ud188\u5b36\ue4ee\u6efe\ue800\u71a9\ufba2\u8558\u0f00\u8cab\u167b\u9809\u21db\uab6f\u2d2a\ub2e2\u3c98\uc251\u4be5\ucdb7\u535c\ud917\u62af\ue47d\u6e0f\uf7db\u7915\u0727\u84c8\u0eee\u9022\u19e3\ua7a8\u254d\uaf15\u30d0\ube6c", 1327560813)) : wap.s(a.d("\u23ec\u5a7f\ud0bb\u4edc\uc50b\u43e9\uf9fb\u704b\uee5f\u64e0\ue32f\u1907\u9796\u0e2e\u8460\u02c3", 848639040, 863901676), a.c(-27743035, "\ua8cb\ud157\u5b82\uc5f9\u4e2a\uc8e1\u72c5\uff21\u6564\uefd2\u6802\u9272\u1ca0\u8568\u0b58\u89bd\u33fd\ubc58\u2284"))) + wap.t(irk2.name()) + (irk2.clearable() ? wap.s(a.d("\u1bd1\u6260\ue824\u76c2\ufd15\u7bc1\uc1a4\u4845\ud659\u5cab\udb77\u210f\uafdc\u367e\ubc2c", 740210913, -627596513), a.c(767408464, "\ub963\uc0d2\u4a96\ud470\u5fa7\ud973\u6316\ueaf7\u74eb\ude6e\u7989\u8799\u093e\u90fe\u1ad3\u9c5d\u266b\ua9c0\u337d")) : wap.s(a.c(923389750, "\ucf06\ub6b7\u3cf3\ua215\u29c2\uaf16\u1573\u9c92\u028e\u887c\u0fad\uf5d3\u7b09\ue2be\u68e4\uee0a"), a.b("\u3c8b\u453a\ucf7e\u5198\uda4f\u5c9b\ue6fe\u6f1f\uf103\u5b86\ufc61\u020e\u8ca5\u156a\u9f30\u19c9\ua38b", 532298938)));
    }

    private void hpt(int n) {
        List list;
        this.hnf.set(n);
        List<Object> list2 = list = this.hnf.clearable() ? hzv.boundTo(n, this.hnf.name()) : List.of();
        if (!list.isEmpty()) {
            this.toast(irr.keyName(n) + wap.s(a.c(431181292, "\u4dc7\u3437\ubee9\u2087\uab4c\u2db2\u97b3\u1e45\u8001\u0aad\u8d2d"), a.b("\u3e46\u4395\uc934\u574f\udc94\u5a26\ue460\u6986\uf7de\u7d60\ufacf\u00bc\u8e10\u17ab\u9dfd\u1b7b\ua556", 623066743)) + String.join((CharSequence)a.d("\u2a57\u53ea", -239454005, 343872178), list), vhz.KEYBOARD, false);
        }
        this.hnf = null;
    }

    iah focusedField() {
        return this.hof;
    }

    public boolean typing() {
        return this.hof != null || this.hnf != null;
    }

    void focus(iah iah2) {
        this.hof = iah2;
        if (iah2 != null) {
            iah2.focusGained();
        }
    }

    void toast(String string, vhz vhz2, boolean bl) {
        this.hni = string;
        this.hnj = vhz2;
        this.hnk = bl;
        this.hnl = System.currentTimeMillis() + (bl ? 3200L : 2200L);
        this.hmo.set(1.0f);
    }

    void hint(String string) {
        this.hnn = string;
    }

    private void hpu(DrawContext drawContext) {
        unf.observe(drawContext);
        if (unf.frame() == this.hoo) {
            return;
        }
        this.hoo = unf.frame();
        this.hop = unf.delta() * (float)iov.ANIMATION.get();
        this.hnm = this.hnn;
        this.hnn = null;
        iov.update(this.hop);
        this.hmc.update(this.hop);
        this.hmd.update(this.hop);
        this.hme.update(this.hop);
        this.hmf.update(this.hop);
        if (this.hnd != null && this.hnd.gone()) {
            this.hnd = null;
        }
        if (this.hne != null && this.hne.gone()) {
            if (this.hof == this.hne.field()) {
                this.hof = null;
            }
            this.hne = null;
        }
        if (this.hmx && this.hmc.finished() && !this.hmy && this.field_22787 != null) {
            this.hmy = true;
            this.field_22787.method_63588(() -> hlc.super.method_25419());
        }
    }

    private float hpv() {
        float f = this.hmc.linear();
        return this.hmx ? vcq.outCubic(f) : vcq.outQuint(f);
    }

    public void method_25420(DrawContext drawContext, int n, int n2, float f) {
        uut.beginFrame();
        this.hpu(drawContext);
        float f2 = this.hpv();
        float f3 = (float)iov.DIM.get();
        if (this.field_22787 != null && this.field_22787.field_1687 != null) {
            this.hpw();
            float f4 = Math.max(1, this.field_22787.method_22683().method_4495());
            float f5 = this.hpi();
            this.how = isv.frame(Math.round(540.0f * f5 * f4), Math.round(409.0f * f5 * f4));
            GpuTextureView gpuTextureView = null;
            if (this.how != null) {
                gpuTextureView = ujw.worldWith(this.how, this.hos * f4, this.hot * f4, (this.hos + 540.0f * this.hoq) * f4, (this.hot + 409.0f * this.hor) * f4, f2, iov.photoTone());
            }
            hyv.capture(drawContext, iov.BG_BLUR.getInt(), f2, gpuTextureView);
            uut.gradientV(drawContext, 0.0f, 0.0f, this.field_22789, this.field_22790, 0.0f, ujt.withAlpha(0, (int)(255.0f * f3 * 0.65f * f2)), ujt.withAlpha(0, (int)(255.0f * f3 * f2)));
            swh.renderInMenu(drawContext);
            izx.renderInMenu(drawContext, this.hod.isEmpty() && this.hlz.get((int)hlc.hln).hkz == hks.HUD);
        } else {
            this.how = null;
            hyv.skip();
            this.method_57728(drawContext, f);
            if (iov.BG_BLUR.getInt() > 0) {
                drawContext.method_71278();
            }
            uut.rect(drawContext, 0.0f, 0.0f, this.field_22789, this.field_22790, ujt.withAlpha(0, (int)(255.0f * Math.max(0.3f, f3) * f2)));
        }
    }

    private void hpw() {
        float f = this.hpv();
        float f2 = this.hpi();
        this.hoq = f2 * (0.95f + 0.05f * f);
        this.hor = this.hoq * (0.93f + 0.07f * f);
        float f3 = hlp + 540.0f * f2 * 0.5f;
        float f4 = hlq + 409.0f * f2 * 0.5f + (1.0f - f) * 10.0f;
        this.hos = f3 - 270.0f * this.hoq;
        this.hot = f4 - 204.5f * this.hor;
        if (f >= 0.999f && f2 == 1.0f && this.field_22787 != null) {
            float f5 = Math.max(1, this.field_22787.method_22683().method_4495());
            this.hos = (float)Math.round(this.hos * f5) / f5;
            this.hot = (float)Math.round(this.hot * f5) / f5;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(DrawContext drawContext, int n, int n2, float f) {
        this.hpu(drawContext);
        float f2 = this.hpv();
        float f3 = this.hpi();
        this.hpw();
        this.hou = this.hpx(n);
        this.hov = this.hpy(n2);
        vdn.setRenderScale(f3);
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(this.hos, this.hot);
        drawContext.method_51448().scale(this.hoq, this.hor);
        uut.pushAlpha(f2);
        try {
            this.hpz(drawContext);
        }
        finally {
            uut.popAlpha();
            drawContext.method_51448().popMatrix();
            vdn.setRenderScale(1.0f);
        }
    }

    private float hpx(double d) {
        return (float)((d - (double)this.hos) / (double)this.hoq);
    }

    private float hpy(double d) {
        return (float)((d - (double)this.hot) / (double)this.hor);
    }

    private void hpz(DrawContext drawContext) {
        boolean bl;
        float f = this.hne != null ? -10000.0f : this.hou;
        float f2 = this.hne != null ? -10000.0f : this.hov;
        float f3 = iov.r(12.0f);
        float f4 = iov.lightness();
        float f5 = 2.5f + 1.5f * this.hpv();
        uut.shadow(drawContext, 0.0f, 2.0f, 540.0f, 409.0f, f3, 4.0f, ujt.withAlpha(0, Math.round(90.0f - 50.0f * f4)));
        uut.shadow(drawContext, 0.0f, 4.0f + 3.0f * f5, 540.0f, 409.0f, f3, 12.0f + 6.0f * f5, iov.shadow);
        if (this.how != null) {
            uut.image(drawContext, this.how, 0.0f, 0.0f, 540.0f, 409.0f, f3, iov.photoTone());
            uut.round(drawContext, 0.0f, 0.0f, 540.0f, 409.0f, f3, hyv.tint(iov.window, iov.photoDarken()));
            uut.round(drawContext, 0.0f, 0.0f, 136.0f, 409.0f, f3, 0.0f, 0.0f, f3, hyv.tint(iov.window, 0.4f));
            bl = false;
        } else {
            bl = hyv.surface(drawContext, 0.0f, 0.0f, 540.0f, 409.0f, f3, hyv.tint(iov.window, iov.windowTint()), ujt.withAlpha(iov.window, 255), (float)hyv.EDGE.get(), hyv.WINDOW);
        }
        uut.round(drawContext, 0.0f, 0.0f, 136.0f, 409.0f, f3, 0.0f, 0.0f, f3, iov.panel);
        uut.rect(drawContext, 136.0f, 0.0f, 1.0f, 409.0f, iov.divider);
        ukf.sheen(drawContext, 0.0f, 0.0f, 540.0f, 90.0f, f3, 0.8f * (1.0f - 0.7f * f4));
        if (!bl || !hyv.liquid()) {
            uut.outline(drawContext, 0.0f, 0.0f, 540.0f, 409.0f, f3, 1.0f, bl || this.how != null ? ujt.withAlpha(0xFFFFFF, 24) : iov.stroke);
        }
        ukf.rim(drawContext, 0.0f, 0.0f, 540.0f, 409.0f, f3, f4, 1.1f);
        this.hqc(drawContext, f, f2);
        this.hqx(drawContext, f, f2);
        this.hrd(drawContext, f, f2);
        this.hrf(drawContext, f, f2);
        if (this.hnd != null) {
            this.hnd.render(drawContext, f, f2, this.hop);
        }
        this.hqr(drawContext, f, f2);
        this.hqq(drawContext);
        if (this.hne != null) {
            this.hne.render(drawContext, this, this.hou, this.hov, this.hop, 540.0f, 409.0f);
        }
        this.hrh(drawContext);
    }

    private float hqa(int n) {
        if (n < this.hma) {
            return 62.0f + (float)n * 25.0f;
        }
        return this.hqb() + (float)(n - this.hma) * 25.0f;
    }

    private float hqb() {
        return 62.0f + (float)this.hma * 25.0f + 20.0f;
    }

    private void hqc(DrawContext drawContext, float f, float f2) {
        float f3 = 24.0f;
        float f4 = 19.0f;
        if (!uqe.draw(drawContext, 13.0f, f3 - f4 * 0.5f, f4, iov.isLight(), -1) && !upt.draw(drawContext, 15.0f, f3 - 8.5f, 17.0f, iov.logoTint())) {
            vjf.draw(drawContext, vhz.LOGO, 23.0f, f3, 13.0f, iov.accent());
        }
        irr.LOGO.draw(drawContext, irr.LOGO.ellipsize(vvi.get(), 94.0f), 35.0f, irr.LOGO.centerTop(f3), iov.text);
        uut.rect(drawContext, 16.0f, this.hqb() - 11.0f, 104.0f, 1.0f, iov.divider);
        boolean bl = !this.hod.isEmpty();
        float f5 = this.hmg.step(this.hqa(hln), this.hop);
        float f6 = 120.0f;
        float f7 = iov.r(6.0f);
        uut.pushAlpha(bl ? 0.35f : 1.0f);
        float f8 = iov.lightness();
        ukf.shadow(drawContext, 8.0f, f5, f6, 23.0f, f7, 0.9f, f8);
        boolean bl2 = hyv.surface(drawContext, 8.0f, f5, f6, 23.0f, f7, hyv.tint(iov.window, Math.min(0.92f, iov.windowTint() * 0.85f)), ujt.lerp(iov.fieldHover, -1, 0.9f * f8), 11.5f, hyv.TABS);
        if (bl2) {
            int n = ujt.withAlpha(ujt.lerp(-1, iov.accent(), 0.5f), 24);
            uut.round(drawContext, 8.0f, f5, f6, 23.0f, f7, ujt.lerp(n, -2130706433, f8));
        }
        ukf.sheen(drawContext, 8.0f, f5, f6, 23.0f, f7, 1.4f * (1.0f - 0.7f * f8));
        ukf.rim(drawContext, 8.0f, f5, f6, 23.0f, f7, f8, 1.2f);
        uut.round(drawContext, 8.0f, f5 + 11.5f - 4.0f, 2.0f, 8.0f, 1.0f, iov.accent());
        uut.popAlpha();
        float f9 = this.hmc.linear();
        for (int i = 0; i < this.hlz.size(); ++i) {
            int n;
            hkv hkv2 = this.hlz.get(i);
            float f10 = this.hqa(i);
            float f11 = vcq.outCubic((f9 * 1.5f - (float)i * 0.045f) / 0.55f);
            boolean bl3 = this.canHover() && irr.inside(f, f2, 8.0f, f10, f6, 23.0f);
            float f12 = this.hmh.get(i).step(bl3, this.hop);
            float f13 = i == hln && !bl ? 1.0f : 0.0f;
            uut.pushAlpha(f11);
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate(-(1.0f - f11) * 10.0f, 0.0f);
            if (f12 > 0.01f && f13 < 1.0f) {
                uut.round(drawContext, 8.0f, f10, f6, 23.0f, f7, ujt.withAlpha(iov.hover, Math.round((float)ujt.alpha(iov.hover) * f12)));
            }
            float f14 = f10 + 11.5f;
            float f15 = this.hmi.get(i).step(0.0f, this.hop);
            int n2 = ujt.lerp(ujt.lerp(iov.textMuted, iov.textDim, f12), iov.text, f13);
            vjf.draw(drawContext, hkv2.hkx, 25.0f + f12 * 0.5f, f14, 9.5f * (1.0f + 0.2f * f15), n2);
            irr.TAB.draw(drawContext, wap.t(hkv2.hkw), 37.0f + f12 * 1.5f, irr.TAB.centerTop(f14), ujt.lerp(iov.textDim, iov.text, Math.max(f13, f12)));
            int n3 = hkv2.hky != null ? hlc.hph(hkv2.hky) : (hkv2.hkz == hks.WAYPOINTS ? wlk.inWorld().size() : (hkv2.hkz == hks.FRIENDS ? hhf.all().size() : (hkv2.hkz == hks.HUD ? izx.enabledCount() : (n = hkv2.hkz == hks.COSMETICS ? Cosmetics.wornCount() : 0))));
            if (n != this.hmk[i]) {
                this.hmk[i] = n;
                this.hmj.get(i).set(1.0f);
            }
            float f16 = this.hmj.get(i).step(0.0f, this.hop);
            if (n > 0) {
                String string = String.valueOf(n);
                float f17 = 1.0f + 0.25f * f16;
                drawContext.method_51448().pushMatrix();
                drawContext.method_51448().translate(116.0f, f14);
                drawContext.method_51448().scale(f17, f17);
                irr.SMALL.drawCentered(drawContext, string, 0.0f, irr.SMALL.centerTop(0.0f), ujt.lerp(iov.textMuted, iov.text, Math.max(f16, f13 * 0.6f)));
                drawContext.method_51448().popMatrix();
            }
            drawContext.method_51448().popMatrix();
            uut.popAlpha();
        }
        this.hqm(drawContext, f, f2);
    }

    private float hqd() {
        return 365.0f;
    }

    private float hqe() {
        return 26.0f;
    }

    private float hqf() {
        return this.hqd() + 22.0f;
    }

    private float hqg() {
        return 12.0f;
    }

    private float hqh() {
        return (float)hia.SLOTS.length * 24.0f + (float)(hia.SLOTS.length - 1) * 7.0f + 16.0f;
    }

    private float hqi() {
        return this.hqd() - 24.0f - 20.0f;
    }

    private float hqj(int n) {
        return this.hqg() + 8.0f + (float)n * 31.0f;
    }

    private boolean hqk(float f, float f2) {
        return irr.inside(f, f2, this.hqe() - 9.0f - 3.0f, this.hqf() - 9.0f - 3.0f, 24.0f, 24.0f);
    }

    private boolean hql(float f, float f2) {
        return irr.inside(f, f2, this.hqg(), this.hqi(), this.hqh(), 40.0f);
    }

    private void hqm(DrawContext drawContext, float f, float f2) {
        float f3 = this.hqd();
        uut.rect(drawContext, 14.0f, f3, 108.0f, 1.0f, iov.divider);
        String string = LoaderInfo.login();
        long l = LoaderInfo.uid();
        String string2 = string.isEmpty() ? hia.windowsUser() : string;
        String string3 = l > 0L ? a.d("\u93c7\uea6a\u60b4\ufea1", -14539492, 1412675210) + l : a.d("\u22e4\u5b7f\ud1af\u4fc6\uc433\u42a4\uf8e1\u7107", -39430625, -1997507403);
        float f4 = this.hqe();
        float f5 = this.hqf();
        float f6 = this.hoh.get();
        float f7 = 18.0f + 1.5f * f6;
        float f8 = f7 * 0.5f;
        ukf.shadow(drawContext, f4 - f7 * 0.5f, f5 - f7 * 0.5f, f7, f7, f8, 0.6f + 0.4f * f6, iov.lightness());
        if (!hia.draw(drawContext, hia.selected(), f4 - f7 * 0.5f, f5 - f7 * 0.5f, f7, 19.5f)) {
            uut.round(drawContext, f4 - f7 * 0.5f, f5 - f7 * 0.5f, f7, f7, f8, iov.field);
            irr.AVATAR.drawCentered(drawContext, string2.substring(0, 1).toUpperCase(Locale.ROOT), f4, irr.AVATAR.centerTop(f5), iov.textDim);
        }
        uut.circleOutline(drawContext, f4, f5, f7 * 0.5f, 1.0f, ujt.lerp(0x34FFFFFF, iov.accent(200), f6));
        float f9 = this.hqn() - 9.0f - 5.0f - 41.0f;
        irr.NAME.draw(drawContext, irr.NAME.ellipsize(string2, f9), 41.0f, irr.NAME.centerTop(f5 - 4.0f), iov.text);
        irr.SUBTITLE.draw(drawContext, irr.SUBTITLE.ellipsize(string3, f9), 41.0f, irr.SUBTITLE.centerTop(f5 + 5.0f), iov.textMuted);
        this.hqp(drawContext, f, f2);
    }

    private float hqn() {
        return 113.0f;
    }

    private boolean hqo(float f, float f2) {
        return irr.inside(f, f2, this.hqn() - 9.0f - 2.0f, this.hqf() - 9.0f - 2.0f, 22.0f, 22.0f);
    }

    private void hqp(DrawContext drawContext, float f, float f2) {
        this.hon = this.canHover() && this.hqo(f, f2);
        float f3 = vcq.outCubic(this.hok.step(this.hon, this.hop));
        float f4 = this.hol.step(0.0f, this.hop);
        float f5 = iov.lightness();
        float f6 = 18.0f * (1.0f - 0.06f * f4);
        float f7 = this.hqn() - f6 * 0.5f;
        float f8 = this.hqf() - f6 * 0.5f - 0.5f * f3;
        float f9 = iov.r(6.0f);
        ukf.shadow(drawContext, f7, f8, f6, f6, f9, 0.2f + 0.7f * f3, f5);
        uut.round(drawContext, f7, f8, f6, f6, f9, ujt.lerp(iov.field, -1750963, 0.14f * f3));
        uut.outline(drawContext, f7, f8, f6, f6, f9, 1.0f, ujt.lerp(iov.stroke, ujt.withAlpha(-1750963, 150), f3));
        ukf.rim(drawContext, f7, f8, f6, f6, f9, f5, 0.8f + 0.4f * f3);
        vjf.draw(drawContext, vhz.POWER, f7 + f6 * 0.5f, f8 + f6 * 0.5f, 9.0f, ujt.lerp(iov.textDim, -1750963, f3));
    }

    private void hqq(DrawContext drawContext) {
        float f = vcq.outCubic(this.hom.step(this.hon, this.hop));
        if (f <= 0.01f) {
            return;
        }
        String string = wap.s(a.b("\u9296\ueb16\u61ca\uffbc\u7461", 334533315), a.b("\u95ec\uec72\u66ac\uf8d8\u730d", -1241869834));
        String string2 = wap.s(a.d("\u384f\u41fe\ucbba\u555c\ude8b\u5875\ue22f\u6bde\uf5c7\u7f23\uf8eb\u0280\u8c4a\u15fe\u9fe1\u1942\ua31a\u2cdd\ub669\u302d\ub9c9\uc39e", -2035486916, -1725114555), a.b("\u23fd\u5a4c\ud008\u4eee\uc539\u479a\ufdb0\u7430\uea6e\u60aa\ue770\u1d7e\u93d3\u0a6c\u8453\u06b6\ubcf3\u373c\ua990\u2fcb\ua649\udc6d\u52dc\uc90a\u4f7a\uc5d7\u7c66\uf24c\u68b1", 374940608));
        float f2 = irr.SUBTITLE.width(string);
        float f3 = f2 + irr.SUBTITLE.width(string2) + 14.0f + 9.0f;
        float f4 = irr.SUBTITLE.height() + 10.0f;
        float f5 = Math.max(6.0f, Math.min(534.0f - f3, this.hqn() - f3 * 0.5f));
        float f6 = this.hqf() - 9.0f - 6.0f - f4;
        float f7 = iov.r(6.0f);
        float f8 = f6 + f4 * 0.5f;
        uut.pushAlpha(f);
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(0.0f, (1.0f - f) * 3.0f);
        uut.shadow(drawContext, f5, f6 + 2.0f, f3, f4, f7, 12.0f, iov.shadow);
        hyv.surface(drawContext, f5, f6, f3, f4, f7, hyv.tint(iov.window, Math.min(1.0f, iov.windowTint() + 0.08f)), ujt.withAlpha(iov.cardHover, 250), 6.0f, hyv.POPUPS);
        uut.outline(drawContext, f5, f6, f3, f4, f7, 1.0f, iov.stroke);
        uut.circle(drawContext, f5 + 7.0f + 2.0f, f8, 2.0f, -1750963);
        irr.SUBTITLE.draw(drawContext, string, f5 + 7.0f + 9.0f, irr.SUBTITLE.centerTop(f8), iov.text);
        irr.SUBTITLE.draw(drawContext, string2, f5 + 7.0f + 9.0f + f2, irr.SUBTITLE.centerTop(f8), iov.textMuted);
        drawContext.method_51448().popMatrix();
        uut.popAlpha();
    }

    private void hqr(DrawContext drawContext, float f, float f2) {
        float f3;
        boolean bl = this.canHover() && (this.hqk(f, f2) || this.hoh.get() > 0.3f && this.hql(f, f2));
        long l = System.currentTimeMillis();
        if (bl) {
            this.hoj = l + 250L;
        }
        if ((f3 = vcq.outCubic(this.hoh.step(bl || l < this.hoj, this.hop))) <= 0.01f) {
            return;
        }
        float f4 = this.hqg();
        float f5 = this.hqi() + (1.0f - f3) * 6.0f;
        float f6 = this.hqh();
        float f7 = 40.0f;
        float f8 = iov.r(8.0f);
        uut.pushAlpha(f3);
        uut.shadow(drawContext, f4, f5 + 2.0f, f6, f7, f8, 12.0f, iov.shadow);
        uut.round(drawContext, f4, f5, f6, f7, f8, ujt.withAlpha(iov.cardHover, 250));
        uut.outline(drawContext, f4, f5, f6, f7, f8, 1.0f, iov.stroke);
        String string = null;
        for (int i = 0; i < hia.SLOTS.length; ++i) {
            String string2 = hia.SLOTS[i];
            float f9 = this.hqj(i);
            float f10 = f5 + 8.0f;
            boolean bl2 = irr.inside(f, f2, f9 - 2.0f, f10 - 2.0f, 28.0f, 28.0f);
            float f11 = this.hoi[i].step(bl2, this.hop);
            float f12 = 24.0f * (1.0f + 0.08f * f11);
            float f13 = f9 + 12.0f;
            float f14 = f10 + 12.0f - f11;
            boolean bl3 = string2.equals(hia.selected());
            if (bl3) {
                uut.circleOutline(drawContext, f13, f14, f12 * 0.5f + 2.2f, 1.4f, iov.accent());
            }
            if (a.c(-960941453, "\u321f\u4bb6\uc17c").equals(string2) && !hia.ownReady()) {
                uut.circle(drawContext, f13, f14, f12 * 0.5f, ujt.lerp(iov.field, iov.accent(60), f11));
                uut.circleOutline(drawContext, f13, f14, f12 * 0.5f, 1.0f, ujt.lerp(iov.stroke, iov.accent(160), f11));
                vjf.draw(drawContext, vhz.PLUS, f13, f14, 9.0f, ujt.lerp(iov.textDim, iov.accent(), f11));
            } else if (!hia.draw(drawContext, string2, f13 - f12 * 0.5f, f14 - f12 * 0.5f, f12, 25.920002f)) {
                uut.circle(drawContext, f13, f14, f12 * 0.5f, iov.field);
            }
            if (!bl2) continue;
            string = hia.label(string2);
        }
        uut.popAlpha();
        if (string != null) {
            this.hint(string);
        }
    }

    private float hqs() {
        return 480.0f;
    }

    private float hqt() {
        return this.hqs() - 8.0f - 136.0f;
    }

    private float hqu() {
        return 13.0f;
    }

    private float hqv() {
        return 13.0f;
    }

    private String hqw(hkv hkv2, float f, float f2) {
        if (this.hnm != null) {
            return this.hnm;
        }
        if (!this.hod.isEmpty()) {
            int n = this.hmb.size();
            return n + wap.s(n == 1 ? a.b("\u99fe\ue01d\u6ad9\uf4be\u7f6f\uf9c7\u438c", 1929681369) : a.b("\u8f60\uf683\u7c47\ue220\u69f1\uef59\u5512\udce4", -979923128), a.b("\u52db", -634170630) + hlc.plural(n, a.c(-2057249334, "\ud983\ua047\u2a96\ub493\u3f3c\ub9fa\u03a7\u8a24\u1409"), a.d("\ucefc\ub738\u3de9\ua3ec\u2843\uae85\u14d8\u9d5b\u0376\u89b5", -820053705, -477023359), a.d("\u7c3d\u05f9\u8f28\u112d\u9a82\u1c44\ua619\u2f9a\ub1b7\u3b7a\ubca5", 1225019192, -815188146)));
        }
        return switch (hkv2.hkz.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1 -> iov.shownName(iov.presetName());
            case 2 -> izx.enabledCount() + wap.s(a.c(-314033867, "\u3916\u40e8\uca3a"), a.b("\u57b3\u2a10\ua0cb\u3ebb", -1123526761));
            case 3 -> {
                if (ConfigManager.active() != null) {
                    yield ConfigManager.active();
                }
                yield wap.s(a.d("\ua679\udfe9\u5575\ucb47\u409c\uc62c\u7c77\uf589\u6bd8\ue12e\u66a4\u9cc9\u120f", -859376192, 1181963258), a.b("\uf6d8\u8f4d\u059d\u9b95\u103e\u9684\u2cd4\ua135\u3b75\ub1c5\u3612\ucc69\u46ae\udb02\u5159\ud7df", -1952714030));
            }
            case 4 -> {
                int var4_5 = wlk.inWorld().size();
                yield var4_5 + wap.s(var4_5 == 1 ? a.c(-1404173969, "\u0141\u78a7\uf262\u6c0b\ue7d5\u617b\udb2e\u52d8\ucc9d\u4678\uc1e3\u3b9f\ub55f\u2cf9") : a.c(598118076, "\u8e93\uf775\u7db0\ue3d9\u6807\ueea9\u54fc\udd0a\u434f\uc9f9\u4e79\ub440\u3a9a\ua33c\u2978"), a.b("\u2253", 328802930) + hlc.plural(var4_5, a.c(1050864595, "\uefea\u9652\u1cf6\u82ff\u0922"), a.b("\u7fc0\u0678\u8cdc\u12d5\u9900", 326990841), a.b("\u9ee0\ue758\u6dfc\uf3f1\u7822", -1746887975)) + a.c(1767930853, "\u7bc3\u0665\u8cb5\u12c5\u9966\u1fda"));
            }
            case 5 -> {
                int var4_6 = hhf.all().size();
                if (var4_6 == 0) {
                    yield wap.s(a.b("\uf2f1\u8b61\u01b3\u9fc9\u145b\u92b3\u28fc\ua11c\u3f17\ub5a6\u32e2\uc804\u46d3", 1888219826), a.c(1881814284, "\u311e\u488e\uc259\u5c22\ud3e5\u5149\ueb12\u6294\uf8a9\u7218\uf55c\u0fba\u816d")) + irr.keyName(hzv.friendKey().key()) + wap.s(a.d("\u8777\ufe89\u745b\uea64\u61f2\ue702\u5d01\ud4ec\u4abe\uc017\u47d8\ubdbe", -1903316659, -2057488874), a.c(208684447, "\u45b5\u381b\ub2c9\u28a6\ua769\u21d3\u9bf3\u127c\u8c27\u06ef"));
                }
                yield var4_6 + wap.s(var4_6 == 1 ? a.d("\ua96d\ud09a\u5a5d\uc437\u4fec\uc956\u730f", 60846475, 34920641) : a.d("\u04de\u7d29\uf7ee\u6984\ue25f\u64e5\udebc\u575a", 647252734, 1621839368), a.c(-1963512272, "\u2e11") + hlc.plural(var4_6, a.c(-2125725809, "\ufbbf\u827a\u08aa\u96ab"), a.c(204096617, "\u4058\u399d\ub34d\u2d4c\ua698"), a.c(-767416036, "\u2d2e\u54eb\ude3b\u403e\ucbeb\u4d56")));
            }
            case 6 -> {
                int var4_7 = Cosmetics.wornCount();
                if (var4_7 == 0) {
                    yield wap.s(a.b("\u7855\u01c5\u8b0d\u1560\u9eb6\u1800\ua25a\u2bec\ub5fc\u3f4c\ub8d1\u42f9\ucc32\u5592", 1464694805), a.b("\ue9ea\u907a\u1aad\u84d6\u0b11\u89bd\u33eb\uba65\u2448\uaeff\u2921\ud74e\u5d84\uc43d\u4a7b\uc897\u72d5\ufd00\u67b2\ue194\u681f", 64876000));
                }
                yield var4_7 + wap.s(a.c(-358461486, "\u4ff7\u3611\ubcda\u22b6\ua97d"), a.d("\u4d52", 1144395020, 812472447) + hlc.plural(var4_7, a.c(-1283386946, "\u1587\u6c31\ue69e\u78ea\uf751\u75fd\ucfa3\u4656\ud808\u52ce\ud56f"), a.c(-1380457530, "\ue7ff\u9e49\u14e6\u8ae6\u0529\u8785\u3ddb\ub42e\u2a70\ua0b6\u276c"), a.c(-1713351746, "\u5780\u2e36\ua499\u3a94\ub14f\u33e7\u8da9\u0455\u9a0e\u10be\u971a\u6d17")));
            }
            case 0 -> {
                int var4_8 = 0;
                for (hjg var6_10 : this.hmb) {
                    if (var6_10.module == null || !var6_10.module.isEnabled()) continue;
                    ++var4_8;
                }
                yield var4_8 + wap.s(a.d("\ua476\udd88\u5752\uc965", 814882692, 1111473110), a.b("\u1637\u6b9e\ue142\u7b24", 543495699)) + this.hmb.size() + wap.s(a.d("\u34e6\u4d18\uc7ca", 1557234015, 1883354522), a.b("\u51b0\u2c13\ua6c8\u38b8", 372265364));
            }
        };
    }

    static String plural(int n, String string, String string2, String string3) {
        int n2 = n % 10;
        int n3 = n % 100;
        if (n2 == 1 && n3 != 11) {
            return string;
        }
        if (n2 >= 2 && n2 <= 4 && (n3 < 12 || n3 > 14)) {
            return string2;
        }
        return string3;
    }

    private void hqx(DrawContext drawContext, float f, float f2) {
        float f3;
        float f4;
        float f5 = 152.0f;
        hkv hkv2 = this.hlz.get(hln);
        String string = wap.t(this.hod.isEmpty() ? hkv2.hkw : a.b("\ud5e6\uac61\u26b6\ub8d4\u3312\ub5a8", -586033741));
        if (!string.equals(this.hmt)) {
            this.hmu = this.hmt;
            this.hmt = string;
            this.hme.restart();
        }
        if ((f4 = vcq.outCubic(this.hme.linear())) < 1.0f && !this.hmu.isEmpty()) {
            uut.pushAlpha(1.0f - f4);
            irr.TITLE.draw(drawContext, this.hmu, f5, irr.TITLE.centerTop(18.0f) - 6.0f * f4, iov.text);
            uut.popAlpha();
        }
        uut.pushAlpha(f4);
        irr.TITLE.draw(drawContext, this.hmt, f5, irr.TITLE.centerTop(18.0f) + 6.0f * (1.0f - f4), iov.text);
        uut.popAlpha();
        float f6 = this.hqt() - f5 - 12.0f;
        String string2 = irr.SUBTITLE.ellipsize(this.hqw(hkv2, f, f2), f6);
        if (!string2.equals(this.hmv)) {
            this.hmw = this.hmv;
            this.hmv = string2;
            this.hmf.restart();
        }
        if ((f3 = vcq.outCubic(this.hmf.linear())) < 1.0f && !this.hmw.isEmpty()) {
            uut.pushAlpha(1.0f - f3);
            irr.SUBTITLE.draw(drawContext, this.hmw, f5, irr.SUBTITLE.centerTop(31.0f), iov.textMuted);
            uut.popAlpha();
        }
        uut.pushAlpha(f3);
        irr.SUBTITLE.draw(drawContext, this.hmv, f5 + 3.0f * (1.0f - f3), irr.SUBTITLE.centerTop(31.0f), iov.textMuted);
        uut.popAlpha();
        this.hoe.x = this.hqt();
        this.hoe.y = this.hqu();
        this.hoe.w = 136.0f;
        this.hoe.h = 20.0f;
        this.hoe.render(drawContext, this, f, f2, this.hop);
        if (this.hoe.text.isEmpty() && this.hof != this.hoe) {
            irr.SMALL.drawRight(drawContext, a.c(-337651266, "\ud9fb\ua07d\u2aa8\ub4c7\u3f5c\ub98b"), this.hqt() + 136.0f - 8.0f, irr.SMALL.centerTop(this.hqu() + 10.0f), ujt.mulAlpha(iov.textMuted, 0.8f));
        }
        float f7 = this.hqv();
        float f8 = iov.lightness();
        float f9 = this.hog.step(this.canHover() && irr.inside(f, f2, this.hqs(), f7, 46.0f, 20.0f), this.hop);
        float f10 = iov.r(6.0f);
        float f11 = this.hqs();
        float f12 = f7 - 0.5f * f9;
        ukf.shadow(drawContext, f11, f12, 46.0f, 20.0f, f10, 0.2f + 0.7f * f9, f8);
        uut.round(drawContext, f11, f12, 46.0f, 20.0f, f10, ujt.lerp(iov.field, iov.fieldHover, f9));
        uut.outline(drawContext, f11, f12, 46.0f, 20.0f, f10, 1.0f, ujt.lerp(iov.stroke, iov.accent(150), f9));
        ukf.rim(drawContext, f11, f12, 46.0f, 20.0f, f10, f8, 0.8f + 0.4f * f9);
        int n = ujt.lerp(iov.textDim, iov.text, f9);
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f11 + 11.0f, f12 + 10.0f);
        drawContext.method_51448().rotate(0.50265485f * f9);
        vjf.draw(drawContext, vhz.GLOBE, 0.0f, 0.0f, 9.0f, n);
        drawContext.method_51448().popMatrix();
        irr.VALUE.draw(drawContext, wap.ru() ? a.c(-823456020, "\u0ebc\u770a") : a.c(1388713720, "\u16bf\u6f05"), f11 + 20.0f, irr.VALUE.centerTop(f12 + 10.0f), n);
        vjf.draw(drawContext, vhz.CHEVRON_DOWN, f11 + 46.0f - 8.0f, f12 + 10.0f + 0.5f, 6.0f, ujt.lerp(iov.textMuted, iov.accent(), f9));
        if (f9 > 0.5f) {
            this.hint(wap.s(a.c(-1260149072, "\ua6e8\udf74\u55a8\ucbd0\u4015\uc6b0\u7ce5\uf516\u6b0c\ue1bd\u66f9\u9c1f\u12c8\u8b1c\u0164\u879c\u3dd8\ub20c\u28a5\uaeef"), a.c(437828725, "\ub84a\uc1e3\u4b4c\ud54c\u5a81\udc30\u66f4\uef92\u71cd\uff7c\u78cc\u82bf\u0c68\u95a2\u1ff3\u9903")));
        }
        uut.rect(drawContext, 137.0f, 46.0f, 403.0f, 1.0f, iov.divider);
    }

    private float hqy() {
        return 150.0f;
    }

    private float hqz() {
        return 56.0f;
    }

    private float hra() {
        return 399.0f;
    }

    private float hrb() {
        return 183.0f;
    }

    private hjg hrc(float f, float f2) {
        if (!this.canHover() || !irr.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            return null;
        }
        for (hjg hjg2 : this.hmb) {
            if (!hjg2.hovered(f, f2)) continue;
            return hjg2;
        }
        return null;
    }

    private void hrd(DrawContext drawContext, float f, float f2) {
        float f3;
        float f4;
        int n;
        float f5;
        float f6 = this.hqz();
        float f7 = this.hra() - f6;
        float f8 = this.hrb();
        int n2 = this.hmb.size();
        float[] fArray = new float[n2];
        float[] fArray2 = new float[n2];
        float[] fArray3 = new float[]{0.0f, 0.0f};
        for (int i = 0; i < n2; ++i) {
            hjg hjg2 = this.hmb.get(i);
            f5 = hjg2.height();
            if (hjg2.wide && this.hod.isEmpty()) {
                float f9 = Math.max(fArray3[0], fArray3[1]);
                fArray[i] = this.hqy();
                fArray2[i] = f9;
                hjg2.w = f8 * 2.0f + 10.0f;
                fArray3[0] = fArray3[1] = f9 + f5 + 10.0f;
                continue;
            }
            fArray[i] = this.hqy() + (float)hjg2.column * (f8 + 10.0f);
            fArray2[i] = fArray3[hjg2.column];
            hjg2.w = f8;
            int n3 = hjg2.column;
            fArray3[n3] = fArray3[n3] + (f5 + 10.0f);
        }
        this.hmq = Math.max(fArray3[0], fArray3[1]) - 10.0f;
        float f10 = Math.max(0.0f, this.hmq - f7);
        this.hmp = Math.max(0.0f, Math.min(f10, this.hmp));
        float f11 = this.hml.step(this.hmp, this.hop);
        uut.pushScissor(drawContext, 137.0f, 47.0f, 402.0f, 361.0f);
        if (this.hmb.isEmpty()) {
            this.hre(drawContext);
        }
        f5 = this.hmd.linear();
        boolean bl = irr.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f);
        float f12 = bl ? f : -1000.0f;
        float f13 = bl ? f2 : -1000.0f;
        int n4 = 0;
        for (n = 0; n < n2; ++n) {
            hjg hjg3 = this.hmb.get(n);
            hjg3.x = fArray[n];
            hjg3.y = f6 + fArray2[n] - f11;
            f4 = hjg3.height();
            if (hjg3.y > 409.0f || hjg3.y + f4 < 46.0f) continue;
            if ((f3 = vcq.outCubic((f5 * 1.9f - (float)Math.min(n4++, 9) * 0.12f) / 0.8f)) <= 0.01f) continue;
            uut.pushAlpha(f3);
            drawContext.method_51448().pushMatrix();
            drawContext.method_51448().translate((1.0f - f3) * 16.0f * (float)this.hms, (1.0f - f3) * 10.0f);
            hjg3.render(drawContext, this, f12, f13, this.hop);
            drawContext.method_51448().popMatrix();
            uut.popAlpha();
        }
        n = System.nanoTime() - this.hmr < 900000000L ? 1 : 0;
        float f14 = this.hmm.step(f10 > 0.0f && (n != 0 || irr.inside(f, f2, 528.0f, f6, 12.0f, f7)), this.hop);
        if (f10 > 0.0f) {
            f4 = Math.max(18.0f, f7 * f7 / this.hmq);
            f3 = f6 + (f7 - f4) * (f11 / f10);
            float f15 = 2.5f + 1.5f * f14;
            uut.round(drawContext, 536.0f - f15, f3, f15, f4, f15 * 0.5f, ujt.mulAlpha(iov.textMuted, 0.35f + 0.5f * f14));
        }
        uut.popScissor(drawContext);
    }

    private void hre(DrawContext drawContext) {
        float f = 338.0f;
        float f2 = 217.5f;
        float f3 = vcq.outCubic(this.hmd.linear() * 1.5f);
        float f4 = (float)Math.sin((double)System.nanoTime() / 5.0E8) * 1.5f;
        uut.pushAlpha(f3);
        uut.circle(drawContext, f, f2 - 6.0f + f4, 22.0f * (0.8f + 0.2f * f3), iov.hover);
        vhz vhz2 = this.hod.isEmpty() ? this.hlz.get((int)hlc.hln).hkx : vhz.SEARCH;
        vjf.draw(drawContext, vhz2, f, f2 - 6.0f + f4, 20.0f, iov.textMuted);
        String string = this.hod.isEmpty() ? wap.s(a.c(1867619923, "\u9e0d\ue79d\u6d55\uf338\u78ee\ufe58\u4402\ucdb4\u53a3\ud91f\u5edb\ua4bd\u2a2f\ub3c7\u3988\ubf68"), a.b("\u28de\u514e\udb99\u45e2\uca25\u488b\uf2a4\u7b57\ue50b\u6fc6", -1228460853)) : wap.s(a.d("\ub2cc\ucb5c\u4194\udff9\u542f\ud299\u68c3\ue175\u7f6c\uf5d4\u721d\u8877\u06aa", -1600026941, -1633405876), a.b("\uaf77\ud6e3\u5c4f\uc24c\u499d\ucf21\u716c\ufc80\u62d7\uec73\u6fbd\u95c1\u1b1f\u82a3\u08f1\u8e08\u3444", -284644485));
        String string2 = this.hod.isEmpty() ? wap.s(a.d("\ue263\u9bf0\u1128\u8f48\u0486\u823e\u387b\ub1d9\u2fc0\ua578\u22b6\ud895\u5616\ucfbb\u45e9\uc302\u791e\uf68c\u6c3d\uea79\u639f\u19cc\u9777\u0cbb\u8acfG\ub9b5\u37f7\uad17\u2b03\ua0ff\u5e2f\ud42e\u4d8b\ucbc4\u4178\ufeea\u74cc\uf209\u6ba0", -314374952, 1701308126), a.b("\u4da5\u3436\ubeef\u20e9\uab46\u2df4\u93bf\u1e23\u8073\u0abe\u8d6a\u7302\uf9cf\u6074\uea55\u6cd3\ud69a\u5946\uc38b\u45a2\ucc55\ub21c\u38ce\ua364\u251f\uafb0\u167d\u9c32\u02da\u848a\u0f48\uf1e4\u7bd6\ue22a\u647a\ueec5", 1154304413)) : wap.s(a.b("\u11cd\u685a\ue282\u7caa\uf73c\u7182\ucbd0\u423a\udc79\u56c5\ud101\u2b22\ua5bb\u3c05\ub65a\u30a3\u8aa9\u0537\u9f99\u199a\u903e\uea79\u64db\uff0a\u7968\uf3be\u4a04", 941035906), a.b("\u6993\u1003\u9ad1\u04df\u8f76\u09c8\ub3e9\u3a62\ua446\u2e80\uad46\u5323\udd80\u4432\uce11\u48ed\uf2a9\u796d\ue7c3\u619f\ue86f\u923b\u1c8a\u8756\u012c\u8bf0\u3656\ubc1f\u26eb\ua0b9\u2f12\ud5de\u5f9c\uc61c\u404c\ucaff\u7556\uff20\u79f0\ue038", 714042788));
        irr.CARD_TITLE.drawCentered(drawContext, string, f, irr.CARD_TITLE.centerTop(f2 + 28.0f), iov.textDim);
        irr.SUBTITLE.drawCentered(drawContext, string2, f, irr.SUBTITLE.centerTop(f2 + 40.0f), iov.textMuted);
        uut.popAlpha();
    }

    private void hrf(DrawContext drawContext, float f, float f2) {
        boolean bl;
        hjg hjg2 = null;
        if (this.canHover() && this.hne == null && irr.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            for (hjg hjg3 : this.hmb) {
                if (!hjg3.headerHovered(f, f2)) continue;
                hjg2 = hjg3;
                break;
            }
        }
        long l = System.currentTimeMillis();
        if (hjg2 != this.hns) {
            this.hns = hjg2;
            this.hnt = l;
        }
        if (hjg2 != this.hnv) {
            this.hnv = null;
        }
        boolean bl2 = bl = hjg2 != null && hjg2 != this.hnv && l - this.hnt >= 350L;
        if (bl && hjg2 != this.hnu) {
            this.hnu = hjg2;
            this.hnr.set(0.0f);
        }
        float f3 = vcq.outCubic(this.hnr.step(bl && hjg2 == this.hnu, this.hop));
        if (this.hnu == null || f3 <= 0.01f || !this.hmb.contains(this.hnu)) {
            return;
        }
        if (this.hnu != this.hnx || wap.get() != this.hny) {
            this.hnx = this.hnu;
            this.hny = wap.get();
            this.hnw = hlc.hrg(this.hnu.description(), 220.0f);
            this.hnz = 0.0f;
            for (String string : this.hnw) {
                this.hnz = Math.max(this.hnz, irr.SUBTITLE.width(string));
            }
        }
        if (this.hnw.isEmpty()) {
            return;
        }
        float f4 = irr.SUBTITLE.height() + 1.5f;
        float f5 = 5.0f;
        float f6 = this.hnz + 14.0f;
        float f7 = (float)this.hnw.size() * f4 + f5 * 2.0f;
        float f8 = Math.max(142.0f, Math.min(534.0f - f6, this.hnu.x + 8.0f));
        float f9 = this.hnu.headBottom() - 2.0f;
        if (f9 + f7 > 403.0f) {
            f9 = this.hnu.y - f7 - 3.0f;
        }
        f9 = Math.max(50.0f, Math.min(403.0f - f7, f9));
        float f10 = iov.r(6.0f);
        uut.pushAlpha(f3);
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(0.0f, (1.0f - f3) * -3.0f);
        uut.shadow(drawContext, f8, f9 + 2.0f, f6, f7, f10, 12.0f, iov.shadow);
        hyv.surface(drawContext, f8, f9, f6, f7, f10, hyv.tint(iov.window, Math.min(1.0f, iov.windowTint() + 0.08f)), ujt.withAlpha(iov.cardHover, 250), 6.0f, hyv.POPUPS);
        uut.outline(drawContext, f8, f9, f6, f7, f10, 1.0f, iov.stroke);
        int n = ujt.lerp(iov.textDim, iov.text, 0.6f);
        for (int i = 0; i < this.hnw.size(); ++i) {
            float f11 = f9 + f5 + f4 * ((float)i + 0.5f);
            irr.SUBTITLE.draw(drawContext, this.hnw.get(i), f8 + 7.0f, irr.SUBTITLE.centerTop(f11), n);
        }
        drawContext.method_51448().popMatrix();
        uut.popAlpha();
    }

    private static List<String> hrg(String string, float f) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string == null || string.isBlank()) {
            return arrayList;
        }
        for (String string2 : string.split(a.d("\u79d0", 289488599, 865879820))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string3 : string2.trim().split(a.b("\u6544\u1cda\u9651", 1657038107))) {
                if (string3.isEmpty()) continue;
                if (!stringBuilder.isEmpty()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    if (irr.SUBTITLE.width(stringBuilder2.append((Object)stringBuilder).append(a.d("\uf6e6", -1051700899, 32155546)).append(string3).toString()) > f) {
                        arrayList.add(irr.SUBTITLE.ellipsize(stringBuilder.toString(), f));
                        stringBuilder.setLength(0);
                    }
                }
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(string3);
            }
            if (stringBuilder.isEmpty()) continue;
            arrayList.add(irr.SUBTITLE.ellipsize(stringBuilder.toString(), f));
        }
        return arrayList;
    }

    private void hrh(DrawContext drawContext) {
        boolean bl = this.hnf != null || System.currentTimeMillis() < this.hnl;
        float f = vcq.outCubic(this.hmn.step(bl, this.hop));
        if (f <= 0.01f) {
            return;
        }
        String string = this.hnf != null ? this.hng : this.hni;
        vhz vhz2 = this.hnf != null ? vhz.KEYBOARD : this.hnj;
        boolean bl2 = this.hnf == null && this.hnk;
        int n = bl2 ? -1750963 : iov.accent();
        float f2 = Math.min(374.0f, irr.LABEL.width(string) + 34.0f);
        float f3 = 21.0f;
        float f4 = 136.0f + (404.0f - f2) * 0.5f;
        float f5 = 393.0f - f3 + (1.0f - f) * 10.0f;
        float f6 = iov.r(7.0f);
        float f7 = 1.0f + 0.05f * this.hmo.step(0.0f, this.hop);
        uut.pushAlpha(f);
        drawContext.method_51448().pushMatrix();
        drawContext.method_51448().translate(f4 + f2 * 0.5f, f5 + f3 * 0.5f);
        drawContext.method_51448().scale(f7, f7);
        drawContext.method_51448().translate(-f2 * 0.5f, -f3 * 0.5f);
        uut.shadow(drawContext, 0.0f, 0.0f, f2, f3, f6, 12.0f, iov.shadow);
        hyv.surface(drawContext, 0.0f, 0.0f, f2, f3, f6, hyv.tint(iov.window, Math.min(1.0f, iov.windowTint() + 0.1f)), ujt.withAlpha(iov.cardHover, 250), f3 * 0.5f, hyv.POPUPS);
        uut.outline(drawContext, 0.0f, 0.0f, f2, f3, f6, 1.0f, ujt.withAlpha(n, 130));
        vjf.draw(drawContext, vhz2, 14.0f, f3 * 0.5f, 9.0f, n);
        irr.LABEL.draw(drawContext, irr.LABEL.ellipsize(string, f2 - 32.0f), 24.0f, irr.LABEL.centerTop(f3 * 0.5f), iov.text);
        drawContext.method_51448().popMatrix();
        uut.popAlpha();
    }

    public boolean method_25402(Click click, boolean bl) {
        if (this.hmx) {
            return true;
        }
        float f = this.hpx(click.comp_4798());
        float f2 = this.hpy(click.comp_4799());
        int n = click.method_74245();
        this.hnv = this.hns;
        if (this.hnf != null) {
            if (n >= 2 && this.hnf.clearable()) {
                this.hpt(vzz.mouse(n));
            } else {
                this.hnf = null;
            }
            return true;
        }
        if (this.hne != null) {
            if (this.hps()) {
                this.hne.mouseClicked(this, f, f2, n);
            }
            return true;
        }
        if (this.hpr()) {
            if (!this.hnd.mouseClicked(f, f2)) {
                this.hnd.close();
            }
            return true;
        }
        this.hof = null;
        if (!irr.inside(f, f2, 0.0f, 0.0f, 540.0f, 409.0f)) {
            return true;
        }
        if (this.hoh.get() > 0.5f && this.hql(f, f2)) {
            for (int i = 0; i < hia.SLOTS.length; ++i) {
                String string = hia.SLOTS[i];
                if (n != 0 || !irr.inside(f, f2, this.hqj(i) - 2.0f, this.hqi() + 6.0f, 28.0f, 28.0f)) continue;
                if (a.b("\u0c7b\u75d2\uff18", -1606874089).equals(string) && !hia.ownReady()) {
                    evi.refresh();
                    continue;
                }
                hia.select(string);
                hyz.saveLater();
            }
            return true;
        }
        if (this.hoe.mouseClicked(this, f, f2, n)) {
            return true;
        }
        if (n == 0 && this.hqo(f, f2)) {
            this.hol.set(1.0f);
            dry.trigger();
            if (this.field_22787 != null) {
                this.field_22787.method_1507(null);
            }
            return true;
        }
        if (n == 0 && irr.inside(f, f2, this.hqs(), this.hqv(), 46.0f, 20.0f)) {
            if (this.field_22787 != null) {
                this.field_22787.method_1507((Screen)new ida(this));
            }
            return true;
        }
        for (int i = 0; i < this.hlz.size(); ++i) {
            if (!irr.inside(f, f2, 8.0f, this.hqa(i), 120.0f, 23.0f)) continue;
            this.hrj(i);
            return true;
        }
        if (n == 0 && (f2 < 46.0f || f < 136.0f && f2 < 46.0f)) {
            this.hmz = true;
            this.hna = (float)click.comp_4798() - hlp;
            this.hnb = (float)click.comp_4799() - hlq;
            return true;
        }
        if (irr.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            for (hjg hjg2 : this.hmb) {
                if (!hjg2.mouseClicked(this, f, f2, n)) continue;
                return true;
            }
        }
        return true;
    }

    public boolean method_25406(Click click) {
        this.hmz = false;
        this.hnc = null;
        return true;
    }

    public boolean method_25403(Click click, double d, double d2) {
        if (this.hmz) {
            hlp = (float)click.comp_4798() - this.hna;
            hlq = (float)click.comp_4799() - this.hnb;
            this.hpj();
            return true;
        }
        if (this.hnc != null) {
            this.hnc.mouseDragged(this.hpx(click.comp_4798()), this.hpy(click.comp_4799()));
            return true;
        }
        return true;
    }

    public boolean method_25401(double d, double d2, double d3, double d4) {
        float f = this.hpx(d);
        float f2 = this.hpy(d2);
        if (this.hne != null) {
            this.hne.scrolled(d4);
            return true;
        }
        if (this.hpr()) {
            return true;
        }
        if (irr.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            this.hmp -= (float)d4 * 32.0f;
            this.hmr = System.nanoTime();
        }
        return true;
    }

    public boolean method_16803(KeyInput keyInput) {
        if (this.hnf != null && this.hnh != -1 && keyInput.comp_4795() == this.hnh) {
            this.hnh = -1;
            this.hpt(keyInput.comp_4795());
            return true;
        }
        return super.method_16803(keyInput);
    }

    public boolean method_25404(KeyInput keyInput) {
        boolean bl;
        int n = keyInput.comp_4795();
        if (this.hmx) {
            return true;
        }
        if (this.hnf != null) {
            boolean bl2;
            boolean bl3 = bl2 = n == 256 || n == 261 || n == 259;
            if (!bl2) {
                if (this.hnf.clearable() && vzz.isModifier(n)) {
                    this.hnh = n;
                } else {
                    this.hpt(this.hnf.clearable() ? vzz.combo(n, keyInput.comp_4797() | vzz.heldMods(this.field_22787)) : n);
                }
                return true;
            }
            if (this.hnf.clearable()) {
                this.hnf.set(-1);
            }
            this.hnf = null;
            return true;
        }
        if (this.hpr() && n == 256) {
            this.hnd.close();
            return true;
        }
        if (this.hne != null) {
            if (this.hps()) {
                this.hne.keyPressed(this, n, keyInput.comp_4797());
            }
            return true;
        }
        if (this.hof != null) {
            if (this.hof == this.hoe && n == 256 && !this.hoe.text.isEmpty()) {
                this.hoe.setText("");
                return true;
            }
            this.hof.keyPressed(this, n, keyInput.comp_4797());
            return true;
        }
        boolean bl4 = bl = (keyInput.comp_4797() & 2) != 0;
        if (bl && n == 70) {
            this.focus(this.hoe);
            return true;
        }
        if (n == 256 || n == Flow.getInstance().getOpenGuiKey()) {
            this.method_25419();
            return true;
        }
        if (n == 265 || n == 264) {
            int n2 = hln + (n == 265 ? -1 : 1);
            this.hrj((n2 + this.hlz.size()) % this.hlz.size());
            return true;
        }
        return true;
    }

    public boolean method_25400(CharInput charInput) {
        if (this.hmx || this.hnf != null || this.hof == null || !charInput.method_74227()) {
            return false;
        }
        this.hof.charTyped(charInput.method_74226());
        return true;
    }

    private void hri(String string) {
        if (string.equals(this.hod)) {
            return;
        }
        boolean bl = this.hod.isEmpty();
        if (bl && !string.isEmpty()) {
            this.hpp();
        }
        this.hod = string;
        hoa = string;
        this.hpm(true);
        if (string.isEmpty() && !bl) {
            this.hpq();
        }
    }

    private void hrj(int n) {
        this.hnd = null;
        this.hne = null;
        if (!this.hod.isEmpty()) {
            this.hoe.setText("");
            this.focus(null);
        }
        if (n == hln && this.hmd.linear() > 0.0f) {
            this.hpm(false);
            return;
        }
        this.hpp();
        this.hms = Integer.signum(n - hln);
        hln = n;
        hlo = this.hlz.get((int)n).hkw;
        this.hmi.get(n).set(1.0f);
        this.hpm(true);
        this.hmd.restart();
        this.hpq();
    }

    public void method_25419() {
        if (!this.hmx) {
            this.hmx = true;
            lsg.menu(false);
            this.hpp();
            this.hmc.backward();
            this.hof = null;
            this.hnd = null;
            this.hne = null;
            this.hnc = null;
            this.hmz = false;
        }
    }

    public void method_25432() {
        vdn.setRenderScale(1.0f);
        this.hpp();
        ConfigManager.autoSaveLater();
        hyz.saveLater();
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25422() {
        return false;
    }

    static {
        hlp = Float.NaN;
        hlq = Float.NaN;
        hlr = new HashMap<String, Float>();
        hls = new IdentityHashMap<kfe, hjg>();
        hoa = "";
        hob = new HashSet<hjg>();
    }

    private static /* synthetic */ int abu(int n, int n2) {
        return n - n2 | 0xAE511500;
    }

    private static /* synthetic */ int abv(int n, int n2) {
        return hlc.abu(n, n2) ^ 0x73BB0CAB;
    }

    private static /* synthetic */ int abw(int n, int n2) {
        return hlc.abu(n, n2) * n2;
    }
}

