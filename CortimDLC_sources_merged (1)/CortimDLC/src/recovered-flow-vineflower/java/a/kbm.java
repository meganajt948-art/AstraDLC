package a;

import flow.dev.a;
import java.util.List;

public final class kbm {
   public static final vkl TITLE = new vkl(a.c(-863354905, "㾖䘺쳴劝\ud943"), false);
   public static final vlv POSITION = new vlv(
      a.b("\udcc8ꕦ⾩뇂㨈벤۱輁", -1349133136),
      a.c(373756639, "ኗ欏\ue1df羼"),
      a.c(1813437214, "\udb56ꋎ⠞뙽"),
      a.d("诔\uf243碛\ue6f0洶\ueb90", 1395788748, -255950755),
      a.b("뺜윖䷋펵塾", -1449083189)
   );
   public static final vlv BUTTONS = new vlv(
      a.d("䪹㌟맍➼거⫀邎", 1104814711, -1701091157),
      a.d("좥넿㯡ꖂ⹕", 29292174, -1649131927),
      a.c(-2119748357, "㒹䴣쟽妞퉉"),
      a.c(-1282769139, "罍ۙ谙ቱ"),
      a.c(-350027891, "ￄ虐\u0c8d鋳ᤸ"),
      a.b("뛡콪䖸\udbd1倃횵泭", -260852055)
   );
   public static final vmc BLUR = new vmc(a.b("ퟮ깑⒛뫭", -1010051192), 0.0, 0.0, 1.0, 0.05).percent();
   public static final vmc ROUND = new vmc(a.b("\ud854ꇸ⬱땛㺆", 1586944035), 0.55, 0.0, 1.0, 0.05).percent();
   public static final vmc DIM = new vmc(a.c(-1035119985, "勨⭔ꆃ"), 0.0, 0.0, 0.6, 0.05).percent();
   public static final vkl PARTICLES = new vkl(a.b("㟤乄쒄嫳턹垂\uedde搦\ufa6f", 1500133277), true);
   public static final vkl PARALLAX = new vkl(a.c(1018353912, "\ud880ꄠ⯠떂㹘룩ʷ譟"), true);
   public static final List<vmo> ALL = List.of(TITLE, POSITION, BUTTONS, BLUR, ROUND, DIM, PARTICLES, PARALLAX);

   private kbm() {
   }

   public static void reset() {
      TITLE.reset();
      POSITION.reset();
      BUTTONS.reset();
      BLUR.reset();
      ROUND.reset();
      DIM.reset();
      PARTICLES.reset();
      PARALLAX.reset();
   }
}
