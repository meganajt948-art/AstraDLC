package a;

import flow.dev.a;
import java.awt.Color;
import java.util.ArrayList;

public final class kbs {
   private static final kbs[] kbt;
   public static final kbs DEFAULT;
   private static kbs kbu;
   public final String key;
   private final String kbv;
   private final String kbw;
   public final int accent;
   public final jsf particles;
   public final int tint;
   public final int fill;
   public final boolean light;
   private int kbx;

   private kbs(String var1, String var2, String var3, int var4, jsf var5, int var6, int var7, boolean var8) {
      this.key = var1;
      this.kbv = var2;
      this.kbw = var3;
      this.accent = var4;
      this.particles = var5;
      this.tint = var6;
      this.fill = var7;
      this.light = var8;
   }

   public boolean logo() {
      return this.fill >= 0;
   }

   public String title() {
      return wap.s(this.kbv, this.kbw);
   }

   public int ordinal() {
      return this.kbx;
   }

   public boolean isVideo() {
      return whl.is(this.key);
   }

   public static kbs[] values() {
      return kbt;
   }

   public static kbs selected() {
      return kbu;
   }

   public static void select(kbs var0) {
      kbu = var0;
   }

   public static void load(String var0) {
      kbs var1 = byKey(var0);
      if (var1 != null) {
         kbu = var1;
      }
   }

   public static kbs byKey(String var0) {
      for (kbs var4 : kbt) {
         if (var4.key.equals(var0)) {
            return var4;
         }
      }

      return null;
   }

   static String resource(String var0) {
      return whl.is(var0)
         ? whl.poster(var0.substring(a.d("慃ᣭ鈳ృ螞ź", -1555662234, 2080512853).length()))
         : a.b("\ua8c7턿實얔乛좲犣ﭚ攎\uefa4栭", 833399011) + var0 + a.d("⛤弑험䮾", -731496764, -226617334);
   }

   private static int kca(int var0) {
      float[] var1 = Color.RGBtoHSB(var0 >> 16 & 0xFF, var0 >> 8 & 0xFF, var0 & 0xFF, null);
      float var2 = Math.max(0.32F, Math.min(0.62F, var1[1]));
      return Color.HSBtoRGB(var1[0], var2, 1.0F) & 16777215;
   }

