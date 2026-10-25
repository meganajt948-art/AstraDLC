package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

public final class snp {
   static final float snq = 16.0F;
   static final int snr = 20;
   static final float[] sns = new float[44];
   static final vdn[][] snt = new vdn[vek.values().length][sns.length];
   static final float snu = 1.3F;
   static final float snv = 11.0F;
   static final float snw = 11.0F;
   static final float snx = 0.7F;
   static final float sny = 0.95F;
   static final float snz = 0.55F;
   static final float soa = 0.024F;
   static final float sob = 0.045F;
   static final long soc = 4500L;
   static final long sod = 80L;
   static final float soe = (float) (Math.PI * 2);
   final smt[] sof;
   final long[] sog;
   final long[] soh;
   final float[] soi;
   final float[] soj;
   final float[] sok;
   final float[] sol;
   final float som;
   final float son;
   public final int line;
   public final boolean card;
   public final long holdUntil;
   public double x;
   public double y;
   public double z;
   public float yawOff;
   public float pitchOff;
   public float dist;
   public float age;
   public float hidden;
   float soo = -1.0F;
   float sop = -1.0F;
   float[] soq = new float[0];
   float[] sor = new float[0];
   float[] sos = new float[0];
   float[] sot = new float[0];
   float[] sou = new float[0];
   float[] sov = new float[0];
   float[] sow = new float[0];
   int[] sox = new int[0];
   final float[] soy;
   final float[] soz;

   snp(int var1, boolean var2, List<smw> var3, float var4, long var5, Random var7) {
      this.line = var1;
      this.card = var2;
      this.holdUntil = var5;
      ArrayList<List<smw>> var8 = new ArrayList<>();
      ArrayList<Float> var9 = new ArrayList<>();
      ArrayList<smw> var10 = new ArrayList<>();
      float var11 = 0.0F;

      for (smw var13 : var3) {
         float var14 = spf(var13.smx, var13.smy) * var13.smz;
         float var15 = spf(" ", var13.smy) * var13.smz;
         if (!var10.isEmpty() && (var13.snc || var11 + var15 + var14 > var4)) {
            var8.add(var10);
            var9.add(var11);
            var10 = new ArrayList();
            var11 = 0.0F;
         }

         var11 += (var10.isEmpty() ? 0.0F : var15) + var14;
         var10.add(var13);
      }

      if (!var10.isEmpty()) {
         var8.add(var10);
         var9.add(var11);
      }

      float[] var35 = new float[var8.size()];
      float var36 = 0.0F;

      for (int var37 = 0; var37 < var8.size(); var37++) {
         float var39 = 0.0F;

         for (smw var17 : (List)var8.get(var37)) {
            var39 = Math.max(var39, var17.smz);
         }

         var35[var37] = 1.3F * var39;
         var36 += var35[var37];
      }

      int var38 = var3.size();
      this.sog = new long[var38];
      this.soh = new long[var38];
      this.soi = new float[var38];
      this.soj = new float[var38];
      this.sok = new float[var38];
      this.sol = new float[var38];
      this.soy = new float[var38];
      this.soz = new float[var38];
      ArrayList<smt> var40 = new ArrayList<>();
      float var41 = -var36 * 0.5F;
      int var42 = 0;
      float var18 = Float.MAX_VALUE;
      float var19 = -Float.MAX_VALUE;

      for (int var20 = 0; var20 < var8.size(); var20++) {
         float var21 = var41 + var35[var20] * 0.5F;
         var41 += var35[var20];
         float var22 = -(Float)var9.get(var20) * 0.5F;
         boolean var23 = true;

         for (smw var25 : (List)var8.get(var20)) {
            if (!var23) {
               var22 += spf(" ", var25.smy) * var25.smz;
            }

            var23 = false;
            float var26 = var22;
            int var27 = var25.smx.codePointCount(0, var25.smx.length());
            long var28 = var27 <= 1 ? 0L : Math.min(45L, Math.max(0L, (var25.snb - var25.sna) / var27));
            int var30 = 0;

            for (int var31 = 0; var31 < var25.smx.length(); var30++) {
               int var32 = var25.smx.codePointAt(var31);
               var31 += Character.charCount(var32);
               String var33 = new String(Character.toChars(var32));
               float var34 = spf(var33, var25.smy) * var25.smz;
               if (!Character.isWhitespace(var32)) {
                  var40.add(
                     new smt(
                        var33,
                        var25.smy,
                        var25.smz,
                        var22 + var34 * 0.5F,
                        var21,
                        var42,
                        var25.sna == Long.MIN_VALUE ? Long.MIN_VALUE : var25.sna + var28 * var30,
                        var25.snd
                     )
                  );
               }

               var22 += var34;
            }

            this.sog[var42] = var25.sna;
            this.soh[var42] = var25.snb;
            this.soi[var42] = (var26 + var22) * 0.5F;
            this.soj[var42] = var21;
            this.sok[var42] = var22 - var26;
            this.sol[var42] = var25.smz;
            var18 = Math.min(var18, var26);
            var19 = Math.max(var19, var22);
            var42++;
         }
      }

      this.sof = var40.toArray(new smt[0]);
      this.som = var18 == Float.MAX_VALUE ? 0.0F : var18;
      this.son = var19 == -Float.MAX_VALUE ? 0.0F : var19;
      float var43 = Math.max(0.001F, this.son - this.som);

      for (smt var47 : this.sof) {
         var47.vx = (var7.nextFloat() * 2.0F - 1.0F) * 0.55F;
         var47.vy = -(0.35F + var7.nextFloat() * 0.8F);
         var47.vr = (var7.nextFloat() * 2.0F - 1.0F) * 0.9F;
         var47.delay = 0.55F * (0.75F * (var47.x - this.som) / var43 + 0.25F * var7.nextFloat());
         var47.phase = var7.nextFloat() * (float) (Math.PI * 2);
         var47.s1 = var7.nextFloat() * 2.0F - 1.0F;
         var47.s2 = var7.nextFloat() * 2.0F - 1.0F;
      }
   }

