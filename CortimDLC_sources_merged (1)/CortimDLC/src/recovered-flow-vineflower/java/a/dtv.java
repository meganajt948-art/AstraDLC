package a;

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
import net.minecraft.client.network.ServerInfo.ResourcePackPolicy;
import net.minecraft.client.network.ServerInfo.ServerType;
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
import net.minecraft.network.message.ChatVisibility;
import net.minecraft.network.packet.BundlePacket;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.SyncedClientOptions;
import net.minecraft.network.packet.c2s.login.LoginHelloC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientTickEndC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.network.state.LoginStates;
import net.minecraft.particle.ParticlesMode;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.Uuids;
import net.minecraft.util.ActionResult.Fail;
import net.minecraft.util.ActionResult.Success;
import net.minecraft.util.ActionResult.SwingSource;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.WorldChunk;

public final class dtv implements efz {
   private static final MinecraftClient dtw = MinecraftClient.method_1551();
   private static final long dtx = 50000000L;
   private static final long dty = 6000000L;
   private static final String dtz = a.d("躕\uf767綷\ue3ce栗\ueea1咼", -1482419073, -1385784638);
   private static final Pattern dua = Pattern.compile(a.d("ॳ炌祖搓\uefeb椃퍒嫗쒰乎즟㎛뵣⒋", -254349818, 1927997268), 2);
   private static final double dub = 2304.0;
   private static final double[] duc = new double[]{0.5, 0.47, 0.43, 0.39, 0.52, 0.55, 0.36, 0.45, 0.41};
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
   final Map<UUID, ClientBossBar> bossBars = new LinkedHashMap<>();
   final pth silent = new pth();
   volatile Object[] fabricAddons;
   final eck chat = new eck();
   final ehq packs = new ehq();
   final eff control = new eff();
   final eao captcha = new eao(this);
   private final ArrayDeque<Runnable> dum = new ArrayDeque<>();
   private final List<dtn> dun = new ArrayList<>();
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

   dtv(String var1, String var2) {
      this.dud = var1;
      this.due = Uuids.method_43344(var1);
      this.address = var2;
      this.dug = duc[this.duf.nextInt(duc.length)];
      this.duw = new mpq();
      this.duw.attachBot(this);
      mpq var3 = dwe();
      if (var3 != null) {
         this.duw.copySettingsFrom(var3);
      }

      this.duy = new nxa();
      this.duy.attachBot(this);
      nxa var4 = dwf();
      if (var4 != null) {
         this.duy.copySettingsFrom(var4);
      }

      this.dva = new nfl();
      this.dva.attachBot(this);
      kfx var5 = dwd();
      nfl var6 = var5 == null ? null : var5.get(nfl.class);
      if (var6 != null && !var6.isBotInstance()) {
         this.dva.copySettingsFrom(var6);
      }

      this.dvc = new lqq();
      this.dvc.attachBot(this);
      lqq var7 = lqq.get();
      if (var7 != null && var7 != this.dvc) {
         this.dvc.copySettingsFrom(var7);
      }
   }

   double sensitivity() {
      return this.dug;
   }

   private static kfx dwd() {
      Flow var0 = Flow.getInstance();
      return var0 == null ? null : var0.getModuleManager();
   }

   private static mpq dwe() {
      kfx var0 = dwd();
      mpq var1 = var0 == null ? null : var0.get(mpq.class);
      return var1 != null && !var1.isBotInstance() ? var1 : null;
   }

   private static nxa dwf() {
      kfx var0 = dwd();
      nxa var1 = var0 == null ? null : var0.get(nxa.class);
      return var1 != null && !var1.isBotInstance() ? var1 : null;
   }

   public void connect() {
      if (this.connection == null && !this.dul) {
         this.duk = false;
         this.dvu = false;
         this.dvv = 0L;
         if (!egq.get().tryStartJoin(this)) {
            this.dvv = System.currentTimeMillis() + 1200L + this.duf.nextInt(1300);
            this.dxa(dts.QUEUED, a.c(63894451, "\uf790訳Ӿ髶ᅓ鞗ⶱꑁ㨒뒻㝵촉䟎\uda6d偉훃沆"));
         } else {
            this.dul = true;
            this.dxa(dts.CONNECTING, a.b("蝆ﻶ琯\uea50憆\ue742崘풛䫌쁸䞦", 162890610));
            String var1 = this.address;
            Util.method_27958().execute(() -> this.dwg(var1));
         }
      }
   }

   boolean isJoining() {
      return this.dul || this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.JOINING;
   }

   private void dwg(String var1) {
      try {
         ServerAddress var2 = ServerAddress.method_2950(var1);
         Optional var10 = AllowedAddressResolver.field_33745.method_36907(var2).map(Address::method_36902);
         if (var10.isEmpty()) {
            this.dwh(a.b("묫싮䡈홋嶛\udb5f敬\ue880盗\uf873箽臁༟隣ᳱ騈", -1664761990));
            return;
         }

         InetSocketAddress var4 = (InetSocketAddress)var10.get();
         edb var5 = new edb(this);
         ClientConnection.method_52271(var4, NetworkingBackend.method_75867(dtw.field_1690.method_1639()), var5).syncUninterruptibly();
         synchronized (this) {
            this.dul = false;
            if (this.duk) {
               var5.method_10747(Text.method_43471(a.d("ࢅ焬ﯦ斏\uee45棭튢孞씙侴조㉝볗╡꼧⧃鎍ᱚ蚴º襉\uf304綪\ue67b怙\ueacf卵", -1215154949, -482460664)));
               this.dxa(dts.OFFLINE, a.c(1061586037, "聃年猥\ued55曷\ue04f娊펗"));
               return;
            }

            this.connection = var5;
         }

         var5.method_56326(var4.getHostName(), var4.getPort(), LoginStates.field_48247, LoginStates.field_48248, new egf(this, var5), false);
         var5.method_10743(new LoginHelloC2SPacket(this.dud, this.due));
         this.dxa(dts.LOGIN, a.b("맇쀁䪩퓒", -562709007));
      } catch (Throwable var9) {
         Throwable var3 = var9.getCause() != null ? var9.getCause() : var9;
         this.dwh(var3.getMessage() == null ? var3.getClass().getSimpleName() : var3.getMessage());
      }
   }

   private void dwh(String var1) {
      this.dul = false;
      this.connection = null;
      this.dxa(dts.FAILED, var1);
      dtw.execute(() -> {
         this.chat.system(a.d("늅쬜䗚\udfc8周틝梅\ue171网\uf5ed癒蠼۪齑ᔌ鏼⧆ꘞ㳒뫹㌀䥜쟡塅\ude20", -134078425, 924620454) + var1);
         this.dwi();
      });
   }

