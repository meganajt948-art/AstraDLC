/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jsf;
import a.Lang;
import a.whl;
import flow.dev.StringDecryptor;
import java.awt.Color;
import java.util.ArrayList;

public final class WallpaperEntry {
    private static final WallpaperEntry[] kbt;
    public static final WallpaperEntry DEFAULT;
    private static WallpaperEntry kbu;
    public final String key;
    private final String kbv;
    private final String kbw;
    public final int accent;
    public final jsf particles;
    public final int tint;
    public final int fill;
    public final boolean light;
    private int kbx;
    private static /* synthetic */ boolean kby;
    private static /* synthetic */ String kbz;

    private WallpaperEntry(String string, String string2, String string3, int n, jsf jsf2, int n2, int n3, boolean bl) {
        this.key = string;
        this.kbv = string2;
        this.kbw = string3;
        this.accent = n;
        this.particles = jsf2;
        this.tint = n2;
        this.fill = n3;
        this.light = bl;
    }

    public boolean logo() {
        return this.fill >= 0;
    }

    public String title() {
        return Lang.s(this.kbv, this.kbw);
    }

    public int ordinal() {
        return this.kbx;
    }

    public boolean isVideo() {
        return whl.is(this.key);
    }

    public static WallpaperEntry[] values() {
        return kbt;
    }

    public static WallpaperEntry selected() {
        return kbu;
    }

    public static void select(WallpaperEntry kbs2) {
        kbu = kbs2;
    }

    public static void load(String string) {
        WallpaperEntry kbs2 = WallpaperEntry.byKey(string);
        if (kbs2 != null) {
            kbu = kbs2;
        }
    }

    public static WallpaperEntry byKey(String string) {
        for (WallpaperEntry kbs2 : kbt) {
            if (!kbs2.key.equals(string)) continue;
            return kbs2;
        }
        return null;
    }

    static String resource(String string) {
        if (whl.is(string)) {
            return whl.poster(string.substring("video:".length()));
        }
        return "/flow/menu/" + string + ".jpg";
    }

    private static int kca(int n) {
        float[] fArray = Color.RGBtoHSB(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, null);
        float f = Math.max(0.32f, Math.min(0.62f, fArray[1]));
        return Color.HSBtoRGB(fArray[0], f, 1.0f) & 0xFFFFFF;
    }

    static {
        Object[][] objectArrayArray;
        ArrayList<WallpaperEntry> arrayList = new ArrayList<WallpaperEntry>();
        arrayList.add(new WallpaperEntry("video:flow-dark", "Flow Black", "Flow Чёрная", 14476012, jsf.SILVER, 0xFFFFFF, 263430, false));
        arrayList.add(new WallpaperEntry("video:flow-light", "Flow White", "Flow Белая", 2764342, jsf.INK, 0xFFFFFF, 0xEEEFED, true));
        for (Object[] objectArray : objectArrayArray = new Object[][]{{"sparkle", "Sparkle", "Спаркл", 15231626, jsf.MOTES}, {"cherry", "Cherry Leaves", "Вишнёвые листья", 15771864, jsf.PETALS}, {"autumn-cats", "Autumn Cats", "Осенние котики", 15764026, jsf.LEAVES}, {"castle", "Castle in the Clouds", "Замок в облаках", 8370408, jsf.MOTES}, {"snow", "Falling Snow", "Снегопад", 11131391, jsf.MOTES}, {"hsr-sky", "Sky Meadow", "Небесный луг", 7321328, jsf.PETALS}, {"flowers", "Girl with Flowers", "Девушка с цветами", 15254138, jsf.MOTES}, {"elf", "Dark Elf", "Тёмная эльфийка", 11570431, jsf.FIREFLIES}, {"samurai", "Wandering Samurai", "Странствующий самурай", 0xE05050, jsf.MOTES}, {"farm", "Sunset Farm", "Ферма на закате", 15904842, jsf.MOTES}}) {
            arrayList.add(new WallpaperEntry("video:" + objectArray[0], (String)objectArray[1], (String)objectArray[2], WallpaperEntry.kca((Integer)objectArray[3]), (jsf)((Object)objectArray[4]), 0xFFFFFF, -1, false));
        }
        kbt = arrayList.toArray(new WallpaperEntry[0]);
        for (int i = 0; i < kbt.length; ++i) {
            WallpaperEntry.kbt[i].kbx = i;
        }
        kbu = DEFAULT = kbt[0];
    }

    private static /* synthetic */ int arr(int n, int n2) {
        return n * n2 ^ 0x24D0174D;
    }
}

