package a;

import flow.dev.a;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.MinecraftClient;

final class uhg {
   private static final HttpClient uhh = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();
   private static final ExecutorService uhi = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, a.d("啈ⳓꘃ㡪돸㕛轘ڸ飴ቃ閝", -937584473, -397226590));
      var1.setDaemon(true);
      return var1;
   });
   private final uhc uhj;
   private final AtomicBoolean uhk = new AtomicBoolean();
   private final StringBuilder uhl = new StringBuilder();
   private volatile WebSocket uhm;

   uhg(URI var1, uhc var2) {
      this.uhj = var2;
      uhh.newWebSocketBuilder().connectTimeout(Duration.ofSeconds(10L)).buildAsync(var1, new uhd(this)).whenComplete((var1x, var2x) -> {
         if (var2x != null) {
            this.uhp(-1, uhq(var2x));
         }
      });
   }

   void send(String var1) {
      uhi.execute(() -> {
         WebSocket var2 = this.uhm;
         if (var2 != null && !this.uhk.get()) {
            try {
               var2.sendText(var1, true).get(10L, TimeUnit.SECONDS);
            } catch (Exception var4) {
               var2.abort();
               this.uhp(-1, uhq(var4));
            }
         }
      });
   }

   void close() {
      if (this.uhk.compareAndSet(false, true)) {
         WebSocket var1 = this.uhm;
         if (var1 != null) {
            uhi.execute(() -> {
               try {
                  var1.sendClose(1000, a.b("␍嶧흨", -1938086804)).get(2L, TimeUnit.SECONDS);
               } catch (Exception var2) {
               }

               var1.abort();
            });
         }
      }
   }

   private void uhp(int var1, String var2) {
      if (this.uhk.compareAndSet(false, true)) {
         WebSocket var3 = this.uhm;
         if (var3 != null) {
            var3.abort();
         }

         uhr(() -> this.uhj.closed(this, var1, var2));
      }
   }

   private static String uhq(Throwable var0) {
      while (var0.getCause() != null && var0.getCause() != var0) {
         var0 = var0.getCause();
      }

      String var1 = var0.getMessage();
      return var0.getClass().getSimpleName() + (var1 != null ? a.c(1142845654, "烮ॅ") + var1 : "");
   }

   private static void uhr(Runnable var0) {
      MinecraftClient.method_1551().execute(var0);
   }
}
