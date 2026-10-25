package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttackRangeComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

final class kjq extends kfe {
   private final vlv kjr = this.add(
      new vlv(a.b("亻㜻뷳⎟ꡏ", -478523651), a.d("ֈ簇\uf6d8梺\ue36b", -1632274082, 457538688), a.b("煎ࣁ舞ᱼ鞭", -1862831848), a.c(-990878769, "掃ᨛ郈"))
   );
   private final vkl kjs = this.add(new vkl(a.c(1207326738, "塅⇖ꬒ㕢뺸㠃艇"), true));
   private final vkl kjt = this.add(new vkl(a.b("ꋠ\udb72冣쿉䐙슲磇\uf101潈\ue5ef戭", -1490705736), false));
   private final vkl kju = this.add(new vkl(a.c(1614762710, "劖⬉ꇚ㾾됹㋛袋Ÿ鼼ᖊ鉃"), true));
   private final vkl kjv = this.add(new vkl(a.b("\uf31f誂S鸤ᗅ鍊⤕ꃶ㺲", 75821915), true));
   private final vmc kjw = this.add(new vmc(a.c(2118563030, "뒌촊䟝\ud9ae剮퓂溗\ue767"), 0.0, 0.0, 500.0, 10.0).suffix(a.b("郇\ue968", -1290760024)));
   private final vmc kjx = this.add(new vmc(a.c(287932150, "纷ܧ跽ᎁ顎"), 0.0, 0.0, 10.0, 1.0).suffix(a.c(903363351, "㭦䋊젓噪\udda5")));
   private final vkl kjy = this.add(new vkl(a.d("\ude19ꞔⵊ댣㣨빎М", -1981620463, -612564641), true));
   private final vkl kjz = this.add(new vkl(a.d("ⵃ哐\ude0e䁮", 1311863879, -364357299), true));
   private final vkl kka = this.add(new vkl(a.b("뷕쑘云탽嬰\udd93柏\uee76灯響紂蝿ণ逘ᩜ", -1952334450), true));
   private static final int kkb = 12;
   private static final int kkc = 1;
   private static final int kkd = 2;
   private static final int kke = 10;
   private static final int kkf = 2;
   private static final double kkg = 0.1;
   private static final double kkh = 1.0;
   private static final int kki = 3;
   private static final float kkj = 0.9F;
   private static final double kkk = 1.25;
   private static final int kkl = 5;
   private static final int kkm = 20;
   private static final Field kkn = vxr.find(
      MinecraftClient.class, a.c(-14317303, "襰\uf0ca稈\ue423澷\ue902卖\udaac䓵칕䦕돣㴦\ua4cd⻓\ua82dቯ鶬ܟ腢ࣹ犪ﰘ"), a.c(-1767998247, "粵ԋ返ᆬ驳᳹ꛄ⼳녬㯛"), a.c(1898917041, "⳹")
   );
   private static final Field kko = vxr.find(
      LivingEntity.class,
      a.b("\uf5c8豲ڰ颛ጏ閺\u2feeꘔ㡍닭㔭콛䆞\ud875剫풕滗\ue114箧\ufdda瑃ฐ肠᭸", 71103934),
      a.c(1565623774, "薲ﰌ盓\ue8ab捴\ue5fe忄혱䡮싕"),
      a.d("ฒ", 282739367, -1331671811)
   );
   private final ksp kkp = new ksp();
   private kjn kkq = kjn.NONE;
   private int kkr;
   private int kks = 1;
   private boolean kkt;
   private int kku;
   private boolean kkv;
   private double kkw;
   private boolean kkx = true;
   private int kky;
   private int kkz;
   private double kla;
   private double klb = Double.NaN;
   private int klc = Integer.MAX_VALUE;
   private Entity kld;
   private int kle;
   private int klf;
   private int klg = 3;
   private int klh;
   private boolean kli;
   private Entity klj;
   private int klk = 10;
   private final wdt kll = new wdt();
   private Predicate<Entity> klm;
   private Entity kln;
   private Vec3d klo;
   private boolean klp;
   private boolean klq;
   private int klr = -1;
   private kjn kls = kjn.NONE;
   private boolean klt;

