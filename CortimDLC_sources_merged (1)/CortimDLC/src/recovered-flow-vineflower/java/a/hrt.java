package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;

public final class hrt extends ijy {
   static final float hru = 470.0F;
   static final float hrv = 336.0F;
   static final float hrw = 12.0F;
   static final float hrx = 30.0F;
   static final float hry = 22.0F;
   static final float hrz = 16.0F;
   static final float hsa = 26.0F;
   static final float hsb = 4.0F;
   static final float hsc = 266.0F;
   static final float hsd = 14.0F;
   final iah search = new iah(a.d("﹋蟌ഛ鍹ᢿ鸅", 1574397152, -1990026498), vhz.SEARCH, 32, iah.ANY);
   final float hse;
   final float hsf;
   final vcj hsg = new vcj(16.0F);
   final vcj hsh = new vcj(18.0F);
   final List<hrk> hsi = new ArrayList<>();
   final List<pdr> hsj = new ArrayList<>();
   float hsk;
   boolean hsl;
   pdr hsm;
   String hsn;

   hrt(float var1, float var2) {
      this.hse = (var1 - 470.0F) * 0.5F;
      this.hsf = (var2 - 336.0F) * 0.5F;
      this.search.onChange = var1x -> this.hsq();
      pdr var3 = mkl.collecting();
      this.hsm = var3 != null ? var3 : pej.items().get(0);
      this.hsq();
   }

   public static void open() {
      if (MinecraftClient.getInstance().currentScreen instanceof hlc var0) {
         var0.openOverlay(new hrt(540.0F, 409.0F));
      }
   }

   void hsq() {
      this.hsj.clear();
      String var1 = this.search.text.toLowerCase(Locale.ROOT).trim();

      for (pdr var3 : pej.items()) {
         if (var1.isEmpty() || var3.searchText().contains(var1) || wap.matches(var3.searchText(), this.search.text)) {
            this.hsj.add(var3);
         }
      }

      this.hsk = Math.min(this.hsk, this.hsy());
   }

   void hsr() {
      pej.changed();
   }

   @Override
   iah field() {
      return this.search;
   }

   @Override
   boolean gone() {
      return this.hsl && this.hsg.get() <= 0.01F;
   }

   @Override
   boolean closing() {
      return this.hsl;
   }

   @Override
   void close() {
      this.hsl = true;
   }

   float hss() {
      return this.hse + 12.0F;
   }

   float hst() {
      return this.hsf + 30.0F + 22.0F + 8.0F;
   }

   float hsu() {
      return 336.0F - (this.hst() - this.hsf) - 16.0F - 8.0F;
   }

   int hsv() {
      return Math.max(1, 9);
   }

   float hsw() {
      int var1 = this.hsv();
      return var1 <= 1 ? 30.0F : 240.0F / (var1 - 1);
   }

   float hsx() {
      int var1 = (this.hsj.size() + this.hsv() - 1) / this.hsv();
      return var1 * 30.0F - 4.0F;
   }

   float hsy() {
      return Math.max(0.0F, this.hsx() - this.hsu());
   }

