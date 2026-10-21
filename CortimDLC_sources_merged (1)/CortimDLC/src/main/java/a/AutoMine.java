/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ProfilePopup;
import a.ModuleCategory;
import a.Module;
import a.lex;
import a.AncientFarmer;
import a.AutoMines;
import a.AimModel;
import a.StudioProfiles;
import a.MineModelReader;
import a.WalkModelReader;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.KeySetting;
import a.TextSetting;
import flow.Flow;
import flow.config.ConfigManager;
import flow.dev.StringDecryptor;

public class AutoMine
extends Module {
    private static AutoMine lfb;
    private static StudioProfiles lfc;
    private static String lfd;
    private final ButtonSetting lfe = this.add(new ButtonSetting("Studio", new vkq("Open studio", Icon.LAYERS, ProfilePopup::open)));
    private final TextSetting lff = this.add(new TextSetting("Profile", "", 32));
    private final BoolSetting lfg = this.add(new BoolSetting("AutoMine", true));
    private final BoolSetting lfh = this.add(new BoolSetting("AutoEnd", true));
    private final BoolSetting lfi = this.add(new BoolSetting("AutoWarden", true));
    private final KeySetting lfj = this.add(new KeySetting("Stop stands", 269));
    private final TextSetting lfk = this.add(new TextSetting("Mine profile", "", 32));
    private final TextSetting lfl = this.add(new TextSetting("Walk profile", "", 32));
    private static StudioProfiles lfm;
    private static String lfn;
    private static StudioProfiles lfo;
    private static String lfp;
    private static /* synthetic */ int lfq;
    private static /* synthetic */ int lfr;

    public AutoMine() {
        super("NeuroRotation", "Your own trained rotation for AutoMine, AutoEnd and AutoWarden", ModuleCategory.COMBAT);
        lfb = this;
        this.lff.visibleWhen(() -> false);
        this.lfk.visibleWhen(() -> false);
        this.lfl.visibleWhen(() -> false);
    }

    public static StudioProfiles walkProfile() {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return null;
        }
        String string = lfa2.lfl.get();
        if (string == null || string.isBlank()) {
            lfo = null;
            lfp = "";
            return null;
        }
        if (lfo == null || !string.equals(lfp)) {
            lfp = string;
            lfo = StudioProfiles.open(string);
        }
        return lfo;
    }

    public static void activateWalk(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa2.lfl.set(tiq2 == null ? "" : tiq2.name);
        lfo = tiq2;
        lfp = tiq2 == null ? "" : tiq2.name;
        ConfigManager.autoSaveLater();
    }

    public static void useForWalk(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        AutoMine.activateWalk(tiq2);
        lfa2.lfh.set(true);
        lfa2.lfi.set(true);
        if (!lfa2.isEnabled()) {
            lfa2.setEnabled(true);
        }
    }

    public static boolean walksWith(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        return lfa2 != null && tiq2 != null && (lfa2.lfh.get() || lfa2.lfi.get()) && AutoMine.walkProfile() == tiq2;
    }

    public static WalkModelReader walkModel(lex lex2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null || !lfa2.lft(lex2)) {
            return null;
        }
        StudioProfiles tiq2 = AutoMine.walkProfile();
        return tiq2 == null || !tiq2.walk() ? null : tiq2.walkModel();
    }

    public static StudioProfiles mineProfile() {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return null;
        }
        String string = lfa2.lfk.get();
        if (string == null || string.isBlank()) {
            lfm = null;
            lfn = "";
            return null;
        }
        if (lfm == null || !string.equals(lfn)) {
            lfn = string;
            lfm = StudioProfiles.open(string);
        }
        return lfm;
    }

    public static void activateMine(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa2.lfk.set(tiq2 == null ? "" : tiq2.name);
        lfm = tiq2;
        lfn = tiq2 == null ? "" : tiq2.name;
        ConfigManager.autoSaveLater();
    }

    public static void useForMine(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        AutoMine.activateMine(tiq2);
        lfa2.lfg.set(true);
        if (!lfa2.isEnabled()) {
            lfa2.setEnabled(true);
        }
    }

    public static boolean minesWith(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        return lfa2 != null && tiq2 != null && lfa2.lfg.get() && AutoMine.mineProfile() == tiq2;
    }

    public static double mineBoost() {
        StudioProfiles tiq2 = AutoMine.mineProfile();
        return tiq2 == null ? 0.0 : (double)tiq2.mineBoost() / 100.0;
    }

    public static MineModelReader mineModel() {
        AutoMine lfa2 = lfb;
        if (lfa2 == null || !lfa2.lfg.get()) {
            return null;
        }
        StudioProfiles tiq2 = AutoMine.mineProfile();
        return tiq2 == null || !tiq2.mine() ? null : tiq2.mineModel();
    }

    @Override
    public boolean isHidden() {
        return true;
    }

    public static AutoMine get() {
        return lfb;
    }

    public static StudioProfiles activeProfile() {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return null;
        }
        String string = lfa2.lff.get();
        if (string == null || string.isBlank()) {
            lfc = null;
            lfd = "";
            return null;
        }
        if (lfc == null || !string.equals(lfd)) {
            lfd = string;
            lfc = StudioProfiles.open(string);
        }
        return lfc;
    }

    public static void activate(StudioProfiles tiq2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null) {
            return;
        }
        lfa2.lff.set(tiq2 == null ? "" : tiq2.name);
        lfc = tiq2;
        lfd = tiq2 == null ? "" : tiq2.name;
        ConfigManager.autoSaveLater();
    }

    public static int stopKey() {
        AutoMine lfa2 = lfb;
        return lfa2 == null ? 269 : lfa2.lfj.get();
    }

    public static AimModel model(lex lex2) {
        AutoMine lfa2 = lfb;
        if (lfa2 == null || !lfa2.lft(lex2)) {
            return null;
        }
        StudioProfiles tiq2 = AutoMine.activeProfile();
        return tiq2 == null || tiq2.aura() || tiq2.mine() || tiq2.walk() ? null : tiq2.model();
    }

    public static AimModel modelOr1(lex lex2) {
        AimModel tck2 = AutoMine.model(lex2);
        return tck2 != null ? tck2 : AimModel.profile1();
    }

    public static boolean turning() {
        return AutoMine.lfs("AimAssist") || AutoMine.lfs("AutoMine") || AutoMine.lfs("AutoEnd") || AutoMine.lfs("AutoWarden") || AutoMines.busy() || AncientFarmer.busy();
    }

    private static boolean lfs(String string) {
        Flow flow = Flow.getInstance();
        Module kfe2 = flow.getModuleManager() == null ? null : flow.getModuleManager().getByName(string);
        return kfe2 != null && kfe2.isEnabled();
    }

    private boolean lft(lex lex2) {
        return switch (lex2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> this.lfg.get();
            case 1 -> this.lfh.get();
            case 2 -> this.lfi.get();
        };
    }

    static {
        lfd = "";
        lfn = "";
        lfp = "";
    }

    private static /* synthetic */ int awf(int n, int n2) {
        return n - n2 + 2045997961;
    }

    private static /* synthetic */ int awg(int n, int n2) {
        return AutoMine.awf(n, n2) ^ 0x8311F5B5;
    }

    private static /* synthetic */ int awh(int n, int n2) {
        return AutoMine.awf(n, n2) + n;
    }
}

