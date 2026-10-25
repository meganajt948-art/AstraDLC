/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.Monster
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.MaceItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.hhf;
import a.ign;
import a.kfa;
import a.kfe;
import a.lfa;
import a.tck;
import a.tcw;
import a.tcz;
import a.tel;
import a.tiq;
import a.tkx;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vmu;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class ldr
extends kfe {
    private static ldr lds;
    private static tiq ldt;
    private static String ldu;
    private final vkw ldv = this.add(new vkw(a.d("\uf769\u8eff\u042d\u9a4d\u1197\u9720", 780206722, -2098661954), new vkq(a.d("\u73a7\u0a29\u80ef\u1e95\u950c\u13ee\ua9ba\u204a\ube04\u34b8\ub36d", 2017663258, 490367737), vhz.LAYERS, ign::open)));
    private final vmu ldw = this.add(new vmu(a.b("\u8bf0\uf263\u78ad\ue6d5\u6d0d\uebb9\u51e3", -533623897), "", 32));
    private final vmc ldx = this.add(new vmc(a.b("\uc702\ube90\u3456\uaa27\u21f1", 981649236), 1.0, 0.3, 1.6, 0.05).percent());
    private final vmc ldy = this.add(new vmc(a.d("\u066f\u7fef\uf521\u6b5c\ue08a\u663c\udc78", -2139191000, 1589350164), 1.0, 0.0, 1.5, 0.05).percent());
    private final vmc ldz = this.add(new vmc(a.c(-307741767, "\u3be7\u4265\uc8a1\u56d6\udd1c\u5ba7\ue1f6\u680a"), 1.0, 0.0, 1.0, 0.05).percent());
    private final vmc lea = this.add(new vmc(a.d("\u7087\u093f\u83f5", 1505155032, 2141366042), 120.0, 20.0, 360.0, 5.0).unit(a.d("\u55a6", -1903928790, 915476285)));
    private final vmc leb = this.add(new vmc(a.b("\u3e48\u47d4\ucd1d\u536b\ud8a9\u5e17\ue449\u6dbe", -170836476), 5.0, 3.0, 8.0, 0.1).suffix(a.b("\u4d0c", 1134710112)));
    private final vmc lec = this.add(new vmc(a.b("\u7a17\u0391\u8946\u1735\u9cf5\u1a59\ua00c\u29fc", 318601805), 120.0, 0.0, 300.0, 10.0).suffix(a.d("\u3ec9\u4766", 1028598471, 92476513)));
    private final vlv led = this.add(new vlv(a.c(-1569348712, "\ua3d3\uda40\u5084\ucee8\u4520\uc386\u79c0\uf02c\u6e75\ue4c5"), a.d("\ua4be\udd22\u57ea\uc98d\u4242\uc4f9", 539739820, 435511893), a.d("\ue3e5\u9a79\u10b1\u8ed6\u0519\u83a2", -792449264, -649474894), a.b("\ufcac\u853c\u0fa1\u9191\u1a53\u9ce2\u26a4\uaf57\u3100", 849673450), a.c(-92398713, "\u1bce\u625e\ue8c3\u76f9\ufd20\u7b8d")));
    private final vlq lee = this.add(new vlq(a.d("\u282e\u51b7\udb60\u455c\ucec0\u487f\uf230", 193216056, 1876301392)));
    private final vlv lef = this.add(new vlv(a.c(-215736653, "\u1eff\u6773\uedb1\u73c8\uf801"), a.c(-694124604, "\u7f94\u0617\u8cc0\u12a0\u9968\u1fd8\ua596"), a.d("\u255a\u5cd9\ud60e\u486e\uc3a6\u4516\uff58", 1115285953, -940651317), a.c(2124927995, "\ud3b9\uaa27\u20e3")));
    private final vkl leg = this.add(new vkl(a.d("\ub0a8\uc925\u43fb\udd92\u5659\ud0ff\u6aad", 1845338409, 1088360918), true));
    private final vkl leh = this.add(new vkl(a.c(1497455759, "\u5cc6\u2555\uaf8b\u31eb"), false));
    private final vkl lei = this.add(new vkl(a.c(1220612220, "\u1025\u69a8\ue361\u7d0d\uf6c0\u7063\uca3f\u4386\udd8e\u5729\ud0f7\u2a86\ua44e"), false));
    private final vkl lej = this.add(new vkl(a.d("\udc7f\ua5fe\u2f21\ub159\u3a86\ubc73\u0674\u8f9e\u118e\u9b72\u1ca3\ue6c8\u6819\uf1be", 709825337, -1890922735), true));
    private final vlq lek = this.add(new vlq(a.d("\u35dc\u4c4a\uc682\u58ec\ud36b\u5589\uefdd\u6639\uf869\u72d2\uf516", 1195546156, 893625256), 269));
    private final tel lel = new tel();
    private long lem;
    private long len;
    private static /* synthetic */ int leo;
    private static /* synthetic */ String lep;

    public ldr() {
        super(a.b("\u759f\u0c05\u86c6\u18b0\u937a\u15e5\uaf9e\u266b", 1400796633), a.d("\u7941\u00d8\u8a0f\u1433\u9fb0\u1907\ua347\u2abe\ub4e6\u3e5c\ub98e\u43bb\ucd23\u5493\ude8e\u5826\ue27f\u6db4\uf700\u7103\uf8bb\u82f2\u0c58\u97c7\u11ea\u9b26\u228e\uacca\u3628\ub064\u3bd1\uc501", 1740756178, -380981774), kfa.COMBAT);
        lds = this;
        this.ldw.visibleWhen(() -> false);
        this.lee.visibleWhen(() -> this.led.is(a.c(1466834132, "\u1c9d\u650d\uef90\u71aa\ufa73\u7cde")));
    }

    public static ldr get() {
        return lds;
    }

    public static tiq activeProfile() {
        return lfa.activeProfile();
    }

    public static void activate(tiq tiq2) {
        lfa.activate(tiq2);
        if (lds != null) {
            ldr.lds.len = 0L;
        }
    }

    public int stopKey() {
        return this.lek.get();
    }

    public boolean aiming() {
        return this.isEnabled() && this.lel.aiming();
    }

    public Entity target() {
        return this.lel.target();
    }

    @Override
    protected void onDisable() {
        this.lel.reset();
        this.lel.forgetFrame();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        tiq tiq2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.len > 1000L) {
            this.len = l;
            tiq2 = ldr.activeProfile();
            tck tck2 = tiq2 == null ? null : tiq2.model();
            this.lel.use(tck2);
        }
        this.leq(minecraftClient);
        this.lel.tune(this.ldx.get(), this.ldy.get(), this.ldz.get());
        tiq2 = this.ler(minecraftClient, clientPlayerEntity) ? this.let(minecraftClient, clientPlayerEntity) : null;
        int n = (int)Math.round(this.lec.get() / 50.0);
        this.lel.tick(minecraftClient, clientPlayerEntity, (Entity)tiq2, n, this.lej.get());
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.currentScreen != null || !minecraftClient.mouse.isCursorLocked()) {
            this.lel.forgetFrame();
            return;
        }
        this.lel.frame(minecraftClient, clientPlayerEntity);
    }

    private void leq(MinecraftClient minecraftClient) {
        if (minecraftClient.options.attackKey.isPressed() || minecraftClient.currentScreen == null && minecraftClient.getWindow() != null && GLFW.glfwGetMouseButton((long)minecraftClient.getWindow().getHandle(), (int)0) == 1) {
            this.lem = System.currentTimeMillis();
        }
    }

    /*
     * Exception decompiling
     */
    private boolean ler(MinecraftClient var1_1, ClientPlayerEntity var2_2) {
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

    private boolean les(ItemStack itemStack) {
        if (this.lef.is(a.d("\u680b\u1195\u9b51", -650041140, -1607712635))) {
            return true;
        }
        return itemStack.isIn(ItemTags.SWORDS) || itemStack.isIn(ItemTags.AXES) || itemStack.getItem() instanceof MaceItem || itemStack.getItem() instanceof TridentItem;
    }

    private Entity let(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        double d = this.leb.get();
        double d2 = this.lea.get() * 0.5;
        Entity entity2 = this.lel.target();
        if (entity2 != null && this.leu(clientPlayerEntity, entity2) && ldr.lev(vec3d, entity2, d) && ldr.lew(clientPlayerEntity, vec3d, entity2) <= Math.min(180.0, d2 * 1.25)) {
            return entity2;
        }
        Entity entity3 = null;
        double d3 = Double.MAX_VALUE;
        for (Entity entity4 : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(d + 1.0), entity -> this.leu(clientPlayerEntity, (Entity)entity))) {
            double d4;
            if (!ldr.lev(vec3d, entity4, d) || (d4 = ldr.lew(clientPlayerEntity, vec3d, entity4)) > d2 || !(d4 < d3)) continue;
            d3 = d4;
            entity3 = entity4;
        }
        return entity3;
    }

    private boolean leu(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        LivingEntity livingEntity;
        if (!(entity != clientPlayerEntity && entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).isAlive() && entity.isAttackable())) {
            return false;
        }
        if (entity instanceof tkx) {
            return tcz.mode() == tcw.TEST;
        }
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)entity;
            if (!this.leg.get() || playerEntity.isSpectator() || hhf.protects((Entity)playerEntity)) {
                return false;
            }
        } else if (!this.leh.get() || !(entity instanceof Monster)) {
            return false;
        }
        return this.lei.get() || clientPlayerEntity.canSee(entity);
    }

    private static boolean lev(Vec3d vec3d, Entity entity, double d) {
        return entity.getBoundingBox().squaredMagnitude(vec3d) <= d * d;
    }

    private static double lew(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Entity entity) {
        Vec3d vec3d2 = entity.getBoundingBox().getCenter();
        double d = Math.toDegrees(Math.atan2(vec3d2.z - vec3d.z, vec3d2.x - vec3d.x)) - 90.0;
        double d2 = -Math.toDegrees(Math.atan2(vec3d2.y - vec3d.y, Math.hypot(vec3d2.x - vec3d.x, vec3d2.z - vec3d.z)));
        double d3 = MathHelper.wrapDegrees((double)(d - (double)clientPlayerEntity.getYaw()));
        double d4 = d2 - (double)clientPlayerEntity.getPitch();
        return Math.sqrt(d3 * d3 + d4 * d4 * 0.25);
    }

    static {
        ldu = "";
    }

    private static /* synthetic */ int avw(int n, int n2) {
        return n + n2 | 0xCD9369D1;
    }

    private static /* synthetic */ int avx(int n, int n2) {
        return ldr.avw(n, n2) + n;
    }
}

