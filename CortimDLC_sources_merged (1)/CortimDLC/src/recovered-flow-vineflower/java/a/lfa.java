package a;

import flow.Flow;
import flow.config.ConfigManager;
import flow.dev.a;

public class lfa extends kfe {
   private static lfa lfb;
   private static tiq lfc;
   private static String lfd = "";
   private final vkw lfe = this.add(new vkw(a.d("㹘䟎촜卼\ud8a6帑", 1125465510, -1174142037), new vkq(a.c(-1758046623, "嘥⾫ꕭ㬗낎㙬谸\u05c8鮆ᄺ雯"), vhz.LAYERS, ign::open)));
   private final vmu lff = this.add(new vmu(a.b("쏝멎む껸┠ꎔ\u19ce", 722125706), "", 32));
   private final vkl lfg = this.add(new vkl(a.c(-987561507, "Ɣ砑\uf2c3沩\ue75c應\udb9d剧"), true));
   private final vkl lfh = this.add(new vkl(a.d("쯅뉀㢒\ua6f8ⴅꮟᇆ", -1771926427, -791263258), true));
   private final vkl lfi = this.add(new vkl(a.d("ᗱ汴\ue6a6磌\uf323疤쿤䘃\ud85d勧", -38231102, 769767032), true));
   private final vlq lfj = this.add(new vlq(a.b("焈࢞艖\u1c38鞿ᅝꬉ⋭벽㘆뇂", 737177936), 269));
   private final vmu lfk = this.add(new vmu(a.d("똺쾯䕻\udb01傓홲氣\ue5cf箙\uf127盱貉", -628552157, -1278101416), "", 32));
   private final vmu lfl = this.add(new vmu(a.c(-903150683, "Ͼ穹\uf0a7滑\ue54d掬\ud9fd們칇䓹쌯㥗"), "", 32));
   private static tiq lfm;
   private static String lfn = "";
   private static tiq lfo;
   private static String lfp = "";

   public lfa() {
      super(
         a.c(910706515, "䜐㺊둉⨿ꇵ❹鴗ᓽ誷\u0013蟝綪\uf37c"),
         a.c(311183862, "䦑〖뫟⒩꼬⧒鎙ᩱ葠\u0e85襐猲\ufded摛\uee03棳틸嵻쟕䆟졽눹㲗Ꝁℾꮡቔ鰌ۦ胥ଷ\uf5d2羜\ue676怇\uea92啂\udf38妢쀟䨡㓤뺶㤜ꏡⶻ鑢ẗ颙͇贾瞫ﹽ砘\ue2ea沠휧净\udba0䉧쳑뚋"),
         kfa.COMBAT
      );
      lfb = this;
      this.lff.visibleWhen(() -> false);
      this.lfk.visibleWhen(() -> false);
      this.lfl.visibleWhen(() -> false);
   }

   public static tiq walkProfile() {
      lfa var0 = lfb;
      if (var0 == null) {
         return null;
      }

      String var1 = var0.lfl.get();
      if (var1 != null && !var1.isBlank()) {
         if (lfo == null || !var1.equals(lfp)) {
            lfp = var1;
            lfo = tiq.open(var1);
         }

         return lfo;
      } else {
         lfo = null;
         lfp = "";
         return null;
      }
   }

   public static void activateWalk(tiq var0) {
      lfa var1 = lfb;
      if (var1 != null) {
         var1.lfl.set(var0 == null ? "" : var0.name);
         lfo = var0;
         lfp = var0 == null ? "" : var0.name;
         ConfigManager.autoSaveLater();
      }
   }

   public static void useForWalk(tiq var0) {
      lfa var1 = lfb;
      if (var1 != null) {
         activateWalk(var0);
         var1.lfh.set(true);
         var1.lfi.set(true);
         if (!var1.isEnabled()) {
            var1.setEnabled(true);
         }
      }
   }

   public static boolean walksWith(tiq var0) {
      lfa var1 = lfb;
      return var1 != null && var0 != null && (var1.lfh.get() || var1.lfi.get()) && walkProfile() == var0;
   }

