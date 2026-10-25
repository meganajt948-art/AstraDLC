package a;

import flow.Flow;
import flow.dev.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AfterDamage;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class fpo {
   static final fot[] fpp = new fot[]{
      new fot(a.d("䠌ㆬ뭯┗", 1018781309, -34138607), 900, true, 0.6, true, 16.0F),
      new fot(a.c(-190063754, "\udb12ꊥ⡶똒㷘"), 700, true, 1.0, true, 16.0F),
      new fot(a.d("讎\uf23d磣\ue693", 580668412, -1982218219), 600, true, 0.1, false, 14.0F),
      new fot(a.c(-1397452765, "遂\ue9e6挨﵃皏\uf034"), 500, false, 0.5, true, 16.0F)
   };
   static final fot[] fpq = fue();
   static final int fpr = 100;
   static final int fps = 8;
   static final boolean fpt = System.getenv(a.c(-1229975286, "ᅜ棧\ue237籞\uf7ec焰쭸䊘\udcd7噯톯⯕ꔄ㲦뛷　")) != null;
   static final String fpu = System.getenv(a.c(1915715256, "绱݊趚Ᏻ顁ẝꓕⴵ덺㧂븂䑭쪮匘\ud958"));
   static final Field fpv = vxr.find(
      ClientPlayerEntity.class,
      a.d("便胟ਝ鐶ᾢ餗⍃ꪹ㓠빀㦀쏶䴳퓘廆\ud838扺\uedb9眊\uf177磨ʺ谋", -1609502571, -586151543),
      a.c(-701688847, "\u139d樣\ue0fc纄\uf55b珑짮䀕\ude47哳"),
      a.d("嘔", -101762424, 875523291)
   );
   static final Field fpw = vxr.find(
      ClientPlayerEntity.class, a.b("瞦ผ蓞\u1af5酡។궀⑺먣ゃ띃䴵쏰娛퀅囻\uecb9捺柳羴\uf62b豹ˈ", -100304929), a.c(-1656699692, "쒸봆㟙ꦡ≾ꓴị霰।菒"), a.d("ᒖ", 1322923978, -2116934885)
   );
   static final Set<Integer> fpx = new HashSet<>();
   static final List<Double> fpy = new ArrayList<>();
   static final List<double[]> fpz = new ArrayList<>();
   static final List<double[]> fqa = new ArrayList<>();
   static final List<Double> fqb = new ArrayList<>();
   static final List<Double> fqc = new ArrayList<>();
   static float fqd = Float.NaN;
   static float fqe;
   static double fqf;
   static int fqg;
   static int fqh;
   static double fqi;
   static final List<Double> fqj = new ArrayList<>();
   static final boolean fqk = System.getenv(a.b("\uf493质߸馑ሣ铿⺷ꝗ㤘뎠㑠츏䃌\ud97a区헕澑\ue05b章ﲱ畍༕", 37614787)) != null;
   static int fql = -1;
   static double fqm;
   static double fqn;
   static int fqo = -1;
   static int fqp;
   static int fqq;
   static int fqr;
   static double fqs;
   static double fqt;
   static final ConcurrentLinkedQueue<fpf> fqu = new ConcurrentLinkedQueue<>();
   static final ConcurrentLinkedQueue<foo> fqv = new ConcurrentLinkedQueue<>();
   static final ConcurrentLinkedQueue<Integer> fqw = new ConcurrentLinkedQueue<>();
   static final ConcurrentLinkedQueue<Integer> fqx = new ConcurrentLinkedQueue<>();
   static final List<fpc> fqy = new ArrayList<>();
   static final ArrayDeque<fpc> fqz = new ArrayDeque<>();
   static volatile int fra;
   static volatile int frb = -1;
   static volatile int frc = -1;
   static volatile UUID frd;
   static volatile boolean fre;
   static volatile int frf = -1;
   static boolean frg;
   static int frh;
   static double fri;
   static double frj;
   static double frk;
   static int frl;
   static int frm;
   static int frn;
   static final Random fro = new Random(17L);
   static boolean frp = true;
   static int frq;
   static int frr;
   static boolean frs;
   static int frt = -1000;
   static boolean fru;
   static float frv = -1.0F;
   static boolean frw;
   static String frx = "";
   static int fry = -1;
   static int frz = 99;
   static int fsa = -1;
   static boolean fsb;
   static boolean fsc;
   static final Vec3d[] fsd = new Vec3d[12];
   static float fse = 1.0F;
   static float fsf;
   static float fsg = 1.2F;
   static int fsh;
   static int fsi;
   static int fsj = 80;
   static float fsk;
   static int fsl;
   static int fsm;
   static final int[] fsn = new int[8];
   static final int[] fso = new int[8];
   static final int[] fsp = new int[8];
   static final int[] fsq = new int[8];
   static final int[] fsr = new int[8];
   static final int[] fss = new int[8];
   static final int[] fst = new int[8];
   static final int[] fsu = new int[8];
   static final int[][] fsv = new int[8][6];
   static final int[] fsw = new int[8];
   static final int[] fsx = new int[8];
   static final int[] fsy = new int[8];
   static final int[] fsz = new int[8];
   static final int[] fta = new int[8];
   static final double[] ftb = new double[8];
   static final double[] ftc = new double[8];
   static final int[] ftd = new int[8];
   static final int[] fte = new int[8];
   static final int[] ftf = new int[8];
   static final int[] ftg = new int[8];
   static final List<Double> fth = new ArrayList<>();

   fpo() {
   }

   static boolean tick(MinecraftClient var0) {
      frh++;
      ClientPlayerEntity var1 = var0.player;
      fub(var0);
      wcn.ensure(var0);
      if (frh == 1) {
         int var8 = MathHelper.floor(var1.getX());
         int var9 = MathHelper.floor(var1.getY());
         int var10 = MathHelper.floor(var1.getZ());
         fri = var8 + 0.5;
         frj = var9;
         frk = var10 + 0.5;
         frd = var1.getUuid();
         frc = var1.getId();
         fuf(var0, a.d("ꯙ퉮墱웈䴗쮤燼\uf80c昖\uecf4次酗ᾄ蘪౦誀ヂ", -307556399, -364993410));
         fuf(var0, a.d("⸛垷\udd60䌙좋乩\uf42c緌\ue3c7椲\ueee4ᒍ", -574092651, 232137974));
         fuf(var0, a.b("쭡닂㠕꙱ⶺꬆᅂ飡۽豃ங\uf1ec缨", -2032481509));
         fuf(var0, a.c(95199938, "ꊁ\udb33几쾒䑃싥磢\uf154漅\ue5ab扫顟ᛨ轪ժ菉㦑뙖⳿ꪴ⍄夀ힼ䱠쨙䂍蠟睶\ued81毐\ue063ẫ铰ക謒ƥ빵㐔"));
         fuf(var0, a.c(-946030543, "롲쇀䬓핡庰\ud816我\ueba7痶ｘ碘芬ఛ閙ᾙ餻⍦겢㘐끆㦢䏦쵈嚟탡婾\ue3d4涅\uf772焣敖ј踃៦釡᭖ꒆ⻧"));
         fuf(var0, a.d("僜⥢ꎸ㷍똉リ諙̛", 91760528, 1740404519));
         fuf(var0, a.c(837404832, "죞녭㮻ꗊ⹑ꢀዶ鬹Չ迵\u082f\uf24b糄\ue569潫\ue986叄\udc0d䚢샤䤼"));
         fuf(
            var0,
            a.d(
               "镹\uecd5昗\uf86e珴\uf517体욷壴퉈喙꿮ⅼ뢈㋐됻\u0e69膥ᬛ鴓ᒄ滦\ue006箟\ufde7眭캈䃚\uda3e尳힞⥟ꍇ㪨볦㙋觔Ϩ蔿\u1c89雝\ue82a扨\ue5ca缚\uf179䣤숋䑉\udf90凯ꬼ⊊ꓑ㸙끤\u0bdf贖ݸ麿",
               -1299412435,
               1701519105
            )
         );
         fuf(
            var0,
            String.format(
               Locale.ROOT,
               a.b("⇼塂튔䳥읾䇊ﯘ牭\uec37曇\ue150ᬤ閲ే蘑¡몪㕾꾌⦙ꁫ\uda7b和켐䥫쎽稅\uf452溴\ue8f6捂鶁ក踬ࡴ苈㴍라ㇼꠅ≝岯훼兎쮁", 955851191),
               var8 - 16,
               var9 - 1,
               var10 - 16,
               var8 + 16,
               var9 + 9,
               var10 + 16
            )
         );
         fuf(var0, String.format(Locale.ROOT, a.b("섰뢅㈆갗⟳ꄑᭇ銽\u0cfd蘛Ǝﯺ畬\uec99曏\ue035婥헣伖쥊䂩㫱둒⾓", -892878500), fri, var9, frk));
         var1.getInventory().setSelectedSlot(0);
         return false;
      }

      if (frh == 8) {
         double var7 = fri + 3.0;
         var0.getServer().execute(() -> fnq.spawn(var0.getServer(), frd, var7, frj, frk));
         return false;
      }

      if (frh == 40) {
         fuc();
      }

      if (frh < 100) {
         if (frh > 20) {
            fua(var0);
         }

         return false;
      } else {
         Entity var2 = fua(var0);
         if (var2 == null) {
            System.out.println(a.d("쯜뉼㢿ꛇⵜꮹᇻ頜ل財ଔ\uf162羽\ue609氶\uea89僇\udf59䖨쏴䨘", 843544986, 1544139319));
            return true;
         }

         if (var0.mouse.isCursorLocked()) {
            var0.mouse.unlockCursor();
         }

         int var3 = frh - 100;
         int var4 = 0;

         for (int var5 = 0; var4 < fpq.length && var3 >= var5 + fpq[var4].fov; var4++) {
            var5 += fpq[var4].fov;
         }

         if (var4 >= fpq.length) {
            fre = false;
            fnq.active = false;
            ftz(var0);
            vzz.simulated = null;
            ftw();
            fud();
            return true;
         }

         fot var6 = fpq[var4];
         if (var4 != frf) {
            if (frf >= 0) {
               ftf[frf] = fnq.hits - frm;
               ftg[frf] = fnq.critHits - frn;
            }

            frf = var4;
            frl = frh;
            frm = fnq.hits;
            frn = fnq.critHits;
            fnq.aggression = var6.fox;
            fnq.jumping = var6.foy;
            fnq.strafing = true;
            fnq.active = true;
            fre = true;
            System.out.println(a.b("缠ڀ豃ሻ馠ὁꔊⳲ늿㠘뾎", 2089254735) + var6.fou);
         }

         ftf[var4] = fnq.hits - frm;
         ftg[var4] = fnq.critHits - frn;
         if (fpt && frw && fry != fra) {
            System.out.println(a.b("\ud896ꄶ⯵떍㸖룴ʿ譌ᔊ鿫", -897263368) + var6.fou + a.c(-1547238408, "ϙ") + frx);
         }

         frw = false;
         if (fpu == null) {
            if (frh - frl < 20) {
               ftx(var0, var1, var2, var6, var4);
               fty(var0, var1, var2, false);
               return false;
            } else {
               ftx(var0, var1, var2, var6, var4);
               fty(var0, var1, var2, var6.fow);
               return false;
            }
         } else {
            ftk(var0, var1, var2, var6.fow && frh - frl >= 20);
            return false;
         }
      }
   }

   static void ftk(MinecraftClient var0, ClientPlayerEntity var1, Entity var2, boolean var3) {
      float var4 = vxr.getFloat(fpv, var1, var1.getYaw());
      float var5 = vxr.getFloat(fpw, var1, var1.getPitch());
      if (!Float.isNaN(fqd)) {
         double var6 = MathHelper.wrapDegrees(var4 - fqd);
         double var8 = var5 - fqe;
         fpy.add(Math.sqrt(var6 * var6 + var8 * var8));
         if (kwf.target() != null) {
            fqb.add(var6);
            fqc.add(var8);
         } else {
            ftl();
         }

         if (System.getenv(a.c(-365273819, "嵶Ⓧ긝ぴ믆㴚蝒າ都ᩅ鶅柪\ue929炟\ufadf簰왴䦣팃啐\udca1")) != null || Math.sqrt(var6 * var6 + var8 * var8) > 30.0) {
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.c(
                        -1066221823,
                        "뼴요䱗툯妴\udf64攣\uecd5犙\uf849翘薢\u0b7b銍ᢊ鹺\u2432\uabff\u3102뜇㺹䓰쨂冗ힻ嵼\ue4c4檏\uf02c癸ﷀ̎褖Ⴎ雷ᱍꎅ⦣꼶㚊볆숩䡿쿅唍\udb2b抱\ue80a湎\uf580箤脳ࣇ躔ᑫ騲↚Ꝙ\u2d6a뒾㨂䁌쟨䷰팵媏\ue0c3晥\uec74玑綾缵蛿ౌ鈎ᦶ鿹┞겞㋪롳"
                     ),
                     fra,
                     fqd,
                     fqe,
                     var4,
                     var5,
                     var1.getYaw(),
                     var1.getPitch(),
                     kwf.target(),
                     kwf.debug()
                  )
               );
         }
      }

      fqd = var4;
      fqe = var5;
      if (fqk) {
         ftm(var1, var4, var5);
      }

      Vec3d var33 = var1.getEyePos();
      Vec3d var7 = var2.getEntityPos();
      double var34 = Math.toDegrees(Math.atan2(var7.z - var33.z, var7.x - var33.x)) - 90.0;
      if (a.b("쯟뉴㢢ꛚⴆꮭ", 798280618).equals(fpu)) {
         if (--fsh <= 0) {
            fsh = 30 + fro.nextInt(60);
            fqf = (fro.nextDouble() - 0.5) * 6.0;
         }

         var1.changeLookDirection(fqf / 0.15, 0.0);
         if (Math.abs(MathHelper.wrapDegrees(var34 - var1.getYaw())) > 90.0) {
            fqg++;
         }
      }

      fqh++;
      double var10 = var7.x - var1.getX();
      double var12 = var7.z - var1.getZ();
      double var14 = Math.max(0.001, Math.sqrt(var10 * var10 + var12 * var12));
      fqi += var14;
      if (--fsl <= 0) {
         fsl = 15 + fro.nextInt(30);
         fsm = fro.nextInt(3) - 1;
      }

      boolean var16 = Math.abs(var1.getX() - fri) > 12.0 || Math.abs(var1.getZ() - frk) > 12.0;
      double var17 = var14 > 2.6 ? 1.0 : (var14 < 1.4 ? -1.0 : 0.0);
      double var19 = var16 ? 0.0 : fsm;
      double var21 = var10 / var14 * var17 + var12 / var14 * var19;
      double var23 = var12 / var14 * var17 - var10 / var14 * var19;
      double var25 = Math.hypot(var21, var23);
      double var27 = 0.0;
      double var29 = 0.0;
      if (var25 > 1.0E-6) {
         double var31 = Math.toRadians(var1.getYaw());
         var27 = (var23 * Math.cos(var31) - var21 * Math.sin(var31)) / var25;
         var29 = (var21 * Math.cos(var31) + var23 * Math.sin(var31)) / var25;
      }

      double var35 = Math.sin(Math.toRadians(22.5));
      fpx.clear();
      ftn(var0, var0.options.forwardKey, var27 > var35);
      ftn(var0, var0.options.backKey, var27 < -var35);
      ftn(var0, var0.options.leftKey, var29 > var35);
      ftn(var0, var0.options.rightKey, var29 < -var35);
      var0.options.jumpKey.setPressed(var3);
      vzz.simulated = fpx::contains;
   }

   static void ftl() {
      if (fqb.size() >= 8) {
         fpz.add(fqb.stream().mapToDouble(Double::doubleValue).toArray());
         fqa.add(fqc.stream().mapToDouble(Double::doubleValue).toArray());
      }

      fqb.clear();
      fqc.clear();
   }

   static void ftm(ClientPlayerEntity var0, float var1, float var2) {
      kfe var3 = Flow.getInstance().getModuleManager().getByName(a.d("ꚓ\udf00嗖쮧䁝웘粌\uf56e", -365975033, -779416361));
      int var4 = fqh % 100;
      if (fql >= 0) {
         int var5 = fra - fql;
         if (var5 > 0 && fpy.size() > 0) {
            fqn = Math.max(fqn, fpy.get(fpy.size() - 1));
         }

         double var6 = Math.hypot(MathHelper.wrapDegrees(var1 - var0.getYaw()), var2 - var0.getPitch());
         if (fqo < 0 && var5 > 0 && var6 < 1.0) {
            fqo = var5;
         }
      }

      if (var4 == 59 && fql >= 0) {
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.b(
                     "쟾빞㒝ꫥⅾꞮᷩ鐟\u0a53肃ܟﵧ现\uea47怗\ue6e0峮퍡䧈쿏䘧㱺닛⥝꽵▲鰓ሑ裣ູ蔕箓\uf19a栯\uee7d擎\udb5e兩\ud7ae丂쑟뫣ン띀\u2d9bꏢᨦ還ᚆ赛ͪ隸瀍\uf654泬\ue2f4奌\udfd3喥찵䋆㣃뼭㕶ꮱ∘頔ứ铳\u0b4e膄ޭ︦璖\ueac2愯\ue736嶂푚䨴사䚻㵌뎜⧩ꁰ⚘鳔ጡ襸",
                     1839450048
                  ),
                  fqp,
                  fqm,
                  fqo,
                  fqn
               )
            );
         fqp++;
         if (fqn > 35.0) {
            fqq++;
         }

         if (fqo < 0) {
            fqr++;
         } else {
            fqt = fqt + fqo;
         }

         fqs = Math.max(fqs, fqn);
         fql = -1;
      }

      if (var4 == 0 && var3.isEnabled()) {
         fql = fra;
         fqm = Math.hypot(MathHelper.wrapDegrees(var1 - var0.getYaw()), var2 - var0.getPitch());
         fqn = 0.0;
         fqo = -1;
         var3.setEnabled(false);
      } else if (var4 == 60 && !var3.isEnabled()) {
         var3.setEnabled(true);
      }
   }

   static void ftn(MinecraftClient var0, KeyBinding var1, boolean var2) {
      var1.setPressed(var2);
      Key var3 = KeyBindingHelper.getBoundKeyOf(var1);
      if (var2) {
         fpx.add(var3.getCode());
      }
   }

   static void fto(MinecraftClient var0) {
      fra++;
      ClientPlayerEntity var1 = var0.player;
      if (fre && var1 != null && frb >= 0) {
         int var2 = frf;
         Entity var3 = var0.world.getEntityById(frb);
         if (var3 != null) {
            if (System.getenv(a.d("쬝늦㡶ꘟⶭꭱᄹ飙ږ谮௮\uf181罂\ue6f4沴\uea5b借\udfc8䕨쌻䫊", 9974764, -796526430)) != null) {
               System.out
                  .println(
                     String.format(
                        Locale.ROOT,
                        a.d("댡쪁䁂\ude3a喡퍱椶\ue0c0續\uf45c珜親ݨ黊ᒟ鈺⠡ꞹ㴒묂㊱䢹옒巕\udbe0儩\ue891曟ﱿ穨\uf188ཏ蔋᳠髺ၓ꾏◡ꍥ㪒낁칽䐼쎊夔흽溥\ue40b戓", -571099507, -2046622215),
                        fra,
                        var1.getYaw(),
                        vxr.getFloat(fpv, var1, Float.NaN),
                        var1.lastYaw
                     )
                  );
            }

            Integer var4;
            while ((var4 = fqx.poll()) != null) {
               frt = var4;
               fru = !var1.isOnGround() && var1.fallDistance > 0.0;
               fsw[var2]++;
               if (fru) {
                  fsx[var2]++;
               }
            }

            double var5 = var1.getY() - var1.lastY;
            boolean var7 = var1.isOnGround();
            if (!var7 && var5 < 0.0) {
               frq++;
            } else {
               frq = 0;
            }

            for (fpc var9 : fqz) {
               if (var9.land < 0 && var7) {
                  var9.land = fra - var9.tick;
               }
            }

            if (frp && !var7 && var5 > 0.0) {
               ftu(var2);
               frr = 0;
               frs = false;
               fsn[var2]++;
            }

            frp = var7;
            HitResult var18 = var0.crosshairTarget;
            boolean var19 = var18 != null && var18.getType() == Type.ENTITY && ((EntityHitResult)var18).getEntity() == var3;
            boolean var10 = var1.getAttackCooldownProgress(0.5F) > 0.9F;
            frw = var19 && var10;
            if (fpt && frw) {
               frx = String.format(
                  Locale.ROOT,
                  a.d(
                     "֦籞\uf695梥\ue336旀\udf86噪젯䊅앜㽴놻⡜ꉜ⓫麣ᅿ诌ඥ葯︴炏\ueb08浯\ue7ff师퀝䫷쳢䝉릓㏁ꩥⱰꚇᥗ錫ᗸ谘ٟ碥\uf2ea甏\uef9e憹\ud865劐퓇伝셳㯷눆㐄껴₧鬃ᷕ鞼๊胋晴絸\uf760榷\ue050婐\udce2嚾줆䏆얢㱿뚖⣝ꌧ╬龉ᘜ蠦ˬ蒼＃燚\uebfb戲\ue4c0廕텩䬴춆䑍븯ーꭘⵀꞗᦧ",
                     1871305566,
                     49798894
                  ),
                  fra,
                  var7,
                  frq,
                  var5,
                  var1.fallDistance,
                  var1.getVelocity().y,
                  wdt.serverSprinting(var1),
                  var1.getAttackCooldownProgress(0.5F),
                  fra - frt,
                  fsa < 0 ? -1 : fra - fsa
               );
            }

            if (var19) {
               fte[var2]++;
               if (!var7 && var10) {
                  frs = true;
               }

               if (frz >= 5) {
                  ftv(var2);
                  fsa = fra;
                  fsb = var10;
                  fsc = false;
                  fss[var2]++;
                  if (var10) {
                     fst[var2]++;
                  }
               }

               frz = 0;
            } else {
               frz++;
               if (frz == 5) {
                  ftv(var2);
               }
            }

            float var11 = var3 instanceof LivingEntity var12 ? var12.getHealth() : 0.0F;
            if (frv >= 0.0F && var11 < frv - 0.01F) {
               fpc var20 = fts(fra);
               if (var20 != null && var20.damage == 0.0F) {
                  var20.damage = frv - var11;
               }
            }

            frv = var11;

            Integer var21;
            while ((var21 = fqw.poll()) != null) {
               fpc var13 = fts(var21);
               if (var13 != null) {
                  var13.seenCrit = true;
               }
            }

            long var22 = System.nanoTime();

            fpf var15;
            while ((var15 = fqu.peek()) != null) {
               fqu.poll();
               fpc var16 = ftt(var15.fpg);
               if (var16 != null && var16.serverCrit == null) {
                  var16.serverCrit = var15.fph;
                  if (var16.clientCrit && !var15.fph) {
                     System.out
                        .println(
                           String.format(
                              Locale.ROOT,
                              a.d(
                                 "싟뭿ㆼ꿄\u245fꊭᣱ鄅བ藬ȥ\uf80d皔\uef34敼\ue390妋혈䲬쫲䌊㥝럹ⰹꩇ\u20c8饡\u1776趆\u0bda聩纀\uf4f2洉\ueb52憵\ude7a告틝䬠셲뾌㗕눽⣲ꛂὕ閧Ꮳ蠻ٛﲟ甪\uf323槈\ue792就\udab4傁줃䞢㷤먓け꺉❪鵿ᮉ釓\u0e62蓠ʉﭝ燱\ueff7摀\ue250壴턺佑얅䏞㠴뛽Ⳝꕞ⎾駬ᘑ豛૯茤礚\uf7d3氶\uea34悸\udec2團춺䯸쀋븀㒩굽⬐ꆗ",
                                 350081476,
                                 2074678036
                              ),
                              var16.fallTick,
                              var16.land,
                              var16.charge,
                              var15.fpj,
                              var15.fpk,
                              var15.fpl,
                              var15.fpi
                           )
                        );
                  }
               }
            }

            foo var23;
            while ((var23 = fqv.peek()) != null) {
               fqv.poll();
               fpc var17 = ftt(var23.fop);
               if (var17 != null) {
                  var17.serverDamage = var17.serverDamage + var23.foq;
               }
            }

            while (!fqz.isEmpty() && fra - fqz.peekFirst().tick > 40 && var22 - fqz.peekFirst().nanos > 1000000000L) {
               fqz.pollFirst();
            }
         }
      }
   }

   static double ftp(String var0, double var1) {
      return ftq(var0, var1, 0);
   }

   static double ftq(String var0, double var1, int var3) {
      String var4 = System.getenv(var0);
      if (var4 == null) {
         return var1;
      }

      String[] var5 = var4.split(a.d("⸼", -1031349015, 690811640));
      return Double.parseDouble(var5[Math.min(var3, var5.length - 1)].trim());
   }

   static void ftr(MinecraftClient var0, Entity var1) {
      ClientPlayerEntity var2 = var0.player;
      if (fre && var1.getId() == frb && var2 != null) {
         if (var0.crosshairTarget instanceof EntityHitResult var3 && var3.getEntity() == var1) {
            Box var6 = var1.getBoundingBox();
            fqj.add((var3.getPos().y - var6.minY) / (var6.maxY - var6.minY));
         }

         fpc var5 = new fpc();
         var5.phase = frf;
         var5.tick = fra;
         var5.nanos = System.nanoTime();
         var5.charge = var2.getAttackCooldownProgress(0.5F);
         var5.sprintSent = wdt.serverSprinting(var2);
         var5.clientCrit = var5.charge > 0.9F
            && var2.fallDistance > 0.0
            && !var2.isOnGround()
            && !var2.isClimbing()
            && !var2.isTouchingWater()
            && !var2.hasStatusEffect(StatusEffects.BLINDNESS)
            && !var2.hasVehicle()
            && !var5.sprintSent;
         var5.fallTick = frq;
         fry = fra;
         var5.sinceKnock = fra - frt;
         var5.midAirKnock = fru;
         fqy.add(var5);
         fqz.add(var5);
         frr++;
         if (fsa >= 0 && !fsc) {
            fsc = true;
            if (fsb) {
               int var7 = fra - fsa;
               fsv[var5.phase][var7 <= 0 ? 0 : (var7 == 1 ? 1 : (var7 == 2 ? 2 : (var7 <= 5 ? 3 : 4)))]++;
            }

            fsu[var5.phase]++;
         }
      }
   }

   static fpc fts(int var0) {
      fpc var1 = null;

      for (fpc var3 : fqz) {
         if (var3.tick <= var0 && var0 - var3.tick <= 8) {
            var1 = var3;
         }
      }

      return var1;
   }

   static fpc ftt(long var0) {
      fpc var2 = null;

      for (fpc var4 : fqz) {
         if (var4.nanos <= var0 && var0 - var4.nanos < 400000000L) {
            var2 = var4;
         }
      }

      return var2;
   }

   static void ftu(int var0) {
      if (var0 >= 0 && fsn[var0] != 0) {
         if (frr > 0) {
            fso[var0]++;
         }

         if (frr > 1) {
            fsp[var0]++;
         }

         if (frs) {
            fsq[var0]++;
            if (frr > 0) {
               fsr[var0]++;
            }
         }
      }
   }

   static void ftv(int var0) {
      if (fsa >= 0 && fsb && !fsc && var0 >= 0) {
         fsv[var0][5]++;
      }

      fsa = -1;
   }

   static void ftw() {
      for (fpc var1 : fqy) {
         if (var1.sinceKnock >= 0 && var1.sinceKnock <= 15) {
            boolean var2 = var1.serverCrit != null ? var1.serverCrit : var1.seenCrit;
            if (var2) {
               fsy[var1.phase]++;
               fsz[var1.phase] = fsz[var1.phase] + var1.sinceKnock;
               if (var1.midAirKnock && var1.sinceKnock <= 2) {
                  fta[var1.phase]++;
               }
            }
         }
      }
   }

   static void ftx(MinecraftClient var0, ClientPlayerEntity var1, Entity var2, fot var3, int var4) {
      System.arraycopy(fsd, 0, fsd, 1, fsd.length - 1);
      fsd[0] = var2.getEntityPos();

      for (int var5 = 1; var5 < fsd.length; var5++) {
         if (fsd[var5] == null) {
            fsd[var5] = fsd[0];
         }
      }

      if (--fsh <= 0) {
         fsh = 6 + fro.nextInt(14);
         fsf = (fro.nextFloat() - 0.5F) * 0.5F;
         fsg = 0.8F + fro.nextFloat() * 0.8F;
         fse = 0.7F + fro.nextFloat() * 0.6F;
      }

      int var35 = 2 + fro.nextInt(2);
      Vec3d var6 = fsd[var35];
      Vec3d var7 = fsd[var35].subtract(fsd[var35 + 1]);
      Vec3d var8 = var6.add(var7.multiply(var35 * 0.6));
      Vec3d var9 = var1.getEyePos();
      double var10 = var8.x - var9.x;
      double var12 = var8.z - var9.z;
      double var14 = Math.max(0.001, Math.sqrt(var10 * var10 + var12 * var12));
      double var16 = -var12 / var14;
      double var18 = var10 / var14;
      double var20 = var8.x + var16 * fsf - var9.x;
      double var22 = var8.z + var18 * fsf - var9.z;
      double var24 = var8.y + fsg - var9.y;
      float var26 = (float)(MathHelper.atan2(var22, var20) * 180.0F / (float)Math.PI) - 90.0F;
      float var27 = (float)(-(MathHelper.atan2(var24, Math.sqrt(var20 * var20 + var22 * var22)) * 180.0F / (float)Math.PI));
      if (fsi > 0) {
         fsi--;
         var26 += fsk;
      } else if (--fsj <= 0) {
         fsj = 90 + fro.nextInt(120);
         fsi = 5 + fro.nextInt(10);
         fsk = (fro.nextBoolean() ? 1 : -1) * (35.0F + fro.nextFloat() * 40.0F);
      }

      float var28 = var3.foz * fse;
      float var29 = MathHelper.wrapDegrees(var26 - var1.getYaw());
      float var30 = var27 - var1.getPitch();
      float var31 = MathHelper.clamp(var29 * 0.55F, -var28, var28) + (float)fro.nextGaussian() * 0.35F;
      float var32 = MathHelper.clamp(var30 * 0.35F, -var28 * 0.6F, var28 * 0.6F) + (float)fro.nextGaussian() * 0.2F;
      var1.changeLookDirection(var31 / 0.15F, var32 / 0.15F);
      double var33 = Math.sqrt(var31 * var31 + var32 * var32);
      ftb[var4] = ftb[var4] + var33;
      ftc[var4] = Math.max(ftc[var4], var33);
      ftd[var4]++;
      fth.add(var33);
   }

   static void fty(MinecraftClient var0, ClientPlayerEntity var1, Entity var2, boolean var3) {
      double var4 = var2.getX() - var1.getX();
      double var6 = var2.getZ() - var1.getZ();
      double var8 = Math.sqrt(var4 * var4 + var6 * var6);
      if (--fsl <= 0) {
         fsl = 15 + fro.nextInt(30);
         fsm = fro.nextInt(3) - 1;
      }

      boolean var10 = Math.abs(var1.getX() - fri) > 12.0 || Math.abs(var1.getZ() - frk) > 12.0;
      var0.options.forwardKey.setPressed(var8 > 2.6);
      var0.options.backKey.setPressed(var8 < 1.4);
      var0.options.leftKey.setPressed(!var10 && fsm < 0);
      var0.options.rightKey.setPressed(!var10 && fsm > 0);
      var0.options.jumpKey.setPressed(var3);
   }

   static void ftz(MinecraftClient var0) {
      var0.options.forwardKey.setPressed(false);
      var0.options.backKey.setPressed(false);
      var0.options.leftKey.setPressed(false);
      var0.options.rightKey.setPressed(false);
      var0.options.jumpKey.setPressed(false);
   }

   static Entity fua(MinecraftClient var0) {
      if (frb >= 0) {
         Entity var1 = var0.world.getEntityById(frb);
         if (var1 != null) {
            return var1;
         }
      }

      for (PlayerEntity var2 : var0.world.getPlayers()) {
         if (a.b("ㄭ䢶쉦小ퟭ共\ueb39", 1180709228).equals(var2.getGameProfile().name())) {
            frb = var2.getId();
            return var2;
         }
      }

      return null;
   }

   static void fub(MinecraftClient var0) {
      if (!frg) {
         frg = true;
         ClientTickEvents.START_CLIENT_TICK.register(fpo::fto);
         AttackEntityCallback.EVENT
            .register(
               (AttackEntityCallback)(var0x, var1, var2, var3, var4) -> {
                  if (var1.isClient()) {
                     ftr(MinecraftClient.getInstance(), var3);
                     return ActionResult.PASS;
                  } else if (fre && var3.getId() == fnq.spawned && var0x.getUuid().equals(frd)) {
                     float var5 = var0x.getAttackCooldownProgress(0.5F);
                     boolean var6 = var5 > 0.9F
                        && var0x.fallDistance > 0.0
                        && !var0x.isOnGround()
                        && !var0x.isClimbing()
                        && !var0x.isTouchingWater()
                        && !var0x.hasVehicle()
                        && !var0x.isSprinting();
                     fqu.add(new fpf(System.nanoTime(), var6, var5, var0x.fallDistance, var0x.isOnGround(), var0x.isSprinting()));
                     return ActionResult.PASS;
                  } else {
                     return ActionResult.PASS;
                  }
               }
            );
         ServerLivingEntityEvents.AFTER_DAMAGE.register((AfterDamage)(var0x, var1, var2, var3, var4) -> {
            if (fre && var0x.getId() == fnq.spawned) {
               fqv.add(new foo(System.nanoTime(), var3));
            }
         });
         wcn.listen(var0x -> {
            if (var0x instanceof EntityAnimationS2CPacket var1 && var1.getEntityId() == frb && var1.getAnimationId() == 4) {
               fqw.add(fra);
            } else if (var0x instanceof EntityVelocityUpdateS2CPacket var2 && var2.getEntityId() == frc && fre) {
               fqx.add(fra);
            }
         });
      }
   }

   static void fuc() {
      kfe var0 = Flow.getInstance().getModuleManager().getByName(a.d("훣꽴▼믃〔뚧ೣ蔢᭐釺", 974682502, 1151512379));

      for (vmo var2 : var0.getSettings()) {
                  if (java.util.Objects.equals(var2.getName(), a.c(1880711168, "恆ᧆ錎ൢ蚲"))) {
            ((vlv)var2).set(a.c(2121573387, "ꑝ\uddd2圍쥯䊾"));
         }
         else if (java.util.Objects.equals(var2.getName(), a.c(1868850072, "描ᩜ邘\u0ee8蔲Ή맍"))) {
         }
         else if (java.util.Objects.equals(var2.getName(), a.d("껯흽嶬쏆䠖캽瓈ﴎ捇\ue9e0渢", -333356408, 1350159423))) {
         }
         else if (java.util.Objects.equals(var2.getName(), a.d("誀\uf312秃\ue7a9汹\uead2僕\ud976䜾춙䩜뀼", 1388699342, -804629487))) {
         }
         else if (java.util.Objects.equals(var2.getName(), a.d("ໞ睃ﶒ揥\ue804溋퓔崷썳", 412538188, -1201939498))) {
         }
         else if (java.util.Objects.equals(var2.getName(), a.d("청딠㿾ꆗ⩜곺ᚨ", 1076721374, -187909596))) {
            ((vkl)var2).set(true);
         }
         else if (java.util.Objects.equals(var2.getName(), a.c(1173227593, "ࠀ熓כֿ攭"))) {
         }
         else if (java.util.Objects.equals(var2.getName(), a.b("呖ⷐ꜅㥸늲㐕", -1771482110))) {
            ((vkl)var2).set(false);
         }
         else if (java.util.Objects.equals(var2.getName(), a.c(1152789733, "ⲿ唹\udfee䆝쩝䳱\uf6a4罔"))) {
         }
         else if (java.util.Objects.equals(var2.getName(), a.c(2103697344, "\udf81ꘑⳋ늷㥸"))) {
            ((vmc)var2).set(0.0);
         }
      }

      var0.setEnabled(fpu == null && !a.c(-933814889, "ᶧ").equals(System.getenv(a.d("婲⏉ꤙ㝰볂㨞聖শ韹ᵁ骁惠\uee3e瞏", 1894222909, 1946080775))));
      if (fpu != null) {
         kfe var6 = Flow.getInstance().getModuleManager().getByName(a.b("娭⎾ꥨ㜙볣㩦耲\u09d0", 586439278));

         for (vmo var11 : var6.getSettings()) {
                        if (java.util.Objects.equals(var11.getName(), a.b("豁\uf5cd缅\ue161檣\uec0f噚\udfaa", 1418365979))) {
               ((vlv)var11).set(a.d("授ᨶ郠ຝ蕁Ϫ", 1785558030, 1599281123).equals(fpu) ? a.c(1295193606, "ᙃ濝\ue50b筶\uf0aa瘁") : a.c(-320494210, "ꔫ\udca0噶젎䏒앹"));
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("節ɀ袈ᛤ鴴", 2060745606))) {
            }
            else if (java.util.Objects.equals(var11.getName(), a.d("\uea12鎁᥋蜩\u0cbb詌【맰", -1442425588, -1078018213))) {
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("職狀猤\ued4d暆\ue020婲", -1610448864))) {
               ((vkl)var11).set(true);
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("薬ﰿ盡\ue881", -335837723))) {
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("ぁ䧌쌅嵩횤倇\uea5b揢\ufdea睍\uf093ૢ萪", -1610403816))) {
               ((vkl)var11).set(false);
            }
            else if (java.util.Objects.equals(var11.getName(), a.d("⃒奋펜", -1278028333, -127077053))) {
               ((vlv)var11)
                                    .set(
                                       a.d("ᰉ斣\uef79焛\ufada", -1756913955, -689470814).equals(System.getenv(a.b("皸༃藓ᮺ逈ᛔ겜╼묳ㆋ뙋䰤싧孑턑埾\uedaf扶\uf8c1", 1377138413)))
                                          ? a.c(1091427018, "\uda9cꌖ⧌랮㱯")
                                          : a.b("煒ࣈ舋ᱽ鞹ᄅ", 1551593754)
                                    );
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("㕣䳰옸塏펅唯\uef61暝", 1019098427))) {
               ((vlv)var11).set(a.b("뱬엲伨텒媌", -2028487640));
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("ࠖ熚ﭘ攡\ueee8", -332265382))) {
               ((vlv)var11).set(a.c(1383453864, "퓸굻➬만㈄뒴\u0efa"));
            }
            else if (java.util.Objects.equals(var11.getName(), a.b("\udbcbꉉ⢍뛺㴰뮋ǚ蠦", -1290675307))) {
               ((vmc)var11).set(ftp(a.d("\u173c溇\ue457稾\uf18c睐촘䓸\udab7倏ퟏⶠꍣ㫕낕㙺谼Ͼ饚Ἅ雧\uecbc戍六", -952433355, 239866455), 1.0));
            }
            else if (java.util.Objects.equals(var11.getName(), a.c(1206453375, "д維\uf77a楆\ue2d9摥\ude3a埅즕䌸"))) {
               ((vlv)var11)
                                    .set(
                                       System.getenv(a.d("셮룕㈅걬⟞ꄂᭊ銪\u0ce5虝Ɲﯲ由\uec87曇\ue028婰햬伓쥌䂴㫹", 1988821749, 998884299)) == null
                                          ? a.c(225800798, "爖அ腝Ἥ铳")
                                          : a.b("㟮乩쒼嫊턆垵", -1597425749)
                                    );
            }
            else if (java.util.Objects.equals(var11.getName(), a.c(-1233694381, "儐⢌ꉓ㰬럴ㅙ譞˩鲢ᘎ釟"))) {
               ((vmc)var11).set(ftq(a.c(-1544565096, "컈띳㶣ꏊ⡸꺤ᓬ鴌̓觻\u0e3b\uf454窗\ue321楡\uef8e嗖\uda0a䂵웪伒㕟"), 0.45, 0));
            }
            else if (java.util.Objects.equals(var11.getName(), a.d("ୢ狾\uf821晞\ued86欫턬墉웍", 2025840971, -681711000))) {
               ((vmc)var11).set(ftq(a.d("긇ힼ嵬쌅䢷칫琣ﷃ掌\ue934滴钛ᩘ菮ম轁㔙뫅⁺꘥\u2fdd喐", 1305304896, 670036247), 0.85, 1));
            }
         }

         String var9 = System.getenv(a.b("\ue515鲮ᙾ蠗Υ蕹㼱뛑⢞ꈦ◦\udf89兊주䊼쑓縎\uf1dd步\ued35擋", 210822470));
         tiq var12 = var9 == null ? null : tiq.open(var9);
         kwf.useStudio(var12);
         System.out
            .println(
               a.b("醌\ue82c拯ﲗ県\uf1dc䮛쉭尡훱兯\uab1c◀뱰㘪낍\u0ad8", -1020554759)
                  + (
                     var12 == null
                        ? a.c(156908093, "㩤䏷줹坁\udc99娭\ue077槃\uf78d")
                        : var12.name
                           + a.c(-2033883686, "旸᱁")
                           + (var12.auraModel() == null ? a.b("ꀋ\ud9bb匇촷䛴쁂稂\uf3bc涫\ue74e惂", -1171218354) : a.c(-253598351, "攘Ჽ险ࠋ莓ժ뽭㛃"))
                           + a.b("\ue835", 1012852765)
                  )
            );
         var6.setEnabled(true);
      }

      Flow.getInstance().getModuleManager().getByName(a.b("樂耺૨钂Ὡ駻⎪ꩀ㐘뺳", -972949004)).setEnabled(true);

      for (String var15 : new String[]{
         a.b("폤ꩽ₪뻷㔒뎣৪老ṙ", -87501908), a.c(-924561517, "俖㙆벰⋾ꤱ⾝闺ᰪ艼ࣀ輋"), a.c(1129833506, "\ue46b鷮\u173c襖ʣ萾㹯래"), a.b("抔ᬑ釃ྩ葅ˏ뢇ㅧ꼰", 1035231964)
      }) {
         kfe var16 = Flow.getInstance().getModuleManager().getByName(var15);
         if (var16 != null) {
            var16.setEnabled(false);
         }
      }
   }

   static void fud() {
      StringBuilder var0 = new StringBuilder(
         a.d(
            "뿋왢䲸틛多\udfe2早\uec05牐\uf8e9罽蕃\u0b9b鈯ᡰ麊ⓟꬹㆻ럱㸛䐒쫾儹흑嶄\ue424橢\uf0a4盄ﵬΠ覷မ陜᳭ꌱ⥭꾏㘥뱧싎䣒콨営\udbd4戒\ue8a1溧\uf53c筈膔ࠣ蹊ᒄ髟Ⅸꟾⷍ됑㪩䃲읉䵇펒娤\ue07a暍\uecf4獠零翏蘘೮鋼ᤉ齓◇갼㉖뢠㻔䕦쮻凄\ud852庾\ue4ec欑\uf15b矯︤Ѵ誓ᄫ靠᷷ꏎ⨘낥㛾봉썘䦠퀠噇\udc83挶\ue972澔\uf5f1籥芦ࣻ輎ᕝ鮅",
            66781281,
            247185327
         )
      );
      int[] var1 = new int[8];

      for (int var2 = 0; var2 < fpq.length; var2++) {
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         double var11 = 0.0;
         int var13 = 0;
         double var14 = 0.0;
         int var16 = 0;
         double var17 = 0.0;
         double var19 = 0.0;
         float var21 = 1.0F;
         int[] var22 = new int[8];

         for (fpc var24 : fqy) {
            if (var24.phase == var2) {
               var3++;
               var19 += var24.charge;
               var21 = Math.min(var21, var24.charge);
               if (var24.clientCrit) {
                  var4++;
                  var22[Math.min(7, var24.fallTick)]++;
               }

               if (var24.serverCrit != null) {
                  var6++;
                  if (var24.serverCrit) {
                     var5++;
                  } else if (var24.clientCrit) {
                     var10++;
                  }
               }

               if (var24.seenCrit) {
                  var7++;
               }

               if (var24.clientCrit && var24.land >= 1 && var24.land <= 2) {
                  var8++;
                  if (Boolean.FALSE.equals(var24.serverCrit)) {
                     var9++;
                  }
               }

               if (var24.damage > 0.0F) {
                  if (var24.seenCrit) {
                     var11 += var24.damage;
                     var13++;
                  } else {
                     var14 += var24.damage;
                     var16++;
                  }
               }

               var17 += var24.serverDamage;
               var0.append(
                  String.format(
                     Locale.ROOT,
                     a.d("쳄딣㾯ꇗ⩁겸ᛢ齅Ņ诽౸\uf656碈\ue16f正\ued9b域\ud813䋵쓮䴐㜀맻∣ꐝ⺄霾\u192e莑\u05c9踬炢\ufae4捃\ue54f濷퀫婆\udcc1䔺콬놖㯙밼⚨ꢒ", -497618652, -1150140949),
                     fpq[var2].fou,
                     var24.tick,
                     var24.clientCrit,
                     var24.serverCrit,
                     var24.seenCrit,
                     var24.charge,
                     var24.fallTick,
                     var24.land,
                     var24.sinceKnock,
                     var24.midAirKnock,
                     var24.sprintSent,
                     var24.damage,
                     var24.serverDamage
                  )
               );
            }
         }

         var1[0] += var3;
         var1[1] += var4;
         var1[2] += var5;
         var1[3] += var7;
         var1[4] += var10;
         double var36 = fpq[var2].fov / 20.0;
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.c(
                     -1462789481,
                     "骅\ue325槦\uf79e簅缾䂴줌坉\uddb0婢ꀎ⻞뜡㵪믚Ǒ踈ᒶ鋬ᬇ愂\ueff8瑵\uf250碈셸伸헔厘\ud87f⛭겭㕙댆㦼虱\u0c49誂፲饩\ue7cb涎\uea3f烣ﻁ䜊췺䯱큳帖ꓐⵣꬡ㇅뿛Ѽ苬ࣔ鄏Ό旬\ue24d栋\uf6cb罵씠䏆즀嘰\udcba嫓ꍍ⦸랧㱛먙¹褲\u175b鷕ᯀ怿\ueee3璁﵁篑솧乐퐄勦\udb2fℙ꾌㑼눦㣠蚂ང闷Ꮵ顕\ue611沱\uf534獝礪䘩찫䪜킂夷ꟿⷽꨖが뻦ݢ"
                  ),
                  fpq[var2].fou,
                  var3,
                  var3 / var36,
                  var4,
                  var7,
                  var5,
                  var6,
                  var10,
                  var8,
                  var9,
                  var3 == 0 ? 0.0 : var19 / var3,
                  var21
               )
            );
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.b(
                     "ᦧ怇\ueac4璼Ｇ禓쎖䨮푫庞\ud948⌵귮㑙븈㢼芰൰韘ᆔ頷\ue227沃\uf743煦ﮯ䈗챚囹탮孕ꖉ⾇똻ち몀Ջ輷৬遚ᩋ擻\ueebf椟\uf392緻쐣于좕匂\udd79➥깓⡏늵㲷蜞ǘ讯ቭ鳍\ue6ce慩\ueb23痷ﱓ䘍삭䫢하徔\ud9b2\u202bꪚ㒊뽪㤦莊\u0a0d鐺Ỳ颮\ue31d涀\uf7a3繯\uf8d6䊏촻圢톐塛ꈫⲳ뜘ㄟ",
                     -988735069
                  ),
                  fpq[var2].fou,
                  var13 == 0 ? 0.0 : var11 / var13,
                  var13,
                  var16 == 0 ? 0.0 : var14 / var16,
                  var16,
                  var17,
                  Arrays.toString(Arrays.copyOfRange(var22, 1, 8))
               )
            );
         if (fpq[var2].fow) {
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.c(
                        2057705984,
                        "ᨴ掔\ue957眯ﲴ稀쀅䦽ퟸ崃\udacf₦깬㟞뷃㬪脤ັ鑕ሚ鯰\ue1bd潆\uf4df犡\uf86d䆗쿞啨퍽墊ꙐⰅ뗣㎾뤆ډ賠ੲ鎇ᦄ朩\ued30檞\uf051總쟭䴏쬗僘\udeb6⑻궄⮔넦㼴蒀ɘ蠤ᇸ齉\ue540披\ue8bb瘰\uffc9䖛썷䥩훀屒\uda67⎰ꤌ㝔벻㪺聈ছ韦"
                     ),
                     fpq[var2].fou,
                     fsn[var2],
                     fso[var2],
                     fsp[var2],
                     fsq[var2],
                     fsr[var2],
                     fsq[var2] == 0 ? 0.0 : 100.0 * fsr[var2] / fsq[var2]
                  )
               );
         }

         int[] var25 = fsv[var2];
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.d(
                     "韝\uee7d撾陼煝\uf7e9䷬쑔娑탣圼굌⎁먥ぴ뚒\u0cda荅᧮鿾ᙍ江\ue2e7礿ｓ疗찦䉶\ud8d8庑핣⯶ꇱ㠁빏㒷譸ň蟟Ḽ鑴\uea81惐\ue776綼\uf3cb䨙샮䛪\udd30半ꦈ\u202aꙹ㲋늗ड迠ח鱏ዠ棰\uef47攇ﮍ牵젾于쒝嬾톫垓깔⒤몳ㅑ뜘න萣ᨛ郌ᛜ洫\ue3ec禆\uf008盲첻䌅\ud910忭혽ⱋꊑ㥺뼳㖽",
                     -1134097524,
                     255237204
                  ),
                  fpq[var2].fou,
                  fss[var2],
                  fst[var2],
                  fsu[var2],
                  var25[0],
                  var25[1],
                  var25[2],
                  var25[3],
                  var25[4],
                  var25[5]
               )
            );
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.b(
                     "孱⋑ꠒ㙪뷱㭅腀ࣸ隽᱇鮑懡\uef3a皃ﳙ稫쁦便픔匋\udae4ꃴ⸃떟㏤뤸\u008e軗ᐻ鈥ᦎ\ue71e洕\uf4b6狲\uf845䞃췩䬧튑墕♰갢⮟녌㽼蛲\u0c57言ᆐ龧攷\uec97櫗\uf063繶었䌐쥮傧\ude54ꐝ⏥ꦫ㜳뻄ӑ舧ࡢ韔ᵓ魯抴\ue808癞ﶧ篫섈䢉훯尦\uda66ꇎ⼂땲㳭멆V迭ᗠ錏\u1a9c\ue0e6測\uf5cb珒卵䝰캤呛툔妤➳굁㒏닥㠫螝\u0d84譭ᅿ",
                     -851158150
                  ),
                  fpq[var2].fou,
                  fsw[var2],
                  fsx[var2],
                  fsy[var2],
                  fsy[var2] == 0 ? 0.0 : (double)fsz[var2] / fsy[var2],
                  fta[var2],
                  ftf[var2],
                  ftg[var2]
               )
            );
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.d(
                     "嘨⾈ꕋ㬳남㘜谙֡鯤ᄔ雏沺\ue220篅\uf197睡촲䊭\ud85f帙\ud7ff귴⍟뢅㻥둣ඖ莊ᥱ鼹ᓏ\uea06恂怜羨\uf55f䫌삼䙭\udf94喐⭼ꄥ⚜밌㉱诡Ł蜓᳞銭桧\ue1d9枀ﵨ獫좛之쑶工퍟ꤕ⺲ꓦ㨢뎍ঈ輺խ髙၅阽澤\ue541笏\uf0f4皫찂",
                     -685367455,
                     10045795
                  ),
                  fpq[var2].fou,
                  ftd[var2] == 0 ? 0.0 : ftb[var2] / ftd[var2],
                  ftc[var2],
                  ftd[var2] == 0 ? 0.0 : 100.0 * fte[var2] / ftd[var2]
               )
            );
      }

      fth.sort(Double::compare);
      double var27 = fth.isEmpty() ? 0.0 : fth.get((int)(fth.size() * 0.95));
      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.d(
                  "\udaa7ꌇ⧄랼㰧뫤 襇\u171e鶶\u1a7d\ue078滧\uf757紙ﯯ䇮츧哕틀孴ℴ꾜㑐눨㢪腚༄闶Ꭻ頓曘\uecde男\uf325秐왔䰳쫠博\ud956ꞿⶭ꩘ボ뺻ݿ跊\u0b96遐Ṭ\ue4a5浓\ueb46燧ﾡ䐑싏䢺텼忚▊ꈠ⡩뛧㼒蔀Ϲ親ᙖ鳕\u1aed\ue33e榇\uf7cc簶奄䂘줍圸\uddf6宥⁞껔㒾뵥㯞",
                  -335628023,
                  156525469
               ),
               var1[0],
               var1[1],
               var1[3],
               var1[2],
               var1[4],
               var27
            )
         );
      if (fpu != null) {
         fpy.sort(Double::compare);
         double var28 = fpy.isEmpty() ? 0.0 : fpy.get((int)(fpy.size() * 0.95));
         double var30 = fpy.isEmpty() ? 0.0 : fpy.get(fpy.size() - 1);
         double var31 = fpy.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.c(
                     -862529067,
                     "\ud9daꁺ⪹듁㽚릊ύ註ᑷ麧ᥱ\ue356淈\uf463繣\uf884䋀촋埬퇩堟≉곦㝹녇㮁舣న雇ႝ鬱斷\uefbe瘟\uf005窸앧伎짖偸\uda70\ua4c7⻙ꥤ㎪붞ѕ軯ࢿ錹ᴌ\ue799港\ue87c狇ﳍ䝯솴䯏퉙峢⛰ꄁ⭜떛㰽虽Í諛ᕼ龹᧐\ue056檡\uf4e6缊寧䎣쨲呎\ude9a墟〈귳㞚븝㣭芼ൊ霗ᇥ頣扅\uecd3眤\uf178箭엛䰝횣價\udb0eꔘ⾬뙸〕몒"
                  ),
                  fpu,
                  var31,
                  var28,
                  var30,
                  fqh == 0 ? 0.0 : 100.0 * fqg / fqh,
                  fqh == 0 ? 0.0 : fqi / fqh
               )
            );
         if (fqk) {
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.b(
                        "⮘券\ud8fb䚃촘䯈\uf18f硹\ue635泥\ueb59ᄡ鿶ء谀૦낿㽨ꗂ⎋ꨈ퀍庿앩䌊짐灢ﹷ擏\ue297椤鞳᷹葉ɞ袻㝱봄㯟ꉸ⡮嚅\udc85嬩쇱侑\uf641粫\ufaf2愮\uef5bᖐ鱼ᨰ胉ຐ땭㎨맃⁓꺠풿卍\ud907䞜칯琿\uf2cc碓\ue769淳\ueb85ሔ颰ۯ贇\u0b04놨㡱ꘈⳟꫀ텫忻었䱘쫼炼＄攗\ue3a7橴逋ẑ蕫̽覼㟈븐Ⓘꊾ⤉圎\udda2䑷숎䣅\uf72b絰\ufbcc憓\ue83bᚬ鲩᭛脍ྦ똹㰋뫝ⅰ꼰헔受\uda2f䃷캄甓\uf359秣\ue02f渉钘፭餿ߌ跛㐱닿㢄ꝛ",
                        -1970459791
                     ),
                     fqp,
                     fqq,
                     fqr,
                     fqp - fqr == 0 ? 0.0 : fqt / (fqp - fqr),
                     fqs
                  )
               );
         }

         fqj.sort(Double::compare);
         if (!fqj.isEmpty()) {
            int var32 = fqj.size();
            System.out
               .println(
                  String.format(
                     Locale.ROOT,
                     a.c(
                        1493683686,
                        "췙둹㺺ꃂ⭙궉៎鸸t誤ി\uf74f禅\ue060橻\uec87囄\ud91b䎧엪䱉㘐뢻⍺ꕃ⾑阢ᡢ苍Ґ輲燲ﯩ戃\ue44f溧텣嬈\udd8b䑻츥냙㪒봨⟣꧆ၓ骯᳨蜸ॆ\uf39f稧ﰥ曎\ue894匷햲徇옆䣸㊠땞㼗ꇓ⡾鉹ᓎ黔š讵\u0d97\uf450绪\ue0a5欀\ued11埭\ude32䁚쫐䲙㜡맬⏏꩘Ⲥ雼᥅茑ף"
                     ),
                     fqj.get(var32 / 10),
                     fqj.get(var32 / 2),
                     fqj.get(var32 * 9 / 10),
                     fqj.get(0),
                     fqj.get(var32 - 1),
                     var32
                  )
               );
         }

         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.b("彼⛜갟㉧맼㼬蕫ಝ鋑᠁龆时\ueb26犋\uf8c5繧쐶䯫텚圆\udee9ꓹ⨎뇁㞳뵡ӟ誖ဠ阵ᶘ\ue343椈\uf0f4皿ﱏ䏜짢伸훏岕∥", 584474418),
                  fpy.stream().filter(var0x -> var0x > 20.0).count(),
                  fpy.stream().filter(var0x -> var0x > 30.0).count(),
                  fpy.stream().filter(var0x -> var0x > 40.0).count(),
                  fpy.size()
               )
            );
         ftl();
         tiq var33 = kwf.studioProfile();
         if (var33 == null && System.getenv(a.d("䶲㐉뻙₰ꬂⷞ鞖Ṷ耹ઁ赁眮吝恛\uea1b泴횶奰쏀", 1954468119, -476668688)) != null) {
            var33 = tiq.open(System.getenv(a.b("箳Ȉ裘ᚱ鴃ᯟꆗ⡷똸㲀뭀䄯쿬噚\udc1a嫵\ue0b7潱\uf5c1", 1054702566)));
         }

         ArrayList var34 = new ArrayList();
         if (var33 != null) {
            var34.addAll(var33.tapes());
         }

         for (String var35 : syq.report(fpz, fqa, var34)) {
            System.out.println(a.b("ᮑ戱\ue8f2皊ﴑ篁솆䡰혼峬\udb72℁꿍㙡밴㫄胅", 1097866212) + var35);
         }
      }

      try {
         Path var29 = Path.of(a.b("뙒쿩䔹\udb50僂홬汶\ue596篙\uf161盰賌ȋ鮿", 839693882));
         Files.writeString(var29, var0.toString(), StandardCharsets.UTF_8);
         System.out.println(a.c(-1571531035, "嚈⼨ꗫ㮓뀈㛺貹Ս魄") + var29.toAbsolutePath());
      } catch (IOException var26) {
         System.out.println(a.b("㫯䍏즌埴\udc6f媝\ue0de椪\uf723緔切y身ᜓ鵁\u1bf4", 1235106459) + var26);
      }
   }

   static fot[] fue() {
      String var0 = System.getenv(a.b("䷓㑨뺸⃑ꭣ\u2dbf韷ḗ聘ૠ贠睁聯怤\uea62", -531083878));
      if (var0 == null) {
         return fpp;
      }

      ArrayList var1 = new ArrayList();

      for (String var5 : var0.split(a.b("啖", 508253563))) {
         for (fot var9 : fpp) {
            if (var9.fou.equals(var5.trim())) {
               var1.add(var9);
            }
         }
      }

      return var1.toArray(new fot[0]);
   }

   static void fuf(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
