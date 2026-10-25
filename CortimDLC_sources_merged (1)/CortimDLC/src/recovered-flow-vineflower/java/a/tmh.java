package a;

import flow.dev.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class tmh {
   public static final int MAGIC = 1177702979;
   public static final int VERSION = 1;
   public static final int VALID = 1;
   public static final int GROUND = 2;
   public static final int BREAK = 4;
   public static final int SOURCE_STANDS = 0;
   public static final int SOURCE_FIGHTS = 1;
   public static final int SOURCE_MINE = 2;
   public long created;
   public float unit;
   public double originX;
   public double originY;
   public double originZ;
   public int source;
   public final List<tme> ticks = new ArrayList<>();

   public byte[] bytes() throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(65536);

      try (DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1, 65536), 65536))) {
         var2.writeInt(1177702979);
         var2.writeInt(1);
         var2.writeLong(this.created);
         var2.writeFloat(this.unit);
         var2.writeDouble(this.originX);
         var2.writeDouble(this.originY);
         var2.writeDouble(this.originZ);
         var2.writeInt(this.source);
         var2.writeInt(this.ticks.size());

         for (tme var4 : this.ticks) {
            var2.writeByte(var4.flags);
            var2.writeFloat(var4.yaw);
            var2.writeFloat(var4.pitch);
            var2.writeFloat(var4.eyeX);
            var2.writeFloat(var4.eyeY);
            var2.writeFloat(var4.eyeZ);
            var2.writeFloat(var4.cooldown);
            var2.writeByte(Math.min(var4.presses, 127));
            var2.writeInt(var4.hitId);
            if (var4.hitId != 0) {
               var2.writeFloat(var4.hitU);
               var2.writeFloat(var4.hitV);
            }

            int var5 = Math.min(var4.ids.length, 255);
            var2.writeByte(var5);

            for (int var6 = 0; var6 < var5; var6++) {
               var2.writeInt(var4.ids[var6]);

               for (int var7 = 0; var7 < 5; var7++) {
                  var2.writeFloat(var4.boxes[var6 * 5 + var7]);
               }
            }
         }
      }

      return var1.toByteArray();
   }

   public static tmh read(InputStream var0) throws IOException {
      try (DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0, 65536), 65536))) {
         if (var1.readInt() != 1177702979) {
            throw new IOException(a.d("\uf7b3踃Ӌ髮ᅸ鞈ⶉꑯ㨶낋㝅촢䏸\uda4e倔", 873623202, -96036496));
         }

         int var2 = var1.readInt();
         if (var2 != 1) {
            throw new IOException(a.d("\ude3eꞘⵍ댰㣺빝Ѓ践Ꭳ饕Ố\ue4b2橲\uf3c2禋ｼ䔲쪭", 581465585, 2006952879) + var2);
         }

         tmh var3 = new tmh();
         var3.created = var1.readLong();
         var3.unit = var1.readFloat();
         var3.originX = var1.readDouble();
         var3.originY = var1.readDouble();
         var3.originZ = var1.readDouble();
         var3.source = var1.readInt();
         int var4 = var1.readInt();

         for (int var5 = 0; var5 < var4; var5++) {
            tme var6 = new tme();
            var6.flags = var1.readUnsignedByte();
            var6.yaw = var1.readFloat();
            var6.pitch = var1.readFloat();
            var6.eyeX = var1.readFloat();
            var6.eyeY = var1.readFloat();
            var6.eyeZ = var1.readFloat();
            var6.cooldown = var1.readFloat();
            var6.presses = var1.readUnsignedByte();
            var6.hitId = var1.readInt();
            if (var6.hitId != 0) {
               var6.hitU = var1.readFloat();
               var6.hitV = var1.readFloat();
            }

            int var7 = var1.readUnsignedByte();
            var6.ids = new int[var7];
            var6.boxes = new float[var7 * 5];

            for (int var8 = 0; var8 < var7; var8++) {
               var6.ids[var8] = var1.readInt();

               for (int var9 = 0; var9 < 5; var9++) {
                  var6.boxes[var8 * 5 + var9] = var1.readFloat();
               }
            }

            var3.ticks.add(var6);
         }

         return var3;
      }
   }
}
