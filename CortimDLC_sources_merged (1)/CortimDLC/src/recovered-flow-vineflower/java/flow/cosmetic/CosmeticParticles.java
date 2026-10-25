package flow.cosmetic;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.MatrixStack.Entry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

final class CosmeticParticles {
   private static final int MAX = 1600;
   private static final int KINDS = 8;
   private static final List<CosmeticParticles.P> LIVE = new ArrayList<>();
   private static final List<CosmeticParticles.P> ADD = new ArrayList<>();
   private static final List<CosmeticParticles.P> BLEND = new ArrayList<>();
   private static final Vector3f VERTEX = new Vector3f();
   private static Identifier sheet;
   private static boolean failed;
   private static final float[] SWAY = new float[]{0.015F, 0.07F, 0.03F, 0.05F, 0.04F, 0.06F, 0.02F, 0.14F};
   private static final float[] FREQ = new float[]{2.0F, 2.2F, 5.0F, 4.2F, 1.7F, 2.6F, 1.2F, 3.1F};
   private static final int[] TRI = new int[]{0, 1, 2, 0, 2, 3};

   private CosmeticParticles() {
   }

   static void spawn(CosmeticItem.Emitter em, double x, double y, double z, float yawRad) {
      if (LIVE.size() < 1600) {
         ThreadLocalRandom r = ThreadLocalRandom.current();
         CosmeticParticles.P p = new CosmeticParticles.P();
         float sp = em.spread / 16.0F;

         double ux;
         double uy;
         double uz;
         do {
            ux = r.nextDouble() * 2.0 - 1.0;
            uy = r.nextDouble() * 2.0 - 1.0;
            uz = r.nextDouble() * 2.0 - 1.0;
         } while (ux * ux + uy * uy + uz * uz > 1.0);

         p.x = x + ux * sp;
         p.y = y + uy * sp;
         p.z = z + uz * sp;
         float jx = 1.0F + (float)r.nextDouble(-0.35, 0.35);
         float jy = 1.0F + (float)r.nextDouble(-0.35, 0.35);
         float jz = 1.0F + (float)r.nextDouble(-0.35, 0.35);
         double lx = em.vx * jx / 16.0;
         double lz = em.vz * jz / 16.0;
         double c = Math.cos(yawRad);
         double s = Math.sin(yawRad);
         p.vx = lx * c + lz * s + r.nextDouble(-0.3, 0.3) / 16.0;
         p.vz = -lx * s + lz * c + r.nextDouble(-0.3, 0.3) / 16.0;
         p.vy = em.vy * jy / 16.0 + r.nextDouble(-0.3, 0.3) / 16.0;
         p.gravity = em.gravity / 16.0F;
         p.drag = em.drag;
         p.life = (float)r.nextDouble(em.lifeMin, Math.max(em.lifeMin + 0.001, (double)em.lifeMax));
         p.size = (float)r.nextDouble(em.sizeMin, Math.max(em.sizeMin + 0.001, (double)em.sizeMax)) * 1.5F / 16.0F;
         p.color = em.colors[r.nextInt(em.colors.length)];
         p.kind = Math.max(0, Math.min(7, em.kind));
         p.additive = em.additive;
         p.rot = (float)r.nextDouble(0.0, Math.PI * 2);
         p.spin = (float)r.nextDouble(-1.5, 1.5);
         p.phase = (float)r.nextDouble(0.0, Math.PI * 2);
         p.sway = SWAY[p.kind] * (float)r.nextDouble(0.7, 1.3);
         p.freq = FREQ[p.kind] * (float)r.nextDouble(0.8, 1.2);
         switch (p.kind) {
            case 0:
               p.spin = (float)r.nextDouble(-0.9, 0.9);
               break;
            case 1:
               p.spin = (float)r.nextDouble(-0.6, 0.6);
            case 2:
            case 4:
            case 6:
            default:
               break;
            case 3:
               p.rot = 0.0F;
               p.spin = 0.0F;
               break;
            case 5:
               p.rot = (float)r.nextDouble(-0.2, 0.2);
               p.spin = 0.0F;
               break;
            case 7:
               p.spin = (float)r.nextDouble(-3.0, 3.0);
         }

         LIVE.add(p);
      }
   }

