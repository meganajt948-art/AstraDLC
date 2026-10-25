package flow.splash;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.zip.InflaterInputStream;
import net.minecraft.client.texture.NativeImage;

final class Signature {
   final float size;
   final int width;
   final int height;
   final float x0;
   final float x1;
   final float base;
   final float length;
   final float scale;
   final int segs;
   final float[] ax;
   final float[] ay;
   final float[] bx;
   final float[] by;
   final float[] s0;
   final float[] s1;
   final float[] dropS;
   final float[] dropX;
   final float[] dropY;
   final float[] dropR;
   final float[] sampleX;
   final float[] sampleY;
   final float[] sampleK;
   final float streamS;
   final float streamMin;
   final float streamMax;
   final float[] streamPath;
   private int[] texels;
   private GpuTexture texture;
   private GpuTextureView view;

   private Signature(
      float size,
      int width,
      int height,
      float x0,
      float x1,
      float base,
      float[][] strokes,
      int[] dropStroke,
      float[] dropX,
      float[] dropY,
      float[] dropR,
      byte[] alpha
   ) {
      this.size = size;
      this.width = width;
      this.height = height;
      this.x0 = x0;
      this.x1 = x1;
      this.base = base;
      this.dropX = dropX;
      this.dropY = dropY;
      this.dropR = dropR;
      this.dropS = new float[dropStroke.length];
      int cap = 0;

      for (float[] st : strokes) {
         cap += Math.max(1, st.length / 3);
      }

      float[] sax = new float[cap];
      float[] say = new float[cap];
      float[] sbx = new float[cap];
      float[] sby = new float[cap];
      float[] sw = new float[cap];
      float[] ss0 = new float[cap];
      float[] ss1 = new float[cap];
      float[] startS = new float[strokes.length];
      int n = 0;
      float total = 0.0F;
      float px = 0.0F;
      float py = 0.0F;
      boolean first = true;

      for (int i = 0; i < strokes.length; i++) {
         float[] st = strokes[i];
         int k = st.length / 3;
         if (k != 0) {
            if (!first) {
               total += Math.min((float)Math.hypot(st[0] - px, st[1] - py), size * 0.5F) * 0.3F;
            }

            first = false;
            startS[i] = total;

            for (int d = 0; d < dropStroke.length; d++) {
               if (dropStroke[d] == i) {
                  this.dropS[d] = total;
               }
            }

            if (k == 1) {
               float r = st[2];
               sax[n] = st[0];
               say[n] = st[1];
               sbx[n] = st[0] + 0.01F;
               sby[n] = st[1];
               sw[n] = r * 2.3F + 3.0F;
               ss0[n] = total;
               ss1[n] = total + r * 2.0F;
               total += r * 2.0F;
               n++;
            }

            for (int j = 1; j < k; j++) {
               float ax0 = st[(j - 1) * 3];
               float ay0 = st[(j - 1) * 3 + 1];
               float bx0 = st[j * 3];
               float by0 = st[j * 3 + 1];
               float len = (float)Math.hypot(bx0 - ax0, by0 - ay0);
               if (!(len < 0.001F)) {
                  sax[n] = ax0;
                  say[n] = ay0;
                  sbx[n] = bx0;
                  sby[n] = by0;
                  sw[n] = (st[(j - 1) * 3 + 2] + st[j * 3 + 2]) * 1.15F + 3.0F;
                  ss0[n] = total;
                  ss1[n] = total + len;
                  total += len;
                  n++;
               }
            }

            px = st[(k - 1) * 3];
            py = st[(k - 1) * 3 + 1];
         }
      }

      this.segs = n;
      this.ax = Arrays.copyOf(sax, n);
      this.ay = Arrays.copyOf(say, n);
      this.bx = Arrays.copyOf(sbx, n);
      this.by = Arrays.copyOf(sby, n);
      this.s0 = Arrays.copyOf(ss0, n);
      this.s1 = Arrays.copyOf(ss1, n);
      this.length = total;
      this.scale = total + size;
      this.texels = this.bake(alpha, Arrays.copyOf(sw, n));
      int stream = dropStroke.length > 1 ? dropStroke[1] - 1 : -1;
      if (stream >= 0 && stream < strokes.length && strokes[stream].length >= 6) {
         float lo = Float.MAX_VALUE;
         float hi = -Float.MAX_VALUE;

         for (int i = stream; i < strokes.length; i++) {
            for (int j = 0; j < strokes[i].length; j += 3) {
               lo = Math.min(lo, strokes[i][j]);
               hi = Math.max(hi, strokes[i][j]);
            }
         }

         float[] st = strokes[stream];
         float[] path = new float[st.length / 3 * 2];
         int j = 0;

         for (int k = 0; j < st.length; k += 2) {
            path[k] = st[j];
            path[k + 1] = st[j + 1];
            j += 3;
         }

         this.streamS = startS[stream];
         this.streamMin = lo;
         this.streamMax = hi;
         this.streamPath = path;
      } else {
         this.streamS = Float.MAX_VALUE;
         this.streamMin = x0;
         this.streamMax = x1;
         this.streamPath = null;
      }

      Random random = new Random(11L);
      int fg = 0;

      for (byte b : alpha) {
         if ((b & 255) > 140) {
            fg++;
         }
      }

      int[] inside = new int[fg];
      fg = 0;

      for (int i = 0; i < alpha.length; i++) {
         if ((alpha[i] & 255) > 140) {
            inside[fg++] = i;
         }
      }

      int count = Math.min(2400, fg);
      float[][] picks = new float[count][];

      for (int i = 0; i < count; i++) {
         int at = inside[random.nextInt(fg)];
         float x = at % width + random.nextFloat();
         float y = at / width + random.nextFloat();
         picks[i] = new float[]{x, y, x + (noise(x / size * 3.0F, y / size * 3.0F) - 0.5F) * size * 0.5F};
      }

      Arrays.sort(picks, (a, b) -> Float.compare(a[2], b[2]));
      this.sampleX = new float[count];
      this.sampleY = new float[count];
      this.sampleK = new float[count];

      for (int i = 0; i < count; i++) {
         this.sampleX[i] = picks[i][0];
         this.sampleY[i] = picks[i][1];
         this.sampleK[i] = picks[i][2];
      }
   }

