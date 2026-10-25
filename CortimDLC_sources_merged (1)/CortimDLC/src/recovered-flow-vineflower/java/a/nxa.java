package a;

import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BannerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import net.minecraft.world.chunk.WorldChunk;

public class nxa extends pnc {
   static final String nxb = a.c(-729813488, "\uee74韊ᵅ茵ࣩ");
   static final String nxc = a.d("늘쬦䆩\udfd9各", 675656037, -668925031);
   static final String nxd = a.c(348483266, "溎\u1718鷉ΰ");
   static final String nxe = a.d("ꉨ\udbef儯콜", -603660189, -1943190952);
   static final String nxf = a.c(1809714706, "\u0e63矄ﴄ捣\ue8b5渏");
   static final String nxg = a.d("\uef38雹ᱛ艔ৼ", -181515372, -427450136);
   static final String nxh = a.d("䨴㎄륓", -1746088683, -839613673);
   static final String nxi = a.d("৴灀煮擧\uef3f", -1555736928, 226057065);
   static final String nxj = a.d("耇料獪\ued11曊\ue077娠", -112699413, 802280406);
   static final String nxk = a.b("揿ᨵ郢\u0eed蕄Ί맚", 265643961);
   static final String nxl = a.b("\uf18d蠚˯鳣ፙ閝⿍\ua632㡩뛄㔇콼䇓\ud818剁풷滰", 2015556044);
   static final String nxm = a.c(-1019693863, "냨쥎䎓\uddec嘱킁檬\ue35f絲\uf7b5瀘訞¦鵰ᝑ釕⯯ꐼ㪂");
   static final String nxn = a.c(-1020520630, "ፋ櫟\ue003繵\uf5aa獤쥅䃄\ude97偊펆⧶Ꜥ㺐듀㘬豮β鴜ᭀ隧\ue897晐ﶍ篹");
   static final String nxo = a.d("⮗剄\ud8e9䚑촱䯹\uf1a8籁\ue67f沱\ueb6dᅭ鿊ٶ豓້뒋㭗ꗹ⎥깂큲庵앨䌜", 2143303911, 888149832);
   static final String nxp = a.d("〭䦴쌐夃훉偰\uea24揟ﶌ眱\uf0e6ક落ᶏ鞦ᕏ꼍⃑빿㠣뗄쯴䔳\udeee墚", 211270009, -1555591856);
   static final String nxq = a.d("ㅭ䣴쉐塃힉儰\ueb64抟ﳌ癱\uf1a6\u0bd5蕽\u1ccf雦ᐏ꩝▁묢㥢낔쫂䑳\udbb7巅휙檼\ue4ef繽\uf841", -84916901, -451514315);
   static final String nxr = a.c(-1303116514, "Ē碋\uf22f格\ue7fe慎\udb62囸좪䈖쇘㮤녣ⲳꚔ\u2069騭");
   static final String nxs = a.c(1558973535, "\u086e燂\ufb18攜\ueec9桶홉徵쇧佋좕㛴뱂▇꿘⤢");
   static final String nxt = a.d("䏘㩋냨⻭ꔻ⎂鷌ၝ踍Ӈ茞祭\uf3a6樚\ue044拖\ud89f圵춌䯑숢", 1766663742, -329752095);
   static final String nxu = a.d("벡씽䯾퇮婍\udcf0暨\uef5e甔\ufbc6籠蘒\u0cd0镲ἲ鷞➜꠵㋶듚㥈䌔춪剭퐐庤\ue77a洷\uf3de痶︷\u0093誩ፙ锆", 736967255, -711425336);
   static final String nxv = a.b("ᩨ掊\ue92d獉ﲎ稲쁦䦕폒嵸\udad3₣긆㎧뷣㬕腗\u0ef4鑊ሒ龎\ue5d2歬\uf4ab狖\uf862䆼쯱唘팰壱ꙕⱯ떟㏀", 500506201);
   static final String nxw = a.c(1418924330, "ᔇ沞\ue258硋\uf3eb畔켉䛲\ud8ac剣햲⾹ꄖ㣙늆㑵踱ǥ齈ᴋ郮\ueeac怒﮽綼\uf767䫀쒜幦\udc28埤ꥋ⌋몈㲭똕ෞ莻Ԝ鲮ᚁ栀\ue25e憁ｆ焺죮䈦");
   static final double nxx = 120.0;
   static final double nxy = 100.0;
   static final int nxz = 200;
   static final double nya = 7.0;
   static final int nyb = 2400;
   static final long nyc = 6000L;
   static final long nyd = 10000L;
   static final double nye = 14.0;
   static final long nyf = 240L;
   static final int nyg = 3;
   static final int[] nyh = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
   static final float nyi = -55.0F;
   static final float nyj = 86.0F;
   static final int nyk = 3;
   static final int nyl = 3;
   static final int nym = 100;
   static nxa nyn;
   static boolean nyo;
   final pnz nyp = new pnz();
   final vmc nyq = this.add(new vmc(a.c(1538886874, "貝\uf500翊\ue1e3橷\ueccd嚓\udf74䄬쮚"), 5.0, 1.0, 30.0, 1.0));
   final vlj nyr = this.add(new vlj(a.c(-792673846, "솏렝㋎겤✧ꇚᮌ鉧ి"), vlg.LOOT, ppu.WARDEN_DEFAULTS));
   final vmc nys = this.add(new vmc(a.d("쪝댏㧜Ꞷⰵꫀ႒饪ܸ趑", -2103134400, -329679461), 60.0, 35.0, 200.0, 5.0).suffix(a.c(1642534583, "ᛘ潷")));
   final vkl nyt = this.add(new vkl(a.b("픇것♚력㎷땕༅蛡ᢾ鈎", 578905), false));
   final vmu nyu = this.add(new vmu(a.c(356087237, "疚ఙ蛝ᢿ錭ᗝ꾁♿렳㊓땋伫"), a.c(961501262, "堪↔\uab1b㕫뺷"), 32));
   final vmu nyv = this.add(new vmu(a.c(264744924, "꾜혎峝슷䤴쿄疘ﱦ截\ue88a潒锲"), a.d("杅ỻ鑴\u0a04臙", 1230052507, 2120383418), 120));
   final vlv nyw = this.add(
      new vlv(
         a.b("蚒２痈\uebb0恲\ue6dc岒핥䭮솝䙕", -572881203), a.d("\uec25閳ὢ脛", -691721589, -1487681822), a.c(313494045, "詑\uf3c7礖\ue76f"), a.b("뛜콛䖛\udbe8", -27281777)
      )
   );
   final vmu nyx = this.add(new vmu(a.d("⼭嚻\udc6a䈓즁佾\uf522糟\ue288", 1143535024, 517135068), a.d("뮑숶䣶횑嵇\udbfd", -692494820, 37414396), 32));
   final vmu nyy = this.add(new vmu(a.d("☄徃핃䬰삷䙈ﰔ痩\uebbe", 1713913152, 666442522), a.b("憺\u181d鋝\u0cba蝬ǖ", 2026136011), 32));
   final vkl nyz = this.add(new vkl(a.d("ﴅ蒏๛進᮲鵑✟껴オ먊", 1259604267, 1657533559), false));
   final vkw nza = this.add(
      new vkw(
         a.c(1713758171, "\udf98ꘂⳁ늷㥽뾃և豠ሲ预ὕ\ue523毽"),
         new vkq(a.b("š磧\uf232汏\ue785愢\udb35劅쳕䙮쇹㯜딍ⲯ꛴ ", 1689649443), vhz.LAYERS, () -> ign.openWalk(a.d("\udc8aꔏ\u2fdd놷㩘볟ڟ轸ᄦ鮜", 228617762, 483242723)))
      )
   );
   nwx nzb = nwx.BOOT;
   int nzc = 0;
   int nzd = 0;
   int nze = 0;
   final Random nzf = new Random();
   int nzg = 0;
   BlockPos nzh = null;
   final Map<BlockPos, Long> nzi = new HashMap<>();
   final Map<BlockPos, Long> nzj = new HashMap<>();
   final Set<BlockPos> nzk = new HashSet<>();
   final Map<BlockPos, Long> nzl = new HashMap<>();
   final Map<BlockPos, Long> nzm = new HashMap<>();
   long nzn = 0L;
   int nzo = 0;
   final Map<BlockPos, Integer> nzp = new HashMap<>();
   List<BlockPos> nzq = List.of();
   volatile long nzr = 0L;
   final ConcurrentLinkedQueue<String> nzs = new ConcurrentLinkedQueue<>();
   rzv nzt = null;
   BlockPos nzu = null;
   int nzv = 99;
   BlockPos nzw = null;
   int nzx = 0;
   int nzy = 0;
   long nzz = 700L;
   int oaa = 0;
   BlockPos oab = null;
   int oac = 0;
   int oad = 0;
   int oae = 0;
   Vec3d oaf = null;
   boolean oag = false;
   boolean oah = false;
   boolean oai = false;
   boolean oaj = false;
   final List<nwg> oak = new ArrayList<>(List.of(nwg.FOOD, nwg.INVIS, nwg.SPEED));
   int oal = 3;
   BlockPos oam = null;
   nwg oan = nwg.NONE;
   int oao = 0;
   int oap = 0;
   int oaq = 0;
   long oar = 0L;
   int oas = 0;
   int oat = 0;
   boolean oau = false;
   boolean oav = false;
   BlockPos oaw = null;
   int oax = 0;
   int oay = 0;
   nwg oaz = nwg.NONE;
   int oba = -1;
   BlockPos obb = null;
   long obc = 0L;
   long obd = 0L;
   volatile int obe = -1;
   boolean obf = false;
   boolean obg = false;
   long obh = 0L;
   int obi = -1;
   double obj = 88.0;
   double obk = 84.0;
   int obl = 0;
   int obm = 0;
   boolean obn = false;
   final Map<Integer, Integer> obo = new HashMap<>();
   final Set<Integer> obp = new HashSet<>();
   pmf obq = null;
   int obr = 0;
   BlockPos obs = null;
   long obt = 0L;
   nwg obu = nwg.NONE;
   long obv = 0L;
   boolean obw = false;
   boolean obx = false;
   long oby = 0L;
   long obz = 0L;
   int oca = 0;
   int ocb = 0;
   int occ = -1;
   int ocd = 0;
   boolean oce = false;
   boolean ocf = false;
   int ocg = -1;
   int och = 0;
   int oci = 0;
   boolean ocj = false;
   int ock = 0;
   int ocl = 0;
   int ocm = 0;
   float ocn = 0.0F;
   int oco = 0;
   int ocp = 0;
   int ocq = -100000;
   final Map<ItemStack, Boolean> ocr = new IdentityHashMap<>();
   int ocs = -1;
   int oct = -1;
   int ocu = 0;
   float ocv = 10.0F;
   int ocw = 0;
   int ocx = 0;
   World ocy = null;
   World ocz = null;
   PlayerEntity oda = null;
   Vec3d odb = null;
   int odc = -1;
   boolean odd = false;
   int ode = -100000;
   String odf = "";
   int odg = 0;
   float odh = 0.0F;
   int odi = 0;
   boolean odj = false;
   int odk = 0;
   int odl = 0;
   int odm = -1;
   int odn = -100000;
   final int[] odo = new int[]{-1, -1};
   final int[] odp = new int[2];
   final int[] odq = new int[2];
   final int[] odr = new int[2];
   final int[] ods = new int[2];
   final boolean[] odt = new boolean[2];
   String odu = null;
   int odv = 0;
   String odw = "";
   boolean odx = false;
   boolean ody = false;
   final Map<String, BlockPos> odz = new HashMap<>();
   final Map<String, String> oea = new HashMap<>();
   boolean oeb = false;
   BlockPos oec = null;
   World oed = null;
   int oee = -100000;
   PlayerEntity oef = null;
   int oeg = -100000;
   float oeh = 0.0F;
   boolean oei = false;
   int oej = 0;
   int oek = -100000;
   boolean oel = false;
   int oem = 0;
   int oen = 0;
   int oeo = 40;
   boolean oep = false;
   Vec3d oeq = null;
   int oer = 0;
   int oes = 0;
   int oet = 0;
   BlockPos oeu = null;
   int oev = 0;
   int oew = 0;
   boolean oex = false;
   int oey = 0;
   int oez = 1;
   boolean ofa = false;
   List<BlockPos> ofb = null;
   int ofc = 0;
   int ofd = 0;
   final pyd ofe = new pyd();
   psf off = null;
   pqq ofg = null;
   BlockPos ofh = null;
   boolean ofi = false;
   boolean ofj = false;
   boolean ofk = false;
   final double[] ofl = new double[2];
   double ofm = Double.NaN;
   int ofn = 0;
   int ofo = 0;
   final Set<Long> ofp = new HashSet<>();
   BlockPos ofq = null;
   BlockPos ofr = null;
   final Map<BlockPos, Long> ofs = new HashMap<>();
   BlockPos oft = null;
   Vec3d ofu = null;
   int ofv = 0;
   int ofw = 0;
   int ofx = 0;
   int ofy = 0;
   boolean ofz = false;
   int oga = 0;
   float ogb = 0.0F;
   int ogc = 0;
   Vec3d ogd = null;
   boolean oge = true;
   double ogf = Double.NaN;
   rzy ogg;
   int ogh = 0;
   int ogi = 0;
   long ogj = 0L;
   long ogk = 0L;
   final pjw ogl = new pjw().neuro(lex.WARDEN);
   final pud ogm = pud.INSTANCE;
   boolean ogn = false;
   boolean ogo = false;
   boolean ogp = false;
   boolean ogq = false;
   boolean ogr = false;
   float ogs = 0.0F;
   float ogt = 0.0F;
   double ogu = 0.0;
   float ogv = 0.0F;
   float ogw = 0.0F;
   PlayerEntity ogx = null;
   Vec3d ogy = null;
   BlockPos ogz = null;
   Vec3d oha = null;
   boolean ohb = false;
   boolean ohc = false;
   int ohd = 0;
   int ohe = 0;
   double ohf = 0.0;
   double ohg = 0.0;
   double ohh = 0.0;
   int ohi = 0;
   int ohj = 0;
   boolean ohk = false;
   int ohl = -1000;
   float ohm = 0.0F;
   boolean ohn = false;
   boolean oho = false;
   boolean ohp = false;
   boolean ohq = false;

   public nxa() {
      super(
         a.d("㥵䃰쨢呈\udfa7夠\ue360檇\uf4d9繣", 860443421, -1714984413),
         a.b("ܴ约\uf475樟\ue1cf札\udd2a哇쪕䁡쟅㶂덆⫡ꂳ♉鱈Ꮝ襥༬蛂ﳝ爭\ue9f7澅\ue542島튠䠄츗䖿묷ㄬꣀ⺗ꐮᯮ醞", -2026633378),
         kfa.PLAYER
      );
      this.nyy.visibleWhen(() -> a.d("䯒㉕뢕⛦", -1652830312, 1921811481).equals(this.nyw.get()));
   }

   @Override
   public boolean isMaintenance() {
      return false;
   }

   public static nxa mainInstance() {
      return nyn;
   }

   public void registerAsMain() {
      nyn = this;
      if (!nyo) {
         nyo = true;
         wcn.listen(var0 -> {
            nxa var1 = nyn;
            if (var1 != null && var1.isEnabled() && !var1.isBotInstance()) {
               var1.onPacket(var0);
            }
         });
      }
   }

   @Override
   public void attachBot(efz var1) {
      super.attachBot(var1);
      this.ogg = new rzy(false);
   }

   public boolean ownsContainer() {
      return this.oaz != nwg.NONE;
   }

   public void copySettingsFrom(nxa var1) {
      if (var1 != null && var1 != this) {
         this.nyq.set(var1.nyq.get());
         this.nyr.set(var1.nyr.ids());
         this.nys.set(var1.nys.get());
         this.nyt.set(var1.nyt.get());
         this.nyu.set(var1.nyu.get());
         this.nyv.set(var1.nyv.get());
         this.nyw.set(var1.nyw.get());
         this.nyx.set(var1.nyx.get());
         this.nyy.set(var1.nyy.get());
      }
   }

   public vmo[] botSettings() {
      return new vmo[]{this.nyu, this.nyv, this.nyw, this.nyx, this.nyy, this.nyq, this.nys, this.nyt};
   }

   public vlj lootList() {
      nxa var1 = nyn;
      return this.driver != null && var1 != null && var1 != this ? var1.nyr : this.nyr;
   }

   boolean oht(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      }

      vlj var2 = this.lootList();
      if (this.ocs != this.nzd || this.oct != var2.version() || this.ocr.size() > 256) {
         this.ocr.clear();
         this.ocs = this.nzd;
         this.oct = var2.version();
      }

      Boolean var3 = this.ocr.get(var1);
      if (var3 == null) {
         var3 = ppu.picked(var1, var2.ids());
         this.ocr.put(var1, var3);
      }

