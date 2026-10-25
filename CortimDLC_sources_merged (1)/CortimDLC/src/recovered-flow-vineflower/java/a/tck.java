package a;

import flow.dev.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class tck {
   public static final int MAGIC = 1177701965;
   public static final int VERSION = 4;
   public static final int KIND_AIM = 0;
   public static final int KIND_AURA = 1;
   public static final double[] EDGES = new double[]{0.5, 1.0, 2.0, 4.0, 8.0, 16.0, 32.0, 64.0};
   public static final int BINS = EDGES.length + 1;
   public tbx[] nets = new tbx[0];
   public int lag = 3;
   public float[] qIn = new float[0];
   public float[] qOut = new float[0];
   public float boost = 1.0F;
   public float boostFrom;
   public float boostTo;
   public int flicks;
   public int tracking;
   public final double[] mu = new double[32];
   public final double[] sd = new double[32];
   public boolean mirror;
   public final double[] speedCap = new double[BINS];
   public final double[] accelCap = new double[BINS];
   public float[] aimU = new float[0];
   public float[] aimV = new float[0];
   public float[] resX = new float[0];
   public float[] resY = new float[0];
   public byte[] resBin = new byte[0];
   public boolean[] resLink = new boolean[0];
   public int kind = 0;
   public float[] axes = new float[0];
   public float texX = 1.0F;
   public float texY = 1.0F;
   public float texCap = 0.35F;
   public float texFloor = 0.12F;
   public float turnCap;
   public float[] chainU = new float[0];
   public float[] chainV = new float[0];
   public int[] chainGap = new int[0];
   public int[] reactions = new int[0];
   public long created;
   public int hits;
   public int steps;
   public int epochs;
   public float unit;
   public double similarity;
   public double speedMatch;
   public double timeMatch;
   public double shapeMatch;
   public double overshootModel;
   public double overshootUser;
   public double userPeak;
   public double modelPeak;
   public double userEntry;
   public double modelEntry;
   private int[][] tcl;
   private static tck tcm;
   private static boolean tcn;
   private static tck tco;
   private static boolean tcp;

   public static synchronized tck profile1() {
      if (!tcn) {
         tcn = true;

         try (InputStream var0 = tjs.open()) {
            tcm = read(var0);
         } catch (Exception var5) {
            System.out.println(a.c(1342195124, "䗍㱾뚢⢚ꌞ◻鿺ᘜ衇˳蕤罁\uf18a栶\ue220撐\uded7儂쯼䷠쐕빏ヽꬥⴌꟇ") + var5);
            tcm = null;
         }
      }

      return tcm;
   }

   public static synchronized tck profileOld() {
      if (!tcp) {
         tcp = true;

         try (InputStream var0 = tjx.open()) {
            tco = read(var0);
         } catch (Exception var5) {
            System.out.println(a.c(-434274647, "绔ݧ趻ᎃ頇Ợꓣⴅ덞㧪빽䑘쪓匯\ud939徇\ue5cb樒\uf0e5盵＊蕟\u0ba1逽ᙀ鲚┨ꭰ㇑랚") + var5);
            tco = null;
         }
      }

      return tco != null ? tco : profile1();
   }

   public static int bin(double var0) {
      int var2 = 0;

      while (var2 < EDGES.length && var0 >= EDGES[var2]) {
         var2++;
      }

      return var2;
   }

   public void raw(double[] var1, double[] var2, tch var3) {
      tbf.features(var1, this.mu, this.sd, var3.x);
      Arrays.fill(var3.sum, 0.0);

      for (tbx var7 : this.nets) {
         var3.fit(var7);
         var7.forward(var3.x, var3.a1, var3.a2, var3.y);

         for (int var8 = 0; var8 < 4; var8++) {
            var3.sum[var8] = var3.sum[var8] + var3.y[var8];
         }
      }

      double var9 = this.nets.length == 0 ? 0.0 : 1.0 / this.nets.length;
      var2[0] = var1[0] * var3.sum[0] * var9 + 2.0 * var3.sum[2] * var9;
      var2[1] = var1[1] * var3.sum[1] * var9 + 2.0 * var3.sum[3] * var9;
   }

   public void predict(double[] var1, double[] var2, tch var3) {
      this.base(var1, var2, var3);
      this.calibrate(var2);
   }

   public void base(double[] var1, double[] var2, tch var3) {
      this.raw(var1, var2, var3);
      if (this.mirror) {
         double var4 = var2[0];
         double var6 = var2[1];
         tbf.mirror(var1, var3.m);
         this.raw(var3.m, var2, var3);
         var2[0] = (var4 - var2[0]) * 0.5;
         var2[1] = (var6 + var2[1]) * 0.5;
      }
   }

   public void calibrate(double[] var1) {
      int var2 = this.qIn.length;
      if (var2 >= 2) {
         double var3 = Math.hypot(var1[0], var1[1]);
         if (!(var3 <= this.qIn[0]) && !(var3 < 1.0E-6)) {
            double var5;
            if (var3 >= this.qIn[var2 - 1]) {
               var5 = var3 * this.qOut[var2 - 1] / Math.max(1.0E-6, (double)this.qIn[var2 - 1]);
            } else {
               int var7 = 1;

               while (var7 < var2 - 1 && this.qIn[var7] < var3) {
                  var7++;
               }

               double var8 = this.qIn[var7 - 1];
               double var10 = this.qIn[var7];
               double var12 = var10 - var8 > 1.0E-9 ? (var3 - var8) / (var10 - var8) : 1.0;
               var5 = this.qOut[var7 - 1] + (this.qOut[var7] - this.qOut[var7 - 1]) * var12;
            }

            double var14 = Math.max(0.6, Math.min(2.0, var5 / var3));
            if (this.boost != 1.0F && this.boostTo > this.boostFrom) {
               double var9 = Math.max(0.0, Math.min(1.0, (var3 - this.boostFrom) / (this.boostTo - this.boostFrom)));
               var14 *= 1.0 + (this.boost - 1.0) * var9 * var9 * (3.0 - 2.0 * var9);
            }

            var1[0] *= var14;
            var1[1] *= var14;
         }
      }
   }

   public double axisScore(int var1) {
      return var1 < this.axes.length ? this.axes[var1] : Double.NaN;
   }

   public boolean ownAim() {
      return this.chainU.length > 0;
   }

   public int reaction(Random var1) {
      return this.reactions.length < 8 ? -1 : this.reactions[var1.nextInt(this.reactions.length)];
   }

   public int[] residualsIn(int var1) {
      if (this.tcl == null) {
         int[][] var2 = new int[BINS][];
         int[] var3 = new int[BINS];

         for (byte var7 : this.resBin) {
            var3[var7]++;
         }

         for (int var10 = 0; var10 < BINS; var10++) {
            var2[var10] = new int[var3[var10]];
            var3[var10] = 0;
         }

         int var11 = 0;

         while (var11 < this.resBin.length) {
            byte var13 = this.resBin[var11];
            var2[var13][var3[var13]++] = var11++;
         }

         this.tcl = var2;
      }

      for (int var8 = 0; var8 < BINS; var8++) {
         int var9 = var1 - var8;
         int var12 = var1 + var8;
         if (var9 >= 0 && this.tcl[var9].length > 0) {
            return this.tcl[var9];
         }

         if (var12 < BINS && this.tcl[var12].length > 0) {
            return this.tcl[var12];
         }
      }

      return new int[0];
   }

   public void write(Path var1) throws IOException {
      throw new IOException(a.b("䢷ㄍ믎▸깲⢌銛᭧蔢ཱྀ衑爮ﳰ敀", -1194637097));
   }

   public byte[] bytes() throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(262144);

      try (DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1, 65536), 65536))) {
         var2.writeInt(1177701965);
         var2.writeInt(4);
         var2.writeLong(this.created);
         var2.writeInt(this.hits);
         var2.writeInt(this.steps);
         var2.writeInt(this.epochs);
         var2.writeFloat(this.unit);
         double[] var3 = new double[]{
            this.similarity,
            this.speedMatch,
            this.timeMatch,
            this.shapeMatch,
            this.overshootModel,
            this.overshootUser,
            this.userPeak,
            this.modelPeak,
            this.userEntry,
            this.modelEntry
         };
         var2.writeInt(var3.length);

         for (double var7 : var3) {
            var2.writeDouble(var7);
         }

         var2.writeBoolean(this.mirror);

         for (int var11 = 0; var11 < 32; var11++) {
            var2.writeDouble(this.mu[var11]);
            var2.writeDouble(this.sd[var11]);
         }

         var2.writeInt(this.nets.length);

         for (tbx var26 : this.nets) {
            var26.write(var2);
         }

         var2.writeInt(this.lag);
         var2.writeInt(this.flicks);
         var2.writeInt(this.tracking);
         var2.writeFloat(this.boost);
         var2.writeFloat(this.boostFrom);
         var2.writeFloat(this.boostTo);
         var2.writeInt(this.qIn.length);

         for (int var13 = 0; var13 < this.qIn.length; var13++) {
            var2.writeFloat(this.qIn[var13]);
            var2.writeFloat(this.qOut[var13]);
         }

         for (int var14 = 0; var14 < BINS; var14++) {
            var2.writeFloat((float)this.speedCap[var14]);
            var2.writeFloat((float)this.accelCap[var14]);
         }

         var2.writeInt(this.aimU.length);

         for (int var15 = 0; var15 < this.aimU.length; var15++) {
            var2.writeFloat(this.aimU[var15]);
            var2.writeFloat(this.aimV[var15]);
         }

         var2.writeInt(this.resX.length);

         for (int var16 = 0; var16 < this.resX.length; var16++) {
            var2.writeFloat(this.resX[var16]);
            var2.writeFloat(this.resY[var16]);
            var2.writeByte(this.resBin[var16]);
            var2.writeBoolean(this.resLink[var16]);
         }

         var2.writeInt(this.kind);
         var2.writeFloat(this.texX);
         var2.writeFloat(this.texY);
         var2.writeFloat(this.texCap);
         var2.writeFloat(this.texFloor);
         var2.writeInt(this.axes.length);

         for (float var27 : this.axes) {
            var2.writeFloat(var27);
         }

         var2.writeFloat(this.turnCap);
         var2.writeInt(this.chainU.length);

         for (int var18 = 0; var18 < this.chainU.length; var18++) {
            var2.writeFloat(this.chainU[var18]);
            var2.writeFloat(this.chainV[var18]);
            var2.writeShort(this.chainGap[var18]);
         }

         var2.writeInt(this.reactions.length);

         for (int var28 : this.reactions) {
            var2.writeByte(var28);
         }
      }

      return var1.toByteArray();
   }

   private static float[] tcs(DataInputStream var0) throws IOException {
      int var1 = var0.readInt();
      if (var1 >= 0 && var1 <= 4096) {
         float[] var2 = new float[var1];

         for (int var3 = 0; var3 < var1; var3++) {
            var2[var3] = var0.readFloat();
         }

         return var2;
      } else {
         throw new IOException(a.d("㼺䚈챞剫\ud9fd彟\ue50c泮\uf2a9", 1025434393, 1924389960));
      }
   }

   public static tck read(Path var0) throws IOException {
      return read(Files.newInputStream(var0));
   }

   public static tck read(InputStream var0) throws IOException {
      tck var22;
      try (DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0, 65536), 65536))) {
         if (var1.readInt() != 1177701965) {
            throw new IOException(a.d("ᚡ漑\ue5d9篼\uf06a皚첄䕷\udb23冓홉", 1672856540, -1377446632));
         }

         int var2 = var1.readInt();
         if (var2 < 2 || var2 > 4) {
            throw new IOException(a.c(-962409388, "착떛㽀ꅵ⫯걜ᘄ鿴Ƣ譟\u0cda\uf6b8硸\ue1c8殁\ued76圸\ud8a7") + var2);
         }

         tck var3 = new tck();
         var3.created = var1.readLong();
         var3.hits = var1.readInt();
         var3.steps = var1.readInt();
         var3.epochs = var1.readInt();
         var3.unit = var1.readFloat();
         int var4 = var1.readInt();
         double[] var5 = new double[Math.max(10, var4)];

         for (int var6 = 0; var6 < var4; var6++) {
            var5[var6] = var1.readDouble();
         }

         var3.similarity = var5[0];
         var3.speedMatch = var5[1];
         var3.timeMatch = var5[2];
         var3.shapeMatch = var5[3];
         var3.overshootModel = var5[4];
         var3.overshootUser = var5[5];
         var3.userPeak = var5[6];
         var3.modelPeak = var5[7];
         var3.userEntry = var5[8];
         var3.modelEntry = var5[9];
         var3.mirror = var1.readBoolean();

         for (int var15 = 0; var15 < 32; var15++) {
            var3.mu[var15] = var1.readDouble();
            var3.sd[var15] = var1.readDouble();
         }

         int var16 = var1.readInt();
         if (var16 <= 0 || var16 > 8) {
            throw new IOException(a.d("\ud968ꃚ⨌됹㾫뤑͟誸ᓯ鹑ᦌ\ue3f4", -927342220, -1626326926));
         }

         var3.nets = new tbx[var16];

         for (int var7 = 0; var7 < var16; var7++) {
            var3.nets[var7] = tbx.read(var1);
            if (var3.nets[var7].in != 32 || var3.nets[var7].out != 4) {
               throw new IOException(a.d("્獾簾柖\uec08櫵탯夙의䷬쨾え뻌✹굧⮙釖Ḅ蒠", -1940360304, -621053661));
            }
         }

         var3.lag = var1.readInt();
         var3.flicks = var1.readInt();
         var3.tracking = var1.readInt();
         var3.boost = var1.readFloat();
         var3.boostFrom = var1.readFloat();
         var3.boostTo = var1.readFloat();
         int var17 = var1.readInt();
         if (var17 < 0 || var17 > 256) {
            throw new IOException(a.c(-2074862039, "Ṅ柶\ued20猕\uf881縲쑬䶘폌奭\udeadⓉꨃ㎴맦"));
         }

         var3.qIn = new float[var17];
         var3.qOut = new float[var17];

         for (int var8 = 0; var8 < var17; var8++) {
            var3.qIn[var8] = var1.readFloat();
            var3.qOut[var8] = var1.readFloat();
         }

         for (int var18 = 0; var18 < BINS; var18++) {
            var3.speedCap[var18] = var1.readFloat();
            var3.accelCap[var18] = var1.readFloat();
         }

         int var19 = var1.readInt();
         var3.aimU = new float[var19];
         var3.aimV = new float[var19];

         for (int var9 = 0; var9 < var19; var9++) {
            var3.aimU[var9] = var1.readFloat();
            var3.aimV[var9] = var1.readFloat();
         }

         int var20 = var1.readInt();
         var3.resX = new float[var20];
         var3.resY = new float[var20];
         var3.resBin = new byte[var20];
         var3.resLink = new boolean[var20];

         for (int var10 = 0; var10 < var20; var10++) {
            var3.resX[var10] = var1.readFloat();
            var3.resY[var10] = var1.readFloat();
            var3.resBin[var10] = (byte)Math.max(0, Math.min(BINS - 1, var1.readByte()));
            var3.resLink[var10] = var1.readBoolean();
         }

         if (var2 >= 3) {
            var3.kind = var1.readInt();
            var3.texX = var1.readFloat();
            var3.texY = var1.readFloat();
            var3.texCap = var1.readFloat();
            var3.texFloor = var1.readFloat();
            var3.axes = tcs(var1);
         }

         label142:
         if (var2 >= 4) {
            var3.turnCap = var1.readFloat();
            int var21 = var1.readInt();
            if (var21 >= 0 && var21 <= 100000) {
               var3.chainU = new float[var21];
               var3.chainV = new float[var21];
               var3.chainGap = new int[var21];

               for (int var11 = 0; var11 < var21; var11++) {
                  var3.chainU[var11] = var1.readFloat();
                  var3.chainV[var11] = var1.readFloat();
                  var3.chainGap[var11] = var1.readUnsignedShort();
               }

               int var23 = var1.readInt();
               if (var23 >= 0 && var23 <= 100000) {
                  var3.reactions = new int[var23];
                  int var12 = 0;

                  while (true) {
                     if (var12 >= var23) {
                        break label142;
                     }

                     var3.reactions[var12] = var1.readUnsignedByte();
                     var12++;
                  }
               }

               throw new IOException(a.b("賩\uf55b羍\ue1b8樽\uec9b囌\udf3f䅷쯛䰎뙾㢴", 788171910));
            }

            throw new IOException(a.d("泮ᕜ龊ƿ訩ಐ뛇㽻ꅧ⯝갇噾\ud8ae䄂", 192544216, 1666158938));
         }

         var22 = var3;
      }

      return var22;
   }
}
