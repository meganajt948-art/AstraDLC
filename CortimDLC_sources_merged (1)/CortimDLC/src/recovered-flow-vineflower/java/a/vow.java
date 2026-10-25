package a;

import java.nio.file.Path;

final class vow {
   private final String vox;
   private final Path voy;
   private final Path voz;
   private final Path vpa;

   private vow(String name, Path both, Path on, Path off) {
      this.vox = name;
      this.voy = both;
      this.voz = on;
      this.vpa = off;
   }

   vow with(Boolean var1, Path var2) {
      if (var1 == null) {
         return this.voy != null ? this : new vow(this.vox, var2, this.voz, this.vpa);
      } else if (var1) {
         return this.voz != null ? this : new vow(this.vox, this.voy, var2, this.vpa);
      } else {
         return this.vpa != null ? this : new vow(this.vox, this.voy, this.voz, var2);
      }
   }

   public String name() {
      return this.vox;
   }

   public Path both() {
      return this.voy;
   }

   public Path on() {
      return this.voz;
   }

   public Path off() {
      return this.vpa;
   }
}
