package a;

import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;

final class kug {
   static final int IN = 15;
   static final int OUT = 8;
   static final int READY = 400;
   static final int kuh = 32;
   static final int kui = 16;
   static final int kuj = 20000;
   static final int kuk = 16;
   static final int kul = 6;
   static final int kum = 64;
   static final double kun = 0.001;
   static final double kuo = 0.9;
   static final double kup = 0.999;
   static final double kuq = 1.0E-8;
   static final int kur = 2000;
   static final int kus = 1177700436;
   tbx kut;
   double[] kuu;
   double[] kuv;
   long kuw;
   long kux;
   double kuy = 0.5;
   double kuz = 0.5;
   int kva;
   boolean kvb;
   final float[] kvc = new float[300000];
   final byte[] kvd = new byte[20000];
   final byte[] kve = new byte[20000];
   int kvf;
   int kvg;
   final ArrayDeque<kud> kvh = new ArrayDeque<>();
   final double[] kvi = new double[32];
   final double[] kvj = new double[16];
   final double[] kvk = new double[8];
   final double[] kvl = new double[8];
   final double[] kvm = new double[32];
   final double[] kvn = new double[16];
   final double[] kvo = new double[15];
   double[] kvp;
   static final String kvq = a.c(-1344875438, "퐼권❂뤩㋵둕");

   boolean ready() {
      this.kvv();
      return this.kux >= 400L;
   }

   long seen() {
      this.kvv();
      return this.kux;
   }

   double accuracy() {
      return this.kuy;
   }

   double hitRate() {
      return this.kuz;
   }

   void predict(double[] var1, double[] var2) {
      this.kvv();
      this.kut.forward(var1, this.kvi, this.kvj, this.kvk);

      for (int var3 = 0; var3 < 8; var3++) {
         var2[var3] = kvy(this.kvk[var3]);
      }
   }

   void observe(int var1, Entity var2, double[] var3, double[] var4) {
      this.kvv();
      this.kvh.addLast(new kud(var1, var2, (double[])var3.clone(), (double[])var4.clone()));
   }

   void censor(int var1) {
      for (kud var3 : this.kvh) {
         var3.censorFrom = Math.min(var3.censorFrom, var1);
      }
   }

   void label(int var1, Entity var2) {
      Iterator var3 = this.kvh.iterator();

      while (var3.hasNext()) {
         kud var4 = (kud)var3.next();
         int var5 = var1 - var4.tick;
         if (var5 >= 1) {
            if (var1 < var4.censorFrom && var5 <= 8) {
               var4.mask |= 1 << var5 - 1;
               if (var2 == var4.target) {
                  var4.labels |= 1 << var5 - 1;
               }
            }

            if (var5 >= 8 || var1 >= var4.censorFrom) {
               var3.remove();
               this.kvt(var4);
            }
         }
      }
   }

