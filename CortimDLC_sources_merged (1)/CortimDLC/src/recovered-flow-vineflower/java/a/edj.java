package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult;

final class edj {
   private static final MinecraftClient edk = MinecraftClient.method_1551();
   private static final long edl = ejl.offsetOf(edk, edk.method_1483());
   private static final long edm = ejl.offsetOf(edk, edk.field_1713);
   private static final long edn = ejl.offsetOf(edk, edk.field_1729);
   private static final long edo = ejl.offsetOf(edk, edk.field_1769);
   private static final Field edp = vxr.find(
      MinecraftClient.class,
      a.d("梙ᄣ鯡\u05ca蹞࣫늿㭅ꔜ⾼\ua87c刊\udccf䔤켺䧄\uf386籅\ue6f6悋\ue910鍃ᷱ", 1340244188, -820320196),
      a.c(2090077296, "జ疢ｽ愅\ueada汐홭徚쇃䭺"),
      a.d("ǳ硠\uf2b8泘\ue754憧\udbf0分챒䛥섧㭅떕ⰶ\ua63e₃髃ᔟ达৯耴廓璻\uef61椐\ue3cd", 494456179, 1285475542)
   );
   private static final Field edq = vxr.find(
      MinecraftClient.class,
      a.c(-439245696, "ꓹ\udd43垁즪䈾쒋统\uf725楼\ue3dc搜鹪Ⴏ襄͚薤㿦뀥⪖곫╰弣톑"),
      a.d("ꛜ\udf62喽쯅䀚욐粭\uf55a欇\ue1b1", 1933986926, 1530850014),
      a.d("氟", 1206452448, 1835822263)
   );
   private static final long edr = edp == null ? -1L : ejl.U.objectFieldOffset(edp);
   private static final long eds = edq == null ? -1L : ejl.U.objectFieldOffset(edq);
   private static final long edt;
   private static final long edu;
   private static ClientPlayerEntity edv;
   private static ClientWorld edw;
   private static ClientPlayerInteractionManager edx;
   private static Screen edy;
   private static HitResult edz;
   private static Entity eea;
   private static Entity eeb;
   private static Object eec;
   private static Object eed;
   private static Object eee;
   private static Object eef;
   private static Object eeg;
   private static int eeh;
   private static boolean eei;
   private static BossBarHud eej;
   private static pth eek;
   private static boolean eel;
   private static boolean[] eem = new boolean[0];
   private static int[] een = new int[0];
   private static boolean eeo;
   private static boolean eep;
   private static boolean eeq;
   private static boolean eer;
   private static double ees;
   private static boolean eet;
   private static Object[] eeu;
   private static boolean eev;

   private edj() {
   }

