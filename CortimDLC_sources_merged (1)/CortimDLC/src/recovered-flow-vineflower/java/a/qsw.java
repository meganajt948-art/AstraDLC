package a;

import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import net.minecraft.world.chunk.WorldChunk;

public final class qsw {
   static final String qsx = a.c(656358294, "㯶䉖좝囱");
   static final String qsy = a.c(795336601, "\udffbꙃⲐ닪");
   static final String qsz = a.d("轜\uf6e5", 382379335, 924133985);
   static final double qta = 4.3;
   static final long qtb = 75000L;
   static final long qtc = 160000L;
   static final long qtd = 360000L;
   static final int qte = 10;
   static final int qtf = 2;
   static final int qtg = 24;
   public static volatile Consumer<String> trace;
   public int repairTo = 1500;
   public int xpStock = 576;
   public Set<String> junk = Set.of();
   final qdz qth = new qdz();
   final qbo qti = new qbo();
   final Map<BlockPos, String> qtj = new HashMap<>();
   final ArrayDeque<BlockPos> qtk = new ArrayDeque<>();
   Consumer<String> qtl = var0 -> {};
   qst qtm = qst.DONE;
   long qtn;
   long qto;
   BlockPos qtp;
   BlockPos qtq;
   BlockPos qtr;
   BlockPos qts;
   int qtt = -1;
   boolean qtu;
   boolean qtv;
   long qtw;
   String qtx = "";
   BlockPos qty;
   int qtz;
   long qua;
   int qub;
   Object quc;
   boolean qud;
   int que;
   int quf;
   int qug;
   long quh;
   int qui;
   long quj;
   long quk;
   boolean qul;
   boolean qum;
   long qun;
   int quo;
   int qup;

   public qsw() {
      this.qth.target(var0 -> false);
   }

   public void notes(Consumer<String> var1) {
      this.qtl = var1;
   }

   public qdz walker() {
      return this.qth;
   }

   public boolean repairFailed() {
      if (this.qtv && System.currentTimeMillis() - this.qtw > 600000L) {
         this.qtv = false;
      }

      return this.qtv;
   }

   public String status() {
      return this.qtx;
   }

   public boolean running() {
      return this.qtm != qst.DONE;
   }

   public boolean canPause() {
      return this.qty == null && this.quf == 0 && this.qtm != qst.LAYOUT;
   }

   public void begin(long var1) {
      this.qto = var1;
      this.qtp = null;
      this.qtq = null;
      this.qtr = null;
      this.qts = null;
      this.qtt = -1;
      this.qtu = false;
      this.qty = null;
      this.qtk.clear();
      this.quf = 0;
      this.qum = false;
      this.qun = 0L;
      this.quo = 0;
      this.qup = 0;
      this.qus(qst.FIND, var1);
   }

   public void forget() {
      this.qtj.clear();
      this.qtv = false;
   }

   public void stop(MinecraftClient var1) {
      this.qth.stop(var1);
      this.qwi(var1);
      if (var1.player != null && var1.currentScreen instanceof HandledScreen) {
         var1.player.closeHandledScreen();
      }

      this.qtm = qst.DONE;
      this.qty = null;
   }

