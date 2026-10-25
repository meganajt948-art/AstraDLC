package a;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import flow.dev.a;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public final class wlk {
   public static final vkl ENABLED = new vkl(a.d("ព渜\ue4c8窡\uf121矇춂䑫\uda3d傓흆ⴰꏽ㩋", -1273135039, -1057646710), true);
   public static final vlv COLOR = new vlv(
      a.d("\udee4Ꝺⶩ돛㠖뺠", -1944053484, 1848690613), a.b("ѯ緢\uf73c楅\ue29a", 782828606), a.d("敤ᳩ阷ࡎ莑", -1414680626, -1757099269), a.b("綎Ї軍", 1115061698)
   );
   public static final vlv COORDS = new vlv(
      a.d("\ua87c퇡嬲앞亟젣牷ﮉ旃\uef63梦", 479382896, -657889980),
      a.d("낥줹䏱\udd96噙탢", 246819694, -849306740),
      a.d("\uef52雎ᰆ艡ম輕", 744114982, 858498099),
      a.c(21325353, "晠\u1ff0镭ଢ଼肂ط"),
      a.d("לּ芤ࡷ", 244537043, -342184541)
   );
   public static final vkl DISTANCE = new vkl(a.d("\u2e7f埣\udd2a䍜좞丠\uf47e綉", -849862821, -1279708824), true);
   public static final vmc SCALE = new vmc(a.d("骝\ue316槖\uf7b8", 2064945152, -419034422), 1.0, 0.6, 1.6, 0.05).percent();
   public static final vkl CHAT = new vkl(a.d("핉곓☉롭㏮딜གྷ蚲ᣰ鉗ᖉ\uefff愧\uf883狁\uf426", -1964050937, 595469085), true);
   public static final List<vmo> DISPLAY = List.of(COLOR, COORDS, DISTANCE, SCALE, CHAT);
   public static final List<vmo> ALL = List.of(ENABLED, COLOR, COORDS, DISTANCE, SCALE, CHAT);
   static final String wll = a.d("슝묨ㇼ꾆\u2457ꋷᢷ酁༌藳ɵ\uf81d盙\uef7f攩\ue3c0妒홝䳦", 1813012103, 533175396);
   public static final int[] COLORS = new int[]{-7643914, -12877066, -14494738, -14498466, -340971, -429290, -1096636, -1292135};
   static final Gson wlm = new GsonBuilder().setPrettyPrinting().create();
   static final List<wkq> wln = new ArrayList<>();
   static boolean wlo;
   static int wlp;
   static final Map<wkq, wkq> wlq = new IdentityHashMap<>();

   wlk() {
   }

   public static int version() {
      return wlp;
   }

   public static List<wkq> inWorld() {
      wlu();
      String var0 = worldId();
      ArrayList var1 = new ArrayList();

      for (wkq var3 : wln) {
         if (var0 == null || var0.equals(var3.world)) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public static List<wkq> drawable() {
      wlu();
      String var0 = worldId();
      String var1 = dimensionId();
      ArrayList var2 = new ArrayList();
      if (var0 != null && var1 != null) {
         for (wkq var4 : wln) {
            if (var4.visible && var0.equals(var4.world)) {
               if (var1.equals(var4.dimension)) {
                  var2.add(var4);
               } else {
                  wkq var5 = wlt(var4);
                  if (var5 != null) {
                     var2.add(var5);
                  }
               }
            }
         }

         wlq.keySet().removeIf(var0x -> !wln.contains(var0x));
         return var2;
      } else {
         return var2;
      }
   }

   static wkq wlt(wkq var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world != null
         && a.d("\uee80霵ᷡ莛ࡊ軪㒪뵜⌑ꧮ\u2e68퐀嫄썢䤴쿝疏懲惻", 742262319, -1756239663).equals(var0.dimension)
         && !(var1.world.getDimension().coordinateScale() <= 1.0)) {
         double var2 = var1.world.getDimension().coordinateScale();
         int var4 = var1.world.getBottomY();
         int var5 = var4 + var1.world.getDimension().logicalHeight() - 2;
         wkq var6 = wlq.computeIfAbsent(var0, var0x -> new wkq());
         var6.name = var0.name + a.c(-672317879, "㹬䟝춙卿\ud8a8") + dimensionName(var0.dimension);
         var6.x = Math.floor(var0.x / var2);
         var6.y = Math.max(var4 + 1, Math.min(var5, var0.y));
         var6.z = Math.floor(var0.z / var2);
         var6.color = var0.color;
         var6.ownColor = var0.ownColor;
         var6.world = var0.world;
         var6.dimension = dimensionId();
         var6.visible = true;
         var6.created = var0.created;
         return var6;
      } else {
         return null;
      }
   }

   public static wkq here(wkq var0) {
      String var1 = dimensionId();
      if (var1 == null) {
         return null;
      } else {
         return var1.equals(var0.dimension) ? var0 : wlt(var0);
      }
   }

   public static boolean exists(double var0, double var2, double var4) {
      wlu();
      String var6 = worldId();
      String var7 = dimensionId();

      for (wkq var9 : wln) {
         if (Objects.equals(var6, var9.world)
            && Objects.equals(var7, var9.dimension)
            && Math.floor(var9.x) == Math.floor(var0)
            && Math.floor(var9.y) == Math.floor(var2)
            && Math.floor(var9.z) == Math.floor(var4)) {
            return true;
         }
      }

      return false;
   }

   public static int colorOf(wkq var0) {
      return COLOR.is(a.b("慳\u18fe鈠ౙ螆", -48733918)) && !var0.ownColor ? iov.accent() | 0xFF000000 : var0.color | 0xFF000000;
   }

   public static wkq add(String var0, double var1, double var3, double var5, int var7) {
      wlu();
      wkq var8 = new wkq(var0, var1, var3, var5, var7, worldId(), dimensionId());
      wln.add(var8);
      changed();
      return var8;
   }

   public static void remove(wkq var0) {
      wln.remove(var0);
      changed();
   }

   public static void changed() {
      wlp++;
      wlv();
   }

   public static String worldId() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      if (var0.world == null) {
         return null;
      }

      try {
         if (var0.isInSingleplayer() && var0.getServer() != null) {
            return a.d("䋀㭲뇫", -661889245, 1120214419) + var0.getServer().getSaveProperties().getLevelName();
         }
      } catch (Throwable var2) {
      }

      ServerInfo var1 = var0.getCurrentServerEntry();
      return var1 != null ? a.c(-1514144637, "ﳭ蕁࿘") + var1.address : a.d("萆ﶬ睺\ue90e拘\ue471帻", 773352640, 315484340);
   }

   public static String dimensionId() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      return var0.world == null ? null : var0.world.getRegistryKey().getValue().toString();
   }

   public static String dimensionName(String var0) {
      if (var0 == null) {
         return a.b("⪵", 26421899);
      }

      int var1 = var0.indexOf(58);
      String var2 = (var1 >= 0 ? var0.substring(var1 + 1) : var0).replace(a.c(-1869341246, "ᶲ搟\ueec1炊"), "").replace('_', ' ');

      if (var2.equals(a.b("\uf65c迴Դ魒ႀ阩Ⱨꖈ㯟", -300157382))) {
         return wap.s(var2, a.d("\uf711躧Ё驵ᇚ靮ⴼꃔ㪗뀢㞉", -226611629, 1407966587));
      }
      else if (var2.equals(a.d("瓟\u0d65螧\u19ca鈐ᒶ", 1410480448, -1545843209))) {
         return wap.s(var2, a.d("롶쇏䬞항廏", 868819401, 1687657863));
      }
      else if (var2.equals(a.c(-2117466748, "ע籘\uf681"))) {
         return wap.s(var2, a.d("\udc84ꕅ⾟", -1848796671, 893862603));
      }
      else {
         return var2;
      }
   }

   static void wlu() {
      if (!wlo) {
         wlo = true;
         String var0 = ewk.get(a.c(1204147723, "홵꿒┙뭡ォ똞ొ薡\u1bf9"));
         if (var0 != null && !var0.isBlank()) {
            try {
               List var1 = (List)wlm.fromJson(var0, (new TypeToken<List<wkq>>() {}).getType());
               if (var1 != null) {
                  for (wkq var3 : var1) {
                     if (var3 != null && var3.name != null) {
                        wln.add(var3);
                     }
                  }
               }
            } catch (Exception var4) {
               System.out.println(a.d("\u20cf奼펠䶘옜䃹\ufaf8猞\ued45柱\ue066ᩀ钁ന蝲Ɯ믕㐃꺪⣼ꅂ\udb09", 124161895, 1043771357) + var4);
            }
         }
      }
   }

   static void wlv() {
      ewk.put(a.d("휶꺑\u245a먢\u31ea띝ഉ蓢᪺", 420154200, -1658463216), wlm.toJson(wln));
   }
}
