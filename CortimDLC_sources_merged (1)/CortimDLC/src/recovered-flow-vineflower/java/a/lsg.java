package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class lsg extends kfe {
   private static lsg lsh;
   private final vlv lsi = this.add(
      new vlv(a.d("眊\u0e80葛ᨪ釶ᝎ", -1385517365, 1254218131), a.d("敖茇ঢ়鞥ᱤ髒ₜꥥ㜷", 760641135, 1036029109), lst(false).toArray(String[]::new))
   );
   private final vkl lsj = this.add(new vkl(a.c(562964867, "⧊偓\uda8b䓡"), true));
   private final vlv lsk = this.add(new vlv(a.b("\ude10Ꞁⵎ", 138731099), a.b("\ue9b9逡\u1af2", -481695243), lst(true).toArray(String[]::new)));
   private final vmc lsl = this.add(new vmc(a.d("\uf796踞ӎ骦ᅩ韐", 522986322, -1863920492), 0.6, 0.0, 1.5, 0.05).percent());
   private long lsm;
   private long lsn;
   private int lso = vpo.version();
   private String lsp;
   private String lsq;

   public lsg() {
      super(a.d("迉\uf657粁\ue2fc椠\uef8b嗿\udc32䉷죝伄땢", -925663867, 1116205571), a.c(1724206838, "亾㜳뷺⎐ꡍ⻫铫ᵜ茊দ踧琂龜捷\ue924濞햘婟삿䚯콗딌㯻ꁢ☜곐ᕤ"), kfa.MISC);
      lsh = this;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      boolean var2 = var1.currentScreen instanceof hlc;
      long var3 = System.currentTimeMillis();
      if (var2 && var3 - this.lsn > 1200L) {
         this.lsn = var3;
         vpo.scan();
      }

      if (this.lso != vpo.version()) {
         this.lsu();
      }

      if (this.lsp != null && !this.lsi.is(this.lsp) && var2 && !this.lsi.is(a.d("\ue0f2饪Ꮉ", 1333226027, 1328777877))) {
         voa.play(this.lsi.get(), true, (float)this.lsl.get());
      } else if (this.lsq != null && !this.lsk.is(this.lsq) && var2 && !this.lsk.is(a.c(-1571883179, "\uf719躁ђ"))) {
         voa.play(this.lsk.get(), true, (float)this.lsl.get());
      }

      this.lsp = this.lsi.get();
      this.lsq = this.lsk.get();
   }

   private static List<String> lst(boolean var0) {
      vpo.scan();
      ArrayList var1 = new ArrayList();
      if (var0) {
         var1.add(a.c(1391280322, "䂎㤖독"));
      }

      var1.addAll(voa.BUILT_IN);
      var1.addAll(vpo.extras());
      if (!var0) {
         var1.add(a.c(1263274936, "௴牬\uf8bf"));
      }

      return var1;
   }

   private void lsu() {
      this.lsi.setModes(lst(false));
      this.lsk.setModes(lst(true));
      this.lso = vpo.version();
   }

   private static void lsv() {
      lsg var0 = lsh;
      vpo.scan();
      if (var0 != null) {
         var0.lsu();
         if (!var0.lsi.is(a.c(-2024810460, "\ud868ꇰ⬣"))) {
            voa.play(var0.lsi.get(), true, (float)var0.lsl.get());
         }
      }
   }

   private static boolean lsw() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      return lsh != null && lsh.isEnabled() && var0.player != null;
   }

   public static void toggled(kfe var0) {
      lsg var1 = lsh;
      if (lsw() && (var0 != var1 || var0.isEnabled()) && !var1.lsi.is(a.d("芥\ufb3d燮", -935904730, 1123596495))) {
         long var2 = System.currentTimeMillis();
         if (var2 - var1.lsm >= 60L) {
            var1.lsm = var2;
            voa.play(var1.lsi.get(), var0.isEnabled(), (float)var1.lsl.get());
         }
      }
   }

   public static void menu(boolean var0) {
      lsg var1 = lsh;
      if (lsw() && var1.lsj.get() && !var1.lsi.is(a.b("䷭㑵뺦", -633451103))) {
         voa.menu(var1.lsi.get(), var0, (float)var1.lsl.get());
      }
   }

   public static void hit(Entity var0) {
      lsg var1 = lsh;
      if (lsw() && !var1.lsk.is(a.b("㕣䳻온", 2053059887)) && var0 instanceof LivingEntity) {
         voa.play(var1.lsk.get(), true, (float)var1.lsl.get());
      }
   }
}