   public static snp line(int var0, skx var1, Random var2) {
      String[] var3 = var1.text().split(" ");
      long[] var4 = new long[var3.length];
      long[] var5 = new long[var3.length];
      long[] var6 = var1.words();
      long var7 = Math.max(300L, var1.end() - var1.start());
      if (var6 != null && var6.length == var3.length) {
         for (int var14 = 0; var14 < var3.length; var14++) {
            var4[var14] = var6[var14];
            var5[var14] = var14 + 1 < var3.length ? var6[var14 + 1] : Math.min(var1.end(), var6[var14] + 900L);
         }
      } else {
         int var9 = 0;

         for (String var13 : var3) {
            var9 += var13.length();
         }

         long var16 = Math.max(500L, Math.min((long)(var7 * 0.9), var9 * 80L));
         int var18 = 0;

         for (int var19 = 0; var19 < var3.length; var19++) {
            var4[var19] = var1.start() + var16 * var18 / Math.max(1, var9);
            var18 += var3[var19].length();
            var5[var19] = var1.start() + var16 * var18 / Math.max(1, var9);
         }
      }

      ArrayList var15 = new ArrayList(var3.length);

      for (int var17 = 0; var17 < var3.length; var17++) {
         var15.add(new smw(var3[var17], vek.SEMIBOLD, 1.0F, var4[var17], var5[var17], false, false));
      }

      return new snp(var0, false, var15, 11.0F, var5[var5.length - 1] + 4500L, var2);
   }

   public static snp card(String var0, String var1, Random var2) {
      ArrayList var3 = new ArrayList();

      for (String var7 : var0.split(" ")) {
         if (!var7.isEmpty()) {
            var3.add(new smw(var7, vek.BOLD, 1.35F, Long.MIN_VALUE, Long.MIN_VALUE, false, false));
         }
      }

      boolean var9 = true;

      for (String var8 : var1.split(" ")) {
         if (!var8.isEmpty()) {
            var3.add(new smw(var8, vek.MEDIUM, 0.62F, Long.MIN_VALUE, Long.MIN_VALUE, var9, true));
            var9 = false;
         }
      }

      return new snp(-1, true, var3, 11.0F, Long.MAX_VALUE, var2);
   }

