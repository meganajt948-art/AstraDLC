package a;

final class fot {
   final String fou;
   final int fov;
   final boolean fow;
   final double fox;
   final boolean foy;
   final float foz;

   fot(String name, int ticks, boolean jump, double aggression, boolean botJumps, float aim) {
      this.fou = name;
      this.fov = ticks;
      this.fow = jump;
      this.fox = aggression;
      this.foy = botJumps;
      this.foz = aim;
   }

   public String name() {
      return this.fou;
   }

   public int ticks() {
      return this.fov;
   }

   public boolean jump() {
      return this.fow;
   }

   public double aggression() {
      return this.fox;
   }

   public boolean botJumps() {
      return this.foy;
   }

   public float aim() {
      return this.foz;
   }
}
