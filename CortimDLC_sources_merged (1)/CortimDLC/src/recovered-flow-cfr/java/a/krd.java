/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import a.kfa;
import a.kfe;
import a.kvz;
import a.oxw;
import a.vkl;
import a.vmc;
import a.vyn;
import a.wdq;
import flow.dev.a;
import java.util.Arrays;
import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;

public class krd
extends kfe {
    private static final int kre = 20;
    private static final int krf = 8;
    private static final int krg = 1;
    private static final int krh = 10;
    private static final float kri = 0.5f;
    private static krd krj;
    private final vmc krk = this.add(new vmc(a.d("\ueb64\u92f4\u1859\u8656\u0d8c\u8f2e\u316a\ub898\u26cd\uac02\u2baf\ud1d2\u5f7b\uc6c9", -638367651, 775726888), 6.0, 1.0, 20.0, 0.5).suffix(a.d("\ua0b8\ud911", -845376223, 901526995)));
    private final vkl krl = this.add(new vkl(a.d("\u7d43\u04de\u8e04\u1070\u9bd5\u1d14\ua73e\u2eb6\ub09b\u3a24\ub99b\u47f5\uc95d\u5099\udacb\u5c32\ue674\u69d2", 301850475, 1457169960), true));
    private final vkl krm = this.add(new vkl(a.d("\u0a97\u733a\uf9e4\u67e2\uec42\u6af8\ud0a0\u5d41\uc700\u4dbe\uca17\u306a\ubec7\u2700\uad2d\u2fc9\u91e4\u1e49\u8486\u02a0\u8b5e\uf178", 690779290, 194017850), true));
    private final vkl krn = this.add(new vkl(a.b("\u0141\u78d8\uf61e\u6c7d\ue7a6\u6509\udb48\u52cb\ucce1\u4659\uc1f9\u3fe7\ub525\u2c95\ua6b9", 751502675), false));
    private final vkl kro = this.add(new vkl(a.b("\ub950\uc0fe\u4a2c\ud45e\u5f82\udd26\u636a\uea91\u74bb\ufe7f\u79a5\u83dd\u0d76\u94bb\u1ee0\u9814\u2256", 1464188258), true));
    private final vyn krp = new vyn();
    private final float[] krq = new float[20];
    private ClientPlayerEntity krr;
    private boolean krs;
    private ItemStack krt = ItemStack.field_8037;
    private int kru = -1;
    private boolean krv;
    private int krw;
    private int krx = 1;
    private static /* synthetic */ String kry;
    private static /* synthetic */ String krz;

    public krd() {
        super(a.b("\u45f1\u3c74\ub6a6\u28cc\ua320\u25aa\u9fe2\u1602\u8855", -827374151), a.d("\u42dd\u3b42\ub191\u2ff5\ua421\u22c3\u98d1\u1161\u8f6a\u05c0\u8208\u7868\uf6b7\u6f4b\ue551\u63a7\ud9a6\u5623\ucc8c\u4ad0\uc362\ub97c\u37c6\uac17\u2a66\ua0be\u1902\u9759", 522260502, 1779389084), kfa.COMBAT);
        krj = this;
    }

    public static boolean busy() {
        return krj != null && krd.krj.krv;
    }

    public static boolean needsTotem() {
        return krj != null && krj.isEnabled() && krd.krj.krs;
    }

    @Override
    protected void onEnable() {
        this.krr = null;
        this.krs = false;
        this.ksl();
        this.krv = false;
        this.krw = 0;
        this.krx = 1;
    }

    @Override
    protected void onDisable() {
        this.ksk();
        this.krs = false;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        int n;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity != this.krr) {
            this.ksb(clientPlayerEntity);
        }
        this.ksc(clientPlayerEntity);
        if (this.krx < 1) {
            ++this.krx;
        }
        if (!clientPlayerEntity.method_5805() || clientPlayerEntity.method_7325() || clientPlayerEntity.method_68878()) {
            this.ksk();
            return;
        }
        if (this.krn.get() && krd.ksf(clientPlayerEntity)) {
            this.ksk();
            return;
        }
        Boolean bl = this.kse(clientPlayerEntity);
        if (bl != null) {
            this.krs = bl;
        }
        if ((n = this.ksg(clientPlayerEntity)) < 0 || this.krx < 1 || !krd.ksm(minecraftClient, clientPlayerEntity) || this.ksa()) {
            this.ksk();
            return;
        }
        if (krd.ksn(clientPlayerEntity)) {
            this.ksj(minecraftClient, clientPlayerEntity, n);
            return;
        }
        if (++this.krw > 8) {
            this.ksk();
            this.krx = -10;
            return;
        }
        this.krp.hold(minecraftClient);
        if (clientPlayerEntity.method_6115()) {
            minecraftClient.field_1761.method_2897((PlayerEntity)clientPlayerEntity);
        }
        this.krv = true;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (!this.krv) {
            return;
        }
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        int n = this.ksg(clientPlayerEntity);
        if (n < 0 || !krd.ksm(minecraftClient, clientPlayerEntity)) {
            this.ksk();
            return;
        }
        if (krd.ksn(clientPlayerEntity) && !this.ksa()) {
            this.ksj(minecraftClient, clientPlayerEntity, n);
        }
    }

    private boolean ksa() {
        return !this.krs && (oxw.busy() || kvz.busy());
    }

    private void ksb(ClientPlayerEntity clientPlayerEntity) {
        boolean bl = this.krr != null && this.krr.method_5805();
        this.krr = clientPlayerEntity;
        Arrays.fill(this.krq, krd.ksd(clientPlayerEntity));
        if (!bl) {
            this.krs = false;
            this.ksl();
        }
        this.ksk();
        this.krx = 1;
    }

    private void ksc(ClientPlayerEntity clientPlayerEntity) {
        System.arraycopy(this.krq, 0, this.krq, 1, 19);
        this.krq[0] = krd.ksd(clientPlayerEntity);
    }

    private static float ksd(ClientPlayerEntity clientPlayerEntity) {
        float f = clientPlayerEntity.method_6059(StatusEffects.field_5898) ? clientPlayerEntity.method_6067() : 0.0f;
        return clientPlayerEntity.method_6032() + f;
    }

    private Boolean kse(ClientPlayerEntity clientPlayerEntity) {
        float f;
        if (clientPlayerEntity.method_7357().method_7904(Items.field_8288.method_7854())) {
            return Boolean.FALSE;
        }
        if (this.kro.get() && krd.ksf(clientPlayerEntity) && clientPlayerEntity.method_6030().method_7935((LivingEntity)clientPlayerEntity) > 5) {
            int n = clientPlayerEntity.method_6014();
            if (n < 10) {
                return null;
            }
            float f2 = this.krq[19] - this.krq[0];
            if (n < 30 && f2 / 20.0f * (float)n < this.krq[0]) {
                return null;
            }
        }
        if (this.krq[0] <= (f = (float)this.krk.get())) {
            return Boolean.TRUE;
        }
        return this.krq[0] >= f + 0.5f ? Boolean.FALSE : null;
    }

    private static boolean ksf(ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack = clientPlayerEntity.method_6030();
        return clientPlayerEntity.method_6115() && !itemStack.method_7960() && itemStack.method_58694(DataComponentTypes.field_50075) != null;
    }

    private int ksg(ClientPlayerEntity clientPlayerEntity) {
        return this.krs ? this.ksh(clientPlayerEntity) : this.ksi(clientPlayerEntity);
    }

    private int ksh(ClientPlayerEntity clientPlayerEntity) {
        int n;
        ItemStack itemStack2 = clientPlayerEntity.method_6079();
        boolean bl = this.krm.get();
        boolean bl2 = itemStack2.method_31574(Items.field_8288);
        if (!(!bl2 || bl && itemStack2.method_7958())) {
            return -1;
        }
        int n2 = n = bl ? krd.kso(clientPlayerEntity, itemStack -> itemStack.method_31574(Items.field_8288) && !itemStack.method_7958()) : -1;
        if (n < 0 && !bl2) {
            n = krd.kso(clientPlayerEntity, itemStack -> itemStack.method_31574(Items.field_8288));
        }
        return n;
    }

    private int ksi(ClientPlayerEntity clientPlayerEntity) {
        if (this.krt.method_7960()) {
            return -1;
        }
        ItemStack itemStack2 = clientPlayerEntity.method_6079();
        if (!this.krl.get() || !itemStack2.method_7960() && !itemStack2.method_31574(Items.field_8288)) {
            this.ksl();
            return -1;
        }
        PlayerInventory playerInventory = clientPlayerEntity.method_31548();
        if (this.kru >= 0 && ItemStack.method_31577((ItemStack)playerInventory.method_5438(this.kru), (ItemStack)this.krt)) {
            return this.kru;
        }
        int n = krd.kso(clientPlayerEntity, itemStack -> ItemStack.method_31577((ItemStack)itemStack, (ItemStack)this.krt));
        if (n < 0) {
            n = krd.kso(clientPlayerEntity, itemStack -> itemStack.method_31574(this.krt.method_7909()));
        }
        if (n < 0) {
            this.ksl();
        }
        return n;
    }

    private void ksj(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, int n) {
        ItemStack itemStack = clientPlayerEntity.method_6079();
        if (!this.krs) {
            this.ksl();
        } else if (this.krl.get() && this.krt.method_7960() && !itemStack.method_7960() && !itemStack.method_31574(Items.field_8288)) {
            this.krt = itemStack.method_7972();
            this.kru = n;
        }
        ScreenHandler screenHandler = clientPlayerEntity.field_7512;
        int n2 = wdq.slotId(screenHandler, (Inventory)clientPlayerEntity.method_31548(), n);
        if (n2 >= 0) {
            minecraftClient.field_1761.method_2906(screenHandler.field_7763, n2, 40, SlotActionType.field_7791, (PlayerEntity)clientPlayerEntity);
            if (screenHandler == clientPlayerEntity.field_7498) {
                wdq.close(minecraftClient);
            }
        }
        this.krx = 0;
        this.ksk();
    }

    private void ksk() {
        if (this.krv || this.krp.isHeld()) {
            this.krp.release(this.mc);
        }
        this.krv = false;
        this.krw = 0;
    }

    private void ksl() {
        this.krt = ItemStack.field_8037;
        this.kru = -1;
    }

    private static boolean ksm(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        HandledScreen handledScreen;
        Screen screen;
        ScreenHandler screenHandler = clientPlayerEntity.field_7512;
        if (screenHandler == null || !screenHandler.method_34255().method_7960()) {
            return false;
        }
        return screenHandler == clientPlayerEntity.field_7498 || (screen = minecraftClient.field_1755) instanceof HandledScreen && (handledScreen = (HandledScreen)screen).method_17577() == screenHandler;
    }

    private static boolean ksn(ClientPlayerEntity clientPlayerEntity) {
        return vyn.serverIdle(clientPlayerEntity) && !clientPlayerEntity.method_6115();
    }

    private static int kso(ClientPlayerEntity clientPlayerEntity, Predicate<ItemStack> predicate) {
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

    private static /* synthetic */ int auj(int n, int n2) {
        return n * n2 + -386924236;
    }
}