   @Override
   void render(DrawContext var1, hlc var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = vcq.outCubic(this.hsg.step(this.hsl ? 0.0F : 1.0F, var5));
      if (!(var8 <= 0.01F)) {
         boolean var9 = !this.hsl;
         if (!var9) {
            var3 = -10000.0F;
            var4 = -10000.0F;
         }

         this.hsi.clear();
         this.hsn = null;
         float var10 = iov.r(10.0F);
         float var11 = iov.lightness();
         uut.round(var1, 0.0F, 0.0F, var6, var7, iov.r(12.0F), ujt.withAlpha(0, Math.round(110.0F * var8)));
         uut.pushAlpha(var8);
         var1.getMatrices().pushMatrix();
         float var12 = 0.96F + 0.04F * var8;
         var1.getMatrices().translate(this.hse + 235.0F, this.hsf + 168.0F + (1.0F - var8) * 6.0F);
         var1.getMatrices().scale(var12, var12);
         var1.getMatrices().translate(-(this.hse + 235.0F), -(this.hsf + 168.0F));
         uut.shadow(var1, this.hse, this.hsf + 4.0F, 470.0F, 336.0F, var10, 18.0F, iov.shadow);
         uut.round(var1, this.hse, this.hsf, 470.0F, 336.0F, var10, ujt.withAlpha(iov.window, 252));
         uut.round(var1, this.hse, this.hsf, 470.0F, 336.0F, var10, iov.card);
         ukf.sheen(var1, this.hse, this.hsf, 470.0F, 50.0F, var10, 0.8F * (1.0F - 0.7F * var11));
         uut.outline(var1, this.hse, this.hsf, 470.0F, 336.0F, var10, 1.0F, iov.stroke);
         ukf.rim(var1, this.hse, this.hsf, 470.0F, 336.0F, var10, var11, 1.0F);
         this.hsz(var1, var3, var4);
         this.hta(var1, var2, var3, var4, var5);
         this.htc(var1, var3, var4, var5);
         this.htd(var1, var3, var4);
         this.hti(var1);
         var1.getMatrices().popMatrix();
         uut.popAlpha();
      }
   }

   void hsz(DrawContext var1, float var2, float var3) {
      float var4 = this.hsf + 15.0F + 1.0F;
      vjf.draw(var1, vhz.LAYERS, this.hse + 12.0F + 5.0F, var4, 10.0F, iov.accent());
      String var5 = wap.s(a.b("䇹㡼늮Ⳅꜿ↢鯲ሃ豕ۢ脦筌\uf586汥\ue67a悎\udadb唍", -1134083670), a.b("媩⌆꧒㟚뱲㫇蒎ഞ鍵ᧅ鸍摐\ueaab猙壘羲엻䨽킕囙", 1088708252));
      irr.CARD_TITLE.draw(var1, var5, this.hse + 12.0F + 16.0F, irr.CARD_TITLE.centerTop(var4), iov.text);
      String var6 = pej.activeCount()
         + a.d("悑\u192f鏳", 1288312977, 1741125667)
         + pej.items().size()
         + wap.s(a.d("줘냦㨴", -1637953483, -319678194), a.b("쨀랣㵸ꌈ", 593480228));
      float var7 = this.hse + 12.0F + 16.0F + irr.CARD_TITLE.width(var5) + 8.0F + Math.max(16.0F, irr.SMALL.width(var6) + 9.0F);
      irr.drawChip(var1, var6, var7, var4, iov.textDim, iov.stroke, 0.0F);
      pdr var8 = mkl.collecting();
      if (var8 != null) {
         String var9 = wap.s(a.c(490863395, "ﭬ英ࠡ限ᶎ鬹ⅽꢑ㛉뱱㯿솔"), a.b("ᵒ擼\uee20灘ﯷ紶읠亘퓁幪", -2088691335)) + var8.name();
         irr.SMALL.draw(var1, var9, var7 + 8.0F, irr.SMALL.centerTop(var4), iov.accent());
      }

      float var13 = 16.0F;
      float var10 = this.hse + 470.0F - 12.0F - var13;
      float var11 = this.hsf + (30.0F - var13) * 0.5F + 1.0F;
      boolean var12 = irr.inside(var2, var3, var10, var11, var13, var13);
      irr.iconButton(var1, vhz.CLOSE, var10, var11, var13, var12 ? 1.0F : 0.0F, false, 1.0F);
      this.hsi.add(new hrk(var10, var11, var13, var13, this::close, null));
   }

