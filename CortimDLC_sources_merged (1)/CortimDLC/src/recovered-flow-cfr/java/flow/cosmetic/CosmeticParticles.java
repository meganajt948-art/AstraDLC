/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.OverlayTexture
 *  net.minecraft.client.render.RenderLayers
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.NativeImageBackedTexture
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.Vec3d
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package flow.cosmetic;

import flow.cosmetic.CosmeticGlow;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.CosmeticLoader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

final class CosmeticParticles {
    private static final int MAX = 1600;
    private static final int KINDS = 8;
    private static final List<P> LIVE = new ArrayList<P>();
    private static final List<P> ADD = new ArrayList<P>();
    private static final List<P> BLEND = new ArrayList<P>();
    private static final Vector3f VERTEX = new Vector3f();
    private static Identifier sheet;
    private static boolean failed;
    private static final float[] SWAY;
    private static final float[] FREQ;
    private static final int[] TRI;

    private CosmeticParticles() {
    }

    static void spawn(CosmeticItem.Emitter em, double x, double y, double z, float yawRad) {
        double uz;
        double uy;
        double ux;
        if (LIVE.size() >= 1600) {
            return;
        }
        ThreadLocalRandom r = ThreadLocalRandom.current();
        P p = new P();
        float sp = em.spread / 16.0f;
        while ((ux = r.nextDouble() * 2.0 - 1.0) * ux + (uy = r.nextDouble() * 2.0 - 1.0) * uy + (uz = r.nextDouble() * 2.0 - 1.0) * uz > 1.0) {
        }
        p.x = x + ux * (double)sp;
        p.y = y + uy * (double)sp;
        p.z = z + uz * (double)sp;
        float jx = 1.0f + (float)r.nextDouble(-0.35, 0.35);
        float jy = 1.0f + (float)r.nextDouble(-0.35, 0.35);
        float jz = 1.0f + (float)r.nextDouble(-0.35, 0.35);
        double lx = (double)(em.vx * jx) / 16.0;
        double lz = (double)(em.vz * jz) / 16.0;
        double c = Math.cos(yawRad);
        double s = Math.sin(yawRad);
        p.vx = lx * c + lz * s + r.nextDouble(-0.3, 0.3) / 16.0;
        p.vz = -lx * s + lz * c + r.nextDouble(-0.3, 0.3) / 16.0;
        p.vy = (double)(em.vy * jy) / 16.0 + r.nextDouble(-0.3, 0.3) / 16.0;
        p.gravity = em.gravity / 16.0f;
        p.drag = em.drag;
        p.life = (float)r.nextDouble(em.lifeMin, Math.max((double)em.lifeMin + 0.001, (double)em.lifeMax));
        p.size = (float)r.nextDouble(em.sizeMin, Math.max((double)em.sizeMin + 0.001, (double)em.sizeMax)) * 1.5f / 16.0f;
        p.color = em.colors[r.nextInt(em.colors.length)];
        p.kind = Math.max(0, Math.min(7, em.kind));
        p.additive = em.additive;
        p.rot = (float)r.nextDouble(0.0, Math.PI * 2);
        p.spin = (float)r.nextDouble(-1.5, 1.5);
        p.phase = (float)r.nextDouble(0.0, Math.PI * 2);
        p.sway = SWAY[p.kind] * (float)r.nextDouble(0.7, 1.3);
        p.freq = FREQ[p.kind] * (float)r.nextDouble(0.8, 1.2);
        switch (p.kind) {
            case 0: {
                p.spin = (float)r.nextDouble(-0.9, 0.9);
                break;
            }
            case 1: {
                p.spin = (float)r.nextDouble(-0.6, 0.6);
                break;
            }
            case 3: {
                p.rot = 0.0f;
                p.spin = 0.0f;
                break;
            }
            case 5: {
                p.rot = (float)r.nextDouble(-0.2, 0.2);
                p.spin = 0.0f;
                break;
            }
            case 7: {
                p.spin = (float)r.nextDouble(-3.0, 3.0);
                break;
            }
        }
        LIVE.add(p);
    }

    private static float pop(float t, float dur) {
        float x = Math.min(1.0f, t / dur) - 1.0f;
        return 1.0f + 2.70158f * x * x * x + 1.70158f * x * x;
    }

    private static float angle(P p) {
        return switch (p.kind) {
            case 5 -> p.rot + 0.26f * (float)Math.sin(p.age * 2.6f + p.phase);
            case 7 -> p.rot + 0.7f * (float)Math.sin(p.age * 3.0f + p.phase);
            default -> p.rot;
        };
    }

    private static float scale(P p, float t) {
        return switch (p.kind) {
            case 0 -> CosmeticParticles.pop(t, 0.14f) * (1.0f - 0.35f * t) * (0.74f + 0.26f * (float)Math.sin(p.age * 13.0f + p.phase));
            case 2 -> 1.0f - 0.55f * t;
            case 3 -> {
                if (t > 0.86f) {
                    yield 1.15f + (t - 0.86f) * 4.0f;
                }
                yield 0.8f + 0.35f * t;
            }
            case 5 -> CosmeticParticles.pop(t, 0.2f) * (1.0f - 0.25f * t);
            case 6 -> 1.0f + t * 1.8f;
            default -> 1.0f - 0.35f * t;
        };
    }

