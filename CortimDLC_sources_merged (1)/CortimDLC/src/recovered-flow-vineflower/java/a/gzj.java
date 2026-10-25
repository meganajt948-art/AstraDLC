package a;

final class gzj {
   final int gzk;
   final String gzl;
   final long gzm;
   final float gzn;
   final float gzo;
   final boolean gzp;
   final String gzq;

   gzj(int var1, String var2, long var3, float var5, float var6, boolean var7) {
      this(var1, var2, var3, var5, var6, var7, "");
   }

   gzj(int at, String name, long time, float yaw, float pitch, boolean on, String extra) {
      this.gzk = at;
      this.gzl = name;
      this.gzm = time;
      this.gzn = yaw;
      this.gzo = pitch;
      this.gzp = on;
      this.gzq = extra;
   }

   public int at() {
      return this.gzk;
   }

   public String name() {
      return this.gzl;
   }

   public long time() {
      return this.gzm;
   }

   public float yaw() {
      return this.gzn;
   }

   public float pitch() {
      return this.gzo;
   }

   public boolean on() {
      return this.gzp;
   }

   public String extra() {
      return this.gzq;
   }
}
