package flow.cosmetic;

import java.nio.ByteBuffer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack.Entry;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

final class CosmeticMesh {
   static final int SOLID = 0;
   static final int GLASS = 1;
   static final int GLOW = 2;
   static final int VIDEO = 3;
   private static final float[] A = new float[3];
   private static final float CHAIN_GAIN = (float)Math.toRadians(2.6);
   private static final float CHAIN_MAX = (float)Math.toRadians(16.0);
   private static final int LAG_PER_LINK = 3;
   private static final Matrix4f E_POS = new Matrix4f();
   private static final Matrix4f E_M = new Matrix4f();
   private static final Matrix3f E_NRM = new Matrix3f();
   private static final Matrix3f E_NM = new Matrix3f();
   private static final Matrix3f E_TMP = new Matrix3f();
   private static final Vector4f E_P = new Vector4f();
   private static final Vector3f E_N = new Vector3f();
   private static final Matrix4f G_M = new Matrix4f();
   private static final Vector3f[] G_C = new Vector3f[]{new Vector3f(), new Vector3f(), new Vector3f(), new Vector3f()};
   private static final Matrix4f ABOUT = new Matrix4f();
   private static final Matrix4f Q = new Matrix4f();
   private static final Vector3f DRAG_H = new Vector3f();
   private static final Vector3f DRAG_AXIS = new Vector3f();
   private static final int[] TRI = new int[]{0, 1, 2, 0, 2, 3};

   private CosmeticMesh() {
   }

   static CosmeticItem.Clip clip(CosmeticItem item, String state) {
      CosmeticItem.Clip c = item.clips.get(state);
      if (c == null && "fly".equals(state)) {
         c = item.clips.get("walk");
      }

      if (c == null) {
         c = item.clips.get("idle");
      }

      return c;
   }

   private static int add(CosmeticItem.Clip[] cl, float[] ts, float[] ws, int n, CosmeticItem.Clip c, float t, float w) {
      if (c != null && !(w <= 1.0E-4F)) {
         for (int k = 0; k < n; k++) {
            if (cl[k] == c) {
               ws[k] += w;
               return n;
            }
         }

         cl[n] = c;
         ts[n] = wrap(t, c.length);
         ws[n] = w;
         return n + 1;
      } else {
         return n;
      }
   }

