package a;

import com.google.gson.JsonObject;

final class ubp {
   final JsonObject json = new JsonObject();

   private ubp() {
   }

   ubp put(String var1, String var2) {
      this.json.addProperty(var1, var2);
      return this;
   }
}
