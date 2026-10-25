package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
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

public class ldr extends kfe {
   static ldr lds;
   static tiq ldt;
   static String ldu = "";
   final vkw ldv = this.add(
      new vkw(a.d("\uf769軿Э驍ᆗ霠", 780206722, -2098661954), new vkq(a.d("玧\u0a29胯ẕ锌Ꮾꦺ⁊븄㒸덭", 2017663258, 490367737), vhz.LAYERS, ign::open))
   );
   final vmu ldw = this.add(new vmu(a.b("诰\uf263碭\ue6d5洍\uebb9凣", -533623897), "", 32));
   final vmc ldx = this.add(new vmc(a.b("윂뺐㑖ꨧ⇱", 981649236), 1.0, 0.3, 1.6, 0.05).percent());
   final vmc ldy = this.add(new vmc(a.d("ٯ翯\uf521歜\ue08a昼\udc78", -2139191000, 1589350164), 1.0, 0.0, 1.5, 0.05).percent());
   final vmc ldz = this.add(new vmc(a.c(-307741767, "㯧䉥좡囖\udd1c宧\ue1f6栊"), 1.0, 0.0, 1.0, 0.05).percent());
   final vmc lea = this.add(new vmc(a.d("炇ि菵", 1505155032, 2141366042), 120.0, 20.0, 360.0, 5.0).unit(a.d("喦", -1903928790, 915476285)));
   final vmc leb = this.add(new vmc(a.b("㹈䟔총卫\ud8a9帗\ue449涾", -170836476), 5.0, 3.0, 8.0, 0.1).suffix(a.b("䴌", 1134710112)));
   final vmc lec = this.add(new vmc(a.b("稗Α襆᜵鳵ᩙꀌ⧼", 318601805), 120.0, 0.0, 300.0, 10.0).suffix(a.d("㻉䝦", 1028598471, 92476513)));
   final vlv led = this.add(
      new vlv(
         a.c(-1569348712, "ꏓ\uda40傄컨䔠쎆秀\uf02c湵\ue4c5"),
         a.d("꒾\udd22埪즍䉂쓹", 539739820, 435511893),
         a.d("\ue3e5驹Ⴑ軖ԙ莢", -792449264, -649474894),
         a.b("ﲬ蔼ྡ醑ᩓ鳢⚤꽗\u3100", 849673450),
         a.c(-92398713, "ᯎ扞\ue8c3盹ﴠ箍")
      )
   );
   final vlq lee = this.add(new vlq(a.d("⠮冷\udb60䕜컀䡿\uf230", 193216056, 1876301392)));
   final vlv lef = this.add(
      new vlv(a.c(-215736653, "ỿ杳\uedb1珈\uf801"), a.c(-694124604, "羔ؗ賀አ饨Ῐꖖ"), a.d("╚峙혎䡮쎦䔖ｘ", 1115285953, -940651317), a.c(2124927995, "펹ꨧ⃣"))
   );
   final vkl leg = this.add(new vkl(a.d("남줥䏻\udd92噙탿檭", 1845338409, 1088360918), true));
   final vkl leh = this.add(new vkl(a.c(1497455759, "峆╕꾋\u31eb"), false));
   final vkl lei = this.add(new vkl(a.c(1220612220, "ဥ榨\ue361納\uf6c0灣쨿䎆\udd8e圩탷⪆ꑎ"), false));
   final vkl lej = this.add(new vkl(a.d("\udc7fꗾ⼡녙㪆뱳ٴ辞ᆎ魲Უ\ue6c8栙\uf1be", 709825337, -1890922735), true));
   final vlq lek = this.add(new vlq(a.d("㗜䱊욂壬퍫喉\uefdd昹\uf869狒\uf516", 1195546156, 893625256), 269));
   final tel lel = new tel();
   long lem;
   long len;

   public ldr() {
      super(a.b("疟అ蛆ᢰ鍺ᗥ꾞♫", 1400796633), a.d("祁Ø訏ᐳ龰ᤇꍇ⪾듦㹜릎䎻촣咓\ude8e堦\ue27f涴\uf700焃\uf8bb苲ౘ韇ᇪ鬦⊎곊㘨끤㯑씁", 1740756178, -380981774), kfa.COMBAT);
      lds = this;
      this.ldw.visibleWhen(() -> false);
      this.lee.visibleWhen(() -> this.led.is(a.c(1466834132, "Ო攍\uef90熪侀糞")));
   }

   public static ldr get() {
      return lds;
   }

   public static tiq activeProfile() {
      return lfa.activeProfile();
   }

   public static void activate(tiq var0) {
      lfa.activate(var0);
      if (lds != null) {
         lds.len = 0L;
      }
   }

   public int stopKey() {
      return this.lek.get();
   }

   public boolean aiming() {
      return this.isEnabled() && this.lel.aiming();
   }

   public Entity target() {
      return this.lel.target();
   }

