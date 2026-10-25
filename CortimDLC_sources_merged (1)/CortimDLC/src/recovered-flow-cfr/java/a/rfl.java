/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.kfa;
import a.kfe;
import a.vkl;
import a.vlv;
import a.vmc;

public class rfl
extends kfe {
    private static rfl rfm;
    public final vmc range = this.add(new vmc("Range", 32.0, 8.0, 96.0, 4.0).suffix("m"));
    public final vmc size = this.add(new vmc("Size", 1.0, 0.6, 1.6, 0.05).percent());
    public final vlv background = this.add(new vlv("Background", "Solid", "Solid", "None"));
    public final vkl icon = this.add(new vkl("Icon", true));
    public final vkl merge = this.add(new vkl("Merge", true));
    public final vkl rarity = this.add(new vkl("Rarity colour", true));
    private static /* synthetic */ boolean rfn;
    private static /* synthetic */ String rfo;

    public rfl() {
        super(new String(new char[]{'I', 't', 'e', 'm', 'E', 'S', 'P'}), "Tags over dropped items", kfa.RENDER);
        rfm = this;
    }

    public static rfl get() {
        return rfm;
    }

    private static /* synthetic */ int bya(int n, int n2) {
        return n + n2 ^ 0x392B8097;
    }

    private static /* synthetic */ int byb(int n, int n2) {
        return rfl.bya(n, n2) ^ 0x494D7297;
    }

    private static /* synthetic */ int byc(int n, int n2) {
        return n + n2 + -381137047;
    }
}

