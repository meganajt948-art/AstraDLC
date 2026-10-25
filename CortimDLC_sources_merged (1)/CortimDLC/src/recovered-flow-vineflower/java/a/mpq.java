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
   static final String mpr = a.b("㞺丬쓽媄", 1693399030);
   static final String mps = a.b("⨛厜\ud95c䜯", 1390946888);
   static final List<BlockPos> mpt = Collections.emptyList();
   static final int[] mpu = new int[]{0, 45, -45, 90, -90, 135, -135, 180};
   static final float mpv = -55.0F;
   static final int mpw = 2400;
   static final long mpx = 6000L;
   static final int mpy = 2;
   static final int mpz = 200;
   static final int mqa = 3;
   static final int mqb = 100;
   static final float mqc = 86.0F;
   final vmc mqd = this.add(new vmc(a.d("⾞嘃\udcc9䋠쥡俇\uf586籡\ue228", -2028986025, -1575547251), 10.0, 1.0, 30.0, 1.0));
   final vlj mqe = this.add(new vlj(a.b("\ue5d2鱀ᚓ裹ͺ薇㿑똺⡢", 1473504663), vlg.LOOT, ppu.END_DEFAULTS));
   final vkl mqf = this.add(new vkl(a.c(-678181698, "쓢뵵㞰ꦄ∑꒰Ụ霓ॗ"), false));
   final vkl mqg = this.add(new vkl(a.d("뒰촴䟭\ud992刀퓢溲\ue756礉\uf3b9", 654443813, 53916107), false));
   final vmu mqh = this.add(new vmu(a.b("鲚\ue519濝\uf1bf稭ﳹ䚁콺", -871719743), a.d("Ὣ曕\uec5d爩粒", 2023181717, -397127014), 32));
   final vmu mqi = this.add(new vmu(a.c(-277864943, "ṕ柇\ued14獾\uf8fd縩쑑䶪"), a.d("꧶큈嫀쒴佫", 1969651208, 141612954), 120));
   final vlv mqj = this.add(
      new vlv(a.d("\ue313骓၉踱׳荝㤓냤⻯ꐜ⏔", -98598428, -323591512), a.d("Ꭶ樰\ue0e1纘", -369263833, 370763981), a.b("䇇㡑늀⳹", 925188491), a.c(70318726, "𥉉荒\u0992韡"))
   );
   final vmu mqk = this.add(new vmu(a.c(2023459489, "諿\uf378禸\ue7cb汌\ueab3僯\ud912䝅"), a.b("⿳噉\udc90", 1374891925), 32));
   final vkl mql = this.add(new vkl(a.b("댘쪒䁆\ude2f喯퍌椂\ue0e9纷\uf417", -1426279615), false));
   final vkw mqm = this.add(
      new vkw(
         a.b("㒆䴜쟟妩퉣咝\uee99松郎玚\uf44b\u0e3d胣", 1860777157),
         new vkq(a.b("\uf219讟Ŋ鼷ᓽ鉚⡍ꇽ㾭딖㊁좤䙵\udfd7喌퍺", 1798107739), vhz.LAYERS, () -> ign.openWalk(a.c(693239075, "ﵥ蓠า遘ᮥ鴿❦")))
      )
   );
   static mpq mqn;
   final pnz mqo = new pnz();
   int mqp = 0;
   mpm mqq = mpm.RESTOCK_AND_DUMP;
   int mqr = 0;
   long mqs = 0L;
   long mqt = 0L;
   int mqu = 0;
   int mqv = 0;
   int mqw = 0;
   int mqx = -1;
   List<BlockPos> mqy = null;
   int mqz = 0;
   final Set<BlockPos> mra = new HashSet<>();
   int mrb = 0;
   int mrc = 0;
   final List<String> mrd = new ArrayList<>(
      List.of(a.b("歛ያ頼", 1128689517), a.d("햛갯⛳뢈㍐", -1629421280, 1886703750), a.c(360675067, "犲\u0b78膯ᾠ鐉\u12c7ꢗⅨ"))
   );
   int mre = 3;
   pmf mrf = null;
   int mrg = 0;
   boolean mrh = false;
   boolean mri = false;
   boolean mrj = false;
   boolean mrk = false;
   BlockPos mrl = null;
   String mrm = "";
   int mrn = 0;
   boolean mro = false;
   BlockPos mrp = null;
   int mrq = 0;
   BlockPos mrr = null;
   int mrs = 0;
   BlockPos mrt = null;
   int mru = 0;
   int mrv = 0;
   int mrw = 0;
   int mrx = 1;
   boolean mry = false;
   BlockPos mrz = null;
   int msa = 0;
   boolean msb = false;
   int msc = 0;
   int msd = 0;
   int mse = 0;
   int msf = 0;
   int msg = 0;
   int msh = 0;
   int msi = 0;
   Vec3d msj = null;
   boolean msk = false;
   final Set<Integer> msl = new HashSet<>();
   final Set<Integer> msm = new HashSet<>();
   int msn = 0;
   double mso = Double.MAX_VALUE;
   int msp = -1;
   boolean msq = false;
   int msr = 0;
   int mss = 0;
   boolean mst = false;
   boolean msu = false;
   int msv = 0;
   int msw = 0;
   int msx = 0;
   final Queue<Runnable> msy = new LinkedList<>();
   int msz = 0;
   long mta = 0L;
   int mtb = 0;
   float mtc = 0.0F;
   boolean mtd = false;
   int mte = 0;
   int mtf = 0;
   float mtg = 0.0F;
   int mth = 0;
   Vec3d mti = null;
   int mtj = 0;
   int mtk = 0;
   final pjw mtl = new pjw().neuro(lex.END);
   final pud mtm = pud.INSTANCE;
   boolean mtn = false;
   boolean mto = false;
   boolean mtp = false;
   boolean mtq = false;
   boolean mtr = false;
   float mts = 0.0F;
   float mtt = 0.0F;
   float mtu = 0.0F;
   float mtv = 0.0F;
   PlayerEntity mtw = null;
   Vec3d mtx = null;
   final Random mty = new Random();
   float mtz = 0.0F;
   boolean mua = false;
   boolean mub = false;
   boolean muc = false;
   int mud = 0;
   int mue = 0;
   int muf = 0;
   int mug = 0;
   int muh = 0;
   int mui = -1;
   int muj = 0;
   int muk = -1;
   int mul = 0;
   int mum = 0;
   boolean mun = false;
   int muo = 0;
   int mup = 0;
   int muq = 0;
   float mur = 0.0F;
   boolean mus = false;
   World mut = null;
   int muu = -1;
   int muv = 0;
   boolean muw = false;
   boolean mux = false;
   Vec3d muy = null;
   double muz = 0.0;
   double mva = 0.0;
   double mvb = 0.0;
   int mvc = 0;
   double mvd = 0.0;
   boolean mve = false;
   int mvf = 0;
   int mvg = 0;
   boolean mvh = false;
   int mvi = 0;
   int mvj = 0;
   BlockPos mvk = null;
   final pyd mvl = new pyd();
   psf mvm = null;
   pqq mvn = null;
   BlockPos mvo = null;
   boolean mvp = false;
   boolean mvq = false;
   boolean mvr = false;
   final double[] mvs = new double[2];
   double mvt = Double.NaN;
   int mvu = 0;
   int mvv = 0;
   final Set<Long> mvw = new HashSet<>();
   int mvx = 0;
   boolean mvy = false;
   String mvz = null;
   int mwa = 0;
   int mwb = 0;
   final Map<ItemStack, Boolean> mwc = new IdentityHashMap<>();
   int mwd = -1;
   int mwe = -1;
   int mwf = 0;
   float mwg = 10.0F;
   int mwh = 0;
   int mwi = 0;
   BlockPos mwj = null;
   long mwk = 0L;
   int mwl = -1;
   int mwm = -100000;
   String mwn = "";
   Vec3d mwo = null;
   int mwp = 0;
   int mwq = 0;
   int mwr = -1;
   int mws = -100000;
   final int[] mwt = new int[]{-1, -1};
   final int[] mwu = new int[2];
   final int[] mwv = new int[2];
   final int[] mww = new int[2];
   final int[] mwx = new int[2];
   final boolean[] mwy = new boolean[2];
   World mwz = null;
   PlayerEntity mxa = null;
   Vec3d mxb = null;
   int mxc = -1;
   volatile boolean mxd = false;
   int mxe = 0;
   int mxf = 0;
   int mxg = 0;
   int mxh = 0;
   String mxi = "";
   boolean mxj = false;
   boolean mxk = false;
   volatile int mxl = -100000;
   volatile String mxm = null;
   PlayerEntity mxn = null;
   int mxo = -100000;

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

   boolean mxr(ItemStack var1) {
      return ppu.picked(var1, this.lootList().ids());
   }

   public String queueNote() {
      return this.mwn;
   }

   Object mxs() {
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

   String mxt() {
      if (!a.c(1694846919, "侔㘓볓⊠").equals(this.mqj.get())) {
         return a.c(2020307053, "瀌\u09ba荫ᴒ隀ၹꨭ⏞붉");
      }

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

   @Override
   protected void onEnable() {
      if (this.getPlayer() != null) {
         this.mtc = this.getPlayer().getHealth();
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

   void mxu() {
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
      if (this.mc.interactionManager != null) {
         this.mc.interactionManager.cancelBlockBreaking();
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

   void mxv() {
      this.mxw(true);
   }

   void mxw(boolean var1) {
      this.mc.options.sneakKey.setPressed(var1);
      this.mc.options.useKey.setPressed(true);
      ptr.miss();
   }

   void mxx() {
      if (this.mc.options != null) {
         this.mc.options.useKey.setPressed(false);
         this.mc.options.sneakKey.setPressed(false);
      }
   }

   boolean mxy(float var1) {
      this.nby(this.mto ? this.mts : this.mtl.intentYaw(), var1);
      return Math.abs(this.mtl.intentPitch() - var1) <= 0.75F;
   }

   boolean mxz() {
      boolean var1 = this.getPlayer().getHungerManager().getFoodLevel() < 18;
      int var2 = this.nei(Items.GOLDEN_CARROT);
      boolean var3 = this.nci();
      if (this.mtf == 0) {
         if (!var1 || var2 == -1) {
            if (this.mc.options.useKey.isPressed() && this.mqq != mpm.BRUSHING_SAND) {
               this.mxx();
               if (this.getPlayer().getMainHandStack().getItem() == Items.GOLDEN_CARROT) {
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

            this.getPlayer().getInventory().setSelectedSlot(var2);
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

   void mya() {
      if (this.nci()) {
         this.ncr();
         this.mc.options.sprintKey.setPressed(false);
         this.mc.options.jumpKey.setPressed(false);
      } else {
         pqf.resetKeys();
         this.ncf();
      }
   }

   void myb() {
      this.mxx();
      this.mtf = 0;
      this.mth = 0;
   }

   boolean myc(ItemStack var1) {
      return var1.isEmpty() ? false : var1.getItem() == Items.GOLDEN_CARROT || var1.getItem() == Items.WATER_BUCKET || this.nel(var1) || this.neo(var1);
   }

   void myd(mpm var1) {
      if (this.mqq != var1) {
         this.mqq = var1;
         this.mwn = "";
      }
   }

   void mye(String var1) {
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

   void myf() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 != this.mxn) {
         this.mxo = this.mwa;
      }

      this.mxn = var1;
   }

   void myg() {
      int var1 = this.mxl;
      if (this.mwa - var1 <= 100) {
         ClientPlayerEntity var2 = this.getPlayer();
         boolean var3 = var2.isDead() || var2.getHealth() <= 0.0F;
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

   boolean myh() {
      StatusEffectInstance var1 = this.getPlayer().getStatusEffect(StatusEffects.INVISIBILITY);
      return var1 != null ? var1.getDuration() > 600 : false;
   }

   boolean myi() {
      StatusEffectInstance var1 = this.getPlayer().getStatusEffect(StatusEffects.SPEED);
      return var1 != null ? var1.getDuration() > 600 : false;
   }

   int myj(boolean var1) {
      StatusEffectInstance var2 = this.getPlayer().getStatusEffect(var1 ? StatusEffects.INVISIBILITY : StatusEffects.SPEED);
      return var2 == null ? 0 : (var2.isInfinite() ? Integer.MAX_VALUE : var2.getDuration());
   }

   boolean myk(boolean var1) {
      int var2 = var1 ? 0 : 1;
      if (!this.mwy[var2] && this.mwu[var2] <= 0 && this.nab(var1) != 0) {
         int var3 = this.mww[var2] > 0 ? Math.min(600, this.mww[var2] * 3 / 4) : 600;
         return this.myj(var1) <= var3;
      } else {
         return false;
      }
   }

   void myl() {
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

   void mym(int var1) {
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

   void myn() {
      for (int var1 = 0; var1 < 2; var1++) {
         this.mwu[var1] = 0;
         this.mwy[var1] = false;
         this.mwx[var1] = 0;
      }
   }

   void myo(String var1) {
      this.mxg++;
      this.mxi = var1;
   }

   boolean myp() {
      int var1 = Math.max(this.mxg, this.mxh);
      if (var1 < 3) {
         return false;
      }

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
         this.mtz = this.getPlayer().getYaw();
         this.mua = true;
         this.mvl.beginTick();
         boolean var2 = this.myq();
         if (var2 && this.mc.options != null) {
            this.mvp = this.mc.options.sprintKey.isPressed();
            this.mvq = this.mc.options.sneakKey.isPressed();
         }

         try {
            this.myz();
         } finally {
            if (var2) {
               this.myu();
            }

            this.nck();
            if (this.mud > 0 && this.mc.options != null) {
               this.mc.options.attackKey.setPressed(false);
               this.mc.options.useKey.setPressed(false);
            }

            this.myx();
            this.mub = this.mc.options != null && this.mc.options.attackKey.isPressed();
            this.muc = this.mc.options != null && this.mc.options.useKey.isPressed();
            if (this.driver == null) {
               pnf.publish(this.mvl.shown(), this.mvl.shownAt(), var2, var2 && this.myr(), this.mql.get(), this.getName());
            }
         }
      }
   }

   boolean myq() {
      return this.driver == null && mqn == this && this.isEnabled() && tcz.walkGuide();
   }

   boolean myr() {
      return this.mvr || this.getPlayer().isUsingItem() || this.ncm() || this.mrf != null || this.muw || this.mc.currentScreen != null;
   }

   int mys(int var1) {
      return this.myq() ? var1 * 3 : var1;
   }

   txs myt() {
      return lfa.walkModel(lex.END);
   }

   void myu() {
      GameOptions var1 = this.mc.options;
      if (var1 != null && !this.ncm() && this.mrf == null && !this.muw) {
         KeyBinding[] var2 = new KeyBinding[]{var1.forwardKey, var1.backKey, var1.leftKey, var1.rightKey, var1.jumpKey};

         for (KeyBinding var6 : var2) {
            var6.setPressed(this.heldByHuman(var6));
         }

         if (var1.getSprintToggled().getValue()) {
            if (var1.sprintKey.isPressed() != this.mvp) {
               var1.sprintKey.setPressed(true);
            }
         } else {
            var1.sprintKey.setPressed(this.heldByHuman(var1.sprintKey));
         }

         if (var1.getSneakToggled().getValue()) {
            if (var1.sneakKey.isPressed() != this.mvq) {
               var1.sneakKey.setPressed(true);
            }
         } else {
            var1.sneakKey.setPressed(this.heldByHuman(var1.sneakKey));
         }
      }
   }

   void myv() {
      long var1 = System.currentTimeMillis();
      if (this.mqt != 0L) {
         long var3 = var1 - this.mqt;
         if (var3 > 0L && var3 < 5000L) {
            this.mqs += var3;
         }
      }

      this.mqt = var1;
   }

   void myw() {
      PlayerInventory var1 = this.getPlayer().getInventory();
      int var2 = 0;

      for (int var3 = 0; var3 < var1.size(); var3++) {
         ItemStack var4 = var1.getStack(var3);
         if (ndf(var4)) {
            var2 += var4.getCount();
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
      boolean var6 = this.getPlayer().currentScreenHandler != this.getPlayer().playerScreenHandler;
      if (this.mqx >= 0 && var2 > this.mqx && var5 && !var6) {
         this.mqw = this.mqw + (var2 - this.mqx);
      }

      this.mqx = var2;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.mc.options != null) {
         this.mc.options.attackKey.setPressed(this.mub);
         this.mc.options.useKey.setPressed(this.muc);

         while (this.mc.options.attackKey.wasPressed()) {
         }

         while (this.mc.options.useKey.wasPressed()) {
         }

         if (this.mud > 0) {
            this.silenceMovement();
         }

         if (this.mc.player != null && this.mc.world != null) {
            if (this.driver == null && !this.mux && this.mua && this.mtn && this.mud == 0) {
               this.mtm.remapHumanKeys(this.mc, this.mtm.cameraYaw(this.mc.player), this.mtu);
            }

            ptr.applyOwn(this.mc);
         }
      }
   }

   void myx() {
      if (this.mc.options != null && this.mud <= 0) {
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

   void myy() {
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

   void myz() {
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
            && this.getPlayer().getEntityPos().squaredDistanceTo(this.mwo) < 1.0E-4
            && var1
            && this.mvi <= 0
            && this.mud == 0
            && !this.myq()
            && (this.mc.options.forwardKey.isPressed() || this.mqy != null)) {
            this.mwp++;
            if (this.mwp > 6 && this.getPlayer().isOnGround() && pqf.isJumpUseful(this.ncj())) {
               this.mc.options.jumpKey.setPressed(true);
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
            this.mwo = this.getPlayer().getEntityPos();
         }

         this.mwf = pqf.onClimbable(this.getPlayer()) ? this.mwf + 1 : 0;
         if (this.mc.currentScreen instanceof AbstractSignEditScreen) {
            this.mc.currentScreen.close();
         } else if (this.mqq != mpm.RESTOCK_AND_DUMP && this.mc.currentScreen instanceof HandledScreen && !(this.mc.currentScreen instanceof InventoryScreen)) {
            this.mxx();
            this.mc.player.closeHandledScreen();
         } else {
            this.mc.options.sneakKey.setPressed(this.mc.options.useKey.isPressed() && this.myc(this.getPlayer().getMainHandStack()) && !this.nci());
            if (!(this.getPlayer().getHealth() <= 0.0F) && !this.getPlayer().isDead()) {
               if (this.mte > 0) {
                  this.mte--;
               }

               if (this.getPlayer().fallDistance > 3.0) {
                  this.mtd = true;
               } else if (this.mtd) {
                  this.mtd = false;
                  this.mte = 6;
               }

               float var2 = this.getPlayer().getHealth();
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

               if (!this.mst && !this.mc.options.useKey.isPressed()) {
                  this.nee();
                  this.ndo();
                  if (this.muk == -1 && !this.ncm() && !this.muw && this.mqq != mpm.BRUSHING_SAND && this.mqq != mpm.ESCAPING) {
                     ItemStack var3 = this.getPlayer().getMainHandStack();
                     if (!var3.isEmpty()
                        && !var3.getItem().getTranslationKey().contains(a.b("馄\ue031櫺\uf496罗", -2090100238))
                        && !var3.getItem().getTranslationKey().contains(a.b("ﾂ蘿೮銙", -937033749))
                        && var3.getItem() != Items.GOLDEN_CARROT
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
                     if (this.mc.player != null && this.mc.currentScreen != null) {
                        this.mc.player.closeHandledScreen();
                     }
                  } else {
                     this.msz++;
                     boolean var8 = this.mc.currentScreen instanceof GenericContainerScreen;
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
                           if (this.getPlayer().getInventory().getSelectedSlot() != var5) {
                              this.getPlayer().getInventory().setSelectedSlot(var5);
                              this.mxx();
                              this.msw = 0;
                              return;
                           }

                           int var11 = var7 ? 0 : 1;
                           this.msw++;
                           if (this.getPlayer().getInventory().getStack(var5).isOf(Items.POTION) || this.mxy(86.0F) && !(this.mtv < 78.0F)) {
                              this.mwr = var11;
                              this.mws = this.mwa;
                              this.mxv();
                              if (!this.getPlayer().isUsingItem() && this.msw % 5 == 0) {
                                 ptr.later(() -> {
                                    if (this.mc.player != null && this.mc.interactionManager != null && !this.mc.player.isUsingItem()) {
                                       this.mc.interactionManager.interactItem(this.mc.player, Hand.MAIN_HAND);
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
                     this.mc.options.attackKey.setPressed(false);
                     this.mc.options.useKey.setPressed(false);
                     if (this.mc.interactionManager != null) {
                        this.mc.interactionManager.cancelBlockBreaking();
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

   boolean mza() {
      if (this.mtk > 0) {
         this.mtk--;
      }

      Vec3d var1 = this.getPlayer().getEntityPos();
      if (this.mti != null && !(var1.squaredDistanceTo(this.mti) > 2.25)) {
         this.mtj++;
         if (this.mqq == mpm.RESTOCK_AND_DUMP && this.mxk) {
            this.mtj = 0;
            return false;
         }

         if (this.mtj >= 2400 && this.mtk <= 0) {
            pqf.resetKeys();
            this.mxx();
            if (this.mc.player != null && this.mc.currentScreen != null) {
               this.mc.player.closeHandledScreen();
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

   void mzb(boolean var1) {
      boolean var2 = this.mc.options.forwardKey.isPressed();
      if (var1 && var2 && pqf.isBlockedHorizontally()) {
         this.mrw++;
         if (this.mrw >= 8) {
            this.mux = true;
            if (this.mrw % 20 == 0) {
               this.mrx = -this.mrx;
            }

            if (this.mrx > 0) {
               this.mc.options.rightKey.setPressed(true);
               this.mc.options.leftKey.setPressed(false);
            } else {
               this.mc.options.leftKey.setPressed(true);
               this.mc.options.rightKey.setPressed(false);
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
            this.mc.options.leftKey.setPressed(false);
            this.mc.options.rightKey.setPressed(false);
         }
      }
   }

   void mzc(float var1) {
      float var2 = 1.0F;
      float var3 = 0.0F;
      float var4 = Float.MAX_VALUE;

      for (float var5 = -1.0F; var5 <= 1.0F; var5++) {
         for (float var6 = -1.0F; var6 <= 1.0F; var6++) {
            if (var5 != 0.0F || var6 != 0.0F) {
               double var7 = Math.toDegrees(pud.inputDirection(this.mtu, var5, var6));
               float var9 = Math.abs(MathHelper.wrapDegrees((float)var7 - var1));
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
      this.mc.options.forwardKey.setPressed(var2 > 0.0F);
      this.mc.options.backKey.setPressed(var2 < 0.0F);
      this.mc.options.leftKey.setPressed(var3 > 0.0F);
      this.mc.options.rightKey.setPressed(var3 < 0.0F);
   }

   static float mzd(double var0, double var2) {
      return (float)Math.toDegrees(Math.atan2(-var0, var2));
   }

   boolean mze() {
      if (this.mwf < 6) {
         return false;
      }

      ClientPlayerEntity var1 = this.getPlayer();
      if (this.nci() && pqf.getStandY(this.mqy.get(this.mqz)) > var1.getY() + 0.6) {
         return false;
      }

      this.mqy = null;
      this.mqz = 0;
      this.mse = 0;
      this.ncf();
      Vec3d var2 = pqf.awayFromClimbable(var1);
      pqf.resetKeys();
      this.mzc(var2 != null ? mzd(var2.x, var2.z) : this.ncj() + 180.0F);
      this.mc.options.sprintKey.setPressed(false);
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

   void mzf() {
      if (pqf.onClimbable(this.getPlayer()) && this.mc.options != null) {
         this.mc.options.sneakKey.setPressed(true);
      }
   }

   void mzg() {
      if (Math.abs(this.mtl.intentPitch() - this.mwg) > 6.0F) {
         this.nbz(this.mtl.intentYaw(), this.mwg, true);
      } else {
         this.ncf();
      }
   }

   boolean mzh() {
      if (this.mc.world != null && this.getPlayer() != null) {
         String var1 = this.mc.world.getRegistryKey().getValue().toString().toLowerCase();
         Optional var2 = this.mc.world.getBiome(this.getPlayer().getBlockPos()).getKey();
         String var3 = var2.isPresent() ? ((RegistryKey)var2.get()).getValue().toString().toLowerCase() : "";
         return var1.contains(a.b("얇밽㛤", -832584223)) || var3.contains(a.c(-30972929, "掙ᨣ郺"));
      } else {
         return false;
      }
   }

   void mzi() {
      this.mru++;
      this.mc.options.attackKey.setPressed(false);
      this.mxx();
      if (this.mc.interactionManager != null) {
         this.mc.interactionManager.cancelBlockBreaking();
      }

      PlayerEntity var1 = this.neh();
      double var2 = var1 != null ? var1.squaredDistanceTo(this.getPlayer()) : Double.MAX_VALUE;
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
            Vec3d var5 = this.mzj(this.getPlayer().getEntityPos().subtract(var1.getEntityPos()).normalize(), Math.toRadians(mpu[this.mrv]));
            Vec3d var6 = this.getPlayer().getEntityPos().add(var5.multiply(12.0));
            this.ncp(new Vec3d(var6.x, this.getPlayer().getY(), var6.z));
         } else {
            this.ncf();
            this.mux = true;
            this.mc.options.forwardKey.setPressed(true);
            pyd.setSprint(this.mc.options, true);
         }

         if (this.mru > 200) {
            pqf.resetKeys();
            this.myd(mpm.FARMING);
         }
      }
   }

   Vec3d mzj(Vec3d var1, double var2) {
      double var4 = Math.cos(var2);
      double var6 = Math.sin(var2);
      return new Vec3d(var1.x * var4 - var1.z * var6, 0.0, var1.x * var6 + var1.z * var4).normalize();
   }

   void mzk(PlayerEntity var1) {
      Vec3d var2 = this.getPlayer().getEntityPos().subtract(var1.getEntityPos()).normalize();
      BlockPos var3 = this.getPlayer().getBlockPos();

      for (int var4 = 0; var4 < 3; var4++) {
         int var5 = (this.mrv + var4) % mpu.length;
         double var6 = mpu[var5] + this.mty.nextGaussian() * 12.0;
         Vec3d var8 = this.mzj(var2, Math.toRadians(var6));
         double var9 = 26.0 + this.mty.nextDouble() * 12.0;
         BlockPos var11 = this.nbd(var3.add((int)(var8.x * var9), 0, (int)(var8.z * var9)));
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

   void mzl() {
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
         if (this.mrl != null && !(this.mc.currentScreen instanceof GenericContainerScreen) && this.mwa - this.mwh > 400) {
            this.mrl = null;
            this.mqy = null;
            this.mc.options.useKey.setPressed(false);
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
            this.ncb(this.mrl, var5 != null ? var5 : Vec3d.ofCenter(this.mrl));
            if (this.mc.currentScreen instanceof GenericContainerScreen var6 && !this.mzp(var6)) {
               this.mc.player.closeHandledScreen();
               return;
            }

            if (!(this.mc.currentScreen instanceof GenericContainerScreen)) {
               BlockHitResult var7 = this.nco(this.mrl);
               boolean var9 = false;
               if (var7 != null && this.mvc > 0) {
                  this.mvc--;
               } else if (var7 != null) {
                  var9 = System.currentTimeMillis() - this.mta > 500L;
               } else {
                  this.mvg++;
                  if (this.mvg > 40 && this.getPlayer().getBlockPos().getSquaredDistance(this.mrl) < 16.0 && System.currentTimeMillis() - this.mta > 500L) {
                     BlockHitResult var4 = this.mzr(this.mrl);
                     if (var4 != null) {
                        ptr.later(() -> {
                           if (this.mc.interactionManager != null && this.mc.player != null && this.mc.currentScreen == null) {
                              this.mc.interactionManager.interactBlock(this.mc.player, Hand.MAIN_HAND, var4);
                              this.mc.player.swingHand(Hand.MAIN_HAND);
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

               this.mc.options.useKey.setPressed(var9);
            } else {
               this.mc.options.useKey.setPressed(false);
               GenericContainerScreen var8 = (GenericContainerScreen)this.mc.currentScreen;
               if (this.mrm.equals(a.c(-1340484654, "힖깗⓵뫺ㅒ"))) {
                  this.mzt(var8);
                  this.msy.add(() -> {
                     this.mrh = true;
                     this.mc.player.closeHandledScreen();
                     this.mrl = null;
                  });
               } else if (this.mrm.equals(a.d("륌샼䨫", 1143429311, 1234232773))) {
                  if (this.msy.isEmpty()) {
                     int var10 = 0;

                     for (int var11 = 0; var11 < this.getPlayer().getInventory().size(); var11++) {
                        if (this.getPlayer().getInventory().getStack(var11).getItem() == Items.GOLDEN_CARROT) {
                           var10 += this.getPlayer().getInventory().getStack(var11).getCount();
                        }
                     }

                     if (var10 > this.mre && this.mrc < 4) {
                        this.mrc++;
                        if (!this.nae(var8, var0 -> var0.getItem() == Items.GOLDEN_CARROT)) {
                           this.mrc = 4;
                        }
                     } else if (var10 < this.mre && this.mrc < 4) {
                        this.mrc++;
                        if (!this.mzw(var8, this.mre - var10)) {
                           this.mrc = 0;
                           this.msy.add(() -> {
                              this.mri = true;
                              this.mc.player.closeHandledScreen();
                              this.mrl = null;
                           });
                        }
                     } else {
                        this.mrc = 0;
                        this.msy.add(() -> {
                           this.mri = true;
                           this.mc.player.closeHandledScreen();
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

   void mzm() {
      if (this.mc.currentScreen == null && !this.msu && !this.mus) {
         for (int var1 = 0; var1 < 9; var1++) {
            if (this.getPlayer().getInventory().getStack(var1).getItem() == Items.GLASS_BOTTLE) {
               if (this.muk == -1 && this.mum <= 0 && this.ndx()) {
                  this.ndz(var1);
               }

               return;
            }
         }

         if (this.msy.isEmpty() && this.mud <= 0) {
            for (int var3 = 9; var3 < 36; var3++) {
               if (this.getPlayer().getInventory().getStack(var3).getItem() == Items.GLASS_BOTTLE) {
                  int var2 = var3;
                  this.msy.add(() -> this.ndv(var2, 1, SlotActionType.THROW));
                  return;
               }
            }
         }
      }
   }

   BlockPos mzn(String var1) {
      if (this.getWorld() != null && this.getPlayer() != null) {
                  String[] var2;
         if (java.util.Objects.equals(var1, a.b("椆Ⴒ驮Е迍") || java.util.Objects.equals(var1, -467702469))) {
            var2 = new String[]{a.d("↲堆틚䲡읹", -1600239057, -2112458848), a.d("ᎇ樾\ue0ea纑\uf54a珷즠", 1042776697, 1667798468)};
         }
         else if (java.util.Objects.equals(var1, a.c(738142290) || java.util.Objects.equals(var1, "Ⱋ嗑\udf06䄉쪠䱮\uf63e翁"))) {
            var2 = new String[]{a.b("侬㙦벱⊾ꤗ\u2fd9閉", -1858057238)};
         }
         else {
            var2 = new String[]{var1};
         }
         return pte.find(this.mc, this.getPlayer().getBlockPos(), var2);
      } else {
         return null;
      }
   }

   void mzo(BlockPos var1) {
      this.mwj = var1;
      this.mwk = System.currentTimeMillis();
   }

   boolean mzp(GenericContainerScreen var1) {
      int var2 = var1.getScreenHandler().syncId;
      if (var2 == this.mwl) {
         return true;
      }

      if (this.mwj != null && this.mwj.equals(this.mrl) && System.currentTimeMillis() - this.mwk <= 3000L) {
         BlockState var3 = this.getWorld().getBlockState(this.mwj);
         if (!(var3.getBlock() instanceof ChestBlock)) {
            return false;
         }

         int var4 = var3.get(ChestBlock.CHEST_TYPE) == ChestType.SINGLE ? 27 : 54;
         if (var1.getScreenHandler().getRows() * 9 != var4) {
            return false;
         }

         this.mwl = var2;
         return true;
      } else {
         return false;
      }
   }

   void mzq(String var1) {
            if (java.util.Objects.equals(var1, a.b("ާ繦\uf4c4櫋\ue163") || java.util.Objects.equals(var1, 1934820323))) {
         this.mrh = true;
      }
      else if (java.util.Objects.equals(var1, a.d("⳻啋\udf9c") || java.util.Objects.equals(var1, -1908903790) || java.util.Objects.equals(var1, -122136481))) {
         this.mri = true;
      }
      else if (java.util.Objects.equals(var1, a.c(815252782) || java.util.Objects.equals(var1, "섓뢧㉻가⟘"))) {
         this.mrj = true;
      }
      else if (java.util.Objects.equals(var1, a.c(1940035325) || java.util.Objects.equals(var1, "銴\ueb7e憩ﾦ琏\uf2c1䢑셮"))) {
         this.mrk = true;
      }
   }

   BlockHitResult mzr(BlockPos var1) {
      Vec3d var2 = this.getPlayer().getEyePos();
      Vec3d var3 = Vec3d.ofCenter(var1);
      BlockHitResult var4 = this.getWorld().raycast(new RaycastContext(var2, var3, ShapeType.COLLIDER, FluidHandling.NONE, this.getPlayer()));
      if (var4.getType() == Type.BLOCK && var4.getBlockPos().equals(var1)) {
         return var4;
      }

      if (this.mvg <= 80) {
         return null;
      }

      Direction var5 = Direction.getFacing(var2.x - var3.x, var2.y - var3.y, var2.z - var3.z);
      Vec3d var6 = var3.add(var5.getOffsetX() * 0.5, var5.getOffsetY() * 0.5, var5.getOffsetZ() * 0.5);
      return new BlockHitResult(var6, var5, var1, false);
   }

   boolean mzs(BlockPos var1) {
      if (this.getWorld() == null) {
         return false;
      }

      String var2 = this.getWorld().getBlockState(var1).getBlock().getTranslationKey().toLowerCase();
      return var2.contains(a.d("\uf851臫ଵ镒Ẃ", 842418189, 574402618)) && !var2.contains(a.b("泉ᕳ龪ǚ訚ಆ뛩㼓ꅁ⯦갲", 1928031399));
   }

   void mzt(GenericContainerScreen var1) {
      int var2 = this.mzv(Items.GOLDEN_CARROT);
      int var3 = var1.getScreenHandler().getInventory().size();

      for (int var4 = var3; var4 < var1.getScreenHandler().slots.size(); var4++) {
         Slot var5 = var1.getScreenHandler().slots.get(var4);
         if (var5.inventory == this.getPlayer().getInventory() && var5.getIndex() < 36) {
            ItemStack var6 = var5.getStack();
            if (!var6.isEmpty()
               && !var6.isOf(Items.BRUSH)
               && !var6.isOf(Items.GLASS_BOTTLE)
               && !this.isTrashItem(var6)
               && !this.nel(var6)
               && !this.neo(var6)
               && !var6.isOf(Items.WATER_BUCKET)
               && (
                  var6.isOf(Items.GOLDEN_CARROT)
                     ? var2 > this.mre
                     : this.mxr(var6)
                        || !var6.getItem().getTranslationKey().contains(a.b("ꮱ툄壏욣䵢", -1008227385))
                           && !var6.getItem().getTranslationKey().contains(a.b("ぞ䧣쌲嵅", -662491081))
                           && !var6.isOf(Items.TOTEM_OF_UNDYING)
               )) {
               int var7 = var4;
               int var8 = var1.getScreenHandler().syncId;
               this.msy
                  .add(
                     () -> {
                        if (this.mc.interactionManager != null
                           && this.getPlayer() != null
                           && this.getPlayer().currentScreenHandler.syncId == var8
                           && !this.mzu(var7)) {
                           this.mc.interactionManager.clickSlot(var8, var7, 0, SlotActionType.QUICK_MOVE, this.getPlayer());
                        }
                     }
                  );
            }
         }
      }
   }

   boolean mzu(int var1) {
      ScreenHandler var2 = this.getPlayer().currentScreenHandler;
      return var1 >= 0 && var1 < var2.slots.size() && var2.slots.get(var1).getStack().isOf(Items.BRUSH);
   }

   int mzv(Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = this.getPlayer().getInventory().getStack(var3);
         if (var4.isOf(var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   boolean mzw(GenericContainerScreen var1, int var2) {
      this.mrf = pmf.plan(
         var1.getScreenHandler(), this.getPlayer().getInventory(), var0 -> var0.getItem() == Items.GOLDEN_CARROT, var2, this.mty, System.currentTimeMillis()
      );
      this.mrg = 0;
      return this.mrf != null;
   }

   void mzx() {
      if (this.mc.currentScreen instanceof GenericContainerScreen var1 && this.mc.interactionManager != null && this.getPlayer() != null) {
         ScreenHandler var4 = var1.getScreenHandler();
         if (++this.mrg == 120) {
            this.mrf.abort();
         }

         pmc var3 = this.mrf
            .drive(
               var4,
               System.currentTimeMillis(),
               (var2, var3x, var4x) -> this.mc.interactionManager.clickSlot(var4.syncId, var2, var3x, var4x, this.getPlayer())
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

   void mzy() {
      if (this.mc.currentScreen instanceof GenericContainerScreen var1 && this.mc.interactionManager != null && this.getPlayer() != null) {
         ScreenHandler var4 = var1.getScreenHandler();
         int var3 = pmf.stashSlot(var4, this.getPlayer().getInventory(), var4.getCursorStack(), -1);
         if (var3 != -1) {
            this.mc.interactionManager.clickSlot(var4.syncId, var3, 0, SlotActionType.PICKUP, this.getPlayer());
         }
      }
   }

   String mzz() {
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

   void naa() {
      Collections.shuffle(this.mrd, this.mty);
      this.mre = 3;
      this.mrc = 0;
      this.mwg = 4.0F + this.mty.nextFloat() * 14.0F;
   }

   int nab(boolean var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = this.getPlayer().getInventory().getStack(var3);
         if (var1 ? this.nel(var4) : this.neo(var4)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   int nac(GenericContainerScreen var1, int var2) {
      int var3 = var1.getScreenHandler().getInventory().size();
      return var2 < 9 ? var3 + 27 + var2 : var3 + (var2 - 9);
   }

   boolean nad(GenericContainerScreen var1, boolean var2) {
      return this.nae(var1, var2x -> var2 ? this.nel(var2x) : this.neo(var2x));
   }

   boolean nae(GenericContainerScreen var1, Predicate<ItemStack> var2) {
      boolean var3 = false;

      for (int var4 = 0; var4 < 36; var4++) {
         ItemStack var5 = this.getPlayer().getInventory().getStack(var4);
         if (var2.test(var5)) {
            int var6 = this.nac(var1, var4);
            this.msy.add(() -> this.mc.interactionManager.clickSlot(var1.getScreenHandler().syncId, var6, 0, SlotActionType.QUICK_MOVE, this.getPlayer()));
            var3 = true;
         }
      }

      return var3;
   }

   void naf(GenericContainerScreen var1, boolean var2) {
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

   void nag(boolean var1) {
      if (var1) {
         this.mrj = true;
      } else {
         this.mrk = true;
      }

      this.mrb = 0;
      this.mc.player.closeHandledScreen();
      this.mrl = null;
   }

   boolean nah(GenericContainerScreen var1, boolean var2) {
      this.mrf = pmf.plan(
         var1.getScreenHandler(), this.getPlayer().getInventory(), var2x -> var2 ? this.nel(var2x) : this.neo(var2x), 1, this.mty, System.currentTimeMillis()
      );
      this.mrg = 0;
      return this.mrf != null;
   }

   String[] nai() {
      String var1 = this.mqi.get();
      String[] var2 = var1 == null ? new String[0] : var1.trim().split(a.b("⋚嬜톿信쐘䋟", -1858198905));
      return var2.length != 0 && !var2[0].isEmpty() ? var2 : new String[]{a.d("㫘䍦짮垚\udc45", -1457529262, -1147083538)};
   }

   String naj() {
      String[] var1 = this.nai();
      if (this.mqp >= var1.length) {
         this.mqp = 0;
      }

      return var1[this.mqp];
   }

   static String nak(String var0) {
      String var1 = var0 == null ? "" : var0.trim();

      while (var1.startsWith(a.d("䰲", 974307399, 1334807643))) {
         var1 = var1.substring(1).trim();
      }

      return var1;
   }

   void nal(String var1) {
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

   void nam() {
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
         this.getNetworkHandler().sendChatCommand(var4);
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
         this.mxb = this.getPlayer() == null ? null : this.getPlayer().getEntityPos();
         this.mxc = -1;
         this.mxd = false;
         this.mxe = 0;
         this.mxf = 0;
         this.myd(mpm.WARPING_TO_LOOT_BASE);
      }
   }

   boolean nan() {
      ClientPlayerEntity var1 = this.getPlayer();
      return this.mxd || this.getWorld() != this.mwz || var1 != this.mxa || this.mxb != null && var1.getEntityPos().distanceTo(this.mxb) > 48.0;
   }

   void nao() {
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
            if (this.mc.options != null) {
               this.mc.options.useKey.setPressed(false);
            }

            boolean var2 = this.mrp != null && this.getPlayer().getBlockPos().getSquaredDistance(this.mrp) > 9.0;
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

   void nap() {
      this.getNetworkHandler().sendChatCommand(this.mxt());
      this.mro = true;
      this.mxe++;
      this.mrp = this.getPlayer().getBlockPos();
      this.mxf = this.mrn;
      this.mrq = 0;
   }

   void naq() {
      if (this.mzh()) {
         pqf.resetKeys();
         this.msc = 0;
         this.myd(mpm.RUN_TO_FARM_COORDS);
      } else {
         this.ncf();
         this.mux = true;
         this.mc.options.forwardKey.setPressed(true);
         this.mc.options.sprintKey.setPressed(true);
         this.mc.options.jumpKey.setPressed(this.getPlayer().horizontalCollision && this.getPlayer().isOnGround());
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

   void nar() {
      BlockPos var1 = new BlockPos(0, 66, 1);
      if (Math.abs(this.getPlayer().getX()) <= 10.0 && Math.abs(this.getPlayer().getZ() - 1.0) <= 10.0 && Math.abs(this.getPlayer().getY() - 66.0) <= 3.0) {
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

         if (this.getPlayer().fallDistance > 3.0) {
            int var2 = this.nei(Items.WATER_BUCKET);
            if (var2 != -1) {
               this.getPlayer().getInventory().setSelectedSlot(var2);
               this.nby(this.mtl.intentYaw(), 89.0F);
               if (this.mtl.intentPitch() > 65.0F) {
                  this.mxv();
               }
            }
         }
      }
   }

   void nas() {
      this.msq = true;
      this.mst = false;
      this.mss = this.mrn;
      this.mc.options.useKey.setPressed(false);
      this.nat();
   }

   void nat() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.getPlayer().getInventory().getStack(var1).isEmpty()) {
            this.getPlayer().getInventory().setSelectedSlot(var1);
            return;
         }
      }

      for (int var3 = 0; var3 < 9; var3++) {
         ItemStack var2 = this.getPlayer().getInventory().getStack(var3);
         if (!this.nel(var2) && !this.neo(var2) && var2.getItem() != Items.GOLDEN_CARROT) {
            this.getPlayer().getInventory().setSelectedSlot(var3);
            return;
         }
      }
   }

   void nau(int var1) {
      int var2 = this.nav();
      int var3 = var2 != -1 ? var2 : 8;
      int var4 = var1;
      this.msy.add(() -> this.ndv(var4, var3, SlotActionType.SWAP));
   }

   int nav() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.getPlayer().getInventory().getStack(var1).isEmpty()) {
            return var1;
         }
      }

      return -1;
   }

   int naw() {
      return pjn.teleportSeconds(this.mc, a.d("ạ朇\uedda玥\uf878终쓥䴖팻姼\ude51\u2457껯㌹뤘㾜薦ੵ铋", 721719727, 536513343));
   }

   void nax() {
      this.msu = false;
      this.msv = 0;
      if (!(this.mqr >= this.mqd.get()) && this.getPlayer().getInventory().getEmptySlot() != -1) {
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
            double var1 = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(this.mrr));
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
               if (!this.mvh && var3 && var1 <= 36.0 && this.ncs(Vec3d.ofCenter(this.mrr))) {
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
                        this.ncp(Vec3d.ofCenter(this.mrr));
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

   void nay(boolean var1) {
      if (var1 && this.mrr != null) {
         this.mra.add(this.mrr);
      }

      this.mvh = false;
      this.mrr = null;
      this.mqy = null;
      this.mqz = 0;
      this.msx = 0;
      this.msi = 0;
      if (this.mc.interactionManager != null) {
         this.mc.interactionManager.cancelBlockBreaking();
      }

      this.mc.options.attackKey.setPressed(false);
   }

   boolean naz(BlockPos var1, boolean var2) {
      if (var1 == null) {
         return false;
      }

      if (!var2 && this.mse > 0) {
         return this.mqy != null && this.mqz < this.mqy.size();
      }

      this.mse = 8;
      this.nbc(this.nba(var1));
      return this.mqy != null && !this.mqy.isEmpty();
   }

   List<BlockPos> nba(BlockPos var1) {
      return this.nbb(this.getPlayer().getBlockPos(), var1);
   }

   List<BlockPos> nbb(BlockPos var1, BlockPos var2) {
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

   void nbc(List<BlockPos> var1) {
      this.mqy = var1;
      this.mqz = 0;
      this.mvm = var1 != null && !var1.isEmpty()
         ? this.mvl.plan(this.getWorld(), this.getPlayer(), var1, (BlockPos)var1.get(var1.size() - 1), new prz())
         : null;
      if (this.mvm == null) {
         this.mqy = null;
      }
   }

   BlockPos nbd(BlockPos var1) {
      if (this.getWorld() == null) {
         return var1;
      }

      Mutable var2 = new Mutable();

      for (int var3 = 0; var3 <= 10; var3++) {
         for (byte var4 = 1; var4 >= -1; var4 -= 2) {
            var2.set(var1.getX(), var1.getY() + var3 * var4, var1.getZ());
            if (this.nbe(var2)) {
               return var2.toImmutable();
            }

            if (var3 == 0) {
               break;
            }
         }
      }

      return var1;
   }

   boolean nbe(BlockPos var1) {
      return this.getWorld() == null
         ? false
         : this.getWorld().getBlockState(var1).getCollisionShape(this.getWorld(), var1).isEmpty()
            && this.getWorld().getBlockState(var1.up()).getCollisionShape(this.getWorld(), var1.up()).isEmpty()
            && !this.getWorld().getBlockState(var1.down()).getCollisionShape(this.getWorld(), var1.down()).isEmpty();
   }

   void nbf() {
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

   void nbg() {
      BlockPos var1 = this.getPlayer().getBlockPos();
      this.nbi(var1);
      if (Double.isNaN(this.mvt)) {
         this.mvt = Math.toRadians(this.ncj() + 90.0);
      }

      double[] var2 = new double[]{0.0, 0.9, -0.9, 2.1, -2.1, Math.PI};
      int var3 = 0;

      for (int var4 = 0; var4 < var2.length && var3 < 2; var4++) {
         double var5 = this.mvt + var2[(var4 + this.mvv) % var2.length] + this.mty.nextGaussian() * 0.28;
         double var7 = 17.0 + this.mty.nextDouble() * 19.0;
         BlockPos var9 = var1.add((int)Math.round(Math.cos(var5) * var7), 0, (int)Math.round(Math.sin(var5) * var7));
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

   static long nbh(BlockPos var0) {
      return (long)(var0.getX() >> 4) << 32 ^ var0.getZ() >> 4 & 4294967295L;
   }

   void nbi(BlockPos var1) {
      if (this.mvw.size() > 512) {
         this.mvw.clear();
      }

      this.mvw.add(nbh(var1));
   }

   boolean nbj(BlockPos var1) {
      return this.mvw.contains(nbh(var1));
   }

   BlockPos nbk() {
      BlockPos var1 = this.getPlayer().getBlockPos();
      Mutable var2 = new Mutable();
      ArrayList var3 = new ArrayList();
      if (this.getWorld() != null) {
         for (PlayerEntity var5 : this.getWorld().getPlayers()) {
            if (var5 != this.getPlayer()) {
               var3.add(var5.getEntityPos());
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
                     int var13 = var1.getY() + var12;
                     if (var13 < 80 || var13 > 90) {
                        var2.set(var1.getX() + var10, var13, var1.getZ() + var11);
                        if (this.nbl(var2) && !this.mra.contains(var2)) {
                           double var14 = var2.getSquaredDistance(var1) * (0.8 + this.mty.nextDouble() * 0.65);
                           if (!this.nbn(var2)) {
                              var14 *= 2.4;
                           }

                           Vec3d var16 = Vec3d.ofCenter(var2);

                           for (Vec3d var18 : var3) {
                              if (var18.squaredDistanceTo(var16) < 1600.0) {
                                 var14 += 100000.0;
                                 break;
                              }
                           }

                           var7++;
                           if (var14 < var20) {
                              var20 = var14;
                              var19 = var2.toImmutable();
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

   boolean nbl(BlockPos var1) {
      return this.getWorld() != null && var1 != null ? this.getWorld().getBlockState(var1).isOf(Blocks.DECORATED_POT) : false;
   }

   boolean nbm(BlockPos var1) {
      return this.nbo(var1) != null;
   }

   boolean nbn(BlockPos var1) {
      Vec3d var2 = this.getPlayer().getEyePos();
      Vec3d[] var3 = new Vec3d[]{Vec3d.ofCenter(var1), Vec3d.ofCenter(var1).add(0.0, 0.4, 0.0)};

      for (Vec3d var7 : var3) {
         BlockHitResult var8 = this.getWorld().raycast(new RaycastContext(var2, var7, ShapeType.OUTLINE, FluidHandling.NONE, this.getPlayer()));
         if (var8.getType() == Type.MISS || var8.getBlockPos().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   Vec3d nbo(BlockPos var1) {
      if (this.getWorld() != null && this.getPlayer() != null && var1 != null) {
         Vec3d var2 = this.getPlayer().getEyePos();
         Vec3d var3 = Vec3d.ofCenter(var1);
         Vec3d[] var4 = new Vec3d[]{
            var3.add(this.muz, this.mva, this.mvb),
            var3.add(0.0, 0.35, 0.0),
            var3.add(0.0, -0.35, 0.0),
            var3.add(0.3, 0.0, 0.0),
            var3.add(-0.3, 0.0, 0.0),
            var3.add(0.0, 0.0, 0.3),
            var3.add(0.0, 0.0, -0.3)
         };

         for (Vec3d var8 : var4) {
            BlockHitResult var9 = this.getWorld().raycast(new RaycastContext(var2, var8, ShapeType.OUTLINE, FluidHandling.NONE, this.getPlayer()));
            if (var9.getType() == Type.MISS || var9.getBlockPos().equals(var1)) {
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   void nbp(Vec3d var1) {
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
      this.mc.options.attackKey.setPressed(false);
      this.mxx();
      if (this.mc.interactionManager != null) {
         this.mc.interactionManager.cancelBlockBreaking();
      }

      this.msj = var1;
      this.msm.clear();
      if (this.mc.world != null) {
         for (Entity var3 : this.mc.world.getEntities()) {
            if (var3 instanceof ItemEntity var4 && var4.squaredDistanceTo(var1) < 100.0 && var4.getItemAge() > 20) {
               this.msm.add(var4.getId());
            }
         }
      }
   }

   void nbq() {
      if (this.mrr != null && this.nbl(this.mrr)) {
         this.mrs++;
         Vec3d var5 = this.nbo(this.mrr);
         double var2 = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(this.mrr));
         if (var5 != null && !(var2 > 20.25)) {
            if (this.nbr(this.mrr)) {
               this.mux = true;
               this.mc.options.forwardKey.setPressed(true);
               this.mc.options.sprintKey.setPressed(true);
               this.mc.options.jumpKey.setPressed(false);
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

            this.mc.options.attackKey.setPressed(var4);
            if (this.mrs > this.mys(100)) {
               this.nay(true);
               this.myd(mpm.FARMING);
            }
         } else {
            this.mc.options.attackKey.setPressed(false);
            if (this.mc.interactionManager != null) {
               this.mc.interactionManager.cancelBlockBreaking();
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
            Vec3d var1 = this.mrr != null ? Vec3d.ofCenter(this.mrr) : this.getPlayer().getEntityPos();
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

   boolean nbr(BlockPos var1) {
      if (this.getPlayer().isOnGround() && !this.getPlayer().isTouchingWater()) {
         if (Math.abs(var1.getY() - this.getPlayer().getY()) > 1.0) {
            return false;
         }

         double var2 = var1.getX() + 0.5 - this.getPlayer().getX();
         double var4 = var1.getZ() + 0.5 - this.getPlayer().getZ();
         double var6 = Math.hypot(var2, var4);
         if (var6 < 2.0) {
            return false;
         }

         double var8 = (var6 - 1.3) / var6;
         return this.nct(new Vec3d(this.getPlayer().getX() + var2 * var8, this.getPlayer().getY(), this.getPlayer().getZ() + var4 * var8), true);
      } else {
         return false;
      }
   }

   void nbs(mpm var1) {
      this.mrs++;
      this.mc.options.attackKey.setPressed(false);
      this.mc.options.useKey.setPressed(false);
      Vec3d var2 = this.msj != null ? this.msj : this.getPlayer().getEntityPos();
      ItemEntity var3 = null;
      double var4 = Double.MAX_VALUE;
      if (this.mc.world != null) {
         for (Entity var7 : this.mc.world.getEntities()) {
            if (var7 instanceof ItemEntity var8
               && var8.isAlive()
               && (!(var8.squaredDistanceTo(var2) > 64.0) || !(var8.squaredDistanceTo(this.getPlayer()) > 36.0))) {
               if (!this.msm.contains(var8.getId())) {
                  this.msk = true;
               }

               if (!this.isTrashItem(var8.getStack()) && !this.msl.contains(var8.getId())) {
                  double var9 = var8.squaredDistanceTo(this.getPlayer());
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
         if (var3.getId() != this.msp) {
            this.msp = var3.getId();
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
            this.msl.add(var3.getId());
            this.msp = -1;
            this.mqy = null;
            this.mqz = 0;
            pqf.resetKeys();
            return;
         }

         if (var4 > 6.25) {
            BlockPos var14 = var3.getBlockPos();
            if (this.mqy == null || this.mqy.isEmpty() || this.mqz >= this.mqy.size() || this.mqy.get(this.mqy.size() - 1).getSquaredDistance(var14) > 4.0) {
               this.naz(var14, false);
            }

            if (this.mqy != null && this.mqz < this.mqy.size()) {
               this.ncr();
            } else {
               this.ncq(var3.getEntityPos(), true);
            }
         } else if (pqf.isBlockedHorizontally() && this.msn > 12) {
            if (this.mqy == null || this.mqz >= this.mqy.size()) {
               this.naz(var3.getBlockPos(), false);
            }

            if (this.mqy != null && this.mqz < this.mqy.size()) {
               this.ncr();
            } else {
               this.nbt(var3.getEntityPos());
            }
         } else {
            this.mqy = null;
            this.nbt(var3.getEntityPos());
         }
      } else {
         this.msv++;
         double var12 = Math.hypot(var2.x - this.getPlayer().getX(), var2.z - this.getPlayer().getZ());
         if (!this.msk && this.msj != null && this.mrs < 12 && var12 > 1.1 && this.ncx(BlockPos.ofFloored(this.msj))) {
            this.ncq(new Vec3d(var2.x, this.getPlayer().getY(), var2.z), true);
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

   void nbt(Vec3d var1) {
      ClientPlayerEntity var2 = this.getPlayer();
      Vec3d var3 = new Vec3d(var1.x, var2.getEyePos().y - 0.6, var1.z);
      int var4 = this.mvl.walkTo(this.mc, var2, this.getWorld(), var1, this.mtu, this.mtv, var3, false, this.myq(), this.myt());
      if (var4 != 0 && !this.myq()) {
         pqf.resetKeys();
      }

      this.mux = true;
      this.mry = true;
   }

   void nbu(mpm var1) {
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

   void nbv() {
      this.mtw = this.getPlayer();
      if (this.mtw != null) {
         this.nce(this.mtw);
         this.mtl.reset(this.mtw.getYaw(), this.mtw.getPitch());
         this.mtu = this.mtw.getYaw();
         this.mtv = this.mtw.getPitch();
         this.mtx = this.mtw.getEntityPos();
      }

      this.mtn = false;
      this.mto = false;
      this.mua = false;
      this.mub = false;
      this.muc = false;
   }

   void nbw() {
      ptr.clear();
      if (this.mtn) {
         this.mtn = false;
         if (this.driver == null && this.mtm.ownedBy(this)) {
            this.mtm.release(this.mc.player);
         }
      }
   }

   boolean nbx() {
      ClientPlayerEntity var1 = this.getPlayer();
      if (var1 == null) {
         return false;
      }

      boolean var2 = this.mtw != var1 || this.mtx == null || var1.getEntityPos().squaredDistanceTo(this.mtx) > 400.0;
      if (var2) {
         if (this.driver == null) {
            this.mtm.reset();
         }

         if (this.mtw != var1) {
            this.nce(var1);
         }

         this.mtl.reset(var1.getYaw(), var1.getPitch());
         this.mtu = var1.getYaw();
         this.mtv = var1.getPitch();
         this.mtw = var1;
         this.mtn = false;
         this.mqy = null;
         this.mqz = 0;
         this.mvm = null;
         this.mvl.reset();
      }

      this.mtx = var1.getEntityPos();
      return var2;
   }

   void nby(float var1, float var2) {
      this.nbz(var1, var2, false);
   }

   void nbz(float var1, float var2, boolean var3) {
      this.mts = var1;
      this.mtt = var2;
      this.mtq = var3;
      this.mtr = false;
      this.mvd = 0.0;
      this.mto = true;
      this.mtp = false;
   }

   void nca(Vec3d var1) {
      float[] var2 = prt.calculateAngle(var1);
      this.nbz(var2[0], var2[1], false);
   }

   void ncb(BlockPos var1, Vec3d var2) {
      this.nca(var2);
      this.mvd = this.mve ? 0.25 : this.ncc(var1, var2);
   }

   double ncc(BlockPos var1, Vec3d var2) {
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

   void ncd(boolean var1) {
      if (!var1 && !this.mtl.isMoving()) {
         if (++this.mvf >= 3) {
            this.mve = true;
         }
      } else {
         this.mvf = 0;
      }
   }

   void nce(PlayerEntity var1) {
      String var2 = var1.getGameProfile() != null ? var1.getGameProfile().name() : null;
      long var3 = 1125899906842597L;
      if (var2 != null) {
         for (int var5 = 0; var5 < var2.length(); var5++) {
            var3 = var3 * 31L + Character.toLowerCase(var2.charAt(var5));
         }
      }

      this.mtl.personalize(var3);
      this.mvl.personalize(var3);
   }

   void ncf() {
      if (!this.mto) {
         this.mtp = true;
      }
   }

   boolean ncg() {
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

   void nch() {
      this.mvh = false;
      this.mve = false;
      this.mvf = 0;
      this.muz = (this.mty.nextDouble() - 0.5) * 0.34;
      this.mva = (this.mty.nextDouble() - 0.5) * 0.44;
      this.mvb = (this.mty.nextDouble() - 0.5) * 0.34;
      this.mvc = 1 + this.mty.nextInt(4);
   }

   boolean nci() {
      return this.mqy != null && this.mqz < this.mqy.size();
   }

   float ncj() {
      return (float)this.mvl.moveYaw(this.mtu);
   }

   void nck() {
      if (this.getPlayer() != null) {
         this.mvr = this.mto && !this.mtq;
         boolean var1 = this.mvl.takeTurn(this.mvs);
         if (this.myq() && !this.mvr) {
            this.ncl();
         } else {
            if (this.mc.currentScreen == null) {
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
               if (this.mc.currentScreen == null) {
                  this.driver.look(this.mtu, MathHelper.clamp(this.mtv, -90.0F, 90.0F));
               }
            } else {
               this.mtm.set(this, this.mtu, MathHelper.clamp(this.mtv, -90.0F, 90.0F));
            }

            this.mtn = true;
            if (this.mc.currentScreen != null) {
               ptr.clear();
            } else if (this.mvk != null) {
               ptr.aimAt(this.mvk, this.mtu, this.mtv);
            }

            this.mvk = null;
         }
      }
   }

   void ncl() {
      this.mto = false;
      this.mtp = false;
      ClientPlayerEntity var1 = this.getPlayer();
      this.mtl.reset(var1.getYaw(), var1.getPitch());
      this.mtu = var1.getYaw();
      this.mtv = var1.getPitch();
      if (this.mtn) {
         this.mtn = false;
         if (this.mtm.ownedBy(this)) {
            this.mtm.release(this.mc.player);
         }
      }

      if (this.mc.currentScreen != null) {
         ptr.clear();
      } else if (this.mvk != null) {
         ptr.aimAt(this.mvk, this.mtu, this.mtv);
      }

      this.mvk = null;
   }

   boolean ncm() {
      return this.mud > 0 || !this.msy.isEmpty() || this.mtb > 0;
   }

   BlockHitResult ncn() {
      if (this.getWorld() != null && this.getPlayer() != null) {
         Vec3d var1 = this.getPlayer().getEyePos();
         Vec3d var2 = Vec3d.fromPolar(this.mtv, this.mtu);
         double var3 = 4.5;
         Vec3d var5 = var1.add(var2.x * var3, var2.y * var3, var2.z * var3);
         return this.getWorld().raycast(new RaycastContext(var1, var5, ShapeType.OUTLINE, FluidHandling.NONE, this.getPlayer()));
      } else {
         return null;
      }
   }

   BlockHitResult nco(BlockPos var1) {
      BlockHitResult var2 = this.ncn();
      if (var2 != null && var2.getType() == Type.BLOCK && var2.getBlockPos().equals(var1)) {
         this.mvk = var1;
         return var2;
      } else {
         return null;
      }
   }

   void ncp(Vec3d var1) {
      this.ncq(var1, false);
   }

   void ncq(Vec3d var1, boolean var2) {
      int var3 = this.mvl.walkTo(this.mc, this.getPlayer(), this.getWorld(), var1, this.mtu, this.mtv, null, this.mqq == mpm.ESCAPING, this.myq(), this.myt());
      if (var3 != 0 && !this.myq()) {
         pqf.resetKeys();
      }

      this.mux = true;
      this.mry = true;
   }

   void ncr() {
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

   boolean ncs(Vec3d var1) {
      return this.nct(var1, true);
   }

   boolean nct(Vec3d var1, boolean var2) {
      if (this.getWorld() != null && this.getPlayer() != null) {
         Vec3d var3 = this.getPlayer().getEntityPos();
         double var4 = var1.x - var3.x;
         double var6 = var1.z - var3.z;
         double var8 = Math.hypot(var4, var6);
         if (var8 < 0.1) {
            return true;
         }

         double var10 = this.ncu();
         int var12 = (int)Math.ceil(var8 / 0.45);

         for (int var13 = 1; var13 <= var12; var13++) {
            double var14 = (double)var13 / var12;
            double var16 = var3.x + var4 * var14;
            double var18 = var3.z + var6 * var14;
            if (!this.ncv(var16, var18, var10)) {
               return false;
            }

            if (var2 && this.ncx(BlockPos.ofFloored(var16, var10 - 0.2, var18))) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   double ncu() {
      return this.nci() ? pqf.getStandY(this.mqy.get(this.mqz)) : this.getPlayer().getY();
   }

   boolean ncv(double var1, double var3, double var5) {
      return this.ncw(new Box(var1 - 0.31, var5 + 0.6, var3 - 0.31, var1 + 0.31, var5 + 1.8, var3 + 0.31));
   }

   boolean ncw(Box var1) {
      for (VoxelShape var3 : this.getWorld().getBlockCollisions(this.getPlayer(), var1)) {
         if (!var3.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   boolean ncx(BlockPos var1) {
      return this.getWorld().getBlockState(var1).getCollisionShape(this.getWorld(), var1).isEmpty();
   }

   void ncy() {
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
            double var1 = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(this.mrz));
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
               if (!this.mvh && var3 && var1 <= 36.0 && this.ncs(Vec3d.ofCenter(this.mrz))) {
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
                        this.ncp(Vec3d.ofCenter(this.mrz));
                     } else if (!this.naz(this.mrz, false)) {
                        pqf.resetKeys();
                     }
                  }
               }
            }
         }
      }
   }

   void ncz(boolean var1) {
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
      this.mc.options.useKey.setPressed(false);
   }

   BlockPos nda() {
      BlockPos var1 = this.getPlayer().getBlockPos();
      Mutable var2 = new Mutable();
      ArrayList var3 = new ArrayList();

      for (PlayerEntity var5 : this.getWorld().getPlayers()) {
         if (var5 != this.getPlayer()) {
            var3.add(var5.getEntityPos());
         }
      }

      BlockPos var16 = null;
      double var17 = Double.MAX_VALUE;

      for (int var7 = 0; var7 <= 32; var7++) {
         for (int var8 = -var7; var8 <= var7; var8++) {
            for (int var9 = -var7; var9 <= var7; var9++) {
               if (Math.max(Math.abs(var8), Math.abs(var9)) == var7) {
                  for (int var10 = -8; var10 <= 8; var10++) {
                     var2.set(var1.getX() + var8, var1.getY() + var10, var1.getZ() + var9);
                     if (this.ndb(var2) && !this.mra.contains(var2)) {
                        double var11 = var2.getSquaredDistance(var1);
                        Vec3d var13 = Vec3d.ofCenter(var2);

                        for (Vec3d var15 : var3) {
                           if (var15.squaredDistanceTo(var13) < 1600.0) {
                              var11 += 100000.0;
                              break;
                           }
                        }

                        if (var11 < var17) {
                           var17 = var11;
                           var16 = var2.toImmutable();
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

   boolean ndb(BlockPos var1) {
      return this.getWorld() != null && var1 != null ? this.getWorld().getBlockState(var1).isOf(Blocks.SUSPICIOUS_SAND) : false;
   }

   void ndc() {
      if (!this.nde()) {
         this.mc.options.useKey.setPressed(false);
         this.msj = this.mrz != null ? Vec3d.ofCenter(this.mrz) : this.getPlayer().getEntityPos();
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
               int var9 = var7;
               this.msy.add(() -> this.ndv(var9, var8, SlotActionType.SWAP));
            }
         } else {
            this.getPlayer().getInventory().setSelectedSlot(var1);
            double var2 = this.getPlayer().getEyePos().squaredDistanceTo(Vec3d.ofCenter(this.mrz));
            if (!(var2 > 5.0)) {
               if (!this.msb) {
                  this.msb = true;
                  this.msa = 0;
                  this.mqy = null;
                  this.mqz = 0;
               }

               pqf.resetKeys();
               this.ncb(this.mrz, Vec3d.ofCenter(this.mrz));
               BlockHitResult var4 = this.nco(this.mrz);
               boolean var5 = var4 != null;
               this.ncd(var5);
               if (var5 && this.mvc > 0) {
                  this.mvc--;
                  var5 = false;
                  var4 = null;
               }

               if (var5) {
                  this.mc.options.useKey.setPressed(true);
                  if (!this.getPlayer().isUsingItem()) {
                     BlockHitResult var6 = var4;
                     ptr.later(
                        () -> {
                           if (this.mc.interactionManager != null
                              && this.mc.player != null
                              && !this.mc.player.isUsingItem()
                              && ndf(this.mc.player.getMainHandStack())) {
                              this.mc.interactionManager.interactBlock(this.mc.player, Hand.MAIN_HAND, var6);
                              this.mc.player.setCurrentHand(Hand.MAIN_HAND);
                           }
                        }
                     );
                  }

                  this.msx = 0;
               } else {
                  this.mc.options.useKey.setPressed(false);
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
                  this.msj = Vec3d.ofCenter(this.mrz);
                  this.mrz = null;
                  this.msb = false;
                  this.mc.options.useKey.setPressed(false);
                  this.msu = false;
                  this.myd(mpm.LOOTING_SAND);
               }
            } else {
               this.msb = false;
               this.mc.options.useKey.setPressed(false);
               if (this.nbm(this.mrz)) {
                  this.ncp(Vec3d.ofCenter(this.mrz));
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
                  this.mc.options.useKey.setPressed(false);
                  this.myd(mpm.FARMING_SAND);
               }
            }
         }
      } else {
         this.mc.options.useKey.setPressed(false);
         this.msj = this.mrz != null ? Vec3d.ofCenter(this.mrz) : this.getPlayer().getEntityPos();
         if (this.mrz != null) {
            this.mra.add(this.mrz);
            this.mqv++;
         }

         this.mrz = null;
         this.msu = false;
         this.myd(mpm.LOOTING_SAND);
      }
   }

   void ndd() {
      if (!this.msu) {
         this.nbp(this.msj != null ? this.msj : this.getPlayer().getEntityPos());
      }

      this.nbs(this.nde() ? mpm.FARMING_SAND : mpm.CHECK_PVP_COOLDOWN);
   }

   boolean nde() {
      return this.ndg(0, 36) != -1;
   }

   static boolean ndf(ItemStack var0) {
      if (!var0.isOf(Items.BRUSH)) {
         return false;
      }

      if (var0.contains(DataComponentTypes.UNBREAKABLE)) {
         return true;
      }

      LoreComponent var1 = var0.get(DataComponentTypes.LORE);
      if (var1 == null) {
         return false;
      }

      for (Text var3 : var1.lines()) {
         if (var3.getString().toLowerCase().contains(a.b("㾐䘩첏劎\ud95e徘\ue5c8氲\uf215碡ｻ", 1763457958))) {
            return true;
         }
      }

      return false;
   }

   int ndg(int var1, int var2) {
      for (int var3 = var1; var3 < var2; var3++) {
         if (ndf(this.getPlayer().getInventory().getStack(var3))) {
            return var3;
         }
      }

      return -1;
   }

   void ndh() {
      if (this.mwa - this.mwb > 60) {
         this.mqp++;
         this.myd(mpm.TELEPORT_TO_SAVE);
         this.mrt = null;
      } else {
         this.ndi();
      }
   }

   void ndi() {
      PlayerEntity var1 = this.neh();
      if (var1 != null) {
         if (this.mse <= 0
            && (this.mrt == null || this.mrt.getSquaredDistance(this.getPlayer().getBlockPos()) < 10.0 || var1.squaredDistanceTo(this.getPlayer()) < 400.0)) {
            Vec3d var2 = this.mzj(this.getPlayer().getEntityPos().subtract(var1.getEntityPos()).normalize(), Math.toRadians(this.mty.nextGaussian() * 20.0));
            double var3 = 26.0 + this.mty.nextDouble() * 14.0;
            this.mrt = this.nbd(this.getPlayer().getBlockPos().add((int)(var2.x * var3), 0, (int)(var2.z * var3)));
            this.mse = 10;
            this.nbc(this.nba(this.mrt));
         }
      } else if (this.mse <= 0 && (this.mrt == null || this.mrt.getSquaredDistance(this.getPlayer().getBlockPos()) < 4.0)) {
         double var6 = this.mty.nextDouble() * Math.PI * 2.0;
         double var4 = 18.0 + this.mty.nextDouble() * 20.0;
         this.mrt = this.nbd(this.getPlayer().getBlockPos().add((int)Math.round(Math.cos(var6) * var4), 0, (int)Math.round(Math.sin(var6) * var4)));
         this.mse = 10;
         this.nbc(this.nba(this.mrt));
      }

      if (this.mqy != null && this.mqz < this.mqy.size()) {
         this.ncr();
      } else {
         pqf.resetKeys();
      }
   }

   boolean ndj() {
      return pjn.contains(this.mc, a.d("\uf6dc轋־鮲ᐈ鋌⢜ꅣ㼸놕㉖젭䚂\udf49唐폦榡", 606286106, 1128580999));
   }

   void ndk() {
      String var1 = nak(this.mqh.get());
      if (!pjd.enter(this.mxs(), var1)) {
         this.nal(a.c(-1477713762, "\ue4a0鴼\u13ff觯Ɍ蓱㺩띟ⴕꏇ②\ude13哑쵳䜳엟羝\uf034櫷\uecdb慉ᬕ閫੬谑ڥ뽻㔶ꯟⷷ\ua636墒튨䭘촇"));
      } else {
         this.mwn = "";
         this.getNetworkHandler().sendChatCommand(var1);
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

   void ndl() {
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
      if (var1.isEmpty()) {
         return false;
      }

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

   boolean ndm(ItemStack var1, vlj var2) {
      if (this.neg(var1)) {
         return false;
      } else if (var1.isOf(Items.BRUSH)) {
         return true;
      } else if (ppu.picked(var1, var2.ids())) {
         return false;
      } else if (ppu.known(var1)) {
         return true;
      } else {
         Item var3 = var1.getItem();
         String var4 = var3.getTranslationKey().toLowerCase();
         if (var3 == Items.DRAGON_HEAD) {
            return false;
         } else if (var3 == Items.GOLDEN_CARROT) {
            return false;
         } else if (var3 == Items.VILLAGER_SPAWN_EGG || var3 == Items.ZOMBIE_VILLAGER_SPAWN_EGG) {
            return false;
         } else if (var3 == Items.GOLDEN_APPLE || var3 == Items.ENCHANTED_GOLDEN_APPLE) {
            return false;
         } else if (var3 == Items.HEAVY_CORE) {
            return false;
         } else if (var4.contains(a.d("蕫ﳗ瘀\ue874", -1352822735, 531371318)) || var4.contains(a.d("\uf3e2詋\u0086黮ᔹ", 1696324825, -305647795))) {
            return false;
         } else if (var3 == Items.IRON_NUGGET) {
            return false;
         } else {
            String var5 = var1.getName().getString().toLowerCase();
            if (var4.contains(a.b("绠݂趑ᏽ頲", 302743172))) {
               return var5.contains(a.d("풛괨⟼맾", -805642075, 1178742797))
                     || var5.contains(a.d("\uf0f4褿Β鷯ᘺ邉", -630686278, 1317964146))
                     || var5.contains(a.c(2070976211, "鋦\ueb28懿\ufff1瑜\uf29a䣇셁彯"))
                  ? true
                  : var3 != Items.TIPPED_ARROW && !var1.contains(DataComponentTypes.CUSTOM_NAME);
            } else if (var5.contains(a.d("줚냕㨃ꑳ\u2fd8ꥢፃ", -1753364669, 1573915163))) {
               return true;
            } else if (var3 == Items.LEAD) {
               return true;
            } else if (var3 == Items.DRAGON_BREATH) {
               return true;
            } else if (var3 == Items.EGG) {
               return true;
            } else if (var3 == Items.GLASS_BOTTLE) {
               return true;
            } else if (var3 == Items.FEATHER) {
               return !var1.contains(DataComponentTypes.CUSTOM_NAME);
            } else if (var3 == Items.HONEY_BOTTLE || var3 == Items.HONEYCOMB) {
               return true;
            } else if (var3 == Items.ENCHANTING_TABLE) {
               return true;
            } else if (var3 == Items.BOOKSHELF) {
               return true;
            } else if (var3 == Items.GHAST_TEAR) {
               return true;
            } else if (var3 == Items.SHULKER_SHELL) {
               return true;
            } else if (var3 == Items.FERMENTED_SPIDER_EYE) {
               return true;
            } else if (var3 == Items.END_CRYSTAL) {
               return true;
            } else if (var3 == Items.BOW) {
               return true;
            } else if (var3 == Items.LEATHER) {
               return true;
            } else if (var3 == Items.EMERALD) {
               return true;
            } else if (var3 == Items.IRON_INGOT) {
               return true;
            } else if (var3 == Items.GOLD_INGOT || var3 == Items.GOLD_NUGGET) {
               return true;
            } else if (var3 == Items.NAUTILUS_SHELL) {
               return true;
            } else if (var3 == Items.GUNPOWDER) {
               return true;
            } else if (var3 == Items.CHORUS_FRUIT || var3 == Items.POPPED_CHORUS_FRUIT) {
               return true;
            } else if (var4.contains(a.c(753118924, "꺕휈巟쎶䡼컛"))) {
               return true;
            } else if (var3 == Items.BONE) {
               return true;
            } else if (var4.contains(a.b("\uf296謠Ǯ龞ᑟ鋔⢹ꅛ㼛떨㉦", 2075063029)) || var4.contains(a.b("鷋\ue462溲\uf0c9笧ﶨ䟨츆偛\udaf7", 1642700214))) {
               return true;
            } else if (var3 == Items.BLAZE_ROD) {
               return true;
            } else if (var3 == Items.SLIME_BALL) {
               return true;
            } else if (var1.contains(DataComponentTypes.FOOD)) {
               return true;
            } else if (var4.contains(a.d("ꢥ턗寕얲乼주犕ﭦ改", -244918230, -2124713739))) {
               return true;
            } else if (var3 == Items.ENDER_CHEST) {
               return true;
            } else if (var3 == Items.FIREWORK_ROCKET) {
               return true;
            } else if (var3 == Items.ENCHANTED_BOOK || var3 == Items.BOOK || var3 == Items.WRITTEN_BOOK || var3 == Items.WRITABLE_BOOK) {
               return true;
            } else if (var4.contains(a.c(201042272, "꤄킺婱쐟俍"))) {
               return true;
            } else if (var4.contains(a.d("䛺㽚떁⯭ꀦ⚚鳜ᔼ", -1896952143, -882633))) {
               return true;
            } else if (var4.contains(a.d("ῳ晙\uec8d狥嵐羙", 690090973, 1491856475))) {
               return true;
            } else if (var3 == Items.WITHER_ROSE) {
               return true;
            } else if (var3 == Items.TRIDENT) {
               return true;
            } else if (var3 == Items.CONDUIT) {
               return true;
            } else if (var4.contains(a.b("誟\uf336秣\ue788汕\uead8傰\ud94c䜉춨", 1858439928))) {
               return true;
            } else if (var4.contains(a.d("๓矵ﴲ捚\ue895", -123881445, -206719429))) {
               return true;
            } else if (var3 == Items.PUFFERFISH) {
               return true;
            } else if (var3 == Items.COD_BUCKET || var3 == Items.SALMON_BUCKET || var3 == Items.TROPICAL_FISH_BUCKET || var3 == Items.PUFFERFISH_BUCKET) {
               return true;
            } else if (var4.contains(a.c(-1623003556, "\uee38鞊ᵖ茧ࣻ蹝"))) {
               return true;
            } else if (var3 == Items.STRING) {
               return true;
            } else if (var3 == Items.NAME_TAG) {
               return true;
            } else if (var3 == Items.HEART_OF_THE_SEA) {
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
                  ? var3 == Items.STONE_AXE
                  : true;
            }
         }
      }
   }

   void ndn() {
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

   void ndo() {
      if (!this.nec()) {
         if (this.mc.currentScreen == null && this.msy.isEmpty() && this.mud <= 0) {
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
               if (!this.mc.options.attackKey.isPressed()) {
                  if (!this.msu || this.getPlayer().getInventory().getEmptySlot() == -1) {
                     int var5 = 0;
                     int var2 = 0;

                     for (int var3 = 9; var3 < 36; var3++) {
                        ItemStack var4 = this.getPlayer().getInventory().getStack(var3);
                        if (var4.isEmpty()) {
                           var2++;
                        } else if (this.isTrashItem(var4)) {
                           var5++;
                        }
                     }

                     if (var5 != 0) {
                        if (this.muv > 0 || var2 <= 3 || var5 >= 5 || this.getPlayer().getInventory().getEmptySlot() == -1) {
                           this.muv = 0;

                           for (int var6 = 0; var6 < 9; var6++) {
                              if (this.isTrashItem(this.getPlayer().getInventory().getStack(var6))) {
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

   void ndp() {
      this.mug++;
      if (this.mug > this.muh || this.mc.currentScreen != null || this.getPlayer() == null || this.mqq == mpm.ESCAPING || this.mus) {
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
               this.ndv(var1, 1, SlotActionType.THROW);
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

   void ndq() {
      this.mud = 0;
      this.mue = 0;
      this.muf = 0;
      this.mug = 0;
      this.muh = 0;
      this.mui = -1;
      this.ndw();
      this.ndu();
   }

   int ndr() {
      PlayerInventory var1 = this.getPlayer().getInventory();
      int var2 = this.mui != -1 ? this.mui : 13;
      int var3 = -1;
      double var4 = Double.MAX_VALUE;

      for (int var6 = 0; var6 < 36; var6++) {
         if (this.isTrashItem(var1.getStack(var6))) {
            double var7 = nds(var2, var6);
            if (var7 < var4) {
               var4 = var7;
               var3 = var6;
            }
         }
      }

      return var3;
   }

   static double nds(int var0, int var1) {
      double var2 = var0 < 9 ? 3.25 : (var0 - 9) / 9;
      double var4 = var0 < 9 ? var0 : (var0 - 9) % 9;
      double var6 = var1 < 9 ? 3.25 : (var1 - 9) / 9;
      double var8 = var1 < 9 ? var1 : (var1 - 9) % 9;
      return Math.hypot(var2 - var6, var4 - var8);
   }

   int ndt(double var1) {
      int var3 = var1 <= 1.5 ? 2 : (var1 <= 4.0 ? 3 : 4);
      float var4 = this.mty.nextFloat();
      if (var3 == 2 && var4 < 0.12F) {
         var3 = 1;
      } else if (var4 > 0.65F) {
         var3++;
      }

      return var3 - 1;
   }

   void ndu() {
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

   void ndv(int var1, int var2, SlotActionType var3) {
      if (this.mc.interactionManager != null && this.getPlayer() != null) {
         int var4 = var1 < 9 ? var1 + 36 : var1;
         this.mc.interactionManager.clickSlot(this.getPlayer().playerScreenHandler.syncId, var4, var2, var3, this.getPlayer());
         if (this.mc.currentScreen == null) {
            this.muw = true;
         }
      }
   }

   void ndw() {
      if (this.muw) {
         this.muw = false;
         if (this.mc.currentScreen == null && this.getPlayer() != null && this.getNetworkHandler() != null) {
            this.getNetworkHandler().sendPacket(new CloseHandledScreenC2SPacket(this.getPlayer().playerScreenHandler.syncId));
         }
      }
   }

   boolean ndx() {
      return this.mc.currentScreen == null
         && !this.muw
         && this.msy.isEmpty()
         && this.mud == 0
         && !this.mus
         && !this.mc.options.attackKey.isPressed()
         && !this.mc.options.useKey.isPressed()
         && !this.getPlayer().isUsingItem()
         && !this.getPlayer().isSpectator()
         && this.mqq != mpm.BRUSHING_SAND
         && this.mqq != mpm.ESCAPING
         && this.mqq != mpm.LOOTING_VASE
         && !this.mvh;
   }

   int ndy() {
      PlayerInventory var1 = this.getPlayer().getInventory();
      int var2 = var1.getSelectedSlot();
      int var3 = -1;

      for (int var4 = 0; var4 < 9; var4++) {
         if (this.isTrashItem(var1.getStack(var4)) && (var3 == -1 || Math.abs(var4 - var2) < Math.abs(var3 - var2))) {
            var3 = var4;
         }
      }

      return var3;
   }

   void ndz(int var1) {
      this.neb();
      this.muk = var1;
      boolean var2 = this.getPlayer().getInventory().getSelectedSlot() == var1;
      this.mul = var2 ? 0 : this.nea();
      this.getPlayer().getInventory().setSelectedSlot(var1);
   }

   int nea() {
      float var1 = this.mty.nextFloat();
      return var1 < 0.2F ? 0 : (var1 < 0.6F ? 1 : (var1 < 0.9F ? 2 : 3));
   }

   void neb() {
      this.muk = -1;
      this.mul = 0;
      this.mun = false;
      this.muo = 0;
      this.mup = 0;
   }

   boolean nec() {
      if (this.muk == -1) {
         return false;
      }

      if (this.mun) {
         if (this.mup == 0 && ++this.muo <= 3) {
            return true;
         }

         boolean var4 = this.mup > 0;
         this.neb();
         if (var4) {
            this.mur++;
            this.mum = this.mty.nextInt(3);
         } else {
            this.mum = 8 + this.mty.nextInt(12);
         }

         return false;
      } else {
         PlayerInventory var1 = this.getPlayer().getInventory();
         if (this.ndx() && this.isTrashItem(var1.getStack(this.muk))) {
            if (var1.getSelectedSlot() != this.muk) {
               this.neb();
               this.mum = 10 + this.mty.nextInt(10);
               return false;
            }

            if (this.mul-- > 0) {
               return true;
            }

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
         } else {
            this.neb();
            this.mum = 4 + this.mty.nextInt(8);
            return false;
         }
      }
   }

   boolean ned(int var1, int var2) {
      ClientPlayerEntity var3 = this.mc.player;
      if (var2 == this.muq && this.mun && var3 != null && this.mc.currentScreen == null && !var3.isSpectator() && var3.getInventory().getSelectedSlot() == var1
         )
       {
         ItemStack var4 = var3.getMainHandStack();
         if (!this.isTrashItem(var4)) {
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

   public boolean busy() {
      return !this.msy.isEmpty() || this.mud > 0 || this.mtb > 0 || this.mc.currentScreen instanceof GenericContainerScreen;
   }

   void nee() {
      if (this.mc.currentScreen == null && this.msy.isEmpty() && this.mud <= 0 && this.muk == -1) {
         int var1 = 0;

         for (int var2 = 0; var2 < 9; var2++) {
            if (this.getPlayer().getInventory().getStack(var2).isEmpty()) {
               var1++;
            }
         }

         if (var1 < 2) {
            for (int var7 = 0; var7 < 9; var7++) {
               ItemStack var3 = this.getPlayer().getInventory().getStack(var7);
               if (!this.isTrashItem(var3) && !this.neg(var3)) {
                  int var4 = this.nef();
                  if (var4 == -1) {
                     return;
                  }

                  int var5 = var7;
                  int var6 = var4;
                  this.msy.add(() -> this.ndv(var6, var5, SlotActionType.SWAP));
                  return;
               }
            }
         }
      }
   }

   int nef() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (this.getPlayer().getInventory().getStack(var1).isEmpty()) {
            return var1;
         }
      }

      return -1;
   }

   boolean neg(ItemStack var1) {
      if (var1.isEmpty()) {
         return true;
      } else {
         return var1.getItem() != Items.GOLDEN_CARROT && !ndf(var1) && var1.getItem() != Items.WATER_BUCKET ? this.nel(var1) || this.neo(var1) : true;
      }
   }

   PlayerEntity neh() {
      PlayerEntity var1 = null;
      double var2 = 2500.0;

      for (PlayerEntity var5 : this.getWorld().getPlayers()) {
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

   int nei(Item var1) {
      for (int var2 = 0; var2 < 9; var2++) {
         if (this.getPlayer().getInventory().getStack(var2).getItem() == var1) {
            return var2;
         }
      }

      return -1;
   }

   int nej() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.nel(this.getPlayer().getInventory().getStack(var1))) {
            return var1;
         }
      }

      return -1;
   }

   int nek() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (this.nel(this.getPlayer().getInventory().getStack(var1))) {
            return var1;
         }
      }

      return -1;
   }

   boolean nel(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      }

      if (var1.getItem() != Items.POTION && var1.getItem() != Items.SPLASH_POTION && var1.getItem() != Items.LINGERING_POTION) {
         return false;
      }

      PotionContentsComponent var2 = var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var2 != null) {
         int var3 = 0;
         boolean var4 = false;

         for (StatusEffectInstance var6 : var2.getEffects()) {
            var3++;
            if (var6.getEffectType() == StatusEffects.INVISIBILITY) {
               var4 = true;
            }
         }

         if (var3 > 0) {
            return var3 == 1 && var4;
         }
      }

      String var7 = var1.getName().getString().toLowerCase();
      return var7.contains(a.d("諹\uf340禔\ue7ef水\uea89僞", -425032786, 1206390125));
   }

   int nem() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (this.neo(this.getPlayer().getInventory().getStack(var1))) {
            return var1;
         }
      }

      return -1;
   }

   int nen() {
      for (int var1 = 9; var1 < 36; var1++) {
         if (this.neo(this.getPlayer().getInventory().getStack(var1))) {
            return var1;
         }
      }

      return -1;
   }

   boolean neo(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      }

      if (var1.getItem() != Items.POTION && var1.getItem() != Items.SPLASH_POTION && var1.getItem() != Items.LINGERING_POTION) {
         return false;
      }

      PotionContentsComponent var2 = var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var2 != null) {
         int var3 = 0;
         boolean var4 = false;

         for (StatusEffectInstance var6 : var2.getEffects()) {
            var3++;
            if (var6.getEffectType() == StatusEffects.SPEED) {
               var4 = true;
            }
         }

         if (var3 > 0) {
            return var3 == 1 && var4;
         }
      }

      String var7 = var1.getName().getString().toLowerCase();
      return var7.contains(a.b("釙\ue813拄ﳋ睢\uf1ac䯼", -1835756129)) || var7.contains(a.c(-96193484, "㑂䷰윶奇튑"));
   }
}
