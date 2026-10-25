package a;

import flow.dev.a;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.attribute.EntityAttributes;

public final class tyd {
   private static final int tye = 1200;
   private static final long tyf = 180000L;
   private static final int tyg = 10;
   public final tiq profile;
   public final String module;
   private final String tyh;
   private final tzs tyi = new tzs();
   private final Map<Long, Integer> tyj = new HashMap<>();
   private boolean tyk;
   private boolean tyl = true;
   private ClientWorld tym;
   private int tyn = -1000;
   private int tyo;
   private int typ;
   private int tyq;
   private int tyr = -1;
   private int tys;
   private int tyt;
   private double tyu;
   private int tyv;
   private int tyw;
   private boolean tyx;
   private boolean tyy;
   private long tyz = System.currentTimeMillis();
   private boolean tza;
   private double tzb;
   private double tzc;
   public int recorded;
   public double meters;
   public int routes;
   public int jumps;
   public boolean paused = true;
   public String pauseReason = "";

   public tyd(tiq var1, String var2, float var3) {
      this.profile = var1;
      this.module = var2;
      this.tyh = var1.newTapeName();
      this.tyi.created = System.currentTimeMillis();
      this.tyi.unit = var3;
      this.tyi.module = a.c(-13034048, "ᶋ搎\ueedc炶ﭙ緞잞乹퀧媝").equals(var2) ? 2 : 1;
   }

   public int seconds() {
      return this.recorded / 20;
   }

   public double[] unsaved() {
      return new double[]{this.recorded - this.tyt, this.meters - this.tyu, this.routes - this.tyv, this.jumps - this.tyw};
   }

   public void pause(String var1) {
      this.paused = true;
      this.pauseReason = var1;
      this.tyl = true;
   }

   public void tick(MinecraftClient var1) {
      ClientPlayerEntity var2 = var1.field_1724;
      ClientWorld var3 = var1.field_1687;
      if (var2 != null && var3 != null) {
         if (var3 != this.tym) {
            this.tym = var3;
            this.tyl = true;
            this.tyr = -1;
         }

         psf var4 = pnf.route();
         if (!pnf.guiding()) {
            this.pause(a.b("㔿䲌왔場폺啂", 90584404));
         } else if (pnf.working()) {
            this.pause(a.b("瓢\u0d50螃᧩", -1160874870));
         } else if (var4 != null && var4.track.n >= 2) {
            if (!this.tyk) {
               this.tyk = true;
               this.tyi.ox = (int)Math.floor(var2.method_23317());
               this.tyi.oy = (int)Math.floor(var2.method_23318());
               this.tyi.oz = (int)Math.floor(var2.method_23321());
            }

            this.paused = false;
            this.pauseReason = "";
            Integer var5 = this.tyj.get(var4.id);
            if (var5 == null) {
               var5 = this.tyi.lanes.size();
               this.tyi.lanes.add(this.tzf(var4));
               this.tyj.put(var4.id, var5);
               this.routes++;
            }

            int var6 = this.tyi.ticks.size();
            int var7 = (int)Math.floor(var2.method_23317());
            int var8 = (int)Math.floor(var2.method_23318() + 0.001);
            int var9 = (int)Math.floor(var2.method_23321());
            if (this.tyr < 0 || var7 != this.tyo || var8 != this.typ || var9 != this.tyq || var6 - this.tyn >= 10) {
               tzg var10 = txf.snap(var3, var7, var8, var9);
               tzj var11 = new tzj();
               var11.x0 = var10.x0 - this.tyi.ox;
               var11.y0 = var10.y0 - this.tyi.oy;
               var11.z0 = var10.z0 - this.tyi.oz;
               var11.packed = tzs.pack(var10.cells);
               this.tyi.snaps.add(var11);
               this.tyr = this.tyi.snaps.size() - 1;
               this.tyo = var7;
               this.typ = var8;
               this.tyq = var9;
               this.tyn = var6;
            }

            GameOptions var16 = var1.field_1690;
            boolean var17 = vzz.isPhysicallyDown(var1, var16.field_1903);
            int var12 = (vzz.isPhysicallyDown(var1, var16.field_1894) ? 1 : 0)
               | (vzz.isPhysicallyDown(var1, var16.field_1881) ? 2 : 0)
               | (vzz.isPhysicallyDown(var1, var16.field_1913) ? 4 : 0)
               | (vzz.isPhysicallyDown(var1, var16.field_1849) ? 8 : 0)
               | (var17 ? 16 : 0)
               | (var2.method_5624() ? 32 : 0)
               | (var2.method_5715() ? 64 : 0);
            tzp var13 = new tzp();
            var13.flags = 1
               | (var2.method_24828() ? 2 : 0)
               | (this.tyl ? 4 : 0)
               | (var2.method_5624() ? 8 : 0)
               | (var2.method_5715() ? 16 : 0)
               | (var2.method_5799() ? 32 : 0)
               | (var2.method_6101() ? 64 : 0)
               | (var2.field_5976 ? 128 : 0);
            var13.keys = var12;
            var13.yaw = var2.method_36454();
            var13.pitch = var2.method_36455();
            var13.x = (float)(var2.method_23317() - this.tyi.ox);
            var13.y = (float)(var2.method_23318() - this.tyi.oy);
            var13.z = (float)(var2.method_23321() - this.tyi.oz);
            var13.vx = (float)(var2.method_23317() - var2.field_6014);
            var13.vy = (float)(var2.method_23318() - var2.field_6036);
            var13.vz = (float)(var2.method_23321() - var2.field_5969);
            double var14 = var2.method_45325(EntityAttributes.field_23719);
            var13.speed = (float)(var2.method_5624() ? var14 / 1.3 : var14);
            var13.food = Math.max(0, Math.min(255, var2.method_7344().method_7586()));
            var13.route = var5;
            var13.snap = this.tyr;
            if (!this.tyl) {
               this.meters = this.meters + Math.hypot(var2.method_23317() - this.tzb, var2.method_23321() - this.tzc);
               if (var17 && !this.tza) {
                  this.jumps++;
               }
            }

            this.tzb = var2.method_23317();
            this.tzc = var2.method_23321();
            this.tza = var17;
            this.tyl = false;
            this.tyi.ticks.add(var13);
            this.recorded++;
            if (var6 + 1 - this.tys >= 1200) {
               this.save();
            }
         } else {
            this.pause(a.c(571089828, "⏓婿킶仆씀"));
         }
      } else {
         this.pause(a.c(-506266187, "\ufdd5葥າ郆"));
      }
   }