   public void startTick(MinecraftClient var1, ClientPlayerEntity var2) {
      if (this.qtm == qst.REPAIR && this.quf == 3 && var2.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE) && var1.currentScreen == null && qwh(var1)) {
         this.qth.releaseKeys(var1);
         var1.options.useKey.setPressed(true);
         this.qul = true;
      } else {
         this.qwi(var1);
         if (this.qty != null && this.qtz == 0) {
            this.qth.startTick(var1, var2);
         } else {
            this.qth.releaseKeys(var1);
         }
      }
   }

   public qsq tick(MinecraftClient var1, ClientPlayerEntity var2, qof var3, tel var4, qsp var5, long var6) {
      if (this.qtm == qst.DONE) {
         return qsq.DONE;
      }

      if (var6 - this.qtn > (this.qtm == qst.REPAIR ? 160000L : 75000L)) {
         this.qtl.accept(a.c(-116579169, "₶夜폎䶴왧䓘ﺑ矫") + quv(this.qtm) + a.d("µ禟\uf751椨\ue6ea搸\ude69埦즳䌌새㪵끶⧃ꎛ┝齖ჺ", 2108886629, -1996747143));
         this.qvn(var1);
         this.qth.stop(var1);
         this.qwi(var1);
         this.qty = null;
         if (this.qtm == qst.REPAIR) {
            this.quf = 0;
            this.qum = false;
            if (var2.getOffHandStack().isIn(ItemTags.PICKAXES) && !var3.busy()) {
               var3.swaps(this.qug, 40);
            }
         }

         this.qut(var6);
         return qsq.RUNNING;
      } else {
         PlayerInventory var8 = var2.getInventory();
         boolean var9 = this.qty == null;
         switch (this.qtm) {
            case FIND:
               this.qtx = a.c(-1064508966, "\ue5e9鱃ᚑ裫̸膇㯎똧⠉ꊲℂ\udf12凇절䉒쓔绢\uf131");
               if (var6 - this.qto >= 1500L) {
                  this.quy(var1.world, var2);
                  if (this.qtp != null && this.qtq != null && this.qtr != null) {
                     this.qut(var6);
                  } else if (var6 - this.qtn > 4000L) {
                     this.qvb(var1.world, var2);
                     this.qus(qst.SCAN, var6);
                  }
               }
               break;
            case SCAN:
               this.qtx = a.d("䖷㰝뛏⢵ꍦ⇙鮐ᘀ蠢ʑ蔾罍\uf194汋\ue279撊\udebb兣쮧䶏쑺", -1827568728, 422887979);
               BlockPos var21 = this.qtk.peek();
               if (var21 == null) {
                  if (this.qtp == null && this.qtq == null && this.qtr == null) {
                     this.qtl
                        .accept(
                           a.c(
                              561465331,
                              "䎫㨲듴⺘ꕂ⎋駁ၚ訞ӎ茟礐\uf7ce済\ue422拑\udc86圶췾䮮쉒렇㚰ꥱ⼆ꆽ\u187c阬\u0cd1誃ŏ￣疮\ue847溟\ue0c4彣핣収쨀䒥㫃난㞦ꧭ➕鹃ᓷ鋄१蝫秕\uf47e爭\ue8a0暋\udd30寭퇠䳆싦뢻㿃넇⿉ꘌ᱖鹞ᒛ"
                           )
                        );
                     this.stop(var1);
                     return qsq.FAILED;
                  }

                  this.quu(a.c(-544458098, "㺹䜀짆厪\ud870庹\ue4f3浨\uf736綝") + this.quw());
                  this.qut(var6);
               } else {
                  int var22 = this.qvh(var1, var2, var4, var5, var21, var6);
                  if (var22 != 0) {
                     if (var22 > 0) {
                        String var24 = role(var1.currentScreen.getTitle().getString());
                        if (var24 != null) {
                           this.qtj.put(var21, var24);
                           this.quz(var24, var21, var2);
                        }

                        this.qvn(var1);
                     }

                     this.qty = null;
                     this.qtk.poll();
                  }
               }
               break;
            case JUNK:
               this.qut(var6);
               break;
            case COMPACT:
               this.qtx = a.d("넴좞䉌\udc36埥핚漓\ue283糟\uf61c燅设ԗ飈ᚋ遱⨹ꗤ㽐륽㓡䪨쀃必\ud9b3卧\uead1擼ﹷ", -942139822, 1026532186);
               if (!var3.busy()) {
                  if (!this.qud) {
                     this.qud = true;
                     var3.compact();
                  } else {
                     this.qut(var6);
                  }
               }
               break;
            case XP_LOOK:
               this.qtx = a.c(1880634486, "ぅ䧯쌽嵇횔含\uee62揲\ufdd0督\uf0ccિ葦ᦹ韴ᄄꬿⓧ");
               if (this.qtr == null) {
                  this.qtu = this.needsRepair(var2);
                  this.qut(var6);
               } else {
                  int var20 = this.qvh(var1, var2, var4, var5, this.qtr, var6);
                  if (var20 < 0) {
                     this.quu(a.d("㫿䍆춀埯\udc44媍\ue0a4楞\uf771綺逸ѹ軏\u177c鵑ᮩꆑ⸹낐㙊묨셸便푧囡", -1002619469, -1182203032));
                     this.qty = null;
                     this.qtu = this.needsRepair(var2);
                     this.qut(var6);
                  } else if (var20 > 0 && this.qvp(var1, var2, var6) && this.qvr(var1, var2)) {
                     this.qvo(var1, var6);
                  }
               }
               break;
            case CRAFT:
               this.qtx = this.qtu
                  ? a.d("鱏\ue5e5漷\uf14d窞\uf821䉨쾃冦\udb67峀ꚲ⡡떳㯾봎ܵ裭ᘼ鑵ᦚ柚\ue963犷\uf4cc縟", -1819807010, -1997903190)
                  : a.b("⼯嚅\udc57䈭짾䭁\uf108糣\ue2c6标\uefa0ᗒ鬁ۓ袑\u0e6a될㯵ꅄ", -547673315);
               if (this.qts != null && (this.qud || this.qwa(var8) || this.qtu)) {
                  int var19 = this.qvh(var1, var2, var4, var5, this.qts, var6);
                  if (var19 < 0) {
                     this.quu(a.d("턋ꢲ♴받㞰녹\u0b50芪ᲅ陎ᆓ\uef8d效ﳾ盘\uf028䩤엇彾", -1074824487, -1275678724));
                     this.qty = null;
                     this.qut(var6);
                  } else if (var19 > 0) {
                     if (var1.currentScreen instanceof CraftingScreen var11) {
                        if (!this.qud) {
                           this.qud = true;
                           if (this.qtu) {
                              this.qup++;
                           }

                           this.qti.plan(this.qtu, this.qwb(var8));
                        }

                        CraftingScreenHandler var23 = var11.getScreenHandler();
                        if (this.qti.tick(var1, var2, var23)) {
                           for (String var14 : this.qti.notes()) {
                              this.quu(var14);
                           }

                           qbo.putBack(var1, var2, var23, -1);
                           this.qvo(var1, var6);
                        }
                     } else {
                        this.quu(a.d("\u10ce楰\ue3df禰\uf67a烃캅䍦\udd3e基퀨⩚꓿㵄", -494824317, 40796174));
                        this.qvo(var1, var6);
                     }
                  }
               } else {
                  if (this.qts == null && this.qtu) {
                     this.quu(a.d("㨂䎻줟匌\udcc9婿\ue059榩\uf7f5紶\ufaef\u0094詓ខ馱ᬡꅬ⻃둹㉟믑솊䬩큳劙\ud849憎\uefd6燘", 1959749790, 1002854076));
                  }

                  this.qut(var6);
               }
               break;
            case XP_TAKE:
               this.qtx = a.d("퍀ꫪ‸빂㖑뜮൧肇Ờ鐘Ꮘ\uedda朓ﺣ璄\uf27c", 1680046254, 1190309855);
               if (this.qtr != null && (this.qud || this.needsRepair(var2) && this.qtt != 0 && qpw.count(var8, Items.EXPERIENCE_BOTTLE) < this.qux(var2))) {
                  int var18 = this.qvh(var1, var2, var4, var5, this.qtr, var6);
                  if (var18 < 0) {
                     this.qty = null;
                     this.qut(var6);
                  } else if (var18 > 0 && this.qvp(var1, var2, var6) && this.qvt(var1, var2, Items.EXPERIENCE_BOTTLE, this.qux(var2))) {
                     this.qtt = this.qvs(var1, var2, Items.EXPERIENCE_BOTTLE);
                     this.qvo(var1, var6);
                  }
               } else {
                  this.qut(var6);
               }
               break;
            case REPAIR:
               if (this.qun == 0L) {
                  this.qun = var6;
               }

               this.qtx = a.b("מּ芔ࡆ阼ᷯ齐┙ꢏ㚯받㮻얤佩훚峱\uda7a恌", -2061304050)
                  + (this.quf == 3 ? a.b("湦\u17df鵢̴裱็됵㷢ꎫ⥖", 1614048844) : "")
                  + a.c(-1909197298, "\uf62d輋Տ")
                  + Math.max(0, qpw.pickaxeDurability(var2))
                  + a.d("༪皔ﱈ", 1024559082, 1759480035)
                  + this.repairTo;
               if (this.qwe(var1, var2, var3, var5, var6)) {
                  this.qwc(var2, var6);
               }
               break;
            case XP_STORE:
               this.qtx = a.c(2059140709, "節菼म靔ᲇ鸸⑱ꧣ㟎뵶㫝샜乵펪巧\udb17愬\ueef4");
               if (this.qtr != null && (this.qud || qpw.count(var8, Items.EXPERIENCE_BOTTLE) != 0)) {
                  int var17 = this.qvh(var1, var2, var4, var5, this.qtr, var6);
                  if (var17 < 0) {
                     this.qty = null;
                     this.qut(var6);
                  } else if (var17 > 0 && this.qvp(var1, var2, var6) && this.qvu(var1, var2, var0 -> var0.isOf(Items.EXPERIENCE_BOTTLE))) {
                     this.qvo(var1, var6);
                  }
               } else {
                  this.qut(var6);
               }
               break;
            case DUMP:
               this.qtx = a.b("⒫崁ퟓ䦩쉺䃅戴眜\ue938授\ue450ḥ邍ॅ茔֛뮺べ께⳨ꕯ\udf4f冂쨬", -1222369134);
               if (this.qtp != null && (this.qud || qvx(var8))) {
                  int var16 = this.qvh(var1, var2, var4, var5, this.qtp, var6);
                  if (var16 < 0) {
                     this.quu(a.b("攰\u1c89鉏ࠠ莋Ղ뽫㚑ꢾ≵ꖨ家턀䢳슞䑦﹞燶\uef5f榅\ue498麹ၻ诔ු菿", -2045157097));
                     this.qty = null;
                     this.qut(var6);
                  } else if (var16 > 0 && this.qvp(var1, var2, var6) && this.qvy(var1, var2)) {
                     this.qvo(var1, var6);
                  }
               } else {
                  this.qut(var6);
               }
               break;
            case FOOD_PREP:
               label253:
               if (!var3.busy()) {
                  int var15 = qpw.emptySlot(var8);
                  if (!this.qud) {
                     log(
                        a.d("伎㚶뱥∟ꦌ⽭锼᳚芐\u086b辢疜\ufb42拳\ue8fb", 975872081, -203034826)
                           + var2.getOffHandStack()
                           + a.c(-786578764, "슓뭫ㆿ꿩␙ꊰᢨ")
                           + qpw.find(var8, Items.GOLDEN_CARROT)
                           + a.d("煻\u088f艔\u1c38韫ᅗꭀ", 1593586014, 707608578)
                           + var15
                           + a.d("쀷맀㌚굫⚷ꁟ", 593345382, -197821577)
                           + qpw.food(var2)
                     );
                     this.qud = true;
                     if (this.qtq != null
                        && qpw.food(var2) < 64
                        && var2.getOffHandStack().isOf(Items.GOLDEN_CARROT)
                        && qpw.find(var8, Items.GOLDEN_CARROT) < 0
                        && var15 >= 0) {
                        var3.swaps(var15, 40);
                        break label253;
                     }
                  }

                  this.qut(var6);
               }
               break;
            case FOOD:
               this.qtx = a.c(-1347924532, "䧶ぜ몎⓴꼧\u2d98韑ᨱ葪ຮ襾睬ﶬ搔\uee42梶튅嵕쟫䗔젿뉬㲡꜊ⅱꮬቡ");
               if (this.qtq != null && (this.qud || qpw.food(var2) < 64)) {
                  int var10 = this.qvh(var1, var2, var4, var5, this.qtq, var6);
                  if (var10 < 0) {
                     this.quu(a.d("╛峢툤䡋쏠䔩\uff00盺\ue8d5戞\ue5c3ᯝ酫ࣘ苵Ѝ븵㆝꼴⧮ꒅ\udedd偫쮿䶼윟结\uf4ed樆\uec55枘餳፸誅ನ苮", -1582147128, -1625786230));
                     this.qty = null;
                     this.qut(var6);
                  } else if (var10 > 0 && this.qvp(var1, var2, var6) && this.qvv(var1, var2)) {
                     this.qvo(var1, var6);
                  }
               } else {
                  this.qut(var6);
               }
               break;
            case LAYOUT:
               this.qtx = a.b("辵\uf61f糍\ue2b7楤\uebdb冒\udc03䈬죬佄딴㯨ꉝ⡱껹ᒴ鬛׆螏\u0e7d琣流慎\ue74e淭퐮婳", 19106696);
               if (!var3.busy()) {
                  if (var1.currentScreen != null) {
                     this.qvn(var1);
                  } else if (!this.qud) {
                     this.qud = true;
                     var3.layout();
                  } else {
                     if (var8.getStack(0).isIn(ItemTags.PICKAXES)) {
                        var8.setSelectedSlot(0);
                     }

                     this.qut(var6);
                  }
               }
         }

         if (this.qtm == qst.DONE) {
            this.qth.stop(var1);
            return qsq.DONE;
         }

         if (this.qty != null && this.qtz == 0) {
            this.qth.endTick(var1, var2, var4);
         } else if ((this.qtm != qst.REPAIR || this.quf < 1) && (var9 || this.qtz != 1)) {
            var5.at(var1, var2, null, null);
         }

         return qsq.RUNNING;
      }
   }

   static void log(String var0) {
      Consumer var1 = trace;
      if (var1 != null) {
         var1.accept(var0);
      }
   }

   void qus(qst var1, long var2) {
      log(a.d("溺ᜌ鷎Ϊ蠭", 1857476704, -1063143764) + var1);
      this.qtm = var1;
      this.qtn = var2;
      this.qud = false;
      this.que = 0;
   }

   void qut(long var1) {
      this.qvn(MinecraftClient.getInstance());
      this.qty = null;
      qst[] var3 = qst.values();
      this.qus(var3[Math.min(var3.length - 1, this.qtm.ordinal() + 1)], var1);
      if (this.qtm == qst.SCAN) {
         this.qus(qst.JUNK, var1);
      }
   }

   void quu(String var1) {
      this.qtl.accept(a.c(557178258, "\ud9b4ꀞ⫌뒶㽥뷚ޓ") + var1);
   }

   static String quv(qst var0) {
      return switch (var0) {
         case FIND, SCAN -> a.d("ꤛ킫婾쑶俚쵱獃練撑\uee29榍鎅ᵖ蓫", -440302409, 88484253);
         case JUNK -> a.b("亷㝹붨⎦ꠏ", 1214532238);
         case COMPACT -> a.c(-1827633749, "臯\uf85d狼\uec87杒");
         case XP_LOOK, XP_TAKE -> a.c(-1474936536, "䔒㲢똅⡽");
         case CRAFT -> a.d("Ⰴ嗏\udf6c䅩쪸", 1224411166, -1189404635);
         case REPAIR -> a.d("ݙ绩\uf443橍\ue19f朩\udd70", 1868551029, -183054316);
         case XP_STORE -> a.d("Բ糱\uf653桒\ue3f7效\udb77嚘죆䈃엙", -437075694, -1388920728);
         case DUMP -> a.b("萗\ufdd6睴\ue97b拓", 1309048915);
         case FOOD_PREP, FOOD -> a.c(1890066298, "ᭁ拲\ue85f癔ﶇ笺섗");
         case LAYOUT -> a.b("袁\uf140篢\ue5e8渾\ue884勓\udb2c䕹", 700026056);
         case DONE -> a.c(-211178327, "ꢜ턠宏얂乙죤");
      };
   }

   String quw() {
      ArrayList var1 = new ArrayList();
      if (this.qtp == null) {
         var1.add(a.c(-1848336077, "ꕷ\udcb6嘔젛䎳"));
      }

      if (this.qtq == null) {
         var1.add(a.d("\udcdbꕨ⿅뇎㨝베ڍ", 1365878537, 1703509993));
      }

      if (this.qtr == null) {
         var1.add(a.d("⯨剘\ud8ff䚇", -2079893320, 2073327466));
      }

      if (this.qts == null) {
         var1.add(a.c(-1361445180, "\ufaf1荇ৡ鞑᱅骆⃟"));
      }

      return String.join(a.b("㻥䝘", -342802741), var1);
   }

   public boolean needsRepair(ClientPlayerEntity var1) {
      int var2 = qpw.pickaxeDurability(var1);
      return var2 >= 0 && var2 < this.repairTo && !this.repairFailed();
   }

   int qux(ClientPlayerEntity var1) {
      int var2 = Math.max(0, qpw.pickaxeDurability(var1));
      return Math.max(64, Math.min(768, (this.repairTo - var2) / 10 + 32));
   }

   void quy(World var1, ClientPlayerEntity var2) {
      BlockPos var3 = var2.getBlockPos();
      double[] var4 = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
      BlockPos[] var5 = new BlockPos[3];

      for (int var6 = var3.getX() - 24 >> 4; var6 <= var3.getX() + 24 >> 4; var6++) {
         for (int var7 = var3.getZ() - 24 >> 4; var7 <= var3.getZ() + 24 >> 4; var7++) {
            WorldChunk var8 = var1.getChunk(var6, var7);

            for (BlockEntity var10 : new ArrayList<>(var8.getBlockEntities().values())) {
               if (var10 instanceof SignBlockEntity var11 && var10.getPos().isWithinDistance(var3, 24.0)) {
                  String var12 = qvc(var11);
                  String var13 = role(var12);
                  if (var13 != null) {
                     BlockPos var14 = qvd(var1, var11.getPos(), var1.getBlockState(var11.getPos()));
                     qva(var13, var14, var3, var5, var4);
                  }
               }
            }
         }
      }

      for (Entity var18 : var1 instanceof ClientWorld var17 ? var17.getEntities() : List.of()) {
         if (var18 != var2 && var18.getBlockPos().isWithinDistance(var3, 24.0)) {
            List<String> var20 = pzw.lines(var18);
            if (!var20.isEmpty()) {
               String var21 = role(String.join(a.c(838377754, "ꄻ"), var20));
               if (var21 != null) {
                  qva(var21, qve(var1, var18.getBlockPos(), 2), var3, var5, var4);
               }
            }
         }
      }

      for (Entry var19 : this.qtj.entrySet()) {
         if (qvg(var1.getBlockState((BlockPos)var19.getKey())) && ((BlockPos)var19.getKey()).isWithinDistance(var3, 24.0)) {
            qva((String)var19.getValue(), (BlockPos)var19.getKey(), var3, var5, var4);
         }
      }

      if (var5[0] != null) {
         this.qtp = var5[0];
      }

      if (var5[1] != null) {
         this.qtq = var5[1];
      }

      if (var5[2] != null) {
         this.qtr = var5[2];
      }

      this.qts = this.qtr != null ? qvf(var1, this.qtr, 6, Blocks.CRAFTING_TABLE) : null;
      if (this.qts == null) {
         this.qts = qvf(var1, var3, 12, Blocks.CRAFTING_TABLE);
      }
   }

   public boolean atHome(World var1, ClientPlayerEntity var2, double var3) {
      if (var1 == null) {
         return false;
      }

      Vec3d var5 = var2.getEyePos();
      BlockPos var6 = var2.getBlockPos();
      int var7 = (int)Math.ceil(var3) + 1;

      for (int var8 = var6.getX() - var7 >> 4; var8 <= var6.getX() + var7 >> 4; var8++) {
         for (int var9 = var6.getZ() - var7 >> 4; var9 <= var6.getZ() + var7 >> 4; var9++) {
            for (BlockEntity var11 : new ArrayList<>(var1.getChunk(var8, var9).getBlockEntities().values())) {
               if (var11 instanceof SignBlockEntity var12 && Vec3d.ofCenter(var11.getPos()).distanceTo(var5) <= var3 && role(qvc(var12)) != null) {
                  return true;
               }
            }
         }
      }

      for (Entry var14 : this.qtj.entrySet()) {
         if (Vec3d.ofCenter((Vec3i)var14.getKey()).distanceTo(var5) <= var3 && qvg(var1.getBlockState((BlockPos)var14.getKey()))) {
            return true;
         }
      }

      return false;
   }

   void quz(String var1, BlockPos var2, ClientPlayerEntity var3) {
            if (java.util.Objects.equals(var1, a.c(38664506, "讀胺\u0a31鑝"))) {
         this.qtp = this.qtp == null ? var2 : this.qtp;
      }
      else if (java.util.Objects.equals(var1, a.b("鼐\ue6a8汻\uf201", 1469095794))) {
         this.qtq = this.qtq == null ? var2 : this.qtq;
      }
      else {
         if (this.qtr == null) {
                        this.qtr = var2;
                        BlockPos var6 = qvf(var3.getEntityWorld(), var2, 6, Blocks.CRAFTING_TABLE);
                        if (var6 != null) {
                           this.qts = var6;
                        }
                     }
      }
   }

   static void qva(String var0, BlockPos var1, BlockPos var2, BlockPos[] var3, double[] var4) {
      if (var1 != null) {
                  byte var5;
         if (java.util.Objects.equals(var0, a.c(1447178763, "㉫䯋섀彬"))) {
            var5 = 0;
         }
         else if (java.util.Objects.equals(var0, a.c(1726920595, "럱칉䒚\udae0"))) {
            var5 = 1;
         }
         else {
            var5 = 2;
         }
         double var8 = var1.getSquaredDistance(var2);
         if (var8 < var4[var5]) {
            var4[var5] = var8;
            var3[var5] = var1.toImmutable();
         }
      }
   }

   void qvb(World var1, ClientPlayerEntity var2) {
      this.qtk.clear();
      BlockPos var3 = var2.getBlockPos();
      ArrayList var4 = new ArrayList();

      for (BlockPos var6 : BlockPos.iterateOutwards(var3, 10, 4, 10)) {
         if (qvg(var1.getBlockState(var6)) && !var6.equals(this.qtp) && !var6.equals(this.qtq) && !var6.equals(this.qtr) && !this.qtj.containsKey(var6)) {
            var4.add(var6.toImmutable());
         }
      }

      for (int var10 = 0; var10 < var4.size() && this.qtk.size() < 8; var10++) {
         BlockPos var11 = (BlockPos)var4.get(var10);
         boolean var7 = false;

         for (BlockPos var9 : this.qtk) {
            if (var9.getManhattanDistance(var11) == 1 && var1.getBlockState(var9).getBlock() instanceof ChestBlock) {
               var7 = true;
            }
         }

         if (!var7) {
            this.qtk.add(var11);
         }
      }
   }

   static String role(String var0) {
      String var1 = pfl.title(var0);
      if (var1.contains(a.c(-282781802, "Ꮢ樓\ue0b1纾\uf516"))) {
         return a.b("\ueefe非ᶕ菹", -1128010082);
      } else if (var1.contains(a.b("蝅ﻶ瑛\uea50憃\ue73e", -1622113409)) || var1.contains(a.c(-375232706, "挈᪸遯"))) {
         return a.b("\ude65\ua7ddⴎ덴", 1221778951);
      } else {
         return !var1.contains(a.d("\ue327骗ူ蹈", 896230047, 1038058882)) && !var1.contains(a.c(671909930, "谐\uf5dd罺\ue177檫"))
            ? null
            : a.d("棣ᅚ", -89705155, -1422238300);
      }
   }

   static String qvc(SignBlockEntity var0) {
      StringBuilder var1 = new StringBuilder();

      for (boolean var5 : new boolean[]{true, false}) {
         for (Text var9 : var0.getText(var5).getMessages(false)) {
            var1.append(var9.getString()).append(' ');
         }
      }

      return var1.toString();
   }

   static BlockPos qvd(World var0, BlockPos var1, BlockState var2) {
      Direction var3 = null;
      if (var2.getBlock() instanceof WallSignBlock) {
         var3 = var2.get(WallSignBlock.FACING);
      } else if (var2.getBlock() instanceof WallHangingSignBlock) {
         var3 = var2.get(WallHangingSignBlock.FACING);
      }

      if (var3 != null) {
         BlockPos var4 = var1.offset(var3.getOpposite());
         if (qvg(var0.getBlockState(var4))) {
            return var4;
         }
      }

      return qvg(var0.getBlockState(var1.down())) ? var1.down() : qve(var0, var1, 2);
   }

   static BlockPos qve(World var0, BlockPos var1, int var2) {
      for (BlockPos var4 : BlockPos.iterateOutwards(var1, var2, var2, var2)) {
         if (qvg(var0.getBlockState(var4))) {
            return var4.toImmutable();
         }
      }

      return null;
   }

   static BlockPos qvf(World var0, BlockPos var1, int var2, Block var3) {
      for (BlockPos var5 : BlockPos.iterateOutwards(var1, var2, var2, var2)) {
         if (var0.getBlockState(var5).isOf(var3)) {
            return var5.toImmutable();
         }
      }

      return null;
   }

   static boolean qvg(BlockState var0) {
      Block var1 = var0.getBlock();
      return var1 instanceof ChestBlock || var1 instanceof BarrelBlock || var1 instanceof ShulkerBoxBlock;
   }

   int qvh(MinecraftClient var1, ClientPlayerEntity var2, tel var3, qsp var4, BlockPos var5, long var6) {
      if (!var5.equals(this.qty)) {
         this.qvn(var1);
         this.qty = var5;
         this.qtz = 0;
         this.qua = var6;
         this.qub = 0;
         this.qth.stop(var1);
      }

      switch (this.qtz) {
         case 0:
            if (qvj(var2, var5) <= 4.3 && qvk(var1.world, var2, var5) != null) {
               this.qth.stop(var1);
               this.qtz = 1;
               this.qua = var6;
               this.quc = new Object();
               return 0;
            } else {
               if (this.qth.status() == qdw.IDLE) {
                  this.qth.park(pzc.empty(var2.getBlockPos()), var5, false);
               } else if (this.qth.parked() || this.qth.parkLost() || this.qth.status() == qdw.FAR) {
                  if (qvj(var2, var5) <= 5.3) {
                     this.qth.stop(var1);
                     this.qtz = 1;
                     this.qua = var6;
                     this.quc = new Object();
                     return 0;
                  }

                  if (var6 - this.qua > 3000L) {
                     this.qth.stop(var1);
                     return -1;
                  }
               }

               if (var6 - this.qua > 25000L) {
                  this.qth.stop(var1);
                  return -1;
               }

               return 0;
            }
         case 1:
            Vec3d var8 = qvk(var1.world, var2, var5);
            var4.at(var1, var2, this.quc, var8 != null ? var8 : qvl(var2, var5));
            var1.gameRenderer.updateCrosshairTarget(1.0F);
            if (var1.crosshairTarget instanceof BlockHitResult var9 && var9.getType() == Type.BLOCK && qvi(var1.world, var9.getBlockPos(), var5)) {
               ActionResult var11 = var1.interactionManager.interactBlock(var2, Hand.MAIN_HAND, var9);
               if (var11.isAccepted()) {
                  var2.swingHand(Hand.MAIN_HAND);
               }

               this.qtz = 2;
               this.qua = var6;
            } else if (var6 - this.qua > 3000L) {
               return ++this.qub > 2 ? -1 : 0;
            }

            return 0;
         default:
            if (var1.currentScreen instanceof HandledScreen) {
               return 1;
            } else {
               if (var6 - this.qua > 2500L) {
                  if (++this.qub > 2) {
                     return -1;
                  }

                  this.qtz = 1;
                  this.qua = var6;
                  this.quc = new Object();
               }

               return 0;
            }
      }
   }

   static boolean qvi(World var0, BlockPos var1, BlockPos var2) {
      if (var1.equals(var2)) {
         return true;
      }

      BlockState var3 = var0.getBlockState(var1);
      return var3.getBlock() instanceof ChestBlock && var3.getBlock() == var0.getBlockState(var2).getBlock() && var1.getManhattanDistance(var2) == 1;
   }

   static double qvj(ClientPlayerEntity var0, BlockPos var1) {
      Vec3d var2 = var0.getEyePos();
      Box var3 = new Box(var1);
      double var4 = Math.max(0.0, Math.max(var3.minX - var2.x, var2.x - var3.maxX));
      double var6 = Math.max(0.0, Math.max(var3.minY - var2.y, var2.y - var3.maxY));
      double var8 = Math.max(0.0, Math.max(var3.minZ - var2.z, var2.z - var3.maxZ));
      return Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
   }

   static Vec3d qvk(World var0, ClientPlayerEntity var1, BlockPos var2) {
      Vec3d var3 = var1.getEyePos();
      Vec3d var4 = var1.getRotationVec(1.0F);
      ArrayList<Vec3d> var5 = new ArrayList<>();
      var5.add(qvl(var1, var2));
      Vec3d var6 = Vec3d.ofCenter(var2);

      for (Direction var10 : Direction.values()) {
         double var11 = var10 == Direction.UP ? 0.33 : 0.4;
         var5.add(var6.add(var10.getOffsetX() * var11, var10.getOffsetY() * var11, var10.getOffsetZ() * var11));
      }

      Vec3d var18 = null;
      double var19 = Double.MAX_VALUE;

      for (Vec3d var21 : var5) {
         Vec3d var12 = var21.subtract(var3);
         double var13 = var12.length();
         if (!(var13 > 4.7) && !(var13 < 0.001)) {
            BlockHitResult var15 = var0.raycast(new RaycastContext(var3, var21.add(var12.multiply(0.05 / var13)), ShapeType.OUTLINE, FluidHandling.NONE, var1));
            if (var15.getType() == Type.BLOCK && qvi(var0, var15.getBlockPos(), var2)) {
               double var16 = Math.acos(Math.max(-1.0, Math.min(1.0, var12.multiply(1.0 / var13).dotProduct(var4))));
               if (var16 < var19) {
                  var19 = var16;
                  var18 = var21;
               }
            }
         }
      }

      return var18;
   }

   static Vec3d qvl(ClientPlayerEntity var0, BlockPos var1) {
      Vec3d var2 = var0.getEyePos();
      return new Vec3d(
         qvm(var2.x, var1.getX() + 0.3, var1.getX() + 0.7),
         qvm(var2.y, var1.getY() + 0.3, var1.getY() + 0.65),
         qvm(var2.z, var1.getZ() + 0.3, var1.getZ() + 0.7)
      );
   }

   static double qvm(double var0, double var2, double var4) {
      return Math.max(var2, Math.min(var4, var0));
   }

   void qvn(MinecraftClient var1) {
      if (var1.player != null && var1.currentScreen instanceof HandledScreen) {
         var1.player.closeHandledScreen();
      }
   }

   void qvo(MinecraftClient var1, long var2) {
      this.qvn(var1);
      this.qty = null;
      this.qut(var2);
   }

   boolean qvp(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (!this.qud) {
         this.qud = true;
         this.qua = var3;
         return false;
      } else {
         return var3 - this.qua >= 250L && var1.currentScreen instanceof HandledScreen;
      }
   }

   ScreenHandler qvq(MinecraftClient var1) {
      return var1.currentScreen instanceof HandledScreen var2 ? var2.getScreenHandler() : null;
   }

   boolean qvr(MinecraftClient var1, ClientPlayerEntity var2) {
      ScreenHandler var3 = this.qvq(var1);
      if (var3 == null) {
         return true;
      }

      if (this.qtt < 0) {
         this.qtt = this.qvs(var1, var2, Items.EXPERIENCE_BOTTLE);
         this.qtu = this.qtt < this.xpStock;
         this.quu(
            a.c(1504251319, "ঙ瀩搜擶\uef53淲펳幐쑮仝쥰㌈붨①긼Ⳙ")
               + this.qtt
               + (this.qtu ? a.b("ᯞ䉛\ue8bc狑羅羶얔䱡퉃峧", 369236980) + this.xpStock + a.c(-688552617, "蕲ﳏ牽\uec77柚\ue11b嬼틎䲕") : "")
         );
      }

      if (!this.qtu && this.needsRepair(var2)) {
         if (this.qvt(var1, var2, Items.EXPERIENCE_BOTTLE, this.qux(var2))) {
            this.qtt = this.qvs(var1, var2, Items.EXPERIENCE_BOTTLE);
            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   int qvs(MinecraftClient var1, ClientPlayerEntity var2, Item var3) {
      ScreenHandler var4 = this.qvq(var1);
      if (var4 == null) {
         return -1;
      }

      int var5 = 0;

      for (Slot var7 : vxl.own(var4, var2.getInventory())) {
         if (var7.getStack().isOf(var3)) {
            var5 += var7.getStack().getCount();
         }
      }

      return var5;
   }

   boolean qvt(MinecraftClient var1, ClientPlayerEntity var2, Item var3, int var4) {
      ScreenHandler var5 = this.qvq(var1);
      if (var5 == null) {
         return true;
      }

      int var6 = 0;

      while (var6 < 2) {
         if (qbo.count(var5, var2, var3) < var4 && ++this.que <= 60) {
            Slot var7 = null;

            for (Slot var9 : vxl.own(var5, var2.getInventory())) {
               if (var9.getStack().isOf(var3)) {
                  var7 = var9;
                  break;
               }
            }

            if (var7 != null && vxl.hasRoom(var5, var2.getInventory(), var7.getStack())) {
               vxl.click(var1, var5, var7.id, 0, SlotActionType.QUICK_MOVE);
               var6++;
               continue;
            }

            return true;
         }

         return true;
      }

      return false;
   }

   boolean qvu(MinecraftClient var1, ClientPlayerEntity var2, Predicate<ItemStack> var3) {
      ScreenHandler var4 = this.qvq(var1);
      if (var4 == null) {
         return true;
      }

      for (int var5 = 0; var5 < 2; var5++) {
         Slot var6 = null;

         for (Slot var8 : var4.slots) {
            if (var8.inventory == var2.getInventory() && var3.test(var8.getStack())) {
               var6 = var8;
               break;
            }
         }

         if (var6 == null || ++this.que > 80) {
            return true;
         }

         int var9 = var6.getStack().getCount();
         vxl.click(var1, var4, var6.id, 0, SlotActionType.QUICK_MOVE);
         if (var6.getStack().getCount() == var9) {
            this.quu(a.c(-1693978051, "\uf670迃ծ鬖Ⴖ陾⠷ꗙ㮇넳㛥첗"));
            return true;
         }
      }

      return false;
   }

   boolean qvv(MinecraftClient var1, ClientPlayerEntity var2) {
      ScreenHandler var3 = this.qvq(var1);
      if (var3 == null) {
         return true;
      }

      if (!var3.getCursorStack().isEmpty()) {
         qbo.putBack(var1, var2, var3, -1);
         return false;
      }

      int var4 = qpw.food(var2);
      if (var4 < 64 && ++this.que <= 30) {
         Slot var5 = null;

         for (Slot var7 : vxl.own(var3, var2.getInventory())) {
            if (var7.getStack().isOf(Items.GOLDEN_CARROT)) {
               var5 = var7;
               break;
            }
         }

         if (var5 == null) {
            this.quu(a.d("㾆䈥첗勤\ud94d念\ue5d1汙\uf209粭｣Ԛ论ᙩ頭ổ꒟⭋놄㞩빙쀑䪾텭坬\uddc7摰\uea2d烐", -1757730918, 123018291));
            return true;
         }

         Slot var9 = null;

         for (Slot var8 : var3.slots) {
            if (var8.inventory == var2.getInventory()
               && var8.getStack().isOf(Items.GOLDEN_CARROT)
               && var8.getStack().getCount() < var8.getStack().getMaxCount()) {
               var9 = var8;
               break;
            }
         }

         if (var9 == null) {
            for (Slot var13 : var3.slots) {
               if (var13.inventory == var2.getInventory() && !var13.hasStack()) {
                  var9 = var13;
                  break;
               }
            }
         }

         if (var9 == null) {
            this.quu(a.d("⾞嘧\udc83䚐쥛俣\uf5c4簶\ue21b沺\uef7dᔃ鮠پ蠱ໂ듳㭘ꇯ➲깏", 976727690, -232487620));
            return true;
         }

         vxl.click(var1, var3, var5.id, 0, SlotActionType.PICKUP);
         int var12 = 64 - var4;
         if (!var9.hasStack() && var3.getCursorStack().getCount() > var12 && var12 <= 8) {
            for (int var14 = 0; var14 < var12 && !var3.getCursorStack().isEmpty(); var14++) {
               vxl.click(var1, var3, var9.id, 1, SlotActionType.PICKUP);
            }
         } else {
            vxl.click(var1, var3, var9.id, 0, SlotActionType.PICKUP);
         }

         if (!var3.getCursorStack().isEmpty()) {
            vxl.click(var1, var3, var5.id, 0, SlotActionType.PICKUP);
         }

         return false;
      } else {
         return true;
      }
   }

   static int[] qvw(PlayerInventory var0) {
      for (int var1 = 0; var1 < 36; var1++) {
         if (dumpable(var0.getStack(var1))) {
            return new int[]{var1, 0};
         }
      }

      return null;
   }

   static boolean dumpable(ItemStack var0) {
      return var0.isOf(Items.DIAMOND_BLOCK) || var0.isOf(Items.GOLD_BLOCK) || var0.isOf(Items.ANCIENT_DEBRIS) || var0.isOf(Items.NETHERITE_SCRAP);
   }

   static boolean qvx(PlayerInventory var0) {
      return qvw(var0) != null;
   }

   boolean qvy(MinecraftClient var1, ClientPlayerEntity var2) {
      ScreenHandler var3 = this.qvq(var1);
      if (var3 == null) {
         return true;
      }

      PlayerInventory var4 = var2.getInventory();
      if (!var3.getCursorStack().isEmpty()) {
         if (!this.qvz(var1, var2, var3)) {
            qbo.putBack(var1, var2, var3, -1);
            this.quu(a.c(-368675, "守∻ꢖ㛮뵎㮆藏ವ阀᳁魣慬\uefc4犏\uf847窩샧伳햅受"));
            return true;
         } else {
            return false;
         }
      } else {
         int[] var5 = qvw(var4);
         if (var5 != null && ++this.que <= 120) {
            int var6 = wdq.slotId(var3, var4, var5[0]);
            if (var6 < 0) {
               return true;
            }

            Slot var7 = var3.slots.get(var6);
            int var8 = var7.getStack().getCount();
            if (var5[1] == 0) {
               vxl.click(var1, var3, var6, 0, SlotActionType.QUICK_MOVE);
               if (var7.getStack().getCount() == var8) {
                  this.quu(a.d("㵶䓅침倐\udbb0嵸\ue331橋\uf0fe稿ﶝޒ褺ᑱ麹᱗ꘙ⧍덻㔩", 2068744132, -170672409));
                  return true;
               } else {
                  return false;
               }
            } else {
               vxl.click(var1, var3, var6, 0, SlotActionType.PICKUP);

               for (int var9 = 0; var9 < var5[1]; var9++) {
                  vxl.click(var1, var3, var6, 1, SlotActionType.PICKUP);
               }

               return false;
            }
         } else {
            return true;
         }
      }
   }

   boolean qvz(MinecraftClient var1, ClientPlayerEntity var2, ScreenHandler var3) {
      ItemStack var4 = var3.getCursorStack();
      Slot var5 = null;

      for (Slot var7 : vxl.own(var3, var2.getInventory())) {
         if (var7.hasStack() && ItemStack.areItemsAndComponentsEqual(var7.getStack(), var4) && var7.getStack().getCount() < var7.getStack().getMaxCount()) {
            var5 = var7;
            break;
         }
      }

      if (var5 == null) {
         for (Slot var9 : vxl.own(var3, var2.getInventory())) {
            if (!var9.hasStack()) {
               var5 = var9;
               break;
            }
         }
      }

      if (var5 == null) {
         return false;
      }

      vxl.click(var1, var3, var5.id, 0, SlotActionType.PICKUP);
      return true;
   }

   boolean qwa(PlayerInventory var1) {
      return qpw.count(var1, Items.DIAMOND) >= 25 || qpw.count(var1, Items.GOLD_INGOT) >= this.qwb(var1) + 9 || qpw.count(var1, Items.GOLD_NUGGET) >= 9;
   }

   int qwb(PlayerInventory var1) {
      return this.qtp != null ? 15 : qpw.keepGold(var1);
   }

   void qwc(ClientPlayerEntity var1, long var2) {
      boolean var4 = this.qum;
      this.qum = false;
      if (var4 && this.needsRepair(var1)) {
         int var5 = Math.max(0, qpw.pickaxeDurability(var1));
         if (this.quo < 10 && var2 - this.qun <= 360000L) {
            if (this.qtr != null && this.qtt != 0) {
               this.quo++;
               this.quu(
                  wap.s(a.b("严㞈뵖⍢ꣷ⹋鐃ᷲ莵ऍ軈瓪\ufa6f揍\ue991漮픮嫥쁗䙒쿤떠㭇", 2042121798), a.d("\uf7a3蹮Ӊ髄ᄘ鞥ⶀꑳ㸴낟㝈촺䎗\uda59倉훻泍\ue311緎ﾂ癸࠹", -79549215, -545857685))
                     + var5
                     + wap.s(
                        a.d("柹㹼钛ધ腲ߞ붚㐮\uaa37ₒꝜ崯펵䩐쀟䛣ﳩ獻\ue9c3澟\ue67e鰨", 323932736, -93342321),
                        a.b("⥱烴\uda13䁳쮠䵤\uf734窦\ue0ec模\uedeaᏪ餥\u009b軟\u0c4f똂㦭ꌗ┱겿훤", -820434617)
                     )
               );
               this.qty = null;
               this.qus(qst.XP_TAKE, var2);
               return;
            }

            if (this.qwd(var1.getInventory())) {
               this.quo++;
               this.quu(
                  wap.s(a.d("碶ě诅ᗱ鹤ᣘꊐ⭡딦㾞롛䉹쳼啞\udf02妽\ue3bd汶\uf6c4烁亮茳ු", -1436902171, 1496704048), a.c(-871608073, "哞ⴓꞴ㦹뉥㓘軽\u070e鵉Ꮲ鐵湇\ue0ea礤\uf374疆쾰䁬\udeb3峿픅ꭄ"))
                     + var5
                     + wap.s(a.d("횱輴◓믡〧뚅\u0cd1蔲᭰釆ᘜ\uec2a抰ﬃ煍\uf7ab", 1155402103, 168484854), a.c(-1488204453, "쵶铳㸔ꑿ⿒ꤓጴ髆ҝ詏উ\uf384絋"))
               );
               this.qtu = true;
               this.qty = null;
               this.qus(qst.CRAFT, var2);
               return;
            }

            this.quu(
               wap.s(
                     a.c(-615924876, "묿슏䠓혠巺\udb50愃\ue8ea皼ﰛ箛膦ླྀ雊\u1c8b騮†꿾㕚댅㫭䂱츕嗓폥夸\ue0cf溏\uf47f爽轢ݗ贝ᓩ銧\u181bꞕ"),
                     a.c(-1844022208, "灜৬荋ᴳ隖ᐷꩵ⎋뷑㜗냀䫌쀎嶢ퟹ兿\uef52撞︨硲\uf182诒Ÿ骥ᣅ鉫⮦ꖎ㼃륑㊝챏䘎\udb93")
                  )
                  + var5
            );
         } else {
            this.quu(
               wap.s(
                     a.d("⤘債\uda6b䑟쿊䥶\uf33e竏\ue488渰\ue9f5Ꮧ鵒Ӱ躬ࠓ눓㷘ꝪⅣꢘ튍尯쟹䆕쭇狿ﲫ晙\ue015殫锣", 1913646886, 120440426),
                     a.b("\uf668辥Ԃ鬏დ陮ⱋꖸ㿿녔㚃쳱䉜\udb92凂휰洆\ue2da簉穀瞼ඒ荟\u18f7黲ᐠ귬⎾륇㭺", 1349841481)
                  )
                  + var5
                  + wap.s(
                     a.d("⟳幊퓔䪮셸䟓ﶒ瑬\uea7b悞\ue74bᴡ鏯\u0a5d聝۪벬㍠ꦁ⾝Ꙩ\udc24劀줝", -1201834184, -671592205),
                     a.c(473367621, "ѿ緆\uf378浾\ue6ab恨\uda41及짷䜣삋㫰됫ⷠꞽ┠魸ᒮ訍ࡁ膵ﯨ產\uee84棿\ue63f")
                  )
            );
         }
      }

      this.qut(var2);
   }

   boolean qwd(PlayerInventory var1) {
      return this.qts != null && this.qup < 2 && !this.qti.xpFailed() && qpw.count(var1, Items.DIAMOND_BLOCK) > 2;
   }

   boolean qwe(MinecraftClient var1, ClientPlayerEntity var2, qof var3, qsp var4, long var5) {
      PlayerInventory var7 = var2.getInventory();
      switch (this.quf) {
         case 0:
            if (var3.busy()) {
               return false;
            }

            if (var1.currentScreen != null) {
               this.qvn(var1);
               return false;
            }

            int var12 = qpw.pickaxe(var7);
            int var14 = qpw.find(var7, Items.EXPERIENCE_BOTTLE);
            if (this.needsRepair(var2) && var12 >= 0 && var14 >= 0) {
               this.qug = var12;
               int var15 = var7.getSelectedSlot();
               if (var14 < 9 && var14 != var12) {
                  var7.setSelectedSlot(var14);
                  var3.swaps(var12, 40);
               } else {
                  if (var15 == var12) {
                     var15 = var12 == 8 ? 7 : var12 + 1;
                     var7.setSelectedSlot(var15);
                  }

                  var3.swaps(var12, 40, var14, var15);
               }

               this.quf = 1;
               this.quh = var5;
               break;
            }

            if (this.needsRepair(var2) && var14 < 0 && var12 >= 0) {
               if (this.qtt != 0 && this.qtr != null) {
                  this.quu(a.b("ꔉ\udcb0嘑젒䏌셡罕\uf6db梁\ue235斜鿣ᕘ裳ʢ萫㸞놶⽦褃⃀庌퀷䮑즌䝂ﺍ炨\uea23汹\ue7c6ᥡ錪\u0ad7袖ع맯㏪따ⳳ", -1968594660));
               } else {
                  this.qum = true;
               }
            }

            return true;
         case 1:
            if (var3.busy()) {
               return false;
            }

            if (!var2.getOffHandStack().isIn(ItemTags.PICKAXES) || !var2.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE)) {
               this.quu(a.b("勠⭙ꖟ㾏됥㊖裈Ԫ齧ᗓ鉸栄\ue6dd笀\uf549玺즍䘦\udcec廞팻ꥦ⏋밈㨇낪१蜵᷏鿰ဣ\ueef1擇﵏", 1220826879));
               this.quf = 4;
               return false;
            }

            this.quf = 2;
            this.qui = qpw.durability(var2.getOffHandStack());
            this.quj = var5;
            this.quh = var5;
            this.quk = var5;
            break;
         case 2:
            if (var1.currentScreen instanceof HandledScreen) {
               this.qvn(var1);
               return false;
            }

            BlockPos var11 = qwf(var1.world, var2);
            var4.at(
               var1,
               var2,
               this,
               var11 == null ? var2.getEntityPos().add(0.0, -1.0, 0.0) : new Vec3d(var11.getX() + 0.5, var11.getY() + 0.95, var11.getZ() + 0.5)
            );
            var1.gameRenderer.updateCrosshairTarget(1.0F);
            if (var2.getPitch() >= 60.0F && qwh(var1) || var5 - this.quk > 3000L) {
               this.quf = 3;
               this.quj = var5;
               Key var13 = KeyBindingHelper.getBoundKeyOf(var1.options.useKey);
               if (!var13.equals(InputUtil.UNKNOWN_KEY)) {
                  KeyBinding.onKeyPressed(var13);
               }
            }
            break;
         case 3:
            if (var1.currentScreen instanceof HandledScreen || !qwh(var1)) {
               this.qwi(var1);
               this.qvn(var1);
               this.quf = 2;
               this.quk = var5;
               return false;
            }

            BlockPos var8 = qwf(var1.world, var2);
            var4.at(
               var1, var2, this, var8 == null ? var2.getEntityPos().add(0.0, -1.0, 0.0) : new Vec3d(var8.getX() + 0.5, var8.getY() + 0.95, var8.getZ() + 0.5)
            );
            int var9 = qpw.durability(var2.getOffHandStack());
            if (trace != null && (var5 - this.quh) % 1000L < 50L) {
               log(
                  a.b("ㆋ䠭싫岋흔凾\uebff扃ﰐ皩\uf17dୟ", -328584715)
                     + var2.getMainHandStack()
                     + a.c(-1027822192, "궵푋庑샠䭬")
                     + var2.getOffHandStack()
                     + a.b("鋅\ueb30懲ﾄ琜", 1642238688)
                     + var9
                     + a.c(1344006376, "\ue8cf鄮ᯤ薈่裲㋴")
                     + (int)var2.getPitch()
                     + a.d("⊐孴톡俆쑉", 843570811, 1289223374)
                     + var1.options.useKey.isPressed()
                     + a.d("\ud9dbꀿ⫪뒁㽑맩Ϡ", -1169222540, -1663382136)
                     + var2.isUsingItem()
               );
            }

            if (var9 > this.qui) {
               this.qui = var9;
               this.quj = var5;
            }

            if (!var2.getOffHandStack().isIn(ItemTags.PICKAXES) || var9 >= this.repairTo) {
               this.quf = 4;
               return false;
            }

            if (!var2.getMainHandStack().isOf(Items.EXPERIENCE_BOTTLE)) {
               int var10 = qpw.find(var7, Items.EXPERIENCE_BOTTLE);
               if (var10 < 0) {
                  this.qum = true;
                  this.quf = 4;
               } else if (!var3.busy()) {
                  this.qwi(var1);
                  var3.swaps(var10, var7.getSelectedSlot());
                  this.quf = 1;
               }

               return false;
            }

            our.repairing(var1);
            if (var5 - this.quj > 9000L) {
               this.quu(a.c(-1868781566, "같햪弁섊䫗졶瘸\uffc1斋\ueb5d泱隅ᡗ膜ௌ贳㌓볊≬ꐵⶵ历\uddbe䋛쒅中\uf7e1禵\ue345攖\uea26ᑳ鸪"));
               this.qtv = true;
               this.qtw = System.currentTimeMillis();
               this.quf = 4;
            } else if (var5 - this.quh > 150000L || var5 - this.qun > 360000L) {
               this.quu(
                  wap.s(
                        a.d("\ue135题ቆ豲߷腑㬗닷Ⲡꘊ↋\udbae啢쳓䚄쀾稥\uf5ef潜\ue942惹᪫鐙࿁觵̨뫟㒟깯⠭ꎝ嵇휍仹좷䈋ﶅ", 1889614717, 1004591641),
                        a.d("㾁䘱첛劕\ud947忱\ue5a8桉\uf201碷６ժ诏ሀ頫ốꓯ⬳뗠㎽빕쑻䪶턞圛\uddc9搅\uea57炮\uf293", -789627957, -1672282005)
                     )
                     + var9
               );
               this.quf = 4;
            }
            break;
         case 4:
            this.qwi(var1);
            if (var3.busy()) {
               return false;
            }

            if (var2.getOffHandStack().isIn(ItemTags.PICKAXES)) {
               var3.swaps(this.qug, 40);
            }

            this.quf = 5;
            break;
         default:
            if (var3.busy()) {
               return false;
            }

            if (!this.qum) {
               this.quu(a.b("ﭓ苠ࡋ陀ᶝ鼼ⅰꢀ㚦뱨㮾쇇优횤壧\uda02恇\ueb88", -1298202757) + Math.max(0, qpw.pickaxeDurability(var2)));
            }

            this.quf = 0;
            return true;
      }

      return false;
   }

   static BlockPos qwf(World var0, ClientPlayerEntity var1) {
      BlockPos var2 = var1.getBlockPos().down();

      for (BlockPos var4 : BlockPos.iterateOutwards(var2, 1, 0, 1)) {
         if (qwg(var0, var4)) {
            return var4.toImmutable();
         }
      }

      return null;
   }

   static boolean qwg(World var0, BlockPos var1) {
      BlockState var2 = var0.getBlockState(var1);
      return var2.isSolidBlock(var0, var1) && !var2.hasBlockEntity() && var2.createScreenHandlerFactory(var0, var1) == null;
   }

   static boolean qwh(MinecraftClient var0) {
      return var0.crosshairTarget instanceof BlockHitResult var1 && var1.getType() == Type.BLOCK ? qwg(var0.world, var1.getBlockPos()) : true;
   }

   void qwi(MinecraftClient var1) {
      if (this.qul && var1.options != null && var1.getWindow() != null) {
         var1.options.useKey.setPressed(vzz.isPhysicallyDown(var1, var1.options.useKey));
      }

      this.qul = false;
   }
}