   public void disconnect() {
      this.dvu = true;
      this.dvv = 0L;
      synchronized (this) {
         this.duk = true;
      }

      edb var1 = this.connection;
      if (var1 != null) {
         var1.method_10747(Text.method_43471(a.d("\ud97eꃗ⨝둴㾾뤖͙誥ᓢ鹏ᦋ\ue3a6洬\uf49a络\uf838䉶춡坏텁墲⋿걑㞀뇢㬴芎", 1921927102, 850894518)));
      } else {
         if (this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.QUEUED) {
            this.dxa(dts.OFFLINE, a.b("⭾劳\ud818䙨췊䭲\uf137碪", -809685176));
         }
      }
   }

   ServerInfo serverInfo() {
      ServerInfo var1 = new ServerInfo(this.dud, this.address, ServerType.field_45611);
      var1.method_2995(ResourcePackPolicy.field_3768);
      return var1;
   }

   SyncedClientOptions syncedOptions() {
      int var1 = 0;

      for (PlayerModelPart var5 : PlayerModelPart.values()) {
         var1 |= var5.method_7430();
      }

      String var6 = dtw.field_1690 == null ? a.b("樲ᎈ饪ܱ賠", 317418066) : dtw.field_1690.field_1883;
      return new SyncedClientOptions(
         var6, egq.get().getViewDistance(), ChatVisibility.field_7538, true, var1, Arm.field_6183, false, true, ParticlesMode.field_18197
      );
   }

   void onLoginSuccess(GameProfile var1) {
      this.duo = true;
      this.dxa(dts.JOINING, a.d("最Ặ鑦\u0a64膰ݵ봫㓐꺟′\ua7e5巬퍋", -1822107416, 1577696210));
   }

   void onPlayHandler(ehy var1) {
      this.handler = var1;
   }

   void onJoinWorld(ClientWorld var1, ClientPlayerEntity var2) {
      this.dve.reset();
      this.dvf = 0;
      this.dvg = 0;
      this.dvh = 0;
      this.bossBars.clear();
      this.dwa.reset();
      boolean var3 = this.duo;
      if (var3) {
         this.duo = false;
         this.captcha.arm();
      } else {
         this.captcha.reset();
      }

      this.dxa(dts.ONLINE, a.c(931386785, "톕갶⋽벇㜣뇧"));
      if (!var3) {
         this.dvy = this.dvw == null ? 0L : System.currentTimeMillis() + 15000L;
      } else {
         this.chat.system(a.c(-1127663214, "㶊䐜캷僟\udb62姈\ue786湺\uf435童﵂݆解ၕ驳"));
         this.notifyHud(a.c(1916483836, "㳋䕶쿓冻\uda06"), true);
         if (this.dvw != null) {
            this.dvx = 30 + this.duf.nextInt(40);
         } else if (this.dux || this.duz || this.dvb || this.dvd) {
            this.dvz = 100 + this.duf.nextInt(80);
         }
      }
   }

   void onRespawn(ClientWorld var1, ClientPlayerEntity var2, boolean var3) {
      this.dvf = 0;
      this.dvg = 0;
      this.dvh = 0;
      if (var3) {
         this.dwa.reset();
         this.captcha.reset();
         this.dve.reset();
      }
   }

   void onReconfigure() {
      dtw.field_1724 = null;
      dtw.field_1687 = null;
      dtw.field_1761 = null;
      dtw.field_1755 = null;
      edj.camera(null);
      dtw.field_1765 = null;
      dtw.field_1692 = null;
      this.handler = null;
      this.bossBars.clear();
      this.dxa(dts.JOINING, a.b("풾괅➣릧㉿듊ບ蜒ᤱ鎋ᐨ\uee5a惽鷺猗\uf591", 1981993105));
   }

   void onChunksComing() {
      if (this.dvf == 0) {
         this.dvf = 1;
      }
   }

   void tickLoading(ehy var1) {
      ClientPlayerEntity var2 = dtw.field_1724;
      ClientWorld var3 = dtw.field_1687;
      if (var2 != null && var3 != null && !var1.method_76760()) {
         if (this.dvf == 0 && ++this.dvg > 100) {
            this.dvf = 1;
         }

         if (this.dvf == 1) {
            BlockPos var4 = var2.method_24515();
            boolean var5 = var3.method_31601(var4.method_10264())
               || var3.method_2935().method_12126(var4.method_10263() >> 4, var4.method_10260() >> 4, false) != null
               || var2.method_7325()
               || !var2.method_5805();
            if (var5) {
               this.dvf = 2;
               var1.markLoaded();
            }
         }
      }
   }

   void onServerMessage(Text var1, boolean var2) {
      this.onServerMessage(var1, var2, false);
   }

   void onLocalMessage(Text var1, boolean var2) {
      if (var1 != null) {
         if (var2) {
            this.duq = var1;
            this.dur = System.currentTimeMillis();
         } else {
            this.chat.server(var1, false);
         }
      }
   }

   void onServerMessage(Text var1, boolean var2, boolean var3) {
      if (var1 != null) {
         if (var2) {
            this.duq = var1;
            this.dur = System.currentTimeMillis();
         } else {
            this.chat.server(var1, var3);
            this.captcha.onHint(var1.getString());
            if (!var3) {
               if (this.dvy != 0L) {
                  if (System.currentTimeMillis() > this.dvy) {
                     this.dvy = 0L;
                  } else {
                     String var4 = var1.getString().toLowerCase(Locale.ROOT);
                     if (var4.contains(a.c(-287387852, "켝뛯㰿ꉆ⦟꼩"))
                        || var4.contains(a.c(174757471, "陳\uef81攞"))
                        || var4.contains(a.b("Ⓖ崏\ud7ac䦡숈䓁ﺝ眘\ue93d", 571678853))
                        || var4.contains(a.b("仜㝡붵⏉ꠒ⻙铽", 63064809))) {
                        this.dvy = 0L;
                        this.dvx = 20 + this.duf.nextInt(30);
                     }
                  }
               }

               if (this.duw.isEnabled()) {
                  try {
                     this.duw.onChatMessage(var1.getString());
                  } catch (Throwable var7) {
                  }
               }

               if (this.dva.isEnabled()) {
                  try {
                     this.dva.onChat(var1);
                  } catch (Throwable var6) {
                  }
               }

               if (this.dvc.isEnabled()) {
                  try {
                     this.dvc.onChat(var1);
                  } catch (Throwable var5) {
                  }
               }
            }
         }
      }
   }

