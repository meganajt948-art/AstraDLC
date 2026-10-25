package a;

public final class pnf {
   private static final long png = 160L;
   private static volatile psf pnh;
   private static volatile int pni;
   private static volatile boolean pnj;
   private static volatile boolean pnk;
   private static volatile boolean pnl;
   private static volatile String pnm = "";
   private static volatile long pnn;

   private pnf() {
   }

   public static void publish(psf var0, int var1, boolean var2, boolean var3, boolean var4, String var5) {
      pnh = var0;
      pni = var1;
      pnj = var2;
      pnk = var3;
      pnl = var4;
      pnm = var5;
      pnn = System.currentTimeMillis();
   }

   public static void clear() {
      pnh = null;
      pnj = false;
      pnk = false;
      pnl = false;
      pnn = 0L;
   }

   private static boolean pnq() {
      return System.currentTimeMillis() - pnn < 160L;
   }

   public static psf route() {
      return pnq() ? pnh : null;
   }

   public static int at() {
      return pni;
   }

   public static boolean guiding() {
      return pnq() && pnj;
   }

   public static boolean working() {
      return pnq() && pnk;
   }

   public static boolean visible() {
      return pnq() && pnh != null && (pnj || pnl);
   }

   public static String module() {
      return pnq() ? pnm : "";
   }
}
