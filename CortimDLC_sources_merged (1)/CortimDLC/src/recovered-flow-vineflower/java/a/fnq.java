package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.common.SyncedClientOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameMode;

final class fnq {
   static final String NAME = a.c(-1790195458, "좿네㯴ꖝ\u2e7f꣣ካ");
   static final double fnr = 3.0;
   static final float fns = 30.0F;
   static volatile boolean active;
   static volatile double aggression;
   static volatile boolean jumping;
   static volatile boolean strafing;
   static volatile int hits;
   static volatile int critHits;
   static volatile int spawned;
   static volatile int orbit;
   static volatile double orbitMin = 2.6;
   static volatile double orbitMax = 2.8;
   static volatile double orbitRadiusSum;
   static volatile double orbitTurnSum;
   static volatile int orbitTicks;
   static ServerPlayerEntity fnt;
   static fux fnu;
   static UUID fnv;
   static boolean fnw;
   static final Random fnx = new Random(5L);
   static int fny;
   static float fnz;
   static int foa;
   static float fob;
   static float foc;
   static int fod;
   static int foe = 1;
   static int fof;
   static double fog = Double.NaN;
   static double foh = 2.5;
   static double foi = Double.NaN;

   fnq() {
   }

   static void spawn(MinecraftServer var0, UUID var1, double var2, double var4, double var6) {
      if (!fnw) {
         fnw = true;
         ServerTickEvents.END_SERVER_TICK.register(fnq::fol);
      }

      fnv = var1;
      ServerWorld var8 = var0.getOverworld();
      UUID var9 = UUID.nameUUIDFromBytes(a.c(-425270718, "\ue218鮀ᅓ輨Ӻ艌㠔뇐⾳ꔏ⋄\ud8a9噩쾐䖿썤礨\uf6e1汧\uea1b揷").getBytes(StandardCharsets.UTF_8));
      GameProfile var10 = new GameProfile(var9, a.d("⊺嬡퇱侘쑺䋦\uf8ae", 825027198, -1867593595));
      ServerPlayerEntity var11 = new ServerPlayerEntity(var0, var8, var10, SyncedClientOptions.createDefault());
      var11.refreshPositionAndAngles(var2, var4, var6, 90.0F, 0.0F);
      fnu = new fux();
      var0.getPlayerManager().onPlayerConnect(fnu, var11, new ConnectedClientData(var10, 0, var11.getClientOptions(), false));
      var11.changeGameMode(GameMode.SURVIVAL);
      var11.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(1024.0);
      var11.setHealth(1024.0F);
      var11.getInventory().setStack(0, new ItemStack(Items.DIAMOND_SWORD));
      var11.getInventory().setSelectedSlot(0);
      fnt = var11;
      spawned = var11.getId();
   }

   static void fol(MinecraftServer var0) {
      if (fnt != null) {
         fnu.drain();
         if (fnt.isRemoved()) {
            fnt = null;
         } else {
            fnt.getHungerManager().setFoodLevel(20);
            if (fnt.getHealth() < 600.0F) {
               fnt.setHealth(1024.0F);
            }

            ServerPlayerEntity var1 = fnv == null ? null : var0.getPlayerManager().getPlayer(fnv);
            if (var1 != null && active && orbit != 0) {
               fom(var1);
            } else if (var1 != null && active) {
               fon(var1);
            } else {
               fnt.forwardSpeed = 0.0F;
               fnt.sidewaysSpeed = 0.0F;
               fnt.setJumping(false);
               fnt.setSprinting(false);
            }

            double var2 = fnt.getY();
            fnt.playerTick();
            double var4 = fnt.getY() - var2;
            if (fnt.isOnGround() || var4 > 0.0) {
               fnt.fallDistance = 0.0;
            } else if (var4 < 0.0) {
               fnt.fallDistance -= var4;
            }
         }
      }
   }

