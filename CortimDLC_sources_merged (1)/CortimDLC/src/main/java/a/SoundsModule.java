/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_310
 */
package a;

import a.ClickGuiScreen;
import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Sounds;
import a.SoundLibrary;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_310;

public class SoundsModule
extends Module {
    private static SoundsModule lsh;
    private final ModeSetting lsi = this.add(new ModeSetting("Toggle", "Celestial", (String[])SoundsModule.lst(false).toArray(String[]::new)));
    private final BoolSetting lsj = this.add(new BoolSetting("Menu", true));
    private final ModeSetting lsk = this.add(new ModeSetting("Hit", "Off", (String[])SoundsModule.lst(true).toArray(String[]::new)));
    private final NumberSetting lsl = this.add(new NumberSetting("Volume", 0.6, 0.0, 1.5, 0.05).percent());
    private long lsm;
    private long lsn;
    private int lso = SoundLibrary.version();
    private String lsp;
    private String lsq;
    private static /* synthetic */ boolean lsr;
    private static /* synthetic */ long lss;

    public SoundsModule() {
        super("ClientSounds", "Sounds for toggles and hits", ModuleCategory.MISC);
        lsh = this;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        boolean bl = class_3102.field_1755 instanceof ClickGuiScreen;
        long l = System.currentTimeMillis();
        if (bl && l - this.lsn > 1200L) {
            this.lsn = l;
            SoundLibrary.scan();
        }
        if (this.lso != SoundLibrary.version()) {
            this.lsu();
        }
        if (this.lsp != null && !this.lsi.is(this.lsp) && bl && !this.lsi.is("Off")) {
            Sounds.play(this.lsi.get(), true, (float)this.lsl.get());
        } else if (this.lsq != null && !this.lsk.is(this.lsq) && bl && !this.lsk.is("Off")) {
            Sounds.play(this.lsk.get(), true, (float)this.lsl.get());
        }
        this.lsp = this.lsi.get();
        this.lsq = this.lsk.get();
    }

    private static List<String> lst(boolean bl) {
        SoundLibrary.scan();
        ArrayList<String> arrayList = new ArrayList<String>();
        if (bl) {
            arrayList.add("Off");
        }
        arrayList.addAll(Sounds.BUILT_IN);
        arrayList.addAll(SoundLibrary.extras());
        if (!bl) {
            arrayList.add("Off");
        }
        return arrayList;
    }

    private void lsu() {
        this.lsi.setModes(SoundsModule.lst(false));
        this.lsk.setModes(SoundsModule.lst(true));
        this.lso = SoundLibrary.version();
    }

    private static void lsv() {
        SoundsModule lsg2 = lsh;
        SoundLibrary.scan();
        if (lsg2 != null) {
            lsg2.lsu();
            if (!lsg2.lsi.is("Off")) {
                Sounds.play(lsg2.lsi.get(), true, (float)lsg2.lsl.get());
            }
        }
    }

    private static boolean lsw() {
        class_310 class_3102 = class_310.method_1551();
        return lsh != null && lsh.isEnabled() && class_3102.field_1724 != null;
    }

    public static void toggled(Module kfe2) {
        SoundsModule lsg2 = lsh;
        if (!SoundsModule.lsw() || kfe2 == lsg2 && !kfe2.isEnabled() || lsg2.lsi.is("Off")) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - lsg2.lsm < 60L) {
            return;
        }
        lsg2.lsm = l;
        Sounds.play(lsg2.lsi.get(), kfe2.isEnabled(), (float)lsg2.lsl.get());
    }

    public static void menu(boolean bl) {
        SoundsModule lsg2 = lsh;
        if (!SoundsModule.lsw() || !lsg2.lsj.get() || lsg2.lsi.is("Off")) {
            return;
        }
        Sounds.menu(lsg2.lsi.get(), bl, (float)lsg2.lsl.get());
    }

    public static void hit(class_1297 class_12972) {
        SoundsModule lsg2 = lsh;
        if (!SoundsModule.lsw() || lsg2.lsk.is("Off") || !(class_12972 instanceof class_1309)) {
            return;
        }
        Sounds.play(lsg2.lsk.get(), true, (float)lsg2.lsl.get());
    }

    private static /* synthetic */ int azf(int n, int n2) {
        return n + n2 + -1273447958;
    }
}

