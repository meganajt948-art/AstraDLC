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
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.AttackRangeComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
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
import a.kjn;
import a.kmy;
import a.ksp;
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
import a.wdf;
import a.wdt;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
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
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

final class kjq
extends kfe {
    private final vlv kjr = this.add(new vlv(a.b("\u4ebb\u373b\ubdf3\u239f\ua84f", -478523651), a.d("\u0588\u7c07\uf6d8\u68ba\ue36b", -1632274082, 457538688), a.b("\u714e\u08c1\u821e\u1c7c\u97ad", -1862831848), a.c(-990878769, "\u6383\u1a1b\u90c8")));
    private final vkl kjs = this.add(new vkl(a.c(1207326738, "\u5845\u21d6\uab12\u3562\ubeb8\u3803\u8247"), true));
    private final vkl kjt = this.add(new vkl(a.b("\ua2e0\udb72\u51a3\ucfc9\u4419\uc2b2\u78c7\uf101\u6f48\ue5ef\u622d", -1490705736), false));
    private final vkl kju = this.add(new vkl(a.c(1614762710, "\u5296\u2b09\ua1da\u3fbe\ub439\u32db\u888b\u0178\u9f3c\u158a\u9243"), true));
    private final vkl kjv = this.add(new vkl(a.b("\uf31f\u8a82S\u9e24\u15c5\u934a\u2915\ua0f6\u3eb2", 75821915), true));
    private final vmc kjw = this.add(new vmc(a.c(2118563030, "\ub48c\ucd0a\u47dd\ud9ae\u526e\ud4c2\u6e97\ue767"), 0.0, 0.0, 500.0, 10.0).suffix(a.b("\u90c7\ue968", -1290760024)));
    private final vmc kjx = this.add(new vmc(a.c(287932150, "\u7eb7\u0727\u8dfd\u1381\u984e"), 0.0, 0.0, 10.0, 1.0).suffix(a.c(903363351, "\u3b66\u42ca\uc813\u566a\udda5")));
    private final vkl kjy = this.add(new vkl(a.d("\ude19\ua794\u2d4a\ub323\u38e8\ube4e\u041c", -1981620463, -612564641), true));
    private final vkl kjz = this.add(new vkl(a.d("\u2d43\u54d0\ude0e\u406e", 1311863879, -364357299), true));
    private final vkl kka = this.add(new vkl(a.b("\ubdd5\uc458\u4e91\ud0fd\u5b30\udd93\u67cf\uee76\u706f\ufaca\u7d02\u877f\u09a3\u9018\u1a5c", -1952334450), true));
    private static final int kkb = 12;
    private static final int kkc = 1;
    private static final int kkd = 2;
    private static final int kke = 10;
    private static final int kkf = 2;
    private static final double kkg = 0.1;
    private static final double kkh = 1.0;
    private static final int kki = 3;
    private static final float kkj = 0.9f;
    private static final double kkk = 1.25;
    private static final int kkl = 5;
    private static final int kkm = 20;
    private static final Field kkn = vxr.find(MinecraftClient.class, a.c(-14317303, "\u8970\uf0ca\u7a08\ue423\u6fb7\ue902\u5356\udaac\u44f5\uce55\u4995\ub3e3\u3d26\ua4cd\u2ed3\ua82d\u126f\u9dac\u071f\u8162\u08f9\u72aa\ufc18"), a.c(-1767998247, "\u7cb5\u050b\u8fd4\u11ac\u9a73\u1cf9\ua6c4\u2f33\ub16c\u3bdb"), a.c(1898917041, "\u2cf9"));
    private static final Field kko = vxr.find(LivingEntity.class, a.b("\uf5c8\u8c72\u06b0\u989b\u130f\u95ba\u2fee\ua614\u384d\ub2ed\u352d\ucf5b\u419e\ud875\u526b\ud495\u6ed7\ue114\u7ba7\ufdda\u7443\u0e10\u80a0\u1b78", 71103934), a.c(1565623774, "\u85b2\ufc0c\u76d3\ue8ab\u6374\ue5fe\u5fc4\ud631\u486e\uc2d5"), a.d("\u0e12", 282739367, -1331671811));
    private final ksp kkp = new ksp();
    private kjn kkq = kjn.NONE;
    private int kkr;
    private int kks = 1;
    private boolean kkt;
    private int kku;
    private boolean kkv;
    private double kkw;
    private boolean kkx = true;
    private int kky;
    private int kkz;
    private double kla;
    private double klb = Double.NaN;
    private int klc = Integer.MAX_VALUE;
    private Entity kld;
    private int kle;
    private int klf;
    private int klg = 3;
    private int klh;
    private boolean kli;
    private Entity klj;
    private int klk = 10;
    private final wdt kll = new wdt();
    private Predicate<Entity> klm;
    private Entity kln;
    private Vec3d klo;
    private boolean klp;
    private boolean klq;
    private int klr = -1;
    private kjn kls = kjn.NONE;
    private boolean klt;
    private static /* synthetic */ String klu;
    private static /* synthetic */ String klv;

    private kjq(Predicate<Entity> predicate) {
        super(a.d("\ub555\uccc2\u460a\ud875\u53a2\ud511\u6f55\ue694\u78e6\uf24c", -549677939, 1153507718), "", kfa.COMBAT);
        this.klm = predicate;
    }

    static kjq embedded(Predicate<Entity> predicate) {
        return new kjq(predicate);
    }

    String trace() {
        return a.d("\uc411\ubdb5\u3775\ua911\u22c4\ua464\u1e7e", -1478821122, 1752252060) + this.klp + a.b("\udc74\ua586\u2f57\ub129\u3aad", 633855057) + this.klq + a.b("\u998c\ue07e\u6abc\uf4d6\u7f1c\uf9e4", -270886486) + this.klr + a.d("\u4abb\u334f\ub997\u27ef\uac3e\u2a89\u90d8\u1928\u872e", -549924535, -1985635365) + this.kli + a.c(559946465, "\u1ac6\u6325\ue9e1\u7794\ufc50\u7afe\uc0fd") + (Object)((Object)this.kls) + a.d("\u42e9\u3b10\ub1c4\u2faa\ua430", -1451105018, 261924810) + this.klt + a.b("\u8f1d\uf6ff\u7c2f\ue24b\u6997\uef3c\u5526", -1861710022) + this.kkt;
    }

    int strikeIn(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Entity entity, boolean bl) {
        int n;
        int n2;
        this.kkp.predict(clientPlayerEntity, (World)minecraftClient.field_1687, minecraftClient.field_1690.field_1903.method_1434(), vxr.getInt(kko, clientPlayerEntity, 0), lxp.active(), this.kla);
        int n3 = n2 = wdt.serverSprinting(clientPlayerEntity) ? 1 : 0;
        if (bl && this.kmr(minecraftClient, clientPlayerEntity)) {
            n = this.kma(clientPlayerEntity, n2, true, false);
            if (n < 0) {
                n = this.kma(clientPlayerEntity, n2, false, false);
            }
            if (n > 0 && kjq.kmd(clientPlayerEntity, 0) && this.kmb(clientPlayerEntity, entity, n)) {
                n = -1;
            }
            if (n >= 0) {
                return n;
            }
        }
        for (n = 0; n < 20; ++n) {
            if (!kjq.kmd(clientPlayerEntity, n)) continue;
            return n;
        }
        return 20;
    }

    Vec3d selfOffset(int n) {
        return this.kkp.offsetAt(n);
    }

    void crits(boolean bl) {
        this.kjr.set(bl ? a.b("\u4c87\u3508\ubfd7\u21b5\uaa64", 504843473) : a.c(-698373815, "\ua905\ud09d\u5a4e"));
    }

    @Override
    protected void onEnable() {
        this.kla = 0.0;
        this.klb = Double.NaN;
        this.klc = Integer.MAX_VALUE;
        this.kkt = false;
        this.kks = kjq.kmn();
        this.kkw = kjq.klx();
        this.kky = kjq.kly();
    }

    @Override
    protected void onDisable() {
        this.kmt(this.mc);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        double d = clientPlayerEntity.method_23318();
        double d2 = Double.isNaN(this.klb) ? 0.0 : d - this.klb;
        this.klb = d;
        if (d2 > 0.0 || d2 < -4.0) {
            this.kla = 0.0;
        } else if (d2 < 0.0 && !clientPlayerEntity.method_5799()) {
            this.kla -= d2;
        }
        this.kla = Math.min(this.kla, clientPlayerEntity.field_6017);
        this.klc = clientPlayerEntity.method_24828() ? Math.min(this.klc, 0x7FFFFFFE) + 1 : 0;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        boolean bl;
        int n;
        boolean bl2;
        boolean bl3;
        kjn kjn2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (this.kkz > 0) {
            --this.kkz;
        }
        if (this.klk < 10) {
            ++this.klk;
        }
        if (minecraftClient.field_1755 != null || clientPlayerEntity.method_7325() || !clientPlayerEntity.method_5805() || clientPlayerEntity.method_6115() || clientPlayerEntity.method_3144() || this.kmu(minecraftClient) || oxw.busy() || kvz.busy() || nuo.busy() || kmy.busy() || nfl.busy() || lqq.busy()) {
            this.kmt(minecraftClient);
            return;
        }
        boolean bl4 = wdt.serverSprinting(clientPlayerEntity);
        if (!bl4) {
            this.kkt = false;
        } else if (this.kkt) {
            if (!clientPlayerEntity.method_5624()) {
                this.kkv = true;
            }
            if (!this.kkv && ++this.kku > 20) {
                this.kkt = false;
            }
        }
        boolean bl5 = clientPlayerEntity.method_24828();
        if (this.kkx && !bl5) {
            this.kkw = kjq.klx();
        }
        this.kkx = bl5;
        boolean bl6 = this.kju.get();
        kjn kjn3 = kjn2 = bl6 ? kjn.NONE : this.kkq;
        if (kjn2 == kjn.STOP && clientPlayerEntity.method_24828() && minecraftClient.field_1690.field_1903.method_1434()) {
            kjn2 = kjn.START;
        }
        minecraftClient.field_1773.method_3190(1.0f);
        Entity entity = this.kmv(minecraftClient);
        this.kli = Integer.bitCount(this.klh) >= 2;
        this.klh = (this.klh << 1 | (entity != null ? 1 : 0)) & 0xFFFF;
        boolean bl7 = this.kmc(entity);
        boolean bl8 = bl3 = this.kjv.get() && clientPlayerEntity.method_6047().method_31574(Items.field_49814);
        boolean bl9 = entity != null && bl7 && this.kkz == 0 && kjq.kme(minecraftClient, clientPlayerEntity, this.kln != null ? this.klo : minecraftClient.field_1765.method_17784()) && (!bl3 || !this.kmp(entity));
        boolean bl10 = this.kjr.is(a.b("\uea47\u93c8\u1917\u8775\u0ca4", -1627919855)) && this.kmr(minecraftClient, clientPlayerEntity) && (!bl6 || !bl4 || this.kkt);
        boolean bl11 = bl2 = bl3 && this.kmq(minecraftClient, clientPlayerEntity);
        if (bl10 || bl2) {
            this.kkp.predict(clientPlayerEntity, (World)minecraftClient.field_1687, minecraftClient.field_1690.field_1903.method_1434(), vxr.getInt(kko, clientPlayerEntity, 0), lxp.active(), this.kla);
        }
        int n2 = !bl6 && bl4 ? 1 : 0;
        int n3 = -1;
        boolean bl12 = bl2 && this.kkp.smashAt(0);
        boolean bl13 = false;
        if (bl3) {
            if (bl10 && bl2) {
                n3 = this.kma(clientPlayerEntity, n2, true, true);
            }
            if (n3 > 0 && bl12 && this.kmb(clientPlayerEntity, entity, n3)) {
                n3 = -1;
            }
        } else if (bl10) {
            n3 = this.klw(clientPlayerEntity, n2, true);
            if (n3 < 0) {
                n3 = this.klw(clientPlayerEntity, n2, false);
            }
            boolean bl14 = bl13 = n3 < 0 && clientPlayerEntity.method_24828() && this.klc <= 5 && this.kli && ksp.headroom(clientPlayerEntity, (World)minecraftClient.field_1687, 1.25) < 1.25;
            if (n3 > 0 && kjq.kmd(clientPlayerEntity, 0) && this.kmb(clientPlayerEntity, entity, n3)) {
                n = this.kma(clientPlayerEntity, n2, true, false);
                if (n < 0) {
                    n = this.kma(clientPlayerEntity, n2, false, false);
                }
                int n4 = n3 = n >= 0 && n < n3 && !this.kmb(clientPlayerEntity, entity, n) ? n : -1;
            }
        }
        if (!bl6 && kjn2 == kjn.NONE && this.kkt && this.kjt.get() && n3 < 0 && (n = this.kmo(minecraftClient, clientPlayerEntity)) > 0) {
            kjn2 = kjn.STOP;
            this.kkr = n;
        }
        n = n3 == 0 || n3 == 1 ? 1 : 0;
        boolean bl15 = entity != null || n != 0 && this.kjs.get() && (this.kmh(minecraftClient, clientPlayerEntity) || this.kmi(minecraftClient, clientPlayerEntity));
        this.klg = bl15 ? 0 : this.klg + 1;
        boolean bl16 = bl = !bl6 && n != 0 && this.klg <= 2;
        if (kjn2 == kjn.STOP || bl) {
            this.kll.hold(minecraftClient);
        } else {
            this.kll.release(minecraftClient);
        }
        this.kkq = switch (kjn2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1 -> {
                if (--this.kkr > 0) {
                    yield kjn.STOP;
                }
                yield kjn.START;
            }
            case 0, 2 -> kjn.NONE;
        };
        this.klp = entity != null;
        this.klq = bl9;
        this.klr = n3;
        this.kls = kjn2;
        this.klt = bl13;
        if (!bl9) {
            return;
        }
        if (n3 == 0) {
            this.kml(minecraftClient);
            this.kkw = kjq.klx();
            this.kll.release(minecraftClient);
            if (bl3) {
                this.kla = 0.0;
            }
        } else {
            if (n3 > 0) {
                return;
            }
            if (bl3) {
                if (!bl12) {
                    return;
                }
                this.kml(minecraftClient);
                this.kla = 0.0;
            } else {
                if (!kjq.kmd(clientPlayerEntity, 0) || !kjq.klz(clientPlayerEntity, this.kky) || kjn2 != kjn.NONE || bl13) {
                    return;
                }
                this.kml(minecraftClient);
            }
        }
        this.kkz = this.kjx.getInt();
    }

    private int klw(ClientPlayerEntity clientPlayerEntity, int n, boolean bl) {
        if (!this.kli) {
            return this.kma(clientPlayerEntity, n, bl, false);
        }
        int n2 = -1;
        for (int i = n; i < 20; ++i) {
            boolean bl2;
            boolean bl3 = bl2 = bl ? this.kkp.critAt(i) : this.kkp.rawCritAt(i);
            if (!bl2) {
                if (n2 < 0) continue;
                break;
            }
            if (!kjq.kmd(clientPlayerEntity, i)) continue;
            if (n2 < 0) {
                n2 = i;
            }
            if (!(this.kkp.fallAt(i) >= this.kkw)) continue;
            return i;
        }
        return n2;
    }

    private static double klx() {
        double d = ThreadLocalRandom.current().nextDouble();
        return d < 0.3 ? 0.0 : (d < 0.65 ? 0.15 : (d < 0.9 ? 0.35 : 0.6));
    }

    private static int kly() {
        double d = ThreadLocalRandom.current().nextDouble();
        return d < 0.5 ? 0 : (d < 0.85 ? 1 : 2);
    }

    private static boolean klz(ClientPlayerEntity clientPlayerEntity, int n) {
        return clientPlayerEntity.method_7261(0.5f - (float)n) > 0.9f;
    }

    private int kma(ClientPlayerEntity clientPlayerEntity, int n, boolean bl, boolean bl2) {
        for (int i = n; i < 20; ++i) {
            boolean bl3;
            boolean bl4 = bl3 = bl ? this.kkp.critAt(i) : this.kkp.rawCritAt(i);
            if (!bl3 || bl2 && !this.kkp.smashAt(i) || !kjq.kmd(clientPlayerEntity, i)) continue;
            return i;
        }
        return -1;
    }

    private boolean kmb(ClientPlayerEntity clientPlayerEntity, Entity entity, int n) {
        return n > (this.kli ? 12 : 1) || entity != null && this.kmg(clientPlayerEntity, entity, n);
    }

    private boolean kmc(Entity entity) {
        if (entity == null) {
            if (this.kld != null && ++this.klf > 2) {
                this.kld = null;
            }
            return false;
        }
        if (entity != this.kld) {
            this.kld = entity;
            this.kle = 0;
        }
        this.klf = 0;
        return (long)this.kle++ * 50L >= (long)this.kjw.get();
    }

    private static boolean kmd(ClientPlayerEntity clientPlayerEntity, int n) {
        return clientPlayerEntity.method_7261(0.5f + (float)n) > 0.9f;
    }

    private static boolean kme(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d) {
        if (vxr.getInt(kkn, minecraftClient, 0) > 0) {
            return false;
        }
        ItemStack itemStack = clientPlayerEntity.method_6047();
        if (clientPlayerEntity.method_75202(itemStack, 0)) {
            return false;
        }
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)itemStack.method_58694(DataComponentTypes.field_64680);
        return attackRangeComponent == null || attackRangeComponent.method_76736((LivingEntity)clientPlayerEntity, vec3d);
    }

    private static double kmf(ClientPlayerEntity clientPlayerEntity) {
        AttackRangeComponent attackRangeComponent = (AttackRangeComponent)clientPlayerEntity.method_6047().method_58694(DataComponentTypes.field_64680);
        return attackRangeComponent != null ? (double)attackRangeComponent.method_76739((Entity)clientPlayerEntity) : clientPlayerEntity.method_55755();
    }

    private boolean kmg(ClientPlayerEntity clientPlayerEntity, Entity entity, int n) {
        int n2 = Math.min(n, 3);
        double d = kjq.kmf(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.method_33571().method_1019(this.kkp.offsetAt(n2));
        Box box = entity.method_5829().method_989((entity.method_23317() - entity.field_6014) * (double)n2, 0.0, (entity.method_23321() - entity.field_5969) * (double)n2);
        return box.method_49271(vec3d) > d * d;
    }

    private boolean kmh(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = kjq.kmf(clientPlayerEntity) + 1.0;
        Vec3d vec3d = clientPlayerEntity.method_33571();
        for (Entity entity2 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d + 1.0), entity -> this.kmx(minecraftClient, (Entity)entity))) {
            if (!(entity2.method_5829().method_49271(vec3d) <= d * d)) continue;
            return true;
        }
        return false;
    }

    private boolean kmi(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = kjq.kmf(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = vec3d.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(d));
        float f = MathHelper.method_15363((float)(2.0f * clientPlayerEntity.method_36455() - clientPlayerEntity.field_6004), (float)-90.0f, (float)90.0f);
        float f2 = 2.0f * clientPlayerEntity.method_36454() - clientPlayerEntity.field_5982;
        Vec3d vec3d3 = vec3d.method_1019(Vec3d.method_1030((float)f, (float)f2).method_1021(d));
        Vec3d vec3d4 = kjq.kmj(minecraftClient, clientPlayerEntity, vec3d, vec3d2);
        Vec3d vec3d5 = kjq.kmj(minecraftClient, clientPlayerEntity, vec3d, vec3d3);
        Box box = clientPlayerEntity.method_5829().method_1014(d + 2.0);
        for (Entity entity2 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, box, entity -> this.kmx(minecraftClient, (Entity)entity))) {
            Box box2 = entity2.method_5829();
            Box box3 = box2.method_991(box2.method_989(entity2.method_23317() - entity2.field_6014, entity2.method_23318() - entity2.field_6036, entity2.method_23321() - entity2.field_5969)).method_1014(0.1);
            if (!kjq.kmk(box3, vec3d, vec3d2, vec3d4) && !kjq.kmk(box3, vec3d, vec3d3, vec3d5)) continue;
            return true;
        }
        return false;
    }

    private static Vec3d kmj(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, Vec3d vec3d2) {
        BlockHitResult blockHitResult = minecraftClient.field_1687.method_17742(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, (Entity)clientPlayerEntity));
        return blockHitResult.method_17783() == HitResult.Type.field_1333 ? vec3d2 : blockHitResult.method_17784();
    }

    private static boolean kmk(Box box, Vec3d vec3d, Vec3d vec3d3, Vec3d vec3d4) {
        if (box.method_1006(vec3d)) {
            return true;
        }
        double d = vec3d.method_1025(vec3d4);
        return box.method_992(vec3d, vec3d3).filter(vec3d2 -> vec3d.method_1025(vec3d2) <= d).isPresent();
    }

    private void kml(MinecraftClient minecraftClient) {
        wdf.hold(minecraftClient, kjq.kmm());
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (wdt.serverSprinting(clientPlayerEntity) && clientPlayerEntity.method_7261(0.5f) > 0.9f) {
            this.kkt = true;
            this.kku = 0;
            this.kkv = false;
            this.kks = kjq.kmn();
        }
        this.kky = kjq.kly();
        if (this.kln != null) {
            minecraftClient.field_1761.method_2918((PlayerEntity)minecraftClient.field_1724, this.kln);
            minecraftClient.field_1724.method_6104(Hand.field_5808);
            this.klj = this.kln;
        } else {
            KeyBinding.method_1420((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.field_1690.field_1886));
            this.klj = this.kmv(minecraftClient);
        }
        this.klk = 0;
    }

    private static long kmm() {
        return ThreadLocalRandom.current().nextLong(1000000L, 10000001L);
    }

    private static int kmn() {
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    private int kmo(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        for (int i = this.kks; i > 0; --i) {
            if (kjq.kmd(clientPlayerEntity, i) || clientPlayerEntity.method_24828() && (!kjq.kmd(clientPlayerEntity, i + 1) || minecraftClient.field_1690.field_1903.method_1434())) continue;
            return i;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean kmp(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.field_6235 > 0) return true;
        }
        if (entity != this.klj) return false;
        if (this.klk >= 10) return false;
        return true;
    }

    private boolean kmq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.method_6101() && !clientPlayerEntity.method_5799() && !clientPlayerEntity.method_5771() && !clientPlayerEntity.method_5765() && !clientPlayerEntity.method_6128() && !clientPlayerEntity.method_31549().field_7479 && !clientPlayerEntity.field_27857 && !clientPlayerEntity.method_6059(StatusEffects.field_5902) && !clientPlayerEntity.method_6059(StatusEffects.field_5906) && minecraftClient.field_1687.method_29546(clientPlayerEntity.method_5829().method_1011(1.0E-7)).noneMatch(kjq::kms);
    }

    private boolean kmr(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        return !clientPlayerEntity.method_6059(StatusEffects.field_5919) && this.kmq(minecraftClient, clientPlayerEntity);
    }

    private static boolean kms(BlockState blockState) {
        return blockState.method_27852(Blocks.field_10343) || blockState.method_27852(Blocks.field_16999) || blockState.method_27852(Blocks.field_27879);
    }

    private void kmt(MinecraftClient minecraftClient) {
        this.kll.release(minecraftClient);
        this.kkq = kjn.NONE;
        this.kld = null;
        this.kle = 0;
        this.klf = 0;
        this.klg = 3;
        this.klh = 0;
    }

    private boolean kmu(MinecraftClient minecraftClient) {
        if (minecraftClient.field_1761 != null && minecraftClient.field_1761.method_2923()) {
            return true;
        }
        return minecraftClient.field_1690.field_1886.method_1434() && minecraftClient.field_1765 != null && minecraftClient.field_1765.method_17783() == HitResult.Type.field_1332;
    }

    private Entity kmv(MinecraftClient minecraftClient) {
        this.kln = null;
        HitResult hitResult = minecraftClient.field_1765;
        if (hitResult == null || hitResult.method_17783() != HitResult.Type.field_1331) {
            return null;
        }
        Entity entity = ((EntityHitResult)hitResult).method_17782();
        if (this.kmx(minecraftClient, entity)) {
            return entity;
        }
        if (this.kka.get() && entity instanceof PlayerEntity && hhf.isFriend(entity)) {
            this.kln = this.kmw(minecraftClient, minecraftClient.field_1724);
            return this.kln;
        }
        return null;
    }

    private Entity kmw(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        double d = kjq.kmf(clientPlayerEntity);
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = vec3d.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(d));
        double d2 = vec3d.method_1025(kjq.kmj(minecraftClient, clientPlayerEntity, vec3d, vec3d2));
        Entity entity2 = null;
        double d3 = Double.MAX_VALUE;
        for (Entity entity3 : minecraftClient.field_1687.method_8333((Entity)clientPlayerEntity, clientPlayerEntity.method_5829().method_1014(d + 1.0), entity -> this.kmx(minecraftClient, (Entity)entity))) {
            double d4;
            Box box = entity3.method_5829().method_1014((double)entity3.method_5871());
            Vec3d vec3d3 = box.method_1006(vec3d) ? vec3d : (Vec3d)box.method_992(vec3d, vec3d2).orElse(null);
            if (vec3d3 == null || !((d4 = vec3d.method_1025(vec3d3)) <= d2) || !(d4 < d3)) continue;
            entity2 = entity3;
            d3 = d4;
            this.klo = vec3d3;
        }
        return entity2;
    }

    private boolean kmx(MinecraftClient minecraftClient, Entity entity) {
        LivingEntity livingEntity;
        if (entity == null || entity == minecraftClient.field_1724) {
            return false;
        }
        if (!(entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).method_5805() && entity.method_5732())) {
            return false;
        }
        if (this.klm != null) {
            return this.klm.test(entity);
        }
        if (entity instanceof PlayerEntity) {
            return this.kjy.get() && !hhf.protects(entity);
        }
        return this.kjz.get();
    }

    private static /* synthetic */ int atq(int n, int n2) {
        return n + n2 | 0xB74FF4B5;
    }
}