   private tzm tzf(psf var1) {
      tvt var2 = var1.track;
      tzm var3 = new tzm();
      int var4 = var2.n;
      var3.x = new float[var4];
      var3.y = new float[var4];
      var3.z = new float[var4];
      var3.flag = new byte[var4];

      for (int var5 = 0; var5 < var4; var5++) {
         var3.x[var5] = var2.x[var5] - this.tyi.ox;
         var3.y[var5] = var2.y[var5] - this.tyi.oy;
         var3.z[var5] = var2.z[var5] - this.tyi.oz;
         var3.flag[var5] = var2.flag[var5];
      }

      var3.goal = (byte)(var1.direct ? 1 : 0);
      return var3;
   }

   public void save() {
      int var1 = this.tyi.ticks.size();
      if (var1 > this.tys || this.tyy) {
         this.profile.add(a.d("獶\u0ad1耏ṹ闫ጀꥎ₵뻢㑋", -510440161, -586072556), this.recorded - this.tyt);
         this.profile.add(a.b("뷢쑅些탭孿\udd8d柖\uee36灸\ufade紌", -1721451106), Math.round(this.meters - this.tyu));
         this.profile.add(a.b("璑ശ蟨ᦞ鈌ᓡ꺯❄뤚㎺둿", 152401133), this.routes - this.tyv);
         this.profile.add(a.c(-931175578, "挛᪼遢ด薆ͳ뤿ブ꺔␦"), this.jumps - this.tyw);
         this.tyt = this.recorded;
         this.tyu = Math.round(this.meters);
         this.tyv = this.routes;
         this.tyw = this.jumps;
         this.tys = var1;
         this.profile.save();
         tzs var2 = this.tyi.frozen();
         this.profile.putWalkTape(this.tyh, var2);
         long var3 = System.currentTimeMillis();
         if (this.tyy || var3 - this.tyz > 180000L) {
            this.tyy = false;
            this.tyz = var3;
            this.profile.uploadWalkTape(this.tyh, var2);
         }
      }
   }

   public void finish() {
      if (this.recorded > 0 && !this.tyx) {
         this.tyx = true;
         this.profile.add(a.d("疝\u0c3a蛿ᢎ鍃ᗴ꾦♊", 831628901, -107949181), 1L);
      }

      this.tyy = this.recorded > 0;
      this.save();
   }
}
