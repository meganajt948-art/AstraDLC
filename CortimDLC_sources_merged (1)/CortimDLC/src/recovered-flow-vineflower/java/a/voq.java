package a;

import java.util.List;
import java.util.Map;

record voq(String signature, Map<String, vow> sounds, List<String> extras) {
   private final String vor;
   private final Map<String, vow> vos;
   private final List<String> vot;

   private voq(String signature, Map<String, vow> sounds, List<String> extras) {
      this.vor = signature;
      this.vos = sounds;
      this.vot = extras;
   }

   public String signature() {
      return this.vor;
   }

   public Map<String, vow> sounds() {
      return this.vos;
   }

   public List<String> extras() {
      return this.vot;
   }
}