   private static float pop(float t, float dur) {
      float x = Math.min(1.0F, t / dur) - 1.0F;
      return 1.0F + 2.70158F * x * x * x + 1.70158F * x * x;
   }

   private static float angle(CosmeticParticles.P p) {
      return switch (p.kind) {
         case 5 -> p.rot + 0.26F * (float)Math.sin(p.age * 2.6F + p.phase);
         case 7 -> p.rot + 0.7F * (float)Math.sin(p.age * 3.0F + p.phase);
         default -> p.rot;
      };
   }

   private static float scale(CosmeticParticles.P p, float t) {
      return switch (p.kind) {
         case 0 -> pop(t, 0.14F) * (1.0F - 0.35F * t) * (0.74F + 0.26F * (float)Math.sin(p.age * 13.0F + p.phase));
         default -> 1.0F - 0.35F * t;
         case 2 -> 1.0F - 0.55F * t;
         case 3 -> t > 0.86F ? 1.15F + (t - 0.86F) * 4.0F : 0.8F + 0.35F * t;
         case 5 -> pop(t, 0.2F) * (1.0F - 0.25F * t);
         case 6 -> 1.0F + t * 1.8F;
      };
   }

   private static float fade(CosmeticParticles.P p, float t) {
      float f = Math.min(1.0F, t / 0.12F) * (1.0F - Math.max(0.0F, (t - 0.55F) / 0.45F));
      switch (p.kind) {
         case 0:
            f *= 0.8F + 0.2F * (float)Math.sin(p.age * 13.0F + p.phase);
         case 1:
         default:
            break;
         case 2:
            f *= 0.72F + 0.28F * (float)Math.sin(p.age * 21.0F + p.phase);
            break;
         case 3:
            if (t > 0.86F) {
               f *= Math.max(0.0F, 1.0F - (t - 0.86F) / 0.14F);
            }
      }

      return f;
   }

   private static int tint(CosmeticParticles.P p, float t) {
      if (p.kind != 2) {
         return p.color;
      } else {
         int r = p.color >> 16 & 0xFF;
         int g = p.color >> 8 & 0xFF;
         int b = p.color & 0xFF;
         g = (int)(g * (1.0F - 0.55F * t));
         b = (int)(b * (1.0F - 0.7F * t));
         r = (int)(r * (1.0F - 0.1F * t));
         return r << 16 | g << 8 | b;
      }
   }

   static void step(float dt) {
      for (int i = LIVE.size() - 1; i >= 0; i--) {
         CosmeticParticles.P p = LIVE.get(i);
         p.age += dt;
         if (p.age >= p.life) {
            LIVE.set(i, LIVE.get(LIVE.size() - 1));
            LIVE.remove(LIVE.size() - 1);
         } else {
            p.vy = p.vy + p.gravity * dt;
            double k = Math.max(0.0, 1.0 - p.drag * dt);
            p.vx *= k;
            p.vy *= k;
            p.vz *= k;
            p.x = p.x + p.vx * dt;
            p.y = p.y + p.vy * dt;
            p.z = p.z + p.vz * dt;
            if (p.sway > 0.0F) {
               double s = Math.sin(p.age * p.freq + p.phase) * p.sway * p.freq * dt;
               p.x = p.x + Math.cos(p.phase) * s;
               p.z = p.z + Math.sin(p.phase) * s;
            }

            p.rot = p.rot + p.spin * dt;
         }
      }
   }

   static void clear() {
      LIVE.clear();
   }

