package a;

import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
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

public class mpq extends pnc {
   private static final String mpr = a.b("㞺丬쓽媄", 1693399030);
   private static final String mps = a.b("⨛厜\ud95c䜯", 1390946888);
   private static final List<BlockPos> mpt = Collections.emptyList();
   private static final int[] mpu = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
   private static final float mpv = -55.0F;
   private static final int mpw = 2400;
   private static final long mpx = 6000L;
   private static final int mpy = 2;
   private static final int mpz = 200;
   private static final int mqa = 3;
   private static final int mqb = 100;
   private static final float mqc = 86.0F;
   private final vmc mqd = this.add(new vmc(a.d("⾞嘃\udcc9䋠쥡俇\uf586籡\ue228", -2028986025, -1575547251), 10.0, 1.0, 30.0, 1.0));
   private final vlj mqe = this.add(new vlj(a.b("\ue5d2鱀ᚓ裹ͺ薇㿑똺⡢", 1473504663), vlg.LOOT, ppu.END_DEFAULTS));
   private final vkl mqf = this.add(new vkl(a.c(-678181698, "쓢뵵㞰ꦄ∑꒰Ụ霓ॗ"), false));
   private final vkl mqg = this.add(new vkl(a.d("뒰촴䟭\ud992刀퓢溲\ue756礉\uf3b9", 654443813, 53916107), false));
   private final vmu mqh = this.add(new vmu(a.b("鲚\ue519濝\uf1bf稭ﳹ䚁콺", -871719743), a.d("Ὣ曕\uec5d爩粒", 2023181717, -397127014), 32));
   private final vmu mqi = this.add(new vmu(a.c(-277864943, "ṕ柇\ued14獾\uf8fd縩쑑䶪"), a.d("꧶큈嫀쒴佫", 1969651208, 141612954), 120));
   private final vlv mqj = this.add(
      new vlv(a.d("\ue313骓၉踱׳荝㤓냤⻯ꐜ⏔", -98598428, -323591512), a.d("Ꭶ樰\ue0e1纘", -369263833, 370763981), a.b("䇇㡑늀⳹", 925188491), a.c(70318726, "𥉉荒\u0992韡"))
   );
   private final vmu mqk = this.add(new vmu(a.c(2023459489, "諿\uf378禸\ue7cb汌\ueab3僯\ud912䝅"), a.b("⿳噉\udc90", 1374891925), 32));
   private final vkl mql = this.add(new vkl(a.b("댘쪒䁆\ude2f喯퍌椂\ue0e9纷\uf417", -1426279615), false));
   private final vkw mqm = this.add(
      new vkw(
         a.b("㒆䴜쟟妩퉣咝\uee99松郎玚\uf44b\u0e3d胣", 1860777157),
         new vkq(a.b("\uf219讟Ŋ鼷ᓽ鉚⡍ꇽ㾭딖㊁좤䙵\udfd7喌퍺", 1798107739), vhz.LAYERS, () -> ign.openWalk(a.c(693239075, "ﵥ蓠า遘ᮥ鴿❦")))
      )
   );
   private static mpq mqn;
   private final pnz mqo = new pnz();
   private int mqp = 0;
   private mpm mqq = mpm.RESTOCK_AND_DUMP;
   private int mqr = 0;
   private long mqs = 0L;
   private long mqt = 0L;
   private int mqu = 0;
   private int mqv = 0;
   private int mqw = 0;
   private int mqx = -1;
   private List<BlockPos> mqy = null;
   private int mqz = 0;
   private final Set<BlockPos> mra = new HashSet<>();
   private int mrb = 0;
   private int mrc = 0;
   private final List<String> mrd = new ArrayList<>(
      List.of(a.b("歛ያ頼", 1128689517), a.d("햛갯⛳뢈㍐", -1629421280, 1886703750), a.c(360675067, "犲\u0b78膯ᾠ鐉\u12c7ꢗⅨ"))
   );
   private int mre = 3;
   private pmf mrf = null;
   private int mrg = 0;
   private boolean mrh = false;
   private boolean mri = false;
   private boolean mrj = false;
   private boolean mrk = false;
   private BlockPos mrl = null;
   private String mrm = "";
   private int mrn = 0;
   private boolean mro = false;
   private BlockPos mrp = null;
   private int mrq = 0;
   private BlockPos mrr = null;
   private int mrs = 0;
   private BlockPos mrt = null;
   private int mru = 0;
   private int mrv = 0;
   private int mrw = 0;
   private int mrx = 1;
   private boolean mry = false;
   private BlockPos mrz = null;
   private int msa = 0;
   private boolean msb = false;
   private int msc = 0;
   private int msd = 0;
   private int mse = 0;
   private int msf = 0;
   private int msg = 0;
   private int msh = 0;
   private int msi = 0;
   private Vec3d msj = null;
   private boolean msk = false;
   private final Set<Integer> msl = new HashSet<>();
   private final Set<Integer> msm = new HashSet<>();
   private int msn = 0;
   private double mso = Double.MAX_VALUE;
   private int msp = -1;
   private boolean msq = false;
   private int msr = 0;
   private int mss = 0;
   private boolean mst = false;
   private boolean msu = false;
   private int msv = 0;
   private int msw = 0;
   private int msx = 0;
   private final Queue<Runnable> msy = new LinkedList<>();
   private int msz = 0;
   private long mta = 0L;
   private int mtb = 0;
   private float mtc = 0.0F;
   private boolean mtd = false;
   private int mte = 0;
   private int mtf = 0;
   private float mtg = 0.0F;
   private int mth = 0;
   private Vec3d mti = null;
   private int mtj = 0;
   private int mtk = 0;
   private final pjw mtl = new pjw().neuro(lex.END);
   private final pud mtm = pud.INSTANCE;
   private boolean mtn = false;
   private boolean mto = false;
   private boolean mtp = false;
   private boolean mtq = false;
   private boolean mtr = false;
   private float mts = 0.0F;
   private float mtt = 0.0F;
   private float mtu = 0.0F;
   private float mtv = 0.0F;
   private PlayerEntity mtw = null;
   private Vec3d mtx = null;
   private final Random mty = new Random();
   private float mtz = 0.0F;
   private boolean mua = false;
   private boolean mub = false;
   private boolean muc = false;
   private int mud = 0;
   private int mue = 0;
   private int muf = 0;
   private int mug = 0;
   private int muh = 0;
   private int mui = -1;
   private int muj = 0;
   private int muk = -1;
   private int mul = 0;
   private int mum = 0;
   private boolean mun = false;
   private int muo = 0;
   private int mup = 0;
   private int muq = 0;
   private float mur = 0.0F;
   private boolean mus = false;
   private World mut = null;
   private int muu = -1;
   private int muv = 0;
   private boolean muw = false;
   private boolean mux = false;
   private Vec3d muy = null;
   private double muz = 0.0;
   private double mva = 0.0;
   private double mvb = 0.0;
   private int mvc = 0;
   private double mvd = 0.0;
   private boolean mve = false;
   private int mvf = 0;
   private int mvg = 0;
   private boolean mvh = false;
   private int mvi = 0;
   private int mvj = 0;
   private BlockPos mvk = null;
   private final pyd mvl = new pyd();
   private psf mvm = null;
   private pqq mvn = null;
   private BlockPos mvo = null;
   private boolean mvp = false;
   private boolean mvq = false;
   private boolean mvr = false;
   private final double[] mvs = new double[2];
   private double mvt = Double.NaN;
   private int mvu = 0;
   private int mvv = 0;
   private final Set<Long> mvw = new HashSet<>();
   private int mvx = 0;
   private boolean mvy = false;
   private String mvz = null;
   private int mwa = 0;
   private int mwb = 0;
   private final Map<ItemStack, Boolean> mwc = new IdentityHashMap<>();
   private int mwd = -1;
   private int mwe = -1;
   private int mwf = 0;
   private float mwg = 10.0F;
   private int mwh = 0;
   private int mwi = 0;
   private BlockPos mwj = null;
   private long mwk = 0L;
   private int mwl = -1;
   private int mwm = -100000;
   private String mwn = "";
   private Vec3d mwo = null;
   private int mwp = 0;
   private int mwq = 0;
   private int mwr = -1;
   private int mws = -100000;
   private final int[] mwt = new int[]{-1, -1};
   private final int[] mwu = new int[2];
   private final int[] mwv = new int[2];
   private final int[] mww = new int[2];
   private final int[] mwx = new int[2];
   private final boolean[] mwy = new boolean[2];
   private World mwz = null;
   private PlayerEntity mxa = null;
   private Vec3d mxb = null;
   private int mxc = -1;
   private volatile boolean mxd = false;
   private int mxe = 0;
   private int mxf = 0;
   private int mxg = 0;
   private int mxh = 0;
   private String mxi = "";
   private boolean mxj = false;
   private boolean mxk = false;
   private volatile int mxl = -100000;
   private volatile String mxm = null;
   private PlayerEntity mxn = null;
   private int mxo = -100000;

   public mpq() {
      super(a.c(441565294, "쀨릭㍿괕⛨ꁲᨫ"), a.d("媮⌯ꧫ㞞뱃㫪胪ॾ霊ᶱ騦怇\ueecf睥ﴱ箟쇜乆퓻努\udb48ꄚ⿺둲㈛룐Ť轧ᗜ鎎ᠽ\ue6f7", 2145421006, 1436539906), kfa.PLAYER);
      this.mqk.visibleWhen(() -> a.d("소렋㋋겸", 1897598553, -1422667898).equals(this.mqj.get()));
      if (mqn == null) {
         mqn = this;
      }
   }

   @Override
   public boolean isMaintenance() {
      return false;
   }

   public static mpq mainInstance() {
      return mqn;
   }

   public static void onMessage(Text var0) {
      mpq var1 = mqn;
      if (var1 != null && var1.isEnabled() && var0 != null) {
         var1.onChatMessage(var0.getString());
      }
   }

   public void copySettingsFrom(mpq var1) {
      if (var1 != null && var1 != this) {
         this.mqd.set(var1.mqd.get());
         this.mqe.set(var1.mqe.ids());
         this.mqf.set(var1.mqf.get());
         this.mqg.set(var1.mqg.get());
         this.mqh.set(var1.mqh.get());
         this.mqi.set(var1.mqi.get());
         this.mqj.set(var1.mqj.get());
         this.mqk.set(var1.mqk.get());
      }
   }

   public String getStateDescription() {
      if (!this.mwn.isEmpty()) {
         return this.mwn;
      } else {
         return this.mqq == null ? "" : this.mqq.mpn;
      }
   }

   public vmo[] botSettings() {
      return new vmo[]{this.mqh, this.mqi, this.mqj, this.mqk, this.mqd, this.mqf, this.mqg};
   }

   public void onBotSettingChanged() {
   }

   public vlj lootList() {
      mpq var1 = mqn;
      return this.driver != null && var1 != null && var1 != this && !var1.isBotInstance() ? var1.mqe : this.mqe;
   }

   private boolean mxr(ItemStack var1) {
      return ppu.picked(var1, this.lootList().ids());
   }

   public String queueNote() {
      return this.mwn;
   }

   private Object mxs() {
      return this.driver != null ? this.driver : pjd.MAIN;
   }

   public tvz walkBrain() {
      return this.mvl.brain();
   }

   public List<BlockPos> getBotPath() {
      return this.mqy;
   }

   public int getBotPathIndex() {
      return this.mqz;
   }

   public BlockPos getBotTarget() {
      if (this.mrr != null) {
         return this.mrr;
      } else {
         return this.mrz != null ? this.mrz : this.mrl;
      }
   }

   public int getBrokenVases() {
      return this.mqr;
   }

   public long getFarmMillis() {
      return this.mqs;
   }

   public int getTotalVases() {
      return this.mqu;
   }

   public int getTotalSand() {
      return this.mqv;
   }

   public int getTotalBrushes() {
      return this.mqw;
   }

   public void resetFarmStats() {
      this.mqs = 0L;
      this.mqu = 0;
      this.mqv = 0;
      this.mqw = 0;
   }

   private String mxt() {
      if (!a.c(1694846919, "侔㘓볓⊠").equals(this.mqj.get())) {
         return a.c(2020307053, "瀌\u09ba荫ᴒ隀ၹꨭ⏞붉");
      } else {
         String var1 = this.mqk.get();
         var1 = var1 == null ? "" : var1.trim();

         while (var1.startsWith(a.c(-1685469480, "웶"))) {
            var1 = var1.substring(1).trim();
         }

         if (var1.toLowerCase().startsWith(a.b("ࡔ燳דּ敀\ueec7", -1152514010))) {
            var1 = var1.substring(5).trim();
         }

         if (var1.isEmpty()) {
            var1 = a.c(990254011, "Ꮭ橧\ue0be");
         }

         return a.d("嫹⍞ꦞ㟭뱪", -1223607346, -57908923) + var1;
      }
   }

   @Override
   protected void onEnable() {
      if (this.getPlayer() != null) {
         this.mtc = this.getPlayer().method_6032();
      }

      if (this.driver == null) {
         try {
            nxa var1 = Flow.getInstance().getModuleManager().get(nxa.class);
            if (var1 != null && var1.isEnabled()) {
               var1.setEnabled(false);
            }
         } catch (Exception var2) {
         }
      }

      this.nbv();
      this.mvw.clear();
      this.mvt = Double.NaN;
      this.mvu = 0;
      this.mqo.reset();
      this.mxg = 0;
      this.mxh = 0;
      this.mxj = false;
      this.mxk = false;
      this.mxl = -100000;
      this.mxn = null;
      this.mxu();
      if (this.mzh()) {
         pjd.at(this.mxs(), nak(this.naj()));
         this.myd(mpm.FARMING);
      } else if (this.getPlayer() != null && this.mzn(a.d("䪼㍽맟⟐걸", -996329450, 1544910574)) != null) {
         pjd.at(this.mxs(), nak(this.mqh.get()));
      }
   }

   @Override
   protected void onDisable() {
      this.mxu();
      this.nbw();
      if (this.driver == null) {
         pnf.clear();
      }

      this.mqt = 0L;
      this.mqx = -1;
      pjd.cancel(this.mxs());
      this.mwn = "";
   }

   private void mxu() {
      this.myd(mpm.RESTOCK_AND_DUMP);
      this.mqr = 0;
      this.mqy = null;
      this.mqz = 0;
      this.mra.clear();
      this.mrh = false;
      this.mri = false;
      this.mrj = false;
      this.mrk = false;
      this.mrl = null;
      this.mrm = "";
      this.mrb = 0;
      this.naa();
      this.mrn = 0;
      this.mro = false;
      this.mrp = null;
      this.mrq = 0;
      this.mrr = null;
      this.mrs = 0;
      this.mrt = null;
      this.mru = 0;
      this.mrv = 0;
      this.mrw = 0;
      this.mrx = 1;
      this.mrz = null;
      this.msa = 0;
      this.msb = false;
      this.mwq = 0;
      this.msc = 0;
      this.msq = false;
      this.msr = 0;
      this.mss = 0;
      this.mst = false;
      this.msu = false;
      this.msv = 0;
      this.msx = 0;
      this.msw = 0;
      this.mwr = -1;
      this.myn();
      this.mxc = -1;
      this.mxe = 0;
      this.mse = 0;
      this.msf = 0;
      this.msg = 0;
      this.msh = 0;
      this.msi = 0;
      this.msj = null;
      this.msk = false;
      this.msl.clear();
      this.msm.clear();
      this.msn = 0;
      this.mso = Double.MAX_VALUE;
      this.msp = -1;
      if (this.mc.field_1761 != null) {
         this.mc.field_1761.method_2925();
      }

      ptr.clear();
      this.mvk = null;
      this.muy = null;
      this.ndw();
      this.mud = 0;
      this.mue = 0;
      this.muf = 0;
      this.mug = 0;
      this.muh = 0;
      this.mui = -1;
      this.neb();
      this.mum = 0;
      this.mur = 0.0F;
      this.mus = false;
      this.mut = null;
      this.muu = -1;
      this.muv = 0;
      this.mvi = 0;
      this.mvj = 1200 + this.mty.nextInt(3000);
      this.mvc = 0;
      this.mvl.reset();
      this.mvm = null;
      this.mvd = 0.0;
      this.mve = false;
      this.mvf = 0;
      this.mvg = 0;
      this.mvy = false;
      this.mvz = null;
      this.mvx = 0;
      this.msy.clear();
      this.mrf = null;
      this.mrg = 0;
      this.mtb = 0;
      this.mtd = false;
      this.mte = 0;
      this.mtf = 0;
      this.mth = 0;
      this.mtj = 0;
      this.mti = null;
      this.mwf = 0;
      this.mwi = 0;
      this.mwj = null;
      this.mwl = -1;
      this.myy();
   }

   private void mxv() {
      this.mxw(true);
   }

   private void mxw(boolean var1) {
      this.mc.field_1690.field_1832.method_23481(var1);
      this.mc.field_1690.field_1904.method_23481(true);
      ptr.miss();
   }

   private void mxx() {
      if (this.mc.field_1690 != null) {
         this.mc.field_1690.field_1904.method_23481(false);
         this.mc.field_1690.field_1832.method_23481(false);
      }
   }

   private boolean mxy(float var1) {
      this.nby(this.mto ? this.mts : this.mtl.intentYaw(), var1);
      return Math.abs(this.mtl.intentPitch() - var1) <= 0.75F;
   }

   private boolean mxz() {
      boolean var1 = this.getPlayer().method_7344().method_7586() < 18;
      int var2 = this.nei(Items.field_8071);
      boolean var3 = this.nci();
      if (this.mtf == 0) {
         if (!var1 || var2 == -1) {
            if (this.mc.field_1690.field_1904.method_1434() && this.mqq != mpm.BRUSHING_SAND) {
               this.mxx();
               if (this.getPlayer().method_6047().method_7909() == Items.field_8071) {
                  this.nat();
               }
            }

            return false;
         }

         this.mtg = this.mtl.intentPitch();
         this.mtf = var3 ? 2 : 1;
         this.mth = 0;
      }

      if (this.mtf != 3 && (!var1 || var2 == -1)) {
         this.mxx();
         this.mtf = var3 ? 0 : 3;
         if (this.mtf == 0) {
            this.nat();
            return false;
         }
      }

      switch (this.mtf) {
         case 1:
            this.mxx();
            if (var3 || this.mxy(-55.0F)) {
               this.mtf = 2;
               this.mth = 0;
            }
            break;
         case 2:
            if (!var3) {
               this.mxy(-55.0F);
            }

            this.getPlayer().method_31548().method_61496(var2);
            this.mxw(!var3);
            this.mth++;
            if (this.mth > 200) {
               this.mxx();
               this.mtf = 3;
            }
            break;
         case 3:
            this.mxx();
            if (var3 || this.mxy(this.mtg)) {
               this.mtf = 0;
               this.nat();
               return false;
            }
      }

      return true;
   }