   public static txs walkModel(lex var0) {
      lfa var1 = lfb;
      if (var1 != null && var1.lft(var0)) {
         tiq var2 = walkProfile();
         return var2 != null && var2.walk() ? var2.walkModel() : null;
      } else {
         return null;
      }
   }

   public static tiq mineProfile() {
      lfa var0 = lfb;
      if (var0 == null) {
         return null;
      }

      String var1 = var0.lfk.get();
      if (var1 != null && !var1.isBlank()) {
         if (lfm == null || !var1.equals(lfn)) {
            lfn = var1;
            lfm = tiq.open(var1);
         }

         return lfm;
      } else {
         lfm = null;
         lfn = "";
         return null;
      }
   }

   public static void activateMine(tiq var0) {
      lfa var1 = lfb;
      if (var1 != null) {
         var1.lfk.set(var0 == null ? "" : var0.name);
         lfm = var0;
         lfn = var0 == null ? "" : var0.name;
         ConfigManager.autoSaveLater();
      }
   }

   public static void useForMine(tiq var0) {
      lfa var1 = lfb;
      if (var1 != null) {
         activateMine(var0);
         var1.lfg.set(true);
         if (!var1.isEnabled()) {
            var1.setEnabled(true);
         }
      }
   }

   public static boolean minesWith(tiq var0) {
      lfa var1 = lfb;
      return var1 != null && var0 != null && var1.lfg.get() && mineProfile() == var0;
   }

   public static double mineBoost() {
      tiq var0 = mineProfile();
      return var0 == null ? 0.0 : var0.mineBoost() / 100.0;
   }

   public static ttb mineModel() {
      lfa var0 = lfb;
      if (var0 != null && var0.lfg.get()) {
         tiq var1 = mineProfile();
         return var1 != null && var1.mine() ? var1.mineModel() : null;
      } else {
         return null;
      }
   }

   @Override
   public boolean isHidden() {
      return true;
   }

   public static lfa get() {
      return lfb;
   }

   public static tiq activeProfile() {
      lfa var0 = lfb;
      if (var0 == null) {
         return null;
      }

      String var1 = var0.lff.get();
      if (var1 != null && !var1.isBlank()) {
         if (lfc == null || !var1.equals(lfd)) {
            lfd = var1;
            lfc = tiq.open(var1);
         }

         return lfc;
      } else {
         lfc = null;
         lfd = "";
         return null;
      }
   }

   public static void activate(tiq var0) {
      lfa var1 = lfb;
      if (var1 != null) {
         var1.lff.set(var0 == null ? "" : var0.name);
         lfc = var0;
         lfd = var0 == null ? "" : var0.name;
         ConfigManager.autoSaveLater();
      }
   }

   public static int stopKey() {
      lfa var0 = lfb;
      return var0 == null ? 269 : var0.lfj.get();
   }

   public static tck model(lex var0) {
      lfa var1 = lfb;
      if (var1 != null && var1.lft(var0)) {
         tiq var2 = activeProfile();
         return var2 != null && !var2.aura() && !var2.mine() && !var2.walk() ? var2.model() : null;
      } else {
         return null;
      }
   }

   public static tck modelOr1(lex var0) {
      tck var1 = model(var0);
      return var1 != null ? var1 : tck.profile1();
   }

   public static boolean turning() {
      return lfs(a.c(1962348833, "ᅩ棰\ue227籺\uf79f焮쭧䊌\udcd4"))
         || lfs(a.c(-2086043640, "聁龍猖\ued7c暉\ue01c婈펲"))
         || lfs(a.d("뵊쓏丝큷宊\udd10杉", 332989849, -1704609643))
         || lfs(a.c(1571927494, "떍찈䛚\ud8b0卟험澘\ue67f砡\uf29b"))
         || nfl.busy()
         || lqq.busy();
   }

   private static boolean lfs(String var0) {
      Flow var1 = Flow.getInstance();
      kfe var2 = var1.getModuleManager() == null ? null : var1.getModuleManager().getByName(var0);
      return var2 != null && var2.isEnabled();
   }

   private boolean lft(lex var1) {
      return switch (var1) {
         case MINE -> this.lfg.get();
         case END -> this.lfh.get();
         case WARDEN -> this.lfi.get();
      };
   }
}
