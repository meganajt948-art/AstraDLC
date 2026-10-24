/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.KeySetting;
import a.CooldownPress;
import a.Lang;
import flow.dev.StringDecryptor;
import net.minecraft.class_1802;
import net.minecraft.class_310;

public class KeyPearl
extends Module {
    private static KeyPearl kwa;
    private final KeySetting kwb = this.add(new KeySetting("Кнопка броска"));
    private final CooldownPress kwc = new CooldownPress(class_1802.field_8634, true);
    private static /* synthetic */ boolean kwd;
    private static /* synthetic */ long kwe;

    public KeyPearl() {
        super("ClickPearl", "Throws an ender pearl on a key", ModuleCategory.PLAYER);
        kwa = this;
    }

    public static boolean busy() {
        return kwa != null && KeyPearl.kwa.kwc.busy();
    }

    @Override
    protected void onEnable() {
        this.kwc.reset(this.mc);
    }

    @Override
    protected void onDisable() {
        this.kwc.reset(this.mc);
    }

    @Override
    public void onKey(class_310 class_3102, int n) {
        if (n == this.kwb.get()) {
            this.kwc.press(class_3102, n, this.getName(), Lang.s("No pearls", "Нет жемчуга"));
        }
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.kwc.startTick(class_3102);
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        this.kwc.endTick(class_3102);
    }

    private static /* synthetic */ int avi(int n, int n2) {
        return n + n2 ^ 0xD5357292;
    }

    private static /* synthetic */ int avj(int n, int n2) {
        return KeyPearl.avi(n, n2) ^ 0xE948822C;
    }
}