   private void mya() {
      if (this.nci()) {
         this.ncr();
         this.mc.field_1690.field_1867.method_23481(false);
         this.mc.field_1690.field_1903.method_23481(false);
      } else {
         pqf.resetKeys();
         this.ncf();
      }
   }

   private void myb() {
      this.mxx();
      this.mtf = 0;
      this.mth = 0;
   }

   private boolean myc(ItemStack var1) {
      return var1.method_7960() ? false : var1.method_7909() == Items.field_8071 || var1.method_7909() == Items.field_8705 || this.nel(var1) || this.neo(var1);
   }

   private void myd(mpm var1) {
      if (this.mqq != var1) {
         this.mqq = var1;
         this.mwn = "";
      }
   }

   private void mye(String var1) {
      if (!this.mvy) {
         this.mvy = true;
         this.mvx = 0;
         this.mqp++;
      }

      if (var1 != null && this.mvz == null) {
         this.mvz = var1;
      }
   }

   public void onChatMessage(String var1) {
      String var2 = var1.toLowerCase();
      if ((
            var2.contains(a.d("Ӄ絳\uf7a2榠\ue205撱\udee6", 1326943706, 1424723233))
               || var2.contains(a.b("ᔀ沰\ue661硣\uf3c6畿켥", 62787896))
               || var2.contains(a.b("ᢴ慼\uefc4疪ﹼ磀슘䭠픵徇", -234152820))
               || var2.contains(a.b("\ueedc靯᷍蟝ࡩ躪㓰봂", -664933658))
               || var2.contains(a.c(375933496, "乬㞠뵺⍾ꢫ⸔逫᷇莕ഴ軽璈著掐\ue9b7潊픀嫜쀝䘾쾼"))
         )
         && this.isEnabled()) {
         String var3 = null;
         if (var2.contains(a.b("崤ⓧ긽く뾃", -27960990))) {
            String[] var4 = var1.split(a.c(494879084, "䔪㳩똳⡁Ɥ"));
            if (var4.length > 1) {
               var3 = var4[1].split(a.c(-157270135, "㾨"))[0].replaceAll(a.b("⣔兠\udb8c䖱츱䢻\uf284笂\ue537澛\ue85cቋ鲞", 748693634), "");
               if (var3.isEmpty() && var4.length > 2) {
                  var3 = var4[2].split(a.c(-517122748, "啥"))[0].replaceAll(a.c(-1245765227, "⇃塷튛䲦윦䆬ﮓ爕\uec20暌\ue14b᭜閉"), "");
               }
            }
         }

         this.mxm = var3;
         this.mxl = this.mwa;
      }

      boolean var5 = var2.contains(a.d("┄峀혐", -166216364, 141335568))
            && (
               var2.contains(a.d("爃ெ腠ὣ钳ቷ", -691044894, 39127974))
                  || var2.contains(a.c(1326728985, "䌡㪑끈⸷ꗡ⌥饿"))
                  || var2.contains(a.d("\ue5a8鰔ᚲ袸ͥ藘㿱", 1649753657, -1362239573))
            )
         || var2.contains(a.b("죳녏㮂ꗤ⸷ꢃው魥չ迄ࠖ\uf267粻\ue50c潈\ue9a8另", 719046787));
      if (this.mqq == mpm.WARPING_TO_LOOT_BASE && !this.mro && var5) {
         this.mxd = true;
      }

      if (var5 && (this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.TELEPORT_TO_SAVE)) {
         this.mqo.dismiss(this.getWorld());
      }
   }