   void onTitle(Text var1, boolean var2) {
      if (var1 == null) {
         this.dus = null;
         this.dut = null;
      } else {
         if (var2) {
            this.dut = var1;
         } else {
            this.dus = var1;
         }

         this.duu = System.currentTimeMillis();
      }
   }

   void onTotemPop() {
      this.chat.system(a.b("꯭툽增웮䴶쯻燚\uf820扤\uecb7欘鄕\u1fb5蘍", -1217482814));
      this.notifyHud(a.b("嫡⌬ꦃ㞅뱛", 990731942), false);
   }

   void onDeath(Text var1) {
      this.chat.system(a.d("삥뤉㏓귗☂ꂽẘ靳", -1998198293, 1706241383) + (var1 == null ? "" : var1.getString()));
      this.notifyHud(a.b("\u0c3a痴Ｎ愪", -1884223363), false);
   }

   void onScreenOpened(Text var1) {
      this.duv = var1 == null ? null : var1.getString();
   }

   void onChunkLoaded(WorldChunk var1) {
      this.dwa.onChunk(var1);
   }

   void onMapUpdated(MapIdComponent var1) {
      this.dwa.onMap(var1);
      this.captcha.onMap();
   }

   void onCaptcha() {
      this.chat.system(a.c(-1235440802, "꽲훩尵숼䦜쬽畳ﲏ曀\ue863濇闍ᬐ芠\u0cfc託㑂뮙⅚꜉⺄哐\uda64䆿쏐䴙\uf0b2竼\ue00a晞\uede3ᜧ饼\u0082蚥ࡻ뎶㧃뼚⚯꣠혜层\udfe1䄤쭋犜\uf82a繭\ue1a9毋鄕ᣞ黽"));
      this.notifyHud(a.d("厶⨍ꃑ㻘땸㟙趇ѻ鸹ᓶ鍐椢\ue7fd穑\uf418狭좨", -1766484419, 1726923168), false);
   }

   void onCaptchaGone() {
      this.chat.system(a.c(-1174595480, "ᱤ旿\uef5c焯廒簶왢侙헖孽\udca4⛚꡵ㆻ뿰㴞蜮ࢁ鈳ᑭ鶑\ue7cb"));
   }

   void onCaptchaSolved(String var1) {
      this.chat.system(a.b("ᶛ搀\ueedc烕ﭵ秔잘世퀷嫿\udd53❘ꧽぁ먟㣾蛐ॵ鎱ᗮ鰛\ue23e沗", -827057770) + var1);
      this.notifyHud(a.c(1621552910, "\ueb33銈ᡔ虝\u0dfd轆㔏") + var1, true);
      this.sendChat(var1);
   }

   void onCaptchaUnsolved(String var1) {
      this.chat.system(a.c(288103366, "Ὴ晑\uec8d犄襤箅엋䰲홸壖\udf7a╵ꯛ㈕렼㺿蓻ଡ釣ឿ騤\ue07d") + var1 + a.c(1897770882, "꾲혊峔슨䵭쯜熈\uf878昫\ue882歋鄾ΰ艆ఇ軤サ뽠◔ꎍ\u2e6f倯\ude93䔾쌳"));
   }

   void onPacketReceived() {
      this.dvq = System.currentTimeMillis();
   }

   void beforePacket(Packet<?> var1) {
      if (!(var1 instanceof BundlePacket var2)) {
         if (this.duy.isEnabled()) {
            try {
               this.duy.onPacket(var1);
            } catch (Throwable var7) {
            }
         }

         if (this.dvc.isEnabled()) {
            try {
               this.dvc.onPacket(var1);
            } catch (Throwable var6) {
            }
         }

         if (this.dva.isEnabled()) {
            try {
               this.dva.onPacket(var1);
            } catch (Throwable var5) {
            }
         }
      } else {
         for (Packet var4 : var2.method_48324()) {
            this.beforePacket(var4);
         }
      }
   }

   void onPacketError(Packet<?> var1, Throwable var2) {
      if (this.dwk()) {
         this.chat.system(a.b("ز翕\uf576欎\ue0d2晩\ud82a嗄쮔䄯웳㳵뉐⿱", 1257374242) + var1.getClass().getSimpleName() + a.c(-1052934378, "缮څ") + var2);
         if (Boolean.getBoolean(a.d("픹겂♒렻㎩딄༊蛭ᢻ鈀ᗁ\uefa1慠\uf8d6", -545526478, -2068432797))) {
            var2.printStackTrace(System.out);
         }
      }
   }

   void onDisconnected(Text var1) {
      boolean var2 = this.duh == dts.ONLINE;
      if (this.duw.isEnabled()) {
         try {
            this.duw.setBotRunning(false);
         } catch (Throwable var7) {
         }
      }

      if (this.duy.isEnabled()) {
         try {
            this.duy.setBotRunning(false);
         } catch (Throwable var6) {
         }
      }

      if (this.dva.isEnabled()) {
         try {
            this.dva.setEnabledSilently(false);
         } catch (Throwable var5) {
         }
      }

      if (this.dvc.isEnabled()) {
         try {
            this.dvc.setBotRunning(false);
         } catch (Throwable var4) {
         }
      }

      if (ejp.current() == this) {
         dtw.field_1724 = null;
         dtw.field_1687 = null;
         dtw.field_1761 = null;
         dtw.field_1755 = null;
         edj.camera(null);
         dtw.field_1765 = null;
         dtw.field_1692 = null;
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
      String var3 = var1 == null ? "" : var1.getString();
      this.dxa(this.dvu ? dts.OFFLINE : dts.FAILED, this.dvu ? a.c(1237706786, "\uec14闙ὲ脂ઠ谘㙝뿀") : var3);
      this.chat.system(a.d("\ue822量᭤蔔ຶ蠎㉋믖\u218eꬥ", -140684645, -2097365331) + var3);
      if (var2) {
         this.notifyHud(a.b("स烵艹搮\uef8c椴퍱嫬", 1816661262), false);
      }

      this.dwi();
   }

   private void dwi() {
      if (!this.dvu && this.dvt && egq.get().getBots().indexOf(this) >= 0) {
         long var1 = 9000L + this.duf.nextInt(9000);
         this.dvv = System.currentTimeMillis() + var1;
         this.chat.system(a.b("뻊응䷷폳堮\ude9e擇\ued38獦廉繸葻ત錐᥎鮪▂ꨡョ뛃㼶䅰", -1871004989) + var1 / 1000L + a.b("霯\ueaff", 1411094285));
      }
   }

   void frame(long var1) {
      this.dwu();
      if (this.connection == null) {
         if (this.dvv != 0L && System.currentTimeMillis() >= this.dvv) {
            this.dvv = 0L;
            this.connect();
         }

         this.dvk = var1;
      } else {
         if (this.dvk == 0L || var1 - this.dvk > 400000000L) {
            this.dvk = var1;
         }

         for (int var3 = 0; var1 - this.dvk >= 0L && var3 < 3 && this.connection != null; var3++) {
            this.dwl();
            this.dvk += 50000000L;
         }

         if (this.player != null) {
            pjd.keep(this);
            this.dwv();
         }

         this.dwj();
      }
   }

   private void dwj() {
      if (this.connection != null && this.duy.wantsBotFrame() && edj.enter(this)) {
         try {
            if (dtw.field_1724 != null && dtw.field_1687 != null && dtw.field_1761 != null) {
               this.duy.onBotFrame();
            }
         } catch (Throwable var5) {
            if (this.dwk()) {
               this.chat.system(a.c(1765598822, "\ue261鮆ᄥ轝ҁ舺㱹높⿇ꕲ⋕\ud8d4刓쯃䆤읔紀\uf2e9桬\uee2e柏ᶟ錧ࢢ軇") + var5);
            }
         } finally {
            edj.exit();
         }
      }
   }

   private boolean dwk() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.dvm > 60000L) {
         this.dvm = var1;
         this.dvl = 0;
      }