   static Matrix4f[] pose(CosmeticItem item, CosmeticMesh.Drive d) {
      CosmeticItem.Clip[] cl = new CosmeticItem.Clip[3];
      float[] ts = new float[3];
      float[] ws = new float[3];
      int n = 0;
      n = add(cl, ts, ws, n, clip(item, "idle"), d.tIdle, d.wIdle);
      n = add(cl, ts, ws, n, clip(item, "walk"), d.tWalk, d.wWalk);
      n = add(cl, ts, ws, n, clip(item, "fly"), d.tFly, d.wFly);
      float total = 0.0F;

      for (int k = 0; k < n; k++) {
         total += ws[k];
      }

      for (int k = 0; k < n && total > 1.0E-5F; k++) {
         ws[k] /= total;
      }

      CosmeticItem.Clip sneak = d.wSneak > 0.001F ? item.clips.get("sneak") : null;
      CosmeticItem.Clip air = d.wAir > 0.001F ? item.clips.get("air") : null;
      CosmeticItem.Clip attack = d.wAttack > 0.001F ? item.clips.get("attack") : null;
      Matrix4f root = rootOf(item, d);
      CosmeticItem.Bone[] bones = item.bones;
      Matrix4f[] out = new Matrix4f[bones.length];
      float[] r = new float[3];
      float[] p = new float[3];
      float[] s = new float[3];
      Vector3f origin = new Vector3f();

      for (int i = 0; i < bones.length; i++) {
         CosmeticItem.Bone b = bones[i];
         r[0] = r[1] = r[2] = 0.0F;
         p[0] = p[1] = p[2] = 0.0F;
         s[0] = s[1] = s[2] = n == 0 ? 1.0F : 0.0F;

         for (int k = 0; k < n; k++) {
            accumulate(cl[k].rotation[i], ts[k], ws[k], 0.0F, r);
            accumulate(cl[k].position[i], ts[k], ws[k], 0.0F, p);
            accumulate(cl[k].scale[i], ts[k], ws[k], 1.0F, s);
         }

         layer(sneak, i, d.tIdle, d.wSneak, r, p);
         layer(air, i, d.tIdle, d.wAir, r, p);
         layer(attack, i, d.tIdle, d.wAttack, r, p);
         float rx = b.rx + r[0];
         float ry = b.ry + r[1];
         float rz = b.rz + r[2];
         if (d.cape != null && "cape".equals(b.name)) {
            rx += d.cape[0];
            ry += d.cape[1];
            rz += d.cape[2];
         }

         boolean nested = b.parent >= 0 && out[b.parent] != null && bones[b.parent].part == b.part;
         Matrix4f m = nested ? new Matrix4f(out[b.parent]) : new Matrix4f(root);
         float ppx = nested ? bones[b.parent].px : 0.0F;
         float ppy = nested ? bones[b.parent].py : 0.0F;
         float ppz = nested ? bones[b.parent].pz : 0.0F;
         m.translate(b.px - ppx - p[0], b.py - ppy + p[1], b.pz - ppz + p[2])
            .rotateZ((float)Math.toRadians(rz))
            .rotateY((float)Math.toRadians(-ry))
            .rotateX((float)Math.toRadians(-rx))
            .scale(s[0], s[1], s[2]);
         switch (b.role) {
            case 1:
               Matrix4f q = Q.identity().rotateY((float)Math.toRadians(-b.side * d.sweep + d.turn)).rotateZ((float)Math.toRadians(b.side * d.lift));
               about(m, q, origin);
               break;
            case 2:
               drag(m, b, d, origin);
               break;
            case 3:
               if (Math.abs(d.twitch) > 0.01F) {
                  about(m, Q.identity().rotateZ((float)Math.toRadians(-b.side * d.twitch)), origin);
               }
               break;
            case 4:
               if (Math.abs(d.lookYaw) > 0.01F || Math.abs(d.lookPitch) > 0.01F) {
                  about(m, Q.identity().rotateY((float)Math.toRadians(-d.lookYaw)).rotateX((float)Math.toRadians(-d.lookPitch)), origin);
               }
               break;
            case 5:
               if (!d.blink || d.happy && !d.hurt && !d.air) {
                  about(m, Q.identity().scale(1.0F, 0.001F, 1.0F), origin);
               }
               break;
            case 6:
               float front = Math.max(0.0F, -Math.min(d.legL, d.legR));
               float back = Math.max(0.0F, Math.max(d.legL, d.legR));

               float a = switch (b.side) {
                  case 0 -> front * 0.9F;
                  case 1 -> -back * 0.9F;
                  default -> 0.0F;
               };
               if (b.side >= 2) {
                  float spread = (front + back) * 0.22F;
                  about(m, Q.identity().rotateZ(b.side == 2 ? -spread : spread), origin);
               } else if (Math.abs(a) > 1.0E-4F) {
                  about(m, Q.identity().rotateX(a), origin);
               }

               drag(m, b, d, origin);
               break;
            case 7:
               jiggle(m, b, d, origin);
               break;
            case 8:
               boolean on = switch (b.side) {
                  case 0 -> d.hurt;
                  case 1 -> d.air;
                  default -> {
                     if (d.happy && !d.hurt && !d.air) {
                        yield true;
                     }

                     yield false;
                  }
                  case 3 -> !d.happy || d.hurt || d.air;
               };
               if (!on) {
                  about(m, Q.identity().scale(0.001F), origin);
               }
         }

         out[i] = m;
      }

      return out;
   }

