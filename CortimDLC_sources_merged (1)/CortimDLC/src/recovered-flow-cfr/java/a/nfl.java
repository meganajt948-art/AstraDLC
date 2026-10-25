/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.DeathScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package a;

import a.efz;
import a.ign;
import a.izx;
import a.kfa;
import a.kfe;
import a.lex;
import a.lfa;
import a.nes;
import a.ney;
import a.nff;
import a.nfi;
import a.pfl;
import a.pjd;
import a.poi;
import a.pzc;
import a.pzp;
import a.pzw;
import a.qaj;
import a.qdw;
import a.qdz;
import a.qma;
import a.qmh;
import a.qoc;
import a.qof;
import a.qpw;
import a.qqd;
import a.qqg;
import a.qqm;
import a.qqp;
import a.qqs;
import a.qsq;
import a.qsw;
import a.qwj;
import a.qwo;
import a.tck;
import a.tel;
import a.toq;
import a.ttb;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vmo;
import a.vmu;
import a.wcn;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class nfl
extends kfe {
    private static final int nfm = 0;
    private static final double nfn = 72.0;
    private static final double nfo = 36.0;
    private static final double nfp = 30.0;
    private static final double nfq = 6.0;
    private static final int nfr = 3;
    private static final long nfs = 600000L;
    private static final Pattern nft;
    private static final Pattern nfu;
    private static final String nfv;
    private static final String nfw;
    private static final String nfx;
    private static final long nfy = 30000L;
    private static final long nfz = 7000L;
    private static final long nga = 25000L;
    private static final long ngb = 150000L;
    private static final String ngc;
    private static final String ngd;
    private static final String nge;
    private static final String ngf;
    private static final int ngg = 190;
    private static final int ngh = 576;
    private static final float ngi = 3.0f;
    private static final int ngj = 576;
    private static final int ngk = 20;
    private static final long ngl = 60000L;
    private static final long ngm = 20000L;
    private static final Set<String> ngn;
    private final vmu ngo = this.add(new vmu(a.b("\udd4b\ua4d7\u2e03\ub078\u3fbf\ubd6f\u0747\u8eb7\u10e3\u9a56\u1d81", 1109186896), "", 16));
    private final vkl ngp = this.add(new vkl(a.c(-727505227, "\u22a6\u5b38\ud191\u4fec\uc441\u4286\uf8ab\u754f\uef78\u65b1\ue217\u1861\u96bf"), true));
    private final vkl ngq = this.add(new vkl(a.c(249814891, "\udb67\ua2f2\u285d\ub650\u3df8\ubb3b\u011c\u8896\u16cb\u9c77\u1fb1\ue1a8\u6f07\uf6c3\u7c97\ufa6f"), true));
    private final vkl ngr = this.add(new vkl(a.b("\u5439\u2da6\ua773\u3904\ub2db\u3463\u8e34\u07b5\u9997\u1350\u94fd\u6a99\ue026\u79ef\uf3c9\u753f\ucf79", 913133619), true));
    private final vkl ngs = this.add(new vkl(a.c(1512283722, "\u9a5a\ue3b4\u6912\uf762\u7cb9\ufa0a\u4021\ucdb2\u57f6\udd42\u5a93\ua0ee\u2e34\ub780\u3da4"), true));
    private final vkw ngt = this.add(new vkw(a.c(-1235147233, "\u220f\u5b96\ud149\u4f41\uc4e8\u464a\uf80e\u71fb\uefa5\u651b\ue2c5\u18b1\u966b"), new vkq(a.b("\u560c\u2f9a\ua546\u3b30\ub09e\u365e\u8c7f\u0580\u9fb3\u111a\u92d1\u6cbe\ue266\u7ba5\uf1f2\u777c\ucd49\u4296", 2140951049), vhz.LAYERS, ign::openMine)));
    private static nfl ngu;
    private static boolean ngv;
    private efz ngw;
    private final qqs ngx = new qqs();
    private final qqd ngy = new qqd();
    private final qdz ngz = new qdz();
    private final qof nha = new qof();
    private final tel nhb = new tel();
    private final qmh nhc = new qmh();
    private final qsw nhd = new qsw();
    private final qaj nhe = new qaj();
    private final qma nhf = new qma();
    private final Map<Integer, pzc> nhg = new HashMap<Integer, pzc>();
    private final Map<Integer, Vec3d> nhh = new HashMap<Integer, Vec3d>();
    private final Set<Integer> nhi = new HashSet<Integer>();
    private final Map<String, Long> nhj = new HashMap<String, Long>();
    private final poi nhk = new poi();
    private final Map<Integer, Long> nhl = new HashMap<Integer, Long>();
    private final Map<Integer, Long> nhm = new HashMap<Integer, Long>();
    private boolean nhn;
    private boolean nho;
    private nff nhp = nff.START;
    private long nhq;
    private int nhr = -1;
    private int nhs = -1;
    private boolean nht;
    private ClientPlayerEntity nhu;
    private int nhv = -1;
    private long nhw;
    private boolean nhx;
    private ClientWorld nhy;
    private ClientPlayerEntity nhz;
    private Vec3d nia;
    private boolean nib;
    private boolean nic;
    private int nid;
    private long nie;
    private long nif;
    private int nig;
    private Vec3d nih;
    private ClientWorld nii;
    private ClientPlayerEntity nij;
    private long nik;
    private boolean nil;
    private long nim;
    private int nin;
    private long nio;
    private boolean nip;
    private String niq = "";
    private long nir;
    private int nis = -1;
    private boolean nit;
    private boolean niu;
    private long niv;
    private int niw = -1;
    private long nix;
    private qwj niy;
    private qwj niz;
    private long nja;
    private int njb;
    private boolean njc;
    private int njd;
    private boolean nje;
    private boolean njf;
    private boolean njg;
    private boolean njh;
    private long nji;
    private long njj;
    private String njk;
    private long njl;
    private long njm;
    private Vec3d njn;
    private Object njo;
    private long njp;
    private String njq = "";
    private int njr;
    private static /* synthetic */ boolean njs;
    private static /* synthetic */ long njt;

    public nfl() {
        super(a.c(610722204, "\ue1d5\u9850\u1282\u8ce8\u071d\u8188\u3bdc\ub226"), a.d("\u559a\u2c04\ua6de\u38ab\ub36f\u35df\u8fdf\u067a\u9839\u1285\u9513\u6f23\ue1fb\u7845\uf205\u74e5\ucea1\u4161\udb8b\u5d9b\ud478\uae28\u2080\ubb13\u3d2c\ub7f9\u0e4d\u8017\u1af6\u9cf4\u1705\ue9cf\u63d9\ufa61\u7c2f\uf699\u4958\uc320\u45f9", -439984955, 95422779), kfa.PLAYER);
        if (ngu == null) {
            ngu = this;
        }
        this.ngz.target(nfl::nkc);
        this.ngz.junk(itemStack -> qof.isJunkStack(itemStack, ngn));
        this.ngz.onSit(this::nkd);
        this.nhd.walker().junk(itemStack -> qof.isJunkStack(itemStack, ngn));
        this.nhd.notes(string -> this.nma((String)string, vhz.INFO));
        this.nhk.notes(string -> this.nma((String)string, vhz.NAV));
        if (!ngv) {
            ngv = true;
            wcn.listen(nfl::nju);
        }
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    private static void nju(Packet<?> packet) {
        nfl nfl2 = ngu;
        if (nfl2 != null && nfl2.ngw == null && nfl2.isEnabled()) {
            nfl2.ngz.echo(packet);
        }
    }

    public void onPacket(Packet<?> packet) {
        if (this.isEnabled()) {
            this.ngz.echo(packet);
        }
    }

    public static boolean busy() {
        nfl nfl2 = ngu;
        return nfl2 != null && nfl2.isEnabled() && nfl2.nhp != nff.START;
    }

    public void attachBot(efz efz2) {
        this.ngw = efz2;
        this.nhb.tickOnly();
    }

    public boolean isBotInstance() {
        return this.ngw != null;
    }

    public void copySettingsFrom(nfl nfl2) {
        if (nfl2 == null || nfl2 == this) {
            return;
        }
        List<vmo> list = nfl2.getSettings();
        List<vmo> list2 = this.getSettings();
        for (int i = 0; i < Math.min(list.size(), list2.size()); ++i) {
            vmo vmo2 = list.get(i);
            vmo vmo3 = list2.get(i);
            if (vmo2 instanceof vkl) {
                vkl vkl2 = (vkl)vmo2;
                if (vmo3 instanceof vkl) {
                    vkl vkl3 = (vkl)vmo3;
                    vkl3.set(vkl2.get());
                    continue;
                }
            }
            if (!(vmo2 instanceof vmu)) continue;
            vmu vmu2 = (vmu)vmo2;
            if (!(vmo3 instanceof vmu)) continue;
            vmu vmu3 = (vmu)vmo3;
            vmu3.set(vmu2.get());
        }
    }

    private void njv() {
        Flow flow = Flow.getInstance();
        if (flow == null || flow.getModuleManager() == null) {
            return;
        }
        nfl nfl2 = flow.getModuleManager().get(nfl.class);
        if (nfl2 == null || nfl2 == this || nfl2.isBotInstance()) {
            return;
        }
        Set set = Collections.newSetFromMap(new IdentityHashMap());
        set.addAll(List.of(this.botSettings()));
        List<vmo> list = nfl2.getSettings();
        List<vmo> list2 = this.getSettings();
        for (int i = 0; i < Math.min(list.size(), list2.size()); ++i) {
            vmo vmo2 = list.get(i);
            vmo vmo3 = list2.get(i);
            if (set.contains(vmo3)) continue;
            if (vmo2 instanceof vkl) {
                vkl vkl2 = (vkl)vmo2;
                if (vmo3 instanceof vkl) {
                    vkl vkl3 = (vkl)vmo3;
                    if (vkl2.get() != vkl3.get()) {
                        vkl3.set(vkl2.get());
                        continue;
                    }
                }
            }
            if (!(vmo2 instanceof vmu)) continue;
            vmu vmu2 = (vmu)vmo2;
            if (!(vmo3 instanceof vmu)) continue;
            vmu vmu3 = (vmu)vmo3;
            if (vmu2.get().equals(vmu3.get())) continue;
            vmu3.set(vmu2.get());
        }
    }

    public vmo[] botSettings() {
        return new vmo[]{this.ngo, this.ngp, this.ngq, this.ngr, this.ngs};
    }

    public int mined() {
        return this.ngz.mined();
    }

    public String lastNote() {
        return this.njq;
    }

    public static String hudStatus() {
        nfl nfl2 = ngu;
        return nfl2 == null ? null : nfl2.status();
    }

    public static List<ney> hudRows() {
        nfl nfl2 = ngu;
        ArrayList<ney> arrayList = new ArrayList<ney>();
        if (nfl2 == null || !nfl2.isEnabled()) {
            return arrayList;
        }
        long l = System.currentTimeMillis();
        for (qqm qqm2 : nfl2.ngx.entries()) {
            if (qqm2.tier == null || qqm2.refreshAt <= l - 2000L) continue;
            boolean bl = qqm2.id == nfl2.nhs || qqm2.id == nfl2.nhr && (nfl2.nhp == nff.WAIT || nfl2.nhp == nff.MINE);
            arrayList.add(new ney(qqm2.id, qqm2.tier, qqm2.refreshAt, bl));
        }
        arrayList.sort((ney2, ney3) -> Long.compare(ney2.refreshAt(), ney3.refreshAt()));
        return arrayList.size() > 8 ? new ArrayList<ney>(arrayList.subList(0, 8)) : arrayList;
    }

    public String status() {
        nfl nfl2 = this;
        if (!nfl2.isEnabled()) {
            return null;
        }
        long l = System.currentTimeMillis();
        if (nfl2.nhk.active()) {
            return nfl2.nhk.status();
        }
        if (nfl2.nhe.active()) {
            return a.c(1985731854, "\ud90f\ua096\u2a44\ub440\u3f9e\ub958\u0375\u8eea\u14a5\u9e16\u19b5\ue3b8\u697c\uf4a1\u7e89\uf801\u4232\ucde6\u572c");
        }
        if (nfl2.nhf.active()) {
            return a.b("\uecea\u9572", -982652675);
        }
        return switch (nfl2.nhp.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 1 -> a.d("\u107b\u6993\ue33a\u7d42\uf6ed\u702c\uca01\u479e\udda9\u5760\ud0c6\u2ab0\ua466", 1915102252, -2020659128);
            case 2 -> a.b("\u547a\u2dec\ua74a\u3940\ub29f\u345b\u8a6b\u0787\u99d5\u1774", -1050980249) + nfl2.nhv + (nfl2.nid > 0 ? a.d("\u863c\uff85\u7141\uef31\u64ea\ue22b\u5804\ud18b\u4bb4", -330349232, 757646149) + nfl2.nid + a.b("\u0aa3", -2124543349) : "");
            case 3 -> a.b("\ue204\u9ba8\u1179\u8f74\u04a1\u821e\u3c23\ub1b0\u2f9d\ua52d\u22f4\ud886\u562e\ucfe2\u45c8\uc75a\u7908\uf6d4\u6877", 2147280438) + nfl2.nhr;
            case 4 -> {
                if (nfl2.nim > 0L) {
                    yield a.b("\uc4b7\ubd1b\u37ca\ua9c7\u2212\ua4ad\u1a90\u9703\u092e\u839e\u0447\ufe35\u709d\ue951\u637b", -534789991);
                }
                if (nfl2.nik > l) {
                    yield a.c(-1247726053, "\u3219\u4b8a\uc129\u5f27\ud0ef\u5243\ue81d\u65fc\uffcb\u7502\uf2a4\u08d2\u8604\u1bd6\u9112\u1774") + (nfl2.nik - l + 999L) / 1000L + a.b("\u1ecd\u631d", -1949557009);
                }
                yield a.c(303126522, "\u53e5\u2a76\ua0d5\u3edb\ub113\u33bf\u89e1\u0400\u9e37\u14fe\u9358\u692e\ue7f8");
            }
            case 5 -> {
                qqm var4_3 = nfl2.ngx.entry(nfl2.nhr);
                String var5_4 = !nfl2.njf ? a.b("\u15b2\u6c21\ue685\u7c97", -931393120) : (nfl2.ngz.parked() ? (nfl2.mc.field_1724 != null && nfl2.mc.field_1724.method_5765() ? a.d("\u4ae9\u3341\ub99c\u2798\ua82c\u2a80\u90de\u1d3f\u8701\u0db3\u8a61\u706c\ufeb1\u6708\ued2a\u6bad\ud1e8\u5e4c\uc096\u46cb\ucb2a\ub179\u3fbd\ua00f", -163365951, 690320657) : a.c(-2021787155, "\ufdde\u806c\u0ede\u90ac\u1b7a\u9db7\u27ee\uae17\u3040\ubafe\u393b\uc346\u4987\ud034\u5a10\ud882")) : a.d("\ubed8\uc745\u4de1\ud7f3\u583e\uda95\u64a7\ued55\u730b\uf9c6\u7e1f\u8466\u0ac0\u9307\u195e\u9fa3\u21fc\uae21\u3084\ub6d7\u3f57\u4165", -1334101007, 1841922343));
                yield var5_4 + (nfl2.niy == null ? a.c(711954127, "\u8a82\uf34b\u79ed\ue79b\u6c4d") : nfl2.niy.title()) + (var4_3 == null ? "" : a.c(-607763068, "\u45a7\u3c81\ub6c5") + nfl.clock(var4_3.refreshAt - l));
            }
            case 6 -> a.c(-1211701687, "\ue271\u9bd8\u117e\u8f08\u04ad\u860c\u3841\ub1bf\u2fec\ua55e\u2281\ud8fa\u562e\ucf94\u45b6\uc34a");
            case 7 -> a.b("\u247d\u5de8\ud73a\u4944\uc2ed\u4032", -1141825439) + (nfl2.niz == null ? a.b("\ub3cd\uca04\u40a2\uded4\u5502", -1870153856) : nfl2.niz.title()) + a.d("\u91ac\ue88a\u62ce", -526365120, -1414996017) + nfl2.ngz.mined() + a.c(1299589695, "\u2a1a\u57bb\udd63\u4315\uccd0") + (nfl2.ngz.hasBrain() ? a.c(1965951536, "\u0a18\u733e\uf97a\u6316\ue8c9\u6e74\ud45e\u5dd1") + nfl2.njw() : "");
            case 8 -> a.d("\ud89b\ua108\u2bac", 1216322443, 328681221);
            case 9 -> {
                switch (nfl2.nin) {
                    case -1: {
                        yield a.c(1218314701, "\u05da\u7c46\uf285\u6895\ue339\u6589\udfd1\u5624\ucc6f\u46d6") + nfl2.niq + a.b("\ub848\uc1f0\u4bb4\ud552\u5a98\udc24\u6267", 9484390) + nfl2.nln() + a.b("\u8e33\uf3e1\u7947\ue735\u68f7", -2050519530) + 3 + a.c(-869306110, "\u7137\u0c9b\u8645\u184c\u93eb\u1527\uab1d\u22e0\ub8a9\u321a\ub5be\u4bac\uc165\u58ad\ud28c\u5408\uee32\u61e2\ufb5d\u7914\uf0eb") + Math.max(1, pjd.position(nfl2.nmb())) + a.d("\u9ba6\ue603\u68c0", -1186172628, 603056804);
                    }
                    case 0: {
                        yield a.c(-685897817, "\u03b0\u7a2c\uf4ef\u6eff\ue553\u63e3\ud9bb\u504e\uca05\u40bc") + nfl2.niq + a.c(-290035785, "\u6790\u1e28\u946c\u0a8a\u854a\u03fc\ub9da\u3050\uae07\u24c3\ua773\u591f\ud7c5\u4a64") + nfl2.nln();
                    }
                    case 1: {
                        if (nfl2.nik > l) {
                            yield a.c(-2045954688, "\u31b6\u4810\uc2cd\u5cb2\ud76f\u51df\uebf2\u6201\uf83c\u7690\uf14e\u0f2f\u8599\u1c53\u9601\u10fb\uaab0\u2175\ubb51\u3d97") + (nfl2.nik - l + 999L) / 1000L + a.c(2006479108, "\u7126\u0cf6");
                        }
                        yield a.c(1349525712, "\u24e3\u5d45\ud798\u49e7\uc23a\u448a\ufea7\u7754\ued69\u63c5\ue41b\u1a7a\u90cc\u0906\u8354\u05ae\ubfe5");
                    }
                }
                yield nfl2.nhd.status();
            }
        };
    }

    private String njw() {
        double d;
        toq toq2 = this.ngz.brain();
        double d2 = d = toq2 == null ? Double.NaN : toq2.ratio();
        if (Double.isNaN(d)) {
            return "";
        }
        long l = Math.round((d - 1.0) * 100.0);
        return a.d("\ue0ec", -864896176, -1367778403) + (l >= 0L ? a.c(-7143762, "\ufe84") : "") + l + a.c(1989996772, "\uf0c9\u897d\u07b4\u9ddf\u126a\u94ac\u2efb\ua70e");
    }

    public static toq neuroBrain() {
        nfl nfl2 = ngu;
        return nfl2 == null || !nfl2.isEnabled() ? null : nfl2.ngz.brain();
    }

    public String debug() {
        return (Object)((Object)this.nhp) + a.c(1903570080, "\u2c86\u557f\udfa1\u41c7\uca07\u4cee") + this.nhr + a.d("\u67dd\u1e21\u94f6\u0a80\u815c\u07ec\ubde6", -1697615986, -367130508) + this.ngz.mined() + a.b("\uf46d\u8d88\u0747\u992c\u12e6\u944f\u2e05\ua7a7", 967308357) + this.nha.thrown() + a.c(28523828, "\u3d1d\u44fe\uce3a\u5058\udb9c\u5d3a\ue76f\u6e99\uf088") + this.ngz.reverts() + a.d("\ua513\udcf2\u5623\uc845\u4393\uc52f\u7f76\uf690\u6886\ue251", -1058560118, -2056322381) + this.ngz.predicted() + a.c(-1589167482, "\u3add\u4311\uc98a\u57fc\udc34\u5ac8") + this.ngx.hopMs() + a.d("\uccd6\ub530\u3ff5\ua197\u2a42\uacbe", -616107490, -1843904786) + this.ngx.warpMs() + (this.ngz.area() == null ? "" : a.b("\u5d61\u2491\uae51\u3037\ubbe4\u3d09", -417243833) + this.ngz.area()) + a.d("\ud827", 911310596, 1082304258) + this.ngz.dozer() + a.d("\ud108\ua8c2", -1868478420, 2113771782) + this.ngz.sweepStats() + a.c(-1516353678, "\u472e");
    }

    public String action() {
        return this.ngz.action() + String.format(Locale.ROOT, a.d("\u12c0\u6b21\ue1ee\u7f92\uf44a\u72a8\uc8e3\u4119\udf59\u55bf", 2118010442, -1640934240), this.nhb.lastPlan());
    }

    public static void onMessage(Text text) {
        nfl nfl2 = ngu;
        if (nfl2 != null) {
            nfl2.onChat(text);
        }
    }

    public void onChat(Text text) {
        boolean bl;
        nfl nfl2 = this;
        if (!nfl2.isEnabled() || text == null) {
            return;
        }
        nfl2.nhk.onChat(text);
        String string = pfl.title(text.getString());
        boolean bl2 = nfl2.nhp == nff.HOP || nfl2.nhp == nff.BASE && nfl2.nin == 0;
        boolean bl3 = bl = nfl2.nhp == nff.WARP || nfl2.nhp == nff.BASE && nfl2.nin == 1;
        if (bl2) {
            if (string.contains(a.d("\ud5ad\uac69\u26b9", 1759931051, 922467142)) && (string.contains(a.b("\ud728\uaeed\u244b\uba48\u3198\ub75c", -840314001)) || string.contains(a.c(-1544927448, "\u4310\u3aa0\ub079\u2e06\ua5d0\u2314\u994e")) || string.contains(a.b("\u3b69\u42d5\uc873\u5679\udda4\u5b19\ue130", -1555939501))) || string.contains(a.c(-1378966369, "\ua4ef\udd53\u579e\uc9f8\u422b\uc49f\u7ed1\uf779\u6965\ue3d8\u640a\u9e7b\u10a7\u8910\u0354\u85b4\u3ffa"))) {
                nfl2.nib = true;
            } else if (string.contains(a.d("\u21ac\u5815\ud2c7\u4cbc\uc714\u41a6\ufbf4\u7279", 574677753, 177325920)) || string.contains(a.d("\u77cc\u0e75\u80b3\u1aa1\u9101\u17b4\uadec\u2418\uba38\u3084\ub33b\u4d55\uc383\u5a38\ud065\u5695\uecaf\u6377", -1290392137, -570991020)) || string.contains(a.d("\ue83e\u918e\u1b46\u8563\u0ef5\u8853\u3217\ubbee\u25b4\uaf08\u28d8\ud2a7\u5c79", 1027639150, 1455845171)) || string.contains(a.b("\u0523\u7c98\uf63e\u683a\ue3e7\u6557\udf01\u56f6\uc8a1\u4218", -787021546))) {
                nfl2.nic = true;
            }
        }
        if (bl) {
            Matcher matcher;
            if (string.contains(a.b("\u9feb\ue626\u6c8b\uf2f3\u792c\uff95\u45ce", -526345262)) || string.contains(a.c(1597318470, "\u217f\u58b2\ud21f\u4c67\uc7b8\u4165\ufb5a"))) {
                nfl2.nil = true;
            } else if (string.contains(a.b("\ufae4\u8327\u0981\u9785\u1c50", 939851430)) && (string.contains(a.b("\uab12\ud2a9\u580f\uc60b\u4dd5\ucb6d\u7142", -747458774)) || string.contains(a.c(-247065775, "\u171b\u6edd\ue400\u7a7f\uf1a2\u7712\ucd3f\u44cc"))) && (matcher = nft.matcher(string)).find()) {
                nfl2.nik = System.currentTimeMillis() + (long)Integer.parseInt(matcher.group(1)) * 1000L + 300L;
            }
        }
    }

    private boolean njx() {
        Boolean bl = nfi.solo;
        return bl == null || bl == false;
    }

    private static String njy() {
        String string = nfi.anarchies;
        return string != null ? string : a.b("\u3f77\u46c7\ucc17\u5278\ud9b3\u5f02\ue552\u6cbd\uf2ee\u784d\uff9c\u05ee\u8b27\u1289\u98db\u1e2d\ua47a\u2ba7\ub107\u3755\ubea0\uc4ee\u4a43\ud193\u57ed\udd23\u649c\uead8\u702a\uf67a\u7dd5\u831c\u0957\u90a3\u16e8\u9c55\u239b\ua9e3\u2f31\ub69c\u3cd7\u422f\uc878", -166772883);
    }

    private static long njz() {
        Long l = nfi.minMineMs;
        return l != null ? l : 25000L;
    }

    private static long nka() {
        Long l = nfi.maxMineMs;
        return l != null ? l : 150000L;
    }

    private Set<qwj> nkb() {
        EnumSet<qwj> enumSet = EnumSet.noneOf(qwj.class);
        if (this.ngp.get()) {
            enumSet.add(qwj.COMMON);
        }
        if (this.ngq.get()) {
            enumSet.add(qwj.MYTHIC);
        }
        if (this.ngr.get()) {
            enumSet.add(qwj.LEGENDARY);
        }
        return enumSet.isEmpty() ? EnumSet.allOf(qwj.class) : enumSet;
    }

    private static boolean nkc(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10442) || blockState.method_27852(Blocks.field_29029);
    }

    private void nkd() {
        if (this.mc.method_1562() != null) {
            this.mc.method_1562().method_45730(a.b("\ueeb5\u971e\u1dd0", -1258623291));
        }
    }

    @Override
    protected void onEnable() {
        this.ngx.clear();
        this.nhr = -1;
        this.nhs = -1;
        this.nht = false;
        this.niw = -1;
        this.nje = false;
        this.njp = 0L;
        this.njq = "";
        this.nhi.clear();
        this.nhj.clear();
        this.nhl.clear();
        this.nhm.clear();
        this.nhk.reset(this.nmb());
        this.nhn = false;
        this.nir = 0L;
        this.niu = false;
        this.nhd.forget();
        this.ngz.resetCounters();
        this.nhc.reset();
        this.nhb.reset();
        this.nhb.forgetFrame();
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        this.nit = clientPlayerEntity != null && qpw.ready(clientPlayerEntity.method_31548()) && qpw.misplaced(clientPlayerEntity.method_31548(), qpw.targets(clientPlayerEntity.method_31548(), clientPlayerEntity.method_6079())) == 0;
        this.nly(nff.START);
    }

    @Override
    protected void onDisable() {
        this.ngz.stop(this.mc);
        this.nhd.stop(this.mc);
        this.nhe.cancel(this.mc);
        this.nhf.stop(this.mc, this.mc.field_1724);
        this.nha.cancel(this.mc);
        this.nhb.reset();
        this.nhb.forgetFrame();
        if (this.ngw == null) {
            qwo.clear();
        }
        this.nhk.reset(this.nmb());
        pjd.cancel(this.nmb());
        this.nhp = nff.START;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        this.nhb.newTick();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null) {
            return;
        }
        if (this.nhn) {
            this.ngz.releaseKeys(minecraftClient);
            this.nhd.walker().releaseKeys(minecraftClient);
            return;
        }
        if (this.nha.busy()) {
            this.ngz.releaseKeys(minecraftClient);
            this.nhd.walker().releaseKeys(minecraftClient);
            this.nha.startTick(minecraftClient);
            return;
        }
        if (this.nhf.active()) {
            this.ngz.releaseKeys(minecraftClient);
            this.nhd.walker().releaseKeys(minecraftClient);
            this.nhf.startTick(minecraftClient);
            return;
        }
        if (this.njg) {
            this.nhd.walker().releaseKeys(minecraftClient);
            this.ngz.startTick(minecraftClient, clientPlayerEntity);
            return;
        }
        if (this.nhp == nff.BASE) {
            this.ngz.releaseKeys(minecraftClient);
            if (this.nin == 2) {
                this.nhd.startTick(minecraftClient, clientPlayerEntity);
            } else {
                this.nhd.walker().releaseKeys(minecraftClient);
            }
            return;
        }
        if (this.nhe.active() || !this.nkg()) {
            this.ngz.releaseKeys(minecraftClient);
            return;
        }
        this.ngz.startTick(minecraftClient, clientPlayerEntity);
    }

    private void nke(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        boolean bl;
        boolean bl2 = bl = clientPlayerEntity.method_5805() && (this.nhp != nff.BASE || this.nin != 2) && !this.nkg() && qdz.trapped((World)minecraftClient.field_1687, clientPlayerEntity) != null;
        if (!bl) {
            if (this.njg) {
                this.njg = false;
                if (!this.nkg()) {
                    this.ngz.stop(minecraftClient);
                }
            }
            return;
        }
        if (this.nhf.active()) {
            this.nhf.stop(minecraftClient, clientPlayerEntity);
        }
        if (!this.njg) {
            this.njg = true;
            this.nji = l;
            this.nma(a.b("\u69df\u1049\u9aeb\u0499\u8f4c\u09f2\ub3d5\u3e3f\ua472\u2ad1\ua913\u5368\uddba\u440f\uce56\u48d2\uf6f8\u591d\ue39a\u61d9\ue857\u9277\u1cce\u8710\u011b\u8bb3\u3202\ubc2d\u26d5\ua089", 798453206), vhz.ALERT);
        }
        if (this.ngz.status() != qdw.WORKING || !this.ngz.guarding()) {
            this.ngz.guard(pzc.empty(clientPlayerEntity.method_24515()));
        }
    }

    private boolean nkf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (this.nhk.tick(minecraftClient, clientPlayerEntity, this.nmb(), this.ngo.get(), l)) {
            if (!this.nhn) {
                this.nhn = true;
                this.nho = false;
                this.ngz.stop(minecraftClient);
                this.nhd.stop(minecraftClient);
                this.nhe.cancel(minecraftClient);
                this.nhf.stop(minecraftClient, clientPlayerEntity);
                this.nha.cancel(minecraftClient);
                this.njg = false;
                this.njf = false;
                this.nhs = -1;
                this.nly(nff.IDLE);
            }
            this.nho |= this.nhk.active();
            this.nhb.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
            return true;
        }
        boolean bl = this.nhk.takeReturned();
        if (bl || this.nhn) {
            this.nhn = false;
            if (bl || this.nho) {
                this.nhr = !this.njx() ? 0 : (bl ? this.nln() : -1);
                this.nht = false;
                this.njp = 0L;
                this.nly(nff.START);
            } else {
                this.nly(nff.DECIDE);
            }
        }
        return false;
    }

    private boolean nkg() {
        return this.nhp == nff.MINE || (this.nhp == nff.WAIT || this.nhp == nff.SETTLE) && this.ngz.status() == qdw.WORKING;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        boolean bl;
        long l;
        ttb ttb2;
        ClientPlayerEntity clientPlayerEntity;
        ++this.njr;
        if (this.ngw != null && this.njr % 20 == 1) {
            this.njv();
        }
        if ((clientPlayerEntity = minecraftClient.field_1724) == null || minecraftClient.field_1687 == null) {
            return;
        }
        pjd.keep(this.nmb());
        if (this.ngw == null) {
            wcn.ensure(minecraftClient);
        }
        tck tck2 = (ttb2 = lfa.mineModel()) != null ? ttb2.hand : lfa.model(lex.MINE);
        double d = ttb2 != null ? lfa.mineBoost() : 0.0;
        this.nhb.use(tck2 != null ? tck2 : tck.profile1());
        this.nhb.tune(1.0 + d, 1.0, 1.0);
        this.nhb.reactionScale(1.0 / (1.0 + 2.0 * d));
        this.nhb.verticalAware(ttb2 == null);
        this.nhb.cap(ttb2 != null && ttb2.style.turnCap > 0.0f ? (double)ttb2.style.turnCap * (1.0 + d) : 0.0);
        this.nhb.pointSize(ttb2 != null ? 0.5 : 0.3);
        this.nhc.cap(110.0);
        this.ngz.boost(d);
        this.ngz.brain(ttb2);
        this.ngz.configure(tck2 != null ? null : this.nhc, ttb2 == null || ttb2.style.sprints(), true);
        this.ngz.predict(this.ngs.get(), minecraftClient);
        this.nhd.walker().configure(this.nhc, true, false);
        this.nha.noThrow = this.nhp == nff.BASE;
        this.nlx();
        if (minecraftClient.field_1755 instanceof DeathScreen && clientPlayerEntity.method_29504() && this.njr % 20 == 0) {
            clientPlayerEntity.method_7331();
            minecraftClient.method_1507(null);
        }
        if (clientPlayerEntity.method_29504() && this.nhp == nff.BASE) {
            this.nhd.stop(minecraftClient);
            this.nly(nff.DECIDE);
        }
        if (this.nht && this.nhu != clientPlayerEntity) {
            this.nht = false;
        }
        if (this.nkf(minecraftClient, clientPlayerEntity, l = System.currentTimeMillis())) {
            return;
        }
        this.nke(minecraftClient, clientPlayerEntity, l);
        boolean bl2 = bl = !this.njg && (this.nhp != nff.BASE || this.nin == 2 && this.nhd.canPause());
        if (this.njr % 10 == 0 && !this.nhf.active() && !this.nha.busy() && !this.nhe.active() && minecraftClient.field_1755 == null && bl && clientPlayerEntity.method_5805() && qma.hungry(clientPlayerEntity)) {
            if (qma.canEat(clientPlayerEntity)) {
                this.nhf.start(clientPlayerEntity);
            } else {
                int n = qma.stored(clientPlayerEntity);
                if (n >= 0) {
                    this.nha.swaps(n, clientPlayerEntity.method_6079().method_7960() ? 40 : 8);
                }
            }
        }
        try {
            if (!(this.nhf.active() || this.nha.busy() || this.njg && l - this.nji < 12000L)) {
                this.nki(minecraftClient, clientPlayerEntity, l);
            }
        }
        catch (RuntimeException runtimeException) {
            System.out.println(a.c(686499189, "\u253e\u5cbb\ud669\u4803\uc3f6\u4563\uff37\u76cd\ue8cd\u6266") + runtimeException);
            runtimeException.printStackTrace();
            this.ngz.stop(minecraftClient);
            this.nhd.stop(minecraftClient);
            this.nly(nff.DECIDE);
        }
        if (this.nha.busy()) {
            this.nha.endTick(minecraftClient, clientPlayerEntity, ngn);
        }
        if (this.ngw == null) {
            this.nlk(minecraftClient, clientPlayerEntity);
        }
        if (this.nha.busy()) {
            if (this.nha.job() == qoc.JUNK && this.njn != null) {
                this.nkh(minecraftClient, clientPlayerEntity, this.njo, this.njn);
            } else {
                this.nhb.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
            }
        } else if (this.nhf.active()) {
            this.nhf.endTick(minecraftClient, clientPlayerEntity);
            this.nhb.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
        } else if (this.njg) {
            this.ngz.endTick(minecraftClient, clientPlayerEntity, this.nhb);
        } else if (this.nhp == nff.BASE) {
            if (this.nin != 2) {
                this.nhb.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
            }
        } else if (this.nkg() && !this.nhe.active()) {
            this.ngz.endTick(minecraftClient, clientPlayerEntity, this.nhb);
        } else {
            this.nhb.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
        }
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || minecraftClient.field_1755 != null || !minecraftClient.field_1729.method_1613()) {
            this.nhb.forgetFrame();
            return;
        }
        this.nhb.frame(minecraftClient, clientPlayerEntity);
    }

    private void nkh(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Object object, Vec3d vec3d) {
        this.nhb.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
        this.nhc.aim(minecraftClient, clientPlayerEntity, object, vec3d);
    }

    private void nki(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (this.nhe.active()) {
            if (this.nhe.tick(minecraftClient, clientPlayerEntity, l)) {
                this.nhi.add(this.nis);
                this.nma(a.c(-282126880, "\u11fb\u6868\ue2cb\u7cc6\uf302\u71df\ucbf7\u427f\udc5c\u56e8\ud131") + (this.nis > 0 ? a.c(-1828324346, "\ufc22\u818e\u0b50\u9131") + this.nis : "") + a.b("\u58b1\u211a", -44345207) + this.nhe.result(), this.nhe.ok() ? vhz.CHECK : vhz.ALERT);
            }
            return;
        }
        switch (this.nhp.ordinal()) {
            case 0: {
                this.nkj(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 1: {
                this.nkk(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 2: {
                this.nks(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 3: {
                this.nkt(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 4: {
                this.nkw(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 5: {
                this.nkz(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 6: {
                this.nlf(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 7: {
                this.nli(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 9: {
                this.nlt(minecraftClient, clientPlayerEntity, l);
                break;
            }
            case 8: {
                if (this.njr % 20 == 0 && this.nls(minecraftClient, clientPlayerEntity, l)) {
                    return;
                }
                if (l - this.nhq <= 2500L) break;
                this.nly(nff.DECIDE);
            }
        }
    }

    private void nkj(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        pzc pzc2;
        pzp pzp2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(this.njx() ? qqs.parseList(nfl.njy()) : List.of(Integer.valueOf(0)));
        arrayList.remove((Object)this.nln());
        this.ngx.list(arrayList);
        if (!this.njx()) {
            this.nhr = 0;
        }
        if ((pzp2 = pzw.read(minecraftClient, 72.0)) != null && pzp2.pos().method_1022(clientPlayerEntity.method_73189()) <= 30.0 && (pzc2 = pzc.detect((World)minecraftClient.field_1687, pzp2.pos())) != null && pzc2.ores >= 20 && pzc2.distanceTo(clientPlayerEntity.method_73189()) < 24.0) {
            this.nkx(clientPlayerEntity);
            if (this.nhr >= 0) {
                this.nlw(this.nhr, pzp2, l, false);
                this.nhg.put(this.nhr, pzc2);
                this.nhh.put(this.nhr, pzp2.pos());
            }
            this.niz = null;
            this.nhs = this.nhr;
            this.nlh(minecraftClient, clientPlayerEntity, pzc2, l);
            this.nma(a.b("\u6b4d\u12d8\u980a\u0674\u8ddd\u0f02\ub139\u38b0\ua69a\u2c2c\uabfe\u55ec\udf5b\u46e5\ucccd\u4a36\uf07b", 1909419846), vhz.PLAYER);
            return;
        }
        this.nly(nff.DECIDE);
    }

    private void nkk(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        nes nes2;
        Object object;
        if (!qof.holdsPickaxe(clientPlayerEntity) && qof.bestPickaxe(clientPlayerEntity.method_31548()) < 0 && !poi.inLobby((PlayerEntity)clientPlayerEntity)) {
            if (this.njp == 0L) {
                this.njp = l;
            }
            if (l - this.njp > 5000L) {
                this.nma(a.b("\u6362\u1afb\u905f\u0a4c\u8581\u0332\ub919\u3092\uaecf\u2066\ua3a7\u5dc4\ud70b\u4ebf\uc4e3\u4215\uf852\u77fc\ued3d\u6b1c\ue29e", -829790358), vhz.ALERT);
                this.nlz();
            }
            return;
        }
        this.njp = 0L;
        if (this.nls(minecraftClient, clientPlayerEntity, l) || this.nlp(minecraftClient, clientPlayerEntity, l)) {
            return;
        }
        if (this.nht && (object = this.nhh.get(this.nhr)) != null && object.method_1022(clientPlayerEntity.method_73189()) > 36.0) {
            this.nht = false;
        }
        if (!this.njx()) {
            this.nhr = 0;
            object = pzw.read(minecraftClient, 72.0);
            if (object == null) {
                if (this.nht) {
                    this.nly(nff.IDLE);
                } else {
                    this.nku(minecraftClient, clientPlayerEntity, l);
                }
                return;
            }
            this.nhh.put(0, ((pzp)object).pos());
            this.nlw(0, (pzp)object, l, false);
        }
        Object object2 = object = this.nhr >= 0 ? this.ngx.fresh(this.nhr, l, this.ngy) : null;
        if (object != null && this.nhh.containsKey(this.nhr)) {
            this.nhs = this.nhr;
            this.niz = object;
            if (this.nht) {
                this.nlg(true);
            } else {
                this.nku(minecraftClient, clientPlayerEntity, l);
            }
            return;
        }
        nes nes3 = nes2 = this.nhr >= 0 ? this.nkl(minecraftClient, clientPlayerEntity, l) : null;
        if (nes2 != null) {
            String string;
            this.nhs = this.nhr;
            qqm qqm2 = this.ngx.entry(this.nhr);
            this.niz = qqm2 != null && qqm2.lastTier != null ? qqm2.lastTier : qwj.COMMON;
            String string2 = string = this.nhr > 0 ? a.d("\u4778\u3ad4\ub00a\u2a6b", -1780191993, 1315252827) + this.nhr : "";
            if (!nes2.look() && (this.nht || nes2.area().distanceTo(clientPlayerEntity.method_73189()) < 24.0)) {
                this.nma(a.b("\u1095\u693c\ue39a\u7dec\uf649", 2060260536) + string + a.b("\uac34\ud1e7\u5b48\uc53c\u4e9c\uc85b\u720c\uffe3\u65db\uef6f\u68c0\u96af\u1c66\u85d8\u0f87\u8975\u3336\ubced\u265d\ua007\u2981\u53dd\ud918\u42d3", -1043682292) + nes2.diamonds() + a.c(-95041365, "\uc89b\ub53a\u3fe2\ua194\u2a4f\uacf9\u16a3\u9f5e\u0513\uaf96\u0871\uf61a\u78c9\ue179\u6b25\uedaa"), vhz.PLAYER);
                this.nlh(minecraftClient, clientPlayerEntity, nes2.area(), l);
            } else {
                this.nma(nes2.look() ? a.d("\u0a9c\u7335\uf993\u67e5\uec40", 148362841, -1310730008) + string + a.b("\u46c4\u3b67\ub1be\u2fc3\ua41d\u22a1\u9ce2\u110e\u8f59\u01fd\u823c\u783e\uf6e7\u6b35\ue16a\u638b\ud9cf\u5619\ucca6\u4af0\uc30e\ub953\u33f2\uac31\u2e5c\ua090\u192b\u9776\u0998\u8bd5g\ufeb5\u74f7\ued0b\u6f46\uc5c3\u5a20\ud449\u5296\ucb50\u456c\u3f82\ub5d0\u321e\ua8b4\u26c7\u9f68\u15db\u93e1\u0847\u863a", 464471767) : a.c(1363531596, "\ud361\uaac8\u206e\ube18\u35bd") + string + a.b("\u8d2f\uf0fc\u7a53\ue427\u6f87\ue940\u5317\udef8\u44c0\uce74\u49db\ub7b4\u3d7d\ua4c3\u2e9c\ua86e\u122d\u9df6\u0746\u811c\u089a\u72c6\uf803\u63c8", -1273787113) + nes2.diamonds() + a.d("\u8d23\uf082\u7a5a\ue42c\u6ff7\ue941\u531b\udae6\u40ab\uea2e\u4dc9\ub3a0\u3d7b\ua4bd\u2a8d\ua866\u122d\u9dfd\u0741\u8162\u089b", 820565740, 1273781242), vhz.NAV);
                this.nku(minecraftClient, clientPlayerEntity, l);
            }
            return;
        }
        qqg qqg2 = this.ngx.decide(l, this.nhr, this.nht ? 0L : this.ngx.warpMs(), this.ngy);
        switch (qqg2.kind()) {
            case SCAN: {
                this.nhs = -1;
                this.nkp(minecraftClient, clientPlayerEntity, qqg2.id(), l);
                break;
            }
            case GO: {
                this.nhs = qqg2.id();
                if (qqg2.id() == this.nhr) {
                    if (this.nht) {
                        this.nky(minecraftClient, qqg2.entry(), l);
                        break;
                    }
                    this.nku(minecraftClient, clientPlayerEntity, l);
                    break;
                }
                qqm qqm3 = qqg2.entry();
                this.nma(a.b("\uf859\u81c4\u0b60\u9172\u1eb8\u9804\u2647", -825754554) + qqg2.id() + a.b("\ub9c1\uc06a", 984922617) + qqm3.tier.title() + a.d("\u46fb\u3b2d\ub18c\u2f88\ua42a\u2299\u9cdd", -2013874818, -61869150) + nfl.clock(qqm3.refreshAt - l), vhz.NAV);
                this.nkp(minecraftClient, clientPlayerEntity, qqg2.id(), l);
                break;
            }
            case IDLE: {
                this.nly(nff.IDLE);
            }
        }
    }

    private nes nkl(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        int n;
        Vec3d vec3d = this.nhh.get(this.nhr);
        qqm qqm2 = this.ngx.entry(this.nhr);
        if (vec3d == null || qqm2 == null || this.nhr == this.nln() || minecraftClient.field_1687 == null) {
            return null;
        }
        if (qqm2.refreshAt - l < this.ngy.minMineMs + 20000L) {
            return null;
        }
        if (nfl.nkn(this.nhl.get(this.nhr), qqm2.refreshAt)) {
            return null;
        }
        boolean bl = nfl.nkn(this.nhm.get(this.nhr), qqm2.refreshAt);
        if (bl && !this.nht) {
            this.nhl.put(this.nhr, qqm2.refreshAt);
            return null;
        }
        pzc pzc2 = this.nhg.get(this.nhr);
        if (pzc2 == null || pzc2.distanceTo(vec3d) > 30.0) {
            pzc2 = pzc.detect((World)minecraftClient.field_1687, vec3d);
            if (pzc2 == null) {
                return null;
            }
            this.nhg.put(this.nhr, pzc2);
        }
        if ((n = nfl.nkm((World)minecraftClient.field_1687, pzc2)) >= 20) {
            if (!this.nht) {
                this.nhm.put(this.nhr, qqm2.refreshAt);
            }
            return new nes(pzc2, n, false);
        }
        if (this.nht || pzc.loaded((World)minecraftClient.field_1687, vec3d)) {
            this.nhl.put(this.nhr, qqm2.refreshAt);
            return null;
        }
        if (!bl && n * 2 >= 20) {
            this.nhm.put(this.nhr, qqm2.refreshAt);
            return new nes(pzc2, n, true);
        }
        return null;
    }

    private static int nkm(World world, pzc pzc2) {
        int n = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = pzc2.minX; i <= pzc2.maxX; ++i) {
            for (int j = pzc2.minZ; j <= pzc2.maxZ; ++j) {
                if (!world.method_8393(i >> 4, j >> 4)) continue;
                for (int k = pzc2.minY; k <= pzc2.maxY; ++k) {
                    if (!nfl.nkc(world.method_8320((BlockPos)mutable.method_10103(i, k, j)))) continue;
                    ++n;
                }
            }
        }
        return n;
    }

    private static boolean nkn(Long l, long l2) {
        return l != null && Math.abs(l - l2) < 60000L;
    }

    private void nko() {
        qqm qqm2;
        qqm qqm3 = qqm2 = this.nhr >= 0 ? this.ngx.entry(this.nhr) : null;
        if (qqm2 != null) {
            this.nhl.put(this.nhr, qqm2.refreshAt);
        }
    }

    private void nkp(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, int n, long l) {
        if (!pjd.enter(this.nmb(), String.valueOf(n))) {
            pjd.cancel(this.nmb());
            this.ngx.block(n, l + 30000L);
            this.nma(a.c(-1081522088, "\u4c46\u35da\ubb19") + n + a.c(-1710005776, "\u61d5\u1c07\u96a1\u08d3\u8711") + 3 + a.d("\udeab\ua307\u29d9\ub7d0\u3c77\ubabb\u048d\uad48\u1323\u9d8d\u1a21\ue02e\u6ef8\uf735\u7d64\ufbee\u41ab\uce04", -1910320719, -553709784), vhz.INFO);
            this.nly(nff.DECIDE);
            return;
        }
        this.ngx.scanned(n);
        this.nhv = n;
        this.nhw = l;
        this.nhx = true;
        this.nid = 0;
        this.nie = 0L;
        this.nkq(minecraftClient, clientPlayerEntity);
        this.nly(nff.HOP);
    }

    private void nkq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        this.nhy = minecraftClient.field_1687;
        this.nhz = clientPlayerEntity;
        this.nia = clientPlayerEntity.method_73189();
        this.nib = false;
        this.nic = false;
        minecraftClient.method_1562().method_45730(a.b("\u6f17\u16a9", -523538572) + this.nhv);
    }

    private boolean nkr(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return minecraftClient.field_1687 != this.nhy || clientPlayerEntity != this.nhz || this.nia != null && clientPlayerEntity.method_73189().method_1022(this.nia) > 48.0;
    }

    private void nks(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (this.nkr(minecraftClient, clientPlayerEntity) || this.nib) {
            this.nhr = this.nhv;
            this.nht = false;
            this.nly(nff.ARRIVE);
            return;
        }
        if (this.nic) {
            if (this.nid >= 3) {
                this.ngx.block(this.nhv, l + 120000L);
                this.nma(a.b("\u623d\u1ba1\u917f\u0f7e\u84ac\u0260\ub844\u35da", -274569691) + this.nhv + a.c(2130781034, "\u235c\u5ef0\ud42b\u4a5b\uc186\u4748\ufd18\u74e8\ueacb\u6078\ue7a6\u19cb\u9710\u0abe\u8092\u061d\ubc53\u33fe\ua94f\u2f65\ua698\udcb7"), vhz.ALERT);
                this.nly(nff.DECIDE);
                return;
            }
            if (this.nie == 0L) {
                this.nie = l + 2500L;
            } else if (l >= this.nie) {
                ++this.nid;
                this.nie = 0L;
                this.nhx = false;
                this.nkq(minecraftClient, clientPlayerEntity);
            }
            return;
        }
        if (l - this.nhq > 15000L) {
            this.ngx.block(this.nhv, l + 90000L);
            this.nma(a.b("\uaf49\ud6d0\u5816\uc278\u49d3\ucf60\u7530\ufcbb\u62e7\ue853\u6b9e\u95f2\u1b28\u8689", -725898406) + this.nhv, vhz.ALERT);
            this.nly(nff.DECIDE);
        }
    }

    private void nkt(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (minecraftClient.field_1755 != null && !(minecraftClient.field_1755 instanceof DeathScreen)) {
            if (l - this.nhq > 20000L) {
                this.nly(nff.DECIDE);
            }
            return;
        }
        if (l - this.nhq < 1500L) {
            return;
        }
        pzp pzp2 = pzw.read(minecraftClient, 72.0);
        if (pzp2 != null) {
            this.nhh.put(this.nhr, pzp2.pos());
            this.nlw(this.nhr, pzp2, l, this.nhx);
            this.nhx = false;
            if (pzp2.pos().method_1022(clientPlayerEntity.method_73189()) <= 12.0) {
                this.nkx(clientPlayerEntity);
            }
            this.nly(nff.DECIDE);
            return;
        }
        if (l - this.nhq > 4000L) {
            this.nku(minecraftClient, clientPlayerEntity, l);
        }
    }

    private void nku(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        this.nig = 0;
        this.nly(nff.WARP);
        this.nkv(minecraftClient, clientPlayerEntity, l, a.d("\u84c1\ufd66\u77a6\ue9d5\u6252\ue4ae\u5ef9\ud70f\u495b", 1800882882, -253309315));
    }

    private void nkv(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l, String string) {
        String string2 = string.trim();
        if (string2.startsWith(a.b("\u4b5c", -922530958))) {
            string2 = string2.substring(1);
        }
        if (!string2.isEmpty()) {
            minecraftClient.method_1562().method_45730(string2);
        }
        ++this.nig;
        this.nif = l;
        this.nih = clientPlayerEntity.method_73189();
        this.nii = minecraftClient.field_1687;
        this.nij = clientPlayerEntity;
        this.nik = 0L;
        this.nil = false;
        this.nim = 0L;
    }

    private void nkw(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (this.nim == 0L) {
            long l2;
            boolean bl;
            boolean bl2 = minecraftClient.field_1687 != this.nii || clientPlayerEntity != this.nij || clientPlayerEntity.method_73189().method_1022(this.nih) > 2.5;
            Vec3d vec3d = this.nhh.get(this.nhr);
            boolean bl3 = bl = this.nik > 0L && l > this.nik + 1500L && vec3d != null && vec3d.method_1022(clientPlayerEntity.method_73189()) <= 14.0;
            if (bl2 || bl) {
                this.nim = l;
                this.nkx(clientPlayerEntity);
                this.ngx.warpTook(l - this.nif);
                return;
            }
            long l3 = l2 = this.nik > 0L ? this.nik + 5000L : this.nif + 12000L;
            if (this.nil || l > l2) {
                if (this.nig < 2) {
                    this.nkv(minecraftClient, clientPlayerEntity, l, a.b("\u4db7\u3410\ubed0\u20a3\uab24\u2dd8\u978f\u1e79\u802d", 1779781065));
                    return;
                }
                if (this.njx() && this.nhr >= 0) {
                    this.ngx.block(this.nhr, l + 120000L);
                }
                this.nma(a.c(697729987, "\u87f6\ufe6f\u70a9\ueac7\u6111\ue7a5\u5d8e\ud47b\u4a5b\uc0e9\u473f\ubd31\u33eb\uae36\u2007\ua681\u1cc0\u931f\u09a6\u8ff6\u067f\u7c2c\uf2e5\u694c\uef4d\u6590\udc21\u5202\uc8fb\u4ea7\uc51a\u3fa4\ub1f6\u280a\uaa49\u2490\u9b3f\u113b\u97ef\u0e5f") + (this.nhr > 0 ? a.b("\u1ecb\u6367\ue9b9\u73d8", 1145773807) + this.nhr : ""), vhz.ALERT);
                this.nly(this.njx() ? nff.DECIDE : nff.IDLE);
            }
            return;
        }
        if (l - this.nim < 700L) {
            return;
        }
        pzp pzp2 = pzw.read(minecraftClient, 72.0);
        if (pzp2 != null) {
            this.nhh.put(this.nhr, pzp2.pos());
            this.nlw(this.nhr, pzp2, l, this.nhx);
            this.nhx = false;
            this.nly(nff.DECIDE);
            return;
        }
        if (l - this.nim > 6000L) {
            this.nma(a.b("\uac33\ud5aa\u5b6c\uc10f\u4ad2\ucc6d\u764b\ufbd9\u61e4\ueb27\u6cf5\u968e\u185a\u8194\u0bba\u8d32\u331e\ub8a7\u226c\ua448\u2db8\u57e0", 1615505464) + (this.nhr > 0 ? a.d("\ua868\ud5c4\u5f1a\uc57b", 562673347, -183689585) + this.nhr : ""), vhz.ALERT);
            if (this.njx() && this.nhr >= 0 && this.ngx.entry(this.nhr) == null) {
                this.ngx.block(this.nhr, l + 120000L);
            }
            this.nly(nff.DECIDE);
        }
    }

    private void nkx(ClientPlayerEntity clientPlayerEntity) {
        this.nht = true;
        this.nhu = clientPlayerEntity;
    }

    private void nky(MinecraftClient minecraftClient, qqm qqm2, long l) {
        this.niy = qqm2 == null ? null : qqm2.tier;
        this.niw = -1;
        this.njf = false;
        this.njj = 0L;
        this.njk = null;
        this.nma(a.c(-115977436, "\u5736\u2ea5\ua401\u3e13") + (this.niy == null ? a.d("\u8751\ufe98\u743e\uea48\u619e", -1870961822, -1071062914) : this.niy.title()) + a.c(723201994, "\u2fee\u5242\ud89c\u42fd") + this.nhr + (qqm2 == null ? "" : a.b("\u0159\u78e0", -679542405) + nfl.clock(qqm2.refreshAt - l) + a.d("\uc7da", -1971669157, 1954115753)), vhz.CLOCK);
        this.nly(nff.WAIT);
        this.nlm(minecraftClient, l);
    }

    private void nkz(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        if (this.njf && (this.ngz.parkLost() || this.ngz.status() != qdw.WORKING)) {
            this.njf = false;
            this.ngz.stop(minecraftClient);
            this.nlc(a.c(290189533, "\uf4fb\u8d42\u0384\u99e7\u123a\u9485\u2ea3\ua331\u397a\ub3c1\u346c\uce63\u40b9\ud903\u5748\ud5a3\u6bf6\ue046\u7af6\ufca6\u752d\u0f76\u81cd\u1a6d\u9c64\u16bf\uaf00"), l);
        }
        if (!this.njf && this.nht && l >= this.njj) {
            this.nlb(minecraftClient, clientPlayerEntity, l);
        }
        if (!this.njf && this.nht) {
            this.nla(clientPlayerEntity);
        }
        boolean bl4 = bl3 = this.njf || clientPlayerEntity.method_5765();
        if (!bl3 && this.njr % 20 == 0 && this.nls(minecraftClient, clientPlayerEntity, l)) {
            return;
        }
        if (this.njr % 5 != 0) {
            return;
        }
        pzp pzp2 = pzw.read(minecraftClient, 72.0);
        qqm qqm2 = this.ngx.entry(this.nhr);
        boolean bl5 = bl2 = qqm2 != null && l > qqm2.refreshAt + 2500L;
        if (pzp2 == null || pzp2.pos().method_1022(clientPlayerEntity.method_73189()) > 36.0) {
            boolean bl6;
            Vec3d vec3d = this.nhh.get(this.nhr);
            boolean bl7 = bl6 = bl3 || vec3d != null && vec3d.method_1022(clientPlayerEntity.method_73189()) <= 36.0;
            if (bl6 && bl2) {
                this.niz = this.niy != null ? this.niy : qqm2.tier;
                this.nlg(false);
            } else if (!bl6 && l - this.nix > 6000L) {
                this.nht = false;
                this.nly(nff.DECIDE);
            }
            return;
        }
        boolean bl8 = bl = this.niw >= 0 && pzp2.seconds() > this.niw + 20;
        if (bl || bl2) {
            qwj qwj2;
            qwj qwj3 = this.niy != null ? this.niy : (qwj2 = qqm2 != null ? qqm2.tier : null);
            if (bl) {
                this.nlw(this.nhr, pzp2, l, false);
            }
            this.niz = qwj2;
            this.nhh.put(this.nhr, pzp2.pos());
            this.nlg(bl);
            return;
        }
        if (pzp2.tier() != null && (qqm2 == null || qqm2.tier == pzp2.tier())) {
            this.nlw(this.nhr, pzp2, l, false);
        }
        this.niw = pzp2.seconds();
        if (bl3) {
            return;
        }
        qqg qqg2 = this.ngx.decide(l, this.nhr, 0L, this.ngy);
        if (qqg2.kind() == qqp.GO && qqg2.id() != this.nhr && qqm2 != null && qqg2.entry() != null && qqg2.entry().tier.rank() > qqm2.tier.rank()) {
            this.nly(nff.DECIDE);
        }
    }

    private void nla(ClientPlayerEntity clientPlayerEntity) {
        if (this.ngz.status() == qdw.WORKING) {
            return;
        }
        pzc pzc2 = this.nhg.get(this.nhr);
        this.ngz.guard(pzc2 != null && pzc2.distanceTo(clientPlayerEntity.method_73189()) < 30.0 ? pzc2 : pzc.empty(clientPlayerEntity.method_24515()));
    }

    private void nlb(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (!clientPlayerEntity.method_24828() && !clientPlayerEntity.method_5765()) {
            return;
        }
        BlockPos blockPos = nfl.nle(a.d("\u5231\u2b9b\ua14f\u3f2f\ub4ee\u3250\u881a\u01f8\u9fa1", -454491144, 1331646957));
        if (blockPos == null) {
            this.nlc(a.c(-2032489325, "\ua8b1\ud108\u5fce\uc5a0\u4e76\uc8c4\u72e5\ufb60\u6124\uef8f\u6858\u9229\u1c80\u8545\u0f1a\u89ee\u33ac\ubc0f\u26b5\ua48f\u2df3\u5724\ud98c\u425a\uc434\u4ef3\uf74f\u7907\ue3e3\u65b4\uee89"), l);
            return;
        }
        Vec3d vec3d = Vec3d.method_24953((Vec3i)blockPos);
        Vec3d vec3d2 = this.nhh.get(this.nhr);
        if (vec3d2 != null && vec3d2.method_1022(vec3d) > 48.0 || vec3d.method_1022(clientPlayerEntity.method_73189()) > 48.0) {
            this.nlc(a.b("\u6583\u1c31\u96e3\u08ee\u8333\u058a\ubfa8\u362f\ua872\u26db", 1024483784) + blockPos.method_23854() + a.d("\u6d25\u1080\u9a57\u042d\u8ff4\u094a\ub31d", 1962118724, -1142430906), l);
            return;
        }
        pzc pzc2 = this.nld(minecraftClient, vec3d2, blockPos);
        this.nha.equip(minecraftClient, clientPlayerEntity);
        this.ngz.park(pzc2, blockPos, true);
        this.njf = true;
        if (this.njk == null) {
            this.nma(a.b("\u35c5\u4c58\uc6fc\u5cee\ud323\u5188\uefba\u6648\uf816\u72db\uf502\u0f7b\u81dd\u181a\u9243\u14be\uaaed", -2062011956) + blockPos.method_23854(), vhz.NAV);
        }
    }

    private void nlc(String string, long l) {
        this.njj = l + 3000L;
        if (!string.equals(this.njk)) {
            this.njk = string;
            this.nma(a.c(-509177717, "\u9483\ued1a\u63dc\uf9b5\u726e\uf4a8\u4a98\uc774\u5926\ud787\u5435\uae47\u2091\ub95c\u3305\ub5fc\u0fc2\u8065\u1ad4\u9887\u116a") + string, vhz.ALERT);
        }
    }

    private pzc nld(MinecraftClient minecraftClient, Vec3d vec3d, BlockPos blockPos) {
        pzc pzc2 = this.nhg.get(this.nhr);
        if (pzc2 != null && (vec3d == null || pzc2.distanceTo(vec3d) <= 30.0)) {
            return pzc2;
        }
        if (vec3d != null) {
            pzc pzc3 = pzc.detect((World)minecraftClient.field_1687, vec3d);
            if (pzc3 != null) {
                this.nhg.put(this.nhr, pzc3);
                return pzc3;
            }
            for (Map.Entry<Integer, pzc> entry : this.nhg.entrySet()) {
                Vec3d vec3d2 = this.nhh.get(entry.getKey());
                if (entry.getKey() == this.nhr || vec3d2 == null || vec3d2.method_1022(vec3d) > 3.0) continue;
                pzc pzc4 = entry.getValue();
                int n = (int)Math.round(vec3d.field_1352 - vec3d2.field_1352);
                int n2 = (int)Math.round(vec3d.field_1351 - vec3d2.field_1351);
                int n3 = (int)Math.round(vec3d.field_1350 - vec3d2.field_1350);
                return new pzc(pzc4.minX + n, pzc4.minY + n2, pzc4.minZ + n3, pzc4.maxX + n, pzc4.maxY + n2, pzc4.maxZ + n3, pzc4.ores);
            }
        }
        return pzc.empty(blockPos);
    }

    private static BlockPos nle(String string) {
        String[] stringArray = string.trim().replace(',', ' ').split(a.b("\u56d0\u2f4e\ua5c5", -1219733873));
        if (stringArray.length < 3) {
            return null;
        }
        try {
            return BlockPos.method_49637((double)Double.parseDouble(stringArray[0]), (double)Double.parseDouble(stringArray[1]), (double)Double.parseDouble(stringArray[2]));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private void nlf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        ++this.njb;
        if (this.nht && this.ngz.status() != qdw.WORKING) {
            this.nla(clientPlayerEntity);
        }
        if (this.njb % 20 == 0 && !clientPlayerEntity.method_5765() && this.nls(minecraftClient, clientPlayerEntity, l)) {
            return;
        }
        if (this.njb % 3 != 0) {
            return;
        }
        Vec3d vec3d = this.nhh.get(this.nhr);
        pzp pzp2 = pzw.read(minecraftClient, 72.0);
        if (pzp2 != null) {
            vec3d = pzp2.pos();
            if (!this.njc && this.niw >= 0 && pzp2.seconds() > this.niw + 20) {
                this.njc = true;
                this.njd = this.njb;
                this.nlw(this.nhr, pzp2, l, false);
            } else if (!this.njc && pzp2.seconds() >= 0) {
                int n = this.niw = this.niw < 0 ? pzp2.seconds() : Math.min(this.niw, pzp2.seconds());
            }
        }
        if (!this.njc && this.njb > 200) {
            this.njc = true;
            this.njd = this.njb;
        }
        if (!this.njc || this.njb - this.njd < 12 || this.njb % 6 != 0) {
            return;
        }
        if (vec3d == null) {
            vec3d = clientPlayerEntity.method_73189();
        }
        pzc pzc2 = pzc.detect((World)minecraftClient.field_1687, vec3d);
        pzc pzc3 = this.nhg.get(this.nhr);
        if (pzc3 != null && pzc3.distanceTo(vec3d) > 30.0) {
            pzc3 = null;
        }
        if (!(pzc2 == null || pzc3 != null && pzc2.volume() < pzc3.volume() && pzc3.covers(pzc2))) {
            this.nhg.put(this.nhr, pzc2);
            pzc3 = pzc2;
        }
        if (pzc3 != null && (pzc2 != null || this.njb - this.njd > 60)) {
            this.nlh(minecraftClient, clientPlayerEntity, pzc3, l);
            this.nma(a.c(559037012, "\u3e48\u47dd\ucd0f\u5371\ud8d8\u5a07") + (this.niz == null ? a.b("\uda8e\ua347\u29e1\ub797\u3c41", -1178542397) : this.niz.title()) + (this.nhr > 0 ? a.c(-1065965862, "\ua6fe\udb52\u518c\ucbed") + this.nhr : ""), vhz.PLAYER);
            return;
        }
        if (this.njb - this.njd > 80) {
            this.nma(a.b("\uf8dd\u8144\u0f82\u95ee\u1e34\u98fd\u22b7\uab2c\u3168\ubfca\u386a\uc26b\u4cb1\ud505\u5f28\ud9d4\u67f0\uec49\u7682\uf0a6\u7956\u030e", -805569322), vhz.ALERT);
            this.ngx.mined(this.nhr);
            this.nly(nff.DECIDE);
        }
    }

    private void nlg(boolean bl) {
        this.njb = 0;
        this.njc = bl;
        this.njd = 0;
        this.nly(nff.SETTLE);
    }

    private void nlh(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, pzc pzc2, long l) {
        this.nja = l;
        this.ngx.mined(this.nhr);
        this.nko();
        this.nha.equip(minecraftClient, clientPlayerEntity);
        this.nha.unstow(clientPlayerEntity);
        this.ngz.start(pzc2);
        this.niw = -1;
        this.nly(nff.MINE);
        this.nlm(minecraftClient, l);
    }

    private void nli(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        int n;
        boolean bl;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (this.nlp(minecraftClient, clientPlayerEntity, l)) {
            return;
        }
        this.nha.unstow(clientPlayerEntity);
        if (this.niu && !this.nha.busy()) {
            this.niu = false;
            this.nit = this.nha.laidOut();
            this.nma(this.nit ? a.c(-849848680, "\u5292\u2b06\ua1da\u3fac\ub473\u32bd\u889c\u011d\u9f4e\u1193\u9220\u6821\ue6f1\u7f4c\uf51a\u73e3\uc9af\u4676") : a.d("\ub919\uc0b8\u4a1a\ud410\u5fc6\ud97c\u632b\uead4\u7481\ufa20\u79ee\u8397\u0955\u9487\u1ea3\u9856\u2212\uadc8\u370a\ub156\u3cc1\u469c\ucc30\u57e0\ud193\u5b32\ue2fd\u6cd2\uf62b\u7414\ufbb8\u0568\u8f2e\u16de\u908e", 2084836137, 79474227), this.nit ? vhz.CHECK : vhz.ALERT);
        }
        if (this.njr % 20 == 0) {
            if (this.nls(minecraftClient, clientPlayerEntity, l)) {
                return;
            }
            pzp pzp2 = pzw.read(minecraftClient, 72.0);
            if (pzp2 != null) {
                if (this.niw >= 0 && pzp2.seconds() > this.niw + 20) {
                    qqm qqm2 = this.ngx.entry(this.nhr);
                    this.niz = qqm2 != null ? qqm2.tier : this.niz;
                    this.nlw(this.nhr, pzp2, l, false);
                    this.niw = pzp2.seconds();
                    this.ngz.stop(minecraftClient);
                    this.nlg(true);
                    return;
                }
                if (this.nhr >= 0) {
                    this.nlw(this.nhr, pzp2, l, false);
                    this.ngx.mined(this.nhr);
                }
                this.niw = pzp2.seconds();
            }
            if (!(qof.holdsPickaxe(clientPlayerEntity) || this.nha.busy() || this.nha.equip(minecraftClient, clientPlayerEntity))) {
                this.nma(a.c(-1295647491, "\uf8e9\u8170\u0bd4\u91c7\u1e0a\u98b9\u2292\uab19\u3544"), vhz.ALERT);
                this.nlz();
                return;
            }
            if (this.nit && this.njr % 400 == 0 && qpw.misplaced(playerInventory, qpw.targets(playerInventory, clientPlayerEntity.method_6079())) > 3) {
                this.nit = false;
            }
        }
        if (!(this.nit || this.niu || this.njr % 20 != 10 || this.nha.busy() || this.ngz.breaking() || !qpw.ready(playerInventory))) {
            this.nma(a.d("\u0312\u7afd\uf05b\u6e21\ue5f5\u634f\udd09\u50e5\uceb7\u4407\uc3a5\u39a4\ub77e\u2ecc\ua08d\u2670\u985f\u17fe\u8d3c\u0b16\u82e0\uf8ba\u760d\ueda3\u6ba5\ue176\u58bb\ud284\u4c6b\uca3f\u4183\ubf55\u3512\uac9c\u2abd\ua07c\u1fa7", -1514716050, 561005380), vhz.INFO);
            this.nha.layout();
            this.niu = true;
            return;
        }
        if (this.nit && this.njr % 10 == 5 && l - this.niv > 3000L && !this.nha.busy()) {
            this.nll(minecraftClient, clientPlayerEntity, l);
        }
        boolean bl2 = bl = minecraftClient.field_1761 != null && minecraftClient.field_1761.method_2923();
        if (!this.nha.busy() && !bl && this.njr % 5 == 0 && l - this.njl > 5000L && (n = qof.empty(playerInventory)) <= 2) {
            if (qof.hasJunk(playerInventory, ngn)) {
                this.nlj(clientPlayerEntity);
                this.ngz.avoid(clientPlayerEntity.method_73189(), 1200);
                this.njl = l;
                this.nje = false;
            } else if (!this.nje && n == 0 && !this.nit) {
                this.nje = true;
                this.nma(a.b("\u1b59\u62cd\ue811\u7667\ufdb8\u7b76\uc157\u48d6\ud685\u5858\udb94\u21e4\uaf36\u3682\ubcd2", 1890197326), vhz.ALERT);
            }
        }
        long l2 = this.njx() ? this.ngx.leaveAt(l, this.nhr, this.niz, l - this.nja, this.ngy) : Long.MAX_VALUE;
        boolean bl3 = l - this.nja > nfl.nka();
        qqm qqm3 = this.nhr >= 0 ? this.ngx.entry(this.nhr) : null;
        boolean bl4 = qqm3 != null && qqm3.refreshAt > this.nja + 20000L && qqm3.refreshAt - l < 20000L;
        qdw qdw2 = this.ngz.status();
        if (l >= l2 || bl3 || bl4 || qdw2 == qdw.DONE || qdw2 == qdw.FAR) {
            if (this.nha.busy()) {
                return;
            }
            int n2 = this.ngz.diamondsLeft();
            this.nma(a.c(-477125922, "\ua6cb\udf57\u558e\ucbfb\u402d\uc693\u7ccb\uf121") + this.ngz.mined() + a.d("\u8e96\uf337\u79ef\ue799\u6c42\ueaf4\u50ae\ud953", 1755230930, -1212269460) + (bl4 ? a.c(1658862849, "\u3d00\u6485\uce62\u547b\udfd4\u5910\ue344\u6ac7\uf088\u7e58\uf9ff\u0382\u8d2b\u14ed\u9ecf\u1c5f\ua20e\u2dd0\ub76f\u313d\ub8c6\uc29d\u4c54\ud786\u51f7\udf45\u66fa\uecbd\u7648\uf06e\u7fbe\u857a\u0f51") : (qdw2 != qdw.DONE ? "" : (n2 > 0 ? a.b("\u411a\u38a7\ub66a\u2864\ua3b0\u2573\u9f2b\u16df\u88ff\u0243\u81fc", -1625210563) + n2 + a.c(1319975349, "\u3987\u6002\ucae5\u5080\udb53\u5de9\ue7cd\u6e38\uf01a\u7ebe\ufd70\u0709\u8dcb\u1060\u9a37\u1cc7\ua687\u2928") : a.c(487681882, "\u6f7b\u16c6\u987d\u0674\u8dd6\u0b60\ub141\u3ca0\ua6e0\u2c2d\uabfc\u518e\udf2b")))), vhz.CHECK);
            this.ngz.stop(minecraftClient);
            this.nko();
            this.nhs = -1;
            if (qdw2 == qdw.FAR) {
                this.nht = false;
            } else if (qof.hasJunk(playerInventory, ngn)) {
                this.nlj(clientPlayerEntity);
                this.njl = l;
                this.nje = false;
            }
            this.nly(nff.DECIDE);
        }
    }

    private void nlj(ClientPlayerEntity clientPlayerEntity) {
        double d;
        Vec3d vec3d;
        pzc pzc2;
        this.nha.dropJunk(64);
        this.njo = new Object();
        Vec3d vec3d2 = clientPlayerEntity.method_33571();
        Vec3d vec3d3 = null;
        pzc pzc3 = pzc2 = this.nhr >= 0 ? this.nhg.get(this.nhr) : null;
        if (pzc2 == null) {
            pzc2 = this.ngz.area();
        }
        if (pzc2 != null && pzc2.maxX >= pzc2.minX) {
            vec3d = pzc2.center();
            d = vec3d2.field_1352 - vec3d.field_1352;
            double d2 = vec3d2.field_1350 - vec3d.field_1350;
            double d3 = Math.sqrt(d * d + d2 * d2);
            if (d3 > 1.5) {
                vec3d3 = new Vec3d(d / d3, 0.0, d2 / d3);
            }
        }
        if (vec3d3 == null) {
            vec3d = clientPlayerEntity.method_5828(1.0f);
            d = Math.sqrt(vec3d.field_1352 * vec3d.field_1352 + vec3d.field_1350 * vec3d.field_1350);
            vec3d3 = d < 0.1 ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(vec3d.field_1352 / d, 0.0, vec3d.field_1350 / d);
        }
        this.njn = vec3d2.method_1031(vec3d3.field_1352 * 4.0, 2.2, vec3d3.field_1350 * 4.0);
    }

    private void nlk(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        pzc pzc2;
        pzc pzc3 = pzc2 = this.nhr >= 0 ? this.nhg.get(this.nhr) : null;
        if (pzc2 == null && this.nkg()) {
            pzc2 = this.ngz.area();
        }
        if (pzc2 == null || pzc2.maxX < pzc2.minX || pzc2.distanceTo(clientPlayerEntity.method_73189()) > 64.0) {
            qwo.clear();
            return;
        }
        if (this.njr % 10 == 0) {
            qwo.scan((World)minecraftClient.field_1687, pzc2, clientPlayerEntity.method_33571());
        }
        qwo.focus(this.ngz.focus());
    }

    private void nll(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        boolean bl;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (qpw.count(playerInventory, Items.field_22019) > 0 || qof.empty(playerInventory) > 0) {
            return;
        }
        boolean bl2 = bl = !minecraftClient.field_1687.method_8390(ItemEntity.class, clientPlayerEntity.method_5829().method_1009(6.0, 3.0, 6.0), itemEntity -> itemEntity.method_6983().method_31574(Items.field_22019)).isEmpty();
        if (!bl) {
            return;
        }
        int n = -1;
        if (playerInventory.method_5438(32).method_31574(Items.field_8695) && playerInventory.method_5438(32).method_7947() == 1) {
            n = 32;
        } else {
            for (int i = 9; i < 36 && n < 0; ++i) {
                if (!playerInventory.method_5438(i).method_31574(Items.field_8695) || playerInventory.method_5438(i).method_7947() != 1) continue;
                n = i;
            }
        }
        if (n >= 0) {
            this.niv = l;
            this.nha.throwOne(n);
            this.nma(a.d("\udd11\ua4f4\u2e52\ub024\u3bfc\ubd48\u071a\u8af2\u10b3\u9a0d\u1dd4\ue7a0\u6975\uf0c6\u7a91\uf87a\u4628\uc9f4\u5757\ud511\u5ce4\u26bc\ua808\u33d7\ub1bd\u1b58\u82df\u0890\u9218\u143a\u9f85\u615b\ueb1b\u72e2\uf4b3\u7e06\uc1af\u4fb0\ucd7c\u54cc\ude99\ua47c\u2a32\uad8b\u375a\ub926\u04eb\u8a3b\u0c0e\u97da\u19d5", -1482987976, 2095038222), vhz.INFO);
        }
    }

    private void nlm(MinecraftClient minecraftClient, long l) {
        int n;
        int n2 = n = this.njx() ? this.nhr : 0;
        if (this.nhe.active() || n < 0 || n == this.nln() || this.nhi.contains(n)) {
            return;
        }
        this.nis = n;
        this.nhe.begin(minecraftClient, a.c(2061203581, "\u781a\u01bc\u8b63\u150e\u9ece"), l);
    }

    private int nln() {
        Matcher matcher = nfu.matcher(this.ngo.get());
        if (!matcher.find()) {
            return -1;
        }
        try {
            return Integer.parseInt(matcher.group(1));
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    private String nlo(ClientPlayerEntity clientPlayerEntity, long l) {
        if (this.nln() <= 0 || l < this.nir) {
            return null;
        }
        if (qdz.trapped(clientPlayerEntity.method_73183(), clientPlayerEntity) != null) {
            return null;
        }
        if (clientPlayerEntity.method_6032() < 3.0f && this.nlq(a.c(1760422779, "\ueb11\u92b8"), l)) {
            return a.b("\u1547\u6cee", 1859523885);
        }
        int n = qpw.pickaxeDurability(clientPlayerEntity);
        if (n >= 0 && n < 190 && !this.nhd.repairFailed() && this.nlq(a.b("\u08e0\u7148\ufb91\u65e8", -1479407468), l)) {
            return a.d("\uf950\u80f8\u0a21\u9458", -1009286406, 1505131486);
        }
        if (qpw.count(clientPlayerEntity.method_31548(), Items.field_8477) > 576 && this.nlq(a.c(-5401926, "\u92d6\ueb6a\u61b1\uffcc\u7419\uf2a9\u48f0\uc116"), l)) {
            return a.b("\u9909\ue0b5\u6a6e\uf413\u7fc6\uf976\u432f\ucac9", -2124179099);
        }
        if (qpw.food((PlayerEntity)clientPlayerEntity) < 3 && this.nlq(a.b("\ubff8\uc640\u4c93\ud2e9", -1445216358), l)) {
            return a.d("\uf0c0\u8978\u03ab\u9dd1", -297550931, 590891791);
        }
        return null;
    }

    private boolean nlp(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        int n = qpw.pickaxeDurability(clientPlayerEntity);
        if (n < 0 || n >= 190) {
            this.njh = false;
            return false;
        }
        if (this.nls(minecraftClient, clientPlayerEntity, l)) {
            return true;
        }
        if (qdz.trapped(clientPlayerEntity.method_73183(), clientPlayerEntity) != null) {
            return false;
        }
        this.ngz.stop(minecraftClient);
        if (!this.njh) {
            this.njh = true;
            this.nma(a.d("\u93b7\uea24\u608f\ufe84\u7559\uf7e2\u4dab", 814208338, 1379156728) + n + a.d("\u24de\u5970\ud3dc\u4dd3\uc67d\u40b6\ufae6\u7368\ued34\u67ff\ue434\u3e71\u9092\u0d3e\u8765\u0581\ubbd4\u3401\uaeb3\u28ed\ua164\udf57\u51e8\uce5e\u4824\uc289\u7b35\uf51e\u6b82\ue9ce\u6275\u98b1\u169f\u8f14\u0942\u83f1\u3c2a\ub629\u30f4\uad29\u277e", -1988406299, 358971186) + (this.nln() <= 0 ? a.d("\ub4ed\ucd27\u47f5\ud98f\u525c\ud0f9\u6eb7\ue74e\u7d04\uf3a2\u7476\u8e03\u00d0\u996c", 1099415619, -1221365535) : a.b("\u3a43\u4389\uc95b\u5721\udcf2\u5e57\ue01b\u69eb\uf7bd\u7d0d\ufadd", -1994113527)) + a.b("\udabd", 775346837), vhz.ALERT);
        }
        this.nly(nff.IDLE);
        return true;
    }

    private boolean nlq(String string, long l) {
        Long l2 = this.nhj.get(string);
        return l2 == null || l2 <= l;
    }

    /*
     * Exception decompiling
     */
    private static String nlr(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private boolean nls(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        String string = this.nlo(clientPlayerEntity, l);
        if (string == null || this.nha.busy()) {
            return false;
        }
        if (this.njx() && this.nhr != this.nln() && qof.hasJunk(clientPlayerEntity.method_31548(), ngn) && l - this.njm > 15000L) {
            this.njm = l;
            this.ngz.stop(minecraftClient);
            this.nlj(clientPlayerEntity);
            this.njl = l;
            return true;
        }
        this.ngz.stop(minecraftClient);
        this.njf = false;
        this.niq = nfl.nlr(string);
        this.nma(a.b("\u68c6\u115a\u9f99\u0589\u8e25\u0895\ub2cd\u3b38\ua169\u2bc2", -915510063) + this.niq, vhz.NAV);
        this.nht = false;
        this.nhs = -1;
        int n = this.nln();
        if (this.nhd.atHome((World)minecraftClient.field_1687, clientPlayerEntity, 6.0)) {
            if (this.njx()) {
                this.nhr = n;
            }
            this.nin = 2;
            this.nhd.begin(l);
            this.nma(a.c(-819613283, "\ub5a6\ucc02\u46d2\udcb6\u5302\ud1d0\u6fe2\ue668\u7836\uf28c\u755b\u8f2e\u05e9\ubc6c\u160b\u94eb\u2ea0\ua173\u3fd7\ub989\u3039\u4a6f\uc4de\u5f07"), vhz.CHECK);
        } else if (this.njx() && this.nhr != n) {
            this.nhv = n;
            this.nhw = l;
            this.nid = 0;
            this.nie = 0L;
            if (pjd.enter(this.nmb(), String.valueOf(n))) {
                this.nkq(minecraftClient, clientPlayerEntity);
                this.nin = 0;
            } else {
                this.nin = -1;
                this.nma(a.b("\u95a9\uec35\u62f6\uf8e6\u734a\uf5fa\u4fa2\uc657\u5809\ud6ad\u551d\uaf19\u21cd\ubc69\u3629\ub0cb\u0e99\u8145\u1b8e\u9daf\u1425\u6a11\uc496\u7f73\ufd1a\u77c9\uce0d\u443f\udad6\u5cfe\ud73f\u299b\ua3a1\u3a51\ubc0e", 1280479639), vhz.INFO);
            }
        } else {
            this.nin = 1;
            this.nip = false;
        }
        this.nio = l;
        this.nly(nff.BASE);
        return true;
    }

    private void nlt(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        switch (this.nin) {
            case -1: {
                if (this.njr % 20 != 0 || !pjd.enter(this.nmb(), String.valueOf(this.nhv))) break;
                this.nhw = l;
                this.nid = 0;
                this.nie = 0L;
                this.nkq(minecraftClient, clientPlayerEntity);
                this.nin = 0;
                this.nio = l;
                this.nhq = l;
                break;
            }
            case 0: {
                if (this.nkr(minecraftClient, clientPlayerEntity) || this.nib) {
                    this.nhr = this.nhv;
                    this.nin = 1;
                    this.nio = l;
                    this.nip = false;
                    return;
                }
                if (this.nic) {
                    if (this.nid >= 3) {
                        this.nlv(minecraftClient, clientPlayerEntity, false, a.d("\u8e29\uf7e3\u7d31\ue34b\u6898\uea3d", 1245035298, -1869860532) + this.nhv + a.b("\u2e6b\u53c7\ud91c\u476c\uccb1\u4a7f\uf02f\u79df\ue7fc\u6d47\uea9c", 212938304), l);
                    } else if (this.nie == 0L) {
                        this.nie = l + 2500L;
                    } else if (l >= this.nie) {
                        ++this.nid;
                        this.nie = 0L;
                        this.nkq(minecraftClient, clientPlayerEntity);
                    }
                    return;
                }
                if (l - this.nhq <= 20000L) break;
                this.nlv(minecraftClient, clientPlayerEntity, false, a.d("\u27b0\u5e09\ud0cf\u4aa1\uc10a\u47b9\ufde9\u7462\uea3e\u608a\ue347\u1d2b\u93f1\u0e50\u8062\u06e8\ubca6\u337c\ua9cb\u2b8e", 1454982008, -1086299935) + this.nhv, l);
                break;
            }
            case 1: {
                long l2;
                if (!this.nip) {
                    if (l - this.nio < 1500L || minecraftClient.field_1755 != null && !(minecraftClient.field_1755 instanceof DeathScreen)) {
                        return;
                    }
                    if (this.nhd.atHome((World)minecraftClient.field_1687, clientPlayerEntity, 6.0)) {
                        this.nin = 2;
                        this.nhd.begin(l);
                        this.nma(a.d("\u7b08\u02ac\u887c\u1218\u9dac\u1f7e\ua14c\u28c6\ub698\u3c22\ubbf5\u4180\ucb47\u72c2\ud8a5\u5a45\ue00e\u6fdd\uf179\u7727\ufe97\u84c1\u0a70\u91a9", 1407884293, 1144709942), vhz.CHECK);
                        return;
                    }
                    this.nip = true;
                    this.nig = 0;
                    this.nkv(minecraftClient, clientPlayerEntity, l, a.b("\u8452\ufde4\u7735\ue94c", -662141890));
                    return;
                }
                boolean bl = minecraftClient.field_1687 != this.nii || clientPlayerEntity != this.nij || clientPlayerEntity.method_73189().method_1022(this.nih) > 2.5;
                long l3 = l2 = this.nik > 0L ? this.nik + 5000L : this.nif + 12000L;
                if (bl || this.nig >= 2 && (this.nil || l > l2)) {
                    this.nin = 2;
                    this.nhd.begin(l);
                    return;
                }
                if (!this.nil && l <= l2) break;
                this.nkv(minecraftClient, clientPlayerEntity, l, a.d("\ub1df\uc869\u42b8\udcc1", 800187716, 1199985911));
                break;
            }
            default: {
                this.nhd.repairTo = nfl.nlu(clientPlayerEntity);
                this.nhd.xpStock = 576;
                this.nhd.junk = ngn;
                qsq qsq2 = this.nhd.tick(minecraftClient, clientPlayerEntity, this.nha, this.nhb, this::nkh, l);
                if (qsq2 == qsq.RUNNING) break;
                this.nlv(minecraftClient, clientPlayerEntity, qsq2 == qsq.DONE, null, l);
            }
        }
    }

    private static int nlu(ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack = clientPlayerEntity.method_6047();
        if (!itemStack.method_31573(ItemTags.field_42614)) {
            int n = qof.bestPickaxe(clientPlayerEntity.method_31548());
            ItemStack itemStack2 = itemStack = n >= 0 ? clientPlayerEntity.method_31548().method_5438(n) : clientPlayerEntity.method_6079();
        }
        if (!itemStack.method_31573(ItemTags.field_42614) || itemStack.method_7936() <= 0) {
            return 1500;
        }
        return Math.max(200, itemStack.method_7936() - 2);
    }

    private void nlv(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, boolean bl, String string, long l) {
        this.nhd.stop(minecraftClient);
        if (string != null) {
            this.nma(string, vhz.ALERT);
        }
        if (bl) {
            this.nit = this.nha.laidOut();
            this.nma(a.d("\u797c\u00d6\u8a04\u147e\u9fad\u1d08\ua348\u2ab4\ub497\u3e5a\ub985\u47ea\uc931\u5492\udecd\u5835\ue27f\u6ddc\uf71f\u7137\uf8b9\u8296\u0c2a\u97f6\u15e5\u9b2e\u2299\uacc9\u3631\ub012\u3baf", -963045390, 872180400), vhz.CHECK);
        } else {
            this.nir = l + 120000L;
        }
        String string2 = this.nlo(clientPlayerEntity, l);
        while (string2 != null) {
            this.nhj.put(string2, l + 600000L);
            this.nma(a.b("\u02f9\u7b53\uf181\u6ffb\ue428\u668d\ud8c3\u513a\ucb70\u45de\uc20c\u387f\ub6aa\u2f16\ua14c\u27a7", 1594754760) + nfl.nlr(string2) + a.d("\u596d\u00e8\uaa0f\u3061\ubbb7\u3d0c\u8755\u0eac\u90f1\u1a37\u9987\u63e7\ued31\u7490\ufadf\u7c2a\uc660", 1805252886, 749576266), vhz.ALERT);
            string2 = this.nlo(clientPlayerEntity, l);
        }
        this.nht = false;
        this.nhs = -1;
        this.nly(nff.DECIDE);
    }

    private void nlw(int n, pzp pzp2, long l, boolean bl) {
        qqm qqm2;
        if (n < 0 || pzp2 == null) {
            return;
        }
        qwj qwj2 = pzp2.tier();
        if (qwj2 == null) {
            qwj2 = qwj.COMMON;
            if (!pzp2.tierWord().isEmpty() && !this.njq.contains(pzp2.tierWord())) {
                this.nma(a.b("\u6e5f\u17c6\u9d18\u0366\u88b4\u0e02\ub425\u3dd7\ua3f7\u2930\uae91\u50f9\uda4d\u43ff\uc9d2\u4f2f\uf567\u7abe\ue07c\u625b\uebb6", -1238406569) + pzp2.tierWord(), vhz.INFO);
            }
        }
        boolean bl2 = (qqm2 = this.ngx.entry(n)) == null || qqm2.tier != qwj2 || qqm2.refreshAt < l;
        this.ngx.seen(n, qwj2, pzp2.seconds(), l);
        this.nix = l;
        if (bl) {
            this.ngx.hopTook(l - this.nhw);
        }
        if (bl2 && this.nhp != nff.MINE && this.nhp != nff.SETTLE) {
            this.nma((n > 0 ? n + a.d("\ub28b\ucb20", -312439239, 1876573322) : "") + qwj2.title() + a.b("\u702a\u0dfc\u875d\u1959\u92fb\u1448\uaa0c", -1059753971) + nfl.clock((long)pzp2.seconds() * 1000L), vhz.INFO);
        }
    }

    private void nlx() {
        this.ngy.tiers = this.nkb();
        this.ngy.waitMs = 30000L;
        this.ngy.leadMs = 7000L;
        this.ngy.minMineMs = nfl.njz();
    }

    private void nly(nff nff2) {
        if (this.njf && nff2 != nff.WAIT) {
            this.njf = false;
            if (nff2 != nff.SETTLE) {
                this.ngz.stop(this.mc);
            }
        }
        if ((this.nhp == nff.WAIT || this.nhp == nff.SETTLE) && nff2 != nff.WAIT && nff2 != nff.SETTLE && nff2 != nff.MINE && this.ngz.guarding()) {
            this.ngz.stop(this.mc);
        }
        this.nhp = nff2;
        this.nhq = System.currentTimeMillis();
    }

    private void nlz() {
        if (this.ngw != null) {
            this.setEnabledSilently(false);
        } else {
            this.setEnabled(false);
        }
    }

    private void nma(String string, vhz vhz2) {
        this.njq = string;
        if (this.ngw != null) {
            this.ngw.report(a.b("\u3e3a\u47bf\ucd6d\u5307\ud8f2\u5e67\ue433\u6dc9\uf3c9\u7962", 1288519281) + string, true);
            return;
        }
        System.out.println(a.c(1436539112, "\ud8a3\ua126\u2bf4\ub59e\u3e6b\ub8fe\u02aa\u8b50\u1550\u9ffb") + string);
        izx.alert(this.getName(), string, vhz2, true);
    }

    private Object nmb() {
        return this.ngw != null ? this.ngw : pjd.MAIN;
    }

    public static String clock(long l) {
        long l2 = Math.max(0L, (l + 999L) / 1000L);
        return String.format(Locale.ROOT, a.d("\udead\ua75d\u2dd0\ub3be\u387c\ubecf\u04ca", 1360934432, 1274669231), l2 / 60L, l2 % 60L);
    }

    static {
        nfv = a.c(-1501091926, "\u27b0\u5e00\ud4d0\u4abf\uc174\u47c5\ufd95\u747a\uea29\u608a\ue75b\u1d29\u93e0\u0a4e\u801c\u06ea\ubcbd\u3360\ua9c0\u2f92\ua667\udc29\u5284\uc954\u4f2a\uc5e4\u7c5b\uf21f\u68ed\ueebd\u6512\u9bdb\u1190\u8864\u0e2f\u8492\u3b5c\ub124\u37f6\uae5b\u2410\u5ae8\ud0bf");
        nfw = a.b("\u301b\u49a5", 483995768);
        nfx = a.c(337423386, "\uac64\ud5c3\u5f03\uc170\u4af7\ucc0b\u765c\uffaa\u61fe");
        ngc = a.b("\u6ede\u1774\u9da0\u03c0\u8801\u0ebf\ub4f5\u3d17\ua34e", 324955898);
        ngd = a.b("\u2729\u5e8f\ud450\u4a3d\uc1fd", 598681422);
        nge = a.c(-1423223801, "\u5477\u2ddc\ua712");
        ngf = a.b("\uf3a5\u8a13\u00c2\u9ebb", 1570829257);
        nft = Pattern.compile(a.b("\ua50b\udcce\u5625\uc81b\u43ce\uc50a\u7f76\uf6de\u6cea\ue62f\u61f3", 89761064));
        nfu = Pattern.compile(a.c(-2097066369, "\u4e52\u3797\ubd7c\u2342\ua897"));
        ngn = Set.of(a.d("\u93f1\uea44\u6090\ufeea\u753b\uf39b\u49db\uc02d\u5e60\ud49f\u5315\ua968\u27b2\ube03\u345e\ub2a6\u08ff\u8729\u1d81\u9bd1\u122d", 1145636931, -1590584374), a.c(2124664663, "\ucf21\ub694\u3c40\ua23a\u29eb\uaf4b\u150b\u9cfd\u02b0\u884f\u0fc5\uf5b8\u7b62\ue2d3\u688e\uee76\u5438\udbd2\u415a\uc70a\u4efd\u34b9\uba09\u21c7\ua7b5\u2d71\u94d3"), a.b("\u858c\ufc39\u76ed\ue897\u6346\ue5e6\u5fa6\ud650\u481d\uc2e2\u4578\ubf0e\u31c2\ua872\u222a", 954303982), a.d("\ubfa1\uc614\u4cc0\ud2ba\u596b\udfcb\u658b\uec7d\u7230\uf8cf\u7f41\u8525\u0be1\u925f\u180b\u9ee7\u24b9", -343223458, -1682936701), a.b("\uc8f2\ub147\u3b93\ua5e9\u2e38\ua898\u12d8\u9b2e\u0563\u8f9c\u0811\uf26d\u7cbc\ue510\u6f58\ue9b4\u53ea", -78002034), a.d("\ud88c\ua139\u2bed\ub597\u3e46\ub8e6\u02a6\u8b50\u151d\u9fe2\u186a\ue214\u6cc9\uf579\u7f3c\uf9d7\u4385\ucc45", 977339535, 1215028348), a.d("\uf574\u8cc1\u0615\u986f\u13be\u951e\u2f5e\ua6a8\u38e5\ub21a\u3587\ucff7\u4133\ud882", -1214295759, -938761178), a.c(1188549970, "\ud52e\uac9b\u264f\ub835\u33e4\ub544\u0f04\u86f2\u18bf\u9240\u15ca\uefb9\u6163\uf8dd\u7284\uf468\u4e36"), a.b("\ub761\uced4\u4400\uda7a\u51ab\ud70b\u6d4b\ue4bd\u7af0\uf00f\u7782\u8df2\u0325\u9a81\u10d1\u963f\u2c7d\ua3b9\u391b", 1097840415), a.b("\u72b7\u0b02\u81d6\u1fac\u947d\u12dd\ua89d\u216b\ubf26\u35d9\ub257\u4833\uc6f7\u5f51\ud511\u53e9", 361067210), a.d("\u97ab\uee1e\u64ca\ufab0\u7161\uf7c1\u4d81\uc477\u5a3a\ud0c5\u5748\uad34\u23f8\uba4f", 1070576150, -1185077794), a.d("\u68d7\u1162\u9bb6\u05cc\u8e1d\u08bd\ub2fd\u3b0b\ua546\u2fb9\ua83e\u5244\udc82\u452f\ucf71\u4997\uf3d8\u7c1a\ue6ab\u60f2", 1819904409, -1114054345), a.b("\u68d7\u1162\u9bb6\u05cc\u8e1d\u08bd\ub2fd\u3b0b\ua546\u2fb9\ua832\u524d\udc97\u4524\ucf7f\u4996\uf3de\u7c14\ue6a6\u60fc", -1273665362), a.b("\u28e1\u5154\udb80\u45fa\uce2b\u488b\uf2cb\u7b3d\ue570\u6f8f\ue804\u1276\u9cb3\u0510\u8f4e\u09a7", -975492964), a.c(-995143975, "\u4ea3\u3716\ubdc2\u23b8\ua869\u2ec9\u9489\u1d7f\u8332\u09cd\u8e57\u7438\ufaed\u635c\ue914\u6ff9\ud581\u5a6d\uc0dd\u469e\ucf7b\ub527\u3b8c"), a.d("\u7896\u0123\u8bf7\u158d\u9e5c\u18fc\ua2bc\u2b4a\ub507\u3ff8\ub877\u420c\uccde\u5568\udf21", 890770786, 1439329686));
    }

    private static /* synthetic */ int bcr(int n, int n2) {
        return n * n2 ^ 0x7A8F7001;
    }

    private static /* synthetic */ int bcs(int n, int n2) {
        return nfl.bcr(n, n2) * n2;
    }
}

