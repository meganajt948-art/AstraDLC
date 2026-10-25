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

public class lxy extends kfe {
   static final String lxz = a.d("杌Ỵ鑯੍膌ܹ뵹㒙\uaacd‴", 1025040403, -1585936588);
   static final String lya = a.d("劵⬍ꆖ㾴둵㋍袞ģ", 793634717, 1010283841);
   static final String lyb = a.b("\uebeb鉓", 891743112);
   static final String lyc = a.b("旖ᱢ雁ࢽ药ם뾍㘍", -2046140005);
   static final String lyd = a.b("倈⦳ꌕ㴑뛁〉詐\u03a2鶏\u173c", -1372171203);
   static final String lye = a.d("Փ粑\uf63b栶\ue39f攨\udf78", -1718409316, 1489970936);
   static final String lyf = a.c(-1257960822, "\u0ecf眍\ufdd6");
   static final String lyg = a.c(-1895021466, "䐓㶠띨⤓ꋂ");
   static final String lyh = a.d("৷灃\ufaec撒\uef3f淥펡婗쐉仉쥪㍩붰", 1224290199, 461709866);
   static final String lyi = a.b("搙ᶠ鍦इ苚Г빁㟃ꦗ", 1064263725);
   static final String lyj = a.c(1552414078, "\uf147袉Ȥ鱟ឌ鄿");
   static final String lyk = a.b("퍣ꫛ 빶㖠댟", -382085289);
   static final String[] lyl = new String[]{
      a.c(-1924747583, "꫱퍈嶎잝䰸쪃瓊浪朏\uedb4橤逗Ế"),
      a.b("眏ໄ萔ᨕ醰ᜅ굔₹뫷〼럥䶗썂媍", -626035904),
      a.d("เ瞋ﵛ捚\ue8ff湊퐛姶쏎䤈캪㓘멳", 1368783221, 1377301369),
      a.d("⭀勰\ud829䙒춍䬾\uf161", -1323141539, 310860069),
      a.c(-265067277, "撘ᴥ韶\u0984艛ӡ뺪㝂")
   };
   static final String[] lym = new String[]{
      a.c(912144230, "㍜䫥쐣幏햕匭\ue973"),
      a.d("㽠䛙젟刏\ud9da彡\ue54e泋\uf297硖", 1694755342, -455552679),
      a.b("嫅⍼꧘㏋밃㫍胫छ靌ᷴ驐", 208690931),
      a.d("甧ಕ虂ᠷ鎚", 537823451, 1252129218),
      a.d("戻ᮂ酟ཙ蓵ȼ", 1152379486, -126579618),
      a.b("㸭䞛쵇卉\ud8eb带", -926270948),
      a.c(1718523507, "鉂\uebfb愩ｒ瓺\uf248䡩쇪忉픁动\ua8da"),
      a.d("葹ﷀ猆\ue912抲\ue401帠힣䧹쌿", 244438447, 1824740833),
      a.c(-700573290, "᷐搛\ueecb烊ﭯ線잋"),
      a.b("뙡쾦䔅\udb7d傡", 1438167642),
      a.c(1863938643, "癩࿐脖ᬄ邤ᘑ걉")
   };
   static final String[] lyn = new String[]{a.c(-1364565997, "搪ᷤ靄ह苡џ븆"), a.b("鎳\uea72惔ﺭ畳", 443258758)};
   static final int lyo = 36;
   static final double lyp = 0.75;
   static final long lyq = 180000L;
   static final long lyr = 120000L;
   static final long lys = 110L;
   static final long lyt = 360L;
   static final long lyu = 260L;
   static final long lyv = 4000L;
   static final long lyw = 4000L;
   static final long lyx = 20000L;
   static final long lyy = 850L;
   static final long lyz = 900L;
   static final long lza = 3500L;
   static final double lzb = 1.4;
   static final double lzc = 1500.0;
   static final double lzd = 0.75;
   static final long lze = 25000L;
   static final int lzf = 3;
   static final long lzg = 60000L;
   static final long lzh = 380L;
   static final double lzi = 4.3;
   static final long lzj = 60000L;
   static final long lzk = 1500L;
   static final long lzl = 3000L;
   static final int lzm = 64;
   static final int lzn = 0;
   static final int lzo = 1;
   static final int lzp = 2;
   static final int lzq = 3;
   static final Field lzr = vxr.find(
      ClientPlayerEntity.class,
      a.b("\uf3fa詀\u0082麩ᔽ鎈⧜ꀦ㹿듟㌟쥩䞬\ude47呙튧棥\ue726綕ﯨ牷ࠥ蚔", 292615043),
      a.d("侐㘮볱⊉\ua956\u2fdc闣ᰘ艊ࣾ", -322140526, 200591726),
      a.d("작", -586597637, 1165032749)
   );
   static final Field lzs = vxr.find(
      ClientPlayerEntity.class,
      a.b("ӂ絸\uf7ba榑\ue205撰\udee4圞쥇䏧쐧㹑낔⥿ꍡ▟鿝သ読\u0cd0蕏＝熬", -486800197),
      a.d("ѹ緇\uf718楠\ue2bf搵\ude0a埱즥䌓", 1233053955, 1001188630),
      a.d("喕", 763871993, 1915655979)
   );
   static lxy lzt;
   final vmc lzu = this.add(new vmc(a.d("\u0b0d犙\uf844昶\ue9f4欥텽壺욢䰙", -1088202757, 891771105), 5.0, 1.0, 50.0, 1.0).suffix(a.b("ᆔ", -1548021328)));
   final vmc lzv = this.add(new vmc(a.b("ᤔ惁\uea69琐ￄ礁썑䪮킝幋\ud9ef⏮", -1470816967), 60.0, 0.0, 100.0, 5.0).suffix(a.b("匈", -1754901716)));
   final vkl lzw = this.add(new vkl(a.b("䶃㐩뺆₄ꭒⶓ鎠ḳ耐\u0aa9赹", 1568098733), false));
   final vmc lzx = this.add(new vmc(a.c(217379286, "\uf5d9豉ڜ颔ጸ閍⿒ꈱ㡼뛟㔐콥䆷\ud878刪퓚"), 20.0, 4.0, 40.0, 1.0));
   final vkl lzy = this.add(new vkl(a.b("醅\ue81b曟ﳏ眚\uf1d5䮏숉尯횚充", -1980983914), true));
   lxu lzz = lxu.IDLE;
   long maa;
   long mab;
   long mac;
   long mad;
   long mae = -1L;
   int maf = 0;
   long mag;
   long mah;
   long mai = 360L;
   long maj;
   long mak;
   int mal;
   long mam;
   int man;
   int mao = 8;
   boolean map;
   ItemStack maq = ItemStack.EMPTY;
   String mar = "";
   String mas = "";
   final Set<String> mat = new HashSet<>();
   final Map<String, long[]> mau = new HashMap<>();
   int mav = -1;
   int maw;
   int max;
   long may;
   boolean maz;
   int mba = -1;
   int mbb = -1;
   int mbc = -1;
   int mbd = -1;
   boolean mbe;
   final vyn mbf = new vyn();
   long mbg;
   long mbh;
   boolean mbi;
   int mbj = -1;
   int mbk = -1;
   long mbl;
   int mbm = 0;
   String mbn = "";
   final Map<BlockPos, Long> mbo = new HashMap<>();
   BlockPos mbp;
   BlockPos mbq;
   Vec3d mbr;
   double mbs;
   double mbt;
   double mbu;
   int mbv;
   long mbw;
   boolean mbx;
   int mby;
   int mbz;
   int mca;
   int mcb = -1;
   int mcc = -1;
   ItemStack[] mcd;
   final boolean[] mce = new boolean[9];
   boolean mcf;
   final pgi mcg = new pgi();
   final pjw mch = new pjw();
   ClientPlayerEntity mci;
   boolean mcj;
   long mck;

