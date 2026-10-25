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
   static final MinecraftClient edk = MinecraftClient.getInstance();
   static final long edl = ejl.offsetOf(edk, edk.getSoundManager());
   static final long edm = ejl.offsetOf(edk, edk.particleManager);
   static final long edn = ejl.offsetOf(edk, edk.mouse);
   static final long edo = ejl.offsetOf(edk, edk.worldRenderer);
   static final Field edp = vxr.find(
      MinecraftClient.class,
      a.d("梙ᄣ鯡\u05ca蹞࣫늿㭅ꔜ⾼\ua87c刊\udccf䔤켺䧄\uf386籅\ue6f6悋\ue910鍃ᷱ", 1340244188, -820320196),
      a.c(2090077296, "జ疢ｽ愅\ueada汐홭徚쇃䭺"),
      a.d("ǳ硠\uf2b8泘\ue754憧\udbf0分챒䛥섧㭅떕ⰶ\ua63e₃髃ᔟ达৯耴廓璻\uef61椐\ue3cd", 494456179, 1285475542)
   );
   static final Field edq = vxr.find(
      MinecraftClient.class,
      a.c(-439245696, "ꓹ\udd43垁즪䈾쒋统\uf725楼\ue3dc搜鹪Ⴏ襄͚薤㿦뀥⪖곫╰弣톑"),
      a.d("ꛜ\udf62喽쯅䀚욐粭\uf55a欇\ue1b1", 1933986926, 1530850014),
      a.d("氟", 1206452448, 1835822263)
   );
   static final long edr = edp == null ? -1L : ejl.U.objectFieldOffset(edp);
   static final long eds = edq == null ? -1L : ejl.U.objectFieldOffset(edq);
   static final long edt;
   static final long edu;
   static ClientPlayerEntity edv;
   static ClientWorld edw;
   static ClientPlayerInteractionManager edx;
   static Screen edy;
   static HitResult edz;
   static Entity eea;
   static Entity eeb;
   static Object eec;
   static Object eed;
   static Object eee;
   static Object eef;
   static Object eeg;
   static int eeh;
   static boolean eei;
   static BossBarHud eej;
   static pth eek;
   static boolean eel;
   static boolean[] eem = new boolean[0];
   static int[] een = new int[0];
   static boolean eeo;
   static boolean eep;
   static boolean eeq;
   static boolean eer;
   static double ees;
   static boolean eet;
   static Object[] eeu;
   static boolean eev;

   edj() {
   }

   static long[] eey() {
      long var0 = -1L;
      long var2 = -1L;

      try {
         KeyBinding var4 = ejl.allocate(KeyBinding.class);

         for (Field var8 : KeyBinding.class.getDeclaredFields()) {
            if (!Modifier.isStatic(var8.getModifiers())) {
               long var9 = ejl.U.objectFieldOffset(var8);
               if (var8.getType() == boolean.class && var0 < 0L) {
                  var4.setPressed(true);
                  boolean var11 = ejl.U.getBoolean(var4, var9);
                  var4.setPressed(false);
                  if (var11 && !ejl.U.getBoolean(var4, var9)) {
                     var0 = var9;
                  }
               } else if (var8.getType() == int.class && var2 < 0L) {
                  ejl.U.putInt(var4, var9, 1);
                  if (var4.wasPressed() && ejl.U.getInt(var4, var9) == 0) {
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

   static Entity eez() {
      return edr < 0L ? edk.getCameraEntity() : (Entity)ejl.U.getObject(edk, edr);
   }

   static void camera(Entity var0) {
      if (edr >= 0L) {
         ejl.U.putObject(edk, edr, var0);
      }
   }

   static boolean enter(dtv var0) {
      if (ejp.active == null && edk.isOnThread()) {
         try {
            if (!ejp.LOCK.tryLock() && !ejp.LOCK.tryLock(60L, TimeUnit.MILLISECONDS)) {
               return false;
            }
         } catch (InterruptedException var5) {
            Thread.currentThread().interrupt();
            return false;
         }

         edv = edk.player;
         edw = edk.world;
         edx = edk.interactionManager;
         edy = edk.currentScreen;
         edz = edk.crosshairTarget;
         eea = edk.targetedEntity;
         eeb = eez();
         eec = ejl.get(edk, edl);
         eed = ejl.get(edk, edm);
         eee = ejl.get(edk, edn);
         eef = ejl.get(edk, edo);
         eej = edk.inGameHud == null ? null : edk.inGameHud.getBossBarHud();
         Field var1 = pjn.field();

         try {
            eeg = eej != null && var1 != null ? var1.get(eej) : null;
         } catch (ReflectiveOperationException var4) {
            eeg = null;
         }

         try {
            ejp.active = var0;
            edk.player = var0.player;
            edk.world = var0.world;
            edk.interactionManager = var0.interaction;
            edk.currentScreen = var0.screen;
            edk.crosshairTarget = var0.crosshair;
            edk.targetedEntity = var0.targeted;
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
         var0.player = edk.player;
         var0.world = edk.world;
         var0.interaction = edk.interactionManager;
         var0.screen = edk.currentScreen;
         var0.crosshair = edk.crosshairTarget;
         var0.targeted = edk.targetedEntity;
         var0.camera = eez();
         efa(var0);
      }
   }

   static void efa(dtv var0) {
      try {
         edk.player = edv;
         edk.world = edw;
         edk.interactionManager = edx;
         edk.currentScreen = edy;
         edk.crosshairTarget = edz;
         edk.targetedEntity = eea;
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

   static void efb(dtv var0) {
      KeyBinding[] var1 = edk.options.allKeys;
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

   static void efc(dtv var0) {
      KeyBinding[] var1 = edk.options.allKeys;
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

   static void efd() {
      GameOptions var0 = edk.options;
      eep = var0.getSneakToggled().getValue();
      eeq = var0.getSprintToggled().getValue();
      eer = var0.getAutoJump().getValue();
      ees = var0.getMouseSensitivity().getValue();
      eet = true;
      dtv var1 = ejp.active;
      if (var1 != null) {
         var0.getMouseSensitivity().setValue(var1.sensitivity());
      }

      if (eep) {
         var0.getSneakToggled().setValue(false);
      }

      if (eeq) {
         var0.getSprintToggled().setValue(false);
      }

      if (eer) {
         var0.getAutoJump().setValue(false);
      }
   }

   static void efe() {
      GameOptions var0 = edk.options;
      if (eep) {
         var0.getSneakToggled().setValue(true);
      }

      if (eeq) {
         var0.getSprintToggled().setValue(true);
      }

      if (eer) {
         var0.getAutoJump().setValue(true);
      }

      var0.getMouseSensitivity().setValue(ees);
   }

   static {
      long[] var0 = eey();
      edt = var0[0];
      edu = var0[1];
   }
}