   void hta(DrawContext var1, hlc var2, float var3, float var4, float var5) {
      float var6 = this.hsf + 30.0F + 2.0F;
      this.search.x = this.hse + 12.0F;
      this.search.y = var6 + 3.0F;
      this.search.w = 150.0F;
      this.search.h = 16.0F;
      this.search.render(var1, var2, var3, var4, var5);
      float var7 = 16.0F;
      float var8 = this.search.y;
      String[] var9 = new String[]{
         wap.s(a.d("쇗롋㊘겥✽ꆍ", -586852737, 2065864687), a.c(743499507, "\ue2ed魴ᆦ辢Ѽ芲㢛녤⭗ꗴ≔\ud851")),
         wap.s(a.b("蒡ﴽ矮\ue9d3手\ue4f3庠", 183469287), a.b("㼂䛪챈券\ud99a弢\ue50e沅\uf2d4簉\uffc8\u05ca譩", 1301625629)),
         wap.s(a.c(-1949949019, "⏲婴킱他씐"), a.d("\uf118袹ț鰔ូ", -936444091, 2007108217))
      };
      vhz[] var10 = new vhz[]{vhz.CHECK, vhz.CLOSE, vhz.RESET};
      Runnable[] var11 = new Runnable[]{
         () -> this.htb(true),
         () -> this.htb(false),
         () -> {
            pej.resetAll();
            var2.toast(
               wap.s(a.b("樁᎓饂ܻ貧ੂ뀊㦴ꞿⴒ\uaacc僸\ude6b䟛춋䭽\uf126绮\ue445所\uebfb醯ἆ蓐", -2010813861), a.c(1167128754, "ﲻ蔭ྋ醇ᨮ鳧⚷ꭞㅠ뮯㱻왳䣛텮弧\uddc9枇\uec48犘\uf4b6絃ܗ觘ቾ鐌Ộꜝ")),
               vhz.RESET,
               false
            );
         }
      };
      float var12 = this.search.x + this.search.w + 8.0F;
      float var13 = (this.hse + 470.0F - 12.0F - var12 - 12.0F) / 3.0F;

      for (int var14 = 0; var14 < 3; var14++) {
         float var15 = var12 + var14 * (var13 + 6.0F);
         boolean var16 = irr.inside(var3, var4, var15, var8, var13, var7);
         irr.secondaryButton(var1, var9[var14], var10[var14], var15, var8, var13, var7, var16 ? 1.0F : 0.0F, 0.0F);
         this.hsi.add(new hrk(var15, var8, var13, var7, var11[var14], null));
      }
   }

   void htb(boolean var1) {
      for (pdr var3 : this.hsj) {
         var3.setActive(var1);
      }

      this.hsr();
   }

   void htc(DrawContext var1, float var2, float var3, float var4) {
      float var5 = this.hss();
      float var6 = this.hst();
      float var7 = this.hsu();
      float var8 = this.hsh.step(Math.max(0.0F, Math.min(this.hsk, this.hsy())), var4);
      int var9 = this.hsv();
      float var10 = this.hsw();
      pdr var11 = mkl.collecting();
      float var12 = iov.r(5.0F);
      uut.pushScissor(var1, var5 - 2.0F, var6 - 2.0F, 270.0F, var7 + 4.0F);

      for (int var13 = 0; var13 < this.hsj.size(); var13++) {
         pdr var14 = this.hsj.get(var13);
         float var15 = var5 + var13 % var9 * var10;
         float var16 = var6 + var13 / var9 * 30.0F - var8;
         if (!(var16 + 26.0F < var6 - 2.0F) && !(var16 > var6 + var7 + 2.0F)) {
            boolean var17 = irr.inside(var2, var3, var15, var16, 26.0F, 26.0F) && irr.inside(var2, var3, var5, var6, 266.0F, var7);
            boolean var18 = var14.active();
            int var19 = var18 ? ujt.lerp(iov.field, iov.accent(), 0.22F) : iov.field;
            uut.round(var1, var15, var16, 26.0F, 26.0F, var12, var17 ? ujt.lerp(var19, iov.fieldHover, 0.6F) : var19);
            if (var14 == this.hsm) {
               uut.outline(var1, var15, var16, 26.0F, 26.0F, var12, 1.2F, iov.accent(230));
            } else if (var18) {
               uut.outline(var1, var15, var16, 26.0F, 26.0F, var12, 1.0F, iov.accent(90));
            }

            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(var15 + 5.0F, var16 + 5.0F);
            var1.drawItem(var14.icon(), 0, 0);
            var1.getMatrices().popMatrix();
            if (!var18) {
               uut.round(var1, var15, var16, 26.0F, 26.0F, var12, ujt.withAlpha(iov.window, 150));
            }

            if (var14.count() > 1) {
               String var20 = String.valueOf(var14.count());
               irr.SMALL.drawRight(var1, var20, var15 + 26.0F - 2.0F, var16 + 26.0F - 7.5F, var18 ? iov.text : iov.textMuted);
            }

            if (var14 == var11) {
               uut.circle(var1, var15 + 26.0F - 4.0F, var16 + 4.0F, 2.5F, iov.accent());
            }

            if (var17) {
               this.hsn = var14.name() + (var18 ? "" : wap.s(a.d("\ue315骤რ踆ב茯㥵낄", 769328025, 282255524), a.d("珇੶耲Ổ锃ហ궊␊메ゐ띊䵉쎖", 113131924, 1294283390)));
            }

            pdr var24 = var14;
            this.hsi.add(new hrk(var15, var16, 26.0F, 26.0F, () -> this.hsm = var24, () -> {
               var24.setActive(!var24.active());
               this.hsm = var24;
               this.hsr();
            }));
         }
      }

      uut.popScissor(var1);
      float var21 = this.hsy();
      if (var21 > 0.0F) {
         float var22 = Math.max(18.0F, var7 * var7 / this.hsx());
         float var23 = var6 + (var7 - var22) * (var8 / var21);
         uut.round(var1, var5 + 266.0F + 4.0F, var23, 2.5F, var22, 1.25F, ujt.withAlpha(iov.textMuted, 110));
      }
   }

