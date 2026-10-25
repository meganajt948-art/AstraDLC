package a;

import com.google.gson.JsonObject;
import flow.dev.a;

public record ewf(int status, JsonObject body) {
   private final int ewg;
   private final JsonObject ewh;

   public ewf(int status, JsonObject body) {
      this.ewg = status;
      this.ewh = body;
   }

   public boolean ok() {
      return this.ewg == 200 && this.ewh.has(a.b("罏ۺ", 1042186018)) && this.ewh.get(a.d("۫罞", -1072870186, 1001867856)).getAsBoolean();
   }

   public String error() {
      return this.ewh.has(a.d("ᇢ桄\ue297系\uf731", 304517663, -1227783267)) && this.ewh.get(a.c(948925785, "甹ಟ虌ᠠ鏪")).isJsonPrimitive()
         ? this.ewh.get(a.b("옠뾆㕕ꬹ\u20f3", -2066233792)).getAsString()
         : a.b("쏊멧ゴ껁╆", 1095091111) + this.ewg;
   }

   public int status() {
      return this.ewg;
   }

   public JsonObject body() {
      return this.ewh;
   }
}
