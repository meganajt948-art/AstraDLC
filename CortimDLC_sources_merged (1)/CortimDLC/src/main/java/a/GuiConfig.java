/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.PanicShutdown;
import a.CloudSync;
import a.Friends;
import a.UserProfile;
import a.ClickGuiScreen;
import a.LiquidGlass;
import a.HotkeyStore;
import a.Theme;
import a.WallpaperManager;
import a.Hud;
import a.TitleLayoutSetting;
import a.WallpaperEntry;
import a.PartyClient;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
import a.FileWriter;
import a.Lang;
import a.whl;
import a.Waypoints;
import flow.Flow;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.dev.StringDecryptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public final class GuiConfig {
    private static final String hza = "gui.scroll.";
    private static final String hzb = "/flow/default-gui.properties";
    private static final int hzc = 4;
    private static final int hzd = 1;
    private static final int hze = 1;
    private static final int hzf = 1;
    private static /* synthetic */ long hzg;
    private static /* synthetic */ long hzh;

    private GuiConfig() {
    }

    static Path gameDir() {
        return ConfigManager.gameDir();
    }

    private static List<Object[]> hzi() {
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        for (Setting object : Theme.ALL) {
            arrayList.add(new Object[]{"theme." + object.getName(), object});
        }
        for (Setting vmo2 : LiquidGlass.ALL) {
            arrayList.add(new Object[]{"glass." + vmo2.getName(), vmo2});
        }
        for (Setting vmo3 : Waypoints.ALL) {
            arrayList.add(new Object[]{"waypoints." + vmo3.getName(), vmo3});
        }
        for (Setting vmo4 : Friends.ALL) {
            arrayList.add(new Object[]{"friends." + vmo4.getName(), vmo4});
        }
        for (Setting vmo5 : PartyClient.ALL) {
            arrayList.add(new Object[]{"party." + vmo5.getName(), vmo5});
        }
        for (Setting vmo6 : Cosmetics.ALL) {
            arrayList.add(new Object[]{"cosmetics." + vmo6.getName(), vmo6});
        }
        for (Setting vmo7 : TitleLayoutSetting.ALL) {
            arrayList.add(new Object[]{"menu.look." + vmo7.getName(), vmo7});
        }
        arrayList.add(new Object[]{"wallpaper.fit", WallpaperManager.FIT});
        arrayList.add(new Object[]{"wallpaper.darken", WallpaperManager.DARKEN});
        arrayList.add(new Object[]{"wallpaper.motion", WallpaperManager.MOTION});
        arrayList.add(new Object[]{"wallpaper.particles", WallpaperManager.PARTICLES});
        arrayList.add(new Object[]{"config.autosave", ConfigManager.AUTO_SAVE});
        arrayList.add(new Object[]{"config.loadonstart", ConfigManager.LOAD_ON_START});
        for (Map.Entry entry : Hud.persisted().entrySet()) {
            arrayList.add(new Object[]{entry.getKey(), entry.getValue()});
        }
        return arrayList;
    }

    public static void load() {
        int n;
        String string;
        Object object22;
        String string2 = CloudSync.get("gui");
        boolean bl = string2 == null || string2.isBlank();
        Properties properties = new Properties();
        try (InputStream inputStream = bl ? GuiConfig.class.getResourceAsStream("/flow/default-gui.properties") : new ByteArrayInputStream(string2.getBytes(StandardCharsets.ISO_8859_1));){
            if (inputStream == null) {
                return;
            }
            properties.load(inputStream);
        }
        catch (Exception exception) {
            System.out.println("can't read menu settings: " + exception);
            return;
        }
        for (Object object22 : GuiConfig.hzi()) {
            string = properties.getProperty((String)object22[0]);
            if (string == null) continue;
            try {
                Setting vmo2 = (Setting)object22[1];
                if (vmo2 instanceof BoolSetting) {
                    BoolSetting vkl2 = (BoolSetting)vmo2;
                    vkl2.set(Boolean.parseBoolean(string));
                    continue;
                }
                if (vmo2 instanceof NumberSetting) {
                    NumberSetting object3 = (NumberSetting)vmo2;
                    object3.set(Double.parseDouble(string));
                    continue;
                }
                if (!(vmo2 instanceof ModeSetting)) continue;
                ModeSetting vlv2 = (ModeSetting)vmo2;
                vlv2.set(string);
            }
            catch (RuntimeException runtimeException) {}
        }
        try {
            n = Integer.parseInt(properties.getProperty("design", "0").trim());
        }
        catch (NumberFormatException numberFormatException) {
            n = 0;
        }
        object22 = properties.getProperty("wallpaper");
        if (object22 != null) {
            WallpaperManager.select((String)object22);
        }
        if (n < 4) {
            Theme.resetLook();
            LiquidGlass.ENABLED.reset();
            Hud.BACKGROUND.reset();
            WallpaperManager.select("world");
        }
        if (!String.valueOf(1).equals(properties.getProperty("wallpaperRev"))) {
            WallpaperManager.select("video:flow-dark");
        }
        if (!String.valueOf(1).equals(properties.getProperty("roundRev"))) {
            Theme.ROUNDNESS.reset();
        }
        Theme.loadColors(properties);
        Hud.load(properties);
        HotkeyStore.load(properties);
        Lang.load(properties.getProperty("language"));
        WallpaperEntry.load(properties.getProperty("menu.background"));
        if (!String.valueOf(1).equals(properties.getProperty("flowRev"))) {
            Theme.choose("Flow Black");
            WallpaperEntry.select(WallpaperEntry.DEFAULT);
        }
        whl.warm(WallpaperEntry.selected().key, WallpaperManager.selected());
        UserProfile.select(properties.getProperty("avatar"));
        UserProfile.seenOwn(properties.getProperty("avatar.own"));
        Cosmetics.load(properties);
        string = properties.getProperty("config.active");
        if (string != null && ConfigManager.exists(string)) {
            ConfigManager.setActive(string);
        }
        try {
            int n2 = Integer.parseInt(properties.getProperty("menuKey", ""));
            if (n2 > 0) {
                Flow.getInstance().setOpenGuiKey(n2);
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        String string3 = properties.getProperty("gui.tab");
        if (string3 != null) {
            ClickGuiScreen.setTabKey(string3);
        }
        for (String string4 : properties.stringPropertyNames()) {
            if (!string4.startsWith("gui.scroll.")) continue;
            try {
                ClickGuiScreen.scrolls().put(string4.substring("gui.scroll.".length()), Float.valueOf(Float.parseFloat(properties.getProperty(string4))));
            }
            catch (NumberFormatException numberFormatException) {}
        }
        try {
            float f = Float.parseFloat(properties.getProperty("gui.x", "NaN"));
            float f2 = Float.parseFloat(properties.getProperty("gui.y", "NaN"));
            ClickGuiScreen.setWindowPos(f, f2);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public static void save() {
        if (PanicShutdown.armed()) {
            return;
        }
        GuiConfig.hzk(GuiConfig.hzj());
    }

    public static void saveLater() {
        if (PanicShutdown.armed()) {
            return;
        }
        Properties properties = GuiConfig.hzj();
        FileWriter.later("menu settings", () -> GuiConfig.hzk(properties));
    }

    private static Properties hzj() {
        Properties properties = new Properties();
        for (Object[] object : GuiConfig.hzi()) {
            String string;
            Setting vmo2 = (Setting)object[1];
            if (vmo2 instanceof BoolSetting) {
                BoolSetting vkl2 = (BoolSetting)vmo2;
                string = String.valueOf(vkl2.get());
            } else if (vmo2 instanceof NumberSetting) {
                NumberSetting vmc2 = (NumberSetting)vmo2;
                string = String.valueOf(vmc2.get());
            } else {
                if (!(vmo2 instanceof ModeSetting)) continue;
                ModeSetting vlv2 = (ModeSetting)vmo2;
                string = vlv2.get();
            }
            properties.setProperty((String)object[0], string);
        }
        properties.setProperty("design", String.valueOf(4));
        properties.setProperty("wallpaper", WallpaperManager.selected());
        properties.setProperty("wallpaperRev", String.valueOf(1));
        properties.setProperty("flowRev", String.valueOf(1));
        properties.setProperty("roundRev", String.valueOf(1));
        Theme.saveColors(properties);
        Hud.save(properties);
        HotkeyStore.save(properties);
        if (Lang.chosen()) {
            properties.setProperty("language", Lang.code());
        }
        properties.setProperty("avatar", UserProfile.selected());
        properties.setProperty("avatar.own", UserProfile.seenOwn());
        Cosmetics.save(properties);
        properties.setProperty("menu.background", WallpaperEntry.selected().key);
        properties.setProperty("menuKey", String.valueOf(Flow.getInstance().getOpenGuiKey()));
        if (ConfigManager.active() != null) {
            properties.setProperty("config.active", ConfigManager.active());
        }
        if (ClickGuiScreen.tabKey() != null) {
            properties.setProperty("gui.tab", ClickGuiScreen.tabKey());
        }
        for (Map.Entry entry : ClickGuiScreen.scrolls().entrySet()) {
            properties.setProperty("gui.scroll." + (String)entry.getKey(), String.valueOf(entry.getValue()));
        }
        if (!Float.isNaN(ClickGuiScreen.windowX())) {
            properties.setProperty("gui.x", String.valueOf(ClickGuiScreen.windowX()));
            properties.setProperty("gui.y", String.valueOf(ClickGuiScreen.windowY()));
        }
        return properties;
    }

    private static void hzk(Properties properties) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            properties.store(byteArrayOutputStream, "Flow2 menu (look, config options, waypoint display, last position)");
            CloudSync.put("gui", byteArrayOutputStream.toString(StandardCharsets.ISO_8859_1));
        }
        catch (Exception exception) {
            System.out.println("can't save menu settings: " + exception);
        }
    }

    private static /* synthetic */ int aeb(int n, int n2) {
        return n * n2 + -33371183;
    }

    private static /* synthetic */ int aec(int n, int n2) {
        return n + n2 + 1756919990;
    }
}

