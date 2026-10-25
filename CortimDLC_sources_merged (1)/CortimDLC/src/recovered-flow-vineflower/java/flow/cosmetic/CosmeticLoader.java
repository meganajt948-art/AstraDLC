package flow.cosmetic;

import a.ezj;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

final class CosmeticLoader {
   private static final String ROOT = "/flow/cosmetics/";
   private static final String[] FACES = new String[]{"north", "south", "east", "west", "up", "down"};
   private static final float[][] NORMALS = new float[][]{
      {0.0F, 0.0F, -1.0F}, {0.0F, 0.0F, 1.0F}, {1.0F, 0.0F, 0.0F}, {-1.0F, 0.0F, 0.0F}, {0.0F, 1.0F, 0.0F}, {0.0F, -1.0F, 0.0F}
   };
   private static final Map<String, Integer> KINDS = Map.of(
      "sparkle", 0, "spark", 0, "snow", 1, "ember", 2, "bubble", 3, "wisp", 4, "heart", 5, "smoke", 6, "petal", 7
   );
   private static final Map<CosmeticItem.Bone, List<CosmeticLoader.Pending>> PENDING = new HashMap<>();
   private static final float INSET = 0.02F;
   private static final float LAYER = 0.015F;
   private static final Pattern CHAIN = Pattern.compile("(tail.*|t\\d+_\\d+|o\\d+_\\d+|hem\\d+|tip\\d*|lantern|crest|fluke|[lr]w_t\\d+_\\d+)");

   private CosmeticLoader() {
   }

   static List<CosmeticItem> loadIndex() {
      List<CosmeticItem> out = new ArrayList<>();
      JsonObject index = readJson("index.json");
      if (index == null) {
         return out;
      }

      for (JsonElement e : index.getAsJsonArray("items")) {
         String id = e.getAsString();

         try {
            JsonObject doc = readJson(id + ".json");
            if (doc != null) {
               out.add(parse(doc));
            }
         } catch (Throwable t) {
            System.out.println("cosmetic " + id + " skipped: " + t);
         }
      }

      return out;
   }