   private static Identifier sheet() {
      if (sheet == null && !failed) {
         NativeImage img = CosmeticLoader.image("particles.png");
         if (img == null) {
            failed = true;
            return null;
         } else {
            sheet = Identifier.method_60655("flow2", "cosmetic/particles");
            MinecraftClient.method_1551().method_1531().method_4616(sheet, new NativeImageBackedTexture(() -> "Flow2 cosmetic particles", img));
            return sheet;
         }
      } else {
         return sheet;
      }
   }

   static void render(MatrixStack matrices, OrderedRenderCommandQueue queue, Vec3d cam, Quaternionf camRot) {
      if (!LIVE.isEmpty()) {
         Identifier tex = sheet();
         if (tex != null) {
            List<CosmeticParticles.P> add = ADD;
            List<CosmeticParticles.P> blend = BLEND;
            add.clear();
            blend.clear();

            for (CosmeticParticles.P p : LIVE) {
               (p.additive ? add : blend).add(p);
            }

            Quaternionf q = new Quaternionf(camRot);
            if (!add.isEmpty()) {
               queue.method_73483(matrices, RenderLayers.method_76014(tex), (entry, vc) -> quads(add, entry, vc, cam, q, true));
               if (CosmeticGlow.active()) {
                  glow(add, tex, cam, q);
               }
            }

            if (!blend.isEmpty()) {
               for (CosmeticParticles.P p : blend) {
                  double dx = p.x - cam.field_1352;
                  double dy = p.y - cam.field_1351;
                  double dz = p.z - cam.field_1350;
                  p.depth = dx * dx + dy * dy + dz * dz;
               }

               blend.sort((a, b) -> Double.compare(b.depth, a.depth));
               queue.method_73483(matrices, RenderLayers.method_76000(tex), (entry, vc) -> quads(blend, entry, vc, cam, q, false));
            }
         }
      }
   }

   private static void glow(List<CosmeticParticles.P> list, Identifier tex, Vec3d cam, Quaternionf q) {
      Vector3f right = q.transform(new Vector3f(1.0F, 0.0F, 0.0F));
      Vector3f up = q.transform(new Vector3f(0.0F, 1.0F, 0.0F));
      Vector3f a = new Vector3f();
      Vector3f b = new Vector3f();
      ByteBuffer out = CosmeticGlow.reserve(list.size() * 6);
      int written = 0;
      float[][] c = new float[4][3];
      float[][] uv = new float[4][2];

      for (CosmeticParticles.P p : list) {
         float t = p.age / p.life;
         float fade = fade(p, t);
         float size = p.size * 1.6F * scale(p, t);
         float rot = angle(p);
         float cs = (float)Math.cos(rot) * size;
         float sn = (float)Math.sin(rot) * size;
         a.set(right).mul(cs).add(up.x * sn, up.y * sn, up.z * sn);
         b.set(up).mul(cs).sub(right.x * sn, right.y * sn, right.z * sn);
         float cx = (float)(p.x - cam.field_1352);
         float cy = (float)(p.y - cam.field_1351);
         float cz = (float)(p.z - cam.field_1350);
         float u0 = p.kind / 8.0F;
         float u1 = (p.kind + 1) / 8.0F;
         set(c[0], uv[0], cx - a.x - b.x, cy - a.y - b.y, cz - a.z - b.z, u0, 1.0F);
         set(c[1], uv[1], cx + a.x - b.x, cy + a.y - b.y, cz + a.z - b.z, u1, 1.0F);
         set(c[2], uv[2], cx + a.x + b.x, cy + a.y + b.y, cz + a.z + b.z, u1, 0.0F);
         set(c[3], uv[3], cx - a.x + b.x, cy - a.y + b.y, cz - a.z + b.z, u0, 0.0F);
         int color = tint(p, t);
         byte r = (byte)(color >> 16);
         byte g = (byte)(color >> 8);
         byte bl = (byte)color;
         byte al = (byte)Math.round(Math.min(1.0F, fade * 0.7F) * 255.0F);

         for (int k : TRI) {
            out.putFloat(c[k][0]).putFloat(c[k][1]).putFloat(c[k][2]).putFloat(uv[k][0]).putFloat(uv[k][1]);
            out.put(r).put(g).put(bl).put(al);
         }

         written += 6;
      }

      CosmeticGlow.commit(tex, written);
   }

