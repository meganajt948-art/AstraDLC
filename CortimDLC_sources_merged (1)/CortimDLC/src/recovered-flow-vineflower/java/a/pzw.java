package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public final class pzw {
   static final Pattern pzx = Pattern.compile(a.b("䍇㪂끩⸇ꖚ⌶饻Ⴥ軎Ѭ莭禨\uf747滩\ue4f3才\ud856垔촵䬐싟뢑㙫귵⯞", -753384586));
   static final Pattern pzy = Pattern.compile(a.c(539086795, "쿲똷㳜ꊲ⤯꾃ᗏ鱰ɻ裙༘\uf51d篲\ue25c框\ueef8哣"));
   static final Pattern pzz = Pattern.compile(a.b("䌁㫄뀯⸑ꗄ⌀饼ე誝(蟾", 1357595426));
   static final Pattern qaa = Pattern.compile(a.b("\ue0fb餾Ꮥ跫ؾ胺㪆댮⤚ꏟ␃", 1589567704));
   static TrackedData<?> qab;
   static boolean qac;

   pzw() {
   }

   public static pzp read(MinecraftClient var0, double var1) {
      ClientPlayerEntity var3 = var0.player;
      if (var3 != null && var0.world != null) {
         Vec3d var4 = var3.getEntityPos();
         ArrayList<pzk> var5 = new ArrayList<>();
         pzk var6 = null;
         double var7 = Double.MAX_VALUE;

         for (Entity var10 : var0.world.getEntities()) {
            if (var10 != var3) {
               Vec3d var11 = var10.getEntityPos();
               if (!(var11.squaredDistanceTo(var4) > var1 * var1)) {
                  List<String> var12 = lines(var10);
                  if (!var12.isEmpty()) {
                     pzk var13 = new pzk(var11, var12);
                     var5.add(var13);

                     for (String var15 : var12) {
                        if (pfl.title(var15).contains(a.d("ꌗ\udade偸츎", 373595790, -2000078379))) {
                           double var16 = var11.squaredDistanceTo(var4);
                           if (var16 < var7) {
                              var7 = var16;
                              var6 = var13;
                           }
                           break;
                        }
                     }
                  }
               }
            }
         }

         if (var6 == null) {
            return null;
         }

         ArrayList<pzk> var18 = new ArrayList<>();

         for (pzk var21 : var5) {
            double var24 = var21.pzl.x - var6.pzl.x;
            double var31 = var21.pzl.z - var6.pzl.z;
            if (var24 * var24 + var31 * var31 <= 9.0 && Math.abs(var21.pzl.y - var6.pzl.y) <= 5.0) {
               var18.add(var21);
            }
         }

         var18.sort((var0x, var1x) -> Double.compare(var1x.pzl.y, var0x.pzl.y));
         ArrayList<String> var20 = new ArrayList<>();

         for (pzk var25 : var18) {
            for (String var32 : var25.pzm) {
               var20.add(pfl.title(var32));
            }
         }

         qwj var23 = null;
         String var26 = "";

         for (int var28 = 0; var28 < var20.size() && var23 == null; var28++) {
            String var33 = (String)var20.get(var28);
            int var37 = var33.indexOf(a.c(-429870435, "뛛켐䗍\udbbd倝횡泵"));
            if (var37 >= 0) {
               int var40 = var33.indexOf(58, var37);
               String var17 = var40 >= 0 ? var33.substring(var40 + 1) : var33.substring(var37 + 7);
               if (qwj.parse(var17) == null && var17.replaceAll(a.b("夫\u209f\uaa4e㐓뿏㥉茫ૺ", -2017961608), "").length() < 3 && var28 + 1 < var20.size()) {
                  var17 = (String)var20.get(var28 + 1);
               }

               var26 = var17.replaceAll(a.c(-741177950, "藰ﱄ皕\ue8c8挔\ue592忰활䡾"), "").trim();
               var23 = qwj.parse(var17);
            }
         }

         if (var23 == null) {
            for (String var34 : var20) {
               var23 = qwj.parse(var34);
               if (var23 != null) {
                  break;
               }
            }
         }

         int var30 = -1;

         for (int var35 = 0; var35 < var20.size() && var30 < 0; var35++) {
            String var38 = (String)var20.get(var35);
            if (var38.contains(a.b("첳딍㿒ꆠ⩻곃\u169e齧", -222967675)) || var38.contains(a.d("隹\uef7a旜ﯘ瀍", 1740039021, 1272148374))) {
               for (int var41 = var35; var41 < Math.min(var20.size(), var35 + 3) && var30 < 0; var41++) {
                  var30 = seconds((String)var20.get(var41));
               }
            }
         }

         if (var30 < 0) {
            for (String var39 : var20) {
               var30 = clock(var39);
               if (var30 >= 0) {
                  break;
               }
            }
         }

         return var30 < 0 ? null : new pzp(var23, var26, var30, var6.pzl);
      } else {
         return null;
      }
   }

   static int clock(String var0) {
      Matcher var1 = pzx.matcher(var0);
      if (var1.find()) {
         return Integer.parseInt(var1.group(1)) * 3600 + Integer.parseInt(var1.group(2)) * 60 + Integer.parseInt(var1.group(3));
      }

      var1 = pzy.matcher(var0);
      return var1.find() ? Integer.parseInt(var1.group(1)) * 60 + Integer.parseInt(var1.group(2)) : -1;
   }

   static int seconds(String var0) {
      int var1 = clock(var0);
      if (var1 >= 0) {
         return var1;
      }

      int var2 = -1;
      Matcher var3 = pzz.matcher(var0);
      if (var3.find()) {
         var2 = Integer.parseInt(var3.group(1)) * 60;
      }

      var3 = qaa.matcher(var0);
      if (var3.find()) {
         var2 = Math.max(0, var2) + Integer.parseInt(var3.group(1));
      }

      return var2;
   }

   static List<String> lines(Entity var0) {
      ArrayList<String> var1 = new ArrayList<>();
      if (var0 instanceof TextDisplayEntity var2) {
         Text var3 = qaf(var2);
         if (var3 != null) {
            for (String var7 : var3.getString().split(a.b("⼾", -1129304267))) {
               if (!var7.isBlank()) {
                  var1.add(var7);
               }
            }
         }
      }

      if (var0.hasCustomName() && var0.getCustomName() != null) {
         String var8 = var0.getCustomName().getString();
         if (!var8.isBlank()) {
            var1.add(var8);
         }
      }

      return var1;
   }

   static Text qaf(TextDisplayEntity var0) {
      if (!qac) {
         qac = true;

         for (Field var4 : TextDisplayEntity.class.getDeclaredFields()) {
            if (Modifier.isStatic(var4.getModifiers()) && var4.getType() == TrackedData.class) {
               try {
                  var4.setAccessible(true);
                  TrackedData var5 = (TrackedData)var4.get(null);
                  if (var5 != null && var5.dataType() == TrackedDataHandlerRegistry.TEXT_COMPONENT) {
                     qab = var5;
                     break;
                  }
               } catch (ReflectiveOperationException | RuntimeException var7) {
               }
            }
         }
      }

      if (qab == null) {
         return null;
      }

      try {
         return var0.getDataTracker().get(qab) instanceof Text var9 ? var9 : null;
      } catch (RuntimeException var6) {
         return null;
      }
   }
}