   public boolean isEmpty() {
      return this.sof.length == 0;
   }

   public void dissolve() {
      if (!(this.soo >= 0.0F)) {
         this.soo = 0.0F;

         for (smt var4 : this.sof) {
            if (var4.born > this.age) {
               var4.born = -1.0F;
            }
         }
      }
   }

   public boolean dissolving() {
      return this.soo >= 0.0F;
   }

   public boolean finished() {
      return this.soo > 1.8824999F;
   }

   public void update(float var1, long var2) {
      this.age += var1;
      if (this.soo >= 0.0F) {
         this.soo += var1;
      } else {
         for (smt var7 : this.sof) {
            if (var7.born < 0.0F && (this.card || var2 >= var7.due)) {
               float var8 = Math.max(this.age, this.sop + (this.card ? 0.045F : 0.024F));
               var7.born = var8;
               this.sop = var8;
            }
         }

         float var10 = Math.min(1.0F, var1 * 9.0F);

         for (smt var14 : this.sof) {
            boolean var9 = !this.card && var2 >= this.sog[var14.word] && var2 < this.soh[var14.word] + 120L;
            var14.hl = var14.hl + ((var9 ? 1.0F : 0.0F) - var14.hl) * var10;
         }
      }
   }

   public void draw(DrawContext var1, float var2, float var3, float var4, sng var5, GpuTextureView var6) {
      float var7 = var5.alpha() * (1.0F - 0.85F * this.hidden);
      if (!(var7 <= 0.01F) && this.sof.length != 0) {
         int var8 = this.sof.length;
         if (this.soq.length < var8) {
            this.soq = new float[var8];
            this.sor = new float[var8];
            this.sos = new float[var8];
            this.sot = new float[var8];
            this.sou = new float[var8];
            this.sov = new float[var8];
            this.sow = new float[var8];
            this.sox = new int[var8];
         }

         Arrays.fill(this.soy, 0.0F);
         Arrays.fill(this.soz, 0.0F);
         float var9 = Math.max(0.001F, this.son - this.som);
         boolean var10 = false;

         for (int var11 = 0; var11 < var8; var11++) {
            smt var12 = this.sof[var11];
            if (!(var12.born < 0.0F) && !(this.age < var12.born)) {
               float var13 = vcq.clamp01((this.age - var12.born) / 0.7F);
               float var14 = this.soo < 0.0F ? 0.0F : vcq.clamp01((this.soo - var12.delay) / 0.95F);
               float var15 = 1.0F - var14;
               float var16 = vcq.outCubic(var13 * 1.5F) * var15 * var15;
               this.sou[var11] = var16;
               if (!(var16 <= 0.004F)) {
                  var10 = true;
                  float var17 = vcq.outCubic(var14);
                  float var18 = (1.0F - vcq.outBack(var13)) * 0.5F * var12.scale;
                  float var19 = (float)Math.sin(this.age * 1.6F + var12.phase) * 0.035F * var12.scale;
                  this.soq[var11] = var2 + (var12.x + var12.vx * var17 * 1.5F) * var4;
                  this.sor[var11] = var3 + (var12.y + var18 + var19 + var12.vy * var17 * 1.8F) * var4;
                  this.sos[var11] = (1.25F - 0.25F * vcq.outCubic(var13)) * (1.0F - 0.3F * var17) * (1.0F + 0.08F * var12.hl);
                  this.sot[var11] = var12.vr * var17;
                  this.sov[var11] = ((1.0F - vcq.outCubic(var13)) * 0.14F + var17 * 0.2F) * var12.scale;
                  this.sow[var11] = 1.0F - vcq.outCubic(var13 * 1.4F);
                  int var20 = ujt.lerp(var5.tone(), var5.tone2(), (var12.x - this.som) / var9);
                  int var21 = ujt.lerp(var20, -1, 0.55F);
                  int var22 = ujt.lerp(-1, var20, (var12.dim ? 0.3F : 0.14F) + 0.5F * var12.hl);
                  this.sox[var11] = ujt.lerp(var22, var21, this.sow[var11] * 0.85F);
                  float var23 = vcq.outCubic(var13 * 1.5F) * var15;
                  this.soy[var12.word] = Math.max(this.soy[var12.word], var23);
                  this.soz[var12.word] = Math.max(this.soz[var12.word], var12.hl);
               }
            } else {
               this.sou[var11] = 0.0F;
            }
         }

         if (var10) {
            if (var6 != null) {
               if (var5.shadow()) {
                  uut.additive(false);

                  for (int var24 = 0; var24 < this.soy.length; var24++) {
                     float var30 = this.soy[var24] * var7;
                     if (!(var30 <= 0.01F)) {
                        float var36 = this.sol[var24];
                        float var42 = this.sok[var24] * var4 + 1.8F * var4 * var36;
                        float var47 = 2.1F * var4 * var36;
                        float var51 = var2 + this.soi[var24] * var4;
                        float var55 = var3 + this.soj[var24] * var4;
                        uut.image(var1, var6, var51 - var42 * 0.5F, var55 - var47 * 0.5F, var42, var47, 0.0F, ujt.withAlpha(0, Math.round(72.0F * var30)));
                     }
                  }
               }

               if (var5.glow() > 0.01F) {
                  uut.additive(true);

                  for (int var25 = 0; var25 < this.soy.length; var25++) {
                     float var31 = this.soy[var25] * var7 * var5.glow();
                     if (!(var31 <= 0.01F)) {
                        float var37 = this.sol[var25];
                        float var43 = this.sok[var25] * var4 + 1.4F * var4 * var37;
                        float var48 = 1.75F * var4 * var37;
                        float var52 = var2 + this.soi[var25] * var4;
                        float var56 = var3 + this.soj[var25] * var4;
                        int var59 = ujt.lerp(var5.tone(), var5.tone2(), (this.soi[var25] - this.som) / var9);
                        uut.image(
                           var1,
                           var6,
                           var52 - var43 * 0.5F,
                           var56 - var48 * 0.5F,
                           var43,
                           var48,
                           0.0F,
                           ujt.withAlpha(var59, Math.round((40.0F + 70.0F * this.soz[var25]) * var31))
                        );
                     }
                  }

                  for (int var26 = 0; var26 < var8; var26++) {
                     float var32 = this.sow[var26] * this.sou[var26] * var7 * (0.35F + 0.65F * var5.glow());
                     if (!(var32 <= 0.01F)) {
                        float var38 = 2.4F * var4 * this.sof[var26].scale * this.sos[var26];
                        uut.sprite(var1, var6, this.soq[var26], this.sor[var26], var38, ujt.withAlpha(this.sox[var26], Math.round(150.0F * var32)));
                     }
                  }

                  uut.additive(false);
               }
            }

            if (var5.shadow()) {
               float var27 = 0.045F * var4;
               float var33 = 0.065F * var4;

               for (int var39 = 0; var39 < var8; var39++) {
                  float var44 = this.sou[var39] * var7;
                  if (!(var44 <= 0.01F)) {
                     spc(
                        var1,
                        this.sof[var39],
                        this.soq[var39] + var27 * this.sof[var39].scale,
                        this.sor[var39] + var33 * this.sof[var39].scale,
                        var4,
                        this.sos[var39],
                        this.sot[var39],
                        ujt.withAlpha(0, Math.round(90.0F * var44))
                     );
                  }
               }
            }

            for (int var28 = 0; var28 < var8; var28++) {
               float var34 = this.sou[var28] * var7;
               if (!(var34 <= 0.01F)) {
                  smt var40 = this.sof[var28];
                  float var45 = this.sov[var28] * var4;
                  float var49 = var34;
                  if (var45 > 0.35F) {
                     var49 = var34 * (1.0F - Math.min(0.55F, this.sov[var28] * 2.8F));
                     int var53 = ujt.withAlpha(this.sox[var28], Math.round(255.0F * var34 * 0.3F * (var40.dim ? 0.8F : 1.0F)));
                     float var57 = var45 * 0.7071F;
                     spc(var1, var40, this.soq[var28] - var57, this.sor[var28] - var57, var4, this.sos[var28], this.sot[var28], var53);
                     spc(var1, var40, this.soq[var28] + var57, this.sor[var28] - var57, var4, this.sos[var28], this.sot[var28], var53);
                     spc(var1, var40, this.soq[var28] - var57, this.sor[var28] + var57, var4, this.sos[var28], this.sot[var28], var53);
                     spc(var1, var40, this.soq[var28] + var57, this.sor[var28] + var57, var4, this.sos[var28], this.sot[var28], var53);
                  }

                  spc(
                     var1,
                     var40,
                     this.soq[var28],
                     this.sor[var28],
                     var4,
                     this.sos[var28],
                     this.sot[var28],
                     ujt.withAlpha(this.sox[var28], Math.round(255.0F * var49 * (var40.dim ? 0.8F : 1.0F)))
                  );
               }
            }

            if (var6 != null && var5.particles() && this.soo >= 0.0F) {
               uut.additive(true);

               for (int var29 = 0; var29 < var8; var29++) {
                  smt var35 = this.sof[var29];
                  if (!(var35.born < 0.0F)) {
                     float var41 = vcq.clamp01((this.soo - var35.delay) / 1.2825F);
                     if (!(var41 <= 0.0F) && !(var41 >= 1.0F)) {
                        float var46 = vcq.outCubic(var41);
                        float var50 = (float)Math.sin(Math.PI * var41) * var7;
                        int var54 = ujt.lerp(var5.tone(), var5.tone2(), (var35.x - this.som) / var9);
                        int var58 = ujt.lerp(var54, -1, 0.65F);

                        for (int var60 = 0; var60 < 2; var60++) {
                           float var61 = var60 == 0 ? var35.s1 : var35.s2;
                           float var62 = var2
                              + (var35.x + (var35.vx + var61 * 0.7F) * var46 * 2.2F) * var4
                              + (float)Math.sin(this.soo * 5.0F + var35.phase + var60) * 0.08F * var4;
                           float var63 = var3 + (var35.y + var35.vy * (1.4F + 0.5F * var60) * var46 * 2.2F) * var4;
                           float var64 = Math.max(1.2F, var4 * 0.14F * var35.scale * (1.0F - 0.5F * var41));
                           uut.sprite(var1, var6, var62, var63, var64 * 4.0F, ujt.withAlpha(var54, Math.round(80.0F * var50)));
                           uut.sprite(var1, var6, var62, var63, var64, ujt.withAlpha(var58, Math.round(230.0F * var50)));
                        }
                     }
                  }
               }

               uut.additive(false);
            }
         }
      }
   }

