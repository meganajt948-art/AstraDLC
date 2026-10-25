package a;

final class iom {
   final String ion;
   final String ioo;
   final int[] iop;
   final float ioq;
   final boolean ior;
   final int[] ios;

   iom(String name, String group, int[] colors, float tintScale, boolean light, int[] accent) {
      this.ion = name;
      this.ioo = group;
      this.iop = colors;
      this.ioq = tintScale;
      this.ior = light;
      this.ios = accent;
   }

   int color(int var1) {
      return this.iop[var1];
   }

   boolean isGlass() {
      return this.ioq < 0.9F;
   }

   public String name() {
      return this.ion;
   }

   public String group() {
      return this.ioo;
   }

   public int[] colors() {
      return this.iop;
   }

   public float tintScale() {
      return this.ioq;
   }

   public boolean light() {
      return this.ior;
   }

   public int[] accent() {
      return this.ios;
   }
}
