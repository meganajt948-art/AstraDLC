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
   private static final int tda = -789577728;
   private static final String[] tdb = new String[]{
      a.d("렴솴䭿픎廍\ud85a戗\uebc4疝", -788012186, 793074463),
      a.c(801353398, "껸흸嶳쏂䠁캖瓘ﴄ捘\ue9f1"),
      a.d("끠짠䌫\udd5a嚙퀎橁\ue381緃\uf76a", -877860424, -602449514),
      a.b("쮅눅㣎ꚿ\u2d7c꯫ᆣ顣غ貓", -1118712885)
   };
   private static final List<tkx> tdc = new ArrayList<>();
   private static final Random tdd = new Random();
   private static tcw tde = tcw.NONE;
   private static tiq tdf;
   private static tkc tdg;
   private static ttl tdh;
   private static tyd tdi;
   private static kfe tdj;
   private static tkc tdk;
   private static ClientWorld tdl;
   private static Field tdm;
   private static boolean tdn;
   private static boolean tdo;
   private static volatile tct tdp;
   private static volatile tiq tdq;

   private tcz() {
   }

   public static void install() {
      ClientTickEvents.START_CLIENT_TICK.register(tcz::tea);
      ClientTickEvents.END_CLIENT_TICK.register(tcz::teb);

      try {
         AttackBlockCallback.EVENT.register((AttackBlockCallback)(var0, var1x, var2, var3, var4) -> {
            ttl var5 = tdh;
            MinecraftClient var6 = MinecraftClient.method_1551();
            if (var5 != null && var1x.method_8608() && var0 == var6.field_1724 && !ejp.isActive()) {
               var5.attack(var6, var3, var4);
            }

            return ActionResult.field_5811;
         });
         ClientPlayerBlockBreakEvents.AFTER.register((After)(var0, var1x, var2, var3) -> {
            ttl var4 = tdh;
            if (var4 != null && var1x == MinecraftClient.method_1551().field_1724 && !ejp.isActive()) {
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
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (var2.field_1724 != null && var2.field_1687 != null && var0 != null) {
         stop();
         tdw();
         tdf = var0;
         tde = tcw.RECORD;
         tdl = var2.field_1687;
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

   private static String tdt(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.field_1724;
      if (var0.field_1755 != null) {
         return a.b("曾Ὗ閝\u0bfb耬ږ", 1756063371);
      } else if (!var0.method_1569()) {
         return a.b("䃘㥠뎿ⷘꘉ", -1324400453);
      } else if (!var1.method_5805() || var1.method_7325()) {
         return a.b("\udac1ꍱ⦦럒", -2033395039);
      } else {
         return ovh.active() ? a.d("㏛䩾삺廋픚厩\ue9f6", 1038296086, 1988040620) : null;
      }
   }

   public static boolean mining() {
      return tdh != null;
   }

   public static void startMining(tiq var0) {
      MinecraftClient var1 = MinecraftClient.method_1551();
      if (var1.field_1724 != null && var1.field_1687 != null && var0 != null) {
         stop();
         tdw();
         tdf = var0;
         tde = tcw.RECORD;
         tdl = var1.field_1687;
         tdh = new ttl(var0, (float)unit(var1));
      }
   }

   private static String tdu(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.field_1724;
      if (var0.field_1755 != null) {
         return a.d("쨑뎰㥲꜔ⳃ꩹", -2106492669, -767773849);
      } else if (!var0.method_1569()) {
         return a.d("䰺㖂뽝℺ꫫ", 367600820, -1607833363);
      } else if (var1.method_5805() && !var1.method_7325()) {
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

   private static void tdv(tiq var0, tcw var1) {
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (var2.field_1724 != null && var2.field_1687 != null && var0 != null) {
         stop();
         tdw();
         tdf = var0;
         tde = var1;
         tdl = var2.field_1687;
         tdx(var2, var0);
         if (var1 == tcw.RECORD) {
            tdg = new tkc(var0, 0, var2.field_1724.method_73189(), (float)unit(var2));
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

      tdy(MinecraftClient.method_1551());
      tde = tcw.NONE;
      tdf = null;
   }

   private static void tdw() {
      if (tdk != null) {
         tdk.finish();
         tdk = null;
      }
   }

   public static double unit(MinecraftClient var0) {
      double var1 = (Double)var0.field_1690.method_42495().method_41753() * 0.6 + 0.2;
      return var1 * var1 * var1 * 8.0 * 0.15;
   }

   private static void tdx(MinecraftClient var0, tiq var1) {
      tdy(var0);
      int var2 = var1.standCount();

      for (int var3 = 0; var3 < var2; var3++) {
         tkx var4 = new tkx(var0.field_1687, tdb[var3 % tdb.length], tdd.nextLong(), var1.standMode(), var1.standNear(), var1.standFar(), var1.standSpeed());
         var4.method_5838(-789577728 - var3);
         var4.method_5673(EquipmentSlot.field_6169, new ItemStack(Items.field_8805));
         var4.method_5673(EquipmentSlot.field_6174, new ItemStack(Items.field_8058));
         var4.method_5673(EquipmentSlot.field_6172, new ItemStack(Items.field_8348));
         var4.method_5673(EquipmentSlot.field_6166, new ItemStack(Items.field_8285));
         var4.method_5673(EquipmentSlot.field_6173, new ItemStack(Items.field_8802));
         var4.relocate(var0.field_1724);
         var0.field_1687.method_53875(var4);
         tdc.add(var4);
      }
   }

   private static void tdy(MinecraftClient var0) {
      if (var0.field_1687 != null && var0.field_1687 == tdl) {
         for (tkx var2 : tdc) {
            if (!var2.method_31481()) {
               var0.field_1687.method_2945(var2.method_5628(), RemovalReason.field_26999);
            }
         }
      }

      tdc.clear();
   }

   public static boolean onAttack(PlayerEntity var0, Entity var1, EntityHitResult var2) {
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var0 instanceof ClientPlayerEntity var4) {
         Vec3d var5 = var2 != null ? var2.method_17784() : var1.method_5829().method_1005();
         if (var1 instanceof tkx var6) {
            if (tdg != null) {
               tdg.hit(var1, var5, var4);
            }

            boolean var7 = var4.field_6017 > 0.0 && !var4.method_24828() && !var4.method_6101() && !var4.method_5799() && !var4.method_5624();
            var6.knock(var4.method_73189(), var4.method_5624());
            var4.method_7350();
            if (var3.field_1687 != null) {
               var3.field_1687
                  .method_8486(
                     var6.method_23317(),
                     var6.method_23320(),
                     var6.method_23321(),
                     var7 ? SoundEvents.field_15016 : SoundEvents.field_14840,
                     SoundCategory.field_15248,
                     0.8F,
                     0.95F + tdd.nextFloat() * 0.1F,
                     false
                  );
               var3.field_1687
                  .method_8486(
                     var6.method_23317(),
                     var6.method_23320(),
                     var6.method_23321(),
                     SoundEvents.field_15115,
                     SoundCategory.field_15248,
                     0.6F,
                     0.9F + tdd.nextFloat() * 0.2F,
                     false
                  );
               if (var7) {
                  var3.field_1713.method_3061(var6, ParticleTypes.field_11205);
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

   private static int tdz(MinecraftClient var0) {
      if (!tdn) {
         tdn = true;
         tdm = vxr.find(
            KeyBinding.class,
            a.d("\udd9aꐠ⻢냉㭝뷨\u07bc蹆ဟ骿ᵿ\ue709槌\uf027稹ﳇ䚅쥆叵했尓♁ꣶ", -779239710, 1212900097),
            a.c(2048388231, "\ueceb镕ᾊ臲ਭ貧㚚뽬ℳꮅ"),
            a.d("Ʃ", 978839039, -2096896994)
         );
      }

      return Math.max(0, vxr.getInt(tdm, var0.field_1690.field_1886, 0));
   }

   private static void tea(MinecraftClient var0) {
      if (var0.field_1724 != null && var0.field_1755 == null) {
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

   private static void teb(MinecraftClient var0) {
      if ((tdh != null || tdi != null) && dry.armed()) {
         stop();
      }

      if ((tdh != null || tdi != null) && var0.field_1687 != null && var0.field_1687 != tdl) {
         tdl = var0.field_1687;
      }

      if (var0.field_1687 != tdl && tde != tcw.NONE && tdh == null && tdi == null) {
         if (tdg != null) {
            tdg.finish();
            tdg = null;
         }

         tdc.clear();
         tde = tcw.NONE;
         tdf = null;
      }

      if (var0.field_1724 != null && var0.field_1687 != null) {
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

   private static void tec(MinecraftClient var0) {
      for (int var1 = 0; var1 < tdc.size(); var1++) {
         tkx var2 = tdc.get(var1);
         if (var2.method_31481() || var0.field_1687.method_8469(var2.method_5628()) != var2) {
            tkx var3 = new tkx(var0.field_1687, tdb[var1 % tdb.length], tdd.nextLong(), tdf.standMode(), tdf.standNear(), tdf.standFar(), tdf.standSpeed());
            var3.method_5838(-789577728 - var1);

            for (EquipmentSlot var7 : EquipmentSlot.values()) {
               var3.method_5673(var7, var2.method_6118(var7).method_7972());
            }

            var3.relocate(var0.field_1724);
            var0.field_1687.method_53875(var3);
            tdc.set(var1, var3);
         }
      }
   }

   private static String ted(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.field_1724;
      if (var0.field_1755 != null) {
         return a.b("王ਪ胨Ẏ镙Ꮳ", -987335682);
      } else if (!var0.method_1569()) {
         return a.c(-239097764, "\ua83f톇存씿仮");
      } else if (var1.method_5805() && !var1.method_7325()) {
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

   private static kfe tee(String var0) {
      Flow var1 = Flow.getInstance();
      return var1.getModuleManager() == null ? null : var1.getModuleManager().getByName(var0);
   }

   private static void tef(MinecraftClient var0) {
      tiq var1 = lfa.activeProfile();
      boolean var2 = tde == tcw.NONE && var1 != null && var1.fights() && !lfa.turning();
      if (!var2) {
         tdw();
      } else {
         if (tdk != null && tdk.profile != var1) {
            tdw();
         }

         if (tdk == null) {
            tdk = new tkc(var1, 1, var0.field_1724.method_73189(), (float)unit(var0));
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

   private static boolean teg(ClientPlayerEntity var0, Entity var1) {
      return var1 instanceof PlayerEntity var2 && var2 != var0 && var2.method_5805() && !var2.method_7325() && !(var1 instanceof tkx) && !hhf.protects(var2);
   }

   private static List<Entity> teh(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.field_1724;
      ArrayList var2 = new ArrayList();

      for (PlayerEntity var4 : var0.field_1687.method_18456()) {
         if (teg(var1, var4) && var4.method_5858(var1) < 64.0) {
            var2.add(var4);
         }
      }

      var2.sort(Comparator.comparingDouble(var1x -> var1x.method_5858(var1)));
      return var2.size() > 4 ? new ArrayList<>(var2.subList(0, 4)) : var2;
   }

   private static void tei(MinecraftClient var0) {
      int var1 = lfa.stopKey();
      boolean var2 = var0.field_1755 == null && var1 != -1 && vzz.isDown(var0, var1);
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

   private static void tej(tct var0) {
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
            String var5 = var1.quality();

            byte var4 = switch (var5) {
               case a.d("柢Ṵ钵ૃ", -972900777, 1908527607) -> 25;
               case a.d("쒜봁㟋", -16719540, 1874404766) -> 70;
               default -> 45;
            };
            String var11 = var1.quality();

            byte var10 = switch (var11) {
               case a.b("듪쵼䞽\ud9cb", 957854888) -> 12;
               case a.d("솺렧㋭", 1372135260, 1138679464) -> 30;
               default -> 20;
            };
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

   private static void tek(tct var0) {
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

            String var4 = var1.size();

            byte var3 = switch (var4) {
               case a.d("堔↛ꭄ㔸뻯", -339022630, 1401926808) -> 48;
               case a.c(-883173187, "\ud8f4ꅨ⮨뗌㸙") -> 96;
               default -> 64;
            };
            String var10 = var1.quality();

            byte var9 = switch (var10) {
               case a.d("煯ࣹ舸ᱎ", -484582252, -164319815) -> 25;
               case a.d("➃帞퓔", -1531697587, 246546816) -> 70;
               default -> 45;
            };
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