   void htd(DrawContext var1, float var2, float var3) {
      float var4 = this.hss() + 266.0F + 14.0F;
      float var5 = this.hst();
      float var6 = this.hse + 470.0F - 12.0F - var4;
      float var7 = this.hsu();
      uut.round(var1, var4, var5, var6, var7, iov.r(7.0F), iov.field);
      pdr var8 = this.hsm;
      if (var8 != null) {
         float var9 = var4 + 8.0F;
         float var10 = var5 + 8.0F;
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(var9, var10);
         var1.drawItem(var8.icon(), 0, 0);
         var1.getMatrices().popMatrix();
         float var11 = var9 + 22.0F;
         irr.NAME.draw(var1, irr.NAME.ellipsize(var8.name(), var6 - 34.0F), var11, irr.NAME.centerTop(var10 + 4.0F), iov.text);
         String var12 = var8.hasQuery()
            ? wap.s(a.c(1489735870, "郅\ue962掵\ufdd7瘑\uf0ab䪪썁"), a.c(672438366, "鱦\ue5d6漃\uf10b窧\uf816䉟")) + var8.query()
            : (
               var8.deepScan()
                  ? wap.s(
                     a.d("啇⳽꘣㡖뎐㔴轱ڇ颌ቲ閨澟\ue11c碱\uf2ef瑛칒䆌\udb24嵴풄꺁\u2062뮢㷛뜈ອ", 2030775095, -1811907064),
                     a.b("倣⦓ꌽ㴱뛡し計Έ鶧\u1717铝櫍\ue07b緕\uf78c焈쬵䒝\ude20尔톂ꯐ╡뻀㢲뉦\u0bab", -1150200820)
                  )
                  : wap.s(a.d("ꊪ\udb10凎쾻䑽싙碜\uf16a潡\ue59c扌頦", -1504627500, -1719233007), a.b("\uec33闳Ἤ脪એ蠧㙠뾐↲\uab1aⲪ횢堇얯䯧촓眠", -982390685))
            );
         irr.SMALL.draw(var1, irr.SMALL.ellipsize(var12, var6 - 34.0F), var11, irr.SMALL.centerTop(var10 + 12.5F), iov.textMuted);
         float var13 = var5 + 30.0F;
         float var14 = var4 + 8.0F;
         float var15 = var6 - 16.0F;
         uut.rect(var1, var14, var13 - 3.0F, var15, 1.0F, iov.divider);
         boolean var16 = irr.inside(var2, var3, var14, var13, var15, 14.0F);
         irr.LABEL
            .draw(
               var1,
               wap.s(a.d("ᷙ摟\uee80", 1229833796, 1776344028), a.d("퐞궎❙륑㋺둄\u0e65螚", 475041440, 2100977321)),
               var14,
               irr.LABEL.centerTop(var13 + 7.0F),
               var16 ? iov.text : iov.textDim
            );
         irr.drawSwitch(var1, var14 + var15 - 17.0F, var13 + 2.25F, var8.active() ? 1.0F : 0.0F, var16 ? 1.0F : 0.0F);
         this.hsi.add(new hrk(var14, var13, var15, 14.0F, () -> {
            var8.setActive(!var8.active());
            this.hsr();
         }, null));
         var13 += 17.0F;
         if (var8.stackable()) {
            irr.LABEL.draw(var1, wap.s(a.c(2010725865, "㶦䐹컪傎"), a.c(-110722323, "蛾ｮ痈\uebcf怞\ue6dd岀")), var14, irr.LABEL.centerTop(var13 + 7.0F), iov.textDim);
            this.hth(var1, var2, var3, var14 + var15, var13, String.valueOf(var8.count()), () -> {
               var8.setCount(var8.count() - hte(var8));
               this.hsr();
            }, () -> {
               var8.setCount(var8.count() + hte(var8));
               this.hsr();
            });
            var13 += 17.0F;
         }

         List var17 = var8.shownRules();
         if (!var17.isEmpty()) {
            var13 = this.htg(var1, wap.s(a.d("፯櫲\ue020繛\uf581猭쥣䂔\udeca呦", -405987232, 15741766), a.d("孴⊧ꠎ㙺붡㬚脾", -1962051645, 1551313043)), var14, var13, var15);

            for (phm var19 : var17) {
               boolean var20 = var19.state() == phj.ON;
               boolean var21 = irr.inside(var2, var3, var14, var13, var15 - (var19.hasLevel() ? 44.0F : 0.0F), 14.0F);
               float var22 = 3.0F;
               uut.circle(var1, var14 + var22, var13 + 7.0F, var22, var20 ? iov.accent() : ujt.withAlpha(iov.textMuted, 120));
               String var23 = var19.label();
               if (var19.hasLevel()) {
                  int var24 = var23.lastIndexOf(32);
                  var23 = var24 > 0 ? var23.substring(0, var24) : var23;
               }

               int var36 = var20 ? (var21 ? iov.text : iov.textDim) : iov.textMuted;
               irr.LABEL.draw(var1, irr.LABEL.ellipsize(var23, var15 - 56.0F), var14 + 10.0F, irr.LABEL.centerTop(var13 + 7.0F), var36);
               this.hsi.add(new hrk(var14, var13, var15 - (var19.hasLevel() ? 44.0F : 0.0F), 14.0F, () -> {
                  var19.setState(var19.state() == phj.ON ? phj.OFF : phj.ON);
                  this.hsr();
               }, null));
               if (var19.hasLevel() && var20) {
                  String var25 = var19.isEnchant() ? String.valueOf(var19.level()) : pfl.roman(var19.level());
                  this.hth(var1, var2, var3, var14 + var15, var13, var25, () -> {
                     var19.setLevel(var19.level() - 1);
                     this.hsr();
                  }, () -> {
                     var19.setLevel(var19.level() + 1);
                     this.hsr();
                  });
               }

               var13 += 14.0F;
            }

            var13 += 3.0F;
         }

         if (var8.hasEffects()) {
            var13 = this.htg(
               var1,
               wap.s(a.b("풃광⟂린㉡듇ຓ蜱ᥦ鎞ᑀ\uee31悪凜猎\uf5b9侢쁯嫑\udc88唾⽣ꆕ㩙밿㛬轈ā鯣ᷢ", 99734744), a.b("⿆嘞\udccd䋍줕俜\uf586砜\ue64b棠\uef40ᕅ龋ض蠅ຊ듉㬗ꆧ⏨깽푞嫧섴䝆즋", 946023409)),
               var14,
               var13,
               var15
            );

            for (pig var31 : var8.effects()) {
               String var33 = var31.effect().value().getName().getString() + a.b("黲", -82207021) + pfl.roman(var31.level());
               String var35 = var31.duration() > 0 ? htf(var31.duration()) : "";
               irr.LABEL.draw(var1, irr.LABEL.ellipsize(var33, var15 - 30.0F), var14 + 2.0F, irr.LABEL.centerTop(var13 + 7.0F), iov.textDim);
               irr.SMALL.drawRight(var1, var35, var14 + var15, irr.SMALL.centerTop(var13 + 7.0F), iov.textMuted);
               var13 += 13.0F;
            }
         }

         if (var8.hasAttrs()) {
            var13 = this.htg(var1, wap.s(a.c(1448036758, "䧘\u3040몉ⓣ꼾⧋鏚ᨰ"), a.d("\ue6a4鼴ᗦ讞C蛿㳍딯⭳ꇌ", -477069972, -464150564)), var14, var13, var15);
            irr.SMALL
               .draw(
                  var1,
                  wap.s(a.c(590188363, "輵\uf699籍\ue26f槹\uef5d唎\udcf9䊽젇促떳㭵ꊁ⢟깬ᐨ鯴ň蜖\u0eed璫神"), a.c(-169664450, "␖嶦퍫䤇식䑭︱瞾\ue9e2朰\ue486Ẃ逥\u09e4莽Դ뼌エꩣⱋꖿ\udf94儥")),
                  var14 + 2.0F,
                  irr.SMALL.centerTop(var13 + 7.0F),
                  iov.textDim
               );
         }

         if (var8.changed()) {
            float var30 = 15.0F;
            float var32 = var5 + var7 - var30 - 7.0F;
            boolean var34 = irr.inside(var2, var3, var14, var32, var15, var30);
            irr.secondaryButton(
               var1,
               wap.s(a.d("\ue8d0酖ᮓ藴า裗㋍묡╯꿖", 1612784797, -307770347), a.d("ⶃ吢\ude80䂏쬧䷯\uf7c6縹\ue40a檤\ued08ᜌ駚c訹ಿ", 267562617, -1650489397)),
               vhz.RESET,
               var14,
               var32,
               var15,
               var30,
               var34 ? 1.0F : 0.0F,
               0.0F
            );
            this.hsi.add(new hrk(var14, var32, var15, var30, () -> {
               var8.reset();
               this.hsr();
            }, null));
         }
      }
   }

