package flow.splash;

import a.uut;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Random;
import net.minecraft.client.gui.DrawContext;

public final class Snow {
   static final int FAR = 0;
   static final int MID = 1;
   static final int NEAR = 2;
   static final int CRYSTAL = 3;
   private static final int[] COUNTS = new int[]{170, 80, 14, 9};
   private final int n;
   private final int[] kind;
   private final float[] x0;
   private final float[] y0;
   private final float[] speed;
   private final float[] size;
   private final float[] swayA;
   private final float[] swayF;
   private final float[] phase;
   private final float[] alpha;
   private final float[] depth;
   private final float[] spin;

   public Snow(long seed) {
      int total = 0;

      for (int c : COUNTS) {
         total += c;
      }

      this.n = total;
      this.kind = new int[this.n];
      this.x0 = new float[this.n];
      this.y0 = new float[this.n];
      this.speed = new float[this.n];
      this.size = new float[this.n];
      this.swayA = new float[this.n];
      this.swayF = new float[this.n];
      this.phase = new float[this.n];
      this.alpha = new float[this.n];
      this.depth = new float[this.n];
      this.spin = new float[this.n];
      Random r = new Random(seed);
      int i = 0;

      for (int k = 0; k < COUNTS.length; k++) {
         for (int c = 0; c < COUNTS[k]; i++) {
            this.kind[i] = k;
            this.x0[i] = r.nextFloat();
            this.y0[i] = r.nextFloat();
            this.phase[i] = r.nextFloat() * 6.2832F;
            this.swayF[i] = 0.35F + r.nextFloat() * 0.9F;
            this.spin[i] = (r.nextBoolean() ? 1.0F : -1.0F) * (0.25F + r.nextFloat() * 0.6F);
            switch (k) {
               case 0:
                  this.depth[i] = 0.25F + r.nextFloat() * 0.2F;
                  this.size[i] = 0.35F + r.nextFloat() * 0.45F;
                  this.speed[i] = 9.0F + r.nextFloat() * 8.0F;
                  this.swayA[i] = 2.0F + r.nextFloat() * 4.0F;
                  this.alpha[i] = 0.35F + r.nextFloat() * 0.4F;
                  break;
               case 1:
                  this.depth[i] = 0.5F + r.nextFloat() * 0.25F;
                  this.size[i] = 1.6F + r.nextFloat() * 1.8F;
                  this.speed[i] = 17.0F + r.nextFloat() * 12.0F;
                  this.swayA[i] = 4.0F + r.nextFloat() * 7.0F;
                  this.alpha[i] = 0.55F + r.nextFloat() * 0.35F;
                  break;
               case 2:
                  this.depth[i] = 1.1F + r.nextFloat() * 0.5F;
                  this.size[i] = 9.0F + r.nextFloat() * 13.0F;
                  this.speed[i] = 38.0F + r.nextFloat() * 22.0F;
                  this.swayA[i] = 8.0F + r.nextFloat() * 10.0F;
                  this.alpha[i] = 0.12F + r.nextFloat() * 0.14F;
                  break;
               default:
                  this.depth[i] = 0.8F + r.nextFloat() * 0.35F;
                  this.size[i] = 2.6F + r.nextFloat() * 2.4F;
                  this.speed[i] = 16.0F + r.nextFloat() * 10.0F;
                  this.swayA[i] = 6.0F + r.nextFloat() * 8.0F;
                  this.alpha[i] = 0.7F + r.nextFloat() * 0.25F;
            }

            c++;
         }
      }
   }

   public void draw(DrawContext ctx, GpuTextureView glow, float vw, float vh, float t, boolean front, float px, float py) {
      float wind = 7.0F * (float)Math.sin(t * 0.31F) + 3.5F * (float)Math.sin(t * 0.83F + 1.3F);
      uut.beginBatch();

      try {
         for (int i = 0; i < this.n; i++) {
            int k = this.kind[i];
            if (k >= 2 == front) {
               float margin = k == 2 ? 30.0F : 8.0F;
               float spanY = vh + margin * 2.0F;
               float spanX = vw + margin * 2.0F;
               float fall = this.y0[i] * spanY + t * this.speed[i];
               float y = fall % spanY - margin;
               float drift = this.depth[i] * (t * 6.0F + wind) + this.swayA[i] * (float)Math.sin(t * this.swayF[i] + this.phase[i]);
               float x = ((this.x0[i] * spanX + drift) % spanX + spanX) % spanX - margin;
               x -= px * this.depth[i] * 10.0F;
               y -= py * this.depth[i] * 6.0F;
               float a = this.alpha[i];
               switch (k) {
                  case 0:
                     uut.circle(ctx, x, y, this.size[i], color(a));
                     break;
                  case 1:
                     float tw = 0.78F + 0.22F * (float)Math.sin(t * 2.6F + this.phase[i] * 3.0F);
                     if (glow != null) {
                        uut.sprite(ctx, glow, x, y, this.size[i] * 2.6F, color(a * tw * 0.9F));
                     }

                     uut.circle(ctx, x, y, this.size[i] * 0.42F, color(a * tw));
                     break;
                  case 2:
                     if (glow != null) {
                        uut.sprite(ctx, glow, x, y, this.size[i], color(a));
                     } else {
                        uut.circle(ctx, x, y, this.size[i] * 0.3F, color(a * 0.6F));
                     }
                     break;
                  default:
                     float rot = this.phase[i] + t * this.spin[i];
                     if (glow != null) {
                        uut.sprite(ctx, glow, x, y, this.size[i] * 3.4F, color(a * 0.32F));
                     }

                     crystal(ctx, x, y, this.size[i], rot, color(a));
               }
            }
         }
      } finally {
         uut.endBatch();
      }
   }

   public static void crystal(DrawContext ctx, float cx, float cy, float r, float rot, int color) {
      float w = Math.max(0.32F, r * 0.15F);

      for (int arm = 0; arm < 6; arm++) {
         float ang = rot + arm * 1.0472F;
         float c = (float)Math.cos(ang);
         float s = (float)Math.sin(ang);
         uut.line(ctx, cx, cy, cx + c * r, cy + s * r, w, color);
         if (!(r < 2.0F)) {
            for (int side = -1; side <= 1; side += 2) {
               float bx = cx + c * r * 0.55F;
               float by = cy + s * r * 0.55F;
               float ba = ang + side * 0.85F;
               float len = r * 0.34F;
               uut.line(ctx, bx, by, bx + (float)Math.cos(ba) * len, by + (float)Math.sin(ba) * len, w * 0.85F, color);
            }
         }
      }

      uut.circle(ctx, cx, cy, w * 0.9F, color);
   }

   private static int color(float a) {
      int al = Math.max(0, Math.min(255, Math.round(a * 255.0F)));
      return al << 24 | 16055039;
   }
}
