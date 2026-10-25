package a;

final class rrj {
   final int rrk;
   final double rrl;
   final double rrm;
   final double rrn;
   final float rro;
   final float rrp;
   final boolean rrq;
   final boolean rrr;

   rrj(int id, double x, double y, double z, float yaw, float height, boolean player, boolean totem) {
      this.rrk = id;
      this.rrl = x;
      this.rrm = y;
      this.rrn = z;
      this.rro = yaw;
      this.rrp = height;
      this.rrq = player;
      this.rrr = totem;
   }

   public int id() {
      return this.rrk;
   }

   public double x() {
      return this.rrl;
   }

   public double y() {
      return this.rrm;
   }

   public double z() {
      return this.rrn;
   }

   public float yaw() {
      return this.rro;
   }

   public float height() {
      return this.rrp;
   }

   public boolean player() {
      return this.rrq;
   }

   public boolean totem() {
      return this.rrr;
   }
}
