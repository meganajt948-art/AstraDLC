package a;

import flow.dev.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class vza {
   static final ExecutorService vzb = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, a.c(-1306862787, "\udb6aꋱ⠡뙈㷚뭹Ŭ袒ᛈ鱰᯦\ue1c0漒\uf6b8糶猪䁎"));
      var1.setDaemon(true);
      var1.setPriority(1);
      return var1;
   });

   vza() {
   }

   public static void later(String var0, vyz var1) {
      vzb.execute(() -> {
         try {
            var1.run();
         } catch (Exception var3) {
            System.out.println(a.b("\ud8dcꅯ⮳떋㸏룪˪謉ᕁ鿣ᡵ", 1174460596) + var0 + a.b("᳚敱", 547232994) + var3);
         }
      });
   }

   public static void flush() {
      try {
         vzb.submit(() -> {}).get(2L, TimeUnit.SECONDS);
      } catch (Exception var1) {
      }
   }
}
