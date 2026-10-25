/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package a;

import a.ivw;
import a.ivx;
import a.iwf;
import a.izx;
import a.kfa;
import a.kfe;
import a.kpx;
import a.kqa;
import a.krd;
import a.kvz;
import a.oxw;
import a.vhz;
import a.vlq;
import a.vlv;
import a.vmu;
import a.vyn;
import a.wap;
import a.wdq;
import flow.dev.a;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class kqh
extends kfe
implements ivw {
    private static final int kqi = 3;
    private static final int kqj = -1;
    private final vlv kqk = this.add(new vlv(a.d("\uf5e0\u8c65\u06ab\u98d8", 99149815, 1287918165), a.c(796706570, "\uc75f\ubecd\u3406\uaa7a\u21ba\ua71c"), kpx.names()));
    private final vlv kql = this.add(new vlv(a.d("\ufb86\u820c", 2122457743, -546121377), a.d("\u874a\ufec0\u7408\uea68\u61b7", 448561641, -129235214), kpx.names()));
    private final vlq kqm = this.add(new vlq(a.c(-378499829, "\u8d50\uf4c5\u7e00\ue060\u6be7\ued1d\u5740\udead")));
    private final vlq kqn = this.add(new vlq(a.b("\uf69f\u8f11\u05cf\u9bbe\u1060\u969d\u2c85\ua57a\u3b39", -213584191)));
    private final vmu[] kqo = new vmu[3];
    private static final int kqp = 10;
    private final vyn kqq = new vyn();
    private final EnumMap<kpx, ItemStack> kqr = new EnumMap(kpx.class);
    private boolean kqs;
    private int kqt = -1;
    private int kqu;
    private static /* synthetic */ String kqv;
    private static /* synthetic */ long kqw;

    public kqh() {
        super(a.d("\uffa1\u8624\u0cf6\u929c\u1977\u9fe2\u25a7\uac47", -1349459499, 910761533), a.d("\u55c5\u2c5d\ua68e\u38f1\ub32f\u3591\u8fc8\u067d\u9871\u12c4\u9501\u6f61\ue1e6\u7816\uf24a\u74b1\uceba\u412a\udbd8\u5d9a\ud473\uae66\u20c8\ubb08\u3d7f\ub7e3\u0e07\u8049\u1ab3\u9ce2\u1758\ue9c5\u63c5\ufa35\u7c28\uf6d8\u494e\uc374\u45a9\udc04", -1380712368, 794646002), kfa.COMBAT);
        for (int i = 0; i < 3; ++i) {
            this.kqo[i] = this.add(new vmu(a.b("\u8f9a\uf614\u7cca\ue2bb\u6965\uef98\u5582\udc6e\u4220\uc899\u4f07", 214273990) + (i + 1), "", 160));
            this.kqo[i].visibleWhen(() -> false);
        }
    }

    @Override
    public void onConfigLoaded(boolean bl) {
        if (!bl && this.getKey() != -1 && !this.kqm.isBound()) {
            this.kqm.set(this.getKey());
            this.setKey(-1);
            this.setEnabled(true);
        }
    }

    @Override
    protected void onEnable() {
        this.kqs = false;
    }

    @Override
    protected void onDisable() {
        this.kqs = false;
        this.kqq.release(this.mc);
    }

    @Override
    public boolean keysAtStart() {
        return true;
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (minecraftClient.field_1724 == null) {
            return;
        }
        if (n == this.kqn.get()) {
            if (minecraftClient.field_1755 == null) {
                minecraftClient.method_1507((Screen)new iwf(this, n));
            }
            return;
        }
        if (n == this.kqm.get()) {
            this.kqt = -1;
            this.kqs = true;
            this.kqu = 0;
            if (kqh.kqx(minecraftClient.field_1724) && !oxw.busy() && !kvz.busy()) {
                this.kqz(minecraftClient);
            }
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (!this.kqs) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (++this.kqu > 10) {
            this.kqy(minecraftClient);
            return;
        }
        if (!wdq.canClick(clientPlayerEntity) || oxw.busy() || kvz.busy()) {
            return;
        }
        if (kqh.kqx(clientPlayerEntity)) {
            this.kqz(minecraftClient);
            return;
        }
        this.kqq.hold(minecraftClient);
        if (clientPlayerEntity.method_6115()) {
            minecraftClient.field_1761.method_2897((PlayerEntity)clientPlayerEntity);
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (this.kqs && kqh.kqx(minecraftClient.field_1724) && !oxw.busy() && !kvz.busy()) {
            this.kqz(minecraftClient);
        }
    }

    @Override
    public String title() {
        return wap.s(a.d("\u7188\u081d\u82d8\u1cb8", 910397369, 256966246), a.c(-2043203714, "\u2b5b\u52f9\ud828\u4656"));
    }

    @Override
    public boolean editable() {
        return true;
    }

    @Override
    public List<ivx> slots() {
        ArrayList<ivx> arrayList = new ArrayList<ivx>(3);
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        for (int i = 0; i < 3; ++i) {
            String string;
            ItemStack itemStack;
            int n;
            kqa kqa2 = kqa.parse(this.kqo[i].get());
            if (kqa2 == null || clientPlayerEntity == null) {
                arrayList.add(new ivx(ItemStack.field_8037, "", "", 0.0f, false));
                continue;
            }
            ItemStack itemStack2 = clientPlayerEntity.method_6079();
            boolean bl = kqa2.matches(itemStack2);
            int n2 = n = bl ? -1 : kqh.krc(clientPlayerEntity, kqa2::matches);
            ItemStack itemStack3 = bl ? itemStack2 : (n >= 0 ? clientPlayerEntity.method_31548().method_5438(n) : ItemStack.field_8037);
            ItemStack itemStack4 = itemStack = itemStack3.method_7960() ? new ItemStack((ItemConvertible)kqa2.item()) : itemStack3;
            String string2 = !itemStack3.method_7960() ? itemStack3.method_7964().getString() : (string = kqa2.name().isEmpty() ? itemStack.method_7964().getString() : kqa2.name());
            String string3 = bl ? wap.s(a.b("\uc0dc\ub960\u33ba\uadc3", -1551187792), a.d("\u2b54\u56f7\ud844\u4636\ucd98\u4b26", 1607784061, 1379465501)) : (itemStack3.method_7960() ? wap.s(a.c(834091486, "\u39b4\u4004\ucad6\u54ac"), a.b("\u2321\u5a98\ud03c", 800401183)) : "");
            arrayList.add(new ivx(itemStack, string, string3, 0.0f, !itemStack3.method_7960() && !bl));
        }
        return arrayList;
    }

    @Override
    public void pick(int n) {
        if (!this.isEnabled() || n < 0 || n >= 3 || kqa.parse(this.kqo[n].get()) == null) {
            return;
        }
        this.kqt = n;
        this.kqs = true;
        this.kqu = 0;
    }

    @Override
    public void assign(int n, ItemStack itemStack) {
        if (n >= 0 && n < 3) {
            this.kqo[n].set(itemStack.method_7960() ? "" : kqa.of(itemStack).text());
        }
    }

    private static boolean kqx(ClientPlayerEntity clientPlayerEntity) {
        return wdq.canClick(clientPlayerEntity) && vyn.serverIdle(clientPlayerEntity) && !clientPlayerEntity.method_6115();
    }

    private void kqy(MinecraftClient minecraftClient) {
        this.kqs = false;
        this.kqq.release(minecraftClient);
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private void kqz(MinecraftClient var1_1) {
        block9: {
            block8: {
                var2_2 = var1_1.field_1724;
                var3_3 = var2_2.method_6079();
                if (this.kqt != -1) break block8;
                var6_4 = kpx.of(this.kqk);
                var7_5 = kpx.of(this.kql);
                var8_7 = var7_5.matches(var3_3) != false || var7_5.isTotem() != false && var3_3.method_31574(Items.field_8288) != false && var6_4.matches(var3_3) == false ? 1 : 0;
                var9_8 = var8_7 != 0 ? var6_4 : var7_5;
                var5_9 = var9_8.isTotem();
                var4_10 = var5_9 != false || kqh.kra(var3_3) == false ? this.krb(var2_2, (kpx)var9_8, var3_3) : -1;
                break block9;
            }
            var6_4 = kqa.parse(this.kqo[this.kqt].get());
            if (var6_4 == null || var6_4.matches(var3_3)) {
                this.kqy(var1_1);
                return;
            }
            v0 = var5_9 = var6_4.item() == Items.field_8288;
            if (var5_9) ** GOTO lbl22
            if (!kqh.kra(var3_3)) {
lbl22:
                // 2 sources

                v1 = kqh.krc(var2_2, (Predicate<ItemStack>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, matches(net.minecraft.item.ItemStack ), (Lnet/minecraft/item/ItemStack;)Z)((kqa)var6_4));
            } else {
                v1 = var4_10 = -1;
            }
            if (var4_10 < 0 && (var5_9 || !kqh.kra(var3_3))) {
                izx.alert(this.getName(), wap.s(a.c(-1263940819, "\ucb77\ub2e7\u382f\ua60a\u2d94\uab22\u113f\u989a\u06d9\u8c65\u0bf3\uf1cb\u7f1b\ue6b2\u6cf2\uea08\u505d\udf97\u4539\uc363"), a.c(-99105583, "\uc0c3\ub95a\u33fe\ua9ed\u2628\ua48b\u1ac0\u9334\u0d64\u87d2\t\ufa07\u74a2\ued63\u6745")), vhz.INFO, false);
            }
        }
        if (!var5_9 && kqh.kra(var3_3)) {
            izx.alert(this.getName(), wap.s(a.c(982624727, "\ua98f\ud00a\u5ad8\uc4b2\u4f5e\uc9d4\u739c\ufa7c\u642b\ueed7\u694f\u9330\u1de7\u8443\u0e13\u88b1\u32aa\ubd67\u27d9\ua1cd\u286e\u5224\udc8c\u474c\uc13b"), a.b("\u2673\u5ff6\ud524\u4b4e\uc0a2\u4628\ufc60\u7580\uebd7\u612b\ue2ec\u189c\u963e\u0ff9\u85a4\u032f\ubd02\u36b1\uac7e\u2a53\ua3d3\ud98b", -1350818268)), vhz.INFO, false);
        } else if (var4_10 >= 0) {
            for (Object var9_8 : kpx.values()) {
                if (!var9_8.matches(var3_3)) continue;
                this.kqr.put((kpx)var9_8, var3_3.method_7972());
            }
            wdq.swap(var1_1, var4_10, 40);
        }
        this.kqy(var1_1);
    }

    private static boolean kra(ItemStack itemStack) {
        return krd.needsTotem() && itemStack.method_31574(Items.field_8288);
    }

    private int krb(ClientPlayerEntity clientPlayerEntity, kpx kpx2, ItemStack itemStack3) {
        int n;
        Predicate<ItemStack> predicate = itemStack2 -> !ItemStack.method_31577((ItemStack)itemStack2, (ItemStack)itemStack3);
        ItemStack itemStack4 = this.kqr.getOrDefault((Object)kpx2, ItemStack.field_8037);
        if (!itemStack4.method_7960() && predicate.test(itemStack4) && (n = kqh.krc(clientPlayerEntity, itemStack2 -> ItemStack.method_31577((ItemStack)itemStack2, (ItemStack)itemStack4))) >= 0) {
            return n;
        }
        n = kqh.krc(clientPlayerEntity, itemStack -> kpx2.matches((ItemStack)itemStack) && predicate.test((ItemStack)itemStack));
        if (n < 0 && kpx2.isTotem()) {
            n = kqh.krc(clientPlayerEntity, itemStack -> itemStack.method_31574(Items.field_8288) && predicate.test((ItemStack)itemStack));
        }
        return n;
    }

    private static int krc(ClientPlayerEntity clientPlayerEntity, Predicate<ItemStack> predicate) {
        int n;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        int n2 = playerInventory.method_67532();
        for (n = 9; n < 36; ++n) {
            if (!predicate.test(playerInventory.method_5438(n))) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (n == n2 || !predicate.test(playerInventory.method_5438(n))) continue;
            return n;
        }
        return predicate.test(playerInventory.method_5438(n2)) ? n2 : -1;
    }

    private static /* synthetic */ int aug(int n, int n2) {
        return n * n2 ^ 0x4B56BF5B;
    }
}

