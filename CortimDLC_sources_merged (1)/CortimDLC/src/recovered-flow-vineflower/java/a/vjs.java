package a;

import flow.dev.a;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public final class vjs {
   static final AtomicBoolean vjt = new AtomicBoolean(false);
   static final long vju = 2000000000L;
   static final long vjv = 100000000L;
   static final long vjw = 60000000000L;
   static volatile long vjx;
   static volatile Map<Class<?>, byte[]> vjy;
   static volatile ClassLoader vjz;
   static volatile Set<String> vka;
   static volatile Set<String> vkb;
   static volatile long vkc;
   static volatile String vkd;

   vjs() {
   }

   public static void boot() {
      Thread var0 = new Thread(vjs::vkg, a.b("ώ曆\uec16牿鱗缝았䲯튾塀\udf9e◯ꬣ", 859250454));
      var0.setDaemon(true);
      var0.start();
   }

   static void vkg() {
      try {
         Thread.sleep(3000L);
      } catch (InterruptedException var11) {
      }

      try {
         String[] var0 = new String[]{
            a.d("짡끚㪊ꓣ⽭ꦇᏕ騹ѣ躐ड\uf373綪\ue41e湌\ue8aa勞\udd28䞓쇋", -10863791, 241758914),
            a.d("\uf3dc詧·點ᕐ鎉⧰ꀂ㹅", -124783787, -1098252058),
            a.c(1801729254, "㒊䴱쟡妈툆哉\ueeab杕懶玶")
         };
         ArrayList var1 = new ArrayList();

         for (String var5 : var0) {
            try {
               var1.add(Class.forName(var5));
            } catch (Throwable var10) {
            }
         }

         LinkedHashMap var14 = new LinkedHashMap();

         for (Class var17 : var1) {
            try {
               var14.put(var17, vki(var17));
            } catch (Throwable var9) {
            }
         }

         vjy = var14;

         try {
            vjz = Class.forName(a.b("ﴂ蒹\u0e69退ᮎ鵗✮껜゛", 1815281005)).getClassLoader();
         } catch (Throwable var8) {
         }

         HashSet var16 = new HashSet();

         try {
            for (Thread var20 : Thread.getAllStackTraces().keySet()) {
               if (var20 != null && var20.getName() != null) {
                  var16.add(var20.getName());
               }
            }
         } catch (Throwable var12) {
         }

         vka = var16;

         try {
            List var19 = ManagementFactory.getRuntimeMXBean().getInputArguments();
            vkb = new HashSet<>(var19);
         } catch (Throwable var7) {
         }

         vjx = System.nanoTime();
      } catch (Throwable var13) {
      }
   }

   public static void tick() {
      if (!vjt.get()) {
         long var0 = System.nanoTime();
         if (var0 >= vkc) {
            long var2 = vjx == 0L ? 0L : var0 - vjx;
            vkc = var0 + (var2 < 60000000000L ? 100000000L : 2000000000L);

            try {
               Map var4 = vjy;
               if (var4 != null) {
                  for (Entry var6 : var4.entrySet()) {
                     byte[] var7 = vki((Class<?>)var6.getKey());
                     if (!vkj(var7, (byte[])var6.getValue())) {
                        vkk(a.b("婘⏡ꤣ㝎벞㨤耳\u0991韔ᵫ髿惍\uee11瞩ﷵ笍셀从푧", 1607096870) + ((Class)var6.getKey()).getName());
                        return;
                     }
                  }
               }

               try {
                  ClassLoader var23 = vjz;
                  if (var23 != null) {
                     Class var25 = Class.forName(a.b("闂\uec79暩\uf8c0獎\uf597修옜塛", -1977772627));
                     if (var25.getClassLoader() != var23) {
                        vkk(a.d("\ue3cb驐ႀ軩թ莻㧧끺\u2e76꓃⌆\ud966垱츕䑇", 974993886, 1320082012));
                        return;
                     }
                  }
               } catch (Throwable var21) {
               }

               String[] var24 = new String[]{
                  a.c(1608487794, "錜\ueab8恫️痚\uf360䥻샆府퐷口ꦃ❟뻥㒡"),
                  a.b("庹✔규㎴롾", -510042410),
                  a.d("힏기⓰몆", -1810061853, 1307996674),
                  a.b("α稆\uf0d7溭\ue560掅\ud99b偦츱䒇", -965606438),
                  a.c(1617565240, "ᙎ濠\ue537笏"),
                  a.b("㝀任쐵婇톙", -1338296543),
                  a.d("훳꽉▟믲", -145154152, 1462749445),
                  a.b("熒࠭芷\u1c8c靉ᇤ", 1936486910)
               };
               Map var26 = Thread.getAllStackTraces();

               for (Thread var8 : var26.keySet()) {
                  String var9 = var8 == null ? null : var8.getName();
                  if (var9 != null) {
                     String var10 = var9.toLowerCase(Locale.ROOT);

                     for (String var14 : var24) {
                        if (var10.contains(var14)) {
                           vkk(a.d("\uf8f6腁ஔ闦ṡ预⋋ꬠ㕨뿝㠋숤䳩", 195878624, 257631848) + var9);
                           return;
                        }
                     }
                  }
               }

               if (a.b("ᓃ", -1474292493).equals(System.getProperty(a.b("땋쳈䘅\ud829厣프潑", -1012353773)))) {
                  vkk(a.c(-1972612373, "劗⬩ꇯ㾃둋㋩裿Ś鼐ᖭ鉣标\ue6c7缤\uf531珊즈䙟"));
                  return;
               }

               Set var28 = vkb;
               if (var28 != null) {
                  for (String var33 : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
                     if (vkh(var33) && !var28.contains(var33)) {
                        vkk(a.b("晫\u1fdc镛ୠ肫\u0601밟㖯ꯣⅇꛉ岢", -1300011499) + var33);
                        return;
                     }
                  }
               }

               String[] var30 = new String[]{
                  a.c(686706887, "傰⤍ꏜ㷮뙤ビ誛̪鴯ច遖樤\ue4ec紀\uf71c燸쮷䑳\udec2墘"),
                  a.b("蓩ﵞ瞖\ue9a7截\ue480廓휡䥡쎍䐑빵ア꤆⍗ꖭ", -1073970038),
                  a.b("䬠㊟롃♷귯⭋鄘\u18fc蚡ఛ", -532329664),
                  a.c(-802634239, "왢뿎㔈ꬰ₫ꘝ᱅閼\u0bab腗ځﳤ"),
                  a.d("픲겈♞렳㎲", -825283840, 1147666013),
                  a.c(-532209265, "⇬塕틍䳱윪䆘﯂爯\uec27曊\ue10e᭹閬చ")
               };

               for (Entry var34 : var26.entrySet()) {
                  StackTraceElement[] var35 = (StackTraceElement[])var34.getValue();
                  if (var35 != null) {
                     for (StackTraceElement var15 : var35) {
                        String var16 = var15.getClassName();
                        if (var16 != null) {
                           for (String var20 : var30) {
                              if (var16.startsWith(var20)) {
                                 vkk(a.d("ｬ蛛ఎ鉼᧻鼌╋격㋺롃㿏얤", 811934306, -1002316431) + var16);
                                 return;
                              }
                           }
                        }
                     }
                  }
               }
            } catch (Throwable var22) {
            }
         }
      }
   }

   static boolean vkh(String var0) {
      return var0 == null
         ? false
         : var0.startsWith(a.b("蒂ﵿ瞪\ue9d9戅\ue4ae廥휑䥅쎬䐯빐ゔꤢ", 1690535073))
            || var0.startsWith(a.c(-339249476, "皚ཬ薴ᯒ递ᚣ곶┅뭑ㇺ뙧"))
            || var0.startsWith(a.c(-265931766, "㐬䷑위奷튫吀\uee57枷什獐\uf4d1"))
            || var0.startsWith(a.d("ꆁ\ud845努쳚䜊솬篭", 1194690464, 70985227));
   }

   static byte[] vki(Class<?> var0) {
      try {
         Method[] var1 = var0.getDeclaredMethods();
         Arrays.sort(var1, (var0x, var1x) -> {
            int var2x = var0x.getName().compareTo(var1x.getName());
            return var2x != 0 ? var2x : Integer.compare(var0x.getParameterCount(), var1x.getParameterCount());
         });
         StringBuilder var2 = new StringBuilder();

         for (Method var6 : var1) {
            var2.append(var6.getName()).append('(');
            Class[] var7 = var6.getParameterTypes();

            for (int var8 = 0; var8 < var7.length; var8++) {
               if (var8 > 0) {
                  var2.append(',');
               }

               var2.append(var7[var8].getName());
            }

            var2.append(')').append(var6.getModifiers()).append('/').append(var6.getReturnType().getName()).append(';');
         }

         MessageDigest var10 = MessageDigest.getInstance(a.b("탂ꥨ⎲붯㙧냑ઁ", 516214934));
         return var10.digest(var2.toString().getBytes(StandardCharsets.UTF_8));
      } catch (Throwable var9) {
         return new byte[0];
      }
   }

   static boolean vkj(byte[] var0, byte[] var1) {
      if (var0 != null && var1 != null && var0.length == var1.length) {
         int var2 = 0;

         for (int var3 = 0; var3 < var0.length; var3++) {
            var2 |= var0[var3] ^ var1[var3];
         }

         return var2 == 0;
      } else {
         return false;
      }
   }

   public static void tripFromCallerGate(String var0) {
      vkk(a.c(2061013130, "郤\ue957掉ﷸ瘦\uf080䪁쌷嵮\ud7ca倈ꨦ⓫") + var0);
   }

   static void vkk(String var0) {
      if (vjt.compareAndSet(false, true)) {
         vkd = var0;

         try {
            Class var1 = Class.forName(a.d("\uf28e謵ǥ龌ᐂ鋍⢯ꅑ㼉떲", 2022442473, -179833077));
            var1.getMethod(a.b("轾\uf6c9簁\ue27e榩\uef1a啞", -129659123)).invoke(null);
         } catch (Throwable var2) {
         }

         Thread var3 = new Thread(() -> {
            try {
               int var0x = ThreadLocalRandom.current().nextInt(15000, 60000);
               Thread.sleep(var0x);
            } catch (InterruptedException var9) {
            } finally {
               try {
                  System.exit(0);
               } catch (Throwable var8) {
               }
            }
         });
         var3.setDaemon(true);
         var3.start();
      }
   }
}
