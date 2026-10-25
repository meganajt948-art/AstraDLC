package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public class oxw extends kfe {
   private static final String oxx = a.c(-312694930, "ꜯ\udead呥쨮䇄읱紪");
   private static final String oxy = a.b("븅잓䵃팧壞\ude57搙\uedf6玡", 741654084);
   private static final String oxz = a.c(47142108, "咅ⴃ\ua7d4㦨뉿㓛躦ݯ餭ᎂ鑙");
   private static final int oya = 10;
   public static final long FLASH_MS = 700L;
   private static oxw oyb;
   private final vlv oyc = this.add(
      new vlv(
         a.b("ꕥ\udce2嘦졓䎗씱", 145728816),
         a.b("꒢\udd20埨즣䉉쓼级", 922658019),
         a.b("ἴ暶\uec7e爵履罪씱", 1607802741),
         a.c(638333618, "㋳䭥솵忑퐨务\ue8ef愀ｗ"),
         a.b("ꨖ펐奇윻䳬쩈瀵識枾\ued11櫊", 287550031)
      )
   );
   private final vlq oyd = this.add(new vlq(a.d("嬩⊥ꡧ㘞분㭢脮࣒隍ᰵ", 1578664880, 238278874)));
   private final vkl oye = new vkl(a.c(1094840059, "\ueaf9錚ᦱ蟋ఞ読㓮뤀❞궐⨹큆媄윢䵶쯷熷\ufe1d撪"), true);
   private final vkl oyf = new vkl(a.b("꼰훞将숊䧕콠焩ﳊ暇\ue854濵閍᭟苪ࢼ蹃", 1593289535), true);
   private final List<oxf> oyg = new ArrayList<>();
   private final vyn oyh = new vyn(true);
   private final vvn oyi = new vvn();
   private boolean oyj;
   private oxf oyk;
   private oxf oyl;
   private oxf oym;
   private oxt oyn;
   private int oyo;
   private boolean oyp;
   private int oyq;
   private float oyr;
   private boolean oys;
   private int oyt;
   private int oyu = -1;
   private int oyv = -1;
   private boolean oyw;
   private static final float oyx = 83.0F;
   private static final float oyy = 93.0F;
   private static final float oyz = 3.0F;
   private static final float oza = 40.0F;
   private static final float ozb = 65.0F;
   private static final float ozc = 1.6F;
   private static final float ozd = 1.2F;
   private static final float oze = 30.0F;
   private static final float ozf = 55.0F;
   private static final int ozg = 0;
   private static final int ozh = 1;
   private static final int ozi = 0;
   private static final int ozj = 1;
   private static final long ozk = 120L;
   private static final long ozl = 220L;
   private int ozm;
   private long ozn;
   private oxf ozo;
   private float ozp;
   private float ozq;
   private float ozr;
   private float ozs;
   private static final int ozt = 12;
   private int ozu;
   private int ozv = -1;
   private boolean ozw;
   private double ozx;
   private float ozy;
   private float ozz;

   public oxw() {
      super(
         a.b("櫭፪馮ߛ谟હ냐㤌Ꝛⷷꨱ偗", 1940810418),
         a.b(
            "玖ਉ胆ẽ锹Ꮞꦔ⁸빵㒢덂䤨쟅幉퐞勧\ue8e1朼\ufde7箑\uf265蠡ڼ鵕ᬷ釸⡃Ꙗ㳠몾ㄇ쾒䖯\udc69娾킂潕\ue531揌海瀇\u0ee8蒳͆駕ឯ깽Ⓝꊙ㥙띯䷷쑝䈝\ud8e6嚩\ued5f殔\ue1b2硥\uf6c4貃ଣ脦\u1ff5陉Ⱂꪮ₪뼜㗉뎫䩼샃废핲危\ue986恁︭瓠\uf2fc褛ߖ鶬ᐸ鋂⢔ꝳ㴱뮉㉂젮䛢\udd5a孞톝澼\ue673糛慠焨༺藊᱅騫უ꽏┞ꏮ㧳뀕仅쒙䍪\ud932",
            1678865321
         ),
         kfa.PLAYER
      );
      oyb = this;
      oxf var1 = this.pac(a.b("䙶㿙딍⭶", -566475259), a.b("⡄凒\udb71䔏캣䰆\uf247箱\ue599漪\ue889", 1911565400), Items.field_49098, null, null, true);
      var1.thenMace = true;
      var1.groundOnly = true;
      this.add(this.oye);
      this.add(this.oyf);
      this.oye.activeWhen(var1.key::isBound);
      this.oyf.activeWhen(var1.key::isBound);
      this.pac(
         a.c(1560444909, "羈ح賹ኛ"),
         a.d("窘̆觝៖鰂Ờꂟ⤝띁㶀", 1854470058, 1700432169),
         Items.field_8614,
         a.d("\ue473鷍\u1716褝ˉ耗㹔럖⦊ꍋ", -1485713885, 681127531),
         a.c(998070638, "夯₭ꩥ㐮뿄㥱茪"),
         false
      );
      this.pac(
         a.b("\u0dc9瑾ﺾ惞", -123925063),
         a.d("釀\ue813抰ﳎ眜\uf1a7", 991509486, -1150046710),
         Items.field_22021,
         a.b("፟櫬\ue04f縱\uf5e3獘", 353507099),
         a.d("\uda5aꏘ⤐띛㲱먄_", -1804833722, 1545647709),
         false
      );
      this.pac(a.b("䄮㢃뉝ⰾ\ua7ee", -939900581), a.b("鲟\ue50a濒\uf1d2稆", 840931461), Items.field_8551, a.b("甽ಈ虐ᡐ鎄", 164983047), a.c(-1396543912, "渙ល鵓̘裲็된"), false);
      this.pac(
         a.c(425400577, "ᥡ惁\uea14瑢"),
         a.c(570113052, "㠹䆕쭉唵\ude9d屃\ue20f殊\uf5a5罣"),
         Items.field_8479,
         a.d("≗宛텇伻쒓", 1257307274, -1990141289),
         a.c(8615486, "癿\u0ffd蔵᭾邔ᘡ걺"),
         false
      );
      this.pac(
         a.b("ឌ渰\ue4f9窔\uf15e矴춫䑑\uda14", -1414457375),
         a.b("咄ⴔꟅ㦽눔㓝躃ݺ饚᎙鐼渳\ue093", 704729245),
         Items.field_8449,
         a.d("⾅嘵\udce4䊜줵俼\uf5a2籛\ue27b梸\uef1dᔒ鮲", 709744792, 2083320612),
         a.c(1603988197, "\ueaa4錦᧮螥\u0c4f諺ァ"),
         false
      );
      this.pac(
         a.d("퉩ꯅ℗뽾㒼눎ࡐ膡", 27184182, 829890084),
         a.b("폑ꩼ₧뻕㔊뎿\u0df6耐Ṉ铵ጤ\ue92b枂︺瑤\uf29f", -488646688),
         Items.field_8543,
         a.c(-1719128060, "㑕䶘읃失틮呛\uea12柴怜猑\uf4c0\u0ecf聦᧞鎀ᕻ"),
         a.c(1228799302, "ﴇ蒅ํ逆ᯬ鵙✂"),
         false
      );
      this.pac(
         a.d("\uf43f越ݚ餴ዦ鑑⸙\ua7eb㦾", -1424707636, -196322414),
         a.d("á祎\uf398淨\ue643惹\udad8匣", -1589044391, 1401823125),
         Items.field_8436,
         a.c(1948897813, "환꾗╁묱゚똠ఁ藺"),
         a.b("珯੭肥Ữ锄Ꮁꧪ", -1351715922),
         false
      );
      this.pac(
         a.b("밫얝位턩嫰\udc57昑\ueff1熹", -2052801462),
         a.d("㾭䘏첡勝\ud978徶\ue18a汩\uf23a碁ｖ", 1702052246, -1964475887),
         Items.field_8436,
         a.b("躲\uf770緞\ue3a2标\ueec9僵\udd16䍅짾丩", 186288888),
         a.d("㧱䁳쪻哰\udf1a妯\ue3f4", 536310177, 718620689),
         true
      );
      this.pac(
         a.d("깍ퟳ崩썚䢚", 153656468, -329829699),
         a.c(-1635136676, "콀뛓㰎ꈈ⦦ꬂᕂ鲽˪衜ྍ"),
         Items.field_8436,
         a.b("笚ʩ衴ᙲ鷜ὸꄸ⣇뚐㰦믷", 1573945126),
         a.b("㒖䴔쟜妗퉽哈\uee93", -19778345),
         true
      );
      this.pac(
         a.c(-753169213, "貴\uf514翊\ue1b6橤\uecd8嚌"),
         a.c(1604969726, "\ue0e7饴Ꭹ趯\u0601蒥㫩댗ⵃꟹ\u202e\uda53咁촽"),
         Items.field_8436,
         a.d("긢힑嵌썊䣤쩀琌ﷲ掦\ue917滏钺ᩡ菕ঋ", -2013500767, -864829253),
         a.d("䕿㳽똵⡾ꎔ┡齺", 1513101542, 1286692312),
         true
      );
      this.pac(
         a.b("›妙퍊䴩웬䁝﨔珢", 1026367571),
         a.b("ｷ蛤హ鈿ᦑ鬵╶곶㊩롩㿋엃䬑튭", -1369441426),
         Items.field_8436,
         a.b("纪ܙ跄Ꮒ顬᫈ꒋⴋ더㦔븶䐾쫬卐", -1929020781),
         a.b("\ue6b3鼱ᗹ讲X蛭㲶", -1286150414),
         true
      );
      this.pac(
         a.c(1337431089, "鑊\uede8朾壟犝\uf439乷잀姞"),
         a.b("䜞㺍두⩖ꇸ⍜鵯ᓮ誵\b蟓緔\uf37d櫌", -1845542137),
         Items.field_8436,
         a.c(1498586346, "飓\ue160殽\uf5bb縕ﲱ䊂쬃啘\udfe5堾ꈹⲐ딡"),
         a.c(60727728, "ꇱ\ud873劻쳰䜚솯篴"),
         false
      );
      this.pac(
         a.b("ร瞍ﵗ挦\ue8e4", 935136853),
         a.b("㡥䇈쬘唕\udeb2堏\ue222殮\uf5f2罈", -1191035826),
         Items.field_8436,
         a.b("콈뚅㱕ꉘ⧿꽂ᕯ鳣ʿ蠅", -1121793277),
         a.d("ℨ墪퉢䰩쟃䅶שּׂ", 620989408, 1231202953),
         false
      );
      this.pac(
            a.d("Ⳍ啲\udfba䇜쨌䲾\uf6e0缑", 1042523090, -1455452304),
            a.c(770719711, "㯍䉑좌囵\udd2a宛\ue1be栽\uf27b粢\ufb09Ĉ"),
            Items.field_8814,
            a.c(-2107986114, "ꬌ튰塭옔䷋쭺煟\uf8dc抚\uec43毨釩"),
            a.d("䆗㠕닝Ⲗꝼ⇉鮒", 2113693214, -1137694776),
            false
         )
         .anyItem = true;
      this.pac(
         a.b("拞᭰釺࿇萝ʬ룽ㄕ꽌◮ꈬ", -496213315),
         a.c(-1538852560, "ﴭ蒹ฝ遧ᯉ鵷✩꺧㒗멄㶕잔䥌탸媡"),
         Items.field_8662,
         a.d("巅⑱껕ク묁㶿蟡\u0e6f鑟\u1a8c鵝杜\ue984瀰響", -1373402284, 581096108),
         a.b("쟏빙㒉ꫭ℔ꞝᷓ鐼੫", 101894030),
         false
      );
      this.pac(
         a.d("╏峡홫䡀쎑䔳ｱ", 211577353, -1927262423),
         a.b("葶\ufde8睁\ue93c抑\ue42d币펟䦢쌑䒲뻌〞ꦥ", 876118118),
         Items.field_8882,
         a.c(-1320519261, "緧є軷ႉ魛ᷠ"),
         a.b("§礱\uf3e1涅\ue67c惵\udabb協촃", -1099104026),
         false
      );
      this.pac(
         a.c(1835282946, "㉭䯃셉彥풵刅\ue84d"), a.d("짤뀶㪗ꓫ", 2130804832, -222540383), Items.field_8137, a.b("㐜䶮윏女", -1851183015), a.b("죎녘㮈ꗬ⸕ꢜዒ鬽ժ", -186070897), false
      );
      this.pac(
         a.c(-129012902, "欵ኛ頑ج跶େ넖"),
         a.c(130495059, "㙎俚앾嬄킪嘔\uec4a旄\ufff4焭\uf6f4಄艗ᮛ釂"),
         Items.field_8814,
         a.c(-41124045, "笎ʺ蠞ᙤ鷊᭴ꄪ⢤는㱍뮔䇤켷囻\udca2"),
         a.d("ႊ検\ue3cc綨\uf651烘쪖䍹\udd2e", -1600960298, 1612011549),
         false
      );
      this.pac(
         a.b("憗ᠹ銳ಟ蝕ǥ뮮㉊갖⚪ꅹ", -485727756),
         a.b("挶\u1a9b遀า藭͘봑ヷ꺯␒ꏃ姌흥仝쒃䉸ﰧ玞\ue932", -722049276),
         Items.field_8543,
         a.d("쨆돋㤐Ꝣⲽꨈᑁ馧߿赂ઓ\uf09c縵\ue78d淓\ueb28", -529626318, 188302693),
         a.d("ヺ䥬쎼巘혡储\ueae6按ﵞ", -1341882509, 1921535944),
         false
      );
      this.pac(
         a.d("鲦\ue508澂\uf1b7穫ﳘ䚃", -1386183253, -1093723806),
         a.b("ྡ瘃ﳗ拑\ue97c濎헪屪숰䢃쭊㔏믺≈ꠔ⻯", -1622471792),
         Items.field_8693,
         a.c(-1839220731, "뱔얖佂텄嫩\udc5b晿\uefff熥ﬖ磟蚺\u086f針ᮁ鵺"),
         a.b("볗앁侑퇵娌\udc85曋\uef24煳", 56999062),
         false
      );
      this.pac(
         a.b("↳堝튗䲭읧䇞", -1996348963),
         a.d("\ue8aa酇ᯠ藭ั袌㚳뭜│꿇⠝툞", -1583764493, 2023704394),
         Items.field_8287,
         a.b("\u137f檲\ue015縘\uf5c4獹쵆䂩\udef7吲폨⧫", -1543432372),
         a.c(890695166, "\uedbf鐩ỹ肝\u0b64跭㞣빌‛"),
         false
      );
      this.pac(
         a.d("犿\u0b11膛ᾦ鑲ዅꣀ", -2125315670, -1855835270),
         a.b("劧⭸ꇟ㾣둳㋈貁ա鬯ᗽ鈭栢\ue6f9罇\uf566", 1723422344),
         Items.field_8520,
         a.b("뽤웛䱼툀姐\udf6b愢\ue8db盅ﰽ羍藿ୖ鋫ᢿ鹆⑸꿌", 49396534),
         a.b("餉\ue09f橏\uf42b習拏䌕쫺咭", 510368072),
         false
      );
      this.pac(
         a.b("䠚ㆴ묾┃껗⡠鉦", -1887221643),
         a.b("휣껼\u245b먧ㇷ띌अ胦ẫ遹ឩ\ueda6捽遲烢", -630009076),
         Items.field_8350,
         a.d("\ueaf4鍋᧬螐ీ諻㒲뵋⍕ꧤ\u2e7e크庸읷䴨쯞熙︹惯", 374216430, 1806956617),
         a.b("\ufbd2艄\u0894雰ᴉ鮀⇎ꠡ㙶", 1195244435),
         false
      );
      this.pac(
         a.c(-1656506957, "뗜챲䛸\ud8c5匑햦澡"),
         a.b("滲ᜭ鶊϶蠦ຝ냔㤶ꝺ⦨깸呷\udaac䌒줳", -690328867),
         Items.field_8676,
         a.c(112623516, "篈ɷ裐ᚬ鵼ᯇꖎⱷ뉩㣘뼋䔳쾇嘵\udc18嫥\ue0ad潴\uf5b6瞂"),
         a.d("슯묹\u31e9꾍⑴ꋽᢳ酜་", 1222557523, 1551072701),
         false
      );
      this.pac(
         a.c(-1026543536, "〨䦜쌖崨훰偛\uea15揫ﶾ眚"),
         a.c(-518199713, "\ue245鯙ᅵ轾±舟㡍놹\u2fe8ꔮ"),
         Items.field_8450,
         a.c(-1529159763, "\udb97ꈫ⢇뚌㥃믭ƿ衋ᘚ鳜"),
         a.b("㜨亮쑹娅퇒坶\ued0b擂婢瀯\uf7f4", -316590223),
         false
      );
      this.pac(
         a.d("㘅侱씻嬁탋噲", 697423472, 1478549505),
         a.d("ꇒ\ud870助첢䜉솼翵\uf21a汄\ue681慛魘", 228698976, 1264914079),
         Items.field_8498,
         a.c(-756778076, "翩ث賲ዹ饒ῧꆮⱁ눟㣚뼀䔃"),
         a.c(-1732939194, "爟ங腎ἲ铥ቁ\ua83c⇵뾷㔘닃"),
         false
      );
   }

   private oxf pac(String var1, String var2, Item var3, String var4, String var5, boolean var6) {
      oxf var7 = new oxf(var1, var2, var3, var4, var5, var6);
      if (var5 != null) {
         var7.key.visibleWhen(() -> this.oyc.is(var5));
      }

      this.add(var7.key);
      this.oyg.add(var7);
      return var7;
   }

   private boolean pad(oxf var1) {
      return var1.server == null || this.oyc.is(var1.server);
   }

   public static oxw get() {
      return oyb;
   }

   public static boolean busy() {
      return oyb != null && oyb.oym != null;
   }

   @Override
   protected void onEnable() {
      this.oym = null;
      this.oyk = null;
      this.oyl = null;
      this.ozo = null;
   }

   @Override
   protected void onDisable() {
      this.oyl = null;
      this.ozo = null;
      this.pap();
      this.pas(this.mc);
      this.ozv = -1;
   }

   @Override
   public boolean keysAtStart() {
      return true;
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var2 == this.oyd.get()) {
         this.paf(var1, var2);
      } else {
         if (vzz.mods(var2) != 0) {
            this.pav(var1, vzz.baseKey(var2));
         }

         boolean var3 = this.oym != null || kvz.busy();

         for (oxf var5 : this.oyg) {
            if (var5.key.get() == var2 && this.pad(var5)) {
               if (var3) {
                  if (this.oym != var5 && var1.field_1724 != null && pag(var1.field_1724, var5) > 0) {
                     this.ozo = var5;
                     return;
                  }
               } else if (this.pae(var1, var5)) {
                  return;
               }
            }
         }
      }
   }

   private boolean pae(MinecraftClient var1, oxf var2) {
      ClientPlayerEntity var3 = var1.field_1724;
      if (var3 != null && System.currentTimeMillis() < this.ozn && pag(var3, var2) > 0) {
         this.ozo = var2;
         return true;
      } else if (!var2.groundOnly || var3 == null || var3.method_24828() || !var3.method_5805()) {
         return this.pai(var1, var2);
      } else if (pag(var3, var2) == 0) {
         izx.alert(
            wap.t(var2.name),
            wap.s(a.d("⧱偡\udaa9䒌켒䦤\uf3b9稜\ue45f滣\ue975ፍ鶝д蹴ࢎ닛㴑ꞿ⇥", -1729300789, -1187651744), a.b("哕ⵌ\ua7e8㷻눾ゝ軖ܢ饲Ꮔ鐟渑\ue0b4祵\uf353", -265531193)),
            vhz.POTION,
            false
         );
         return false;
      } else {
         if (this.oyl != var2) {
            this.oyl = var2;
            izx.alert(
               wap.t(var2.name), wap.s(a.d("ꫧ퍱妰쟐䰐쫳烬蘿杀\uedfb樥道ẍ", -560794004, -2000266041), a.b("퍣ꫳ 빔㖍뜩॥胫Ọ鑲Ꭳ\ue9db朋ﺴ瓯\uf21b䠣", 1375655789)), vhz.CLOCK, false
            );
         }

         return true;
      }
   }

   private void paf(final MinecraftClient var1, int var2) {
      ClientPlayerEntity var3 = var1.field_1724;
      if (var3 != null && var1.field_1755 == null) {
         final ArrayList var4 = new ArrayList();

         for (oxf var6 : this.oyg) {
            if (var6.potion() && this.pad(var6) && pag(var3, var6) > 0) {
               var4.add(var6);
            }
         }

         if (var4.isEmpty()) {
            izx.alert(
               this.getName(),
               wap.s(a.d("ꟁ\ude51响쫯䄮있緟\uf43d橵\ue096朕鵻Ꮇ訛N蚾㳬덮⦒꿂♻屳틖䤝", 1112071064, 1731361807), a.b("튴ꬭ↉뮚㑙닢ࢲ腎ὣ醽ቴ\ue807曞ｬ甾\uf7d6䦋쉈峣\udab7协⤙Ꞣ㰌먁゠襦", -95037774)),
               vhz.POTION,
               false
            );
         } else {
            var1.method_1507(
               new iwf(
                  new ivw() {
                     @Override
                     public String title() {
                        return oxw.this.oyc.get();
                     }

                     @Override
                     public List<ivx> slots() {
                        ArrayList var1x = new ArrayList(var4.size());
                        ClientPlayerEntity var2x = var1.field_1724;

                        for (oxf var4x : var4) {
                           int var5 = var2x == null ? 0 : oxw.pag(var2x, var4x);
                           ItemStack var6x = var2x == null ? ItemStack.field_8037 : oxw.pah(var2x, var4x);
                           float var7 = var6x.method_7960() ? 0.0F : var2x.method_7357().method_7905(var6x, var1.method_61966().method_60637(true));
                           var1x.add(
                              new ivx(
                                 var6x.method_7960() ? new ItemStack(var4x.item) : var6x,
                                 wap.t(var4x.name),
                                 a.b("ẘ", -1300488479) + var5,
                                 var7,
                                 var5 > 0 && var7 <= 0.0F
                              )
                           );
                        }

                        return var1x;
                     }

                     @Override
                     public void pick(int var1x) {
                        if (oxw.this.isEnabled() && var1x >= 0 && var1x < var4.size()) {
                           oxw.this.oyk = (oxf)var4.get(var1x);
                        }
                     }
                  },
                  var2
               )
            );
         }
      }
   }

   private static int pag(ClientPlayerEntity var0, oxf var1) {
      PlayerInventory var2 = var0.method_31548();
      int var3 = vvn.count(var2, var1::matches);

      for (int var4 = 0; var4 < 36; var4++) {
         ItemStack var5 = var2.method_5438(var4);
         if (var1.matches(var5)) {
            var3 += var5.method_7947();
         }
      }

      return var3;
   }

   private static ItemStack pah(ClientPlayerEntity var0, oxf var1) {
      PlayerInventory var2 = var0.method_31548();

      for (int var3 = 0; var3 < 36; var3++) {
         if (var1.matches(var2.method_5438(var3))) {
            return var2.method_5438(var3);
         }
      }

      return vvn.peek(var2, var1::matches);
   }

   private boolean pai(MinecraftClient var1, oxf var2) {
      ClientPlayerEntity var3 = var1.field_1724;
      if (var3 != null && var3.method_5805() && !var3.method_7325() && var3.field_7512 == var3.field_7498) {
         int var4 = pbc(var3, var2);
         ItemStack var5 = var4 >= 0 ? var3.method_31548().method_5438(var4) : vvn.peek(var3.method_31548(), var2::matches);
         if (var5.method_7960()) {
            izx.alert(
               wap.t(var2.name),
               wap.s(a.d("踲\uf7a2絪\ue34f棑\uee67呺\udddf䎜줠亶뒎㩞ꏷ⦷꽍ᔘ髒|蘦", -508470079, -1095052631), a.d("蚳Ｊ疎\uef9d恘\ue2fb岰필䬔솢䙹뱷㋒ꬓℵ", 1077347329, 1663600288)),
               vhz.POTION,
               false
            );
            return false;
         } else if (var3.method_7357().method_7904(var5)) {
            izx.alert(wap.t(var2.name), wap.s(a.c(-123049931, "桾ᇣ鬰Ղ躝ࠧ뉬㮄"), a.d("胫賈玨\uedd6昅\ue0c7嫪", 899285787, -1242855443)), vhz.CLOCK, false);
            return true;
         } else if (KeyBindingHelper.getBoundKeyOf(var1.field_1690.field_1904).equals(InputUtil.field_16237)) {
            izx.alert(
               wap.t(var2.name),
               wap.s(a.d("蕛ﳑ瘌\ue872掹\ue55c彌횲䣨쉓䖈뾲ㄬꢇ⋉ꑱṭ釨ଙ赅Ҩ绢\uf05b", -6341663, 1693892351), a.c(-448376251, "噈⿑ꄗ㭻낡㘗豎ֲ鮚ᅙ隂泾\ue639箷\uf1e1眖")),
               vhz.KEYBOARD,
               false
            );
            return true;
         } else {
            PlayerInventory var6 = var3.method_31548();
            this.oym = var2;
            this.oyo = var4;
            this.oyj = var4 < 0;
            this.oyp = !this.oyj && var4 < 9;
            this.oyq = var6.method_67532();
            this.oyr = var3.method_36455();
            this.ozp = Math.min(90.0F, pba(83.0F, 93.0F));
            this.ozq = pba(-3.0F, 3.0F);
            this.ozs = this.ozq;
            this.oyt = 0;
            this.oyv = -1;
            this.oyw = false;
            this.ozm = 0;
            if (this.oyp) {
               this.oyn = oxt.SELECT;
            } else if (this.pbb(var3)) {
               if (!this.pao(var1)) {
                  return true;
               }

               this.oyn = oxt.USE;
               this.ozm = paq(0, 1);
            } else {
               this.oyn = oxt.PREPARE;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.ozu++;
      this.oyu = var1.field_1724.method_31548().method_67532();
      this.pas(var1);
      this.pam(var1);
      this.paj(var1);
      this.pak(var1);
      this.par(var1);
   }

   private void paj(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (this.oyl != null && (!var2.method_5805() || var2.method_7325())) {
         this.oyl = null;
      }

      if (this.oym == null && !kvz.busy() && var1.field_1755 == null) {
         if (this.oyl != null && var2.method_24828()) {
            oxf var5 = this.oyl;
            this.oyl = null;
            this.pai(var1, var5);
         } else if (this.oyk != null) {
            oxf var4 = this.oyk;
            this.oyk = null;
            this.pai(var1, var4);
         } else {
            if (this.ozo != null && System.currentTimeMillis() >= this.ozn) {
               oxf var3 = this.ozo;
               this.ozo = null;
               this.pae(var1, var3);
            }
         }
      }
   }

   private void pak(MinecraftClient var1) {
      if (this.oym != null) {
         ClientPlayerEntity var2 = var1.field_1724;
         if (var2.method_5805() && var2.field_7512 == var2.field_7498 && var1.field_1755 == null) {
            switch (this.oyn) {
               case SELECT:
                  PlayerInventory var3 = var2.method_31548();
                  boolean var4 = var3.method_67532() != this.oyo;
                  if (var4) {
                     var3.method_61496(this.oyo);
                  }

                  this.oyn = oxt.USE;
                  this.ozm = 0;
                  if (var4 && paq(0, 1) > 0) {
                     this.pax(var2);
                  } else {
                     this.pal(var1, var2);
                  }
                  break;
               case PREPARE:
                  this.paw(var1, var2);
                  this.pax(var2);
                  break;
               case USE:
                  if (this.ozm > 0) {
                     this.ozm--;
                     if (!this.oyp) {
                        this.paw(var1, var2);
                     }

                     this.pax(var2);
                     return;
                  }

                  this.pal(var1, var2);
                  break;
               case SWAP_BACK:
               default:
                  this.paw(var1, var2);
                  break;
               case RESTORE:
                  if (this.ozm > 0) {
                     this.ozm--;
                     return;
                  }

                  this.pan(var1, var2);
            }
         } else {
            this.pap();
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.ozx = var1.field_1724.method_18798().field_1351;
      if (this.oym != null) {
         ClientPlayerEntity var2 = var1.field_1724;
         if (this.oyn == oxt.PREPARE) {
            if (!this.oyj && !this.oym.matches(var2.method_31548().method_5438(this.oyo))) {
               this.pap();
            } else if (this.pbb(var2)) {
               if (this.pao(var1)) {
                  this.oyn = oxt.USE;
                  this.ozm = paq(0, 1);
               }
            } else if (++this.oyt > 10) {
               this.pap();
            }
         } else if (this.oyn == oxt.SWAP_BACK && this.ozm > 0) {
            this.ozm--;
         } else if (this.oyn == oxt.SWAP_BACK) {
            boolean var3 = this.oyj ? var2.field_7512 == var2.field_7498 && this.oyh.idle(var2) : wdq.canClick(var2) && this.oyh.idle(var2);
            if (var3) {
               if (this.oyj) {
                  this.oyi.giveBack(var1);
               } else {
                  wdq.click(var1, this.oyo, this.oyq);
               }

               if (this.pat() && var2.field_7498.method_34255().method_7960()) {
                  int var4 = pau(var2, this.oyq);
                  if (var4 >= 9) {
                     wdq.click(var1, var4, this.oyq);
                  } else if (var4 >= 0) {
                     var2.method_31548().method_61496(var4);
                  }
               }

               wdq.close(var1);
               this.oyh.release(var1);
               this.oyt = 0;
               if (this.oym.self) {
                  this.oyn = oxt.RESTORE;
               } else {
                  this.pap();
               }
            } else if (++this.oyt > 10) {
               this.pap();
            }
         } else if (this.oyn == oxt.RESTORE && this.oyv >= 0) {
            if (this.pbb(var2)) {
               wdq.swap(var1, this.oyv, var2.method_31548().method_67532());
               this.oyv = -1;
               this.oyh.release(var1);
               if (this.oyw) {
                  this.pap();
               }
            } else if (++this.oyt > 10) {
               this.oyv = -1;
               this.oyh.release(var1);
            }
         }
      }
   }

   private void pal(MinecraftClient var1, ClientPlayerEntity var2) {
      PlayerInventory var3 = var2.method_31548();
      if (!this.oyp) {
         this.paw(var1, var2);
      } else if (var3.method_67532() != this.oyo) {
         var3.method_61496(this.oyo);
      }

      if (this.pax(var2)) {
         if (this.oym.self) {
            this.ozr = MathHelper.method_15363(this.oyr + pba(-1.6F, 1.6F), -90.0F, 90.0F);
            this.ozs = pba(-1.2F, 1.2F) - (this.ozq - this.ozs);
         }

         if (!this.oym.matches(var2.method_6047())) {
            if (this.oyp) {
               this.pap();
            } else {
               this.oyt = 0;
               this.oyn = oxt.SWAP_BACK;
            }
         } else {
            if (var2.method_6115()) {
               var1.field_1761.method_2897(var2);
            }

            if (var1.field_1761.method_2923()) {
               var1.field_1761.method_2925();
               var1.field_1690.field_1886.method_23481(false);
               this.oys = true;
            }

            for (KeyBinding var7 : var1.field_1690.field_1852) {
               while (var7.method_1436()) {
               }
            }

            KeyBinding.method_1420(KeyBindingHelper.getBoundKeyOf(var1.field_1690.field_1904));
            this.oym.usedAt = System.currentTimeMillis();
            if (this.oym.thenMace && this.oyf.get() && var2.method_24828()) {
               this.ozv = this.ozu + 12;
            }

            this.oyt = 0;
            this.oyn = this.oyp ? oxt.RESTORE : oxt.SWAP_BACK;
            this.ozm = this.oyp ? paq(0, 1) : paq(0, 1);
         }
      }
   }

   private void pam(MinecraftClient var1) {
      if (this.oys) {
         this.oys = false;
         if (var1.field_1690 != null && var1.method_22683() != null) {
            var1.field_1690.field_1886.method_23481(vzz.isPhysicallyDown(var1, var1.field_1690.field_1886));
         }
      }
   }

   private void pan(MinecraftClient var1, ClientPlayerEntity var2) {
      PlayerInventory var3 = var2.method_31548();
      if (this.oyp) {
         if (var3.method_67532() == this.oyo && this.oyo != this.oyq) {
            var3.method_61496(this.oyq);
         }

         this.oyp = false;
         if (this.pat() && var3.method_67532() == this.oyq) {
            int var4 = pau(var2, this.oyq);
            if (var4 >= 9) {
               this.oyv = var4;
            } else if (var4 >= 0) {
               var3.method_61496(var4);
            }
         }
      }

      this.oyw = !this.oym.self || this.pay(var2, this.ozr, 30.0F, 55.0F);
      if (this.oyv >= 0) {
         this.paw(var1, var2);
      } else {
         if (this.oyw) {
            this.pap();
         }
      }
   }

   private boolean pao(MinecraftClient var1) {
      if (!this.oyj) {
         wdq.swap(var1, this.oyo, this.oyq);
         return true;
      } else if (!this.oyi.take(var1, this.oym::matches, this.oyq)) {
         izx.alert(
            wap.t(this.oym.name),
            wap.s(a.b("⟦并퓪䫉섃䞲\ufde3瑟\uea54惾\ue762ᵇ鎅ਾ聣ۗ병㌝ꧺ\u2fe4ꘉ\udc59", -1683085378), a.b("灕ৌ茐ᴘ隸ဍ깎⎫뷾㜰냠䫣쑆巹폆儯\ueb6f悩︆硞\uf1d4请Վ", -1723173793)),
            vhz.POTION,
            false
         );
         this.pap();
         return false;
      } else {
         if (!this.oyi.cursorHeld(var1.field_1724)) {
            wdq.close(var1);
         }

         return true;
      }
   }

   private void pap() {
      ClientPlayerEntity var1 = this.mc.field_1724;
      if (this.oyi.active() && var1 != null) {
         this.oyi.giveBack(this.mc);
         wdq.close(this.mc);
      }

      this.oyh.release(this.mc);
      this.pam(this.mc);
      if (this.oym != null && this.oyp && var1 != null) {
         PlayerInventory var2 = var1.method_31548();
         if (var2.method_67532() == this.oyo && this.oyo != this.oyq) {
            var2.method_61496(this.oyq);
         }
      }

      if (this.oym != null) {
         this.ozn = System.currentTimeMillis() + 120L + ThreadLocalRandom.current().nextLong(101L);
      }

      this.oym = null;
      this.oyn = null;
      this.oyv = -1;
      this.ozm = 0;
      this.ozy = 0.0F;
      this.ozz = 0.0F;
      ett.releaseView();
   }

   private static int paq(int var0, int var1) {
      ThreadLocalRandom var2 = ThreadLocalRandom.current();
      double var3 = (var2.nextDouble() + var2.nextDouble()) * 0.5;
      return var0 + (int)Math.round(var3 * (var1 - var0));
   }

   private void par(MinecraftClient var1) {
      if (this.ozv >= 0) {
         ClientPlayerEntity var2 = var1.field_1724;
         if (this.ozu <= this.ozv && var2.method_24828() && !(var2.method_18798().field_1351 - this.ozx > 0.5)) {
            for (WindChargeEntity var4 : var1.field_1687
               .method_8390(
                  WindChargeEntity.class, var2.method_5829().method_1009(2.0, 3.0, 2.0), var1x -> var1x.method_24921() == null || var1x.method_24921() == var2
               )) {
               Vec3d var5 = var4.method_73189();
               Vec3d var6 = var5.method_1019(var4.method_18798().method_1021(2.0));
               BlockHitResult var7 = var1.field_1687.method_17742(new RaycastContext(var5, var6, ShapeType.field_17558, FluidHandling.field_1348, var4));
               if (var7.method_17783() != Type.field_1333) {
                  this.ozv = -1;
                  if (var1.field_1755 == null) {
                     var1.field_1690.field_1903.method_23481(true);
                     this.ozw = true;
                  }

                  return;
               }
            }
         } else {
            this.ozv = -1;
         }
      }
   }

   private void pas(MinecraftClient var1) {
      if (this.ozw) {
         this.ozw = false;
         if (var1.field_1690 != null && var1.method_22683() != null) {
            var1.field_1690.field_1903.method_23481(vzz.isPhysicallyDown(var1, var1.field_1690.field_1903));
         }
      }
   }

   private boolean pat() {
      return this.oym.thenMace && this.oye.get() && !kmy.takesWindMace();
   }

   private static int pau(ClientPlayerEntity var0, int var1) {
      PlayerInventory var2 = var0.method_31548();
      if (var2.method_5438(var1).method_31574(Items.field_49814)) {
         return var1;
      } else {
         for (int var3 = 0; var3 < 36; var3++) {
            if (var2.method_5438(var3).method_31574(Items.field_49814)) {
               return var3;
            }
         }

         return -1;
      }
   }

   private void pav(MinecraftClient var1, int var2) {
      for (KeyBinding var6 : var1.field_1690.field_1852) {
         Key var7 = KeyBindingHelper.getBoundKeyOf(var6);
         if (var7.method_1442() == net.minecraft.client.util.InputUtil.Type.field_1668 && var7.method_1444() == var2) {
            while (var6.method_1436()) {
            }
         }
      }

      if (!kfx.startPhase()) {
         PlayerInventory var8 = var1.field_1724.method_31548();
         int var9 = var8.method_67532();
         if (this.oyu >= 0 && var9 != this.oyu && var9 < var1.field_1690.field_1852.length) {
            Key var10 = KeyBindingHelper.getBoundKeyOf(var1.field_1690.field_1852[var9]);
            if (var10.method_1442() == net.minecraft.client.util.InputUtil.Type.field_1668 && var10.method_1444() == var2) {
               var8.method_61496(this.oyu);
            }
         }
      }
   }

   private void paw(MinecraftClient var1, ClientPlayerEntity var2) {
      this.oyh.hold(var1);
      if (var2.method_6115()) {
         var1.field_1761.method_2897(var2);
      }
   }

   private boolean pax(ClientPlayerEntity var1) {
      return !this.oym.self || this.pay(var1, this.ozp, 40.0F, 65.0F);
   }

   private boolean pay(ClientPlayerEntity var1, float var2, float var3, float var4) {
      float var5 = var2 - var1.method_36455();
      float var6 = pba(var3, var4);
      boolean var7 = Math.abs(var5) <= var6;
      float var8 = var7 ? 1.0F : var6 / Math.abs(var5);
      double var9 = prp.multiplier();
      float var11 = paz(var7 ? var5 : Math.signum(var5) * var6, var9);
      float var12 = paz(this.ozs * var8, var9);
      float var13 = var1.method_36455();
      var1.method_36457(MathHelper.method_15363(var1.method_36455() + var11, -90.0F, 90.0F));
      var1.method_36456(var1.method_36454() + var12);
      this.ozs -= var12;
      this.ozy += var12;
      this.ozz = this.ozz + (var1.method_36455() - var13);
      ett.viewOffset(this.ozy, this.ozz);
      return var7;
   }

   private static float paz(float var0, double var1) {
      return var1 > 0.0 ? prp.quantize(var0, var1) : var0;
   }

   private static float pba(float var0, float var1) {
      return var0 + ThreadLocalRandom.current().nextFloat() * (var1 - var0);
   }

   private boolean pbb(ClientPlayerEntity var1) {
      return wdq.canClick(var1) && this.oyh.idle(var1) && !var1.method_6115();
   }

   private static int pbc(ClientPlayerEntity var0, oxf var1) {
      PlayerInventory var2 = var0.method_31548();
      int var3 = var2.method_67532();
      if (var1.matches(var2.method_5438(var3))) {
         return var3;
      } else {
         for (int var4 = 0; var4 < 36; var4++) {
            if (var1.matches(var2.method_5438(var4))) {
               return var4;
            }
         }

         return -1;
      }
   }

   private static String pbd(String var0) {
      return var0.toLowerCase(Locale.ROOT).replace('ё', 'е');
   }

   public List<oxi> entries(float var1) {
      ArrayList var2 = new ArrayList();
      ClientPlayerEntity var3 = this.mc.field_1724;
      if (var3 == null) {
         return var2;
      } else {
         PlayerInventory var4 = var3.method_31548();

         for (oxf var6 : this.oyg) {
            if (var6.key.isBound() && this.pad(var6)) {
               int var7 = vvn.count(var4, var6::matches);
               ItemStack var8 = ItemStack.field_8037;

               for (int var9 = 0; var9 < 36; var9++) {
                  ItemStack var10 = var4.method_5438(var9);
                  if (var6.matches(var10)) {
                     var7 += var10.method_7947();
                     if (var8.method_7960()) {
                        var8 = var10;
                     }
                  }
               }

               if (var8.method_7960() && var7 > 0) {
                  var8 = vvn.peek(var4, var6::matches);
               }

               float var11 = var8.method_7960() ? 0.0F : var3.method_7357().method_7905(var8, var1);
               var2.add(
                  new oxi(
                     var6.id,
                     var6.name,
                     var8.method_7960() ? new ItemStack(var6.item) : var8,
                     var7,
                     var6.key.get(),
                     var11,
                     var6.usedAt,
                     this.oym == var6 || this.oyl == var6
                  )
               );
            }
         }

         return var2;
      }
   }
}
