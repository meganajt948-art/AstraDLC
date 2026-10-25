/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.block.BarrelBlock
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.block.ShulkerBoxBlock
 *  net.minecraft.block.WallHangingSignBlock
 *  net.minecraft.block.WallSignBlock
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.SignBlockEntity
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.CraftingScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.screen.CraftingScreenHandler
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.state.property.Property
 *  net.minecraft.text.Text
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 */
package a;

import a.our;
import a.pfl;
import a.pzc;
import a.pzw;
import a.qbo;
import a.qdw;
import a.qdz;
import a.qof;
import a.qpw;
import a.qsp;
import a.qsq;
import a.qst;
import a.tel;
import a.vxl;
import a.vzz;
import a.wap;
import a.wdq;
import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.CraftingScreenHandler;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public final class qsw {
    private static final String qsx = a.c(656358294, "\u3bf6\u4256\uc89d\u56f1");
    private static final String qsy = a.c(795336601, "\udffb\ua643\u2c90\ub2ea");
    private static final String qsz = a.d("\u8f5c\uf6e5", 382379335, 924133985);
    private static final double qta = 4.3;
    private static final long qtb = 75000L;
    private static final long qtc = 160000L;
    private static final long qtd = 360000L;
    private static final int qte = 10;
    private static final int qtf = 2;
    private static final int qtg = 24;
    public static volatile Consumer<String> trace;
    public int repairTo = 1500;
    public int xpStock = 576;
    public Set<String> junk = Set.of();
    private final qdz qth = new qdz();
    private final qbo qti = new qbo();
    private final Map<BlockPos, String> qtj = new HashMap<BlockPos, String>();
    private final ArrayDeque<BlockPos> qtk = new ArrayDeque();
    private Consumer<String> qtl = string -> {};
    private qst qtm = qst.DONE;
    private long qtn;
    private long qto;
    private BlockPos qtp;
    private BlockPos qtq;
    private BlockPos qtr;
    private BlockPos qts;
    private int qtt = -1;
    private boolean qtu;
    private boolean qtv;
    private long qtw;
    private String qtx = "";
    private BlockPos qty;
    private int qtz;
    private long qua;
    private int qub;
    private Object quc;
    private boolean qud;
    private int que;
    private int quf;
    private int qug;
    private long quh;
    private int qui;
    private long quj;
    private long quk;
    private boolean qul;
    private boolean qum;
    private long qun;
    private int quo;
    private int qup;
    private static /* synthetic */ long quq;
    private static /* synthetic */ int qur;

    public qsw() {
        this.qth.target(blockState -> false);
    }

    public void notes(Consumer<String> consumer) {
        this.qtl = consumer;
    }

    public qdz walker() {
        return this.qth;
    }

    public boolean repairFailed() {
        if (this.qtv && System.currentTimeMillis() - this.qtw > 600000L) {
            this.qtv = false;
        }
        return this.qtv;
    }

    public String status() {
        return this.qtx;
    }

    public boolean running() {
        return this.qtm != qst.DONE;
    }

    public boolean canPause() {
        return this.qty == null && this.quf == 0 && this.qtm != qst.LAYOUT;
    }

    public void begin(long l) {
        this.qto = l;
        this.qtp = null;
        this.qtq = null;
        this.qtr = null;
        this.qts = null;
        this.qtt = -1;
        this.qtu = false;
        this.qty = null;
        this.qtk.clear();
        this.quf = 0;
        this.qum = false;
        this.qun = 0L;
        this.quo = 0;
        this.qup = 0;
        this.qus(qst.FIND, l);
    }

    public void forget() {
        this.qtj.clear();
        this.qtv = false;
    }

    public void stop(MinecraftClient minecraftClient) {
        this.qth.stop(minecraftClient);
        this.qwi(minecraftClient);
        if (minecraftClient.player != null && minecraftClient.currentScreen instanceof HandledScreen) {
            minecraftClient.player.closeHandledScreen();
        }
        this.qtm = qst.DONE;
        this.qty = null;
    }

    public void startTick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (this.qtm == qst.REPAIR && this.quf == 3 && clientPlayerEntity.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE) && minecraftClient.currentScreen == null && qsw.qwh(minecraftClient)) {
            this.qth.releaseKeys(minecraftClient);
            minecraftClient.options.useKey.setPressed(true);
            this.qul = true;
            return;
        }
        this.qwi(minecraftClient);
        if (this.qty != null && this.qtz == 0) {
            this.qth.startTick(minecraftClient, clientPlayerEntity);
        } else {
            this.qth.releaseKeys(minecraftClient);
        }
    }

    public qsq tick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, qof qof2, tel tel2, qsp qsp2, long l) {
        if (this.qtm == qst.DONE) {
            return qsq.DONE;
        }
        if (l - this.qtn > (this.qtm == qst.REPAIR ? 160000L : 75000L)) {
            this.qtl.accept(a.c(-116579169, "\u20b6\u591c\ud3ce\u4db4\uc667\u44d8\ufe91\u77eb") + qsw.quv(this.qtm) + a.d("\u00b5\u799f\uf751\u6928\ue6ea\u6438\ude69\u57e6\uc9b3\u430c\uc0c8\u3ab5\ub076\u29c3\ua39b\u251d\u9f56\u10fa", 2108886629, -1996747143));
            this.qvn(minecraftClient);
            this.qth.stop(minecraftClient);
            this.qwi(minecraftClient);
            this.qty = null;
            if (this.qtm == qst.REPAIR) {
                this.quf = 0;
                this.qum = false;
                if (clientPlayerEntity.getOffHandStack().isIn(ItemTags.PICKAXES) && !qof2.busy()) {
                    qof2.swaps(this.qug, 40);
                }
            }
            this.qut(l);
            return qsq.RUNNING;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        boolean bl = this.qty == null;
        switch (this.qtm.ordinal()) {
            case 0: {
                this.qtx = a.c(-1064508966, "\ue5e9\u9c43\u1691\u88eb\u0338\u8187\u3bce\ub627\u2809\ua2b2\u2102\udf12\u51c7\uc808\u4252\uc4d4\u7ee2\uf131");
                if (l - this.qto < 1500L) break;
                this.quy((World)minecraftClient.world, clientPlayerEntity);
                if (this.qtp != null && this.qtq != null && this.qtr != null) {
                    this.qut(l);
                    break;
                }
                if (l - this.qtn <= 4000L) break;
                this.qvb((World)minecraftClient.world, clientPlayerEntity);
                this.qus(qst.SCAN, l);
                break;
            }
            case 1: {
                this.qtx = a.d("\u45b7\u3c1d\ub6cf\u28b5\ua366\u21d9\u9b90\u1600\u8822\u0291\u853e\u7f4d\uf194\u6c4b\ue279\u648a\udebb\u5163\ucba7\u4d8f\uc47a", -1827568728, 422887979);
                BlockPos blockPos = this.qtk.peek();
                if (blockPos == null) {
                    if (this.qtp == null && this.qtq == null && this.qtr == null) {
                        this.qtl.accept(a.c(561465331, "\u43ab\u3a32\ub4f4\u2e98\ua542\u238b\u99c1\u105a\u8a1e\u04ce\u831f\u7910\uf7ce\u6e08\ue422\u62d1\udc86\u5736\ucdfe\u4bae\uc252\ub807\u36b0\ua971\u2f06\ua1bd\u187c\u962c\u0cd1\u8a83\u014f\uffe3\u75ae\ue847\u6e9f\ue0c4\u5f63\ud563\u53ce\uca00\u44a5\u3ac3\ub09c\u37a6\ua9ed\u2795\u9e43\u14f7\u92c4\u0967\u876b\u79d5\uf47e\u722d\ue8a0\u668b\udd30\u5bed\ud1e0\u4cc6\uc2e6\ub8bb\u3fc3\ub107\u2fc9\ua60c\u1c56\u9e5e\u149b"));
                        this.stop(minecraftClient);
                        return qsq.FAILED;
                    }
                    this.quu(a.c(-544458098, "\u3eb9\u4700\uc9c6\u53aa\ud870\u5eb9\ue4f3\u6d68\uf736\u7d9d") + this.quw());
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, blockPos, l);
                if (n == 0) break;
                if (n > 0) {
                    String string = qsw.role(minecraftClient.currentScreen.getTitle().getString());
                    if (string != null) {
                        this.qtj.put(blockPos, string);
                        this.quz(string, blockPos, clientPlayerEntity);
                    }
                    this.qvn(minecraftClient);
                }
                this.qty = null;
                this.qtk.poll();
                break;
            }
            case 2: {
                this.qut(l);
                break;
            }
            case 3: {
                this.qtx = a.d("\ub134\uc89e\u424c\udc36\u57e5\ud55a\u6f13\ue283\u7cdf\uf61c\u71c5\u8bbe\u0517\u98c8\u168b\u9071\u2a39\ua5e4\u3f50\ub97d\u34e1\u4aa8\uc003\u5fc5\ud9b3\u5367\uead1\u64fc\ufe77", -942139822, 1026532186);
                if (qof2.busy()) break;
                if (!this.qud) {
                    this.qud = true;
                    qof2.compact();
                    break;
                }
                this.qut(l);
                break;
            }
            case 4: {
                this.qtx = a.c(1880634486, "\u3045\u49ef\uc33d\u5d47\ud694\u542b\uee62\u63f2\ufdd0\u7763\uf0cc\u0abf\u8466\u19b9\u97f4\u1104\uab3f\u24e7");
                if (this.qtr == null) {
                    this.qtu = this.needsRepair(clientPlayerEntity);
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, this.qtr, l);
                if (n < 0) {
                    this.quu(a.d("\u3aff\u4346\ucd80\u57ef\udc44\u5a8d\ue0a4\u695e\uf771\u7dba\ufa67\u0479\u8ecf\u177c\u9d51\u1ba9\ua191\u2e39\ub090\u364a\ubb28\uc178\u4fbf\ud467\u56e1", -1002619469, -1182203032));
                    this.qty = null;
                    this.qtu = this.needsRepair(clientPlayerEntity);
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(minecraftClient, clientPlayerEntity, l) || !this.qvr(minecraftClient, clientPlayerEntity)) break;
                this.qvo(minecraftClient, l);
                break;
            }
            case 5: {
                String string = this.qtx = this.qtu ? a.d("\u9c4f\ue5e5\u6f37\uf14d\u7a9e\uf821\u4268\ucf83\u51a6\udb67\u5cc0\ua6b2\u2861\ub5b3\u3bfe\ubd0e\u0735\u88ed\u163c\u9475\u199a\u67da\ue963\u72b7\uf4cc\u7e1f", -1819807010, -1997903190) : a.b("\u2f2f\u5685\udc57\u422d\uc9fe\u4b41\uf108\u7ce3\ue2c6\u6807\uefa0\u15d2\u9b01\u06d3\u8891\u0e6a\ub420\u3bf5\ua144", -547673315);
                if (this.qts == null || !this.qud && !this.qwa(playerInventory) && !this.qtu) {
                    if (this.qts == null && this.qtu) {
                        this.quu(a.d("\u3a02\u43bb\uc91f\u530c\udcc9\u5a7f\ue059\u69a9\uf7f5\u7d36\ufaef\u0094\u8a53\u1781\u99b1\u1b21\ua16c\u2ec3\ub479\u325f\ubbd1\uc18a\u4b29\ud073\u5299\ud849\u618e\uefd6\u71d8", 1959749790, 1002854076));
                    }
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, this.qts, l);
                if (n < 0) {
                    this.quu(a.d("\ud10b\ua8b2\u2674\ubc1b\u37b0\ub179\u0b50\u82aa\u1c85\u964e\u1193\uef8d\u6548\ufcfe\u76d8\uf028\u4a64\uc5c7\u5f7e", -1074824487, -1275678724));
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0) break;
                Screen screen = minecraftClient.currentScreen;
                if (!(screen instanceof CraftingScreen)) {
                    this.quu(a.d("\u10ce\u6970\ue3df\u79b0\uf67a\u70c3\uce85\u4366\udd3e\u57fa\ud028\u2a5a\ua4ff\u3d44", -494824317, 40796174));
                    this.qvo(minecraftClient, l);
                    break;
                }
                CraftingScreen craftingScreen = (CraftingScreen)screen;
                if (!this.qud) {
                    this.qud = true;
                    if (this.qtu) {
                        ++this.qup;
                    }
                    this.qti.plan(this.qtu, this.qwb(playerInventory));
                }
                if (!this.qti.tick(minecraftClient, clientPlayerEntity, (CraftingScreenHandler)(screen = (CraftingScreenHandler)craftingScreen.getScreenHandler()))) break;
                for (String string2 : this.qti.notes()) {
                    this.quu(string2);
                }
                qbo.putBack(minecraftClient, clientPlayerEntity, (ScreenHandler)screen, -1);
                this.qvo(minecraftClient, l);
                break;
            }
            case 6: {
                this.qtx = a.d("\ud340\uaaea\u2038\ube42\u3591\ub72e\u0d67\u8087\u1edc\u9418\u13c8\uedda\u6713\ufea3\u7484\uf27c", 1680046254, 1190309855);
                if (this.qtr == null || !this.qud && (!this.needsRepair(clientPlayerEntity) || this.qtt == 0 || qpw.count(playerInventory, Items.EXPERIENCE_BOTTLE) >= this.qux(clientPlayerEntity))) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, this.qtr, l);
                if (n < 0) {
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(minecraftClient, clientPlayerEntity, l) || !this.qvt(minecraftClient, clientPlayerEntity, Items.EXPERIENCE_BOTTLE, this.qux(clientPlayerEntity))) break;
                this.qtt = this.qvs(minecraftClient, clientPlayerEntity, Items.EXPERIENCE_BOTTLE);
                this.qvo(minecraftClient, l);
                break;
            }
            case 7: {
                if (this.qun == 0L) {
                    this.qun = l;
                }
                this.qtx = a.b("\ufb3e\u8294\u0846\u963c\u1def\u9f50\u2519\ua88f\u36af\ubc1b\u3bbb\uc5a4\u4f69\ud6da\u5cf1\uda7a\u604c", -2061304050) + (this.quf == 3 ? a.b("\u6e66\u17df\u9d62\u0334\u88f1\u0e47\ub435\u3de2\ua3ab\u2956", 1614048844) : "") + a.c(-1909197298, "\uf62d\u8f0b\u054f") + Math.max(0, qpw.pickaxeDurability(clientPlayerEntity)) + a.d("\u0f2a\u7694\ufc48", 1024559082, 1759480035) + this.repairTo;
                if (!this.qwe(minecraftClient, clientPlayerEntity, qof2, qsp2, l)) break;
                this.qwc(clientPlayerEntity, l);
                break;
            }
            case 8: {
                this.qtx = a.c(2059140709, "\ufa56\u83fc\u092e\u9754\u1c87\u9e38\u2471\ua9e3\u37ce\ubd76\u3add\uc0dc\u4e75\ud3aa\u5de7\udb17\u612c\ueef4");
                if (this.qtr == null || !this.qud && qpw.count(playerInventory, Items.EXPERIENCE_BOTTLE) == 0) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, this.qtr, l);
                if (n < 0) {
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(minecraftClient, clientPlayerEntity, l) || !this.qvu(minecraftClient, clientPlayerEntity, itemStack -> itemStack.isOf(Items.EXPERIENCE_BOTTLE))) break;
                this.qvo(minecraftClient, l);
                break;
            }
            case 9: {
                this.qtx = a.b("\u24ab\u5d01\ud7d3\u49a9\uc27a\u40c5\ufa8c\u771c\ue938\u6388\ue450\u1e25\u908d\u0945\u8314\u059b\ubbba\u3079\uaed8\u2ce8\ua56f\udf4f\u5182\uca2c", -1222369134);
                if (this.qtp == null || !this.qud && !qsw.qvx(playerInventory)) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, this.qtp, l);
                if (n < 0) {
                    this.quu(a.b("\u6530\u1c89\u924f\u0820\u838b\u0542\ubf6b\u3691\ua8be\u2275\ua5a8\u5bb6\ud100\u48b3\uc29e\u4466\ufe5e\u71f6\uef5f\u6985\ue498\u9eb9\u107b\u8bd4\u0dd4\u83ff", -2045157097));
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(minecraftClient, clientPlayerEntity, l) || !this.qvy(minecraftClient, clientPlayerEntity)) break;
                this.qvo(minecraftClient, l);
                break;
            }
            case 10: {
                if (qof2.busy()) break;
                int n = qpw.emptySlot(playerInventory);
                if (!this.qud) {
                    qsw.log(a.d("\u4f0e\u36b6\ubc65\u221f\ua98c\u2f6d\u953c\u1cda\u8290\u086b\u8fa2\u759c\ufb42\u62f3\ue8fb", 975872081, -203034826) + clientPlayerEntity.getOffHandStack() + a.c(-786578764, "\uc293\ubb6b\u31bf\uafe9\u2419\ua2b0\u18a8") + qpw.find(playerInventory, Items.GOLDEN_CARROT) + a.d("\u717b\u088f\u8254\u1c38\u97eb\u1157\uab40", 1593586014, 707608578) + n + a.d("\uc037\ub9c0\u331a\uad6b\u26b7\ua05f", 593345382, -197821577) + qpw.food((PlayerEntity)clientPlayerEntity));
                    this.qud = true;
                    if (this.qtq != null && qpw.food((PlayerEntity)clientPlayerEntity) < 64 && clientPlayerEntity.getOffHandStack().isOf(Items.GOLDEN_CARROT) && qpw.find(playerInventory, Items.GOLDEN_CARROT) < 0 && n >= 0) {
                        qof2.swaps(n, 40);
                        break;
                    }
                }
                this.qut(l);
                break;
            }
            case 11: {
                this.qtx = a.c(-1347924532, "\u49f6\u305c\uba8e\u24f4\uaf27\u2d98\u97d1\u1a31\u846a\u0eae\u897e\u776c\ufdac\u6414\uee42\u68b6\ud285\u5d55\uc7eb\u45d4\uc83f\ub26c\u3ca1\ua70a\u2171\uabac\u1261");
                if (this.qtq == null || !this.qud && qpw.food((PlayerEntity)clientPlayerEntity) >= 64) {
                    this.qut(l);
                    break;
                }
                int n = this.qvh(minecraftClient, clientPlayerEntity, tel2, qsp2, this.qtq, l);
                if (n < 0) {
                    this.quu(a.d("\u255b\u5ce2\ud224\u484b\uc3e0\u4529\uff00\u76fa\ue8d5\u621e\ue5c3\u1bdd\u916b\u08d8\u82f5\u040d\ube35\u319d\uaf34\u29ee\ua485\udedd\u506b\ucbbf\u4dbc\uc71f\u7ed3\uf4ed\u6a06\uec55\u6798\u9933\u1378\u8a85\u0ca8\u82ee", -1582147128, -1625786230));
                    this.qty = null;
                    this.qut(l);
                    break;
                }
                if (n <= 0 || !this.qvp(minecraftClient, clientPlayerEntity, l) || !this.qvv(minecraftClient, clientPlayerEntity)) break;
                this.qvo(minecraftClient, l);
                break;
            }
            case 12: {
                this.qtx = a.b("\u8fb5\uf61f\u7ccd\ue2b7\u6964\uebdb\u5192\udc03\u422c\uc8ec\u4f44\ub534\u3be8\ua25d\u2871\uaef9\u14b4\u9b1b\u05c6\u878f\u0e7d\u7423\ufa97\u614e\ue74e\u6ded\ud42e\u5a73", 19106696);
                if (qof2.busy()) break;
                if (minecraftClient.currentScreen != null) {
                    this.qvn(minecraftClient);
                    break;
                }
                if (!this.qud) {
                    this.qud = true;
                    qof2.layout();
                    break;
                }
                if (playerInventory.getStack(0).isIn(ItemTags.PICKAXES)) {
                    playerInventory.setSelectedSlot(0);
                }
                this.qut(l);
                break;
            }
        }
        if (this.qtm == qst.DONE) {
            this.qth.stop(minecraftClient);
            return qsq.DONE;
        }
        if (this.qty != null && this.qtz == 0) {
            this.qth.endTick(minecraftClient, clientPlayerEntity, tel2);
        } else if (!(this.qtm == qst.REPAIR && this.quf >= 1 || !bl && this.qtz == 1)) {
            qsp2.at(minecraftClient, clientPlayerEntity, null, null);
        }
        return qsq.RUNNING;
    }

    static void log(String string) {
        Consumer<String> consumer = trace;
        if (consumer != null) {
            consumer.accept(string);
        }
    }

    private void qus(qst qst2, long l) {
        qsw.log(a.d("\u6eba\u170c\u9dce\u03aa\u882d", 1857476704, -1063143764) + (Object)((Object)qst2));
        this.qtm = qst2;
        this.qtn = l;
        this.qud = false;
        this.que = 0;
    }

    private void qut(long l) {
        this.qvn(MinecraftClient.getInstance());
        this.qty = null;
        qst[] qstArray = qst.values();
        this.qus(qstArray[Math.min(qstArray.length - 1, this.qtm.ordinal() + 1)], l);
        if (this.qtm == qst.SCAN) {
            this.qus(qst.JUNK, l);
        }
    }

    private void quu(String string) {
        this.qtl.accept(a.c(557178258, "\ud9b4\ua01e\u2acc\ub4b6\u3f65\ubdda\u0793") + string);
    }

    private static String quv(qst qst2) {
        return switch (qst2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0, 1 -> a.d("\ua91b\ud0ab\u5a7e\uc476\u4fda\ucd71\u7343\ufab0\u6491\uee29\u698d\u9385\u1d56\u84eb", -440302409, 88484253);
            case 2 -> a.b("\u4eb7\u3779\ubda8\u23a6\ua80f", 1214532238);
            case 3 -> a.c(-1827633749, "\u81ef\uf85d\u72fc\uec87\u6752");
            case 4, 6 -> a.c(-1474936536, "\u4512\u3ca2\ub605\u287d");
            case 5 -> a.d("\u2c04\u55cf\udf6c\u4169\ucab8", 1224411166, -1189404635);
            case 7 -> a.d("\u0759\u7ee9\uf443\u6a4d\ue19f\u6729\udd70", 1868551029, -183054316);
            case 8 -> a.d("\u0532\u7cf1\uf653\u6852\ue3f7\u6548\udb77\u5698\uc8c6\u4203\uc5d9", -437075694, -1388920728);
            case 9 -> a.b("\u8417\ufdd6\u7774\ue97b\u62d3", 1309048915);
            case 10, 11 -> a.c(1890066298, "\u1b41\u62f2\ue85f\u7654\ufd87\u7b3a\uc117");
            case 12 -> a.b("\u8881\uf140\u7be2\ue5e8\u6e3e\ue884\u52d3\udb2c\u4579", 700026056);
            case 13 -> a.c(-211178327, "\ua89c\ud120\u5b8f\uc582\u4e59\uc8e4");
        };
    }

    private String quw() {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (this.qtp == null) {
            arrayList.add(a.c(-1848336077, "\ua577\udcb6\u5614\uc81b\u43b3"));
        }
        if (this.qtq == null) {
            arrayList.add(a.d("\udcdb\ua568\u2fc5\ub1ce\u3a1d\ubca0\u068d", 1365878537, 1703509993));
        }
        if (this.qtr == null) {
            arrayList.add(a.d("\u2be8\u5258\ud8ff\u4687", -2079893320, 2073327466));
        }
        if (this.qts == null) {
            arrayList.add(a.c(-1361445180, "\ufaf1\u8347\u09e1\u9791\u1c45\u9a86\u20df"));
        }
        return String.join((CharSequence)a.b("\u3ee5\u4758", -342802741), arrayList);
    }

    public boolean needsRepair(ClientPlayerEntity clientPlayerEntity) {
        int n = qpw.pickaxeDurability(clientPlayerEntity);
        return n >= 0 && n < this.repairTo && !this.repairFailed();
    }

    private int qux(ClientPlayerEntity clientPlayerEntity) {
        int n = Math.max(0, qpw.pickaxeDurability(clientPlayerEntity));
        return Math.max(64, Math.min(768, (this.repairTo - n) / 10 + 32));
    }

    private void quy(World world, ClientPlayerEntity clientPlayerEntity) {
        List list;
        Object object;
        Object object2;
        BlockPos blockPos = clientPlayerEntity.getBlockPos();
        double[] dArray = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
        BlockPos[] blockPosArray = new BlockPos[3];
        for (int i = blockPos.getX() - 24 >> 4; i <= blockPos.getX() + 24 >> 4; ++i) {
            for (int j = blockPos.getZ() - 24 >> 4; j <= blockPos.getZ() + 24 >> 4; ++j) {
                object2 = world.getChunk(i, j);
                object = new ArrayList(object2.getBlockEntities().values()).iterator();
                while (object.hasNext()) {
                    String string;
                    String string2;
                    BlockEntity blockEntity = (BlockEntity)object.next();
                    if (!(blockEntity instanceof SignBlockEntity)) continue;
                    SignBlockEntity signBlockEntity = (SignBlockEntity)blockEntity;
                    if (!blockEntity.getPos().isWithinDistance((Vec3i)blockPos, 24.0) || (string2 = qsw.role(string = qsw.qvc(signBlockEntity))) == null) continue;
                    BlockPos blockPos2 = qsw.qvd(world, signBlockEntity.getPos(), world.getBlockState(signBlockEntity.getPos()));
                    qsw.qva(string2, blockPos2, blockPos, blockPosArray, dArray);
                }
            }
        }
        if (world instanceof ClientWorld) {
            ClientWorld clientWorld = (ClientWorld)world;
            list = clientWorld.getEntities();
        } else {
            list = List.of();
        }
        for (Entity entity : list) {
            if (entity == clientPlayerEntity || !entity.getBlockPos().isWithinDistance((Vec3i)blockPos, 24.0) || (object2 = pzw.lines(entity)).isEmpty() || (object = qsw.role(String.join((CharSequence)a.c(838377754, "\ua13b"), (Iterable<? extends CharSequence>)object2))) == null) continue;
            qsw.qva((String)object, qsw.qve(world, entity.getBlockPos(), 2), blockPos, blockPosArray, dArray);
        }
        for (Map.Entry entry : this.qtj.entrySet()) {
            if (!qsw.qvg(world.getBlockState((BlockPos)entry.getKey())) || !((BlockPos)entry.getKey()).isWithinDistance((Vec3i)blockPos, 24.0)) continue;
            qsw.qva((String)entry.getValue(), (BlockPos)entry.getKey(), blockPos, blockPosArray, dArray);
        }
        if (blockPosArray[0] != null) {
            this.qtp = blockPosArray[0];
        }
        if (blockPosArray[1] != null) {
            this.qtq = blockPosArray[1];
        }
        if (blockPosArray[2] != null) {
            this.qtr = blockPosArray[2];
        }
        BlockPos blockPos2 = this.qts = this.qtr != null ? qsw.qvf(world, this.qtr, 6, Blocks.CRAFTING_TABLE) : null;
        if (this.qts == null) {
            this.qts = qsw.qvf(world, blockPos, 12, Blocks.CRAFTING_TABLE);
        }
    }

    public boolean atHome(World world, ClientPlayerEntity clientPlayerEntity, double d) {
        if (world == null) {
            return false;
        }
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        BlockPos blockPos = clientPlayerEntity.getBlockPos();
        int n = (int)Math.ceil(d) + 1;
        for (int i = blockPos.getX() - n >> 4; i <= blockPos.getX() + n >> 4; ++i) {
            for (int j = blockPos.getZ() - n >> 4; j <= blockPos.getZ() + n >> 4; ++j) {
                for (BlockEntity blockEntity : new ArrayList(world.getChunk(i, j).getBlockEntities().values())) {
                    if (!(blockEntity instanceof SignBlockEntity)) continue;
                    SignBlockEntity signBlockEntity = (SignBlockEntity)blockEntity;
                    if (!(Vec3d.ofCenter((Vec3i)blockEntity.getPos()).distanceTo(vec3d) <= d) || qsw.role(qsw.qvc(signBlockEntity)) == null) continue;
                    return true;
                }
            }
        }
        for (Map.Entry<BlockPos, String> entry : this.qtj.entrySet()) {
            if (!(Vec3d.ofCenter((Vec3i)((Vec3i)entry.getKey())).distanceTo(vec3d) <= d) || !qsw.qvg(world.getBlockState(entry.getKey()))) continue;
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private void quz(String var1_1, BlockPos var2_2, ClientPlayerEntity var3_3) {
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

    /*
     * Exception decompiling
     */
    private static void qva(String var0, BlockPos var1_1, BlockPos var2_2, BlockPos[] var3_3, double[] var4_4) {
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

    private void qvb(World world, ClientPlayerEntity clientPlayerEntity) {
        this.qtk.clear();
        BlockPos blockPos = clientPlayerEntity.getBlockPos();
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        for (BlockPos blockPos2 : BlockPos.iterateOutwards((BlockPos)blockPos, (int)10, (int)4, (int)10)) {
            if (!qsw.qvg(world.getBlockState(blockPos2)) || blockPos2.equals((Object)this.qtp) || blockPos2.equals((Object)this.qtq) || blockPos2.equals((Object)this.qtr) || this.qtj.containsKey(blockPos2)) continue;
            arrayList.add(blockPos2.toImmutable());
        }
        for (int i = 0; i < arrayList.size() && this.qtk.size() < 8; ++i) {
            BlockPos blockPos2;
            blockPos2 = (BlockPos)arrayList.get(i);
            boolean bl = false;
            for (BlockPos blockPos3 : this.qtk) {
                if (blockPos3.getManhattanDistance((Vec3i)blockPos2) != 1 || !(world.getBlockState(blockPos3).getBlock() instanceof ChestBlock)) continue;
                bl = true;
            }
            if (bl) continue;
            this.qtk.add(blockPos2);
        }
    }

    static String role(String string) {
        String string2 = pfl.title(string);
        if (string2.contains(a.c(-282781802, "\u13d2\u6a13\ue0b1\u7ebe\uf516"))) {
            return a.b("\ueefe\u975e\u1d95\u83f9", -1128010082);
        }
        if (string2.contains(a.b("\u8745\ufef6\u745b\uea50\u6183\ue73e", -1622113409)) || string2.contains(a.c(-375232706, "\u6308\u1ab8\u906f"))) {
            return a.b("\ude65\ua7dd\u2d0e\ub374", 1221778951);
        }
        if (string2.contains(a.d("\ue327\u9a97\u1030\u8e48", 896230047, 1038058882)) || string2.contains(a.c(671909930, "\u8c10\uf5dd\u7f7a\ue177\u6aab"))) {
            return a.d("\u68e3\u115a", -89705155, -1422238300);
        }
        return null;
    }

    private static String qvc(SignBlockEntity signBlockEntity) {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean bl : new boolean[]{true, false}) {
            for (Text text : signBlockEntity.getText(bl).getMessages(false)) {
                stringBuilder.append(text.getString()).append(' ');
            }
        }
        return stringBuilder.toString();
    }

    private static BlockPos qvd(World world, BlockPos blockPos, BlockState blockState) {
        BlockPos blockPos2;
        Direction direction = null;
        if (blockState.getBlock() instanceof WallSignBlock) {
            direction = (Direction)blockState.get((Property)WallSignBlock.FACING);
        } else if (blockState.getBlock() instanceof WallHangingSignBlock) {
            direction = (Direction)blockState.get((Property)WallHangingSignBlock.FACING);
        }
        if (direction != null && qsw.qvg(world.getBlockState(blockPos2 = blockPos.offset(direction.getOpposite())))) {
            return blockPos2;
        }
        if (qsw.qvg(world.getBlockState(blockPos.down()))) {
            return blockPos.down();
        }
        return qsw.qve(world, blockPos, 2);
    }

    private static BlockPos qve(World world, BlockPos blockPos, int n) {
        for (BlockPos blockPos2 : BlockPos.iterateOutwards((BlockPos)blockPos, (int)n, (int)n, (int)n)) {
            if (!qsw.qvg(world.getBlockState(blockPos2))) continue;
            return blockPos2.toImmutable();
        }
        return null;
    }

    private static BlockPos qvf(World world, BlockPos blockPos, int n, Block block) {
        for (BlockPos blockPos2 : BlockPos.iterateOutwards((BlockPos)blockPos, (int)n, (int)n, (int)n)) {
            if (!world.getBlockState(blockPos2).isOf(block)) continue;
            return blockPos2.toImmutable();
        }
        return null;
    }

    private static boolean qvg(BlockState blockState) {
        Block block = blockState.getBlock();
        return block instanceof ChestBlock || block instanceof BarrelBlock || block instanceof ShulkerBoxBlock;
    }

    private int qvh(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, tel tel2, qsp qsp2, BlockPos blockPos, long l) {
        if (!blockPos.equals((Object)this.qty)) {
            this.qvn(minecraftClient);
            this.qty = blockPos;
            this.qtz = 0;
            this.qua = l;
            this.qub = 0;
            this.qth.stop(minecraftClient);
        }
        switch (this.qtz) {
            case 0: {
                if (qsw.qvj(clientPlayerEntity, blockPos) <= 4.3 && qsw.qvk((World)minecraftClient.world, clientPlayerEntity, blockPos) != null) {
                    this.qth.stop(minecraftClient);
                    this.qtz = 1;
                    this.qua = l;
                    this.quc = new Object();
                    return 0;
                }
                if (this.qth.status() == qdw.IDLE) {
                    this.qth.park(pzc.empty(clientPlayerEntity.getBlockPos()), blockPos, false);
                } else if (this.qth.parked() || this.qth.parkLost() || this.qth.status() == qdw.FAR) {
                    if (qsw.qvj(clientPlayerEntity, blockPos) <= 5.3) {
                        this.qth.stop(minecraftClient);
                        this.qtz = 1;
                        this.qua = l;
                        this.quc = new Object();
                        return 0;
                    }
                    if (l - this.qua > 3000L) {
                        this.qth.stop(minecraftClient);
                        return -1;
                    }
                }
                if (l - this.qua > 25000L) {
                    this.qth.stop(minecraftClient);
                    return -1;
                }
                return 0;
            }
            case 1: {
                BlockHitResult blockHitResult;
                Vec3d vec3d = qsw.qvk((World)minecraftClient.world, clientPlayerEntity, blockPos);
                qsp2.at(minecraftClient, clientPlayerEntity, this.quc, vec3d != null ? vec3d : qsw.qvl(clientPlayerEntity, blockPos));
                minecraftClient.gameRenderer.updateCrosshairTarget(1.0f);
                HitResult hitResult = minecraftClient.crosshairTarget;
                if (hitResult instanceof BlockHitResult && (blockHitResult = (BlockHitResult)hitResult).getType() == HitResult.Type.BLOCK && qsw.qvi((World)minecraftClient.world, blockHitResult.getBlockPos(), blockPos)) {
                    hitResult = minecraftClient.interactionManager.interactBlock(clientPlayerEntity, Hand.MAIN_HAND, blockHitResult);
                    if (hitResult.isAccepted()) {
                        clientPlayerEntity.swingHand(Hand.MAIN_HAND);
                    }
                    this.qtz = 2;
                    this.qua = l;
                } else if (l - this.qua > 3000L) {
                    return ++this.qub > 2 ? -1 : 0;
                }
                return 0;
            }
        }
        if (minecraftClient.currentScreen instanceof HandledScreen) {
            return 1;
        }
        if (l - this.qua > 2500L) {
            if (++this.qub > 2) {
                return -1;
            }
            this.qtz = 1;
            this.qua = l;
            this.quc = new Object();
        }
        return 0;
    }

    private static boolean qvi(World world, BlockPos blockPos, BlockPos blockPos2) {
        if (blockPos.equals((Object)blockPos2)) {
            return true;
        }
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.getBlock() instanceof ChestBlock && blockState.getBlock() == world.getBlockState(blockPos2).getBlock() && blockPos.getManhattanDistance((Vec3i)blockPos2) == 1;
    }

    private static double qvj(ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Box box = new Box(blockPos);
        double d = Math.max(0.0, Math.max(box.minX - vec3d.x, vec3d.x - box.maxX));
        double d2 = Math.max(0.0, Math.max(box.minY - vec3d.y, vec3d.y - box.maxY));
        double d3 = Math.max(0.0, Math.max(box.minZ - vec3d.z, vec3d.z - box.maxZ));
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    private static Vec3d qvk(World world, ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        Vec3d vec3d2 = clientPlayerEntity.getRotationVec(1.0f);
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        arrayList.add(qsw.qvl(clientPlayerEntity, blockPos));
        Vec3d vec3d3 = Vec3d.ofCenter((Vec3i)blockPos);
        for (Object object : Direction.values()) {
            double d = object == Direction.UP ? 0.33 : 0.4;
            arrayList.add(vec3d3.add((double)object.getOffsetX() * d, (double)object.getOffsetY() * d, (double)object.getOffsetZ() * d));
        }
        Vec3d vec3d4 = null;
        double d = Double.MAX_VALUE;
        for (Vec3d vec3d5 : arrayList) {
            double d2;
            BlockHitResult blockHitResult;
            Vec3d vec3d6 = vec3d5.subtract(vec3d);
            double d3 = vec3d6.length();
            if (d3 > 4.7 || d3 < 0.001 || (blockHitResult = world.raycast(new RaycastContext(vec3d, vec3d5.add(vec3d6.multiply(0.05 / d3)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)clientPlayerEntity))).getType() != HitResult.Type.BLOCK || !qsw.qvi(world, blockHitResult.getBlockPos(), blockPos) || !((d2 = Math.acos(Math.max(-1.0, Math.min(1.0, vec3d6.multiply(1.0 / d3).dotProduct(vec3d2))))) < d)) continue;
            d = d2;
            vec3d4 = vec3d5;
        }
        return vec3d4;
    }

    private static Vec3d qvl(ClientPlayerEntity clientPlayerEntity, BlockPos blockPos) {
        Vec3d vec3d = clientPlayerEntity.getEyePos();
        return new Vec3d(qsw.qvm(vec3d.x, (double)blockPos.getX() + 0.3, (double)blockPos.getX() + 0.7), qsw.qvm(vec3d.y, (double)blockPos.getY() + 0.3, (double)blockPos.getY() + 0.65), qsw.qvm(vec3d.z, (double)blockPos.getZ() + 0.3, (double)blockPos.getZ() + 0.7));
    }

    private static double qvm(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    private void qvn(MinecraftClient minecraftClient) {
        if (minecraftClient.player != null && minecraftClient.currentScreen instanceof HandledScreen) {
            minecraftClient.player.closeHandledScreen();
        }
    }

    private void qvo(MinecraftClient minecraftClient, long l) {
        this.qvn(minecraftClient);
        this.qty = null;
        this.qut(l);
    }

    private boolean qvp(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        if (!this.qud) {
            this.qud = true;
            this.qua = l;
            return false;
        }
        return l - this.qua >= 250L && minecraftClient.currentScreen instanceof HandledScreen;
    }

    private ScreenHandler qvq(MinecraftClient minecraftClient) {
        ScreenHandler screenHandler;
        Screen screen = minecraftClient.currentScreen;
        if (screen instanceof HandledScreen) {
            HandledScreen handledScreen = (HandledScreen)screen;
            screenHandler = handledScreen.getScreenHandler();
        } else {
            screenHandler = null;
        }
        return screenHandler;
    }

    private boolean qvr(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        ScreenHandler screenHandler = this.qvq(minecraftClient);
        if (screenHandler == null) {
            return true;
        }
        if (this.qtt < 0) {
            this.qtt = this.qvs(minecraftClient, clientPlayerEntity, Items.EXPERIENCE_BOTTLE);
            this.qtu = this.qtt < this.xpStock;
            this.quu(a.c(1504251319, "\u0999\u7029\ufa8e\u64f6\uef53\u6df2\ud3b3\u5e50\uc46e\u4edd\uc970\u3308\ubda8\u2460\uae3c\u2cd8") + this.qtt + (this.qtu ? a.b("\u1bde\u425b\ue8bc\u72d1\uf90f\u7fb6\uc594\u4c61\ud243\u5ce7", 369236980) + this.xpStock + a.c(-688552617, "\u8572\ufccf\u727d\uec77\u67da\ue11b\u5b3c\ud2ce\u4c95") : ""));
        }
        if (this.qtu || !this.needsRepair(clientPlayerEntity)) {
            return true;
        }
        if (this.qvt(minecraftClient, clientPlayerEntity, Items.EXPERIENCE_BOTTLE, this.qux(clientPlayerEntity))) {
            this.qtt = this.qvs(minecraftClient, clientPlayerEntity, Items.EXPERIENCE_BOTTLE);
            return true;
        }
        return false;
    }

    private int qvs(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Item item) {
        ScreenHandler screenHandler = this.qvq(minecraftClient);
        if (screenHandler == null) {
            return -1;
        }
        int n = 0;
        for (Slot slot : vxl.own(screenHandler, clientPlayerEntity.getInventory())) {
            if (!slot.getStack().isOf(item)) continue;
            n += slot.getStack().getCount();
        }
        return n;
    }

    private boolean qvt(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Item item, int n) {
        ScreenHandler screenHandler = this.qvq(minecraftClient);
        if (screenHandler == null) {
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            if (qbo.count(screenHandler, clientPlayerEntity, item) >= n || ++this.que > 60) {
                return true;
            }
            Slot slot = null;
            for (Slot slot2 : vxl.own(screenHandler, clientPlayerEntity.getInventory())) {
                if (!slot2.getStack().isOf(item)) continue;
                slot = slot2;
                break;
            }
            if (slot == null || !vxl.hasRoom(screenHandler, clientPlayerEntity.getInventory(), slot.getStack())) {
                return true;
            }
            vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
        }
        return false;
    }

    private boolean qvu(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, Predicate<ItemStack> predicate) {
        ScreenHandler screenHandler = this.qvq(minecraftClient);
        if (screenHandler == null) {
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            Slot slot = null;
            for (Slot slot2 : screenHandler.slots) {
                if (slot2.inventory != clientPlayerEntity.getInventory() || !predicate.test(slot2.getStack())) continue;
                slot = slot2;
                break;
            }
            if (slot == null || ++this.que > 80) {
                return true;
            }
            int n = slot.getStack().getCount();
            vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
            if (slot.getStack().getCount() != n) continue;
            this.quu(a.c(-1693978051, "\uf670\u8fc3\u056e\u9b16\u10b6\u967e\u2837\ua5d9\u3b87\ub133\u36e5\ucc97"));
            return true;
        }
        return false;
    }

    private boolean qvv(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        ScreenHandler screenHandler = this.qvq(minecraftClient);
        if (screenHandler == null) {
            return true;
        }
        if (!screenHandler.getCursorStack().isEmpty()) {
            qbo.putBack(minecraftClient, clientPlayerEntity, screenHandler, -1);
            return false;
        }
        int n = qpw.food((PlayerEntity)clientPlayerEntity);
        if (n >= 64 || ++this.que > 30) {
            return true;
        }
        Slot object = null;
        for (Slot object2 : vxl.own(screenHandler, clientPlayerEntity.getInventory())) {
            if (!object2.getStack().isOf(Items.GOLDEN_CARROT)) continue;
            object = object2;
            break;
        }
        if (object == null) {
            this.quu(a.d("\u3f86\u4225\ucc97\u52e4\ud94d\u5ff5\ue5d1\u6c59\uf209\u7cad\uff63\u051a\u8bba\u1669\u982d\u1ed5\ua49f\u2b4b\ub184\u37a9\ube59\uc011\u4abe\ud16d\u576c\uddc7\u6470\uea2d\u70d0", -1757730918, 123018291));
            return true;
        }
        Slot slot = null;
        for (Slot slot2 : screenHandler.slots) {
            if (slot2.inventory != clientPlayerEntity.getInventory() || !slot2.getStack().isOf(Items.GOLDEN_CARROT) || slot2.getStack().getCount() >= slot2.getStack().getMaxCount()) continue;
            slot = slot2;
            break;
        }
        if (slot == null) {
            for (Slot slot2 : screenHandler.slots) {
                if (slot2.inventory != clientPlayerEntity.getInventory() || slot2.hasStack()) continue;
                slot = slot2;
                break;
            }
        }
        if (slot == null) {
            this.quu(a.d("\u2f9e\u5627\udc83\u4690\uc95b\u4fe3\uf5c4\u7c36\ue21b\u6cba\uef7d\u1503\u9ba0\u067e\u8831\u0ec2\ub4f3\u3b58\ua1ef\u27b2\uae4f", 976727690, -232487620));
            return true;
        }
        vxl.click(minecraftClient, screenHandler, object.id, 0, SlotActionType.PICKUP);
        int n2 = 64 - n;
        if (slot.hasStack() || screenHandler.getCursorStack().getCount() <= n2 || n2 > 8) {
            vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.PICKUP);
        } else {
            for (int i = 0; i < n2 && !screenHandler.getCursorStack().isEmpty(); ++i) {
                vxl.click(minecraftClient, screenHandler, slot.id, 1, SlotActionType.PICKUP);
            }
        }
        if (!screenHandler.getCursorStack().isEmpty()) {
            vxl.click(minecraftClient, screenHandler, object.id, 0, SlotActionType.PICKUP);
        }
        return false;
    }

    private static int[] qvw(PlayerInventory playerInventory) {
        for (int i = 0; i < 36; ++i) {
            if (!qsw.dumpable(playerInventory.getStack(i))) continue;
            return new int[]{i, 0};
        }
        return null;
    }

    static boolean dumpable(ItemStack itemStack) {
        return itemStack.isOf(Items.DIAMOND_BLOCK) || itemStack.isOf(Items.GOLD_BLOCK) || itemStack.isOf(Items.ANCIENT_DEBRIS) || itemStack.isOf(Items.NETHERITE_SCRAP);
    }

    private static boolean qvx(PlayerInventory playerInventory) {
        return qsw.qvw(playerInventory) != null;
    }

    private boolean qvy(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        ScreenHandler screenHandler = this.qvq(minecraftClient);
        if (screenHandler == null) {
            return true;
        }
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        if (!screenHandler.getCursorStack().isEmpty()) {
            if (!this.qvz(minecraftClient, clientPlayerEntity, screenHandler)) {
                qbo.putBack(minecraftClient, clientPlayerEntity, screenHandler, -1);
                this.quu(a.c(-368675, "\u5b88\u223b\ua896\u36ee\ubd4e\u3b86\u85cf\u0cb5\u9600\u1cc1\u9b63\u616c\uefc4\u728f\uf847\u7aa9\uc0e7\u4f33\ud585\u53d7"));
                return true;
            }
            return false;
        }
        int[] nArray = qsw.qvw(playerInventory);
        if (nArray == null || ++this.que > 120) {
            return true;
        }
        int n = wdq.slotId(screenHandler, (Inventory)playerInventory, nArray[0]);
        if (n < 0) {
            return true;
        }
        Slot slot = (Slot)screenHandler.slots.get(n);
        int n2 = slot.getStack().getCount();
        if (nArray[1] == 0) {
            vxl.click(minecraftClient, screenHandler, n, 0, SlotActionType.QUICK_MOVE);
            if (slot.getStack().getCount() == n2) {
                this.quu(a.d("\u3d76\u44c5\uce68\u5010\udbb0\u5d78\ue331\u6a4b\uf0fe\u7a3f\ufd9d\u0792\u893a\u1471\u9eb9\u1c57\ua619\u29cd\ub37b\u3529", 2068744132, -170672409));
                return true;
            }
            return false;
        }
        vxl.click(minecraftClient, screenHandler, n, 0, SlotActionType.PICKUP);
        for (int i = 0; i < nArray[1]; ++i) {
            vxl.click(minecraftClient, screenHandler, n, 1, SlotActionType.PICKUP);
        }
        return false;
    }

    private boolean qvz(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, ScreenHandler screenHandler) {
        ItemStack itemStack = screenHandler.getCursorStack();
        Slot slot = null;
        for (Slot slot2 : vxl.own(screenHandler, clientPlayerEntity.getInventory())) {
            if (!slot2.hasStack() || !ItemStack.areItemsAndComponentsEqual((ItemStack)slot2.getStack(), (ItemStack)itemStack) || slot2.getStack().getCount() >= slot2.getStack().getMaxCount()) continue;
            slot = slot2;
            break;
        }
        if (slot == null) {
            for (Slot slot2 : vxl.own(screenHandler, clientPlayerEntity.getInventory())) {
                if (slot2.hasStack()) continue;
                slot = slot2;
                break;
            }
        }
        if (slot == null) {
            return false;
        }
        vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.PICKUP);
        return true;
    }

    private boolean qwa(PlayerInventory playerInventory) {
        return qpw.count(playerInventory, Items.DIAMOND) >= 25 || qpw.count(playerInventory, Items.GOLD_INGOT) >= this.qwb(playerInventory) + 9 || qpw.count(playerInventory, Items.GOLD_NUGGET) >= 9;
    }

    private int qwb(PlayerInventory playerInventory) {
        return this.qtp != null ? 15 : qpw.keepGold(playerInventory);
    }

    private void qwc(ClientPlayerEntity clientPlayerEntity, long l) {
        boolean bl = this.qum;
        this.qum = false;
        if (bl && this.needsRepair(clientPlayerEntity)) {
            int n = Math.max(0, qpw.pickaxeDurability(clientPlayerEntity));
            if (this.quo >= 10 || l - this.qun > 360000L) {
                this.quu(wap.s(a.d("\u2918\u50b5\uda6b\u445f\ucfca\u4976\uf33e\u7acf\ue488\u6e30\ue9f5\u13d7\u9d52\u04f0\u8eac\u0813\ub213\u3dd8\ua76a\u2163\ua898\ud28d\u5c2f\uc7f9\u4195\ucb47\u72ff\ufcab\u6659\ue015\u6bab\u9523", 1913646886, 120440426), a.b("\uf668\u8fa5\u0502\u9b0f\u10d3\u966e\u2c4b\ua5b8\u3fff\ub154\u3683\uccf1\u425c\udb92\u51c2\ud730\u6d06\ue2da\u7c09\ufa54\u77bc\u0d92\u835f\u18f7\u9ef2\u1420\uadec\u23be\ub947\u3b7a", 1349841481)) + n + wap.s(a.d("\u27f3\u5e4a\ud4d4\u4aae\uc178\u47d3\ufd92\u746c\uea7b\u609e\ue74b\u1d21\u93ef\u0a5d\u805d\u06ea\ubcac\u3360\ua981\u2f9d\ua668\udc24\u5280\uc91d", -1201834184, -671592205), a.c(473367621, "\u047f\u7dc6\uf378\u6d7e\ue6ab\u6068\uda41\u53ca\uc9f7\u4723\uc08b\u3af0\ub42b\u2de0\ua7bd\u2520\u9b78\u14ae\u8a0d\u0841\u81b5\ufbe8\u7522\uee84\u68ff\ue63f")));
            } else {
                if (this.qtr != null && this.qtt != 0) {
                    ++this.quo;
                    this.quu(wap.s(a.b("\u4e25\u3788\ubd56\u2362\ua8f7\u2e4b\u9403\u1df2\u83b5\u090d\u8ec8\u74ea\ufa6f\u63cd\ue991\u6f2e\ud52e\u5ae5\uc057\u4652\ucfe4\ub5a0\u3b47", 2042121798), a.d("\uf7a3\u8e6e\u04c9\u9ac4\u1118\u97a5\u2d80\ua473\u3e34\ub09f\u3748\ucd3a\u4397\uda59\u5009\ud6fb\u6ccd\ue311\u7dce\uff82\u7678\u0839", -79549215, -545857685)) + n + wap.s(a.d("\u67f9\u3e7c\u949b\u0aa7\u8172\u07de\ubd9a\u342e\uaa37\u2092\ua75c\u5d2f\ud3b5\u4a50\uc01f\u46e3\ufce9\u737b\ue9c3\u6f9f\ue67e\u9c28", 323932736, -93342321), a.b("\u2971\u70f4\uda13\u4073\ucba0\u4d64\uf734\u7aa6\ue0ec\u6a21\uedea\u13ea\u9925\u009b\u8edf\u0c4f\ub602\u39ad\ua317\u2531\uacbf\ud6e4", -820434617)));
                    this.qty = null;
                    this.qus(qst.XP_TAKE, l);
                    return;
                }
                if (this.qwd(clientPlayerEntity.getInventory())) {
                    ++this.quo;
                    this.quu(wap.s(a.d("\u78b6\u011b\u8bc5\u15f1\u9e64\u18d8\ua290\u2b61\ub526\u3f9e\ub85b\u4279\uccfc\u555e\udf02\u59bd\ue3bd\u6c76\uf6c4\u70c1\uf977\u8333\u0dd4", -1436902171, 1496704048), a.c(-871608073, "\u54de\u2d13\ua7b4\u39b9\ub265\u34d8\u8efd\u070e\u9d49\u13e2\u9435\u6e47\ue0ea\u7924\uf374\u7586\ucfb0\u406c\udeb3\u5cff\ud505\uab44")) + n + wap.s(a.d("\ud6b1\u8f34\u25d3\ubbe1\u3027\ub685\u0cd1\u8532\u1b70\u91c6\u161c\uec2a\u62b0\ufb03\u714d\uf7ab", 1155402103, 168484854), a.c(-1488204453, "\ucd76\u94f3\u3e14\ua47f\u2fd2\ua913\u1334\u9ac6\u049d\u8a4f\u0989\uf384\u7d4b")));
                    this.qtu = true;
                    this.qty = null;
                    this.qus(qst.CRAFT, l);
                    return;
                }
                this.quu(wap.s(a.c(-615924876, "\ubb3f\uc28f\u4813\ud620\u5dfa\udb50\u6103\ue8ea\u76bc\ufc1b\u7b9b\u81a6\u0f78\u96ca\u1c8b\u9a2e\u2020\uaffe\u355a\ub305\u3aed\u40b1\uce15\u55d3\ud3e5\u5938\ue0cf\u6e8f\uf47f\u723d\uf98d\u0757\u8d1d\u14e9\u92a7\u181b\ua795"), a.c(-1844022208, "\u705c\u09ec\u834b\u1d33\u9696\u1437\uaa75\u238b\ubdd1\u3717\ub0c0\u4acc\uc00e\u5da2\ud7f9\u517f\uef52\u649e\ufe28\u7872\uf182\u8bd2\u0178\u9aa5\u18c5\u926b\u2ba6\ua58e\u3f03\ub951\u329d\ucc4f\u460e\udb93")) + n);
            }
        }
        this.qut(l);
    }

    private boolean qwd(PlayerInventory playerInventory) {
        return this.qts != null && this.qup < 2 && !this.qti.xpFailed() && qpw.count(playerInventory, Items.DIAMOND_BLOCK) > 2;
    }

    private boolean qwe(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, qof qof2, qsp qsp2, long l) {
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        switch (this.quf) {
            case 0: {
                if (qof2.busy()) {
                    return false;
                }
                if (minecraftClient.currentScreen != null) {
                    this.qvn(minecraftClient);
                    return false;
                }
                int n = qpw.pickaxe(playerInventory);
                int n2 = qpw.find(playerInventory, Items.EXPERIENCE_BOTTLE);
                if (!this.needsRepair(clientPlayerEntity) || n < 0 || n2 < 0) {
                    if (this.needsRepair(clientPlayerEntity) && n2 < 0 && n >= 0) {
                        if (this.qtt == 0 || this.qtr == null) {
                            this.qum = true;
                        } else {
                            this.quu(a.b("\ua509\udcb0\u5611\uc812\u43cc\uc161\u7f55\uf6db\u6881\ue235\u659c\u9fe3\u1558\u88f3\u02a2\u842b\u3e1e\ub1b6\u2f66\u8903\u20c0\u5e8c\ud037\u4b91\uc98c\u4742\ufe8d\u70a8\uea23\u6c79\ue7c6\u1961\u932a\u0ad7\u8896\u0639\ub9ef\u33ea\ub530\u2cf3", -1968594660));
                        }
                    }
                    return true;
                }
                this.qug = n;
                int n3 = playerInventory.getSelectedSlot();
                if (n2 < 9 && n2 != n) {
                    playerInventory.setSelectedSlot(n2);
                    qof2.swaps(n, 40);
                } else {
                    if (n3 == n) {
                        n3 = n == 8 ? 7 : n + 1;
                        playerInventory.setSelectedSlot(n3);
                    }
                    qof2.swaps(n, 40, n2, n3);
                }
                this.quf = 1;
                this.quh = l;
                break;
            }
            case 1: {
                if (qof2.busy()) {
                    return false;
                }
                if (!clientPlayerEntity.getOffHandStack().isIn(ItemTags.PICKAXES) || !clientPlayerEntity.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE)) {
                    this.quu(a.b("\u52e0\u2b59\ua59f\u3f8f\ub425\u3296\u88c8\u052a\u9f67\u15d3\u9278\u6804\ue6dd\u7b00\uf549\u73ba\uc98d\u4626\udcec\u5ede\ud33b\ua966\u23cb\ubc08\u3a07\ub0aa\u0967\u8735\u1dcf\u9ff0\u1023\ueef1\u64c7\ufd4f", 1220826879));
                    this.quf = 4;
                    return false;
                }
                this.quf = 2;
                this.qui = qpw.durability(clientPlayerEntity.getOffHandStack());
                this.quj = l;
                this.quh = l;
                this.quk = l;
                break;
            }
            case 2: {
                if (minecraftClient.currentScreen instanceof HandledScreen) {
                    this.qvn(minecraftClient);
                    return false;
                }
                BlockPos blockPos = qsw.qwf((World)minecraftClient.world, clientPlayerEntity);
                qsp2.at(minecraftClient, clientPlayerEntity, this, blockPos == null ? clientPlayerEntity.getEntityPos().add(0.0, -1.0, 0.0) : new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.95, (double)blockPos.getZ() + 0.5));
                minecraftClient.gameRenderer.updateCrosshairTarget(1.0f);
                if (!(clientPlayerEntity.getPitch() >= 60.0f && qsw.qwh(minecraftClient)) && l - this.quk <= 3000L) break;
                this.quf = 3;
                this.quj = l;
                InputUtil.Key key = KeyBindingHelper.getBoundKeyOf((KeyBinding)minecraftClient.options.useKey);
                if (key.equals((Object)InputUtil.UNKNOWN_KEY)) break;
                KeyBinding.onKeyPressed((InputUtil.Key)key);
                break;
            }
            case 3: {
                if (minecraftClient.currentScreen instanceof HandledScreen || !qsw.qwh(minecraftClient)) {
                    this.qwi(minecraftClient);
                    this.qvn(minecraftClient);
                    this.quf = 2;
                    this.quk = l;
                    return false;
                }
                BlockPos blockPos = qsw.qwf((World)minecraftClient.world, clientPlayerEntity);
                qsp2.at(minecraftClient, clientPlayerEntity, this, blockPos == null ? clientPlayerEntity.getEntityPos().add(0.0, -1.0, 0.0) : new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.95, (double)blockPos.getZ() + 0.5));
                int n = qpw.durability(clientPlayerEntity.getOffHandStack());
                if (trace != null && (l - this.quh) % 1000L < 50L) {
                    qsw.log(a.b("\u318b\u482d\uc2eb\u5c8b\ud754\u51fe\uebff\u6243\ufc10\u76a9\uf17d\u0b5f", -328584715) + clientPlayerEntity.getMainHandStack() + a.c(-1027822192, "\uadb5\ud44b\u5e91\uc0e0\u4b6c") + clientPlayerEntity.getOffHandStack() + a.b("\u92c5\ueb30\u61f2\uff84\u741c", 1642238688) + n + a.c(1344006376, "\ue8cf\u912e\u1be4\u8588\u0e48\u88f2\u32f4") + (int)clientPlayerEntity.getPitch() + a.d("\u2290\u5b74\ud1a1\u4fc6\uc449", 843570811, 1289223374) + minecraftClient.options.useKey.isPressed() + a.d("\ud9db\ua03f\u2aea\ub481\u3f51\ub9e9\u03e0", -1169222540, -1663382136) + clientPlayerEntity.isUsingItem());
                }
                if (n > this.qui) {
                    this.qui = n;
                    this.quj = l;
                }
                if (!clientPlayerEntity.getOffHandStack().isIn(ItemTags.PICKAXES) || n >= this.repairTo) {
                    this.quf = 4;
                    return false;
                }
                if (!clientPlayerEntity.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE)) {
                    int n4 = qpw.find(playerInventory, Items.EXPERIENCE_BOTTLE);
                    if (n4 < 0) {
                        this.qum = true;
                        this.quf = 4;
                    } else if (!qof2.busy()) {
                        this.qwi(minecraftClient);
                        qof2.swaps(n4, playerInventory.getSelectedSlot());
                        this.quf = 1;
                    }
                    return false;
                }
                our.repairing(minecraftClient);
                if (l - this.quj > 9000L) {
                    this.quu(a.c(-1868781566, "\uac19\ud5aa\u5f01\uc10a\u4ad7\uc876\u7638\uffc1\u658b\ueb5d\u6cf1\u9685\u1857\u819c\u0bcc\u8d33\u3313\ubcca\u226c\ua435\u2db5\u5386\uddbe\u42db\uc485\u4e2d\uf7e1\u79b5\ue345\u6516\uea26\u1473\u9e2a"));
                    this.qtv = true;
                    this.qtw = System.currentTimeMillis();
                    this.quf = 4;
                    break;
                }
                if (l - this.quh <= 150000L && l - this.qun <= 360000L) break;
                this.quu(wap.s(a.d("\ue135\u9898\u1246\u8c72\u07f7\u8151\u3b17\ub2f7\u2ca0\ua60a\u218b\udbae\u5562\uccd3\u4684\uc03e\u7a25\uf5ef\u6f5c\ue942\u60f9\u1aab\u9419\u0fc1\u89f5\u0328\ubadf\u349f\uae6f\u282d\ua39d\u5d47\ud70d\u4ef9\uc8b7\u420b\ufd85", 1889614717, 1004591641), a.d("\u3f81\u4631\ucc9b\u5295\ud947\u5ff1\ue5a8\u6849\uf201\u78b7\uff16\u056a\u8bcf\u1200\u982b\u1ed1\ua4ef\u2b33\ub5e0\u33bd\ube55\uc47b\u4ab6\ud11e\u571b\uddc9\u6405\uea57\u70ae\uf293", -789627957, -1672282005)) + n);
                this.quf = 4;
                break;
            }
            case 4: {
                this.qwi(minecraftClient);
                if (qof2.busy()) {
                    return false;
                }
                if (clientPlayerEntity.getOffHandStack().isIn(ItemTags.PICKAXES)) {
                    qof2.swaps(this.qug, 40);
                }
                this.quf = 5;
                break;
            }
            default: {
                if (qof2.busy()) {
                    return false;
                }
                if (!this.qum) {
                    this.quu(a.b("\ufb53\u82e0\u084b\u9640\u1d9d\u9f3c\u2170\ua880\u36a6\ubc68\u3bbe\uc1c7\u4f18\ud6a4\u58e7\uda02\u6047\ueb88", -1298202757) + Math.max(0, qpw.pickaxeDurability(clientPlayerEntity)));
                }
                this.quf = 0;
                return true;
            }
        }
        return false;
    }

    private static BlockPos qwf(World world, ClientPlayerEntity clientPlayerEntity) {
        BlockPos blockPos = clientPlayerEntity.getBlockPos().down();
        for (BlockPos blockPos2 : BlockPos.iterateOutwards((BlockPos)blockPos, (int)1, (int)0, (int)1)) {
            if (!qsw.qwg(world, blockPos2)) continue;
            return blockPos2.toImmutable();
        }
        return null;
    }

    private static boolean qwg(World world, BlockPos blockPos) {
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSolidBlock((BlockView)world, blockPos) && !blockState.hasBlockEntity() && blockState.createScreenHandlerFactory(world, blockPos) == null;
    }

    private static boolean qwh(MinecraftClient minecraftClient) {
        BlockHitResult blockHitResult;
        HitResult hitResult = minecraftClient.crosshairTarget;
        if (!(hitResult instanceof BlockHitResult) || (blockHitResult = (BlockHitResult)hitResult).getType() != HitResult.Type.BLOCK) {
            return true;
        }
        return qsw.qwg((World)minecraftClient.world, blockHitResult.getBlockPos());
    }

    private void qwi(MinecraftClient minecraftClient) {
        if (this.qul && minecraftClient.options != null && minecraftClient.getWindow() != null) {
            minecraftClient.options.useKey.setPressed(vzz.isPhysicallyDown(minecraftClient, minecraftClient.options.useKey));
        }
        this.qul = false;
    }

    private static /* synthetic */ int bvz(int n, int n2) {
        return n + n2 ^ 0x65BF8133;
    }

    private static /* synthetic */ int bwa(int n, int n2) {
        return qsw.bvz(n, n2) + n;
    }

    private static /* synthetic */ int bwb(int n, int n2) {
        return qsw.bwa(n, n2) + n;
    }
}