   static {
      ArrayList var0 = new ArrayList();
      var0.add(
         new kbs(
            a.c(906118871, "䚮㼀뗞⮮ꁳ⚗鲘ᕣ謿Ɩ蘟簧\uf2f5歗\ue11d"),
            a.c(2001845537, "뵭쓶並큏寏\udd1c条\uee9d烀啕"),
            a.c(-1895530086, "臗\uf84c犜\uecf5杵\ue5c3忦혆䠤슘䔴"),
            14476012,
            jsf.SILVER,
            16777215,
            263430,
            false
         )
      );
      var0.add(
         new kbs(
            a.b("毱\u125f颁۱贬ை뇇㠼Ꙡⳉꭀ兰\udfa2䘝챁䪬", -455513193),
            a.d("Ϡ穻\uf0ab滂\ue542掄\ud9e8倘칚䓺", -24606607, -195916835),
            a.b("됹춢䝲\ud91b力퀛橬\ue393緇\uf709", -2137410443),
            2764342,
            jsf.INK,
            16777215,
            15658989,
            true
         )
      );
      Object[][] var1 = new Object[][]{
         {a.b("䠊ㆸ뭺┘껖⡠鈺", 1048266878), a.d("僅⥗ꎕ㷷똹わ諕", 1040924393, -2084868488), a.b("䘋㾤땸⭹ꃔ♤", 1139950124), 15231626, jsf.MOTES},
         {
               a.c(-1363940738, "\uea1b鎡\u197f蜙\u0cce詴"),
               a.d("⮤刾\ud8e0䚆쵑䯫\uf1e1硼\ue60a沿\ueb7bᄙ鿘", 994635375, -1251424891),
               a.b("퉋ꯐⅳ뽷㓌눞࠴膻ᯱ镛ኋ\ue883晗￨疸", -56043946),
               15771864,
               jsf.PETALS
         },
         {
               a.d("슞묻\u31e9꾙\u2456ꋤᣴ酋༖薲ɦ", 1585797887, -1600481269),
               a.d("騹\ue3bc楮\uf71e糑謹䁾짬垑\udd35嫡", -738981844, -972254625),
               a.d("藳ﰝ皺\ue8c3挔\ue5a0忾툚䡟싪䕅뽎㆛꠨", -1725895089, -1180733524),
               15764026,
               jsf.LEAVES
         },
         {
               a.d("좔넧㯦ꖐ\u2e5f꣧", 1276002115, -1375733838),
               a.c(-1739735903, "볶앥侤퇒娝\udca5暳\uef0b煓ﮬ簫虆࢜酨᭘鶆⟊ꠁ㊣듥"),
               a.d("ᴞ撈\uee57瀤ﯷ祜윝䫾킿威\uddd8➢\ua97fツ뫢", -1254590292, -180461142),
               8370408,
               jsf.MOTES
         },
         {a.b("﨨莄ॖ霿", 13433439), a.b("৪灼甆擓\uef01榷폭婛쑷任줩㍀", 1449986464), a.c(2016702270, "欗ኺ顡ؖ跌\u0b7c넠㣕"), 11131391, jsf.MOTES},
         {a.b("㚛伱엣寍큄园\uecac", 1691629300), a.d("澄ᘍ鳌ˤ襞࿇떐㱤ꈰ⢙", 1794294066, 758951663), a.c(-2016359682, "컯띶㶡ꏔ⡷꺺ᒟ鴜ݚ觰๛\uf45a"), 7321328, jsf.PETALS},
         {a.c(1220274029, "\ue70c麷ᑧ討ǋ蝭㴿"), a.b("❽廢퐪䩅쇞䜸ﵵ璙\ueada怣\ue796᷍錙ર胱ؗ뱙", -1250744533), a.c(1853126663, "簂֒轆ᅆ骚᱙ꘀ⯡뇟㼏벺䚿졯冩\udb88嵵\ue73e"), 15254138, jsf.MOTES},
         {a.b("䌞㪦끿", -1222229128), a.b("铯\ued7b枻陸牏\uf49b仡윚", 567121059), a.c(390862784, "Ꮽ樯\ue091绡\uf53b珵췉䁕\ude7c咺퍡⥬Ꞻ㸈둑"), 11570431, jsf.FIREFLIES},
         {
               a.d("\ue2d8魻ᆤ迍Н芿㣤", 482750364, 636865840),
               a.c(1193092083, "⎵娲탮井앃䏥玲灛\uee0d擻\ue35bᤘ韃\u0e6a萾˜뢛"),
               a.d("注ᔺ鿫Ǫ訰\u0cfd뚭㼬ꄂ⮾걪噪\ud8bc䔔쬦䶦\uf7e5硋\ue2fb據\ued24", -892250093, 1969762511),
               14700624,
               jsf.MOTES
         },
         {a.d("䬚㊬롬☂", 1999947131, 1262521859), a.b("써뫿〷깛▚ꌺ\u193d邪໒葰μ", -1515142352), a.b("秛{諝ᓐ鼋ᶪꏤ⨘끗㻱뤥䍞춃呀\ude64", 282164720), 15904842, jsf.MOTES}
      };

      for (Object[] var5 : var1) {
         var0.add(new kbs(a.c(350859266, "끲짜䌂\udd72嚯큋") + var5[0], (String)var5[1], (String)var5[2], kca((Integer)var5[3]), (jsf)var5[4], 16777215, -1, false));
      }

      kbt = var0.toArray(new kbs[0]);
      int var6 = 0;

      while (var6 < kbt.length) {
         kbt[var6].kbx = var6++;
      }

      DEFAULT = kbt[0];
      kbu = DEFAULT;
   }
}
