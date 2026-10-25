package a;

import java.nio.file.Path;

final class vpd {
   private final Path vpe;
   private final boolean vpf;

   vpd(Path file, boolean own) {
      this.vpe = file;
      this.vpf = own;
   }

   public Path file() {
      return this.vpe;
   }

   public boolean own() {
      return this.vpf;
   }
}
