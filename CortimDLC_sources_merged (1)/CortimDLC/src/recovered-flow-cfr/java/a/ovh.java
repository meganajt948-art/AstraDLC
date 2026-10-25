/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.input.Input
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.option.Perspective
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.item.HeldItemRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import a.kfa;
import a.kfe;
import a.ove;
import a.vmc;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ovh
extends kfe {
    private static ovh ovi;
    private final vmc ovj = this.add(new vmc(a.b("\u420c\u3b9e\ub158\u2f29\ua4ff", -1405140390), 10.0, 1.0, 50.0, 1.0).suffix(a.d("\u6e27\u17db\u9d54", -937067049, 1378358161)));
    private final vmc ovk = this.add(new vmc(a.b("\u93d0\uea5f\u608e\ufeff\u7533\uf39e", 683971461), 0.5, 0.0, 1.0, 0.05).percent());
    private static Field ovl;
    private static Field ovm;
    private static Field ovn;
    private static Field[] ovo;
    private static boolean ovp;
    private ove ovq;
    private Input ovr;
    private Perspective ovs;
    private boolean ovt = true;
    private boolean ovu;
    private float ovv;
    private float ovw;
    private float ovx;
    private float ovy;
    private double ovz;
    private double owa;
    private double owb;
    private long owc;
    private long owd;
    private long owe = -1L;
    private static /* synthetic */ boolean owf;
    private static /* synthetic */ long owg;

    public ovh() {
        super(a.d("\ud13e\ua8bb\u227f\ubc0e\u37ff\ub16c\u0b33", 891867848, -1659108425), a.b("\ua0ee\ud975\u53b3\ucd9b\u4618\uc0b5\u7aeb\uf35f\u6d43\ue7f0\u602f\u9a56\u1496\u8d34\u072a\u81d7\u3bc1\ub406\u2eaf\ua8f9\u215c\u5b5d\ud5f2\u4e2e\uc849\u4284\ufb20\u7523\uef87\u69d1\ue277\u1cbe\u96fb", -27615095), kfa.PLAYER);
        ovi = this;
    }

    public static boolean active() {
        return ovi != null && ovi.isEnabled() && ovh.ovi.ovq != null;
    }

    @Override
    protected void onEnable() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.world == null) {
            this.setEnabled(false);
            return;
        }
        ovh.owm();
        this.ovv = clientPlayerEntity.getYaw();
        this.ovw = clientPlayerEntity.getPitch();
        this.ovx = this.ovv;
        this.ovy = this.ovw;
        this.owb = 0.0;
        this.owa = 0.0;
        this.ovz = 0.0;
        this.owc = 0L;
        Vec3d vec3d = clientPlayerEntity.getCameraPosVec(1.0f);
        this.ovq = new ove(this, (World)minecraftClient.world);
        this.ovq.setPosition(vec3d.x, vec3d.y, vec3d.z);
        this.ovq.lastX = vec3d.x;
        this.ovq.lastY = vec3d.y;
        this.ovq.lastZ = vec3d.z;
        this.ovr = clientPlayerEntity.input;
        clientPlayerEntity.input = new Input();
        clientPlayerEntity.setSprinting(false);
        this.ovs = minecraftClient.options.getPerspective();
        minecraftClient.options.setPerspective(Perspective.FIRST_PERSON);
        this.ovt = minecraftClient.chunkCullingEnabled;
        minecraftClient.chunkCullingEnabled = false;
        minecraftClient.setCameraEntity((Entity)this.ovq);
        ovh.own(minecraftClient, 0.0f);
    }

    @Override
    protected void onDisable() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        this.owh(clientPlayerEntity);
        if (this.ovq != null && clientPlayerEntity != null) {
            minecraftClient.setCameraEntity((Entity)clientPlayerEntity);
            if (this.ovr != null) {
                clientPlayerEntity.input = this.ovr;
            }
            clientPlayerEntity.setYaw(this.ovv);
            clientPlayerEntity.setPitch(this.ovw);
            clientPlayerEntity.lastYaw = this.ovv;
            clientPlayerEntity.lastPitch = this.ovw;
            ovh.own(minecraftClient, clientPlayerEntity.getStandingEyeHeight());
        }
        if (this.ovq != null) {
            minecraftClient.chunkCullingEnabled = this.ovt;
        }
        if (this.ovs != null) {
            minecraftClient.options.setPerspective(this.ovs);
        }
        this.ovq = null;
        this.ovr = null;
        this.ovs = null;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (this.ovq == null) {
            return;
        }
        this.owh(minecraftClient.player);
        if (this.ovq.getEntityWorld() != minecraftClient.world || minecraftClient.getCameraEntity() != this.ovq) {
            this.setEnabled(false);
            return;
        }
        ovh.owi(minecraftClient, (Entity)minecraftClient.player);
        for (KeyBinding keyBinding : new KeyBinding[]{minecraftClient.options.attackKey, minecraftClient.options.useKey, minecraftClient.options.pickItemKey, minecraftClient.options.dropKey, minecraftClient.options.swapHandsKey}) {
            while (keyBinding.wasPressed()) {
            }
            keyBinding.setPressed(false);
        }
        if (minecraftClient.player.input != null && minecraftClient.player.input.getClass() != Input.class) {
            this.ovr = minecraftClient.player.input;
            minecraftClient.player.input = new Input();
        }
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        ++this.owd;
        this.owl(minecraftClient);
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.ovq != null && clientPlayerEntity != null && !clientPlayerEntity.noClip) {
            clientPlayerEntity.noClip = true;
            this.ovu = true;
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (this.ovq != null && minecraftClient.getCameraEntity() == minecraftClient.player) {
            ovh.owi(minecraftClient, (Entity)this.ovq);
        }
        this.owl(minecraftClient);
    }

    private void owh(ClientPlayerEntity clientPlayerEntity) {
        if (this.ovu && clientPlayerEntity != null) {
            clientPlayerEntity.noClip = false;
        }
        this.ovu = false;
    }

    private static void owi(MinecraftClient minecraftClient, Entity entity) {
        if (entity == null) {
            return;
        }
        try {
            if (ovn != null) {
                ovn.set(minecraftClient, entity);
                return;
            }
        }
        catch (IllegalAccessException | RuntimeException exception) {
            // empty catch block
        }
        minecraftClient.setCameraEntity(entity);
    }

    private void owj() {
        if (this.owe == this.owd) {
            return;
        }
        this.owe = this.owd;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || this.ovq == null) {
            return;
        }
        this.ovx += clientPlayerEntity.getYaw() - this.ovv;
        this.ovy = MathHelper.clamp((float)(this.ovy + clientPlayerEntity.getPitch() - this.ovw), (float)-90.0f, (float)90.0f);
        clientPlayerEntity.setYaw(this.ovv);
        clientPlayerEntity.setPitch(this.ovw);
        clientPlayerEntity.lastYaw = this.ovv;
        clientPlayerEntity.lastPitch = this.ovw;
        long l = System.nanoTime();
        double d = this.owc == 0L ? 0.0 : Math.min(0.1, (double)(l - this.owc) / 1.0E9);
        this.owc = l;
        double d2 = ovh.owk(minecraftClient.options.forwardKey, minecraftClient.options.backKey);
        double d3 = ovh.owk(minecraftClient.options.leftKey, minecraftClient.options.rightKey);
        double d4 = ovh.owk(minecraftClient.options.jumpKey, minecraftClient.options.sneakKey);
        double d5 = this.ovj.get() * (minecraftClient.options.sprintKey.isPressed() ? 2.5 : 1.0);
        double d6 = Math.toRadians(this.ovx);
        double d7 = Math.sin(d6);
        double d8 = Math.cos(d6);
        double d9 = Math.sqrt(d2 * d2 + d3 * d3);
        double d10 = 0.0;
        double d11 = 0.0;
        if (d9 > 0.0) {
            d10 = (-d7 * (d2 /= d9) + d8 * (d3 /= d9)) * d5;
            d11 = (d8 * d2 + d7 * d3) * d5;
        }
        double d12 = d4 * d5;
        double d13 = this.ovk.get() <= 0.01 ? 1.0 : 1.0 - Math.exp(-d * (4.0 + 26.0 * (1.0 - this.ovk.get())));
        this.ovz += (d10 - this.ovz) * d13;
        this.owa += (d12 - this.owa) * d13;
        this.owb += (d11 - this.owb) * d13;
        double d14 = this.ovq.getX() + this.ovz * d;
        double d15 = this.ovq.getY() + this.owa * d;
        double d16 = this.ovq.getZ() + this.owb * d;
        this.ovq.setPosition(d14, d15, d16);
        this.ovq.lastX = d14;
        this.ovq.lastY = d15;
        this.ovq.lastZ = d16;
    }

    private static double owk(KeyBinding keyBinding, KeyBinding keyBinding2) {
        return (keyBinding.isPressed() ? 1 : 0) - (keyBinding2.isPressed() ? 1 : 0);
    }

    private void owl(MinecraftClient minecraftClient) {
        if (this.ovq == null || ovo == null) {
            return;
        }
        HeldItemRenderer heldItemRenderer = minecraftClient.getEntityRenderDispatcher().getHeldItemRenderer();
        for (Field field : ovo) {
            vxr.setFloat(field, heldItemRenderer, 0.0f);
        }
    }

    private static void owm() {
        if (ovp) {
            return;
        }
        ovp = true;
        ovl = vxr.find(Camera.class, a.b("\uf055\u89ef\u032d\u9d06\u1692\u9027\u2a73\ua389\u3dd0\ub770\u30b0\ucac6\u4403\udde8\u57f6\ud108\u6b4a\ue489\u7e3a\uf847\u71db\u0b8f\u8535\u1ee8", 666103843), a.b("\u83c8\ufa76\u70a9\ueed1\u650e\ue384\u59b9\ud041\u4e11\uc4a5\u4375", 2094171045), a.c(661490767, "\u8c08"));
        ovm = vxr.find(Camera.class, a.d("\uf279\u8bc3\u0101\u9f2a\u14be\u920b\u285f\ua1a5\u3ffc\ub55c\u329c\uc8ea\u462f\udfc4\u55da\ud324\u6966\ue6a5\u7c16\ufa6b\u73f7\u09a3\u8719\u1cc4", 425939087, -1650417024), a.b("\ua86f\ud1d1\u5b0e\uc576\u4ea9\uc823\u721e\ufbe6\u65b6\uef02\u68d1", -1930582014), a.b("\u115e", -1970925287));
        ovn = vxr.find(MinecraftClient.class, a.b("\u5e23\u2799\uad5b\u3370\ub8e4\u3e51\u8405\u0dff\u93a6\u1906\u9ec6\u64b0\uea75\u739e\uf980\u7f7e\uc53c\u4aff\ud04c\u5631\udfaa\ua5f9\u2b4b", 836394586), a.c(922977124, "\u8308\ufab6\u7069\uee11\u65ce\ue344\u5979\ud08e\u4ed7\uc46e"), a.b("\u205c\u59cf\ud317\u4d77\uc6fb\u4008\ufa5f\u73a9\uedfd\u674a\ue088\u1aea\u943a\u0d99\u8791\u012c\ubb6c\u34b0\uae11\u2840\ua19b\udba4\u5514\ucece\u48bf\uc262", -720297974));
        Field[] fieldArray = new Field[]{vxr.find(HeldItemRenderer.class, a.c(-1214325488, "\udd69\ua4d3\u2e11\ub03a\u3bae\ubd1b\u074f\u8eb5\u10ec\u9a4c\u1d8c\ue7fa\u693f\uf0d4\u7aca\ufc34\u4676\uc9b5\u5306\ud57b\u5ce4\u26b7\ua808"), a.c(-1460459750, "\u2776\u5ec8\ud417\u4a6f\uc1b0\u473a\ufd02\u74f7\ueaac\u601a"), a.c(-1165832429, "\ucf54")), vxr.find(HeldItemRenderer.class, a.c(-114415152, "\u29a9\u5013\udad1\u44fa\ucf6e\u49db\uf38f\u7a75\ue42c\u6e8c\ue94c\u133a\u9dff\u0414\u8e0a\u08f4\ub2b6\u3d75\ua7c6\u21bb\ua824\ud277\u5cc8"), a.d("\u44a4\u3d1a\ub7c5\u29bd\ua262\u24e8\u9ed0\u1725\u897f\u03c8", 1331739662, -1702102842), a.c(-1619893418, "\u6311")), vxr.find(HeldItemRenderer.class, a.d("\u70df\u0965\u83a7\u1d8c\u9618\u10ad\uaaf9\u2303\ubd5a\u37fa\ub03a\u4a4c\uc489\u5d62\ud77c\u5182\uebc0\u6403\ufeb0\u78cd\uf152\u8b01\u05be", -101199147, -1763990925), a.c(-1004550912, "\uc56c\ubcd2\u360d\ua875\u23aa\ua520\u1f18\u96ed\u08b7\u8201"), a.b("\ube9e", -1271546151)), vxr.find(HeldItemRenderer.class, a.d("\u85eb\ufc51\u7693\ue8b8\u632c\ue599\u5fcd\ud637\u486e\uc2ce\u450e\ubf78\u31bd\ua856\u2248\ua4b6\u1ef4\u9137\u0b84\u8df9\u0466\u7e35\uf08a", 417296199, -3740971), a.d("\u53c6\u2a78\ua0a7\u3edf\ub500\u338a\u89b2G\u9e1d\u14a8", -1189539635, 1719550823), a.d("\u95c3", -605564791, -63879923))};
        ovo = fieldArray[0] != null && fieldArray[1] != null && fieldArray[2] != null && fieldArray[3] != null ? fieldArray : null;
    }

    private static void own(MinecraftClient minecraftClient, float f) {
        Camera camera = minecraftClient.gameRenderer.getCamera();
        vxr.setFloat(ovl, camera, f);
        vxr.setFloat(ovm, camera, f);
    }

    private static /* synthetic */ int bfj(int n, int n2) {
        return n - n2 + 143632168;
    }
}

