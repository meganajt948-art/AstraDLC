package a;

import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.World;

public class nfl extends kfe {
   static final int nfm = 0;
   static final double nfn = 72.0;
   static final double nfo = 36.0;
   static final double nfp = 30.0;
   static final double nfq = 6.0;
   static final int nfr = 3;
   static final long nfs = 600000L;
   static final Pattern nft = Pattern.compile(a.b("ꔋ\udcce嘥젛䏎씊罶\uf6de泪\ue62f懳", 89761064));
   static final Pattern nfu = Pattern.compile(a.c(-2097066369, "乒㞗뵼⍂ꢗ"));
   static final String nfv = a.c(-1501091926, "➰帀퓐䪿셴䟅ﶕ瑺\uea29悊\ue75bᴩ鏠\u0a4e耜۪벽㍠꧀⾒ꙧ\udc29劄쥔伪엤籛\uf21f棭\ueebd攒鯛ᆐ衤ฯ蒒㭜네㟶깛␐嫨킿");
   static final String nfw = a.b("〛䦥", 483995768);
   static final String nfx = a.c(337423386, "걤헃弃셰䫷찋癜ﾪ懾");
   static final long nfy = 30000L;
   static final long nfz = 7000L;
   static final long nga = 25000L;
   static final long ngb = 150000L;
   static final String ngc = a.b("滞\u1774鶠π蠁\u0ebf듵㴗ꍎ", 324955898);
   static final String ngd = a.b("✩序푐䨽쇽", 598681422);
   static final String nge = a.c(-1423223801, "呷ⷜ꜒");
   static final String ngf = a.b("\uf3a5訓Â麻", 1570829257);
   static final int ngg = 190;
   static final int ngh = 576;
   static final float ngi = 3.0F;
   static final int ngj = 576;
   static final int ngk = 20;
   static final long ngl = 60000L;
   static final long ngm = 20000L;
   static final Set<String> ngn = Set.of(
      a.d("鏱\uea44悐ﻪ画\uf39b䧛쀭幠풟匕ꥨ➲븃㑞늦ࣿ蜩ᶁ鯑ር", 1145636931, -1590584374),
      a.c(2124664663, "켡뚔㱀ꈺ⧫꽋ᔋ鳽ʰ衏࿅\uf5b8筢\ue2d3梎\uee76吸\udbd2䅚윊份㒹먉⇇ꞵ\u2d71铓"),
      a.b("薌ﰹ盭\ue897捆\ue5e6徦홐䠝싢䕸뼎㇂ꡲ∪", 954303982),
      a.d("뾡옔䳀튺奫\udfcb斋\uec7d爰\uf8cf罁蔥\u0be1鉟᠋黧Ⓓ", -343223458, -1682936701),
      a.b("죲녇㮓ꗩ⸸ꢘዘ鬮գ辜ࠑ\uf26d粼\ue510潘\ue9b4只", -78002034),
      a.d("\ud88cꄹ⯭떗㹆룦ʦ譐ᔝ鿢ᡪ\ue214泉\uf579缼輪䎅책", 977339535, 1215028348),
      a.d("\uf574賁ؕ顯Ꮎ锞⽞ꚨ㣥눚㖇쿷䄳\ud882", -1214295759, -938761178),
      a.c(1188549970, "픮겛♏렵㏤땄༄蛲ᢿ鉀ᗊ\uefb9慣\uf8dd犄\uf468丶"),
      a.b("띡컔䐀\uda7a冫휋测\ue4bd竰\uf00f瞂跲̥骁ბ阿ⱽꎹ㤛", 1097840415),
      a.b("犷ଂ臖ᾬ鑽ዝꢝⅫ뼦㗙뉗䠳웷彑픑叩", 361067210),
      a.d("鞫\uee1e擊練煡\uf7c1䶁쑷娺탅坈괴⏸멏", 1070576150, -1185077794),
      a.d("棗ᅢ鮶\u05cc踝ࢽ닽㬋ꕆ⾹\ua83e剄\udc82䔯콱䦗\uf3d8簚\ue6ab惲", 1819904409, -1114054345),
      a.b("棗ᅢ鮶\u05cc踝ࢽ닽㬋ꕆ⾹꠲前\udc97䔤콿䦖\uf3de簔\ue6a6惼", -1273665362),
      a.b("⣡兔\udb80䗺츫䢋\uf2cb笽\ue570澏\ue804ቶ鲳Ԑ轎ধ", -975492964),
      a.c(-995143975, "亣㜖뷂⎸ꡩ⻉钉ᵿ茲্蹗琸\ufaed捜\ue914濹햁婭생䚞콻딧㮌"),
      a.d("碖ģ请ᖍ鹜\u18fcꊼ⭊딇㿸롷䈌쳞啨\udf21", 890770786, 1439329686)
   );
   final vmu ngo = this.add(new vmu(a.b("\udd4bꓗ⸃끸㾿뵯݇躷უ驖ᶁ", 1109186896), "", 16));
   final vkl ngp = this.add(new vkl(a.c(-727505227, "⊦嬸톑俬쑁䊆\uf8ab畏\uef78斱\ue217ᡡ隿"), true));
   final vkl ngq = this.add(new vkl(a.c(249814891, "\udb67ꋲ⡝뙐㷸묻Ĝ袖ᛋ鱷ᾱ\ue1a8漇\uf6c3粗\ufa6f"), true));
   final vkl ngr = this.add(new vkl(a.b("吹ⶦꝳ㤄닛㑣踴\u07b5馗ፐ铽檙\ue026积\uf3c9甿콹", 913133619), true));
   final vkl ngs = this.add(new vkl(a.c(1512283722, "驚\ue3b4椒\uf762粹見䀡춲埶\udd42媓ꃮ⸴란㶤"), true));
   final vkw ngt = this.add(
      new vkw(a.c(-1235147233, "∏宖텉佁쓨䙊\uf80e燻\uefa5攛\ue2c5ᢱ陫"), new vkq(a.b("嘌⾚ꕆ㬰낞㙞豿ր龳ᄚ鋑沾\ue266箥\uf1f2睼쵉䊖", 2140951049), vhz.LAYERS, ign::openMine))
   );
   static nfl ngu;
   static boolean ngv;
   efz ngw;
   final qqs ngx = new qqs();
   final qqd ngy = new qqd();
   final qdz ngz = new qdz();
   final qof nha = new qof();
   final tel nhb = new tel();
   final qmh nhc = new qmh();
   final qsw nhd = new qsw();
   final qaj nhe = new qaj();
   final qma nhf = new qma();
   final Map<Integer, pzc> nhg = new HashMap<>();
   final Map<Integer, Vec3d> nhh = new HashMap<>();
   final Set<Integer> nhi = new HashSet<>();
   final Map<String, Long> nhj = new HashMap<>();
   final poi nhk = new poi();
   final Map<Integer, Long> nhl = new HashMap<>();
   final Map<Integer, Long> nhm = new HashMap<>();
   boolean nhn;
   boolean nho;
   nff nhp = nff.START;
   long nhq;
   int nhr = -1;
   int nhs = -1;
   boolean nht;
   ClientPlayerEntity nhu;
   int nhv = -1;
   long nhw;
   boolean nhx;
   ClientWorld nhy;
   ClientPlayerEntity nhz;
   Vec3d nia;
   boolean nib;
   boolean nic;
   int nid;
   long nie;
   long nif;
   int nig;
   Vec3d nih;
   ClientWorld nii;
   ClientPlayerEntity nij;
   long nik;
   boolean nil;
   long nim;
   int nin;
   long nio;
   boolean nip;
   String niq = "";
   long nir;
   int nis = -1;
   boolean nit;
   boolean niu;
   long niv;
   int niw = -1;
   long nix;
   qwj niy;
   qwj niz;
   long nja;
   int njb;
   boolean njc;
   int njd;
   boolean nje;
   boolean njf;
   boolean njg;
   boolean njh;
   long nji;
   long njj;
   String njk;
   long njl;
   long njm;
   Vec3d njn;
   Object njo;
   long njp;
   String njq = "";
   int njr;

   public nfl() {
      super(a.c(610722204, "\ue1d5顐ኂ賨ܝ膈㯜눦"), a.d("喚Ⰴꛞ㢫덯㗟迟ٺ頹ኅ锓漣\ue1fb硅\uf205瓥캡䅡\udb8b嶛푸긨₀묓㴬럹ํ耗\u1af6鳴ᜅ\ue9cf揙視簯\uf699䥘쌠䗹", -439984955, 95422779), kfa.PLAYER);
      if (ngu == null) {
         ngu = this;
      }

      this.ngz.target(nfl::nkc);
      this.ngz.junk(var0 -> qof.isJunkStack(var0, ngn));
      this.ngz.onSit(this::nkd);
      this.nhd.walker().junk(var0 -> qof.isJunkStack(var0, ngn));
      this.nhd.notes(var1 -> this.nma(var1, vhz.INFO));
      this.nhk.notes(var1 -> this.nma(var1, vhz.NAV));
      if (!ngv) {
         ngv = true;
         wcn.listen(nfl::nju);
      }
   }

   @Override
   public boolean isMaintenance() {
      return false;
   }

   static void nju(Packet<?> var0) {
      nfl var1 = ngu;
      if (var1 != null && var1.ngw == null && var1.isEnabled()) {
         var1.ngz.echo(var0);
      }
   }

   public void onPacket(Packet<?> var1) {
      if (this.isEnabled()) {
         this.ngz.echo(var1);
      }
   }

   public static boolean busy() {
      nfl var0 = ngu;
      return var0 != null && var0.isEnabled() && var0.nhp != nff.START;
   }

   public void attachBot(efz var1) {
      this.ngw = var1;
      this.nhb.tickOnly();
   }

   public boolean isBotInstance() {
      return this.ngw != null;
   }

   public void copySettingsFrom(nfl var1) {
      if (var1 != null && var1 != this) {
         List var2 = var1.getSettings();
         List var3 = this.getSettings();

         for (int var4 = 0; var4 < Math.min(var2.size(), var3.size()); var4++) {
            vmo var5 = (vmo)var2.get(var4);
            vmo var6 = (vmo)var3.get(var4);
            if (var5 instanceof vkl var7 && var6 instanceof vkl var8) {
               var8.set(var7.get());
            } else if (var5 instanceof vmu var9 && var6 instanceof vmu var10) {
               var10.set(var9.get());
            }
         }
      }
   }

