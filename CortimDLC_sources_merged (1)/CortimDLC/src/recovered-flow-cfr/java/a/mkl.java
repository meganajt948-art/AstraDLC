/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.GenericContainerScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.EquippableComponent
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.text.Text
 */
package a;

import a.hlc;
import a.hrt;
import a.izx;
import a.kfa;
import a.kfe;
import a.pdr;
import a.pej;
import a.pey;
import a.pfd;
import a.pfl;
import a.pfw;
import a.pgb;
import a.pgi;
import a.phj;
import a.phm;
import a.piq;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vyn;
import a.vzz;
import a.wap;
import flow.dev.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public class mkl
extends kfe {
    private static mkl mkm;
    private static final String[] mkn;
    private static final String[] mko;
    private static final String mkp;
    private static final String[] mkq;
    private static final Pattern mkr;
    private static final int mks = 200;
    private static final long mkt = 1500L;
    private static final long mku = 1400L;
    private static final int mkv = 4;
    private static final int mkw = 2;
    private static final int mkx = 6;
    private static final long mky = 3000L;
    private static final int mkz = 3;
    private static final int mla = 3;
    private static final int mlb = 40;
    private static final int mlc = 3;
    private static final long mld = 90000L;
    private static final long mle = 210000L;
    private static final long mlf = 2500L;
    private static final double mlg = 6.0;
    private static final long mlh = 4000L;
    private static final int mli = 4;
    private static final int mlj = 24;
    private static final int mlk = 54;
    private static final int mll = 4;
    private static final int mlm = 12;
    private static final int mln = 0;
    private static final int mlo = 1;
    private static final int mlp = 2;
    private static final int mlq = 3;
    private static final int mlr = 4;
    private static final int mls = 5;
    private static final int mlt = 6;
    private static final int mlu = 7;
    private final vkw mlv = this.add(new vkw(a.c(-26252019, "\u6d5e\u14d7\u9e19q"), new vkq(a.d("\ua249\udbdf\u5119\ucf7b\u44aa", 1973474591, -1540000000), vhz.PLAY, this::mnt), new vkq(a.d("\u3702\u4e94\uc45c\u5a32", -1654698555, 244546192), vhz.PAUSE, this::mnu)));
    private final vkw mlw = this.add(new vkw(a.d("\u11f1\u687d\ue2bf\u7cc6\uf75c\u71a1\ucbf7\u421c\udc44", -974761284, 988889869), new vkq(a.d("\u0919\u7089\ufa57\u643b\uefb8\u6945\ud313\u5af8\uc4a0", 1941377565, -1064494264), vhz.PENCIL, hrt::open)));
    private final vkl mlx = this.add(new vkl(a.c(1181572352, "\u5d48\u24d8\uae10\u307c\ubba4\u3d0a"), true));
    private final pgb mly = new pgb();
    private final pgi mlz = new pgi();
    private final piq mma = new piq();
    private final piq mmb = new piq();
    private final piq mmc = new piq();
    private final piq mmd = new piq();
    private final piq mme = new piq();
    private final piq mmf = new piq();
    private final vyn mmg = new vyn();
    private pdr mmh;
    private boolean mmi;
    private String mmj = "";
    private boolean mmk;
    private int mml;
    private int mmm;
    private final Map<pdr, Long> mmn = new HashMap<pdr, Long>();
    private boolean mmo;
    private double mmp = 6.0;
    private long mmq = System.currentTimeMillis();
    private int mmr = -1;
    private SlotActionType mms = SlotActionType.field_7790;
    private boolean mmt;
    private int mmu;
    private int mmv;
    private int mmw;
    private int mmx;
    private int mmy = -1;
    private int mmz;
    private int mna;
    private int mnb;
    private ItemStack mnc = ItemStack.field_8037;
    private boolean mnd;
    private int mne;
    private boolean mnf;
    private int mng = -1;
    private final int[] mnh = new int[8];
    private boolean mni;
    private int mnj;
    private int mnk;
    private int mnl = -1;
    private float mnm;
    private float mnn;
    private volatile boolean mno;
    private volatile boolean mnp;
    private volatile boolean mnq;
    private static /* synthetic */ boolean mnr;
    private static /* synthetic */ String mns;

    public mkl() {
        super(a.d("\uca52\ub3d7\u3905\ua76f\u2c94\uaa09\u1059\u99a8\u07fe\u8d49\u0a8d\uf0e7\u7e2d", -1878110017, 143825569), a.c(-319571899, "\ub81a\uc19c\u4b43\ud538\u5ebc\ud854\u6211\uebfa\u75a2\uff41\u78de\u82aa\u0c67\u95d1\u1f93\u9963\u2368\uacf0\u365e\ub01e\u39e1\u43ae\ucd4e\u56d0\ud0ae\u5a31\ue38d\u6d92\uf76c"), kfa.PLAYER);
        mkm = this;
    }

    public static mkl get() {
        return mkm;
    }

    public static pdr collecting() {
        mkl mkl2 = mkm;
        return mkl2 != null && mkl2.isEnabled() ? mkl2.mmh : null;
    }

    public static boolean busy() {
        mkl mkl2 = mkm;
        return mkl2 != null && mkl2.isEnabled() && mkl2.mmh != null;
    }

    public static void onMessage(Text text) {
        mkl mkl2 = mkm;
        if (mkl2 == null || !mkl2.isEnabled() || mkl2.mmh == null || text == null) {
            return;
        }
        String string = text.getString().toLowerCase();
        if (string.contains(a.b("\uf3ac\u8a12\u00bd\u9eb0\u1105\u93d6\u29f9\ua004\u3e59\ub498\u372b\uc939\u479b\ude29\u506f\ud284\u68b2\ue71f\u7dab\ufbf9\u720d", -20908044))) {
            mkl2.mno = true;
        } else if (string.contains(a.b("\ufacf\u8376\u0db0\u97a4\u1c04\u9ab7\u2096\ua915\u374f\ubd89\u3e38\uc055\u4e80\ud732\u5d69\udbef", 525139682))) {
            mkl2.mnp = true;
        } else if (string.contains(a.d("\u017e\u78c7\uf215\u6c6e\ue7c6\u6174\udb26\u52ab\uccf6\u464a\uc589\u3bea\ub12f\u2cfe\ua6d8\u202a\u9a6b\u15be\u8f04\u0d40\u84f6\ufea0\u701e", -390815373, 257205287))) {
            mkl2.mnq = true;
        }
    }

    @Override
    protected void onEnable() {
        this.mpd();
        this.mpl(wap.s(a.b("\ue2e9\u9b7a\u11be\u8fd9\u040e\u82ec\u38cc\ub11a\u2f50\ua5f2\u2227\ud80c\u56d5\ucf0d\u4563\uc3c6\u79cb\uf60d\u6cb2\ueae9\u634d\u1948\u97e7\u0c3b\u8a01\u0093\ub92b\u3777\uad84\u2bc4\ua062\u5ea5\ud4ed\u4d48\ucb5d\u41e3\ufe29\u7458\uf296\u6b20\ue176\u9fc0\u15df\u926d\u08a1\u86d7\u3f57\u95d2\u33a9\ua82f\u264a\udc8e\u552e\ud374\u49cf\uc7c7\u7c6e\ufaa5\u70d1\ue952\u67a7\u1df5\u9a0b\u1057\u8e97\u072b\ubd7e", 2019549946), a.c(-1600154473, "\u90c4\ue958\u638d\ufdf6\u7625\uf0ee\u4aca\uc72e\u59fa\ud7f7\u5003\uaa7d\u24d6\ubd65\u3735\ub1be\u0b8b\u8454\u1a10\u9cd4\u152d\u6b4d\ue5da\u7e7e\uf810\u72d2\ucf03\u4533\udfb5\u59e8\ud22c\u2c83\ua2d9\u3f3c\ub96e\u33a2\u8c6c\u067e\u80d4\u191b\u9751\uedbf\u67ed\ue056\u7af0\uf4fa\u4d23\uc7e9\u41a0\uda00\u547e\uaaba\u2716\ua142\u3bcd\ub595\u0a41\uaca4\u06e3\u9b53\u159e\u6fc1\ue833\u626e\ufcdb\u751d\ucb5b\u49bd\uc3ed\u584c\ud68e\u50fe\ua92a\u2390\ubdce\u3643\ub06b\u0ad8")), true);
    }

    @Override
    protected void onDisable() {
        this.mpd();
        this.mmg.release(this.mc);
        this.mny();
    }

    private void mnt() {
        if (this.mc.field_1724 == null) {
            return;
        }
        if (!this.isEnabled()) {
            this.setEnabled(true);
        }
        if (pej.activeCount() == 0) {
            this.mpl(wap.s(a.c(1372339142, "\u3bb3\u423e\uc8e0\u56d4\udd4f\u5bfb\ue1b2\u6844\uf64f\u7cb6\ufb6c\u010f\u8f8b\u1674\u9c26\u1a98\ua09e\u2f52\ub5f0\u33a9\uba40\uc042\u4ea2\ud577\u5316\ud9da\u607e\uee24\u74de\uf28e\u7979\u87e7\u0da9"), a.c(271671869, "\u6608\u1b8b\u9539\u0b36\u80e6\u062e\ubc06\u35f8\uafb2\u211e\ua6c5\u58a1\ud264\u4bdd\uc18f\u470b\ufd4d\u72ee\ue855\u6e07\ue3ee\u9da2\u1314\u8cdd\u0ebc\u8467\u3ddd\ub38f\u2975\uaf29\u2084\uda4a\u507a\uc9fe\u4fac\uc515\u7acb\uf0cd\u766c")), false);
            return;
        }
        this.mmi = true;
        this.mmn.clear();
        this.mlz.reset();
        this.mmh = null;
        this.moz();
        this.mme.arm(this.mlz.draw(0));
    }

    private void mnu() {
        if (this.mmh != null || this.mmi) {
            this.mpc();
            this.mpl(wap.s(a.c(-1332698800, "\ua104\ud892\u525a\ucc34\u47e3\uc147\u7b15"), a.c(-283805843, "\u735f\u0afe\u802c\u1e52\u95f9\u133a\uad79\u2096\ubeb6\u3404\ub3a5\u49d9\uc70d\u5eb0\ud4ea\u5215\ue852\u678e")), false);
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        this.mmg.release(minecraftClient);
        if (minecraftClient.field_1724 == null) {
            return;
        }
        if (this.mmh != null && minecraftClient.field_1755 instanceof HandledScreen) {
            this.mmg.hold(minecraftClient);
        }
        this.mnx(minecraftClient);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (minecraftClient.field_1724 == null || minecraftClient.field_1687 == null) {
            return;
        }
        if (!(minecraftClient.field_1755 instanceof GenericContainerScreen)) {
            this.mmy = -1;
            this.mmr = -1;
        }
        this.mnw();
        if (this.mmh == null) {
            this.mpb();
            return;
        }
        if (this.mpk(minecraftClient)) {
            return;
        }
        if (minecraftClient.field_1724.method_31548().method_7376() == -1) {
            this.mpl(wap.s(a.b("\u146a\u6dfa\ue766\u7951\uf292\u7434\uce67\u47d3\ud9c5\u5373\ud4b8\u2eda\ua006\u39ad\ub3e5\u3509\u8f4d\u00c5\u9a25\u1c6b\u959f\uefd5\u6161", -431287245), a.d("\u9893\ue10a\u6bae\uf1bd\u7e0b\uf8c9\u4296\ucb68\u5538\udf83\u5859\ua25e\u2c87\ub153\u3f61\ub9ea\u03a0\u8c0d\u16c2\u909f\u1d7a\u6339\ue998\u7651\uf02b\u7af5\uc341\u4d18\ud790\u51b3\uda70\u24d4", 446539183, 1534867713)), false);
            this.mpj();
            this.mpc();
            return;
        }
        this.mpe(false);
        this.mnv();
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        if (this.mmh == null || minecraftClient.field_1724 == null) {
            return;
        }
        if (minecraftClient.method_61964() != null) {
            minecraftClient.method_61964().method_61939();
        }
        this.mnv();
    }

    private void mnv() {
        if (this.mmh == null || this.mmj.isEmpty() || this.mc.field_1724 == null || this.mc.method_1562() == null) {
            return;
        }
        Screen screen = this.mc.field_1755;
        if (screen instanceof GenericContainerScreen) {
            GenericContainerScreen genericContainerScreen = (GenericContainerScreen)screen;
            this.moa(genericContainerScreen);
            return;
        }
        if (this.mc.field_1755 != null || this.mnj > 0) {
            return;
        }
        if (this.mc.field_1724.field_6012 < 200 || !this.mme.ready()) {
            return;
        }
        if (this.mmm >= 3) {
            this.mon();
            return;
        }
        if (!this.mph()) {
            return;
        }
        this.mc.method_1562().method_45730(a.b("\ueacd\u9375\u19ee\u87cc\u0c0d\u8ab8\u30f8\ub918\u274c\uadb5", -1430000986) + this.mmj);
        this.mme.arm(this.mlz.draw(4, this.mpi()));
        this.mml = 0;
        ++this.mmm;
    }

    private void mnw() {
        if (this.mnq) {
            this.mnq = false;
            this.mnj = ThreadLocalRandom.current().nextInt(24, 54);
            this.mnk = 0;
        }
        if (this.mno) {
            this.mno = false;
            this.mmm = Math.max(0, this.mmm - 1);
            this.moq();
        }
        if (this.mnp) {
            this.mnp = false;
            if (this.mmh != null) {
                this.mpl(wap.s(a.c(1184143787, "\u99e8\ue063\u6ab1\uf494\u7f0c\uf9b4\u43a1\uca13\u5440\udef7\u5923\ua34f"), a.b("\u409e\u3907\ub7c1\u2dd5\ua675\u20c6\u9ae7\u1364\u8d3e\u07f8\u8449\u7a24\uf4f1\u6d43\ue718\u619e\udfb3\u547f\ucec1\u4c80\uc167\ubb3c\u358f\uae54\u2858\ua2f7\u1b3b\u951d", -1318632289)), false);
                this.mpj();
                this.mpc();
            }
        }
    }

    private void mnx(MinecraftClient minecraftClient) {
        if (this.mnj <= 0) {
            return;
        }
        if (minecraftClient.field_1755 != null) {
            this.mnj = 0;
            this.mny();
            return;
        }
        --this.mnj;
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        if (--this.mnk <= 0) {
            this.mnk = threadLocalRandom.nextInt(4, 12);
            this.mnl = threadLocalRandom.nextInt(5);
        }
        KeyBinding[] keyBindingArray = mkl.mnz(minecraftClient.field_1690);
        for (int i = 0; i < keyBindingArray.length; ++i) {
            keyBindingArray[i].method_23481(this.mnl == i);
        }
        this.mnm = this.mnm * 0.85f + (float)threadLocalRandom.nextGaussian() * 0.9f;
        this.mnn = this.mnn * 0.85f + (float)threadLocalRandom.nextGaussian() * 0.45f;
        float f = minecraftClient.field_1724.method_36455();
        float f2 = f + this.mnn > 80.0f || f + this.mnn < -80.0f ? -this.mnn : this.mnn;
        minecraftClient.field_1724.method_5872((double)this.mnm / 0.15, (double)f2 / 0.15);
        if (this.mnj == 0) {
            this.mny();
        }
    }

    private void mny() {
        if (this.mnl < 0 || this.mc.field_1690 == null || this.mc.method_22683() == null) {
            return;
        }
        this.mnl = -1;
        for (KeyBinding keyBinding : mkl.mnz(this.mc.field_1690)) {
            keyBinding.method_23481(vzz.isPhysicallyDown(this.mc, keyBinding));
        }
    }

    private static KeyBinding[] mnz(GameOptions gameOptions) {
        return new KeyBinding[]{gameOptions.field_1894, gameOptions.field_1881, gameOptions.field_1913, gameOptions.field_1849};
    }

    private void moa(GenericContainerScreen genericContainerScreen) {
        boolean bl;
        ScreenHandler screenHandler = genericContainerScreen.method_17577();
        String string = pfl.title(genericContainerScreen.method_25440().getString());
        if (screenHandler.field_7763 != this.mmy) {
            this.mmy = screenHandler.field_7763;
            this.mmb.arm(this.mlz.draw(0));
            this.mmd.restart();
            if (this.mmr >= 0) {
                this.mmt = true;
                this.mmu = 0;
                this.mmv = 0;
                this.mmr = -1;
            }
            return;
        }
        if (!vyn.serverIdle(this.mc.field_1724)) {
            return;
        }
        if (mkl.mob(string)) {
            if (this.mnd) {
                if (this.mma.elapsed(1400L)) {
                    this.mnd = false;
                    if (++this.mne >= 4) {
                        this.mpl(wap.s(a.b("\u72f4\u0b64\u81f8\u1fcb\u940b\u12b6\ua8bc\u210f\ubf47\u35f7\ub224\u484e\uc698\u5f67\ud57d\u538b\ue98a\u660f\ufca0\u7afc\uf34e\u895c\u07e3\u9c33\u1a44\u909a\u2932\ua77c\u3dc6\ubbc0\u306d\ucebb\u44fe\udd04\u5b4f", 796029593), a.d("\ua76c\udaef\u5422\uca57\u4187\uc73e\u7978\uf496\u6ac8\ue073\u67d6\u9dd7\u1307\u8ac3\u00e6\u8615\u3c5b\ub382\u2934\uaf12\u228a\u5cc6\ud27d\u49db\ucbc6\u450d\ufcb9\u72eb\ue81d\u6e49\ue5f8\u1f31\u9161\u0891\u8ec6\u040e\ubba5\u31d1\ub700", -1140360583, -337127136)), false);
                        this.mne = 0;
                        this.mpj();
                    }
                }
                return;
            }
            if (this.mmb.ready() && this.mma.ready()) {
                Slot slot = mkl.moj(mkl.mor(screenHandler), a.c(56465371, "\u93e7\uea2f\u6080\ufef6\u755b\uf3e4"));
                if (slot != null) {
                    this.mop(screenHandler, slot.field_7874, SlotActionType.field_7794);
                    this.mnd = true;
                } else if (++this.mne >= 4) {
                    this.mpl(wap.s(a.b("\ua2f1\udb61\u51fd\ucfce\u440e\uc2b3\u78b9\uf10a\u6f42\ue5f2\u6221\u984b\u169d\u8f62\u0578\u838e\u398f\ub60a\u2ca5\uaaf9\u234b\u5959\ud7e6\u4c36\uca41\u409f\uf937\u7779\uedc3\u6bc5\ue068\u1ebe\u94fb\u0d01\u8b4a", -1459379556), a.b("\uc0f8\ubd7b\u33b6\uadc3\u2613\ua0aa\u1eec\u9302\u0d5c\u87e7B\ufa43\u7493\ued57\u6772\ue181\u5bcf\ud416\u4ea0\uc886\u451e\u3b52\ub5e9\u2e4f\uac52\u2299\u9b2d\u157f\u8f89\u09dd\u826c\u78a5\uf6f5\u6f05\ue952\u639a\udc31\u5645\ud094", 1158071501)), false);
                    this.mne = 0;
                    this.mpj();
                }
                this.mma.arm(this.mlz.draw(3));
            }
            return;
        }
        if (!string.contains(pfl.title(this.mmj))) {
            this.mpj();
            return;
        }
        this.mnd = false;
        this.mne = 0;
        if (this.mnf) {
            if (screenHandler.field_7763 == this.mng && !this.mma.elapsed(1400L)) {
                return;
            }
            this.mnf = false;
            this.mpe(true);
            if (this.mmz < this.mmh.count()) {
                this.mpj();
                this.mme.arm(this.mlz.draw(6));
                return;
            }
        }
        if (this.mmz >= this.mmh.count()) {
            if (!this.mma.ready()) {
                return;
            }
            this.mpl(wap.s(a.b("\u9876\ue1eb\u6b3b\uf54a\u7e94\uf823\u4267\ucb87\u55d9\udf36\u58ff", -17786818), a.d("\u4f73\u369d\ubc3b\u224b\ua994\u2f2c\u9508\u189b\u82a5\u086b\u8fb7\u75b7\ufb10\u62ac\uecf8\u6a13", -1969955191, 813012469)) + this.mmh.name(), true);
            this.moz();
            this.mpj();
            return;
        }
        if (!this.mmb.ready() || !this.mma.ready()) {
            return;
        }
        int[] nArray = mkl.moe(screenHandler, string);
        int n = nArray[0];
        int n2 = nArray[1];
        boolean bl2 = bl = !mkl.moc(mkl.mor(screenHandler)) || n2 > 1 && !mkl.moc(mkl.mos(screenHandler)) || nArray[2] == 0 && (this.mly.target() != null || this.mmr >= 0);
        if (bl) {
            if (this.mmd.elapsed(3000L)) {
                this.mom();
            }
            return;
        }
        this.mmd.restart();
        if (this.mog(n)) {
            return;
        }
        Arrays.fill(this.mnh, 0);
        this.mma.arm(this.mlz.draw(1));
        this.mod(screenHandler, n, n2);
    }

    private static boolean mob(String string) {
        for (String string2 : mkq) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private static boolean moc(List<Slot> list) {
        for (Slot slot : list) {
            if (slot.method_7677().method_7960()) continue;
            return true;
        }
        return false;
    }

    private void mod(ScreenHandler screenHandler, int n, int n2) {
        int n3 = Math.min(16, n2);
        pfw pfw2 = this.mly.target();
        if (pfw2 == null) {
            if (this.mly.markPage(n)) {
                for (Slot slot : mkl.mos(screenHandler)) {
                    if (!this.mou(slot.method_7677())) continue;
                    this.mly.offer(n, pfd.of(slot.method_7677()));
                }
            }
            if (!(n >= n3 || n >= 3 && this.mly.enough())) {
                this.moh(screenHandler, n, mkn);
            } else if (!this.mly.choose(n)) {
                this.mom();
            }
            return;
        }
        if (pfw2.page() > n2) {
            this.mpl(wap.s(a.c(2070835536, "\u711b\u0896\u8248\u1c7c\u97e7\u1155\uab1d\u22b8\ubcae\u3605\ub185\u4bb3\uc56c\u5cdc\ud684\u503c\uea7f\u65fd\uff5e\u790d\uf0f5\u8aa4\u0410\u9fc6\u19b0\u9326\u2ad4\ua483\u3e72\ub82b\u339f"), a.c(-635210175, "\u7245\u0bae\u817d\u1f7d\u94df\u160e\ua842\u21cc\ubfed\u355d\ub281\u48fb\uc23b\u5b86\ud5ca\u5331\ue90b\u66af\ufc68\u7a42\uf3bf\u89e3\u0755\u9cfc\u1a80\u905c")), false);
            this.moq();
            return;
        }
        if (n == pfw2.page()) {
            Slot slot = null;
            int n4 = Integer.MAX_VALUE;
            for (Slot slot2 : mkl.mos(screenHandler)) {
                int n5;
                if (!this.mou(slot2.method_7677()) || (n5 = pfd.of(slot2.method_7677())) > pfw2.price() || n5 >= n4) continue;
                slot = slot2;
                n4 = n5;
            }
            if (slot != null) {
                this.moo(screenHandler, slot.field_7874);
                return;
            }
            this.mpl(wap.s(a.d("\uea8c\u9301\u19df\u87eb\u0c70\u8ac2\u308a\ub92f\u2739\uad92\u2a12\ud024\u5efb\uc74b\u4d13\ucbab\u71e8\ufe6a\u64c9\ue29a\u6b62\u1133\u9f87\u0451\u8227\u08b1\ub143\u3f14\ua5e5\u23bc\ua808", -984192554, -808877295), a.d("\u46f3\u3f18\ub5cb\u2bcb\ua069\u22b8\u9cf4\u157a\u8b5b\u01eb\u8637\u7c4d\uf68d\u6f30\ue17c\u6787\uddbd\u5219\uc8de\u4ef4\uc709\ubd55\u33e3\ua84a\u2e36\ua4ea", 1913060220, -1564034677)), false);
            if (this.mly.dropTarget() == null) {
                this.mom();
            }
            return;
        }
        this.moh(screenHandler, n, n < pfw2.page() ? mkn : mko);
    }

    private static int[] moe(ScreenHandler screenHandler, String string) {
        int[] nArray = mkl.mof(string);
        if (nArray == null) {
            Slot slot;
            ItemStack itemStack;
            Iterator<Slot> iterator = mkl.mot(screenHandler).iterator();
            while (iterator.hasNext() && ((itemStack = (slot = iterator.next()).method_7677()).method_7960() || (nArray = mkl.mof(pfl.title(itemStack.method_7964().getString()))) == null)) {
            }
        }
        if (nArray == null) {
            return new int[]{1, 1, 0};
        }
        int n = Math.max(1, nArray[1]);
        return new int[]{Math.min(Math.max(1, nArray[0]), n), n, 1};
    }

    private static int[] mof(String string) {
        Matcher matcher = mkr.matcher(string);
        while (matcher.find()) {
            try {
                return new int[]{Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))};
            }
            catch (NumberFormatException numberFormatException) {
            }
        }
        return null;
    }

    private boolean mog(int n) {
        if (this.mmr < 0) {
            return false;
        }
        if (n != this.mmr) {
            this.mmr = -1;
            this.mmt = true;
            this.mmu = 0;
            this.mmv = 0;
            return false;
        }
        if (this.mmc.elapsed(1500L)) {
            this.mmr = -1;
            ++this.mmv;
            if (!this.mmt && ++this.mmu >= 2) {
                this.mms = this.mms == SlotActionType.field_7790 ? SlotActionType.field_7794 : SlotActionType.field_7790;
                this.mmu = 0;
            }
            return false;
        }
        return true;
    }

    private void moh(ScreenHandler screenHandler, int n, String[] stringArray) {
        if (this.mmv >= 3 || ++this.mmw > 40) {
            this.mpl(wap.s(a.b("\ub745\ucec8\u4416\uda22\u51a5\ud705\u6d50\ue4a3\u7aeb\uf008\u779f\u8de5\u0338\u9a9f\u10d1\u9669\u2c75\ua3f0\u3911\ubf57\u36b6\u4ce4\uc248\u5998\udfed\u5574\ueccb\u62c9\uf828\u7e7d\uf5dd\u0b1d\u8159\u18a9\u9efd\u1445\uabd5\u21e5\ua730\u3e87\ub4d0\uca26", 1092532027), a.d("\u118b\u6819\ue2b3\u7cc1\uf764\u71de\ucb8c\u4277\ud838\u5694\ud14f\u2f2b\ua5e2\u3c2f\ub60c\u30fa\u8ac7\u0561\u9fd7\u19f1\u9468\uee35\u649e\uff3e\u794b\uf7f9\u4a5d\uc40b\u5ef1\ud8a3\u531c\uadc1", -16945713, -1135380353)), false);
            this.mom();
            return;
        }
        Slot slot = mkl.moi(screenHandler, stringArray);
        if (slot == null) {
            this.mok(screenHandler);
            return;
        }
        this.mmx = 0;
        this.mop(screenHandler, slot.field_7874, this.mms);
        this.mmr = n;
        this.mmc.restart();
        this.mma.arm(this.mlz.draw(2));
    }

    private static Slot moi(ScreenHandler screenHandler, String[] stringArray) {
        for (String string : stringArray) {
            Slot slot = mkl.moj(mkl.mot(screenHandler), string);
            if (slot == null) continue;
            return slot;
        }
        return mkl.moj(mkl.mos(screenHandler), stringArray[0]);
    }

    private static Slot moj(List<Slot> list, String string) {
        for (Slot slot : list) {
            ItemStack itemStack = slot.method_7677();
            if (itemStack.method_7960() || !pfl.title(itemStack.method_7964().getString()).contains(string)) continue;
            return slot;
        }
        return null;
    }

    private void mok(ScreenHandler screenHandler) {
        if (++this.mmx < 6) {
            this.mma.arm(this.mlz.draw(2));
            return;
        }
        this.mpl(wap.s(a.d("\u7464\u0df4\u8768\u1949\u928f\u1438\uae69\u27dd\ub9c0\u3366\ub4b4\u4ec5\uc009\u59b9\ud3f7\u5555\uef53\u6085\ufa78\u7c7d\uf596\u8fca\u013c\u9aba\u1cdb\u960d\u2fb4\ua1ee\u3b01", -1777782288, -238074425), a.c(-1825855575, "\ua399\ude1a\u50d7\ucea2\u4572\uc3cb\u7d8d\uf061\u6e36\ue4f0\u6741\u992a\u17fa\u8e48\u041a\u82ee\u38a3\ub36a\u2dc2\uab90\u221e\u584c\ud68d\u4d51\ucb2b\u418d\ufc51\u7661\uec95\u6ac6\ue105\u1fd9\u9593\u0c1c")), false);
        this.mmx = 0;
        this.moq();
        Slot slot = this.mol(screenHandler);
        if (slot != null) {
            this.moo(screenHandler, slot.field_7874);
        } else {
            this.mom();
        }
    }

    private Slot mol(ScreenHandler screenHandler) {
        Slot slot2;
        int n = Integer.MAX_VALUE;
        for (Slot slot2 : mkl.mos(screenHandler)) {
            if (!this.mou(slot2.method_7677())) continue;
            n = Math.min(n, pfd.of(slot2.method_7677()));
        }
        if (n == Integer.MAX_VALUE) {
            return null;
        }
        int n2 = this.mmh.count() - this.mmz;
        slot2 = null;
        Slot slot3 = null;
        for (Slot slot4 : mkl.mos(screenHandler)) {
            int n3;
            if (this.mov(slot4.method_7677()) != 0 || (n3 = pfd.of(slot4.method_7677())) > n * 2) continue;
            if (slot3 == null || n3 < pfd.of(slot3.method_7677())) {
                slot3 = slot4;
            }
            if (slot4.method_7677().method_7947() < n2 || slot2 != null && n3 >= pfd.of(slot2.method_7677())) continue;
            slot2 = slot4;
        }
        return slot2 != null ? slot2 : slot3;
    }

    private void mom() {
        this.moq();
        this.mpj();
        String string = this.mmh.item().method_63680().getString();
        if (!(this.mml != 0 || this.mmk || this.mmh.hasQuery() || string.equalsIgnoreCase(this.mmj))) {
            this.mmk = true;
            this.mmj = string;
            this.mmm = 0;
            this.mpl(wap.s(a.d("\u9a30\ue3b7\u6960\uf702\u7cc4\ufa7e\u402c\uc9da\u578c\udd7a\u5aeb\ua081\u2e0f\ub7ea\u3da5\ubb59\u0153\u8ecb\u1465\u9225\u1bda\u61c6\uef3b\u74e5\uf296\u784f\uc1a3\u4fe8", -1303104056, -234573897), a.d("\u46bd\u3f5d\ub584\u2f96\ua05e\u26ee\u98a3\u154f\u8b1d\u01ab\u867d\u7c0e\uf2d4\u6b60\ue145\u63da\udd8a\u5224\uc8e2\u4eb2\uc74d\ubd15\u33d1\ua872\u2a07\ua0cc", -1123868379, 382296986)) + string, false);
        } else if (this.mmm >= 3) {
            this.mon();
            return;
        }
        this.mme.arm(this.mlz.draw(4, this.mpi()));
    }

    private void mon() {
        this.mmn.put(this.mmh, System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(90000L, 210000L));
        this.mpl(wap.s(a.b("\u5bd1\u2241\ua8dd\u36ea\ubd32\u3b9e\u81cd\u0821\u9679\u1cc1\u9b55\u6168\uefbc\u7616\ufc0b\u7ae0", -155231345), a.c(512810331, "\ud950\ua0c9\u2a6d\ub07e\u3fb6\ub906\u035f\u8adf\u14fb\u9e40\u19e8\ue39f\u6d34\uf483\u7edd\ufc32\u4266\ucdb2\u577d\ud15e\u5ca3\u26e8")) + this.mmh.name() + this.mox(), false);
        this.moz();
    }

    private void moo(ScreenHandler screenHandler, int n) {
        this.mop(screenHandler, n, SlotActionType.field_7794);
        this.mng = screenHandler.field_7763;
        this.mma.arm(this.mlz.draw(3));
        this.mme.arm(this.mlz.draw(6));
        this.moq();
        this.mnf = true;
        this.mmm = 0;
        this.mna = 1;
    }

    private void mop(ScreenHandler screenHandler, int n, SlotActionType slotActionType) {
        this.mc.field_1761.method_2906(screenHandler.field_7763, n, 0, slotActionType, (PlayerEntity)this.mc.field_1724);
    }

    private void moq() {
        this.mly.release();
        this.mmr = -1;
        this.mmv = 0;
        this.mmw = 0;
        this.mmx = 0;
    }

    private static List<Slot> mor(ScreenHandler screenHandler) {
        int n;
        if (screenHandler instanceof GenericContainerScreenHandler) {
            GenericContainerScreenHandler genericContainerScreenHandler = (GenericContainerScreenHandler)screenHandler;
            n = genericContainerScreenHandler.method_17388() * 9;
        } else {
            n = screenHandler.field_7761.size();
        }
        int n2 = n;
        return screenHandler.field_7761.subList(0, Math.min(Math.max(n2, 0), screenHandler.field_7761.size()));
    }

    private static List<Slot> mos(ScreenHandler screenHandler) {
        List<Slot> list = mkl.mor(screenHandler);
        return list.size() > 9 ? list.subList(0, list.size() - 9) : list;
    }

    private static List<Slot> mot(ScreenHandler screenHandler) {
        List<Slot> list = mkl.mor(screenHandler);
        return list.size() > 9 ? list.subList(list.size() - 9, list.size()) : list;
    }

    private boolean mou(ItemStack itemStack) {
        int n = this.mov(itemStack);
        if (this.mmh != null && itemStack.method_31574(this.mmh.item())) {
            int n2 = n;
            this.mnh[n2] = this.mnh[n2] + 1;
            ++this.mml;
        }
        return n == 0;
    }

    private int mov(ItemStack itemStack) {
        if (itemStack.method_7960() || this.mmh == null || !this.mmh.matches(itemStack, new pey(itemStack))) {
            return 1;
        }
        if (!(this.mmh.hasEffects() || this.mnc.method_7960() || Objects.equals(itemStack.method_58694(DataComponentTypes.field_49651), this.mnc.method_58694(DataComponentTypes.field_49651)))) {
            return 2;
        }
        if (pfd.claimed(itemStack)) {
            return 3;
        }
        if (pfd.of(itemStack) <= 0) {
            return 4;
        }
        if (itemStack.method_7947() > this.mnb) {
            return 7;
        }
        if (this.mmh.item() == Items.field_8288 && !this.mmh.hasAttrs() && itemStack.method_7958()) {
            return 5;
        }
        Integer n = (Integer)itemStack.method_58694(DataComponentTypes.field_49629);
        int n2 = itemStack.method_7936();
        if (n == null || n2 <= 0) {
            return 0;
        }
        if (this.mmh.item() == Items.field_8833) {
            return (float)(n2 - n) / (float)n2 >= 0.5f ? 0 : 6;
        }
        if (!mkl.mow(itemStack)) {
            return 0;
        }
        boolean bl = false;
        for (phm phm2 : this.mmh.rules()) {
            if (phm2.state() != phj.ON || !Enchantments.field_9101.method_29177().toString().equals(phm2.key())) continue;
            bl = true;
        }
        return bl || (float)(n2 - n) / (float)n2 >= 0.7f ? 0 : 6;
    }

    private static boolean mow(ItemStack itemStack) {
        EquippableComponent equippableComponent = (EquippableComponent)itemStack.method_58694(DataComponentTypes.field_54196);
        return equippableComponent != null && equippableComponent.comp_3174().method_46643();
    }

    private String mox() {
        StringBuilder stringBuilder = new StringBuilder();
        mkl.moy(stringBuilder, wap.s(a.c(1455050095, "\u4d41\u3467\ube23\u2011\uabca\u2d7a\u9723\u1edf\u809d\u0a31\u8de4\u7794\uf95e\u60bc"), a.b("\uacbc\ud59a\u5fde\uc5cc\u4e19\uc8d2\u7284\ufb79\u652c\uefea\u6c56", -2024887145)), this.mnh[1]);
        mkl.moy(stringBuilder, wap.s(a.b("\u66d5\u1ff3\u95b7\u0b89\u8045\u06e8\ubcb6\u3550\uab5d\u21bc\ua670\u5c1a\ud2d0\u4b67\uc135\u478a", -596941083), a.b("\u454c\u3c6a\ub62e\u2c4b\ua7e8\u215a\u9b79\u1285\u8cd1\u0275\u81b1\u7bc2\uf51b\u6cdd\ue6f7\u6413", 111691132)), this.mnh[2]);
        mkl.moy(stringBuilder, wap.s(a.c(1289702311, "\u4b95\u32b3\ub8f7\u26c7\uad1d\u2bb2\u91f6\u1803\u8659\u0cf5\u8b7f\u714c\uff96\u663d\uec7c\u6a82\ud0d1\u5f54"), a.b("\u6be1\u12c7\u9883\u0291\u8933\u0f81\ub1c7\u3c2c\ua20a\u28c7\uaf10\u556f\udbb0\u461c", -300586033)), this.mnh[3]);
        mkl.moy(stringBuilder, wap.s(a.c(2779161, "\u6835\u1113\u9b57\u0568\u8ebe\u0840\ub243\u3bb0\ua5f4\u2f4f\ua89a\u52ae"), a.d("\u0b9e\u72b8\uf8fc\u6290\ue94f\u6f89\ud1b8\u5c2f\uc203\u48ba\ucf1f\u3105", -1438808826, 267620020)), this.mnh[4]);
        mkl.moy(stringBuilder, wap.s(a.c(1239970630, "\u736f\u0a49\u800d\u1e3b\u95e7\u1353\ua907\u20ec\ubee7"), a.d("\u346d\u4d4b\uc70f\u5d6f\ud6b2\u500d\uea2a\u63a0\uf9e5", 749517292, 439455144)), this.mnh[5]);
        mkl.moy(stringBuilder, wap.s(a.c(-2004854563, "\u58f3\u21d5\uab91\u35a4\ube62\u38d4\u8294\u0b66\u9532\u1f86\u9850\u623c\uece6\u750e"), a.d("\u8e7b\uf75d\u7d19\ue777\u6cdf\uea10\u503a\ud9b1\u47ed\ucd23\u4af3\ub08c\u3a37", -1836982776, 1741246558)), this.mnh[6]);
        mkl.moy(stringBuilder, wap.s(a.c(-815692724, "\u8460\ufd46\u7702\ue93f\u62eb\ue441\u5e46\ud7e4\u49a1\uc303\u44cf\ubefb"), a.b("\u71c6\u08e0\u82a4\u18b5\u9312\u15a4\uaffc\u2604\ub82e\u36ff\ub537\u4f43\uc1e8\u582b\ud668", -145853975)), this.mnh[7]);
        return stringBuilder.toString();
    }

    private static void moy(StringBuilder stringBuilder, String string, int n) {
        if (n > 0) {
            stringBuilder.append(string).append(n);
        }
    }

    private void moz() {
        List<pdr> list = pej.items();
        int n = this.mmh == null ? 0 : list.indexOf(this.mmh) + 1;
        this.moq();
        this.mne = 0;
        this.mnd = false;
        this.mnf = false;
        this.mmm = 0;
        this.mmk = false;
        this.mml = 0;
        this.mmh = this.mpa(list, Math.max(0, n));
        this.mme.arm(this.mlz.draw(5));
        if (this.mmh != null) {
            this.mmj = this.mmh.query();
            this.mmo = false;
            this.mpe(true);
            this.mpl(wap.s(a.d("\u5c7a\u25e7\uaf37\u3146\uba98\u3c2f\u866b\u0f87\u91df\u1b67\u9ce9\u6682", 1859113898, 1222741919), a.c(-275535980, "\ua3bf\uda11\u50cd\uceb5\u451a\uc3db\u798d\uf075\u6a2c\ue087")) + this.mmh.name(), true);
            return;
        }
        this.mmj = "";
        if (this.mmn.isEmpty()) {
            if (this.mmi) {
                this.mpl(wap.s(a.d("\u1822\u61a0\ueb60\u7506\ufeda\u7866\uc229\u4bd9\ud581\u5f39\ud8ad\u2295\uac58\u35ba\ubfaa\u3957\u831b\u0cca\u9670\u1027\u99c7\ue387\u6d35", -1425292547, 1663752845), a.b("\u939e\uea7c\u60db\ufabf\u7577\uf3b9\u499f\uc06f\u5e38\ud480\u5324\ua95c\u23e0\ube30\u341c\ub2e2\u08dc\u877d\u1dc3\u9be4\u1674\u6c29\ue6fa\u7d5b\ufb25\u71fb\uc834\u4617\ud8f0\u5ab6\ud102\u2fd1\ua599\u3c1d\uba46\u308a\u8f55\u0529", -999450710)), true);
            }
            this.mmi = false;
        } else if (!this.mmo) {
            this.mmo = true;
            this.mpl(wap.s(a.d("\u7218\u0b84\u8157\u1f6a\u94f1\u1249\ua819\u21fa\ubff1\u3509\ub2c7\u48a7\uc678\u5fd7\ud5d7\u5367\ue93b\u66fd\ufc0b\u7a0a\uf3f8\u89a8\u074f\u9cd1\u1aa7\u9076\u298f\ua7d2\u3d67\ubb35\u3084\uce5d\u4459\uddfc\u5bb4\ud14a\u6ec9\ue4a4\u627a\ufbc3\u71d1\u0f6c\u8532\u0296\u9850\u1636", -1074065957, 77627308), a.b("\u65d2\u1c30\u9697\u0cf3\u8345\u05f7\ubfa6\u3629\ua872\u22c1\ua10a\u5f65\ud1ce\u4806\uc250\u44a9\ufee5\u713c\uebf9\u69cf\ue034\u9e77\u10c3\u8b67\u0d65\u87ca\u3e7b\ub027\u2ebc\uacf7\u235e\ud992\u53d8\uca2d\u4862\uc6cc\u791a\uf362\u75b0\uec02", -1112055320)), true);
        }
    }

    private pdr mpa(List<pdr> list, int n) {
        long l = System.currentTimeMillis();
        this.mmn.values().removeIf(l2 -> l2 <= l);
        for (int i = 0; i < list.size(); ++i) {
            pdr pdr2 = list.get((n + i) % list.size());
            if (!pdr2.active() || this.mmn.containsKey(pdr2) || this.mpf(pdr2) >= pdr2.count()) continue;
            return pdr2;
        }
        return null;
    }

    private void mpb() {
        if (!this.mmi || this.mmn.isEmpty() || !this.mmf.elapsed(2500L)) {
            return;
        }
        this.mmf.restart();
        this.moz();
    }

    private void mpc() {
        this.mmh = null;
        this.mmi = false;
        this.mmo = false;
        this.mmj = "";
        this.mmn.clear();
        this.moq();
        this.mnd = false;
        this.mnf = false;
        this.mmm = 0;
        this.mmk = false;
        this.mml = 0;
    }

    private void mpd() {
        this.mpc();
        this.mms = SlotActionType.field_7790;
        this.mmt = false;
        this.mmu = 0;
        this.mne = 0;
        this.mmy = -1;
        this.mnj = 0;
        this.mnk = 0;
        this.mnm = 0.0f;
        this.mnn = 0.0f;
        this.mni = false;
        this.mmz = 0;
        this.mna = 0;
        this.mnb = 0;
        this.mnc = ItemStack.field_8037;
        this.mno = false;
        this.mnp = false;
        this.mnq = false;
    }

    private void mpe(boolean bl) {
        if (this.mmh == null || !bl && --this.mna > 0) {
            return;
        }
        this.mna = 4;
        this.mmz = this.mpf(this.mmh);
        this.mnc = this.mmh.isPotion() && !this.mmh.hasEffects() ? this.mpg(this.mmh) : ItemStack.field_8037;
        int n = this.mmh.count() + Math.round((float)this.mmh.count() * 0.2f);
        this.mnb = Math.max(n - this.mmz, this.mmh.count());
    }

    private int mpf(pdr pdr2) {
        if (this.mc.field_1724 == null) {
            return 0;
        }
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        int n = 0;
        for (int i = 0; i < 41; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_7960() || !pdr2.matches(itemStack)) continue;
            n += itemStack.method_7947();
        }
        return n;
    }

    private ItemStack mpg(pdr pdr2) {
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        for (int i = 0; i < 41; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_7960() || !pdr2.matches(itemStack)) continue;
            return itemStack;
        }
        return ItemStack.field_8037;
    }

    private boolean mph() {
        long l = System.currentTimeMillis();
        this.mmp = Math.min(6.0, this.mmp + (double)(l - this.mmq) / 4000.0);
        this.mmq = l;
        if (this.mmp < 1.0) {
            return false;
        }
        this.mmp -= 1.0;
        return true;
    }

    private double mpi() {
        return 1 << Math.min(this.mmm, 3);
    }

    private void mpj() {
        this.mmr = -1;
        this.mmx = 0;
        this.mmy = -1;
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity != null && this.mc.field_1755 instanceof GenericContainerScreen) {
            clientPlayerEntity.method_7346();
        }
    }

    private boolean mpk(MinecraftClient minecraftClient) {
        boolean bl = vzz.isDown(minecraftClient, 256);
        if (minecraftClient.field_1755 instanceof hlc) {
            this.mni = bl;
            return false;
        }
        if (bl && !this.mni) {
            this.mni = true;
            this.mpc();
            this.mpl(wap.s(a.c(626807961, "\u54c4\u2d52\ua79a\u39f4\ub223\u3487\u8ed5\u0760\u997d\u13d7\u945d\u6e49\ue0a8\u7909"), a.d("\u9552\uecf3\u6621\uf85f\u73f4\uf537\u4b74\uc69b\u58bb\ud209\u55a8\uafd4\u2100\ub8bd\u32e7\ub418\u0e5f\u8183\u1f20\u9979\u10e3\u6a84\ue427\u7fbc", 722292640, -1959403830)), false);
            return true;
        }
        this.mni = bl;
        return false;
    }

    private void mpl(String string, boolean bl) {
        if (this.mlx.get()) {
            izx.alert(this.getName(), string, bl ? vhz.CHECK : vhz.INFO, bl);
        }
    }

    static {
        mkp = a.d("\u4a1f\u33d7\ub978\u270e\uaca3\u2a1c", -993364463, 533739570);
        mkn = new String[]{a.d("\uc77b\ubeb0\u346d\uaa1d\u21bd\ua701\u1d55", 1386593625, -439058844), a.c(-398867590, "\uc74c\ubef0\u3429\uaa2d"), a.d("\u0546", 1672504866, 1071473630), a.d("\u1f1b", 615472894, -1078108042)};
        mko = new String[]{a.d("\ua654\udf9a\u553c\ucb4c\u40e4\uc62a\u7c0e\uf5f5", 1297984769, -879227038), a.d("\uc0b7\ub90b\u33df\uada9\u267a", -207007531, -819817382), a.b("\u9620", 2097518218), a.d("\u9aa1", -878194436, 0xCCB6BCC)};
        mkq = new String[]{a.c(678258110, "\u6194\u1824\u92fd\u0cfa\u875d\u01eb\ubbcd\u324a\uac17\u26a7\ua17c\u5b08\ud5d2\u4876\uc63a\u40ca\ufa81\u7529\uefe6\u69b2\ue047"), a.d("\ueed1\u9761\u1db8\u83c3\u081d\u8edb\u34f0\ubd7b\u2353\ua9ec\u2e48\ud448\u5a92\uc35c\u4d60\ucff7\u75cb\ufa12\u60ac", -647756837, -136910554)};
        mkr = Pattern.compile(a.b("\u5d77\u24b2\uae59\u3067\ubbb2\u3d76\u870a\u0ea2\u90f8\u1a3a\u9dc6\u67ee\ue93b\u70fe\ufa95\u7c2b\uc666", 644308302));
    }

    private static /* synthetic */ int bbm(int n, int n2) {
        return n ^ n2 | 0xBB5D6092;
    }

    private static /* synthetic */ int bbn(int n, int n2) {
        return mkl.bbm(n, n2) + n;
    }
}