   private static void jiggle(Matrix4f m, CosmeticItem.Bone b, CosmeticMesh.Drive d, Vector3f origin) {
      float j = d.jiggle;
      if (b.side == 0) {
         m.translate(0.0F, j * 0.7F, 0.0F).rotateX((float)Math.toRadians(j * 11.0F)).rotateZ((float)Math.toRadians(d.sway));
      } else if (b.side <= 2) {
         float leg = b.side == 1 ? d.legL : d.legR;
         float lag = b.side == 1 ? 1.0F : 0.8F;
         about(
            m,
            Q.identity()
               .translation(0.0F, j * 0.75F * lag, 0.0F)
               .rotateX((float)Math.toRadians(j * 12.0F * lag + leg * 5.0F))
               .rotateZ((float)Math.toRadians(d.sway * 1.2F + (b.side == 1 ? -1.0F : 1.0F) * Math.abs(j) * 2.0F)),
            origin
         );
      } else {
         float leg = b.side == 3 ? d.legL : d.legR;
         about(
            m,
            Q.identity()
               .translation(0.0F, j * 0.5F + Math.max(0.0F, leg) * 0.9F, 0.0F)
               .rotateX(-leg * 0.32F - (float)Math.toRadians(j * 7.0F))
               .rotateZ((float)Math.toRadians(d.sway * 0.8F)),
            origin
         );
      }
   }

   private static void layer(CosmeticItem.Clip c, int i, float t, float w, float[] r, float[] p) {
      if (c != null) {
         float tt = wrap(t, c.length);
         if (c.rotation[i] != null) {
            accumulate(c.rotation[i], tt, w, 0.0F, r);
         }

         if (c.position[i] != null) {
            accumulate(c.position[i], tt, w, 0.0F, p);
         }
      }
   }

   private static void drag(Matrix4f m, CosmeticItem.Bone b, CosmeticMesh.Drive d, Vector3f origin) {
      Vector3f h = m.transformDirection(b.hx, b.hy, b.hz, DRAG_H);
      if (h.lengthSquared() > 1.0E-8F) {
         h.normalize();
         float dx = d.dx;
         float dy = d.dy;
         float dz = d.dz;
         if (d.lag != null && b.depth > 0) {
            int n = d.lag.length / 3;
            int k = Math.floorMod(d.lagHead - Math.min(n - 1, b.depth * 3), n);
            dx = d.lag[k * 3];
            dy = d.lag[k * 3 + 1];
            dz = d.lag[k * 3 + 2];
         }

         Vector3f axis = h.cross(dx, dy, dz, DRAG_AXIS);
         float len = axis.length();
         if (len > 1.0E-4F) {
            float reach = 1.0F + 0.05F * Math.min(b.depth, 6);
            float angle = Math.min(CHAIN_MAX * reach, len * CHAIN_GAIN * reach);
            about(m, Q.identity().rotation(angle, axis.div(len)), origin);
         }
      }
   }

   private static Matrix4f rootOf(CosmeticItem item, CosmeticMesh.Drive d) {
      Matrix4f root = new Matrix4f();
      if (item.isPet()) {
         if (Math.abs(d.roll) > 0.01F || Math.abs(d.pitch) > 0.01F) {
            root.rotateZ((float)Math.toRadians(-d.roll)).rotateX((float)Math.toRadians(d.pitch));
         }
      } else if (item.isBack()) {
         root.translate(0.0F, 24.0F + d.bob, 2.0F).rotateX((float)Math.toRadians(-d.tilt)).translate(0.0F, -24.0F, -2.0F);
      }

      return root;
   }

   private static void about(Matrix4f m, Matrix4f q, Vector3f scratch) {
      m.getTranslation(scratch);
      Matrix4f local = ABOUT.translation(scratch).mul(q).translate(-scratch.x, -scratch.y, -scratch.z);
      m.set(local.mul(m));
   }

   private static void accumulate(CosmeticItem.Track track, float t, float w, float def, float[] out) {
      if (track == null) {
         out[0] += def * w;
         out[1] += def * w;
         out[2] += def * w;
      } else {
         track.sample(t, A);
         out[0] += A[0] * w;
         out[1] += A[1] * w;
         out[2] += A[2] * w;
      }
   }

