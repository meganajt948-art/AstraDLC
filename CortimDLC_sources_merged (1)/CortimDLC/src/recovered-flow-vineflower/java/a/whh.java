package a;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

final class whh implements Runnable {
   private final whl this$0;
   final ArrayBlockingQueue<whe> ready;
   final ArrayBlockingQueue<whe> free;
   volatile boolean done;

   whh(whl var1) {
      this.this$0 = var1;
      this.ready = new ArrayBlockingQueue<>(4);
      this.free = new ArrayBlockingQueue<>(4);
   }

   @Override
   public void run() {
      boolean var1 = false;
      boolean var2 = false;
      wet var3 = null;

      try {
         if (!wjh.available()) {
            throw new IOException("needs 64-bit Windows");
         }

         wet.startThread();
         var1 = true;
         byte[] var4 = this.this$0.wjg();
         var3 = this.whk(var4, false);

         for (int var5 = 0; var5 < 4; var5++) {
            this.free.add(new whe(var3.width, var3.height));
         }

         long var26 = 0L;
         long var7 = -1L;
         long var9 = -1L;
         long var11 = 0L;

         while (true) {
            whe var13;
            long var14;
            while (true) {
               if (System.nanoTime() - this.this$0.why >= 2000000000L) {
                  return;
               }

               var13 = this.free.poll(100L, TimeUnit.MILLISECONDS);
               if (var13 != null) {
                  if (var13.width != var3.width || var13.height != var3.height) {
                     var13 = new whe(var3.width, var3.height);
                  }

                  try {
                     var14 = var3.read(var13.y, var13.uv);
                     break;
                  } catch (IOException var22) {
                     if (!var3.hardware) {
                        throw var22;
                     }

                     System.out.println("video " + this.this$0.whx + ": hardware decoding stopped (" + var22.getMessage() + "), going on in software");
                     var3.close();
                     var3 = new wet(var4, false);
                     var26 += var9 >= var7 && var7 >= 0L ? var9 - var7 + var11 : 0L;
                     var9 = -1L;
                     var7 = -1L;
                     this.free.offer(var13);
                  }
               }
            }

            if (var14 < 0L) {
               this.free.offer(var13);
               if (var7 < 0L || var9 < 0L) {
                  throw new IOException("no frames");
               }

               var26 += var9 - var7 + Math.max(var11, 1L);
               var9 = -1L;
               var3.rewind();
            } else {
               if (var7 < 0L) {
                  var7 = var14;
               }

               if (var9 >= 0L && var14 > var9) {
                  var11 = var11 == 0L ? var14 - var9 : Math.min(var11, var14 - var9);
               }

               var9 = Math.max(var9, var14);
               var13.pts = (var26 + var14 - var7) * 100L;
               this.ready.offer(var13);
               var2 = true;
            }
         }
      } catch (InterruptedException var23) {
         Thread.currentThread().interrupt();
      } catch (Throwable var24) {
         if (!var2) {
            this.this$0.whz = true;
         }

         System.out.println("video " + this.this$0.whx + " stopped: " + var24);
      } finally {
         if (var3 != null) {
            var3.close();
         }

         if (var1) {
            wet.endThread();
         }

         this.done = true;
      }
   }

   wet whk(byte[] var1, boolean var2) throws IOException {
      try {
         wet var3 = new wet(var1, var2);
         if (!this.this$0.wiv) {
            this.this$0.wiv = true;
            System.out.println("video " + this.this$0.whx + ": " + var3.width + "x" + var3.height + ", " + (var2 ? "hardware" : "software") + " decoding");
         }

         return var3;
      } catch (IOException var4) {
         if (!var2) {
            throw var4;
         }

         System.out.println("video " + this.this$0.whx + ": no hardware decoding (" + var4.getMessage() + ")");
         return this.whk(var1, false);
      }
   }
}
