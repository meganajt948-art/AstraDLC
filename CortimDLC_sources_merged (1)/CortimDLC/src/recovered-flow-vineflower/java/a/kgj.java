package a;

import flow.config.ConfigManager;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

public class kgj extends kfe {
   final vkw kgk = this.add(new vkw(a.b("拏᭜醘\u0fff萾ʞ", -298884455), new vkq(a.d("턠ꢃ", 65597041, -988594411), vhz.CHECK, this::kit)));
   final vmc kgl = this.add(new vmc(a.b("ዏ歝\ue19b翪\uf43c", -2056514919), 1.0, 0.3, 1.6, 0.05).percent());
   final vmc kgm = this.add(new vmc(a.b("䯕㉌뢛⚧괣⮌針ᠬ虨\u0cc5", -462533730), 0.5, 0.0, 1.0, 0.05).percent());
   final vmc kgn = this.add(new vmc(a.d("ู瞠ﵷ捋\ue8d1湬퐦嶏쎃䤱컷㒆멐", 598303519, 1257925994), 30.0, 5.0, 90.0, 1.0).suffix(a.d("덉쩧䃯", 1326574415, 941512885)));
   final vmc kgo = this.add(new vmc(a.d("퓃굚➍릱㈴뒒\u0ec5蜶\u197e鏒ᐇ\uee77", -1461957813, 908173253), 100.0, 0.0, 300.0, 10.0).suffix(a.c(-49848727, "帆➩")));
   final vkl kgp = this.add(new vkl(a.b("徶☯곸㋄륊㿫薴ౌ鈛ᣮ齩攃\ueb9b牧\uf836绝쒔䭓", 1134911461), false));
   final vkl kgq = this.add(new vkl(a.c(262682685, "㡩䇰쬧唛\ude83堳\ue262殆\uf580罦\uf8aa˚谈ᖰ龦ᤚꍗⲟ똳づ릛"), false));
   final vmc kgr = this.add(new vmc(a.b("溋ᜒ鷅Ϲ衺໐뒛㵼ꌰ⦗글吥\udae7䍅줃俰\uf5ae", -1750372645), 3.0, 1.0, 3.0, 0.05).suffix(a.d("ⵂ", 321923545, -1607793438)));
   final vmc kgs = this.add(
      new vmc(a.d("駾\ue067檰\uf48c缚尿䏸쨑吗\udee0大ꍋ\u2d9e둢㹥뢁˝贙ឨ釨", 312764874, -1922830239), 1.0, 0.0, 1.0, 0.05).suffix(a.c(-2110588573, "駱"))
   );
   final vmc kgt = this.add(new vmc(a.c(1001716339, "喝莎ॄ"), 70.0, 10.0, 360.0, 5.0).unit(a.d("꯳", -806019792, 996193906)));
   final vmc kgu = this.add(new vmc(a.c(1610531071, "삳뤯㏦궐♒ꃬ᪲鍅"), 4.5, 2.0, 8.0, 0.1).suffix(a.d("Ꭻ", -556907735, 1997885678)));
   final vmc kgv = this.add(new vmc(a.d("펑ꨓ⃗뺠㕪돑ঀ聼", 2054289274, 1499604149), 1.0, 0.0, 1.0, 0.05).percent());
   final vlv kgw = this.add(
      new vlv(
         a.b("헤걨⚪룓㌚", 2097141160),
         a.c(454254467, "忓♐겇㋧뤯㾟藑"),
         a.c(-1177600455, "㹩䟪촽卝\ud895帥\ue46b"),
         a.d("㪫䌾짵垙\udc58嫾", -933711957, 891065685),
         a.d("臯\uf867犩\uecce", 623172715, -1233363519),
         a.c(-1714421323, "Ƿ硩\uf2ad")
      )
   );
   final vlv kgx = this.add(
      new vlv(
         a.b("짥끶㪾\ua4c9⼃ꦩᏧ騛", 1231669693),
         a.c(760418819, "ቇ毙\ue103罹\uf4a7"),
         a.c(103727010, "뿦외䲢틘夆"),
         a.c(-363289967, "ꋝ\udb41冈쿾䐼슂磜\uf12b"),
         a.c(1998113016, "좶넪㯽ꖁ⹎꣣")
      )
   );
   final vkl kgy = this.add(new vkl(a.c(150882620, "䥵ル먽⑆꾙⥣鍿\u1a8f蓒\u0e76"), false));
   final vkl kgz = this.add(new vkl(a.d("窨̥觻ធ鱙\u1affꂭ", 1686979734, -161399191), true));
   final vkl kha = this.add(new vkl(a.d("㸩䞺쵤匄", 1229063014, 1845116166), false));
   final vkl khb = this.add(new vkl(a.c(-508081671, "䦠〭뫤⒈꽅⧦鎺ᨃ萋ຬ襲猃\ufdcb"), false));
   final lfy khc = new lfy();
   static final double khd = 1.2;
   static final double khe = 1.5;
   static final int khf = 12;
   static final long khg = 1200L;
   static final long khh = 650L;
   static final double khi = 1.0;
   static final double khj = 0.8;
   static final long khk = 180L;
   static final double khl = 1.5;
   static final double khm = 8.0;
   static final double khn = 350.0;
   static final double kho = 1000.0;
   static final double khp = 0.25;
   static Field khq;
   static Field khr;
   static Field khs;
   final tel kht;
   final tbm khu;
   final double[] khv;
   long khw;
   Entity khx;
   long khy;
   GLFWCursorPosCallback khz;
   GLFWCursorPosCallback kia;
   boolean kib;
   double kic;
   double kid;
   double kie;
   double kif;
   double kig;
   long kih;
   double kii;
   double kij;
   double kik;
   double kil;
   double kim;
   volatile long kin;
   Entity kio;
   long kip;
   int kiq;

