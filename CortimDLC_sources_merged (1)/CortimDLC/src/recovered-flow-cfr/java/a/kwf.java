/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.Monster
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.kfa;
import a.kfe;
import a.kjq;
import a.kmy;
import a.kvz;
import a.lgc;
import a.ljx;
import a.lkh;
import a.lng;
import a.nuo;
import a.ovh;
import a.oxw;
import a.tck;
import a.tcw;
import a.tcz;
import a.tiq;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmu;
import a.vyd;
import a.vyk;
import a.vzz;
import flow.config.ConfigManager;
import flow.dev.a;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class kwf
extends kfe {
    private final vlv kwg = this.add(new vlv(a.c(233082365, "\u8da7\uf42b\u7ee3\ue087\u6b45\uede9\u57bc\ude4c"), a.b("\u15f1\u6c7a\ue6ac\u78d4\uf308\u75a3", -1076030044), a.d("\ucf2c\ub6a7\u3c71\ua209\u29d5\uaf7e", -1684065766, -1101071005), a.b("\uba1b\uc385\u4953\ud72e\u5cf2\uda59", -268846498)));
    private final vlv kwh = this.add(new vlv(a.b("\uf02a\u89b3\u0364", 1299902568), a.b("\u97dc\uee46\u6485\ufaf3\u7137\uf78b", 1119721364), a.c(459830664, "\u75c0\u0c5a\u8699\u18ef\u932b\u1597"), a.b("\u92fb\ueb71\u61ab\uffc9\u7408", 1293259437)));
    private final vlv kwi = this.add(new vlv(a.c(215903861, "\u6e37\u17ad\u9d6e\u0318\u88dc\u0e60\ub47f\u3dc3\ua39e\u2924\uaef6\u548e"), a.b("\u32ca\u4b59\uc197\u5fef\ud437\u5283\ue8d9\u616d\uff23", 1659122323), a.d("\ue153\u98c0\u120e\u8c76\u07ae\u811a\u3b40\ub2f4\u2cba", -1335107776, 1625505354), a.c(-1785420293, "\ua5ae\udc38\u56ea\uc88a\u4350\uc5e7")));
    private final vmu kwj = this.add(new vmu(a.d("\u7c74\u05f1\u8f25\u1147\u9ad1\u1c30\ua661\u2f8d\ub1db\u3b65\ubcb3\u46cb", -2120129952, -1019732391), "", 32));
    private final vmc kwk = this.add(new vmc(a.d("\u32c6\u4b54\uc192\u5fe3\ud435", 2046298678, 1360869542), 1.0, 0.3, 1.6, 0.05).percent());
    private final vmc kwl = this.add(new vmc(a.c(500444174, "\u2c50\u55d2\udf16\u4161\ucaab\u4c10\uf641\u7fbd"), 1.0, 0.0, 1.0, 0.05).percent());
    private final vlv kwm = this.add(new vlv(a.c(305277693, "\u2ab6\u532f\ud9f8\u47c4\ucc5b\u4ae7\uf0b8\u7947\ue717\u6dba"), a.d("\u01ff\u786c\uf2b4\u6cc4\ue71a", -249325704, -627665201), a.b("\ud944\ua0d7\u2a0f\ub47f\u3fa1", -33892084), a.b("\u5fd7\u2650\uac85\u32f3\ub93f\u3f8c", -210083950)));
    private final vmc kwn = this.add(new vmc(a.c(-1727678203, "\ub946\uc0da\u4a05\ud47a\u5fa2\ud90f\u6308\ueabf\u74f4\ufe58\u7989"), 0.45, 0.0, 1.0, 0.05).percent());
    private final vmc kwo = this.add(new vmc(a.c(1334337753, "\u6098\u1904\u93db\u0da4\u867c\u00d1\ubad6\u3373\uad37"), 0.85, 0.0, 1.0, 0.05).percent());
    private final vmc kwp = this.add(new vmc(a.c(1927083304, "\uf56d\u8cd5\u061f"), 360.0, 10.0, 360.0, 5.0).unit(a.d("\u3275", -850838333, 1147276807)));
    private final vmc kwq = this.add(new vmc(a.b("\u8aee\uf372\u79bb\ue7cd\u6c0f\ueab1\u50ef\ud918", 1612090018), 4.0, 2.0, 6.0, 0.1).suffix(a.c(1180195030, "\u58ba")));
    private final vlv kwr = this.add(new vlv(a.c(281209406, "\uea72\u93fe\u193c\u8745\u0c8c"), a.b("\u37e9\u4e6a\uc4bd\u5add\ud115\u57a5\uedeb", -2091567175), a.c(-1601781311, "\uc191\ub812\u32c5\uaca5\u276d\ua1dd\u1b93"), a.d("\u3661\u4ff4\uc53f\u5b53\ud092\u5634", 1773748394, 1249605278), a.b("\ufeda\u8752\u0d9c\u93fb", -218825057), a.d("\u5e2e\u27b0\uad74", -1237545396, -409087968)));
    private final vlv kws = this.add(new vlv(a.d("\ufbde\u824d\u0885\u96f2\u1d38\u9b92\u21dc\ua820", -1153097373, 535026405), a.d("\u60ba\u1924\u93fe\u0d84\u865a", 1523545751, 485758569), a.b("\u9aa2\ue33c\u69e6\uf79c\u7c42", -755524890), a.c(1021864061, "\u6831\u11ad\u9b64\u0512\u8ed0\u086e\ub230\u3bc7"), a.d("\u1252\u6bce\ue119\u7f65\uf4aa\u7207", 640434405, 1461408505)));
    private final vkl kwt = this.add(new vkl(a.d("\u0ff1\u7671\ufcb9\u62d5\ue905", -887580280, -1212246465), true));
    private final vkl kwu = this.add(new vkl(a.b("\u0679\u7fea\uf520\u6b42\ue0d0\u6627\udc7b\u559b", 2056652348), true));
    private final vkl kwv = this.add(new vkl(a.b("\uc142\ub8c4\u3206\uac76\u27a6\ua10b\u1b16\u92b1\u0cf1\u864c\u018d", -1719287525), false));
    private final vkl kww = this.add(new vkl(a.b("\u116d\u68e0\ue23e\u7c57\uf79c\u713a\ucb68", -377941702), true));
    private final vkl kwx = this.add(new vkl(a.b("\u8249\ufbda\u7104\uef64", -1355120128), false));
    private final vkl kwy = this.add(new vkl(a.b("\u6187\u180a\u92c3\u0caf\u8762\u01c1\ubb9d\u3224\uac2c\u268b\ua155\u5b24\ud5ec", -443981346), false));
    private static final double kwz = 1.2;
    private static final int kxa = 2;
    private static final double kxb = Math.sin(Math.toRadians(22.5));
    private static final int kxc = 8;
    private static final int kxd = 2;
    private final Random kxe = new Random();
    private static kwf kxf;
    private final lng kxg = new lng();
    private final kjq kxh = kjq.embedded(this::kyg);
    private final ljx kxi = new ljx();
    private final lkh kxj = new lkh(this.kxi);
    private Entity kxk;
    private Vec3d kxl;
    private double kxm;
    private boolean kxn;
    private boolean kxo;
    private boolean kxp;
    private ClientPlayerEntity kxq;
    private tiq kxr;
    private String kxs = "";
    private tck kxt;
    private long kxu;
    private int kxv = 2;
    private static /* synthetic */ long kxw;
    private static /* synthetic */ String kxx;

    public kwf() {
        super(a.c(1203908670, "\u307d\u49ee\uc338\u5d49\ud6b3\u5036\uea62\u6380"), a.d("\u0d82\u741c\ufec1\u60bf\ueb74\u6dc2\ud7c2\u5e67\uc024\u4a98\ucd0e\u3731\ub9ed\u2058\uaa18\u2cfe\u96a7\u1971\u8396\u0593\u8c71\uf633\u7895\ue346\u6528\uefad\u5649\ud806\u42ec\uc4a1\u4f5a\ub1df\u3b8c\ua270\u2466\uae99\u1145\u9b24\u1df0\u8452\u0e00\u70bd\ufabc\u7d10\ue7dc\u69b8\ud07e\u5ad2\udc9b\u474b", -355053796, -30260502), kfa.COMBAT);
        kxf = this;
        this.kwu.visibleWhen(() -> this.kwg.is(a.d("\u467e\u3ff5\ub523\u2b5b\ua087\u262c", -1237692396, 656414271)));
        this.kwv.visibleWhen(() -> this.kwg.is(a.c(-1390044569, "\u9a22\ue3bc\u696a\uf717\u7ccb\ufa60")));
        this.kwi.visibleWhen(() -> this.kwh.is(a.b("\ub26b\ucbf1\u4132\udf44\u5480\ud23c", -1843023325)));
        this.kwk.visibleWhen(() -> this.kwh.is(a.d("\ua2a4\udb3e\u51fd\ucf8b\u444f\uc2f3", 601377720, 387246420)) && !this.kwi.is(a.c(514856085, "\u14c0\u6d56\ue784\u79e4\uf23e\u7489")));
        this.kwl.visibleWhen(() -> this.kwh.is(a.b("\ua6ab\udf31\u55f2\ucb84\u4040\uc6fc", 1431676643)) && !this.kwi.is(a.d("\u6eec\u177a\u9da8\u03c8\u8812\u0ea5", -308974915, -1883110396)));
        this.kwm.visibleWhen(() -> this.kwh.is(a.d("\ud637\uafad\u256e\ubb18\u30dc\ub660", 73124402, -1654514611)) && !this.kwi.is(a.b("\u1615\u6f83\ue551\u7b31\uf0eb\u765c", -1866983872)));
        this.kwn.visibleWhen(() -> this.kwh.is(a.b("\u52f2\u2b68\ua1ab\u3fdd\ub419\u32a5", 857559738)) && !this.kwi.is(a.c(-578622383, "\uec04\u9592\u1f40\u8120\u0afa\u8c4d")) && this.kwm.is(a.c(924850186, "\u184f\u61c8\ueb1d\u756b\ufea7\u7814")));
        this.kwo.visibleWhen(() -> this.kwh.is(a.d("\ub491\ucd0b\u47c8\ud9be\u527a\ud4c6", -546480833, 189327846)) && !this.kwi.is(a.c(1822190145, "\u6a14\u1382\u9950\u0730\u8cea\u0a5d")) && this.kwm.is(a.b("\ucc02\ub585\u3f50\ua126\u2aea\uac59", -402994105)));
        this.kwj.visibleWhen(() -> false);
    }

    public static tiq studioProfile() {
        kwf kwf2 = kxf;
        if (kwf2 == null) {
            return null;
        }
        String string = kwf2.kwj.get();
        if (string == null || string.isBlank()) {
            kwf2.kxr = null;
            kwf2.kxs = "";
            return null;
        }
        if (kwf2.kxr == null || !string.equals(kwf2.kxs)) {
            kwf2.kxs = string;
            kwf2.kxr = tiq.open(string);
        }
        return kwf2.kxr;
    }

    public static boolean usesStudio(tiq tiq2) {
        kwf kwf2 = kxf;
        return kwf2 != null && tiq2 != null && kwf2.kwi.is(a.c(-1515519047, "\u03ec\u7a7a\uf0a8\u6ec8\ue512\u63a5")) && kwf.studioProfile() == tiq2;
    }

    public static void useStudio(tiq tiq2) {
        kwf kwf2 = kxf;
        if (kwf2 == null) {
            return;
        }
        kwf2.kwj.set(tiq2 == null ? "" : tiq2.name);
        kwf2.kxr = tiq2;
        kwf2.kxs = tiq2 == null ? "" : tiq2.name;
        kwf2.kwi.set(tiq2 == null ? a.d("\u84f8\ufd6b\u77a5\ue9dd\u6205\ue4b1\u5eeb\ud75f\u4911", 738863724, 2079502029) : a.d("\ue1e9\u987f\u12ad\u8ccd\u0717\u81a0", -302855574, 1240083414));
        kwf2.kxu = 0L;
        ConfigManager.autoSaveLater();
    }

    private tck kxy() {
        if (!this.kwi.is(a.c(1647453411, "\u24b6\u5d20\ud7f2\u4992\uc248\u44ff"))) {
            return tck.profile1();
        }
        long l = System.currentTimeMillis();
        if (l - this.kxu > 1000L) {
            this.kxu = l;
            tiq tiq2 = kwf.studioProfile();
            this.kxt = tiq2 == null ? null : tiq2.auraModel();
        }
        return this.kxt != null ? this.kxt : tck.profile1();
    }

    public static Entity target() {
        return kxf != null && kxf.isEnabled() ? kwf.kxf.kxg.target() : null;
    }

    public static String debug() {
        if (kxf == null) {
            return a.b("\u9ebc\ue704\u6dd7", -178938160);
        }
        ClientPlayerEntity clientPlayerEntity = MinecraftClient.getInstance().player;
        return String.format(Locale.ROOT, a.d("\ued0a\u94b2\u1e61\u8005\u0bc4\u8d64\u377e\ube97\u209e\uaa7c\u2de9\ud797\u594e\uc0f0\u4abf\ucc53\u761b\uf9c3\u632a\ue563\u6cc2\u16c0\u983a\u03e6\u8591\u0f49\ub6a2\u38eb\ua24a\u2448\uafad\u5163\udb20\u42c3\uc4da\u4e73\uf1af\u7bc1\ufd45\u64bd\ueee8\u9012\u1a5e\u9db8\u0729\u890b\u30c3\uba7b\u3c27\ua7e0\u29ac\ud303\u5ae2\udc9d\u4613\uc800\u73b2\uf578\u7f24\ue68b\u686a\u1215", -728323603, 1423393974), kwf.kxf.kxg.debugOffsets(), kwf.kxf.kxo, kwf.kxf.kxg.idle(), clientPlayerEntity == null ? 0.0 : (double)kwf.kxf.kxg.serverYaw(clientPlayerEntity), clientPlayerEntity == null ? 0.0 : (double)kwf.kxf.kxg.serverPitch(clientPlayerEntity), kwf.kxf.kxj.debug(), kwf.kxf.kxh.trace());
    }

    public static boolean returning() {
        return kxf != null && kwf.kxf.kxp;
    }

    @Override
    public boolean ticksWhenOff() {
        return this.kxp;
    }

    @Override
    protected void onEnable() {
        if (!this.kxp) {
            this.kxg.reset();
        }
        this.kxp = false;
        this.kxq = null;
        this.kxo = false;
        this.kxj.enabled();
        this.kxh.onEnable();
    }

    @Override
    protected void onDisable() {
        this.kxh.onDisable();
        this.kxo = false;
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (this.kwg.is(a.c(1014196903, "\u6af2\u1379\u99af\u07d7\u8c0b\u0aa0")) && clientPlayerEntity != null && clientPlayerEntity.isAlive() && !this.kxg.idle()) {
            this.kxg.hit(2 + this.kxe.nextInt(3));
            this.kxp = true;
            this.kxq = clientPlayerEntity;
            return;
        }
        this.kxg.end(clientPlayerEntity);
        this.kye(this.mc);
        this.kxg.reset();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!this.isEnabled()) {
            if (this.kxp && clientPlayerEntity == this.kxq) {
                this.kxg.begin(clientPlayerEntity);
                if (this.kwu.get() && !this.kxg.idle() && minecraftClient.currentScreen == null) {
                    this.kyd(minecraftClient, clientPlayerEntity);
                }
            }
            return;
        }
        boolean bl = this.kwg.is(a.d("\u6fbf\u1634\u9ce2\u029a\u8946\u0fed", -717577097, -817247331));
        this.kxg.mode(bl, clientPlayerEntity);
        this.kxg.begin(clientPlayerEntity);
        if (bl && this.kwu.get() && !this.kxg.idle() && minecraftClient.currentScreen == null) {
            this.kyd(minecraftClient, clientPlayerEntity);
        }
        if (this.kyl(minecraftClient, clientPlayerEntity) && this.kym(clientPlayerEntity.getMainHandStack()) && !lgc.moduleOn()) {
            this.kxh.crits(this.kwt.get());
            this.kxh.onStartTick(minecraftClient);
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        Entity entity;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        this.kxg.end(clientPlayerEntity);
        this.kxg.newTick(clientPlayerEntity);
        this.kye(minecraftClient);
        tck tck2 = this.kxy();
        boolean bl = tck2 != tck.profile1();
        this.kxg.use(tck2, bl ? 1.0 : this.kwk.get());
        this.kxg.vertical(bl ? 1.0 : this.kwl.get());
        if (!bl && this.kwm.is(a.b("\u340c\u4d8b\uc75e\u5928\ud2e4\u5457", -563661751))) {
            this.kxg.height(this.kwn.get(), this.kwo.get());
        } else {
            this.kxg.height(Double.NaN, Double.NaN);
        }
        this.kxg.verticalAware(false);
        this.kxg.stepCap(bl && tck2.turnCap > 0.0f ? (double)tck2.turnCap : this.kxg.maxTurn());
        int n = this.kxv = bl ? -1 : 2;
        if (!this.isEnabled()) {
            this.kyb(minecraftClient, clientPlayerEntity);
            return;
        }
        this.kxh.onEndTick(minecraftClient);
        Entity entity2 = entity = this.kyl(minecraftClient, clientPlayerEntity) && this.kym(clientPlayerEntity.getMainHandStack()) ? this.kyf(minecraftClient, clientPlayerEntity) : null;
        if (entity == null) {
            this.kxj.targetNull();
            this.kxi.target = null;
            this.kxk = null;
            this.kxl = null;
            if (this.kxo && clientPlayerEntity.isAlive()) {
                this.kxg.hit(8 + this.kxe.nextInt(5));
            }
            this.kxo = false;
            this.kyc(minecraftClient, clientPlayerEntity);
            return;
        }
        this.kxo = true;
        if (this.kwh.is(a.d("\u3299\u4b13\uc1c9\u5fab\ud46a", 648642937, 2018161590))) {
            this.kxz(minecraftClient, clientPlayerEntity, entity);
        } else {
            this.kxg.track(minecraftClient, clientPlayerEntity, entity, this.kxv);
        }
    }

    private void kxz(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity) {
        float f = this.kxg.serverYaw(clientPlayerEntity);
        float f2 = this.kxg.serverPitch(clientPlayerEntity);
        Box box = entity.getBoundingBox();
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = box.getCenter();
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.y - vec3d.y;
        double d3 = vec3d2.z - vec3d.z;
        this.kxi.target = entity;
        this.kxi.box = box;
        this.kxi.yawToTarget = (float)(Math.toDegrees(Math.atan2(d3, d)) - 90.0);
        this.kxi.pitchToTarget = (float)(-Math.toDegrees(Math.atan2(d2, Math.hypot(d, d3))));
        this.kxi.strikeIn = this.kxh.strikeIn(minecraftClient, clientPlayerEntity, entity, this.kwt.get());
        this.kxi.attackReady = this.kxi.strikeIn == 0;
        this.kya(entity, vec3d, vec3d2);
        if (this.kxj.rotate(f, f2)) {
            this.kxg.turnBy(minecraftClient, clientPlayerEntity, entity, this.kxj.yaw() - f, this.kxj.pitch() - f2);
        }
    }

    private void kya(Entity entity, Vec3d vec3d, Vec3d vec3d2) {
        Vec3d vec3d3;
        Vec3d vec3d4 = entity.getEntityPos();
        Vec3d vec3d5 = vec3d3 = entity == this.kxk && this.kxl != null ? vec3d4.subtract(this.kxl) : Vec3d.ZERO;
        if (vec3d3.lengthSquared() > 1.0) {
            vec3d3 = Vec3d.ZERO;
        }
        if (entity != this.kxk || entity.isOnGround()) {
            this.kxm = vec3d4.y;
        }
        this.kxk = entity;
        this.kxl = vec3d4;
        double d = vec3d2.x;
        double d2 = vec3d2.y;
        double d3 = vec3d2.z;
        double d4 = entity.isOnGround() ? 0.0 : vec3d3.y;
        double d5 = vec3d2.y - (vec3d4.y - this.kxm);
        for (int i = 0; i < 16; ++i) {
            this.kxi.eyeAt[i] = vec3d.add(this.kxh.selfOffset(i));
            this.kxi.targetAt[i] = new Vec3d(d, d2, d3);
            d += vec3d3.x;
            d3 += vec3d3.z;
            if (d4 == 0.0 && !(d2 > d5)) continue;
            d2 += d4;
            d4 = (d4 - 0.08) * 0.98;
            if (!(d2 < d5)) continue;
            d2 = d5;
            d4 = 0.0;
        }
    }

    private void kyb(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (clientPlayerEntity != this.kxq || clientPlayerEntity == null || !clientPlayerEntity.isAlive() || !this.kwg.is(a.b("\ua899\ud112\u5bc4\uc5bc\u4e60\uc8cb", 1240377548)) || this.kxg.home(minecraftClient, clientPlayerEntity)) {
            this.kxg.reset();
            this.kxp = false;
            this.kxq = null;
        }
    }

    private void kyc(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (!clientPlayerEntity.isAlive()) {
            this.kxg.forget();
        } else if (this.kwv.get() || this.kwg.is(a.b("\u16ce\u6f45\ue593\u7beb\uf037\u769c", -1848633701))) {
            this.kxg.home(minecraftClient, clientPlayerEntity);
        } else {
            this.kxg.release();
        }
    }

    private void kyd(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        GameOptions gameOptions = minecraftClient.options;
        double d = (vzz.isPhysicallyDown(minecraftClient, gameOptions.forwardKey) ? 1 : 0) - (vzz.isPhysicallyDown(minecraftClient, gameOptions.backKey) ? 1 : 0);
        double d2 = (vzz.isPhysicallyDown(minecraftClient, gameOptions.leftKey) ? 1 : 0) - (vzz.isPhysicallyDown(minecraftClient, gameOptions.rightKey) ? 1 : 0);
        if (d == 0.0 && d2 == 0.0) {
            return;
        }
        double d3 = Math.toRadians(this.kxg.cameraYaw(clientPlayerEntity));
        double d4 = d2 * Math.cos(d3) - d * Math.sin(d3);
        double d5 = d * Math.cos(d3) + d2 * Math.sin(d3);
        double d6 = Math.hypot(d4, d5);
        double d7 = Math.toRadians(clientPlayerEntity.getYaw());
        double d8 = (d5 * Math.cos(d7) - d4 * Math.sin(d7)) / d6;
        double d9 = (d4 * Math.cos(d7) + d5 * Math.sin(d7)) / d6;
        gameOptions.forwardKey.setPressed(d8 > kxb);
        gameOptions.backKey.setPressed(d8 < -kxb);
        gameOptions.leftKey.setPressed(d9 > kxb);
        gameOptions.rightKey.setPressed(d9 < -kxb);
        this.kxn = true;
    }

    private void kye(MinecraftClient minecraftClient) {
        if (!this.kxn || minecraftClient.options == null) {
            return;
        }
        this.kxn = false;
        for (KeyBinding keyBinding : new KeyBinding[]{minecraftClient.options.forwardKey, minecraftClient.options.backKey, minecraftClient.options.leftKey, minecraftClient.options.rightKey}) {
            keyBinding.setPressed(minecraftClient.currentScreen == null && vzz.isPhysicallyDown(minecraftClient, keyBinding));
        }
    }

    /*
     * Exception decompiling
     */
    private Entity kyf(MinecraftClient var1_1, ClientPlayerEntity var2_2) {
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

    private boolean kyg(Entity entity) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)entity;
            return this.kww.get() && !playerEntity.isSpectator() && !hhf.protects((Entity)playerEntity);
        }
        return this.kwx.get() && entity instanceof Monster;
    }

    private boolean kyh(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        LivingEntity livingEntity;
        if (!(entity != clientPlayerEntity && entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).isAlive() && entity.isAttackable() && this.kyg(entity))) {
            return false;
        }
        return this.kwy.get() || clientPlayerEntity.canSee(entity);
    }

    private static double kyi(LivingEntity livingEntity) {
        vyd vyd2 = vyk.of(livingEntity);
        return vyd2.unknown() ? 100.0 : (double)vyd2.total();
    }

    private static boolean kyj(Vec3d vec3d, Entity entity, double d) {
        return entity.getBoundingBox().squaredMagnitude(vec3d) <= d * d;
    }

    private static double kyk(float f, Vec3d vec3d, Entity entity) {
        Vec3d vec3d2 = entity.getEntityPos();
        double d = Math.toDegrees(Math.atan2(vec3d2.z - vec3d.z, vec3d2.x - vec3d.x)) - 90.0;
        return Math.abs(MathHelper.wrapDegrees((double)(d - (double)f)));
    }

    private boolean kyl(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return minecraftClient.currentScreen == null && clientPlayerEntity.isAlive() && !clientPlayerEntity.isSpectator() && !clientPlayerEntity.isUsingItem() && !clientPlayerEntity.isRiding() && !ovh.active() && !oxw.busy() && !kvz.busy() && !nuo.busy() && !kmy.busy() && tcz.mode() != tcw.RECORD && (minecraftClient.interactionManager == null || !minecraftClient.interactionManager.isBreakingBlock());
    }

    /*
     * Exception decompiling
     */
    private boolean kym(ItemStack var1_1) {
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

    private /* synthetic */ boolean lambda$pickTarget$9(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        return this.kyh(clientPlayerEntity, entity);
    }

    private static /* synthetic */ int avm(int n, int n2) {
        return (n ^ n2) + 1400613756;
    }
}