   private kjq(Predicate<Entity> var1) {
      super(a.d("땕쳂䘊\ud875厢픑潕\ue694磦\uf24c", -549677939, 1153507718), "", kfa.COMBAT);
      this.klm = var1;
   }

   static kjq embedded(Predicate<Entity> var0) {
      return new kjq(var0);
   }

   String trace() {
      return a.d("쐑붵㝵ꤑ⋄ꑤṾ", -1478821122, 1752252060)
         + this.klp
         + a.b("\udc74ꖆ⽗넩㪭", 633855057)
         + this.klq
         + a.b("馌\ue07e檼\uf4d6缜理", -270886486)
         + this.klr
         + a.d("䪻㍏릗⟯갾⪉郘ᤨ蜮", -549924535, -1985635365)
         + this.kli
         + a.c(559946465, "᫆挥\ue9e1瞔ﱐ竾샽")
         + this.kls
         + a.d("䋩㬐뇄⾪ꐰ", -1451105018, 261924810)
         + this.klt
         + a.b("輝\uf6ff簯\ue24b榗\uef3c唦", -1861710022)
         + this.kkt;
   }

   int strikeIn(MinecraftClient var1, ClientPlayerEntity var2, Entity var3, boolean var4) {
      this.kkp.predict(var2, var1.world, var1.options.jumpKey.isPressed(), vxr.getInt(kko, var2, 0), lxp.active(), this.kla);
      int var5 = wdt.serverSprinting(var2) ? 1 : 0;
      if (var4 && this.kmr(var1, var2)) {
         int var6 = this.kma(var2, var5, true, false);
         if (var6 < 0) {
            var6 = this.kma(var2, var5, false, false);
         }

         if (var6 > 0 && kmd(var2, 0) && this.kmb(var2, var3, var6)) {
            var6 = -1;
         }

         if (var6 >= 0) {
            return var6;
         }
      }

      for (int var7 = 0; var7 < 20; var7++) {
         if (kmd(var2, var7)) {
            return var7;
         }
      }

      return 20;
   }

   Vec3d selfOffset(int var1) {
      return this.kkp.offsetAt(var1);
   }

   void crits(boolean var1) {
      this.kjr.set(var1 ? a.b("䲇㔈뿗↵ꩤ", 504843473) : a.c(-698373815, "꤅킝婎"));
   }

   @Override
   protected void onEnable() {
      this.kla = 0.0;
      this.klb = Double.NaN;
      this.klc = Integer.MAX_VALUE;
      this.kkt = false;
      this.kks = kmn();
      this.kkw = klx();
      this.kky = kly();
   }