   public kgj() {
      super(a.c(295261415, "咯ⴶ\ua7e1㦼뉙㓨躡݊餒"), a.b("ṟ某\ued01獰\uf8bc縑쐊䶺폭奘\udec6⓿ꨥ㎝맒㽳蕫ત逊ᙇ鿸\ue5e8欚\uf09c盱ﰤ䖆쯈儾", 1288707601), kfa.COMBAT);
      this.add(this.khc.naked);
      this.add(this.khc.invisible);
      this.add(this.khc.armored);
      this.kht = new tel();
      this.khu = new tbm();
      this.khv = new double[2];
      this.kig = Double.NaN;
      this.kii = 0.016666666666666666;

      for (vmo var4 : new vmo[]{this.kgm, this.kgn, this.kgo, this.kgp, this.kgq, this.kgr, this.kgs}) {
         var4.visibleWhen(() -> false);
      }
   }

   void kit() {
      this.kgl.set(0.9);
      this.kgt.set(360.0);
      this.kgu.set(4.5);
      this.kgv.set(0.55);
      ConfigManager.autoSaveLater();
   }

   public Entity pilotTarget() {
      return this.isEnabled() ? this.kht.target() : null;
   }

   @Override
   protected void onDisable() {
      this.kht.reset();
      this.kht.forgetFrame();
      this.kjf();
      this.khx = null;
      this.kih = 0L;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 == null) {
         this.khx = null;
      } else {
         this.kht.use(tck.profileOld());
         this.kjb(var1);
         this.kht.tune(this.kgl.get(), 1.0 * (1.0 - 0.8 * this.kgm.get()), this.kgv.get());
         this.kht.newTick();
         this.kht.cap(this.kgn.get());
         Entity var3 = this.kjc(var1, var2) ? this.kiu(var1, var2) : null;
         long var4 = System.currentTimeMillis();
         if (var3 != null && this.kgq.get() && var4 - this.kin > 180L) {
            var3 = null;
         }

         int var6 = (int)Math.round(this.kgo.get() / 50.0);
         if (var3 != null && var3 == this.kio && var4 - this.kip < 1200L) {
            var6 = 0;
         }

         if (var3 != null) {
            this.kio = var3;
            this.kip = var4;
         }

         this.kht.tick(var1, var2, var3, var6, this.kgp.get());
         this.khx = var3;
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      if ((this.kia == null || !this.kib) && var1.getWindow() != null) {
         this.kje(var1.getWindow().getHandle());
      }

      long var2 = System.nanoTime();
      if (this.kih != 0L) {
         this.kii = this.kii + (Math.min(0.1, (var2 - this.kih) / 1.0E9) - this.kii) * 0.2;
      }

      this.kih = var2;
      ClientPlayerEntity var4 = var1.player;
      if (var4 != null && var1.currentScreen == null && var1.mouse.isCursorLocked()) {
         this.kht.frame(var1, var4);
      } else {
         this.kht.forgetFrame();
      }
   }

