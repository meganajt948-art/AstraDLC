package a;

import flow.dev.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public class mkl extends kfe {
   private static mkl mkm;
   private static final String[] mkn = new String[]{
      a.d("읻뺰㑭ꨝ↽꜁ᵕ", 1386593625, -439058844), a.c(-398867590, "음뻰㐩ꨭ"), a.d("Ն", 1672504866, 1071473630), a.d("Ἓ", 615472894, -1078108042)
   };
   private static final String[] mko = new String[]{
      a.d("Ꙕ\udf9a唼쭌䃤옪簎\uf5f5", 1297984769, -879227038), a.d("삷뤋㏟궩♺", -207007531, -819817382), a.b("阠", 2097518218), a.d("骡", -878194436, 214657996)
   };
   private static final String mkp = a.d("䨟㏗른✎겣⨜", -993364463, 533739570);
   private static final String[] mkq = new String[]{
      a.c(678258110, "憔ᠤ鋽\u0cfa蝝ǫ믍㉊갗⚧ꅼ嬈헒䡶옺䃊嬨甩\uefe6榲\ue047"), a.d("\ueed1靡ᶸ菃ࠝ軛㓰뵻⍓ꧬ⹈푈媒썜䵠쿷痋晴悬", -647756837, -136910554)
   };
   private static final Pattern mkr = Pattern.compile(a.b("嵷⒲깙で뮲㵶蜊ຢ郸ᨺ鷆柮\ue93b烾歹簫왦", 644308302));
   private static final int mks = 200;
   private static final long mkt = 1500L;
   private static final long mku = 1400L;
   private static final int mkv = 4;
   private static final int mkw = 2;
   private static final int mkx = 6;
   private static final long mky = 3000L;
   private static final int mkz = 3;
   private static final int mla = 3;
   private static final int mlb = 40;
   private static final int mlc = 3;
   private static final long mld = 90000L;
   private static final long mle = 210000L;
   private static final long mlf = 2500L;
   private static final double mlg = 6.0;
   private static final long mlh = 4000L;
   private static final int mli = 4;
   private static final int mlj = 24;
   private static final int mlk = 54;
   private static final int mll = 4;
   private static final int mlm = 12;
   private static final int mln = 0;
   private static final int mlo = 1;
   private static final int mlp = 2;
   private static final int mlq = 3;
   private static final int mlr = 4;
   private static final int mls = 5;
   private static final int mlt = 6;
   private static final int mlu = 7;
   private final vkw mlv = this.add(
      new vkw(
         a.c(-26252019, "浞ᓗ鸙q"),
         new vkq(a.d("ꉉ\udbdf儙콻䒪", 1973474591, -1540000000), vhz.PLAY, this::mnt),
         new vkq(a.d("㜂五쑜娲", -1654698555, 244546192), vhz.PAUSE, this::mnu)
      )
   );
   private final vkw mlw = this.add(
      new vkw(a.d("ᇱ桽\ue2bf糆\uf75c熡쯷䈜\udc44", -974761284, 988889869), new vkq(a.d("ङ炉練搻\uefb8楅팓嫸쒠", 1941377565, -1064494264), vhz.PENCIL, hrt::open))
   );
   private final vkl mlx = this.add(new vkl(a.c(1181572352, "嵈ⓘ긐ぼ뮤㴊"), true));
   private final pgb mly = new pgb();
   private final pgi mlz = new pgi();
   private final piq mma = new piq();
   private final piq mmb = new piq();
   private final piq mmc = new piq();
   private final piq mmd = new piq();
   private final piq mme = new piq();
   private final piq mmf = new piq();
   private final vyn mmg = new vyn();
   private pdr mmh;
   private boolean mmi;
   private String mmj = "";
   private boolean mmk;
   private int mml;
   private int mmm;
   private final Map<pdr, Long> mmn = new HashMap<>();
   private boolean mmo;
   private double mmp = 6.0;
   private long mmq = System.currentTimeMillis();
   private int mmr = -1;
   private SlotActionType mms = SlotActionType.field_7790;
   private boolean mmt;
   private int mmu;
   private int mmv;
   private int mmw;
   private int mmx;
   private int mmy = -1;
   private int mmz;
   private int mna;
   private int mnb;
   private ItemStack mnc = ItemStack.field_8037;
   private boolean mnd;
   private int mne;
   private boolean mnf;
   private int mng = -1;
   private final int[] mnh = new int[8];
   private boolean mni;
   private int mnj;
   private int mnk;
   private int mnl = -1;
   private float mnm;
   private float mnn;
   private volatile boolean mno;
   private volatile boolean mnp;
   private volatile boolean mnq;

   public mkl() {
      super(a.d("쩒돗㤅ꝯⲔꨉၙ馨߾赉ઍ\uf0e7縭", -1878110017, 143825569), a.c(-319571899, "렚솜䭃픸庼\ud854我\uebfa疢ａ磞芪౧闑ᾓ饣⍨곰㙞뀞㧡䎮쵎囐킮娱\ue38d涒\uf76c"), kfa.PLAYER);
      mkm = this;
   }

   public static mkl get() {
      return mkm;
   }

   public static pdr collecting() {
      mkl var0 = mkm;
      return var0 != null && var0.isEnabled() ? var0.mmh : null;
   }

   public static boolean busy() {
      mkl var0 = mkm;
      return var0 != null && var0.isEnabled() && var0.mmh != null;
   }

   public static void onMessage(Text var0) {
      mkl var1 = mkm;
      if (var1 != null && var1.isEnabled() && var1.mmh != null && var0 != null) {
         String var2 = var0.getString().toLowerCase();
         if (var2.contains(a.b("\uf3ac訒½麰ᄅ鏖⧹ꀄ㹙뒘㜫줹䞛\ude29偯튄梲\ue71f綫ﯹ爍", -20908044))) {
            var1.mno = true;
         } else if (var2.contains(a.b("𢡊荶ධ鞤ᰄ骷ₖꤕ㝏붉㸸쁕亀휲嵩\udbef", 525139682))) {
            var1.mnp = true;
         } else if (var2.contains(a.d("ž磇\uf215汮\ue7c6慴\udb26劫쳶䙊얉㯪넯⳾ꛘ\u202a驫ᖾ輄ീ蓶ﺠ瀞", -390815373, 257205287))) {
            var1.mnq = true;
         }
      }
   }

   @Override
   protected void onEnable() {
      this.mpd();
      this.mpl(
         wap.s(
            a.b("\ue2e9魺ᆾ这Ў苬㣌넚⽐ꗲ∧\ud80c囕켍䕣쏆秋\uf60d沲\ueae9捍᥈韧\u0c3b訁\u0093뤫㝷궄⯄ꁢ庥퓭䵈쭝䇣︩瑘\uf296欠\ue176鿀ᗟ鉭ࢡ蛗㽗闒㎩\ua82f♊\udc8e售퍴䧏쟇籮瘟烑\ue952枧᷵騋ၗ躗ܫ뵾", 2019549946),
            a.c(
               -1600154473,
               "郄\ue958掍ﷶ瘥\uf0ee䫊윮姺ퟷ倃ꩽⓖ뵥㜵놾\u0b8b葔ᨐ鳔ᔭ歍\ue5da繾\uf810狒켃䔳\udfb5姨투ⲃꋙ㼼륮㎢豬پ胔ᤛ靑\uedbf柭\ue056竰\uf4fa䴣쟩䆠\uda00呾ꪺ✖ꅂ㯍떕ੁ겤ۣ魓ᖞ濁\ue833扮ﳛ甝쭛䦽쏭塌횎僾ꤪ⎐뷎㙃끫\u0ad8"
            )
         ),
         true
      );
   }

   @Override
   protected void onDisable() {
      this.mpd();
      this.mmg.release(this.mc);
      this.mny();
   }

   private void mnt() {
      if (this.mc.field_1724 != null) {
         if (!this.isEnabled()) {
            this.setEnabled(true);
         }

         if (pej.activeCount() == 0) {
            this.mpl(
               wap.s(
                  a.c(1372339142, "㮳䈾죠囔\udd4f寻\ue1b2桄\uf64f粶ﭬď辋ᙴ鰦᪘ꂞ⽒뗰㎩멀쁂亢핷化\ud9da恾\uee24瓞\uf28e祹蟧ඩ"),
                  a.c(271671869, "昈ᮋ锹ଶ胦خ밆㗸꾲℞ꛅ墡퉤䯝솏䜋﵍狮\ue855渇\ue3ee鶢ጔ賝ຼ葧㷝뎏⥵꼩₄\uda4a偺짾侬씕立\uf0cd癬")
               ),
               false
            );
         } else {
            this.mmi = true;
            this.mmn.clear();
            this.mlz.reset();
            this.mmh = null;
            this.moz();
            this.mme.arm(this.mlz.draw(0));
         }
      }
   }

   private void mnu() {
      if (this.mmh != null || this.mmi) {
         this.mpc();
         this.mpl(wap.s(a.c(-1332698800, "ꄄ\ud892剚찴䟣셇笕"), a.c(-283805843, "獟૾耬Ṓ闹ጺ굹ₖ뺶㐄뎥䧙윍庰퓪刕\ue852枎")), false);
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.mmg.release(var1);
      if (var1.field_1724 != null) {
         if (this.mmh != null && var1.field_1755 instanceof HandledScreen) {
            this.mmg.hold(var1);
         }

         this.mnx(var1);
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (var1.field_1724 != null && var1.field_1687 != null) {
         if (!(var1.field_1755 instanceof GenericContainerScreen)) {
            this.mmy = -1;
            this.mmr = -1;
         }

         this.mnw();
         if (this.mmh == null) {
            this.mpb();
         } else if (!this.mpk(var1)) {
            if (var1.field_1724.method_31548().method_7376() == -1) {
               this.mpl(
                  wap.s(
                     a.b("ᑪ淺\ue766祑\uf292琴칧䟓\ud9c5即풸⻚ꀆ㦭돥㔉轍Å騥ᱫ閟\uefd5慡", -431287245),
                     a.d("颓\ue10a殮\uf1bd縋\uf8c9䊖쭨唸\udf83塙ꉞⲇ녓㽡맪Π谍ᛂ邟ᵺ挹\ue998癑\uf02b竵썁䴘힐决\uda70ⓔ", 446539183, 1534867713)
                  ),
                  false
               );
               this.mpj();
               this.mpc();
            } else {
               this.mpe(false);
               this.mnv();
            }
         }
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      if (this.mmh != null && var1.field_1724 != null) {
         if (var1.method_61964() != null) {
            var1.method_61964().method_61939();
         }

         this.mnv();
      }
   }

   private void mnv() {
      if (this.mmh != null && !this.mmj.isEmpty() && this.mc.field_1724 != null && this.mc.method_1562() != null) {
         if (this.mc.field_1755 instanceof GenericContainerScreen var1) {
            this.moa(var1);
         } else if (this.mc.field_1755 == null && this.mnj <= 0) {
            if (this.mc.field_1724.field_6012 >= 200 && this.mme.ready()) {
               if (this.mmm >= 3) {
                  this.mon();
               } else if (this.mph()) {
                  this.mc.method_1562().method_45730(a.b("\ueacd鍵᧮蟌\u0c0d誸ヸ뤘❌궵", -1430000986) + this.mmj);
                  this.mme.arm(this.mlz.draw(4, this.mpi()));
                  this.mml = 0;
                  this.mmm++;
               }
            }
         }
      }
   }

   private void mnw() {
      if (this.mnq) {
         this.mnq = false;
         this.mnj = ThreadLocalRandom.current().nextInt(24, 54);
         this.mnk = 0;
      }

      if (this.mno) {
         this.mno = false;
         this.mmm = Math.max(0, this.mmm - 1);
         this.moq();
      }

      if (this.mnp) {
         this.mnp = false;
         if (this.mmh != null) {
            this.mpl(wap.s(a.c(1184143787, "駨\ue063檱\uf494缌領䎡쨓呀\udef7夣ꍏ"), a.b("䂞㤇럁ⷕꙵ\u20c6髧፤贾߸葉稤\uf4f1浃\ue718憞\udfb3呿컁䲀셧물㖏깔⡘ꋷᬻ锝", -1318632289)), false);
            this.mpj();
            this.mpc();
         }
      }
   }

   private void mnx(MinecraftClient var1) {
      if (this.mnj > 0) {
         if (var1.field_1755 != null) {
            this.mnj = 0;
            this.mny();
         } else {
            this.mnj--;
            ThreadLocalRandom var2 = ThreadLocalRandom.current();
            if (--this.mnk <= 0) {
               this.mnk = var2.nextInt(4, 12);
               this.mnl = var2.nextInt(5);
            }

            KeyBinding[] var3 = mnz(var1.field_1690);

            for (int var4 = 0; var4 < var3.length; var4++) {
               var3[var4].method_23481(this.mnl == var4);
            }

            this.mnm = this.mnm * 0.85F + (float)var2.nextGaussian() * 0.9F;
            this.mnn = this.mnn * 0.85F + (float)var2.nextGaussian() * 0.45F;
            float var6 = var1.field_1724.method_36455();
            float var5 = !(var6 + this.mnn > 80.0F) && !(var6 + this.mnn < -80.0F) ? this.mnn : -this.mnn;
            var1.field_1724.method_5872(this.mnm / 0.15, var5 / 0.15);
            if (this.mnj == 0) {
               this.mny();
            }
         }
      }
   }

   private void mny() {
      if (this.mnl >= 0 && this.mc.field_1690 != null && this.mc.method_22683() != null) {
         this.mnl = -1;

         for (KeyBinding var4 : mnz(this.mc.field_1690)) {
            var4.method_23481(vzz.isPhysicallyDown(this.mc, var4));
         }
      }
   }

   private static KeyBinding[] mnz(GameOptions var0) {
      return new KeyBinding[]{var0.field_1894, var0.field_1881, var0.field_1913, var0.field_1849};
   }

   private void moa(GenericContainerScreen var1) {
      ScreenHandler var2 = var1.method_17577();
      String var3 = pfl.title(var1.method_25440().getString());
      if (var2.field_7763 != this.mmy) {
         this.mmy = var2.field_7763;
         this.mmb.arm(this.mlz.draw(0));
         this.mmd.restart();
         if (this.mmr >= 0) {
            this.mmt = true;
            this.mmu = 0;
            this.mmv = 0;
            this.mmr = -1;
         }
      } else if (vyn.serverIdle(this.mc.field_1724)) {
         if (mob(var3)) {
            if (this.mnd) {
               if (this.mma.elapsed(1400L)) {
                  this.mnd = false;
                  if (++this.mne >= 4) {
                     this.mpl(
                        wap.s(
                           a.b("狴\u0b64臸Ή鐋\u12b6ꢼℏ뽇㗷눤䡎욘彧핽压\ue98a昏ﲠ竼\uf34e襜ߣ鰳ᩄ邚⤲ꝼ㷆므ね캻䓾\udd04孏", 796029593),
                           a.d("Ꝭ\udaef吢쩗䆇윾祸\uf496櫈\ue073柖鷗ጇ諃æ蘕㱛뎂⤴꼒⊊峆퉽䧛쯆䔍ﲹ狫\ue81d湉\ue5f8ἱ酡\u0891軆Ў뮥㇑뜀", -1140360583, -337127136)
                        ),
                        false
                     );
                     this.mne = 0;
                     this.mpj();
                  }
               }
            } else {
               if (this.mmb.ready() && this.mma.ready()) {
                  Slot var8 = moj(mor(var2), a.c(56465371, "鏧\uea2f悀ﻶ畛\uf3e4"));
                  if (var8 != null) {
                     this.mop(var2, var8.field_7874, SlotActionType.field_7794);
                     this.mnd = true;
                  } else if (++this.mne >= 4) {
                     this.mpl(
                        wap.s(
                           a.b("ꋱ\udb61函쿎䐎슳碹\uf10a潂\ue5f2戡顋\u169d轢ո莎㦏똊ⲥ\uaaf9⍋奙ퟦ䰶쩁䂟路睹\uedc3毅\ue068Ế铻ഁ譊", -1459379556),
                           a.b("샸뵻㎶귃☓ꂪỬ錂൜蟧B暑璓\ued57杲\ue181寏퐖亠좆䔞㭒뗩⹏걒⊙鬭ᕿ辉ঢ়艬碥\uf6f5漅\ue952掚\udc31噅킔", 1158071501)
                        ),
                        false
                     );
                     this.mne = 0;
                     this.mpj();
                  }

                  this.mma.arm(this.mlz.draw(3));
               }
            }
         } else if (!var3.contains(pfl.title(this.mmj))) {
            this.mpj();
         } else {
            this.mnd = false;
            this.mne = 0;
            if (this.mnf) {
               if (var2.field_7763 == this.mng && !this.mma.elapsed(1400L)) {
                  return;
               }

               this.mnf = false;
               this.mpe(true);
               if (this.mmz < this.mmh.count()) {
                  this.mpj();
                  this.mme.arm(this.mlz.draw(6));
                  return;
               }
            }

            if (this.mmz >= this.mmh.count()) {
               if (this.mma.ready()) {
                  this.mpl(
                     wap.s(a.b("顶\ue1eb欻\uf54a纔\uf823䉧쮇嗙\udf36壿", -17786818), a.d("佳㚝밻≋ꦔ⼬锈ᢛ芥\u086b辷疷\ufb10抬\uecf8樓", -1969955191, 813012469)) + this.mmh.name(),
                     true
                  );
                  this.moz();
                  this.mpj();
               }
            } else if (this.mmb.ready() && this.mma.ready()) {
               int[] var4 = moe(var2, var3);
               int var5 = var4[0];
               int var6 = var4[1];
               boolean var7 = !moc(mor(var2)) || var6 > 1 && !moc(mos(var2)) || var4[2] == 0 && (this.mly.target() != null || this.mmr >= 0);
               if (var7) {
                  if (this.mmd.elapsed(3000L)) {
                     this.mom();
                  }
               } else {
                  this.mmd.restart();
                  if (!this.mog(var5)) {
                     Arrays.fill(this.mnh, 0);
                     this.mma.arm(this.mlz.draw(1));
                     this.mod(var2, var5, var6);
                  }
               }
            }
         }
      }
   }

   private static boolean mob(String var0) {
      for (String var4 : mkq) {
         if (var0.contains(var4)) {
            return true;
         }
      }

      return false;
   }

   private static boolean moc(List<Slot> var0) {
      for (Slot var2 : var0) {
         if (!var2.method_7677().method_7960()) {
            return true;
         }
      }

      return false;
   }

   private void mod(ScreenHandler var1, int var2, int var3) {
      int var4 = Math.min(16, var3);
      pfw var5 = this.mly.target();
      if (var5 != null) {
         if (var5.page() > var3) {
            this.mpl(
               wap.s(a.c(2070835536, "焛\u0896艈ᱼ韧ᅕ\uab1d⊸벮㘅놅䮳앬峜횄值\uea7f旽～礍\uf0f5誤А鿆ᦰ錦⫔ꒃ㹲렫㎟"), a.c(-635210175, "牅ம腽ώ铟ᘎꡂ⇌뿭㕝늁䣻숻宆헊匱\ue90b暯ﱨ穂\uf3bf解ݕ鳼᪀遜")), false
            );
            this.moq();
         } else if (var2 == var5.page()) {
            Slot var11 = null;
            int var12 = Integer.MAX_VALUE;

            for (Slot var9 : mos(var1)) {
               if (this.mou(var9.method_7677())) {
                  int var10 = pfd.of(var9.method_7677());
                  if (var10 <= var5.price() && var10 < var12) {
                     var11 = var9;
                     var12 = var10;
                  }
               }
            }

            if (var11 != null) {
               this.moo(var1, var11.field_7874);
            } else {
               this.mpl(
                  wap.s(
                     a.d("\uea8c錁᧟蟫\u0c70諂り뤯✹궒⨒퀤廻읋䴓쮫燨﹪擉\ue29a止ᄳ龇ё舧ࢱ녃㼔ꗥ⎼ꠈ", -984192554, -808877295),
                     a.d("䛳㼘뗋⯋ꁩ⊸鳴ᕺ譛ǫ蘷籍\uf68d漰\ue17c枇\uddbd则죞仴윉뵕㏣ꡊ⸶ꓪ", 1913060220, -1564034677)
                  ),
                  false
               );
               if (this.mly.dropTarget() == null) {
                  this.mom();
               }
            }
         } else {
            this.moh(var1, var2, var2 < var5.page() ? mkn : mko);
         }
      } else {
         if (this.mly.markPage(var2)) {
            for (Slot var7 : mos(var1)) {
               if (this.mou(var7.method_7677())) {
                  this.mly.offer(var2, pfd.of(var7.method_7677()));
               }
            }
         }

         if (var2 >= var4 || var2 >= 3 && this.mly.enough()) {
            if (!this.mly.choose(var2)) {
               this.mom();
            }
         } else {
            this.moh(var1, var2, mkn);
         }
      }
   }

   private static int[] moe(ScreenHandler var0, String var1) {
      int[] var2 = mof(var1);
      if (var2 == null) {
         for (Slot var4 : mot(var0)) {
            ItemStack var5 = var4.method_7677();
            if (!var5.method_7960()) {
               var2 = mof(pfl.title(var5.method_7964().getString()));
               if (var2 != null) {
                  break;
               }
            }
         }
      }

      if (var2 == null) {
         return new int[]{1, 1, 0};
      } else {
         int var6 = Math.max(1, var2[1]);
         return new int[]{Math.min(Math.max(1, var2[0]), var6), var6, 1};
      }
   }

   private static int[] mof(String var0) {
      Matcher var1 = mkr.matcher(var0);

      while (var1.find()) {
         try {
            return new int[]{Integer.parseInt(var1.group(1)), Integer.parseInt(var1.group(2))};
         } catch (NumberFormatException var3) {
         }
      }

      return null;
   }

   private boolean mog(int var1) {
      if (this.mmr < 0) {
         return false;
      } else if (var1 != this.mmr) {
         this.mmr = -1;
         this.mmt = true;
         this.mmu = 0;
         this.mmv = 0;
         return false;
      } else if (this.mmc.elapsed(1500L)) {
         this.mmr = -1;
         this.mmv++;
         if (!this.mmt && ++this.mmu >= 2) {
            this.mms = this.mms == SlotActionType.field_7790 ? SlotActionType.field_7794 : SlotActionType.field_7790;
            this.mmu = 0;
         }

         return false;
      } else {
         return true;
      }
   }

   private void moh(ScreenHandler var1, int var2, String[] var3) {
      if (this.mmv < 3 && ++this.mmw <= 40) {
         Slot var4 = moi(var1, var3);
         if (var4 == null) {
            this.mok(var1);
         } else {
            this.mmx = 0;
            this.mop(var1, var4.field_7874, this.mms);
            this.mmr = var2;
            this.mmc.restart();
            this.mma.arm(this.mlz.draw(2));
         }
      } else {
         this.mpl(
            wap.s(
               a.b("띅컈䐖\uda22冥휅浐\ue4a3竫\uf008瞟跥̸骟ბ险Ⱶꏰ㤑뽗㚶䳤쉈妘\udfed啴\ueccb拉\uf828繽\uf5ddଝ腙ᢩ黽ᑅꯕ⇥ꜰ㺇듐쨦", 1092532027),
               a.d("ᆋ栙\ue2b3糁\uf764燞쮌䉷\ud838嚔텏⼫ꗢ㰯똌ヺ談ա鿗᧱鑨\uee35撞＾祋\uf7f9䩝쐋廱\ud8a3匜귁", -16945713, -1135380353)
            ),
            false
         );
         this.mom();
      }
   }

   private static Slot moi(ScreenHandler var0, String[] var1) {
      for (String var5 : var1) {
         Slot var6 = moj(mot(var0), var5);
         if (var6 != null) {
            return var6;
         }
      }

      return moj(mos(var0), var1[0]);
   }

   private static Slot moj(List<Slot> var0, String var1) {
      for (Slot var3 : var0) {
         ItemStack var4 = var3.method_7677();
         if (!var4.method_7960() && pfl.title(var4.method_7964().getString()).contains(var1)) {
            return var3;
         }
      }

      return null;
   }

   private void mok(ScreenHandler var1) {
      if (++this.mmx < 6) {
         this.mma.arm(this.mlz.draw(2));
      } else {
         this.mpl(
            wap.s(
               a.d("瑤෴蝨᥉銏ᐸ깩⟝맀㍦뒴仅쀉妹폷啕\uef53悅喝籽\uf596迊ļ骺᳛阍⾴ꇮ㬁", -1777782288, -238074425),
               a.c(-1825855575, "ꎙ\ude1a僗캢䕲쏋綍\uf061渶\ue4f0杁餪\u17fa蹈К苮㢣덪ⷂꮐ∞塌획䵑쬫䆍ﱑ癡\uec95櫆\ue105Ῑ間జ")
            ),
            false
         );
         this.mmx = 0;
         this.moq();
         Slot var2 = this.mol(var1);
         if (var2 != null) {
            this.moo(var1, var2.field_7874);
         } else {
            this.mom();
         }
      }
   }

   private Slot mol(ScreenHandler var1) {
      int var2 = Integer.MAX_VALUE;

      for (Slot var4 : mos(var1)) {
         if (this.mou(var4.method_7677())) {
            var2 = Math.min(var2, pfd.of(var4.method_7677()));
         }
      }

      if (var2 == Integer.MAX_VALUE) {
         return null;
      } else {
         int var9 = this.mmh.count() - this.mmz;
         Slot var10 = null;
         Slot var5 = null;

         for (Slot var7 : mos(var1)) {
            if (this.mov(var7.method_7677()) == 0) {
               int var8 = pfd.of(var7.method_7677());
               if (var8 <= var2 * 2) {
                  if (var5 == null || var8 < pfd.of(var5.method_7677())) {
                     var5 = var7;
                  }

                  if (var7.method_7677().method_7947() >= var9 && (var10 == null || var8 < pfd.of(var10.method_7677()))) {
                     var10 = var7;
                  }
               }
            }
         }

         return var10 != null ? var10 : var5;
      }
   }

   private void mom() {
      this.moq();
      this.mpj();
      String var1 = this.mmh.item().method_63680().getString();
      if (this.mml == 0 && !this.mmk && !this.mmh.hasQuery() && !var1.equalsIgnoreCase(this.mmj)) {
         this.mmk = true;
         this.mmj = var1;
         this.mmm = 0;
         this.mpl(
            wap.s(
                  a.d("騰\ue3b7楠\uf702糄奄䀬짚垌\udd7a嫫ꂁ⸏럪㶥뭙œ軋ᑥ鈥ᯚ懆\uef3b瓥\uf296硏솣俨", -1303104056, -234573897),
                  a.d("䚽㽝떄⾖ꁞ⛮颣ᕏ謝ƫ虽簎\uf2d4歠\ue145揚\udd8a判죢亲읍봕㏑ꡲ⨇ꃌ", -1123868379, 382296986)
               )
               + var1,
            false
         );
      } else if (this.mmm >= 3) {
         this.mon();
         return;
      }

      this.mme.arm(this.mlz.draw(4, this.mpi()));
   }

   private void mon() {
      this.mmn.put(this.mmh, System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(90000L, 210000L));
      this.mpl(
         wap.s(a.b("寑≁\ua8dd㛪봲㮞臍ࠡ陹᳁魕慨\uefbc瘖ﰋ章", -155231345), a.c(512810331, "\ud950ꃉ⩭끾㾶뤆͟諟ᓻ鹀᧨\ue39f洴\uf483绝ﰲ䉦춲坽텞岣⛨")) + this.mmh.name() + this.mox(), false
      );
      this.moz();
   }

   private void moo(ScreenHandler var1, int var2) {
      this.mop(var1, var2, SlotActionType.field_7794);
      this.mng = var1.field_7763;
      this.mma.arm(this.mlz.draw(3));
      this.mme.arm(this.mlz.draw(6));
      this.moq();
      this.mnf = true;
      this.mmm = 0;
      this.mna = 1;
   }

   private void mop(ScreenHandler var1, int var2, SlotActionType var3) {
      this.mc.field_1761.method_2906(var1.field_7763, var2, 0, var3, this.mc.field_1724);
   }

   private void moq() {
      this.mly.release();
      this.mmr = -1;
      this.mmv = 0;
      this.mmw = 0;
      this.mmx = 0;
   }

   private static List<Slot> mor(ScreenHandler var0) {
      int var1 = var0 instanceof GenericContainerScreenHandler var2 ? var2.method_17388() * 9 : var0.field_7761.size();
      return var0.field_7761.subList(0, Math.min(Math.max(var1, 0), var0.field_7761.size()));
   }

   private static List<Slot> mos(ScreenHandler var0) {
      List var1 = mor(var0);
      return var1.size() > 9 ? var1.subList(0, var1.size() - 9) : var1;
   }

   private static List<Slot> mot(ScreenHandler var0) {
      List var1 = mor(var0);
      return var1.size() > 9 ? var1.subList(var1.size() - 9, var1.size()) : var1;
   }

   private boolean mou(ItemStack var1) {
      int var2 = this.mov(var1);
      if (this.mmh != null && var1.method_31574(this.mmh.item())) {
         this.mnh[var2]++;
         this.mml++;
      }

      return var2 == 0;
   }

   private int mov(ItemStack var1) {
      if (var1.method_7960() || this.mmh == null || !this.mmh.matches(var1, new pey(var1))) {
         return 1;
      } else if (!this.mmh.hasEffects()
         && !this.mnc.method_7960()
         && !Objects.equals(var1.method_58694(DataComponentTypes.field_49651), this.mnc.method_58694(DataComponentTypes.field_49651))) {
         return 2;
      } else if (pfd.claimed(var1)) {
         return 3;
      } else if (pfd.of(var1) <= 0) {
         return 4;
      } else if (var1.method_7947() > this.mnb) {
         return 7;
      } else if (this.mmh.item() == Items.field_8288 && !this.mmh.hasAttrs() && var1.method_7958()) {
         return 5;
      } else {
         Integer var2 = (Integer)var1.method_58694(DataComponentTypes.field_49629);
         int var3 = var1.method_7936();
         if (var2 == null || var3 <= 0) {
            return 0;
         } else if (this.mmh.item() == Items.field_8833) {
            return (float)(var3 - var2) / var3 >= 0.5F ? 0 : 6;
         } else if (!mow(var1)) {
            return 0;
         } else {
            boolean var4 = false;

            for (phm var6 : this.mmh.rules()) {
               if (var6.state() == phj.ON && Enchantments.field_9101.method_29177().toString().equals(var6.key())) {
                  var4 = true;
               }
            }

            return !var4 && !((float)(var3 - var2) / var3 >= 0.7F) ? 6 : 0;
         }
      }
   }

   private static boolean mow(ItemStack var0) {
      EquippableComponent var1 = (EquippableComponent)var0.method_58694(DataComponentTypes.field_54196);
      return var1 != null && var1.comp_3174().method_46643();
   }

   private String mox() {
      StringBuilder var1 = new StringBuilder();
      moy(var1, wap.s(a.c(1455050095, "䵁㑧븣‑ꯊ\u2d7a霣ở肝\u0a31跤瞔丹悼"), a.b("겼햚忞엌丙죒犄ﭹ攬\uefea汖", -2024887145)), this.mnh[1]);
      moy(var1, wap.s(a.b("曕ῳ閷உ聅ۨ벶㕐ꭝ↼꙰尚틐䭧섵䞊", -596941083), a.b("䕌㱪똮ⱋ\ua7e8⅚魹ኅ賑ɵ膱篂\uf51b泝\ue6f7搓", 111691132)), this.mnh[2]);
      moy(var1, wap.s(a.c(1289702311, "䮕㊳룷⛇괝⮲釶᠃虙\u0cf5譿煌ﾖ昽\uec7c檂탑彔"), a.b("毡\u12c7颃ʑ褳ཱྀ뇇㰬ꈊ⣇꼐啯\udbb0䘜", -300586033)), this.mnh[3]);
      moy(var1, wap.s(a.c(2779161, "栵ᄓ魗ը躾ࡀ뉃㮰ꗴ⽏ꢚ劮"), a.d("ஞ犸\uf8fc抐\ue94f澉톸尯숃䢺켟ㄅ", -1438808826, 267620020)), this.mnh[4]);
      moy(var1, wap.s(a.c(1239970630, "獯\u0a49耍ḻ闧ፓ꤇⃬뻧"), a.d("㑭䵋윏嵯횲倍\uea2a掠痢", 749517292, 439455144)), this.mnh[5]);
      moy(var1, wap.s(a.c(-2004854563, "壳⇕ꮑ㖤빢㣔芔୦锲ᾆ顐戼\uece6甎"), a.d("蹻\uf75d紙\ue777泟\uea10债\ud9b1䟭촣䫳낌㨷", -1836982776, 1741246558)), this.mnh[6]);
      moy(var1, wap.s(a.c(-815692724, "葠﵆眂\ue93f拫\ue441幆ퟤ䦡쌃䓏뻻"), a.b("燆࣠芤ᢵ錒ᖤ꿼☄렮㛿딷佃쇨堫홨", -145853975)), this.mnh[7]);
      return var1.toString();
   }

   private static void moy(StringBuilder var0, String var1, int var2) {
      if (var2 > 0) {
         var0.append(var1).append(var2);
      }
   }

   private void moz() {
      List var1 = pej.items();
      int var2 = this.mmh == null ? 0 : var1.indexOf(this.mmh) + 1;
      this.moq();
      this.mne = 0;
      this.mnd = false;
      this.mnf = false;
      this.mmm = 0;
      this.mmk = false;
      this.mml = 0;
      this.mmh = this.mpa(var1, Math.max(0, var2));
      this.mme.arm(this.mlz.draw(5));
      if (this.mmh != null) {
         this.mmj = this.mmh.query();
         this.mmo = false;
         this.mpe(true);
         this.mpl(wap.s(a.d("屺◧꼷ㅆ몘㰯虫྇釟᭧鳩暂", 1859113898, 1222741919), a.c(-275535980, "ꎿ\uda11働캵䔚쏛禍\uf075樬\ue087")) + this.mmh.name(), true);
      } else {
         this.mmj = "";
         if (this.mmn.isEmpty()) {
            if (this.mmi) {
               this.mpl(
                  wap.s(
                     a.d("ᠢ憠\ueb60甆ﻚ硦숩䯙햁弹\ud8ad⊕걘㖺뾪㥗茛ೊ陰ဧ駇\ue387洵", -1425292547, 1663752845),
                     a.b("鎞\uea7c惛謹畷\uf3b9䦟쁯常풀匤\ua95c⏠븰㐜닢ࣜ蝽᷃鯤ᙴ氩\ue6fa絛ﬥ燻젴䘗\ud8f0媶턂⿑ꖙ㰝멆り轕ԩ", -999450710)
                  ),
                  true
               );
            }

            this.mmi = false;
         } else if (!this.mmo) {
            this.mmo = true;
            this.mpl(
               wap.s(
                  a.d("爘\u0b84腗Ὢ铱\u1249ꠙ⇺뿱㔉닇䢧외志헗卧\ue93b曽ﰋ稊\uf3f8覨ݏ鳑ᪧ遶⦏\ua7d2㵧묵や칝䑙\uddfc宴텊滉\ue4a4扺\ufbc3燑ཬ蔲ʖ顐ᘶ", -1074065957, 77627308),
                  a.b("旒ᰰ隗ೳ荅\u05f7뾦㘩ꡲ⋁ꄊ彥퇎䠆쉐䒩ﻥ焼\uebf9槏\ue034鹷Ⴣ譧\u0d65蟊㹻뀧⺼곷⍞\ud992变쨭䡢워礚\uf362疰\uec02", -1112055320)
               ),
               true
            );
         }
      }
   }

   private pdr mpa(List<pdr> var1, int var2) {
      long var3 = System.currentTimeMillis();
      this.mmn.values().removeIf(var2x -> var2x <= var3);

      for (int var5 = 0; var5 < var1.size(); var5++) {
         pdr var6 = (pdr)var1.get((var2 + var5) % var1.size());
         if (var6.active() && !this.mmn.containsKey(var6) && this.mpf(var6) < var6.count()) {
            return var6;
         }
      }

      return null;
   }

   private void mpb() {
      if (this.mmi && !this.mmn.isEmpty() && this.mmf.elapsed(2500L)) {
         this.mmf.restart();
         this.moz();
      }
   }

   private void mpc() {
      this.mmh = null;
      this.mmi = false;
      this.mmo = false;
      this.mmj = "";
      this.mmn.clear();
      this.moq();
      this.mnd = false;
      this.mnf = false;
      this.mmm = 0;
      this.mmk = false;
      this.mml = 0;
   }

   private void mpd() {
      this.mpc();
      this.mms = SlotActionType.field_7790;
      this.mmt = false;
      this.mmu = 0;
      this.mne = 0;
      this.mmy = -1;
      this.mnj = 0;
      this.mnk = 0;
      this.mnm = 0.0F;
      this.mnn = 0.0F;
      this.mni = false;
      this.mmz = 0;
      this.mna = 0;
      this.mnb = 0;
      this.mnc = ItemStack.field_8037;
      this.mno = false;
      this.mnp = false;
      this.mnq = false;
   }

   private void mpe(boolean var1) {
      if (this.mmh != null && (var1 || --this.mna <= 0)) {
         this.mna = 4;
         this.mmz = this.mpf(this.mmh);
         this.mnc = this.mmh.isPotion() && !this.mmh.hasEffects() ? this.mpg(this.mmh) : ItemStack.field_8037;
         int var2 = this.mmh.count() + Math.round(this.mmh.count() * 0.2F);
         this.mnb = Math.max(var2 - this.mmz, this.mmh.count());
      }
   }

   private int mpf(pdr var1) {
      if (this.mc.field_1724 == null) {
         return 0;
      } else {
         PlayerInventory var2 = this.mc.field_1724.method_31548();
         int var3 = 0;

         for (int var4 = 0; var4 < 41; var4++) {
            ItemStack var5 = var2.method_5438(var4);
            if (!var5.method_7960() && var1.matches(var5)) {
               var3 += var5.method_7947();
            }
         }

         return var3;
      }
   }

   private ItemStack mpg(pdr var1) {
      PlayerInventory var2 = this.mc.field_1724.method_31548();

      for (int var3 = 0; var3 < 41; var3++) {
         ItemStack var4 = var2.method_5438(var3);
         if (!var4.method_7960() && var1.matches(var4)) {
            return var4;
         }
      }

      return ItemStack.field_8037;
   }

   private boolean mph() {
      long var1 = System.currentTimeMillis();
      this.mmp = Math.min(6.0, this.mmp + (var1 - this.mmq) / 4000.0);
      this.mmq = var1;
      if (this.mmp < 1.0) {
         return false;
      } else {
         this.mmp--;
         return true;
      }
   }

   private double mpi() {
      return 1 << Math.min(this.mmm, 3);
   }

   private void mpj() {
      this.mmr = -1;
      this.mmx = 0;
      this.mmy = -1;
      ClientPlayerEntity var1 = this.mc.field_1724;
      if (var1 != null && this.mc.field_1755 instanceof GenericContainerScreen) {
         var1.method_7346();
      }
   }

   private boolean mpk(MinecraftClient var1) {
      boolean var2 = vzz.isDown(var1, 256);
      if (var1.field_1755 instanceof hlc) {
         this.mni = var2;
         return false;
      } else if (var2 && !this.mni) {
         this.mni = true;
         this.mpc();
         this.mpl(wap.s(a.c(626807961, "哄ⵒꞚ㧴눣㒇軕ݠ饽Ꮧ鑝湉\ue0a8礉"), a.d("镒\uecf3昡\uf85f珴\uf537䭴욛墻툉喨꿔℀뢽㋧되\u0e5f膃ἠ饹უ檄\ue427羼", 722292640, -1959403830)), false);
         return true;
      } else {
         this.mni = var2;
         return false;
      }
   }

   private void mpl(String var1, boolean var2) {
      if (this.mlx.get()) {
         izx.alert(this.getName(), var1, var2 ? vhz.CHECK : vhz.INFO, var2);
      }
   }
}
