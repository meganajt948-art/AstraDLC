/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.ClientBossBar
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.Address
 *  net.minecraft.client.network.AllowedAddressResolver
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.client.network.ServerAddress
 *  net.minecraft.client.network.ServerInfo
 *  net.minecraft.client.network.ServerInfo$ResourcePackPolicy
 *  net.minecraft.client.network.ServerInfo$ServerType
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.AttackRangeComponent
 *  net.minecraft.component.type.MapIdComponent
 *  net.minecraft.component.type.PiercingWeaponComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.PositionInterpolator
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerModelPart
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.NetworkingBackend
 *  net.minecraft.network.listener.ClientPacketListener
 *  net.minecraft.network.message.ChatVisibility
 *  net.minecraft.network.packet.BundlePacket
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.common.SyncedClientOptions
 *  net.minecraft.network.packet.c2s.login.LoginHelloC2SPacket
 *  net.minecraft.network.packet.c2s.play.ClientTickEndC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket
 *  net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket$Action
 *  net.minecraft.network.state.LoginStates
 *  net.minecraft.particle.ParticlesMode
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.text.Text
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.ActionResult$Fail
 *  net.minecraft.util.ActionResult$Success
 *  net.minecraft.util.ActionResult$SwingSource
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Hand
 *  net.minecraft.util.Util
 *  net.minecraft.util.Uuids
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.chunk.WorldChunk
 */
package a;

import a.dtn;
import a.dts;
import a.dyh;
import a.eao;
import a.ech;
import a.eck;
import a.edb;
import a.edj;
import a.eff;
import a.efz;
import a.egf;
import a.egq;
import a.ehq;
import a.ehy;
import a.eip;
import a.ejp;
import a.izx;
import a.kfx;
import a.lqq;
import a.mpq;
import a.nfl;
import a.nxa;
import a.pjd;
import a.prp;
import a.pth;
import a.vhz;
import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
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
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.Address;
import net.minecraft.client.network.AllowedAddressResolver;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttackRangeComponent;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.component.type.PiercingWeaponComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.PositionInterpolator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.item.ItemStack;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkingBackend;
import net.minecraft.network.listener.ClientPacketListener;
import net.minecraft.network.message.ChatVisibility;
import net.minecraft.network.packet.BundlePacket;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.SyncedClientOptions;
import net.minecraft.network.packet.c2s.login.LoginHelloC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientTickEndC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.state.LoginStates;
import net.minecraft.particle.ParticlesMode;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.Uuids;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.WorldChunk;

