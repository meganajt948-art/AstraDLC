package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class gnr {
   private static final gmx[] gns = new gmx[]{
      new gmx(a.b("䝣㻕됀⩢ꆲ✀鴛ᒴ諬H螔緯", -1603254500), 500, 1, false, 0.0, false),
      new gmx(a.c(-271553502, "汚ᗬ鼹ś誋హ똢㾔ꇔ⭽겳"), 700, 1, true, 0.0, false),
      new gmx(a.b("穩ϛ褊ᝠ鲰ᨛꀑ⦧럧㵎몀", -732464623), 700, 2, true, 0.0, false),
      new gmx(a.b("裷\uf145箔\ue5fe渮\ue885劏\udb20䕸쿜䠀뉻", 779323528), 500, 2, false, 0.0, false),
      new gmx(a.c(1187904512, "ﱬ藒༏酱᪺鱒♆꾨\u31ef뭃"), 700, 1, true, 0.7, false),
      new gmx(a.c(980985648, "Ꝝ\udee2吿쩁䆊읢統\uf482櫄\ue066"), 700, 1, true, 0.7, true),
      new gmx(a.b("镎\uecf0昭\uf853玘\uf570佽욏壒퉸喬꿇ⅉ뢸㋩됁\u0e5d", 880448825), 700, 2, true, 0.7, true),
      new gmx(a.d("钍\ued33柮戀牛\uf4b3亾음夑펻呯긄₊를㌰뗙ྋ", 554932272, -1115484982), 700, 2, true, 1.0, false)
   };
   private static final gmx[] gnt = gph();
   private static final int gnu = 100;
   private static final int gnv = 20;
   private static final boolean gnw = System.getenv(a.d("쉽믆ㄖ꽿Ⓧꈑᡒ醾\u0ff1蕋ʅ\uf8ff瘣\uef94旔\ue327奮", -1010335564, 1053180574)) != null;
   private static final Field gnx = vxr.find(
      ClientPlayerEntity.class,
      a.b("㤤䂞쩜呷\udfe3奖\ue302櫸\uf4a1縁療η赲ᒙ麇\u1879ꈻⷸ띋ㄶ뢩싻䱊", 1983723869),
      a.d("ﻑ蝯ධ鏈᠗麝⒢굙㌋릿", -1441070749, 2063007710),
      a.d("깒", -49736635, 876264016)
   );
   private static final Field gny = vxr.find(
      ClientPlayerEntity.class, a.b("봍쒷乵큞寊\udd7f末\ueed1炈﨨編螞ज़邰\u1aae鱐☒꧑㍢딟㲀䛒졣", 579059060), a.c(-266001706, "⊺嬄퇛侣쑼䋶\uf8c9焲\uef66旐"), a.b("醵", 1591316978)
   );
   private static final gnl[] gnz = new gnl[gnt.length];
   private static final ConcurrentLinkedQueue<gng> goa = new ConcurrentLinkedQueue<>();
   private static final Random gob = new Random(23L);
   private static volatile boolean goc;
   private static volatile int god;
   private static volatile int goe = -1;
   private static volatile UUID gof;
   private static volatile int gog = -1;
   private static boolean goh;
   private static int goi;
   private static int goj;
   private static double gok;
   private static double gol;
   private static double gom;
   private static int gon = -1;
   private static gno goo;
   private static int gop = -1;
   private static boolean goq = true;
   private static boolean gor;
   private static boolean gos;
   private static boolean got;
   private static float gou = Float.NaN;
   private static float gov;
   private static double gow;
   private static int gox;
   private static long goy;
   private static boolean goz;
   private static final Set<Integer> gpa = new HashSet<>();
   private static volatile int gpb = -1;
   private static final ConcurrentLinkedQueue<Integer> gpc = new ConcurrentLinkedQueue<>();
   private static int gpd;
   private static int gpe;

   private gnr() {
   }

   private static gmx[] gph() {
      String var0 = System.getenv(a.c(-234343922, "㉘䯣섳彚퓨刴\ue877憛ￔ畮\uf2a0ࣚ蘝ᾭ闼ጘ"));
      if (var0 != null && !var0.isBlank()) {
         List var1 = Arrays.asList(var0.split(a.d("뙑", 1411887142, -1141701030)));
         return Arrays.stream(gns).filter(var1x -> var1.contains(var1x.gmy)).toArray(gmx[]::new);
      } else {
         return gns;
      }
   }

   static boolean tick(MinecraftClient var0) {
      goi++;
      ClientPlayerEntity var1 = var0.player;
      gps();
      if (goi == 1) {
         int var14 = MathHelper.floor(var1.getX());
         int var15 = MathHelper.floor(var1.getY());
         int var16 = MathHelper.floor(var1.getZ());
         gok = var14 + 0.5;
         gol = var15;
         gom = var16 + 0.5;
         gof = var1.getUuid();
         gpb = var1.getId();
         gpt(var0, a.d("簮֙轆ᄿ髠᱓ꘋ⿻뇡㬃볖䚠졳凝\udb91嵷\ue735", 1663005300, 1826295340));
         gpt(var0, a.c(811379863, "곯핃徔쇭䩿첝盘Ｘ愳\uebc6氐陹"));
         gpt(var0, a.c(14001628, "ꖦ\udc05囒좶䍽엁羅\uf626栺\ue284敞鼫ᇯ"));
         gpt(var0, a.b("ꬎ튼塯옝䷌쭪煭\uf8db暊\uec24毤釐ὧ蛥\u0ce5詆〞뿙╰ꌻ⫋傏\ude33䗯쎖䤂\uf0a8绹\ue40e扟\ue9ecᜤ鵿Қ芝ࠪ럺㶛", 1253878605));
         gpt(var0, a.c(2028857967, "\uea2c鎞᥍蜿೮詈く맹➨괆⫆탲幅쟇䷇쭥焸ﻼ摎\ue218毼ᆸ鼖Ӂ芿ࠠ놊㿛ꔬ⍽꣎嘆\udc5d䖸쎿䤈\uf6d8粹"));
         gpt(var0, a.d("뇒졬䊶\udcc3圇퇤毗\ue215", -755447717, 1036089826));
         gpt(var0, a.b("냭쥞䎈\uddf9噢킳櫅\ue30a絺\uf7c6瀜詸ӷ鵚\u1758醵⯷ꐾ㺑룗ㄏ", -497045357));
         gpt(var0, a.b("蝢ﻎ琌\uea75懯\ue70c嵈풬䫯쁓䞂뷵㍧ꪓ\u20cb꘠ᱲ鎾ऀ輈ڟ糽\uf21d榄\ueffc收\udc93勁젥丨얅㭄녜⢳껽\u2450鯏ᇳ霤ຒ蓆僧灳\uf7d1洁\ue362嫿퀐噒춋䏴뤧ゑ뛊Ⰲꉿᧄ鼍ᕣ貤", -142833865));
         gpt(
            var0,
            String.format(
               Locale.ROOT,
               a.d("ཞ盠ﰶ扇\ue9dc潨핺峏슕䡥쿲㖆묐⋥ꢳ⸃鐈ᯜ脮ܻ軉\uf4d9種\ue1b2柉\ued1f咧\udaf0䀖왔䷠댣㤢ꂎ⛖걪Ꭿ駞\u1f5e蚧\u0cff爍\uf85e翬\ue523", -1297874748, -321384495),
               var14 - 16,
               var15 - 1,
               var16 - 16,
               var14 + 16,
               var15 + 9,
               var16 + 16
            )
         );
         gpt(var0, String.format(Locale.ROOT, a.b("⛒彧헤䯵쀑䛳ﲥ畟\ueb1f懹\ue66cᰘ銎\u0b7b脭ߗ붇㈁ꣴ⺨ꝋ\udd13厰족", 61023934), gok, var15, gom));
         var1.getInventory().setSelectedSlot(0);
         return false;
      }

      if (goi == 8) {
         double var13 = gok + 2.7;
         var0.getServer().execute(() -> fnq.spawn(var0.getServer(), gof, var13, gol, gom));
         return false;
      }

      if (goi == 40) {
         gpq();
      }

      if (goi < 100) {
         if (goi > 20) {
            gpr(var0);
         }

         return false;
      } else {
         wcn.ensure(var0);
         Entity var2 = gpr(var0);
         if (var2 == null) {
            System.out.println(a.c(-468677319, "赀\uf4ec縯\ue055殟\ued7a坽\ude9d䃔쩢䷥럲㤢ꂛ⫍걐ᙑ馁ͽ蕮ಔ盞"));
            return true;
         }

         if (var0.mouse.isCursorLocked()) {
            var0.mouse.unlockCursor();
         }

         int var3 = goi - 100;
         int var4 = 0;

         for (int var5 = 0; var4 < gnt.length && var3 >= var5 + gnt[var4].gmz; var4++) {
            var5 += gnt[var4].gmz;
         }

         if (var4 >= gnt.length) {
            goc = false;
            fnq.active = false;
            fnq.orbit = 0;
            var0.options.jumpKey.setPressed(false);
            gpk(var0);
            gpp();
            return true;
         }

         gmx var6 = gnt[var4];
         if (var4 != gog) {
            gpl();
            if (gor && gog >= 0) {
               gpo(gnz[gog]);
            }

            gor = false;
            gog = var4;
            goj = goi;
            gnz[var4] = new gnl();
            fnq.orbit = var6.gna;
            fnq.jumping = true;
            fnq.aggression = var6.gnc;
            fnq.active = true;
            fnq.orbitRadiusSum = 0.0;
            fnq.orbitTurnSum = 0.0;
            fnq.orbitTicks = 0;
            goo = null;
            gop = -1;
            goc = true;
            System.out.println(a.d("\uecf6镚ᾙ臣\u0a29賌㛏뼦ⅰꯓⰖ혢", 473211277, 670518552) + var6.gmy);
         }

         if (--gox <= 0) {
            gox = 30 + gob.nextInt(60);
            gow = (gob.nextDouble() - 0.5) * 6.0;
         }

         var1.changeLookDirection(gow / 0.15, 0.0);
         var0.options.jumpKey.setPressed(var6.gnb && goi - goj >= 20);
         gpi(var0, var1, var2, var6.gnd && goi - goj >= 20);
         float var7 = vxr.getFloat(gnx, var1, var1.getYaw());
         float var8 = vxr.getFloat(gny, var1, var1.getPitch());
         if (!Float.isNaN(gou) && goi - goj >= 20) {
            double var9 = MathHelper.wrapDegrees(var7 - gou);
            double var11 = var8 - gov;
            gnz[var4].turns.add(Math.sqrt(var9 * var9 + var11 * var11));
         }

         gou = var7;
         gov = var8;
         return false;
      }
   }

   private static void gpi(MinecraftClient var0, ClientPlayerEntity var1, Entity var2, boolean var3) {
      gpa.clear();
      if (!var3) {
         gpj(var0.options.forwardKey, false);
         gpj(var0.options.backKey, false);
         gpj(var0.options.leftKey, false);
         gpj(var0.options.rightKey, false);
         vzz.simulated = gpa::contains;
      } else {
         double var4 = var2.getX() - var1.getX();
         double var6 = var2.getZ() - var1.getZ();
         double var8 = Math.max(0.001, Math.sqrt(var4 * var4 + var6 * var6));
         if (--gpd <= 0) {
            gpd = 15 + gob.nextInt(30);
            gpe = gob.nextInt(3) - 1;
         }

         boolean var10 = Math.abs(var1.getX() - gok) > 11.0 || Math.abs(var1.getZ() - gom) > 11.0;
         double var11 = var8 > 3.0 ? 1.0 : (var8 < 2.0 ? -1.0 : 0.0);
         double var13 = var10 ? 0.0 : gpe;
         double var15 = var4 / var8 * var11 + var6 / var8 * var13;
         double var17 = var6 / var8 * var11 - var4 / var8 * var13;
         if (var10) {
            var15 = gok - var1.getX();
            var17 = gom - var1.getZ();
         }

         double var19 = Math.hypot(var15, var17);
         double var21 = 0.0;
         double var23 = 0.0;
         if (var19 > 1.0E-6) {
            double var25 = Math.toRadians(var1.getYaw());
            var21 = (var17 * Math.cos(var25) - var15 * Math.sin(var25)) / var19;
            var23 = (var15 * Math.cos(var25) + var17 * Math.sin(var25)) / var19;
         }

         double var27 = Math.sin(Math.toRadians(22.5));
         gpj(var0.options.forwardKey, var21 > var27);
         gpj(var0.options.backKey, var21 < -var27);
         gpj(var0.options.leftKey, var23 > var27);
         gpj(var0.options.rightKey, var23 < -var27);
         vzz.simulated = gpa::contains;
      }
   }

   private static void gpj(KeyBinding var0, boolean var1) {
      var0.setPressed(var1);
      if (var1) {
         gpa.add(KeyBindingHelper.getBoundKeyOf(var0).getCode());
      }
   }

   private static void gpk(MinecraftClient var0) {
      var0.options.forwardKey.setPressed(false);
      var0.options.backKey.setPressed(false);
      var0.options.leftKey.setPressed(false);
      var0.options.rightKey.setPressed(false);
      vzz.simulated = null;
   }

   private static void gpl() {
      if (gog >= 0 && gnz[gog] != null) {
         gnl var0 = gnz[gog];
         var0.radius = fnq.orbitRadiusSum;
         var0.spin = fnq.orbitTurnSum;
         var0.orbitTicks = fnq.orbitTicks;
      }
   }

   private static void gpm(MinecraftClient var0) {
      god++;
      ClientPlayerEntity var1 = var0.player;
      if (goc && var1 != null && goe >= 0 && gog >= 0) {
         Entity var2 = var0.world.getEntityById(goe);
         if (var2 != null) {
            gnl var3 = gnz[gog];
            long var4 = System.nanoTime();
            if (goy != 0L && var4 - goy < 10000000L) {
               var3.bursts++;
            }

            goy = var4;

            gng var6;
            while ((var6 = goa.poll()) != null) {
               var3.serverHits++;
               if (var6.gni) {
                  var3.serverCrits++;
                  if (gor) {
                     goz = true;
                  }
               }
            }

            while (gpc.poll() != null) {
               var3.knocks++;
            }

            if (goo != null && goo.phase == gog) {
               gpn(goo, gon == goo.tick);
            }

            if (goi - goj < 20) {
               goo = null;
            } else {
               Vec3d var7 = var1.getEyePos();
               Box var8 = var2.getBoundingBox();
               Vec3d var9 = var7.add(var1.getRotationVec(1.0F).multiply(3.0));
               gno var10 = new gno();
               var10.tick = god;
               var10.phase = gog;
               var10.charged = var1.getAttackCooldownProgress(0.5F) > 0.9F;
               var10.reach = var8.squaredMagnitude(var7) <= 9.0;
               var10.aimed = var8.contains(var7) || var8.raycast(var7, var9).isPresent();
               var10.ground = var1.isOnGround();
               var10.crit = !var10.ground && var1.fallDistance > 0.0;
               var10.why = kwf.debug();
               double var11 = var8.squaredMagnitude(var7);
               if (var11 <= 16.0) {
                  var3.nearTicks++;
                  if (kwf.target() == null) {
                     var3.lostTicks++;
                  }
               }

               if (var11 > 9.0) {
                  var3.farTicks++;
               }

               Vec3d var13 = var8.getCenter();
               double var14 = var13.x - var7.x;
               double var16 = var13.z - var7.z;
               var10.yawErr = MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var16, var14)) - 90.0 - var1.getYaw());
               var10.pitchErr = -Math.toDegrees(Math.atan2(var13.y - var7.y, Math.hypot(var14, var16))) - var1.getPitch();
               if (goq && !var10.ground && var1.getVelocity().y > 0.0) {
                  if (gor) {
                     gpo(var3);
                  }

                  gor = true;
                  gos = false;
                  got = false;
                  goz = false;
                  var3.jumps++;
               }

               goq = var10.ground;
               goo = var10;
            }
         }
      }
   }

   private static void gpn(gno var0, boolean var1) {
      gnl var2 = gnz[var0.phase];
      var2.ticks++;
      if (var0.aimed) {
         var2.aimedTicks++;
      }

      if (var1) {
         var2.hits++;
         if (gor) {
            gos = true;
         }
      }

      if (var0.crit && var0.charged && var0.reach && gor) {
         got = true;
      }

      if (var0.charged && var0.reach) {
         var2.ready++;
         if (gop < 0) {
            gop = var0.tick;
         }

         if (var1) {
            var2.readyHit++;
         } else if (var0.aimed) {
            var2.heldAimed++;
            if (var0.why.contains(a.b("钨\ued08柀怜爲", 2131989710))
               && !var0.why.contains(a.c(-728218298, "䔢㲂뙊⠦ꎸ┙齖"))
               && !var0.why.contains(a.d("䪢㌂맊➦갸⪄郇", 665829965, 1223002251))) {
               var2.heldCrit++;
            } else {
               var2.heldOther++;
            }
         } else {
            var2.notAimed++;
         }
      }

      if (var1 && gop >= 0) {
         int var3 = var0.tick - gop;
         var2.wait[var3 <= 0 ? 0 : (var3 == 1 ? 1 : (var3 == 2 ? 2 : (var3 <= 5 ? 3 : (var3 <= 10 ? 4 : (var3 <= 20 ? 5 : 6)))))]++;
         gop = -1;
      }

      if (gnw) {
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.b(
                     "難\uef4f斌ﯶ瀼\uf6d9䳞앦嬡퇑噆갲⊳뭑ㅁ랻\u0dfd舿ᢙ黊\u173c洴\ue39f砘︴璷촓䍆\ud9b3忩퐏⫆ꃟ㥽뽯㗖訅|蚮\u1f46锁\ueba6憦\ue650粒\uf2fe䬷솝䟘\udc50刻ꢼ⅘Ꝋ㶨돢ࡀ軘ҳ鴴Ꮠ槀\uee26摷節猞쥅俢얭婊탊图꼶▇뮛ひ똮ಀ蔄ᬼ釹ឣ氏\ue289碸\uf16c瞉",
                     -34236709
                  ),
                  var0.tick,
                  gnt[var0.phase].gmy,
                  var0.charged,
                  var0.reach,
                  var0.aimed,
                  var0.ground,
                  var0.crit,
                  var1,
                  var0.yawErr,
                  var0.pitchErr,
                  var0.why
               )
            );
      }
   }

   private static void gpo(gnl var0) {
      if (gos) {
         var0.jumpsHit++;
      }

      if (goz) {
         var0.jumpsCrit++;
      }

      if (got) {
         var0.jumpsChance++;
         if (gos) {
            var0.jumpsChanceHit++;
         }
      }
   }

   private static void gpp() {
      gpl();
      int var0 = 0;
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      for (int var7 = 0; var7 < gnt.length; var7++) {
         gnl var8 = gnz[var7];
         if (var8 != null) {
            var8.turns.sort(Double::compare);
            double var9 = var8.turns.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double var11 = var8.turns.isEmpty() ? 0.0 : var8.turns.get((int)(var8.turns.size() * 0.95));
            double var13 = var8.turns.isEmpty() ? 0.0 : var8.turns.get(var8.turns.size() - 1);
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.b(
                        "沨ᔄ鿇ƽ詷ಒ뛄㽣ꅵ⯞걅嘵\ud8ff䅉쭔䶽\uf7b3砦\ue29d擁\ued3d靰ᦗ舏Ь躧㜝뤟⏾ꖸ⸏탍媕쌫䕠쾐瀃僧糳\ue559漛ᇭ鯰᱙蛏ࣺ녵㮘붅♃꠴勠\udb4a嵟잴䦤\uf25f瓆ﺴ杸\ue9f4鎄ᑋ鸭æ襒㌜떩㿦ꀖ⪁겸啪\udfd2䆉쩝䰢\uf697罌\ue13c殪\uede3阑ᢄ苻ୡ跃㞉롫≮ꒊⵍ휲姾숙䑍컃烺拉換\ue597湺ဤ骂̏蕻\u0fe9뀕㩋보⚦꼌凶\udb8f屸옡䢗\uf11f筴\ufde4星\ue812銽ᒭ鴒߇覼㉬둧㻓꜋⥤폥吗\ude44䂰쪠猘\uf58d羨\ue062櫙\uec82镫",
                        -1608815529
                     ),
                     gnt[var7].gmy,
                     var8.hits,
                     var8.ticks == 0 ? 0.0 : var8.hits * 20.0 / var8.ticks,
                     var8.serverHits,
                     var8.serverCrits,
                     var8.ready,
                     var8.readyHit,
                     var8.heldAimed,
                     var8.heldCrit,
                     var8.heldOther,
                     var8.notAimed,
                     var8.ticks == 0 ? 0.0 : 100.0 * var8.aimedTicks / var8.ticks
                  )
               );
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.b(
                        "쳂땮㾭ꇗ⨝곸ᚮ鼉ğ讴ర\uf657碈\ue124欣\ued91埕\ud80d䊭쓩䴜㝌릶≴ꑝ⺍霣ᤦ菁ה踮烧\ufae9捜\ue51e濪클娝\udc8f䕺켷놀㮚밳⚥ꢐᅐ鯿ᶨ蘸ࠂ\uf2cb笽ﴨ柍\ue987判퓴廃읛䧴㏤둓㸓ꃜ⥱錽ᗎ鿝%諮ೞ\uf545翦\ue1b6橝\uec55嚭\udf66䅖쯝䷐㘿뢤⋌ꬅⶫ韹ᡈ舁ӳ赦睙黎戧\ue43f滨탘奏쎽䗻츑끟㪧ꍠ═꿇ဵ驩Ბ蛍ཱ\uf1b8箱ﱚ晊\ue8b9儫\udb53嶋옻䡧㊒듮㵸Ꞵ⦎鉇ᑉ",
                        -1428698068
                     ),
                     gnt[var7].gmy,
                     var8.wait[0],
                     var8.wait[1],
                     var8.wait[2],
                     var8.wait[3],
                     var8.wait[4],
                     var8.wait[5],
                     var8.wait[6],
                     var8.jumps,
                     var8.jumpsHit,
                     var8.jumpsCrit,
                     var8.jumpsChance,
                     var8.jumpsChanceHit
                  )
               );
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.c(
                        -1180507990,
                        "\ue09b餷Ᏼ趎ل股㫷덐ⵆ\ua7ed⁵\uda01哗쵪䜱쇉箅\uf456滭\ue8a4愝᭔閦ำ蠐ʝ뭡㔪꿜⧙ꈥ峽훴佗줓䎦ﱳ瘉\uf092椦\ue372鶝ម遪ઽ蓉㵕럭\u31e4ꩡ␏\uded4坫턢䮂얏繬\uf8e9犏\ueb4d旯ᾼ類ቛ賘ժ뼥㧓돐Ɽ꛶\u20c3\ud953叫췾䘊쀜竩\uf36e洂\ue7c7憞ᨵ钷ທ蝘Ƕ뮻㑅긓⣮ꄫ孈헔"
                     ),
                     gnt[var7].gmy,
                     var8.knocks,
                     var8.ticks == 0 ? 0.0 : 100.0 * var8.farTicks / var8.ticks,
                     var8.lostTicks,
                     var8.nearTicks
                  )
               );
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.d(
                        "곦핊徉쇳䨹쳜皊Ｍ愻\ueb90氐陷\u18ab脀ଇ趢㟬렺⊕ꒊⴼ坺\ud9d8䉓쐴仮\uf742祄\ue3f5旴\uee0eდ骔ͽ蔥ྋ뀋㨼벢┟꽙퇭宦\udc1c䛔죲照ﮒ緜\ue60f栴銾ᬔ鵏\u07b4覮㉍듀㻱ꜭ⦁厄퐥幧삭䤑\uf35e疩ﾭ怙\ueac1沬锧ῐ臐ਢ豬㛚뽇ℳ꯷ⶹ噝\ud8ca䋹쬩䶘\uf781砥\ue269擐\ued09᜵馸ɗ葒\u0e80냻㤠ꎉ▍깠퀾媎쌌䕣쿣瀓突粵\ue6f5潂釙ᮍ鰿",
                        1591340204,
                        147210326
                     ),
                     gnt[var7].gmy,
                     var9,
                     var11,
                     var13,
                     var8.orbitTicks == 0 ? 0.0 : var8.radius / var8.orbitTicks,
                     var8.orbitTicks == 0 ? 0.0 : var8.spin / var8.orbitTicks,
                     var8.bursts
                  )
               );
            var0 += var8.hits;
            var1 += var8.serverHits;
            var2 += var8.serverCrits;
            var3 += var8.ready;
            var4 += var8.notAimed;
            var5 += var8.heldAimed;
            var6 += var8.ticks;
         }
      }

      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.c(
                  -1547016405,
                  "朖Ẻ鑹ਃ臉ܬ봍㓫ꪢ―\ua7df嶶팕䫬삾䙒ﰚ玅\ue92e漾\ue68d鳔ቪ覰࿓蕖㲬늡⠌깔▴\udb73儫죞亞쐸箠\uf1c9睛\ueeae撲ᩒ通ា赦͙몒ぢ뙩ⷪꎎ奛탩嚥찒䉛殮缰\uf50d泝\ue271頕῎閛ଡ଼苬㣦븏㐙꯬ⅷ꜋廝푤䨒쇋䞘ﴡ瓳\ueadb怌\ue61c"
               ),
               var0,
               var6 == 0 ? 0.0 : var0 * 20.0 / var6,
               var1,
               var2,
               var3,
               var4,
               var5
            )
         );
   }

   private static void gpq() {
      String var0 = System.getenv().getOrDefault(a.b("悹ᤂ鏒ර蘉Õ몖㍺괵➏ꁁ娻퓲䵋윜", 652370160), a.c(984674386, "\uf024覎͔鴶ᛷ"));
      String var1 = System.getenv().getOrDefault(a.d("緇Ѽ躬Ⴥ魷ᶫ\ua7e8⸄끋㫱봿䝅즟倳\uda7b", 885744427, 416816805), a.d("ࢲ焙\ufbcf斷\uee6b检", 1894576825, -409863554));
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.d("ᡞ懍\ueb1b番ﺐ砕쉁䮣", 1737661281, -2121563268));

      for (vmo var4 : var2.getSettings()) {
         switch (var4.getName()) {
            case a.b("﹊蟆എ鍪ᢨ鸄\u2451궡", -1863451120):
               ((vlv)var4).set(a.d("䀂㦼덪ⴗꛋ\u2060", 1432830316, 1509556491).equals(var1) ? a.b("݅绛\uf40d橰\ue1ac朇", 378734336) : a.c(1379117624, "ꩭ폦夰읈䲔쨿"));
               break;
            case a.d("ꥁ탘娏", 1803889754, 1227457881):
               ((vlv)var4)
                  .set(a.d("꾺혀峃습䥱쿍", -517987800, 1569689082).equals(var0) ? a.d("竃͙覚\u17ec鰨᪔", -1507461574, 2082245809) : a.c(1857058074, "界ೆ蘜\u187e鎿"));
               break;
            case a.d("瓑\u0d51螙᧵鈥", 918361247, 1936089096):
            case a.b("䮐㈃룉⚫괹⯎醒ᡲ", 865356757):
            case a.d("䶼㐱뻯₆ꭍⷫ鞹", -1862573302, 733163233):
               ((vkl)var4).set(true);
               break;
            case a.d("₺天폷䶗", -1844840840, -409872757):
            case a.c(641433938, "脋\uf886牏\uec23柮\ue14d嬑튨䲠옇䇙뮨㕠"):
               ((vkl)var4).set(false);
               break;
            case a.c(1520863765, "詍\uf3de礖\ue761沫\uea01偏\ud9b3"):
               ((vlv)var4).set(a.b("↾堠틺䲀읞", -1248517638));
               break;
            case a.c(240620443, "鏗\uea5b悙ﻠ甩"):
               ((vlv)var4).set(a.b("쬖늕㡂꘢ⷪꭚᄔ", -816657594));
         }
      }

      kwf.useStudio(null);
      var2.setEnabled(true);
      Flow.getInstance().getModuleManager().getByName(a.d("巣⑦꺴マ묵㶧蟶ผ遄\u1aef", 298467163, 399532787)).setEnabled(true);

      for (String var11 : new String[]{
         a.b("⒋崜ퟔ䦫쉼䓏ﺋ睊\ue938排", -1447877419),
         a.d("ꘌ\udf95啂쬟䃺왋簂\uf5e9殱", 1870407189, -174555055),
         a.c(-208892339, "踈\uf798絮\ue320棯\uee43吤\uddf4䎢줞仕"),
         a.d("놾젻䋩\udc83坶퇫殺\ue24d", 2047485506, -1667655755),
         a.c(-1915436209, "쌇몂ぐ긺◖ꍜᤔ郴ຣ")
      }) {
         kfe var7 = Flow.getInstance().getModuleManager().getByName(var11);
         if (var7 != null) {
            var7.setEnabled(false);
         }
      }
   }

   private static Entity gpr(MinecraftClient var0) {
      if (goe >= 0) {
         Entity var1 = var0.world.getEntityById(goe);
         if (var1 != null) {
            return var1;
         }
      }

      for (PlayerEntity var2 : var0.world.getPlayers()) {
         if (a.b("༤皿ﱯ戆\ue9e4潸픰", -1451815067).equals(var2.getGameProfile().name())) {
            goe = var2.getId();
            return var2;
         }
      }

      return null;
   }

   private static void gps() {
      if (!goh) {
         goh = true;
         ClientTickEvents.START_CLIENT_TICK.register(gnr::gpm);
         wcn.listen(var0 -> {
            if (goc && var0 instanceof EntityVelocityUpdateS2CPacket var1 && var1.getEntityId() == gpb) {
               gpc.add(god);
            }
         });
         AttackEntityCallback.EVENT
            .register(
               (AttackEntityCallback)(var0, var1, var2, var3, var4) -> {
                  if (var1.isClient()) {
                     if (goc && var3.getId() == goe) {
                        gon = god;
                     }

                     return ActionResult.PASS;
                  } else if (goc && var3.getId() == fnq.spawned && var0.getUuid().equals(gof)) {
                     boolean var5 = var0.getAttackCooldownProgress(0.5F) > 0.9F
                        && var0.fallDistance > 0.0
                        && !var0.isOnGround()
                        && !var0.isClimbing()
                        && !var0.isTouchingWater()
                        && !var0.hasVehicle()
                        && !var0.isSprinting();
                     goa.add(new gng(god, var5));
                     return ActionResult.PASS;
                  } else {
                     return ActionResult.PASS;
                  }
               }
            );
      }
   }

   private static void gpt(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