    private static float fade(P p, float t) {
        float f = Math.min(1.0f, t / 0.12f) * (1.0f - Math.max(0.0f, (t - 0.55f) / 0.45f));
        switch (p.kind) {
            case 0: {
                f *= 0.8f + 0.2f * (float)Math.sin(p.age * 13.0f + p.phase);
                break;
            }
            case 2: {
                f *= 0.72f + 0.28f * (float)Math.sin(p.age * 21.0f + p.phase);
                break;
            }
            case 3: {
                if (!(t > 0.86f)) break;
                f *= Math.max(0.0f, 1.0f - (t - 0.86f) / 0.14f);
                break;
            }
        }
        return f;
    }

    private static int tint(P p, float t) {
        if (p.kind != 2) {
            return p.color;
        }
        int r = p.color >> 16 & 0xFF;
        int g = p.color >> 8 & 0xFF;
        int b = p.color & 0xFF;
        g = (int)((float)g * (1.0f - 0.55f * t));
        b = (int)((float)b * (1.0f - 0.7f * t));
        r = (int)((float)r * (1.0f - 0.1f * t));
        return r << 16 | g << 8 | b;
    }

    static void step(float dt) {
        for (int i = LIVE.size() - 1; i >= 0; --i) {
            P p = LIVE.get(i);
            p.age += dt;
            if (p.age >= p.life) {
                LIVE.set(i, LIVE.get(LIVE.size() - 1));
                LIVE.remove(LIVE.size() - 1);
                continue;
            }
            p.vy += (double)(p.gravity * dt);
            double k = Math.max(0.0, 1.0 - (double)(p.drag * dt));
            p.vx *= k;
            p.vy *= k;
            p.vz *= k;
            p.x += p.vx * (double)dt;
            p.y += p.vy * (double)dt;
            p.z += p.vz * (double)dt;
            if (p.sway > 0.0f) {
                double s = Math.sin(p.age * p.freq + p.phase) * (double)p.sway * (double)p.freq * (double)dt;
                p.x += Math.cos(p.phase) * s;
                p.z += Math.sin(p.phase) * s;
            }
            p.rot += p.spin * dt;
        }
    }

    static void clear() {
        LIVE.clear();
    }

    private static Identifier sheet() {
        if (sheet != null || failed) {
            return sheet;
        }
        NativeImage img = CosmeticLoader.image("particles.png");
        if (img == null) {
            failed = true;
            return null;
        }
        sheet = Identifier.method_60655((String)"flow2", (String)"cosmetic/particles");
        MinecraftClient.method_1551().method_1531().method_4616(sheet, (AbstractTexture)new NativeImageBackedTexture(() -> "Flow2 cosmetic particles", img));
        return sheet;
    }

    static void render(MatrixStack matrices, OrderedRenderCommandQueue queue, Vec3d cam, Quaternionf camRot) {
        if (LIVE.isEmpty()) {
            return;
        }
        Identifier tex = CosmeticParticles.sheet();
        if (tex == null) {
            return;
        }
        List<P> add = ADD;
        List<P> blend = BLEND;
        add.clear();
        blend.clear();
        for (P p : LIVE) {
            (p.additive ? add : blend).add(p);
        }
        Quaternionf q = new Quaternionf((Quaternionfc)camRot);
        if (!add.isEmpty()) {
            queue.method_73483(matrices, RenderLayers.method_76014((Identifier)tex), (entry, vc) -> CosmeticParticles.quads(add, entry, vc, cam, q, true));
            if (CosmeticGlow.active()) {
                CosmeticParticles.glow(add, tex, cam, q);
            }
        }
        if (!blend.isEmpty()) {
            for (P p : blend) {
                double dx = p.x - cam.field_1352;
                double dy = p.y - cam.field_1351;
                double dz = p.z - cam.field_1350;
                p.depth = dx * dx + dy * dy + dz * dz;
            }
            blend.sort((a2, b) -> Double.compare(b.depth, a2.depth));
            queue.method_73483(matrices, RenderLayers.method_76000((Identifier)tex), (entry, vc) -> CosmeticParticles.quads(blend, entry, vc, cam, q, false));
        }
    }