   public lxy() {
      super(
         a.c(-9870285, "摻᷾霻ॡ芛У빬㞈꧀"),
         a.b("橓Ꮤ餎ݿ買\u0a55끒㦿\ua7edⴙꪃ僵\ude3a䞘췀䬫\uf17f纳\ue40b戃\uebbb釫\u1f16蒓˰蠬㇚뿊┩ꍮ⣊혆屏얿䎢쥆皊ﳱ稣\ue385榈ᜭ鵢\u1ade职\u0e70랯㴍뭛₄껦呣\udd96寜셶佮\uf4cc爚\uf87f憧\uef1a", 559311421),
         kfa.PLAYER
      );
      lzt = this;
   }

   public static void onMessage(Text var0) {
      lxy var1 = lzt;
      if (var1 != null && var1.isEnabled()) {
         var1.mcn(var0);
      }
   }

   @Override
   protected void onEnable() {
      this.mge();
      this.mat.clear();
      this.mbo.clear();
      this.mcf = false;
      this.mcg.reset();
      this.man = 0;
      this.mao = mfy();
      this.mbd = this.mc.player == null ? -1 : this.mc.player.getInventory().getSelectedSlot();
      long var1 = System.currentTimeMillis();
      this.mau.values().removeIf(var2 -> var1 - var2[1] > 180000L);
      this.mah = var1 + 260L + ThreadLocalRandom.current().nextLong(0L, 340L);
      this.mac = Math.max(this.mac, var1 + mfx());
   }

