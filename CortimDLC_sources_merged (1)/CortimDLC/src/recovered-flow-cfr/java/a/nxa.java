/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.DeathScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityPose
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.mob.WardenEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.BannerItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ShovelItem
 *  net.minecraft.item.SmithingTemplateItem
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket
 *  net.minecraft.network.packet.s2c.play.GameMessageS2CPacket
 *  net.minecraft.network.packet.s2c.play.InventoryS2CPacket
 *  net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket
 *  net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.PlayerScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.state.property.Property
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.WorldChunk
 */
package a;

import a.efz;
import a.ign;
import a.kfa;
import a.lex;
import a.lfa;
import a.mpq;
import a.nwg;
import a.nwj;
import a.nwq;
import a.nwx;
import a.oqv;
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
import a.pte;
import a.ptr;
import a.pud;
import a.pxa;
import a.pxd;
import a.pyd;
import a.rzv;
import a.rzy;
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
import a.wcn;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BannerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.property.Property;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

public class nxa
extends pnc {
    private static final String nxb = a.c(-729813488, "\uee74\u97ca\u1d45\u8335\u08e9");
    private static final String nxc = a.d("\ub298\ucb26\u41a9\udfd9\u5404", 675656037, -668925031);
    private static final String nxd = a.c(348483266, "\u6e8e\u1718\u9dc9\u03b0");
    private static final String nxe = a.d("\ua268\udbef\u512f\ucf5c", -603660189, -1943190952);
    private static final String nxf = a.c(1809714706, "\u0e63\u77c4\ufd04\u6363\ue8b5\u6e0f");
    private static final String nxg = a.d("\uef38\u96f9\u1c5b\u8254\u09fc", -181515372, -427450136);
    private static final String nxh = a.d("\u4a34\u3384\ub953", -1746088683, -839613673);
    private static final String nxi = a.d("\u09f4\u7040\ufa9c\u64e7\uef3f", -1555736928, 226057065);
    private static final String nxj = a.d("\u8007\uf9be\u736a\ued11\u66ca\ue077\u5a20", -112699413, 802280406);
    private static final String nxk = a.b("\u63ff\u1a35\u90e2\u0eed\u8544\u038a\ub9da", 265643961);
    private static final String nxl = a.b("\uf18d\u881a\u02ef\u9ce3\u1359\u959d\u2fcd\ua632\u3869\ub6c4\u3507\ucf7c\u41d3\ud818\u5241\ud4b7\u6ef0", 2015556044);
    private static final String nxm = a.c(-1019693863, "\ub0e8\uc94e\u4393\uddec\u5631\ud081\u6aac\ue35f\u7d72\uf7b5\u7018\u8a1e\u00a6\u9d70\u1751\u91d5\u2bef\ua43c\u3a82");
    private static final String nxn = a.c(-1020520630, "\u134b\u6adf\ue003\u7e75\uf5aa\u7364\uc945\u40c4\ude97\u504a\ud386\u29f6\ua724\u3e90\ub4c0\u362c\u8c6e\u03b2\u9d1c\u1b40\u96a7\ue897\u6650\ufd8d\u7bf9");
    private static final String nxo = a.d("\u2b97\u5244\ud8e9\u4691\ucd31\u4bf9\uf1a8\u7c41\ue67f\u6cb1\ueb6d\u116d\u9fca\u0676\u8c53\u0ec9\ub48b\u3b57\ua5f9\u23a5\uae42\ud072\u5eb5\uc568\u431c", 2143303911, 888149832);
    private static final String nxp = a.d("\u302d\u49b4\uc310\u5903\ud6c9\u5070\uea24\u63df\ufd8c\u7731\uf0e6\u0a95\u843d\u1d8f\u97a6\u154f\uaf0d\u20d1\ube7f\u3823\ub5c4\ucbf4\u4533\udeee\u589a", 211270009, -1555591856);
    private static final String nxq = a.d("\u316d\u48f4\uc250\u5843\ud789\u5130\ueb64\u629f\ufccc\u7671\uf1a6\u0bd5\u857d\u1ccf\u96e6\u140f\uaa5d\u2581\ubb22\u3962\ub094\ucac2\u4473\udbb7\u5dc5\ud719\u6abc\ue4ef\u7e7d\uf841", -84916901, -451514315);
    private static final String nxr = a.c(-1303116514, "\u0112\u788b\uf22f\u683c\ue7fe\u614e\udb62\u56f8\uc8aa\u4216\uc1d8\u3ba4\ub163\u2cb3\ua694\u2069\u9a2d");
    private static final String nxs = a.c(1558973535, "\u086e\u71c2\ufb18\u651c\ueec9\u6876\ud649\u5fb5\uc1e7\u4f4b\uc895\u36f4\ubc42\u2587\uafd8\u2922");
    private static final String nxt = a.d("\u43d8\u3a4b\ub0e8\u2eed\ua53b\u2382\u9dcc\u105d\u8e0d\u04c7\u831e\u796d\uf3a6\u6a1a\ue044\u62d6\ud89f\u5735\ucd8c\u4bd1\uc222", 1766663742, -329752095);
    private static final String nxu = a.d("\ubca1\uc53d\u4bfe\ud1ee\u5a4d\udcf0\u66a8\uef5e\u7514\ufbc6\u7c60\u8612\u0cd0\u9572\u1f32\u9dde\u279c\ua835\u32f6\ub4da\u3948\u4314\ucdaa\u526d\ud410\u5ea4\ue77a\u6d37\uf3de\u75f6\ufe37\u0093\u8aa9\u1359\u9506", 736967255, -711425336);
    private static final String nxv = a.b("\u1a68\u638a\ue92d\u7349\ufc8e\u7a32\uc066\u4995\ud3d2\u5d78\udad3\u20a3\uae06\u33a7\ubde3\u3b15\u8157\u0ef4\u944a\u1212\u9f8e\ue5d2\u6b6c\uf4ab\u72d6\uf862\u41bc\ucbf1\u5518\ud330\u58f1\ua655\u2c6f\ub59f\u33c0", 500506201);
    private static final String nxw = a.c(1418924330, "\u1507\u6c9e\ue258\u784b\uf3eb\u7554\ucf09\u46f2\ud8ac\u5263\ud5b2\u2fb9\ua116\u38d9\ub286\u3475\u8e31\u01e5\u9f48\u1d0b\u90ee\ueeac\u6012\ufbbd\u7dbc\uf767\u4ac0\uc49c\u5e66\udc28\u57e4\ua94b\u230b\uba88\u3cad\ub615\u0dde\u83bb\u051c\u9cae\u1681\u6800\ue25e\u6181\uff46\u713a\uc8ee\u4226");
    private static final double nxx = 120.0;
    private static final double nxy = 100.0;
    private static final int nxz = 200;
    private static final double nya = 7.0;
    private static final int nyb = 2400;
    private static final long nyc = 6000L;
    private static final long nyd = 10000L;
    private static final double nye = 14.0;
    private static final long nyf = 240L;
    private static final int nyg = 3;
    private static final int[] nyh = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
    private static final float nyi = -55.0f;
    private static final float nyj = 86.0f;
    private static final int nyk = 3;
    private static final int nyl = 3;
    private static final int nym = 100;
    private static nxa nyn;
    private static boolean nyo;
    private final pnz nyp = new pnz();
    private final vmc nyq = this.add(new vmc(a.c(1538886874, "\u8c9d\uf500\u7fca\ue1e3\u6a77\ueccd\u5693\udf74\u412c\ucb9a"), 5.0, 1.0, 30.0, 1.0));
    private final vlj nyr = this.add(new vlj(a.c(-792673846, "\uc18f\ub81d\u32ce\uaca4\u2727\ua1da\u1b8c\u9267\u0c3f"), vlg.LOOT, ppu.WARDEN_DEFAULTS));
    private final vmc nys = this.add(new vmc(a.d("\uca9d\ub30f\u39dc\ua7b6\u2c35\uaac0\u1092\u996a\u0738\u8d91", -2103134400, -329679461), 60.0, 35.0, 200.0, 5.0).suffix(a.c(1642534583, "\u16d8\u6f77")));
    private final vkl nyt = this.add(new vkl(a.b("\ud507\uac83\u265a\ub825\u33b7\ub555\u0f05\u86e1\u18be\u920e", 578905), false));
    private final vmu nyu = this.add(new vmu(a.c(356087237, "\u759a\u0c19\u86dd\u18bf\u932d\u15dd\uaf81\u267f\ub833\u3293\ub54b\u4f2b"), a.c(961501262, "\u582a\u2194\uab1b\u356b\ubeb7"), 32));
    private final vmu nyv = this.add(new vmu(a.c(264744924, "\uaf9c\ud60e\u5cdd\uc2b7\u4934\ucfc4\u7598\ufc66\u622a\ue88a\u6f52\u9532"), a.d("\u6745\u1efb\u9474\u0a04\u81d9", 1230052507, 2120383418), 120));
    private final vlv nyw = this.add(new vlv(a.b("\u8692\uff12\u75c8\uebb0\u6072\ue6dc\u5c92\ud565\u4b6e\uc19d\u4655", -572881203), a.d("\uec25\u95b3\u1f62\u811b", -691721589, -1487681822), a.c(313494045, "\u8a51\uf3c7\u7916\ue76f"), a.b("\ub6dc\ucf5b\u459b\udbe8", -27281777)));
    private final vmu nyx = this.add(new vmu(a.d("\u2f2d\u56bb\udc6a\u4213\uc981\u4f7e\uf522\u7cdf\ue288", 1143535024, 517135068), a.d("\ubb91\uc236\u48f6\ud691\u5d47\udbfd", -692494820, 37414396), 32));
    private final vmu nyy = this.add(new vmu(a.d("\u2604\u5f83\ud543\u4b30\uc0b7\u4648\ufc14\u75e9\uebbe", 1713913152, 666442522), a.b("\u61ba\u181d\u92dd\u0cba\u876c\u01d6", 2026136011), 32));
    private final vkl nyz = this.add(new vkl(a.d("\ufd05\u848f\u0e5b\u9032\u1bb2\u9d51\u271f\uaef4\u30aa\uba0a", 1259604267, 1657533559), false));
    private final vkw nza = this.add(new vkw(a.c(1713758171, "\udf98\ua602\u2cc1\ub2b7\u397d\ubf83\u0587\u8c60\u1232\u9884\u1f55\ue523\u6bfd"), new vkq(a.b("\u0161\u78e7\uf232\u6c4f\ue785\u6122\udb35\u5285\uccd5\u466e\uc1f9\u3bdc\ub50d\u2caf\ua6f4\u2002", 1689649443), vhz.LAYERS, () -> ign.openWalk(a.d("\udc8a\ua50f\u2fdd\ub1b7\u3a58\ubcdf\u069f\u8f78\u1126\u9b9c", 228617762, 483242723)))));
    private nwx nzb = nwx.BOOT;
    private int nzc = 0;
    private int nzd = 0;
    private int nze = 0;
    private final Random nzf = new Random();
    private int nzg = 0;
    private BlockPos nzh = null;
    private final Map<BlockPos, Long> nzi = new HashMap<BlockPos, Long>();
    private final Map<BlockPos, Long> nzj = new HashMap<BlockPos, Long>();
    private final Set<BlockPos> nzk = new HashSet<BlockPos>();
    private final Map<BlockPos, Long> nzl = new HashMap<BlockPos, Long>();
    private final Map<BlockPos, Long> nzm = new HashMap<BlockPos, Long>();
    private long nzn = 0L;
    private int nzo = 0;
    private final Map<BlockPos, Integer> nzp = new HashMap<BlockPos, Integer>();
    private List<BlockPos> nzq = List.of();
    private volatile long nzr = 0L;
    private final ConcurrentLinkedQueue<String> nzs = new ConcurrentLinkedQueue();
    private rzv nzt = null;
    private BlockPos nzu = null;
    private int nzv = 99;
    private BlockPos nzw = null;
    private int nzx = 0;
    private int nzy = 0;
    private long nzz = 700L;
    private int oaa = 0;
    private BlockPos oab = null;
    private int oac = 0;
    private int oad = 0;
    private int oae = 0;
    private Vec3d oaf = null;
    private boolean oag = false;
    private boolean oah = false;
    private boolean oai = false;
    private boolean oaj = false;
    private final List<nwg> oak = new ArrayList<nwg>(List.of(nwg.FOOD, nwg.INVIS, nwg.SPEED));
    private int oal = 3;
    private BlockPos oam = null;
    private nwg oan = nwg.NONE;
    private int oao = 0;
    private int oap = 0;
    private int oaq = 0;
    private long oar = 0L;
    private int oas = 0;
    private int oat = 0;
    private boolean oau = false;
    private boolean oav = false;
    private BlockPos oaw = null;
    private int oax = 0;
    private int oay = 0;
    private nwg oaz = nwg.NONE;
    private int oba = -1;
    private BlockPos obb = null;
    private long obc = 0L;
    private long obd = 0L;
    private volatile int obe = -1;
    private boolean obf = false;
    private boolean obg = false;
    private long obh = 0L;
    private int obi = -1;
    private double obj = 88.0;
    private double obk = 84.0;
    private int obl = 0;
    private int obm = 0;
    private boolean obn = false;
    private final Map<Integer, Integer> obo = new HashMap<Integer, Integer>();
    private final Set<Integer> obp = new HashSet<Integer>();
    private pmf obq = null;
    private int obr = 0;
    private BlockPos obs = null;
    private long obt = 0L;
    private nwg obu = nwg.NONE;
    private long obv = 0L;
    private boolean obw = false;
    private boolean obx = false;
    private long oby = 0L;
    private long obz = 0L;
    private int oca = 0;
    private int ocb = 0;
    private int occ = -1;
    private int ocd = 0;
    private boolean oce = false;
    private boolean ocf = false;
    private int ocg = -1;
    private int och = 0;
    private int oci = 0;
    private boolean ocj = false;
    private int ock = 0;
    private int ocl = 0;
    private int ocm = 0;
    private float ocn = 0.0f;
    private int oco = 0;
    private int ocp = 0;
    private int ocq = -100000;
    private final Map<ItemStack, Boolean> ocr = new IdentityHashMap<ItemStack, Boolean>();
    private int ocs = -1;
    private int oct = -1;
    private int ocu = 0;
    private float ocv = 10.0f;
    private int ocw = 0;
    private int ocx = 0;
    private World ocy = null;
    private World ocz = null;
    private PlayerEntity oda = null;
    private Vec3d odb = null;
    private int odc = -1;
    private boolean odd = false;
    private int ode = -100000;
    private String odf = "";
    private int odg = 0;
    private float odh = 0.0f;
    private int odi = 0;
    private boolean odj = false;
    private int odk = 0;
    private int odl = 0;
    private int odm = -1;
    private int odn = -100000;
    private final int[] odo = new int[]{-1, -1};
    private final int[] odp = new int[2];
    private final int[] odq = new int[2];
    private final int[] odr = new int[2];
    private final int[] ods = new int[2];
    private final boolean[] odt = new boolean[2];
    private String odu = null;
    private int odv = 0;
    private String odw = "";
    private boolean odx = false;
    private boolean ody = false;
    private final Map<String, BlockPos> odz = new HashMap<String, BlockPos>();
    private final Map<String, String> oea = new HashMap<String, String>();
    private boolean oeb = false;
    private BlockPos oec = null;
    private World oed = null;
    private int oee = -100000;
    private PlayerEntity oef = null;
    private int oeg = -100000;
    private float oeh = 0.0f;
    private boolean oei = false;
    private int oej = 0;
    private int oek = -100000;
    private boolean oel = false;
    private int oem = 0;
    private int oen = 0;
    private int oeo = 40;
    private boolean oep = false;
    private Vec3d oeq = null;
    private int oer = 0;
    private int oes = 0;
    private int oet = 0;
    private BlockPos oeu = null;
    private int oev = 0;
    private int oew = 0;
    private boolean oex = false;
    private int oey = 0;
    private int oez = 1;
    private boolean ofa = false;
    private List<BlockPos> ofb = null;
    private int ofc = 0;
    private int ofd = 0;
    private final pyd ofe = new pyd();
    private psf off = null;
    private pqq ofg = null;
    private BlockPos ofh = null;
    private boolean ofi = false;
    private boolean ofj = false;
    private boolean ofk = false;
    private final double[] ofl = new double[2];
    private double ofm = Double.NaN;
    private int ofn = 0;
    private int ofo = 0;
    private final Set<Long> ofp = new HashSet<Long>();
    private BlockPos ofq = null;
    private BlockPos ofr = null;
    private final Map<BlockPos, Long> ofs = new HashMap<BlockPos, Long>();
    private BlockPos oft = null;
    private Vec3d ofu = null;
    private int ofv = 0;
    private int ofw = 0;
    private int ofx = 0;
    private int ofy = 0;
    private boolean ofz = false;
    private int oga = 0;
    private float ogb = 0.0f;
    private int ogc = 0;
    private Vec3d ogd = null;
    private boolean oge = true;
    private double ogf = Double.NaN;
    private rzy ogg;
    private int ogh = 0;
    private int ogi = 0;
    private long ogj = 0L;
    private long ogk = 0L;
    private final pjw ogl = new pjw().neuro(lex.WARDEN);
    private final pud ogm = pud.INSTANCE;
    private boolean ogn = false;
    private boolean ogo = false;
    private boolean ogp = false;
    private boolean ogq = false;
    private boolean ogr = false;
    private float ogs = 0.0f;
    private float ogt = 0.0f;
    private double ogu = 0.0;
    private float ogv = 0.0f;
    private float ogw = 0.0f;
    private PlayerEntity ogx = null;
    private Vec3d ogy = null;
    private BlockPos ogz = null;
    private Vec3d oha = null;
    private boolean ohb = false;
    private boolean ohc = false;
    private int ohd = 0;
    private int ohe = 0;
    private double ohf = 0.0;
    private double ohg = 0.0;
    private double ohh = 0.0;
    private int ohi = 0;
    private int ohj = 0;
    private boolean ohk = false;
    private int ohl = -1000;
    private float ohm = 0.0f;
    private boolean ohn = false;
    private boolean oho = false;
    private boolean ohp = false;
    private boolean ohq = false;
    private static /* synthetic */ long ohr;
    private static /* synthetic */ int ohs;

    public nxa() {
        super(a.d("\u3975\u40f0\uca22\u5448\udfa7\u5920\ue360\u6a87\uf4d9\u7e63", 860443421, -1714984413), a.b("\u0734\u7ea6\uf475\u6a1f\ue1cf\u672d\udd2a\u54c7\uca95\u4061\uc7c5\u3d82\ub346\u2ae1\ua0b3\u2649\u9c48\u13cd\u8965\u0f2c\u86c2\ufcdd\u722d\ue9f7\u6f85\ue542\u5cf6\ud2a0\u4804\uce17\u45bf\ubb37\u312c\ua8c0\u2e97\ua42e\u1bee\u919e", -2026633378), kfa.PLAYER);
        this.nyy.visibleWhen(() -> a.d("\u4bd2\u3255\ub895\u26e6", -1652830312, 1921811481).equals(this.nyw.get()));
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    public static nxa mainInstance() {
        return nyn;
    }

    public void registerAsMain() {
        nyn = this;
        if (!nyo) {
            nyo = true;
            wcn.listen(packet -> {
                nxa nxa2 = nyn;
                if (nxa2 != null && nxa2.isEnabled() && !nxa2.isBotInstance()) {
                    nxa2.onPacket((Packet<?>)packet);
                }
            });
        }
    }

    @Override
    public void attachBot(efz efz2) {
        super.attachBot(efz2);
        this.ogg = new rzy(false);
    }

    public boolean ownsContainer() {
        return this.oaz != nwg.NONE;
    }

    public void copySettingsFrom(nxa nxa2) {
        if (nxa2 == null || nxa2 == this) {
            return;
        }
        this.nyq.set(nxa2.nyq.get());
        this.nyr.set(nxa2.nyr.ids());
        this.nys.set(nxa2.nys.get());
        this.nyt.set(nxa2.nyt.get());
        this.nyu.set(nxa2.nyu.get());
        this.nyv.set(nxa2.nyv.get());
        this.nyw.set(nxa2.nyw.get());
        this.nyx.set(nxa2.nyx.get());
        this.nyy.set(nxa2.nyy.get());
    }

    public vmo[] botSettings() {
        return new vmo[]{this.nyu, this.nyv, this.nyw, this.nyx, this.nyy, this.nyq, this.nys, this.nyt};
    }

    public vlj lootList() {
        nxa nxa2 = nyn;
        return this.driver != null && nxa2 != null && nxa2 != this ? nxa2.nyr : this.nyr;
    }

    private boolean oht(ItemStack itemStack) {
        Boolean bl;
        if (itemStack.isEmpty()) {
            return false;
        }
        vlj vlj2 = this.lootList();
        if (this.ocs != this.nzd || this.oct != vlj2.version() || this.ocr.size() > 256) {
            this.ocr.clear();
            this.ocs = this.nzd;
            this.oct = vlj2.version();
        }
        if ((bl = this.ocr.get(itemStack)) == null) {
            bl = ppu.picked(itemStack, vlj2.ids());
            this.ocr.put(itemStack, bl);
        }
        return bl;
    }

    public String queueNote() {
        return this.odf;
    }

    private Object ohu() {
        return this.driver != null ? this.driver : pjd.MAIN;
    }

    public void onBotSettingChanged() {
    }

    public void setLootStart(int n) {
        this.nze = Math.max(0, n);
    }

    public String getCurrentLootAnarchy() {
        return this.olr();
    }

    public int getStateIndex() {
        return this.nzb == null ? 0 : this.nzb.ordinal();
    }

    public tvz walkBrain() {
        return this.ofe.brain();
    }

    public List<BlockPos> getBotPath() {
        return this.ofb;
    }

    public int getBotPathIndex() {
        return this.ofc;
    }

    public BlockPos getBotTarget() {
        if (this.nzu != null) {
            return this.nzu;
        }
        if (this.oam != null) {
            return this.oam;
        }
        return this.oab;
    }

    public int getTripChests() {
        return this.nzg;
    }

    public int getMaxChests() {
        return this.nyq.getInt();
    }

    public int getTotalChests() {
        return this.ogh;
    }

    public int getTotalTrips() {
        return this.ogi;
    }

    public long getFarmMillis() {
        return this.ogj;
    }

    public void resetFarmStats() {
        this.ogh = 0;
        this.ogi = 0;
        this.ogj = 0L;
    }

    public boolean wantsBotFrame() {
        if (!this.isEnabled()) {
            return false;
        }
        if (this.oaz != nwg.NONE || this.obw) {
            return true;
        }
        this.obv = System.currentTimeMillis();
        return false;
    }

    public void onBotFrame() {
        long l;
        if (!this.isEnabled() || this.isNotInWorld()) {
            return;
        }
        this.obv = l = System.currentTimeMillis();
        this.ojk(l);
        this.okg(l);
    }

    public static void onFrame() {
        long l;
        nxa nxa2 = nyn;
        if (nxa2 == null || !nxa2.isEnabled() || nxa2.isBotInstance() || nxa2.isNotInWorld()) {
            return;
        }
        nxa2.obv = l = System.currentTimeMillis();
        if (nxa2.oaz != nwg.NONE || nxa2.obw) {
            nxa2.ojk(l);
            nxa2.okg(l);
        }
    }

    @Override
    protected void onEnable() {
        if (this.getPlayer() != null) {
            this.oeh = this.getPlayer().getHealth();
        }
        if (this.driver == null) {
            try {
                mpq mpq2 = Flow.getInstance().getModuleManager().get(mpq.class);
                if (mpq2 != null && mpq2.isEnabled() && !mpq2.isBotInstance()) {
                    mpq2.setEnabled(false);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        this.ogk = 0L;
        this.ooi();
        this.ofp.clear();
        this.ofm = Double.NaN;
        this.ofn = 0;
        this.nyp.reset();
        this.odv = 0;
        this.odx = false;
        this.ody = false;
        this.oee = -100000;
        this.oef = null;
        this.ohv();
        this.ohw();
        this.ohy(nwx.BOOT);
        this.nzc = 10;
    }

    @Override
    protected void onDisable() {
        this.ohv();
        this.ooj();
        if (this.driver == null) {
            pnf.clear();
        }
        pjd.cancel(this.ohu());
        this.odf = "";
    }

    private void ohv() {
        this.ohy(nwx.RESTOCK);
        this.ohx();
        this.oab = null;
        this.ofb = null;
        this.ofc = 0;
        this.off = null;
        this.ofe.reset();
        this.ofd = 0;
        this.oao = 0;
        this.oaa = 0;
        this.oac = 0;
        this.oam = null;
        this.oan = nwg.NONE;
        this.oap = 0;
        this.oaq = 0;
        this.oas = 0;
        this.oau = false;
        this.oav = false;
        this.oaw = null;
        this.oay = 0;
        this.oeu = null;
        this.oev = 0;
        this.oew = 0;
        this.oey = 0;
        this.oet = 0;
        this.opg();
        this.oer = 0;
        this.oeq = null;
        this.oel = false;
        this.oem = 0;
        this.odg = 0;
        this.odi = 0;
        this.odj = false;
        this.odk = 0;
        this.odl = 0;
        this.odm = -1;
        this.odp[0] = 0;
        this.odp[1] = 0;
        this.oei = false;
        this.oej = 0;
        this.oad = 0;
        this.oae = 0;
        this.ohi = 0;
        this.ohj = 1200 + this.nzf.nextInt(3000);
        this.oha = null;
        this.ohb = false;
        this.ohc = false;
        this.ohd = 0;
        this.ogu = 0.0;
        this.ogz = null;
        this.obs = null;
        this.obu = nwg.NONE;
        this.oce = false;
        this.ocd = 0;
        this.oka();
        this.okh();
        this.oku();
        this.oci = 0;
        this.ocn = 0.0f;
        this.oco = 0;
        this.ocq = -100000;
        this.ocu = 0;
        this.ocx = 0;
        this.nzs.clear();
        if (this.mc.interactionManager != null) {
            this.mc.interactionManager.cancelBlockBreaking();
        }
        ptr.clear();
        this.oje();
    }

    private void ohw() {
        this.nzg = 0;
        this.nzh = null;
        this.nzi.clear();
        this.nzj.clear();
        this.nzk.clear();
        this.nzl.clear();
        this.nzm.clear();
        this.ofs.clear();
        this.nzp.clear();
        this.nzq = List.of();
        this.oag = false;
        this.oah = false;
        this.oai = false;
        this.oaj = false;
        this.odu = null;
        for (int i = 0; i < 2; ++i) {
            this.odt[i] = false;
            this.ods[i] = 0;
        }
        this.olm();
    }

    private void ohx() {
        this.nzt = null;
        this.nzu = null;
        this.nzv = 99;
        this.nzw = null;
        this.nzx = 0;
        this.nzy = 0;
        this.ohb = false;
    }

    private void ohy(nwx nwx2) {
        if (this.nzb != nwx2) {
            this.odf = "";
        }
        this.nzb = nwx2;
    }

    private rzy ohz() {
        if (this.driver != null) {
            return this.ogg;
        }
        try {
            return Flow.getInstance().getModuleManager().get(rzy.class);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private void oia() {
        rzy rzy2 = this.ohz();
        if (rzy2 != null) {
            rzy2.clearTimers();
        }
    }

    public void onPacket(Packet<?> packet) {
        Object object;
        InventoryS2CPacket inventoryS2CPacket;
        if (packet instanceof InventoryS2CPacket && (inventoryS2CPacket = (InventoryS2CPacket)packet).syncId() != 0) {
            this.obe = inventoryS2CPacket.syncId();
            return;
        }
        if (packet instanceof GameMessageS2CPacket) {
            inventoryS2CPacket = (GameMessageS2CPacket)packet;
            if (this.nzs.size() < 64) {
                this.nzs.add(inventoryS2CPacket.content().getString());
            }
            return;
        }
        inventoryS2CPacket = null;
        if (packet instanceof PlaySoundS2CPacket) {
            object = (PlaySoundS2CPacket)packet;
            inventoryS2CPacket = object.getSound();
        } else if (packet instanceof PlaySoundFromEntityS2CPacket) {
            PlaySoundFromEntityS2CPacket playSoundFromEntityS2CPacket = (PlaySoundFromEntityS2CPacket)packet;
            inventoryS2CPacket = playSoundFromEntityS2CPacket.getSound();
        }
        if (inventoryS2CPacket != null) {
            try {
                object = ((SoundEvent)inventoryS2CPacket.value()).id().getPath();
                if (((String)object).contains(a.d("\u6eac\u170b\u9dcb\u03ac\u887a\u0ec0\ub4d3\u3d7e\ua33c\u2983\uae43", 1977503822, 657604254)) || ((String)object).contains(a.d("\u0fb0\u7617\ufcd7\u62b0\ue966\u6fdc\ud5cf\u5c71\uc221\u4899\ucf5f\u3525", 1667287867, 1060553968)) || ((String)object).contains(a.c(-1113763147, "\u52ce\u2b69\ua1a9\u3fce\ub418\u32a2\u88b1\u011d\u9f5e\u15ee\u923a\u6841"))) {
                    this.nzr = System.currentTimeMillis();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        rzy rzy2;
        if (this.mc.options == null) {
            return;
        }
        this.mc.options.attackKey.setPressed(this.oho);
        this.mc.options.useKey.setPressed(this.ohp);
        while (this.mc.options.attackKey.wasPressed()) {
        }
        while (this.mc.options.useKey.wasPressed()) {
        }
        if (this.obw || this.oaz != nwg.NONE) {
            this.silenceMovement();
        }
        if ((rzy2 = this.ohz()) != null && !rzy2.isEnabled() && !this.isNotInWorld()) {
            rzy2.tickTimers(false);
        }
        if (this.mc.player != null && this.mc.world != null) {
            if (this.driver == null) {
                wcn.ensure(this.mc);
                if (!this.ohq && this.ohn && this.ogn && !this.obw && this.oaz == nwg.NONE) {
                    this.ogm.remapHumanKeys(this.mc, this.ogm.cameraYaw(this.mc.player), this.ogv);
                }
            }
            ptr.applyOwn(this.mc);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        boolean bl;
        block14: {
            ++this.nzd;
            if (this.isNotInWorld()) {
                this.ogk = 0L;
                this.oig();
                return;
            }
            if (this.odx) {
                this.odx = false;
                pqf.resetKeys();
                if (this.driver != null) {
                    this.setBotRunning(false);
                    this.driver.halted();
                } else {
                    this.setEnabled(false);
                }
                return;
            }
            long l = System.currentTimeMillis();
            if (this.ogk != 0L) {
                this.ogj += Math.min(2000L, Math.max(0L, l - this.ogk));
            }
            this.ogk = l;
            pjd.keep(this.ohu());
            this.ook();
            this.ohm = this.getPlayer().getYaw();
            this.ohn = true;
            this.ofe.beginTick();
            bl = this.oib();
            if (bl && this.mc.options != null) {
                this.ofi = this.mc.options.sprintKey.isPressed();
                this.ofj = this.mc.options.sneakKey.isPressed();
            }
            try {
                this.oih();
                if (bl) {
                    this.oif();
                }
                this.oox();
                this.ofz = this.ohq;
                if (!this.obw && this.oaz == nwg.NONE || this.mc.options == null) break block14;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.oif();
                }
                this.oox();
                this.ofz = this.ohq;
                if ((this.obw || this.oaz != nwg.NONE) && this.mc.options != null) {
                    this.mc.options.attackKey.setPressed(false);
                    this.mc.options.useKey.setPressed(false);
                }
                this.ojd();
                this.oho = this.mc.options != null && this.mc.options.attackKey.isPressed();
                boolean bl2 = this.ohp = this.mc.options != null && this.mc.options.useKey.isPressed();
                if (this.driver == null) {
                    pnf.publish(this.ofe.shown(), this.ofe.shownAt(), bl, bl && this.oic(), this.nyz.get(), this.getName());
                }
                throw throwable;
            }
            this.mc.options.attackKey.setPressed(false);
            this.mc.options.useKey.setPressed(false);
        }
        this.ojd();
        this.oho = this.mc.options != null && this.mc.options.attackKey.isPressed();
        boolean bl3 = this.ohp = this.mc.options != null && this.mc.options.useKey.isPressed();
        if (this.driver == null) {
            pnf.publish(this.ofe.shown(), this.ofe.shownAt(), bl, bl && this.oic(), this.nyz.get(), this.getName());
        }
        long l = System.currentTimeMillis();
        if (l - this.obv > 80L) {
            this.ojk(l);
            this.okg(l);
        }
    }

    private boolean oib() {
        return this.driver == null && nyn == this && this.isEnabled() && tcz.walkGuide();
    }

    private boolean oic() {
        return this.ofk || this.getPlayer().isUsingItem() || this.obw || this.ocf || this.oaz != nwg.NONE || this.mc.currentScreen != null;
    }

    private int oid(int n) {
        return this.oib() ? n * 3 : n;
    }

    private txs oie() {
        return lfa.walkModel(lex.WARDEN);
    }

    private void oif() {
        KeyBinding[] keyBindingArray;
        GameOptions gameOptions = this.mc.options;
        if (gameOptions == null || this.obw || this.oaz != nwg.NONE || this.ocf) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey}) {
            keyBinding.setPressed(this.heldByHuman(keyBinding));
        }
        if (((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            if (gameOptions.sprintKey.isPressed() != this.ofi) {
                gameOptions.sprintKey.setPressed(true);
            }
        } else {
            gameOptions.sprintKey.setPressed(this.heldByHuman(gameOptions.sprintKey));
        }
        if (((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
            if (gameOptions.sneakKey.isPressed() != this.ofj) {
                gameOptions.sneakKey.setPressed(true);
            }
        } else {
            gameOptions.sneakKey.setPressed(this.heldByHuman(gameOptions.sneakKey));
        }
    }

    private void oig() {
        if (this.ogn) {
            this.ogn = false;
            if (this.driver == null) {
                this.ogm.reset();
            }
        }
        this.ogx = null;
        this.ogy = null;
        this.ohn = false;
        this.oho = false;
        this.ohp = false;
        ptr.clear();
        this.oka();
        this.obw = false;
        this.obx = false;
        this.ocf = false;
        this.oku();
        this.obs = null;
        this.nzp.clear();
        this.nzq = List.of();
        this.ofs.clear();
        this.opg();
    }

    private void oih() {
        WardenEntity wardenEntity;
        boolean bl;
        long l = System.currentTimeMillis();
        this.oha = null;
        this.ohq = false;
        this.ofa = false;
        this.ohk = false;
        if (this.oga <= 0 && this.mc.options.backKey.isPressed() && !this.heldByHuman(this.mc.options.backKey)) {
            this.mc.options.backKey.setPressed(false);
        }
        if (this.ofd > 0) {
            --this.ofd;
        }
        if (this.oci > 0) {
            --this.oci;
        }
        if (this.oao > 0) {
            --this.oao;
        }
        if (this.oac > 0) {
            --this.oac;
        }
        if (this.nzo > 0) {
            --this.nzo;
        }
        if (this.oaa > 0) {
            --this.oaa;
        }
        if (this.ocd > 0) {
            --this.ocd;
        }
        if (this.odl > 0) {
            --this.odl;
        }
        if (this.oco > 0) {
            --this.oco;
        }
        this.ocn *= 0.99f;
        int n = this.oqk();
        if (n > this.ocp && this.nzd - this.ocq < 200 && this.oaz == nwg.NONE) {
            this.oco = 600;
        }
        this.ocp = n;
        this.onr();
        this.oin();
        this.oim();
        this.oio();
        this.okz();
        if (this.oiq()) {
            pqf.resetKeys();
            return;
        }
        if (this.oel) {
            pqf.resetKeys();
            if (++this.oem >= 40 && !this.getPlayer().isDead()) {
                this.ohv();
                this.ohy(nwx.TELEPORT_TO_SAVE);
            }
            return;
        }
        if (this.nzb != nwx.TELEPORT_TO_SAVE && this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nyp.check((PlayerEntity)this.getPlayer(), System.currentTimeMillis(), 6000L)) {
            pqf.resetKeys();
            pjd.leave(this.ohu());
            this.ohv();
            this.ohw();
            this.ohy(nwx.TELEPORT_TO_SAVE);
            this.notifyUser(a.c(1752946124, "\ud1f6\uac75\u22bd\ubcc9\u3711\ub1a0\u0bfa\u8613\u1844\u96e7\u1130\ueb43\u6597\ufc29\u760b\uf49b\u4ac6\uc105\u5fd7\ud9fc\u500e\u2a23\ua4e2\u3f46\ubd55\u378d\uae0ao\u9e80\u18dd\u9319\u69ab\ue7f9\u7e05\ufc46\u7296\ucd35\u4748\uc190\u5c33") + nxa.ols(this.nyu.get(), a.b("\u99d0\ue06e\u6ae1\uf491\u7f4d", 1362270644)), false);
            return;
        }
        if (this.nzb == nwx.BOOT) {
            pqf.resetKeys();
            this.oot();
            if (--this.nzc <= 0) {
                this.oii();
            }
            return;
        }
        if (this.oir()) {
            return;
        }
        boolean bl2 = bl = this.nzb != nwx.WARPING_TO_LOOT_BASE && this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nzb != nwx.LOOTING;
        if (!this.oib()) {
            this.oiu(bl);
            this.ois(bl);
        }
        int n2 = this.ocu = pqf.onClimbable((PlayerEntity)this.getPlayer()) ? this.ocu + 1 : 0;
        if (this.mc.currentScreen instanceof AbstractSignEditScreen) {
            this.mc.currentScreen.close();
            return;
        }
        if (this.oaz == nwg.NONE && this.oil() && !this.ojh(l)) {
            this.olh();
            this.mc.player.closeHandledScreen();
            return;
        }
        if (this.oaz != nwg.NONE) {
            pqf.resetKeys();
            this.oot();
            this.olh();
            return;
        }
        if (this.nzb == nwx.LOOTING) {
            this.ohy(nwx.EXPLORING);
        }
        this.mc.options.sneakKey.setPressed(this.mc.options.useKey.isPressed() && this.oli(this.getPlayer().getMainHandStack()) && !this.opb());
        if (this.getPlayer().getHealth() <= 0.0f || this.getPlayer().isDead()) {
            this.oip();
            return;
        }
        if (this.oej > 0) {
            --this.oej;
        }
        if (this.getPlayer().fallDistance > 3.0) {
            this.oei = true;
        } else if (this.oei) {
            this.oei = false;
            this.oej = 6;
        }
        float f = this.getPlayer().getHealth();
        if (f < this.oeh && this.oej <= 0 && this.oik() && this.nzb != nwx.ESCAPING) {
            wardenEntity = this.onu(20.0);
            PlayerEntity playerEntity = this.ooh();
            this.ooa(wardenEntity != null && (playerEntity == null || wardenEntity.squaredDistanceTo((Entity)this.getPlayer()) < playerEntity.squaredDistanceTo((Entity)this.getPlayer())));
        }
        this.oeh = f;
        if (this.omp()) {
            this.oek = this.nzd;
        }
        if (!this.odj && !this.mc.options.useKey.isPressed()) {
            this.okd(l);
            if (!(this.ocg != -1 || this.obw || this.ocf || this.nzb == nwx.ESCAPING || (wardenEntity = this.getPlayer().getMainHandStack()).isEmpty() || this.oqd((ItemStack)wardenEntity))) {
                this.olj();
            }
        } else {
            this.oku();
        }
        if (this.obw) {
            pqf.resetKeys();
            this.oot();
            return;
        }
        this.okp();
        if (this.okx()) {
            return;
        }
        if (this.nzb != nwx.ESCAPING && !this.ond(l)) {
            if (this.olc()) {
                this.ole();
                return;
            }
        } else if (this.odg != 0) {
            this.olf();
        }
        if (this.oik() && this.nzb != nwx.ESCAPING && this.onx()) {
            this.notifyUser(a.d("\u6c2c\u15bf\u9f1c\u0119\u8acf\u0c76\ub238\u3fa9\ua1f9\u2b33\uacea\u5699\udc52\u45ee\ucfb0\u4d22\uf76b\u78c1\ue278\u6425\uedd6", -488738214, -1879565711), false);
        }
        if (bl && !this.oib()) {
            this.oiz();
        }
        if (this.oga > 0 && bl && !this.oib()) {
            --this.oga;
            this.oja();
            this.oot();
            return;
        }
        if ((this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST) && this.nzo <= 0) {
            this.nzo = 5;
            this.omy(l);
        }
        switch (this.nzb.ordinal()) {
            case 1: {
                this.olk(l);
                break;
            }
            case 2: {
                this.olx();
                break;
            }
            case 3: {
                this.olz();
                break;
            }
            case 4: {
                this.omq(l);
                break;
            }
            case 5: {
                this.one(l);
                break;
            }
            case 7: {
                this.oob();
                break;
            }
            case 8: {
                this.oof();
                break;
            }
            case 9: {
                this.omm();
                break;
            }
            case 10: {
                this.omn();
                break;
            }
        }
        if (!this.oib()) {
            this.ojc(bl);
        }
    }

    private void oii() {
        BlockPos blockPos = this.getPlayer().getBlockPos();
        rzy rzy2 = this.ohz();
        String string = this.oij();
        if (rzy2 != null) {
            for (rzv rzv2 : rzy2.getCachedTimers()) {
                if (!string.equals(rzv2.dimension) || !(rzv2.pos.squaredDistanceTo(this.getPlayer().getEntityPos()) < 6400.0)) continue;
                this.nzh = blockPos;
                pjd.at(this.ohu(), this.olr());
                this.ohy(nwx.EXPLORING);
                return;
            }
        }
        if (this.olp(a.d("\u211d\u58dc\ud27e\u4c71\uc7d9", -533521177, 38091198)) != null) {
            pjd.at(this.ohu(), nxa.ols(this.nyu.get(), a.c(-1538227089, "\u840b\ufdb5\u773a\ue94a\u6296")));
            this.ohy(nwx.RESTOCK);
            return;
        }
        this.ohy(nwx.TELEPORT_TO_SAVE);
    }

    private String oij() {
        return this.mc.world == null ? "" : this.mc.world.getRegistryKey().getValue().toString();
    }

    private boolean oik() {
        return this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST || this.nzb == nwx.CHECK_PVP_COOLDOWN || this.nzb == nwx.ESCAPING || this.nzb == nwx.LOOTING || this.nzb == nwx.TELEPORT_TO_SAVE && this.nzh != null && !this.odf.isEmpty();
    }

    private boolean oil() {
        HandledScreen handledScreen;
        Screen screen = this.mc.currentScreen;
        return screen instanceof HandledScreen && !((handledScreen = (HandledScreen)screen) instanceof InventoryScreen) && !(handledScreen.getScreenHandler() instanceof PlayerScreenHandler);
    }

    private void oim() {
        String string;
        while ((string = this.nzs.poll()) != null) {
            boolean bl;
            int n;
            String string2 = string.toLowerCase();
            for (n = 0; n < string2.length() && !Character.isLetter(string2.charAt(n)); ++n) {
            }
            if ((string2 = string2.substring(n)).startsWith(a.d("\u4cd2\u3562\ubfb3\u21b1\uaa14\u2ca0\u96f7", -1917657672, 424908114)) || string2.startsWith(a.d("\u5ef4\u2744\uad95\u3397\ub832\u3e8b\u84d1", -269654129, 1642937667)) || string2.startsWith(a.b("\ue940\u9088\u1e30\u845e\u0f88\u8934\u336c\uba94\u24c1\uae73", -1169953416)) || string2.startsWith(a.d("\u6c14\u15d8\u9f02\u0106\u8ad3\u0c6c\ub253\u3fbf\ua1ed\u2f4c\uac85\u56f0\ud827\u41e8\ucbcf\u4d32\uf778\u78a4\ue265\u6446\uedc4", 1234580538, -395551622))) {
                this.oee = this.nzd;
            }
            boolean bl2 = bl = string2.contains(a.b("\u62f0\u1b34\u91e4", -693344592)) && (string2.contains(a.c(904261579, "\ueb8c\u9249\u18ef\u86ec\u0d3c\u8bf8")) || string2.contains(a.c(1475068875, "\uc7f3\ube43\u349a\uaae5\u2133\ua7f7\u1dad")) || string2.contains(a.b("\u1899\u6125\ueb83\u7589\ufe54\u78e9\uc2c0", 959782051))) || string2.contains(a.c(778730326, "\u7b26\u029a\u8857\u1631\u9de2\u1b56\ua118\u28b0\ub6ac\u3c11\ubbc3\u41b2\ucf6e\u56d9\udc9d\u5a7d\ue033"));
            if (this.nzb == nwx.WARPING_TO_LOOT_BASE && !this.oau && bl) {
                this.odd = true;
            }
            if (!bl || this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nzb != nwx.TELEPORT_TO_SAVE) continue;
            this.nyp.dismiss(this.getWorld());
        }
    }

    private void oin() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (clientPlayerEntity != this.oef) {
            this.oeg = this.nzd;
        }
        this.oef = clientPlayerEntity;
    }

    private void oio() {
        boolean bl;
        if (this.nzd - this.oee > 100) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        boolean bl2 = clientPlayerEntity.isDead() || clientPlayerEntity.getHealth() <= 0.0f;
        boolean bl3 = this.nzb == nwx.TELEPORT_TO_LOOT || this.nzb == nwx.TELEPORT_TO_SAVE || this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.WARPING_TO_LOOT_BASE && (this.odc < 0 || this.oas - this.odc < 100);
        boolean bl4 = bl = !bl3 && this.oeg >= this.oee - 100;
        if (bl2 || bl) {
            this.oee = -100000;
            this.oip();
        }
    }

    private void oip() {
        if (this.oel) {
            return;
        }
        this.oel = true;
        this.oem = 0;
        ++this.nze;
        this.oka();
        this.okh();
        this.olh();
        this.notifyUser(a.c(1582595820, "\u7add\u0371\u89ab\u17af\u9c7a\u1ac5\ua4fa\u2d06\ub354\u3df8\uba26\u4447\ucef1\u5734\udd6b\u5b91"), false);
    }

    private boolean oiq() {
        if (!(this.mc.currentScreen instanceof DeathScreen)) {
            this.oen = 0;
            this.oep = false;
            this.oeo = 26 + this.nzf.nextInt(34);
            return false;
        }
        this.oip();
        if (++this.oen >= this.oeo && !this.oep && this.mc.player != null) {
            this.mc.player.requestRespawn();
            this.oep = true;
        }
        return true;
    }

    private boolean oir() {
        if (this.oes > 0) {
            --this.oes;
        }
        Vec3d vec3d = this.getPlayer().getEntityPos();
        if (this.oeq == null || vec3d.squaredDistanceTo(this.oeq) > 2.25) {
            this.oeq = vec3d;
            this.oer = 0;
            return false;
        }
        ++this.oer;
        if (this.nzb == nwx.RESTOCK && this.ody) {
            this.oer = 0;
            return false;
        }
        if (this.oer < 2400 || this.oes > 0) {
            return false;
        }
        pqf.resetKeys();
        this.olh();
        if (this.mc.player != null && this.mc.currentScreen != null) {
            this.mc.player.closeHandledScreen();
        }
        if (this.nzg == 0 && this.nzb != nwx.TELEPORT_TO_SAVE && this.nzb != nwx.TELEPORT_TO_LOOT) {
            this.omd(wap.s(a.d("\uf5e1\u8c57\u069f\u98ee\u1332\u95c7\u2fc7\ua631\u3873\ub2c7\u3514\ucf29\u41b8\ud800\u524e\ud4ed\u6eb0\ue173\u7b8d\ufdd8\u7428\u0e62\u80d0\u1b10\u9d79", -1879600606, 1028941737), a.c(27431981, "\u907b\ue9c9\u6366\ufd66\u76c5\uf46f\u4a21\uc3dd\u5992\ud73f\u50e5\uaae0\u2434\ubdf2\u33b4\ub557\u0f0a\u84c7\u1e70\u9824\u11ad\u6bfd\ue547")));
            if (this.ome()) {
                return true;
            }
        }
        this.ohv();
        this.oeq = vec3d;
        this.oes = 600;
        this.ohy(nwx.TELEPORT_TO_SAVE);
        return true;
    }

    private void ois(boolean bl) {
        boolean bl2 = bl && this.ofz && this.ohi <= 0 && !this.obw && this.oga <= 0;
        Vec3d vec3d = this.getPlayer().getEntityPos();
        if (!bl2) {
            this.ofu = null;
            this.ofv = 0;
            return;
        }
        if (this.ofu == null || nxa.oit(vec3d, this.ofu) > 0.9) {
            this.ofu = vec3d;
            this.ofv = 0;
            return;
        }
        if (++this.ofv >= 28) {
            this.ofu = vec3d;
            this.ofv = 0;
            this.oiv(false);
        }
    }

    private static double oit(Vec3d vec3d, Vec3d vec3d2) {
        return Math.hypot(vec3d.x - vec3d2.x, vec3d.z - vec3d2.z);
    }

    private void oiu(boolean bl) {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        boolean bl2 = clientPlayerEntity.isOnGround();
        if (bl2 || Double.isNaN(this.ogf)) {
            this.ogf = clientPlayerEntity.getY();
        }
        if (this.oge && !bl2 && clientPlayerEntity.getVelocity().y > 0.2) {
            this.ogd = clientPlayerEntity.getEntityPos();
        } else if (!this.oge && bl2 && this.ogd != null) {
            double d = nxa.oit(clientPlayerEntity.getEntityPos(), this.ogd);
            double d2 = clientPlayerEntity.getY() - this.ogd.y;
            this.ogd = null;
            if (bl && this.ofz && d < 0.55 && d2 < 0.3) {
                if (++this.ogc >= 2) {
                    this.ogc = 0;
                    this.oiv(true);
                }
            } else {
                this.ogc = 0;
            }
        }
        this.oge = bl2;
    }

    private void oiv(boolean bl) {
        BlockPos blockPos;
        ++this.oet;
        this.ofy = 0;
        BlockPos blockPos2 = blockPos = this.opb() ? this.ofb.get(this.ofc) : null;
        if (blockPos != null && this.opp(blockPos) < 6.25 && !blockPos.equals((Object)this.ofq) && (bl || blockPos.equals((Object)this.oft))) {
            this.oiw(blockPos, 30000L);
        }
        this.oft = blockPos;
        this.oiy();
        this.ofb = null;
        this.ofc = 0;
        this.ofd = 0;
        this.oey = 0;
        if (this.oet >= 4) {
            this.oet = 0;
            this.ojb();
        }
    }

    private void oiw(BlockPos blockPos, long l) {
        if (this.ofs.size() > 256) {
            this.ofs.clear();
        }
        this.ofs.put(blockPos.toImmutable(), System.currentTimeMillis() + l);
    }

    private Set<BlockPos> oix() {
        if (this.ofs.isEmpty()) {
            return Set.of();
        }
        long l = System.currentTimeMillis();
        this.ofs.values().removeIf(l2 -> l2 <= l);
        return this.ofs.isEmpty() ? Set.of() : new HashSet<BlockPos>(this.ofs.keySet());
    }

    private void oiy() {
        this.oga = 0;
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (clientPlayerEntity == null || !clientPlayerEntity.isOnGround()) {
            return;
        }
        float f = this.oow();
        float[] fArray = new float[]{180.0f, 135.0f, -135.0f, 90.0f, -90.0f};
        int n = this.nzf.nextBoolean() ? 1 : 2;
        for (int i = 0; i < fArray.length; ++i) {
            int n2 = i == 0 ? 0 : (i == 1 ? n : (i == 2 ? 3 - n : i));
            float f2 = f + fArray[n2];
            pxa pxa2 = pxd.run((PlayerEntity)clientPlayerEntity, f2, false, false, 8);
            if (!(pxa2.progress > 0.35) || !(pxa2.endY > clientPlayerEntity.getY() - 0.7) || pxa2.blockedWithin(2)) continue;
            this.ogb = f2;
            this.oga = 5 + this.nzf.nextInt(6);
            return;
        }
    }

    private void oiz() {
        if (this.ocu < 6 || this.oga > 0) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (this.opb() && pqf.getStandY(this.ofb.get(this.ofc)) > clientPlayerEntity.getY() + 0.6) {
            return;
        }
        if (this.ocu > 200) {
            this.ocu = 0;
            this.oiv(false);
        }
        BlockPos blockPos = clientPlayerEntity.getBlockPos();
        this.oiw(blockPos, 30000L);
        this.oiw(blockPos.down(), 30000L);
        this.ofb = null;
        this.ofc = 0;
        this.ofd = 0;
        Vec3d vec3d = pqf.awayFromClimbable((PlayerEntity)clientPlayerEntity);
        this.ogb = vec3d != null ? (float)Math.toDegrees(Math.atan2(-vec3d.x, vec3d.z)) : this.oow() + 180.0f;
        this.oga = 6 + this.nzf.nextInt(5);
    }

    private void oja() {
        float f = -1.0f;
        float f2 = 0.0f;
        float f3 = Float.MAX_VALUE;
        for (float f4 = -1.0f; f4 <= 1.0f; f4 += 1.0f) {
            for (float f5 = -1.0f; f5 <= 1.0f; f5 += 1.0f) {
                double d;
                float f6;
                if (f4 == 0.0f && f5 == 0.0f || !((f6 = Math.abs(MathHelper.wrapDegrees((float)((float)(d = Math.toDegrees(pud.inputDirection(this.ogv, f4, f5))) - this.ogb)))) < f3)) continue;
                f3 = f6;
                f = f4;
                f2 = f5;
            }
        }
        this.ohq = true;
        this.ofa = true;
        this.mc.options.forwardKey.setPressed(f > 0.0f);
        this.mc.options.backKey.setPressed(f < 0.0f);
        this.mc.options.leftKey.setPressed(f2 > 0.0f);
        this.mc.options.rightKey.setPressed(f2 < 0.0f);
        this.mc.options.sprintKey.setPressed(false);
        this.mc.options.jumpKey.setPressed(false);
    }

    private void ojb() {
        long l = System.currentTimeMillis();
        if (this.nzb == nwx.WAITING_FOR_CHEST && this.nzu != null) {
            this.nzj.put(this.nzu, l + 30000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
        } else if (this.oab != null) {
            this.nzl.put(this.oab, l + 60000L);
            this.oab = null;
        } else if (this.nzb == nwx.CHECK_PVP_COOLDOWN) {
            this.oeu = null;
        }
    }

    private void ojc(boolean bl) {
        boolean bl2 = this.mc.options.forwardKey.isPressed();
        if (!(bl && bl2 && pqf.isBlockedHorizontally())) {
            this.oey = 0;
            if (!this.ofa) {
                this.mc.options.leftKey.setPressed(false);
                this.mc.options.rightKey.setPressed(false);
            }
            return;
        }
        ++this.oey;
        if (this.oey < 8) {
            return;
        }
        this.ohq = true;
        if (this.oey % 20 == 0) {
            this.oez = -this.oez;
        }
        this.mc.options.rightKey.setPressed(this.oez > 0);
        this.mc.options.leftKey.setPressed(this.oez < 0);
        if (this.oey > 30) {
            this.oew = (this.oew + 1) % nyh.length;
            this.oiv(false);
        }
    }

    private void ojd() {
        KeyBinding[] keyBindingArray;
        if (this.mc.options == null || this.obw || this.oaz != nwg.NONE) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{this.mc.options.forwardKey, this.mc.options.backKey, this.mc.options.leftKey, this.mc.options.rightKey, this.mc.options.jumpKey, this.mc.options.sneakKey, this.mc.options.sprintKey}) {
            if (!this.heldByHuman(keyBinding)) continue;
            keyBinding.setPressed(true);
        }
    }

    private void oje() {
        KeyBinding[] keyBindingArray;
        if (this.mc.options == null) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{this.mc.options.forwardKey, this.mc.options.backKey, this.mc.options.leftKey, this.mc.options.rightKey, this.mc.options.jumpKey, this.mc.options.sprintKey, this.mc.options.sneakKey, this.mc.options.attackKey, this.mc.options.useKey}) {
            if (this.heldByHuman(keyBinding)) continue;
            keyBinding.setPressed(false);
        }
    }

    private void ojf() {
        KeyBinding[] keyBindingArray;
        if (this.mc.options == null) {
            return;
        }
        for (KeyBinding keyBinding : keyBindingArray = new KeyBinding[]{this.mc.options.forwardKey, this.mc.options.backKey, this.mc.options.leftKey, this.mc.options.rightKey, this.mc.options.jumpKey, this.mc.options.sprintKey}) {
            keyBinding.setPressed(this.heldByHuman(keyBinding));
        }
    }

    public boolean busy() {
        return this.oaz != nwg.NONE || this.obw || this.ocf;
    }

    private void ojg(BlockPos blockPos, nwg nwg2, long l) {
        this.obs = blockPos;
        this.obt = l;
        this.obu = nwg2;
    }

    private boolean ojh(long l) {
        GenericContainerScreenHandler genericContainerScreenHandler;
        Screen screen;
        block7: {
            block6: {
                screen = this.mc.currentScreen;
                if (!(screen instanceof HandledScreen)) {
                    return false;
                }
                HandledScreen handledScreen = (HandledScreen)screen;
                screen = handledScreen.getScreenHandler();
                if (!(screen instanceof GenericContainerScreenHandler)) break block6;
                genericContainerScreenHandler = (GenericContainerScreenHandler)screen;
                if (this.obs != null && this.obu != nwg.NONE && l - this.obt <= 2500L) break block7;
            }
            return false;
        }
        int n = this.oji(this.obs);
        if (n <= 0 || genericContainerScreenHandler.getRows() * 9 != n) {
            this.nzj.put(this.obs, l + 30000L);
            this.obs = null;
            return false;
        }
        this.oaz = this.obu;
        this.oba = screen.syncId;
        this.obb = this.obs;
        this.obd = l;
        this.obf = false;
        this.obg = false;
        this.obm = 0;
        this.obl = 0;
        this.obn = false;
        this.obh = 0L;
        this.obi = -1;
        this.obo.clear();
        this.obp.clear();
        this.obq = null;
        this.obr = 0;
        this.obj = 88.0;
        this.obk = (114.0 + (double)genericContainerScreenHandler.getRows() * 18.0) / 2.0;
        this.obc = l + Math.round(MathHelper.clamp((double)(230.0 * Math.exp(this.nzf.nextGaussian() * 0.25)), (double)150.0, (double)480.0));
        this.obs = null;
        this.obu = nwg.NONE;
        if (this.oaz == nwg.LOOT) {
            this.ohy(nwx.LOOTING);
        }
        this.silenceMovement();
        return true;
    }

    private int oji(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return 0;
        }
        BlockState blockState = this.getWorld().getBlockState(blockPos);
        if (!(blockState.getBlock() instanceof ChestBlock)) {
            return 0;
        }
        return blockState.get((Property)ChestBlock.CHEST_TYPE) == ChestType.SINGLE ? 27 : 54;
    }

    private HandledScreen<?> ojj() {
        Screen screen = this.mc.currentScreen;
        if (screen instanceof HandledScreen) {
            HandledScreen handledScreen = (HandledScreen)screen;
            if (handledScreen.getScreenHandler().syncId == this.oba) {
                return handledScreen;
            }
        }
        return null;
    }

    private void ojk(long l) {
        if (this.oaz == nwg.NONE || this.getPlayer() == null || this.getInteractionManager() == null) {
            return;
        }
        HandledScreen<?> handledScreen = this.ojj();
        if (handledScreen == null) {
            this.ojz();
            return;
        }
        ScreenHandler screenHandler = handledScreen.getScreenHandler();
        if (this.obf) {
            if (l >= this.obc) {
                if (this.ojp(screenHandler, l)) {
                    return;
                }
                this.mc.player.closeHandledScreen();
                this.ojz();
            }
            return;
        }
        if (l < this.obc) {
            return;
        }
        if (!this.isMovementSilent()) {
            this.obc = l + 25L;
            return;
        }
        if (this.obe != this.oba && l - this.obd < 1500L) {
            this.obc = l + 40L;
            return;
        }
        if (this.obq != null) {
            pmc pmc2 = this.obq.drive(screenHandler, l, (n, n2, slotActionType) -> this.ojl(screenHandler, n, n2, slotActionType));
            if (pmc2 == pmc.DONE || pmc2 == pmc.GAVE_UP) {
                this.obq = null;
                this.obc = l + pmf.settleDelay(this.nzf);
            }
            return;
        }
        if (this.ojp(screenHandler, l)) {
            return;
        }
        if (!screenHandler.getCursorStack().isEmpty()) {
            this.ojy(l);
            return;
        }
        switch (this.oaz.ordinal()) {
            case 1: {
                this.ojm(screenHandler, l);
                break;
            }
            case 2: {
                this.ojn(screenHandler, l);
                break;
            }
            case 3: {
                this.ojo(screenHandler, l);
                break;
            }
            case 4: {
                this.ojs(screenHandler, l, true);
                break;
            }
            case 5: {
                this.ojs(screenHandler, l, false);
                break;
            }
            default: {
                this.ojy(l);
            }
        }
    }

    private void ojl(ScreenHandler screenHandler, int n, int n2, SlotActionType slotActionType) {
        this.getInteractionManager().clickSlot(screenHandler.syncId, n, n2, slotActionType, (PlayerEntity)this.getPlayer());
        this.obh = System.currentTimeMillis();
        if (n >= 0 && n < screenHandler.slots.size()) {
            Slot slot = (Slot)screenHandler.slots.get(n);
            this.obj = (double)slot.x + 8.0;
            this.obk = (double)slot.y + 8.0;
        }
    }

    private void ojm(ScreenHandler screenHandler, long l) {
        Slot slot;
        Slot slot2;
        Slot slot3 = slot2 = this.obi >= 0 && this.oju(screenHandler, this.obi) ? (Slot)screenHandler.slots.get(this.obi) : this.ojt(screenHandler, -1, true);
        if (slot2 == null) {
            if (this.obh > 0L && l - this.obh < 240L) {
                this.obc = this.obh + 240L;
                return;
            }
            this.obn = this.ojw(screenHandler);
            this.obg = true;
            this.ojy(l);
            return;
        }
        int n = this.obo.merge(slot2.id, 1, Integer::sum);
        if (n > 3) {
            this.obp.add(slot2.id);
            this.obi = -1;
            return;
        }
        this.ojl(screenHandler, slot2.id, 0, SlotActionType.QUICK_MOVE);
        if (n == 1) {
            ++this.obl;
        }
        this.obi = (slot = this.ojt(screenHandler, slot2.id, true)) == null ? -1 : slot.id;
        double d = slot == null ? 0.0 : Math.hypot(slot.x - slot2.x, slot.y - slot2.y) / 18.0;
        this.obc = l + this.okc(d, 1.0);
    }

    private void ojn(ScreenHandler screenHandler, long l) {
        Slot slot;
        Slot slot2 = slot = this.obi >= 0 && this.ojv(screenHandler, this.obi) ? (Slot)screenHandler.slots.get(this.obi) : this.ojt(screenHandler, -1, false);
        if (slot == null) {
            if (this.obh > 0L && l - this.obh < 240L) {
                this.obc = this.obh + 240L;
                return;
            }
            this.obg = true;
            this.ojy(l);
            return;
        }
        int n = this.obo.merge(slot.id, 1, Integer::sum);
        if (n > 3) {
            this.obp.add(slot.id);
            this.obi = -1;
            return;
        }
        this.ojl(screenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
        Slot slot3 = this.ojt(screenHandler, slot.id, false);
        this.obi = slot3 == null ? -1 : slot3.id;
        double d = slot3 == null ? 0.0 : Math.hypot(slot3.x - slot.x, slot3.y - slot.y) / 18.0;
        this.obc = l + this.okc(d, 1.15);
    }

    private void ojo(ScreenHandler screenHandler, long l) {
        int n;
        int n2 = this.oqh(Items.GOLDEN_CARROT);
        if (n2 > this.oal && this.obm < 6 && (n = this.ojr(screenHandler, itemStack -> itemStack.isOf(Items.GOLDEN_CARROT))) != -1) {
            ++this.obm;
            this.ojl(screenHandler, n, 0, SlotActionType.QUICK_MOVE);
            this.obc = l + this.okc(1.0, 1.4);
            return;
        }
        if (n2 >= this.oal || this.obm >= 6) {
            this.obg = true;
            this.ojy(l);
            return;
        }
        ++this.obm;
        this.obq = pmf.plan(screenHandler, this.getPlayer().getInventory(), itemStack -> itemStack.isOf(Items.GOLDEN_CARROT), this.oal - n2, this.nzf, l);
        if (this.obq == null) {
            this.obg = true;
            this.ojy(l);
        }
    }

    private boolean ojp(ScreenHandler screenHandler, long l) {
        int n;
        ItemStack itemStack = screenHandler.getCursorStack();
        if (itemStack.isEmpty() || this.obr >= 8) {
            return false;
        }
        boolean bl = this.oaz == nwg.DUMP || this.oaz == nwg.FOOD && itemStack.isOf(Items.GOLDEN_CARROT) || this.oaz == nwg.INVIS && this.oqf(itemStack, true) || this.oaz == nwg.SPEED && this.oqf(itemStack, false);
        int n2 = n = bl ? pmf.stashSlot(screenHandler, this.getPlayer().getInventory(), itemStack, -1) : this.ojq(screenHandler, itemStack);
        if (n == -1) {
            int n3 = n = bl ? this.ojq(screenHandler, itemStack) : pmf.stashSlot(screenHandler, this.getPlayer().getInventory(), itemStack, -1);
        }
        if (n == -1) {
            return false;
        }
        ++this.obr;
        this.ojl(screenHandler, n, 0, SlotActionType.PICKUP);
        this.obc = l + pmf.settleDelay(this.nzf);
        return true;
    }

    private int ojq(ScreenHandler screenHandler, ItemStack itemStack) {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n = -1;
        for (int i = 0; i < screenHandler.slots.size(); ++i) {
            Slot slot = (Slot)screenHandler.slots.get(i);
            if (slot.inventory != playerInventory || slot.getIndex() >= 36) continue;
            if (!slot.hasStack()) {
                if (n != -1) continue;
                n = i;
                continue;
            }
            if (!ItemStack.areItemsAndComponentsEqual((ItemStack)slot.getStack(), (ItemStack)itemStack) || slot.getStack().getCount() >= slot.getStack().getMaxCount()) continue;
            return i;
        }
        return n;
    }

    private int ojr(ScreenHandler screenHandler, Predicate<ItemStack> predicate) {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < screenHandler.slots.size(); ++i) {
            Slot slot = (Slot)screenHandler.slots.get(i);
            if (slot.inventory != playerInventory || slot.getIndex() >= 36 || !slot.hasStack() || !predicate.test(slot.getStack()) || slot.getStack().getCount() <= n2) continue;
            n2 = slot.getStack().getCount();
            n = i;
        }
        return n;
    }

    private void ojs(ScreenHandler screenHandler, long l, boolean bl) {
        int n = this.oqg(bl);
        if (n == 1 || this.obm > 4) {
            this.obg = true;
            this.ojy(l);
            return;
        }
        if (n > 1) {
            for (int i = 0; i < screenHandler.slots.size(); ++i) {
                Slot slot = (Slot)screenHandler.slots.get(i);
                if (slot.inventory != this.getPlayer().getInventory() || !this.oqf(slot.getStack(), bl)) continue;
                this.ojl(screenHandler, i, 0, SlotActionType.QUICK_MOVE);
                this.obc = l + this.okc(1.0, 1.4);
                return;
            }
            ++this.obm;
            return;
        }
        ++this.obm;
        this.obq = pmf.plan(screenHandler, this.getPlayer().getInventory(), itemStack -> this.oqf((ItemStack)itemStack, bl), 1, this.nzf, l);
        if (this.obq == null) {
            this.obg = true;
            this.ojy(l);
        }
    }

    private Slot ojt(ScreenHandler screenHandler, int n, boolean bl) {
        Slot slot = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < screenHandler.slots.size(); ++i) {
            if (i == n || (bl ? !this.oju(screenHandler, i) : !this.ojv(screenHandler, i))) continue;
            Slot slot2 = (Slot)screenHandler.slots.get(i);
            double d2 = Math.hypot((double)slot2.x + 8.0 - this.obj, (double)slot2.y + 8.0 - this.obk);
            if (!(d2 < d)) continue;
            d = d2;
            slot = slot2;
        }
        return slot;
    }

    private boolean oju(ScreenHandler screenHandler, int n) {
        if (n < 0 || n >= screenHandler.slots.size() || this.obp.contains(n)) {
            return false;
        }
        Slot slot = (Slot)screenHandler.slots.get(n);
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        if (slot.inventory == playerInventory || !slot.hasStack()) {
            return false;
        }
        ItemStack itemStack = slot.getStack();
        return !this.oqa(itemStack) && slot.canTakeItems((PlayerEntity)this.getPlayer()) && nxa.ojx(playerInventory, itemStack);
    }

    private boolean ojv(ScreenHandler screenHandler, int n) {
        if (n < 0 || n >= screenHandler.slots.size() || this.obp.contains(n)) {
            return false;
        }
        Slot slot = (Slot)screenHandler.slots.get(n);
        if (slot.inventory != this.getPlayer().getInventory() || !slot.hasStack() || slot.getIndex() >= 36) {
            return false;
        }
        ItemStack itemStack = slot.getStack();
        return !this.oqe(itemStack) && !this.oqb(itemStack);
    }

    private boolean ojw(ScreenHandler screenHandler) {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        for (Slot slot : screenHandler.slots) {
            if (slot.inventory == playerInventory || !slot.hasStack() || this.oqa(slot.getStack()) || nxa.ojx(playerInventory, slot.getStack())) continue;
            return true;
        }
        return false;
    }

    private static boolean ojx(PlayerInventory playerInventory, ItemStack itemStack) {
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack2 = playerInventory.getStack(i);
            if (itemStack2.isEmpty()) {
                return true;
            }
            if (itemStack2.getCount() >= itemStack2.getMaxCount() || !ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack2, (ItemStack)itemStack)) continue;
            return true;
        }
        return false;
    }

    private void ojy(long l) {
        this.obf = true;
        this.obc = l + Math.round(MathHelper.clamp((double)(160.0 * Math.exp(this.nzf.nextGaussian() * 0.25)), (double)90.0, (double)400.0));
    }

    private void ojz() {
        nwg nwg2 = this.oaz;
        BlockPos blockPos = this.obb;
        boolean bl = this.obg;
        this.oka();
        this.oar = System.currentTimeMillis();
        this.oaq = 0;
        if (nwg2 == nwg.LOOT) {
            this.okb(blockPos);
            return;
        }
        if (nwg2 == nwg.NONE) {
            return;
        }
        if (!bl && ++this.oap < 3) {
            this.oam = null;
            return;
        }
        this.oap = 0;
        switch (nwg2.ordinal()) {
            case 2: {
                this.oag = true;
                break;
            }
            case 3: {
                this.oah = true;
                break;
            }
            case 4: {
                this.oai = true;
                break;
            }
            case 5: {
                this.oaj = true;
                break;
            }
        }
        this.oam = null;
    }

    private void oka() {
        this.oaz = nwg.NONE;
        this.oba = -1;
        this.obb = null;
        this.obf = false;
        this.obg = false;
        this.obi = -1;
        this.obo.clear();
        this.obp.clear();
        this.obq = null;
        this.obr = 0;
    }

    private void okb(BlockPos blockPos) {
        long l = System.currentTimeMillis();
        if (blockPos != null) {
            this.nzi.put(blockPos, l);
            if (this.getWorld() != null && this.driver == null) {
                oqv.markFromOutside(this.getWorld(), blockPos, this.obn);
            }
        }
        if (this.obl > 0) {
            ++this.nzg;
            ++this.ogh;
            this.odv = 0;
            if (this.nzh != null) {
                String string = pjd.key(this.olr());
                this.odz.put(string, this.nzh);
                this.oea.put(string, this.oij());
            }
        }
        this.oce = true;
        this.ohx();
        this.ofb = null;
        this.ofc = 0;
        if (this.obn || this.oql() < 2) {
            this.oml(a.d("\u20ea\u597e\ud3a2\u4dd4\uc60b\u40c5\ufae4\u7365\ued36\u63eb\ue027\u1a57\u9485\u0d31\u8761\u058d\ubfcf\u3013\uaebd\u28e1\ua506\udb36\u55f1\uce2c\u4858", -1393893021, 2083702152));
        } else if ((double)this.nzg >= this.nyq.get()) {
            this.oml(a.c(-1004802330, "\ueade\u930d\u19a0\u87d8\u0c78\u8ab0\u30e1\ubd08\u2736\uadf8\u2a24\ud024\u5e83\uc73f\u4d1a\ucf80\u75c2\ufa1e\u64b0\ue2ec\u6f0b\u113b\u9ffc\u0421\u8255"));
        } else {
            this.ohy(nwx.EXPLORING);
            this.oaa = 0;
        }
    }

    private long okc(double d, double d2) {
        double d3 = this.nys.get() * d2;
        double d4 = d3 * Math.exp(this.nzf.nextGaussian() * 0.22) + d3 * 0.32 * (Math.log(1.0 + d) / Math.log(2.0));
        if (this.nzf.nextDouble() < 0.04) {
            d4 += d3 * (1.0 + this.nzf.nextDouble() * 1.6);
        }
        return Math.round(MathHelper.clamp((double)d4, (double)(d3 * 0.6), (double)(d3 * 5.0)));
    }

    private void okd(long l) {
        boolean bl;
        boolean bl2;
        ItemStack itemStack;
        int n;
        int n2;
        if (this.okv()) {
            return;
        }
        if (this.obw || this.oaz != nwg.NONE || this.mc.currentScreen != null) {
            return;
        }
        if (this.nzb == nwx.ESCAPING || this.nzb == nwx.BOOT || this.nzb == nwx.CHECK_PVP_COOLDOWN || this.nzb == nwx.TELEPORT_TO_SAVE || this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.TELEPORT_TO_LOOT || this.nzb == nwx.WARPING_TO_LOOT_BASE) {
            return;
        }
        if (this.oci <= 0 && this.okq() && (n2 = this.oks()) != -1) {
            if (this.ocn > 10.0f) {
                this.oci = 200 + this.nzf.nextInt(200);
                return;
            }
            this.okt(n2);
            return;
        }
        if (this.ocd > 0 || this.odl > 60) {
            return;
        }
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        boolean bl3 = this.okr();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (n = 9; n < 36; ++n) {
            itemStack = playerInventory.getStack(n);
            if (itemStack.isEmpty()) {
                ++n4;
                continue;
            }
            if (!bl3 || !this.oqb(itemStack)) continue;
            ++n3;
        }
        for (n = 0; n < 9; ++n) {
            itemStack = playerInventory.getStack(n);
            if (itemStack.isEmpty()) {
                ++n6;
                continue;
            }
            if (this.oqb(itemStack) || this.oqd(itemStack)) continue;
            ++n5;
        }
        n = this.oke() ? 1 : 0;
        boolean bl4 = bl2 = n != 0 || n3 > 0 && (n4 <= 3 || n3 >= 5 || this.oce) || n5 > 0 && n4 > 0 && (this.oce || n6 < 2);
        if (!bl2) {
            this.oce = false;
            return;
        }
        boolean bl5 = bl = !this.opb() || this.oce;
        if (n == 0 && !bl && n4 > 1 && n6 >= 1) {
            return;
        }
        this.okf(l);
        this.oce = false;
    }

    private boolean oke() {
        if (this.nzb == nwx.RESTOCK || this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.TELEPORT_TO_SAVE) {
            return false;
        }
        return this.okj() != null;
    }

    private void okf(long l) {
        if (this.obw) {
            return;
        }
        this.oku();
        this.obw = true;
        this.obx = false;
        this.ocb = 0;
        this.occ = -1;
        this.oca = this.nzd;
        this.obz = l;
        this.oby = l + Math.round(MathHelper.clamp((double)(190.0 * Math.exp(this.nzf.nextGaussian() * 0.25)), (double)120.0, (double)420.0));
        this.silenceMovement();
    }

    private void okg(long l) {
        if (!this.obw) {
            return;
        }
        if (this.getPlayer() == null || this.mc.currentScreen != null || this.nzb == nwx.ESCAPING || l - this.obz > 9000L) {
            this.okh();
            return;
        }
        if (l < this.oby || this.nzd - this.oca < 1 || !this.isMovementSilent()) {
            return;
        }
        if (this.obx) {
            this.okh();
            return;
        }
        nwj nwj2 = this.oki();
        if (nwj2 == null) {
            this.obx = true;
            this.oby = l + (this.ocb == 0 ? 40L + (long)this.nzf.nextInt(60) : this.okn());
            return;
        }
        this.oko(nwj2.slot(), nwj2.button(), nwj2.type());
        if (nwj2.type() == SlotActionType.THROW) {
            this.ocq = this.nzd;
        }
        this.occ = nwj2.cursor();
        ++this.ocb;
        nwj nwj3 = this.oki();
        if (nwj3 == null) {
            this.obx = true;
            this.oby = l + this.okn();
        } else {
            this.oby = l + this.okm(nxa.okl(nwj2.cursor(), nwj3.cursor()));
        }
    }

    private void okh() {
        if (!this.obw) {
            return;
        }
        boolean bl = this.ocb == 0;
        this.obw = false;
        this.obx = false;
        this.okp();
        this.ojf();
        this.ocd = bl ? 40 : 10 + this.nzf.nextInt(20);
    }

    private nwj oki() {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n = this.occ != -1 ? this.occ : 13;
        int n2 = -1;
        double d = Double.MAX_VALUE;
        boolean bl = this.okr();
        for (int i = 0; i < 36; ++i) {
            double d2;
            if (!bl || !this.oqb(playerInventory.getStack(i)) || !((d2 = nxa.okl(n, i)) < d)) continue;
            d = d2;
            n2 = i;
        }
        if (n2 != -1) {
            return new nwj(n2, 1, SlotActionType.THROW, n2);
        }
        nwj nwj2 = this.okj();
        if (nwj2 != null) {
            return nwj2;
        }
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            if (itemStack.isEmpty() || this.oqd(itemStack)) continue;
            int n3 = this.okk(n);
            if (n3 == -1) {
                return null;
            }
            return new nwj(n3, i, SlotActionType.SWAP, n3);
        }
        return null;
    }

    private nwj okj() {
        int n;
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n2 = -1;
        if (this.oqi(itemStack -> this.oqf((ItemStack)itemStack, true)) == -1) {
            n2 = this.oqj(itemStack -> this.oqf((ItemStack)itemStack, true));
        }
        if (n2 == -1 && this.nyt.get() && this.oqi(itemStack -> this.oqf((ItemStack)itemStack, false)) == -1) {
            n2 = this.oqj(itemStack -> this.oqf((ItemStack)itemStack, false));
        }
        if (n2 == -1 && this.oqi(itemStack -> itemStack.isOf(Items.GOLDEN_CARROT)) == -1) {
            n2 = this.oqj(itemStack -> itemStack.isOf(Items.GOLDEN_CARROT));
        }
        if (n2 == -1) {
            return null;
        }
        int n3 = -1;
        for (n = 0; n < 9 && n3 == -1; ++n) {
            if (!playerInventory.getStack(n).isEmpty()) continue;
            n3 = n;
        }
        for (n = 0; n < 9 && n3 == -1; ++n) {
            if (this.oqd(playerInventory.getStack(n))) continue;
            n3 = n;
        }
        if (n3 == -1) {
            return null;
        }
        return new nwj(n2, n3, SlotActionType.SWAP, n2);
    }

    private int okk(int n) {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n2 = -1;
        double d = Double.MAX_VALUE;
        for (int i = 9; i < 36; ++i) {
            double d2;
            if (!playerInventory.getStack(i).isEmpty() || !((d2 = nxa.okl(n, i)) < d)) continue;
            d = d2;
            n2 = i;
        }
        return n2;
    }

    private static double okl(int n, int n2) {
        double d = n < 9 ? 3.25 : (double)((n - 9) / 9);
        double d2 = n < 9 ? (double)n : (double)((n - 9) % 9);
        double d3 = n2 < 9 ? 3.25 : (double)((n2 - 9) / 9);
        double d4 = n2 < 9 ? (double)n2 : (double)((n2 - 9) % 9);
        return Math.hypot(d - d3, d2 - d4);
    }

    private long okm(double d) {
        double d2 = 95.0 * Math.exp(this.nzf.nextGaussian() * 0.25) + 28.0 * (Math.log(1.0 + d) / Math.log(2.0));
        if (this.nzf.nextDouble() < 0.04) {
            d2 += 120.0 + this.nzf.nextDouble() * 180.0;
        }
        return Math.round(MathHelper.clamp((double)d2, (double)55.0, (double)520.0));
    }

    private long okn() {
        return Math.round(MathHelper.clamp((double)(150.0 * Math.exp(this.nzf.nextGaussian() * 0.3)), (double)80.0, (double)420.0));
    }

    private void oko(int n, int n2, SlotActionType slotActionType) {
        if (this.getInteractionManager() == null || this.getPlayer() == null) {
            return;
        }
        int n3 = n < 9 ? n + 36 : n;
        this.getInteractionManager().clickSlot(this.getPlayer().playerScreenHandler.syncId, n3, n2, slotActionType, (PlayerEntity)this.getPlayer());
        if (this.mc.currentScreen == null) {
            this.ocf = true;
        }
    }

    private void okp() {
        if (!this.ocf) {
            return;
        }
        this.ocf = false;
        if (this.mc.currentScreen != null || this.getPlayer() == null || this.getNetworkHandler() == null) {
            return;
        }
        this.getNetworkHandler().sendPacket((Packet)new CloseHandledScreenC2SPacket(this.getPlayer().playerScreenHandler.syncId));
    }

    private boolean okq() {
        return this.mc.currentScreen == null && !this.ocf && !this.obw && this.oaz == nwg.NONE && !this.mc.options.attackKey.isPressed() && !this.mc.options.useKey.isPressed() && !this.getPlayer().isUsingItem() && !this.getPlayer().isSpectator() && this.nzb != nwx.ESCAPING && this.nzd - this.ohl > 10 && !this.ohb && !this.ond(System.currentTimeMillis()) && this.okr();
    }

    private boolean okr() {
        if (this.oco > 0 || this.nzd - this.oek < 40 || !this.opb()) {
            return false;
        }
        return this.nzb == nwx.EXPLORING || this.nzb == nwx.RESTOCK || this.nzb == nwx.WAITING_FOR_CHEST && !this.oni();
    }

    private int oks() {
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        int n = playerInventory.getSelectedSlot();
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            if (!this.oqb(playerInventory.getStack(i)) || n2 != -1 && Math.abs(i - n) >= Math.abs(n2 - n)) continue;
            n2 = i;
        }
        return n2;
    }

    private void okt(int n) {
        this.oku();
        this.ocg = n;
        boolean bl = this.getPlayer().getInventory().getSelectedSlot() == n;
        float f = this.nzf.nextFloat();
        this.och = bl ? 0 : (f < 0.2f ? 0 : (f < 0.6f ? 1 : (f < 0.9f ? 2 : 3)));
        this.getPlayer().getInventory().setSelectedSlot(n);
    }

    private void oku() {
        this.ocg = -1;
        this.och = 0;
        this.ocj = false;
        this.ock = 0;
        this.ocl = 0;
    }

    private boolean okv() {
        if (this.ocg == -1) {
            return false;
        }
        if (this.ocj) {
            if (this.ocl == 0 && ++this.ock <= 3) {
                return true;
            }
            boolean bl = this.ocl > 0;
            this.oku();
            if (bl) {
                this.ocn += 1.0f;
                this.oci = this.nzf.nextInt(3);
                this.ocq = this.nzd;
            } else {
                this.oci = 8 + this.nzf.nextInt(12);
            }
            return false;
        }
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        if (!this.okq() || !this.oqb(playerInventory.getStack(this.ocg)) || playerInventory.getSelectedSlot() != this.ocg) {
            this.oku();
            this.oci = 6 + this.nzf.nextInt(10);
            return false;
        }
        if (this.och-- > 0) {
            return true;
        }
        int n = this.ocg;
        int n2 = ++this.ocm;
        this.ocj = true;
        this.ock = 0;
        this.ocl = 0;
        ptr.later(() -> {
            boolean bl = this.okw(n, n2);
            if (n2 == this.ocm) {
                this.ocl = bl ? 1 : -1;
            }
        });
        return true;
    }

    private boolean okw(int n, int n2) {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (n2 != this.ocm || !this.ocj || clientPlayerEntity == null || this.mc.currentScreen != null || clientPlayerEntity.isSpectator() || clientPlayerEntity.getInventory().getSelectedSlot() != n) {
            return false;
        }
        ItemStack itemStack = clientPlayerEntity.getMainHandStack();
        if (!this.oqb(itemStack)) {
            return false;
        }
        if (!clientPlayerEntity.dropSelectedItem(itemStack.getCount() > 1)) {
            return false;
        }
        clientPlayerEntity.swingHand(Hand.MAIN_HAND);
        return true;
    }

    private boolean okx() {
        boolean bl;
        boolean bl2 = this.nzb == nwx.WARPING_TO_LOOT_BASE && this.oau && (this.omo() > 0 || this.omk());
        boolean bl3 = bl = this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST || this.nzb == nwx.CHECK_PVP_COOLDOWN;
        if ((bl2 || bl) && this.odl <= 0 && !this.ond(System.currentTimeMillis())) {
            boolean bl4;
            int n = bl2 ? 2400 : 600;
            boolean bl5 = this.oky(true, n);
            boolean bl6 = bl4 = this.nyt.get() && this.oky(false, n);
            if (bl5 || bl4) {
                boolean bl7 = bl5;
                int n2 = this.oqi(itemStack -> this.oqf((ItemStack)itemStack, bl7));
                if (n2 == -1) {
                    if (this.ocd > 0) {
                        return false;
                    }
                    this.okf(System.currentTimeMillis());
                    pqf.resetKeys();
                    this.oot();
                    return true;
                }
                if (this.odg != 0) {
                    this.olf();
                }
                pqf.resetKeys();
                this.oot();
                if (this.getPlayer().getInventory().getSelectedSlot() != n2) {
                    this.getPlayer().getInventory().setSelectedSlot(n2);
                    this.olh();
                    this.odk = 0;
                    this.odj = true;
                    return true;
                }
                this.odj = true;
                ++this.odk;
                if (!(this.getPlayer().getInventory().getStack(n2).isOf(Items.POTION) || this.old(86.0f) && !(this.ogw < 78.0f))) {
                    this.olh();
                    if (this.odk > 100) {
                        this.odk = 0;
                        this.odl = 100;
                    }
                    return true;
                }
                this.odm = bl7 ? 0 : 1;
                this.odn = this.nzd;
                this.olg(true);
                if (!this.getPlayer().isUsingItem() && this.odk % 5 == 0) {
                    ptr.later(() -> {
                        if (this.mc.player != null && this.mc.interactionManager != null && !this.mc.player.isUsingItem()) {
                            this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, Hand.MAIN_HAND);
                        }
                    });
                }
                if (this.odk > 100) {
                    int n3;
                    this.olh();
                    this.odk = 0;
                    this.odl = 100;
                    int n4 = n3 = bl7 ? 0 : 1;
                    this.ods[n4] = this.ods[n4] + 1;
                    if (this.ods[n4] >= 3) {
                        this.ola(n3);
                    }
                }
                return true;
            }
        }
        if (this.odj) {
            this.odj = false;
            this.odk = 0;
            this.odm = -1;
            this.olh();
            if (!this.oqb(this.getPlayer().getMainHandStack())) {
                this.olj();
            }
        }
        return false;
    }

    private boolean oky(boolean bl, int n) {
        int n2;
        int n3 = n2 = bl ? 0 : 1;
        if (this.odt[n2] || this.odp[n2] > 0 || this.oqg(bl) == 0) {
            return false;
        }
        int n4 = this.odr[n2] > 0 ? Math.min(n, this.odr[n2] * 3 / 4) : n;
        return this.olb(bl) < n4;
    }

    private void okz() {
        for (int i = 0; i < 2; ++i) {
            boolean bl = i == 0;
            int n = this.oqg(bl);
            int n2 = this.olb(bl);
            if (this.odo[i] >= 0 && n < this.odo[i] && this.odm == i && this.nzd - this.odn <= 3) {
                this.odp[i] = 60;
                this.odq[i] = n2;
                this.ods[i] = 0;
            }
            this.odo[i] = n;
            if (this.odp[i] <= 0) continue;
            if (n2 > this.odq[i]) {
                this.odp[i] = 0;
                this.odr[i] = n2;
                continue;
            }
            int n3 = i;
            this.odp[n3] = this.odp[n3] - 1;
            if (this.odp[n3] != 0) continue;
            this.ola(i);
        }
    }

    private void ola(int n) {
        if (this.odt[n]) {
            return;
        }
        this.odt[n] = true;
        this.notifyUser(n == 0 ? wap.s(a.c(-2121146754, "\ude68\ua7e5\u2d3b\ub30f\u3891\ube27\u046c\u8d82\u13c7\u996c\u1eb4\ue4ce\u6a1c\uf3a8\u79e6\uff1a\u450c\uca8d\u5021\ud66b\u5f81\u25d6\uab64\u30fb\ub6c3\u3c14\u85b0\u0bf2\u9140\u175f\u9ced\u6273\ue879\u718b\uf7d8\u7d6a\uc2bb\u48dd\uce5a\u57e6\uddb4\ua30b\u2959\uaea7\u343d\uba4e\u0380\u8926\u0f2c\u94b2\u1ac8\ue05f\u69bc\ueff1\u750f\ufb56\u40a4\uc621\u4c4e\ud59e\u5b33\u2131\ua696\u2cc1\ub215\u3bbd"), a.b("\ub1c4\uc857\u428a\udc8c\u5722\ud586\u6bc8\ue231\u7c69\uf6d2\u710d\u8b70\u05a3\u9c10\u163c\u90ce\u2afb\ua132\u3f9c\ub9c5\u3427\u4a62\uc4d5\u5f0f\ud975\u57ba\uea64\u643c\ufecb\u78eb\uf357\u0dfe\u87c3\u1a22\u9c7c\u16c0\uad06\u2778\ua1ae\u3868\ub233\uccbf\u42f9\uc155\u5b8a\ud1ee\u6c22\ue6e0\u60ad\uff12\u7573\u8bb0\u066a\u8034\u1abb\u94e8\u2b4b\ua98d\u23f9\uba5d\u3491\u4eca\uc938", -893405716)) : wap.s(a.c(-2105457530, "\u44e9\u3d64\ub7ba\u298e\ua20a\u24b8\u9efe\u170f\u8951\u03a4\u8427\u7e49\uf085\u6929\ue37c\u658c\udf8d\u501b\ucaae\u4ce8\uc50c\ubf18\u31e5\uaa35\u2c05\ua691\u1f21\u9170\u0b84\u8dd3\u0677\uf8f2\u72b0\ueb4c\u6d51\ue7e1\u5879\ud245\u5494\ucd38\u4770\u39c4\ub3d8\u3460\uaef1\u20d4\u991b\u13a7\u95e0\u0e7c\u805b\u7a96\uf320\u756b\uefcb\u61ce\uda77\u5cbd\ud6d7"), a.b("\u12aa\u6b39\ue1e4\u7fe2\uf44c\u76e8\uc8da\u4150\udf0b\u55c4\ud269\u2867\ua6b3\u3f78\ub133\u33df\u8998\u025c\u9cfb\u1aae\u9352\ue906\u63ab\ufc17\u7a61\uf0b0\u4972\uc72c\u5da3\udb80\u5423\uaaff\u20bd\ubd5d\u3b01\ub1b5\u0e15\u8460\u02ce\u9f6a\u1128\u6fd1\ue197\u6239\uf89d\u76ee\ucb53\u45f0\uc7ad\u5811\ud66d\u2cc0\ua575\u2738\ub9dc\u378a\u8c40\u0aea\u8093\u1943", 1693783681)), false);
    }

    private int olb(boolean bl) {
        StatusEffectInstance statusEffectInstance = this.getPlayer().getStatusEffect(bl ? StatusEffects.INVISIBILITY : StatusEffects.SPEED);
        return statusEffectInstance == null ? 0 : (statusEffectInstance.isInfinite() ? Integer.MAX_VALUE : statusEffectInstance.getDuration());
    }

    private boolean olc() {
        boolean bl = this.getPlayer().getHungerManager().getFoodLevel() < 14;
        int n = this.oqi(itemStack -> itemStack.isOf(Items.GOLDEN_CARROT));
        boolean bl2 = this.opb();
        if (this.odg == 0) {
            if (!bl || n == -1) {
                if (this.mc.options.useKey.isPressed() && !this.ohk) {
                    this.olh();
                    if (this.getPlayer().getMainHandStack().isOf(Items.GOLDEN_CARROT)) {
                        this.olj();
                    }
                }
                return false;
            }
            this.odh = this.ogl.intentPitch();
            this.odg = bl2 ? 2 : 1;
            this.odi = 0;
        }
        if (!(this.odg == 3 || bl && n != -1)) {
            this.olh();
            int n2 = this.odg = bl2 ? 0 : 3;
            if (this.odg == 0) {
                this.olj();
                return false;
            }
        }
        switch (this.odg) {
            case 1: {
                this.olh();
                if (!bl2 && !this.old(-55.0f)) break;
                this.odg = 2;
                this.odi = 0;
                break;
            }
            case 2: {
                if (!bl2) {
                    this.old(-55.0f);
                }
                this.getPlayer().getInventory().setSelectedSlot(n);
                this.olg(!bl2);
                if (++this.odi <= 200) break;
                this.olh();
                this.odg = 3;
                break;
            }
            case 3: {
                this.olh();
                if (!bl2 && !this.old(this.odh)) break;
                this.odg = 0;
                this.olj();
                return false;
            }
        }
        return true;
    }

    private boolean old(float f) {
        this.oom(this.ogo ? this.ogs : this.ogl.intentYaw(), f);
        return Math.abs(this.ogl.intentPitch() - f) <= 0.75f;
    }

    private void ole() {
        if (this.opb()) {
            this.opq();
            pyd.setSprint(this.mc.options, false);
            this.mc.options.jumpKey.setPressed(false);
        } else {
            pqf.resetKeys();
            this.oot();
        }
    }

    private void olf() {
        this.olh();
        this.odg = 0;
        this.odi = 0;
    }

    private void olg(boolean bl) {
        this.mc.options.sneakKey.setPressed(bl);
        this.mc.options.useKey.setPressed(true);
        ptr.miss();
    }

    private void olh() {
        if (this.mc.options == null) {
            return;
        }
        this.mc.options.useKey.setPressed(false);
        this.mc.options.sneakKey.setPressed(false);
    }

    private boolean oli(ItemStack itemStack) {
        return !itemStack.isEmpty() && (itemStack.isOf(Items.GOLDEN_CARROT) || this.oqf(itemStack, true) || this.oqf(itemStack, false));
    }

    private void olj() {
        int n;
        PlayerInventory playerInventory = this.getPlayer().getInventory();
        for (n = 0; n < 9; ++n) {
            if (!playerInventory.getStack(n).isEmpty()) continue;
            playerInventory.setSelectedSlot(n);
            return;
        }
        for (n = 0; n < 9; ++n) {
            if (this.oli(playerInventory.getStack(n))) continue;
            playerInventory.setSelectedSlot(n);
            return;
        }
    }

    private void olk(long l) {
        this.odj = false;
        if (!this.oai && this.oqg(true) == 1) {
            this.oai = true;
        }
        if (this.nyt.get()) {
            if (!this.oaj && this.oqg(false) == 1) {
                this.oaj = true;
            }
        } else {
            this.oaj = true;
        }
        if (!this.oah && this.oqh(Items.GOLDEN_CARROT) == this.oal) {
            this.oah = true;
        }
        if (this.oag && this.oah && this.oai && this.oaj) {
            if (this.oqg(true) == 0 && (this.olb(true) < 2400 || this.olp(a.c(196441258, "\u7097\u0923\u83ff\u1d84\u965c"), a.d("\u69f8\u1041\u9a95\u04ee\u8f35\u0988\ub3df", 1353270919, -624219323)) != null)) {
                if (!this.ody) {
                    this.ody = true;
                    this.notifyUser(a.b("\uf46b\u8df2\u0756\u9d45\u128f\u9436\u2e62\ua799\u39ca\ub377\u34a0\uced3\u407b\ud9c9\u53e0\ud109\u6f5b\ue087\u7e24\ufc64\u7592\u0fc4\u8175\u1eb1\u98c3\u121f\uafba\u21e9\ubb7b\u3d47", -337383320), false);
                }
                this.oai = false;
                this.oao = 600;
                return;
            }
            this.ody = false;
            if (this.ome()) {
                pqf.resetKeys();
                this.oou();
                return;
            }
            this.ohy(nwx.TELEPORT_TO_LOOT);
            return;
        }
        if (this.oam != null && this.nzd - this.ocw > 400) {
            this.oam = null;
            this.ofb = null;
            this.oao = 40;
            this.oln();
        }
        if (this.oam == null) {
            BlockPos blockPos;
            if (this.oao > 0) {
                pqf.resetKeys();
                this.oou();
                return;
            }
            nwg nwg2 = !this.oag ? nwg.DUMP : this.oll();
            switch (nwg2.ordinal()) {
                case 2: {
                    BlockPos blockPos2 = this.olp(a.b("\uf4e6\u8d27\u0785\u998a\u1222", -154144606));
                    break;
                }
                case 3: {
                    BlockPos blockPos2 = this.olp(a.d("\u4e11\u37a1\ubd76", 670375888, 1650808311));
                    break;
                }
                case 4: {
                    BlockPos blockPos2 = this.olp(a.c(616551291, "\ud746\uaef2\u242e\uba55\u318d"), a.d("\ude3a\ua783\u2d57\ub32c\u38f7\ube4a\u041d", -259859738, -1391722266));
                    break;
                }
                default: {
                    BlockPos blockPos2 = blockPos = this.olp(a.b("\ud568\uaca2\u2675\ub87a\u33d3\ub51d\u0f4d", -398667474));
                }
            }
            if (blockPos == null) {
                this.oao = 10;
                if (nwg2 != nwg.DUMP && this.olp(a.b("\u67c8\u1e09\u94ab\u0aa4\u810c", 2090689420)) != null) {
                    switch (nwg2.ordinal()) {
                        case 3: {
                            this.oah = true;
                            break;
                        }
                        case 4: {
                            this.oai = true;
                            break;
                        }
                        default: {
                            this.oaj = true;
                        }
                    }
                }
                pqf.resetKeys();
                this.oou();
                return;
            }
            this.oam = blockPos;
            this.oan = nwg2;
            this.ocw = this.nzd;
            this.oaq = 0;
            this.nzy = 0;
            this.oov();
            this.opc(blockPos, true);
            return;
        }
        if (!this.olo(this.oam)) {
            if (!this.opb()) {
                this.opc(this.oam, false);
            }
            if (this.opb()) {
                this.opq();
                return;
            }
        }
        this.ofb = null;
        pqf.resetKeys();
        Vec3d vec3d = this.onl(this.oam);
        if (vec3d == null) {
            if (this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)this.oam)) > 16.0) {
                this.opc(this.oam, false);
            }
            vec3d = Vec3d.ofCenter((Vec3i)this.oam);
        }
        this.ooq(this.oam, vec3d);
        this.ono(this.oam, this.oan, l);
        if (this.nzy > 6) {
            this.nzy = 0;
            this.oam = null;
            this.oao = 40;
            this.oln();
        }
    }

    private nwg oll() {
        for (nwg nwg2 : this.oak) {
            if (nwg2 == nwg.FOOD && !this.oah) {
                return nwg2;
            }
            if (nwg2 == nwg.INVIS && !this.oai) {
                return nwg2;
            }
            if (nwg2 != nwg.SPEED || this.oaj) continue;
            return nwg2;
        }
        return nwg.SPEED;
    }

    private void olm() {
        Collections.shuffle(this.oak, this.nzf);
        this.oal = 3;
        this.ocv = 4.0f + this.nzf.nextFloat() * 14.0f;
    }

    private void oln() {
        if (++this.oap < 3) {
            return;
        }
        this.oap = 0;
        switch (this.oan.ordinal()) {
            case 2: {
                this.oag = true;
                break;
            }
            case 3: {
                this.oah = true;
                break;
            }
            case 4: {
                this.oai = true;
                break;
            }
            case 5: {
                this.oaj = true;
                break;
            }
        }
    }

    private boolean olo(BlockPos blockPos) {
        return this.getPlayer().isOnGround() && this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos)) <= 12.0 && this.onl(blockPos) != null;
    }

    private BlockPos olp(String ... stringArray) {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        return pte.find(this.mc, this.getPlayer().getBlockPos(), stringArray);
    }

    private boolean olq(BlockPos blockPos) {
        return this.getWorld() != null && this.getWorld().getBlockState(blockPos).getBlock() instanceof ChestBlock;
    }

    private String olr() {
        String[] stringArray;
        String string = this.nyv.get();
        String[] stringArray2 = stringArray = string == null ? new String[]{} : string.trim().split(a.b("\ue40b\u9dcd\u176e\u8930\u02c9\u840e", 875422806));
        if (stringArray.length == 0 || stringArray[0].isEmpty()) {
            return a.c(-898335051, "\u7ed1\u076f\u8de0\u1390\u984d");
        }
        if (this.nze >= stringArray.length) {
            this.nze = 0;
        }
        return stringArray[this.nze];
    }

    private static String ols(String string, String string2) {
        String string3;
        String string4 = string3 = string == null ? "" : string.trim();
        while (string3.startsWith(a.c(-690656584, "\u6a96"))) {
            string3 = string3.substring(1).trim();
        }
        return string3.isEmpty() ? string2 : string3;
    }

    private String olt() {
        if (a.d("\ub6df\ucf58\u4598\udbeb", -1694636612, 1880576816).equals(this.nyw.get())) {
            String string = nxa.ols(this.nyy.get(), a.c(-1452440530, "\u845f\ufdf8\u7738\ue95f\u6289\ue433"));
            if (string.toLowerCase().startsWith(a.c(-27186685, "\u2a71\u53d6\ud916\u4765\ucce2"))) {
                string = string.substring(5).trim();
            }
            return a.b("\ua2d7\udb70\u51b0\ucfc3\u4444", 65643173) + (string.isEmpty() ? a.c(-1164931064, "\u9079\ue9de\u631e\ufd79\u76af\uf015") : string);
        }
        return this.olu();
    }

    private String olu() {
        String string = nxa.ols(this.nyx.get(), a.b("\u15d5\u6c72\ue6b2\u78d5\uf303\u75b9", 2059933092));
        if (string.toLowerCase().startsWith(a.d("\u286e\u51d8\udb09\u4570\ucee2", 1742183438, 705541133))) {
            string = string.substring(5).trim();
        }
        return a.b("\u1510\u6ca6\ue677\u780e\uf39c", -1888610947) + (string.isEmpty() ? a.c(-566673034, "\u4107\u38a0\ub260\u2c07\ua7d1\u216b") : string);
    }

    private void olv() {
        this.oas = 0;
        this.oau = false;
        this.oav = false;
        this.ocx = 0;
        this.oaw = null;
        this.oax = 0;
        this.oay = 0;
        this.oat = this.nzf.nextInt(25);
        this.ofb = null;
        this.ofc = 0;
        this.ohx();
        this.oab = null;
        this.oia();
        this.ocz = this.getWorld();
        this.oda = this.getPlayer();
        this.odb = this.getPlayer() == null ? null : this.getPlayer().getEntityPos();
        this.odc = -1;
        this.odd = false;
        this.oeb = false;
        this.oec = null;
        this.oed = null;
    }

    private String[] olw() {
        String[] stringArray;
        String[] stringArray2;
        String string = this.nyv.get();
        String[] stringArray3 = stringArray2 = string == null ? new String[]{} : string.trim().split(a.c(-946926314, "\u0d4b\u748d\ufe2e\u6070\ueb89\u6d4e"));
        if (stringArray2.length == 0 || stringArray2[0].isEmpty()) {
            String[] stringArray4 = new String[1];
            stringArray = stringArray4;
            stringArray4[0] = a.c(505358758, "\u29c2\u507c\udaf3\u4483\ucf5e");
        } else {
            stringArray = stringArray2;
        }
        return stringArray;
    }

    private void olx() {
        pqf.resetKeys();
        String[] stringArray = this.olw();
        for (int i = 0; i < stringArray.length; ++i) {
            int n = (this.nze + i) % stringArray.length;
            if (!pjd.hasRoom(stringArray[n], this.ohu())) continue;
            this.nze = n;
            break;
        }
        String string = nxa.ols(this.olr(), a.d("\u825d\ufbe3\u716c\uef1c\u64c1", 187058704, -962017239));
        if (!pjd.enter(this.ohu(), string)) {
            this.oly(a.c(-1412527208, "\u8fa9\uf64b\u7cec\ue688\u694f\ueff3\u55a7\udc54\u4613\uc8b9\u4f12\ub562\u3bc7\ua666\u2822\uaed4\u1496\u9b35\u018b\u87d3\u0a4f\u7013\ufead\u616a\ue717\u6da3\ud47d\u5e30\uc0d9\u46f1\ucd30\u3394\ub9ae\u205e\ua601"), false);
            return;
        }
        this.odf = "";
        this.getNetworkHandler().sendChatCommand(string);
        this.olv();
        ++this.ogi;
        this.nzg = 0;
        this.nzi.clear();
        this.nzj.clear();
        this.nzk.clear();
        this.nzl.clear();
        this.ohy(nwx.WARPING_TO_LOOT_BASE);
    }

    private void oly(String string, boolean bl) {
        int n = pjd.position(this.ohu());
        this.odf = wap.t(string) + (n > 0 ? wap.s(a.b("\u0aa1\u7318\uf9c0", -2143942014) + n + a.b("\ua501", -1158306519), a.b("\u3a7f\u43c6", 1584609885) + n + a.d("\u8d48\uf0ed\u7e2e", 288367060, -1031230286)) : "");
        if (this.nzd - this.ode > 600) {
            this.ode = this.nzd;
            this.notifyUser(this.odf, false);
        }
        if (bl) {
            this.oog();
        } else {
            pqf.resetKeys();
            this.oou();
        }
    }

    private void olz() {
        pqf.resetKeys();
        this.oot();
        this.omh();
        ++this.oas;
        if (!this.oau) {
            if (this.odc < 0) {
                if (this.omf() || this.oas >= 200) {
                    this.odc = this.oas;
                    this.oeb = this.omf();
                }
                return;
            }
            if (this.oas - this.odc < 30 + this.oat) {
                return;
            }
            if (this.omg() || this.omc()) {
                this.omb();
                return;
            }
            if (this.ocx >= 3) {
                this.oma();
                return;
            }
            this.omi(this.olt());
            return;
        }
        if (this.getWorld() != this.ocy && !this.oeb) {
            this.oeb = true;
            this.oau = false;
            this.odc = this.oas;
            this.oay = 0;
            this.oec = null;
            this.oed = null;
            return;
        }
        if (this.omo() > 0) {
            this.oay = 0;
            return;
        }
        if (!(this.omk() || this.omg() || this.omc())) {
            if (this.oas - this.oax < 200) {
                return;
            }
            if (this.ocx < 3) {
                this.omi(this.olt());
                return;
            }
            this.oma();
            return;
        }
        if (++this.oay >= 30) {
            this.omb();
        }
    }

    private void oma() {
        this.notifyUser(a.c(547284444, "\ue1f1\u9868\u16ae\u8cbd\u071d\u81a2\u3bff\ub204\u2c5a\ua695\u2144\udb4f\u55e0\ucc2f\u4670\uc083\u7ac7\uf513\u6bbe\ue9fd\u6418\u1a5a\u94e4\u0f4b\u894a\u0391\ube36\u306a\uaa90\u28de\ua312\u5dbd\ud7fd\u4e7e\uc85b\u42e3\uf928\u774d\uf1ea\u6858\ue277\u9cf6\u16a8\u9577\u0bb0\u85cc\u3c18\ub6d0"), false);
        this.omd(wap.t(a.b("\u2f0a\u5693\ud855\u4246\uc9e6\u4f59\uf504\u7cff\ue2a1\u686e\uefbf\u15b4\u9b1b\u02d4\u888b\u0e78\ub43c\u3be8\ua545\u2706\uaae3\ud4a1\u5a1f\uc1b0\u47b1\ucd6a\u70cd\ufe91\u646b\ue625\u6de9\u9346\u1906\u8085\u06a0\u8c18\u37d3\ub9b6\u3f11\ua6a3\u2c8c\u520d\ud853\u5b8c\uc54b\u4b37\uf2e3\u782b", -1839060185)));
        ++this.nze;
        this.ohy(nwx.TELEPORT_TO_SAVE);
    }

    private void omb() {
        BlockPos blockPos = this.omc() ? this.odz.get(pjd.key(this.olr())) : null;
        this.nzh = blockPos != null ? blockPos : this.getPlayer().getBlockPos();
        this.oaa = 0;
        this.oay = 0;
        this.ohy(nwx.EXPLORING);
    }

    private boolean omc() {
        String string = pjd.key(this.olr());
        BlockPos blockPos = this.odz.get(string);
        double d = 100.0;
        return blockPos != null && this.oij().equals(this.oea.get(string)) && this.getPlayer().getBlockPos().getSquaredDistance((Vec3i)blockPos) < d * d;
    }

    private void omd(String string) {
        ++this.odv;
        this.odw = string;
    }

    private boolean ome() {
        if (this.odv < 3) {
            return false;
        }
        if (!this.odx) {
            this.notifyUser(wap.s(a.b("\u2454\u5dc2\ud70a\u4964\uc2b3\u4417\ufe45\u77ea\ue9af", 1370235918) + this.odv + a.b("\u77bf\u0e5a\u848f\u1ae5\u912b\u1799\uad99\u2421\uba79\u3086\ub714\u4d24\uc3a1\u5a0d\ud046\u56e0\uecec\u633f\uf980\u7fd9\uf66b\u8c78\u02c8\u991b\u1f6c\u95f6\u2c12\ua25d\u38b7\ubefa\u3501\ucb9e\u41d0\ud83a\u5e75\ud4c5\u6b15\ue16d\u67f9\ufe40", -345278537) + this.odw + a.b("\u19ce\u6078\ueaa5\u74b7\uff4b\u79f7\uc3a2\u4a5b\ud44f\u5eaa\ud965\u2319\uad8b\u346a\ube26\u38cc\u829e\u0d49\u97fb\u11b7\u981f\ue242\u6ca5\uf768\u711a\ufb8e\u426a\ucc2d\u56c9\ud09a\u5b79\ua5a7\u2fe7\ub65e\u300a\ubab9\u0566\u8f52\u09c0\u907e\u1a2b\u649e\uee99\u6934\uf3ee\u7dda\uc448\u4ef6\uc8b6\u5374\udd16\u27cc\uae7a\u2827\ub2c2\u3ccc\u877f\u01fa\u8b95\u1249\u9cf5\ue6ea\u614d\ueb1d\u75d5\ufc78\u4665\uc0dd\u4a97\ud572\u5fee\ud99e\u200f\uaaff\u34aa\ubf5d\u3902\u83b4", 1007360425), a.c(-22107395, "\uaeef\ud701\u5dd1\uc3d2\u4808\uceba\u74e5\ufd1d\u634c\ue9f5\u6a21\u904a") + this.odv + a.c(1851661904, "\u1e68\u63ce\ue91a\u771e\ufcb2\u7a09\uc05e\u4dbf\ud7ff\u5d4f\uda96\u2093\uae4b\u3781\ub9c6\u3b25\u8167\u0eca\u947b\u1229\u9bdf\ue183\u6b5e\uf087") + this.odw + a.d("\u9a2d\ue39b\u6946\uf308\u7880\ufe4f\u4410\ucde6\u53cc\ud971\u5ace\ua4a8\u2a7d\ub3c2\u39e6\ubf14\u0138\u8ee5\u1044\u9617\u1f90\u65be\uef12\u74cc\uf2bc\u7c08\uc5c0\u4b93\ud578\u5731\ud89a\u225b\ua819\u31e5\ub7c6\u3d72\u82d8\u08a9\u8a62\u17cb\u998c\ue36f\u6934\uee84\u7426\ufa5e\u43f2\ucd5b\u4f75\ud4d8\u5aa8\ua075\u29c0", -563519013, 606534634)), false);
            this.odx = true;
        }
        return true;
    }

    private boolean omf() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        return this.odd || this.getWorld() != this.ocz || clientPlayerEntity != this.oda || this.odb != null && clientPlayerEntity.getEntityPos().distanceTo(this.odb) > 48.0;
    }

    private boolean omg() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (clientPlayerEntity == null || this.getWorld() == null) {
            return false;
        }
        rzy rzy2 = this.ohz();
        if (rzy2 != null) {
            String string = this.oij();
            Vec3d vec3d = clientPlayerEntity.getEntityPos();
            for (rzv rzv2 : rzy2.getCachedTimers()) {
                if (rzv2.untimed || !string.equals(rzv2.dimension) || !(rzv2.pos.squaredDistanceTo(vec3d) < 10000.0)) continue;
                return true;
            }
        }
        return this.omv(2).size() >= 4 && pte.find(this.mc, clientPlayerEntity.getBlockPos(), 24, 8, a.b("\u9acc\ue30d\u69af\uf7a0\u7c08", -1748722040)) == null;
    }

    private void omh() {
        if (pqf.onClimbable((PlayerEntity)this.getPlayer()) && this.mc.options != null) {
            this.mc.options.sneakKey.setPressed(true);
        }
    }

    private void omi(String string) {
        this.getNetworkHandler().sendChatCommand(string);
        this.oau = true;
        ++this.ocx;
        this.oaw = this.getPlayer().getBlockPos();
        this.ocy = this.getWorld();
        this.oax = this.oas;
        this.oay = 0;
        if (this.oec == null) {
            this.oec = this.oaw;
            this.oed = this.ocy;
        }
    }

    private boolean omj() {
        return this.oaw != null && this.getPlayer().getBlockPos().getSquaredDistance((Vec3i)this.oaw) > 9.0;
    }

    private boolean omk() {
        return this.oec != null && (this.getWorld() != this.oed || this.getPlayer().getBlockPos().getSquaredDistance((Vec3i)this.oec) > 576.0);
    }

    private void oml(String string) {
        if (this.odu == null) {
            String string2 = this.odu = string == null ? "" : string;
            if (string != null) {
                this.notifyUser(string, true);
                if (this.nzg == 0 && (a.b("\u9f2b\ue6b2\u6c16\uf605\u79cf\uff76\u4522\uccd9\u528a\ud837\u5fe0\ua593\u2b3b\ub289\u38a0\uba49\u000b\u8fd7\u1179\u9725\u1ac2\u64f2\uea35\u71e8\uf79c", -517629137).equals(string) || a.d("\u9dc7\ue45e\u6efa\uf4e9\u7b2b\ufd9b\u47b7\uca2d\u547f\udec3\u5d0d\ua771\u2db6\ub066\u3a41\ubcbc\u06f8", 1084513386, 1839646113).equals(string))) {
                    this.omd(wap.t(string));
                }
            }
        }
        this.ohx();
        this.oab = null;
        this.oeu = null;
        this.ofb = null;
        this.ofc = 0;
        this.ohy(nwx.CHECK_PVP_COOLDOWN);
    }

    private void omm() {
        String string = nxa.ols(this.nyu.get(), a.c(-1081936808, "\uf43c\u8d82\u070d\u997d\u12a1"));
        if (!pjd.enter(this.ohu(), string)) {
            this.oly(a.c(37602478, "\uc090\ub90c\u37cf\uaddf\u267c\ua0c1\u1a99\u936f\u0925\u87f7Q\ufa23\u70e1\ue943\u6303\ue1ef\u5bad\ud404\u4ec7\uc8eb\u4579\u3f25\ub19b\u2e5c\ua821\u2295\u9b4b\u1106\u8fef\u09c7\u8206\u7ca2\uf698\u6f68\ue937"), this.nzh != null);
            return;
        }
        this.odf = "";
        pqf.resetKeys();
        this.getNetworkHandler().sendChatCommand(string);
        this.olv();
        this.ohw();
        this.oam = null;
        this.oap = 0;
        this.oeu = null;
        this.ohy(nwx.WARPING_TO_SAVE_BASE);
    }

    private void omn() {
        pqf.resetKeys();
        this.oot();
        this.omh();
        ++this.oas;
        if (this.omo() > 0) {
            this.oay = 0;
            return;
        }
        if (this.oas < 60) {
            return;
        }
        if (!this.oau) {
            if (this.olp(a.b("\u1827\u61e6\ueb44\u754b\ufee3", 1358765155)) != null) {
                this.ohy(nwx.RESTOCK);
                return;
            }
            if (this.oas < 80 + this.oat) {
                return;
            }
            this.omi(this.olu());
            return;
        }
        if (!this.omj() && this.oas - this.oax < 200) {
            return;
        }
        if (++this.oay >= 30) {
            this.ohy(nwx.RESTOCK);
        }
    }

    private int omo() {
        return pjn.teleportSeconds(this.mc, a.d("\u85a0\ufc06\u76db\ue8a4\u6379\ue5c9\u5fe4\ud617\u483a\uc2fd\u4550\ubf56\u35ee\ua838\u2219\ua49d\u1ea7\u9174\u0fca", -536219444, -1095208611));
    }

    private boolean omp() {
        return pjn.contains(this.mc, a.b("\u2c3c\u55ab\udf5e\u4152\ucee8\u482c\uf27c\u7b83\ue5d8\u6b75\ue8b6\u12cd\u9c62\u05a9\u8ff0\u0906\ub341", 1341402237));
    }

    private void omq(long l) {
        if (this.nzh == null) {
            this.nzh = this.getPlayer().getBlockPos();
        }
        if (this.odu != null) {
            this.oml(null);
            return;
        }
        if (this.oql() < 2) {
            this.oml(a.c(-458030342, "\u06fb\u7f6f\uf5b3\u6bc5\ue01a\u66d4\udcf5\u5574\ucb27\u45fa\uc636\u3c46\ub294\u2b20\ua170\u239c\u99de\u1602\u88ac\u0ef0\u8317\ufd27\u73e0\ue83d\u6e49"));
            return;
        }
        if ((double)this.nzg >= this.nyq.get()) {
            this.oml(a.b("\uec6d\u95be\u1f13\u816b\u0acb\u8c03\u3652\ubbbb\u2185\uab4b\u2c97\ud697\u5830\uc18c\u4ba9\uc933\u7371\ufcad\u6203\ue45f\u69b8\u1788\u994f\u0292\u84e6", -1627592619));
            return;
        }
        if (this.olb(true) < 100 && (this.oqg(true) == 0 || this.odt[0])) {
            this.oml(a.b("\u7028\u09b1\u8315\u1906\u96cc\u1075\uaa21\u23da\ubd89\u3734\ub0e3\u4a90\uc438\u5d8a\ud7a3\u554a\uef08\u60d4\ufe7a\u7826\uf5c1\u8bf1\u0536\u9eeb\u189f", 244085804));
            return;
        }
        if (this.getPlayer().getHungerManager().getFoodLevel() < 8 && this.oqh(Items.GOLDEN_CARROT) == 0) {
            this.oml(a.b("\u2fdd\u5644\udce0\u46f3\uc931\u4f81\uf5ad\u7837\ue665\u6cd9\uef17\u156b\u9fac\u027c\u885b\u0ea6\ub4e2", -2085344303));
            return;
        }
        if (this.oaa <= 0) {
            this.oaa = 5;
            nwq nwq2 = this.omw(l);
            if (nwq2 != null) {
                this.omr(nwq2);
                this.ohy(nwx.WAITING_FOR_CHEST);
                return;
            }
        }
        this.oms(l);
    }

    private void omr(nwq nwq2) {
        this.ohx();
        this.nzt = nwq2.timer();
        this.nzu = nwq2.chest();
        this.nzv = nwq2.tier();
        this.oab = null;
        this.ofb = null;
        this.ofc = 0;
        this.oaq = 0;
        this.oov();
    }

    private void oms(long l) {
        if (this.oab != null) {
            double d = this.getPlayer().getBlockPos().getSquaredDistance((Vec3i)this.oab);
            if (!this.olq(this.oab) || d <= 144.0) {
                this.omt();
                this.oab = null;
                this.ofb = null;
            }
        }
        if (this.oab == null && this.oac <= 0) {
            this.oac = 20;
            this.omu(l);
        }
        if (this.oab != null) {
            if (!this.opb() && !this.opc(this.oab, false) && this.ofd <= 0) {
                this.nzl.put(this.oab, l + 60000L);
                this.oab = null;
            }
            if (this.opb()) {
                this.opq();
            } else {
                pqf.resetKeys();
                this.oot();
            }
            return;
        }
        this.opi();
    }

    private void omt() {
        BlockPos blockPos = this.getPlayer().getBlockPos();
        for (BlockPos blockPos2 : this.omv(1)) {
            if (!(blockPos2.getSquaredDistance((Vec3i)blockPos) <= 196.0)) continue;
            this.nzk.add(blockPos2);
        }
    }

    private void omu(long l) {
        List<BlockPos> list;
        BlockPos blockPos = this.getPlayer().getBlockPos();
        this.omt();
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        for (BlockPos blockPos4 : this.omv(4)) {
            if (this.nzk.contains(blockPos4) || (list = this.nzl.get(blockPos4)) != null && (Long)((Object)list) > l || this.nzh != null && blockPos4.getSquaredDistance((Vec3i)this.nzh) > 14400.0 || this.ont(blockPos4, 7.0)) continue;
            arrayList.add(blockPos4);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.sort((blockPos2, blockPos3) -> Double.compare(blockPos2.getSquaredDistance((Vec3i)blockPos), blockPos3.getSquaredDistance((Vec3i)blockPos)));
        for (int i = 0; i < Math.min(2, arrayList.size()); ++i) {
            BlockPos blockPos4;
            blockPos4 = (BlockPos)arrayList.get(i);
            list = this.opd(blockPos4);
            if (list != null && !list.isEmpty()) {
                this.oab = blockPos4;
                this.opf(list);
                return;
            }
            this.nzl.put(blockPos4, l + 60000L);
        }
    }

    private List<BlockPos> omv(int n) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        if (this.mc.world == null) {
            return arrayList;
        }
        BlockPos blockPos = this.getPlayer().getBlockPos();
        int n2 = blockPos.getX() >> 4;
        int n3 = blockPos.getZ() >> 4;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                WorldChunk worldChunk = this.mc.world.getChunkManager().getWorldChunk(n2 + i, n3 + j, false);
                if (worldChunk == null) continue;
                for (BlockEntity blockEntity : worldChunk.getBlockEntities().values()) {
                    if (!(blockEntity instanceof ChestBlockEntity) || Math.abs(blockEntity.getPos().getY() - blockPos.getY()) > 16) continue;
                    arrayList.add(blockEntity.getPos());
                }
            }
        }
        return arrayList;
    }

    private nwq omw(long l) {
        rzy rzy2 = this.ohz();
        if (rzy2 == null) {
            return null;
        }
        String string = this.oij();
        Vec3d vec3d = this.getPlayer().getEyePos();
        nwq nwq2 = null;
        for (rzv rzv2 : rzy2.getCachedTimers()) {
            int n;
            Long l2;
            Long l3;
            BlockPos blockPos;
            if (!string.equals(rzv2.dimension) || (blockPos = this.onc(rzv2)) == null || (l3 = this.nzj.get(blockPos)) != null && l3 > l || (l2 = this.nzi.get(blockPos)) != null && rzv2.lastNumericUpdate <= l2 + 1500L || this.nzh != null && blockPos.getSquaredDistance((Vec3i)this.nzh) > 14400.0) continue;
            long l4 = nxa.omx(rzv2, l);
            boolean bl = l4 <= 0L;
            double d = vec3d.squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos));
            if (bl && d <= 25.0) {
                n = 0;
            } else if (!bl && l4 <= 5000L && d <= 144.0) {
                n = 1;
            } else if (bl && d <= 144.0) {
                n = 2;
            } else if (!bl && l4 <= 15000L && d <= 625.0) {
                n = 3;
            } else if (bl) {
                n = 4;
            } else {
                if (l4 > 30000L) continue;
                n = 5;
            }
            if (this.ont(blockPos, 7.0) || this.onv(blockPos)) continue;
            double d2 = (double)blockPos.getY() + 0.5 - vec3d.y;
            double d3 = (double)blockPos.getX() + 0.5 - this.getPlayer().getX();
            double d4 = (double)blockPos.getZ() + 0.5 - this.getPlayer().getZ();
            double d5 = d3 * d3 + d4 * d4 + (d2 > 0.0 ? 2.0 : 1.0) * d2 * d2;
            if (nwq2 != null && n >= nwq2.tier() && (n != nwq2.tier() || !(d5 < nwq2.score()))) continue;
            nwq2 = new nwq(rzv2, blockPos, n, d5);
        }
        if (nwq2 != null && this.onj(nwq2.chest()) == null) {
            this.nzj.put(nwq2.chest(), l + 20000L);
            return null;
        }
        return nwq2;
    }

    private static long omx(rzv rzv2, long l) {
        return rzv2.isReady ? -1L : rzv2.expirationTime - l;
    }

    private void omy(long l) {
        BlockPos blockPos2;
        rzy rzy2 = this.ohz();
        if (rzy2 == null || this.nzn == 0L || l - this.nzn < 3000L) {
            return;
        }
        String string = this.oij();
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        for (rzv rzv3 : rzy2.getCachedTimers()) {
            BlockPos blockPos3;
            if (rzv3.untimed || !string.equals(rzv3.dimension) || (blockPos3 = this.onc(rzv3)) == null) continue;
            hashSet.add(blockPos3);
            blockPos2 = this.ona(blockPos3);
            if (blockPos2 == null) continue;
            hashSet.add(blockPos2);
        }
        rzy2.getCachedTimers().removeIf(rzv2 -> {
            if (!rzv2.untimed || !string.equals(rzv2.dimension)) {
                return false;
            }
            BlockPos blockPos = this.onc((rzv)rzv2);
            return blockPos == null || hashSet.contains(blockPos);
        });
        Vec3d vec3d = this.getPlayer().getEyePos();
        double d = 196.0;
        blockPos2 = new HashSet();
        for (BlockPos blockPos4 : this.omv(1)) {
            long l2;
            BlockPos blockPos5;
            if (vec3d.squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos4)) > d || hashSet.contains(blockPos4) || !blockPos2.add(blockPos5 = this.onb(blockPos4)) || l - (l2 = this.nzm.computeIfAbsent(blockPos5, blockPos -> l).longValue()) < 250L || this.omz(blockPos5, l) || this.nzh != null && blockPos5.getSquaredDistance((Vec3i)this.nzh) > 14400.0) continue;
            rzy2.markUntimedReady(blockPos5, string);
        }
        this.nzm.keySet().retainAll((Collection<?>)blockPos2);
    }

    private boolean omz(BlockPos blockPos, long l) {
        Long l2 = this.nzi.get(blockPos);
        if (l2 != null && l - l2 < 600000L) {
            return true;
        }
        BlockPos blockPos2 = this.ona(blockPos);
        Long l3 = blockPos2 == null ? null : this.nzi.get(blockPos2);
        return l3 != null && l - l3 < 600000L;
    }

    private BlockPos ona(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return null;
        }
        BlockState blockState = this.getWorld().getBlockState(blockPos);
        if (!(blockState.getBlock() instanceof ChestBlock) || blockState.get((Property)ChestBlock.CHEST_TYPE) == ChestType.SINGLE) {
            return null;
        }
        BlockPos blockPos2 = blockPos.offset(ChestBlock.getFacing((BlockState)blockState));
        return this.olq(blockPos2) ? blockPos2 : null;
    }

    private BlockPos onb(BlockPos blockPos) {
        BlockPos blockPos2 = this.ona(blockPos);
        if (blockPos2 == null) {
            return blockPos;
        }
        return blockPos2.asLong() < blockPos.asLong() ? blockPos2 : blockPos;
    }

    private BlockPos onc(rzv rzv2) {
        BlockPos blockPos = BlockPos.ofFloored((double)rzv2.pos.x, (double)rzv2.pos.y, (double)rzv2.pos.z);
        for (int i = 0; i >= -3; --i) {
            if (this.olq(blockPos.add(0, i, 0))) {
                return blockPos.add(0, i, 0);
            }
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    BlockPos blockPos2 = blockPos.add(j, i, k);
                    if (!this.olq(blockPos2)) continue;
                    return blockPos2;
                }
            }
        }
        return null;
    }

    private boolean ond(long l) {
        return this.nzb == nwx.WAITING_FOR_CHEST && this.nzt != null && nxa.omx(this.nzt, l) < 3500L && this.nzw != null && this.oni();
    }

    private void one(long l) {
        nwq nwq2;
        rzy rzy2 = this.ohz();
        rzv rzv2 = this.nzt;
        BlockPos blockPos = this.nzu;
        if (rzv2 == null || blockPos == null || rzy2 == null || !rzy2.getCachedTimers().contains(rzv2) || !this.olq(blockPos)) {
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        long l2 = nxa.omx(rzv2, l);
        if (l2 > 31000L) {
            this.nzi.put(blockPos, l);
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        if (this.ont(blockPos, 7.0) || this.onv(blockPos)) {
            this.nzj.put(blockPos, l + 20000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        if (this.oaa <= 0 && l2 > 4000L) {
            this.oaa = 10;
            nwq2 = this.omw(l);
            if (nwq2 != null && !nwq2.chest().equals((Object)blockPos) && nwq2.tier() < this.nzv) {
                this.omr(nwq2);
                return;
            }
        }
        if (this.nzw == null || !this.onk(this.nzw)) {
            this.nzw = this.onj(blockPos);
            this.ofb = null;
            if (this.nzw == null) {
                this.nzj.put(blockPos, l + 20000L);
                this.ohx();
                this.ohy(nwx.EXPLORING);
                return;
            }
        }
        if (!this.oni()) {
            this.ong(blockPos, l);
            return;
        }
        this.nzx = 0;
        this.ofb = null;
        this.ofc = 0;
        pqf.resetKeys();
        nwq2 = this.onl(blockPos);
        if (nwq2 == null) {
            this.nzw = null;
            return;
        }
        boolean bl = this.onf(rzv2, l2, l);
        if (!bl && l2 > 2500L) {
            if (!this.onh()) {
                this.oop((Vec3d)nwq2);
            }
            return;
        }
        this.oad = 0;
        if (this.oli(this.getPlayer().getMainHandStack())) {
            this.olj();
        }
        this.ooq(blockPos, (Vec3d)nwq2);
        if (!bl) {
            return;
        }
        this.ono(blockPos, nwg.LOOT, l);
        if (this.nzy > 4) {
            this.nzj.put(blockPos, l + (rzv2.untimed ? 180000L : 25000L));
            this.ohx();
            this.ohy(nwx.EXPLORING);
        }
    }

    private boolean onf(rzv rzv2, long l, long l2) {
        if (l > 1000L) {
            return false;
        }
        if (!rzv2.countdownShown(l2)) {
            return true;
        }
        return rzv2.zeroShownMs(l2) > 10000L;
    }

    private void ong(BlockPos blockPos, long l) {
        boolean bl;
        if (++this.nzx > this.oid(400)) {
            this.nzj.put(blockPos, l + 30000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
            return;
        }
        Vec3d vec3d = new Vec3d((double)this.nzw.getX() + 0.5, pqf.getStandY(this.nzw), (double)this.nzw.getZ() + 0.5);
        double d = Math.hypot(vec3d.x - this.getPlayer().getX(), vec3d.z - this.getPlayer().getZ());
        double d2 = vec3d.y - this.getPlayer().getY();
        boolean bl2 = d < 5.0 && d2 > -1.6 && d2 < 1.2 && (Math.abs(d2) < 0.6 ? this.opt(vec3d) : this.opu(vec3d)) ? true : (bl = false);
        if (bl) {
            this.ofb = null;
            this.opo(vec3d, true);
            if (d < 2.0) {
                this.mc.options.sprintKey.setPressed(false);
            }
            return;
        }
        if (!this.opb()) {
            this.opc(this.nzw, false);
        }
        if (this.opb()) {
            Vec3d vec3d2 = this.onl(blockPos);
            double d3 = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos));
            if (!this.ohb && vec3d2 != null && d3 <= 25.0 && this.opt(vec3d)) {
                this.ohb = true;
            }
            if (this.ohb && vec3d2 != null) {
                this.oha = vec3d2;
            }
            this.opq();
        } else {
            pqf.resetKeys();
            this.oot();
        }
    }

    private boolean onh() {
        if (this.oad > 0) {
            --this.oad;
            if (this.oaf != null) {
                this.oop(this.oaf);
            }
            return true;
        }
        if (this.oae > 0) {
            --this.oae;
            return false;
        }
        this.oae = 60 + this.nzf.nextInt(80);
        this.oad = 10 + this.nzf.nextInt(16);
        double d = Math.toRadians((double)this.ogv + 90.0 + (this.nzf.nextDouble() - 0.5) * 140.0);
        double d2 = 6.0 + this.nzf.nextDouble() * 8.0;
        Vec3d vec3d = this.getPlayer().getEyePos();
        this.oaf = new Vec3d(vec3d.x + Math.cos(d) * d2, vec3d.y + (this.nzf.nextDouble() - 0.6) * 3.0, vec3d.z + Math.sin(d) * d2);
        return true;
    }

    private boolean oni() {
        if (this.nzw == null) {
            return false;
        }
        double d = this.getPlayer().getX() - ((double)this.nzw.getX() + 0.5);
        double d2 = this.getPlayer().getZ() - ((double)this.nzw.getZ() + 0.5);
        double d3 = this.getPlayer().getY() - pqf.getStandY(this.nzw);
        double d4 = d * d + d2 * d2;
        if (!this.getPlayer().isOnGround() || Math.abs(d3) > 0.6) {
            return false;
        }
        if (d4 < 0.36) {
            return true;
        }
        return d4 < 2.25 && this.nzu != null && this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)this.nzu)) <= 15.0 && this.onl(this.nzu) != null;
    }

    private BlockPos onj(BlockPos blockPos) {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        double d = this.getPlayer().getEyeHeight(EntityPose.STANDING);
        Vec3d vec3d = Vec3d.ofCenter((Vec3i)blockPos);
        Vec3d vec3d2 = this.getPlayer().getEntityPos();
        BlockPos blockPos2 = null;
        double d2 = Double.MAX_VALUE;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -2; k <= 2; ++k) {
                    BlockPos blockPos3;
                    if (j == 0 && k == 0 && i != 1 || !this.onk(blockPos3 = blockPos.add(j, i, k)) || this.ont(blockPos3, 7.0)) continue;
                    double d3 = pqf.getStandY(blockPos3);
                    Vec3d vec3d3 = new Vec3d((double)blockPos3.getX() + 0.5, d3 + d, (double)blockPos3.getZ() + 0.5);
                    if (vec3d3.squaredDistanceTo(vec3d) > 12.9 || this.onm(vec3d3, blockPos) == null) continue;
                    double d4 = Math.max(Math.abs(j), Math.abs(k));
                    double d5 = Math.sqrt(vec3d2.squaredDistanceTo(Vec3d.ofBottomCenter((Vec3i)blockPos3))) + (d4 > 1.0 ? 1.2 : 0.0) + (i != 0 ? 0.8 : 0.0) + (j == 0 && k == 0 ? 1.5 : 0.0);
                    if (!(d5 < d2)) continue;
                    d2 = d5;
                    blockPos2 = blockPos3;
                }
            }
        }
        return blockPos2;
    }

    private boolean onk(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return false;
        }
        return this.getWorld().getBlockState(blockPos).getCollisionShape((BlockView)this.getWorld(), blockPos).isEmpty() && this.getWorld().getBlockState(blockPos.up()).getCollisionShape((BlockView)this.getWorld(), blockPos.up()).isEmpty() && !this.getWorld().getBlockState(blockPos.down()).getCollisionShape((BlockView)this.getWorld(), blockPos.down()).isEmpty();
    }

    private Vec3d onl(BlockPos blockPos) {
        return this.onm(this.getPlayer().getEyePos(), blockPos);
    }

    private Vec3d onm(Vec3d vec3d, BlockPos blockPos) {
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos).add(0.0, -0.06, 0.0);
        Vec3d vec3d3 = vec3d2.add(this.ohf, this.ohg * 0.6, this.ohh);
        if (this.onn(vec3d, vec3d3, blockPos)) {
            return vec3d3;
        }
        Vec3d vec3d4 = null;
        double d = Double.MAX_VALUE;
        for (double d2 = -0.3; d2 <= 0.31; d2 += 0.3) {
            for (double d3 = -0.3; d3 <= 0.31; d3 += 0.3) {
                for (double d4 = -0.3; d4 <= 0.31; d4 += 0.3) {
                    Vec3d vec3d5 = vec3d2.add(d2, d3, d4);
                    double d5 = vec3d5.squaredDistanceTo(vec3d2);
                    if (!(d5 < d) || !this.onn(vec3d, vec3d5, blockPos)) continue;
                    d = d5;
                    vec3d4 = vec3d5;
                }
            }
        }
        return vec3d4;
    }

    private boolean onn(Vec3d vec3d, Vec3d vec3d2, BlockPos blockPos) {
        BlockHitResult blockHitResult = this.getWorld().raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
        return blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)blockPos);
    }

    private void ono(BlockPos blockPos, nwg nwg2, long l) {
        BlockHitResult blockHitResult;
        if (this.mc.currentScreen != null) {
            return;
        }
        this.ohk = true;
        this.ohl = this.nzd;
        BlockHitResult blockHitResult2 = this.opa(blockPos);
        this.oos(blockHitResult2 != null);
        boolean bl = false;
        if (blockHitResult2 != null) {
            this.oaq = 0;
            if (this.ohe > 0) {
                --this.ohe;
            } else if (l - this.oar > this.nzz) {
                bl = true;
            }
        } else if (++this.oaq > 40 && l - this.oar > this.nzz && this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter((Vec3i)blockPos)) < 16.0 && (blockHitResult = this.onq(blockPos)) != null) {
            ptr.later(() -> {
                if (this.mc.interactionManager != null && this.mc.player != null && this.mc.currentScreen == null) {
                    this.mc.interactionManager.interactBlock(this.mc.player, Hand.MAIN_HAND, blockHitResult);
                    this.mc.player.swingHand(Hand.MAIN_HAND);
                }
            });
            this.onp(blockPos, nwg2, l);
        }
        if (bl) {
            this.onp(blockPos, nwg2, l);
        }
        this.mc.options.useKey.setPressed(bl);
        this.mc.options.sneakKey.setPressed(false);
    }

    private void onp(BlockPos blockPos, nwg nwg2, long l) {
        this.oar = l;
        this.nzz = 550L + (long)this.nzf.nextInt(450);
        ++this.nzy;
        this.ojg(blockPos, nwg2, l);
    }

    private BlockHitResult onq(BlockPos blockPos) {
        Vec3d vec3d = this.getPlayer().getEyePos();
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        BlockHitResult blockHitResult = this.getWorld().raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
        if (blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)blockPos)) {
            return blockHitResult;
        }
        if (this.oaq <= 80) {
            return null;
        }
        Direction direction = Direction.getFacing((double)(vec3d.x - vec3d2.x), (double)(vec3d.y - vec3d2.y), (double)(vec3d.z - vec3d2.z));
        Vec3d vec3d3 = vec3d2.add((double)direction.getOffsetX() * 0.5, (double)direction.getOffsetY() * 0.5, (double)direction.getOffsetZ() * 0.5);
        return new BlockHitResult(vec3d3, direction, blockPos, false);
    }

    private void onr() {
        if (this.mc.world == null) {
            return;
        }
        boolean bl = false;
        for (Entity entity : this.mc.world.getEntities()) {
            WardenEntity wardenEntity;
            if (!(entity instanceof WardenEntity) || !(wardenEntity = (WardenEntity)entity).isAlive() || this.nzp.put(wardenEntity.getBlockPos(), this.nzd + 100) != null) continue;
            bl = true;
        }
        if (this.nzp.values().removeIf(n -> n < this.nzd)) {
            bl = true;
        }
        if (this.nzp.size() > 256) {
            this.nzp.clear();
            bl = true;
        }
        if (bl) {
            this.nzq = new ArrayList<BlockPos>(this.nzp.keySet());
        }
    }

    private List<BlockPos> ons() {
        return this.nzq;
    }

    private boolean ont(BlockPos blockPos, double d) {
        double d2 = d * d;
        for (BlockPos blockPos2 : this.nzp.keySet()) {
            if (!(blockPos2.getSquaredDistance((Vec3i)blockPos) < d2)) continue;
            return true;
        }
        return false;
    }

    private WardenEntity onu(double d) {
        if (this.mc.world == null) {
            return null;
        }
        WardenEntity wardenEntity = null;
        double d2 = d * d;
        for (Entity entity : this.mc.world.getEntities()) {
            double d3;
            WardenEntity wardenEntity2;
            if (!(entity instanceof WardenEntity) || !(wardenEntity2 = (WardenEntity)entity).isAlive() || !((d3 = wardenEntity2.squaredDistanceTo((Entity)this.getPlayer())) < d2)) continue;
            d2 = d3;
            wardenEntity = wardenEntity2;
        }
        return wardenEntity;
    }

    private boolean onv(BlockPos blockPos) {
        Vec3d vec3d = Vec3d.ofCenter((Vec3i)blockPos);
        for (PlayerEntity playerEntity : this.mc.world.getPlayers()) {
            if (playerEntity == this.getPlayer() || playerEntity.squaredDistanceTo(vec3d) >= 20.0 || !nxa.onw(playerEntity.getEquippedStack(EquipmentSlot.HEAD)) && !nxa.onw(playerEntity.getEquippedStack(EquipmentSlot.CHEST)) && !nxa.onw(playerEntity.getEquippedStack(EquipmentSlot.LEGS)) && !nxa.onw(playerEntity.getEquippedStack(EquipmentSlot.FEET))) continue;
            return true;
        }
        return false;
    }

    private static boolean onw(ItemStack itemStack) {
        return !itemStack.isEmpty() && (itemStack.isIn(ItemTags.HEAD_ARMOR) || itemStack.isIn(ItemTags.CHEST_ARMOR) || itemStack.isIn(ItemTags.LEG_ARMOR) || itemStack.isIn(ItemTags.FOOT_ARMOR));
    }

    private boolean onx() {
        boolean bl = System.currentTimeMillis() - this.nzr < 5000L;
        PlayerEntity playerEntity = this.mc.world.getEntities().iterator();
        while (playerEntity.hasNext()) {
            double d;
            WardenEntity wardenEntity;
            Entity entity = (Entity)playerEntity.next();
            if (!(entity instanceof WardenEntity) || !(wardenEntity = (WardenEntity)entity).isAlive() || !((d = wardenEntity.squaredDistanceTo((Entity)this.getPlayer())) < 36.0) && (!bl || !(d < 900.0) || !this.ony(wardenEntity) || !(d < 64.0) && !this.onz(wardenEntity))) continue;
            this.ooa(true);
            return true;
        }
        if (this.getPlayer().hasStatusEffect(StatusEffects.GLOWING) && (playerEntity = this.ooh()) != null && playerEntity.squaredDistanceTo((Entity)this.getPlayer()) < 576.0) {
            this.ooa(false);
            return true;
        }
        return false;
    }

    private boolean ony(WardenEntity wardenEntity) {
        double d = Math.toDegrees(Math.atan2(-(this.getPlayer().getX() - wardenEntity.getX()), this.getPlayer().getZ() - wardenEntity.getZ()));
        return Math.abs(MathHelper.wrapDegrees((double)((double)wardenEntity.getBodyYaw() - d))) < 30.0;
    }

    private boolean onz(WardenEntity wardenEntity) {
        return (this.getPlayer().getX() - wardenEntity.getX()) * (wardenEntity.getX() - wardenEntity.lastX) + (this.getPlayer().getZ() - wardenEntity.getZ()) * (wardenEntity.getZ() - wardenEntity.lastZ) > 0.01;
    }

    private void ooa(boolean bl) {
        if (this.nzb == nwx.ESCAPING) {
            return;
        }
        this.oex = bl;
        this.oev = 0;
        this.oew = 0;
        this.oey = 0;
        this.ofb = null;
        this.ofc = 0;
        this.ofd = 0;
        this.olh();
        this.ohx();
        this.oab = null;
        this.ohy(nwx.ESCAPING);
    }

    private void oob() {
        boolean bl;
        double d;
        ++this.oev;
        this.mc.options.attackKey.setPressed(false);
        this.olh();
        PlayerEntity playerEntity = this.oex ? this.onu(48.0) : this.ooh();
        double d2 = playerEntity != null ? playerEntity.squaredDistanceTo((Entity)this.getPlayer()) : Double.MAX_VALUE;
        double d3 = d = this.oex ? 576.0 : 1600.0;
        if (this.oev > 30 && d2 > d || this.oev > 240) {
            pqf.resetKeys();
            this.ofb = null;
            boolean bl2 = this.odu != null || (double)this.nzg >= this.nyq.get() || this.oql() < 2;
            this.ohy(bl2 ? nwx.CHECK_PVP_COOLDOWN : nwx.EXPLORING);
            this.oaa = 0;
            return;
        }
        boolean bl3 = bl = !this.opb() || this.oev % 25 == 0;
        if (playerEntity != null && bl && this.ofd <= 0) {
            this.ofd = 10;
            this.ood(playerEntity.getEntityPos());
        }
        if (this.opb()) {
            this.opq();
        } else if (playerEntity != null) {
            Vec3d vec3d = nxa.ooc(this.getPlayer().getEntityPos().subtract(playerEntity.getEntityPos()).normalize(), Math.toRadians(nyh[this.oew]));
            Vec3d vec3d2 = this.getPlayer().getEntityPos().add(vec3d.multiply(12.0));
            this.opn(new Vec3d(vec3d2.x, this.getPlayer().getY(), vec3d2.z));
        } else {
            this.oot();
            this.ohq = true;
            this.mc.options.forwardKey.setPressed(true);
            pyd.setSprint(this.mc.options, true);
        }
    }

    private static Vec3d ooc(Vec3d vec3d, double d) {
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        return new Vec3d(vec3d.x * d2 - vec3d.z * d3, 0.0, vec3d.x * d3 + vec3d.z * d2).normalize();
    }

    private void ood(Vec3d vec3d) {
        Vec3d vec3d2 = this.getPlayer().getEntityPos().subtract(vec3d).normalize();
        BlockPos blockPos = this.getPlayer().getBlockPos();
        for (int i = 0; i < 2; ++i) {
            int n = (this.oew + i) % nyh.length;
            double d = (double)nyh[n] + this.nzf.nextGaussian() * 12.0;
            Vec3d vec3d3 = nxa.ooc(vec3d2, Math.toRadians(d));
            double d2 = 22.0 + this.nzf.nextDouble() * 12.0;
            BlockPos blockPos2 = this.ooe(this.oph(blockPos.add((int)(vec3d3.x * d2), 0, (int)(vec3d3.z * d2))));
            List<BlockPos> list = this.opd(blockPos2);
            if (list == null || list.size() < 5) continue;
            this.opf(list);
            this.oew = n;
            return;
        }
        this.oew = (this.oew + 3) % nyh.length;
        this.ofb = null;
        this.ofc = 0;
    }

    private BlockPos ooe(BlockPos blockPos) {
        double d;
        double d2;
        if (this.nzh == null) {
            return blockPos;
        }
        double d3 = blockPos.getX() - this.nzh.getX();
        double d4 = Math.hypot(d3, d2 = (double)(blockPos.getZ() - this.nzh.getZ()));
        if (d4 <= (d = 100.0)) {
            return blockPos;
        }
        double d5 = d / d4;
        return this.oph(new BlockPos(this.nzh.getX() + (int)(d3 * d5), blockPos.getY(), this.nzh.getZ() + (int)(d2 * d5)));
    }

    private void oof() {
        if (this.nzd - this.oek > 60) {
            ++this.nze;
            this.oeu = null;
            this.ohy(nwx.TELEPORT_TO_SAVE);
            return;
        }
        this.oog();
    }

    private void oog() {
        PlayerEntity playerEntity = this.ooh();
        BlockPos blockPos = this.getPlayer().getBlockPos();
        if (this.ofd <= 0) {
            if (playerEntity != null && (this.oeu == null || this.oeu.getSquaredDistance((Vec3i)blockPos) < 10.0 || playerEntity.squaredDistanceTo((Entity)this.getPlayer()) < 400.0)) {
                Vec3d vec3d = nxa.ooc(this.getPlayer().getEntityPos().subtract(playerEntity.getEntityPos()).normalize(), Math.toRadians(this.nzf.nextGaussian() * 20.0));
                double d = 24.0 + this.nzf.nextDouble() * 14.0;
                this.oeu = this.ooe(this.oph(blockPos.add((int)(vec3d.x * d), 0, (int)(vec3d.z * d))));
                this.ofd = 10;
                this.opf(this.opd(this.oeu));
            } else if (!(playerEntity != null || this.oeu != null && !(this.oeu.getSquaredDistance((Vec3i)blockPos) < 4.0) || this.oeu != null && this.nzf.nextInt(120) != 0)) {
                double d = this.nzf.nextDouble() * Math.PI * 2.0;
                double d2 = 12.0 + this.nzf.nextDouble() * 14.0;
                this.oeu = this.ooe(this.oph(blockPos.add((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2))));
                this.ofd = 10;
                this.opf(this.opd(this.oeu));
            }
        }
        if (this.opb()) {
            this.opq();
        } else {
            pqf.resetKeys();
            this.oot();
        }
    }

    private PlayerEntity ooh() {
        PlayerEntity playerEntity = null;
        double d = 2500.0;
        for (PlayerEntity playerEntity2 : this.mc.world.getPlayers()) {
            double d2;
            if (playerEntity2 == this.getPlayer() || !((d2 = playerEntity2.squaredDistanceTo((Entity)this.getPlayer())) < d)) continue;
            d = d2;
            playerEntity = playerEntity2;
        }
        return playerEntity;
    }

    private void ooi() {
        this.ogx = this.getPlayer();
        if (this.ogx != null) {
            this.ool(this.ogx);
            this.ogl.reset(this.ogx.getYaw(), this.ogx.getPitch());
            this.ogv = this.ogx.getYaw();
            this.ogw = this.ogx.getPitch();
            this.ogy = this.ogx.getEntityPos();
        }
        this.ogn = false;
        this.ogo = false;
        this.ohn = false;
        this.oho = false;
        this.ohp = false;
        this.nzn = System.currentTimeMillis();
    }

    private void ooj() {
        ptr.clear();
        if (this.ogn) {
            this.ogn = false;
            if (this.driver == null && this.ogm.ownedBy(this)) {
                this.ogm.release(this.mc.player);
            }
        }
    }

    private void ook() {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        if (clientPlayerEntity == null) {
            return;
        }
        boolean bl2 = bl = this.ogx != clientPlayerEntity || this.ogy == null || clientPlayerEntity.getEntityPos().squaredDistanceTo(this.ogy) > 400.0;
        if (bl) {
            this.nzn = System.currentTimeMillis();
            this.nzm.clear();
            if (this.driver == null) {
                this.ogm.reset();
            }
            if (this.ogx != clientPlayerEntity) {
                this.ool((PlayerEntity)clientPlayerEntity);
            }
            this.ogl.reset(clientPlayerEntity.getYaw(), clientPlayerEntity.getPitch());
            this.ogv = clientPlayerEntity.getYaw();
            this.ogw = clientPlayerEntity.getPitch();
            this.ogx = clientPlayerEntity;
            this.ogn = false;
            this.ofb = null;
            this.ofc = 0;
            this.off = null;
            this.ofe.reset();
        }
        this.ogy = clientPlayerEntity.getEntityPos();
    }

    private void ool(PlayerEntity playerEntity) {
        String string = playerEntity.getGameProfile() != null ? playerEntity.getGameProfile().name() : null;
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        this.ogl.personalize(l);
        this.ofe.personalize(l);
    }

    private void oom(float f, float f2) {
        this.oon(f, f2, false);
    }

    private void oon(float f, float f2, boolean bl) {
        this.ogs = f;
        this.ogt = f2;
        this.ogq = bl;
        this.ogr = false;
        this.ogu = 0.0;
        this.ogo = true;
        this.ogp = false;
    }

    private void ooo(Vec3d vec3d) {
        float[] fArray = prt.calculateAngle(vec3d);
        this.oon(fArray[0], fArray[1], false);
    }

    private void oop(Vec3d vec3d) {
        float[] fArray = prt.calculateAngle(vec3d);
        this.oon(fArray[0], fArray[1], true);
    }

    private void ooq(BlockPos blockPos, Vec3d vec3d) {
        this.ooo(vec3d);
        this.ogu = this.ohc ? 0.25 : this.oor(blockPos, vec3d);
    }

    private double oor(BlockPos blockPos, Vec3d vec3d) {
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

    private void oos(boolean bl) {
        if (bl || this.ogl.isMoving()) {
            this.ohd = 0;
            return;
        }
        if (++this.ohd >= 3) {
            this.ohc = true;
        }
    }

    private void oot() {
        if (!this.ogo) {
            this.ogp = true;
        }
    }

    private void oou() {
        float f = this.ogl.intentPitch();
        if (Math.abs(f - this.ocv) > 6.0f) {
            this.oon(this.ogl.intentYaw(), this.ocv, true);
        } else {
            this.oot();
        }
    }

    private void oov() {
        this.ohb = false;
        this.ohc = false;
        this.ohd = 0;
        this.ohf = (this.nzf.nextDouble() - 0.5) * 0.3;
        this.ohg = (this.nzf.nextDouble() - 0.5) * 0.36;
        this.ohh = (this.nzf.nextDouble() - 0.5) * 0.3;
        this.ohe = 1 + this.nzf.nextInt(4);
    }

    private float oow() {
        return (float)this.ofe.moveYaw(this.ogv);
    }

    private void oox() {
        if (this.getPlayer() == null) {
            return;
        }
        this.ofk = this.ogo && !this.ogq;
        boolean bl = this.ofe.takeTurn(this.ofl);
        if (this.oib() && !this.ofk) {
            this.ooy();
            return;
        }
        if (this.mc.currentScreen == null) {
            this.ogl.setMouseStep(this.driver != null ? this.driver.mouseStep() : prp.step());
            if (this.obw || this.ocf) {
                this.ogl.freeze();
            } else if (this.ogo) {
                if (this.ogq && this.ogr) {
                    this.ogl.aimTight(this.ogs, this.ogt);
                } else if (this.ogq) {
                    this.ogl.aimRelaxed(this.ogs, this.ogt);
                } else {
                    this.ogl.aim(this.ogs, this.ogt, this.ogu);
                }
            } else if (bl) {
                this.ogl.turn(this.ofl[0], this.ofl[1]);
            } else if (this.ogp) {
                this.ogl.hold();
            } else {
                this.ogl.idle();
            }
            this.ogv = this.ogl.getYaw();
            this.ogw = this.ogl.getPitch();
        }
        this.ogo = false;
        this.ogp = false;
        if (this.driver != null) {
            if (this.mc.currentScreen == null) {
                this.driver.look(this.ogv, MathHelper.clamp((float)this.ogw, (float)-90.0f, (float)90.0f));
            }
        } else {
            this.ogm.set(this, this.ogv, MathHelper.clamp((float)this.ogw, (float)-90.0f, (float)90.0f));
        }
        this.ogn = true;
        if (this.mc.currentScreen != null) {
            ptr.clear();
        } else if (this.ogz != null) {
            ptr.aimAt(this.ogz, this.ogv, this.ogw);
        }
        this.ogz = null;
    }

    private void ooy() {
        this.ogo = false;
        this.ogp = false;
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        this.ogl.reset(clientPlayerEntity.getYaw(), clientPlayerEntity.getPitch());
        this.ogv = clientPlayerEntity.getYaw();
        this.ogw = clientPlayerEntity.getPitch();
        if (this.ogn) {
            this.ogn = false;
            if (this.ogm.ownedBy(this)) {
                this.ogm.release(this.mc.player);
            }
        }
        if (this.mc.currentScreen != null) {
            ptr.clear();
        } else if (this.ogz != null) {
            ptr.aimAt(this.ogz, this.ogv, this.ogw);
        }
        this.ogz = null;
    }

    private BlockHitResult ooz() {
        if (this.getWorld() == null || this.getPlayer() == null) {
            return null;
        }
        Vec3d vec3d = this.getPlayer().getEyePos();
        Vec3d vec3d2 = Vec3d.fromPolar((float)this.ogw, (float)this.ogv);
        double d = 4.5;
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d, vec3d2.y * d, vec3d2.z * d);
        return this.getWorld().raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)this.getPlayer()));
    }

    private BlockHitResult opa(BlockPos blockPos) {
        BlockHitResult blockHitResult = this.ooz();
        if (blockHitResult != null && blockHitResult.getType() == HitResult.Type.BLOCK && blockHitResult.getBlockPos().equals((Object)blockPos)) {
            this.ogz = blockPos;
            return blockHitResult;
        }
        return null;
    }

    private boolean opb() {
        return this.ofb != null && this.ofc < this.ofb.size();
    }

    private boolean opc(BlockPos blockPos, boolean bl) {
        if (blockPos == null) {
            return false;
        }
        if (!bl && this.ofd > 0) {
            return this.opb();
        }
        this.ofd = 8;
        this.opf(this.opd(blockPos));
        return this.ofb != null && !this.ofb.isEmpty();
    }

    private List<BlockPos> opd(BlockPos blockPos) {
        this.ofq = blockPos;
        this.ofr = this.ope();
        if (this.ofg == null || !blockPos.equals((Object)this.ofh)) {
            this.ofg = pqq.random(this.nzf);
            this.ofh = blockPos;
        }
        return pqx.findPath((BlockView)this.getWorld(), (Entity)this.getPlayer(), this.ofr, blockPos, this.ons(), 7.0, true, this.oix(), this.ofg);
    }

    private BlockPos ope() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        BlockPos blockPos = BlockPos.ofFloored((double)clientPlayerEntity.getX(), (double)(clientPlayerEntity.getY() + 0.001), (double)clientPlayerEntity.getZ());
        if (!this.opz(blockPos)) {
            blockPos = blockPos.up();
        }
        if (!clientPlayerEntity.isOnGround() && !clientPlayerEntity.isTouchingWater()) {
            BlockPos.Mutable mutable = blockPos.mutableCopy();
            for (int i = 0; i < 6 && this.opz(mutable.down()); ++i) {
                mutable.move(Direction.DOWN);
            }
            return mutable.toImmutable();
        }
        return blockPos;
    }

    private void opf(List<BlockPos> list) {
        this.ofb = list;
        this.ofc = 0;
        this.ofw = 0;
        this.ofx = 0;
        this.off = null;
        if (list != null && !list.isEmpty()) {
            prz prz2 = new prz();
            prz2.danger = this.ons();
            prz2.radius = 7.0;
            prz2.avoid = this.oix();
            this.off = this.ofe.plan((World)this.getWorld(), (PlayerEntity)this.getPlayer(), list, this.ofq, prz2);
        }
        if (this.off == null) {
            this.ofb = null;
        }
    }

    private void opg() {
        this.ofq = null;
        this.ofr = null;
        this.oft = null;
        this.ofu = null;
        this.ofv = 0;
        this.ofw = 0;
        this.ofx = 0;
        this.ofy = 0;
        this.ofz = false;
        this.oga = 0;
        this.ogc = 0;
        this.ogd = null;
        this.oge = true;
        this.ogf = Double.NaN;
    }

    private BlockPos oph(BlockPos blockPos) {
        if (this.getWorld() == null) {
            return blockPos;
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        block0: for (int i = 0; i <= 10; ++i) {
            for (int j = 1; j >= -1; j -= 2) {
                mutable.set(blockPos.getX(), blockPos.getY() + i * j, blockPos.getZ());
                if (this.onk((BlockPos)mutable)) {
                    return mutable.toImmutable();
                }
                if (i == 0) continue block0;
            }
        }
        return blockPos;
    }

    private void opi() {
        if (this.opb() && this.off != null && this.ofd <= 0 && !this.oib() && this.ofe.remaining(this.off) < 3.5) {
            this.ofd = 8;
            this.opj();
        }
        if (!this.opb()) {
            if (this.ofd > 0) {
                pqf.resetKeys();
                this.oot();
                return;
            }
            this.ofd = 8;
            this.opj();
        }
        if (this.opb()) {
            this.opq();
        } else {
            pqf.resetKeys();
            this.oot();
        }
    }

    private void opj() {
        BlockPos blockPos = this.getPlayer().getBlockPos();
        this.opl(blockPos);
        if (Double.isNaN(this.ofm)) {
            this.ofm = Math.toRadians((double)this.oow() + 90.0);
        }
        if (this.nzh != null && blockPos.getSquaredDistance((Vec3i)this.nzh) > 4900.0) {
            this.ofm = Math.atan2(this.nzh.getZ() - blockPos.getZ(), this.nzh.getX() - blockPos.getX());
        }
        double[] dArray = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
        int n = 0;
        for (int i = 0; i < dArray.length && n < 2; ++i) {
            double d = this.ofm + dArray[(i + this.ofo) % dArray.length] + this.nzf.nextGaussian() * 0.28;
            double d2 = 14.0 + this.nzf.nextDouble() * 16.0;
            BlockPos blockPos2 = blockPos.add((int)Math.round(Math.cos(d) * d2), 0, (int)Math.round(Math.sin(d) * d2));
            if (this.opm(blockPos2) && this.ofn < 2) continue;
            ++n;
            List<BlockPos> list = this.opd(this.ooe(this.oph(blockPos2)));
            if (list == null || list.size() < 5) continue;
            this.ofm = d;
            this.ofn = 0;
            this.ofo = 0;
            this.opf(list);
            return;
        }
        ++this.ofn;
        this.ofo = (this.ofo + 2) % dArray.length;
        this.ofm += 1.5707963267948966 + this.nzf.nextDouble() * Math.PI;
        this.opf(null);
    }

    private static long opk(BlockPos blockPos) {
        return (long)(blockPos.getX() >> 4) << 32 ^ (long)(blockPos.getZ() >> 4) & 0xFFFFFFFFL;
    }

    private void opl(BlockPos blockPos) {
        if (this.ofp.size() > 512) {
            this.ofp.clear();
        }
        this.ofp.add(nxa.opk(blockPos));
    }

    private boolean opm(BlockPos blockPos) {
        return this.ofp.contains(nxa.opk(blockPos));
    }

    private void opn(Vec3d vec3d) {
        this.opo(vec3d, false);
    }

    private void opo(Vec3d vec3d, boolean bl) {
        int n = this.ofe.walkTo(this.mc, (PlayerEntity)this.getPlayer(), (World)this.getWorld(), vec3d, this.ogv, this.ogw, null, this.nzb == nwx.ESCAPING, this.oib(), this.oie());
        if (n != 0 && !this.oib()) {
            pqf.resetKeys();
        }
        this.ohq = true;
        this.ofa = true;
    }

    private double opp(BlockPos blockPos) {
        double d = this.getPlayer().getX() - ((double)blockPos.getX() + 0.5);
        double d2 = this.getPlayer().getZ() - ((double)blockPos.getZ() + 0.5);
        return d * d + d2 * d2;
    }

    private void opq() {
        Object object;
        if (!this.opb()) {
            return;
        }
        if (!this.oib() && this.ops()) {
            pqf.resetKeys();
            this.oot();
            return;
        }
        if (this.off == null) {
            object = new prz();
            object.danger = this.ons();
            object.radius = 7.0;
            object.avoid = this.oix();
            this.off = this.ofe.plan((World)this.getWorld(), (PlayerEntity)this.getPlayer(), this.ofb, this.ofq, (prz)object);
            if (this.off == null) {
                this.ofb = null;
                this.ofc = 0;
                return;
            }
        }
        object = this.oha;
        this.oha = null;
        int n = this.ofe.follow(this.mc, (PlayerEntity)this.getPlayer(), (World)this.getWorld(), this.off, this.ogv, this.ogw, (Vec3d)object, this.nzb == nwx.ESCAPING, this.oib(), this.oie());
        if (n == 2) {
            List<BlockPos> list;
            List<BlockPos> list2 = list = this.ofq != null ? this.opd(this.ofq) : null;
            if (list == null || list.isEmpty()) {
                this.ofb = null;
                this.ofc = 0;
                this.off = null;
                this.ofd = 0;
                if (!this.oib()) {
                    pqf.resetKeys();
                }
                return;
            }
            this.opf(list);
            return;
        }
        if (n == 1) {
            this.ofc = this.ofb.size();
            this.off = null;
            if (!this.oib()) {
                pqf.resetKeys();
            }
            return;
        }
        this.ofc = Math.min(this.ofb.size() - 1, this.off.nodeIndex(this.ofe.stride.at()));
        if (this.ofc > this.ofw) {
            this.ofy += this.ofc - this.ofw;
            this.ofw = this.ofc;
            this.ofx = 0;
            if (this.ofy >= 10) {
                this.oet = 0;
                this.oft = null;
            }
        } else if (!this.oib() && this.ofz && ++this.ofx > 90) {
            this.ofx = 0;
            this.oiv(false);
            pqf.resetKeys();
            return;
        }
        this.ohq = true;
        this.ofa = true;
    }

    private double opr() {
        ClientPlayerEntity clientPlayerEntity = this.getPlayer();
        return clientPlayerEntity.isOnGround() || Double.isNaN(this.ogf) ? clientPlayerEntity.getY() : this.ogf;
    }

    private boolean ops() {
        if (this.ohi > 0) {
            --this.ohi;
            return true;
        }
        if (this.ohj > 0) {
            --this.ohj;
            return false;
        }
        if (this.nzb != nwx.EXPLORING || this.oab != null) {
            return false;
        }
        this.ohj = 2400 + this.nzf.nextInt(4200);
        this.ohi = 8 + this.nzf.nextInt(26);
        return true;
    }

    private boolean opt(Vec3d vec3d) {
        return this.opv(vec3d, true);
    }

    private boolean opu(Vec3d vec3d) {
        return this.opv(vec3d, false);
    }

    private boolean opv(Vec3d vec3d, boolean bl) {
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
        double d4 = this.opw();
        int n = (int)Math.ceil(d3 / 0.45);
        for (int i = 1; i <= n; ++i) {
            double d5 = (double)i / (double)n;
            double d6 = vec3d2.x + d * d5;
            double d7 = vec3d2.z + d2 * d5;
            if (!this.opx(d6, d7, d4)) {
                return false;
            }
            if (!bl || !this.opz(BlockPos.ofFloored((double)d6, (double)(d4 - 0.2), (double)d7))) continue;
            return false;
        }
        return true;
    }

    private double opw() {
        double d = this.opr();
        if (!this.opb()) {
            return d;
        }
        double d2 = pqf.getStandY(this.ofb.get(this.ofc));
        double d3 = d2 - d;
        return d3 > 0.0 && d3 <= 0.6 ? d2 : d;
    }

    private boolean opx(double d, double d2, double d3) {
        return this.opy(new Box(d - 0.31, d3 + 0.6, d2 - 0.31, d + 0.31, d3 + 1.8, d2 + 0.31));
    }

    private boolean opy(Box box) {
        for (VoxelShape voxelShape : this.getWorld().getBlockCollisions((Entity)this.getPlayer(), box)) {
            if (voxelShape.isEmpty()) continue;
            return false;
        }
        return true;
    }

    private boolean opz(BlockPos blockPos) {
        return this.getWorld().getBlockState(blockPos).getCollisionShape((BlockView)this.getWorld(), blockPos).isEmpty();
    }

    private boolean oqa(ItemStack itemStack) {
        if (itemStack.isEmpty() || itemStack.isOf(Items.GLASS_BOTTLE)) {
            return true;
        }
        if (this.oqf(itemStack, true) || this.nyt.get() && this.oqf(itemStack, false)) {
            return false;
        }
        return !this.oht(itemStack);
    }

    private boolean oqb(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.isOf(Items.GLASS_BOTTLE)) {
            return true;
        }
        return !this.oqd(itemStack) && nxa.oqc(itemStack) && !this.oht(itemStack);
    }

    private static boolean oqc(ItemStack itemStack) {
        Item item = itemStack.getItem();
        return item instanceof ShovelItem || item instanceof AxeItem || item instanceof BannerItem || item instanceof SmithingTemplateItem && !itemStack.isOf(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE) || itemStack.isOf(Items.BLAZE_ROD) || itemStack.isOf(Items.ENCHANTED_BOOK) || itemStack.isOf(Items.TRIDENT) || itemStack.isOf(Items.NAME_TAG) || itemStack.isOf(Items.SCULK) || itemStack.isOf(Items.SCULK_SENSOR) || itemStack.isOf(Items.ENDER_CHEST) || itemStack.isOf(Items.REINFORCED_DEEPSLATE) || itemStack.isOf(Items.PUFFERFISH) || itemStack.isOf(Items.HONEY_BOTTLE) || itemStack.isOf(Items.FERMENTED_SPIDER_EYE) || itemStack.isOf(Items.ANVIL) || itemStack.isOf(Items.COOKED_PORKCHOP);
    }

    private boolean oqd(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return true;
        }
        if (itemStack.isOf(Items.GOLDEN_CARROT) || itemStack.isOf(Items.TOTEM_OF_UNDYING) || itemStack.isOf(Items.MACE)) {
            return true;
        }
        if (this.oqf(itemStack, true) || this.oqf(itemStack, false)) {
            return true;
        }
        return itemStack.getItem().getTranslationKey().contains(a.d("\u9ddc\ue441\u6e96\uf0ff\u7b35\ufd92", 1568403408, -906464683));
    }

    private boolean oqe(ItemStack itemStack) {
        if (this.oqf(itemStack, true) || this.oqf(itemStack, false)) {
            return true;
        }
        if (itemStack.isOf(Items.GOLDEN_CARROT)) {
            return this.oqh(Items.GOLDEN_CARROT) <= this.oal;
        }
        return this.oqd(itemStack) && !this.oht(itemStack);
    }

    private boolean oqf(ItemStack itemStack, boolean bl) {
        if (itemStack.isEmpty()) {
            return false;
        }
        if (!(itemStack.isOf(Items.POTION) || itemStack.isOf(Items.SPLASH_POTION) || itemStack.isOf(Items.LINGERING_POTION))) {
            return false;
        }
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.get(DataComponentTypes.POTION_CONTENTS);
        if (potionContentsComponent != null) {
            int n = 0;
            boolean bl2 = false;
            for (StatusEffectInstance statusEffectInstance : potionContentsComponent.getEffects()) {
                ++n;
                if (statusEffectInstance.getEffectType() != (bl ? StatusEffects.INVISIBILITY : StatusEffects.SPEED)) continue;
                bl2 = true;
            }
            if (n > 0) {
                return n == 1 && bl2;
            }
        }
        String string = itemStack.getName().getString().toLowerCase();
        return bl ? string.contains(a.d("\u9085\ue93c\u63e8\ufd93\u7648\uf0f5\u4aa2", -166002153, -559573336)) : string.contains(a.c(252853652, "\u39d2\u4018\ucacf\u54c0\udf69\u59a7\ue3f7")) || string.contains(a.d("\u09a3\u7011\ufad7\u64a6\uef70", 897879409, -15498076));
    }

    private int oqg(boolean bl) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(i);
            if (!this.oqf(itemStack, bl)) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private int oqh(Item item) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(i);
            if (!itemStack.isOf(item)) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private int oqi(Predicate<ItemStack> predicate) {
        for (int i = 0; i < 9; ++i) {
            if (!predicate.test(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private int oqj(Predicate<ItemStack> predicate) {
        for (int i = 9; i < 36; ++i) {
            if (!predicate.test(this.getPlayer().getInventory().getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private int oqk() {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            if (!this.oqb(this.getPlayer().getInventory().getStack(i))) continue;
            ++n;
        }
        return n;
    }

    private int oql() {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = this.getPlayer().getInventory().getStack(i);
            if (!itemStack.isEmpty() && !this.oqb(itemStack)) continue;
            ++n;
        }
        return n;
    }

    private static /* synthetic */ int bec(int n, int n2) {
        return n - n2 ^ 0x972C128B;
    }

    private static /* synthetic */ int bed(int n, int n2) {
        return nxa.bec(n, n2) * n2;
    }
}