   static int hte(pdr var0) {
      long var1 = MinecraftClient.getInstance().getWindow().getHandle();
      boolean var3 = GLFW.glfwGetKey(var1, 340) == 1 || GLFW.glfwGetKey(var1, 344) == 1;
      return var3 && var0.maxCount() > 16 ? 8 : 1;
   }

   static String htf(int var0) {
      int var1 = var0 / 20;
      return var1 / 60 + a.c(-421161944, "鐓") + String.format(Locale.ROOT, a.b("ⶫ吏\udede䃹", 1565732234), var1 % 60);
   }

   float htg(DrawContext var1, String var2, float var3, float var4, float var5) {
      irr.SECTION.draw(var1, var2.toUpperCase(Locale.ROOT), var3, irr.SECTION.centerTop(var4 + 6.0F), iov.textMuted);
      return var4 + 12.0F;
   }

   void hth(DrawContext var1, float var2, float var3, float var4, float var5, String var6, Runnable var7, Runnable var8) {
      float var9 = 12.0F;
      float var10 = 18.0F;
      float var11 = var4 - var9;
      float var12 = var11 - var10;
      float var13 = var12 - var9;
      float var14 = var5 + (14.0F - var9) * 0.5F;
      boolean var15 = irr.inside(var2, var3, var13, var14, var9, var9);
      boolean var16 = irr.inside(var2, var3, var11, var14, var9, var9);
      uut.round(var1, var13, var14, var9, var9, iov.r(3.0F), var15 ? iov.fieldHover : iov.card);
      uut.round(var1, var11, var14, var9, var9, iov.r(3.0F), var16 ? iov.fieldHover : iov.card);
      irr.VALUE
         .drawCentered(var1, a.d("퀙", -407300061, -39204842), var13 + var9 * 0.5F, irr.VALUE.centerTop(var14 + var9 * 0.5F), var15 ? iov.text : iov.textDim);
      vjf.draw(var1, vhz.PLUS, var11 + var9 * 0.5F, var14 + var9 * 0.5F, 6.0F, var16 ? iov.text : iov.textDim);
      irr.VALUE.drawCentered(var1, var6, var12 + var10 * 0.5F, irr.VALUE.centerTop(var14 + var9 * 0.5F), iov.text);
      this.hsi.add(new hrk(var13, var14, var9, var9, var7, null));
      this.hsi.add(new hrk(var11, var14, var9, var9, var8, null));
   }

