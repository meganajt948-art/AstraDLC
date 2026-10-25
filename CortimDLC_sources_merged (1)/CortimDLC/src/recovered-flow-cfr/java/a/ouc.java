/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 */
package a;

import a.izx;
import a.kfa;
import a.kfe;
import a.kvz;
import a.oxw;
import a.vhz;
import a.vlq;
import a.vuc;
import a.vui;
import a.vyn;
import a.vzh;
import a.vzz;
import a.wap;
import a.wdq;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

public class ouc
extends kfe {
    private static final int oud = 6;
    private final vlq oue = this.add(new vlq(a.b("\ua9ee\ud07b\u5abe\uc4de\u4f59\uc9a3\u73fe\ufa13", 95922613)));
    private final vlq ouf = this.add(new vlq(a.d("\uf05b\u89c5\u030d\u9d6b\u16ae\u9007\u2a49\ua3a1\u3db5\ub74f\u3092\ucaff", 1374212688, 1801200193)));
    private final vzh oug = new vzh(Items.FIREWORK_ROCKET);
    private final vyn ouh = new vyn();
    private boolean oui;
    private boolean ouj;
    private int ouk;
    private int oul;
    private static /* synthetic */ boolean oum;
    private static /* synthetic */ int oun;

    public ouc() {
        super(a.b("\uf8e1\u8179\u0bbf\u95c3\u1e12\u98b0\u22d1\uab04\u354d\ubfed", -937101138), a.c(1145135342, "\u60f1\u1964\u93a1\u0dc1\u8615\u00f7\ubaf0\u331d\uad4f\u27bb\ua02b\u5a51\ud48b\u4d2c\uc778\u418d\ufbde\u7402\ueea4\u68e4\ue156\u9b46\u15fa\u8e21\u081a\u829f\u3b30\ub56c\u2fde\ua9ca\u2270\udcb4\u56f6\ucf01\u4941\uc3b1\u7c29\uf659\u70c4\ue93a\u6364\u1d9e\u9788\u1072\u8aab\u04c6\ubd40\u37fd\ub1e7\u2a30\ua455\u5e92\ud776\u5166\ucbd4\u45c3\ufe73\u78b9\uf2dd\u6b1e\ue5b1\u9ffd\u1817\u920d\u0c8d\u853d\u3f20\ub985\u33ce\uac72\u26e4\ua0da\u591e\ud3b3\u4ded\uc60b"), kfa.PLAYER);
    }

    @Override
    protected void onEnable() {
        if (!this.oue.isBound() && !this.ouf.isBound() && this.mc.player != null) {
            izx.alert(this.getName(), wap.s(a.d("\uf887\u811d\u0bc9\u95b2\u1e21\u98c4\u228b\uab77\u356d\ubf97\u384a\uc227\u4cfa\ud518\u5f02\ud9f4\u63f5\uec6d\u76c3\uf095\u7931\u0333\u8d96\u1656\u9029\u1ae5\ua351\u2d09\ub7ea", -690312238, 1522619146), a.d("\u920c\ueb90\u6144\uff3f\u74e5\uf223\u487b\uc5e6\u5fa3\ud515\u52c5\ua8b5\u2667\ubfd4\u319f\ub37c\u0d21\u86ed\u1c53\u9a73\u1387\u69d4\ue719\u7ccf\ufab3\u7068\uc9ae", 851516112, 108694746)), vhz.KEYBOARD, false);
        }
    }

    @Override
    protected void onDisable() {
        this.ouj = false;
        this.oup();
        this.ouq();
        this.oug.reset(this.mc);
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (n == this.oue.get()) {
            this.ouj = true;
            this.ouk = 0;
        } else if (n == this.ouf.get() && !this.ouj) {
            this.oug.press(minecraftClient, n, this.getName(), wap.s(a.c(1730095261, "\u28df\u514f\udbd3\u45e4\uce3c\u4896\uf2d2\u7b31\ue576\u6fda\ue810\u1279"), a.c(-274947199, "\ua793\ude0a\u54ae\ucebd\u410e\uc7ce\u7d91\uf46c\u6a46\ue085\u6751\u9d55\u13f8\u8a4d\u0012")));
        }
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        this.oug.startTick(minecraftClient);
        if (this.oul > 0 && --this.oul == 0) {
            this.ouq();
        }
        if (this.ouj && !this.oui && minecraftClient.player != null && !vyn.serverIdle(minecraftClient.player)) {
            this.ouh.hold(minecraftClient);
            this.oui = true;
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        this.oug.endTick(minecraftClient);
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (!this.ouj || clientPlayerEntity == null) {
            return;
        }
        if (!wdq.canClick(clientPlayerEntity) || minecraftClient.currentScreen != null || oxw.busy() || kvz.busy() || this.oug.busy()) {
            if (++this.ouk > 6) {
                this.ouj = false;
                this.oup();
            }
            return;
        }
        if (!vyn.serverIdle(clientPlayerEntity)) {
            if (++this.ouk > 6) {
                this.ouj = false;
                this.oup();
            }
            return;
        }
        this.ouj = false;
        this.ouo(minecraftClient, clientPlayerEntity);
        this.oup();
    }

    private void ouo(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity) {
        ItemStack itemStack2 = clientPlayerEntity.getEquippedStack(EquipmentSlot.CHEST);
        boolean bl = !itemStack2.isOf(Items.ELYTRA);
        vuc vuc2 = vui.best(clientPlayerEntity.getInventory(), true, itemStack -> {
            if (bl) {
                return itemStack.isOf(Items.ELYTRA) && vui.left(itemStack) > 1 ? 1 + Math.min(9999, vui.left(itemStack)) : 0;
            }
            if (vui.wornIn(itemStack) != EquipmentSlot.CHEST || itemStack.isOf(Items.ELYTRA)) {
                return 0;
            }
            String string = Registries.ITEM.getId((Object)itemStack.getItem()).getPath();
            int n = string.startsWith(a.c(744795749, "\uae01\ud7bb\u5d79\uc314\u48ce\uce68\u7420\ufdcc\u6382\ue909")) ? 6 : (string.startsWith(a.c(-1652743933, "\u216f\u58d3\ud208\u4c75\uc7a0\u4110\ufb49\u7283")) ? 5 : (string.startsWith(a.b("\u27fb\u5e51\ud49f\u4aef\uc109", -237492329)) ? 4 : (string.startsWith(a.c(-117954676, "\u27e5\u5e5f\ud485\u4afc\uc12c\u479e\ufdc1\u7438\uea62\u60e0")) ? 3 : (string.startsWith(a.c(291825617, "\ue7b1\u9e08\u14d8\u8aa1\u0177\u87cd\u3daf")) ? 2 : 1))));
            return n * 100000 + Math.min(99999, vui.left(itemStack));
        });
        if (vuc2 == null) {
            izx.alert(this.getName(), bl ? wap.s(a.d("\u380f\u419f\ucb03\u5537\udee9\u584d\ue213\u6be4\uf5a8", -852681235, -2130369115), a.c(910612228, "\ud310\uaa89\u202d\uba3e\u3584\ub343\u0913\u8098\u1ec5")) : wap.s(a.d("\uf584\u8c14\u0688\u98ba\u1366\u95da\u2f9f\ua669\u3832\ub29f\u3541\ucf25\u41e3", 138987540, -1493221933), a.d("\ud24a\uabd3\u2177\ubb64\u34ae\ub212\u0842\u81c0\u1f9c\u955a\u1280\ue8f4\u6621\uff9a", 538288357, 381056700)), vhz.INFO, false);
            return;
        }
        if (!vui.roomFor(clientPlayerEntity.getInventory(), vuc2, itemStack2)) {
            izx.alert(this.getName(), wap.s(a.d("\u06d3\u7f43\uf5df\u6bfc\ue036\u6687\udcd6\u556a\ucb7c\u41ca\uc657\u3c72\ub2b9\u2b05\ua113\u27ab\u9de3\u122a\u888a\u0ed0\u873d\ufd77\u73d9\ue803", 85146633, 954415756), a.c(118085557, "\ud3bd\uaa24\u2080\uba93\u3558\ub3e0\u09c7\u8035\u1e18\u90b9\u1378\ued1b\u67d4\ufe60\u743c\uf2ca\u488d\uc723\u5de2\udbc3\u5241")), vhz.INFO, false);
            return;
        }
        if (vui.equip(minecraftClient, EquipmentSlot.CHEST, vuc2) && bl && !clientPlayerEntity.isOnGround() && !clientPlayerEntity.isGliding() && !clientPlayerEntity.getAbilities().flying) {
            minecraftClient.options.jumpKey.setPressed(true);
            this.oul = 2;
        }
    }

    private void oup() {
        if (this.oui) {
            this.ouh.release(this.mc);
            this.oui = false;
        }
    }

    private void ouq() {
        if (this.mc.options != null && this.mc.getWindow() != null) {
            this.mc.options.jumpKey.setPressed(vzz.isPhysicallyDown(this.mc, this.mc.options.jumpKey));
        }
        this.oul = 0;
    }

    private static /* synthetic */ int bey(int n, int n2) {
        return n + n2 ^ 0x3E693F6A;
    }
}

