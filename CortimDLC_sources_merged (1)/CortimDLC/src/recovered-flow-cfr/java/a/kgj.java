/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.Monster
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.MathHelper
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
import a.lfy;
import a.lqq;
import a.nfl;
import a.ovh;
import a.tbm;
import a.tbp;
import a.tck;
import a.tcw;
import a.tcz;
import a.tel;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vxr;
import a.vyd;
import a.vyk;
import flow.config.ConfigManager;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class kgj
extends kfe {
    private final vkw kgk = this.add(new vkw(a.b("\u62cf\u1b5c\u9198\u0fff\u843e\u029e", -298884455), new vkq(a.d("\ud120\ua883", 65597041, -988594411), vhz.CHECK, this::kit)));
    private final vmc kgl = this.add(new vmc(a.b("\u12cf\u6b5d\ue19b\u7fea\uf43c", -2056514919), 1.0, 0.3, 1.6, 0.05).percent());
    private final vmc kgm = this.add(new vmc(a.b("\u4bd5\u324c\ub89b\u26a7\uad23\u2b8c\u91dd\u182c\u8668\u0cc5", -462533730), 0.5, 0.0, 1.0, 0.05).percent());
    private final vmc kgn = this.add(new vmc(a.d("\u0e39\u77a0\ufd77\u634b\ue8d1\u6e6c\ud426\u5d8f\uc383\u4931\ucef7\u3486\uba50", 598303519, 1257925994), 30.0, 5.0, 90.0, 1.0).suffix(a.d("\ub349\uca67\u40ef", 1326574415, 941512885)));
    private final vmc kgo = this.add(new vmc(a.d("\ud4c3\uad5a\u278d\ub9b1\u3234\ub492\u0ec5\u8736\u197e\u93d2\u1407\uee77", -1461957813, 908173253), 100.0, 0.0, 300.0, 10.0).suffix(a.c(-49848727, "\u5e06\u27a9")));
    private final vkl kgp = this.add(new vkl(a.b("\u5fb6\u262f\uacf8\u32c4\ub94a\u3feb\u85b4\u0c4c\u921b\u18ee\u9f69\u6503\ueb9b\u7267\uf836\u7edd\uc494\u4b53", 1134911461), false));
    private final vkl kgq = this.add(new vkl(a.c(262682685, "\u3869\u41f0\ucb27\u551b\ude83\u5833\ue262\u6b86\uf580\u7f66\uf8aa\u02da\u8c08\u15b0\u9fa6\u191a\ua357\u2c9f\ub633\u3065\ub99b"), false));
    private final vmc kgr = this.add(new vmc(a.b("\u6e8b\u1712\u9dc5\u03f9\u887a\u0ed0\ub49b\u3d7c\ua330\u2997\uae00\u5425\udae7\u4345\uc903\u4ff0\uf5ae", -1750372645), 3.0, 1.0, 3.0, 0.05).suffix(a.d("\u2d42", 321923545, -1607793438)));
    private final vmc kgs = this.add(new vmc(a.d("\u99fe\ue067\u6ab0\uf48c\u7f1a\uf9bd\u43f8\uca11\u5417\udee0\u5927\ua34b\u2d9e\ub462\u3e65\ub881\u02dd\u8d19\u17a8\u91e8", 312764874, -1922830239), 1.0, 0.0, 1.0, 0.05).suffix(a.c(-2110588573, "\uf91a")));
    private final vmc kgt = this.add(new vmc(a.c(1001716339, "\ufa36\u838e\u0944"), 70.0, 10.0, 360.0, 5.0).unit(a.d("\uabf3", -806019792, 996193906)));
    private final vmc kgu = this.add(new vmc(a.c(1610531071, "\uc0b3\ub92f\u33e6\uad90\u2652\ua0ec\u1ab2\u9345"), 4.5, 2.0, 8.0, 0.1).suffix(a.d("\u13ab", -556907735, 1997885678)));
    private final vmc kgv = this.add(new vmc(a.d("\ud391\uaa13\u20d7\ubea0\u356a\ub3d1\u0980\u807c", 2054289274, 1499604149), 1.0, 0.0, 1.0, 0.05).percent());
    private final vlv kgw = this.add(new vlv(a.b("\ud5e4\uac68\u26aa\ub8d3\u331a", 2097141160), a.c(454254467, "\u5fd3\u2650\uac87\u32e7\ub92f\u3f9f\u85d1"), a.c(-1177600455, "\u3e69\u47ea\ucd3d\u535d\ud895\u5e25\ue46b"), a.d("\u3aab\u433e\uc9f5\u5799\udc58\u5afe", -933711957, 891065685), a.d("\u81ef\uf867\u72a9\uecce", 623172715, -1233363519), a.c(-1714421323, "\u01f7\u7869\uf2ad")));
    private final vlv kgx = this.add(new vlv(a.b("\uc9e5\ub076\u3abe\ua4c9\u2f03\ua9a9\u13e7\u9a1b", 1231669693), a.c(760418819, "\u1247\u6bd9\ue103\u7f79\uf4a7"), a.c(103727010, "\ubfe6\uc678\u4ca2\ud2d8\u5906"), a.c(-363289967, "\ua2dd\udb41\u5188\ucffe\u443c\uc282\u78dc\uf12b"), a.c(1998113016, "\uc8b6\ub12a\u3bfd\ua581\u2e4e\ua8e3")));
    private final vkl kgy = this.add(new vkl(a.c(150882620, "\u4975\u30eb\uba3d\u2446\uaf99\u2963\u937f\u1a8f\u84d2\u0e76"), false));
    private final vkl kgz = this.add(new vkl(a.d("\u7aa8\u0325\u89fb\u1792\u9c59\u1aff\ua0ad", 1686979734, -161399191), true));
    private final vkl kha = this.add(new vkl(a.d("\u3e29\u47ba\ucd64\u5304", 1229063014, 1845116166), false));
    private final vkl khb = this.add(new vkl(a.c(-508081671, "\u49a0\u302d\ubae4\u2488\uaf45\u29e6\u93ba\u1a03\u840b\u0eac\u8972\u7303\ufdcb"), false));
    private final lfy khc = new lfy();
    private static final double khd = 1.2;
    private static final double khe = 1.5;
    private static final int khf = 12;
    private static final long khg = 1200L;
    private static final long khh = 650L;
    private static final double khi = 1.0;
    private static final double khj = 0.8;
    private static final long khk = 180L;
    private static final double khl = 1.5;
    private static final double khm = 8.0;
    private static final double khn = 350.0;
    private static final double kho = 1000.0;
    private static final double khp = 0.25;
    private static Field khq;
    private static Field khr;
    private static Field khs;
    private final tel kht;
    private final tbm khu;
    private final double[] khv;
    private long khw;
    private Entity khx;
    private long khy;
    private GLFWCursorPosCallback khz;
    private GLFWCursorPosCallback kia;
    private boolean kib;
    private double kic;
    private double kid;
    private double kie;
    private double kif;
    private double kig;
    private long kih;
    private double kii;
    private double kij;
    private double kik;
    private double kil;
    private double kim;
    private volatile long kin;
    private Entity kio;
    private long kip;
    private int kiq;
    private static /* synthetic */ int kir;
    private static /* synthetic */ String kis;

    public kgj() {
        super(a.c(295261415, "\u54af\u2d36\ua7e1\u39bc\ub259\u34e8\u8ea1\u074a\u9912"), a.b("\u1e5f\u67d0\ued01\u7370\uf8bc\u7e11\uc40a\u4dba\ud3ed\u5958\udec6\u24ff\uaa25\u339d\ub9d2\u3f73\u856b\u0aa4\u900a\u1647\u9ff8\ue5e8\u6b1a\uf09c\u76f1\ufc24\u4586\ucbc8\u513e", 1288707601), kfa.COMBAT);
        this.add(this.khc.naked);
        this.add(this.khc.invisible);
        this.add(this.khc.armored);
        this.kht = new tel();
        this.khu = new tbm();
        this.khv = new double[2];
        this.kig = Double.NaN;
        this.kii = 0.016666666666666666;
        for (vmo vmo2 : new vmo[]{this.kgm, this.kgn, this.kgo, this.kgp, this.kgq, this.kgr, this.kgs}) {
            vmo2.visibleWhen(() -> false);
        }
    }

    private void kit() {
        this.kgl.set(0.9);
        this.kgt.set(360.0);
        this.kgu.set(4.5);
        this.kgv.set(0.55);
        ConfigManager.autoSaveLater();
    }

    public Entity pilotTarget() {
        return this.isEnabled() ? this.kht.target() : null;
    }

    @Override
    protected void onDisable() {
        this.kht.reset();
        this.kht.forgetFrame();
        this.kjf();
        this.khx = null;
        this.kih = 0L;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null) {
            this.khx = null;
            return;
        }
        this.kht.use(tck.profileOld());
        this.kjb(minecraftClient);
        this.kht.tune(this.kgl.get(), 1.0 * (1.0 - 0.8 * this.kgm.get()), this.kgv.get());
        this.kht.newTick();
        this.kht.cap(this.kgn.get());
        Entity entity = this.kjc(minecraftClient, clientPlayerEntity) ? this.kiu(minecraftClient, clientPlayerEntity) : null;
        long l = System.currentTimeMillis();
        if (entity != null && this.kgq.get() && l - this.kin > 180L) {
            entity = null;
        }
        int n = (int)Math.round(this.kgo.get() / 50.0);
        if (entity != null && entity == this.kio && l - this.kip < 1200L) {
            n = 0;
        }
        if (entity != null) {
            this.kio = entity;
            this.kip = l;
        }
        this.kht.tick(minecraftClient, clientPlayerEntity, entity, n, this.kgp.get());
        this.khx = entity;
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        if (!(this.kia != null && this.kib || minecraftClient.method_22683() == null)) {
            this.kje(minecraftClient.method_22683().method_4490());
        }
        long l = System.nanoTime();
        if (this.kih != 0L) {
            this.kii += (Math.min(0.1, (double)(l - this.kih) / 1.0E9) - this.kii) * 0.2;
        }
        this.kih = l;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || minecraftClient.field_1755 != null || !minecraftClient.field_1729.method_1613()) {
            this.kht.forgetFrame();
            return;
        }
        this.kht.frame(minecraftClient, clientPlayerEntity);
    }

    /*
     * Exception decompiling
     */
    private Entity kiu(MinecraftClient var1_1, ClientPlayerEntity var2_2) {
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

    private boolean kiv(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Entity entity, double d, double d2) {
        if (entity.method_31481() || !this.kix(clientPlayerEntity, entity, false) || !kgj.kiz(vec3d, entity, d + 1.5) || kgj.kja(clientPlayerEntity, vec3d, entity) > d2 * 1.2) {
            return false;
        }
        if (this.khb.get() || clientPlayerEntity.method_6057(entity)) {
            this.kiq = 0;
            return true;
        }
        return ++this.kiq <= 12;
    }

    private boolean kiw(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        return this.kix(clientPlayerEntity, entity, true);
    }

    private boolean kix(ClientPlayerEntity clientPlayerEntity, Entity entity, boolean bl) {
        LivingEntity livingEntity;
        if (!(entity != clientPlayerEntity && entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).method_5805() && entity.method_5732())) {
            return false;
        }
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)entity;
            if (!this.kgz.get() || playerEntity.method_7325() || hhf.protects((Entity)playerEntity)) {
                return false;
            }
        } else if (!this.kha.get() || !(entity instanceof Monster)) {
            return false;
        }
        if (!this.khc.allows(entity)) {
            return false;
        }
        return !bl || this.khb.get() || clientPlayerEntity.method_6057(entity);
    }

    private static double kiy(LivingEntity livingEntity) {
        vyd vyd2 = vyk.of(livingEntity);
        return vyd2.unknown() ? 100.0 : (double)vyd2.total();
    }

    private static boolean kiz(Vec3d vec3d, Entity entity, double d) {
        return entity.method_5829().method_49271(vec3d) <= d * d;
    }

    private static double kja(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Entity entity) {
        Vec3d vec3d2 = entity.method_73189();
        double d = Math.toDegrees(Math.atan2(vec3d2.field_1350 - vec3d.field_1350, vec3d2.field_1352 - vec3d.field_1352)) - 90.0;
        return Math.abs(MathHelper.method_15338((double)(d - (double)clientPlayerEntity.method_36454())));
    }

    private void kjb(MinecraftClient minecraftClient) {
        boolean bl;
        boolean bl2 = bl = minecraftClient.field_1690.field_1886.method_1434() || minecraftClient.field_1755 == null && minecraftClient.method_22683() != null && GLFW.glfwGetMouseButton((long)minecraftClient.method_22683().method_4490(), (int)0) == 1;
        if (bl) {
            this.khw = System.currentTimeMillis();
        }
    }

    private boolean kjc(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (minecraftClient.field_1755 != null || !minecraftClient.method_1569() || !minecraftClient.field_1729.method_1613() || !clientPlayerEntity.method_5805() || clientPlayerEntity.method_7325()) {
            return false;
        }
        if (minecraftClient.field_1761 != null && minecraftClient.field_1761.method_2923()) {
            return false;
        }
        if (clientPlayerEntity.method_6115()) {
            return false;
        }
        if (kmy.busy() || tcz.mode() == tcw.RECORD || nfl.busy() || lqq.busy()) {
            return false;
        }
        if (this.kgy.get() && System.currentTimeMillis() - this.khw > 650L) {
            return false;
        }
        return this.kjd(clientPlayerEntity.method_6047());
    }

    /*
     * Exception decompiling
     */
    private boolean kjd(ItemStack var1_1) {
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

    private void kje(long l) {
        if (khq == null || khr == null || khs == null) {
            khq = vxr.find(Mouse.class, a.d("\uc4ef\ubd55\u3797\ua9bc\u2228\ua49d\u1ec9\u9733\u096a\u83ca\u040a\ufe7c\u70b9\ue952\u634c\ue5b2\u5ff0\ud033\u4a80\uccfd\u4566\u3f35\ub185", 2047519207, 312634737), a.c(326382811, "\u34b7\u4d09\uc7d6\u59ae\ud271\u54fb\ueec6\u6731\uf961\u73d1"), a.c(-2056003935, "\udee4"));
            khr = vxr.find(Mouse.class, a.b("\u9fb2\ue608\u6cca\uf2e1\u7975\uffc0\u4594\ucc6e\u5237\ud897\u5f57\ua521\u2be4\ub20f\u3811\ubeef\u04ad\u8b6e\u11dd\u97a0\u1e3b\u6468\uead8", 1817026507), a.d("\u170b\u6eb5\ue46a\u7a12\uf1cd\u7747\ucd7a\u448d\udadd\u5063", 1712520531, 40167988), a.d("\ubb01", 1740035789, -1693880951));
            khs = vxr.find(Mouse.class, a.b("\ud28c\uab36\u21f4\ubfdf\u344b\ub2fe\u08aa\u8150\u1f09\u95a9\u1269\ue81f\u66da\uff31\u752f\uf3d1\u4993\uc650\u5ce3\uda9e\u5305\u2956\ua7e6", -961293579), a.b("\u73f3\u0a4d\u8092\u1eea\u9535\u13bf\ua987\u2075\ube25\u3498\ub34d", -532909154), a.b("\ua6c7", 175548034));
        }
        if (khq == null || khr == null || khs == null) {
            return;
        }
        this.kif = 0.0;
        this.kie = 0.0;
        this.kid = 0.0;
        this.kic = 0.0;
        this.kig = Double.NaN;
        this.kim = 0.0;
        this.kil = 0.0;
        this.kik = 0.0;
        this.kij = 0.0;
        if (this.kia == null) {
            this.khy = l;
            this.kia = GLFWCursorPosCallback.create(this::kjg);
            this.khz = GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)this.kia);
        }
        this.kib = true;
    }

    private void kjf() {
        this.kib = false;
        if (this.kia == null) {
            return;
        }
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)this.khy, (GLFWCursorPosCallbackI)this.khz);
        if (gLFWCursorPosCallback != null && gLFWCursorPosCallback.address() == this.kia.address()) {
            this.kia.free();
            this.kia = null;
            this.khz = null;
        } else {
            GLFW.glfwSetCursorPosCallback((long)this.khy, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        }
    }

    private void kjg(long l, double d, double d2) {
        if (this.khz != null) {
            this.khz.invoke(l, d, d2);
        }
        if (this.kib) {
            MinecraftClient.method_1551().execute(this::kjh);
        }
    }

    private void kjh() {
        if (!this.kib || khq == null) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        try {
            double d = khq.getDouble(minecraftClient.field_1729);
            double d2 = khr.getDouble(minecraftClient.field_1729);
            double d3 = khs.getDouble(minecraftClient.field_1729);
            if (d3 != this.kig) {
                boolean bl = !Double.isNaN(this.kig) && d3 - this.kig < 0.25;
                this.kij = bl ? this.kil : 0.0;
                this.kik = bl ? this.kim : 0.0;
                this.kim = 0.0;
                this.kil = 0.0;
                this.kig = d3;
                this.kic = d;
                this.kid = d2;
            } else {
                this.kic += d - this.kie;
                this.kid += d2 - this.kif;
            }
            if (this.kic != 0.0 || this.kid != 0.0) {
                this.kin = System.currentTimeMillis();
            }
            this.kji(minecraftClient);
            this.kie = this.kic + this.khv[0];
            this.kif = this.kid + this.khv[1];
            khq.setDouble(minecraftClient.field_1729, this.kie);
            khr.setDouble(minecraftClient.field_1729, this.kif);
        }
        catch (IllegalAccessException illegalAccessException) {
            khq = null;
            this.kib = false;
        }
    }

    private void kji(MinecraftClient minecraftClient) {
        this.khv[1] = 0.0;
        this.khv[0] = 0.0;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        Entity entity = this.khx;
        if (this.kic == 0.0 && this.kid == 0.0 || !this.isEnabled() || clientPlayerEntity == null || entity == null || !entity.method_5805() || entity.method_31481() || minecraftClient.field_1755 != null || !minecraftClient.field_1729.method_1613() || minecraftClient.field_1690.field_1914 || !minecraftClient.field_1690.method_31044().method_31034() || ovh.active()) {
            this.kim = 0.0;
            this.kil = 0.0;
            return;
        }
        double d = kgj.kjl(minecraftClient, clientPlayerEntity);
        float f = minecraftClient.method_61966().method_60637(true);
        Vec3d vec3d = clientPlayerEntity.method_5836(f);
        Vec3d vec3d2 = entity.method_30950(f);
        if (d <= 0.0 || !tbp.aim(vec3d.field_1352, vec3d.field_1351, vec3d.field_1350, vec3d2.field_1352, vec3d2.field_1351, vec3d2.field_1350, (double)entity.method_17681() * 0.5, entity.method_17682(), 0.0, 0.5, this.khu)) {
            this.kim = 0.0;
            this.kil = 0.0;
            return;
        }
        double d2 = (Boolean)minecraftClient.field_1690.method_72706().method_41753() != false ? -1.0 : 1.0;
        double d3 = (Boolean)minecraftClient.field_1690.method_42438().method_41753() != false ? -1.0 : 1.0;
        double d4 = this.kic * d * d2;
        double d5 = this.kid * d * d3;
        double d6 = tbp.wrap(this.khu.yaw - (double)clientPlayerEntity.method_36454());
        double d7 = this.khu.pitch - (double)clientPlayerEntity.method_36455();
        double d8 = kgj.kjk(d6 + this.khu.la, d6 + this.khu.ra);
        double d9 = kgj.kjk(d7 + this.khu.ta, d7 + this.khu.ba);
        double d10 = 1.0 - kgj.kjm(1.5, 8.0, Math.hypot(d8, d9));
        double d11 = kgj.kjm(350.0, 1000.0, Math.hypot(d4, d5) / Math.max(0.001, this.kii));
        double d12 = (this.kjj(d4, d8, d6, d10) - d4) * (1.0 - d11);
        double d13 = (this.kjj(d5, d9, d7, d10) - d5) * (1.0 - d11) * this.kgv.get();
        double d14 = d12 / d * d2 + this.kij;
        double d15 = d13 / d * d3 + this.kik;
        this.khv[0] = Math.rint(d14);
        this.khv[1] = Math.rint(d15);
        this.kil = d14 - this.khv[0];
        this.kim = d15 - this.khv[1];
    }

    private double kjj(double d, double d2, double d3, double d4) {
        boolean bl;
        if (d == 0.0) {
            return 0.0;
        }
        boolean bl2 = d2 != 0.0 ? d * d2 > 0.0 : (bl = d * d3 > 0.0);
        if (!bl) {
            return d * MathHelper.method_16436((double)d4, (double)1.0, (double)this.kgs.get());
        }
        if (d2 == 0.0) {
            return d;
        }
        double d5 = d * this.kgr.get();
        double d6 = Math.max(Math.abs(d), Math.abs(d3));
        return Math.abs(d5) > d6 ? Math.copySign(d6, d) : d5;
    }

    private static double kjk(double d, double d2) {
        return d > 0.0 ? d : (d2 < 0.0 ? d2 : 0.0);
    }

    private static double kjl(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = (Double)minecraftClient.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = minecraftClient.field_1690.method_31044().method_31034() && clientPlayerEntity.method_31550();
        return (bl ? d2 : d2 * 8.0) * 0.15;
    }

    private static double kjm(double d, double d2, double d3) {
        double d4 = MathHelper.method_15350((double)((d3 - d) / (d2 - d)), (double)0.0, (double)1.0);
        return d4 * d4 * (3.0 - 2.0 * d4);
    }

    private /* synthetic */ boolean lambda$pickTarget$1(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        return this.kiw(clientPlayerEntity, entity);
    }

    private static /* synthetic */ int ath(int n, int n2) {
        return (n ^ n2) + -855431446;
    }

    private static /* synthetic */ int ati(int n, int n2) {
        return kgj.ath(n, n2) ^ 0x6FA7BA6B;
    }
}

