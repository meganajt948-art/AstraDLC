package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

public class kyn extends kfe {
   private final vmc kyo = this.add(new vmc(a.d("捆\u1ad4递\u0e63薵", -619412060, 1931273908), 5.0, 1.0, 10.0, 1.0));
   private final vmc kyp = this.add(new vmc(a.d("岳┡꿧㆖멀㲵蚵ཇ鄚ᮼ鱫星", -983236670, 925475630), 0.3, 0.0, 0.6, 0.05).percent());
   private final vmc kyq = this.add(new vmc(a.d("\ued80鐎Ở肷୳跉㞂빪", -411490779, -873804802), 0.35, 0.0, 0.8, 0.05).percent());
   private final vmc kyr = this.add(new vmc(a.c(1146289752, "︆螄ീ錷\u18fd鹆␗귫"), 0.5, 0.0, 1.0, 0.05).percent());
   private final vmc kys = this.add(new vmc(a.c(1509878106, "\ue91f邧ᩭ"), 90.0, 20.0, 180.0, 5.0).unit(a.b("튲", -1700343293)));
   private final vmc kyt = this.add(new vmc(a.b("\ue30f骓ၚ踬\u05ee荐㤎냹", -1452612797), 4.0, 2.0, 6.0, 0.1).suffix(a.d("뻆", -490704688, 1064291962)));
   private final vlv kyu = this.add(
      new vlv(
         a.c(2006925133, "㼁䚍챏制\ud9ff"),
         a.d("뿩왪䲽틝夕\udfa5旫", 1771780979, -1815575350),
         a.b("\ue194頗ዀ負ݨ臘㮖", -231808572),
         a.c(-1261425033, "⸢垷\udd7c䌐죑乷"),
         a.d("텼ꣴ∺뱝", 816797853, -1378711132),
         a.c(-30588880, "䁲㧬댨")
      )
   );
   private final vkl kyv = this.add(new vkl(a.c(-1265563731, "ߤ繺\uf4ac櫗\ue108柲\uddee吞쩃䃧"), false));
   private final vkl kyw = this.add(new vkl(a.d("쎜먑ハ꺦╭ꏋᦙ", 1618045485, 1203415526), true));
   private final vkl kyx = this.add(new vkl(a.c(-230131163, "穬Ͽ褡ᝁ"), false));
   private final vkl kyy = this.add(new vkl(a.d("䳳㕾뾷⇛ꨖⲵ雩ὐ腘\u0bff谡癐\uf898", -1799006606, -1119348008), false));
   private static final double kyz = 1.2;
   private static final double kza = 0.12;
   private static final double kzb = 0.08;
   private static final double kzc = 0.25;
   private static Field kzd;
   private static Field kze;
   private static Field kzf;
   private final Random kzg = new Random();
   private final lln kzh = new lln();
   private final tbm kzi = new tbm();
   private final tbm kzj = new tbm();
   private final double[] kzk = new double[2];
   private long kzl;
   private GLFWCursorPosCallback kzm;
   private GLFWCursorPosCallback kzn;
   private boolean kzo;
   private double kzp;
   private double kzq;
   private double kzr;
   private double kzs;
   private double kzt = Double.NaN;
   private double kzu = Double.NaN;
   private double kzv;
   private double kzw;
   private double kzx;
   private double kzy;
   private LivingEntity kzz;
   private boolean laa;
   private long lab;
   private LivingEntity lac;
   private long lad;
   private double lae;
   private double laf;
   private double lag;
   private double lah;
   private double lai;
   private double laj;
   private double lak;
   private double lal;
   private double lam;
   private double lan;
   private double lao;
   private double lap;
   private double laq;
   private double lar;
   private double las;
   private double lat;
   private double lau;
   private long lav;
   private double law = 0.016666666666666666;
   private boolean lax;
   private long lay;
   private double laz;
   private double lba;
   private double lbb;
   private double lbc;
   private double lbd;
   private double lbe;
   private double lbf;
   private double lbg;
   private boolean lbh;
   private double lbi;
   private double lbj;
   private double lbk;
   private double lbl;

   public kyn() {
      super(
         a.b("谬\uf5b4罥\ue11a櫐\uec54嘯\udfda", 1205963880),
         a.c(-213966631, "₩夵폯䶂왖䂴諭獙\ued1c枪\ue02bᨕ铚൲蝯Ǔ뮞㑕껠⢧ꄏ\udb44喱칧䠊시签\uf538澝\ue998戰鲮ᚵ轘आ菲㱱똕フꥱ⌬巌\ud7c7偺쫾䒓﵉矪\uf1b4橲\ue453ọ靻ᅤ诞֒"),
         kfa.COMBAT
      );
   }