   private static JsonObject readJson(String name) {
      try (InputStream in = ezj.open("/flow/cosmetics/" + name)) {
         return in == null ? null : JsonParser.parseReader(new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonObject();
      } catch (Exception e) {
         System.out.println("can't read cosmetic " + name + ": " + e);
         return null;
      }
   }

   private static float f(JsonObject o, String key, float def) {
      JsonElement e = o.get(key);
      return e != null && !e.isJsonNull() ? e.getAsFloat() : def;
   }

   private static String s(JsonObject o, String key, String def) {
      JsonElement e = o.get(key);
      return e != null && !e.isJsonNull() ? e.getAsString() : def;
   }

   private static float[] vec(JsonArray a) {
      return new float[]{a.get(0).getAsFloat(), a.get(1).getAsFloat(), a.get(2).getAsFloat()};
   }

   private static float[] floats(JsonArray a) {
      float[] out = new float[6];
      out[3] = 1.0F;

      for (int i = 0; i < Math.min(6, a.size()); i++) {
         out[i] = a.get(i).getAsFloat();
      }

      return out;
   }

   private static int color(String hex) {
      String h = hex.startsWith("#") ? hex.substring(1) : hex;
      return 0xFF000000 | Integer.parseInt(h, 16);
   }

   private static CosmeticItem parse(JsonObject doc) {
      String id = doc.get("id").getAsString();
      JsonObject tex = doc.getAsJsonObject("texture");
      int texW = tex.get("width").getAsInt();
      int texH = tex.get("height").getAsInt();
      int frames = tex.has("frames") ? tex.get("frames").getAsInt() : 1;
      float frameTime = (tex.has("frameTime") ? tex.get("frameTime").getAsFloat() : 2.0F) * 0.05F;
      String albedo = tex.get("albedo").getAsString();
      String emissive = tex.has("emissive") && !tex.get("emissive").isJsonNull() ? tex.get("emissive").getAsString() : null;
      float[] anchor = null;
      if (doc.has("anchor")) {
         float[] a = vec(doc.getAsJsonArray("anchor"));
         anchor = new float[]{-a[0], a[1], a[2]};
      }

      float gp = 0.0F;
      float gmin = 1.0F;
      float gmax = 1.0F;
      if (doc.has("glowPulse")) {
         JsonObject g = doc.getAsJsonObject("glowPulse");
         gp = f(g, "period", 0.0F);
         gmin = f(g, "min", 1.0F);
         gmax = f(g, "max", 1.0F);
      }

      String accentHex = s(doc, "accent", "#ffffff");
      boolean translucent = doc.has("translucent") && doc.get("translucent").getAsBoolean();
      boolean mesh = doc.has("mesh");
      JsonArray boneArr = mesh
         ? doc.getAsJsonObject("mesh").getAsJsonArray("bones")
         : doc.getAsJsonObject("geometry").getAsJsonArray("minecraft:geometry").get(0).getAsJsonObject().getAsJsonArray("bones");
      Map<String, Integer> index = new LinkedHashMap<>();

      for (int i = 0; i < boneArr.size(); i++) {
         index.put(boneArr.get(i).getAsJsonObject().get("name").getAsString(), i);
      }

      CosmeticItem.Bone[] bones = new CosmeticItem.Bone[boneArr.size()];
      List<List<CosmeticLoader.Pending>> perBone = new ArrayList<>();
      Map<Integer, String> roles = new HashMap<>();

      for (int i = 0; i < boneArr.size(); i++) {
         JsonObject b = boneArr.get(i).getAsJsonObject();
         float[] piv = vec(b.getAsJsonArray("pivot"));
         float[] rot = b.has("rotation") ? vec(b.getAsJsonArray("rotation")) : new float[3];
         JsonElement par = b.get("parent");
         int parent = par != null && !par.isJsonNull() ? index.getOrDefault(par.getAsString(), -1) : -1;
         CosmeticItem.Bone bone = new CosmeticItem.Bone(b.get("name").getAsString(), parent, mesh ? piv[0] : -piv[0], piv[1], piv[2], rot[0], rot[1], rot[2]);
         bones[i] = bone;
         List<CosmeticLoader.Pending> quads = new ArrayList<>();
         if (mesh || b.has("part")) {
            bone.part = partIndex(s(b, "part", "body"));
         }

         bone.video = b.has("video") && b.get("video").getAsBoolean();
         if (b.has("blink")) {
            bone.blinkU = b.getAsJsonArray("blink").get(0).getAsFloat();
            bone.blinkV = b.getAsJsonArray("blink").get(1).getAsFloat();
         }

         if (b.has("role")) {
            roles.put(i, b.get("role").getAsString());
         }

         if (mesh) {
            for (JsonElement qe : b.getAsJsonArray("quads")) {
               meshQuad(qe.getAsJsonArray(), quads);
            }
         } else if (b.has("cubes")) {
            for (JsonElement ce : b.getAsJsonArray("cubes")) {
               cube(ce.getAsJsonObject(), bone, texW, texH, quads);
            }
         }

         perBone.add(quads);
      }

      if (!mesh || !doc.getAsJsonObject("mesh").has("separate") || doc.getAsJsonObject("mesh").get("separate").getAsBoolean()) {
         separate(bones, perBone);
      }

      rig(bones, perBone, s(doc, "slot", "wings"));

      for (Entry<Integer, String> e : roles.entrySet()) {
         CosmeticItem.Bone b = bones[e.getKey()];
         switch ((String)e.getValue()) {
            case "chain":
               b.role = 2;
               break;
            case "ear":
               b.role = 3;
               b.side = b.px < 0.0F ? -1 : 1;
               break;
            case "head":
               b.role = 4;
               break;
            case "blink":
               b.role = 5;
               break;
            case "jiggle":
            case "jiggle_l":
            case "jiggle_r":
            case "glute_l":
            case "glute_r":
               b.role = 7;

               b.side = switch ((String)e.getValue()) {
                  case "jiggle_l" -> 1;
                  case "jiggle_r" -> 2;
                  case "glute_l" -> 3;
                  case "glute_r" -> 4;
                  default -> 0;
               };
               break;
            case "show_hurt":
            case "show_air":
            case "show_happy":
            case "hide_happy":
               b.role = 8;
               b.side = e.getValue().startsWith("hide") ? 3 : (e.getValue().endsWith("hurt") ? 0 : (e.getValue().endsWith("air") ? 1 : 2));
               break;
            case "skirt_f":
            case "skirt_b":
            case "skirt_l":
            case "skirt_r":
               b.role = 6;
               b.side = "fblr".indexOf(e.getValue().charAt(6));
               break;
            default:
               b.role = 0;
         }
      }

      chains(bones, perBone);
      float[][] partPivots = null;
      JsonObject partsObj = mesh && doc.getAsJsonObject("mesh").has("parts")
         ? doc.getAsJsonObject("mesh").getAsJsonObject("parts")
         : (doc.has("parts") ? doc.getAsJsonObject("parts") : null);
      if (partsObj != null) {
         partPivots = new float[CosmeticItem.PARTS.length][];

         for (Entry<String, JsonElement> e : partsObj.entrySet()) {
            int pi = partIndex(e.getKey());
            if (pi >= 0) {
               partPivots[pi] = vec(e.getValue().getAsJsonArray());
            }
         }
      }

      float[] headFit = null;
      float[] backFit = null;
      if (doc.has("anchors")) {
         JsonObject an = doc.getAsJsonObject("anchors");
         headFit = an.has("head") ? floats(an.getAsJsonArray("head")) : null;
         backFit = an.has("back") ? floats(an.getAsJsonArray("back")) : null;
      }

      for (int i = 0; i < bones.length; i++) {
         if (translucent) {
            PENDING.put(bones[i], perBone.get(i));
         } else {
            bones[i].solid = pack(perBone.get(i));
            bones[i].glass = new float[0];
         }
      }

      Map<String, CosmeticItem.Clip> clips = new HashMap<>();
      if (doc.has("animations") && doc.get("animations").isJsonObject()) {
         for (Entry<String, JsonElement> st : doc.getAsJsonObject("animations").entrySet()) {
            JsonObject a = st.getValue().getAsJsonObject();
            CosmeticItem.Clip clip = new CosmeticItem.Clip(f(a, "animation_length", 1.0F), bones.length);
            if (a.has("bones")) {
               for (Entry<String, JsonElement> be : a.getAsJsonObject("bones").entrySet()) {
                  Integer bi = index.get(be.getKey());
                  if (bi != null) {
                     for (Entry<String, JsonElement> ch : be.getValue().getAsJsonObject().entrySet()) {
                        CosmeticItem.Track track = track(ch.getValue().getAsJsonObject());
                        switch ((String)ch.getKey()) {
                           case "rotation":
                              clip.rotation[bi] = track;
                              break;
                           case "position":
                              clip.position[bi] = track;
                              break;
                           case "scale":
                              clip.scale[bi] = track;
                        }
                     }
                  }
               }
            }

            clips.put(st.getKey(), clip);
         }
      }

      List<CosmeticItem.Emitter> emitters = new ArrayList<>();
      if (doc.has("particles")) {
         for (JsonElement pe : doc.getAsJsonArray("particles")) {
            JsonObject p = pe.getAsJsonObject();
            Integer bi = index.get(p.get("bone").getAsString());
            if (bi != null) {
               CosmeticItem.Bone bone = bones[bi];
               float[] off = vec(p.getAsJsonArray("offset"));
               float[] vel = vec(p.getAsJsonArray("velocity"));
               JsonArray life = p.getAsJsonArray("life");
               JsonArray size = p.getAsJsonArray("size");
               JsonArray cols = p.getAsJsonArray("colors");
               int[] colors = new int[cols.size()];

               for (int i = 0; i < colors.length; i++) {
                  colors[i] = color(cols.get(i).getAsString());
               }

               String kind = s(p, "kind", "sparkle").toLowerCase(Locale.ROOT);
               boolean viewer = "viewer".equals(s(p, "space", ""));
               float ox = viewer ? off[0] : -off[0];
               float vx = viewer ? vel[0] : -vel[0];
               emitters.add(
                  new CosmeticItem.Emitter(
                     bi,
                     ox - bone.px,
                     off[1] - bone.py,
                     off[2] - bone.pz,
                     f(p, "rate", 1.0F),
                     life.get(0).getAsFloat(),
                     life.get(1).getAsFloat(),
                     colors,
                     size.get(0).getAsFloat(),
                     size.get(1).getAsFloat(),
                     vx,
                     vel[1],
                     vel[2],
                     f(p, "spread", 0.0F),
                     f(p, "gravity", 0.0F),
                     KINDS.getOrDefault(kind, 0),
                     !p.has("additive") || p.get("additive").getAsBoolean(),
                     f(p, "drag", 0.0F)
                  )
               );
            }
         }
      }

      CosmeticItem item = new CosmeticItem(
         id,
         s(doc, "name", id),
         s(doc, "name_en", s(doc, "name", id)),
         s(doc, "description", ""),
         s(doc, "description_en", s(doc, "description", "")),
         s(doc, "slot", "wings"),
         s(doc, "attach", "body"),
         color(accentHex),
         frames,
         frameTime,
         anchor,
         gp,
         gmin,
         gmax,
         bones,
         clips,
         emitters.toArray(new CosmeticItem.Emitter[0]),
         albedo,
         emissive
      );
      item.headFit = headFit;
      item.backFit = backFit;
      if (doc.has("video") && doc.get("video").isJsonObject()) {
         JsonObject v = doc.getAsJsonObject("video");
         item.video = v.get("name").getAsString();
         item.videoRect = v.has("rect") ? floats(v.getAsJsonArray("rect")) : new float[]{0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F};
      }

      item.partPivots = partPivots;
      return item;
   }

   private static int partIndex(String name) {
      for (int i = 0; i < CosmeticItem.PARTS.length; i++) {
         if (CosmeticItem.PARTS[i].equals(name)) {
            return i;
         }
      }

      return -1;
   }

   private static void meshQuad(JsonArray q, List<CosmeticLoader.Pending> out) {
      if (q.size() >= 23) {
         float[] verts = new float[32];
         float nx = q.get(20).getAsFloat();
         float ny = q.get(21).getAsFloat();
         float nz = q.get(22).getAsFloat();
         float u0 = Float.MAX_VALUE;
         float v0 = Float.MAX_VALUE;

         for (int k = 0; k < 4; k++) {
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

         out.add(new CosmeticLoader.Pending(verts, -1, -1, 0, 0, u0, v0, uvMax(verts, 3), uvMax(verts, 4)));
      }
   }

   private static float uvMax(float[] verts, int o) {
      float m = -Float.MAX_VALUE;

      for (int k = 0; k < 4; k++) {
         m = Math.max(m, verts[k * 8 + o]);
      }

      return m;
   }

   private static CosmeticItem.Track track(JsonObject keys) {
      List<Entry<String, JsonElement>> list = new ArrayList<>(keys.entrySet());
      list.sort((a, b) -> Float.compare(Float.parseFloat(a.getKey()), Float.parseFloat(b.getKey())));
      float[] times = new float[list.size()];
      float[] values = new float[list.size() * 3];

      for (int i = 0; i < list.size(); i++) {
         times[i] = Float.parseFloat(list.get(i).getKey());
         JsonElement v = list.get(i).getValue();
         if (v.isJsonArray()) {
            float[] x = vec(v.getAsJsonArray());
            values[3 * i] = x[0];
            values[3 * i + 1] = x[1];
            values[3 * i + 2] = x[2];
         } else {
            float x = v.getAsFloat();
            values[3 * i] = x;
            values[3 * i + 1] = x;
            values[3 * i + 2] = x;
         }
      }

      return new CosmeticItem.Track(times, values);
   }

   private static float[][] faceQuad(int face, float[] o, float[] s, float f) {
      float x0 = -(o[0] + s[0]) - f;
      float y0 = o[1] - f;
      float z0 = o[2] - f;
      float x1 = -o[0] + f;
      float y1 = o[1] + s[1] + f;
      float z1 = o[2] + s[2] + f;

      return switch (face) {
         case 0 -> new float[][]{{x1, y1, z0}, {x0, y1, z0}, {x0, y0, z0}, {x1, y0, z0}};
         case 1 -> new float[][]{{x0, y1, z1}, {x1, y1, z1}, {x1, y0, z1}, {x0, y0, z1}};
         case 2 -> new float[][]{{x1, y1, z1}, {x1, y1, z0}, {x1, y0, z0}, {x1, y0, z1}};
         case 3 -> new float[][]{{x0, y1, z0}, {x0, y1, z1}, {x0, y0, z1}, {x0, y0, z0}};
         case 4 -> new float[][]{{x0, y1, z0}, {x1, y1, z0}, {x1, y1, z1}, {x0, y1, z1}};
         default -> new float[][]{{x0, y0, z1}, {x1, y0, z1}, {x1, y0, z0}, {x0, y0, z0}};
      };
   }

   static Matrix3f rotation(float rx, float ry, float rz) {
      return new Matrix3f().rotateZ((float)Math.toRadians(rz)).rotateY((float)Math.toRadians(-ry)).rotateX((float)Math.toRadians(-rx));
   }

   private static void cube(JsonObject c, CosmeticItem.Bone bone, int texW, int texH, List<CosmeticLoader.Pending> out) {
      float[] o = vec(c.getAsJsonArray("origin"));
      float[] s = vec(c.getAsJsonArray("size"));
      float inflate = f(c, "inflate", 0.0F);
      Matrix3f rot = null;
      Vector3f cp = null;
      if (c.has("rotation")) {
         float[] r = vec(c.getAsJsonArray("rotation"));
         float[] p = c.has("pivot") ? vec(c.getAsJsonArray("pivot")) : o;
         rot = rotation(r[0], r[1], r[2]);
         cp = new Vector3f(-p[0], p[1], p[2]);
      }

      if (c.has("uv") && c.get("uv").isJsonObject()) {
         JsonObject uvs = c.getAsJsonObject("uv");

         for (int fi = 0; fi < 6; fi++) {
            JsonObject face = uvs.has(FACES[fi]) ? uvs.getAsJsonObject(FACES[fi]) : null;
            if (face != null) {
               JsonArray uv = face.getAsJsonArray("uv");
               JsonArray size = face.getAsJsonArray("uv_size");
               float u = uv.get(0).getAsFloat();
               float v = uv.get(1).getAsFloat();
               float w = size.get(0).getAsFloat();
               float h = size.get(1).getAsFloat();
               float[][] q = faceQuad(fi, o, s, inflate);
               if (!(dist(q[0], q[1]) < 1.0E-6F) && !(dist(q[0], q[3]) < 1.0E-6F)) {
                  Vector3f n = new Vector3f(NORMALS[fi][0], NORMALS[fi][1], NORMALS[fi][2]);
                  if (rot != null) {
                     rot.transform(n);
                  }

                  float iu = Math.signum(w) * 0.02F;
                  float iv = Math.signum(h) * 0.02F;
                  float[][] tuv = new float[][]{{u + iu, v + iv}, {u + w - iu, v + iv}, {u + w - iu, v + h - iv}, {u + iu, v + h - iv}};
                  float[] verts = new float[32];

                  for (int k = 0; k < 4; k++) {
                     Vector3f p = new Vector3f(q[k][0], q[k][1], q[k][2]);
                     if (rot != null) {
                        p.sub(cp);
                        rot.transform(p);
                        p.add(cp);
                     }

                     int b = k * 8;
                     verts[b] = p.x - bone.px;
                     verts[b + 1] = p.y - bone.py;
                     verts[b + 2] = p.z - bone.pz;
                     verts[b + 3] = tuv[k][0] / texW;
                     verts[b + 4] = tuv[k][1] / texH;
                     verts[b + 5] = n.x;
                     verts[b + 6] = n.y;
                     verts[b + 7] = n.z;
                  }

                  out.add(
                     new CosmeticLoader.Pending(
                        verts,
                        (int)Math.floor(Math.min(u, u + w)),
                        (int)Math.floor(Math.min(v, v + h)),
                        (int)Math.ceil(Math.abs(w)),
                        (int)Math.ceil(Math.abs(h))
                     )
                  );
               }
            }
         }
      }
   }

   static Matrix4f[] rest(CosmeticItem.Bone[] bones) {
      Matrix4f[] out = new Matrix4f[bones.length];

      for (int i = 0; i < bones.length; i++) {
         CosmeticItem.Bone b = bones[i];
         boolean nested = b.parent >= 0 && b.parent < i;
         Matrix4f m = nested ? new Matrix4f(out[b.parent]) : new Matrix4f();
         float ppx = nested ? bones[b.parent].px : 0.0F;
         float ppy = nested ? bones[b.parent].py : 0.0F;
         float ppz = nested ? bones[b.parent].pz : 0.0F;
         m.translate(b.px - ppx, b.py - ppy, b.pz - ppz)
            .rotateZ((float)Math.toRadians(b.rz))
            .rotateY((float)Math.toRadians(-b.ry))
            .rotateX((float)Math.toRadians(-b.rx));
         out[i] = m;
      }

      return out;
   }

   private static void separate(CosmeticItem.Bone[] bones, List<List<CosmeticLoader.Pending>> perBone) {
      Matrix4f[] rest = rest(bones);
      List<CosmeticLoader.Face> faces = new ArrayList<>();

      for (int i = 0; i < bones.length; i++) {
         for (CosmeticLoader.Pending q : perBone.get(i)) {
            faces.add(new CosmeticLoader.Face(q, rest[i]));
         }
      }

      for (int i = 0; i < faces.size(); i++) {
         CosmeticLoader.Face a = faces.get(i);

         for (int j = 0; j < i; j++) {
            CosmeticLoader.Face b = faces.get(j);
            float dot = a.n.dot(b.n);
            if (!(Math.abs(dot) < 0.9995F) && !(Math.abs(a.d - Math.signum(dot) * b.d) > 0.002F) && overlap(a, b)) {
               a.layer = Math.max(a.layer, dot > 0.0F ? b.layer + 1 : 1);
            }
         }
      }

      for (CosmeticLoader.Face f : faces) {
         if (f.layer != 0) {
            float[] v = f.quad.verts;
            float k = f.layer * 0.015F;

            for (int c = 0; c < 4; c++) {
               v[c * 8] = v[c * 8] + v[5] * k;
               v[c * 8 + 1] = v[c * 8 + 1] + v[6] * k;
               v[c * 8 + 2] = v[c * 8 + 2] + v[7] * k;
            }
         }
      }
   }

   private static boolean overlap(CosmeticLoader.Face a, CosmeticLoader.Face b) {
      Vector3f u = new Vector3f(a.p[1]).sub(a.p[0]);
      if (u.lengthSquared() < 1.0E-10F) {
         return false;
      }

      u.normalize();
      Vector3f w = new Vector3f(a.n).cross(u).normalize();
      float[][] pa = new float[4][2];
      float[][] pb = new float[4][2];

      for (int k = 0; k < 4; k++) {
         pa[k][0] = a.p[k].dot(u);
         pa[k][1] = a.p[k].dot(w);
         pb[k][0] = b.p[k].dot(u);
         pb[k][1] = b.p[k].dot(w);
      }

      return !separated(pa, pa, pb) && !separated(pb, pa, pb);
   }

   private static boolean separated(float[][] edges, float[][] pa, float[][] pb) {
      for (int k = 0; k < 4; k++) {
         float ex = edges[(k + 1) % 4][0] - edges[k][0];
         float ey = edges[(k + 1) % 4][1] - edges[k][1];
         float len = (float)Math.sqrt(ex * ex + ey * ey);
         if (!(len < 1.0E-6F)) {
            float ax = -ey / len;
            float ay = ex / len;
            float amin = Float.MAX_VALUE;
            float amax = -Float.MAX_VALUE;
            float bmin = Float.MAX_VALUE;
            float bmax = -Float.MAX_VALUE;

            for (int c = 0; c < 4; c++) {
               float x = pa[c][0] * ax + pa[c][1] * ay;
               float y = pb[c][0] * ax + pb[c][1] * ay;
               amin = Math.min(amin, x);
               amax = Math.max(amax, x);
               bmin = Math.min(bmin, y);
               bmax = Math.max(bmax, y);
            }

            if (Math.min(amax, bmax) - Math.max(amin, bmin) < 0.001F) {
               return true;
            }
         }
      }

      return false;
   }

   private static void rig(CosmeticItem.Bone[] bones, List<List<CosmeticLoader.Pending>> perBone, String slot) {
      for (int i = 0; i < bones.length; i++) {
         CosmeticItem.Bone b = bones[i];
         String n = b.name.toLowerCase(Locale.ROOT);
         if (!"wings".equals(slot) || b.parent >= 0 || !n.startsWith("lw_") && !n.startsWith("rw_")) {
            if (CHAIN.matcher(n).matches()) {
               b.role = 2;
            } else if (n.equals("ear_l") || n.equals("le")) {
               b.role = 3;
               b.side = -1;
            } else if (n.equals("ear_r") || n.equals("re")) {
               b.role = 3;
               b.side = 1;
            } else if ("pet".equals(slot) && (n.equals("head") || n.equals("cam"))) {
               b.role = 4;
            }
         } else {
            b.role = 1;
            b.side = n.startsWith("lw_") ? -1 : 1;
         }
      }
   }

   private static void chains(CosmeticItem.Bone[] bones, List<List<CosmeticLoader.Pending>> perBone) {
      for (int pass = 0; pass < 2; pass++) {
         for (CosmeticItem.Bone b : bones) {
            if (b.role == 2 || b.role == 6) {
               CosmeticItem.Bone p = b.parent >= 0 ? bones[b.parent] : null;
               boolean linked = p != null && (p.role == 2 || p.role == 6);
               b.depth = linked ? Math.min(12, p.depth + 1) : 0;
            }
         }
      }

      for (int i = 0; i < bones.length; i++) {
         CosmeticItem.Bone b = bones[i];
         if (b.role == 2 || b.role == 6) {
            Vector3f h = null;

            for (int j = 0; j < bones.length; j++) {
               if (bones[j].parent == i) {
                  h = new Vector3f(bones[j].px - b.px, bones[j].py - b.py, bones[j].pz - b.pz);
                  break;
               }
            }

            if (h == null || h.lengthSquared() < 1.0E-6F) {
               h = new Vector3f();
               int count = 0;

               for (CosmeticLoader.Pending q : perBone.get(i)) {
                  for (int k = 0; k < 4; k++) {
                     h.add(q.verts[k * 8], q.verts[k * 8 + 1], q.verts[k * 8 + 2]);
                     count++;
                  }
               }

               if (count > 0) {
                  h.div(count);
               }
            }

            if (h.lengthSquared() < 1.0E-6F) {
               h.set(0.0F, -1.0F, 0.0F);
            }

            h.normalize();
            b.hx = h.x;
            b.hy = h.y;
            b.hz = h.z;
         }
      }
   }

   private static float dist(float[] a, float[] b) {
      float dx = a[0] - b[0];
      float dy = a[1] - b[1];
      float dz = a[2] - b[2];
      return (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
   }

   private static float[] pack(List<CosmeticLoader.Pending> quads) {
      float[] out = new float[quads.size() * 32];

      for (int i = 0; i < quads.size(); i++) {
         System.arraycopy(quads.get(i).verts, 0, out, i * 32, 32);
      }

      return out;
   }

   static void ensureTextures(CosmeticItem item) {
      if (!item.loaded && !item.failed) {
         try {
            NativeImage albedo = image(item.albedoPath);
            if (albedo == null) {
               item.failed = true;
               return;
            }

            for (CosmeticItem.Bone bone : item.bones) {
               List<CosmeticLoader.Pending> quads = PENDING.remove(bone);
               if (quads == null) {
                  if (bone.solid == null) {
                     bone.solid = new float[0];
                     bone.glass = new float[0];
                  }
               } else {
                  List<CosmeticLoader.Pending> solid = new ArrayList<>();
                  List<CosmeticLoader.Pending> glass = new ArrayList<>();

                  for (CosmeticLoader.Pending p : quads) {
                     (translucent(albedo, p) ? glass : solid).add(p);
                  }

                  bone.solid = pack(solid);
                  bone.glass = pack(glass);
               }
            }

            MinecraftClient mc = MinecraftClient.getInstance();
            item.albedo = Identifier.of("flow2", "cosmetic/" + item.id);
            mc.getTextureManager().registerTexture(item.albedo, new NativeImageBackedTexture(() -> "Flow2 cosmetic " + item.id, albedo));
            if (item.emissivePath != null) {
               NativeImage em = image(item.emissivePath);
               if (em != null) {
                  item.emissive = Identifier.of("flow2", "cosmetic/" + item.id + "_e");
                  mc.getTextureManager().registerTexture(item.emissive, new NativeImageBackedTexture(() -> "Flow2 cosmetic glow " + item.id, em));
               }
            }

            if (item.video != null) {
               int vw = Math.round(item.videoRect[4] > 0.0F ? item.videoRect[4] : 256.0F);
               int vh = Math.round(item.videoRect[5] > 0.0F ? item.videoRect[5] : 256.0F);
               item.videoTexture = new VideoTexture(item.video, vw, vh, mc.getTextureManager().getTexture(item.albedo));
               item.videoId = Identifier.of("flow2", "cosmetic/" + item.id + "_video");
               mc.getTextureManager().registerTexture(item.videoId, item.videoTexture);
            }

            item.loaded = true;
         } catch (Throwable t) {
            item.failed = true;
            System.out.println("cosmetic " + item.id + " textures failed: " + t);
         }
      }
   }

   static NativeImage image(String name) {
      try (InputStream in = ezj.open("/flow/cosmetics/" + name)) {
         return in == null ? null : NativeImage.read(in);
      } catch (Exception e) {
         System.out.println("can't read cosmetic texture " + name + ": " + e);
         return null;
      }
   }

   private static boolean translucent(NativeImage img, CosmeticLoader.Pending p) {
      int x0;
      int y0;
      int x1;
      int y1;
      if (p.nu0 >= 0.0F) {
         x0 = Math.max(0, (int)Math.floor(p.nu0 * img.getWidth()));
         y0 = Math.max(0, (int)Math.floor(p.nv0 * img.getHeight()));
         x1 = Math.min(img.getWidth(), (int)Math.ceil(p.nu1 * img.getWidth()));
         y1 = Math.min(img.getHeight(), (int)Math.ceil(p.nv1 * img.getHeight()));
      } else {
         x0 = Math.max(0, p.u);
         y0 = Math.max(0, p.v);
         x1 = Math.min(img.getWidth(), p.u + p.w);
         y1 = Math.min(img.getHeight(), p.v + p.h);
      }

      for (int y = y0; y < y1; y++) {
         for (int x = x0; x < x1; x++) {
            int a = img.getColorArgb(x, y) >>> 24;
            if (a > 6 && a < 248) {
               return true;
            }
         }
      }

      return false;
   }

   private static final class Face {
      final CosmeticLoader.Pending quad;
      final Vector3f[] p = new Vector3f[4];
      final Vector3f n = new Vector3f();
      final float d;
      int layer;

      Face(CosmeticLoader.Pending quad, Matrix4f m) {
         this.quad = quad;
         float[] v = quad.verts;

         for (int k = 0; k < 4; k++) {
            this.p[k] = m.transformPosition(v[k * 8], v[k * 8 + 1], v[k * 8 + 2], new Vector3f());
         }

         m.transformDirection(v[5], v[6], v[7], this.n);
         if (this.n.lengthSquared() > 1.0E-12F) {
            this.n.normalize();
         }

         this.d = this.n.dot(this.p[0]);
      }
   }

   private record Pending(float[] verts, int u, int v, int w, int h, float nu0, float nv0, float nu1, float nv1) {
      Pending(float[] verts, int u, int v, int w, int h) {
         this(verts, u, v, w, h, -1.0F, -1.0F, -1.0F, -1.0F);
      }
   }
}
