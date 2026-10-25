package flow.cosmetic;

import a.wap;
import java.util.Map;
import net.minecraft.util.Identifier;

public final class CosmeticItem {
   public static final String[] SLOTS = new String[]{"avatar", "wings", "pet", "hat", "face", "back", "cape"};
   public static final String[] PARTS = new String[]{"head", "body", "right_arm", "left_arm", "right_leg", "left_leg"};
   public final String id;
   public final String name;
   public final String nameEn;
   public final String description;
   public final String descriptionEn;
   public final String slot;
   public final String attach;
   public final int accent;
   public final int frames;
   public final float frameTime;
   public final float[] anchor;
   public final float glowPeriod;
   public final float glowMin;
   public final float glowMax;
   final CosmeticItem.Bone[] bones;
   final Map<String, CosmeticItem.Clip> clips;
   final CosmeticItem.Emitter[] emitters;
   final String albedoPath;
   final String emissivePath;
   float[][] partPivots;
   float[][] hands;
   float[] stride;
   float[] headFit;
   float[] backFit;
   float petFoot = Float.NaN;
   String video;
   float[] videoRect;
   VideoTexture videoTexture;
   Identifier videoId;
   Identifier albedo;
   Identifier emissive;
   boolean loaded;
   boolean failed;
   static final int ROLE_NONE = 0;
   static final int ROLE_WING = 1;
   static final int ROLE_CHAIN = 2;
   static final int ROLE_EAR = 3;
   static final int ROLE_HEAD = 4;
   static final int ROLE_BLINK = 5;
   static final int ROLE_SKIRT = 6;
   static final int ROLE_JIGGLE = 7;
   static final int ROLE_SHOW = 8;

   CosmeticItem(
      String id,
      String name,
      String nameEn,
      String description,
      String descriptionEn,
      String slot,
      String attach,
      int accent,
      int frames,
      float frameTime,
      float[] anchor,
      float glowPeriod,
      float glowMin,
      float glowMax,
      CosmeticItem.Bone[] bones,
      Map<String, CosmeticItem.Clip> clips,
      CosmeticItem.Emitter[] emitters,
      String albedoPath,
      String emissivePath
   ) {
      this.id = id;
      this.name = name;
      this.nameEn = nameEn;
      this.description = description;
      this.descriptionEn = descriptionEn;
      this.slot = slot;
      this.attach = attach;
      this.accent = accent;
      this.frames = frames;
      this.frameTime = frameTime;
      this.anchor = anchor;
      this.glowPeriod = glowPeriod;
      this.glowMin = glowMin;
      this.glowMax = glowMax;
      this.bones = bones;
      this.clips = clips;
      this.emitters = emitters;
      this.albedoPath = albedoPath;
      this.emissivePath = emissivePath;
   }

   public String title() {
      return wap.ru() ? this.name : this.nameEn;
   }

   public String about() {
      return wap.ru() ? this.description : this.descriptionEn;
   }

   public boolean isPet() {
      return "pet".equals(this.attach);
   }

   public boolean onHead() {
      return "head".equals(this.attach);
   }

   public boolean isCape() {
      return "cape".equals(this.slot);
   }

   public boolean isBack() {
      return "back".equals(this.slot);
   }

   public boolean isAvatar() {
      return "avatar".equals(this.slot);
   }

   public boolean glows() {
      return this.emissivePath != null;
   }

   static final class Bone {
      final String name;
      final int parent;
      final float px;
      final float py;
      final float pz;
      final float rx;
      final float ry;
      final float rz;
      float[] solid;
      float[] glass;
      int role;
      int side;
      int part = -1;
      float blinkU;
      float blinkV;
      float hx;
      float hy = -1.0F;
      float hz;
      int depth;
      boolean video;

      Bone(String name, int parent, float px, float py, float pz, float rx, float ry, float rz) {
         this.name = name;
         this.parent = parent;
         this.px = px;
         this.py = py;
         this.pz = pz;
         this.rx = rx;
         this.ry = ry;
         this.rz = rz;
      }
   }