   @Override
   protected void onEnable() {
      lck var1 = lca();
      if (var1 != null && var1.isEnabled()) {
         var1.setEnabled(false);
      }
   }

   @Override
   protected void onDisable() {
      this.lcc();
      this.kzz = null;
      this.laa = false;
      this.lbp();
      this.kzh.reset();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (var2 != null && var1.field_1687 != null) {
         this.lbx(var1);
         this.laa = this.lby(var1, var2);
         this.kzz = this.laa ? this.lbt(var1, var2) : null;
      } else {
         this.kzz = null;
         this.laa = false;
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      lck var2 = lca();
      if (var2 != null && var2.isEnabled()) {
         this.setEnabled(false);
      } else {
         if ((this.kzn == null || !this.kzo) && var1.method_22683() != null) {
            this.lcb(var1.method_22683().method_4490());
         }

         long var3 = System.nanoTime();
         double var5 = this.lav == 0L ? 0.016666666666666666 : Math.min(0.1, (var3 - this.lav) / 1.0E9);
         this.lav = var3;
         this.law = this.law + (Math.min(0.05, var5) - this.law) * 0.2;
         ClientPlayerEntity var7 = var1.field_1724;
         boolean var8 = var7 != null && var1.field_1755 == null && var1.field_1729.method_1613();
         LivingEntity var9 = var8 && this.laa ? this.kzz : null;
         if (var9 != null && var9 != this.lac) {
            this.lbo(var9, var3);
         }

         boolean var10 = var9 != null && var9 == this.lac;
         this.lae = var10 ? Math.min(1.0, this.lae + var5 / this.laf) : Math.max(0.0, this.lae - var5 / 0.12);
         if (this.lac != null && (!var10 && this.lae <= 0.0 || this.lac.method_31481() || !this.lac.method_5805())) {
            this.lbp();
         }

         if (this.lac != null && var7 != null) {
            this.lbq(var1, var7, var3, var5);
         } else {
            this.lax = false;
            this.lbg = 0.0;
         }
      }
   }

   private void lbo(LivingEntity var1, long var2) {
      this.lac = var1;
      this.lad = var2;
      this.lae = 0.0;
      this.laf = 0.18 + this.kzg.nextDouble() * 0.22;
      this.lag = 0.35 + this.kzg.nextDouble() * 0.2;
      this.lah = this.kzg.nextDouble() * 2.0 - 1.0;
      this.lai = 0.45 + this.kzg.nextDouble() * 0.45;
      this.laj = 1.1 + this.kzg.nextDouble() * 0.6;
      this.lak = this.kzg.nextDouble() * Math.PI * 2.0;
      this.lal = this.kzg.nextDouble() * Math.PI * 2.0;
      double[] var4 = this.lbs();
      this.lam = this.lao = this.laq = var4[0];
      this.lan = this.lap = this.lar = var4[1];
      this.las = this.lat = 0.0;
      this.lau = 0.4 + this.kzg.nextDouble() * 0.9;
      this.lbh = false;
      this.lbk = this.lbl = 0.0;
   }

   private void lbp() {
      this.lac = null;
      this.lae = 0.0;
      this.lax = false;
      this.lbh = false;
      this.lbg = 0.0;
      this.lbk = this.lbl = 0.0;
   }

   private void lbq(MinecraftClient var1, ClientPlayerEntity var2, long var3, double var5) {
      double var7 = (var3 - this.lad) / 1.0E9;
      this.lbr(var7);
      float var9 = var1.method_61966().method_60637(true);
      Vec3d var10 = var2.method_5836(var9);
      Vec3d var11 = this.lac.method_30950(var9);
      double var12 = this.lac.method_17681() * 0.5;
      double var14 = this.lac.method_17682();
      if (tbp.aim(
            var10.field_1352,
            var10.field_1351,
            var10.field_1350,
            var11.field_1352,
            var11.field_1351,
            var11.field_1350,
            var12,
            var14,
            this.lam,
            this.lan,
            this.kzi
         )
         && tbp.aim(
            var10.field_1352, var10.field_1351, var10.field_1350, var11.field_1352, var11.field_1351, var11.field_1350, var12, var14, 0.0, 0.5, this.kzj
         )) {
         if (this.lbh && var5 > 1.0E-4) {
            double var16 = tbp.wrap(this.kzj.yaw - this.lbi) / var5;
            double var18 = (this.kzj.pitch - this.lbj) / var5;
            double var20 = 1.0 - Math.exp(-var5 / 0.08);
            this.lbk = this.lbk + (var16 - this.lbk) * var20;
            this.lbl = this.lbl + (var18 - this.lbl) * var20;
         }

         this.lbi = this.kzj.yaw;
         this.lbj = this.kzj.pitch;
         this.lbh = true;
         this.laz = this.kzi.yaw;
         this.lba = this.kzi.pitch;
         this.lbb = this.kzi.la;
         this.lbc = this.kzi.ra;
         this.lbd = this.kzi.ta;
         this.lbe = this.kzi.ba;
         this.lay = var3;
         this.lbf = Math.max(1.0, 0.6 * this.kzi.bw);
         this.lax = true;
         double var28 = this.kys.get() * 0.5;
         double var29 = Math.hypot(tbp.wrap(this.kzi.yaw - var2.method_36454()), this.kzi.pitch - var2.method_36455());
         double var30 = 1.0 - lci(var28 * 0.75, var28 * 1.2, var29);
         double var22 = 0.5 * (Math.sin((Math.PI * 2) * this.lai * var7 + this.lak) + Math.sin((Math.PI * 2) * this.laj * var7 + this.lal));
         double var24 = lcj(1.0 + this.kyp.get() * (this.lah + 0.6 * var22), 0.2, 2.0);
         double var26 = this.kyv.get() ? 1.0 - lci(0.45, 0.8, (System.currentTimeMillis() - this.lab) / 1000.0) : 1.0;
         this.lbg = lci(0.0, 1.0, this.lae) * var24 * var30 * var26;
         this.kzh.pull = 0.1 * this.kyo.get();
         this.kzh.slow = this.kyq.get();
         this.kzh.vertical = this.kyr.get();
      } else {
         this.lax = false;
         this.lbh = false;
         this.lbg = 0.0;
      }
   }

   private void lbr(double var1) {
      if (var1 < this.lat) {
         double var5 = lci(this.las, this.lat, var1);
         this.lam = this.lao + (this.laq - this.lao) * var5;
         this.lan = this.lap + (this.lar - this.lap) * var5;
      } else {
         this.lam = this.laq;
         this.lan = this.lar;
         if (var1 >= this.lau) {
            double[] var3 = this.lbs();
            this.lao = this.lam;
            this.lap = this.lan;
            this.laq = var3[0];
            this.lar = var3[1];
            this.las = var1;
            this.lat = var1 + 0.25 + this.kzg.nextDouble() * 0.3;
            this.lau = this.lat + 0.5 + this.kzg.nextDouble() * 0.9;
         }
      }
   }

   private double[] lbs() {
      double var1 = lcj(this.kzg.nextGaussian() * 0.18, -0.35, 0.35);
      double var3 = 0.55 + this.kzg.nextDouble() * 0.3;
      return new double[]{var1, var3};
   }

   private LivingEntity lbt(MinecraftClient var1, ClientPlayerEntity var2) {
      Vec3d var3 = var2.method_33571();
      double var4 = this.kyt.get();
      double var6 = this.kys.get() * 0.5;
      if (this.kzz != null && this.lbu(var2, this.kzz) && lbv(var3, this.kzz, var4) && lbw(var2, var3, this.kzz) <= var6 * 1.2) {
         return this.kzz;
      } else {
         LivingEntity var8 = null;
         double var9 = Double.MAX_VALUE;

         for (Entity var12 : var1.field_1687.method_8335(var2, var2.method_5829().method_1014(var4 + 1.0))) {
            if (var12 instanceof LivingEntity var13 && this.lbu(var2, var13) && lbv(var3, var13, var4)) {
               double var14 = lbw(var2, var3, var13);
               if (var14 <= var6 && var14 < var9) {
                  var9 = var14;
                  var8 = var13;
               }
            }
         }

         return var8;
      }
   }

   private boolean lbu(ClientPlayerEntity var1, LivingEntity var2) {
      if (var2 != var1 && !var2.method_31481() && var2.method_5805() && var2.method_5732() && !(var2 instanceof ArmorStandEntity)) {
         if (var2 instanceof PlayerEntity var3) {
            if (!this.kyw.get() || var3.method_7325() || hhf.protects(var3)) {
               return false;
            }
         } else if (!this.kyx.get() || !(var2 instanceof Monster)) {
            return false;
         }

         return this.kyy.get() || var1.method_6057(var2);
      } else {
         return false;
      }
   }

   private static boolean lbv(Vec3d var0, Entity var1, double var2) {
      return var1.method_5829().method_49271(var0) <= var2 * var2;
   }

   private static double lbw(ClientPlayerEntity var0, Vec3d var1, Entity var2) {
      Vec3d var3 = var2.method_5829().method_1005();
      double var4 = var3.field_1352 - var1.field_1352;
      double var6 = var3.field_1350 - var1.field_1350;
      double var8 = tbp.yawTo(var4, var6);
      double var10 = tbp.pitchTo(var3.field_1351 - var1.field_1351, Math.sqrt(var4 * var4 + var6 * var6));
      return Math.hypot(tbp.wrap(var8 - var0.method_36454()), var10 - var0.method_36455());
   }

   private void lbx(MinecraftClient var1) {
      boolean var2 = var1.field_1690.field_1886.method_1434()
         || var1.field_1755 == null && var1.method_22683() != null && GLFW.glfwGetMouseButton(var1.method_22683().method_4490(), 0) == 1;
      if (var2) {
         this.lab = System.currentTimeMillis();
      }
   }

   private boolean lby(MinecraftClient var1, ClientPlayerEntity var2) {
      if (var1.field_1755 != null || !var1.method_1569() || !var1.field_1729.method_1613() || !var2.method_5805() || var2.method_7325() || var2.method_6115()) {
         return false;
      } else if (!var1.field_1690.method_31044().method_31034() || var1.field_1690.field_1914) {
         return false;
      } else if (var1.field_1761 != null && var1.field_1761.method_2923()) {
         return false;
      } else {
         return !ovh.active() && !kmy.busy() && !nfl.busy() && tcz.mode() != tcw.RECORD && !lqq.busy() ? this.lbz(var2.method_6047()) : false;
      }
   }

   private boolean lbz(ItemStack var1) {
      String var2 = this.kyu.get();

      return switch (var2) {
         case a.b("㙺俤씠", 1158100536) -> true;
         case a.d("\ud91fꂊ⩁됭㿬륊", -1613187249, 961179141) -> var1.method_31573(ItemTags.field_42611);
         case a.c(1324087958, "䀘荛ক韲") -> var1.method_31573(ItemTags.field_42612);
         default -> var1.method_31573(ItemTags.field_42611)
            || var1.method_31573(ItemTags.field_42612)
            || var1.method_7909() instanceof MaceItem
            || var1.method_7909() instanceof TridentItem;
      };
   }

   private static lck lca() {
      Flow var0 = Flow.getInstance();
      return var0 != null && var0.getModuleManager() != null ? var0.getModuleManager().get(lck.class) : null;
   }

   private void lcb(long var1) {
      if (kzd == null || kze == null || kzf == null) {
         kzd = vxr.find(
            Mouse.class,
            a.b("\udc61ꗛ⼙넲㪦밓ه辽ᇤ魄ᲄ\ue6f2样\uf1dc篂ﴼ䝾좽刎푳巨➻ꤋ", -408888296),
            a.d("鱷\ue5c9漖\uf16e窱ﰻ䘆쿱冡\udb11", -810158300, 1663658815),
            a.b("\udc48", 1025170445)
         );
         kze = vxr.find(Mouse.class, a.c(678554466, "\ueb1b銡ᡣ虈ො譩ㄽ룇⚞갾⯾톈彍욦䲸쩆瀄ￇ整\ue309檒Ⴡ鹱"), a.b("뷮쑐亏탷嬨\udda2枟\uee68瀸惘", 208256386), a.c(1789913297, "\ue894"));
         kzf = vxr.find(Mouse.class, a.b("狚ୠ膢ᾉ鐝ከ꣼℆뽟㗿눿䡉욌彧핹厇\ue9c5昆ﲵ竈\uf353褀ް", 597258915), a.d("쉞믠ㄿ꽇⒘ꈒᠪ釘ྈ蔵ˠ", -1854674423, -156686278), a.b("䀉", -1410580404));
      }

      if (kzd != null && kze != null && kzf != null) {
         this.kzp = this.kzq = this.kzr = this.kzs = 0.0;
         this.kzt = Double.NaN;
         this.kzu = Double.NaN;
         this.kzv = this.kzw = this.kzx = this.kzy = 0.0;
         this.kzh.reset();
         if (this.kzn == null) {
            this.kzl = var1;
            this.kzn = GLFWCursorPosCallback.create(this::lcd);
            this.kzm = GLFW.glfwSetCursorPosCallback(var1, this.kzn);
         }

         this.kzo = true;
      }
   }

   private void lcc() {
      this.kzo = false;
      if (this.kzn != null) {
         GLFWCursorPosCallback var1 = GLFW.glfwSetCursorPosCallback(this.kzl, this.kzm);
         if (var1 != null && var1.address() == this.kzn.address()) {
            this.kzn.free();
            this.kzn = null;
            this.kzm = null;
         } else {
            GLFW.glfwSetCursorPosCallback(this.kzl, var1);
         }
      }
   }

   private void lcd(long var1, double var3, double var5) {
      if (this.kzm != null) {
         this.kzm.invoke(var1, var3, var5);
      }

      if (this.kzo) {
         MinecraftClient.method_1551().execute(this::lce);
      }
   }

   private void lce() {
      if (this.kzo && kzd != null) {
         MinecraftClient var1 = MinecraftClient.method_1551();

         try {
            double var2 = kzd.getDouble(var1.field_1729);
            double var4 = kze.getDouble(var1.field_1729);
            double var6 = kzf.getDouble(var1.field_1729);
            if (var6 != this.kzt) {
               double var8 = Double.isNaN(this.kzu) ? 1.0 : var6 - this.kzu;
               this.kzh.frame(var8);
               boolean var10 = var8 < 0.25;
               this.kzv = var10 ? this.kzx : 0.0;
               this.kzw = var10 ? this.kzy : 0.0;
               this.kzx = this.kzy = 0.0;
               this.kzt = var6;
               this.kzu = var6;
               this.kzp = var2;
               this.kzq = var4;
            } else {
               this.kzp = this.kzp + (var2 - this.kzr);
               this.kzq = this.kzq + (var4 - this.kzs);
            }

            this.lcf(var1);
            this.kzr = this.kzp + this.kzk[0];
            this.kzs = this.kzq + this.kzk[1];
            kzd.setDouble(var1.field_1729, this.kzr);
            kze.setDouble(var1.field_1729, this.kzs);
         } catch (IllegalAccessException var11) {
            kzd = null;
            this.kzo = false;
         }
      }
   }

   private void lcf(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      if (var2 != null && (this.kzp != 0.0 || this.kzq != 0.0)) {
         double var3 = lch(var1, var2);
         double var5 = var1.field_1690.method_72706().method_41753() ? -1.0 : 1.0;
         double var7 = var1.field_1690.method_42438().method_41753() ? -1.0 : 1.0;
         double var9 = this.kzp * var3 * var5;
         double var11 = this.kzq * var3 * var7;
         boolean var13 = this.isEnabled()
            && this.lax
            && this.lbg > 0.0
            && var1.field_1755 == null
            && var1.field_1729.method_1613()
            && !var1.field_1690.field_1914;
         if (!var13) {
            this.kzh.extra(var9, var11, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, this.kzk);
            this.kzx = this.kzy = 0.0;
            this.kzk[0] = this.kzk[1] = 0.0;
         } else {
            double var14 = lcj((System.nanoTime() - this.lay) / 1.0E9, 0.0, 0.05);
            double var16 = this.laz + this.lbk * var14;
            double var18 = this.lba + this.lbl * var14;
            double var20 = tbp.wrap(var16 - var2.method_36454());
            double var22 = var18 - var2.method_36455();
            double var24 = lcg(var20 + this.lbb * this.lag, var20 + this.lbc * this.lag);
            double var26 = lcg(var22 + this.lbd * this.lag, var22 + this.lbe * this.lag);
            this.kzh.extra(var9, var11, var24, var26, this.lbk * this.law, this.lbl * this.law, this.lbf, this.lbg, this.kzk);
            double var28 = this.kzk[0] / var3 * var5 + this.kzv;
            double var30 = this.kzk[1] / var3 * var7 + this.kzw;
            double var32 = Math.rint(var28);
            double var34 = Math.rint(var30);
            this.kzx = var28 - var32;
            this.kzy = var30 - var34;
            this.kzk[0] = var32;
            this.kzk[1] = var34;
         }
      } else {
         this.kzk[0] = this.kzk[1] = 0.0;
      }
   }

   private static double lcg(double var0, double var2) {
      return var0 > 0.0 ? var0 : (var2 < 0.0 ? var2 : 0.0);
   }

   private static double lch(MinecraftClient var0, ClientPlayerEntity var1) {
      double var2 = (Double)var0.field_1690.method_42495().method_41753() * 0.6F + 0.2F;
      double var4 = var2 * var2 * var2;
      boolean var6 = var0.field_1690.method_31044().method_31034() && var1.method_31550();
      return (var6 ? var4 : var4 * 8.0) * 0.15;
   }

   private static double lci(double var0, double var2, double var4) {
      double var6 = lcj((var4 - var0) / (var2 - var0), 0.0, 1.0);
      return var6 * var6 * (3.0 - 2.0 * var6);
   }

   private static double lcj(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }
}
