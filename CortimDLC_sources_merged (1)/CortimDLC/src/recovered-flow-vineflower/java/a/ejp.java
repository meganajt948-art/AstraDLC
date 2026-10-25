package a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class ejp {
   static final ReentrantLock LOCK = new ReentrantLock(true);
   static volatile dtv active;
   static volatile boolean any;

   ejp() {
   }

   public static boolean isActive() {
      return active != null;
   }

   public static dtv current() {
      return active;
   }

   public static boolean anyBots() {
      return any;
   }

   public static boolean lockMain() {
      if (!any) {
         return false;
      }

      try {
         return LOCK.tryLock(40L, TimeUnit.MILLISECONDS);
      } catch (InterruptedException var1) {
         Thread.currentThread().interrupt();
         return false;
      }
   }

   public static void unlockMain() {
      LOCK.unlock();
   }
}
