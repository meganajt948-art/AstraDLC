package a;

public record lpc(
   double reach,
   boolean crits,
   boolean serverSprinting,
   boolean lateSmash,
   double spread,
   float lookYaw,
   float lookPitch,
   double maxTurn,
   double minFall,
   double maxFall
) {
   private final double lpd;
   private final boolean lpe;
   private final boolean lpf;
   private final boolean lpg;
   private final double lph;
   private final float lpi;
   private final float lpj;
   private final double lpk;
   private final double lpl;
   private final double lpm;

   public lpc(
      double reach,
      boolean crits,
      boolean serverSprinting,
      boolean lateSmash,
      double spread,
      float lookYaw,
      float lookPitch,
      double maxTurn,
      double minFall,
      double maxFall
   ) {
      this.lpd = reach;
      this.lpe = crits;
      this.lpf = serverSprinting;
      this.lpg = lateSmash;
      this.lph = spread;
      this.lpi = lookYaw;
      this.lpj = lookPitch;
      this.lpk = maxTurn;
      this.lpl = minFall;
      this.lpm = maxFall;
   }

   public double reach() {
      return this.lpd;
   }

   public boolean crits() {
      return this.lpe;
   }

   public boolean serverSprinting() {
      return this.lpf;
   }

   public boolean lateSmash() {
      return this.lpg;
   }

   public double spread() {
      return this.lph;
   }

   public float lookYaw() {
      return this.lpi;
   }

   public float lookPitch() {
      return this.lpj;
   }

   public double maxTurn() {
      return this.lpk;
   }

   public double minFall() {
      return this.lpl;
   }

   public double maxFall() {
      return this.lpm;
   }
}
