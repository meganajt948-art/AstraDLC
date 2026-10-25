package a;

import flow.config.ConfigManager;
import flow.dev.a;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class kwf extends kfe {
   final vlv kwg = this.add(
      new vlv(
         a.c(233082365, "趧\uf42b绣\ue087歅\uede9垼\ude4c"),
         a.b("ᗱ決\ue6ac磔\uf308疣", -1076030044),
         a.d("켬뚧㱱ꈉ⧕꽾", -1684065766, -1101071005),
         a.b("먛쎅䥓휮峲\uda59", -268846498)
      )
   );
   final vlv kwh = this.add(
      new vlv(a.b("\uf02a観ͤ", 1299902568), a.b("韜\uee46撅\ufaf3焷\uf78b", 1119721364), a.c(459830664, "痀ౚ蚙ᣯ錫ᖗ"), a.b("鋻\ueb71憫\uffc9琈", 1293259437))
   );
   final vlv kwi = this.add(
      new vlv(
         a.c(215903861, "渷ឭ鵮̘補\u0e60둿㷃ꎞ⤤껶咎"),
         a.b("㋊䭙솗忯퐷劃\ue8d9慭Ｃ", 1659122323),
         a.d("\ue153飀ሎ豶ޮ脚㭀담Ⲻ", -1335107776, 1625505354),
         a.c(-1785420293, "ꖮ\udc38囪좊䍐엧")
      )
   );
   final vmu kwj = this.add(new vmu(a.d("籴ױ輥ᅇ髑ᰰꙡ⾍뇛㭥벳䛋", -2120129952, -1019732391), "", 32));
   final vmc kwk = this.add(new vmc(a.d("㋆䭔솒忣퐵", 2046298678, 1360869542), 1.0, 0.3, 1.6, 0.05).percent());
   final vmc kwl = this.add(new vmc(a.c(500444174, "ⱐ嗒\udf16䅡쪫䰐\uf641羽"), 1.0, 0.0, 1.0, 0.05).percent());
   final vlv kwm = this.add(
      new vlv(
         a.c(305277693, "⪶匯\ud9f8䟄챛䫧\uf0b8祇\ue717涺"), a.d("ǿ硬\uf2b4泄\ue71a", -249325704, -627665201), a.b("\ud944ꃗ⨏둿㾡", -33892084), a.b("志♐겅㋳뤿㾌", -210083950)
      )
   );
   final vmc kwn = this.add(new vmc(a.c(-1727678203, "륆샚䨅푺徢\ud90f挈\ueabf瓴﹘禉"), 0.45, 0.0, 1.0, 0.05).percent());
   final vmc kwo = this.add(new vmc(a.c(1334337753, "悘ᤄ鏛ඤ虼Ñ뫖㍳괷"), 0.85, 0.0, 1.0, 0.05).percent());
   final vmc kwp = this.add(new vmc(a.c(1927083304, "\uf56d賕؟"), 360.0, 10.0, 360.0, 5.0).unit(a.d("㉵", -850838333, 1147276807)));
   final vmc kwq = this.add(new vmc(a.b("諮\uf372离\ue7cd氏\ueab1僯\ud918", 1612090018), 4.0, 2.0, 6.0, 0.1).suffix(a.c(1180195030, "墺")));
   final vlv kwr = this.add(
      new vlv(
         a.c(281209406, "\uea72鏾\u193c蝅ಌ"),
         a.b("㟩乪쒽嫝턕垥\uedeb", -2091567175),
         a.c(-1601781311, "솑렒㋅겥❭ꇝᮓ"),
         a.d("㙡俴씿孓킒嘴", 1773748394, 1249605278),
         a.b("ﻚ蝒ග鏻", -218825057),
         a.d("帮➰굴", -1237545396, -409087968)
      )
   );
   final vlv kws = this.add(
      new vlv(
         a.d("ﯞ艍ࢅ雲ᴸ鮒⇜ꠠ", -1153097373, 535026405),
         a.d("悺ᤤ鏾\u0d84虚", 1523545751, 485758569),
         a.b("骢\ue33c槦\uf79c籂", -755524890),
         a.c(1021864061, "栱ᆭ魤Ԓ軐\u086e눰㯇"),
         a.d("ቒ毎\ue119罥\uf4aa爇", 640434405, 1461408505)
      )
   );
   final vkl kwt = this.add(new vkl(a.d("\u0ff1癱ﲹ拕\ue905", -887580280, -1212246465), true));
   final vkl kwu = this.add(new vkl(a.b("ٹ翪\uf520歂\ue0d0昧\udc7b喛", 2056652348), true));
   final vkl kwv = this.add(new vkl(a.b("셂룄㈆걶➦ꄋᬖ銱ೱ虌ƍ", -1719287525), false));
   final vkl kww = this.add(new vkl(a.b("ᅭ棠\ue23e籗\uf79c焺쭨", -377941702), true));
   final vkl kwx = this.add(new vkl(a.b("艉ﯚ焄\uef64", -1355120128), false));
   final vkl kwy = this.add(new vkl(a.b("憇᠊鋃ಯ蝢ǁ뮝㈤갬⚋ꅕ嬤헬", -443981346), false));
   static final double kwz = 1.2;
   static final int kxa = 2;
   static final double kxb = Math.sin(Math.toRadians(22.5));
   static final int kxc = 8;
   static final int kxd = 2;
   final Random kxe = new Random();
   static kwf kxf;
   final lng kxg = new lng();
   final kjq kxh = kjq.embedded(this::kyg);
   final ljx kxi = new ljx();
   final lkh kxj = new lkh(this.kxi);
   Entity kxk;
   Vec3d kxl;
   double kxm;
   boolean kxn;
   boolean kxo;
   boolean kxp;
   ClientPlayerEntity kxq;
   tiq kxr;
   String kxs = "";
   tck kxt;
   long kxu;
   int kxv = 2;

   public kwf() {
      super(
         a.c(1203908670, "ぽ䧮쌸嵉횳倶\uea62掀"),
         a.d("ං琜ﻁ悿\ueb74淂ퟂ幧쀤䪘촎㜱맭⁘ꨘ⳾隧ᥱ莖֓豱\uf633碕\ue346攨\uefad噉\ud806䋬쒡佚뇟㮌ꉰ⑦꺙ᅅ鬤ᷰ葒\u0e00炽謁紐\ue7dc榸큾嫒\udc9b䝋", -355053796, -30260502),
         kfa.COMBAT
      );
      kxf = this;
      this.kwu.visibleWhen(() -> this.kwg.is(a.d("䙾㿵딣⭛ꂇ☬", -1237692396, 656414271)));
      this.kwv.visibleWhen(() -> this.kwg.is(a.c(-1390044569, "騢\ue3bc楪\uf717糋褐")));
      this.kwi.visibleWhen(() -> this.kwh.is(a.b("뉫쯱䄲\udf44咀툼", -1843023325)));
      this.kwk.visibleWhen(() -> this.kwh.is(a.d("ꊤ\udb3e函쾋䑏싳", 601377720, 387246420)) && !this.kwi.is(a.c(514856085, "ᓀ浖\ue784秤\uf23e璉")));
      this.kwl.visibleWhen(() -> this.kwh.is(a.b("ꚫ\udf31嗲쮄䁀웼", 1431676643)) && !this.kwi.is(a.d("滬\u177a鶨ψ蠒ລ", -308974915, -1883110396)));
      this.kwm.visibleWhen(() -> this.kwh.is(a.d("혷꾭╮묘ボ뙠", 73124402, -1654514611)) && !this.kwi.is(a.b("ᘕ澃\ue551笱\uf0eb癜", -1866983872)));
      this.kwn
         .visibleWhen(() -> this.kwh.is(a.b("勲⭨ꆫ㿝됙㊥", 857559738)) && !this.kwi.is(a.c(-578622383, "\uec04閒ὀ脠ૺ豍")) && this.kwm.is(a.c(924850186, "ᡏ懈\ueb1d畫ﺧ研")));
      this.kwo
         .visibleWhen(
            () -> this.kwh.is(a.d("뒑촋䟈\ud9be剺퓆", -546480833, 189327846))
               && !this.kwi.is(a.c(1822190145, "樔ᎂ饐ܰ質\u0a5d"))
               && this.kwm.is(a.b("찂떅㽐ꄦ⫪걙", -402994105))
         );
      this.kwj.visibleWhen(() -> false);
   }

   public static tiq studioProfile() {
      kwf var0 = kxf;
      if (var0 == null) {
         return null;
      }

      String var1 = var0.kwj.get();
      if (var1 != null && !var1.isBlank()) {
         if (var0.kxr == null || !var1.equals(var0.kxs)) {
            var0.kxs = var1;
            var0.kxr = tiq.open(var1);
         }

         return var0.kxr;
      } else {
         var0.kxr = null;
         var0.kxs = "";
         return null;
      }
   }

   public static boolean usesStudio(tiq var0) {
      kwf var1 = kxf;
      return var1 != null && var0 != null && var1.kwi.is(a.c(-1515519047, "Ϭ空\uf0a8滈\ue512接")) && studioProfile() == var0;
   }

   public static void useStudio(tiq var0) {
      kwf var1 = kxf;
      if (var1 != null) {
         var1.kwj.set(var0 == null ? "" : var0.name);
         var1.kxr = var0;
         var1.kxs = var0 == null ? "" : var0.name;
         var1.kwi.set(var0 == null ? a.d("蓸ﵫ瞥\ue9dd戅\ue4b1廫흟䤑", 738863724, 2079502029) : a.d("\ue1e9顿ክ賍ܗ膠", -302855574, 1240083414));
         var1.kxu = 0L;
         ConfigManager.autoSaveLater();
      }
   }

   tck kxy() {
      if (!this.kwi.is(a.c(1647453411, "Ⓐ崠ퟲ䦒쉈䓿"))) {
         return tck.profile1();
      }

      long var1 = System.currentTimeMillis();
      if (var1 - this.kxu > 1000L) {
         this.kxu = var1;
         tiq var3 = studioProfile();
         this.kxt = var3 == null ? null : var3.auraModel();
      }

      return this.kxt != null ? this.kxt : tck.profile1();
   }

   public static Entity target() {
      return kxf != null && kxf.isEnabled() ? kxf.kxg.target() : null;
   }

   public static String debug() {
      if (kxf == null) {
         return a.b("麼\ue704淗", -178938160);
      }

      ClientPlayerEntity var0 = MinecraftClient.getInstance().player;
      return String.format(
         Locale.ROOT,
         a.d("\ued0a钲ṡ者\u0bc4赤㝾뺗\u209eꩼⷩ힗奎샰䪿챓瘛遼挪\ue563泂ᛀ頺Ϧ薑ཉ뚢㣫ꉊ⑈꾭兣\udb20䋃쓚乳\uf1af篁﵅撽\ueee8递ᩞ鶸ܩ褋ッ멻㰧\ua7e0⦬팃嫢\udc9d䘓저玲\uf578缤\ue68b桪ሕ", -728323603, 1423393974),
         kxf.kxg.debugOffsets(),
         kxf.kxo,
         kxf.kxg.idle(),
         var0 == null ? 0.0 : kxf.kxg.serverYaw(var0),
         var0 == null ? 0.0 : kxf.kxg.serverPitch(var0),
         kxf.kxj.debug(),
         kxf.kxh.trace()
      );
   }

   public static boolean returning() {
      return kxf != null && kxf.kxp;
   }

   @Override
   public boolean ticksWhenOff() {
      return this.kxp;
   }

   @Override
   protected void onEnable() {
      if (!this.kxp) {
         this.kxg.reset();
      }

      this.kxp = false;
      this.kxq = null;
      this.kxo = false;
      this.kxj.enabled();
      this.kxh.onEnable();
   }

   @Override
   protected void onDisable() {
      this.kxh.onDisable();
      this.kxo = false;
      ClientPlayerEntity var1 = this.mc.player;
      if (this.kwg.is(a.c(1014196903, "櫲፹馯ߗ谋ઠ")) && var1 != null && var1.isAlive() && !this.kxg.idle()) {
         this.kxg.hit(2 + this.kxe.nextInt(3));
         this.kxp = true;
         this.kxq = var1;
      } else {
         this.kxg.end(var1);
         this.kye(this.mc);
         this.kxg.reset();
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (!this.isEnabled()) {
         if (this.kxp && var2 == this.kxq) {
            this.kxg.begin(var2);
            if (this.kwu.get() && !this.kxg.idle() && var1.currentScreen == null) {
               this.kyd(var1, var2);
            }
         }
      } else {
         boolean var3 = this.kwg.is(a.d("澿ᘴ鳢ʚ襆\u0fed", -717577097, -817247331));
         this.kxg.mode(var3, var2);
         this.kxg.begin(var2);
         if (var3 && this.kwu.get() && !this.kxg.idle() && var1.currentScreen == null) {
            this.kyd(var1, var2);
         }

         if (this.kyl(var1, var2) && this.kym(var2.getMainHandStack()) && !lgc.moduleOn()) {
            this.kxh.crits(this.kwt.get());
            this.kxh.onStartTick(var1);
         }
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      this.kxg.end(var2);
      this.kxg.newTick(var2);
      this.kye(var1);
      tck var3 = this.kxy();
      boolean var4 = var3 != tck.profile1();
      this.kxg.use(var3, var4 ? 1.0 : this.kwk.get());
      this.kxg.vertical(var4 ? 1.0 : this.kwl.get());
      if (!var4 && this.kwm.is(a.b("㐌䶋읞夨틤呗", -563661751))) {
         this.kxg.height(this.kwn.get(), this.kwo.get());
      } else {
         this.kxg.height(Double.NaN, Double.NaN);
      }

      this.kxg.verticalAware(false);
      this.kxg.stepCap(var4 && var3.turnCap > 0.0F ? var3.turnCap : this.kxg.maxTurn());
      this.kxv = var4 ? -1 : 2;
      if (!this.isEnabled()) {
         this.kyb(var1, var2);
      } else {
         this.kxh.onEndTick(var1);
         Entity var5 = this.kyl(var1, var2) && this.kym(var2.getMainHandStack()) ? this.kyf(var1, var2) : null;
         if (var5 == null) {
            this.kxj.targetNull();
            this.kxi.target = null;
            this.kxk = null;
            this.kxl = null;
            if (this.kxo && var2.isAlive()) {
               this.kxg.hit(8 + this.kxe.nextInt(5));
            }

            this.kxo = false;
            this.kyc(var1, var2);
         } else {
            this.kxo = true;
            if (this.kwh.is(a.d("㊙䬓쇉徫푪", 648642937, 2018161590))) {
               this.kxz(var1, var2, var5);
            } else {
               this.kxg.track(var1, var2, var5, this.kxv);
            }
         }
      }
   }

   void kxz(MinecraftClient var1, ClientPlayerEntity var2, Entity var3) {
      float var4 = this.kxg.serverYaw(var2);
      float var5 = this.kxg.serverPitch(var2);
      Box var6 = var3.getBoundingBox();
      Vec3d var7 = var2.getEyePos();
      Vec3d var8 = var6.getCenter();
      double var9 = var8.x - var7.x;
      double var11 = var8.y - var7.y;
      double var13 = var8.z - var7.z;
      this.kxi.target = var3;
      this.kxi.box = var6;
      this.kxi.yawToTarget = (float)(Math.toDegrees(Math.atan2(var13, var9)) - 90.0);
      this.kxi.pitchToTarget = (float)(-Math.toDegrees(Math.atan2(var11, Math.hypot(var9, var13))));
      this.kxi.strikeIn = this.kxh.strikeIn(var1, var2, var3, this.kwt.get());
      this.kxi.attackReady = this.kxi.strikeIn == 0;
      this.kya(var3, var7, var8);
      if (this.kxj.rotate(var4, var5)) {
         this.kxg.turnBy(var1, var2, var3, this.kxj.yaw() - var4, this.kxj.pitch() - var5);
      }
   }

   void kya(Entity var1, Vec3d var2, Vec3d var3) {
      Vec3d var4 = var1.getEntityPos();
      Vec3d var5 = var1 == this.kxk && this.kxl != null ? var4.subtract(this.kxl) : Vec3d.ZERO;
      if (var5.lengthSquared() > 1.0) {
         var5 = Vec3d.ZERO;
      }

      if (var1 != this.kxk || var1.isOnGround()) {
         this.kxm = var4.y;
      }

      this.kxk = var1;
      this.kxl = var4;
      double var6 = var3.x;
      double var8 = var3.y;
      double var10 = var3.z;
      double var12 = var1.isOnGround() ? 0.0 : var5.y;
      double var14 = var3.y - (var4.y - this.kxm);

      for (int var16 = 0; var16 < 16; var16++) {
         this.kxi.eyeAt[var16] = var2.add(this.kxh.selfOffset(var16));
         this.kxi.targetAt[var16] = new Vec3d(var6, var8, var10);
         var6 += var5.x;
         var10 += var5.z;
         if (var12 != 0.0 || var8 > var14) {
            var8 += var12;
            var12 = (var12 - 0.08) * 0.98;
            if (var8 < var14) {
               var8 = var14;
               var12 = 0.0;
            }
         }
      }
   }

   void kyb(MinecraftClient var1, ClientPlayerEntity var2) {
      if (var2 != this.kxq || var2 == null || !var2.isAlive() || !this.kwg.is(a.b("ꢙ턒寄얼习죋", 1240377548)) || this.kxg.home(var1, var2)) {
         this.kxg.reset();
         this.kxp = false;
         this.kxq = null;
      }
   }

   void kyc(MinecraftClient var1, ClientPlayerEntity var2) {
      if (!var2.isAlive()) {
         this.kxg.forget();
      } else if (!this.kwv.get() && !this.kwg.is(a.b("ᛎ潅\ue593篫\uf037皜", -1848633701))) {
         this.kxg.release();
      } else {
         this.kxg.home(var1, var2);
      }
   }

   void kyd(MinecraftClient var1, ClientPlayerEntity var2) {
      GameOptions var3 = var1.options;
      double var4 = (vzz.isPhysicallyDown(var1, var3.forwardKey) ? 1 : 0) - (vzz.isPhysicallyDown(var1, var3.backKey) ? 1 : 0);
      double var6 = (vzz.isPhysicallyDown(var1, var3.leftKey) ? 1 : 0) - (vzz.isPhysicallyDown(var1, var3.rightKey) ? 1 : 0);
      if (var4 != 0.0 || var6 != 0.0) {
         double var8 = Math.toRadians(this.kxg.cameraYaw(var2));
         double var10 = var6 * Math.cos(var8) - var4 * Math.sin(var8);
         double var12 = var4 * Math.cos(var8) + var6 * Math.sin(var8);
         double var14 = Math.hypot(var10, var12);
         double var16 = Math.toRadians(var2.getYaw());
         double var18 = (var12 * Math.cos(var16) - var10 * Math.sin(var16)) / var14;
         double var20 = (var10 * Math.cos(var16) + var12 * Math.sin(var16)) / var14;
         var3.forwardKey.setPressed(var18 > kxb);
         var3.backKey.setPressed(var18 < -kxb);
         var3.leftKey.setPressed(var20 > kxb);
         var3.rightKey.setPressed(var20 < -kxb);
         this.kxn = true;
      }
   }

   void kye(MinecraftClient var1) {
      if (this.kxn && var1.options != null) {
         this.kxn = false;

         for (KeyBinding var5 : new KeyBinding[]{var1.options.forwardKey, var1.options.backKey, var1.options.leftKey, var1.options.rightKey}) {
            var5.setPressed(var1.currentScreen == null && vzz.isPhysicallyDown(var1, var5));
         }
      }
   }

   Entity kyf(MinecraftClient var1, ClientPlayerEntity var2) {
      Vec3d var3 = var2.getEyePos();
      double var4 = this.kwq.get();
      double var6 = this.kwp.get() * 0.5;
      float var8 = this.kxg.serverYaw(var2);
      Entity var9 = this.kxg.target();
      if (var9 != null && this.kyh(var2, var9) && kyj(var3, var9, var4) && kyk(var8, var3, var9) <= var6 * 1.2) {
         return var9;
      }

      Entity var10 = null;
      double var11 = Double.MAX_VALUE;

      for (Entity var14 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var4 + 1.0), var2x -> this.kyh(var2, var2x))) {
         if (kyj(var3, var14, var4)) {
            double var15 = kyk(var8, var3, var14);
            if (!(var15 > var6)) {
                              double var17;
               if (java.util.Objects.equals(this.kws.get(), a.b("慍ᣑ鈘౮螬Ē뭌㊻", -1419878143))) {
                  var17 = var14.getBoundingBox().squaredMagnitude(var3);
               }
               else if (java.util.Objects.equals(this.kws.get(), a.b("腇\uf8db爌\uec70枿\ue112", -1496088311))) {
                  var17 = var14 instanceof LivingEntity var21 ? kyi(var21) : 100.0;
               }
               else {
                  var17 = var15;
               }
               if (var17 < var11) {
                  var11 = var17;
                  var10 = var14;
               }
            }
         }
      }

      return var10;
   }

   boolean kyg(Entity var1) {
      return var1 instanceof PlayerEntity var2 ? this.kww.get() && !var2.isSpectator() && !hhf.protects(var2) : this.kwx.get() && var1 instanceof Monster;
   }

   boolean kyh(ClientPlayerEntity var1, Entity var2) {
      return var2 != var1 && var2 instanceof LivingEntity var3 && var3.isAlive() && var2.isAttackable() && this.kyg(var2)
         ? this.kwy.get() || var1.canSee(var2)
         : false;
   }

   static double kyi(LivingEntity var0) {
      vyd var1 = vyk.of(var0);
      return var1.unknown() ? 100.0 : var1.total();
   }

   static boolean kyj(Vec3d var0, Entity var1, double var2) {
      return var1.getBoundingBox().squaredMagnitude(var0) <= var2 * var2;
   }

   static double kyk(float var0, Vec3d var1, Entity var2) {
      Vec3d var3 = var2.getEntityPos();
      double var4 = Math.toDegrees(Math.atan2(var3.z - var1.z, var3.x - var1.x)) - 90.0;
      return Math.abs(MathHelper.wrapDegrees(var4 - var0));
   }

   boolean kyl(MinecraftClient var1, ClientPlayerEntity var2) {
      return var1.currentScreen == null
         && var2.isAlive()
         && !var2.isSpectator()
         && !var2.isUsingItem()
         && !var2.isRiding()
         && !ovh.active()
         && !oxw.busy()
         && !kvz.busy()
         && !nuo.busy()
         && !kmy.busy()
         && tcz.mode() != tcw.RECORD
         && (var1.interactionManager == null || !var1.interactionManager.isBreakingBlock());
   }

   boolean kym(ItemStack var1) {
            if (java.util.Objects.equals(this.kwr.get(), a.b("\uf656迈Ԍ", 407696916))) {
         return true;
      }
      else if (java.util.Objects.equals(this.kwr.get(), a.d("䝻㻮됥⩉ꆈ✮", -149477138, -786141248))) {
         return var1.isIn(ItemTags.SWORDS);
      }
      else if (java.util.Objects.equals(this.kwr.get(), a.c(-615311786, "ᘓ澛\ue555笲"))) {
         return var1.isIn(ItemTags.AXES);
      }
      else {
         return var1.isIn(ItemTags.SWORDS) || var1.isIn(ItemTags.AXES) || var1.getItem() instanceof MaceItem || var1.getItem() instanceof TridentItem;
      }
   }
}
