package a;

import flow.dev.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class txs {
   public static final int MAGIC = 1177704269;
   public static final int VERSION = 3;
   public txv net;
   public txp style = new txp();
   public long created;
   public int samples;
   public int valSamples;
   public double keysAcc;
   public double keysBase;
   public double jumpAcc;
   public double sprintAcc;
   public double yawSim;
   public double pitchSim;
   public double yawCeil;
   public double modelJumps;
   public double yawTemp = 0.8;
   public double yawJitter = 0.6;
   public double pitchTemp = 0.8;
   public double pitchJitter = 0.6;
   public double jumpThreshold = 0.3;

   public byte[] bytes() throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(65536);

      try (DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1, 65536), 65536))) {
         var2.writeInt(1177704269);
         var2.writeInt(3);
         var2.writeLong(this.created);
         var2.writeInt(this.samples);
         var2.writeInt(this.valSamples);
         var2.writeDouble(this.keysAcc);
         var2.writeDouble(this.keysBase);
         var2.writeDouble(this.jumpAcc);
         var2.writeDouble(this.sprintAcc);
         var2.writeDouble(this.yawSim);
         var2.writeDouble(this.pitchSim);
         var2.writeDouble(this.yawCeil);
         var2.writeDouble(this.modelJumps);
         var2.writeDouble(this.yawTemp);
         var2.writeDouble(this.yawJitter);
         var2.writeDouble(this.pitchTemp);
         var2.writeDouble(this.pitchJitter);
         var2.writeDouble(this.jumpThreshold);
         this.style.write(var2);
         this.net.write(var2);
      }

      return var1.toByteArray();
   }

   public static txs read(InputStream var0) throws IOException {
      txs var4;
      try (DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0, 65536), 65536))) {
         if (var1.readInt() != 1177704269) {
            throw new IOException(a.d("Ｆ蚖\u0c5e鉻᧭鼝┙곾㊬렚㾂얾䭫틑境\ude7b", -445606313, -280598257));
         }

         int var2 = var1.readInt();
         if (var2 != 3) {
            throw new IOException(a.d("㷸䑊캑傤\udb3e嶍\ue7d5渥\uf073窎ﴋݩ覩မ驐Ყꛩ⥶", 1143663020, -352594903) + var2);
         }

         txs var3 = new txs();
         var3.created = var1.readLong();
         var3.samples = var1.readInt();
         var3.valSamples = var1.readInt();
         var3.keysAcc = var1.readDouble();
         var3.keysBase = var1.readDouble();
         var3.jumpAcc = var1.readDouble();
         var3.sprintAcc = var1.readDouble();
         var3.yawSim = var1.readDouble();
         var3.pitchSim = var1.readDouble();
         var3.yawCeil = var1.readDouble();
         var3.modelJumps = var1.readDouble();
         var3.yawTemp = var1.readDouble();
         var3.yawJitter = var1.readDouble();
         var3.pitchTemp = var1.readDouble();
         var3.pitchJitter = var1.readDouble();
         var3.jumpThreshold = var1.readDouble();
         var3.style = txp.read(var1);
         var3.net = txv.read(var1);
         var4 = var3;
      }

      return var4;
   }
}