   @Override
   protected void onDisable() {
      this.kmt(this.mc);
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      double var3 = var2.getY();
      double var5 = Double.isNaN(this.klb) ? 0.0 : var3 - this.klb;
      this.klb = var3;
      if (var5 > 0.0 || var5 < -4.0) {
         this.kla = 0.0;
      } else if (var5 < 0.0 && !var2.isTouchingWater()) {
         this.kla -= var5;
      }

      this.kla = Math.min(this.kla, var2.fallDistance);
      this.klc = var2.isOnGround() ? Math.min(this.klc, 2147483646) + 1 : 0;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      if (this.kkz > 0) {
         this.kkz--;
      }

      if (this.klk < 10) {
         this.klk++;
      }

      if (var1.currentScreen == null
         && !var2.isSpectator()
         && var2.isAlive()
         && !var2.isUsingItem()
         && !var2.isRiding()
         && !this.kmu(var1)
         && !oxw.busy()
         && !kvz.busy()
         && !nuo.busy()
         && !kmy.busy()
         && !nfl.busy()
         && !lqq.busy()) {
         boolean var3 = wdt.serverSprinting(var2);
         if (!var3) {
            this.kkt = false;
         } else if (this.kkt) {
            if (!var2.isSprinting()) {
               this.kkv = true;
            }

            if (!this.kkv && ++this.kku > 20) {
               this.kkt = false;
            }
         }

         boolean var4 = var2.isOnGround();
         if (this.kkx && !var4) {
            this.kkw = klx();
         }

         this.kkx = var4;
         boolean var5 = this.kju.get();
         kjn var6 = var5 ? kjn.NONE : this.kkq;
         if (var6 == kjn.STOP && var2.isOnGround() && var1.options.jumpKey.isPressed()) {
            var6 = kjn.START;
         }

         var1.gameRenderer.updateCrosshairTarget(1.0F);
         Entity var7 = this.kmv(var1);
         this.kli = Integer.bitCount(this.klh) >= 2;
         this.klh = (this.klh << 1 | (var7 != null ? 1 : 0)) & 65535;
         boolean var8 = this.kmc(var7);
         boolean var9 = this.kjv.get() && var2.getMainHandStack().isOf(Items.MACE);
         boolean var10 = var7 != null
            && var8
            && this.kkz == 0
            && kme(var1, var2, this.kln != null ? this.klo : var1.crosshairTarget.getPos())
            && (!var9 || !this.kmp(var7));
         boolean var11 = this.kjr.is(a.b("\uea47鏈ᤗ蝵ತ", -1627919855)) && this.kmr(var1, var2) && (!var5 || !var3 || this.kkt);
         boolean var12 = var9 && this.kmq(var1, var2);
         if (var11 || var12) {
            this.kkp.predict(var2, var1.world, var1.options.jumpKey.isPressed(), vxr.getInt(kko, var2, 0), lxp.active(), this.kla);
         }

         int var13 = !var5 && var3 ? 1 : 0;
         int var14 = -1;
         boolean var15 = var12 && this.kkp.smashAt(0);
         boolean var16 = false;
         if (var9) {
            if (var11 && var12) {
               var14 = this.kma(var2, var13, true, true);
            }

            if (var14 > 0 && var15 && this.kmb(var2, var7, var14)) {
               var14 = -1;
            }
         } else if (var11) {
            var14 = this.klw(var2, var13, true);
            if (var14 < 0) {
               var14 = this.klw(var2, var13, false);
            }

            var16 = var14 < 0 && var2.isOnGround() && this.klc <= 5 && this.kli && ksp.headroom(var2, var1.world, 1.25) < 1.25;
            if (var14 > 0 && kmd(var2, 0) && this.kmb(var2, var7, var14)) {
               int var17 = this.kma(var2, var13, true, false);
               if (var17 < 0) {
                  var17 = this.kma(var2, var13, false, false);
               }

               var14 = var17 >= 0 && var17 < var14 && !this.kmb(var2, var7, var17) ? var17 : -1;
            }
         }

         if (!var5 && var6 == kjn.NONE && this.kkt && this.kjt.get() && var14 < 0) {
            int var20 = this.kmo(var1, var2);
            if (var20 > 0) {
               var6 = kjn.STOP;
               this.kkr = var20;
            }
         }

         boolean var21 = var14 == 0 || var14 == 1;
         boolean var18 = var7 != null || var21 && this.kjs.get() && (this.kmh(var1, var2) || this.kmi(var1, var2));
         this.klg = var18 ? 0 : this.klg + 1;
         boolean var19 = !var5 && var21 && this.klg <= 2;
         if (var6 != kjn.STOP && !var19) {
            this.kll.release(var1);
         } else {
            this.kll.hold(var1);
         }
         this.kkq = switch (var6) {
            case NONE, START -> kjn.NONE;
            case STOP -> --this.kkr > 0 ? kjn.STOP : kjn.START;
         };
         this.klp = var7 != null;
         this.klq = var10;
         this.klr = var14;
         this.kls = var6;
         this.klt = var16;
         if (var10) {
            if (var14 == 0) {
               this.kml(var1);
               this.kkw = klx();
               this.kll.release(var1);
               if (var9) {
                  this.kla = 0.0;
               }
            } else {
               if (var14 > 0) {
                  return;
               }

               if (var9) {
                  if (!var15) {
                     return;
                  }

                  this.kml(var1);
                  this.kla = 0.0;
               } else {
                  if (!kmd(var2, 0) || !klz(var2, this.kky) || var6 != kjn.NONE || var16) {
                     return;
                  }

                  this.kml(var1);
               }
            }

            this.kkz = this.kjx.getInt();
         }
      } else {
         this.kmt(var1);
      }
   }