   @Override
   protected void onDisable() {
      this.mge();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.mdy();
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.getNetworkHandler() != null) {
         if (this.mbe) {
            this.mbf.hold(var1);
         }

         if (this.mcj && this.lzz == lxu.CHEST_OPEN) {
            this.mdz();
         }

         if (this.lzz == lxu.IDLE) {
            Screen var3 = var1.currentScreen;
            if (var3 == null || var3 instanceof HandledScreen) {
               if (System.currentTimeMillis() >= this.mah) {
                  if (!this.mco() && !this.mdo()) {
                     this.mcs();
                  }
               }
            }
         } else if (this.lzz.lxv > 0L && System.currentTimeMillis() - this.maa > this.lzz.lxv) {
            if (this.lzz == lxu.RESTORE) {
               this.mdd();
            } else if (this.lzz == lxu.CHEST_OPEN) {
               this.mdu(System.currentTimeMillis() + 60000L, a.d("\uda67ꎴ⤙띡㳁먉р覬\u17fb饟᪒\ue09f渰\uf7fb綣ﬢ䄗컈", 1128114533, -791644367), false, 0);
            } else if (this.lzz == lxu.CHEST_LOOT) {
               this.mdv();
               this.mdu(0L, null, true, 2);
            } else if (this.mdk()) {
               this.mgf(a.c(-1846086968, "\uf6fb輯\u058c鯰ဢ隐Ⳁꕀ㭣뗇㘉챰䚲\udb1d儲ힻ涎\ue254碗ﻃ睋ഗ"), false);
               this.mdj();
            } else {
               this.mcr(a.d("蘐\ufff2畘\ueb55惼\ue64b尛퇷䮴섇䛑볜㉴ꮿ▔ꍿ", 1542086463, -987898577) + this.mas, false, true);
            }
         } else {
            switch (this.lzz) {
               case TAKE:
                  this.mct();
                  break;
               case SEARCH:
                  this.mcu();
                  break;
               case SCAN:
                  this.mcv();
                  break;
               case SEND:
                  this.mda();
                  break;
               case CONFIRM:
                  this.mdb();
                  break;
               case RESTORE:
                  this.mdc();
                  break;
               case FULL_WAIT:
                  this.mdf();
                  break;
               case AH_OPEN:
                  this.mdg();
                  break;
               case AH_STORAGE:
                  this.mdh();
                  break;
               case AH_RELIST:
                  this.mdi();
                  break;
               case CHEST_OPEN:
                  this.mdq();
                  break;
               case CHEST_LOOT:
                  this.mdt();
            }
         }
      } else {
         if (this.lzz != lxu.IDLE) {
            this.mge();
         }
      }
   }

   void mcn(Text var1) {
      if (this.lzz != lxu.IDLE && !this.mdk() && System.currentTimeMillis() - this.mag <= 4000L) {
         String var2 = mfg(var1.getString());
         if (!var2.isEmpty()) {
            if (mfh(var2)) {
               this.mbm = 3;
            } else if (mfi(var2, lyl)) {
               this.mbm = 1;
            } else if (mfi(var2, lym)) {
               this.mbn = var2.length() > 48 ? var2.substring(0, 48) : var2;
               this.mbm = 2;
            }
         }
      }
   }

   boolean mco() {
      PlayerInventory var1 = this.mc.player.getInventory();

      for (int var2 = 0; var2 < 2; var2++) {
         int var3 = var2 == 0 ? 9 : 0;
         int var4 = var2 == 0 ? 36 : 9;

         for (int var5 = var3; var5 < var4; var5++) {
            if (this.mcp(var5)) {
               ItemStack var6 = var1.getStack(var5);
               if (!var6.isEmpty()) {
                  String var7 = mfa(var6);
                  if (!this.mat.contains(var7)) {
                     String var8 = cleanQuery(var6.getName().getString());
                     if (!var8.isEmpty()) {
                        this.maq = var6.copy();
                        this.mar = var7;
                        this.mas = var8;
                        this.mav = -1;
                        this.max = 0;
                        this.mbm = 0;
                        this.mbn = "";
                        this.mbi = false;
                        this.mai = 360L + ThreadLocalRandom.current().nextLong(0L, 260L);
                        this.mgf(a.b("ᣢ愌\ueba1痚︉磆웡伊", 1441668341) + this.mas, true);
                        this.mgd(lxu.TAKE);
                        return true;
                     }

                     this.mat.add(var7);
                  }
               }
            }
         }
      }

      return false;
   }

   boolean mcp(int var1) {
      if (var1 == this.mbc) {
         return false;
      } else {
         return var1 >= 9 ? true : this.lzw.get() || var1 == this.mba || this.mcq(var1);
      }
   }

   boolean mcq(int var1) {
      if (!this.mce[var1]) {
         return false;
      } else if (this.mc.player.getInventory().getStack(var1).isEmpty()) {
         this.mce[var1] = false;
         return false;
      } else {
         return true;
      }
   }

   void mcr(String var1, boolean var2, boolean var3) {
      if (var3 && !this.mar.isEmpty()) {
         this.mat.add(this.mar);
      }

      if (var1 != null) {
         long var4 = System.currentTimeMillis();
         if (var2 || var4 - this.maj > 4000L) {
            if (!var2) {
               this.maj = var4;
            }

            this.mgf(var1, var2);
         }
      }

      this.mbi = false;
      this.mav = -1;
      this.max = 0;
      this.mbm = 0;
      this.mbn = "";
      this.maq = ItemStack.EMPTY;
      this.mar = "";
      this.mas = "";
      this.mfq();
      this.mah = System.currentTimeMillis() + 260L + ThreadLocalRandom.current().nextLong(0L, 300L);
      this.mgd(lxu.IDLE);
   }

   void mcs() {
      this.mgf(
         this.maw > 0 ? a.b("뤳삯䨀퐍忖\ud96b未\ueed7璓︧禈莅൞郧\u1aae", 864337199) + this.maw : a.d("₋奥폈䶳왠䃓廒猁\ued50掍\ue043ᨺ钟൜蜉ǵ", 1245273134, -1888978774), this.maw > 0
      );
      this.maz = true;
      this.mgd(lxu.RESTORE);
   }

   void mct() {
      if (!this.mfn()) {
         PlayerInventory var1 = this.mc.player.getInventory();
         if (this.mcp(var1.getSelectedSlot()) && mfb(this.mc.player.getMainHandStack(), this.maq)) {
            this.mfq();
            this.mgd(lxu.SEARCH);
         } else {
            int var2 = this.mfj();
            if (var2 < 0) {
               this.mcr(null, true, false);
            } else if (var2 < 9) {
               this.mfq();
               if (this.mft()) {
                  var1.setSelectedSlot(var2);
                  this.mgd(lxu.SEARCH);
               }
            } else if (this.mfo()) {
               int var3 = this.mfl();
               boolean var4 = !var1.getStack(var3).isEmpty();
               this.mfr(mfm(var2), SlotActionType.SWAP, var3);
               this.mba = var3;
               if (var4 && this.mbb < 0) {
                  this.mbb = var3;
                  this.mbc = var2;
               }
            }
         }
      }
   }

   void mcu() {
      this.mfq();
      if (!this.mfn()) {
         String var1 = cleanQuery(this.mc.player.getMainHandStack().getName().getString());
         if (!var1.isEmpty()) {
            this.mas = var1;
         }

         long var2 = System.currentTimeMillis();
         long[] var4 = this.mcz(this.mar, var2, 180000L);
         if (var4 != null) {
            if (var4[0] > 0L) {
               this.mgd(lxu.SEND);
            } else {
               this.mcr(a.c(-1407915681, "\ued48铑ṵ葦ௗ贕㝎뻉ⓧ까") + this.mas, false, true);
            }
         } else if (this.mfv(var2, 0)) {
            this.mbi = true;
            this.mbk = -1;
            this.mbl = 0L;
            this.mbj = this.mc.player.currentScreenHandler == null ? -1 : this.mc.player.currentScreenHandler.syncId;
            this.mbm = 0;
            this.mfs(a.b("拹ᭁ釚\u0ff8萹ʌ료ㄬ꽸▁", -1304665454) + this.mas);
            this.mgd(lxu.SCAN);
         }
      }
   }

   void mcv() {
      this.mfq();
      if (this.mbm == 3) {
         this.mde();
      } else if (this.mbm == 2) {
         this.mgc();
      } else if (this.mbm == 1) {
         if (this.mgb()) {
            this.mgd(lxu.SEARCH);
         }
      } else {
         List var1 = this.mcw();
         if (var1 != null) {
            long var2 = System.currentTimeMillis();
            if (var2 - this.mbl >= this.mai) {
               this.mbi = false;
               this.mcx(var1, var2);
               long[] var4 = this.mcz(this.mar, var2, 180000L);
               if (var4 != null && var4[0] > 0L) {
                  this.mam = var2 + mfz(900L, 0.45, 350L, 3500L);
                  this.mgd(lxu.SEND);
               } else {
                  this.mcr(a.d("紬ҵ踑ᐂ鮳ᵱꜪ⺭뒃㸨", -304598496, -199734501) + this.mas, false, true);
               }
            }
         }
      }
   }

   List<ItemStack> mcw() {
      if (this.mbi && this.mc.currentScreen instanceof HandledScreen) {
         ScreenHandler var1 = this.mc.player.currentScreenHandler;
         if (var1 instanceof GenericContainerScreenHandler && var1.syncId != this.mbj) {
            int var2 = var1.slots.size() - 36;
            boolean var3 = false;

            for (int var4 = 0; var4 < var2 && !var3; var4++) {
               var3 = !var1.slots.get(var4).getStack().isEmpty();
            }

            if (!var3) {
               return null;
            }

            if (var1.syncId != this.mbk) {
               this.mbk = var1.syncId;
               this.mbl = System.currentTimeMillis();
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

   void mcx(List<ItemStack> var1, long var2) {
      this.mcy(this.mar, this.mer(var1, this.maq), var2);
      String var4 = this.mas;
      PlayerInventory var5 = this.mc.player.getInventory();

      for (int var6 = 0; var6 < 36; var6++) {
         if (this.mcp(var6)) {
            ItemStack var7 = var5.getStack(var6);
            if (!var7.isEmpty() && var7.getItem() == this.maq.getItem()) {
               String var8 = mfa(var7);
               if (!var8.equals(this.mar) && !this.mat.contains(var8) && var4.equals(cleanQuery(var7.getName().getString()))) {
                  this.mcy(var8, this.mer(var1, var7), var2);
               }
            }
         }
      }
   }

   void mcy(String var1, int var2, long var3) {
      this.mau.put(var1, new long[]{var2 > 0 ? var2 : -1L, var3});
   }

   long[] mcz(String var1, long var2, long var4) {
      long[] var6 = this.mau.get(var1);
      return var6 != null && var2 - var6[1] < var4 ? var6 : null;
   }

   void mda() {
      this.mfq();
      long var1 = System.currentTimeMillis();
      if (var1 < this.mam && this.mc.currentScreen instanceof HandledScreen) {
         this.maa = var1;
      } else if (!this.mfn()) {
         if (this.mbm == 3) {
            this.mde();
         } else if (this.mbm == 2) {
            this.mgc();
         } else {
            long[] var3 = this.mcz(this.mar, var1, 300000L);
            if (var3 != null && var3[0] > 0L) {
               int var4 = (int)var3[0];
               ItemStack var5 = this.mc.player.getMainHandStack();
               if (!mfb(var5, this.maq)) {
                  if (++this.max > 2) {
                     this.mcr(a.c(-491171904, "䯶㉛뢄⛷교⾁重ᡃ虢\u0cd2謎煴﮸昑\uec4d溫킄彖얜䏏"), false, true);
                  } else {
                     this.mgd(lxu.TAKE);
                  }
               } else if (this.mfv(var1, 1)) {
                  int var6 = Math.max(1, var5.getCount());
                  long var7 = (long)Math.floor(var4 * (1.0 - this.lzu.get() / 100.0));
                  if (var7 >= var4) {
                     var7 = var4 - 1L;
                  }

                  this.may = mez(Math.max(1L, var7) * var6);
                  this.mav = this.mfk();
                  this.mfs(a.d("ꀨ\ud990匋촩䛨쁐稃\uf3be", -603002167, -926397816) + this.may);
                  this.mgd(lxu.CONFIRM);
               }
            } else {
               this.mgd(lxu.SEARCH);
            }
         }
      }
   }

   void mdb() {
      this.mfq();
      if (!this.mfn()) {
         if (this.mbm == 3) {
            this.mde();
         } else if (this.mbm == 1) {
            if (this.mgb()) {
               this.mgd(lxu.SEND);
            }
         } else if (this.mbm == 2) {
            this.mgc();
         } else {
            int var1 = this.mfk();
            if (this.mav >= 0 && var1 < this.mav) {
               this.maw++;
               this.mal = 0;
               this.max = 0;
               this.mav = -1;
               this.mgf(a.b("䫓㌻맢➐갵⪆郜ᤣ蝴ෆ踋灭ﺽ挜", 1747275471) + this.may, true);
               if (++this.man >= this.mao) {
                  this.man = 0;
                  this.mao = mfy();
                  this.mac = Math.max(this.mac, System.currentTimeMillis() + mfz(3500L, 0.45, 1500L, 12000L));
               }

               if (var1 > 0) {
                  this.mgd(lxu.TAKE);
               } else {
                  this.mcr(null, true, false);
               }
            }
         }
      }
   }

   void mdc() {
      if (!this.mfn()) {
         PlayerInventory var1 = this.mc.player.getInventory();
         if (this.mbb >= 0 && this.mbc >= 0) {
            boolean var2 = !var1.getStack(this.mbc).isEmpty() || !var1.getStack(this.mbb).isEmpty();
            if (var2) {
               if (!this.mfo()) {
                  return;
               }

               this.mfr(mfm(this.mbc), SlotActionType.SWAP, this.mbb);
            }

            this.mbb = -1;
            this.mbc = -1;
         } else {
            this.mfq();
            if (this.mbd >= 0 && this.mbd < 9 && var1.getSelectedSlot() != this.mbd) {
               if (!this.mft()) {
                  return;
               }

               var1.setSelectedSlot(this.mbd);
            }

            this.mdd();
         }
      }
   }

   void mdd() {
      boolean var1 = this.maz;
      this.mge();
      if (var1) {
         this.setEnabled(false);
      }
   }

   void mde() {
      this.mbm = 0;
      this.mbn = "";
      this.mav = -1;
      this.mbi = false;
      this.mfq();
      if (this.map) {
         this.mgf(a.b("棙ᅲ鮤֩蹷ಭ닥㬑ꔲ\u2fffꠠ噃\udc83䔵콫䧨\uf3aa籲\ue2a6擻\ue913錽ᷰ蘫P誃㌲봑⟨ꗕ⩻풢廢읪䅎쯻", 87387356), false);
         this.mcs();
      } else {
         long var1 = System.currentTimeMillis();
         if (var1 >= this.mbg) {
            this.mgd(lxu.AH_OPEN);
         } else {
            this.mgf(
               a.d("裄\uf110箳\ue5cf渝\ue8af勿\udb7f䕜쯸䠴뉄㲖ꔡ⽱궒៑鰟ڦ肂ऀ獖ﶜ晇\ue03b檘팩嵱쟳䗌쨘㒻뺁✅ꅔ⿲", 420682161, -1446537868)
                  + (this.mbg - var1 + 999L) / 1000L
                  + a.c(1136746110, "幜⎌"),
               false
            );
            this.mgd(lxu.FULL_WAIT);
         }
      }
   }

   void mdf() {
      if (System.currentTimeMillis() >= this.mbg) {
         this.mgd(lxu.AH_OPEN);
      }
   }

   void mdg() {
      if (!this.mfn()) {
         long var1 = System.currentTimeMillis();
         if (this.mfv(var1, 0)) {
            this.mbg = var1 + 60000L + ThreadLocalRandom.current().nextLong(400L, 4000L);
            this.map = true;
            this.mfs(a.b("\ue5a7鰟", -1435703868));
            this.mgd(lxu.AH_STORAGE);
         }
      }
   }

   void mdh() {
      int var1 = this.mdl(a.c(612614747, "옖뾢㔁ꭽ₯ꘝᱍ闍"));
      if (var1 >= 0 && this.mdn() && this.mfp()) {
         this.mfr(var1, SlotActionType.PICKUP, 0);
         pdi.note(0);
         this.mgd(lxu.AH_RELIST);
      }
   }

   void mdi() {
      int var1 = this.mdl(a.b("\u10cf楴\ue3d2緖\uf606烎쪗䍥\udd48埻", -223800070));
      if (var1 >= 0 && this.mdn() && this.mfp()) {
         int var2 = this.mdm();
         if (var2 > 0) {
            this.mfr(var1, SlotActionType.PICKUP, 0);
            pdi.note(0);
            this.mgf(a.d("\udf1dꚆⰠ눤㧴뼼ե貗ኺ頉ΐ\ue5d6欀\uf6c5粌", 1755457151, -1874920078) + var2, true);
         } else {
            this.mgf(a.b("ᔯ泻\ue658砤\uf3f6畄켔䚔\ud8b7嘓헟⿒ꄇ㢵늚㑠訶\u05eb鬹ᴒ铠\ueecd恷ￍ綥\uf773仍샮娔\udc4c厔\ua95e⌔몙㲸똅\u09d6", 1226445103), false);
         }

         this.mdj();
      }
   }

   void mdj() {
      this.mfq();
      this.mbm = 0;
      this.mbn = "";
      long var1 = System.currentTimeMillis();
      this.mag = 0L;
      this.mac = Math.max(this.mac, var1 + mfz(1600L, 0.35, 900L, 4000L));
      this.mab = var1 + 250L + ThreadLocalRandom.current().nextLong(0L, 350L);
      this.mgd(this.maq.isEmpty() ? lxu.IDLE : lxu.TAKE);
   }

   boolean mdk() {
      return this.lzz == lxu.FULL_WAIT || this.lzz == lxu.AH_OPEN || this.lzz == lxu.AH_STORAGE || this.lzz == lxu.AH_RELIST;
   }

   int mdl(String var1) {
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

   int mdm() {
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

   boolean mdn() {
      if (this.mbh != 0L) {
         return true;
      }

      long var1 = System.currentTimeMillis();
      this.mbh = var1;
      double var3 = mga(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.25, 0.7, 1.9);
      long var5 = (long)(380.0 * var3) + ThreadLocalRandom.current().nextLong(10L, 90L);
      this.mab = Math.max(this.mab, var1 + var5);
      return false;
   }

   boolean mdo() {
      if (!this.lzy.get()) {
         return false;
      }

      ClientPlayerEntity var1 = this.mc.player;
      if (!var1.hasVehicle() && meq(var1.getInventory()) && !this.mee()) {
         long var2 = System.currentTimeMillis();
         if (oqv.listEmpty()) {
            if (!this.mcf && this.mdp(var2) != null) {
               this.mcf = true;
               this.mgf(a.b("㖁䰮웺売퍚嗯\ueba6戴ﱀ盼\uf139\u0b4f薠ᰲ陡ႋ\uaad5┓뿲㶼됷칤䃔", -10079817), false);
            }

            return false;
         } else {
            ThreadLocalRandom var4 = ThreadLocalRandom.current();
            this.mbs = (var4.nextDouble() - 0.5) * 0.3;
            this.mbt = (var4.nextDouble() - 0.5) * 0.25;
            this.mbu = (var4.nextDouble() - 0.5) * 0.3;
            BlockPos var5 = this.mdp(var2);
            if (var5 == null) {
               return false;
            }

            this.mbp = var5;
            this.mbq = mel(this.mc.world, var5);
            this.mbr = this.meg(var5);
            this.mbv = 1 + var4.nextInt(4);
            this.mbw = 0L;
            this.meb(var1);
            this.mgd(lxu.CHEST_OPEN);
            return true;
         }
      } else {
         return false;
      }
   }

   BlockPos mdp(long var1) {
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
                        BlockPos var19 = mel(var3, var18);
                        Long var20 = this.mbo.get(var19);
                        if (var20 == null || var20 <= var1) {
                           int var21 = oqv.markState(var3, var18);
                           if (var21 != 1 && (var21 != 2 || var20 != null)) {
                              if (mem(var3, var18)) {
                                 this.mbo.put(var19, Long.MAX_VALUE);
                              } else {
                                 Vec3d var22 = this.meg(var18);
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

   void mdq() {
      ClientPlayerEntity var1 = this.mc.player;
      long var2 = System.currentTimeMillis();
      ClientWorld var4 = this.mc.world;
      if (this.mbw > 0L && this.mc.currentScreen instanceof HandledScreen && this.mdr(var4, var1.currentScreenHandler, var2)) {
         this.mds(var2);
      } else if (!this.mfn()) {
         if (this.mbp != null && mej(var4, this.mbp)) {
            Vec3d var5 = var1.getEyePos();
            if (this.mbr == null || var5.distanceTo(this.mbr) > 4.3) {
               this.mbr = this.meg(this.mbp);
               if (this.mbr == null || var5.distanceTo(this.mbr) > 4.3) {
                  this.mdu(var2 + 60000L, null, false, 0);
                  return;
               }
            }

            this.mea();
            float var6 = vxr.getFloat(lzr, var1, var1.getYaw());
            float var7 = vxr.getFloat(lzs, var1, var1.getPitch());
            BlockHitResult var8 = this.mdw(var1, var6, var7);
            if (var8 != null && this.mei(var4, var8.getBlockPos())) {
               if (this.mbv > 0) {
                  this.mbv--;
               } else if (var2 - this.mbw > 1500L && !var1.isSneaking() && !var1.isUsingItem() && vyn.serverIdle(var1)) {
                  this.mdx();
                  this.mbw = var2;
               }
            }

            this.mec(this.mbr, this.meh(var4, this.mbp, this.mbr));
         } else {
            this.mdu(Long.MAX_VALUE, null, false, 0);
         }
      }
   }

   boolean mdr(World var1, ScreenHandler var2, long var3) {
      if (var2 instanceof GenericContainerScreenHandler var5 && var3 - this.mbw <= 3000L && this.mbp != null) {
         int var6 = mek(var1, this.mbp) != null ? 6 : 3;
         if (var5.getRows() != var6) {
            return false;
         }

         String var7 = pfl.title(this.mc.currentScreen.getTitle().getString());
         return !var7.contains(a.b("塇ↅ\uab2f㔢뺋㠼艬", 2133023856)) && !var7.contains(a.c(-2092048698, "\uda8bꌿ⦜럠㰲몀Ð襐"));
      } else {
         return false;
      }
   }

   void mds(long var1) {
      PlayerInventory var3 = this.mc.player.getInventory();
      this.mcc = this.mc.player.currentScreenHandler.syncId;
      this.mcd = new ItemStack[9];

      for (int var4 = 0; var4 < 9; var4++) {
         this.mcd[var4] = var3.getStack(var4).copy();
      }

      this.mby = 0;
      this.mbz = 0;
      this.mcb = -1;
      this.mca = men(var3);
      this.mab = var1 + this.mcg.draw(0);
      this.mgd(lxu.CHEST_LOOT);
   }

   void mdt() {
      ClientPlayerEntity var1 = this.mc.player;
      long var2 = System.currentTimeMillis();
      ScreenHandler var4 = var1.currentScreenHandler;
      if (!(this.mc.currentScreen instanceof HandledScreen) || !(var4 instanceof GenericContainerScreenHandler) || var4.syncId != this.mcc) {
         this.mdu(var2 + 15000L, null, true, this.mbz > 0 ? 2 : 0);
      } else if (var2 >= this.mab && vyn.serverIdle(var1)) {
         PlayerInventory var5 = var1.getInventory();
         if (this.mby >= 4 && this.mby % 4 == 0 && men(var5) <= this.mca) {
            this.mdv();
            this.mdu(Long.MAX_VALUE, a.d("\ue0cc餟Ꮂ跊٪肢㻫댇ⵐꏴ‹\uda34咕촠䜒쇰翝\uf41e溪\ue887愁", 779925535, 2105564391), false, 2);
         } else {
            int var6 = var4.slots.size() - 36;
            int var7 = -1;
            double var8 = Double.MAX_VALUE;
            boolean var10 = false;

            for (int var11 = 0; var11 < var6; var11++) {
               ItemStack var12 = var4.slots.get(var11).getStack();
               if (!var12.isEmpty() && !this.mat.contains(mfa(var12)) && oqv.wantsItem(var12.getItem())) {
                  if (!mep(var5, var12)) {
                     var10 = true;
                  } else {
                     double var13 = this.mcb < 0 ? var11 * 0.01 : meo(this.mcb, var11);
                     if (var13 < var8) {
                        var8 = var13;
                        var7 = var11;
                     }
                  }
               }
            }

            if (var7 >= 0 && this.mby < 64) {
               this.mc.interactionManager.clickSlot(var4.syncId, var7, 0, SlotActionType.QUICK_MOVE, var1);
               this.mbz++;
               this.mcb = var7;
               this.mab = var2 + this.mcg.draw(this.mby++ == 0 ? 1 : 2);
            } else {
               boolean var15 = var10 || var7 >= 0;
               this.mdv();
               this.mdu(var15 ? 0L : Long.MAX_VALUE, this.mbz > 0 ? a.c(-459243703, "筝˃谇ᘗ鷂ᬍꅗ⣑뛷㱌뾕䗾") + this.mbz : null, true, var15 ? 2 : 1);
            }
         }
      }
   }

   void mdu(long var1, String var3, boolean var4, int var5) {
      if (this.mbq != null) {
         this.mbo.put(this.mbq, var1);
      }

      if (var5 != 0 && this.mbp != null) {
         oqv.markFromOutside(this.mc.world, this.mbp, var5 == 2);
      }

      if (var4 && this.mcd != null) {
         PlayerInventory var6 = this.mc.player.getInventory();

         for (int var7 = 0; var7 < 9; var7++) {
            if (this.mcd[var7].isEmpty() && !var6.getStack(var7).isEmpty()) {
               this.mce[var7] = true;
            }
         }
      }

      if (var3 != null) {
         this.mgf(var3, var4);
      }

      this.med();
      this.mfq();
      this.mbp = null;
      this.mbq = null;
      this.mbr = null;
      this.mbw = 0L;
      this.mcd = null;
      this.mah = System.currentTimeMillis() + this.mcg.draw(0);
      this.mgd(lxu.IDLE);
   }

   void mdv() {
      ClientPlayerEntity var1 = this.mc.player;
      if (var1.currentScreenHandler != var1.playerScreenHandler) {
         var1.closeHandledScreen();
      }
   }

   BlockHitResult mdw(ClientPlayerEntity var1, float var2, float var3) {
      Vec3d var4 = var1.getEyePos();
      Vec3d var5 = Vec3d.fromPolar(var3, var2);
      Vec3d var6 = var4.add(var5.multiply(var1.getBlockInteractionRange()));
      BlockHitResult var7 = this.mc.world.raycast(new RaycastContext(var4, var6, ShapeType.OUTLINE, FluidHandling.NONE, var1));
      return var7.getType() == Type.BLOCK ? var7 : null;
   }

   void mdx() {
      GameOptions var1 = this.mc.options;
      if (var1 != null) {
         var1.useKey.setPressed(true);
         this.mbx = true;
      }
   }

   void mdy() {
      if (this.mbx) {
         this.mbx = false;
         if (this.mc.options != null && this.mc.getWindow() != null) {
            this.mc.options.useKey.setPressed(vzz.isPhysicallyDown(this.mc, this.mc.options.useKey));
         }
      }
   }

   void mdz() {
      GameOptions var1 = this.mc.options;
      if (var1 != null) {
         while (var1.attackKey.wasPressed()) {
         }

         while (var1.useKey.wasPressed()) {
         }
      }
   }

   void mea() {
      if (!this.mbe) {
         this.mbe = true;
         this.mbf.hold(this.mc);
      }
   }

   void meb(ClientPlayerEntity var1) {
      if (this.mci != var1) {
         this.mci = var1;
         this.mch.personalize(mef(var1.getGameProfile().name()));
      }

      if (!this.mcj) {
         boolean var2 = pud.INSTANCE.engaged();
         float var3 = var2 ? vxr.getFloat(lzr, var1, var1.getYaw()) : var1.getYaw();
         float var4 = var2 ? vxr.getFloat(lzs, var1, var1.getPitch()) : var1.getPitch();
         this.mch.reset(var3, var4);
      }
   }

   void mec(Vec3d var1, double var2) {
      float[] var4 = prt.calculateAngle(var1);
      this.mch.setMouseStep(prp.step());
      this.mch.aim(var4[0], var4[1], var2);
      pud.INSTANCE.set(this, this.mch.getYaw(), MathHelper.clamp(this.mch.getPitch(), -90.0F, 90.0F));
      this.mcj = true;
   }

   void med() {
      if (this.mcj) {
         this.mcj = false;
         this.mck = System.currentTimeMillis();
         pud.INSTANCE.release(this.mc.player);
      }
   }

   boolean mee() {
      return !this.mcj && pud.INSTANCE.engaged() && System.currentTimeMillis() - this.mck > 1000L;
   }

   static long mef(String var0) {
      long var1 = 1125899906842597L;
      if (var0 != null) {
         for (int var3 = 0; var3 < var0.length(); var3++) {
            var1 = var1 * 31L + Character.toLowerCase(var0.charAt(var3));
         }
      }

      return var1;
   }

   Vec3d meg(BlockPos var1) {
      ClientPlayerEntity var2 = this.mc.player;
      ClientWorld var3 = this.mc.world;
      Vec3d var4 = var2.getEyePos();
      Vec3d var5 = Vec3d.ofCenter(var1);
      BlockPos var6 = mek(var3, var1);
      Vec3d[] var7 = new Vec3d[]{
         var5.add(this.mbs, this.mbt, this.mbu),
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

   double meh(World var1, BlockPos var2, Vec3d var3) {
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

   boolean mei(World var1, BlockPos var2) {
      return var2 != null && this.mbp != null ? var2.equals(this.mbp) || var2.equals(mek(var1, this.mbp)) : false;
   }

   static boolean mej(World var0, BlockPos var1) {
      BlockEntity var2 = var0.getBlockEntity(var1);
      return var2 instanceof ChestBlockEntity || var2 instanceof BarrelBlockEntity;
   }

   static BlockPos mek(World var0, BlockPos var1) {
      BlockState var2 = var0.getBlockState(var1);
      return var2.getBlock() instanceof ChestBlock && var2.contains(ChestBlock.CHEST_TYPE) && var2.get(ChestBlock.CHEST_TYPE) != ChestType.SINGLE
         ? var1.offset(ChestBlock.getFacing(var2))
         : null;
   }

   static BlockPos mel(World var0, BlockPos var1) {
      BlockPos var2 = mek(var0, var1);
      return (var2 != null && var2.asLong() < var1.asLong() ? var2 : var1).toImmutable();
   }

   static boolean mem(World var0, BlockPos var1) {
      if (!(var0.getBlockState(var1).getBlock() instanceof ChestBlock)) {
         return false;
      }

      BlockPos var2 = mek(var0, var1);
      return ChestBlock.isChestBlocked(var0, var1) || var2 != null && ChestBlock.isChestBlocked(var0, var2);
   }

   static int men(PlayerInventory var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 36; var2++) {
         ItemStack var3 = var0.getStack(var2);
         if (!var3.isEmpty() && oqv.wantsItem(var3.getItem())) {
            var1 += var3.getCount();
         }
      }

      return var1;
   }

   static double meo(int var0, int var1) {
      int var2 = var0 % 9 - var1 % 9;
      int var3 = var0 / 9 - var1 / 9;
      return Math.sqrt(var2 * var2 + var3 * var3);
   }

   static boolean mep(PlayerInventory var0, ItemStack var1) {
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

   static boolean meq(PlayerInventory var0) {
      for (int var1 = 0; var1 < 36; var1++) {
         if (var0.getStack(var1).isEmpty()) {
            return true;
         }
      }

      return false;
   }

   int mer(List<ItemStack> var1, ItemStack var2) {
      int var3 = this.mes(var1, var2, 0);
      if (var3 <= 0) {
         var3 = this.mes(var1, var2, 1);
      }

      if (var3 <= 0 && mfc(var2).isEmpty()) {
         var3 = this.mes(var1, var2, 2);
      }

      return var3;
   }

   int mes(List<ItemStack> var1, ItemStack var2, int var3) {
      int var4 = Math.max(0, var1.size() - 36);
      String var5 = mfg(this.mc.player.getGameProfile().name());
      Map<String, Integer> var6 = mfc(var2);
      ArrayList<Integer> var7 = new ArrayList<>();

      for (int var8 = 0; var8 < var4; var8++) {
         ItemStack var9 = (ItemStack)var1.get(var8);
         if (var9 != null && !var9.isEmpty() && this.met(var9, var2, var6, var3)) {
            int var10 = mew(mff(var9), var5);
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

   boolean met(ItemStack var1, ItemStack var2, Map<String, Integer> var3, int var4) {
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

      Map var7 = mfc(var1);
      return var4 != 0 ? mev(var3, var7) >= this.lzv.get() / 100.0 : var3.equals(var7) && meu(var1, var2);
   }

   static boolean meu(ItemStack var0, ItemStack var1) {
      List var2 = mff(var1);
      if (var2.size() <= 1) {
         return true;
      }

      List var3 = mff(var0);

      for (int var4 = 1; var4 < var2.size(); var4++) {
         String var5 = (String)var2.get(var4);
         if (!var5.isEmpty() && !var3.contains(var5)) {
            return false;
         }
      }

      return true;
   }

   static double mev(Map<String, Integer> var0, Map<String, Integer> var1) {
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

   static int mew(List<String> var0, String var1) {
      int var2 = -1;
      int var3 = 0;

      while (var3 < var0.size()) {
         String var4 = (String)var0.get(var3);
         if (!var4.contains(a.c(-599991091, "\ud887ꄳ⮜뗢㹏법ˑ謧ᕹ龹\u181a\ue219泀")) && !var4.contains(a.d("\ua4cb\udd72厴징䈈쓁纓\uf711楅", 399891685, 819231770))) {
            if (var1.isEmpty() || !var4.contains(var1) || !var4.contains(a.b("搹᷷靚ड苲с", -2103943168)) && !var4.contains(a.c(1431363554, "\udbd6ꉮ⢶뛃㴕뮪"))) {
               if (var2 <= 0 && var3 != 0) {
                  int var5 = var4.indexOf(a.c(647994328, "龝\ue65f沄"));
                  if (var5 < 0) {
                     var5 = var4.indexOf(a.d("뜿캌䑄\uda3f凮", -450008059, -1141777585));
                  }

                  if (var5 < 0) {
                     var5 = var4.indexOf(36);
                  }

                  if (var5 >= 0) {
                     int var6 = var4.indexOf(58, var5);
                     var2 = mex(var4, var6 >= 0 ? var6 + 1 : var5);
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

   static int mex(String var0, int var1) {
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
         } else if (var4 && !mey(var6)) {
            break;
         }
      }

      return var4 && var2 > 0L ? (int)var2 : -1;
   }

   static boolean mey(char var0) {
      return var0 == ' ' || var0 == ',' || var0 == '.' || var0 == 160 || var0 == 8239;
   }

   static long mez(long var0) {
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

   static String mfa(ItemStack var0) {
      return String.valueOf(var0.getItem()) + '|' + mfg(var0.getName().getString()) + '|' + mfe(var0);
   }

   static boolean mfb(ItemStack var0, ItemStack var1) {
      return var0 != null && var1 != null && !var0.isEmpty() && !var1.isEmpty() ? var0.getItem() == var1.getItem() && mfa(var0).equals(mfa(var1)) : false;
   }

   static Map<String, Integer> mfc(ItemStack var0) {
      TreeMap<String, Integer> var1 = new TreeMap<>();
      if (var0 != null && !var0.isEmpty()) {
         try {
            mfd(var0.get(DataComponentTypes.ENCHANTMENTS), var1);
            mfd(var0.get(DataComponentTypes.STORED_ENCHANTMENTS), var1);
         } catch (Throwable var3) {
         }

         return var1;
      } else {
         return var1;
      }
   }

   static void mfd(ItemEnchantmentsComponent var0, Map<String, Integer> var1) {
      if (var0 != null && !var0.isEmpty()) {
         for (RegistryEntry<Enchantment> var3 : var0.getEnchantments()) {
            String var4 = var3.getKey().map((RegistryKey<Enchantment> var0x) -> var0x.getValue().getPath()).orElse("");
            if (!var4.isEmpty()) {
               var1.put(var4, var0.getLevel(var3));
            }
         }
      }
   }

   static String mfe(ItemStack var0) {
      StringBuilder var1 = new StringBuilder();

      for (Entry var3 : mfc(var0).entrySet()) {
         var1.append((String)var3.getKey()).append(var3.getValue()).append(',');
      }

      return var1.toString();
   }

   static List<String> mff(ItemStack var0) {
      ArrayList var1 = new ArrayList();

      try {
         var1.add(mfg(var0.getName().getString()));
         LoreComponent var2 = var0.get(DataComponentTypes.LORE);
         if (var2 != null) {
            for (Text var4 : var2.lines()) {
               if (var4 != null) {
                  var1.add(mfg(var4.getString()));
               }
            }
         }
      } catch (Throwable var5) {
      }

      return var1;
   }

   static String mfg(String var0) {
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

   static boolean mfh(String var0) {
      String var1 = pfl.title(var0);
      return var1.contains(a.b("㯛䉯죌嚰\udd62寐\ue180栀", 2064990102)) && mfi(var1, lyn);
   }

   static boolean mfi(String var0, String[] var1) {
      for (String var5 : var1) {
         if (var0.contains(var5)) {
            return true;
         }
      }

      return false;
   }

   int mfj() {
      PlayerInventory var1 = this.mc.player.getInventory();
      int var2 = -1;
      int var3 = 0;

      for (int var4 = 0; var4 < 36; var4++) {
         if (this.mcp(var4)) {
            ItemStack var5 = var1.getStack(var4);
            if (mfb(var5, this.maq) && var5.getCount() > var3) {
               var3 = var5.getCount();
               var2 = var4;
            }
         }
      }

      return var2;
   }

   int mfk() {
      PlayerInventory var1 = this.mc.player.getInventory();
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         if (this.mcp(var3)) {
            ItemStack var4 = var1.getStack(var3);
            if (mfb(var4, this.maq)) {
               var2 += var4.getCount();
            }
         }
      }

      return var2;
   }

   int mfl() {
      if (this.mba >= 0) {
         return this.mba;
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

   static int mfm(int var0) {
      return var0 < 9 ? 36 + var0 : var0;
   }

   boolean mfn() {
      Screen var1 = this.mc.currentScreen;
      if (var1 == null) {
         return false;
      }

      if (!(var1 instanceof HandledScreen)) {
         this.maa = System.currentTimeMillis();
         return true;
      }

      if (this.mft()) {
         this.mc.player.closeHandledScreen();
         this.mac = Math.max(this.mac, System.currentTimeMillis() + mfx());
      }

      return true;
   }

   boolean mfo() {
      ClientPlayerEntity var1 = this.mc.player;
      return var1.currentScreenHandler != var1.playerScreenHandler ? false : this.mfp();
   }

   boolean mfp() {
      if (!this.mcj && (!pud.INSTANCE.engaged() || System.currentTimeMillis() - this.mck >= 1000L)) {
         if (!this.mft()) {
            return false;
         } else if (!this.mbe) {
            this.mbe = true;
            return false;
         } else {
            return vyn.serverIdle(this.mc.player);
         }
      } else {
         return false;
      }
   }

   void mfq() {
      if (this.mbe) {
         this.mbf.release(this.mc);
         this.mbe = false;
      }
   }

   void mfr(int var1, SlotActionType var2, int var3) {
      ClientPlayerEntity var4 = this.mc.player;
      if (var4 != null && this.mc.interactionManager != null) {
         ScreenHandler var5 = var4.currentScreenHandler;
         if (var5 != null && var1 >= 0 && var1 < var5.slots.size()) {
            this.mc.interactionManager.clickSlot(var5.syncId, var1, var3, var2, var4);
            this.mab = System.currentTimeMillis() + this.mfu();
         }
      }
   }

   void mfs(String var1) {
      if (this.mc.getNetworkHandler() != null) {
         this.mc.getNetworkHandler().sendChatCommand(var1);
         long var2 = System.currentTimeMillis();
         this.mag = var2;
         this.mad = var2;
         this.mae = -1L;
      }
   }

   boolean mft() {
      long var1 = System.currentTimeMillis();
      if (var1 < this.mab) {
         return false;
      }

      this.mab = var1 + this.mfu();
      return true;
   }

   long mfu() {
      double var1 = mga(1.0 + ThreadLocalRandom.current().nextGaussian() * 0.22, 0.72, 1.8);
      long var3 = (long)(110.0 * var1);
      if (ThreadLocalRandom.current().nextInt(100) < 6) {
         var3 += ThreadLocalRandom.current().nextLong(140L, 520L);
      }

      return var3 + ThreadLocalRandom.current().nextLong(10L, 60L);
   }

   boolean mfv(long var1, int var3) {
      if (this.mae < 0L || this.maf != var3) {
         this.mae = this.mfw(var3);
         this.maf = var3;
      }

      if (var1 < Math.max(this.mac, this.mad + this.mae)) {
         this.maa = var1;
         return false;
      }

      long var4 = var3 == 1 ? var1 : pdi.nextFree(var3, this.lzx.getInt(), var1);
      if (var4 <= var1) {
         return true;
      }

      this.mac = var4 + mfz(900L, 0.6, 150L, 5000L);
      this.maa = var1;
      if (this.mac - var1 > 5000L && var1 - this.mak > 20000L) {
         this.mak = var1;
         this.mgf(a.c(-790457063, "鄖\ue884打ﰦ瞋\uf558䬛슙岿홲凟ꮨ╼변㊏둲ਫ藸Ἴ鴎") + (this.mac - var1 + 999L) / 1000L + a.b("\uf443覓", -1749552031), false);
      }

      return false;
   }

   long mfw(int var1) {
      if (var1 == 1) {
         return this.mcg.draw(3, 1.4);
      }

      double var2 = 60000.0 / pdi.limit(this.lzx.getInt());
      return this.mcg.draw(4, var2 * 0.75 / 1500.0);
   }

   static long mfx() {
      return mfz(850L, 0.35, 450L, 3000L);
   }

   static int mfy() {
      return 14 + ThreadLocalRandom.current().nextInt(11);
   }

   static long mfz(long var0, double var2, long var4, long var6) {
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

   static double mga(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }

   boolean mgb() {
      this.mbm = 0;
      this.mbi = false;
      if (pdi.warn() >= 2) {
         this.mgf(a.b("\u2455巰흖䥕슅䑁全矣\ue9c9捻\ue4abậ鐘\u09b3菤ԗ뽔よꨲⰜ", -1920524192), false);
         this.mcs();
         return false;
      } else {
         long var1 = System.currentTimeMillis();
         long var3 = mfz(25000L, 0.25, 15000L, 45000L);
         this.mac = Math.max(this.mac, var1 + var3);
         this.mgf(a.c(870016198, "惸ᥝ鏻\u0df8蘨ì뻟㌱광⟞ꁲ婺퓗䤄읋䆳ﯽ琣\uee9e棇\ue130魩ᗚ訒ౡ芯㬓딱⾲ꧤ♇") + (var3 + 999L) / 1000L + a.c(519189454, "㏬丼"), false);
         this.maa = var1;
         return true;
      }
   }

   void mgc() {
      String var1 = this.mbn;
      String var2 = var1.isEmpty() ? a.d("邘\ue97a提\ufddd癴\uf0c3䪓읿崾ퟳ偘ꨣ⓳뵅㜝", 1303802709, 909109202) : a.c(1884055245, "拌ᬮ醄ྉ萠ʗ룇㔫꽪▧ꈌ塷횧休앉䞹\ufdec") + var1;
      if (++this.mal >= 3) {
         this.mgf(var2, false);
         this.mcs();
      } else {
         this.mcr(var2, false, true);
      }
   }

   void mgd(lxu var1) {
      if (this.lzz != var1) {
         this.lzz = var1;
         this.maa = System.currentTimeMillis();
         this.mbh = 0L;
      }
   }

   void mge() {
      this.mfq();
      this.mdy();
      this.med();
      this.mbp = null;
      this.mbq = null;
      this.mbr = null;
      this.mbw = 0L;
      this.mcd = null;
      Arrays.fill(this.mce, false);
      this.lzz = lxu.IDLE;
      this.maa = 0L;
      this.mbh = 0L;
      this.maz = false;
      this.mbi = false;
      this.mbm = 0;
      this.mbn = "";
      this.maq = ItemStack.EMPTY;
      this.mar = "";
      this.mas = "";
      this.mav = -1;
      this.max = 0;
      this.mal = 0;
      this.mam = 0L;
      this.map = false;
      this.maw = 0;
      this.mba = -1;
      this.mbb = -1;
      this.mbc = -1;
      this.mbd = -1;
   }

   void mgf(String var1, boolean var2) {
      System.out.println(a.c(1141262067, "䚹㼼뗹⮣ꁙ⛡鲮ᕊ謂ǻ蘲") + var1);
      izx.alert(this.getName(), var1, var2 ? vhz.CHECK : vhz.INFO, var2);
   }
}
