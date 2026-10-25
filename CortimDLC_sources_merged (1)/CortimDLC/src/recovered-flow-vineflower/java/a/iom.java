package a;

record iom(String name, String group, int[] colors, float tintScale, boolean light, int[] accent) {
   private final String ion;
   private final String ioo;
   private final int[] iop;
   private final float ioq;
   private final boolean ior;
   private final int[] ios;

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
