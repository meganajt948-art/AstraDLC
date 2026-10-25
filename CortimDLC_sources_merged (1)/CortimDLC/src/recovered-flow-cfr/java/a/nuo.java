/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.BlockView
 */
package a;

import a.kfa;
import a.kfe;
import a.krd;
import a.kvz;
import a.lqq;
import a.oxw;
import a.vkl;
import a.vmc;
import a.vyn;
import a.vzz;
import a.wdq;
import flow.dev.a;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;

public class nuo
extends kfe {
    private static final int nup = -1;
    private static final int nuq = -2;
    private static final int nur = -3;
    private static final int nus = 20;
    private static final int nut = 20;
    private static final int nuu = 10;
    private static final float nuv = 0.01f;
    private static final float nuw = 0.3f;
    private final vkl nux = this.add(new vkl(a.c(-590709628, "\u7890\u010e\u8fca\u15a3\u9e71\u18cf\ua29b\u2b62\ub542\u3f81\ub822\u425c"), true));
    private final vkl nuy = this.add(new vkl(a.c(-1150386401, "\u7b07\u029a\u8840\u1634\u9d91\u1b50\ua17a\u28f2\ub6df\u3c60"), true));
    private final vmc nuz = this.add(new vmc(a.c(1100149864, "\uf06e\u89f8\u032f\u9d5f\u16fd\u903a\u2a65\ua39e\u39d1\ub772\u30ad\ucad5\u4407\uddc4\u57e7\ud164\u6b59"), 4.0, 0.0, 20.0, 1.0).suffix(a.c(-844885942, "\u103b\u6997\ue34e\u7d37\uf6f8")));
    private final vkl nva = this.add(new vkl(a.c(-957963011, "\ua0fc\ud969\u53cf\ucdcb\u466e\uc0d4\u7eeb\uf305\u6d25\ue7ea\u6040\u9a4b\u149f\u8d51\u0701\u81fe"), true));
    private static nuo nvb;
    private final vyn nvc = new vyn();
    private ClientPlayerEntity nvd;
    private int nve = -1;
    private int nvf = -1;
    private int nvg = -1;
    private ItemStack nvh = ItemStack.field_8037;
    private boolean nvi;
    private int nvj;
    private int nvk = -1;
    private boolean nvl;
    private boolean nvm;
    private int nvn;
    private int nvo;
    private static /* synthetic */ String nvp;
    private static /* synthetic */ int nvq;

    public nuo() {
        super(a.c(1240864642, "\u17cb\u6e4e\ue49c\u7af6\uf11a\u7790\ucdc3\u4431"), a.d("\u31e8\u486c\uc2b5\u5cca\ud70b\u51e9\uebee\u6203\ufc51\u76a5\uf134\u0b42\u8583\u1c35\u9632\u1097\uaac3\u2512\ubfa2\u39bf\ub01f\uca51\u44e3\udf37\u5941\ud3d5\u6a3f\ue478\u7e95\uf891\u736f\u8dba\u07f2\u9e08", 1944634096, -1230441618), kfa.PLAYER);
        this.nuz.activeWhen(this.nuy::get);
        nvb = this;
    }

    public static boolean busy() {
        return nvb != null && nvb.isEnabled() && nuo.nvb.nve >= 0;
    }

    @Override
    protected void onEnable() {
        this.nvd = null;
        this.nwd();
        this.nvo = 0;
    }

    @Override
    protected void onDisable() {
        this.nwc();
        ClientPlayerEntity clientPlayerEntity = this.mc.field_1724;
        if (clientPlayerEntity != null && clientPlayerEntity == this.nvd && this.nvg >= 0 && wdq.canClick(clientPlayerEntity) && this.nwe(clientPlayerEntity)) {
            this.nvx(clientPlayerEntity.method_31548());
        }
        this.nwd();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        BlockState blockState;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity != this.nvd) {
            this.nvd = clientPlayerEntity;
            this.nwd();
        }
        if (this.nvo > 0) {
            --this.nvo;
        }
        if (lqq.busy()) {
            this.nwc();
            return;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (this.nvf >= 0 && playerInventory.method_67532() != this.nvf) {
            this.nvi = true;
        }
        int n = this.nvj = (blockState = this.nvs(clientPlayerEntity)) != null ? 0 : Math.min(this.nvj + 1, 1000);
        if (!clientPlayerEntity.method_5805() || clientPlayerEntity.method_7325()) {
            this.nwd();
            return;
        }
        int n2 = this.nvr(clientPlayerEntity, blockState);
        if (n2 == -1) {
            this.nwc();
            return;
        }
        if (n2 == -3) {
            this.nwd();
            return;
        }
        if (n2 < 9 && n2 >= 0) {
            this.nwc();
            this.nvy(playerInventory, n2);
            return;
        }
        if (!(n2 != -2 || this.nvg >= 0 && this.nvz(playerInventory))) {
            this.nvx(playerInventory);
            return;
        }
        if (this.nvo > 0 || !wdq.canClick(clientPlayerEntity) || oxw.busy() || kvz.busy() || krd.busy()) {
            this.nwc();
            return;
        }
        if (this.nwe(clientPlayerEntity)) {
            this.nwc();
            this.nvw(clientPlayerEntity, n2);
            return;
        }
        if (nuo.nwf(clientPlayerEntity)) {
            this.nwc();
            return;
        }
        if (++this.nvn > 20) {
            this.nwc();
            this.nvo = 20;
            return;
        }
        this.nwa(clientPlayerEntity);
        this.nvk = n2;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (this.nvk == -1) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (wdq.canClick(clientPlayerEntity) && this.nwe(clientPlayerEntity) && !oxw.busy() && !kvz.busy()) {
            int n = this.nvk;
            this.nvw(clientPlayerEntity, n);
            this.nwc();
        } else {
            this.nwb();
        }
    }

    private int nvr(ClientPlayerEntity clientPlayerEntity, BlockState blockState) {
        boolean bl;
        if (blockState != null) {
            if (this.nvi) {
                return -1;
            }
            boolean bl2 = this.nux.get() && (this.nwe(clientPlayerEntity) || !nuo.nwf(clientPlayerEntity));
            return this.nvt(clientPlayerEntity, blockState, bl2);
        }
        if (this.nve < 0 || clientPlayerEntity.method_6115()) {
            return -1;
        }
        HitResult hitResult = this.mc.field_1765;
        boolean bl3 = bl = hitResult != null && hitResult.method_17783() == HitResult.Type.field_1331;
        if (!bl && this.nvj <= this.nuz.getInt()) {
            return -1;
        }
        return this.nuy.get() ? -2 : -3;
    }

    private BlockState nvs(ClientPlayerEntity clientPlayerEntity) {
        BlockHitResult blockHitResult;
        if (this.mc.field_1755 != null || this.mc.field_1687 == null || clientPlayerEntity.method_68878() || clientPlayerEntity.method_7325() || clientPlayerEntity.method_6115() || !this.mc.field_1690.field_1886.method_1434()) {
            return null;
        }
        this.mc.field_1773.method_3190(1.0f);
        HitResult hitResult = this.mc.field_1765;
        if (!(hitResult instanceof BlockHitResult) || (blockHitResult = (BlockHitResult)hitResult).method_17783() != HitResult.Type.field_1332) {
            return null;
        }
        hitResult = blockHitResult.method_17777();
        BlockState blockState = this.mc.field_1687.method_8320((BlockPos)hitResult);
        if (blockState.method_26215() || blockState.method_26214((BlockView)this.mc.field_1687, (BlockPos)hitResult) <= 0.0f) {
            return null;
        }
        return blockState;
    }

    private int nvt(ClientPlayerEntity clientPlayerEntity, BlockState blockState, boolean bl) {
        float f;
        int n;
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        int n2 = playerInventory.method_67532();
        float f2 = this.nvu(playerInventory.method_5438(n2), blockState);
        int n3 = -1;
        for (n = 0; n < 9; ++n) {
            if (n == n2 || !((f = this.nvu(playerInventory.method_5438(n), blockState)) > f2 + 0.01f)) continue;
            f2 = f;
            n3 = n;
        }
        if (bl) {
            for (n = 9; n < 36; ++n) {
                f = this.nvu(playerInventory.method_5438(n), blockState);
                if (!(f > f2 + 0.01f) || !(f > 1.0f)) continue;
                f2 = f;
                n3 = n;
            }
        }
        return n3;
    }

    private float nvu(ItemStack itemStack, BlockState blockState) {
        int n;
        if (this.nva.get() && itemStack.method_7963() && itemStack.method_7936() - itemStack.method_7919() <= 10) {
            return -1.0f;
        }
        float f = itemStack.method_7924(blockState);
        if (f > 1.0f && (n = nuo.nvv(itemStack)) > 0) {
            f += (float)(n * n + 1);
        }
        return !blockState.method_29291() || itemStack.method_7951(blockState) ? f : f * 0.3f;
    }

    private static int nvv(ItemStack itemStack) {
        for (Object2IntMap.Entry entry : itemStack.method_58657().method_57539()) {
            if (!((RegistryEntry)entry.getKey()).method_40225(Enchantments.field_9131)) continue;
            return entry.getIntValue();
        }
        return 0;
    }

    private void nvw(ClientPlayerEntity clientPlayerEntity, int n) {
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (n == -2) {
            this.nvx(playerInventory);
            return;
        }
        if (this.nve < 0) {
            this.nve = playerInventory.method_67532();
        }
        if (this.nvg >= 0 && this.nvz(playerInventory)) {
            wdq.click(this.mc, this.nvg, this.nve);
            if (n == this.nvg) {
                this.nvg = -1;
                this.nvh = ItemStack.field_8037;
                wdq.close(this.mc);
                this.nvy(playerInventory, this.nve);
                return;
            }
        }
        this.nvh = playerInventory.method_5438(this.nve).method_7972();
        wdq.click(this.mc, n, this.nve);
        this.nvg = n;
        wdq.close(this.mc);
        this.nvy(playerInventory, this.nve);
    }

    private void nvx(PlayerInventory playerInventory) {
        if (this.nvg >= 0 && this.nvz(playerInventory)) {
            wdq.swap(this.mc, this.nvg, this.nve);
        }
        if (!this.nvi && this.nve >= 0 && playerInventory.method_67532() == this.nvf && this.nvf != this.nve) {
            playerInventory.method_61496(this.nve);
        }
        this.nwd();
    }

    private void nvy(PlayerInventory playerInventory, int n) {
        if (this.nve < 0) {
            this.nve = playerInventory.method_67532();
        }
        if (playerInventory.method_67532() != n) {
            playerInventory.method_61496(n);
        }
        this.nvf = n;
    }

    private boolean nvz(PlayerInventory playerInventory) {
        return ItemStack.method_31577((ItemStack)playerInventory.method_5438(this.nvg), (ItemStack)this.nvh);
    }

    private void nwa(ClientPlayerEntity clientPlayerEntity) {
        this.nvc.hold(this.mc);
        KeyBinding keyBinding = this.mc.field_1690.field_1886;
        while (keyBinding.method_1436()) {
            this.nvm = true;
        }
        keyBinding.method_23481(false);
        this.nvl = true;
        if (clientPlayerEntity.method_6115()) {
            this.mc.field_1761.method_2897((PlayerEntity)clientPlayerEntity);
        }
    }

    private void nwb() {
        if (this.nvl) {
            this.nvl = false;
            if (this.mc.field_1690 != null && this.mc.method_22683() != null) {
                InputUtil.Key key;
                KeyBinding keyBinding = this.mc.field_1690.field_1886;
                keyBinding.method_23481(vzz.isPhysicallyDown(this.mc, keyBinding));
                if (this.nvm && !(key = KeyBindingHelper.getBoundKeyOf((KeyBinding)keyBinding)).equals((Object)InputUtil.field_16237)) {
                    KeyBinding.method_1420((InputUtil.Key)key);
                }
            }
        }
        this.nvm = false;
    }

    private void nwc() {
        if (this.nvc.isHeld()) {
            this.nvc.release(this.mc);
        }
        this.nwb();
        this.nvk = -1;
        this.nvn = 0;
    }

    private void nwd() {
        this.nwc();
        this.nve = -1;
        this.nvf = -1;
        this.nvg = -1;
        this.nvh = ItemStack.field_8037;
        this.nvi = false;
    }

    private boolean nwe(ClientPlayerEntity clientPlayerEntity) {
        return vyn.serverIdle(clientPlayerEntity) && !clientPlayerEntity.method_6115() && (this.mc.field_1761 == null || !this.mc.field_1761.method_2923());
    }

    private static boolean nwf(ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        boolean bl2 = bl = clientPlayerEntity.method_5715() || vyn.lastSent(clientPlayerEntity).comp_3164();
        if (!bl || !clientPlayerEntity.method_24828()) {
            return false;
        }
        Box box = clientPlayerEntity.method_5829();
        Vec3d vec3d = clientPlayerEntity.method_18798();
        double d = clientPlayerEntity.method_49476();
        Box box2 = new Box(box.field_1323 + vec3d.field_1352 + 1.0E-7, box.field_1322 - d - 1.0E-7, box.field_1321 + vec3d.field_1350 + 1.0E-7, box.field_1320 + vec3d.field_1352 - 1.0E-7, box.field_1322, box.field_1324 + vec3d.field_1350 - 1.0E-7);
        return clientPlayerEntity.method_73183().method_8587((Entity)clientPlayerEntity, box2);
    }

    private static /* synthetic */ int bdf(int n, int n2) {
        return n * n2 ^ 0xBCCD37E6;
    }

    private static /* synthetic */ int bdg(int n, int n2) {
        return n + n2 ^ 0x2EDEAA47;
    }

    private static /* synthetic */ int bdh(int n, int n2) {
        return nuo.bdg(n, n2) + n;
    }
}