   void kvt(kud var1) {
      if (var1.mask != 0) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;

         for (int var5 = 0; var5 < 8; var5++) {
            if ((var1.mask & 1 << var5) != 0) {
               boolean var6 = (var1.labels & 1 << var5) != 0;
               if (var6 == var1.p[var5] >= 0.5) {
                  var2++;
               }

               if (var6) {
                  var4++;
               }

               var3++;
            }
         }

         this.kuy = this.kuy + 0.01 * ((double)var2 / var3 - this.kuy);
         this.kuz = this.kuz + 0.01 * ((double)var4 / var3 - this.kuz);
         int var7 = this.kvg;

         for (int var8 = 0; var8 < 15; var8++) {
            this.kvc[var7 * 15 + var8] = (float)var1.x[var8];
         }

         this.kvd[var7] = (byte)var1.labels;
         this.kve[var7] = (byte)var1.mask;
         this.kvg = (this.kvg + 1) % 20000;
         this.kvf = Math.min(20000, this.kvf + 1);
         this.kux++;
      }
   }

   void train() {
      this.kvv();
      if (this.kvf >= 64) {
         ThreadLocalRandom var1 = ThreadLocalRandom.current();

         for (int var2 = 0; var2 < 6; var2++) {
            Arrays.fill(this.kvp, 0.0);

            for (int var3 = 0; var3 < 16; var3++) {
               int var4 = var1.nextInt(this.kvf);

               for (int var5 = 0; var5 < 15; var5++) {
                  this.kvo[var5] = this.kvc[var4 * 15 + var5];
               }

               this.kut.forward(this.kvo, this.kvi, this.kvj, this.kvk);
               byte var10 = this.kvd[var4];
               byte var6 = this.kve[var4];

               for (int var7 = 0; var7 < 8; var7++) {
                  if ((var6 & 1 << var7) == 0) {
                     this.kvl[var7] = 0.0;
                  } else {
                     double var8 = (var10 & 1 << var7) != 0 ? 1.0 : 0.0;
                     this.kvl[var7] = (kvy(this.kvk[var7]) - var8) / 16.0;
                  }
               }

               this.kut.backward(this.kvo, this.kvi, this.kvj, this.kvl, this.kvp, null, this.kvm, this.kvn);
            }

            this.kvu();
         }

         if (++this.kva >= 2000) {
            this.kva = 0;
            this.save();
         }
      }
   }

   void kvu() {
      this.kuw++;
      double var1 = 1.0 - Math.pow(0.9, this.kuw);
      double var3 = 1.0 - Math.pow(0.999, this.kuw);
      double[] var5 = this.kut.p;

      for (int var6 = 0; var6 < var5.length; var6++) {
         this.kuu[var6] = 0.9 * this.kuu[var6] + 0.09999999999999998 * this.kvp[var6];
         this.kuv[var6] = 0.999 * this.kuv[var6] + 0.0010000000000000009 * this.kvp[var6] * this.kvp[var6];
         var5[var6] -= 0.001 * (this.kuu[var6] / var1) / (Math.sqrt(this.kuv[var6] / var3) + 1.0E-8);
      }
   }

   void reset() {
      this.kvv();
      this.kvw();
      this.kvf = 0;
      this.kvg = 0;
      this.kvh.clear();
      this.save();
   }

   void save() {
      if (this.kut != null) {
         try {
            ByteArrayOutputStream var1 = new ByteArrayOutputStream();
            DataOutputStream var2 = new DataOutputStream(var1);
            var2.writeInt(1177700436);
            var2.writeLong(this.kux);
            var2.writeDouble(this.kuy);
            var2.writeDouble(this.kuz);
            this.kut.write(var2);
            var2.flush();
            byte[] var3 = var1.toByteArray();
            vza.later(a.c(117273160, "爎ங腑Ἦ铹ቊꠎ⇏뾽㔗느䢯왳忓햃卪\ue938曰"), () -> ewk.putBytes(a.c(-2130004419, "뙓쿣䔭\udb46傚혺"), var3));
         } catch (Exception var4) {
            System.out.println(a.d("῏晼\ueca0犘卵翹엹䰚퉒声\udf66╃ꮈ㈴렢㺧蓎\u0b04醹៨鸝\ue45b櫘\uf124着ﷅ䐸쩢傄훖嵽ꎱ⧧끇㘎", -1252507720, 510009399) + var4);
         }
      }
   }

   void kvv() {
      if (!this.kvb) {
         this.kvb = true;

         try {
            byte[] var1 = ewk.getBytes(a.b("蚫；痕\uebbe恢\ue6c2", -554989883));
            if (var1 != null && var1.length > 0) {
               DataInputStream var2 = new DataInputStream(new ByteArrayInputStream(var1));
               if (var2.readInt() == 1177700436) {
                  long var3 = var2.readLong();
                  double var5 = var2.readDouble();
                  double var7 = var2.readDouble();
                  tbx var9 = tbx.read(var2);
                  if (var9.in == 15 && var9.h1 == 32 && var9.h2 == 16 && var9.out == 8) {
                     this.kvx(var9);
                     this.kux = var3;
                     this.kuy = var5;
                     this.kuz = var7;
                     return;
                  }
               }
            }
         } catch (Exception var10) {
            System.out.println(a.d("糒ա辽ᆅ騁᳤ꛥ⼃녘㯬뱻䙞좕儩\udb3f嶺\ue7d3栙\uf2a4瓵ﴀ蝆\u09c5鈹ᑝ默✥\ua97f㎙뗋㹠사䫺퍚唓", -700514834, 1629585788) + var10);
         }

         this.kvw();
      }
   }

   void kvw() {
      tbx var1 = new tbx(15, 32, 16, 8);
      var1.init(new Random(), new double[8]);
      this.kvx(var1);
      this.kux = 0L;
      this.kuy = 0.5;
      this.kuz = 0.5;
      this.kuw = 0L;
   }

   void kvx(tbx var1) {
      this.kut = var1;
      this.kuu = new double[var1.size()];
      this.kuv = new double[var1.size()];
      this.kvp = new double[var1.size()];
      this.kuw = 0L;
   }

   static double kvy(double var0) {
      return 1.0 / (1.0 + Math.exp(-var0));
   }
}