   Entity kiu(MinecraftClient var1, ClientPlayerEntity var2) {
      Vec3d var3 = var2.getEyePos();
      double var4 = this.kgu.get();
      double var6 = this.kgt.get() * 0.5;
      Entity var8 = this.kht.target();
      if (var8 == null && this.kio != null && System.currentTimeMillis() - this.kip < 1200L) {
         var8 = this.kio;
      }

      if (var8 != null && this.kiv(var2, var3, var8, var4, var6)) {
         return var8;
      }

      this.kiq = 0;
      Entity var9 = null;
      double var10 = Double.MAX_VALUE;

      for (Entity var13 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var4 + 1.0), var2x -> this.kiw(var2, var2x))) {
         if (kiz(var3, var13, var4)) {
            double var14 = kja(var2, var3, var13);
            if (!(var14 > var6)) {
                              double var16;
               if (java.util.Objects.equals(this.kgx.get(), a.b("\udec7ꝛⶒ돤㠦뺘ӆ贱", -46866805))) {
                  var16 = var13.getBoundingBox().squaredMagnitude(var3);
               }
               else if (java.util.Objects.equals(this.kgx.get(), a.b("ꂐ\ud90c叛춧䙨샅", -2138464034))) {
                  var16 = var13 instanceof LivingEntity var20 ? kiy(var20) : 100.0;
               }
               else {
                  var16 = var14;
               }
               if (var16 < var10) {
                  var10 = var16;
                  var9 = var13;
               }
            }
         }
      }

      return var9;
   }

   boolean kiv(ClientPlayerEntity var1, Vec3d var2, Entity var3, double var4, double var6) {
      if (var3.isRemoved() || !this.kix(var1, var3, false) || !kiz(var2, var3, var4 + 1.5) || kja(var1, var2, var3) > var6 * 1.2) {
         return false;
      }

      if (!this.khb.get() && !var1.canSee(var3)) {
         return ++this.kiq <= 12;
      }

      this.kiq = 0;
      return true;
   }

   boolean kiw(ClientPlayerEntity var1, Entity var2) {
      return this.kix(var1, var2, true);
   }

   boolean kix(ClientPlayerEntity var1, Entity var2, boolean var3) {
      if (var2 != var1 && var2 instanceof LivingEntity var4 && var4.isAlive() && var2.isAttackable()) {
         if (var2 instanceof PlayerEntity var5) {
            if (!this.kgz.get() || var5.isSpectator() || hhf.protects(var5)) {
               return false;
            }
         } else if (!this.kha.get() || !(var2 instanceof Monster)) {
            return false;
         }

         return !this.khc.allows(var2) ? false : !var3 || this.khb.get() || var1.canSee(var2);
      } else {
         return false;
      }
   }

   static double kiy(LivingEntity var0) {
      vyd var1 = vyk.of(var0);
      return var1.unknown() ? 100.0 : var1.total();
   }

   static boolean kiz(Vec3d var0, Entity var1, double var2) {
      return var1.getBoundingBox().squaredMagnitude(var0) <= var2 * var2;
   }

   static double kja(ClientPlayerEntity var0, Vec3d var1, Entity var2) {
      Vec3d var3 = var2.getEntityPos();
      double var4 = Math.toDegrees(Math.atan2(var3.z - var1.z, var3.x - var1.x)) - 90.0;
      return Math.abs(MathHelper.wrapDegrees(var4 - var0.getYaw()));
   }

   void kjb(MinecraftClient var1) {
      boolean var2 = var1.options.attackKey.isPressed()
         || var1.currentScreen == null && var1.getWindow() != null && GLFW.glfwGetMouseButton(var1.getWindow().getHandle(), 0) == 1;
      if (var2) {
         this.khw = System.currentTimeMillis();
      }
   }

   boolean kjc(MinecraftClient var1, ClientPlayerEntity var2) {
      if (var1.currentScreen != null || !var1.isWindowFocused() || !var1.mouse.isCursorLocked() || !var2.isAlive() || var2.isSpectator()) {
         return false;
      } else if (var1.interactionManager != null && var1.interactionManager.isBreakingBlock()) {
         return false;
      } else if (var2.isUsingItem()) {
         return false;
      } else if (kmy.busy() || tcz.mode() == tcw.RECORD || nfl.busy() || lqq.busy()) {
         return false;
      } else {
         return this.kgy.get() && System.currentTimeMillis() - this.khw > 650L ? false : this.kjd(var2.getMainHandStack());
      }
   }

   boolean kjd(ItemStack var1) {
            if (java.util.Objects.equals(this.kgw.get(), a.c(138839254, "蒔ﴊ矎"))) {
         return true;
      }
      else if (java.util.Objects.equals(this.kgw.get(), a.d("Ἲ暯\uec64爈柳罯", 1174444933, -987331350))) {
         return var1.isIn(ItemTags.SWORDS);
      }
      else if (java.util.Objects.equals(this.kgw.get(), a.d("ᒜ洔\ue7da禽", 1898114766, 1348401687))) {
         return var1.isIn(ItemTags.AXES);
      }
      else {
         return var1.isIn(ItemTags.SWORDS) || var1.isIn(ItemTags.AXES) || var1.getItem() instanceof MaceItem || var1.getItem() instanceof TridentItem;
      }
   }

   void kje(long var1) {
      if (khq == null || khr == null || khs == null) {
         khq = vxr.find(
            Mouse.class, a.d("쓯뵕㞗ꦼ∨꒝ỉ霳४菊Њﹼ点\ue952捌\ue5b2忰퀳䪀쳽䕦㼵놅", 2047519207, 312634737), a.c(326382811, "㒷䴉쟖妮퉱哻\ueec6朱率珑"), a.c(-2056003935, "\udee4")
         );
         khr = vxr.find(
            Mouse.class,
            a.b("龲\ue608泊\uf2e1祵\uffc0䖔챮刷\ud897彗ꔡ⯤눏㠑뻯ҭ譮ᇝ鞠ḻ摨\uead8", 1817026507),
            a.d("ᜋ溵\ue46a稒\uf1cd睇쵺䒍\udadd偣", 1712520531, 40167988),
            a.d("묁", 1740035789, -1693880951)
         );
         khs = vxr.find(Mouse.class, a.b("튌ꬶ⇴뿟㑋닾ࢪ腐Ἁ閩ቩ\ue81f曚Ｑ甯\uf3d1䦓왐峣\uda9e包⥖\ua7e6", -961293579), a.b("珳੍肒Ừ锵Ꮏꦇ⁵븥㒘덍", -532909154), a.b("ꛇ", 175548034));
      }

      if (khq != null && khr != null && khs != null) {
         this.kic = this.kid = this.kie = this.kif = 0.0;
         this.kig = Double.NaN;
         this.kij = this.kik = this.kil = this.kim = 0.0;
         if (this.kia == null) {
            this.khy = var1;
            this.kia = GLFWCursorPosCallback.create(this::kjg);
            this.khz = GLFW.glfwSetCursorPosCallback(var1, this.kia);
         }

         this.kib = true;
      }
   }

   void kjf() {
      this.kib = false;
      if (this.kia != null) {
         GLFWCursorPosCallback var1 = GLFW.glfwSetCursorPosCallback(this.khy, this.khz);
         if (var1 != null && var1.address() == this.kia.address()) {
            this.kia.free();
            this.kia = null;
            this.khz = null;
         } else {
            GLFW.glfwSetCursorPosCallback(this.khy, var1);
         }
      }
   }

   void kjg(long var1, double var3, double var5) {
      if (this.khz != null) {
         this.khz.invoke(var1, var3, var5);
      }

      if (this.kib) {
         MinecraftClient.getInstance().execute(this::kjh);
      }
   }

   void kjh() {
      if (this.kib && khq != null) {
         MinecraftClient var1 = MinecraftClient.getInstance();

         try {
            double var2 = khq.getDouble(var1.mouse);
            double var4 = khr.getDouble(var1.mouse);
            double var6 = khs.getDouble(var1.mouse);
            if (var6 == this.kig) {
               this.kic = this.kic + (var2 - this.kie);
               this.kid = this.kid + (var4 - this.kif);
            } else {
               boolean var8 = !Double.isNaN(this.kig) && var6 - this.kig < 0.25;
               this.kij = var8 ? this.kil : 0.0;
               this.kik = var8 ? this.kim : 0.0;
               this.kil = this.kim = 0.0;
               this.kig = var6;
               this.kic = var2;
               this.kid = var4;
            }

            if (this.kic != 0.0 || this.kid != 0.0) {
               this.kin = System.currentTimeMillis();
            }

            this.kji(var1);
            this.kie = this.kic + this.khv[0];
            this.kif = this.kid + this.khv[1];
            khq.setDouble(var1.mouse, this.kie);
            khr.setDouble(var1.mouse, this.kif);
         } catch (IllegalAccessException var9) {
            khq = null;
            this.kib = false;
         }
      }
   }

   void kji(MinecraftClient var1) {
      this.khv[0] = this.khv[1] = 0.0;
      ClientPlayerEntity var2 = var1.player;
      Entity var3 = this.khx;
      if ((this.kic != 0.0 || this.kid != 0.0)
         && this.isEnabled()
         && var2 != null
         && var3 != null
         && var3.isAlive()
         && !var3.isRemoved()
         && var1.currentScreen == null
         && var1.mouse.isCursorLocked()
         && !var1.options.smoothCameraEnabled
         && var1.options.getPerspective().isFirstPerson()
         && !ovh.active()) {
         double var4 = kjl(var1, var2);
         float var6 = var1.getRenderTickCounter().getTickProgress(true);
         Vec3d var7 = var2.getCameraPosVec(var6);
         Vec3d var8 = var3.getLerpedPos(var6);
         if (!(var4 <= 0.0) && tbp.aim(var7.x, var7.y, var7.z, var8.x, var8.y, var8.z, var3.getWidth() * 0.5, var3.getHeight(), 0.0, 0.5, this.khu)) {
            double var9 = var1.options.getInvertMouseX().getValue() ? -1.0 : 1.0;
            double var11 = var1.options.getInvertMouseY().getValue() ? -1.0 : 1.0;
            double var13 = this.kic * var4 * var9;
            double var15 = this.kid * var4 * var11;
            double var17 = tbp.wrap(this.khu.yaw - var2.getYaw());
            double var19 = this.khu.pitch - var2.getPitch();
            double var21 = kjk(var17 + this.khu.la, var17 + this.khu.ra);
            double var23 = kjk(var19 + this.khu.ta, var19 + this.khu.ba);
            double var25 = 1.0 - kjm(1.5, 8.0, Math.hypot(var21, var23));
            double var27 = kjm(350.0, 1000.0, Math.hypot(var13, var15) / Math.max(0.001, this.kii));
            double var29 = (this.kjj(var13, var21, var17, var25) - var13) * (1.0 - var27);
            double var31 = (this.kjj(var15, var23, var19, var25) - var15) * (1.0 - var27) * this.kgv.get();
            double var33 = var29 / var4 * var9 + this.kij;
            double var35 = var31 / var4 * var11 + this.kik;
            this.khv[0] = Math.rint(var33);
            this.khv[1] = Math.rint(var35);
            this.kil = var33 - this.khv[0];
            this.kim = var35 - this.khv[1];
         } else {
            this.kil = this.kim = 0.0;
         }
      } else {
         this.kil = this.kim = 0.0;
      }
   }

   double kjj(double var1, double var3, double var5, double var7) {
      if (var1 == 0.0) {
         return 0.0;
      }

      boolean var9 = var3 != 0.0 ? var1 * var3 > 0.0 : var1 * var5 > 0.0;
      if (!var9) {
         return var1 * MathHelper.lerp(var7, 1.0, this.kgs.get());
      }

      if (var3 == 0.0) {
         return var1;
      }

      double var10 = var1 * this.kgr.get();
      double var12 = Math.max(Math.abs(var1), Math.abs(var5));
      return Math.abs(var10) > var12 ? Math.copySign(var12, var1) : var10;
   }

   static double kjk(double var0, double var2) {
      return var0 > 0.0 ? var0 : (var2 < 0.0 ? var2 : 0.0);
   }

   static double kjl(MinecraftClient var0, ClientPlayerEntity var1) {
      double var2 = var0.options.getMouseSensitivity().getValue() * 0.6F + 0.2F;
      double var4 = var2 * var2 * var2;
      boolean var6 = var0.options.getPerspective().isFirstPerson() && var1.isUsingSpyglass();
      return (var6 ? var4 : var4 * 8.0) * 0.15;
   }

   static double kjm(double var0, double var2, double var4) {
      double var6 = MathHelper.clamp((var4 - var0) / (var2 - var0), 0.0, 1.0);
      return var6 * var6 * (3.0 - 2.0 * var6);
   }
}