   private static void set(float[] c, float[] uv, float x, float y, float z, float u, float v) {
      c[0] = x;
      c[1] = y;
      c[2] = z;
      uv[0] = u;
      uv[1] = v;
   }

   private static void quads(List<CosmeticParticles.P> list, Entry entry, VertexConsumer vc, Vec3d cam, Quaternionf q, boolean additive) {
      Vector3f right = q.transform(new Vector3f(1.0F, 0.0F, 0.0F));
      Vector3f up = q.transform(new Vector3f(0.0F, 1.0F, 0.0F));
      Vector3f normal = q.transform(new Vector3f(0.0F, 0.0F, 1.0F));
      Vector3f a = new Vector3f();
      Vector3f b = new Vector3f();
      int light = 15728880;
      int overlay = OverlayTexture.field_21444;

      for (CosmeticParticles.P p : list) {
         float t = p.age / p.life;
         float fade = fade(p, t);
         float size = p.size * scale(p, t);
         int color = tint(p, t);
         int r = color >> 16 & 0xFF;
         int g = color >> 8 & 0xFF;
         int bl = color & 0xFF;
         int argb;
         if (additive) {
            float k = fade * 1.25F;
            argb = 0xFF000000 | Math.min(255, (int)(r * k)) << 16 | Math.min(255, (int)(g * k)) << 8 | Math.min(255, (int)(bl * k));
         } else {
            argb = (int)(fade * 255.0F) << 24 | r << 16 | g << 8 | bl;
         }

         float rot = angle(p);
         float c = (float)Math.cos(rot) * size;
         float s = (float)Math.sin(rot) * size;
         a.set(right).mul(c).add(up.x * s, up.y * s, up.z * s);
         b.set(up).mul(c).sub(right.x * s, right.y * s, right.z * s);
         float cx = (float)(p.x - cam.field_1352);
         float cy = (float)(p.y - cam.field_1351);
         float cz = (float)(p.z - cam.field_1350);
         float u0 = p.kind / 8.0F;
         float u1 = (p.kind + 1) / 8.0F;
         vertex(vc, entry, cx - a.x - b.x, cy - a.y - b.y, cz - a.z - b.z, argb, u0, 1.0F, overlay, light, normal);
         vertex(vc, entry, cx + a.x - b.x, cy + a.y - b.y, cz + a.z - b.z, argb, u1, 1.0F, overlay, light, normal);
         vertex(vc, entry, cx + a.x + b.x, cy + a.y + b.y, cz + a.z + b.z, argb, u1, 0.0F, overlay, light, normal);
         vertex(vc, entry, cx - a.x + b.x, cy - a.y + b.y, cz - a.z + b.z, argb, u0, 0.0F, overlay, light, normal);
      }
   }

   private static void vertex(VertexConsumer vc, Entry entry, float x, float y, float z, int argb, float u, float v, int overlay, int light, Vector3f n) {
      Vector3f p = entry.method_23761().transformPosition(x, y, z, VERTEX);
      vc.method_23919(p.x, p.y, p.z, argb, u, v, overlay, light, n.x, n.y, n.z);
   }

   private static final class P {
      double x;
      double y;
      double z;
      double vx;
      double vy;
      double vz;
      float gravity;
      float drag;
      float age;
      float life;
      float size;
      int color;
      int kind;
      boolean additive;
      float rot;
      float spin;
      float phase;
      float sway;
      float freq;
      double depth;
   }
}
