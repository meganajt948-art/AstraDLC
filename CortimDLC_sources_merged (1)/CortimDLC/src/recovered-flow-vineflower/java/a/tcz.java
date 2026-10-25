package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents.After;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;

public final class tcz {
   static final int tda = -789577728;
   static final String[] tdb = new String[]{
      a.d("렴솴䭿픎廍\ud85a戗\uebc4疝", -788012186, 793074463),
      a.c(801353398, "껸흸嶳쏂䠁캖瓘ﴄ捘\ue9f1"),
      a.d("끠짠䌫\udd5a嚙퀎橁\ue381緃\uf76a", -877860424, -602449514),
      a.b("쮅눅㣎ꚿ\u2d7c꯫ᆣ顣غ貓", -1118712885)
   };
   static final List<tkx> tdc = new ArrayList<>();
   static final Random tdd = new Random();
   static tcw tde = tcw.NONE;
   static tiq tdf;
   static tkc tdg;
   static ttl tdh;
   static tyd tdi;
   static kfe tdj;
   static tkc tdk;
   static ClientWorld tdl;
   static Field tdm;
   static boolean tdn;
   static boolean tdo;
   static volatile tct tdp;
   static volatile tiq tdq;

   tcz() {
   }

   public static void install() {
      ClientTickEvents.START_CLIENT_TICK.register(tcz::tea);
      ClientTickEvents.END_CLIENT_TICK.register(tcz::teb);

      try {
         AttackBlockCallback.EVENT.register((AttackBlockCallback)(var0, var1x, var2, var3, var4) -> {
            ttl var5 = tdh;
            MinecraftClient var6 = MinecraftClient.getInstance();
            if (var5 != null && var1x.isClient() && var0 == var6.player && !ejp.isActive()) {
               var5.attack(var6, var3, var4);
            }

            return ActionResult.PASS;
         });
         ClientPlayerBlockBreakEvents.AFTER.register((After)(var0, var1x, var2, var3) -> {
            ttl var4 = tdh;
            if (var4 != null && var1x == MinecraftClient.getInstance().player && !ejp.isActive()) {
               var4.broken(var3);
            }
         });
      } catch (Throwable var1) {
         System.out.println(a.c(320079134, "Ց糤\uf630桊\ue3d8攻\udf7f嚈죛䉷얲㿎넞⢦ꊲ␋鹃ᆒ謥൬蓈ﻌ灤\uebba淒\ue714庯탻䨁챓䟮뤶㌦\uaacd") + var1);
      }
   }

   public static ttl mineRecorder() {
      return tdh;
   }

   public static tyd walkRecorder() {
      return tdi;
   }

   public static boolean walkGuide() {
      return tdi != null && !dry.armed();
   }