    private static void glow(List<P> list, Identifier tex, Vec3d cam, Quaternionf q) {
        Vector3f right = q.transform(new Vector3f(1.0f, 0.0f, 0.0f));
        Vector3f up = q.transform(new Vector3f(0.0f, 1.0f, 0.0f));
        Vector3f a2 = new Vector3f();
        Vector3f b = new Vector3f();
        ByteBuffer out = CosmeticGlow.reserve(list.size() * 6);
        int written = 0;
        float[][] c = new float[4][3];
        float[][] uv = new float[4][2];
        for (P p : list) {
            float t = p.age / p.life;
            float fade = CosmeticParticles.fade(p, t);
            float size = p.size * 1.6f * CosmeticParticles.scale(p, t);
            float rot = CosmeticParticles.angle(p);
            float cs = (float)Math.cos(rot) * size;
            float sn = (float)Math.sin(rot) * size;
            a2.set((Vector3fc)right).mul(cs).add(up.x * sn, up.y * sn, up.z * sn);
            b.set((Vector3fc)up).mul(cs).sub(right.x * sn, right.y * sn, right.z * sn);
            float cx = (float)(p.x - cam.field_1352);
            float cy = (float)(p.y - cam.field_1351);
            float cz = (float)(p.z - cam.field_1350);
            float u0 = (float)p.kind / 8.0f;
            float u1 = (float)(p.kind + 1) / 8.0f;
            CosmeticParticles.set(c[0], uv[0], cx - a2.x - b.x, cy - a2.y - b.y, cz - a2.z - b.z, u0, 1.0f);
            CosmeticParticles.set(c[1], uv[1], cx + a2.x - b.x, cy + a2.y - b.y, cz + a2.z - b.z, u1, 1.0f);
            CosmeticParticles.set(c[2], uv[2], cx + a2.x + b.x, cy + a2.y + b.y, cz + a2.z + b.z, u1, 0.0f);
            CosmeticParticles.set(c[3], uv[3], cx - a2.x + b.x, cy - a2.y + b.y, cz - a2.z + b.z, u0, 0.0f);
            int color = CosmeticParticles.tint(p, t);
            byte r = (byte)(color >> 16);
            byte g = (byte)(color >> 8);
            byte bl = (byte)color;
            byte al = (byte)Math.round(Math.min(1.0f, fade * 0.7f) * 255.0f);
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

    private static void quads(List<P> list, MatrixStack.Entry entry, VertexConsumer vc, Vec3d cam, Quaternionf q, boolean additive) {
        Vector3f right = q.transform(new Vector3f(1.0f, 0.0f, 0.0f));
        Vector3f up = q.transform(new Vector3f(0.0f, 1.0f, 0.0f));
        Vector3f normal = q.transform(new Vector3f(0.0f, 0.0f, 1.0f));
        Vector3f a2 = new Vector3f();
        Vector3f b = new Vector3f();
        int light = 0xF000F0;
        int overlay = OverlayTexture.field_21444;
        for (P p : list) {
            int argb;
            float t = p.age / p.life;
            float fade = CosmeticParticles.fade(p, t);
            float size = p.size * CosmeticParticles.scale(p, t);
            int color = CosmeticParticles.tint(p, t);
            int r = color >> 16 & 0xFF;
            int g = color >> 8 & 0xFF;
            int bl = color & 0xFF;
            if (additive) {
                float k = fade * 1.25f;
                argb = 0xFF000000 | Math.min(255, (int)((float)r * k)) << 16 | Math.min(255, (int)((float)g * k)) << 8 | Math.min(255, (int)((float)bl * k));
            } else {
                argb = (int)(fade * 255.0f) << 24 | r << 16 | g << 8 | bl;
            }
            float rot = CosmeticParticles.angle(p);
            float c = (float)Math.cos(rot) * size;
            float s = (float)Math.sin(rot) * size;
            a2.set((Vector3fc)right).mul(c).add(up.x * s, up.y * s, up.z * s);
            b.set((Vector3fc)up).mul(c).sub(right.x * s, right.y * s, right.z * s);
            float cx = (float)(p.x - cam.field_1352);
            float cy = (float)(p.y - cam.field_1351);
            float cz = (float)(p.z - cam.field_1350);
            float u0 = (float)p.kind / 8.0f;
            float u1 = (float)(p.kind + 1) / 8.0f;
            CosmeticParticles.vertex(vc, entry, cx - a2.x - b.x, cy - a2.y - b.y, cz - a2.z - b.z, argb, u0, 1.0f, overlay, light, normal);
            CosmeticParticles.vertex(vc, entry, cx + a2.x - b.x, cy + a2.y - b.y, cz + a2.z - b.z, argb, u1, 1.0f, overlay, light, normal);
            CosmeticParticles.vertex(vc, entry, cx + a2.x + b.x, cy + a2.y + b.y, cz + a2.z + b.z, argb, u1, 0.0f, overlay, light, normal);
            CosmeticParticles.vertex(vc, entry, cx - a2.x + b.x, cy - a2.y + b.y, cz - a2.z + b.z, argb, u0, 0.0f, overlay, light, normal);
        }
    }

    private static void vertex(VertexConsumer vc, MatrixStack.Entry entry, float x, float y, float z, int argb, float u, float v, int overlay, int light, Vector3f n) {
        Vector3f p = entry.method_23761().transformPosition(x, y, z, VERTEX);
        vc.method_23919(p.x, p.y, p.z, argb, u, v, overlay, light, n.x, n.y, n.z);
    }

    static {
        SWAY = new float[]{0.015f, 0.07f, 0.03f, 0.05f, 0.04f, 0.06f, 0.02f, 0.14f};
        FREQ = new float[]{2.0f, 2.2f, 5.0f, 4.2f, 1.7f, 2.6f, 1.2f, 3.1f};
        TRI = new int[]{0, 1, 2, 0, 2, 3};
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

        private P() {
        }
    }
}

