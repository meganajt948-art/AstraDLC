package a;

import java.nio.ShortBuffer;

final class vsd {
   final ShortBuffer vse;
   final int vsf;
   final int vsg;

   vsd(ShortBuffer data, int channels, int rate) {
      this.vse = data;
      this.vsf = channels;
      this.vsg = rate;
   }

   public ShortBuffer data() {
      return this.vse;
   }

   public int channels() {
      return this.vsf;
   }

   public int rate() {
      return this.vsg;
   }
}
