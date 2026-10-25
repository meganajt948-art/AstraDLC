package a;

public final class pnf {
   static final long png = 160L;
   static volatile psf pnh;
   static volatile int pni;
   static volatile boolean pnj;
   static volatile boolean pnk;
   static volatile boolean pnl;
   static volatile String pnm = "";
   static volatile long pnn;

   pnf() {
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

   static boolean pnq() {
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