   @Override
   protected void onDisable() {
      this.lel.reset();
      this.lel.forgetFrame();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null) {
         long var3 = System.currentTimeMillis();
         if (var3 - this.len > 1000L) {
            this.len = var3;
            tiq var5 = activeProfile();
            tck var6 = var5 == null ? null : var5.model();
            this.lel.use(var6);
         }

         this.leq(var1);
         this.lel.tune(this.ldx.get(), this.ldy.get(), this.ldz.get());
         Entity var7 = this.ler(var1, var2) ? this.let(var1, var2) : null;
         int var8 = (int)Math.round(this.lec.get() / 50.0);
         this.lel.tick(var1, var2, var7, var8, this.lej.get());
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.currentScreen == null && var1.mouse.isCursorLocked()) {
         this.lel.frame(var1, var2);
      } else {
         this.lel.forgetFrame();
      }
   }

   void leq(MinecraftClient var1) {
      if (var1.options.attackKey.isPressed()
         || var1.currentScreen == null && var1.getWindow() != null && GLFW.glfwGetMouseButton(var1.getWindow().getHandle(), 0) == 1) {
         this.lem = System.currentTimeMillis();
      }
   }

   boolean ler(MinecraftClient var1, ClientPlayerEntity var2) {
      if (!this.lel.ready()
         || var1.currentScreen != null
         || !var1.isWindowFocused()
         || !var1.mouse.isCursorLocked()
         || !var2.isAlive()
         || var2.isSpectator()
         || tcz.mode() == tcw.RECORD) {
         return false;
      }

      if (var1.interactionManager != null && var1.interactionManager.isBreakingBlock()) {
         return false;
      }

      if (!var2.isUsingItem() && !kmy.busy()) {
         switch (this.led.get()) {
            case a.c(1817051083, "ﾍ蘝ಀ銰ᥲ鿃▅걶㈡"):
               if (System.currentTimeMillis() - this.lem > 650L) {
                  return false;
               }
               break;
            case a.b("ᮺ截\ue8b7皍ﵔ篹", -213836813):
               if (!vzz.isDown(var1, this.lee.get())) {
                  return false;
               }
         }

         return this.les(var2.getMainHandStack());
      } else {
         return false;
      }
   }

   boolean les(ItemStack var1) {
      return this.lef.is(a.d("栋ᆕ魑", -650041140, -1607712635))
         ? true
         : var1.isIn(ItemTags.SWORDS) || var1.isIn(ItemTags.AXES) || var1.getItem() instanceof MaceItem || var1.getItem() instanceof TridentItem;
   }

   Entity let(MinecraftClient var1, ClientPlayerEntity var2) {
      Vec3d var3 = var2.getEyePos();
      double var4 = this.leb.get();
      double var6 = this.lea.get() * 0.5;
      Entity var8 = this.lel.target();
      if (var8 != null && this.leu(var2, var8) && lev(var3, var8, var4) && lew(var2, var3, var8) <= Math.min(180.0, var6 * 1.25)) {
         return var8;
      }

      Entity var9 = null;
      double var10 = Double.MAX_VALUE;

      for (Entity var13 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var4 + 1.0), var2x -> this.leu(var2, var2x))) {
         if (lev(var3, var13, var4)) {
            double var14 = lew(var2, var3, var13);
            if (!(var14 > var6) && var14 < var10) {
               var10 = var14;
               var9 = var13;
            }
         }
      }

      return var9;
   }

   boolean leu(ClientPlayerEntity var1, Entity var2) {
      if (!(var2 != var1 && var2 instanceof LivingEntity var3) || !var3.isAlive() || !var2.isAttackable()) {
         return false;
      } else {
         if (var2 instanceof tkx) {
            return tcz.mode() == tcw.TEST;
         }

         if (var2 instanceof PlayerEntity var4) {
            if (!this.leg.get() || var4.isSpectator() || hhf.protects(var4)) {
               return false;
            }
         } else if (!this.leh.get() || !(var2 instanceof Monster)) {
            return false;
         }

         return this.lei.get() || var1.canSee(var2);
      }
   }

   static boolean lev(Vec3d var0, Entity var1, double var2) {
      return var1.getBoundingBox().squaredMagnitude(var0) <= var2 * var2;
   }

   static double lew(ClientPlayerEntity var0, Vec3d var1, Entity var2) {
      Vec3d var3 = var2.getBoundingBox().getCenter();
      double var4 = Math.toDegrees(Math.atan2(var3.z - var1.z, var3.x - var1.x)) - 90.0;
      double var6 = -Math.toDegrees(Math.atan2(var3.y - var1.y, Math.hypot(var3.x - var1.x, var3.z - var1.z)));
      double var8 = MathHelper.wrapDegrees(var4 - var0.getYaw());
      double var10 = var6 - var0.getPitch();
      return Math.sqrt(var8 * var8 + var10 * var10 * 0.25);
   }
}
