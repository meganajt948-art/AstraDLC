/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.entity.mob.Monster
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 *  org.lwjgl.glfw.GLFWCursorPosCallback
 *  org.lwjgl.glfw.GLFWCursorPosCallbackI
 */
package a;

import a.hhf;
import a.kfa;
import a.kfe;
import a.kmy;
import a.lck;
import a.lln;
import a.lqq;
import a.nfl;
import a.ovh;
import a.tbm;
import a.tbp;
import a.tcw;
import a.tcz;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vxr;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class kyn
extends kfe {
    private final vmc kyo = this.add(new vmc(a.d("\u6346\u1ad4\u9012\u0e63\u85b5", -619412060, 1931273908), 5.0, 1.0, 10.0, 1.0));
    private final vmc kyp = this.add(new vmc(a.d("\u5cb3\u2521\uafe7\u3196\uba40\u3cb5\u86b5\u0f47\u911a\u1bbc\u9c6b\u661f", -983236670, 925475630), 0.3, 0.0, 0.6, 0.05).percent());
    private final vmc kyq = this.add(new vmc(a.d("\ued80\u940e\u1ede\u80b7\u0b73\u8dc9\u3782\ube6a", -411490779, -873804802), 0.35, 0.0, 0.8, 0.05).percent());
    private final vmc kyr = this.add(new vmc(a.c(1146289752, "\ufe06\u8784\u0d40\u9337\u18fd\u9e46\u2417\uadeb"), 0.5, 0.0, 1.0, 0.05).percent());
    private final vmc kys = this.add(new vmc(a.c(1509878106, "\ue91f\u90a7\u1a6d"), 90.0, 20.0, 180.0, 5.0).unit(a.b("\ud2b2", -1700343293)));
    private final vmc kyt = this.add(new vmc(a.b("\ue30f\u9a93\u105a\u8e2c\u05ee\u8350\u390e\ub0f9", -1452612797), 4.0, 2.0, 6.0, 0.1).suffix(a.d("\ubec6", -490704688, 1064291962)));
    private final vlv kyu = this.add(new vlv(a.c(2006925133, "\u3f01\u468d\ucc4f\u5236\ud9ff"), a.d("\ubfe9\uc66a\u4cbd\ud2dd\u5915\udfa5\u65eb", 1771780979, -1815575350), a.b("\ue194\u9817\u12c0\u8ca0\u0768\u81d8\u3b96", -231808572), a.c(-1261425033, "\u2e22\u57b7\udd7c\u4310\uc8d1\u4e77"), a.d("\ud17c\ua8f4\u223a\ubc5d", 816797853, -1378711132), a.c(-30588880, "\u4072\u39ec\ub328")));
    private final vkl kyv = this.add(new vkl(a.c(-1265563731, "\u07e4\u7e7a\uf4ac\u6ad7\ue108\u67f2\uddee\u541e\uca43\u40e7"), false));
    private final vkl kyw = this.add(new vkl(a.d("\uc39c\uba11\u30cf\uaea6\u256d\ua3cb\u1999", 1618045485, 1203415526), true));
    private final vkl kyx = this.add(new vkl(a.c(-230131163, "\u7a6c\u03ff\u8921\u1741"), false));
    private final vkl kyy = this.add(new vkl(a.d("\u4cf3\u357e\ubfb7\u21db\uaa16\u2cb5\u96e9\u1f50\u8158\u0bff\u8c21\u7650\uf898", -1799006606, -1119348008), false));
    private static final double kyz = 1.2;
    private static final double kza = 0.12;
    private static final double kzb = 0.08;
    private static final double kzc = 0.25;
    private static Field kzd;
    private static Field kze;
    private static Field kzf;
    private final Random kzg = new Random();
    private final lln kzh = new lln();
    private final tbm kzi = new tbm();
    private final tbm kzj = new tbm();
    private final double[] kzk = new double[2];
    private long kzl;
    private GLFWCursorPosCallback kzm;
    private GLFWCursorPosCallback kzn;
    private boolean kzo;
    private double kzp;
    private double kzq;
    private double kzr;
    private double kzs;
    private double kzt = Double.NaN;
    private double kzu = Double.NaN;
    private double kzv;
    private double kzw;
    private double kzx;
    private double kzy;
    private LivingEntity kzz;
    private boolean laa;
    private long lab;
    private LivingEntity lac;
    private long lad;
    private double lae;
    private double laf;
    private double lag;
    private double lah;
    private double lai;
    private double laj;
    private double lak;
    private double lal;
    private double lam;
    private double lan;
    private double lao;
    private double lap;
    private double laq;
    private double lar;
    private double las;
    private double lat;
    private double lau;
    private long lav;
    private double law = 0.016666666666666666;
    private boolean lax;
    private long lay;
    private double laz;
    private double lba;
    private double lbb;
    private double lbc;
    private double lbd;
    private double lbe;
    private double lbf;
    private double lbg;
    private boolean lbh;
    private double lbi;
    private double lbj;
    private double lbk;
    private double lbl;
    private static /* synthetic */ long lbm;
    private static /* synthetic */ String lbn;

    public kyn() {
        super(a.b("\u8c2c\uf5b4\u7f65\ue11a\u6ad0\uec54\u562f\udfda", 1205963880), a.c(-213966631, "\u20a9\u5935\ud3ef\u4d82\uc656\u40b4\ufabe\u7359\ued1c\u67aa\ue02b\u1a15\u94da\u0d72\u876f\u01d3\ubb9e\u3455\uaee0\u28a7\ua10f\udb44\u55b1\uce67\u480a\uc2dc\u7b7e\uf538\u6f9d\ue998\u6230\u9cae\u16b5\u8f58\u0906\u83f2\u3c71\ub615\u30d5\ua971\u232c\u5dcc\ud7c7\u507a\ucafe\u4493\ufd49\u77ea\uf1b4\u6a72\ue453\u1ecd\u977b\u1164\u8bde\u0592"), kfa.COMBAT);
    }

    @Override
    protected void onEnable() {
        lck lck2 = kyn.lca();
        if (lck2 != null && lck2.isEnabled()) {
            lck2.setEnabled(false);
        }
    }

    @Override
    protected void onDisable() {
        this.lcc();
        this.kzz = null;
        this.laa = false;
        this.lbp();
        this.kzh.reset();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.world == null) {
            this.kzz = null;
            this.laa = false;
            return;
        }
        this.lbx(minecraftClient);
        this.laa = this.lby(minecraftClient, clientPlayerEntity);
        this.kzz = this.laa ? this.lbt(minecraftClient, clientPlayerEntity) : null;
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        LivingEntity livingEntity;
        lck lck2 = kyn.lca();
        if (lck2 != null && lck2.isEnabled()) {
            this.setEnabled(false);
            return;
        }
        if (!(this.kzn != null && this.kzo || minecraftClient.getWindow() == null)) {
            this.lcb(minecraftClient.getWindow().getHandle());
        }
        long l = System.nanoTime();
        double d = this.lav == 0L ? 0.016666666666666666 : Math.min(0.1, (double)(l - this.lav) / 1.0E9);
        this.lav = l;
        this.law += (Math.min(0.05, d) - this.law) * 0.2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        boolean bl = clientPlayerEntity != null && minecraftClient.currentScreen == null && minecraftClient.mouse.isCursorLocked();
        LivingEntity livingEntity2 = livingEntity = bl && this.laa ? this.kzz : null;
        if (livingEntity != null && livingEntity != this.lac) {
            this.lbo(livingEntity, l);
        }
        boolean bl2 = livingEntity != null && livingEntity == this.lac;
        double d2 = this.lae = bl2 ? Math.min(1.0, this.lae + d / this.laf) : Math.max(0.0, this.lae - d / 0.12);
        if (this.lac != null && (!bl2 && this.lae <= 0.0 || this.lac.isRemoved() || !this.lac.isAlive())) {
            this.lbp();
        }
        if (this.lac == null || clientPlayerEntity == null) {
            this.lax = false;
            this.lbg = 0.0;
            return;
        }
        this.lbq(minecraftClient, clientPlayerEntity, l, d);
    }

    private void lbo(LivingEntity livingEntity, long l) {
        this.lac = livingEntity;
        this.lad = l;
        this.lae = 0.0;
        this.laf = 0.18 + this.kzg.nextDouble() * 0.22;
        this.lag = 0.35 + this.kzg.nextDouble() * 0.2;
        this.lah = this.kzg.nextDouble() * 2.0 - 1.0;
        this.lai = 0.45 + this.kzg.nextDouble() * 0.45;
        this.laj = 1.1 + this.kzg.nextDouble() * 0.6;
        this.lak = this.kzg.nextDouble() * Math.PI * 2.0;
        this.lal = this.kzg.nextDouble() * Math.PI * 2.0;
        double[] dArray = this.lbs();
        this.lao = this.laq = dArray[0];
        this.lam = this.laq;
        this.lap = this.lar = dArray[1];
        this.lan = this.lar;
        this.lat = 0.0;
        this.las = 0.0;
        this.lau = 0.4 + this.kzg.nextDouble() * 0.9;
        this.lbh = false;
        this.lbl = 0.0;
        this.lbk = 0.0;
    }

    private void lbp() {
        this.lac = null;
        this.lae = 0.0;
        this.lax = false;
        this.lbh = false;
        this.lbg = 0.0;
        this.lbl = 0.0;
        this.lbk = 0.0;
    }

    private void lbq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l, double d) {
        double d2;
        double d3;
        double d4;
        double d5 = (double)(l - this.lad) / 1.0E9;
        this.lbr(d5);
        float f = minecraftClient.getRenderTickCounter().getTickProgress(true);
        Vec3d vec3d = clientPlayerEntity.getCameraPosVec(f);
        Vec3d vec3d2 = this.lac.getLerpedPos(f);
        double d6 = (double)this.lac.getWidth() * 0.5;
        double d7 = this.lac.getHeight();
        if (!tbp.aim(vec3d.x, vec3d.y, vec3d.z, vec3d2.x, vec3d2.y, vec3d2.z, d6, d7, this.lam, this.lan, this.kzi) || !tbp.aim(vec3d.x, vec3d.y, vec3d.z, vec3d2.x, vec3d2.y, vec3d2.z, d6, d7, 0.0, 0.5, this.kzj)) {
            this.lax = false;
            this.lbh = false;
            this.lbg = 0.0;
            return;
        }
        if (this.lbh && d > 1.0E-4) {
            d4 = tbp.wrap(this.kzj.yaw - this.lbi) / d;
            d3 = (this.kzj.pitch - this.lbj) / d;
            d2 = 1.0 - Math.exp(-d / 0.08);
            this.lbk += (d4 - this.lbk) * d2;
            this.lbl += (d3 - this.lbl) * d2;
        }
        this.lbi = this.kzj.yaw;
        this.lbj = this.kzj.pitch;
        this.lbh = true;
        this.laz = this.kzi.yaw;
        this.lba = this.kzi.pitch;
        this.lbb = this.kzi.la;
        this.lbc = this.kzi.ra;
        this.lbd = this.kzi.ta;
        this.lbe = this.kzi.ba;
        this.lay = l;
        this.lbf = Math.max(1.0, 0.6 * this.kzi.bw);
        this.lax = true;
        d4 = this.kys.get() * 0.5;
        d3 = Math.hypot(tbp.wrap(this.kzi.yaw - (double)clientPlayerEntity.getYaw()), this.kzi.pitch - (double)clientPlayerEntity.getPitch());
        d2 = 1.0 - kyn.lci(d4 * 0.75, d4 * 1.2, d3);
        double d8 = 0.5 * (Math.sin(Math.PI * 2 * this.lai * d5 + this.lak) + Math.sin(Math.PI * 2 * this.laj * d5 + this.lal));
        double d9 = kyn.lcj(1.0 + this.kyp.get() * (this.lah + 0.6 * d8), 0.2, 2.0);
        double d10 = this.kyv.get() ? 1.0 - kyn.lci(0.45, 0.8, (double)(System.currentTimeMillis() - this.lab) / 1000.0) : 1.0;
        this.lbg = kyn.lci(0.0, 1.0, this.lae) * d9 * d2 * d10;
        this.kzh.pull = 0.1 * this.kyo.get();
        this.kzh.slow = this.kyq.get();
        this.kzh.vertical = this.kyr.get();
    }

    private void lbr(double d) {
        if (d < this.lat) {
            double d2 = kyn.lci(this.las, this.lat, d);
            this.lam = this.lao + (this.laq - this.lao) * d2;
            this.lan = this.lap + (this.lar - this.lap) * d2;
            return;
        }
        this.lam = this.laq;
        this.lan = this.lar;
        if (d >= this.lau) {
            double[] dArray = this.lbs();
            this.lao = this.lam;
            this.lap = this.lan;
            this.laq = dArray[0];
            this.lar = dArray[1];
            this.las = d;
            this.lat = d + 0.25 + this.kzg.nextDouble() * 0.3;
            this.lau = this.lat + 0.5 + this.kzg.nextDouble() * 0.9;
        }
    }

    private double[] lbs() {
        double d = kyn.lcj(this.kzg.nextGaussian() * 0.18, -0.35, 0.35);
        double d2 = 0.55 + this.kzg.nextDouble() * 0.3;
        return new double[]{d, d2};
    }

    private LivingEntity lbt(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        double d = this.kyt.get();
        double d2 = this.kys.get() * 0.5;
        if (this.kzz != null && this.lbu(clientPlayerEntity, this.kzz) && kyn.lbv(vec3d, (Entity)this.kzz, d) && kyn.lbw(clientPlayerEntity, vec3d, (Entity)this.kzz) <= d2 * 1.2) {
            return this.kzz;
        }
        LivingEntity livingEntity = null;
        double d3 = Double.MAX_VALUE;
        for (Entity entity : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(d + 1.0))) {
            double d4;
            LivingEntity livingEntity2;
            if (!(entity instanceof LivingEntity) || !this.lbu(clientPlayerEntity, livingEntity2 = (LivingEntity)entity) || !kyn.lbv(vec3d, (Entity)livingEntity2, d) || !((d4 = kyn.lbw(clientPlayerEntity, vec3d, (Entity)livingEntity2)) <= d2) || !(d4 < d3)) continue;
            d3 = d4;
            livingEntity = livingEntity2;
        }
        return livingEntity;
    }

    private boolean lbu(ClientPlayerEntity clientPlayerEntity, LivingEntity livingEntity) {
        if (livingEntity == clientPlayerEntity || livingEntity.isRemoved() || !livingEntity.isAlive() || !livingEntity.isAttackable() || livingEntity instanceof ArmorStandEntity) {
            return false;
        }
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)livingEntity;
            if (!this.kyw.get() || playerEntity.isSpectator() || hhf.protects((Entity)playerEntity)) {
                return false;
            }
        } else if (!this.kyx.get() || !(livingEntity instanceof Monster)) {
            return false;
        }
        return this.kyy.get() || clientPlayerEntity.canSee((Entity)livingEntity);
    }

    private static boolean lbv(Vec3d vec3d, Entity entity, double d) {
        return entity.getBoundingBox().squaredMagnitude(vec3d) <= d * d;
    }

    private static double lbw(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Entity entity) {
        Vec3d vec3d2 = entity.getBoundingBox().getCenter();
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.z - vec3d.z;
        double d3 = tbp.yawTo(d, d2);
        double d4 = tbp.pitchTo(vec3d2.y - vec3d.y, Math.sqrt(d * d + d2 * d2));
        return Math.hypot(tbp.wrap(d3 - (double)clientPlayerEntity.getYaw()), d4 - (double)clientPlayerEntity.getPitch());
    }

    private void lbx(MinecraftClient minecraftClient) {
        boolean bl;
        boolean bl2 = bl = minecraftClient.options.attackKey.isPressed() || minecraftClient.currentScreen == null && minecraftClient.getWindow() != null && GLFW.glfwGetMouseButton((long)minecraftClient.getWindow().getHandle(), (int)0) == 1;
        if (bl) {
            this.lab = System.currentTimeMillis();
        }
    }

    private boolean lby(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (minecraftClient.currentScreen != null || !minecraftClient.isWindowFocused() || !minecraftClient.mouse.isCursorLocked() || !clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator() || clientPlayerEntity.isUsingItem()) {
            return false;
        }
        if (!minecraftClient.options.getPerspective().isFirstPerson() || minecraftClient.options.smoothCameraEnabled) {
            return false;
        }
        if (minecraftClient.interactionManager != null && minecraftClient.interactionManager.isBreakingBlock()) {
            return false;
        }
        if (ovh.active() || kmy.busy() || nfl.busy() || tcz.mode() == tcw.RECORD || lqq.busy()) {
            return false;
        }
        return this.lbz(clientPlayerEntity.getMainHandStack());
    }

    /*
     * Exception decompiling
     */
    private boolean lbz(ItemStack var1_1) {
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

    private static lck lca() {
        Flow flow = Flow.getInstance();
        return flow == null || flow.getModuleManager() == null ? null : flow.getModuleManager().get(lck.class);
    }

    private void lcb(long l) {
        if (kzd == null || kze == null || kzf == null) {
            kzd = vxr.find(Mouse.class, a.b("\udc61\ua5db\u2f19\ub132\u3aa6\ubc13\u0647\u8fbd\u11e4\u9b44\u1c84\ue6f2\u6837\uf1dc\u7bc2\ufd3c\u477e\uc8bd\u520e\ud473\u5de8\u27bb\ua90b", -408888296), a.d("\u9c77\ue5c9\u6f16\uf16e\u7ab1\ufc3b\u4606\ucff1\u51a1\udb11", -810158300, 1663658815), a.b("\udc48", 1025170445));
            kze = vxr.find(Mouse.class, a.c(678554466, "\ueb1b\u92a1\u1863\u8648\u0ddc\u8b69\u313d\ub8c7\u269e\uac3e\u2bfe\ud188\u5f4d\uc6a6\u4cb8\uca46\u7004\uffc7\u6574\ue309\u6a92\u10c1\u9e71"), a.b("\ubdee\uc450\u4e8f\ud0f7\u5b28\udda2\u679f\uee68\u7038\ufa86", 208256386), a.c(1789913297, "\ue894"));
            kzf = vxr.find(Mouse.class, a.b("\u72da\u0b60\u81a2\u1f89\u941d\u12a8\ua8fc\u2106\ubf5f\u35ff\ub23f\u4849\uc68c\u5f67\ud579\u5387\ue9c5\u6606\ufcb5\u7ac8\uf353\u8900\u07b0", 597258915), a.d("\uc25e\ubbe0\u313f\uaf47\u2498\ua212\u182a\u91d8\u0f88\u8535\u02e0", -1854674423, -156686278), a.b("\u4009", -1410580404));
        }
        if (kzd == null || kze == null || kzf == null) {
            return;
        }
        this.kzs = 0.0;
        this.kzr = 0.0;
        this.kzq = 0.0;
        this.kzp = 0.0;
        this.kzt = Double.NaN;
        this.kzu = Double.NaN;
        this.kzy = 0.0;
        this.kzx = 0.0;
        this.kzw = 0.0;
        this.kzv = 0.0;
        this.kzh.reset();
        if (this.kzn == null) {
            this.kzl = l;
            this.kzn = GLFWCursorPosCallback.create(this::lcd);
            this.kzm = GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)this.kzn);
        }
        this.kzo = true;
    }

    private void lcc() {
        this.kzo = false;
        if (this.kzn == null) {
            return;
        }
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)this.kzl, (GLFWCursorPosCallbackI)this.kzm);
        if (gLFWCursorPosCallback != null && gLFWCursorPosCallback.address() == this.kzn.address()) {
            this.kzn.free();
            this.kzn = null;
            this.kzm = null;
        } else {
            GLFW.glfwSetCursorPosCallback((long)this.kzl, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        }
    }

    private void lcd(long l, double d, double d2) {
        if (this.kzm != null) {
            this.kzm.invoke(l, d, d2);
        }
        if (this.kzo) {
            MinecraftClient.getInstance().execute(this::lce);
        }
    }

    private void lce() {
        if (!this.kzo || kzd == null) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        try {
            double d = kzd.getDouble(minecraftClient.mouse);
            double d2 = kze.getDouble(minecraftClient.mouse);
            double d3 = kzf.getDouble(minecraftClient.mouse);
            if (d3 != this.kzt) {
                double d4 = Double.isNaN(this.kzu) ? 1.0 : d3 - this.kzu;
                this.kzh.frame(d4);
                boolean bl = d4 < 0.25;
                this.kzv = bl ? this.kzx : 0.0;
                this.kzw = bl ? this.kzy : 0.0;
                this.kzy = 0.0;
                this.kzx = 0.0;
                this.kzt = d3;
                this.kzu = d3;
                this.kzp = d;
                this.kzq = d2;
            } else {
                this.kzp += d - this.kzr;
                this.kzq += d2 - this.kzs;
            }
            this.lcf(minecraftClient);
            this.kzr = this.kzp + this.kzk[0];
            this.kzs = this.kzq + this.kzk[1];
            kzd.setDouble(minecraftClient.mouse, this.kzr);
            kze.setDouble(minecraftClient.mouse, this.kzs);
        }
        catch (IllegalAccessException illegalAccessException) {
            kzd = null;
            this.kzo = false;
        }
    }

    private void lcf(MinecraftClient minecraftClient) {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || this.kzp == 0.0 && this.kzq == 0.0) {
            this.kzk[1] = 0.0;
            this.kzk[0] = 0.0;
            return;
        }
        double d = kyn.lch(minecraftClient, clientPlayerEntity);
        double d2 = (Boolean)minecraftClient.options.getInvertMouseX().getValue() != false ? -1.0 : 1.0;
        double d3 = (Boolean)minecraftClient.options.getInvertMouseY().getValue() != false ? -1.0 : 1.0;
        double d4 = this.kzp * d * d2;
        double d5 = this.kzq * d * d3;
        boolean bl2 = bl = this.isEnabled() && this.lax && this.lbg > 0.0 && minecraftClient.currentScreen == null && minecraftClient.mouse.isCursorLocked() && !minecraftClient.options.smoothCameraEnabled;
        if (!bl) {
            this.kzh.extra(d4, d5, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, this.kzk);
            this.kzy = 0.0;
            this.kzx = 0.0;
            this.kzk[1] = 0.0;
            this.kzk[0] = 0.0;
            return;
        }
        double d6 = kyn.lcj((double)(System.nanoTime() - this.lay) / 1.0E9, 0.0, 0.05);
        double d7 = this.laz + this.lbk * d6;
        double d8 = this.lba + this.lbl * d6;
        double d9 = tbp.wrap(d7 - (double)clientPlayerEntity.getYaw());
        double d10 = d8 - (double)clientPlayerEntity.getPitch();
        double d11 = kyn.lcg(d9 + this.lbb * this.lag, d9 + this.lbc * this.lag);
        double d12 = kyn.lcg(d10 + this.lbd * this.lag, d10 + this.lbe * this.lag);
        this.kzh.extra(d4, d5, d11, d12, this.lbk * this.law, this.lbl * this.law, this.lbf, this.lbg, this.kzk);
        double d13 = this.kzk[0] / d * d2 + this.kzv;
        double d14 = this.kzk[1] / d * d3 + this.kzw;
        double d15 = Math.rint(d13);
        double d16 = Math.rint(d14);
        this.kzx = d13 - d15;
        this.kzy = d14 - d16;
        this.kzk[0] = d15;
        this.kzk[1] = d16;
    }

    private static double lcg(double d, double d2) {
        return d > 0.0 ? d : (d2 < 0.0 ? d2 : 0.0);
    }

    private static double lch(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = (Double)minecraftClient.options.getMouseSensitivity().getValue() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = minecraftClient.options.getPerspective().isFirstPerson() && clientPlayerEntity.isUsingSpyglass();
        return (bl ? d2 : d2 * 8.0) * 0.15;
    }

    private static double lci(double d, double d2, double d3) {
        double d4 = kyn.lcj((d3 - d) / (d2 - d), 0.0, 1.0);
        return d4 * d4 * (3.0 - 2.0 * d4);
    }

    private static double lcj(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private static /* synthetic */ int avp(int n, int n2) {
        return n * n2 | 0x731EFBBC;
    }

    private static /* synthetic */ int avq(int n, int n2) {
        return kyn.avp(n, n2) * n2;
    }
}