   private static long[] eey() {
      long var0 = -1L;
      long var2 = -1L;

      try {
         KeyBinding var4 = ejl.allocate(KeyBinding.class);

         for (Field var8 : KeyBinding.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var8.getModifiers())) {
               long var9 = ejl.U.objectFieldOffset(var8);
               if (var8.getType() == boolean.class && var0 < 0L) {
                  var4.method_23481(true);
                  boolean var11 = ejl.U.getBoolean(var4, var9);
                  var4.method_23481(false);
                  if (var11 && !ejl.U.getBoolean(var4, var9)) {
                     var0 = var9;
                  }
               } else if (var8.getType() == int.class && var2 < 0L) {
                  ejl.U.putInt(var4, var9, 1);
                  if (var4.method_1436() && ejl.U.getInt(var4, var9) == 0) {
                     var2 = var9;
                  } else {
                     ejl.U.putInt(var4, var9, 0);
                  }
               }
            }
         }
      } catch (Throwable var12) {
      }

      return new long[]{var0 >= 0L ? var0 : ejl.offset(KeyBinding.class, boolean.class), var2 >= 0L ? var2 : ejl.offset(KeyBinding.class, int.class)};
   }

   static boolean isActive() {
      return ejp.active != null;
   }

   static dtv current() {
      return ejp.active;
   }

   static boolean holdsUseCooldown(dtv var0) {
      return eei && ejp.active == var0;
   }

   static int useCooldown() {
      return eds < 0L ? 0 : ejl.U.getInt(edk, eds);
   }

   static void useCooldown(int var0) {
      if (eds >= 0L) {
         ejl.U.putInt(edk, eds, var0);
      }
   }

   static void click(KeyBinding var0) {
      if (ejp.active != null) {
         ejl.U.putInt(var0, edu, ejl.U.getInt(var0, edu) + 1);
      }
   }

   private static Entity eez() {
      return edr < 0L ? edk.method_1560() : (Entity)ejl.U.getObject(edk, edr);
   }

   static void camera(Entity var0) {
      if (edr >= 0L) {
         ejl.U.putObject(edk, edr, var0);
      }
   }

   static boolean enter(dtv var0) {
      if (ejp.active == null && edk.method_18854()) {
         try {
            if (!ejp.LOCK.tryLock() && !ejp.LOCK.tryLock(60L, TimeUnit.MILLISECONDS)) {
               return false;
            }
         } catch (InterruptedException var5) {
            Thread.currentThread().interrupt();
            return false;
         }

         edv = edk.field_1724;
         edw = edk.field_1687;
         edx = edk.field_1761;
         edy = edk.field_1755;
         edz = edk.field_1765;
         eea = edk.field_1692;
         eeb = eez();
         eec = ejl.get(edk, edl);
         eed = ejl.get(edk, edm);
         eee = ejl.get(edk, edn);
         eef = ejl.get(edk, edo);
         eej = edk.field_1705 == null ? null : edk.field_1705.method_1740();
         Field var1 = pjn.field();

         try {
            eeg = eej != null && var1 != null ? var1.get(eej) : null;
         } catch (ReflectiveOperationException var4) {
            eeg = null;
         }

         try {
            ejp.active = var0;
            edk.field_1724 = var0.player;
            edk.field_1687 = var0.world;
            edk.field_1761 = var0.interaction;
            edk.field_1755 = var0.screen;
            edk.field_1765 = var0.crosshair;
            edk.field_1692 = var0.targeted;
            camera(var0.camera);
            ejl.put(edk, edl, eky.SOUND);
            ejl.put(edk, edm, eky.PARTICLES);
            ejl.put(edk, edn, eky.MOUSE);
            ejl.put(edk, edo, eky.WORLD_RENDERER);
            if (eej != null && var1 != null && eeg != null) {
               var1.set(eej, var0.bossBars);
            }

            eek = ptr.swap(var0.silent);
            eel = true;
            eeh = useCooldown();
            eei = eds >= 0L;
            useCooldown(var0.itemUseCooldown);
            efb(var0);
            efd();
            Object[] var2 = var0.fabricAddons;
            if (var2 != null) {
               eeu = ega.saveAddons();
               eev = true;
               ega.restoreAddons(var2);
            }

            return true;
         } catch (Throwable var3) {
            efa(null);
            return false;
         }
      } else {
         return false;
      }
   }

   static void exit() {
      dtv var0 = ejp.active;
      if (var0 != null) {
         var0.player = edk.field_1724;
         var0.world = edk.field_1687;
         var0.interaction = edk.field_1761;
         var0.screen = edk.field_1755;
         var0.crosshair = edk.field_1765;
         var0.targeted = edk.field_1692;
         var0.camera = eez();
         efa(var0);
      }
   }

   private static void efa(dtv var0) {
      try {
         edk.field_1724 = edv;
         edk.field_1687 = edw;
         edk.field_1761 = edx;
         edk.field_1755 = edy;
         edk.field_1765 = edz;
         edk.field_1692 = eea;
         camera(eeb);
         if (eec != null) {
            ejl.put(edk, edl, eec);
         }

         if (eed != null) {
            ejl.put(edk, edm, eed);
         }

         if (eee != null) {
            ejl.put(edk, edn, eee);
         }

         if (eef != null) {
            ejl.put(edk, edo, eef);
         }

         Field var1 = pjn.field();
         if (eej != null && var1 != null && eeg != null) {
            try {
               var1.set(eej, eeg);
            } catch (ReflectiveOperationException var6) {
            }
         }

         if (eel) {
            ptr.swap(eek);
         }

         if (eei) {
            if (var0 != null) {
               var0.itemUseCooldown = useCooldown();
            }

            useCooldown(eeh);
         }

         if (eeo) {
            efc(var0);
         }

         if (eet) {
            efe();
         }

         if (eev) {
            if (var0 != null) {
               Object[] var2 = ega.saveAddons();
               if (var2 != null) {
                  var0.fabricAddons = var2;
               }
            }

            ega.restoreAddons(eeu);
         }
      } finally {
         edv = null;
         edw = null;
         edx = null;
         edy = null;
         edz = null;
         eea = null;
         eeb = null;
         eec = null;
         eed = null;
         eee = null;
         eef = null;
         eeg = null;
         eej = null;
         eek = null;
         eel = false;
         eei = false;
         eeo = false;
         eet = false;
         eeu = null;
         eev = false;
         ejp.active = null;
         ejp.LOCK.unlock();
      }
   }

   private static void efb(dtv var0) {
      KeyBinding[] var1 = edk.field_1690.field_1839;
      if (eem.length != var1.length) {
         eem = new boolean[var1.length];
         een = new int[var1.length];
      }

      var0.ensureKeys(var1.length);

      for (int var2 = 0; var2 < var1.length; var2++) {
         eem[var2] = ejl.U.getBoolean(var1[var2], edt);
         een[var2] = ejl.U.getInt(var1[var2], edu);
      }

      eeo = true;

      for (int var3 = 0; var3 < var1.length; var3++) {
         ejl.U.putBoolean(var1[var3], edt, var0.keyPressed[var3]);
         ejl.U.putInt(var1[var3], edu, var0.keyTimes[var3]);
      }
   }

   private static void efc(dtv var0) {
      KeyBinding[] var1 = edk.field_1690.field_1839;
      int var2 = Math.min(var1.length, eem.length);

      for (int var3 = 0; var3 < var2; var3++) {
         KeyBinding var4 = var1[var3];
         if (var0 != null && var3 < var0.keyPressed.length) {
            var0.keyPressed[var3] = ejl.U.getBoolean(var4, edt);
            var0.keyTimes[var3] = ejl.U.getInt(var4, edu);
         }

         ejl.U.putBoolean(var4, edt, eem[var3]);
         ejl.U.putInt(var4, edu, een[var3]);
      }
   }

   private static void efd() {
      GameOptions var0 = edk.field_1690;
      eep = (Boolean)var0.method_42449().method_41753();
      eeq = (Boolean)var0.method_42450().method_41753();
      eer = (Boolean)var0.method_42423().method_41753();
      ees = (Double)var0.method_42495().method_41753();
      eet = true;
      dtv var1 = ejp.active;
      if (var1 != null) {
         var0.method_42495().method_41748(var1.sensitivity());
      }

      if (eep) {
         var0.method_42449().method_41748(false);
      }

      if (eeq) {
         var0.method_42450().method_41748(false);
      }

      if (eer) {
         var0.method_42423().method_41748(false);
      }
   }

   private static void efe() {
      GameOptions var0 = edk.field_1690;
      if (eep) {
         var0.method_42449().method_41748(true);
      }

      if (eeq) {
         var0.method_42450().method_41748(true);
      }

      if (eer) {
         var0.method_42423().method_41748(true);
      }

      var0.method_42495().method_41748(ees);
   }

   static {
      long[] var0 = eey();
      edt = var0[0];
      edu = var0[1];
   }
}
