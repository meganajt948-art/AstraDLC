package a;

import flow.dev.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class ttb {
   public static final int MAGIC = 1177701710;
   public static final int VERSION = 2;
   public tck hand;
   public tqa brain;
   public trj legs;
   public tvq style = new tvq();
   public long created;
   public double top1;
   public double top3;
   public double base1;
   public double nll;
   public int events;
   public int valEvents;
   public double legsAcc;
   public double legsBase;
   public double legsJump;
   public double legsSprint;
   public int legsSamples;
   public int boost;

   public byte[] bytes() throws IOException {
      byte[] var1 = this.hand.bytes();
      ByteArrayOutputStream var2 = new ByteArrayOutputStream(65536);

      try (DataOutputStream var3 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var2, 65536), 65536))) {
         var3.writeInt(1177701710);
         var3.writeInt(2);
         var3.writeLong(this.created);
         var3.writeDouble(this.top1);
         var3.writeDouble(this.top3);
         var3.writeDouble(this.base1);
         var3.writeDouble(this.nll);
         var3.writeInt(this.events);
         var3.writeInt(this.valEvents);
         var3.writeDouble(this.legsAcc);
         var3.writeDouble(this.legsBase);
         var3.writeDouble(this.legsJump);
         var3.writeDouble(this.legsSprint);
         var3.writeInt(this.legsSamples);
         var3.writeInt(this.boost);
         this.style.write(var3);
         this.brain.write(var3);
         var3.writeBoolean(this.legs != null);
         if (this.legs != null) {
            this.legs.write(var3);
         }

         var3.writeInt(var1.length);
         var3.write(var1);
      }

      return var2.toByteArray();
   }

   public static ttb read(InputStream var0) throws IOException {
      try (DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0, 65536), 65536))) {
         if (var1.readInt() != 1177701710) {
            throw new IOException(a.d("묠슐䡘홽巫\udb1b愅\ue8f0皨ﰒ箄膸\u0f6d雗ᲅ驽", 2105038156, 981528082));
         }

         int var2 = var1.readInt();
         if (var2 != 2) {
            throw new IOException(a.d("ࡼ燎ﬕ攠\ueeba栉퉑审엷伊좏㋭밭▝꿔⤣鍭ᳲ", -844173843, 1687938540) + var2);
         }

         ttb var3 = new ttb();
         var3.created = var1.readLong();
         var3.top1 = var1.readDouble();
         var3.top3 = var1.readDouble();
         var3.base1 = var1.readDouble();
         var3.nll = var1.readDouble();
         var3.events = var1.readInt();
         var3.valEvents = var1.readInt();
         var3.legsAcc = var1.readDouble();
         var3.legsBase = var1.readDouble();
         var3.legsJump = var1.readDouble();
         var3.legsSprint = var1.readDouble();
         var3.legsSamples = var1.readInt();
         var3.boost = var1.readInt();
         var3.style = tvq.read(var1);
         var3.brain = tqa.read(var1);
         if (var1.readBoolean()) {
            var3.legs = trj.read(var1);
         }

         int var4 = var1.readInt();
         if (var4 <= 0 || var4 > 8000000) {
            throw new IOException(a.c(446779379, "侙㘫볽⋈\ua957\u2fef閳᱈"));
         }

         byte[] var5 = new byte[var4];
         var1.readFully(var5);
         var3.hand = tck.read(new ByteArrayInputStream(var5));
         return var3;
      }
   }
}
