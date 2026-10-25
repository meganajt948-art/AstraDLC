/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.NativeImageBackedTexture
 *  net.minecraft.util.Identifier
 *  org.joml.Matrix3f
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package flow.cosmetic;

import a.ezj;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.VideoTexture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

final class CosmeticLoader {
    private static final String ROOT = "/flow/cosmetics/";
    private static final String[] FACES = new String[]{"north", "south", "east", "west", "up", "down"};
    private static final float[][] NORMALS = new float[][]{{0.0f, 0.0f, -1.0f}, {0.0f, 0.0f, 1.0f}, {1.0f, 0.0f, 0.0f}, {-1.0f, 0.0f, 0.0f}, {0.0f, 1.0f, 0.0f}, {0.0f, -1.0f, 0.0f}};
    private static final Map<String, Integer> KINDS = Map.of("sparkle", 0, "spark", 0, "snow", 1, "ember", 2, "bubble", 3, "wisp", 4, "heart", 5, "smoke", 6, "petal", 7);
    private static final Map<CosmeticItem.Bone, List<Pending>> PENDING = new HashMap<CosmeticItem.Bone, List<Pending>>();
    private static final float INSET = 0.02f;
    private static final float LAYER = 0.015f;
    private static final Pattern CHAIN = Pattern.compile("(tail.*|t\\d+_\\d+|o\\d+_\\d+|hem\\d+|tip\\d*|lantern|crest|fluke|[lr]w_t\\d+_\\d+)");

    private CosmeticLoader() {
    }

