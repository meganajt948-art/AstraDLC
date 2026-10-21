/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_437
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import flow.bot.BotScreen;
import flow.dev.StringDecryptor;
import net.minecraft.class_437;

public class BotsModule
extends Module {
    private final BoolSetting oqn = this.add(new BoolSetting("Solve captcha", true));
    private static /* synthetic */ long oqo;
    private static /* synthetic */ boolean oqp;

    public BotsModule() {
        super("Bots", "Extra bot accounts for farming", ModuleCategory.PLAYER);
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
        if (this.mc.field_1755 instanceof BotScreen) {
            this.mc.method_1507(null);
            return;
        }
        this.mc.method_1507((class_437)new BotScreen());
    }

    private static /* synthetic */ int beg(int n, int n2) {
        return n ^ n2 ^ 0xBDACBC6F;
    }
}