   private int[] bake(byte[] alpha, float[] widths) {
      float[] reach = new float[this.width * this.height];
      Arrays.fill(reach, Float.MAX_VALUE);

      for (int i = 0; i < this.segs; i++) {
         float r = widths[i] * 0.5F;
         float dx = this.bx[i] - this.ax[i];
         float dy = this.by[i] - this.ay[i];
         float ll = dx * dx + dy * dy;
         int minX = Math.max(0, (int)Math.floor(Math.min(this.ax[i], this.bx[i]) - r));
         int maxX = Math.min(this.width - 1, (int)Math.ceil(Math.max(this.ax[i], this.bx[i]) + r));
         int minY = Math.max(0, (int)Math.floor(Math.min(this.ay[i], this.by[i]) - r));
         int maxY = Math.min(this.height - 1, (int)Math.ceil(Math.max(this.ay[i], this.by[i]) + r));
         float rr = r * r;

         for (int y = minY; y <= maxY; y++) {
            float cy = y + 0.5F;
            int row = y * this.width;

            for (int x = minX; x <= maxX; x++) {
               float cx = x + 0.5F;
               float t = ll > 0.0F ? ((cx - this.ax[i]) * dx + (cy - this.ay[i]) * dy) / ll : 0.0F;
               t = t < 0.0F ? 0.0F : Math.min(t, 1.0F);
               float qx = this.ax[i] + dx * t - cx;
               float qy = this.ay[i] + dy * t - cy;
               if (!(qx * qx + qy * qy > rr)) {
                  float s = this.s0[i] + (this.s1[i] - this.s0[i]) * t;
                  if (s < reach[row + x]) {
                     reach[row + x] = s;
                  }
               }
            }
         }
      }

      int[] out = new int[this.width * this.height];

      for (int i = 0; i < out.length; i++) {
         float s = reach[i] == Float.MAX_VALUE ? this.length : reach[i];
         int code = Math.max(0, Math.min(65535, Math.round(s / this.scale * 65535.0F)));
         out[i] = 0xFF000000 | (alpha[i] & 255) << 16 | code >> 8 << 8 | code & 0xFF;
      }

      return out;
   }

   static Signature load() throws IOException {
      try (InputStream raw = Signature.class.getResourceAsStream("/flow/intro/sig.bin")) {
         if (raw == null) {
            throw new IOException("missing");
         }

         DataInputStream in = new DataInputStream(new BufferedInputStream(new InflaterInputStream(raw), 65536));
         if (in.readInt() != 1179862833) {
            throw new IOException("bad data");
         }

         float size = in.readFloat();
         int width = in.readInt();
         int height = in.readInt();
         float x0 = in.readFloat();
         float x1 = in.readFloat();
         float base = in.readFloat();
         float[][] strokes = new float[in.readInt()][];

         for (int i = 0; i < strokes.length; i++) {
            strokes[i] = new float[in.readInt() * 3];

            for (int j = 0; j < strokes[i].length; j++) {
               strokes[i][j] = in.readFloat();
            }
         }

         int drops = in.readInt();
         int[] dropStroke = new int[drops];
         float[] dx = new float[drops];
         float[] dy = new float[drops];
         float[] dr = new float[drops];

         for (int i = 0; i < drops; i++) {
            dropStroke[i] = in.readInt();
            dx[i] = in.readFloat();
            dy[i] = in.readFloat();
            dr[i] = in.readFloat();
         }

         byte[] alpha = new byte[in.readInt()];
         if (alpha.length != width * height) {
            throw new IOException("bad size");
         }

         in.readFully(alpha);
         return new Signature(size, width, height, x0, x1, base, strokes, dropStroke, dx, dy, dr, alpha);
      }
   }

