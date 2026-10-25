package a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

final class eke {
   static final byte[] ekf = a.b("\ue797鸬ᓼ誕ć螩㶵둉⨍ꂻ", -1307187205).getBytes(StandardCharsets.UTF_8);

   eke() {
   }

   static byte[] eki(byte[] var0) {
      byte[] var1 = new byte[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = (byte)(var0[var2] ^ ekf[var2 % ekf.length] ^ var2 * 31);
      }

      return var1;
   }

   static ejz load() {
      ArrayList var0 = new ArrayList();
      int var1 = 0;

      try {
         String var2 = ewk.get(a.c(-1460241541, "笝ʡ衩ᘟ"));
         if (var2 == null || var2.isBlank()) {
            return new ejz(0, var0);
         }

         byte[] var3 = Base64.getDecoder().decode(var2.trim());
         String var4 = new String(eki(var3), StandardCharsets.UTF_8);
         JsonElement var5 = JsonParser.parseString(var4);
         if (!var5.isJsonObject()) {
            return new ejz(0, var0);
         }

         JsonObject var6 = var5.getAsJsonObject();
         if (var6.has(a.b("Ὢ", 125837085))) {
            var1 = var6.get(a.d("봸", -1877114394, 769473705)).getAsInt();
         }

         if (var6.has(a.d("ᗀ", -2099872564, 1619028335)) && var6.get(a.d("帝", -783202492, -1145235142)).isJsonArray()) {
            for (JsonElement var8 : var6.getAsJsonArray(a.c(-602604192, "ﴃ"))) {
               if (var8.isJsonObject()) {
                  JsonObject var9 = var8.getAsJsonObject();
                  if (var9.has(a.c(663941316, "\uf0ab")) && var9.has(a.b("ᚃ", -1111877917))) {
                     String var10 = var9.has(a.c(-1840479440, "荁")) ? var9.get(a.c(367972735, "턎")).getAsString() : null;
                     boolean var11 = !var9.has(a.d("\udece", 98093091, 661526174)) || var9.get(a.b("鹼", 932945423)).getAsBoolean();
                     var0.add(new ejs(var9.get(a.d("Ꞻ", 1826879479, 1947750434)).getAsString(), var9.get(a.b("쯁", -1633104991)).getAsString(), var10, var11));
                  }
               }
            }
         }
      } catch (Exception var12) {
      }

      return new ejz(var1, var0);
   }

   static void save(List<dtv> var0, int var1) {
      try {
         JsonArray var2 = new JsonArray();

         for (dtv var4 : var0) {
            JsonObject var5 = new JsonObject();
            var5.addProperty(a.b("ᑩ", -2076306426), var4.getName());
            var5.addProperty(a.d("\uf048", -1413176890, 198988270), var4.getAddress());
            String var6 = var4.loginPassword();
            if (var6 != null) {
               var5.addProperty(a.c(145779160, "榩"), var6);
            }

            var5.addProperty(a.b("㌭", -1717161122), var4.isAutoReconnect());
            var2.add(var5);
         }

         JsonObject var8 = new JsonObject();
         var8.addProperty(a.c(-390160714, "黁"), var1);
         var8.add(a.c(1080072828, "騟"), var2);
         byte[] var9 = eki(var8.toString().getBytes(StandardCharsets.UTF_8));
         ewk.put(a.c(-645095806, "黤\ue758涐\uf3e6"), Base64.getEncoder().encodeToString(var9));
      } catch (Exception var7) {
      }
   }
}