   static final class Clip {
      final float length;
      final CosmeticItem.Track[] rotation;
      final CosmeticItem.Track[] position;
      final CosmeticItem.Track[] scale;

      Clip(float length, int bones) {
         this.length = length;
         this.rotation = new CosmeticItem.Track[bones];
         this.position = new CosmeticItem.Track[bones];
         this.scale = new CosmeticItem.Track[bones];
      }
   }

   static final class Emitter {
      final int bone;
      final float ox;
      final float oy;
      final float oz;
      final float rate;
      final float lifeMin;
      final float lifeMax;
      final int[] colors;
      final float sizeMin;
      final float sizeMax;
      final float vx;
      final float vy;
      final float vz;
      final float spread;
      final float gravity;
      final int kind;
      final boolean additive;
      final float drag;

      Emitter(
         int bone,
         float ox,
         float oy,
         float oz,
         float rate,
         float lifeMin,
         float lifeMax,
         int[] colors,
         float sizeMin,
         float sizeMax,
         float vx,
         float vy,
         float vz,
         float spread,
         float gravity,
         int kind,
         boolean additive,
         float drag
      ) {
         this.bone = bone;
         this.ox = ox;
         this.oy = oy;
         this.oz = oz;
         this.rate = rate;
         this.lifeMin = lifeMin;
         this.lifeMax = lifeMax;
         this.colors = colors;
         this.sizeMin = sizeMin;
         this.sizeMax = sizeMax;
         this.vx = vx;
         this.vy = vy;
         this.vz = vz;
         this.spread = spread;
         this.gravity = gravity;
         this.kind = kind;
         this.additive = additive;
         this.drag = drag;
      }
   }

   static final class Track {
      final float[] times;
      final float[] values;

      Track(float[] times, float[] values) {
         this.times = times;
         this.values = values;
      }

      void sample(float t, float[] out) {
         int n = this.times.length;
         if (n != 1 && !(t <= this.times[0])) {
            if (t >= this.times[n - 1]) {
               out[0] = this.values[3 * (n - 1)];
               out[1] = this.values[3 * (n - 1) + 1];
               out[2] = this.values[3 * (n - 1) + 2];
            } else {
               int lo = 0;
               int hi = n - 1;

               while (hi - lo > 1) {
                  int mid = lo + hi >>> 1;
                  if (this.times[mid] <= t) {
                     lo = mid;
                  } else {
                     hi = mid;
                  }
               }

               float span = this.times[hi] - this.times[lo];
               float f = span > 1.0E-6F ? (t - this.times[lo]) / span : 0.0F;
               int p0 = lo > 0 ? lo - 1 : lo;
               int p3 = hi < n - 1 ? hi + 1 : hi;
               boolean even = span > 1.0E-6F && even(this.times[lo] - this.times[p0], span) && even(this.times[p3] - this.times[hi], span);

               for (int i = 0; i < 3; i++) {
                  float a = this.values[3 * lo + i];
                  float b = this.values[3 * hi + i];
                  if (!even) {
                     out[i] = a + (b - a) * f;
                  } else {
                     float y0 = p0 == lo ? 2.0F * a - b : this.values[3 * p0 + i];
                     float y3 = p3 == hi ? 2.0F * b - a : this.values[3 * p3 + i];
                     float f2 = f * f;
                     float f3 = f2 * f;
                     out[i] = 0.5F * (2.0F * a + (b - y0) * f + (2.0F * y0 - 5.0F * a + 4.0F * b - y3) * f2 + (3.0F * a - y0 - 3.0F * b + y3) * f3);
                  }
               }
            }
         } else {
            out[0] = this.values[0];
            out[1] = this.values[1];
            out[2] = this.values[2];
         }
      }

      private static boolean even(float gap, float span) {
         return gap <= 1.0E-6F || gap > span * 0.6F && gap < span * 1.6F;
      }
   }
}
