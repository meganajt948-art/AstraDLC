package a;

final class gxv {
   final int gxw;
   final String gxx;
   final long gxy;
   final float gxz;
   final float gya;
   final boolean gyb;
   final String gyc;

   gxv(int var1, String var2, long var3, float var5, float var6, boolean var7) {
      this(var1, var2, var3, var5, var6, var7, "");
   }

   gxv(int at, String name, long time, float yaw, float pitch, boolean on, String extra) {
      this.gxw = at;
      this.gxx = name;
      this.gxy = time;
      this.gxz = yaw;
      this.gya = pitch;
      this.gyb = on;
      this.gyc = extra;
   }

   public int at() {
      return this.gxw;
   }

   public String name() {
      return this.gxx;
   }

   public long time() {
      return this.gxy;
   }

   public float yaw() {
      return this.gxz;
   }

   public float pitch() {
      return this.gya;
   }

   public boolean on() {
      return this.gyb;
   }

   public String extra() {
      return this.gyc;
   }
}