   private static float wrap(float t, float length) {
      if (length <= 1.0E-4F) {
         return 0.0F;
      }

      float m = t % length;
      return m < 0.0F ? m + length : m;
   }

   static void emit(CosmeticItem item, Matrix4f[] bones, Matrix4f base, Entry entry, VertexConsumer vc, int pass, int light, int argb, int frame) {
      emit(item, bones, base, entry, vc, pass, light, argb, frame, -2, false);
   }

   static void emit(
      CosmeticItem item, Matrix4f[] bones, Matrix4f base, Entry entry, VertexConsumer vc, int pass, int light, int argb, int frame, int part, boolean blink
   ) {
      emit(item, bones, base, entry, vc, pass, light, argb, frame, part, blink, false);
   }

   static void emit(
      CosmeticItem item,
      Matrix4f[] bones,
      Matrix4f base,
      Entry entry,
      VertexConsumer vc,
      int pass,
      int light,
      int argb,
      int frame,
      int part,
      boolean blink,
      boolean liveVideo
   ) {
      Matrix4f pos = E_POS.set(entry.getPositionMatrix()).mul(base);
      Matrix3f nrm = E_NRM.set(entry.getNormalMatrix()).mul(E_TMP.set(base).invert().transpose());
      int frames = Math.max(1, item.frames);
      float vScale = 1.0F / frames;
      float vOff = (float)(frame % frames) / frames;
      Vector4f p = E_P;
      Vector3f n = E_N;
      int overlay = OverlayTexture.DEFAULT_UV;

      for (int i = 0; i < item.bones.length; i++) {
         CosmeticItem.Bone bone = item.bones[i];
         if ((part == -2 || bone.part == part) && (pass == 3 ? bone.video : !bone.video || !liveVideo)) {
            Matrix4f m = E_M.set(pos).mul(bones[i]);
            Matrix3f nm = E_NM.set(nrm).mul(E_TMP.set(bones[i]).invert().transpose());
            float bu = blink ? bone.blinkU : 0.0F;
            float bv = blink ? bone.blinkV : 0.0F;
            if (pass == 3) {
               videoQuads(bone.solid, item.videoRect, m, nm, vc, p, n, argb, light, overlay);
            } else if (pass == 2) {
               quads(bone.solid, m, nm, vc, p, n, argb, light, overlay, vScale, vOff, bu, bv);
               quads(bone.glass, m, nm, vc, p, n, argb, light, overlay, vScale, vOff, bu, bv);
            } else {
               quads(pass == 1 ? bone.glass : bone.solid, m, nm, vc, p, n, argb, light, overlay, vScale, vOff, bu, bv);
            }
         }
      }
   }

   private static void videoQuads(float[] v, float[] r, Matrix4f m, Matrix3f nm, VertexConsumer vc, Vector4f p, Vector3f n, int argb, int light, int overlay) {
      if (v != null) {
         float du = Math.max(1.0E-6F, r[2] - r[0]);
         float dv = Math.max(1.0E-6F, r[3] - r[1]);

         for (int k = 0; k + 7 < v.length; k += 8) {
            p.set(v[k], v[k + 1], v[k + 2], 1.0F);
            m.transform(p);
            n.set(v[k + 5], v[k + 6], v[k + 7]);
            nm.transform(n);
            float len = n.length();
            if (len > 1.0E-6F) {
               n.div(len);
            }

            float u = Math.min(1.0F, Math.max(0.0F, (v[k + 3] - r[0]) / du));
            float w = Math.min(1.0F, Math.max(0.0F, (v[k + 4] - r[1]) / dv));
            vc.vertex(p.x, p.y, p.z, argb, u, w, overlay, light, n.x, n.y, n.z);
         }
      }
   }

