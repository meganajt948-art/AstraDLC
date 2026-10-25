package a;

final class vpi {
   final short[] vpj;
   final int vpk;
   final int vpl;

   vpi(short[] data, int channels, int rate) {
      this.vpj = data;
      this.vpk = channels;
      this.vpl = rate;
   }

   public short[] data() {
      return this.vpj;
   }

   public int channels() {
      return this.vpk;
   }

   public int rate() {
      return this.vpl;
   }
}