   void hti(DrawContext var1) {
      float var2 = this.hsf + 336.0F - 8.0F - 5.0F;
      uut.rect(var1, this.hse + 12.0F, this.hsf + 336.0F - 16.0F - 8.0F, 446.0F, 1.0F, iov.divider);
      String var3 = this.hsn != null
         ? this.hsn
         : wap.s(
            a.c(
               -1334442806, "ӌ絒\uf784槿\ue220據ﺽ坸쥣䏓쐑㹵낪⤞ꍒ◰龿ჹ諝ಌ蔩｣燞\uea00汣\ue6e6弖텈䮺췡䙚룀ኻꭾⵢ\ua7d2ᡋ鈵ᓩ贗݁禰\uf3a5琔\uee54悲\ud961厣헗万쁻㪸덛㔁꿹↧騗㻴隵༷膇\ufbc7簡\uf673棯\ue11c孔\uddfc垳"
            ),
            a.d("쐉붙㝉ꤺ⛷聲ᨕ韹ফ荫һﻈ灡\ue9d7掇\ue574嬣퓲他점䇧㾉넿⫨ꢫɎ鯉ᆊ譵ഥ芍籓\uf613毰\uedda朚\ud8cc嚦큵䥓쎛뵪㝊냀⨖ꑨᶩ靌ᄈ諒Үﹰ嗵\uf196漍\ue124媘\ud85a刱", -1606027465, -85510369)
         );
      irr.SMALL.draw(var1, irr.SMALL.ellipsize(var3, 446.0F), this.hse + 12.0F, irr.SMALL.centerTop(var2), this.hsn != null ? iov.text : iov.textMuted);
   }