   GpuTextureView view() {
      if (this.view == null && this.texels != null) {
         GpuDevice device = RenderSystem.getDevice();
         this.texture = device.createTexture(() -> "Flow2 signature", 5, TextureFormat.RGBA8, this.width, this.height, 1, 1);

         try (NativeImage image = new NativeImage(this.width, this.height, false)) {
            for (int y = 0; y < this.height; y++) {
               int row = y * this.width;

               for (int x = 0; x < this.width; x++) {
                  image.setColorArgb(x, y, this.texels[row + x]);
               }
            }

            device.createCommandEncoder().writeToTexture(this.texture, image);
         }

         this.view = device.createTextureView(this.texture);
         this.texels = null;
      }

      return this.view;
   }

   float u(float x) {
      return (x - this.x0) / (this.x1 - this.x0);
   }

   int seg(float s) {
      if (this.segs != 0 && !(s < this.s0[0])) {
         int lo = 0;
         int hi = this.segs - 1;

         while (lo < hi) {
            int mid = lo + hi + 1 >>> 1;
            if (this.s0[mid] <= s) {
               lo = mid;
            } else {
               hi = mid - 1;
            }
         }

         return lo;
      } else {
         return -1;
      }
   }

   boolean tip(float s, float[] out) {
      int j = this.seg(s);
      int i = Math.max(0, j);
      float dx = this.bx[i] - this.ax[i];
      float dy = this.by[i] - this.ay[i];
      float dl = (float)Math.hypot(dx, dy);
      if (dl < 1.0E-6F) {
         dl = 1.0F;
      }

      out[2] = dx / dl;
      out[3] = dy / dl;
      if (j < 0) {
         out[0] = this.ax[0];
         out[1] = this.ay[0];
         return false;
      } else if (s <= this.s1[j]) {
         float k = (s - this.s0[j]) / Math.max(1.0E-6F, this.s1[j] - this.s0[j]);
         out[0] = this.ax[j] + dx * k;
         out[1] = this.ay[j] + dy * k;
         return true;
      } else if (j + 1 >= this.segs) {
         out[0] = this.bx[j];
         out[1] = this.by[j];
         return false;
      } else {
         float k = (s - this.s1[j]) / Math.max(1.0E-6F, this.s0[j + 1] - this.s1[j]);
         out[0] = this.bx[j] + (this.ax[j + 1] - this.bx[j]) * k;
         out[1] = this.by[j] + (this.ay[j + 1] - this.by[j]) * k;
         return false;
      }
   }

   boolean streamPoint(float x, float[] out) {
      if (this.streamPath == null) {
         return false;
      }

      float best = Float.MAX_VALUE;

      for (int k = 0; k < this.streamPath.length; k += 2) {
         float d = Math.abs(this.streamPath[k] - x) - this.streamPath[k + 1] * 0.001F;
         if (d < best) {
            best = d;
            out[0] = this.streamPath[k];
            out[1] = this.streamPath[k + 1];
         }
      }

      out[2] = 1.0F;
      out[3] = 0.0F;
      return true;
   }

   void close() {
      if (this.view != null) {
         this.view.close();
         this.view = null;
      }

      if (this.texture != null) {
         this.texture.close();
         this.texture = null;
      }
   }

   static float noise(float x, float y) {
      int ix = (int)Math.floor(x);
      int iy = (int)Math.floor(y);
      float fx = x - ix;
      float fy = y - iy;
      float ux = fx * fx * (3.0F - 2.0F * fx);
      float uy = fy * fy * (3.0F - 2.0F * fy);
      float a = hash(ix, iy);
      float b = hash(ix + 1, iy);
      float c = hash(ix, iy + 1);
      float d = hash(ix + 1, iy + 1);
      return a + (b - a) * ux + (c - a) * uy + (a - b - c + d) * ux * uy;
   }

   private static float hash(int x, int y) {
      int h = x * 374761393 + y * 668265263;
      h = (h ^ h >>> 13) * 1274126177;
      h ^= h >>> 16;
      return (h & 16777215) / 1.6777215E7F;
   }
}