   void njv() {
      Flow var1 = Flow.getInstance();
      if (var1 != null && var1.getModuleManager() != null) {
         nfl var2 = var1.getModuleManager().get(nfl.class);
         if (var2 != null && var2 != this && !var2.isBotInstance()) {
            Set var3 = Collections.newSetFromMap(new IdentityHashMap());
            var3.addAll(List.of(this.botSettings()));
            List var4 = var2.getSettings();
            List var5 = this.getSettings();

            for (int var6 = 0; var6 < Math.min(var4.size(), var5.size()); var6++) {
               vmo var7 = (vmo)var4.get(var6);
               vmo var8 = (vmo)var5.get(var6);
               if (!var3.contains(var8)) {
                  if (var7 instanceof vkl var9 && var8 instanceof vkl var10 && var9.get() != var10.get()) {
                     var10.set(var9.get());
                  } else if (var7 instanceof vmu var11 && var8 instanceof vmu var12 && !var11.get().equals(var12.get())) {
                     var12.set(var11.get());
                  }
               }
            }
         }
      }
   }

   public vmo[] botSettings() {
      return new vmo[]{this.ngo, this.ngp, this.ngq, this.ngr, this.ngs};
   }

   public int mined() {
      return this.ngz.mined();
   }

   public String lastNote() {
      return this.njq;
   }

   public static String hudStatus() {
      nfl var0 = ngu;
      return var0 == null ? null : var0.status();
   }

   public static List<ney> hudRows() {
      nfl var0 = ngu;
      ArrayList var1 = new ArrayList();
      if (var0 != null && var0.isEnabled()) {
         long var2 = System.currentTimeMillis();

         for (qqm var5 : var0.ngx.entries()) {
            if (var5.tier != null && var5.refreshAt > var2 - 2000L) {
               boolean var6 = var5.id == var0.nhs || var5.id == var0.nhr && (var0.nhp == nff.WAIT || var0.nhp == nff.MINE);
               var1.add(new ney(var5.id, var5.tier, var5.refreshAt, var6));
            }
         }

         var1.sort((var0x, var1x) -> Long.compare(var0x.refreshAt(), var1x.refreshAt()));
         return var1.size() > 8 ? new ArrayList<>(var1.subList(0, 8)) : var1;
      } else {
         return var1;
      }
   }

   public String status() {
      nfl var1 = this;
      if (!var1.isEnabled()) {
         return null;
      }

      long var2 = System.currentTimeMillis();
      if (var1.nhk.active()) {
         return var1.nhk.status();
      }

      if (var1.nhe.active()) {
         return a.c(1985731854, "\ud90fꂖ⩄둀㾞류͵軪ᒥ鸖ᦵ\ue3b8楼\uf4a1纉\uf801䈲췦圬");
      }

      if (var1.nhf.active()) {
         return a.b("\uecea镲", -982652675);
      }

      return switch (var1.nhp) {
         case START, DECIDE -> a.d("ၻ榓\ue33a終\uf6ed瀬쨁䞞\udda9坠탆⪰ꑦ", 1915102252, -2020659128);
         case HOP -> a.b("呺ⷬꝊ㥀늟㑛詫އ駕\u1774", -1050980249)
            + var1.nhv
            + (var1.nid > 0 ? a.d("蘼ﾅ煁\uef31擪\ue22b堄톋䮴", -330349232, 757646149) + var1.nid + a.b("ણ", -2124543349) : "");
         case ARRIVE -> a.b("\ue204鮨ᅹ轴ҡ舞㰣놰⾝ꔭ⋴\ud886嘮쿢䗈읚礈\uf6d4桷", 2147280438) + var1.nhr;
         case WARP -> var1.nim > 0L
            ? a.b("쒷봛㟊꧇−꒭᪐霃म莞ч︵炝\ue951捻", -534789991)
            : (
               var1.nik > var2
                  ? a.c(-1247726053, "㈙䮊섩弧탯剃\ue81d旼ￋ甂\uf2a4࣒蘄ᯖ鄒\u1774") + (var1.nik - var2 + 999L) / 1000L + a.b("ọ挝", -1949557009)
                  : a.c(303126522, "句⩶ꃕ㻛넓㎿觡Ѐ鸷ᓾ鍘椮\ue7f8")
            );
         case WAIT -> {
            qqm var4 = var1.ngx.entry(var1.nhr);
            String var5 = !var1.njf
               ? a.b("ᖲ氡\ue685粗", -931393120)
               : (
                  var1.ngz.parked()
                     ? (
                        var1.mc.player != null && var1.mc.player.hasVehicle()
                           ? a.d("䫩㍁릜➘꠬⪀郞ᴿ蜁ඳ詡灬ﺱ月\ued2a殭퇨幌삖䛋쬪녹㾽ꀏ", -163365951, 690320657)
                           : a.c(-2021787155, "\ufdde聬ໞ邬᭺鶷⟮긗\u3040뫾㤻썆䦇퀴娐\ud882")
                     )
                     : a.d("뻘읅䷡ퟳ堾\uda95撧\ued55猋阮縟葦ી錇ᥞ龣⇼긡や뛗㽗䅥", -1334101007, 1841922343)
               );
            yield var5
               + (var1.niy == null ? a.c(711954127, "誂\uf34b秭\ue79b汍") : var1.niy.title())
               + (var4 == null ? "" : a.c(-607763068, "䖧㲁뛅") + clock(var4.refreshAt - var2));
         }
         case SETTLE -> a.c(-1211701687, "\ue271鯘ᅾ輈ҭ蘌㡁놿\u2fecꕞ⊁\ud8fa嘮쾔䖶썊");
         case MINE -> a.b("⑽巨휺䥄십䀲", -1141825439)
            + (var1.niz == null ? a.b("돍쨄䂢\uded4唂", -1870153856) : var1.niz.title())
            + a.d("醬\ue88a拎", -526365120, -1414996017)
            + var1.ngz.mined()
            + a.c(1299589695, "⨚垻\udd63䌕쳐")
            + (var1.ngz.hasBrain() ? a.c(1965951536, "ਘ猾梁挖\ue8c9湴푞巑") + var1.njw() : "");
         case IDLE -> a.d("\ud89bꄈ⮬", 1216322443, 328681221);
         case BASE -> {
            switch (var1.nin) {
               case -1:
                  yield a.c(1218314701, "ך籆\uf285梕\ue339斉\udfd1嘤챯䛖")
                     + var1.niq
                     + a.b("롈쇰䮴핒媘\udc24执", 9484390)
                     + var1.nln()
                     + a.b("踳\uf3e1祇\ue735棷", -2050519530)
                     + 3
                     + a.c(-869306110, "焷ಛ虅ᡌ鏫ᔧ\uab1d⋠뢩㈚떾䮬셥墭튌合\uee32懢ﭝ礔\uf0eb")
                     + Math.max(1, pjd.position(var1.nmb()))
                     + a.d("鮦\ue603检", -1186172628, 603056804);
               case 0:
                  yield a.c(-685897817, "ΰ稬\uf4ef滿\ue553揣\ud9bb偎쨅䂼") + var1.niq + a.c(-290035785, "析Ḩ鑬ઊ蕊ϼ맚ぐ긇Ⓝꝳ够ퟅ䩤") + var1.nln();
               case 1:
                  yield var1.nik > var2
                     ? a.c(-2045954688, "ㆶ䠐싍岲흯凟\uebf2戁\uf83c皐\uf14e༯薙᱓阁჻ꪰⅵ뭑㶗") + (var1.nik - var2 + 999L) / 1000L + a.c(2006479108, "焦\u0cf6")
                     : a.c(1349525712, "ⓣ嵅힘䧧숺䒊ﺧ睔\ued69揅\ue41b᩺郌आ荔֮뿥");
               default:
                  yield var1.nhd.status();
            }
         }
      };
   }

   String njw() {
      toq var1 = this.ngz.brain();
      double var2 = var1 == null ? Double.NaN : var1.ratio();
      if (Double.isNaN(var2)) {
         return "";
      }

      long var4 = Math.round((var2 - 1.0) * 100.0);
      return a.d("\ue0ec", -864896176, -1367778403) + (var4 >= 0L ? a.c(-7143762, "ﺄ") : "") + var4 + a.c(1989996772, "\uf0c9襽\u07b4鷟ቪ钬\u2efb꜎");
   }

   public static toq neuroBrain() {
      nfl var0 = ngu;
      return var0 != null && var0.isEnabled() ? var0.ngz.brain() : null;
   }

   public String debug() {
      return this.nhp
         + a.c(1903570080, "Ⲇ啿\udfa1䇇쨇䳮")
         + this.nhr
         + a.d("柝ḡ银\u0a80腜߬뷦", -1697615986, -367130508)
         + this.ngz.mined()
         + a.b("\uf46d趈݇餬ዦ鑏⸅ꞧ", 967308357)
         + this.nha.thrown()
         + a.c(28523828, "㴝䓾츺偘\udb9c崺\ue76f溙\uf088")
         + this.ngz.reverts()
         + a.d("ꔓ\udcf2嘣졅䎓씯罶\uf690梆\ue251", -1058560118, -2056322381)
         + this.ngz.predicted()
         + a.c(-1589167482, "㫝䌑즊埼\udc34嫈")
         + this.ngx.hopMs()
         + a.d("쳖따㿵ꆗ⩂겾", -616107490, -1843904786)
         + this.ngx.warpMs()
         + (this.ngz.area() == null ? "" : a.b("嵡⒑깑〷믤㴉", -417243833) + this.ngz.area())
         + a.d("\ud827", 911310596, 1082304258)
         + this.ngz.dozer()
         + a.d("턈ꣂ", -1868478420, 2113771782)
         + this.ngz.sweepStats()
         + a.c(-1516353678, "䜮");
   }

   public String action() {
      return this.ngz.action() + String.format(Locale.ROOT, a.d("ዀ次\ue1ee羒\uf44a犨죣䄙\udf59喿", 2118010442, -1640934240), this.nhb.lastPlan());
   }

   public static void onMessage(Text var0) {
      nfl var1 = ngu;
      if (var1 != null) {
         var1.onChat(var0);
      }
   }