   private static void quads(
      float[] v,
      Matrix4f m,
      Matrix3f nm,
      VertexConsumer vc,
      Vector4f p,
      Vector3f n,
      int argb,
      int light,
      int overlay,
      float vScale,
      float vOff,
      float bu,
      float bv
   ) {
      if (v != null) {
         for (int k = 0; k + 7 < v.length; k += 8) {
            p.set(v[k], v[k + 1], v[k + 2], 1.0F);
            m.transform(p);
            n.set(v[k + 5], v[k + 6], v[k + 7]);
            nm.transform(n);
            float len = n.length();
            if (len > 1.0E-6F) {
               n.div(len);
            }

            vc.vertex(p.x, p.y, p.z, argb, v[k + 3] + bu, vOff + (v[k + 4] + bv) * vScale, overlay, light, n.x, n.y, n.z);
         }
      }
   }

   static int glowVertices(CosmeticItem item) {
      int n = 0;

      for (CosmeticItem.Bone b : item.bones) {
         n += (b.solid == null ? 0 : b.solid.length / 32) + (b.glass == null ? 0 : b.glass.length / 32);
      }

      return n * 6;
   }

   static int glow(CosmeticItem item, Matrix4f[] bones, Matrix4f pose, ByteBuffer out, int argb, int frame, int part, boolean blink) {
      int frames = Math.max(1, item.frames);
      float vScale = 1.0F / frames;
      float vOff = (float)(frame % frames) / frames;
      int written = 0;
      Vector3f[] c = G_C;

      for (int i = 0; i < item.bones.length; i++) {
         if (part == -2 || item.bones[i].part == part) {
            Matrix4f m = G_M.set(pose).mul(bones[i]);
            float bu = blink ? item.bones[i].blinkU : 0.0F;
            float bv = blink ? item.bones[i].blinkV : 0.0F;
            written += glowQuads(item.bones[i].solid, m, out, argb, vScale, vOff, c, bu, bv);
            written += glowQuads(item.bones[i].glass, m, out, argb, vScale, vOff, c, bu, bv);
         }
      }

      return written;
   }

   private static int glowQuads(float[] v, Matrix4f m, ByteBuffer out, int argb, float vScale, float vOff, Vector3f[] c, float bu, float bv) {
      if (v == null) {
         return 0;
      }

      int written = 0;
      byte r = (byte)(argb >> 16);
      byte g = (byte)(argb >> 8);
      byte b = (byte)argb;
      byte a = (byte)(argb >>> 24);

      for (int q = 0; q + 31 < v.length; q += 32) {
         for (int k = 0; k < 4; k++) {
            m.transformPosition(v[q + k * 8], v[q + k * 8 + 1], v[q + k * 8 + 2], c[k]);
         }

         for (int k : TRI) {
            int o = q + k * 8;
            out.putFloat(c[k].x).putFloat(c[k].y).putFloat(c[k].z);
            out.putFloat(v[o + 3] + bu).putFloat(vOff + (v[o + 4] + bv) * vScale);
            out.put(r).put(g).put(b).put(a);
         }

         written += 6;
      }

      return written;
   }

   static boolean hasGlass(CosmeticItem item) {
      for (CosmeticItem.Bone b : item.bones) {
         if (b.glass != null && b.glass.length > 0) {
            return true;
         }
      }

      return false;
   }

   static boolean hasSolid(CosmeticItem item) {
      for (CosmeticItem.Bone b : item.bones) {
         if (b.solid != null && b.solid.length > 0) {
            return true;
         }
      }

      return false;
   }

   static final class Drive {
      float wIdle = 1.0F;
      float wWalk;
      float wFly;
      float tIdle;
      float tWalk;
      float tFly;
      float dx;
      float dy;
      float dz;
      float lift;
      float sweep;
      float turn;
      float bob;
      float tilt;
      float roll;
      float pitch;
      float lookYaw;
      float lookPitch;
      float twitch;
      boolean blink;
      float legL;
      float legR;
      float jiggle;
      float sway;
      float wSneak;
      float wAir;
      float wAttack;
      boolean hurt;
      boolean air;
      boolean happy;
      float[] lag;
      int lagHead;
      float[] cape;
   }
}
