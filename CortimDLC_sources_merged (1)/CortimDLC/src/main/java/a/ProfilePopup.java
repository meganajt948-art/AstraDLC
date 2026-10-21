/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package a;

import a.eyg;
import a.CloudConfigs;
import a.ClickGuiScreen;
import a.TextField;
import a.StudioStatusLine;
import a.ige;
import a.Popup;
import a.Theme;
import a.UiKit;
import a.Module;
import a.Aura;
import a.AutoMine;
import a.AutoEnd;
import a.AutoMines;
import a.AutoWarden;
import a.AimModel;
import a.tct;
import a.tcw;
import a.RecorderHooks;
import a.tik;
import a.StudioProfiles;
import a.TurnRateLimiter;
import a.MineModelReader;
import a.MineRecorder;
import a.MineStyleStats;
import a.WalkSpeedModel;
import a.txp;
import a.WalkModelReader;
import a.WardenRecorder;
import a.ColorUtil;
import a.GlassDraw;
import a.DrawUtil;
import a.Spring;
import a.Easing;
import a.Icon;
import a.IconRenderer;
import a.Lang;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class ProfilePopup
extends Popup {
    private static final float igo = 510.0f;
    private static final float igp = 360.0f;
    private static final float igq = 12.0f;
    private static final float igr = 30.0f;
    private static final float igs = 16.0f;
    private static final float igt = 146.0f;
    private static final float igu = 30.0f;
    private static final float igv = 16.0f;
    private static final float igw = 10.0f;
    private final TextField igx = new TextField("New profile", Icon.PLUS, 24, TextField.ANY);
    private final float igy;
    private final float igz;
    private final Spring iha = new Spring(16.0f);
    private final Spring ihb = new Spring(18.0f);
    private final List<ige> ihc = new ArrayList<ige>();
    private List<StudioProfiles> ihd = new ArrayList<StudioProfiles>();
    private StudioProfiles ihe;
    private float ihf;
    private boolean ihg;
    private float ihh;
    private float ihi;
    private float ihj;
    private float ihk;
    private String ihl;
    private long ihm;
    private boolean ihn;
    private String iho;
    private StudioProfiles ihp;
    private long ihq;
    private long ihr;
    private tct ihs;
    private ClickGuiScreen iht;
    private static /* synthetic */ String ihu;
    private static /* synthetic */ int ihv;

    private ProfilePopup(float f, float f2) {
        this.igy = (f - 510.0f) * 0.5f;
        this.igz = (f2 - 360.0f) * 0.5f;
        this.igx.onSubmit = this::iia;
        this.ihy();
        StudioProfiles tiq2 = AutoMine.activeProfile();
        this.ihe = tiq2 != null ? this.ihz(tiq2.name) : (this.ihd.isEmpty() ? null : this.ihd.get(this.ihd.size() - 1));
        this.ihs = RecorderHooks.job();
        if (this.ihe != null) {
            this.ihe.prefetch();
        }
    }

    public static void open() {
        class_437 class_4372 = class_310.method_1551().field_1755;
        if (class_4372 instanceof ClickGuiScreen) {
            ClickGuiScreen hlc2 = (ClickGuiScreen)class_4372;
            hlc2.openOverlay(new ProfilePopup(540.0f, 409.0f));
        }
    }

    public static void openMine() {
        Object object = class_310.method_1551().field_1755;
        if (object instanceof ClickGuiScreen) {
            ClickGuiScreen hlc2 = (ClickGuiScreen)((Object)object);
            object = new ProfilePopup(540.0f, 409.0f);
            ((ProfilePopup)object).ihx();
            hlc2.openOverlay((Popup)object);
        }
    }

    public static void openWalk(String string) {
        Object object = class_310.method_1551().field_1755;
        if (object instanceof ClickGuiScreen) {
            ClickGuiScreen hlc2 = (ClickGuiScreen)((Object)object);
            object = new ProfilePopup(540.0f, 409.0f);
            ((ProfilePopup)object).ihw(string);
            hlc2.openOverlay((Popup)object);
        }
    }

    private void ihw(String string) {
        StudioProfiles tiq2 = AutoMine.walkProfile();
        if (tiq2 == null) {
            for (StudioProfiles tiq3 : this.ihd) {
                if (!tiq3.walk()) continue;
                tiq2 = tiq3;
            }
        }
        for (int i = 1; tiq2 == null && i <= 9; ++i) {
            try {
                tiq2 = StudioProfiles.create(Lang.s("Walking", "Ходьба") + (i == 1 ? "" : " " + i));
                tiq2.set("purpose", "Walk");
                tiq2.save();
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        if (tiq2 != null && string != null) {
            tiq2.set("walk.with", string);
            tiq2.save();
        }
        this.ihy();
        if (tiq2 != null) {
            this.ihe = this.ihz(tiq2.name);
            if (this.ihe != null) {
                this.ihe.prefetch();
            }
        }
    }

    private void ihx() {
        StudioProfiles tiq2 = AutoMine.mineProfile();
        if (tiq2 == null) {
            for (StudioProfiles tiq3 : this.ihd) {
                if (!tiq3.mine()) continue;
                tiq2 = tiq3;
            }
        }
        for (int i = 1; tiq2 == null && i <= 9; ++i) {
            try {
                tiq2 = StudioProfiles.create(Lang.s("Mine", "Шахта") + (i == 1 ? "" : " " + i));
                tiq2.set("purpose", "Mine");
                tiq2.save();
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.ihy();
        if (tiq2 != null) {
            this.ihe = this.ihz(tiq2.name);
            if (this.ihe != null) {
                this.ihe.prefetch();
            }
        }
    }

    private void ihy() {
        this.ihd = StudioProfiles.list();
        if (this.ihe != null) {
            this.ihe = this.ihz(this.ihe.name);
        }
    }

    private StudioProfiles ihz(String string) {
        for (StudioProfiles tiq2 : this.ihd) {
            if (!tiq2.name.equals(string)) continue;
            return tiq2;
        }
        return null;
    }

    private void iia() {
        String string = this.igx.text;
        if (StudioProfiles.clean(string).isEmpty()) {
            string = Lang.s("Profile ", "Профиль ") + (this.ihd.size() + 1);
        }
        try {
            StudioProfiles tiq2 = StudioProfiles.create(string);
            this.igx.setText("");
            this.ihy();
            this.ihe = this.ihz(tiq2.name);
            if (AutoMine.activeProfile() == null) {
                AutoMine.activate(this.ihe);
            }
            this.iib(Lang.s("Profile created", "Профиль создан"), Icon.CHECK, false);
        }
        catch (IOException iOException) {
            this.igx.error();
            this.iib("exists".equals(iOException.getMessage()) ? Lang.s("That name is taken", "Такое имя уже есть") : Lang.s("Can't create it", "Не получилось создать"), Icon.CLOSE, true);
        }
    }

    private void iib(String string, Icon vhz2, boolean bl) {
        if (this.iht != null) {
            this.iht.toast(string, vhz2, bl);
        }
    }

    @Override
    TextField field() {
        return this.igx;
    }

    @Override
    boolean gone() {
        return this.ihn && this.iha.get() <= 0.01f;
    }

    @Override
    boolean closing() {
        return this.ihn;
    }

    @Override
    void close() {
        this.ihn = true;
    }

    @Override
    void render(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3, float f4, float f5) {
        this.iht = hlc2;
        this.ihj = f;
        this.ihk = f2;
        float f6 = Easing.outCubic(this.iha.step(this.ihn ? 0.0f : 1.0f, f3));
        if (f6 <= 0.01f) {
            return;
        }
        if (this.ihn) {
            f = -10000.0f;
            f2 = -10000.0f;
        }
        this.iic();
        this.ihc.clear();
        this.iho = null;
        float f7 = Theme.r(10.0f);
        float f8 = Theme.lightness();
        DrawUtil.round(class_3322, 0.0f, 0.0f, f4, f5, Theme.r(12.0f), ColorUtil.withAlpha(0, Math.round(110.0f * f6)));
        DrawUtil.pushAlpha(f6);
        class_3322.method_51448().pushMatrix();
        float f9 = 0.96f + 0.04f * f6;
        class_3322.method_51448().translate(this.igy + 255.0f, this.igz + 180.0f + (1.0f - f6) * 6.0f);
        class_3322.method_51448().scale(f9, f9);
        class_3322.method_51448().translate(-(this.igy + 255.0f), -(this.igz + 180.0f));
        DrawUtil.shadow(class_3322, this.igy, this.igz + 4.0f, 510.0f, 360.0f, f7, 18.0f, Theme.shadow);
        DrawUtil.round(class_3322, this.igy, this.igz, 510.0f, 360.0f, f7, ColorUtil.withAlpha(Theme.window, 252));
        DrawUtil.round(class_3322, this.igy, this.igz, 510.0f, 360.0f, f7, Theme.card);
        GlassDraw.sheen(class_3322, this.igy, this.igz, 510.0f, 50.0f, f7, 0.8f * (1.0f - 0.7f * f8));
        DrawUtil.outline(class_3322, this.igy, this.igz, 510.0f, 360.0f, f7, 1.0f, Theme.stroke);
        GlassDraw.rim(class_3322, this.igy, this.igz, 510.0f, 360.0f, f7, f8, 1.0f);
        this.iie(class_3322, f, f2);
        this.iii(class_3322, hlc2, f, f2, f3);
        if (this.ihe == null) {
            this.iik(class_3322);
        } else {
            float f10 = this.igy + 12.0f + 146.0f + 10.0f;
            float f11 = this.igy + 510.0f - 12.0f - f10;
            float f12 = (f11 - 10.0f) * 0.5f;
            float f13 = this.igz + 30.0f + 4.0f;
            this.iiq(class_3322, f, f2, f10, f13, f12);
            this.iir(class_3322, f, f2, f10 + f12 + 10.0f, f13, f12);
        }
        this.iju(class_3322);
        class_3322.method_51448().popMatrix();
        DrawUtil.popAlpha();
    }

    private void iic() {
        tct tct2 = RecorderHooks.job();
        if (tct2 == null || tct2 == this.ihs || !tct2.done) {
            return;
        }
        this.ihs = tct2;
        if (tct2.error == null && tct2.walkResult != null) {
            this.iib(Lang.s("Walking model ready · keys like you ", "Модель ходьбы готова · клавиши как у тебя ") + Math.round(tct2.walkResult.keysAcc) + "% · " + Lang.s("turns ", "поворот ") + Math.round(tct2.walkResult.yawSim) + "%", Icon.CHECK, false);
        } else if (tct2.error == null && tct2.mineResult != null) {
            this.iib(Lang.s("Mine model ready · picks like you ", "Модель шахты готова · выбор как у тебя ") + Math.round(tct2.mineResult.top1) + "% · " + Lang.s("hand ", "рука ") + Math.round(tct2.mineResult.hand.similarity) + "%", Icon.CHECK, false);
        } else if (tct2.error == null && tct2.result != null && tct2.aura) {
            this.iib(Lang.s("Aura model ready · X ", "Модель ауры готова · X ") + ProfilePopup.ijd(tct2.result.axisScore(0)) + " · Y " + ProfilePopup.ijd(tct2.result.axisScore(1)), Icon.CHECK, false);
        } else if (tct2.error == null && tct2.result != null) {
            this.iib(Lang.s("Model ready · similarity ", "Модель готова · сходство ") + Math.round(tct2.result.similarity) + "%", Icon.CHECK, false);
        } else if (tct2.error != null) {
            this.iib(ProfilePopup.iid(tct2.error, tct2.aura, tct2.mine, tct2.walk), Icon.CLOSE, !"cancel".equals(tct2.error));
        }
    }

    /*
     * Exception decompiling
     */
    private static String iid(String var0, boolean var1_1, boolean var2_2, boolean var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void iie(class_332 class_3322, float f, float f2) {
        boolean bl;
        float f3;
        float f4;
        float f5;
        AutoMine lfa2;
        String string;
        boolean bl2;
        boolean bl3;
        float f6 = this.igz + 15.0f + 1.0f;
        IconRenderer.draw(class_3322, Icon.LAYERS, this.igy + 12.0f + 5.0f, f6, 10.0f, Theme.accent());
        String string2 = Lang.s("Neuro studio", "Нейро-студия");
        UiKit.CARD_TITLE.draw(class_3322, string2, this.igy + 12.0f + 16.0f, UiKit.CARD_TITLE.centerTop(f6), Theme.text);
        boolean bl4 = this.ihe != null && this.ihe.aura();
        boolean bl5 = this.ihe != null && this.ihe.mine();
        boolean bl6 = bl3 = this.ihe != null && this.ihe.walk();
        StudioProfiles tiq2 = bl4 ? Aura.studioProfile() : (bl5 ? AutoMine.mineProfile() : (bl3 ? AutoMine.walkProfile() : AutoMine.activeProfile()));
        boolean bl7 = bl2 = bl4 && this.ihe != null && Aura.usesStudio(Aura.studioProfile());
        if (bl3) {
            string = tiq2 == null ? Lang.s("AutoEnd / AutoWarden: built-in walking", "AutoEnd / AutoWarden: своя ходьба") : Lang.s("walking uses: ", "ходьба берёт: ") + tiq2.name;
        } else if (bl4) {
            string = bl2 && tiq2 != null ? Lang.s("aura uses: ", "аура берёт: ") + tiq2.name : Lang.s("aura uses: Profile 1", "аура берёт: Профиль 1");
        } else if (bl5) {
            string = tiq2 == null ? Lang.s("AutoMine: built-in", "AutoMine: встроенный") : Lang.s("AutoMine uses: ", "AutoMine берёт: ") + tiq2.name;
        } else {
            String string3 = string = tiq2 == null ? Lang.s("no active profile", "нет активного профиля") : Lang.s("aim uses: ", "аим берёт: ") + tiq2.name;
        }
        boolean bl8 = bl4 ? bl2 : tiq2 != null;
        float f7 = this.igy + 12.0f + 16.0f + UiKit.CARD_TITLE.width(string2) + 8.0f + Math.max(16.0f, UiKit.SMALL.width(string) + 9.0f);
        UiKit.drawChip(class_3322, string, f7, f6, bl8 ? Theme.accent() : Theme.textMuted, Theme.stroke, 0.0f);
        Module kfe2 = lfa2 = bl4 ? Flow.getInstance().getModuleManager().getByName("KillAura") : AutoMine.get();
        if (lfa2 != null) {
            String string4 = lfa2.getDisplayName();
            String string5 = string4 + (lfa2.isEnabled() ? Lang.s(" on", " вкл") : Lang.s(" off", " выкл"));
            f5 = Math.max(16.0f, UiKit.SMALL.width(string5) + 9.0f);
            float f8 = f7 + 6.0f;
            boolean bl9 = UiKit.inside(f, f2, f8, f6 - 5.5f, f5, 11.0f);
            UiKit.drawChip(class_3322, string5, f8 + f5, f6, lfa2.isEnabled() ? Theme.accent() : Theme.textMuted, Theme.stroke, bl9 ? 1.0f : 0.0f);
            this.ihc.add(new ige(f8, f6 - 5.5f, f5, 11.0f, lfa2::toggle, null));
            if (bl9) {
                this.iho = bl4 ? Lang.s("Click — turn KillAura on / off", "Клик — включить / выключить KillAura") : (bl3 ? Lang.s("Click — NeuroRotation on / off: AutoEnd and AutoWarden walk with your model only while it is on", "Клик — вкл / выкл NeuroRotation: AutoEnd и AutoWarden ходят твоей моделью, только пока он включён") : (bl5 ? Lang.s("Click — NeuroRotation on / off: AutoMine digs with your model only while it is on", "Клик — вкл / выкл NeuroRotation: AutoMine копает твоей моделью, только пока он включён") : Lang.s("Click — turn the aim on / off", "Клик — включить / выключить аим")));
            }
        }
        UiKit.iconButton(class_3322, Icon.CLOSE, f4, f5, f3, (bl = UiKit.inside(f, f2, f4 = this.igy + 510.0f - 12.0f - (f3 = 16.0f), f5 = this.igz + (30.0f - f3) * 0.5f + 1.0f, f3, f3)) ? 1.0f : 0.0f, false, 1.0f);
        this.ihc.add(new ige(f4, f5, f3, f3, this::close, null));
    }

    private float iif() {
        return this.igz + 30.0f + 16.0f;
    }

    private float iig() {
        return this.igz + 360.0f - 16.0f - 8.0f - 26.0f - this.iif();
    }

    private float iih() {
        return Math.max(0.0f, (float)this.ihd.size() * 34.0f - 4.0f - this.iig());
    }

    private void iii(class_332 class_3322, ClickGuiScreen hlc2, float f, float f2, float f3) {
        boolean bl;
        float f4 = this.igy + 12.0f;
        this.ijn(class_3322, Lang.s("Profiles", "Профили"), f4, this.igz + 30.0f + 4.0f);
        float f5 = this.iif();
        float f6 = this.iig();
        float f7 = this.ihb.step(Math.max(0.0f, Math.min(this.ihf, this.iih())), f3);
        StudioProfiles tiq2 = AutoMine.activeProfile();
        tct tct2 = RecorderHooks.job();
        DrawUtil.pushScissor(class_3322, f4 - 2.0f, f5 - 2.0f, 150.0f, f6 + 4.0f);
        float f8 = Theme.r(6.0f);
        for (int i = 0; i < this.ihd.size(); ++i) {
            Object object;
            String string;
            boolean bl2;
            StudioProfiles tiq3 = this.ihd.get(i);
            bl = tiq3.aura();
            float f9 = f5 + (float)i * 34.0f - f7;
            if (f9 + 30.0f < f5 - 2.0f || f9 > f5 + f6 + 2.0f) continue;
            boolean bl3 = UiKit.inside(f, f2, f4, f9, 146.0f, 30.0f) && UiKit.inside(f, f2, f4, f5, 146.0f, f6);
            boolean bl4 = tiq3 == this.ihe;
            int n = bl4 ? ColorUtil.lerp(Theme.field, Theme.accent(), 0.18f) : Theme.field;
            DrawUtil.round(class_3322, f4, f9, 146.0f, 30.0f, f8, bl3 ? ColorUtil.lerp(n, Theme.fieldHover, 0.6f) : n);
            if (bl4) {
                DrawUtil.outline(class_3322, f4, f9, 146.0f, 30.0f, f8, 1.1f, Theme.accent(200));
            }
            float f10 = f4 + 8.0f;
            if (bl ? Aura.usesStudio(tiq3) : (tiq3.mine() ? AutoMine.mineProfile() == tiq3 : (tiq3.walk() ? AutoMine.walkProfile() == tiq3 : tiq2 == tiq3))) {
                DrawUtil.circle(class_3322, f4 + 7.0f, f9 + 15.0f, 2.5f, Theme.accent());
                f10 = f4 + 14.0f;
            }
            UiKit.NAME.draw(class_3322, UiKit.NAME.ellipsize(tiq3.name, 146.0f - (f10 - f4) - 22.0f), f10, UiKit.NAME.centerTop(f9 + 10.0f), Theme.text);
            boolean bl5 = bl2 = tct2 != null && !tct2.done && tct2.profile == tiq3;
            if (bl2) {
                string = Lang.s("training ", "обучение ") + (tct2.progress.epoch + 1) + "/" + tct2.progress.epochs;
            } else if (RecorderHooks.mode() == tcw.RECORD && RecorderHooks.sessionProfile() == tiq3) {
                string = Lang.s("recording…", "идёт запись…");
            } else if (tiq3.walk()) {
                object = tiq3.walkModel();
                string = ProfilePopup.ijv(tiq3.getLong("walk.ticks", 0L) / 20L) + "  ·  " + (object == null ? Lang.s("walk none", "ходьба нет") : Lang.s("walk ", "ходьба ") + Math.round(((WalkModelReader)object).keysAcc) + "%");
            } else if (tiq3.mine()) {
                object = tiq3.mineModel();
                string = tiq3.getLong("mine.blocks", 0L) + Lang.s(" blocks", " бл.") + "  ·  " + (object == null ? Lang.s("mine none", "шахта нет") : Lang.s("mine ", "шахта ") + Math.round(((MineModelReader)object).top1) + "%");
            } else {
                object = tiq3.model(bl);
                String string2 = bl ? Lang.s("aura ", "аура ") : Lang.s("model ", "модель ");
                string = tiq3.getLong("hits", 0L) + Lang.s(" hits", " уд.") + "  ·  " + (object == null ? string2 + Lang.s("none", "нет") : string2 + Math.round(((AimModel)object).similarity) + "%");
            }
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, 146.0f - (f10 - f4) - 8.0f), f10, UiKit.SMALL.centerTop(f9 + 20.5f), bl2 ? Theme.accent() : Theme.textMuted);
            object = tiq3;
            if (bl3 || this.ihp == tiq3) {
                float f11 = 14.0f;
                float f12 = f4 + 146.0f - f11 - 5.0f;
                float f13 = f9 + (30.0f - f11) * 0.5f;
                boolean bl6 = this.ihp == tiq3 && System.currentTimeMillis() - this.ihq < 3000L;
                boolean bl7 = UiKit.inside(f, f2, f12, f13, f11, f11);
                UiKit.iconButton(class_3322, Icon.TRASH, f12, f13, f11, bl7 ? 1.0f : 0.0f, bl6, 1.0f);
                this.ihc.add(new ige(f12, f13, f11, f11, () -> this.lambda$list$0((StudioProfiles)object), null));
                if (bl7) {
                    this.iho = bl6 ? Lang.s("Click again to delete it with all recordings", "Ещё клик — удалить вместе с записями") : Lang.s("Delete the profile", "Удалить профиль");
                }
            }
            this.ihc.add(new ige(f4, f9, 146.0f, 30.0f, () -> this.lambda$list$1((StudioProfiles)object), () -> this.lambda$list$2((StudioProfiles)object)));
            if (!bl3 || this.iho != null) continue;
            this.iho = bl ? Lang.s("Click — open  ·  right click — KillAura uses it", "Клик — открыть  ·  ПКМ — KillAura берёт его") : (tiq3.mine() ? Lang.s("Click — open  ·  right click — AutoMine digs with it", "Клик — открыть  ·  ПКМ — AutoMine копает им") : (tiq3.walk() ? Lang.s("Click — open  ·  right click — AutoEnd / AutoWarden walk with it", "Клик — открыть  ·  ПКМ — AutoEnd / AutoWarden ходят им") : Lang.s("Click — open  ·  right click — the aim uses it", "Клик — открыть  ·  ПКМ — аим берёт его")));
        }
        if (this.ihd.isEmpty()) {
            UiKit.SMALL.draw(class_3322, Lang.s("No profiles yet", "Профилей пока нет"), f4 + 4.0f, UiKit.SMALL.centerTop(f5 + 10.0f), Theme.textMuted);
        }
        DrawUtil.popScissor(class_3322);
        float f14 = this.igz + 360.0f - 16.0f - 8.0f - 20.0f;
        this.igx.x = f4;
        this.igx.y = f14;
        this.igx.w = 124.0f;
        this.igx.h = 18.0f;
        this.igx.render(class_3322, hlc2, f, f2, 0.016f);
        float f15 = f4 + 146.0f - 18.0f;
        bl = UiKit.inside(f, f2, f15, f14, 18.0f, 18.0f);
        UiKit.primaryButton(class_3322, "", Icon.PLUS, f15, f14, 18.0f, 18.0f, bl ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f15, f14, 18.0f, 18.0f, this::iia, null));
        if (bl) {
            this.iho = Lang.s("Create a profile", "Создать профиль");
        }
    }

    private void iij(StudioProfiles tiq2) {
        long l = System.currentTimeMillis();
        if (this.ihp != tiq2 || l - this.ihq > 3000L) {
            this.ihp = tiq2;
            this.ihq = l;
            return;
        }
        this.ihp = null;
        if (RecorderHooks.sessionProfile() == tiq2) {
            RecorderHooks.stop();
        }
        if (RecorderHooks.training() && RecorderHooks.job().profile == tiq2) {
            RecorderHooks.cancelTraining();
        }
        if (AutoMine.activeProfile() == tiq2) {
            AutoMine.activate(null);
        }
        if (AutoMine.mineProfile() == tiq2) {
            AutoMine.activateMine(null);
        }
        if (AutoMine.walkProfile() == tiq2) {
            AutoMine.activateWalk(null);
        }
        if (Aura.studioProfile() == tiq2) {
            Aura.useStudio(null);
        }
        try {
            StudioProfiles.delete(tiq2);
            this.iib(Lang.s("Profile deleted", "Профиль удалён"), Icon.TRASH, false);
        }
        catch (IOException iOException) {
            this.iib(Lang.s("Can't delete it", "Не получилось удалить"), Icon.CLOSE, true);
        }
        this.ihy();
        if (this.ihe == null && !this.ihd.isEmpty()) {
            this.ihe = this.ihd.get(0);
        }
    }

    private void iik(class_332 class_3322) {
        float f = this.igy + 12.0f + 146.0f + 10.0f;
        float f2 = this.igy + 510.0f - 12.0f - f;
        float f3 = this.igz + 180.0f - 10.0f;
        UiKit.CARD_TITLE.drawCentered(class_3322, Lang.s("Create a profile on the left", "Создай профиль слева"), f + f2 * 0.5f, UiKit.CARD_TITLE.centerTop(f3), Theme.textDim);
        UiKit.SMALL.drawCentered(class_3322, Lang.s("One profile = one aim style: record, train, use", "Профиль = один стиль аима: записал, обучил, пользуешься"), f + f2 * 0.5f, UiKit.SMALL.centerTop(f3 + 14.0f), Theme.textMuted);
    }

    private void iil(class_332 class_3322, float f, float f2, float f3, float f4, float f5) {
        String string3;
        String[] stringArray;
        int n;
        String string2;
        StudioProfiles tiq2 = this.ihe;
        float f6 = this.ijn(class_3322, Lang.s("Mining recording", "Запись копания"), f3, f4);
        MineRecorder ttl2 = RecorderHooks.mineRecorder();
        boolean bl = ttl2 != null && RecorderHooks.sessionProfile() == tiq2;
        long l = tiq2.getLong("mine.blocks", 0L);
        long l2 = tiq2.getLong("mine.decisions", 0L);
        long l3 = tiq2.getLong("mine.ticks", 0L);
        long l4 = tiq2.getLong("mine.diamonds", 0L);
        long l5 = tiq2.getLong("mine.farmed", 0L);
        if (bl) {
            int[] nArray = ttl2.unsaved();
            l += (long)nArray[0];
            l2 += (long)nArray[1];
            l3 += (long)nArray[2];
            l4 += (long)nArray[3];
            l5 += (long)nArray[4];
        }
        float f7 = (f5 - 6.0f) * 0.5f;
        this.ijo(class_3322, Lang.s("blocks clicked", "кликов по блокам"), String.valueOf(l), f3, f6, f7, false);
        this.ijo(class_3322, Lang.s("farmed with 3x3", "нафармлено с 3×3"), String.valueOf(l5), f3 + f7 + 6.0f, f6, f7, true);
        this.ijo(class_3322, Lang.s("recorded", "записано"), ProfilePopup.ijv(l3 / 20L), f3, f6 += 30.0f, f7, false);
        this.ijo(class_3322, Lang.s("diamonds", "алмазов"), String.valueOf(l4), f3 + f7 + 6.0f, f6, f7, false);
        float f8 = 18.0f;
        float f9 = f5 - 50.0f;
        boolean bl2 = UiKit.inside(f, f2, f3, f6 += 32.0f, f9, f8);
        if (bl) {
            UiKit.primaryButton(class_3322, Lang.s("Stop", "Стоп"), Icon.PAUSE, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, RecorderHooks::stop, null));
        } else {
            UiKit.primaryButton(class_3322, Lang.s("Record mining", "Записать копание"), Icon.PLAY, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, () -> {
                RecorderHooks.startMining(tiq2);
                this.close();
                if (this.iht != null) {
                    this.iht.method_25419();
                }
            }, null));
        }
        if (bl2) {
            this.iho = Lang.s("Mine yourself with a pickaxe: what you break, your turns and walking are recorded", "Копай сам киркой: пишется что ломаешь, как крутишь камеру и как ходишь");
        }
        float f10 = f3 + f9 + 6.0f;
        float f11 = f5 - f9 - 6.0f;
        boolean bl3 = System.currentTimeMillis() - this.ihr < 3000L;
        boolean bl4 = UiKit.inside(f, f2, f10, f6, f11, f8);
        UiKit.secondaryButton(class_3322, bl3 ? Lang.s("Sure?", "Точно?") : "", Icon.TRASH, f10, f6, f11, f8, bl4 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f10, f6, f11, f8, () -> this.ije(tiq2), null));
        if (bl4) {
            this.iho = Lang.s("Delete all recordings of this profile (the model stays)", "Удалить все записи профиля (модель останется)");
        }
        f6 += f8 + 6.0f;
        if (bl && ttl2.paused) {
            string2 = Lang.s("Paused: ", "Пауза: ") + StudioStatusLine.reasonText(ttl2.pauseReason);
            n = -678620;
        } else if (bl) {
            string2 = (ttl2.mineFound() ? Lang.s("Mine found · recording", "Шахта найдена · пишу") : Lang.s("No mine board near · recording all blocks", "Табличка шахты не видна · пишу все блоки")) + Lang.s(" · choices ", " · решений ") + l2;
            n = ttl2.mineFound() ? Theme.accent() : Theme.textDim;
        } else {
            string2 = l2 > 0L ? Lang.s("Choices to learn from: ", "Решений для учёбы: ") + l2 : Lang.s("5–10 minutes of mining is enough to train", "Для обучения хватит 5–10 минут копания");
            n = Theme.textMuted;
        }
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string2, f5), f3, UiKit.SMALL.centerTop(f6 + 4.0f), n);
        f6 += 16.0f;
        f6 = this.ijn(class_3322, Lang.s("What is recorded", "Что пишется"), f3, f6);
        for (String string3 : stringArray = new String[]{Lang.s("what you break and in which order", "что ломаешь и в каком порядке"), Lang.s("your turns: speed, start, overshoots", "поворот камеры: скорость, разгон, перелёты"), Lang.s("movement: W A S D, jumps, sprint", "движение: W A S D, прыжки, спринт"), Lang.s("how much you farmed: learns from your best moments", "сколько нафармил: учится на твоих лучших моментах"), Lang.s("a 3D snapshot of the blocks around you every tick", "3D-снимок блоков вокруг каждый тик")}) {
            DrawUtil.circle(class_3322, f3 + 2.0f, f6 + 5.5f, 1.4f, Theme.accent());
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string3, f5 - 8.0f), f3 + 7.0f, UiKit.SMALL.centerTop(f6 + 5.5f), Theme.textDim);
            f6 += 11.0f;
        }
        f6 += 4.0f;
        double d = RecorderHooks.unit(class_310.method_1551());
        MineModelReader ttb2 = tiq2.mineModel();
        string3 = Lang.s("Sensitivity: ", "Сенса: ") + ProfilePopup.ijx(d) + Lang.s("°/count", "°/отсчёт") + ProfilePopup.iix(tiq2);
        if (ttb2 != null && ttb2.hand.unit > 0.0f && Math.abs((double)ttb2.hand.unit - d) / (double)ttb2.hand.unit > 0.15) {
            string3 = string3 + Lang.s("  ·  model: ", "  ·  у модели: ") + ProfilePopup.ijx(ttb2.hand.unit);
        }
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string3, f5), f3, UiKit.SMALL.centerTop(f6 + 5.0f), Theme.textMuted);
    }

    private static String iim(StudioProfiles tiq2) {
        return "AutoWarden".equals(tiq2.get("walk.with", "AutoEnd")) ? "AutoWarden" : "AutoEnd";
    }

    private void iin(class_332 class_3322, float f, float f2, float f3, float f4, float f5) {
        String[] stringArray;
        int n;
        String string;
        StudioProfiles tiq2 = this.ihe;
        float f6 = this.ijn(class_3322, Lang.s("Walking recording", "Запись ходьбы"), f3, f4);
        WardenRecorder tyd2 = RecorderHooks.walkRecorder();
        boolean bl = tyd2 != null && RecorderHooks.sessionProfile() == tiq2;
        long l = tiq2.getLong("walk.ticks", 0L);
        long l2 = tiq2.getLong("walk.meters", 0L);
        long l3 = tiq2.getLong("walk.routes", 0L);
        long l4 = tiq2.getLong("walk.jumps", 0L);
        if (bl) {
            double[] dArray = tyd2.unsaved();
            l += Math.round(dArray[0]);
            l2 += Math.round(dArray[1]);
            l3 += Math.round(dArray[2]);
            l4 += Math.round(dArray[3]);
        }
        float f7 = (f5 - 6.0f) * 0.5f;
        this.ijo(class_3322, Lang.s("recorded", "записано"), ProfilePopup.ijv(l / 20L), f3, f6, f7, true);
        this.ijo(class_3322, Lang.s("walked", "пройдено"), l2 + Lang.s(" m", " м"), f3 + f7 + 6.0f, f6, f7, false);
        this.ijo(class_3322, Lang.s("routes", "маршрутов"), String.valueOf(l3), f3, f6 += 30.0f, f7, false);
        this.ijo(class_3322, Lang.s("jumps", "прыжков"), String.valueOf(l4), f3 + f7 + 6.0f, f6, f7, false);
        String string2 = bl ? tyd2.module : ProfilePopup.iim(tiq2);
        this.ijr(class_3322, f, f2, Lang.s("Lines from", "Линии от"), string2, f3, f6 += 32.0f, f5, () -> {
            if (!bl) {
                tiq2.set("walk.with", "AutoEnd".equals(ProfilePopup.iim(tiq2)) ? "AutoWarden" : "AutoEnd");
                tiq2.save();
            }
        }, () -> {
            if (!bl) {
                tiq2.set("walk.with", "AutoEnd".equals(ProfilePopup.iim(tiq2)) ? "AutoWarden" : "AutoEnd");
                tiq2.save();
            }
        }, Lang.s("Which module plans the routes and does the looting while you walk", "Какой модуль строит маршруты и лутает, пока ты идёшь"));
        float f8 = 18.0f;
        float f9 = f5 - 50.0f;
        boolean bl2 = UiKit.inside(f, f2, f3, f6 += 20.0f, f9, f8);
        if (bl) {
            UiKit.primaryButton(class_3322, Lang.s("Stop", "Стоп"), Icon.PAUSE, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, RecorderHooks::stop, null));
        } else {
            UiKit.primaryButton(class_3322, Lang.s("Record walking", "Записать ходьбу"), Icon.PLAY, f3, f6, f9, f8, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, () -> {
                RecorderHooks.startWalking(tiq2, ProfilePopup.iim(tiq2));
                this.close();
                if (this.iht != null) {
                    this.iht.method_25419();
                }
            }, null));
        }
        if (bl2) {
            this.iho = Lang.s("The module draws the route, you walk it yourself; it loots by itself", "Модуль рисует маршрут, идёшь по нему сам; лутает он сам");
        }
        float f10 = f3 + f9 + 6.0f;
        float f11 = f5 - f9 - 6.0f;
        boolean bl3 = System.currentTimeMillis() - this.ihr < 3000L;
        boolean bl4 = UiKit.inside(f, f2, f10, f6, f11, f8);
        UiKit.secondaryButton(class_3322, bl3 ? Lang.s("Sure?", "Точно?") : "", Icon.TRASH, f10, f6, f11, f8, bl4 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f10, f6, f11, f8, () -> this.ije(tiq2), null));
        if (bl4) {
            this.iho = Lang.s("Delete all recordings of this profile (the model stays)", "Удалить все записи профиля (модель останется)");
        }
        f6 += f8 + 6.0f;
        if (bl && tyd2.paused) {
            string = Lang.s("Paused: ", "Пауза: ") + StudioStatusLine.reasonText(tyd2.pauseReason);
            n = -678620;
        } else if (bl) {
            string = Lang.s("Walk along the line · routes ", "Иди по линии · маршрутов ") + l3;
            n = Theme.accent();
        } else {
            string = l > 0L ? Lang.s("Recorded: ", "Записано: ") + ProfilePopup.ijv(l / 20L) : Lang.s("5–10 minutes of walking is enough to train", "Для обучения хватит 5–10 минут ходьбы");
            n = Theme.textMuted;
        }
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, f5), f3, UiKit.SMALL.centerTop(f6 + 4.0f), n);
        f6 += 16.0f;
        f6 = this.ijn(class_3322, Lang.s("What is recorded", "Что пишется"), f3, f6);
        for (String string3 : stringArray = new String[]{Lang.s("how you follow the line: W A S D, sprint, jumps", "как идёшь по линии: W A S D, спринт, прыжки"), Lang.s("your speed and your camera turns while walking", "твоя скорость и поворот камеры при ходьбе"), Lang.s("how you correct when you leave the line", "как поправляешься, если ушёл с линии"), Lang.s("looting is not recorded: the bot does it", "лутание не пишется: его делает бот")}) {
            DrawUtil.circle(class_3322, f3 + 2.0f, f6 + 5.5f, 1.4f, Theme.accent());
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string3, f5 - 8.0f), f3 + 7.0f, UiKit.SMALL.centerTop(f6 + 5.5f), Theme.textDim);
            f6 += 11.0f;
        }
        double d = RecorderHooks.unit(class_310.method_1551());
        String string4 = Lang.s("Sensitivity: ", "Сенса: ") + ProfilePopup.ijx(d) + Lang.s("°/count", "°/отсчёт") + ProfilePopup.iix(tiq2);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string4, f5), f3, UiKit.SMALL.centerTop((f6 += 4.0f) + 5.0f), Theme.textMuted);
    }

    private void iio(class_332 class_3322, float f, float f2, StudioProfiles tiq2, float f3, float f4, float f5) {
        WalkModelReader txs2 = tiq2.walkModel();
        if (txs2 == null) {
            boolean bl = "old".equals(tiq2.walkIssue());
            UiKit.LABEL.draw(class_3322, bl ? Lang.s("Old model: train again", "Старая модель: обучи заново") : Lang.s("Not trained yet", "Ещё не обучена"), f3, UiKit.LABEL.centerTop(f4 + 6.0f), Theme.textMuted);
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("Walk the lines yourself for 5–10 minutes, then train", "Походи по линиям сам 5–10 минут, потом обучи"), f5), f3, UiKit.SMALL.centerTop((f4 += 16.0f) + 4.0f), Theme.textMuted);
            return;
        }
        String string = new SimpleDateFormat("dd.MM HH:mm", Locale.ROOT).format(new Date(txs2.created));
        UiKit.LABEL.draw(class_3322, Lang.s("Walks like you ", "Ходьба как у тебя ") + Math.round(txs2.keysAcc) + "%", f3, UiKit.LABEL.centerTop(f4 + 6.0f), txs2.keysAcc > txs2.keysBase + 5.0 ? Theme.accent() : Theme.text);
        UiKit.SMALL.drawRight(class_3322, string + "  ·  " + ProfilePopup.ijv(txs2.samples / 20), f3 + f5, UiKit.SMALL.centerTop(f4 + 6.0f), Theme.textMuted);
        txp txp2 = txs2.style;
        this.ijp(class_3322, Lang.s("Keys · just the usual", "Клавиши · просто обычные"), ProfilePopup.ijd(txs2.keysAcc) + " · " + ProfilePopup.ijd(txs2.keysBase), f3, f4 += 15.0f, f5);
        this.ijp(class_3322, Lang.s("Camera turns · ceiling", "Поворот камеры · потолок"), ProfilePopup.ijd(txs2.yawSim) + " · " + ProfilePopup.ijd(txs2.yawCeil), f3, f4 += 12.0f, f5);
        this.ijp(class_3322, Lang.s("Camera pitch", "Наклон камеры"), ProfilePopup.ijd(txs2.pitchSim), f3, f4 += 12.0f, f5);
        this.ijp(class_3322, Lang.s("Jumps · sprint", "Прыжки · спринт"), ProfilePopup.ijd(txs2.jumpAcc) + " · " + ProfilePopup.ijd(txs2.sprintAcc), f3, f4 += 12.0f, f5);
        this.ijp(class_3322, Lang.s("Your pace · sprint", "Твой темп · спринт"), ProfilePopup.ijw(txp2.speed) + Lang.s(" m/s · ", " м/с · ") + Math.round(txp2.sprintShare * 100.0f) + "%", f3, f4 += 12.0f, f5);
        double d = ProfilePopup.iip(txs2);
        this.ijp(class_3322, Lang.s("Bot now", "Бот сейчас"), d < 0.0 ? Lang.s("not walking yet", "ещё не ходил") : ProfilePopup.ijw(d) + Lang.s(" m/s", " м/с"), f3, f4 += 12.0f, f5);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("checked on walking it never saw", "проверено на ходьбе, которой не видела"), f5), f3, UiKit.SMALL.centerTop((f4 += 12.0f) + 4.0f), Theme.textMuted);
        float f6 = 18.0f;
        boolean bl = AutoMine.walksWith(tiq2);
        boolean bl2 = UiKit.inside(f, f2, f3, f4 += 13.0f, f5, f6);
        if (bl) {
            UiKit.secondaryButton(class_3322, Lang.s("AutoEnd / AutoWarden walk with it", "AutoEnd / AutoWarden ходят ей"), Icon.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                AutoMine.activateWalk(null);
                this.iib(Lang.s("The modules walk on their own again", "Модули снова ходят сами"), Icon.INFO, false);
            }, null));
            if (bl2) {
                this.iho = Lang.s("Click — back to the built-in walking", "Клик — вернуть встроенную ходьбу");
            }
        } else {
            UiKit.primaryButton(class_3322, Lang.s("Use in AutoEnd / AutoWarden", "Использовать в AutoEnd / AutoWarden"), Icon.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                AutoMine.useForWalk(tiq2);
                this.iib(Lang.s("AutoEnd and AutoWarden walk like you now (NeuroRotation on)", "AutoEnd и AutoWarden ходят как ты (NeuroRotation включён)"), Icon.CHECK, false);
            }, null));
            if (bl2) {
                this.iho = Lang.s("The modules walk their routes with this model", "Модули ходят по маршрутам этой моделью");
            }
        }
    }

    private static double iip(WalkModelReader txs2) {
        double d = -1.0;
        for (WalkSpeedModel tvz2 : new WalkSpeedModel[]{AutoEnd.mainInstance() == null ? null : AutoEnd.mainInstance().walkBrain(), AutoWarden.mainInstance() == null ? null : AutoWarden.mainInstance().walkBrain()}) {
            if (tvz2 == null || tvz2.model != txs2) continue;
            d = Math.max(d, tvz2.speed());
        }
        return d;
    }

    private void iiq(class_332 class_3322, float f, float f2, float f3, float f4, float f5) {
        boolean bl;
        StudioProfiles tiq2 = this.ihe;
        if (tiq2.walk()) {
            this.iin(class_3322, f, f2, f3, f4, f5);
            return;
        }
        if (tiq2.mine()) {
            this.iil(class_3322, f, f2, f3, f4, f5);
            return;
        }
        float f6 = this.ijn(class_3322, Lang.s("Recording", "Запись"), f3, f4);
        long l = tiq2.getLong("hits", 0L);
        long l2 = tiq2.getLong("filtered", 0L);
        long l3 = tiq2.getLong("ticks", 0L);
        boolean bl2 = bl = RecorderHooks.mode() == tcw.RECORD && RecorderHooks.sessionProfile() == tiq2 && RecorderHooks.recorder() != null;
        if (bl) {
            l += (long)RecorderHooks.recorder().hits;
            l2 += (long)RecorderHooks.recorder().failures;
            l3 += (long)RecorderHooks.recorder().recorded;
        }
        float f7 = (f5 - 6.0f) * 0.5f;
        this.ijo(class_3322, Lang.s("good hits", "удачных ударов"), String.valueOf(l), f3, f6, f7, true);
        this.ijo(class_3322, Lang.s("misses filtered", "промахов отсеяно"), String.valueOf(l2), f3 + f7 + 6.0f, f6, f7, false);
        this.ijo(class_3322, Lang.s("recorded", "записано"), ProfilePopup.ijv(l3 / 20L), f3, f6 += 30.0f, f7, false);
        this.ijo(class_3322, Lang.s("sessions", "сессий"), String.valueOf(tiq2.getLong("sessions", 0L)), f3 + f7 + 6.0f, f6, f7, false);
        float f8 = 18.0f;
        float f9 = f5 - 50.0f;
        boolean bl3 = UiKit.inside(f, f2, f3, f6 += 32.0f, f9, f8);
        if (bl) {
            UiKit.primaryButton(class_3322, Lang.s("Stop", "Стоп"), Icon.PAUSE, f3, f6, f9, f8, bl3 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, RecorderHooks::stop, null));
        } else {
            UiKit.primaryButton(class_3322, Lang.s("Record on stands", "Запись со стендами"), Icon.PLAY, f3, f6, f9, f8, bl3 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f6, f9, f8, () -> {
                RecorderHooks.startRecording(tiq2);
                this.close();
                if (this.iht != null) {
                    this.iht.method_25419();
                }
            }, null));
        }
        if (bl3) {
            this.iho = Lang.s("Stands appear around you: hit them yourself, only good aiming is kept", "Вокруг появятся стенды: бей их сам, в обучение идут только удачные наведения");
        }
        float f10 = f3 + f9 + 6.0f;
        float f11 = f5 - f9 - 6.0f;
        boolean bl4 = System.currentTimeMillis() - this.ihr < 3000L;
        boolean bl5 = UiKit.inside(f, f2, f10, f6, f11, f8);
        UiKit.secondaryButton(class_3322, bl4 ? Lang.s("Sure?", "Точно?") : "", Icon.TRASH, f10, f6, f11, f8, bl5 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f10, f6, f11, f8, () -> this.ije(tiq2), null));
        if (bl5) {
            this.iho = Lang.s("Delete all recordings of this profile (the model stays)", "Удалить все записи профиля (модель останется)");
        }
        this.ijq(class_3322, f, f2, Lang.s("Record real fights", "Писать реальные бои"), tiq2.fights(), f3, f6 += f8 + 6.0f, f5, () -> {
            tiq2.set("fights", !tiq2.fights());
            tiq2.save();
        }, Lang.s("Also records your fights with players while AimAssist and the bots are off (into the profile in use)", "Пишет и твои бои с игроками, пока AimAssist и боты выключены (в профиль, который используется)"));
        f6 += 22.0f;
        f6 = this.ijn(class_3322, Lang.s("Stands", "Стенды"), f3, f6);
        this.ijs(class_3322, f, f2, Lang.s("Count", "Количество"), String.valueOf(tiq2.standCount()), f3, f6, f5, () -> ProfilePopup.ijg(tiq2, "stands.count", tiq2.standCount() - 1), () -> ProfilePopup.ijg(tiq2, "stands.count", tiq2.standCount() + 1), Lang.s("More stands — more switching between targets", "Больше стендов — больше переводов между целями"));
        this.ijr(class_3322, f, f2, Lang.s("Behaviour", "Поведение"), ProfilePopup.ijk(tiq2.standMode()), f3, f6 += 16.0f, f5, () -> ProfilePopup.ijj(tiq2, "stands.mode", StudioProfiles.STAND_MODES, tiq2.standMode(), 1), () -> ProfilePopup.ijj(tiq2, "stands.mode", StudioProfiles.STAND_MODES, tiq2.standMode(), -1), Lang.s("Mix switches between duel, strafe, jumps, walking", "Микс чередует дуэль, стрейф, прыжки, ходьбу"));
        String string = ProfilePopup.ijw(tiq2.standNear()) + "–" + ProfilePopup.ijw(tiq2.standFar()) + Lang.s(" m", " м");
        this.ijs(class_3322, f, f2, Lang.s("Distance", "Дистанция"), string, f3, f6 += 16.0f, f5, () -> ProfilePopup.iji(tiq2, -0.3), () -> ProfilePopup.iji(tiq2, 0.3), Lang.s("How far the stands keep; aiming counts even out of reach", "Как далеко держатся стенды; наведение засчитывается и вне досягаемости"));
        this.ijs(class_3322, f, f2, Lang.s("Speed", "Скорость"), Math.round(tiq2.standSpeed() * 100.0) + "%", f3, f6 += 16.0f, f5, () -> ProfilePopup.ijh(tiq2, "stands.speed", Math.max(0.3, tiq2.standSpeed() - 0.1)), () -> ProfilePopup.ijh(tiq2, "stands.speed", Math.min(1.6, tiq2.standSpeed() + 0.1)), Lang.s("How fast the stands move", "Как быстро двигаются стенды"));
        f6 += 20.0f;
        double d = RecorderHooks.unit(class_310.method_1551());
        AimModel tck2 = tiq2.model(tiq2.aura());
        String string2 = Lang.s("Sensitivity: ", "Сенса: ") + ProfilePopup.ijx(d) + Lang.s("°/count", "°/отсчёт") + ProfilePopup.iix(tiq2);
        if (tck2 != null && tck2.unit > 0.0f && Math.abs((double)tck2.unit - d) / (double)tck2.unit > 0.15) {
            string2 = string2 + Lang.s("  ·  model: ", "  ·  у модели: ") + ProfilePopup.ijx(tck2.unit);
        }
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string2, f5), f3, UiKit.SMALL.centerTop(f6 + 5.0f), Theme.textMuted);
    }

    private void iir(class_332 class_3322, float f, float f2, float f3, float f4, float f5) {
        StudioProfiles tiq2 = this.ihe;
        boolean bl = tiq2.aura();
        boolean bl2 = tiq2.mine();
        boolean bl3 = tiq2.walk();
        boolean bl4 = bl2 || bl3;
        float f6 = f4;
        if (!bl4 || bl2) {
            f6 = this.ijn(class_3322, Lang.s("Trainer", "Тренер"), f3, f4);
        }
        if (!bl4) {
            f6 = this.iis(class_3322, f, f2, tiq2, bl, bl2, bl3, f3, f6, f5);
        }
        if (!bl && !bl3) {
            this.ijq(class_3322, f, f2, Lang.s("Drop overshoots", "Без перелётов"), tiq2.clean(), f3, f6, f5, () -> {
                tiq2.set("trainer.clean", !tiq2.clean());
                tiq2.save();
            }, Lang.s("Cuts the moments you flew past the target out of the data", "Вырезает из данных моменты, где ты пролетал цель"));
            f6 += 16.0f;
        }
        if (bl2) {
            int n = tiq2.mineBoost();
            this.ijr(class_3322, f, f2, Lang.s("Net boost", "Буст сети"), n == 0 ? Lang.s("off", "выкл") : "+" + n + "%", f3, f6, f5, () -> ProfilePopup.ijf(tiq2, 1), () -> ProfilePopup.ijf(tiq2, -1), Lang.s("How much better than you: faster hand and reaction, more of your best moves (by what you farmed)", "На сколько лучше тебя: быстрее рука и реакция, больше твоих самых удачных решений (по нафармленному)"));
            f6 += 16.0f;
        }
        if (!bl4 || bl2) {
            f6 += 6.0f;
        }
        this.iit(class_3322, f, f2, tiq2, f3, f6, f5);
    }

    private float iis(class_332 class_3322, float f, float f2, StudioProfiles tiq2, boolean bl, boolean bl2, boolean bl3, float f3, float f4, float f5) {
        this.ijr(class_3322, f, f2, Lang.s("Purpose", "Назначение"), bl ? "KillAura" : (bl2 ? Lang.s("Mine", "Шахта") : (bl3 ? Lang.s("Walking", "Ходьба") : Lang.s("Bots", "Боты"))), f3, f4, f5, () -> ProfilePopup.ijj(tiq2, "purpose", StudioProfiles.PURPOSES, tiq2.purpose(), 1), () -> ProfilePopup.ijj(tiq2, "purpose", StudioProfiles.PURPOSES, tiq2.purpose(), -1), bl ? Lang.s("KillAura: learns all your tracking near a target, similarity per axis X / Y", "KillAura: учит весь твой трекинг рядом с целью, сходство по осям X / Y") : (bl3 ? Lang.s("Walking: learns how you follow a route — keys, pace, camera, corrections; AutoEnd and AutoWarden walk with it", "Ходьба: учит как ты идёшь по маршруту — клавиши, темп, камера, поправки; так ходят AutoEnd и AutoWarden") : (bl2 ? Lang.s("Mine: learns how you dig — which block next, your turns, your walking; AutoMine digs with it", "Шахта: учит как ты копаешь — какой блок следующий, поворот и ходьбу; так копает AutoMine") : Lang.s("Bots: learns the aiming that ended in a hit; AutoMine, AutoEnd, AutoWarden turn with it", "Боты: учит наведение, которое закончилось ударом; им крутят AutoMine, AutoEnd, AutoWarden"))));
        this.ijr(class_3322, f, f2, Lang.s("Quality", "Качество"), ProfilePopup.ijl(tiq2.quality()), f3, f4 += 16.0f, f5, () -> ProfilePopup.ijj(tiq2, "trainer.quality", StudioProfiles.QUALITIES, tiq2.quality(), 1), () -> ProfilePopup.ijj(tiq2, "trainer.quality", StudioProfiles.QUALITIES, tiq2.quality(), -1), Lang.s("More epochs learn finer, take longer", "Больше эпох — точнее, но дольше"));
        this.ijr(class_3322, f, f2, Lang.s("Network", "Сеть"), ProfilePopup.ijm(tiq2.size()), f3, f4 += 16.0f, f5, () -> ProfilePopup.ijj(tiq2, "trainer.size", StudioProfiles.SIZES, tiq2.size(), 1), () -> ProfilePopup.ijj(tiq2, "trainer.size", StudioProfiles.SIZES, tiq2.size(), -1), Lang.s("Bigger needs more data; medium suits most", "Большой нужно больше данных; средняя подходит почти всем"));
        this.ijq(class_3322, f, f2, Lang.s("Mirror left / right", "Зеркалить лево / право"), tiq2.mirror(), f3, f4 += 16.0f, f5, () -> {
            tiq2.set("trainer.mirror", !tiq2.mirror());
            tiq2.save();
        }, Lang.s("Learns both directions from each flick: twice the data", "Учит оба направления из каждого флика: данных вдвое больше"));
        return f4 + 16.0f;
    }

    /*
     * Exception decompiling
     */
    private void iit(class_332 var1_1, float var2_2, float var3_3, StudioProfiles var4_4, float var5_5, float var6_6, float var7_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void iiu(class_332 class_3322, float f, float f2, StudioProfiles tiq2, AimModel tck2, float f3, float f4, float f5) {
        String string = new SimpleDateFormat("dd.MM HH:mm", Locale.ROOT).format(new Date(tck2.created));
        UiKit.LABEL.draw(class_3322, Lang.s("Similarity ", "Сходство ") + Math.round(tck2.similarity) + "%", f3, UiKit.LABEL.centerTop(f4 + 6.0f), Theme.text);
        UiKit.SMALL.drawRight(class_3322, string + "  ·  " + ProfilePopup.ijv(tck2.steps / 20), f3 + f5, UiKit.SMALL.centerTop(f4 + 6.0f), Theme.textMuted);
        f4 += 15.0f;
        if (tck2.axes.length >= 21) {
            this.ijc(class_3322, "X", Lang.s("yaw", "по горизонтали"), tck2.axisScore(0), tck2.axisScore(2), f3, f4, f5);
            this.ijc(class_3322, "Y", Lang.s("pitch", "по вертикали"), tck2.axisScore(1), tck2.axisScore(3), f3, f4 += 12.0f, f5);
            f4 += 13.0f;
            String[] stringArray = new String[]{Lang.s("Delta (speed)", "Дельта (скорость)"), Lang.s("Acceleration", "Ускорение"), Lang.s("Jerk", "Рывок"), Lang.s("Aim error", "Ошибка прицела"), Lang.s("Smoothness", "Плавность"), Lang.s("Overshoots", "Перелёты")};
            for (int i = 0; i < 6; ++i) {
                this.ijp(class_3322, stringArray[i], "X " + ProfilePopup.ijd(tck2.axisScore(4 + i)) + "   Y " + ProfilePopup.ijd(tck2.axisScore(10 + i)), f3, f4, f5);
                f4 += 11.0f;
            }
            this.ijp(class_3322, Lang.s("Overshoots / 100 ticks, you · model", "Перелёты на 100 т, ты · модель"), ProfilePopup.ijw(tck2.axisScore(16)) + " · " + ProfilePopup.ijw(tck2.axisScore(17)), f3, f4, f5);
            double d = tck2.axisScore(20);
            this.ijp(class_3322, Lang.s("Reaction, aim points, top speed", "Реакция, точки, макс. скорость"), (Double.isNaN(d) ? "—" : Math.round(d * 50.0) + Lang.s(" ms", " мс")) + " · " + (tck2.ownAim() ? Lang.s("yours", "твои") : "—") + " · " + (tck2.turnCap > 0.0f ? Math.round(tck2.turnCap) + "°/" + Lang.s("t", "т") : "—"), f3, f4 += 11.0f, f5);
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("on fights it never saw · ceiling = you vs you", "на боях, которых не видела · потолок = ты vs ты"), f5), f3, UiKit.SMALL.centerTop((f4 += 11.0f) + 4.0f), Theme.textMuted);
            f4 += 13.0f;
        } else {
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("Old model: retrain for your reaction, aim points, overshoots", "Старая модель: переобучи — будут твои реакция, точки, перелёты"), f5), f3, UiKit.SMALL.centerTop(f4 + 4.0f), -1727155);
            f4 += 13.0f;
        }
        float f6 = 18.0f;
        float f7 = (f5 - 6.0f) * 0.5f;
        boolean bl = Aura.usesStudio(tiq2);
        boolean bl2 = UiKit.inside(f, f2, f3, f4, f7, f6);
        if (bl) {
            UiKit.secondaryButton(class_3322, Lang.s("In KillAura", "В KillAura"), Icon.CHECK, f3, f4, f7, f6, 0.0f, 0.0f);
        } else {
            UiKit.primaryButton(class_3322, Lang.s("Use in KillAura", "В KillAura"), Icon.CHECK, f3, f4, f7, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f7, f6, () -> Aura.useStudio(tiq2), null));
            if (bl2) {
                this.iho = Lang.s("KillAura turns with this model instead of Profile 1", "KillAura будет крутить этой моделью вместо Профиля 1");
            }
        }
        float f8 = f3 + f7 + 6.0f;
        boolean bl3 = RecorderHooks.mode() == tcw.TEST && RecorderHooks.sessionProfile() == tiq2;
        boolean bl4 = UiKit.inside(f, f2, f8, f4, f7, f6);
        UiKit.secondaryButton(class_3322, bl3 ? Lang.s("Stop test", "Стоп теста") : Lang.s("Test on stands", "Тест на стендах"), bl3 ? Icon.PAUSE : Icon.PLAY, f8, f4, f7, f6, bl4 ? 1.0f : 0.0f, 0.0f);
        this.ihc.add(new ige(f8, f4, f7, f6, () -> {
            if (bl3) {
                RecorderHooks.stop();
                return;
            }
            Aura.useStudio(tiq2);
            Module kfe2 = Flow.getInstance().getModuleManager().getByName("KillAura");
            if (kfe2 != null && !kfe2.isEnabled()) {
                kfe2.setEnabled(true);
            }
            RecorderHooks.startTest(tiq2);
            this.close();
            if (this.iht != null) {
                this.iht.method_25419();
            }
        }, null));
        if (bl4) {
            this.iho = Lang.s("Stands come out and KillAura fights them with this model", "Выйдут стенды, KillAura будет биться с ними этой моделью");
        }
    }

    private void iiv(class_332 class_3322, float f, float f2, StudioProfiles tiq2, float f3, float f4, float f5) {
        double d;
        MineModelReader ttb2 = tiq2.mineModel();
        if (ttb2 == null) {
            boolean bl = "old".equals(tiq2.mineIssue());
            UiKit.LABEL.draw(class_3322, bl ? Lang.s("Old model: train again", "Старая модель: обучи заново") : Lang.s("Not trained yet", "Ещё не обучена"), f3, UiKit.LABEL.centerTop(f4 + 6.0f), Theme.textMuted);
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("Mine a mine yourself for 5–10 minutes, then train", "Покопай шахту сам 5–10 минут, потом обучи"), f5), f3, UiKit.SMALL.centerTop((f4 += 16.0f) + 4.0f), Theme.textMuted);
            return;
        }
        String string = new SimpleDateFormat("dd.MM HH:mm", Locale.ROOT).format(new Date(ttb2.created));
        UiKit.LABEL.draw(class_3322, Lang.s("Picks like you ", "Выбор как у тебя ") + Math.round(ttb2.top1) + "%", f3, UiKit.LABEL.centerTop(f4 + 6.0f), ttb2.top1 > ttb2.base1 + 5.0 ? Theme.accent() : Theme.text);
        UiKit.SMALL.drawRight(class_3322, string + "  ·  " + ttb2.events + Lang.s(" picks", " реш."), f3 + f5, UiKit.SMALL.centerTop(f4 + 6.0f), Theme.textMuted);
        MineStyleStats tvq2 = ttb2.style;
        this.ijp(class_3322, Lang.s("Top 3 · just the nearest", "Топ-3 · просто ближайший"), ProfilePopup.ijd(ttb2.top3) + " · " + ProfilePopup.ijd(ttb2.base1), f3, f4 += 15.0f, f5);
        this.ijp(class_3322, Lang.s("Walks like you · usual move", "Ходьба как у тебя · обычно"), ttb2.legs == null ? Lang.s("few data", "мало данных") : ProfilePopup.ijd(ttb2.legsAcc) + " · " + ProfilePopup.ijd(ttb2.legsBase), f3, f4 += 12.0f, f5);
        this.ijp(class_3322, Lang.s("Hand · overshoots you / model", "Рука · перелёты ты / модель"), Math.round(ttb2.hand.similarity) + "% · " + Math.round(ttb2.hand.overshootUser * 100.0) + "% / " + Math.round(ttb2.hand.overshootModel * 100.0) + "%", f3, f4 += 12.0f, f5);
        this.ijp(class_3322, Lang.s("You farm while working", "Твой фарм в работе"), Math.round(tvq2.activeRate) + Lang.s(" bl/min · ", " бл/мин · ") + ProfilePopup.ijw(tvq2.activeDia) + Lang.s(" dia", " алм"), f3, f4 += 12.0f, f5);
        TurnRateLimiter toq2 = AutoMines.neuroBrain();
        double d2 = d = toq2 == null || toq2.model != ttb2 ? -1.0 : toq2.rate();
        String string2 = d < 0.0 ? Lang.s("not mining yet", "ещё не копал") : Math.round(d) + Lang.s(" bl/min", " бл/мин") + (tvq2.activeRate > 0.0f ? " (" + (d >= (double)tvq2.activeRate ? "+" : "") + Math.round((d / (double)tvq2.activeRate - 1.0) * 100.0) + "%)" : "");
        this.ijp(class_3322, Lang.s("Bot now", "Бот сейчас"), string2, f3, f4 += 12.0f, f5);
        this.ijp(class_3322, Lang.s("Reaction · flick · sprint", "Реакция · флик · спринт"), (tvq2.reactionMs > 0 ? tvq2.reactionMs + Lang.s(" ms", " мс") : "—") + " · " + Math.round(tvq2.turnRate) + "°/" + Lang.s("t", "т") + " · " + Math.round(tvq2.sprintShare * 100.0f) + "%", f3, f4 += 12.0f, f5);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("checked on choices it never saw", "проверено на решениях, которых не видела"), f5), f3, UiKit.SMALL.centerTop((f4 += 12.0f) + 4.0f), Theme.textMuted);
        float f6 = 18.0f;
        boolean bl = AutoMine.minesWith(tiq2);
        boolean bl2 = UiKit.inside(f, f2, f3, f4 += 13.0f, f5, f6);
        if (bl) {
            UiKit.secondaryButton(class_3322, Lang.s("AutoMine digs with it", "AutoMine копает ей"), Icon.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                AutoMine.activateMine(null);
                this.iib(Lang.s("AutoMine is back to its own digging", "AutoMine снова копает сам"), Icon.INFO, false);
            }, null));
            if (bl2) {
                this.iho = Lang.s("Click — AutoMine goes back to the built-in digging", "Клик — вернуть AutoMine встроенное копание");
            }
        } else {
            UiKit.primaryButton(class_3322, Lang.s("Use in AutoMine", "Использовать в AutoMine"), Icon.CHECK, f3, f4, f5, f6, bl2 ? 1.0f : 0.0f, 0.0f);
            this.ihc.add(new ige(f3, f4, f5, f6, () -> {
                AutoMine.useForMine(tiq2);
                this.iib(Lang.s("AutoMine digs like you now (NeuroRotation on)", "AutoMine копает как ты (NeuroRotation включён)"), Icon.CHECK, false);
            }, null));
            if (bl2) {
                this.iho = Lang.s("AutoMine picks blocks, turns and walks with this model", "AutoMine выбирает блоки, крутит и ходит этой моделью");
            }
        }
    }

    private void iiw(StudioProfiles tiq2) {
        if (this.ihe != tiq2) {
            this.ihg = false;
            this.ihi = 0.0f;
        }
        this.ihe = tiq2;
        if (tiq2 != null) {
            tiq2.prefetch();
        }
    }

    private static String iix(StudioProfiles tiq2) {
        if (!CloudConfigs.online()) {
            return Lang.s("  ·  cloud off", "  ·  облако выкл");
        }
        if (tiq2.recordingsLoading()) {
            int n = Math.max(0, tiq2.recordingsTotal());
            return Lang.s("  ·  cloud ", "  ·  облако ") + tiq2.recordingsLoaded() + "/" + n;
        }
        int n = tiq2.recordingsTotal();
        return n < 0 ? "" : Lang.s("  ·  in cloud: ", "  ·  в облаке: ") + n + Lang.s(" rec.", " зап.");
    }

    private List<eyg> iiy(StudioProfiles tiq2) {
        ArrayList<eyg> arrayList = new ArrayList<eyg>();
        String string = tiq2.kind();
        for (eyg eyg2 : tiq2.versions()) {
            if (!string.equals(eyg2.meta().get("kind"))) continue;
            arrayList.add(eyg2);
        }
        return arrayList;
    }

    private void iiz(class_332 class_3322, float f, float f2, StudioProfiles tiq2, float f3, float f4) {
        int n = this.iiy(tiq2).size();
        tik tik2 = tiq2.cloud(tiq2.kind());
        String string = this.ihg ? Lang.s("back", "назад") : (tik2 == tik.SAVING ? Lang.s("saving · ", "сохраняю · ") : (tik2 == tik.FAILED ? Lang.s("not saved · ", "не сохранена · ") : "")) + Lang.s("versions ", "версии ") + n;
        float f5 = Math.max(16.0f, UiKit.SMALL.width(string) + 9.0f);
        boolean bl = UiKit.inside(f, f2, f3 - f5, f4 - 5.5f, f5, 11.0f);
        int n2 = tik2 == tik.FAILED && !this.ihg ? -1750963 : (this.ihg || bl ? Theme.accent() : Theme.textMuted);
        UiKit.drawChip(class_3322, string, f3, f4, n2, Theme.stroke, bl ? 1.0f : 0.0f);
        this.ihc.add(new ige(f3 - f5, f4 - 5.5f, f5, 11.0f, () -> {
            this.ihg = !this.ihg;
            this.ihi = 0.0f;
            if (this.ihg) {
                tiq2.refreshVersions(true);
            }
        }, null));
        if (bl) {
            this.iho = this.ihg ? Lang.s("Back to the model", "Назад к модели") : Lang.s("Every trained model is kept in the cloud: pick one to load, delete old ones", "Каждая обученная модель хранится в облаке: выбери и загрузи нужную, удали лишние");
        }
    }

    private void ija(class_332 class_3322, float f, float f2, StudioProfiles tiq2, float f3, float f4, float f5) {
        float f6 = this.igz + 360.0f - 16.0f - 12.0f;
        if (!CloudConfigs.online()) {
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(Lang.s("Cloud is off: start the game through the loader", "Облако недоступно: запусти игру через лоадер"), f5), f3, UiKit.SMALL.centerTop(f4 + 6.0f), Theme.textMuted);
            return;
        }
        List<eyg> list = this.iiy(tiq2);
        if (list.isEmpty()) {
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(tiq2.versionsLoading() ? Lang.s("Loading the list…", "Загружаю список…") : Lang.s("No saved versions yet: train a model", "Сохранённых версий пока нет: обучи модель"), f5), f3, UiKit.SMALL.centerTop(f4 + 6.0f), Theme.textMuted);
            return;
        }
        float f7 = 24.0f;
        float f8 = f6 - f4;
        float f9 = Math.max(0.0f, (float)list.size() * f7 - 2.0f - f8);
        this.ihi = Math.min(this.ihi, f9);
        this.ihh += (this.ihi - this.ihh) * 0.35f;
        String string = tiq2.activeKey(tiq2.kind());
        DrawUtil.pushScissor(class_3322, f3 - 2.0f, f4, f5 + 4.0f, f8);
        float f10 = Theme.r(5.0f);
        for (int i = 0; i < list.size(); ++i) {
            long l;
            eyg eyg2 = list.get(i);
            float f11 = f4 + (float)i * f7 - this.ihh;
            if (f11 + f7 < f4 || f11 > f6) continue;
            boolean bl = tiq2.ownVersion(eyg2);
            boolean bl2 = bl && eyg2.key().equals(string);
            boolean bl3 = UiKit.inside(f, f2, f3, f11, f5, f7 - 2.0f) && UiKit.inside(f, f2, f3, f4, f5, f8);
            int n = bl2 ? ColorUtil.lerp(Theme.field, Theme.accent(), 0.16f) : Theme.field;
            DrawUtil.round(class_3322, f3, f11, f5, f7 - 2.0f, f10, bl3 ? ColorUtil.lerp(n, Theme.fieldHover, 0.5f) : n);
            if (bl2) {
                DrawUtil.outline(class_3322, f3, f11, f5, f7 - 2.0f, f10, 1.0f, Theme.accent(180));
            }
            try {
                l = Long.parseLong(eyg2.meta().getOrDefault("created", "0"));
            }
            catch (NumberFormatException numberFormatException) {
                l = 0L;
            }
            if (l <= 0L) {
                l = eyg2.uploaded() * 1000L;
            }
            String string2 = new SimpleDateFormat("dd.MM HH:mm", Locale.ROOT).format(new Date(l));
            String string3 = bl ? "" : Lang.s("  ·  from ", "  ·  из ") + eyg2.meta().getOrDefault("profile", "?");
            float f12 = 52.0f;
            float f13 = f5 - f12 - 30.0f;
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string2 + string3, f13), f3 + 6.0f, UiKit.SMALL.centerTop(f11 + 7.0f), bl2 ? Theme.accent() : Theme.text);
            UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(ProfilePopup.ijb(eyg2) + "  ·  " + Math.max(1, Math.round((float)eyg2.size() / 1024.0f)) + Lang.s(" KB", " КБ"), f13), f3 + 6.0f, UiKit.SMALL.centerTop(f11 + 16.0f), Theme.textMuted);
            float f14 = f3 + f5 - f12 - (bl ? 22.0f : 4.0f);
            float f15 = f11 + 4.0f;
            if (bl2) {
                UiKit.drawChip(class_3322, Lang.s("in use", "используется"), f14 + f12, f11 + 11.0f, Theme.accent(), Theme.stroke, 0.0f);
            } else {
                boolean bl4 = UiKit.inside(f, f2, f14, f15, f12, 14.0f) && UiKit.inside(f, f2, f3, f4, f5, f8);
                UiKit.secondaryButton(class_3322, Lang.s("Load", "Загрузить"), null, f14, f15, f12, 14.0f, bl4 ? 1.0f : 0.0f, 0.0f);
                if (f11 >= f4 - 1.0f && f11 + f7 <= f6 + 1.0f) {
                    this.ihc.add(new ige(f14, f15, f12, 14.0f, () -> {
                        tiq2.useVersion(eyg2);
                        this.iib(Lang.s("Loading this version…", "Загружаю эту версию…"), Icon.REFRESH, false);
                    }, null));
                }
                if (bl4) {
                    String string4 = this.iho = bl ? Lang.s("Use this version of the model", "Использовать эту версию модели") : Lang.s("Copy this model into this profile and use it", "Скопировать эту модель в профиль и использовать");
                }
            }
            if (!bl) continue;
            float f16 = f3 + f5 - 18.0f;
            boolean bl5 = eyg2.key().equals(this.ihl) && System.currentTimeMillis() - this.ihm < 3000L;
            boolean bl6 = UiKit.inside(f, f2, f16, f15, 14.0f, 14.0f) && UiKit.inside(f, f2, f3, f4, f5, f8);
            UiKit.iconButton(class_3322, Icon.TRASH, f16, f15, 14.0f, bl6 ? 1.0f : 0.0f, bl5, 1.0f);
            if (f11 >= f4 - 1.0f && f11 + f7 <= f6 + 1.0f) {
                this.ihc.add(new ige(f16, f15, 14.0f, 14.0f, () -> {
                    if (!eyg2.key().equals(this.ihl) || System.currentTimeMillis() - this.ihm > 3000L) {
                        this.ihl = eyg2.key();
                        this.ihm = System.currentTimeMillis();
                        return;
                    }
                    this.ihl = null;
                    tiq2.deleteVersion(eyg2);
                    this.iib(Lang.s("Version deleted", "Версия удалена"), Icon.TRASH, false);
                }, null));
            }
            if (!bl6) continue;
            this.iho = bl5 ? Lang.s("Click again to delete it from the cloud", "Ещё клик — удалить из облака") : Lang.s("Delete this version", "Удалить эту версию");
        }
        DrawUtil.popScissor(class_3322);
    }

    private static String ijb(eyg eyg2) {
        Map<String, String> map = eyg2.meta();
        if ("walk".equals(map.get("kind"))) {
            return Lang.s("keys ", "клавиши ") + map.getOrDefault("keys", "?") + "%  ·  " + Lang.s("turns ", "поворот ") + map.getOrDefault("turn", "?") + "%";
        }
        if ("mine".equals(map.get("kind"))) {
            String string = map.getOrDefault("legs", "");
            String string2 = map.getOrDefault("boost", "0");
            return Lang.s("picks ", "выбор ") + map.getOrDefault("top1", "?") + "%  ·  " + Lang.s("hand ", "рука ") + map.getOrDefault("hand", "?") + "%" + (string.isEmpty() ? "" : "  ·  " + Lang.s("walk ", "ходьба ") + string + "%") + ("0".equals(string2) ? "" : "  ·  +" + string2 + "%");
        }
        return Lang.s("similarity ", "сходство ") + map.getOrDefault("similarity", "?") + "%";
    }

    private void ijc(class_332 class_3322, String string, String string2, double d, double d2, float f, float f2, float f3) {
        UiKit.SMALL.draw(class_3322, string + "  " + string2, f, UiKit.SMALL.centerTop(f2 + 5.0f), Theme.textDim);
        String string3 = Double.isNaN(d2) ? "" : Lang.s("  ceiling ", "  потолок ") + ProfilePopup.ijd(d2);
        float f4 = UiKit.SMALL.width(string3);
        UiKit.SMALL.drawRight(class_3322, string3, f + f3, UiKit.SMALL.centerTop(f2 + 5.0f), Theme.textMuted);
        int n = d >= 90.0 ? Theme.accent() : Theme.text;
        UiKit.LABEL.drawRight(class_3322, ProfilePopup.ijd(d), f + f3 - f4, UiKit.LABEL.centerTop(f2 + 5.0f), n);
    }

    private static String ijd(double d) {
        return Double.isNaN(d) ? "—" : Math.round(d) + "%";
    }

    private void ije(StudioProfiles tiq2) {
        long l = System.currentTimeMillis();
        if (l - this.ihr > 3000L) {
            this.ihr = l;
            return;
        }
        this.ihr = 0L;
        if (RecorderHooks.sessionProfile() == tiq2) {
            RecorderHooks.stop();
        }
        try {
            tiq2.clearRecordings();
            this.iib(Lang.s("Recordings deleted", "Записи удалены"), Icon.TRASH, false);
        }
        catch (IOException iOException) {
            this.iib(Lang.s("Can't delete them", "Не получилось удалить"), Icon.CLOSE, true);
        }
    }

    private static void ijf(StudioProfiles tiq2, int n) {
        int[] nArray = StudioProfiles.BOOSTS;
        int n2 = 0;
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != tiq2.mineBoost()) continue;
            n2 = i;
        }
        tiq2.set("mine.boost", nArray[(n2 + n + nArray.length) % nArray.length]);
        tiq2.save();
    }

    private static void ijg(StudioProfiles tiq2, String string, int n) {
        tiq2.set(string, n);
        tiq2.save();
    }

    private static void ijh(StudioProfiles tiq2, String string, double d) {
        tiq2.set(string, (double)Math.round(d * 100.0) / 100.0);
        tiq2.save();
    }

    private static void iji(StudioProfiles tiq2, double d) {
        double d2 = Math.max(2.6, Math.min(6.5, tiq2.standFar() + d));
        tiq2.set("stands.far", (double)Math.round(d2 * 10.0) / 10.0);
        tiq2.set("stands.near", (double)Math.round(Math.max(2.0, d2 - 1.2) * 10.0) / 10.0);
        tiq2.save();
    }

    private static void ijj(StudioProfiles tiq2, String string, String[] stringArray, String string2, int n) {
        int n2 = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].equals(string2)) continue;
            n2 = i;
        }
        tiq2.set(string, stringArray[(n2 + n + stringArray.length) % stringArray.length]);
        tiq2.save();
    }

    /*
     * Exception decompiling
     */
    private static String ijk(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private static String ijl(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private static String ijm(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private float ijn(class_332 class_3322, String string, float f, float f2) {
        UiKit.SECTION.draw(class_3322, string.toUpperCase(Locale.ROOT), f, UiKit.SECTION.centerTop(f2 + 5.0f), Theme.textMuted);
        return f2 + 12.0f;
    }

    private void ijo(class_332 class_3322, String string, String string2, float f, float f2, float f3, boolean bl) {
        float f4 = 26.0f;
        DrawUtil.round(class_3322, f, f2, f3, f4, Theme.r(6.0f), Theme.field);
        UiKit.CARD_TITLE.draw(class_3322, string2, f + 7.0f, UiKit.CARD_TITLE.centerTop(f2 + 9.0f), bl ? Theme.accent() : Theme.text);
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, f3 - 10.0f), f + 7.0f, UiKit.SMALL.centerTop(f2 + 19.5f), Theme.textMuted);
    }

    private void ijp(class_332 class_3322, String string, String string2, float f, float f2, float f3) {
        UiKit.SMALL.draw(class_3322, string, f, UiKit.SMALL.centerTop(f2 + 5.0f), Theme.textDim);
        UiKit.SMALL.drawRight(class_3322, string2, f + f3, UiKit.SMALL.centerTop(f2 + 5.0f), Theme.text);
    }

    private void ijq(class_332 class_3322, float f, float f2, String string, boolean bl, float f3, float f4, float f5, Runnable runnable, String string2) {
        boolean bl2 = UiKit.inside(f, f2, f3, f4, f5, 16.0f);
        UiKit.LABEL.draw(class_3322, UiKit.LABEL.ellipsize(string, f5 - 17.0f - 6.0f), f3, UiKit.LABEL.centerTop(f4 + 8.0f), bl2 ? Theme.text : Theme.textDim);
        UiKit.drawSwitch(class_3322, f3 + f5 - 17.0f, f4 + 3.25f, bl ? 1.0f : 0.0f, bl2 ? 1.0f : 0.0f);
        this.ihc.add(new ige(f3, f4, f5, 16.0f, runnable, null));
        if (bl2) {
            this.iho = string2;
        }
    }

    private void ijr(class_332 class_3322, float f, float f2, String string, String string2, float f3, float f4, float f5, Runnable runnable, Runnable runnable2, String string3) {
        boolean bl = UiKit.inside(f, f2, f3, f4, f5, 16.0f);
        UiKit.LABEL.draw(class_3322, string, f3, UiKit.LABEL.centerTop(f4 + 8.0f), bl ? Theme.text : Theme.textDim);
        String string4 = string2 + "  ›";
        UiKit.drawChip(class_3322, string4, f3 + f5, f4 + 8.0f, Theme.text, Theme.stroke, bl ? 1.0f : 0.0f);
        this.ihc.add(new ige(f3, f4, f5, 16.0f, runnable, runnable2));
        if (bl) {
            this.iho = string3 + Lang.s("  ·  right click — back", "  ·  ПКМ — назад");
        }
    }

    private void ijs(class_332 class_3322, float f, float f2, String string, String string2, float f3, float f4, float f5, Runnable runnable, Runnable runnable2, String string3) {
        UiKit.LABEL.draw(class_3322, string, f3, UiKit.LABEL.centerTop(f4 + 8.0f), Theme.textDim);
        float f6 = 12.0f;
        float f7 = Math.max(22.0f, UiKit.VALUE.width(string2) + 6.0f);
        float f8 = f3 + f5 - f6;
        float f9 = f8 - f7;
        float f10 = f9 - f6;
        float f11 = f4 + (16.0f - f6) * 0.5f;
        boolean bl = UiKit.inside(f, f2, f10, f11, f6, f6);
        boolean bl2 = UiKit.inside(f, f2, f8, f11, f6, f6);
        DrawUtil.round(class_3322, f10, f11, f6, f6, Theme.r(3.0f), bl ? Theme.fieldHover : Theme.field);
        DrawUtil.round(class_3322, f8, f11, f6, f6, Theme.r(3.0f), bl2 ? Theme.fieldHover : Theme.field);
        UiKit.VALUE.drawCentered(class_3322, "-", f10 + f6 * 0.5f, UiKit.VALUE.centerTop(f11 + f6 * 0.5f), bl ? Theme.text : Theme.textDim);
        IconRenderer.draw(class_3322, Icon.PLUS, f8 + f6 * 0.5f, f11 + f6 * 0.5f, 6.0f, bl2 ? Theme.text : Theme.textDim);
        UiKit.VALUE.drawCentered(class_3322, string2, f9 + f7 * 0.5f, UiKit.VALUE.centerTop(f11 + f6 * 0.5f), Theme.text);
        this.ihc.add(new ige(f10, f11, f6, f6, runnable, null));
        this.ihc.add(new ige(f8, f11, f6, f6, runnable2, null));
        if (UiKit.inside(f, f2, f3, f4, f5, 16.0f)) {
            this.iho = string3;
        }
    }

    private void ijt(class_332 class_3322, float[] fArray, float f, float f2, float f3, float f4) {
        float f5;
        int n;
        DrawUtil.round(class_3322, f, f2, f3, f4, Theme.r(4.0f), Theme.field);
        if (fArray.length < 2) {
            return;
        }
        float f6 = Float.MAX_VALUE;
        float f7 = -3.4028235E38f;
        float[] fArray2 = fArray;
        int n2 = fArray2.length;
        for (n = 0; n < n2; ++n) {
            f5 = fArray2[n];
            if (!Float.isFinite(f5)) continue;
            f6 = Math.min(f6, f5);
            f7 = Math.max(f7, f5);
        }
        if (!(f7 > f6)) {
            f7 = f6 + 1.0f;
        }
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (n = 0; n < fArray.length; ++n) {
            f5 = f + 3.0f + (f3 - 6.0f) * (float)n / ((float)fArray.length - 1.0f);
            float f10 = f2 + 3.0f + (f4 - 6.0f) * (1.0f - (fArray[n] - f6) / (f7 - f6));
            if (n > 0) {
                DrawUtil.line(class_3322, f8, f9, f5, f10, 1.2f, Theme.accent());
            }
            f8 = f5;
            f9 = f10;
        }
    }

    private void iju(class_332 class_3322) {
        boolean bl;
        float f = this.igz + 360.0f - 8.0f - 5.0f;
        DrawUtil.rect(class_3322, this.igy + 12.0f, this.igz + 360.0f - 16.0f - 8.0f, 486.0f, 1.0f, Theme.divider);
        boolean bl2 = this.ihe != null && this.ihe.aura();
        boolean bl3 = this.ihe != null && this.ihe.mine();
        boolean bl4 = bl = this.ihe != null && this.ihe.walk();
        String string = this.iho != null ? this.iho : (bl ? Lang.s("Record → train → AutoEnd / AutoWarden. You walk the drawn route, the model learns how you walk", "Запись → обучение → AutoEnd / AutoWarden. Идёшь по нарисованному маршруту, модель учит как ты ходишь") : (bl3 ? Lang.s("Record → train → AutoMine. Learns what you break, how you turn and how you walk", "Запись → обучение → AutoMine. Учит что ты ломаешь, как крутишь камеру и как ходишь") : (bl2 ? Lang.s("Record → train → KillAura. Every tick near a target is learned; similarity per axis X / Y", "Запись → обучение → KillAura. Учится каждый тик рядом с целью; сходство по осям X / Y") : Lang.s("Record → train → use. Only aiming that ended in a hit is learned, misses are dropped", "Запись → обучение → использовать. Учится только наведение, которое закончилось ударом, промахи отсеиваются"))));
        UiKit.SMALL.draw(class_3322, UiKit.SMALL.ellipsize(string, 486.0f), this.igy + 12.0f, UiKit.SMALL.centerTop(f), this.iho != null ? Theme.text : Theme.textMuted);
    }

    private static String ijv(long l) {
        return l / 60L + ":" + String.format(Locale.ROOT, "%02d", l % 60L);
    }

    private static String ijw(double d) {
        return String.format(Locale.ROOT, "%.1f", d);
    }

    private static String ijx(double d) {
        return String.format(Locale.ROOT, "%.3f", d);
    }

    @Override
    boolean mouseClicked(ClickGuiScreen hlc2, float f, float f2, int n) {
        if (this.ihn) {
            return true;
        }
        if (!UiKit.inside(f, f2, this.igy, this.igz, 510.0f, 360.0f)) {
            this.close();
            return true;
        }
        if (this.igx.mouseClicked(hlc2, f, f2, n)) {
            return true;
        }
        hlc2.focus(null);
        for (int i = this.ihc.size() - 1; i >= 0; --i) {
            Runnable runnable;
            ige ige2 = this.ihc.get(i);
            if (!UiKit.inside(f, f2, ige2.x(), ige2.y(), ige2.w(), ige2.h())) continue;
            Runnable runnable2 = n == 1 ? ige2.right() : (runnable = n == 0 ? ige2.left() : null);
            if (runnable == null) continue;
            runnable.run();
            return true;
        }
        return true;
    }

    @Override
    void scrolled(double d) {
        if (this.ihg && this.ihj > this.igy + 12.0f + 146.0f + 10.0f) {
            this.ihi = Math.max(0.0f, this.ihi - (float)d * 22.0f);
            return;
        }
        this.ihf = Math.max(0.0f, Math.min(this.iih(), this.ihf - (float)d * 34.0f));
    }

    @Override
    boolean keyPressed(ClickGuiScreen hlc2, int n, int n2) {
        if (n == 256) {
            if (hlc2.focusedField() == this.igx && !this.igx.text.isEmpty()) {
                this.igx.setText("");
            } else {
                this.close();
            }
            return true;
        }
        if (hlc2.focusedField() == this.igx) {
            this.igx.keyPressed(hlc2, n, n2);
            return true;
        }
        return true;
    }

    private static /* synthetic */ void lambda$trainerJob$33(StudioProfiles tiq2) {
        AutoMine.activate(tiq2);
    }

    private /* synthetic */ void lambda$trainerJob$32(StudioProfiles tiq2) {
        RecorderHooks.train(tiq2);
        this.ihs = null;
    }

    private /* synthetic */ void lambda$list$2(StudioProfiles tiq2) {
        this.iiw(tiq2);
        if (tiq2.aura()) {
            Aura.useStudio(tiq2);
        } else if (tiq2.walk()) {
            AutoMine.useForWalk(tiq2);
        } else if (tiq2.mine()) {
            AutoMine.useForMine(tiq2);
        } else {
            AutoMine.activate(tiq2);
        }
    }

    private /* synthetic */ void lambda$list$1(StudioProfiles tiq2) {
        this.iiw(tiq2);
    }

    private /* synthetic */ void lambda$list$0(StudioProfiles tiq2) {
        this.iij(tiq2);
    }

    private static /* synthetic */ int agm(int n, int n2) {
        return n - n2 ^ 0xFF26975C;
    }
}