   private int klw(ClientPlayerEntity var1, int var2, boolean var3) {
      if (!this.kli) {
         return this.kma(var1, var2, var3, false);
      }

      int var4 = -1;

      for (int var5 = var2; var5 < 20; var5++) {
         boolean var6 = var3 ? this.kkp.critAt(var5) : this.kkp.rawCritAt(var5);
         if (!var6) {
            if (var4 >= 0) {
               break;
            }
         } else if (kmd(var1, var5)) {
            if (var4 < 0) {
               var4 = var5;
            }

            if (this.kkp.fallAt(var5) >= this.kkw) {
               return var5;
            }
         }
      }

      return var4;
   }

   private static double klx() {
      double var0 = ThreadLocalRandom.current().nextDouble();
      return var0 < 0.3 ? 0.0 : (var0 < 0.65 ? 0.15 : (var0 < 0.9 ? 0.35 : 0.6));
   }

   private static int kly() {
      double var0 = ThreadLocalRandom.current().nextDouble();
      return var0 < 0.5 ? 0 : (var0 < 0.85 ? 1 : 2);
   }

   private static boolean klz(ClientPlayerEntity var0, int var1) {
      return var0.getAttackCooldownProgress(0.5F - var1) > 0.9F;
   }

   private int kma(ClientPlayerEntity var1, int var2, boolean var3, boolean var4) {
      for (int var5 = var2; var5 < 20; var5++) {
         boolean var6 = var3 ? this.kkp.critAt(var5) : this.kkp.rawCritAt(var5);
         if (var6 && (!var4 || this.kkp.smashAt(var5)) && kmd(var1, var5)) {
            return var5;
         }
      }

      return -1;
   }

   private boolean kmb(ClientPlayerEntity var1, Entity var2, int var3) {
      return var3 > (this.kli ? 12 : 1) || var2 != null && this.kmg(var1, var2, var3);
   }

   private boolean kmc(Entity var1) {
      if (var1 == null) {
         if (this.kld != null && ++this.klf > 2) {
            this.kld = null;
         }

         return false;
      } else {
         if (var1 != this.kld) {
            this.kld = var1;
            this.kle = 0;
         }

         this.klf = 0;
         return this.kle++ * 50L >= (long)this.kjw.get();
      }
   }

   private static boolean kmd(ClientPlayerEntity var0, int var1) {
      return var0.getAttackCooldownProgress(0.5F + var1) > 0.9F;
   }

   private static boolean kme(MinecraftClient var0, ClientPlayerEntity var1, Vec3d var2) {
      if (vxr.getInt(kkn, var0, 0) > 0) {
         return false;
      }

      ItemStack var3 = var1.getMainHandStack();
      if (var1.isBelowMinimumAttackCharge(var3, 0)) {
         return false;
      }

      AttackRangeComponent var4 = var3.get(DataComponentTypes.ATTACK_RANGE);
      return var4 == null || var4.isWithinRange(var1, var2);
   }

   private static double kmf(ClientPlayerEntity var0) {
      AttackRangeComponent var1 = var0.getMainHandStack().get(DataComponentTypes.ATTACK_RANGE);
      return var1 != null ? var1.getEffectiveMaxRange(var0) : var0.getEntityInteractionRange();
   }

