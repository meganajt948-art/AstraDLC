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

public final class tvc {
   public static final int VALID = 1;
   public static final int GROUND = 2;
   public static final int BREAK = 4;
   public static final int SPRINT = 8;
   public static final int SNEAK = 16;
   public static final int MOVE = 32;
   public static final int ATTACK = 64;
   public static final int K_FWD = 1;
   public static final int K_BACK = 2;
   public static final int K_LEFT = 4;
   public static final int K_RIGHT = 8;
   public static final int K_JUMP = 16;
   public static final int K_SPRINT = 32;
   public static final int K_SNEAK = 64;
   public long created;
   public float unit;
   public int ox;
   public int oy;
   public int oz;
   public final List<tuz> ticks = new ArrayList<>();
   public final List<tuw> hits = new ArrayList<>();
   public final List<tut> decisions = new ArrayList<>();
   public static final int MAGIC = 1177701716;
   public static final int VERSION = 1;

   public tvc frozen() {
      tvc var1 = new tvc();
      var1.created = this.created;
      var1.unit = this.unit;
      var1.ox = this.ox;
      var1.oy = this.oy;
      var1.oz = this.oz;
      var1.ticks.addAll(this.ticks);
      var1.hits.addAll(this.hits);
      var1.decisions.addAll(this.decisions);
      return var1;
   }

   public int validTicks() {
      int var1 = 0;

      for (tuz var3 : this.ticks) {
         if ((var3.flags & 1) != 0) {
            var1++;
         }
      }

      return var1;
   }

   public byte[] bytes() throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(1048576);

