package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import net.minecraft.world.chunk.WorldChunk;

public class nmg extends kfe {
   static final String nmh = a.b("繤ߜ赇፥颤ḑꑑⶱ돥㤜", 2125168143);
   static final String nmi = a.d("晇\u1fff镤\u0b46肇ؿ뱬㗑", -260310604, -974151782);
   static final String nmj = a.d("შ楐", 1283661315, 1865813640);
   static final String nmk = a.c(-97666056, "뾵영䲢틞夌\udfbe旮\uec6e");
   static final String nml = a.b("놑젪䊌\udc88坘톐毉\ue23b簖\uf6a5", 1258927524);
   static final String nmm = a.b("敧Ქ阏ࠂ莫Ԝ뽌", -1371512496);
   static final String nmn = a.c(1233984232, "ậ杯\uedb4");
   static final String nmo = a.c(-402032835, "睈\u0efb萳ᩈ醙");
   static final String nmp = a.c(1417472844, "\uef06隲ᰝ艣ৎ謔㕐벦⋸꠸⾛햘孁");
   static final String nmq = a.b("ﾭ蘔࣒銳\u196e龧◵걷㈣", -1210254439);
   static final String nmr = a.b("敎ᲀ阭ࡖ莅Զ", 65429879);
   static final String nms = a.b("龜肿੧鐒ῄ饻", -2022834893);
   static final String[] nmt = new String[]{
      a.c(-1151989219, "อ瞔勒捁\ue8e4湟퀖巶쏓䥨캸㓋멢"),
      a.b("֫籠\uf6b0梱\ue314斡\udff0初졓䊘앁㼳뇦⠩", -1721433628),
      a.b("⡕冞\udb4e䕏컪䡟\uf20e翣\ue5db漝\ue8bfው鱦", 1453075481),
      a.c(1350132863, "恇᧷錮ൕ蚊9멦"),
      a.d("ᨦ掛\ue948眺ﳥ穟쀔䧼", 2027829326, 947200515)
   };
   static final String[] nmu = new String[]{
      a.d("\uf277诎Ԉ齤ᒾ鈆⡘", 1916029549, -113329120),
      a.c(-1717891486, "\u0a55珬ﴪ机\uecef橔큻姾잢䵣"),
      a.c(-1534417231, "ꊇ\udb3e冚쮉䑁슏碩\uf159漎\ue5b6戒"),
      a.d("嘼⾎ꕙ㬬낁", -1278593382, -875273064),
      a.d("鿂\ue67b沦\uf2a0礌ￅ", 1240536523, 1455001138),
      a.d("蜤ﺒ瑎\uea40懢\ue72f", 1553206516, 665817057),
      a.d("㿛䙢첰勋\ud963忑\ue5f0汳\uf250碘ＱՃ", -1920542226, 1824973316),
      a.c(-1104399963, "㖒䰫십壹퍙嗪\uefcb晈\uf812狔"),
      a.b("劒⭙ꆉ㾈됭㊘裉", -1242736940),
      a.b("닲쬵䆖\udfee吲", -2031044919),
      a.b("쪁댸㷾\ua7ecⱌ\uaaf9Ⴁ", 1993068219)
   };
   static final String[] nmv = new String[]{a.d("䫋㌅릥⟘가⪾郧", 1537211233, 1522447763), a.b("⒣嵢ퟄ䦽쉣", 1214652566)};
   static final int nmw = 36;
   static final double nmx = 0.75;
   static final long nmy = 180000L;
   static final long nmz = 120000L;
   static final long nna = 110L;
   static final long nnb = 360L;
   static final long nnc = 260L;
   static final long nnd = 4000L;
   static final long nne = 4000L;
   static final long nnf = 20000L;
   static final long nng = 850L;
   static final long nnh = 900L;
   static final long nni = 3500L;
   static final double nnj = 1.4;
   static final double nnk = 1500.0;
   static final double nnl = 0.75;
   static final long nnm = 25000L;
   static final int nnn = 3;
   static final long nno = 60000L;
   static final long nnp = 380L;
   static final double nnq = 4.3;
   static final long nnr = 60000L;
   static final long nns = 1500L;
   static final long nnt = 3000L;
   static final int nnu = 64;
   static final int nnv = 0;
   static final int nnw = 1;
   static final int nnx = 2;
   static final int nny = 3;
   static final Field nnz = vxr.find(
      ClientPlayerEntity.class, a.c(1576694976, "璹ഃ蟁᧪鉾ᓋ꺟❥뤼㎜둜个샯处팚嗤\uefa6恥𥳐粫\uf534车Ǘ"), a.d("\uef78集ᰙ艡া輴㔋볰⊢ꠖ", -55873425, -330457221), a.c(992488130, "⪅")
   );
   static final Field noa = vxr.find(
      ClientPlayerEntity.class, a.b("㭄䋾젼嘗\udd83嬶\ue162梘\uf6c1籡ﮡǗ輒\u16f9鳧ᨙꁛ⾘딫㍖뫉삛个", 1847540541), a.b("ꯥ퉛墄웼䴣쮩熖\uf86d昹\uec8f", -412177527), a.b("ᖝ", -508881446)
   );
   static nmg nob;
   final vmc noc = this.add(new vmc(a.c(-1501869311, "伖㚂뱟∭귯⼾镦᳡芹ࠂ"), 5.0, 1.0, 50.0, 1.0).suffix(a.c(-1002632484, "\u0af8")));
   final vmc nod = this.add(new vmc(a.d("濓ᘆ鲮˗褃࿆떖㱩Ꙛ⢌꼨唩", -1464656866, -950765600), 60.0, 0.0, 100.0, 5.0).suffix(a.d("\uea7d", 1228273941, 28906316)));
   final vkl noe = this.add(new vkl(a.d("乢㟈뵧⍥ꢳ\u2e72遁᷒菱ै躘", -798940136, -1107988908), false));
   final vmc nof = this.add(new vmc(a.b("\ue533鲣ᙶ衾ϒ蕧㼸닛⢖\ua635◺\udf8f兝좒䋀쐰", 1029759292), 20.0, 4.0, 40.0, 1.0));
   final vkl nog = this.add(new vkl(a.b("\ue04a駔ᜐ贀ە耚㩀돆ⷠꝕ₊", 929686617), true));
   nmc noh = nmc.IDLE;
   long noi;
   long noj;
   long nok;
   long nol;
   long nom = -1L;
   int non = 0;
   long noo;
   long nop;
   long noq = 360L;
   long nor;
   long nos;
   int not;
   long nou;
   int nov;
   int now = 8;
   boolean nox;
   ItemStack noy = ItemStack.EMPTY;
   String noz = "";
   String npa = "";
   final Set<String> npb = new HashSet<>();
   final Map<String, long[]> npc = new HashMap<>();
   int npd = -1;
   int npe;
   int npf;
   long npg;
   boolean nph;
   int npi = -1;
   int npj = -1;
   int npk = -1;
   int npl = -1;
   boolean npm;
   final vyn npn = new vyn();
   long npo;
   long npp;
   boolean npq;
   int npr = -1;
   int nps = -1;
   long npt;
   int npu = 0;
   String npv = "";
   final Map<BlockPos, Long> npw = new HashMap<>();
   BlockPos npx;
   BlockPos npy;
   Vec3d npz;
   double nqa;
   double nqb;
   double nqc;
   int nqd;
   long nqe;
   boolean nqf;
   int nqg;
   int nqh;
   int nqi;
   int nqj = -1;
   int nqk = -1;
   ItemStack[] nql;
   final boolean[] nqm = new boolean[9];
   boolean nqn;
   final pgi nqo = new pgi();
   final pjw nqp = new pjw();
   ClientPlayerEntity nqq;
   boolean nqr;
   long nqs;

   public nmg() {
      super(a.d("凐⡕ꊇ㳭뜆ㆁ诛Ȫ", 1739780492, -385048555), a.c(512599125, "ꐮ\udda9坳줂䋊쐨縢\uf7c5榀\ue336撷麏ၟ觶ζ蕌㼙냓⩽갧▉得턥䪺쳊䙕\uffef燶\ueb54洞\ue6a7ᡷ鈯\u0b8c趒ܯ룫㊃둞ⷾ"), kfa.PLAYER);
      nob = this;
   }

   public static void onMessage(Text var0) {
      nmg var1 = nob;
      if (var1 != null && var1.isEnabled()) {
         var1.nqv(var0);
      }
   }

