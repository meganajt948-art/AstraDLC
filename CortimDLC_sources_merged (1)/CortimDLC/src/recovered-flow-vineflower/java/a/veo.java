package a;

import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class veo {
   static final Map<vek, Font> vep = new EnumMap<>(vek.class);
   static final Map<vek, Boolean> veq = new EnumMap<>(vek.class);
   static final Map<Long, vdn> ver = new HashMap<>();

   veo() {
   }

   public static vdn get(vek var0, float var1) {
      long var2 = (long)var0.ordinal() << 32 | Float.floatToIntBits(var1) & 4294967295L;
      return ver.computeIfAbsent(var2, var2x -> new vdn(var0.name().toLowerCase() + " " + var1, () -> veu(var0), var1, vfk.TEXT_CHARSET, false));
   }

   public static List<vdn> all() {
      return new ArrayList<>(ver.values());
   }

   public static vdn regular(float var0) {
      return get(vek.REGULAR, var0);
   }

   public static vdn medium(float var0) {
      return get(vek.MEDIUM, var0);
   }

   public static vdn semibold(float var0) {
      return get(vek.SEMIBOLD, var0);
   }

   public static vdn bold(float var0) {
      return get(vek.BOLD, var0);
   }

   static synchronized Font veu(vek var0) {
      Font var1 = vep.get(var0);
      if (var1 == null && !veq.containsKey(var0)) {
         try (InputStream var2 = veo.class.getResourceAsStream(var0.vel)) {
            if (var2 == null) {
               throw new IllegalStateException("missing " + var0.vel);
            }

            var1 = Font.createFont(0, var2);
         } catch (Throwable var7) {
            System.out.println("can't load font " + var0 + ": " + var7);
            var1 = null;
         }

         if (var1 == null) {
            veq.put(var0, Boolean.TRUE);
         } else {
            vep.put(var0, var1);
         }

         return var1;
      } else {
         return var1;
      }
   }
}