   public static void startWalking(tiq var0, String var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var2.player != null && var2.world != null && var0 != null) {
         stop();
         tdw();
         tdf = var0;
         tde = tcw.RECORD;
         tdl = var2.world;
         String var3 = a.b("ꢭ턨寺얐乿죸犸ﭟ攁\uefbb", 1396812006).equals(var1) ? a.b("⻏坊\udd98䏲젝亚\uf4da紽\ue363槙", -1905250684) : a.d("◧屢횰䣚쌧䖽￤", 613483270, 1031153319);
         tdi = new tyd(var0, var3, (float)unit(var2));
         kfe var4 = tee(var3);
         tdj = null;
         if (var4 != null && !var4.isEnabled()) {
            var4.setEnabled(true);
            tdj = var4;
         }
      }
   }

   static String tdt(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      if (var0.currentScreen != null) {
         return a.b("曾Ὗ閝\u0bfb耬ږ", 1756063371);
      } else if (!var0.isWindowFocused()) {
         return a.b("䃘㥠뎿ⷘꘉ", -1324400453);
      } else if (!var1.isAlive() || var1.isSpectator()) {
         return a.b("\udac1ꍱ⦦럒", -2033395039);
      } else {
         return ovh.active() ? a.d("㏛䩾삺廋픚厩\ue9f6", 1038296086, 1988040620) : null;
      }
   }

   public static boolean mining() {
      return tdh != null;
   }

   public static void startMining(tiq var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.player != null && var1.world != null && var0 != null) {
         stop();
         tdw();
         tdf = var0;
         tde = tcw.RECORD;
         tdl = var1.world;
         tdh = new ttl(var0, (float)unit(var1));
      }
   }

   static String tdu(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      if (var0.currentScreen != null) {
         return a.d("쨑뎰㥲꜔ⳃ꩹", -2106492669, -767773849);
      }

      if (!var0.isWindowFocused()) {
         return a.d("䰺㖂뽝℺ꫫ", 367600820, -1607833363);
      }

      if (var1.isAlive() && !var1.isSpectator()) {
         kfe var2 = tee(a.d("櫚፟馍ߧ谒ઇ냓㤩", -10262202, -87489579));
         if (!nfl.busy() && (var2 == null || !var2.isEnabled())) {
            if (lqq.busy()) {
               return a.c(-1481305268, "ጬ檚\ue05a縴\uf5eb獍");
            } else if (ovh.active()) {
               return a.d("혚꾿╻묊ホ뙨ష", -257904309, 1792370480);
            } else {
               return !qof.holdsPickaxe(var1) ? a.c(1821855018, "䵝㓵븬⁕ꮈⴠ靮") : null;
            }
         } else {
            return a.b("酞\ue8fb戩ﱃ瞖\uf123䭷슍", -320958153);
         }
      } else {
         return a.c(-1806067046, "髺\ue34a榝\uf7e9");
      }
   }

   public static tcw mode() {
      return tde;
   }

   public static tiq sessionProfile() {
      return tdf;
   }

   public static tkc recorder() {
      return tdg;
   }

   public static tkc fightRecorder() {
      return tdk;
   }

   public static boolean recording() {
      return tde == tcw.RECORD || tdk != null;
   }

   public static boolean standsOut() {
      return tde != tcw.NONE;
   }

   public static List<tkx> stands() {
      return tdc;
   }

   public static tct job() {
      return tdp;
   }

   public static boolean training() {
      tct var0 = tdp;
      return var0 != null && !var0.done;
   }

   public static void startRecording(tiq var0) {
      tdv(var0, tcw.RECORD);
   }

   public static void startTest(tiq var0) {
      tdv(var0, tcw.TEST);
   }

   static void tdv(tiq var0, tcw var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var2.player != null && var2.world != null && var0 != null) {
         stop();
         tdw();
         tdf = var0;
         tde = var1;
         tdl = var2.world;
         tdx(var2, var0);
         if (var1 == tcw.RECORD) {
            tdg = new tkc(var0, 0, var2.player.getEntityPos(), (float)unit(var2));
         }
      }
   }

   public static void stop() {
      if (tdg != null) {
         tdg.finish();
         tdg = null;
      }

      if (tdh != null) {
         tdh.finish();
         tdh = null;
      }

      if (tdi != null) {
         tdi.finish();
         tdi = null;
         kfe var0 = tdj;
         tdj = null;
         if (var0 != null && var0.isEnabled()) {
            var0.setEnabled(false);
         }
      }

      tdy(MinecraftClient.getInstance());
      tde = tcw.NONE;
      tdf = null;
   }

   static void tdw() {
      if (tdk != null) {
         tdk.finish();
         tdk = null;
      }
   }

   public static double unit(MinecraftClient var0) {
      double var1 = var0.options.getMouseSensitivity().getValue() * 0.6 + 0.2;
      return var1 * var1 * var1 * 8.0 * 0.15;
   }

   static void tdx(MinecraftClient var0, tiq var1) {
      tdy(var0);
      int var2 = var1.standCount();

      for (int var3 = 0; var3 < var2; var3++) {
         tkx var4 = new tkx(var0.world, tdb[var3 % tdb.length], tdd.nextLong(), var1.standMode(), var1.standNear(), var1.standFar(), var1.standSpeed());
         var4.setId(-789577728 - var3);
         var4.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
         var4.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
         var4.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
         var4.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
         var4.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
         var4.relocate(var0.player);
         var0.world.addEntity(var4);
         tdc.add(var4);
      }
   }

   static void tdy(MinecraftClient var0) {
      if (var0.world != null && var0.world == tdl) {
         for (tkx var2 : tdc) {
            if (!var2.isRemoved()) {
               var0.world.removeEntity(var2.getId(), RemovalReason.DISCARDED);
            }
         }
      }

      tdc.clear();
   }

   public static boolean onAttack(PlayerEntity var0, Entity var1, EntityHitResult var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var0 instanceof ClientPlayerEntity var4) {
         Vec3d var5 = var2 != null ? var2.getPos() : var1.getBoundingBox().getCenter();
         if (var1 instanceof tkx var6) {
            if (tdg != null) {
               tdg.hit(var1, var5, var4);
            }

            boolean var7 = var4.fallDistance > 0.0 && !var4.isOnGround() && !var4.isClimbing() && !var4.isTouchingWater() && !var4.isSprinting();
            var6.knock(var4.getEntityPos(), var4.isSprinting());
            var4.resetTicksSince();
            if (var3.world != null) {
               var3.world
                  .playSoundClient(
                     var6.getX(),
                     var6.getEyeY(),
                     var6.getZ(),
                     var7 ? SoundEvents.ENTITY_PLAYER_ATTACK_CRIT : SoundEvents.ENTITY_PLAYER_ATTACK_STRONG,
                     SoundCategory.PLAYERS,
                     0.8F,
                     0.95F + tdd.nextFloat() * 0.1F,
                     false
                  );
               var3.world
                  .playSoundClient(
                     var6.getX(),
                     var6.getEyeY(),
                     var6.getZ(),
                     SoundEvents.ENTITY_PLAYER_HURT,
                     SoundCategory.PLAYERS,
                     0.6F,
                     0.9F + tdd.nextFloat() * 0.2F,
                     false
                  );
               if (var7) {
                  var3.particleManager.addEmitter(var6, ParticleTypes.CRIT);
               }
            }

            return true;
         } else {
            if (tdk != null && teg(var4, var1)) {
               tdk.hit(var1, var5, var4);
            }

            return false;
         }
      } else {
         return false;
      }
   }

   static int tdz(MinecraftClient var0) {
      if (!tdn) {
         tdn = true;
         tdm = vxr.find(
            KeyBinding.class,
            a.d("\udd9aꐠ⻢냉㭝뷨\u07bc蹆ဟ骿ᵿ\ue709槌\uf027稹ﳇ䚅쥆叵했尓♁ꣶ", -779239710, 1212900097),
            a.c(2048388231, "\ueceb镕ᾊ臲ਭ貧㚚뽬ℳꮅ"),
            a.d("Ʃ", 978839039, -2096896994)
         );
      }

      return Math.max(0, vxr.getInt(tdm, var0.options.attackKey, 0));
   }

   static void tea(MinecraftClient var0) {
      if (var0.player != null && var0.currentScreen == null) {
         int var1 = tdg == null && tdk == null ? 0 : tdz(var0);
         if (var1 > 0) {
            if (tdg != null) {
               tdg.presses(var1);
               tdg.aim(var0, tdc);
            }

            if (tdk != null) {
               tdk.presses(var1);
               tdk.aim(var0, teh(var0));
            }
         }
      }
   }

   static void teb(MinecraftClient var0) {
      if ((tdh != null || tdi != null) && dry.armed()) {
         stop();
      }

      if ((tdh != null || tdi != null) && var0.world != null && var0.world != tdl) {
         tdl = var0.world;
      }

      if (var0.world != tdl && tde != tcw.NONE && tdh == null && tdi == null) {
         if (tdg != null) {
            tdg.finish();
            tdg = null;
         }

         tdc.clear();
         tde = tcw.NONE;
         tdf = null;
      }

      if (var0.player != null && var0.world != null) {
         if (tde != tcw.NONE) {
            tec(var0);
         }

         tct var1 = tdp;
         if (var1 != null && var1.done && !var1.applied) {
            var1.applied = true;
            if (var1.mineResult != null) {
               if (lfa.mineProfile() == null) {
                  lfa.activateMine(var1.profile);
               }
            } else if (var1.walkResult != null) {
               if (lfa.walkProfile() == null) {
                  lfa.activateWalk(var1.profile);
               }
            } else if (var1.result != null && var1.aura && kwf.studioProfile() == null) {
               kwf.useStudio(var1.profile);
            } else if (var1.result != null && !var1.aura && lfa.activeProfile() == null) {
               lfa.activate(var1.profile);
            }
         }

         tei(var0);
         if (tdg != null) {
            String var2 = ted(var0);
            if (var2 != null) {
               tdg.pause(var2);
            } else {
               tdg.tick(var0, tdc);
            }
         }

         ttl var5 = tdh;
         if (var5 != null) {
            String var3 = tdu(var0);
            if (var3 != null) {
               var5.pause(var3);
            } else {
               var5.tick(var0);
            }
         }

         tyd var6 = tdi;
         if (var6 != null) {
            String var4 = tdt(var0);
            if (var4 != null) {
               var6.pause(var4);
            } else {
               var6.tick(var0);
            }
         }

         tef(var0);
      } else {
         tdw();
      }
   }

   static void tec(MinecraftClient var0) {
      for (int var1 = 0; var1 < tdc.size(); var1++) {
         tkx var2 = tdc.get(var1);
         if (var2.isRemoved() || var0.world.getEntityById(var2.getId()) != var2) {
            tkx var3 = new tkx(var0.world, tdb[var1 % tdb.length], tdd.nextLong(), tdf.standMode(), tdf.standNear(), tdf.standFar(), tdf.standSpeed());
            var3.setId(-789577728 - var1);

            for (EquipmentSlot var7 : EquipmentSlot.values()) {
               var3.equipStack(var7, var2.getEquippedStack(var7).copy());
            }

            var3.relocate(var0.player);
            var0.world.addEntity(var3);
            tdc.set(var1, var3);
         }
      }
   }

   static String ted(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      if (var0.currentScreen != null) {
         return a.b("王ਪ胨Ẏ镙Ꮳ", -987335682);
      }

      if (!var0.isWindowFocused()) {
         return a.c(-239097764, "\ua83f톇存씿仮");
      }

      if (var1.isAlive() && !var1.isSpectator()) {
         kfe var2 = tee(a.c(168907861, "吝ⶄꝓ㤎닫㑚踓߸馠"));
         if (var2 != null && var2.isEnabled()) {
            return a.b("翻ق貕የ餭ᾜꗕⰾ뉦", 1637842835);
         } else {
            return kmy.busy() ? a.d("\u0b3b犆\uf857映", 549180726, 357097060) : null;
         }
      } else {
         return a.d("ꖩ\udc19囎좺", -382912701, -1206807926);
      }
   }

   static kfe tee(String var0) {
      Flow var1 = Flow.getInstance();
      return var1.getModuleManager() == null ? null : var1.getModuleManager().getByName(var0);
   }

   static void tef(MinecraftClient var0) {
      tiq var1 = lfa.activeProfile();
      boolean var2 = tde == tcw.NONE && var1 != null && var1.fights() && !lfa.turning();
      if (!var2) {
         tdw();
      } else {
         if (tdk != null && tdk.profile != var1) {
            tdw();
         }

         if (tdk == null) {
            tdk = new tkc(var1, 1, var0.player.getEntityPos(), (float)unit(var0));
         }

         String var3 = ted(var0);
         List var4 = teh(var0);
         if (var3 != null) {
            tdk.pause(var3);
         } else if (var4.isEmpty()) {
            tdk.pause(a.c(-516308133, "쌶몊け긩"));
         } else {
            tdk.tick(var0, var4);
         }
      }
   }

   static boolean teg(ClientPlayerEntity var0, Entity var1) {
      return var1 instanceof PlayerEntity var2 && var2 != var0 && var2.isAlive() && !var2.isSpectator() && !(var1 instanceof tkx) && !hhf.protects(var2);
   }

   static List<Entity> teh(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      ArrayList var2 = new ArrayList();

      for (PlayerEntity var4 : var0.world.getPlayers()) {
         if (teg(var1, var4) && var4.squaredDistanceTo(var1) < 64.0) {
            var2.add(var4);
         }
      }

      var2.sort(Comparator.comparingDouble(var1x -> var1x.squaredDistanceTo(var1)));
      return var2.size() > 4 ? new ArrayList<>(var2.subList(0, 4)) : var2;
   }

   static void tei(MinecraftClient var0) {
      int var1 = lfa.stopKey();
      boolean var2 = var0.currentScreen == null && var1 != -1 && vzz.isDown(var0, var1);
      if (var2 && !tdo && tde != tcw.NONE) {
         stop();
      }

      tdo = var2;
   }

   public static void train(tiq var0) {
      if (!training() && var0 != null) {
         if (tde == tcw.RECORD && tdf == var0) {
            stop();
         }

         if (tdk != null && tdk.profile == var0) {
            tdk.save();
         }

         tct var1 = new tct(var0);
         tdp = var1;
         if (var1.mine) {
            tej(var1);
         } else if (var1.walk) {
            tek(var1);
         } else {
            Thread var2 = new Thread(() -> {
               try {
                  vza.flush();
                  var1.progress.phase = a.b("尊▴꽤ㄏ뫉", -1257022356);
                  var0.loadRecordings(true);
                  List var2x = var0.tapes();
                  if (var2x.isEmpty()) {
                     throw new tmt(a.c(1269784160, "帊➺굨㌒"));
                  }

                  tmk var3 = var0.trainerConfig();
                  var3.track = var1.aura;
                  var3.dropOvershoot = !var1.aura && var0.clean();
                  tck var4 = tnl.run(var2x, var3, var1.progress);
                  var0.saveModel(var4, var1.aura);
                  var0.set(var1.aura ? a.d("〴䦑썅崧횿偔\uea01揣ﶴ眂\uf0daપ", -1691500114, 695398903) : a.c(-1162083566, "Ͳ竁\uf019湩\ue5b7捄\ud94d傺컶䑏쎛㧡뜷"), var4.created);
                  var0.save();
                  var1.result = var4;
               } catch (tmt var5) {
                  var1.error = var5.code;
               } catch (Throwable var6) {
                  var1.error = a.c(2119501731, "߃繥\uf4b6櫚\ue110");
                  System.out.println(a.d("対≄ꢇ㛱봻㯅臂࠵陹᳀鬔慢\uefb2瘊ﰞ窩샡伸햎取\uda20ꀯ⺆", 561938874, 783604285) + var6);
                  var6.printStackTrace();
               }

               var1.finished = System.currentTimeMillis();
               var1.done = true;
            }, a.d("甙ಂ虒ᠻ鎩ᔊ꼗⛭뢢㈔뗚俤셧壐튐呩\uee21懻ﭟ", 1784547679, -265651181));
            var2.setDaemon(true);
            var2.setPriority(1);
            var2.start();
         }
      }
   }

   static void tej(tct var0) {
      tiq var1 = var0.profile;
      Thread var2 = new Thread(() -> {
         try {
            vza.flush();
            var0.progress.phase = a.b("엿뱁㚑꣺⌼", -1079786087);
            var1.loadRecordings(true);
            List var2x = var1.mineTapes();
            if (var2x.isEmpty()) {
               throw new tmt(a.c(1184691601, "\uf5fb豋ڙ飣"));
            }

            tmk var3 = var1.trainerConfig();

                        byte var4;
            if (java.util.Objects.equals(var1.quality(), a.d("柢Ṵ钵ૃ") || java.util.Objects.equals(var1.quality(), -972900777) || java.util.Objects.equals(var1.quality(), 1908527607))) {
               var4 = 25;
            }
            else if (java.util.Objects.equals(var1.quality(), a.d("쒜봁㟋") || java.util.Objects.equals(var1.quality(), -16719540) || java.util.Objects.equals(var1.quality(), 1874404766))) {
               var4 = 70;
            }
            else {
               var4 = 45;
            }

                        byte var10;
            if (java.util.Objects.equals(var1.quality(), a.b("듪쵼䞽\ud9cb") || java.util.Objects.equals(var1.quality(), 957854888))) {
               var10 = 12;
            }
            else if (java.util.Objects.equals(var1.quality(), a.d("솺렧㋭") || java.util.Objects.equals(var1.quality(), 1372135260) || java.util.Objects.equals(var1.quality(), 1138679464))) {
               var10 = 30;
            }
            else {
               var10 = 20;
            }
            ttb var12 = tvf.run(var2x, var3, var4, var10, var1.mineBoost(), var0.progress);
            var1.saveMineModel(var12);
            var1.set(a.b("鹿胵ਡ鑛ῇ餬⍹ꪛ㓌빺㦢쏒", 738326817), var12.created);
            var1.save();
            var0.mineResult = var12;
            var0.result = var12.hand;
         } catch (tmt var8) {
            var0.error = var8.code;
         } catch (Throwable var9) {
            var0.error = a.b("\udee7ꝁⶒ돾㠴", -358556025);
            System.out.println(a.d("霠\uee95摁層熩\uf74c䴙쓻媬퀚城궸⍦몐ゅ뙳ఴ菠ᥚ鼊ᚣ注", -589066679, 1291458834) + var9);
            var9.printStackTrace();
         }

         var0.finished = System.currentTimeMillis();
         var0.done = true;
      }, a.c(1464331003, "\uea9a錯᧻螁ఓ諶ィ륁✖궠⩸퀞"));
      var2.setDaemon(true);
      var2.setPriority(1);
      var2.start();
   }

   static void tek(tct var0) {
      tiq var1 = var0.profile;
      Thread var2 = new Thread(() -> {
         try {
            vza.flush();
            var0.progress.phase = a.c(-802955506, "\udf68ꛖⰆ뉭㦫");
            var1.loadRecordings(true);
            List var2x = var1.walkTapes();
            if (var2x.isEmpty()) {
               throw new tmt(a.b("\ufdc8葸ສ郐", 1642266018));
            }
                        byte var3;
            if (java.util.Objects.equals(var1.size(), a.d("堔↛ꭄ㔸뻯") || java.util.Objects.equals(var1.size(), -339022630) || java.util.Objects.equals(var1.size(), 1401926808))) {
               var3 = 48;
            }
            else if (java.util.Objects.equals(var1.size(), a.c(-883173187) || java.util.Objects.equals(var1.size(), "\ud8f4ꅨ⮨뗌㸙"))) {
               var3 = 96;
            }
            else {
               var3 = 64;
            }

                        byte var9;
            if (java.util.Objects.equals(var1.quality(), a.d("煯ࣹ舸ᱎ") || java.util.Objects.equals(var1.quality(), -484582252) || java.util.Objects.equals(var1.quality(), -164319815))) {
               var9 = 25;
            }
            else if (java.util.Objects.equals(var1.quality(), a.d("➃帞퓔") || java.util.Objects.equals(var1.quality(), -1531697587) || java.util.Objects.equals(var1.quality(), 246546816))) {
               var9 = 70;
            }
            else {
               var9 = 45;
            }
            txs var11 = tzy.run(var2x, var3, var9, System.nanoTime(), var1.mirror(), var0.progress);
            var1.saveWalkModel(var11);
            var1.set(a.b("Ṧ柁\ued1f獩\uf8fb縐쑅䶧폰奆\ude9e⓮", 549002781), var11.created);
            var1.save();
            var0.walkResult = var11;
         } catch (tmt var7) {
            var0.error = var7.code;
         } catch (Throwable var8) {
            var0.error = a.d("覌\uf02a竹\ue495潟", -1644937768, 1701426228);
            System.out.println(a.b("ଵ犒\uf84c昺\ueda6歃턖壴욣䰕쯁ㆷ뽩⚟겊⩼逻`蕕̅説\uf0e7", 1607666516) + var8);
            var8.printStackTrace();
         }

         var0.finished = System.currentTimeMillis();
         var0.done = true;
      }, a.d("驚\ue3fd椣\uf755糉館䁹즛埌\udd7a媢ꃄ", 435801118, -549366209));
      var2.setDaemon(true);
      var2.setPriority(1);
      var2.start();
   }

   public static boolean analyzing(tiq var0) {
      return tdq == var0;
   }

   public static void analyze(tiq var0) {
      if (var0 != null && tdq == null) {
         String var1 = var0.dataStamp();
         if (!var1.equals(var0.get(a.c(1091782165, "䙻㿏딉⭭ꃵ☙鱍ᖩ诺Ŗ"), ""))) {
            tdq = var0;
            Thread var2 = new Thread(() -> {
               try {
                  vza.flush();
                  List var2x = var0.tapes();
                  szk var3 = var0.aura() ? szk.track(var2x, false) : szk.build(var2x, var0.clean());
                  var0.set(a.d("Ỻ李\ued88珬\uf874纘쓙䴤퍦始\ude11⑶", -626500076, 1636778118), var3.stats.steps);
                  var0.set(a.c(1008761909, "籚\u05ee輨ᅌ體ᰭꙴ⾀뇕㭬벧"), var3.stats.flicks);
                  var0.set(a.b("뤒삦䩠퐄徜\ud977挢\ueac0璝︤秵莃൝", 2140846459), var3.stats.tracking);
                  var0.set(a.d("숈뮼ㅺ꼞⒆ꉯᠯ釉ྐ蔼˥\uf896癌", 225404567, -2075876106), var3.stats.vertical);
                  var0.set(a.b("䏝㩩낯⻋ꕓ⎹駬ဋ蹕", 1649886128), var3.stats.usedHits);
                  var0.set(a.c(-1253442422, "ﳡ蕕ྒྷ釷ᩯ鲟⛕꼷ㅿ믏㰇왱䢦턌存"), var3.stats.overshoots);
                  var0.set(a.c(-761765962, "忘♬겪㋎륖㾺藮ఊ鉙ᣵ"), var1);
                  var0.save();
               } catch (Throwable var7) {
                  System.out.println(a.c(-1807142355, "㉟䯥섦彐풚剤\ue873憇ￍ畩\uf2fb࣋蘓ᾭ闳\u1317ꥒ⚙배㨲뎃징䝮\udcba嫌퀜槱\ue7ba") + var7);
               } finally {
                  tdq = null;
               }
            }, a.b("\uf565賾خ顇Ꮥ镶⽫ꚑ㣞뉨㖦쾘䄎\ud8b0勬퐐湊\ue191笸ﵳ", -1615596233));
            var2.setDaemon(true);
            var2.setPriority(1);
            var2.start();
         }
      }
   }

   public static void cancelTraining() {
      tct var0 = tdp;
      if (var0 != null && !var0.done) {
         var0.progress.cancel = true;
      }
   }
}
