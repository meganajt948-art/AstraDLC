/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_10584
 *  net.minecraft.class_12125
 *  net.minecraft.class_12239
 *  net.minecraft.class_12392
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1269$class_9857
 *  net.minecraft.class_1269$class_9860
 *  net.minecraft.class_1269$class_9861
 *  net.minecraft.class_1297
 *  net.minecraft.class_1306
 *  net.minecraft.class_1309
 *  net.minecraft.class_1542
 *  net.minecraft.class_156
 *  net.minecraft.class_1657
 *  net.minecraft.class_1659
 *  net.minecraft.class_1664
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2535
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2818
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2915
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_345
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_4066
 *  net.minecraft.class_437
 *  net.minecraft.class_4844
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_6368
 *  net.minecraft.class_6370
 *  net.minecraft.class_638
 *  net.minecraft.class_639
 *  net.minecraft.class_640
 *  net.minecraft.class_642
 *  net.minecraft.class_642$class_643
 *  net.minecraft.class_642$class_8678
 *  net.minecraft.class_746
 *  net.minecraft.class_8038
 *  net.minecraft.class_8697
 *  net.minecraft.class_8791
 *  net.minecraft.class_9099
 *  net.minecraft.class_9209
 *  net.minecraft.class_9334
 *  net.minecraft.class_9836
 */
package a;

import a.dtn;
import a.dts;
import a.BotCamera;
import a.MapCaptchaDetector;
import a.ech;
import a.BotChatLog;
import a.BotConnection;
import a.ClientContextSwitcher;
import a.BotRemoteInput;
import a.BotHost;
import a.BotLoginHandler;
import a.BotManager;
import a.ResourcePackSimulator;
import a.BotPlayHandler;
import a.BotMinimap;
import a.BotRuntime;
import a.Hud;
import a.ModuleManager;
import a.AncientFarmer;
import a.AutoEnd;
import a.AutoMines;
import a.AutoWarden;
import a.InstanceQueue;
import a.MouseQuantizer;
import a.pth;
import a.Icon;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_10584;
import net.minecraft.class_12125;
import net.minecraft.class_12239;
import net.minecraft.class_12392;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1306;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1659;
import net.minecraft.class_1664;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2535;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2818;
import net.minecraft.class_2846;
import net.minecraft.class_2915;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_345;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_4066;
import net.minecraft.class_437;
import net.minecraft.class_4844;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_6368;
import net.minecraft.class_6370;
import net.minecraft.class_638;
import net.minecraft.class_639;
import net.minecraft.class_640;
import net.minecraft.class_642;
import net.minecraft.class_746;
import net.minecraft.class_8038;
import net.minecraft.class_8697;
import net.minecraft.class_8791;
import net.minecraft.class_9099;
import net.minecraft.class_9209;
import net.minecraft.class_9334;
import net.minecraft.class_9836;