    static List<CosmeticItem> loadIndex() {
        ArrayList<CosmeticItem> out = new ArrayList<CosmeticItem>();
        JsonObject index = CosmeticLoader.readJson("index.json");
        if (index == null) {
            return out;
        }
        for (JsonElement e : index.getAsJsonArray("items")) {
            String id = e.getAsString();
            try {
                JsonObject doc = CosmeticLoader.readJson(id + ".json");
                if (doc == null) continue;
                out.add(CosmeticLoader.parse(doc));
            }
            catch (Throwable t) {
                System.out.println("cosmetic " + id + " skipped: " + t);
            }
        }
        return out;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static JsonObject readJson(String name) {
        try (InputStream in = ezj.open(ROOT + name);){
            if (in == null) {
                JsonObject jsonObject2 = null;
                return jsonObject2;
            }
            JsonObject jsonObject = JsonParser.parseReader((Reader)new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonObject();
            return jsonObject;
        }
        catch (Exception e) {
            System.out.println("can't read cosmetic " + name + ": " + e);
            return null;
        }
    }

    private static float f(JsonObject o, String key, float def) {
        JsonElement e = o.get(key);
        return e == null || e.isJsonNull() ? def : e.getAsFloat();
    }

    private static String s(JsonObject o, String key, String def) {
        JsonElement e = o.get(key);
        return e == null || e.isJsonNull() ? def : e.getAsString();
    }

    private static float[] vec(JsonArray a2) {
        return new float[]{a2.get(0).getAsFloat(), a2.get(1).getAsFloat(), a2.get(2).getAsFloat()};
    }

    private static float[] floats(JsonArray a2) {
        float[] out = new float[6];
        out[3] = 1.0f;
        for (int i = 0; i < Math.min(6, a2.size()); ++i) {
            out[i] = a2.get(i).getAsFloat();
        }
        return out;
    }

    private static int color(String hex) {
        String h = hex.startsWith("#") ? hex.substring(1) : hex;
        return 0xFF000000 | Integer.parseInt(h, 16);
    }

    private static CosmeticItem parse(JsonObject doc) {
        JsonObject partsObj;
        String id = doc.get("id").getAsString();
        JsonObject tex = doc.getAsJsonObject("texture");
        int texW = tex.get("width").getAsInt();
        int texH = tex.get("height").getAsInt();
        int frames = tex.has("frames") ? tex.get("frames").getAsInt() : 1;
        float frameTime = (tex.has("frameTime") ? tex.get("frameTime").getAsFloat() : 2.0f) * 0.05f;
        String albedo = tex.get("albedo").getAsString();
        String emissive = tex.has("emissive") && !tex.get("emissive").isJsonNull() ? tex.get("emissive").getAsString() : null;
        float[] anchor = null;
        if (doc.has("anchor")) {
            float[] a2 = CosmeticLoader.vec(doc.getAsJsonArray("anchor"));
            anchor = new float[]{-a2[0], a2[1], a2[2]};
        }
        float gp = 0.0f;
        float gmin = 1.0f;
        float gmax = 1.0f;
        if (doc.has("glowPulse")) {
            JsonObject g = doc.getAsJsonObject("glowPulse");
            gp = CosmeticLoader.f(g, "period", 0.0f);
            gmin = CosmeticLoader.f(g, "min", 1.0f);
            gmax = CosmeticLoader.f(g, "max", 1.0f);
        }
        String accentHex = CosmeticLoader.s(doc, "accent", "#ffffff");
        boolean translucent = doc.has("translucent") && doc.get("translucent").getAsBoolean();
        boolean mesh = doc.has("mesh");
        JsonArray boneArr = mesh ? doc.getAsJsonObject("mesh").getAsJsonArray("bones") : doc.getAsJsonObject("geometry").getAsJsonArray("minecraft:geometry").get(0).getAsJsonObject().getAsJsonArray("bones");
        LinkedHashMap<String, Integer> index = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < boneArr.size(); ++i) {
            index.put(boneArr.get(i).getAsJsonObject().get("name").getAsString(), i);
        }
        CosmeticItem.Bone[] bones = new CosmeticItem.Bone[boneArr.size()];
        ArrayList<List<Pending>> perBone = new ArrayList<List<Pending>>();
        HashMap<Integer, String> roles = new HashMap<Integer, String>();
        for (int i = 0; i < boneArr.size(); ++i) {
            CosmeticItem.Bone bone;
            JsonObject b = boneArr.get(i).getAsJsonObject();
            float[] piv2 = CosmeticLoader.vec(b.getAsJsonArray("pivot"));
            Object rot = b.has("rotation") ? CosmeticLoader.vec(b.getAsJsonArray("rotation")) : new float[3];
            JsonElement par = b.get("parent");
            int parent = par != null && !par.isJsonNull() ? index.getOrDefault(par.getAsString(), -1) : -1;
            bones[i] = bone = new CosmeticItem.Bone(b.get("name").getAsString(), parent, mesh ? piv2[0] : -piv2[0], piv2[1], piv2[2], (float)rot[0], (float)rot[1], (float)rot[2]);
            ArrayList<Pending> quads = new ArrayList<Pending>();
            if (mesh || b.has("part")) {
                bone.part = CosmeticLoader.partIndex(CosmeticLoader.s(b, "part", "body"));
            }
            boolean bl = bone.video = b.has("video") && b.get("video").getAsBoolean();
            if (b.has("blink")) {
                bone.blinkU = b.getAsJsonArray("blink").get(0).getAsFloat();
                bone.blinkV = b.getAsJsonArray("blink").get(1).getAsFloat();
            }
            if (b.has("role")) {
                roles.put(i, b.get("role").getAsString());
            }
            if (mesh) {
                for (JsonElement qe : b.getAsJsonArray("quads")) {
                    CosmeticLoader.meshQuad(qe.getAsJsonArray(), quads);
                }
            } else if (b.has("cubes")) {
                for (JsonElement ce : b.getAsJsonArray("cubes")) {
                    CosmeticLoader.cube(ce.getAsJsonObject(), bone, texW, texH, quads);
                }
            }
            perBone.add(quads);
        }
        if (!mesh || !doc.getAsJsonObject("mesh").has("separate") || doc.getAsJsonObject("mesh").get("separate").getAsBoolean()) {
            CosmeticLoader.separate(bones, perBone);
        }
        CosmeticLoader.rig(bones, perBone, CosmeticLoader.s(doc, "slot", "wings"));
        block54: for (Map.Entry e : roles.entrySet()) {
            CosmeticItem.Bone b = bones[(Integer)e.getKey()];
            switch ((String)e.getValue()) {
                case "chain": {
                    b.role = 2;
                    continue block54;
                }
                case "ear": {
                    b.role = 3;
                    b.side = b.px < 0.0f ? -1 : 1;
                    continue block54;
                }
                case "head": {
                    b.role = 4;
                    continue block54;
                }
                case "blink": {
                    b.role = 5;
                    continue block54;
                }
                case "jiggle": 
                case "jiggle_l": 
                case "jiggle_r": 
                case "glute_l": 
                case "glute_r": {
                    b.role = 7;
                    b.side = switch ((String)e.getValue()) {
                        case "jiggle_l" -> 1;
                        case "jiggle_r" -> 2;
                        case "glute_l" -> 3;
                        case "glute_r" -> 4;
                        default -> 0;
                    };
                    continue block54;
                }
                case "show_hurt": 
                case "show_air": 
                case "show_happy": 
                case "hide_happy": {
                    b.role = 8;
                    b.side = ((String)e.getValue()).startsWith("hide") ? 3 : (((String)e.getValue()).endsWith("hurt") ? 0 : (((String)e.getValue()).endsWith("air") ? 1 : 2));
                    continue block54;
                }
                case "skirt_f": 
                case "skirt_b": 
                case "skirt_l": 
                case "skirt_r": {
                    b.role = 6;
                    b.side = "fblr".indexOf(((String)e.getValue()).charAt(6));
                    continue block54;
                }
            }
            b.role = 0;
        }
        CosmeticLoader.chains(bones, perBone);
        float[][] partPivots = null;
        JsonObject jsonObject = mesh && doc.getAsJsonObject("mesh").has("parts") ? doc.getAsJsonObject("mesh").getAsJsonObject("parts") : (partsObj = doc.has("parts") ? doc.getAsJsonObject("parts") : null);
        if (partsObj != null) {
            partPivots = new float[CosmeticItem.PARTS.length][];
            for (Map.Entry e : partsObj.entrySet()) {
                int pi = CosmeticLoader.partIndex((String)e.getKey());
                if (pi < 0) continue;
                partPivots[pi] = CosmeticLoader.vec(((JsonElement)e.getValue()).getAsJsonArray());
            }
        }
        float[] headFit = null;
        float[] backFit = null;
        if (doc.has("anchors")) {
            JsonObject an = doc.getAsJsonObject("anchors");
            headFit = an.has("head") ? CosmeticLoader.floats(an.getAsJsonArray("head")) : null;
            backFit = an.has("back") ? CosmeticLoader.floats(an.getAsJsonArray("back")) : null;
        }
        for (int i = 0; i < bones.length; ++i) {
            if (translucent) {
                PENDING.put(bones[i], (List)perBone.get(i));
                continue;
            }
            bones[i].solid = CosmeticLoader.pack((List)perBone.get(i));
            bones[i].glass = new float[0];
        }
        HashMap<String, CosmeticItem.Clip> clips = new HashMap<String, CosmeticItem.Clip>();
        if (doc.has("animations") && doc.get("animations").isJsonObject()) {
            for (Map.Entry st : doc.getAsJsonObject("animations").entrySet()) {
                JsonObject a3 = ((JsonElement)st.getValue()).getAsJsonObject();
                CosmeticItem.Clip clip = new CosmeticItem.Clip(CosmeticLoader.f(a3, "animation_length", 1.0f), bones.length);
                if (a3.has("bones")) {
                    for (Map.Entry be : a3.getAsJsonObject("bones").entrySet()) {
                        Integer bi = (Integer)index.get(be.getKey());
                        if (bi == null) continue;
                        for (Map.Entry ch : ((JsonElement)be.getValue()).getAsJsonObject().entrySet()) {
                            CosmeticItem.Track track = CosmeticLoader.track(((JsonElement)ch.getValue()).getAsJsonObject());
                            switch ((String)ch.getKey()) {
                                case "rotation": {
                                    clip.rotation[bi.intValue()] = track;
                                    break;
                                }
                                case "position": {
                                    clip.position[bi.intValue()] = track;
                                    break;
                                }
                                case "scale": {
                                    clip.scale[bi.intValue()] = track;
                                    break;
                                }
                            }
                        }
                    }
                }
                clips.put((String)st.getKey(), clip);
            }
        }
        ArrayList<CosmeticItem.Emitter> emitters = new ArrayList<CosmeticItem.Emitter>();
        if (doc.has("particles")) {
            for (JsonElement pe : doc.getAsJsonArray("particles")) {
                JsonObject p = pe.getAsJsonObject();
                Integer bi = (Integer)index.get(p.get("bone").getAsString());
                if (bi == null) continue;
                CosmeticItem.Bone bone = bones[bi];
                float[] off = CosmeticLoader.vec(p.getAsJsonArray("offset"));
                float[] vel = CosmeticLoader.vec(p.getAsJsonArray("velocity"));
                JsonArray life = p.getAsJsonArray("life");
                JsonArray size = p.getAsJsonArray("size");
                JsonArray cols = p.getAsJsonArray("colors");
                int[] colors = new int[cols.size()];
                for (int i = 0; i < colors.length; ++i) {
                    colors[i] = CosmeticLoader.color(cols.get(i).getAsString());
                }
                String kind = CosmeticLoader.s(p, "kind", "sparkle").toLowerCase(Locale.ROOT);
                boolean viewer = "viewer".equals(CosmeticLoader.s(p, "space", ""));
                float ox = viewer ? off[0] : -off[0];
                float vx = viewer ? vel[0] : -vel[0];
                emitters.add(new CosmeticItem.Emitter(bi, ox - bone.px, off[1] - bone.py, off[2] - bone.pz, CosmeticLoader.f(p, "rate", 1.0f), life.get(0).getAsFloat(), life.get(1).getAsFloat(), colors, size.get(0).getAsFloat(), size.get(1).getAsFloat(), vx, vel[1], vel[2], CosmeticLoader.f(p, "spread", 0.0f), CosmeticLoader.f(p, "gravity", 0.0f), KINDS.getOrDefault(kind, 0), !p.has("additive") || p.get("additive").getAsBoolean(), CosmeticLoader.f(p, "drag", 0.0f)));
            }
        }
        CosmeticItem item = new CosmeticItem(id, CosmeticLoader.s(doc, "name", id), CosmeticLoader.s(doc, "name_en", CosmeticLoader.s(doc, "name", id)), CosmeticLoader.s(doc, "description", ""), CosmeticLoader.s(doc, "description_en", CosmeticLoader.s(doc, "description", "")), CosmeticLoader.s(doc, "slot", "wings"), CosmeticLoader.s(doc, "attach", "body"), CosmeticLoader.color(accentHex), frames, frameTime, anchor, gp, gmin, gmax, bones, clips, emitters.toArray(new CosmeticItem.Emitter[0]), albedo, emissive);
        item.headFit = headFit;
        item.backFit = backFit;
        if (doc.has("video") && doc.get("video").isJsonObject()) {
            float[] fArray;
            JsonObject v = doc.getAsJsonObject("video");
            item.video = v.get("name").getAsString();
            if (v.has("rect")) {
                fArray = CosmeticLoader.floats(v.getAsJsonArray("rect"));
            } else {
                float[] fArray2 = new float[6];
                fArray2[0] = 0.0f;
                fArray2[1] = 0.0f;
                fArray2[2] = 1.0f;
                fArray2[3] = 1.0f;
                fArray2[4] = 0.0f;
                fArray = fArray2;
                fArray2[5] = 0.0f;
            }
            item.videoRect = fArray;
        }
        item.partPivots = partPivots;
        return item;
    }

    private static int partIndex(String name) {
        for (int i = 0; i < CosmeticItem.PARTS.length; ++i) {
            if (!CosmeticItem.PARTS[i].equals(name)) continue;
            return i;
        }
        return -1;
    }

    private static void meshQuad(JsonArray q, List<Pending> out) {
        if (q.size() < 23) {
            return;
        }
        float[] verts = new float[32];
        float nx = q.get(20).getAsFloat();
        float ny = q.get(21).getAsFloat();
        float nz = q.get(22).getAsFloat();
        float u0 = Float.MAX_VALUE;
        float v0 = Float.MAX_VALUE;
        for (int k = 0; k < 4; ++k) {
            int b = k * 8;
            verts[b] = q.get(k * 5).getAsFloat();
            verts[b + 1] = q.get(k * 5 + 1).getAsFloat();
            verts[b + 2] = q.get(k * 5 + 2).getAsFloat();
            verts[b + 3] = q.get(k * 5 + 3).getAsFloat();
            verts[b + 4] = q.get(k * 5 + 4).getAsFloat();
            boolean own = q.size() >= 32;
            verts[b + 5] = own ? q.get(20 + k * 3).getAsFloat() : nx;
            verts[b + 6] = own ? q.get(21 + k * 3).getAsFloat() : ny;
            verts[b + 7] = own ? q.get(22 + k * 3).getAsFloat() : nz;
            u0 = Math.min(u0, verts[b + 3]);
            v0 = Math.min(v0, verts[b + 4]);
        }
        out.add(new Pending(verts, -1, -1, 0, 0, u0, v0, CosmeticLoader.uvMax(verts, 3), CosmeticLoader.uvMax(verts, 4)));
    }

    private static float uvMax(float[] verts, int o) {
        float m = -3.4028235E38f;
        for (int k = 0; k < 4; ++k) {
            m = Math.max(m, verts[k * 8 + o]);
        }
        return m;
    }

    private static CosmeticItem.Track track(JsonObject keys) {
        ArrayList list = new ArrayList(keys.entrySet());
        list.sort((a2, b) -> Float.compare(Float.parseFloat((String)a2.getKey()), Float.parseFloat((String)b.getKey())));
        float[] times = new float[list.size()];
        float[] values = new float[list.size() * 3];
        for (int i = 0; i < list.size(); ++i) {
            float x;
            times[i] = Float.parseFloat((String)((Map.Entry)list.get(i)).getKey());
            JsonElement v = (JsonElement)((Map.Entry)list.get(i)).getValue();
            if (v.isJsonArray()) {
                float[] x2 = CosmeticLoader.vec(v.getAsJsonArray());
                values[3 * i] = x2[0];
                values[3 * i + 1] = x2[1];
                values[3 * i + 2] = x2[2];
                continue;
            }
            values[3 * i] = x = v.getAsFloat();
            values[3 * i + 1] = x;
            values[3 * i + 2] = x;
        }
        return new CosmeticItem.Track(times, values);
    }

    private static float[][] faceQuad(int face, float[] o, float[] s, float f) {
        float[][] fArrayArray;
        float x0 = -(o[0] + s[0]) - f;
        float y0 = o[1] - f;
        float z0 = o[2] - f;
        float x1 = -o[0] + f;
        float y1 = o[1] + s[1] + f;
        float z1 = o[2] + s[2] + f;
        switch (face) {
            case 0: {
                float[][] fArrayArray2 = new float[4][];
                fArrayArray2[0] = new float[]{x1, y1, z0};
                fArrayArray2[1] = new float[]{x0, y1, z0};
                fArrayArray2[2] = new float[]{x0, y0, z0};
                fArrayArray = fArrayArray2;
                fArrayArray2[3] = new float[]{x1, y0, z0};
                break;
            }
            case 1: {
                float[][] fArrayArray3 = new float[4][];
                fArrayArray3[0] = new float[]{x0, y1, z1};
                fArrayArray3[1] = new float[]{x1, y1, z1};
                fArrayArray3[2] = new float[]{x1, y0, z1};
                fArrayArray = fArrayArray3;
                fArrayArray3[3] = new float[]{x0, y0, z1};
                break;
            }
            case 2: {
                float[][] fArrayArray4 = new float[4][];
                fArrayArray4[0] = new float[]{x1, y1, z1};
                fArrayArray4[1] = new float[]{x1, y1, z0};
                fArrayArray4[2] = new float[]{x1, y0, z0};
                fArrayArray = fArrayArray4;
                fArrayArray4[3] = new float[]{x1, y0, z1};
                break;
            }
            case 3: {
                float[][] fArrayArray5 = new float[4][];
                fArrayArray5[0] = new float[]{x0, y1, z0};
                fArrayArray5[1] = new float[]{x0, y1, z1};
                fArrayArray5[2] = new float[]{x0, y0, z1};
                fArrayArray = fArrayArray5;
                fArrayArray5[3] = new float[]{x0, y0, z0};
                break;
            }
            case 4: {
                float[][] fArrayArray6 = new float[4][];
                fArrayArray6[0] = new float[]{x0, y1, z0};
                fArrayArray6[1] = new float[]{x1, y1, z0};
                fArrayArray6[2] = new float[]{x1, y1, z1};
                fArrayArray = fArrayArray6;
                fArrayArray6[3] = new float[]{x0, y1, z1};
                break;
            }
            default: {
                float[][] fArrayArray7 = new float[4][];
                fArrayArray7[0] = new float[]{x0, y0, z1};
                fArrayArray7[1] = new float[]{x1, y0, z1};
                fArrayArray7[2] = new float[]{x1, y0, z0};
                fArrayArray = fArrayArray7;
                fArrayArray7[3] = new float[]{x0, y0, z0};
            }
        }
        return fArrayArray;
    }

    static Matrix3f rotation(float rx, float ry, float rz) {
        return new Matrix3f().rotateZ((float)Math.toRadians(rz)).rotateY((float)Math.toRadians(-ry)).rotateX((float)Math.toRadians(-rx));
    }

    private static void cube(JsonObject c, CosmeticItem.Bone bone, int texW, int texH, List<Pending> out) {
        float[] o = CosmeticLoader.vec(c.getAsJsonArray("origin"));
        float[] s = CosmeticLoader.vec(c.getAsJsonArray("size"));
        float inflate = CosmeticLoader.f(c, "inflate", 0.0f);
        Matrix3f rot = null;
        Vector3f cp = null;
        if (c.has("rotation")) {
            float[] r = CosmeticLoader.vec(c.getAsJsonArray("rotation"));
            float[] p = c.has("pivot") ? CosmeticLoader.vec(c.getAsJsonArray("pivot")) : o;
            rot = CosmeticLoader.rotation(r[0], r[1], r[2]);
            cp = new Vector3f(-p[0], p[1], p[2]);
        }
        if (!c.has("uv") || !c.get("uv").isJsonObject()) {
            return;
        }
        JsonObject uvs = c.getAsJsonObject("uv");
        for (int fi = 0; fi < 6; ++fi) {
            JsonObject face;
            JsonObject jsonObject = face = uvs.has(FACES[fi]) ? uvs.getAsJsonObject(FACES[fi]) : null;
            if (face == null) continue;
            JsonArray uv = face.getAsJsonArray("uv");
            JsonArray size = face.getAsJsonArray("uv_size");
            float u = uv.get(0).getAsFloat();
            float v = uv.get(1).getAsFloat();
            float w = size.get(0).getAsFloat();
            float h = size.get(1).getAsFloat();
            float[][] q = CosmeticLoader.faceQuad(fi, o, s, inflate);
            if (CosmeticLoader.dist(q[0], q[1]) < 1.0E-6f || CosmeticLoader.dist(q[0], q[3]) < 1.0E-6f) continue;
            Vector3f n = new Vector3f(NORMALS[fi][0], NORMALS[fi][1], NORMALS[fi][2]);
            if (rot != null) {
                rot.transform(n);
            }
            float iu = Math.signum(w) * 0.02f;
            float iv = Math.signum(h) * 0.02f;
            float[][] tuv = new float[][]{{u + iu, v + iv}, {u + w - iu, v + iv}, {u + w - iu, v + h - iv}, {u + iu, v + h - iv}};
            float[] verts = new float[32];
            for (int k = 0; k < 4; ++k) {
                Vector3f p = new Vector3f(q[k][0], q[k][1], q[k][2]);
                if (rot != null) {
                    p.sub((Vector3fc)cp);
                    rot.transform(p);
                    p.add((Vector3fc)cp);
                }
                int b = k * 8;
                verts[b] = p.x - bone.px;
                verts[b + 1] = p.y - bone.py;
                verts[b + 2] = p.z - bone.pz;
                verts[b + 3] = tuv[k][0] / (float)texW;
                verts[b + 4] = tuv[k][1] / (float)texH;
                verts[b + 5] = n.x;
                verts[b + 6] = n.y;
                verts[b + 7] = n.z;
            }
            out.add(new Pending(verts, (int)Math.floor(Math.min(u, u + w)), (int)Math.floor(Math.min(v, v + h)), (int)Math.ceil(Math.abs(w)), (int)Math.ceil(Math.abs(h))));
        }
    }

    static Matrix4f[] rest(CosmeticItem.Bone[] bones) {
        Matrix4f[] out = new Matrix4f[bones.length];
        for (int i = 0; i < bones.length; ++i) {
            CosmeticItem.Bone b = bones[i];
            boolean nested = b.parent >= 0 && b.parent < i;
            Matrix4f m = nested ? new Matrix4f((Matrix4fc)out[b.parent]) : new Matrix4f();
            float ppx = nested ? bones[b.parent].px : 0.0f;
            float ppy = nested ? bones[b.parent].py : 0.0f;
            float ppz = nested ? bones[b.parent].pz : 0.0f;
            m.translate(b.px - ppx, b.py - ppy, b.pz - ppz).rotateZ((float)Math.toRadians(b.rz)).rotateY((float)Math.toRadians(-b.ry)).rotateX((float)Math.toRadians(-b.rx));
            out[i] = m;
        }
        return out;
    }

    private static void separate(CosmeticItem.Bone[] bones, List<List<Pending>> perBone) {
        int i;
        Matrix4f[] rest = CosmeticLoader.rest(bones);
        ArrayList<Face> faces = new ArrayList<Face>();
        for (i = 0; i < bones.length; ++i) {
            for (Pending q : perBone.get(i)) {
                faces.add(new Face(q, rest[i]));
            }
        }
        for (i = 0; i < faces.size(); ++i) {
            Face a2 = (Face)faces.get(i);
            for (int j = 0; j < i; ++j) {
                Face b = (Face)faces.get(j);
                float dot = a2.n.dot((Vector3fc)b.n);
                if (Math.abs(dot) < 0.9995f || Math.abs(a2.d - Math.signum(dot) * b.d) > 0.002f || !CosmeticLoader.overlap(a2, b)) continue;
                a2.layer = Math.max(a2.layer, dot > 0.0f ? b.layer + 1 : 1);
            }
        }
        for (Face f : faces) {
            if (f.layer == 0) continue;
            float[] v = f.quad.verts;
            float k = (float)f.layer * 0.015f;
            for (int c = 0; c < 4; ++c) {
                int n = c * 8;
                v[n] = v[n] + v[5] * k;
                int n2 = c * 8 + 1;
                v[n2] = v[n2] + v[6] * k;
                int n3 = c * 8 + 2;
                v[n3] = v[n3] + v[7] * k;
            }
        }
    }

    private static boolean overlap(Face a2, Face b) {
        Vector3f u = new Vector3f((Vector3fc)a2.p[1]).sub((Vector3fc)a2.p[0]);
        if (u.lengthSquared() < 1.0E-10f) {
            return false;
        }
        u.normalize();
        Vector3f w = new Vector3f((Vector3fc)a2.n).cross((Vector3fc)u).normalize();
        float[][] pa = new float[4][2];
        float[][] pb = new float[4][2];
        for (int k = 0; k < 4; ++k) {
            pa[k][0] = a2.p[k].dot((Vector3fc)u);
            pa[k][1] = a2.p[k].dot((Vector3fc)w);
            pb[k][0] = b.p[k].dot((Vector3fc)u);
            pb[k][1] = b.p[k].dot((Vector3fc)w);
        }
        return !CosmeticLoader.separated(pa, pa, pb) && !CosmeticLoader.separated(pb, pa, pb);
    }

    private static boolean separated(float[][] edges, float[][] pa, float[][] pb) {
        for (int k = 0; k < 4; ++k) {
            float ex = edges[(k + 1) % 4][0] - edges[k][0];
            float ey = edges[(k + 1) % 4][1] - edges[k][1];
            float len = (float)Math.sqrt(ex * ex + ey * ey);
            if (len < 1.0E-6f) continue;
            float ax = -ey / len;
            float ay = ex / len;
            float amin = Float.MAX_VALUE;
            float amax = -3.4028235E38f;
            float bmin = Float.MAX_VALUE;
            float bmax = -3.4028235E38f;
            for (int c = 0; c < 4; ++c) {
                float x = pa[c][0] * ax + pa[c][1] * ay;
                float y = pb[c][0] * ax + pb[c][1] * ay;
                amin = Math.min(amin, x);
                amax = Math.max(amax, x);
                bmin = Math.min(bmin, y);
                bmax = Math.max(bmax, y);
            }
            if (!(Math.min(amax, bmax) - Math.max(amin, bmin) < 0.001f)) continue;
            return true;
        }
        return false;
    }

    private static void rig(CosmeticItem.Bone[] bones, List<List<Pending>> perBone, String slot) {
        for (int i = 0; i < bones.length; ++i) {
            CosmeticItem.Bone b = bones[i];
            String n = b.name.toLowerCase(Locale.ROOT);
            if ("wings".equals(slot) && b.parent < 0 && (n.startsWith("lw_") || n.startsWith("rw_"))) {
                b.role = 1;
                b.side = n.startsWith("lw_") ? -1 : 1;
                continue;
            }
            if (CHAIN.matcher(n).matches()) {
                b.role = 2;
                continue;
            }
            if (n.equals("ear_l") || n.equals("le")) {
                b.role = 3;
                b.side = -1;
                continue;
            }
            if (n.equals("ear_r") || n.equals("re")) {
                b.role = 3;
                b.side = 1;
                continue;
            }
            if (!"pet".equals(slot) || !n.equals("head") && !n.equals("cam")) continue;
            b.role = 4;
        }
    }

    private static void chains(CosmeticItem.Bone[] bones, List<List<Pending>> perBone) {
        for (int pass = 0; pass < 2; ++pass) {
            for (CosmeticItem.Bone b : bones) {
                if (b.role != 2 && b.role != 6) continue;
                CosmeticItem.Bone p = b.parent >= 0 ? bones[b.parent] : null;
                boolean linked = p != null && (p.role == 2 || p.role == 6);
                b.depth = linked ? Math.min(12, p.depth + 1) : 0;
            }
        }
        for (int i = 0; i < bones.length; ++i) {
            CosmeticItem.Bone b = bones[i];
            if (b.role != 2 && b.role != 6) continue;
            Vector3f h = null;
            for (int j = 0; j < bones.length; ++j) {
                if (bones[j].parent != i) continue;
                h = new Vector3f(bones[j].px - b.px, bones[j].py - b.py, bones[j].pz - b.pz);
                break;
            }
            if (h == null || h.lengthSquared() < 1.0E-6f) {
                h = new Vector3f();
                int count = 0;
                for (Pending q : perBone.get(i)) {
                    for (int k = 0; k < 4; ++k) {
                        h.add(q.verts[k * 8], q.verts[k * 8 + 1], q.verts[k * 8 + 2]);
                        ++count;
                    }
                }
                if (count > 0) {
                    h.div((float)count);
                }
            }
            if (h.lengthSquared() < 1.0E-6f) {
                h.set(0.0f, -1.0f, 0.0f);
            }
            h.normalize();
            b.hx = h.x;
            b.hy = h.y;
            b.hz = h.z;
        }
    }

    private static float dist(float[] a2, float[] b) {
        float dx = a2[0] - b[0];
        float dy = a2[1] - b[1];
        float dz = a2[2] - b[2];
        return (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    private static float[] pack(List<Pending> quads) {
        float[] out = new float[quads.size() * 32];
        for (int i = 0; i < quads.size(); ++i) {
            System.arraycopy(quads.get((int)i).verts, 0, out, i * 32, 32);
        }
        return out;
    }

    static void ensureTextures(CosmeticItem item) {
        if (item.loaded || item.failed) {
            return;
        }
        try {
            NativeImage em;
            NativeImage albedo = CosmeticLoader.image(item.albedoPath);
            if (albedo == null) {
                item.failed = true;
                return;
            }
            for (CosmeticItem.Bone bone : item.bones) {
                List<Pending> quads = PENDING.remove(bone);
                if (quads == null) {
                    if (bone.solid != null) continue;
                    bone.solid = new float[0];
                    bone.glass = new float[0];
                    continue;
                }
                ArrayList<Pending> solid = new ArrayList<Pending>();
                ArrayList<Pending> glass = new ArrayList<Pending>();
                for (Pending p : quads) {
                    (CosmeticLoader.translucent(albedo, p) ? glass : solid).add(p);
                }
                bone.solid = CosmeticLoader.pack(solid);
                bone.glass = CosmeticLoader.pack(glass);
            }
            MinecraftClient mc = MinecraftClient.getInstance();
            item.albedo = Identifier.of((String)"flow2", (String)("cosmetic/" + item.id));
            mc.getTextureManager().registerTexture(item.albedo, (AbstractTexture)new NativeImageBackedTexture(() -> "Flow2 cosmetic " + item.id, albedo));
            if (item.emissivePath != null && (em = CosmeticLoader.image(item.emissivePath)) != null) {
                item.emissive = Identifier.of((String)"flow2", (String)("cosmetic/" + item.id + "_e"));
                mc.getTextureManager().registerTexture(item.emissive, (AbstractTexture)new NativeImageBackedTexture(() -> "Flow2 cosmetic glow " + item.id, em));
            }
            if (item.video != null) {
                int vw = Math.round(item.videoRect[4] > 0.0f ? item.videoRect[4] : 256.0f);
                int vh = Math.round(item.videoRect[5] > 0.0f ? item.videoRect[5] : 256.0f);
                item.videoTexture = new VideoTexture(item.video, vw, vh, mc.getTextureManager().getTexture(item.albedo));
                item.videoId = Identifier.of((String)"flow2", (String)("cosmetic/" + item.id + "_video"));
                mc.getTextureManager().registerTexture(item.videoId, (AbstractTexture)item.videoTexture);
            }
            item.loaded = true;
        }
        catch (Throwable t) {
            item.failed = true;
            System.out.println("cosmetic " + item.id + " textures failed: " + t);
        }
    }

    static NativeImage image(String name) {
        NativeImage nativeImage;
        block8: {
            InputStream in = ezj.open(ROOT + name);
            try {
                NativeImage nativeImage2 = nativeImage = in == null ? null : NativeImage.read((InputStream)in);
                if (in == null) break block8;
            }
            catch (Throwable throwable) {
                try {
                    if (in != null) {
                        try {
                            in.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                catch (Exception e) {
                    System.out.println("can't read cosmetic texture " + name + ": " + e);
                    return null;
                }
            }
            in.close();
        }
        return nativeImage;
    }

    private static boolean translucent(NativeImage img, Pending p) {
        int y1;
        int x1;
        if (p.nu0 >= 0.0f) {
            x0 = Math.max(0, (int)Math.floor(p.nu0 * (float)img.getWidth()));
            y0 = Math.max(0, (int)Math.floor(p.nv0 * (float)img.getHeight()));
            x1 = Math.min(img.getWidth(), (int)Math.ceil(p.nu1 * (float)img.getWidth()));
            y1 = Math.min(img.getHeight(), (int)Math.ceil(p.nv1 * (float)img.getHeight()));
        } else {
            x0 = Math.max(0, p.u);
            y0 = Math.max(0, p.v);
            x1 = Math.min(img.getWidth(), p.u + p.w);
            y1 = Math.min(img.getHeight(), p.v + p.h);
        }
        for (int y = y0; y < y1; ++y) {
            for (int x = x0; x < x1; ++x) {
                int a2 = img.getColorArgb(x, y) >>> 24;
                if (a2 <= 6 || a2 >= 248) continue;
                return true;
            }
        }
        return false;
    }

    private record Pending(float[] verts, int u, int v, int w, int h, float nu0, float nv0, float nu1, float nv1) {
        Pending(float[] verts, int u, int v, int w, int h) {
            this(verts, u, v, w, h, -1.0f, -1.0f, -1.0f, -1.0f);
        }
    }

    private static final class Face {
        final Pending quad;
        final Vector3f[] p = new Vector3f[4];
        final Vector3f n = new Vector3f();
        final float d;
        int layer;

        Face(Pending quad, Matrix4f m) {
            this.quad = quad;
            float[] v = quad.verts;
            for (int k = 0; k < 4; ++k) {
                this.p[k] = m.transformPosition(v[k * 8], v[k * 8 + 1], v[k * 8 + 2], new Vector3f());
            }
            m.transformDirection(v[5], v[6], v[7], this.n);
            if (this.n.lengthSquared() > 1.0E-12f) {
                this.n.normalize();
            }
            this.d = this.n.dot((Vector3fc)this.p[0]);
        }
    }
}

