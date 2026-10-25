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
        if (this.mc.field_1724 != null) {
            this.lhl.sync(this.mc.field_1724);
            this.lic = wdt.serverSprinting(this.mc.field_1724);
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
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        this.lhl.afterMove(clientPlayerEntity, (World)minecraftClient.field_1687);
        boolean bl = wdt.serverSprinting(clientPlayerEntity);
        if (bl != this.lic) {
            this.lic = bl;
            this.lib = false;
        }
        boolean bl2 = clientPlayerEntity.method_24828();
        if (this.lif && !bl2 && this.lig && clientPlayerEntity.method_23318() > clientPlayerEntity.field_6036 + 1.0E-4) {
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
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
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
        boolean bl2 = clientPlayerEntity.method_24828();
        this.lih = bl2 ? Math.min(this.lih + 1, 1000) : 0;
        this.lif = bl2;
        this.lig = minecraftClient.field_1690.field_1903.method_1434();
        minecraftClient.field_1773.method_3190(1.0f);
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
        boolean bl5 = this.lgg.get() && clientPlayerEntity.method_6047().method_31574(Items.field_49814);
        boolean bl6 = wdt.serverSprinting(clientPlayerEntity) && !this.lib;
        boolean bl7 = this.lgf.get();
        boolean bl8 = this.lgd.is(a.b("\u7f7f\u06f0\u8c2f\u124d\u999c", -1413644503)) && !bl5 && this.ljo(minecraftClient, clientPlayerEntity) && (bl7 || !bl6);
        this.lhl.predict(clientPlayerEntity, (World)minecraftClient.field_1687, minecraftClient.field_1690.field_1903.method_1434(), vxr.getInt(lhh, clientPlayerEntity, 0), lxp.active());
        int n2 = bl8 ? this.lio(clientPlayerEntity, bl6) : -1;
        boolean bl9 = bl8 && this.lge.get() && this.lip(minecraftClient, clientPlayerEntity, bl2);
        boolean bl10 = bl = entity != null && bl4 && this.lhn == 0;
        if (bl) {
            Vec3d vec3d = this.lhx != null ? this.lhy : minecraftClient.field_1765.method_17784();
            lgc.ljj(minecraftClient);
            bl = lgc.ljk(minecraftClient, clientPlayerEntity, vec3d) && clientPlayerEntity.method_33571().method_1025(vec3d) <= this.lgj.get() * this.lgj.get();
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
        if (!this.lij || this.lhm - this.lii > 26 || clientPlayerEntity.method_5715() || clientPlayerEntity.method_5799() || bl && this.lih > this.liq()) {
            return false;
        }
        return ksp.headroom(clientPlayerEntity, (World)minecraftClient.field_1687, 0.16) >= 0.16;
    }

    private int liq() {
        return MathHelper.method_15340((int)((int)Math.ceil(this.lil) + 2), (int)2, (int)7);
    }

    private boolean lir(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, boolean bl) {
        return this.lib && bl && clientPlayerEntity.method_5624() && !wdt.anyHeld() && (!clientPlayerEntity.method_24828() || !minecraftClient.field_1690.field_1903.method_1434());
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
                if (livingEntity.field_6235 > 0 || livingEntity.method_6039()) break block5;
            }
            this.lib = true;
        }
        if (this.lhx != null) {
            minecraftClient.field_1761.method_2918((PlayerEntity)clientPlayerEntity, this.lhx);
            clientPlayerEntity.method_6104(Hand.field_5808);
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
        float f = MathHelper.method_15363((float)(((float)this.lhz + 0.5f + (float)n) / clientPlayerEntity.method_7279()), (float)0.0f, (float)1.0f);
        return Math.min(clientPlayerEntity.method_7261(0.5f + (float)n), f);
    }

    private static void lix(MinecraftClient minecraftClient) {
        KeyBinding keyBinding = minecraftClient.field_1690.field_1886;
        int n = vxr.getInt(lhi, keyBinding, -1);
        if (n > 0) {
            return;
        }
        if (n == 0 && vxr.setInt(lhi, keyBinding, 1)) {
            return;
        }
        InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding);
        if (!key.equals((Object)InputUtil.field_16237)) {
            KeyBinding.method_1420((InputUtil.Key)key);
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
        Vec3d vec3d = clientPlayerEntity.method_33571().method_1019(this.lhl.offsetAt(n2));
        Box box = entity.method_5829().method_989((entity.method_23317() - entity.field_6014) * (double)n2, 0.0, (entity.method_23321() - entity.field_5969) * (double)n2);
        return box.method_49271(vec3d) > d * d;
    }

    private boolean ljb(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get()) + 1.5;
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = vec3d.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(d));
        Vec3d vec3d3 = lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d2);
        for (Entity entity2 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d + 1.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            if (!lgc.ljh(entity2.method_5829().method_1014((double)entity2.method_5871()), vec3d, vec3d2, vec3d3)) continue;
            return true;
        }
        return false;
    }

    private boolean ljc(ClientPlayerEntity clientPlayerEntity, Entity entity) {
        float f = 2.0f * clientPlayerEntity.method_36454() - clientPlayerEntity.field_5982;
        float f2 = MathHelper.method_15363((float)(2.0f * clientPlayerEntity.method_36455() - clientPlayerEntity.field_6004), (float)-90.0f, (float)90.0f);
        Vec3d vec3d = clientPlayerEntity.method_33571().method_1019(this.lhl.offsetAt(1));
        Vec3d vec3d2 = vec3d.method_1019(Vec3d.method_1030((float)f2, (float)f).method_1021(Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get())));
        Box box = entity.method_5829().method_989(entity.method_23317() - entity.field_6014, entity.method_23318() - entity.field_6036, entity.method_23321() - entity.field_5969).method_1014((double)entity.method_5871() + 0.1);
        return !box.method_1006(vec3d) && box.method_992(vec3d, vec3d2).isEmpty();
    }

    private boolean ljd(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return this.lje(minecraftClient, clientPlayerEntity) || this.ljf(minecraftClient, clientPlayerEntity);
    }

    private boolean lje(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = Math.min(lgc.ljl(clientPlayerEntity), this.lgj.get()) + 0.6;
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = clientPlayerEntity.method_5828(1.0f);
        for (Entity entity2 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d + 1.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            Box box = entity2.method_5829();
            if (box.method_49271(vec3d) > d * d || !(box.method_1005().method_1020(vec3d).method_1029().method_1026(vec3d2) >= 0.766)) continue;
            return true;
        }
        return false;
    }

    private boolean ljf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = lgc.ljl(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = vec3d.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(d));
        float f = MathHelper.method_15363((float)(2.0f * clientPlayerEntity.method_36455() - clientPlayerEntity.field_6004), (float)-90.0f, (float)90.0f);
        float f2 = 2.0f * clientPlayerEntity.method_36454() - clientPlayerEntity.field_5982;
        Vec3d vec3d3 = vec3d.method_1019(Vec3d.method_1030((float)f, (float)f2).method_1021(d));
        Vec3d vec3d4 = lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d2);
        Vec3d vec3d5 = lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d3);
        for (Entity entity2 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d + 2.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            Box box = entity2.method_5829();
            Box box2 = box.method_991(box.method_989(entity2.method_23317() - entity2.field_6014, entity2.method_23318() - entity2.field_6036, entity2.method_23321() - entity2.field_5969)).method_1014(0.1);
            if (!lgc.ljh(box2, vec3d, vec3d2, vec3d4) && !lgc.ljh(box2, vec3d, vec3d3, vec3d5)) continue;
            return true;
        }
        return false;
    }

    private static Vec3d ljg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Vec3d vec3d2) {
        BlockHitResult blockHitResult = minecraftClient.field_1687.method_17742(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, (Entity)clientPlayerEntity));
        return blockHitResult.method_17783() == HitResult.Type.field_1333 ? vec3d2 : blockHitResult.method_17784();
    }

    private static boolean ljh(Box box, Vec3d vec3d, Vec3d vec3d3, Vec3d vec3d4) {
        if (box.method_1006(vec3d)) {
            return true;
        }
        double d = vec3d.method_1025(vec3d4);
        return box.method_992(vec3d, vec3d3).filter(vec3d2 -> vec3d.method_1025(vec3d2) <= d).isPresent();
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
        ItemStack itemStack = clientPlayerEntity.method_6047();
        if (clientPlayerEntity.method_75202(itemStack, 0)) {
            return false;
        }
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)itemStack.method_58694(DataComponentTypes.field_64680);
        return attackRangeComponent == null || attackRangeComponent.method_76736((LivingEntity)clientPlayerEntity, vec3d);
    }

    private static double ljl(ClientPlayerEntity clientPlayerEntity) {
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)clientPlayerEntity.method_6047().method_58694(DataComponentTypes.field_64680);
        return attackRangeComponent != null ? (double)attackRangeComponent.method_76739((Entity)clientPlayerEntity) : clientPlayerEntity.method_55755();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean ljm(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.field_6235 > 0) return true;
        }
        if (entity != this.lhv) return false;
        if (this.lhw >= 10) return false;
        return true;
    }

    private boolean ljn(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.method_6101() && !clientPlayerEntity.method_5799() && !clientPlayerEntity.method_5771() && !clientPlayerEntity.method_5765() && !clientPlayerEntity.method_6128() && !clientPlayerEntity.method_31549().field_7479 && !clientPlayerEntity.field_27857 && !clientPlayerEntity.method_6059(StatusEffects.field_5902) && !clientPlayerEntity.method_6059(StatusEffects.field_5906) && minecraftClient.field_1687.method_29546(clientPlayerEntity.method_5829().method_1011(1.0E-7)).noneMatch(lgc::ljp);
    }

    private boolean ljo(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.method_6059(StatusEffects.field_5919) && this.ljn(minecraftClient, clientPlayerEntity);
    }

    private static boolean ljp(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10343) || blockState.method_27852(Blocks.field_16999) || blockState.method_27852(Blocks.field_27879);
    }

    private boolean ljq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return minecraftClient.field_1755 != null || clientPlayerEntity.method_7325() || !clientPlayerEntity.method_5805() || clientPlayerEntity.method_6115() || clientPlayerEntity.method_3144() || this.ljs(minecraftClient) || oxw.busy() || kvz.busy() || nuo.busy() && !lgc.ljw(clientPlayerEntity) || kmy.busy() || nfl.busy() || lqq.busy();
    }

    private void ljr() {
        this.lhr = 0;
        this.lhs = 0;
        this.lho = 0;
        this.lht = 0;
    }

    private boolean ljs(MinecraftClient minecraftClient) {
        if (minecraftClient.field_1761 != null && minecraftClient.field_1761.method_2923()) {
            return true;
        }
        return minecraftClient.field_1690.field_1886.method_1434() && minecraftClient.field_1765 != null && minecraftClient.field_1765.method_17783() == HitResult.Type.field_1332;
    }

    private Entity ljt(MinecraftClient minecraftClient) {
        this.lhx = null;
        HitResult hitResult = minecraftClient.field_1765;
        if (hitResult == null || hitResult.method_17783() != HitResult.Type.field_1331) {
            return null;
        }
        Entity entity = ((EntityHitResult)hitResult).method_17782();
        if (this.ljv(minecraftClient, entity)) {
            return entity;
        }
        if (this.lgm.get() && entity instanceof PlayerEntity && hhf.isFriend(entity)) {
            this.lhx = this.lju(minecraftClient, minecraftClient.field_1724);
            return this.lhx;
        }
        return null;
    }

    private Entity lju(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = lgc.ljl(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = vec3d.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(d));
        double d2 = vec3d.method_1025(lgc.ljg(minecraftClient, clientPlayerEntity, vec3d, vec3d2));
        Entity entity2 = null;
        double d3 = Double.MAX_VALUE;
        for (Entity entity3 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d + 1.0), entity -> this.ljv(minecraftClient, (Entity)entity))) {
            double d4;
            Box box = entity3.method_5829().method_1014((double)entity3.method_5871());
            Vec3d vec3d3 = box.method_1006(vec3d) ? vec3d : (Vec3d)box.method_992(vec3d, vec3d2).orElse(null);
            if (vec3d3 == null || !((d4 = vec3d.method_1025(vec3d3)) <= d2) || !(d4 < d3)) continue;
            entity2 = entity3;
            d3 = d4;
            this.lhy = vec3d3;
        }
        return entity2;
    }

    private boolean ljv(MinecraftClient minecraftClient, Entity entity) {
        LivingEntity livingEntity;
        if (entity == null || entity == minecraftClient.field_1724) {
            return false;
        }
        if (!(entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).method_5805() && entity.method_5732())) {
            return false;
        }
        if (entity instanceof PlayerEntity) {
            return this.lgk.get() && !hhf.protects(entity);
        }
        return this.lgl.get();
    }

    private static boolean ljw(ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack = clientPlayerEntity.method_6047();
        return itemStack.method_31573(ItemTags.field_42611) || itemStack.method_31573(ItemTags.field_42612) || itemStack.method_31574(Items.field_49814) || itemStack.method_31574(Items.field_8547);
    }

    private static /* synthetic */ int awr(int n, int n2) {
        return n * n2 + -2053724126;
    }
}

