/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 */
package a;

import a.BotHost;
import a.ModuleCategory;
import a.BotModule;
import a.Setting;
import flow.Flow;
import flow.dev.StringDecryptor;
import net.minecraft.class_2561;
import net.minecraft.class_2596;

public class AncientFarmer
extends BotModule {
    private static AncientFarmer lqr;
    private static /* synthetic */ boolean lqs;
    private static /* synthetic */ String lqt;

    public AncientFarmer() {
        super("AncientFarmer", "Farms ancient debris in flight: blows up TNT and digs out what the blast reveals", ModuleCategory.MISC);
        if (lqr == null) {
            lqr = this;
        }
    }

    @Override
    public boolean isMaintenance() {
        return false;
    }

    public static boolean busy() {
        return false;
    }

    public static AncientFarmer get() {
        AncientFarmer lqq2 = lqr;
        if (lqq2 == null) {
            Flow flow = Flow.getInstance();
            lqq2 = flow == null || flow.getModuleManager() == null ? null : flow.getModuleManager().get(AncientFarmer.class);
        }
        return lqq2;
    }

    public int mined() {
        return 0;
    }

    public int blasts() {
        return 0;
    }

    public String lastNote() {
        return null;
    }

    public String status() {
        return "";
    }

    @Override
    public void attachBot(BotHost efz2) {
        super.attachBot(efz2);
        if (lqr == this) {
            lqr = null;
        }
    }

    @Override
    public void setBotRunning(boolean bl) {
        if (!bl) {
            super.setBotRunning(false);
        }
    }

    public Setting[] botSettings() {
        return new Setting[0];
    }

    public void copySettingsFrom(AncientFarmer lqq2) {
    }

    public void onPacket(class_2596<?> class_25962) {
    }

    public static void onMessage(class_2561 class_25612) {
    }

    public void onChat(class_2561 class_25612) {
    }

    private static /* synthetic */ int ayq(int n, int n2) {
        return n + n2 ^ 0x320E8C99;
    }

    private static /* synthetic */ int ayr(int n, int n2) {
        return AncientFarmer.ayq(n, n2) ^ 0x3F14498D;
    }

    private static /* synthetic */ int ays(int n, int n2) {
        return AncientFarmer.ayq(n, n2) * n2;
    }
}

