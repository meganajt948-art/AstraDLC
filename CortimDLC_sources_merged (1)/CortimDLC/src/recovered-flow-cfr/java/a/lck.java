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
 *  net.minecraft.entity.player.PlayerEntity
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
import a.ovh;
import a.tcw;
import a.tcz;
import a.vkl;
import a.vmc;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class lck
extends kfe {
    private final vmc lcl = this.add(new vmc(a.b("\u7749\u0ac2\u8477\u1a75\u91ac\u171e", 1635808085), 1.5, 1.0, 3.0, 0.05).suffix(a.d("\u3103", 1651795651, 419387321)));
    private final vmc lcm = this.add(new vmc(a.b("\u3ec7\u472a\uc99b\u538c\ud828\u5e97\ue4c7", -2028520738), 0.5, 0.0, 1.0, 0.05).suffix(a.c(398505387, "\ub5d2")));
    private final vmc lcn = this.add(new vmc(a.d("\u6b11\u1281\u982c\u0623\u8df9", -1892789012, -558351385), 50.0, 5.0, 200.0, 1.0));
    private final vmc lco = this.add(new vmc(a.b("\u5102\u289f\ua235\u3c47\ub7e2\u315e\u8b76\u02f9\u9cd1", 1021072671), 3.5, 2.0, 6.0, 0.1).suffix(a.c(-486064284, "\u3f08")));
    private final vmc lcp = this.add(new vmc(a.d("\u0ec3\u777b\ufdb1", 1245922544, -2075243914), 360.0, 10.0, 360.0, 5.0).unit(a.b("\u6679", 926967496)));
    private final vkl lcq = this.add(new vkl(a.b("\u62ef\u1b75\u91d5\u0fda\u8409\u02ba", -776902927), true));
    private final vkl lcr = this.add(new vkl(a.d("\u8ce6\uf575\u7fa9\ue1a2", -436942022, -609532988), true));
    private final vkl lcs = this.add(new vkl(a.c(-933448196, "\ub1d1\uc87b\u42a0\udcdd\u5703\ud1c9\u6ff6\ue266\u7c3a\uf6fc\u7127\u8b20"), true));
    private static Field lct;
    private static Field lcu;
    private LivingEntity lcv;
    private long lcw;
    private GLFWCursorPosCallback lcx;
    private GLFWCursorPosCallback lcy;
    private double lcz;
    private double lda;
    private double ldb = Double.NaN;
    private double ldc;
    private double ldd;
    private static /* synthetic */ String lde;
    private static /* synthetic */ int ldf;

    public lck() {
        super(a.b("\uadbd\ud42e\u5ee7\uc090\u4b51\ucdc4\u77a5\ufe54\u6011\ueaba\u6d6e", -922833413), a.c(1078306845, "\ua80b\ud199\u5b5f\uc52e\u4ef8\uc85e\u725e\ufbfb\u65b8\uef04\u6892\u92ae\u1c7b\u85d0\u0f85\u8962\u3368\ubcec\u265a\ua05b\u29f8\u53b2\udd19\u46de\uc0b2\u4a75\uf3d1\u7dd3\ue770\u613d\uea83\u1417\u9e0c\u07e8\u81a8\u0b0c\ub4d9\u3eb9\ub83e\u21ce\uab9e\ud565\u5f72\ud890\u4258\ucc2a\u75e1\uff54\u7948\ue2d0\u6cbe\u963b\u1fc8\u9992\u0379\u8d31\u36c0\ub050\u3a35\ua3f2\u2d5d\u5755\ud0e0\u5aa5\uc477\u4dc4\uf7da\u7162\ufb28"), kfa.COMBAT);
    }

    @Override
    protected void onDisable() {
        this.ldm();
        this.lcv = null;
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        if (this.lcy == null && minecraftClient.method_22683() != null) {
            this.ldl(minecraftClient.method_22683().method_4490());
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || minecraftClient.field_1687 == null) {
            this.lcv = null;
            return;
        }
        double d = this.lco.get();
        if (this.lcv == null || !this.ldh(clientPlayerEntity, this.lcv) || !lck.ldi(clientPlayerEntity, (Entity)this.lcv, d) || lck.ldj(clientPlayerEntity, (Entity)this.lcv) > this.lcp.get() * 0.5) {
            this.lcv = this.ldg(minecraftClient, clientPlayerEntity, d);
        }
    }

    private LivingEntity ldg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, double d) {
        LivingEntity livingEntity = null;
        double d2 = Double.MAX_VALUE;
        double d3 = this.lcp.get() * 0.5;
        for (Entity entity : minecraftClient.field_1687.method_8335((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d))) {
            double d4;
            LivingEntity livingEntity2;
            if (!(entity instanceof LivingEntity) || !this.ldh(clientPlayerEntity, livingEntity2 = (LivingEntity)entity) || !lck.ldi(clientPlayerEntity, (Entity)livingEntity2, d) || !((d4 = lck.ldj(clientPlayerEntity, (Entity)livingEntity2)) <= d3) || !(d4 < d2)) continue;
            d2 = d4;
            livingEntity = livingEntity2;
        }
        return livingEntity;
    }

    private boolean ldh(ClientPlayerEntity clientPlayerEntity, LivingEntity livingEntity) {
        if (livingEntity == clientPlayerEntity || livingEntity.method_31481() || !livingEntity.method_5805() || livingEntity.method_29504() || livingEntity instanceof ArmorStandEntity) {
            return false;
        }
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)livingEntity;
            if (!this.lcq.get() || playerEntity.method_7325() || hhf.protects((Entity)playerEntity)) {
                return false;
            }
        } else if (!this.lcr.get()) {
            return false;
        }
        return this.lcs.get() || clientPlayerEntity.method_6057((Entity)livingEntity);
    }

    private static boolean ldi(ClientPlayerEntity clientPlayerEntity, Entity entity, double d) {
        return clientPlayerEntity.method_5858(entity) <= d * d;
    }

    private static double ldj(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        return Math.abs(lck.ldk(clientPlayerEntity, entity.method_5829().method_1005()));
    }

    private static double ldk(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d) {
        Vec3d vec3d2 = clientPlayerEntity.method_33571();
        double d = Math.toDegrees(Math.atan2(-(vec3d.field_1352 - vec3d2.field_1352), vec3d.field_1350 - vec3d2.field_1350));
        return MathHelper.method_15338((double)(d - (double)clientPlayerEntity.method_36454()));
    }

    private void ldl(long l) {
        if (lct == null) {
            lct = vxr.find(Mouse.class, a.c(954673734, "\u2a3f\u5385\ud947\u476c\uccf8\u4a4d\uf019\u79e3\ue7ba\u6d1a\ueada\u10ac\u9e69\u0782\u8d9c\u0b62\ub120\u3ee3\ua450\u222d\uabb6\ud1e5\u5f55"), a.d("\u4bf5\u324b\ub894\u26ec\uad33\u2bb9\u9184\u1873\u8623\u0c93", -1271301847, -977718608), a.c(1517652545, "\u8a04"));
            lcu = vxr.find(Mouse.class, a.c(923224073, "\u4870\u31ca\ubb08\u2523\uaeb7\u2802\u9256\u1bac\u85f5\u0f55\u8895\u72e3\ufc26\u65cd\uefd3\u692d\ud36f\u5cac\uc61f\u4062\uc9f9\ub3aa\u3d1a"), a.b("\uec61\u95df\u1f00\u8178\u0aa7\u8c2d\u3615\ubfe7\u21b7\uab0a\u2cdf", 1719593996), a.b("\ub706", -870992061));
        }
        this.lcw = l;
        this.lcz = 0.0;
        this.lda = 0.0;
        this.ldb = Double.NaN;
        this.ldc = 0.0;
        this.ldd = 0.0;
        this.lcy = GLFWCursorPosCallback.create(this::ldn);
        this.lcx = GLFW.glfwSetCursorPosCallback((long)l, (GLFWCursorPosCallbackI)this.lcy);
    }

    private void ldm() {
        if (this.lcy == null) {
            return;
        }
        GLFWCursorPosCallback gLFWCursorPosCallback = GLFW.glfwSetCursorPosCallback((long)this.lcw, (GLFWCursorPosCallbackI)this.lcx);
        if (gLFWCursorPosCallback != null && gLFWCursorPosCallback.address() == this.lcy.address()) {
            this.lcy.free();
        } else {
            GLFW.glfwSetCursorPosCallback((long)this.lcw, (GLFWCursorPosCallbackI)gLFWCursorPosCallback);
        }
        this.lcy = null;
        this.lcx = null;
    }

    private void ldn(long l, double d, double d2) {
        if (this.lcx != null) {
            this.lcx.invoke(l, d, d2);
        }
        if (lct != null && lcu != null) {
            MinecraftClient.method_1551().execute(this::ldo);
        }
    }

    private void ldo() {
        if (this.lcy == null) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        try {
            double d = lct.getDouble(minecraftClient.field_1729);
            double d2 = lcu.getDouble(minecraftClient.field_1729);
            if (d2 != this.ldb) {
                this.ldc = d2 - this.ldb < 0.25 ? this.ldd : 0.0;
                this.ldd = 0.0;
                this.ldb = d2;
                this.lcz = d;
            } else {
                this.lcz += d - this.lda;
            }
            this.lda = this.lcz + this.ldp(minecraftClient, this.lcz);
            lct.setDouble(minecraftClient.field_1729, this.lda);
        }
        catch (IllegalAccessException illegalAccessException) {
            lct = null;
        }
    }

    private double ldp(MinecraftClient minecraftClient, double d) {
        double d2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (d == 0.0 || !this.isEnabled() || clientPlayerEntity == null || this.lcv == null || !this.lcv.method_5805() || !minecraftClient.field_1729.method_1613() || minecraftClient.field_1755 != null || minecraftClient.field_1690.field_1914 || ovh.active() || kmy.busy() || tcz.mode() == tcw.RECORD) {
            this.ldd = 0.0;
            return 0.0;
        }
        double d3 = d * lck.ldq(minecraftClient, clientPlayerEntity);
        if (((Boolean)minecraftClient.field_1690.method_72706().method_41753()).booleanValue()) {
            d3 = -d3;
        }
        double d4 = d3 * (d2 = lck.ldk(clientPlayerEntity, this.lcv.method_5829().method_1005())) > 0.0 ? this.lcl.get() : this.lcm.get();
        double d5 = MathHelper.method_15350((double)(1.0 - Math.abs(d3) / this.lcn.get()), (double)0.0, (double)1.0);
        d4 = MathHelper.method_16436((double)d5, (double)1.0, (double)d4);
        double d6 = d * (d4 - 1.0) + this.ldc;
        double d7 = Math.rint(d6);
        this.ldd = d6 - d7;
        return d7;
    }

    private static double ldq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = (Double)minecraftClient.field_1690.method_42495().method_41753() * (double)0.6f + (double)0.2f;
        double d2 = d * d * d;
        boolean bl = minecraftClient.field_1690.method_31044().method_31034() && clientPlayerEntity.method_31550();
        return bl ? d2 : d2 * 8.0;
    }

    private static /* synthetic */ int avt(int n, int n2) {
        return n ^ n2 ^ 0xC943A990;
    }
}

