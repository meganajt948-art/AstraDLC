package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttackRangeComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
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

public class lgc extends kfe {
   private final vlv lgd = this.add(
      new vlv(a.d("䃠㥠뎨ⷄꘔ", 448129708, -410670582), a.b("⼁嚎\udc51䈳짢", -1905053865), a.d("ꗙ\udc56嚉죫䌺", 1286650616, 2056396663), a.d("쟀빘㒋", 359545675, 885062855))
   );
   private final vkl lge = this.add(new vkl(a.c(1364002008, "ҏ紜\uf7d8榨\ue272擉\ude8d"), true));
   private final vkl lgf = this.add(new vkl(a.c(-1166832502, "賕\uf547羖\ue1fc樬\uec87嚀\udf23䅫쯌䰉뙩"), true));
   private final vkl lgg = this.add(new vkl(a.c(1878724242, "໖睋ﶚ揭\ue80c溃퓜崿썻"), true));
   private final vmc lgh = this.add(new vmc(a.b("\u1289欏\ue1d8羫\uf46b狇좒䅢", 275845843), 0.0, 0.0, 500.0, 10.0).suffix(a.d("␒嶽", 1749851769, -156124668)));
   private final vmc lgi = this.add(new vmc(a.d("齭\ue6fd氧\uf25b禔", -1164547851, -363661351), 0.0, 0.0, 10.0, 1.0).suffix(a.c(770298799, "폞ꩲ₫뻒㔝")));
   private final vmc lgj = this.add(new vmc(a.c(1822894818, "⪮匲\ud9fb䞍챏䫱\uf0af祘"), 3.0, 2.5, 3.0, 0.05));
   private final vkl lgk = this.add(new vkl(a.c(1691564813, "㭚䋗젉噠\uddab嬍\ue15f"), true));
   private final vkl lgl = this.add(new vkl(a.c(-1694340878, "梻ᄨ鯶֖"), true));
   private final vkl lgm = this.add(new vkl(a.b("ﴫ蒦\u0e6f逃ᯎ鵭✱꺈ゑ먴㷼잁䥝탦媢", -1106510480), true));
   private static final float lgn = 0.9F;
   private static final double lgo = 1.5;
   private static final int lgp = 2;
   private static final int lgq = 10;
   private static final int lgr = 2;
   private static final int lgs = 14;
   private static final int lgt = 18;
   private static final int lgu = 30;
   private static final int lgv = 4;
   private static final int lgw = 26;
   private static final int lgx = 2;
   private static final int lgy = 7;
   private static final double lgz = 0.16;
   private static final int lha = 10;
   private static final double lhb = 0.6;
   private static final double lhc = 0.766;
   private static final double lhd = 0.1;
   private static final double lhe = 1.5;
   private static final double lhf = 0.1;
   private static final Field lhg = vxr.find(
      MinecraftClient.class,
      a.d("䥢ヘ먚\u2431꾥⤐鍄᪾蓧็覇珱ﴴ擟\ueec1栿퉽嶾윍䅰죫늸㰊", -1598645460, -767897033),
      a.d("쑫뷕㜊ꥲ⊭ꐧḚ韭ল茅", 1698091193, 1554322622),
      a.d("౫", 1127164230, -1823201947)
   );
   private static final Field lhh = vxr.find(
      LivingEntity.class, a.d("\ue8c5酿ᮽ薖ข袷㋣묙╀꿠⠠퉖岓앸佦즘珚ﰙ暪\ue0d7楎ጝ鶭ٵ", 1060335984, -419653181), a.c(292519284, "紘Ҧ蹹ခ鯞ᵔꝮ⺛냄㩿"), a.d("⫵", -919185265, 1639805490)
   );
   private static final Field lhi = vxr.find(
      KeyBinding.class, a.d("俏㙵벷⊜꤈⾽闩ᰓ艊࣪輪畜ﮙ扲\ue86c溒퓐嬓솠䟝칆됔㪣", 658182611, -1007985051), a.b("\ueaa2錜ᧃ螻\u0c64諮ビ뤥❺귌", -640881970), a.d("ᥤ", 1480884821, 1875549049)
   );
   private static lgc lhj;
   private final wdt lhk = new wdt();
   private final ktf lhl = new ktf();
   private int lhm;
   private int lhn;
   private int lho;
   private int lhp;
   private int lhq = 1;
   private int lhr;
   private int lhs;
   private int lht;
   private boolean lhu;
   private Entity lhv;
   private int lhw = 10;
   private Entity lhx;
   private Vec3d lhy;
   private int lhz = 1000;
   private int lia;
   private boolean lib;
   private boolean lic;
   private boolean lid;
   private int lie;
   private boolean lif = true;
   private boolean lig;
   private int lih;
   private int lii = -1000;
   private boolean lij;
   private int lik = -1000;
   private double lil = 2.0;

