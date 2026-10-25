/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.Screen
 */
package a;

import a.kfa;
import a.kfe;
import a.vkl;
import flow.bot.BotScreen;
import flow.dev.a;
import net.minecraft.client.gui.screen.Screen;

public class oqm
extends kfe {
    private final vkl oqn = this.add(new vkl(a.c(305493345, "\u753f\u0cb2\u8662\u1809\u93cd\u1539\uaf29\u26da\ub894\u3221\ub5e5\u4f9f\uc141"), true));
    private static /* synthetic */ long oqo;
    private static /* synthetic */ boolean oqp;

    public oqm() {
        super(a.d("\u281d\u5181\udb49\u453f", -2045997647, -1448499734), a.c(1139491451, "\u4220\u3bac\ub173\u2f04\ua4c0\u2230\u9821\u11dd\u8f99\u057c\u82ee\u789d\uf64a\u6ff7\ue5be\u6354\ud901\u56d7\ucc37\u4a20\uc3de\ub992\u3773\uace4\u2a9c\ua05e\u19f2\u97a7\u0d57\u8b0f"), kfa.PLAYER);
    }

    public boolean solvesCaptcha() {
        return this.oqn.get();
    }

    @Override
    public boolean isAction() {
        return true;
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    @Override
    public void toggle() {
        if (this.isMaintenance()) {
            return;
        }
        if (this.mc.currentScreen instanceof BotScreen) {
            this.mc.setScreen(null);
            return;
        }
        this.mc.setScreen((Screen)new BotScreen());
    }

    private static /* synthetic */ int beg(int n, int n2) {
        return n ^ n2 ^ 0xBDACBC6F;
    }
}

