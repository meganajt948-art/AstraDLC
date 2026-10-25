package a;

import java.util.Map;

public record eyg(String key, long size, long uploaded, Map<String, String> meta) {
   private final String eyh;
   private final long eyi;
   private final long eyj;
   private final Map<String, String> eyk;

   public eyg(String key, long size, long uploaded, Map<String, String> meta) {
      this.eyh = key;
      this.eyi = size;
      this.eyj = uploaded;
      this.eyk = meta;
   }

   public String key() {
      return this.eyh;
   }

   public long size() {
      return this.eyi;
   }

   public long uploaded() {
      return this.eyj;
   }

   public Map<String, String> meta() {
      return this.eyk;
   }
}
