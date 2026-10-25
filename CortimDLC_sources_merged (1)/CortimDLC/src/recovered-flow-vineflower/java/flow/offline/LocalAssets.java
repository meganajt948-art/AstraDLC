package flow.offline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public final class LocalAssets {
   private static final ConcurrentHashMap<String, byte[]> CACHE = new ConcurrentHashMap<>();

   private LocalAssets() {
   }

   public static byte[] bytes(String name) throws IOException {
      if (name == null) {
         throw new IOException("Empty resource name");
      } else {
         String key = name.replace('\\', '/').trim();

         while (key.startsWith("/")) {
            key = key.substring(1);
         }

         if (key.startsWith("flow/")) {
            key = key.substring(5);
         }

         for (String part : key.split("/")) {
            if (part.isEmpty() || part.equals(".") || part.equals("..")) {
               throw new IOException("Invalid resource name");
            }
         }

         byte[] cached = CACHE.get(key);
         if (cached != null) {
            return cached;
         } else {
            byte[] var11;
            try (InputStream in = LocalAssets.class.getResourceAsStream("/flow_offline_assets/" + key)) {
               if (in == null) {
                  throw new FileNotFoundException("Resource was not present in the supplied dump: " + key);
               }

               byte[] data = in.readAllBytes();
               if (data.length <= 2097152) {
                  CACHE.putIfAbsent(key, data);
               }

               var11 = data;
            }

            return var11;
         }
      }
   }
}
