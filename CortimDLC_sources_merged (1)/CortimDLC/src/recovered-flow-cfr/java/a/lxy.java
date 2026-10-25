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
import a.lxu;
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

public class lxy
extends kfe {
    private static final String lxz = a.d("\u674c\u1ef4\u946f\u0a4d\u818c\u0739\ubd79\u3499\uaacd\u2034", 1025040403, -1585936588);
    private static final String lya = a.d("\u52b5\u2b0d\ua196\u3fb4\ub475\u32cd\u889e\u0123", 793634717, 1010283841);
    private static final String lyb = a.b("\uebeb\u9253", 891743112);
    private static final String lyc = a.b("\u65d6\u1c62\u96c1\u08bd\u836f\u05dd\ubf8d\u360d", -2046140005);
    private static final String lyd = a.b("\u5008\u29b3\ua315\u3d11\ub6c1\u3009\u8a50\u03a2\u9d8f\u173c", -1372171203);
    private static final String lye = a.d("\u0553\u7c91\uf63b\u6836\ue39f\u6528\udf78", -1718409316, 1489970936);
    private static final String lyf = a.c(-1257960822, "\u0ecf\u770d\ufdd6");
    private static final String lyg = a.c(-1895021466, "\u4413\u3da0\ub768\u2913\ua2c2");
    private static final String lyh = a.d("\u09f7\u7043\ufaec\u6492\uef3f\u6de5\ud3a1\u5a57\uc409\u4ec9\uc96a\u3369\ubdb0", 1224290199, 461709866);
    private static final String lyi = a.b("\u6419\u1da0\u9366\u0907\u82da\u0413\ube41\u37c3\ua997", 1064263725);
    private static final String lyj = a.c(1552414078, "\uf147\u8889\u0224\u9c5f\u178c\u913f");
    private static final String lyk = a.b("\ud363\uaadb\u2003\ube76\u35a0\ub31f", -382085289);
    private static final String[] lyl = new String[]{a.c(-1924747583, "\uaaf1\ud348\u5d8e\uc79d\u4c38\uca83\u74ca\uf92a\u670f\uedb4\u6a64\u9017\u1ebe"), a.b("\u770f\u0ec4\u8414\u1a15\u91b0\u1705\uad54\u20b9\ubaf7\u303c\ub7e5\u4d97\uc342\u5a8d", -626035904), a.d("\u0e40\u778b\ufd5b\u635a\ue8ff\u6e4a\ud41b\u59f6\uc3ce\u4908\uceaa\u34d8\uba73", 1368783221, 1377301369), a.d("\u2b40\u52f0\ud829\u4652\ucd8d\u4b3e\uf161", -1323141539, 310860069), a.c(-265067277, "\u6498\u1d25\u97f6\u0984\u825b\u04e1\ubeaa\u3742")};
    private static final String[] lym = new String[]{a.c(912144230, "\u335c\u4ae5\uc423\u5e4f\ud595\u532d\ue973"), a.d("\u3f60\u46d9\uc81f\u520f\ud9da\u5f61\ue54e\u6ccb\uf297\u7856", 1694755342, -455552679), a.b("\u5ac5\u237c\ua9d8\u33cb\ubc03\u3acd\u80eb\u091b\u974c\u1df4\u9a50", 208690931), a.d("\u7527\u0c95\u8642\u1837\u939a", 537823451, 1252129218), a.d("\u623b\u1b82\u915f\u0f59\u84f5\u023c", 1152379486, -126579618), a.b("\u3e2d\u479b\ucd47\u5349\ud8eb\u5e26", -926270948), a.c(1718523507, "\u9242\uebfb\u6129\uff52\u74fa\uf248\u4869\uc1ea\u5fc9\ud501\u52a8\ua8da"), a.d("\u8479\ufdc0\u7306\ue912\u62b2\ue401\u5e20\ud7a3\u49f9\uc33f", 244438447, 1824740833), a.c(-700573290, "\u1dd0\u641b\ueecb\u70ca\ufb6f\u7dda\uc78b"), a.b("\ub661\ucfa6\u4505\udb7d\u50a1", 1438167642), a.c(1863938643, "\u7669\u0fd0\u8116\u1b04\u90a4\u1611\uac49")};
    private static final String[] lyn = new String[]{a.c(-1364565997, "\u642a\u1de4\u9744\u0939\u82e1\u045f\ube06"), a.b("\u93b3\uea72\u60d4\ufead\u7573", 443258758)};
    private static final int lyo = 36;
    private static final double lyp = 0.75;
    private static final long lyq = 180000L;
    private static final long lyr = 120000L;
    private static final long lys = 110L;
    private static final long lyt = 360L;
    private static final long lyu = 260L;
    private static final long lyv = 4000L;
    private static final long lyw = 4000L;
    private static final long lyx = 20000L;
    private static final long lyy = 850L;
    private static final long lyz = 900L;
    private static final long lza = 3500L;
    private static final double lzb = 1.4;
    private static final double lzc = 1500.0;
    private static final double lzd = 0.75;
    private static final long lze = 25000L;
    private static final int lzf = 3;
    private static final long lzg = 60000L;
    private static final long lzh = 380L;
    private static final double lzi = 4.3;
    private static final long lzj = 60000L;
    private static final long lzk = 1500L;
    private static final long lzl = 3000L;
    private static final int lzm = 64;
    private static final int lzn = 0;
    private static final int lzo = 1;
    private static final int lzp = 2;
    private static final int lzq = 3;
    private static final Field lzr = vxr.find(ClientPlayerEntity.class, a.b("\uf3fa\u8a40\u0082\u9ea9\u153d\u9388\u29dc\ua026\u3e7f\ub4df\u331f\uc969\u47ac\ude47\u5459\ud2a7\u68e5\ue726\u7d95\ufbe8\u7277\u0825\u8694", 292615043), a.d("\u4f90\u362e\ubcf1\u2289\ua956\u2fdc\u95e3\u1c18\u824a\u08fe", -322140526, 200591726), a.d("\uc791", -586597637, 1165032749));
    private static final Field lzs = vxr.find(ClientPlayerEntity.class, a.b("\u04c2\u7d78\uf7ba\u6991\ue205\u64b0\udee4\u571e\uc947\u43e7\uc427\u3e51\ub094\u297f\ua361\u259f\u9fdd\u101e\u8aad\u0cd0\u854f\uff1d\u71ac", -486800197), a.d("\u0479\u7dc7\uf718\u6960\ue2bf\u6435\ude0a\u57f1\uc9a5\u4313", 1233053955, 1001188630), a.d("\u5595", 763871993, 1915655979));
    private static lxy lzt;
    private final vmc lzu = this.add(new vmc(a.d("\u0b0d\u7299\uf844\u6636\ue9f4\u6b25\ud17d\u58fa\uc6a2\u4c19", -1088202757, 891771105), 5.0, 1.0, 50.0, 1.0).suffix(a.b("\u1194", -1548021328)));
    private final vmc lzv = this.add(new vmc(a.b("\u1914\u60c1\uea69\u7410\uffc4\u7901\uc351\u4aae\ud09d\u5e4b\ud9ef\u23ee", -1470816967), 60.0, 0.0, 100.0, 5.0).suffix(a.b("\u5308", -1754901716)));
    private final vkl lzw = this.add(new vkl(a.b("\u4d83\u3429\ube86\u2084\uab52\u2d93\u93a0\u1e33\u8010\u0aa9\u8d79", 1568098733), false));
    private final vmc lzx = this.add(new vmc(a.c(217379286, "\uf5d9\u8c49\u069c\u9894\u1338\u958d\u2fd2\ua231\u387c\ub6df\u3510\ucf65\u41b7\ud878\u522a\ud4da"), 20.0, 4.0, 40.0, 1.0));
    private final vkl lzy = this.add(new vkl(a.b("\u9185\ue81b\u66df\ufccf\u771a\uf1d5\u4b8f\uc209\u5c2f\ud69a\u5145", -1980983914), true));
    private lxu lzz = lxu.IDLE;
    private long maa;
    private long mab;
    private long mac;
    private long mad;
    private long mae = -1L;
    private int maf = 0;
    private long mag;
    private long mah;
    private long mai = 360L;
    private long maj;
    private long mak;
    private int mal;
    private long mam;
    private int man;
    private int mao = 8;
    private boolean map;
    private ItemStack maq = ItemStack.field_8037;
    private String mar = "";
    private String mas = "";
    private final Set<String> mat = new HashSet<String>();
    private final Map<String, long[]> mau = new HashMap<String, long[]>();
    private int mav = -1;
    private int maw;
    private int max;
    private long may;
    private boolean maz;
    private int mba = -1;
    private int mbb = -1;
    private int mbc = -1;
    private int mbd = -1;
    private boolean mbe;
    private final vyn mbf = new vyn();
    private long mbg;
    private long mbh;
    private boolean mbi;
    private int mbj = -1;
    private int mbk = -1;
    private long mbl;
    private int mbm = 0;
    private String mbn = "";
    private final Map<BlockPos, Long> mbo = new HashMap<BlockPos, Long>();
    private BlockPos mbp;
    private BlockPos mbq;
    private Vec3d mbr;
    private double mbs;
    private double mbt;
    private double mbu;
    private int mbv;
    private long mbw;
    private boolean mbx;
    private int mby;
    private int mbz;
    private int mca;
    private int mcb = -1;
    private int mcc = -1;
    private ItemStack[] mcd;
    private final boolean[] mce = new boolean[9];
    private boolean mcf;
    private final pgi mcg = new pgi();
    private final pjw mch = new pjw();
    private ClientPlayerEntity mci;
    private boolean mcj;
    private long mck;
    private static /* synthetic */ boolean mcl;
    private static /* synthetic */ String mcm;

    public lxy() {
        super(a.c(-9870285, "\u647b\u1dfe\u973b\u0961\u829b\u0423\ube6c\u3788\ua9c0"), a.b("\u6a53\u13d4\u990e\u077f\u8cb7\u0a55\ub052\u39bf\ua7ed\u2d19\uaa83\u50f5\ude3a\u4798\ucdc0\u4b2b\uf17f\u7eb3\ue40b\u6203\uebbb\u91eb\u1f16\u8493\u02f0\u882c\u31da\ubfca\u2529\ua36e\u28ca\ud606\u5c4f\uc5bf\u43a2\uc946\u768a\ufcf1\u7a23\ue385\u6988\u172d\u9d62\u1ade\u804c\u0e70\ub7af\u3d0d\ubb5b\u2084\uaee6\u5463\udd96\u5bdc\uc176\u4f6e\uf4cc\u721a\uf87f\u61a7\uef1a", 559311421), kfa.PLAYER);
        lzt = this;
    }

    public static void onMessage(Text text) {
        lxy lxy2 = lzt;
        if (lxy2 != null && lxy2.isEnabled()) {
            lxy2.mcn(text);
        }
    }

    @Override
    protected void onEnable() {
        this.mge();
        this.mat.clear();
        this.mbo.clear();
        this.mcf = false;
        this.mcg.reset();
        this.man = 0;
        this.mao = lxy.mfy();
        this.mbd = this.mc.field_1724 == null ? -1 : this.mc.field_1724.method_31548().method_67532();
        long l = System.currentTimeMillis();
        this.mau.values().removeIf(lArray -> l - lArray[1] > 180000L);
        this.mah = l + 260L + ThreadLocalRandom.current().nextLong(0L, 340L);
        this.mac = Math.max(this.mac, l + lxy.mfx());
    }

    @Override
    protected void onDisable() {
        this.mge();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        this.mdy();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || minecraftClient.method_1562() == null) {
            if (this.lzz != lxu.IDLE) {
                this.mge();
            }
            return;
        }
        if (this.mbe) {
            this.mbf.hold(minecraftClient);
        }
        if (this.mcj && this.lzz == lxu.CHEST_OPEN) {
            this.mdz();
        }
        if (this.lzz == lxu.IDLE) {
            Screen screen = minecraftClient.field_1755;
            if (screen != null && !(screen instanceof HandledScreen)) {
                return;
            }
            if (System.currentTimeMillis() < this.mah) {
                return;
            }
            if (!this.mco() && !this.mdo()) {
                this.mcs();
            }
            return;
        }
        if (this.lzz.lxv > 0L && System.currentTimeMillis() - this.maa > this.lzz.lxv) {
            if (this.lzz == lxu.RESTORE) {
                this.mdd();
            } else if (this.lzz == lxu.CHEST_OPEN) {
                this.mdu(System.currentTimeMillis() + 60000L, a.d("\uda67\ua3b4\u2919\ub761\u3cc1\uba09\u0440\u89ac\u17fb\u995f\u1a92\ue09f\u6e30\uf7fb\u7da3\ufb22\u4117\ucec8", 1128114533, -791644367), false, 0);
            } else if (this.lzz == lxu.CHEST_LOOT) {
                this.mdv();
                this.mdu(0L, null, true, 2);
            } else if (this.mdk()) {
                this.mgf(a.c(-1846086968, "\uf6fb\u8f2f\u058c\u9bf0\u1022\u9690\u2cc0\ua540\u3b63\ub5c7\u3609\ucc70\u46b2\udb1d\u5132\ud7bb\u6d8e\ue254\u7897\ufec3\u774b\u0d17"), false);
                this.mdj();
            } else {
                this.mcr(a.d("\u8610\ufff2\u7558\ueb55\u60fc\ue64b\u5c1b\ud1f7\u4bb4\uc107\u46d1\ubcdc\u3274\uabbf\u2594\ua37f", 1542086463, -987898577) + this.mas, false, true);
            }
            return;
        }
        switch (this.lzz.ordinal()) {
            case 1: {
                this.mct();
                break;
            }
            case 2: {
                this.mcu();
                break;
            }
            case 3: {
                this.mcv();
                break;
            }
            case 4: {
                this.mda();
                break;
            }
            case 5: {
                this.mdb();
                break;
            }
            case 6: {
                this.mdc();
                break;
            }
            case 7: {
                this.mdf();
                break;
            }
            case 8: {
                this.mdg();
                break;
            }
            case 9: {
                this.mdh();
                break;
            }
            case 10: {
                this.mdi();
                break;
            }
            case 11: {
                this.mdq();
                break;
            }
            case 12: {
                this.mdt();
                break;
            }
        }
    }

    private void mcn(Text text) {
        if (this.lzz == lxu.IDLE || this.mdk() || System.currentTimeMillis() - this.mag > 4000L) {
            return;
        }
        String string = lxy.mfg(text.getString());
        if (string.isEmpty()) {
            return;
        }
        if (lxy.mfh(string)) {
            this.mbm = 3;
        } else if (lxy.mfi(string, lyl)) {
            this.mbm = 1;
        } else if (lxy.mfi(string, lym)) {
            this.mbn = string.length() > 48 ? string.substring(0, 48) : string;
            this.mbm = 2;
        }
    }

    private boolean mco() {
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        for (int i = 0; i < 2; ++i) {
            int n = i == 0 ? 9 : 0;
            int n2 = i == 0 ? 36 : 9;
            for (int j = n; j < n2; ++j) {
                String string;
                ItemStack itemStack;
                if (!this.mcp(j) || (itemStack = playerInventory.method_5438(j)).method_7960() || this.mat.contains(string = lxy.mfa(itemStack))) continue;
                String string2 = lxy.cleanQuery(itemStack.method_7964().getString());
                if (string2.isEmpty()) {
                    this.mat.add(string);
                    continue;
                }
                this.maq = itemStack.method_7972();
                this.mar = string;
                this.mas = string2;
                this.mav = -1;
                this.max = 0;
                this.mbm = 0;
                this.mbn = "";
                this.mbi = false;
                this.mai = 360L + ThreadLocalRandom.current().nextLong(0L, 260L);
                this.mgf(a.b("\u18e2\u610c\ueba1\u75da\ufe09\u78c6\uc6e1\u4f0a", 1441668341) + this.mas, true);
                this.mgd(lxu.TAKE);
                return true;
            }
        }
        return false;
    }

    private boolean mcp(int n) {
        if (n == this.mbc) {
            return false;
        }
        if (n >= 9) {
            return true;
        }
        return this.lzw.get() || n == this.mba || this.mcq(n);
    }

    private boolean mcq(int n) {
        if (!this.mce[n]) {
            return false;
        }
        if (this.mc.field_1724.method_31548().method_5438(n).method_7960()) {
            this.mce[n] = false;
            return false;
        }
        return true;
    }

    private void mcr(String string, boolean bl, boolean bl2) {
        if (bl2 && !this.mar.isEmpty()) {
            this.mat.add(this.mar);
        }
        if (string != null) {
            long l = System.currentTimeMillis();
            if (bl || l - this.maj > 4000L) {
                if (!bl) {
                    this.maj = l;
                }
                this.mgf(string, bl);
            }
        }
        this.mbi = false;
        this.mav = -1;
        this.max = 0;
        this.mbm = 0;
        this.mbn = "";
        this.maq = ItemStack.field_8037;
        this.mar = "";
        this.mas = "";
        this.mfq();
        this.mah = System.currentTimeMillis() + 260L + ThreadLocalRandom.current().nextLong(0L, 300L);
        this.mgd(lxu.IDLE);
    }

    private void mcs() {
        this.mgf(this.maw > 0 ? a.b("\ub933\uc0af\u4a00\ud40d\u5fd6\ud96b\u672a\ueed7\u7493\ufe27\u7988\u8385\u0d5e\u90e7\u1aae", 864337199) + this.maw : a.d("\u208b\u5965\ud3c8\u4db3\uc660\u40d3\ufa82\u7301\ued50\u638d\ue043\u1a3a\u949f\u0d5c\u8709\u01f5", 1245273134, -1888978774), this.maw > 0);
        this.maz = true;
        this.mgd(lxu.RESTORE);
    }

    private void mct() {
        if (this.mfn()) {
            return;
        }
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        if (this.mcp(playerInventory.method_67532()) && lxy.mfb(this.mc.field_1724.method_6047(), this.maq)) {
            this.mfq();
            this.mgd(lxu.SEARCH);
            return;
        }
        int n = this.mfj();
        if (n < 0) {
            this.mcr(null, true, false);
            return;
        }
        if (n < 9) {
            this.mfq();
            if (!this.mft()) {
                return;
            }
            playerInventory.method_61496(n);
            this.mgd(lxu.SEARCH);
            return;
        }
        if (!this.mfo()) {
            return;
        }
        int n2 = this.mfl();
        boolean bl = !playerInventory.method_5438(n2).method_7960();
        this.mfr(lxy.mfm(n), SlotActionType.field_7791, n2);
        this.mba = n2;
        if (bl && this.mbb < 0) {
            this.mbb = n2;
            this.mbc = n;
        }
    }

    private void mcu() {
        long l;
        long[] lArray;
        this.mfq();
        if (this.mfn()) {
            return;
        }
        String string = lxy.cleanQuery(this.mc.field_1724.method_6047().method_7964().getString());
        if (!string.isEmpty()) {
            this.mas = string;
        }
        if ((lArray = this.mcz(this.mar, l = System.currentTimeMillis(), 180000L)) != null) {
            if (lArray[0] > 0L) {
                this.mgd(lxu.SEND);
            } else {
                this.mcr(a.c(-1407915681, "\ued48\u94d1\u1e75\u8466\u0bd7\u8d15\u374e\ubec9\u24e7\uae4c") + this.mas, false, true);
            }
            return;
        }
        if (!this.mfv(l, 0)) {
            return;
        }
        this.mbi = true;
        this.mbk = -1;
        this.mbl = 0L;
        this.mbj = this.mc.field_1724.field_7512 == null ? -1 : this.mc.field_1724.field_7512.field_7763;
        this.mbm = 0;
        this.mfs(a.b("\u62f9\u1b41\u91da\u0ff8\u8439\u028c\ub8cc\u312c\uaf78\u2581", -1304665454) + this.mas);
        this.mgd(lxu.SCAN);
    }

    private void mcv() {
        this.mfq();
        if (this.mbm == 3) {
            this.mde();
            return;
        }
        if (this.mbm == 2) {
            this.mgc();
            return;
        }
        if (this.mbm == 1) {
            if (this.mgb()) {
                this.mgd(lxu.SEARCH);
            }
            return;
        }
        List<ItemStack> list = this.mcw();
        if (list == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.mbl < this.mai) {
            return;
        }
        this.mbi = false;
        this.mcx(list, l);
        long[] lArray = this.mcz(this.mar, l, 180000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.mcr(a.d("\u7d2c\u04b5\u8e11\u1402\u9bb3\u1d71\ua72a\u2ead\ub483\u3e28", -304598496, -199734501) + this.mas, false, true);
            return;
        }
        this.mam = l + lxy.mfz(900L, 0.45, 350L, 3500L);
        this.mgd(lxu.SEND);
    }

    private List<ItemStack> mcw() {
        if (!this.mbi || !(this.mc.field_1755 instanceof HandledScreen)) {
            return null;
        }
        ScreenHandler screenHandler = this.mc.field_1724.field_7512;
        if (!(screenHandler instanceof GenericContainerScreenHandler) || screenHandler.field_7763 == this.mbj) {
            return null;
        }
        int n = screenHandler.field_7761.size() - 36;
        boolean bl = false;
        for (int i = 0; i < n && !bl; ++i) {
            bl = !((Slot)screenHandler.field_7761.get(i)).method_7677().method_7960();
        }
        if (!bl) {
            return null;
        }
        if (screenHandler.field_7763 != this.mbk) {
            this.mbk = screenHandler.field_7763;
            this.mbl = System.currentTimeMillis();
        }
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>(screenHandler.field_7761.size());
        for (int i = 0; i < screenHandler.field_7761.size(); ++i) {
            arrayList.add(((Slot)screenHandler.field_7761.get(i)).method_7677().method_7972());
        }
        return arrayList;
    }

    private void mcx(List<ItemStack> list, long l) {
        this.mcy(this.mar, this.mer(list, this.maq), l);
        String string = this.mas;
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        for (int i = 0; i < 36; ++i) {
            String string2;
            ItemStack itemStack;
            if (!this.mcp(i) || (itemStack = playerInventory.method_5438(i)).method_7960() || itemStack.method_7909() != this.maq.method_7909() || (string2 = lxy.mfa(itemStack)).equals(this.mar) || this.mat.contains(string2) || !string.equals(lxy.cleanQuery(itemStack.method_7964().getString()))) continue;
            this.mcy(string2, this.mer(list, itemStack), l);
        }
    }

    private void mcy(String string, int n, long l) {
        this.mau.put(string, new long[]{n > 0 ? (long)n : -1L, l});
    }

    private long[] mcz(String string, long l, long l2) {
        long[] lArray = this.mau.get(string);
        return lArray != null && l - lArray[1] < l2 ? lArray : null;
    }

    private void mda() {
        this.mfq();
        long l = System.currentTimeMillis();
        if (l < this.mam && this.mc.field_1755 instanceof HandledScreen) {
            this.maa = l;
            return;
        }
        if (this.mfn()) {
            return;
        }
        if (this.mbm == 3) {
            this.mde();
            return;
        }
        if (this.mbm == 2) {
            this.mgc();
            return;
        }
        long[] lArray = this.mcz(this.mar, l, 300000L);
        if (lArray == null || lArray[0] <= 0L) {
            this.mgd(lxu.SEARCH);
            return;
        }
        int n = (int)lArray[0];
        ItemStack itemStack = this.mc.field_1724.method_6047();
        if (!lxy.mfb(itemStack, this.maq)) {
            if (++this.max > 2) {
                this.mcr(a.c(-491171904, "\u4bf6\u325b\ub884\u26f7\uad50\u2f81\u91cd\u1843\u8662\u0cd2\u8b0e\u7174\ufbb8\u6611\uec4d\u6eab\ud084\u5f56\uc59c\u43cf"), false, true);
            } else {
                this.mgd(lxu.TAKE);
            }
            return;
        }
        if (!this.mfv(l, 1)) {
            return;
        }
        int n2 = Math.max(1, itemStack.method_7947());
        long l2 = (long)Math.floor((double)n * (1.0 - this.lzu.get() / 100.0));
        if (l2 >= (long)n) {
            l2 = (long)n - 1L;
        }
        this.may = lxy.mez(Math.max(1L, l2) * (long)n2);
        this.mav = this.mfk();
        this.mfs(a.d("\ua028\ud990\u530b\ucd29\u46e8\uc050\u7a03\uf3be", -603002167, -926397816) + this.may);
        this.mgd(lxu.CONFIRM);
    }

    private void mdb() {
        this.mfq();
        if (this.mfn()) {
            return;
        }
        if (this.mbm == 3) {
            this.mde();
            return;
        }
        if (this.mbm == 1) {
            if (this.mgb()) {
                this.mgd(lxu.SEND);
            }
            return;
        }
        if (this.mbm == 2) {
            this.mgc();
            return;
        }
        int n = this.mfk();
        if (this.mav < 0 || n >= this.mav) {
            return;
        }
        ++this.maw;
        this.mal = 0;
        this.max = 0;
        this.mav = -1;
        this.mgf(a.b("\u4ad3\u333b\ub9e2\u2790\uac35\u2a86\u90dc\u1923\u8774\u0dc6\u8e0b\u706d\ufebd\u631c", 1747275471) + this.may, true);
        if (++this.man >= this.mao) {
            this.man = 0;
            this.mao = lxy.mfy();
            this.mac = Math.max(this.mac, System.currentTimeMillis() + lxy.mfz(3500L, 0.45, 1500L, 12000L));
        }
        if (n > 0) {
            this.mgd(lxu.TAKE);
        } else {
            this.mcr(null, true, false);
        }
    }

    private void mdc() {
        if (this.mfn()) {
            return;
        }
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        if (this.mbb >= 0 && this.mbc >= 0) {
            boolean bl;
            boolean bl2 = bl = !playerInventory.method_5438(this.mbc).method_7960() || !playerInventory.method_5438(this.mbb).method_7960();
            if (bl) {
                if (!this.mfo()) {
                    return;
                }
                this.mfr(lxy.mfm(this.mbc), SlotActionType.field_7791, this.mbb);
            }
            this.mbb = -1;
            this.mbc = -1;
            return;
        }
        this.mfq();
        if (this.mbd >= 0 && this.mbd < 9 && playerInventory.method_67532() != this.mbd) {
            if (!this.mft()) {
                return;
            }
            playerInventory.method_61496(this.mbd);
        }
        this.mdd();
    }

    private void mdd() {
        boolean bl = this.maz;
        this.mge();
        if (bl) {
            this.setEnabled(false);
        }
    }

    private void mde() {
        this.mbm = 0;
        this.mbn = "";
        this.mav = -1;
        this.mbi = false;
        this.mfq();
        if (this.map) {
            this.mgf(a.b("\u68d9\u1172\u9ba4\u05a9\u8e77\u0cad\ub2e5\u3b11\ua532\u2fff\ua820\u5643\udc83\u4535\ucf6b\u49e8\uf3aa\u7c72\ue2a6\u64fb\ue913\u933d\u1df0\u862bP\u8a83\u3332\ubd11\u27e8\ua5d5\u2a7b\ud4a2\u5ee2\uc76a\u414e\ucbfb", 87387356), false);
            this.mcs();
            return;
        }
        long l = System.currentTimeMillis();
        if (l >= this.mbg) {
            this.mgd(lxu.AH_OPEN);
            return;
        }
        this.mgf(a.d("\u88c4\uf110\u7bb3\ue5cf\u6e1d\ue8af\u52ff\udb7f\u455c\ucbf8\u4834\ub244\u3c96\ua521\u2f71\uad92\u17d1\u9c1f\u06a6\u8082\u0900\u7356\ufd9c\u6647\ue03b\u6a98\ud329\u5d71\uc7f3\u45cc\uca18\u34bb\ube81\u2705\ua154\u2ff2", 420682161, -1446537868) + (this.mbg - l + 999L) / 1000L + a.c(1136746110, "\u5e5c\u238c"), false);
        this.mgd(lxu.FULL_WAIT);
    }

    private void mdf() {
        if (System.currentTimeMillis() >= this.mbg) {
            this.mgd(lxu.AH_OPEN);
        }
    }

    private void mdg() {
        if (this.mfn()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!this.mfv(l, 0)) {
            return;
        }
        this.mbg = l + 60000L + ThreadLocalRandom.current().nextLong(400L, 4000L);
        this.map = true;
        this.mfs(a.b("\ue5a7\u9c1f", -1435703868));
        this.mgd(lxu.AH_STORAGE);
    }

    private void mdh() {
        int n = this.mdl(a.c(612614747, "\uc616\ubfa2\u3501\uab7d\u20af\ua61d\u1c4d\u95cd"));
        if (n < 0 || !this.mdn() || !this.mfp()) {
            return;
        }
        this.mfr(n, SlotActionType.field_7790, 0);
        pdi.note(0);
        this.mgd(lxu.AH_RELIST);
    }

    private void mdi() {
        int n = this.mdl(a.b("\u10cf\u6974\ue3d2\u7dd6\uf606\u70ce\uca97\u4365\udd48\u57fb", -223800070));
        if (n < 0 || !this.mdn() || !this.mfp()) {
            return;
        }
        int n2 = this.mdm();
        if (n2 > 0) {
            this.mfr(n, SlotActionType.field_7790, 0);
            pdi.note(0);
            this.mgf(a.d("\udf1d\ua686\u2c20\ub224\u39f4\ubf3c\u0565\u8c97\u12ba\u9809\u1fd3\ue5d6\u6b00\uf6c5\u7c8c", 1755457151, -1874920078) + n2, true);
        } else {
            this.mgf(a.b("\u152f\u6cfb\ue658\u7824\uf3f6\u7544\ucf14\u4694\ud8b7\u5613\ud5df\u2fd2\ua107\u38b5\ub29a\u3460\u8a36\u05eb\u9b39\u1d12\u94e0\ueecd\u6077\uffcd\u7da5\uf773\u4ecd\uc0ee\u5a14\udc4c\u5394\ua95e\u2314\uba99\u3cb8\ub605\u09d6", 1226445103), false);
        }
        this.mdj();
    }

    private void mdj() {
        this.mfq();
        this.mbm = 0;
        this.mbn = "";
        long l = System.currentTimeMillis();
        this.mag = 0L;
        this.mac = Math.max(this.mac, l + lxy.mfz(1600L, 0.35, 900L, 4000L));
        this.mab = l + 250L + ThreadLocalRandom.current().nextLong(0L, 350L);
        this.mgd(this.maq.method_7960() ? lxu.IDLE : lxu.TAKE);
    }

    private boolean mdk() {
        return this.lzz == lxu.FULL_WAIT || this.lzz == lxu.AH_OPEN || this.lzz == lxu.AH_STORAGE || this.lzz == lxu.AH_RELIST;
    }

    private int mdl(String string) {
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        ScreenHandler screenHandler = clientPlayerEntity.field_7512;
        if (!(this.mc.field_1755 instanceof HandledScreen) || screenHandler == null || screenHandler == clientPlayerEntity.field_7498) {
            return -1;
        }
        int n = screenHandler.field_7761.size() - 36;
        if (n < 9) {
            return -1;
        }
        for (int i = n - 9; i < n; ++i) {
            ItemStack itemStack = ((Slot)screenHandler.field_7761.get(i)).method_7677();
            if (itemStack.method_7960() || !pfl.title(itemStack.method_7964().getString()).contains(string)) continue;
            return i;
        }
        return -1;
    }

    private int mdm() {
        ScreenHandler screenHandler = this.mc.field_1724.field_7512;
        int n = screenHandler.field_7761.size() - 36;
        int n2 = 0;
        for (int i = 0; i < n - 9; ++i) {
            if (((Slot)screenHandler.field_7761.get(i)).method_7677().method_7960()) continue;
            ++n2;
        }
        return n2;
    }

    private boolean mdn() {
        long l;
        if (this.mbh != 0L) {
            return true;
        }
        this.mbh = l = System.currentTimeMillis();
        double d = lxy.mga(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.25, 0.7, 1.9);
        long l2 = (long)(380.0 * d) + ThreadLocalRandom.current().nextLong(10L, 90L);
        this.mab = Math.max(this.mab, l + l2);
        return false;
    }

    private boolean mdo() {
        if (!this.lzy.get()) {
            return false;
        }
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity.method_5765() || !lxy.meq(clientPlayerEntity.method_31548()) || this.mee()) {
            return false;
        }
        long l = System.currentTimeMillis();
        if (oqv.listEmpty()) {
            if (!this.mcf && this.mdp(l) != null) {
                this.mcf = true;
                this.mgf(a.b("\u3581\u4c2e\uc6fa\u58f2\ud35a\u55ef\ueba6\u6234\ufc40\u76fc\uf139\u0b4f\u85a0\u1c32\u9661\u108b\uaad5\u2513\ubff2\u3dbc\ub437\uce64\u40d4", -10079817), false);
            }
            return false;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.mbs = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        this.mbt = (threadLocalRandom.nextDouble() - 0.5) * 0.25;
        this.mbu = (threadLocalRandom.nextDouble() - 0.5) * 0.3;
        BlockPos blockPos = this.mdp(l);
        if (blockPos == null) {
            return false;
        }
        this.mbp = blockPos;
        this.mbq = lxy.mel((World)this.mc.field_1687, blockPos);
        this.mbr = this.meg(blockPos);
        this.mbv = 1 + threadLocalRandom.nextInt(4);
        this.mbw = 0L;
        this.meb(clientPlayerEntity);
        this.mgd(lxu.CHEST_OPEN);
        return true;
    }

    private BlockPos mdp(long l) {
        ClientWorld clientWorld = this.mc.field_1687;
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        Vec3d vec3d = clientPlayerEntity.method_33571();
        double d = 28.09;
        BlockPos blockPos = null;
        double d2 = Double.MAX_VALUE;
        int n = clientPlayerEntity.method_31477() >> 4;
        int n2 = clientPlayerEntity.method_31479() >> 4;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                WorldChunk worldChunk = clientWorld.method_2935().method_12126(n + i, n2 + j, false);
                if (worldChunk == null) continue;
                for (BlockEntity blockEntity : worldChunk.method_12214().values()) {
                    int n3;
                    BlockPos blockPos2;
                    Long l2;
                    BlockPos blockPos3;
                    if (!(blockEntity instanceof ChestBlockEntity) && !(blockEntity instanceof BarrelBlockEntity) || vec3d.method_1025(Vec3d.method_24953((Vec3i)(blockPos3 = blockEntity.method_11016()))) > d || (l2 = this.mbo.get(blockPos2 = lxy.mel((World)clientWorld, blockPos3))) != null && l2 > l || (n3 = oqv.markState(clientWorld, blockPos3)) == 1 || n3 == 2 && l2 == null) continue;
                    if (lxy.mem((World)clientWorld, blockPos3)) {
                        this.mbo.put(blockPos2, Long.MAX_VALUE);
                        continue;
                    }
                    Vec3d vec3d2 = this.meg(blockPos3);
                    double d3 = vec3d2 == null ? Double.MAX_VALUE : vec3d.method_1025(vec3d2);
                    double d4 = d3;
                    if (!(d4 <= 18.49) || !(d4 < d2)) continue;
                    d2 = d4;
                    blockPos = blockPos3.method_10062();
                }
            }
        }
        return blockPos;
    }

    private void mdq() {
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        long l = System.currentTimeMillis();
        ClientWorld clientWorld = this.mc.field_1687;
        if (this.mbw > 0L && this.mc.field_1755 instanceof HandledScreen && this.mdr((World)clientWorld, clientPlayerEntity.field_7512, l)) {
            this.mds(l);
            return;
        }
        if (this.mfn()) {
            return;
        }
        if (this.mbp == null || !lxy.mej((World)clientWorld, this.mbp)) {
            this.mdu(Long.MAX_VALUE, null, false, 0);
            return;
        }
        Vec3d vec3d = clientPlayerEntity.method_33571();
        if (this.mbr == null || vec3d.method_1022(this.mbr) > 4.3) {
            this.mbr = this.meg(this.mbp);
            if (this.mbr == null || vec3d.method_1022(this.mbr) > 4.3) {
                this.mdu(l + 60000L, null, false, 0);
                return;
            }
        }
        this.mea();
        float f = vxr.getFloat(lzr, clientPlayerEntity, clientPlayerEntity.method_36454());
        float f2 = vxr.getFloat(lzs, clientPlayerEntity, clientPlayerEntity.method_36455());
        BlockHitResult blockHitResult = this.mdw(clientPlayerEntity, f, f2);
        if (blockHitResult != null && this.mei((World)clientWorld, blockHitResult.method_17777())) {
            if (this.mbv > 0) {
                --this.mbv;
            } else if (l - this.mbw > 1500L && !clientPlayerEntity.method_5715() && !clientPlayerEntity.method_6115() && vyn.serverIdle(clientPlayerEntity)) {
                this.mdx();
                this.mbw = l;
            }
        }
        this.mec(this.mbr, this.meh((World)clientWorld, this.mbp, this.mbr));
    }

    private boolean mdr(World world, ScreenHandler screenHandler, long l) {
        int n;
        GenericContainerScreenHandler genericContainerScreenHandler;
        block5: {
            block4: {
                if (!(screenHandler instanceof GenericContainerScreenHandler)) break block4;
                genericContainerScreenHandler = (GenericContainerScreenHandler)screenHandler;
                if (l - this.mbw <= 3000L && this.mbp != null) break block5;
            }
            return false;
        }
        int n2 = n = lxy.mek(world, this.mbp) != null ? 6 : 3;
        if (genericContainerScreenHandler.method_17388() != n) {
            return false;
        }
        String string = pfl.title(this.mc.field_1755.method_25440().getString());
        return !string.contains(a.b("\u5847\u2185\uab2f\u3522\ube8b\u383c\u826c", 2133023856)) && !string.contains(a.c(-2092048698, "\uda8b\ua33f\u299c\ub7e0\u3c32\uba80\u00d0\u8950"));
    }

    private void mds(long l) {
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        this.mcc = this.mc.field_1724.field_7512.field_7763;
        this.mcd = new ItemStack[9];
        for (int i = 0; i < 9; ++i) {
            this.mcd[i] = playerInventory.method_5438(i).method_7972();
        }
        this.mby = 0;
        this.mbz = 0;
        this.mcb = -1;
        this.mca = lxy.men(playerInventory);
        this.mab = l + this.mcg.draw(0);
        this.mgd(lxu.CHEST_LOOT);
    }

    private void mdt() {
        int n;
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        long l = System.currentTimeMillis();
        ScreenHandler screenHandler = clientPlayerEntity.field_7512;
        if (!(this.mc.field_1755 instanceof HandledScreen) || !(screenHandler instanceof GenericContainerScreenHandler) || screenHandler.field_7763 != this.mcc) {
            this.mdu(l + 15000L, null, true, this.mbz > 0 ? 2 : 0);
            return;
        }
        if (l < this.mab || !vyn.serverIdle(clientPlayerEntity)) {
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (this.mby >= 4 && this.mby % 4 == 0 && lxy.men(playerInventory) <= this.mca) {
            this.mdv();
            this.mdu(Long.MAX_VALUE, a.d("\ue0cc\u991f\u13b2\u8dca\u066a\u80a2\u3eeb\ub307\u2d50\ua3f4\u2039\uda34\u5495\ucd20\u4712\uc1f0\u7fdd\uf41e\u6eaa\ue887\u6101", 779925535, 2105564391), false, 2);
            return;
        }
        int n2 = screenHandler.field_7761.size() - 36;
        int n3 = -1;
        double d = Double.MAX_VALUE;
        boolean bl = false;
        for (n = 0; n < n2; ++n) {
            double d2;
            ItemStack itemStack = ((Slot)screenHandler.field_7761.get(n)).method_7677();
            if (itemStack.method_7960() || this.mat.contains(lxy.mfa(itemStack)) || !oqv.wantsItem(itemStack.method_7909())) continue;
            if (!lxy.mep(playerInventory, itemStack)) {
                bl = true;
                continue;
            }
            double d3 = d2 = this.mcb < 0 ? (double)n * 0.01 : lxy.meo(this.mcb, n);
            if (!(d2 < d)) continue;
            d = d2;
            n3 = n;
        }
        if (n3 < 0 || this.mby >= 64) {
            n = bl || n3 >= 0 ? 1 : 0;
            this.mdv();
            this.mdu(n != 0 ? 0L : Long.MAX_VALUE, this.mbz > 0 ? a.c(-459243703, "\u7b5d\u02c3\u8c07\u1617\u9dc2\u1b0d\ua157\u28d1\ub6f7\u3c4c\ubf95\u45fe") + this.mbz : null, true, n != 0 ? 2 : 1);
            return;
        }
        this.mc.field_1761.method_2906(screenHandler.field_7763, n3, 0, SlotActionType.field_7794, (PlayerEntity)clientPlayerEntity);
        ++this.mbz;
        this.mcb = n3;
        this.mab = l + this.mcg.draw(this.mby++ == 0 ? 1 : 2);
    }

    private void mdu(long l, String string, boolean bl, int n) {
        if (this.mbq != null) {
            this.mbo.put(this.mbq, l);
        }
        if (n != 0 && this.mbp != null) {
            oqv.markFromOutside(this.mc.field_1687, this.mbp, n == 2);
        }
        if (bl && this.mcd != null) {
            PlayerInventory playerInventory = this.mc.field_1724.method_31548();
            for (int i = 0; i < 9; ++i) {
                if (!this.mcd[i].method_7960() || playerInventory.method_5438(i).method_7960()) continue;
                this.mce[i] = true;
            }
        }
        if (string != null) {
            this.mgf(string, bl);
        }
        this.med();
        this.mfq();
        this.mbp = null;
        this.mbq = null;
        this.mbr = null;
        this.mbw = 0L;
        this.mcd = null;
        this.mah = System.currentTimeMillis() + this.mcg.draw(0);
        this.mgd(lxu.IDLE);
    }

    private void mdv() {
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity.field_7512 != clientPlayerEntity.field_7498) {
            clientPlayerEntity.method_7346();
        }
    }

    private BlockHitResult mdw(ClientPlayerEntity clientPlayerEntity, float f, float f2) {
        Vec3d vec3d;
        Vec3d vec3d2;
        Vec3d vec3d3 = clientPlayerEntity.method_33571();
        BlockHitResult blockHitResult = this.mc.field_1687.method_17742(new RaycastContext(vec3d3, vec3d2 = vec3d3.method_1019((vec3d = Vec3d.method_1030((float)f2, (float)f)).method_1021(clientPlayerEntity.method_55754())), RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, (Entity)clientPlayerEntity));
        return blockHitResult.method_17783() == HitResult.Type.field_1332 ? blockHitResult : null;
    }

    private void mdx() {
        GameOptions gameOptions = this.mc.field_1690;
        if (gameOptions == null) {
            return;
        }
        gameOptions.field_1904.method_23481(true);
        this.mbx = true;
    }

    private void mdy() {
        if (!this.mbx) {
            return;
        }
        this.mbx = false;
        if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
            this.mc.field_1690.field_1904.method_23481(vzz.isPhysicallyDown(this.mc, this.mc.field_1690.field_1904));
        }
    }

    private void mdz() {
        GameOptions gameOptions = this.mc.field_1690;
        if (gameOptions == null) {
            return;
        }
        while (gameOptions.field_1886.method_1436()) {
        }
        while (gameOptions.field_1904.method_1436()) {
        }
    }

    private void mea() {
        if (!this.mbe) {
            this.mbe = true;
            this.mbf.hold(this.mc);
        }
    }

    private void meb(ClientPlayerEntity clientPlayerEntity) {
        if (this.mci != clientPlayerEntity) {
            this.mci = clientPlayerEntity;
            this.mch.personalize(lxy.mef(clientPlayerEntity.method_7334().name()));
        }
        if (!this.mcj) {
            boolean bl = pud.INSTANCE.engaged();
            float f = bl ? vxr.getFloat(lzr, clientPlayerEntity, clientPlayerEntity.method_36454()) : clientPlayerEntity.method_36454();
            float f2 = bl ? vxr.getFloat(lzs, clientPlayerEntity, clientPlayerEntity.method_36455()) : clientPlayerEntity.method_36455();
            this.mch.reset(f, f2);
        }
    }

    private void mec(Vec3d vec3d, double d) {
        float[] fArray = prt.calculateAngle(vec3d);
        this.mch.setMouseStep(prp.step());
        this.mch.aim(fArray[0], fArray[1], d);
        pud.INSTANCE.set(this, this.mch.getYaw(), MathHelper.method_15363((float)this.mch.getPitch(), (float)-90.0f, (float)90.0f));
        this.mcj = true;
    }

    private void med() {
        if (this.mcj) {
            this.mcj = false;
            this.mck = System.currentTimeMillis();
            pud.INSTANCE.release(this.mc.field_1724);
        }
    }

    private boolean mee() {
        return !this.mcj && pud.INSTANCE.engaged() && System.currentTimeMillis() - this.mck > 1000L;
    }

    private static long mef(String string) {
        long l = 1125899906842597L;
        if (string != null) {
            for (int i = 0; i < string.length(); ++i) {
                l = l * 31L + (long)Character.toLowerCase(string.charAt(i));
            }
        }
        return l;
    }

    private Vec3d meg(BlockPos blockPos) {
        Vec3d[] vec3dArray;
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        ClientWorld clientWorld = this.mc.field_1687;
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = Vec3d.method_24953((Vec3i)blockPos);
        BlockPos blockPos2 = lxy.mek((World)clientWorld, blockPos);
        for (Vec3d vec3d3 : vec3dArray = new Vec3d[]{vec3d2.method_1031(this.mbs, this.mbt, this.mbu), vec3d2.method_1031(0.0, 0.3, 0.0), vec3d2.method_1031(0.0, -0.2, 0.0), vec3d2.method_1031(0.3, 0.0, 0.0), vec3d2.method_1031(-0.3, 0.0, 0.0), vec3d2.method_1031(0.0, 0.0, 0.3), vec3d2.method_1031(0.0, 0.0, -0.3)}) {
            BlockHitResult blockHitResult = clientWorld.method_17742(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.field_17559, RaycastContext.FluidHandling.field_1348, (Entity)clientPlayerEntity));
            if (blockHitResult.method_17783() != HitResult.Type.field_1332 || !blockHitResult.method_17777().equals((Object)blockPos) && !blockHitResult.method_17777().equals((Object)blockPos2)) continue;
            return vec3d3;
        }
        return null;
    }

    private double meh(World world, BlockPos blockPos, Vec3d vec3d) {
        VoxelShape voxelShape = world.method_8320(blockPos).method_26218((BlockView)world, blockPos);
        Box box = voxelShape.method_1110() ? new Box(blockPos) : voxelShape.method_1107().method_996(blockPos);
        double d = Math.min(Math.min(Math.min(vec3d.field_1352 - box.field_1323, box.field_1320 - vec3d.field_1352), Math.min(vec3d.field_1351 - box.field_1322, box.field_1325 - vec3d.field_1351)), Math.min(vec3d.field_1350 - box.field_1321, box.field_1324 - vec3d.field_1350));
        if (d <= 0.02) {
            return 0.25;
        }
        double d2 = Math.max(0.5, this.mc.field_1724.method_33571().method_1022(vec3d));
        return MathHelper.method_15350((double)(Math.toDegrees(Math.atan2(d, d2)) * 0.55), (double)0.25, (double)4.0);
    }

    private boolean mei(World world, BlockPos blockPos) {
        if (blockPos == null || this.mbp == null) {
            return false;
        }
        return blockPos.equals((Object)this.mbp) || blockPos.equals((Object)lxy.mek(world, this.mbp));
    }

    private static boolean mej(World world, BlockPos blockPos) {
        BlockEntity blockEntity = world.method_8321(blockPos);
        return blockEntity instanceof ChestBlockEntity || blockEntity instanceof BarrelBlockEntity;
    }

    private static BlockPos mek(World world, BlockPos blockPos) {
        BlockState blockState = world.method_8320(blockPos);
        if (blockState.method_26204() instanceof ChestBlock && blockState.method_28498((Property)ChestBlock.field_10770) && blockState.method_11654((Property)ChestBlock.field_10770) != ChestType.field_12569) {
            return blockPos.method_10093(ChestBlock.method_9758((BlockState)blockState));
        }
        return null;
    }

    private static BlockPos mel(World world, BlockPos blockPos) {
        BlockPos blockPos2 = lxy.mek(world, blockPos);
        return (blockPos2 != null && blockPos2.method_10063() < blockPos.method_10063() ? blockPos2 : blockPos).method_10062();
    }

    private static boolean mem(World world, BlockPos blockPos) {
        if (!(world.method_8320(blockPos).method_26204() instanceof ChestBlock)) {
            return false;
        }
        BlockPos blockPos2 = lxy.mek(world, blockPos);
        return ChestBlock.method_9756((WorldAccess)world, (BlockPos)blockPos) || blockPos2 != null && ChestBlock.method_9756((WorldAccess)world, (BlockPos)blockPos2);
    }

    private static int men(PlayerInventory playerInventory) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.method_5438(i);
            if (itemStack.method_7960() || !oqv.wantsItem(itemStack.method_7909())) continue;
            n += itemStack.method_7947();
        }
        return n;
    }

    private static double meo(int n, int n2) {
        int n3 = n % 9 - n2 % 9;
        int n4 = n / 9 - n2 / 9;
        return Math.sqrt(n3 * n3 + n4 * n4);
    }

    private static boolean mep(PlayerInventory playerInventory, ItemStack itemStack) {
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack2 = playerInventory.method_5438(i);
            if (itemStack2.method_7960()) {
                return true;
            }
            if (itemStack2.method_7947() >= itemStack2.method_7914() || !ItemStack.method_31577((ItemStack)itemStack2, (ItemStack)itemStack)) continue;
            return true;
        }
        return false;
    }

    private static boolean meq(PlayerInventory playerInventory) {
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.method_5438(i).method_7960()) continue;
            return true;
        }
        return false;
    }

    private int mer(List<ItemStack> list, ItemStack itemStack) {
        int n = this.mes(list, itemStack, 0);
        if (n <= 0) {
            n = this.mes(list, itemStack, 1);
        }
        if (n <= 0 && lxy.mfc(itemStack).isEmpty()) {
            n = this.mes(list, itemStack, 2);
        }
        return n;
    }

    private int mes(List<ItemStack> list, ItemStack itemStack, int n) {
        int n2;
        Object object;
        int n3;
        int n4 = Math.max(0, list.size() - 36);
        String string = lxy.mfg(this.mc.field_1724.method_7334().name());
        Map<String, Integer> map = lxy.mfc(itemStack);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n3 = 0; n3 < n4; ++n3) {
            object = list.get(n3);
            if (object == null || object.method_7960() || !this.met((ItemStack)object, itemStack, map, n) || (n2 = lxy.mew(lxy.mff((ItemStack)object), string)) <= 0) continue;
            arrayList.add(Math.max(1, n2 / Math.max(1, object.method_7947())));
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

    private boolean met(ItemStack itemStack, ItemStack itemStack2, Map<String, Integer> map, int n) {
        if (itemStack.method_7909() != itemStack2.method_7909()) {
            return false;
        }
        String string = lxy.cleanQuery(itemStack.method_7964().getString());
        String string2 = lxy.cleanQuery(itemStack2.method_7964().getString());
        if (string.isEmpty() || string2.isEmpty()) {
            return false;
        }
        if (!(string.equals(string2) || string.contains(string2) || string2.contains(string))) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        Map<String, Integer> map2 = lxy.mfc(itemStack);
        if (n == 0) {
            return map.equals(map2) && lxy.meu(itemStack, itemStack2);
        }
        return lxy.mev(map, map2) >= this.lzv.get() / 100.0;
    }

    private static boolean meu(ItemStack itemStack, ItemStack itemStack2) {
        List<String> list = lxy.mff(itemStack2);
        if (list.size() <= 1) {
            return true;
        }
        List<String> list2 = lxy.mff(itemStack);
        for (int i = 1; i < list.size(); ++i) {
            String string = list.get(i);
            if (string.isEmpty() || list2.contains(string)) continue;
            return false;
        }
        return true;
    }

    private static double mev(Map<String, Integer> map, Map<String, Integer> map2) {
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

    private static int mew(List<String> list, String string) {
        int n = -1;
        for (int i = 0; i < list.size(); ++i) {
            String string2 = list.get(i);
            if (string2.contains(a.c(-599991091, "\ud887\ua133\u2b9c\ub5e2\u3e4f\ubc95\u02d1\u8b27\u1579\u9fb9\u181a\ue219\u6cc0")) || string2.contains(a.d("\ua4cb\udd72\u53b4\uc9d5\u4208\uc4c1\u7e93\uf711\u6945", 399891685, 819231770))) {
                return -1;
            }
            if (!string.isEmpty() && string2.contains(string) && (string2.contains(a.b("\u6439\u1df7\u975a\u0921\u82f2\u0441", -2103943168)) || string2.contains(a.c(1431363554, "\udbd6\ua26e\u28b6\ub6c3\u3d15\ubbaa")))) {
                return -1;
            }
            if (n > 0 || i == 0) continue;
            int n2 = string2.indexOf(a.c(647994328, "\u9f9d\ue65f\u6c84"));
            if (n2 < 0) {
                n2 = string2.indexOf(a.d("\ub73f\uce8c\u4444\uda3f\u51ee", -450008059, -1141777585));
            }
            if (n2 < 0) {
                n2 = string2.indexOf(36);
            }
            if (n2 < 0) continue;
            int n3 = string2.indexOf(58, n2);
            n = lxy.mex(string2, n3 >= 0 ? n3 + 1 : n2);
        }
        return n;
    }

    private static int mex(String string, int n) {
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
            if (bl && !lxy.mey(c)) break;
        }
        return bl && l > 0L ? (int)l : -1;
    }

    private static boolean mey(char c) {
        return c == ' ' || c == ',' || c == '.' || c == '\u00a0' || c == '\u202f';
    }

    private static long mez(long l) {
        long l2;
        long l3 = l;
        for (long i = 10L; i <= 10000L && l / i >= 10L && (l2 = (l + 1L) / i * i - 1L) > 0L && l - l2 <= Math.max(1L, l / 20L); i *= 10L) {
            l3 = l2;
        }
        return l3;
    }

    private static String mfa(ItemStack itemStack) {
        return String.valueOf(itemStack.method_7909()) + '|' + lxy.mfg(itemStack.method_7964().getString()) + '|' + lxy.mfe(itemStack);
    }

    private static boolean mfb(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null || itemStack.method_7960() || itemStack2.method_7960()) {
            return false;
        }
        return itemStack.method_7909() == itemStack2.method_7909() && lxy.mfa(itemStack).equals(lxy.mfa(itemStack2));
    }

    private static Map<String, Integer> mfc(ItemStack itemStack) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        if (itemStack == null || itemStack.method_7960()) {
            return treeMap;
        }
        try {
            lxy.mfd((ItemEnchantmentsComponent)itemStack.method_58694(DataComponentTypes.field_49633), treeMap);
            lxy.mfd((ItemEnchantmentsComponent)itemStack.method_58694(DataComponentTypes.field_49643), treeMap);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return treeMap;
    }

    private static void mfd(ItemEnchantmentsComponent itemEnchantmentsComponent, Map<String, Integer> map) {
        if (itemEnchantmentsComponent == null || itemEnchantmentsComponent.method_57543()) {
            return;
        }
        for (RegistryEntry registryEntry : itemEnchantmentsComponent.method_57534()) {
            String string = registryEntry.method_40230().map(registryKey -> registryKey.method_29177().method_12832()).orElse("");
            if (string.isEmpty()) continue;
            map.put(string, itemEnchantmentsComponent.method_57536(registryEntry));
        }
    }

    private static String mfe(ItemStack itemStack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : lxy.mfc(itemStack).entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue()).append(',');
        }
        return stringBuilder.toString();
    }

    private static List<String> mff(ItemStack itemStack) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            arrayList.add(lxy.mfg(itemStack.method_7964().getString()));
            LoreComponent loreComponent = (LoreComponent)itemStack.method_58694(DataComponentTypes.field_49632);
            if (loreComponent != null) {
                for (Text text : loreComponent.comp_2400()) {
                    if (text == null) continue;
                    arrayList.add(lxy.mfg(text.getString()));
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return arrayList;
    }

    private static String mfg(String string) {
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

    private static boolean mfh(String string) {
        String string2 = pfl.title(string);
        return string2.contains(a.b("\u3bdb\u426f\uc8cc\u56b0\udd62\u5bd0\ue180\u6800", 2064990102)) && lxy.mfi(string2, lyn);
    }

    private static boolean mfi(String string, String[] stringArray) {
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private int mfj() {
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        int n = -1;
        int n2 = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack;
            if (!this.mcp(i) || !lxy.mfb(itemStack = playerInventory.method_5438(i), this.maq) || itemStack.method_7947() <= n2) continue;
            n2 = itemStack.method_7947();
            n = i;
        }
        return n;
    }

    private int mfk() {
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack;
            if (!this.mcp(i) || !lxy.mfb(itemStack = playerInventory.method_5438(i), this.maq)) continue;
            n += itemStack.method_7947();
        }
        return n;
    }

    private int mfl() {
        if (this.mba >= 0) {
            return this.mba;
        }
        PlayerInventory playerInventory = this.mc.field_1724.method_31548();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) {
            if (!playerInventory.method_5438(i).method_7960()) continue;
            arrayList.add(i);
        }
        if (arrayList.isEmpty()) {
            return playerInventory.method_67532();
        }
        return (Integer)arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
    }

    private static int mfm(int n) {
        return n < 9 ? 36 + n : n;
    }

    private boolean mfn() {
        Screen screen = this.mc.field_1755;
        if (screen == null) {
            return false;
        }
        if (!(screen instanceof HandledScreen)) {
            this.maa = System.currentTimeMillis();
            return true;
        }
        if (this.mft()) {
            this.mc.field_1724.method_7346();
            this.mac = Math.max(this.mac, System.currentTimeMillis() + lxy.mfx());
        }
        return true;
    }

    private boolean mfo() {
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity.field_7512 != clientPlayerEntity.field_7498) {
            return false;
        }
        return this.mfp();
    }

    private boolean mfp() {
        if (this.mcj || pud.INSTANCE.engaged() && System.currentTimeMillis() - this.mck < 1000L) {
            return false;
        }
        if (!this.mft()) {
            return false;
        }
        if (!this.mbe) {
            this.mbe = true;
            return false;
        }
        return vyn.serverIdle(this.mc.field_1724);
    }

    private void mfq() {
        if (this.mbe) {
            this.mbf.release(this.mc);
            this.mbe = false;
        }
    }

    private void mfr(int n, SlotActionType slotActionType, int n2) {
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity == null || this.mc.field_1761 == null) {
            return;
        }
        ScreenHandler screenHandler = clientPlayerEntity.field_7512;
        if (screenHandler == null || n < 0 || n >= screenHandler.field_7761.size()) {
            return;
        }
        this.mc.field_1761.method_2906(screenHandler.field_7763, n, n2, slotActionType, (PlayerEntity)clientPlayerEntity);
        this.mab = System.currentTimeMillis() + this.mfu();
    }

    private void mfs(String string) {
        long l;
        if (this.mc.method_1562() == null) {
            return;
        }
        this.mc.method_1562().method_45730(string);
        this.mag = l = System.currentTimeMillis();
        this.mad = l;
        this.mae = -1L;
    }

    private boolean mft() {
        long l = System.currentTimeMillis();
        if (l < this.mab) {
            return false;
        }
        this.mab = l + this.mfu();
        return true;
    }

    private long mfu() {
        double d = lxy.mga(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.22, 0.72, 1.8);
        long l = (long)(110.0 * d);
        if (ThreadLocalRandom.current().nextInt(100) < 6) {
            l += ThreadLocalRandom.current().nextLong(140L, 520L);
        }
        return l + ThreadLocalRandom.current().nextLong(10L, 60L);
    }

    private boolean mfv(long l, int n) {
        long l2;
        if (this.mae < 0L || this.maf != n) {
            this.mae = this.mfw(n);
            this.maf = n;
        }
        if (l < Math.max(this.mac, this.mad + this.mae)) {
            this.maa = l;
            return false;
        }
        long l3 = l2 = n == 1 ? l : pdi.nextFree(n, this.lzx.getInt(), l);
        if (l2 <= l) {
            return true;
        }
        this.mac = l2 + lxy.mfz(900L, 0.6, 150L, 5000L);
        this.maa = l;
        if (this.mac - l > 5000L && l - this.mak > 20000L) {
            this.mak = l;
            this.mgf(a.c(-790457063, "\u9116\ue884\u6253\ufc26\u778b\uf558\u4b1b\uc299\u5cbf\ud672\u51df\uaba8\u257c\ubcc0\u328f\ub472\u0a2b\u85f8\u1f3c\u9d0e") + (this.mac - l + 999L) / 1000L + a.b("\uf443\u8993", -1749552031), false);
        }
        return false;
    }

    private long mfw(int n) {
        if (n == 1) {
            return this.mcg.draw(3, 1.4);
        }
        double d = 60000.0 / (double)pdi.limit(this.lzx.getInt());
        return this.mcg.draw(4, d * 0.75 / 1500.0);
    }

    private static long mfx() {
        return lxy.mfz(850L, 0.35, 450L, 3000L);
    }

    private static int mfy() {
        return 14 + ThreadLocalRandom.current().nextInt(11);
    }

    private static long mfz(long l, double d, long l2, long l3) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long l4 = l;
        for (int i = 0; i < 12; ++i) {
            l4 = Math.round((double)l * Math.exp(d * threadLocalRandom.nextGaussian()));
            if (l4 < l2 || l4 > l3) continue;
            return l4;
        }
        return Math.max(l2, Math.min(l3, l4));
    }

    private static double mga(double d, double d2, double d3) {
        return d < d2 ? d2 : (d > d3 ? d3 : d);
    }

    private boolean mgb() {
        this.mbm = 0;
        this.mbi = false;
        if (pdi.warn() >= 2) {
            this.mgf(a.b("\u2455\u5df0\ud756\u4955\uc285\u4441\ufa72\u77e3\ue9c9\u637b\ue4ab\u1ead\u9418\u09b3\u83e4\u0517\ubf54\u3088\uaa32\u2c1c", -1920524192), false);
            this.mcs();
            return false;
        }
        long l = System.currentTimeMillis();
        long l2 = lxy.mfz(25000L, 0.25, 15000L, 45000L);
        this.mac = Math.max(this.mac, l + l2);
        this.mgf(a.c(870016198, "\u60f8\u195d\u93fb\u0df8\u8628\u00ec\ubedf\u3331\uad11\u27de\ua072\u5a7a\ud4d7\u4904\uc74b\u41b3\ufbfd\u7423\uee9e\u68c7\ue130\u9b69\u15da\u8a12\u0c61\u82af\u3b13\ub531\u2fb2\ua9e4\u2647") + (l2 + 999L) / 1000L + a.c(519189454, "\u33ec\u4e3c"), false);
        this.maa = l;
        return true;
    }

    private void mgc() {
        String string;
        String string2 = this.mbn;
        String string3 = string = string2.isEmpty() ? a.d("\u9098\ue97a\u63d0\ufddd\u7674\uf0c3\u4a93\uc77f\u5d3e\ud7f3\u5058\uaa23\u24f3\ubd45\u371d", 1303802709, 909109202) : a.c(1884055245, "\u62cc\u1b2e\u9184\u0f89\u8420\u0297\ub8c7\u352b\uaf6a\u25a7\ua20c\u5877\ud6a7\u4f11\uc549\u47b9\ufdec") + string2;
        if (++this.mal >= 3) {
            this.mgf(string, false);
            this.mcs();
            return;
        }
        this.mcr(string, false, true);
    }

    private void mgd(lxu lxu2) {
        if (this.lzz != lxu2) {
            this.lzz = lxu2;
            this.maa = System.currentTimeMillis();
            this.mbh = 0L;
        }
    }

    private void mge() {
        this.mfq();
        this.mdy();
        this.med();
        this.mbp = null;
        this.mbq = null;
        this.mbr = null;
        this.mbw = 0L;
        this.mcd = null;
        Arrays.fill(this.mce, false);
        this.lzz = lxu.IDLE;
        this.maa = 0L;
        this.mbh = 0L;
        this.maz = false;
        this.mbi = false;
        this.mbm = 0;
        this.mbn = "";
        this.maq = ItemStack.field_8037;
        this.mar = "";
        this.mas = "";
        this.mav = -1;
        this.max = 0;
        this.mal = 0;
        this.mam = 0L;
        this.map = false;
        this.maw = 0;
        this.mba = -1;
        this.mbb = -1;
        this.mbc = -1;
        this.mbd = -1;
    }

    private void mgf(String string, boolean bl) {
        System.out.println(a.c(1141262067, "\u46b9\u3f3c\ub5f9\u2ba3\ua059\u26e1\u9cae\u154a\u8b02\u01fb\u8632") + string);
        izx.alert(this.getName(), string, bl ? vhz.CHECK : vhz.INFO, bl);
    }

    private static /* synthetic */ int baq(int n, int n2) {
        return n - n2 | 0x870780ED;
    }

    private static /* synthetic */ int bar(int n, int n2) {
        return n - n2 | 0x63FA094F;
    }

    private static /* synthetic */ int bas(int n, int n2) {
        return lxy.bar(n, n2) + n;
    }
}

