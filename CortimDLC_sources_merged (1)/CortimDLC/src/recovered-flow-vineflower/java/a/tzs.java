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
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public final class tzs {
   public static final int VALID = 1;
   public static final int GROUND = 2;
   public static final int BREAK = 4;
   public static final int SPRINT = 8;
   public static final int SNEAK = 16;
   public static final int WATER = 32;
   public static final int CLIMB = 64;
   public static final int COLLIDE = 128;
   public static final int WORK = 256;
   public static final int K_FWD = 1;
   public static final int K_BACK = 2;
   public static final int K_LEFT = 4;
   public static final int K_RIGHT = 8;
   public static final int K_JUMP = 16;
   public static final int K_SPRINT = 32;
   public static final int K_SNEAK = 64;
   public static final int MAGIC = 1177704276;
   public static final int VERSION = 1;
   public long created;
   public float unit;
   public int ox;
   public int oy;
   public int oz;
   public int module;
   public final List<tzp> ticks = new ArrayList<>();
   public final List<tzm> lanes = new ArrayList<>();
   public final List<tzj> snaps = new ArrayList<>();

   public tzs frozen() {
      tzs var1 = new tzs();
      var1.created = this.created;
      var1.unit = this.unit;
      var1.ox = this.ox;
      var1.oy = this.oy;
      var1.oz = this.oz;
      var1.module = this.module;
      var1.ticks.addAll(this.ticks);
      var1.lanes.addAll(this.lanes);
      var1.snaps.addAll(this.snaps);
      return var1;
   }

   public int validTicks() {
      int var1 = 0;

      for (tzp var3 : this.ticks) {
         if ((var3.flags & 1) != 0 && (var3.flags & 256) == 0 && var3.route >= 0) {
            var1++;
         }
      }

      return var1;
   }

   public tzg snap(int var1) {
      if (var1 >= 0 && var1 < this.snaps.size()) {
         tzj var2 = this.snaps.get(var1);
         return new tzg(var2.x0, var2.y0, var2.z0, unpack(var2.packed));
      } else {
         return null;
      }
   }

   public byte[] bytes() throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(262144);

      try (DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1, 65536), 65536))) {
         var2.writeInt(1177704276);
         var2.writeInt(1);
         var2.writeLong(this.created);
         var2.writeFloat(this.unit);
         var2.writeInt(this.ox);
         var2.writeInt(this.oy);
         var2.writeInt(this.oz);
         var2.writeInt(this.module);
         var2.writeInt(this.lanes.size());

         for (tzm var4 : this.lanes) {
            var2.writeByte(var4.goal);
            var2.writeInt(var4.x.length);

            for (int var5 = 0; var5 < var4.x.length; var5++) {
               var2.writeFloat(var4.x[var5]);
               var2.writeFloat(var4.y[var5]);
               var2.writeFloat(var4.z[var5]);
               var2.writeByte(var4.flag[var5]);
            }
         }

         var2.writeInt(this.snaps.size());

         for (tzj var10 : this.snaps) {
            var2.writeInt(var10.x0);
            var2.writeInt(var10.y0);
            var2.writeInt(var10.z0);
            var2.writeInt(var10.packed.length);
            var2.write(var10.packed);
         }

         var2.writeInt(this.ticks.size());

         for (tzp var11 : this.ticks) {
            var2.writeShort(var11.flags);
            var2.writeByte(var11.keys);
            var2.writeFloat(var11.yaw);
            var2.writeFloat(var11.pitch);
            var2.writeFloat(var11.x);
            var2.writeFloat(var11.y);
            var2.writeFloat(var11.z);
            var2.writeFloat(var11.vx);
            var2.writeFloat(var11.vy);
            var2.writeFloat(var11.vz);
            var2.writeFloat(var11.speed);
            var2.writeByte(var11.food);
            var2.writeInt(var11.route);
            var2.writeInt(var11.snap);
         }
      }

      return var1.toByteArray();
   }

   public static tzs read(InputStream var0) throws IOException {
      tzs var15;
      try (DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0, 65536), 65536))) {
         if (var1.readInt() != 1177704276) {
            throw new IOException(a.b("栙ᆩ魡Մ軒ࠢ눦㯁ꖓ⼥ꢽ办\udc5e䗩쾶䥚\uf303糟\ue66b怳", 1706125411));
         }

         if (var1.readInt() != 1) {
            throw new IOException(a.d("玺ਝ胃ẵ锩Ꮚꦎ⁹븪㒆덃䤿쟯幗푃勤\ue8b8松\ufdcc箇\uf276蠦", 1233421286, -1549340611));
         }

         tzs var2 = new tzs();
         var2.created = var1.readLong();
         var2.unit = var1.readFloat();
         var2.ox = var1.readInt();
         var2.oy = var1.readInt();
         var2.oz = var1.readInt();
         var2.module = var1.readInt();
         int var3 = var1.readInt();
         if (var3 < 0 || var3 > 500000) {
            throw new IOException(a.c(1899889150, "ƕ砧\uf2f1泄\ue75f懣\udbbf剅찌"));
         }

         for (int var4 = 0; var4 < var3; var4++) {
            tzm var5 = new tzm();
            var5.goal = var1.readByte();
            int var6 = var1.readInt();
            if (var6 < 0 || var6 > 100000) {
               throw new IOException(a.b("䥾ヌ먚\u242f꾴⤈鍔\u1aae", -2056566508));
            }

            var5.x = new float[var6];
            var5.y = new float[var6];
            var5.z = new float[var6];
            var5.flag = new byte[var6];

            for (int var7 = 0; var7 < var6; var7++) {
               var5.x[var7] = var1.readFloat();
               var5.y[var7] = var1.readFloat();
               var5.z[var7] = var1.readFloat();
               var5.flag[var7] = var1.readByte();
            }

            var2.lanes.add(var5);
         }

         int var10 = var1.readInt();
         if (var10 < 0 || var10 > 2000000) {
            throw new IOException(a.d("\uf4f0赂ޔ馡ሥ钉⻕ꜵ㥩", 1985625102, -15677291));
         }

         for (int var11 = 0; var11 < var10; var11++) {
            tzj var13 = new tzj();
            var13.x0 = var1.readInt();
            var13.y0 = var1.readInt();
            var13.z0 = var1.readInt();
            int var16 = var1.readInt();
            if (var16 < 0 || var16 > 2366) {
               throw new IOException(a.c(642007241, "䂣㤑돇⃚ⷲꙶ骆፦"));
            }

            var13.packed = new byte[var16];
            var1.readFully(var13.packed);
            var2.snaps.add(var13);
         }

         int var12 = var1.readInt();
         if (var12 < 0 || var12 > 4000000) {
            throw new IOException(a.d("\uec59闫Ἵ脈ઋ谧㙾뾇⇀", -1092893306, 1182738868));
         }

         for (int var14 = 0; var14 < var12; var14++) {
            tzp var17 = new tzp();
            var17.flags = var1.readUnsignedShort();
            var17.keys = var1.readUnsignedByte();
            var17.yaw = var1.readFloat();
            var17.pitch = var1.readFloat();
            var17.x = var1.readFloat();
            var17.y = var1.readFloat();
            var17.z = var1.readFloat();
            var17.vx = var1.readFloat();
            var17.vy = var1.readFloat();
            var17.vz = var1.readFloat();
            var17.speed = var1.readFloat();
            var17.food = var1.readUnsignedByte();
            var17.route = var1.readInt();
            var17.snap = var1.readInt();
            if (var17.route >= var3) {
               var17.route = -1;
            }

            if (var17.snap >= var10) {
               var17.snap = -1;
            }

            var2.ticks.add(var17);
         }

         var15 = var2;
      }

      return var15;
   }

   public static byte[] pack(byte[] var0) {
      Deflater var1 = new Deflater(1, true);

      byte[] var4;
      try {
         var1.setInput(var0);
         var1.finish();
         byte[] var2 = new byte[var0.length + 64];

         int var3;
         for (var3 = 0; !var1.finished(); var3 += var1.deflate(var2, var3, var2.length - var3)) {
            if (var3 == var2.length) {
               var2 = Arrays.copyOf(var2, var2.length * 2);
            }
         }

         var4 = Arrays.copyOf(var2, var3);
      } finally {
         var1.end();
      }

      return var4;
   }

   public static byte[] unpack(byte[] var0) {
      Inflater var1 = new Inflater(true);

      byte[] var3;
      try {
         var1.setInput(var0);
         byte[] var2 = new byte[1183];
         int var10 = 0;

         while (var10 < var2.length && !var1.finished()) {
            int var4 = var1.inflate(var2, var10, var2.length - var10);
            if (var4 == 0 && (var1.needsInput() || var1.needsDictionary())) {
               break;
            }

            var10 += var4;
         }

         return var2;
      } catch (DataFormatException var8) {
         var3 = new byte[1183];
      } finally {
         var1.end();
      }

      return var3;
   }

   public static int move(int var0) {
      boolean var1 = (var0 & 1) != 0 && (var0 & 2) == 0;
      boolean var2 = (var0 & 2) != 0 && (var0 & 1) == 0;
      boolean var3 = (var0 & 4) != 0 && (var0 & 8) == 0;
      boolean var4 = (var0 & 8) != 0 && (var0 & 4) == 0;
      if (var1) {
         return var3 ? 2 : (var4 ? 3 : 1);
      } else if (var2) {
         return var3 ? 7 : (var4 ? 8 : 6);
      } else {
         return var3 ? 4 : (var4 ? 5 : 0);
      }
   }
}
