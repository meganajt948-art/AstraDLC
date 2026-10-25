/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.doubles.DoubleArrayList
 *  it.unimi.dsi.fastutil.longs.Long2DoubleMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2IntMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2LongMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongArrayList
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.SlabBlock
 *  net.minecraft.block.StairsBlock
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.predicate.entity.EntityPredicates
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 */
package a;

import a.pzc;
import a.qcu;
import a.qda;
import a.qdk;
import a.qdo;
import a.qdt;
import a.qdw;
import a.qln;
import a.qmh;
import a.qmx;
import a.qnd;
import a.qrm;
import a.qsc;
import a.tbp;
import a.tcz;
import a.tel;
import a.toq;
import a.trj;
import a.ttb;
import a.vxr;
import a.vzz;
import flow.dev.a;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.longs.Long2DoubleMap;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2LongMap;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public final class qdz {
    private static final double qea = 4.4;
    private static final int qeb = 20;
    private static final int qec = 30;
    private static final int qed = 50;
    private static final double qee = 0.12;
    private static final double qef = 0.35;
    private static final int qeg = 32;
    private static final int qeh = 10;
    private static final double[][] qei = new double[][]{{0.14, 0.0}, {-0.14, 0.0}, {0.0, 0.14}, {0.0, -0.14}};
    private static final double[][] qej = new double[][]{{0.0, 0.0}, {0.27, 0.27}, {-0.27, 0.27}, {0.27, -0.27}, {-0.27, -0.27}, {0.3, 0.0}, {-0.3, 0.0}, {0.0, 0.3}, {0.0, -0.3}};
    private static final Field qek = vxr.find(ClientPlayerEntity.class, a.c(1534863791, "\u29d6\u506c\udaae\u4485\ucf11\u49a4\uf3f0\u7a0a\ue453\u6ef3\ue933\u1345\u9d80\u046b\u8e75\u088b\ub2c9\u3d0a\ua7b9\u21c4\ua85b\ud209\u5cb8"), a.c(-1377249660, "\ud6e8\uaf56\u2589\ubbf1\u302e\ub6a4\u0c9b\u8560\u1b32\u9186"), a.b("\u5468", 1570591791));
    private static final Field qel = vxr.find(ClientPlayerEntity.class, a.c(709615511, "\udfee\ua654\u2c96\ub2bd\u3929\ubf9c\u05c8\u8c32\u126b\u98cb\u1f0b\ue57d\u6bb8\uf253\u784d\ufeb3\u44f1\ucb32\u5181\ud7fc\u5e63\u2431\uaa80"), a.c(-1832242657, "\u3273\u4bcd\uc112\u5f6a\ud4b5\u523f\ue800\u61fb\uffaf\u7519"), a.d("\u654e", -1690170895, 1491758328));
    private static final double qem = 0.9;
    private static final int qen = 3;
    private static final int qeo = 6;
    private final Random qep = new Random();
    private final qnd qeq = new qnd();
    private final qsc qer = new qsc();
    private final qln qes = new qln();
    private final qrm qet = new qrm();
    private boolean qeu;
    private final LongOpenHashSet qev = new LongOpenHashSet();
    private final Long2LongOpenHashMap qew = new Long2LongOpenHashMap();
    private final LongOpenHashSet qex = new LongOpenHashSet();
    private final List<qcu> qey = new ArrayList<qcu>();
    private final Long2IntOpenHashMap qez = new Long2IntOpenHashMap();
    private final Long2IntOpenHashMap qfa = new Long2IntOpenHashMap();
    private final Long2IntOpenHashMap qfb = new Long2IntOpenHashMap();
    private final LongOpenHashSet qfc = new LongOpenHashSet();
    private final List<qdo> qfd = new ArrayList<qdo>();
    public static volatile Consumer<String> trace;
    private Predicate<BlockState> qfe = blockState -> false;
    private Predicate<ItemStack> qff = itemStack -> false;
    private pzc qfg;
    private qdw qfh = qdw.IDLE;
    private int qfi;
    private qmx qfj;
    private int qfk;
    private boolean qfl = true;
    private int qfm;
    private int qfn;
    private boolean qfo;
    private int qfp;
    private int qfq;
    private BlockPos qfr;
    private Block qfs;
    private boolean qft;
    private Vec3d qfu;
    private Object qfv;
    private int qfw;
    private Vec3d qfx;
    private boolean qfy;
    private boolean qfz;
    private Vec3d qga;
    private Object qgb;
    private long qgc = Long.MIN_VALUE;
    private boolean qgd;
    private int qge;
    private BlockPos qgf;
    private BlockPos qgg;
    private Direction qgh;
    private float qgi;
    private float qgj;
    private int qgk;
    private boolean qgl;
    private Vec3d qgm;
    private int qgn;
    private int qgo;
    private Vec3d qgp;
    private int qgq;
    private qmh qgr;
    private toq qgs;
    private double qgt;
    private boolean qgu;
    private int qgv;
    private int qgw;
    private boolean qgx;
    private boolean qgy;
    private boolean qgz;
    private boolean qha;
    private boolean qhb;
    private BlockPos qhc;
    private boolean qhd;
    private boolean qhe;
    private boolean qhf;
    private boolean qhg;
    private BlockPos qhh;
    private Vec3d qhi;
    private Object qhj;
    private int qhk;
    private int qhl;
    private Runnable qhm = () -> {};
    private static final int qhn = Integer.MIN_VALUE;
    private int qho = Integer.MIN_VALUE;
    private int qhp;
    private long qhq = Long.MIN_VALUE;
    private int qhr;
    private static final List<Box> qhs;
    private static final int qht = 4;
    private static final int qhu = 14;
    private static final double qhv = 3.6;
    private static final int[][] qhw;
    private static final int qhx = 0;
    private static final int qhy = 1;
    private static final int qhz = 2;
    private static final int qia = 3;
    private static final int qib = 4;
    private static final int qic = 5;
    private static final int qid = 6;
    private final int[] qie = new int[7];
    private int qif = Integer.MIN_VALUE;
    private static final int qig = 4;
    private int qih;
    private int qii = -1;
    private static /* synthetic */ String qij;
    private static /* synthetic */ boolean qik;

    public void configure(qmh qmh2, boolean bl, boolean bl2) {
        this.qgr = qmh2;
        this.qgx = bl;
        this.qgy = bl2;
        this.qes.wide(bl2);
        this.qeq.tune(bl ? 3.6f : 4.6f, qmh2 == null ? 4.0f : (bl2 ? 0.8f : 1.5f), qmh2 != null ? qmh2.cap() : 22.0, bl2 ? 0.6f : 0.0f);
    }

    public void target(Predicate<BlockState> predicate) {
        this.qfe = predicate;
    }

    public void brain(ttb ttb2) {
        if (ttb2 == null) {
            this.qgs = null;
            this.qgu = false;
        } else if (this.qgs == null || this.qgs.model != ttb2) {
            this.qgs = new toq(ttb2);
        }
        if (this.qgs != null) {
            this.qgs.boost(this.qgt);
        }
    }

    public void boost(double d) {
        this.qgt = d;
        if (this.qgs != null) {
            this.qgs.boost(d);
        }
    }

    public boolean hasBrain() {
        return this.qgs != null;
    }

    public toq brain() {
        return this.qgs;
    }

    private double qil() {
        return this.qgr != null ? this.qgr.cap() : (this.qgs != null ? this.qgs.turnRate() : 22.0);
    }

    private static double qim(ClientPlayerEntity clientPlayerEntity, Vec3d vec3d) {
        Vec3d vec3d2 = vec3d.subtract(clientPlayerEntity.getEyePos());
        double d = tbp.yawTo(vec3d2.x, vec3d2.z);
        double d2 = tbp.pitchTo(vec3d2.y, Math.sqrt(vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z));
        return Math.hypot(MathHelper.wrapDegrees((double)(d - (double)clientPlayerEntity.getYaw())), d2 - (double)clientPlayerEntity.getPitch());
    }

    public void predict(boolean bl, MinecraftClient minecraftClient) {
        if (this.qeu && !bl && minecraftClient != null) {
            this.qet.restore((World)minecraftClient.world);
        }
        this.qeu = bl;
    }

    public void echo(Packet<?> packet) {
        this.qet.echo(packet);
    }

    public String predicted() {
        return this.qet.describe();
    }

    public void junk(Predicate<ItemStack> predicate) {
        this.qff = predicate;
    }

    public void onSit(Runnable runnable) {
        this.qhm = runnable;
    }

    public void park(pzc pzc2, BlockPos blockPos, boolean bl) {
        this.start(pzc2);
        this.qhc = blockPos.toImmutable();
        this.qhg = bl;
    }

    public boolean parking() {
        return this.qhc != null;
    }

    public boolean parked() {
        return this.qhc != null && this.qhd;
    }

    public boolean parkLost() {
        return this.qhc != null && this.qhe;
    }

    public void guard(pzc pzc2) {
        this.start(pzc2);
        this.qhf = true;
    }

    public boolean guarding() {
        return this.qhf && this.qfh == qdw.WORKING;
    }

    public void start(pzc pzc2) {
        this.qhf = false;
        this.qhc = null;
        this.qhd = false;
        this.qhe = false;
        this.qhh = null;
        this.qhi = null;
        this.qhk = 0;
        this.qhl = 0;
        this.qho = Integer.MIN_VALUE;
        this.qhq = Long.MIN_VALUE;
        this.qhr = 0;
        this.qif = Integer.MIN_VALUE;
        this.qii = -1;
        this.qih = 0;
        if (this.qfg == null || pzc2 == null || !this.qfg.covers(pzc2) || !pzc2.covers(this.qfg)) {
            this.qev.clear();
        }
        this.qfa.clear();
        this.qez.clear();
        this.qer.clear();
        this.qfg = pzc2;
        this.qfh = pzc2 == null ? qdw.IDLE : qdw.WORKING;
        this.qew.clear();
        this.qfb.clear();
        this.qey.clear();
        this.qfd.clear();
        this.qfc.clear();
        this.qfj = null;
        this.qfl = true;
        this.qfn = 0;
        this.qfo = false;
        this.qfr = null;
        this.qfx = null;
        this.qgo = 0;
    }

    public void avoid(Vec3d vec3d, int n) {
        this.qgp = vec3d;
        this.qgq = this.qfi + n;
        this.qfl = true;
    }

    public pzc area() {
        return this.qfg;
    }

    public qdw status() {
        return this.qfh;
    }

    public int mined() {
        return this.qfp;
    }

    public int reverts() {
        return this.qfq;
    }

    public boolean breaking() {
        return this.qfr != null;
    }

    public String dozer() {
        return this.qes.describe();
    }

    public BlockPos focus() {
        if (this.qfh != qdw.WORKING || this.qhc != null || this.qhf) {
            return null;
        }
        if (this.qfr != null && this.qft) {
            return this.qfr;
        }
        return this.qfj == null ? null : this.qfj.target();
    }

    public String action() {
        if (this.qfr != null) {
            return a.b("\uccdb\ub57a\u3fbe\ua1cb\u2a16\uacec", 262851775) + this.qfr.toShortString() + a.c(1916832265, "\u8a2c\uf3dc\u7907\ue772\u6ce8") + qdz.qin(this.qfu);
        }
        if (this.qfx != null) {
            return a.c(-550039396, "\u10ee\u6949\ue397\u7de1\uf67d") + qdz.qin(this.qfx) + a.c(327677930, "\uf7cc\u8e31\u04e1\u9a90\u1143\u97b9") + qdz.qin(this.qga);
        }
        return a.c(-1713369827, "\u0d77\u74c7\ufe15\u606f");
    }

    private static String qin(Vec3d vec3d) {
        return vec3d == null ? a.d("\ucade", -819785257, 1821563685) : String.format(Locale.ROOT, a.c(681747764, "\ua51f\udca5\u566a\uc84f\u43d2\uc56a\u7f32\uf6df\u68d4\ue22f\u65f5\u9f8f\u1144\u88a1"), vec3d.x, vec3d.y, vec3d.z);
    }

    public void resetCounters() {
        this.qfp = 0;
        this.qfq = 0;
        Arrays.fill(this.qie, 0);
    }

    public void stop(MinecraftClient minecraftClient) {
        this.qfh = qdw.IDLE;
        this.qer.clear();
        this.qfg = null;
        this.qfj = null;
        this.qfr = null;
        this.qfx = null;
        this.qfc.clear();
        if (minecraftClient != null) {
            this.qet.restore((World)minecraftClient.world);
        }
        this.releaseKeys(minecraftClient);
    }

    public void endTick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, tel tel2) {
        Vec3d vec3d;
        ++this.qfi;
        this.qgu = false;
        ClientWorld clientWorld = minecraftClient.world;
        if (clientWorld != null) {
            this.qet.tick((World)clientWorld, this.qfi);
        }
        if (this.qfg == null || clientWorld == null || this.qfh == qdw.IDLE) {
            this.qiq(minecraftClient, clientPlayerEntity, tel2, null, null);
            return;
        }
        qdz.qkz((World)clientWorld, clientPlayerEntity);
        this.qlh((World)clientWorld);
        this.qjc((World)clientWorld, clientPlayerEntity);
        this.qfd.removeIf(qdo2 -> this.qfi - qdo2.tick() > this.qes.lag() + 6);
        if (this.qgs != null) {
            this.qgs.tick((World)clientWorld, clientPlayerEntity, this.qfg);
        }
        if (this.qfg.distanceTo(clientPlayerEntity.getEntityPos()) > 40.0) {
            this.qfh = qdw.FAR;
            this.qfr = null;
            this.qfx = null;
            this.qiq(minecraftClient, clientPlayerEntity, tel2, null, null);
            return;
        }
        if (minecraftClient.currentScreen != null || !clientPlayerEntity.isAlive()) {
            this.qfr = null;
            this.qfx = null;
            this.qiq(minecraftClient, clientPlayerEntity, tel2, null, null);
            return;
        }
        this.qlg(clientPlayerEntity);
        if (this.qfr != null && this.qhc == null && !this.qhf) {
            this.qjf(6);
        }
        if (this.qfr != null && !this.qiy((World)clientWorld, clientPlayerEntity)) {
            this.qfr = null;
            this.qfl = this.qfl || this.qgr == null;
        }
        this.qes.tick(this.qfi, arg_0 -> this.lambda$endTick$4((World)clientWorld, arg_0));
        BlockPos blockPos = qdz.trapped((World)clientWorld, clientPlayerEntity);
        if (blockPos != null && this.qfg.maxX >= this.qfg.minX && !this.qfg.contains(blockPos)) {
            blockPos = null;
        }
        if (blockPos != null && !blockPos.equals((Object)this.qfr)) {
            this.qlj(a.b("\u1960\u60d7\uea17\u7477\uffa0\u7904\uc356\u4ae3\ud4f5\u5e43\ud9de", -2055792353) + blockPos.toShortString());
            this.qku(blockPos, clientWorld.getBlockState(blockPos).getBlock(), false, qdz.qkw(clientPlayerEntity, blockPos));
            vec3d = clientPlayerEntity.getInventory();
            if (!clientPlayerEntity.getMainHandStack().isIn(ItemTags.PICKAXES)) {
                for (int i = 0; i < 9; ++i) {
                    if (!vec3d.getStack(i).isIn(ItemTags.PICKAXES)) continue;
                    vec3d.setSelectedSlot(i);
                    break;
                }
            }
        }
        if (this.qfr == null) {
            this.qjd((World)clientWorld, clientPlayerEntity);
        }
        if (this.qhd && this.qhg && this.qfr == null && this.qfx == null && !clientPlayerEntity.hasVehicle()) {
            this.qiu((World)clientWorld, clientPlayerEntity);
            vec3d = clientPlayerEntity.getEyePos();
            if (this.qhi != null && Math.hypot(this.qhi.x - vec3d.x, this.qhi.z - vec3d.z) > 1.2) {
                this.qiq(minecraftClient, clientPlayerEntity, tel2, this.qhj, new Vec3d(this.qhi.x, vec3d.y - 0.35, this.qhi.z));
            } else {
                this.qiq(minecraftClient, clientPlayerEntity, tel2, null, null);
            }
            return;
        }
        if (this.qfr != null) {
            if (!this.qgz) {
                this.qfx = null;
            }
            this.qiq(minecraftClient, clientPlayerEntity, tel2, this.qfv, this.qfu);
            if (this.qgr == null) {
                this.qir(minecraftClient, clientPlayerEntity, tel2);
            }
        } else if (this.qga != null) {
            this.qiq(minecraftClient, clientPlayerEntity, tel2, this.qgb, this.qga);
        } else {
            this.qiq(minecraftClient, clientPlayerEntity, tel2, null, null);
        }
        this.qio((World)clientWorld, clientPlayerEntity);
    }

    private void qio(World world, ClientPlayerEntity clientPlayerEntity) {
        this.qgu = false;
        if (this.qgs == null) {
            return;
        }
        boolean bl = this.qgs.hasLegs() && this.qgr == null && this.qhc == null && !this.qhf && this.qfg.maxX >= this.qfg.minX && this.qho == Integer.MIN_VALUE && this.qfx == null && this.qfi >= this.qgw && !clientPlayerEntity.hasVehicle();
        double d = clientPlayerEntity.getX();
        double d2 = clientPlayerEntity.getZ();
        if (bl && (d < (double)this.qfg.minX - 0.5 || d > (double)this.qfg.maxX + 1.5 || d2 < (double)this.qfg.minZ - 0.5 || d2 > (double)this.qfg.maxZ + 1.5)) {
            bl = false;
        }
        if (!bl) {
            this.qgs.stopLegs();
            this.qgv = 0;
            return;
        }
        int n = this.qgs.move();
        double d3 = Math.hypot(clientPlayerEntity.getX() - clientPlayerEntity.lastX, clientPlayerEntity.getZ() - clientPlayerEntity.lastZ);
        if (n != 0 && d3 < 0.02) {
            if (++this.qgv >= 20) {
                this.qgv = 0;
                this.qgw = this.qfi + 30;
                this.qgs.stopLegs();
                this.qlj(a.d("\u3dc4\u447c\ucead\u50c8\udb4c\u5dae\ue7fa\u6e0a\uf043\u7afa\ufd62\u0752\u8990\u1075", 1504850795, -1538978099) + clientPlayerEntity.getBlockPos().toShortString());
                return;
            }
        } else {
            this.qgv = 0;
        }
        this.qgs.planLegs(world, clientPlayerEntity, this.qfr);
        this.qgu = true;
    }

    private static boolean qip(World world, ClientPlayerEntity clientPlayerEntity, int n) {
        double d;
        double d2 = Math.toRadians(clientPlayerEntity.getYaw());
        double d3 = (double)trj.FWD[n] * -Math.sin(d2) + (double)trj.LEFT[n] * Math.cos(d2);
        double d4 = Math.hypot(d3, d = (double)trj.FWD[n] * Math.cos(d2) + (double)trj.LEFT[n] * Math.sin(d2));
        if (d4 < 1.0E-6) {
            return false;
        }
        int n2 = MathHelper.floor((double)(clientPlayerEntity.getX() + d3 / d4 * 0.9));
        int n3 = MathHelper.floor((double)(clientPlayerEntity.getZ() + d / d4 * 0.9));
        int n4 = qdz.standing(world, clientPlayerEntity).getY();
        for (int i = n4 - 1; i >= n4 - 4; --i) {
            if (qdz.qjs(world, new BlockPos(n2, i, n3))) continue;
            return false;
        }
        return true;
    }

    private void qiq(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, tel tel2, Object object, Vec3d vec3d) {
        if (this.qgr != null) {
            tel2.assistAt(minecraftClient, clientPlayerEntity, null, null, 1);
            this.qgr.aim(minecraftClient, clientPlayerEntity, object, vec3d);
        } else if (this.qgs != null && object != null && object == this.qfv && this.qfr != null) {
            tel2.assistBlock(minecraftClient, clientPlayerEntity, object, new Box(this.qfr), vec3d, -1);
        } else {
            tel2.assistAt(minecraftClient, clientPlayerEntity, object, vec3d, this.qgs != null ? -1 : 1);
        }
    }

    private void qir(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, tel tel2) {
        double d;
        if (this.qgk < 3 || this.qfi - this.qfw < 4) {
            return;
        }
        Vec3d vec3d = this.qfu.subtract(clientPlayerEntity.getEyePos());
        double d2 = tbp.yawTo(vec3d.x, vec3d.z);
        double d3 = tbp.pitchTo(vec3d.y, Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z));
        double d4 = MathHelper.wrapDegrees((double)(d2 - (double)clientPlayerEntity.getYaw()));
        double d5 = Math.hypot(d4, d = d3 - (double)clientPlayerEntity.getPitch());
        if (d5 > 9.0 || d5 < 0.05) {
            return;
        }
        double d6 = Math.min(0.55 + this.qep.nextDouble() * 0.3, Math.min(3.5, tel2.budgetLeft()) / d5);
        if (d6 <= 0.0) {
            return;
        }
        double d7 = tcz.unit(minecraftClient);
        if (d7 <= 0.0) {
            return;
        }
        long l = Math.round(d4 * d6 / d7);
        long l2 = Math.round(d * d6 / d7);
        if (l == 0L && l2 == 0L) {
            if (Math.abs(d4) >= Math.abs(d)) {
                l = (long)Math.signum(d4);
            } else {
                l2 = (long)Math.signum(d);
            }
        }
        double d8 = d7 / 0.15;
        clientPlayerEntity.changeLookDirection((double)l * d8, (double)l2 * d8);
        tel2.spent(Math.hypot((double)l * d7, (double)l2 * d7));
    }

    public void startTick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d;
        if (this.qfh != qdw.WORKING || minecraftClient.currentScreen != null || clientPlayerEntity == null || !clientPlayerEntity.isAlive()) {
            this.releaseKeys(minecraftClient);
            return;
        }
        GameOptions gameOptions = minecraftClient.options;
        if (clientPlayerEntity.hasVehicle() && this.qhc == null) {
            gameOptions.forwardKey.setPressed(false);
            gameOptions.backKey.setPressed(false);
            gameOptions.leftKey.setPressed(false);
            gameOptions.rightKey.setPressed(false);
            gameOptions.jumpKey.setPressed(false);
            this.qix(minecraftClient, false);
            this.qis(minecraftClient, true);
            this.qgl = true;
            if (this.qgd) {
                gameOptions.attackKey.setPressed(false);
                this.qgd = false;
            }
            return;
        }
        if (this.qhb) {
            this.qis(minecraftClient, false);
        }
        if (this.qhd && this.qhg && !clientPlayerEntity.hasVehicle()) {
            this.qit(minecraftClient, clientPlayerEntity);
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        if ((this.qfr == null || this.qgz) && this.qfx != null) {
            boolean bl8;
            vec3d = clientPlayerEntity.getEntityPos();
            double d = this.qfx.x - vec3d.x;
            double d2 = this.qfx.z - vec3d.z;
            double d3 = Math.sqrt(d * d + d2 * d2);
            Vec3d vec3d2 = clientPlayerEntity.getVelocity();
            double d4 = Math.sqrt(vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z);
            boolean bl9 = bl8 = this.qfz && clientPlayerEntity.isOnGround() && d3 < d4 * 1.3 + 0.05;
            if (d3 > 0.12 && !bl8) {
                double d5 = tbp.yawTo(d, d2);
                double d6 = MathHelper.wrapDegrees((double)(d5 - (double)clientPlayerEntity.getYaw()));
                bl = Math.abs(d6) < 67.5;
                bl2 = Math.abs(d6) > 112.5;
                bl4 = d6 > 22.5 && d6 < 157.5;
                bl3 = d6 < -22.5 && d6 > -157.5;
            }
            bl6 = this.qfz && d3 < 1.6;
            bl5 = this.qfy && clientPlayerEntity.isOnGround() && d3 < 1.25 || this.qgn >= 10 && this.qgn % 10 == 0 && clientPlayerEntity.isOnGround() && (bl || bl2 || bl3 || bl4);
        } else if (this.qgu && this.qgs != null && minecraftClient.world != null) {
            int n = this.qgs.move();
            bl = trj.FWD[n] > 0;
            bl2 = trj.FWD[n] < 0;
            bl3 = trj.LEFT[n] > 0;
            boolean bl10 = bl4 = trj.LEFT[n] < 0;
            if ((bl || bl2 || bl3 || bl4) && qdz.qip((World)minecraftClient.world, clientPlayerEntity, n)) {
                bl4 = false;
                bl3 = false;
                bl2 = false;
                bl = false;
            }
            bl5 = this.qgs.jump() && clientPlayerEntity.isOnGround();
            bl7 = true;
        }
        gameOptions.forwardKey.setPressed(bl);
        gameOptions.backKey.setPressed(bl2);
        gameOptions.leftKey.setPressed(bl3);
        gameOptions.rightKey.setPressed(bl4);
        gameOptions.jumpKey.setPressed(bl5);
        boolean bl11 = this.qgl = bl || bl2 || bl3 || bl4 || bl5;
        this.qix(minecraftClient, bl7 ? this.qgs.sprint() && bl && !bl2 : this.qgx && bl && !bl2 && !bl6);
        vec3d = gameOptions.attackKey;
        boolean bl12 = false;
        BlockHitResult blockHitResult = null;
        if (this.qfr != null) {
            minecraftClient.gameRenderer.updateCrosshairTarget(1.0f);
            HitResult hitResult = minecraftClient.crosshairTarget;
            if (hitResult instanceof BlockHitResult) {
                BlockHitResult blockHitResult2 = (BlockHitResult)hitResult;
                if (hitResult.getType() == HitResult.Type.BLOCK && blockHitResult2.getBlockPos().equals((Object)this.qfr)) {
                    bl12 = true;
                    blockHitResult = blockHitResult2;
                }
            }
        }
        if (bl12 && this.qhr > 0) {
            --this.qhr;
            bl12 = false;
            this.qgk = 0;
            if (this.qgd) {
                vec3d.setPressed(false);
                this.qgd = false;
            }
            return;
        }
        int n = this.qgk = this.qfr == null || bl12 ? 0 : this.qgk + 1;
        if (bl12 && this.qgd && this.qfr.equals((Object)this.qgf) && !minecraftClient.interactionManager.isBreakingBlock()) {
            if (++this.qge >= 2) {
                this.qge = 0;
                bl12 = false;
                this.qgf = null;
            }
        } else {
            this.qge = 0;
        }
        if (bl12) {
            if (!this.qfr.equals((Object)this.qgf)) {
                InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)vec3d);
                if (!key.equals((Object)InputUtil.UNKNOWN_KEY)) {
                    KeyBinding.onKeyPressed((InputUtil.Key)key);
                }
                this.qgg = this.qgf = this.qfr.toImmutable();
                this.qgh = blockHitResult.getSide();
                this.qgi = vxr.getFloat(qek, clientPlayerEntity, clientPlayerEntity.getYaw());
                this.qgj = vxr.getFloat(qel, clientPlayerEntity, clientPlayerEntity.getPitch());
            }
            vec3d.setPressed(true);
            this.qgd = true;
        } else if (this.qgd) {
            vec3d.setPressed(false);
            this.qgd = false;
        }
    }

    private void qis(MinecraftClient minecraftClient, boolean bl) {
        KeyBinding keyBinding = minecraftClient.options.sneakKey;
        if (((Boolean)minecraftClient.options.getSneakToggled().getValue()).booleanValue()) {
            if (bl != keyBinding.isPressed()) {
                keyBinding.setPressed(true);
            }
        } else {
            keyBinding.setPressed(bl);
        }
        this.qhb = bl;
    }

    private void qit(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        GameOptions gameOptions = minecraftClient.options;
        this.qix(minecraftClient, false);
        if (this.qgd) {
            gameOptions.attackKey.setPressed(false);
            this.qgd = false;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        if (this.qhi != null && this.qhk < 3) {
            double d = this.qhi.x - clientPlayerEntity.getX();
            double d2 = this.qhi.z - clientPlayerEntity.getZ();
            double d3 = Math.sqrt(d * d + d2 * d2);
            Vec3d vec3d = clientPlayerEntity.getVelocity();
            double d4 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
            if (d3 > 0.2) {
                boolean bl7;
                double d5 = MathHelper.wrapDegrees((double)(tbp.yawTo(d, d2) - (double)clientPlayerEntity.getYaw()));
                boolean bl8 = bl7 = clientPlayerEntity.isOnGround() && d3 < d4 * 1.5 + 0.04;
                if (!bl7) {
                    bl = Math.abs(d5) < 67.5;
                    bl2 = Math.abs(d5) > 112.5;
                    bl4 = d5 > 22.5 && d5 < 157.5;
                    bl3 = d5 < -22.5 && d5 > -157.5;
                }
                bl6 = d3 < 0.9;
                bl5 = clientPlayerEntity.isOnGround() && clientPlayerEntity.horizontalCollision && this.qhi.y > clientPlayerEntity.getY() + 0.6;
                this.qhl = Math.max(this.qhl, 6);
            } else if (clientPlayerEntity.isOnGround() && d4 < 0.02 && Math.abs(clientPlayerEntity.getX() - clientPlayerEntity.lastX) + Math.abs(clientPlayerEntity.getZ() - clientPlayerEntity.lastZ) < 0.003) {
                if (this.qhl > 0) {
                    --this.qhl;
                } else {
                    this.qhm.run();
                    ++this.qhk;
                    this.qhl = 40;
                    this.qlj(a.b("\uff94\u8679\u0cb0\u92dc\u195f\u9faf\u25e9\uac4c", 1763049395) + clientPlayerEntity.getBlockPos().toShortString() + a.b("\u0f2e\u76cb\ufc1e\u6264\ue9ea", 313003787) + this.qhk);
                }
            }
        }
        gameOptions.forwardKey.setPressed(bl);
        gameOptions.backKey.setPressed(bl2);
        gameOptions.leftKey.setPressed(bl3);
        gameOptions.rightKey.setPressed(bl4);
        gameOptions.jumpKey.setPressed(bl5);
        this.qgl = bl || bl2 || bl3 || bl4 || bl5;
        this.qis(minecraftClient, bl6);
    }

    private void qiu(World world, ClientPlayerEntity clientPlayerEntity) {
        double d;
        Vec3d vec3d;
        if (clientPlayerEntity.hasVehicle() || this.qhc == null) {
            return;
        }
        if (this.qhi != null && (this.qhh == null || qdz.qiw(world.getBlockState(this.qhh)))) {
            return;
        }
        this.qhh = null;
        if (qdz.qiw(world.getBlockState(this.qhc)) && qdz.qiv(world, this.qhc)) {
            this.qhh = this.qhc;
        } else if (qdz.qiw(world.getBlockState(this.qhc.down())) && qdz.qiv(world, this.qhc.down())) {
            this.qhh = this.qhc.down();
        } else {
            vec3d = Vec3d.ofCenter((Vec3i)this.qhc);
            d = Double.MAX_VALUE;
            for (int i = -3; i <= 3; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -3; k <= 3; ++k) {
                        BlockPos blockPos = this.qhc.add(i, j, k);
                        BlockState blockState = world.getBlockState(blockPos);
                        if (!qdz.qiw(blockState) || !qdz.qiv(world, blockPos)) continue;
                        double d2 = Vec3d.ofCenter((Vec3i)blockPos).distanceTo(vec3d) + (blockState.getBlock() instanceof StairsBlock ? 0.0 : 1.5);
                        if (!(d2 < d)) continue;
                        d = d2;
                        this.qhh = blockPos.toImmutable();
                    }
                }
            }
        }
        if (this.qhh != null) {
            vec3d = world.getBlockState(this.qhh).getCollisionShape((BlockView)world, this.qhh);
            d = vec3d.isEmpty() ? 0.0 : vec3d.getMax(Direction.Axis.Y);
            this.qhi = new Vec3d((double)this.qhh.getX() + 0.5, (double)this.qhh.getY() + d, (double)this.qhh.getZ() + 0.5);
        } else {
            this.qhi = new Vec3d((double)this.qhc.getX() + 0.5, (double)this.qhc.getY(), (double)this.qhc.getZ() + 0.5);
        }
        this.qhj = new Object();
        this.qlj(a.d("\u2572\u5cd5\ud602\u4866\uc3e5", -1718510172, 2050734240) + (this.qhh == null ? a.d("\u456e\u3cdc\ub610\u287a\ua3f9", 1785730449, 419385481) + this.qhc.toShortString() : this.qhh.toShortString()));
    }

    private static boolean qiv(World world, BlockPos blockPos) {
        return world.getBlockState(blockPos.up()).getCollisionShape((BlockView)world, blockPos.up()).isEmpty() && world.getBlockState(blockPos.up(2)).getCollisionShape((BlockView)world, blockPos.up(2)).isEmpty();
    }

    private static boolean qiw(BlockState blockState) {
        return blockState.getBlock() instanceof StairsBlock || blockState.getBlock() instanceof SlabBlock;
    }

    private void qix(MinecraftClient minecraftClient, boolean bl) {
        KeyBinding keyBinding = minecraftClient.options.sprintKey;
        if (((Boolean)minecraftClient.options.getSprintToggled().getValue()).booleanValue()) {
            if (bl != keyBinding.isPressed()) {
                keyBinding.setPressed(true);
            }
        } else {
            keyBinding.setPressed(bl);
        }
        this.qha = bl;
    }

    public void releaseKeys(MinecraftClient minecraftClient) {
        if (minecraftClient == null || minecraftClient.options == null || minecraftClient.getWindow() == null) {
            return;
        }
        GameOptions gameOptions = minecraftClient.options;
        if (this.qhb) {
            if (((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
                if (gameOptions.sneakKey.isPressed()) {
                    gameOptions.sneakKey.setPressed(true);
                }
            } else {
                gameOptions.sneakKey.setPressed(vzz.isPhysicallyDown(minecraftClient, gameOptions.sneakKey));
            }
            this.qhb = false;
        }
        if (this.qha) {
            if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
                if (gameOptions.sprintKey.isPressed()) {
                    gameOptions.sprintKey.setPressed(true);
                }
            } else {
                gameOptions.sprintKey.setPressed(vzz.isPhysicallyDown(minecraftClient, gameOptions.sprintKey));
            }
            this.qha = false;
        }
        if (this.qgl) {
            for (KeyBinding keyBinding : new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey}) {
                keyBinding.setPressed(vzz.isPhysicallyDown(minecraftClient, keyBinding));
            }
            this.qgl = false;
        }
        if (this.qgd) {
            gameOptions.attackKey.setPressed(vzz.isPhysicallyDown(minecraftClient, gameOptions.attackKey));
            this.qgd = false;
        }
        this.qgf = null;
    }

    private boolean qiy(World world, ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d;
        BlockState blockState = world.getBlockState(this.qfr);
        if (blockState.isAir() || blockState.getBlock() != this.qfs || !qdz.qld(world, this.qfr)) {
            if (blockState.isAir()) {
                this.qiz(world, clientPlayerEntity);
            }
            return false;
        }
        if (this.qfi - this.qfw > 200 || this.qgk > (this.qgr != null ? 12 : (this.qgs != null ? 14 : 80))) {
            this.qlj((this.qfi - this.qfw > 200 ? a.d("\uc449\ubde8\u372c\ua959\u2284\ua47e\u1e79\u9795\u09ce\u8377\u04ae\ufec5\u7013\ue9f6", 419097087, 1869688282) : a.c(2012211012, "\ue72e\u9e97\u1440\u8a7c\u01ed\u875b\u3d00\ub4f4\u2aa2\ua012\u2785")) + this.qfr.toShortString());
            this.qlf(this.qfr, this.qgr != null ? 100 : (this.qgs != null ? 200 : 600));
            if (this.qfj != null && this.qgr == null && this.qgs == null) {
                this.qlf(this.qfj.target(), 600);
            }
            return false;
        }
        if (this.qgr != null ? this.qgk == 4 || this.qgk == 8 : (this.qgs != null ? this.qgk == 5 || this.qgk == 10 : this.qgk == 30 || this.qgk == 55)) {
            vec3d = this.qkx(world, clientPlayerEntity, this.qfr);
            if (vec3d == null) {
                return false;
            }
            this.qfu = vec3d;
            this.qfv = new Object();
        }
        if (((this.qfi - this.qfw) % 5 == 0 || this.qgr != null && this.qgk > 0) && (this.qfu.distanceTo(vec3d = clientPlayerEntity.getEyePos()) > 4.4 || !qdz.qky(world, clientPlayerEntity, vec3d, this.qfr, this.qfu))) {
            Vec3d vec3d2 = this.qkx(world, clientPlayerEntity, this.qfr);
            if (vec3d2 == null) {
                return false;
            }
            this.qfu = vec3d2;
        }
        return true;
    }

    private void qiz(World world, ClientPlayerEntity clientPlayerEntity) {
        long l2 = this.qfr.asLong();
        this.qey.add(new qcu(l2, this.qfs, this.qfi));
        if (!this.qgy || this.qgh == null || !this.qfr.equals((Object)this.qgg)) {
            LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
            longOpenHashSet.add(l2);
            this.qes.exclude(longOpenHashSet);
            return;
        }
        this.qgg = null;
        int n = this.qgh.getAxis().ordinal();
        double[] dArray = qln.lookAxes(this.qgi, this.qgj);
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        int n2 = this.qes.lag() + 3;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    if (i == 0 && j == 0 && k == 0) continue;
                    int[] nArray = new int[]{i, j, k};
                    boolean bl = nArray[n] == 0;
                    for (int i2 = 0; i2 < 3 && !bl; ++i2) {
                        bl = dArray[i2] > 0.0 && nArray[i2] == 0;
                    }
                    long l3 = BlockPos.add((long)l2, (int)i, (int)j, (int)k);
                    if (!bl || !this.qfg.contains(BlockPos.unpackLongX((long)l3), BlockPos.unpackLongY((long)l3), BlockPos.unpackLongZ((long)l3))) continue;
                    longOpenHashSet.add(l3);
                    if (!(this.qes.expect(l3, l2, n, dArray) >= 0.5)) continue;
                    this.qfb.put(l3, this.qfi + n2);
                }
            }
        }
        longOpenHashSet.add(l2);
        this.qes.exclude(longOpenHashSet);
        if (!this.qes.probing()) {
            LongOpenHashSet longOpenHashSet2 = new LongOpenHashSet();
            for (qdo qdo2 : this.qfd) {
                longOpenHashSet2.addAll((LongCollection)qdo2.blocks());
            }
            this.qes.open(l2, this.qfi, n, dArray, l -> this.qjb(world, l), longOpenHashSet2);
        }
        this.qfd.add(new qdo(this.qfi, longOpenHashSet));
        this.qja(world, clientPlayerEntity, l2, n, dArray, longOpenHashSet);
    }

    private void qja(World world, ClientPlayerEntity clientPlayerEntity, long l, int n, double[] dArray, LongOpenHashSet longOpenHashSet) {
        if (!this.qeu || this.qes.votes() < 3 || clientPlayerEntity == null) {
            return;
        }
        LongOpenHashSet longOpenHashSet2 = qdz.qjp(world, clientPlayerEntity, qdz.standing(world, clientPlayerEntity).getY());
        Box box = clientPlayerEntity.getBoundingBox().expand(0.05);
        int n2 = this.qfi + this.qes.lag() * 2 + 6;
        LongIterator longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            BlockPos blockPos;
            long l2 = longIterator.nextLong();
            if (l2 == l || longOpenHashSet2.contains(l2) || !this.qjb(world, l2) || this.qes.expect(l2, l, n, dArray) < 0.9 || new Box(blockPos = BlockPos.fromLong((long)l2)).intersects(box)) continue;
            this.qet.ghost(world, blockPos, n2);
        }
    }

    private boolean qjb(World world, long l) {
        BlockPos blockPos = BlockPos.fromLong((long)l);
        if (this.qfg == null || !this.qfg.contains(blockPos) || this.qev.contains(l)) {
            return false;
        }
        BlockState blockState = world.getBlockState(blockPos);
        return !blockState.isAir() && blockState.getFluidState().isEmpty() && blockState.getHardness((BlockView)world, blockPos) >= 0.0f;
    }

    private void qjc(World world, ClientPlayerEntity clientPlayerEntity) {
        if (this.qfc.isEmpty()) {
            return;
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        LongIterator longIterator = this.qfc.iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.nextLong();
            BlockPos blockPos = BlockPos.fromLong((long)l);
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isAir()) {
                if (this.qet.isGhost(l)) continue;
                ++this.qfp;
                longIterator.remove();
                continue;
            }
            if (this.qfe.test(blockState) && !(Vec3d.ofCenter((Vec3i)blockPos).squaredDistanceTo(vec3d) > 81.0)) continue;
            longIterator.remove();
        }
    }

    private void qjd(World world, ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        if (this.qhf) {
            this.qfx = null;
            this.qga = null;
            return;
        }
        if (this.qhc != null && this.qhd && qdz.standing(world, clientPlayerEntity).getSquaredDistance((Vec3i)this.qhc) <= 25.0) {
            this.qfx = null;
            this.qga = null;
            return;
        }
        if (this.qhc == null && (this.qgr != null || this.qgs != null) && this.qfg.maxX >= this.qfg.minX) {
            this.qje(world, clientPlayerEntity);
            return;
        }
        if (this.qhc == null && this.qgr != null && this.qke(world, clientPlayerEntity)) {
            this.qfn = 0;
            return;
        }
        if (!(clientPlayerEntity.isOnGround() || clientPlayerEntity.isTouchingWater() || clientPlayerEntity.isClimbing())) {
            return;
        }
        BlockPos blockPos = qdz.standing(world, clientPlayerEntity);
        if (this.qfj != null && !this.qfl && this.qfi < this.qfm) {
            int n = this.qkm(blockPos);
            if (n < 0) {
                this.qlj(a.d("\ud0cd\ua975\u23a6\ubd91\u3616\ub0b6\u0af0\u831d\u1d0a\u97fa\u103c\uea19", -142309247, 481187887) + blockPos.toShortString());
                this.qfl = true;
            } else {
                this.qfk = n;
            }
        }
        if (this.qhc == null && this.qfj != null && !this.qfl && !this.qkr(world, this.qfj.target())) {
            this.qlj(a.d("\ub71f\ucebb\u447b\uda1f\u51ca\ud76a\u6d6d\ue4db\u7a8c\uf03c\u77e4\u8dd0", 1816040736, 167584327) + this.qfj.target().toShortString());
            this.qfl = true;
        }
        if (this.qfj == null || this.qfl || this.qfi >= this.qfm) {
            this.qkq(world, clientPlayerEntity);
        }
        if (this.qhc != null) {
            if (this.qfj == null) {
                this.qfx = null;
                this.qga = null;
                if (blockPos.getSquaredDistance((Vec3i)this.qhc) <= 25.0) {
                    this.qhd = true;
                } else if (!this.qhd) {
                    this.qhe = true;
                }
                return;
            }
            if (this.qfk >= this.qkl() - 1) {
                if (!this.qhd) {
                    this.qlj(a.d("\u8fc6\uf666\u7ca6\ue2ce\u6917\uefa7\u55b0\udc00\u424a\uc8af", 1472536667, -1142247449) + blockPos.toShortString());
                }
                this.qhd = true;
                this.qfx = null;
                this.qga = null;
                return;
            }
            this.qhd = false;
            this.qjw(world, clientPlayerEntity, false);
            return;
        }
        if (this.qfj == null) {
            this.qfx = null;
            this.qga = null;
            if (!this.qfo && ++this.qfn > 30) {
                this.qfh = qdw.DONE;
            }
            return;
        }
        this.qfn = 0;
        BlockPos blockPos2 = this.qfj.target();
        if (this.qfb.getOrDefault(blockPos2.asLong(), 0) > this.qfi) {
            this.qfx = null;
            return;
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        boolean bl2 = bl = this.qfk >= this.qkl() - 1;
        if (bl || Vec3d.ofCenter((Vec3i)blockPos2).distanceTo(vec3d) <= 4.2) {
            Vec3d vec3d2 = this.qkx(world, clientPlayerEntity, blockPos2);
            if (vec3d2 != null) {
                this.qku(blockPos2, world.getBlockState(blockPos2).getBlock(), true, vec3d2);
                return;
            }
            if (bl) {
                BlockPos blockPos3 = qdz.qla(world, clientPlayerEntity, vec3d, blockPos2);
                if (blockPos3 != null && this.qlc(world, blockPos3)) {
                    this.qkt(world, clientPlayerEntity, blockPos3, false);
                    if (this.qfr != null) {
                        return;
                    }
                }
                this.qlf(blockPos2, 400);
                this.qfl = true;
                this.qfx = null;
                return;
            }
        }
        this.qjw(world, clientPlayerEntity, true);
    }

    private void qje(World world, ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        boolean bl2;
        boolean bl3 = bl2 = clientPlayerEntity.isOnGround() || clientPlayerEntity.isTouchingWater() || clientPlayerEntity.isClimbing();
        if (!bl2) {
            int n;
            this.qfx = null;
            this.qga = null;
            if (this.qho != Integer.MIN_VALUE && (n = this.qjj(world, clientPlayerEntity)) != Integer.MIN_VALUE && n + 1 > this.qho) {
                this.qjk(world, clientPlayerEntity, this.qji(world, clientPlayerEntity, n));
            }
            this.qjf(4);
            return;
        }
        BlockPos blockPos = qdz.standing(world, clientPlayerEntity);
        int n = blockPos.getY();
        if (this.qho != Integer.MIN_VALUE) {
            if (n > this.qho && this.qjk(world, clientPlayerEntity, this.qji(world, clientPlayerEntity, n - 1))) {
                this.qfn = 0;
                this.qjf(3);
                return;
            }
            this.qho = Integer.MIN_VALUE;
        }
        if (this.qfi >= this.qih) {
            this.qih = this.qfi + 20;
            this.qii = this.qjg(world);
        }
        if (this.qii >= 0 && this.qii <= 4) {
            this.qlj(a.d("\u67b4\u1e04\u94d5\u0ab1\u813f", -1744326495, 1724438399) + this.qii + a.b("\u83d3\ufa26\u70f8\uee81\u655a\ue3e9\u59bb\ud040\u4e08\uc4ea\u4375\ub90d\u37d9\uae7a\u2467\ua28c\u1887\u975d\u0def\u8bb5", 375161831));
            this.qfx = null;
            this.qga = null;
            this.qfh = qdw.DONE;
            return;
        }
        boolean bl4 = bl = this.qfx != null && this.qfi - this.qhp < 8;
        if (this.qgs != null ? this.qjm(world, clientPlayerEntity, n, bl) || this.qjl(world, clientPlayerEntity, n, bl) : this.qjl(world, clientPlayerEntity, n, bl)) {
            this.qfn = 0;
            this.qjf(0);
            return;
        }
        if (this.qjt(world, clientPlayerEntity, n)) {
            this.qfn = 0;
            this.qjf(1);
            return;
        }
        if (this.qjh(world, n)) {
            this.qjf(5);
            return;
        }
        if (n > this.qfg.minY) {
            BlockPos blockPos2 = this.qji(world, clientPlayerEntity, n - 1);
            if (blockPos2 != null && this.qjk(world, clientPlayerEntity, blockPos2)) {
                this.qho = Math.max(this.qfg.minY, n - 3);
                this.qfn = 0;
                this.qlj(a.d("\u4659\u3fe3\ub528\u2b40\ua0d9\u262e\u9c69\u1585\u8bd8\u0124", -1066751725, -636358876) + n + a.c(-1990803626, "\ubf72\uc697\u4c5f\ud261") + this.qho);
                this.qjf(3);
                return;
            }
            if (this.qju(world, clientPlayerEntity, n)) {
                this.qfn = 0;
                this.qjf(1);
                return;
            }
        }
        this.qfx = null;
        this.qga = null;
        this.qjf(5);
        if (++this.qfn > 30) {
            this.qfh = qdw.DONE;
        }
    }

    private void qjf(int n) {
        int n2 = n;
        this.qie[n2] = this.qie[n2] + 1;
    }

    private int qjg(World world) {
        int n = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = this.qfg.minX; i <= this.qfg.maxX; ++i) {
            for (int j = this.qfg.minZ; j <= this.qfg.maxZ; ++j) {
                for (int k = this.qfg.minY; k <= this.qfg.maxY; ++k) {
                    if (!this.qfe.test(world.getBlockState((BlockPos)mutable.set(i, k, j))) || this.qev.contains(mutable.asLong())) continue;
                    ++n;
                }
            }
        }
        return n;
    }

    public int diamondsLeft() {
        return this.qii;
    }

    public String sweepStats() {
        String[] stringArray = new String[]{a.b("\uc44e\ubde6\u373f\ua946", 1490011194), a.b("\u6306\u1aa1\u907f\u0e09", 103310197), a.c(1836456759, "\u1b53\u62ee\ue83e\u764f\ufd91\u7b26\uc162"), a.c(-224282623, "\ub861\uc1db\u4b10\ud578"), a.c(-414068310, "\ud1c8\ua87e\u22a0\ubcd1"), a.c(-43629126, "\u45d7\u3c6b\ub6b0\u28c8"), a.c(1320217503, "\uebf5\u9254\u1890\u86e5\u0d38\u8b8b\u31df\ub827")};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; ++i) {
            stringBuilder.append(stringArray[i]).append(' ').append(this.qie[i]).append(i + 1 < stringArray.length ? a.b("\ua6ad", 367896204) : "");
        }
        return stringBuilder.toString();
    }

    private boolean qjh(World world, int n) {
        if (this.qif == n) {
            return false;
        }
        this.qif = n;
        boolean bl = false;
        int n2 = Math.min(this.qfg.maxY, n + 4);
        ObjectIterator objectIterator = this.qew.long2LongEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            Long2LongMap.Entry entry = (Long2LongMap.Entry)objectIterator.next();
            int n3 = BlockPos.unpackLongY((long)entry.getLongKey());
            if (entry.getLongValue() <= (long)this.qfi || n3 < n || n3 > n2) continue;
            objectIterator.remove();
            bl = true;
        }
        return bl;
    }

    private BlockPos qji(World world, ClientPlayerEntity clientPlayerEntity, int n) {
        Box box = clientPlayerEntity.getBoundingBox();
        BlockPos blockPos = null;
        double d = Double.MAX_VALUE;
        for (int i = MathHelper.floor((double)(box.minX + 0.001)); i <= MathHelper.floor((double)(box.maxX - 0.001)); ++i) {
            for (int j = MathHelper.floor((double)(box.minZ + 0.001)); j <= MathHelper.floor((double)(box.maxZ - 0.001)); ++j) {
                BlockPos blockPos2 = new BlockPos(i, n, j);
                BlockState blockState = world.getBlockState(blockPos2);
                if (blockState.getCollisionShape((BlockView)world, blockPos2).isEmpty()) continue;
                if (!this.qfg.contains(blockPos2) || !qdz.qjq(world, blockPos2, blockState) || this.qev.contains(blockPos2.asLong()) || this.qew.getOrDefault(blockPos2.asLong(), 0L) > (long)this.qfi) {
                    return null;
                }
                double d2 = ((double)i + 0.5 - clientPlayerEntity.getX()) * ((double)i + 0.5 - clientPlayerEntity.getX()) + ((double)j + 0.5 - clientPlayerEntity.getZ()) * ((double)j + 0.5 - clientPlayerEntity.getZ());
                if (!(d2 < d)) continue;
                d = d2;
                blockPos = blockPos2;
            }
        }
        return blockPos;
    }

    private int qjj(World world, ClientPlayerEntity clientPlayerEntity) {
        int n;
        Box box = clientPlayerEntity.getBoundingBox();
        for (int i = n = MathHelper.floor((double)(clientPlayerEntity.getY() - 0.001)); i >= n - 4; --i) {
            for (int j = MathHelper.floor((double)(box.minX + 0.001)); j <= MathHelper.floor((double)(box.maxX - 0.001)); ++j) {
                for (int k = MathHelper.floor((double)(box.minZ + 0.001)); k <= MathHelper.floor((double)(box.maxZ - 0.001)); ++k) {
                    BlockPos blockPos = new BlockPos(j, i, k);
                    if (world.getBlockState(blockPos).getCollisionShape((BlockView)world, blockPos).isEmpty()) continue;
                    return i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private boolean qjk(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        if (blockPos == null) {
            return false;
        }
        if (this.qfb.getOrDefault(blockPos.asLong(), 0) > this.qfi) {
            this.qfx = null;
            return true;
        }
        Vec3d vec3d = null;
        for (qda qda2 : this.qki(world, clientPlayerEntity, blockPos)) {
            if (qda2.axis() != Direction.Axis.Y.ordinal() || !(qda2.point().y < clientPlayerEntity.getEyeY())) continue;
            vec3d = qda2.point();
            break;
        }
        if (vec3d == null) {
            vec3d = this.qkx(world, clientPlayerEntity, blockPos);
        }
        if (vec3d == null) {
            return false;
        }
        BlockState blockState = world.getBlockState(blockPos);
        this.qku(blockPos, blockState.getBlock(), this.qfe.test(blockState), vec3d);
        this.qfx = null;
        this.qga = null;
        return true;
    }

    private boolean qjl(World world, ClientPlayerEntity clientPlayerEntity, int n3, boolean bl) {
        double d;
        double d2;
        int n4;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        int n5 = MathHelper.floor((double)vec3d.x);
        int n6 = MathHelper.floor((double)vec3d.z);
        int n7 = Math.max(this.qfg.minY, n3);
        int n8 = Math.min(this.qfg.maxY, MathHelper.floor((double)(vec3d.y + 4.4)));
        LongOpenHashSet longOpenHashSet = qdz.qjp(world, clientPlayerEntity, n3);
        LongArrayList longArrayList = new LongArrayList();
        DoubleArrayList doubleArrayList = new DoubleArrayList();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        double d3 = 24.010000000000005;
        for (int i = n5 - 5; i <= n5 + 5; ++i) {
            for (n4 = n6 - 5; n4 <= n6 + 5; ++n4) {
                for (int j = n7; j <= n8; ++j) {
                    double d4;
                    double d5;
                    double d6;
                    BlockState blockState;
                    if (!this.qfg.contains(i, j, n4) || !qdz.qjq(world, (BlockPos)mutable, blockState = world.getBlockState((BlockPos)mutable.set(i, j, n4)))) continue;
                    long l = BlockPos.asLong((int)i, (int)j, (int)n4);
                    if (this.qfe.test(blockState)) {
                        this.qfc.add(l);
                    }
                    if ((d6 = (double)i + 0.5 - vec3d.x) * d6 + (d5 = (double)j + 0.5 - vec3d.y) * d5 + (d4 = (double)n4 + 0.5 - vec3d.z) * d4 > d3 || this.qkb(l) || !qdz.qjr(world, (BlockPos)mutable)) continue;
                    d2 = qdz.qim(clientPlayerEntity, new Vec3d((double)i + 0.5, (double)j + 0.5, (double)n4 + 0.5));
                    d = j == n3 + 1 ? 3.0 : (j == n3 ? 1.2 : 1.8);
                    longArrayList.add(l);
                    doubleArrayList.add(this.qka(blockState) * d / qdz.qjo(d2));
                }
            }
        }
        if (longArrayList.isEmpty()) {
            return false;
        }
        Integer[] integerArray = new Integer[longArrayList.size()];
        for (n4 = 0; n4 < integerArray.length; ++n4) {
            integerArray[n4] = n4;
        }
        Arrays.sort(integerArray, (n, n2) -> Double.compare(doubleArrayList.getDouble(n2.intValue()), doubleArrayList.getDouble(n.intValue())));
        qda qda2 = null;
        double d7 = 0.0;
        boolean bl2 = false;
        for (int i = 0; i < Math.min(14, integerArray.length); ++i) {
            long l = longArrayList.getLong(integerArray[i].intValue());
            BlockPos blockPos = BlockPos.fromLong((long)l);
            BlockState blockState = world.getBlockState(blockPos);
            for (qda qda3 : this.qki(world, clientPlayerEntity, blockPos)) {
                d2 = qdz.qjo(qda3.turn());
                d = this.qjn(world, blockPos, blockState, qda3.axis(), qda3.look(), n3, longOpenHashSet, mutable) / d2;
                double d8 = qda3.turn() < 2.0 ? 0.0 : this.qjn(world, blockPos, blockState, qda3.axis(), qln.lookAxes(qda3.yaw(), qda3.pitch()), n3, longOpenHashSet, mutable) / (d2 + 1.0);
                double d9 = d8;
                double d10 = Math.max(d, d9);
                if (!(d10 > d7)) continue;
                d7 = d10;
                qda2 = qda3;
                bl2 = d9 > d;
            }
        }
        if (qda2 == null) {
            return false;
        }
        BlockState blockState = world.getBlockState(qda2.pos());
        this.qkv(qda2.pos(), blockState.getBlock(), this.qfe.test(blockState), qda2.point(), bl);
        this.qhr = bl2 ? 1 : 0;
        return true;
    }

    private boolean qjm(World world, ClientPlayerEntity clientPlayerEntity, int n, boolean bl) {
        Object object;
        BlockPos blockPos = null;
        if (!this.qey.isEmpty() && this.qfi - ((qcu)(object = this.qey.get(this.qey.size() - 1))).tick() <= 40) {
            blockPos = BlockPos.fromLong((long)((qcu)object).pos());
        }
        if (((Object)(object = (Object)this.qgs.rank(world, clientPlayerEntity, this.qfg, l -> this.qew.getOrDefault(l, 0L) > (long)this.qfi || this.qev.contains(l), l -> this.qfb.getOrDefault(l, 0) > this.qfi, blockPos, 6))).length == 0) {
            return false;
        }
        LongOpenHashSet longOpenHashSet = qdz.qjp(world, clientPlayerEntity, n);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (Object object2 : object) {
            BlockPos blockPos2 = BlockPos.fromLong((long)object2);
            BlockState blockState = world.getBlockState(blockPos2);
            if (!this.qfg.contains(blockPos2) || this.qkb((long)object2) || !qdz.qjq(world, blockPos2, blockState)) continue;
            qda qda2 = null;
            double d = Double.NEGATIVE_INFINITY;
            boolean bl2 = false;
            for (qda qda3 : this.qki(world, clientPlayerEntity, blockPos2)) {
                double d2 = qdz.qjo(qda3.turn());
                double d3 = this.qjn(world, blockPos2, blockState, qda3.axis(), qda3.look(), n, longOpenHashSet, mutable) / d2;
                double d4 = qda3.turn() < 2.0 ? Double.NEGATIVE_INFINITY : this.qjn(world, blockPos2, blockState, qda3.axis(), qln.lookAxes(qda3.yaw(), qda3.pitch()), n, longOpenHashSet, mutable) / (d2 + 1.0);
                double d5 = Math.max(d3, d4);
                if (qda2 != null && !(d5 > d)) continue;
                qda2 = qda3;
                d = d5;
                bl2 = d4 > d3;
            }
            if (qda2 == null) continue;
            this.qkv(blockPos2, blockState.getBlock(), this.qfe.test(blockState), qda2.point(), bl);
            this.qhr = bl2 ? 1 : 0;
            return true;
        }
        return false;
    }

    private double qjn(World world, BlockPos blockPos, BlockState blockState, int n, double[] dArray, int n2, LongOpenHashSet longOpenHashSet, BlockPos.Mutable mutable) {
        long l = blockPos.asLong();
        double d = this.qka(blockState);
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    double d2;
                    BlockState blockState2;
                    long l2;
                    int n3;
                    int n4;
                    int n5;
                    if (i == 0 && j == 0 && k == 0 || !this.qfg.contains(n5 = blockPos.getX() + i, n4 = blockPos.getY() + j, n3 = blockPos.getZ() + k) || this.qkb(l2 = BlockPos.asLong((int)n5, (int)n4, (int)n3)) || !qdz.qjq(world, (BlockPos)mutable, blockState2 = world.getBlockState((BlockPos)mutable.set(n5, n4, n3))) || (d2 = this.qes.expect(l2, l, n, dArray)) <= 0.0) continue;
                    if (n4 < n2) {
                        d -= (longOpenHashSet.contains(l2) ? 8.0 : 0.7) * d2;
                        continue;
                    }
                    d += this.qka(blockState2) * d2;
                }
            }
        }
        return d;
    }

    private static double qjo(double d) {
        return 1.0 + d / 55.0 + Math.max(0.0, d - 60.0) / 40.0;
    }

    private static LongOpenHashSet qjp(World world, ClientPlayerEntity clientPlayerEntity, int n) {
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        Box box = clientPlayerEntity.getBoundingBox();
        for (int i = MathHelper.floor((double)(box.minX + 0.001)); i <= MathHelper.floor((double)(box.maxX - 0.001)); ++i) {
            for (int j = MathHelper.floor((double)(box.minZ + 0.001)); j <= MathHelper.floor((double)(box.maxZ - 0.001)); ++j) {
                longOpenHashSet.add(BlockPos.asLong((int)i, (int)(n - 1), (int)j));
            }
        }
        return longOpenHashSet;
    }

    private static boolean qjq(World world, BlockPos blockPos, BlockState blockState) {
        return !blockState.isAir() && blockState.getFluidState().isEmpty() && blockState.getHardness((BlockView)world, blockPos) >= 0.0f && !blockState.getCollisionShape((BlockView)world, blockPos).isEmpty();
    }

    private static boolean qjr(World world, BlockPos blockPos) {
        for (Direction direction : Direction.values()) {
            BlockPos blockPos2 = blockPos.offset(direction);
            if (!world.getBlockState(blockPos2).getOutlineShape((BlockView)world, blockPos2).isEmpty()) continue;
            return true;
        }
        return false;
    }

    private static boolean qjs(World world, BlockPos blockPos) {
        return world.getBlockState(blockPos).getCollisionShape((BlockView)world, blockPos).isEmpty();
    }

    private boolean qjt(World world, ClientPlayerEntity clientPlayerEntity, int n2) {
        int[] nArray;
        BlockPos blockPos;
        qdk qdk2 = new qdk(this, world, clientPlayerEntity, n2);
        if (qdk2.start < 0) {
            return false;
        }
        long[] lArray = new long[qdk2.w * qdk2.d];
        Arrays.fill(lArray, Long.MIN_VALUE);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int n3 = Math.min(this.qfg.maxY, n2 + 4);
        boolean bl = false;
        for (int i = this.qfg.minX; i <= this.qfg.maxX; ++i) {
            block1: for (int j = this.qfg.minZ; j <= this.qfg.maxZ; ++j) {
                for (int k = Math.max(this.qfg.minY, n2); k <= n3; ++k) {
                    long l = BlockPos.asLong((int)i, (int)k, (int)j);
                    if (this.qkb(l) || !qdz.qjq(world, (BlockPos)mutable.set(i, k, j), world.getBlockState((BlockPos)mutable))) continue;
                    bl = true;
                    for (int i2 = i - 3; i2 <= i + 3; ++i2) {
                        for (int i3 = j - 3; i3 <= j + 3; ++i3) {
                            double d;
                            double d2;
                            double d3;
                            int n4 = qdk2.index(i2, i3);
                            if (n4 < 0 || lArray[n4] != Long.MIN_VALUE || !((d3 = (double)(i - i2)) * d3 + (d2 = (double)k + 0.5 - ((double)n2 + 1.62)) * d2 + (d = (double)(j - i3)) * d <= 12.96)) continue;
                            lArray[n4] = l;
                        }
                    }
                    continue block1;
                }
            }
        }
        if (!bl) {
            return false;
        }
        if (this.qhq != Long.MIN_VALUE && this.qfi - this.qhp <= 2 && Vec3d.ofCenter((Vec3i)(blockPos = BlockPos.fromLong((long)this.qhq))).distanceTo(clientPlayerEntity.getEyePos()) <= 3.9) {
            this.qlf(blockPos, 400);
            this.qhq = Long.MIN_VALUE;
        }
        if ((nArray = qdk2.path(n -> n != qdk2.start && lArray[n] != Long.MIN_VALUE && this.qew.getOrDefault(lArray[n], 0L) <= (long)this.qfi)) == null) {
            return false;
        }
        long l = lArray[nArray[nArray.length - 1]];
        this.qjv(qdk2.waypoint(clientPlayerEntity, nArray), nArray.length <= 3, l, Vec3d.ofCenter((Vec3i)BlockPos.fromLong((long)l)));
        return true;
    }

    private boolean qju(World world, ClientPlayerEntity clientPlayerEntity, int n) {
        qdk qdk2 = new qdk(this, world, clientPlayerEntity, n);
        if (qdk2.start < 0) {
            return false;
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int[] nArray = qdk2.path(n2 -> {
            int n3;
            if (n2 == qdk2.start) {
                return false;
            }
            int n4 = qdk2.cellX(n2);
            if (!this.qfg.contains(n4, n - 1, n3 = qdk2.cellZ(n2)) || this.qkb(BlockPos.asLong((int)n4, (int)(n - 1), (int)n3))) {
                return false;
            }
            return qdz.qjq(world, (BlockPos)mutable.set(n4, n - 1, n3), world.getBlockState((BlockPos)mutable));
        });
        if (nArray == null) {
            return false;
        }
        int n3 = nArray[nArray.length - 1];
        Vec3d vec3d = nArray.length <= 2 ? new Vec3d((double)qdk2.cellX(n3) + 0.5, (double)n, (double)qdk2.cellZ(n3) + 0.5) : qdk2.waypoint(clientPlayerEntity, nArray);
        this.qjv(vec3d, true, BlockPos.asLong((int)qdk2.cellX(n3), (int)(n - 1), (int)qdk2.cellZ(n3)), new Vec3d((double)qdk2.cellX(n3) + 0.5, (double)n - 0.5, (double)qdk2.cellZ(n3) + 0.5));
        return true;
    }

    private void qjv(Vec3d vec3d, boolean bl, long l, Vec3d vec3d2) {
        if (l != this.qhq) {
            this.qhq = l;
            this.qgb = new Object();
        } else if (this.qgn > 40) {
            this.qgn = 0;
            this.qlf(BlockPos.fromLong((long)l), 400);
        }
        this.qfx = vec3d;
        this.qhp = this.qfi;
        this.qfy = false;
        this.qfz = bl;
        this.qga = vec3d2;
    }

    private void qjw(World world, ClientPlayerEntity clientPlayerEntity, boolean bl) {
        int n;
        BlockPos blockPos = this.qfj.target();
        int n2 = this.qfj.path()[this.qfk * 3];
        int n3 = this.qfj.path()[this.qfk * 3 + 1];
        int n4 = this.qfj.path()[this.qfk * 3 + 2];
        int n5 = this.qfj.path()[(this.qfk + 1) * 3];
        int n6 = this.qfj.path()[(this.qfk + 1) * 3 + 1];
        int n7 = this.qfj.path()[(this.qfk + 1) * 3 + 2];
        int n8 = this.qjy(world, n2, n3, n4, n5, n6, n7);
        int n9 = this.qfj.path()[n8 * 3];
        int n10 = this.qfj.path()[n8 * 3 + 2];
        Vec3d vec3d = new Vec3d((double)n9 + 0.5, (double)n6, (double)n10 + 0.5);
        if (bl && this.qjz()) {
            n = this.qkk(world, clientPlayerEntity);
            if (n < 0) {
                this.qlj(a.d("\u526e\u2bd1\ua101\u3f7c\ub4a3\u321c\u884e\u01fb\u9ff7\u1541\u9283\u68e7\ue660", -687595192, 1631875913) + n2 + a.b("\uff5c", 1678311281) + n3 + a.c(-101397769, "\ucada") + n4 + a.c(1345220264, "\u6e8c\u1730\u9df0\u039f") + n5 + a.d("\u5a71", 2084715363, 1591501119) + n6 + a.d("\ubc63", 1987281718, -294174856) + n7);
                this.qfl = true;
                this.qfx = null;
                return;
            }
            if (n > 0) {
                this.qfx = n == 2 ? null : vec3d;
                this.qfy = n6 > n3;
                this.qfz = true;
                return;
            }
        } else {
            for (BlockPos blockPos2 : this.qks(n2, n3, n4, n5, n6, n7)) {
                if (!qdz.qle(world, blockPos2)) continue;
                if (!this.qlc(world, blockPos2)) {
                    this.qlj(a.b("\u3f3f\u4680\ucc50\u522d\ud9f2\u5f4d\ue51f\u6caa", -702202027) + blockPos2.toShortString() + a.c(178799320, "\u42fe\u3b1c\ub1c8\u2fa8\ua46a\u228b") + n2 + a.d("\ub1ae", 296989217, 626197410) + n3 + a.d("\u355e", 227536667, -1637885336) + n4 + a.d("\u825a\ufbe6\u7126\uef49", 10353374, 732068000) + n5 + a.b("\uf903", 756152622) + n6 + a.d("\u2ae4", 298627232, -1451976087) + n7);
                    this.qfl = true;
                    this.qfx = null;
                    return;
                }
                this.qkt(world, clientPlayerEntity, blockPos2, false);
                if (this.qfr != null) {
                    return;
                }
                this.qlj(a.b("\u4e87\u3737\ubdab\u239b\ua844\u2ef1\u94ef", -1146532114) + blockPos2.toShortString() + a.b("\u3801\u41e3\ucb37\u5557\ude95\u5874", -731826137) + n2 + a.b("\uf6fb", -170592554) + n3 + a.b("\ud543", -775694994) + n4 + a.b("\uc863\ub1df\u3b1f\ua570", 783534151) + n5 + a.d("\ue21e", 1966740213, 1608052934) + n6 + a.c(-1758479877, "\ub9d6") + n7);
                this.qfl = true;
                return;
            }
        }
        if (this.qgn > 50) {
            this.qlj(a.b("\u78c9\u017f\u8bad\u15ca\u9e15\u18ef\ua2fd\u2b19\ub512", 855406771) + clientPlayerEntity.getBlockPos().toShortString() + a.d("\u5d0f\u24ea\uae22\u301c", 1758371912, 667549027) + n5 + a.c(-1347100770, "\udfb3") + n6 + a.d("\ub385", -657149490, -474611098) + n7);
            this.qgn = 0;
            if (++this.qgo >= 3) {
                if (this.qhc != null) {
                    this.qhd = true;
                } else {
                    this.qlf(blockPos, 600);
                }
                this.qgo = 0;
            }
            this.qfl = true;
            this.qfx = null;
            return;
        }
        boolean bl2 = this.qfz = n6 <= n3 && (n8 >= this.qkl() - 1 || this.qko(n8));
        if (this.qfx == null || this.qfx.x != vec3d.x || this.qfx.y != vec3d.y || this.qfx.z != vec3d.z) {
            this.qlj(a.b("\ud536\uac91\u264f\ub839\u33a5", 224449860) + n2 + a.c(-593811850, "\u265b") + n3 + a.c(865264831, "\ue492") + n4 + a.b("\u5009\u29b5\ua375\u3d1a", -978956243) + n9 + a.c(-389982549, "\u5686") + n6 + a.b("\u6c31", -1629328356) + n10);
        }
        this.qfx = vec3d;
        this.qfy = n6 > n3;
        n = Math.min(this.qkl() - 1, this.qfk + 3);
        int n11 = this.qfj.path()[n * 3];
        int n12 = this.qfj.path()[n * 3 + 1];
        int n13 = this.qfj.path()[n * 3 + 2];
        Vec3d vec3d2 = clientPlayerEntity.getEyePos();
        if (bl && this.qgr != null && qdz.qjx(vec3d2, n11, n13, blockPos)) {
            long l = blockPos.asLong() ^ 0x5DEECE66DL;
            if (l != this.qgc || this.qga == null) {
                this.qgc = l;
                this.qgb = new Object();
                this.qga = Vec3d.ofCenter((Vec3i)blockPos);
            }
            return;
        }
        long l = BlockPos.asLong((int)n11, (int)n12, (int)n13);
        if (l != this.qgc || this.qga == null) {
            this.qgc = l;
            this.qgb = new Object();
            Vec3d vec3d3 = new Vec3d((double)n11 + 0.5, (double)n12 + (this.qgr != null ? 1.45 : 0.9), (double)n13 + 0.5);
            Vec3d vec3d4 = vec3d3.subtract(vec3d2);
            double d = Math.sqrt(vec3d4.x * vec3d4.x + vec3d4.z * vec3d4.z);
            if (d < 1.5) {
                double d2 = n5 - n2;
                double d3 = n7 - n4;
                double d4 = Math.sqrt(d2 * d2 + d3 * d3);
                if (d4 < 0.5) {
                    double d5 = Math.toRadians(clientPlayerEntity.getYaw());
                    d2 = -Math.sin(d5);
                    d3 = Math.cos(d5);
                    d4 = 1.0;
                }
                vec3d3 = new Vec3d(vec3d2.x + d2 / d4 * 3.0, vec3d2.y - (n6 < n3 ? 1.6 : 0.4), vec3d2.z + d3 / d4 * 3.0);
            }
            this.qga = vec3d3;
        }
    }

    private static boolean qjx(Vec3d vec3d, int n, int n2, BlockPos blockPos) {
        double d = (double)n + 0.5 - vec3d.x;
        double d2 = (double)n2 + 0.5 - vec3d.z;
        double d3 = (double)blockPos.getX() + 0.5 - vec3d.x;
        double d4 = (double)blockPos.getZ() + 0.5 - vec3d.z;
        double d5 = Math.sqrt(d * d + d2 * d2);
        double d6 = Math.sqrt(d3 * d3 + d4 * d4);
        if (d5 < 0.5 || d6 < 0.5 || Math.abs((double)blockPos.getY() + 0.5 - vec3d.y) > d6 * 0.7) {
            return false;
        }
        return (d * d3 + d2 * d4) / (d5 * d6) > 0.34;
    }

    private int qjy(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.qfk + 1;
        if (n5 != n2) {
            return n7;
        }
        int n8 = n4 - n;
        int n9 = n6 - n3;
        int n10 = n7;
        int[] nArray = this.qfj.path();
        while (n10 + 1 < this.qkl() && n10 + 1 <= this.qfk + 4) {
            int n11 = nArray[n10 * 3];
            int n12 = nArray[n10 * 3 + 1];
            int n13 = nArray[n10 * 3 + 2];
            int n14 = nArray[(n10 + 1) * 3];
            int n15 = nArray[(n10 + 1) * 3 + 1];
            int n16 = nArray[(n10 + 1) * 3 + 2];
            if (n15 != n12 || n14 - n11 != n8 || n16 - n13 != n9) break;
            boolean bl = true;
            for (BlockPos blockPos : this.qks(n11, n12, n13, n14, n15, n16)) {
                if (!qdz.qle(world, blockPos)) continue;
                bl = false;
                break;
            }
            if (!bl || !qdz.qle(world, new BlockPos(n14, n15 - 1, n16))) break;
            ++n10;
        }
        return n10;
    }

    private boolean qjz() {
        return this.qgr != null && this.qgy;
    }

    private double qka(BlockState blockState) {
        return 1.0 + (double)qnd.value(blockState) / 15.0;
    }

    private boolean qkb(long l) {
        return this.qfb.getOrDefault(l, 0) > this.qfi || this.qew.getOrDefault(l, 0L) > (long)this.qfi || this.qev.contains(l);
    }

    private int qkc(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos, BlockState blockState) {
        float f = blockState.calcBlockBreakingDelta((PlayerEntity)clientPlayerEntity, (BlockView)world, blockPos);
        if (f <= 0.0f) {
            return 600;
        }
        return Math.max(1, (int)Math.ceil(1.0f / f));
    }

    private double qkd(double d) {
        return d / Math.max(10.0, this.qil());
    }

    /*
     * WARNING - void declaration
     */
    private boolean qke(World world, ClientPlayerEntity clientPlayerEntity) {
        double d;
        Object object;
        if (this.qfg == null || this.qfg.maxX < this.qfg.minX) {
            return false;
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        int n = MathHelper.floor((double)vec3d.x);
        int n2 = MathHelper.floor((double)vec3d.y);
        int n3 = MathHelper.floor((double)vec3d.z);
        double d2 = 6.0;
        Long2DoubleOpenHashMap long2DoubleOpenHashMap = new Long2DoubleOpenHashMap();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = n - 6; i <= n + 6; ++i) {
            for (int j = n2 - 6; j <= n2 + 5; ++j) {
                for (int k = n3 - 6; k <= n3 + 6; ++k) {
                    BlockState blockState;
                    long l3;
                    double d3;
                    double d4;
                    double d5;
                    if (!this.qfg.contains(i, j, k) || (d5 = (double)i + 0.5 - vec3d.x) * d5 + (d4 = (double)j + 0.5 - vec3d.y) * d4 + (d3 = (double)k + 0.5 - vec3d.z) * d3 > d2 * d2 || this.qkb(l3 = BlockPos.asLong((int)i, (int)j, (int)k)) || (blockState = world.getBlockState((BlockPos)mutable.set(i, j, k))).isAir() || !this.qfe.test(blockState)) continue;
                    long2DoubleOpenHashMap.put(l3, this.qka(blockState));
                    this.qfc.add(l3);
                }
            }
        }
        if (long2DoubleOpenHashMap.isEmpty()) {
            return false;
        }
        Long2DoubleOpenHashMap long2DoubleOpenHashMap2 = new Long2DoubleOpenHashMap();
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        for (Long2DoubleMap.Entry entry : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
            BlockPos blockPos;
            long l4 = entry.getLongKey();
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        if ((i != 0 || j != 0 || k != 0) && !this.qgy) continue;
                        longOpenHashSet.add(BlockPos.add((long)l4, (int)i, (int)j, (int)k));
                    }
                }
            }
            BlockPos blockPos2 = BlockPos.fromLong((long)l4);
            if (!(Vec3d.ofCenter((Vec3i)blockPos2).distanceTo(vec3d) <= 4.7) || (blockPos = qdz.qla(world, clientPlayerEntity, vec3d, blockPos2)) == null || qdz.qkg(blockPos.asLong(), l4) <= (this.qgy ? 1 : 0)) continue;
            longOpenHashSet.add(blockPos.asLong());
            double d6 = 0.45 * entry.getDoubleValue();
            if (!(d6 > long2DoubleOpenHashMap2.get(blockPos.asLong()))) continue;
            long2DoubleOpenHashMap2.put(blockPos.asLong(), d6);
        }
        boolean bl = this.qgy && this.qes.p(2) < 0.98;
        LongArrayList longArrayList = new LongArrayList();
        Long2DoubleOpenHashMap long2DoubleOpenHashMap3 = new Long2DoubleOpenHashMap();
        LongIterator longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            Vec3d vec3d2;
            double d7;
            long l5 = longIterator.nextLong();
            BlockPos blockPos = BlockPos.fromLong((long)l5);
            if (!this.qfg.contains(blockPos) || this.qkb(l5) || (d7 = (vec3d2 = Vec3d.ofCenter((Vec3i)blockPos)).distanceTo(vec3d)) > 4.45 || (object = world.getBlockState(blockPos)).isAir() || !object.getFluidState().isEmpty() || object.getHardness((BlockView)world, blockPos) < 0.0f) continue;
            double d8 = long2DoubleOpenHashMap.get(l5) + long2DoubleOpenHashMap2.get(l5);
            if (bl) {
                for (Object object2 : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
                    long l6 = object2.getLongKey();
                    if (l6 == l5 || qdz.qkg(l6, l5) > 1 || !qdz.qkh(l6, l5)) continue;
                    d8 += object2.getDoubleValue();
                }
            }
            if (d8 <= 0.0) continue;
            double d9 = Math.toDegrees(Math.atan2(0.6, Math.max(0.6, d7)));
            double d10 = (double)this.qkc(world, clientPlayerEntity, blockPos, (BlockState)object) + this.qkd(Math.max(0.0, this.qgr.error(clientPlayerEntity, vec3d2) - d9)) + 0.35;
            long2DoubleOpenHashMap3.put(l5, d8 / d10);
            longArrayList.add(l5);
        }
        if (longArrayList.isEmpty()) {
            return false;
        }
        longArrayList.sort((l, l2) -> Double.compare(long2DoubleOpenHashMap3.get(l2), long2DoubleOpenHashMap3.get(l)));
        long l7 = qdz.standing(world, clientPlayerEntity).down().asLong();
        ArrayList<Long2DoubleMap.Entry> arrayList = new ArrayList<Long2DoubleMap.Entry>();
        int n4 = 0;
        for (int i = 0; i < longArrayList.size() && n4 < 32; ++i) {
            void qdt5;
            Object object2;
            long l8 = longArrayList.getLong(i);
            if (arrayList.size() >= 10 && long2DoubleOpenHashMap3.get(l8) <= ((qdt)arrayList.get(9)).rate()) break;
            ++n4;
            object = BlockPos.fromLong((long)l8);
            BlockState blockState = world.getBlockState((BlockPos)object);
            d = this.qkc(world, clientPlayerEntity, (BlockPos)object, blockState);
            object2 = null;
            for (qda qda2 : this.qki(world, clientPlayerEntity, (BlockPos)object)) {
                qdt qdt2 = new qdt(qda2, long2DoubleOpenHashMap.get(l8) + long2DoubleOpenHashMap2.get(l8), d);
                qdt2.value = qdt2.own;
                if (long2DoubleOpenHashMap.containsKey(l8)) {
                    qdt2.caught.add(l8);
                    qdt2.chance.add(1.0);
                }
                if (bl) {
                    for (Long2DoubleMap.Entry entry : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
                        double d3;
                        long l3 = entry.getLongKey();
                        if (l3 == l8 || qdz.qkg(l3, l8) > 1 || !((d3 = this.qes.expect(l3, l8, qda2.axis(), qda2.look())) > 0.0)) continue;
                        qdt2.value += entry.getDoubleValue() * d3;
                        qdt2.caught.add(l3);
                        qdt2.chance.add(d3);
                    }
                }
                double d4 = l7 == l8 ? 1.0 : (bl ? this.qes.expect(l7, l8, qda2.axis(), qda2.look()) : 0.0);
                qdt2.time = d + this.qkd(qda2.turn()) + 0.35 + d4 * 0.8;
                if (object2 != null && !(qdt2.rate() > ((qdt)object2).rate())) continue;
                object2 = qdt2;
            }
            if (object2 == null || ((qdt)object2).value <= 0.0) continue;
            boolean n5 = false;
            while (qdt5 < arrayList.size() && ((qdt)arrayList.get((int)qdt5)).rate() >= ((qdt)object2).rate()) {
                ++qdt5;
            }
            arrayList.add((int)qdt5, (Long2DoubleMap.Entry)object2);
            if (arrayList.size() <= 10) continue;
            arrayList.remove(arrayList.size() - 1);
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        qdt qdt3 = null;
        double d13 = 0.0;
        for (qdt qdt4 : arrayList) {
            d = qdt4.rate();
            for (qdt qdt5 : arrayList) {
                if (qdt5 == qdt4 || qdt4.chanceOf(qdt5.key) >= 0.5 || bl && this.qes.expect(qdt5.key, qdt4.key, qdt4.hit.axis(), qdt4.hit.look()) >= 0.5) continue;
                double[] dArray = qln.lookAxes(qdt4.hit.yaw(), qdt4.hit.pitch());
                double d5 = qdt5.own * (1.0 - qdt4.chanceOf(qdt5.key));
                if (bl) {
                    for (Long2DoubleMap.Entry entry : long2DoubleOpenHashMap.long2DoubleEntrySet()) {
                        long l4 = entry.getLongKey();
                        if (l4 == qdt5.key || qdz.qkg(l4, qdt5.key) > 1) continue;
                        double d6 = this.qes.expect(l4, qdt5.key, qdt5.hit.axis(), dArray);
                        d5 += entry.getDoubleValue() * d6 * (1.0 - qdt4.chanceOf(l4));
                    }
                }
                double d7 = qdz.qkf(vec3d, qdt4.hit.point(), qdt5.hit.point());
                double d8 = (qdt4.value + d5) / (qdt4.time + qdt5.ticks + this.qkd(d7) + 0.35);
                d = Math.max(d, d8);
            }
            if (!(d > d13)) continue;
            d13 = d;
            qdt3 = qdt4;
        }
        if (qdt3 == null || d13 < 0.12) {
            return false;
        }
        object = qdt3.hit.pos();
        BlockState blockState = world.getBlockState((BlockPos)object);
        this.qkv((BlockPos)object, blockState.getBlock(), long2DoubleOpenHashMap.containsKey(qdt3.key), qdt3.hit.point(), this.qfx != null && this.qfj != null);
        if (trace != null) {
            this.qlj(String.format(Locale.ROOT, a.c(-894157631, "\u3c84\u452c\ucff5\u518c\uda10\u5ca4\ue6a1\u6f03\uf10a\u7bf0\ufc3b\u0641\u888a\u116f\u9b7a\u1ddf\ua7d9\u2810\ub2a8\u34e5\ubd46\uc751\u49b6\ud266\u541e\uded3\u6733\ue97a\u7386\uf5c9\u7e2c\u80bb\u0aa7\u9346\u1519\u9fb5\u2075\uaa5c\u2c97\ub52d\u3f6e\u41cb\ucbde\u4c20\ud6fe\u58c9\ue11f\u6bef\uede4\u763d\uf843\u02c4\u8b29"), object.toShortString(), qdt3.value, qdt3.time, qdt3.hit.turn(), d13, arrayList.size(), this.qes.describe()));
        }
        return true;
    }

    private static double qkf(Vec3d vec3d, Vec3d vec3d2, Vec3d vec3d3) {
        Vec3d vec3d4 = vec3d2.subtract(vec3d).normalize();
        Vec3d vec3d5 = vec3d3.subtract(vec3d).normalize();
        return Math.toDegrees(Math.acos(MathHelper.clamp((double)vec3d4.dotProduct(vec3d5), (double)-1.0, (double)1.0)));
    }

    private static int qkg(long l, long l2) {
        return Math.max(Math.abs(BlockPos.unpackLongX((long)l) - BlockPos.unpackLongX((long)l2)), Math.max(Math.abs(BlockPos.unpackLongY((long)l) - BlockPos.unpackLongY((long)l2)), Math.abs(BlockPos.unpackLongZ((long)l) - BlockPos.unpackLongZ((long)l2))));
    }

    private static boolean qkh(long l, long l2) {
        return BlockPos.unpackLongX((long)l) == BlockPos.unpackLongX((long)l2) || BlockPos.unpackLongY((long)l) == BlockPos.unpackLongY((long)l2) || BlockPos.unpackLongZ((long)l) == BlockPos.unpackLongZ((long)l2);
    }

    private List<qda> qki(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        ArrayList<qda> arrayList = new ArrayList<qda>(3);
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        double d = (this.qep.nextDouble() - 0.5) * 0.3;
        double d2 = (this.qep.nextDouble() - 0.5) * 0.3;
        block0: for (Direction direction : Direction.values()) {
            BlockPos blockPos2 = blockPos.offset(direction);
            if (!world.getBlockState(blockPos2).getOutlineShape((BlockView)world, blockPos2).isEmpty()) continue;
            Vec3d vec3d2 = new Vec3d((double)direction.getOffsetX(), (double)direction.getOffsetY(), (double)direction.getOffsetZ());
            Vec3d vec3d3 = Vec3d.ofCenter((Vec3i)blockPos).add(vec3d2.multiply(0.5));
            if (vec3d.subtract(vec3d3).dotProduct(vec3d2) <= 0.02) continue;
            Vec3d vec3d4 = direction.getAxis() == Direction.Axis.X ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(1.0, 0.0, 0.0);
            Vec3d vec3d5 = direction.getAxis() == Direction.Axis.Y ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(0.0, 1.0, 0.0);
            for (double[] dArray : qej) {
                double d3;
                double d4 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d : dArray[0];
                double d5 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d2 : dArray[1];
                Vec3d vec3d6 = vec3d3.add(vec3d4.multiply(d4)).add(vec3d5.multiply(d5));
                Vec3d vec3d7 = vec3d6.subtract(vec3d);
                double d6 = vec3d7.length();
                if (d6 > 4.4 || d6 < 0.3 || (d3 = Math.sqrt(vec3d7.x * vec3d7.x + vec3d7.z * vec3d7.z)) < 0.25 || !qdz.qky(world, clientPlayerEntity, vec3d, blockPos, vec3d6)) continue;
                float f = (float)tbp.yawTo(vec3d7.x, vec3d7.z);
                float f2 = (float)tbp.pitchTo(vec3d7.y, d3);
                double d7 = Math.hypot(MathHelper.wrapDegrees((float)(f - clientPlayerEntity.getYaw())), f2 - clientPlayerEntity.getPitch());
                arrayList.add(new qda(blockPos.toImmutable(), vec3d6, direction.getAxis().ordinal(), this.qkj(clientPlayerEntity, f, f2, d7), d7, f, f2));
                continue block0;
            }
        }
        return arrayList;
    }

    private double[] qkj(ClientPlayerEntity clientPlayerEntity, float f, float f2, double d) {
        float f3 = clientPlayerEntity.getYaw();
        float f4 = clientPlayerEntity.getPitch();
        double d2 = this.qil();
        if (d <= d2 * 0.97) {
            return qln.lookAxes(f3, f4);
        }
        double d3 = d2 / d;
        return qln.lookAxes((float)((double)f3 + (double)MathHelper.wrapDegrees((float)(f - f3)) * d3), (float)((double)f4 + (double)(f2 - f4) * d3));
    }

    private int qkk(World world, ClientPlayerEntity clientPlayerEntity) {
        int n;
        long l;
        int n2 = this.qkl();
        int[] nArray = this.qfj.path();
        LongArrayList longArrayList = new LongArrayList();
        DoubleArrayList doubleArrayList = new DoubleArrayList();
        boolean bl = false;
        block0: for (int i = this.qfk; i < Math.min(n2 - 1, this.qfk + 3); ++i) {
            for (BlockPos blockPos : this.qks(nArray[i * 3], nArray[i * 3 + 1], nArray[i * 3 + 2], nArray[(i + 1) * 3], nArray[(i + 1) * 3 + 1], nArray[(i + 1) * 3 + 2])) {
                if (!qdz.qle(world, blockPos)) continue;
                l = blockPos.asLong();
                if (this.qfb.getOrDefault(l, 0) > this.qfi) {
                    bl |= i == this.qfk;
                    continue;
                }
                if (!this.qlc(world, blockPos)) {
                    if (i != this.qfk) break block0;
                    return -1;
                }
                if (longArrayList.contains(l)) continue;
                longArrayList.add(l);
                doubleArrayList.add(i == this.qfk ? 1.5 : (i == this.qfk + 1 ? 1.0 : 0.6));
            }
        }
        if (longArrayList.isEmpty()) {
            return bl ? 2 : 0;
        }
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        longOpenHashSet.add(qdz.standing(world, clientPlayerEntity).down().asLong());
        for (n = this.qfk; n < Math.min(n2, this.qfk + 5); ++n) {
            longOpenHashSet.add(BlockPos.asLong((int)nArray[n * 3], (int)(nArray[n * 3 + 1] - 1), (int)nArray[n * 3 + 2]));
        }
        for (n = 0; n < longArrayList.size(); ++n) {
            longOpenHashSet.remove(longArrayList.getLong(n));
        }
        LongOpenHashSet longOpenHashSet2 = new LongOpenHashSet();
        for (int i = 0; i < longArrayList.size(); ++i) {
            l = longArrayList.getLong(i);
            longOpenHashSet2.add(l);
            if (!this.qgy) continue;
            longOpenHashSet2.add(BlockPos.add((long)l, (int)0, (int)1, (int)0));
            longOpenHashSet2.add(BlockPos.add((long)l, (int)0, (int)-1, (int)0));
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        qda qda2 = null;
        double d = 0.0;
        LongIterator longIterator = longOpenHashSet2.iterator();
        while (longIterator.hasNext()) {
            long l2 = longIterator.nextLong();
            BlockPos blockPos = BlockPos.fromLong((long)l2);
            if (longOpenHashSet.contains(l2) || this.qfb.getOrDefault(l2, 0) > this.qfi || !this.qlc(world, blockPos) || Vec3d.ofCenter((Vec3i)blockPos).distanceTo(vec3d) > 4.5) continue;
            BlockState blockState = world.getBlockState(blockPos);
            double d2 = this.qkc(world, clientPlayerEntity, blockPos, blockState);
            for (qda qda3 : this.qki(world, clientPlayerEntity, blockPos)) {
                double d3 = 0.0;
                for (int i = 0; i < longArrayList.size(); ++i) {
                    d3 += doubleArrayList.getDouble(i) * this.qes.expect(longArrayList.getLong(i), l2, qda3.axis(), qda3.look());
                }
                double d4 = 0.0;
                LongIterator longIterator2 = longOpenHashSet.iterator();
                while (longIterator2.hasNext()) {
                    d4 += this.qes.expect(longIterator2.nextLong(), l2, qda3.axis(), qda3.look());
                }
                double d5 = (d3 - 2.5 * d4) / (d2 + this.qkd(qda3.turn()) + 0.35);
                if (!(d5 > d)) continue;
                d = d5;
                qda2 = qda3;
            }
        }
        if (qda2 == null) {
            longIterator = BlockPos.fromLong((long)longArrayList.getLong(0));
            this.qkt(world, clientPlayerEntity, (BlockPos)longIterator, false);
            if (this.qfr == null) {
                return -1;
            }
            this.qgz = true;
            return 1;
        }
        longIterator = world.getBlockState(qda2.pos());
        this.qkv(qda2.pos(), longIterator.getBlock(), this.qfe.test((BlockState)longIterator), qda2.point(), true);
        return 1;
    }

    private int qkl() {
        return this.qfj.path().length / 3;
    }

    private int qkm(BlockPos blockPos) {
        int n = this.qkl();
        for (int i = this.qfk; i < Math.min(n, this.qfk + 4); ++i) {
            int n2 = this.qfj.path()[i * 3];
            int n3 = this.qfj.path()[i * 3 + 1];
            int n4 = this.qfj.path()[i * 3 + 2];
            if (blockPos.getX() == n2 && blockPos.getY() == n3 && blockPos.getZ() == n4) {
                if (i == this.qfk || !this.qko(i) || this.qkn(blockPos, n2, n4)) {
                    return i;
                }
                return i - 1;
            }
            if (i <= 0 || blockPos.getX() != n2 || blockPos.getZ() != n4 || blockPos.getY() <= n3 || blockPos.getY() > this.qfj.path()[(i - 1) * 3 + 1]) continue;
            return i - 1;
        }
        return -1;
    }

    private boolean qkn(BlockPos blockPos, int n, int n2) {
        return this.qgm != null && Math.abs(this.qgm.x - ((double)n + 0.5)) < 0.32 && Math.abs(this.qgm.z - ((double)n2 + 0.5)) < 0.32;
    }

    private boolean qko(int n) {
        int n2 = this.qkl();
        if (n <= 0 || n >= n2 - 1) {
            return false;
        }
        int[] nArray = this.qfj.path();
        int n3 = nArray[n * 3] - nArray[(n - 1) * 3];
        int n4 = nArray[n * 3 + 2] - nArray[(n - 1) * 3 + 2];
        int n5 = nArray[(n + 1) * 3] - nArray[n * 3];
        int n6 = nArray[(n + 1) * 3 + 2] - nArray[n * 3 + 2];
        return n3 != n5 || n4 != n6;
    }

    private List<Vec3d> qkp(World world) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (this.qgp != null && this.qfi < this.qgq) {
            arrayList.add(this.qgp);
        }
        Box box = new Box((double)(this.qfg.minX - 4), (double)(this.qfg.minY - 2), (double)(this.qfg.minZ - 4), (double)(this.qfg.maxX + 5), (double)(this.qfg.maxY + 6), (double)(this.qfg.maxZ + 5));
        if (this.qhc != null) {
            box = box.union(new Box(this.qhc).expand(6.0));
        }
        for (ItemEntity itemEntity2 : world.getEntitiesByClass(ItemEntity.class, box, itemEntity -> this.qff.test(itemEntity.getStack()))) {
            if (arrayList.size() >= 40) continue;
            arrayList.add(itemEntity2.getEntityPos());
        }
        return arrayList;
    }

    private void qkq(World world, ClientPlayerEntity clientPlayerEntity) {
        Long2IntMap.Entry entry;
        this.qfl = false;
        this.qfm = this.qfi + 20;
        this.qfo = false;
        this.qex.clear();
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
        ObjectIterator objectIterator = this.qfb.long2IntEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            entry = (Long2IntMap.Entry)objectIterator.next();
            if (entry.getIntValue() <= this.qfi) {
                objectIterator.remove();
                continue;
            }
            this.qex.add(entry.getLongKey());
        }
        objectIterator = this.qew.long2LongEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            entry = (Long2LongMap.Entry)objectIterator.next();
            if (entry.getLongValue() <= (long)this.qfi) {
                objectIterator.remove();
                continue;
            }
            this.qex.add(entry.getLongKey());
            longOpenHashSet.add(entry.getLongKey());
        }
        if (this.qhc != null) {
            this.qeq.build(world, clientPlayerEntity, this.qfg, this.qfe, (LongSet)this.qev, this.qkp(world), this.qhc);
            this.qeq.search(qdz.standing(world, clientPlayerEntity));
            this.qfj = this.qeq.toward(this.qhc, 3);
            this.qfk = 0;
            this.qgc = Long.MIN_VALUE;
            this.qlj(this.qfj == null ? a.c(1041995744, "\u9780\uee20\u64e0\ufa88\u710e\uf7a5\u4db8\uc448\u5a58\ud0be\u577b\uad12\u239c\uba79\u3031\ub68f") + this.qhc.toShortString() : a.c(-117214198, "\u7471\u0dd1\u8711\u1979\u92ff\u1454\uae57\u27b7\ub9fd\u3350\ub4cb") + this.qfj.path().length / 3 + a.c(-92191881, "\u435d\u3aa2\ub070\u2e0a\ua5dc\u237b\u997b\u10de\u8e9a\u0464") + this.qhc.toShortString());
            return;
        }
        this.qeq.build(world, clientPlayerEntity, this.qfg, this.qfe, (LongSet)this.qev, this.qkp(world));
        this.qeq.search(qdz.standing(world, clientPlayerEntity));
        objectIterator = clientPlayerEntity.getEyePos();
        entry = clientPlayerEntity.getRotationVec(1.0f);
        LongArrayList longArrayList = new LongArrayList();
        for (int i = 0; i < this.qeq.targetCount(); ++i) {
            long l = this.qeq.targetKey(i);
            if (longOpenHashSet.contains(l)) continue;
            longArrayList.add(l);
        }
        Vec3d vec3d = clientPlayerEntity.getEntityPos();
        this.qer.update(longArrayList, vec3d.x, vec3d.y, vec3d.z);
        this.qfj = null;
        for (int i = 0; i < 4 && this.qfj == null && !this.qer.isEmpty(); ++i) {
            LongOpenHashSet longOpenHashSet2 = this.qer.head();
            this.qfj = this.qeq.best((Vec3d)objectIterator, (Vec3d)entry, (LongSet)this.qex, (LongSet)longOpenHashSet2);
            if (this.qfj != null) break;
            boolean bl = true;
            LongIterator longIterator = longOpenHashSet2.iterator();
            while (longIterator.hasNext() && bl) {
                bl = this.qfb.getOrDefault(longIterator.nextLong(), 0) > this.qfi;
            }
            if (bl) {
                this.qfo = true;
                break;
            }
            this.qlj(a.c(-97302964, "\u4625\u3f89\ub540\u2b30\ua0f6\u2618\u9c51\u15e3\u8bbe\u0100\u869a\u7cb8\uf23b\u6bd8\ue19c\u6769\udd24\u52fe\uc805\u4e07\uc7f7\ubdbd\u3311\ua890\u2eae\ua46a\u1d8d") + this.qer.headCenter().toShortString());
            longIterator = longOpenHashSet2.iterator();
            while (longIterator.hasNext()) {
                long l = longIterator.nextLong();
                if (this.qfb.getOrDefault(l, 0) > this.qfi) continue;
                this.qlf(BlockPos.fromLong((long)l), 600);
                this.qex.add(l);
            }
            this.qer.dropHead();
        }
        if (this.qfj == null && !this.qfo) {
            this.qfj = this.qeq.best((Vec3d)objectIterator, (Vec3d)entry, (LongSet)this.qex);
        }
        if (this.qfj == null) {
            this.qfm = this.qfi + 4;
        }
        this.qfk = 0;
        if (trace != null) {
            this.qlj(this.qfj == null ? a.c(-550309427, "\uf1b6\u881b\u02c5\u9cbb\u1722\u91dd\u2b8f\ua27f\u3c2b\ub6df\u3104") + this.qeq.targetCount() + a.d("\u2ee9\u570c\uddca\u43a8\uc86a\u4ed9\uf49b\u7d6d", 662695574, 420134999) + (this.qfo ? a.b("\uccea\ub557\u3f97\ua1ad\u2a31\uac93\u1690\u9f74\u0120\u8b9b\u0c45\uf633\u78ed", 1169476811) : "") + a.c(-481008132, "\u65d4") : a.c(19509695, "\ub1ca\uc867\u42b9\udcc7\u575e") + this.qfj.target().toShortString() + a.c(-106514153, "\ub930\uc0cf\u4a1d\ud467\u5fb1\ud916\u630b") + this.qfj.path().length / 3 + a.c(-462008687, "\u4eb7\u3745\ubd9a\u23f7\ua827\u2edf") + (int)this.qfj.cost() + a.b("\ubd85\uc460\u4ea6\ud0c4\u5b06\uddb5\u67f7\uee01\u7010", 1665056172) + this.qeq.targetCount() + a.b("\udd4c\ua4ae\u2e7a\ub010\u3bd8\ubd6a\u0777", 1148312939) + this.qer.size() + a.b("\u689c\u116c\u9baa\u058f", 2061134008) + clientPlayerEntity.getBlockPos().toShortString());
        }
        this.qgc = Long.MIN_VALUE;
    }

    private boolean qkr(World world, BlockPos blockPos) {
        BlockState blockState = world.getBlockState(blockPos);
        return !blockState.isAir() && this.qfe.test(blockState) && !this.qew.containsKey(blockPos.asLong());
    }

    private List<BlockPos> qks(int n, int n2, int n3, int n4, int n5, int n6) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>(3);
        if (n4 == n && n6 == n3) {
            if (n5 < n2) {
                arrayList.add(new BlockPos(n, n2 - 1, n3));
            }
            return arrayList;
        }
        if (n5 > n2) {
            arrayList.add(new BlockPos(n, n2 + 2, n3));
            arrayList.add(new BlockPos(n4, n5 + 1, n6));
            arrayList.add(new BlockPos(n4, n5, n6));
            return arrayList;
        }
        arrayList.add(new BlockPos(n4, n2 + 1, n6));
        arrayList.add(new BlockPos(n4, n2, n6));
        return arrayList;
    }

    private void qkt(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos, boolean bl) {
        Vec3d vec3d = this.qkx(world, clientPlayerEntity, blockPos);
        if (vec3d == null) {
            BlockPos blockPos2 = qdz.qla(world, clientPlayerEntity, clientPlayerEntity.getEyePos(), blockPos);
            if (blockPos2 != null && !blockPos2.equals((Object)blockPos) && this.qlc(world, blockPos2) && (vec3d = this.qkx(world, clientPlayerEntity, blockPos2)) != null) {
                this.qku(blockPos2, world.getBlockState(blockPos2).getBlock(), this.qfe.test(world.getBlockState(blockPos2)), vec3d);
            }
            return;
        }
        this.qku(blockPos, world.getBlockState(blockPos).getBlock(), bl || this.qfe.test(world.getBlockState(blockPos)), vec3d);
    }

    private void qku(BlockPos blockPos, Block block, boolean bl, Vec3d vec3d) {
        this.qkv(blockPos, block, bl, vec3d, false);
    }

    private void qkv(BlockPos blockPos, Block block, boolean bl, Vec3d vec3d, boolean bl2) {
        if (blockPos.equals((Object)this.qfr)) {
            return;
        }
        this.qgz = bl2;
        this.qlj(a.d("\u23e6\u5a47\ud083\u4ef6\uc52b\u43d1", -296734278, -1279978952) + blockPos.toShortString() + a.c(1884253044, "\u6b55") + block.getTranslationKey().replace(a.d("\u9dc0\ue47f\u6eaf\uf0d2\u7b0d\ufdf9\u47e9\uce1c\u5044\udafe\u5d2b\ua74b\u298f\ub039\u3a78\ubcd3", -1621958378, -237470556), "") + (bl ? a.d("\ud0ed\ua928", -1642896548, 1212593043) : ""));
        this.qfr = blockPos.toImmutable();
        this.qfs = block;
        this.qft = bl;
        if (bl) {
            this.qfc.add(this.qfr.asLong());
        }
        this.qfu = vec3d;
        this.qfv = new Object();
        this.qfw = this.qfi;
        this.qgk = 0;
        if (!bl2) {
            this.qfx = null;
        }
    }

    private static Vec3d qkw(ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = clientPlayerEntity.getRotationVec(1.0f);
        if (BlockPos.ofFloored((Position)vec3d).equals((Object)blockPos)) {
            return vec3d.add(vec3d2.x * 0.6, -0.3, vec3d2.z * 0.6);
        }
        double d = Math.max(0.001, Math.sqrt(vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z));
        return new Vec3d((double)blockPos.getX() + 0.5 + vec3d2.x / d * 0.25, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5 + vec3d2.z / d * 0.25);
    }

    private Vec3d qkx(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = clientPlayerEntity.getRotationVec(1.0f);
        Vec3d vec3d3 = null;
        double d = Double.MAX_VALUE;
        double d2 = (this.qep.nextDouble() - 0.5) * 0.3;
        double d3 = (this.qep.nextDouble() - 0.5) * 0.3;
        block0: for (Direction direction : Direction.values()) {
            BlockPos blockPos2 = blockPos.offset(direction);
            if (!world.getBlockState(blockPos2).getOutlineShape((BlockView)world, blockPos2).isEmpty()) continue;
            Vec3d vec3d4 = new Vec3d((double)direction.getOffsetX(), (double)direction.getOffsetY(), (double)direction.getOffsetZ());
            Vec3d vec3d5 = Vec3d.ofCenter((Vec3i)blockPos).add(vec3d4.multiply(0.5));
            if (vec3d.subtract(vec3d5).dotProduct(vec3d4) <= 0.02) continue;
            Vec3d vec3d6 = direction.getAxis() == Direction.Axis.X ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(1.0, 0.0, 0.0);
            Vec3d vec3d7 = direction.getAxis() == Direction.Axis.Y ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(0.0, 1.0, 0.0);
            for (double[] dArray : qej) {
                double d4;
                double d5;
                double d6;
                double d7 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d2 : dArray[0];
                double d8 = dArray[0] == 0.0 && dArray[1] == 0.0 ? d3 : dArray[1];
                Vec3d vec3d8 = vec3d5.add(vec3d6.multiply(d7)).add(vec3d7.multiply(d8));
                Vec3d vec3d9 = vec3d8.subtract(vec3d);
                double d9 = vec3d9.length();
                if (d9 > 4.4 || d9 < 0.3 || (d6 = Math.sqrt(vec3d9.x * vec3d9.x + vec3d9.z * vec3d9.z)) < 0.25 || !qdz.qky(world, clientPlayerEntity, vec3d, blockPos, vec3d8)) continue;
                int n = 0;
                for (double[] dArray2 : qei) {
                    d5 = MathHelper.clamp((double)(d7 + dArray2[0]), (double)-0.47, (double)0.47);
                    double d10 = MathHelper.clamp((double)(d8 + dArray2[1]), (double)-0.47, (double)0.47);
                    if (!qdz.qky(world, clientPlayerEntity, vec3d, blockPos, vec3d5.add(vec3d6.multiply(d5)).add(vec3d7.multiply(d10)))) continue;
                    ++n;
                }
                double d11 = Math.acos(MathHelper.clamp((double)vec3d9.multiply(1.0 / d9).dotProduct(vec3d2), (double)-1.0, (double)1.0));
                d5 = d11 + (double)(qei.length - n) * 0.35 + ((d4 = d6 / Math.max(0.05, Math.abs(vec3d9.y))) < 0.4 ? (0.4 - d4) * 2.0 : 0.0);
                if (d5 < d) {
                    d = d5;
                    vec3d3 = vec3d8;
                }
                if (n == qei.length) continue block0;
            }
        }
        return vec3d3;
    }

    private static boolean qky(World world, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, BlockPos blockPos, Vec3d vec3d2) {
        Vec3d vec3d3 = vec3d2.subtract(vec3d);
        double d = vec3d3.length();
        if (d < 1.0E-4) {
            return false;
        }
        Vec3d vec3d4 = vec3d2.add(vec3d3.multiply(0.08 / d));
        BlockHitResult blockHitResult = world.raycast(new RaycastContext(vec3d, vec3d4, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity));
        if (blockHitResult.getType() != HitResult.Type.BLOCK || !blockHitResult.getBlockPos().equals((Object)blockPos)) {
            return false;
        }
        for (Box box : qhs) {
            if (!box.contains(vec3d) && !box.raycast(vec3d, vec3d4).isPresent()) continue;
            return false;
        }
        return true;
    }

    private static void qkz(World world, ClientPlayerEntity clientPlayerEntity) {
        qhs.clear();
        for (Entity entity : world.getOtherEntities((Entity)clientPlayerEntity, clientPlayerEntity.getBoundingBox().expand(7.0), EntityPredicates.CAN_HIT)) {
            qhs.add(entity.getBoundingBox().expand((double)entity.getTargetingMargin()));
        }
    }

    private static BlockPos qla(World world, ClientPlayerEntity clientPlayerEntity, Vec3d vec3d, BlockPos blockPos) {
        BlockHitResult blockHitResult = world.raycast(new RaycastContext(vec3d, Vec3d.ofCenter((Vec3i)blockPos), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity));
        if (blockHitResult.getType() != HitResult.Type.BLOCK || blockHitResult.getBlockPos().equals((Object)blockPos)) {
            return null;
        }
        return blockHitResult.getBlockPos();
    }

    static BlockPos standing(World world, ClientPlayerEntity clientPlayerEntity) {
        BlockPos blockPos = clientPlayerEntity.getBlockPos();
        if (clientPlayerEntity.getY() - (double)blockPos.getY() >= 0.49 && !world.getBlockState(blockPos).getCollisionShape((BlockView)world, blockPos).isEmpty()) {
            return blockPos.up();
        }
        return blockPos;
    }

    public static BlockPos trapped(World world, ClientPlayerEntity clientPlayerEntity) {
        Box box = clientPlayerEntity.getBoundingBox().contract(0.001);
        if (world.isSpaceEmpty((Entity)clientPlayerEntity, box)) {
            BlockPos blockPos = BlockPos.ofFloored((double)clientPlayerEntity.getX(), (double)box.minY, (double)clientPlayerEntity.getZ()).up();
            return clientPlayerEntity.isCrawling() && qdz.qlb(world, blockPos) ? blockPos : null;
        }
        BlockPos blockPos = BlockPos.ofFloored((Position)clientPlayerEntity.getEyePos());
        if (qdz.qlb(world, blockPos)) {
            return blockPos;
        }
        BlockPos blockPos2 = BlockPos.ofFloored((double)clientPlayerEntity.getX(), (double)box.minY, (double)clientPlayerEntity.getZ());
        if (qdz.qlb(world, blockPos2)) {
            return blockPos2;
        }
        for (BlockPos blockPos3 : BlockPos.iterate((BlockPos)BlockPos.ofFloored((double)box.minX, (double)box.minY, (double)box.minZ), (BlockPos)BlockPos.ofFloored((double)box.maxX, (double)box.maxY, (double)box.maxZ))) {
            if (!qdz.qlb(world, blockPos3) || !world.getBlockState(blockPos3).getCollisionShape((BlockView)world, blockPos3).getBoundingBox().offset(blockPos3).intersects(box)) continue;
            return blockPos3.toImmutable();
        }
        return null;
    }

    private static boolean qlb(World world, BlockPos blockPos) {
        BlockState blockState = world.getBlockState(blockPos);
        return !blockState.isAir() && blockState.getFluidState().isEmpty() && blockState.getHardness((BlockView)world, blockPos) >= 0.0f && blockState.isFullCube((BlockView)world, blockPos);
    }

    private boolean qlc(World world, BlockPos blockPos) {
        if (this.qfg == null || !this.qfg.contains(blockPos) || this.qev.contains(blockPos.asLong())) {
            return false;
        }
        BlockState blockState = world.getBlockState(blockPos);
        return !blockState.isAir() && blockState.getFluidState().isEmpty() && blockState.getHardness((BlockView)world, blockPos) >= 0.0f;
    }

    private static boolean qld(World world, BlockPos blockPos) {
        return !world.getBlockState(blockPos).getCollisionShape((BlockView)world, blockPos).isEmpty();
    }

    private static boolean qle(World world, BlockPos blockPos) {
        VoxelShape voxelShape = world.getBlockState(blockPos).getCollisionShape((BlockView)world, blockPos);
        return !voxelShape.isEmpty() && voxelShape.getMax(Direction.Axis.Y) > 0.25;
    }

    private void qlf(BlockPos blockPos, int n) {
        this.qlj(a.c(-564323151, "\u1cc7\u656e\uefbf\u71d7\ufa50") + blockPos.toShortString() + a.d("\uc928", 1780711411, -1700415750) + n);
        this.qew.put(blockPos.asLong(), (long)(this.qfi + n));
    }

    private void qlg(ClientPlayerEntity clientPlayerEntity) {
        Vec3d vec3d = clientPlayerEntity.getEntityPos();
        this.qgn = this.qfx != null && this.qfr == null && this.qgm != null && vec3d.squaredDistanceTo(this.qgm) < 4.0E-4 ? ++this.qgn : 0;
        this.qgm = vec3d;
    }

    private void qlh(World world) {
        Iterator<qcu> iterator = this.qey.iterator();
        while (iterator.hasNext()) {
            qcu qcu2 = iterator.next();
            if (this.qfi - qcu2.tick() > 60) {
                iterator.remove();
                continue;
            }
            BlockPos blockPos = BlockPos.fromLong((long)qcu2.pos());
            if (world.getBlockState(blockPos).getBlock() != qcu2.block()) {
                this.qez.remove(qcu2.pos());
                continue;
            }
            int n = this.qez.getOrDefault(qcu2.pos(), -1);
            if (n < 0) {
                this.qez.put(qcu2.pos(), this.qfi);
                int n2 = this.qfa.addTo(qcu2.pos(), 1) + 1;
                if (n2 < 2) continue;
                this.qli(qcu2.pos(), a.b("\ue29e\u9b2c\u11e1\u8f9a\u044b", 2091639535));
                iterator.remove();
                continue;
            }
            if (this.qfi - n <= 25) continue;
            this.qli(qcu2.pos(), a.c(8754864, "\u96c5\uef73\u65b5\ufbdc\u7017\uf6a7"));
            iterator.remove();
        }
    }

    private void qli(long l, String string) {
        this.qev.add(l);
        this.qez.remove(l);
        ++this.qfq;
        this.qfl = true;
        this.qlj(a.b("\u387f\u41cd\ucb11\u552e", -1674627047) + BlockPos.fromLong((long)l).toShortString() + a.b("\uc262", 1437909571) + string);
    }

    private void qlj(String string) {
        Consumer<String> consumer = trace;
        if (consumer != null) {
            consumer.accept(this.qfi + a.d("\u123e", 9087797, -99043030) + string);
        }
    }

    private /* synthetic */ boolean lambda$endTick$4(World world, long l) {
        return !this.qet.isGhost(l) && world.getBlockState(BlockPos.fromLong((long)l)).isAir();
    }

    static {
        qhs = new ArrayList<Box>();
        qhw = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    }

    private static /* synthetic */ int bsi(int n, int n2) {
        return n - n2 | 0x4DAD0EE;
    }

    private static /* synthetic */ int bsj(int n, int n2) {
        return qdz.bsi(n, n2) + n;
    }

    private static /* synthetic */ int bsk(int n, int n2) {
        return n * n2 | 0x22A1611;
    }
}

