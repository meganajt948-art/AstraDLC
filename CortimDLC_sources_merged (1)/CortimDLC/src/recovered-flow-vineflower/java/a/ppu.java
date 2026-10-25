package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class ppu {
   private static final List<ppn> ppv = new ArrayList<>();
   public static final String[] WARDEN_DEFAULTS;
   public static final String[] END_DEFAULTS;

   private ppu() {
   }

   private static void ppy(String var0, String var1, String var2, Item var3, Predicate<ppi> var4) {
      ppv.add(new ppn(var0, var1, var2, var3, null, var4));
   }

   private static void ppz(String var0, String var1, String var2, Item var3, String var4, Predicate<ppi> var5) {
      ppv.add(new ppn(var0, var1, var2, var3, var4, var5));
   }

   private static void pqa(String var0, String var1, String var2, String var3) {
      ppz(
         var0,
         var1,
         var2,
         Items.TOTEM_OF_UNDYING,
         a.d("샐鼿㎴궸", -45210801, 1910498240) + var1,
         var1x -> var1x.is(Items.TOTEM_OF_UNDYING) && var1x.named(a.b("겦핥徽쇏䩡청盲．", 1504749804)) && var1x.named(var3)
      );
   }

   private static void pqb(String var0, String var1, String var2, String var3) {
      ppz(
         var0,
         var1,
         var2,
         Items.PLAYER_HEAD,
         a.d("햲詝⛖룚", -945253084, 1679638729) + var1,
         var1x -> var1x.is(Items.PLAYER_HEAD) && var1x.named(a.c(-303489311, "᪤挐\ue9b2瞶")) && var1x.named(var3)
      );
   }

   private static boolean pqc(ppi var0) {
      return var0.is(Items.TNT)
         && (var0.named(a.c(551348825, "\uee6f韜ᴆ茌")) || var0.lore().contains(a.c(-1636467348, "祎ӭ踯ၟ鮘᥉ꍪ⪜냔㸄릮䏜쵼咼\udee7堖")))
         && !var0.lore().contains(a.c(-747489610, "㋭䬢쇰忾푖勨\ue8bf慆ﬄ疧\uf271ࠉ蚠ὣ锲Ꮁ꧰≍볠㪾댹중䞮\udc73娄탘"));
   }

   private static boolean pqd(ppi var0) {
      return var0.is(Items.TNT)
         && (var0.named(a.d("矂\u0e79蓜\u1ada", -47719745, 847882568)) || var0.lore().contains(a.b("砤ǫ謹ᔷ麟ᠡꉶ⮏뇍㽮뢸䋀챩喪\udffb奸\ue339梄\uf629灷藺菘൧隺Ⴭ騑", -2080015233)));
   }

   private static boolean pqe(ItemStack var0) {
      PotionContentsComponent var1 = var0.get(DataComponentTypes.POTION_CONTENTS);
      if (var1 == null) {
         return false;
      }

      boolean var2 = false;
      boolean var3 = false;

      for (StatusEffectInstance var5 : var1.getEffects()) {
         if (var5.getEffectType() == StatusEffects.SLOWNESS && var5.getAmplifier() >= 5) {
            var2 = true;
         } else if (var5.getEffectType() == StatusEffects.MINING_FATIGUE) {
            var3 = true;
         }
      }

      return var2 && var3;
   }

   static String norm(String var0) {
      return var0 == null ? "" : var0.replaceAll(a.d("꾌횴", -971103781, 1691913970), "").toLowerCase(Locale.ROOT).replace('ё', 'е');
   }

   public static List<ppn> entries() {
      return Collections.unmodifiableList(ppv);
   }

   public static ppn byId(String var0) {
      for (ppn var2 : ppv) {
         if (var2.id.equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   public static boolean known(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         ppi var1 = new ppi(var0);

         for (ppn var3 : ppv) {
            if (var3.test(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean picked(ItemStack var0, Collection<String> var1) {
      if (var0 != null && !var0.isEmpty() && var1 != null && !var1.isEmpty()) {
         ppi var2 = new ppi(var0);

         for (ppn var4 : ppv) {
            if (var1.contains(var4.id) && var4.test(var2)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   static {
      ppy(a.b("很☰곶㊊륛㿹", 1992122347), a.b("\u2fe4噃\udc93䊘쥍俷", 8072143), a.b("窣̻觽ខ鱐\u1af2", 1621129952), Items.ELYTRA, var0x -> var0x.is(Items.ELYTRA));
      ppy(
         a.d("픦겜♞렳㏩땏༇蛫ᢥ鈮ᗃ\uefa1慩\uf8da犔", 1179686682, 2135245405),
         a.b("鲷\ue52e濿\uf18c種ﳧ䛎콃儐\udba3小ꈑ⣗넗㬺뷈ߵ", -632710981),
         a.c(1554930742, "屨◲꼰ㅝ몇㰡虩྅釋ᬿ鲭曏\ue807熴ﯽ紋"),
         Items.NETHERITE_CHESTPLATE,
         var0x -> var0x.is(Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS)
      );
      ppy(
         a.d("\ud8c6ꅼ⮢뗘㸆뢸˱謑ᕏ鿅ᠨ\ue248沟\uf532罨", -982452078, -1805901762),
         a.c(-1467032061, "\uda21ꎇ⤤뜯㳲"),
         a.d("蚮Ｔ痪\ueb90恎\ue6f0岹학䬇쇲䙦밟㋋ꭲ℠\ua7daᷛ鉋ࣩ躸ݓ紋", 825121515, -1441276906),
         Items.ENCHANTED_GOLDEN_APPLE,
         var0x -> var0x.is(Items.ENCHANTED_GOLDEN_APPLE)
      );
      ppy(
         a.c(493346155, "\udd00꒹\u2e69뀐㯆뵼ܞ軑႟騮ᷡ\ue799"),
         a.d("礀ï詎ᐻ", -1441007588, 1837270283),
         a.b("ꆝ\ud804勔청䝻쇁篜\uf26c氢\ue693慜鬤", 370778582),
         Items.GOLDEN_APPLE,
         var0x -> var0x.is(Items.GOLDEN_APPLE)
      );
      ppz(
         a.c(-1205783175, "㔆䲨왠堌폝啭\uef0f曀\uf88d爼\uf5fdྞ腉ᣢ銶"),
         a.b("\u09d1灂犯撙\uef37涓폰婐쐏仏쥭㍥붷␋", 1725959624),
         a.b("檉ጊ駙\u07ba豿\u0ace낇㥱Ꝡⶁꩍ倧\udeed䝚초", -1256953145),
         Items.SPLASH_POTION,
         a.b("⛸礗햜䮐쑰䋣\uf8be焸\uef1e憺\ue259\u1879隮\u0f6e蕌τ릎㙒", 1828595377),
         var0x -> var0x.potion() && var0x.named(a.d("痠ఠ蛳ᣳ鍕ᖝ꿋", 1985594937, 1800189934))
      );
      ppz(
         a.b("ŕ磻\uf233江\ue78e愾\udb5c劂쳌䙰솮㯚딀Ⲷ", 435224875),
         a.c(1619101214, "舆ﮕ煈\uef4e擠\ue644堨퇶侢씓䋋뢾㙥꿑▏"),
         a.c(-1366289518, "Ꮜ橌\ue092绮\uf53c玀짔䁫\ude64哊팂⥮ꞿ㸏"),
         Items.SPLASH_POTION,
         a.d("\uf474ꮛܐ餜\u16fc遯⨲ꎴ㶒댶ペ쪄䑘\udde9垱텄欇\ue4d3繭", 123527339, -1655171945),
         var0x -> var0x.potion() && var0x.named(a.c(-993828030, "杴Ỏ鐖\u0a63膸܌"))
      );
      ppz(
         a.c(-38489841, "녭죛䈋\udc6f垞턇歂\ue2a6糨\uf64e"),
         a.d("尾▜꼲ㅎ뫫㰥舙\u0ffa醩ᬒ鳅", -653846741, 951930687),
         a.c(-1117748023, "蒋ﴝ矍\ue9a9戧\ue4c1庄흠䤮쎈"),
         Items.SPLASH_POTION,
         a.c(1261188329, "㒽歒쟙姕혃傡\uea8f捳ﵞ瞐\uf42c\u0a4f蒔ᴯ靸"),
         var0x -> var0x.potion() && var0x.named(a.b("뎓쩑䃿\ude83", 10270678), a.b("ᵆ擻\uee22", 2127305079))
      );
      ppz(
         a.d("䈵㮛녓⼿ꓮ≞頼ᇠ辬Ԙ苆碿\uf67d濑\ue584捴", 1245408680, 1400319997),
         a.d("鰱\ue5a2潿\uf179竗\uf873䘠쿁冚\udb27峼\ua6fb⡒뇣", -522086188, -1452080900),
         a.c(1706467736, "ꇚ\ud858劎쳲䜭솉篇\uf230汮\ue691愒魼ᖰ谜ى肹"),
         Items.SPLASH_POTION,
         a.c(-1338719422, "쌋鳤は깣Ↄ꜐ᵍ铋૭葉ޚﷻ猨\uea95惎\ue649屸펩"),
         var0x -> var0x.potion() && var0x.named(a.c(-293906100, "崊Ⓥ긜ち뮾㵹"))
      );
      ppy(
         a.b("ꌘ\udaa4偿츂䗗썧社", 1674945403),
         a.d("兽⣧ꈳ㱎랞", 985145774, -1207536442),
         a.c(2001530860, "\uefaf阳᳨芕ी述㖩"),
         Items.DIAMOND,
         var0x -> var0x.is(Items.DIAMOND)
      );
      ppy(
         a.b("㳭䕆쾐击\uda3f岙", -80069480),
         a.c(-1975569187, "・䥞쏸巼혯僯\ueac2"),
         a.d("뎪쨡䃷\ude9c啘폾", -401249092, -181149885),
         Items.IRON_NUGGET,
         var0x -> var0x.is(Items.IRON_NUGGET) || var0x.named(a.c(2048451876, "\ue163颦ሀ谄ߗ脗"))
      );
      ppy(
         a.d("\uf42d趗ݕ餸ዢ鑄⸌\ua7e0㦮댥㓚캻䁽\ud9df厝", -1801098853, 1785634263),
         a.c(-1856546800, "専▛꽊ㄹ몛㱒虻\u0ff6醥᭭鳌护\ue868燜ﮍ"),
         a.c(-1039906447, "䤰オ멨␅꿟⥹錱\u1add蒓\u0e67觧玆﵀擢\ueea0"),
         Items.NETHERITE_SCRAP,
         var0x -> var0x.is(Items.NETHERITE_SCRAP) && !var0x.says(a.c(-1745747946, "ё緢\uf741椿\ue2ed")) && !var0x.says(a.b("盄ཽ藛ᮩ遵ᚴ곣┞묾㗠똩䱙슀孆텭垖", 1498378985))
      );
      ppy(
         a.d("櫘።馠ߍ谗\u0ab1냹㤕ꝛⷐꨵ偃\ude9d䜤쵬", 541523191, -287271346),
         a.c(2086506760, "锇\uec9e晏\uf83c玞\uf557佾웳墠퉨嗉ꮡ℗룜㊌됇ิ臡"),
         a.c(-1676022844, "\ueb85鈟ᣝ蚰൪诌ㆄ롨☦곒⭈턾忠왙䰑"),
         Items.NETHERITE_INGOT,
         var0x -> var0x.is(Items.NETHERITE_INGOT)
      );
      ppz(
         a.b("濱ᙜ鲂ˡ褱", 1170173828),
         a.c(-1120623904, "\ua6fa\udf6f喷쮷䁣"),
         a.b("銘\ueb15懋ﾨ瑸", -2040098099),
         Items.DRIED_KELP,
         a.d("ꆯ﹀勋쳇䌯얺翢\uf662栾", 618015154, -1402042289),
         var0x -> var0x.named(a.d("\uf3bc訉Ñ黑ᔅ", 726831236, -714971390)) || var0x.lore().contains(a.b("ᦾ怇\ueaa1瓓／秎쎙䩤푄媚\ud928⍚귺㑃븝", -1005904500))
      );
      ppz(
         a.d("럵칂䒂\udae2", 538464726, 639100499),
         a.d("䵧㒴븗\u2069ꮻⴀ", -1732131992, -45446613),
         a.d("逨\ue9bf捿ﴟ", -1391792039, 296968225),
         Items.NETHERITE_SCRAP,
         a.d("閞쩱曺\uf8f6眣\uf1f0䯓숭屷훌", 223401160, 2008105223),
         var0x -> var0x.named(a.d("繁菪ॉ霷᳥", 1371283130, -955719516)) || var0x.lore().contains(a.d("䚠㼙떿⯍ꀑ⛐鲇ᕺ譚ք虍簽\uf2e4欢\ue109柲", -1292669463, 1684352868))
      );
      ppz(
         a.b("﵏蓳ฺ遗ᮝ鴷❨꺒プ", 1104084258),
         a.b("⧷偧\udab6䓎콧䦮\uf3f0稉\ue429滪\ue94fፀ鷠", -1809633810),
         a.c(1409999717, "\ue32f骳ၺ踗ם荷㤨냒⺗ꐳ⏵\ud999坈컸"),
         Items.ENDER_EYE,
         a.d("檘㕷駼߰蠓\u0e83듒㴪ꌋ⧂긜呥\udacd䌎줫侤\uf59c", 1423153719, 1119613157),
         var0x -> var0x.named(a.d("队\uefaf敾ﬆ炯\uf666䰸엁寡", 1310121864, 1058622890))
            || var0x.lore().contains(a.b("ᬚ抮\ue80c瘄\ufdd7筪섻䢵튅尦\udbf9\u218d꽜㛠", -747495645))
      );
      ppz(
         a.b("鷝\ue47d溨\uf0de", -1126916675),
         a.c(435515271, "殢ሎ飒ڮ贆࿘놔㠑\ua63e\u2cf8"),
         a.b("\uea63鏽ᤧ蝒ಖ詵ぢ릂⟛국", 3729962),
         Items.SUGAR,
         a.d("엓騼㚷ꢻ❣ꇏᮓ鉯\u0c4f芑ŝﭘ痿\uec39", 1022584, 851927038),
         var0x -> var0x.named(a.c(-228622604, "窱ͽ覡៝鱵ẫꃧ⥢띍㶋")) || var0x.lore().contains(a.b("ⵢ咠\ude74䁲쯙䵤\uf735纻\ue48b樨\ued88ជ餤\u0096誷ౌ", 469510451))
      );
      ppy(
         a.b("䨬㎖륔✹곣⩅逍᧡螯ത諛炮﹡柍\ued88", -1395963315),
         a.c(1631283885, "溿ᜦ鷷΄蠦\u0eef듆㵋ꌘ⧐깱候\udad2䍪쥋"),
         a.b("领\ue11c毞\uf5b3繩\uf8cf䊇쭫唥\udfd1塑ꈤⳫ땇㼂", -184510265),
         Items.NETHERITE_SWORD,
         var0x -> var0x.is(Items.NETHERITE_SWORD)
      );
      ppy(
         a.d("᭲招\ue806百ﶠ笀셈䢸훖屋\udb80⇯꼡㚐", 711787658, 909975429),
         a.b("䳕㕶뿐⇔ꨉ⢧隕\u1f1f腏௰谭瘫\uf88e", 950683903),
         a.d("⌞媗큊串여䍌滑烴\ueee5搇\ue3ccᦣ靭ໜ", 2002283328, -263305213),
         Items.SKELETON_SKULL,
         var0x -> var0x.is(Items.SKELETON_SKULL)
      );
      ppy(
         a.d("䇲㡝늓⳾Ꜥↂ鯼ሡ豦ۉ脃筲", 961595070, -282228937),
         a.c(950326828, "툘ꮻℝ뼙㓄뙪ࠫ臐ᾀ锳ን\uec89昲\ufff8疤\uf35b䤚욼屽"),
         a.c(594610565, "ে灈惘擫\uef31榗펖娴쑳仌줖㍮붨␂깐⣯鋳ᴺ螗ǟ蠨"),
         Items.WITHER_SKELETON_SKULL,
         var0x -> var0x.is(Items.WITHER_SKELETON_SKULL)
      );
      ppy(
         a.b("ꍠ\udac7倇칰䖯쌟祽\uf0bb滩\ue45c掊", 1792058127),
         a.b("槜၀骖Ӣ輹ঊ량㨬ꐇ⻆ꤟ卪\uddbe䐂", -1890751039),
         a.d("㖧䰠웠増퍈嗸\uefe5晜\uf80e犻\uf56d", 1475361449, -266858687),
         Items.DRAGON_HEAD,
         var0x -> var0x.is(Items.DRAGON_HEAD)
      );
      ppy(
         a.b("림쀜䫘풩彫\ud9cf掋\uea57琿ﺃ祔茠", 376617427),
         a.c(257180978, "䄯㢳뉥Ⱁꟊⅹ鼺ዑ賴ؽ臩箒\uf530泱"),
         a.d("\uda82ꌂ⧆랷㱵뫑\u0095褶ᜡ鶝ᩊ\ue03e", -1828484852, -1606331455),
         Items.CREEPER_HEAD,
         var0x -> var0x.is(Items.CREEPER_HEAD)
      );
      ppy(
         a.b("䚌㼨뗹⮇ꁛ⛦鲏ᕉ講Ʈ虸", -715569411),
         a.c(1583419353, "ெ牚\uf88c書\ued23殐헓堵왣䳐쬎ㅶ"),
         a.b("\ueae3鍧ᦶ蟈ఔ誩タ뤆❔귡⨷", -161158478),
         Items.ZOMBIE_HEAD,
         var0x -> var0x.is(Items.ZOMBIE_HEAD)
      );
      pqa(
         a.b("쌑몵に긟◒ꍽᤢ郜າ萨϶歷睈\ueef6撿", -1533623446),
         a.d("됂춡䝹\ud90b劥푩渶\ue7ca綈\uf33b瓲軻\\駠Ꮎ", 1666285515, 1609748452),
         a.b("ᐴ涨\ue770礒\uf2ca瑡칦䟃\ud989匵퓣⺈ꁁ㧼뎠", -944368529),
         a.c(575781703, "뼀웋䱠퉡妻")
      );
      pqa(
         a.d("ᕨ泌\ue612硦\uf3ab甄콛䚥\ud8cb剁햟⿴ꄳ㢎닀㐧", 375966693, 150134505),
         a.c(225563974, "텴꣗∏뱽㟓넟ୀ芼\u18fe陏ᆌ\uebfa攮ﲕ皸\uf039"),
         a.c(490772696, "颌\ue110毙\uf5b8繣\uf8cf䊊쬿唴\udf90塎ꈺ\u2cf7땘㼇맹"),
         a.b("Ẩ杩\uedbd珏\uf812绝", -886105362)
      );
      pqa(
         a.b("馟\ue03b櫥\uf491罜麟䎬쩒吼\udeb5奭ꌟⷈ둻", 2044762597),
         a.d("㡢䇁쬙啫\udec5堉\ue256殪\uf1e8罥\uf8ea˫谶ᖍ", -253363394, 1813694320),
         a.c(-1484232133, "橲Ꮸ餸݉貜\u0a60끧㦃ꟑⵥꪬ僃\ude18䞦"),
         a.c(-2082699703, "艱﮼焟\uef64")
      );
      pqa(
         a.b("缟ڻ豥ሑ駜έꔬⳒ늼㠥뿩䖙쭕勺", -1517584539),
         a.b("ࢣ焀ﯘ斪\uee04棈튗孫섩侪졓㉟벍┳", 207490191),
         a.c(-1650061035, "ᅌ棂\ue210籺\uf7b3煎쭉䊭\udcff噋톂⯭ꔶ㲈"),
         a.c(781903205, "\ue153飨ቆ谲")
      );
      pqa(
         a.b("틠ꭄ↚뿮㐣늌࣓脭ὃ闉ማ\ue862暷＇", 2014827162),
         a.d("᳖敵\uefad營况粽웢伞한寙\udc2b♓ꢆㄴ뭪", -1969584396, -1259954673),
         a.b("톯\ua83f⋤벗㝁놾ஹ艝ᰏ隻ᅲ\ueb1d旆ﱸ", 1642123749),
         a.d("\ude96Ꜧⷼ뎏㡛", -324348246, -2045965299)
      );
      pqb(
         a.d("賮\uf55c羗\ue1eb樫\uec8d囤\udf28䅰쯅䰄뙲", -2038242190, 1179609315),
         a.d("㻎䜚춸厼\ud81b媺\ue4d8洍\uf326禔︽ь", -974556827, 1299336070),
         a.b("Ꝗ\udec0吗쩴䆤읁絁\uf4b3櫴\ue048枌鷪", 1689167640),
         a.c(-697467885, "砧ƒ謵ᕇ黪")
      );
      pqb(
         a.d("ᶁ搳\ueef8炄פּ緢잋乌퀙媪\udd6a✜꧍", 302369294, -465315855),
         a.c(1911423427, "ש簽\uf69f梛\ue33c憝\udff6嘥조䊱씒"),
         a.c(-506034797, "藗ﱌ皝\ue8ff振\ue598徘혺䡦싏䔑뽷ㆷ"),
         a.b("噦⿕ꔌ㬍", -1762241958)
      );
      pqb(
         a.c(-1142328475, "猚ન聣ḟ闟፹ꤐ\u20cd뺀㐤돺䦀"),
         a.c(2047740562, "\u0ebf睫\ufdc9揍\ue86a櫋풙嵹썔䦟츴㐵"),
         a.c(-1716747717, "艤ﯧ無\uef5d撁\ue262塢톐俗앫䊯룉"),
         a.c(400786432, "聄濾猥\ued2e暁")
      );
      pqb(a.c(-235941052, "팼ꪎ⁅븹㗹덟श胹ẵ鐓Ꮦ"), a.d("첮땺㿘ꇜ⩻\ua8daᚹ鼘Ĳ请ౕ", -336948477, 142826375), a.b("㛞作얘寿큻嚙\uecc9攠ﭲ燔\uf610", -1960823148), a.b("뵿쒾丘퀝", 1200863563));
      pqb(
         a.b("줏낽㩶ꐊ⿊ꥬጅ髈Ҝ踤৹\uf394", -1306998416),
         a.c(2050139772, "ꉖ\udb82儠켤䒃옢硴\uf190濁\ue50f抭"),
         a.d("䊍㬗뇍⾲ꑹ⊛颛ᅩ輮֒艖砰", 1567420290, 1948560704),
         a.c(323029787, "ཚ皞ﱃ才")
      );
      pqb(
         a.c(-1284985063, "꽦훔尟쉣䦣켅畬ﲪ拤\ue848澍闯"),
         a.d("礸ì詎ᑊ鿭ᵌꌬ⫶뒥㹠릸", -333958042, 537545076),
         a.c(-1114907422, "\udca6ꔦ\u2fe8놏㩋벻ڻ轉ᄎ鮲ᱶ\ue610"),
         a.b("ぉ䧳쌬崩", 1415066750)
      );
      ppz(
         a.b("뭼싇䠒홙嶰\udb12慁\ue8ad盪", -666518756),
         a.c(-1717581917, "쎐멂ん꺗╎ꏴᶷ遘จ蒳ͮ爛矈\uee71搪\ue2d3墙휿"),
         a.d("딓첈䙝\ud869叿핝漎\ue6e2碥", -502354647, 1982732410),
         Items.TIPPED_ARROW,
         a.b("Ꟁ\ude12哃쫇䄞잤秧\uf408橘\ue0e3朾鵎᎘訡z蚃㳉덯", -87251981),
         var0x -> var0x.is(Items.TIPPED_ARROW, Items.ARROW, Items.SPECTRAL_ARROW) && (var0x.named(a.b("⟾幀풙䫦섰䞀\ufddb", 483009479)) || pqe(var0x.stack))
      );
      ppy(
         a.d("穳ϊ褚ᝣ鲵ᨏꁭ⦠럽㵟몌䃠츬", 1241889509, 581746940),
         a.c(-528931311, "∉宑텇伳쒘䉛\uf877痩\uefaa攙\ue2b4ᢿ陬࿑藼"),
         a.c(28539829, "篿ɦ袶ᛏ鴙ᮣꆾ⠌뙑㳳묠䅌쾀"),
         Items.GOLDEN_CARROT,
         var0x -> var0x.is(Items.GOLDEN_CARROT)
      );
      ppz(
         a.c(788737602, "⸭垔\udd4c䌆죯乊\uf41e緼"),
         a.c(1620625019, "쉠믾ㄥ꼮⓺꘤ᡧ釥ྐྵ蕸"),
         a.c(-600921045, "걦헿弧섕䪖챴癦ﾃ懛\ueb79"),
         Items.PHANTOM_MEMBRANE,
         a.d("螞\ud871瓺\ueaf6攐\ue38e姕큞丂샜䌟뤝㟉금", 1201463737, 1944413810),
         var0x -> var0x.named(a.b("\uee39鞇ᵜ荗ࢃ詝㐞붜⏀꤁", 801040898)) || var0x.lore().contains(a.c(-401036654, "꺲휌巗쎥䠆캴璗ﵡ挶\ue987湙鑗ữ荎८辜㖣"))
      );
      ppy(
         a.d("ࣃ煺ﮆ旊\uee10梺틩嬀앖", -331341151, 433662483),
         a.d("㼊䚚창剅\uddf0孉\ue500沂\uf2a9簍\uffc1\u05cc譯ኢ飺ṳꀭ", -158234232, -423054707),
         a.b("ᅾ棇\ue264簝\uf783焿쭬䋑\udccc噰톸⯉ꔆ㲾뛻ぐ", 1904021814),
         Items.EXPERIENCE_BOTTLE,
         var0x -> var0x.is(Items.EXPERIENCE_BOTTLE) || var0x.named(a.d("⣨儥\udb82䖏칓", -64566524, -1095505962), a.b("\ue8de酮ᯉ薱", 1190259940))
      );
      ppz(
         a.d("숼뮏ㅗ꼝⓳ꉍ᠏", 1526512223, 578320393),
         a.d("㛙佊얓寮큅嚈\uecd9攢\ufb0f燂\uf66fࡾ芶ᬆ鄬អ귨∾뢏", -266329091, -417328853),
         a.b("鸞肦\u0a60鐀῟饵⍴\uaac8㒕븯㧱쎏䵗퓪庮", -1977222787),
         Items.AMETHYST_SHARD,
         a.c(830177205, "翹₲貝ኑ鵺ᯩꆰ⡍뙮㲣뭲䄉쾬噡\udc4c廝\ue08d潝\uf597玹碑耝ຬ"),
         var0x -> var0x.named(a.b("揅᩶邯໒蕹", -318347268), a.c(-1471142272, "⊹嬉톣侭쑿䋉")) || var0x.lore().contains(a.d("앃벻㙧ꠇ", -2043381265, 1998896263))
      );
      ppy(
         a.c(752452763, "蓿﵌瞔\ue9de户\ue489廂휬䥶"),
         a.b("霬\ueebf摦福熰\uf77d䴬쓗嫺퀷垚ꦋ⍁뫽イ뙑ఒ菁\u1979齟ᛙ沍", -1486449882),
         a.d("쒞봀㟋ꦥ≷ꒊẔ靧ळ莏ѓ︭烶\ue950", -15122157, -919697982),
         Items.ANVIL,
         var0x -> var0x.named(a.c(-177161691, "븜잯䵶팋墠"), a.c(864407516, "쯨뉔㢍\ua6f8ⴣꮐᇈ顎٠")) || var0x.lore().contains(a.c(258996763, "免菍ऑ靸Ჰ騄"))
      );
      ppz(
         a.d("\ue00c馿፧购ۃ聸㨾", 670561634, -1379920636),
         a.b("퍥꫶ 빒㗹댴॥肞ẳ鑾Ꮣ\uedc2朊ﺺ瓬\uf277䠫있", 1080219499),
         a.c(-1926107569, "\uee06鞝ᵋ茴࣬蹁㑆뷺⎧ꤝ⻃풽婥쏘䦜"),
         Items.FEATHER,
         a.d("鹶섽洒\uf31e糵辶䀿짂埡\udd2c嫽ꂆ⸣럮㷃뽒Ă軒ᑤ鉟ᮻ憘", -1022346221, -1282235864),
         var0x -> var0x.named(a.b("爿\u0b8c腕Ἠ钃", -397642234), a.b("幵⟅괓㍬료", 387471951)) || var0x.lore().contains(a.c(-370318277, "搐ᷨ霱ॕ"))
      );
      ppy(a.b("ꭔ틢堵왆䶝쬭", -1246909648), a.c(1413715739, "錃\uea9e怲︶"), a.c(475317492, "쒰봦㟱ꦂ≙ꓩ"), Items.BEACON, var0x -> var0x.is(Items.BEACON));
      ppz(
         a.b("皤༝藕᮲遳ᛟ겓", -1470138686),
         a.c(1717550364, "뤋삒䨹퐼徟\ud950挂"),
         a.c(1213492644, "淢ᑻ麳Ô謕ඹ럵"),
         Items.REDSTONE_TORCH,
         a.b("㺋慤췯口\udc04媝\ue0b6椳\uf718緗洞", -487244069),
         var0x -> var0x.says(a.d("پ翇\uf56c歩\ue0ca昅\udc57", 515868926, -46495049)) || var0x.says(a.b("縠ޙ赑ጶ飷ṛꐗ", 429293126))
      );
      ppy(
         a.b("㈅䮯셶弆퓕剡\ue809懆ﾔ甽\uf2fb࢙", -890883460),
         a.b("ज炆館搯\uef88椵휊嫦쒱七짞㏕뵸", -1270739711),
         a.b("偝⧗ꌎ㵾뚭〙討ξ鷬ᝅ邃櫡", -46379004),
         Items.RESPAWN_ANCHOR,
         var0x -> var0x.named(a.b("콑뛫㱁ꉂ⧥", 371575652))
      );
      ppz(
         a.d("훯꽁▓믿〹뚲ೊ蔡᭤", 728374698, 17746747),
         a.b("冘⠋ꋑ㳛", 1076254094),
         a.c(161929615, "\ud9d1ꁟ⪍듡㼧맓ϴ訟ᑚ"),
         Items.TNT,
         a.b("\ue16c뺃ለ谄ϡ蕲㼨뚢", -2079465153),
         ppu::pqc
      );
      ppz(
         a.c(511588213, "㜞亡쑿娌퇓坖\ued2e擅婢"),
         a.d("쟓빈㓭ꫫ", 1907055573, 1403361299),
         a.d("\ue194頋ዕ貦ݹ膃㮤뉏Ⰺ", -766324956, -1867567365),
         Items.TNT,
         a.d("昍㧢镩\u0b65蒃Ș렽ㆻ", 1187915557, 757285243),
         ppu::pqd
      );
      ppy(
         a.d("\uf3fb詐\u0099", 433585094, -543225782),
         a.b("봠쒮乂", 1654700289),
         a.d("䧌で몮", -2040388159, 2130472026),
         Items.TNT,
         var0x -> var0x.is(Items.TNT) && !pqc(var0x) && !pqd(var0x)
      );
      ppy(
         a.b("箒ȫ裰ᚖ鵒ᯮꆵ⡿또㲼뭸", -507806724),
         a.b("ｈ蛖\u0c71鉿᧔齦╂겺㋨렦㮚얋䭟튙壎", 305920863),
         a.d("梤ᄽ鯦ր蹄ࣸ늣㬖ꔆ⾪ꡮ", 80330609, -229779557),
         Items.EMERALD_ORE,
         var0x -> var0x.is(Items.EMERALD_ORE, Items.DEEPSLATE_EMERALD_ORE)
      );
      ppy(
         a.b("蘸ﾁ畑\ueb28惄\ue643尗헯䮸섒", 28804693),
         a.b("檣ጻ駭ޙ谲ઊ낧㵃Ᵹⶶꩦ偭\udec2䝱", -1885835590),
         a.b("獓\u0aca耚ṣ闰ገ\ua95c₤뻳㑙뎍", 1948218143),
         Items.GOLD_INGOT,
         var0x -> var0x.is(Items.GOLD_INGOT)
      );
      ppz(
         a.b("剌⯾ꄡ㽘뒔㈼补Ɯ", 1919111720),
         a.b("⒬嵁ퟬ䧪숱䓽ﺬ獅\ued12掹\ue419Ḝ铗", 1502093503),
         a.d("豬\uf5fe缡\ue158檔\uec3c噥\udf9c䇛쬹䳢뛚㠀ꆱ⮧", 755428469, 1054367834),
         Items.TRIPWIRE_HOOK,
         a.b("朮㣁鑊\u0a46薯͂륯ラ꺺⑶ꎯ巎휃䪨쓺䉮\uf850矴\ued37歪", 568747873),
         var0x -> var0x.named(a.c(1071882697, "ꗱ\udc3c嚑좗䍌얀"))
      );
      ppy(
         a.d("述\uf654粅\ue2fb椧\uef9a嗳\udc2b䉫죟伌땰㮡ꈒ⡖꺊ᓿ鬬Ɵ", -481212018, -1144207849),
         a.c(706705522, "籃פ轈ᅁ麈ᰦꘊ⾃뇓㬞벴䛇찀冦\udbfc崏\ue74d梕\uf633瑵ﷸ蟜छ鋉ᒸ鹪➫\ua9ff㌍땑"),
         a.d("끈짌䌝\udd63嚿퀂樔\ue3b3緳\uf747炔諨й鶊៎酭⭱꒣㸁롆ㆨ䮷앁庒\ud8ed", -1488811659, 1166227838),
         Items.ZOMBIE_VILLAGER_SPAWN_EGG,
         var0x -> var0x.is(Items.ZOMBIE_VILLAGER_SPAWN_EGG)
      );
      ppy(
         a.c(1406428896, "暚ἴ闢ஓ聉۾벯㕉ꬻ↰ꙡ尐"),
         a.c(-1263965053, "梴ᄓ鮿ֶ詿࣑닽㭴ꔤ\u2fe9ꡃ到\ud8f7䕜콵䧱\uf3ca簘\ue6a5惷\ue972錦ᶐ虌"),
         a.d("䐣㶭띻⤊ꋐ⑧鸶័觝̿蓯纏\uf04e槦\ue3fb敏\udf02僓", -389978299, 624108322),
         Items.VILLAGER_SPAWN_EGG,
         var0x -> var0x.is(Items.VILLAGER_SPAWN_EGG)
      );
      ppy(
         a.b("\ue074駎ጌ赡ڻ耝㩣뎾ⷦꝂ₂", -1796284399),
         a.d("ㅐ䣄숐屣ힷ儂\uef41抍ﳺ癉\uf198ஜ蔻", -1818981322, 2138093948),
         a.d("\uee32鞨ᵪ茇ࣝ蹻㑺뷘⎀ꤤ⻤", 213035091, -2069936604),
         Items.NETHER_STAR,
         var0x -> var0x.is(Items.NETHER_STAR)
      );
      ppz(
         a.c(1657008156, "\uf073觔̔鵣ᚼ逌⩮ꎳ㷴띇ん"),
         a.c(-1972314615, "\uda10ꏵ⥖뜭㳾멌\u001a觪Ꭼ鵼\u1ad4\ue0a7湵"),
         a.c(1838766282, "墅ℂꯂ㖵빪㣚苇\u0b65锢ᾑ顅"),
         Items.PAPER,
         a.c(1738150982, "ᐌ䯣\ue768祤\uf687灢쩁䎺\udde1坓킅⫵ꀻ㷫럃\u3130譺"),
         var0x -> var0x.says(a.d("蒟ﵚ矹\ue982扑\ue4e3庵흅䴃쏓䑻븈ペ", -770411799, -487198129))
      );
      ppz(
         a.d("퓴굂➚맸㈰뒜\u0eda蜨\u1979鏁ᐨ\uee75悺契獝", -1694811504, 349367810),
         a.d("ʘ笁\uf1df澡\ue470担\ud895兯콆䖅왏㡟뛳⽀ꔖ", 2008182811, 1051096721),
         a.d("㬉䊟졇嘥\udded孁\ue107棵\uf6a4簜ﮊƨ轧ᛔ鲀", 130342645, -543627846),
         Items.PAPER,
         a.d("䀲῝덖ⵚꊰ\u2429鹷ញ觐ͥ蒵经\uf06e榭\ue7e7敷\udf43傐쨦", -2022593794, 885713540),
         var0x -> var0x.says(a.c(210283351, "꽥훜専쉼䦭켘畈ﲲ抛\ue858殒閂ᬮ芝࣋"))
      );
      ppy(a.b("鱑\ue5f2漺\uf155窝ﰴ䙴쾄凌", 954113087), a.b("∜完턡伮쒂", 1477649926), a.c(-571710519, "掇ᨄ郌ຣ蕫ς릂ひ긺"), Items.GUNPOWDER, var0x -> var0x.is(Items.GUNPOWDER));
      ppy(
         a.b("堒↴꭫㔝뻂㡺舴\u0bd4閍Ἵ飕抟\uec49痸ﾾ祌쌜䳀홦倦", 420829300),
         a.b("潵ᛝ鱴ɰ覭༘딡㲼ꋣ⠤꾅凭\udb29䊐좻丸\uf47e箪\ue119朾\ueebb郳ᨡ膊߾财㒙못", -1404802230),
         a.c(1705574857, "Ə砉\uf2d6沠\ue77f懇\udb89剩찰䚀섗㬢뗴ⱅꘃ\u20f1骡ᕽ进ছ"),
         Items.REINFORCED_DEEPSLATE,
         var0x -> var0x.is(Items.REINFORCED_DEEPSLATE)
      );
      ppy(
         a.b("靲\ueec0搄頻熵\uf70f䵆쒦嫸큲垛귶⌽", 226400025),
         a.d("꺮휳嶐쎙䡋컹璦ﵕ指\ue9b6渓鐐Ở荰ब辮㗥멋\u20f9ꊱ⽕唌\udbb4䁢", 78109679, 1977643333),
         a.b("⮌刞\ud8da䚴쵫䯑\uf198硸\ue626泓\ueb53ᄡ鿯ٓ谁૧냺㽮ꗁ⎌", 1132800990),
         Items.FERMENTED_SPIDER_EYE,
         var0x -> var0x.is(Items.FERMENTED_SPIDER_EYE)
      );
      pqa(
         a.c(-1308272221, "姚⁾ꪠ㓔뼙㦶菩ਗ鑹ự餱捇\ued9b"),
         a.c(1122483047, "뽊웩䰱퉃姭\udf21敾\uec82盀\uf87e翂藍\u0b65鋗\u18fe"),
         a.d("䖢㰠뛴⢎ꌀ◥龣ᙟ蠅ʮ蕣缞\uf1c6", -709624419, 1210038388),
         a.b("弜⚢갏㈁맕", 1336302422)
      );
      ppy(
         a.c(189845985, "톅꠸⋩벞㝳뇵\u0bab艞ᰄ"),
         a.c(-14872251, "ᕗ泋\ue61a硬\uf3ce畷코䚨\udce2剂헣\u2feaꄶ㢅늯"),
         a.b("涀ᐝ黌»謩ැ랎㹻ꀡ", -1637585468),
         Items.HEAVY_CORE,
         var0x -> var0x.is(Items.HEAVY_CORE) || var0x.named(a.c(-1450786264, "옝뾡㕰ꬆ₤ꘝ᰾闂"))
      );
      ArrayList var0 = new ArrayList();
      ArrayList var1 = new ArrayList();

      for (ppn var3 : ppv) {
         if (!var3.id.equals(a.b("皲༖藈ᮼ遱ᛞ겁╿묑㆙뙙䰯싳", -943360309)) && !var3.id.equals(a.c(564215680, "㿤䙙첈勿\ud912徔\ue5ca氿\uf265"))) {
            var0.add(var3.id);
         }

         var1.add(var3.id);
      }

      WARDEN_DEFAULTS = var0.toArray(new String[0]);
      END_DEFAULTS = var1.toArray(new String[0]);
   }
}