public final class dtv
implements efz {
    private static final MinecraftClient dtw;
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
    volatile edb connection;
    private volatile boolean duk;
    private volatile boolean dul;
    ehy handler;
    ClientPlayerEntity player;
    ClientWorld world;
    ClientPlayerInteractionManager interaction;
    Screen screen;
    HitResult crosshair;
    Entity targeted;
    Entity camera;
    boolean[] keyPressed = new boolean[0];
    int[] keyTimes = new int[0];
    final Map<UUID, ClientBossBar> bossBars = new LinkedHashMap<UUID, ClientBossBar>();
    final pth silent = new pth();
    volatile Object[] fabricAddons;
    final eck chat = new eck();
    final ehq packs = new ehq();
    final eff control = new eff();
    final eao captcha = new eao(this);
    private final ArrayDeque<Runnable> dum = new ArrayDeque();
    private final List<dtn> dun = new ArrayList<dtn>();
    private volatile boolean duo;
    private long dup;
    Text tabHeader;
    Text tabFooter;
    Text serverLabel;
    private Text duq;
    private long dur;
    private Text dus;
    private Text dut;
    private long duu;
    private String duv;
    private final mpq duw;
    private boolean dux;
    private final nxa duy;
    private boolean duz;
    private final nfl dva;
    private boolean dvb;
    private final lqq dvc;
    private boolean dvd;
    private final dyh dve = new dyh(this);
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
    private final eip dwa = new eip(this);
    private static /* synthetic */ long dwb;
    private static /* synthetic */ boolean dwc;

    dtv(String string, String string2) {
        nfl nfl2;
        this.dud = string;
        this.due = Uuids.method_43344((String)string);
        this.address = string2;
        this.dug = duc[this.duf.nextInt(duc.length)];
        this.duw = new mpq();
        this.duw.attachBot(this);
        mpq mpq2 = dtv.dwe();
        if (mpq2 != null) {
            this.duw.copySettingsFrom(mpq2);
        }
        this.duy = new nxa();
        this.duy.attachBot(this);
        nxa nxa2 = dtv.dwf();
        if (nxa2 != null) {
            this.duy.copySettingsFrom(nxa2);
        }
        this.dva = new nfl();
        this.dva.attachBot(this);
        kfx kfx2 = dtv.dwd();
        nfl nfl3 = nfl2 = kfx2 == null ? null : kfx2.get(nfl.class);
        if (nfl2 != null && !nfl2.isBotInstance()) {
            this.dva.copySettingsFrom(nfl2);
        }
        this.dvc = new lqq();
        this.dvc.attachBot(this);
        lqq lqq2 = lqq.get();
        if (lqq2 != null && lqq2 != this.dvc) {
            this.dvc.copySettingsFrom(lqq2);
        }
    }

    double sensitivity() {
        return this.dug;
    }

    private static kfx dwd() {
        Flow flow = Flow.getInstance();
        return flow == null ? null : flow.getModuleManager();
    }

    private static mpq dwe() {
        kfx kfx2 = dtv.dwd();
        mpq mpq2 = kfx2 == null ? null : kfx2.get(mpq.class);
        return mpq2 == null || mpq2.isBotInstance() ? null : mpq2;
    }

    private static nxa dwf() {
        kfx kfx2 = dtv.dwd();
        nxa nxa2 = kfx2 == null ? null : kfx2.get(nxa.class);
        return nxa2 == null || nxa2.isBotInstance() ? null : nxa2;
    }

    public void connect() {
        if (this.connection != null || this.dul) {
            return;
        }
        this.duk = false;
        this.dvu = false;
        this.dvv = 0L;
        if (!egq.get().tryStartJoin(this)) {
            this.dvv = System.currentTimeMillis() + 1200L + (long)this.duf.nextInt(1300);
            this.dxa(dts.QUEUED, a.c(63894451, "\uf790\u8a33\u04fe\u9af6\u1153\u9797\u2db1\ua441\u3a12\ub4bb\u3775\ucd09\u47ce\uda6d\u5049\ud6c3\u6c86"));
            return;
        }
        this.dul = true;
        this.dxa(dts.CONNECTING, a.b("\u8746\ufef6\u742f\uea50\u6186\ue742\u5d18\ud49b\u4acc\uc078\u47a6", 162890610));
        String string = this.address;
        Util.method_27958().execute(() -> this.dwg(string));
    }

    boolean isJoining() {
        return this.dul || this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.JOINING;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dwg(String string) {
        try {
            ServerAddress serverAddress = ServerAddress.method_2950((String)string);
            Optional<InetSocketAddress> optional = AllowedAddressResolver.field_33745.method_36907(serverAddress).map(Address::method_36902);
            if (optional.isEmpty()) {
                this.dwh(a.b("\ubb2b\uc2ee\u4848\ud64b\u5d9b\udb5f\u656c\ue880\u76d7\uf873\u7bbd\u81c1\u0f1f\u96a3\u1cf1\u9a08", -1664761990));
                return;
            }
            InetSocketAddress inetSocketAddress = optional.get();
            edb edb2 = new edb(this);
            ClientConnection.method_52271((InetSocketAddress)inetSocketAddress, (NetworkingBackend)NetworkingBackend.method_75867((boolean)dtv.dtw.field_1690.method_1639()), (ClientConnection)edb2).syncUninterruptibly();
            dtv dtv2 = this;
            synchronized (dtv2) {
                this.dul = false;
                if (this.duk) {
                    edb2.method_10747((Text)Text.method_43471((String)a.d("\u0885\u712c\ufbe6\u658f\uee45\u68ed\ud2a2\u5b5e\uc519\u4fb4\uc870\u325d\ubcd7\u2561\uaf27\u29c3\u938d\u1c5a\u86b4\u00ba\u8949\uf304\u7daa\ue67b\u6019\ueacf\u5375", -1215154949, -482460664)));
                    this.dxa(dts.OFFLINE, a.c(1061586037, "\u8043\uf98e\u7325\ued55\u66f7\ue04f\u5a0a\ud397"));
                    return;
                }
                this.connection = edb2;
            }
            edb2.method_56326(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), LoginStates.field_48247, LoginStates.field_48248, (ClientPacketListener)new egf(this, edb2), false);
            edb2.method_10743((Packet)new LoginHelloC2SPacket(this.dud, this.due));
            this.dxa(dts.LOGIN, a.b("\ub9c7\uc001\u4aa9\ud4d2", -562709007));
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
            this.chat.system(a.d("\ub285\ucb1c\u45da\udfc8\u5468\ud2dd\u6885\ue171\u7f51\uf5ed\u7652\u883c\u06ea\u9f51\u150c\u93fc\u29c6\ua61e\u3cd2\ubaf9\u3300\u495c\uc7e1\u5845\ude20", -134078425, 924620454) + string);
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
                this.dxa(dts.OFFLINE, a.b("\u2b7e\u52b3\ud818\u4668\ucdca\u4b72\uf137\u78aa", -809685176));
            }
            return;
        }
        object.method_10747((Text)Text.method_43471((String)a.d("\ud97e\ua0d7\u2a1d\ub474\u3fbe\ub916\u0359\u8aa5\u14e2\u9e4f\u198b\ue3a6\u6d2c\uf49a\u7edc\uf838\u4276\ucda1\u574f\ud141\u58b2\u22ff\uac51\u3780\ub1e2\u3b34\u828e", 1921927102, 850894518)));
    }

    ServerInfo serverInfo() {
        ServerInfo serverInfo = new ServerInfo(this.dud, this.address, ServerInfo.ServerType.field_45611);
        serverInfo.method_2995(ServerInfo.ResourcePackPolicy.field_3768);
        return serverInfo;
    }

    SyncedClientOptions syncedOptions() {
        int n = 0;
        for (PlayerModelPart playerModelPart : PlayerModelPart.values()) {
            n |= playerModelPart.method_7430();
        }
        String string = dtv.dtw.field_1690 == null ? a.b("\u6a32\u1388\u996a\u0731\u8ce0", 317418066) : dtv.dtw.field_1690.field_1883;
        return new SyncedClientOptions(string, egq.get().getViewDistance(), ChatVisibility.field_7538, true, n, Arm.field_6183, false, true, ParticlesMode.field_18197);
    }

    void onLoginSuccess(GameProfile gameProfile) {
        this.duo = true;
        this.dxa(dts.JOINING, a.d("\u6700\u1eb6\u9466\u0a64\u81b0\u0775\ubd2b\u34d0\uae9f\u2032\ua7e5\u5dec\ud34b", -1822107416, 1577696210));
    }

    void onPlayHandler(ehy ehy2) {
        this.handler = ehy2;
    }

    void onJoinWorld(ClientWorld clientWorld, ClientPlayerEntity clientPlayerEntity) {
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
        this.dxa(dts.ONLINE, a.c(931386785, "\ud195\uac36\u22fd\ubc87\u3723\ub1e7"));
        if (!bl) {
            this.dvy = this.dvw == null ? 0L : System.currentTimeMillis() + 15000L;
            return;
        }
        this.chat.system(a.c(-1127663214, "\u3d8a\u441c\uceb7\u50df\udb62\u59c8\ue786\u6e7a\uf435\u7ae5\ufd42\u0746\u89e3\u1055\u9a73"));
        this.notifyHud(a.c(1916483836, "\u3ccb\u4576\ucfd3\u51bb\uda06"), true);
        if (this.dvw != null) {
            this.dvx = 30 + this.duf.nextInt(40);
        } else if (this.dux || this.duz || this.dvb || this.dvd) {
            this.dvz = 100 + this.duf.nextInt(80);
        }
    }

    void onRespawn(ClientWorld clientWorld, ClientPlayerEntity clientPlayerEntity, boolean bl) {
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
        dtv.dtw.field_1724 = null;
        dtv.dtw.field_1687 = null;
        dtv.dtw.field_1761 = null;
        dtv.dtw.field_1755 = null;
        edj.camera(null);
        dtv.dtw.field_1765 = null;
        dtv.dtw.field_1692 = null;
        this.handler = null;
        this.bossBars.clear();
        this.dxa(dts.JOINING, a.b("\ud4be\uad05\u27a3\ub9a7\u327f\ub4ca\u0e9a\u8712\u1931\u938b\u1428\uee5a\u60fd\uf93a\u7317\uf591", 1981993105));
    }

    void onChunksComing() {
        if (this.dvf == 0) {
            this.dvf = 1;
        }
    }

    void tickLoading(ehy ehy2) {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = dtv.dtw.field_1724;
        ClientWorld clientWorld = dtv.dtw.field_1687;
        if (clientPlayerEntity == null || clientWorld == null || ehy2.method_76760()) {
            return;
        }
        if (this.dvf == 0 && ++this.dvg > 100) {
            this.dvf = 1;
        }
        if (this.dvf != 1) {
            return;
        }
        BlockPos blockPos = clientPlayerEntity.method_24515();
        boolean bl2 = bl = clientWorld.method_31601(blockPos.method_10264()) || clientWorld.method_2935().method_12126(blockPos.method_10263() >> 4, blockPos.method_10260() >> 4, false) != null || clientPlayerEntity.method_7325() || !clientPlayerEntity.method_5805();
        if (bl) {
            this.dvf = 2;
            ehy2.markLoaded();
        }
    }

    void onServerMessage(Text text, boolean bl) {
        this.onServerMessage(text, bl, false);
    }

    void onLocalMessage(Text text, boolean bl) {
        if (text == null) {
            return;
        }
        if (bl) {
            this.duq = text;
            this.dur = System.currentTimeMillis();
            return;
        }
        this.chat.server(text, false);
    }

    void onServerMessage(Text text, boolean bl, boolean bl2) {
        if (text == null) {
            return;
        }
        if (bl) {
            this.duq = text;
            this.dur = System.currentTimeMillis();
            return;
        }
        this.chat.server(text, bl2);
        this.captcha.onHint(text.getString());
        if (bl2) {
            return;
        }
        if (this.dvy != 0L) {
            if (System.currentTimeMillis() > this.dvy) {
                this.dvy = 0L;
            } else {
                String string = text.getString().toLowerCase(Locale.ROOT);
                if (string.contains(a.c(-287387852, "\ucf1d\ub6ef\u3c3f\ua246\u299f\uaf29")) || string.contains(a.c(174757471, "\u9673\uef81\u651e")) || string.contains(a.b("\u24bc\u5d0f\ud7ac\u49a1\uc208\u44c1\ufe9d\u7718\ue93d", 571678853)) || string.contains(a.b("\u4edc\u3761\ubdb5\u23c9\ua812\u2ed9\u94fd", 63064809))) {
                    this.dvy = 0L;
                    this.dvx = 20 + this.duf.nextInt(30);
                }
            }
        }
        if (this.duw.isEnabled()) {
            try {
                this.duw.onChatMessage(text.getString());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dva.isEnabled()) {
            try {
                this.dva.onChat(text);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dvc.isEnabled()) {
            try {
                this.dvc.onChat(text);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    void onTitle(Text text, boolean bl) {
        if (text == null) {
            this.dus = null;
            this.dut = null;
            return;
        }
        if (bl) {
            this.dut = text;
        } else {
            this.dus = text;
        }
        this.duu = System.currentTimeMillis();
    }

    void onTotemPop() {
        this.chat.system(a.b("\uabed\ud23d\u589e\uc6ee\u4d36\ucbfb\u71da\uf820\u6264\uecb7\u6b18\u9115\u1fb5\u860d", -1217482814));
        this.notifyHud(a.b("\u5ae1\u232c\ua983\u3785\ubc5b", 990731942), false);
    }

    void onDeath(Text text) {
        this.chat.system(a.d("\uc0a5\ub909\u33d3\uadd7\u2602\ua0bd\u1e98\u9773", -1998198293, 1706241383) + (text == null ? "" : text.getString()));
        this.notifyHud(a.b("\u0c3a\u75f4\uff2e\u612a", -1884223363), false);
    }

    void onScreenOpened(Text text) {
        this.duv = text == null ? null : text.getString();
    }

    void onChunkLoaded(WorldChunk worldChunk) {
        this.dwa.onChunk(worldChunk);
    }

    void onMapUpdated(MapIdComponent mapIdComponent) {
        this.dwa.onMap(mapIdComponent);
        this.captcha.onMap();
    }

    void onCaptcha() {
        this.chat.system(a.c(-1235440802, "\uaf72\ud6e9\u5c35\uc23c\u499c\ucb3d\u7573\ufc8f\u66c0\ue863\u6fc7\u95cd\u1b10\u82a0\u0cfc\u8a17\u3442\ubb99\u215a\ua709\u2e84\u54d0\uda64\u41bf\uc3d0\u4d19\uf0b2\u7afc\ue00a\u665e\uede3\u1727\u997c\u0082\u86a5\u087b\ub3b6\u39c3\ubf1a\u26af\ua8e0\ud61c\u5c42\udfe1\u4124\ucb4b\u729c\uf82a\u7e6d\ue1a9\u6bcb\u9115\u18de\u9efd"));
        this.notifyHud(a.d("\u53b6\u2a0d\ua0d1\u3ed8\ub578\u37d9\u8d87\u047b\u9e39\u14f6\u9350\u6922\ue7fd\u7a51\uf418\u72ed\uc8a8", -1766484419, 1726923168), false);
    }

    void onCaptchaGone() {
        this.chat.system(a.c(-1174595480, "\u1c64\u65ff\uef5c\u712f\ufa82\u7c36\uc662\u4f99\ud5d6\u5b7d\udca4\u26da\ua875\u31bb\ubff0\u3d1e\u872e\u0881\u9233\u146d\u9d91\ue7cb"));
    }

    void onCaptchaSolved(String string) {
        this.chat.system(a.b("\u1d9b\u6400\ueedc\u70d5\ufb75\u79d4\uc798\u4e16\ud037\u5aff\udd53\u2758\ua9fd\u3041\uba1f\u38fe\u86d0\u0975\u93b1\u15ee\u9c1b\ue23e\u6c97", -827057770) + string);
        this.notifyHud(a.c(1621552910, "\ueb33\u9288\u1854\u865d\u0dfd\u8f46\u350f") + string, true);
        this.sendChat(string);
    }

    void onCaptchaUnsolved(String string) {
        this.chat.system(a.c(288103366, "\u1fca\u6651\uec8d\u7284\uf924\u7b85\uc5cb\u4c32\ud678\u58d6\udf7a\u2575\uabdb\u3215\ub83c\u3ebf\u84fb\u0b21\u91e3\u17bf\u9a24\ue07d") + string + a.c(1897770882, "\uafb2\ud60a\u5cd4\uc2a8\u4d6d\ucbdc\u7188\uf878\u662b\ue882\u6b4b\u913e\u1fe3\u8246\u0c07\u8ee4\u30b5\ubf60\u25d4\ua38d\u2e6f\u502f\ude93\u453e\uc333"));
    }

    void onPacketReceived() {
        this.dvq = System.currentTimeMillis();
    }

    void beforePacket(Packet<?> packet) {
        if (packet instanceof BundlePacket) {
            BundlePacket bundlePacket = (BundlePacket)packet;
            for (Packet packet2 : bundlePacket.method_48324()) {
                this.beforePacket(packet2);
            }
            return;
        }
        if (this.duy.isEnabled()) {
            try {
                this.duy.onPacket(packet);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dvc.isEnabled()) {
            try {
                this.dvc.onPacket(packet);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (this.dva.isEnabled()) {
            try {
                this.dva.onPacket(packet);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    void onPacketError(Packet<?> packet, Throwable throwable) {
        if (this.dwk()) {
            this.chat.system(a.b("\u0632\u7fd5\uf576\u6b0e\ue0d2\u6669\ud82a\u55c4\ucb94\u412f\uc6f3\u3cf5\ub250\u2ff1", 1257374242) + packet.getClass().getSimpleName() + a.c(-1052934378, "\u7f2e\u0685") + throwable);
            if (Boolean.getBoolean(a.d("\ud539\uac82\u2652\ub83b\u33a9\ub504\u0f0a\u86ed\u18bb\u9200\u15c1\uefa1\u6160\uf8d6", -545526478, -2068432797))) {
                throwable.printStackTrace(System.out);
            }
        }
    }

    void onDisconnected(Text text) {
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
        if (ejp.current() == this) {
            dtv.dtw.field_1724 = null;
            dtv.dtw.field_1687 = null;
            dtv.dtw.field_1761 = null;
            dtv.dtw.field_1755 = null;
            edj.camera(null);
            dtv.dtw.field_1765 = null;
            dtv.dtw.field_1692 = null;
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
        pjd.leave(this);
        this.dvr = null;
        String string = text == null ? "" : text.getString();
        this.dxa(this.dvu ? dts.OFFLINE : dts.FAILED, this.dvu ? a.c(1237706786, "\uec14\u95d9\u1f72\u8102\u0aa0\u8c18\u365d\ubfc0") : string);
        this.chat.system(a.d("\ue822\u91cf\u1b64\u8514\u0eb6\u880e\u324b\ubbd6\u218e\uab25", -140684645, -2097365331) + string);
        if (bl) {
            this.notifyHud(a.b("\u0938\u70f5\ufa5e\u642e\uef8c\u6934\ud371\u5aec", 1816661262), false);
        }
        this.dwi();
    }

    private void dwi() {
        if (this.dvu || !this.dvt || egq.get().getBots().indexOf(this) < 0) {
            return;
        }
        long l = 9000L + (long)this.duf.nextInt(9000);
        this.dvv = System.currentTimeMillis() + l;
        this.chat.system(a.b("\ubeca\uc751\u4df7\ud3f3\u582e\ude9e\u64c7\ued38\u7366\uf9a2\u7e78\u847b\u0aa4\u9310\u194e\u9baa\u2582\uaa21\u30e7\ub6c3\u3f36\u4170", -1871004989) + l / 1000L + a.b("\u972f\ueaff", 1411094285));
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
            pjd.keep(this);
            this.dwv();
        }
        this.dwj();
    }

    private void dwj() {
        if (this.connection == null || !this.duy.wantsBotFrame() || !edj.enter(this)) {
            return;
        }
        try {
            if (dtv.dtw.field_1724 != null && dtv.dtw.field_1687 != null && dtv.dtw.field_1761 != null) {
                this.duy.onBotFrame();
            }
        }
        catch (Throwable throwable) {
            if (this.dwk()) {
                this.chat.system(a.c(1765598822, "\ue261\u9b86\u1125\u8f5d\u0481\u823a\u3c79\ub192\u2fc7\ua572\u22d5\ud8d4\u5213\ucbc3\u41a4\uc754\u7d00\uf2e9\u686c\uee2e\u67cf\u1d9f\u9327\u08a2\u8ec7") + throwable);
            }
        }
        finally {
            edj.exit();
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
        edb edb2 = this.connection;
        if (edb2 == null || !edj.enter(this)) {
            return;
        }
        long l = System.nanoTime();
        try {
            edb2.drain(6000000L);
            if (this.connection == null) {
                return;
            }
            if (dtv.dtw.field_1724 != null && dtv.dtw.field_1687 != null && dtv.dtw.field_1761 != null && this.handler != null) {
                this.dwm();
            } else {
                edb2.method_10754();
            }
        }
        catch (Throwable throwable) {
            if (this.dwk()) {
                this.chat.system(a.d("\ua6f8\udf1f\u55bc\ucbc4\u4018\uc6a3\u78e0\uf573\u6b56\ue1e5\u663c\u9847\u168a", -1693564075, 452911550) + throwable);
                if (Boolean.getBoolean(a.d("\u36f5\u4f4e\uc59e\u5bf7\ud065\u56c8\uecc6\u6521\ufb77\u71cc\uf60d\u0c6d\u82ac\u1b1a", -1745060301, -516863826))) {
                    throwable.printStackTrace(System.out);
                }
            }
        }
        finally {
            edj.exit();
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
            if (dtv.dtw.field_1724 != null && dtv.dtw.field_1687 != null) continue;
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
        if (dtv.dtw.field_1724 == null || dtv.dtw.field_1687 == null) {
            return;
        }
        ClientWorld clientWorld = dtv.dtw.field_1687;
        clientWorld.method_54719().method_54755();
        int n = this.dwy();
        if (n > 0) {
            this.dwz(n - 1);
        }
        this.control.apply(this);
        dtv.dtw.field_1773.method_3190(1.0f);
        dtv.dtw.field_1761.method_2927();
        if (this.connection == null || dtv.dtw.field_1724 == null || dtv.dtw.field_1687 == null) {
            return;
        }
        clientWorld = dtv.dtw.field_1687;
        ClientPlayerEntity clientPlayerEntity = dtv.dtw.field_1724;
        this.dwo(clientPlayerEntity, this.duy.isEnabled());
        if (dtv.dtw.field_1755 != null) {
            this.dvj = 10000;
            try {
                dtv.dtw.field_1755.method_25393();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dtv.dtw.field_1755 == null) {
            this.dwq(clientPlayerEntity);
            if (this.dvj > 0) {
                --this.dvj;
            }
        }
        this.dwn(clientWorld, clientPlayerEntity);
        clientWorld.method_8441(() -> true);
        clientWorld.method_38534();
        clientWorld.method_2935().method_12130().method_15516();
        if (this.handler != null) {
            this.handler.method_52787((Packet)ClientTickEndC2SPacket.field_52333);
        }
        if (this.duw.isEnabled() && dtv.dtw.field_1724 != null) {
            this.duw.onEndTick(dtw);
        }
        if (this.duy.isEnabled() && dtv.dtw.field_1724 != null) {
            this.duy.onEndTick(dtw);
        }
        if (this.dva.isEnabled() && dtv.dtw.field_1724 != null) {
            this.dva.onEndTick(dtw);
        }
        if (this.dvc.isEnabled() && dtv.dtw.field_1724 != null) {
            this.dvc.onEndTick(dtw);
        }
        this.dwp();
        this.dwa.tick();
        this.captcha.tick();
    }

    private void dwn(ClientWorld clientWorld, ClientPlayerEntity clientPlayerEntity) {
        Entity entity = clientPlayerEntity.method_5668();
        if (!entity.method_31481()) {
            clientWorld.method_18646(entity);
        }
        for (Entity entity2 : clientWorld.method_18112()) {
            if (entity2 == entity || entity2 == clientPlayerEntity || entity2.method_31481() || entity.method_5821(entity2)) continue;
            if ((entity2 instanceof LivingEntity && !(entity2 instanceof PlayerEntity) || entity2 instanceof ItemEntity) && !entity2.method_5765() && entity2.method_5858((Entity)clientPlayerEntity) < 2304.0) {
                try {
                    clientWorld.method_18646(entity2);
                }
                catch (Throwable throwable) {}
                continue;
            }
            entity2.method_22862();
            PositionInterpolator positionInterpolator = entity2.method_66233();
            if (positionInterpolator == null || !positionInterpolator.method_66270()) continue;
            Vec3d vec3d = positionInterpolator.method_66265();
            float f = positionInterpolator.method_66268();
            float f2 = positionInterpolator.method_66269();
            positionInterpolator.method_66272();
            entity2.method_33574(vec3d);
            entity2.method_36456(f);
            entity2.method_36457(f2);
        }
    }

    private void dwo(ClientPlayerEntity clientPlayerEntity, boolean bl) {
        if (!clientPlayerEntity.method_29504()) {
            this.dvh = 0;
            return;
        }
        if (++this.dvh == 1) {
            this.dvi = 30 + this.duf.nextInt(10);
        }
        if (!bl && this.dvh == this.dvi || this.dvh % 200 == 0) {
            clientPlayerEntity.method_7331();
        }
    }

    private void dwp() {
        if (this.dvx > 0 && --this.dvx == 0) {
            this.dvx = -1;
            if (this.dvw != null && this.handler != null) {
                this.handler.method_45730(this.dvw.substring(1));
                this.chat.system(a.c(-433003123, "\ue18a\u981a\u12c5\u8cc4\u076f\u81a0\u3b8e\ub209\u2c24\ua28c\u214d\udb4b\u55e7\ucc5c\u421b\uc0f4\u7ac7\uf56b\u6fa7\ue986\u6073\u1a2b\u9496\u0f4f"));
            }
            if (this.dux || this.duz || this.dvb || this.dvd) {
                this.dvz = 100 + this.duf.nextInt(80);
            }
        }
        if (this.dvz > 0 && --this.dvz == 0) {
            this.dvz = -1;
            if (this.dux && !this.duw.isEnabled() && dtv.dtw.field_1724 != null) {
                this.duw.setBotRunning(true);
                this.chat.system(a.c(-1345598965, "\uca5f\ub3da\u3908\ua762\u2c9f\uaa05\u105c\u99e9\u03d7\u891a\u0eca\uf4b7\u7a62\ue7c3\u6987\uef71\u5531\uda9c\u4025\uc608\u4ff7"));
            } else if (this.duz && !this.duy.isEnabled() && dtv.dtw.field_1724 != null) {
                this.duy.setBotRunning(true);
                this.chat.system(a.d("\uda02\ua387\u2955\ub73f\u3cd0\uba57\u0017\u89f0\u17ae\u9d14\u1a89\ue499\u6a32\uf380\u79df\uff2c\u4173\ucab5\u5001\ud65f\u5fd4\u258f\uab40\u3099", -165975432, -1921929181));
            } else if (this.dvb && !this.dva.isEnabled() && dtv.dtw.field_1724 != null) {
                this.dva.setEnabledSilently(true);
                this.chat.system(a.b("\ucf56\ub6d3\u3c01\ua26b\u299e\uaf0b\u155f\u9ca5\u02bf\u8c6f\u0bc0\uf1b2\u7f69\ue6da\u6899\uea7f\u5037\udfe9\u4526\uc37d\u4af6\u30af", 1023790849));
            } else if (this.dvd && !this.dvc.isEnabled() && dtv.dtw.field_1724 != null) {
                this.dvc.setBotRunning(true);
                this.chat.system(a.b("\ua71e\ude80\u545e\uca25\u41fe\uc744\u7d0d\uf4ce\u6ab6\ue014\u67d8\u9da1\u1361\u8a82\u04b0\u823d\u3871\ub7ac\u2d1d\uaf5c\u22bc\u58ea\ud656\u4dfb\ucb8e\u4123\uf898", 1969334084));
            }
        }
    }

    private void dwq(ClientPlayerEntity clientPlayerEntity) {
        int n;
        GameOptions gameOptions = dtv.dtw.field_1690;
        for (n = 0; n < 9; ++n) {
            if (!gameOptions.field_1852[n].method_1436() || clientPlayerEntity.method_7325()) continue;
            clientPlayerEntity.method_31548().method_61496(n);
        }
        while (gameOptions.field_1831.method_1436()) {
            if (clientPlayerEntity.method_7325() || this.handler == null) continue;
            this.handler.method_52787((Packet)new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.field_12969, BlockPos.field_10980, Direction.field_11033));
        }
        while (gameOptions.field_1869.method_1436()) {
            if (clientPlayerEntity.method_7325() || !clientPlayerEntity.method_7290(false)) continue;
            clientPlayerEntity.method_6104(Hand.field_5808);
        }
        n = 0;
        if (clientPlayerEntity.method_6115()) {
            if (!gameOptions.field_1904.method_1434()) {
                dtv.dtw.field_1761.method_2897((PlayerEntity)clientPlayerEntity);
            }
            while (gameOptions.field_1886.method_1436()) {
            }
            while (gameOptions.field_1904.method_1436()) {
            }
            while (gameOptions.field_1871.method_1436()) {
            }
        } else {
            while (gameOptions.field_1886.method_1436()) {
                n |= this.dws(clientPlayerEntity);
            }
            while (gameOptions.field_1904.method_1436()) {
                this.dwt(clientPlayerEntity);
            }
            while (gameOptions.field_1871.method_1436()) {
            }
        }
        if (gameOptions.field_1904.method_1434() && this.dwy() == 0 && !clientPlayerEntity.method_6115()) {
            this.dwt(clientPlayerEntity);
        }
        this.dwr(clientPlayerEntity, dtv.dtw.field_1755 == null && n == 0 && gameOptions.field_1886.method_1434());
    }

    private void dwr(ClientPlayerEntity clientPlayerEntity, boolean bl) {
        if (!bl) {
            this.dvj = 0;
        }
        if (this.dvj > 0 || clientPlayerEntity.method_6115()) {
            return;
        }
        if (clientPlayerEntity.method_5998(Hand.field_5808).method_57826(DataComponentTypes.field_63631)) {
            return;
        }
        if (bl && dtv.dtw.field_1765 != null && dtv.dtw.field_1765.method_17783() == HitResult.Type.field_1332) {
            BlockHitResult blockHitResult = (BlockHitResult)dtv.dtw.field_1765;
            BlockPos blockPos = blockHitResult.method_17777();
            if (!dtv.dtw.field_1687.method_8320(blockPos).method_26215() && dtv.dtw.field_1761.method_2902(blockPos, blockHitResult.method_17780())) {
                clientPlayerEntity.method_6104(Hand.field_5808);
            }
            return;
        }
        dtv.dtw.field_1761.method_2925();
    }

    private boolean dws(ClientPlayerEntity clientPlayerEntity) {
        if (this.dvj > 0) {
            return false;
        }
        if (dtv.dtw.field_1765 == null) {
            if (dtv.dtw.field_1761.method_2924()) {
                this.dvj = 10;
            }
            return false;
        }
        if (clientPlayerEntity.method_3144()) {
            return false;
        }
        ItemStack itemStack = clientPlayerEntity.method_5998(Hand.field_5808);
        if (!itemStack.method_45435(dtv.dtw.field_1687.method_45162())) {
            return false;
        }
        if (clientPlayerEntity.method_75202(itemStack, 0)) {
            return false;
        }
        PiercingWeaponComponent piercingWeaponComponent = (PiercingWeaponComponent)itemStack.method_58694(DataComponentTypes.field_63631);
        if (piercingWeaponComponent != null && !dtv.dtw.field_1761.method_2928()) {
            dtv.dtw.field_1761.method_75407(piercingWeaponComponent);
            clientPlayerEntity.method_6104(Hand.field_5808);
            return true;
        }
        boolean bl = false;
        switch (dtv.dtw.field_1765.method_17783()) {
            case field_1331: {
                AttackRangeComponent attackRangeComponent = (AttackRangeComponent)itemStack.method_58694(DataComponentTypes.field_64680);
                if (attackRangeComponent != null && !attackRangeComponent.method_76736((LivingEntity)clientPlayerEntity, dtv.dtw.field_1765.method_17784())) break;
                dtv.dtw.field_1761.method_2918((PlayerEntity)clientPlayerEntity, ((EntityHitResult)dtv.dtw.field_1765).method_17782());
                break;
            }
            case field_1332: {
                BlockHitResult blockHitResult = (BlockHitResult)dtv.dtw.field_1765;
                BlockPos blockPos = blockHitResult.method_17777();
                if (!dtv.dtw.field_1687.method_8320(blockPos).method_26215()) {
                    dtv.dtw.field_1761.method_2910(blockPos, blockHitResult.method_17780());
                    if (!dtv.dtw.field_1687.method_8320(blockPos).method_26215()) break;
                    bl = true;
                    break;
                }
            }
            case field_1333: {
                if (dtv.dtw.field_1761.method_2924()) {
                    this.dvj = 10;
                }
                clientPlayerEntity.method_7350();
                break;
            }
        }
        if (!clientPlayerEntity.method_7325()) {
            clientPlayerEntity.method_6104(Hand.field_5808);
        }
        return bl;
    }

    private void dwt(ClientPlayerEntity clientPlayerEntity) {
        if (dtv.dtw.field_1761.method_2923()) {
            return;
        }
        this.dwz(4);
        if (clientPlayerEntity.method_3144()) {
            return;
        }
        for (Hand hand : Hand.values()) {
            Entity entity;
            EntityHitResult entityHitResult;
            ItemStack itemStack = clientPlayerEntity.method_5998(hand);
            if (!itemStack.method_45435(dtv.dtw.field_1687.method_45162())) {
                return;
            }
            HitResult hitResult = dtv.dtw.field_1765;
            if (hitResult != null) {
                if (hitResult.method_17783() == HitResult.Type.field_1331) {
                    entityHitResult = (EntityHitResult)hitResult;
                    entity = entityHitResult.method_17782();
                    if (!dtv.dtw.field_1687.method_8621().method_11952(entity.method_24515())) {
                        return;
                    }
                    if (clientPlayerEntity.method_56094(entity, 0.0)) {
                        ActionResult actionResult = dtv.dtw.field_1761.method_2917((PlayerEntity)clientPlayerEntity, entity, entityHitResult, hand);
                        if (!actionResult.method_23665()) {
                            actionResult = dtv.dtw.field_1761.method_2905((PlayerEntity)clientPlayerEntity, entity, hand);
                        }
                        if (actionResult instanceof ActionResult.Success) {
                            ActionResult.Success success = (ActionResult.Success)actionResult;
                            if (success.comp_2909() == ActionResult.SwingSource.field_52427) {
                                clientPlayerEntity.method_6104(hand);
                            }
                            return;
                        }
                    }
                } else if (hitResult.method_17783() == HitResult.Type.field_1332) {
                    entityHitResult = dtv.dtw.field_1761.method_2896(clientPlayerEntity, hand, (BlockHitResult)hitResult);
                    if (entityHitResult instanceof ActionResult.Success) {
                        entity = (ActionResult.Success)entityHitResult;
                        if (entity.comp_2909() == ActionResult.SwingSource.field_52427) {
                            clientPlayerEntity.method_6104(hand);
                        }
                        return;
                    }
                    if (entityHitResult instanceof ActionResult.Fail) {
                        return;
                    }
                }
            }
            if (itemStack.method_7960() || !((entityHitResult = dtv.dtw.field_1761.method_2919((PlayerEntity)clientPlayerEntity, hand)) instanceof ActionResult.Success)) continue;
            entity = (ActionResult.Success)entityHitResult;
            if (entity.comp_2909() == ActionResult.SwingSource.field_52427) {
                clientPlayerEntity.method_6104(hand);
            }
            return;
        }
    }

    int loadDistance() {
        ehy ehy2 = this.handler;
        return ehy2 == null ? egq.get().getViewDistance() : ehy2.loadDistance();
    }

    float partialTick() {
        return MathHelper.method_15363((float)((float)(System.nanoTime() - this.dvo) / 5.0E7f), (float)0.0f, (float)1.0f);
    }

    double mouseMultiplier() {
        double d = this.dug * (double)0.6f + (double)0.2f;
        return d * d * d * 8.0;
    }

    @Override
    public double mouseStep() {
        return prp.step(this.mouseMultiplier());
    }

    @Override
    public void look(float f, float f2) {
        ClientPlayerEntity clientPlayerEntity = dtv.dtw.field_1724;
        if (clientPlayerEntity == null || ejp.current() != this || !Float.isFinite(f) || !Float.isFinite(f2)) {
            return;
        }
        double d = this.mouseMultiplier();
        float f3 = clientPlayerEntity.method_36454();
        float f4 = clientPlayerEntity.method_36455();
        double d2 = (double)f - (double)f3;
        double d3 = Math.floor((d2 + 180.0) / 360.0) * 360.0;
        float f5 = (float)((double)f3 + d3) + prp.quantize(d2 - d3, d);
        float f6 = MathHelper.method_15363((float)(f4 + prp.quantize((double)f2 - (double)f4, d)), (float)-90.0f, (float)90.0f);
        clientPlayerEntity.method_36456(f5);
        clientPlayerEntity.method_36457(f6);
    }

    @Override
    public boolean heldByHuman(KeyBinding keyBinding) {
        return this.control.isHeld(keyBinding);
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
        if (matcher.matches() && !pjd.enter(this, matcher.group(1))) {
            if (string2.equalsIgnoreCase(this.dvr)) {
                pjd.cancel(this);
                this.dvr = null;
                this.chat.system(a.c(902851001, "\u6daa\u1442\u9ee3\u00e7\u8b45\u0df5\ub7de\u3a43\ua001\u2abd\ua97e\u534e\udd96") + matcher.group(1) + a.d("\ub6b9\ucb16\u41b9\udfb6\u5468\ud2d1\u688a\ue173\u7f21", -171275629, -443466749));
            } else {
                this.dvr = string2;
                this.dvs = System.currentTimeMillis();
                this.chat.system(a.d("\u5c87\u251b\uabd8\u35e8\ube30", 1984706464, -93032641) + matcher.group(1) + a.b("\u58f1\u2523\uaf85\u31f7\ube35", -728999724) + 3 + a.d("\u3a6a\u47c6\ucd18\u5311\ud8b6\u5e7a\ue04c\u4989\uf7e2\u7945\ufe94\u0492\u8e26\u138b\u99d1\u1f54\ua518\u2abb\ub418\u3241", 157370480, 1207792174) + pjd.position(this) + a.b("\u0969\u74cc\ufa0f\u6479\uefa0\u6d2e\ud75c\u5ea1\uc08e\u4a43\ucdee\u37e7\ubd28\u2083\uaad4\u2c27\u9664\u19b8\u8302\u0524\u88bc\uf2e1\u7835\ue3e1\u65e2\uef3c\u56f5\udccf\u4226\uc40b\u4fc6\ub11e\u3b59\ua2ad\u2484\uae3b", -110556832));
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
            if (string4.startsWith(a.b("\u6e46", -912626072))) {
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
        if (matcher.matches() && pjd.enter(this, matcher.group(1))) {
            this.dvr = null;
            this.chat.system(a.b("\udef7\ua76f\u2dc8\ub3ba\u3811\ubabe\u04f0\u8d0c\u1743\u9db3\u1a6f", 1292360416) + matcher.group(1) + a.c(-820101608, "\u3e20\u438f\uc923\u5721\udcfa\u5a44\ue018\u69e3\uf7b0\u7d02\ufad4\u00da\u8e00\u13dd\ub9ba\u1f7f\ua12f\u2ef4\ub432\u3216\ubb91\uc1bb\u4f00\ud4a4"));
            this.sendChat(string);
        }
    }

    private void dww(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        String[] stringArray = string.split(a.c(-1374606266, "\u2c19\u5587\udf0c"));
        String string3 = null;
        if ((string2.startsWith(a.c(1171058936, "\uf0d0\u8922\u03f2\u9d8b\u1652\u90e4\u2af9")) || string2.startsWith(a.c(-1054523916, "\u3dd8\u442a\uceb5")) || string2.startsWith(a.b("\u7bae\u025c\u888c\u16f5\u9d65", 558922628))) && stringArray.length >= 2) {
            string3 = a.b("\u7cf7\u0505\u8fd5\u11ac\u9a75\u1cc3\ua6de", 1036680415) + stringArray[1];
        } else if ((string2.startsWith(a.c(1114159556, "\ub9ee\uc002\u4ac6\ud4b5\u5f25")) || string2.startsWith(a.d("\ue9a1\u904d\u1a89\u84fa\u0f23\u8988\u33dc\uba3c\u2474\uae97", -2073614061, -139018089))) && stringArray.length >= 2) {
            string3 = a.b("\u5769\u2e9b\ua44b\u3a32\ub1eb\u375d\u8d40", 1005213505) + stringArray[1];
        }
        if (string3 != null && !string3.equals(this.dvw)) {
            this.dvw = string3;
            egq.get().persist();
        }
    }

    String loginPassword() {
        return this.dvw == null ? null : this.dvw.substring(a.d("\u0f53\u76a1\ufc71\u6208\ue9d1\u6f67\ud57a", -1037593122, -1894147419).length());
    }

    void restore(String string, boolean bl) {
        this.dvw = string == null || string.isBlank() ? null : a.d("\u1842\u61b0\ueb60\u7519\ufec0\u7876\uc26b", 70120623, -1251152699) + string;
        this.dvt = bl;
    }

    private void dwx() {
        if (this.dvc.isEnabled()) {
            this.dvc.setBotRunning(false);
            this.chat.system(a.c(1272024124, "\u8c65\uf5fb\u7f25\ue15e\u6a85\uec3f\u5676\udfb5\u41cd\ucb6f\u4ca3\ub6da\u381a\ua1f9\u2fb4\ua93a\u1376\u9cd5\u066b\u8039\u09c2\u739a\ufd27\u66fe"));
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
            if (dtv.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                this.dwx();
            }
            if (bl && this.duy.isEnabled()) {
                this.duy.setBotRunning(false);
                this.chat.system(a.b("\u0166\u78e3\uf231\u6c5b\ue7b4\u6133\udb73\u5294\uccca\u4670\uc1ed\u3f82\ub12a\u2898\ua2b9\u2445\u9e09\u11d4\u8b6e\u0d31\u84ce", 2015101234));
            }
            if (bl && this.dva.isEnabled()) {
                this.dva.setEnabledSilently(false);
                this.chat.system(a.c(2128170065, "\u4c03\u3586\ubf54\u213e\uaacb\u2c5e\u960a\u1ff0\u81ea\u0f45\u88e9\u729b\ufc3e\u6582\uefd2\u692f\ud369\u5cb6\uc60d"));
            }
            if (bl && !this.duw.isEnabled()) {
                this.duw.setBotRunning(true);
                this.chat.system(a.d("\u7052\u09d7\u8305\u1d6f\u9692\u1008\uaa51\u23e4\ub9ac\u331a\ub4c6\u4ecb\uc016\u59db\ud380", 986551585, 2006246717));
            } else if (!bl && this.duw.isEnabled()) {
                this.duw.setBotRunning(false);
                this.chat.system(a.b("\u6302\u1a87\u9055\u0e3f\u85c2\u0358\ub901\u30b4\uaaf5\u203b\ua7eb\u5de8\ud332\u4a80\uc0df\u4627\ufc66\u73bf", 548168529));
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
            if (dtv.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                this.dwx();
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                    this.chat.system(a.d("G\u79c2\uf310\u6d7a\ue687\u601d\uda44\u53f1\uc9b0\u437e\uc4ae\u3ead\ub077\u29c5\ua39a\u2562\u9f23\u10fa", -7751788, 1876932480));
                }
                if (this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(false);
                    this.chat.system(a.c(-1983854941, "\uc6f1\ubf74\u35a6\uabcc\u2039\ua6ac\u1cf8\u9502\u0b18\u85b7\u021b\uf869\u76cc\uef70\u6520\ue3dd\u599b\ud644\u4cff"));
                }
                if (!this.duy.isEnabled()) {
                    this.duy.setBotRunning(true);
                    this.chat.system(a.d("\uf340\u8ac5\u0017\u9e7d\u1592\u9315\u2955\ua0b2\u3eec\ub456\u33cb\ucdad\u437d\udac3\u50ec\ud617\u6c24\ue3fd\u7d5f\ufb02\u76ee\u0cc7\u8275\u1ddc\u9bb9", -1084381516, 35018156) + this.duy.getCurrentLootAnarchy());
                }
            } else if (this.duy.isEnabled()) {
                this.duy.setBotRunning(false);
                this.chat.system(a.d("\u357c\u4cf9\uc62b\u5841\ud3ae\u5529\uef69\u668e\uf8d0\u726a\uf5f7\u0b98\u8530\u1c82\u96a3\u105f\uaa13\u25ce\ubf74\u392b\ub0d4", -1959602666, 347005758));
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
            if (dtv.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                this.dwx();
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                    this.chat.system(a.c(608327891, "\u5880\u2105\uabd7\u35bd\ube40\u38da\u8283\u0b36\u9177\u1bb9\u9c69\u666a\ue8b0\u7102\ufb5d\u7da5\uc7e4\u483d"));
                }
                if (this.duy.isEnabled()) {
                    this.duy.setBotRunning(false);
                    this.chat.system(a.d("\u75dc\u0c59\u868b\u18e1\u930e\u1589\uafc9\u262e\ub870\u32ca\ub557\u4b38\uc590\u5c22\ud603\u50ff\ueab3\u656e\uffd4\u798b\uf074", -1324122829, -974452549));
                }
                if (!this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(true);
                    this.chat.system(a.b("\ub52a\uccaf\u467d\ud817\u53e2\ud577\u6f23\ue6d9\u78c3\uf665\u71b1\u8bcf\u0564\u9cdf\u16f0\u9009", -470764165));
                }
            } else if (this.dva.isEnabled()) {
                this.dva.setEnabledSilently(false);
                this.chat.system(a.c(804619860, "\u8606\uff83\u7551\ueb3b\u60ce\ue65b\u5c0f\ud5f5\u4bef\uc540\u42ec\ub89e\u363b\uaf87\u25d7\ua32a\u196c\u96b3\u0c08"));
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
            if (dtv.dtw.field_1724 == null) {
                return;
            }
            if (bl) {
                if (this.duw.isEnabled()) {
                    this.duw.setBotRunning(false);
                    this.chat.system(a.c(825572945, "\u3e02\u4787\ucd55\u533f\ud8c2\u5e58\ue401\u6db4\uf7f5\u7d3b\ufaeb\u00e8\u8e32\u1780\u9ddf\u1b27\ua166\u2ebf"));
                }
                if (this.duy.isEnabled()) {
                    this.duy.setBotRunning(false);
                    this.chat.system(a.d("\uf962\u80e7\u0a35\u945f\u1fb0\u9937\u2377\uaa90\u34ce\ube74\u39e9\uc786\u492e\ud09c\u5abd\udc41\u660d\ue9d0\u736a\uf535\u7cca", 1079223721, -1653384033));
                }
                if (this.dva.isEnabled()) {
                    this.dva.setEnabledSilently(false);
                    this.chat.system(a.c(422332887, "\u4985\u3000\ubad2\u24b8\uaf4d\u29d8\u938c\u1a76\u846c\u0ac3\u8d6f\u771d\uf9b8\u6004\uea54\u6ca9\ud6ef\u5930\uc38b"));
                }
                if (!this.dvc.isEnabled()) {
                    this.dvc.setBotRunning(true);
                    this.chat.system(a.c(130244382, "\u5f4a\u26d4\uac0a\u3271\ub9aa\u3f10\u8559\u0c9a\u92e2\u1840\u9f8c\u65f5\ueb35\u72d6\ufc92\u7a64\uc024\u4f89\ud530\u531d\udae2"));
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
                this.chat.system(a.c(-242699480, "\ub37a\ucaff\u402d\ude47\u55b2\ud327\u6973\ue089\u7e93\uf03c\u7790\u8de2\u0347\u9afb\u10ab\u9656\u2c10\ua3cf\u3974"));
            }
            if (this.duw.isEnabled()) {
                this.duw.setBotRunning(false);
                this.chat.system(a.c(1195806058, "\u8d39\uf4bc\u7e6e\ue004\u6bf9\ued63\u573a\ude8f\u44ce\uce00\u49d0\ub3d3\u3d09\ua4bb\u2ee4\ua81c\u125d\u9d84"));
            }
            if (this.duy.isEnabled()) {
                this.duy.setBotRunning(false);
                this.chat.system(a.d("\u6c7c\u15f9\u9f2b\u0141\u8aae\u0c29\ub669\u3f8e\ua1d0\u2b6a\uacf7\u5298\udc30\u4582\ucfa3\u495f\uf313\u7cce\ue674\u602b\ue9d4", 2145452242, 1243376890));
            }
        });
    }

    public void boostItemUse(int n) {
        if (this.dwy() > n) {
            this.dwz(Math.max(0, n));
        }
    }

    private int dwy() {
        return edj.holdsUseCooldown(this) ? edj.useCooldown() : this.itemUseCooldown;
    }

    private void dwz(int n) {
        if (edj.holdsUseCooldown(this)) {
            edj.useCooldown(n);
        } else {
            this.itemUseCooldown = n;
        }
    }

    public void selectSlot(int n) {
        this.post(() -> {
            if (dtv.dtw.field_1724 != null && n >= 0 && n < 9) {
                dtv.dtw.field_1724.method_31548().method_61496(n);
            }
        });
    }

    public void clickSlot(int n, int n2, int n3, SlotActionType slotActionType) {
        this.post(() -> {
            if (dtv.dtw.field_1724 != null && dtv.dtw.field_1761 != null && dtv.dtw.field_1724.field_7512.field_7763 == n) {
                dtv.dtw.field_1761.method_2906(n, n2, n3, slotActionType, (PlayerEntity)dtv.dtw.field_1724);
            }
        });
    }

    public void closeScreen() {
        this.post(() -> {
            if (dtv.dtw.field_1724 == null) {
                return;
            }
            if (dtv.dtw.field_1724.field_7512 != dtv.dtw.field_1724.field_7498) {
                dtv.dtw.field_1724.method_7346();
            } else if (dtv.dtw.field_1755 != null) {
                dtw.method_1507(null);
            }
            this.duv = null;
        });
    }

    public void dropSelected(boolean bl) {
        this.post(() -> {
            if (dtv.dtw.field_1724 != null && !dtv.dtw.field_1724.method_7325() && dtv.dtw.field_1724.method_7290(bl)) {
                dtv.dtw.field_1724.method_6104(Hand.field_5808);
            }
        });
    }

    public void swapHands() {
        this.post(() -> {
            if (this.handler != null && dtv.dtw.field_1724 != null && !dtv.dtw.field_1724.method_7325()) {
                this.handler.method_52787((Packet)new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.field_12969, BlockPos.field_10980, Direction.field_11033));
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
            if (dtv.dtw.field_1724 != null && dtv.dtw.field_1724.method_29504()) {
                dtv.dtw.field_1724.method_7331();
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
        if ((this.duw.isEnabled() || this.duy.isEnabled() || this.dva.isEnabled() || this.dvc.isEnabled()) && this.player != null && edj.enter(this)) {
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
                edj.exit();
            }
        }
        pjd.leave(this);
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
                    izx.alert(this.dud, string, vhz.INFO, bl);
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
        egq.get().persist();
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

    public ClientPlayerEntity getPlayer() {
        return this.player;
    }

    public ClientWorld getWorld() {
        return this.world;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public String getOpenedScreenTitle() {
        return this.duv;
    }

    public eck getChat() {
        return this.chat;
    }

    public eff getControl() {
        return this.control;
    }

    public eip getRadar() {
        return this.dwa;
    }

    public eao getCaptcha() {
        return this.captcha;
    }

    public long getLastSent() {
        return this.dup;
    }

    public Text replyToLastSent() {
        ech ech2 = this.dup == 0L ? null : this.chat.firstServerAfter(this.dup, 5000L);
        return ech2 == null ? null : ech2.text;
    }

    public mpq f0ref() {
        return this.duw;
    }

    public nxa f1ref() {
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

    public lqq f3ref() {
        return this.dvc;
    }

    public boolean f3Run() {
        return this.dvc.isEnabled();
    }

    public boolean f3Want() {
        return this.dvd;
    }

    public nfl f2ref() {
        return this.dva;
    }

    public boolean f2Run() {
        return this.dva.isEnabled();
    }

    public boolean f2Want() {
        return this.dvb;
    }

    public dyh getCamera() {
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
            egq.get().persist();
        }
    }

    public boolean hasLoginCommand() {
        return this.dvw != null;
    }

    public void forgetLogin() {
        if (this.dvw != null) {
            this.dvw = null;
            egq.get().persist();
        }
    }

    public long getReconnectAt() {
        return this.dvv;
    }

    public Text getActionBar() {
        return System.currentTimeMillis() - this.dur < 3000L ? this.duq : null;
    }

    public Text getTitle() {
        return System.currentTimeMillis() - this.duu < 4000L ? this.dus : null;
    }

    public Text getSubtitle() {
        return System.currentTimeMillis() - this.duu < 4000L ? this.dut : null;
    }

    public Map<UUID, ClientBossBar> getBossBars() {
        return this.bossBars;
    }

    public float getTickMillis() {
        return this.dvn;
    }

    public int getPing() {
        ehy ehy2 = this.handler;
        if (ehy2 == null) {
            return -1;
        }
        PlayerListEntry playerListEntry = ehy2.method_2871(this.due);
        return playerListEntry == null ? -1 : playerListEntry.method_2959();
    }

    public float takePeakTickMillis() {
        float f = this.dvp;
        this.dvp = 0.0f;
        return f;
    }

    public int getPendingPackets() {
        edb edb2 = this.connection;
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

    Text getTabHeader() {
        return this.tabHeader;
    }

    Text getTabFooter() {
        return this.tabFooter;
    }

    ClientPlayNetworkHandler getHandler() {
        return this.handler;
    }

    static {
        dtz = a.d("\u8e95\uf767\u7db7\ue3ce\u6817\ueea1\u54bc", -1482419073, -1385784638);
        dtw = MinecraftClient.method_1551();
        dua = Pattern.compile(a.d("\u0973\u708c\ufa50\u6413\uefeb\u6903\ud352\u5ad7\uc4b0\u4e4e\uc99f\u339b\ubd63\u248b", -254349818, 1927997268), 2);
        duc = new double[]{0.5, 0.47, 0.43, 0.39, 0.52, 0.55, 0.36, 0.45, 0.41};
    }

    private static /* synthetic */ int at(int n, int n2) {
        return n + n2 ^ 0xAC6DA06D;
    }

    private static /* synthetic */ int au(int n, int n2) {
        return dtv.at(n, n2) ^ 0xBF8424F3;
    }

    private static /* synthetic */ int av(int n, int n2) {
        return dtv.au(n, n2) + n;
    }
}

