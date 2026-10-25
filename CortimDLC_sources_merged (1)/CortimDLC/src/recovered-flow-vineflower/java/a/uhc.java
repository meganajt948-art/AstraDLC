package a;

import com.google.gson.JsonObject;

interface uhc {
   void opened(uhg var1);

   void message(uhg var1, JsonObject var2);

   void closed(uhg var1, int var2, String var3);
}
