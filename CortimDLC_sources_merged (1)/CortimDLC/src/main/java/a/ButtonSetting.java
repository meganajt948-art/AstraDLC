/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vkq;
import a.Setting;
import java.util.List;

public class ButtonSetting
extends Setting {
    private final List<vkq> vkx;
    private static /* synthetic */ int vky;
    private static /* synthetic */ String vkz;

    public ButtonSetting(String string, vkq ... vkqArray) {
        super(string);
        this.vkx = List.of(vkqArray);
    }

    public List<vkq> buttons() {
        return this.vkx;
    }

    private static /* synthetic */ int dgt(int n, int n2) {
        return n - n2 ^ 0x169F4C10;
    }

    private static /* synthetic */ int dgu(int n, int n2) {
        return ButtonSetting.dgt(n, n2) * n2;
    }
}