   @Override
   boolean mouseClicked(hlc var1, float var2, float var3, int var4) {
      if (this.hsl) {
         return true;
      }

      if (!irr.inside(var2, var3, this.hse, this.hsf, 470.0F, 336.0F)) {
         this.close();
         return true;
      }

      if (this.search.mouseClicked(var1, var2, var3, var4)) {
         return true;
      }

      var1.focus(null);

      for (int var5 = this.hsi.size() - 1; var5 >= 0; var5--) {
         hrk var6 = this.hsi.get(var5);
         if (irr.inside(var2, var3, var6.x(), var6.y(), var6.w(), var6.h())) {
            Runnable var7 = var4 == 1 ? var6.right() : (var4 == 0 ? var6.left() : null);
            if (var7 != null) {
               var7.run();
               return true;
            }
         }
      }

      return true;
   }

   @Override
   void scrolled(double var1) {
      this.hsk = Math.max(0.0F, Math.min(this.hsy(), this.hsk - (float)var1 * 30.0F * 2.0F));
   }

   @Override
   boolean keyPressed(hlc var1, int var2, int var3) {
      if (var2 != 256) {
         if (var1.focusedField() == this.search) {
            this.search.keyPressed(var1, var2, var3);
            return true;
         }

         if ((var3 & 2) != 0 && var2 == 70) {
            var1.focus(this.search);
         }

         return true;
      } else {
         if (var1.focusedField() == this.search && !this.search.text.isEmpty()) {
            this.search.setText("");
         } else {
            this.close();
         }

         return true;
      }
   }
}