   public lgc() {
      super(a.b("잓븄㓌ꪳⅤꟗᶓ鑒ਠ肊", 1598736333), a.b("癒࿂蔌᭺郾ᘛ걔▨뮲ㅗ뚑䳳숱宂퇀坥\ued7f抵\uf80c繜\uf7bc趿͕颒ỷ鐡ⷀꏒ㤴뽸㓗쨆䁒\ud9aa忱핛", -990480834), kfa.COMBAT);
      lhj = this;
      this.lge.visibleWhen(() -> this.lgd.is(a.b("碑菄छ靹Შ", 652671517)));
   }

   static boolean moduleOn() {
      return lhj != null && lhj.isEnabled();
   }

   @Override
   protected void onEnable() {
      if (this.mc.player != null) {
         this.lhl.sync(this.mc.player);
         this.lic = wdt.serverSprinting(this.mc.player);
      }

      this.lia = wee.count();
      this.lhz = 1000;
      this.lib = false;
      this.lid = false;
      this.lie = 0;
      this.lht = 0;
      this.lii = -1000;
      this.lik = -1000;
      this.lhp = liy();
      this.lhq = liz();
      this.ljr();
   }

   @Override
   protected void onDisable() {
      this.liu(this.mc);
      this.ljr();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      this.lhl.afterMove(var2, var1.world);
      boolean var3 = wdt.serverSprinting(var2);
      if (var3 != this.lic) {
         this.lic = var3;
         this.lib = false;
      }

      boolean var4 = var2.isOnGround();
      if (this.lif && !var4 && this.lig && var2.getY() > var2.lastY + 1.0E-4) {
         if (this.lik > this.lii) {
            this.lil = this.lil * 0.7 + Math.min(10, this.lhm - this.lik) * 0.3;
         }

         this.lii = this.lhm;
         this.lij = this.lhu || (this.lht & 1) != 0;
      } else if (!this.lif && var4) {
         this.lik = this.lhm;
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.player;
      this.lhm++;
      if (this.lhn > 0) {
         this.lhn--;
      }

      if (this.lhw < 10) {
         this.lhw++;
      }

      wee.ensure(var1);
      int var3 = wee.count();
      if (var3 != this.lia) {
         this.lia = var3;
         this.lhz = 1;
      } else if (this.lhz < 1000) {
         this.lhz++;
      }

      boolean var4 = var2.isOnGround();
      this.lih = var4 ? Math.min(this.lih + 1, 1000) : 0;
      this.lif = var4;
      this.lig = var1.options.jumpKey.isPressed();
      var1.gameRenderer.updateCrosshairTarget(1.0F);
      if (this.ljq(var1, var2)) {
         this.liu(var1);
         this.ljr();
      } else {
         Entity var5 = this.ljt(var1);
         boolean var6 = var5 != null || this.ljb(var1, var2);
         this.lhu = Integer.bitCount(this.lht) >= 2;
         this.lht = (this.lht << 1 | (var6 ? 1 : 0)) & 65535;
         boolean var7 = this.lji(var5);
         boolean var8 = this.lgg.get() && var2.getMainHandStack().isOf(Items.MACE);
         boolean var9 = wdt.serverSprinting(var2) && !this.lib;
         boolean var10 = this.lgf.get();
         boolean var11 = this.lgd.is(a.b("罿۰谯ቍ馜", -1413644503)) && !var8 && this.ljo(var1, var2) && (var10 || !var9);
         this.lhl.predict(var2, var1.world, var1.options.jumpKey.isPressed(), vxr.getInt(lhh, var2, 0), lxp.active());
         int var12 = var11 ? this.lio(var2, var9) : -1;
         boolean var13 = var11 && this.lge.get() && this.lip(var1, var2, var4);
         boolean var14 = var5 != null && var7 && this.lhn == 0;
         if (var14) {
            Vec3d var15 = this.lhx != null ? this.lhy : var1.crosshairTarget.getPos();
            ljj(var1);
            var14 = ljk(var1, var2, var15) && var2.getEyePos().squaredDistanceTo(var15) <= this.lgj.get() * this.lgj.get();
         }

         boolean var21 = this.liv(var2, 0);
         if (var14 && var21) {
            this.lho++;
         }

         boolean var16 = false;
         if (var14) {
            if (var8) {
               var16 = !this.ljm(var5) && this.ljn(var1, var2) && this.lhl.airAt(0) && this.lhl.fallAt(0) > 1.5 && (var21 || this.lhl.landsWithin(0, 2));
            } else if (!var11) {
               var16 = var21 && this.lis(var2) && this.lie == 0;
            } else if (var12 == 0) {
               var16 = true;
            } else if (var21) {
               boolean var17 = !this.lja(var2, var5, var12 < 0 ? 4 : var12) && !this.ljc(var2, var5);
               boolean var18 = var12 > 0 && (var12 <= 1 || this.lhu) && var12 <= 14 && var17;
               boolean var19 = var12 < 0 && var13 && this.lhu && var17;
               boolean var20 = this.lho <= 18 || this.lho <= 30 && var13 && !var9 && this.lhl.serverGroundAt(0);
               if ((var18 || var19) && var20) {
                  var16 = false;
               } else if (this.lie != 0) {
                  var16 = false;
               } else if (this.lir(var1, var2, var10) && this.lhu && !this.lja(var2, var5, 2)) {
                  this.lie = 1;
               } else {
                  var16 = this.lis(var2) || this.lho > 18;
               }
            }
         }

         if (!var16
            && this.lie == 0
            && !this.lid
            && !var8
            && this.lir(var1, var2, var10)
            && var12 < 0
            && !var13
            && this.liv(var2, 2)
            && !this.liv(var2, 1)
            && (var5 != null || this.lhu)) {
            this.lie = 1;
         }

         if (this.lid) {
            this.lid = var11 && var10 && var12 >= 0 && var12 <= Math.max(this.lhq, 1) && (var5 != null || this.lhu || var12 <= 1 && this.ljd(var1, var2));
         } else if (var11 && var10 && var9 && var12 >= 1 && var12 <= this.lhq && this.lie == 0) {
            this.lid = var5 != null || this.lhu || this.lge.get() && this.ljd(var1, var2);
         }

         if (var16) {
            this.lit(var1, var2, var5);
            this.lid = false;
         }

         if (!this.lid && this.lie != 1) {
            this.lhk.release(var1);
         } else {
            this.lhk.hold(var1);
         }

         if (this.lie == 1) {
            this.lie = 2;
         } else if (this.lie == 2) {
            this.lie = 0;
         }
      }
   }

   private int lio(ClientPlayerEntity var1, boolean var2) {
      int var3 = var2 ? 1 : 0;
      int var4 = -1;
      int var5 = -1;
      int var6 = -1;

      for (int var7 = var3; var7 <= 20; var7++) {
         if (var7 == 20 || var7 > var3 && this.lhl.airAt(var7 - 1) && !this.lhl.airAt(var7)) {
            if (var4 >= 0) {
               return var4;
            }

            if (var6 >= 0 || var7 == 20) {
               return var6;
            }
         } else if (this.lhl.critAt(var7) && this.liv(var1, var7)) {
            if (!this.lhl.safeAt(var7)) {
               if (var6 < 0) {
                  var6 = var7;
               }
            } else if (var4 < 0) {
               var4 = var7;
               if (this.liw(var1, var7) >= 1.0F) {
                  return var7;
               }
            } else {
               if (var5 >= 0) {
                  return var5;
               }

               if (this.liw(var1, var7) >= 1.0F) {
                  var5 = var7;
               }
            }
         }
      }

      return -1;
   }

   private boolean lip(MinecraftClient var1, ClientPlayerEntity var2, boolean var3) {
      return this.lij && this.lhm - this.lii <= 26 && !var2.isSneaking() && !var2.isTouchingWater() && (!var3 || this.lih <= this.liq())
         ? ksp.headroom(var2, var1.world, 0.16) >= 0.16
         : false;
   }

   private int liq() {
      return MathHelper.clamp((int)Math.ceil(this.lil) + 2, 2, 7);
   }

   private boolean lir(MinecraftClient var1, ClientPlayerEntity var2, boolean var3) {
      return this.lib && var3 && var2.isSprinting() && !wdt.anyHeld() && (!var2.isOnGround() || !var1.options.jumpKey.isPressed());
   }

   private boolean lis(ClientPlayerEntity var1) {
      return !this.lhu || this.liw(var1, -this.lhp) >= 1.0F;
   }

   private void lit(MinecraftClient var1, ClientPlayerEntity var2, Entity var3) {
      if (wdt.serverSprinting(var2) && !this.lib && this.liv(var2, 0) && !(var3 instanceof LivingEntity var4 && (var4.hurtTime > 0 || var4.isBlocking()))) {
         this.lib = true;
      }

      if (this.lhx != null) {
         var1.interactionManager.attackEntity(var2, this.lhx);
         var2.swingHand(Hand.MAIN_HAND);
      } else {
         lix(var1);
      }

      this.lhv = var3;
      this.lhw = 0;
      this.lho = 0;
      this.lhn = this.lgi.getInt();
      this.lhp = liy();
      this.lhq = liz();
   }

   private void liu(MinecraftClient var1) {
      this.lhk.release(var1);
      this.lid = false;
      this.lie = 0;
   }

   private boolean liv(ClientPlayerEntity var1, int var2) {
      return this.liw(var1, var2) > 0.9F;
   }

   private float liw(ClientPlayerEntity var1, int var2) {
      float var3 = MathHelper.clamp((this.lhz + 0.5F + var2) / var1.getAttackCooldownProgressPerTick(), 0.0F, 1.0F);
      return Math.min(var1.getAttackCooldownProgress(0.5F + var2), var3);
   }

   private static void lix(MinecraftClient var0) {
      KeyBinding var1 = var0.options.attackKey;
      int var2 = vxr.getInt(lhi, var1, -1);
      if (var2 <= 0) {
         if (var2 != 0 || !vxr.setInt(lhi, var1, 1)) {
            Key var3 = KeyBindingHelper.getBoundKeyOf(var1);
            if (!var3.equals(InputUtil.UNKNOWN_KEY)) {
               KeyBinding.onKeyPressed(var3);
            }
         }
      }
   }

   private static int liy() {
      return ThreadLocalRandom.current().nextDouble() < 0.2 ? 1 : 0;
   }

   private static int liz() {
      return ThreadLocalRandom.current().nextDouble() < 0.3 ? 2 : 1;
   }

   private boolean lja(ClientPlayerEntity var1, Entity var2, int var3) {
      int var4 = Math.min(var3, 4);
      double var5 = Math.min(ljl(var1), this.lgj.get());
      Vec3d var7 = var1.getEyePos().add(this.lhl.offsetAt(var4));
      Box var8 = var2.getBoundingBox().offset((var2.getX() - var2.lastX) * var4, 0.0, (var2.getZ() - var2.lastZ) * var4);
      return var8.squaredMagnitude(var7) > var5 * var5;
   }

   private boolean ljb(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = Math.min(ljl(var2), this.lgj.get()) + 1.5;
      Vec3d var5 = var2.getEyePos();
      Vec3d var6 = var5.add(var2.getRotationVec(1.0F).multiply(var3));
      Vec3d var7 = ljg(var1, var2, var5, var6);

      for (Entity var9 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3 + 1.0), var2x -> this.ljv(var1, var2x))) {
         if (ljh(var9.getBoundingBox().expand(var9.getTargetingMargin()), var5, var6, var7)) {
            return true;
         }
      }

