/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import a.kfa;
import a.kfe;
import a.mpq;
import a.nxa;
import a.oqv;
import a.osq;
import a.vkl;
import a.vmc;
import a.vxl;
import flow.dev.a;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class otn
extends kfe {
    private final vmc oto = this.add(new vmc(a.c(2015664505, "\u9938\ue0a8\u6a72\uf40e\u7fc1"), 60.0, 0.0, 500.0, 10.0).suffix(a.b("\ubb6c\uc2c3", 424655619)));
    private final vmc otp = this.add(new vmc(a.d("\ud56c\uacee\u2632\ub849\u3395\ub526", -78782486, -1419900206), 40.0, 0.0, 300.0, 10.0).suffix(a.c(1416209304, "\ua3f7\uda58")));
    private final vkl otq = this.add(new vkl(a.d("\u660d\u1f88\u955a\u0b30\u80a8\u065a\ubc06\u35f4\uabb7\u2110", -1516567235, -402496645), true));
    private final vkl otr = this.add(new vkl(a.c(-1737755196, "\uf583\u8c13\u068f\u98b6\u1366\u95cc\u2f89\ua67b\u3837"), false));
    private static final long ots = 180L;
    private static final long ott = 300L;
    private final Random otu = new Random();
    private Screen otv;
    private long otw;
    private long otx;
    private long oty;
    private static /* synthetic */ int otz;
    private static /* synthetic */ int oua;

    public otn() {
        super(a.c(238885778, "\u1bdd\u6247\ue899\u76fe\ufd2e\u7bb8\uc1cc\u482c\ud677\u5ccb\udb11\u2177"), a.b("\ud7ef\uae76\u24b8\ubacd\u3107\ub7ba\u0dff\u845d\u1a56\u90fb\u1725\ued11\u6385\ufa3f\u7061\uf686\u4cce\uc318\u59f8\udff0\u5611\u2c5a\ua2bc\u3922\ubf42\u3586\u8c3e", -648751183), kfa.PLAYER);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        HandledScreen handledScreen;
        long l;
        block12: {
            block11: {
                Screen screen = minecraftClient.currentScreen;
                l = System.currentTimeMillis();
                if (screen != this.otv) {
                    this.otv = screen;
                    this.otw = l;
                    this.oty = l;
                    this.otx = l + 180L;
                }
                if (!(screen instanceof HandledScreen)) break block11;
                handledScreen = (HandledScreen)screen;
                if (vxl.isStorage(screen) && !oqv.busy() && !osq.busy() && !otn.oub()) break block12;
            }
            return;
        }
        ScreenHandler screenHandler = handledScreen.getScreenHandler();
        if (!screenHandler.getCursorStack().isEmpty() || l < this.otx) {
            return;
        }
        PlayerInventory playerInventory = minecraftClient.player.getInventory();
        for (Slot slot : vxl.own(screenHandler, playerInventory)) {
            if (!slot.hasStack() || !slot.canTakeItems((PlayerEntity)minecraftClient.player) || vxl.room(screenHandler, playerInventory, slot.getStack(), !this.otr.get()) == null) continue;
            if (this.otr.get()) {
                Slot slot2 = vxl.room(screenHandler, playerInventory, slot.getStack(), false);
                vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.PICKUP);
                vxl.click(minecraftClient, screenHandler, slot2.id, 0, SlotActionType.PICKUP);
                if (!screenHandler.getCursorStack().isEmpty()) {
                    vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.PICKUP);
                }
            } else {
                vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.QUICK_MOVE);
            }
            this.oty = l;
            this.otx = l + (long)this.oto.getInt() + (long)(this.otp.getInt() > 0 ? this.otu.nextInt(this.otp.getInt() + 1) : 0);
            return;
        }
        if (this.otq.get() && l - this.oty > 300L && l - this.otw > 480L) {
            handledScreen.close();
        }
    }

    private static boolean oub() {
        nxa nxa2 = nxa.mainInstance();
        if (nxa2 != null && nxa2.isEnabled() && nxa2.busy()) {
            return true;
        }
        mpq mpq2 = mpq.mainInstance();
        return mpq2 != null && mpq2.isEnabled() && mpq2.busy();
    }

    private static /* synthetic */ int bev(int n, int n2) {
        return n ^ n2 ^ 0x3FFCBC02;
    }
}