   public void onChat(Text var1) {
      nfl var2 = this;
      if (var2.isEnabled() && var1 != null) {
         var2.nhk.onChat(var1);
         String var3 = pfl.title(var1.getString());
         boolean var4 = var2.nhp == nff.HOP || var2.nhp == nff.BASE && var2.nin == 0;
         boolean var5 = var2.nhp == nff.WARP || var2.nhp == nff.BASE && var2.nin == 1;
         if (var4) {
            if ((
                  !var3.contains(a.d("햭걩⚹", 1759931051, 922467142))
                     || !var3.contains(a.b("휨껭\u244b멈㆘띜", -840314001))
                        && !var3.contains(a.c(-1544927448, "䌐㪠끹⸆ꗐ⌔饎"))
                        && !var3.contains(a.b("㭩䋕졳噹\udda4嬙\ue130", -1555939501))
               )
               && !var3.contains(a.c(-1378966369, "ꓯ\udd53垞째䈫쒟绑\uf779楥\ue3d8搊鹻Ⴇ褐͔薴㿺"))) {
               if (var3.contains(a.d("↬堕틇䲼윔䆦ﯴ特", 574677753, 177325920))
                  || var3.contains(a.d("矌\u0e75肳᪡鄁឴귬␘머や댻䵕쎃娸큥嚕\uecaf捷", -1290392137, -570991020))
                  || var3.contains(a.d("\ue83e醎ᭆ蕣\u0ef5術㈗믮▴꼈⣘튧屹", 1027639150, 1455845171))
                  || var3.contains(a.b("ԣ粘\uf63e栺\ue3e7敗\udf01囶좡䈘", -787021546))) {
                  var2.nic = true;
               }
            } else {
               var2.nib = true;
            }
         }

         if (var5) {
            if (var3.contains(a.b("鿫\ue626沋\uf2f3礬ﾕ䗎", -526345262)) || var3.contains(a.c(1597318470, "ⅿ墲툟䱧잸䅥ﭚ"))) {
               var2.nil = true;
            } else if (var3.contains(a.b("\ufae4茧ঁ鞅᱐", 939851430))
               && (var3.contains(a.b("ꬒ튩堏옋䷕쭭煂", -747458774)) || var3.contains(a.c(-247065775, "\u171b滝\ue400穿\uf1a2眒촿䓌")))) {
               Matcher var6 = nft.matcher(var3);
               if (var6.find()) {
                  var2.nik = System.currentTimeMillis() + Integer.parseInt(var6.group(1)) * 1000L + 300L;
               }
            }
         }
      }
   }

   boolean njx() {
      Boolean var1 = nfi.solo;
      return var1 == null || !var1;
   }

   static String njy() {
      String var0 = nfi.anarchies;
      return var0 != null ? var0 : a.b("㽷䛇찗剸\ud9b3异\ue552沽\uf2ee硍ﾜ\u05ee謧\u1289飛ḭꑺ⮧넇㝕뺠쓮䩃톓埭\udd23撜\uead8瀪\uf67a緕茜ॗ那ᛨ鱕⎛ꧣ⼱뚜㳗䈯졸", -166772883);
   }

   static long njz() {
      Long var0 = nfi.minMineMs;
      return var0 != null ? var0 : 25000L;
   }

   static long nka() {
      Long var0 = nfi.maxMineMs;
      return var0 != null ? var0 : 150000L;
   }

   Set<qwj> nkb() {
      EnumSet var1 = EnumSet.noneOf(qwj.class);
      if (this.ngp.get()) {
         var1.add(qwj.COMMON);
      }

      if (this.ngq.get()) {
         var1.add(qwj.MYTHIC);
      }

      if (this.ngr.get()) {
         var1.add(qwj.LEGENDARY);
      }

      return var1.isEmpty() ? EnumSet.allOf(qwj.class) : var1;
   }

   static boolean nkc(BlockState var0) {
      return var0.isOf(Blocks.DIAMOND_ORE) || var0.isOf(Blocks.DEEPSLATE_DIAMOND_ORE);
   }

   void nkd() {
      if (this.mc.getNetworkHandler() != null) {
         this.mc.getNetworkHandler().sendChatCommand(a.b("\ueeb5霞᷐", -1258623291));
      }
   }

   @Override
   protected void onEnable() {
      this.ngx.clear();
      this.nhr = -1;
      this.nhs = -1;
      this.nht = false;
      this.niw = -1;
      this.nje = false;
      this.njp = 0L;
      this.njq = "";
      this.nhi.clear();
      this.nhj.clear();
      this.nhl.clear();
      this.nhm.clear();
      this.nhk.reset(this.nmb());
      this.nhn = false;
      this.nir = 0L;
      this.niu = false;
      this.nhd.forget();
      this.ngz.resetCounters();
      this.nhc.reset();
      this.nhb.reset();
      this.nhb.forgetFrame();
      ClientPlayerEntity var1 = this.mc.player;
      this.nit = var1 != null
         && qpw.ready(var1.getInventory())
         && qpw.misplaced(var1.getInventory(), qpw.targets(var1.getInventory(), var1.getOffHandStack())) == 0;
      this.nly(nff.START);
   }