      return false;
   }

   private boolean ljc(ClientPlayerEntity var1, Entity var2) {
      float var3 = 2.0F * var1.getYaw() - var1.lastYaw;
      float var4 = MathHelper.clamp(2.0F * var1.getPitch() - var1.lastPitch, -90.0F, 90.0F);
      Vec3d var5 = var1.getEyePos().add(this.lhl.offsetAt(1));
      Vec3d var6 = var5.add(Vec3d.fromPolar(var4, var3).multiply(Math.min(ljl(var1), this.lgj.get())));
      Box var7 = var2.getBoundingBox()
         .offset(var2.getX() - var2.lastX, var2.getY() - var2.lastY, var2.getZ() - var2.lastZ)
         .expand(var2.getTargetingMargin() + 0.1);
      return !var7.contains(var5) && var7.raycast(var5, var6).isEmpty();
   }

   private boolean ljd(MinecraftClient var1, ClientPlayerEntity var2) {
      return this.lje(var1, var2) || this.ljf(var1, var2);
   }

   private boolean lje(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = Math.min(ljl(var2), this.lgj.get()) + 0.6;
      Vec3d var5 = var2.getEyePos();
      Vec3d var6 = var2.getRotationVec(1.0F);

      for (Entity var8 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3 + 1.0), var2x -> this.ljv(var1, var2x))) {
         Box var9 = var8.getBoundingBox();
         if (!(var9.squaredMagnitude(var5) > var3 * var3) && var9.getCenter().subtract(var5).normalize().dotProduct(var6) >= 0.766) {
            return true;
         }
      }

      return false;
   }

   private boolean ljf(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = ljl(var2);
      Vec3d var5 = var2.getEyePos();
      Vec3d var6 = var5.add(var2.getRotationVec(1.0F).multiply(var3));
      float var7 = MathHelper.clamp(2.0F * var2.getPitch() - var2.lastPitch, -90.0F, 90.0F);
      float var8 = 2.0F * var2.getYaw() - var2.lastYaw;
      Vec3d var9 = var5.add(Vec3d.fromPolar(var7, var8).multiply(var3));
      Vec3d var10 = ljg(var1, var2, var5, var6);
      Vec3d var11 = ljg(var1, var2, var5, var9);

      for (Entity var13 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3 + 2.0), var2x -> this.ljv(var1, var2x))) {
         Box var14 = var13.getBoundingBox();
         Box var15 = var14.union(var14.offset(var13.getX() - var13.lastX, var13.getY() - var13.lastY, var13.getZ() - var13.lastZ)).expand(0.1);
         if (ljh(var15, var5, var6, var10) || ljh(var15, var5, var9, var11)) {
            return true;
         }
      }

      return false;
   }

   private static Vec3d ljg(MinecraftClient var0, ClientPlayerEntity var1, Vec3d var2, Vec3d var3) {
      BlockHitResult var4 = var0.world.raycast(new RaycastContext(var2, var3, ShapeType.OUTLINE, FluidHandling.NONE, var1));
      return var4.getType() == Type.MISS ? var3 : var4.getPos();
   }

   private static boolean ljh(Box var0, Vec3d var1, Vec3d var2, Vec3d var3) {
      if (var0.contains(var1)) {
         return true;
      }

      double var4 = var1.squaredDistanceTo(var3);
      return var0.raycast(var1, var2).filter(var3x -> var1.squaredDistanceTo(var3x) <= var4).isPresent();
   }

   private boolean lji(Entity var1) {
      if (var1 == null) {
         if (++this.lhs > 2) {
            this.lhr = 0;
            this.lho = 0;
         }

         return false;
      } else {
         this.lhs = 0;
         return this.lhr++ * 50L >= (long)this.lgh.get();
      }
   }

   private static void ljj(MinecraftClient var0) {
      if (vxr.getInt(lhg, var0, 0) > 10) {
         vxr.setInt(lhg, var0, 0);
      }
   }

   private static boolean ljk(MinecraftClient var0, ClientPlayerEntity var1, Vec3d var2) {
      if (vxr.getInt(lhg, var0, 0) > 0) {
         return false;
      }

      ItemStack var3 = var1.getMainHandStack();
      if (var1.isBelowMinimumAttackCharge(var3, 0)) {
         return false;
      }

      AttackRangeComponent var4 = var3.get(DataComponentTypes.ATTACK_RANGE);
      return var4 == null || var4.isWithinRange(var1, var2);
   }

   private static double ljl(ClientPlayerEntity var0) {
      AttackRangeComponent var1 = var0.getMainHandStack().get(DataComponentTypes.ATTACK_RANGE);
      return var1 != null ? var1.getEffectiveMaxRange(var0) : var0.getEntityInteractionRange();
   }

   private boolean ljm(Entity var1) {
      return var1 instanceof LivingEntity var2 && var2.hurtTime > 0 || var1 == this.lhv && this.lhw < 10;
   }

   private boolean ljn(MinecraftClient var1, ClientPlayerEntity var2) {
      return !var2.isClimbing()
         && !var2.isTouchingWater()
         && !var2.isInLava()
         && !var2.hasVehicle()
         && !var2.isGliding()
         && !var2.getAbilities().flying
         && !var2.inPowderSnow
         && !var2.hasStatusEffect(StatusEffects.LEVITATION)
         && !var2.hasStatusEffect(StatusEffects.SLOW_FALLING)
         && var1.world.getStatesInBox(var2.getBoundingBox().contract(1.0E-7)).noneMatch(lgc::ljp);
   }

   private boolean ljo(MinecraftClient var1, ClientPlayerEntity var2) {
      return !var2.hasStatusEffect(StatusEffects.BLINDNESS) && this.ljn(var1, var2);
   }

   private static boolean ljp(BlockState var0) {
      return var0.isOf(Blocks.COBWEB) || var0.isOf(Blocks.SWEET_BERRY_BUSH) || var0.isOf(Blocks.POWDER_SNOW);
   }

   private boolean ljq(MinecraftClient var1, ClientPlayerEntity var2) {
      return var1.currentScreen != null
         || var2.isSpectator()
         || !var2.isAlive()
         || var2.isUsingItem()
         || var2.isRiding()
         || this.ljs(var1)
         || oxw.busy()
         || kvz.busy()
         || nuo.busy() && !ljw(var2)
         || kmy.busy()
         || nfl.busy()
         || lqq.busy();
   }

   private void ljr() {
      this.lhr = 0;
      this.lhs = 0;
      this.lho = 0;
      this.lht = 0;
   }

   private boolean ljs(MinecraftClient var1) {
      return var1.interactionManager != null && var1.interactionManager.isBreakingBlock()
         ? true
         : var1.options.attackKey.isPressed() && var1.crosshairTarget != null && var1.crosshairTarget.getType() == Type.BLOCK;
   }

   private Entity ljt(MinecraftClient var1) {
      this.lhx = null;
      HitResult var2 = var1.crosshairTarget;
      if (var2 != null && var2.getType() == Type.ENTITY) {
         Entity var3 = ((EntityHitResult)var2).getEntity();
         if (this.ljv(var1, var3)) {
            return var3;
         } else if (this.lgm.get() && var3 instanceof PlayerEntity && hhf.isFriend(var3)) {
            this.lhx = this.lju(var1, var1.player);
            return this.lhx;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private Entity lju(MinecraftClient var1, ClientPlayerEntity var2) {
      double var3 = ljl(var2);
      Vec3d var5 = var2.getEyePos();
      Vec3d var6 = var5.add(var2.getRotationVec(1.0F).multiply(var3));
      double var7 = var5.squaredDistanceTo(ljg(var1, var2, var5, var6));
      Entity var9 = null;
      double var10 = Double.MAX_VALUE;

      for (Entity var13 : var1.world.getOtherEntities(var2, var2.getBoundingBox().expand(var3 + 1.0), var2x -> this.ljv(var1, var2x))) {
         Box var14 = var13.getBoundingBox().expand(var13.getTargetingMargin());
         Vec3d var15 = var14.contains(var5) ? var5 : var14.raycast(var5, var6).orElse(null);
         if (var15 != null) {
            double var16 = var5.squaredDistanceTo(var15);
            if (var16 <= var7 && var16 < var10) {
               var9 = var13;
               var10 = var16;
               this.lhy = var15;
            }
         }
      }

      return var9;
   }

   private boolean ljv(MinecraftClient var1, Entity var2) {
      if (var2 != null && var2 != var1.player) {
         if (!(var2 instanceof LivingEntity var3 && var3.isAlive() && var2.isAttackable())) {
            return false;
         } else {
            return !(var2 instanceof PlayerEntity) ? this.lgl.get() : this.lgk.get() && !hhf.protects(var2);
         }
      } else {
         return false;
      }
   }

   private static boolean ljw(ClientPlayerEntity var0) {
      ItemStack var1 = var0.getMainHandStack();
      return var1.isIn(ItemTags.SWORDS) || var1.isIn(ItemTags.AXES) || var1.isOf(Items.MACE) || var1.isOf(Items.TRIDENT);
   }
}
