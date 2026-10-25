package a;

import flow.dev.a;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public final class iov {
   static final int WINDOW = 0;
   static final int PANEL = 1;
   static final int CARD = 2;
   static final int CARD_HOVER = 3;
   static final int STROKE = 4;
   static final int FIELD = 5;
   static final int FIELD_HOVER = 6;
   static final int TRACK = 7;
   static final int TEXT = 8;
   static final int TEXT_DIM = 9;
   static final int TEXT_MUTED = 10;
   static final int DIVIDER = 11;
   static final int SHADOW = 12;
   static final int KNOB = 13;
   static final int HOVER = 14;
   static final int SLOTS = 15;
   static final int ACCENT_SLOT = 15;
   static final int ACCENT2_SLOT = 16;
   static final int PAINT_SLOTS = 17;
   private static final String[] iow = new String[]{
      a.c(1586193622, "撧ᴈ韜ধ艻Ӓ"),
      a.b("稳Γ襏᜵鳫", 1455782470),
      a.b("魜\ue2ef栯\uf648", -469918917),
      a.c(1903438107, "⥲僁\uda01䑦쿸䤌\uf358窰\ue4fc湚"),
      a.c(1267828288, "蘵ﾃ畖\ueb3a惩\ue656"),
      a.d("苬ﭒ熍\ueff5搪", 1330956161, 1650017550),
      a.c(-433458680, "\uf265诛Ą齼ᒣ鉛⡍ꆻ㿽땟㊛"),
      a.c(-1143464188, "ή曂\uec02牱瑩"),
      a.d("娶⎖\ua958㜥", -1193356650, 227444944),
      a.d("ꋇ\udb67冩쿔䑚슢磼\uf109", -716808222, 1480457561),
      a.c(436000554, "흔껴\u243a멇㇉뜸൳蒃ᫍ遽"),
      a.c(-385729018, "㹥䟙촕卻\ud8a1帑\ue455"),
      a.b("㛕使얥寑퀍嚤", 364656288),
      a.c(813139734, "蝹ﻍ琟\uea63"),
      a.c(732347432, "뱅엳伹텛媛"),
      a.d("헿걌⚟루㌴떟", 1834840564, 1491969132),
      a.c(-177064732, "㒂䴱쟢妕퉉哢\ueef7")
   };
   static final String DARK = a.d("㇂䡖슖峾", 1623371612, 1834393310);
   static final String COLOUR = a.c(1400270455, "渲ឯ鵿̍裀\u0e76");
   static final String LIGHT = a.b("朰Ấ鑹ਇ臌", 1226467193);
   static final String GLASS = a.c(1076846111, "幞⟊괗㍩뢢㹇萒\u0de5鏽᥇麙擺\uea2d");
   static final String CUSTOM = a.c(615268176, "㼕䚒챇刱\ud9fd彎");
   static final String FLOW = a.b("푻균✰륙", 510252089);
   static final String FLOW_BLACK = a.b("龲\ue629泹\uf290礐ￃ䖾챂刟\ud8a6", -1893294082);
   static final String FLOW_WHITE = a.d("蓞﵅瞕\ue9fc扼\ue4ba廖휦䥤쏄", -1165763834, 894590868);
   private static final int[] iox = new int[]{-1776408, -4934468};
   private static final int[] ioy = new int[]{-14474457, -10592666};
   static final iom[] PRESETS = new iom[]{
      new iom(
         a.d("鑇\ueddc朌便狥\uf436之잷姪퍓", -922979740, 1865803375),
         a.c(586076975, "퍭꫶…빏"),
         new int[]{
            -16448249,
            637534208,
            -804582642,
            -636349930,
            385875967,
            352321535,
            587202559,
            822083583,
            -657672,
            -4736318,
            -8683639,
            318767103,
            -1879048192,
            -1644308,
            218103807
         },
         0.62F,
         false,
         iox
      ),
      new iom(
         a.c(-855667923, "譡\uf2fa砪\ue643淃\ueb05兩\ud899䛛챻"),
         a.c(1996418554, "\uedb8鐣ỳ肚"),
         new int[]{
            -920847,
            520093695,
            -754974721,
            -520093697,
            335544320,
            -2130706433,
            -1459617793,
            603979776,
            -15658474,
            -12763063,
            -9670534,
            301989888,
            805306368,
            -1,
            201326592
         },
         0.62F,
         true,
         ioy
      ),
      new iom(
         a.b("䚬㼨뗨⮈ꁇ⛷鲹ᕙ", 129386211),
         a.d("⇏塛튛䳳", -833387112, 344826903),
         new int[]{
            -15724526,
            134217727,
            -15395561,
            -15132388,
            -14474457,
            -15132388,
            -14737629,
            -14145491,
            -1184273,
            -6579293,
            -10592666,
            251658239,
            -1946157056,
            -7434601,
            150994943
         },
         1.1F,
         false,
         iox
      ),
      new iom(
         a.d("麟\ue703淁\uf3aa硰ﻌ䒗쵩", -1860062689, 1551576263),
         a.c(510600156, "⎜娈탈亠"),
         new int[]{
            -16645629,
            184549375,
            -267777524,
            -233959919,
            -15198180,
            -15658732,
            -15329766,
            -14869214,
            -1,
            -6184534,
            -10855837,
            285212671,
            -1073741824,
            -7631979,
            184549375
         },
         1.1F,
         false,
         iox
      ),
      new iom(
         a.c(-1986076015, "\ue2d4魁ᆟ迤д芋㣗넺"),
         a.d("쏹멭キ껅", -1067886495, 1101831128),
         new int[]{
            -15987694,
            855638016,
            -435023335,
            -350939875,
            -14803416,
            -15263969,
            -14935003,
            -14408658,
            -921098,
            -6513493,
            -10526868,
            318767103,
            -1610612736,
            -7697768,
            184549375
         },
         1.0F,
         false,
         new int[]{-7701008, -5660683}
      ),
      iqf(a.c(183951654, "\ue179飳ሤ豇ކ腸㭅늓Ⳃ꙼↳"), a.b("躑\uf705緅\ue3ad", -1765044527), -15592676, -8740105, -8740105, -4482313),
      iqf(a.c(-223700849, "飔\ue158殗\uf5f0繢\uf8a3䋉쬿啫"), a.c(1787803638, "랶츢䓢\uda8a"), -15132892, -1327942, -1327942, -3889177),
      new iom(
         a.c(408607464, "\udaabꌮ⧠랍㱝"),
         a.b("쪽댩㧴꞊ⱁꪤჱ餆ܞ趤\u0a7a\uf019绎", -212743428),
         new int[]{
            -723464,
            150994944,
            -167772161,
            -83886081,
            -1907478,
            -1052428,
            -1578514,
            -2301978,
            -15395301,
            -10723474,
            -6644311,
            301989888,
            939524096,
            -1,
            134217728
         },
         1.0F,
         true,
         ioy
      ),
      new iom(
         a.b("⇳塦튯䳙", 443818426),
         a.c(-1787783870, "锃\uec97晊\uf834珿\uf51a住울墠툚嗄꾧ⅰ"),
         new int[]{
            -526084,
            218103807,
            1895825407,
            -1929379841,
            469762048,
            1560281087,
            -2130706433,
            637534208,
            -15724266,
            -12828850,
            -9670784,
            369098752,
            805306368,
            -1,
            268435456
         },
         0.55F,
         true,
         ioy
      ),
      new iom(
         a.b("\uf503貃ٛ頠Ᏸ镔⼊", -1449396921),
         a.d("\uf6d8轌֑鯯ဤ雁Ⲕꕣ㭻뇁㘟챼䊫", -378422393, 1085099294),
         new int[]{
            -15856106,
            335544320,
            352321535,
            486539263,
            587202559,
            385875967,
            587202559,
            721420287,
            -1,
            -2302746,
            -5197632,
            486539263,
            1610612736,
            -3618606,
            285212671
         },
         0.5F,
         false,
         iox
      ),
      iqg(a.c(-1345956348, "噃\u2fd9ꔀ㭰냩㘺豇֯鯠"), -15591116, -15986650, -16250340, -16579570, -13474576, -14795616),
      iqg(a.c(-1209568808, "熜ࠜ苔Ს靨ᇅꮗ"), -13364714, -14283760, -15071221, -15858939, -2347716, -7595741),
      iqg(a.b("梇ᄞ鯅֣蹧ࣛ늀", 697002181), -15848164, -16113644, -16378355, -16578042, -14762401, -15566793),
      iqg(a.d("秭z課ᓞ鼟ᦿ", -2035227739, -1362978275), -13165042, -14019574, -14807545, -15792381, -686296, -5286631),
      iqg(a.c(1738884292, "䒔㴚럏⦽ꉣⓃ"), -14282700, -15070426, -15595750, -16186611, -5949461, -9887589),
      iqg(a.b("\uea04鎆᥄蜢೨詓", -1549931965), -14931918, -15590364, -15986151, -16381683, -9192991, -12485211),
      iqg(a.c(-1724868928, "隊\uef01旉﮿灿\uf6cc䲚앰嬪"), -14152664, -14940130, -15596268, -16186870, -53816, -4973428),
      iqg(a.d("㒦䴻쟮妛퉃", 207710330, 1525832854), -16114131, -16313310, -16511464, -16644340, -15425336, -15965049),
      iqg(a.b("㫥䍾즫", 1102199471), -15457488, -15853276, -16183272, -16513012, -6234881, -10182456),
      iqg(a.b("\ue4ad鴨\u17fc覐ɚ蓸", 170386666), -16115421, -16313830, -16446446, -16644599, -14099296, -15100306),
      iqg(a.c(-1065535113, "㤼䂽쩪吏\udfd4奩\ue329櫃\uf49b縡"), -15981789, -16246760, -16445424, -16644088, -13765156, -15092576),
      iqg(a.b("蓇﵋瞎\ue9e7戽", -96762736), -14479571, -15201762, -15727084, -16252150, -3628801, -7573816),
      new iom(
         a.b("౹痷Ｅ慉\uea8f", -856028117),
         a.d("䷏㑛뺆\u20f8ꬳⷖ鞃Ṵ聬\u0ad6贈睫寮", 1700595789, -796310077),
         iqc(-1117962, -6129939, 1.0F),
         1.0F,
         true,
         new int[]{-6129939, -7576872}
      ),
      new iom(a.b("䯺㉠뢾⛝괊", 1619938232), a.b("\uf1a0蠴˩鲗\u175c醹⯬ꈛ㰃뚹ㅧ쬄䗓", -1883311647), iqd(-15987178, -8996097, 1.0F), 0.5F, false, new int[]{-8996097, -5731073})
   };
   public static final vlv PRESET = new vlv(a.d("뵃쓎丐큩家", 693468151, -2114664731), a.d("茯華灤\uee0d斍\ue35e夣탟亂쐻", 1952914574, 1186242541), iqa());
   public static final vmc BG_HUE = new vmc(a.b("ꌦ\udab4健츜䗇썣礭\uf0c6溂\ue439掮馗\u175d軼", 1793368938), 0.68, 0.0, 1.0, 0.0);
   public static final vmc BG_SATURATION = new vmc(a.b("裾\uf16c箽\ue5c4渟\ue8bb勵\udb1e䕚쿡䡶뉔㲑ꔵ⽧ꦑᏍ鰉ڧ胰आ", -1756067671), 0.35, 0.0, 1.0, 0.0);
   public static final vmc BG_BRIGHTNESS = new vmc(a.d("뻹읫䶺폃堘\udebc擲\ued19獝罹繱葂અ錯ᥲ龌◟ꨔガ뛫㼜", 1427502884, -893302390), 0.12, 0.0, 1.0, 0.0);
   public static final vmc OPACITY = new vmc(a.c(446664459, "轃\uf6cd簏\ue27c榡\uef0d啓"), 1.0, 0.3, 1.0, 0.05).percent();
   public static final vmc CONTRAST = new vmc(a.b("\u1a9d挀\ue9d2瞹ﱨ竊삋䥽", -1131013418), 1.0, 0.5, 2.0, 0.05).percent();
   static final List<vmo> CUSTOM_SLIDERS = List.of(OPACITY, CONTRAST);
   static final vlv PAINT = new vlv(
      a.d("⼉嚔\udc44䈶짻位\uf51f粽\ue2ad栕", 498093721, -1074372135), a.c(-1478646150, "\ua633\udfaa啲쬘"), a.c(-296986799, "團⺁ꑙ㨳"), a.c(740276647, "맬쁀䪂")
   );
   static final iog[] MENU_PAINTS = new iog[]{
      new iog(a.d("锈\uec87晓\uf828珴\uf55d", -1168281943, 154401776), 0, false),
      new iog(a.c(762062777, "⟭幦풸䫈섘䞪\ufdea"), 1, false),
      new iog(a.c(-131957250, "綸Ы軫ႌ魌"), 2, false),
      new iog(a.b("鶖\ue405滅\uf0a2筢ﶀ䞜칬偽\uda84嵐Ꜹ⧼끚", 499686875), 3, false),
      new iog(a.c(-48327816, "錽\ueaa1息︈痞\uf378䤪"), 4, false),
      new iog(a.c(433596570, "⣎児\udb8f䗷츨䢎\uf28e笾\ue56e濕\ue842ቱ鲱ԁ轒স돶㰺"), 5, false),
      new iog(a.b("玬ਲ胭ẕ镊Ꮼꧬ⁒브㓳덨䤞쟐干퐶", -662342683), 6, false),
      new iog(a.d("搒ᶇ靊द苦ќ빇㟢ꦻ⌙\ua4c8庱", -2084230741, -528527898), 7, false),
      new iog(a.d("멘쏍䤀희岬\uda16怍\ue9b7短ﵝ窃", -1942645257, 10301431), 13, false),
      new iog(a.b("\ue6d6齖ᖘ该", -1183455610), 8, false),
      new iog(a.c(-167150479, "簬֫轾ᄃ髕ᱮ\ua638\u2fda놎㭦볡䚁졋凶"), 9, false),
      new iog(a.b("ᯛ扒\ue880盠ﴶ篃쇄䠤홦峛", -805561444), 10, false),
      new iog(a.d("\uf07e觢̮鵀ᚚ逪⩮ꎞ", -726958386, -1622962436), 11, false),
      new iog(a.d("ᙉ濟\ue515筷\uf0b7", -957922265, 186536483), 14, false),
      new iog(a.b("鄅\ue88f払ﰡ矽\uf154", 1317310800), 12, false),
      new iog(a.b("圕⺆ꑕ㨢뇾㝕", -982165678), 15, false),
      new iog(a.b("笲ʡ衲ᘅ鷙᭲ꅵ⢖", 1865120635), 16, false)
   };
   static final iog[] HUD_PAINTS = new iog[]{
      new iog(a.c(1628590424, "儐⢂ꉓ㰪럱ㅕ講˰鲴ᘏ"), 0, true),
      new iog(a.b("冱⠱ꋿ㲂", 1129337313), 8, true),
      new iog(a.c(-2026637838, "\uf5af谨۽颀ፖ闭⾻ꙙ㠍닥㕢켂䇈\ud875"), 9, true),
      new iog(a.b("៦湯\ue4bd竝\uf10b矾췹䐙\uda5b僦", -961669215), 10, true),
      new iog(a.c(2021475904, "䘇㾔땇⬰ꃬ♇"), 15, true),
      new iog(a.d("ᆴ栧\ue2f4粃\uf75f燴쯳䈐", 936947592, 2074066549), 16, true),
      new iog(a.c(-1986277632, "콆뛔㰔ꉤ"), 7, true),
      new iog(a.c(317840178, "\udb72ꋬ⠳뙋㶔묲"), 5, true),
      new iog(a.b("耷嶺獥\ued02曔\ue072娠", 183140466), 4, true),
      new iog(a.d("彁⛝갑㉿릥㼕蕑ಡ", -1633704466, 167049955), 11, true),
      new iog(a.c(2094112589, "鼕\ue680汍\uf221秡｛䕀쳺加\ud810忎"), 13, true),
      new iog(a.b("ჶ楠\ue3aa緈\uf608", -127332165), 14, true)
   };
   private static final int[] ioz = new int[17];
   private static final boolean[] ipa = new boolean[17];
   private static final int[] ipb = new int[17];
   private static final boolean[] ipc = new boolean[17];
   private static int ipd;
   private static final String[] ipe = new String[]{
      a.d("ส瞯ﵽ挗", 1039991029, 1588989594),
      a.b("\uf7bb踨Ӻ骊", -1552877582),
      a.d("䒳㴽럨⦚ꉄⓤ", -732865084, -188737241),
      a.c(-23102843, "竏͒覇៲鰪"),
      a.d("ꛭ\udf64喥", -1432843266, 81538371),
      a.c(-1212930454, "☣徶핢䬉"),
      a.b("綇Г軄Ⴝ", 385973711),
      a.c(-410468161, "샼륥㎵귌"),
      a.b("귏푘庐샼䬽춝", -910053990),
      a.d("盛茧৯鞚᱓髾€", -1748167874, 2038229469),
      a.b("뢈섄䯋햬", 1780398302),
      a.b("㼖䚑채刲\ud9fe彍", -1677377709)
   };
   private static final int[][] ipf = new int[][]{
      null,
      iox,
      {-7701008, -5660683},
      {-11760144, -8803596},
      {-13912621, -9974301},
      {-13649535, -10695780},
      {-7487681, -5516691},
      {-2049990, -1389716},
      {-1465797, -1000856},
      {-1748149, -1147787},
      {-1550470, -1146727}
   };
   public static final vlv ACCENT = new vlv(a.c(1433614625, "㥦䃵쨦呑\udf8d夦"), a.c(-1148007169, "첶딥㿷ꆇ"), ipe);
   public static final vkl GRADIENT = new vkl(a.d("ꎗ\uda13僓캧䕽쏀禘\uf073", 1358855626, -1392058862), false);
   public static final vmc HUE = new vmc(a.b("\ud853ꇟ⬜", -1573136360), 0.72, 0.0, 1.0, 0.0);
   public static final vmc SATURATION = new vmc(a.b("糠գ辥ᇕ騅Ყꛡ⼍녔㯤", 2098822329), 0.62, 0.0, 1.0, 0.0);
   public static final vmc BRIGHTNESS = new vmc(a.c(465193488, "䩘㏙뤑❮겶⨛遒ᦨ蟡\u0d50"), 0.97, 0.0, 1.0, 0.0);
   public static final vlv STYLE = new vlv(a.c(1997231017, "叿⩩ꂷ㻓딍"), a.b("矒้蒗\u1af3", 108689296), a.c(-1761136439, "る䤐쏎嶪"), a.c(-417488624, "ꅑ\ud8c1切챲䞹"));
   public static final vmc SCALE = new vmc(a.c(1273679411, "칥럤㴵ꍉ⢗"), 1.0, 0.7, 1.3, 0.05).percent();
   public static final vmc ROUNDNESS = new vmc(a.b("ꦕ퀙嫐쒺佧짜玄謹搼", 684435918), 1.6, 0.0, 1.6, 0.05).percent();
   public static final vmc ANIMATION = new vmc(a.d("㹤䟺촮卛\ud880帤\ue46a涝\uf3c3祯", -2128193107, -215586942), 1.0, 0.5, 2.0, 0.1)
      .unit(a.d("ꢗ", 1707733783, -63415303));
   public static final vmc BG_BLUR = new vmc(a.c(672422233, "夑₎ꩄ㐲뾷㥑茚\u0af6钷Ḏ"), 2.0, 0.0, 6.0, 1.0);
   public static final vmc DIM = new vmc(a.c(-337767633, "።櫾\ue029縕\uf595猼쥲䂝\udeca"), 0.35, 0.0, 0.9, 0.05).percent();
   static final List<vmo> INTERFACE = List.of(STYLE, SCALE, ROUNDNESS, ANIMATION, BG_BLUR, DIM);
   static final List<vmo> ALL = List.of(
      PRESET,
      ACCENT,
      GRADIENT,
      HUE,
      SATURATION,
      BRIGHTNESS,
      BG_HUE,
      BG_SATURATION,
      BG_BRIGHTNESS,
      OPACITY,
      CONTRAST,
      STYLE,
      SCALE,
      ROUNDNESS,
      ANIMATION,
      BG_BLUR,
      DIM
   );
   public static int window;
   public static int panel;
   public static int card;
   public static int cardHover;
   public static int stroke;
   public static int field;
   public static int fieldHover;
   public static int track;
   public static int text;
   public static int textDim;
   public static int textMuted;
   public static int divider;
   public static int shadow;
   public static int knob;
   public static int hover;
   private static final int[] ipg = (int[])PRESETS[0].iop.clone();
   private static float iph = 1.0F;
   private static float ipi;
   private static float ipj = 0.4F;
   private static int ipk = iox[0];
   private static int ipl = iox[0];
   private static int ipm = iox[0];
   private static float ipn;
   private static final float[] ipo = new float[3];
   private static String ipp = a.b("䳠㕤뾤⇄ꨋⲻ雵ἕ", -235058001);
   private static long ipq = -1L;
   private static long ipr = Long.MIN_VALUE;
   private static iom ips;
   private static long ipt = Long.MIN_VALUE;
   private static final int[] ipu = new int[17];
   private static float ipv;
   private static boolean ipw;
   private static final float ipx = 0.3F;

   private iov() {
   }

   private static String[] iqa() {
      ArrayList var0 = new ArrayList();

      for (iom var4 : PRESETS) {
         var0.add(var4.ion);
      }

      var0.add(a.b("↮堩틼䲊읆䇵", 2089165291));
      return var0.toArray(new String[0]);
   }

   private static int[] iqb(int var0, int var1, float var2) {
      int var3 = ujt.lerp(var1, -1, 0.8F);
      int var4 = ujt.lerp(-1, var1, 0.08F);
      return new int[]{
         var0,
         805306368,
         ujt.withAlpha(ujt.lerp(var0, var3, 0.035F * var2), 230),
         ujt.withAlpha(ujt.lerp(var0, var3, 0.055F * var2), 235),
         ujt.lerp(var0, var3, 0.1F * var2),
         ujt.lerp(var0, var3, 0.055F * var2),
         ujt.lerp(var0, var3, 0.08F * var2),
         ujt.lerp(var0, var3, 0.12F * var2),
         var4,
         ujt.lerp(var4, var0, 0.36F),
         ujt.lerp(var4, var0, 0.6F),
         ujt.withAlpha(var3, 20),
         -1610612736,
         ujt.lerp(var4, var0, 0.42F),
         ujt.withAlpha(var3, 10)
      };
   }

   private static int[] iqc(int var0, int var1, float var2) {
      int var3 = ujt.lerp(-15395301, var1, 0.14F);
      int var4 = ujt.lerp(-16777216, var1, 0.2F);
      return new int[]{
         var0,
         150994944,
         ujt.withAlpha(ujt.lerp(var0, -1, 0.7F), 245),
         ujt.withAlpha(ujt.lerp(var0, -1, 0.85F), 250),
         ujt.lerp(var0, var4, 0.09F * var2),
         ujt.lerp(var0, var4, 0.025F * var2),
         ujt.lerp(var0, var4, 0.05F * var2),
         ujt.lerp(var0, var4, 0.1F * var2),
         var3,
         ujt.lerp(var3, var0, 0.4F),
         ujt.lerp(var3, var0, 0.62F),
         ujt.withAlpha(var4, 18),
         939524096,
         -1,
         ujt.withAlpha(var4, 8)
      };
   }

   private static int[] iqd(int var0, int var1, float var2) {
      int var3 = ujt.lerp(-1, ujt.shade(var1, 0.8F), 0.55F);
      return new int[]{
         var0,
         335544320,
         ujt.withAlpha(var1, Math.round(26.0F * var2)),
         ujt.withAlpha(var1, Math.round(36.0F * var2)),
         ujt.withAlpha(var1, Math.round(46.0F * var2)),
         ujt.withAlpha(var1, Math.round(31.0F * var2)),
         ujt.withAlpha(var1, Math.round(43.0F * var2)),
         ujt.withAlpha(var1, Math.round(51.0F * var2)),
         -1,
         ujt.lerp(-1, var1, 0.25F),
         var3,
         ujt.withAlpha(var1, 34),
         1342177280,
         ujt.lerp(-1, var1, 0.3F),
         ujt.withAlpha(var1, 20)
      };
   }

   private static int[] iqe(int var0, int var1, float var2) {
      int var3 = ujt.lerp(-15724266, var1, 0.14F);
      return new int[]{
         var0,
         218103807,
         ujt.withAlpha(-1, Math.round(112.0F * Math.min(1.4F, var2))),
         ujt.withAlpha(-1, Math.round(140.0F * Math.min(1.4F, var2))),
         ujt.withAlpha(-16777216, Math.round(28.0F * var2)),
         ujt.withAlpha(-1, Math.round(92.0F * Math.min(1.4F, var2))),
         ujt.withAlpha(-1, Math.round(128.0F * Math.min(1.4F, var2))),
         ujt.withAlpha(-16777216, Math.round(38.0F * var2)),
         var3,
         ujt.lerp(var3, var0, 0.3F),
         ujt.lerp(var3, var0, 0.52F),
         369098752,
         805306368,
         -1,
         268435456
      };
   }

   private static iom iqf(String var0, String var1, int var2, int var3, int var4, int var5) {
      return new iom(var0, var1, iqb(var2, var3, 1.0F), 1.0F, false, new int[]{var4, var5});
   }

   private static iom iqg(String var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = (int[])iqb(var3, var5, 1.0F).clone();
      var7[2] = ujt.withAlpha(var2, 230);
      var7[3] = ujt.withAlpha(var1, 235);
      var7[5] = ujt.lerp(var2, var1, 0.35F);
      var7[6] = ujt.lerp(var2, var1, 0.75F);
      var7[4] = ujt.lerp(var1, var5, 0.18F);
      var7[7] = ujt.lerp(var1, var5, 0.14F);
      var7[12] = ujt.withAlpha(var4, 176);
      return new iom(var0, a.d("鄠\ue8bd扭ﰟ矒\uf164", -1735860766, -131052409), var7, 1.0F, false, new int[]{var5, var6});
   }

   static iom custom() {
      long var0 = Double.doubleToLongBits(BG_HUE.get()) * 31L + Double.doubleToLongBits(BG_SATURATION.get());
      var0 = var0 * 31L + Double.doubleToLongBits(BG_BRIGHTNESS.get());
      var0 = var0 * 31L + Double.doubleToLongBits(OPACITY.get());
      var0 = var0 * 31L + Double.doubleToLongBits(CONTRAST.get());
      var0 = var0 * 31L + ipd;
      if (ips != null && var0 == ipr) {
         return ips;
      } else {
         ipr = var0;
         float var2 = (float)BG_HUE.get();
         float var3 = (float)BG_SATURATION.get();
         float var4 = (float)BG_BRIGHTNESS.get();
         float var5 = (float)CONTRAST.get();
         float var6 = (float)OPACITY.get();
         int var7 = ujt.hsv(var2, var3, var4);
         boolean var8 = ujt.luminance(var7) > 0.55F;
         boolean var9 = var6 < 0.9F;
         int[] var10;
         int[] var11;
         if (var8) {
            int var12 = ujt.hsv(var2, Math.max(0.45F, var3), 0.55F);
            var10 = var9 ? iqe(var7, var12, var5) : iqc(var7, var12, var5);
            var11 = new int[]{ujt.hsv(var2, Math.max(0.55F, var3), 0.72F), ujt.hsv(var2, Math.max(0.4F, var3 * 0.8F), 0.85F)};
         } else {
            int var19 = ujt.hsv(var2, Math.min(1.0F, 0.25F + var3 * 0.6F), 1.0F);
            var10 = var9 ? iqd(var7, var19, var5) : iqb(var7, var19, var5);
            var11 = var3 < 0.08F
               ? iox
               : new int[]{ujt.hsv(var2, Math.min(1.0F, 0.35F + var3 * 0.5F), 0.95F), ujt.hsv(var2 + 0.06F, Math.min(1.0F, 0.25F + var3 * 0.4F), 1.0F)};
         }

         var10 = (int[])var10.clone();

         for (int var20 = 1; var20 < 15; var20++) {
            if (ipa[var20]) {
               var10[var20] = ioz[var20];
            }
         }

         if (ipa[15] || ipa[16]) {
            int var21 = ipa[15] ? ioz[15] : var11[0];
            int var13 = ipa[16] ? ioz[16] : (ipa[15] ? ujt.lerp(var21, -1, 0.3F) : var11[1]);
            var11 = new int[]{var21, var13};
         }

         ips = new iom(a.c(-281498519, "갬햫彾섈䫄챷"), a.b("\uf7e3蹤ұ髇ᄋ鞸", 102496166), var10, var9 ? var6 : 1.0F, var8, var11);
         return ips;
      }
   }

   static void customFromCurrent() {
      iom var0 = preset();
      int[] var1 = accentPair(ACCENT.index(), var0);
      int var2 = var0.color(0);
      float[] var3 = Color.RGBtoHSB(var2 >> 16 & 0xFF, var2 >> 8 & 0xFF, var2 & 0xFF, null);
      int[] var4 = (int[])var0.iop.clone();
      BG_HUE.set(var3[0]);
      BG_SATURATION.set(var3[1]);
      BG_BRIGHTNESS.set(var3[2]);
      OPACITY.set(Math.max(0.3, Math.min(1.0, (double)var0.tintScale())));
      CONTRAST.reset();

      for (int var5 = 1; var5 < 15; var5++) {
         ioz[var5] = var4[var5];
         ipa[var5] = true;
      }

      ioz[15] = var1[0];
      ioz[16] = var1[1];
      ipa[15] = true;
      ipa[16] = true;
      ipd++;
      ACCENT.set(a.b("˿筺\uf1a8濂", -2017983814));
      PRESET.set(a.d("鐰\uedb7杢樂狘\uf46b", -714454059, -1008803936));
   }

   static void resetCustom() {
      if (PAINT.is(a.c(-821768515, "컶띚㶘"))) {
         Arrays.fill(ipc, false);
      } else {
         BG_HUE.reset();
         BG_SATURATION.reset();
         BG_BRIGHTNESS.reset();
         OPACITY.reset();
         CONTRAST.reset();
         Arrays.fill(ipa, false);
      }

      ipd++;
   }

   static boolean isPainted(iog var0) {
      return !var0.hud() && var0.slot() == 0 ? true : (var0.hud() ? ipc : ipa)[var0.slot()];
   }

   static int paintColor(iog var0) {
      if (var0.hud() && ipc[var0.slot()]) {
         return ipb[var0.slot()];
      } else if (var0.hud() && var0.slot() == 16 && ipc[15]) {
         return ujt.lerp(ipb[15], -1, 0.3F);
      } else {
         iom var1 = custom();

         return switch (var0.slot()) {
            case 15 -> var1.accent()[0];
            case 16 -> var1.accent()[1];
            default -> var1.color(var0.slot());
         };
      }
   }

   static void setPaint(iog var0, int var1, float var2, float var3, float var4) {
      if (!var0.hasAlpha()) {
         var1 |= -16777216;
      }

      if (!var0.hud() && var0.slot() == 0) {
         BG_HUE.set(var2);
         BG_SATURATION.set(var3);
         BG_BRIGHTNESS.set(var4);
      } else if (var0.hud()) {
         ipb[var0.slot()] = var1;
         ipc[var0.slot()] = true;
      } else {
         ioz[var0.slot()] = var1;
         ipa[var0.slot()] = true;
      }

      if (var0.slot() == 15 || var0.slot() == 16) {
         ACCENT.set(a.b("ᥣ惦\uea34瑞", 1526143270));
      }

      ipd++;
   }

   static void clearPaint(iog var0) {
      if (!var0.hud() && var0.slot() == 0) {
         BG_HUE.reset();
         BG_SATURATION.reset();
         BG_BRIGHTNESS.reset();
      } else {
         (var0.hud() ? ipc : ipa)[var0.slot()] = false;
      }

      ipd++;
   }

   public static void saveColors(Properties var0) {
      for (int var1 = 0; var1 < 17; var1++) {
         if (ipa[var1]) {
            var0.setProperty(a.b("へ䧕쌋嵲횭偗\uea49掴\ufde8睚\uf094હ萭ᶔ韌ᄦꬲ", 355676189) + iow[var1], iqh(ioz[var1]));
         }

         if (ipc[var1]) {
            var0.setProperty(a.c(2073085090, "쓆뵫㞵꧌∓ꓩỷ霊ॖ菤Ъ︇炖\ue93a捸\ue5c3") + iow[var1], iqh(ipb[var1]));
         }
      }
   }

   public static void loadColors(Properties var0) {
      for (int var1 = 0; var1 < 17; var1++) {
         Integer var2 = iqi(var0.getProperty(a.d("讇\uf22a磴\ue68d浒\ueba8冶\ud84b䘗첥䭫녆㿒ꙫⰳ\uaad9Ⴭ", -1578154029, -1860449231) + iow[var1]));
         ipa[var1] = var2 != null && var1 != 0;
         ioz[var1] = var2 != null ? var2 : 0;
         Integer var3 = iqi(var0.getProperty(a.b("嶺␗껉グ뭯㶕螋\u0e76逪᪘鵖杻\ue9ea灆宅粿", 1033788894) + iow[var1]));
         ipc[var1] = var3 != null;
         ipb[var1] = var3 != null ? var3 : 0;
      }

      ipd++;
   }

   private static String iqh(int var0) {
      return String.format(Locale.ROOT, a.b("甏ಫ虰ᡡ", 1641641262), var0);
   }

   private static Integer iqi(String var0) {
      if (var0 == null) {
         return null;
      } else {
         try {
            return (int)Long.parseLong(var0.trim().replace(a.b("몛", -1746879815), ""), 16);
         } catch (NumberFormatException var2) {
            return null;
         }
      }
   }

   public static void beginHud() {
      if (!ipw && !(ipv <= 0.002F)) {
         ipw = true;

         for (int var0 = 0; var0 < 17; var0++) {
            ipu[var0] = iqk(var0);
            if (ipc[var0]) {
               iql(var0, ujt.lerp(ipu[var0], ipb[var0], ipv));
            }
         }

         if (!ipc[16] && ipc[15]) {
            int var1 = GRADIENT.get() ? ujt.lerp(ipb[15], -1, 0.3F) : ipb[15];
            iql(16, ujt.lerp(ipu[16], var1, ipv));
         }
      }
   }

   public static void endHud() {
      if (ipw) {
         ipw = false;

         for (int var0 = 0; var0 < 17; var0++) {
            iql(var0, ipu[var0]);
         }
      }
   }

   private static boolean iqj() {
      for (boolean var3 : ipc) {
         if (var3) {
            return true;
         }
      }

      return false;
   }

   private static int iqk(int var0) {
      return switch (var0) {
         case 15 -> ipk;
         case 16 -> ipl;
         default -> ipg[var0];
      };
   }

   private static void iql(int var0, int var1) {
      switch (var0) {
         case 15:
            ipk = var1;
            break;
         case 16:
            ipl = var1;
            break;
         default:
            ipg[var0] = var1;
      }

      iqn();
   }

   static iom preset() {
      if (PRESET.is(a.b("閊\uec0d曘\uf8ae獢\uf5d1", 2012452303))) {
         return custom();
      } else {
         int var0 = PRESET.index();
         return PRESETS[Math.max(0, Math.min(PRESETS.length - 1, var0))];
      }
   }

   public static void update(float var0) {
      if (unf.frame() != ipq) {
         ipq = unf.frame();
         ukf.enabled = STYLE.is(a.c(-1999928815, "艐﯀焆\uef73撸"));
         iqm();
         float var1 = 1.0F - (float)Math.exp(-9.0F * var0);
         iom var2 = preset();

         for (int var3 = 0; var3 < 15; var3++) {
            ipg[var3] = ujt.lerp(ipg[var3], var2.iop[var3], var1);
         }

         iph = iph + (var2.ioq - iph) * var1;
         ipi = ipi + ((var2.ior ? 1.0F : 0.0F) - ipi) * var1;
         float var5 = isv.luminance();
         ipj = ipj + ((var5 >= 0.0F ? var5 : 0.4F) - ipj) * var1;
         int[] var4 = accentPair(ACCENT.index(), var2);
         ipk = ujt.lerp(ipk, var4[0], var1);
         ipl = ujt.lerp(ipl, GRADIENT.get() ? var4[1] : var4[0], var1);
         ipm = ujt.lerp(ipm, var2.accent()[0], var1);
         ipn = Color.RGBtoHSB(ipm >> 16 & 0xFF, ipm >> 8 & 0xFF, ipm & 0xFF, ipo)[1];
         ipv = ipv + ((PRESET.is(a.d("\ue5f5鱲ᚧ裑̝薮", 1694597783, -143562969)) && iqj() ? 1.0F : 0.0F) - ipv) * var1;
         if (!var2.ior) {
            ipp = var2.ion;
         }

         iqn();
      }
   }

   private static void iqm() {
      custom();
      if (ipt != Long.MIN_VALUE && ipt != ipr && !PRESET.is(a.c(-188472272, "⑵已휧䥑슝䐮"))) {
         PRESET.set(a.c(1462290806, "줳내㩡ꐗ\u2fdbꥨ"));
      }

      ipt = ipr;
   }

   private static void iqn() {
      window = ipg[0];
      panel = ipg[1];
      card = ipg[2];
      cardHover = ipg[3];
      stroke = ipg[4];
      field = ipg[5];
      fieldHover = ipg[6];
      track = ipg[7];
      text = ipg[8];
      textDim = ipg[9];
      textMuted = ipg[10];
      divider = ipg[11];
      shadow = ipg[12];
      knob = ipg[13];
      hover = ipg[14];
   }

   static int[] accentPair(int var0, iom var1) {
      String var2 = ipe[Math.max(0, Math.min(ipe.length - 1, var0))];
      switch (var2) {
         case a.c(689249227, "ᮎ戉\ue8dc皪ﵦ篕"):
            return customAccent();
         case a.b("ㅤ䣡숳屙", -1080676063):
            return var1.accent();
         case a.b("쀂릑㍃괳", -1270169525):
            return var1.light() ? ioy : iox;
         default:
            return ipf[var0];
      }
   }

   static int[] customAccent() {
      float var0 = (float)HUE.get();
      float var1 = (float)SATURATION.get();
      float var2 = (float)BRIGHTNESS.get();
      return new int[]{ujt.hsv(var0, var1, var2), ujt.hsv(var0 + 0.09F, Math.min(1.0F, var1 * 1.05F), var2)};
   }

   static void resetLook() {
      PRESET.reset();
      ACCENT.reset();
      GRADIENT.reset();
      STYLE.reset();
      ROUNDNESS.reset();
   }

   static void choose(String var0) {
      PRESET.set(var0);
      ACCENT.set(a.c(-1378833440, "ꮥ툠売욘"));
      String var1 = wallpaperOf(var0);
      if (var1 != null) {
         isv.select(var1);
      }
   }

   static String wallpaperOf(String var0) {
      return switch (var0) {
         case a.c(1967915595, "ȇ箜\uf14c漥\ue4a5扶\ud80b凷쾪䔓") -> a.b("䪍㌣맽➍걐⪴邻᥀蜜ඵ証瀄ﻖ杴\ued3e", 1113541364);
         case a.d("箳Ȩ裸ᚑ鴑ᯗꆻ⡋똉㲩", 106724394, -1651636267) -> a.d("ꚨ\udf06嗘쮨䁵욑粞\uf565欹\ue190昙鰩ዻ譄Ę蟵", -414093818, 1911015624);
         default -> null;
      };
   }

   static void toggleLight() {
      iom var0 = preset();
      if (!var0.ion.equals(a.b("\ue9c8道᪃蓪ཪ覹㏄머⑥껜", -774968956)) && !var0.ion.equals(a.d("튅\uab1e⇎뾧㐧닡ࢍ腽Ἷ閟", 2019520762, -306863565))) {
         choose(var0.ior ? ipp : (var0.isGlass() ? a.c(-686725162, "枟Ḋ铃વ") : a.c(-1403878507, "菖禎炝\ueef0攠")));
      } else {
         choose(var0.ior ? a.c(447449442, "褮\uf0b5穥\ue40c澌\ue95f匢\udade䒃츺") : a.d("㛧佼얬寅큅嚃\uecef攟ﭝ燽", -689530979, 365535542));
      }
   }

   public static void cycle(int var0) {
      if (var0 < 0) {
         PRESET.cyclePrev();
      } else {
         PRESET.cycle();
      }

      ACCENT.set(a.b("荂難瀕\uee7f", -1971944697));
   }

   public static String presetName() {
      return PRESET.get();
   }

   public static String shownName(String var0) {
      return a.d("\u206b姬팹䵏욃䀰", 161933876, 487901722).equals(var0) ? wap.s(a.c(927387966, "텻꣼∩뱟㞓넠"), a.b("涎ᐬ黳ó", -1110546005)) : wap.value(var0);
   }

   public static boolean isLight() {
      return ipi > 0.5F;
   }

   public static float lightness() {
      return ipi;
   }

   public static float tintScale() {
      return iph;
   }

   public static float windowTint() {
      return Math.max(Math.min(1.0F, (float)hyv.TINT.get() * iph), iqo());
   }

   static float photoDarken() {
      return Math.max(Math.max((float)isv.DARKEN.get(), 0.3F), iqo());
   }

   static int photoTone() {
      return ujt.lerp(-1, ipm, (0.5F - 0.32F * ipi) * Math.min(1.0F, ipn * 1.4F));
   }

   public static int logoTint() {
      return ujt.lerp(-1, ipk, 0.55F);
   }

   public static int tone() {
      return ipm;
   }

   public static int hudFill(float var0) {
      float var1 = 1.0F - Math.max(0.0F, Math.min(1.0F, var0));
      float var2 = ipc[0] ? 1.0F - ipv : 1.0F;
      int var3 = ipi > 0.5F ? ujt.lerp(ipm, -1, 0.55F) : ujt.shade(ipm, 0.5F);
      int var4 = ujt.lerp(window, var3, Math.min(0.75F, (0.25F + var1) * 0.85F) * ipn * var2);
      return ujt.withAlpha(var4, Math.round(255.0F * Math.max(0.0F, Math.min(1.0F, var0))));
   }

   public static int hudEdge() {
      int var0 = ujt.lerp(stroke, ipm, 0.35F + 0.4F * ipn);
      return ujt.withAlpha(var0, Math.round(40.0F + 70.0F * ipn));
   }

   private static float iqo() {
      float var0 = ujt.luminance(window);
      float var1;
      if (ipi > 0.5F) {
         float var2 = 0.7F;
         var1 = var0 - ipj > 0.05F ? (var2 - ipj) / (var0 - ipj) : 0.0F;
      } else {
         float var3 = 0.34F;
         var1 = ipj - var0 > 0.05F ? (ipj - var3) / (ipj - var0) : 0.0F;
      }

      return Math.max(0.0F, Math.min(0.92F, var1));
   }

   public static int accent() {
      return ipk;
   }

   public static int accent2() {
      return ipl;
   }

   public static int accent(int var0) {
      return ujt.withAlpha(ipk, var0);
   }

   public static int onAccent() {
      return ujt.luminance(ipk) > 0.62F ? -15592938 : -1;
   }

   public static float r(float var0) {
      return var0 * (float)ROUNDNESS.get();
   }

   static {
      iqn();
   }
}
