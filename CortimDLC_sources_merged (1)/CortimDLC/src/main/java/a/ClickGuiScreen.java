/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_11905
 *  net.minecraft.class_11908
 *  net.minecraft.class_11909
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package a;

import a.PanicShutdown;
import a.AvatarCloud;
import a.CloudSync;
import a.Friends;
import a.AutoAccentRow;
import a.UserProfile;
import a.hip;
import a.ButtonSettingRow;
import a.ModuleAccessGate;
import a.hks;
import a.hkv;
import a.HudColorRow;
import a.ConfigSaveRow;
import a.ConfigFindRow;
import a.ConfigCardRow;
import a.CosmeticThumbCard;
import a.ModeDropdown;
import a.FriendAddRow;
import a.FriendsList;
import a.LiquidGlass;
import a.GuiConfig;
import a.hzq;
import a.HotkeyStore;
import a.LabelRow;
import a.TextField;
import a.ItemPickerPopup;
import a.ClickRow;
import a.LanguageScreen;
import a.ChangeNotice;
import a.Popup;
import a.PartyCodeCard;
import a.PartyInviteRow;
import a.PartyMembersList;
import a.ColorRow;
import a.Widget;
import a.Theme;
import a.ThemePicker;
import a.irk;
import a.UiKit;
import a.WallpaperRow;
import a.WallpaperManager;
import a.WaypointForm;
import a.WaypointList;
import a.ArmorHudWidget;
import a.Hud;
import a.NowPlaying;
import a.TargetHudWidget;
import a.WatermarkWidget;
import a.ModuleCategory;
import a.Module;
import a.SoundsModule;
import a.HealthBars;
import a.PartyClient;
import a.ColorUtil;
import a.CompositePass;
import a.GlassDraw;
import a.FrameDelta;
import a.LogoRenderer;
import a.AnimatedLogo;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Tween;
import a.FontFace;
import a.Icon;
import a.IconRenderer;
import a.ColorSetting;
import a.ListSetting;
import a.ModeSetting;
import a.Setting;
import a.EncodedString;
import a.KeyUtil;
import a.wam;
import a.Lang;
import a.Waypoints;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.Flow;
import flow.config.ConfigManager;
import flow.cosmetic.Cosmetics;
import flow.dev.StringDecryptor;
import flow.util.LoaderInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public class ClickGuiScreen
extends class_437 {
    static final float W = 540.0f;
    static final float H = 409.0f;
    private static final float hld = 136.0f;
    private static final float hle = 46.0f;
    private static final float hlf = 14.0f;
    private static final float hlg = 10.0f;
    private static final float hlh = 23.0f;
    private static final float hli = 25.0f;
    private static final float hlj = 62.0f;
    private static final float hlk = 136.0f;
    private static final float hll = 20.0f;
    private static final float hlm = 20.0f;
    private static int hln;
    private static String hlo;
    private static float hlp;
    private static float hlq;
    private static final Map<String, Float> hlr;
    private static final Map<Module, ModuleAccessGate> hls;
    private static List<ModuleAccessGate> hlt;
    private static List<ModuleAccessGate> hlu;
    private static List<ModuleAccessGate> hlv;
    private static List<ModuleAccessGate> hlw;
    private static List<ModuleAccessGate> hlx;
    private static List<ModuleAccessGate> hly;
    private final List<hkv> hlz = new ArrayList<hkv>();
    private int hma;
    private List<ModuleAccessGate> hmb = new ArrayList<ModuleAccessGate>();
    private final Tween hmc = new Tween(0.3f, 0.0f);
    private final Tween hmd = new Tween(0.42f, 0.0f);
    private final Tween hme = new Tween(0.32f, 1.0f);
    private final Tween hmf = new Tween(0.18f, 1.0f);
    private final Spring hmg = new Spring(16.0f);
    private final List<Spring> hmh = new ArrayList<Spring>();
    private final List<Spring> hmi = new ArrayList<Spring>();
    private final List<Spring> hmj = new ArrayList<Spring>();
    private int[] hmk = new int[0];
    private final Spring hml = new Spring(16.0f);
    private final Spring hmm = new Spring(8.0f);
    private final Spring hmn = new Spring(14.0f);
    private final Spring hmo = new Spring(8.0f);
    private float hmp;
    private float hmq;
    private long hmr;
    private int hms;
    private String hmt = "";
    private String hmu = "";
    private String hmv = "";
    private String hmw = "";
    private boolean hmx;
    private boolean hmy;
    private boolean hmz;
    private float hna;
    private float hnb;
    private Widget hnc;
    private ModeDropdown hnd;
    private Popup hne;
    private irk hnf;
    private String hng = "";
    private int hnh = -1;
    private String hni = "";
    private Icon hnj = Icon.INFO;
    private boolean hnk;
    private long hnl;
    private String hnm;
    private String hnn;
    private static final long hno = 350L;
    private static final float hnp = 220.0f;
    private static final float hnq = 7.0f;
    private final Spring hnr = new Spring(14.0f);
    private ModuleAccessGate hns;
    private long hnt;
    private ModuleAccessGate hnu;
    private ModuleAccessGate hnv;
    private List<String> hnw = List.of();
    private ModuleAccessGate hnx;
    private wam hny;
    private float hnz;
    private static String hoa;
    private static final Set<ModuleAccessGate> hob;
    private static final int hoc = 4;
    private String hod = "";
    private final TextField hoe = new TextField("Search", Icon.SEARCH, 24, TextField.ANY);
    private TextField hof;
    private final Spring hog = new Spring(16.0f);
    private final Spring hoh = new Spring(14.0f);
    private final Spring[] hoi = new Spring[]{new Spring(16.0f), new Spring(16.0f), new Spring(16.0f), new Spring(16.0f)};
    private long hoj;
    private final Spring hok = new Spring(14.0f);
    private final Spring hol = new Spring(9.0f);
    private final Spring hom = new Spring(13.0f);
    private boolean hon;
    private long hoo = -1L;
    private float hop = 0.016666668f;
    private float hoq = 1.0f;
    private float hor = 1.0f;
    private float hos;
    private float hot;
    private float hou;
    private float hov;
    private GpuTextureView how;
    private static final float hox = 18.0f;
    private static final float hoy = 24.0f;
    private static final float hoz = 7.0f;
    private static final float hpa = 18.0f;
    private static final int hpb = -1750963;
    private static final float hpc = 46.0f;
    private static /* synthetic */ int hpd;
    private static /* synthetic */ boolean hpe;

    public ClickGuiScreen() {
        super((class_2561)class_2561.method_43470((String)"AstraDLC"));
        AvatarCloud.refresh();
        this.hod = hoa;
        this.hoe.text = hoa;
        this.hoe.onChange = this::hri;
        this.hoe.onSubmit = () -> this.focus(null);
    }

    static String tabKey() {
        return hlo;
    }

    static void setTabKey(String string) {
        hlo = string;
    }

    static Map<String, Float> scrolls() {
        return hlr;
    }

    static float windowX() {
        return hlp;
    }

    static float windowY() {
        return hlq;
    }

    static void setWindowPos(float f, float f2) {
        hlp = f;
        hlq = f2;
    }

    static float contentCenterX() {
        return 0.6259259f;
    }

    static float contentCenterY() {
        return 0.5562347f;
    }

    protected void method_25426() {
        int n;
        if (!this.hlz.isEmpty()) {
            this.hpj();
            return;
        }
        this.hlz.clear();
        this.hmh.clear();
        this.hmi.clear();
        this.hmj.clear();
        for (ModuleCategory kfa2 : ModuleCategory.values()) {
            this.hlz.add(new hkv(kfa2.title(), ClickGuiScreen.iconFor(kfa2), kfa2, hks.MODULES));
        }
        this.hma = this.hlz.size();
        this.hlz.add(new hkv("HUD", Icon.LAYOUT, null, hks.HUD));
        this.hlz.add(new hkv("Configs", Icon.LAYERS, null, hks.CONFIGS));
        this.hlz.add(new hkv("Waypoints", Icon.PIN, null, hks.WAYPOINTS));
        this.hlz.add(new hkv("Friends", Icon.FRIENDS, null, hks.FRIENDS));
        this.hlz.add(new hkv("Cosmetics", Icon.CROWN, null, hks.COSMETICS));
        for (n = 0; n < this.hlz.size(); ++n) {
            this.hmh.add(new Spring(16.0f));
            this.hmi.add(new Spring(7.0f));
            this.hmj.add(new Spring(7.0f));
        }
        this.hmk = new int[this.hlz.size()];
        if (hlo != null) {
            for (n = 0; n < this.hlz.size(); ++n) {
                if (!this.hlz.get((int)n).hkw.equals(hlo)) continue;
                hln = n;
            }
        }
        hln = Math.max(0, Math.min(hln, this.hlz.size() - 1));
        hlo = this.hlz.get((int)ClickGuiScreen.hln).hkw;
        for (Module kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            hls.computeIfAbsent(kfe2, ModuleAccessGate::new);
        }
        if (hlt == null) {
            ClickGuiScreen.hpf();
        }
        WallpaperManager.rescan();
        this.hpm(false);
        this.hpq();
        this.hmg.set(this.hqa(hln));
        this.hpj();
    }

    private static void hpf() {
        Object object;
        ModuleAccessGate hjg2 = new ModuleAccessGate("Theme", "Presets. Glass ones let the picture through").row(new ThemePicker());
        hjg2.wide = true;
        ModuleAccessGate hjg3 = new ModuleAccessGate("Accent", "Auto takes the theme's own. Or pick your colour").row(new AutoAccentRow()).settings(List.of(Theme.GRADIENT)).row(new ColorRow().visibleWhen(() -> Theme.ACCENT.is("Custom")));
        hjg3.home = 0;
        ModuleAccessGate hjg4 = new ModuleAccessGate("Custom theme", "Every colour of the menu and the HUD. Editing switches to it").settings(List.of(Theme.PAINT)).row(new HudColorRow()).settings(Theme.CUSTOM_SLIDERS).row(new ButtonSettingRow(new hip("From current", Icon.LAYERS, Theme::customFromCurrent), new hip("Reset", Icon.RESET, Theme::resetCustom)));
        for (Setting object52 : Theme.CUSTOM_SLIDERS) {
            Widget imn2 = hjg4.rowFor(object52);
            if (imn2 == null) continue;
            imn2.visibleWhen(() -> Theme.PAINT.is("Menu"));
        }
        hjg4.home = 1;
        ModuleAccessGate hjg5 = new ModuleAccessGate("Wallpaper", "Menu background: live skies, moving photos").row(new WallpaperRow()).settings(List.of(WallpaperManager.FIT, WallpaperManager.DARKEN, WallpaperManager.MOTION, WallpaperManager.PARTICLES));
        hjg5.wide = true;
        for (Setting vmo2 : List.of(WallpaperManager.FIT, WallpaperManager.DARKEN, WallpaperManager.MOTION, WallpaperManager.PARTICLES)) {
            Widget imn3 = hjg5.rowFor(vmo2);
            if (imn3 == null) continue;
            if (vmo2 == WallpaperManager.DARKEN) {
                imn3.activeWhen(() -> !WallpaperManager.selected().equals("world"));
                continue;
            }
            if (vmo2 == WallpaperManager.PARTICLES) {
                imn3.activeWhen(() -> WallpaperManager.photoSelected() && WallpaperManager.MOTION.get() > 0.001);
                continue;
            }
            imn3.activeWhen(WallpaperManager::photoSelected);
        }
        ModuleAccessGate hjg6 = new ModuleAccessGate("Liquid Glass", "Refraction over the picture and the world").toggle(LiquidGlass.ENABLED).settings(LiquidGlass.OPTICS).row(new ButtonSettingRow("Reset glass", Icon.RESET, LiquidGlass::resetAll));
        for (Setting vmo3 : LiquidGlass.LIQUID_ONLY) {
            object = hjg6.rowFor(vmo3);
            if (object == null) continue;
            ((Widget)object).activeWhen(LiquidGlass::liquid);
        }
        hjg6.home = 1;
        ModuleAccessGate hjg7 = new ModuleAccessGate("Glass parts", "Which parts are glass").settings(LiquidGlass.TARGETS);
        hjg7.home = 1;
        ModuleAccessGate hjg8 = new ModuleAccessGate("Interface", "Size, corners, motion, the game behind").settings(Theme.INTERFACE);
        hjg8.home = 0;
        hlt = List.of(hjg2, hjg3, hjg4, hjg5, hjg8, hjg6, hjg7);
        object = new ModuleAccessGate("HUD", "In the chat: drag parts to move, right drag to size").toggle(Hud.ENABLED).settings(Hud.LOOK).row(new ButtonSettingRow(new hip("Edit layout", Icon.MOVE, Hud::openEditor), new hip("Reset", Icon.RESET, Hud::resetLayout)));
        ((ModuleAccessGate)object).home = 0;
        ModuleAccessGate hjg9 = new ModuleAccessGate("Watermark", "FPS, ping, TPS, speed and position, top centre").toggle(Hud.WATERMARK.enabled).settings(WatermarkWidget.ISLAND);
        hjg9.home = 0;
        ModuleAccessGate hjg10 = new ModuleAccessGate("Target", "Who you hit or look at: health, armour, hands").toggle(Hud.TARGET.enabled).settings(TargetHudWidget.OPTIONS);
        hjg10.home = 0;
        ModuleAccessGate hjg11 = new ModuleAccessGate("Music", "Spotify, Yandex Music, a browser. Controls in the chat").toggle(WatermarkWidget.MUSIC).settings(WatermarkWidget.MUSIC_SETTINGS).row(new LabelRow("Now", NowPlaying::summary)).row(new ButtonSettingRow(new hip("", Icon.PREV, () -> NowPlaying.command("prev")), new hip("Play / Pause", Icon.PLAY, () -> NowPlaying.command("toggle")), new hip("", Icon.NEXT, () -> NowPlaying.command("next"))));
        hjg11.home = 1;
        ModuleAccessGate hjg12 = new ModuleAccessGate("Potions", "Active effects and time left").toggle(Hud.POTIONS.enabled).settings(Hud.POTIONS.settings());
        hjg12.home = 1;
        ModuleAccessGate hjg13 = new ModuleAccessGate("Keybinds", "Modules with a key. Middle click a module to bind").toggle(Hud.KEYBINDS.enabled).settings(Hud.KEYBINDS.settings());
        hjg13.home = 1;
        ModuleAccessGate hjg14 = new ModuleAccessGate("Cooldowns", "Pearls, chorus, wind charges").toggle(Hud.COOLDOWNS.enabled);
        hjg14.home = 1;
        ModuleAccessGate hjg15 = new ModuleAccessGate("Items", "ServerHelper item keys: item, count, cooldown, key").toggle(Hud.ITEMS.enabled);
        hjg15.home = 1;
        ModuleAccessGate hjg16 = new ModuleAccessGate("Armor", "Your armour and how much of it is left").toggle(Hud.ARMOR.enabled).settings(ArmorHudWidget.OPTIONS);
        hjg16.home = 0;
        hlu = List.of(object, hjg9, hjg10, hjg11, hjg12, hjg13, hjg14, hjg15, hjg16);
        ConfigSaveRow hur2 = new ConfigSaveRow();
        ModuleAccessGate hjg17 = new ModuleAccessGate("Configs", "Modules, settings and binds. Share one with a code").row(hur2).row(new ConfigFindRow()).row(new ConfigCardRow(hur2));
        hjg17.wide = true;
        irk irk2 = new irk("Menu", () -> Flow.getInstance().getOpenGuiKey(), n -> Flow.getInstance().setOpenGuiKey(n), false);
        ModuleAccessGate hjg18 = new ModuleAccessGate("Options", "Auto-save writes the active config when the menu closes").settings(List.of(ConfigManager.AUTO_SAVE, ConfigManager.LOAD_ON_START)).row(new ClickRow("Menu key", irk2));
        hjg18.home = 0;
        ModuleAccessGate hjg19 = new ModuleAccessGate("Cloud", "Saved to your account, nothing stored on this PC").row(new LabelRow("Active", () -> ConfigManager.active() != null ? ConfigManager.active() : Lang.t("none"))).row(new LabelRow("Saved", () -> String.valueOf(ConfigManager.list().size()))).row(new LabelRow("Status", () -> CloudSync.online() ? Lang.s("synced", "в облаке") : Lang.s("offline", "оффлайн"))).row(new ButtonSettingRow(new hip("Sync now", Icon.FOLDER, ClickGuiScreen::hpg)));
        hjg19.home = 1;
        ModuleAccessGate hjg20 = new ModuleAccessGate("Hotkeys", "Client functions on keys. One key can run many things");
        for (hzq hzq2 : HotkeyStore.ALL) {
            hjg20.row(new ClickRow(hzq2.name, hzq2.bind));
        }
        hjg20.home = 0;
        hlv = List.of(hjg17, hjg18, hjg19, hjg20);
        WaypointForm iui2 = new WaypointForm();
        ModuleAccessGate hjg21 = new ModuleAccessGate("New waypoint", "Coordinates or Here. Tab moves, Enter adds").row(iui2);
        hjg21.home = 0;
        ModuleAccessGate hjg22 = new ModuleAccessGate("Display", "Markers in the world").toggle(Waypoints.ENABLED).settings(Waypoints.DISPLAY);
        hjg22.home = 0;
        ModuleAccessGate hjg23 = new ModuleAccessGate("Waypoints", "This world. Click one to edit").row(new WaypointList(iui2));
        hjg23.home = 1;
        hlw = List.of(hjg21, hjg22, hjg23);
        ModuleAccessGate hjg24 = new ModuleAccessGate("Add friend", "By name. Or middle click a player in the world").row(new FriendAddRow());
        hjg24.home = 0;
        ModuleAccessGate hjg25 = new ModuleAccessGate("Nearby", "Players around you. Click one to add or remove").row(new ChangeNotice());
        hjg25.home = 0;
        ModuleAccessGate hjg26 = new ModuleAccessGate("Click friend", "The friend key adds or removes the player you aim at. Off: it does nothing").toggle(Friends.CLICK).settings(Friends.CLICK_OPTIONS).row(new ClickRow("Friend key", HotkeyStore.friendKey().bind)).unfolded();
        hjg26.home = 0;
        ModuleAccessGate hjg27 = new ModuleAccessGate("Options", "Combat modules never go for friends").settings(Friends.OPTIONS);
        hjg27.home = 0;
        ModuleAccessGate hjg28 = new ModuleAccessGate("Friends", "Everywhere, by name. Hover one to remove it").row(new FriendsList());
        hjg28.home = 1;
        hlx = List.of(hjg24, hjg26, hjg25, hjg27, hjg28);
        hly = List.of(new ModuleAccessGate("Coming Soon", "Cosmetics are temporarily unavailable"));
    }

    private static void hpg() {
        Thread thread = new Thread(CloudSync::flushNow, "Flow2 cloud sync");
        thread.setDaemon(true);
        thread.start();
    }

    public static Icon iconFor(ModuleCategory kfa2) {
        return switch (kfa2) {
            default -> throw new MatchException(null, null);
            case ModuleCategory.COMBAT -> Icon.COMBAT;
            case ModuleCategory.MOVEMENT -> Icon.MOVEMENT;
            case ModuleCategory.PLAYER -> Icon.PLAYER;
            case ModuleCategory.RENDER -> Icon.RENDER;
            case ModuleCategory.MISC -> Icon.MISC;
        };
    }

    private static int hph(ModuleCategory kfa2) {
        int n = 0;
        for (Module kfe2 : Flow.getInstance().getModuleManager().getModules()) {
            if (!kfe2.isEnabled() || kfe2.isHidden() || kfa2 != null && kfe2.getCategory() != kfa2) continue;
            ++n;
        }
        return n;
    }

    private float hpi() {
        float f = Math.min(((float)this.field_22789 - 16.0f) / 540.0f, ((float)this.field_22790 - 16.0f) / 409.0f);
        return Math.max(0.3f, Math.min((float)Theme.SCALE.get(), f));
    }

    private void hpj() {
        if (this.field_22789 < 64 || this.field_22790 < 64) {
            return;
        }
        float f = this.hpi();
        float f2 = 540.0f * f;
        float f3 = 409.0f * f;
        if (Float.isNaN(hlp) || Float.isNaN(hlq)) {
            hlp = ((float)this.field_22789 - f2) * 0.5f;
            hlq = ((float)this.field_22790 - f3) * 0.5f;
        }
        hlp = Math.max(60.0f - f2, Math.min((float)this.field_22789 - 60.0f, hlp));
        hlq = Math.max(0.0f, Math.min((float)this.field_22790 - 30.0f, hlq));
    }

    private static List<Module> hpk(List<Module> list) {
        ArrayList<Module> arrayList = new ArrayList<Module>(list);
        arrayList.removeIf(Module::isHidden);
        arrayList.sort(Comparator.comparing(kfe2 -> kfe2.getName().toLowerCase(Locale.ROOT)));
        return arrayList;
    }

    private List<ModuleAccessGate> hpl(hkv hkv2) {
        return switch (hkv2.hkz.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1 -> hlt;
            case 2 -> hlu;
            case 3 -> hlv;
            case 4 -> hlw;
            case 5 -> hlx;
            case 6 -> hly;
            case 0 -> {
                ArrayList<ModuleAccessGate> var2_2 = new ArrayList<ModuleAccessGate>();
                for (Module var4_4 : ClickGuiScreen.hpk(Flow.getInstance().getModuleManager().getByCategory(hkv2.hky))) {
                    var2_2.add(hls.get(var4_4));
                }
                yield var2_2;
            }
        };
    }

    private void hpm(boolean bl) {
        ArrayList<ModuleAccessGate> arrayList = new ArrayList<ModuleAccessGate>();
        HashSet<ModuleAccessGate> hashSet = new HashSet<ModuleAccessGate>();
        if (!this.hod.isEmpty()) {
            Iterator iterator2 = this.hod.trim();
            ArrayList<ModuleAccessGate> object = new ArrayList<ModuleAccessGate>();
            for (Module kfe2 : ClickGuiScreen.hpk(Flow.getInstance().getModuleManager().getModules())) {
                object.add(hls.get(kfe2));
            }
            for (List list : List.of(hlt, hlu, hlv, hlw, hlx, hly)) {
                object.addAll(list);
            }
            HashMap hashMap = new HashMap();
            for (ModuleAccessGate hjg3 : object) {
                int n = ClickGuiScreen.hpn(hjg3, iterator2);
                if (n <= 0) continue;
                arrayList.add(hjg3);
                hashMap.put(hjg3, n);
                if (n > 60 || n <= 40 || !hjg3.isCollapsed() && !hob.contains(hjg3)) continue;
                hashSet.add(hjg3);
            }
            if (hashSet.size() > 4) {
                hashSet.clear();
            }
            arrayList.sort(Comparator.comparingInt(hjg2 -> -((Integer)hashMap.get(hjg2)).intValue()));
        } else {
            arrayList.addAll(this.hpl(this.hlz.get(hln)));
        }
        for (ModuleAccessGate hjg4 : hob) {
            if (hashSet.contains(hjg4)) continue;
            hjg4.setCollapsed(true);
        }
        for (ModuleAccessGate hjg5 : hashSet) {
            hjg5.setCollapsed(false);
        }
        hob.clear();
        hob.addAll(hashSet);
        boolean bl2 = !arrayList.equals(this.hmb);
        this.hmb = arrayList;
        this.hpo();
        if (bl2 && bl) {
            this.hmd.restart();
            this.hmp = 0.0f;
            this.hml.set(0.0f);
        }
    }

    private static int hpn(ModuleAccessGate hjg2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        if (hjg2.module != null) {
            stringBuilder.append(Lang.both(hjg2.module.getCategory().title()));
        }
        for (Widget object2 : hjg2.rows) {
            if (object2.setting == null || object2.targetHeight() <= 0.0f) continue;
            stringBuilder.append(' ').append(Lang.both(object2.setting.getName()));
            Setting vmo2 = object2.setting;
            if (!(vmo2 instanceof ModeSetting)) continue;
            ModeSetting vlv2 = (ModeSetting)vmo2;
            if (object2.setting instanceof ColorSetting) continue;
            for (String string2 : vlv2.getModes()) {
                stringBuilder.append(' ').append(Lang.both(string2));
            }
        }
        String string3 = hjg2.module != null ? hjg2.module.getName() : hjg2.title;
        String string4 = hjg2.module != null ? Lang.aliases(string3) : null;
        return Lang.score(string, Lang.names(string3), string4, stringBuilder.toString(), hjg2.searchDescription());
    }

    private void hpo() {
        int n;
        boolean bl;
        boolean bl2 = bl = this.hod.isEmpty() && this.hlz.get((int)ClickGuiScreen.hln).hkz != hks.MODULES;
        if (bl) {
            for (ModuleAccessGate hjg2 : this.hmb) {
                hjg2.column = Math.max(0, hjg2.home);
            }
            return;
        }
        int n2 = this.hmb.size();
        float f = 0.0f;
        for (ModuleAccessGate hjg3 : this.hmb) {
            f += hjg3.targetHeight() + 10.0f;
        }
        int n3 = n2;
        float f2 = 0.0f;
        float f3 = Float.MAX_VALUE;
        for (n = 0; n <= n2; ++n) {
            float f4 = Math.max(f2, f - f2);
            if (f4 <= f3 + 0.01f) {
                f3 = f4;
                n3 = n;
            }
            if (n >= n2) continue;
            f2 += this.hmb.get(n).targetHeight() + 10.0f;
        }
        for (n = 0; n < n2; ++n) {
            this.hmb.get((int)n).column = n < n3 ? 0 : 1;
        }
    }

    private void hpp() {
        if (this.hod.isEmpty() && !this.hlz.isEmpty()) {
            hlr.put(this.hlz.get((int)ClickGuiScreen.hln).hkw, Float.valueOf(this.hmp));
        }
    }

    private void hpq() {
        float f;
        this.hmp = f = hlr.getOrDefault(this.hlz.get((int)ClickGuiScreen.hln).hkw, Float.valueOf(0.0f)).floatValue();
        this.hml.set(f);
    }

    boolean canHover() {
        return !this.hmx && !this.hpr() && !this.hmz && this.hnc == null && this.hnf == null;
    }

    private boolean hpr() {
        return this.hnd != null && !this.hnd.closing();
    }

    boolean isDragging(Widget imn2) {
        return this.hnc == imn2;
    }

    void startDrag(Widget imn2) {
        this.hnc = imn2;
    }

    boolean isDropdownFor(ModeSetting vlv2) {
        return this.hnd != null && !this.hnd.closing() && this.hnd.mode == vlv2;
    }

    void openDropdown(ModeSetting vlv2, float f, float f2, float f3, float f4) {
        this.hnd = new ModeDropdown(vlv2, f, f2, f3, f4, 403.0f);
    }

    void openPicker(ListSetting vlj2) {
        this.hnd = null;
        ItemPickerPopup ibf2 = new ItemPickerPopup(vlj2, 540.0f, 409.0f);
        this.hne = ibf2;
        this.focus(ibf2.search);
    }

    void openOverlay(Popup ijy2) {
        this.hnd = null;
        this.hne = ijy2;
        this.focus(ijy2.field());
    }

    private boolean hps() {
        return this.hne != null && !this.hne.closing();
    }

    irk binding() {
        return this.hnf;
    }

    void startBinding(irk irk2) {
        this.hnf = irk2;
        this.hnh = -1;
        this.focus(null);
        this.hng = (irk2.clearable() ? Lang.s("Press a key (Ctrl / Shift / Alt + key works) or mouse button for ", "Нажмите кнопку (можно Ctrl / Shift / Alt + кнопка) или кнопку мыши для ") : Lang.s("Press a key for ", "Нажмите кнопку для ")) + Lang.t(irk2.name()) + (irk2.clearable() ? Lang.s("  ·  Esc clears", "  ·  Esc — сбросить") : Lang.s("  ·  Esc cancels", "  ·  Esc — отмена"));
    }

    private void hpt(int n) {
        List list;
        this.hnf.set(n);
        List<Object> list2 = list = this.hnf.clearable() ? HotkeyStore.boundTo(n, this.hnf.name()) : List.of();
        if (!list.isEmpty()) {
            this.toast(UiKit.keyName(n) + Lang.s(" also runs ", " также запускает ") + String.join((CharSequence)", ", list), Icon.KEYBOARD, false);
        }
        this.hnf = null;
    }

    TextField focusedField() {
        return this.hof;
    }

    public boolean typing() {
        return this.hof != null || this.hnf != null;
    }

    void focus(TextField iah2) {
        this.hof = iah2;
        if (iah2 != null) {
            iah2.focusGained();
        }
    }

    void toast(String string, Icon vhz2, boolean bl) {
        this.hni = string;
        this.hnj = vhz2;
        this.hnk = bl;
        this.hnl = System.currentTimeMillis() + (bl ? 3200L : 2200L);
        this.hmo.set(1.0f);
    }

    void hint(String string) {
        this.hnn = string;
    }

    private void hpu(class_332 class_3322) {
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == this.hoo) {
            return;
        }
        this.hoo = FrameDelta.frame();
        this.hop = FrameDelta.delta() * (float)Theme.ANIMATION.get();
        this.hnm = this.hnn;
        this.hnn = null;
        Theme.update(this.hop);
        this.hmc.update(this.hop);
        this.hmd.update(this.hop);
        this.hme.update(this.hop);
        this.hmf.update(this.hop);
        if (this.hnd != null && this.hnd.gone()) {
            this.hnd = null;
        }
        if (this.hne != null && this.hne.gone()) {
            if (this.hof == this.hne.field()) {
                this.hof = null;
            }
            this.hne = null;
        }
        if (this.hmx && this.hmc.finished() && !this.hmy && this.field_22787 != null) {
            this.hmy = true;
            this.field_22787.method_63588(() -> ClickGuiScreen.super.method_25419());
        }
    }

    private float hpv() {
        float f = this.hmc.linear();
        return this.hmx ? Easing.outCubic(f) : Easing.outQuint(f);
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
        DrawUtil.beginFrame();
        this.hpu(class_3322);
        float f2 = this.hpv();
        float f3 = (float)Theme.DIM.get();
        if (this.field_22787 != null && this.field_22787.field_1687 != null) {
            this.hpw();
            float f4 = Math.max(1, this.field_22787.method_22683().method_4495());
            float f5 = this.hpi();
            this.how = WallpaperManager.frame(Math.round(540.0f * f5 * f4), Math.round(409.0f * f5 * f4));
            GpuTextureView gpuTextureView = null;
            if (this.how != null) {
                gpuTextureView = CompositePass.worldWith(this.how, this.hos * f4, this.hot * f4, (this.hos + 540.0f * this.hoq) * f4, (this.hot + 409.0f * this.hor) * f4, f2, Theme.photoTone());
            }
            LiquidGlass.capture(class_3322, Theme.BG_BLUR.getInt(), f2, gpuTextureView);
            DrawUtil.gradientV(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, 0.0f, ColorUtil.withAlpha(0, (int)(255.0f * f3 * 0.65f * f2)), ColorUtil.withAlpha(0, (int)(255.0f * f3 * f2)));
            HealthBars.renderInMenu(class_3322);
            Hud.renderInMenu(class_3322, this.hod.isEmpty() && this.hlz.get((int)ClickGuiScreen.hln).hkz == hks.HUD);
        } else {
            this.how = null;
            LiquidGlass.skip();
            this.method_57728(class_3322, f);
            if (Theme.BG_BLUR.getInt() > 0) {
                class_3322.method_71278();
            }
            DrawUtil.rect(class_3322, 0.0f, 0.0f, this.field_22789, this.field_22790, ColorUtil.withAlpha(0, (int)(255.0f * Math.max(0.3f, f3) * f2)));
        }
    }

    private void hpw() {
        float f = this.hpv();
        float f2 = this.hpi();
        this.hoq = f2 * (0.95f + 0.05f * f);
        this.hor = this.hoq * (0.93f + 0.07f * f);
        float f3 = hlp + 540.0f * f2 * 0.5f;
        float f4 = hlq + 409.0f * f2 * 0.5f + (1.0f - f) * 10.0f;
        this.hos = f3 - 270.0f * this.hoq;
        this.hot = f4 - 204.5f * this.hor;
        if (f >= 0.999f && f2 == 1.0f && this.field_22787 != null) {
            float f5 = Math.max(1, this.field_22787.method_22683().method_4495());
            this.hos = (float)Math.round(this.hos * f5) / f5;
            this.hot = (float)Math.round(this.hot * f5) / f5;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        this.hpu(class_3322);
        float f2 = this.hpv();
        float f3 = this.hpi();
        this.hpw();
        this.hou = this.hpx(n);
        this.hov = this.hpy(n2);
        FontFace.setRenderScale(f3);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(this.hos, this.hot);
        class_3322.method_51448().scale(this.hoq, this.hor);
        DrawUtil.pushAlpha(f2);
        try {
            this.hpz(class_3322);
        }
        finally {
            DrawUtil.popAlpha();
            class_3322.method_51448().popMatrix();
            FontFace.setRenderScale(1.0f);
        }
    }

    private float hpx(double d) {
        return (float)((d - (double)this.hos) / (double)this.hoq);
    }

    private float hpy(double d) {
        return (float)((d - (double)this.hot) / (double)this.hor);
    }

    private void hpz(class_332 class_3322) {
        boolean bl;
        float f = this.hne != null ? -10000.0f : this.hou;
        float f2 = this.hne != null ? -10000.0f : this.hov;
        float f3 = Theme.r(12.0f);
        float f4 = Theme.lightness();
        float f5 = 2.5f + 1.5f * this.hpv();
        DrawUtil.shadow(class_3322, 0.0f, 2.0f, 540.0f, 409.0f, f3, 4.0f, ColorUtil.withAlpha(0, Math.round(90.0f - 50.0f * f4)));
        DrawUtil.shadow(class_3322, 0.0f, 4.0f + 3.0f * f5, 540.0f, 409.0f, f3, 12.0f + 6.0f * f5, Theme.shadow);
        if (this.how != null) {
            DrawUtil.image(class_3322, this.how, 0.0f, 0.0f, 540.0f, 409.0f, f3, Theme.photoTone());
            DrawUtil.round(class_3322, 0.0f, 0.0f, 540.0f, 409.0f, f3, LiquidGlass.tint(Theme.window, Theme.photoDarken()));
            DrawUtil.round(class_3322, 0.0f, 0.0f, 136.0f, 409.0f, f3, 0.0f, 0.0f, f3, LiquidGlass.tint(Theme.window, 0.4f));
            bl = false;
        } else {
            bl = LiquidGlass.surface(class_3322, 0.0f, 0.0f, 540.0f, 409.0f, f3, LiquidGlass.tint(Theme.window, Theme.windowTint()), ColorUtil.withAlpha(Theme.window, 255), (float)LiquidGlass.EDGE.get(), LiquidGlass.WINDOW);
        }
        DrawUtil.round(class_3322, 0.0f, 0.0f, 136.0f, 409.0f, f3, 0.0f, 0.0f, f3, Theme.panel);
        DrawUtil.rect(class_3322, 136.0f, 0.0f, 1.0f, 409.0f, Theme.divider);
        GlassDraw.sheen(class_3322, 0.0f, 0.0f, 540.0f, 90.0f, f3, 0.8f * (1.0f - 0.7f * f4));
        if (!bl || !LiquidGlass.liquid()) {
            DrawUtil.outline(class_3322, 0.0f, 0.0f, 540.0f, 409.0f, f3, 1.0f, bl || this.how != null ? ColorUtil.withAlpha(0xFFFFFF, 24) : Theme.stroke);
        }
        GlassDraw.rim(class_3322, 0.0f, 0.0f, 540.0f, 409.0f, f3, f4, 1.1f);
        this.hqc(class_3322, f, f2);
        this.hqx(class_3322, f, f2);
        this.hrd(class_3322, f, f2);
        this.hrf(class_3322, f, f2);
        if (this.hnd != null) {
            this.hnd.render(class_3322, f, f2, this.hop);
        }
        this.hqr(class_3322, f, f2);
        this.hqq(class_3322);
        if (this.hne != null) {
            this.hne.render(class_3322, this, this.hou, this.hov, this.hop, 540.0f, 409.0f);
        }
        this.hrh(class_3322);
    }

    private float hqa(int n) {
        if (n < this.hma) {
            return 62.0f + (float)n * 25.0f;
        }
        return this.hqb() + (float)(n - this.hma) * 25.0f;
    }

    private float hqb() {
        return 62.0f + (float)this.hma * 25.0f + 20.0f;
    }

    private void hqc(class_332 class_3322, float f, float f2) {
        float f3 = 24.0f;
        float f4 = 19.0f;
        if (!AnimatedLogo.draw(class_3322, 13.0f, f3 - f4 * 0.5f, f4, Theme.isLight(), -1) && !LogoRenderer.draw(class_3322, 15.0f, f3 - 8.5f, 17.0f, Theme.logoTint())) {
            IconRenderer.draw(class_3322, Icon.LOGO, 23.0f, f3, 13.0f, Theme.accent());
        }
        UiKit.LOGO.draw(class_3322, UiKit.LOGO.ellipsize(EncodedString.get(), 94.0f), 35.0f, UiKit.LOGO.centerTop(f3), Theme.text);
        DrawUtil.rect(class_3322, 16.0f, this.hqb() - 11.0f, 104.0f, 1.0f, Theme.divider);
        boolean bl = !this.hod.isEmpty();
        float f5 = this.hmg.step(this.hqa(hln), this.hop);
        float f6 = 120.0f;
        float f7 = Theme.r(6.0f);
        DrawUtil.pushAlpha(bl ? 0.35f : 1.0f);
        float f8 = Theme.lightness();
        GlassDraw.shadow(class_3322, 8.0f, f5, f6, 23.0f, f7, 0.9f, f8);
        boolean bl2 = LiquidGlass.surface(class_3322, 8.0f, f5, f6, 23.0f, f7, LiquidGlass.tint(Theme.window, Math.min(0.92f, Theme.windowTint() * 0.85f)), ColorUtil.lerp(Theme.fieldHover, -1, 0.9f * f8), 11.5f, LiquidGlass.TABS);
        if (bl2) {
            int n = ColorUtil.withAlpha(ColorUtil.lerp(-1, Theme.accent(), 0.5f), 24);
            DrawUtil.round(class_3322, 8.0f, f5, f6, 23.0f, f7, ColorUtil.lerp(n, -2130706433, f8));
        }
        GlassDraw.sheen(class_3322, 8.0f, f5, f6, 23.0f, f7, 1.4f * (1.0f - 0.7f * f8));
        GlassDraw.rim(class_3322, 8.0f, f5, f6, 23.0f, f7, f8, 1.2f);
        DrawUtil.round(class_3322, 8.0f, f5 + 11.5f - 4.0f, 2.0f, 8.0f, 1.0f, Theme.accent());
        DrawUtil.popAlpha();
        float f9 = this.hmc.linear();
        for (int i = 0; i < this.hlz.size(); ++i) {
            int n;
            hkv hkv2 = this.hlz.get(i);
            float f10 = this.hqa(i);
            float f11 = Easing.outCubic((f9 * 1.5f - (float)i * 0.045f) / 0.55f);
            boolean bl3 = this.canHover() && UiKit.inside(f, f2, 8.0f, f10, f6, 23.0f);
            float f12 = this.hmh.get(i).step(bl3, this.hop);
            float f13 = i == hln && !bl ? 1.0f : 0.0f;
            DrawUtil.pushAlpha(f11);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(-(1.0f - f11) * 10.0f, 0.0f);
            if (f12 > 0.01f && f13 < 1.0f) {
                DrawUtil.round(class_3322, 8.0f, f10, f6, 23.0f, f7, ColorUtil.withAlpha(Theme.hover, Math.round((float)ColorUtil.alpha(Theme.hover) * f12)));
            }
            float f14 = f10 + 11.5f;
            float f15 = this.hmi.get(i).step(0.0f, this.hop);
            int n2 = ColorUtil.lerp(ColorUtil.lerp(Theme.textMuted, Theme.textDim, f12), Theme.text, f13);
            IconRenderer.draw(class_3322, hkv2.hkx, 25.0f + f12 * 0.5f, f14, 9.5f * (1.0f + 0.2f * f15), n2);
            UiKit.TAB.draw(class_3322, Lang.t(hkv2.hkw), 37.0f + f12 * 1.5f, UiKit.TAB.centerTop(f14), ColorUtil.lerp(Theme.textDim, Theme.text, Math.max(f13, f12)));
            int n3 = hkv2.hky != null ? ClickGuiScreen.hph(hkv2.hky) : (hkv2.hkz == hks.WAYPOINTS ? Waypoints.inWorld().size() : (hkv2.hkz == hks.FRIENDS ? Friends.all().size() : (hkv2.hkz == hks.HUD ? Hud.enabledCount() : 0)));
            if (n != this.hmk[i]) {
                this.hmk[i] = n;
                this.hmj.get(i).set(1.0f);
            }
            float f16 = this.hmj.get(i).step(0.0f, this.hop);
            if (n > 0) {
                String string = String.valueOf(n);
                float f17 = 1.0f + 0.25f * f16;
                class_3322.method_51448().pushMatrix();
                class_3322.method_51448().translate(116.0f, f14);
                class_3322.method_51448().scale(f17, f17);
                UiKit.SMALL.drawCentered(class_3322, string, 0.0f, UiKit.SMALL.centerTop(0.0f), ColorUtil.lerp(Theme.textMuted, Theme.text, Math.max(f16, f13 * 0.6f)));
                class_3322.method_51448().popMatrix();
            }
            class_3322.method_51448().popMatrix();
            DrawUtil.popAlpha();
        }
        this.hqm(class_3322, f, f2);
    }

    private float hqd() {
        return 365.0f;
    }

    private float hqe() {
        return 26.0f;
    }

    private float hqf() {
        return this.hqd() + 22.0f;
    }

    private float hqg() {
        return 12.0f;
    }

    private float hqh() {
        return (float)UserProfile.SLOTS.length * 24.0f + (float)(UserProfile.SLOTS.length - 1) * 7.0f + 16.0f;
    }

    private float hqi() {
        return this.hqd() - 24.0f - 20.0f;
    }

    private float hqj(int n) {
        return this.hqg() + 8.0f + (float)n * 31.0f;
    }

    private boolean hqk(float f, float f2) {
        return UiKit.inside(f, f2, this.hqe() - 9.0f - 3.0f, this.hqf() - 9.0f - 3.0f, 24.0f, 24.0f);
    }

    private boolean hql(float f, float f2) {
        return UiKit.inside(f, f2, this.hqg(), this.hqi(), this.hqh(), 40.0f);
    }

    private void hqm(class_332 class_3322, float f, float f2) {
        float f3 = this.hqd();
        DrawUtil.rect(class_3322, 14.0f, f3, 108.0f, 1.0f, Theme.divider);
        long l = LoaderInfo.uid();
        String string2 = "AstraDLC";
        String string3 = l > 0L ? "UID " + l : "Client";
        float f4 = this.hqe();
        float f5 = this.hqf();
        float f6 = this.hoh.get();
        float f7 = 18.0f + 1.5f * f6;
        float f8 = f7 * 0.5f;
        GlassDraw.shadow(class_3322, f4 - f7 * 0.5f, f5 - f7 * 0.5f, f7, f7, f8, 0.6f + 0.4f * f6, Theme.lightness());
        DrawUtil.round(class_3322, f4 - f7 * 0.5f, f5 - f7 * 0.5f, f7, f7, f8, Theme.field);
        UiKit.AVATAR.drawCentered(class_3322, "A", f4, UiKit.AVATAR.centerTop(f5), Theme.textDim);
        DrawUtil.circleOutline(class_3322, f4, f5, f7 * 0.5f, 1.0f, ColorUtil.lerp(0x34FFFFFF, Theme.accent(200), f6));
        float f9 = this.hqn() - 9.0f - 5.0f - 41.0f;
        UiKit.NAME.draw(class_3322, UiKit.NAME.ellipsize(string2, f9), 41.0f, UiKit.NAME.centerTop(f5 - 4.0f), Theme.text);
        UiKit.SUBTITLE.draw(class_3322, UiKit.SUBTITLE.ellipsize(string3, f9), 41.0f, UiKit.SUBTITLE.centerTop(f5 + 5.0f), Theme.textMuted);
        this.hqp(class_3322, f, f2);
    }

    private float hqn() {
        return 113.0f;
    }

    private boolean hqo(float f, float f2) {
        return UiKit.inside(f, f2, this.hqn() - 9.0f - 2.0f, this.hqf() - 9.0f - 2.0f, 22.0f, 22.0f);
    }

    private void hqp(class_332 class_3322, float f, float f2) {
        this.hon = this.canHover() && this.hqo(f, f2);
        float f3 = Easing.outCubic(this.hok.step(this.hon, this.hop));
        float f4 = this.hol.step(0.0f, this.hop);
        float f5 = Theme.lightness();
        float f6 = 18.0f * (1.0f - 0.06f * f4);
        float f7 = this.hqn() - f6 * 0.5f;
        float f8 = this.hqf() - f6 * 0.5f - 0.5f * f3;
        float f9 = Theme.r(6.0f);
        GlassDraw.shadow(class_3322, f7, f8, f6, f6, f9, 0.2f + 0.7f * f3, f5);
        DrawUtil.round(class_3322, f7, f8, f6, f6, f9, ColorUtil.lerp(Theme.field, -1750963, 0.14f * f3));
        DrawUtil.outline(class_3322, f7, f8, f6, f6, f9, 1.0f, ColorUtil.lerp(Theme.stroke, ColorUtil.withAlpha(-1750963, 150), f3));
        GlassDraw.rim(class_3322, f7, f8, f6, f6, f9, f5, 0.8f + 0.4f * f3);
        IconRenderer.draw(class_3322, Icon.POWER, f7 + f6 * 0.5f, f8 + f6 * 0.5f, 9.0f, ColorUtil.lerp(Theme.textDim, -1750963, f3));
    }

    private void hqq(class_332 class_3322) {
        float f = Easing.outCubic(this.hom.step(this.hon, this.hop));
        if (f <= 0.01f) {
            return;
        }
        String string = Lang.s("Panic", "Паник");
        String string2 = Lang.s("  ·  off until restart", "  ·  выключить до перезапуска");
        float f2 = UiKit.SUBTITLE.width(string);
        float f3 = f2 + UiKit.SUBTITLE.width(string2) + 14.0f + 9.0f;
        float f4 = UiKit.SUBTITLE.height() + 10.0f;
        float f5 = Math.max(6.0f, Math.min(534.0f - f3, this.hqn() - f3 * 0.5f));
        float f6 = this.hqf() - 9.0f - 6.0f - f4;
        float f7 = Theme.r(6.0f);
        float f8 = f6 + f4 * 0.5f;
        DrawUtil.pushAlpha(f);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(0.0f, (1.0f - f) * 3.0f);
        DrawUtil.shadow(class_3322, f5, f6 + 2.0f, f3, f4, f7, 12.0f, Theme.shadow);
        LiquidGlass.surface(class_3322, f5, f6, f3, f4, f7, LiquidGlass.tint(Theme.window, Math.min(1.0f, Theme.windowTint() + 0.08f)), ColorUtil.withAlpha(Theme.cardHover, 250), 6.0f, LiquidGlass.POPUPS);
        DrawUtil.outline(class_3322, f5, f6, f3, f4, f7, 1.0f, Theme.stroke);
        DrawUtil.circle(class_3322, f5 + 7.0f + 2.0f, f8, 2.0f, -1750963);
        UiKit.SUBTITLE.draw(class_3322, string, f5 + 7.0f + 9.0f, UiKit.SUBTITLE.centerTop(f8), Theme.text);
        UiKit.SUBTITLE.draw(class_3322, string2, f5 + 7.0f + 9.0f + f2, UiKit.SUBTITLE.centerTop(f8), Theme.textMuted);
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    private void hqr(class_332 class_3322, float f, float f2) {
        float f3;
        boolean bl = this.canHover() && (this.hqk(f, f2) || this.hoh.get() > 0.3f && this.hql(f, f2));
        long l = System.currentTimeMillis();
        if (bl) {
            this.hoj = l + 250L;
        }
        if ((f3 = Easing.outCubic(this.hoh.step(bl || l < this.hoj, this.hop))) <= 0.01f) {
            return;
        }
        float f4 = this.hqg();
        float f5 = this.hqi() + (1.0f - f3) * 6.0f;
        float f6 = this.hqh();
        float f7 = 40.0f;
        float f8 = Theme.r(8.0f);
        DrawUtil.pushAlpha(f3);
        DrawUtil.shadow(class_3322, f4, f5 + 2.0f, f6, f7, f8, 12.0f, Theme.shadow);
        DrawUtil.round(class_3322, f4, f5, f6, f7, f8, ColorUtil.withAlpha(Theme.cardHover, 250));
        DrawUtil.outline(class_3322, f4, f5, f6, f7, f8, 1.0f, Theme.stroke);
        String string = null;
        for (int i = 0; i < UserProfile.SLOTS.length; ++i) {
            String string2 = UserProfile.SLOTS[i];
            float f9 = this.hqj(i);
            float f10 = f5 + 8.0f;
            boolean bl2 = UiKit.inside(f, f2, f9 - 2.0f, f10 - 2.0f, 28.0f, 28.0f);
            float f11 = this.hoi[i].step(bl2, this.hop);
            float f12 = 24.0f * (1.0f + 0.08f * f11);
            float f13 = f9 + 12.0f;
            float f14 = f10 + 12.0f - f11;
            boolean bl3 = string2.equals(UserProfile.selected());
            if (bl3) {
                DrawUtil.circleOutline(class_3322, f13, f14, f12 * 0.5f + 2.2f, 1.4f, Theme.accent());
            }
            if ("own".equals(string2) && !UserProfile.ownReady()) {
                DrawUtil.circle(class_3322, f13, f14, f12 * 0.5f, ColorUtil.lerp(Theme.field, Theme.accent(60), f11));
                DrawUtil.circleOutline(class_3322, f13, f14, f12 * 0.5f, 1.0f, ColorUtil.lerp(Theme.stroke, Theme.accent(160), f11));
                IconRenderer.draw(class_3322, Icon.PLUS, f13, f14, 9.0f, ColorUtil.lerp(Theme.textDim, Theme.accent(), f11));
            } else if (!UserProfile.draw(class_3322, string2, f13 - f12 * 0.5f, f14 - f12 * 0.5f, f12, 25.920002f)) {
                DrawUtil.circle(class_3322, f13, f14, f12 * 0.5f, Theme.field);
            }
            if (!bl2) continue;
            string = UserProfile.label(string2);
        }
        DrawUtil.popAlpha();
        if (string != null) {
            this.hint(string);
        }
    }

    private float hqs() {
        return 480.0f;
    }

    private float hqt() {
        return this.hqs() - 8.0f - 136.0f;
    }

    private float hqu() {
        return 13.0f;
    }

    private float hqv() {
        return 13.0f;
    }

    private String hqw(hkv hkv2, float f, float f2) {
        if (this.hnm != null) {
            return this.hnm;
        }
        if (!this.hod.isEmpty()) {
            int n = this.hmb.size();
            return n + Lang.s(n == 1 ? " result" : " results", " " + ClickGuiScreen.plural(n, "результат", "результата", "результатов"));
        }
        return switch (hkv2.hkz.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1 -> Theme.shownName(Theme.presetName());
            case 2 -> Hud.enabledCount() + Lang.s(" on", " вкл");
            case 3 -> {
                if (ConfigManager.active() != null) {
                    yield ConfigManager.active();
                }
                yield Lang.s("No config yet", "Конфига пока нет");
            }
            case 4 -> {
                int var4_5 = Waypoints.inWorld().size();
                yield var4_5 + Lang.s(var4_5 == 1 ? " waypoint here" : " waypoints here", " " + ClickGuiScreen.plural(var4_5, "метка", "метки", "меток") + " здесь");
            }
            case 5 -> {
                int var4_6 = Friends.all().size();
                if (var4_6 == 0) {
                    yield Lang.s("None yet  ·  ", "Пока нет  ·  ") + UiKit.keyName(HotkeyStore.friendKey().key()) + Lang.s(" on a player", " по игроку");
                }
                yield var4_6 + Lang.s(var4_6 == 1 ? " friend" : " friends", " " + ClickGuiScreen.plural(var4_6, "друг", "друга", "друзей"));
            }
            case 6 -> {
                int var4_7 = Cosmetics.wornCount();
                if (var4_7 == 0) {
                    yield Lang.s("Nothing on yet", "Пока ничего не надето");
                }
                yield var4_7 + Lang.s(" worn", " " + ClickGuiScreen.plural(var4_7, "вещь надета", "вещи надеты", "вещей надето"));
            }
            case 0 -> {
                int var4_8 = 0;
                for (ModuleAccessGate var6_10 : this.hmb) {
                    if (var6_10.module == null || !var6_10.module.isEnabled()) continue;
                    ++var4_8;
                }
                yield var4_8 + Lang.s(" of ", " из ") + this.hmb.size() + Lang.s(" on", " вкл");
            }
        };
    }

    static String plural(int n, String string, String string2, String string3) {
        int n2 = n % 10;
        int n3 = n % 100;
        if (n2 == 1 && n3 != 11) {
            return string;
        }
        if (n2 >= 2 && n2 <= 4 && (n3 < 12 || n3 > 14)) {
            return string2;
        }
        return string3;
    }

    private void hqx(class_332 class_3322, float f, float f2) {
        float f3;
        float f4;
        float f5 = 152.0f;
        hkv hkv2 = this.hlz.get(hln);
        String string = Lang.t(this.hod.isEmpty() ? hkv2.hkw : "Search");
        if (!string.equals(this.hmt)) {
            this.hmu = this.hmt;
            this.hmt = string;
            this.hme.restart();
        }
        if ((f4 = Easing.outCubic(this.hme.linear())) < 1.0f && !this.hmu.isEmpty()) {
            DrawUtil.pushAlpha(1.0f - f4);
            UiKit.TITLE.draw(class_3322, this.hmu, f5, UiKit.TITLE.centerTop(18.0f) - 6.0f * f4, Theme.text);
            DrawUtil.popAlpha();
        }
        DrawUtil.pushAlpha(f4);
        UiKit.TITLE.draw(class_3322, this.hmt, f5, UiKit.TITLE.centerTop(18.0f) + 6.0f * (1.0f - f4), Theme.text);
        DrawUtil.popAlpha();
        float f6 = this.hqt() - f5 - 12.0f;
        String string2 = UiKit.SUBTITLE.ellipsize(this.hqw(hkv2, f, f2), f6);
        if (!string2.equals(this.hmv)) {
            this.hmw = this.hmv;
            this.hmv = string2;
            this.hmf.restart();
        }
        if ((f3 = Easing.outCubic(this.hmf.linear())) < 1.0f && !this.hmw.isEmpty()) {
            DrawUtil.pushAlpha(1.0f - f3);
            UiKit.SUBTITLE.draw(class_3322, this.hmw, f5, UiKit.SUBTITLE.centerTop(31.0f), Theme.textMuted);
            DrawUtil.popAlpha();
        }
        DrawUtil.pushAlpha(f3);
        UiKit.SUBTITLE.draw(class_3322, this.hmv, f5 + 3.0f * (1.0f - f3), UiKit.SUBTITLE.centerTop(31.0f), Theme.textMuted);
        DrawUtil.popAlpha();
        this.hoe.x = this.hqt();
        this.hoe.y = this.hqu();
        this.hoe.w = 136.0f;
        this.hoe.h = 20.0f;
        this.hoe.render(class_3322, this, f, f2, this.hop);
        if (this.hoe.text.isEmpty() && this.hof != this.hoe) {
            UiKit.SMALL.drawRight(class_3322, "Ctrl F", this.hqt() + 136.0f - 8.0f, UiKit.SMALL.centerTop(this.hqu() + 10.0f), ColorUtil.mulAlpha(Theme.textMuted, 0.8f));
        }
        float f7 = this.hqv();
        float f8 = Theme.lightness();
        float f9 = this.hog.step(this.canHover() && UiKit.inside(f, f2, this.hqs(), f7, 46.0f, 20.0f), this.hop);
        float f10 = Theme.r(6.0f);
        float f11 = this.hqs();
        float f12 = f7 - 0.5f * f9;
        GlassDraw.shadow(class_3322, f11, f12, 46.0f, 20.0f, f10, 0.2f + 0.7f * f9, f8);
        DrawUtil.round(class_3322, f11, f12, 46.0f, 20.0f, f10, ColorUtil.lerp(Theme.field, Theme.fieldHover, f9));
        DrawUtil.outline(class_3322, f11, f12, 46.0f, 20.0f, f10, 1.0f, ColorUtil.lerp(Theme.stroke, Theme.accent(150), f9));
        GlassDraw.rim(class_3322, f11, f12, 46.0f, 20.0f, f10, f8, 0.8f + 0.4f * f9);
        int n = ColorUtil.lerp(Theme.textDim, Theme.text, f9);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f11 + 11.0f, f12 + 10.0f);
        class_3322.method_51448().rotate(0.50265485f * f9);
        IconRenderer.draw(class_3322, Icon.GLOBE, 0.0f, 0.0f, 9.0f, n);
        class_3322.method_51448().popMatrix();
        UiKit.VALUE.draw(class_3322, Lang.ru() ? "RU" : "EN", f11 + 20.0f, UiKit.VALUE.centerTop(f12 + 10.0f), n);
        IconRenderer.draw(class_3322, Icon.CHEVRON_DOWN, f11 + 46.0f - 8.0f, f12 + 10.0f + 0.5f, 6.0f, ColorUtil.lerp(Theme.textMuted, Theme.accent(), f9));
        if (f9 > 0.5f) {
            this.hint(Lang.s("Language  ·  English", "Язык  ·  Русский"));
        }
        DrawUtil.rect(class_3322, 137.0f, 46.0f, 403.0f, 1.0f, Theme.divider);
    }

    private float hqy() {
        return 150.0f;
    }

    private float hqz() {
        return 56.0f;
    }

    private float hra() {
        return 399.0f;
    }

    private float hrb() {
        return 183.0f;
    }

    private ModuleAccessGate hrc(float f, float f2) {
        if (!this.canHover() || !UiKit.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            return null;
        }
        for (ModuleAccessGate hjg2 : this.hmb) {
            if (!hjg2.hovered(f, f2)) continue;
            return hjg2;
        }
        return null;
    }

    private void hrd(class_332 class_3322, float f, float f2) {
        float f3;
        float f4;
        int n;
        float f5;
        float f6 = this.hqz();
        float f7 = this.hra() - f6;
        float f8 = this.hrb();
        int n2 = this.hmb.size();
        float[] fArray = new float[n2];
        float[] fArray2 = new float[n2];
        float[] fArray3 = new float[]{0.0f, 0.0f};
        for (int i = 0; i < n2; ++i) {
            ModuleAccessGate hjg2 = this.hmb.get(i);
            f5 = hjg2.height();
            if (hjg2.wide && this.hod.isEmpty()) {
                float f9 = Math.max(fArray3[0], fArray3[1]);
                fArray[i] = this.hqy();
                fArray2[i] = f9;
                hjg2.w = f8 * 2.0f + 10.0f;
                fArray3[0] = fArray3[1] = f9 + f5 + 10.0f;
                continue;
            }
            fArray[i] = this.hqy() + (float)hjg2.column * (f8 + 10.0f);
            fArray2[i] = fArray3[hjg2.column];
            hjg2.w = f8;
            int n3 = hjg2.column;
            fArray3[n3] = fArray3[n3] + (f5 + 10.0f);
        }
        this.hmq = Math.max(fArray3[0], fArray3[1]) - 10.0f;
        float f10 = Math.max(0.0f, this.hmq - f7);
        this.hmp = Math.max(0.0f, Math.min(f10, this.hmp));
        float f11 = this.hml.step(this.hmp, this.hop);
        DrawUtil.pushScissor(class_3322, 137.0f, 47.0f, 402.0f, 361.0f);
        if (this.hmb.isEmpty()) {
            this.hre(class_3322);
        }
        f5 = this.hmd.linear();
        boolean bl = UiKit.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f);
        float f12 = bl ? f : -1000.0f;
        float f13 = bl ? f2 : -1000.0f;
        int n4 = 0;
        for (n = 0; n < n2; ++n) {
            ModuleAccessGate hjg3 = this.hmb.get(n);
            hjg3.x = fArray[n];
            hjg3.y = f6 + fArray2[n] - f11;
            f4 = hjg3.height();
            if (hjg3.y > 409.0f || hjg3.y + f4 < 46.0f) continue;
            if ((f3 = Easing.outCubic((f5 * 1.9f - (float)Math.min(n4++, 9) * 0.12f) / 0.8f)) <= 0.01f) continue;
            DrawUtil.pushAlpha(f3);
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate((1.0f - f3) * 16.0f * (float)this.hms, (1.0f - f3) * 10.0f);
            hjg3.render(class_3322, this, f12, f13, this.hop);
            class_3322.method_51448().popMatrix();
            DrawUtil.popAlpha();
        }
        n = System.nanoTime() - this.hmr < 900000000L ? 1 : 0;
        float f14 = this.hmm.step(f10 > 0.0f && (n != 0 || UiKit.inside(f, f2, 528.0f, f6, 12.0f, f7)), this.hop);
        if (f10 > 0.0f) {
            f4 = Math.max(18.0f, f7 * f7 / this.hmq);
            f3 = f6 + (f7 - f4) * (f11 / f10);
            float f15 = 2.5f + 1.5f * f14;
            DrawUtil.round(class_3322, 536.0f - f15, f3, f15, f4, f15 * 0.5f, ColorUtil.mulAlpha(Theme.textMuted, 0.35f + 0.5f * f14));
        }
        DrawUtil.popScissor(class_3322);
    }

    private void hre(class_332 class_3322) {
        float f = 338.0f;
        float f2 = 217.5f;
        float f3 = Easing.outCubic(this.hmd.linear() * 1.5f);
        float f4 = (float)Math.sin((double)System.nanoTime() / 5.0E8) * 1.5f;
        DrawUtil.pushAlpha(f3);
        DrawUtil.circle(class_3322, f, f2 - 6.0f + f4, 22.0f * (0.8f + 0.2f * f3), Theme.hover);
        Icon vhz2 = this.hod.isEmpty() ? this.hlz.get((int)ClickGuiScreen.hln).hkx : Icon.SEARCH;
        IconRenderer.draw(class_3322, vhz2, f, f2 - 6.0f + f4, 20.0f, Theme.textMuted);
        String string = this.hod.isEmpty() ? Lang.s("Nothing here yet", "Пока пусто") : Lang.s("Nothing found", "Ничего не найдено");
        String string2 = this.hod.isEmpty() ? Lang.s("Modules for this category are on the way", "Модули этой категории скоро появятся") : Lang.s("Try another name or setting", "Попробуйте другое название или настройку");
        UiKit.CARD_TITLE.drawCentered(class_3322, string, f, UiKit.CARD_TITLE.centerTop(f2 + 28.0f), Theme.textDim);
        UiKit.SUBTITLE.drawCentered(class_3322, string2, f, UiKit.SUBTITLE.centerTop(f2 + 40.0f), Theme.textMuted);
        DrawUtil.popAlpha();
    }

    private void hrf(class_332 class_3322, float f, float f2) {
        boolean bl;
        ModuleAccessGate hjg2 = null;
        if (this.canHover() && this.hne == null && UiKit.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            for (ModuleAccessGate hjg3 : this.hmb) {
                if (!hjg3.headerHovered(f, f2)) continue;
                hjg2 = hjg3;
                break;
            }
        }
        long l = System.currentTimeMillis();
        if (hjg2 != this.hns) {
            this.hns = hjg2;
            this.hnt = l;
        }
        if (hjg2 != this.hnv) {
            this.hnv = null;
        }
        boolean bl2 = bl = hjg2 != null && hjg2 != this.hnv && l - this.hnt >= 350L;
        if (bl && hjg2 != this.hnu) {
            this.hnu = hjg2;
            this.hnr.set(0.0f);
        }
        float f3 = Easing.outCubic(this.hnr.step(bl && hjg2 == this.hnu, this.hop));
        if (this.hnu == null || f3 <= 0.01f || !this.hmb.contains(this.hnu)) {
            return;
        }
        if (this.hnu != this.hnx || Lang.get() != this.hny) {
            this.hnx = this.hnu;
            this.hny = Lang.get();
            this.hnw = ClickGuiScreen.hrg(this.hnu.description(), 220.0f);
            this.hnz = 0.0f;
            for (String string : this.hnw) {
                this.hnz = Math.max(this.hnz, UiKit.SUBTITLE.width(string));
            }
        }
        if (this.hnw.isEmpty()) {
            return;
        }
        float f4 = UiKit.SUBTITLE.height() + 1.5f;
        float f5 = 5.0f;
        float f6 = this.hnz + 14.0f;
        float f7 = (float)this.hnw.size() * f4 + f5 * 2.0f;
        float f8 = Math.max(142.0f, Math.min(534.0f - f6, this.hnu.x + 8.0f));
        float f9 = this.hnu.headBottom() - 2.0f;
        if (f9 + f7 > 403.0f) {
            f9 = this.hnu.y - f7 - 3.0f;
        }
        f9 = Math.max(50.0f, Math.min(403.0f - f7, f9));
        float f10 = Theme.r(6.0f);
        DrawUtil.pushAlpha(f3);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(0.0f, (1.0f - f3) * -3.0f);
        DrawUtil.shadow(class_3322, f8, f9 + 2.0f, f6, f7, f10, 12.0f, Theme.shadow);
        LiquidGlass.surface(class_3322, f8, f9, f6, f7, f10, LiquidGlass.tint(Theme.window, Math.min(1.0f, Theme.windowTint() + 0.08f)), ColorUtil.withAlpha(Theme.cardHover, 250), 6.0f, LiquidGlass.POPUPS);
        DrawUtil.outline(class_3322, f8, f9, f6, f7, f10, 1.0f, Theme.stroke);
        int n = ColorUtil.lerp(Theme.textDim, Theme.text, 0.6f);
        for (int i = 0; i < this.hnw.size(); ++i) {
            float f11 = f9 + f5 + f4 * ((float)i + 0.5f);
            UiKit.SUBTITLE.draw(class_3322, this.hnw.get(i), f8 + 7.0f, UiKit.SUBTITLE.centerTop(f11), n);
        }
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    private static List<String> hrg(String string, float f) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string == null || string.isBlank()) {
            return arrayList;
        }
        for (String string2 : string.split("\n")) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string3 : string2.trim().split("\\s+")) {
                if (string3.isEmpty()) continue;
                if (!stringBuilder.isEmpty()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    if (UiKit.SUBTITLE.width(stringBuilder2.append((Object)stringBuilder).append(" ").append(string3).toString()) > f) {
                        arrayList.add(UiKit.SUBTITLE.ellipsize(stringBuilder.toString(), f));
                        stringBuilder.setLength(0);
                    }
                }
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(string3);
            }
            if (stringBuilder.isEmpty()) continue;
            arrayList.add(UiKit.SUBTITLE.ellipsize(stringBuilder.toString(), f));
        }
        return arrayList;
    }

    private void hrh(class_332 class_3322) {
        boolean bl = this.hnf != null || System.currentTimeMillis() < this.hnl;
        float f = Easing.outCubic(this.hmn.step(bl, this.hop));
        if (f <= 0.01f) {
            return;
        }
        String string = this.hnf != null ? this.hng : this.hni;
        Icon vhz2 = this.hnf != null ? Icon.KEYBOARD : this.hnj;
        boolean bl2 = this.hnf == null && this.hnk;
        int n = bl2 ? -1750963 : Theme.accent();
        float f2 = Math.min(374.0f, UiKit.LABEL.width(string) + 34.0f);
        float f3 = 21.0f;
        float f4 = 136.0f + (404.0f - f2) * 0.5f;
        float f5 = 393.0f - f3 + (1.0f - f) * 10.0f;
        float f6 = Theme.r(7.0f);
        float f7 = 1.0f + 0.05f * this.hmo.step(0.0f, this.hop);
        DrawUtil.pushAlpha(f);
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f4 + f2 * 0.5f, f5 + f3 * 0.5f);
        class_3322.method_51448().scale(f7, f7);
        class_3322.method_51448().translate(-f2 * 0.5f, -f3 * 0.5f);
        DrawUtil.shadow(class_3322, 0.0f, 0.0f, f2, f3, f6, 12.0f, Theme.shadow);
        LiquidGlass.surface(class_3322, 0.0f, 0.0f, f2, f3, f6, LiquidGlass.tint(Theme.window, Math.min(1.0f, Theme.windowTint() + 0.1f)), ColorUtil.withAlpha(Theme.cardHover, 250), f3 * 0.5f, LiquidGlass.POPUPS);
        DrawUtil.outline(class_3322, 0.0f, 0.0f, f2, f3, f6, 1.0f, ColorUtil.withAlpha(n, 130));
        IconRenderer.draw(class_3322, vhz2, 14.0f, f3 * 0.5f, 9.0f, n);
        UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(string, f2 - 32.0f), 24.0f, UiKit.LABEL.centerTop(f3 * 0.5f), Theme.text);
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        if (this.hmx) {
            return true;
        }
        float f = this.hpx(class_119092.comp_4798());
        float f2 = this.hpy(class_119092.comp_4799());
        int n = class_119092.method_74245();
        this.hnv = this.hns;
        if (this.hnf != null) {
            if (n >= 2 && this.hnf.clearable()) {
                this.hpt(KeyUtil.mouse(n));
            } else {
                this.hnf = null;
            }
            return true;
        }
        if (this.hne != null) {
            if (this.hps()) {
                this.hne.mouseClicked(this, f, f2, n);
            }
            return true;
        }
        if (this.hpr()) {
            if (!this.hnd.mouseClicked(f, f2)) {
                this.hnd.close();
            }
            return true;
        }
        this.hof = null;
        if (!UiKit.inside(f, f2, 0.0f, 0.0f, 540.0f, 409.0f)) {
            return true;
        }
        if (this.hoh.get() > 0.5f && this.hql(f, f2)) {
            for (int i = 0; i < UserProfile.SLOTS.length; ++i) {
                String string = UserProfile.SLOTS[i];
                if (n != 0 || !UiKit.inside(f, f2, this.hqj(i) - 2.0f, this.hqi() + 6.0f, 28.0f, 28.0f)) continue;
                if ("own".equals(string) && !UserProfile.ownReady()) {
                    AvatarCloud.refresh();
                    continue;
                }
                UserProfile.select(string);
                GuiConfig.saveLater();
            }
            return true;
        }
        if (this.hoe.mouseClicked(this, f, f2, n)) {
            return true;
        }
        if (n == 0 && this.hqo(f, f2)) {
            this.hol.set(1.0f);
            PanicShutdown.trigger();
            if (this.field_22787 != null) {
                this.field_22787.method_1507(null);
            }
            return true;
        }
        if (n == 0 && UiKit.inside(f, f2, this.hqs(), this.hqv(), 46.0f, 20.0f)) {
            if (this.field_22787 != null) {
                this.field_22787.method_1507((class_437)new LanguageScreen(this));
            }
            return true;
        }
        for (int i = 0; i < this.hlz.size(); ++i) {
            if (!UiKit.inside(f, f2, 8.0f, this.hqa(i), 120.0f, 23.0f)) continue;
            this.hrj(i);
            return true;
        }
        if (n == 0 && (f2 < 46.0f || f < 136.0f && f2 < 46.0f)) {
            this.hmz = true;
            this.hna = (float)class_119092.comp_4798() - hlp;
            this.hnb = (float)class_119092.comp_4799() - hlq;
            return true;
        }
        if (UiKit.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            for (ModuleAccessGate hjg2 : this.hmb) {
                if (!hjg2.mouseClicked(this, f, f2, n)) continue;
                return true;
            }
        }
        return true;
    }

    public boolean method_25406(class_11909 class_119092) {
        this.hmz = false;
        this.hnc = null;
        return true;
    }

    public boolean method_25403(class_11909 class_119092, double d, double d2) {
        if (this.hmz) {
            hlp = (float)class_119092.comp_4798() - this.hna;
            hlq = (float)class_119092.comp_4799() - this.hnb;
            this.hpj();
            return true;
        }
        if (this.hnc != null) {
            this.hnc.mouseDragged(this.hpx(class_119092.comp_4798()), this.hpy(class_119092.comp_4799()));
            return true;
        }
        return true;
    }

    public boolean method_25401(double d, double d2, double d3, double d4) {
        float f = this.hpx(d);
        float f2 = this.hpy(d2);
        if (this.hne != null) {
            this.hne.scrolled(d4);
            return true;
        }
        if (this.hpr()) {
            return true;
        }
        if (UiKit.inside(f, f2, 136.0f, 46.0f, 404.0f, 363.0f)) {
            this.hmp -= (float)d4 * 32.0f;
            this.hmr = System.nanoTime();
        }
        return true;
    }

    public boolean method_16803(class_11908 class_119082) {
        if (this.hnf != null && this.hnh != -1 && class_119082.comp_4795() == this.hnh) {
            this.hnh = -1;
            this.hpt(class_119082.comp_4795());
            return true;
        }
        return super.method_16803(class_119082);
    }

    public boolean method_25404(class_11908 class_119082) {
        boolean bl;
        int n = class_119082.comp_4795();
        if (this.hmx) {
            return true;
        }
        if (this.hnf != null) {
            boolean bl2;
            boolean bl3 = bl2 = n == 256 || n == 261 || n == 259;
            if (!bl2) {
                if (this.hnf.clearable() && KeyUtil.isModifier(n)) {
                    this.hnh = n;
                } else {
                    this.hpt(this.hnf.clearable() ? KeyUtil.combo(n, class_119082.comp_4797() | KeyUtil.heldMods(this.field_22787)) : n);
                }
                return true;
            }
            if (this.hnf.clearable()) {
                this.hnf.set(-1);
            }
            this.hnf = null;
            return true;
        }
        if (this.hpr() && n == 256) {
            this.hnd.close();
            return true;
        }
        if (this.hne != null) {
            if (this.hps()) {
                this.hne.keyPressed(this, n, class_119082.comp_4797());
            }
            return true;
        }
        if (this.hof != null) {
            if (this.hof == this.hoe && n == 256 && !this.hoe.text.isEmpty()) {
                this.hoe.setText("");
                return true;
            }
            this.hof.keyPressed(this, n, class_119082.comp_4797());
            return true;
        }
        boolean bl4 = bl = (class_119082.comp_4797() & 2) != 0;
        if (bl && n == 70) {
            this.focus(this.hoe);
            return true;
        }
        if (n == 256 || n == Flow.getInstance().getOpenGuiKey()) {
            this.method_25419();
            return true;
        }
        if (n == 265 || n == 264) {
            int n2 = hln + (n == 265 ? -1 : 1);
            this.hrj((n2 + this.hlz.size()) % this.hlz.size());
            return true;
        }
        return true;
    }

    public boolean method_25400(class_11905 class_119052) {
        if (this.hmx || this.hnf != null || this.hof == null || !class_119052.method_74227()) {
            return false;
        }
        this.hof.charTyped(class_119052.method_74226());
        return true;
    }

    private void hri(String string) {
        if (string.equals(this.hod)) {
            return;
        }
        boolean bl = this.hod.isEmpty();
        if (bl && !string.isEmpty()) {
            this.hpp();
        }
        this.hod = string;
        hoa = string;
        this.hpm(true);
        if (string.isEmpty() && !bl) {
            this.hpq();
        }
    }

    private void hrj(int n) {
        this.hnd = null;
        this.hne = null;
        if (!this.hod.isEmpty()) {
            this.hoe.setText("");
            this.focus(null);
        }
        if (n == hln && this.hmd.linear() > 0.0f) {
            this.hpm(false);
            return;
        }
        this.hpp();
        this.hms = Integer.signum(n - hln);
        hln = n;
        hlo = this.hlz.get((int)n).hkw;
        this.hmi.get(n).set(1.0f);
        this.hpm(true);
        this.hmd.restart();
        this.hpq();
    }

    public void method_25419() {
        if (!this.hmx) {
            this.hmx = true;
            SoundsModule.menu(false);
            this.hpp();
            this.hmc.backward();
            this.hof = null;
            this.hnd = null;
            this.hne = null;
            this.hnc = null;
            this.hmz = false;
        }
    }

    public void method_25432() {
        FontFace.setRenderScale(1.0f);
        this.hpp();
        ConfigManager.autoSaveLater();
        GuiConfig.saveLater();
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25422() {
        return false;
    }

    static {
        hlp = Float.NaN;
        hlq = Float.NaN;
        hlr = new HashMap<String, Float>();
        hls = new IdentityHashMap<Module, ModuleAccessGate>();
        hoa = "";
        hob = new HashSet<ModuleAccessGate>();
    }

    private static /* synthetic */ int abu(int n, int n2) {
        return n - n2 | 0xAE511500;
    }

    private static /* synthetic */ int abv(int n, int n2) {
        return ClickGuiScreen.abu(n, n2) ^ 0x73BB0CAB;
    }

    private static /* synthetic */ int abw(int n, int n2) {
        return ClickGuiScreen.abu(n, n2) * n2;
    }
}

