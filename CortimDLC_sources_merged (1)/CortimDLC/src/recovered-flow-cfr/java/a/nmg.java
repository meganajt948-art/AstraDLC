/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.entity.BarrelBlockEntity
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.ItemEnchantmentsComponent
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.state.property.Property
 *  net.minecraft.text.Text
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.chunk.WorldChunk
 */
package a;

import a.izx;
import a.kfa;
import a.kfe;
import a.nmc;
import a.oqv;
import a.pdi;
import a.pfl;
import a.pgi;
import a.pjw;
import a.prp;
import a.prt;
import a.pud;
import a.vhz;
import a.vkl;
import a.vmc;
import a.vxr;
import a.vyn;
import a.vzz;
import a.wap;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.chunk.WorldChunk;

public class nmg
extends kfe {
    private static final String nmh = a.b("\u7e64\u07dc\u8d47\u1365\u98a4\u1e11\ua451\u2db1\ub3e5\u391c", 2125168143);
    private static final String nmi = a.d("\u6647\u1fff\u9564\u0b46\u8087\u063f\ubc6c\u35d1", -260310604, -974151782);
    private static final String nmj = a.d("\u10e8\u6950", 1283661315, 1865813640);
    private static final String nmk = a.c(-97666056, "\ubfb5\uc601\u4ca2\ud2de\u590c\udfbe\u65ee\uec6e");
    private static final String nml = a.b("\ub191\uc82a\u428c\udc88\u5758\ud190\u6bc9\ue23b\u7c16\uf6a5", 1258927524);
    private static final String nmm = a.b("\u6567\u1ca5\u960f\u0802\u83ab\u051c\ubf4c", -1371512496);
    private static final String nmn = a.c(1233984232, "\u1ead\u676f\uedb4");
    private static final String nmo = a.c(-402032835, "\u7748\u0efb\u8433\u1a48\u9199");
    private static final String nmp = a.c(1417472844, "\uef06\u96b2\u1c1d\u8263\u09ce\u8b14\u3550\ubca6\u22f8\ua838\u2f9b\ud598\u5b41");
    private static final String nmq = a.b("\uffad\u8614\u08d2\u92b3\u196e\u9fa7\u25f5\uac77\u3223", -1210254439);
    private static final String nmr = a.b("\u654e\u1c80\u962d\u0856\u8385\u0536", 65429879);
    private static final String nms = a.b("\uf907\u80bf\u0a67\u9412\u1fc4\u997b", -2022834893);
    private static final String[] nmt = new String[]{a.c(-1151989219, "\u0e2d\u7794\uf952\u6341\ue8e4\u6e5f\ud016\u5df6\uc3d3\u4968\uceb8\u34cb\uba62"), a.b("\u05ab\u7c60\uf6b0\u68b1\ue314\u65a1\udff0\u521d\uc853\u4298\uc541\u3f33\ub1e6\u2829", -1721433628), a.b("\u2855\u519e\udb4e\u454f\uceea\u485f\uf20e\u7fe3\ue5db\u6f1d\ue8bf\u12cd\u9c66", 1453075481), a.c(1350132863, "\u6047\u19f7\u932e\u0d55\u868a9\uba66"), a.d("\u1a26\u639b\ue948\u773a\ufce5\u7a5f\uc014\u49fc", 2027829326, 947200515)};
    private static final String[] nmu = new String[]{a.d("\uf277\u8bce\u0508\u9f64\u14be\u9206\u2858", 1916029549, -113329120), a.c(-1717891486, "\u0a55\u73ec\ufd2a\u673a\uecef\u6a54\ud07b\u59fe\uc7a2\u4d63"), a.c(-1534417231, "\ua287\udb3e\u519a\ucb89\u4441\uc28f\u78a9\uf159\u6f0e\ue5b6\u6212"), a.d("\u563c\u2f8e\ua559\u3b2c\ub081", -1278593382, -875273064), a.d("\u9fc2\ue67b\u6ca6\uf2a0\u790c\uffc5", 1240536523, 1455001138), a.d("\u8724\ufe92\u744e\uea40\u61e2\ue72f", 1553206516, 665817057), a.d("\u3fdb\u4662\uccb0\u52cb\ud963\u5fd1\ue5f0\u6c73\uf250\u7898\uff31\u0543", -1920542226, 1824973316), a.c(-1104399963, "\u3592\u4c2b\uc2ed\u58f9\ud359\u55ea\uefcb\u6648\uf812\u72d4"), a.b("\u5292\u2b59\ua189\u3f88\ub42d\u3298\u88c9", -1242736940), a.b("\ub2f2\ucb35\u4196\udfee\u5432", -2031044919), a.b("\uca81\ub338\u3dfe\ua7ec\u2c4c\uaaf9\u10a1", 1993068219)};
    private static final String[] nmv = new String[]{a.d("\u4acb\u3305\ub9a5\u27d8\uac00\u2abe\u90e7", 1537211233, 1522447763), a.b("\u24a3\u5d62\ud7c4\u49bd\uc263", 1214652566)};
    private static final int nmw = 36;
    private static final double nmx = 0.75;
    private static final long nmy = 180000L;
    private static final long nmz = 120000L;
    private static final long nna = 110L;
    private static final long nnb = 360L;
    private static final long nnc = 260L;
    private static final long nnd = 4000L;
    private static final long nne = 4000L;
    private static final long nnf = 20000L;
    private static final long nng = 850L;
    private static final long nnh = 900L;
    private static final long nni = 3500L;
    private static final double nnj = 1.4;
    private static final double nnk = 1500.0;
    private static final double nnl = 0.75;
    private static final long nnm = 25000L;
    private static final int nnn = 3;
    private static final long nno = 60000L;
    private static final long nnp = 380L;
    private static final double nnq = 4.3;
    private static final long nnr = 60000L;
    private static final long nns = 1500L;
    private static final long nnt = 3000L;
    private static final int nnu = 64;
    private static final int nnv = 0;
    private static final int nnw = 1;
    private static final int nnx = 2;
    private static final int nny = 3;
    private static final Field nnz = vxr.find(ClientPlayerEntity.class, a.c(1576694976, "\u74b9\u0d03\u87c1\u19ea\u927e\u14cb\uae9f\u2765\ub93c\u339c\ub45c\u4e2a\uc0ef\u5904\ud31a\u55e4\uefa6\u6065\ufad6\u7cab\uf534\u8f66\u01d7"), a.d("\uef78\u96c6\u1c19\u8261\u09be\u8f34\u350b\ubcf0\u22a2\ua816", -55873425, -330457221), a.c(992488130, "\u2a85"));
    private static final Field noa = vxr.find(ClientPlayerEntity.class, a.b("\u3b44\u42fe\uc83c\u5617\udd83\u5b36\ue162\u6898\uf6c1\u7c61\ufba1\u01d7\u8f12\u16f9\u9ce7\u1a19\ua05b\u2f98\ub52b\u3356\ubac9\uc09b\u4e2a", 1847540541), a.b("\uabe5\ud25b\u5884\uc6fc\u4d23\ucba9\u7196\uf86d\u6639\uec8f", -412177527), a.b("\u159d", -508881446));
    private static nmg nob;
    private final vmc noc = this.add(new vmc(a.c(-1501869311, "\u4f16\u3682\ubc5f\u222d\uadef\u2f3e\u9566\u1ce1\u82b9\u0802"), 5.0, 1.0, 50.0, 1.0).suffix(a.c(-1002632484, "\u0af8")));
    private final vmc nod = this.add(new vmc(a.d("\u6fd3\u1606\u9cae\u02d7\u8903\u0fc6\ub596\u3c69\ua65a\u288c\uaf28\u5529", -1464656866, -950765600), 60.0, 0.0, 100.0, 5.0).suffix(a.d("\uea7d", 1228273941, 28906316)));
    private final vkl noe = this.add(new vkl(a.d("\u4e62\u37c8\ubd67\u2365\ua8b3\u2e72\u9041\u1dd2\u83f1\u0948\u8e98", -798940136, -1107988908), false));
    private final vmc nof = this.add(new vmc(a.b("\ue533\u9ca3\u1676\u887e\u03d2\u8567\u3f38\ub2db\u2896\ua635\u25fa\udf8f\u515d\uc892\u42c0\uc430", 1029759292), 20.0, 4.0, 40.0, 1.0));
    private final vkl nog = this.add(new vkl(a.b("\ue04a\u99d4\u1710\u8d00\u06d5\u801a\u3a40\ub3c6\u2de0\ua755\u208a", 929686617), true));
    private nmc noh = nmc.IDLE;
    private long noi;
    private long noj;
    private long nok;
    private long nol;
    private long nom = -1L;
    private int non = 0;
    private long noo;
    private long nop;
    private long noq = 360L;
    private long nor;
    private long nos;
    private int not;
    private long nou;
    private int nov;
    private int now = 8;
    private boolean nox;
    private ItemStack noy = ItemStack.EMPTY;
    private String noz = "";
    private String npa = "";
    private final Set<String> npb = new HashSet<String>();
    private final Map<String, long[]> npc = new HashMap<String, long[]>();
    private int npd = -1;
    private int npe;
    private int npf;
    private long npg;
    private boolean nph;
    private int npi = -1;
    private int npj = -1;
    private int npk = -1;
    private int npl = -1;
    private boolean npm;
    private final vyn npn = new vyn();
    private long npo;
    private long npp;
    private boolean npq;
    private int npr = -1;
    private int nps = -1;
    private long npt;
    private int npu = 0;
    private String npv = "";
    private final Map<BlockPos, Long> npw = new HashMap<BlockPos, Long>();
    private BlockPos npx;
    private BlockPos npy;
    private Vec3d npz;
    private double nqa;
    private double nqb;
    private double nqc;
    private int nqd;
    private long nqe;
    private boolean nqf;
    private int nqg;
    private int nqh;
    private int nqi;
    private int nqj = -1;
    private int nqk = -1;
    private ItemStack[] nql;
    private final boolean[] nqm = new boolean[9];
    private boolean nqn;
    private final pgi nqo = new pgi();
    private final pjw nqp = new pjw();
    private ClientPlayerEntity nqq;
    private boolean nqr;
    private long nqs;
    private static /* synthetic */ String nqt;
    private static /* synthetic */ int nqu;

    public nmg() {
        super(a.d("\u51d0\u2855\ua287\u3ced\ub706\u3181\u8bdb\u022a", 1739780492, -385048555), a.c(512599125, "\ua42e\udda9\u5773\uc902\u42ca\uc428\u7e22\uf7c5\u6980\ue336\u64b7\u9e8f\u105f\u89f6\u03b6\u854c\u3f19\ub0d3\u2a7d\uac27\u2589\u5f97\ud125\u4aba\uccca\u4655\uffef\u71f6\ueb54\u6d1e\ue6a7\u1877\u922f\u0b8c\u8d92\u072f\ub8eb\u3283\ub45e\u2dfe"), kfa.PLAYER);
        nob = this;
    }

    public static void onMessage(Text text) {
        nmg nmg2 = nob;
        if (nmg2 != null && nmg2.isEnabled()) {
            nmg2.nqv(text);
        }
    }

    @Override
    protected void onEnable() {
        this.num();
        this.npb.clear();
        this.npw.clear();
        this.nqn = false;
        this.nqo.reset();
        this.nov = 0;
        this.now = nmg.nug();
        this.npl = this.mc.player == null ? -1 : this.mc.player.getInventory().getSelectedSlot();
        long l = System.currentTimeMillis();
        this.npc.values().removeIf(lArray -> l - lArray[1] > 180000L);
        this.nop = l + 260L + ThreadLocalRandom.current().nextLong(0L, 340L);
        this.nok = Math.max(this.nok, l + nmg.nuf());
    }

    @Override
    protected void onDisable() {
        this.num();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        this.nsg();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.getNetworkHandler() == null) {
            if (this.noh != nmc.IDLE) {
                this.num();
            }
            return;
        }
        if (this.npm) {
            this.npn.hold(minecraftClient);
        }
        if (this.nqr && this.noh == nmc.CHEST_OPEN) {
            this.nsh();
        }
        if (this.noh == nmc.IDLE) {
            Screen screen = minecraftClient.currentScreen;
            if (screen != null && !(screen instanceof HandledScreen)) {
                return;
            }
            if (System.currentTimeMillis() < this.nop) {
                return;
            }
            if (!this.nqw() && !this.nrw()) {
                this.nra();
            }
            return;
        }
        if (this.noh.nmd > 0L && System.currentTimeMillis() - this.noi > this.noh.nmd) {
            if (this.noh == nmc.RESTORE) {
                this.nrl();
            } else if (this.noh == nmc.CHEST_OPEN) {
                this.nsc(System.currentTimeMillis() + 60000L, wap.s(a.c(1859138279, "\u32a6\u4b2b\uc1f5\u5fc1\ud455\u52ef\ue8b1\u6156\uff0e\u75eb\uf27c\u0800\u86da\u1f61\u957b\u13d9\ua9c2\u265c\ubcf0\u3ab4\ub348"), a.c(-469570317, "\ue8c0\u9113\u1bbe\u85c6\u0e66\u88ae\u36e7\ubb0b\u255c\uabf8\u2835\ud238\u5c97\uc55c\u4f04\uc985\u73b0\ufc6f")), false, 0);
            } else if (this.noh == nmc.CHEST_LOOT) {
                this.nsd();
                this.nsc(0L, null, true, 2);
            } else if (this.nrs()) {
                this.nun(wap.s(a.c(-1118277666, "\u6f9d\u1610\u9cce\u02fa\u897e\u0fc8\ub580\u3c6c\ua220\u2897\uaf46\u5572\udbe1\u425d\uc803\u4ef8\uf4fe\u7b7c\ue19b\u6785\uee6d\u9429\u1a91"), a.d("\ue89b\u914f\u1bec\u8590\u0e42\u88f0\u32a0\ubb20\u2503\uaba7\u2869\ud210\u58d2\uc57d\u4f52\uc9db\u73ee\ufc34\u66f7\ue0a3\u692b\u1377", 85673192, 1743300672)), false);
                this.nrr();
            } else {
                this.nqz(wap.s(a.b("\u13f5\u6a78\ue0a6\u7e92\uf504\u73a1\uc9e4\u4002\ude40\u54f7\ud325\u291a\ua784\u3e2f\ub42f\u328d\u88d8\u070c\u9db6\u1bec\u9201\ue81e\u66b7", 708121526), a.d("\ubbd7\uc235\u489f\ud692\u5d3b\udb8c\u61dc\uec30\u7673\ufcc0\u7b16\u811b\u0fb3\u9678\u1853\u9eb8", 1842220612, 787853715)) + this.npa, false, true);
            }
            return;
        }
        switch (this.noh.ordinal()) {
            case 1: {
                this.nrb();
                break;
            }
            case 2: {
                this.nrc();
                break;
            }
            case 3: {
                this.nrd();
                break;
            }
            case 4: {
                this.nri();
                break;
            }
            case 5: {
                this.nrj();
                break;
            }
            case 6: {
                this.nrk();
                break;
            }
            case 7: {
                this.nrn();
                break;
            }
            case 8: {
                this.nro();
                break;
            }
            case 9: {
                this.nrp();
                break;
            }
            case 10: {
                this.nrq();
                break;
            }
            case 11: {
                this.nry();
                break;
            }
            case 12: {
                this.nsb();
                break;
            }
        }
    }

    private void nqv(Text text) {
        if (this.noh == nmc.IDLE || this.nrs() || System.currentTimeMillis() - this.noo > 4000L) {
            return;
        }
        String string = nmg.nto(text.getString());
        if (string.isEmpty()) {
            return;
        }
        if (nmg.ntp(string)) {
            this.npu = 3;
        } else if (nmg.ntq(string, nmt)) {
            this.npu = 1;
        } else if (nmg.ntq(string, nmu)) {
            this.npv = string.length() > 48 ? string.substring(0, 48) : string;
            this.npu = 2;
        }
    }

    private boolean nqw() {
        PlayerInventory playerInventory = this.mc.player.getInventory();
        for (int i = 0; i < 2; ++i) {
            int n = i == 0 ? 9 : 0;
            int n2 = i == 0 ? 36 : 9;
            for (int j = n; j < n2; ++j) {
                String string;
                ItemStack itemStack;
                if (!this.nqx(j) || (itemStack = playerInventory.getStack(j)).isEmpty() || this.npb.contains(string = nmg.nti(itemStack))) continue;
                String string2 = nmg.cleanQuery(itemStack.getName().getString());
                if (string2.isEmpty()) {
                    this.npb.add(string);
                    continue;
                }
                this.noy = itemStack.copy();
                this.noz = string;
                this.npa = string2;
                this.npd = -1;
                this.npf = 0;
                this.npu = 0;
                this.npv = "";
                this.npq = false;
                this.noq = 360L + ThreadLocalRandom.current().nextLong(0L, 260L);
                this.nun(wap.s(a.c(1626048758, "\u88ac\uf12b\u7bf1\ue580\u6e52\ue8e4\u52be\udb12\u4557"), a.d("\ud1e0\ua80e\u22a3\ubcd8\u370b\ub1c4\u0fe3\u8608", -1763073027, 1907062282)) + this.npa, true);
                this.nul(nmc.TAKE);
                return true;
            }
        }
        return false;
    }

    private boolean nqx(int n) {
        if (n == this.npk) {
            return false;
        }
        if (n >= 9) {
            return true;
        }
        return this.noe.get() || n == this.npi || this.nqy(n);
    }

    private boolean nqy(int n) {
        if (!this.nqm[n]) {
            return false;
        }
        if (this.mc.player.getInventory().getStack(n).isEmpty()) {
            this.nqm[n] = false;
            return false;
        }
        return true;
    }

    private void nqz(String string, boolean bl, boolean bl2) {
        if (bl2 && !this.noz.isEmpty()) {
            this.npb.add(this.noz);
        }
        if (string != null) {
            long l = System.currentTimeMillis();
            if (bl || l - this.nor > 4000L) {
                if (!bl) {
                    this.nor = l;
                }
                this.nun(string, bl);
            }
        }
        this.npq = false;
        this.npd = -1;
        this.npf = 0;
        this.npu = 0;
        this.npv = "";
        this.noy = ItemStack.EMPTY;
        this.noz = "";
        this.npa = "";
        this.nty();
        this.nop = System.currentTimeMillis() + 260L + ThreadLocalRandom.current().nextLong(0L, 300L);
        this.nul(nmc.IDLE);
    }

    private void nra() {
        this.nun(this.npe > 0 ? wap.s(a.d("\u9598\uec02\u66d0\uf8aa\u7334\uf589\u4f96\uc664\u5820\ud296\u550c\uaf67", 1170604283, -1443654357), a.d("\u8e38\uf7a4\u7d0b\ue306\u68dd\uee60\u5021\ud9dc\u4398\uc92c\u4e83\ub48e\u3a55\ua7ec\u2da5", 1967025482, -1392973970)) + this.npe : wap.s(a.c(76792324, "\uc245\ubbd5\u311d\uaf70\u24a6\ua210\u184a\u91fc\u0ff7\u855d\u02c1\uf8e3\u7622\uef9a\u65c9"), a.d("\ua400\uddee\u5743\uc938\u42eb\uc458\u7e09\uf78a\u69db\ue706\u64c8\u9eb1\u1014\u89d7\u0382\u857e", -2047509949, 671013452)), this.npe > 0);
        this.nph = true;
        this.nul(nmc.RESTORE);
    }

    private void nrb() {
        if (this.ntv()) {
            return;
        }
        PlayerInventory playerInventory = this.mc.player.getInventory();
        if (this.nqx(playerInventory.getSelectedSlot()) && nmg.ntj(this.mc.player.getMainHandStack(), this.noy)) {
            this.nty();
            this.nul(nmc.SEARCH);
            return;
        }
        int n = this.ntr();
        if (n < 0) {
            this.nqz(null, true, false);
            return;
        }
        if (n < 9) {
            this.nty();
            if (!this.nub()) {
                return;
            }
            playerInventory.setSelectedSlot(n);
            this.nul(nmc.SEARCH);
            return;
        }
        if (!this.ntw()) {
            return;
        }
        int n2 = this.ntt();
        boolean bl = !playerInventory.getStack(n2).isEmpty();
        this.ntz(nmg.ntu(n), SlotActionType.SWAP, n2);
        this.npi = n2;
        if (bl && this.npj < 0) {
            this.npj = n2;
            this.npk = n;
        }
    }

    private void nrc() {
        long l;
        long[] lArray;
        this.nty();
        if (this.ntv()) {
            return;
        }
        String string = nmg.cleanQuery(this.mc.player.getMainHandStack().getName().getString());
        if (!string.isEmpty()) {
            this.npa = string;
        }
        if ((lArray = this.nrh(this.noz, l = System.currentTimeMillis(), 180000L)) != null) {
            if (lArray[0] > 0L) {
                this.nul(nmc.SEND);
            } else {
                this.nqz(wap.s(a.d("\ube8d\uc71d\u4d81\ud3a0\u5875\udedf\u6486\ued71\u7371\uf9da", 1707452646, -967371217), a.b("\udbb8\ua221\u2885\ub296\u3d27\ubbe5\u01be\u8839\u1217\u98bc", 381542319)) + this.npa, false, true);
            }
            return;
        }
        if (!this.nud(l, 0)) {
            return;
        }
        this.npq = true;
        this.nps = -1;
        this.npt = 0L;
        this.npr = this.mc.player.currentScreenHandler == null ? -1 : this.mc.player.currentScreenHandler.syncId;
        this.npu = 0;
        this.nua(a.b("\ub01c\uc9a4\u433f\udd1d\u56dc\ud069\u6a29\ue3c9\u7d9d\uf764", -151342985) + this.npa);
        this.nul(nmc.SCAN);
    }

    private void nrd() {
        this.nty();
        if (this.npu == 3) {
            this.nrm();
            return;
        }
        if (this.npu == 2) {
            this.nuk();
            return;
        }
        if (this.npu == 1) {
            if (this.nuj()) {
                this.nul(nmc.SEARCH);
            }
            return;
        }
        List<ItemStack> list = this.nre();
        if (list == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.npt < this.noq) {
            return;
        }
        this.npq = false;
        this.nrf(list, l);
        long[] lArray = this.nrh(this.noz, l, 180000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.nqz(wap.s(a.c(-1517454865, "\u79ab;\u8aa7\u1486\u9f53\u19f9\ua3a0\u2a57\ub457\u3efc"), a.d("\u7181\u0818\u82bc\u18af\u971e\u11dc\uab87\u2200\ub82e\u3285", -125098721, 389369993)) + this.npa, false, true);
            return;
        }
        this.nou = l + nmg.nuh(900L, 0.45, 350L, 3500L);
        this.nul(nmc.SEND);
    }

    private List<ItemStack> nre() {
        if (!this.npq || !(this.mc.currentScreen instanceof HandledScreen)) {
            return null;
        }
        ScreenHandler screenHandler = this.mc.player.currentScreenHandler;
        if (!(screenHandler instanceof GenericContainerScreenHandler) || screenHandler.syncId == this.npr) {
            return null;
        }
        int n = screenHandler.slots.size() - 36;
        boolean bl = false;
        for (int i = 0; i < n && !bl; ++i) {
            bl = !((Slot)screenHandler.slots.get(i)).getStack().isEmpty();
        }
        if (!bl) {
            return null;
        }
        if (screenHandler.syncId != this.nps) {
            this.nps = screenHandler.syncId;
            this.npt = System.currentTimeMillis();
        }
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>(screenHandler.slots.size());
        for (int i = 0; i < screenHandler.slots.size(); ++i) {
            arrayList.add(((Slot)screenHandler.slots.get(i)).getStack().copy());
        }
        return arrayList;
    }

    private void nrf(List<ItemStack> list, long l) {
        this.nrg(this.noz, this.nsz(list, this.noy), l);
        String string = this.npa;
        PlayerInventory playerInventory = this.mc.player.getInventory();
        for (int i = 0; i < 36; ++i) {
            String string2;
            ItemStack itemStack;
            if (!this.nqx(i) || (itemStack = playerInventory.getStack(i)).isEmpty() || itemStack.getItem() != this.noy.getItem() || (string2 = nmg.nti(itemStack)).equals(this.noz) || this.npb.contains(string2) || !string.equals(nmg.cleanQuery(itemStack.getName().getString()))) continue;
            this.nrg(string2, this.nsz(list, itemStack), l);
        }
    }

    private void nrg(String string, int n, long l) {
        this.npc.put(string, new long[]{n > 0 ? (long)n : -1L, l});
    }

    private long[] nrh(String string, long l, long l2) {
        long[] lArray = this.npc.get(string);
        return lArray != null && l - lArray[1] < l2 ? lArray : null;
    }

    private void nri() {
        this.nty();
        long l = System.currentTimeMillis();
        if (l < this.nou && this.mc.currentScreen instanceof HandledScreen) {
            this.noi = l;
            return;
        }
        if (this.ntv()) {
            return;
        }
        if (this.npu == 3) {
            this.nrm();
            return;
        }
        if (this.npu == 2) {
            this.nuk();
            return;
        }
        long[] lArray = this.nrh(this.noz, l, 300000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.nul(nmc.SEARCH);
            return;
        }
        int n = (int)lArray[0];
        ItemStack itemStack = this.mc.player.getMainHandStack();
        if (!nmg.ntj(itemStack, this.noy)) {
            if (++this.npf > 2) {
                this.nqz(wap.s(a.d("\u0bf1\u727c\uf8a2\u6696\ued08\u6ba4\ud1e6\u581f\uc60d\u4cf0\ucb2a\u3158\ubf9d\u2678\uac7f\u2a92\u90d0\u1f44\u85bf\u03e7\u8a1f\uf044", -2054961122, 992265133), a.c(1289452755, "\u78e5\u0148\u8b97\u15e4\u9e43\u1c92\ua2de\u2b50\ub571\u3fc1\ub81d\u4267\uc8ab\u5502\udf5e\u5db8\ue397\u6c45\uf68f\u70dc")), false, true);
            } else {
                this.nul(nmc.TAKE);
            }
            return;
        }
        if (!this.nud(l, 1)) {
            return;
        }
        int n2 = Math.max(1, itemStack.getCount());
        long l2 = (long)Math.floor((double)n * (1.0 - this.noc.get() / 100.0));
        if (l2 >= (long)n) {
            l2 = (long)n - 1L;
        }
        this.npg = nmg.nth(Math.max(1L, l2) * (long)n2);
        this.npd = this.nts();
        this.nua(a.d("\ud7ef\uae57\u24cc\ubaee\u312f\ub797\u0dc4\u8479", 2130015067, 966829277) + this.npg);
        this.nul(nmc.CONFIRM);
    }

    private void nrj() {
        this.nty();
        if (this.ntv()) {
            return;
        }
        if (this.npu == 3) {
            this.nrm();
            return;
        }
        if (this.npu == 1) {
            if (this.nuj()) {
                this.nul(nmc.SEND);
            }
            return;
        }
        if (this.npu == 2) {
            this.nuk();
            return;
        }
        int n = this.nts();
        if (this.npd < 0 || n >= this.npd) {
            return;
        }
        ++this.npe;
        this.not = 0;
        this.npf = 0;
        this.npd = -1;
        this.nun(wap.s(a.d("\ubca5\uc531\u4ff8\ud18e\u5a48\udcf8\u66ef\uef58\u710e\ufba2\u7c23", -611244710, -1685153352), a.d("\u9d54\ue4bc\u6e65\uf017\u7bb2\ufd01\u475b\ucea4\u50f3\uda41\u598c\ua7ea\u293a\ub49b", 243713159, -1231790641)) + this.npg, true);
        if (++this.nov >= this.now) {
            this.nov = 0;
            this.now = nmg.nug();
            this.nok = Math.max(this.nok, System.currentTimeMillis() + nmg.nuh(3500L, 0.45, 1500L, 12000L));
        }
        if (n > 0) {
            this.nul(nmc.TAKE);
        } else {
            this.nqz(null, true, false);
        }
    }

    private void nrk() {
        if (this.ntv()) {
            return;
        }
        PlayerInventory playerInventory = this.mc.player.getInventory();
        if (this.npj >= 0 && this.npk >= 0) {
            boolean bl;
            boolean bl2 = bl = !playerInventory.getStack(this.npk).isEmpty() || !playerInventory.getStack(this.npj).isEmpty();
            if (bl) {
                if (!this.ntw()) {
                    return;
                }
                this.ntz(nmg.ntu(this.npk), SlotActionType.SWAP, this.npj);
            }
            this.npj = -1;
            this.npk = -1;
            return;
        }
        this.nty();
        if (this.npl >= 0 && this.npl < 9 && playerInventory.getSelectedSlot() != this.npl) {
            if (!this.nub()) {
                return;
            }
            playerInventory.setSelectedSlot(this.npl);
        }
        this.nrl();
    }

    private void nrl() {
        boolean bl = this.nph;
        this.num();
        if (bl) {
            this.setEnabled(false);
        }
    }

    private void nrm() {
        this.npu = 0;
        this.npv = "";
        this.npd = -1;
        this.npq = false;
        this.nty();
        if (this.nox) {
            this.nun(wap.s(a.c(-1951403857, "\uf0c6\u895a\u0389\u9db4\u162f\u909d\u2ad5\ua370\u3d7c\ub7d2\u3002\uca68\u44b8\udd5a\u5748\ud1aa\u6bf2\ue466\u7e81\uf8c5\u7138\u0b67\u85df\u1e4c\u983f\u12a0\uab12\u255b\ubfb3\u39ef\ub24b\u4c8d\uc687\u5f22\ud96a\u5394\uec10\u6677\ue0ad\u791c"), a.c(1292075897, "\u877c\ufed7\u7401\uea0c\u61d2\ue308\u5d40\ud4b4\u4a97\uc05a\u4785\ub9e6\u3326\uaa90\u20ce\ua64d\u1c0f\u93d7\u0d03\u8b5e\u06b6\u7c98\uf255\u698e\ueff5\u6526\udc97\u52b4\uc84d\u4a70\uc5de\u3b07\ub147\u28cf\uaeeb\u245e")), false);
            this.nra();
            return;
        }
        long l = System.currentTimeMillis();
        if (l >= this.npo) {
            this.nul(nmc.AH_OPEN);
            return;
        }
        this.nun(wap.s(a.d("\u390f\u4082\uca5c\u5468\udfec\u595a\ue312\u6afe\uf4b2\u7e05\uf9d4\u03e0\u8d7e\u14d5\u9ed5\u1862\ua23e\u2df6\ub745\u3154\ub8af\uc2ac\u4c08\ud7d0\u51aa\udb61\u62d5\uec99\u7669\uf031\u7bc5\u855d\u0f15\u96aa", 2127213415, 909609502), a.b("\u460d\u3fd9\ub57a\u2b06\ua0d4\u2666\u9c36\u15b6\u8b95\u0531\u86fd\u7c8d\uf25f\u6be8\ue1b8\u635b\ud918\u52d6\uc86f\u4e4b\uc7c9\ubd9f\u3355\ua88e\u2ef2\ua451\u1de0\u93b8\u093a\u8b05\u04d1\ufa72\u7048\ue9cc\u6f9d\ue13b", 2108375564)) + (this.npo - l + 999L) / 1000L + wap.s(a.b("\u078b\u7e69", 833816489), a.c(1661766070, "\u8994\uf444")), false);
        this.nul(nmc.FULL_WAIT);
    }

    private void nrn() {
        if (System.currentTimeMillis() >= this.npo) {
            this.nul(nmc.AH_OPEN);
        }
    }

    private void nro() {
        if (this.ntv()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!this.nud(l, 0)) {
            return;
        }
        this.npo = l + 60000L + ThreadLocalRandom.current().nextLong(400L, 4000L);
        this.nox = true;
        this.nua(a.b("\u9283\ueb3b", -1888578848));
        this.nul(nmc.AH_STORAGE);
    }

    private void nrp() {
        int n = this.nrt(a.b("\u81e7\uf853\u72f0\uec8c\u675e\ue1ec\u5bbc\ud23c", 1830716842));
        if (n < 0 || !this.nrv() || !this.ntx()) {
            return;
        }
        this.ntz(n, SlotActionType.PICKUP, 0);
        pdi.note(0);
        this.nul(nmc.AH_RELIST);
    }

    private void nrq() {
        int n = this.nrt(a.c(1019336349, "\ud2a8\uab13\u21b5\ubfb1\u3461\ub2a9\u08f0\u8102\u1f2f\u959c"));
        if (n < 0 || !this.nrv() || !this.ntx()) {
            return;
        }
        int n2 = this.nru();
        if (n2 > 0) {
            this.ntz(n, SlotActionType.PICKUP, 0);
            pdi.note(0);
            this.nun(wap.s(a.b("\u102e\u69a8\ue372\u7d06\uf6cb\u707d\uca33\u43c5\udd93\u577f\ud0b6", -1983180681), a.d("\u78d8\u0143\u8be5\u15e1\u9e31\u18f9\ua2a0\u2b52\ub57f\u3fcc\ub816\u4213\uccc5\u5100\udb49", 1669158300, -1291114156)) + n2, true);
        } else {
            this.nun(wap.s(a.c(374693028, "\u5cde\u2553\uaf8d\u31b9\uba3d\u3c8b\u86c3\u0f2f\u9163\u1bd4\u9c05\u6631\ue8af\u7104\ufb04\u7db0\uc7f7\u483b\ud28c\u54d0\udd72\ua72f\u29c8\ub205\u3477\ubee3\u0703\u894d\u13b9\u95f3\u1e47\ue0c5\u6ac2\uf334\u7564\uffdd\u404e\uca73\u4ca5\ud50b\u5f47\u21f3\uabec\u2c5e\ub692\u38e4"), a.c(756897622, "\u5356\u2a82\ua021\u3e5d\ub58f\u333d\u896d\u00ed\u9ece\u106a\u93a6\u69ab\ue77e\u7ecc\uf4e3\u7219\ucc4f\u4392\udd40\u5b6b\ud299\ua8b4\u260e\ub9b4\u3bdc\ub10a\u08b4\u8697\u1c6d\u9a35\u15ed\uef27\u656d\ufce0\u7ac1\uf07c\u4faf")), false);
        }
        this.nrr();
    }

    private void nrr() {
        this.nty();
        this.npu = 0;
        this.npv = "";
        long l = System.currentTimeMillis();
        this.noo = 0L;
        this.nok = Math.max(this.nok, l + nmg.nuh(1600L, 0.35, 900L, 4000L));
        this.noj = l + 250L + ThreadLocalRandom.current().nextLong(0L, 350L);
        this.nul(this.noy.isEmpty() ? nmc.IDLE : nmc.TAKE);
    }

    private boolean nrs() {
        return this.noh == nmc.FULL_WAIT || this.noh == nmc.AH_OPEN || this.noh == nmc.AH_STORAGE || this.noh == nmc.AH_RELIST;
    }

    private int nrt(String string) {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        ScreenHandler screenHandler = clientPlayerEntity.currentScreenHandler;
        if (!(this.mc.currentScreen instanceof HandledScreen) || screenHandler == null || screenHandler == clientPlayerEntity.playerScreenHandler) {
            return -1;
        }
        int n = screenHandler.slots.size() - 36;
        if (n < 9) {
            return -1;
        }
        for (int i = n - 9; i < n; ++i) {
            ItemStack itemStack = ((Slot)screenHandler.slots.get(i)).getStack();
            if (itemStack.isEmpty() || !pfl.title(itemStack.getName().getString()).contains(string)) continue;
            return i;
        }
        return -1;
    }

    private int nru() {
        ScreenHandler screenHandler = this.mc.player.currentScreenHandler;
        int n = screenHandler.slots.size() - 36;
        int n2 = 0;
        for (int i = 0; i < n - 9; ++i) {
            if (((Slot)screenHandler.slots.get(i)).getStack().isEmpty()) continue;
            ++n2;
        }
        return n2;
    }

    private boolean nrv() {
        long l;
        if (this.npp != 0L) {
            return true;
        }
        this.npp = l = System.currentTimeMillis();
        double d = nmg.nui(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.25, 0.7, 1.9);
        long l2 = (long)(380.0 * d) + ThreadLocalRandom.current().nextLong(10L, 90L);
        this.noj = Math.max(this.noj, l + l2);
        return false;
    }

    private boolean nrw() {
        if (!this.nog.get()) {
            return false;
        }
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (clientPlayerEntity.hasVehicle() || !nmg.nsy(clientPlayerEntity.getInventory()) || this.nsm()) {
            return false;
        }
        long l = System.currentTimeMillis();
        if (oqv.listEmpty()) {
            if (!this.nqn && this.nrx(l) != null) {
                this.nqn = true;
                this.nun(wap.s(a.d("\u4220\u3bba\ub164\u2f03\ua4d3\u225a\u982a\u11db\u8f9f\u053f\u82fb\u78df\uf65c\u6fbe\ue5a1\u6355\ud900\u56d6\ucc31\u4a29\uc3c4\ub9c6\u3730\uace9\u2a8b\ua05e\u19e0", -292513171, 831182869), a.d("\ufd76\u84d9\u0e0d\u9005\u1bad\u9d18\u2351\uaac3\u34b7\ube0b\u39ce\uc3b8\u4d57\ud4c5\u5e96\ud87c\u6222\uede4\u7705\uf54b\u7cc0\u0693\u8823", 577765907, -133039277)), false);
            }
            return false;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.nqa = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        this.nqb = (threadLocalRandom.nextDouble() - 0.5) * 0.25;
        this.nqc = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        BlockPos blockPos = this.nrx(l);
        if (blockPos == null) {
            return false;
        }
        this.npx = blockPos;
        this.npy = nmg.nst((World)this.mc.world, blockPos);
        this.npz = this.nso(blockPos);
        this.nqd = 1 + threadLocalRandom.nextInt(4);
        this.nqe = 0L;
        this.nsj(clientPlayerEntity);
        this.nul(nmc.CHEST_OPEN);
        return true;
    }

    private BlockPos nrx(long l) {
        ClientWorld clientWorld = this.mc.world;
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        double d = 28.09;
        BlockPos blockPos = null;
        double d2 = Double.MAX_VALUE;
        int n = clientPlayerEntity.getBlockX() >> 4;
        int n2 = clientPlayerEntity.getBlockZ() >> 4;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                WorldChunk worldChunk = clientWorld.getChunkManager().getWorldChunk(n + i, n2 + j, false);
                if (worldChunk == null) continue;
                for (BlockEntity blockEntity : worldChunk.getBlockEntities().values()) {
                    int n3;
                    BlockPos blockPos2;
                    Long l2;
                    BlockPos blockPos3;
                    if (!(blockEntity instanceof ChestBlockEntity) && !(blockEntity instanceof BarrelBlockEntity) || vec3d.squaredDistanceTo(Vec3d.ofCenter((Vec3i)(blockPos3 = blockEntity.getPos()))) > d || (l2 = this.npw.get(blockPos2 = nmg.nst((World)clientWorld, blockPos3))) != null && l2 > l || (n3 = oqv.markState(clientWorld, blockPos3)) == 1 || n3 == 2 && l2 == null) continue;
                    if (nmg.nsu((World)clientWorld, blockPos3)) {
                        this.npw.put(blockPos2, Long.MAX_VALUE);
                        continue;
                    }
                    Vec3d vec3d2 = this.nso(blockPos3);
                    double d3 = vec3d2 == null ? Double.MAX_VALUE : vec3d.squaredDistanceTo(vec3d2);
                    double d4 = d3;
                    if (!(d4 <= 18.49) || !(d4 < d2)) continue;
                    d2 = d4;
                    blockPos = blockPos3.toImmutable();
                }
            }
        }
        return blockPos;
    }

    private void nry() {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        long l = System.currentTimeMillis();
        ClientWorld clientWorld = this.mc.world;
        if (this.nqe > 0L && this.mc.currentScreen instanceof HandledScreen && this.nrz((World)clientWorld, clientPlayerEntity.currentScreenHandler, l)) {
            this.nsa(l);
            return;
        }
        if (this.ntv()) {
            return;
        }
        if (this.npx == null || !nmg.nsr((World)clientWorld, this.npx)) {
            this.nsc(Long.MAX_VALUE, null, false, 0);
            return;
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        if (this.npz == null || vec3d.distanceTo(this.npz) > 4.3) {
            this.npz = this.nso(this.npx);
            if (this.npz == null || vec3d.distanceTo(this.npz) > 4.3) {
                this.nsc(l + 60000L, null, false, 0);
                return;
            }
        }
        this.nsi();
        float f = vxr.getFloat(nnz, clientPlayerEntity, clientPlayerEntity.getYaw());
        float f2 = vxr.getFloat(noa, clientPlayerEntity, clientPlayerEntity.getPitch());
        BlockHitResult blockHitResult = this.nse(clientPlayerEntity, f, f2);
        if (blockHitResult != null && this.nsq((World)clientWorld, blockHitResult.getBlockPos())) {
            if (this.nqd > 0) {
                --this.nqd;
            } else if (l - this.nqe > 1500L && !clientPlayerEntity.isSneaking() && !clientPlayerEntity.isUsingItem() && vyn.serverIdle(clientPlayerEntity)) {
                this.nsf();
                this.nqe = l;
            }
        }
        this.nsk(this.npz, this.nsp((World)clientWorld, this.npx, this.npz));
    }

    private boolean nrz(World world, ScreenHandler screenHandler, long l) {
        int n;
        GenericContainerScreenHandler genericContainerScreenHandler;
        block5: {
            block4: {
                if (!(screenHandler instanceof GenericContainerScreenHandler)) break block4;
                genericContainerScreenHandler = (GenericContainerScreenHandler)screenHandler;
                if (l - this.nqe <= 3000L && this.npx != null) break block5;
            }
            return false;
        }
        int n2 = n = nmg.nss(world, this.npx) != null ? 6 : 3;
        if (genericContainerScreenHandler.getRows() != n) {
            return false;
        }
        String string = pfl.title(this.mc.currentScreen.getTitle().getString());
        return !string.contains(a.d("\u284d\u518f\udb25\u4528\uce81\u4836\uf266", -1326163368, 295728674)) && !string.contains(a.c(-89532832, "\ud22d\uab99\u213a\ubf46\u3494\ub226\u0876\u81f6"));
    }

    private void nsa(long l) {
        PlayerInventory playerInventory = this.mc.player.getInventory();
        this.nqk = this.mc.player.currentScreenHandler.syncId;
        this.nql = new ItemStack[9];
        for (int i = 0; i < 9; ++i) {
            this.nql[i] = playerInventory.getStack(i).copy();
        }
        this.nqg = 0;
        this.nqh = 0;
        this.nqj = -1;
        this.nqi = nmg.nsv(playerInventory);
        this.noj = l + this.nqo.draw(0);
        this.nul(nmc.CHEST_LOOT);
    }

    private void nsb() {
        int n;
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        long l = System.currentTimeMillis();
        ScreenHandler screenHandler = clientPlayerEntity.currentScreenHandler;
        if (!(this.mc.currentScreen instanceof HandledScreen) || !(screenHandler instanceof GenericContainerScreenHandler) || screenHandler.syncId != this.nqk) {
            this.nsc(l + 15000L, null, true, this.nqh > 0 ? 2 : 0);
            return;
        }
        if (l < this.noj || !vyn.serverIdle(clientPlayerEntity)) {
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (this.nqg >= 4 && this.nqg % 4 == 0 && nmg.nsv(playerInventory) <= this.nqi) {
            this.nsd();
            this.nsc(Long.MAX_VALUE, wap.s(a.c(394115480, "\ub9d2\uc05f\u4a81\ud4b5\u5f21\ud99b\u63c5\uea22\u747a\ufe9f\u791b\u8372\u0da4\u945c\u1e5c\u98f9\u22f1\uad2e\u3782\ub1c0\u3872\u426a\uccc4\u5712\ud13e\u5ba6\ue208\u6c48\uf6b7\u70f8"), a.d("\u5ca4\u2577\uafda\u31a2\uba02\u3cca\u8283\u0f6f\u9138\u1f9c\u9c51\u665c\ue8fd\u7148\ufb7a\u7d98\uc3b5\u4876\ud2c2\u54ef\udd69", -552115097, -388088585)), false, 2);
            return;
        }
        int n2 = screenHandler.slots.size() - 36;
        int n3 = -1;
        double d = Double.MAX_VALUE;
        boolean bl = false;
        for (n = 0; n < n2; ++n) {
            double d2;
            ItemStack itemStack = ((Slot)screenHandler.slots.get(n)).getStack();
            if (itemStack.isEmpty() || this.npb.contains(nmg.nti(itemStack)) || !oqv.wantsItem(itemStack.getItem())) continue;
            if (!nmg.nsx(playerInventory, itemStack)) {
                bl = true;
                continue;
            }
            double d3 = d2 = this.nqj < 0 ? (double)n * 0.01 : nmg.nsw(this.nqj, n);
            if (!(d2 < d)) continue;
            d = d2;
            n3 = n;
        }
        if (n3 < 0 || this.nqg >= 64) {
            n = bl || n3 >= 0 ? 1 : 0;
            this.nsd();
            this.nsc(n != 0 ? 0L : Long.MAX_VALUE, this.nqh > 0 ? wap.s(a.b("\u748d\u0d08\u87c6\u19b5\u922f\u14ca\uae85\u2779\ub963\u3391\ub449\u4e35\uc0f4\u5942\ud35f\u55b4", 664827099), a.b("\ua83b\ud1a5\u5f61\uc571\u4ea4\uc86b\u7231\ufbb7\u6591\uef2a\u6cf3\u9698", 582528047)) + this.nqh : null, true, n != 0 ? 2 : 1);
            return;
        }
        this.mc.interactionManager.clickSlot(screenHandler.syncId, n3, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)clientPlayerEntity);
        ++this.nqh;
        this.nqj = n3;
        this.noj = l + this.nqo.draw(this.nqg++ == 0 ? 1 : 2);
    }

    private void nsc(long l, String string, boolean bl, int n) {
        if (this.npy != null) {
            this.npw.put(this.npy, l);
        }
        if (n != 0 && this.npx != null) {
            oqv.markFromOutside(this.mc.world, this.npx, n == 2);
        }
        if (bl && this.nql != null) {
            PlayerInventory playerInventory = this.mc.player.getInventory();
            for (int i = 0; i < 9; ++i) {
                if (!this.nql[i].isEmpty() || playerInventory.getStack(i).isEmpty()) continue;
                this.nqm[i] = true;
            }
        }
        if (string != null) {
            this.nun(string, bl);
        }
        this.nsl();
        this.nty();
        this.npx = null;
        this.npy = null;
        this.npz = null;
        this.nqe = 0L;
        this.nql = null;
        this.nop = System.currentTimeMillis() + this.nqo.draw(0);
        this.nul(nmc.IDLE);
    }

    private void nsd() {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (clientPlayerEntity.currentScreenHandler != clientPlayerEntity.playerScreenHandler) {
            clientPlayerEntity.closeHandledScreen();
        }
    }

    private BlockHitResult nse(ClientPlayerEntity clientPlayerEntity, float f, float f2) {
        Vec3d vec3d;
        Vec3d vec3d2;
        Vec3d vec3d3 = clientPlayerEntity.getEyePos();
        BlockHitResult blockHitResult = this.mc.world.raycast(new RaycastContext(vec3d3, vec3d2 = vec3d3.add((vec3d = Vec3d.fromPolar((float)f2, (float)f)).multiply(clientPlayerEntity.getBlockInteractionRange())), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity));
        return blockHitResult.getType() == HitResult.Type.BLOCK ? blockHitResult : null;
    }

    private void nsf() {
        GameOptions gameOptions = this.mc.options;
        if (gameOptions == null) {
            return;
        }
        gameOptions.useKey.setPressed(true);
        this.nqf = true;
    }

    private void nsg() {
        if (!this.nqf) {
            return;
        }
        this.nqf = false;
        if (this.mc.options != null && this.mc.getWindow() != null) {
            this.mc.options.useKey.setPressed(vzz.isPhysicallyDown(this.mc, this.mc.options.useKey));
        }
    }

    private void nsh() {
        GameOptions gameOptions = this.mc.options;
        if (gameOptions == null) {
            return;
        }
        while (gameOptions.attackKey.wasPressed()) {
        }
        while (gameOptions.useKey.wasPressed()) {
        }
    }

    private void nsi() {
        if (!this.npm) {
            this.npm = true;
            this.npn.hold(this.mc);
        }
    }

    private void nsj(ClientPlayerEntity clientPlayerEntity) {
        if (this.nqq != clientPlayerEntity) {
            this.nqq = clientPlayerEntity;
            this.nqp.personalize(nmg.nsn(clientPlayerEntity.getGameProfile().name()));
        }
        if (!this.nqr) {
            boolean bl = pud.INSTANCE.engaged();
            float f = bl ? vxr.getFloat(nnz, clientPlayerEntity, clientPlayerEntity.getYaw()) : clientPlayerEntity.getYaw();
            float f2 = bl ? vxr.getFloat(noa, clientPlayerEntity, clientPlayerEntity.getPitch()) : clientPlayerEntity.getPitch();
            this.nqp.reset(f, f2);
        }
    }

    private void nsk(Vec3d vec3d, double d) {
        float[] fArray = prt.calculateAngle(vec3d);
        this.nqp.setMouseStep(prp.step());
        this.nqp.aim(fArray[0], fArray[1], d);
        pud.INSTANCE.set(this, this.nqp.getYaw(), MathHelper.clamp((float)this.nqp.getPitch(), (float)-90.0f, (float)90.0f));
        this.nqr = true;
    }

    private void nsl() {
        if (this.nqr) {
            this.nqr = false;
            this.nqs = System.currentTimeMillis();
            pud.INSTANCE.release(this.mc.player);
        }
    }

    private boolean nsm() {
        return !this.nqr && pud.INSTANCE.engaged() && System.currentTimeMillis() - this.nqs > 1000L;
    }

    private static long nsn(String string) {
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        return l;
    }

    private Vec3d nso(BlockPos blockPos) {
        Vec3d[] vec3dArray;
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        ClientWorld clientWorld = this.mc.world;
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = Vec3d.ofCenter((Vec3i)blockPos);
        BlockPos blockPos2 = nmg.nss((World)clientWorld, blockPos);
        for (Vec3d vec3d3 : vec3dArray = new Vec3d[]{vec3d2.add(this.nqa, this.nqb, this.nqc), vec3d2.add(0.0, 0.3, 0.0), vec3d2.add(0.0, -0.2, 0.0), vec3d2.add(0.3, 0.0, 0.0), vec3d2.add(-0.3, 0.0, 0.0), vec3d2.add(0.0, 0.0, 0.3), vec3d2.add(0.0, 0.0, -0.3)}) {
            BlockHitResult blockHitResult = clientWorld.raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity));
            if (blockHitResult.getType() != HitResult.Type.BLOCK || !blockHitResult.getBlockPos().equals((Object)blockPos) && !blockHitResult.getBlockPos().equals((Object)blockPos2)) continue;
            return vec3d3;
        }
        return null;
    }

    private double nsp(World world, BlockPos blockPos, Vec3d vec3d) {
        VoxelShape voxelShape = world.getBlockState(blockPos).getOutlineShape((BlockView)world, blockPos);
        Box box = voxelShape.isEmpty() ? new Box(blockPos) : voxelShape.getBoundingBox().offset(blockPos);
        double d = Math.min(Math.min(Math.min(vec3d.x - box.minX, box.maxX - vec3d.x), Math.min(vec3d.y - box.minY, box.maxY - vec3d.y)), Math.min(vec3d.z - box.minZ, box.maxZ - vec3d.z));
        if (d <= 0.02) {
            return 0.25;
        }
        double d2 = Math.max(0.5, this.mc.player.getEyePos().distanceTo(vec3d));
        return MathHelper.clamp((double)(Math.toDegrees(Math.atan2(d, d2)) * 0.55), (double)0.25, (double)4.0);
    }

    private boolean nsq(World world, BlockPos blockPos) {
        if (blockPos == null || this.npx == null) {
            return false;
        }
        return blockPos.equals((Object)this.npx) || blockPos.equals((Object)nmg.nss(world, this.npx));
    }

    private static boolean nsr(World world, BlockPos blockPos) {
        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        return blockEntity instanceof ChestBlockEntity || blockEntity instanceof BarrelBlockEntity;
    }

    private static BlockPos nss(World world, BlockPos blockPos) {
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() instanceof ChestBlock && blockState.contains((Property)ChestBlock.CHEST_TYPE) && blockState.get((Property)ChestBlock.CHEST_TYPE) != ChestType.SINGLE) {
            return blockPos.offset(ChestBlock.getFacing((BlockState)blockState));
        }
        return null;
    }

    private static BlockPos nst(World world, BlockPos blockPos) {
        BlockPos blockPos2 = nmg.nss(world, blockPos);
        return (blockPos2 != null && blockPos2.asLong() < blockPos.asLong() ? blockPos2 : blockPos).toImmutable();
    }

    private static boolean nsu(World world, BlockPos blockPos) {
        if (!(world.getBlockState(blockPos).getBlock() instanceof ChestBlock)) {
            return false;
        }
        BlockPos blockPos2 = nmg.nss(world, blockPos);
        return ChestBlock.isChestBlocked((WorldAccess)world, (BlockPos)blockPos) || blockPos2 != null && ChestBlock.isChestBlocked((WorldAccess)world, (BlockPos)blockPos2);
    }

    private static int nsv(PlayerInventory playerInventory) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            if (itemStack.isEmpty() || !oqv.wantsItem(itemStack.getItem())) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private static double nsw(int n, int n2) {
        int n3 = n % 9 - n2 % 9;
        int n4 = n / 9 - n2 / 9;
        return Math.sqrt(n3 * n3 + n4 * n4);
    }

    private static boolean nsx(PlayerInventory playerInventory, ItemStack itemStack) {
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

    private static boolean nsy(PlayerInventory playerInventory) {
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.getStack(i).isEmpty()) continue;
            return true;
        }
        return false;
    }

    private int nsz(List<ItemStack> list, ItemStack itemStack) {
        int n = this.nta(list, itemStack, 0);
        if (n <= 0) {
            n = this.nta(list, itemStack, 1);
        }
        if (n <= 0 && nmg.ntk(itemStack).isEmpty()) {
            n = this.nta(list, itemStack, 2);
        }
        return n;
    }

    private int nta(List<ItemStack> list, ItemStack itemStack, int n) {
        int n2;
        Object object;
        int n3;
        int n4 = Math.max(0, list.size() - 36);
        String string = nmg.nto(this.mc.player.getGameProfile().name());
        Map<String, Integer> map = nmg.ntk(itemStack);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n3 = 0; n3 < n4; ++n3) {
            object = list.get(n3);
            if (object == null || object.isEmpty() || !this.ntb((ItemStack)object, itemStack, map, n) || (n2 = nmg.nte(nmg.ntn((ItemStack)object), string)) <= 0) continue;
            arrayList.add(Math.max(1, n2 / Math.max(1, object.getCount())));
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        n3 = (Integer)arrayList.get(Math.min(2, arrayList.size() - 1));
        object = arrayList.iterator();
        while (object.hasNext()) {
            n2 = (Integer)object.next();
            if (!((double)n2 >= (double)n3 * 0.75)) continue;
            return n2;
        }
        return n3;
    }

    private boolean ntb(ItemStack itemStack, ItemStack itemStack2, Map<String, Integer> map, int n) {
        if (itemStack.getItem() != itemStack2.getItem()) {
            return false;
        }
        String string = nmg.cleanQuery(itemStack.getName().getString());
        String string2 = nmg.cleanQuery(itemStack2.getName().getString());
        if (string.isEmpty() || string2.isEmpty()) {
            return false;
        }
        if (!(string.equals(string2) || string.contains(string2) || string2.contains(string))) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        Map<String, Integer> map2 = nmg.ntk(itemStack);
        if (n == 0) {
            return map.equals(map2) && nmg.ntc(itemStack, itemStack2);
        }
        return nmg.ntd(map, map2) >= this.nod.get() / 100.0;
    }

    private static boolean ntc(ItemStack itemStack, ItemStack itemStack2) {
        List<String> list = nmg.ntn(itemStack2);
        if (list.size() <= 1) {
            return true;
        }
        List<String> list2 = nmg.ntn(itemStack);
        for (int i = 1; i < list.size(); ++i) {
            String string = list.get(i);
            if (string.isEmpty() || list2.contains(string)) continue;
            return false;
        }
        return true;
    }

    private static double ntd(Map<String, Integer> map, Map<String, Integer> map2) {
        if (map.isEmpty() && map2.isEmpty()) {
            return 1.0;
        }
        if (map.isEmpty() || map2.isEmpty()) {
            return 0.0;
        }
        double d = 0.0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer n = map2.get(entry.getKey());
            if (n == null) continue;
            d += n.equals(entry.getValue()) ? 1.0 : 0.6;
        }
        return d / (double)Math.max(map.size(), map2.size());
    }

    private static int nte(List<String> list, String string) {
        int n = -1;
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            if (string2.contains(a.c(1345326780, "\u0af6\u7342\uf9ed\u6793\uec3e\u6ee4\ud0a0\u5956\uc708\u4dc8\uca6b\u3068\ubeb1")) || string2.contains(a.b("\u2cd5\u556c\udbaa\u41cb\uca16\u4cdf\uf68d\u7f0f\ue15b", 921118945))) {
                return -1;
            }
            if (!string.isEmpty() && string2.contains(string) && (string2.contains(a.b("\u062c\u7fe2\uf54f\u6b34\ue0e7\u6654", 1765999125)) || string2.contains(a.b("\u7c3d\u0585\u8f5d\u1128\u9afe\u1c41", 1628272649)))) {
                return -1;
            }
            if (n > 0 || i == 0) continue;
            int n2 = string2.indexOf(a.d("\u1ad5\u6317\ue9cc", 1494807297, 936308113));
            if (n2 < 0) {
                n2 = string2.indexOf(a.c(-1565491635, "\u7e38\u078b\u8d43\u1338\u98e9"));
            }
            if (n2 < 0) {
                n2 = string2.indexOf(36);
            }
            if (n2 < 0) continue;
            int n3 = string2.indexOf(58, n2);
            n = nmg.ntf(string2, n3 >= 0 ? n3 + 1 : n2);
        }
        return n;
    }

    private static int ntf(String string, int n) {
        long l = 0L;
        boolean bl = false;
        for (int i = n; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                if ((l = l * 10L + (long)(c - 48)) > Integer.MAX_VALUE) {
                    return -1;
                }
                bl = true;
                continue;
            }
            if (bl && !nmg.ntg(c)) break;
        }
        return bl && l > 0L ? (int)l : -1;
    }

    private static boolean ntg(char c) {
        return c == ' ' || c == ',' || c == '.' || c == '\u00a0' || c == '\u202f';
    }

    private static long nth(long l) {
        long l2;
        long l3 = l;
        for (long i = 10L; i <= 10000L && l / i >= 10L && (l2 = (l + 1L) / i * i - 1L) > 0L && l - l2 <= Math.max(1L, l / 20L); i *= 10L) {
            l3 = l2;
        }
        return l3;
    }

    private static String nti(ItemStack itemStack) {
        return String.valueOf(itemStack.getItem()) + '|' + nmg.nto(itemStack.getName().getString()) + '|' + nmg.ntm(itemStack);
    }

    private static boolean ntj(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null || itemStack.isEmpty() || itemStack2.isEmpty()) {
            return false;
        }
        return itemStack.getItem() == itemStack2.getItem() && nmg.nti(itemStack).equals(nmg.nti(itemStack2));
    }

    private static Map<String, Integer> ntk(ItemStack itemStack) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        if (itemStack == null || itemStack.isEmpty()) {
            return treeMap;
        }
        try {
            nmg.ntl((ItemEnchantmentsComponent)itemStack.get(DataComponentTypes.ENCHANTMENTS), treeMap);
            nmg.ntl((ItemEnchantmentsComponent)itemStack.get(DataComponentTypes.STORED_ENCHANTMENTS), treeMap);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return treeMap;
    }

    private static void ntl(ItemEnchantmentsComponent itemEnchantmentsComponent, Map<String, Integer> map) {
        if (itemEnchantmentsComponent == null || itemEnchantmentsComponent.isEmpty()) {
            return;
        }
        for (RegistryEntry registryEntry : itemEnchantmentsComponent.getEnchantments()) {
            String string = registryEntry.getKey().map(registryKey -> registryKey.getValue().getPath()).orElse("");
            if (string.isEmpty()) continue;
            map.put(string, itemEnchantmentsComponent.getLevel(registryEntry));
        }
    }

    private static String ntm(ItemStack itemStack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : nmg.ntk(itemStack).entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue()).append(',');
        }
        return stringBuilder.toString();
    }

    private static List<String> ntn(ItemStack itemStack) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            arrayList.add(nmg.nto(itemStack.getName().getString()));
            LoreComponent loreComponent = (LoreComponent)itemStack.get(DataComponentTypes.LORE);
            if (loreComponent != null) {
                for (Text text : loreComponent.lines()) {
                    if (text == null) continue;
                    arrayList.add(nmg.nto(text.getString()));
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return arrayList;
    }

    private static String nto(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7') {
                ++i;
                continue;
            }
            stringBuilder.append(Character.toLowerCase(c));
        }
        return stringBuilder.toString().trim();
    }

    static String cleanQuery(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7') {
                ++i;
                continue;
            }
            if (Character.isLetterOrDigit(c)) {
                if (bl && stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                bl = false;
                stringBuilder.append(Character.toLowerCase(c));
                continue;
            }
            bl = true;
        }
        return stringBuilder.toString().trim();
    }

    private static boolean ntp(String string) {
        String string2 = pfl.title(string);
        return string2.contains(a.d("\udb1b\ua2af\u280c\ub670\u3da2\ubb10\u0140\u88c0", 1287447561, -1156564129)) && nmg.ntq(string2, nmv);
    }

    private static boolean ntq(String string, String[] stringArray) {
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private int ntr() {
        PlayerInventory playerInventory = this.mc.player.getInventory();
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack;
            if (!this.nqx(i) || !nmg.ntj(itemStack = playerInventory.getStack(i), this.noy) || itemStack.getCount() <= n2) continue;
            n2 = itemStack.getCount();
            n = i;
        }
        return n;
    }

    private int nts() {
        PlayerInventory playerInventory = this.mc.player.getInventory();
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack;
            if (!this.nqx(i) || !nmg.ntj(itemStack = playerInventory.getStack(i), this.noy)) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private int ntt() {
        if (this.npi >= 0) {
            return this.npi;
        }
        PlayerInventory playerInventory = this.mc.player.getInventory();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) {
            if (!playerInventory.getStack(i).isEmpty()) continue;
            arrayList.add(i);
        }
        if (arrayList.isEmpty()) {
            return playerInventory.getSelectedSlot();
        }
        return (Integer)arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
    }

    private static int ntu(int n) {
        return n < 9 ? 36 + n : n;
    }

    private boolean ntv() {
        Screen screen = this.mc.currentScreen;
        if (screen == null) {
            return false;
        }
        if (!(screen instanceof HandledScreen)) {
            this.noi = System.currentTimeMillis();
            return true;
        }
        if (this.nub()) {
            this.mc.player.closeHandledScreen();
            this.nok = Math.max(this.nok, System.currentTimeMillis() + nmg.nuf());
        }
        return true;
    }

    private boolean ntw() {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (clientPlayerEntity.currentScreenHandler != clientPlayerEntity.playerScreenHandler) {
            return false;
        }
        return this.ntx();
    }

    private boolean ntx() {
        if (this.nqr || pud.INSTANCE.engaged() && System.currentTimeMillis() - this.nqs < 1000L) {
            return false;
        }
        if (!this.nub()) {
            return false;
        }
        if (!this.npm) {
            this.npm = true;
            return false;
        }
        return vyn.serverIdle(this.mc.player);
    }

    private void nty() {
        if (this.npm) {
            this.npn.release(this.mc);
            this.npm = false;
        }
    }

    private void ntz(int n, SlotActionType slotActionType, int n2) {
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (clientPlayerEntity == null || this.mc.interactionManager == null) {
            return;
        }
        ScreenHandler screenHandler = clientPlayerEntity.currentScreenHandler;
        if (screenHandler == null || n < 0 || n >= screenHandler.slots.size()) {
            return;
        }
        this.mc.interactionManager.clickSlot(screenHandler.syncId, n, n2, slotActionType, (PlayerEntity)clientPlayerEntity);
        this.noj = System.currentTimeMillis() + this.nuc();
    }

    private void nua(String string) {
        long l;
        if (this.mc.getNetworkHandler() == null) {
            return;
        }
        this.mc.getNetworkHandler().sendChatCommand(string);
        this.noo = l = System.currentTimeMillis();
        this.nol = l;
        this.nom = -1L;
    }

    private boolean nub() {
        long l = System.currentTimeMillis();
        if (l < this.noj) {
            return false;
        }
        this.noj = l + this.nuc();
        return true;
    }

    private long nuc() {
        double d = nmg.nui(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.22, 0.72, 1.8);
        long l = (long)(110.0 * d);
        if (ThreadLocalRandom.current().nextInt(100) < 6) {
            l += ThreadLocalRandom.current().nextLong(140L, 520L);
        }
        return l + ThreadLocalRandom.current().nextLong(10L, 60L);
    }

    private boolean nud(long l, int n) {
        long l2;
        if (this.nom < 0L || this.non != n) {
            this.nom = this.nue(n);
            this.non = n;
        }
        if (l < Math.max(this.nok, this.nol + this.nom)) {
            this.noi = l;
            return false;
        }
        long l3 = l2 = n == 1 ? l : pdi.nextFree(n, this.nof.getInt(), l);
        if (l2 <= l) {
            return true;
        }
        this.nok = l2 + nmg.nuh(900L, 0.6, 150L, 5000L);
        this.noi = l;
        if (this.nok - l > 5000L && l - this.nos > 20000L) {
            this.nos = l;
            this.nun(wap.s(a.c(1169371817, "\u32ff\u4b7a\uc1bf\u5fd9\ud413\u52a4\ue8f6\u6149\uff5a\u75ee\uf239\u084c\u8686\u1f6f\u9530\u1396\ua9cf\u2616\ubcb8\u3af4\ub304\uc95c\u47a8"), a.d("\u1cb2\u6520\ueff7\u7182\ufa2f\u78fc\uc6bf\u4f3d\ud11b\u5bd6\udc7b\u260c\ua8d8\u3164\ubf2b\u39d6\u878f\u085c\u9298\u10aa", -188180244, 2072543313)) + (this.nok - l + 999L) / 1000L + wap.s(a.d("\u4d05\u34e7", -192273514, -1680970063), a.c(1990481409, "\u5623\u2bf3")), false);
        }
        return false;
    }

    private long nue(int n) {
        if (n == 1) {
            return this.nqo.draw(3, 1.4);
        }
        double d = 60000.0 / (double)pdi.limit(this.nof.getInt());
        return this.nqo.draw(4, d * 0.75 / 1500.0);
    }

    private static long nuf() {
        return nmg.nuh(850L, 0.35, 450L, 3000L);
    }

    private static int nug() {
        return 14 + ThreadLocalRandom.current().nextInt(11);
    }

    private static long nuh(long l, double d, long l2, long l3) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long l4 = l;
        for (int i = 0; i < 12; ++i) {
            l4 = Math.round((double)l * Math.exp(d * threadLocalRandom.nextGaussian()));
            if (l4 < l2 || l4 > l3) continue;
            return l4;
        }
        return Math.max(l2, Math.min(l3, l4));
    }

    private static double nui(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private boolean nuj() {
        this.npu = 0;
        this.npq = false;
        if (pdi.warn() >= 2) {
            this.nun(wap.s(a.c(416269799, "\uc591\ubc1c\u36c2\ua8f6\u2372\ua5d5\u1f91\u9664\u0828\u828e\u050f\uff37\u71fa\ue818\u6208\ue4ef\u5ea1\ud170\u4bde\ucd88\u4476\u3e60\ub087\u2b4a\uad38\u27ac\u9e5c\u1001\u8af4\u0ca5\u871a\u79c4\uf381\u6a67"), a.d("\ue62d\u9f88\u152e\u8b2d\u00fd\u8639\u380a\ub59b\u2bb1\ua103\u26d3\udcd5\u5660\ucbcb\u419c\uc76f\u7d2c\uf2f0\u684a\uee64", -984449545, -1005215761)), false);
            this.nra();
            return false;
        }
        long l = System.currentTimeMillis();
        long l2 = nmg.nuh(25000L, 0.25, 15000L, 45000L);
        this.nok = Math.max(this.nok, l + l2);
        this.nun(wap.s(a.b("\uf68e\u8f03\u05dd\u9be9\u106d\u96ca\u2c8e\ua57b\u3b37\ub191\u3610\ucc20\u42e5\udb4c\u5107\ud7a5\u6dbe\ue274\u7888\ufe8a\u7762\u0d30\u839b\u181d\u9e26\u14fc\uad57\u231f\ub9aa\u3ff7\ub414\u4ad4\uc08f\u5978\udf3d\u55c9", 1915483902), a.b("\u2ac3\u5366\ud9c0\u47c3\ucc13\u4ad7\uf4e4\u790a\ue72a\u6de5\uea49\u1041\u9eec\u033f\u8d70\u0b88\ub1c6\u3e18\ua4a5\u22fc\uab0b\ud152\u5fe1\uc029\u465a\uc894\u7128\uff0a\u6589\ue3df\u6c7c", 2010328829)) + (l2 + 999L) / 1000L + wap.s(a.d("\u61c8\u182a", 1842313224, 1533352418), a.d("\u368b\u4b5b", 1788216682, 392115139)), false);
        this.noi = l;
        return true;
    }

    private void nuk() {
        String string;
        String string2 = this.npv;
        String string3 = string = string2.isEmpty() ? wap.s(a.c(-1614400983, "\u326e\u4be3\uc13d\u5f09\ud49f\u523a\ue87f\u6199\uffdb\u756c\uf2be\u0881\u8604\u1fa2\u95f2\u1310\ua959\u269e\ubc2c"), a.d("\ue3f6\u9a14\u10be\u8eb3\u051a\u83ad\u39fd\ub411\u2e50\ua49d\u2336\ud94d\u579d\uce2b\u4473", -555690841, 1592210254)) : wap.s(a.c(728468998, "\u8e47\uf7ca\u7d14\ue320\u68b6\uee13\u5456\uddb0\u43f2\uc945\u4e97\ub4a8\u3a2d\ua38b\u29db\uaf39\u1570\u9ab7\u0005\u860a\u0fe7"), a.c(-1551906289, "\uce0e\ub7ec\u3d46\ua34b\u28e2\uae55\u1405\u99e9\u03a8\u8965\u0ece\uf4b5\u7a65\ue3d3\u698b\ueb7b\u512e")) + string2;
        if (++this.not >= 3) {
            this.nun(string, false);
            this.nra();
            return;
        }
        this.nqz(string, false, true);
    }

    private void nul(nmc nmc2) {
        if (this.noh != nmc2) {
            this.noh = nmc2;
            this.noi = System.currentTimeMillis();
            this.npp = 0L;
        }
    }

    private void num() {
        this.nty();
        this.nsg();
        this.nsl();
        this.npx = null;
        this.npy = null;
        this.npz = null;
        this.nqe = 0L;
        this.nql = null;
        Arrays.fill(this.nqm, false);
        this.noh = nmc.IDLE;
        this.noi = 0L;
        this.npp = 0L;
        this.nph = false;
        this.npq = false;
        this.npu = 0;
        this.npv = "";
        this.noy = ItemStack.EMPTY;
        this.noz = "";
        this.npa = "";
        this.npd = -1;
        this.npf = 0;
        this.not = 0;
        this.nou = 0L;
        this.nox = false;
        this.npe = 0;
        this.npi = -1;
        this.npj = -1;
        this.npk = -1;
        this.npl = -1;
    }

    private void nun(String string, boolean bl) {
        System.out.println(a.c(1288341737, "\u88a2\uf127\u7bf5\ue59f\u6e74\ue8f3\u52a9\udb58\u4551\ucffa") + string);
        izx.alert(this.getName(), string, bl ? vhz.CHECK : vhz.INFO, bl);
    }

    private static /* synthetic */ int bda(int n, int n2) {
        return n * n2 + 2124300415;
    }

    private static /* synthetic */ int bdb(int n, int n2) {
        return nmg.bda(n, n2) ^ 0xBFB576FB;
    }

    private static /* synthetic */ int bdc(int n, int n2) {
        return n * n2 ^ 0x3D081603;
    }
}