   @Override
   protected void onDisable() {
      this.ngz.stop(this.mc);
      this.nhd.stop(this.mc);
      this.nhe.cancel(this.mc);
      this.nhf.stop(this.mc, this.mc.player);
      this.nha.cancel(this.mc);
      this.nhb.reset();
      this.nhb.forgetFrame();
      if (this.ngw == null) {
         qwo.clear();
      }

      this.nhk.reset(this.nmb());
      pjd.cancel(this.nmb());
      this.nhp = nff.START;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.nhb.newTick();
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null) {
         if (this.nhn) {
            this.ngz.releaseKeys(var1);
            this.nhd.walker().releaseKeys(var1);
         } else if (this.nha.busy()) {
            this.ngz.releaseKeys(var1);
            this.nhd.walker().releaseKeys(var1);
            this.nha.startTick(var1);
         } else if (this.nhf.active()) {
            this.ngz.releaseKeys(var1);
            this.nhd.walker().releaseKeys(var1);
            this.nhf.startTick(var1);
         } else if (this.njg) {
            this.nhd.walker().releaseKeys(var1);
            this.ngz.startTick(var1, var2);
         } else if (this.nhp == nff.BASE) {
            this.ngz.releaseKeys(var1);
            if (this.nin == 2) {
               this.nhd.startTick(var1, var2);
            } else {
               this.nhd.walker().releaseKeys(var1);
            }
         } else if (!this.nhe.active() && this.nkg()) {
            this.ngz.startTick(var1, var2);
         } else {
            this.ngz.releaseKeys(var1);
         }
      }
   }

   void nke(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      boolean var5 = var2.isAlive() && (this.nhp != nff.BASE || this.nin != 2) && !this.nkg() && qdz.trapped(var1.world, var2) != null;
      if (!var5) {
         if (this.njg) {
            this.njg = false;
            if (!this.nkg()) {
               this.ngz.stop(var1);
            }
         }
      } else {
         if (this.nhf.active()) {
            this.nhf.stop(var1, var2);
         }

         if (!this.njg) {
            this.njg = true;
            this.nji = var3;
            this.nma(a.b("槟၉髫ҙ轌৲돕㸿ꑲ⫑ꤓ卨\uddba䐏칖䣒\uf6f8夝\ue39a懙\ue857鉷\u1cce蜐ě讳㈂밭⛕ꂉ", 798453206), vhz.ALERT);
         }

         if (this.ngz.status() != qdw.WORKING || !this.ngz.guarding()) {
            this.ngz.guard(pzc.empty(var2.getBlockPos()));
         }
      }
   }

   boolean nkf(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (this.nhk.tick(var1, var2, this.nmb(), this.ngo.get(), var3)) {
         if (!this.nhn) {
            this.nhn = true;
            this.nho = false;
            this.ngz.stop(var1);
            this.nhd.stop(var1);
            this.nhe.cancel(var1);
            this.nhf.stop(var1, var2);
            this.nha.cancel(var1);
            this.njg = false;
            this.njf = false;
            this.nhs = -1;
            this.nly(nff.IDLE);
         }

         this.nho = this.nho | this.nhk.active();
         this.nhb.assistAt(var1, var2, null, null, 1);
         return true;
      } else {
         boolean var5 = this.nhk.takeReturned();
         if (var5 || this.nhn) {
            this.nhn = false;
            if (!var5 && !this.nho) {
               this.nly(nff.DECIDE);
            } else {
               this.nhr = !this.njx() ? 0 : (var5 ? this.nln() : -1);
               this.nht = false;
               this.njp = 0L;
               this.nly(nff.START);
            }
         }

         return false;
      }
   }

   boolean nkg() {
      return this.nhp == nff.MINE || (this.nhp == nff.WAIT || this.nhp == nff.SETTLE) && this.ngz.status() == qdw.WORKING;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.njr++;
      if (this.ngw != null && this.njr % 20 == 1) {
         this.njv();
      }

      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.world != null) {
         pjd.keep(this.nmb());
         if (this.ngw == null) {
            wcn.ensure(var1);
         }

         ttb var3 = lfa.mineModel();
         tck var4 = var3 != null ? var3.hand : lfa.model(lex.MINE);
         double var5 = var3 != null ? lfa.mineBoost() : 0.0;
         this.nhb.use(var4 != null ? var4 : tck.profile1());
         this.nhb.tune(1.0 + var5, 1.0, 1.0);
         this.nhb.reactionScale(1.0 / (1.0 + 2.0 * var5));
         this.nhb.verticalAware(var3 == null);
         this.nhb.cap(var3 != null && var3.style.turnCap > 0.0F ? var3.style.turnCap * (1.0 + var5) : 0.0);
         this.nhb.pointSize(var3 != null ? 0.5 : 0.3);
         this.nhc.cap(110.0);
         this.ngz.boost(var5);
         this.ngz.brain(var3);
         this.ngz.configure(var4 != null ? null : this.nhc, var3 == null || var3.style.sprints(), true);
         this.ngz.predict(this.ngs.get(), var1);
         this.nhd.walker().configure(this.nhc, true, false);
         this.nha.noThrow = this.nhp == nff.BASE;
         this.nlx();
         if (var1.currentScreen instanceof DeathScreen && var2.isDead() && this.njr % 20 == 0) {
            var2.requestRespawn();
            var1.setScreen(null);
         }

         if (var2.isDead() && this.nhp == nff.BASE) {
            this.nhd.stop(var1);
            this.nly(nff.DECIDE);
         }

         if (this.nht && this.nhu != var2) {
            this.nht = false;
         }

         long var7 = System.currentTimeMillis();
         if (!this.nkf(var1, var2, var7)) {
            this.nke(var1, var2, var7);
            boolean var9 = !this.njg && (this.nhp != nff.BASE || this.nin == 2 && this.nhd.canPause());
            if (this.njr % 10 == 0
               && !this.nhf.active()
               && !this.nha.busy()
               && !this.nhe.active()
               && var1.currentScreen == null
               && var9
               && var2.isAlive()
               && qma.hungry(var2)) {
               if (qma.canEat(var2)) {
                  this.nhf.start(var2);
               } else {
                  int var10 = qma.stored(var2);
                  if (var10 >= 0) {
                     this.nha.swaps(var10, var2.getOffHandStack().isEmpty() ? 40 : 8);
                  }
               }
            }

            try {
               if (!this.nhf.active() && !this.nha.busy() && (!this.njg || var7 - this.nji >= 12000L)) {
                  this.nki(var1, var2, var7);
               }
            } catch (RuntimeException var11) {
               System.out.println(a.c(686499189, "┾岻황䠃쏶䕣Ｗ盍\ue8cd扦") + var11);
               var11.printStackTrace();
               this.ngz.stop(var1);
               this.nhd.stop(var1);
               this.nly(nff.DECIDE);
            }

            if (this.nha.busy()) {
               this.nha.endTick(var1, var2, ngn);
            }

            if (this.ngw == null) {
               this.nlk(var1, var2);
            }

            if (this.nha.busy()) {
               if (this.nha.job() == qoc.JUNK && this.njn != null) {
                  this.nkh(var1, var2, this.njo, this.njn);
               } else {
                  this.nhb.assistAt(var1, var2, null, null, 1);
               }
            } else if (this.nhf.active()) {
               this.nhf.endTick(var1, var2);
               this.nhb.assistAt(var1, var2, null, null, 1);
            } else if (this.njg) {
               this.ngz.endTick(var1, var2, this.nhb);
            } else if (this.nhp == nff.BASE) {
               if (this.nin != 2) {
                  this.nhb.assistAt(var1, var2, null, null, 1);
               }
            } else if (this.nkg() && !this.nhe.active()) {
               this.ngz.endTick(var1, var2, this.nhb);
            } else {
               this.nhb.assistAt(var1, var2, null, null, 1);
            }
         }
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.currentScreen == null && var1.mouse.isCursorLocked()) {
         this.nhb.frame(var1, var2);
      } else {
         this.nhb.forgetFrame();
      }
   }

   void nkh(MinecraftClient var1, ClientPlayerEntity var2, Object var3, Vec3d var4) {
      this.nhb.assistAt(var1, var2, null, null, 1);
      this.nhc.aim(var1, var2, var3, var4);
   }

   void nki(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (this.nhe.active()) {
         if (this.nhe.tick(var1, var2, var3)) {
            this.nhi.add(this.nis);
            this.nma(
               a.c(-282126880, "ᇻ桨\ue2cb糆\uf302營쯷䉿\udc5c囨턱")
                  + (this.nis > 0 ? a.c(-1828324346, "ﰢ膎\u0b50鄱") + this.nis : "")
                  + a.b("墱ℚ", -44345207)
                  + this.nhe.result(),
               this.nhe.ok() ? vhz.CHECK : vhz.ALERT
            );
         }
      } else {
         switch (this.nhp) {
            case START:
               this.nkj(var1, var2, var3);
               break;
            case DECIDE:
               this.nkk(var1, var2, var3);
               break;
            case HOP:
               this.nks(var1, var2, var3);
               break;
            case ARRIVE:
               this.nkt(var1, var2, var3);
               break;
            case WARP:
               this.nkw(var1, var2, var3);
               break;
            case WAIT:
               this.nkz(var1, var2, var3);
               break;
            case SETTLE:
               this.nlf(var1, var2, var3);
               break;
            case MINE:
               this.nli(var1, var2, var3);
               break;
            case IDLE:
               if (this.njr % 20 == 0 && this.nls(var1, var2, var3)) {
                  return;
               }

               if (var3 - this.nhq > 2500L) {
                  this.nly(nff.DECIDE);
               }
               break;
            case BASE:
               this.nlt(var1, var2, var3);
         }
      }
   }

   void nkj(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      ArrayList var5 = new ArrayList<>(this.njx() ? qqs.parseList(njy()) : List.of(0));
      var5.remove(Integer.valueOf(this.nln()));
      this.ngx.list(var5);
      if (!this.njx()) {
         this.nhr = 0;
      }

      pzp var6 = pzw.read(var1, 72.0);
      if (var6 != null && var6.pos().distanceTo(var2.getEntityPos()) <= 30.0) {
         pzc var7 = pzc.detect(var1.world, var6.pos());
         if (var7 != null && var7.ores >= 20 && var7.distanceTo(var2.getEntityPos()) < 24.0) {
            this.nkx(var2);
            if (this.nhr >= 0) {
               this.nlw(this.nhr, var6, var3, false);
               this.nhg.put(this.nhr, var7);
               this.nhh.put(this.nhr, var6.pos());
            }

            this.niz = null;
            this.nhs = this.nhr;
            this.nlh(var1, var2, var7, var3);
            this.nma(a.b("歍ዘ頊ٴ距༂넹㢰ꚚⰬ\uabfe嗬\udf5b䛥쳍䨶\uf07b", 1909419846), vhz.PLAYER);
            return;
         }
      }

      this.nly(nff.DECIDE);
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void nkk(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (!qof.holdsPickaxe(var2) && qof.bestPickaxe(var2.getInventory()) < 0 && !poi.inLobby(var2)) {
         if (this.njp == 0L) {
            this.njp = var3;
         }

         if (var3 - this.njp > 5000L) {
            this.nma(a.b("换\u1afb遟ੌ薁̲뤙を껏\u2066ꎧ巄휋亿쓣䈕\uf852矼\ued3d欜\ue29e", -829790358), vhz.ALERT);
            this.nlz();
         }
      } else {
         this.njp = 0L;
         if (!this.nls(var1, var2, var3) && !this.nlp(var1, var2, var3)) {
            if (this.nht) {
               Vec3d var5 = this.nhh.get(this.nhr);
               if (var5 != null && var5.distanceTo(var2.getEntityPos()) > 36.0) {
                  this.nht = false;
               }
            }

            if (!this.njx()) {
               this.nhr = 0;
               pzp var9 = pzw.read(var1, 72.0);
               if (var9 == null) {
                  if (this.nht) {
                     this.nly(nff.IDLE);
                  } else {
                     this.nku(var1, var2, var3);
                  }

                  return;
               }

               this.nhh.put(0, var9.pos());
               this.nlw(0, var9, var3, false);
            }

            qwj var10 = this.nhr >= 0 ? this.ngx.fresh(this.nhr, var3, this.ngy) : null;
            if (var10 != null && this.nhh.containsKey(this.nhr)) {
               this.nhs = this.nhr;
               this.niz = var10;
               if (this.nht) {
                  this.nlg(true);
               } else {
                  this.nku(var1, var2, var3);
               }
            } else {
               nes var6 = this.nhr >= 0 ? this.nkl(var1, var2, var3) : null;
               if (var6 == null) {
                  qqg var11 = this.ngx.decide(var3, this.nhr, this.nht ? 0L : this.ngx.warpMs(), this.ngy);
                  switch (var11.kind()) {
                     case SCAN:
                        this.nhs = -1;
                        this.nkp(var1, var2, var11.id(), var3);
                        break;
                     case GO:
                        this.nhs = var11.id();
                        if (var11.id() == this.nhr) {
                           if (this.nht) {
                              this.nky(var1, var11.entry(), var3);
                           } else {
                              this.nku(var1, var2, var3);
                           }
                        } else {
                           qqm var12 = var11.entry();
                           this.nma(
                              a.b("\uf859臄ୠ酲Ẹ頄♇", -825754554)
                                 + var11.id()
                                 + a.b("링쁪", 984922617)
                                 + var12.tier.title()
                                 + a.d("䛻㬭놌⾈ꐪ⊙鳝", -2013874818, -61869150)
                                 + clock(var12.refreshAt - var3),
                              vhz.NAV
                           );
                           this.nkp(var1, var2, var11.id(), var3);
                        }
                        break;
                     case IDLE:
                        this.nly(nff.IDLE);
                  }
               } else {
                  this.nhs = this.nhr;
                  qqm var7 = this.ngx.entry(this.nhr);
                  this.niz = var7 != null && var7.lastTier != null ? var7.lastTier : qwj.COMMON;
                  String var8 = this.nhr > 0 ? a.d("䝸㫔뀊⩫", -1780191993, 1315252827) + this.nhr : "";
                  if (var6.look() || !this.nht && !(var6.area().distanceTo(var2.getEntityPos()) < 24.0)) {
                     this.nma(
                        var6.look()
                           ? a.d("જ猵煉查\uec40", 148362841, -1310730008)
                              + var8
                              + a.b("䛄㭧놾⿃ꐝ⊡鳢ᄎ轙ǽ舼砾\uf6e7欵\ue16a掋\ud9cf嘙첦䫰쌎륓㏲갱⹜ꂐᤫ靶ঘ试gﺵ瓷\ued0b潆엃娠푉劖쭐䕬㾂뗐㈞ꢴ⛇齨ᗛ鏡ࡇ蘺", 464471767)
                           : a.c(1363531596, "퍡\uaac8\u206e븘㖽")
                              + var8
                              + a.b("贯\uf0fc穓\ue427澇\ue940北\udef8䓀카䧛랴㵽꓃⺜ꡮር鷶݆脜࢚狆\uf803揈", -1273787113)
                              + var6.diamonds()
                              + a.d("责\uf082穚\ue42c濷\ue941匛\udae6䂫\uea2e䷉뎠㵻꒽⪍ꡦር鷽݁腢࢛", 820565740, 1273781242),
                        vhz.NAV
                     );
                     this.nku(var1, var2, var3);
                  } else {
                     this.nma(
                        a.b("႕椼\ue39a緬\uf649", 2060260536)
                           + var8
                           + a.b("갴퇧孈씼亜졛爌￣旛\uef6f检隯ᱦ藘྇襵㌶볭♝ꀇ⦁叝\ud918䋓", -1043682292)
                           + var6.diamonds()
                           + a.c(-95041365, "좛딺㿢ꆔ⩏곹ᚣ齞ԓ꾖ࡱ\uf61a磉\ue179欥\uedaa"),
                        vhz.PLAYER
                     );
                     this.nlh(var1, var2, var6.area(), var3);
                  }
               }
            }
         }
      }
   }

   nes nkl(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      Vec3d var5 = this.nhh.get(this.nhr);
      qqm var6 = this.ngx.entry(this.nhr);
      if (var5 == null || var6 == null || this.nhr == this.nln() || var1.world == null) {
         return null;
      }

      if (var6.refreshAt - var3 < this.ngy.minMineMs + 20000L) {
         return null;
      }

      if (nkn(this.nhl.get(this.nhr), var6.refreshAt)) {
         return null;
      }

      boolean var7 = nkn(this.nhm.get(this.nhr), var6.refreshAt);
      if (var7 && !this.nht) {
         this.nhl.put(this.nhr, var6.refreshAt);
         return null;
      }

      pzc var8 = this.nhg.get(this.nhr);
      if (var8 == null || var8.distanceTo(var5) > 30.0) {
         var8 = pzc.detect(var1.world, var5);
         if (var8 == null) {
            return null;
         }

         this.nhg.put(this.nhr, var8);
      }

      int var9 = nkm(var1.world, var8);
      if (var9 >= 20) {
         if (!this.nht) {
            this.nhm.put(this.nhr, var6.refreshAt);
         }

         return new nes(var8, var9, false);
      } else if (this.nht || pzc.loaded(var1.world, var5)) {
         this.nhl.put(this.nhr, var6.refreshAt);
         return null;
      } else if (!var7 && var9 * 2 >= 20) {
         this.nhm.put(this.nhr, var6.refreshAt);
         return new nes(var8, var9, true);
      } else {
         return null;
      }
   }

   static int nkm(World var0, pzc var1) {
      int var2 = 0;
      Mutable var3 = new Mutable();

      for (int var4 = var1.minX; var4 <= var1.maxX; var4++) {
         for (int var5 = var1.minZ; var5 <= var1.maxZ; var5++) {
            if (var0.isChunkLoaded(var4 >> 4, var5 >> 4)) {
               for (int var6 = var1.minY; var6 <= var1.maxY; var6++) {
                  if (nkc(var0.getBlockState(var3.set(var4, var6, var5)))) {
                     var2++;
                  }
               }
            }
         }
      }

      return var2;
   }

   static boolean nkn(Long var0, long var1) {
      return var0 != null && Math.abs(var0 - var1) < 60000L;
   }

   void nko() {
      qqm var1 = this.nhr >= 0 ? this.ngx.entry(this.nhr) : null;
      if (var1 != null) {
         this.nhl.put(this.nhr, var1.refreshAt);
      }
   }

   void nkp(MinecraftClient var1, ClientPlayerEntity var2, int var3, long var4) {
      if (!pjd.enter(this.nmb(), String.valueOf(var3))) {
         pjd.cancel(this.nmb());
         this.ngx.block(var3, var4 + 30000L);
         this.nma(a.c(-1081522088, "䱆㗚묙") + var3 + a.c(-1710005776, "懕ᰇ隡࣓蜑") + 3 + a.d("\udeabꌇ⧙럐㱷못ҍ굈ጣ鶍ᨡ\ue02e滸\uf735絤ﯮ䆫츄", -1910320719, -553709784), vhz.INFO);
         this.nly(nff.DECIDE);
      } else {
         this.ngx.scanned(var3);
         this.nhv = var3;
         this.nhw = var4;
         this.nhx = true;
         this.nid = 0;
         this.nie = 0L;
         this.nkq(var1, var2);
         this.nly(nff.HOP);
      }
   }

   void nkq(MinecraftClient var1, ClientPlayerEntity var2) {
      this.nhy = var1.world;
      this.nhz = var2;
      this.nia = var2.getEntityPos();
      this.nib = false;
      this.nic = false;
      var1.getNetworkHandler().sendChatCommand(a.b("漗ᚩ", -523538572) + this.nhv);
   }

   boolean nkr(MinecraftClient var1, ClientPlayerEntity var2) {
      return var1.world != this.nhy || var2 != this.nhz || this.nia != null && var2.getEntityPos().distanceTo(this.nia) > 48.0;
   }

   void nks(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (this.nkr(var1, var2) || this.nib) {
         this.nhr = this.nhv;
         this.nht = false;
         this.nly(nff.ARRIVE);
      } else if (!this.nic) {
         if (var3 - this.nhq > 15000L) {
            this.ngx.block(this.nhv, var3 + 90000L);
            this.nma(a.b("꽉훐堖쉸䧓콠田ﲻ拧\ue853殞闲ᬨ蚉", -725898406) + this.nhv, vhz.ALERT);
            this.nly(nff.DECIDE);
         }
      } else if (this.nid >= 3) {
         this.ngx.block(this.nhv, var3 + 120000L);
         this.nma(a.b("戽ᮡ酿ཾ蒬ɠ롄㗚", -274569691) + this.nhv + a.c(2130781034, "⍜廰퐫䩛솆䝈ﴘ瓨\ueacb恸\ue7a6\u19cb霐ા肒؝뱓㏾ꥏ⽥Ꚙ\udcb7"), vhz.ALERT);
         this.nly(nff.DECIDE);
      } else {
         if (this.nie == 0L) {
            this.nie = var3 + 2500L;
         } else if (var3 >= this.nie) {
            this.nid++;
            this.nie = 0L;
            this.nhx = false;
            this.nkq(var1, var2);
         }
      }
   }

   void nkt(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (var1.currentScreen != null && !(var1.currentScreen instanceof DeathScreen)) {
         if (var3 - this.nhq > 20000L) {
            this.nly(nff.DECIDE);
         }
      } else if (var3 - this.nhq >= 1500L) {
         pzp var5 = pzw.read(var1, 72.0);
         if (var5 != null) {
            this.nhh.put(this.nhr, var5.pos());
            this.nlw(this.nhr, var5, var3, this.nhx);
            this.nhx = false;
            if (var5.pos().distanceTo(var2.getEntityPos()) <= 12.0) {
               this.nkx(var2);
            }

            this.nly(nff.DECIDE);
         } else {
            if (var3 - this.nhq > 4000L) {
               this.nku(var1, var2, var3);
            }
         }
      }
   }

   void nku(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      this.nig = 0;
      this.nly(nff.WARP);
      this.nkv(var1, var2, var3, a.d("蓁ﵦ瞦\ue9d5扒\ue4ae廹휏䥛", 1800882882, -253309315));
   }

   void nkv(MinecraftClient var1, ClientPlayerEntity var2, long var3, String var5) {
      String var6 = var5.trim();
      if (var6.startsWith(a.b("䭜", -922530958))) {
         var6 = var6.substring(1);
      }

      if (!var6.isEmpty()) {
         var1.getNetworkHandler().sendChatCommand(var6);
      }

      this.nig++;
      this.nif = var3;
      this.nih = var2.getEntityPos();
      this.nii = var1.world;
      this.nij = var2;
      this.nik = 0L;
      this.nil = false;
      this.nim = 0L;
   }

   void nkw(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (this.nim != 0L) {
         if (var3 - this.nim >= 700L) {
            pzp var10 = pzw.read(var1, 72.0);
            if (var10 != null) {
               this.nhh.put(this.nhr, var10.pos());
               this.nlw(this.nhr, var10, var3, this.nhx);
               this.nhx = false;
               this.nly(nff.DECIDE);
            } else {
               if (var3 - this.nim > 6000L) {
                  this.nma(a.b("갳햪孬섏䫒챭癋ﯙ懤\ueb27泵階ᡚ膔\u0bba贲㌞뢧≬ꑈⶸ埠", 1615505464) + (this.nhr > 0 ? a.d("ꡨ헄弚앻", 562673347, -183689585) + this.nhr : ""), vhz.ALERT);
                  if (this.njx() && this.nhr >= 0 && this.ngx.entry(this.nhr) == null) {
                     this.ngx.block(this.nhr, var3 + 120000L);
                  }

                  this.nly(nff.DECIDE);
               }
            }
         }
      } else {
         boolean var5 = var1.world != this.nii || var2 != this.nij || var2.getEntityPos().distanceTo(this.nih) > 2.5;
         Vec3d var6 = this.nhh.get(this.nhr);
         boolean var7 = this.nik > 0L && var3 > this.nik + 1500L && var6 != null && var6.distanceTo(var2.getEntityPos()) <= 14.0;
         if (!var5 && !var7) {
            long var8 = this.nik > 0L ? this.nik + 5000L : this.nif + 12000L;
            if (this.nil || var3 > var8) {
               if (this.nig < 2) {
                  this.nkv(var1, var2, var3, a.b("䶷㐐뻐₣ꬤⷘ鞏ṹ耭", 1779781065));
                  return;
               }

               if (this.njx() && this.nhr >= 0) {
                  this.ngx.block(this.nhr, var3 + 120000L);
               }

               this.nma(
                  a.c(697729987, "蟶\ufe6f炩\ueac7愑\ue7a5嶎푻䩛샩䜿봱㏫긶 ꚁ᳀錟দ迶ٿ簬\uf2e5楌\uef4d斐\udc21刂죻产씚㾤뇶⠊ꩉ⒐鬿ᄻ韯\u0e5f")
                     + (this.nhr > 0 ? a.b("ị捧\ue9b9珘", 1145773807) + this.nhr : ""),
                  vhz.ALERT
               );
               this.nly(this.njx() ? nff.DECIDE : nff.IDLE);
            }
         } else {
            this.nim = var3;
            this.nkx(var2);
            this.ngx.warpTook(var3 - this.nif);
         }
      }
   }

   void nkx(ClientPlayerEntity var1) {
      this.nht = true;
      this.nhu = var1;
   }

   void nky(MinecraftClient var1, qqm var2, long var3) {
      this.niy = var2 == null ? null : var2.tier;
      this.niw = -1;
      this.njf = false;
      this.njj = 0L;
      this.njk = null;
      this.nma(
         a.c(-115977436, "圶⺥ꐁ㸓")
            + (this.niy == null ? a.d("蝑ﺘ琾\uea48憞", -1870961822, -1071062914) : this.niy.title())
            + a.c(723201994, "\u2fee剂\ud89c䋽")
            + this.nhr
            + (var2 == null ? "" : a.b("ř磠", -679542405) + clock(var2.refreshAt - var3) + a.d("쟚", -1971669157, 1954115753)),
         vhz.CLOCK
      );
      this.nly(nff.WAIT);
      this.nlm(var1, var3);
   }

   void nkz(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (this.njf && (this.ngz.parkLost() || this.ngz.status() != qdw.WORKING)) {
         this.njf = false;
         this.ngz.stop(var1);
         this.nlc(a.c(290189533, "\uf4fb赂΄駧ሺ钅⺣ꌱ㥺돁㑬칣䂹\ud903坈햣毶\ue046競ﲦ甭ྲྀ臍ᩭ鱤ᚿ꼀"), var3);
      }

      if (!this.njf && this.nht && var3 >= this.njj) {
         this.nlb(var1, var2, var3);
      }

      if (!this.njf && this.nht) {
         this.nla(var2);
      }

      boolean var5 = this.njf || var2.hasVehicle();
      if (var5 || this.njr % 20 != 0 || !this.nls(var1, var2, var3)) {
         if (this.njr % 5 == 0) {
            pzp var6 = pzw.read(var1, 72.0);
            qqm var7 = this.ngx.entry(this.nhr);
            boolean var8 = var7 != null && var3 > var7.refreshAt + 2500L;
            if (var6 != null && !(var6.pos().distanceTo(var2.getEntityPos()) > 36.0)) {
               boolean var11 = this.niw >= 0 && var6.seconds() > this.niw + 20;
               if (!var11 && !var8) {
                  if (var6.tier() != null && (var7 == null || var7.tier == var6.tier())) {
                     this.nlw(this.nhr, var6, var3, false);
                  }

                  this.niw = var6.seconds();
                  if (!var5) {
                     qqg var13 = this.ngx.decide(var3, this.nhr, 0L, this.ngy);
                     if (var13.kind() == qqp.GO
                        && var13.id() != this.nhr
                        && var7 != null
                        && var13.entry() != null
                        && var13.entry().tier.rank() > var7.tier.rank()) {
                        this.nly(nff.DECIDE);
                     }
                  }
               } else {
                  qwj var12 = this.niy != null ? this.niy : (var7 != null ? var7.tier : null);
                  if (var11) {
                     this.nlw(this.nhr, var6, var3, false);
                  }

                  this.niz = var12;
                  this.nhh.put(this.nhr, var6.pos());
                  this.nlg(var11);
               }
            } else {
               Vec3d var9 = this.nhh.get(this.nhr);
               boolean var10 = var5 || var9 != null && var9.distanceTo(var2.getEntityPos()) <= 36.0;
               if (var10 && var8) {
                  this.niz = this.niy != null ? this.niy : var7.tier;
                  this.nlg(false);
               } else if (!var10 && var3 - this.nix > 6000L) {
                  this.nht = false;
                  this.nly(nff.DECIDE);
               }
            }
         }
      }
   }

   void nla(ClientPlayerEntity var1) {
      if (this.ngz.status() != qdw.WORKING) {
         pzc var2 = this.nhg.get(this.nhr);
         this.ngz.guard(var2 != null && var2.distanceTo(var1.getEntityPos()) < 30.0 ? var2 : pzc.empty(var1.getBlockPos()));
      }
   }

   void nlb(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (var2.isOnGround() || var2.hasVehicle()) {
         BlockPos var5 = nle(a.d("刱⮛ꅏ㼯듮㉐蠚Ǹ龡", -454491144, 1331646957));
         if (var5 == null) {
            this.nlc(a.c(-2032489325, "ꢱ턈忎얠乶죄狥ﭠ愤\uef8f桘鈩ᲀ蕅༚觮㎬및⚵\ua48fⷳ圤\ud98c䉚쐴仳\uf74f礇\ue3e3斴\uee89"), var3);
         } else {
            Vec3d var6 = Vec3d.ofCenter(var5);
            Vec3d var7 = this.nhh.get(this.nhr);
            if ((var7 == null || !(var7.distanceTo(var6) > 48.0)) && !(var6.distanceTo(var2.getEntityPos()) > 48.0)) {
               pzc var8 = this.nld(var1, var7, var5);
               this.nha.equip(var1, var2);
               this.ngz.park(var8, var5, true);
               this.njf = true;
               if (this.njk == null) {
                  this.nma(a.b("㗅䱘웼峮팣冈\uefba晈\uf816狛\uf502ཻ臝\u181a鉃ᒾꫭ", -2062011956) + var5.toShortString(), vhz.NAV);
               }
            } else {
               this.nlc(a.b("斃ᰱ難࣮茳֊뾨㘯ꡲ⛛", 1024483784) + var5.toShortString() + a.d("津ႀ驗Э迴ॊ댝", 1962118724, -1142430906), var3);
            }
         }
      }
   }

   void nlc(String var1, long var2) {
      this.njj = var2 + 3000L;
      if (!var1.equals(this.njk)) {
         this.njk = var1;
         this.nma(a.c(-509177717, "钃\ued1a揜例牮\uf4a8䪘이夦힇吵깇ₑ륜㌅뗼࿂聥\u1ad4颇ᅪ") + var1, vhz.ALERT);
      }
   }

   pzc nld(MinecraftClient var1, Vec3d var2, BlockPos var3) {
      pzc var4 = this.nhg.get(this.nhr);
      if (var4 == null || var2 != null && !(var4.distanceTo(var2) <= 30.0)) {
         if (var2 != null) {
            pzc var5 = pzc.detect(var1.world, var2);
            if (var5 != null) {
               this.nhg.put(this.nhr, var5);
               return var5;
            }

            for (Entry var7 : this.nhg.entrySet()) {
               Vec3d var8 = this.nhh.get(var7.getKey());
               if ((Integer)var7.getKey() != this.nhr && var8 != null && !(var8.distanceTo(var2) > 3.0)) {
                  pzc var9 = (pzc)var7.getValue();
                  int var10 = (int)Math.round(var2.x - var8.x);
                  int var11 = (int)Math.round(var2.y - var8.y);
                  int var12 = (int)Math.round(var2.z - var8.z);
                  return new pzc(var9.minX + var10, var9.minY + var11, var9.minZ + var12, var9.maxX + var10, var9.maxY + var11, var9.maxZ + var12, var9.ores);
               }
            }
         }

         return pzc.empty(var3);
      } else {
         return var4;
      }
   }

   static BlockPos nle(String var0) {
      String[] var1 = var0.trim().replace(',', ' ').split(a.b("囐⽎ꗅ", -1219733873));
      if (var1.length < 3) {
         return null;
      }

      try {
         return BlockPos.ofFloored(Double.parseDouble(var1[0]), Double.parseDouble(var1[1]), Double.parseDouble(var1[2]));
      } catch (NumberFormatException var3) {
         return null;
      }
   }

   void nlf(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      this.njb++;
      if (this.nht && this.ngz.status() != qdw.WORKING) {
         this.nla(var2);
      }

      if (this.njb % 20 != 0 || var2.hasVehicle() || !this.nls(var1, var2, var3)) {
         if (this.njb % 3 == 0) {
            Vec3d var5 = this.nhh.get(this.nhr);
            pzp var6 = pzw.read(var1, 72.0);
            if (var6 != null) {
               var5 = var6.pos();
               if (!this.njc && this.niw >= 0 && var6.seconds() > this.niw + 20) {
                  this.njc = true;
                  this.njd = this.njb;
                  this.nlw(this.nhr, var6, var3, false);
               } else if (!this.njc && var6.seconds() >= 0) {
                  this.niw = this.niw < 0 ? var6.seconds() : Math.min(this.niw, var6.seconds());
               }
            }

            if (!this.njc && this.njb > 200) {
               this.njc = true;
               this.njd = this.njb;
            }

            if (this.njc && this.njb - this.njd >= 12 && this.njb % 6 == 0) {
               if (var5 == null) {
                  var5 = var2.getEntityPos();
               }

               pzc var7 = pzc.detect(var1.world, var5);
               pzc var8 = this.nhg.get(this.nhr);
               if (var8 != null && var8.distanceTo(var5) > 30.0) {
                  var8 = null;
               }

               if (var7 != null && (var8 == null || var7.volume() >= var8.volume() || !var8.covers(var7))) {
                  this.nhg.put(this.nhr, var7);
                  var8 = var7;
               }

               if (var8 == null || var7 == null && this.njb - this.njd <= 60) {
                  if (this.njb - this.njd > 80) {
                     this.nma(a.b("\uf8dd腄ྂ问Ḵ飽⊷ꬬㅨ뿊㡪쉫䲱픅弨\ud9d4柰\uec49皂\uf0a6祖̎", -805569322), vhz.ALERT);
                     this.ngx.mined(this.nhr);
                     this.nly(nff.DECIDE);
                  }
               } else {
                  this.nlh(var1, var2, var8, var3);
                  this.nma(
                     a.c(559037012, "㹈䟝촏危\ud8d8娇")
                        + (this.niz == null ? a.b("\uda8eꍇ⧡랗㱁", -1178542397) : this.niz.title())
                        + (this.nhr > 0 ? a.c(-1065965862, "\ua6fe\udb52册쯭") + this.nhr : ""),
                     vhz.PLAYER
                  );
               }
            }
         }
      }
   }

   void nlg(boolean var1) {
      this.njb = 0;
      this.njc = var1;
      this.njd = 0;
      this.nly(nff.SETTLE);
   }

   void nlh(MinecraftClient var1, ClientPlayerEntity var2, pzc var3, long var4) {
      this.nja = var4;
      this.ngx.mined(this.nhr);
      this.nko();
      this.nha.equip(var1, var2);
      this.nha.unstow(var2);
      this.ngz.start(var3);
      this.niw = -1;
      this.nly(nff.MINE);
      this.nlm(var1, var4);
   }

   void nli(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      PlayerInventory var5 = var2.getInventory();
      if (!this.nlp(var1, var2, var3)) {
         this.nha.unstow(var2);
         if (this.niu && !this.nha.busy()) {
            this.niu = false;
            this.nit = this.nha.laidOut();
            this.nma(
               this.nit
                  ? a.c(-849848680, "劒⬆ꇚ㾬둳㊽袜ĝ齎ᆓ鈠校\ue6f1罌\uf51a珣즯䙶")
                  : a.d("뤙삸䨚퐐忆\ud97c挫\uead4璁蘒秮莗ॕ钇ả顖−귈㜊녖㳁䚜찰埠톓嬲\ue2fd泒\uf62b琔﮸ը輮ᛞ邎", 2084836137, 79474227),
               this.nit ? vhz.CHECK : vhz.ALERT
            );
         }

         if (this.njr % 20 == 0) {
            if (this.nls(var1, var2, var3)) {
               return;
            }

            pzp var6 = pzw.read(var1, 72.0);
            if (var6 != null) {
               if (this.niw >= 0 && var6.seconds() > this.niw + 20) {
                  qqm var16 = this.ngx.entry(this.nhr);
                  this.niz = var16 != null ? var16.tier : this.niz;
                  this.nlw(this.nhr, var6, var3, false);
                  this.niw = var6.seconds();
                  this.ngz.stop(var1);
                  this.nlg(true);
                  return;
               }

               if (this.nhr >= 0) {
                  this.nlw(this.nhr, var6, var3, false);
                  this.ngx.mined(this.nhr);
               }

               this.niw = var6.seconds();
            }

            if (!qof.holdsPickaxe(var2) && !this.nha.busy() && !this.nha.equip(var1, var2)) {
               this.nma(a.c(-1295647491, "\uf8e9腰\u0bd4采Ḋ颹⊒\uab19㕄"), vhz.ALERT);
               this.nlz();
               return;
            }

            if (this.nit && this.njr % 400 == 0 && qpw.misplaced(var5, qpw.targets(var5, var2.getOffHandStack())) > 3) {
               this.nit = false;
            }
         }

         if (!this.nit && !this.niu && this.njr % 20 == 10 && !this.nha.busy() && !this.ngz.breaking() && qpw.ready(var5)) {
            this.nma(a.d("̒竽\uf05b渡\ue5f5捏\udd09僥캷䐇쎥㦤띾⻌ꂍ♰顟\u17fe贼ଖ苠\uf8ba瘍\ueda3殥\ue176墻튄䱫쨿䆃뽕㔒겜⪽ꁼᾧ", -1514716050, 561005380), vhz.INFO);
            this.nha.layout();
            this.niu = true;
         } else {
            if (this.nit && this.njr % 10 == 5 && var3 - this.niv > 3000L && !this.nha.busy()) {
               this.nll(var1, var2, var3);
            }

            boolean var14 = var1.interactionManager != null && var1.interactionManager.isBreakingBlock();
            if (!this.nha.busy() && !var14 && this.njr % 5 == 0 && var3 - this.njl > 5000L) {
               int var7 = qof.empty(var5);
               if (var7 <= 2) {
                  if (qof.hasJunk(var5, ngn)) {
                     this.nlj(var2);
                     this.ngz.avoid(var2.getEntityPos(), 1200);
                     this.njl = var3;
                     this.nje = false;
                  } else if (!this.nje && var7 == 0 && !this.nit) {
                     this.nje = true;
                     this.nma(a.b("᭙拍\ue811癧ﶸ筶셗䣖횅塘\udb94⇤꼶㚂볒", 1890197326), vhz.ALERT);
                  }
               }
            }

            long var15 = this.njx() ? this.ngx.leaveAt(var3, this.nhr, this.niz, var3 - this.nja, this.ngy) : Long.MAX_VALUE;
            boolean var9 = var3 - this.nja > nka();
            qqm var10 = this.nhr >= 0 ? this.ngx.entry(this.nhr) : null;
            boolean var11 = var10 != null && var10.refreshAt > this.nja + 20000L && var10.refreshAt - var3 < 20000L;
            qdw var12 = this.ngz.status();
            if (var3 >= var15 || var9 || var11 || var12 == qdw.DONE || var12 == qdw.FAR) {
               if (this.nha.busy()) {
                  return;
               }

               int var13 = this.ngz.diamondsLeft();
               this.nma(
                  a.c(-477125922, "ꛋ\udf57喎쯻䀭욓糋\uf121")
                     + this.ngz.mined()
                     + a.d("躖\uf337积\ue799求\ueaf4傮\ud953", 1755230930, -1212269460)
                     + (
                        var11
                           ? a.c(1658862849, "㴀撅칢呻\udfd4夐\ue344櫇\uf088繘刺\u0382贫ᓭ黏ᱟꈎⷐ띯ㄽ룆슝䱔힆凷\udf45曺\uecbd癈\uf06e羾蕺ད")
                           : (
                              var12 != qdw.DONE
                                 ? ""
                                 : (
                                    var13 > 0
                                       ? a.b("䄚㢧뙪⡤ꎰ╳鼫ᛟ裿Ƀ臼", -1625210563) + var13 + a.c(1319975349, "㦇怂쫥傀\udb53巩\ue7cd游\uf01a纾ﵰ܉跋ၠ騷᳇ꚇ⤨")
                                       : a.c(487681882, "潻ᛆ顽ٴ跖ୠ녁㲠ꛠⰭ\uabfc冎\udf2b")
                                 )
                           )
                     ),
                  vhz.CHECK
               );
               this.ngz.stop(var1);
               this.nko();
               this.nhs = -1;
               if (var12 == qdw.FAR) {
                  this.nht = false;
               } else if (qof.hasJunk(var5, ngn)) {
                  this.nlj(var2);
                  this.njl = var3;
                  this.nje = false;
               }

               this.nly(nff.DECIDE);
            }
         }
      }
   }

   void nlj(ClientPlayerEntity var1) {
      this.nha.dropJunk(64);
      this.njo = new Object();
      Vec3d var2 = var1.getEyePos();
      Vec3d var3 = null;
      pzc var4 = this.nhr >= 0 ? this.nhg.get(this.nhr) : null;
      if (var4 == null) {
         var4 = this.ngz.area();
      }

      if (var4 != null && var4.maxX >= var4.minX) {
         Vec3d var5 = var4.center();
         double var6 = var2.x - var5.x;
         double var8 = var2.z - var5.z;
         double var10 = Math.sqrt(var6 * var6 + var8 * var8);
         if (var10 > 1.5) {
            var3 = new Vec3d(var6 / var10, 0.0, var8 / var10);
         }
      }

      if (var3 == null) {
         Vec3d var12 = var1.getRotationVec(1.0F);
         double var13 = Math.sqrt(var12.x * var12.x + var12.z * var12.z);
         var3 = var13 < 0.1 ? new Vec3d(0.0, 0.0, 1.0) : new Vec3d(var12.x / var13, 0.0, var12.z / var13);
      }

      this.njn = var2.add(var3.x * 4.0, 2.2, var3.z * 4.0);
   }

   void nlk(MinecraftClient var1, ClientPlayerEntity var2) {
      pzc var3 = this.nhr >= 0 ? this.nhg.get(this.nhr) : null;
      if (var3 == null && this.nkg()) {
         var3 = this.ngz.area();
      }

      if (var3 != null && var3.maxX >= var3.minX && !(var3.distanceTo(var2.getEntityPos()) > 64.0)) {
         if (this.njr % 10 == 0) {
            qwo.scan(var1.world, var3, var2.getEyePos());
         }

         qwo.focus(this.ngz.focus());
      } else {
         qwo.clear();
      }
   }

   void nll(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      PlayerInventory var5 = var2.getInventory();
      if (qpw.count(var5, Items.ANCIENT_DEBRIS) <= 0 && qof.empty(var5) <= 0) {
         boolean var6 = !var1.world
            .getEntitiesByClass(ItemEntity.class, var2.getBoundingBox().expand(6.0, 3.0, 6.0), var0 -> var0.getStack().isOf(Items.ANCIENT_DEBRIS))
            .isEmpty();
         if (var6) {
            int var7 = -1;
            if (var5.getStack(32).isOf(Items.GOLD_INGOT) && var5.getStack(32).getCount() == 1) {
               var7 = 32;
            } else {
               for (int var8 = 9; var8 < 36 && var7 < 0; var8++) {
                  if (var5.getStack(var8).isOf(Items.GOLD_INGOT) && var5.getStack(var8).getCount() == 1) {
                     var7 = var8;
                  }
               }
            }

            if (var7 >= 0) {
               this.niv = var3;
               this.nha.throwOne(var7);
               this.nma(a.d("\udd11ꓴ⹒뀤㯼뵈ܚ諲Ⴓ騍ᷔ\ue7a0極\uf0c6窑\uf87a䘨짴块픑峤⚼ꠈ㏗놽᭘苟\u0890鈘ᐺ龅慛\ueb1b狢\uf4b3縆솯侰쵼哌\ude99ꑼ⨲궋㝚뤦ӫ註ఎ韚᧕", -1482987976, 2095038222), vhz.INFO);
            }
         }
      }
   }

   void nlm(MinecraftClient var1, long var2) {
      int var4 = this.njx() ? this.nhr : 0;
      if (!this.nhe.active() && var4 >= 0 && var4 != this.nln() && !this.nhi.contains(var4)) {
         this.nis = var4;
         this.nhe.begin(var1, a.c(2061203581, "砚Ƽ譣ᔎ黎"), var2);
      }
   }

   int nln() {
      Matcher var1 = nfu.matcher(this.ngo.get());
      if (!var1.find()) {
         return -1;
      }

      try {
         return Integer.parseInt(var1.group(1));
      } catch (NumberFormatException var3) {
         return -1;
      }
   }

   String nlo(ClientPlayerEntity var1, long var2) {
      if (this.nln() > 0 && var2 >= this.nir) {
         if (qdz.trapped(var1.getEntityWorld(), var1) != null) {
            return null;
         } else if (var1.getHealth() < 3.0F && this.nlq(a.c(1760422779, "\ueb11銸"), var2)) {
            return a.b("ᕇ泮", 1859523885);
         } else {
            int var4 = qpw.pickaxeDurability(var1);
            if (var4 >= 0 && var4 < 190 && !this.nhd.repairFailed() && this.nlq(a.b("࣠煈ﮑ旨", -1479407468), var2)) {
               return a.d("縷胸ਡ鑘", -1009286406, 1505131486);
            } else if (qpw.count(var1.getInventory(), Items.DIAMOND) > 576 && this.nlq(a.c(-5401926, "鋖\ueb6a憱ￌ琙\uf2a9䣰섖"), var2)) {
               return a.b("餉\ue0b5橮\uf413翆略䌯쫉", -2124179099);
            } else {
               return qpw.food(var1) < 3 && this.nlq(a.b("뿸와䲓틩", -1445216358), var2) ? a.d("\uf0c0襸Ϋ鷑", -297550931, 590891791) : null;
            }
         }
      } else {
         return null;
      }
   }

   boolean nlp(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      int var5 = qpw.pickaxeDurability(var2);
      if (var5 < 0 || var5 >= 190) {
         this.njh = false;
         return false;
      }

      if (this.nls(var1, var2, var3)) {
         return true;
      }

      if (qdz.trapped(var2.getEntityWorld(), var2) != null) {
         return false;
      }

      this.ngz.stop(var1);
      if (!this.njh) {
         this.njh = true;
         this.nma(
            a.d("鎷\uea24悏ﺄ留\uf7e2䶫", 814208338, 1379156728)
               + var5
               + a.d("ⓞ奰폜䷓왽䂶\ufae6獨\ued34柿\ue434㹱邒ാ蝥ց믔㐁꺳⣭ꅤ\udf57凨칞䠤슉笵\uf51e殂\ue9ce扵颱\u169f輔ू菱㰪똩ヴ괩❾", -1988406299, 358971186)
               + (this.nln() <= 0 ? a.d("듭촧䟵\ud98f剜탹溷\ue74e約\uf3a2瑶踃Ð饬", 1099415619, -1221365535) : a.b("㩃䎉쥛圡\udcf2幗\ue01b槫\uf7bd納\ufadd", -1994113527))
               + a.b("\udabd", 775346837),
            vhz.ALERT
         );
      }

      this.nly(nff.IDLE);
      return true;
   }

   boolean nlq(String var1, long var2) {
      Long var4 = this.nhj.get(var1);
      return var4 == null || var4 <= var2;
   }

   static String nlr(String var0) {
      return switch (var0) {
         case a.d("긂\ud7ab", 643588259, 1846267595) -> a.d("ꔍ\udcb0器제䟕섌筇", -1273960703, -1706211785);
         case a.d("훾꽖▏믶", -1774369912, -1863871230) -> a.d("\ud95aꃩ⩂둉㾔봵ͽ誉ᓔ鹩ᦿ\ue3b9浭\uf4d2", 1435623102, 1451885520);
         case a.d("『䦲썩崔훁偱\uea28揎", 1969823512, 359608186) -> a.d("떔찤䛴\ud888卒퇽澾\ue644砜\uf2a1畵輍ǖ", -617383317, 1768868814);
         default -> a.c(-1216190610, "捙\u1aec逼ื薗̣뤇ヵ꺤⁺ꎼ姌휟");
      };
   }

   boolean nls(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      String var5 = this.nlo(var2, var3);
      if (var5 != null && !this.nha.busy()) {
         if (this.njx() && this.nhr != this.nln() && qof.hasJunk(var2.getInventory(), ngn) && var3 - this.njm > 15000L) {
            this.njm = var3;
            this.ngz.stop(var1);
            this.nlj(var2);
            this.njl = var3;
            return true;
         }

         this.ngz.stop(var1);
         this.njf = false;
         this.niq = nlr(var5);
         this.nma(a.b("棆ᅚ龙։踥\u0895닍㬸ꅩ⯂", -915510063) + this.niq, vhz.NAV);
         this.nht = false;
         this.nhs = -1;
         int var6 = this.nln();
         if (this.nhd.atHome(var1.world, var2, 6.0)) {
            if (this.njx()) {
               this.nhr = var6;
            }

            this.nin = 2;
            this.nhd.begin(var3);
            this.nma(a.c(-819613283, "떦찂䛒\udcb6匂퇐濢\ue668砶\uf28c畛輮ש뱬ᘋ铫⺠ꅳ㿗릉〹䩯쓞弇"), vhz.CHECK);
         } else if (this.njx() && this.nhr != var6) {
            this.nhv = var6;
            this.nhw = var3;
            this.nid = 0;
            this.nie = 0L;
            if (pjd.enter(this.nmb(), String.valueOf(var6))) {
               this.nkq(var1, var2);
               this.nin = 0;
            } else {
               this.nin = -1;
               this.nma(a.b("閩\uec35拶\uf8e6獊\uf5fa侢왗堉횭唝꼙⇍뱩㘩냋ນ腅ᮎ鶯ᐥ樑쒖罳ﴚ矉츍䐿\udad6峾휿⦛ꎡ㩑밎", 1280479639), vhz.INFO);
            }
         } else {
            this.nin = 1;
            this.nip = false;
         }

         this.nio = var3;
         this.nly(nff.BASE);
         return true;
      } else {
         return false;
      }
   }

   void nlt(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      switch (this.nin) {
         case -1:
            if (this.njr % 20 == 0 && pjd.enter(this.nmb(), String.valueOf(this.nhv))) {
               this.nhw = var3;
               this.nid = 0;
               this.nie = 0L;
               this.nkq(var1, var2);
               this.nin = 0;
               this.nio = var3;
               this.nhq = var3;
            }
            break;
         case 0:
            if (this.nkr(var1, var2) || this.nib) {
               this.nhr = this.nhv;
               this.nin = 1;
               this.nio = var3;
               this.nip = false;
               return;
            }

            if (this.nic) {
               if (this.nid >= 3) {
                  this.nlv(
                     var1,
                     var2,
                     false,
                     a.d("踩\uf7e3紱\ue34b梘\uea3d", 1245035298, -1869860532) + this.nhv + a.b("\u2e6b叇\ud91c䝬첱䩿\uf02f租\ue7fc浇\uea9c", 212938304),
                     var3
                  );
               } else if (this.nie == 0L) {
                  this.nie = var3 + 2500L;
               } else if (var3 >= this.nie) {
                  this.nid++;
                  this.nie = 0L;
                  this.nkq(var1, var2);
               }

               return;
            }

            if (var3 - this.nhq > 20000L) {
               this.nlv(var1, var2, false, a.d("➰帉탏䪡섊䞹\ufde9瑢\uea3e悊\ue347ᴫ鏱๐聢ۨ벦㍼꧋⮎", 1454982008, -1086299935) + this.nhv, var3);
            }
            break;
         case 1:
            if (!this.nip) {
               if (var3 - this.nio >= 1500L && (var1.currentScreen == null || var1.currentScreen instanceof DeathScreen)) {
                  if (this.nhd.atHome(var1.world, var2, 6.0)) {
                     this.nin = 2;
                     this.nhd.begin(var3);
                     this.nma(a.d("笈ʬ衼መ鶬\u1f7eꅌ⣆뚘㰢믵䆀쭇狂\ud8a5婅\ue00e濝\uf179眧ﺗ蓁ੰ醩", 1407884293, 1144709942), vhz.CHECK);
                     return;
                  }

                  this.nip = true;
                  this.nig = 0;
                  this.nkv(var1, var2, var3, a.b("葒\ufde4眵\ue94c", -662141890));
                  return;
               }

               return;
            }

            boolean var8 = var1.world != this.nii || var2 != this.nij || var2.getEntityPos().distanceTo(this.nih) > 2.5;
            long var6 = this.nik > 0L ? this.nik + 5000L : this.nif + 12000L;
            if (var8 || this.nig >= 2 && (this.nil || var3 > var6)) {
               this.nin = 2;
               this.nhd.begin(var3);
               return;
            }

            if (this.nil || var3 > var6) {
               this.nkv(var1, var2, var3, a.d("뇟졩䊸\udcc1", 800187716, 1199985911));
            }
            break;
         default:
            this.nhd.repairTo = nlu(var2);
            this.nhd.xpStock = 576;
            this.nhd.junk = ngn;
            qsq var5 = this.nhd.tick(var1, var2, this.nha, this.nhb, this::nkh, var3);
            if (var5 != qsq.RUNNING) {
               this.nlv(var1, var2, var5 == qsq.DONE, null, var3);
            }
      }
   }

   static int nlu(ClientPlayerEntity var0) {
      ItemStack var1 = var0.getMainHandStack();
      if (!var1.isIn(ItemTags.PICKAXES)) {
         int var2 = qof.bestPickaxe(var0.getInventory());
         var1 = var2 >= 0 ? var0.getInventory().getStack(var2) : var0.getOffHandStack();
      }

      return var1.isIn(ItemTags.PICKAXES) && var1.getMaxDamage() > 0 ? Math.max(200, var1.getMaxDamage() - 2) : 1500;
   }

   void nlv(MinecraftClient var1, ClientPlayerEntity var2, boolean var3, String var4, long var5) {
      this.nhd.stop(var1);
      if (var4 != null) {
         this.nma(var4, vhz.ALERT);
      }

      if (var3) {
         this.nit = this.nha.laidOut();
         this.nma(a.d("祼Ö訄ᑾ龭ᴈꍈ⪴뒗㹚릅䟪줱咒\udecd堵\ue27f淜\uf71f焷\uf8b9芖ప韶ᗥ鬮⊙곉㘱뀒㮯", -963045390, 872180400), vhz.CHECK);
      } else {
         this.nir = var5 + 120000L;
      }

      for (String var7 = this.nlo(var2, var5); var7 != null; var7 = this.nlo(var2, var5)) {
         this.nhj.put(var7, var5 + 600000L);
         this.nma(a.b("˹筓\uf181濻\ue428暍\ud8c3儺쭰䗞숌㡿뚪⼖ꅌ➧", 1594754760) + nlr(var7) + a.d("奭èꨏち뮷㴌蝕ຬ郱ᨷ馇揧\ued31璐\ufadf簪왠", 1805252886, 749576266), vhz.ALERT);
      }

      this.nht = false;
      this.nhs = -1;
      this.nly(nff.DECIDE);
   }

   void nlw(int var1, pzp var2, long var3, boolean var5) {
      if (var1 >= 0 && var2 != null) {
         qwj var6 = var2.tier();
         if (var6 == null) {
            var6 = qwj.COMMON;
            if (!var2.tierWord().isEmpty() && !this.njq.contains(var2.tierWord())) {
               this.nma(a.b("湟ំ鴘ͦ袴ข됥㷗ꏷ⤰꺑價\uda4d䏿짒伯\uf567窾\ue07c扛\uebb6", -1238406569) + var2.tierWord(), vhz.INFO);
            }
         }

         qqm var7 = this.ngx.entry(var1);
         boolean var8 = var7 == null || var7.tier != var6 || var7.refreshAt < var3;
         this.ngx.seen(var1, var6, var2.seconds(), var3);
         this.nix = var3;
         if (var5) {
            this.ngx.hopTook(var3 - this.nhw);
         }

         if (var8 && this.nhp != nff.MINE && this.nhp != nff.SETTLE) {
            this.nma(
               (var1 > 0 ? var1 + a.d("늋쬠", -312439239, 1876573322) : "") + var6.title() + a.b("瀪\u0dfc蝝ᥙ鋻ᑈꨌ", -1059753971) + clock(var2.seconds() * 1000L),
               vhz.INFO
            );
         }
      }
   }

   void nlx() {
      this.ngy.tiers = this.nkb();
      this.ngy.waitMs = 30000L;
      this.ngy.leadMs = 7000L;
      this.ngy.minMineMs = njz();
   }

   void nly(nff var1) {
      if (this.njf && var1 != nff.WAIT) {
         this.njf = false;
         if (var1 != nff.SETTLE) {
            this.ngz.stop(this.mc);
         }
      }

      if ((this.nhp == nff.WAIT || this.nhp == nff.SETTLE) && var1 != nff.WAIT && var1 != nff.SETTLE && var1 != nff.MINE && this.ngz.guarding()) {
         this.ngz.stop(this.mc);
      }

      this.nhp = var1;
      this.nhq = System.currentTimeMillis();
   }

   void nlz() {
      if (this.ngw != null) {
         this.setEnabledSilently(false);
      } else {
         this.setEnabled(false);
      }
   }

   void nma(String var1, vhz var2) {
      this.njq = var1;
      if (this.ngw != null) {
         this.ngw.report(a.b("㸺䞿쵭匇\ud8f2幧\ue433淉\uf3c9祢", 1288519281) + var1, true);
      } else {
         System.out.println(a.c(1436539112, "\ud8a3ꄦ⯴떞㹫룾ʪ譐ᕐ鿻") + var1);
         izx.alert(this.getName(), var1, var2, true);
      }
   }

   Object nmb() {
      return this.ngw != null ? this.ngw : pjd.MAIN;
   }

   public static String clock(long var0) {
      long var2 = Math.max(0L, (var0 + 999L) / 1000L);
      return String.format(Locale.ROOT, a.d("\udeadꝝⷐ뎾㡼뻏ӊ", 1360934432, 1274669231), var2 / 60L, var2 % 60L);
   }
}