   static void fom(ServerPlayerEntity var0) {
      if (--fof <= 0) {
         fof = 25 + fnx.nextInt(60);
         foe = fnx.nextBoolean() ? 1 : -1;
      }

      double var1 = var0.getX() - fnt.getX();
      double var3 = var0.getZ() - fnt.getZ();
      double var5 = Math.max(0.001, Math.hypot(var1, var3));
      float var7 = (float)Math.toDegrees(Math.atan2(var3, var1)) - 90.0F;
      double var8 = MathHelper.clamp((var5 - (orbitMin + orbitMax) * 0.5) / 0.3, -1.0, 1.0);
      double var10 = Math.toDegrees(Math.atan2(-var3, -var1));
      if (!Double.isNaN(fog)) {
         orbitTurnSum = orbitTurnSum + Math.abs(MathHelper.wrapDegrees(var10 - fog));
         orbitRadiusSum += var5;
         orbitTicks++;
      }

      fog = var10;
      float var12;
      if (orbit == 1) {
         var12 = var7;
         fnt.forwardSpeed = (float)var8;
         fnt.sidewaysSpeed = foe;
         fnt.setSprinting(false);
      } else {
         foi = Double.isNaN(foi) ? var5 : foi + (var5 - foi) * 0.02;
         double var13 = (orbitMin + orbitMax) * 0.5;
         foh = MathHelper.clamp(foh + (var13 - foi) * 0.01, 1.6, var13);
         double var15 = MathHelper.clamp((var5 - foh) / 0.25, -1.0, 1.0);
         var12 = var7 + foe * (float)(90.0 - var15 * 60.0);
         fnt.forwardSpeed = 1.0F;
         fnt.sidewaysSpeed = 0.0F;
         fnt.setSprinting(true);
      }

      Vec3d var22 = fnt.getEyePos();
      double var14 = var0.getEyeY() - var22.y;
      fnt.setYaw(var12);
      fnt.setHeadYaw(orbit == 1 ? var12 : var7);
      fnt.setBodyYaw(var12);
      fnt.setPitch((float)(-Math.toDegrees(Math.atan2(var14, var5))));
      fnt.setJumping(jumping);
      if (!(aggression <= 0.0)) {
         if (fod > 0) {
            fod--;
         }

         double var16 = var0.getBoundingBox().squaredMagnitude(var22);
         boolean var18 = fnt.fallDistance > 0.0 && !fnt.isOnGround();
         boolean var19 = var18 || fnx.nextDouble() < aggression * 0.08;
         if (var16 <= 9.0 && fnt.getAttackCooldownProgress(0.5F) > 0.9F && fod == 0 && var19 && fnx.nextDouble() < 0.2 + 0.8 * aggression) {
            boolean var20 = fnt.isSprinting();
            if (var18) {
               fnt.setSprinting(false);
            }

            boolean var21 = var18 && !fnt.isSprinting();
            fnt.attack(var0);
            fnt.swingHand(Hand.MAIN_HAND);
            hits++;
            if (var21) {
               critHits++;
            }

            fnt.setSprinting(var20);
            fod = aggression < 0.5 ? 10 + fnx.nextInt(20) : 0;
         }
      }
   }

   static void fon(ServerPlayerEntity var0) {
      if (--foa <= 0) {
         foa = 5 + fnx.nextInt(12);
         fob = (float)fnx.nextGaussian() * 5.0F;
         foc = 0.7F + fnx.nextFloat() * 0.8F;
      }

      Vec3d var1 = fnt.getEyePos();
      Vec3d var2 = var0.getEntityPos().add(0.0, foc, 0.0);
      double var3 = var2.x - var1.x;
      double var5 = var2.y - var1.y;
      double var7 = var2.z - var1.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)(MathHelper.atan2(var7, var3) * 180.0F / (float)Math.PI) - 90.0F + fob;
      float var12 = (float)(-(MathHelper.atan2(var5, var9) * 180.0F / (float)Math.PI));
      float var13 = fnt.getYaw() + MathHelper.clamp(MathHelper.wrapDegrees(var11 - fnt.getYaw()), -30.0F, 30.0F);
      float var14 = MathHelper.clamp(fnt.getPitch() + MathHelper.clamp(var12 - fnt.getPitch(), -20.0F, 20.0F), -90.0F, 90.0F);
      fnt.setYaw(var13);
      fnt.setHeadYaw(var13);
      fnt.setBodyYaw(var13);
      fnt.setPitch(var14);
      if (--fny <= 0) {
         fny = 10 + fnx.nextInt(30);
         int var15 = fnx.nextInt(3);
         fnz = var15 == 0 ? 0.0F : (var15 == 1 ? 1.0F : -1.0F);
      }

      float var24 = var9 > 2.7 ? 1.0F : (var9 < 1.5 ? -0.7F : 0.3F);
      fnt.forwardSpeed = var24;
      fnt.sidewaysSpeed = strafing ? fnz : 0.0F;
      fnt.setJumping(jumping);
      boolean var16 = var24 > 0.5F && var9 > 2.2;
      double var17 = var0.getBoundingBox().squaredMagnitude(var1);
      float var19 = fnt.getAttackCooldownProgress(0.5F);
      boolean var20 = fnt.fallDistance > 0.0 && !fnt.isOnGround();
      float var21 = Math.abs(MathHelper.wrapDegrees(var11 - fob - var13));
      if (fod > 0) {
         fod--;
      }

      boolean var22 = var20 || !jumping || fnx.nextDouble() < aggression * 0.08;
      if (var17 <= 9.0 && var19 > 0.9F && var21 < 30.0F && fod == 0 && var22 && fnx.nextDouble() < 0.2 + 0.8 * aggression) {
         if (var20) {
            var16 = false;
         }

         fnt.setSprinting(var16);
         boolean var23 = var20 && !fnt.isSprinting();
         fnt.attack(var0);
         fnt.swingHand(Hand.MAIN_HAND);
         hits++;
         if (var23) {
            critHits++;
         }

         fod = aggression < 0.5 ? 10 + fnx.nextInt(20) : 0;
      } else {
         fnt.setSprinting(var16);
      }
   }
}
