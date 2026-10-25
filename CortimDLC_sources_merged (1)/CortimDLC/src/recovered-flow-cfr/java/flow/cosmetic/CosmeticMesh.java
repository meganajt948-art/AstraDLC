/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.OverlayTexture
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  org.joml.Matrix3f
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector4f
 */
package flow.cosmetic;

import flow.cosmetic.CosmeticItem;
import java.nio.ByteBuffer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
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
        if (c == null || w <= 1.0E-4f) {
            return n;
        }
        for (int k = 0; k < n; ++k) {
            if (cl[k] != c) continue;
            int n2 = k;
            ws[n2] = ws[n2] + w;
            return n;
        }
        cl[n] = c;
        ts[n] = CosmeticMesh.wrap(t, c.length);
        ws[n] = w;
        return n + 1;
    }

    static Matrix4f[] pose(CosmeticItem item, Drive d) {
        int k;
        CosmeticItem.Clip[] cl = new CosmeticItem.Clip[3];
        float[] ts = new float[3];
        float[] ws = new float[3];
        int n = 0;
        n = CosmeticMesh.add(cl, ts, ws, n, CosmeticMesh.clip(item, "idle"), d.tIdle, d.wIdle);
        n = CosmeticMesh.add(cl, ts, ws, n, CosmeticMesh.clip(item, "walk"), d.tWalk, d.wWalk);
        n = CosmeticMesh.add(cl, ts, ws, n, CosmeticMesh.clip(item, "fly"), d.tFly, d.wFly);
        float total = 0.0f;
        for (k = 0; k < n; ++k) {
            total += ws[k];
        }
        k = 0;
        while (k < n && total > 1.0E-5f) {
            int n2 = k++;
            ws[n2] = ws[n2] / total;
        }
        CosmeticItem.Clip sneak = d.wSneak > 0.001f ? item.clips.get("sneak") : null;
        CosmeticItem.Clip air = d.wAir > 0.001f ? item.clips.get("air") : null;
        CosmeticItem.Clip attack = d.wAttack > 0.001f ? item.clips.get("attack") : null;
        Matrix4f root = CosmeticMesh.rootOf(item, d);
        CosmeticItem.Bone[] bones = item.bones;
        Matrix4f[] out = new Matrix4f[bones.length];
        float[] r = new float[3];
        float[] p = new float[3];
        float[] s = new float[3];
        Vector3f origin = new Vector3f();
        for (int i = 0; i < bones.length; ++i) {
            CosmeticItem.Bone b = bones[i];
            r[2] = 0.0f;
            r[1] = 0.0f;
            r[0] = 0.0f;
            p[2] = 0.0f;
            p[1] = 0.0f;
            p[0] = 0.0f;
            s[2] = n == 0 ? 1.0f : 0.0f;
            s[1] = s[2];
            s[0] = s[2];
            for (int k2 = 0; k2 < n; ++k2) {
                CosmeticMesh.accumulate(cl[k2].rotation[i], ts[k2], ws[k2], 0.0f, r);
                CosmeticMesh.accumulate(cl[k2].position[i], ts[k2], ws[k2], 0.0f, p);
                CosmeticMesh.accumulate(cl[k2].scale[i], ts[k2], ws[k2], 1.0f, s);
            }
            CosmeticMesh.layer(sneak, i, d.tIdle, d.wSneak, r, p);
            CosmeticMesh.layer(air, i, d.tIdle, d.wAir, r, p);
            CosmeticMesh.layer(attack, i, d.tIdle, d.wAttack, r, p);
            float rx = b.rx + r[0];
            float ry = b.ry + r[1];
            float rz = b.rz + r[2];
            if (d.cape != null && "cape".equals(b.name)) {
                rx += d.cape[0];
                ry += d.cape[1];
                rz += d.cape[2];
            }
            boolean nested = b.parent >= 0 && out[b.parent] != null && bones[b.parent].part == b.part;
            Matrix4f m = nested ? new Matrix4f((Matrix4fc)out[b.parent]) : new Matrix4f((Matrix4fc)root);
            float ppx = nested ? bones[b.parent].px : 0.0f;
            float ppy = nested ? bones[b.parent].py : 0.0f;
            float ppz = nested ? bones[b.parent].pz : 0.0f;
            m.translate(b.px - ppx - p[0], b.py - ppy + p[1], b.pz - ppz + p[2]).rotateZ((float)Math.toRadians(rz)).rotateY((float)Math.toRadians(-ry)).rotateX((float)Math.toRadians(-rx)).scale(s[0], s[1], s[2]);
            switch (b.role) {
                case 1: {
                    Matrix4f q = Q.identity().rotateY((float)Math.toRadians((float)(-b.side) * d.sweep + d.turn)).rotateZ((float)Math.toRadians((float)b.side * d.lift));
                    CosmeticMesh.about(m, q, origin);
                    break;
                }
                case 2: {
                    CosmeticMesh.drag(m, b, d, origin);
                    break;
                }
                case 6: {
                    float a2;
                    float front = Math.max(0.0f, -Math.min(d.legL, d.legR));
                    float back = Math.max(0.0f, Math.max(d.legL, d.legR));
                    switch (b.side) {
                        case 0: {
                            float f = front * 0.9f;
                            break;
                        }
                        case 1: {
                            float f = -back * 0.9f;
                            break;
                        }
                        default: {
                            float f = a2 = 0.0f;
                        }
                    }
                    if (b.side >= 2) {
                        float spread = (front + back) * 0.22f;
                        CosmeticMesh.about(m, Q.identity().rotateZ(b.side == 2 ? -spread : spread), origin);
                    } else if (Math.abs(a2) > 1.0E-4f) {
                        CosmeticMesh.about(m, Q.identity().rotateX(a2), origin);
                    }
                    CosmeticMesh.drag(m, b, d, origin);
                    break;
                }
                case 7: {
                    CosmeticMesh.jiggle(m, b, d, origin);
                    break;
                }
                case 8: {
                    boolean on;
                    switch (b.side) {
                        case 0: {
                            boolean bl = d.hurt;
                            break;
                        }
                        case 1: {
                            boolean bl = d.air;
                            break;
                        }
                        case 3: {
                            boolean bl;
                            if (!d.happy || d.hurt || d.air) {
                                bl = true;
                                break;
                            }
                            bl = false;
                            break;
                        }
                        default: {
                            boolean bl = on = d.happy && !d.hurt && !d.air;
                        }
                    }
                    if (on) break;
                    CosmeticMesh.about(m, Q.identity().scale(0.001f), origin);
                    break;
                }
                case 5: {
                    if (d.blink && (!d.happy || d.hurt || d.air)) break;
                    CosmeticMesh.about(m, Q.identity().scale(1.0f, 0.001f, 1.0f), origin);
                    break;
                }
                case 3: {
                    if (!(Math.abs(d.twitch) > 0.01f)) break;
                    CosmeticMesh.about(m, Q.identity().rotateZ((float)Math.toRadians((float)(-b.side) * d.twitch)), origin);
                    break;
                }
                case 4: {
                    if (!(Math.abs(d.lookYaw) > 0.01f) && !(Math.abs(d.lookPitch) > 0.01f)) break;
                    CosmeticMesh.about(m, Q.identity().rotateY((float)Math.toRadians(-d.lookYaw)).rotateX((float)Math.toRadians(-d.lookPitch)), origin);
                    break;
                }
            }
            out[i] = m;
        }
        return out;
    }

    private static void jiggle(Matrix4f m, CosmeticItem.Bone b, Drive d, Vector3f origin) {
        float j = d.jiggle;
        if (b.side == 0) {
            m.translate(0.0f, j * 0.7f, 0.0f).rotateX((float)Math.toRadians(j * 11.0f)).rotateZ((float)Math.toRadians(d.sway));
            return;
        }
        if (b.side <= 2) {
            float leg = b.side == 1 ? d.legL : d.legR;
            float lag = b.side == 1 ? 1.0f : 0.8f;
            CosmeticMesh.about(m, Q.identity().translation(0.0f, j * 0.75f * lag, 0.0f).rotateX((float)Math.toRadians(j * 12.0f * lag + leg * 5.0f)).rotateZ((float)Math.toRadians(d.sway * 1.2f + (b.side == 1 ? -1.0f : 1.0f) * Math.abs(j) * 2.0f)), origin);
            return;
        }
        float leg = b.side == 3 ? d.legL : d.legR;
        CosmeticMesh.about(m, Q.identity().translation(0.0f, j * 0.5f + Math.max(0.0f, leg) * 0.9f, 0.0f).rotateX(-leg * 0.32f - (float)Math.toRadians(j * 7.0f)).rotateZ((float)Math.toRadians(d.sway * 0.8f)), origin);
    }

    private static void layer(CosmeticItem.Clip c, int i, float t, float w, float[] r, float[] p) {
        if (c == null) {
            return;
        }
        float tt = CosmeticMesh.wrap(t, c.length);
        if (c.rotation[i] != null) {
            CosmeticMesh.accumulate(c.rotation[i], tt, w, 0.0f, r);
        }
        if (c.position[i] != null) {
            CosmeticMesh.accumulate(c.position[i], tt, w, 0.0f, p);
        }
    }

    private static void drag(Matrix4f m, CosmeticItem.Bone b, Drive d, Vector3f origin) {
        Vector3f h = m.transformDirection(b.hx, b.hy, b.hz, DRAG_H);
        if (h.lengthSquared() > 1.0E-8f) {
            Vector3f axis;
            float len;
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
            if ((len = (axis = h.cross(dx, dy, dz, DRAG_AXIS)).length()) > 1.0E-4f) {
                float reach = 1.0f + 0.05f * (float)Math.min(b.depth, 6);
                float angle = Math.min(CHAIN_MAX * reach, len * CHAIN_GAIN * reach);
                CosmeticMesh.about(m, Q.identity().rotation(angle, (Vector3fc)axis.div(len)), origin);
            }
        }
    }

    private static Matrix4f rootOf(CosmeticItem item, Drive d) {
        Matrix4f root = new Matrix4f();
        if (item.isPet()) {
            if (Math.abs(d.roll) > 0.01f || Math.abs(d.pitch) > 0.01f) {
                root.rotateZ((float)Math.toRadians(-d.roll)).rotateX((float)Math.toRadians(d.pitch));
            }
        } else if (item.isBack()) {
            root.translate(0.0f, 24.0f + d.bob, 2.0f).rotateX((float)Math.toRadians(-d.tilt)).translate(0.0f, -24.0f, -2.0f);
        }
        return root;
    }

    private static void about(Matrix4f m, Matrix4f q, Vector3f scratch) {
        m.getTranslation(scratch);
        Matrix4f local = ABOUT.translation((Vector3fc)scratch).mul((Matrix4fc)q).translate(-scratch.x, -scratch.y, -scratch.z);
        m.set((Matrix4fc)local.mul((Matrix4fc)m));
    }

    private static void accumulate(CosmeticItem.Track track, float t, float w, float def, float[] out) {
        if (track == null) {
            out[0] = out[0] + def * w;
            out[1] = out[1] + def * w;
            out[2] = out[2] + def * w;
            return;
        }
        track.sample(t, A);
        out[0] = out[0] + A[0] * w;
        out[1] = out[1] + A[1] * w;
        out[2] = out[2] + A[2] * w;
    }

    private static float wrap(float t, float length) {
        if (length <= 1.0E-4f) {
            return 0.0f;
        }
        float m = t % length;
        return m < 0.0f ? m + length : m;
    }

    static void emit(CosmeticItem item, Matrix4f[] bones, Matrix4f base, MatrixStack.Entry entry, VertexConsumer vc, int pass, int light, int argb, int frame) {
        CosmeticMesh.emit(item, bones, base, entry, vc, pass, light, argb, frame, -2, false);
    }

    static void emit(CosmeticItem item, Matrix4f[] bones, Matrix4f base, MatrixStack.Entry entry, VertexConsumer vc, int pass, int light, int argb, int frame, int part, boolean blink) {
        CosmeticMesh.emit(item, bones, base, entry, vc, pass, light, argb, frame, part, blink, false);
    }

    static void emit(CosmeticItem item, Matrix4f[] bones, Matrix4f base, MatrixStack.Entry entry, VertexConsumer vc, int pass, int light, int argb, int frame, int part, boolean blink, boolean liveVideo) {
        Matrix4f pos = E_POS.set((Matrix4fc)entry.method_23761()).mul((Matrix4fc)base);
        Matrix3f nrm = E_NRM.set((Matrix3fc)entry.method_23762()).mul((Matrix3fc)E_TMP.set((Matrix4fc)base).invert().transpose());
        int frames = Math.max(1, item.frames);
        float vScale = 1.0f / (float)frames;
        float vOff = (float)(frame % frames) / (float)frames;
        Vector4f p = E_P;
        Vector3f n = E_N;
        int overlay = OverlayTexture.field_21444;
        for (int i = 0; i < item.bones.length; ++i) {
            float bv;
            CosmeticItem.Bone bone = item.bones[i];
            if (part != -2 && bone.part != part || (pass == 3 ? !bone.video : bone.video && liveVideo)) continue;
            Matrix4f m = E_M.set((Matrix4fc)pos).mul((Matrix4fc)bones[i]);
            Matrix3f nm = E_NM.set((Matrix3fc)nrm).mul((Matrix3fc)E_TMP.set((Matrix4fc)bones[i]).invert().transpose());
            float bu = blink ? bone.blinkU : 0.0f;
            float f = bv = blink ? bone.blinkV : 0.0f;
            if (pass == 3) {
                CosmeticMesh.videoQuads(bone.solid, item.videoRect, m, nm, vc, p, n, argb, light, overlay);
                continue;
            }
            if (pass == 2) {
                CosmeticMesh.quads(bone.solid, m, nm, vc, p, n, argb, light, overlay, vScale, vOff, bu, bv);
                CosmeticMesh.quads(bone.glass, m, nm, vc, p, n, argb, light, overlay, vScale, vOff, bu, bv);
                continue;
            }
            CosmeticMesh.quads(pass == 1 ? bone.glass : bone.solid, m, nm, vc, p, n, argb, light, overlay, vScale, vOff, bu, bv);
        }
    }

    private static void videoQuads(float[] v, float[] r, Matrix4f m, Matrix3f nm, VertexConsumer vc, Vector4f p, Vector3f n, int argb, int light, int overlay) {
        if (v == null) {
            return;
        }
        float du = Math.max(1.0E-6f, r[2] - r[0]);
        float dv = Math.max(1.0E-6f, r[3] - r[1]);
        int k = 0;
        while (k + 7 < v.length) {
            p.set(v[k], v[k + 1], v[k + 2], 1.0f);
            m.transform(p);
            n.set(v[k + 5], v[k + 6], v[k + 7]);
            nm.transform(n);
            float len = n.length();
            if (len > 1.0E-6f) {
                n.div(len);
            }
            float u = Math.min(1.0f, Math.max(0.0f, (v[k + 3] - r[0]) / du));
            float w = Math.min(1.0f, Math.max(0.0f, (v[k + 4] - r[1]) / dv));
            vc.method_23919(p.x, p.y, p.z, argb, u, w, overlay, light, n.x, n.y, n.z);
            k += 8;
        }
    }

    private static void quads(float[] v, Matrix4f m, Matrix3f nm, VertexConsumer vc, Vector4f p, Vector3f n, int argb, int light, int overlay, float vScale, float vOff, float bu, float bv) {
        if (v == null) {
            return;
        }
        int k = 0;
        while (k + 7 < v.length) {
            p.set(v[k], v[k + 1], v[k + 2], 1.0f);
            m.transform(p);
            n.set(v[k + 5], v[k + 6], v[k + 7]);
            nm.transform(n);
            float len = n.length();
            if (len > 1.0E-6f) {
                n.div(len);
            }
            vc.method_23919(p.x, p.y, p.z, argb, v[k + 3] + bu, vOff + (v[k + 4] + bv) * vScale, overlay, light, n.x, n.y, n.z);
            k += 8;
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
        float vScale = 1.0f / (float)frames;
        float vOff = (float)(frame % frames) / (float)frames;
        int written = 0;
        Vector3f[] c = G_C;
        for (int i = 0; i < item.bones.length; ++i) {
            if (part != -2 && item.bones[i].part != part) continue;
            Matrix4f m = G_M.set((Matrix4fc)pose).mul((Matrix4fc)bones[i]);
            float bu = blink ? item.bones[i].blinkU : 0.0f;
            float bv = blink ? item.bones[i].blinkV : 0.0f;
            written += CosmeticMesh.glowQuads(item.bones[i].solid, m, out, argb, vScale, vOff, c, bu, bv);
            written += CosmeticMesh.glowQuads(item.bones[i].glass, m, out, argb, vScale, vOff, c, bu, bv);
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
        byte a2 = (byte)(argb >>> 24);
        int q = 0;
        while (q + 31 < v.length) {
            for (int k = 0; k < 4; ++k) {
                m.transformPosition(v[q + k * 8], v[q + k * 8 + 1], v[q + k * 8 + 2], c[k]);
            }
            for (int k : TRI) {
                int o = q + k * 8;
                out.putFloat(c[k].x).putFloat(c[k].y).putFloat(c[k].z);
                out.putFloat(v[o + 3] + bu).putFloat(vOff + (v[o + 4] + bv) * vScale);
                out.put(r).put(g).put(b).put(a2);
            }
            written += 6;
            q += 32;
        }
        return written;
    }

    static boolean hasGlass(CosmeticItem item) {
        for (CosmeticItem.Bone b : item.bones) {
            if (b.glass == null || b.glass.length <= 0) continue;
            return true;
        }
        return false;
    }

    static boolean hasSolid(CosmeticItem item) {
        for (CosmeticItem.Bone b : item.bones) {
            if (b.solid == null || b.solid.length <= 0) continue;
            return true;
        }
        return false;
    }

    static final class Drive {
        float wIdle = 1.0f;
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

        Drive() {
        }
    }
}