   static void spc(DrawContext var0, smt var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      if (var7 >>> 24 != 0) {
         float var8 = var4 * var1.scale;
         int var9 = spd(var8);
         vdn var10 = spe(var1.weight, var9);
         float var11 = var8 * var5 / (16.0F * sns[var9]);
         Matrix3x2fStack var12 = var0.getMatrices();
         var12.pushMatrix();
         var12.translate(var2, var3);
         if (var6 != 0.0F) {
            var12.rotate(var6);
         }

         var12.scale(var11, var11);
         var10.draw(var0, var1.ch, -var10.width(var1.ch) * 0.5F, var10.centerTop(0.0F), var7);
         var12.popMatrix();
      }
   }

   static int spd(float var0) {
      int var1 = Math.round((float)(Math.log(Math.max(0.01F, var0) / 16.0F) / Math.log(2.0) * 8.0)) + 20;
      return Math.max(0, Math.min(sns.length - 1, var1));
   }

   static vdn spe(vek var0, int var1) {
      vdn var2 = snt[var0.ordinal()][var1];
      if (var2 == null) {
         var2 = veo.get(var0, 16.0F * sns[var1]);
         snt[var0.ordinal()][var1] = var2;
      }

      return var2;
   }

   static float spf(String var0, vek var1) {
      return spe(var1, 20).width(var0) / 16.0F;
   }

   static {
      for (int var0 = 0; var0 < sns.length; var0++) {
         sns[var0] = (float)Math.pow(2.0, (var0 - 20) / 8.0);
      }

      sns[20] = 1.0F;
   }
}