   private boolean kmg(ClientPlayerEntity var1, Entity var2, int var3) {
      int var4 = Math.min(var3, 3);
      double var5 = kmf(var1);
      Vec3d var7 = var1.getEyePos().add(this.kkp.offsetAt(var4));
      Box var8 = var2.getBoundingBox().offset((var2.getX() - var2.lastX) * var4, 0.0, (var2.getZ() - var2.lastZ) * var4);
      return var8.squaredMagnitude(var7) > var5 * var5;
   }

   private boolean kmh(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = kmf(var2) + 1.0;
      Vec3d var5 = var2.getEyePos();

      for (Entity var7 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3 + 1.0), var2x -> this.kmx(var1, var2x))) {
         if (var7.getBoundingBox().squaredMagnitude(var5) <= var3 * var3) {
            return true;
         }
      }

      return false;
   }

   private boolean kmi(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = kmf(var2);
      Vec3d var5 = var2.getEyePos();
      Vec3d var6 = var5.add(var2.getRotationVec(1.0F).multiply(var3));
      float var7 = MathHelper.clamp(2.0F * var2.getPitch() - var2.lastPitch, -90.0F, 90.0F);
      float var8 = 2.0F * var2.getYaw() - var2.lastYaw;
      Vec3d var9 = var5.add(Vec3d.fromPolar(var7, var8).multiply(var3));
      Vec3d var10 = kmj(var1, var2, var5, var6);
      Vec3d var11 = kmj(var1, var2, var5, var9);
      Box var12 = var2.getBoundingBox().expand(var3 + 2.0);

      for (Entity var14 : var1.world.getOtherEntities(var2, var12, var2x -> this.kmx(var1, var2x))) {
         Box var15 = var14.getBoundingBox();
         Box var16 = var15.union(var15.offset(var14.getX() - var14.lastX, var14.getY() - var14.lastY, var14.getZ() - var14.lastZ)).expand(0.1);
         if (kmk(var16, var5, var6, var10) || kmk(var16, var5, var9, var11)) {
            return true;
         }
      }

      return false;
   }

   private static Vec3d kmj(MinecraftClient var0, ClientPlayerEntity var1, Vec3d var2, Vec3d var3) {
      BlockHitResult var4 = var0.world.raycast(new RaycastContext(var2, var3, ShapeType.OUTLINE, FluidHandling.NONE, var1));
      return var4.getType() == Type.MISS ? var3 : var4.getPos();
   }

   private static boolean kmk(Box var0, Vec3d var1, Vec3d var2, Vec3d var3) {
      if (var0.contains(var1)) {
         return true;
      }

      double var4 = var1.squaredDistanceTo(var3);
      return var0.raycast(var1, var2).filter(var3x -> var1.squaredDistanceTo(var3x) <= var4).isPresent();
   }

   private void kml(MinecraftClient var1) {
      wdf.hold(var1, kmm());
      ClientPlayerEntity var2 = var1.player;
      if (wdt.serverSprinting(var2) && var2.getAttackCooldownProgress(0.5F) > 0.9F) {
         this.kkt = true;
         this.kku = 0;
         this.kkv = false;
         this.kks = kmn();
      }

      this.kky = kly();
      if (this.kln != null) {
         var1.interactionManager.attackEntity(var1.player, this.kln);
         var1.player.swingHand(Hand.MAIN_HAND);
         this.klj = this.kln;
      } else {
         KeyBinding.onKeyPressed(KeyBindingHelper.getBoundKeyOf(var1.options.attackKey));
         this.klj = this.kmv(var1);
      }

      this.klk = 0;
   }

   private static long kmm() {
      return ThreadLocalRandom.current().nextLong(1000000L, 10000001L);
   }

   private static int kmn() {
      return ThreadLocalRandom.current().nextInt(1, 3);
   }

   private int kmo(MinecraftClient var1, ClientPlayerEntity var2) {
      for (int var3 = this.kks; var3 > 0; var3--) {
         if (!kmd(var2, var3) && (!var2.isOnGround() || kmd(var2, var3 + 1) && !var1.options.jumpKey.isPressed())) {
            return var3;
         }
      }

      return 0;
   }

   private boolean kmp(Entity var1) {
      return var1 instanceof LivingEntity var2 && var2.hurtTime > 0 || var1 == this.klj && this.klk < 10;
   }

   private boolean kmq(MinecraftClient var1, ClientPlayerEntity var2) {
      return !var2.isClimbing()
         && !var2.isTouchingWater()
         && !var2.isInLava()
         && !var2.hasVehicle()
         && !var2.isGliding()
         && !var2.getAbilities().flying
         && !var2.inPowderSnow
         && !var2.hasStatusEffect(StatusEffects.LEVITATION)
         && !var2.hasStatusEffect(StatusEffects.SLOW_FALLING)
         && var1.world.getStatesInBox(var2.getBoundingBox().contract(1.0E-7)).noneMatch(kjq::kms);
   }

   private boolean kmr(MinecraftClient var1, ClientPlayerEntity var2) {
      return !var2.hasStatusEffect(StatusEffects.BLINDNESS) && this.kmq(var1, var2);
   }

   private static boolean kms(BlockState var0) {
      return var0.isOf(Blocks.COBWEB) || var0.isOf(Blocks.SWEET_BERRY_BUSH) || var0.isOf(Blocks.POWDER_SNOW);
   }

   private void kmt(MinecraftClient var1) {
      this.kll.release(var1);
      this.kkq = kjn.NONE;
      this.kld = null;
      this.kle = 0;
      this.klf = 0;
      this.klg = 3;
      this.klh = 0;
   }

   private boolean kmu(MinecraftClient var1) {
      return var1.interactionManager != null && var1.interactionManager.isBreakingBlock()
         ? true
         : var1.options.attackKey.isPressed() && var1.crosshairTarget != null && var1.crosshairTarget.getType() == Type.BLOCK;
   }

   private Entity kmv(MinecraftClient var1) {
      this.kln = null;
      HitResult var2 = var1.crosshairTarget;
      if (var2 != null && var2.getType() == Type.ENTITY) {
         Entity var3 = ((EntityHitResult)var2).getEntity();
         if (this.kmx(var1, var3)) {
            return var3;
         } else if (this.kka.get() && var3 instanceof PlayerEntity && hhf.isFriend(var3)) {
            this.kln = this.kmw(var1, var1.player);
            return this.kln;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private Entity kmw(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = kmf(var2);
      Vec3d var5 = var2.getEyePos();
      Vec3d var6 = var5.add(var2.getRotationVec(1.0F).multiply(var3));
      double var7 = var5.squaredDistanceTo(kmj(var1, var2, var5, var6));
      Entity var9 = null;
      double var10 = Double.MAX_VALUE;

      for (Entity var13 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3 + 1.0), var2x -> this.kmx(var1, var2x))) {
         Box var14 = var13.getBoundingBox().expand(var13.getTargetingMargin());
         Vec3d var15 = var14.contains(var5) ? var5 : var14.raycast(var5, var6).orElse(null);
         if (var15 != null) {
            double var16 = var5.squaredDistanceTo(var15);
            if (var16 <= var7 && var16 < var10) {
               var9 = var13;
               var10 = var16;
               this.klo = var15;
            }
         }
      }

      return var9;
   }

   private boolean kmx(MinecraftClient var1, Entity var2) {
      if (var2 != null && var2 != var1.player) {
         if (!(var2 instanceof LivingEntity var3 && var3.isAlive() && var2.isAttackable())) {
            return false;
         } else if (this.klm != null) {
            return this.klm.test(var2);
         } else {
            return !(var2 instanceof PlayerEntity) ? this.kjz.get() : this.kjy.get() && !hhf.protects(var2);
         }
      } else {
         return false;
      }
   }
}
