/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.AttackRangeComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 */
package a;

import a.hhf;
import a.kfa;
import a.kfe;
import a.kmy;
import a.ksp;
import a.ktf;
import a.kvz;
import a.lqq;
import a.lxp;
import a.nfl;
import a.nuo;
import a.oxw;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vxr;
import a.wdt;
import a.wee;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttackRangeComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class lgc
extends kfe {
    private final vlv lgd = this.add(new vlv(a.d("\u40e0\u3960\ub3a8\u2dc4\ua614", 448129708, -410670582), a.b("\u2f01\u568e\udc51\u4233\uc9e2", -1905053865), a.d("\ua5d9\udc56\u5689\uc8eb\u433a", 1286650616, 2056396663), a.d("\uc7c0\ube58\u348b", 359545675, 885062855)));
    private final vkl lge = this.add(new vkl(a.c(1364002008, "\u048f\u7d1c\uf7d8\u69a8\ue272\u64c9\ude8d"), true));
    private final vkl lgf = this.add(new vkl(a.c(-1166832502, "\u8cd5\uf547\u7f96\ue1fc\u6a2c\uec87\u5680\udf23\u416b\ucbcc\u4c09\ub669"), true));
    private final vkl lgg = this.add(new vkl(a.c(1878724242, "\u0ed6\u774b\ufd9a\u63ed\ue80c\u6e83\ud4dc\u5d3f\uc37b"), true));
    private final vmc lgh = this.add(new vmc(a.b("\u1289\u6b0f\ue1d8\u7fab\uf46b\u72c7\uc892\u4162", 275845843), 0.0, 0.0, 500.0, 10.0).suffix(a.d("\u2412\u5dbd", 1749851769, -156124668)));
    private final vmc lgi = this.add(new vmc(a.d("\u9f6d\ue6fd\u6c27\uf25b\u7994", -1164547851, -363661351), 0.0, 0.0, 10.0, 1.0).suffix(a.c(770298799, "\ud3de\uaa72\u20ab\ubed2\u351d")));
    private final vmc lgj = this.add(new vmc(a.c(1822894818, "\u2aae\u5332\ud9fb\u478d\ucc4f\u4af1\uf0af\u7958"), 3.0, 2.5, 3.0, 0.05));
    private final vkl lgk = this.add(new vkl(a.c(1691564813, "\u3b5a\u42d7\uc809\u5660\uddab\u5b0d\ue15f"), true));
    private final vkl lgl = this.add(new vkl(a.c(-1694340878, "\u68bb\u1128\u9bf6\u0596"), true));
    private final vkl lgm = this.add(new vkl(a.b("\ufd2b\u84a6\u0e6f\u9003\u1bce\u9d6d\u2731\uae88\u3091\uba34\u3dfc\uc781\u495d\ud0e6\u5aa2", -1106510480), true));
    private static final float lgn = 0.9f;
    private static final double lgo = 1.5;
    private static final int lgp = 2;
    private static final int lgq = 10;
    private static final int lgr = 2;
    private static final int lgs = 14;
    private static final int lgt = 18;
    private static final int lgu = 30;
    private static final int lgv = 4;
    private static final int lgw = 26;
    private static final int lgx = 2;
    private static final int lgy = 7;
    private static final double lgz = 0.16;
    private static final int lha = 10;
    private static final double lhb = 0.6;
    private static final double lhc = 0.766;
    private static final double lhd = 0.1;
    private static final double lhe = 1.5;
    private static final double lhf = 0.1;
    private static final Field lhg = vxr.find(MinecraftClient.class, a.d("\u4962\u30d8\uba1a\u2431\uafa5\u2910\u9344\u1abe\u84e7\u0e47\u8987\u73f1\ufd34\u64df\ueec1\u683f\ud27d\u5dbe\uc70d\u4170\uc8eb\ub2b8\u3c0a", -1598645460, -767897033), a.d("\uc46b\ubdd5\u370a\ua972\u22ad\ua427\u1e1a\u97ed\u09b2\u8305", 1698091193, 1554322622), a.d("\u0c6b", 1127164230, -1823201947));
    private static final Field lhh = vxr.find(LivingEntity.class, a.d("\ue8c5\u917f\u1bbd\u8596\u0e02\u88b7\u32e3\ubb19\u2540\uafe0\u2820\ud256\u5c93\uc578\u4f66\uc998\u73da\ufc19\u66aa\ue0d7\u694e\u131d\u9dad\u0675", 1060335984, -419653181), a.c(292519284, "\u7d18\u04a6\u8e79\u1001\u9bde\u1d54\ua76e\u2e9b\ub0c4\u3a7f"), a.d("\u2af5", -919185265, 1639805490));
    private static final Field lhi = vxr.find(KeyBinding.class, a.d("\u4fcf\u3675\ubcb7\u229c\ua908\u2fbd\u95e9\u1c13\u824a\u08ea\u8f2a\u755c\ufb99\u6272\ue86c\u6e92\ud4d0\u5b13\uc1a0\u47dd\uce46\ub414\u3aa3", 658182611, -1007985051), a.b("\ueaa2\u931c\u19c3\u87bb\u0c64\u8aee\u30d3\ub925\u277a\uadcc", -640881970), a.d("\u1964", 1480884821, 1875549049));
    private static lgc lhj;
    private final wdt lhk = new wdt();
    private final ktf lhl = new ktf();
    private int lhm;
    private int lhn;
    private int lho;
    private int lhp;
    private int lhq = 1;
    private int lhr;
    private int lhs;
    private int lht;
    private boolean lhu;
    private Entity lhv;
    private int lhw = 10;
    private Entity lhx;
    private Vec3d lhy;
    private int lhz = 1000;
    private int lia;
    private boolean lib;
    private boolean lic;
    private boolean lid;
    private int lie;
    private boolean lif = true;
    private boolean lig;
    private int lih;
    private int lii = -1000;
    private boolean lij;
    private int lik = -1000;
    private double lil = 2.0;
    private static /* synthetic */ int lim;
    private static /* synthetic */ boolean lin;

    public lgc() {
        super(a.b("\uc793\ube04\u34cc\uaab3\u2164\ua7d7\u1d93\u9452\u0a20\u808a", 1598736333), a.b("\u7652\u0fc2\u850c\u1b7a\u90fe\u161b\uac54\u25a8\ubbb2\u3157\ub691\u4cf3\uc231\u5b82\ud1c0\u5765\ued7f\u62b5\uf80c\u7e5c\uf7bc\u8dbf\u0355\u9892\u1ef7\u9421\u2dc0\ua3d2\u3934\ubf78\u34d7\uca06\u4052\ud9aa\u5ff1\ud55b", -990480834), kfa.COMBAT);
        lhj = this;
        this.lge.visibleWhen(() -> this.lgd.is(a.b("\ufa4b\u83c4\u091b\u9779\u1ca8", 652671517)));
    }

    static boolean moduleOn() {
        return lhj != null && lhj.isEnabled();
    }

    @Override
    protected void onEnable() {
        if (this.mc.player != null) {
            this.lhl.sync(this.mc.player);
            this.lic = wdt.serverSprinting(this.mc.player);
        }
        this.lia = wee.count();
        this.lhz = 1000;
        this.lib = false;
        this.lid = false;
        this.lie = 0;
        this.lht = 0;
        this.lii = -1000;
        this.lik = -1000;
        this.lhp = lgc.liy();
        this.lhq = lgc.liz();
        this.ljr();
    }

    @Override
    protected void onDisable() {
        this.liu(this.mc);
        this.ljr();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        this.lhl.afterMove(clientPlayerEntity, (World)minecraftClient.world);
        boolean bl = wdt.serverSprinting(clientPlayerEntity);
        if (bl != this.lic) {
            this.lic = bl;
            this.lib = false;
        }
        boolean bl2 = clientPlayerEntity.isOnGround();
        if (this.lif && !bl2 && this.lig && clientPlayerEntity.getY() > clientPlayerEntity.lastY + 1.0E-4) {
            if (this.lik > this.lii) {
                this.lil = this.lil * 0.7 + (double)Math.min(10, this.lhm - this.lik) * 0.3;
            }
            this.lii = this.lhm;
            this.lij = this.lhu || (this.lht & 1) != 0;
        } else if (!this.lif && bl2) {
            this.lik = this.lhm;
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        ++this.lhm;
        if (this.lhn > 0) {
            --this.lhn;
        }
        if (this.lhw < 10) {
            ++this.lhw;
        }
        wee.ensure(minecraftClient);
        int n = wee.count();
        if (n != this.lia) {
            this.lia = n;
            this.lhz = 1;
        } else if (this.lhz < 1000) {
            ++this.lhz;
        }
        boolean bl2 = clientPlayerEntity.isOnGround();
        this.lih = bl2 ? Math.min(this.lih + 1, 1000) : 0;
        this.lif = bl2;
        this.lig = minecraftClient.options.jumpKey.isPressed();
        minecraftClient.gameRenderer.updateCrosshairTarget(1.0f);
        if (this.ljq(minecraftClient, clientPlayerEntity)) {
            this.liu(minecraftClient);
            this.ljr();
            return;
        }
        Entity entity = this.ljt(minecraftClient);
        boolean bl3 = entity != null || this.ljb(minecraftClient, clientPlayerEntity);
        this.lhu = Integer.bitCount(this.lht) >= 2;
        this.lht = (this.lht << 1 | (bl3 ? 1 : 0)) & 0xFFFF;
        boolean bl4 = this.lji(entity);
        boolean bl5 = this.lgg.get() && clientPlayerEntity.getMainHandStack().isOf(Items.MACE);
        boolean bl6 = wdt.serverSprinting(clientPlayerEntity) && !this.lib;
        boolean bl7 = this.lgf.get();
        boolean bl8 = this.lgd.is(a.b("\u7f7f\u06f0\u8c2f\u124d\u999c", -1413644503)) && !bl5 && this.ljo(minecraftClient, clientPlayerEntity) && (bl7 || !bl6);
        this.lhl.predict(clientPlayerEntity, (World)minecraftClient.world, minecraftClient.options.jumpKey.isPressed(), vxr.getInt(lhh, clientPlayerEntity, 0), lxp.active());
        int n2 = bl8 ? this.lio(clientPlayerEntity, bl6) : -1;
        boolean bl9 = bl8 && this.lge.get() && this.lip(minecraftClient, clientPlayerEntity, bl2);
        boolean bl10 = bl = entity != null && bl4 && this.lhn == 0;
        if (bl) {
            Vec3d vec3d = this.lhx != null ? this.lhy : minecraftClient.crosshairTarget.getPos();
            lgc.ljj(minecraftClient);
            bl = lgc.ljk(minecraftClient, clientPlayerEntity, vec3d) && clientPlayerEntity.getEyePos().squaredDistanceTo(vec3d) <= this.lgj.get() * this.lgj.get();
        }
        boolean bl11 = this.liv(clientPlayerEntity, 0);
        if (bl && bl11) {
            ++this.lho;
        }
        boolean bl12 = false;
        if (bl) {
            if (bl5) {
                bl12 = !this.ljm(entity) && this.ljn(minecraftClient, clientPlayerEntity) && this.lhl.airAt(0) && this.lhl.fallAt(0) > 1.5 && (bl11 || this.lhl.landsWithin(0, 2));
            } else if (!bl8) {
                bl12 = bl11 && this.lis(clientPlayerEntity) && this.lie == 0;
            } else if (n2 == 0) {
                bl12 = true;
            } else if (bl11) {
                boolean bl13;
                boolean bl14 = !this.lja(clientPlayerEntity, entity, n2 < 0 ? 4 : n2) && !this.ljc(clientPlayerEntity, entity);
                boolean bl15 = n2 > 0 && (n2 <= 1 || this.lhu) && n2 <= 14 && bl14;
                boolean bl16 = n2 < 0 && bl9 && this.lhu && bl14;
                boolean bl17 = bl13 = this.lho <= 18 || this.lho <= 30 && bl9 && !bl6 && this.lhl.serverGroundAt(0);
                if ((bl15 || bl16) && bl13) {
                    bl12 = false;
                } else if (this.lie != 0) {
                    bl12 = false;
                } else if (this.lir(minecraftClient, clientPlayerEntity, bl7) && this.lhu && !this.lja(clientPlayerEntity, entity, 2)) {
                    this.lie = 1;
                } else {
                    boolean bl18 = bl12 = this.lis(clientPlayerEntity) || this.lho > 18;
                }
            }
        }
        if (!(bl12 || this.lie != 0 || this.lid || bl5 || !this.lir(minecraftClient, clientPlayerEntity, bl7) || n2 >= 0 || bl9 || !this.liv(clientPlayerEntity, 2) || this.liv(clientPlayerEntity, 1) || entity == null && !this.lhu)) {
            this.lie = 1;
        }
        if (this.lid) {
            this.lid = bl8 && bl7 && n2 >= 0 && n2 <= Math.max(this.lhq, 1) && (entity != null || this.lhu || n2 <= 1 && this.ljd(minecraftClient, clientPlayerEntity));
        } else if (bl8 && bl7 && bl6 && n2 >= 1 && n2 <= this.lhq && this.lie == 0) {
            boolean bl19 = this.lid = entity != null || this.lhu || this.lge.get() && this.ljd(minecraftClient, clientPlayerEntity);
        }
        if (bl12) {
            this.lit(minecraftClient, clientPlayerEntity, entity);
            this.lid = false;
        }
        if (this.lid || this.lie == 1) {
            this.lhk.hold(minecraftClient);
        } else {
            this.lhk.release(minecraftClient);
        }
        if (this.lie == 1) {
            this.lie = 2;
        } else if (this.lie == 2) {
            this.lie = 0;
        }
    }

    private int lio(ClientPlayerEntity clientPlayerEntity, boolean bl) {
        int n = bl ? 1 : 0;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        for (int i = n; i <= 20; ++i) {
            if (i == 20 || i > n && this.lhl.airAt(i - 1) && !this.lhl.airAt(i)) {
                if (n2 >= 0) {
                    return n2;
                }
                if (n4 < 0 && i != 20) continue;
                return n4;
            }
            if (!this.lhl.critAt(i) || !this.liv(clientPlayerEntity, i)) continue;
            if (!this.lhl.safeAt(i)) {
                if (n4 >= 0) continue;
                n4 = i;
                continue;
            }
            if (n2 < 0) {
                n2 = i;
                if (!(this.liw(clientPlayerEntity, i) >= 1.0f)) continue;
                return i;
            }
            if (n3 >= 0) {
                return n3;
            }
            if (!(this.liw(clientPlayerEntity, i) >= 1.0f)) continue;
            n3 = i;
        }
        return -1;
    }

    private boolean lip(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, boolean bl) {
        if (!this.lij || this.lhm - this.lii > 26 || clientPlayerEntity.isSneaking() || clientPlayerEntity.isTouchingWater() || bl && this.lih > this.liq()) {
            return false;
        }
        return ksp.headroom(clientPlayerEntity, (World)minecraftClient.world, 0.16) >= 0.16;
    }

    private int liq() {
        return MathHelper.clamp((int)((int)Math.ceil(this.lil) + 2), (int)2, (int)7);
    }

    private boolean lir(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, boolean bl) {
        return this.lib && bl && clientPlayerEntity.isSprinting() && !wdt.anyHeld() && (!clientPlayerEntity.isOnGround() || !minecraftClient.options.jumpKey.isPressed());
    }

    private boolean lis(ClientPlayerEntity clientPlayerEntity) {
        return !this.lhu || this.liw(clientPlayerEntity, -this.lhp) >= 1.0f;
    }

    private void lit(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity) {
        block5: {
            block6: {
                if (!wdt.serverSprinting(clientPlayerEntity) || this.lib || !this.liv(clientPlayerEntity, 0)) break block5;
                if (!(entity instanceof LivingEntity)) break block6;
                LivingEntity livingEntity = (LivingEntity)entity;
                if (livingEntity.hurtTime > 0 || livingEntity.isBlocking()) break block5;
            }
            this.lib = true;
        }
        if (this.lhx != null) {
            minecraftClient.interactionManager.attackEntity((PlayerEntity)clientPlayerEntity, this.lhx);
            clientPlayerEntity.swingHand(Hand.MAIN_HAND);
        } else {
            lgc.lix(minecraftClient);
        }
        this.lhv = entity;
        this.lhw = 0;
        this.lho = 0;
        this.lhn = this.lgi.getInt();
        this.lhp = lgc.liy();
        this.lhq = lgc.liz();
    }

    private void liu(MinecraftClient minecraftClient) {
        this.lhk.release(minecraftClient);
        this.lid = false;
        this.lie = 0;
    }

    private boolean liv(ClientPlayerEntity clientPlayerEntity, int n) {
        return this.liw(clientPlayerEntity, n) > 0.9f;
    }

    private float liw(ClientPlayerEntity clientPlayerEntity, int n) {
        float f = MathHelper.clamp((float)(((float)this.lhz + 0.5f + (float)n) / clientPlayerEntity.getAttackCooldownProgressPerTick()), (float)0.0f, (float)1.0f);
        return Math.min(clientPlayerEntity.getAttackCooldownProgress(0.5f + (float)n), f);
    }

    private static void lix(MinecraftClient minecraftClient) {
        KeyBinding keyBinding = minecraftClient.options.attackKey;
        int n = vxr.getInt(lhi, keyBinding, -1);
        if (n > 0) {
            return;
        }
        if (n == 0 && vxr.setInt(lhi, keyBinding, 1)) {
            return;
        }
        InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding);
        if (!key.equals((Object)InputUtil.UNKNOWN_KEY)) {
            KeyBinding.onKeyPressed((InputUtil.Key)key);
        }
    }

    private static int liy() {
        return ThreadLocalRandom.current().nextDouble() < 0.2 ? 1 : 0;
    }

    private static int liz() {
        return ThreadLocalRandom.current().nextDouble() < 0.3 ? 2 : 1;
    }

    private boolean lja(ClientPlayerEntity clientPlayerEntity, Entity entity, int n) {
        int n2 = Math.min(n, 4);
        double d = Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get());
        Vec3d vec3d = clientPlayerEntity.getEyePos().add(this.lhl.offsetAt(n2));
        Box box = entity.getBoundingBox().offset((entity.getX() - entity.lastX) * (double)n2, 0.0, (entity.getZ() - entity.lastZ) * (double)n2);
        return box.squaredMagnitude(vec3d) > d * d;
    }

    private boolean ljb(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get()) + 1.5;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = vec3d.add(clientPlayerEntity.getRotationVec(1.0f).multiply(d));
        Vec3d vec3d3 = lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d2);
        for (Entity entity2 : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(d + 1.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            if (!lgc.ljh(entity2.getBoundingBox().expand((double)entity2.getTargetingMargin()), vec3d, vec3d2, vec3d3)) continue;
            return true;
        }
        return false;
    }

    private boolean ljc(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        float f = 2.0f * clientPlayerEntity.getYaw() - clientPlayerEntity.lastYaw;
        float f2 = MathHelper.clamp((float)(2.0f * clientPlayerEntity.getPitch() - clientPlayerEntity.lastPitch), (float)-90.0f, (float)90.0f);
        Vec3d vec3d = clientPlayerEntity.getEyePos().add(this.lhl.offsetAt(1));
        Vec3d vec3d2 = vec3d.add(Vec3d.fromPolar((float)f2, (float)f).multiply(Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get())));
        Box box = entity.getBoundingBox().offset(entity.getX() - entity.lastX, entity.getY() - entity.lastY, entity.getZ() - entity.lastZ).expand((double)entity.getTargetingMargin() + 0.1);
        return !box.contains(vec3d) && box.raycast(vec3d, vec3d2).isEmpty();
    }

    private boolean ljd(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return this.lje(minecraftClient, clientPlayerEntity) || this.ljf(minecraftClient, clientPlayerEntity);
    }

    private boolean lje(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get()) + 0.6;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = clientPlayerEntity.getRotationVec(1.0f);
        for (Entity entity2 : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(d + 1.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            Box box = entity2.getBoundingBox();
            if (box.squaredMagnitude(vec3d) > d * d || !(box.getCenter().subtract(vec3d).normalize().dotProduct(vec3d2) >= 0.766)) continue;
            return true;
        }
        return false;
    }

    private boolean ljf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = lgc.ljl(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = vec3d.add(clientPlayerEntity.getRotationVec(1.0f).multiply(d));
        float f = MathHelper.clamp((float)(2.0f * clientPlayerEntity.getPitch() - clientPlayerEntity.lastPitch), (float)-90.0f, (float)90.0f);
        float f2 = 2.0f * clientPlayerEntity.getYaw() - clientPlayerEntity.lastYaw;
        Vec3d vec3d3 = vec3d.add(Vec3d.fromPolar((float)f, (float)f2).multiply(d));
        Vec3d vec3d4 = lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d2);
        Vec3d vec3d5 = lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d3);
        for (Entity entity2 : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(d + 2.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            Box box = entity2.getBoundingBox();
            Box box2 = box.union(box.offset(entity2.getX() - entity2.lastX, entity2.getY() - entity2.lastY, entity2.getZ() - entity2.lastZ)).expand(0.1);
            if (!lgc.ljh(box2, vec3d, vec3d2, vec3d4) && !lgc.ljh(box2, vec3d, vec3d3, vec3d5)) continue;
            return true;
        }
        return false;
    }

    private static Vec3d ljg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Vec3d vec3d2) {
        BlockHitResult blockHitResult = minecraftClient.world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity));
        return blockHitResult.getType() == HitResult.Type.MISS ? vec3d2 : blockHitResult.getPos();
    }

    private static boolean ljh(Box box, Vec3d vec3d, Vec3d vec3d3, Vec3d vec3d4) {
        if (box.contains(vec3d)) {
            return true;
        }
        double d = vec3d.squaredDistanceTo(vec3d4);
        return box.raycast(vec3d, vec3d3).filter(vec3d2 -> vec3d.squaredDistanceTo(vec3d2) <= d).isPresent();
    }

    private boolean lji(Entity entity) {
        if (entity == null) {
            if (++this.lhs > 2) {
                this.lhr = 0;
                this.lho = 0;
            }
            return false;
        }
        this.lhs = 0;
        return (long)this.lhr++ * 50L >= (long)this.lgh.get();
    }

    private static void ljj(MinecraftClient minecraftClient) {
        if (vxr.getInt(lhg, minecraftClient, 0) > 10) {
            vxr.setInt(lhg, minecraftClient, 0);
        }
    }

    private static boolean ljk(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d) {
        if (vxr.getInt(lhg, minecraftClient, 0) > 0) {
            return false;
        }
        ItemStack itemStack = clientPlayerEntity.getMainHandStack();
        if (clientPlayerEntity.isBelowMinimumAttackCharge(itemStack, 0)) {
            return false;
        }
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)itemStack.get(DataComponentTypes.ATTACK_RANGE);
        return attackRangeComponent == null || attackRangeComponent.isWithinRange((LivingEntity)clientPlayerEntity, vec3d);
    }

    private static double ljl(ClientPlayerEntity clientPlayerEntity) {
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)clientPlayerEntity.getMainHandStack().get(DataComponentTypes.ATTACK_RANGE);
        return attackRangeComponent != null ? (double)attackRangeComponent.getEffectiveMaxRange((Entity)clientPlayerEntity) : clientPlayerEntity.getEntityInteractionRange();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean ljm(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.hurtTime > 0) return true;
        }
        if (entity != this.lhv) return false;
        if (this.lhw >= 10) return false;
        return true;
    }

    private boolean ljn(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isInLava() && !clientPlayerEntity.hasVehicle() && !clientPlayerEntity.isGliding() && !clientPlayerEntity.getAbilities().flying && !clientPlayerEntity.inPowderSnow && !clientPlayerEntity.hasStatusEffect(StatusEffects.LEVITATION) && !clientPlayerEntity.hasStatusEffect(StatusEffects.SLOW_FALLING) && minecraftClient.world.getStatesInBox(clientPlayerEntity.getBoundingBox().contract(1.0E-7)).noneMatch(lgc::ljp);
    }

    private boolean ljo(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.hasStatusEffect(StatusEffects.BLINDNESS) && this.ljn(minecraftClient, clientPlayerEntity);
    }

    private static boolean ljp(BlockState blockState) {
        return blockState.isOf(Blocks.COBWEB) || blockState.isOf(Blocks.SWEET_BERRY_BUSH) || blockState.isOf(Blocks.POWDER_SNOW);
    }

    private boolean ljq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return minecraftClient.currentScreen != null || clientPlayerEntity.isSpectator() || !clientPlayerEntity.isAlive() || clientPlayerEntity.isUsingItem() || clientPlayerEntity.isRiding() || this.ljs(minecraftClient) || oxw.busy() || kvz.busy() || nuo.busy() && !lgc.ljw(clientPlayerEntity) || kmy.busy() || nfl.busy() || lqq.busy();
    }

    private void ljr() {
        this.lhr = 0;
        this.lhs = 0;
        this.lho = 0;
        this.lht = 0;
    }

    private boolean ljs(MinecraftClient minecraftClient) {
        if (minecraftClient.interactionManager != null && minecraftClient.interactionManager.isBreakingBlock()) {
            return true;
        }
        return minecraftClient.options.attackKey.isPressed() && minecraftClient.crosshairTarget != null && minecraftClient.crosshairTarget.getType() == HitResult.Type.BLOCK;
    }

    private Entity ljt(MinecraftClient minecraftClient) {
        this.lhx = null;
        HitResult hitResult = minecraftClient.crosshairTarget;
        if (hitResult == null || hitResult.getType() != HitResult.Type.ENTITY) {
            return null;
        }
        Entity entity = ((EntityHitResult)hitResult).getEntity();
        if (this.ljv(minecraftClient, entity)) {
            return entity;
        }
        if (this.lgm.get() && entity instanceof PlayerEntity && hhf.isFriend(entity)) {
            this.lhx = this.lju(minecraftClient, minecraftClient.player);
            return this.lhx;
        }
        return null;
    }

    private Entity lju(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = lgc.ljl(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = vec3d.add(clientPlayerEntity.getRotationVec(1.0f).multiply(d));
        double d2 = vec3d.squaredDistanceTo(lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d2));
        Entity entity2 = null;
        double d3 = Double.MAX_VALUE;
        for (Entity entity3 : minecraftClient.world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(d + 1.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            double d4;
            Box box = entity3.getBoundingBox().expand((double)entity3.getTargetingMargin());
            Vec3d vec3d3 = box.contains(vec3d) ? vec3d : (Vec3d)box.raycast(vec3d, vec3d2).orElse(null);
            if (vec3d3 == null || !((d4 = vec3d.squaredDistanceTo(vec3d3)) <= d2) || !(d4 < d3)) continue;
            entity2 = entity3;
            d3 = d4;
            this.lhy = vec3d3;
        }
        return entity2;
    }

    private boolean ljv(MinecraftClient minecraftClient, Entity entity) {
        LivingEntity livingEntity;
        if (entity == null || entity == minecraftClient.player) {
            return false;
        }
        if (!(entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).isAlive() && entity.isAttackable())) {
            return false;
        }
        if (entity instanceof PlayerEntity) {
            return this.lgk.get() && !hhf.protects(entity);
        }
        return this.lgl.get();
    }

    private static boolean ljw(ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack = clientPlayerEntity.getMainHandStack();
        return itemStack.isIn(ItemTags.SWORDS) || itemStack.isIn(ItemTags.AXES) || itemStack.isOf(Items.MACE) || itemStack.isOf(Items.TRIDENT);
    }

    private static /* synthetic */ int awr(int n, int n2) {
        return n * n2 + -2053724126;
    }
}

