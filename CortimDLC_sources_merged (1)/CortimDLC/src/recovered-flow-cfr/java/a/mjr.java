/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 */
package a;

import a.kfa;
import a.kfe;
import a.kvz;
import a.oxw;
import a.vkl;
import a.vmc;
import a.vuc;
import a.vui;
import a.vyn;
import a.wdq;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

public class mjr
extends kfe {
    private static final EquipmentSlot[] mjs = new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.HEAD, EquipmentSlot.FEET};
    private static final int mjt = 6;
    private final vmc mju = this.add(new vmc(a.b("\u3b97\u4202\uc8c7\u56a7\udd20\u5bd3\ue187\u687f\uf623\u7c8a\ufb0e\u013b\u8ffd\u164b\u9c0b\u1af9\ua0bd\u2f69\ub5df\u3393\uba69", -1943454767), 2.0, 1.0, 100.0, 1.0));
    private final vkl mjv = this.add(new vkl(a.c(318390738, "\u4198\u381d\ub2d3\u2ca0\ua73a\u21c9\u9b8d\u1267\u8c32\u068b\u8151\u7b36"), true));
    private final vkl mjw = this.add(new vkl(a.d("\u415e\u38c1\ub212\u2c76\ua7f1\u2105\u9b5f\u12bb\u8ce9\u065e\u819e", -121238918, -430027932), true));
    private final vyn mjx = new vyn();
    private boolean mjy;
    private boolean mjz;
    private int mka;
    private int mkb;
    private static /* synthetic */ int mkc;
    private static /* synthetic */ String mkd;

    public mjr() {
        super(a.c(-84008016, "\u23f8\u5a7d\ud0af\u4ec5\uc53c\u43be\uf9f2\u7001\uee43"), a.c(962174746, "\u9f1c\ue688\u6c5a\uf22c\u79a8\uff56\u4504\uccbb\u52aa\ud810\u5fd2\ua5bf\u2b65\ub2c3\u388b\ube67\u0439\u8bad\u1151\u971d\u1eb8\u64ad\uea13\u71ca\uf7b9\u7d6a\uc4d8\u4a83\ud030\u5620\udd80\u234e\ua903\u30e8\ub6bc\u3c5f\u83c9\u09ad\u8f2a\u16d4\u9c8a\ue276\u6823\uefdb\u7500\ufb22\u42f5\uc852\u4e0c\ud5de\u5bfe\ua16e\u2898\uae8b\u3468\uba2e\u0195\u874e\u0d3f\u94e9\u1a57\u6041\ue7e2\u6daa\uf369\u7ade\uc08b\u463f\ucc2e\u5396\ud958\u5f7b\ua6e5\u2c15\ub214\u39f2\ubfb0\u0510\u8ccb\u12a1\u9879\u1e29\u65de\ueb40\u7136\uf8ec"), kfa.PLAYER);
    }

    @Override
    protected void onDisable() {
        if (this.mjy) {
            this.mjx.release(this.mc);
            this.mjy = false;
        }
        this.mjz = false;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (this.mjz && !this.mjy && minecraftClient.player != null) {
            this.mjx.hold(minecraftClient);
            this.mjy = true;
            this.mka = 0;
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (clientPlayerEntity == null) {
            return;
        }
        if (this.mkb > 0) {
            --this.mkb;
        }
        boolean bl2 = bl = this.mkb == 0 && this.mkf(minecraftClient, clientPlayerEntity) && this.mkh(clientPlayerEntity);
        if (!bl) {
            this.mjz = false;
            this.mke();
            return;
        }
        if (vyn.serverIdle(clientPlayerEntity) || mjr.mkg(minecraftClient, clientPlayerEntity)) {
            this.mki(minecraftClient, clientPlayerEntity);
            this.mjz = false;
            this.mke();
            this.mkb = 2;
            return;
        }
        this.mjz = true;
        if (this.mjy && ++this.mka > 6) {
            this.mke();
            this.mjz = false;
            this.mkb = 10;
        }
    }

    private void mke() {
        if (this.mjy) {
            this.mjx.release(this.mc);
            this.mjy = false;
        }
    }

    private boolean mkf(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        if (!clientPlayerEntity.isAlive() || clientPlayerEntity.isSpectator() || !wdq.canClick(clientPlayerEntity)) {
            return false;
        }
        if (minecraftClient.currentScreen != null && !mjr.mkg(minecraftClient, clientPlayerEntity)) {
            return false;
        }
        return !oxw.busy() && !kvz.busy() && !clientPlayerEntity.isUsingItem();
    }

    private static boolean mkg(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        HandledScreen handledScreen;
        Screen screen = minecraftClient.currentScreen;
        return screen instanceof HandledScreen && (handledScreen = (HandledScreen)screen).getScreenHandler() == clientPlayerEntity.playerScreenHandler;
    }

    private boolean mkh(ClientPlayerEntity clientPlayerEntity) {
        for (EquipmentSlot equipmentSlot : mjs) {
            if (this.mkj(clientPlayerEntity, equipmentSlot) == null) continue;
            return true;
        }
        return false;
    }

    private void mki(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        for (EquipmentSlot equipmentSlot : mjs) {
            vuc vuc2 = this.mkj(clientPlayerEntity, equipmentSlot);
            if (vuc2 == null || vui.equip(minecraftClient, equipmentSlot, vuc2)) continue;
            return;
        }
    }

    private vuc mkj(ClientPlayerEntity clientPlayerEntity, EquipmentSlot equipmentSlot) {
        boolean bl;
        ItemStack itemStack2 = clientPlayerEntity.getEquippedStack(equipmentSlot);
        if (equipmentSlot == EquipmentSlot.CHEST && this.mjw.get() && itemStack2.isOf(Items.ELYTRA)) {
            return null;
        }
        int n = this.mju.getInt();
        boolean bl2 = itemStack2.isEmpty();
        boolean bl3 = bl = !bl2 && itemStack2.isDamageable() && vui.left(itemStack2) <= n;
        if (!bl2 && !bl) {
            return null;
        }
        int n2 = bl2 ? 0 : vui.left(itemStack2);
        PlayerInventory playerInventory = clientPlayerEntity.getInventory();
        vuc vuc2 = vui.best(playerInventory, this.mjv.get(), itemStack -> {
            if (vui.wornIn(itemStack) != equipmentSlot || mjr.mkk(itemStack) == 0) {
                return 0;
            }
            int n3 = vui.left(itemStack);
            if (n3 <= n || !bl2 && n3 <= n2) {
                return 0;
            }
            return mjr.mkk(itemStack) * 100000 + Math.min(99999, n3);
        });
        if (vuc2 == null || !vui.roomFor(playerInventory, vuc2, itemStack2)) {
            return null;
        }
        return vuc2;
    }

    private static int mkk(ItemStack itemStack) {
        String string = Registries.ITEM.getId((Object)itemStack.getItem()).getPath();
        if (string.startsWith(a.c(1739830118, "\ub302\ucab8\u407a\ude17\u55cd\ud36b\u6923\ue0cf\u7e81\uf40a"))) {
            return 2;
        }
        return string.startsWith(a.c(-1583474427, "\u1969\u60d5\uea0e\u7473\uffa6\u7916\uc34f\u4a85")) ? 1 : 0;
    }

    private static /* synthetic */ int bbh(int n, int n2) {
        return n - n2 + -107924305;
    }

    private static /* synthetic */ int bbi(int n, int n2) {
        return mjr.bbh(n, n2) + n;
    }

    private static /* synthetic */ int bbj(int n, int n2) {
        return mjr.bbi(n, n2) * n2;
    }
}