   @Override
   protected void onEnable() {
      this.num();
      this.npb.clear();
      this.npw.clear();
      this.nqn = false;
      this.nqo.reset();
      this.nov = 0;
      this.now = nug();
      this.npl = this.mc.player == null ? -1 : this.mc.player.getInventory().getSelectedSlot();
      long var1 = System.currentTimeMillis();
      this.npc.values().removeIf(var2 -> var1 - var2[1] > 180000L);
      this.nop = var1 + 260L + ThreadLocalRandom.current().nextLong(0L, 340L);
      this.nok = Math.max(this.nok, var1 + nuf());
   }

   @Override
   protected void onDisable() {
      this.num();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.nsg();
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.getNetworkHandler() != null) {
         if (this.npm) {
            this.npn.hold(var1);
         }

         if (this.nqr && this.noh == nmc.CHEST_OPEN) {
            this.nsh();
         }

         if (this.noh == nmc.IDLE) {
            Screen var3 = var1.currentScreen;
            if (var3 == null || var3 instanceof HandledScreen) {
               if (System.currentTimeMillis() >= this.nop) {
                  if (!this.nqw() && !this.nrw()) {
                     this.nra();
                  }
               }
            }
         } else if (this.noh.nmd > 0L && System.currentTimeMillis() - this.noi > this.noh.nmd) {
            if (this.noh == nmc.RESTORE) {
               this.nrl();
            } else if (this.noh == nmc.CHEST_OPEN) {
               this.nsc(
                  System.currentTimeMillis() + 60000L,
                  wap.s(a.c(1859138279, "㊦䬫쇵忁푕勯\ue8b1慖．痫\uf27cࠀ蛚ὡ镻Ꮩ꧂♜볰㪴덈"), a.c(-469570317, "\ue8c0鄓ᮾ藆\u0e66袮㛧묋╜꯸⠵툸岗앜伄즅现ﱯ")),
                  false,
                  0
               );
            } else if (this.noh == nmc.CHEST_LOOT) {
               this.nsd();
               this.nsc(0L, null, true, 2);
            } else if (this.nrs()) {
               this.nun(
                  wap.s(a.c(-1118277666, "澝ᘐ鳎˺襾࿈떀㱬ꈠ⢗꽆啲\udbe1䉝젃仸\uf4fe筼\ue19b枅\uee6d鐩᪑"), a.d("\ue89b酏ᯬ薐โ裰㊠묠┃ꮧ⡩툐壒약佒짛珮ﰴ曷\ue0a3椫፷", 85673192, 1743300672)), false
               );
               this.nrr();
            } else {
               this.nqz(
                  wap.s(a.b("Ᏽ橸\ue0a6纒\uf504玡짤䀂\ude40哷팥⤚Ꞅ㸯됯㊍裘܌鶶ᯬ鈁\ue81e暷", 708121526), a.d("믗숵䢟횒崻\udb8c懜\uec30癳ﳀ笖脛ླ陸ᡓ麸", 1842220612, 787853715)) + this.npa,
                  false,
                  true
               );
            }
         } else {
            switch (this.noh) {
               case TAKE:
                  this.nrb();
                  break;
               case SEARCH:
                  this.nrc();
                  break;
               case SCAN:
                  this.nrd();
                  break;
               case SEND:
                  this.nri();
                  break;
               case CONFIRM:
                  this.nrj();
                  break;
               case RESTORE:
                  this.nrk();
                  break;
               case FULL_WAIT:
                  this.nrn();
                  break;
               case AH_OPEN:
                  this.nro();
                  break;
               case AH_STORAGE:
                  this.nrp();
                  break;
               case AH_RELIST:
                  this.nrq();
                  break;
               case CHEST_OPEN:
                  this.nry();
                  break;
               case CHEST_LOOT:
                  this.nsb();
            }
         }
      } else {
         if (this.noh != nmc.IDLE) {
            this.num();
         }
      }
   }

   void nqv(Text var1) {
      if (this.noh != nmc.IDLE && !this.nrs() && System.currentTimeMillis() - this.noo <= 4000L) {
         String var2 = nto(var1.getString());
         if (!var2.isEmpty()) {
            if (ntp(var2)) {
               this.npu = 3;
            } else if (ntq(var2, nmt)) {
               this.npu = 1;
            } else if (ntq(var2, nmu)) {
               this.npv = var2.length() > 48 ? var2.substring(0, 48) : var2;
               this.npu = 2;
            }
         }
      }
   }

   boolean nqw() {
      PlayerInventory var1 = this.mc.player.getInventory();

      for (int var2 = 0; var2 < 2; var2++) {
         int var3 = var2 == 0 ? 9 : 0;
         int var4 = var2 == 0 ? 36 : 9;

         for (int var5 = var3; var5 < var4; var5++) {
            if (this.nqx(var5)) {
               ItemStack var6 = var1.getStack(var5);
               if (!var6.isEmpty()) {
                  String var7 = nti(var6);
                  if (!this.npb.contains(var7)) {
                     String var8 = cleanQuery(var6.getName().getString());
                     if (!var8.isEmpty()) {
                        this.noy = var6.copy();
                        this.noz = var7;
                        this.npa = var8;
                        this.npd = -1;
                        this.npf = 0;
                        this.npu = 0;
                        this.npv = "";
                        this.npq = false;
                        this.noq = 360L + ThreadLocalRandom.current().nextLong(0L, 260L);
                        this.nun(wap.s(a.c(1626048758, "袬\uf12b篱\ue580湒\ue8e4劾\udb12䕗"), a.d("퇠ꠎ⊣볘㜋뇄\u0fe3蘈", -1763073027, 1907062282)) + this.npa, true);
                        this.nul(nmc.TAKE);
                        return true;
                     }

                     this.npb.add(var7);
                  }
               }
            }
         }
      }

      return false;
   }

   boolean nqx(int var1) {
      if (var1 == this.npk) {
         return false;
      } else {
         return var1 >= 9 ? true : this.noe.get() || var1 == this.npi || this.nqy(var1);
      }
   }

   boolean nqy(int var1) {
      if (!this.nqm[var1]) {
         return false;
      } else if (this.mc.player.getInventory().getStack(var1).isEmpty()) {
         this.nqm[var1] = false;
         return false;
      } else {
         return true;
      }
   }

   void nqz(String var1, boolean var2, boolean var3) {
      if (var3 && !this.noz.isEmpty()) {
         this.npb.add(this.noz);
      }

      if (var1 != null) {
         long var4 = System.currentTimeMillis();
         if (var2 || var4 - this.nor > 4000L) {
            if (!var2) {
               this.nor = var4;
            }

            this.nun(var1, var2);
         }
      }

      this.npq = false;
      this.npd = -1;
      this.npf = 0;
      this.npu = 0;
      this.npv = "";
      this.noy = ItemStack.EMPTY;
      this.noz = "";
      this.npa = "";
      this.nty();
      this.nop = System.currentTimeMillis() + 260L + ThreadLocalRandom.current().nextLong(0L, 300L);
      this.nul(nmc.IDLE);
   }

   void nra() {
      this.nun(
         this.npe > 0
            ? wap.s(a.d("閘\uec02曐\uf8aa猴\uf589侖왤堠튖唌꽧", 1170604283, -1443654357), a.d("踸\uf7a4紋\ue306棝\uee60倡\ud9dc䎘줬亃뒎㩕\ua7ecⶥ", 1967025482, -1392973970))
               + this.npe
            : wap.s(a.c(76792324, "쉅믕ㄝ꽰⒦ꈐᡊ釼\u0ff7蕝ˁ\uf8e3瘢\uef9a旉"), a.d("ꐀ\uddee坃줸䋫쑘縉\uf78a槛\ue706擈麱န觗\u0382蕾", -2047509949, 671013452)),
         this.npe > 0
      );
      this.nph = true;
      this.nul(nmc.RESTORE);
   }

   void nrb() {
      if (!this.ntv()) {
         PlayerInventory var1 = this.mc.player.getInventory();
         if (this.nqx(var1.getSelectedSlot()) && ntj(this.mc.player.getMainHandStack(), this.noy)) {
            this.nty();
            this.nul(nmc.SEARCH);
         } else {
            int var2 = this.ntr();
            if (var2 < 0) {
               this.nqz(null, true, false);
            } else if (var2 < 9) {
               this.nty();
               if (this.nub()) {
                  var1.setSelectedSlot(var2);
                  this.nul(nmc.SEARCH);
               }
            } else if (this.ntw()) {
               int var3 = this.ntt();
               boolean var4 = !var1.getStack(var3).isEmpty();
               this.ntz(ntu(var2), SlotActionType.SWAP, var3);
               this.npi = var3;
               if (var4 && this.npj < 0) {
                  this.npj = var3;
                  this.npk = var2;
               }
            }
         }
      }
   }

   void nrc() {
      this.nty();
      if (!this.ntv()) {
         String var1 = cleanQuery(this.mc.player.getMainHandStack().getName().getString());
         if (!var1.isEmpty()) {
            this.npa = var1;
         }

         long var2 = System.currentTimeMillis();
         long[] var4 = this.nrh(this.noz, var2, 180000L);
         if (var4 != null) {
            if (var4[0] > 0L) {
               this.nul(nmc.SEND);
            } else {
               this.nqz(wap.s(a.d("뺍윝䶁펠塵\udedf撆\ued71獱栗", 1707452646, -967371217), a.b("\udbb8ꈡ⢅늖㴧믥ƾ蠹ሗ颼", 381542319)) + this.npa, false, true);
            }
         } else if (this.nud(var2, 0)) {
            this.npq = true;
            this.nps = -1;
            this.npt = 0L;
            this.npr = this.mc.player.currentScreenHandler == null ? -1 : this.mc.player.currentScreenHandler.syncId;
            this.npu = 0;
            this.nua(a.b("뀜즤䌿\udd1d囜큩権\ue3c9綝\uf764", -151342985) + this.npa);
            this.nul(nmc.SCAN);
         }
      }
   }

   void nrd() {
      this.nty();
      if (this.npu == 3) {
         this.nrm();
      } else if (this.npu == 2) {
         this.nuk();
      } else if (this.npu == 1) {
         if (this.nuj()) {
            this.nul(nmc.SEARCH);
         }
      } else {
         List var1 = this.nre();
         if (var1 != null) {
            long var2 = System.currentTimeMillis();
            if (var2 - this.npt >= this.noq) {
               this.npq = false;
               this.nrf(var1, var2);
               long[] var4 = this.nrh(this.noz, var2, 180000L);
               if (var4 != null && var4[0] > 0L) {
                  this.nou = var2 + nuh(900L, 0.45, 350L, 3500L);
                  this.nul(nmc.SEND);
               } else {
                  this.nqz(wap.s(a.c(-1517454865, "禫;誧ᒆ齓᧹ꎠ⩗둗㻼"), a.d("熁࠘芼\u18af霞ᇜꮇ∀렮㊅", -125098721, 389369993)) + this.npa, false, true);
               }
            }
         }
      }
   }

   List<ItemStack> nre() {
      if (this.npq && this.mc.currentScreen instanceof HandledScreen) {
         ScreenHandler var1 = this.mc.player.currentScreenHandler;
         if (var1 instanceof GenericContainerScreenHandler && var1.syncId != this.npr) {
            int var2 = var1.slots.size() - 36;
            boolean var3 = false;

            for (int var4 = 0; var4 < var2 && !var3; var4++) {
               var3 = !var1.slots.get(var4).getStack().isEmpty();
            }

            if (!var3) {
               return null;
            }

            if (var1.syncId != this.nps) {
               this.nps = var1.syncId;
               this.npt = System.currentTimeMillis();
            }

            ArrayList var6 = new ArrayList(var1.slots.size());

            for (int var5 = 0; var5 < var1.slots.size(); var5++) {
               var6.add(var1.slots.get(var5).getStack().copy());
            }

            return var6;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   void nrf(List<ItemStack> var1, long var2) {
      this.nrg(this.noz, this.nsz(var1, this.noy), var2);
      String var4 = this.npa;
      PlayerInventory var5 = this.mc.player.getInventory();

      for (int var6 = 0; var6 < 36; var6++) {
         if (this.nqx(var6)) {
            ItemStack var7 = var5.getStack(var6);
            if (!var7.isEmpty() && var7.getItem() == this.noy.getItem()) {
               String var8 = nti(var7);
               if (!var8.equals(this.noz) && !this.npb.contains(var8) && var4.equals(cleanQuery(var7.getName().getString()))) {
                  this.nrg(var8, this.nsz(var1, var7), var2);
               }
            }
         }
      }
   }

   void nrg(String var1, int var2, long var3) {
      this.npc.put(var1, new long[]{var2 > 0 ? var2 : -1L, var3});
   }

   long[] nrh(String var1, long var2, long var4) {
      long[] var6 = this.npc.get(var1);
      return var6 != null && var2 - var6[1] < var4 ? var6 : null;
   }

   void nri() {
      this.nty();
      long var1 = System.currentTimeMillis();
      if (var1 < this.nou && this.mc.currentScreen instanceof HandledScreen) {
         this.noi = var1;
      } else if (!this.ntv()) {
         if (this.npu == 3) {
            this.nrm();
         } else if (this.npu == 2) {
            this.nuk();
         } else {
            long[] var3 = this.nrh(this.noz, var1, 300000L);
            if (var3 != null && var3[0] > 0L) {
               int var4 = (int)var3[0];
               ItemStack var5 = this.mc.player.getMainHandStack();
               if (!ntj(var5, this.noy)) {
                  if (++this.npf > 2) {
                     this.nqz(
                        wap.s(a.d("௱牼\uf8a2暖\ued08殤퇦堟옍䳰쬪ㅘ뾝♸걿⪒郐ὄ薿ϧ訟\uf044", -2054961122, 992265133), a.c(1289452755, "磥ň讗ᗤ鹃Გꋞ⭐땱㿁렝䉧좫唂\udf5e嶸\ue397汅\uf68f烜")),
                        false,
                        true
                     );
                  } else {
                     this.nul(nmc.TAKE);
                  }
               } else if (this.nud(var1, 1)) {
                  int var6 = Math.max(1, var5.getCount());
                  long var7 = (long)Math.floor(var4 * (1.0 - this.noc.get() / 100.0));
                  if (var7 >= var4) {
                     var7 = var4 - 1L;
                  }

                  this.npg = nth(Math.max(1L, var7) * var6);
                  this.npd = this.nts();
                  this.nua(a.d("ퟯ깗Ⓦ뫮ㄯ랗හ葹", 2130015067, 966829277) + this.npg);
                  this.nul(nmc.CONFIRM);
               }
            } else {
               this.nul(nmc.SEARCH);
            }
         }
      }
   }

   void nrj() {
      this.nty();
      if (!this.ntv()) {
         if (this.npu == 3) {
            this.nrm();
         } else if (this.npu == 1) {
            if (this.nuj()) {
               this.nul(nmc.SEND);
            }
         } else if (this.npu == 2) {
            this.nuk();
         } else {
            int var1 = this.nts();
            if (this.npd >= 0 && var1 < this.npd) {
               this.npe++;
               this.not = 0;
               this.npf = 0;
               this.npd = -1;
               this.nun(
                  wap.s(a.d("벥씱俸톎婈\udcf8曯\uef58焎ﮢ簣", -611244710, -1685153352), a.d("鵔\ue4bc湥\uf017箲ﴁ䝛캤僳\uda41妌\ua7ea⤺뒛", 243713159, -1231790641)) + this.npg,
                  true
               );
               if (++this.nov >= this.now) {
                  this.nov = 0;
                  this.now = nug();
                  this.nok = Math.max(this.nok, System.currentTimeMillis() + nuh(3500L, 0.45, 1500L, 12000L));
               }

               if (var1 > 0) {
                  this.nul(nmc.TAKE);
               } else {
                  this.nqz(null, true, false);
               }
            }
         }
      }
   }

   void nrk() {
      if (!this.ntv()) {
         PlayerInventory var1 = this.mc.player.getInventory();
         if (this.npj >= 0 && this.npk >= 0) {
            boolean var2 = !var1.getStack(this.npk).isEmpty() || !var1.getStack(this.npj).isEmpty();
            if (var2) {
               if (!this.ntw()) {
                  return;
               }

               this.ntz(ntu(this.npk), SlotActionType.SWAP, this.npj);
            }

            this.npj = -1;
            this.npk = -1;
         } else {
            this.nty();
            if (this.npl >= 0 && this.npl < 9 && var1.getSelectedSlot() != this.npl) {
               if (!this.nub()) {
                  return;
               }

               var1.setSelectedSlot(this.npl);
            }

            this.nrl();
         }
      }
   }

   void nrl() {
      boolean var1 = this.nph;
      this.num();
      if (var1) {
         this.setEnabled(false);
      }
   }

   void nrm() {
      this.npu = 0;
      this.npv = "";
      this.npd = -1;
      this.npq = false;
      this.nty();
      if (this.nox) {
         this.nun(
            wap.s(
               a.c(-1951403857, "\uf0c6襚Ή鶴ᘯ邝⫕ꍰ㵼럒。쩨䒸\udd5a坈톪毲\ue466纁\uf8c5焸୧藟Ṍ頿አꬒ╛뾳㧯뉋䲍욇弢\ud96a厔\uec10晷\ue0ad礜"),
               a.c(1292075897, "蝼ﻗ琁\uea0c懒\ue308嵀풴䪗쁚䞅맦㌦ꪐ\u20ceꙍᰏ鏗ഃ譞ڶ粘\uf255榎\ueff5攦\udc97労졍䩰엞㬇녇⣏껫\u245e")
            ),
            false
         );
         this.nra();
      } else {
         long var1 = System.currentTimeMillis();
         if (var1 >= this.npo) {
            this.nul(nmc.AH_OPEN);
         } else {
            this.nun(
               wap.s(
                     a.d("㤏䂂쩜周\udfec奚\ue312櫾\uf4b2縅倫Ϡ赾ᓕ黕ᡢꈾⷶ띅ㅔ뢯슬䰈ퟐ冪\udb61拕\uec99癩\uf031篅蕝༕險", 2127213415, 909609502),
                     a.b("䘍㿙땺⬆ꃔ♦鰶ᖶ讕Ա蛽粍\uf25f毨\ue1b8捛\ud918勖졯之쟉붟㍕ꢎ⻲ꑑᷠ鎸ऺ謅ӑ全灈\ue9cc澝\ue13b", 2108375564)
                  )
                  + (this.npo - var1 + 999L) / 1000L
                  + wap.s(a.b("ދ繩", 833816489), a.c(1661766070, "覔\uf444")),
               false
            );
            this.nul(nmc.FULL_WAIT);
         }
      }
   }

   void nrn() {
      if (System.currentTimeMillis() >= this.npo) {
         this.nul(nmc.AH_OPEN);
      }
   }

   void nro() {
      if (!this.ntv()) {
         long var1 = System.currentTimeMillis();
         if (this.nud(var1, 0)) {
            this.npo = var1 + 60000L + ThreadLocalRandom.current().nextLong(400L, 4000L);
            this.nox = true;
            this.nua(a.b("銃\ueb3b", -1888578848));
            this.nul(nmc.AH_STORAGE);
         }
      }
   }

   void nrp() {
      int var1 = this.nrt(a.b("臧\uf853狰\uec8c杞\ue1ec宼툼", 1830716842));
      if (var1 >= 0 && this.nrv() && this.ntx()) {
         this.ntz(var1, SlotActionType.PICKUP, 0);
         pdi.note(0);
         this.nul(nmc.AH_RELIST);
      }
   }

   void nrq() {
      int var1 = this.nrt(a.c(1019336349, "튨ꬓ↵뾱㑡늩ࣰ脂Ἧ閜"));
      if (var1 >= 0 && this.nrv() && this.ntx()) {
         int var2 = this.nru();
         if (var2 > 0) {
            this.ntz(var1, SlotActionType.PICKUP, 0);
            pdi.note(0);
            this.nun(wap.s(a.b("ီ榨\ue372紆\uf6cb災쨳䏅\udd93坿킶", -1983180681), a.d("磘Ń该ᗡ鸱\u18f9ꊠ⭒땿㿌렖䈓쳅儀\udb49", 1669158300, -1291114156)) + var2, true);
         } else {
            this.nun(
               wap.s(
                  a.c(374693028, "峞╓꾍ㆹ먽㲋蛃༯酣ᯔ鰅昱\ue8af焄ﬄ綰쟷䠻튌哐\udd72ꜯ⧈눅㑷뻣܃襍Ꮉ闳ṇ\ue0c5櫂\uf334畤\uffdd䁎쩳䲥픋彇⇳꯬ⱞ뚒㣤"),
                  a.c(756897622, "卖⪂ꀡ㹝떏㌽襭í黎ၪ鎦榫\ue77e绌\uf4e3爙챏䎒\udd40孫튙ꢴ☎릴㯜넊ࢴ蚗ᱭ騵ᗭ\uef27敭ﳠ竁\uf07c侯")
               ),
               false
            );
         }

         this.nrr();
      }
   }

   void nrr() {
      this.nty();
      this.npu = 0;
      this.npv = "";
      long var1 = System.currentTimeMillis();
      this.noo = 0L;
      this.nok = Math.max(this.nok, var1 + nuh(1600L, 0.35, 900L, 4000L));
      this.noj = var1 + 250L + ThreadLocalRandom.current().nextLong(0L, 350L);
      this.nul(this.noy.isEmpty() ? nmc.IDLE : nmc.TAKE);
   }

   boolean nrs() {
      return this.noh == nmc.FULL_WAIT || this.noh == nmc.AH_OPEN || this.noh == nmc.AH_STORAGE || this.noh == nmc.AH_RELIST;
   }

   int nrt(String var1) {
      ClientPlayerEntity var2 = this.mc.player;
      ScreenHandler var3 = var2.currentScreenHandler;
      if (this.mc.currentScreen instanceof HandledScreen && var3 != null && var3 != var2.playerScreenHandler) {
         int var4 = var3.slots.size() - 36;
         if (var4 < 9) {
            return -1;
         }

         for (int var5 = var4 - 9; var5 < var4; var5++) {
            ItemStack var6 = var3.slots.get(var5).getStack();
            if (!var6.isEmpty() && pfl.title(var6.getName().getString()).contains(var1)) {
               return var5;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   int nru() {
      ScreenHandler var1 = this.mc.player.currentScreenHandler;
      int var2 = var1.slots.size() - 36;
      int var3 = 0;

      for (int var4 = 0; var4 < var2 - 9; var4++) {
         if (!var1.slots.get(var4).getStack().isEmpty()) {
            var3++;
         }
      }

      return var3;
   }

   boolean nrv() {
      if (this.npp != 0L) {
         return true;
      }

      long var1 = System.currentTimeMillis();
      this.npp = var1;
      double var3 = nui(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.25, 0.7, 1.9);
      long var5 = (long)(380.0 * var3) + ThreadLocalRandom.current().nextLong(10L, 90L);
      this.noj = Math.max(this.noj, var1 + var5);
      return false;
   }

   boolean nrw() {
      if (!this.nog.get()) {
         return false;
      }

      ClientPlayerEntity var1 = this.mc.player;
      if (!var1.hasVehicle() && nsy(var1.getInventory()) && !this.nsm()) {
         long var2 = System.currentTimeMillis();
         if (oqv.listEmpty()) {
            if (!this.nqn && this.nrx(var2) != null) {
               this.nqn = true;
               this.nun(
                  wap.s(
                     a.d("䈠㮺녤⼃ꓓ≚頪ᇛ辟Կ苻磟\uf65c澾\ue5a1捕\ud900囖찱䨩쏄맆㜰곩⪋ꁞ᧠", -292513171, 831182869),
                     a.d("ﵶ蓙ญ逅ᮭ鴘⍑\uaac3㒷븋㧎쎸䵗퓅庖\ud87c戢\uede4眅\uf54b糀ړ蠣", 577765907, -133039277)
                  ),
                  false
               );
            }

            return false;
         } else {
            ThreadLocalRandom var4 = ThreadLocalRandom.current();
            this.nqa = (var4.nextDouble() - 0.5) * 0.3;
            this.nqb = (var4.nextDouble() - 0.5) * 0.25;
            this.nqc = (var4.nextDouble() - 0.5) * 0.3;
            BlockPos var5 = this.nrx(var2);
            if (var5 == null) {
               return false;
            }

            this.npx = var5;
            this.npy = nst(this.mc.world, var5);
            this.npz = this.nso(var5);
            this.nqd = 1 + var4.nextInt(4);
            this.nqe = 0L;
            this.nsj(var1);
            this.nul(nmc.CHEST_OPEN);
            return true;
         }
      } else {
         return false;
      }
   }

   BlockPos nrx(long var1) {
      ClientWorld var3 = this.mc.world;
      ClientPlayerEntity var4 = this.mc.player;
      Vec3d var5 = var4.getEyePos();
      double var6 = 28.09;
      BlockPos var8 = null;
      double var9 = Double.MAX_VALUE;
      int var11 = var4.getBlockX() >> 4;
      int var12 = var4.getBlockZ() >> 4;

      for (int var13 = -1; var13 <= 1; var13++) {
         for (int var14 = -1; var14 <= 1; var14++) {
            WorldChunk var15 = var3.getChunkManager().getWorldChunk(var11 + var13, var12 + var14, false);
            if (var15 != null) {
               for (BlockEntity var17 : var15.getBlockEntities().values()) {
                  if (var17 instanceof ChestBlockEntity || var17 instanceof BarrelBlockEntity) {
                     BlockPos var18 = var17.getPos();
                     if (!(var5.squaredDistanceTo(Vec3d.ofCenter(var18)) > var6)) {
                        BlockPos var19 = nst(var3, var18);
                        Long var20 = this.npw.get(var19);
                        if (var20 == null || var20 <= var1) {
                           int var21 = oqv.markState(var3, var18);
                           if (var21 != 1 && (var21 != 2 || var20 != null)) {
                              if (nsu(var3, var18)) {
                                 this.npw.put(var19, Long.MAX_VALUE);
                              } else {
                                 Vec3d var22 = this.nso(var18);
                                 double var23 = var22 == null ? Double.MAX_VALUE : var5.squaredDistanceTo(var22);
                                 if (var23 <= 18.49 && var23 < var9) {
                                    var9 = var23;
                                    var8 = var18.toImmutable();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var8;
   }

   void nry() {
      ClientPlayerEntity var1 = this.mc.player;
      long var2 = System.currentTimeMillis();
      ClientWorld var4 = this.mc.world;
      if (this.nqe > 0L && this.mc.currentScreen instanceof HandledScreen && this.nrz(var4, var1.currentScreenHandler, var2)) {
         this.nsa(var2);
      } else if (!this.ntv()) {
         if (this.npx != null && nsr(var4, this.npx)) {
            Vec3d var5 = var1.getEyePos();
            if (this.npz == null || var5.distanceTo(this.npz) > 4.3) {
               this.npz = this.nso(this.npx);
               if (this.npz == null || var5.distanceTo(this.npz) > 4.3) {
                  this.nsc(var2 + 60000L, null, false, 0);
                  return;
               }
            }

            this.nsi();
            float var6 = vxr.getFloat(nnz, var1, var1.getYaw());
            float var7 = vxr.getFloat(noa, var1, var1.getPitch());
            BlockHitResult var8 = this.nse(var1, var6, var7);
            if (var8 != null && this.nsq(var4, var8.getBlockPos())) {
               if (this.nqd > 0) {
                  this.nqd--;
               } else if (var2 - this.nqe > 1500L && !var1.isSneaking() && !var1.isUsingItem() && vyn.serverIdle(var1)) {
                  this.nsf();
                  this.nqe = var2;
               }
            }

            this.nsk(this.npz, this.nsp(var4, this.npx, this.npz));
         } else {
            this.nsc(Long.MAX_VALUE, null, false, 0);
         }
      }
   }

   boolean nrz(World var1, ScreenHandler var2, long var3) {
      if (var2 instanceof GenericContainerScreenHandler var5 && var3 - this.nqe <= 3000L && this.npx != null) {
         int var6 = nss(var1, this.npx) != null ? 6 : 3;
         if (var5.getRows() != var6) {
            return false;
         }

         String var7 = pfl.title(this.mc.currentScreen.getTitle().getString());
         return !var7.contains(a.d("⡍冏\udb25䔨캁䠶\uf266", -1326163368, 295728674)) && !var7.contains(a.c(-89532832, "툭ꮙ℺뽆㒔눦ࡶ臶"));
      } else {
         return false;
      }
   }

   void nsa(long var1) {
      PlayerInventory var3 = this.mc.player.getInventory();
      this.nqk = this.mc.player.currentScreenHandler.syncId;
      this.nql = new ItemStack[9];

      for (int var4 = 0; var4 < 9; var4++) {
         this.nql[var4] = var3.getStack(var4).copy();
      }

      this.nqg = 0;
      this.nqh = 0;
      this.nqj = -1;
      this.nqi = nsv(var3);
      this.noj = var1 + this.nqo.draw(0);
      this.nul(nmc.CHEST_LOOT);
   }

   void nsb() {
      ClientPlayerEntity var1 = this.mc.player;
      long var2 = System.currentTimeMillis();
      ScreenHandler var4 = var1.currentScreenHandler;
      if (!(this.mc.currentScreen instanceof HandledScreen) || !(var4 instanceof GenericContainerScreenHandler) || var4.syncId != this.nqk) {
         this.nsc(var2 + 15000L, null, true, this.nqh > 0 ? 2 : 0);
      } else if (var2 >= this.noj && vyn.serverIdle(var1)) {
         PlayerInventory var5 = var1.getInventory();
         if (this.nqg >= 4 && this.nqg % 4 == 0 && nsv(var5) <= this.nqi) {
            this.nsd();
            this.nsc(
               Long.MAX_VALUE,
               wap.s(a.c(394115480, "맒쁟䪁풵弡\ud99b揅\uea22瑺ﺟ礛荲ඤ鑜Ṝ飹⋱괮㞂뇀㡲䉪쳄園턾宦\ue208汈\uf6b7烸"), a.d("岤╷꿚ㆢ먂㳊芃\u0f6f鄸ᾜ鱑晜\ue8fd煈ﭺ綘쎵䡶틂哯\udd69", -552115097, -388088585)),
               false,
               2
            );
         } else {
            int var6 = var4.slots.size() - 36;
            int var7 = -1;
            double var8 = Double.MAX_VALUE;
            boolean var10 = false;

            for (int var11 = 0; var11 < var6; var11++) {
               ItemStack var12 = var4.slots.get(var11).getStack();
               if (!var12.isEmpty() && !this.npb.contains(nti(var12)) && oqv.wantsItem(var12.getItem())) {
                  if (!nsx(var5, var12)) {
                     var10 = true;
                  } else {
                     double var13 = this.nqj < 0 ? var11 * 0.01 : nsw(this.nqj, var11);
                     if (var13 < var8) {
                        var8 = var13;
                        var7 = var11;
                     }
                  }
               }
            }

            if (var7 >= 0 && this.nqg < 64) {
               this.mc.interactionManager.clickSlot(var4.syncId, var7, 0, SlotActionType.QUICK_MOVE, var1);
               this.nqh++;
               this.nqj = var7;
               this.noj = var2 + this.nqo.draw(this.nqg++ == 0 ? 1 : 2);
            } else {
               boolean var15 = var10 || var7 >= 0;
               this.nsd();
               this.nsc(
                  var15 ? 0L : Long.MAX_VALUE,
                  this.nqh > 0 ? wap.s(a.b("璍ഈ蟆ᦵ鈯ᓊ꺅❹륣㎑둉丵샴奂퍟喴", 664827099), a.b("\ua83b톥彡앱交졫爱﮷斑\uef2a泳隘", 582528047)) + this.nqh : null,
                  true,
                  var15 ? 2 : 1
               );
            }
         }
      }
   }

   void nsc(long var1, String var3, boolean var4, int var5) {
      if (this.npy != null) {
         this.npw.put(this.npy, var1);
      }

      if (var5 != 0 && this.npx != null) {
         oqv.markFromOutside(this.mc.world, this.npx, var5 == 2);
      }

      if (var4 && this.nql != null) {
         PlayerInventory var6 = this.mc.player.getInventory();

         for (int var7 = 0; var7 < 9; var7++) {
            if (this.nql[var7].isEmpty() && !var6.getStack(var7).isEmpty()) {
               this.nqm[var7] = true;
            }
         }
      }

      if (var3 != null) {
         this.nun(var3, var4);
      }

      this.nsl();
      this.nty();
      this.npx = null;
      this.npy = null;
      this.npz = null;
      this.nqe = 0L;
      this.nql = null;
      this.nop = System.currentTimeMillis() + this.nqo.draw(0);
      this.nul(nmc.IDLE);
   }

   void nsd() {
      ClientPlayerEntity var1 = this.mc.player;
      if (var1.currentScreenHandler != var1.playerScreenHandler) {
         var1.closeHandledScreen();
      }
   }

   BlockHitResult nse(ClientPlayerEntity var1, float var2, float var3) {
      Vec3d var4 = var1.getEyePos();
      Vec3d var5 = Vec3d.fromPolar(var3, var2);
      Vec3d var6 = var4.add(var5.multiply(var1.getBlockInteractionRange()));
      BlockHitResult var7 = this.mc.world.raycast(new RaycastContext(var4, var6, ShapeType.OUTLINE, FluidHandling.NONE, var1));
      return var7.getType() == Type.BLOCK ? var7 : null;
   }

   void nsf() {
      GameOptions var1 = this.mc.options;
      if (var1 != null) {
         var1.useKey.setPressed(true);
         this.nqf = true;
      }
   }

   void nsg() {
      if (this.nqf) {
         this.nqf = false;
         if (this.mc.options != null && this.mc.getWindow() != null) {
            this.mc.options.useKey.setPressed(vzz.isPhysicallyDown(this.mc, this.mc.options.useKey));
         }
      }
   }

   void nsh() {
      GameOptions var1 = this.mc.options;
      if (var1 != null) {
         while (var1.attackKey.wasPressed()) {
         }

         while (var1.useKey.wasPressed()) {
         }
      }
   }

   void nsi() {
      if (!this.npm) {
         this.npm = true;
         this.npn.hold(this.mc);
      }
   }

   void nsj(ClientPlayerEntity var1) {
      if (this.nqq != var1) {
         this.nqq = var1;
         this.nqp.personalize(nsn(var1.getGameProfile().name()));
      }

      if (!this.nqr) {
         boolean var2 = pud.INSTANCE.engaged();
         float var3 = var2 ? vxr.getFloat(nnz, var1, var1.getYaw()) : var1.getYaw();
         float var4 = var2 ? vxr.getFloat(noa, var1, var1.getPitch()) : var1.getPitch();
         this.nqp.reset(var3, var4);
      }
   }

   void nsk(Vec3d var1, double var2) {
      float[] var4 = prt.calculateAngle(var1);
      this.nqp.setMouseStep(prp.step());
      this.nqp.aim(var4[0], var4[1], var2);
      pud.INSTANCE.set(this, this.nqp.getYaw(), MathHelper.clamp(this.nqp.getPitch(), -90.0F, 90.0F));
      this.nqr = true;
   }

   void nsl() {
      if (this.nqr) {
         this.nqr = false;
         this.nqs = System.currentTimeMillis();
         pud.INSTANCE.release(this.mc.player);
      }
   }

   boolean nsm() {
      return !this.nqr && pud.INSTANCE.engaged() && System.currentTimeMillis() - this.nqs > 1000L;
   }

   static long nsn(String var0) {
      long var1 = 1125899906842597L;
      if (var0 != null) {
         for (int var3 = 0; var3 < var0.length(); var3++) {
            var1 = var1 * 31L + Character.toLowerCase(var0.charAt(var3));
         }
      }

      return var1;
   }

   Vec3d nso(BlockPos var1) {
      ClientPlayerEntity var2 = this.mc.player;
      ClientWorld var3 = this.mc.world;
      Vec3d var4 = var2.getEyePos();
      Vec3d var5 = Vec3d.ofCenter(var1);
      BlockPos var6 = nss(var3, var1);
      Vec3d[] var7 = new Vec3d[]{
         var5.add(this.nqa, this.nqb, this.nqc),
         var5.add(0.0, 0.3, 0.0),
         var5.add(0.0, -0.2, 0.0),
         var5.add(0.3, 0.0, 0.0),
         var5.add(-0.3, 0.0, 0.0),
         var5.add(0.0, 0.0, 0.3),
         var5.add(0.0, 0.0, -0.3)
      };

      for (Vec3d var11 : var7) {
         BlockHitResult var12 = var3.raycast(new RaycastContext(var4, var11, ShapeType.OUTLINE, FluidHandling.NONE, var2));
         if (var12.getType() == Type.BLOCK && (var12.getBlockPos().equals(var1) || var12.getBlockPos().equals(var6))) {
            return var11;
         }
      }

      return null;
   }

   double nsp(World var1, BlockPos var2, Vec3d var3) {
      VoxelShape var4 = var1.getBlockState(var2).getOutlineShape(var1, var2);
      Box var5 = var4.isEmpty() ? new Box(var2) : var4.getBoundingBox().offset(var2);
      double var6 = Math.min(
         Math.min(Math.min(var3.x - var5.minX, var5.maxX - var3.x), Math.min(var3.y - var5.minY, var5.maxY - var3.y)),
         Math.min(var3.z - var5.minZ, var5.maxZ - var3.z)
      );
      if (var6 <= 0.02) {
         return 0.25;
      }

      double var8 = Math.max(0.5, this.mc.player.getEyePos().distanceTo(var3));
      return MathHelper.clamp(Math.toDegrees(Math.atan2(var6, var8)) * 0.55, 0.25, 4.0);
   }

   boolean nsq(World var1, BlockPos var2) {
      return var2 != null && this.npx != null ? var2.equals(this.npx) || var2.equals(nss(var1, this.npx)) : false;
   }

   static boolean nsr(World var0, BlockPos var1) {
      BlockEntity var2 = var0.getBlockEntity(var1);
      return var2 instanceof ChestBlockEntity || var2 instanceof BarrelBlockEntity;
   }

   static BlockPos nss(World var0, BlockPos var1) {
      BlockState var2 = var0.getBlockState(var1);
      return var2.getBlock() instanceof ChestBlock && var2.contains(ChestBlock.CHEST_TYPE) && var2.get(ChestBlock.CHEST_TYPE) != ChestType.SINGLE
         ? var1.offset(ChestBlock.getFacing(var2))
         : null;
   }

   static BlockPos nst(World var0, BlockPos var1) {
      BlockPos var2 = nss(var0, var1);
      return (var2 != null && var2.asLong() < var1.asLong() ? var2 : var1).toImmutable();
   }

   static boolean nsu(World var0, BlockPos var1) {
      if (!(var0.getBlockState(var1).getBlock() instanceof ChestBlock)) {
         return false;
      }

      BlockPos var2 = nss(var0, var1);
      return ChestBlock.isChestBlocked(var0, var1) || var2 != null && ChestBlock.isChestBlocked(var0, var2);
   }

   static int nsv(PlayerInventory var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         ItemStack var3 = var0.getStack(var2);
         if (!var3.isEmpty() && oqv.wantsItem(var3.getItem())) {
            var1 += var3.getCount();
         }
      }

      return var1;
   }

   static double nsw(int var0, int var1) {
      int var2 = var0 % 9 - var1 % 9;
      int var3 = var0 / 9 - var1 / 9;
      return Math.sqrt(var2 * var2 + var3 * var3);
   }

   static boolean nsx(PlayerInventory var0, ItemStack var1) {
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

   static boolean nsy(PlayerInventory var0) {
      for (int var1 = 0; var1 < 36; var1++) {
         if (var0.getStack(var1).isEmpty()) {
            return true;
         }
      }

      return false;
   }

   int nsz(List<ItemStack> var1, ItemStack var2) {
      int var3 = this.nta(var1, var2, 0);
      if (var3 <= 0) {
         var3 = this.nta(var1, var2, 1);
      }

      if (var3 <= 0 && ntk(var2).isEmpty()) {
         var3 = this.nta(var1, var2, 2);
      }

      return var3;
   }

   int nta(List<ItemStack> var1, ItemStack var2, int var3) {
      int var4 = Math.max(0, var1.size() - 36);
      String var5 = nto(this.mc.player.getGameProfile().name());
      Map var6 = ntk(var2);
      ArrayList var7 = new ArrayList();

      for (int var8 = 0; var8 < var4; var8++) {
         ItemStack var9 = (ItemStack)var1.get(var8);
         if (var9 != null && !var9.isEmpty() && this.ntb(var9, var2, var6, var3)) {
            int var10 = nte(ntn(var9), var5);
            if (var10 > 0) {
               var7.add(Math.max(1, var10 / Math.max(1, var9.getCount())));
            }
         }
      }

      if (var7.isEmpty()) {
         return -1;
      }

      Collections.sort(var7);
      int var11 = (Integer)var7.get(Math.min(2, var7.size() - 1));

      for (int var13 : var7) {
         if (var13 >= var11 * 0.75) {
            return var13;
         }
      }

      return var11;
   }

   boolean ntb(ItemStack var1, ItemStack var2, Map<String, Integer> var3, int var4) {
      if (var1.getItem() != var2.getItem()) {
         return false;
      }

      String var5 = cleanQuery(var1.getName().getString());
      String var6 = cleanQuery(var2.getName().getString());
      if (var5.isEmpty() || var6.isEmpty()) {
         return false;
      }

      if (!var5.equals(var6) && !var5.contains(var6) && !var6.contains(var5)) {
         return false;
      }

      if (var4 == 2) {
         return true;
      }

      Map var7 = ntk(var1);
      return var4 != 0 ? ntd(var3, var7) >= this.nod.get() / 100.0 : var3.equals(var7) && ntc(var1, var2);
   }

   static boolean ntc(ItemStack var0, ItemStack var1) {
      List var2 = ntn(var1);
      if (var2.size() <= 1) {
         return true;
      }

      List var3 = ntn(var0);

      for (int var4 = 1; var4 < var2.size(); var4++) {
         String var5 = (String)var2.get(var4);
         if (!var5.isEmpty() && !var3.contains(var5)) {
            return false;
         }
      }

      return true;
   }

   static double ntd(Map<String, Integer> var0, Map<String, Integer> var1) {
      if (var0.isEmpty() && var1.isEmpty()) {
         return 1.0;
      }

      if (!var0.isEmpty() && !var1.isEmpty()) {
         double var2 = 0.0;

         for (Entry var5 : var0.entrySet()) {
            Integer var6 = (Integer)var1.get(var5.getKey());
            if (var6 != null) {
               var2 += var6.equals(var5.getValue()) ? 1.0 : 0.6;
            }
         }

         return var2 / Math.max(var0.size(), var1.size());
      } else {
         return 0.0;
      }
   }

   static int nte(List<String> var0, String var1) {
      int var2 = -1;
      int var3 = 0;

      while (var3 < var0.size()) {
         String var4 = (String)var0.get(var3);
         if (!var4.contains(a.c(1345326780, "\u0af6獂吝枓\uec3e滤킠奖윈䷈쩫と뺱")) && !var4.contains(a.b("ⳕ啬\udbaa䇋쨖䳟\uf68d缏\ue15b", 921118945))) {
            if (var1.isEmpty() || !var4.contains(var1) || !var4.contains(a.b("ج翢\uf54f欴\ue0e7晔", 1765999125)) && !var4.contains(a.b("簽օ轝ᄨ髾᱁", 1628272649))) {
               if (var2 <= 0 && var3 != 0) {
                  int var5 = var4.indexOf(a.d("\u1ad5挗\ue9cc", 1494807297, 936308113));
                  if (var5 < 0) {
                     var5 = var4.indexOf(a.c(-1565491635, "縸ދ赃ጸ飩"));
                  }

                  if (var5 < 0) {
                     var5 = var4.indexOf(36);
                  }

                  if (var5 >= 0) {
                     int var6 = var4.indexOf(58, var5);
                     var2 = ntf(var4, var6 >= 0 ? var6 + 1 : var5);
                  }
               }

               var3++;
               continue;
            }

            return -1;
         }

         return -1;
      }

      return var2;
   }

   static int ntf(String var0, int var1) {
      long var2 = 0L;
      boolean var4 = false;

      for (int var5 = var1; var5 < var0.length(); var5++) {
         char var6 = var0.charAt(var5);
         if (var6 >= '0' && var6 <= '9') {
            var2 = var2 * 10L + (var6 - '0');
            if (var2 > 2147483647L) {
               return -1;
            }

            var4 = true;
         } else if (var4 && !ntg(var6)) {
            break;
         }
      }

      return var4 && var2 > 0L ? (int)var2 : -1;
   }

   static boolean ntg(char var0) {
      return var0 == ' ' || var0 == ',' || var0 == '.' || var0 == 160 || var0 == 8239;
   }

   static long nth(long var0) {
      long var2 = var0;

      for (long var4 = 10L; var4 <= 10000L && var0 / var4 >= 10L; var4 *= 10L) {
         long var6 = (var0 + 1L) / var4 * var4 - 1L;
         if (var6 <= 0L || var0 - var6 > Math.max(1L, var0 / 20L)) {
            break;
         }

         var2 = var6;
      }

      return var2;
   }

   static String nti(ItemStack var0) {
      return String.valueOf(var0.getItem()) + '|' + nto(var0.getName().getString()) + '|' + ntm(var0);
   }

   static boolean ntj(ItemStack var0, ItemStack var1) {
      return var0 != null && var1 != null && !var0.isEmpty() && !var1.isEmpty() ? var0.getItem() == var1.getItem() && nti(var0).equals(nti(var1)) : false;
   }

   static Map<String, Integer> ntk(ItemStack var0) {
      TreeMap var1 = new TreeMap();
      if (var0 != null && !var0.isEmpty()) {
         try {
            ntl(var0.get(DataComponentTypes.ENCHANTMENTS), var1);
            ntl(var0.get(DataComponentTypes.STORED_ENCHANTMENTS), var1);
         } catch (Throwable var3) {
         }

         return var1;
      } else {
         return var1;
      }
   }

   static void ntl(ItemEnchantmentsComponent var0, Map<String, Integer> var1) {
      if (var0 != null && !var0.isEmpty()) {
         for (RegistryEntry var3 : var0.getEnchantments()) {
            String var4 = var3.getKey().map(var0x -> var0x.getValue().getPath()).orElse("");
            if (!var4.isEmpty()) {
               var1.put(var4, var0.getLevel(var3));
            }
         }
      }
   }

   static String ntm(ItemStack var0) {
      StringBuilder var1 = new StringBuilder();

      for (Entry var3 : ntk(var0).entrySet()) {
         var1.append((String)var3.getKey()).append(var3.getValue()).append(',');
      }

      return var1.toString();
   }

   static List<String> ntn(ItemStack var0) {
      ArrayList var1 = new ArrayList();

      try {
         var1.add(nto(var0.getName().getString()));
         LoreComponent var2 = var0.get(DataComponentTypes.LORE);
         if (var2 != null) {
            for (Text var4 : var2.lines()) {
               if (var4 != null) {
                  var1.add(nto(var4.getString()));
               }
            }
         }
      } catch (Throwable var5) {
      }

      return var1;
   }

   static String nto(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (var3 == 167) {
               var2++;
            } else {
               var1.append(Character.toLowerCase(var3));
            }
         }

         return var1.toString().trim();
      } else {
         return "";
      }
   }

   static String cleanQuery(String var0) {
      if (var0 == null) {
         return "";
      }

      StringBuilder var1 = new StringBuilder(var0.length());
      boolean var2 = false;

      for (int var3 = 0; var3 < var0.length(); var3++) {
         char var4 = var0.charAt(var3);
         if (var4 == 167) {
            var3++;
         } else if (Character.isLetterOrDigit(var4)) {
            if (var2 && var1.length() > 0) {
               var1.append(' ');
            }

            var2 = false;
            var1.append(Character.toLowerCase(var4));
         } else {
            var2 = true;
         }
      }

      return var1.toString().trim();
   }

   static boolean ntp(String var0) {
      String var1 = pfl.title(var0);
      return var1.contains(a.d("\udb1bꊯ⠌뙰㶢묐ŀ裀", 1287447561, -1156564129)) && ntq(var1, nmv);
   }

   static boolean ntq(String var0, String[] var1) {
      for (String var5 : var1) {
         if (var0.contains(var5)) {
            return true;
         }
      }

      return false;
   }

   int ntr() {
      PlayerInventory var1 = this.mc.player.getInventory();
      int var2 = -1;
      int var3 = 0;

      for (int var4 = 0; var4 < 36; var4++) {
         if (this.nqx(var4)) {
            ItemStack var5 = var1.getStack(var4);
            if (ntj(var5, this.noy) && var5.getCount() > var3) {
               var3 = var5.getCount();
               var2 = var4;
            }
         }
      }

      return var2;
   }

   int nts() {
      PlayerInventory var1 = this.mc.player.getInventory();
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         if (this.nqx(var3)) {
            ItemStack var4 = var1.getStack(var3);
            if (ntj(var4, this.noy)) {
               var2 += var4.getCount();
            }
         }
      }

      return var2;
   }

   int ntt() {
      if (this.npi >= 0) {
         return this.npi;
      }

      PlayerInventory var1 = this.mc.player.getInventory();
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < 9; var3++) {
         if (var1.getStack(var3).isEmpty()) {
            var2.add(var3);
         }
      }

      return var2.isEmpty() ? var1.getSelectedSlot() : (Integer)var2.get(ThreadLocalRandom.current().nextInt(var2.size()));
   }

   static int ntu(int var0) {
      return var0 < 9 ? 36 + var0 : var0;
   }

   boolean ntv() {
      Screen var1 = this.mc.currentScreen;
      if (var1 == null) {
         return false;
      }

      if (!(var1 instanceof HandledScreen)) {
         this.noi = System.currentTimeMillis();
         return true;
      }

      if (this.nub()) {
         this.mc.player.closeHandledScreen();
         this.nok = Math.max(this.nok, System.currentTimeMillis() + nuf());
      }

      return true;
   }

   boolean ntw() {
      ClientPlayerEntity var1 = this.mc.player;
      return var1.currentScreenHandler != var1.playerScreenHandler ? false : this.ntx();
   }

   boolean ntx() {
      if (!this.nqr && (!pud.INSTANCE.engaged() || System.currentTimeMillis() - this.nqs >= 1000L)) {
         if (!this.nub()) {
            return false;
         } else if (!this.npm) {
            this.npm = true;
            return false;
         } else {
            return vyn.serverIdle(this.mc.player);
         }
      } else {
         return false;
      }
   }

   void nty() {
      if (this.npm) {
         this.npn.release(this.mc);
         this.npm = false;
      }
   }

   void ntz(int var1, SlotActionType var2, int var3) {
      ClientPlayerEntity var4 = this.mc.player;
      if (var4 != null && this.mc.interactionManager != null) {
         ScreenHandler var5 = var4.currentScreenHandler;
         if (var5 != null && var1 >= 0 && var1 < var5.slots.size()) {
            this.mc.interactionManager.clickSlot(var5.syncId, var1, var3, var2, var4);
            this.noj = System.currentTimeMillis() + this.nuc();
         }
      }
   }

   void nua(String var1) {
      if (this.mc.getNetworkHandler() != null) {
         this.mc.getNetworkHandler().sendChatCommand(var1);
         long var2 = System.currentTimeMillis();
         this.noo = var2;
         this.nol = var2;
         this.nom = -1L;
      }
   }

   boolean nub() {
      long var1 = System.currentTimeMillis();
      if (var1 < this.noj) {
         return false;
      }

      this.noj = var1 + this.nuc();
      return true;
   }

   long nuc() {
      double var1 = nui(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.22, 0.72, 1.8);
      long var3 = (long)(110.0 * var1);
      if (ThreadLocalRandom.current().nextInt(100) < 6) {
         var3 += ThreadLocalRandom.current().nextLong(140L, 520L);
      }

      return var3 + ThreadLocalRandom.current().nextLong(10L, 60L);
   }

   boolean nud(long var1, int var3) {
      if (this.nom < 0L || this.non != var3) {
         this.nom = this.nue(var3);
         this.non = var3;
      }

      if (var1 < Math.max(this.nok, this.nol + this.nom)) {
         this.noi = var1;
         return false;
      }

      long var4 = var3 == 1 ? var1 : pdi.nextFree(var3, this.nof.getInt(), var1);
      if (var4 <= var1) {
         return true;
      }

      this.nok = var4 + nuh(900L, 0.6, 150L, 5000L);
      this.noi = var1;
      if (this.nok - var1 > 5000L && var1 - this.nos > 20000L) {
         this.nos = var1;
         this.nun(
            wap.s(a.c(1169371817, "㋿䭺솿忙퐓劤\ue8f6慉ｚ痮\uf239ࡌ蚆Ὧ锰᎖ꧏ☖벸㫴댄쥜䞨"), a.d("Ჲ攠\ueff7熂隷磼욿伽턛寖\udc7b☌꣘ㅤ뼫㧖螏\u085c銘Ⴊ", -188180244, 2072543313))
               + (this.nok - var1 + 999L) / 1000L
               + wap.s(a.d("䴅㓧", -192273514, -1680970063), a.c(1990481409, "嘣⯳")),
            false
         );
      }

      return false;
   }

   long nue(int var1) {
      if (var1 == 1) {
         return this.nqo.draw(3, 1.4);
      }

      double var2 = 60000.0 / pdi.limit(this.nof.getInt());
      return this.nqo.draw(4, var2 * 0.75 / 1500.0);
   }

   static long nuf() {
      return nuh(850L, 0.35, 450L, 3000L);
   }

   static int nug() {
      return 14 + ThreadLocalRandom.current().nextInt(11);
   }

   static long nuh(long var0, double var2, long var4, long var6) {
      ThreadLocalRandom var8 = ThreadLocalRandom.current();
      long var9 = var0;

      for (int var11 = 0; var11 < 12; var11++) {
         var9 = Math.round(var0 * Math.exp(var2 * var8.nextGaussian()));
         if (var9 >= var4 && var9 <= var6) {
            return var9;
         }
      }

      return Math.max(var4, Math.min(var6, var9));
   }

   static double nui(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }

   boolean nuj() {
      this.npu = 0;
      this.npq = false;
      if (pdi.warn() >= 2) {
         this.nun(
            wap.s(a.c(416269799, "양발㛂ꣶ⍲ꗕᾑ除ࠨ芎ԏＷ燺\ue818戈\ue4ef庡텰䯞춈䑶㹠낇⭊괸➬鹜ခ諴ಥ蜚秄\uf381橧"), a.d("\ue62d龈ᔮ謭ý蘹㠊떛⮱ꄃ⛓\udcd5噠쯋䆜읯紬\uf2f0桊\uee64", -984449545, -1005215761)),
            false
         );
         this.nra();
         return false;
      } else {
         long var1 = System.currentTimeMillis();
         long var3 = nuh(25000L, 0.25, 15000L, 45000L);
         this.nok = Math.max(this.nok, var1 + var3);
         this.nun(
            wap.s(
                  a.b("\uf68e較ם鯩ၭ雊Ⲏꕻ㬷놑㘐찠䋥\udb4c儇\ud7a5涾\ue274碈ﺊ睢ര莛\u181d鸦ᓼ굗⌟릪㿷됔䫔삏奸\udf3d嗉", 1915483902),
                  a.b("⫃卦\ud9c0䟃찓䫗\uf4e4礊\ue72a淥\uea49၁黬̿走ஈ뇆㸘꒥⋼ꬋ텒忡쀩䙚좔焨＊斉\ue3df汼", 2010328829)
               )
               + (var3 + 999L) / 1000L
               + wap.s(a.d("懈ᠪ", 1842313224, 1533352418), a.d("㚋䭛", 1788216682, 392115139)),
            false
         );
         this.noi = var1;
         return true;
      }
   }

   void nuk() {
      String var1 = this.npv;
      String var2 = var1.isEmpty()
         ? wap.s(a.c(-1614400983, "㉮䯣섽弉풟刺\ue87f憙ￛ畬\uf2beࢁ蘄ᾢ闲ጐ\ua959⚞밬"), a.d("\ue3f6騔Ⴞ躳Ԛ莭㧽됑⹐꒝⌶\ud94d垝츫䑳", -555690841, 1592210254))
         : wap.s(a.c(728468998, "蹇\uf7ca純\ue320梶\uee13呖\uddb0䏲쥅亗뒨㨭ꎋ⧛꼹ᕰ骷\u0005蘊\u0fe7"), a.c(-1551906289, "츎러㵆ꍋ⣢깕ᐅ駩Ψ襥໎\uf4b5穥\ue3d3榋\ueb7b儮")) + var1;
      if (++this.not >= 3) {
         this.nun(var2, false);
         this.nra();
      } else {
         this.nqz(var2, false, true);
      }
   }

   void nul(nmc var1) {
      if (this.noh != var1) {
         this.noh = var1;
         this.noi = System.currentTimeMillis();
         this.npp = 0L;
      }
   }

   void num() {
      this.nty();
      this.nsg();
      this.nsl();
      this.npx = null;
      this.npy = null;
      this.npz = null;
      this.nqe = 0L;
      this.nql = null;
      Arrays.fill(this.nqm, false);
      this.noh = nmc.IDLE;
      this.noi = 0L;
      this.npp = 0L;
      this.nph = false;
      this.npq = false;
      this.npu = 0;
      this.npv = "";
      this.noy = ItemStack.EMPTY;
      this.noz = "";
      this.npa = "";
      this.npd = -1;
      this.npf = 0;
      this.not = 0;
      this.nou = 0L;
      this.nox = false;
      this.npe = 0;
      this.npi = -1;
      this.npj = -1;
      this.npk = -1;
      this.npl = -1;
   }

   void nun(String var1, boolean var2) {
      System.out.println(a.c(1288341737, "袢\uf127篵\ue59f湴\ue8f3助\udb58䕑쿺") + var1);
      izx.alert(this.getName(), var1, var2 ? vhz.CHECK : vhz.INFO, var2);
   }
}
