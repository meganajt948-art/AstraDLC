/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen
 *  net.minecraft.client.gui.screen.ingame.GenericContainerScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.state.property.Property
 *  net.minecraft.text.Text
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
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

import a.ign;
import a.kfa;
import a.lex;
import a.lfa;
import a.mpm;
import a.nxa;
import a.pjd;
import a.pjn;
import a.pjw;
import a.pmc;
import a.pmf;
import a.pnc;
import a.pnf;
import a.pnz;
import a.ppu;
import a.pqf;
import a.pqq;
import a.pqx;
import a.prp;
import a.prt;
import a.prz;
import a.psf;
import a.ptr;
import a.pud;
import a.pyd;
import a.tcz;
import a.tvz;
import a.txs;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vlg;
import a.vlj;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vmu;
import a.wap;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
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

public class mpq
extends pnc {
    private static final String mpr = a.b("\u37ba\u4e2c\uc4fd\u5a84", 1693399030);
    private static final String mps = a.b("\u2a1b\u539c\ud95c\u472f", 1390946888);
    private static final List<BlockPos> mpt = Collections.emptyList();
    private static final int[] mpu = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
    private static final float mpv = -55.0f;
    private static final int mpw = 2400;
    private static final long mpx = 6000L;
    private static final int mpy = 2;
    private static final int mpz = 200;
    private static final int mqa = 3;
    private static final int mqb = 100;
    private static final float mqc = 86.0f;
    private final vmc mqd = this.add(new vmc(a.d("\u2f9e\u5603\udcc9\u42e0\uc961\u4fc7\uf586\u7c61\ue228", -2028986025, -1575547251), 10.0, 1.0, 30.0, 1.0));
    private final vlj mqe = this.add(new vlj(a.b("\ue5d2\u9c40\u1693\u88f9\u037a\u8587\u3fd1\ub63a\u2862", 1473504663), vlg.LOOT, ppu.END_DEFAULTS));
    private final vkl mqf = this.add(new vkl(a.c(-678181698, "\uc4e2\ubd75\u37b0\ua984\u2211\ua4b0\u1ee4\u9713\u0957"), false));
    private final vkl mqg = this.add(new vkl(a.d("\ub4b0\ucd34\u47ed\ud992\u5200\ud4e2\u6eb2\ue756\u7909\uf3b9", 654443813, 53916107), false));
    private final vmu mqh = this.add(new vmu(a.b("\u9c9a\ue519\u6fdd\uf1bf\u7a2d\ufcf9\u4681\ucf7a", -871719743), a.d("\u1f6b\u66d5\uec5d\u7229\uf9f9", 2023181717, -397127014), 32));
    private final vmu mqi = this.add(new vmu(a.c(-277864943, "\u1e55\u67c7\ued14\u737e\uf8fd\u7e29\uc451\u4daa"), a.d("\ua9f6\ud048\u5ac0\uc4b4\u4f6b", 1969651208, 141612954), 120));
    private final vlv mqj = this.add(new vlv(a.d("\ue313\u9a93\u1049\u8e31\u05f3\u835d\u3913\ub0e4\u2eef\ua41c\u23d4", -98598428, -323591512), a.d("\u13a6\u6a30\ue0e1\u7e98", -369263833, 370763981), a.b("\u41c7\u3851\ub280\u2cf9", 925188491), a.c(70318726, "\ufad5\u8352\u0992\u97e1")));
    private final vmu mqk = this.add(new vmu(a.c(2023459489, "\u8aff\uf378\u79b8\ue7cb\u6c4c\ueab3\u50ef\ud912\u4745"), a.b("\u2ff3\u5649\udc90", 1374891925), 32));
    private final vkl mql = this.add(new vkl(a.b("\ub318\uca92\u4046\ude2f\u55af\ud34c\u6902\ue0e9\u7eb7\uf417", -1426279615), false));
    private final vkw mqm = this.add(new vkw(a.b("\u3486\u4d1c\uc7df\u59a9\ud263\u549d\uee99\u677e\uf92c\u739a\uf44b\u0e3d\u80e3", 1860777157), new vkq(a.b("\uf219\u8b9f\u014a\u9f37\u14fd\u925a\u284d\ua1fd\u3fad\ub516\u3281\uc8a4\u4675\udfd7\u558c\ud37a", 1798107739), vhz.LAYERS, () -> ign.openWalk(a.c(693239075, "\ufd65\u84e0\u0e32\u9058\u1ba5\u9d3f\u2766")))));
    private static mpq mqn;
    private final pnz mqo = new pnz();
    private int mqp = 0;
    private mpm mqq = mpm.RESTOCK_AND_DUMP;
    private int mqr = 0;
    private long mqs = 0L;
    private long mqt = 0L;
    private int mqu = 0;
    private int mqv = 0;
    private int mqw = 0;
    private int mqx = -1;
    private List<BlockPos> mqy = null;
    private int mqz = 0;
    private final Set<BlockPos> mra = new HashSet<BlockPos>();
    private int mrb = 0;
    private int mrc = 0;
    private final List<String> mrd = new ArrayList<String>(List.of(a.b("\u6b5b\u12eb\u983c", 1128689517), a.d("\ud59b\uac2f\u26f3\ub888\u3350", -1629421280, 1886703750), a.c(360675067, "\u72b2\u0b78\u81af\u1fa0\u9409\u12c7\ua897\u2168")));
    private int mre = 3;
    private pmf mrf = null;
    private int mrg = 0;
    private boolean mrh = false;
    private boolean mri = false;
    private boolean mrj = false;
    private boolean mrk = false;
    private BlockPos mrl = null;
    private String mrm = "";
    private int mrn = 0;
    private boolean mro = false;
    private BlockPos mrp = null;
    private int mrq = 0;
    private BlockPos mrr = null;
    private int mrs = 0;
    private BlockPos mrt = null;
    private int mru = 0;
    private int mrv = 0;
    private int mrw = 0;
    private int mrx = 1;
    private boolean mry = false;
    private BlockPos mrz = null;
    private int msa = 0;
    private boolean msb = false;
    private int msc = 0;
    private int msd = 0;
    private int mse = 0;
    private int msf = 0;
    private int msg = 0;
    private int msh = 0;
    private int msi = 0;
    private Vec3d msj = null;
    private boolean msk = false;
    private final Set<Integer> msl = new HashSet<Integer>();
    private final Set<Integer> msm = new HashSet<Integer>();
    private int msn = 0;
    private double mso = Double.MAX_VALUE;
    private int msp = -1;
    private boolean msq = false;
    private int msr = 0;
    private int mss = 0;
    private boolean mst = false;
    private boolean msu = false;
    private int msv = 0;
    private int msw = 0;
    private int msx = 0;
    private final Queue<Runnable> msy = new LinkedList<Runnable>();
    private int msz = 0;
    private long mta = 0L;
    private int mtb = 0;
    private float mtc = 0.0f;
    private boolean mtd = false;
    private int mte = 0;
    private int mtf = 0;
    private float mtg = 0.0f;
    private int mth = 0;
    private Vec3d mti = null;
    private int mtj = 0;
    private int mtk = 0;
    private final pjw mtl = new pjw().neuro(lex.END);
    private final pud mtm = pud.INSTANCE;
    private boolean mtn = false;
    private boolean mto = false;
    private boolean mtp = false;
    private boolean mtq = false;
    private boolean mtr = false;
    private float mts = 0.0f;
    private float mtt = 0.0f;
    private float mtu = 0.0f;
    private float mtv = 0.0f;
    private PlayerEntity mtw = null;
    private Vec3d mtx = null;
    private final Random mty = new Random();
    private float mtz = 0.0f;
    private boolean mua = false;
    private boolean mub = false;
    private boolean muc = false;
    private int mud = 0;
    private int mue = 0;
    private int muf = 0;
    private int mug = 0;
    private int muh = 0;
    private int mui = -1;
    private int muj = 0;
    private int muk = -1;
    private int mul = 0;
    private int mum = 0;
    private boolean mun = false;
    private int muo = 0;
    private int mup = 0;
    private int muq = 0;
    private float mur = 0.0f;
    private boolean mus = false;
    private World mut = null;
    private int muu = -1;
    private int muv = 0;
    private boolean muw = false;
    private boolean mux = false;
    private Vec3d muy = null;
    private double muz = 0.0;
    private double mva = 0.0;
    private double mvb = 0.0;
    private int mvc = 0;
    private double mvd = 0.0;
    private boolean mve = false;
    private int mvf = 0;
    private int mvg = 0;
    private boolean mvh = false;
    private int mvi = 0;
    private int mvj = 0;
    private BlockPos mvk = null;
    private final pyd mvl = new pyd();
    private psf mvm = null;
    private pqq mvn = null;
    private BlockPos mvo = null;
    private boolean mvp = false;
    private boolean mvq = false;
    private boolean mvr = false;
    private final double[] mvs = new double[2];
    private double mvt = Double.NaN;
    private int mvu = 0;
    private int mvv = 0;
    private final Set<Long> mvw = new HashSet<Long>();
    private int mvx = 0;
    private boolean mvy = false;
    private String mvz = null;
    private int mwa = 0;
    private int mwb = 0;
    private final Map<ItemStack, Boolean> mwc = new IdentityHashMap<ItemStack, Boolean>();
    private int mwd = -1;
    private int mwe = -1;
    private int mwf = 0;
    private float mwg = 10.0f;
    private int mwh = 0;
    private int mwi = 0;
    private BlockPos mwj = null;
    private long mwk = 0L;
    private int mwl = -1;
    private int mwm = -100000;
    private String mwn = "";
    private Vec3d mwo = null;
    private int mwp = 0;
    private int mwq = 0;
    private int mwr = -1;
    private int mws = -100000;
    private final int[] mwt = new int[]{-1, -1};
    private final int[] mwu = new int[2];
    private final int[] mwv = new int[2];
    private final int[] mww = new int[2];
    private final int[] mwx = new int[2];
    private final boolean[] mwy = new boolean[2];
    private World mwz = null;
    private PlayerEntity mxa = null;
    private Vec3d mxb = null;
    private int mxc = -1;
    private volatile boolean mxd = false;
    private int mxe = 0;
    private int mxf = 0;
    private int mxg = 0;
    private int mxh = 0;
    private String mxi = "";
    private boolean mxj = false;
    private boolean mxk = false;
    private volatile int mxl = -100000;
    private volatile String mxm = null;
    private PlayerEntity mxn = null;
    private int mxo = -100000;
    private static /* synthetic */ long mxp;
    private static /* synthetic */ int mxq;

    public mpq() {
        super(a.c(441565294, "\uc028\ub9ad\u337f\uad15\u26e8\ua072\u1a2b"), a.d("\u5aae\u232f\ua9eb\u379e\ubc43\u3aea\u80ea\u097e\u970a\u1db1\u9a26\u6007\ueecf\u7765\ufd31\u7b9f\uc1dc\u4e46\ud4fb\u52aa\udb48\ua11a\u2ffa\ub472\u321b\ub8d0\u0164\u8f67\u15dc\u938e\u183d\ue6f7", 2145421006, 1436539906), kfa.PLAYER);
        this.mqk.visibleWhen(() -> a.d("\uc18c\ub80b\u32cb\uacb8", 1897598553, -1422667898).equals(this.mqj.get()));
        if (mqn == null) {
            mqn = this;
        }
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    public static mpq mainInstance() {
        return mqn;
    }

    public static void onMessage(Text text) {
        mpq mpq2 = mqn;
        if (mpq2 != null && mpq2.isEnabled() && text != null) {
            mpq2.onChatMessage(text.getString());
        }
    }

    public void copySettingsFrom(mpq mpq2) {
        if (mpq2 == null || mpq2 == this) {
            return;
        }
        this.mqd.set(mpq2.mqd.get());
        this.mqe.set(mpq2.mqe.ids());
        this.mqf.set(mpq2.mqf.get());
        this.mqg.set(mpq2.mqg.get());
        this.mqh.set(mpq2.mqh.get());
        this.mqi.set(mpq2.mqi.get());
        this.mqj.set(mpq2.mqj.get());
        this.mqk.set(mpq2.mqk.get());
    }

    public String getStateDescription() {
        if (!this.mwn.isEmpty()) {
            return this.mwn;
        }
        return this.mqq == null ? "" : this.mqq.mpn;
    }

    public vmo[] botSettings() {
        return new vmo[]{this.mqh, this.mqi, this.mqj, this.mqk, this.mqd, this.mqf, this.mqg};
    }

    public void onBotSettingChanged() {
    }

    public vlj lootList() {
        mpq mpq2 = mqn;
        return this.driver != null && mpq2 != null && mpq2 != this && !mpq2.isBotInstance() ? mpq2.mqe : this.mqe;
    }

    private boolean mxr(ItemStack itemStack) {
        return ppu.picked(itemStack, this.lootList().ids());
    }

    public String queueNote() {
        return this.mwn;
    }

    private Object mxs() {
        return this.driver != null ? this.driver : pjd.MAIN;
    }

    public tvz walkBrain() {
        return this.mvl.brain();
    }

    public List<BlockPos> getBotPath() {
        return this.mqy;
    }

    public int getBotPathIndex() {
        return this.mqz;
    }

    public BlockPos getBotTarget() {
        if (this.mrr != null) {
            return this.mrr;
        }
        if (this.mrz != null) {
            return this.mrz;
        }
        return this.mrl;
    }

    public int getBrokenVases() {
        return this.mqr;
    }

    public long getFarmMillis() {
        return this.mqs;
    }

    public int getTotalVases() {
        return this.mqu;
    }

    public int getTotalSand() {
        return this.mqv;
    }

    public int getTotalBrushes() {
        return this.mqw;
    }

    public void resetFarmStats() {
        this.mqs = 0L;
        this.mqu = 0;
        this.mqv = 0;
        this.mqw = 0;
    }

    private String mxt() {
        if (!a.c(1694846919, "\u4f94\u3613\ubcd3\u22a0").equals(this.mqj.get())) {
            return a.c(2020307053, "\u700c\u09ba\u836b\u1d12\u9680\u1079\uaa2d\u23de\ubd89");
        }
        String string = this.mqk.get();
        String string2 = string = string == null ? "" : string.trim();
        while (string.startsWith(a.c(-1685469480, "\uc6f6"))) {
            string = string.substring(1).trim();
        }
        if (string.toLowerCase().startsWith(a.b("\u0854\u71f3\ufb33\u6540\ueec7", -1152514010))) {
            string = string.substring(5).trim();
        }
        if (string.isEmpty()) {
            string = a.c(990254011, "\u13dd\u6a67\ue0be");
        }
        return a.d("\u5af9\u235e\ua99e\u37ed\ubc6a", -1223607346, -57908923) + string;
    }

    @Override
    protected void onEnable() {
        if (this.getPlayer() != null) {
            this.mtc = this.getPlayer().getHealth();
        }
        if (this.driver == null) {
            try {
                nxa nxa2 = Flow.getInstance().getModuleManager().get(nxa.class);
                if (nxa2 != null && nxa2.isEnabled()) {
                    nxa2.setEnabled(false);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        this.nbv();
        this.mvw.clear();
        this.mvt = Double.NaN;
        this.mvu = 0;
        this.mqo.reset();
        this.mxg = 0;
        this.mxh = 0;
        this.mxj = false;
        this.mxk = false;
        this.mxl = -100000;
        this.mxn = null;
        this.mxu();
        if (this.mzh()) {
            pjd.at(this.mxs(), mpq.nak(this.naj()));
            this.myd(mpm.FARMING);
        } else if (this.getPlayer() != null && this.mzn(a.d("\u4abc\u337d\ub9df\u27d0\uac78", -996329450, 1544910574)) != null) {
            pjd.at(this.mxs(), mpq.nak(this.mqh.get()));
        }
    }

    @Override
    protected void onDisable() {
        this.mxu();
        this.nbw();
        if (this.driver == null) {
            pnf.clear();
        }
        this.mqt = 0L;
        this.mqx = -1;
        pjd.cancel(this.mxs());
        this.mwn = "";
    }

    private void mxu() {
        this.myd(mpm.RESTOCK_AND_DUMP);
        this.mqr = 0;
        this.mqy = null;
        this.mqz = 0;
        this.mra.clear();
        this.mrh = false;
        this.mri = false;
        this.mrj = false;
        this.mrk = false;
        this.mrl = null;
        this.mrm = "";
        this.mrb = 0;
        this.naa();
        this.mrn = 0;
        this.mro = false;
        this.mrp = null;
        this.mrq = 0;
        this.mrr = null;
        this.mrs = 0;
        this.mrt = null;
        this.mru = 0;
        this.mrv = 0;
        this.mrw = 0;
        this.mrx = 1;
        this.mrz = null;
        this.msa = 0;
        this.msb = false;
        this.mwq = 0;
        this.msc = 0;
        this.msq = false;
        this.msr = 0;
        this.mss = 0;
        this.mst = false;
        this.msu = false;
        this.msv = 0;
        this.msx = 0;
        this.msw = 0;
        this.mwr = -1;
        this.myn();
        this.mxc = -1;
        this.mxe = 0;
        this.mse = 0;
        this.msf = 0;
        this.msg = 0;
        this.msh = 0;
        this.msi = 0;
        this.msj = null;
        this.msk = false;
        this.msl.clear();
        this.msm.clear();
        this.msn = 0;
        this.mso = Double.MAX_VALUE;
        this.msp = -1;
        if (this.mc.interactionManager != null) {
            this.mc.interactionManager.cancelBlockBreaking();
        }
        ptr.clear();
        this.mvk = null;
        this.muy = null;
        this.ndw();
        this.mud = 0;
        this.mue = 0;
        this.muf = 0;
        this.mug = 0;
        this.muh = 0;
        this.mui = -1;
        this.neb();
        this.mum = 0;
        this.mur = 0.0f;
        this.mus = false;
        this.mut = null;
        this.muu = -1;
        this.muv = 0;
        this.mvi = 0;
        this.mvj = 1200 + this.mty.nextInt(3000);
        this.mvc = 0;
        this.mvl.reset();
        this.mvm = null;
        this.mvd = 0.0;
        this.mve = false;
        this.mvf = 0;
        this.mvg = 0;
        this.mvy = false;
        this.mvz = null;
        this.mvx = 0;
        this.msy.clear();
        this.mrf = null;
        this.mrg = 0;
        this.mtb = 0;
        this.mtd = false;
        this.mte = 0;
        this.mtf = 0;
        this.mth = 0;
        this.mtj = 0;
        this.mti = null;
        this.mwf = 0;
        this.mwi = 0;
        this.mwj = null;
        this.mwl = -1;
        this.myy();
    }

    private void mxv() {
        this.mxw(true);
    }

    private void mxw(boolean bl) {
        this.mc.options.sneakKey.setPressed(bl);
        this.mc.options.useKey.setPressed(true);
        ptr.miss();
    }

    private void mxx() {
        if (this.mc.options == null) {
            return;
        }
        this.mc.options.useKey.setPressed(false);
        this.mc.options.sneakKey.setPressed(false);
    }

    private boolean mxy(float f) {
        this.nby(this.mto ? this.mts : this.mtl.intentYaw(), f);
        return Math.abs(this.mtl.intentPitch() - f) <= 0.75f;
    }

    private boolean mxz() {
        boolean bl = this.getPlayer().getHungerManager().getFoodLevel() < 18;
        int n = this.nei(Items.GOLDEN_CARROT);
        boolean bl2 = this.nci();
        if (this.mtf == 0) {
            if (!bl || n == -1) {
                if (this.mc.options.useKey.isPressed() && this.mqq != mpm.BRUSHING_SAND) {
                    this.mxx();
                    if (this.getPlayer().getMainHandStack().getItem() == Items.GOLDEN_CARROT) {
                        this.nat();
                    }
                }
                return false;
            }
            this.mtg = this.mtl.intentPitch();
            this.mtf = bl2 ? 2 : 1;
            this.mth = 0;
        }
        if (!(this.mtf == 3 || bl && n != -1)) {
            this.mxx();
            int n2 = this.mtf = bl2 ? 0 : 3;
            if (this.mtf == 0) {
                this.nat();
                return false;
            }
        }
        switch (this.mtf) {
            case 1: {
                this.mxx();
                if (!bl2 && !this.mxy(-55.0f)) break;
                this.mtf = 2;
                this.mth = 0;
                break;
            }
            case 2: {
                if (!bl2) {
                    this.mxy(-55.0f);
                }
                this.getPlayer().getInventory().setSelectedSlot(n);
                this.mxw(!bl2);
                ++this.mth;
                if (this.mth <= 200) break;
                this.mxx();
                this.mtf = 3;
                break;
            }
            case 3: {
                this.mxx();
                if (!bl2 && !this.mxy(this.mtg)) break;
                this.mtf = 0;
                this.nat();
                return false;
            }
        }
        return true;
    }

    private void mya() {
        if (this.nci()) {
            this.ncr();
            this.mc.options.sprintKey.setPressed(false);
            this.mc.options.jumpKey.setPressed(false);
        } else {
            pqf.resetKeys();
            this.ncf();
        }
    }

    private void myb() {
        this.mxx();
        this.mtf = 0;
        this.mth = 0;
    }

    private boolean myc(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        return itemStack.getItem() == Items.GOLDEN_CARROT || itemStack.getItem() == Items.WATER_BUCKET || this.nel(itemStack) || this.neo(itemStack);
    }

    private void myd(mpm mpm2) {
        if (this.mqq != mpm2) {
            this.mqq = mpm2;
            this.mwn = "";
        }
    }

    private void mye(String string) {
        if (!this.mvy) {
            this.mvy = true;
            this.mvx = 0;
            ++this.mqp;
        }
        if (string != null && this.mvz == null) {
            this.mvz = string;
        }
    }

    public void onChatMessage(String string) {
        boolean bl;
        String string2 = string.toLowerCase();
        if ((string2.contains(a.d("\u04c3\u7d73\uf7a2\u69a0\ue205\u64b1\udee6", 1326943706, 1424723233)) || string2.contains(a.b("\u1500\u6cb0\ue661\u7863\uf3c6\u757f\ucf25", 62787896)) || string2.contains(a.b("\u18b4\u617c\uefc4\u75aa\ufe7c\u78c0\uc298\u4b60\ud535\u5f87", -234152820)) || string2.contains(a.b("\ueedc\u976f\u1dcd\u87dd\u0869\u8eaa\u34f0\ubd02", -664933658)) || string2.contains(a.c(375933496, "\u4e6c\u37a0\ubd7a\u237e\ua8ab\u2e14\u902b\u1dc7\u8395\u0d34\u8efd\u7488\ufa5f\u6390\ue9b7\u6f4a\ud500\u5adc\uc01d\u463e\ucfbc"))) && this.isEnabled()) {
            String[] stringArray;
            String string3 = null;
            if (string2.contains(a.b("\u5d24\u24e7\uae3d\u304f\ubf83", -27960990)) && (stringArray = string.split(a.c(494879084, "\u452a\u3ce9\ub633\u2841\ua78d"))).length > 1 && (string3 = stringArray[1].split(a.c(-157270135, "\u3fa8"))[0].replaceAll(a.b("\u28d4\u5160\udb8c\u45b1\uce31\u48bb\uf284\u7b02\ue537\u6f9b\ue85c\u124b\u9c9e", 748693634), "")).isEmpty() && stringArray.length > 2) {
                string3 = stringArray[2].split(a.c(-517122748, "\u5565"))[0].replaceAll(a.c(-1245765227, "\u21c3\u5877\ud29b\u4ca6\uc726\u41ac\ufb93\u7215\uec20\u668c\ue14b\u1b5c\u9589"), "");
            }
            this.mxm = string3;
            this.mxl = this.mwa;
        }
        boolean bl2 = bl = string2.contains(a.d("\u2504\u5cc0\ud610", -166216364, 141335568)) && (string2.contains(a.d("\u7203\u0bc6\u8160\u1f63\u94b3\u1277", -691044894, 39127974)) || string2.contains(a.c(1326728985, "\u4321\u3a91\ub048\u2e37\ua5e1\u2325\u997f")) || string2.contains(a.d("\ue5a8\u9c14\u16b2\u88b8\u0365\u85d8\u3ff1", 1649753657, -1362239573))) || string2.contains(a.b("\uc8f3\ub14f\u3b82\ua5e4\u2e37\ua883\u12cd\u9b65\u0579\u8fc4\u0816\uf267\u7cbb\ue50c\u6f48\ue9a8\u53e6", 719046787));
        if (this.mqq == mpm.WARPING_TO_LOOT_BASE && !this.mro && bl) {
            this.mxd = true;
        }
        if (bl && (this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.TELEPORT_TO_SAVE)) {
            this.mqo.dismiss(this.getWorld());
        }
    }

    private void myf() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (clientPlayerEntity != this.mxn) {
            this.mxo = this.mwa;
        }
        this.mxn = clientPlayerEntity;
    }

    private void myg() {
        boolean bl;
        int n = this.mxl;
        if (this.mwa - n > 100) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        boolean bl2 = clientPlayerEntity.isDead() || clientPlayerEntity.getHealth() <= 0.0f;
        boolean bl3 = this.mqq == mpm.TELEPORT_TO_LOOT || this.mqq == mpm.TELEPORT_TO_SAVE || this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.WARPING_TO_LOOT_BASE && (this.mxc < 0 || this.mrn - this.mxc < 100);
        boolean bl4 = bl = !bl3 && this.mxo >= n - 100;
        if (bl2 || bl) {
            this.mxl = -100000;
            this.mye(this.mxm);
        }
    }

    private boolean myh() {
        StatusEffectInstance statusEffectInstance = this.getPlayer().getStatusEffect(StatusEffects.INVISIBILITY);
        if (statusEffectInstance != null) {
            return statusEffectInstance.getDuration() > 600;
        }
        return false;
    }

    private boolean myi() {
        StatusEffectInstance statusEffectInstance = this.getPlayer().getStatusEffect(StatusEffects.SPEED);
        if (statusEffectInstance != null) {
            return statusEffectInstance.getDuration() > 600;
        }
        return false;
    }

    private int myj(boolean bl) {
        StatusEffectInstance statusEffectInstance = this.getPlayer().getStatusEffect(bl ? StatusEffects.INVISIBILITY : StatusEffects.SPEED);
        return statusEffectInstance == null ? 0 : (statusEffectInstance.isInfinite() ? Integer.MAX_VALUE : statusEffectInstance.getDuration());
    }

    private boolean myk(boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 1;
        if (this.mwy[n] || this.mwu[n] > 0 || this.nab(bl) == 0) {
            return false;
        }
        int n3 = this.mww[n] > 0 ? Math.min(600, this.mww[n] * 3 / 4) : 600;
        return this.myj(bl) <= n3;
    }

    private void myl() {
        for (int i = 0; i < 2; ++i) {
            boolean bl = i == 0;
            int n = this.nab(bl);
            int n2 = this.myj(bl);
            if (this.mwt[i] >= 0 && n < this.mwt[i] && this.mwr == i && this.mwa - this.mws <= 3) {
                this.mwu[i] = 60;
                this.mwv[i] = n2;
                this.mwx[i] = 0;
            }
            this.mwt[i] = n;
            if (this.mwu[i] <= 0) continue;
            if (n2 > this.mwv[i]) {
                this.mwu[i] = 0;
                this.mww[i] = n2;
                if (i != 0) continue;
                this.mxh = 0;
                continue;
            }
            int n3 = i;
            this.mwu[n3] = this.mwu[n3] - 1;
            if (this.mwu[n3] != 0) continue;
            this.mym(i);
        }
    }

    private void mym(int n) {
        if (this.mwy[n]) {
            return;
        }
        this.mwy[n] = true;
        if (n == 0) {
            ++this.mxh;
            this.mxi = wap.s(a.c(-680538783, "\ucd32\ub49f\u3e41\ua075\u2beb\uad5d\u1716\u9ef8\u00bd\u8a16\u0dce\uf7b4\u7966\ue0d2\u6a9c\uec60\u5676\ud9f7\u435b\uc511\u4cfb\u36ac\ub81e\u2381\ua5b9\u2f66\u96ca\u1888\u8269\u046b\u8f96\u7146\ufb46\u62f2\ue4a2\u6e13\ud1c7\u5bb0\udd74"), a.b("\uda5b\ua3e8\u2935\ub733\u3c9d\ube39w\u898e\u17d6\u9d6d\u1ab2\ue0cf\u6e1c\uf7af\u7d83\ufb71\u4144\uca8d\u5423\ud27a\u5f98\u21dd\uaf6f\u34b2\ub2b5\u3867\u81a4\u0f84\u9505\u1323", -490348942));
        }
        this.notifyUser(n == 0 ? wap.s(a.c(-1615131009, "\u0e69\u77e4\ufd3a\u630e\ue890\u6e26\ud46d\u5d83\uc3c6\u496d\uceb5\u34cf\uba1d\u23a9\ua9e7\u2f1b\u950d\u1a8c\u8020\u066a\u8f80\uf5d7\u7b65\ue0fa\u66c2\uec15\u55b1\udbf3\u4141\uc75e\u4cec\ub272\u3878\ua18a\u27d9\uad6b\u12ba\u98dc\u1e5b\u87e7\u0db5\u730a\uf958\u7ea6\ue43c\u6a4f\ud381\u5927\udf2d\u44b3\ucac9\u305e\ub9bd\u3ff0\ua50e\u2b57\u90a5\u1620\u9c4f\u059f\u8b32\uf130\u7697\ufcc0\u6214\uebbc"), a.c(1280103327, "\ud7b7\uae24\u24f9\ubaff\u3151\ub3f5\u0dbb\u8442\u1a1a\u90a1\u177e\ued03\u63d0\ufa63\u704f\uf6bd\u4c88\uc741\u59ef\udfb6\u5254\u2c11\ua2a6\u397c\ubf06\u31c9\u8c17\u024f\u98b8\u1e98\u9524\u6b8d\ue1b0\u7c51\ufa0f\u70b3\ucb75\u410b\uc7dd\u5e1b\ud440\uaacc\u248a\ua726\u3df9\ub79d\u0a51\u8093\u06de\u9961\u1300\uedc3\u6019\ue647\u7cc8\uf29b\u4d38\ucffe\u458a\udc2e\u52e2\u28b9\uaf4b")) : wap.s(a.d("\ue5b6\u9c3b\u16e5\u88d1\u0355\u85e7\u3fa1\ub650\u280e\ua2fb\u2578\udf16\u51da\uc876\u4223\uc4d3\u7ed2\uf144\u6bf1\uedb7\u6453\u1e47\u90ba\u0b6a\u8d5a\u07ce\ube7e\u302f\uaadb\u2c8c\ua728\u59ad\ud3ef\u4a13\ucc0e\u46be\uf926\u731a\uf5cb\u6c67\ue62f\u989b\u1287\u953f\u0fae\u818b\u3844\ub2f8\u34bf\uaf23\u2104\udbc9\u527f\ud434\u4e94\uc091\u7b28\ufde2\u7788", 471337304, 77327489), a.c(-1089895976, "\u85f3\ufc60\u76bd\ue8bb\u6315\ue1b1\u5f83\ud609\u4852\uc29d\u4530\ubf3e\u31ea\ua821\u266a\ua486\u1ec1\u9505\u0ba2\u8df7\u040b\u7e5f\uf4f2\u6b4e\ued38\u67e9\ude2b\u5075\ucafa\u4cd9\uc37a\u3da6\ub7e4\u2a04\uac58\u26ec\u994c\u1339\u9597\u0833\u8671\uf888\u76ce\uf560\u6fc4\ue1b7\u5c0a\ud2a9\u50f4\ucf48\u4134\ubb99\u322c\ub061\u2e85\ua0d3\u1b19\u9db3\u17ca\u8e1a")), false);
    }

    private void myn() {
        for (int i = 0; i < 2; ++i) {
            this.mwu[i] = 0;
            this.mwy[i] = false;
            this.mwx[i] = 0;
        }
    }

    private void myo(String string) {
        ++this.mxg;
        this.mxi = string;
    }

    private boolean myp() {
        int n = Math.max(this.mxg, this.mxh);
        if (n < 3) {
            return false;
        }
        if (!this.mxj) {
            this.notifyUser(wap.s(a.b("\u7255\u0bc3\u810b\u1f65\u94b2\u1216\ua844\u21eb\ubfae", -214207985) + n + a.b("\u6001\u19e4\u9331\u0d5b\u8695'\uba27\u339f\uadc7\u2738\ua0aa\u5a9a\ud41f\u4db3\uc7f8\u415e\ufb52\u7481\uee3e\u6867\ue1d5\u9bc6\u1576\u8ea5\u08d2\u8248\u3bac\ub5e3\u2f09\ua944\u22bf\udc20\u566e\ucf84\u49cb\uc37b\u7cab\uf6d3\u7047\ue9fe", 372006921) + this.mxi + a.d("\uf846\u81f0\u0b2d\u953f\u1ec3\u987f\u222a\uabd3\u35c7\ubf22\u38ed\uc291\u4c03\ud5e2\u5fae\ud944\u6316\uecc1\u7673\uf03f\u7997\u03ca\u8d2d\u16e0\u9092\u1a06\ua3e2\u2da5\ub741\u3112\ubaf1\u442f\uce6f\u57d6\ud182\u5b31\ue4ee\u6eda\ue848\u71f6\ufba3\u8516\u0f11\u88bc\u1266\u9c52\u25c0\uaf7e\u293e\ub2fc\u3c9e\uc644\u4ff2\uc9af\u534a\udd44\u66f7\ue072\u6a1d\uf3c1\u7d7d\u0762\u80c5\u0a95\u945d\u1df0\ua7ed\u2155\uab1f\u34fa\ube66\u3816\uc187\u4b77\ud522\u5ed5\ud88a\u623c", -429999544, 637485673), a.b("\u8c0b\uf5e5\u7f35\ue136\u6aec\uec5e\u5601\udff9\u41a8\ucb11\u48c5\ub2ae", -247953383) + n + a.c(180115865, "\u59a1\u2407\uaed3\u30d7\ubb7b\u3dc0\u8797\u0a76\u9036\u1a86\u9d5f\u675a\ue982\u7048\ufe0f\u7cec\uc6ae\u4903\ud3b2\u55e0\udc16\ua64a\u2c97\ub74e") + this.mxi + a.d("\ub785\uce33\u44ee\udea0\u5528\ud3e7\u69b8\ue04e\u7e64\uf4d9\u7766\u8900\u07d5\u9e6a\u144e\u92bc\u2c90\ua34d\u3dec\ubbbf\u3238\u4816\uc2ba\u5964\udf14\u51a0\ue868\u663b\uf8d0\u7a99\uf532\u0ff3\u85b1\u1c4d\u9a6e\u10da\uaf70\u2501\ua7ca\u3a63\ub424\ucec7\u449c\uc32c\u598e\ud7f6\u6e5a\ue0f3\u62dd\uf970\u7700\u8ddd\u0468", -1030383577, -1029689410)), false);
            this.mxj = true;
        }
        return true;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        boolean bl;
        block14: {
            ++this.mwa;
            if (this.isNotInWorld()) {
                if (this.mtn) {
                    this.mtn = false;
                    if (this.driver == null) {
                        this.mtm.reset();
                    }
                }
                this.mtw = null;
                this.mtx = null;
                this.mua = false;
                this.mub = false;
                this.muc = false;
                ptr.clear();
                this.mqt = 0L;
                this.mqx = -1;
                return;
            }
            if (this.mxj) {
                this.mxj = false;
                pqf.resetKeys();
                if (this.driver != null) {
                    this.setBotRunning(false);
                    this.driver.halted();
                } else {
                    this.setEnabled(false);
                }
                return;
            }
            this.myv();
            this.myw();
            pjd.keep(this.mxs());
            this.nbx();
            this.mtz = this.getPlayer().getYaw();
            this.mua = true;
            this.mvl.beginTick();
            bl = this.myq();
            if (bl && this.mc.options != null) {
                this.mvp = this.mc.options.sprintKey.isPressed();
                this.mvq = this.mc.options.sneakKey.isPressed();
            }
            try {
                this.myz();
                if (bl) {
                    this.myu();
                }
                this.nck();
                if (this.mud <= 0 || this.mc.options == null) break block14;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.myu();
                }
                this.nck();
                if (this.mud > 0 && this.mc.options != null) {
                    this.mc.options.attackKey.setPressed(false);
                    this.mc.options.useKey.setPressed(false);
                }
                this.myx();
                this.mub = this.mc.options != null && this.mc.options.attackKey.isPressed();
                boolean bl2 = this.muc = this.mc.options != null && this.mc.options.useKey.isPressed();
                if (this.driver == null) {
                    pnf.publish(this.mvl.shown(), this.mvl.shownAt(), bl, bl && this.myr(), this.mql.get(), this.getName());
                }
                throw throwable;
            }
            this.mc.options.attackKey.setPressed(false);
            this.mc.options.useKey.setPressed(false);
        }
        this.myx();
        this.mub = this.mc.options != null && this.mc.options.attackKey.isPressed();
        boolean bl3 = this.muc = this.mc.options != null && this.mc.options.useKey.isPressed();
        if (this.driver == null) {
            pnf.publish(this.mvl.shown(), this.mvl.shownAt(), bl, bl && this.myr(), this.mql.get(), this.getName());
        }
    }

    private boolean myq() {
        return this.driver == null && mqn == this && this.isEnabled() && tcz.walkGuide();
    }

    private boolean myr() {
        return this.mvr || this.getPlayer().isUsingItem() || this.ncm() || this.mrf != null || this.muw || this.mc.currentScreen != null;
    }

    private int mys(int n) {
        return this.myq() ? n * 3 : n;
    }

    private txs myt() {
        return lfa.walkModel(lex.END);
    }

    private void myu() {
        KeyBinding[] keyBindingArray;
        GameOptions gameOptions = this.mc.options;
        if (gameOptions == null || this.ncm() || this.mrf != null || this.muw) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey}) {
            keyBinding.setPressed(this.heldByHuman(keyBinding));
        }
        if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            if (gameOptions.sprintKey.isPressed() != this.mvp) {
                gameOptions.sprintKey.setPressed(true);
            }
        } else {
            gameOptions.sprintKey.setPressed(this.heldByHuman(gameOptions.sprintKey));
        }
        if (((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
            if (gameOptions.sneakKey.isPressed() != this.mvq) {
                gameOptions.sneakKey.setPressed(true);
            }
        } else {
            gameOptions.sneakKey.setPressed(this.heldByHuman(gameOptions.sneakKey));
        }
    }

    private void myv() {
        long l;
        long l2 = System.currentTimeMillis();
        if (this.mqt != 0L && (l = l2 - this.mqt) > 0L && l < 5000L) {
            this.mqs += l;
        }
        this.mqt = l2;
    }

    private void myw() {
        boolean bl;
        int n;
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n2 = 0;
        for (n = 0; n < playerInventory.size(); ++n) {
            ItemStack itemStack = playerInventory.getStack(n);
            if (!mpq.ndf(itemStack)) continue;
            n2 += itemStack.getCount();
        }
        n = this.mqq == mpm.FARMING || this.mqq == mpm.LOOTING_VASE || this.mqq == mpm.FARMING_SAND || this.mqq == mpm.BRUSHING_SAND || this.mqq == mpm.LOOTING_SAND || this.mqq == mpm.CHECK_PVP_COOLDOWN || this.mqq == mpm.ESCAPING || this.mqq == mpm.RUN_TO_FARM_COORDS ? 1 : 0;
        boolean bl2 = bl = this.getPlayer().currentScreenHandler != this.getPlayer().playerScreenHandler;
        if (this.mqx >= 0 && n2 > this.mqx && n != 0 && !bl) {
            this.mqw += n2 - this.mqx;
        }
        this.mqx = n2;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (this.mc.options == null) {
            return;
        }
        this.mc.options.attackKey.setPressed(this.mub);
        this.mc.options.useKey.setPressed(this.muc);
        while (this.mc.options.attackKey.wasPressed()) {
        }
        while (this.mc.options.useKey.wasPressed()) {
        }
        if (this.mud > 0) {
            this.silenceMovement();
        }
        if (this.mc.player != null && this.mc.world != null) {
            if (this.driver == null && !this.mux && this.mua && this.mtn && this.mud == 0) {
                this.mtm.remapHumanKeys(this.mc, this.mtm.cameraYaw(this.mc.player), this.mtu);
            }
            ptr.applyOwn(this.mc);
        }
    }

    private void myx() {
        KeyBinding[] keyBindingArray;
        if (this.mc.options == null || this.mud > 0) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{this.mc.options.forwardKey, this.mc.options.backKey, this.mc.options.leftKey, this.mc.options.rightKey, this.mc.options.jumpKey, this.mc.options.sneakKey, this.mc.options.sprintKey}) {
            if (!this.heldByHuman(keyBinding)) continue;
            keyBinding.setPressed(true);
        }
    }

    private void myy() {
        KeyBinding[] keyBindingArray;
        if (this.mc.options == null) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{this.mc.options.forwardKey, this.mc.options.backKey, this.mc.options.leftKey, this.mc.options.rightKey, this.mc.options.jumpKey, this.mc.options.sprintKey, this.mc.options.sneakKey, this.mc.options.attackKey, this.mc.options.useKey}) {
            if (this.heldByHuman(keyBinding)) continue;
            keyBinding.setPressed(false);
        }
    }

    private void myz() {
        boolean bl;
        this.muy = null;
        this.mux = false;
        this.mry = false;
        if (this.mse > 0) {
            --this.mse;
        }
        if (this.mum > 0) {
            --this.mum;
        }
        this.mur *= 0.99f;
        if (this.msf > 0) {
            --this.msf;
        }
        if (this.msg > 0) {
            --this.msg;
        }
        if (this.msh > 0) {
            --this.msh;
        }
        this.ndn();
        this.myf();
        this.myg();
        this.myl();
        if (this.mvy) {
            ++this.mvx;
            if (this.mvx >= 40) {
                this.mvy = false;
                this.mxu();
                this.myd(mpm.TELEPORT_TO_SAVE);
            }
            return;
        }
        if (this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqo.check((PlayerEntity)this.getPlayer(), System.currentTimeMillis(), 6000L)) {
            pjd.leave(this.mxs());
            this.mxu();
            this.myd(mpm.TELEPORT_TO_SAVE);
            this.notifyUser(a.c(1922611007, "\ub305\uce86\u404e\ude3a\u55e2\ud353\u6909\ue4e0\u7ab7\uf414\u73c3\u89b0\u0764\u9eda\u14f8\u9668\u2835\ua3f6\u3d24\ubb0f\u32fd\u48d0\uc611\u5db5\udfa6\u557e\uccf9\u629c\ufc73\u7a2e\uf1ea\u0b58\u850a\u1cf6\u9eb5\u1065\uafc6\u25bb\ua363\u3ec0") + mpq.nak(this.mqh.get()), false);
            return;
        }
        if (this.mza()) {
            return;
        }
        boolean bl2 = bl = this.mqq != mpm.WARPING_TO_LOOT_BASE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqq != mpm.RESTOCK_AND_DUMP;
        if (this.mwo != null && this.getPlayer().getEntityPos().squaredDistanceTo(this.mwo) < 1.0E-4 && bl && this.mvi <= 0 && this.mud == 0 && !this.myq() && (this.mc.options.forwardKey.isPressed() || this.mqy != null)) {
            ++this.mwp;
            if (this.mwp > 6 && this.getPlayer().isOnGround() && pqf.isJumpUseful(this.ncj())) {
                this.mc.options.jumpKey.setPressed(true);
            }
            if (this.mwp > 16) {
                this.mqy = null;
                this.mqz = 0;
                this.mse = 0;
                this.mwp = 0;
                ++this.mwq;
                if (this.mwq >= 3) {
                    this.mwq = 0;
                    if (this.mrr != null) {
                        this.nay(true);
                    } else if (this.mrz != null) {
                        this.ncz(true);
                    }
                }
            }
        } else {
            if (this.mwp > 0) {
                this.mwq = 0;
            }
            this.mwp = 0;
            this.mwo = this.getPlayer().getEntityPos();
        }
        int n = this.mwf = pqf.onClimbable((PlayerEntity)this.getPlayer()) ? this.mwf + 1 : 0;
        if (this.mc.currentScreen instanceof AbstractSignEditScreen) {
            this.mc.currentScreen.close();
            return;
        }
        if (this.mqq != mpm.RESTOCK_AND_DUMP && this.mc.currentScreen instanceof HandledScreen && !(this.mc.currentScreen instanceof InventoryScreen)) {
            this.mxx();
            this.mc.player.closeHandledScreen();
            return;
        }
        this.mc.options.sneakKey.setPressed(this.mc.options.useKey.isPressed() && this.myc(this.getPlayer().getMainHandStack()) && !this.nci());
        if (this.getPlayer().getHealth() <= 0.0f || this.getPlayer().isDead()) {
            if (this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && !this.mvy) {
                this.mye(null);
            }
            return;
        }
        if (this.mte > 0) {
            --this.mte;
        }
        if (this.getPlayer().fallDistance > 3.0) {
            this.mtd = true;
        } else if (this.mtd) {
            this.mtd = false;
            this.mte = 6;
        }
        float f = this.getPlayer().getHealth();
        if (f < this.mtc && this.mte <= 0 && this.mqq != mpm.ESCAPING && this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqq != mpm.RESTOCK_AND_DUMP && this.mqq != mpm.WARPING_TO_LOOT_BASE && this.mzh()) {
            this.myd(mpm.ESCAPING);
            this.mru = 0;
            this.mrv = 0;
            this.mrw = 0;
            this.mqy = null;
            this.mqz = 0;
        }
        this.mtc = f;
        if (this.ndj()) {
            this.mwb = this.mwa;
        }
        if (!this.mst && !this.mc.options.useKey.isPressed()) {
            ItemStack itemStack;
            this.nee();
            this.ndo();
            if (!(this.muk != -1 || this.ncm() || this.muw || this.mqq == mpm.BRUSHING_SAND || this.mqq == mpm.ESCAPING || (itemStack = this.getPlayer().getMainHandStack()).isEmpty() || itemStack.getItem().getTranslationKey().contains(a.b("\u9984\ue031\u6afa\uf496\u7f57", -2090100238)) || itemStack.getItem().getTranslationKey().contains(a.b("\uff82\u863f\u0cee\u9299", -937033749)) || itemStack.getItem() == Items.GOLDEN_CARROT || this.nel(itemStack) || this.neo(itemStack))) {
                this.nat();
            }
        } else {
            this.neb();
        }
        if (this.mud > 0) {
            this.ndp();
            if (this.mud > 0) {
                pqf.resetKeys();
                return;
            }
        }
        if (this.mtb > 0) {
            --this.mtb;
            return;
        }
        if (this.mrf != null) {
            pqf.resetKeys();
            this.mzx();
            return;
        }
        if (!this.msy.isEmpty()) {
            pqf.resetKeys();
            if (++this.muj > 400) {
                this.msy.clear();
                this.msz = 0;
                this.muj = 0;
                this.mzy();
                if (this.mc.player != null && this.mc.currentScreen != null) {
                    this.mc.player.closeHandledScreen();
                }
                return;
            }
            ++this.msz;
            boolean bl3 = this.mc.currentScreen instanceof GenericContainerScreen;
            if (this.msz >= (bl3 ? 4 : 2)) {
                this.msy.poll().run();
                this.msz = 0;
                this.mtb = bl3 ? 2 + this.mty.nextInt(5) : 1 + this.mty.nextInt(3);
            }
            return;
        }
        this.muj = 0;
        if (this.mud == 0) {
            this.ndw();
        }
        if (!this.mst && this.mqq != mpm.ESCAPING && this.mzh()) {
            boolean bl4;
            boolean bl5 = this.myk(true);
            boolean bl6 = bl4 = this.mqg.get() && this.myk(false);
            if (bl5 || bl4) {
                int n2;
                int n3 = -1;
                if (bl5 && (n3 = this.nej()) == -1) {
                    n2 = this.nek();
                    if (n2 != -1 && this.msy.isEmpty()) {
                        this.nau(n2);
                    }
                    if (n2 != -1) {
                        return;
                    }
                    bl5 = false;
                }
                if (!bl5 && bl4 && (n3 = this.nem()) == -1) {
                    n2 = this.nen();
                    if (n2 != -1 && this.msy.isEmpty()) {
                        this.nau(n2);
                    }
                    if (n2 != -1) {
                        return;
                    }
                    bl4 = false;
                }
                if (n3 != -1) {
                    pqf.resetKeys();
                    if (this.getPlayer().getInventory().getSelectedSlot() != n3) {
                        this.getPlayer().getInventory().setSelectedSlot(n3);
                        this.mxx();
                        this.msw = 0;
                        return;
                    }
                    n2 = bl5 ? 0 : 1;
                    ++this.msw;
                    if (!(this.getPlayer().getInventory().getStack(n3).isOf(Items.POTION) || this.mxy(86.0f) && !(this.mtv < 78.0f))) {
                        this.mxx();
                        if (this.msw > 100) {
                            this.msw = 0;
                            int n4 = n2;
                            this.mwx[n4] = this.mwx[n4] + 1;
                            if (this.mwx[n4] >= 3) {
                                this.mym(n2);
                            }
                        }
                        return;
                    }
                    this.mwr = n2;
                    this.mws = this.mwa;
                    this.mxv();
                    if (!this.getPlayer().isUsingItem() && this.msw % 5 == 0) {
                        ptr.later(() -> {
                            if (this.mc.player != null && this.mc.interactionManager != null && !this.mc.player.isUsingItem()) {
                                this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, Hand.MAIN_HAND);
                            }
                        });
                    }
                    if (this.msw > 100) {
                        this.mxx();
                        this.mzm();
                        this.msw = 0;
                        int n5 = n2;
                        this.mwx[n5] = this.mwx[n5] + 1;
                        if (this.mwx[n5] >= 3) {
                            this.mym(n2);
                        }
                    }
                    return;
                }
            }
            if (this.msw > 0) {
                this.mxx();
                this.mzm();
                this.msw = 0;
                this.mwr = -1;
                if (this.muk == -1) {
                    this.nat();
                }
            }
        }
        if (!this.mst && this.mqq != mpm.ESCAPING) {
            if (this.mxz()) {
                this.mya();
                return;
            }
        } else if (this.mtf != 0) {
            this.myb();
        }
        if (this.mqf.get() && this.nde() && (this.mqq == mpm.FARMING || this.mqq == mpm.LOOTING_VASE)) {
            this.mc.options.attackKey.setPressed(false);
            this.mc.options.useKey.setPressed(false);
            if (this.mc.interactionManager != null) {
                this.mc.interactionManager.cancelBlockBreaking();
            }
            this.mrr = null;
            this.msu = false;
            this.msi = 0;
            this.msx = 0;
            this.mqy = null;
            this.mqz = 0;
            this.myd(mpm.FARMING_SAND);
        }
        if (!(this.mqq != mpm.FARMING && this.mqq != mpm.FARMING_SAND && this.mqq != mpm.LOOTING_VASE && this.mqq != mpm.LOOTING_SAND && this.mqq != mpm.BRUSHING_SAND && this.mqq != mpm.RUN_TO_FARM_COORDS || this.mzh())) {
            if (this.mwa % 60 == 0) {
                this.myd(mpm.TELEPORT_TO_SAVE);
            }
            return;
        }
        if (bl && this.mqq != mpm.ENTER_PORTAL && !this.myq() && this.mze()) {
            return;
        }
        switch (this.mqq.ordinal()) {
            case 0: {
                this.mzl();
                break;
            }
            case 1: {
                this.nam();
                break;
            }
            case 2: {
                this.nao();
                break;
            }
            case 3: {
                this.naq();
                break;
            }
            case 4: {
                this.nar();
                break;
            }
            case 5: {
                this.nax();
                break;
            }
            case 6: {
                this.nbq();
                break;
            }
            case 7: {
                this.ncy();
                break;
            }
            case 8: {
                this.ndc();
                break;
            }
            case 9: {
                this.ndd();
                break;
            }
            case 10: {
                this.ndh();
                break;
            }
            case 11: {
                this.ndk();
                break;
            }
            case 12: {
                this.ndl();
                break;
            }
            case 13: {
                this.mzi();
            }
        }
        if (!this.myq()) {
            this.mzb(bl);
        }
    }

    private boolean mza() {
        if (this.mtk > 0) {
            --this.mtk;
        }
        Vec3d vec3d = this.getPlayer().getEntityPos();
        if (this.mti == null || vec3d.squaredDistanceTo(this.mti) > 2.25) {
            this.mti = vec3d;
            this.mtj = 0;
            return false;
        }
        ++this.mtj;
        if (this.mqq == mpm.RESTOCK_AND_DUMP && this.mxk) {
            this.mtj = 0;
            return false;
        }
        if (this.mtj < 2400 || this.mtk > 0) {
            return false;
        }
        pqf.resetKeys();
        this.mxx();
        if (this.mc.player != null && this.mc.currentScreen != null) {
            this.mc.player.closeHandledScreen();
        }
        if (this.mqq == mpm.WARPING_TO_LOOT_BASE || this.mqq == mpm.ENTER_PORTAL || this.mqq == mpm.RUN_TO_FARM_COORDS || this.mqq == mpm.RESTOCK_AND_DUMP || this.mqq == mpm.WARPING_TO_SAVE_BASE) {
            this.myo(wap.s(a.b("\u7fb5\u0603\u8ccb\u12ba\u9966\u1f93\ua593\u2c65\ub227\u3893\ubf40\u457d\ucbec\u5254\ud81a\u5eb9\ue4e4\u6b27\uf1d9\u778c\ufe7c\u8436\u0a84\u9144\u172d", 1031176159), a.c(-906289479, "\u1aef\u635d\ue9f2\u77f2\ufc51\u7efb\uc0b5\u4949\ud306\u5dab\uda71\u2074\uaea0\u3766\ub920\u3fc3\u859e\u0e53\u94e4\u12b0\u9b39\ue169\u6fd3")));
            if (this.myp()) {
                return true;
            }
        }
        this.mxu();
        this.mti = vec3d;
        this.mtk = 600;
        this.myd(mpm.TELEPORT_TO_SAVE);
        return true;
    }

    private void mzb(boolean bl) {
        boolean bl2 = this.mc.options.forwardKey.isPressed();
        if (!(bl && bl2 && pqf.isBlockedHorizontally())) {
            this.mrw = 0;
            if (!this.mry) {
                this.mc.options.leftKey.setPressed(false);
                this.mc.options.rightKey.setPressed(false);
            }
            return;
        }
        ++this.mrw;
        if (this.mrw < 8) {
            return;
        }
        this.mux = true;
        if (this.mrw % 20 == 0) {
            this.mrx = -this.mrx;
        }
        if (this.mrx > 0) {
            this.mc.options.rightKey.setPressed(true);
            this.mc.options.leftKey.setPressed(false);
        } else {
            this.mc.options.leftKey.setPressed(true);
            this.mc.options.rightKey.setPressed(false);
        }
        if (this.mrw > 30) {
            this.mrw = 0;
            this.mqy = null;
            this.mqz = 0;
            this.mse = 0;
            this.mrv = (this.mrv + 1) % mpu.length;
        }
    }

    private void mzc(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = Float.MAX_VALUE;
        for (float f5 = -1.0f; f5 <= 1.0f; f5 += 1.0f) {
            for (float f6 = -1.0f; f6 <= 1.0f; f6 += 1.0f) {
                double d;
                float f7;
                if (f5 == 0.0f && f6 == 0.0f || !((f7 = Math.abs(MathHelper.wrapDegrees((float)((float)(d = Math.toDegrees(pud.inputDirection(this.mtu, f5, f6))) - f)))) < f4)) continue;
                f4 = f7;
                f2 = f5;
                f3 = f6;
            }
        }
        this.mux = true;
        this.mry = true;
        this.mc.options.forwardKey.setPressed(f2 > 0.0f);
        this.mc.options.backKey.setPressed(f2 < 0.0f);
        this.mc.options.leftKey.setPressed(f3 > 0.0f);
        this.mc.options.rightKey.setPressed(f3 < 0.0f);
    }

    private static float mzd(double d, double d2) {
        return (float)Math.toDegrees(Math.atan2(-d, d2));
    }

    private boolean mze() {
        if (this.mwf < 6) {
            return false;
        }
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (this.nci() && pqf.getStandY(this.mqy.get(this.mqz)) > clientPlayerEntity.getY() + 0.6) {
            return false;
        }
        this.mqy = null;
        this.mqz = 0;
        this.mse = 0;
        this.ncf();
        Vec3d vec3d = pqf.awayFromClimbable((PlayerEntity)clientPlayerEntity);
        pqf.resetKeys();
        this.mzc(vec3d != null ? mpq.mzd(vec3d.x, vec3d.z) : this.ncj() + 180.0f);
        this.mc.options.sprintKey.setPressed(false);
        if (this.mwf > 200) {
            this.mwf = 0;
            if (this.mrr != null) {
                this.nay(true);
            } else if (this.mrz != null) {
                this.ncz(true);
            }
        }
        return true;
    }

    private void mzf() {
        if (pqf.onClimbable((PlayerEntity)this.getPlayer()) && this.mc.options != null) {
            this.mc.options.sneakKey.setPressed(true);
        }
    }

    private void mzg() {
        if (Math.abs(this.mtl.intentPitch() - this.mwg) > 6.0f) {
            this.nbz(this.mtl.intentYaw(), this.mwg, true);
        } else {
            this.ncf();
        }
    }

    private boolean mzh() {
        if (this.mc.world == null || this.getPlayer() == null) {
            return false;
        }
        String string = this.mc.world.getRegistryKey().getValue().toString().toLowerCase();
        Optional optional = this.mc.world.getBiome(this.getPlayer().getBlockPos()).getKey();
        String string2 = optional.isPresent() ? ((RegistryKey)optional.get()).getValue().toString().toLowerCase() : "";
        return string.contains(a.b("\uc587\ubc3d\u36e4", -832584223)) || string2.contains(a.c(-30972929, "\u6399\u1a23\u90fa"));
    }

    private void mzi() {
        boolean bl;
        PlayerEntity playerEntity;
        double d;
        ++this.mru;
        this.mc.options.attackKey.setPressed(false);
        this.mxx();
        if (this.mc.interactionManager != null) {
            this.mc.interactionManager.cancelBlockBreaking();
        }
        double d2 = d = (playerEntity = this.neh()) != null ? playerEntity.squaredDistanceTo((Entity)this.getPlayer()) : Double.MAX_VALUE;
        if (this.mru > 20 && d > 1600.0) {
            pqf.resetKeys();
            this.myd(mpm.FARMING);
            return;
        }
        boolean bl2 = bl = this.mqy == null || this.mqz >= this.mqy.size() || this.mru % 25 == 0;
        if (playerEntity != null && bl && this.mse <= 0) {
            this.mse = 10;
            this.mzk(playerEntity);
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else if (playerEntity != null) {
            Vec3d vec3d = this.mzj(this.getPlayer().getEntityPos().subtract(playerEntity.getEntityPos()).normalize(), Math.toRadians(mpu[this.mrv]));
            Vec3d vec3d2 = this.getPlayer().getEntityPos().add(vec3d.multiply(12.0));
            this.ncp(new Vec3d(vec3d2.x, this.getPlayer().getY(), vec3d2.z));
        } else {
            this.ncf();
            this.mux = true;
            this.mc.options.forwardKey.setPressed(true);
            pyd.setSprint(this.mc.options, true);
        }
        if (this.mru > 200) {
            pqf.resetKeys();
            this.myd(mpm.FARMING);
        }
    }

    private Vec3d mzj(Vec3d vec3d, double d) {
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        return new Vec3d(vec3d.x * d2 - vec3d.z * d3, 0.0, vec3d.x * d3 + vec3d.z * d2).normalize();
    }

    private void mzk(PlayerEntity playerEntity) {
        Vec3d vec3d = this.getPlayer().getEntityPos().subtract(playerEntity.getEntityPos()).normalize();
        BlockPos blockPos = this.getPlayer().getBlockPos();
        for (int i = 0; i < 3; ++i) {
            int n = (this.mrv + i) % mpu.length;
            double d = (double)mpu[n] + this.mty.nextGaussian() * 12.0;
            Vec3d vec3d2 = this.mzj(vec3d, Math.toRadians(d));
            double d2 = 26.0 + this.mty.nextDouble() * 12.0;
            BlockPos blockPos2 = this.nbd(blockPos.add((int)(vec3d2.x * d2), 0, (int)(vec3d2.z * d2)));
            List<BlockPos> list = this.nbb(blockPos, blockPos2);
            if (list == null || list.size() < 5) continue;
            this.nbc(list);
            this.mrv = n;
            return;
        }
        this.mrv = (this.mrv + 3) % mpu.length;
        this.mqy = null;
        this.mqz = 0;
    }

    private void mzl() {
        this.mst = false;
        if (!this.mrj && this.nab(true) == 1) {
            this.mrj = true;
        }
        if (this.mqg.get()) {
            if (!this.mrk && this.nab(false) == 1) {
                this.mrk = true;
            }
        } else if (!this.mrk) {
            this.mrk = true;
        }
        this.mzm();
        if (this.mrh && this.mri && this.mrj && this.mrk) {
            if (!(this.nab(true) != 0 || this.myh() && this.mzn(a.b("\u346b\u4ddf\uc703\u5978\ud2a0", 654192726)) == null)) {
                if (!this.mxk) {
                    this.mxk = true;
                    this.notifyUser(a.d("\u9fe8\ue671\u6cd5\uf6c6\u790c\uffb5\u45e1\ucc1a\u5249\ud8f4\u5f23\ua550\u2bf8\ub24a\u3863\uba8a\u04d8\u8b04\u15a7\u97e7\u1e11\u6447\ueaf6\u7532\uf340\u799c\uc439\u4a6a\ud0f8\u56c4", -1102847731, -54035738), false);
                }
                this.mrj = false;
                this.msh = 600;
                return;
            }
            this.mxk = false;
            if (this.myp()) {
                pqf.resetKeys();
                this.mzg();
                return;
            }
            this.myd(mpm.TELEPORT_TO_LOOT);
            return;
        }
        if (this.mrl != null && !(this.mc.currentScreen instanceof GenericContainerScreen) && this.mwa - this.mwh > 400) {
            this.mrl = null;
            this.mqy = null;
            this.mc.options.useKey.setPressed(false);
            this.msh = 40;
            if (++this.mwi >= 3) {
                this.mwi = 0;
                this.mzq(this.mrm);
            }
        }
        if (this.mrl == null) {
            String string;
            String string2 = string = !this.mrh ? a.c(2114532074, "\u36ae\u4f6f\uc5cd\u5bc2\ud06a") : this.mzz();
            if (this.msh > 0) {
                pqf.resetKeys();
                this.mzg();
                return;
            }
            BlockPos blockPos = this.mzn(string);
            if (blockPos != null) {
                this.mrl = blockPos;
                this.mrm = string;
                this.mwh = this.mwa;
                this.mvg = 0;
                this.nch();
                this.naz(this.mrl, true);
            } else {
                this.msh = 10;
                if (!string.equals(a.d("\uf6b8\u8f79\u05db\u9bd4\u107c", -1752978973, 1464163103)) && this.mzn(a.d("\ud5ff\uac3e\u269c\ub893\u333b", -994787763, -1967493130)) != null) {
                    this.mzq(string);
                }
                pqf.resetKeys();
                this.mzg();
            }
        } else if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            GenericContainerScreen genericContainerScreen;
            pqf.resetKeys();
            Vec3d vec3d = this.nbo(this.mrl);
            this.ncb(this.mrl, vec3d != null ? vec3d : Vec3d.ofCenter((Vec3i)this.mrl));
            Screen screen = this.mc.currentScreen;
            if (screen instanceof GenericContainerScreen && !this.mzp(genericContainerScreen = (GenericContainerScreen)screen)) {
                this.mc.player.closeHandledScreen();
                return;
            }
            if (!(this.mc.currentScreen instanceof GenericContainerScreen)) {
                genericContainerScreen = this.nco(this.mrl);
                boolean bl = false;
                if (genericContainerScreen != null && this.mvc > 0) {
                    --this.mvc;
                } else if (genericContainerScreen != null) {
                    bl = System.currentTimeMillis() - this.mta > 500L;
                } else {
                    BlockHitResult blockHitResult;
                    ++this.mvg;
                    if (this.mvg > 40 && this.getPlayer().getBlockPos().getSquaredDistance((Vec3i)this.mrl) < 16.0 && System.currentTimeMillis() - this.mta > 500L && (blockHitResult = this.mzr(this.mrl)) != null) {
                        ptr.later(() -> {
                            if (this.mc.interactionManager != null && this.mc.player != null && this.mc.currentScreen == null) {
                                this.mc.interactionManager.interactBlock(this.mc.player, Hand.MAIN_HAND, blockHitResult);
                                this.mc.player.swingHand(Hand.MAIN_HAND);
                            }
                        });
                        this.mta = System.currentTimeMillis();
                        this.mzo(this.mrl);
                    }
                }
                if (bl) {
                    this.mta = System.currentTimeMillis();
                    this.mzo(this.mrl);
                }
                this.mc.options.useKey.setPressed(bl);
            } else {
                this.mc.options.useKey.setPressed(false);
                genericContainerScreen = (GenericContainerScreen)this.mc.currentScreen;
                if (this.mrm.equals(a.c(-1340484654, "\ud796\uae57\u24f5\ubafa\u3152"))) {
                    this.mzt(genericContainerScreen);
                    this.msy.add(() -> {
                        this.mrh = true;
                        this.mc.player.closeHandledScreen();
                        this.mrl = null;
                    });
                } else if (this.mrm.equals(a.d("\ub94c\uc0fc\u4a2b", 1143429311, 1234232773))) {
                    if (this.msy.isEmpty()) {
                        int n = 0;
                        for (int i = 0; i < this.getPlayer().getInventory().size(); ++i) {
                            if (this.getPlayer().getInventory().getStack(i).getItem() != Items.GOLDEN_CARROT) continue;
                            n += this.getPlayer().getInventory().getStack(i).getCount();
                        }
                        if (n > this.mre && this.mrc < 4) {
                            ++this.mrc;
                            if (!this.nae(genericContainerScreen, itemStack -> itemStack.getItem() == Items.GOLDEN_CARROT)) {
                                this.mrc = 4;
                            }
                        } else if (n >= this.mre || this.mrc >= 4) {
                            this.mrc = 0;
                            this.msy.add(() -> {
                                this.mri = true;
                                this.mc.player.closeHandledScreen();
                                this.mrl = null;
                            });
                        } else {
                            ++this.mrc;
                            if (!this.mzw(genericContainerScreen, this.mre - n)) {
                                this.mrc = 0;
                                this.msy.add(() -> {
                                    this.mri = true;
                                    this.mc.player.closeHandledScreen();
                                    this.mrl = null;
                                });
                            }
                        }
                    }
                } else if ((this.mrm.equals(a.c(-1903551165, "\u197e\u60ca\uea16\u746d\uffb5")) || this.mrm.equals(a.c(1399297998, "\u9387\uea4d\u609a\ufe95\u753c\uf3f2\u49a2\uc05d"))) && this.msy.isEmpty()) {
                    this.naf(genericContainerScreen, this.mrm.equals(a.b("\u1dc5\u6471\ueead\u70d6\ufb0e", 453450232)));
                }
            }
        }
    }

    private void mzm() {
        int n;
        if (this.mc.currentScreen != null || this.msu || this.mus) {
            return;
        }
        for (n = 0; n < 9; ++n) {
            if (this.getPlayer().getInventory().getStack(n).getItem() != Items.GLASS_BOTTLE) continue;
            if (this.muk == -1 && this.mum <= 0 && this.ndx()) {
                this.ndz(n);
            }
            return;
        }
        if (!this.msy.isEmpty() || this.mud > 0) {
            return;
        }
        for (n = 9; n < 36; ++n) {
            if (this.getPlayer().getInventory().getStack(n).getItem() != Items.GLASS_BOTTLE) continue;
            int n2 = n;
            this.msy.add(() -> this.ndv(n2, 1, SlotActionType.THROW));
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private BlockPos mzn(String var1_1) {
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

    private void mzo(BlockPos blockPos) {
        this.mwj = blockPos;
        this.mwk = System.currentTimeMillis();
    }

    private boolean mzp(GenericContainerScreen genericContainerScreen) {
        int n;
        int n2 = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).syncId;
        if (n2 == this.mwl) {
            return true;
        }
        if (this.mwj == null || !this.mwj.equals((Object)this.mrl) || System.currentTimeMillis() - this.mwk > 3000L) {
            return false;
        }
        BlockState blockState = this.getWorld().getBlockState(this.mwj);
        if (!(blockState.getBlock() instanceof ChestBlock)) {
            return false;
        }
        int n3 = n = blockState.get((Property)ChestBlock.CHEST_TYPE) == ChestType.SINGLE ? 27 : 54;
        if (((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getRows() * 9 != n) {
            return false;
        }
        this.mwl = n2;
        return true;
    }

    /*
     * Exception decompiling
     */
    private void mzq(String var1_1) {
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

    private BlockHitResult mzr(BlockPos blockPos) {
        Vec3d vec3d = this.getPlayer().getEyePos();
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        BlockHitResult blockHitResult = this.getWorld().raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
        if (blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)blockPos)) {
            return blockHitResult;
        }
        if (this.mvg <= 80) {
            return null;
        }
        Direction direction = Direction.getFacing((double)(vec3d.x - vec3d2.x), (double)(vec3d.y - vec3d2.y), (double)(vec3d.z - vec3d2.z));
        Vec3d vec3d3 = vec3d2.add((double)direction.getOffsetX() * 0.5, (double)direction.getOffsetY() * 0.5, (double)direction.getOffsetZ() * 0.5);
        return new BlockHitResult(vec3d3, direction, blockPos, false);
    }

    private boolean mzs(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return false;
        }
        String string = this.getWorld().getBlockState(blockPos).getBlock().getTranslationKey().toLowerCase();
        return string.contains(a.d("\uf851\u81eb\u0b35\u9552\u1e82", 842418189, 574402618)) && !string.contains(a.b("\u6cc9\u1573\u9faa\u01da\u8a1a\u0c86\ub6e9\u3f13\ua141\u2be6\uac32", 1928031399));
    }

    private void mzt(GenericContainerScreen genericContainerScreen) {
        int n;
        int n2 = this.mzv(Items.GOLDEN_CARROT);
        for (int i = n = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getInventory().size(); i < ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).slots.size(); ++i) {
            ItemStack itemStack;
            Slot slot = (Slot)((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).slots.get(i);
            if (slot.inventory != this.getPlayer().getInventory() || slot.getIndex() >= 36 || (itemStack = slot.getStack()).isEmpty() || itemStack.isOf(Items.BRUSH) || itemStack.isOf(Items.GLASS_BOTTLE) || this.isTrashItem(itemStack) || this.nel(itemStack) || this.neo(itemStack) || itemStack.isOf(Items.WATER_BUCKET) || (itemStack.isOf(Items.GOLDEN_CARROT) ? n2 <= this.mre : !this.mxr(itemStack) && (itemStack.getItem().getTranslationKey().contains(a.b("\uabb1\ud204\u58cf\uc6a3\u4d62", -1008227385)) || itemStack.getItem().getTranslationKey().contains(a.b("\u305e\u49e3\uc332\u5d45", -662491081)) || itemStack.isOf(Items.TOTEM_OF_UNDYING)))) continue;
            int n3 = i;
            int n4 = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).syncId;
            this.msy.add(() -> {
                if (this.mc.interactionManager != null && this.getPlayer() != null && this.getPlayer().currentScreenHandler.syncId == n4 && !this.mzu(n3)) {
                    this.mc.interactionManager.clickSlot(n4, n3, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)this.getPlayer());
                }
            });
        }
    }

    private boolean mzu(int n) {
        ScreenHandler screenHandler = this.getPlayer().currentScreenHandler;
        return n >= 0 && n < screenHandler.slots.size() && ((Slot)screenHandler.slots.get(n)).getStack().isOf(Items.BRUSH);
    }

    private int mzv(Item item) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(i);
            if (!itemStack.isOf(item)) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private boolean mzw(GenericContainerScreen genericContainerScreen, int n) {
        this.mrf = pmf.plan(genericContainerScreen.getScreenHandler(), this.getPlayer().getInventory(), itemStack -> itemStack.getItem() == Items.GOLDEN_CARROT, n, this.mty, System.currentTimeMillis());
        this.mrg = 0;
        return this.mrf != null;
    }

    private void mzx() {
        pmc pmc2;
        GenericContainerScreen genericContainerScreen;
        Screen screen;
        block6: {
            block5: {
                screen = this.mc.currentScreen;
                if (!(screen instanceof GenericContainerScreen)) break block5;
                genericContainerScreen = (GenericContainerScreen)screen;
                if (this.mc.interactionManager != null && this.getPlayer() != null) break block6;
            }
            this.mrf = null;
            this.mrg = 0;
            return;
        }
        screen = genericContainerScreen.getScreenHandler();
        if (++this.mrg == 120) {
            this.mrf.abort();
        }
        if ((pmc2 = this.mrf.drive((ScreenHandler)screen, System.currentTimeMillis(), (arg_0, arg_1, arg_2) -> this.lambda$driveTake$11((ScreenHandler)screen, arg_0, arg_1, arg_2))) == pmc.DONE || pmc2 == pmc.GAVE_UP || this.mrg > 160) {
            this.mrf = null;
            this.mrg = 0;
            this.mtb = 2 + this.mty.nextInt(4);
        }
    }

    private void mzy() {
        GenericContainerScreen genericContainerScreen;
        Screen screen;
        block5: {
            block4: {
                screen = this.mc.currentScreen;
                if (!(screen instanceof GenericContainerScreen)) break block4;
                genericContainerScreen = (GenericContainerScreen)screen;
                if (this.mc.interactionManager != null && this.getPlayer() != null) break block5;
            }
            return;
        }
        screen = genericContainerScreen.getScreenHandler();
        int n = pmf.stashSlot((ScreenHandler)screen, this.getPlayer().getInventory(), screen.getCursorStack(), -1);
        if (n != -1) {
            this.mc.interactionManager.clickSlot(screen.syncId, n, 0, SlotActionType.PICKUP, (PlayerEntity)this.getPlayer());
        }
    }

    private String mzz() {
        for (String string : this.mrd) {
            if (string.equals(a.d("\u1684\u6f34\ue5e3", -2054590568, 357530922)) && !this.mri) {
                return string;
            }
            if (string.equals(a.d("\ua4c3\udd77\u57ab\uc9d0\u4208", 1941771291, 1409135845)) && !this.mrj) {
                return string;
            }
            if (!string.equals(a.d("\u234a\u5a80\ud057\u4e58\uc5f1\u433f\uf96f\u7090", -1826207273, -6394156)) || this.mrk) continue;
            return string;
        }
        return a.b("\u3954\u409e\uca49\u5446\udfef\u5921\ue371\u6a8e", -474137315);
    }

    private void naa() {
        Collections.shuffle(this.mrd, this.mty);
        this.mre = 3;
        this.mrc = 0;
        this.mwg = 4.0f + this.mty.nextFloat() * 14.0f;
    }

    private int nab(boolean bl) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(i);
            if (!(bl ? this.nel(itemStack) : this.neo(itemStack))) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private int nac(GenericContainerScreen genericContainerScreen, int n) {
        int n2 = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getInventory().size();
        if (n < 9) {
            return n2 + 27 + n;
        }
        return n2 + (n - 9);
    }

    private boolean nad(GenericContainerScreen genericContainerScreen, boolean bl) {
        return this.nae(genericContainerScreen, itemStack -> bl ? this.nel((ItemStack)itemStack) : this.neo((ItemStack)itemStack));
    }

    private boolean nae(GenericContainerScreen genericContainerScreen, Predicate<ItemStack> predicate) {
        boolean bl = false;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(i);
            if (!predicate.test(itemStack)) continue;
            int n = this.nac(genericContainerScreen, i);
            this.msy.add(() -> this.mc.interactionManager.clickSlot(((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).syncId, n, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)this.getPlayer()));
            bl = true;
        }
        return bl;
    }

    private void naf(GenericContainerScreen genericContainerScreen, boolean bl) {
        int n = this.nab(bl);
        if (this.mrb > 4) {
            this.msy.add(() -> this.nag(bl));
            return;
        }
        if (n == 1) {
            this.mrb = 0;
            this.msy.add(() -> this.nag(bl));
            return;
        }
        ++this.mrb;
        if (n > 1) {
            if (!this.nad(genericContainerScreen, bl)) {
                this.msy.add(() -> this.nag(bl));
            }
            return;
        }
        if (!this.nah(genericContainerScreen, bl)) {
            this.msy.add(() -> this.nag(bl));
        }
    }

    private void nag(boolean bl) {
        if (bl) {
            this.mrj = true;
        } else {
            this.mrk = true;
        }
        this.mrb = 0;
        this.mc.player.closeHandledScreen();
        this.mrl = null;
    }

    private boolean nah(GenericContainerScreen genericContainerScreen, boolean bl) {
        this.mrf = pmf.plan(genericContainerScreen.getScreenHandler(), this.getPlayer().getInventory(), itemStack -> bl ? this.nel((ItemStack)itemStack) : this.neo((ItemStack)itemStack), 1, this.mty, System.currentTimeMillis());
        this.mrg = 0;
        return this.mrf != null;
    }

    private String[] nai() {
        String[] stringArray;
        String[] stringArray2;
        String string = this.mqi.get();
        String[] stringArray3 = stringArray2 = string == null ? new String[]{} : string.trim().split(a.b("\u22da\u5b1c\ud1bf\u4fe1\uc418\u42df", -1858198905));
        if (stringArray2.length == 0 || stringArray2[0].isEmpty()) {
            String[] stringArray4 = new String[1];
            stringArray = stringArray4;
            stringArray4[0] = a.d("\u3ad8\u4366\uc9ee\u579a\udc45", -1457529262, -1147083538);
        } else {
            stringArray = stringArray2;
        }
        return stringArray;
    }

    private String naj() {
        String[] stringArray = this.nai();
        if (this.mqp >= stringArray.length) {
            this.mqp = 0;
        }
        return stringArray[this.mqp];
    }

    private static String nak(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string.trim();
        while (string2.startsWith(a.d("\u4c32", 974307399, 1334807643))) {
            string2 = string2.substring(1).trim();
        }
        return string2;
    }

    private void nal(String string) {
        int n = pjd.position(this.mxs());
        this.mwn = wap.t(string) + (n > 0 ? wap.s(a.c(-601835061, "\ub9e8\uc051\u4a89") + n + a.d("\ufede", -1390731760, -2034114330), a.d("\u31f1\u4848", 590397077, -116158650) + n + a.c(-248147379, "\u9263\uefc6\u6105")) : "");
        if (this.mwa - this.mwm > 600) {
            this.mwm = this.mwa;
            this.notifyUser(this.mwn, false);
        }
        if (this.mzh()) {
            this.ndi();
        } else {
            pqf.resetKeys();
            this.mzg();
        }
    }

    private void nam() {
        String[] stringArray = this.nai();
        for (int i = 0; i < stringArray.length; ++i) {
            int n = (this.mqp + i) % stringArray.length;
            if (!pjd.hasRoom(stringArray[n], this.mxs())) continue;
            this.mqp = n;
            break;
        }
        String string = mpq.nak(this.naj());
        if (!pjd.enter(this.mxs(), string)) {
            this.nal(a.b("\u47cf\u3e2d\ub48a\u2eee\ua129\u2795\u9dc1\u1432\u8e75\u00df\u8774\u7d04\uf3a1\u6e00\ue044\u66b2\udcf0\u5353\uc9ed\u4fb5\uc229\ub875\u36cb\ua90c\u2f71\ua5c5\u1c1b\u9656\u08bf\u8e97\u0556\ufbf2\u71c8\ue838\u6e67", 1834370046));
            return;
        }
        this.mwn = "";
        this.getNetworkHandler().sendChatCommand(string);
        this.mrn = 0;
        this.mro = false;
        this.mrp = null;
        this.mrq = 0;
        this.msq = false;
        this.msr = 0;
        this.mss = 0;
        this.mst = false;
        this.mut = this.getWorld();
        this.mwz = this.getWorld();
        this.mxa = this.getPlayer();
        this.mxb = this.getPlayer() == null ? null : this.getPlayer().getEntityPos();
        this.mxc = -1;
        this.mxd = false;
        this.mxe = 0;
        this.mxf = 0;
        this.myd(mpm.WARPING_TO_LOOT_BASE);
    }

    private boolean nan() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        return this.mxd || this.getWorld() != this.mwz || clientPlayerEntity != this.mxa || this.mxb != null && clientPlayerEntity.getEntityPos().distanceTo(this.mxb) > 48.0;
    }

    private void nao() {
        boolean bl;
        pqf.resetKeys();
        this.mzf();
        ++this.mrn;
        this.mst = false;
        if (!this.msq) {
            if (this.mrn < 12) {
                return;
            }
            this.nas();
            return;
        }
        if (!this.mro) {
            if (this.mxc < 0) {
                if (this.mrn - this.mss >= 10 && (this.nan() || this.mrn >= 200)) {
                    this.mxc = this.mrn;
                }
                return;
            }
            if (this.mrn - this.mxc >= 10) {
                if (this.mzh()) {
                    this.mro = true;
                    this.myd(mpm.RUN_TO_FARM_COORDS);
                    return;
                }
                this.nap();
            }
            return;
        }
        int n = this.naw();
        if (n > 0) {
            this.mrq = 0;
            return;
        }
        if (this.mc.options != null) {
            this.mc.options.useKey.setPressed(false);
        }
        boolean bl2 = bl = this.mrp != null && this.getPlayer().getBlockPos().getSquaredDistance((Vec3i)this.mrp) > 9.0;
        if (!bl && this.mrn - this.mxf < 200) {
            return;
        }
        if (!bl && this.mxe < 2) {
            this.nap();
            return;
        }
        ++this.mrq;
        if (this.mrq >= 40) {
            this.myd(mpm.ENTER_PORTAL);
        }
    }

    private void nap() {
        this.getNetworkHandler().sendChatCommand(this.mxt());
        this.mro = true;
        ++this.mxe;
        this.mrp = this.getPlayer().getBlockPos();
        this.mxf = this.mrn;
        this.mrq = 0;
    }

    private void naq() {
        if (this.mzh()) {
            pqf.resetKeys();
            this.msc = 0;
            this.myd(mpm.RUN_TO_FARM_COORDS);
            return;
        }
        this.ncf();
        this.mux = true;
        this.mc.options.forwardKey.setPressed(true);
        this.mc.options.sprintKey.setPressed(true);
        this.mc.options.jumpKey.setPressed(this.getPlayer().horizontalCollision && this.getPlayer().isOnGround());
        ++this.msc;
        if (this.msc > 600) {
            this.msc = 0;
            pqf.resetKeys();
            String string = wap.s(a.c(-1403542396, "\ua4ea\udd76\u57a8\uc9d3\u424d\uc4af\u7ea8\uf71e\u6943\ue3e3\u6464\u9e5c\u108c\u8927\u036f\u85d1\u3fca\ub007\u2ab9\uacad\u253f\u5f45\ud1fc\u4a69\ucc1b\u46c7\uff36\u7164\ueb91\u6dc8\ue630\u18b5\u92e1\u0b5f\u8d58\u07f5\ub82f\u321b\ub49b\u2d38\ua770\ud992"), a.c(-937836610, "\ubbbb\uc222\u4ce4\ud68a\u5d5c\udbec\u61b0\ue84a\u720e\ufcad\u7f6c\u8110\u0fd7\u966f\u1828\u9ed4\u2496\uaf5a\u35e4\ub7a5\u3a33\u4016\ucea9\u5573"));
            this.notifyUser(string, false);
            this.myo(string);
            this.mxu();
            this.myd(mpm.TELEPORT_TO_SAVE);
        }
    }

    private void nar() {
        int n;
        BlockPos blockPos = new BlockPos(0, 66, 1);
        if (Math.abs(this.getPlayer().getX()) <= 10.0 && Math.abs(this.getPlayer().getZ() - 1.0) <= 10.0 && Math.abs(this.getPlayer().getY() - 66.0) <= 3.0) {
            pqf.resetKeys();
            this.mqy = null;
            this.mxg = 0;
            this.myd(mpm.FARMING);
            return;
        }
        if (this.msd > 0) {
            --this.msd;
            pqf.resetKeys();
            return;
        }
        if (this.mqy == null || this.mqz >= this.mqy.size()) {
            this.nbc(this.nba(blockPos));
            if (this.mqy == null || this.mqy.isEmpty()) {
                this.msd = 20;
            }
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            pqf.resetKeys();
        }
        if (this.getPlayer().fallDistance > 3.0 && (n = this.nei(Items.WATER_BUCKET)) != -1) {
            this.getPlayer().getInventory().setSelectedSlot(n);
            this.nby(this.mtl.intentYaw(), 89.0f);
            if (this.mtl.intentPitch() > 65.0f) {
                this.mxv();
            }
        }
    }

    private void nas() {
        this.msq = true;
        this.mst = false;
        this.mss = this.mrn;
        this.mc.options.useKey.setPressed(false);
        this.nat();
    }

    private void nat() {
        int n;
        for (n = 0; n < 9; ++n) {
            if (!this.getPlayer().getInventory().getStack(n).isEmpty()) continue;
            this.getPlayer().getInventory().setSelectedSlot(n);
            return;
        }
        for (n = 0; n < 9; ++n) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(n);
            if (this.nel(itemStack) || this.neo(itemStack) || itemStack.getItem() == Items.GOLDEN_CARROT) continue;
            this.getPlayer().getInventory().setSelectedSlot(n);
            return;
        }
    }

    private void nau(int n) {
        int n2 = this.nav();
        int n3 = n2 != -1 ? n2 : 8;
        int n4 = n;
        this.msy.add(() -> this.ndv(n4, n3, SlotActionType.SWAP));
    }

    private int nav() {
        for (int i = 0; i < 9; ++i) {
            if (!this.getPlayer().getInventory().getStack(i).isEmpty()) continue;
            return i;
        }
        return -1;
    }

    private int naw() {
        return pjn.teleportSeconds(this.mc, a.d("\u1ea1\u6707\uedda\u73a5\uf878\u7ec8\uc4e5\u4d16\ud33b\u59fc\ude51\u2457\uaeef\u3339\ub918\u3f9c\u85a6\u0a75\u94cb", 721719727, 536513343));
    }

    private void nax() {
        this.msu = false;
        this.msv = 0;
        if ((double)this.mqr >= this.mqd.get() || this.getPlayer().getInventory().getEmptySlot() == -1) {
            this.myd(mpm.CHECK_PVP_COOLDOWN);
            return;
        }
        if (this.mrr != null && (this.mra.contains(this.mrr) || !this.nbl(this.mrr))) {
            this.nay(false);
        }
        if (this.mrr == null && this.msf <= 0) {
            this.mrr = this.nbk();
            if (this.mrr == null) {
                this.msf = 10;
            } else {
                this.msi = 0;
                this.msx = 0;
                this.nch();
                this.naz(this.mrr, true);
            }
        }
        if (this.mrr == null) {
            this.nbf();
            return;
        }
        ++this.msi;
        double d = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)this.mrr));
        boolean bl = this.nbm(this.mrr);
        if (bl && d <= 16.0) {
            this.mqy = null;
            this.mqz = 0;
            this.myd(mpm.LOOTING_VASE);
            this.mrs = 0;
            this.msu = false;
            this.msx = 0;
            return;
        }
        if (this.msi > this.mys(300)) {
            this.nay(true);
            return;
        }
        if (!this.mvh && bl && d <= 36.0 && this.ncs(Vec3d.ofCenter((Vec3i)this.mrr))) {
            this.mvh = true;
        }
        if (this.mvh && bl) {
            this.muy = this.nbo(this.mrr);
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
            this.msx = 0;
            return;
        }
        ++this.msx;
        if (this.msx >= 40) {
            this.nay(true);
            return;
        }
        if (bl && d < 100.0) {
            this.ncp(Vec3d.ofCenter((Vec3i)this.mrr));
        } else if (!this.naz(this.mrr, false)) {
            pqf.resetKeys();
        }
    }

    private void nay(boolean bl) {
        if (bl && this.mrr != null) {
            this.mra.add(this.mrr);
        }
        this.mvh = false;
        this.mrr = null;
        this.mqy = null;
        this.mqz = 0;
        this.msx = 0;
        this.msi = 0;
        if (this.mc.interactionManager != null) {
            this.mc.interactionManager.cancelBlockBreaking();
        }
        this.mc.options.attackKey.setPressed(false);
    }

    private boolean naz(BlockPos blockPos, boolean bl) {
        if (blockPos == null) {
            return false;
        }
        if (!bl && this.mse > 0) {
            return this.mqy != null && this.mqz < this.mqy.size();
        }
        this.mse = 8;
        this.nbc(this.nba(blockPos));
        return this.mqy != null && !this.mqy.isEmpty();
    }

    private List<BlockPos> nba(BlockPos blockPos) {
        return this.nbb(this.getPlayer().getBlockPos(), blockPos);
    }

    private List<BlockPos> nbb(BlockPos blockPos, BlockPos blockPos2) {
        if (blockPos2 == null || this.getWorld() == null) {
            return null;
        }
        if (this.mvn == null || !blockPos2.equals((Object)this.mvo)) {
            this.mvn = pqq.random(this.mty);
            this.mvo = blockPos2;
        }
        return pqx.findPath((BlockView)this.getWorld(), (Entity)this.getPlayer(), blockPos, blockPos2, mpt, 0.0, true, Collections.emptySet(), this.mvn);
    }

    private void nbc(List<BlockPos> list) {
        this.mqy = list;
        this.mqz = 0;
        psf psf2 = this.mvm = list == null || list.isEmpty() ? null : this.mvl.plan((World)this.getWorld(), (PlayerEntity)this.getPlayer(), list, list.get(list.size() - 1), new prz());
        if (this.mvm == null) {
            this.mqy = null;
        }
    }

    private BlockPos nbd(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return blockPos;
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        block0: for (int i = 0; i <= 10; ++i) {
            for (int j = 1; j >= -1; j -= 2) {
                mutable.set(blockPos.getX(), blockPos.getY() + i * j, blockPos.getZ());
                if (this.nbe((BlockPos)mutable)) {
                    return mutable.toImmutable();
                }
                if (i == 0) continue block0;
            }
        }
        return blockPos;
    }

    private boolean nbe(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return false;
        }
        return this.getWorld().getBlockState(blockPos).getCollisionShape((BlockView)this.getWorld(), blockPos).isEmpty() && this.getWorld().getBlockState(blockPos.up()).getCollisionShape((BlockView)this.getWorld(), blockPos.up()).isEmpty() && !this.getWorld().getBlockState(blockPos.down()).getCollisionShape((BlockView)this.getWorld(), blockPos.down()).isEmpty();
    }

    private void nbf() {
        if (this.nci() && this.mvm != null && this.mse <= 0 && !this.myq() && this.mvl.remaining(this.mvm) < 3.5) {
            this.mse = 8;
            this.nbg();
        }
        if (this.mqy == null || this.mqz >= this.mqy.size()) {
            if (this.mse > 0) {
                pqf.resetKeys();
                this.ncf();
                return;
            }
            this.mse = 8;
            this.nbg();
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            pqf.resetKeys();
            this.ncf();
        }
    }

    private void nbg() {
        BlockPos blockPos = this.getPlayer().getBlockPos();
        this.nbi(blockPos);
        if (Double.isNaN(this.mvt)) {
            this.mvt = Math.toRadians((double)this.ncj() + 90.0);
        }
        double[] dArray = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
        int n = 0;
        for (int i = 0; i < dArray.length && n < 2; ++i) {
            double d = this.mvt + dArray[(i + this.mvv) % dArray.length] + this.mty.nextGaussian() * 0.28;
            double d2 = 17.0 + this.mty.nextDouble() * 19.0;
            BlockPos blockPos2 = blockPos.add((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2));
            if (this.nbj(blockPos2) && this.mvu < 2) continue;
            ++n;
            List<BlockPos> list = this.nbb(blockPos, this.nbd(blockPos2));
            if (list == null || list.size() < 5) continue;
            this.mvt = d;
            this.mvu = 0;
            this.mvv = 0;
            this.nbc(list);
            return;
        }
        ++this.mvu;
        this.mvv = (this.mvv + 2) % dArray.length;
        this.mvt += 1.5707963267948966 + this.mty.nextDouble() * Math.PI;
        this.nbc(null);
    }

    private static long nbh(BlockPos blockPos) {
        return (long)(blockPos.getX() >> 4) << 32 ^ (long)(blockPos.getZ() >> 4) & 0xFFFFFFFFL;
    }

    private void nbi(BlockPos blockPos) {
        if (this.mvw.size() > 512) {
            this.mvw.clear();
        }
        this.mvw.add(mpq.nbh(blockPos));
    }

    private boolean nbj(BlockPos blockPos) {
        return this.mvw.contains(mpq.nbh(blockPos));
    }

    private BlockPos nbk() {
        BlockPos blockPos = this.getPlayer().getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (this.getWorld() != null) {
            for (PlayerEntity playerEntity : this.getWorld().getPlayers()) {
                if (playerEntity == this.getPlayer()) continue;
                arrayList.add(playerEntity.getEntityPos());
            }
        }
        BlockPos blockPos2 = null;
        double d = Double.MAX_VALUE;
        int n = 0;
        int n2 = -1;
        for (int i = 0; i <= 32; ++i) {
            for (int j = -i; j <= i; ++j) {
                for (int k = -i; k <= i; ++k) {
                    if (Math.max(Math.abs(j), Math.abs(k)) != i) continue;
                    for (int i2 = -8; i2 <= 8; ++i2) {
                        int n3 = blockPos.getY() + i2;
                        if (n3 >= 80 && n3 <= 90) continue;
                        mutable.set(blockPos.getX() + j, n3, blockPos.getZ() + k);
                        if (!this.nbl((BlockPos)mutable) || this.mra.contains(mutable)) continue;
                        double d2 = mutable.getSquaredDistance((Vec3i)blockPos) * (0.8 + this.mty.nextDouble() * 0.65);
                        if (!this.nbn((BlockPos)mutable)) {
                            d2 *= 2.4;
                        }
                        Vec3d vec3d = Vec3d.ofCenter((Vec3i)mutable);
                        for (Vec3d vec3d2 : arrayList) {
                            if (!(vec3d2.squaredDistanceTo(vec3d) < 1600.0)) continue;
                            d2 += 100000.0;
                            break;
                        }
                        ++n;
                        if (!(d2 < d)) continue;
                        d = d2;
                        blockPos2 = mutable.toImmutable();
                    }
                }
            }
            if (blockPos2 == null) continue;
            if (n2 < 0) {
                n2 = i;
            }
            if (i < n2 + 4 && n < 12) continue;
            return blockPos2;
        }
        return blockPos2;
    }

    private boolean nbl(BlockPos blockPos) {
        if (this.getWorld() == null || blockPos == null) {
            return false;
        }
        return this.getWorld().getBlockState(blockPos).isOf(Blocks.DECORATED_POT);
    }

    private boolean nbm(BlockPos blockPos) {
        return this.nbo(blockPos) != null;
    }

    private boolean nbn(BlockPos blockPos) {
        Vec3d[] vec3dArray;
        Vec3d vec3d = this.getPlayer().getEyePos();
        for (Vec3d vec3d2 : vec3dArray = new Vec3d[]{Vec3d.ofCenter((Vec3i)blockPos), Vec3d.ofCenter((Vec3i)blockPos).add(0.0, 0.4, 0.0)}) {
            BlockHitResult blockHitResult = this.getWorld().raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
            if (blockHitResult.getType() != HitResult.Type.MISS && !blockHitResult.getBlockPos().equals((Object)blockPos)) continue;
            return true;
        }
        return false;
    }

    private Vec3d nbo(BlockPos blockPos) {
        Vec3d[] vec3dArray;
        if (this.getWorld() == null || this.getPlayer() == null || blockPos == null) {
            return null;
        }
        Vec3d vec3d = this.getPlayer().getEyePos();
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        for (Vec3d vec3d3 : vec3dArray = new Vec3d[]{vec3d2.add(this.muz, this.mva, this.mvb), vec3d2.add(0.0, 0.35, 0.0), vec3d2.add(0.0, -0.35, 0.0), vec3d2.add(0.3, 0.0, 0.0), vec3d2.add(-0.3, 0.0, 0.0), vec3d2.add(0.0, 0.0, 0.3), vec3d2.add(0.0, 0.0, -0.3)}) {
            BlockHitResult blockHitResult = this.getWorld().raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
            if (blockHitResult.getType() != HitResult.Type.MISS && !blockHitResult.getBlockPos().equals((Object)blockPos)) continue;
            return vec3d3;
        }
        return null;
    }

    private void nbp(Vec3d vec3d) {
        this.msu = true;
        this.mrs = 0;
        this.msv = 0;
        this.msk = false;
        this.msn = 0;
        this.mso = Double.MAX_VALUE;
        this.msp = -1;
        this.msl.clear();
        this.mqy = null;
        this.mqz = 0;
        this.mc.options.attackKey.setPressed(false);
        this.mxx();
        if (this.mc.interactionManager != null) {
            this.mc.interactionManager.cancelBlockBreaking();
        }
        this.msj = vec3d;
        this.msm.clear();
        if (this.mc.world != null) {
            for (Entity entity : this.mc.world.getEntities()) {
                ItemEntity itemEntity;
                if (!(entity instanceof ItemEntity) || !((itemEntity = (ItemEntity)entity).squaredDistanceTo(vec3d) < 100.0) || itemEntity.getItemAge() <= 20) continue;
                this.msm.add(itemEntity.getId());
            }
        }
    }

    private void nbq() {
        if (this.mrr == null || !this.nbl(this.mrr)) {
            if (!this.msu) {
                Vec3d vec3d;
                Vec3d vec3d2 = vec3d = this.mrr != null ? Vec3d.ofCenter((Vec3i)this.mrr) : this.getPlayer().getEntityPos();
                if (this.mrr != null) {
                    this.mra.add(this.mrr);
                    ++this.mqu;
                }
                this.mrr = null;
                this.nbp(vec3d);
            }
            this.nbs(mpm.FARMING);
            return;
        }
        ++this.mrs;
        Vec3d vec3d = this.nbo(this.mrr);
        double d = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)this.mrr));
        if (vec3d == null || d > 20.25) {
            this.mc.options.attackKey.setPressed(false);
            if (this.mc.interactionManager != null) {
                this.mc.interactionManager.cancelBlockBreaking();
            }
            if (this.mqy == null || this.mqz >= this.mqy.size()) {
                this.naz(this.mrr, false);
            }
            if (this.mqy != null && this.mqz < this.mqy.size()) {
                this.ncr();
            } else {
                pqf.resetKeys();
            }
            if (this.mrs > this.mys(80)) {
                this.nay(true);
                this.myd(mpm.FARMING);
            }
            return;
        }
        if (this.nbr(this.mrr)) {
            this.mux = true;
            this.mc.options.forwardKey.setPressed(true);
            this.mc.options.sprintKey.setPressed(true);
            this.mc.options.jumpKey.setPressed(false);
        } else {
            pqf.resetKeys();
        }
        this.ncb(this.mrr, vec3d);
        boolean bl = this.nco(this.mrr) != null;
        this.ncd(bl);
        if (bl && this.mvc > 0) {
            --this.mvc;
            bl = false;
        }
        this.mc.options.attackKey.setPressed(bl);
        if (this.mrs > this.mys(100)) {
            this.nay(true);
            this.myd(mpm.FARMING);
        }
    }

    private boolean nbr(BlockPos blockPos) {
        double d;
        if (!this.getPlayer().isOnGround() || this.getPlayer().isTouchingWater()) {
            return false;
        }
        if (Math.abs((double)blockPos.getY() - this.getPlayer().getY()) > 1.0) {
            return false;
        }
        double d2 = (double)blockPos.getX() + 0.5 - this.getPlayer().getX();
        double d3 = Math.hypot(d2, d = (double)blockPos.getZ() + 0.5 - this.getPlayer().getZ());
        if (d3 < 2.0) {
            return false;
        }
        double d4 = (d3 - 1.3) / d3;
        return this.nct(new Vec3d(this.getPlayer().getX() + d2 * d4, this.getPlayer().getY(), this.getPlayer().getZ() + d * d4), true);
    }

    private void nbs(mpm mpm2) {
        int n;
        ++this.mrs;
        this.mc.options.attackKey.setPressed(false);
        this.mc.options.useKey.setPressed(false);
        Vec3d vec3d = this.msj != null ? this.msj : this.getPlayer().getEntityPos();
        ItemEntity itemEntity = null;
        double d = Double.MAX_VALUE;
        if (this.mc.world != null) {
            for (Entity entity : this.mc.world.getEntities()) {
                double d2;
                ItemEntity itemEntity2;
                if (!(entity instanceof ItemEntity) || !(itemEntity2 = (ItemEntity)entity).isAlive() || itemEntity2.squaredDistanceTo(vec3d) > 64.0 && itemEntity2.squaredDistanceTo((Entity)this.getPlayer()) > 36.0) continue;
                if (!this.msm.contains(itemEntity2.getId())) {
                    this.msk = true;
                }
                if (this.isTrashItem(itemEntity2.getStack()) || this.msl.contains(itemEntity2.getId()) || !((d2 = itemEntity2.squaredDistanceTo((Entity)this.getPlayer())) < d)) continue;
                d = d2;
                itemEntity = itemEntity2;
            }
        }
        if (itemEntity != null) {
            int n2;
            this.msv = 0;
            if (itemEntity.getId() != this.msp) {
                this.msp = itemEntity.getId();
                this.msn = 0;
                this.mso = d;
                this.mqy = null;
                this.mqz = 0;
            }
            ++this.msn;
            if (d < this.mso - 0.05) {
                this.mso = d;
                this.msn = 0;
            }
            if (this.msn > (n2 = this.mys(d < 2.25 ? 30 : 60))) {
                this.msl.add(itemEntity.getId());
                this.msp = -1;
                this.mqy = null;
                this.mqz = 0;
                pqf.resetKeys();
                return;
            }
            if (d > 6.25) {
                Entity entity;
                entity = itemEntity.getBlockPos();
                if (this.mqy == null || this.mqy.isEmpty() || this.mqz >= this.mqy.size() || this.mqy.get(this.mqy.size() - 1).getSquaredDistance((Vec3i)entity) > 4.0) {
                    this.naz((BlockPos)entity, false);
                }
                if (this.mqy != null && this.mqz < this.mqy.size()) {
                    this.ncr();
                } else {
                    this.ncq(itemEntity.getEntityPos(), true);
                }
            } else if (pqf.isBlockedHorizontally() && this.msn > 12) {
                if (this.mqy == null || this.mqz >= this.mqy.size()) {
                    this.naz(itemEntity.getBlockPos(), false);
                }
                if (this.mqy != null && this.mqz < this.mqy.size()) {
                    this.ncr();
                } else {
                    this.nbt(itemEntity.getEntityPos());
                }
            } else {
                this.mqy = null;
                this.nbt(itemEntity.getEntityPos());
            }
        } else {
            ++this.msv;
            double d3 = Math.hypot(vec3d.x - this.getPlayer().getX(), vec3d.z - this.getPlayer().getZ());
            if (!this.msk && this.msj != null && this.mrs < 12 && d3 > 1.1 && this.ncx(BlockPos.ofFloored((Position)this.msj))) {
                this.ncq(new Vec3d(vec3d.x, this.getPlayer().getY(), vec3d.z), true);
            } else {
                pqf.resetKeys();
            }
        }
        int n3 = n = this.msk ? 4 : 24;
        if (this.msv > n && this.mrs > 8 || this.mrs > this.mys(160)) {
            pqf.resetKeys();
            this.nbu(mpm2);
        }
    }

    private void nbt(Vec3d vec3d) {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        Vec3d vec3d2 = new Vec3d(vec3d.x, clientPlayerEntity.getEyePos().y - 0.6, vec3d.z);
        int n = this.mvl.walkTo(this.mc, (PlayerEntity)clientPlayerEntity, (World)this.getWorld(), vec3d, this.mtu, this.mtv, vec3d2, false, this.myq(), this.myt());
        if (n != 0 && !this.myq()) {
            pqf.resetKeys();
        }
        this.mux = true;
        this.mry = true;
    }

    private void nbu(mpm mpm2) {
        ++this.mqr;
        this.mrr = null;
        this.mrz = null;
        this.mqy = null;
        this.mqz = 0;
        this.msu = false;
        this.msv = 0;
        this.msj = null;
        this.msk = false;
        this.msl.clear();
        this.msm.clear();
        this.msp = -1;
        this.msn = 0;
        this.mso = Double.MAX_VALUE;
        this.msi = 0;
        this.msx = 0;
        this.msb = false;
        this.msf = 0;
        this.msg = 0;
        this.mse = 0;
        this.myd(mpm2);
    }

    private void nbv() {
        this.mtw = this.getPlayer();
        if (this.mtw != null) {
            this.nce(this.mtw);
            this.mtl.reset(this.mtw.getYaw(), this.mtw.getPitch());
            this.mtu = this.mtw.getYaw();
            this.mtv = this.mtw.getPitch();
            this.mtx = this.mtw.getEntityPos();
        }
        this.mtn = false;
        this.mto = false;
        this.mua = false;
        this.mub = false;
        this.muc = false;
    }

    private void nbw() {
        ptr.clear();
        if (this.mtn) {
            this.mtn = false;
            if (this.driver == null && this.mtm.ownedBy(this)) {
                this.mtm.release(this.mc.player);
            }
        }
    }

    private boolean nbx() {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (clientPlayerEntity == null) {
            return false;
        }
        boolean bl2 = bl = this.mtw != clientPlayerEntity || this.mtx == null || clientPlayerEntity.getEntityPos().squaredDistanceTo(this.mtx) > 400.0;
        if (bl) {
            if (this.driver == null) {
                this.mtm.reset();
            }
            if (this.mtw != clientPlayerEntity) {
                this.nce((PlayerEntity)clientPlayerEntity);
            }
            this.mtl.reset(clientPlayerEntity.getYaw(), clientPlayerEntity.getPitch());
            this.mtu = clientPlayerEntity.getYaw();
            this.mtv = clientPlayerEntity.getPitch();
            this.mtw = clientPlayerEntity;
            this.mtn = false;
            this.mqy = null;
            this.mqz = 0;
            this.mvm = null;
            this.mvl.reset();
        }
        this.mtx = clientPlayerEntity.getEntityPos();
        return bl;
    }

    private void nby(float f, float f2) {
        this.nbz(f, f2, false);
    }

    private void nbz(float f, float f2, boolean bl) {
        this.mts = f;
        this.mtt = f2;
        this.mtq = bl;
        this.mtr = false;
        this.mvd = 0.0;
        this.mto = true;
        this.mtp = false;
    }

    private void nca(Vec3d vec3d) {
        float[] fArray = prt.calculateAngle(vec3d);
        this.nbz(fArray[0], fArray[1], false);
    }

    private void ncb(BlockPos blockPos, Vec3d vec3d) {
        this.nca(vec3d);
        this.mvd = this.mve ? 0.25 : this.ncc(blockPos, vec3d);
    }

    private double ncc(BlockPos blockPos, Vec3d vec3d) {
        if (this.getWorld() == null || this.getPlayer() == null || blockPos == null || vec3d == null) {
            return 0.0;
        }
        VoxelShape voxelShape = this.getWorld().getBlockState(blockPos).getOutlineShape((BlockView)this.getWorld(), blockPos);
        Box box = voxelShape.isEmpty() ? new Box(blockPos) : voxelShape.getBoundingBox().offset(blockPos);
        double d = Math.min(Math.min(Math.min(vec3d.x - box.minX, box.maxX - vec3d.x), Math.min(vec3d.y - box.minY, box.maxY - vec3d.y)), Math.min(vec3d.z - box.minZ, box.maxZ - vec3d.z));
        if (d <= 0.02) {
            return 0.25;
        }
        double d2 = Math.max(0.5, this.getPlayer().getEyePos().distanceTo(vec3d));
        return MathHelper.clamp((double)(Math.toDegrees(Math.atan2(d, d2)) * 0.55), (double)0.25, (double)4.0);
    }

    private void ncd(boolean bl) {
        if (bl || this.mtl.isMoving()) {
            this.mvf = 0;
            return;
        }
        if (++this.mvf >= 3) {
            this.mve = true;
        }
    }

    private void nce(PlayerEntity playerEntity) {
        String string = playerEntity.getGameProfile() != null ? playerEntity.getGameProfile().name() : null;
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        this.mtl.personalize(l);
        this.mvl.personalize(l);
    }

    private void ncf() {
        if (!this.mto) {
            this.mtp = true;
        }
    }

    private boolean ncg() {
        if (this.mvi > 0) {
            --this.mvi;
            return true;
        }
        if (this.mvj > 0) {
            --this.mvj;
            return false;
        }
        if (this.msu || this.mqq != mpm.FARMING && this.mqq != mpm.FARMING_SAND && this.mqq != mpm.RUN_TO_FARM_COORDS) {
            return false;
        }
        this.mvj = 2400 + this.mty.nextInt(4200);
        this.mvi = 8 + this.mty.nextInt(26);
        return true;
    }

    private void nch() {
        this.mvh = false;
        this.mve = false;
        this.mvf = 0;
        this.muz = (this.mty.nextDouble() - 0.5) * 0.34;
        this.mva = (this.mty.nextDouble() - 0.5) * 0.44;
        this.mvb = (this.mty.nextDouble() - 0.5) * 0.34;
        this.mvc = 1 + this.mty.nextInt(4);
    }

    private boolean nci() {
        return this.mqy != null && this.mqz < this.mqy.size();
    }

    private float ncj() {
        return (float)this.mvl.moveYaw(this.mtu);
    }

    private void nck() {
        if (this.getPlayer() == null) {
            return;
        }
        this.mvr = this.mto && !this.mtq;
        boolean bl = this.mvl.takeTurn(this.mvs);
        if (this.myq() && !this.mvr) {
            this.ncl();
            return;
        }
        if (this.mc.currentScreen == null) {
            this.mtl.setMouseStep(this.driver != null ? this.driver.mouseStep() : prp.step());
            if (this.ncm()) {
                this.mtl.freeze();
            } else if (this.mto) {
                if (this.mtq && this.mtr) {
                    this.mtl.aimTight(this.mts, this.mtt);
                } else if (this.mtq) {
                    this.mtl.aimRelaxed(this.mts, this.mtt);
                } else {
                    this.mtl.aim(this.mts, this.mtt, this.mvd);
                }
            } else if (bl) {
                this.mtl.turn(this.mvs[0], this.mvs[1]);
            } else if (this.mtp) {
                this.mtl.hold();
            } else {
                this.mtl.idle();
            }
            this.mtu = this.mtl.getYaw();
            this.mtv = this.mtl.getPitch();
        }
        this.mto = false;
        this.mtp = false;
        if (this.driver != null) {
            if (this.mc.currentScreen == null) {
                this.driver.look(this.mtu, MathHelper.clamp((float)this.mtv, (float)-90.0f, (float)90.0f));
            }
        } else {
            this.mtm.set(this, this.mtu, MathHelper.clamp((float)this.mtv, (float)-90.0f, (float)90.0f));
        }
        this.mtn = true;
        if (this.mc.currentScreen != null) {
            ptr.clear();
        } else if (this.mvk != null) {
            ptr.aimAt(this.mvk, this.mtu, this.mtv);
        }
        this.mvk = null;
    }

    private void ncl() {
        this.mto = false;
        this.mtp = false;
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        this.mtl.reset(clientPlayerEntity.getYaw(), clientPlayerEntity.getPitch());
        this.mtu = clientPlayerEntity.getYaw();
        this.mtv = clientPlayerEntity.getPitch();
        if (this.mtn) {
            this.mtn = false;
            if (this.mtm.ownedBy(this)) {
                this.mtm.release(this.mc.player);
            }
        }
        if (this.mc.currentScreen != null) {
            ptr.clear();
        } else if (this.mvk != null) {
            ptr.aimAt(this.mvk, this.mtu, this.mtv);
        }
        this.mvk = null;
    }

    private boolean ncm() {
        return this.mud > 0 || !this.msy.isEmpty() || this.mtb > 0;
    }

    private BlockHitResult ncn() {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        Vec3d vec3d = this.getPlayer().getEyePos();
        Vec3d vec3d2 = Vec3d.fromPolar((float)this.mtv, (float)this.mtu);
        double d = 4.5;
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d, vec3d2.y * d, vec3d2.z * d);
        return this.getWorld().raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
    }

    private BlockHitResult nco(BlockPos blockPos) {
        BlockHitResult blockHitResult = this.ncn();
        if (blockHitResult != null && blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)blockPos)) {
            this.mvk = blockPos;
            return blockHitResult;
        }
        return null;
    }

    private void ncp(Vec3d vec3d) {
        this.ncq(vec3d, false);
    }

    private void ncq(Vec3d vec3d, boolean bl) {
        int n = this.mvl.walkTo(this.mc, (PlayerEntity)this.getPlayer(), (World)this.getWorld(), vec3d, this.mtu, this.mtv, null, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
        if (n != 0 && !this.myq()) {
            pqf.resetKeys();
        }
        this.mux = true;
        this.mry = true;
    }

    private void ncr() {
        if (this.mqy == null || this.mqz >= this.mqy.size()) {
            return;
        }
        if (!this.myq() && this.ncg()) {
            pqf.resetKeys();
            this.ncf();
            return;
        }
        if (this.mvm == null) {
            this.mvm = this.mvl.plan((World)this.getWorld(), (PlayerEntity)this.getPlayer(), this.mqy, this.mqy.get(this.mqy.size() - 1), new prz());
            if (this.mvm == null) {
                this.mqy = null;
                this.mqz = 0;
                return;
            }
        }
        Vec3d vec3d = this.muy;
        this.muy = null;
        int n = this.mvl.follow(this.mc, (PlayerEntity)this.getPlayer(), (World)this.getWorld(), this.mvm, this.mtu, this.mtv, vec3d, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
        if (n == 2) {
            this.mqy = null;
            this.mqz = 0;
            this.mvm = null;
            this.mse = 0;
            if (!this.myq()) {
                pqf.resetKeys();
            }
            return;
        }
        if (n == 1) {
            this.mqz = this.mqy.size();
            this.mvm = null;
            if (!this.myq()) {
                pqf.resetKeys();
            }
            return;
        }
        this.mqz = Math.min(this.mqy.size() - 1, this.mvm.nodeIndex(this.mvl.stride.at()));
        this.mux = true;
        this.mry = true;
    }

    private boolean ncs(Vec3d vec3d) {
        return this.nct(vec3d, true);
    }

    private boolean nct(Vec3d vec3d, boolean bl) {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return false;
        }
        Vec3d vec3d2 = this.getPlayer().getEntityPos();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.z - vec3d2.z;
        double d3 = Math.hypot(d, d2);
        if (d3 < 0.1) {
            return true;
        }
        double d4 = this.ncu();
        int n = (int)Math.ceil(d3 / 0.45);
        for (int i = 1; i <= n; ++i) {
            double d5 = (double)i / (double)n;
            double d6 = vec3d2.x + d * d5;
            double d7 = vec3d2.z + d2 * d5;
            if (!this.ncv(d6, d7, d4)) {
                return false;
            }
            if (!bl || !this.ncx(BlockPos.ofFloored((double)d6, (double)(d4 - 0.2), (double)d7))) continue;
            return false;
        }
        return true;
    }

    private double ncu() {
        return this.nci() ? pqf.getStandY(this.mqy.get(this.mqz)) : this.getPlayer().getY();
    }

    private boolean ncv(double d, double d2, double d3) {
        return this.ncw(new Box(d - 0.31, d3 + 0.6, d2 - 0.31, d + 0.31, d3 + 1.8, d2 + 0.31));
    }

    private boolean ncw(Box box) {
        for (VoxelShape voxelShape : this.getWorld().getBlockCollisions((Entity)this.getPlayer(), box)) {
            if (voxelShape.isEmpty()) continue;
            return false;
        }
        return true;
    }

    private boolean ncx(BlockPos blockPos) {
        return this.getWorld().getBlockState(blockPos).getCollisionShape((BlockView)this.getWorld(), blockPos).isEmpty();
    }

    private void ncy() {
        if (!this.nde()) {
            this.myd(mpm.CHECK_PVP_COOLDOWN);
            return;
        }
        this.msu = false;
        this.msv = 0;
        if (this.mrz != null && (this.mra.contains(this.mrz) || !this.ndb(this.mrz))) {
            this.ncz(false);
        }
        if (this.mrz == null && this.msg <= 0) {
            this.mrz = this.nda();
            if (this.mrz == null) {
                this.msg = 10;
            } else {
                this.msi = 0;
                this.msx = 0;
                this.nch();
                this.naz(this.mrz, true);
            }
        }
        if (this.mrz == null) {
            this.nbf();
            return;
        }
        ++this.msi;
        double d = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)this.mrz));
        boolean bl = this.nbm(this.mrz);
        if (bl && d <= 16.0) {
            pqf.resetKeys();
            this.mqy = null;
            this.mqz = 0;
            this.myd(mpm.BRUSHING_SAND);
            this.msa = 0;
            this.msb = false;
            this.msx = 0;
            return;
        }
        if (this.msi > this.mys(300)) {
            this.ncz(true);
            return;
        }
        if (!this.mvh && bl && d <= 36.0 && this.ncs(Vec3d.ofCenter((Vec3i)this.mrz))) {
            this.mvh = true;
        }
        if (this.mvh && bl) {
            this.muy = this.nbo(this.mrz);
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
            this.msx = 0;
            return;
        }
        ++this.msx;
        if (this.msx >= 40) {
            this.ncz(true);
            return;
        }
        if (bl && d < 100.0) {
            this.ncp(Vec3d.ofCenter((Vec3i)this.mrz));
        } else if (!this.naz(this.mrz, false)) {
            pqf.resetKeys();
        }
    }

    private void ncz(boolean bl) {
        if (bl && this.mrz != null) {
            this.mra.add(this.mrz);
        }
        this.mvh = false;
        this.mrz = null;
        this.mqy = null;
        this.mqz = 0;
        this.msx = 0;
        this.msi = 0;
        this.msb = false;
        this.mc.options.useKey.setPressed(false);
    }

    private BlockPos nda() {
        BlockPos blockPos = this.getPlayer().getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (PlayerEntity playerEntity : this.getWorld().getPlayers()) {
            if (playerEntity == this.getPlayer()) continue;
            arrayList.add(playerEntity.getEntityPos());
        }
        BlockPos blockPos2 = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i <= 32; ++i) {
            for (int j = -i; j <= i; ++j) {
                for (int k = -i; k <= i; ++k) {
                    if (Math.max(Math.abs(j), Math.abs(k)) != i) continue;
                    for (int i2 = -8; i2 <= 8; ++i2) {
                        mutable.set(blockPos.getX() + j, blockPos.getY() + i2, blockPos.getZ() + k);
                        if (!this.ndb((BlockPos)mutable) || this.mra.contains(mutable)) continue;
                        double d2 = mutable.getSquaredDistance((Vec3i)blockPos);
                        Vec3d vec3d = Vec3d.ofCenter((Vec3i)mutable);
                        for (Vec3d vec3d2 : arrayList) {
                            if (!(vec3d2.squaredDistanceTo(vec3d) < 1600.0)) continue;
                            d2 += 100000.0;
                            break;
                        }
                        if (!(d2 < d)) continue;
                        d = d2;
                        blockPos2 = mutable.toImmutable();
                    }
                }
            }
            if (blockPos2 == null || !(d < 100000.0)) continue;
            return blockPos2;
        }
        return blockPos2;
    }

    private boolean ndb(BlockPos blockPos) {
        if (this.getWorld() == null || blockPos == null) {
            return false;
        }
        return this.getWorld().getBlockState(blockPos).isOf(Blocks.SUSPICIOUS_SAND);
    }

    private void ndc() {
        if (!this.nde()) {
            this.mc.options.useKey.setPressed(false);
            this.msj = this.mrz != null ? Vec3d.ofCenter((Vec3i)this.mrz) : this.getPlayer().getEntityPos();
            this.mrz = null;
            this.msu = false;
            this.myd(mpm.LOOTING_SAND);
            return;
        }
        if (this.mrz == null || !this.ndb(this.mrz)) {
            this.mc.options.useKey.setPressed(false);
            Vec3d vec3d = this.msj = this.mrz != null ? Vec3d.ofCenter((Vec3i)this.mrz) : this.getPlayer().getEntityPos();
            if (this.mrz != null) {
                this.mra.add(this.mrz);
                ++this.mqv;
            }
            this.mrz = null;
            this.msu = false;
            this.myd(mpm.LOOTING_SAND);
            return;
        }
        ++this.msa;
        int n = this.ndg(0, 9);
        if (n == -1) {
            int n2 = this.ndg(9, 36);
            if (n2 != -1 && this.msy.isEmpty()) {
                int n3 = this.nav();
                if (n3 == -1) {
                    n3 = 8;
                }
                int n4 = n3;
                int n5 = n2;
                this.msy.add(() -> this.ndv(n5, n4, SlotActionType.SWAP));
            }
            return;
        }
        this.getPlayer().getInventory().setSelectedSlot(n);
        double d = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)this.mrz));
        if (d > 5.0) {
            this.msb = false;
            this.mc.options.useKey.setPressed(false);
            if (this.nbm(this.mrz)) {
                this.ncp(Vec3d.ofCenter((Vec3i)this.mrz));
            } else {
                if (this.mqy == null || this.mqz >= this.mqy.size()) {
                    this.naz(this.mrz, false);
                }
                if (this.mqy != null && this.mqz < this.mqy.size()) {
                    this.ncr();
                } else {
                    pqf.resetKeys();
                }
            }
            if (this.msa > this.mys(120)) {
                this.mra.add(this.mrz);
                this.mrz = null;
                this.mc.options.useKey.setPressed(false);
                this.myd(mpm.FARMING_SAND);
            }
            return;
        }
        if (!this.msb) {
            this.msb = true;
            this.msa = 0;
            this.mqy = null;
            this.mqz = 0;
        }
        pqf.resetKeys();
        this.ncb(this.mrz, Vec3d.ofCenter((Vec3i)this.mrz));
        BlockHitResult blockHitResult = this.nco(this.mrz);
        boolean bl = blockHitResult != null;
        this.ncd(bl);
        if (bl && this.mvc > 0) {
            --this.mvc;
            bl = false;
            blockHitResult = null;
        }
        if (bl) {
            this.mc.options.useKey.setPressed(true);
            if (!this.getPlayer().isUsingItem()) {
                BlockHitResult blockHitResult2 = blockHitResult;
                ptr.later(() -> {
                    if (this.mc.interactionManager != null && this.mc.player != null && !this.mc.player.isUsingItem() && mpq.ndf(this.mc.player.getMainHandStack())) {
                        this.mc.interactionManager.interactBlock(this.mc.player, Hand.MAIN_HAND, blockHitResult2);
                        this.mc.player.setCurrentHand(Hand.MAIN_HAND);
                    }
                });
            }
            this.msx = 0;
        } else {
            this.mc.options.useKey.setPressed(false);
            ++this.msx;
            if (this.msx > 40) {
                this.mra.add(this.mrz);
                this.mrz = null;
                this.msx = 0;
                this.msb = false;
                this.myd(mpm.FARMING_SAND);
                return;
            }
        }
        if (this.msa > 200) {
            this.mra.add(this.mrz);
            this.msj = Vec3d.ofCenter((Vec3i)this.mrz);
            this.mrz = null;
            this.msb = false;
            this.mc.options.useKey.setPressed(false);
            this.msu = false;
            this.myd(mpm.LOOTING_SAND);
        }
    }

    private void ndd() {
        if (!this.msu) {
            this.nbp(this.msj != null ? this.msj : this.getPlayer().getEntityPos());
        }
        this.nbs(this.nde() ? mpm.FARMING_SAND : mpm.CHECK_PVP_COOLDOWN);
    }

    private boolean nde() {
        return this.ndg(0, 36) != -1;
    }

    private static boolean ndf(ItemStack itemStack) {
        if (!itemStack.isOf(Items.BRUSH)) {
            return false;
        }
        if (itemStack.contains(DataComponentTypes.UNBREAKABLE)) {
            return true;
        }
        LoreComponent loreComponent = (LoreComponent)itemStack.get(DataComponentTypes.LORE);
        if (loreComponent == null) {
            return false;
        }
        for (Text text : loreComponent.lines()) {
            if (!text.getString().toLowerCase().contains(a.b("\u3f90\u4629\ucc8f\u528e\ud95e\u5f98\ue5c8\u6c32\uf215\u78a1\uff7b", 1763457958))) continue;
            return true;
        }
        return false;
    }

    private int ndg(int n, int n2) {
        for (int i = n; i < n2; ++i) {
            if (!mpq.ndf(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private void ndh() {
        if (this.mwa - this.mwb > 60) {
            ++this.mqp;
            this.myd(mpm.TELEPORT_TO_SAVE);
            this.mrt = null;
            return;
        }
        this.ndi();
    }

    private void ndi() {
        PlayerEntity playerEntity = this.neh();
        if (playerEntity != null) {
            if (this.mse <= 0 && (this.mrt == null || this.mrt.getSquaredDistance((Vec3i)this.getPlayer().getBlockPos()) < 10.0 || playerEntity.squaredDistanceTo((Entity)this.getPlayer()) < 400.0)) {
                Vec3d vec3d = this.mzj(this.getPlayer().getEntityPos().subtract(playerEntity.getEntityPos()).normalize(), Math.toRadians(this.mty.nextGaussian() * 20.0));
                double d = 26.0 + this.mty.nextDouble() * 14.0;
                this.mrt = this.nbd(this.getPlayer().getBlockPos().add((int)(vec3d.x * d), 0, (int)(vec3d.z * d)));
                this.mse = 10;
                this.nbc(this.nba(this.mrt));
            }
        } else if (this.mse <= 0 && (this.mrt == null || this.mrt.getSquaredDistance((Vec3i)this.getPlayer().getBlockPos()) < 4.0)) {
            double d = this.mty.nextDouble() * Math.PI * 2.0;
            double d2 = 18.0 + this.mty.nextDouble() * 20.0;
            this.mrt = this.nbd(this.getPlayer().getBlockPos().add((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2)));
            this.mse = 10;
            this.nbc(this.nba(this.mrt));
        }
        if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
        } else {
            pqf.resetKeys();
        }
    }

    private boolean ndj() {
        return pjn.contains(this.mc, a.d("\uf6dc\u8f4b\u05be\u9bb2\u1408\u92cc\u289c\ua163\u3f38\ub195\u3256\uc82d\u4682\udf49\u5510\ud3e6\u69a1", 606286106, 1128580999));
    }

    private void ndk() {
        String string = mpq.nak(this.mqh.get());
        if (!pjd.enter(this.mxs(), string)) {
            this.nal(a.c(-1477713762, "\ue4a0\u9d3c\u13ff\u89ef\u024c\u84f1\u3ea9\ub75f\u2d15\ua3c7\u2461\ude13\u54d1\ucd73\u4733\uc5df\u7f9d\uf034\u6af7\uecdb\u6149\u1b15\u95ab\u0a6c\u8c11\u06a5\ubf7b\u3536\uabdf\u2df7\ua636\u5892\ud2a8\u4b58\ucd07"));
            return;
        }
        this.mwn = "";
        this.getNetworkHandler().sendChatCommand(string);
        this.mrh = false;
        this.mri = false;
        this.mrj = false;
        this.mrk = false;
        this.myn();
        this.naa();
        this.mrl = null;
        this.mqr = 0;
        this.mra.clear();
        this.mrt = null;
        this.mrn = 0;
        this.mro = false;
        this.mrp = null;
        this.mrq = 0;
        this.mst = false;
        this.myd(mpm.WARPING_TO_SAVE_BASE);
    }

    private void ndl() {
        pqf.resetKeys();
        this.mzf();
        ++this.mrn;
        if (this.naw() > 0) {
            this.mrq = 0;
            return;
        }
        if (this.mrn < 60) {
            return;
        }
        this.myd(mpm.RESTOCK_AND_DUMP);
    }

    public boolean isTrashItem(ItemStack itemStack) {
        Boolean bl;
        if (itemStack.isEmpty()) {
            return false;
        }
        vlj vlj2 = this.lootList();
        if (this.mwd != this.mwa || this.mwe != vlj2.version() || this.mwc.size() > 512) {
            this.mwc.clear();
            this.mwd = this.mwa;
            this.mwe = vlj2.version();
        }
        if ((bl = this.mwc.get(itemStack)) == null) {
            bl = this.ndm(itemStack, vlj2);
            this.mwc.put(itemStack, bl);
        }
        return bl;
    }

    private boolean ndm(ItemStack itemStack, vlj vlj2) {
        if (this.neg(itemStack)) {
            return false;
        }
        if (itemStack.isOf(Items.BRUSH)) {
            return true;
        }
        if (ppu.picked(itemStack, vlj2.ids())) {
            return false;
        }
        if (ppu.known(itemStack)) {
            return true;
        }
        Item item = itemStack.getItem();
        String string = item.getTranslationKey().toLowerCase();
        if (item == Items.DRAGON_HEAD) {
            return false;
        }
        if (item == Items.GOLDEN_CARROT) {
            return false;
        }
        if (item == Items.VILLAGER_SPAWN_EGG || item == Items.ZOMBIE_VILLAGER_SPAWN_EGG) {
            return false;
        }
        if (item == Items.GOLDEN_APPLE || item == Items.ENCHANTED_GOLDEN_APPLE) {
            return false;
        }
        if (item == Items.HEAVY_CORE) {
            return false;
        }
        if (string.contains(a.d("\u856b\ufcd7\u7600\ue874", -1352822735, 531371318)) || string.contains(a.d("\uf3e2\u8a4b\u0086\u9eee\u1539", 1696324825, -305647795))) {
            return false;
        }
        if (item == Items.IRON_NUGGET) {
            return false;
        }
        String string2 = itemStack.getName().getString().toLowerCase();
        if (string.contains(a.b("\u7ee0\u0742\u8d91\u13fd\u9832", 302743172))) {
            if (string2.contains(a.d("\ud49b\uad28\u27fc\ub9fe", -805642075, 1178742797)) || string2.contains(a.d("\uf0f4\u893f\u0392\u9def\u163a\u9089", -630686278, 1317964146)) || string2.contains(a.c(2070976211, "\u92e6\ueb28\u61ff\ufff1\u745c\uf29a\u48c7\uc141\u5f6f"))) {
                return true;
            }
            return item != Items.TIPPED_ARROW && !itemStack.contains(DataComponentTypes.CUSTOM_NAME);
        }
        if (string2.contains(a.d("\uc91a\ub0d5\u3a03\ua473\u2fd8\ua962\u1343", -1753364669, 1573915163))) {
            return true;
        }
        if (item == Items.LEAD) {
            return true;
        }
        if (item == Items.DRAGON_BREATH) {
            return true;
        }
        if (item == Items.EGG) {
            return true;
        }
        if (item == Items.GLASS_BOTTLE) {
            return true;
        }
        if (item == Items.FEATHER) {
            return !itemStack.contains(DataComponentTypes.CUSTOM_NAME);
        }
        if (item == Items.HONEY_BOTTLE || item == Items.HONEYCOMB) {
            return true;
        }
        if (item == Items.ENCHANTING_TABLE) {
            return true;
        }
        if (item == Items.BOOKSHELF) {
            return true;
        }
        if (item == Items.GHAST_TEAR) {
            return true;
        }
        if (item == Items.SHULKER_SHELL) {
            return true;
        }
        if (item == Items.FERMENTED_SPIDER_EYE) {
            return true;
        }
        if (item == Items.END_CRYSTAL) {
            return true;
        }
        if (item == Items.BOW) {
            return true;
        }
        if (item == Items.LEATHER) {
            return true;
        }
        if (item == Items.EMERALD) {
            return true;
        }
        if (item == Items.IRON_INGOT) {
            return true;
        }
        if (item == Items.GOLD_INGOT || item == Items.GOLD_NUGGET) {
            return true;
        }
        if (item == Items.NAUTILUS_SHELL) {
            return true;
        }
        if (item == Items.GUNPOWDER) {
            return true;
        }
        if (item == Items.CHORUS_FRUIT || item == Items.POPPED_CHORUS_FRUIT) {
            return true;
        }
        if (string.contains(a.c(753118924, "\uae95\ud708\u5ddf\uc3b6\u487c\ucedb"))) {
            return true;
        }
        if (item == Items.BONE) {
            return true;
        }
        if (string.contains(a.b("\uf296\u8b20\u01ee\u9f9e\u145f\u92d4\u28b9\ua15b\u3f1b\ub5a8\u3266", 2075063029)) || string.contains(a.b("\u9dcb\ue462\u6eb2\uf0c9\u7b27\ufda8\u47e8\uce06\u505b\udaf7", 1642700214))) {
            return true;
        }
        if (item == Items.BLAZE_ROD) {
            return true;
        }
        if (item == Items.SLIME_BALL) {
            return true;
        }
        if (itemStack.contains(DataComponentTypes.FOOD)) {
            return true;
        }
        if (string.contains(a.d("\ua8a5\ud117\u5bd5\uc5b2\u4e7c\uc8fc\u7295\ufb66\u6539", -244918230, -2124713739))) {
            return true;
        }
        if (item == Items.ENDER_CHEST) {
            return true;
        }
        if (item == Items.FIREWORK_ROCKET) {
            return true;
        }
        if (item == Items.ENCHANTED_BOOK || item == Items.BOOK || item == Items.WRITTEN_BOOK || item == Items.WRITABLE_BOOK) {
            return true;
        }
        if (string.contains(a.c(201042272, "\ua904\ud0ba\u5a71\uc41f\u4fcd"))) {
            return true;
        }
        if (string.contains(a.d("\u46fa\u3f5a\ub581\u2bed\ua026\u269a\u9cdc\u153c", -1896952143, -882633))) {
            return true;
        }
        if (string.contains(a.d("\u1ff3\u6659\uec8d\u72e5\uf921\u7f99", 690090973, 1491856475))) {
            return true;
        }
        if (item == Items.WITHER_ROSE) {
            return true;
        }
        if (item == Items.TRIDENT) {
            return true;
        }
        if (item == Items.CONDUIT) {
            return true;
        }
        if (string.contains(a.b("\u8a9f\uf336\u79e3\ue788\u6c55\uead8\u50b0\ud94c\u4709\ucda8", 1858439928))) {
            return true;
        }
        if (string.contains(a.d("\u0e53\u77f5\ufd32\u635a\ue895", -123881445, -206719429))) {
            return true;
        }
        if (item == Items.PUFFERFISH) {
            return true;
        }
        if (item == Items.COD_BUCKET || item == Items.SALMON_BUCKET || item == Items.TROPICAL_FISH_BUCKET || item == Items.PUFFERFISH_BUCKET) {
            return true;
        }
        if (string.contains(a.c(-1623003556, "\uee38\u978a\u1d56\u8327\u08fb\u8e5d"))) {
            return true;
        }
        if (item == Items.STRING) {
            return true;
        }
        if (item == Items.NAME_TAG) {
            return true;
        }
        if (item == Items.HEART_OF_THE_SEA) {
            return true;
        }
        if ((string.endsWith(a.b("\ueb8f\u9209\u18d7\u86af\u0d79\u8bc0\u3182", 120908759)) || string.endsWith(a.c(-1549359105, "\ua7ab\ude26\u54fe\uca82\u4143\uc7f5\u7da2\uf44f\u6a1d\ue0b9\u677b")) || string.endsWith(a.d("\u47b4\u3e36\ub4ec\u2a9f\ua148\u27f7\u9da3\u145b\u8a10", 1280063692, -1278771410)) || string.endsWith(a.b("\ubc20\uc5ac\u4f72\ud103\u5acf\udc79", -1565016967))) && !string.contains(a.d("\u798f5\u8af7\u149a\u9f40\u19e6\ua3ae\u2a42\ub40c", -1978584711, -1364703087))) {
            return true;
        }
        if (string.contains(a.d("\u188d\u6131\uebea\u7597\ufe42\u78f2\uc2ab\u4b61\ud511\u5fb9\ud860\u2219\uacc4\u356c\ubf22", 704415766, 2027065584)) || string.contains(a.c(-1106399894, "\uad05\ud4b9\u5e62\uc01f\u4bca\ucd7a\u7723\ufee9\u6088\uea20\u6dee"))) {
            return true;
        }
        if (string.contains(a.c(-385664684, "\u392b\u4091\uca53\u543e\udfe4\u5942\ue30a\u6ae6\uf4a8\u7e23\uf9df\u03b7\u8d6a\u14d3\u9e8a\u1862\ua230")) || string.contains(a.c(376136199, "\u6264\u1bde\u911c\u0f71\u84ab\u020d\ub845\u31a9\uafe7\u256c\ua281\u58e9\ud623"))) {
            return true;
        }
        return item == Items.STONE_AXE;
    }

    private void ndn() {
        if (this.mqq == mpm.TELEPORT_TO_SAVE || this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.RESTOCK_AND_DUMP || this.mqq == mpm.TELEPORT_TO_LOOT) {
            this.mus = true;
            this.muu = -1;
            this.muv = 0;
            return;
        }
        if (!this.mus) {
            if (this.muv > 0) {
                --this.muv;
            }
            return;
        }
        if (this.muu < 0) {
            boolean bl;
            boolean bl2 = bl = this.mut != null && this.getWorld() != this.mut;
            if (!bl && !this.mzh()) {
                return;
            }
            this.muu = 10 + this.mty.nextInt(20);
        }
        if (this.muu-- > 0) {
            return;
        }
        this.mus = false;
        this.mut = null;
        this.muu = -1;
        this.muv = 400;
    }

    private void ndo() {
        int n;
        int n2;
        if (this.nec()) {
            return;
        }
        if (this.mc.currentScreen != null || !this.msy.isEmpty() || this.mud > 0) {
            return;
        }
        if (this.mum <= 0 && this.ndx() && (n2 = this.ndy()) != -1) {
            if (this.mur > 10.0f) {
                this.mum = 200 + this.mty.nextInt(200);
                return;
            }
            this.ndz(n2);
            return;
        }
        if (this.mus || this.mqq == mpm.ESCAPING) {
            return;
        }
        if (this.mc.options.attackKey.isPressed()) {
            return;
        }
        if (this.msu && this.getPlayer().getInventory().getEmptySlot() != -1) {
            return;
        }
        n2 = 0;
        int n3 = 0;
        for (n = 9; n < 36; ++n) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(n);
            if (itemStack.isEmpty()) {
                ++n3;
                continue;
            }
            if (!this.isTrashItem(itemStack)) continue;
            ++n2;
        }
        if (n2 == 0) {
            return;
        }
        if (this.muv <= 0 && n3 > 3 && n2 < 5 && this.getPlayer().getInventory().getEmptySlot() != -1) {
            return;
        }
        this.muv = 0;
        for (n = 0; n < 9; ++n) {
            if (!this.isTrashItem(this.getPlayer().getInventory().getStack(n))) continue;
            ++n2;
        }
        this.mud = 1;
        this.mue = n2;
        this.muf = 3 + (this.mty.nextFloat() < 0.4f ? 1 : 0);
        this.mug = 0;
        this.muh = 30 + n2 * 6;
        this.mui = -1;
    }

    private void ndp() {
        int n;
        ++this.mug;
        if (this.mug > this.muh || this.mc.currentScreen != null || this.getPlayer() == null || this.mqq == mpm.ESCAPING || this.mus) {
            this.ndq();
            return;
        }
        if (this.muf > 0) {
            --this.muf;
            return;
        }
        if (!this.isMovementSilent()) {
            return;
        }
        if (this.mue <= 0) {
            this.ndq();
            return;
        }
        int n2 = this.ndr();
        if (n2 == -1) {
            this.mue = 0;
            this.muf = 1 + this.mty.nextInt(2);
            return;
        }
        this.ndv(n2, 1, SlotActionType.THROW);
        this.mui = n2;
        --this.mue;
        int n3 = n = this.mue > 0 ? this.ndr() : -1;
        if (n == -1) {
            this.mue = 0;
            this.muf = 1 + this.mty.nextInt(2);
        } else {
            this.muf = this.ndt(mpq.nds(n2, n));
        }
    }

    private void ndq() {
        this.mud = 0;
        this.mue = 0;
        this.muf = 0;
        this.mug = 0;
        this.muh = 0;
        this.mui = -1;
        this.ndw();
        this.ndu();
    }

    private int ndr() {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n = this.mui != -1 ? this.mui : 13;
        int n2 = -1;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < 36; ++i) {
            double d2;
            if (!this.isTrashItem(playerInventory.getStack(i)) || !((d2 = mpq.nds(n, i)) < d)) continue;
            d = d2;
            n2 = i;
        }
        return n2;
    }

    private static double nds(int n, int n2) {
        double d = n < 9 ? 3.25 : (double)((n - 9) / 9);
        double d2 = n < 9 ? (double)n : (double)((n - 9) % 9);
        double d3 = n2 < 9 ? 3.25 : (double)((n2 - 9) / 9);
        double d4 = n2 < 9 ? (double)n2 : (double)((n2 - 9) % 9);
        return Math.hypot(d - d3, d2 - d4);
    }

    private int ndt(double d) {
        int n = d <= 1.5 ? 2 : (d <= 4.0 ? 3 : 4);
        float f = this.mty.nextFloat();
        if (n == 2 && f < 0.12f) {
            n = 1;
        } else if (f > 0.65f) {
            ++n;
        }
        return n - 1;
    }

    private void ndu() {
        KeyBinding[] keyBindingArray;
        if (this.mc.options == null) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{this.mc.options.forwardKey, this.mc.options.backKey, this.mc.options.leftKey, this.mc.options.rightKey, this.mc.options.jumpKey, this.mc.options.sprintKey}) {
            keyBinding.setPressed(this.heldByHuman(keyBinding));
        }
    }

    private void ndv(int n, int n2, SlotActionType slotActionType) {
        if (this.mc.interactionManager == null || this.getPlayer() == null) {
            return;
        }
        int n3 = n < 9 ? n + 36 : n;
        this.mc.interactionManager.clickSlot(this.getPlayer().playerScreenHandler.syncId, n3, n2, slotActionType, (PlayerEntity)this.getPlayer());
        if (this.mc.currentScreen == null) {
            this.muw = true;
        }
    }

    private void ndw() {
        if (!this.muw) {
            return;
        }
        this.muw = false;
        if (this.mc.currentScreen != null || this.getPlayer() == null || this.getNetworkHandler() == null) {
            return;
        }
        this.getNetworkHandler().sendPacket((Packet)new CloseHandledScreenC2SPacket(this.getPlayer().playerScreenHandler.syncId));
    }

    private boolean ndx() {
        return this.mc.currentScreen == null && !this.muw && this.msy.isEmpty() && this.mud == 0 && !this.mus && !this.mc.options.attackKey.isPressed() && !this.mc.options.useKey.isPressed() && !this.getPlayer().isUsingItem() && !this.getPlayer().isSpectator() && this.mqq != mpm.BRUSHING_SAND && this.mqq != mpm.ESCAPING && this.mqq != mpm.LOOTING_VASE && !this.mvh;
    }

    private int ndy() {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n = playerInventory.getSelectedSlot();
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            if (!this.isTrashItem(playerInventory.getStack(i)) || n2 != -1 && Math.abs(i - n) >= Math.abs(n2 - n)) continue;
            n2 = i;
        }
        return n2;
    }

    private void ndz(int n) {
        this.neb();
        this.muk = n;
        boolean bl = this.getPlayer().getInventory().getSelectedSlot() == n;
        this.mul = bl ? 0 : this.nea();
        this.getPlayer().getInventory().setSelectedSlot(n);
    }

    private int nea() {
        float f = this.mty.nextFloat();
        return f < 0.2f ? 0 : (f < 0.6f ? 1 : (f < 0.9f ? 2 : 3));
    }

    private void neb() {
        this.muk = -1;
        this.mul = 0;
        this.mun = false;
        this.muo = 0;
        this.mup = 0;
    }

    private boolean nec() {
        if (this.muk == -1) {
            return false;
        }
        if (this.mun) {
            if (this.mup == 0 && ++this.muo <= 3) {
                return true;
            }
            boolean bl = this.mup > 0;
            this.neb();
            if (bl) {
                this.mur += 1.0f;
                this.mum = this.mty.nextInt(3);
            } else {
                this.mum = 8 + this.mty.nextInt(12);
            }
            return false;
        }
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        if (!this.ndx() || !this.isTrashItem(playerInventory.getStack(this.muk))) {
            this.neb();
            this.mum = 4 + this.mty.nextInt(8);
            return false;
        }
        if (playerInventory.getSelectedSlot() != this.muk) {
            this.neb();
            this.mum = 10 + this.mty.nextInt(10);
            return false;
        }
        if (this.mul-- > 0) {
            return true;
        }
        int n = this.muk;
        int n2 = ++this.muq;
        this.mun = true;
        this.muo = 0;
        this.mup = 0;
        ptr.later(() -> {
            boolean bl = this.ned(n, n2);
            if (n2 == this.muq) {
                this.mup = bl ? 1 : -1;
            }
        });
        return true;
    }

    private boolean ned(int n, int n2) {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (n2 != this.muq || !this.mun || clientPlayerEntity == null || this.mc.currentScreen != null || clientPlayerEntity.isSpectator() || clientPlayerEntity.getInventory().getSelectedSlot() != n) {
            return false;
        }
        ItemStack itemStack = clientPlayerEntity.getMainHandStack();
        if (!this.isTrashItem(itemStack)) {
            return false;
        }
        if (!clientPlayerEntity.dropSelectedItem(itemStack.getCount() > 1)) {
            return false;
        }
        clientPlayerEntity.swingHand(Hand.MAIN_HAND);
        return true;
    }

    public boolean busy() {
        return !this.msy.isEmpty() || this.mud > 0 || this.mtb > 0 || this.mc.currentScreen instanceof GenericContainerScreen;
    }

    private void nee() {
        int n;
        if (this.mc.currentScreen != null || !this.msy.isEmpty() || this.mud > 0 || this.muk != -1) {
            return;
        }
        int n2 = 0;
        for (n = 0; n < 9; ++n) {
            if (!this.getPlayer().getInventory().getStack(n).isEmpty()) continue;
            ++n2;
        }
        if (n2 >= 2) {
            return;
        }
        for (n = 0; n < 9; ++n) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(n);
            if (this.isTrashItem(itemStack) || this.neg(itemStack)) continue;
            int n3 = this.nef();
            if (n3 == -1) {
                return;
            }
            int n4 = n;
            int n5 = n3;
            this.msy.add(() -> this.ndv(n5, n4, SlotActionType.SWAP));
            return;
        }
    }

    private int nef() {
        for (int i = 9; i < 36; ++i) {
            if (!this.getPlayer().getInventory().getStack(i).isEmpty()) continue;
            return i;
        }
        return -1;
    }

    private boolean neg(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return true;
        }
        if (itemStack.getItem() == Items.GOLDEN_CARROT || mpq.ndf(itemStack) || itemStack.getItem() == Items.WATER_BUCKET) {
            return true;
        }
        return this.nel(itemStack) || this.neo(itemStack);
    }

    private PlayerEntity neh() {
        PlayerEntity playerEntity = null;
        double d = 2500.0;
        for (PlayerEntity playerEntity2 : this.getWorld().getPlayers()) {
            double d2;
            if (playerEntity2 == this.getPlayer() || !((d2 = playerEntity2.squaredDistanceTo((Entity)this.getPlayer())) < d)) continue;
            d = d2;
            playerEntity = playerEntity2;
        }
        return playerEntity;
    }

    private int nei(Item item) {
        for (int i = 0; i < 9; ++i) {
            if (this.getPlayer().getInventory().getStack(i).getItem() != item) continue;
            return i;
        }
        return -1;
    }

    private int nej() {
        for (int i = 0; i < 9; ++i) {
            if (!this.nel(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private int nek() {
        for (int i = 9; i < 36; ++i) {
            if (!this.nel(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private boolean nel(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.getItem() != Items.POTION && itemStack.getItem() != Items.SPLASH_POTION && itemStack.getItem() != Items.LINGERING_POTION) {
            return false;
        }
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.get(DataComponentTypes.POTION_CONTENTS);
        if (potionContentsComponent != null) {
            int n = 0;
            boolean bl = false;
            for (StatusEffectInstance statusEffectInstance : potionContentsComponent.getEffects()) {
                ++n;
                if (statusEffectInstance.getEffectType() != StatusEffects.INVISIBILITY) continue;
                bl = true;
            }
            if (n > 0) {
                return n == 1 && bl;
            }
        }
        String string = itemStack.getName().getString().toLowerCase();
        return string.contains(a.d("\u8af9\uf340\u7994\ue7ef\u6c34\uea89\u50de", -425032786, 1206390125));
    }

    private int nem() {
        for (int i = 0; i < 9; ++i) {
            if (!this.neo(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private int nen() {
        for (int i = 9; i < 36; ++i) {
            if (!this.neo(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private boolean neo(ItemStack itemStack) {
        String string;
        if (itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.getItem() != Items.POTION && itemStack.getItem() != Items.SPLASH_POTION && itemStack.getItem() != Items.LINGERING_POTION) {
            return false;
        }
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.get(DataComponentTypes.POTION_CONTENTS);
        if (potionContentsComponent != null) {
            int n = 0;
            boolean bl = false;
            for (StatusEffectInstance statusEffectInstance : potionContentsComponent.getEffects()) {
                ++n;
                if (statusEffectInstance.getEffectType() != StatusEffects.SPEED) continue;
                bl = true;
            }
            if (n > 0) {
                return n == 1 && bl;
            }
        }
        return (string = itemStack.getName().getString().toLowerCase()).contains(a.b("\u91d9\ue813\u62c4\ufccb\u7762\uf1ac\u4bfc", -1835756129)) || string.contains(a.c(-96193484, "\u3442\u4df0\uc736\u5947\ud291"));
    }

    private /* synthetic */ void lambda$driveTake$11(ScreenHandler screenHandler, int n, int n2, SlotActionType slotActionType) {
        this.mc.interactionManager.clickSlot(screenHandler.syncId, n, n2, slotActionType, (PlayerEntity)this.getPlayer());
    }

    private static /* synthetic */ int bbt(int n, int n2) {
        return n + n2 | 0x8658EADA;
    }

    private static /* synthetic */ int bbu(int n, int n2) {
        return mpq.bbt(n, n2) ^ 0x3AFA0D50;
    }

    private static /* synthetic */ int bbv(int n, int n2) {
        return n - n2 ^ 0x7CD1E40;
    }
}

