/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.util.InputUtil$Type
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.entity.projectile.WindChargeEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package a;

import a.ett;
import a.iwf;
import a.izx;
import a.kfa;
import a.kfe;
import a.kfx;
import a.kmy;
import a.kvz;
import a.oxc;
import a.oxf;
import a.oxi;
import a.oxt;
import a.prp;
import a.vhz;
import a.vkl;
import a.vlq;
import a.vlv;
import a.vvn;
import a.vyn;
import a.vzz;
import a.wap;
import a.wdq;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public class oxw
extends kfe {
    private static final String oxx = a.c(-312694930, "\ua72f\udead\u5465\uca2e\u41c4\uc771\u7d2a");
    private static final String oxy = a.b("\ube05\uc793\u4d43\ud327\u58de\ude57\u6419\uedf6\u73a1", 741654084);
    private static final String oxz = a.c(47142108, "\u5485\u2d03\ua7d4\u39a8\ub27f\u34db\u8ea6\u076f\u992d\u1382\u9459");
    private static final int oya = 10;
    public static final long FLASH_MS = 700L;
    private static oxw oyb;
    private final vlv oyc = this.add(new vlv(a.b("\ua565\udce2\u5626\uc853\u4397\uc531", 145728816), a.b("\ua4a2\udd20\u57e8\uc9a3\u4249\uc4fc\u7ea7", 922658019), a.b("\u1f34\u66b6\uec7e\u7235\uf9df\u7f6a\uc531", 1607802741), a.c(638333618, "\u32f3\u4b65\uc1b5\u5fd1\ud428\u52a1\ue8ef\u6100\uff57"), a.b("\uaa16\ud390\u5947\uc73b\u4cec\uca48\u7035\uf9fc\u67be\ued11\u6aca", 287550031)));
    private final vlq oyd = this.add(new vlq(a.d("\u5b29\u22a5\ua867\u361e\ubd84\u3b62\u812e\u08d2\u968d\u1c35", 1578664880, 238278874)));
    private final vkl oye = new vkl(a.c(1094840059, "\ueaf9\u931a\u19b1\u87cb\u0c1e\u8aad\u34ee\ub900\u275e\uad90\u2a39\ud046\u5a84\uc722\u4d76\ucbf7\u71b7\ufe1d\u64aa"), true);
    private final vkl oyf = new vkl(a.b("\uaf30\ud6de\u5c06\uc20a\u49d5\ucf60\u7129\ufcca\u6687\ue854\u6ff5\u958d\u1b5f\u82ea\u08bc\u8e43", 1593289535), true);
    private final List<oxf> oyg = new ArrayList<oxf>();
    private final vyn oyh = new vyn(true);
    private final vvn oyi = new vvn();
    private boolean oyj;
    private oxf oyk;
    private oxf oyl;
    private oxf oym;
    private oxt oyn;
    private int oyo;
    private boolean oyp;
    private int oyq;
    private float oyr;
    private boolean oys;
    private int oyt;
    private int oyu = -1;
    private int oyv = -1;
    private boolean oyw;
    private static final float oyx = 83.0f;
    private static final float oyy = 93.0f;
    private static final float oyz = 3.0f;
    private static final float oza = 40.0f;
    private static final float ozb = 65.0f;
    private static final float ozc = 1.6f;
    private static final float ozd = 1.2f;
    private static final float oze = 30.0f;
    private static final float ozf = 55.0f;
    private static final int ozg = 0;
    private static final int ozh = 1;
    private static final int ozi = 0;
    private static final int ozj = 1;
    private static final long ozk = 120L;
    private static final long ozl = 220L;
    private int ozm;
    private long ozn;
    private oxf ozo;
    private float ozp;
    private float ozq;
    private float ozr;
    private float ozs;
    private static final int ozt = 12;
    private int ozu;
    private int ozv = -1;
    private boolean ozw;
    private double ozx;
    private float ozy;
    private float ozz;
    private static /* synthetic */ boolean paa;
    private static /* synthetic */ boolean pab;

    public oxw() {
        super(a.b("\u6aed\u136a\u99ae\u07db\u8c1f\u0ab9\ub0d0\u390c\ua75a\u2df7\uaa31\u5057", 1940810418), a.b("\u7396\u0a09\u80c6\u1ebd\u9539\u13ce\ua994\u2078\ube75\u34a2\ub342\u4928\uc7c5\u5e49\ud41e\u52e7\ue8e1\u673c\ufde7\u7b91\uf265\u8821\u06bc\u9d55\u1b37\u91f8\u2843\ua656\u3ce0\ubabe\u3107\ucf92\u45af\udc69\u5a3e\ud082\u6f55\ue531\u63cc\ufa45\u7007\u0ee8\u84b3\u0346\u99d5\u17af\uae7d\u24c3\ua299\u3959\ub76f\u4df7\uc45d\u421d\ud8e6\u56a9\ued5f\u6b94\ue1b2\u7865\uf6c4\u8c83\u0b23\u8126\u1ff5\u9649\u2c12\uaaae\u20aa\ubf1c\u35c9\ub3ab\u4a7c\uc0c3\u5e9f\ud572\u5371\ue986\u6041\ufe2d\u74e0\uf2fc\u891b\u07d6\u9dac\u1438\u92c2\u2894\ua773\u3d31\ubb89\u3242\uc82e\u46e2\udd5a\u5b5e\ud19d\u6fbc\ue673\u7cdb\ufa8a\u7128\u0f3a\u85ca\u1c45\u9a2b\u10e3\uaf4f\u251e\ua3ee\u39f3\ub015\u4ec5\uc499\u436a\ud932", 1678865321), kfa.PLAYER);
        oyb = this;
        oxf oxf2 = this.pac(a.b("\u4676\u3fd9\ub50d\u2b76", -566475259), a.b("\u2844\u51d2\udb71\u450f\ucea3\u4c06\uf247\u7bb1\ue599\u6f2a\ue889", 1911565400), Items.WIND_CHARGE, null, null, true);
        oxf2.thenMace = true;
        oxf2.groundOnly = true;
        this.add(this.oye);
        this.add(this.oyf);
        this.oye.activeWhen(oxf2.key::isBound);
        this.oyf.activeWhen(oxf2.key::isBound);
        this.pac(a.c(1560444909, "\u7f88\u062d\u8cf9\u129b"), a.d("\u7a98\u0306\u89dd\u17d6\u9c02\u1edc\ua09f\u291d\ub741\u3d80", 1854470058, 1700432169), Items.PHANTOM_MEMBRANE, a.d("\ue473\u9dcd\u1716\u891d\u02c9\u8017\u3e54\ub7d6\u298a\ua34b", -1485713885, 681127531), a.c(998070638, "\u592f\u20ad\uaa65\u342e\ubfc4\u3971\u832a"), false);
        this.pac(a.b("\u0dc9\u747e\ufebe\u60de", -123925063), a.d("\u91c0\ue813\u62b0\ufcce\u771c\uf1a7", 991509486, -1150046710), Items.NETHERITE_SCRAP, a.b("\u135f\u6aec\ue04f\u7e31\uf5e3\u7358", 353507099), a.d("\uda5a\ua3d8\u2910\ub75b\u3cb1\uba04_", -1804833722, 1545647709), false);
        this.pac(a.b("\u412e\u3883\ub25d\u2c3e\ua7ee", -939900581), a.b("\u9c9f\ue50a\u6fd2\uf1d2\u7a06", 840931461), Items.DRIED_KELP, a.b("\u753d\u0c88\u8650\u1850\u9384", 164983047), a.c(-1396543912, "\u6e19\u179b\u9d53\u0318\u88f2\u0e47\ub41c"), false);
        this.pac(a.c(425400577, "\u1961\u60c1\uea14\u7462"), a.c(570113052, "\u3839\u4195\ucb49\u5535\ude9d\u5c43\ue20f\u6b8a\uf5a5\u7f63"), Items.SUGAR, a.d("\u2257\u5b9b\ud147\u4f3b\uc493", 1257307274, -1990141289), a.c(8615486, "\u767f\u0ffd\u8535\u1b7e\u9094\u1621\uac7a"), false);
        this.pac(a.b("\u178c\u6e30\ue4f9\u7a94\uf15e\u77f4\ucdab\u4451\uda14", -1414457375), a.b("\u5484\u2d14\ua7c5\u39bd\ub214\u34dd\u8e83\u077a\u995a\u1399\u943c\u6e33\ue093", 704729245), Items.ENDER_EYE, a.d("\u2f85\u5635\udce4\u429c\uc935\u4ffc\uf5a2\u7c5b\ue27b\u68b8\uef1d\u1512\u9bb2", 709744792, 2083320612), a.c(1603988197, "\ueaa4\u9326\u19ee\u87a5\u0c4f\u8afa\u30a1"), false);
        this.pac(a.d("\ud269\uabc5\u2117\ubf7e\u34bc\ub20e\u0850\u81a1", 27184182, 829890084), a.b("\ud3d1\uaa7c\u20a7\ubed5\u350a\ub3bf\u0df6\u8010\u1e48\u94f5\u1324\ue92b\u6782\ufe3a\u7464\uf29f", -488646688), Items.SNOWBALL, a.c(-1719128060, "\u3455\u4d98\uc743\u5931\ud2ee\u545b\uea12\u67f4\uf9ac\u7311\uf4c0\u0ecf\u8066\u19de\u9380\u157b"), a.c(1228799302, "\ufd07\u8485\u0e4d\u9006\u1bec\u9d59\u2702"), false);
        this.pac(a.d("\uf43f\u8d8a\u075a\u9934\u12e6\u9451\u2e19\ua7eb\u39be", -1424707636, -196322414), a.d("\u00e1\u794e\uf398\u6de8\ue643\u60f9\udad8\u5323", -1589044391, 1401823125), Items.SPLASH_POTION, a.c(1948897813, "\ud658\uaf97\u2541\ubb31\u309a\ub620\u0c01\u85fa"), a.b("\u73ef\u0a6d\u80a5\u1eee\u9504\u13b1\ua9ea", -1351715922), false);
        this.pac(a.b("\ubc2b\uc59d\u4f4d\ud129\u5af0\udc57\u6611\ueff1\u71b9", -2052801462), a.d("\u3fad\u460f\ucca1\u52dd\ud978\u5fb6\ue18a\u6c69\uf23a\u7881\uff56", 1702052246, -1964475887), Items.SPLASH_POTION, a.b("\u8eb2\uf770\u7dde\ue3a2\u6807\ueec9\u50f5\udd16\u4345\uc9fe\u4e29", 186288888), a.d("\u39f1\u4073\ucabb\u54f0\udf1a\u59af\ue3f4", 536310177, 718620689), true);
        this.pac(a.d("\uae4d\ud7f3\u5d29\uc35a\u489a", 153656468, -329829699), a.c(-1635136676, "\ucf40\ub6d3\u3c0e\ua208\u29a6\uab02\u1542\u9cbd\u02ea\u885c\u0f8d"), Items.SPLASH_POTION, a.b("\u7b1a\u02a9\u8874\u1672\u9ddc\u1f78\ua138\u28c7\ub690\u3c26\ubbf7", 1573945126), a.b("\u3496\u4d14\uc7dc\u5997\ud27d\u54c8\uee93", -19778345), true);
        this.pac(a.c(-753169213, "\u8cb4\uf514\u7fca\ue1b6\u6a64\uecd8\u568c"), a.c(1604969726, "\ue0e7\u9974\u13a9\u8daf\u0601\u84a5\u3ae9\ub317\u2d43\ua7f9\u202e\uda53\u5481\ucd3d"), Items.SPLASH_POTION, a.d("\uae22\ud791\u5d4c\uc34a\u48e4\uca40\u740c\ufdf2\u63a6\ue917\u6ecf\u94ba\u1a61\u83d5\u098b", -2013500767, -864829253), a.d("\u457f\u3cfd\ub635\u287e\ua394\u2521\u9f7a", 1513101542, 1286692312), true);
        this.pac(a.b("\u203a\u5999\ud34a\u4d29\uc6ec\u405d\ufa14\u73e2", 1026367571), a.b("\uff77\u86e4\u0c39\u923f\u1991\u9b35\u2576\uacf6\u32a9\ub869\u3fcb\uc5c3\u4b11\ud2ad", -1369441426), Items.SPLASH_POTION, a.b("\u7eaa\u0719\u8dc4\u13c2\u986c\u1ac8\ua48b\u2d0b\ub354\u3994\ube36\u443e\ucaec\u5350", -1929020781), a.b("\ue6b3\u9f31\u15f9\u8bb2X\u86ed\u3cb6", -1286150414), true);
        this.pac(a.c(1337431089, "\u944a\uede8\u673e\uf942\u729d\uf439\u4e77\uc780\u59de"), a.b("\u471e\u3e8d\ub450\u2a56\ua1f8\u235c\u9d6f\u14ee\u8ab5\b\u87d3\u7dd4\uf37d\u6acc", -1845542137), Items.SPLASH_POTION, a.c(1498586346, "\u98d3\ue160\u6bbd\uf5bb\u7e15\ufcb1\u4282\ucb03\u5558\udfe5\u583e\ua239\u2c90\ub521"), a.c(60727728, "\ua1f1\ud873\u52bb\uccf0\u471a\uc1af\u7bf4"), false);
        this.pac(a.b("\u0e23\u778d\ufd57\u6326\ue8e4", 935136853), a.b("\u3865\u41c8\ucb18\u5515\udeb2\u580f\ue222\u6bae\uf5f2\u7f48", -1191035826), Items.SPLASH_POTION, a.b("\ucf48\ub685\u3c55\ua258\u29ff\uaf42\u156f\u9ce3\u02bf\u8805", -1121793277), a.d("\u2128\u58aa\ud262\u4c29\uc7c3\u4176\ufb2d", 620989408, 1231202953), false);
        this.pac((String)a.d((String)"\u2ccc\u5572\udfba\u41dc\uca0c\u4cbe\uf6e0\u7f11", (int)1042523090, (int)-1455452304), (String)a.c((int)770719711, (String)"\u3bcd\u4251\uc88c\u56f5\udd2a\u5b9b\ue1be\u683d\uf27b\u7ca2\ufb09\u0108"), (Item)Items.FIRE_CHARGE, (String)a.c((int)-2107986114, (String)"\uab0c\ud2b0\u586d\uc614\u4dcb\ucb7a\u715f\uf8dc\u629a\uec43\u6be8\u91e9"), (String)a.d((String)"\u4197\u3815\ub2dd\u2c96\ua77c\u21c9\u9b92", (int)2113693214, (int)-1137694776), (boolean)false).anyItem = true;
        this.pac(a.b("\u62de\u1b70\u91fa\u0fc7\u841d\u02ac\ub8fd\u3115\uaf4c\u25ee\ua22c", -496213315), a.c(-1538852560, "\ufd2d\u84b9\u0e1d\u9067\u1bc9\u9d77\u2729\uaea7\u3497\uba44\u3d95\uc794\u494c\ud0f8\u5aa1"), Items.PRISMARINE_SHARD, a.d("\u5dc5\u2471\uaed5\u30af\ubb01\u3dbf\u87e1\u0e6f\u945f\u1a8c\u9d5d\u675c\ue984\u7030\ufa69", -1373402284, 581096108), a.b("\uc7cf\ube59\u3489\uaaed\u2114\ua79d\u1dd3\u943c\u0a6b", 101894030), false);
        this.pac(a.d("\u254f\u5ce1\ud66b\u4840\uc391\u4533\uff71", 211577353, -1927262423), a.b("\u8476\ufde8\u7741\ue93c\u6291\ue42d\u5e01\ud39f\u49a2\uc311\u44b2\ubecc\u301e\ua9a5", 876118118), Items.POPPED_CHORUS_FRUIT, a.c(-1320519261, "\u7de7\u0454\u8ef7\u1089\u9b5b\u1de0"), a.b("\u00a7\u7931\uf3e1\u6d85\ue67c\u60f5\udabb\u5354\ucd03", -1099104026), false);
        this.pac(a.c(1835282946, "\u326d\u4bc3\uc149\u5f65\ud4b5\u5205\ue84d"), a.d("\uc9e4\ub036\u3a97\ua4eb", 2130804832, -222540383), Items.NETHER_STAR, a.b("\u341c\u4dae\uc70f\u5973", -1851183015), a.b("\uc8ce\ub158\u3b88\ua5ec\u2e15\ua89c\u12d2\u9b3d\u056a", -186070897), false);
        this.pac(a.c(-129012902, "\u6b35\u129b\u9811\u062c\u8df6\u0b47\ub116"), a.c(130495059, "\u364e\u4fda\uc57e\u5b04\ud0aa\u5614\uec4a\u65c4\ufff4\u712d\uf6f4\u0c84\u8257\u1b9b\u91c2"), Items.FIRE_CHARGE, a.c(-41124045, "\u7b0e\u02ba\u881e\u1664\u9dca\u1b74\ua12a\u28a4\ub294\u3c4d\ubb94\u41e4\ucf37\u56fb\udca2"), a.d("\u108a\u691c\ue3cc\u7da8\uf651\u70d8\uca96\u4379\udd2e", -1600960298, 1612011549), false);
        this.pac(a.b("\u6197\u1839\u92b3\u0c9f\u8755\u01e5\ubbae\u324a\uac16\u26aa\ua179", -485727756), a.b("\u6336\u1a9b\u9040\u0e32\u85ed\u0358\ubd11\u30f7\uaeaf\u2412\ua3c3\u59cc\ud765\u4edd\uc483\u4278\ufc27\u739e\ue932", -722049276), Items.SNOWBALL, a.d("\uca06\ub3cb\u3910\ua762\u2cbd\uaa08\u1441\u99a7\u07ff\u8d42\u0a93\uf09c\u7e35\ue78d\u6dd3\ueb28", -529626318, 188302693), a.d("\u30fa\u496c\uc3bc\u5dd8\ud621\u50a8\ueae6\u6309\ufd5e", -1341882509, 1921535944), false);
        this.pac(a.d("\u9ca6\ue508\u6f82\uf1b7\u7a6b\ufcd8\u4683", -1386183253, -1093723806), a.b("\u0fa1\u7603\ufcd7\u62d1\ue97c\u6fce\ud5ea\u5c6a\uc230\u4883\ucb4a\u350f\ubbfa\u2248\ua814\u2eef", -1622471792), Items.JACK_O_LANTERN, a.c(-1839220731, "\ubc54\uc596\u4f42\ud144\u5ae9\udc5b\u667f\uefff\u71a5\ufb16\u78df\u86ba\u086f\u91dd\u1b81\u9d7a"), a.b("\ubcd7\uc541\u4f91\ud1f5\u5a0c\udc85\u66cb\uef24\u7173", 56999062), false);
        this.pac(a.b("\u21b3\u581d\ud297\u4cad\uc767\u41de", -1996348963), a.d("\ue8aa\u9147\u1be0\u85ed\u0e31\u888c\u36b3\ubb5c\u2502\uafc7\u281d\ud21e", -1583764493, 2023704394), Items.EXPERIENCE_BOTTLE, a.b("\u137f\u6ab2\ue015\u7e18\uf5c4\u7379\ucd46\u40a9\udef7\u5432\ud3e8\u29eb", -1543432372), a.c(890695166, "\uedbf\u9429\u1ef9\u809d\u0b64\u8ded\u37a3\ube4c\u201b"), false);
        this.pac(a.d("\u72bf\u0b11\u819b\u1fa6\u9472\u12c5\ua8c0", -2125315670, -1855835270), a.b("\u52a7\u2b78\ua1df\u3fa3\ub473\u32c8\u8c81\u0561\u9b2f\u15fd\u922d\u6822\ue6f9\u7f47\uf566", 1723422344), Items.PINK_SHULKER_BOX, a.b("\ubf64\uc6db\u4c7c\ud200\u59d0\udf6b\u6122\ue8db\u76c5\ufc3d\u7f8d\u85ff\u0b56\u92eb\u18bf\u9e46\u2478\uafcc", 49396534), a.b("\u9909\ue09f\u6a4f\uf42b\u7fd2\uf95b\u4315\ucafa\u54ad", 510368072), false);
        this.pac(a.b("\u481a\u31b4\ubb3e\u2503\uaed7\u2860\u9266", -1887221643), a.b("\ud723\uaefc\u245b\uba27\u31f7\ub74c\u0905\u80e6\u1eab\u9079\u17a9\ueda6\u637d\ufac3\u70e2", -630009076), Items.BLUE_SHULKER_BOX, a.d("\ueaf4\u934b\u19ec\u8790\u0c40\u8afb\u34b2\ubd4b\u2355\ua9e4\u2e7e\ud06c\u5eb8\uc777\u4d28\ucbde\u7199\ufe39\u60ef", 374216430, 1806956617), a.b("\ufbd2\u8244\u0894\u96f0\u1d09\u9b80\u21ce\ua821\u3676", 1195244435), false);
        this.pac(a.c(-1656506957, "\ub5dc\ucc72\u46f8\ud8c5\u5311\ud5a6\u6fa1"), a.b("\u6ef2\u172d\u9d8a\u03f6\u8826\u0e9d\ub0d4\u3936\ua77a\u29a8\uae78\u5477\udaac\u4312\uc933", -690328867), Items.RED_SHULKER_BOX, a.c(112623516, "\u7bc8\u0277\u88d0\u16ac\u9d7c\u1bc7\ua58e\u2c77\ub269\u38d8\ubf0b\u4533\ucf87\u5635\udc18\u5ae5\ue0ad\u6f74\uf5b6\u7782"), a.d("\uc2af\ubb39\u31e9\uaf8d\u2474\ua2fd\u18b3\u915c\u0f0b", 1222557523, 1551072701), false);
        this.pac(a.c(-1026543536, "\u3028\u499c\uc316\u5d28\ud6f0\u505b\uea15\u63eb\ufdbe\u771a"), a.c(-518199713, "\ue245\u9bd9\u1175\u8f7e\u00b1\u821f\u384d\ub1b9\u2fe8\ua52e"), Items.FIREWORK_STAR, a.c(-1529159763, "\udb97\ua22b\u2887\ub68c\u3943\ubbed\u01bf\u884b\u161a\u9cdc"), a.b("\u3728\u4eae\uc479\u5a05\ud1d2\u5776\ued0b\u64c2\ufa80\u702f\uf7f4", -316590223), false);
        this.pac(a.d("\u3605\u4fb1\uc53b\u5b01\ud0cb\u5672", 697423472, 1478549505), a.d("\ua1d2\ud870\u52a9\ucca2\u4709\uc1bc\u7ff5\uf21a\u6c44\ue681\u615b\u9b58", 228698976, 1264914079), Items.FLOWER_BANNER_PATTERN, a.c(-756778076, "\u7fe9\u062b\u8cf2\u12f9\u9952\u1fe7\ua1ae\u2c41\ub21f\u38da\ubf00\u4503"), a.c(-1732939194, "\u721f\u0b99\u814e\u1f32\u94e5\u1241\ua83c\u21f5\ubfb7\u3518\ub2c3"), false);
    }

    private oxf pac(String string, String string2, Item item, String string3, String string4, boolean bl) {
        oxf oxf2 = new oxf(string, string2, item, string3, string4, bl);
        if (string4 != null) {
            oxf2.key.visibleWhen(() -> this.oyc.is(string4));
        }
        this.add(oxf2.key);
        this.oyg.add(oxf2);
        return oxf2;
    }

    private boolean pad(oxf oxf2) {
        return oxf2.server == null || this.oyc.is(oxf2.server);
    }

    public static oxw get() {
        return oyb;
    }

    public static boolean busy() {
        return oyb != null && oxw.oyb.oym != null;
    }

    @Override
    protected void onEnable() {
        this.oym = null;
        this.oyk = null;
        this.oyl = null;
        this.ozo = null;
    }

    @Override
    protected void onDisable() {
        this.oyl = null;
        this.ozo = null;
        this.pap();
        this.pas(this.mc);
        this.ozv = -1;
    }

    @Override
    public boolean keysAtStart() {
        return true;
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (n == this.oyd.get()) {
            this.paf(minecraftClient, n);
            return;
        }
        if (vzz.mods(n) != 0) {
            this.pav(minecraftClient, vzz.baseKey(n));
        }
        boolean bl = this.oym != null || kvz.busy();
        for (oxf oxf2 : this.oyg) {
            if (oxf2.key.get() != n || !this.pad(oxf2)) continue;
            if (bl) {
                if (this.oym == oxf2 || minecraftClient.player == null || oxw.pag(minecraftClient.player, oxf2) <= 0) continue;
                this.ozo = oxf2;
                return;
            }
            if (!this.pae(minecraftClient, oxf2)) continue;
            return;
        }
    }

    private boolean pae(MinecraftClient minecraftClient, oxf oxf2) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity != null && System.currentTimeMillis() < this.ozn && oxw.pag(clientPlayerEntity, oxf2) > 0) {
            this.ozo = oxf2;
            return true;
        }
        if (!oxf2.groundOnly || clientPlayerEntity == null || clientPlayerEntity.isOnGround() || !clientPlayerEntity.isAlive()) {
            return this.pai(minecraftClient, oxf2);
        }
        if (oxw.pag(clientPlayerEntity, oxf2) == 0) {
            izx.alert(wap.t(oxf2.name), wap.s(a.d("\u29f1\u5061\udaa9\u448c\ucf12\u49a4\uf3b9\u7a1c\ue45f\u6ee3\ue975\u134d\u9d9d\u0434\u8e74\u088e\ub2db\u3d11\ua7bf\u21e5", -1729300789, -1187651744), a.b("\u54d5\u2d4c\ua7e8\u3dfb\ub23e\u309d\u8ed6\u0722\u9972\u13c4\u941f\u6e11\ue0b4\u7975\uf353", -265531193)), vhz.POTION, false);
            return false;
        }
        if (this.oyl != oxf2) {
            this.oyl = oxf2;
            izx.alert(wap.t(oxf2.name), wap.s(a.d("\uaae7\ud371\u59b0\uc7d0\u4c10\ucaf3\u70ec\uf910\u6740\uedfb\u6a25\u9053\u1e8d", -560794004, -2000266041), a.b("\ud363\uaaf3\u205f\ube54\u358d\ub729\u0965\u80eb\u1ecc\u9472\u13a3\ue9db\u670b\ufeb4\u74ef\uf21b\u4823", 1375655789)), vhz.CLOCK, false);
        }
        return true;
    }

    private void paf(MinecraftClient minecraftClient, int n) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || minecraftClient.currentScreen != null) {
            return;
        }
        ArrayList<oxf> arrayList = new ArrayList<oxf>();
        for (oxf oxf2 : this.oyg) {
            if (!oxf2.potion() || !this.pad(oxf2) || oxw.pag(clientPlayerEntity, oxf2) <= 0) continue;
            arrayList.add(oxf2);
        }
        if (arrayList.isEmpty()) {
            izx.alert(this.getName(), wap.s(a.d("\ua7c1\ude51\u54cd\ucaef\u412e\uc788\u7ddf\uf43d\u6a75\ue096\u6715\u9d7b\u13b7\u8a1bN\u86be\u3cec\ub36e\u2992\uafc2\u267b\u5c73\ud2d6\u491d", 1112071064, 1731361807), a.b("\ud2b4\uab2d\u2189\ubb9a\u3459\ub2e2\u08b2\u814e\u1f63\u91bd\u1274\ue807\u66de\uff6c\u753e\uf7d6\u498b\uc248\u5ce3\udab7\u534f\u2919\ua7a2\u3c0c\uba01\u30a0\u8966", -95037774)), vhz.POTION, false);
            return;
        }
        minecraftClient.setScreen((Screen)new iwf(new oxc(this, arrayList, minecraftClient), n));
    }

    private static int pag(ClientPlayerEntity clientPlayerEntity, oxf oxf2) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        int n = vvn.count(playerInventory, oxf2::matches);
        for (int i = 0; i < 36; ++i) {
            ItemStack itemStack = playerInventory.getStack(i);
            if (!oxf2.matches(itemStack)) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    private static ItemStack pah(ClientPlayerEntity clientPlayerEntity, oxf oxf2) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        for (int i = 0; i < 36; ++i) {
            if (!oxf2.matches(playerInventory.getStack(i))) continue;
            return playerInventory.getStack(i);
        }
        return vvn.peek(playerInventory, oxf2::matches);
    }

    private boolean pai(MinecraftClient minecraftClient, oxf oxf2) {
        ItemStack itemStack;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null || !clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator() || clientPlayerEntity.currentScreenHandler != clientPlayerEntity.playerScreenHandler) {
            return false;
        }
        int n = oxw.pbc(clientPlayerEntity, oxf2);
        ItemStack itemStack2 = itemStack = n >= 0 ? clientPlayerEntity.getInventory().getStack(n) : vvn.peek(clientPlayerEntity.getInventory(), oxf2::matches);
        if (itemStack.isEmpty()) {
            izx.alert(wap.t(oxf2.name), wap.s(a.d("\u8e32\uf7a2\u7d6a\ue34f\u68d1\uee67\u547a\udddf\u439c\uc920\u4eb6\ub48e\u3a5e\ua3f7\u29b7\uaf4d\u1518\u9ad2|\u8626", -508470079, -1095052631), a.d("\u86b3\uff2a\u758e\uef9d\u6058\ue2fb\u5cb0\ud544\u4b14\uc1a2\u4679\ubc77\u32d2\uab13\u2135", 1077347329, 1663600288)), vhz.POTION, false);
            return false;
        }
        if (clientPlayerEntity.getItemCooldownManager().isCoolingDown(itemStack)) {
            izx.alert(wap.t(oxf2.name), wap.s(a.c(-123049931, "\u687e\u11e3\u9b30\u0542\u8e9d\u0827\ub26c\u3b84"), a.d("\u80eb\uf903\u73a8\uedd6\u6605\ue0c7\u5aea", 899285787, -1242855443)), vhz.CLOCK, false);
            return true;
        }
        if (KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.useKey).equals((Object)InputUtil.UNKNOWN_KEY)) {
            izx.alert(wap.t(oxf2.name), wap.s(a.d("\u855b\ufcd1\u760c\ue872\u63b9\ue55c\u5f4c\ud6b2\u48e8\uc253\u4588\ubfb2\u312c\ua887\u22c9\ua471\u1e6d\u91e8\u0b19\u8d45\u04a8\u7ee2\uf05b", -6341663, 1693892351), a.c(-448376251, "\u5648\u2fd1\ua117\u3b7b\ub0a1\u3617\u8c4e\u05b2\u9b9a\u1159\u9682\u6cfe\ue639\u7bb7\uf1e1\u7716")), vhz.KEYBOARD, false);
            return true;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        this.oym = oxf2;
        this.oyo = n;
        this.oyj = n < 0;
        this.oyp = !this.oyj && n < 9;
        this.oyq = playerInventory.getSelectedSlot();
        this.oyr = clientPlayerEntity.getPitch();
        this.ozp = Math.min(90.0f, oxw.pba(83.0f, 93.0f));
        this.ozs = this.ozq = oxw.pba(-3.0f, 3.0f);
        this.oyt = 0;
        this.oyv = -1;
        this.oyw = false;
        this.ozm = 0;
        if (this.oyp) {
            this.oyn = oxt.SELECT;
        } else if (this.pbb(clientPlayerEntity)) {
            if (!this.pao(minecraftClient)) {
                return true;
            }
            this.oyn = oxt.USE;
            this.ozm = oxw.paq(0, 1);
        } else {
            this.oyn = oxt.PREPARE;
        }
        return true;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        ++this.ozu;
        this.oyu = minecraftClient.player.getInventory().getSelectedSlot();
        this.pas(minecraftClient);
        this.pam(minecraftClient);
        this.paj(minecraftClient);
        this.pak(minecraftClient);
        this.par(minecraftClient);
    }

    private void paj(MinecraftClient minecraftClient) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.oyl != null && (!clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator())) {
            this.oyl = null;
        }
        if (this.oym != null || kvz.busy() || minecraftClient.currentScreen != null) {
            return;
        }
        if (this.oyl != null && clientPlayerEntity.isOnGround()) {
            oxf oxf2 = this.oyl;
            this.oyl = null;
            this.pai(minecraftClient, oxf2);
            return;
        }
        if (this.oyk != null) {
            oxf oxf3 = this.oyk;
            this.oyk = null;
            this.pai(minecraftClient, oxf3);
            return;
        }
        if (this.ozo != null && System.currentTimeMillis() >= this.ozn) {
            oxf oxf4 = this.ozo;
            this.ozo = null;
            this.pae(minecraftClient, oxf4);
        }
    }

    private void pak(MinecraftClient minecraftClient) {
        if (this.oym == null) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!clientPlayerEntity.isAlive() || clientPlayerEntity.currentScreenHandler != clientPlayerEntity.playerScreenHandler || minecraftClient.currentScreen != null) {
            this.pap();
            return;
        }
        switch (this.oyn.ordinal()) {
            case 0: {
                boolean bl;
                PlayerInventory playerInventory = clientPlayerEntity.getInventory();
                boolean bl2 = bl = playerInventory.getSelectedSlot() != this.oyo;
                if (bl) {
                    playerInventory.setSelectedSlot(this.oyo);
                }
                this.oyn = oxt.USE;
                this.ozm = 0;
                if (bl && oxw.paq(0, 1) > 0) {
                    this.pax(clientPlayerEntity);
                    break;
                }
                this.pal(minecraftClient, clientPlayerEntity);
                break;
            }
            case 1: {
                this.paw(minecraftClient, clientPlayerEntity);
                this.pax(clientPlayerEntity);
                break;
            }
            case 2: {
                if (this.ozm > 0) {
                    --this.ozm;
                    if (!this.oyp) {
                        this.paw(minecraftClient, clientPlayerEntity);
                    }
                    this.pax(clientPlayerEntity);
                    return;
                }
                this.pal(minecraftClient, clientPlayerEntity);
                break;
            }
            case 4: {
                if (this.ozm > 0) {
                    --this.ozm;
                    return;
                }
                this.pan(minecraftClient, clientPlayerEntity);
                break;
            }
            default: {
                this.paw(minecraftClient, clientPlayerEntity);
            }
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        this.ozx = minecraftClient.player.getVelocity().y;
        if (this.oym == null) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.oyn == oxt.PREPARE) {
            if (!this.oyj && !this.oym.matches(clientPlayerEntity.getInventory().getStack(this.oyo))) {
                this.pap();
            } else if (this.pbb(clientPlayerEntity)) {
                if (this.pao(minecraftClient)) {
                    this.oyn = oxt.USE;
                    this.ozm = oxw.paq(0, 1);
                }
            } else if (++this.oyt > 10) {
                this.pap();
            }
        } else if (this.oyn == oxt.SWAP_BACK && this.ozm > 0) {
            --this.ozm;
        } else if (this.oyn == oxt.SWAP_BACK) {
            boolean bl;
            boolean bl2 = this.oyj ? clientPlayerEntity.currentScreenHandler == clientPlayerEntity.playerScreenHandler && this.oyh.idle(clientPlayerEntity) : (bl = wdq.canClick(clientPlayerEntity) && this.oyh.idle(clientPlayerEntity));
            if (bl) {
                if (this.oyj) {
                    this.oyi.giveBack(minecraftClient);
                } else {
                    wdq.click(minecraftClient, this.oyo, this.oyq);
                }
                if (this.pat() && clientPlayerEntity.playerScreenHandler.getCursorStack().isEmpty()) {
                    int n = oxw.pau(clientPlayerEntity, this.oyq);
                    if (n >= 9) {
                        wdq.click(minecraftClient, n, this.oyq);
                    } else if (n >= 0) {
                        clientPlayerEntity.getInventory().setSelectedSlot(n);
                    }
                }
                wdq.close(minecraftClient);
                this.oyh.release(minecraftClient);
                this.oyt = 0;
                if (this.oym.self) {
                    this.oyn = oxt.RESTORE;
                } else {
                    this.pap();
                }
            } else if (++this.oyt > 10) {
                this.pap();
            }
        } else if (this.oyn == oxt.RESTORE && this.oyv >= 0) {
            if (this.pbb(clientPlayerEntity)) {
                wdq.swap(minecraftClient, this.oyv, clientPlayerEntity.getInventory().getSelectedSlot());
                this.oyv = -1;
                this.oyh.release(minecraftClient);
                if (this.oyw) {
                    this.pap();
                }
            } else if (++this.oyt > 10) {
                this.oyv = -1;
                this.oyh.release(minecraftClient);
            }
        }
    }

    private void pal(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (!this.oyp) {
            this.paw(minecraftClient, clientPlayerEntity);
        } else if (playerInventory.getSelectedSlot() != this.oyo) {
            playerInventory.setSelectedSlot(this.oyo);
        }
        if (!this.pax(clientPlayerEntity)) {
            return;
        }
        if (this.oym.self) {
            this.ozr = MathHelper.clamp((float)(this.oyr + oxw.pba(-1.6f, 1.6f)), (float)-90.0f, (float)90.0f);
            this.ozs = oxw.pba(-1.2f, 1.2f) - (this.ozq - this.ozs);
        }
        if (!this.oym.matches(clientPlayerEntity.getMainHandStack())) {
            if (this.oyp) {
                this.pap();
            } else {
                this.oyt = 0;
                this.oyn = oxt.SWAP_BACK;
            }
            return;
        }
        if (clientPlayerEntity.isUsingItem()) {
            minecraftClient.interactionManager.stopUsingItem((PlayerEntity)clientPlayerEntity);
        }
        if (minecraftClient.interactionManager.isBreakingBlock()) {
            minecraftClient.interactionManager.cancelBlockBreaking();
            minecraftClient.options.attackKey.setPressed(false);
            this.oys = true;
        }
        for (KeyBinding keyBinding : minecraftClient.options.hotbarKeys) {
            while (keyBinding.wasPressed()) {
            }
        }
        KeyBinding.onKeyPressed((InputUtil.Key)KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.useKey));
        this.oym.usedAt = System.currentTimeMillis();
        if (this.oym.thenMace && this.oyf.get() && clientPlayerEntity.isOnGround()) {
            this.ozv = this.ozu + 12;
        }
        this.oyt = 0;
        this.oyn = this.oyp ? oxt.RESTORE : oxt.SWAP_BACK;
        this.ozm = this.oyp ? oxw.paq(0, 1) : oxw.paq(0, 1);
    }

    private void pam(MinecraftClient minecraftClient) {
        if (this.oys) {
            this.oys = false;
            if (minecraftClient.options != null && minecraftClient.getWindow() != null) {
                minecraftClient.options.attackKey.setPressed(vzz.isPhysicallyDown(minecraftClient, minecraftClient.options.attackKey));
            }
        }
    }

    private void pan(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (this.oyp) {
            if (playerInventory.getSelectedSlot() == this.oyo && this.oyo != this.oyq) {
                playerInventory.setSelectedSlot(this.oyq);
            }
            this.oyp = false;
            if (this.pat() && playerInventory.getSelectedSlot() == this.oyq) {
                int n = oxw.pau(clientPlayerEntity, this.oyq);
                if (n >= 9) {
                    this.oyv = n;
                } else if (n >= 0) {
                    playerInventory.setSelectedSlot(n);
                }
            }
        }
        boolean bl = this.oyw = !this.oym.self || this.pay(clientPlayerEntity, this.ozr, 30.0f, 55.0f);
        if (this.oyv >= 0) {
            this.paw(minecraftClient, clientPlayerEntity);
            return;
        }
        if (this.oyw) {
            this.pap();
        }
    }

    private boolean pao(MinecraftClient minecraftClient) {
        if (!this.oyj) {
            wdq.swap(minecraftClient, this.oyo, this.oyq);
            return true;
        }
        if (!this.oyi.take(minecraftClient, this.oym::matches, this.oyq)) {
            izx.alert(wap.t(this.oym.name), wap.s(a.b("\u27e6\u5e76\ud4ea\u4ac9\uc103\u47b2\ufde3\u745f\uea54\u60fe\ue762\u1d47\u9385\u0a3e\u8063\u06d7\ubcd1\u331d\ua9fa\u2fe4\ua609\udc59", -1683085378), a.b("\u7055\u09cc\u8310\u1d18\u96b8\u100d\uae4e\u23ab\ubdfe\u3730\ub0e0\u4ae3\uc446\u5df9\ud3c6\u512f\ueb6f\u60a9\ufe06\u785e\uf1d4\u8bf7\u054e", -1723173793)), vhz.POTION, false);
            this.pap();
            return false;
        }
        if (!this.oyi.cursorHeld(minecraftClient.player)) {
            wdq.close(minecraftClient);
        }
        return true;
    }

    private void pap() {
        PlayerInventory playerInventory;
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (this.oyi.active() && clientPlayerEntity != null) {
            this.oyi.giveBack(this.mc);
            wdq.close(this.mc);
        }
        this.oyh.release(this.mc);
        this.pam(this.mc);
        if (this.oym != null && this.oyp && clientPlayerEntity != null && (playerInventory = clientPlayerEntity.getInventory()).getSelectedSlot() == this.oyo && this.oyo != this.oyq) {
            playerInventory.setSelectedSlot(this.oyq);
        }
        if (this.oym != null) {
            this.ozn = System.currentTimeMillis() + 120L + ThreadLocalRandom.current().nextLong(101L);
        }
        this.oym = null;
        this.oyn = null;
        this.oyv = -1;
        this.ozm = 0;
        this.ozy = 0.0f;
        this.ozz = 0.0f;
        ett.releaseView();
    }

    private static int paq(int n, int n2) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double d = (threadLocalRandom.nextDouble() + threadLocalRandom.nextDouble()) * 0.5;
        return n + (int)Math.round(d * (double)(n2 - n));
    }

    private void par(MinecraftClient minecraftClient) {
        if (this.ozv < 0) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (this.ozu > this.ozv || !clientPlayerEntity.isOnGround() || clientPlayerEntity.getVelocity().y - this.ozx > 0.5) {
            this.ozv = -1;
            return;
        }
        for (WindChargeEntity windChargeEntity2 : minecraftClient.world.getEntitiesByClass(WindChargeEntity.class, clientPlayerEntity.getBoundingBox().expand(2.0, 3.0, 2.0), windChargeEntity -> windChargeEntity.getOwner() == null || windChargeEntity.getOwner() == clientPlayerEntity)) {
            Vec3d vec3d;
            Vec3d vec3d2 = windChargeEntity2.getEntityPos();
            BlockHitResult blockHitResult = minecraftClient.world.raycast(new RaycastContext(vec3d2, vec3d = vec3d2.add(windChargeEntity2.getVelocity().multiply(2.0)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)windChargeEntity2));
            if (blockHitResult.getType() == HitResult.Type.MISS) continue;
            this.ozv = -1;
            if (minecraftClient.currentScreen == null) {
                minecraftClient.options.jumpKey.setPressed(true);
                this.ozw = true;
            }
            return;
        }
    }

    private void pas(MinecraftClient minecraftClient) {
        if (this.ozw) {
            this.ozw = false;
            if (minecraftClient.options != null && minecraftClient.getWindow() != null) {
                minecraftClient.options.jumpKey.setPressed(vzz.isPhysicallyDown(minecraftClient, minecraftClient.options.jumpKey));
            }
        }
    }

    private boolean pat() {
        return this.oym.thenMace && this.oye.get() && !kmy.takesWindMace();
    }

    private static int pau(ClientPlayerEntity clientPlayerEntity, int n) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (playerInventory.getStack(n).isOf(Items.MACE)) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!playerInventory.getStack(i).isOf(Items.MACE)) continue;
            return i;
        }
        return -1;
    }

    private void pav(MinecraftClient minecraftClient, int n) {
        for (KeyBinding keyBinding : minecraftClient.options.hotbarKeys) {
            InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding);
            if (key.getCategory() != InputUtil.Type.KEYSYM || key.getCode() != n) continue;
            while (keyBinding.wasPressed()) {
            }
        }
        if (kfx.startPhase()) {
            return;
        }
        PlayerInventory playerInventory = minecraftClient.player.getInventory();
        int n2 = playerInventory.getSelectedSlot();
        if (this.oyu < 0 || n2 == this.oyu || n2 >= minecraftClient.options.hotbarKeys.length) {
            return;
        }
        InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.hotbarKeys[n2]);
        if (key.getCategory() == InputUtil.Type.KEYSYM && key.getCode() == n) {
            playerInventory.setSelectedSlot(this.oyu);
        }
    }

    private void paw(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        this.oyh.hold(minecraftClient);
        if (clientPlayerEntity.isUsingItem()) {
            minecraftClient.interactionManager.stopUsingItem((PlayerEntity)clientPlayerEntity);
        }
    }

    private boolean pax(ClientPlayerEntity clientPlayerEntity) {
        return !this.oym.self || this.pay(clientPlayerEntity, this.ozp, 40.0f, 65.0f);
    }

    private boolean pay(ClientPlayerEntity clientPlayerEntity, float f, float f2, float f3) {
        float f4 = f - clientPlayerEntity.getPitch();
        float f5 = oxw.pba(f2, f3);
        boolean bl = Math.abs(f4) <= f5;
        float f6 = bl ? 1.0f : f5 / Math.abs(f4);
        double d = prp.multiplier();
        float f7 = oxw.paz(bl ? f4 : Math.signum(f4) * f5, d);
        float f8 = oxw.paz(this.ozs * f6, d);
        float f9 = clientPlayerEntity.getPitch();
        clientPlayerEntity.setPitch(MathHelper.clamp((float)(clientPlayerEntity.getPitch() + f7), (float)-90.0f, (float)90.0f));
        clientPlayerEntity.setYaw(clientPlayerEntity.getYaw() + f8);
        this.ozs -= f8;
        this.ozy += f8;
        this.ozz += clientPlayerEntity.getPitch() - f9;
        ett.viewOffset(this.ozy, this.ozz);
        return bl;
    }

    private static float paz(float f, double d) {
        return d > 0.0 ? prp.quantize(f, d) : f;
    }

    private static float pba(float f, float f2) {
        return f + ThreadLocalRandom.current().nextFloat() * (f2 - f);
    }

    private boolean pbb(ClientPlayerEntity clientPlayerEntity) {
        return wdq.canClick(clientPlayerEntity) && this.oyh.idle(clientPlayerEntity) && !clientPlayerEntity.isUsingItem();
    }

    private static int pbc(ClientPlayerEntity clientPlayerEntity, oxf oxf2) {
        int n;
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (oxf2.matches(playerInventory.getStack(n = playerInventory.getSelectedSlot()))) {
            return n;
        }
        for (int i = 0; i < 36; ++i) {
            if (!oxf2.matches(playerInventory.getStack(i))) continue;
            return i;
        }
        return -1;
    }

    private static String pbd(String string) {
        return string.toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
    }

    public List<oxi> entries(float f) {
        ArrayList<oxi> arrayList = new ArrayList<oxi>();
        ClientPlayerEntity clientPlayerEntity = this.mc.player;
        if (clientPlayerEntity == null) {
            return arrayList;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        for (oxf oxf2 : this.oyg) {
            if (!oxf2.key.isBound() || !this.pad(oxf2)) continue;
            int n = vvn.count(playerInventory, oxf2::matches);
            ItemStack itemStack = ItemStack.EMPTY;
            for (int i = 0; i < 36; ++i) {
                ItemStack itemStack2 = playerInventory.getStack(i);
                if (!oxf2.matches(itemStack2)) continue;
                n += itemStack2.getCount();
                if (!itemStack.isEmpty()) continue;
                itemStack = itemStack2;
            }
            if (itemStack.isEmpty() && n > 0) {
                itemStack = vvn.peek(playerInventory, oxf2::matches);
            }
            float f2 = itemStack.isEmpty() ? 0.0f : clientPlayerEntity.getItemCooldownManager().getCooldownProgress(itemStack, f);
            arrayList.add(new oxi(oxf2.id, oxf2.name, itemStack.isEmpty() ? new ItemStack((ItemConvertible)oxf2.item) : itemStack, n, oxf2.key.get(), f2, oxf2.usedAt, this.oym == oxf2 || this.oyl == oxf2));
        }
        return arrayList;
    }

    private static /* synthetic */ int bgh(int n, int n2) {
        return (n ^ n2) + -224654549;
    }

    private static /* synthetic */ int bgi(int n, int n2) {
        return oxw.bgh(n, n2) + n;
    }

    private static /* synthetic */ int bgj(int n, int n2) {
        return n * n2 + -2005507098;
    }
}

