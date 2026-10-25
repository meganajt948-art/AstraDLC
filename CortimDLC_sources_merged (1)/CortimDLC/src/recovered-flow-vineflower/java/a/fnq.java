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
   private static final double fnr = 3.0;
   private static final float fns = 30.0F;
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
   private static ServerPlayerEntity fnt;
   private static fux fnu;
   private static UUID fnv;
   private static boolean fnw;
   private static final Random fnx = new Random(5L);
   private static int fny;
   private static float fnz;
   private static int foa;
   private static float fob;
   private static float foc;
   private static int fod;
   private static int foe = 1;
   private static int fof;
   private static double fog = Double.NaN;
   private static double foh = 2.5;
   private static double foi = Double.NaN;

   private fnq() {
   }

   static void spawn(MinecraftServer var0, UUID var1, double var2, double var4, double var6) {
      if (!fnw) {
         fnw = true;
         ServerTickEvents.END_SERVER_TICK.register(fnq::fol);
      }

      fnv = var1;
      ServerWorld var8 = var0.method_30002();
      UUID var9 = UUID.nameUUIDFromBytes(a.c(-425270718, "\ue218鮀ᅓ輨Ӻ艌㠔뇐⾳ꔏ⋄\ud8a9噩쾐䖿썤礨\uf6e1汧\uea1b揷").getBytes(StandardCharsets.UTF_8));
      GameProfile var10 = new GameProfile(var9, a.d("⊺嬡퇱侘쑺䋦\uf8ae", 825027198, -1867593595));
      ServerPlayerEntity var11 = new ServerPlayerEntity(var0, var8, var10, SyncedClientOptions.method_53821());
      var11.method_5808(var2, var4, var6, 90.0F, 0.0F);
      fnu = new fux();
      var0.method_3760().method_14570(fnu, var11, new ConnectedClientData(var10, 0, var11.method_53823(), false));
      var11.method_7336(GameMode.field_9215);
      var11.method_5996(EntityAttributes.field_23716).method_6192(1024.0);
      var11.method_6033(1024.0F);
      var11.method_31548().method_5447(0, new ItemStack(Items.field_8802));
      var11.method_31548().method_61496(0);
      fnt = var11;
      spawned = var11.method_5628();
   }

   private static void fol(MinecraftServer var0) {
      if (fnt != null) {
         fnu.drain();
         if (fnt.method_31481()) {
            fnt = null;
         } else {
            fnt.method_7344().method_7580(20);
            if (fnt.method_6032() < 600.0F) {
               fnt.method_6033(1024.0F);
            }

            ServerPlayerEntity var1 = fnv == null ? null : var0.method_3760().method_14602(fnv);
            if (var1 != null && active && orbit != 0) {
               fom(var1);
            } else if (var1 != null && active) {
               fon(var1);
            } else {
               fnt.field_6250 = 0.0F;
               fnt.field_6212 = 0.0F;
               fnt.method_6100(false);
               fnt.method_5728(false);
            }

            double var2 = fnt.method_23318();
            fnt.method_14226();
            double var4 = fnt.method_23318() - var2;
            if (fnt.method_24828() || var4 > 0.0) {
               fnt.field_6017 = 0.0;
            } else if (var4 < 0.0) {
               fnt.field_6017 -= var4;
            }
         }
      }
   }

   private static void fom(ServerPlayerEntity var0) {
      if (--fof <= 0) {
         fof = 25 + fnx.nextInt(60);
         foe = fnx.nextBoolean() ? 1 : -1;
      }

      double var1 = var0.method_23317() - fnt.method_23317();
      double var3 = var0.method_23321() - fnt.method_23321();
      double var5 = Math.max(0.001, Math.hypot(var1, var3));
      float var7 = (float)Math.toDegrees(Math.atan2(var3, var1)) - 90.0F;
      double var8 = MathHelper.method_15350((var5 - (orbitMin + orbitMax) * 0.5) / 0.3, -1.0, 1.0);
      double var10 = Math.toDegrees(Math.atan2(-var3, -var1));
      if (!Double.isNaN(fog)) {
         orbitTurnSum = orbitTurnSum + Math.abs(MathHelper.method_15338(var10 - fog));
         orbitRadiusSum += var5;
         orbitTicks++;
      }

      fog = var10;
      float var12;
      if (orbit == 1) {
         var12 = var7;
         fnt.field_6250 = (float)var8;
         fnt.field_6212 = foe;
         fnt.method_5728(false);
      } else {
         foi = Double.isNaN(foi) ? var5 : foi + (var5 - foi) * 0.02;
         double var13 = (orbitMin + orbitMax) * 0.5;
         foh = MathHelper.method_15350(foh + (var13 - foi) * 0.01, 1.6, var13);
         double var15 = MathHelper.method_15350((var5 - foh) / 0.25, -1.0, 1.0);
         var12 = var7 + foe * (float)(90.0 - var15 * 60.0);
         fnt.field_6250 = 1.0F;
         fnt.field_6212 = 0.0F;
         fnt.method_5728(true);
      }

      Vec3d var22 = fnt.method_33571();
      double var14 = var0.method_23320() - var22.field_1351;
      fnt.method_36456(var12);
      fnt.method_5847(orbit == 1 ? var12 : var7);
      fnt.method_5636(var12);
      fnt.method_36457((float)(-Math.toDegrees(Math.atan2(var14, var5))));
      fnt.method_6100(jumping);
      if (!(aggression <= 0.0)) {
         if (fod > 0) {
            fod--;
         }

         double var16 = var0.method_5829().method_49271(var22);
         boolean var18 = fnt.field_6017 > 0.0 && !fnt.method_24828();
         boolean var19 = var18 || fnx.nextDouble() < aggression * 0.08;
         if (var16 <= 9.0 && fnt.method_7261(0.5F) > 0.9F && fod == 0 && var19 && fnx.nextDouble() < 0.2 + 0.8 * aggression) {
            boolean var20 = fnt.method_5624();
            if (var18) {
               fnt.method_5728(false);
            }

            boolean var21 = var18 && !fnt.method_5624();
            fnt.method_7324(var0);
            fnt.method_6104(Hand.field_5808);
            hits++;
            if (var21) {
               critHits++;
            }

            fnt.method_5728(var20);
            fod = aggression < 0.5 ? 10 + fnx.nextInt(20) : 0;
         }
      }
   }

   private static void fon(ServerPlayerEntity var0) {
      if (--foa <= 0) {
         foa = 5 + fnx.nextInt(12);
         fob = (float)fnx.nextGaussian() * 5.0F;
         foc = 0.7F + fnx.nextFloat() * 0.8F;
      }

      Vec3d var1 = fnt.method_33571();
      Vec3d var2 = var0.method_73189().method_1031(0.0, foc, 0.0);
      double var3 = var2.field_1352 - var1.field_1352;
      double var5 = var2.field_1351 - var1.field_1351;
      double var7 = var2.field_1350 - var1.field_1350;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)(MathHelper.method_15349(var7, var3) * 180.0F / (float)Math.PI) - 90.0F + fob;
      float var12 = (float)(-(MathHelper.method_15349(var5, var9) * 180.0F / (float)Math.PI));
      float var13 = fnt.method_36454() + MathHelper.method_15363(MathHelper.method_15393(var11 - fnt.method_36454()), -30.0F, 30.0F);
      float var14 = MathHelper.method_15363(fnt.method_36455() + MathHelper.method_15363(var12 - fnt.method_36455(), -20.0F, 20.0F), -90.0F, 90.0F);
      fnt.method_36456(var13);
      fnt.method_5847(var13);
      fnt.method_5636(var13);
      fnt.method_36457(var14);
      if (--fny <= 0) {
         fny = 10 + fnx.nextInt(30);
         int var15 = fnx.nextInt(3);
         fnz = var15 == 0 ? 0.0F : (var15 == 1 ? 1.0F : -1.0F);
      }

      float var24 = var9 > 2.7 ? 1.0F : (var9 < 1.5 ? -0.7F : 0.3F);
      fnt.field_6250 = var24;
      fnt.field_6212 = strafing ? fnz : 0.0F;
      fnt.method_6100(jumping);
      boolean var16 = var24 > 0.5F && var9 > 2.2;
      double var17 = var0.method_5829().method_49271(var1);
      float var19 = fnt.method_7261(0.5F);
      boolean var20 = fnt.field_6017 > 0.0 && !fnt.method_24828();
      float var21 = Math.abs(MathHelper.method_15393(var11 - fob - var13));
      if (fod > 0) {
         fod--;
      }

      boolean var22 = var20 || !jumping || fnx.nextDouble() < aggression * 0.08;
      if (var17 <= 9.0 && var19 > 0.9F && var21 < 30.0F && fod == 0 && var22 && fnx.nextDouble() < 0.2 + 0.8 * aggression) {
         if (var20) {
            var16 = false;
         }

         fnt.method_5728(var16);
         boolean var23 = var20 && !fnt.method_5624();
         fnt.method_7324(var0);
         fnt.method_6104(Hand.field_5808);
         hits++;
         if (var23) {
            critHits++;
         }

         fod = aggression < 0.5 ? 10 + fnx.nextInt(20) : 0;
      } else {
         fnt.method_5728(var16);
      }
   }
}
