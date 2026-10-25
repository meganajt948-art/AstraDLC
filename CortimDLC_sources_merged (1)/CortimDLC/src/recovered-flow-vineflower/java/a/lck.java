package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

public class lck extends kfe {
   final vmc lcl = this.add(new vmc(a.b("睉ૂ葷᩵醬\u171e", 1635808085), 1.5, 1.0, 3.0, 0.05).suffix(a.d("\u3103", 1651795651, 419387321)));
   final vmc lcm = this.add(new vmc(a.b("㻇䜪즛厌\ud828店\ue4c7", -2028520738), 0.5, 0.0, 1.0, 0.05).suffix(a.c(398505387, "뗒")));
   final vmc lcn = this.add(new vmc(a.d("欑ኁ頬أ跹", -1892789012, -558351385), 50.0, 5.0, 200.0, 1.0));
   final vmc lco = this.add(new vmc(a.b("儂⢟ꈵ㱇럢ㅞ譶˹鳑", 1021072671), 3.5, 2.0, 6.0, 0.1).suffix(a.c(-486064284, "㼈")));
   final vmc lcp = this.add(new vmc(a.d("ໃ睻ﶱ", 1245922544, -2075243914), 360.0, 10.0, 360.0, 5.0).unit(a.b("晹", 926967496)));
   final vkl lcq = this.add(new vkl(a.b("拯᭵釕࿚萉ʺ", -776902927), true));
   final vkl lcr = this.add(new vkl(a.d("賦\uf575義\ue1a2", -436942022, -609532988), true));
   final vkl lcs = this.add(new vkl(a.c(-933448196, "뇑졻䊠\udcdd圃퇉濶\ue266簺\uf6fc焧謠"), true));
   static Field lct;
   static Field lcu;
   LivingEntity lcv;
   long lcw;
   GLFWCursorPosCallback lcx;
   GLFWCursorPosCallback lcy;
   double lcz;
   double lda;
   double ldb = Double.NaN;
   double ldc;
   double ldd;

   public lck() {
      super(
         a.b("궽퐮廧삐䭑췄瞥﹔怑\ueaba浮", -922833413),
         a.c(1078306845, "ꠋ톙孟씮仸졞牞ﯻ斸\uef04梒銮ᱻ藐྅襢㍨볬♚ꁛ⧸厲\udd19䛞삲䩵\uf3d1緓\ue770愽\uea83ᐗ鸌ߨ膨ଌ듙㺹렾⇎ꮞ핥彲\ud890䉘찪痡ｔ祈\ue2d0沾阻Ὲ馒\u0379贱㛀끐㨵ꏲⵝ坕탠媥쑷䷄\uf7da煢ﬨ"),
         kfa.COMBAT
      );
   }

   @Override
   protected void onDisable() {
      this.ldm();
      this.lcv = null;
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      if (this.lcy == null && var1.getWindow() != null) {
         this.ldl(var1.getWindow().getHandle());
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null && var1.world != null) {
         double var3 = this.lco.get();
         if (this.lcv == null || !this.ldh(var2, this.lcv) || !ldi(var2, this.lcv, var3) || ldj(var2, this.lcv) > this.lcp.get() * 0.5) {
            this.lcv = this.ldg(var1, var2, var3);
         }
      } else {
         this.lcv = null;
      }
   }