   private void myf() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 != this.mxn) {
         this.mxo = this.mwa;
      }

      this.mxn = var1;
   }

   private void myg() {
      int var1 = this.mxl;
      if (this.mwa - var1 <= 100) {
         ClientPlayerEntity var2 = this.getPlayer();
         boolean var3 = var2.method_29504() || var2.method_6032() <= 0.0F;
         boolean var4 = this.mqq == mpm.TELEPORT_TO_LOOT
            || this.mqq == mpm.TELEPORT_TO_SAVE
            || this.mqq == mpm.WARPING_TO_SAVE_BASE
            || this.mqq == mpm.WARPING_TO_LOOT_BASE && (this.mxc < 0 || this.mrn - this.mxc < 100);
         boolean var5 = !var4 && this.mxo >= var1 - 100;
         if (var3 || var5) {
            this.mxl = -100000;
            this.mye(this.mxm);
         }
      }
   }

   private boolean myh() {
      StatusEffectInstance var1 = this.getPlayer().method_6112(StatusEffects.field_5905);
      return var1 != null ? var1.method_5584() > 600 : false;
   }

   private boolean myi() {
      StatusEffectInstance var1 = this.getPlayer().method_6112(StatusEffects.field_5904);
      return var1 != null ? var1.method_5584() > 600 : false;
   }

   private int myj(boolean var1) {
      StatusEffectInstance var2 = this.getPlayer().method_6112(var1 ? StatusEffects.field_5905 : StatusEffects.field_5904);
      return var2 == null ? 0 : (var2.method_48559() ? Integer.MAX_VALUE : var2.method_5584());
   }

   private boolean myk(boolean var1) {
      int var2 = var1 ? 0 : 1;
      if (!this.mwy[var2] && this.mwu[var2] <= 0 && this.nab(var1) != 0) {
         int var3 = this.mww[var2] > 0 ? Math.min(600, this.mww[var2] * 3 / 4) : 600;
         return this.myj(var1) <= var3;
      } else {
         return false;
      }
   }

   private void myl() {
      for (int var1 = 0; var1 < 2; var1++) {
         boolean var2 = var1 == 0;
         int var3 = this.nab(var2);
         int var4 = this.myj(var2);
         if (this.mwt[var1] >= 0 && var3 < this.mwt[var1] && this.mwr == var1 && this.mwa - this.mws <= 3) {
            this.mwu[var1] = 60;
            this.mwv[var1] = var4;
            this.mwx[var1] = 0;
         }

         this.mwt[var1] = var3;
         if (this.mwu[var1] > 0) {
            if (var4 > this.mwv[var1]) {
               this.mwu[var1] = 0;
               this.mww[var1] = var4;
               if (var1 == 0) {
                  this.mxh = 0;
               }
            } else if (--this.mwu[var1] == 0) {
               this.mym(var1);
            }
         }
      }
   }

   private void mym(int var1) {
      if (!this.mwy[var1]) {
         this.mwy[var1] = true;
         if (var1 == 0) {
            this.mxh++;
            this.mxi = wap.s(
               a.c(-680538783, "촲뒟㹁ꁵ⯫굝\u1716黸½訖\u0dce\uf7b4祦\ue0d2檜\uec60噶\ud9f7䍛씑䳻㚬렞⎁ꖹ⽦雊ᢈ艩ѫ辖煆צּ拲\ue4a2渓퇇宰\udd74"),
               a.b("\uda5bꏨ⤵뜳㲝븹w覎៖鵭᪲\ue0cf渜\uf7af綃ﭱ䅄쪍吣퉺徘⇝꽯㒲늵㡧膤྄锅ጣ", -490348942)
            );
         }

         this.notifyUser(
            var1 == 0
               ? wap.s(
                  a.c(-1615131009, "\u0e69矤ﴺ挎\ue890渦푭嶃쏆䥭캵㓏먝⎩ꧧ⼛锍\u1a8c耠٪辀\uf5d7筥\ue0fa曂\uec15喱\udbf3䅁읞䳬뉲㡸ꆊ⟙굫ኺ飜ṛ蟧ඵ猊菱约\ue43c橏펁大\udf2d䒳쫉ぞ립㿰ꔎ⭗邥ᘠ鱏֟謲\uf130皗ﳀ戔\uebbc"),
                  a.c(1280103327, "ힷ긤⓹뫿ㅑ돵ර葂ᨚ邡\u177e\ued03提謹灏\uf6bd䲈읁姯\udfb6剔Ⱁꊦ㥼뼆㇉谗ɏ颸ẘ锤殍\ue1b0籑﨏炳쭵䄋쟝帛푀\uaacc⒊Ꜧ㷹랝ੑ肓۞饡ጀ\uedc3怙\ue647糈\uf29b䴸쿾䖊\udc2e勢⢹꽋")
               )
               : wap.s(
                  a.d("\ue5b6鰻ᛥ裑͕藧㾡뙐⠎ꋻ╸\udf16凚졶䈣쓓绒\uf144毱\uedb7摓ṇ邺୪赚ߎ빾〯ꫛⲌꜨ妭폯䨓찎䚾臘猚\uf5cb汧\ue62f颛ኇ锿ྮ膋㡄닸㒿꼣℄\udbc9剿퐴五삑笨\ufde2瞈", 471337304, 77327489),
                  a.c(-1089895976, "藳ﱠ皽\ue8bb挕\ue1b1徃혉䡒슝䔰뼾\u31eaꠡ♪ꒆề锅\u0ba2跷Ћ繟\uf4f2歎\ued38柩\ude2b偵쫺䳙썺㶦럤⨄걘⛬饌ጹ閗࠳虱\uf888盎\uf560濄\ue1b7尊튩僴콈䄴뮙㈬끡⺅ꃓᬙ鶳៊踚")
               ),
            false
         );
      }
   }

   private void myn() {
      for (int var1 = 0; var1 < 2; var1++) {
         this.mwu[var1] = 0;
         this.mwy[var1] = false;
         this.mwx[var1] = 0;
      }
   }

   private void myo(String var1) {
      this.mxg++;
      this.mxi = var1;
   }

   private boolean myp() {
      int var1 = Math.max(this.mxg, this.mxh);
      if (var1 < 3) {
         return false;
      } else {
         if (!this.mxj) {
            this.notifyUser(
               wap.s(
                  a.b("牕\u0bc3脋ὥ钲ሖꡄ⇫뾮", -214207985)
                     + var1
                     + a.b("态᧤錱൛蚕'먧㎟귇✸ꂪ媚퐟䶳쟸䅞ﭒ璁\uee3e桧\ue1d5鯆ᕶ躥࣒艈㮬뗣⼉ꥄ⊿\udc20噮쾄䧋썻粫\uf6d3灇\ue9fe", 372006921)
                     + this.mxi
                     + a.d(
                        "\uf846臰ଭ锿ể顿∪ꯓ㗇뼢㣭슑䰃헢微\ud944挖\uecc1癳\uf03f禗ϊ购ᛠ邒ᨆꏢⶥ띁ㄒ뫱䐯칯埖톂嬱\ue4ee滚\ue848燶ﮣ蔖༑袼ቦ鱒◀꽾⤾닼㲞완俲즯半\udd44曷\ue072樝\uf3c1絽ݢ胅ક鑝ᷰ\ua7ed⅕\uab1f㓺빦㠖솇䭷픢廕\ud88a戼",
                        -429999544,
                        637485673
                     ),
                  a.b("谋\uf5e5缵\ue136櫬\uec5e嘁\udff9䆨쬑䣅늮", -247953383)
                     + var1
                     + a.c(180115865, "妡␇껓プ뭻㷀螗੶逶᪆鵟杚\ue982灈️糬욮䤃펲嗠\udc16Ꙋⲗ띎")
                     + this.mxi
                     + a.d("랅츳䓮\udea0唨폧榸\ue04e繤\uf4d9睦褀ߕ鹪ᑎ銼Ⲑꍍ㷬뮿㈸䠖슺奤\udf14冠\ue868昻\uf8d0窙\uf532\u0ff3薱ᱍ驮ლ꽰━ꟊ㩣됤컇䒜쌬妎ퟶ湚\ue0f3拝殺眀距Ѩ", -1030383577, -1029689410)
               ),
               false
            );
            this.mxj = true;
         }

         return true;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.mwa++;
      if (this.isNotInWorld()) {
         if (this.mtn) {
            this.mtn = false;
            if (this.driver == null) {
               this.mtm.reset();
            }
         }

         this.mtw = null;
         this.mtx = null;
         this.mua = false;
         this.mub = false;
         this.muc = false;
         ptr.clear();
         this.mqt = 0L;
         this.mqx = -1;
      } else if (this.mxj) {
         this.mxj = false;
         pqf.resetKeys();
         if (this.driver != null) {
            this.setBotRunning(false);
            this.driver.halted();
         } else {
            this.setEnabled(false);
         }
      } else {
         this.myv();
         this.myw();
         pjd.keep(this.mxs());
         this.nbx();
         this.mtz = this.getPlayer().method_36454();
         this.mua = true;
         this.mvl.beginTick();
         boolean var2 = this.myq();
         if (var2 && this.mc.field_1690 != null) {
            this.mvp = this.mc.field_1690.field_1867.method_1434();
            this.mvq = this.mc.field_1690.field_1832.method_1434();
         }

         try {
            this.myz();
         } finally {
            if (var2) {
               this.myu();
            }

            this.nck();
            if (this.mud > 0 && this.mc.field_1690 != null) {
               this.mc.field_1690.field_1886.method_23481(false);
               this.mc.field_1690.field_1904.method_23481(false);
            }

            this.myx();
            this.mub = this.mc.field_1690 != null && this.mc.field_1690.field_1886.method_1434();
            this.muc = this.mc.field_1690 != null && this.mc.field_1690.field_1904.method_1434();
            if (this.driver == null) {
               pnf.publish(this.mvl.shown(), this.mvl.shownAt(), var2, var2 && this.myr(), this.mql.get(), this.getName());
            }
         }
      }
   }

   private boolean myq() {
      return this.driver == null && mqn == this && this.isEnabled() && tcz.walkGuide();
   }

   private boolean myr() {
      return this.mvr || this.getPlayer().method_6115() || this.ncm() || this.mrf != null || this.muw || this.mc.field_1755 != null;
   }

   private int mys(int var1) {
      return this.myq() ? var1 * 3 : var1;
   }

   private txs myt() {
      return lfa.walkModel(lex.END);
   }

   private void myu() {
      GameOptions var1 = this.mc.field_1690;
      if (var1 != null && !this.ncm() && this.mrf == null && !this.muw) {
         KeyBinding[] var2 = new KeyBinding[]{var1.field_1894, var1.field_1881, var1.field_1913, var1.field_1849, var1.field_1903};

         for (KeyBinding var6 : var2) {
            var6.method_23481(this.heldByHuman(var6));
         }

         if ((Boolean)var1.method_42450().method_41753()) {
            if (var1.field_1867.method_1434() != this.mvp) {
               var1.field_1867.method_23481(true);
            }
         } else {
            var1.field_1867.method_23481(this.heldByHuman(var1.field_1867));
         }

         if ((Boolean)var1.method_42449().method_41753()) {
            if (var1.field_1832.method_1434() != this.mvq) {
               var1.field_1832.method_23481(true);
            }
         } else {
            var1.field_1832.method_23481(this.heldByHuman(var1.field_1832));
         }
      }
   }

   private void myv() {
      long var1 = System.currentTimeMillis();
      if (this.mqt != 0L) {
         long var3 = var1 - this.mqt;
         if (var3 > 0L && var3 < 5000L) {
            this.mqs += var3;
         }
      }

      this.mqt = var1;
   }

   private void myw() {
      PlayerInventory var1 = this.getPlayer().method_31548();
      int var2 = 0;

      for (int var3 = 0; var3 < var1.method_5439(); var3++) {
         ItemStack var4 = var1.method_5438(var3);
         if (ndf(var4)) {
            var2 += var4.method_7947();
         }
      }

      boolean var5 = this.mqq == mpm.FARMING
         || this.mqq == mpm.LOOTING_VASE
         || this.mqq == mpm.FARMING_SAND
         || this.mqq == mpm.BRUSHING_SAND
         || this.mqq == mpm.LOOTING_SAND
         || this.mqq == mpm.CHECK_PVP_COOLDOWN
         || this.mqq == mpm.ESCAPING
         || this.mqq == mpm.RUN_TO_FARM_COORDS;
      boolean var6 = this.getPlayer().field_7512 != this.getPlayer().field_7498;
      if (this.mqx >= 0 && var2 > this.mqx && var5 && !var6) {
         this.mqw = this.mqw + (var2 - this.mqx);
      }

      this.mqx = var2;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.mc.field_1690 != null) {
         this.mc.field_1690.field_1886.method_23481(this.mub);
         this.mc.field_1690.field_1904.method_23481(this.muc);

         while (this.mc.field_1690.field_1886.method_1436()) {
         }

         while (this.mc.field_1690.field_1904.method_1436()) {
         }

         if (this.mud > 0) {
            this.silenceMovement();
         }

         if (this.mc.field_1724 != null && this.mc.field_1687 != null) {
            if (this.driver == null && !this.mux && this.mua && this.mtn && this.mud == 0) {
               this.mtm.remapHumanKeys(this.mc, this.mtm.cameraYaw(this.mc.field_1724), this.mtu);
            }

            ptr.applyOwn(this.mc);
         }
      }
   }

   private void myx() {
      if (this.mc.field_1690 != null && this.mud <= 0) {
         KeyBinding[] var1 = new KeyBinding[]{
            this.mc.field_1690.field_1894,
            this.mc.field_1690.field_1881,
            this.mc.field_1690.field_1913,
            this.mc.field_1690.field_1849,
            this.mc.field_1690.field_1903,
            this.mc.field_1690.field_1832,
            this.mc.field_1690.field_1867
         };

         for (KeyBinding var5 : var1) {
            if (this.heldByHuman(var5)) {
               var5.method_23481(true);
            }
         }
      }
   }

   private void myy() {
      if (this.mc.field_1690 != null) {
         KeyBinding[] var1 = new KeyBinding[]{
            this.mc.field_1690.field_1894,
            this.mc.field_1690.field_1881,
            this.mc.field_1690.field_1913,
            this.mc.field_1690.field_1849,
            this.mc.field_1690.field_1903,
            this.mc.field_1690.field_1867,
            this.mc.field_1690.field_1832,
            this.mc.field_1690.field_1886,
            this.mc.field_1690.field_1904
         };

         for (KeyBinding var5 : var1) {
            if (!this.heldByHuman(var5)) {
               var5.method_23481(false);
            }
         }
      }
   }

   private void myz() {
      this.muy = null;
      this.mux = false;
      this.mry = false;
      if (this.mse > 0) {
         this.mse--;
      }

      if (this.mum > 0) {
         this.mum--;
      }

      this.mur *= 0.99F;
      if (this.msf > 0) {
         this.msf--;
      }

      if (this.msg > 0) {
         this.msg--;
      }

      if (this.msh > 0) {
         this.msh--;
      }

      this.ndn();
      this.myf();
      this.myg();
      this.myl();
      if (this.mvy) {
         this.mvx++;
         if (this.mvx >= 40) {
            this.mvy = false;
            this.mxu();
            this.myd(mpm.TELEPORT_TO_SAVE);
         }
      } else if (this.mqq != mpm.TELEPORT_TO_SAVE
         && this.mqq != mpm.WARPING_TO_SAVE_BASE
         && this.mqo.check(this.getPlayer(), System.currentTimeMillis(), 6000L)) {
         pjd.leave(this.mxs());
         this.mxu();
         this.myd(mpm.TELEPORT_TO_SAVE);
         this.notifyUser(a.c(1922611007, "댅캆䁎\ude3a嗢퍓椉\ue4e0窷\uf414珃覰ݤ黚ᓸ陨⠵ꏶ㴤묏㋽䣐옑嶵\udfa6啾쳹抜ﱳ種\uf1ea\u0b58蔊ᳶ麵ၥ꿆▻ꍣ㻀") + nak(this.mqh.get()), false);
      } else if (!this.mza()) {
         boolean var1 = this.mqq != mpm.WARPING_TO_LOOT_BASE && this.mqq != mpm.WARPING_TO_SAVE_BASE && this.mqq != mpm.RESTOCK_AND_DUMP;
         if (this.mwo != null
            && this.getPlayer().method_73189().method_1025(this.mwo) < 1.0E-4
            && var1
            && this.mvi <= 0
            && this.mud == 0
            && !this.myq()
            && (this.mc.field_1690.field_1894.method_1434() || this.mqy != null)) {
            this.mwp++;
            if (this.mwp > 6 && this.getPlayer().method_24828() && pqf.isJumpUseful(this.ncj())) {
               this.mc.field_1690.field_1903.method_23481(true);
            }

            if (this.mwp > 16) {
               this.mqy = null;
               this.mqz = 0;
               this.mse = 0;
               this.mwp = 0;
               this.mwq++;
               if (this.mwq >= 3) {
                  this.mwq = 0;
                  if (this.mrr != null) {
                     this.nay(true);
                  } else if (this.mrz != null) {
                     this.ncz(true);
                  }
               }
            }
         } else {
            if (this.mwp > 0) {
               this.mwq = 0;
            }

            this.mwp = 0;
            this.mwo = this.getPlayer().method_73189();
         }

         this.mwf = pqf.onClimbable(this.getPlayer()) ? this.mwf + 1 : 0;
         if (this.mc.field_1755 instanceof AbstractSignEditScreen) {
            this.mc.field_1755.method_25419();
         } else if (this.mqq != mpm.RESTOCK_AND_DUMP && this.mc.field_1755 instanceof HandledScreen && !(this.mc.field_1755 instanceof InventoryScreen)) {
            this.mxx();
            this.mc.field_1724.method_7346();
         } else {
            this.mc.field_1690.field_1832.method_23481(this.mc.field_1690.field_1904.method_1434() && this.myc(this.getPlayer().method_6047()) && !this.nci());
            if (!(this.getPlayer().method_6032() <= 0.0F) && !this.getPlayer().method_29504()) {
               if (this.mte > 0) {
                  this.mte--;
               }

               if (this.getPlayer().field_6017 > 3.0) {
                  this.mtd = true;
               } else if (this.mtd) {
                  this.mtd = false;
                  this.mte = 6;
               }

               float var2 = this.getPlayer().method_6032();
               if (var2 < this.mtc
                  && this.mte <= 0
                  && this.mqq != mpm.ESCAPING
                  && this.mqq != mpm.TELEPORT_TO_SAVE
                  && this.mqq != mpm.WARPING_TO_SAVE_BASE
                  && this.mqq != mpm.RESTOCK_AND_DUMP
                  && this.mqq != mpm.WARPING_TO_LOOT_BASE
                  && this.mzh()) {
                  this.myd(mpm.ESCAPING);
                  this.mru = 0;
                  this.mrv = 0;
                  this.mrw = 0;
                  this.mqy = null;
                  this.mqz = 0;
               }

               this.mtc = var2;
               if (this.ndj()) {
                  this.mwb = this.mwa;
               }

               if (!this.mst && !this.mc.field_1690.field_1904.method_1434()) {
                  this.nee();
                  this.ndo();
                  if (this.muk == -1 && !this.ncm() && !this.muw && this.mqq != mpm.BRUSHING_SAND && this.mqq != mpm.ESCAPING) {
                     ItemStack var3 = this.getPlayer().method_6047();
                     if (!var3.method_7960()
                        && !var3.method_7909().method_7876().contains(a.b("馄\ue031櫺\uf496罗", -2090100238))
                        && !var3.method_7909().method_7876().contains(a.b("ﾂ蘿೮銙", -937033749))
                        && var3.method_7909() != Items.field_8071
                        && !this.nel(var3)
                        && !this.neo(var3)) {
                        this.nat();
                     }
                  }
               } else {
                  this.neb();
               }

               if (this.mud > 0) {
                  this.ndp();
                  if (this.mud > 0) {
                     pqf.resetKeys();
                     return;
                  }
               }

               if (this.mtb > 0) {
                  this.mtb--;
               } else if (this.mrf != null) {
                  pqf.resetKeys();
                  this.mzx();
               } else if (!this.msy.isEmpty()) {
                  pqf.resetKeys();
                  if (++this.muj > 400) {
                     this.msy.clear();
                     this.msz = 0;
                     this.muj = 0;
                     this.mzy();
                     if (this.mc.field_1724 != null && this.mc.field_1755 != null) {
                        this.mc.field_1724.method_7346();
                     }
                  } else {
                     this.msz++;
                     boolean var8 = this.mc.field_1755 instanceof GenericContainerScreen;
                     if (this.msz >= (var8 ? 4 : 2)) {
                        this.msy.poll().run();
                        this.msz = 0;
                        this.mtb = var8 ? 2 + this.mty.nextInt(5) : 1 + this.mty.nextInt(3);
                     }
                  }
               } else {
                  this.muj = 0;
                  if (this.mud == 0) {
                     this.ndw();
                  }

                  if (!this.mst && this.mqq != mpm.ESCAPING && this.mzh()) {
                     boolean var7 = this.myk(true);
                     boolean var4 = this.mqg.get() && this.myk(false);
                     if (var7 || var4) {
                        int var5 = -1;
                        if (var7) {
                           var5 = this.nej();
                           if (var5 == -1) {
                              int var6 = this.nek();
                              if (var6 != -1 && this.msy.isEmpty()) {
                                 this.nau(var6);
                              }

                              if (var6 != -1) {
                                 return;
                              }

                              var7 = false;
                           }
                        }

                        if (!var7 && var4) {
                           var5 = this.nem();
                           if (var5 == -1) {
                              int var10 = this.nen();
                              if (var10 != -1 && this.msy.isEmpty()) {
                                 this.nau(var10);
                              }

                              if (var10 != -1) {
                                 return;
                              }

                              var4 = false;
                           }
                        }

                        if (var5 != -1) {
                           pqf.resetKeys();
                           if (this.getPlayer().method_31548().method_67532() != var5) {
                              this.getPlayer().method_31548().method_61496(var5);
                              this.mxx();
                              this.msw = 0;
                              return;
                           }

                           int var11 = var7 ? 0 : 1;
                           this.msw++;
                           if (this.getPlayer().method_31548().method_5438(var5).method_31574(Items.field_8574) || this.mxy(86.0F) && !(this.mtv < 78.0F)) {
                              this.mwr = var11;
                              this.mws = this.mwa;
                              this.mxv();
                              if (!this.getPlayer().method_6115() && this.msw % 5 == 0) {
                                 ptr.later(() -> {
                                    if (this.mc.field_1724 != null && this.mc.field_1761 != null && !this.mc.field_1724.method_6115()) {
                                       this.mc.field_1761.method_2919(this.mc.field_1724, Hand.field_5808);
                                    }
                                 });
                              }

                              if (this.msw > 100) {
                                 this.mxx();
                                 this.mzm();
                                 this.msw = 0;
                                 if (++this.mwx[var11] >= 3) {
                                    this.mym(var11);
                                 }
                              }

                              return;
                           }

                           this.mxx();
                           if (this.msw > 100) {
                              this.msw = 0;
                              if (++this.mwx[var11] >= 3) {
                                 this.mym(var11);
                              }
                           }

                           return;
                        }
                     }

                     if (this.msw > 0) {
                        this.mxx();
                        this.mzm();
                        this.msw = 0;
                        this.mwr = -1;
                        if (this.muk == -1) {
                           this.nat();
                        }
                     }
                  }

                  if (!this.mst && this.mqq != mpm.ESCAPING) {
                     if (this.mxz()) {
                        this.mya();
                        return;
                     }
                  } else if (this.mtf != 0) {
                     this.myb();
                  }

                  if (this.mqf.get() && this.nde() && (this.mqq == mpm.FARMING || this.mqq == mpm.LOOTING_VASE)) {
                     this.mc.field_1690.field_1886.method_23481(false);
                     this.mc.field_1690.field_1904.method_23481(false);
                     if (this.mc.field_1761 != null) {
                        this.mc.field_1761.method_2925();
                     }

                     this.mrr = null;
                     this.msu = false;
                     this.msi = 0;
                     this.msx = 0;
                     this.mqy = null;
                     this.mqz = 0;
                     this.myd(mpm.FARMING_SAND);
                  }

                  if ((
                        this.mqq == mpm.FARMING
                           || this.mqq == mpm.FARMING_SAND
                           || this.mqq == mpm.LOOTING_VASE
                           || this.mqq == mpm.LOOTING_SAND
                           || this.mqq == mpm.BRUSHING_SAND
                           || this.mqq == mpm.RUN_TO_FARM_COORDS
                     )
                     && !this.mzh()) {
                     if (this.mwa % 60 == 0) {
                        this.myd(mpm.TELEPORT_TO_SAVE);
                     }
                  } else if (!var1 || this.mqq == mpm.ENTER_PORTAL || this.myq() || !this.mze()) {
                     switch (this.mqq) {
                        case RESTOCK_AND_DUMP:
                           this.mzl();
                           break;
                        case TELEPORT_TO_LOOT:
                           this.nam();
                           break;
                        case WARPING_TO_LOOT_BASE:
                           this.nao();
                           break;
                        case ENTER_PORTAL:
                           this.naq();
                           break;
                        case RUN_TO_FARM_COORDS:
                           this.nar();
                           break;
                        case FARMING:
                           this.nax();
                           break;
                        case LOOTING_VASE:
                           this.nbq();
                           break;
                        case FARMING_SAND:
                           this.ncy();
                           break;
                        case BRUSHING_SAND:
                           this.ndc();
                           break;
                        case LOOTING_SAND:
                           this.ndd();
                           break;
                        case CHECK_PVP_COOLDOWN:
                           this.ndh();
                           break;
                        case TELEPORT_TO_SAVE:
                           this.ndk();
                           break;
                        case WARPING_TO_SAVE_BASE:
                           this.ndl();
                           break;
                        case ESCAPING:
                           this.mzi();
                     }

                     if (!this.myq()) {
                        this.mzb(var1);
                     }
                  }
               }
            } else {
               if (this.mqq != mpm.TELEPORT_TO_SAVE && this.mqq != mpm.WARPING_TO_SAVE_BASE && !this.mvy) {
                  this.mye(null);
               }
            }
         }
      }
   }

   private boolean mza() {
      if (this.mtk > 0) {
         this.mtk--;
      }

      Vec3d var1 = this.getPlayer().method_73189();
      if (this.mti != null && !(var1.method_1025(this.mti) > 2.25)) {
         this.mtj++;
         if (this.mqq == mpm.RESTOCK_AND_DUMP && this.mxk) {
            this.mtj = 0;
            return false;
         } else if (this.mtj >= 2400 && this.mtk <= 0) {
            pqf.resetKeys();
            this.mxx();
            if (this.mc.field_1724 != null && this.mc.field_1755 != null) {
               this.mc.field_1724.method_7346();
            }

            if (this.mqq == mpm.WARPING_TO_LOOT_BASE
               || this.mqq == mpm.ENTER_PORTAL
               || this.mqq == mpm.RUN_TO_FARM_COORDS
               || this.mqq == mpm.RESTOCK_AND_DUMP
               || this.mqq == mpm.WARPING_TO_SAVE_BASE) {
               this.myo(
                  wap.s(a.b("羵\u0603賋ኺ饦ᾓꖓⱥ눧㢓뽀䕽쯬剔\ud81a庹\ue4e4欧\uf1d9瞌ﹼ萶\u0a84酄ᜭ", 1031176159), a.c(-906289479, "\u1aef捝\ue9f2矲ﱑ绻삵䥉팆嶫\uda71⁴꺠㝦뤠㿃薞๓铤ኰ鬹\ue169濓"))
               );
               if (this.myp()) {
                  return true;
               }
            }

            this.mxu();
            this.mti = var1;
            this.mtk = 600;
            this.myd(mpm.TELEPORT_TO_SAVE);
            return true;
         } else {
            return false;
         }
      } else {
         this.mti = var1;
         this.mtj = 0;
         return false;
      }
   }

   private void mzb(boolean var1) {
      boolean var2 = this.mc.field_1690.field_1894.method_1434();
      if (var1 && var2 && pqf.isBlockedHorizontally()) {
         this.mrw++;
         if (this.mrw >= 8) {
            this.mux = true;
            if (this.mrw % 20 == 0) {
               this.mrx = -this.mrx;
            }

            if (this.mrx > 0) {
               this.mc.field_1690.field_1849.method_23481(true);
               this.mc.field_1690.field_1913.method_23481(false);
            } else {
               this.mc.field_1690.field_1913.method_23481(true);
               this.mc.field_1690.field_1849.method_23481(false);
            }

            if (this.mrw > 30) {
               this.mrw = 0;
               this.mqy = null;
               this.mqz = 0;
               this.mse = 0;
               this.mrv = (this.mrv + 1) % mpu.length;
            }
         }
      } else {
         this.mrw = 0;
         if (!this.mry) {
            this.mc.field_1690.field_1913.method_23481(false);
            this.mc.field_1690.field_1849.method_23481(false);
         }
      }
   }

   private void mzc(float var1) {
      float var2 = 1.0F;
      float var3 = 0.0F;
      float var4 = Float.MAX_VALUE;

      for (float var5 = -1.0F; var5 <= 1.0F; var5++) {
         for (float var6 = -1.0F; var6 <= 1.0F; var6++) {
            if (var5 != 0.0F || var6 != 0.0F) {
               double var7 = Math.toDegrees(pud.inputDirection(this.mtu, var5, var6));
               float var9 = Math.abs(MathHelper.method_15393((float)var7 - var1));
               if (var9 < var4) {
                  var4 = var9;
                  var2 = var5;
                  var3 = var6;
               }
            }
         }
      }

      this.mux = true;
      this.mry = true;
      this.mc.field_1690.field_1894.method_23481(var2 > 0.0F);
      this.mc.field_1690.field_1881.method_23481(var2 < 0.0F);
      this.mc.field_1690.field_1913.method_23481(var3 > 0.0F);
      this.mc.field_1690.field_1849.method_23481(var3 < 0.0F);
   }

   private static float mzd(double var0, double var2) {
      return (float)Math.toDegrees(Math.atan2(-var0, var2));
   }

   private boolean mze() {
      if (this.mwf < 6) {
         return false;
      } else {
         ClientPlayerEntity var1 = this.getPlayer();
         if (this.nci() && pqf.getStandY(this.mqy.get(this.mqz)) > var1.method_23318() + 0.6) {
            return false;
         } else {
            this.mqy = null;
            this.mqz = 0;
            this.mse = 0;
            this.ncf();
            Vec3d var2 = pqf.awayFromClimbable(var1);
            pqf.resetKeys();
            this.mzc(var2 != null ? mzd(var2.field_1352, var2.field_1350) : this.ncj() + 180.0F);
            this.mc.field_1690.field_1867.method_23481(false);
            if (this.mwf > 200) {
               this.mwf = 0;
               if (this.mrr != null) {
                  this.nay(true);
               } else if (this.mrz != null) {
                  this.ncz(true);
               }
            }

            return true;
         }
      }
   }

   private void mzf() {
      if (pqf.onClimbable(this.getPlayer()) && this.mc.field_1690 != null) {
         this.mc.field_1690.field_1832.method_23481(true);
      }
   }

   private void mzg() {
      if (Math.abs(this.mtl.intentPitch() - this.mwg) > 6.0F) {
         this.nbz(this.mtl.intentYaw(), this.mwg, true);
      } else {
         this.ncf();
      }
   }

   private boolean mzh() {
      if (this.mc.field_1687 != null && this.getPlayer() != null) {
         String var1 = this.mc.field_1687.method_27983().method_29177().toString().toLowerCase();
         Optional var2 = this.mc.field_1687.method_23753(this.getPlayer().method_24515()).method_40230();
         String var3 = var2.isPresent() ? ((RegistryKey)var2.get()).method_29177().toString().toLowerCase() : "";
         return var1.contains(a.b("얇밽㛤", -832584223)) || var3.contains(a.c(-30972929, "掙ᨣ郺"));
      } else {
         return false;
      }
   }

   private void mzi() {
      this.mru++;
      this.mc.field_1690.field_1886.method_23481(false);
      this.mxx();
      if (this.mc.field_1761 != null) {
         this.mc.field_1761.method_2925();
      }

      PlayerEntity var1 = this.neh();
      double var2 = var1 != null ? var1.method_5858(this.getPlayer()) : Double.MAX_VALUE;
      if (this.mru > 20 && var2 > 1600.0) {
         pqf.resetKeys();
         this.myd(mpm.FARMING);
      } else {
         boolean var4 = this.mqy == null || this.mqz >= this.mqy.size() || this.mru % 25 == 0;
         if (var1 != null && var4 && this.mse <= 0) {
            this.mse = 10;
            this.mzk(var1);
         }

         if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
         } else if (var1 != null) {
            Vec3d var5 = this.mzj(this.getPlayer().method_73189().method_1020(var1.method_73189()).method_1029(), Math.toRadians(mpu[this.mrv]));
            Vec3d var6 = this.getPlayer().method_73189().method_1019(var5.method_1021(12.0));
            this.ncp(new Vec3d(var6.field_1352, this.getPlayer().method_23318(), var6.field_1350));
         } else {
            this.ncf();
            this.mux = true;
            this.mc.field_1690.field_1894.method_23481(true);
            pyd.setSprint(this.mc.field_1690, true);
         }

         if (this.mru > 200) {
            pqf.resetKeys();
            this.myd(mpm.FARMING);
         }
      }
   }

   private Vec3d mzj(Vec3d var1, double var2) {
      double var4 = Math.cos(var2);
      double var6 = Math.sin(var2);
      return new Vec3d(var1.field_1352 * var4 - var1.field_1350 * var6, 0.0, var1.field_1352 * var6 + var1.field_1350 * var4).method_1029();
   }

   private void mzk(PlayerEntity var1) {
      Vec3d var2 = this.getPlayer().method_73189().method_1020(var1.method_73189()).method_1029();
      BlockPos var3 = this.getPlayer().method_24515();

      for (int var4 = 0; var4 < 3; var4++) {
         int var5 = (this.mrv + var4) % mpu.length;
         double var6 = mpu[var5] + this.mty.nextGaussian() * 12.0;
         Vec3d var8 = this.mzj(var2, Math.toRadians(var6));
         double var9 = 26.0 + this.mty.nextDouble() * 12.0;
         BlockPos var11 = this.nbd(var3.method_10069((int)(var8.field_1352 * var9), 0, (int)(var8.field_1350 * var9)));
         List var12 = this.nbb(var3, var11);
         if (var12 != null && var12.size() >= 5) {
            this.nbc(var12);
            this.mrv = var5;
            return;
         }
      }

      this.mrv = (this.mrv + 3) % mpu.length;
      this.mqy = null;
      this.mqz = 0;
   }

   private void mzl() {
      this.mst = false;
      if (!this.mrj && this.nab(true) == 1) {
         this.mrj = true;
      }

      if (this.mqg.get()) {
         if (!this.mrk && this.nab(false) == 1) {
            this.mrk = true;
         }
      } else if (!this.mrk) {
         this.mrk = true;
      }

      this.mzm();
      if (this.mrh && this.mri && this.mrj && this.mrk) {
         if (this.nab(true) != 0 || this.myh() && this.mzn(a.b("㑫䷟윃奸튠", 654192726)) == null) {
            this.mxk = false;
            if (this.myp()) {
               pqf.resetKeys();
               this.mzg();
            } else {
               this.myd(mpm.TELEPORT_TO_LOOT);
            }
         } else {
            if (!this.mxk) {
               this.mxk = true;
               this.notifyUser(a.d("鿨\ue671法\uf6c6礌ﾵ䗡찚剉\ud8f4弣ꕐ⯸뉊㡣몊Ә謄ᖧ韧ḑ摇\ueaf6甲\uf340禜쐹䩪탸囄", -1102847731, -54035738), false);
            }

            this.mrj = false;
            this.msh = 600;
         }
      } else {
         if (this.mrl != null && !(this.mc.field_1755 instanceof GenericContainerScreen) && this.mwa - this.mwh > 400) {
            this.mrl = null;
            this.mqy = null;
            this.mc.field_1690.field_1904.method_23481(false);
            this.msh = 40;
            if (++this.mwi >= 3) {
               this.mwi = 0;
               this.mzq(this.mrm);
            }
         }

         if (this.mrl == null) {
            String var1 = !this.mrh ? a.c(2114532074, "㚮佯엍寂큪") : this.mzz();
            if (this.msh > 0) {
               pqf.resetKeys();
               this.mzg();
               return;
            }

            BlockPos var2 = this.mzn(var1);
            if (var2 != null) {
               this.mrl = var2;
               this.mrm = var1;
               this.mwh = this.mwa;
               this.mvg = 0;
               this.nch();
               this.naz(this.mrl, true);
            } else {
               this.msh = 10;
               if (!var1.equals(a.d("\uf6b8轹כ鯔ၼ", -1752978973, 1464163103)) && this.mzn(a.d("헿갾⚜뢓㌻", -994787763, -1967493130)) != null) {
                  this.mzq(var1);
               }

               pqf.resetKeys();
               this.mzg();
            }
         } else if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
         } else {
            pqf.resetKeys();
            Vec3d var5 = this.nbo(this.mrl);
            this.ncb(this.mrl, var5 != null ? var5 : Vec3d.method_24953(this.mrl));
            if (this.mc.field_1755 instanceof GenericContainerScreen var6 && !this.mzp(var6)) {
               this.mc.field_1724.method_7346();
               return;
            }

            if (!(this.mc.field_1755 instanceof GenericContainerScreen)) {
               BlockHitResult var7 = this.nco(this.mrl);
               boolean var9 = false;
               if (var7 != null && this.mvc > 0) {
                  this.mvc--;
               } else if (var7 != null) {
                  var9 = System.currentTimeMillis() - this.mta > 500L;
               } else {
                  this.mvg++;
                  if (this.mvg > 40 && this.getPlayer().method_24515().method_10262(this.mrl) < 16.0 && System.currentTimeMillis() - this.mta > 500L) {
                     BlockHitResult var4 = this.mzr(this.mrl);
                     if (var4 != null) {
                        ptr.later(() -> {
                           if (this.mc.field_1761 != null && this.mc.field_1724 != null && this.mc.field_1755 == null) {
                              this.mc.field_1761.method_2896(this.mc.field_1724, Hand.field_5808, var4);
                              this.mc.field_1724.method_6104(Hand.field_5808);
                           }
                        });
                        this.mta = System.currentTimeMillis();
                        this.mzo(this.mrl);
                     }
                  }
               }

               if (var9) {
                  this.mta = System.currentTimeMillis();
                  this.mzo(this.mrl);
               }

               this.mc.field_1690.field_1904.method_23481(var9);
            } else {
               this.mc.field_1690.field_1904.method_23481(false);
               GenericContainerScreen var8 = (GenericContainerScreen)this.mc.field_1755;
               if (this.mrm.equals(a.c(-1340484654, "힖깗⓵뫺ㅒ"))) {
                  this.mzt(var8);
                  this.msy.add(() -> {
                     this.mrh = true;
                     this.mc.field_1724.method_7346();
                     this.mrl = null;
                  });
               } else if (this.mrm.equals(a.d("륌샼䨫", 1143429311, 1234232773))) {
                  if (this.msy.isEmpty()) {
                     int var10 = 0;

                     for (int var11 = 0; var11 < this.getPlayer().method_31548().method_5439(); var11++) {
                        if (this.getPlayer().method_31548().method_5438(var11).method_7909() == Items.field_8071) {
                           var10 += this.getPlayer().method_31548().method_5438(var11).method_7947();
                        }
                     }

                     if (var10 > this.mre && this.mrc < 4) {
                        this.mrc++;
                        if (!this.nae(var8, var0 -> var0.method_7909() == Items.field_8071)) {
                           this.mrc = 4;
                        }
                     } else if (var10 < this.mre && this.mrc < 4) {
                        this.mrc++;
                        if (!this.mzw(var8, this.mre - var10)) {
                           this.mrc = 0;
                           this.msy.add(() -> {
                              this.mri = true;
                              this.mc.field_1724.method_7346();
                              this.mrl = null;
                           });
                        }
                     } else {
                        this.mrc = 0;
                        this.msy.add(() -> {
                           this.mri = true;
                           this.mc.field_1724.method_7346();
                           this.mrl = null;
                        });
                     }
                  }
               } else if ((this.mrm.equals(a.c(-1903551165, "\u197e惊\uea16瑭ﾵ")) || this.mrm.equals(a.c(1399297998, "鎇\uea4d悚ﺕ甼\uf3f2䦢쁝")))
                  && this.msy.isEmpty()) {
                  this.naf(var8, this.mrm.equals(a.b("᷅摱\ueead烖\ufb0e", 453450232)));
               }
            }
         }
      }
   }

   private void mzm() {
      if (this.mc.field_1755 == null && !this.msu && !this.mus) {
         for (int var1 = 0; var1 < 9; var1++) {
            if (this.getPlayer().method_31548().method_5438(var1).method_7909() == Items.field_8469) {
               if (this.muk == -1 && this.mum <= 0 && this.ndx()) {
                  this.ndz(var1);
               }

               return;
            }
         }

         if (this.msy.isEmpty() && this.mud <= 0) {
            for (int var3 = 9; var3 < 36; var3++) {
               if (this.getPlayer().method_31548().method_5438(var3).method_7909() == Items.field_8469) {
                  int var2 = var3;
                  this.msy.add(() -> this.ndv(var2, 1, SlotActionType.field_7795));
                  return;
               }
            }
         }
      }
   }

   private BlockPos mzn(String var1) {
      if (this.getWorld() != null && this.getPlayer() != null) {
         String[] var2 = switch (var1) {
            case a.b("椆Ⴒ驮Е迍", -467702469) -> new String[]{a.d("↲堆틚䲡읹", -1600239057, -2112458848), a.d("ᎇ樾\ue0ea纑\uf54a珷즠", 1042776697, 1667798468)};
            case a.c(738142290, "Ⱋ嗑\udf06䄉쪠䱮\uf63e翁") -> new String[]{a.b("侬㙦벱⊾ꤗ\u2fd9閉", -1858057238)};
            default -> new String[]{var1};
         };
         return pte.find(this.mc, this.getPlayer().method_24515(), var2);
      } else {
         return null;
      }
   }

   private void mzo(BlockPos var1) {
      this.mwj = var1;
      this.mwk = System.currentTimeMillis();
   }

   private boolean mzp(GenericContainerScreen var1) {
      int var2 = ((GenericContainerScreenHandler)var1.method_17577()).field_7763;
      if (var2 == this.mwl) {
         return true;
      } else if (this.mwj != null && this.mwj.equals(this.mrl) && System.currentTimeMillis() - this.mwk <= 3000L) {
         BlockState var3 = this.getWorld().method_8320(this.mwj);
         if (!(var3.method_26204() instanceof ChestBlock)) {
            return false;
         } else {
            int var4 = var3.method_11654(ChestBlock.field_10770) == ChestType.field_12569 ? 27 : 54;
            if (((GenericContainerScreenHandler)var1.method_17577()).method_17388() * 9 != var4) {
               return false;
            } else {
               this.mwl = var2;
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private void mzq(String var1) {
      switch (var1) {
         case a.b("ާ繦\uf4c4櫋\ue163", 1934820323):
            this.mrh = true;
            break;
         case a.d("⳻啋\udf9c", -1908903790, -122136481):
            this.mri = true;
            break;
         case a.c(815252782, "섓뢧㉻가⟘"):
            this.mrj = true;
            break;
         case a.c(1940035325, "銴\ueb7e憩ﾦ琏\uf2c1䢑셮"):
            this.mrk = true;
      }
   }

   private BlockHitResult mzr(BlockPos var1) {
      Vec3d var2 = this.getPlayer().method_33571();
      Vec3d var3 = Vec3d.method_24953(var1);
      BlockHitResult var4 = this.getWorld().method_17742(new RaycastContext(var2, var3, ShapeType.field_17558, FluidHandling.field_1348, this.getPlayer()));
      if (var4.method_17783() == Type.field_1332 && var4.method_17777().equals(var1)) {
         return var4;
      } else if (this.mvg <= 80) {
         return null;
      } else {
         Direction var5 = Direction.method_10142(var2.field_1352 - var3.field_1352, var2.field_1351 - var3.field_1351, var2.field_1350 - var3.field_1350);
         Vec3d var6 = var3.method_1031(var5.method_10148() * 0.5, var5.method_10164() * 0.5, var5.method_10165() * 0.5);
         return new BlockHitResult(var6, var5, var1, false);
      }
   }

   private boolean mzs(BlockPos var1) {
      if (this.getWorld() == null) {
         return false;
      } else {
         String var2 = this.getWorld().method_8320(var1).method_26204().method_63499().toLowerCase();
         return var2.contains(a.d("\uf851臫ଵ镒Ẃ", 842418189, 574402618)) && !var2.contains(a.b("泉ᕳ龪ǚ訚ಆ뛩㼓ꅁ⯦갲", 1928031399));
      }
   }

   private void mzt(GenericContainerScreen var1) {
      int var2 = this.mzv(Items.field_8071);
      int var3 = ((GenericContainerScreenHandler)var1.method_17577()).method_7629().method_5439();

      for (int var4 = var3; var4 < ((GenericContainerScreenHandler)var1.method_17577()).field_7761.size(); var4++) {
         Slot var5 = (Slot)((GenericContainerScreenHandler)var1.method_17577()).field_7761.get(var4);
         if (var5.field_7871 == this.getPlayer().method_31548() && var5.method_34266() < 36) {
            ItemStack var6 = var5.method_7677();
            if (!var6.method_7960()
               && !var6.method_31574(Items.field_42716)
               && !var6.method_31574(Items.field_8469)
               && !this.isTrashItem(var6)
               && !this.nel(var6)
               && !this.neo(var6)
               && !var6.method_31574(Items.field_8705)
               && (
                  var6.method_31574(Items.field_8071)
                     ? var2 > this.mre
                     : this.mxr(var6)
                        || !var6.method_7909().method_7876().contains(a.b("ꮱ툄壏욣䵢", -1008227385))
                           && !var6.method_7909().method_7876().contains(a.b("ぞ䧣쌲嵅", -662491081))
                           && !var6.method_31574(Items.field_8288)
               )) {
               int var7 = var4;
               int var8 = ((GenericContainerScreenHandler)var1.method_17577()).field_7763;
               this.msy.add(() -> {
                  if (this.mc.field_1761 != null && this.getPlayer() != null && this.getPlayer().field_7512.field_7763 == var8 && !this.mzu(var7)) {
                     this.mc.field_1761.method_2906(var8, var7, 0, SlotActionType.field_7794, this.getPlayer());
                  }
               });
            }
         }
      }
   }

   private boolean mzu(int var1) {
      ScreenHandler var2 = this.getPlayer().field_7512;
      return var1 >= 0 && var1 < var2.field_7761.size() && ((Slot)var2.field_7761.get(var1)).method_7677().method_31574(Items.field_42716);
   }

   private int mzv(Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = this.getPlayer().method_31548().method_5438(var3);
         if (var4.method_31574(var1)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private boolean mzw(GenericContainerScreen var1, int var2) {
      this.mrf = pmf.plan(
         var1.method_17577(), this.getPlayer().method_31548(), var0 -> var0.method_7909() == Items.field_8071, var2, this.mty, System.currentTimeMillis()
      );
      this.mrg = 0;
      return this.mrf != null;
   }

   private void mzx() {
      if (this.mc.field_1755 instanceof GenericContainerScreen var1 && this.mc.field_1761 != null && this.getPlayer() != null) {
         ScreenHandler var4 = var1.method_17577();
         if (++this.mrg == 120) {
            this.mrf.abort();
         }

         pmc var3 = this.mrf
            .drive(
               var4, System.currentTimeMillis(), (var2, var3x, var4x) -> this.mc.field_1761.method_2906(var4.field_7763, var2, var3x, var4x, this.getPlayer())
            );
         if (var3 == pmc.DONE || var3 == pmc.GAVE_UP || this.mrg > 160) {
            this.mrf = null;
            this.mrg = 0;
            this.mtb = 2 + this.mty.nextInt(4);
         }
      } else {
         this.mrf = null;
         this.mrg = 0;
      }
   }

   private void mzy() {
      if (this.mc.field_1755 instanceof GenericContainerScreen var1 && this.mc.field_1761 != null && this.getPlayer() != null) {
         ScreenHandler var4 = var1.method_17577();
         int var3 = pmf.stashSlot(var4, this.getPlayer().method_31548(), var4.method_34255(), -1);
         if (var3 != -1) {
            this.mc.field_1761.method_2906(var4.field_7763, var3, 0, SlotActionType.field_7790, this.getPlayer());
         }
      }
   }

   private String mzz() {
      for (String var2 : this.mrd) {
         if (var2.equals(a.d("ᚄ漴\ue5e3", -2054590568, 357530922)) && !this.mri) {
            return var2;
         }

         if (var2.equals(a.d("꓃\udd77垫짐䈈", 1941771291, 1409135845)) && !this.mrj) {
            return var2;
         }

         if (var2.equals(a.d("⍊媀큗乘엱䌿說炐", -1826207273, -6394156)) && !this.mrk) {
            return var2;
         }
      }

      return a.b("㥔䂞쩉呆\udfef夡\ue371檎", -474137315);
   }

   private void naa() {
      Collections.shuffle(this.mrd, this.mty);
      this.mre = 3;
      this.mrc = 0;
      this.mwg = 4.0F + this.mty.nextFloat() * 14.0F;
   }

   private int nab(boolean var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = this.getPlayer().method_31548().method_5438(var3);
         if (var1 ? this.nel(var4) : this.neo(var4)) {
            var2 += var4.method_7947();
         }
      }

      return var2;
   }

   private int nac(GenericContainerScreen var1, int var2) {
      int var3 = ((GenericContainerScreenHandler)var1.method_17577()).method_7629().method_5439();
      return var2 < 9 ? var3 + 27 + var2 : var3 + (var2 - 9);
   }

   private boolean nad(GenericContainerScreen var1, boolean var2) {
      return this.nae(var1, var2x -> var2 ? this.nel(var2x) : this.neo(var2x));
   }

   private boolean nae(GenericContainerScreen var1, Predicate<ItemStack> var2) {
      boolean var3 = false;

      for (int var4 = 0; var4 < 36; var4++) {
         ItemStack var5 = this.getPlayer().method_31548().method_5438(var4);
         if (var2.test(var5)) {
            int var6 = this.nac(var1, var4);
            this.msy
               .add(
                  () -> this.mc
                     .field_1761
                     .method_2906(((GenericContainerScreenHandler)var1.method_17577()).field_7763, var6, 0, SlotActionType.field_7794, this.getPlayer())
               );
            var3 = true;
         }
      }

      return var3;
   }

   private void naf(GenericContainerScreen var1, boolean var2) {
      int var3 = this.nab(var2);
      if (this.mrb > 4) {
         this.msy.add(() -> this.nag(var2));
      } else if (var3 == 1) {
         this.mrb = 0;
         this.msy.add(() -> this.nag(var2));
      } else {
         this.mrb++;
         if (var3 > 1) {
            if (!this.nad(var1, var2)) {
               this.msy.add(() -> this.nag(var2));
            }
         } else {
            if (!this.nah(var1, var2)) {
               this.msy.add(() -> this.nag(var2));
            }
         }
      }
   }

   private void nag(boolean var1) {
      if (var1) {
         this.mrj = true;
      } else {
         this.mrk = true;
      }

      this.mrb = 0;
      this.mc.field_1724.method_7346();
      this.mrl = null;
   }

   private boolean nah(GenericContainerScreen var1, boolean var2) {
      this.mrf = pmf.plan(
         var1.method_17577(), this.getPlayer().method_31548(), var2x -> var2 ? this.nel(var2x) : this.neo(var2x), 1, this.mty, System.currentTimeMillis()
      );
      this.mrg = 0;
      return this.mrf != null;
   }

   private String[] nai() {
      String var1 = this.mqi.get();
      String[] var2 = var1 == null ? new String[0] : var1.trim().split(a.b("⋚嬜톿信쐘䋟", -1858198905));
      return var2.length != 0 && !var2[0].isEmpty() ? var2 : new String[]{a.d("㫘䍦짮垚\udc45", -1457529262, -1147083538)};
   }

   private String naj() {
      String[] var1 = this.nai();
      if (this.mqp >= var1.length) {
         this.mqp = 0;
      }

      return var1[this.mqp];
   }

   private static String nak(String var0) {
      String var1 = var0 == null ? "" : var0.trim();

      while (var1.startsWith(a.d("䰲", 974307399, 1334807643))) {
         var1 = var1.substring(1).trim();
      }

      return var1;
   }

   private void nal(String var1) {
      int var2 = pjd.position(this.mxs());
      this.mwn = wap.t(var1)
         + (
            var2 > 0
               ? wap.s(
                  a.c(-601835061, "맨쁑䪉") + var2 + a.d("ﻞ", -1390731760, -2034114330), a.d("ㇱ䡈", 590397077, -116158650) + var2 + a.c(-248147379, "鉣\uefc6愅")
               )
               : ""
         );
      if (this.mwa - this.mwm > 600) {
         this.mwm = this.mwa;
         this.notifyUser(this.mwn, false);
      }

      if (this.mzh()) {
         this.ndi();
      } else {
         pqf.resetKeys();
         this.mzg();
      }
   }

   private void nam() {
      String[] var1 = this.nai();

      for (int var2 = 0; var2 < var1.length; var2++) {
         int var3 = (this.mqp + var2) % var1.length;
         if (pjd.hasRoom(var1[var3], this.mxs())) {
            this.mqp = var3;
            break;
         }
      }

      String var4 = nak(this.naj());
      if (!pjd.enter(this.mxs(), var4)) {
         this.nal(a.b("䟏㸭뒊⻮ꄩ➕鷁ᐲ蹵ß蝴約\uf3a1渀\ue044暲\udcf0卓짭侵숩롵㛋ꤌ⽱ꗅᰛ陖ࢿ躗Ֆﯲ燈\ue838湧", 1834370046));
      } else {
         this.mwn = "";
         this.getNetworkHandler().method_45730(var4);
         this.mrn = 0;
         this.mro = false;
         this.mrp = null;
         this.mrq = 0;
         this.msq = false;
         this.msr = 0;
         this.mss = 0;
         this.mst = false;
         this.mut = this.getWorld();
         this.mwz = this.getWorld();
         this.mxa = this.getPlayer();
         this.mxb = this.getPlayer() == null ? null : this.getPlayer().method_73189();
         this.mxc = -1;
         this.mxd = false;
         this.mxe = 0;
         this.mxf = 0;
         this.myd(mpm.WARPING_TO_LOOT_BASE);
      }
   }

   private boolean nan() {
      ClientPlayerEntity var1 = this.getPlayer();
      return this.mxd || this.getWorld() != this.mwz || var1 != this.mxa || this.mxb != null && var1.method_73189().method_1022(this.mxb) > 48.0;
   }

   private void nao() {
      pqf.resetKeys();
      this.mzf();
      this.mrn++;
      this.mst = false;
      if (!this.msq) {
         if (this.mrn >= 12) {
            this.nas();
         }
      } else if (!this.mro) {
         if (this.mxc >= 0) {
            if (this.mrn - this.mxc >= 10) {
               if (this.mzh()) {
                  this.mro = true;
                  this.myd(mpm.RUN_TO_FARM_COORDS);
                  return;
               }

               this.nap();
            }
         } else {
            if (this.mrn - this.mss >= 10 && (this.nan() || this.mrn >= 200)) {
               this.mxc = this.mrn;
            }
         }
      } else {
         int var1 = this.naw();
         if (var1 > 0) {
            this.mrq = 0;
         } else {
            if (this.mc.field_1690 != null) {
               this.mc.field_1690.field_1904.method_23481(false);
            }

            boolean var2 = this.mrp != null && this.getPlayer().method_24515().method_10262(this.mrp) > 9.0;
            if (var2 || this.mrn - this.mxf >= 200) {
               if (!var2 && this.mxe < 2) {
                  this.nap();
               } else {
                  this.mrq++;
                  if (this.mrq >= 40) {
                     this.myd(mpm.ENTER_PORTAL);
                  }
               }
            }
         }
      }
   }

   private void nap() {
      this.getNetworkHandler().method_45730(this.mxt());
      this.mro = true;
      this.mxe++;
      this.mrp = this.getPlayer().method_24515();
      this.mxf = this.mrn;
      this.mrq = 0;
   }

   private void naq() {
      if (this.mzh()) {
         pqf.resetKeys();
         this.msc = 0;
         this.myd(mpm.RUN_TO_FARM_COORDS);
      } else {
         this.ncf();
         this.mux = true;
         this.mc.field_1690.field_1894.method_23481(true);
         this.mc.field_1690.field_1867.method_23481(true);
         this.mc.field_1690.field_1903.method_23481(this.getPlayer().field_5976 && this.getPlayer().method_24828());
         this.msc++;
         if (this.msc > 600) {
            this.msc = 0;
            pqf.resetKeys();
            String var1 = wap.s(
               a.c(-1403542396, "ꓪ\udd76垨짓䉍쒯纨\uf71e楃\ue3e3摤鹜ႌ褧ͯ藑㿊뀇⪹겭┿彅퇼䩩찛䛇Ｖ煤\ueb91淈\ue630ᢵ鋡ୟ赘ߵ렯㈛뒛ⴸꝰ\ud992"),
               a.c(-937836610, "뮻숢䳤횊嵜\udbec憰\ue84a爎ﲭ罬脐࿗陯ᠨ黔⒖꽚㗤랥㨳䀖캩啳")
            );
            this.notifyUser(var1, false);
            this.myo(var1);
            this.mxu();
            this.myd(mpm.TELEPORT_TO_SAVE);
         }
      }
   }

   private void nar() {
      BlockPos var1 = new BlockPos(0, 66, 1);
      if (Math.abs(this.getPlayer().method_23317()) <= 10.0
         && Math.abs(this.getPlayer().method_23321() - 1.0) <= 10.0
         && Math.abs(this.getPlayer().method_23318() - 66.0) <= 3.0) {
         pqf.resetKeys();
         this.mqy = null;
         this.mxg = 0;
         this.myd(mpm.FARMING);
      } else if (this.msd > 0) {
         this.msd--;
         pqf.resetKeys();
      } else {
         if (this.mqy == null || this.mqz >= this.mqy.size()) {
            this.nbc(this.nba(var1));
            if (this.mqy == null || this.mqy.isEmpty()) {
               this.msd = 20;
            }
         }

         if (this.mqy != null && this.mqz < this.mqy.size()) {
            this.ncr();
         } else {
            pqf.resetKeys();
         }

         if (this.getPlayer().field_6017 > 3.0) {
            int var2 = this.nei(Items.field_8705);
            if (var2 != -1) {
               this.getPlayer().method_31548().method_61496(var2);
               this.nby(this.mtl.intentYaw(), 89.0F);
               if (this.mtl.intentPitch() > 65.0F) {
                  this.mxv();
               }
            }
         }
      }
   }

   private void nas() {
      this.msq = true;
      this.mst = false;
      this.mss = this.mrn;
      this.mc.field_1690.field_1904.method_23481(false);
      this.nat();
   }

   private void nat() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.getPlayer().method_31548().method_5438(var1).method_7960()) {
            this.getPlayer().method_31548().method_61496(var1);
            return;
         }
      }

      for (int var3 = 0; var3 < 9; var3++) {
         ItemStack var2 = this.getPlayer().method_31548().method_5438(var3);
         if (!this.nel(var2) && !this.neo(var2) && var2.method_7909() != Items.field_8071) {
            this.getPlayer().method_31548().method_61496(var3);
            return;
         }
      }
   }

   private void nau(int var1) {
      int var2 = this.nav();
      int var3 = var2 != -1 ? var2 : 8;
      this.msy.add(() -> this.ndv(var1, var3, SlotActionType.field_7791));
   }

   private int nav() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.getPlayer().method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      return -1;
   }

   private int naw() {
      return pjn.teleportSeconds(this.mc, a.d("ạ朇\uedda玥\uf878终쓥䴖팻姼\ude51\u2457껯㌹뤘㾜薦ੵ铋", 721719727, 536513343));
   }

   private void nax() {
      this.msu = false;
      this.msv = 0;
      if (!(this.mqr >= this.mqd.get()) && this.getPlayer().method_31548().method_7376() != -1) {
         if (this.mrr != null && (this.mra.contains(this.mrr) || !this.nbl(this.mrr))) {
            this.nay(false);
         }

         if (this.mrr == null && this.msf <= 0) {
            this.mrr = this.nbk();
            if (this.mrr == null) {
               this.msf = 10;
            } else {
               this.msi = 0;
               this.msx = 0;
               this.nch();
               this.naz(this.mrr, true);
            }
         }

         if (this.mrr == null) {
            this.nbf();
         } else {
            this.msi++;
            double var1 = this.getPlayer().method_33571().method_1025(Vec3d.method_24953(this.mrr));
            boolean var3 = this.nbm(this.mrr);
            if (var3 && var1 <= 16.0) {
               this.mqy = null;
               this.mqz = 0;
               this.myd(mpm.LOOTING_VASE);
               this.mrs = 0;
               this.msu = false;
               this.msx = 0;
            } else if (this.msi > this.mys(300)) {
               this.nay(true);
            } else {
               if (!this.mvh && var3 && var1 <= 36.0 && this.ncs(Vec3d.method_24953(this.mrr))) {
                  this.mvh = true;
               }

               if (this.mvh && var3) {
                  this.muy = this.nbo(this.mrr);
               }

               if (this.mqy != null && this.mqz < this.mqy.size()) {
                  this.ncr();
                  this.msx = 0;
               } else {
                  this.msx++;
                  if (this.msx >= 40) {
                     this.nay(true);
                  } else {
                     if (var3 && var1 < 100.0) {
                        this.ncp(Vec3d.method_24953(this.mrr));
                     } else if (!this.naz(this.mrr, false)) {
                        pqf.resetKeys();
                     }
                  }
               }
            }
         }
      } else {
         this.myd(mpm.CHECK_PVP_COOLDOWN);
      }
   }

   private void nay(boolean var1) {
      if (var1 && this.mrr != null) {
         this.mra.add(this.mrr);
      }

      this.mvh = false;
      this.mrr = null;
      this.mqy = null;
      this.mqz = 0;
      this.msx = 0;
      this.msi = 0;
      if (this.mc.field_1761 != null) {
         this.mc.field_1761.method_2925();
      }

      this.mc.field_1690.field_1886.method_23481(false);
   }

   private boolean naz(BlockPos var1, boolean var2) {
      if (var1 == null) {
         return false;
      } else if (!var2 && this.mse > 0) {
         return this.mqy != null && this.mqz < this.mqy.size();
      } else {
         this.mse = 8;
         this.nbc(this.nba(var1));
         return this.mqy != null && !this.mqy.isEmpty();
      }
   }

   private List<BlockPos> nba(BlockPos var1) {
      return this.nbb(this.getPlayer().method_24515(), var1);
   }

   private List<BlockPos> nbb(BlockPos var1, BlockPos var2) {
      if (var2 != null && this.getWorld() != null) {
         if (this.mvn == null || !var2.equals(this.mvo)) {
            this.mvn = pqq.random(this.mty);
            this.mvo = var2;
         }

         return pqx.findPath(this.getWorld(), this.getPlayer(), var1, var2, mpt, 0.0, true, Collections.emptySet(), this.mvn);
      } else {
         return null;
      }
   }

   private void nbc(List<BlockPos> var1) {
      this.mqy = var1;
      this.mqz = 0;
      this.mvm = var1 != null && !var1.isEmpty()
         ? this.mvl.plan(this.getWorld(), this.getPlayer(), var1, (BlockPos)var1.get(var1.size() - 1), new prz())
         : null;
      if (this.mvm == null) {
         this.mqy = null;
      }
   }

   private BlockPos nbd(BlockPos var1) {
      if (this.getWorld() == null) {
         return var1;
      } else {
         Mutable var2 = new Mutable();

         for (int var3 = 0; var3 <= 10; var3++) {
            for (byte var4 = 1; var4 >= -1; var4 -= 2) {
               var2.method_10103(var1.method_10263(), var1.method_10264() + var3 * var4, var1.method_10260());
               if (this.nbe(var2)) {
                  return var2.method_10062();
               }

               if (var3 == 0) {
                  break;
               }
            }
         }

         return var1;
      }
   }

   private boolean nbe(BlockPos var1) {
      return this.getWorld() == null
         ? false
         : this.getWorld().method_8320(var1).method_26220(this.getWorld(), var1).method_1110()
            && this.getWorld().method_8320(var1.method_10084()).method_26220(this.getWorld(), var1.method_10084()).method_1110()
            && !this.getWorld().method_8320(var1.method_10074()).method_26220(this.getWorld(), var1.method_10074()).method_1110();
   }

   private void nbf() {
      if (this.nci() && this.mvm != null && this.mse <= 0 && !this.myq() && this.mvl.remaining(this.mvm) < 3.5) {
         this.mse = 8;
         this.nbg();
      }

      if (this.mqy == null || this.mqz >= this.mqy.size()) {
         if (this.mse > 0) {
            pqf.resetKeys();
            this.ncf();
            return;
         }

         this.mse = 8;
         this.nbg();
      }

      if (this.mqy != null && this.mqz < this.mqy.size()) {
         this.ncr();
      } else {
         pqf.resetKeys();
         this.ncf();
      }
   }

   private void nbg() {
      BlockPos var1 = this.getPlayer().method_24515();
      this.nbi(var1);
      if (Double.isNaN(this.mvt)) {
         this.mvt = Math.toRadians(this.ncj() + 90.0);
      }

      double[] var2 = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
      int var3 = 0;

      for (int var4 = 0; var4 < var2.length && var3 < 2; var4++) {
         double var5 = this.mvt + var2[(var4 + this.mvv) % var2.length] + this.mty.nextGaussian() * 0.28;
         double var7 = 17.0 + this.mty.nextDouble() * 19.0;
         BlockPos var9 = var1.method_10069((int)Math.round(Math.cos(var5) * var7), 0, (int)Math.round(Math.sin(var5) * var7));
         if (!this.nbj(var9) || this.mvu >= 2) {
            var3++;
            List var10 = this.nbb(var1, this.nbd(var9));
            if (var10 != null && var10.size() >= 5) {
               this.mvt = var5;
               this.mvu = 0;
               this.mvv = 0;
               this.nbc(var10);
               return;
            }
         }
      }

      this.mvu++;
      this.mvv = (this.mvv + 2) % var2.length;
      this.mvt = this.mvt + ((Math.PI / 2) + this.mty.nextDouble() * Math.PI);
      this.nbc(null);
   }

   private static long nbh(BlockPos var0) {
      return (long)(var0.method_10263() >> 4) << 32 ^ var0.method_10260() >> 4 & 4294967295L;
   }

   private void nbi(BlockPos var1) {
      if (this.mvw.size() > 512) {
         this.mvw.clear();
      }

      this.mvw.add(nbh(var1));
   }

   private boolean nbj(BlockPos var1) {
      return this.mvw.contains(nbh(var1));
   }

   private BlockPos nbk() {
      BlockPos var1 = this.getPlayer().method_24515();
      Mutable var2 = new Mutable();
      ArrayList var3 = new ArrayList();
      if (this.getWorld() != null) {
         for (PlayerEntity var5 : this.getWorld().method_18456()) {
            if (var5 != this.getPlayer()) {
               var3.add(var5.method_73189());
            }
         }
      }

      BlockPos var19 = null;
      double var20 = Double.MAX_VALUE;
      int var7 = 0;
      int var8 = -1;

      for (int var9 = 0; var9 <= 32; var9++) {
         for (int var10 = -var9; var10 <= var9; var10++) {
            for (int var11 = -var9; var11 <= var9; var11++) {
               if (Math.max(Math.abs(var10), Math.abs(var11)) == var9) {
                  for (int var12 = -8; var12 <= 8; var12++) {
                     int var13 = var1.method_10264() + var12;
                     if (var13 < 80 || var13 > 90) {
                        var2.method_10103(var1.method_10263() + var10, var13, var1.method_10260() + var11);
                        if (this.nbl(var2) && !this.mra.contains(var2)) {
                           double var14 = var2.method_10262(var1) * (0.8 + this.mty.nextDouble() * 0.65);
                           if (!this.nbn(var2)) {
                              var14 *= 2.4;
                           }

                           Vec3d var16 = Vec3d.method_24953(var2);

                           for (Vec3d var18 : var3) {
                              if (var18.method_1025(var16) < 1600.0) {
                                 var14 += 100000.0;
                                 break;
                              }
                           }

                           var7++;
                           if (var14 < var20) {
                              var20 = var14;
                              var19 = var2.method_10062();
                           }
                        }
                     }
                  }
               }
            }
         }

         if (var19 != null) {
            if (var8 < 0) {
               var8 = var9;
            }

            if (var9 >= var8 + 4 || var7 >= 12) {
               return var19;
            }
         }
      }

      return var19;
   }

   private boolean nbl(BlockPos var1) {
      return this.getWorld() != null && var1 != null ? this.getWorld().method_8320(var1).method_27852(Blocks.field_42752) : false;
   }

   private boolean nbm(BlockPos var1) {
      return this.nbo(var1) != null;
   }

   private boolean nbn(BlockPos var1) {
      Vec3d var2 = this.getPlayer().method_33571();
      Vec3d[] var3 = new Vec3d[]{Vec3d.method_24953(var1), Vec3d.method_24953(var1).method_1031(0.0, 0.4, 0.0)};

      for (Vec3d var7 : var3) {
         BlockHitResult var8 = this.getWorld().method_17742(new RaycastContext(var2, var7, ShapeType.field_17559, FluidHandling.field_1348, this.getPlayer()));
         if (var8.method_17783() == Type.field_1333 || var8.method_17777().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private Vec3d nbo(BlockPos var1) {
      if (this.getWorld() != null && this.getPlayer() != null && var1 != null) {
         Vec3d var2 = this.getPlayer().method_33571();
         Vec3d var3 = Vec3d.method_24953(var1);
         Vec3d[] var4 = new Vec3d[]{
            var3.method_1031(this.muz, this.mva, this.mvb),
            var3.method_1031(0.0, 0.35, 0.0),
            var3.method_1031(0.0, -0.35, 0.0),
            var3.method_1031(0.3, 0.0, 0.0),
            var3.method_1031(-0.3, 0.0, 0.0),
            var3.method_1031(0.0, 0.0, 0.3),
            var3.method_1031(0.0, 0.0, -0.3)
         };

         for (Vec3d var8 : var4) {
            BlockHitResult var9 = this.getWorld()
               .method_17742(new RaycastContext(var2, var8, ShapeType.field_17559, FluidHandling.field_1348, this.getPlayer()));
            if (var9.method_17783() == Type.field_1333 || var9.method_17777().equals(var1)) {
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private void nbp(Vec3d var1) {
      this.msu = true;
      this.mrs = 0;
      this.msv = 0;
      this.msk = false;
      this.msn = 0;
      this.mso = Double.MAX_VALUE;
      this.msp = -1;
      this.msl.clear();
      this.mqy = null;
      this.mqz = 0;
      this.mc.field_1690.field_1886.method_23481(false);
      this.mxx();
      if (this.mc.field_1761 != null) {
         this.mc.field_1761.method_2925();
      }

      this.msj = var1;
      this.msm.clear();
      if (this.mc.field_1687 != null) {
         for (Entity var3 : this.mc.field_1687.method_18112()) {
            if (var3 instanceof ItemEntity var4 && var4.method_5707(var1) < 100.0 && var4.method_6985() > 20) {
               this.msm.add(var4.method_5628());
            }
         }
      }
   }

   private void nbq() {
      if (this.mrr != null && this.nbl(this.mrr)) {
         this.mrs++;
         Vec3d var5 = this.nbo(this.mrr);
         double var2 = this.getPlayer().method_33571().method_1025(Vec3d.method_24953(this.mrr));
         if (var5 != null && !(var2 > 20.25)) {
            if (this.nbr(this.mrr)) {
               this.mux = true;
               this.mc.field_1690.field_1894.method_23481(true);
               this.mc.field_1690.field_1867.method_23481(true);
               this.mc.field_1690.field_1903.method_23481(false);
            } else {
               pqf.resetKeys();
            }

            this.ncb(this.mrr, var5);
            boolean var4 = this.nco(this.mrr) != null;
            this.ncd(var4);
            if (var4 && this.mvc > 0) {
               this.mvc--;
               var4 = false;
            }

            this.mc.field_1690.field_1886.method_23481(var4);
            if (this.mrs > this.mys(100)) {
               this.nay(true);
               this.myd(mpm.FARMING);
            }
         } else {
            this.mc.field_1690.field_1886.method_23481(false);
            if (this.mc.field_1761 != null) {
               this.mc.field_1761.method_2925();
            }

            if (this.mqy == null || this.mqz >= this.mqy.size()) {
               this.naz(this.mrr, false);
            }

            if (this.mqy != null && this.mqz < this.mqy.size()) {
               this.ncr();
            } else {
               pqf.resetKeys();
            }

            if (this.mrs > this.mys(80)) {
               this.nay(true);
               this.myd(mpm.FARMING);
            }
         }
      } else {
         if (!this.msu) {
            Vec3d var1 = this.mrr != null ? Vec3d.method_24953(this.mrr) : this.getPlayer().method_73189();
            if (this.mrr != null) {
               this.mra.add(this.mrr);
               this.mqu++;
            }

            this.mrr = null;
            this.nbp(var1);
         }

         this.nbs(mpm.FARMING);
      }
   }

   private boolean nbr(BlockPos var1) {
      if (this.getPlayer().method_24828() && !this.getPlayer().method_5799()) {
         if (Math.abs(var1.method_10264() - this.getPlayer().method_23318()) > 1.0) {
            return false;
         } else {
            double var2 = var1.method_10263() + 0.5 - this.getPlayer().method_23317();
            double var4 = var1.method_10260() + 0.5 - this.getPlayer().method_23321();
            double var6 = Math.hypot(var2, var4);
            if (var6 < 2.0) {
               return false;
            } else {
               double var8 = (var6 - 1.3) / var6;
               return this.nct(
                  new Vec3d(this.getPlayer().method_23317() + var2 * var8, this.getPlayer().method_23318(), this.getPlayer().method_23321() + var4 * var8),
                  true
               );
            }
         }
      } else {
         return false;
      }
   }

   private void nbs(mpm var1) {
      this.mrs++;
      this.mc.field_1690.field_1886.method_23481(false);
      this.mc.field_1690.field_1904.method_23481(false);
      Vec3d var2 = this.msj != null ? this.msj : this.getPlayer().method_73189();
      ItemEntity var3 = null;
      double var4 = Double.MAX_VALUE;
      if (this.mc.field_1687 != null) {
         for (Entity var7 : this.mc.field_1687.method_18112()) {
            if (var7 instanceof ItemEntity var8 && var8.method_5805() && (!(var8.method_5707(var2) > 64.0) || !(var8.method_5858(this.getPlayer()) > 36.0))) {
               if (!this.msm.contains(var8.method_5628())) {
                  this.msk = true;
               }

               if (!this.isTrashItem(var8.method_6983()) && !this.msl.contains(var8.method_5628())) {
                  double var9 = var8.method_5858(this.getPlayer());
                  if (var9 < var4) {
                     var4 = var9;
                     var3 = var8;
                  }
               }
            }
         }
      }

      if (var3 != null) {
         this.msv = 0;
         if (var3.method_5628() != this.msp) {
            this.msp = var3.method_5628();
            this.msn = 0;
            this.mso = var4;
            this.mqy = null;
            this.mqz = 0;
         }

         this.msn++;
         if (var4 < this.mso - 0.05) {
            this.mso = var4;
            this.msn = 0;
         }

         int var11 = this.mys(var4 < 2.25 ? 30 : 60);
         if (this.msn > var11) {
            this.msl.add(var3.method_5628());
            this.msp = -1;
            this.mqy = null;
            this.mqz = 0;
            pqf.resetKeys();
            return;
         }

         if (var4 > 6.25) {
            BlockPos var14 = var3.method_24515();
            if (this.mqy == null || this.mqy.isEmpty() || this.mqz >= this.mqy.size() || this.mqy.get(this.mqy.size() - 1).method_10262(var14) > 4.0) {
               this.naz(var14, false);
            }

            if (this.mqy != null && this.mqz < this.mqy.size()) {
               this.ncr();
            } else {
               this.ncq(var3.method_73189(), true);
            }
         } else if (pqf.isBlockedHorizontally() && this.msn > 12) {
            if (this.mqy == null || this.mqz >= this.mqy.size()) {
               this.naz(var3.method_24515(), false);
            }

            if (this.mqy != null && this.mqz < this.mqy.size()) {
               this.ncr();
            } else {
               this.nbt(var3.method_73189());
            }
         } else {
            this.mqy = null;
            this.nbt(var3.method_73189());
         }
      } else {
         this.msv++;
         double var12 = Math.hypot(var2.field_1352 - this.getPlayer().method_23317(), var2.field_1350 - this.getPlayer().method_23321());
         if (!this.msk && this.msj != null && this.mrs < 12 && var12 > 1.1 && this.ncx(BlockPos.method_49638(this.msj))) {
            this.ncq(new Vec3d(var2.field_1352, this.getPlayer().method_23318(), var2.field_1350), true);
         } else {
            pqf.resetKeys();
         }
      }

      int var13 = this.msk ? 4 : 24;
      if (this.msv > var13 && this.mrs > 8 || this.mrs > this.mys(160)) {
         pqf.resetKeys();
         this.nbu(var1);
      }
   }

   private void nbt(Vec3d var1) {
      ClientPlayerEntity var2 = this.getPlayer();
      Vec3d var3 = new Vec3d(var1.field_1352, var2.method_33571().field_1351 - 0.6, var1.field_1350);
      int var4 = this.mvl.walkTo(this.mc, var2, this.getWorld(), var1, this.mtu, this.mtv, var3, false, this.myq(), this.myt());
      if (var4 != 0 && !this.myq()) {
         pqf.resetKeys();
      }

      this.mux = true;
      this.mry = true;
   }

   private void nbu(mpm var1) {
      this.mqr++;
      this.mrr = null;
      this.mrz = null;
      this.mqy = null;
      this.mqz = 0;
      this.msu = false;
      this.msv = 0;
      this.msj = null;
      this.msk = false;
      this.msl.clear();
      this.msm.clear();
      this.msp = -1;
      this.msn = 0;
      this.mso = Double.MAX_VALUE;
      this.msi = 0;
      this.msx = 0;
      this.msb = false;
      this.msf = 0;
      this.msg = 0;
      this.mse = 0;
      this.myd(var1);
   }

   private void nbv() {
      this.mtw = this.getPlayer();
      if (this.mtw != null) {
         this.nce(this.mtw);
         this.mtl.reset(this.mtw.method_36454(), this.mtw.method_36455());
         this.mtu = this.mtw.method_36454();
         this.mtv = this.mtw.method_36455();
         this.mtx = this.mtw.method_73189();
      }

      this.mtn = false;
      this.mto = false;
      this.mua = false;
      this.mub = false;
      this.muc = false;
   }

   private void nbw() {
      ptr.clear();
      if (this.mtn) {
         this.mtn = false;
         if (this.driver == null && this.mtm.ownedBy(this)) {
            this.mtm.release(this.mc.field_1724);
         }
      }
   }

   private boolean nbx() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 == null) {
         return false;
      } else {
         boolean var2 = this.mtw != var1 || this.mtx == null || var1.method_73189().method_1025(this.mtx) > 400.0;
         if (var2) {
            if (this.driver == null) {
               this.mtm.reset();
            }

            if (this.mtw != var1) {
               this.nce(var1);
            }

            this.mtl.reset(var1.method_36454(), var1.method_36455());
            this.mtu = var1.method_36454();
            this.mtv = var1.method_36455();
            this.mtw = var1;
            this.mtn = false;
            this.mqy = null;
            this.mqz = 0;
            this.mvm = null;
            this.mvl.reset();
         }

         this.mtx = var1.method_73189();
         return var2;
      }
   }

   private void nby(float var1, float var2) {
      this.nbz(var1, var2, false);
   }

   private void nbz(float var1, float var2, boolean var3) {
      this.mts = var1;
      this.mtt = var2;
      this.mtq = var3;
      this.mtr = false;
      this.mvd = 0.0;
      this.mto = true;
      this.mtp = false;
   }

   private void nca(Vec3d var1) {
      float[] var2 = prt.calculateAngle(var1);
      this.nbz(var2[0], var2[1], false);
   }

   private void ncb(BlockPos var1, Vec3d var2) {
      this.nca(var2);
      this.mvd = this.mve ? 0.25 : this.ncc(var1, var2);
   }

   private double ncc(BlockPos var1, Vec3d var2) {
      if (this.getWorld() != null && this.getPlayer() != null && var1 != null && var2 != null) {
         VoxelShape var3 = this.getWorld().method_8320(var1).method_26218(this.getWorld(), var1);
         Box var4 = var3.method_1110() ? new Box(var1) : var3.method_1107().method_996(var1);
         double var5 = Math.min(
            Math.min(
               Math.min(var2.field_1352 - var4.field_1323, var4.field_1320 - var2.field_1352),
               Math.min(var2.field_1351 - var4.field_1322, var4.field_1325 - var2.field_1351)
            ),
            Math.min(var2.field_1350 - var4.field_1321, var4.field_1324 - var2.field_1350)
         );
         if (var5 <= 0.02) {
            return 0.25;
         } else {
            double var7 = Math.max(0.5, this.getPlayer().method_33571().method_1022(var2));
            return MathHelper.method_15350(Math.toDegrees(Math.atan2(var5, var7)) * 0.55, 0.25, 4.0);
         }
      } else {
         return 0.0;
      }
   }

   private void ncd(boolean var1) {
      if (!var1 && !this.mtl.isMoving()) {
         if (++this.mvf >= 3) {
            this.mve = true;
         }
      } else {
         this.mvf = 0;
      }
   }

   private void nce(PlayerEntity var1) {
      String var2 = var1.method_7334() != null ? var1.method_7334().name() : null;
      long var3 = 1125899906842597L;
      if (var2 != null) {
         for (int var5 = 0; var5 < var2.length(); var5++) {
            var3 = var3 * 31L + Character.toLowerCase(var2.charAt(var5));
         }
      }

      this.mtl.personalize(var3);
      this.mvl.personalize(var3);
   }

   private void ncf() {
      if (!this.mto) {
         this.mtp = true;
      }
   }

   private boolean ncg() {
      if (this.mvi > 0) {
         this.mvi--;
         return true;
      } else if (this.mvj > 0) {
         this.mvj--;
         return false;
      } else if (!this.msu && (this.mqq == mpm.FARMING || this.mqq == mpm.FARMING_SAND || this.mqq == mpm.RUN_TO_FARM_COORDS)) {
         this.mvj = 2400 + this.mty.nextInt(4200);
         this.mvi = 8 + this.mty.nextInt(26);
         return true;
      } else {
         return false;
      }
   }

   private void nch() {
      this.mvh = false;
      this.mve = false;
      this.mvf = 0;
      this.muz = (this.mty.nextDouble() - 0.5) * 0.34;
      this.mva = (this.mty.nextDouble() - 0.5) * 0.44;
      this.mvb = (this.mty.nextDouble() - 0.5) * 0.34;
      this.mvc = 1 + this.mty.nextInt(4);
   }

   private boolean nci() {
      return this.mqy != null && this.mqz < this.mqy.size();
   }

   private float ncj() {
      return (float)this.mvl.moveYaw(this.mtu);
   }

   private void nck() {
      if (this.getPlayer() != null) {
         this.mvr = this.mto && !this.mtq;
         boolean var1 = this.mvl.takeTurn(this.mvs);
         if (this.myq() && !this.mvr) {
            this.ncl();
         } else {
            if (this.mc.field_1755 == null) {
               this.mtl.setMouseStep(this.driver != null ? this.driver.mouseStep() : prp.step());
               if (this.ncm()) {
                  this.mtl.freeze();
               } else if (this.mto) {
                  if (this.mtq && this.mtr) {
                     this.mtl.aimTight(this.mts, this.mtt);
                  } else if (this.mtq) {
                     this.mtl.aimRelaxed(this.mts, this.mtt);
                  } else {
                     this.mtl.aim(this.mts, this.mtt, this.mvd);
                  }
               } else if (var1) {
                  this.mtl.turn(this.mvs[0], this.mvs[1]);
               } else if (this.mtp) {
                  this.mtl.hold();
               } else {
                  this.mtl.idle();
               }

               this.mtu = this.mtl.getYaw();
               this.mtv = this.mtl.getPitch();
            }

            this.mto = false;
            this.mtp = false;
            if (this.driver != null) {
               if (this.mc.field_1755 == null) {
                  this.driver.look(this.mtu, MathHelper.method_15363(this.mtv, -90.0F, 90.0F));
               }
            } else {
               this.mtm.set(this, this.mtu, MathHelper.method_15363(this.mtv, -90.0F, 90.0F));
            }

            this.mtn = true;
            if (this.mc.field_1755 != null) {
               ptr.clear();
            } else if (this.mvk != null) {
               ptr.aimAt(this.mvk, this.mtu, this.mtv);
            }

            this.mvk = null;
         }
      }
   }

   private void ncl() {
      this.mto = false;
      this.mtp = false;
      ClientPlayerEntity var1 = this.getPlayer();
      this.mtl.reset(var1.method_36454(), var1.method_36455());
      this.mtu = var1.method_36454();
      this.mtv = var1.method_36455();
      if (this.mtn) {
         this.mtn = false;
         if (this.mtm.ownedBy(this)) {
            this.mtm.release(this.mc.field_1724);
         }
      }

      if (this.mc.field_1755 != null) {
         ptr.clear();
      } else if (this.mvk != null) {
         ptr.aimAt(this.mvk, this.mtu, this.mtv);
      }

      this.mvk = null;
   }

   private boolean ncm() {
      return this.mud > 0 || !this.msy.isEmpty() || this.mtb > 0;
   }

   private BlockHitResult ncn() {
      if (this.getWorld() != null && this.getPlayer() != null) {
         Vec3d var1 = this.getPlayer().method_33571();
         Vec3d var2 = Vec3d.method_1030(this.mtv, this.mtu);
         double var3 = 4.5;
         Vec3d var5 = var1.method_1031(var2.field_1352 * var3, var2.field_1351 * var3, var2.field_1350 * var3);
         return this.getWorld().method_17742(new RaycastContext(var1, var5, ShapeType.field_17559, FluidHandling.field_1348, this.getPlayer()));
      } else {
         return null;
      }
   }

   private BlockHitResult nco(BlockPos var1) {
      BlockHitResult var2 = this.ncn();
      if (var2 != null && var2.method_17783() == Type.field_1332 && var2.method_17777().equals(var1)) {
         this.mvk = var1;
         return var2;
      } else {
         return null;
      }
   }

   private void ncp(Vec3d var1) {
      this.ncq(var1, false);
   }

   private void ncq(Vec3d var1, boolean var2) {
      int var3 = this.mvl.walkTo(this.mc, this.getPlayer(), this.getWorld(), var1, this.mtu, this.mtv, null, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
      if (var3 != 0 && !this.myq()) {
         pqf.resetKeys();
      }

      this.mux = true;
      this.mry = true;
   }

   private void ncr() {
      if (this.mqy != null && this.mqz < this.mqy.size()) {
         if (!this.myq() && this.ncg()) {
            pqf.resetKeys();
            this.ncf();
         } else {
            if (this.mvm == null) {
               this.mvm = this.mvl.plan(this.getWorld(), this.getPlayer(), this.mqy, this.mqy.get(this.mqy.size() - 1), new prz());
               if (this.mvm == null) {
                  this.mqy = null;
                  this.mqz = 0;
                  return;
               }
            }

            Vec3d var1 = this.muy;
            this.muy = null;
            int var2 = this.mvl
               .follow(this.mc, this.getPlayer(), this.getWorld(), this.mvm, this.mtu, this.mtv, var1, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
            if (var2 == 2) {
               this.mqy = null;
               this.mqz = 0;
               this.mvm = null;
               this.mse = 0;
               if (!this.myq()) {
                  pqf.resetKeys();
               }
            } else if (var2 == 1) {
               this.mqz = this.mqy.size();
               this.mvm = null;
               if (!this.myq()) {
                  pqf.resetKeys();
               }
            } else {
               this.mqz = Math.min(this.mqy.size() - 1, this.mvm.nodeIndex(this.mvl.stride.at()));
               this.mux = true;
               this.mry = true;
            }
         }
      }
   }

   private boolean ncs(Vec3d var1) {
      return this.nct(var1, true);
   }

   private boolean nct(Vec3d var1, boolean var2) {
      if (this.getWorld() != null && this.getPlayer() != null) {
         Vec3d var3 = this.getPlayer().method_73189();
         double var4 = var1.field_1352 - var3.field_1352;
         double var6 = var1.field_1350 - var3.field_1350;
         double var8 = Math.hypot(var4, var6);
         if (var8 < 0.1) {
            return true;
         } else {
            double var10 = this.ncu();
            int var12 = (int)Math.ceil(var8 / 0.45);

            for (int var13 = 1; var13 <= var12; var13++) {
               double var14 = (double)var13 / var12;
               double var16 = var3.field_1352 + var4 * var14;
               double var18 = var3.field_1350 + var6 * var14;
               if (!this.ncv(var16, var18, var10)) {
                  return false;
               }

               if (var2 && this.ncx(BlockPos.method_49637(var16, var10 - 0.2, var18))) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private double ncu() {
      return this.nci() ? pqf.getStandY(this.mqy.get(this.mqz)) : this.getPlayer().method_23318();
   }

   private boolean ncv(double var1, double var3, double var5) {
      return this.ncw(new Box(var1 - 0.31, var5 + 0.6, var3 - 0.31, var1 + 0.31, var5 + 1.8, var3 + 0.31));
   }

   private boolean ncw(Box var1) {
      for (VoxelShape var3 : this.getWorld().method_20812(this.getPlayer(), var1)) {
         if (!var3.method_1110()) {
            return false;
         }
      }

      return true;
   }

   private boolean ncx(BlockPos var1) {
      return this.getWorld().method_8320(var1).method_26220(this.getWorld(), var1).method_1110();
   }

   private void ncy() {
      if (!this.nde()) {
         this.myd(mpm.CHECK_PVP_COOLDOWN);
      } else {
         this.msu = false;
         this.msv = 0;
         if (this.mrz != null && (this.mra.contains(this.mrz) || !this.ndb(this.mrz))) {
            this.ncz(false);
         }

         if (this.mrz == null && this.msg <= 0) {
            this.mrz = this.nda();
            if (this.mrz == null) {
               this.msg = 10;
            } else {
               this.msi = 0;
               this.msx = 0;
               this.nch();
               this.naz(this.mrz, true);
            }
         }

         if (this.mrz == null) {
            this.nbf();
         } else {
            this.msi++;
            double var1 = this.getPlayer().method_33571().method_1025(Vec3d.method_24953(this.mrz));
            boolean var3 = this.nbm(this.mrz);
            if (var3 && var1 <= 16.0) {
               pqf.resetKeys();
               this.mqy = null;
               this.mqz = 0;
               this.myd(mpm.BRUSHING_SAND);
               this.msa = 0;
               this.msb = false;
               this.msx = 0;
            } else if (this.msi > this.mys(300)) {
               this.ncz(true);
            } else {
               if (!this.mvh && var3 && var1 <= 36.0 && this.ncs(Vec3d.method_24953(this.mrz))) {
                  this.mvh = true;
               }

               if (this.mvh && var3) {
                  this.muy = this.nbo(this.mrz);
               }

               if (this.mqy != null && this.mqz < this.mqy.size()) {
                  this.ncr();
                  this.msx = 0;
               } else {
                  this.msx++;
                  if (this.msx >= 40) {
                     this.ncz(true);
                  } else {
                     if (var3 && var1 < 100.0) {
                        this.ncp(Vec3d.method_24953(this.mrz));
                     } else if (!this.naz(this.mrz, false)) {
                        pqf.resetKeys();
                     }
                  }
               }
            }
         }
      }
   }

   private void ncz(boolean var1) {
      if (var1 && this.mrz != null) {
         this.mra.add(this.mrz);
      }

      this.mvh = false;
      this.mrz = null;
      this.mqy = null;
      this.mqz = 0;
      this.msx = 0;
      this.msi = 0;
      this.msb = false;
      this.mc.field_1690.field_1904.method_23481(false);
   }

   private BlockPos nda() {
      BlockPos var1 = this.getPlayer().method_24515();
      Mutable var2 = new Mutable();
      ArrayList var3 = new ArrayList();

      for (PlayerEntity var5 : this.getWorld().method_18456()) {
         if (var5 != this.getPlayer()) {
            var3.add(var5.method_73189());
         }
      }

      BlockPos var16 = null;
      double var17 = Double.MAX_VALUE;

      for (int var7 = 0; var7 <= 32; var7++) {
         for (int var8 = -var7; var8 <= var7; var8++) {
            for (int var9 = -var7; var9 <= var7; var9++) {
               if (Math.max(Math.abs(var8), Math.abs(var9)) == var7) {
                  for (int var10 = -8; var10 <= 8; var10++) {
                     var2.method_10103(var1.method_10263() + var8, var1.method_10264() + var10, var1.method_10260() + var9);
                     if (this.ndb(var2) && !this.mra.contains(var2)) {
                        double var11 = var2.method_10262(var1);
                        Vec3d var13 = Vec3d.method_24953(var2);

                        for (Vec3d var15 : var3) {
                           if (var15.method_1025(var13) < 1600.0) {
                              var11 += 100000.0;
                              break;
                           }
                        }

                        if (var11 < var17) {
                           var17 = var11;
                           var16 = var2.method_10062();
                        }
                     }
                  }
               }
            }
         }

         if (var16 != null && var17 < 100000.0) {
            return var16;
         }
      }

      return var16;
   }

   private boolean ndb(BlockPos var1) {
      return this.getWorld() != null && var1 != null ? this.getWorld().method_8320(var1).method_27852(Blocks.field_42728) : false;
   }

   private void ndc() {
      if (!this.nde()) {
         this.mc.field_1690.field_1904.method_23481(false);
         this.msj = this.mrz != null ? Vec3d.method_24953(this.mrz) : this.getPlayer().method_73189();
         this.mrz = null;
         this.msu = false;
         this.myd(mpm.LOOTING_SAND);
      } else if (this.mrz != null && this.ndb(this.mrz)) {
         this.msa++;
         int var1 = this.ndg(0, 9);
         if (var1 == -1) {
            int var7 = this.ndg(9, 36);
            if (var7 != -1 && this.msy.isEmpty()) {
               int var3 = this.nav();
               if (var3 == -1) {
                  var3 = 8;
               }

               int var8 = var3;
               this.msy.add(() -> this.ndv(var7, var8, SlotActionType.field_7791));
            }
         } else {
            this.getPlayer().method_31548().method_61496(var1);
            double var2 = this.getPlayer().method_33571().method_1025(Vec3d.method_24953(this.mrz));
            if (!(var2 > 5.0)) {
               if (!this.msb) {
                  this.msb = true;
                  this.msa = 0;
                  this.mqy = null;
                  this.mqz = 0;
               }

               pqf.resetKeys();
               this.ncb(this.mrz, Vec3d.method_24953(this.mrz));
               BlockHitResult var4 = this.nco(this.mrz);
               boolean var5 = var4 != null;
               this.ncd(var5);
               if (var5 && this.mvc > 0) {
                  this.mvc--;
                  var5 = false;
                  var4 = null;
               }

               if (var5) {
                  this.mc.field_1690.field_1904.method_23481(true);
                  if (!this.getPlayer().method_6115()) {
                     BlockHitResult var6 = var4;
                     ptr.later(
                        () -> {
                           if (this.mc.field_1761 != null
                              && this.mc.field_1724 != null
                              && !this.mc.field_1724.method_6115()
                              && ndf(this.mc.field_1724.method_6047())) {
                              this.mc.field_1761.method_2896(this.mc.field_1724, Hand.field_5808, var6);
                              this.mc.field_1724.method_6019(Hand.field_5808);
                           }
                        }
                     );
                  }

                  this.msx = 0;
               } else {
                  this.mc.field_1690.field_1904.method_23481(false);
                  this.msx++;
                  if (this.msx > 40) {
                     this.mra.add(this.mrz);
                     this.mrz = null;
                     this.msx = 0;
                     this.msb = false;
                     this.myd(mpm.FARMING_SAND);
                     return;
                  }
               }

               if (this.msa > 200) {
                  this.mra.add(this.mrz);
                  this.msj = Vec3d.method_24953(this.mrz);
                  this.mrz = null;
                  this.msb = false;
                  this.mc.field_1690.field_1904.method_23481(false);
                  this.msu = false;
                  this.myd(mpm.LOOTING_SAND);
               }
            } else {
               this.msb = false;
               this.mc.field_1690.field_1904.method_23481(false);
               if (this.nbm(this.mrz)) {
                  this.ncp(Vec3d.method_24953(this.mrz));
               } else {
                  if (this.mqy == null || this.mqz >= this.mqy.size()) {
                     this.naz(this.mrz, false);
                  }

                  if (this.mqy != null && this.mqz < this.mqy.size()) {
                     this.ncr();
                  } else {
                     pqf.resetKeys();
                  }
               }

               if (this.msa > this.mys(120)) {
                  this.mra.add(this.mrz);
                  this.mrz = null;
                  this.mc.field_1690.field_1904.method_23481(false);
                  this.myd(mpm.FARMING_SAND);
               }
            }
         }
      } else {
         this.mc.field_1690.field_1904.method_23481(false);
         this.msj = this.mrz != null ? Vec3d.method_24953(this.mrz) : this.getPlayer().method_73189();
         if (this.mrz != null) {
            this.mra.add(this.mrz);
            this.mqv++;
         }

         this.mrz = null;
         this.msu = false;
         this.myd(mpm.LOOTING_SAND);
      }
   }

   private void ndd() {
      if (!this.msu) {
         this.nbp(this.msj != null ? this.msj : this.getPlayer().method_73189());
      }

      this.nbs(this.nde() ? mpm.FARMING_SAND : mpm.CHECK_PVP_COOLDOWN);
   }

   private boolean nde() {
      return this.ndg(0, 36) != -1;
   }

   private static boolean ndf(ItemStack var0) {
      if (!var0.method_31574(Items.field_42716)) {
         return false;
      } else if (var0.method_57826(DataComponentTypes.field_49630)) {
         return true;
      } else {
         LoreComponent var1 = (LoreComponent)var0.method_58694(DataComponentTypes.field_49632);
         if (var1 == null) {
            return false;
         } else {
            for (Text var3 : var1.comp_2400()) {
               if (var3.getString().toLowerCase().contains(a.b("㾐䘩첏劎\ud95e徘\ue5c8氲\uf215碡ｻ", 1763457958))) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   private int ndg(int var1, int var2) {
      for (int var3 = var1; var3 < var2; var3++) {
         if (ndf(this.getPlayer().method_31548().method_5438(var3))) {
            return var3;
         }
      }

      return -1;
   }

   private void ndh() {
      if (this.mwa - this.mwb > 60) {
         this.mqp++;
         this.myd(mpm.TELEPORT_TO_SAVE);
         this.mrt = null;
      } else {
         this.ndi();
      }
   }

   private void ndi() {
      PlayerEntity var1 = this.neh();
      if (var1 != null) {
         if (this.mse <= 0 && (this.mrt == null || this.mrt.method_10262(this.getPlayer().method_24515()) < 10.0 || var1.method_5858(this.getPlayer()) < 400.0)
            )
          {
            Vec3d var2 = this.mzj(
               this.getPlayer().method_73189().method_1020(var1.method_73189()).method_1029(), Math.toRadians(this.mty.nextGaussian() * 20.0)
            );
            double var3 = 26.0 + this.mty.nextDouble() * 14.0;
            this.mrt = this.nbd(this.getPlayer().method_24515().method_10069((int)(var2.field_1352 * var3), 0, (int)(var2.field_1350 * var3)));
            this.mse = 10;
            this.nbc(this.nba(this.mrt));
         }
      } else if (this.mse <= 0 && (this.mrt == null || this.mrt.method_10262(this.getPlayer().method_24515()) < 4.0)) {
         double var6 = this.mty.nextDouble() * Math.PI * 2.0;
         double var4 = 18.0 + this.mty.nextDouble() * 20.0;
         this.mrt = this.nbd(this.getPlayer().method_24515().method_10069((int)Math.round(Math.cos(var6) * var4), 0, (int)Math.round(Math.sin(var6) * var4)));
         this.mse = 10;
         this.nbc(this.nba(this.mrt));
      }

      if (this.mqy != null && this.mqz < this.mqy.size()) {
         this.ncr();
      } else {
         pqf.resetKeys();
      }
   }

   private boolean ndj() {
      return pjn.contains(this.mc, a.d("\uf6dc轋־鮲ᐈ鋌⢜ꅣ㼸놕㉖젭䚂\udf49唐폦榡", 606286106, 1128580999));
   }

   private void ndk() {
      String var1 = nak(this.mqh.get());
      if (!pjd.enter(this.mxs(), var1)) {
         this.nal(a.c(-1477713762, "\ue4a0鴼\u13ff觯Ɍ蓱㺩띟ⴕꏇ②\ude13哑쵳䜳엟羝\uf034櫷\uecdb慉ᬕ閫੬谑ڥ뽻㔶ꯟⷷ\ua636墒튨䭘촇"));
      } else {
         this.mwn = "";
         this.getNetworkHandler().method_45730(var1);
         this.mrh = false;
         this.mri = false;
         this.mrj = false;
         this.mrk = false;
         this.myn();
         this.naa();
         this.mrl = null;
         this.mqr = 0;
         this.mra.clear();
         this.mrt = null;
         this.mrn = 0;
         this.mro = false;
         this.mrp = null;
         this.mrq = 0;
         this.mst = false;
         this.myd(mpm.WARPING_TO_SAVE_BASE);
      }
   }

   private void ndl() {
      pqf.resetKeys();
      this.mzf();
      this.mrn++;
      if (this.naw() > 0) {
         this.mrq = 0;
      } else if (this.mrn >= 60) {
         this.myd(mpm.RESTOCK_AND_DUMP);
      }
   }

   public boolean isTrashItem(ItemStack var1) {
      if (var1.method_7960()) {
         return false;
      } else {
         vlj var2 = this.lootList();
         if (this.mwd != this.mwa || this.mwe != var2.version() || this.mwc.size() > 512) {
            this.mwc.clear();
            this.mwd = this.mwa;
            this.mwe = var2.version();
         }

         Boolean var3 = this.mwc.get(var1);
         if (var3 == null) {
            var3 = this.ndm(var1, var2);
            this.mwc.put(var1, var3);
         }

         return var3;
      }
   }

   private boolean ndm(ItemStack var1, vlj var2) {
      if (this.neg(var1)) {
         return false;
      } else if (var1.method_31574(Items.field_42716)) {
         return true;
      } else if (ppu.picked(var1, var2.ids())) {
         return false;
      } else if (ppu.known(var1)) {
         return true;
      } else {
         Item var3 = var1.method_7909();
         String var4 = var3.method_7876().toLowerCase();
         if (var3 == Items.field_8712) {
            return false;
         } else if (var3 == Items.field_8071) {
            return false;
         } else if (var3 == Items.field_8086 || var3 == Items.field_8136) {
            return false;
         } else if (var3 == Items.field_8463 || var3 == Items.field_8367) {
            return false;
         } else if (var3 == Items.field_49813) {
            return false;
         } else if (var4.contains(a.d("蕫ﳗ瘀\ue874", -1352822735, 531371318)) || var4.contains(a.d("\uf3e2詋\u0086黮ᔹ", 1696324825, -305647795))) {
            return false;
         } else if (var3 == Items.field_8675) {
            return false;
         } else {
            String var5 = var1.method_7964().getString().toLowerCase();
            if (var4.contains(a.b("绠݂趑ᏽ頲", 302743172))) {
               return var5.contains(a.d("풛괨⟼맾", -805642075, 1178742797))
                     || var5.contains(a.d("\uf0f4褿Β鷯ᘺ邉", -630686278, 1317964146))
                     || var5.contains(a.c(2070976211, "鋦\ueb28懿\ufff1瑜\uf29a䣇셁彯"))
                  ? true
                  : var3 != Items.field_8087 && !var1.method_57826(DataComponentTypes.field_49631);
            } else if (var5.contains(a.d("줚냕㨃ꑳ\u2fd8ꥢፃ", -1753364669, 1573915163))) {
               return true;
            } else if (var3 == Items.field_8719) {
               return true;
            } else if (var3 == Items.field_8613) {
               return true;
            } else if (var3 == Items.field_8803) {
               return true;
            } else if (var3 == Items.field_8469) {
               return true;
            } else if (var3 == Items.field_8153) {
               return !var1.method_57826(DataComponentTypes.field_49631);
            } else if (var3 == Items.field_20417 || var3 == Items.field_20414) {
               return true;
            } else if (var3 == Items.field_8657) {
               return true;
            } else if (var3 == Items.field_8536) {
               return true;
            } else if (var3 == Items.field_8070) {
               return true;
            } else if (var3 == Items.field_8815) {
               return true;
            } else if (var3 == Items.field_8711) {
               return true;
            } else if (var3 == Items.field_8301) {
               return true;
            } else if (var3 == Items.field_8102) {
               return true;
            } else if (var3 == Items.field_8745) {
               return true;
            } else if (var3 == Items.field_8687) {
               return true;
            } else if (var3 == Items.field_8620) {
               return true;
            } else if (var3 == Items.field_8695 || var3 == Items.field_8397) {
               return true;
            } else if (var3 == Items.field_8864) {
               return true;
            } else if (var3 == Items.field_8054) {
               return true;
            } else if (var3 == Items.field_8233 || var3 == Items.field_8882) {
               return true;
            } else if (var4.contains(a.c(753118924, "꺕휈巟쎶䡼컛"))) {
               return true;
            } else if (var3 == Items.field_8606) {
               return true;
            } else if (var4.contains(a.b("\uf296謠Ǯ龞ᑟ鋔⢹ꅛ㼛떨㉦", 2075063029)) || var4.contains(a.b("鷋\ue462溲\uf0c9笧ﶨ䟨츆偛\udaf7", 1642700214))) {
               return true;
            } else if (var3 == Items.field_8894) {
               return true;
            } else if (var3 == Items.field_8777) {
               return true;
            } else if (var1.method_57826(DataComponentTypes.field_50075)) {
               return true;
            } else if (var4.contains(a.d("ꢥ턗寕얲乼주犕ﭦ改", -244918230, -2124713739))) {
               return true;
            } else if (var3 == Items.field_8466) {
               return true;
            } else if (var3 == Items.field_8639) {
               return true;
            } else if (var3 == Items.field_8598 || var3 == Items.field_8529 || var3 == Items.field_8360 || var3 == Items.field_8674) {
               return true;
            } else if (var4.contains(a.c(201042272, "꤄킺婱쐟俍"))) {
               return true;
            } else if (var4.contains(a.d("䛺㽚떁⯭ꀦ⚚鳜ᔼ", -1896952143, -882633))) {
               return true;
            } else if (var4.contains(a.d("ῳ晙\uec8d狥嵐羙", 690090973, 1491856475))) {
               return true;
            } else if (var3 == Items.field_17515) {
               return true;
            } else if (var3 == Items.field_8547) {
               return true;
            } else if (var3 == Items.field_8140) {
               return true;
            } else if (var4.contains(a.b("誟\uf336秣\ue788汕\uead8傰\ud94c䜉춨", 1858439928))) {
               return true;
            } else if (var4.contains(a.d("๓矵ﴲ捚\ue895", -123881445, -206719429))) {
               return true;
            } else if (var3 == Items.field_8323) {
               return true;
            } else if (var3 == Items.field_8666 || var3 == Items.field_8714 || var3 == Items.field_8478 || var3 == Items.field_8108) {
               return true;
            } else if (var4.contains(a.c(-1623003556, "\uee38鞊ᵖ茧ࣻ蹝"))) {
               return true;
            } else if (var3 == Items.field_8276) {
               return true;
            } else if (var3 == Items.field_8448) {
               return true;
            } else if (var3 == Items.field_8207) {
               return true;
            } else if ((
                  var4.endsWith(a.b("\ueb8f鈉ᣗ蚯൹诀ㆂ", 120908759))
                     || var4.endsWith(a.c(-1549359105, "Ɜ\ude26哾쪂䅃쟵綢\uf44f樝\ue0b9杻"))
                     || var4.endsWith(a.d("䞴㸶듬⪟ꅈ⟷鶣ᑛ訐", 1280063692, -1278771410))
                     || var4.endsWith(a.b("밠얬佲턃嫏\udc79", -1565016967))
               )
               && !var4.contains(a.d("福5諷ᒚ齀᧦ꎮ⩂됌", -1978584711, -1364703087))) {
               return true;
            } else if (var4.contains(a.d("ᢍ愱\uebea疗﹂磲슫䭡픑徹\ud860∙계㕬뼢", 704415766, 2027065584)) || var4.contains(a.c(-1106399894, "괅풹幢쀟䯊쵺眣ﻩ悈\uea20淮"))) {
               return true;
            } else {
               return !var4.contains(a.c(-385664684, "㤫䂑쩓吾\udfe4奂\ue30a櫦\uf4a8縣履η赪ᓓ麊ᡢꈰ")) && !var4.contains(a.c(376136199, "扤ᯞ鄜ཱ蒫ȍ롅ㆩ꿧╬ꊁ壩혣"))
                  ? var3 == Items.field_8062
                  : true;
            }
         }
      }
   }

   private void ndn() {
      if (this.mqq == mpm.TELEPORT_TO_SAVE || this.mqq == mpm.WARPING_TO_SAVE_BASE || this.mqq == mpm.RESTOCK_AND_DUMP || this.mqq == mpm.TELEPORT_TO_LOOT) {
         this.mus = true;
         this.muu = -1;
         this.muv = 0;
      } else if (!this.mus) {
         if (this.muv > 0) {
            this.muv--;
         }
      } else {
         if (this.muu < 0) {
            boolean var1 = this.mut != null && this.getWorld() != this.mut;
            if (!var1 && !this.mzh()) {
               return;
            }

            this.muu = 10 + this.mty.nextInt(20);
         }

         if (this.muu-- <= 0) {
            this.mus = false;
            this.mut = null;
            this.muu = -1;
            this.muv = 400;
         }
      }
   }

   private void ndo() {
      if (!this.nec()) {
         if (this.mc.field_1755 == null && this.msy.isEmpty() && this.mud <= 0) {
            if (this.mum <= 0 && this.ndx()) {
               int var1 = this.ndy();
               if (var1 != -1) {
                  if (this.mur > 10.0F) {
                     this.mum = 200 + this.mty.nextInt(200);
                     return;
                  }

                  this.ndz(var1);
                  return;
               }
            }

            if (!this.mus && this.mqq != mpm.ESCAPING) {
               if (!this.mc.field_1690.field_1886.method_1434()) {
                  if (!this.msu || this.getPlayer().method_31548().method_7376() == -1) {
                     int var5 = 0;
                     int var2 = 0;

                     for (int var3 = 9; var3 < 36; var3++) {
                        ItemStack var4 = this.getPlayer().method_31548().method_5438(var3);
                        if (var4.method_7960()) {
                           var2++;
                        } else if (this.isTrashItem(var4)) {
                           var5++;
                        }
                     }

                     if (var5 != 0) {
                        if (this.muv > 0 || var2 <= 3 || var5 >= 5 || this.getPlayer().method_31548().method_7376() == -1) {
                           this.muv = 0;

                           for (int var6 = 0; var6 < 9; var6++) {
                              if (this.isTrashItem(this.getPlayer().method_31548().method_5438(var6))) {
                                 var5++;
                              }
                           }

                           this.mud = 1;
                           this.mue = var5;
                           this.muf = 3 + (this.mty.nextFloat() < 0.4F ? 1 : 0);
                           this.mug = 0;
                           this.muh = 30 + var5 * 6;
                           this.mui = -1;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void ndp() {
      this.mug++;
      if (this.mug > this.muh || this.mc.field_1755 != null || this.getPlayer() == null || this.mqq == mpm.ESCAPING || this.mus) {
         this.ndq();
      } else if (this.muf > 0) {
         this.muf--;
      } else if (this.isMovementSilent()) {
         if (this.mue <= 0) {
            this.ndq();
         } else {
            int var1 = this.ndr();
            if (var1 == -1) {
               this.mue = 0;
               this.muf = 1 + this.mty.nextInt(2);
            } else {
               this.ndv(var1, 1, SlotActionType.field_7795);
               this.mui = var1;
               this.mue--;
               int var2 = this.mue > 0 ? this.ndr() : -1;
               if (var2 == -1) {
                  this.mue = 0;
                  this.muf = 1 + this.mty.nextInt(2);
               } else {
                  this.muf = this.ndt(nds(var1, var2));
               }
            }
         }
      }
   }

   private void ndq() {
      this.mud = 0;
      this.mue = 0;
      this.muf = 0;
      this.mug = 0;
      this.muh = 0;
      this.mui = -1;
      this.ndw();
      this.ndu();
   }

   private int ndr() {
      PlayerInventory var1 = this.getPlayer().method_31548();
      int var2 = this.mui != -1 ? this.mui : 13;
      int var3 = -1;
      double var4 = Double.MAX_VALUE;

      for (int var6 = 0; var6 < 36; var6++) {
         if (this.isTrashItem(var1.method_5438(var6))) {
            double var7 = nds(var2, var6);
            if (var7 < var4) {
               var4 = var7;
               var3 = var6;
            }
         }
      }

      return var3;
   }

   private static double nds(int var0, int var1) {
      double var2 = var0 < 9 ? 3.25 : (var0 - 9) / 9;
      double var4 = var0 < 9 ? var0 : (var0 - 9) % 9;
      double var6 = var1 < 9 ? 3.25 : (var1 - 9) / 9;
      double var8 = var1 < 9 ? var1 : (var1 - 9) % 9;
      return Math.hypot(var2 - var6, var4 - var8);
   }

   private int ndt(double var1) {
      int var3 = var1 <= 1.5 ? 2 : (var1 <= 4.0 ? 3 : 4);
      float var4 = this.mty.nextFloat();
      if (var3 == 2 && var4 < 0.12F) {
         var3 = 1;
      } else if (var4 > 0.65F) {
         var3++;
      }

      return var3 - 1;
   }

   private void ndu() {
      if (this.mc.field_1690 != null) {
         KeyBinding[] var1 = new KeyBinding[]{
            this.mc.field_1690.field_1894,
            this.mc.field_1690.field_1881,
            this.mc.field_1690.field_1913,
            this.mc.field_1690.field_1849,
            this.mc.field_1690.field_1903,
            this.mc.field_1690.field_1867
         };

         for (KeyBinding var5 : var1) {
            var5.method_23481(this.heldByHuman(var5));
         }
      }
   }

   private void ndv(int var1, int var2, SlotActionType var3) {
      if (this.mc.field_1761 != null && this.getPlayer() != null) {
         int var4 = var1 < 9 ? var1 + 36 : var1;
         this.mc.field_1761.method_2906(this.getPlayer().field_7498.field_7763, var4, var2, var3, this.getPlayer());
         if (this.mc.field_1755 == null) {
            this.muw = true;
         }
      }
   }

   private void ndw() {
      if (this.muw) {
         this.muw = false;
         if (this.mc.field_1755 == null && this.getPlayer() != null && this.getNetworkHandler() != null) {
            this.getNetworkHandler().method_52787(new CloseHandledScreenC2SPacket(this.getPlayer().field_7498.field_7763));
         }
      }
   }

   private boolean ndx() {
      return this.mc.field_1755 == null
         && !this.muw
         && this.msy.isEmpty()
         && this.mud == 0
         && !this.mus
         && !this.mc.field_1690.field_1886.method_1434()
         && !this.mc.field_1690.field_1904.method_1434()
         && !this.getPlayer().method_6115()
         && !this.getPlayer().method_7325()
         && this.mqq != mpm.BRUSHING_SAND
         && this.mqq != mpm.ESCAPING
         && this.mqq != mpm.LOOTING_VASE
         && !this.mvh;
   }

   private int ndy() {
      PlayerInventory var1 = this.getPlayer().method_31548();
      int var2 = var1.method_67532();
      int var3 = -1;

      for (int var4 = 0; var4 < 9; var4++) {
         if (this.isTrashItem(var1.method_5438(var4)) && (var3 == -1 || Math.abs(var4 - var2) < Math.abs(var3 - var2))) {
            var3 = var4;
         }
      }

      return var3;
   }

   private void ndz(int var1) {
      this.neb();
      this.muk = var1;
      boolean var2 = this.getPlayer().method_31548().method_67532() == var1;
      this.mul = var2 ? 0 : this.nea();
      this.getPlayer().method_31548().method_61496(var1);
   }

   private int nea() {
      float var1 = this.mty.nextFloat();
      return var1 < 0.2F ? 0 : (var1 < 0.6F ? 1 : (var1 < 0.9F ? 2 : 3));
   }

   private void neb() {
      this.muk = -1;
      this.mul = 0;
      this.mun = false;
      this.muo = 0;
      this.mup = 0;
   }

   private boolean nec() {
      if (this.muk == -1) {
         return false;
      } else if (this.mun) {
         if (this.mup == 0 && ++this.muo <= 3) {
            return true;
         } else {
            boolean var4 = this.mup > 0;
            this.neb();
            if (var4) {
               this.mur++;
               this.mum = this.mty.nextInt(3);
            } else {
               this.mum = 8 + this.mty.nextInt(12);
            }

            return false;
         }
      } else {
         PlayerInventory var1 = this.getPlayer().method_31548();
         if (this.ndx() && this.isTrashItem(var1.method_5438(this.muk))) {
            if (var1.method_67532() != this.muk) {
               this.neb();
               this.mum = 10 + this.mty.nextInt(10);
               return false;
            } else if (this.mul-- > 0) {
               return true;
            } else {
               int var2 = this.muk;
               int var3 = ++this.muq;
               this.mun = true;
               this.muo = 0;
               this.mup = 0;
               ptr.later(() -> {
                  boolean var3x = this.ned(var2, var3);
                  if (var3 == this.muq) {
                     this.mup = var3x ? 1 : -1;
                  }
               });
               return true;
            }
         } else {
            this.neb();
            this.mum = 4 + this.mty.nextInt(8);
            return false;
         }
      }
   }

   private boolean ned(int var1, int var2) {
      ClientPlayerEntity var3 = this.mc.field_1724;
      if (var2 == this.muq && this.mun && var3 != null && this.mc.field_1755 == null && !var3.method_7325() && var3.method_31548().method_67532() == var1) {
         ItemStack var4 = var3.method_6047();
         if (!this.isTrashItem(var4)) {
            return false;
         } else if (!var3.method_7290(var4.method_7947() > 1)) {
            return false;
         } else {
            var3.method_6104(Hand.field_5808);
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean busy() {
      return !this.msy.isEmpty() || this.mud > 0 || this.mtb > 0 || this.mc.field_1755 instanceof GenericContainerScreen;
   }

   private void nee() {
      if (this.mc.field_1755 == null && this.msy.isEmpty() && this.mud <= 0 && this.muk == -1) {
         int var1 = 0;

         for (int var2 = 0; var2 < 9; var2++) {
            if (this.getPlayer().method_31548().method_5438(var2).method_7960()) {
               var1++;
            }
         }

         if (var1 < 2) {
            for (int var7 = 0; var7 < 9; var7++) {
               ItemStack var3 = this.getPlayer().method_31548().method_5438(var7);
               if (!this.isTrashItem(var3) && !this.neg(var3)) {
                  int var4 = this.nef();
                  if (var4 == -1) {
                     return;
                  }

                  int var5 = var7;
                  this.msy.add(() -> this.ndv(var4, var5, SlotActionType.field_7791));
                  return;
               }
            }
         }
      }
   }

   private int nef() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (this.getPlayer().method_31548().method_5438(var1).method_7960()) {
            return var1;
         }
      }

      return -1;
   }

   private boolean neg(ItemStack var1) {
      if (var1.method_7960()) {
         return true;
      } else {
         return var1.method_7909() != Items.field_8071 && !ndf(var1) && var1.method_7909() != Items.field_8705 ? this.nel(var1) || this.neo(var1) : true;
      }
   }

   private PlayerEntity neh() {
      PlayerEntity var1 = null;
      double var2 = 2500.0;

      for (PlayerEntity var5 : this.getWorld().method_18456()) {
         if (var5 != this.getPlayer()) {
            double var6 = var5.method_5858(this.getPlayer());
            if (var6 < var2) {
               var2 = var6;
               var1 = var5;
            }
         }
      }

      return var1;
   }

   private int nei(Item var1) {
      for (int var2 = 0; var2 < 9; var2++) {
         if (this.getPlayer().method_31548().method_5438(var2).method_7909() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int nej() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.nel(this.getPlayer().method_31548().method_5438(var1))) {
            return var1;
         }
      }

      return -1;
   }

   private int nek() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (this.nel(this.getPlayer().method_31548().method_5438(var1))) {
            return var1;
         }
      }

      return -1;
   }

   private boolean nel(ItemStack var1) {
      if (var1.method_7960()) {
         return false;
      } else if (var1.method_7909() != Items.field_8574 && var1.method_7909() != Items.field_8436 && var1.method_7909() != Items.field_8150) {
         return false;
      } else {
         PotionContentsComponent var2 = (PotionContentsComponent)var1.method_58694(DataComponentTypes.field_49651);
         if (var2 != null) {
            int var3 = 0;
            boolean var4 = false;

            for (StatusEffectInstance var6 : var2.method_57397()) {
               var3++;
               if (var6.method_5579() == StatusEffects.field_5905) {
                  var4 = true;
               }
            }

            if (var3 > 0) {
               return var3 == 1 && var4;
            }
         }

         String var7 = var1.method_7964().getString().toLowerCase();
         return var7.contains(a.d("諹\uf340禔\ue7ef水\uea89僞", -425032786, 1206390125));
      }
   }

   private int nem() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.neo(this.getPlayer().method_31548().method_5438(var1))) {
            return var1;
         }
      }

      return -1;
   }

   private int nen() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (this.neo(this.getPlayer().method_31548().method_5438(var1))) {
            return var1;
         }
      }

      return -1;
   }

   private boolean neo(ItemStack var1) {
      if (var1.method_7960()) {
         return false;
      } else if (var1.method_7909() != Items.field_8574 && var1.method_7909() != Items.field_8436 && var1.method_7909() != Items.field_8150) {
         return false;
      } else {
         PotionContentsComponent var2 = (PotionContentsComponent)var1.method_58694(DataComponentTypes.field_49651);
         if (var2 != null) {
            int var3 = 0;
            boolean var4 = false;

            for (StatusEffectInstance var6 : var2.method_57397()) {
               var3++;
               if (var6.method_5579() == StatusEffects.field_5904) {
                  var4 = true;
               }
            }

            if (var3 > 0) {
               return var3 == 1 && var4;
            }
         }

         String var7 = var1.method_7964().getString().toLowerCase();
         return var7.contains(a.b("釙\ue813拄ﳋ睢\uf1ac䯼", -1835756129)) || var7.contains(a.c(-96193484, "㑂䷰윶奇튑"));
      }
   }
}