      return var3;
   }

   public String queueNote() {
      return this.odf;
   }

   Object ohu() {
      return this.driver != null ? this.driver : pjd.MAIN;
   }

   public void onBotSettingChanged() {
   }

   public void setLootStart(int var1) {
      this.nze = Math.max(0, var1);
   }

   public String getCurrentLootAnarchy() {
      return this.olr();
   }

   public int getStateIndex() {
      return this.nzb == null ? 0 : this.nzb.ordinal();
   }

   public tvz walkBrain() {
      return this.ofe.brain();
   }

   public List<BlockPos> getBotPath() {
      return this.ofb;
   }

   public int getBotPathIndex() {
      return this.ofc;
   }

   public BlockPos getBotTarget() {
      if (this.nzu != null) {
         return this.nzu;
      } else {
         return this.oam != null ? this.oam : this.oab;
      }
   }

   public int getTripChests() {
      return this.nzg;
   }

   public int getMaxChests() {
      return this.nyq.getInt();
   }

   public int getTotalChests() {
      return this.ogh;
   }

   public int getTotalTrips() {
      return this.ogi;
   }

   public long getFarmMillis() {
      return this.ogj;
   }

   public void resetFarmStats() {
      this.ogh = 0;
      this.ogi = 0;
      this.ogj = 0L;
   }

   public boolean wantsBotFrame() {
      if (!this.isEnabled()) {
         return false;
      } else if (this.oaz == nwg.NONE && !this.obw) {
         this.obv = System.currentTimeMillis();
         return false;
      } else {
         return true;
      }
   }

   public void onBotFrame() {
      if (this.isEnabled() && !this.isNotInWorld()) {
         long var1 = System.currentTimeMillis();
         this.obv = var1;
         this.ojk(var1);
         this.okg(var1);
      }
   }

   public static void onFrame() {
      nxa var0 = nyn;
      if (var0 != null && var0.isEnabled() && !var0.isBotInstance() && !var0.isNotInWorld()) {
         long var1 = System.currentTimeMillis();
         var0.obv = var1;
         if (var0.oaz != nwg.NONE || var0.obw) {
            var0.ojk(var1);
            var0.okg(var1);
         }
      }
   }

   @Override
   protected void onEnable() {
      if (this.getPlayer() != null) {
         this.oeh = this.getPlayer().getHealth();
      }

      if (this.driver == null) {
         try {
            mpq var1 = Flow.getInstance().getModuleManager().get(mpq.class);
            if (var1 != null && var1.isEnabled() && !var1.isBotInstance()) {
               var1.setEnabled(false);
            }
         } catch (Exception var2) {
         }
      }

      this.ogk = 0L;
      this.ooi();
      this.ofp.clear();
      this.ofm = Double.NaN;
      this.ofn = 0;
      this.nyp.reset();
      this.odv = 0;
      this.odx = false;
      this.ody = false;
      this.oee = -100000;
      this.oef = null;
      this.ohv();
      this.ohw();
      this.ohy(nwx.BOOT);
      this.nzc = 10;
   }

   @Override
   protected void onDisable() {
      this.ohv();
      this.ooj();
      if (this.driver == null) {
         pnf.clear();
      }

      pjd.cancel(this.ohu());
      this.odf = "";
   }

   void ohv() {
      this.ohy(nwx.RESTOCK);
      this.ohx();
      this.oab = null;
      this.ofb = null;
      this.ofc = 0;
      this.off = null;
      this.ofe.reset();
      this.ofd = 0;
      this.oao = 0;
      this.oaa = 0;
      this.oac = 0;
      this.oam = null;
      this.oan = nwg.NONE;
      this.oap = 0;
      this.oaq = 0;
      this.oas = 0;
      this.oau = false;
      this.oav = false;
      this.oaw = null;
      this.oay = 0;
      this.oeu = null;
      this.oev = 0;
      this.oew = 0;
      this.oey = 0;
      this.oet = 0;
      this.opg();
      this.oer = 0;
      this.oeq = null;
      this.oel = false;
      this.oem = 0;
      this.odg = 0;
      this.odi = 0;
      this.odj = false;
      this.odk = 0;
      this.odl = 0;
      this.odm = -1;
      this.odp[0] = 0;
      this.odp[1] = 0;
      this.oei = false;
      this.oej = 0;
      this.oad = 0;
      this.oae = 0;
      this.ohi = 0;
      this.ohj = 1200 + this.nzf.nextInt(3000);
      this.oha = null;
      this.ohb = false;
      this.ohc = false;
      this.ohd = 0;
      this.ogu = 0.0;
      this.ogz = null;
      this.obs = null;
      this.obu = nwg.NONE;
      this.oce = false;
      this.ocd = 0;
      this.oka();
      this.okh();
      this.oku();
      this.oci = 0;
      this.ocn = 0.0F;
      this.oco = 0;
      this.ocq = -100000;
      this.ocu = 0;
      this.ocx = 0;
      this.nzs.clear();
      if (this.mc.interactionManager != null) {
         this.mc.interactionManager.cancelBlockBreaking();
      }

      ptr.clear();
      this.oje();
   }

   void ohw() {
      this.nzg = 0;
      this.nzh = null;
      this.nzi.clear();
      this.nzj.clear();
      this.nzk.clear();
      this.nzl.clear();
      this.nzm.clear();
      this.ofs.clear();
      this.nzp.clear();
      this.nzq = List.of();
      this.oag = false;
      this.oah = false;
      this.oai = false;
      this.oaj = false;
      this.odu = null;

      for (int var1 = 0; var1 < 2; var1++) {
         this.odt[var1] = false;
         this.ods[var1] = 0;
      }

      this.olm();
   }

   void ohx() {
      this.nzt = null;
      this.nzu = null;
      this.nzv = 99;
      this.nzw = null;
      this.nzx = 0;
      this.nzy = 0;
      this.ohb = false;
   }

   void ohy(nwx var1) {
      if (this.nzb != var1) {
         this.odf = "";
      }

      this.nzb = var1;
   }

   rzy ohz() {
      if (this.driver != null) {
         return this.ogg;
      }

      try {
         return Flow.getInstance().getModuleManager().get(rzy.class);
      } catch (Exception var2) {
         return null;
      }
   }

   void oia() {
      rzy var1 = this.ohz();
      if (var1 != null) {
         var1.clearTimers();
      }
   }

   public void onPacket(Packet<?> var1) {
      if (var1 instanceof InventoryS2CPacket var2 && var2.syncId() != 0) {
         this.obe = var2.syncId();
      } else if (var1 instanceof GameMessageS2CPacket var7) {
         if (this.nzs.size() < 64) {
            this.nzs.add(var7.content().getString());
         }
      } else {
         RegistryEntry var6 = null;
         if (var1 instanceof PlaySoundS2CPacket var3) {
            var6 = var3.getSound();
         } else if (var1 instanceof PlaySoundFromEntityS2CPacket var4) {
            var6 = var4.getSound();
         }

         if (var6 != null) {
            try {
               String var8 = ((SoundEvent)var6.value()).id().getPath();
               if (var8.contains(a.d("溬ᜋ鷋ά衺ເ듓㵾ꌼ⦃깃", 1977503822, 657604254))
                  || var8.contains(a.d("ྰ瘗ﳗ抰\ue966濜헏山숡䢙콟㔥", 1667287867, 1060553968))
                  || var8.contains(a.c(-1113763147, "勎⭩ꆩ㿎되㊢袱ĝ齞ᗮ鈺桁"))) {
                  this.nzr = System.currentTimeMillis();
               }
            } catch (Exception var5) {
            }
         }
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.mc.options != null) {
         this.mc.options.attackKey.setPressed(this.oho);
         this.mc.options.useKey.setPressed(this.ohp);

         while (this.mc.options.attackKey.wasPressed()) {
         }

         while (this.mc.options.useKey.wasPressed()) {
         }

         if (this.obw || this.oaz != nwg.NONE) {
            this.silenceMovement();
         }

         rzy var2 = this.ohz();
         if (var2 != null && !var2.isEnabled() && !this.isNotInWorld()) {
            var2.tickTimers(false);
         }

         if (this.mc.player != null && this.mc.world != null) {
            if (this.driver == null) {
               wcn.ensure(this.mc);
               if (!this.ohq && this.ohn && this.ogn && !this.obw && this.oaz == nwg.NONE) {
                  this.ogm.remapHumanKeys(this.mc, this.ogm.cameraYaw(this.mc.player), this.ogv);
               }
            }

            ptr.applyOwn(this.mc);
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.nzd++;
      if (this.isNotInWorld()) {
         this.ogk = 0L;
         this.oig();
      } else if (this.odx) {
         this.odx = false;
         pqf.resetKeys();
         if (this.driver != null) {
            this.setBotRunning(false);
            this.driver.halted();
         } else {
            this.setEnabled(false);
         }
      } else {
         long var2 = System.currentTimeMillis();
         if (this.ogk != 0L) {
            this.ogj = this.ogj + Math.min(2000L, Math.max(0L, var2 - this.ogk));
         }

         this.ogk = var2;
         pjd.keep(this.ohu());
         this.ook();
         this.ohm = this.getPlayer().getYaw();
         this.ohn = true;
         this.ofe.beginTick();
         boolean var4 = this.oib();
         if (var4 && this.mc.options != null) {
            this.ofi = this.mc.options.sprintKey.isPressed();
            this.ofj = this.mc.options.sneakKey.isPressed();
         }

         try {
            this.oih();
         } finally {
            if (var4) {
               this.oif();
            }

            this.oox();
            this.ofz = this.ohq;
            if ((this.obw || this.oaz != nwg.NONE) && this.mc.options != null) {
               this.mc.options.attackKey.setPressed(false);
               this.mc.options.useKey.setPressed(false);
            }

            this.ojd();
            this.oho = this.mc.options != null && this.mc.options.attackKey.isPressed();
            this.ohp = this.mc.options != null && this.mc.options.useKey.isPressed();
            if (this.driver == null) {
               pnf.publish(this.ofe.shown(), this.ofe.shownAt(), var4, var4 && this.oic(), this.nyz.get(), this.getName());
            }
         }

         long var5 = System.currentTimeMillis();
         if (var5 - this.obv > 80L) {
            this.ojk(var5);
            this.okg(var5);
         }
      }
   }

   boolean oib() {
      return this.driver == null && nyn == this && this.isEnabled() && tcz.walkGuide();
   }

   boolean oic() {
      return this.ofk || this.getPlayer().isUsingItem() || this.obw || this.ocf || this.oaz != nwg.NONE || this.mc.currentScreen != null;
   }

   int oid(int var1) {
      return this.oib() ? var1 * 3 : var1;
   }

   txs oie() {
      return lfa.walkModel(lex.WARDEN);
   }

   void oif() {
      GameOptions var1 = this.mc.options;
      if (var1 != null && !this.obw && this.oaz == nwg.NONE && !this.ocf) {
         KeyBinding[] var2 = new KeyBinding[]{var1.forwardKey, var1.backKey, var1.leftKey, var1.rightKey, var1.jumpKey};

         for (KeyBinding var6 : var2) {
            var6.setPressed(this.heldByHuman(var6));
         }

         if (var1.getSprintToggled().getValue()) {
            if (var1.sprintKey.isPressed() != this.ofi) {
               var1.sprintKey.setPressed(true);
            }
         } else {
            var1.sprintKey.setPressed(this.heldByHuman(var1.sprintKey));
         }

         if (var1.getSneakToggled().getValue()) {
            if (var1.sneakKey.isPressed() != this.ofj) {
               var1.sneakKey.setPressed(true);
            }
         } else {
            var1.sneakKey.setPressed(this.heldByHuman(var1.sneakKey));
         }
      }
   }

   void oig() {
      if (this.ogn) {
         this.ogn = false;
         if (this.driver == null) {
            this.ogm.reset();
         }
      }

      this.ogx = null;
      this.ogy = null;
      this.ohn = false;
      this.oho = false;
      this.ohp = false;
      ptr.clear();
      this.oka();
      this.obw = false;
      this.obx = false;
      this.ocf = false;
      this.oku();
      this.obs = null;
      this.nzp.clear();
      this.nzq = List.of();
      this.ofs.clear();
      this.opg();
   }

   void oih() {
      long var1 = System.currentTimeMillis();
      this.oha = null;
      this.ohq = false;
      this.ofa = false;
      this.ohk = false;
      if (this.oga <= 0 && this.mc.options.backKey.isPressed() && !this.heldByHuman(this.mc.options.backKey)) {
         this.mc.options.backKey.setPressed(false);
      }

      if (this.ofd > 0) {
         this.ofd--;
      }

      if (this.oci > 0) {
         this.oci--;
      }

      if (this.oao > 0) {
         this.oao--;
      }

      if (this.oac > 0) {
         this.oac--;
      }

      if (this.nzo > 0) {
         this.nzo--;
      }

      if (this.oaa > 0) {
         this.oaa--;
      }

      if (this.ocd > 0) {
         this.ocd--;
      }

      if (this.odl > 0) {
         this.odl--;
      }

      if (this.oco > 0) {
         this.oco--;
      }

      this.ocn *= 0.99F;
      int var3 = this.oqk();
      if (var3 > this.ocp && this.nzd - this.ocq < 200 && this.oaz == nwg.NONE) {
         this.oco = 600;
      }

      this.ocp = var3;
      this.onr();
      this.oin();
      this.oim();
      this.oio();
      this.okz();
      if (this.oiq()) {
         pqf.resetKeys();
      } else if (this.oel) {
         pqf.resetKeys();
         if (++this.oem >= 40 && !this.getPlayer().isDead()) {
            this.ohv();
            this.ohy(nwx.TELEPORT_TO_SAVE);
         }
      } else if (this.nzb != nwx.TELEPORT_TO_SAVE
         && this.nzb != nwx.WARPING_TO_SAVE_BASE
         && this.nyp.check(this.getPlayer(), System.currentTimeMillis(), 6000L)) {
         pqf.resetKeys();
         pjd.leave(this.ohu());
         this.ohv();
         this.ohw();
         this.ohy(nwx.TELEPORT_TO_SAVE);
         this.notifyUser(
            a.c(1752946124, "퇶걵⊽볉㜑놠௺蘓ᡄ雧ᄰ\ueb43斗ﰩ瘋\uf49b䫆섅志\ud9fc倎⨣ꓢ㽆뵕㞍긊o麀ᣝ錙榫\ue7f9縅ﱆ犖촵䝈손尳") + ols(this.nyu.get(), a.b("駐\ue06e櫡\uf491罍", 1362270644)), false
         );
      } else if (this.nzb == nwx.BOOT) {
         pqf.resetKeys();
         this.oot();
         if (--this.nzc <= 0) {
            this.oii();
         }
      } else if (!this.oir()) {
         boolean var4 = this.nzb != nwx.WARPING_TO_LOOT_BASE && this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nzb != nwx.LOOTING;
         if (!this.oib()) {
            this.oiu(var4);
            this.ois(var4);
         }

         this.ocu = pqf.onClimbable(this.getPlayer()) ? this.ocu + 1 : 0;
         if (this.mc.currentScreen instanceof AbstractSignEditScreen) {
            this.mc.currentScreen.close();
         } else if (this.oaz == nwg.NONE && this.oil() && !this.ojh(var1)) {
            this.olh();
            this.mc.player.closeHandledScreen();
         } else if (this.oaz != nwg.NONE) {
            pqf.resetKeys();
            this.oot();
            this.olh();
         } else {
            if (this.nzb == nwx.LOOTING) {
               this.ohy(nwx.EXPLORING);
            }

            this.mc.options.sneakKey.setPressed(this.mc.options.useKey.isPressed() && this.oli(this.getPlayer().getMainHandStack()) && !this.opb());
            if (!(this.getPlayer().getHealth() <= 0.0F) && !this.getPlayer().isDead()) {
               if (this.oej > 0) {
                  this.oej--;
               }

               if (this.getPlayer().fallDistance > 3.0) {
                  this.oei = true;
               } else if (this.oei) {
                  this.oei = false;
                  this.oej = 6;
               }

               float var5 = this.getPlayer().getHealth();
               if (var5 < this.oeh && this.oej <= 0 && this.oik() && this.nzb != nwx.ESCAPING) {
                  WardenEntity var6 = this.onu(20.0);
                  PlayerEntity var7 = this.ooh();
                  this.ooa(var6 != null && (var7 == null || var6.squaredDistanceTo(this.getPlayer()) < var7.squaredDistanceTo(this.getPlayer())));
               }

               this.oeh = var5;
               if (this.omp()) {
                  this.oek = this.nzd;
               }

               if (!this.odj && !this.mc.options.useKey.isPressed()) {
                  this.okd(var1);
                  if (this.ocg == -1 && !this.obw && !this.ocf && this.nzb != nwx.ESCAPING) {
                     ItemStack var8 = this.getPlayer().getMainHandStack();
                     if (!var8.isEmpty() && !this.oqd(var8)) {
                        this.olj();
                     }
                  }
               } else {
                  this.oku();
               }

               if (this.obw) {
                  pqf.resetKeys();
                  this.oot();
               } else {
                  this.okp();
                  if (!this.okx()) {
                     if (this.nzb != nwx.ESCAPING && !this.ond(var1)) {
                        if (this.olc()) {
                           this.ole();
                           return;
                        }
                     } else if (this.odg != 0) {
                        this.olf();
                     }

                     if (this.oik() && this.nzb != nwx.ESCAPING && this.onx()) {
                        this.notifyUser(a.d("氬ᖿ鼜ę諏\u0c76눸㾩ꇹ⬳곪嚙\udc52䗮쾰䴢\uf76b磁\ue278搥\uedd6", -488738214, -1879565711), false);
                     }

                     if (var4 && !this.oib()) {
                        this.oiz();
                     }

                     if (this.oga > 0 && var4 && !this.oib()) {
                        this.oga--;
                        this.oja();
                        this.oot();
                     } else {
                        if ((this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST) && this.nzo <= 0) {
                           this.nzo = 5;
                           this.omy(var1);
                        }

                        switch (this.nzb) {
                           case RESTOCK:
                              this.olk(var1);
                              break;
                           case TELEPORT_TO_LOOT:
                              this.olx();
                              break;
                           case WARPING_TO_LOOT_BASE:
                              this.olz();
                              break;
                           case EXPLORING:
                              this.omq(var1);
                              break;
                           case WAITING_FOR_CHEST:
                              this.one(var1);
                           case LOOTING:
                           default:
                              break;
                           case ESCAPING:
                              this.oob();
                              break;
                           case CHECK_PVP_COOLDOWN:
                              this.oof();
                              break;
                           case TELEPORT_TO_SAVE:
                              this.omm();
                              break;
                           case WARPING_TO_SAVE_BASE:
                              this.omn();
                        }

                        if (!this.oib()) {
                           this.ojc(var4);
                        }
                     }
                  }
               }
            } else {
               this.oip();
            }
         }
      }
   }

   void oii() {
      BlockPos var1 = this.getPlayer().getBlockPos();
      rzy var2 = this.ohz();
      String var3 = this.oij();
      if (var2 != null) {
         for (rzv var5 : var2.getCachedTimers()) {
            if (var3.equals(var5.dimension) && var5.pos.squaredDistanceTo(this.getPlayer().getEntityPos()) < 6400.0) {
               this.nzh = var1;
               pjd.at(this.ohu(), this.olr());
               this.ohy(nwx.EXPLORING);
               return;
            }
         }
      }

      if (this.olp(a.d("ℝ壜퉾䱱쟙", -533521177, 38091198)) != null) {
         pjd.at(this.ohu(), ols(this.nyu.get(), a.c(-1538227089, "萋ﶵ眺\ue94a抖")));
         this.ohy(nwx.RESTOCK);
      } else {
         this.ohy(nwx.TELEPORT_TO_SAVE);
      }
   }

   String oij() {
      return this.mc.world == null ? "" : this.mc.world.getRegistryKey().getValue().toString();
   }

   boolean oik() {
      return this.nzb == nwx.EXPLORING
         || this.nzb == nwx.WAITING_FOR_CHEST
         || this.nzb == nwx.CHECK_PVP_COOLDOWN
         || this.nzb == nwx.ESCAPING
         || this.nzb == nwx.LOOTING
         || this.nzb == nwx.TELEPORT_TO_SAVE && this.nzh != null && !this.odf.isEmpty();
   }

   boolean oil() {
      return this.mc.currentScreen instanceof HandledScreen var1
         && !(var1 instanceof InventoryScreen)
         && !(var1.getScreenHandler() instanceof PlayerScreenHandler);
   }

   void oim() {
      String var1;
      while ((var1 = this.nzs.poll()) != null) {
         String var2 = var1.toLowerCase();
         int var3 = 0;

         while (var3 < var2.length() && !Character.isLetter(var2.charAt(var3))) {
            var3++;
         }

         var2 = var2.substring(var3);
         if (var2.startsWith(a.d("䳒㕢뾳↱ꨔⲠ雷", -1917657672, 424908114))
            || var2.startsWith(a.d("廴❄궕㎗렲㺋蓑", -269654129, 1642937667))
            || var2.startsWith(a.b("\ue940邈Ḱ葞ྈ褴㍬몔Ⓛ깳", -1169953416))
            || var2.startsWith(a.d("气ᗘ鼂Ć諓౬뉓㾿ꇭ⽌겅困\ud827䇨쯏䴲\uf778碤\ue265摆\uedc4", 1234580538, -395551622))) {
            this.oee = this.nzd;
         }

         boolean var4 = var2.contains(a.b("拰᬴釤", -693344592))
               && (var2.contains(a.c(904261579, "\ueb8c鉉ᣯ蛬഼诸")) || var2.contains(a.c(1475068875, "쟳빃㒚ꫥℳꟷᶭ")) || var2.contains(a.b("ᢙ愥\ueb83疉﹔磩싀", 959782051)))
            || var2.contains(a.c(778730326, "符ʚ街ᘱ鷢᭖ꄘ⢰뚬㰑믃䆲콮囙\udc9d婽\ue033"));
         if (this.nzb == nwx.WARPING_TO_LOOT_BASE && !this.oau && var4) {
            this.odd = true;
         }

         if (var4 && (this.nzb == nwx.WARPING_TO_SAVE_BASE || this.nzb == nwx.TELEPORT_TO_SAVE)) {
            this.nyp.dismiss(this.getWorld());
         }
      }
   }

   void oin() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 != this.oef) {
         this.oeg = this.nzd;
      }

      this.oef = var1;
   }

   void oio() {
      if (this.nzd - this.oee <= 100) {
         ClientPlayerEntity var1 = this.getPlayer();
         boolean var2 = var1.isDead() || var1.getHealth() <= 0.0F;
         boolean var3 = this.nzb == nwx.TELEPORT_TO_LOOT
            || this.nzb == nwx.TELEPORT_TO_SAVE
            || this.nzb == nwx.WARPING_TO_SAVE_BASE
            || this.nzb == nwx.WARPING_TO_LOOT_BASE && (this.odc < 0 || this.oas - this.odc < 100);
         boolean var4 = !var3 && this.oeg >= this.oee - 100;
         if (var2 || var4) {
            this.oee = -100000;
            this.oip();
         }
      }
   }

   void oip() {
      if (!this.oel) {
         this.oel = true;
         this.oem = 0;
         this.nze++;
         this.oka();
         this.okh();
         this.olh();
         this.notifyUser(a.c(1582595820, "竝ͱ覫ឯ鱺᫅ꓺⴆ더㷸먦䑇컱圴\udd6b宑"), false);
      }
   }

   boolean oiq() {
      if (!(this.mc.currentScreen instanceof DeathScreen)) {
         this.oen = 0;
         this.oep = false;
         this.oeo = 26 + this.nzf.nextInt(34);
         return false;
      }

      this.oip();
      if (++this.oen >= this.oeo && !this.oep && this.mc.player != null) {
         this.mc.player.requestRespawn();
         this.oep = true;
      }

      return true;
   }

   boolean oir() {
      if (this.oes > 0) {
         this.oes--;
      }

      Vec3d var1 = this.getPlayer().getEntityPos();
      if (this.oeq != null && !(var1.squaredDistanceTo(this.oeq) > 2.25)) {
         this.oer++;
         if (this.nzb == nwx.RESTOCK && this.ody) {
            this.oer = 0;
            return false;
         }

         if (this.oer >= 2400 && this.oes <= 0) {
            pqf.resetKeys();
            this.olh();
            if (this.mc.player != null && this.mc.currentScreen != null) {
               this.mc.player.closeHandledScreen();
            }

            if (this.nzg == 0 && this.nzb != nwx.TELEPORT_TO_SAVE && this.nzb != nwx.TELEPORT_TO_LOOT) {
               this.omd(
                  wap.s(
                     a.d("\uf5e1豗ڟ飮ጲ闇⿇\ua631㡳닇㔔켩䆸\ud800剎퓭溰\ue173箍\ufdd8琨\u0e62胐ᬐ鵹", -1879600606, 1028941737),
                     a.c(27431981, "遻\ue9c9捦ﵦ盅\uf46f䨡쏝妒휿僥ꫠ\u2434뷲㎴땗༊蓇Ṱ頤ᆭ毽\ue547")
                  )
               );
               if (this.ome()) {
                  return true;
               }
            }

            this.ohv();
            this.oeq = var1;
            this.oes = 600;
            this.ohy(nwx.TELEPORT_TO_SAVE);
            return true;
         } else {
            return false;
         }
      } else {
         this.oeq = var1;
         this.oer = 0;
         return false;
      }
   }

   void ois(boolean var1) {
      boolean var2 = var1 && this.ofz && this.ohi <= 0 && !this.obw && this.oga <= 0;
      Vec3d var3 = this.getPlayer().getEntityPos();
      if (!var2) {
         this.ofu = null;
         this.ofv = 0;
      } else if (this.ofu != null && !(oit(var3, this.ofu) > 0.9)) {
         if (++this.ofv >= 28) {
            this.ofu = var3;
            this.ofv = 0;
            this.oiv(false);
         }
      } else {
         this.ofu = var3;
         this.ofv = 0;
      }
   }

   static double oit(Vec3d var0, Vec3d var1) {
      return Math.hypot(var0.x - var1.x, var0.z - var1.z);
   }

   void oiu(boolean var1) {
      ClientPlayerEntity var2 = this.getPlayer();
      boolean var3 = var2.isOnGround();
      if (var3 || Double.isNaN(this.ogf)) {
         this.ogf = var2.getY();
      }

      if (this.oge && !var3 && var2.getVelocity().y > 0.2) {
         this.ogd = var2.getEntityPos();
      } else if (!this.oge && var3 && this.ogd != null) {
         double var4 = oit(var2.getEntityPos(), this.ogd);
         double var6 = var2.getY() - this.ogd.y;
         this.ogd = null;
         if (var1 && this.ofz && var4 < 0.55 && var6 < 0.3) {
            if (++this.ogc >= 2) {
               this.ogc = 0;
               this.oiv(true);
            }
         } else {
            this.ogc = 0;
         }
      }

      this.oge = var3;
   }

   void oiv(boolean var1) {
      this.oet++;
      this.ofy = 0;
      BlockPos var2 = this.opb() ? this.ofb.get(this.ofc) : null;
      if (var2 != null && this.opp(var2) < 6.25 && !var2.equals(this.ofq) && (var1 || var2.equals(this.oft))) {
         this.oiw(var2, 30000L);
      }

      this.oft = var2;
      this.oiy();
      this.ofb = null;
      this.ofc = 0;
      this.ofd = 0;
      this.oey = 0;
      if (this.oet >= 4) {
         this.oet = 0;
         this.ojb();
      }
   }

   void oiw(BlockPos var1, long var2) {
      if (this.ofs.size() > 256) {
         this.ofs.clear();
      }

      this.ofs.put(var1.toImmutable(), System.currentTimeMillis() + var2);
   }

   Set<BlockPos> oix() {
      if (this.ofs.isEmpty()) {
         return Set.of();
      }

      long var1 = System.currentTimeMillis();
      this.ofs.values().removeIf(var2 -> var2 <= var1);
      return this.ofs.isEmpty() ? Set.of() : new HashSet<>(this.ofs.keySet());
   }

   void oiy() {
      this.oga = 0;
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 != null && var1.isOnGround()) {
         float var2 = this.oow();
         float[] var3 = new float[]{180.0F, 135.0F, -135.0F, 90.0F, -90.0F};
         int var4 = this.nzf.nextBoolean() ? 1 : 2;

         for (int var5 = 0; var5 < var3.length; var5++) {
            int var6 = var5 == 0 ? 0 : (var5 == 1 ? var4 : (var5 == 2 ? 3 - var4 : var5));
            float var7 = var2 + var3[var6];
            pxa var8 = pxd.run(var1, var7, false, false, 8);
            if (var8.progress > 0.35 && var8.endY > var1.getY() - 0.7 && !var8.blockedWithin(2)) {
               this.ogb = var7;
               this.oga = 5 + this.nzf.nextInt(6);
               return;
            }
         }
      }
   }

   void oiz() {
      if (this.ocu >= 6 && this.oga <= 0) {
         ClientPlayerEntity var1 = this.getPlayer();
         if (!this.opb() || !(pqf.getStandY(this.ofb.get(this.ofc)) > var1.getY() + 0.6)) {
            if (this.ocu > 200) {
               this.ocu = 0;
               this.oiv(false);
            }

            BlockPos var2 = var1.getBlockPos();
            this.oiw(var2, 30000L);
            this.oiw(var2.down(), 30000L);
            this.ofb = null;
            this.ofc = 0;
            this.ofd = 0;
            Vec3d var3 = pqf.awayFromClimbable(var1);
            this.ogb = var3 != null ? (float)Math.toDegrees(Math.atan2(-var3.x, var3.z)) : this.oow() + 180.0F;
            this.oga = 6 + this.nzf.nextInt(5);
         }
      }
   }

   void oja() {
      float var1 = -1.0F;
      float var2 = 0.0F;
      float var3 = Float.MAX_VALUE;

      for (float var4 = -1.0F; var4 <= 1.0F; var4++) {
         for (float var5 = -1.0F; var5 <= 1.0F; var5++) {
            if (var4 != 0.0F || var5 != 0.0F) {
               double var6 = Math.toDegrees(pud.inputDirection(this.ogv, var4, var5));
               float var8 = Math.abs(MathHelper.wrapDegrees((float)var6 - this.ogb));
               if (var8 < var3) {
                  var3 = var8;
                  var1 = var4;
                  var2 = var5;
               }
            }
         }
      }

      this.ohq = true;
      this.ofa = true;
      this.mc.options.forwardKey.setPressed(var1 > 0.0F);
      this.mc.options.backKey.setPressed(var1 < 0.0F);
      this.mc.options.leftKey.setPressed(var2 > 0.0F);
      this.mc.options.rightKey.setPressed(var2 < 0.0F);
      this.mc.options.sprintKey.setPressed(false);
      this.mc.options.jumpKey.setPressed(false);
   }

   void ojb() {
      long var1 = System.currentTimeMillis();
      if (this.nzb == nwx.WAITING_FOR_CHEST && this.nzu != null) {
         this.nzj.put(this.nzu, var1 + 30000L);
         this.ohx();
         this.ohy(nwx.EXPLORING);
      } else if (this.oab != null) {
         this.nzl.put(this.oab, var1 + 60000L);
         this.oab = null;
      } else if (this.nzb == nwx.CHECK_PVP_COOLDOWN) {
         this.oeu = null;
      }
   }

   void ojc(boolean var1) {
      boolean var2 = this.mc.options.forwardKey.isPressed();
      if (var1 && var2 && pqf.isBlockedHorizontally()) {
         this.oey++;
         if (this.oey >= 8) {
            this.ohq = true;
            if (this.oey % 20 == 0) {
               this.oez = -this.oez;
            }

            this.mc.options.rightKey.setPressed(this.oez > 0);
            this.mc.options.leftKey.setPressed(this.oez < 0);
            if (this.oey > 30) {
               this.oew = (this.oew + 1) % nyh.length;
               this.oiv(false);
            }
         }
      } else {
         this.oey = 0;
         if (!this.ofa) {
            this.mc.options.leftKey.setPressed(false);
            this.mc.options.rightKey.setPressed(false);
         }
      }
   }

   void ojd() {
      if (this.mc.options != null && !this.obw && this.oaz == nwg.NONE) {
         KeyBinding[] var1 = new KeyBinding[]{
            this.mc.options.forwardKey,
            this.mc.options.backKey,
            this.mc.options.leftKey,
            this.mc.options.rightKey,
            this.mc.options.jumpKey,
            this.mc.options.sneakKey,
            this.mc.options.sprintKey
         };

         for (KeyBinding var5 : var1) {
            if (this.heldByHuman(var5)) {
               var5.setPressed(true);
            }
         }
      }
   }

   void oje() {
      if (this.mc.options != null) {
         KeyBinding[] var1 = new KeyBinding[]{
            this.mc.options.forwardKey,
            this.mc.options.backKey,
            this.mc.options.leftKey,
            this.mc.options.rightKey,
            this.mc.options.jumpKey,
            this.mc.options.sprintKey,
            this.mc.options.sneakKey,
            this.mc.options.attackKey,
            this.mc.options.useKey
         };

         for (KeyBinding var5 : var1) {
            if (!this.heldByHuman(var5)) {
               var5.setPressed(false);
            }
         }
      }
   }

   void ojf() {
      if (this.mc.options != null) {
         KeyBinding[] var1 = new KeyBinding[]{
            this.mc.options.forwardKey,
            this.mc.options.backKey,
            this.mc.options.leftKey,
            this.mc.options.rightKey,
            this.mc.options.jumpKey,
            this.mc.options.sprintKey
         };

         for (KeyBinding var5 : var1) {
            var5.setPressed(this.heldByHuman(var5));
         }
      }
   }

   public boolean busy() {
      return this.oaz != nwg.NONE || this.obw || this.ocf;
   }

   void ojg(BlockPos var1, nwg var2, long var3) {
      this.obs = var1;
      this.obt = var3;
      this.obu = var2;
   }

   boolean ojh(long var1) {
      if (this.mc.currentScreen instanceof HandledScreen var3) {
         ScreenHandler var7 = var3.getScreenHandler();
         if (var7 instanceof GenericContainerScreenHandler var5 && this.obs != null && this.obu != nwg.NONE && var1 - this.obt <= 2500L) {
            int var6 = this.oji(this.obs);
            if (var6 > 0 && var5.getRows() * 9 == var6) {
               this.oaz = this.obu;
               this.oba = var7.syncId;
               this.obb = this.obs;
               this.obd = var1;
               this.obf = false;
               this.obg = false;
               this.obm = 0;
               this.obl = 0;
               this.obn = false;
               this.obh = 0L;
               this.obi = -1;
               this.obo.clear();
               this.obp.clear();
               this.obq = null;
               this.obr = 0;
               this.obj = 88.0;
               this.obk = (114.0 + var5.getRows() * 18.0) / 2.0;
               this.obc = var1 + Math.round(MathHelper.clamp(230.0 * Math.exp(this.nzf.nextGaussian() * 0.25), 150.0, 480.0));
               this.obs = null;
               this.obu = nwg.NONE;
               if (this.oaz == nwg.LOOT) {
                  this.ohy(nwx.LOOTING);
               }

               this.silenceMovement();
               return true;
            } else {
               this.nzj.put(this.obs, var1 + 30000L);
               this.obs = null;
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   int oji(BlockPos var1) {
      if (this.getWorld() == null) {
         return 0;
      } else {
         BlockState var2 = this.getWorld().getBlockState(var1);
         if (!(var2.getBlock() instanceof ChestBlock)) {
            return 0;
         } else {
            return var2.get(ChestBlock.CHEST_TYPE) == ChestType.SINGLE ? 27 : 54;
         }
      }
   }

   HandledScreen<?> ojj() {
      return this.mc.currentScreen instanceof HandledScreen var1 && var1.getScreenHandler().syncId == this.oba ? var1 : null;
   }

   void ojk(long var1) {
      if (this.oaz != nwg.NONE && this.getPlayer() != null && this.getInteractionManager() != null) {
         HandledScreen var3 = this.ojj();
         if (var3 == null) {
            this.ojz();
         } else {
            ScreenHandler var4 = var3.getScreenHandler();
            if (this.obf) {
               if (var1 >= this.obc) {
                  if (this.ojp(var4, var1)) {
                     return;
                  }

                  this.mc.player.closeHandledScreen();
                  this.ojz();
               }
            } else if (var1 >= this.obc) {
               if (!this.isMovementSilent()) {
                  this.obc = var1 + 25L;
               } else if (this.obe != this.oba && var1 - this.obd < 1500L) {
                  this.obc = var1 + 40L;
               } else if (this.obq != null) {
                  pmc var5 = this.obq.drive(var4, var1, (var2, var3x, var4x) -> this.ojl(var4, var2, var3x, var4x));
                  if (var5 == pmc.DONE || var5 == pmc.GAVE_UP) {
                     this.obq = null;
                     this.obc = var1 + pmf.settleDelay(this.nzf);
                  }
               } else if (!this.ojp(var4, var1)) {
                  if (!var4.getCursorStack().isEmpty()) {
                     this.ojy(var1);
                  } else {
                     switch (this.oaz) {
                        case LOOT:
                           this.ojm(var4, var1);
                           break;
                        case DUMP:
                           this.ojn(var4, var1);
                           break;
                        case FOOD:
                           this.ojo(var4, var1);
                           break;
                        case INVIS:
                           this.ojs(var4, var1, true);
                           break;
                        case SPEED:
                           this.ojs(var4, var1, false);
                           break;
                        default:
                           this.ojy(var1);
                     }
                  }
               }
            }
         }
      }
   }

   void ojl(ScreenHandler var1, int var2, int var3, SlotActionType var4) {
      this.getInteractionManager().clickSlot(var1.syncId, var2, var3, var4, this.getPlayer());
      this.obh = System.currentTimeMillis();
      if (var2 >= 0 && var2 < var1.slots.size()) {
         Slot var5 = var1.slots.get(var2);
         this.obj = var5.x + 8.0;
         this.obk = var5.y + 8.0;
      }
   }

   void ojm(ScreenHandler var1, long var2) {
      Slot var4 = this.obi >= 0 && this.oju(var1, this.obi) ? var1.slots.get(this.obi) : this.ojt(var1, -1, true);
      if (var4 == null) {
         if (this.obh > 0L && var2 - this.obh < 240L) {
            this.obc = this.obh + 240L;
         } else {
            this.obn = this.ojw(var1);
            this.obg = true;
            this.ojy(var2);
         }
      } else {
         int var5 = this.obo.merge(var4.id, 1, Integer::sum);
         if (var5 > 3) {
            this.obp.add(var4.id);
            this.obi = -1;
         } else {
            this.ojl(var1, var4.id, 0, SlotActionType.QUICK_MOVE);
            if (var5 == 1) {
               this.obl++;
            }

            Slot var6 = this.ojt(var1, var4.id, true);
            this.obi = var6 == null ? -1 : var6.id;
            double var7 = var6 == null ? 0.0 : Math.hypot(var6.x - var4.x, var6.y - var4.y) / 18.0;
            this.obc = var2 + this.okc(var7, 1.0);
         }
      }
   }

   void ojn(ScreenHandler var1, long var2) {
      Slot var4 = this.obi >= 0 && this.ojv(var1, this.obi) ? var1.slots.get(this.obi) : this.ojt(var1, -1, false);
      if (var4 == null) {
         if (this.obh > 0L && var2 - this.obh < 240L) {
            this.obc = this.obh + 240L;
         } else {
            this.obg = true;
            this.ojy(var2);
         }
      } else {
         int var5 = this.obo.merge(var4.id, 1, Integer::sum);
         if (var5 > 3) {
            this.obp.add(var4.id);
            this.obi = -1;
         } else {
            this.ojl(var1, var4.id, 0, SlotActionType.QUICK_MOVE);
            Slot var6 = this.ojt(var1, var4.id, false);
            this.obi = var6 == null ? -1 : var6.id;
            double var7 = var6 == null ? 0.0 : Math.hypot(var6.x - var4.x, var6.y - var4.y) / 18.0;
            this.obc = var2 + this.okc(var7, 1.15);
         }
      }
   }

   void ojo(ScreenHandler var1, long var2) {
      int var4 = this.oqh(Items.GOLDEN_CARROT);
      if (var4 > this.oal && this.obm < 6) {
         int var5 = this.ojr(var1, var0 -> var0.isOf(Items.GOLDEN_CARROT));
         if (var5 != -1) {
            this.obm++;
            this.ojl(var1, var5, 0, SlotActionType.QUICK_MOVE);
            this.obc = var2 + this.okc(1.0, 1.4);
            return;
         }
      }

      if (var4 < this.oal && this.obm < 6) {
         this.obm++;
         this.obq = pmf.plan(var1, this.getPlayer().getInventory(), var0 -> var0.isOf(Items.GOLDEN_CARROT), this.oal - var4, this.nzf, var2);
         if (this.obq == null) {
            this.obg = true;
            this.ojy(var2);
         }
      } else {
         this.obg = true;
         this.ojy(var2);
      }
   }

   boolean ojp(ScreenHandler var1, long var2) {
      ItemStack var4 = var1.getCursorStack();
      if (!var4.isEmpty() && this.obr < 8) {
         boolean var5 = this.oaz == nwg.DUMP
            || this.oaz == nwg.FOOD && var4.isOf(Items.GOLDEN_CARROT)
            || this.oaz == nwg.INVIS && this.oqf(var4, true)
            || this.oaz == nwg.SPEED && this.oqf(var4, false);
         int var6 = var5 ? pmf.stashSlot(var1, this.getPlayer().getInventory(), var4, -1) : this.ojq(var1, var4);
         if (var6 == -1) {
            var6 = var5 ? this.ojq(var1, var4) : pmf.stashSlot(var1, this.getPlayer().getInventory(), var4, -1);
         }

         if (var6 == -1) {
            return false;
         }

         this.obr++;
         this.ojl(var1, var6, 0, SlotActionType.PICKUP);
         this.obc = var2 + pmf.settleDelay(this.nzf);
         return true;
      } else {
         return false;
      }
   }

   int ojq(ScreenHandler var1, ItemStack var2) {
      PlayerInventory var3 = this.getPlayer().getInventory();
      int var4 = -1;

      for (int var5 = 0; var5 < var1.slots.size(); var5++) {
         Slot var6 = var1.slots.get(var5);
         if (var6.inventory == var3 && var6.getIndex() < 36) {
            if (!var6.hasStack()) {
               if (var4 == -1) {
                  var4 = var5;
               }
            } else if (ItemStack.areItemsAndComponentsEqual(var6.getStack(), var2) && var6.getStack().getCount() < var6.getStack().getMaxCount()) {
               return var5;
            }
         }
      }

      return var4;
   }

   int ojr(ScreenHandler var1, Predicate<ItemStack> var2) {
      PlayerInventory var3 = this.getPlayer().getInventory();
      int var4 = -1;
      int var5 = 0;

      for (int var6 = 0; var6 < var1.slots.size(); var6++) {
         Slot var7 = var1.slots.get(var6);
         if (var7.inventory == var3 && var7.getIndex() < 36 && var7.hasStack() && var2.test(var7.getStack()) && var7.getStack().getCount() > var5) {
            var5 = var7.getStack().getCount();
            var4 = var6;
         }
      }

      return var4;
   }

   void ojs(ScreenHandler var1, long var2, boolean var4) {
      int var5 = this.oqg(var4);
      if (var5 != 1 && this.obm <= 4) {
         if (var5 > 1) {
            for (int var6 = 0; var6 < var1.slots.size(); var6++) {
               Slot var7 = var1.slots.get(var6);
               if (var7.inventory == this.getPlayer().getInventory() && this.oqf(var7.getStack(), var4)) {
                  this.ojl(var1, var6, 0, SlotActionType.QUICK_MOVE);
                  this.obc = var2 + this.okc(1.0, 1.4);
                  return;
               }
            }

            this.obm++;
         } else {
            this.obm++;
            this.obq = pmf.plan(var1, this.getPlayer().getInventory(), var2x -> this.oqf(var2x, var4), 1, this.nzf, var2);
            if (this.obq == null) {
               this.obg = true;
               this.ojy(var2);
            }
         }
      } else {
         this.obg = true;
         this.ojy(var2);
      }
   }

   Slot ojt(ScreenHandler var1, int var2, boolean var3) {
      Slot var4 = null;
      double var5 = Double.MAX_VALUE;

      for (int var7 = 0; var7 < var1.slots.size(); var7++) {
         if (var7 != var2 && (var3 ? this.oju(var1, var7) : this.ojv(var1, var7))) {
            Slot var8 = var1.slots.get(var7);
            double var9 = Math.hypot(var8.x + 8.0 - this.obj, var8.y + 8.0 - this.obk);
            if (var9 < var5) {
               var5 = var9;
               var4 = var8;
            }
         }
      }

      return var4;
   }

   boolean oju(ScreenHandler var1, int var2) {
      if (var2 >= 0 && var2 < var1.slots.size() && !this.obp.contains(var2)) {
         Slot var3 = var1.slots.get(var2);
         PlayerInventory var4 = this.getPlayer().getInventory();
         if (var3.inventory != var4 && var3.hasStack()) {
            ItemStack var5 = var3.getStack();
            return !this.oqa(var5) && var3.canTakeItems(this.getPlayer()) && ojx(var4, var5);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   boolean ojv(ScreenHandler var1, int var2) {
      if (var2 >= 0 && var2 < var1.slots.size() && !this.obp.contains(var2)) {
         Slot var3 = var1.slots.get(var2);
         if (var3.inventory == this.getPlayer().getInventory() && var3.hasStack() && var3.getIndex() < 36) {
            ItemStack var4 = var3.getStack();
            return !this.oqe(var4) && !this.oqb(var4);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   boolean ojw(ScreenHandler var1) {
      PlayerInventory var2 = this.getPlayer().getInventory();

      for (Slot var4 : var1.slots) {
         if (var4.inventory != var2 && var4.hasStack() && !this.oqa(var4.getStack()) && !ojx(var2, var4.getStack())) {
            return true;
         }
      }

      return false;
   }

   static boolean ojx(PlayerInventory var0, ItemStack var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         ItemStack var3 = var0.getStack(var2);
         if (var3.isEmpty()) {
            return true;
         }

         if (var3.getCount() < var3.getMaxCount() && ItemStack.areItemsAndComponentsEqual(var3, var1)) {
            return true;
         }
      }

      return false;
   }

   void ojy(long var1) {
      this.obf = true;
      this.obc = var1 + Math.round(MathHelper.clamp(160.0 * Math.exp(this.nzf.nextGaussian() * 0.25), 90.0, 400.0));
   }

   void ojz() {
      nwg var1 = this.oaz;
      BlockPos var2 = this.obb;
      boolean var3 = this.obg;
      this.oka();
      this.oar = System.currentTimeMillis();
      this.oaq = 0;
      if (var1 == nwg.LOOT) {
         this.okb(var2);
      } else if (var1 != nwg.NONE) {
         if (!var3 && ++this.oap < 3) {
            this.oam = null;
         } else {
            this.oap = 0;
            switch (var1) {
               case DUMP:
                  this.oag = true;
                  break;
               case FOOD:
                  this.oah = true;
                  break;
               case INVIS:
                  this.oai = true;
                  break;
               case SPEED:
                  this.oaj = true;
            }

            this.oam = null;
         }
      }
   }

   void oka() {
      this.oaz = nwg.NONE;
      this.oba = -1;
      this.obb = null;
      this.obf = false;
      this.obg = false;
      this.obi = -1;
      this.obo.clear();
      this.obp.clear();
      this.obq = null;
      this.obr = 0;
   }

   void okb(BlockPos var1) {
      long var2 = System.currentTimeMillis();
      if (var1 != null) {
         this.nzi.put(var1, var2);
         if (this.getWorld() != null && this.driver == null) {
            oqv.markFromOutside(this.getWorld(), var1, this.obn);
         }
      }

      if (this.obl > 0) {
         this.nzg++;
         this.ogh++;
         this.odv = 0;
         if (this.nzh != null) {
            String var4 = pjd.key(this.olr());
            this.odz.put(var4, this.nzh);
            this.oea.put(var4, this.oij());
         }
      }

      this.oce = true;
      this.ohx();
      this.ofb = null;
      this.ofc = 0;
      if (this.obn || this.oql() < 2) {
         this.oml(a.d("⃪奾펢䷔옋䃅\ufae4獥\ued36揫\ue027ᩗ钅റ蝡֍뿏〓꺽⣡ꔆ\udb36嗱츬䡘", -1393893021, 2083702152));
      } else if (this.nzg >= this.nyq.get()) {
         this.oml(a.c(-1004802330, "\ueade錍ᦠ蟘౸誰メ봈✶그⨤퀤広윿䴚쾀痂羽撰\ue2ec漋ᄻ鿼С艕"));
      } else {
         this.ohy(nwx.EXPLORING);
         this.oaa = 0;
      }
   }

   long okc(double var1, double var3) {
      double var5 = this.nys.get() * var3;
      double var7 = var5 * Math.exp(this.nzf.nextGaussian() * 0.22) + var5 * 0.32 * (Math.log(1.0 + var1) / Math.log(2.0));
      if (this.nzf.nextDouble() < 0.04) {
         var7 += var5 * (1.0 + this.nzf.nextDouble() * 1.6);
      }

      return Math.round(MathHelper.clamp(var7, var5 * 0.6, var5 * 5.0));
   }

   void okd(long var1) {
      if (!this.okv()) {
         if (!this.obw && this.oaz == nwg.NONE && this.mc.currentScreen == null) {
            if (this.nzb != nwx.ESCAPING
               && this.nzb != nwx.BOOT
               && this.nzb != nwx.CHECK_PVP_COOLDOWN
               && this.nzb != nwx.TELEPORT_TO_SAVE
               && this.nzb != nwx.WARPING_TO_SAVE_BASE
               && this.nzb != nwx.TELEPORT_TO_LOOT
               && this.nzb != nwx.WARPING_TO_LOOT_BASE) {
               if (this.oci <= 0 && this.okq()) {
                  int var3 = this.oks();
                  if (var3 != -1) {
                     if (this.ocn > 10.0F) {
                        this.oci = 200 + this.nzf.nextInt(200);
                        return;
                     }

                     this.okt(var3);
                     return;
                  }
               }

               if (this.ocd <= 0 && this.odl <= 60) {
                  PlayerInventory var12 = this.getPlayer().getInventory();
                  boolean var4 = this.okr();
                  int var5 = 0;
                  int var6 = 0;
                  int var7 = 0;
                  int var8 = 0;

                  for (int var9 = 9; var9 < 36; var9++) {
                     ItemStack var10 = var12.getStack(var9);
                     if (var10.isEmpty()) {
                        var6++;
                     } else if (var4 && this.oqb(var10)) {
                        var5++;
                     }
                  }

                  for (int var13 = 0; var13 < 9; var13++) {
                     ItemStack var15 = var12.getStack(var13);
                     if (var15.isEmpty()) {
                        var8++;
                     } else if (!this.oqb(var15) && !this.oqd(var15)) {
                        var7++;
                     }
                  }

                  boolean var14 = this.oke();
                  boolean var16 = var14 || var5 > 0 && (var6 <= 3 || var5 >= 5 || this.oce) || var7 > 0 && var6 > 0 && (this.oce || var8 < 2);
                  if (!var16) {
                     this.oce = false;
                  } else {
                     boolean var11 = !this.opb() || this.oce;
                     if (var14 || var11 || var6 <= 1 || var8 < 1) {
                        this.okf(var1);
                        this.oce = false;
                     }
                  }
               }
            }
         }
      }
   }

   boolean oke() {
      return this.nzb != nwx.RESTOCK && this.nzb != nwx.WARPING_TO_SAVE_BASE && this.nzb != nwx.TELEPORT_TO_SAVE ? this.okj() != null : false;
   }

   void okf(long var1) {
      if (!this.obw) {
         this.oku();
         this.obw = true;
         this.obx = false;
         this.ocb = 0;
         this.occ = -1;
         this.oca = this.nzd;
         this.obz = var1;
         this.oby = var1 + Math.round(MathHelper.clamp(190.0 * Math.exp(this.nzf.nextGaussian() * 0.25), 120.0, 420.0));
         this.silenceMovement();
      }
   }

   void okg(long var1) {
      if (this.obw) {
         if (this.getPlayer() == null || this.mc.currentScreen != null || this.nzb == nwx.ESCAPING || var1 - this.obz > 9000L) {
            this.okh();
         } else if (var1 >= this.oby && this.nzd - this.oca >= 1 && this.isMovementSilent()) {
            if (this.obx) {
               this.okh();
            } else {
               nwj var3 = this.oki();
               if (var3 == null) {
                  this.obx = true;
                  this.oby = var1 + (this.ocb == 0 ? 40L + this.nzf.nextInt(60) : this.okn());
               } else {
                  this.oko(var3.slot(), var3.button(), var3.type());
                  if (var3.type() == SlotActionType.THROW) {
                     this.ocq = this.nzd;
                  }

                  this.occ = var3.cursor();
                  this.ocb++;
                  nwj var4 = this.oki();
                  if (var4 == null) {
                     this.obx = true;
                     this.oby = var1 + this.okn();
                  } else {
                     this.oby = var1 + this.okm(okl(var3.cursor(), var4.cursor()));
                  }
               }
            }
         }
      }
   }

   void okh() {
      if (this.obw) {
         boolean var1 = this.ocb == 0;
         this.obw = false;
         this.obx = false;
         this.okp();
         this.ojf();
         this.ocd = var1 ? 40 : 10 + this.nzf.nextInt(20);
      }
   }

   nwj oki() {
      PlayerInventory var1 = this.getPlayer().getInventory();
      int var2 = this.occ != -1 ? this.occ : 13;
      int var3 = -1;
      double var4 = Double.MAX_VALUE;
      boolean var6 = this.okr();

      for (int var7 = 0; var7 < 36; var7++) {
         if (var6 && this.oqb(var1.getStack(var7))) {
            double var8 = okl(var2, var7);
            if (var8 < var4) {
               var4 = var8;
               var3 = var7;
            }
         }
      }

      if (var3 != -1) {
         return new nwj(var3, 1, SlotActionType.THROW, var3);
      }

      nwj var11 = this.okj();
      if (var11 != null) {
         return var11;
      }

      for (int var12 = 0; var12 < 9; var12++) {
         ItemStack var9 = var1.getStack(var12);
         if (!var9.isEmpty() && !this.oqd(var9)) {
            int var10 = this.okk(var2);
            if (var10 == -1) {
               return null;
            }

            return new nwj(var10, var12, SlotActionType.SWAP, var10);
         }
      }

      return null;
   }

   nwj okj() {
      PlayerInventory var1 = this.getPlayer().getInventory();
      int var2 = -1;
      if (this.oqi(var1x -> this.oqf(var1x, true)) == -1) {
         var2 = this.oqj(var1x -> this.oqf(var1x, true));
      }

      if (var2 == -1 && this.nyt.get() && this.oqi(var1x -> this.oqf(var1x, false)) == -1) {
         var2 = this.oqj(var1x -> this.oqf(var1x, false));
      }

      if (var2 == -1 && this.oqi(var0 -> var0.isOf(Items.GOLDEN_CARROT)) == -1) {
         var2 = this.oqj(var0 -> var0.isOf(Items.GOLDEN_CARROT));
      }

      if (var2 == -1) {
         return null;
      }

      int var3 = -1;

      for (int var4 = 0; var4 < 9 && var3 == -1; var4++) {
         if (var1.getStack(var4).isEmpty()) {
            var3 = var4;
         }
      }

      for (int var5 = 0; var5 < 9 && var3 == -1; var5++) {
         if (!this.oqd(var1.getStack(var5))) {
            var3 = var5;
         }
      }

      return var3 == -1 ? null : new nwj(var2, var3, SlotActionType.SWAP, var2);
   }

   int okk(int var1) {
      PlayerInventory var2 = this.getPlayer().getInventory();
      int var3 = -1;
      double var4 = Double.MAX_VALUE;

      for (int var6 = 9; var6 < 36; var6++) {
         if (var2.getStack(var6).isEmpty()) {
            double var7 = okl(var1, var6);
            if (var7 < var4) {
               var4 = var7;
               var3 = var6;
            }
         }
      }

      return var3;
   }

   static double okl(int var0, int var1) {
      double var2 = var0 < 9 ? 3.25 : (var0 - 9) / 9;
      double var4 = var0 < 9 ? var0 : (var0 - 9) % 9;
      double var6 = var1 < 9 ? 3.25 : (var1 - 9) / 9;
      double var8 = var1 < 9 ? var1 : (var1 - 9) % 9;
      return Math.hypot(var2 - var6, var4 - var8);
   }

   long okm(double var1) {
      double var3 = 95.0 * Math.exp(this.nzf.nextGaussian() * 0.25) + 28.0 * (Math.log(1.0 + var1) / Math.log(2.0));
      if (this.nzf.nextDouble() < 0.04) {
         var3 += 120.0 + this.nzf.nextDouble() * 180.0;
      }

      return Math.round(MathHelper.clamp(var3, 55.0, 520.0));
   }

   long okn() {
      return Math.round(MathHelper.clamp(150.0 * Math.exp(this.nzf.nextGaussian() * 0.3), 80.0, 420.0));
   }

   void oko(int var1, int var2, SlotActionType var3) {
      if (this.getInteractionManager() != null && this.getPlayer() != null) {
         int var4 = var1 < 9 ? var1 + 36 : var1;
         this.getInteractionManager().clickSlot(this.getPlayer().playerScreenHandler.syncId, var4, var2, var3, this.getPlayer());
         if (this.mc.currentScreen == null) {
            this.ocf = true;
         }
      }
   }

   void okp() {
      if (this.ocf) {
         this.ocf = false;
         if (this.mc.currentScreen == null && this.getPlayer() != null && this.getNetworkHandler() != null) {
            this.getNetworkHandler().sendPacket(new CloseHandledScreenC2SPacket(this.getPlayer().playerScreenHandler.syncId));
         }
      }
   }

   boolean okq() {
      return this.mc.currentScreen == null
         && !this.ocf
         && !this.obw
         && this.oaz == nwg.NONE
         && !this.mc.options.attackKey.isPressed()
         && !this.mc.options.useKey.isPressed()
         && !this.getPlayer().isUsingItem()
         && !this.getPlayer().isSpectator()
         && this.nzb != nwx.ESCAPING
         && this.nzd - this.ohl > 10
         && !this.ohb
         && !this.ond(System.currentTimeMillis())
         && this.okr();
   }

   boolean okr() {
      return this.oco <= 0 && this.nzd - this.oek >= 40 && this.opb()
         ? this.nzb == nwx.EXPLORING || this.nzb == nwx.RESTOCK || this.nzb == nwx.WAITING_FOR_CHEST && !this.oni()
         : false;
   }

   int oks() {
      PlayerInventory var1 = this.getPlayer().getInventory();
      int var2 = var1.getSelectedSlot();
      int var3 = -1;

      for (int var4 = 0; var4 < 9; var4++) {
         if (this.oqb(var1.getStack(var4)) && (var3 == -1 || Math.abs(var4 - var2) < Math.abs(var3 - var2))) {
            var3 = var4;
         }
      }

      return var3;
   }

   void okt(int var1) {
      this.oku();
      this.ocg = var1;
      boolean var2 = this.getPlayer().getInventory().getSelectedSlot() == var1;
      float var3 = this.nzf.nextFloat();
      this.och = var2 ? 0 : (var3 < 0.2F ? 0 : (var3 < 0.6F ? 1 : (var3 < 0.9F ? 2 : 3)));
      this.getPlayer().getInventory().setSelectedSlot(var1);
   }

   void oku() {
      this.ocg = -1;
      this.och = 0;
      this.ocj = false;
      this.ock = 0;
      this.ocl = 0;
   }

   boolean okv() {
      if (this.ocg == -1) {
         return false;
      }

      if (this.ocj) {
         if (this.ocl == 0 && ++this.ock <= 3) {
            return true;
         }

         boolean var4 = this.ocl > 0;
         this.oku();
         if (var4) {
            this.ocn++;
            this.oci = this.nzf.nextInt(3);
            this.ocq = this.nzd;
         } else {
            this.oci = 8 + this.nzf.nextInt(12);
         }

         return false;
      } else {
         PlayerInventory var1 = this.getPlayer().getInventory();
         if (this.okq() && this.oqb(var1.getStack(this.ocg)) && var1.getSelectedSlot() == this.ocg) {
            if (this.och-- > 0) {
               return true;
            }

            int var2 = this.ocg;
            int var3 = ++this.ocm;
            this.ocj = true;
            this.ock = 0;
            this.ocl = 0;
            ptr.later(() -> {
               boolean var3x = this.okw(var2, var3);
               if (var3 == this.ocm) {
                  this.ocl = var3x ? 1 : -1;
               }
            });
            return true;
         } else {
            this.oku();
            this.oci = 6 + this.nzf.nextInt(10);
            return false;
         }
      }
   }

   boolean okw(int var1, int var2) {
      ClientPlayerEntity var3 = this.mc.player;
      if (var2 == this.ocm && this.ocj && var3 != null && this.mc.currentScreen == null && !var3.isSpectator() && var3.getInventory().getSelectedSlot() == var1
         )
       {
         ItemStack var4 = var3.getMainHandStack();
         if (!this.oqb(var4)) {
            return false;
         }

         if (!var3.dropSelectedItem(var4.getCount() > 1)) {
            return false;
         }

         var3.swingHand(Hand.MAIN_HAND);
         return true;
      } else {
         return false;
      }
   }

   boolean okx() {
      boolean var1 = this.nzb == nwx.WARPING_TO_LOOT_BASE && this.oau && (this.omo() > 0 || this.omk());
      boolean var2 = this.nzb == nwx.EXPLORING || this.nzb == nwx.WAITING_FOR_CHEST || this.nzb == nwx.CHECK_PVP_COOLDOWN;
      if ((var1 || var2) && this.odl <= 0 && !this.ond(System.currentTimeMillis())) {
         int var3 = var1 ? 2400 : 600;
         boolean var4 = this.oky(true, var3);
         boolean var5 = this.nyt.get() && this.oky(false, var3);
         if (var4 || var5) {
            boolean var6 = var4;
            int var7 = this.oqi(var2x -> this.oqf(var2x, var6));
            if (var7 == -1) {
               if (this.ocd > 0) {
                  return false;
               }

               this.okf(System.currentTimeMillis());
               pqf.resetKeys();
               this.oot();
               return true;
            }

            if (this.odg != 0) {
               this.olf();
            }

            pqf.resetKeys();
            this.oot();
            if (this.getPlayer().getInventory().getSelectedSlot() != var7) {
               this.getPlayer().getInventory().setSelectedSlot(var7);
               this.olh();
               this.odk = 0;
               this.odj = true;
               return true;
            }

            this.odj = true;
            this.odk++;
            if (this.getPlayer().getInventory().getStack(var7).isOf(Items.POTION) || this.old(86.0F) && !(this.ogw < 78.0F)) {
               this.odm = var6 ? 0 : 1;
               this.odn = this.nzd;
               this.olg(true);
               if (!this.getPlayer().isUsingItem() && this.odk % 5 == 0) {
                  ptr.later(() -> {
                     if (this.mc.player != null && this.mc.interactionManager != null && !this.mc.player.isUsingItem()) {
                        this.mc.interactionManager.interactItem(this.mc.player, Hand.MAIN_HAND);
                     }
                  });
               }

               if (this.odk > 100) {
                  this.olh();
                  this.odk = 0;
                  this.odl = 100;
                  int var8 = var6 ? 0 : 1;
                  if (++this.ods[var8] >= 3) {
                     this.ola(var8);
                  }
               }

               return true;
            }

            this.olh();
            if (this.odk > 100) {
               this.odk = 0;
               this.odl = 100;
            }

            return true;
         }
      }

      if (this.odj) {
         this.odj = false;
         this.odk = 0;
         this.odm = -1;
         this.olh();
         if (!this.oqb(this.getPlayer().getMainHandStack())) {
            this.olj();
         }
      }

      return false;
   }

   boolean oky(boolean var1, int var2) {
      int var3 = var1 ? 0 : 1;
      if (!this.odt[var3] && this.odp[var3] <= 0 && this.oqg(var1) != 0) {
         int var4 = this.odr[var3] > 0 ? Math.min(var2, this.odr[var3] * 3 / 4) : var2;
         return this.olb(var1) < var4;
      } else {
         return false;
      }
   }

   void okz() {
      for (int var1 = 0; var1 < 2; var1++) {
         boolean var2 = var1 == 0;
         int var3 = this.oqg(var2);
         int var4 = this.olb(var2);
         if (this.odo[var1] >= 0 && var3 < this.odo[var1] && this.odm == var1 && this.nzd - this.odn <= 3) {
            this.odp[var1] = 60;
            this.odq[var1] = var4;
            this.ods[var1] = 0;
         }

         this.odo[var1] = var3;
         if (this.odp[var1] > 0) {
            if (var4 > this.odq[var1]) {
               this.odp[var1] = 0;
               this.odr[var1] = var4;
            } else if (--this.odp[var1] == 0) {
               this.ola(var1);
            }
         }
      }
   }

   void ola(int var1) {
      if (!this.odt[var1]) {
         this.odt[var1] = true;
         this.notifyUser(
            var1 == 0
               ? wap.s(
                  a.c(-2121146754, "\ude68\ua7e5ⴻ댏㢑븧Ѭ趂Ꮗ饬Ẵ\ue4ce樜\uf3a8秦：䔌쪍倡홫征◖ꭤ・뛃㰔薰௲酀\u175f鳭扳\ue879熋\uf7d8絪슻䣝칚埦\uddb4ꌋ⥙꺧㐽멎\u0380褦༬钲᫈\ue05f榼\ueff1甏ﭖ䂤옡䱎햞嬳ℱꚖⳁ눕㮽"),
                  a.b("뇄졗䊊\udc8c圢햆毈\ue231籩\uf6d2焍議֣鰐ᘼ郎⫻ꄲ㾜맅㐧䩢쓕式\ud975垺\uea64搼ﻋ磫\uf357\u0dfe蟃ᨢ鱼ᛀ괆❸ꆮ㡨눳첿䋹셕宊퇮氢\ue6e0悭２畳记٪耴᪻铨⭋ꦍ⏹멝㒑今줸", -893405716)
               )
               : wap.s(
                  a.c(-2105457530, "䓩㵤랺⦎ꈊⒸ黾ᜏ襑Τ萧繉\uf085椩\ue37c斌\udf8d倛쪮䳨씌뼘\u31e5ꨵⰅꚑἡ酰\u0b84跓ٷ\uf8f2犰\ueb4c浑\ue7e1塹퉅咔촸䝰㧄돘㑠껱⃔餛Ꭷ闠\u0e7c聛窖\uf320畫\uefcb懎\uda77岽훗"),
                  a.b("ኪ欹\ue1e4翢\uf44c盨죚䅐\udf0b嗄퉩⡧ꚳ㽸넳㏟覘ɜ鳻\u1aae鍒\ue906掫ﰗ穡\uf0b0䥲윬嶣\udb80吣\uaaff₽뵝㬁놵ต葠ˎ齪ᄨ濑\ue197戹\uf89d目쭓䗰잭堑홭Ⳁꕵ✸맜㞊豀૪肓\u1943", 1693783681)
               ),
            false
         );
      }
   }

   int olb(boolean var1) {
      StatusEffectInstance var2 = this.getPlayer().getStatusEffect(var1 ? StatusEffects.INVISIBILITY : StatusEffects.SPEED);
      return var2 == null ? 0 : (var2.isInfinite() ? Integer.MAX_VALUE : var2.getDuration());
   }

   boolean olc() {
      boolean var1 = this.getPlayer().getHungerManager().getFoodLevel() < 14;
      int var2 = this.oqi(var0 -> var0.isOf(Items.GOLDEN_CARROT));
      boolean var3 = this.opb();
      if (this.odg == 0) {
         if (!var1 || var2 == -1) {
            if (this.mc.options.useKey.isPressed() && !this.ohk) {
               this.olh();
               if (this.getPlayer().getMainHandStack().isOf(Items.GOLDEN_CARROT)) {
                  this.olj();
               }
            }

            return false;
         }

         this.odh = this.ogl.intentPitch();
         this.odg = var3 ? 2 : 1;
         this.odi = 0;
      }

      if (this.odg != 3 && (!var1 || var2 == -1)) {
         this.olh();
         this.odg = var3 ? 0 : 3;
         if (this.odg == 0) {
            this.olj();
            return false;
         }
      }

      switch (this.odg) {
         case 1:
            this.olh();
            if (var3 || this.old(-55.0F)) {
               this.odg = 2;
               this.odi = 0;
            }
            break;
         case 2:
            if (!var3) {
               this.old(-55.0F);
            }

            this.getPlayer().getInventory().setSelectedSlot(var2);
            this.olg(!var3);
            if (++this.odi > 200) {
               this.olh();
               this.odg = 3;
            }
            break;
         case 3:
            this.olh();
            if (var3 || this.old(this.odh)) {
               this.odg = 0;
               this.olj();
               return false;
            }
      }

      return true;
   }

   boolean old(float var1) {
      this.oom(this.ogo ? this.ogs : this.ogl.intentYaw(), var1);
      return Math.abs(this.ogl.intentPitch() - var1) <= 0.75F;
   }

   void ole() {
      if (this.opb()) {
         this.opq();
         pyd.setSprint(this.mc.options, false);
         this.mc.options.jumpKey.setPressed(false);
      } else {
         pqf.resetKeys();
         this.oot();
      }
   }

   void olf() {
      this.olh();
      this.odg = 0;
      this.odi = 0;
   }

   void olg(boolean var1) {
      this.mc.options.sneakKey.setPressed(var1);
      this.mc.options.useKey.setPressed(true);
      ptr.miss();
   }

   void olh() {
      if (this.mc.options != null) {
         this.mc.options.useKey.setPressed(false);
         this.mc.options.sneakKey.setPressed(false);
      }
   }

   boolean oli(ItemStack var1) {
      return !var1.isEmpty() && (var1.isOf(Items.GOLDEN_CARROT) || this.oqf(var1, true) || this.oqf(var1, false));
   }

   void olj() {
      PlayerInventory var1 = this.getPlayer().getInventory();

      for (int var2 = 0; var2 < 9; var2++) {
         if (var1.getStack(var2).isEmpty()) {
            var1.setSelectedSlot(var2);
            return;
         }
      }

      for (int var3 = 0; var3 < 9; var3++) {
         if (!this.oli(var1.getStack(var3))) {
            var1.setSelectedSlot(var3);
            return;
         }
      }
   }

   void olk(long var1) {
      this.odj = false;
      if (!this.oai && this.oqg(true) == 1) {
         this.oai = true;
      }

      if (this.nyt.get()) {
         if (!this.oaj && this.oqg(false) == 1) {
            this.oaj = true;
         }
      } else {
         this.oaj = true;
      }

      if (!this.oah && this.oqh(Items.GOLDEN_CARROT) == this.oal) {
         this.oah = true;
      }

      if (this.oag && this.oah && this.oai && this.oaj) {
         if (this.oqg(true) != 0 || this.olb(true) >= 2400 && this.olp(a.c(196441258, "炗ण菿ᶄ陜"), a.d("槸၁骕Ӯ輵ঈ돟", 1353270919, -624219323)) == null) {
            this.ody = false;
            if (this.ome()) {
               pqf.resetKeys();
               this.oou();
            } else {
               this.ohy(nwx.TELEPORT_TO_LOOT);
            }
         } else {
            if (!this.ody) {
               this.ody = true;
               this.notifyUser(a.b("\uf46b跲ݖ鵅\u128f鐶\u2e62ꞙ㧊덷㒠컓䁻\ud9c9叠턉潛\ue087縤ﱤ疒࿄腵ằ飃ሟ꾺⇩뭻㵇", -337383320), false);
            }

            this.oai = false;
            this.oao = 600;
         }
      } else {
         if (this.oam != null && this.nzd - this.ocw > 400) {
            this.oam = null;
            this.ofb = null;
            this.oao = 40;
            this.oln();
         }

         if (this.oam == null) {
            if (this.oao > 0) {
               pqf.resetKeys();
               this.oou();
            } else {
               nwg var5 = !this.oag ? nwg.DUMP : this.oll();

               BlockPos var4 = switch (var5) {
                  case DUMP -> this.olp(a.b("\uf4e6货ޅ馊ሢ", -154144606));
                  case FOOD -> this.olp(a.d("丑㞡뵶", 670375888, 1650808311));
                  case INVIS -> this.olp(a.c(616551291, "흆껲\u242e멕ㆍ"), a.d("\ude3aꞃⵗ댬㣷빊Н", -259859738, -1391722266));
                  default -> this.olp(a.b("함겢♵롺㏓딝ཌྷ", -398667474));
               };
               if (var4 == null) {
                  this.oao = 10;
                  if (var5 != nwg.DUMP && this.olp(a.b("柈ḉ钫ત脌", 2090689420)) != null) {
                     switch (var5) {
                        case FOOD:
                           this.oah = true;
                           break;
                        case INVIS:
                           this.oai = true;
                           break;
                        default:
                           this.oaj = true;
                     }
                  }

                  pqf.resetKeys();
                  this.oou();
               } else {
                  this.oam = var4;
                  this.oan = var5;
                  this.ocw = this.nzd;
                  this.oaq = 0;
                  this.nzy = 0;
                  this.oov();
                  this.opc(var4, true);
               }
            }
         } else {
            if (!this.olo(this.oam)) {
               if (!this.opb()) {
                  this.opc(this.oam, false);
               }

               if (this.opb()) {
                  this.opq();
                  return;
               }
            }

            this.ofb = null;
            pqf.resetKeys();
            Vec3d var3 = this.onl(this.oam);
            if (var3 == null) {
               if (this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(this.oam)) > 16.0) {
                  this.opc(this.oam, false);
               }

               var3 = Vec3d.ofCenter(this.oam);
            }

            this.ooq(this.oam, var3);
            this.ono(this.oam, this.oan, var1);
            if (this.nzy > 6) {
               this.nzy = 0;
               this.oam = null;
               this.oao = 40;
               this.oln();
            }
         }
      }
   }

   nwg oll() {
      for (nwg var2 : this.oak) {
         if (var2 == nwg.FOOD && !this.oah) {
            return var2;
         }

         if (var2 == nwg.INVIS && !this.oai) {
            return var2;
         }

         if (var2 == nwg.SPEED && !this.oaj) {
            return var2;
         }
      }

      return nwg.SPEED;
   }

   void olm() {
      Collections.shuffle(this.oak, this.nzf);
      this.oal = 3;
      this.ocv = 4.0F + this.nzf.nextFloat() * 14.0F;
   }

   void oln() {
      if (++this.oap >= 3) {
         this.oap = 0;
         switch (this.oan) {
            case DUMP:
               this.oag = true;
               break;
            case FOOD:
               this.oah = true;
               break;
            case INVIS:
               this.oai = true;
               break;
            case SPEED:
               this.oaj = true;
         }
      }
   }

   boolean olo(BlockPos var1) {
      return this.getPlayer().isOnGround() && this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= 12.0 && this.onl(var1) != null;
   }

   BlockPos olp(String... var1) {
      return this.getWorld() != null && this.getPlayer() != null ? pte.find(this.mc, this.getPlayer().getBlockPos(), var1) : null;
   }

   boolean olq(BlockPos var1) {
      return this.getWorld() != null && this.getWorld().getBlockState(var1).getBlock() instanceof ChestBlock;
   }

   String olr() {
      String var1 = this.nyv.get();
      String[] var2 = var1 == null ? new String[0] : var1.trim().split(a.b("\ue40b鷍ᝮ褰ˉ萎", 875422806));
      if (var2.length != 0 && !var2[0].isEmpty()) {
         if (this.nze >= var2.length) {
            this.nze = 0;
         }

         return var2[this.nze];
      } else {
         return a.c(-898335051, "绑ݯ跠᎐額");
      }
   }

   static String ols(String var0, String var1) {
      String var2 = var0 == null ? "" : var0.trim();

      while (var2.startsWith(a.c(-690656584, "檖"))) {
         var2 = var2.substring(1).trim();
      }

      return var2.isEmpty() ? var1 : var2;
   }

   String olt() {
      if (a.d("뛟콘䖘\udbeb", -1694636612, 1880576816).equals(this.nyw.get())) {
         String var1 = ols(this.nyy.get(), a.c(-1452440530, "葟ﷸ眸\ue95f抉\ue433"));
         if (var1.toLowerCase().startsWith(a.c(-27186685, "⩱取\ud916䝥쳢"))) {
            var1 = var1.substring(5).trim();
         }

         return a.b("ꋗ\udb70冰쿃䑄", 65643173) + (var1.isEmpty() ? a.c(-1164931064, "遹\ue9de挞ﵹ皯\uf015") : var1);
      } else {
         return this.olu();
      }
   }

   String olu() {
      String var1 = ols(this.nyx.get(), a.b("ᗕ汲\ue6b2磕\uf303疹", 2059933092));
      if (var1.toLowerCase().startsWith(a.d("⡮凘\udb09䕰컢", 1742183438, 705541133))) {
         var1 = var1.substring(5).trim();
      }

      return a.b("ᔐ沦\ue677砎\uf39c", -1888610947) + (var1.isEmpty() ? a.c(-566673034, "䄇㢠뉠ⰇꟑⅫ") : var1);
   }

   void olv() {
      this.oas = 0;
      this.oau = false;
      this.oav = false;
      this.ocx = 0;
      this.oaw = null;
      this.oax = 0;
      this.oay = 0;
      this.oat = this.nzf.nextInt(25);
      this.ofb = null;
      this.ofc = 0;
      this.ohx();
      this.oab = null;
      this.oia();
      this.ocz = this.getWorld();
      this.oda = this.getPlayer();
      this.odb = this.getPlayer() == null ? null : this.getPlayer().getEntityPos();
      this.odc = -1;
      this.odd = false;
      this.oeb = false;
      this.oec = null;
      this.oed = null;
   }

   String[] olw() {
      String var1 = this.nyv.get();
      String[] var2 = var1 == null ? new String[0] : var1.trim().split(a.c(-946926314, "ോ璍︮恰\ueb89济"));
      return var2.length != 0 && !var2[0].isEmpty() ? var2 : new String[]{a.c(505358758, "⧂偼\udaf3䒃콞")};
   }

   void olx() {
      pqf.resetKeys();
      String[] var1 = this.olw();

      for (int var2 = 0; var2 < var1.length; var2++) {
         int var3 = (this.nze + var2) % var1.length;
         if (pjd.hasRoom(var1[var3], this.ohu())) {
            this.nze = var3;
            break;
         }
      }

      String var4 = ols(this.olr(), a.d("艝ﯣ煬\uef1c擁", 187058704, -962017239));
      if (!pjd.enter(this.ohu(), var4)) {
         this.oly(a.c(-1412527208, "辩\uf64b糬\ue688楏\ueff3喧\udc54䘓좹伒땢㯇Ꙧ⠢껔ᒖ鬵Ƌ蟓\u0a4f瀓ﺭ慪\ue717涣푽帰샙䛱촰㎔릮⁞ꘁ"), false);
      } else {
         this.odf = "";
         this.getNetworkHandler().sendChatCommand(var4);
         this.olv();
         this.ogi++;
         this.nzg = 0;
         this.nzi.clear();
         this.nzj.clear();
         this.nzk.clear();
         this.nzl.clear();
         this.ohy(nwx.WARPING_TO_LOOT_BASE);
      }
   }

   void oly(String var1, boolean var2) {
      int var3 = pjd.position(this.ohu());
      this.odf = wap.t(var1)
         + (
            var3 > 0
               ? wap.s(a.b("ડ猘燎", -2143942014) + var3 + a.b("ꔁ", -1158306519), a.b("㩿䏆", 1584609885) + var3 + a.d("赈\uf0ed縮", 288367060, -1031230286))
               : ""
         );
      if (this.nzd - this.ode > 600) {
         this.ode = this.nzd;
         this.notifyUser(this.odf, false);
      }

      if (var2) {
         this.oog();
      } else {
         pqf.resetKeys();
         this.oou();
      }
   }

   void olz() {
      pqf.resetKeys();
      this.oot();
      this.omh();
      this.oas++;
      if (!this.oau) {
         if (this.odc >= 0) {
            if (this.oas - this.odc >= 30 + this.oat) {
               if (this.omg() || this.omc()) {
                  this.omb();
               } else if (this.ocx >= 3) {
                  this.oma();
               } else {
                  this.omi(this.olt());
               }
            }
         } else {
            if (this.omf() || this.oas >= 200) {
               this.odc = this.oas;
               this.oeb = this.omf();
            }
         }
      } else if (this.getWorld() != this.ocy && !this.oeb) {
         this.oeb = true;
         this.oau = false;
         this.odc = this.oas;
         this.oay = 0;
         this.oec = null;
         this.oed = null;
      } else if (this.omo() > 0) {
         this.oay = 0;
      } else if (!this.omk() && !this.omg() && !this.omc()) {
         if (this.oas - this.oax >= 200) {
            if (this.ocx < 3) {
               this.omi(this.olt());
            } else {
               this.oma();
            }
         }
      } else {
         if (++this.oay >= 30) {
            this.omb();
         }
      }
   }

   void oma() {
      this.notifyUser(a.c(547284444, "\ue1f1顨ᚮ貽ܝ膢㯿누ⱚꚕ⅄\udb4f嗠찯䙰삃竇\uf513殾\ue9fd搘ᩚ铤ཋ襊Α븶なꪐ⣞ꌒ嶽\ud7fd乾졛䋣廊睍\uf1ea桘\ue277鳶ᚨ長ர藌㰘뛐"), false);
      this.omd(wap.t(a.b("⼊嚓\ud855䉆짦余\uf504糿\ue2a1桮\uefbfᖴ鬛˔袋\u0e78됼㯨ꕅ✆ꫣ풡娟솰䞱쵪烍ﺑ摫\ue625淩鍆ᤆ肅ڠ谘㟓릶㼑ꚣⲌ刍\ud853完앋䬷\uf2e3砫", -1839060185)));
      this.nze++;
      this.ohy(nwx.TELEPORT_TO_SAVE);
   }

   void omb() {
      BlockPos var1 = this.omc() ? this.odz.get(pjd.key(this.olr())) : null;
      this.nzh = var1 != null ? var1 : this.getPlayer().getBlockPos();
      this.oaa = 0;
      this.oay = 0;
      this.ohy(nwx.EXPLORING);
   }

   boolean omc() {
      String var1 = pjd.key(this.olr());
      BlockPos var2 = this.odz.get(var1);
      double var3 = 100.0;
      return var2 != null && this.oij().equals(this.oea.get(var1)) && this.getPlayer().getBlockPos().getSquaredDistance(var2) < var3 * var3;
   }

   void omd(String var1) {
      this.odv++;
      this.odw = var1;
   }

   boolean ome() {
      if (this.odv < 3) {
         return false;
      }

      if (!this.odx) {
         this.notifyUser(
            wap.s(
               a.b("\u2454巂휊䥤슳䐗﹅矪\ue9af", 1370235918)
                  + this.odv
                  + a.b("瞿๚蒏\u1ae5鄫យ궙␡멹ゆ뜔䴤쎡娍큆因\uecec挿呂翙\uf66b豸ˈ餛Ὤ闶Ⱂꉝ㢷뻺㔁쮞䇐\ud83a幵퓅欕\ue16d柹﹀", -345278537)
                  + this.odw
                  + a.b(
                     "\u19ce恸\ueaa5璷ｋ秷쎢䩛푏庪\ud965⌙궋㑪븦㣌芞\u0d49韻ᆷ頟\ue242沥\uf768焚ﮎ䉪찭囉킚孹ꖧ\u2fe7뙞《몹զ轒ী遾ᨫ撞\uee99椴\uf3ee線쑈件좶却\udd16⟌깺⠧닂㳌蝿Ǻ讕\u1249鳵\ue6ea慍\ueb1d痕ﱸ䙥생䪗핲忮\ud99e\u200f\uaaff㒪뽝㤂莴",
                     1007360425
                  ),
               a.c(-22107395, "껯휁巑쏒䠈캺瓥ﴝ捌\ue9f5模遊")
                  + this.odv
                  + a.c(1851661904, "Ṩ揎\ue91a眞ﲲ稉쁞䶿\ud7ff嵏\uda96ₓ깋㞁맆㬥腧໊鑻ሩ鯟\ue183歞\uf087")
                  + this.odw
                  + a.d("騭\ue39b楆\uf308碀﹏䐐췦双\ud971嫎꒨⩽돂㧦뼔ĸ軥၄阗ᾐ斾\uef12瓌\uf2bc簈엀䮓핸圱\ud89a≛ꠙ\u31e5럆㵲苘ࢩ詢់馌\ue36f椴\uee84琦艹䏲쵛併퓘媨ꁵ⧀", -563519013, 606534634)
            ),
            false
         );
         this.odx = true;
      }

      return true;
   }

   boolean omf() {
      ClientPlayerEntity var1 = this.getPlayer();
      return this.odd || this.getWorld() != this.ocz || var1 != this.oda || this.odb != null && var1.getEntityPos().distanceTo(this.odb) > 48.0;
   }

   boolean omg() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 != null && this.getWorld() != null) {
         rzy var2 = this.ohz();
         if (var2 != null) {
            String var3 = this.oij();
            Vec3d var4 = var1.getEntityPos();

            for (rzv var6 : var2.getCachedTimers()) {
               if (!var6.untimed && var3.equals(var6.dimension) && var6.pos.squaredDistanceTo(var4) < 10000.0) {
                  return true;
               }
            }
         }

         return this.omv(2).size() >= 4 && pte.find(this.mc, var1.getBlockPos(), 24, 8, a.b("髌\ue30d榯\uf7a0簈", -1748722040)) == null;
      } else {
         return false;
      }
   }

   void omh() {
      if (pqf.onClimbable(this.getPlayer()) && this.mc.options != null) {
         this.mc.options.sneakKey.setPressed(true);
      }
   }

   void omi(String var1) {
      this.getNetworkHandler().sendChatCommand(var1);
      this.oau = true;
      this.ocx++;
      this.oaw = this.getPlayer().getBlockPos();
      this.ocy = this.getWorld();
      this.oax = this.oas;
      this.oay = 0;
      if (this.oec == null) {
         this.oec = this.oaw;
         this.oed = this.ocy;
      }
   }

   boolean omj() {
      return this.oaw != null && this.getPlayer().getBlockPos().getSquaredDistance(this.oaw) > 9.0;
   }

   boolean omk() {
      return this.oec != null && (this.getWorld() != this.oed || this.getPlayer().getBlockPos().getSquaredDistance(this.oec) > 576.0);
   }

   void oml(String var1) {
      if (this.odu == null) {
         this.odu = var1 == null ? "" : var1;
         if (var1 != null) {
            this.notifyUser(var1, true);
            if (this.nzg == 0
               && (
                  a.b("鼫\ue6b2氖\uf605秏ｶ䔢쳙劊\ud837忠ꖓ⬻늉㢠멉\u000b迗ᅹ霥᫂擲\uea35燨\uf79c", -517629137).equals(var1)
                     || a.d("鷇\ue45e滺\uf4e9笫ﶛ䞷쨭呿\udec3崍ꝱⶶ끦㩁벼۸", 1084513386, 1839646113).equals(var1)
               )) {
               this.omd(wap.t(var1));
            }
         }
      }

      this.ohx();
      this.oab = null;
      this.oeu = null;
      this.ofb = null;
      this.ofc = 0;
      this.ohy(nwx.CHECK_PVP_COOLDOWN);
   }

   void omm() {
      String var1 = ols(this.nyu.get(), a.c(-1081936808, "\uf43c趂܍饽ኡ"));
      if (!pjd.enter(this.ohu(), var1)) {
         this.oly(a.c(37602478, "삐뤌㟏귟♼ꃁ᪙鍯थ蟷Q﨣烡\ue943挃\ue1ef宭퐄仇죫䕹㼥놛⹜ꠡ⊕魋ᄆ迯ে舆粢\uf698潨\ue937"), this.nzh != null);
      } else {
         this.odf = "";
         pqf.resetKeys();
         this.getNetworkHandler().sendChatCommand(var1);
         this.olv();
         this.ohw();
         this.oam = null;
         this.oap = 0;
         this.oeu = null;
         this.ohy(nwx.WARPING_TO_SAVE_BASE);
      }
   }

   void omn() {
      pqf.resetKeys();
      this.oot();
      this.omh();
      this.oas++;
      if (this.omo() > 0) {
         this.oay = 0;
      } else if (this.oas >= 60) {
         if (!this.oau) {
            if (this.olp(a.b("ᠧ懦\ueb44畋ﻣ", 1358765155)) != null) {
               this.ohy(nwx.RESTOCK);
            } else if (this.oas >= 80 + this.oat) {
               this.omi(this.olu());
            }
         } else if (this.omj() || this.oas - this.oax >= 200) {
            if (++this.oay >= 30) {
               this.ohy(nwx.RESTOCK);
            }
         }
      }
   }

   int omo() {
      return pjn.teleportSeconds(this.mc, a.d("薠ﰆ盛\ue8a4捹\ue5c9忤혗䠺싽䕐뽖㗮꠸∙꒝ầ酴࿊", -536219444, -1095208611));
   }

   boolean omp() {
      return pjn.contains(this.mc, a.b("ⰼ喫\udf5e䅒컨䠬\uf27c箃\ue5d8歵\ue8b6ው鱢֩述आ덁", 1341402237));
   }

   void omq(long var1) {
      if (this.nzh == null) {
         this.nzh = this.getPlayer().getBlockPos();
      }

      if (this.odu != null) {
         this.oml(null);
      } else if (this.oql() < 2) {
         this.oml(a.c(-458030342, "ۻ罯\uf5b3毅\ue01a曔\udcf5啴쬧䗺옶㱆는⬠ꅰ⎜駞ᘂ袬\u0ef0茗ﴧ珠\ue83d湉"));
      } else if (this.nzg >= this.nyq.get()) {
         this.oml(a.b("\uec6d閾ἓ腫ો调㙒뮻ↅꭋⲗ횗堰소䮩줳獱ﲭ戃\ue45f榸ឈ饏ʒ蓦", -1627592619));
      } else if (this.olb(true) >= 100 || this.oqg(true) != 0 && !this.odt[0]) {
         if (this.getPlayer().getHungerManager().getFoodLevel() < 8 && this.oqh(Items.GOLDEN_CARROT) == 0) {
            this.oml(a.b("\u2fdd噄\udce0䛳줱侁\uf5ad砷\ue665泙\uef17ᕫ龬ɼ衛\u0ea6듢", -2085344303));
         } else {
            if (this.oaa <= 0) {
               this.oaa = 5;
               nwq var3 = this.omw(var1);
               if (var3 != null) {
                  this.omr(var3);
                  this.ohy(nwx.WAITING_FOR_CHEST);
                  return;
               }
            }

            this.oms(var1);
         }
      } else {
         this.oml(a.b("瀨\u09b1茕ᤆ雌ၵꨡ⏚붉㜴냣䪐쐸嶊힣啊\uef08惔ﹺ砦\uf5c1诱Զ黫ᢟ", 244085804));
      }
   }

   void omr(nwq var1) {
      this.ohx();
      this.nzt = var1.timer();
      this.nzu = var1.chest();
      this.nzv = var1.tier();
      this.oab = null;
      this.ofb = null;
      this.ofc = 0;
      this.oaq = 0;
      this.oov();
   }

   void oms(long var1) {
      if (this.oab != null) {
         double var3 = this.getPlayer().getBlockPos().getSquaredDistance(this.oab);
         if (!this.olq(this.oab) || var3 <= 144.0) {
            this.omt();
            this.oab = null;
            this.ofb = null;
         }
      }

      if (this.oab == null && this.oac <= 0) {
         this.oac = 20;
         this.omu(var1);
      }

      if (this.oab != null) {
         if (!this.opb() && !this.opc(this.oab, false) && this.ofd <= 0) {
            this.nzl.put(this.oab, var1 + 60000L);
            this.oab = null;
         }

         if (this.opb()) {
            this.opq();
         } else {
            pqf.resetKeys();
            this.oot();
         }
      } else {
         this.opi();
      }
   }

   void omt() {
      BlockPos var1 = this.getPlayer().getBlockPos();

      for (BlockPos var3 : this.omv(1)) {
         if (var3.getSquaredDistance(var1) <= 196.0) {
            this.nzk.add(var3);
         }
      }
   }

   void omu(long var1) {
      BlockPos var3 = this.getPlayer().getBlockPos();
      this.omt();
      ArrayList<BlockPos> var4 = new ArrayList<>();

      for (BlockPos var6 : this.omv(4)) {
         if (!this.nzk.contains(var6)) {
            Long var7 = this.nzl.get(var6);
            if ((var7 == null || var7 <= var1) && (this.nzh == null || !(var6.getSquaredDistance(this.nzh) > 14400.0)) && !this.ont(var6, 7.0)) {
               var4.add(var6);
            }
         }
      }

      if (!var4.isEmpty()) {
         var4.sort((var1x, var2) -> Double.compare(var1x.getSquaredDistance(var3), var2.getSquaredDistance(var3)));

         for (int var8 = 0; var8 < Math.min(2, var4.size()); var8++) {
            BlockPos var9 = (BlockPos)var4.get(var8);
            List var10 = this.opd(var9);
            if (var10 != null && !var10.isEmpty()) {
               this.oab = var9;
               this.opf(var10);
               return;
            }

            this.nzl.put(var9, var1 + 60000L);
         }
      }
   }

   List<BlockPos> omv(int var1) {
      ArrayList var2 = new ArrayList();
      if (this.mc.world == null) {
         return var2;
      }

      BlockPos var3 = this.getPlayer().getBlockPos();
      int var4 = var3.getX() >> 4;
      int var5 = var3.getZ() >> 4;

      for (int var6 = -var1; var6 <= var1; var6++) {
         for (int var7 = -var1; var7 <= var1; var7++) {
            WorldChunk var8 = this.mc.world.getChunkManager().getWorldChunk(var4 + var6, var5 + var7, false);
            if (var8 != null) {
               for (BlockEntity var10 : var8.getBlockEntities().values()) {
                  if (var10 instanceof ChestBlockEntity && Math.abs(var10.getPos().getY() - var3.getY()) <= 16) {
                     var2.add(var10.getPos());
                  }
               }
            }
         }
      }

      return var2;
   }

   nwq omw(long var1) {
      rzy var3 = this.ohz();
      if (var3 == null) {
         return null;
      }

      String var4 = this.oij();
      Vec3d var5 = this.getPlayer().getEyePos();
      nwq var6 = null;

      for (rzv var8 : var3.getCachedTimers()) {
         if (var4.equals(var8.dimension)) {
            BlockPos var9 = this.onc(var8);
            if (var9 != null) {
               Long var10 = this.nzj.get(var9);
               if (var10 == null || var10 <= var1) {
                  Long var11 = this.nzi.get(var9);
                  if ((var11 == null || var8.lastNumericUpdate > var11 + 1500L) && (this.nzh == null || !(var9.getSquaredDistance(this.nzh) > 14400.0))) {
                     long var12 = omx(var8, var1);
                     boolean var14 = var12 <= 0L;
                     double var15 = var5.squaredDistanceTo(Vec3d.ofCenter(var9));
                     byte var17;
                     if (var14 && var15 <= 25.0) {
                        var17 = 0;
                     } else if (!var14 && var12 <= 5000L && var15 <= 144.0) {
                        var17 = 1;
                     } else if (var14 && var15 <= 144.0) {
                        var17 = 2;
                     } else if (!var14 && var12 <= 15000L && var15 <= 625.0) {
                        var17 = 3;
                     } else if (var14) {
                        var17 = 4;
                     } else {
                        if (var12 > 30000L) {
                           continue;
                        }

                        var17 = 5;
                     }

                     if (!this.ont(var9, 7.0) && !this.onv(var9)) {
                        double var18 = var9.getY() + 0.5 - var5.y;
                        double var20 = var9.getX() + 0.5 - this.getPlayer().getX();
                        double var22 = var9.getZ() + 0.5 - this.getPlayer().getZ();
                        double var24 = var20 * var20 + var22 * var22 + (var18 > 0.0 ? 2.0 : 1.0) * var18 * var18;
                        if (var6 == null || var17 < var6.tier() || var17 == var6.tier() && var24 < var6.score()) {
                           var6 = new nwq(var8, var9, var17, var24);
                        }
                     }
                  }
               }
            }
         }
      }

      if (var6 != null && this.onj(var6.chest()) == null) {
         this.nzj.put(var6.chest(), var1 + 20000L);
         return null;
      } else {
         return var6;
      }
   }

   static long omx(rzv var0, long var1) {
      return var0.isReady ? -1L : var0.expirationTime - var1;
   }

   void omy(long var1) {
      rzy var3 = this.ohz();
      if (var3 != null && this.nzn != 0L && var1 - this.nzn >= 3000L) {
         String var4 = this.oij();
         HashSet var5 = new HashSet();

         for (rzv var7 : var3.getCachedTimers()) {
            if (!var7.untimed && var4.equals(var7.dimension)) {
               BlockPos var8 = this.onc(var7);
               if (var8 != null) {
                  var5.add(var8);
                  BlockPos var9 = this.ona(var8);
                  if (var9 != null) {
                     var5.add(var9);
                  }
               }
            }
         }

         var3.getCachedTimers().removeIf(var3x -> {
            if (var3x.untimed && var4.equals(var3x.dimension)) {
               BlockPos var4x = this.onc(var3x);
               return var4x == null || var5.contains(var4x);
            } else {
               return false;
            }
         });
         Vec3d var15 = this.getPlayer().getEyePos();
         double var16 = 196.0;
         HashSet var17 = new HashSet();

         for (BlockPos var11 : this.omv(1)) {
            if (!(var15.squaredDistanceTo(Vec3d.ofCenter(var11)) > var16) && !var5.contains(var11)) {
               BlockPos var12 = this.onb(var11);
               if (var17.add(var12)) {
                  long var13 = this.nzm.computeIfAbsent(var12, var2 -> var1);
                  if (var1 - var13 >= 250L && !this.omz(var12, var1) && (this.nzh == null || !(var12.getSquaredDistance(this.nzh) > 14400.0))) {
                     var3.markUntimedReady(var12, var4);
                  }
               }
            }
         }

         this.nzm.keySet().retainAll(var17);
      }
   }

   boolean omz(BlockPos var1, long var2) {
      Long var4 = this.nzi.get(var1);
      if (var4 != null && var2 - var4 < 600000L) {
         return true;
      }

      BlockPos var5 = this.ona(var1);
      Long var6 = var5 == null ? null : this.nzi.get(var5);
      return var6 != null && var2 - var6 < 600000L;
   }

   BlockPos ona(BlockPos var1) {
      if (this.getWorld() == null) {
         return null;
      } else {
         BlockState var2 = this.getWorld().getBlockState(var1);
         if (var2.getBlock() instanceof ChestBlock && var2.get(ChestBlock.CHEST_TYPE) != ChestType.SINGLE) {
            BlockPos var3 = var1.offset(ChestBlock.getFacing(var2));
            return this.olq(var3) ? var3 : null;
         } else {
            return null;
         }
      }
   }

   BlockPos onb(BlockPos var1) {
      BlockPos var2 = this.ona(var1);
      if (var2 == null) {
         return var1;
      } else {
         return var2.asLong() < var1.asLong() ? var2 : var1;
      }
   }

   BlockPos onc(rzv var1) {
      BlockPos var2 = BlockPos.ofFloored(var1.pos.x, var1.pos.y, var1.pos.z);

      for (int var3 = 0; var3 >= -3; var3--) {
         if (this.olq(var2.add(0, var3, 0))) {
            return var2.add(0, var3, 0);
         }

         for (int var4 = -1; var4 <= 1; var4++) {
            for (int var5 = -1; var5 <= 1; var5++) {
               BlockPos var6 = var2.add(var4, var3, var5);
               if (this.olq(var6)) {
                  return var6;
               }
            }
         }
      }

      return null;
   }

   boolean ond(long var1) {
      return this.nzb == nwx.WAITING_FOR_CHEST && this.nzt != null && omx(this.nzt, var1) < 3500L && this.nzw != null && this.oni();
   }

   void one(long var1) {
      rzy var3 = this.ohz();
      rzv var4 = this.nzt;
      BlockPos var5 = this.nzu;
      if (var4 != null && var5 != null && var3 != null && var3.getCachedTimers().contains(var4) && this.olq(var5)) {
         long var6 = omx(var4, var1);
         if (var6 > 31000L) {
            this.nzi.put(var5, var1);
            this.ohx();
            this.ohy(nwx.EXPLORING);
         } else if (!this.ont(var5, 7.0) && !this.onv(var5)) {
            if (this.oaa <= 0 && var6 > 4000L) {
               this.oaa = 10;
               nwq var8 = this.omw(var1);
               if (var8 != null && !var8.chest().equals(var5) && var8.tier() < this.nzv) {
                  this.omr(var8);
                  return;
               }
            }

            if (this.nzw == null || !this.onk(this.nzw)) {
               this.nzw = this.onj(var5);
               this.ofb = null;
               if (this.nzw == null) {
                  this.nzj.put(var5, var1 + 20000L);
                  this.ohx();
                  this.ohy(nwx.EXPLORING);
                  return;
               }
            }

            if (!this.oni()) {
               this.ong(var5, var1);
            } else {
               this.nzx = 0;
               this.ofb = null;
               this.ofc = 0;
               pqf.resetKeys();
               Vec3d var10 = this.onl(var5);
               if (var10 == null) {
                  this.nzw = null;
               } else {
                  boolean var9 = this.onf(var4, var6, var1);
                  if (!var9 && var6 > 2500L) {
                     if (!this.onh()) {
                        this.oop(var10);
                     }
                  } else {
                     this.oad = 0;
                     if (this.oli(this.getPlayer().getMainHandStack())) {
                        this.olj();
                     }

                     this.ooq(var5, var10);
                     if (var9) {
                        this.ono(var5, nwg.LOOT, var1);
                        if (this.nzy > 4) {
                           this.nzj.put(var5, var1 + (var4.untimed ? 180000L : 25000L));
                           this.ohx();
                           this.ohy(nwx.EXPLORING);
                        }
                     }
                  }
               }
            }
         } else {
            this.nzj.put(var5, var1 + 20000L);
            this.ohx();
            this.ohy(nwx.EXPLORING);
         }
      } else {
         this.ohx();
         this.ohy(nwx.EXPLORING);
      }
   }

   boolean onf(rzv var1, long var2, long var4) {
      if (var2 > 1000L) {
         return false;
      } else {
         return !var1.countdownShown(var4) ? true : var1.zeroShownMs(var4) > 10000L;
      }
   }

   void ong(BlockPos var1, long var2) {
      if (++this.nzx > this.oid(400)) {
         this.nzj.put(var1, var2 + 30000L);
         this.ohx();
         this.ohy(nwx.EXPLORING);
      } else {
         Vec3d var4 = new Vec3d(this.nzw.getX() + 0.5, pqf.getStandY(this.nzw), this.nzw.getZ() + 0.5);
         double var5 = Math.hypot(var4.x - this.getPlayer().getX(), var4.z - this.getPlayer().getZ());
         double var7 = var4.y - this.getPlayer().getY();
         boolean var9 = var5 < 5.0 && var7 > -1.6 && var7 < 1.2 && (Math.abs(var7) < 0.6 ? this.opt(var4) : this.opu(var4));
         if (var9) {
            this.ofb = null;
            this.opo(var4, true);
            if (var5 < 2.0) {
               this.mc.options.sprintKey.setPressed(false);
            }
         } else {
            if (!this.opb()) {
               this.opc(this.nzw, false);
            }

            if (this.opb()) {
               Vec3d var10 = this.onl(var1);
               double var11 = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1));
               if (!this.ohb && var10 != null && var11 <= 25.0 && this.opt(var4)) {
                  this.ohb = true;
               }

               if (this.ohb && var10 != null) {
                  this.oha = var10;
               }

               this.opq();
            } else {
               pqf.resetKeys();
               this.oot();
            }
         }
      }
   }

   boolean onh() {
      if (this.oad > 0) {
         this.oad--;
         if (this.oaf != null) {
            this.oop(this.oaf);
         }

         return true;
      } else if (this.oae > 0) {
         this.oae--;
         return false;
      } else {
         this.oae = 60 + this.nzf.nextInt(80);
         this.oad = 10 + this.nzf.nextInt(16);
         double var1 = Math.toRadians(this.ogv + 90.0 + (this.nzf.nextDouble() - 0.5) * 140.0);
         double var3 = 6.0 + this.nzf.nextDouble() * 8.0;
         Vec3d var5 = this.getPlayer().getEyePos();
         this.oaf = new Vec3d(var5.x + Math.cos(var1) * var3, var5.y + (this.nzf.nextDouble() - 0.6) * 3.0, var5.z + Math.sin(var1) * var3);
         return true;
      }
   }

   boolean oni() {
      if (this.nzw == null) {
         return false;
      } else {
         double var1 = this.getPlayer().getX() - (this.nzw.getX() + 0.5);
         double var3 = this.getPlayer().getZ() - (this.nzw.getZ() + 0.5);
         double var5 = this.getPlayer().getY() - pqf.getStandY(this.nzw);
         double var7 = var1 * var1 + var3 * var3;
         if (!this.getPlayer().isOnGround() || Math.abs(var5) > 0.6) {
            return false;
         } else {
            return var7 < 0.36
               ? true
               : var7 < 2.25
                  && this.nzu != null
                  && this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(this.nzu)) <= 15.0
                  && this.onl(this.nzu) != null;
         }
      }
   }

   BlockPos onj(BlockPos var1) {
      if (this.getWorld() != null && this.getPlayer() != null) {
         double var2 = this.getPlayer().getEyeHeight(EntityPose.STANDING);
         Vec3d var4 = Vec3d.ofCenter(var1);
         Vec3d var5 = this.getPlayer().getEntityPos();
         BlockPos var6 = null;
         double var7 = Double.MAX_VALUE;

         for (int var9 = -1; var9 <= 1; var9++) {
            for (int var10 = -2; var10 <= 2; var10++) {
               for (int var11 = -2; var11 <= 2; var11++) {
                  if (var10 != 0 || var11 != 0 || var9 == 1) {
                     BlockPos var12 = var1.add(var10, var9, var11);
                     if (this.onk(var12) && !this.ont(var12, 7.0)) {
                        double var13 = pqf.getStandY(var12);
                        Vec3d var15 = new Vec3d(var12.getX() + 0.5, var13 + var2, var12.getZ() + 0.5);
                        if (!(var15.squaredDistanceTo(var4) > 12.9) && this.onm(var15, var1) != null) {
                           double var16 = Math.max(Math.abs(var10), Math.abs(var11));
                           double var18 = Math.sqrt(var5.squaredDistanceTo(Vec3d.ofBottomCenter(var12)))
                              + (var16 > 1.0 ? 1.2 : 0.0)
                              + (var9 != 0 ? 0.8 : 0.0)
                              + (var10 == 0 && var11 == 0 ? 1.5 : 0.0);
                           if (var18 < var7) {
                              var7 = var18;
                              var6 = var12;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var6;
      } else {
         return null;
      }
   }

   boolean onk(BlockPos var1) {
      return this.getWorld() == null
         ? false
         : this.getWorld().getBlockState(var1).getCollisionShape(this.getWorld(), var1).isEmpty()
            && this.getWorld().getBlockState(var1.up()).getCollisionShape(this.getWorld(), var1.up()).isEmpty()
            && !this.getWorld().getBlockState(var1.down()).getCollisionShape(this.getWorld(), var1.down()).isEmpty();
   }

   Vec3d onl(BlockPos var1) {
      return this.onm(this.getPlayer().getEyePos(), var1);
   }

   Vec3d onm(Vec3d var1, BlockPos var2) {
      Vec3d var3 = Vec3d.ofCenter(var2).add(0.0, -0.06, 0.0);
      Vec3d var4 = var3.add(this.ohf, this.ohg * 0.6, this.ohh);
      if (this.onn(var1, var4, var2)) {
         return var4;
      }

      Vec3d var5 = null;
      double var6 = Double.MAX_VALUE;

      for (double var8 = -0.3; var8 <= 0.31; var8 += 0.3) {
         for (double var10 = -0.3; var10 <= 0.31; var10 += 0.3) {
            for (double var12 = -0.3; var12 <= 0.31; var12 += 0.3) {
               Vec3d var14 = var3.add(var8, var10, var12);
               double var15 = var14.squaredDistanceTo(var3);
               if (var15 < var6 && this.onn(var1, var14, var2)) {
                  var6 = var15;
                  var5 = var14;
               }
            }
         }
      }

      return var5;
   }

   boolean onn(Vec3d var1, Vec3d var2, BlockPos var3) {
      BlockHitResult var4 = this.getWorld().raycast(new RaycastContext(var1, var2, ShapeType.OUTLINE, FluidHandling.NONE, this.getPlayer()));
      return var4.getType() == Type.BLOCK && var4.getBlockPos().equals(var3);
   }

   void ono(BlockPos var1, nwg var2, long var3) {
      if (this.mc.currentScreen == null) {
         this.ohk = true;
         this.ohl = this.nzd;
         BlockHitResult var5 = this.opa(var1);
         this.oos(var5 != null);
         boolean var6 = false;
         if (var5 != null) {
            this.oaq = 0;
            if (this.ohe > 0) {
               this.ohe--;
            } else if (var3 - this.oar > this.nzz) {
               var6 = true;
            }
         } else if (++this.oaq > 40 && var3 - this.oar > this.nzz && this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) < 16.0) {
            BlockHitResult var7 = this.onq(var1);
            if (var7 != null) {
               ptr.later(() -> {
                  if (this.mc.interactionManager != null && this.mc.player != null && this.mc.currentScreen == null) {
                     this.mc.interactionManager.interactBlock(this.mc.player, Hand.MAIN_HAND, var7);
                     this.mc.player.swingHand(Hand.MAIN_HAND);
                  }
               });
               this.onp(var1, var2, var3);
            }
         }

         if (var6) {
            this.onp(var1, var2, var3);
         }

         this.mc.options.useKey.setPressed(var6);
         this.mc.options.sneakKey.setPressed(false);
      }
   }

   void onp(BlockPos var1, nwg var2, long var3) {
      this.oar = var3;
      this.nzz = 550L + this.nzf.nextInt(450);
      this.nzy++;
      this.ojg(var1, var2, var3);
   }

   BlockHitResult onq(BlockPos var1) {
      Vec3d var2 = this.getPlayer().getEyePos();
      Vec3d var3 = Vec3d.ofCenter(var1);
      BlockHitResult var4 = this.getWorld().raycast(new RaycastContext(var2, var3, ShapeType.COLLIDER, FluidHandling.NONE, this.getPlayer()));
      if (var4.getType() == Type.BLOCK && var4.getBlockPos().equals(var1)) {
         return var4;
      }

      if (this.oaq <= 80) {
         return null;
      }

      Direction var5 = Direction.getFacing(var2.x - var3.x, var2.y - var3.y, var2.z - var3.z);
      Vec3d var6 = var3.add(var5.getOffsetX() * 0.5, var5.getOffsetY() * 0.5, var5.getOffsetZ() * 0.5);
      return new BlockHitResult(var6, var5, var1, false);
   }

   void onr() {
      if (this.mc.world != null) {
         boolean var1 = false;

         for (Entity var3 : this.mc.world.getEntities()) {
            if (var3 instanceof WardenEntity var4 && var4.isAlive() && this.nzp.put(var4.getBlockPos(), this.nzd + 100) == null) {
               var1 = true;
            }
         }

         if (this.nzp.values().removeIf(var1x -> var1x < this.nzd)) {
            var1 = true;
         }

         if (this.nzp.size() > 256) {
            this.nzp.clear();
            var1 = true;
         }

         if (var1) {
            this.nzq = new ArrayList<>(this.nzp.keySet());
         }
      }
   }

   List<BlockPos> ons() {
      return this.nzq;
   }

   boolean ont(BlockPos var1, double var2) {
      double var4 = var2 * var2;

      for (BlockPos var7 : this.nzp.keySet()) {
         if (var7.getSquaredDistance(var1) < var4) {
            return true;
         }
      }

      return false;
   }

   WardenEntity onu(double var1) {
      if (this.mc.world == null) {
         return null;
      }

      WardenEntity var3 = null;
      double var4 = var1 * var1;

      for (Entity var7 : this.mc.world.getEntities()) {
         if (var7 instanceof WardenEntity var8 && var8.isAlive()) {
            double var9 = var8.squaredDistanceTo(this.getPlayer());
            if (var9 < var4) {
               var4 = var9;
               var3 = var8;
            }
         }
      }

      return var3;
   }

   boolean onv(BlockPos var1) {
      Vec3d var2 = Vec3d.ofCenter(var1);

      for (PlayerEntity var4 : this.mc.world.getPlayers()) {
         if (var4 != this.getPlayer()
            && !(var4.squaredDistanceTo(var2) >= 20.0)
            && (
               onw(var4.getEquippedStack(EquipmentSlot.HEAD))
                  || onw(var4.getEquippedStack(EquipmentSlot.CHEST))
                  || onw(var4.getEquippedStack(EquipmentSlot.LEGS))
                  || onw(var4.getEquippedStack(EquipmentSlot.FEET))
            )) {
            return true;
         }
      }

      return false;
   }

   static boolean onw(ItemStack var0) {
      return !var0.isEmpty()
         && (var0.isIn(ItemTags.HEAD_ARMOR) || var0.isIn(ItemTags.CHEST_ARMOR) || var0.isIn(ItemTags.LEG_ARMOR) || var0.isIn(ItemTags.FOOT_ARMOR));
   }

   boolean onx() {
      boolean var1 = System.currentTimeMillis() - this.nzr < 5000L;

      for (Entity var3 : this.mc.world.getEntities()) {
         if (var3 instanceof WardenEntity var4 && var4.isAlive()) {
            double var5 = var4.squaredDistanceTo(this.getPlayer());
            if (var5 < 36.0 || var1 && var5 < 900.0 && this.ony(var4) && (var5 < 64.0 || this.onz(var4))) {
               this.ooa(true);
               return true;
            }
         }
      }

      if (this.getPlayer().hasStatusEffect(StatusEffects.GLOWING)) {
         PlayerEntity var7 = this.ooh();
         if (var7 != null && var7.squaredDistanceTo(this.getPlayer()) < 576.0) {
            this.ooa(false);
            return true;
         }
      }

      return false;
   }

   boolean ony(WardenEntity var1) {
      double var2 = Math.toDegrees(Math.atan2(-(this.getPlayer().getX() - var1.getX()), this.getPlayer().getZ() - var1.getZ()));
      return Math.abs(MathHelper.wrapDegrees(var1.getBodyYaw() - var2)) < 30.0;
   }

   boolean onz(WardenEntity var1) {
      return (this.getPlayer().getX() - var1.getX()) * (var1.getX() - var1.lastX) + (this.getPlayer().getZ() - var1.getZ()) * (var1.getZ() - var1.lastZ) > 0.01;
   }

   void ooa(boolean var1) {
      if (this.nzb != nwx.ESCAPING) {
         this.oex = var1;
         this.oev = 0;
         this.oew = 0;
         this.oey = 0;
         this.ofb = null;
         this.ofc = 0;
         this.ofd = 0;
         this.olh();
         this.ohx();
         this.oab = null;
         this.ohy(nwx.ESCAPING);
      }
   }

   void oob() {
      this.oev++;
      this.mc.options.attackKey.setPressed(false);
      this.olh();
      LivingEntity var1 = this.oex ? this.onu(48.0) : this.ooh();
      double var2 = var1 != null ? var1.squaredDistanceTo(this.getPlayer()) : Double.MAX_VALUE;
      double var4 = this.oex ? 576.0 : 1600.0;
      if ((this.oev <= 30 || !(var2 > var4)) && this.oev <= 240) {
         boolean var9 = !this.opb() || this.oev % 25 == 0;
         if (var1 != null && var9 && this.ofd <= 0) {
            this.ofd = 10;
            this.ood(var1.getEntityPos());
         }

         if (this.opb()) {
            this.opq();
         } else if (var1 != null) {
            Vec3d var7 = ooc(this.getPlayer().getEntityPos().subtract(var1.getEntityPos()).normalize(), Math.toRadians(nyh[this.oew]));
            Vec3d var8 = this.getPlayer().getEntityPos().add(var7.multiply(12.0));
            this.opn(new Vec3d(var8.x, this.getPlayer().getY(), var8.z));
         } else {
            this.oot();
            this.ohq = true;
            this.mc.options.forwardKey.setPressed(true);
            pyd.setSprint(this.mc.options, true);
         }
      } else {
         pqf.resetKeys();
         this.ofb = null;
         boolean var6 = this.odu != null || this.nzg >= this.nyq.get() || this.oql() < 2;
         this.ohy(var6 ? nwx.CHECK_PVP_COOLDOWN : nwx.EXPLORING);
         this.oaa = 0;
      }
   }

   static Vec3d ooc(Vec3d var0, double var1) {
      double var3 = Math.cos(var1);
      double var5 = Math.sin(var1);
      return new Vec3d(var0.x * var3 - var0.z * var5, 0.0, var0.x * var5 + var0.z * var3).normalize();
   }

   void ood(Vec3d var1) {
      Vec3d var2 = this.getPlayer().getEntityPos().subtract(var1).normalize();
      BlockPos var3 = this.getPlayer().getBlockPos();

      for (int var4 = 0; var4 < 2; var4++) {
         int var5 = (this.oew + var4) % nyh.length;
         double var6 = nyh[var5] + this.nzf.nextGaussian() * 12.0;
         Vec3d var8 = ooc(var2, Math.toRadians(var6));
         double var9 = 22.0 + this.nzf.nextDouble() * 12.0;
         BlockPos var11 = this.ooe(this.oph(var3.add((int)(var8.x * var9), 0, (int)(var8.z * var9))));
         List var12 = this.opd(var11);
         if (var12 != null && var12.size() >= 5) {
            this.opf(var12);
            this.oew = var5;
            return;
         }
      }

      this.oew = (this.oew + 3) % nyh.length;
      this.ofb = null;
      this.ofc = 0;
   }

   BlockPos ooe(BlockPos var1) {
      if (this.nzh == null) {
         return var1;
      }

      double var2 = var1.getX() - this.nzh.getX();
      double var4 = var1.getZ() - this.nzh.getZ();
      double var6 = Math.hypot(var2, var4);
      double var8 = 100.0;
      if (var6 <= var8) {
         return var1;
      }

      double var10 = var8 / var6;
      return this.oph(new BlockPos(this.nzh.getX() + (int)(var2 * var10), var1.getY(), this.nzh.getZ() + (int)(var4 * var10)));
   }

   void oof() {
      if (this.nzd - this.oek > 60) {
         this.nze++;
         this.oeu = null;
         this.ohy(nwx.TELEPORT_TO_SAVE);
      } else {
         this.oog();
      }
   }

   void oog() {
      PlayerEntity var1 = this.ooh();
      BlockPos var2 = this.getPlayer().getBlockPos();
      if (this.ofd <= 0) {
         if (var1 == null || this.oeu != null && !(this.oeu.getSquaredDistance(var2) < 10.0) && !(var1.squaredDistanceTo(this.getPlayer()) < 400.0)) {
            if (var1 == null && (this.oeu == null || this.oeu.getSquaredDistance(var2) < 4.0) && (this.oeu == null || this.nzf.nextInt(120) == 0)) {
               double var7 = this.nzf.nextDouble() * Math.PI * 2.0;
               double var5 = 12.0 + this.nzf.nextDouble() * 14.0;
               this.oeu = this.ooe(this.oph(var2.add((int)Math.round(Math.cos(var7) * var5), 0, (int)Math.round(Math.sin(var7) * var5))));
               this.ofd = 10;
               this.opf(this.opd(this.oeu));
            }
         } else {
            Vec3d var3 = ooc(this.getPlayer().getEntityPos().subtract(var1.getEntityPos()).normalize(), Math.toRadians(this.nzf.nextGaussian() * 20.0));
            double var4 = 24.0 + this.nzf.nextDouble() * 14.0;
            this.oeu = this.ooe(this.oph(var2.add((int)(var3.x * var4), 0, (int)(var3.z * var4))));
            this.ofd = 10;
            this.opf(this.opd(this.oeu));
         }
      }

      if (this.opb()) {
         this.opq();
      } else {
         pqf.resetKeys();
         this.oot();
      }
   }

   PlayerEntity ooh() {
      PlayerEntity var1 = null;
      double var2 = 2500.0;

      for (PlayerEntity var5 : this.mc.world.getPlayers()) {
         if (var5 != this.getPlayer()) {
            double var6 = var5.squaredDistanceTo(this.getPlayer());
            if (var6 < var2) {
               var2 = var6;
               var1 = var5;
            }
         }
      }

      return var1;
   }

   void ooi() {
      this.ogx = this.getPlayer();
      if (this.ogx != null) {
         this.ool(this.ogx);
         this.ogl.reset(this.ogx.getYaw(), this.ogx.getPitch());
         this.ogv = this.ogx.getYaw();
         this.ogw = this.ogx.getPitch();
         this.ogy = this.ogx.getEntityPos();
      }

      this.ogn = false;
      this.ogo = false;
      this.ohn = false;
      this.oho = false;
      this.ohp = false;
      this.nzn = System.currentTimeMillis();
   }

   void ooj() {
      ptr.clear();
      if (this.ogn) {
         this.ogn = false;
         if (this.driver == null && this.ogm.ownedBy(this)) {
            this.ogm.release(this.mc.player);
         }
      }
   }

   void ook() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 != null) {
         boolean var2 = this.ogx != var1 || this.ogy == null || var1.getEntityPos().squaredDistanceTo(this.ogy) > 400.0;
         if (var2) {
            this.nzn = System.currentTimeMillis();
            this.nzm.clear();
            if (this.driver == null) {
               this.ogm.reset();
            }

            if (this.ogx != var1) {
               this.ool(var1);
            }

            this.ogl.reset(var1.getYaw(), var1.getPitch());
            this.ogv = var1.getYaw();
            this.ogw = var1.getPitch();
            this.ogx = var1;
            this.ogn = false;
            this.ofb = null;
            this.ofc = 0;
            this.off = null;
            this.ofe.reset();
         }

         this.ogy = var1.getEntityPos();
      }
   }

   void ool(PlayerEntity var1) {
      String var2 = var1.getGameProfile() != null ? var1.getGameProfile().name() : null;
      long var3 = 1125899906842597L;
      if (var2 != null) {
         for (int var5 = 0; var5 < var2.length(); var5++) {
            var3 = var3 * 31L + Character.toLowerCase(var2.charAt(var5));
         }
      }

      this.ogl.personalize(var3);
      this.ofe.personalize(var3);
   }

   void oom(float var1, float var2) {
      this.oon(var1, var2, false);
   }

   void oon(float var1, float var2, boolean var3) {
      this.ogs = var1;
      this.ogt = var2;
      this.ogq = var3;
      this.ogr = false;
      this.ogu = 0.0;
      this.ogo = true;
      this.ogp = false;
   }

   void ooo(Vec3d var1) {
      float[] var2 = prt.calculateAngle(var1);
      this.oon(var2[0], var2[1], false);
   }

   void oop(Vec3d var1) {
      float[] var2 = prt.calculateAngle(var1);
      this.oon(var2[0], var2[1], true);
   }

   void ooq(BlockPos var1, Vec3d var2) {
      this.ooo(var2);
      this.ogu = this.ohc ? 0.25 : this.oor(var1, var2);
   }

   double oor(BlockPos var1, Vec3d var2) {
      if (this.getWorld() != null && this.getPlayer() != null && var1 != null && var2 != null) {
         VoxelShape var3 = this.getWorld().getBlockState(var1).getOutlineShape(this.getWorld(), var1);
         Box var4 = var3.isEmpty() ? new Box(var1) : var3.getBoundingBox().offset(var1);
         double var5 = Math.min(
            Math.min(Math.min(var2.x - var4.minX, var4.maxX - var2.x), Math.min(var2.y - var4.minY, var4.maxY - var2.y)),
            Math.min(var2.z - var4.minZ, var4.maxZ - var2.z)
         );
         if (var5 <= 0.02) {
            return 0.25;
         }

         double var7 = Math.max(0.5, this.getPlayer().getEyePos().distanceTo(var2));
         return MathHelper.clamp(Math.toDegrees(Math.atan2(var5, var7)) * 0.55, 0.25, 4.0);
      } else {
         return 0.0;
      }
   }

   void oos(boolean var1) {
      if (!var1 && !this.ogl.isMoving()) {
         if (++this.ohd >= 3) {
            this.ohc = true;
         }
      } else {
         this.ohd = 0;
      }
   }

   void oot() {
      if (!this.ogo) {
         this.ogp = true;
      }
   }

   void oou() {
      float var1 = this.ogl.intentPitch();
      if (Math.abs(var1 - this.ocv) > 6.0F) {
         this.oon(this.ogl.intentYaw(), this.ocv, true);
      } else {
         this.oot();
      }
   }

   void oov() {
      this.ohb = false;
      this.ohc = false;
      this.ohd = 0;
      this.ohf = (this.nzf.nextDouble() - 0.5) * 0.3;
      this.ohg = (this.nzf.nextDouble() - 0.5) * 0.36;
      this.ohh = (this.nzf.nextDouble() - 0.5) * 0.3;
      this.ohe = 1 + this.nzf.nextInt(4);
   }

   float oow() {
      return (float)this.ofe.moveYaw(this.ogv);
   }

   void oox() {
      if (this.getPlayer() != null) {
         this.ofk = this.ogo && !this.ogq;
         boolean var1 = this.ofe.takeTurn(this.ofl);
         if (this.oib() && !this.ofk) {
            this.ooy();
         } else {
            if (this.mc.currentScreen == null) {
               this.ogl.setMouseStep(this.driver != null ? this.driver.mouseStep() : prp.step());
               if (this.obw || this.ocf) {
                  this.ogl.freeze();
               } else if (this.ogo) {
                  if (this.ogq && this.ogr) {
                     this.ogl.aimTight(this.ogs, this.ogt);
                  } else if (this.ogq) {
                     this.ogl.aimRelaxed(this.ogs, this.ogt);
                  } else {
                     this.ogl.aim(this.ogs, this.ogt, this.ogu);
                  }
               } else if (var1) {
                  this.ogl.turn(this.ofl[0], this.ofl[1]);
               } else if (this.ogp) {
                  this.ogl.hold();
               } else {
                  this.ogl.idle();
               }

               this.ogv = this.ogl.getYaw();
               this.ogw = this.ogl.getPitch();
            }

            this.ogo = false;
            this.ogp = false;
            if (this.driver != null) {
               if (this.mc.currentScreen == null) {
                  this.driver.look(this.ogv, MathHelper.clamp(this.ogw, -90.0F, 90.0F));
               }
            } else {
               this.ogm.set(this, this.ogv, MathHelper.clamp(this.ogw, -90.0F, 90.0F));
            }

            this.ogn = true;
            if (this.mc.currentScreen != null) {
               ptr.clear();
            } else if (this.ogz != null) {
               ptr.aimAt(this.ogz, this.ogv, this.ogw);
            }

            this.ogz = null;
         }
      }
   }

   void ooy() {
      this.ogo = false;
      this.ogp = false;
      ClientPlayerEntity var1 = this.getPlayer();
      this.ogl.reset(var1.getYaw(), var1.getPitch());
      this.ogv = var1.getYaw();
      this.ogw = var1.getPitch();
      if (this.ogn) {
         this.ogn = false;
         if (this.ogm.ownedBy(this)) {
            this.ogm.release(this.mc.player);
         }
      }

      if (this.mc.currentScreen != null) {
         ptr.clear();
      } else if (this.ogz != null) {
         ptr.aimAt(this.ogz, this.ogv, this.ogw);
      }

      this.ogz = null;
   }

   BlockHitResult ooz() {
      if (this.getWorld() != null && this.getPlayer() != null) {
         Vec3d var1 = this.getPlayer().getEyePos();
         Vec3d var2 = Vec3d.fromPolar(this.ogw, this.ogv);
         double var3 = 4.5;
         Vec3d var5 = var1.add(var2.x * var3, var2.y * var3, var2.z * var3);
         return this.getWorld().raycast(new RaycastContext(var1, var5, ShapeType.OUTLINE, FluidHandling.NONE, this.getPlayer()));
      } else {
         return null;
      }
   }

   BlockHitResult opa(BlockPos var1) {
      BlockHitResult var2 = this.ooz();
      if (var2 != null && var2.getType() == Type.BLOCK && var2.getBlockPos().equals(var1)) {
         this.ogz = var1;
         return var2;
      } else {
         return null;
      }
   }

   boolean opb() {
      return this.ofb != null && this.ofc < this.ofb.size();
   }

   boolean opc(BlockPos var1, boolean var2) {
      if (var1 == null) {
         return false;
      }

      if (!var2 && this.ofd > 0) {
         return this.opb();
      }

      this.ofd = 8;
      this.opf(this.opd(var1));
      return this.ofb != null && !this.ofb.isEmpty();
   }

   List<BlockPos> opd(BlockPos var1) {
      this.ofq = var1;
      this.ofr = this.ope();
      if (this.ofg == null || !var1.equals(this.ofh)) {
         this.ofg = pqq.random(this.nzf);
         this.ofh = var1;
      }

      return pqx.findPath(this.getWorld(), this.getPlayer(), this.ofr, var1, this.ons(), 7.0, true, this.oix(), this.ofg);
   }

   BlockPos ope() {
      ClientPlayerEntity var1 = this.getPlayer();
      BlockPos var2 = BlockPos.ofFloored(var1.getX(), var1.getY() + 0.001, var1.getZ());
      if (!this.opz(var2)) {
         var2 = var2.up();
      }

      if (!var1.isOnGround() && !var1.isTouchingWater()) {
         Mutable var3 = var2.mutableCopy();

         for (int var4 = 0; var4 < 6 && this.opz(var3.down()); var4++) {
            var3.move(Direction.DOWN);
         }

         return var3.toImmutable();
      } else {
         return var2;
      }
   }

   void opf(List<BlockPos> var1) {
      this.ofb = var1;
      this.ofc = 0;
      this.ofw = 0;
      this.ofx = 0;
      this.off = null;
      if (var1 != null && !var1.isEmpty()) {
         prz var2 = new prz();
         var2.danger = this.ons();
         var2.radius = 7.0;
         var2.avoid = this.oix();
         this.off = this.ofe.plan(this.getWorld(), this.getPlayer(), var1, this.ofq, var2);
      }

      if (this.off == null) {
         this.ofb = null;
      }
   }

   void opg() {
      this.ofq = null;
      this.ofr = null;
      this.oft = null;
      this.ofu = null;
      this.ofv = 0;
      this.ofw = 0;
      this.ofx = 0;
      this.ofy = 0;
      this.ofz = false;
      this.oga = 0;
      this.ogc = 0;
      this.ogd = null;
      this.oge = true;
      this.ogf = Double.NaN;
   }

   BlockPos oph(BlockPos var1) {
      if (this.getWorld() == null) {
         return var1;
      }

      Mutable var2 = new Mutable();

      for (int var3 = 0; var3 <= 10; var3++) {
         for (byte var4 = 1; var4 >= -1; var4 -= 2) {
            var2.set(var1.getX(), var1.getY() + var3 * var4, var1.getZ());
            if (this.onk(var2)) {
               return var2.toImmutable();
            }

            if (var3 == 0) {
               break;
            }
         }
      }

      return var1;
   }

   void opi() {
      if (this.opb() && this.off != null && this.ofd <= 0 && !this.oib() && this.ofe.remaining(this.off) < 3.5) {
         this.ofd = 8;
         this.opj();
      }

      if (!this.opb()) {
         if (this.ofd > 0) {
            pqf.resetKeys();
            this.oot();
            return;
         }

         this.ofd = 8;
         this.opj();
      }

      if (this.opb()) {
         this.opq();
      } else {
         pqf.resetKeys();
         this.oot();
      }
   }

   void opj() {
      BlockPos var1 = this.getPlayer().getBlockPos();
      this.opl(var1);
      if (Double.isNaN(this.ofm)) {
         this.ofm = Math.toRadians(this.oow() + 90.0);
      }

      if (this.nzh != null && var1.getSquaredDistance(this.nzh) > 4900.0) {
         this.ofm = Math.atan2(this.nzh.getZ() - var1.getZ(), this.nzh.getX() - var1.getX());
      }

      double[] var2 = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
      int var3 = 0;

      for (int var4 = 0; var4 < var2.length && var3 < 2; var4++) {
         double var5 = this.ofm + var2[(var4 + this.ofo) % var2.length] + this.nzf.nextGaussian() * 0.28;
         double var7 = 14.0 + this.nzf.nextDouble() * 16.0;
         BlockPos var9 = var1.add((int)Math.round(Math.cos(var5) * var7), 0, (int)Math.round(Math.sin(var5) * var7));
         if (!this.opm(var9) || this.ofn >= 2) {
            var3++;
            List var10 = this.opd(this.ooe(this.oph(var9)));
            if (var10 != null && var10.size() >= 5) {
               this.ofm = var5;
               this.ofn = 0;
               this.ofo = 0;
               this.opf(var10);
               return;
            }
         }
      }

      this.ofn++;
      this.ofo = (this.ofo + 2) % var2.length;
      this.ofm = this.ofm + ((Math.PI / 2) + this.nzf.nextDouble() * Math.PI);
      this.opf(null);
   }

   static long opk(BlockPos var0) {
      return (long)(var0.getX() >> 4) << 32 ^ var0.getZ() >> 4 & 4294967295L;
   }

   void opl(BlockPos var1) {
      if (this.ofp.size() > 512) {
         this.ofp.clear();
      }

      this.ofp.add(opk(var1));
   }

   boolean opm(BlockPos var1) {
      return this.ofp.contains(opk(var1));
   }

   void opn(Vec3d var1) {
      this.opo(var1, false);
   }

   void opo(Vec3d var1, boolean var2) {
      int var3 = this.ofe.walkTo(this.mc, this.getPlayer(), this.getWorld(), var1, this.ogv, this.ogw, null, this.nzb == nwx.ESCAPING, this.oib(), this.oie());
      if (var3 != 0 && !this.oib()) {
         pqf.resetKeys();
      }

      this.ohq = true;
      this.ofa = true;
   }

   double opp(BlockPos var1) {
      double var2 = this.getPlayer().getX() - (var1.getX() + 0.5);
      double var4 = this.getPlayer().getZ() - (var1.getZ() + 0.5);
      return var2 * var2 + var4 * var4;
   }

   void opq() {
      if (this.opb()) {
         if (!this.oib() && this.ops()) {
            pqf.resetKeys();
            this.oot();
         } else {
            if (this.off == null) {
               prz var1 = new prz();
               var1.danger = this.ons();
               var1.radius = 7.0;
               var1.avoid = this.oix();
               this.off = this.ofe.plan(this.getWorld(), this.getPlayer(), this.ofb, this.ofq, var1);
               if (this.off == null) {
                  this.ofb = null;
                  this.ofc = 0;
                  return;
               }
            }

            Vec3d var4 = this.oha;
            this.oha = null;
            int var2 = this.ofe
               .follow(this.mc, this.getPlayer(), this.getWorld(), this.off, this.ogv, this.ogw, var4, this.nzb == nwx.ESCAPING, this.oib(), this.oie());
            if (var2 == 2) {
               List var3 = this.ofq != null ? this.opd(this.ofq) : null;
               if (var3 != null && !var3.isEmpty()) {
                  this.opf(var3);
               } else {
                  this.ofb = null;
                  this.ofc = 0;
                  this.off = null;
                  this.ofd = 0;
                  if (!this.oib()) {
                     pqf.resetKeys();
                  }
               }
            } else if (var2 == 1) {
               this.ofc = this.ofb.size();
               this.off = null;
               if (!this.oib()) {
                  pqf.resetKeys();
               }
            } else {
               this.ofc = Math.min(this.ofb.size() - 1, this.off.nodeIndex(this.ofe.stride.at()));
               if (this.ofc > this.ofw) {
                  this.ofy = this.ofy + (this.ofc - this.ofw);
                  this.ofw = this.ofc;
                  this.ofx = 0;
                  if (this.ofy >= 10) {
                     this.oet = 0;
                     this.oft = null;
                  }
               } else if (!this.oib() && this.ofz && ++this.ofx > 90) {
                  this.ofx = 0;
                  this.oiv(false);
                  pqf.resetKeys();
                  return;
               }

               this.ohq = true;
               this.ofa = true;
            }
         }
      }
   }

   double opr() {
      ClientPlayerEntity var1 = this.getPlayer();
      return !var1.isOnGround() && !Double.isNaN(this.ogf) ? this.ogf : var1.getY();
   }

   boolean ops() {
      if (this.ohi > 0) {
         this.ohi--;
         return true;
      } else if (this.ohj > 0) {
         this.ohj--;
         return false;
      } else if (this.nzb == nwx.EXPLORING && this.oab == null) {
         this.ohj = 2400 + this.nzf.nextInt(4200);
         this.ohi = 8 + this.nzf.nextInt(26);
         return true;
      } else {
         return false;
      }
   }

   boolean opt(Vec3d var1) {
      return this.opv(var1, true);
   }

   boolean opu(Vec3d var1) {
      return this.opv(var1, false);
   }

   boolean opv(Vec3d var1, boolean var2) {
      if (this.getWorld() != null && this.getPlayer() != null) {
         Vec3d var3 = this.getPlayer().getEntityPos();
         double var4 = var1.x - var3.x;
         double var6 = var1.z - var3.z;
         double var8 = Math.hypot(var4, var6);
         if (var8 < 0.1) {
            return true;
         }

         double var10 = this.opw();
         int var12 = (int)Math.ceil(var8 / 0.45);

         for (int var13 = 1; var13 <= var12; var13++) {
            double var14 = (double)var13 / var12;
            double var16 = var3.x + var4 * var14;
            double var18 = var3.z + var6 * var14;
            if (!this.opx(var16, var18, var10)) {
               return false;
            }

            if (var2 && this.opz(BlockPos.ofFloored(var16, var10 - 0.2, var18))) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   double opw() {
      double var1 = this.opr();
      if (!this.opb()) {
         return var1;
      }

      double var3 = pqf.getStandY(this.ofb.get(this.ofc));
      double var5 = var3 - var1;
      return var5 > 0.0 && var5 <= 0.6 ? var3 : var1;
   }

   boolean opx(double var1, double var3, double var5) {
      return this.opy(new Box(var1 - 0.31, var5 + 0.6, var3 - 0.31, var1 + 0.31, var5 + 1.8, var3 + 0.31));
   }

   boolean opy(Box var1) {
      for (VoxelShape var3 : this.getWorld().getBlockCollisions(this.getPlayer(), var1)) {
         if (!var3.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   boolean opz(BlockPos var1) {
      return this.getWorld().getBlockState(var1).getCollisionShape(this.getWorld(), var1).isEmpty();
   }

   boolean oqa(ItemStack var1) {
      if (!var1.isEmpty() && !var1.isOf(Items.GLASS_BOTTLE)) {
         return !this.oqf(var1, true) && (!this.nyt.get() || !this.oqf(var1, false)) ? !this.oht(var1) : false;
      } else {
         return true;
      }
   }

   boolean oqb(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      } else {
         return var1.isOf(Items.GLASS_BOTTLE) ? true : !this.oqd(var1) && oqc(var1) && !this.oht(var1);
      }
   }

   static boolean oqc(ItemStack var0) {
      Item var1 = var0.getItem();
      return var1 instanceof ShovelItem
         || var1 instanceof AxeItem
         || var1 instanceof BannerItem
         || var1 instanceof SmithingTemplateItem && !var0.isOf(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
         || var0.isOf(Items.BLAZE_ROD)
         || var0.isOf(Items.ENCHANTED_BOOK)
         || var0.isOf(Items.TRIDENT)
         || var0.isOf(Items.NAME_TAG)
         || var0.isOf(Items.SCULK)
         || var0.isOf(Items.SCULK_SENSOR)
         || var0.isOf(Items.ENDER_CHEST)
         || var0.isOf(Items.REINFORCED_DEEPSLATE)
         || var0.isOf(Items.PUFFERFISH)
         || var0.isOf(Items.HONEY_BOTTLE)
         || var0.isOf(Items.FERMENTED_SPIDER_EYE)
         || var0.isOf(Items.ANVIL)
         || var0.isOf(Items.COOKED_PORKCHOP);
   }

   boolean oqd(ItemStack var1) {
      if (var1.isEmpty()) {
         return true;
      } else if (var1.isOf(Items.GOLDEN_CARROT) || var1.isOf(Items.TOTEM_OF_UNDYING) || var1.isOf(Items.MACE)) {
         return true;
      } else {
         return !this.oqf(var1, true) && !this.oqf(var1, false)
            ? var1.getItem().getTranslationKey().contains(a.d("鷜\ue441準\uf0ff笵ﶒ", 1568403408, -906464683))
            : true;
      }
   }

   boolean oqe(ItemStack var1) {
      if (this.oqf(var1, true) || this.oqf(var1, false)) {
         return true;
      } else {
         return var1.isOf(Items.GOLDEN_CARROT) ? this.oqh(Items.GOLDEN_CARROT) <= this.oal : this.oqd(var1) && !this.oht(var1);
      }
   }

   boolean oqf(ItemStack var1, boolean var2) {
      if (var1.isEmpty()) {
         return false;
      }

      if (!var1.isOf(Items.POTION) && !var1.isOf(Items.SPLASH_POTION) && !var1.isOf(Items.LINGERING_POTION)) {
         return false;
      }

      PotionContentsComponent var3 = var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var3 != null) {
         int var4 = 0;
         boolean var5 = false;

         for (StatusEffectInstance var7 : var3.getEffects()) {
            var4++;
            if (var7.getEffectType() == (var2 ? StatusEffects.INVISIBILITY : StatusEffects.SPEED)) {
               var5 = true;
            }
         }

         if (var4 > 0) {
            return var4 == 1 && var5;
         }
      }

      String var8 = var1.getName().getString().toLowerCase();
      return var2
         ? var8.contains(a.d("邅\ue93c揨ﶓ癈\uf0f5䪢", -166002153, -559573336))
         : var8.contains(a.c(252853652, "㧒䀘쫏哀\udf69妧\ue3f7")) || var8.contains(a.d("ণ瀑𧻓撦\uef70", 897879409, -15498076));
   }

   int oqg(boolean var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = this.getPlayer().getInventory().getStack(var3);
         if (this.oqf(var4, var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   int oqh(Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = this.getPlayer().getInventory().getStack(var3);
         if (var4.isOf(var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   int oqi(Predicate<ItemStack> var1) {
      for (int var2 = 0; var2 < 9; var2++) {
         if (var1.test(this.getPlayer().getInventory().getStack(var2))) {
            return var2;
         }
      }

      return -1;
   }

   int oqj(Predicate<ItemStack> var1) {
      for (int var2 = 9; var2 < 36; var2++) {
         if (var1.test(this.getPlayer().getInventory().getStack(var2))) {
            return var2;
         }
      }

      return -1;
   }

   int oqk() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         if (this.oqb(this.getPlayer().getInventory().getStack(var2))) {
            var1++;
         }
      }

      return var1;
   }

   int oql() {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         ItemStack var3 = this.getPlayer().getInventory().getStack(var2);
         if (var3.isEmpty() || this.oqb(var3)) {
            var1++;
         }
      }

      return var1;
   }
}
