package a;

import java.util.Map;

public final class eyg {
   final String eyh;
   final long eyi;
   final long eyj;
   final Map<String, String> eyk;

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