   LivingEntity ldg(MinecraftClient var1, ClientPlayerEntity var2, double var3) {
      LivingEntity var5 = null;
      double var6 = Double.MAX_VALUE;
      double var8 = this.lcp.get() * 0.5;

      for (Entity var11 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3))) {
         if (var11 instanceof LivingEntity var12 && this.ldh(var2, var12) && ldi(var2, var12, var3)) {
            double var13 = ldj(var2, var12);
            if (var13 <= var8 && var13 < var6) {
               var6 = var13;
               var5 = var12;
            }
         }
      }

      return var5;
   }

   boolean ldh(ClientPlayerEntity var1, LivingEntity var2) {
      if (var2 != var1 && !var2.isRemoved() && var2.isAlive() && !var2.isDead() && !(var2 instanceof ArmorStandEntity)) {
         if (var2 instanceof PlayerEntity var3) {
            if (!this.lcq.get() || var3.isSpectator() || hhf.protects(var3)) {
               return false;
            }
         } else if (!this.lcr.get()) {
            return false;
         }

         return this.lcs.get() || var1.canSee(var2);
      } else {
         return false;
      }
   }

   static boolean ldi(ClientPlayerEntity var0, Entity var1, double var2) {
      return var0.squaredDistanceTo(var1) <= var2 * var2;
   }

   static double ldj(ClientPlayerEntity var0, Entity var1) {
      return Math.abs(ldk(var0, var1.getBoundingBox().getCenter()));
   }

   static double ldk(ClientPlayerEntity var0, Vec3d var1) {
      Vec3d var2 = var0.getEyePos();
      double var3 = Math.toDegrees(Math.atan2(-(var1.x - var2.x), var1.z - var2.z));
      return MathHelper.wrapDegrees(var3 - var0.getYaw());
   }

   void ldl(long var1) {
      if (lct == null) {
         lct = vxr.find(
            Mouse.class, a.c(954673734, "⨿厅\ud947䝬쳸䩍\uf019秣\ue7ba洚\ueadaႬ鹩ނ趜ୢ넠㻣ꑐ∭ꮶ퇥录"), a.d("䯵㉋뢔⛬괳⮹醄ᡳ蘣ಓ", -1271301847, -977718608), a.c(1517652545, "訄")
         );
         lcu = vxr.find(Mouse.class, a.c(923224073, "䡰㇊묈┣꺷⠂鉖ᮬ藵ཕ袕狣ﰦ旍\uefd3椭퍯岬옟䁢짹뎪㴚"), a.b("\uec61闟ἀ腸ધ谭㘕뿧↷ꬊⳟ", 1719593996), a.b("뜆", -870992061));
      }

      this.lcw = var1;
      this.lcz = 0.0;
      this.lda = 0.0;
      this.ldb = Double.NaN;
      this.ldc = 0.0;
      this.ldd = 0.0;
      this.lcy = GLFWCursorPosCallback.create(this::ldn);
      this.lcx = GLFW.glfwSetCursorPosCallback(var1, this.lcy);
   }

   void ldm() {
      if (this.lcy != null) {
         GLFWCursorPosCallback var1 = GLFW.glfwSetCursorPosCallback(this.lcw, this.lcx);
         if (var1 != null && var1.address() == this.lcy.address()) {
            this.lcy.free();
         } else {
            GLFW.glfwSetCursorPosCallback(this.lcw, var1);
         }

         this.lcy = null;
         this.lcx = null;
      }
   }

   void ldn(long var1, double var3, double var5) {
      if (this.lcx != null) {
         this.lcx.invoke(var1, var3, var5);
      }

      if (lct != null && lcu != null) {
         MinecraftClient.getInstance().execute(this::ldo);
      }
   }

   void ldo() {
      if (this.lcy != null) {
         MinecraftClient var1 = MinecraftClient.getInstance();

         try {
            double var2 = lct.getDouble(var1.mouse);
            double var4 = lcu.getDouble(var1.mouse);
            if (var4 != this.ldb) {
               this.ldc = var4 - this.ldb < 0.25 ? this.ldd : 0.0;
               this.ldd = 0.0;
               this.ldb = var4;
               this.lcz = var2;
            } else {
               this.lcz = this.lcz + (var2 - this.lda);
            }

            this.lda = this.lcz + this.ldp(var1, this.lcz);
            lct.setDouble(var1.mouse, this.lda);
         } catch (IllegalAccessException var6) {
            lct = null;
         }
      }
   }

   double ldp(MinecraftClient var1, double var2) {
      ClientPlayerEntity var4 = var1.player;
      if (var2 != 0.0
         && this.isEnabled()
         && var4 != null
         && this.lcv != null
         && this.lcv.isAlive()
         && var1.mouse.isCursorLocked()
         && var1.currentScreen == null
         && !var1.options.smoothCameraEnabled
         && !ovh.active()
         && !kmy.busy()
         && tcz.mode() != tcw.RECORD) {
         double var5 = var2 * ldq(var1, var4);
         if (var1.options.getInvertMouseX().getValue()) {
            var5 = -var5;
         }

         double var7 = ldk(var4, this.lcv.getBoundingBox().getCenter());
         double var9 = var5 * var7 > 0.0 ? this.lcl.get() : this.lcm.get();
         double var11 = MathHelper.clamp(1.0 - Math.abs(var5) / this.lcn.get(), 0.0, 1.0);
         var9 = MathHelper.lerp(var11, 1.0, var9);
         double var13 = var2 * (var9 - 1.0) + this.ldc;
         double var15 = Math.rint(var13);
         this.ldd = var13 - var15;
         return var15;
      } else {
         this.ldd = 0.0;
         return 0.0;
      }
   }

   static double ldq(MinecraftClient var0, ClientPlayerEntity var1) {
      double var2 = var0.options.getMouseSensitivity().getValue() * 0.6F + 0.2F;
      double var4 = var2 * var2 * var2;
      boolean var6 = var0.options.getPerspective().isFirstPerson() && var1.isUsingSpyglass();
      return var6 ? var4 : var4 * 8.0;
   }
}