      return ++this.dvl <= 5;
   }

   void stagger(long var1, int var3, int var4) {
      this.dvk = var1 + 50000000L * var3 / Math.max(1, var4);
   }

   private void dwl() {
      edb var1 = this.connection;
      if (var1 != null && edj.enter(this)) {
         long var2 = System.nanoTime();

         try {
            var1.drain(6000000L);
            if (this.connection != null) {
               if (dtw.field_1724 != null && dtw.field_1687 != null && dtw.field_1761 != null && this.handler != null) {
                  this.dwm();
                  return;
               }

               var1.method_10754();
               return;
            }
         } catch (Throwable var11) {
            if (this.dwk()) {
               this.chat.system(a.d("\ua6f8\udf1f喼쯄䀘욣磠\uf573歖\ue1e5昼顇ᚊ", -1693564075, 452911550) + var11);
               if (Boolean.getBoolean(a.d("㛵低얞寷큥囈\uecc6攡ﭷ燌\uf60d౭芬ᬚ", -1745060301, -516863826))) {
                  var11.printStackTrace(System.out);
                  return;
               }
            }

            return;
         } finally {
            edj.exit();
            long var7 = System.nanoTime();
            this.dvn = this.dvn * 0.9F + (float)(var7 - var2) / 1000000.0F * 0.1F;
            this.dvo = var7;
            this.dvp = Math.max(this.dvp, (float)(var7 - var2) / 1000000.0F);
         }
      }
   }

   private void dwm() {
      Runnable var1;
      while ((var1 = this.dum.poll()) != null) {
         var1.run();
         if (dtw.field_1724 == null || dtw.field_1687 == null) {
            return;
         }
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

      if (dtw.field_1724 != null && dtw.field_1687 != null) {
         ClientWorld var2 = dtw.field_1687;
         var2.method_54719().method_54755();
         int var3 = this.dwy();
         if (var3 > 0) {
            this.dwz(var3 - 1);
         }

         this.control.apply(this);
         dtw.field_1773.method_3190(1.0F);
         dtw.field_1761.method_2927();
         if (this.connection != null && dtw.field_1724 != null && dtw.field_1687 != null) {
            var2 = dtw.field_1687;
            ClientPlayerEntity var4 = dtw.field_1724;
            this.dwo(var4, this.duy.isEnabled());
            if (dtw.field_1755 != null) {
               this.dvj = 10000;

               try {
                  dtw.field_1755.method_25393();
               } catch (Throwable var6) {
               }
            }

            if (dtw.field_1755 == null) {
               this.dwq(var4);
               if (this.dvj > 0) {
                  this.dvj--;
               }
            }

            this.dwn(var2, var4);
            var2.method_8441(() -> true);
            var2.method_38534();
            var2.method_2935().method_12130().method_15516();
            if (this.handler != null) {
               this.handler.method_52787(ClientTickEndC2SPacket.field_52333);
            }

            if (this.duw.isEnabled() && dtw.field_1724 != null) {
               this.duw.onEndTick(dtw);
            }

            if (this.duy.isEnabled() && dtw.field_1724 != null) {
               this.duy.onEndTick(dtw);
            }

            if (this.dva.isEnabled() && dtw.field_1724 != null) {
               this.dva.onEndTick(dtw);
            }

            if (this.dvc.isEnabled() && dtw.field_1724 != null) {
               this.dvc.onEndTick(dtw);
            }

            this.dwp();
            this.dwa.tick();
            this.captcha.tick();
         }
      }
   }

   private void dwn(ClientWorld var1, ClientPlayerEntity var2) {
      Entity var3 = var2.method_5668();
      if (!var3.method_31481()) {
         var1.method_18646(var3);
      }

      for (Entity var5 : var1.method_18112()) {
         if (var5 != var3 && var5 != var2 && !var5.method_31481() && !var3.method_5821(var5)) {
            if ((var5 instanceof LivingEntity && !(var5 instanceof PlayerEntity) || var5 instanceof ItemEntity)
               && !var5.method_5765()
               && var5.method_5858(var2) < 2304.0) {
               try {
                  var1.method_18646(var5);
               } catch (Throwable var10) {
               }
            } else {
               var5.method_22862();
               PositionInterpolator var6 = var5.method_66233();
               if (var6 != null && var6.method_66270()) {
                  Vec3d var7 = var6.method_66265();
                  float var8 = var6.method_66268();
                  float var9 = var6.method_66269();
                  var6.method_66272();
                  var5.method_33574(var7);
                  var5.method_36456(var8);
                  var5.method_36457(var9);
               }
            }
         }
      }
   }

   private void dwo(ClientPlayerEntity var1, boolean var2) {
      if (!var1.method_29504()) {
         this.dvh = 0;
      } else {
         if (++this.dvh == 1) {
            this.dvi = 30 + this.duf.nextInt(10);
         }

         if (!var2 && this.dvh == this.dvi || this.dvh % 200 == 0) {
            var1.method_7331();
         }
      }
   }

   private void dwp() {
      if (this.dvx > 0 && --this.dvx == 0) {
         this.dvx = -1;
         if (this.dvw != null && this.handler != null) {
            this.handler.method_45730(this.dvw.substring(1));
            this.chat.system(a.c(-433003123, "\ue18a頚ዅ賄ݯ膠㮎눉Ⱔꊌ⅍\udb4b嗧챜䈛샴竇\uf56b澧\ue986恳ᨫ钖ཏ"));
         }

         if (this.dux || this.duz || this.dvb || this.dvd) {
            this.dvz = 100 + this.duf.nextInt(80);
         }
      }

      if (this.dvz > 0 && --this.dvz == 0) {
         this.dvz = -1;
         if (this.dux && !this.duw.isEnabled() && dtw.field_1724 != null) {
            this.duw.setBotRunning(true);
            this.chat.system(a.c(-1345598965, "쩟돚㤈Ꝣⲟꨅၜ駩ϗ褚໊\uf4b7穢\ue7c3榇\uef71唱\uda9c䀥예俷"));
         } else if (this.duz && !this.duy.isEnabled() && dtw.field_1724 != null) {
            this.duy.setBotRunning(true);
            this.chat.system(a.d("\uda02ꎇ⥕뜿㳐멗\u0017觰ឮ鴔᪉\ue499樲\uf380租Ｌ䅳쪵倁홟忔▏ꭀ゙", -165975432, -1921929181));
         } else if (this.dvb && !this.dva.isEnabled() && dtw.field_1724 != null) {
            this.dva.setEnabledSilently(true);
            this.chat.system(a.b("콖뛓㰁ꉫ⦞꼋ᕟ鲥ʿ豯ீ\uf1b2罩\ue6da梙\uea7f倷\udfe9䔦썽䫶ク", 1023790849));
         } else if (this.dvd && !this.dvc.isEnabled() && dtw.field_1724 != null) {
            this.dvc.setBotRunning(true);
            this.chat.system(a.b("ꜞ\ude80呞쨥䇾을納\uf4ce檶\ue014柘鶡፡誂Ұ舽㡱랬ⴝ꽜⊼壪홖䷻쮎䄣\uf898", 1969334084));
         }
      }
   }

   private void dwq(ClientPlayerEntity var1) {
      GameOptions var2 = dtw.field_1690;

      for (int var3 = 0; var3 < 9; var3++) {
         if (var2.field_1852[var3].method_1436() && !var1.method_7325()) {
            var1.method_31548().method_61496(var3);
         }
      }

      while (var2.field_1831.method_1436()) {
         if (!var1.method_7325() && this.handler != null) {
            this.handler.method_52787(new PlayerActionC2SPacket(Action.field_12969, BlockPos.field_10980, Direction.field_11033));
         }
      }

      while (var2.field_1869.method_1436()) {
         if (!var1.method_7325() && var1.method_7290(false)) {
            var1.method_6104(Hand.field_5808);
         }
      }

      boolean var4 = false;
      if (var1.method_6115()) {
         if (!var2.field_1904.method_1434()) {
            dtw.field_1761.method_2897(var1);
         }

         while (var2.field_1886.method_1436()) {
         }

         while (var2.field_1904.method_1436()) {
         }

         while (var2.field_1871.method_1436()) {
         }
      } else {
         while (var2.field_1886.method_1436()) {
            var4 |= this.dws(var1);
         }

         while (var2.field_1904.method_1436()) {
            this.dwt(var1);
         }

         while (var2.field_1871.method_1436()) {
         }
      }

      if (var2.field_1904.method_1434() && this.dwy() == 0 && !var1.method_6115()) {
         this.dwt(var1);
      }

      this.dwr(var1, dtw.field_1755 == null && !var4 && var2.field_1886.method_1434());
   }

   private void dwr(ClientPlayerEntity var1, boolean var2) {
      if (!var2) {
         this.dvj = 0;
      }

      if (this.dvj <= 0 && !var1.method_6115()) {
         if (!var1.method_5998(Hand.field_5808).method_57826(DataComponentTypes.field_63631)) {
            if (var2 && dtw.field_1765 != null && dtw.field_1765.method_17783() == Type.field_1332) {
               BlockHitResult var3 = (BlockHitResult)dtw.field_1765;
               BlockPos var4 = var3.method_17777();
               if (!dtw.field_1687.method_8320(var4).method_26215() && dtw.field_1761.method_2902(var4, var3.method_17780())) {
                  var1.method_6104(Hand.field_5808);
               }
            } else {
               dtw.field_1761.method_2925();
            }
         }
      }
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean dws(ClientPlayerEntity var1) {
      if (this.dvj > 0) {
         return false;
      } else if (dtw.field_1765 == null) {
         if (dtw.field_1761.method_2924()) {
            this.dvj = 10;
         }

         return false;
      } else if (var1.method_3144()) {
         return false;
      } else {
         ItemStack var2 = var1.method_5998(Hand.field_5808);
         if (!var2.method_45435(dtw.field_1687.method_45162())) {
            return false;
         } else if (var1.method_75202(var2, 0)) {
            return false;
         } else {
            PiercingWeaponComponent var3 = (PiercingWeaponComponent)var2.method_58694(DataComponentTypes.field_63631);
            if (var3 != null && !dtw.field_1761.method_2928()) {
               dtw.field_1761.method_75407(var3);
               var1.method_6104(Hand.field_5808);
               return true;
            } else {
               boolean var4 = false;
               switch (dtw.field_1765.method_17783()) {
                  case field_1331:
                     AttackRangeComponent var7 = (AttackRangeComponent)var2.method_58694(DataComponentTypes.field_64680);
                     if (var7 == null || var7.method_76736(var1, dtw.field_1765.method_17784())) {
                        dtw.field_1761.method_2918(var1, ((EntityHitResult)dtw.field_1765).method_17782());
                     }
                     break;
                  case field_1332:
                     BlockHitResult var5 = (BlockHitResult)dtw.field_1765;
                     BlockPos var6 = var5.method_17777();
                     if (!dtw.field_1687.method_8320(var6).method_26215()) {
                        dtw.field_1761.method_2910(var6, var5.method_17780());
                        if (dtw.field_1687.method_8320(var6).method_26215()) {
                           var4 = true;
                        }
                        break;
                     }
                  case field_1333:
                     if (dtw.field_1761.method_2924()) {
                        this.dvj = 10;
                     }

                     var1.method_7350();
               }

               if (!var1.method_7325()) {
                  var1.method_6104(Hand.field_5808);
               }

               return var4;
            }
         }
      }
   }

   private void dwt(ClientPlayerEntity var1) {
      if (!dtw.field_1761.method_2923()) {
         this.dwz(4);
         if (!var1.method_3144()) {
            for (Hand var5 : Hand.values()) {
               ItemStack var6 = var1.method_5998(var5);
               if (!var6.method_45435(dtw.field_1687.method_45162())) {
                  return;
               }

               HitResult var7 = dtw.field_1765;
               if (var7 != null) {
                  if (var7.method_17783() == Type.field_1331) {
                     EntityHitResult var8 = (EntityHitResult)var7;
                     Entity var9 = var8.method_17782();
                     if (!dtw.field_1687.method_8621().method_11952(var9.method_24515())) {
                        return;
                     }

                     if (var1.method_56094(var9, 0.0)) {
                        ActionResult var10 = dtw.field_1761.method_2917(var1, var9, var8, var5);
                        if (!var10.method_23665()) {
                           var10 = dtw.field_1761.method_2905(var1, var9, var5);
                        }

                        if (var10 instanceof Success var11) {
                           if (var11.comp_2909() == SwingSource.field_52427) {
                              var1.method_6104(var5);
                           }

                           return;
                        }
                     }
                  } else if (var7.method_17783() == Type.field_1332) {
                     ActionResult var12 = dtw.field_1761.method_2896(var1, var5, (BlockHitResult)var7);
                     if (var12 instanceof Success var15) {
                        if (var15.comp_2909() == SwingSource.field_52427) {
                           var1.method_6104(var5);
                        }

                        return;
                     }

                     if (var12 instanceof Fail) {
                        return;
                     }
                  }
               }

               if (!var6.method_7960() && dtw.field_1761.method_2919(var1, var5) instanceof Success var14) {
                  if (var14.comp_2909() == SwingSource.field_52427) {
                     var1.method_6104(var5);
                  }

                  return;
               }
            }
         }
      }
   }

   int loadDistance() {
      ehy var1 = this.handler;
      return var1 == null ? egq.get().getViewDistance() : var1.loadDistance();
   }

   float partialTick() {
      return MathHelper.method_15363((float)(System.nanoTime() - this.dvo) / 5.0E7F, 0.0F, 1.0F);
   }

   double mouseMultiplier() {
      double var1 = this.dug * 0.6F + 0.2F;
      return var1 * var1 * var1 * 8.0;
   }

   @Override
   public double mouseStep() {
      return prp.step(this.mouseMultiplier());
   }

   @Override
   public void look(float var1, float var2) {
      ClientPlayerEntity var3 = dtw.field_1724;
      if (var3 != null && ejp.current() == this && Float.isFinite(var1) && Float.isFinite(var2)) {
         double var4 = this.mouseMultiplier();
         float var6 = var3.method_36454();
         float var7 = var3.method_36455();
         double var8 = (double)var1 - var6;
         double var10 = Math.floor((var8 + 180.0) / 360.0) * 360.0;
         float var12 = (float)(var6 + var10) + prp.quantize(var8 - var10, var4);
         float var13 = MathHelper.method_15363(var7 + prp.quantize((double)var2 - var7, var4), -90.0F, 90.0F);
         var3.method_36456(var12);
         var3.method_36457(var13);
      }
   }

   @Override
   public boolean heldByHuman(KeyBinding var1) {
      return this.control.isHeld(var1);
   }

   @Override
   public String getName() {
      return this.dud;
   }

   @Override
   public void report(String var1, boolean var2) {
      if (var1 != null && !var1.isEmpty()) {
         this.chat.system(var1);
      }
   }

   public void post(Runnable var1) {
      if (this.connection != null) {
         this.dum.add(var1);
      }
   }

   public void schedule(long var1, Runnable var3) {
      this.dun.add(new dtn(System.currentTimeMillis() + Math.max(0L, var1), var3));
   }

   public boolean hasScheduled() {
      return !this.dun.isEmpty();
   }

   private void dwu() {
      if (!this.dun.isEmpty()) {
         long var1 = System.currentTimeMillis();
         ArrayList var3 = null;
         Iterator var4 = this.dun.iterator();

         while (var4.hasNext()) {
            dtn var5 = (dtn)var4.next();
            if (var1 >= var5.at()) {
               var4.remove();
               if (var3 == null) {
                  var3 = new ArrayList();
               }

               var3.add(var5.action());
            }
         }

         if (var3 != null) {
            for (Runnable var9 : var3) {
               try {
                  var9.run();
               } catch (Throwable var7) {
               }
            }
         }
      }
   }

   public void sendChat(String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      if (!var2.isEmpty()) {
         if (var2.length() > 256) {
            var2 = var2.substring(0, 256);
         }

         this.dww(var2);
         this.chat.own(var2);
         Matcher var3 = dua.matcher(var2);
         if (var3.matches() && !pjd.enter(this, var3.group(1))) {
            if (var2.equalsIgnoreCase(this.dvr)) {
               pjd.cancel(this);
               this.dvr = null;
               this.chat.system(a.c(902851001, "涪ᑂ黣ç譅\u0df5럞㩃ꀁ⪽\ua97e华\udd96") + var3.group(1) + a.d("뚹쬖䆹\udfb6周틑梊\ue173缡", -171275629, -443466749));
            } else {
               this.dvr = var2;
               this.dvs = System.currentTimeMillis();
               this.chat
                  .system(
                     a.d("岇┛ꯘ㗨븰", 1984706464, -93032641)
                        + var3.group(1)
                        + a.b("壱┣꾅ㇷ븵", -728999724)
                        + 3
                        + a.d("㩪䟆촘匑\ud8b6幺\ue04c䦉\uf7e2祅ﺔҒ踦ᎋ駑ὔꔘ⪻되㉁", 157370480, 1207792174)
                        + pjd.position(this)
                        + a.b("३瓌﨏摹\uefa0洮흜庡삎䩃췮㟧봨₃\uaad4Ⱗ除ᦸ茂Ԥ袼\uf2e1砵\ue3e1既\uef3c囵\udccf䈦쐋俆넞㭙ꊭ⒄긻", -110556832)
                  );
            }
         } else {
            if (var3.matches()) {
               this.dvr = null;
            }

            String var4 = var2;
            this.post(() -> {
               if (this.handler != null) {
                  this.dup = System.currentTimeMillis();
                  if (var4.startsWith(a.b("湆", -912626072))) {
                     this.handler.method_45730(var4.substring(1));
                  } else {
                     this.handler.method_45729(var4);
                  }
               }
            });
         }
      }
   }

   private void dwv() {
      String var1 = this.dvr;
      long var2 = System.currentTimeMillis();
      if (var1 != null && var2 - this.dvs >= 1000L) {
         this.dvs = var2;
         if (this.isActive()) {
            this.dvr = null;
         } else {
            Matcher var4 = dua.matcher(var1);
            if (var4.matches() && pjd.enter(this, var4.group(1))) {
               this.dvr = null;
               this.chat.system(a.b("\udef7ꝯⷈ뎺㠑몾Ӱ贌ᝃ鶳ᩯ", 1292360416) + var4.group(1) + a.c(-820101608, "㸠䎏줣圡\udcfa婄\ue018槣\uf7b0紂䀹Ú踀Ꮭ릺\u1f7fꄯ\u2ef4됲㈖뮑솻伀풤"));
               this.sendChat(var1);
            }
         }
      }
   }

   private void dww(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      String[] var3 = var1.split(a.c(-1374606266, "Ⱉ喇\udf0c"));
      String var4 = null;
      if ((var2.startsWith(a.c(1171058936, "\uf0d0褢ϲ鶋ᙒ郤⫹")) || var2.startsWith(a.c(-1054523916, "㷘䐪캵")) || var2.startsWith(a.b("箮ɜ袌ᛵ鵥", 558922628)))
         && var3.length >= 2) {
         var4 = a.b("糷ԅ迕ᆬ驵᳃ꛞ", 1036680415) + var3[1];
      } else if ((var2.startsWith(a.c(1114159556, "맮쀂䫆풵弥")) || var2.startsWith(a.d("\ue9a1遍᪉蓺༣覈㏜먼⑴꺗", -2073614061, -139018089))) && var3.length >= 2) {
         var4 = a.b("坩⺛ꑋ㨲뇫㝝赀", 1005213505) + var3[1];
      }

      if (var4 != null && !var4.equals(this.dvw)) {
         this.dvw = var4;
         egq.get().persist();
      }
   }

   String loginPassword() {
      return this.dvw == null ? null : this.dvw.substring(a.d("ན皡ﱱ戈\ue9d1潧핺", -1037593122, -1894147419).length());
   }

   void restore(String var1, boolean var2) {
      this.dvw = var1 != null && !var1.isBlank() ? a.d("ᡂ憰\ueb60甙ﻀ硶쉫", 70120623, -1251152699) + var1 : null;
      this.dvt = var2;
   }

   private void dwx() {
      if (this.dvc.isEnabled()) {
         this.dvc.setBotRunning(false);
         this.chat.system(a.c(1272024124, "豥\uf5fb缥\ue15e檅\uec3f噶\udfb5䇍쭯䲣뛚㠚ꇹ⾴ꤺ፶鳕٫耹ূ玚ﴧ曾"));
      }
   }

   public void setF0(boolean var1) {
      this.dux = var1;
      if (var1) {
         this.duz = false;
         this.dvb = false;
         this.dvd = false;
      }

      this.post(() -> {
         if (dtw.field_1724 != null) {
            if (var1) {
               this.dwx();
            }

            if (var1 && this.duy.isEnabled()) {
               this.duy.setBotRunning(false);
               this.chat.system(a.b("Ŧ磣\uf231汛\ue7b4愳\udb73劔쳊䙰쇭㾂넪⢘ꊹ⑅鸉ᇔ譮റ蓎", 2015101234));
            }

            if (var1 && this.dva.isEnabled()) {
               this.dva.setEnabledSilently(false);
               this.chat.system(a.c(2128170065, "䰃㖆뽔ℾ\uaacbⱞ阊\u1ff0自ཅ裩犛ﰾ斂\uefd2椯퍩岶옍"));
            }

            if (var1 && !this.duw.isEnabled()) {
               this.duw.setBotRunning(true);
               this.chat.system(a.d("灒ৗ茅ᵯ隒ဈ꩑⏤리㌚듆介쀖姛펀", 986551585, 2006246717));
            } else if (!var1 && this.duw.isEnabled()) {
               this.duw.setBotRunning(false);
               this.chat.system(a.b("挂᪇違฿藂͘뤁ゴꫵ※\ua7eb巨팲䪀샟䘧ﱦ玿", 548168529));
            }
         }
      });
   }

   public void setF1(boolean var1) {
      this.duz = var1;
      if (var1) {
         this.dux = false;
         this.dvb = false;
         this.dvd = false;
      }

      this.post(() -> {
         if (dtw.field_1724 != null) {
            if (var1) {
               this.dwx();
               if (this.duw.isEnabled()) {
                  this.duw.setBotRunning(false);
                  this.chat.system(a.d("G秂\uf310浺\ue687思\uda44叱즰䍾쒮㺭끷⧅ꎚ╢鼣ჺ", -7751788, 1876932480));
               }

               if (this.dva.isEnabled()) {
                  this.dva.setEnabledSilently(false);
                  this.chat.system(a.c(-1983854941, "웱뽴㖦ꯌ‹ꚬ᳸锂ଘ薷ț\uf869盌\uef70攠\ue3dd妛홄䳿"));
               }

               if (!this.duy.isEnabled()) {
                  this.duy.setBotRunning(true);
                  this.chat.system(a.d("\uf340諅\u0017鹽ᖒ錕⥕ꂲ㻬둖㏋춭䍽\udac3僬혗氤\ue3fd絟ﬂ目ೇ艵ᷜ鮹", -1084381516, 35018156) + this.duy.getCurrentLootAnarchy());
               }
            } else if (this.duy.isEnabled()) {
               this.duy.setBotRunning(false);
               this.chat.system(a.d("㕼䳹옫塁펮唩\uef69暎\uf8d0牪\uf5f7\u0b98蔰ᲂ隣ၟꨓ◎뽴㤫냔", -1959602666, 347005758));
            }
         }
      });
   }

   public void setF2(boolean var1) {
      this.dvb = var1;
      if (var1) {
         this.dux = false;
         this.duz = false;
         this.dvd = false;
      }

      this.post(() -> {
         if (dtw.field_1724 != null) {
            if (var1) {
               this.dwx();
               if (this.duw.isEnabled()) {
                  this.duw.setBotRunning(false);
                  this.chat.system(a.c(608327891, "墀℅ꯗ㖽빀㣚芃ଶ酷᮹鱩晪\ue8b0焂ﭝ綥쟤䠽"));
               }

               if (this.duy.isEnabled()) {
                  this.duy.setBotRunning(false);
                  this.chat.system(a.d("痜ౙ蚋ᣡ錎ᖉ꿉☮롰㋊땗䬸얐尢혃僿\ueab3敮ￔ禋\uf074", -1324122829, -974452549));
               }

               if (!this.dva.isEnabled()) {
                  this.dva.setEnabledSilently(true);
                  this.chat.system(a.b("딪첯䙽\ud817叢핷漣\ue6d9磃\uf665熱诏դ鳟ᛰ选", -470764165));
               }
            } else if (this.dva.isEnabled()) {
               this.dva.setEnabledSilently(false);
               this.chat.system(a.c(804619860, "蘆ﾃ畑\ueb3b惎\ue65b小헵䯯앀䋬뢞㘻꾇◗ꌪᥬ隳ఈ"));
            }
         }
      });
   }

   public void setF3(boolean var1) {
      if (!var1 || !this.dvc.isLocked()) {
         this.dvd = var1;
         if (var1) {
            this.dux = false;
            this.duz = false;
            this.dvb = false;
         }

         this.post(() -> {
            if (dtw.field_1724 != null) {
               if (var1) {
                  if (this.duw.isEnabled()) {
                     this.duw.setBotRunning(false);
                     this.chat.system(a.c(825572945, "㸂䞇쵕匿\ud8c2幘\ue401涴\uf7f5紻\ufaebè踲ក鷟ᬧꅦ⺿"));
                  }

                  if (this.duy.isEnabled()) {
                     this.duy.setBotRunning(false);
                     this.chat.system(a.d("異胧ਵ鑟ᾰ餷⍷ꪐ㓎빴㧩잆䤮킜媽\udc41昍\ue9d0獪\uf535糊", 1079223721, -1653384033));
                  }

                  if (this.dva.isEnabled()) {
                     this.dva.setEnabledSilently(false);
                     this.chat.system(a.c(422332887, "䦅　뫒Ⓒ꽍⧘鎌᩶葬ૃ赯眝隸怄\uea54沩훯夰쎋"));
                  }

                  if (!this.dvc.isEnabled()) {
                     this.dvc.setBotRunning(true);
                     this.chat.system(a.c(130244382, "彊⛔갊㉱릪㼐蕙ಚ鋢ᡀ龌旵\ueb35狖ﲒ穤쀤侉픰匝\udae2"));
                  }
               } else {
                  this.dwx();
               }
            }
         });
      }
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
            this.chat.system(a.c(-242699480, "덺쫿䀭\ude47喲팧楳\ue089纓\uf03c瞐跢͇髻Ⴋ陖Ⱀꏏ㥴"));
         }

         if (this.duw.isEnabled()) {
            this.duw.setBotRunning(false);
            this.chat.system(a.c(1195806058, "费\uf4bc繮\ue004毹\ued63场\ude8f䓎츀䧐돓㴉꒻⻤ꠜቝ鶄"));
         }

         if (this.duy.isEnabled()) {
            this.duy.setBotRunning(false);
            this.chat.system(a.d("汼ᗹ鼫Ł誮\u0c29뙩㾎ꇐ⭪곷劘\udc30䖂쾣䥟\uf313糎\ue674怫\ue9d4", 2145452242, 1243376890));
         }
      });
   }

   public void boostItemUse(int var1) {
      if (this.dwy() > var1) {
         this.dwz(Math.max(0, var1));
      }
   }

   private int dwy() {
      return edj.holdsUseCooldown(this) ? edj.useCooldown() : this.itemUseCooldown;
   }

   private void dwz(int var1) {
      if (edj.holdsUseCooldown(this)) {
         edj.useCooldown(var1);
      } else {
         this.itemUseCooldown = var1;
      }
   }

   public void selectSlot(int var1) {
      this.post(() -> {
         if (dtw.field_1724 != null && var1 >= 0 && var1 < 9) {
            dtw.field_1724.method_31548().method_61496(var1);
         }
      });
   }

   public void clickSlot(int var1, int var2, int var3, SlotActionType var4) {
      this.post(() -> {
         if (dtw.field_1724 != null && dtw.field_1761 != null && dtw.field_1724.field_7512.field_7763 == var1) {
            dtw.field_1761.method_2906(var1, var2, var3, var4, dtw.field_1724);
         }
      });
   }

   public void closeScreen() {
      this.post(() -> {
         if (dtw.field_1724 != null) {
            if (dtw.field_1724.field_7512 != dtw.field_1724.field_7498) {
               dtw.field_1724.method_7346();
            } else if (dtw.field_1755 != null) {
               dtw.method_1507(null);
            }

            this.duv = null;
         }
      });
   }

   public void dropSelected(boolean var1) {
      this.post(() -> {
         if (dtw.field_1724 != null && !dtw.field_1724.method_7325() && dtw.field_1724.method_7290(var1)) {
            dtw.field_1724.method_6104(Hand.field_5808);
         }
      });
   }

   public void swapHands() {
      this.post(() -> {
         if (this.handler != null && dtw.field_1724 != null && !dtw.field_1724.method_7325()) {
            this.handler.method_52787(new PlayerActionC2SPacket(Action.field_12969, BlockPos.field_10980, Direction.field_11033));
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
         if (dtw.field_1724 != null && dtw.field_1724.method_29504()) {
            dtw.field_1724.method_7331();
         }
      });
   }

   void ensureKeys(int var1) {
      if (this.keyPressed.length != var1) {
         boolean[] var2 = new boolean[var1];
         int[] var3 = new int[var1];
         System.arraycopy(this.keyPressed, 0, var2, 0, Math.min(var1, this.keyPressed.length));
         System.arraycopy(this.keyTimes, 0, var3, 0, Math.min(var1, this.keyTimes.length));
         this.keyPressed = var2;
         this.keyTimes = var3;
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
         } catch (Throwable var5) {
         } finally {
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

   void notifyHud(String var1, boolean var2) {
      try {
         dtw.method_63588(() -> {
            try {
               izx.alert(this.dud, var1, vhz.INFO, var2);
            } catch (Throwable var4x) {
            }
         });
      } catch (Throwable var4) {
      }
   }

   private void dxa(dts var1, String var2) {
      this.duh = var1;
      this.dui = var2 == null ? "" : var2;
      this.duj = System.currentTimeMillis();
   }

   public String getAddress() {
      return this.address;
   }

   public void setAddress(String var1) {
      if (var1 != null && !var1.equals(this.address)) {
         this.address = var1;
         egq.get().persist();
      }
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
      ech var1 = this.dup == 0L ? null : this.chat.firstServerAfter(this.dup, 5000L);
      return var1 == null ? null : var1.text;
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

   public void setAutoReconnect(boolean var1) {
      boolean var2 = this.dvt != var1;
      this.dvt = var1;
      if (!var1) {
         this.dvv = 0L;
      }

      if (var2) {
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
      ehy var1 = this.handler;
      if (var1 == null) {
         return -1;
      } else {
         PlayerListEntry var2 = var1.method_2871(this.due);
         return var2 == null ? -1 : var2.method_2959();
      }
   }

   public float takePeakTickMillis() {
      float var1 = this.dvp;
      this.dvp = 0.0F;
      return var1;
   }

   public int getPendingPackets() {
      edb var1 = this.connection;
      return var1 == null ? 0 : var1.pending();
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
}