public final class Bot
implements BotHost {
    private static final class_310 dtw;
    private static final long dtx = 50000000L;
    private static final long dty = 6000000L;
    private static final String dtz;
    private static final Pattern dua;
    private static final double dub = 2304.0;
    private static final double[] duc;
    private final String dud;
    private final UUID due;
    private final Random duf = new Random();
    private final double dug;
    volatile String address;
    private volatile dts duh = dts.OFFLINE;
    private volatile String dui = "";
    private volatile long duj = System.currentTimeMillis();
    volatile BotConnection connection;
    private volatile boolean duk;
    private volatile boolean dul;
    BotPlayHandler handler;
    class_746 player;
    class_638 world;
    class_636 interaction;
    class_437 screen;
    class_239 crosshair;
    class_1297 targeted;
    class_1297 camera;
    boolean[] keyPressed = new boolean[0];
    int[] keyTimes = new int[0];
    final Map<UUID, class_345> bossBars = new LinkedHashMap<UUID, class_345>();
    final pth silent = new pth();
    volatile Object[] fabricAddons;
    final BotChatLog chat = new BotChatLog();
    final ResourcePackSimulator packs = new ResourcePackSimulator();
    final BotRemoteInput control = new BotRemoteInput();
    final MapCaptchaDetector captcha = new MapCaptchaDetector(this);
    private final ArrayDeque<Runnable> dum = new ArrayDeque();
    private final List<dtn> dun = new ArrayList<dtn>();
    private volatile boolean duo;
    private long dup;
    class_2561 tabHeader;
    class_2561 tabFooter;
    class_2561 serverLabel;
    private class_2561 duq;
    private long dur;
    private class_2561 dus;
    private class_2561 dut;
    private long duu;
    private String duv;
    private final AutoEnd duw;
    private boolean dux;
    private final AutoWarden duy;
    private boolean duz;
    private final AutoMines dva;
    private boolean dvb;
    private final AncientFarmer dvc;
    private boolean dvd;
    private final BotCamera dve = new BotCamera(this);
    private int dvf;
    private int dvg;
    private int dvh;
    private int dvi = 35;
    private int dvj;
    int itemUseCooldown;
    private long dvk;
    private int dvl;
    private long dvm;
    private float dvn;
    private long dvo;
    private float dvp;
    private volatile long dvq;
    private String dvr;
    private long dvs;
    private boolean dvt = true;
    private boolean dvu;
    private long dvv;
    private String dvw;
    private int dvx = -1;
    private long dvy;
    private int dvz = -1;
    private final BotMinimap dwa = new BotMinimap(this);
    private static /* synthetic */ long dwb;
    private static /* synthetic */ boolean dwc;

    Bot(String string, String string2) {
        AutoMines nfl2;
        this.dud = string;
        this.due = class_4844.method_43344((String)string);
        this.address = string2;
        this.dug = duc[this.duf.nextInt(duc.length)];
        this.duw = new AutoEnd();
        this.duw.attachBot(this);
        AutoEnd mpq2 = Bot.dwe();
        if (mpq2 != null) {
            this.duw.copySettingsFrom(mpq2);
        }
        this.duy = new AutoWarden();
        this.duy.attachBot(this);
        AutoWarden nxa2 = Bot.dwf();
        if (nxa2 != null) {
            this.duy.copySettingsFrom(nxa2);
        }
        this.dva = new AutoMines();
        this.dva.attachBot(this);
        ModuleManager kfx2 = Bot.dwd();
        AutoMines nfl3 = nfl2 = kfx2 == null ? null : kfx2.get(AutoMines.class);
        if (nfl2 != null && !nfl2.isBotInstance()) {
            this.dva.copySettingsFrom(nfl2);
        }
        this.dvc = new AncientFarmer();
        this.dvc.attachBot(this);
        AncientFarmer lqq2 = AncientFarmer.get();
        if (lqq2 != null && lqq2 != this.dvc) {
            this.dvc.copySettingsFrom(lqq2);
        }
    }

    double sensitivity() {
        return this.dug;
    }

    private static ModuleManager dwd() {
        Flow flow = Flow.getInstance();
        return flow == null ? null : flow.getModuleManager();
    }

    private static AutoEnd dwe() {
        ModuleManager kfx2 = Bot.dwd();
        AutoEnd mpq2 = kfx2 == null ? null : kfx2.get(AutoEnd.class);
        return mpq2 == null || mpq2.isBotInstance() ? null : mpq2;
    }

    private static AutoWarden dwf() {
        ModuleManager kfx2 = Bot.dwd();
        AutoWarden nxa2 = kfx2 == null ? null : kfx2.get(AutoWarden.class);
        return nxa2 == null || nxa2.isBotInstance() ? null : nxa2;
    }

    public void connect() {
        if (this.connection != null || this.dul) {
            return;
        }
        this.duk = false;
        this.dvu = false;
        this.dvv = 0L;
        if (!BotManager.get().tryStartJoin(this)) {
            this.dvv = System.currentTimeMillis() + 1200L + (long)this.duf.nextInt(1300);
            this.dxa(dts.QUEUED, "в очереди на вход");
            return;
        }
        this.dul = true;
        this.dxa(dts.CONNECTING, "подключение");
        String string = this.address;
        class_156.method_27958().execute(() -> this.dwg(string));
    }

    boolean isJoining() {
        return this.dul || this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.JOINING;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dwg(String string) {
        try {
            class_639 class_6392 = class_639.method_2950((String)string);
            Optional<InetSocketAddress> optional = class_6370.field_33745.method_36907(class_6392).map(class_6368::method_36902);
            if (optional.isEmpty()) {
                this.dwh("сервер не найден");
                return;
            }
            InetSocketAddress inetSocketAddress = optional.get();
            BotConnection edb2 = new BotConnection(this);
            class_2535.method_52271((InetSocketAddress)inetSocketAddress, (class_12239)class_12239.method_75867((boolean)Bot.dtw.field_1690.method_1639()), (class_2535)edb2).syncUninterruptibly();
            Bot dtv2 = this;
            synchronized (dtv2) {
                this.dul = false;
                if (this.duk) {
                    edb2.method_10747((class_2561)class_2561.method_43471((String)"multiplayer.status.quitting"));
                    this.dxa(dts.OFFLINE, "отключён");
                    return;
                }
                this.connection = edb2;
            }
            edb2.method_56326(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), class_9099.field_48247, class_9099.field_48248, (class_8697)new BotLoginHandler(this, edb2), false);
            edb2.method_10743((class_2596)new class_2915(this.dud, this.due));
            this.dxa(dts.LOGIN, "вход");
        }
        catch (Throwable throwable) {
            Throwable throwable2 = throwable.getCause() != null ? throwable.getCause() : throwable;
            this.dwh(throwable2.getMessage() == null ? throwable2.getClass().getSimpleName() : throwable2.getMessage());
        }
    }

    private void dwh(String string) {
        this.dul = false;
        this.connection = null;
        this.dxa(dts.FAILED, string);
        dtw.execute(() -> {
            this.chat.system("Не удалось подключиться: " + string);
            this.dwi();
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void disconnect() {
        this.dvu = true;
        this.dvv = 0L;
        Object object = this;
        synchronized (object) {
            this.duk = true;
        }
        object = this.connection;
        if (object == null) {
            if (this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.QUEUED) {
                this.dxa(dts.OFFLINE, "отключён");
            }
            return;
        }
        object.method_10747((class_2561)class_2561.method_43471((String)"multiplayer.status.quitting"));
    }

    class_642 serverInfo() {
        class_642 class_6422 = new class_642(this.dud, this.address, class_642.class_8678.field_45611);
        class_6422.method_2995(class_642.class_643.field_3768);
        return class_6422;
    }

    class_8791 syncedOptions() {
        int n = 0;
        for (class_1664 class_16642 : class_1664.values()) {
            n |= class_16642.method_7430();
        }
        String string = Bot.dtw.field_1690 == null ? "en_us" : Bot.dtw.field_1690.field_1883;
        return new class_8791(string, BotManager.get().getViewDistance(), class_1659.field_7538, true, n, class_1306.field_6183, false, true, class_4066.field_18197);
    }

    void onLoginSuccess(GameProfile gameProfile) {
        this.duo = true;
        this.dxa(dts.JOINING, "загрузка мира");
    }

    void onPlayHandler(BotPlayHandler ehy2) {
        this.handler = ehy2;
    }

    void onJoinWorld(class_638 class_6382, class_746 class_7462) {
        this.dve.reset();
        this.dvf = 0;
        this.dvg = 0;
        this.dvh = 0;
        this.bossBars.clear();
        this.dwa.reset();
        boolean bl = this.duo;
        if (bl) {
            this.duo = false;
            this.captcha.arm();
        } else {
            this.captcha.reset();
        }
        this.dxa(dts.ONLINE, "в игре");
        if (!bl) {
            this.dvy = this.dvw == null ? 0L : System.currentTimeMillis() + 15000L;
            return;
        }
        this.chat.system("Зашёл на сервер");
        this.notifyHud("вошёл", true);
        if (this.dvw != null) {
            this.dvx = 30 + this.duf.nextInt(40);
        } else if (this.dux || this.duz || this.dvb || this.dvd) {
            this.dvz = 100 + this.duf.nextInt(80);
        }
    }

    void onRespawn(class_638 class_6382, class_746 class_7462, boolean bl) {
        this.dvf = 0;
        this.dvg = 0;
        this.dvh = 0;
        if (bl) {
            this.dwa.reset();
            this.captcha.reset();
            this.dve.reset();
        }
    }

    void onReconfigure() {
        Bot.dtw.field_1724 = null;
        Bot.dtw.field_1687 = null;
        Bot.dtw.field_1761 = null;
        Bot.dtw.field_1755 = null;
        ClientContextSwitcher.camera(null);
        Bot.dtw.field_1765 = null;
        Bot.dtw.field_1692 = null;
        this.handler = null;
        this.bossBars.clear();
        this.dxa(dts.JOINING, "переконфигурация");
    }

    void onChunksComing() {
        if (this.dvf == 0) {
            this.dvf = 1;
        }
    }

    void tickLoading(BotPlayHandler ehy2) {
        boolean bl;
        class_746 class_7462 = Bot.dtw.field_1724;
        class_638 class_6382 = Bot.dtw.field_1687;
        if (class_7462 == null || class_6382 == null || ehy2.method_76760()) {
            return;
        }
        if (this.dvf == 0 && ++this.dvg > 100) {
            this.dvf = 1;
        }
        if (this.dvf != 1) {
            return;
        }
        class_2338 class_23382 = class_7462.method_24515();
        boolean bl2 = bl = class_6382.method_31601(class_23382.method_10264()) || class_6382.method_2935().method_12126(class_23382.method_10263() >> 4, class_23382.method_10260() >> 4, false) != null || class_7462.method_7325() || !class_7462.method_5805();
        if (bl) {
            this.dvf = 2;
            ehy2.markLoaded();
        }
    }

    void onServerMessage(class_2561 class_25612, boolean bl) {
        this.onServerMessage(class_25612, bl, false);
    }

    void onLocalMessage(class_2561 class_25612, boolean bl) {
        if (class_25612 == null) {
            return;
        }
        if (bl) {
            this.duq = class_25612;
            this.dur = System.currentTimeMillis();
            return;
        }
        this.chat.server(class_25612, false);
    }

    void onServerMessage(class_2561 class_25612, boolean bl, boolean bl2) {
        if (class_25612 == null) {
            return;
        }
        if (bl) {
            this.duq = class_25612;
            this.dur = System.currentTimeMillis();
            return;
        }
        this.chat.server(class_25612, bl2);
        this.captcha.onHint(class_25612.getString());
        if (bl2) {
            return;
        }
        if (this.dvy != 0L) {
            if (System.currentTimeMillis() > this.dvy) {
                this.dvy = 0L;
            } else {
                String string = class_25612.getString().toLowerCase(Locale.ROOT);
                if (string.contains("/login") || string.contains("/l ") || string.contains("авторизуй") || string.contains("войдите")) {
                    this.dvy = 0L;
                    this.dvx = 20 + this.duf.nextInt(30);
                }
            }
        }
        if (this.duw.isEnabled()) {
            try {
                this.duw.onChatMessage(class_25612.getString());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dva.isEnabled()) {
            try {
                this.dva.onChat(class_25612);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dvc.isEnabled()) {
            try {
                this.dvc.onChat(class_25612);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    void onTitle(class_2561 class_25612, boolean bl) {
        if (class_25612 == null) {
            this.dus = null;
            this.dut = null;
            return;
        }
        if (bl) {
            this.dut = class_25612;
        } else {
            this.dus = class_25612;
        }
        this.duu = System.currentTimeMillis();
    }

    void onTotemPop() {
        this.chat.system("Сработал тотем");
        this.notifyHud("тотем", false);
    }

    void onDeath(class_2561 class_25612) {
        this.chat.system("Смерть: " + (class_25612 == null ? "" : class_25612.getString()));
        this.notifyHud("умер", false);
    }

    void onScreenOpened(class_2561 class_25612) {
        this.duv = class_25612 == null ? null : class_25612.getString();
    }

    void onChunkLoaded(class_2818 class_28182) {
        this.dwa.onChunk(class_28182);
    }

    void onMapUpdated(class_9209 class_92092) {
        this.dwa.onMap(class_92092);
        this.captcha.onMap();
    }

    void onCaptcha() {
        this.chat.system("Капча на входе: картинка и поле для кода - в окне бота");
        this.notifyHud("капча - нужен код", false);
    }

    void onCaptchaGone() {
        this.chat.system("Картинка капчи пропала");
    }

    void onCaptchaSolved(String string) {
        this.chat.system("Капча прочитана сетью: " + string);
        this.notifyHud("капча: " + string, true);
        this.sendChat(string);
    }

    void onCaptchaUnsolved(String string) {
        this.chat.system("Капча не прочиталась (" + string + ") - введи код в окне бота");
    }

    void onPacketReceived() {
        this.dvq = System.currentTimeMillis();
    }

    void beforePacket(class_2596<?> class_25962) {
        if (class_25962 instanceof class_8038) {
            class_8038 class_80382 = (class_8038)class_25962;
            for (class_2596 class_25963 : class_80382.method_48324()) {
                this.beforePacket(class_25963);
            }
            return;
        }
        if (this.duy.isEnabled()) {
            try {
                this.duy.onPacket(class_25962);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dvc.isEnabled()) {
            try {
                this.dvc.onPacket(class_25962);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dva.isEnabled()) {
            try {
                this.dva.onPacket(class_25962);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    void onPacketError(class_2596<?> class_25962, Throwable throwable) {
        if (this.dwk()) {
            this.chat.system("Ошибка пакета " + class_25962.getClass().getSimpleName() + ": " + throwable);
            if (Boolean.getBoolean("flow2.selftest")) {
                throwable.printStackTrace(System.out);
            }
        }
    }

    void onDisconnected(class_2561 class_25612) {
        boolean bl;
        boolean bl2 = bl = this.duh == dts.ONLINE;
        if (this.duw.isEnabled()) {
            try {
                this.duw.setBotRunning(false);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.duy.isEnabled()) {
            try {
                this.duy.setBotRunning(false);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dva.isEnabled()) {
            try {
                this.dva.setEnabledSilently(false);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dvc.isEnabled()) {
            try {
                this.dvc.setBotRunning(false);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (BotRuntime.current() == this) {
            Bot.dtw.field_1724 = null;
            Bot.dtw.field_1687 = null;
            Bot.dtw.field_1761 = null;
            Bot.dtw.field_1755 = null;
            ClientContextSwitcher.camera(null);
            Bot.dtw.field_1765 = null;
            Bot.dtw.field_1692 = null;
        }
        this.player = null;
        this.world = null;
        this.interaction = null;
        this.screen = null;
        this.camera = null;
        this.handler = null;
        this.connection = null;
        this.bossBars.clear();
        this.packs.clear();
        this.dum.clear();
        this.dun.clear();
        this.control.release();
        this.dwa.reset();
        this.captcha.reset();
        this.dve.reset();
        InstanceQueue.leave(this);
        this.dvr = null;
        String string = class_25612 == null ? "" : class_25612.getString();
        this.dxa(this.dvu ? dts.OFFLINE : dts.FAILED, this.dvu ? "отключён" : string);
        this.chat.system("Отключён: " + string);
        if (bl) {
            this.notifyHud("отключён", false);
        }
        this.dwi();
    }

    private void dwi() {
        if (this.dvu || !this.dvt || BotManager.get().getBots().indexOf(this) < 0) {
            return;
        }
        long l = 9000L + (long)this.duf.nextInt(9000);
        this.dvv = System.currentTimeMillis() + l;
        this.chat.system("Переподключение через " + l / 1000L + " с");
    }

    void frame(long l) {
        this.dwu();
        if (this.connection == null) {
            if (this.dvv != 0L && System.currentTimeMillis() >= this.dvv) {
                this.dvv = 0L;
                this.connect();
            }
            this.dvk = l;
            return;
        }
        if (this.dvk == 0L || l - this.dvk > 400000000L) {
            this.dvk = l;
        }
        for (int i = 0; l - this.dvk >= 0L && i < 3 && this.connection != null; ++i) {
            this.dwl();
            this.dvk += 50000000L;
        }
        if (this.player != null) {
            InstanceQueue.keep(this);
            this.dwv();
        }
        this.dwj();
    }

    private void dwj() {
        if (this.connection == null || !this.duy.wantsBotFrame() || !ClientContextSwitcher.enter(this)) {
            return;
        }
        try {
            if (Bot.dtw.field_1724 != null && Bot.dtw.field_1687 != null && Bot.dtw.field_1761 != null) {
                this.duy.onBotFrame();
            }
        }
        catch (Throwable throwable) {
            if (this.dwk()) {
                this.chat.system("Ошибка кадра AutoWarden: " + throwable);
            }
        }
        finally {
            ClientContextSwitcher.exit();
        }
    }

    private boolean dwk() {
        long l = System.currentTimeMillis();
        if (l - this.dvm > 60000L) {
            this.dvm = l;
            this.dvl = 0;
        }
        return ++this.dvl <= 5;
    }

    void stagger(long l, int n, int n2) {
        this.dvk = l + 50000000L * (long)n / (long)Math.max(1, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dwl() {
        BotConnection edb2 = this.connection;
        if (edb2 == null || !ClientContextSwitcher.enter(this)) {
            return;
        }
        long l = System.nanoTime();
        try {
            edb2.drain(6000000L);
            if (this.connection == null) {
                return;
            }
            if (Bot.dtw.field_1724 != null && Bot.dtw.field_1687 != null && Bot.dtw.field_1761 != null && this.handler != null) {
                this.dwm();
            } else {
                edb2.method_10754();
            }
        }
        catch (Throwable throwable) {
            if (this.dwk()) {
                this.chat.system("Ошибка тика: " + throwable);
                if (Boolean.getBoolean("flow2.selftest")) {
                    throwable.printStackTrace(System.out);
                }
            }
        }
        finally {
            ClientContextSwitcher.exit();
            long l2 = System.nanoTime();
            this.dvn = this.dvn * 0.9f + (float)(l2 - l) / 1000000.0f * 0.1f;
            this.dvo = l2;
            this.dvp = Math.max(this.dvp, (float)(l2 - l) / 1000000.0f);
        }
    }

    private void dwm() {
        Runnable runnable;
        while ((runnable = this.dum.poll()) != null) {
            runnable.run();
            if (Bot.dtw.field_1724 != null && Bot.dtw.field_1687 != null) continue;
            return;
        }
        if (this.duw.isEnabled()) {
            this.duw.onStartTick(dtw);
        }
        if (this.duy.isEnabled()) {
            this.duy.onStartTick(dtw);
        }
        if (this.dva.isEnabled()) {
            this.dva.onStartTick(dtw);
        }
        if (this.dvc.isEnabled()) {
            this.dvc.onStartTick(dtw);
        }
        if (Bot.dtw.field_1724 == null || Bot.dtw.field_1687 == null) {
            return;
        }
        class_638 class_6382 = Bot.dtw.field_1687;
        class_6382.method_54719().method_54755();
        int n = this.dwy();
        if (n > 0) {
            this.dwz(n - 1);
        }
        this.control.apply(this);
        Bot.dtw.field_1773.method_3190(1.0f);
        Bot.dtw.field_1761.method_2927();
        if (this.connection == null || Bot.dtw.field_1724 == null || Bot.dtw.field_1687 == null) {
            return;
        }
        class_6382 = Bot.dtw.field_1687;
        class_746 class_7462 = Bot.dtw.field_1724;
        this.dwo(class_7462, this.duy.isEnabled());
        if (Bot.dtw.field_1755 != null) {
            this.dvj = 10000;
            try {
                Bot.dtw.field_1755.method_25393();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (Bot.dtw.field_1755 == null) {
            this.dwq(class_7462);
            if (this.dvj > 0) {
                --this.dvj;
            }
        }
        this.dwn(class_6382, class_7462);
        class_6382.method_8441(() -> true);
        class_6382.method_38534();
        class_6382.method_2935().method_12130().method_15516();
        if (this.handler != null) {
            this.handler.method_52787((class_2596)class_9836.field_52333);
        }
        if (this.duw.isEnabled() && Bot.dtw.field_1724 != null) {
            this.duw.onEndTick(dtw);
        }
        if (this.duy.isEnabled() && Bot.dtw.field_1724 != null) {
            this.duy.onEndTick(dtw);
        }
        if (this.dva.isEnabled() && Bot.dtw.field_1724 != null) {
            this.dva.onEndTick(dtw);
        }
        if (this.dvc.isEnabled() && Bot.dtw.field_1724 != null) {
            this.dvc.onEndTick(dtw);
        }
        this.dwp();
        this.dwa.tick();
        this.captcha.tick();
    }

    private void dwn(class_638 class_6382, class_746 class_7462) {
        class_1297 class_12972 = class_7462.method_5668();
        if (!class_12972.method_31481()) {
            class_6382.method_18646(class_12972);
        }
        for (class_1297 class_12973 : class_6382.method_18112()) {
            if (class_12973 == class_12972 || class_12973 == class_7462 || class_12973.method_31481() || class_12972.method_5821(class_12973)) continue;
            if ((class_12973 instanceof class_1309 && !(class_12973 instanceof class_1657) || class_12973 instanceof class_1542) && !class_12973.method_5765() && class_12973.method_5858((class_1297)class_7462) < 2304.0) {
                try {
                    class_6382.method_18646(class_12973);
                }
                catch (Throwable throwable) {}
                continue;
            }
            class_12973.method_22862();
            class_10584 class_105842 = class_12973.method_66233();
            if (class_105842 == null || !class_105842.method_66270()) continue;
            class_243 class_2432 = class_105842.method_66265();
            float f = class_105842.method_66268();
            float f2 = class_105842.method_66269();
            class_105842.method_66272();
            class_12973.method_33574(class_2432);
            class_12973.method_36456(f);
            class_12973.method_36457(f2);
        }
    }

    private void dwo(class_746 class_7462, boolean bl) {
        if (!class_7462.method_29504()) {
            this.dvh = 0;
            return;
        }
        if (++this.dvh == 1) {
            this.dvi = 30 + this.duf.nextInt(10);
        }
        if (!bl && this.dvh == this.dvi || this.dvh % 200 == 0) {
            class_7462.method_7331();
        }
    }

    private void dwp() {
        if (this.dvx > 0 && --this.dvx == 0) {
            this.dvx = -1;
            if (this.dvw != null && this.handler != null) {
                this.handler.method_45730(this.dvw.substring(1));
                this.chat.system("Повторный вход отправлен");
            }
            if (this.dux || this.duz || this.dvb || this.dvd) {
                this.dvz = 100 + this.duf.nextInt(80);
            }
        }
        if (this.dvz > 0 && --this.dvz == 0) {
            this.dvz = -1;
            if (this.dux && !this.duw.isEnabled() && Bot.dtw.field_1724 != null) {
                this.duw.setBotRunning(true);
                this.chat.system("AutoEnd снова запущен");
            } else if (this.duz && !this.duy.isEnabled() && Bot.dtw.field_1724 != null) {
                this.duy.setBotRunning(true);
                this.chat.system("AutoWarden снова запущен");
            } else if (this.dvb && !this.dva.isEnabled() && Bot.dtw.field_1724 != null) {
                this.dva.setEnabledSilently(true);
                this.chat.system("AutoMine снова запущен");
            } else if (this.dvd && !this.dvc.isEnabled() && Bot.dtw.field_1724 != null) {
                this.dvc.setBotRunning(true);
                this.chat.system("AncientFarmer снова запущен");
            }
        }
    }

    private void dwq(class_746 class_7462) {
        int n;
        class_315 class_3152 = Bot.dtw.field_1690;
        for (n = 0; n < 9; ++n) {
            if (!class_3152.field_1852[n].method_1436() || class_7462.method_7325()) continue;
            class_7462.method_31548().method_61496(n);
        }
        while (class_3152.field_1831.method_1436()) {
            if (class_7462.method_7325() || this.handler == null) continue;
            this.handler.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12969, class_2338.field_10980, class_2350.field_11033));
        }
        while (class_3152.field_1869.method_1436()) {
            if (class_7462.method_7325() || !class_7462.method_7290(false)) continue;
            class_7462.method_6104(class_1268.field_5808);
        }
        n = 0;
        if (class_7462.method_6115()) {
            if (!class_3152.field_1904.method_1434()) {
                Bot.dtw.field_1761.method_2897((class_1657)class_7462);
            }
            while (class_3152.field_1886.method_1436()) {
            }
            while (class_3152.field_1904.method_1436()) {
            }
            while (class_3152.field_1871.method_1436()) {
            }
        } else {
            while (class_3152.field_1886.method_1436()) {
                n |= this.dws(class_7462);
            }
            while (class_3152.field_1904.method_1436()) {
                this.dwt(class_7462);
            }
            while (class_3152.field_1871.method_1436()) {
            }
        }
        if (class_3152.field_1904.method_1434() && this.dwy() == 0 && !class_7462.method_6115()) {
            this.dwt(class_7462);
        }
        this.dwr(class_7462, Bot.dtw.field_1755 == null && n == 0 && class_3152.field_1886.method_1434());
    }

    private void dwr(class_746 class_7462, boolean bl) {
        if (!bl) {
            this.dvj = 0;
        }
        if (this.dvj > 0 || class_7462.method_6115()) {
            return;
        }
        if (class_7462.method_5998(class_1268.field_5808).method_57826(class_9334.field_63631)) {
            return;
        }
        if (bl && Bot.dtw.field_1765 != null && Bot.dtw.field_1765.method_17783() == class_239.class_240.field_1332) {
            class_3965 class_39652 = (class_3965)Bot.dtw.field_1765;
            class_2338 class_23382 = class_39652.method_17777();
            if (!Bot.dtw.field_1687.method_8320(class_23382).method_26215() && Bot.dtw.field_1761.method_2902(class_23382, class_39652.method_17780())) {
                class_7462.method_6104(class_1268.field_5808);
            }
            return;
        }
        Bot.dtw.field_1761.method_2925();
    }

    private boolean dws(class_746 class_7462) {
        if (this.dvj > 0) {
            return false;
        }
        if (Bot.dtw.field_1765 == null) {
            if (Bot.dtw.field_1761.method_2924()) {
                this.dvj = 10;
            }
            return false;
        }
        if (class_7462.method_3144()) {
            return false;
        }
        class_1799 class_17992 = class_7462.method_5998(class_1268.field_5808);
        if (!class_17992.method_45435(Bot.dtw.field_1687.method_45162())) {
            return false;
        }
        if (class_7462.method_75202(class_17992, 0)) {
            return false;
        }
        class_12125 class_121252 = (class_12125)class_17992.method_58694(class_9334.field_63631);
        if (class_121252 != null && !Bot.dtw.field_1761.method_2928()) {
            Bot.dtw.field_1761.method_75407(class_121252);
            class_7462.method_6104(class_1268.field_5808);
            return true;
        }
        boolean bl = false;
        switch (Bot.dtw.field_1765.method_17783()) {
            case field_1331: {
                class_12392 class_123922 = (class_12392)class_17992.method_58694(class_9334.field_64680);
                if (class_123922 != null && !class_123922.method_76736((class_1309)class_7462, Bot.dtw.field_1765.method_17784())) break;
                Bot.dtw.field_1761.method_2918((class_1657)class_7462, ((class_3966)Bot.dtw.field_1765).method_17782());
                break;
            }
            case field_1332: {
                class_3965 class_39652 = (class_3965)Bot.dtw.field_1765;
                class_2338 class_23382 = class_39652.method_17777();
                if (!Bot.dtw.field_1687.method_8320(class_23382).method_26215()) {
                    Bot.dtw.field_1761.method_2910(class_23382, class_39652.method_17780());
                    if (!Bot.dtw.field_1687.method_8320(class_23382).method_26215()) break;
                    bl = true;
                    break;
                }
            }
            case field_1333: {
                if (Bot.dtw.field_1761.method_2924()) {
                    this.dvj = 10;
                }
                class_7462.method_7350();
                break;
            }
        }
        if (!class_7462.method_7325()) {
            class_7462.method_6104(class_1268.field_5808);
        }
        return bl;
    }

    private void dwt(class_746 class_7462) {
        if (Bot.dtw.field_1761.method_2923()) {
            return;
        }
        this.dwz(4);
        if (class_7462.method_3144()) {
            return;
        }
        for (class_1268 class_12682 : class_1268.values()) {
            class_1297 class_12972;
            class_3966 class_39662;
            class_1799 class_17992 = class_7462.method_5998(class_12682);
            if (!class_17992.method_45435(Bot.dtw.field_1687.method_45162())) {
                return;
            }
            class_239 class_2392 = Bot.dtw.field_1765;
            if (class_2392 != null) {
                if (class_2392.method_17783() == class_239.class_240.field_1331) {
                    class_39662 = (class_3966)class_2392;
                    class_12972 = class_39662.method_17782();
                    if (!Bot.dtw.field_1687.method_8621().method_11952(class_12972.method_24515())) {
                        return;
                    }
                    if (class_7462.method_56094(class_12972, 0.0)) {
                        class_1269 class_12692 = Bot.dtw.field_1761.method_2917((class_1657)class_7462, class_12972, class_39662, class_12682);
                        if (!class_12692.method_23665()) {
                            class_12692 = Bot.dtw.field_1761.method_2905((class_1657)class_7462, class_12972, class_12682);
                        }
                        if (class_12692 instanceof class_1269.class_9860) {
                            class_1269.class_9860 class_98602 = (class_1269.class_9860)class_12692;
                            if (class_98602.comp_2909() == class_1269.class_9861.field_52427) {
                                class_7462.method_6104(class_12682);
                            }
                            return;
                        }
                    }
                } else if (class_2392.method_17783() == class_239.class_240.field_1332) {
                    class_39662 = Bot.dtw.field_1761.method_2896(class_7462, class_12682, (class_3965)class_2392);
                    if (class_39662 instanceof class_1269.class_9860) {
                        class_12972 = (class_1269.class_9860)class_39662;
                        if (class_12972.comp_2909() == class_1269.class_9861.field_52427) {
                            class_7462.method_6104(class_12682);
                        }
                        return;
                    }
                    if (class_39662 instanceof class_1269.class_9857) {
                        return;
                    }
                }
            }
            if (class_17992.method_7960() || !((class_39662 = Bot.dtw.field_1761.method_2919((class_1657)class_7462, class_12682)) instanceof class_1269.class_9860)) continue;
            class_12972 = (class_1269.class_9860)class_39662;
            if (class_12972.comp_2909() == class_1269.class_9861.field_52427) {
                class_7462.method_6104(class_12682);
            }
            return;
        }
    }

    int loadDistance() {
        BotPlayHandler ehy2 = this.handler;
        return ehy2 == null ? BotManager.get().getViewDistance() : ehy2.loadDistance();
    }

    float partialTick() {
        return class_3532.method_15363((float)((float)(System.nanoTime() - this.dvo) / 5.0E7f), (float)0.0f, (float)1.0f);
    }

    double mouseMultiplier() {
        double d = this.dug * (double)0.6f + (double)0.2f;
        return d * d * d * 8.0;
    }

    @Override
    public double mouseStep() {
        return MouseQuantizer.step(this.mouseMultiplier());
    }

    @Override
    public void look(float f, float f2) {
        class_746 class_7462 = Bot.dtw.field_1724;
        if (class_7462 == null || BotRuntime.current() != this || !Float.isFinite(f) || !Float.isFinite(f2)) {
            return;
        }
        double d = this.mouseMultiplier();
        float f3 = class_7462.method_36454();
        float f4 = class_7462.method_36455();
        double d2 = (double)f - (double)f3;
        double d3 = Math.floor((d2 + 180.0) / 360.0) * 360.0;
        float f5 = (float)((double)f3 + d3) + MouseQuantizer.quantize(d2 - d3, d);
        float f6 = class_3532.method_15363((float)(f4 + MouseQuantizer.quantize((double)f2 - (double)f4, d)), (float)-90.0f, (float)90.0f);
        class_7462.method_36456(f5);
        class_7462.method_36457(f6);
    }

    @Override
    public boolean heldByHuman(class_304 class_3042) {
        return this.control.isHeld(class_3042);
    }

    @Override
    public String getName() {
        return this.dud;
    }

    @Override
    public void report(String string, boolean bl) {
        if (string != null && !string.isEmpty()) {
            this.chat.system(string);
        }
    }

    public void post(Runnable runnable) {
        if (this.connection != null) {
            this.dum.add(runnable);
        }
    }

    public void schedule(long l, Runnable runnable) {
        this.dun.add(new dtn(System.currentTimeMillis() + Math.max(0L, l), runnable));
    }

    public boolean hasScheduled() {
        return !this.dun.isEmpty();
    }

    private void dwu() {
        if (this.dun.isEmpty()) {
            return;
        }
        long l = System.currentTimeMillis();
        ArrayList<Runnable> arrayList = null;
        Iterator<dtn> iterator = this.dun.iterator();
        while (iterator.hasNext()) {
            dtn object = iterator.next();
            if (l < object.at()) continue;
            iterator.remove();
            if (arrayList == null) {
                arrayList = new ArrayList<Runnable>();
            }
            arrayList.add(object.action());
        }
        if (arrayList != null) {
            for (Runnable runnable : arrayList) {
                try {
                    runnable.run();
                }
                catch (Throwable throwable) {}
            }
        }
    }

    public void sendChat(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string.trim();
        if (string2.isEmpty()) {
            return;
        }
        if (string2.length() > 256) {
            string2 = string2.substring(0, 256);
        }
        this.dww(string2);
        this.chat.own(string2);
        Matcher matcher = dua.matcher(string2);
        if (matcher.matches() && !InstanceQueue.enter(this, matcher.group(1))) {
            if (string2.equalsIgnoreCase(this.dvr)) {
                InstanceQueue.cancel(this);
                this.dvr = null;
                this.chat.system("Очередь на an" + matcher.group(1) + " отменена");
            } else {
                this.dvr = string2;
                this.dvs = System.currentTimeMillis();
                this.chat.system("На an" + matcher.group(1) + " уже " + 3 + " наших — жду места (" + InstanceQueue.position(this) + "-й). Повтори команду, чтобы отменить");
            }
            return;
        }
        if (matcher.matches()) {
            this.dvr = null;
        }
        String string4 = string2;
        this.post(() -> {
            if (this.handler == null) {
                return;
            }
            this.dup = System.currentTimeMillis();
            if (string4.startsWith("/")) {
                this.handler.method_45730(string4.substring(1));
            } else {
                this.handler.method_45729(string4);
            }
        });
    }

    private void dwv() {
        String string = this.dvr;
        long l = System.currentTimeMillis();
        if (string == null || l - this.dvs < 1000L) {
            return;
        }
        this.dvs = l;
        if (this.isActive()) {
            this.dvr = null;
            return;
        }
        Matcher matcher = dua.matcher(string);
        if (matcher.matches() && InstanceQueue.enter(this, matcher.group(1))) {
            this.dvr = null;
            this.chat.system("Место на an" + matcher.group(1) + " освободилось — перехожу");
            this.sendChat(string);
        }
    }

    private void dww(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        String[] stringArray = string.split("\\s+");
        String string3 = null;
        if ((string2.startsWith("/login ") || string2.startsWith("/l ") || string2.startsWith("/log ")) && stringArray.length >= 2) {
            string3 = "/login " + stringArray[1];
        } else if ((string2.startsWith("/reg ") || string2.startsWith("/register ")) && stringArray.length >= 2) {
            string3 = "/login " + stringArray[1];
        }
        if (string3 != null && !string3.equals(this.dvw)) {
            this.dvw = string3;
            BotManager.get().persist();
        }
    }

    String loginPassword() {
        return this.dvw == null ? null : this.dvw.substring("/login ".length());
    }

    void restore(String string, boolean bl) {
        this.dvw = string == null || string.isBlank() ? null : "/login " + string;
        this.dvt = bl;
    }

    private void dwx() {
        if (this.dvc.isEnabled()) {
            this.dvc.setBotRunning(false);
            this.chat.system("AncientFarmer остановлен");
        }
    }

    public void setF0(boolean bl) {
        this.dux = bl;
        if (bl) {
            this.duz = false;
            this.dvb = false;
            this.dvd = false;
        }
        this.post(() -> {
            if (Bot.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                this.dwx();
            }
            if (bl && this.duy.isEnabled()) {
                this.duy.setBotRunning(false);
                this.chat.system("AutoWarden остановлен");
            }
            if (bl && this.dva.isEnabled()) {
                this.dva.setEnabledSilently(false);
                this.chat.system("AutoMine остановлен");
            }
            if (bl && !this.duw.isEnabled()) {
                this.duw.setBotRunning(true);
                this.chat.system("AutoEnd запущен");
            } else if (!bl && this.duw.isEnabled()) {
                this.duw.setBotRunning(false);
                this.chat.system("AutoEnd остановлен");
            }
        });
    }

    public void setF1(boolean bl) {
        this.duz = bl;
        if (bl) {
            this.dux = false;
            this.dvb = false;
            this.dvd = false;
        }
        this.post(() -> {
            if (Bot.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                this.dwx();
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                    this.chat.system("AutoEnd остановлен");
                }
                if (this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(false);
                    this.chat.system("AutoMine остановлен");
                }
                if (!this.duy.isEnabled()) {
                    this.duy.setBotRunning(true);
                    this.chat.system("AutoWarden запущен, лут: " + this.duy.getCurrentLootAnarchy());
                }
            } else if (this.duy.isEnabled()) {
                this.duy.setBotRunning(false);
                this.chat.system("AutoWarden остановлен");
            }
        });
    }

    public void setF2(boolean bl) {
        this.dvb = bl;
        if (bl) {
            this.dux = false;
            this.duz = false;
            this.dvd = false;
        }
        this.post(() -> {
            if (Bot.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                this.dwx();
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                    this.chat.system("AutoEnd остановлен");
                }
                if (this.duy.isEnabled()) {
                    this.duy.setBotRunning(false);
                    this.chat.system("AutoWarden остановлен");
                }
                if (!this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(true);
                    this.chat.system("AutoMine запущен");
                }
            } else if (this.dva.isEnabled()) {
                this.dva.setEnabledSilently(false);
                this.chat.system("AutoMine остановлен");
            }
        });
    }

    public void setF3(boolean bl) {
        if (bl && this.dvc.isLocked()) {
            return;
        }
        this.dvd = bl;
        if (bl) {
            this.dux = false;
            this.duz = false;
            this.dvb = false;
        }
        this.post(() -> {
            if (Bot.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                    this.chat.system("AutoEnd остановлен");
                }
                if (this.duy.isEnabled()) {
                    this.duy.setBotRunning(false);
                    this.chat.system("AutoWarden остановлен");
                }
                if (this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(false);
                    this.chat.system("AutoMine остановлен");
                }
                if (!this.dvc.isEnabled()) {
                    this.dvc.setBotRunning(true);
                    this.chat.system("AncientFarmer запущен");
                }
            } else {
                this.dwx();
            }
        });
    }

    public void stopAutomation() {
        this.dux = false;
        this.duz = false;
        this.dvb = false;
        this.dvd = false;
        this.post(() -> {
            this.dwx();
            if (this.dva.isEnabled()) {
                this.dva.setEnabledSilently(false);
                this.chat.system("AutoMine остановлен");
            }
            if (this.duw.isEnabled()) {
                this.duw.setBotRunning(false);
                this.chat.system("AutoEnd остановлен");
            }
            if (this.duy.isEnabled()) {
                this.duy.setBotRunning(false);
                this.chat.system("AutoWarden остановлен");
            }
        });
    }

    public void boostItemUse(int n) {
        if (this.dwy() > n) {
            this.dwz(Math.max(0, n));
        }
    }

    private int dwy() {
        return ClientContextSwitcher.holdsUseCooldown(this) ? ClientContextSwitcher.useCooldown() : this.itemUseCooldown;
    }

    private void dwz(int n) {
        if (ClientContextSwitcher.holdsUseCooldown(this)) {
            ClientContextSwitcher.useCooldown(n);
        } else {
            this.itemUseCooldown = n;
        }
    }

    public void selectSlot(int n) {
        this.post(() -> {
            if (Bot.dtw.field_1724 != null && n >= 0 && n < 9) {
                Bot.dtw.field_1724.method_31548().method_61496(n);
            }
        });
    }

    public void clickSlot(int n, int n2, int n3, class_1713 class_17132) {
        this.post(() -> {
            if (Bot.dtw.field_1724 != null && Bot.dtw.field_1761 != null && Bot.dtw.field_1724.field_7512.field_7763 == n) {
                Bot.dtw.field_1761.method_2906(n, n2, n3, class_17132, (class_1657)Bot.dtw.field_1724);
            }
        });
    }

    public void closeScreen() {
        this.post(() -> {
            if (Bot.dtw.field_1724 == null) {
                return;
            }
            if (Bot.dtw.field_1724.field_7512 != Bot.dtw.field_1724.field_7498) {
                Bot.dtw.field_1724.method_7346();
            } else if (Bot.dtw.field_1755 != null) {
                dtw.method_1507(null);
            }
            this.duv = null;
        });
    }

    public void dropSelected(boolean bl) {
        this.post(() -> {
            if (Bot.dtw.field_1724 != null && !Bot.dtw.field_1724.method_7325() && Bot.dtw.field_1724.method_7290(bl)) {
                Bot.dtw.field_1724.method_6104(class_1268.field_5808);
            }
        });
    }

    public void swapHands() {
        this.post(() -> {
            if (this.handler != null && Bot.dtw.field_1724 != null && !Bot.dtw.field_1724.method_7325()) {
                this.handler.method_52787((class_2596)new class_2846(class_2846.class_2847.field_12969, class_2338.field_10980, class_2350.field_11033));
            }
        });
    }

    void syncOptionsLive() {
        this.post(() -> {
            if (this.handler != null) {
                this.handler.method_62149(this.syncedOptions());
            }
        });
    }

    public void respawn() {
        this.post(() -> {
            if (Bot.dtw.field_1724 != null && Bot.dtw.field_1724.method_29504()) {
                Bot.dtw.field_1724.method_7331();
            }
        });
    }

    void ensureKeys(int n) {
        if (this.keyPressed.length != n) {
            boolean[] blArray = new boolean[n];
            int[] nArray = new int[n];
            System.arraycopy(this.keyPressed, 0, blArray, 0, Math.min(n, this.keyPressed.length));
            System.arraycopy(this.keyTimes, 0, nArray, 0, Math.min(n, this.keyTimes.length));
            this.keyPressed = blArray;
            this.keyTimes = nArray;
        }
    }

    void release() {
        this.dvt = false;
        this.disconnect();
        if ((this.duw.isEnabled() || this.duy.isEnabled() || this.dva.isEnabled() || this.dvc.isEnabled()) && this.player != null && ClientContextSwitcher.enter(this)) {
            try {
                if (this.dvc.isEnabled()) {
                    this.dvc.setBotRunning(false);
                }
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                }
                if (this.duy.isEnabled()) {
                    this.duy.setBotRunning(false);
                }
                if (this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(false);
                }
            }
            catch (Throwable throwable) {
            }
            finally {
                ClientContextSwitcher.exit();
            }
        }
        InstanceQueue.leave(this);
        this.dwa.close();
        this.captcha.close();
        this.dve.close();
        this.dun.clear();
        this.connection = null;
        this.handler = null;
        this.player = null;
        this.world = null;
        this.interaction = null;
        this.screen = null;
        this.camera = null;
        this.bossBars.clear();
        this.dum.clear();
    }

    void notifyHud(String string, boolean bl) {
        try {
            dtw.method_63588(() -> {
                try {
                    Hud.alert(this.dud, string, Icon.INFO, bl);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            });
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void dxa(dts dts2, String string) {
        this.duh = dts2;
        this.dui = string == null ? "" : string;
        this.duj = System.currentTimeMillis();
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String string) {
        if (string == null || string.equals(this.address)) {
            return;
        }
        this.address = string;
        BotManager.get().persist();
    }

    public dts getStatus() {
        return this.duh;
    }

    public String getStatusText() {
        return this.dui;
    }

    public long getStatusTime() {
        return this.duj;
    }

    public class_746 getPlayer() {
        return this.player;
    }

    public class_638 getWorld() {
        return this.world;
    }

    public class_437 getScreen() {
        return this.screen;
    }

    public String getOpenedScreenTitle() {
        return this.duv;
    }

    public BotChatLog getChat() {
        return this.chat;
    }

    public BotRemoteInput getControl() {
        return this.control;
    }

    public BotMinimap getRadar() {
        return this.dwa;
    }

    public MapCaptchaDetector getCaptcha() {
        return this.captcha;
    }

    public long getLastSent() {
        return this.dup;
    }

    public class_2561 replyToLastSent() {
        ech ech2 = this.dup == 0L ? null : this.chat.firstServerAfter(this.dup, 5000L);
        return ech2 == null ? null : ech2.text;
    }

    public AutoEnd f0ref() {
        return this.duw;
    }

    public AutoWarden f1ref() {
        return this.duy;
    }

    public boolean f1Run() {
        return this.duy.isEnabled();
    }

    public boolean f1Want() {
        return this.duz;
    }

    public boolean f0Run() {
        return this.duw.isEnabled();
    }

    public boolean f0Want() {
        return this.dux;
    }

    public boolean isActive() {
        return this.duw.isEnabled() || this.duy.isEnabled() || this.dva.isEnabled() || this.dvc.isEnabled();
    }

    public AncientFarmer f3ref() {
        return this.dvc;
    }

    public boolean f3Run() {
        return this.dvc.isEnabled();
    }

    public boolean f3Want() {
        return this.dvd;
    }

    public AutoMines f2ref() {
        return this.dva;
    }

    public boolean f2Run() {
        return this.dva.isEnabled();
    }

    public boolean f2Want() {
        return this.dvb;
    }

    public BotCamera getCamera() {
        return this.dve;
    }

    public boolean isAutoReconnect() {
        return this.dvt;
    }

    public void setAutoReconnect(boolean bl) {
        boolean bl2 = this.dvt != bl;
        this.dvt = bl;
        if (!bl) {
            this.dvv = 0L;
        }
        if (bl2) {
            BotManager.get().persist();
        }
    }

    public boolean hasLoginCommand() {
        return this.dvw != null;
    }

    public void forgetLogin() {
        if (this.dvw != null) {
            this.dvw = null;
            BotManager.get().persist();
        }
    }

    public long getReconnectAt() {
        return this.dvv;
    }

    public class_2561 getActionBar() {
        return System.currentTimeMillis() - this.dur < 3000L ? this.duq : null;
    }

    public class_2561 getTitle() {
        return System.currentTimeMillis() - this.duu < 4000L ? this.dus : null;
    }

    public class_2561 getSubtitle() {
        return System.currentTimeMillis() - this.duu < 4000L ? this.dut : null;
    }

    public Map<UUID, class_345> getBossBars() {
        return this.bossBars;
    }

    public float getTickMillis() {
        return this.dvn;
    }

    public int getPing() {
        BotPlayHandler ehy2 = this.handler;
        if (ehy2 == null) {
            return -1;
        }
        class_640 class_6402 = ehy2.method_2871(this.due);
        return class_6402 == null ? -1 : class_6402.method_2959();
    }

    public float takePeakTickMillis() {
        float f = this.dvp;
        this.dvp = 0.0f;
        return f;
    }

    public int getPendingPackets() {
        BotConnection edb2 = this.connection;
        return edb2 == null ? 0 : edb2.pending();
    }

    @Override
    public void halted() {
        this.dux = false;
        this.duz = false;
    }

    @Override
    public int pendingPackets() {
        return this.getPendingPackets();
    }

    public long getLastPacket() {
        return this.dvq;
    }

    class_2561 getTabHeader() {
        return this.tabHeader;
    }

    class_2561 getTabFooter() {
        return this.tabFooter;
    }

    class_634 getHandler() {
        return this.handler;
    }

    static {
        dtz = "/login ";
        dtw = class_310.method_1551();
        dua = Pattern.compile("/an\\s*(\\d+)\\s*", 2);
        duc = new double[]{0.5, 0.47, 0.43, 0.39, 0.52, 0.55, 0.36, 0.45, 0.41};
    }

    private static /* synthetic */ int at(int n, int n2) {
        return n + n2 ^ 0xAC6DA06D;
    }

    private static /* synthetic */ int au(int n, int n2) {
        return Bot.at(n, n2) ^ 0xBF8424F3;
    }

    private static /* synthetic */ int av(int n, int n2) {
        return Bot.au(n, n2) + n;
    }
}

