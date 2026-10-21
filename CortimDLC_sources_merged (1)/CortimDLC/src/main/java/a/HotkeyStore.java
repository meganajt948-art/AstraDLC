/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package a;

import a.Friends;
import a.hzq;
import a.Theme;
import a.WallpaperManager;
import a.Hud;
import a.NowPlaying;
import a.Module;
import a.PartyClient;
import a.BoolSetting;
import a.KeySetting;
import a.Setting;
import a.KeyUtil;
import a.Lang;
import a.Waypoints;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import net.minecraft.class_310;

public final class HotkeyStore {
    public static final List<hzq> ALL = List.of(new hzq("hud", "Show HUD", () -> HotkeyStore.hzz("HUD", Hud.ENABLED)), new hzq("waypoints", "Show waypoints", () -> HotkeyStore.hzz(Lang.t("Waypoints"), Waypoints.ENABLED)), new hzq("waypoint.here", "Waypoint here", HotkeyStore::hzy), new hzq("theme.light", "Light / dark theme", () -> {
        Theme.toggleLight();
        HotkeyStore.iaa(Lang.t("Theme") + "  " + Theme.shownName(Theme.presetName()));
    }), new hzq("theme.next", "Next theme", () -> {
        Theme.cycle(1);
        HotkeyStore.iaa(Lang.t("Theme") + "  " + Theme.shownName(Theme.presetName()));
    }), new hzq("wallpaper.next", "Next wallpaper", () -> HotkeyStore.iaa(Lang.t("Wallpaper") + "  " + WallpaperManager.next())), new hzq("music.toggle", "Play / pause music", () -> NowPlaying.command("toggle")), new hzq("music.next", "Next track", () -> NowPlaying.command("next")), new hzq("friend", "Add / remove friend", KeyUtil.mouse(2), Friends::toggleAimed), new hzq("party.mark", "Party mark", KeyUtil.mouse(3), PartyClient::markKey));
    private static /* synthetic */ boolean hzw;
    private static /* synthetic */ boolean hzx;

    static hzq friendKey() {
        for (hzq hzq2 : ALL) {
            if (!hzq2.id.equals("friend")) continue;
            return hzq2;
        }
        throw new IllegalStateException("no friend hotkey");
    }

    static hzq partyMarkKey() {
        for (hzq hzq2 : ALL) {
            if (!hzq2.id.equals("party.mark")) continue;
            return hzq2;
        }
        throw new IllegalStateException("no party mark hotkey");
    }

    private HotkeyStore() {
    }

    public static void run(int n) {
        for (hzq hzq2 : ALL) {
            if (hzq2.key != n) continue;
            try {
                hzq2.hzr.run();
            }
            catch (RuntimeException runtimeException) {
                System.out.println("hotkey " + hzq2.name + " failed: " + runtimeException);
            }
        }
    }

    static List<String> boundTo(int n, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (n == -1) {
            return arrayList;
        }
        for (Module object : Flow.getInstance().getModuleManager().getModules()) {
            if (object.getKey() == n && !object.getName().equals(string) && !object.getDisplayName().equals(string)) {
                arrayList.add(object.getDisplayName());
            }
            for (Setting vmo2 : object.getSettings()) {
                KeySetting vlq2;
                if (!(vmo2 instanceof KeySetting) || (vlq2 = (KeySetting)vmo2).get() != n || vlq2.getName().equals(string)) continue;
                arrayList.add(object.getDisplayName() + " " + Lang.t(vlq2.getName()));
            }
        }
        for (hzq hzq2 : ALL) {
            if (hzq2.key != n || hzq2.name.equals(string)) continue;
            arrayList.add(Lang.t(hzq2.name));
        }
        return arrayList;
    }

    private static void hzy() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null) {
            return;
        }
        int n = Waypoints.inWorld().size();
        String string = Lang.s("Waypoint ", "Метка ") + (n + 1);
        Waypoints.add(string, class_3102.field_1724.method_31477(), class_3102.field_1724.method_31478(), class_3102.field_1724.method_31479(), Waypoints.COLORS[n % Waypoints.COLORS.length]);
        HotkeyStore.iaa(Lang.s("Added ", "Добавлена ") + string + "  " + class_3102.field_1724.method_31477() + " " + class_3102.field_1724.method_31478() + " " + class_3102.field_1724.method_31479());
    }

    private static void hzz(String string, BoolSetting vkl2) {
        vkl2.toggle();
        HotkeyStore.iaa(string + "  " + Lang.value(vkl2.get() ? "On" : "Off").toLowerCase(Locale.ROOT));
    }

    private static void iaa(String string) {
        Hud.notify("Flow", string);
    }

    static void load(Properties properties) {
        for (hzq hzq2 : ALL) {
            try {
                hzq2.key = Integer.parseInt(properties.getProperty("hotkey." + hzq2.id, String.valueOf(hzq2.hzs)).trim());
            }
            catch (NumberFormatException numberFormatException) {
                hzq2.key = hzq2.hzs;
            }
        }
    }

    static void save(Properties properties) {
        for (hzq hzq2 : ALL) {
            properties.setProperty("hotkey." + hzq2.id, String.valueOf(hzq2.key));
        }
    }

    private static /* synthetic */ int aen(int n, int n2) {
        return n - n2 + -1863657296;
    }
}

