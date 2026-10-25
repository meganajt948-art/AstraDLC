package a;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;

final class uhd implements Listener {
   private final uhg this$0;
   uhd(uhg var1) {
      this.this$0 = var1;
   }

   @Override
   public void onOpen(WebSocket var1) {
      this.this$0.uhm = var1;
      var1.request(1L);
      if (this.this$0.uhk.get()) {
         var1.abort();
      } else {
         uhg.uhr(() -> this.this$0.uhj.opened(this.this$0));
      }
   }

   @Override
   public CompletionStage<?> onText(WebSocket var1, CharSequence var2, boolean var3) {
      this.this$0.uhl.append(var2);
      if (var3) {
         String var4 = this.this$0.uhl.toString();
         this.this$0.uhl.setLength(0);
         if (!var4.equals(a.d("⫐卾\ud9ac䟔", -1678335871, -1170568667)) && var4.length() < 65536) {
            try {
               JsonElement var5 = JsonParser.parseString(var4);
               if (var5.isJsonObject()) {
                  JsonObject var6 = var5.getAsJsonObject();
                  uhg.uhr(() -> {
                     if (!this.this$0.uhk.get()) {
                        this.this$0.uhj.message(this.this$0, var6);
                     }
                  });
               }
            } catch (RuntimeException var7) {
            }
         }
      }

      var1.request(1L);
      return null;
   }

   @Override
   public CompletionStage<?> onClose(WebSocket var1, int var2, String var3) {
      this.this$0.uhp(var2, var3);
      return null;
   }

   @Override
   public void onError(WebSocket var1, Throwable var2) {
      this.this$0.uhp(-1, uhg.uhq(var2));
   }
}
