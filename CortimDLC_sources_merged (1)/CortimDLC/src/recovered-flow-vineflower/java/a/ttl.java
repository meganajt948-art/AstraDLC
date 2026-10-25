package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public final class ttl {
   private static final int ttm = 1200;
   private static final long ttn = 180000L;
   private static final int tto = 12;
   private static final int ttp = 40;
   private static final int ttq = 200;
   private static final double ttr = 24.0;
   public final tiq profile;
   private final String tts;
   private final tvc ttt = new tvc();
   private final List<tte> ttu = new ArrayList<>();
   private final int[] ttv = new int[2];
   private boolean ttw;
   private boolean ttx = true;
   private int tty;
   private ClientWorld ttz;
   private pzc tua;
   private int tub = -200;
   private tvn tuc;
   private int tud;
   private int tue;
   private int tuf;
   private int tug;
   private int tuh;
   private int tui;
   private boolean tuj;
   private boolean tuk;
   private long tul = System.currentTimeMillis();
   public int blocks;
   public int decisions;
   public int diamonds;
   public int farmed;
   public int recorded;
   public boolean paused = true;
   public String pauseReason = "";

   public ttl(tiq var1, float var2) {
      this.profile = var1;
      this.tts = var1.newTapeName();
      this.ttt.created = System.currentTimeMillis();
      this.ttt.unit = var2;
   }

   public boolean mineFound() {
      return this.tua != null;
   }

   public int seconds() {
      return this.recorded / 20;
   }

   public int[] unsaved() {
      return new int[]{this.blocks - this.tue, this.decisions - this.tuf, this.recorded - this.tug, this.diamonds - this.tuh, this.farmed - this.tui};
   }

   public void attack(MinecraftClient var1, BlockPos var2, Direction var3) {
      ClientPlayerEntity var4 = var1.field_1724;
      if (var4 != null && var1.field_1687 != null) {
         BlockState var5 = var1.field_1687.method_8320(var2);
         byte var6 = tsh.kind(var1.field_1687, var2, var5);
         if (tpx.minable(var6)) {
            if (this.tua != null && !this.tua.contains(var2)) {
               var6 = 4;
            }

            this.ttu.add(new tte(var2.method_10062(), var3, tuo(var1, var4, var2, var3), var6));
         }
      }
   }

   public void broken(BlockState var1) {
      if (!this.paused && tsh.diamond(var1)) {
         this.diamonds++;
      }
   }

   private static Vec3d tuo(MinecraftClient var0, ClientPlayerEntity var1, BlockPos var2, Direction var3) {
      HitResult var4 = var0.field_1765;
      if (var4 instanceof BlockHitResult var5 && var4.method_17783() == Type.field_1332 && var5.method_17777().equals(var2)) {
         return var5.method_17784();
      } else {
         Vec3d var7 = var1.method_33571();
         Optional var6 = new Box(var2).method_992(var7, var7.method_1019(var1.method_5828(1.0F).method_1021(6.0)));
         return var6.isPresent()
            ? (Vec3d)var6.get()
            : Vec3d.method_24953(var2).method_1031(var3.method_10148() * 0.5, var3.method_10164() * 0.5, var3.method_10165() * 0.5);
      }
   }

   public void pause(String var1) {
      this.paused = true;
      this.pauseReason = var1;
      this.ttx = true;
      this.tuc = null;
      this.ttu.clear();
   }

   public void tick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      ClientWorld var3 = var1.field_1687;
      if (var2 != null && var3 != null) {
         if (var3 != this.ttz) {
            this.ttz = var3;
            this.tua = null;
            this.tub = -200;
            this.ttx = true;
            this.tuc = null;
         }

         Vec3d var4 = var2.method_33571();
         if (!this.ttw) {
            this.ttw = true;
            this.ttt.ox = (int)Math.floor(var4.field_1352);
            this.ttt.oy = (int)Math.floor(var4.field_1351);
            this.ttt.oz = (int)Math.floor(var4.field_1350);
         }

         this.paused = false;
         this.pauseReason = "";
         int var5 = this.ttt.ticks.size();
         this.tup(var1, var2, var5);
         GameOptions var6 = var1.field_1690;
         int var7 = (var6.field_1894.method_1434() ? 1 : 0)
            | (var6.field_1881.method_1434() ? 2 : 0)
            | (var6.field_1913.method_1434() ? 4 : 0)
            | (var6.field_1849.method_1434() ? 8 : 0)
            | (var6.field_1903.method_1434() ? 16 : 0)
            | (var2.method_5624() ? 32 : 0)
            | (var6.field_1832.method_1434() ? 64 : 0);
         tuz var8 = new tuz();
         var8.flags = 1
            | (var2.method_24828() ? 2 : 0)
            | (this.ttx ? 4 : 0)
            | (var2.method_5624() ? 8 : 0)
            | (var2.method_5715() ? 16 : 0)
            | ((var7 & 31) != 0 ? 32 : 0)
            | (var6.field_1886.method_1434() ? 64 : 0);
         var8.keys = var7;
         if (this.ttx) {
            this.tty = var5;
            this.ttx = false;
            this.tuc = null;
         }

         var8.yaw = var2.method_36454();
         var8.pitch = var2.method_36455();
         var8.x = (float)(var4.field_1352 - this.ttt.ox);
         var8.y = (float)(var4.field_1351 - this.ttt.oy);
         var8.z = (float)(var4.field_1350 - this.ttt.oz);
         var8.vx = (float)(var2.method_23317() - var2.field_6014);
         var8.vy = (float)(var2.method_23318() - var2.field_6036);
         var8.vz = (float)(var2.method_23321() - var2.field_5969);
         var8.feetY = tsh.standing(var3, var2).method_10264() - this.ttt.oy;
         tvn var9 = tsh.snap(var3, var2, var2.method_24515(), this.tua, null, null);
         trd.diff(this.tuc, var9, var4.field_1352, var4.field_1351, var4.field_1350, this.ttv);
         var8.farm = (short)Math.min(32767, this.ttv[0]);
         var8.dia = (byte)Math.min(127, this.ttv[1]);
         this.farmed = this.farmed + this.ttv[0];
         this.tuc = var9;
         var8.sx = var9.x0 - this.ttt.ox;
         var8.sy = var9.y0 - this.ttt.oy;
         var8.sz = var9.z0 - this.ttt.oz;
         var8.snap = tvc.pack(var9.cells);
         this.ttt.ticks.add(var8);

         for (tte var11 : this.ttu) {
            this.tuq(var11, var5);
         }

         this.ttu.clear();
         this.recorded++;
         if (var5 + 1 - this.tud >= 1200) {
            this.save();
         }
      } else {
         this.pause(a.b("鮞\ue22e棹\uf68d", -937255938));
      }
   }

   private void tup(MinecraftClient var1, ClientPlayerEntity var2, int var3) {
      Vec3d var4 = var2.method_73189();
      if (this.tua != null) {
         if (this.tua.distanceTo(var4) <= 24.0) {
            return;
         }

         this.tua = null;
         this.tuc = null;
      }

      if (var3 - this.tub >= 200) {
         this.tub = var3;
         pzp var5 = pzw.read(var1, 72.0);
         pzc var6 = pzc.detect(this.ttz, var5 != null ? var5.pos() : var4);
         if (var6 != null && var6.distanceTo(var4) <= 24.0) {
            this.tua = var6;
            this.tuc = null;
         }
      }
   }

   private void tuq(tte var1, int var2) {
      tuw var3 = new tuw();
      var3.tick = var2;
      var3.x = var1.pos().method_10263() - this.ttt.ox;
      var3.y = var1.pos().method_10264() - this.ttt.oy;
      var3.z = var1.pos().method_10260() - this.ttt.oz;
      var3.face = (byte)var1.side().ordinal();
      var3.px = (float)(var1.point().field_1352 - this.ttt.ox);
      var3.py = (float)(var1.point().field_1351 - this.ttt.oy);
      var3.pz = (float)(var1.point().field_1350 - this.ttt.oz);
      var3.cell = var1.cell();
      int var4 = this.ttt.hits.size();
      tuw var5 = var4 > 0 ? this.ttt.hits.get(var4 - 1) : null;
      this.ttt.hits.add(var3);
      this.blocks++;
      int var6 = Math.max(this.tty, var2 - 12);
      if (var5 != null && var5.tick >= this.tty) {
         var6 = Math.max(var6, var5.tick);
      }

      if (var6 < var2) {
         int var7 = this.tur(var3, var2, var6);
         tuz var8 = this.ttt.ticks.get(var7);
         if (var8.snap != null) {
            tra var9 = new tra();
            var9.ex = var8.x;
            var9.ey = var8.y;
            var9.ez = var8.z;
            var9.yaw = var8.yaw;
            var9.pitch = var8.pitch;
            if (var7 - 2 >= this.tty) {
               tuz var10 = this.ttt.ticks.get(var7 - 2);
               var9.vyaw = (float)(tbp.wrap(var8.yaw - var10.yaw) * 0.5);
               var9.vpitch = (var8.pitch - var10.pitch) * 0.5F;
            } else if (var7 - 1 >= this.tty) {
               tuz var11 = this.ttt.ticks.get(var7 - 1);
               var9.vyaw = (float)tbp.wrap(var8.yaw - var11.yaw);
               var9.vpitch = var8.pitch - var11.pitch;
            }

            var9.vx = var8.vx;
            var9.vz = var8.vz;
            var9.ground = (var8.flags & 2) != 0;
            var9.feetY = var8.feetY;
            if (var5 != null && var2 - var5.tick <= 40 && var5.tick <= var7 && var5.tick >= this.tty) {
               var9.hasPrev = true;
               var9.px = var5.x;
               var9.py = var5.y;
               var9.pz = var5.z;
            }

            tut var12 = new tut();
            var12.tick = var7;
            var12.hit = var4;
            var12.ctx = var9;
            this.ttt.decisions.add(var12);
            this.decisions++;
         }
      }
   }

   private int tur(tuw var1, int var2, int var3) {
      double var4 = tus(this.ttt.ticks.get(var2), var1);

      for (int var6 = var2 - 1; var6 >= var3; var6--) {
         double var7 = tus(this.ttt.ticks.get(var6), var1);
         if (var7 <= var4 + 0.3) {
            return var6;
         }

         var4 = var7;
      }

      return var3;
   }

   private static double tus(tuz var0, tuw var1) {
      double var2 = var1.px - var0.x;
      double var4 = var1.py - var0.y;
      double var6 = var1.pz - var0.z;
      double var8 = tbp.wrap(tbp.yawTo(var2, var6) - var0.yaw);
      double var10 = tbp.pitchTo(var4, Math.sqrt(var2 * var2 + var6 * var6)) - var0.pitch;
      return Math.hypot(var8, var10);
   }

   public void save() {
      int var1 = this.ttt.ticks.size();
      if (var1 > this.tud || this.blocks != this.tue || this.tuk) {
         this.profile.add(a.b("\uf712躧ѳ騉ᆕ靨ⴵ\ua4c7㪔뀭㟦", -185337996), this.blocks - this.tue);
         this.profile.add(a.d("ﾴ蘁ೕ銯ᤳ鿈▚걭㈸뢓㽚씭䯻퉗", 1925126449, 887023334), this.decisions - this.tuf);
         this.profile.add(a.c(846058615, "퐐궥❱뤋㊗둼า蟉ᦞ錷"), this.recorded - this.tug);
         this.profile.add(a.d("\udbadꈘ⣌뚶㴪믑Ə衶ᘥ鲖᭄\ue13f濿", -625798739, 303811168), this.diamonds - this.tuh);
         this.profile.add(a.b("ᦱ怄\uead0璪Ｖ秏쎛䩹퐹庀\ud952", 1519196631), this.farmed - this.tui);
         this.tue = this.blocks;
         this.tuf = this.decisions;
         this.tug = this.recorded;
         this.tuh = this.diamonds;
         this.tui = this.farmed;
         this.tud = var1;
         this.profile.save();
         tvc var2 = this.ttt.frozen();
         this.profile.putMineTape(this.tts, var2);
         long var3 = System.currentTimeMillis();
         if (this.tuk || var3 - this.tul > 180000L) {
            this.tuk = false;
            this.tul = var3;
            this.profile.uploadMineTape(this.tts, var2);
         }
      }
   }

   public void finish() {
      if (this.recorded > 0 && !this.tuj) {
         this.tuj = true;
         this.profile.add(a.c(-810234074, "콝뛺㰿ꉎ⦃꼴ᕦ鲊"), 1L);
      }

      this.tuk = this.recorded > 0;
      this.save();
   }
}
