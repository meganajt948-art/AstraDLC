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
   static final MinecraftClient dtw = MinecraftClient.getInstance();
   static final long dtx = 50000000L;
   static final long dty = 6000000L;
   static final String dtz = a.d("躕\uf767綷\ue3ce栗\ueea1咼", -1482419073, -1385784638);
   static final Pattern dua = Pattern.compile(a.d("ॳ炌祖搓\uefeb椃퍒嫗쒰乎즟㎛뵣⒋", -254349818, 1927997268), 2);
   static final double dub = 2304.0;
   static final double[] duc = new double[]{0.5, 0.47, 0.43, 0.39, 0.52, 0.55, 0.36, 0.45, 0.41};
   final String dud;
   final UUID due;
   final Random duf = new Random();
   final double dug;
   volatile String address;
   volatile dts duh = dts.OFFLINE;
   volatile String dui = "";
   volatile long duj = System.currentTimeMillis();
   volatile edb connection;
   volatile boolean duk;
   volatile boolean dul;
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
   final ArrayDeque<Runnable> dum = new ArrayDeque<>();
   final List<dtn> dun = new ArrayList<>();
   volatile boolean duo;
   long dup;
   Text tabHeader;
   Text tabFooter;
   Text serverLabel;
   Text duq;
   long dur;
   Text dus;
   Text dut;
   long duu;
   String duv;
   final mpq duw;
   boolean dux;
   final nxa duy;
   boolean duz;
   final nfl dva;
   boolean dvb;
   final lqq dvc;
   boolean dvd;
   final dyh dve = new dyh(this);
   int dvf;
   int dvg;
   int dvh;
   int dvi = 35;
   int dvj;
   int itemUseCooldown;
   long dvk;
   int dvl;
   long dvm;
   float dvn;
   long dvo;
   float dvp;
   volatile long dvq;
   String dvr;
   long dvs;
   boolean dvt = true;
   boolean dvu;
   long dvv;
   String dvw;
   int dvx = -1;
   long dvy;
   int dvz = -1;
   final eip dwa = new eip(this);

   dtv(String var1, String var2) {
      this.dud = var1;
      this.due = Uuids.getOfflinePlayerUuid(var1);
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

   static kfx dwd() {
      Flow var0 = Flow.getInstance();
      return var0 == null ? null : var0.getModuleManager();
   }

   static mpq dwe() {
      kfx var0 = dwd();
      mpq var1 = var0 == null ? null : var0.get(mpq.class);
      return var1 != null && !var1.isBotInstance() ? var1 : null;
   }

   static nxa dwf() {
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
            Util.getIoWorkerExecutor().execute(() -> this.dwg(var1));
         }
      }
   }

   boolean isJoining() {
      return this.dul || this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.JOINING;
   }

   void dwg(String var1) {
      try {
         ServerAddress var2 = ServerAddress.parse(var1);
         Optional var10 = AllowedAddressResolver.DEFAULT.resolve(var2).map(Address::getInetSocketAddress);
         if (var10.isEmpty()) {
            this.dwh(a.b("묫싮䡈홋嶛\udb5f敬\ue880盗\uf873箽臁༟隣ᳱ騈", -1664761990));
            return;
         }

         InetSocketAddress var4 = (InetSocketAddress)var10.get();
         edb var5 = new edb(this);
         ClientConnection.connect(var4, NetworkingBackend.remote(dtw.options.shouldUseNativeTransport()), var5).syncUninterruptibly();
         synchronized (this) {
            this.dul = false;
            if (this.duk) {
               var5.disconnect(Text.translatable(a.d("ࢅ焬ﯦ斏\uee45棭튢孞씙侴조㉝볗╡꼧⧃鎍ᱚ蚴º襉\uf304綪\ue67b怙\ueacf卵", -1215154949, -482460664)));
               this.dxa(dts.OFFLINE, a.c(1061586037, "聃年猥\ued55曷\ue04f娊펗"));
               return;
            }

            this.connection = var5;
         }

         var5.connect(var4.getHostName(), var4.getPort(), LoginStates.C2S, LoginStates.S2C, new egf(this, var5), false);
         var5.send(new LoginHelloC2SPacket(this.dud, this.due));
         this.dxa(dts.LOGIN, a.b("맇쀁䪩퓒", -562709007));
      } catch (Throwable var9) {
         Throwable var3 = var9.getCause() != null ? var9.getCause() : var9;
         this.dwh(var3.getMessage() == null ? var3.getClass().getSimpleName() : var3.getMessage());
      }
   }

   void dwh(String var1) {
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
         var1.disconnect(Text.translatable(a.d("\ud97eꃗ⨝둴㾾뤖͙誥ᓢ鹏ᦋ\ue3a6洬\uf49a络\uf838䉶춡坏텁墲⋿걑㞀뇢㬴芎", 1921927102, 850894518)));
      } else {
         if (this.duh == dts.CONNECTING || this.duh == dts.LOGIN || this.duh == dts.QUEUED) {
            this.dxa(dts.OFFLINE, a.b("⭾劳\ud818䙨췊䭲\uf137碪", -809685176));
         }
      }
   }

   ServerInfo serverInfo() {
      ServerInfo var1 = new ServerInfo(this.dud, this.address, ServerType.OTHER);
      var1.setResourcePackPolicy(ResourcePackPolicy.ENABLED);
      return var1;
   }

   SyncedClientOptions syncedOptions() {
      int var1 = 0;

      for (PlayerModelPart var5 : PlayerModelPart.values()) {
         var1 |= var5.getBitFlag();
      }

      String var6 = dtw.options == null ? a.b("樲ᎈ饪ܱ賠", 317418066) : dtw.options.language;
      return new SyncedClientOptions(var6, egq.get().getViewDistance(), ChatVisibility.FULL, true, var1, Arm.RIGHT, false, true, ParticlesMode.ALL);
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
      dtw.player = null;
      dtw.world = null;
      dtw.interactionManager = null;
      dtw.currentScreen = null;
      edj.camera(null);
      dtw.crosshairTarget = null;
      dtw.targetedEntity = null;
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
      ClientPlayerEntity var2 = dtw.player;
      ClientWorld var3 = dtw.world;
      if (var2 != null && var3 != null && !var1.method_76760()) {
         if (this.dvf == 0 && ++this.dvg > 100) {
            this.dvf = 1;
         }

         if (this.dvf == 1) {
            BlockPos var4 = var2.getBlockPos();
            boolean var5 = var3.isOutOfHeightLimit(var4.getY())
               || var3.getChunkManager().getWorldChunk(var4.getX() >> 4, var4.getZ() >> 4, false) != null
               || var2.isSpectator()
               || !var2.isAlive();
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
         for (Packet<?> var4 : var2.getPackets()) {
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
         dtw.player = null;
         dtw.world = null;
         dtw.interactionManager = null;
         dtw.currentScreen = null;
         edj.camera(null);
         dtw.crosshairTarget = null;
         dtw.targetedEntity = null;
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

   void dwi() {
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

   void dwj() {
      if (this.connection != null && this.duy.wantsBotFrame() && edj.enter(this)) {
         try {
            if (dtw.player != null && dtw.world != null && dtw.interactionManager != null) {
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

   boolean dwk() {
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

   void dwl() {
      edb var1 = this.connection;
      if (var1 != null && edj.enter(this)) {
         long var2 = System.nanoTime();

         try {
            var1.drain(6000000L);
            if (this.connection != null) {
               if (dtw.player != null && dtw.world != null && dtw.interactionManager != null && this.handler != null) {
                  this.dwm();
                  return;
               }

               var1.tick();
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

   void dwm() {
      Runnable var1;
      while ((var1 = this.dum.poll()) != null) {
         var1.run();
         if (dtw.player == null || dtw.world == null) {
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

      if (dtw.player != null && dtw.world != null) {
         ClientWorld var2 = dtw.world;
         var2.getTickManager().step();
         int var3 = this.dwy();
         if (var3 > 0) {
            this.dwz(var3 - 1);
         }

         this.control.apply(this);
         dtw.gameRenderer.updateCrosshairTarget(1.0F);
         dtw.interactionManager.tick();
         if (this.connection != null && dtw.player != null && dtw.world != null) {
            var2 = dtw.world;
            ClientPlayerEntity var4 = dtw.player;
            this.dwo(var4, this.duy.isEnabled());
            if (dtw.currentScreen != null) {
               this.dvj = 10000;

               try {
                  dtw.currentScreen.tick();
               } catch (Throwable var6) {
               }
            }

            if (dtw.currentScreen == null) {
               this.dwq(var4);
               if (this.dvj > 0) {
                  this.dvj--;
               }
            }

            this.dwn(var2, var4);
            var2.tick(() -> true);
            var2.runQueuedChunkUpdates();
            var2.getChunkManager().getLightingProvider().doLightUpdates();
            if (this.handler != null) {
               this.handler.sendPacket(ClientTickEndC2SPacket.INSTANCE);
            }

            if (this.duw.isEnabled() && dtw.player != null) {
               this.duw.onEndTick(dtw);
            }

            if (this.duy.isEnabled() && dtw.player != null) {
               this.duy.onEndTick(dtw);
            }

            if (this.dva.isEnabled() && dtw.player != null) {
               this.dva.onEndTick(dtw);
            }

            if (this.dvc.isEnabled() && dtw.player != null) {
               this.dvc.onEndTick(dtw);
            }

            this.dwp();
            this.dwa.tick();
            this.captcha.tick();
         }
      }
   }

   void dwn(ClientWorld var1, ClientPlayerEntity var2) {
      Entity var3 = var2.getRootVehicle();
      if (!var3.isRemoved()) {
         var1.tickEntity(var3);
      }

      for (Entity var5 : var1.getEntities()) {
         if (var5 != var3 && var5 != var2 && !var5.isRemoved() && !var3.hasPassengerDeep(var5)) {
            if ((var5 instanceof LivingEntity && !(var5 instanceof PlayerEntity) || var5 instanceof ItemEntity)
               && !var5.hasVehicle()
               && var5.squaredDistanceTo(var2) < 2304.0) {
               try {
                  var1.tickEntity(var5);
               } catch (Throwable var10) {
               }
            } else {
               var5.resetPosition();
               PositionInterpolator var6 = var5.getInterpolator();
               if (var6 != null && var6.isInterpolating()) {
                  Vec3d var7 = var6.getLerpedPos();
                  float var8 = var6.getLerpedYaw();
                  float var9 = var6.getLerpedPitch();
                  var6.clear();
                  var5.setPosition(var7);
                  var5.setYaw(var8);
                  var5.setPitch(var9);
               }
            }
         }
      }
   }

   void dwo(ClientPlayerEntity var1, boolean var2) {
      if (!var1.isDead()) {
         this.dvh = 0;
      } else {
         if (++this.dvh == 1) {
            this.dvi = 30 + this.duf.nextInt(10);
         }

         if (!var2 && this.dvh == this.dvi || this.dvh % 200 == 0) {
            var1.requestRespawn();
         }
      }
   }

   void dwp() {
      if (this.dvx > 0 && --this.dvx == 0) {
         this.dvx = -1;
         if (this.dvw != null && this.handler != null) {
            this.handler.sendChatCommand(this.dvw.substring(1));
            this.chat.system(a.c(-433003123, "\ue18a頚ዅ賄ݯ膠㮎눉Ⱔꊌ⅍\udb4b嗧챜䈛샴竇\uf56b澧\ue986恳ᨫ钖ཏ"));
         }

         if (this.dux || this.duz || this.dvb || this.dvd) {
            this.dvz = 100 + this.duf.nextInt(80);
         }
      }

      if (this.dvz > 0 && --this.dvz == 0) {
         this.dvz = -1;
         if (this.dux && !this.duw.isEnabled() && dtw.player != null) {
            this.duw.setBotRunning(true);
            this.chat.system(a.c(-1345598965, "쩟돚㤈Ꝣⲟꨅၜ駩ϗ褚໊\uf4b7穢\ue7c3榇\uef71唱\uda9c䀥예俷"));
         } else if (this.duz && !this.duy.isEnabled() && dtw.player != null) {
            this.duy.setBotRunning(true);
            this.chat.system(a.d("\uda02ꎇ⥕뜿㳐멗\u0017觰ឮ鴔᪉\ue499樲\uf380租Ｌ䅳쪵倁홟忔▏ꭀ゙", -165975432, -1921929181));
         } else if (this.dvb && !this.dva.isEnabled() && dtw.player != null) {
            this.dva.setEnabledSilently(true);
            this.chat.system(a.b("콖뛓㰁ꉫ⦞꼋ᕟ鲥ʿ豯ீ\uf1b2罩\ue6da梙\uea7f倷\udfe9䔦썽䫶ク", 1023790849));
         } else if (this.dvd && !this.dvc.isEnabled() && dtw.player != null) {
            this.dvc.setBotRunning(true);
            this.chat.system(a.b("ꜞ\ude80呞쨥䇾을納\uf4ce檶\ue014柘鶡፡誂Ұ舽㡱랬ⴝ꽜⊼壪홖䷻쮎䄣\uf898", 1969334084));
         }
      }
   }

   void dwq(ClientPlayerEntity var1) {
      GameOptions var2 = dtw.options;

      for (int var3 = 0; var3 < 9; var3++) {
         if (var2.hotbarKeys[var3].wasPressed() && !var1.isSpectator()) {
            var1.getInventory().setSelectedSlot(var3);
         }
      }

      while (var2.swapHandsKey.wasPressed()) {
         if (!var1.isSpectator() && this.handler != null) {
            this.handler.sendPacket(new PlayerActionC2SPacket(Action.SWAP_ITEM_WITH_OFFHAND, BlockPos.ORIGIN, Direction.DOWN));
         }
      }

      while (var2.dropKey.wasPressed()) {
         if (!var1.isSpectator() && var1.dropSelectedItem(false)) {
            var1.swingHand(Hand.MAIN_HAND);
         }
      }

      boolean var4 = false;
      if (var1.isUsingItem()) {
         if (!var2.useKey.isPressed()) {
            dtw.interactionManager.stopUsingItem(var1);
         }

         while (var2.attackKey.wasPressed()) {
         }

         while (var2.useKey.wasPressed()) {
         }

         while (var2.pickItemKey.wasPressed()) {
         }
      } else {
         while (var2.attackKey.wasPressed()) {
            var4 |= this.dws(var1);
         }

         while (var2.useKey.wasPressed()) {
            this.dwt(var1);
         }

         while (var2.pickItemKey.wasPressed()) {
         }
      }

      if (var2.useKey.isPressed() && this.dwy() == 0 && !var1.isUsingItem()) {
         this.dwt(var1);
      }

      this.dwr(var1, dtw.currentScreen == null && !var4 && var2.attackKey.isPressed());
   }

   void dwr(ClientPlayerEntity var1, boolean var2) {
      if (!var2) {
         this.dvj = 0;
      }

      if (this.dvj <= 0 && !var1.isUsingItem()) {
         if (!var1.getStackInHand(Hand.MAIN_HAND).contains(DataComponentTypes.PIERCING_WEAPON)) {
            if (var2 && dtw.crosshairTarget != null && dtw.crosshairTarget.getType() == Type.BLOCK) {
               BlockHitResult var3 = (BlockHitResult)dtw.crosshairTarget;
               BlockPos var4 = var3.getBlockPos();
               if (!dtw.world.getBlockState(var4).isAir() && dtw.interactionManager.updateBlockBreakingProgress(var4, var3.getSide())) {
                  var1.swingHand(Hand.MAIN_HAND);
               }
            } else {
               dtw.interactionManager.cancelBlockBreaking();
            }
         }
      }
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   boolean dws(ClientPlayerEntity var1) {
      if (this.dvj > 0) {
         return false;
      }

      if (dtw.crosshairTarget == null) {
         if (dtw.interactionManager.hasLimitedAttackSpeed()) {
            this.dvj = 10;
         }

         return false;
      } else {
         if (var1.isRiding()) {
            return false;
         }

         ItemStack var2 = var1.getStackInHand(Hand.MAIN_HAND);
         if (!var2.isItemEnabled(dtw.world.getEnabledFeatures())) {
            return false;
         }

         if (var1.isBelowMinimumAttackCharge(var2, 0)) {
            return false;
         }

         PiercingWeaponComponent var3 = var2.get(DataComponentTypes.PIERCING_WEAPON);
         if (var3 != null && !dtw.interactionManager.isFlyingLocked()) {
            dtw.interactionManager.attackWithPiercingWeapon(var3);
            var1.swingHand(Hand.MAIN_HAND);
            return true;
         }

         boolean var4 = false;
         switch (dtw.crosshairTarget.getType()) {
            case ENTITY:
               AttackRangeComponent var7 = var2.get(DataComponentTypes.ATTACK_RANGE);
               if (var7 == null || var7.isWithinRange(var1, dtw.crosshairTarget.getPos())) {
                  dtw.interactionManager.attackEntity(var1, ((EntityHitResult)dtw.crosshairTarget).getEntity());
               }
               break;
            case BLOCK:
               BlockHitResult var5 = (BlockHitResult)dtw.crosshairTarget;
               BlockPos var6 = var5.getBlockPos();
               if (!dtw.world.getBlockState(var6).isAir()) {
                  dtw.interactionManager.attackBlock(var6, var5.getSide());
                  if (dtw.world.getBlockState(var6).isAir()) {
                     var4 = true;
                  }
                  break;
               }
            case MISS:
               if (dtw.interactionManager.hasLimitedAttackSpeed()) {
                  this.dvj = 10;
               }

               var1.resetTicksSince();
         }

         if (!var1.isSpectator()) {
            var1.swingHand(Hand.MAIN_HAND);
         }

         return var4;
      }
   }

   void dwt(ClientPlayerEntity var1) {
      if (!dtw.interactionManager.isBreakingBlock()) {
         this.dwz(4);
         if (!var1.isRiding()) {
            for (Hand var5 : Hand.values()) {
               ItemStack var6 = var1.getStackInHand(var5);
               if (!var6.isItemEnabled(dtw.world.getEnabledFeatures())) {
                  return;
               }

               HitResult var7 = dtw.crosshairTarget;
               if (var7 != null) {
                  if (var7.getType() == Type.ENTITY) {
                     EntityHitResult var8 = (EntityHitResult)var7;
                     Entity var9 = var8.getEntity();
                     if (!dtw.world.getWorldBorder().contains(var9.getBlockPos())) {
                        return;
                     }

                     if (var1.canInteractWithEntity(var9, 0.0)) {
                        ActionResult var10 = dtw.interactionManager.interactEntityAtLocation(var1, var9, var8, var5);
                        if (!var10.isAccepted()) {
                           var10 = dtw.interactionManager.interactEntity(var1, var9, var5);
                        }

                        if (var10 instanceof Success var11) {
                           if (var11.swingSource() == SwingSource.CLIENT) {
                              var1.swingHand(var5);
                           }

                           return;
                        }
                     }
                  } else if (var7.getType() == Type.BLOCK) {
                     ActionResult var12 = dtw.interactionManager.interactBlock(var1, var5, (BlockHitResult)var7);
                     if (var12 instanceof Success var15) {
                        if (var15.swingSource() == SwingSource.CLIENT) {
                           var1.swingHand(var5);
                        }

                        return;
                     }

                     if (var12 instanceof Fail) {
                        return;
                     }
                  }
               }

               if (!var6.isEmpty() && dtw.interactionManager.interactItem(var1, var5) instanceof Success var14) {
                  if (var14.swingSource() == SwingSource.CLIENT) {
                     var1.swingHand(var5);
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
      return MathHelper.clamp((float)(System.nanoTime() - this.dvo) / 5.0E7F, 0.0F, 1.0F);
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
      ClientPlayerEntity var3 = dtw.player;
      if (var3 != null && ejp.current() == this && Float.isFinite(var1) && Float.isFinite(var2)) {
         double var4 = this.mouseMultiplier();
         float var6 = var3.getYaw();
         float var7 = var3.getPitch();
         double var8 = (double)var1 - var6;
         double var10 = Math.floor((var8 + 180.0) / 360.0) * 360.0;
         float var12 = (float)(var6 + var10) + prp.quantize(var8 - var10, var4);
         float var13 = MathHelper.clamp(var7 + prp.quantize((double)var2 - var7, var4), -90.0F, 90.0F);
         var3.setYaw(var12);
         var3.setPitch(var13);
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

   void dwu() {
      if (!this.dun.isEmpty()) {
         long var1 = System.currentTimeMillis();
         ArrayList<Runnable> var3 = null;
         Iterator<dtn> var4 = this.dun.iterator();

         while (var4.hasNext()) {
            dtn var5 = (dtn)var4.next();
            if (var1 >= var5.at()) {
               var4.remove();
               if (var3 == null) {
                  var3 = new ArrayList<>();
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
                     this.handler.sendChatCommand(var4.substring(1));
                  } else {
                     this.handler.sendChatMessage(var4);
                  }
               }
            });
         }
      }
   }

   void dwv() {
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

   void dww(String var1) {
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

   void dwx() {
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
         if (dtw.player != null) {
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
         if (dtw.player != null) {
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
         if (dtw.player != null) {
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
            if (dtw.player != null) {
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

   int dwy() {
      return edj.holdsUseCooldown(this) ? edj.useCooldown() : this.itemUseCooldown;
   }

   void dwz(int var1) {
      if (edj.holdsUseCooldown(this)) {
         edj.useCooldown(var1);
      } else {
         this.itemUseCooldown = var1;
      }
   }

   public void selectSlot(int var1) {
      this.post(() -> {
         if (dtw.player != null && var1 >= 0 && var1 < 9) {
            dtw.player.getInventory().setSelectedSlot(var1);
         }
      });
   }

   public void clickSlot(int var1, int var2, int var3, SlotActionType var4) {
      this.post(() -> {
         if (dtw.player != null && dtw.interactionManager != null && dtw.player.currentScreenHandler.syncId == var1) {
            dtw.interactionManager.clickSlot(var1, var2, var3, var4, dtw.player);
         }
      });
   }

   public void closeScreen() {
      this.post(() -> {
         if (dtw.player != null) {
            if (dtw.player.currentScreenHandler != dtw.player.playerScreenHandler) {
               dtw.player.closeHandledScreen();
            } else if (dtw.currentScreen != null) {
               dtw.setScreen(null);
            }

            this.duv = null;
         }
      });
   }

   public void dropSelected(boolean var1) {
      this.post(() -> {
         if (dtw.player != null && !dtw.player.isSpectator() && dtw.player.dropSelectedItem(var1)) {
            dtw.player.swingHand(Hand.MAIN_HAND);
         }
      });
   }

   public void swapHands() {
      this.post(() -> {
         if (this.handler != null && dtw.player != null && !dtw.player.isSpectator()) {
            this.handler.sendPacket(new PlayerActionC2SPacket(Action.SWAP_ITEM_WITH_OFFHAND, BlockPos.ORIGIN, Direction.DOWN));
         }
      });
   }

   void syncOptionsLive() {
      this.post(() -> {
         if (this.handler != null) {
            this.handler.syncOptions(this.syncedOptions());
         }
      });
   }

   public void respawn() {
      this.post(() -> {
         if (dtw.player != null && dtw.player.isDead()) {
            dtw.player.requestRespawn();
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
         dtw.send(() -> {
            try {
               izx.alert(this.dud, var1, vhz.INFO, var2);
            } catch (Throwable var4x) {
            }
         });
      } catch (Throwable var4) {
      }
   }

   void dxa(dts var1, String var2) {
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
      }

      PlayerListEntry var2 = var1.getPlayerListEntry(this.due);
      return var2 == null ? -1 : var2.getLatency();
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