      try (DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1, 65536), 65536))) {
         var2.writeInt(1177701716);
         var2.writeInt(1);
         var2.writeLong(this.created);
         var2.writeFloat(this.unit);
         var2.writeInt(this.ox);
         var2.writeInt(this.oy);
         var2.writeInt(this.oz);
         var2.writeInt(this.ticks.size());

         for (tuz var4 : this.ticks) {
            var2.writeShort(var4.flags);
            var2.writeByte(var4.keys);
            var2.writeFloat(var4.yaw);
            var2.writeFloat(var4.pitch);
            var2.writeFloat(var4.x);
            var2.writeFloat(var4.y);
            var2.writeFloat(var4.z);
            var2.writeFloat(var4.vx);
            var2.writeFloat(var4.vy);
            var2.writeFloat(var4.vz);
            var2.writeInt(var4.feetY);
            var2.writeShort(var4.farm);
            var2.writeByte(var4.dia);
            var2.writeInt(var4.sx);
            var2.writeInt(var4.sy);
            var2.writeInt(var4.sz);
            var2.writeInt(var4.snap == null ? -1 : var4.snap.length);
            if (var4.snap != null) {
               var2.write(var4.snap);
            }
         }

         var2.writeInt(this.hits.size());

         for (tuw var10 : this.hits) {
            var2.writeInt(var10.tick);
            var2.writeInt(var10.x);
            var2.writeInt(var10.y);
            var2.writeInt(var10.z);
            var2.writeByte(var10.face);
            var2.writeFloat(var10.px);
            var2.writeFloat(var10.py);
            var2.writeFloat(var10.pz);
            var2.writeByte(var10.cell);
         }

         var2.writeInt(this.decisions.size());

         for (tut var11 : this.decisions) {
            var2.writeInt(var11.tick);
            var2.writeInt(var11.hit);
            tra var5 = var11.ctx;
            var2.writeFloat((float)var5.ex);
            var2.writeFloat((float)var5.ey);
            var2.writeFloat((float)var5.ez);
            var2.writeFloat(var5.yaw);
            var2.writeFloat(var5.pitch);
            var2.writeFloat(var5.vyaw);
            var2.writeFloat(var5.vpitch);
            var2.writeFloat((float)var5.vx);
            var2.writeFloat((float)var5.vz);
            var2.writeBoolean(var5.ground);
            var2.writeInt(var5.feetY);
            var2.writeBoolean(var5.hasPrev);
            var2.writeInt(var5.px);
            var2.writeInt(var5.py);
            var2.writeInt(var5.pz);
         }
      }

      return var1.toByteArray();
   }

   public static tvc read(InputStream var0) throws IOException {
      tvc var16;
      try (DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0, 65536), 65536))) {
         if (var1.readInt() != 1177701716) {
            throw new IOException(a.b("⨞厮\ud966䝃쳕䨥\uf03b秎\ue796洬\ueaba႙鹙߮趱ଢ଼넄㻘ꑬ∴", 1681402468));
         }

         if (var1.readInt() != 1) {
            throw new IOException(a.c(35811232, "濛᙮鲺ˀ襒ྱ뗵㰂ꉑ⣽꼸啄\udb94䈬져亟\uf4c3笅\ue1b7柼\uee0d鑝"));
         }

         tvc var2 = new tvc();
         var2.created = var1.readLong();
         var2.unit = var1.readFloat();
         var2.ox = var1.readInt();
         var2.oy = var1.readInt();
         var2.oz = var1.readInt();
         int var3 = var1.readInt();
         if (var3 < 0 || var3 > 2000000) {
            throw new IOException(a.d("䱲㗀뼖℣ꪠⰌ陕ᾬ臫", -1769213630, 292666715));
         }

         for (int var4 = 0; var4 < var3; var4++) {
            tuz var5 = new tuz();
            var5.flags = var1.readUnsignedShort();
            var5.keys = var1.readUnsignedByte();
            var5.yaw = var1.readFloat();
            var5.pitch = var1.readFloat();
            var5.x = var1.readFloat();
            var5.y = var1.readFloat();
            var5.z = var1.readFloat();
            var5.vx = var1.readFloat();
            var5.vy = var1.readFloat();
            var5.vz = var1.readFloat();
            var5.feetY = var1.readInt();
            var5.farm = var1.readShort();
            var5.dia = var1.readByte();
            var5.sx = var1.readInt();
            var5.sy = var1.readInt();
            var5.sz = var1.readInt();
            int var6 = var1.readInt();
            if (var6 > 4950) {
               throw new IOException(a.b("䴧㒕빃⁶꯲ⵞ霂Ợ肾ਔ跀瞪", 1733774665));
            }

            if (var6 >= 0) {
               var5.snap = new byte[var6];
               var1.readFully(var5.snap);
            }

            var2.ticks.add(var5);
         }

         int var11 = var1.readInt();
         if (var11 < 0 || var11 > 2000000) {
            throw new IOException(a.c(250687950, "ㆤ䠖싀峵흪凚\ueb94扢"));
         }

         for (int var12 = 0; var12 < var11; var12++) {
            tuw var14 = new tuw();
            var14.tick = var1.readInt();
            var14.x = var1.readInt();
            var14.y = var1.readInt();
            var14.z = var1.readInt();
            var14.face = var1.readByte();
            var14.px = var1.readFloat();
            var14.py = var1.readFloat();
            var14.pz = var1.readFloat();
            var14.cell = var1.readByte();
            var2.hits.add(var14);
         }

         int var13 = var1.readInt();
         if (var13 < 0 || var13 > 2000000) {
            throw new IOException(a.c(1223220966, "\ude89ꜻⷭ돘㡋뻻Ү赕ጐ馻Ṯ\ue41e櫔"));
         }

         for (int var15 = 0; var15 < var13; var15++) {
            tut var7 = new tut();
            var7.tick = var1.readInt();
            var7.hit = var1.readInt();
            tra var8 = new tra();
            var8.ex = var1.readFloat();
            var8.ey = var1.readFloat();
            var8.ez = var1.readFloat();
            var8.yaw = var1.readFloat();
            var8.pitch = var1.readFloat();
            var8.vyaw = var1.readFloat();
            var8.vpitch = var1.readFloat();
            var8.vx = var1.readFloat();
            var8.vz = var1.readFloat();
            var8.ground = var1.readBoolean();
            var8.feetY = var1.readInt();
            var8.hasPrev = var1.readBoolean();
            var8.px = var1.readInt();
            var8.py = var1.readInt();
            var8.pz = var1.readInt();
            var7.ctx = var8;
            if (var7.tick >= 0 && var7.tick < var3 && var7.hit >= 0 && var7.hit < var11) {
               var2.decisions.add(var7);
            }
         }

         var16 = var2;
      }

      return var16;
   }

   public tvn snap(int var1) {
      tuz var2 = this.ticks.get(var1);
      return var2.snap == null ? null : new tvn(var2.sx, var2.sy, var2.sz, unpack(var2.snap));
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
         byte[] var2 = new byte[2475];
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
         var3 = new byte[2475];
      } finally {
         var1.end();
      }

      return var3;
   }
}
