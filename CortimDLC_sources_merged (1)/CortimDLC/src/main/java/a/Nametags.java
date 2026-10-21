/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;

public class Nametags
extends Module {
    private static Nametags rfm;
    public final NumberSetting range = this.add(new NumberSetting("Range", 32.0, 8.0, 96.0, 4.0).suffix("m"));
    public final NumberSetting size = this.add(new NumberSetting("Size", 1.0, 0.6, 1.6, 0.05).percent());
    public final ModeSetting background = this.add(new ModeSetting("Background", "Solid", "Solid", "None"));
    public final BoolSetting icon = this.add(new BoolSetting("Icon", true));
    public final BoolSetting merge = this.add(new BoolSetting("Merge", true));
    public final BoolSetting rarity = this.add(new BoolSetting("Rarity colour", true));
    private static /* synthetic */ boolean rfn;
    private static /* synthetic */ String rfo;

    public Nametags() {
        super(new String(new char[]{'I', 't', 'e', 'm', 'E', 'S', 'P'}), "Tags over dropped items", ModuleCategory.RENDER);
        rfm = this;
    }

    public static Nametags get() {
        return rfm;
    }

    private static /* synthetic */ int bya(int n, int n2) {
        return n + n2 ^ 0x392B8097;
    }

    private static /* synthetic */ int byb(int n, int n2) {
        return Nametags.bya(n, n2) ^ 0x494D7297;
    }

    private static /* synthetic */ int byc(int n, int n2) {
        return n + n2 + -381137047;
    }
}

