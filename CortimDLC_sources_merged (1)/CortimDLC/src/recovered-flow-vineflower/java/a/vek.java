package a;

public enum vek {
   REGULAR("/flow/font/Inter-Regular.ttf"),
   MEDIUM("/flow/font/Inter-Medium.ttf"),
   SEMIBOLD("/flow/font/Inter-SemiBold.ttf"),
   BOLD("/flow/font/Inter-Bold.ttf");

   private final String vel;

   private vek(String var3) {
      this.vel = var3;
   }
}
