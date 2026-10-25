package flow.cosmetic;

import a.rqv;
import a.ucg;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents.AllowCapeRender;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.AfterEntities;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.EndMain;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.AfterRender;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.BeforeInit;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents.BeforeRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public final class Cosmetics {
   public static final vkl ENABLED = new vkl("Cosmetics", true);
   public static final vmc GLOW = new vmc("Glow", 1.0, 0.0, 2.0, 0.05).percent();
   public static final vkl PARTICLES = new vkl("Cosmetic particles", true);
   public static final vkl PET_FIRST_PERSON = new vkl("Pet in first person", true);
   public static final vkl PARTY = new vkl("Party cosmetics", true);
   public static final vlv PET_MODE = new vlv("Pet mode", "Shoulder", "Shoulder", "Follow");
   public static final List<vmo> OPTIONS = List.of(GLOW, PARTICLES, PET_MODE, PET_FIRST_PERSON, PARTY);
   public static final List<vmo> ALL = List.of(ENABLED, GLOW, PARTICLES, PET_MODE, PET_FIRST_PERSON, PARTY);
   private static final String[] BODY_SLOTS = new String[]{"wings", "back", "cape", "hat", "face"};
   private static final Matrix4f MODEL_BASE = new Matrix4f().scale(0.0625F).translate(0.0F, 24.0F, 0.0F).scale(-1.0F, -1.0F, 1.0F);
   private static final Matrix4f IDENTITY = new Matrix4f();
   private static final long START = System.nanoTime();
   private static final double REMOTE_RANGE = 96.0;
   private static List<CosmeticItem> items;
   private static Map<String, CosmeticItem> byId;
   private static final Map<String, String> WORN = new LinkedHashMap<>();
   private static final Map<Integer, Motion> MOTIONS = new HashMap<>();
   private static final Set<EntityRenderState> HIDDEN = Collections.newSetFromMap(new IdentityHashMap<>());
   private static final ModelPart[] SHIFTED = new ModelPart[2];
   private static final Set<CosmeticItem> VIDEO_SEEN = Collections.newSetFromMap(new IdentityHashMap<>());
   private static final float[] SHIFT_ORIGIN = new float[6];
   private static final Map<String, Map<String, CosmeticItem>> PARSED = new HashMap<>();
   private static final CosmeticMesh.Drive DRIVE = new CosmeticMesh.Drive();
   private static boolean installed;
   private static boolean reloaded;
   private static boolean guiPending;
   private static boolean guiFlip;
   private static boolean inWorld;
   private static long lastFrame;
   private static float frameDt;
   private static Vec3d camPos = Vec3d.ZERO;
   private static int version;
   private static Map<String, CosmeticItem> localWorn = Map.of();
   private static int localVersion = -1;
   private static final double SPOT_SIDE = 0.85;
   private static final double SPOT_BACK = 0.9;
   private static final double RUN_FROM = 2.3;
   private static final double TOO_CLOSE = 0.55;
   private static final double ARRIVED = 0.3;

   private Cosmetics() {
   }

   public static synchronized List<CosmeticItem> items() {
      if (items == null) {
         List<CosmeticItem> list = CosmeticLoader.loadIndex();
         Map<String, CosmeticItem> map = new HashMap<>();

         for (CosmeticItem it : list) {
            map.put(it.id, it);
         }

         byId = map;
         items = Collections.unmodifiableList(list);
      }

      return items;
   }

   public static void warm(CosmeticItem it) {
      CosmeticLoader.ensureTextures(it);
   }

   public static CosmeticItem get(String id) {
      items();
      return id == null ? null : byId.get(id);
   }

   public static List<CosmeticItem> ofSlot(String slot) {
      List<CosmeticItem> out = new ArrayList<>();

      for (CosmeticItem it : items()) {
         if (it.slot.equals(slot)) {
            out.add(it);
         }
      }

      return out;
   }

   public static CosmeticItem worn(String slot) {
      return get(WORN.get(slot));
   }

   public static boolean isWorn(CosmeticItem it) {
      return it != null && it.id.equals(WORN.get(it.slot));
   }

   public static void toggle(CosmeticItem it) {
      if (isWorn(it)) {
         WORN.remove(it.slot);
      } else {
         WORN.put(it.slot, it.id);
      }

      version++;
   }

   public static void clear(String slot) {
      WORN.remove(slot);
      version++;
   }

   public static void clearAll() {
      WORN.clear();
      version++;
      CosmeticParticles.clear();
   }

   public static int wornCount() {
      int n = 0;

      for (String slot : CosmeticItem.SLOTS) {
         if (worn(slot) != null) {
            n++;
         }
      }

      return n;
   }

   public static String code() {
      return ENABLED.get() ? shareCode() : "";
   }

   public static String shareCode() {
      StringBuilder sb = new StringBuilder();

      for (String slot : CosmeticItem.SLOTS) {
         CosmeticItem it = worn(slot);
         if (it != null) {
            if (!sb.isEmpty()) {
               sb.append(',');
            }

            sb.append(slot).append(':').append(it.id);
         }
      }

      return sb.toString();
   }

   static Map<String, CosmeticItem> parse(String code) {
      if (code != null && !code.isBlank()) {
         Map<String, CosmeticItem> cached = PARSED.get(code);
         if (cached != null) {
            return cached;
         }

         Map<String, CosmeticItem> out = new LinkedHashMap<>();

         for (String part : code.split(",")) {
            int colon = part.indexOf(58);
            if (colon > 0) {
               CosmeticItem it = get(part.substring(colon + 1).trim());
               if (it != null && it.slot.equals(part.substring(0, colon).trim())) {
                  out.put(it.slot, it);
               }
            }
         }

         if (PARSED.size() > 64) {
            PARSED.clear();
         }

         PARSED.put(code, out);
         return out;
      } else {
         return Map.of();
      }
   }

   public static void load(Properties p) {
      WORN.clear();

      for (String slot : CosmeticItem.SLOTS) {
         String id = p.getProperty("cosmetic." + slot);
         if (id != null && !id.isBlank()) {
            WORN.put(slot, id.trim());
         }
      }

      version++;
   }

   public static void save(Properties p) {
      for (Entry<String, String> e : WORN.entrySet()) {
         p.setProperty("cosmetic." + e.getKey(), e.getValue());
      }
   }

   public static void install() {
      if (!installed) {
         installed = true;
         LivingEntityFeatureRendererRegistrationCallback.EVENT.register((LivingEntityFeatureRendererRegistrationCallback)(type, renderer, helper, context) -> {
            if (renderer instanceof PlayerEntityRenderer) {
               FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel> ctx = renderer;
               CosmeticFeature lead = new CosmeticFeature(ctx, true);
               helper.register(lead);
               helper.register(new CosmeticFeature(ctx, false));
               lead(renderer, lead);
            }
         });
         LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register((AllowCapeRender)state -> !hidesVanillaCape(state));
         WorldRenderEvents.BEFORE_ENTITIES.register(Cosmetics::beforeEntities);
         WorldRenderEvents.AFTER_ENTITIES.register((AfterEntities)context -> inWorld = false);
         WorldRenderEvents.END_MAIN.register((EndMain)context -> CosmeticGlow.flush());
         ClientTickEvents.END_CLIENT_TICK.register(Cosmetics::endTick);
         ScreenEvents.BEFORE_INIT.register((BeforeInit)(client, screen, w, h) -> {
            ScreenEvents.beforeRender(screen).register((BeforeRender)(sc, ctx, mx, my, delta) -> guiBegin());
            ScreenEvents.afterRender(screen).register((AfterRender)(sc, ctx, mx, my, delta) -> guiEnd());
         });
      }
   }

   private static void refreshVideos(Map<String, CosmeticItem> worn) {
      for (CosmeticItem it : worn.values()) {
         if (it.videoTexture != null && VIDEO_SEEN.add(it)) {
            it.videoTexture.refresh();
         }
      }
   }

   private static void guiBegin() {
      MinecraftClient mc = MinecraftClient.getInstance();
      if (ENABLED.get() && mc.player != null) {
         Motion m = MOTIONS.get(mc.player.getId());
         if (m != null) {
            VIDEO_SEEN.clear();
            refreshVideos(m.worn);
         }

         if (m != null && m.worn.containsKey("avatar")) {
            guiPending = true;
            if (!mc.player.isInvisible()) {
               mc.player.setInvisible(true);
               guiFlip = true;
            }
         }
      }
   }

   private static void guiEnd() {
      MinecraftClient mc = MinecraftClient.getInstance();
      if (guiFlip && mc.player != null) {
         mc.player.setInvisible(false);
      }

      guiFlip = false;
   }

   public static boolean wears(int id) {
      if (!ENABLED.get()) {
         return false;
      }

      Motion m = MOTIONS.get(id);
      return m != null && !m.worn.isEmpty();
   }

   public static boolean hidesBody(EntityRenderState state) {
      return !HIDDEN.isEmpty() && HIDDEN.contains(state);
   }

   public static void afterExtraction(WorldRenderState world) {
      HIDDEN.clear();
      if (ENABLED.get()) {
         for (EntityRenderState s : world.entityRenderStates) {
            if (s instanceof PlayerEntityRenderState ps) {
               Motion m = MOTIONS.get(ps.id);
               if (m != null && m.worn.containsKey("avatar")) {
                  ps.invisible = true;
                  ps.invisibleToPlayer = true;
                  ps.capeVisible = false;
                  ps.equippedHeadStack = ItemStack.EMPTY;
                  ps.equippedChestStack = ItemStack.EMPTY;
                  ps.equippedLegsStack = ItemStack.EMPTY;
                  ps.equippedFeetStack = ItemStack.EMPTY;
                  ps.headItemRenderState.clear();
                  HIDDEN.add(ps);
               }
            }
         }
      }
   }

   private static void endTick(MinecraftClient mc) {
      if (!reloaded && mc.world != null) {
         reloaded = true;

         try {
            mc.getEntityRenderDispatcher().reload(mc.getResourceManager());
         } catch (Throwable t) {
            System.out.println("cosmetics renderer reload failed: " + t);
         }
      }
   }

   private static boolean hidesVanillaCape(PlayerEntityRenderState state) {
      if (!ENABLED.get()) {
         return false;
      }

      Motion m = MOTIONS.get(state.id);
      return m != null && m.worn.containsKey("cape");
   }

   private static float seconds() {
      return (float)(System.nanoTime() - START) / 1.0E9F;
   }

   private static int frameOf(CosmeticItem it, float t) {
      return it.frames > 1 && !(it.frameTime <= 0.0F) ? (int)(t / it.frameTime) % it.frames : 0;
   }

   private static int glowColor(CosmeticItem it, float t) {
      float gain = 1.0F;
      if (it.glowPeriod > 0.0F) {
         gain = it.glowMin + (it.glowMax - it.glowMin) * (0.5F + 0.5F * (float)Math.sin((Math.PI * 2) * t / it.glowPeriod));
      }

      int g = Math.max(0, Math.min(255, Math.round(255.0F * gain)));
      return 0xFF000000 | g << 16 | g << 8 | g;
   }

   private static void submit(
      CosmeticItem it, Matrix4f[] bones, Matrix4f base, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, float t, boolean world
   ) {
      submit(it, bones, base, matrices, queue, light, t, world, -2);
   }

   private static void submit(
      CosmeticItem it, Matrix4f[] bones, Matrix4f base, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, float t, boolean world, int part
   ) {
      int frame = frameOf(it, t);
      boolean blink = DRIVE.blink;
      boolean live = it.videoTexture != null && it.videoTexture.live();
      if (CosmeticMesh.hasSolid(it)) {
         queue.submitCustom(
            matrices,
            RenderLayers.entityCutoutNoCull(it.albedo),
            (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 0, light, -1, frame, part, blink, live)
         );
      }

      if (live) {
         int vl = LightmapTextureManager.pack(
            Math.max(LightmapTextureManager.getBlockLightCoordinates(light), 11), LightmapTextureManager.getSkyLightCoordinates(light)
         );
         queue.submitCustom(
            matrices,
            RenderLayers.entityCutoutNoCull(it.videoId),
            (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 3, vl, -1, frame, part, blink, true)
         );
      }

      if (CosmeticMesh.hasGlass(it)) {
         queue.submitCustom(
            matrices, RenderLayers.entityTranslucent(it.albedo), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 1, light, -1, frame, part, blink)
         );
      }

      if (it.emissive != null) {
         int color = glowColor(it, t);
         queue.submitCustom(
            matrices, RenderLayers.eyes(it.emissive), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 2, 15728880, color, frame, part, blink)
         );
         if (world && CosmeticGlow.active()) {
            CosmeticGlow.add(it, bones, new Matrix4f(matrices.peek().getPositionMatrix()).mul(base), color, frame, part, blink);
         }
      }
   }

   private static void renderAvatar(
      PlayerEntityModel model,
      MatrixStack matrices,
      OrderedRenderCommandQueue queue,
      int light,
      PlayerEntityRenderState state,
      Motion motion,
      CosmeticItem it,
      float t,
      boolean world
   ) {
      CosmeticLoader.ensureTextures(it);
      if (it.loaded) {
         DRIVE.legL = model.leftLeg.pitch;
         DRIVE.legR = model.rightLeg.pitch;
         DRIVE.hurt = state.hurt;
         DRIVE.wAttack = state.handSwingProgress > 0.0F ? MathHelper.sin(state.handSwingProgress * (float) Math.PI) : 0.0F;
         Matrix4f[] bones = CosmeticMesh.pose(it, DRIVE);
         ModelPart[] parts = new ModelPart[]{model.head, model.body, model.rightArm, model.leftArm, model.rightLeg, model.leftLeg};

         for (int p = 0; p < parts.length; p++) {
            if (hasPart(it, p)) {
               matrices.push();
               partTransform(matrices, parts[p], it.partPivots != null ? it.partPivots[p] : null, p >= 4 ? stride(it, p) : 1.0F);
               submit(it, bones, MODEL_BASE, matrices, queue, light, t, world, p);
               if (world && PARTICLES.get() && it.emitters.length > 0) {
                  emit(
                     motion,
                     it,
                     bones,
                     new Matrix4f(matrices.peek().getPositionMatrix()).mul(MODEL_BASE),
                     camPos,
                     (float)Math.toRadians(180.0F - state.bodyYaw),
                     p
                  );
               }

               matrices.pop();
            }
         }

         fitHands(model, state, it);
      }
   }

   private static void lead(Object renderer, CosmeticFeature feature) {
      try {
         for (Field f : LivingEntityRenderer.class.getDeclaredFields()) {
            if (List.class.isAssignableFrom(f.getType())) {
               f.setAccessible(true);
               List<Object> list = (List<Object>)f.get(renderer);
               if (list.remove(feature)) {
                  list.add(0, feature);
               }

               return;
            }
         }
      } catch (ReflectiveOperationException | RuntimeException var7) {
      }
   }

   private static void fitHands(PlayerEntityModel model, PlayerEntityRenderState state, CosmeticItem it) {
      for (int p = 2; p <= 3; p++) {
         float[] h = handOf(it, p);
         if (h != null) {
            ModelPart mp = p == 2 ? model.rightArm : model.leftArm;
            Arm arm = p == 2 ? Arm.RIGHT : Arm.LEFT;
            MatrixStack ms = new MatrixStack();
            partTransform(ms, mp, it.partPivots != null ? it.partPivots[p] : null);
            Vector3f target = new Matrix4f(ms.peek().getPositionMatrix()).mul(MODEL_BASE).transformPosition(h[0], h[1], h[2], new Vector3f());
            ms = new MatrixStack();
            model.setArmAngle(state, arm, ms);
            ms.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
            ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
            ms.translate((arm == Arm.LEFT ? -1.0F : 1.0F) / 16.0F, 0.125F, -0.625F);
            Vector3f cur = ms.peek().getPositionMatrix().transformPosition(0.0F, 0.0F, 0.0F, new Vector3f());
            int k = p - 2;
            SHIFTED[k] = mp;
            SHIFT_ORIGIN[k * 3] = mp.originX;
            SHIFT_ORIGIN[k * 3 + 1] = mp.originY;
            SHIFT_ORIGIN[k * 3 + 2] = mp.originZ;
            mp.originX = mp.originX + (target.x - cur.x) * 16.0F;
            mp.originY = mp.originY + (target.y - cur.y) * 16.0F;
            mp.originZ = mp.originZ + (target.z - cur.z) * 16.0F;
         }
      }
   }

   static void restoreArms() {
      for (int k = 0; k < SHIFTED.length; k++) {
         ModelPart mp = SHIFTED[k];
         if (mp != null) {
            mp.originX = SHIFT_ORIGIN[k * 3];
            mp.originY = SHIFT_ORIGIN[k * 3 + 1];
            mp.originZ = SHIFT_ORIGIN[k * 3 + 2];
            SHIFTED[k] = null;
         }
      }
   }

   private static float[] handOf(CosmeticItem it, int part) {
      if (it.hands == null) {
         float[][] hands = new float[CosmeticItem.PARTS.length][];
         hands[2] = hand(it, 2);
         hands[3] = hand(it, 3);
         it.hands = hands;
      }

      return it.hands[part];
   }

   private static float[] hand(CosmeticItem it, int part) {
      Matrix4f[] rest = CosmeticLoader.rest(it.bones);
      float minY = lowest(it, rest, part);
      if (minY == Float.MAX_VALUE) {
         return null;
      }

      float x0 = Float.MAX_VALUE;
      float x1 = -Float.MAX_VALUE;
      float z0 = Float.MAX_VALUE;
      Vector3f p = new Vector3f();

      for (int i = 0; i < it.bones.length; i++) {
         CosmeticItem.Bone b = it.bones[i];
         if (b.part == part) {
            for (float[] v : new float[][]{b.solid, b.glass}) {
               if (v != null) {
                  for (int k = 0; k + 7 < v.length; k += 8) {
                     rest[i].transformPosition(v[k], v[k + 1], v[k + 2], p);
                     if (p.y < minY + 3.0F) {
                        x0 = Math.min(x0, p.x);
                        x1 = Math.max(x1, p.x);
                        z0 = Math.min(z0, p.z);
                     }
                  }
               }
            }
         }
      }

      return new float[]{(x0 + x1) / 2.0F, minY, z0};
   }

   private static boolean hasPart(CosmeticItem it, int part) {
      for (CosmeticItem.Bone b : it.bones) {
         if (b.part == part) {
            return true;
         }
      }

      return false;
   }

   private static float stride(CosmeticItem it, int part) {
      if (it.stride == null) {
         float[] out = new float[CosmeticItem.PARTS.length];
         Matrix4f[] rest = CosmeticLoader.rest(it.bones);

         for (int p = 4; p < out.length; p++) {
            float top = it.partPivots != null && it.partPivots[p] != null ? it.partPivots[p][1] : 12.0F;
            float low = lowest(it, rest, p);
            float len = low == Float.MAX_VALUE ? 12.0F : top - low;
            out[p] = len > 12.5F ? Math.max(0.45F, 12.0F / len) : 1.0F;
         }

         it.stride = out;
      }

      return it.stride[part];
   }

   private static float lowest(CosmeticItem it, Matrix4f[] rest, int part) {
      float y = Float.MAX_VALUE;
      Vector3f v = new Vector3f();

      for (int i = 0; i < it.bones.length; i++) {
         CosmeticItem.Bone b = it.bones[i];
         if (b.part == part) {
            for (float[] arr : new float[][]{b.solid, b.glass}) {
               if (arr != null) {
                  for (int k = 0; k + 7 < arr.length; k += 8) {
                     y = Math.min(y, rest[i].transformPosition(arr[k], arr[k + 1], arr[k + 2], v).y);
                  }
               }
            }
         }
      }

      return y;
   }

   private static void partTransform(MatrixStack matrices, ModelPart mp, float[] pivot) {
      partTransform(matrices, mp, pivot, 1.0F);
   }

   private static void partTransform(MatrixStack matrices, ModelPart mp, float[] pivot, float stride) {
      ModelTransform def = mp.getDefaultTransform();
      float ax = pivot != null ? -pivot[0] : def.x();
      float ay = pivot != null ? 24.0F - pivot[1] : def.y();
      float az = pivot != null ? pivot[2] : def.z();
      matrices.translate((ax + mp.originX - def.x()) / 16.0F, (ay + mp.originY - def.y()) / 16.0F, (az + mp.originZ - def.z()) / 16.0F);
      if (mp.pitch != 0.0F || mp.yaw != 0.0F || mp.roll != 0.0F) {
         matrices.multiply(new Quaternionf().rotationZYX(mp.roll, mp.yaw, mp.pitch * stride));
      }

      if (mp.xScale != 1.0F || mp.yScale != 1.0F || mp.zScale != 1.0F) {
         matrices.scale(mp.xScale, mp.yScale, mp.zScale);
      }

      matrices.translate(-ax / 16.0F, -ay / 16.0F, -az / 16.0F);
   }

   static void renderWorn(PlayerEntityModel model, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, PlayerEntityRenderState state) {
      if (ENABLED.get() && !rqv.isFadedBody(state)) {
         Motion motion = MOTIONS.get(state.id);
         if (motion != null && !motion.worn.isEmpty()) {
            MinecraftClient mc = MinecraftClient.getInstance();
            boolean hidden = HIDDEN.contains(state) || !inWorld && guiPending && mc.player != null && state.id == mc.player.getId();
            float t = seconds();
            CosmeticMesh.Drive d = DRIVE;
            motion.body(d);
            CosmeticItem avatar = motion.worn.get("avatar");
            if (avatar != null && hidden) {
               renderAvatar(model, matrices, queue, light, state, motion, avatar, t, inWorld);
            }

            CosmeticItem fitTo = avatar != null && hidden && avatar.loaded ? avatar : null;

            for (String slot : BODY_SLOTS) {
               CosmeticItem it = motion.worn.get(slot);
               if (it != null
                  && !it.isPet()
                  && !it.isAvatar()
                  && (!"wings".equals(slot) || state.equippedChestStack == null || !state.equippedChestStack.isOf(Items.ELYTRA))) {
                  CosmeticLoader.ensureTextures(it);
                  if (it.loaded) {
                     d.cape = it.isCape() ? new float[]{-(6.0F + state.field_53537 / 2.0F + state.field_53536), 0.0F, state.field_53538 / 2.0F} : null;
                     Matrix4f[] bones = CosmeticMesh.pose(it, d);
                     matrices.push();
                     if (it.isCape() && state.equippedChestStack != null && !state.equippedChestStack.isEmpty()) {
                        matrices.translate(0.0F, -0.053125F, 0.06875F);
                     }

                     Matrix4f base = MODEL_BASE;
                     if (fitTo != null) {
                        int p = it.onHead() ? 0 : 1;
                        partTransform(matrices, p == 0 ? model.head : model.body, fitTo.partPivots != null ? fitTo.partPivots[p] : null);
                        float[] f = p == 0 ? fitTo.headFit : fitTo.backFit;
                        if (f != null) {
                           base = new Matrix4f(MODEL_BASE)
                              .mul(
                                 new Matrix4f()
                                    .translation(f[0], f[1], f[2])
                                    .rotateZ((float)Math.toRadians(f[5]))
                                    .rotateX((float)Math.toRadians(f[4]))
                                    .scale(f[3])
                                    .translate(0.0F, p == 0 ? -32.0F : -24.0F, p == 0 ? 0.0F : -2.0F)
                              );
                        }
                     } else {
                        (it.onHead() ? model.head : model.body).applyTransform(matrices);
                     }

                     submit(it, bones, base, matrices, queue, light, t, inWorld);
                     if (inWorld && PARTICLES.get() && it.emitters.length > 0) {
                        emit(
                           motion,
                           it,
                           bones,
                           new Matrix4f(matrices.peek().getPositionMatrix()).mul(base),
                           camPos,
                           (float)Math.toRadians(180.0F - state.bodyYaw),
                           -2
                        );
                     }

                     matrices.pop();
                  }
               }
            }

            d.cape = null;
         }
      }
   }

   private static void emit(Motion motion, CosmeticItem it, Matrix4f[] bones, Matrix4f m, Vec3d origin, float yaw, int part) {
      for (int i = 0; i < it.emitters.length; i++) {
         CosmeticItem.Emitter em = it.emitters[i];
         if (part == -2 || it.bones[em.bone].part == part) {
            float[] slot = motion.emit.computeIfAbsent(em, k -> new float[1]);
            float acc = slot[0] + em.rate * frameDt;
            if (acc >= 1.0F) {
               Vector3f p = new Matrix4f(m).mul(bones[em.bone]).transformPosition(em.ox, em.oy, em.oz, new Vector3f());

               while (acc >= 1.0F) {
                  acc--;
                  CosmeticParticles.spawn(em, origin.x + p.x, origin.y + p.y, origin.z + p.z, yaw);
               }
            }

            slot[0] = Math.min(acc, 4.0F);
         }
      }
   }

   private static Map<String, CosmeticItem> wornOf(MinecraftClient mc, PlayerEntity p) {
      if (p != mc.player) {
         return PARTY.get() && ucg.inParty() ? parse(ucg.cosmeticsOf(p.getGameProfile().name())) : Map.of();
      }

      if (localVersion != version) {
         Map<String, CosmeticItem> map = new LinkedHashMap<>();

         for (String slot : CosmeticItem.SLOTS) {
            CosmeticItem it = worn(slot);
            if (it != null) {
               map.put(slot, it);
            }
         }

         localWorn = map;
         localVersion = version;
      }

      return localWorn;
   }

   private static void beforeEntities(WorldRenderContext context) {
      inWorld = true;
      guiPending = false;
      long now = System.nanoTime();
      frameDt = lastFrame == 0L ? 0.0F : Math.min(0.1F, (float)(now - lastFrame) / 1.0E9F);
      lastFrame = now;
      CosmeticGlow.begin();
      MinecraftClient mc = MinecraftClient.getInstance();
      Camera camera = mc.gameRenderer.getCamera();
      camPos = camera.getCameraPos();
      CosmeticParticles.step(frameDt);

      try {
         VIDEO_SEEN.clear();
         if (ENABLED.get() && mc.player != null && mc.world != null) {
            float td = mc.getRenderTickCounter().getTickProgress(true);

            for (AbstractClientPlayerEntity p : mc.world.getPlayers()) {
               boolean local = p == mc.player;
               if (local || !(p.squaredDistanceTo(camPos) > 9216.0)) {
                  Map<String, CosmeticItem> worn = wornOf(mc, p);
                  if (!worn.isEmpty()) {
                     Motion m = MOTIONS.computeIfAbsent(p.getId(), Motion::new);
                     m.worn = worn;
                     m.seen = now;
                     m.update(p, td, frameDt, local);
                     refreshVideos(worn);
                     CosmeticItem pet = worn.get("pet");
                     if (pet != null) {
                        pet(context, mc, p, m, pet, td, local);
                     }
                  }
               }
            }
         }

         MOTIONS.values().removeIf(mx -> now - mx.seen > 2000000000L);
         if (PARTICLES.get()) {
            CosmeticParticles.render(context.matrices(), context.commandQueue(), camPos, camera.getRotation());
         } else {
            CosmeticParticles.clear();
         }
      } catch (Throwable t) {
         System.out.println("cosmetics world pass failed: " + t);
      }
   }

   private static int petLight(MinecraftClient mc, Motion m, PlayerEntity owner) {
      World w = mc.world;
      int sky = 0;
      int block = 0;
      BlockPos[] at = new BlockPos[]{
         BlockPos.ofFloored(m.petPos.x, m.petPos.y + 0.25, m.petPos.z),
         BlockPos.ofFloored(m.petPos.x, m.petPos.y + 0.9, m.petPos.z),
         BlockPos.ofFloored(owner.getX(), owner.getEyeY(), owner.getZ())
      };

      for (BlockPos pos : at) {
         int packed = WorldRenderer.getLightmapCoordinates(w, pos);
         sky = Math.max(sky, LightmapTextureManager.getSkyLightCoordinates(packed));
         block = Math.max(block, LightmapTextureManager.getBlockLightCoordinates(packed));
      }

      if (m.petSky < 0.0F) {
         m.petSky = sky;
         m.petBlock = block;
      } else {
         float k = 1.0F - (float)Math.exp(-frameDt * 5.0F);
         m.petSky = m.petSky + (sky - m.petSky) * k;
         m.petBlock = m.petBlock + (block - m.petBlock) * k;
      }

      int s = Math.round(m.petSky * 16.0F);
      int b = Math.round(m.petBlock * 16.0F);
      return Math.min(240, s) << 16 | Math.min(240, b);
   }

   static Vec3d groundSpot(MinecraftClient mc, PlayerEntity player, Vec3d pp, Motion m, CosmeticItem pet) {
      double yr = Math.toRadians(m.bodyYaw);
      double fx = -Math.sin(yr);
      double fz = Math.cos(yr);
      double side = pet.anchor[0] >= 0.0F ? 1.0 : -1.0;
      double rx = -fz * side;
      double rz = fx * side;
      double sx = pp.x + rx * 0.85 - fx * 0.9;
      double sz = pp.z + rz * 0.85 - fz * 0.9;
      double x = sx;
      double z = sz;
      if (m.petPos != null && m.petWorld == mc.world) {
         double hd = Math.hypot(m.petPos.x - pp.x, m.petPos.z - pp.z);
         if (hd > 2.3 || hd < 0.55) {
            m.petRun = true;
         } else if (m.petRun && Math.hypot(m.petPos.x - sx, m.petPos.z - sz) < 0.3) {
            m.petRun = false;
         }

         if (!m.petRun) {
            x = m.petPos.x;
            z = m.petPos.z;
         }
      }

      return new Vec3d(x, groundY(mc, player, x, pp.y, z) - petFoot(pet) / 16.0F, z);
   }

   private static double groundY(MinecraftClient mc, PlayerEntity player, double x, double y, double z) {
      BlockHitResult hit = mc.world
         .raycast(new RaycastContext(new Vec3d(x, y + 1.2, z), new Vec3d(x, y - 4.0, z), ShapeType.COLLIDER, FluidHandling.NONE, player));
      return hit.getType() == Type.MISS ? y : hit.getPos().y;
   }

   private static float petFoot(CosmeticItem pet) {
      if (Float.isNaN(pet.petFoot)) {
         float low = Float.MAX_VALUE;
         Matrix4f[] rest = CosmeticLoader.rest(pet.bones);
         Vector3f v = new Vector3f();

         for (int i = 0; i < pet.bones.length; i++) {
            CosmeticItem.Bone b = pet.bones[i];

            for (float[] arr : new float[][]{b.solid, b.glass}) {
               if (arr != null) {
                  for (int k = 0; k + 7 < arr.length; k += 8) {
                     low = Math.min(low, rest[i].transformPosition(arr[k], arr[k + 1], arr[k + 2], v).y);
                  }
               }
            }
         }

         pet.petFoot = low == Float.MAX_VALUE ? 0.0F : low;
      }

      return pet.petFoot;
   }

   static void follow(Motion m, Vec3d target, float dt, boolean walking) {
      double dist = m.petPos.distanceTo(target);
      double w = walking ? (Math.PI * 2) * (0.5 + 0.3 * Math.min(dist, 5.0)) : (Math.PI * 2) * (1.35 + 0.4 * Math.min(dist, 4.0));
      double zeta = walking ? 0.95 : 0.66;
      int steps = Math.max(1, (int)Math.ceil(dt / 0.008F));
      double h = dt / steps;
      double x = m.petPos.x;
      double y = m.petPos.y;
      double z = m.petPos.z;
      double vx = m.petVel.x;
      double vy = m.petVel.y;
      double vz = m.petVel.z;

      for (int k = 0; k < steps; k++) {
         vx += (w * w * (target.x - x) - 2.0 * zeta * w * vx) * h;
         vy += (w * w * (target.y - y) - 2.0 * zeta * w * vy) * h;
         vz += (w * w * (target.z - z) - 2.0 * zeta * w * vz) * h;
         x += vx * h;
         y += vy * h;
         z += vz * h;
      }

      m.petPos = new Vec3d(x, y, z);
      m.petVel = new Vec3d(vx, vy, vz);
   }

   private static void pet(WorldRenderContext context, MinecraftClient mc, PlayerEntity player, Motion m, CosmeticItem pet, float td, boolean local) {
      if (!player.isSpectator() && pet.anchor != null) {
         CosmeticLoader.ensureTextures(pet);
         if (pet.loaded) {
            Vec3d pp = player.getLerpedPos(td);
            boolean firstPerson = local && mc.options.getPerspective().isFirstPerson();
            float yaw = firstPerson ? MathHelper.lerpAngleDegrees(td, player.lastYaw, player.getYaw()) : m.bodyYaw;
            float t = seconds();
            boolean walking = PET_MODE.is("Follow")
               && !player.getAbilities().flying
               && !player.isGliding()
               && !player.isTouchingWater()
               && !player.hasVehicle();
            Vec3d target;
            if (walking) {
               target = groundSpot(mc, player, pp, m, pet);
            } else {
               m.petRun = false;
               Vector3f a = new Vector3f(pet.anchor);
               if (firstPerson) {
                  a.set(a.x * 1.6F, a.y - 1.5F, a.z + 1.5F);
               }

               float rest = (1.0F - m.walkW) * (1.0F - m.flyW);
               a.add(rest * 1.6F * (float)Math.sin(t * 0.53F), rest * 0.9F * (float)Math.sin(t * 0.81F + 1.3F), rest * 1.3F * (float)Math.cos(t * 0.37F));
               a.div(16.0F).rotateY((float)Math.toRadians(180.0F - yaw));
               target = pp.add(a.x, a.y, a.z);
            }

            if (m.petPos != null && m.petWorld == mc.world && !(m.petPos.squaredDistanceTo(target) > (walking ? 196 : 36))) {
               follow(m, target, frameDt, walking);
               float face = yaw;
               if (walking) {
                  double vx = m.petVel.x;
                  double vz = m.petVel.z;
                  if (vx * vx + vz * vz > 0.36) {
                     face = (float)Math.toDegrees(Math.atan2(-vx, vz));
                  } else {
                     face = (float)Math.toDegrees(Math.atan2(-(pp.x - m.petPos.x), pp.z - m.petPos.z));
                  }
               }

               m.petYaw = MathHelper.lerpAngleDegrees(1.0F - (float)Math.exp(-frameDt * (walking ? 7.0F : 4.0F)), m.petYaw, face);
            } else {
               m.petPos = target;
               m.petVel = Vec3d.ZERO;
               m.petLast = null;
               m.petYaw = yaw;
               m.petWorld = mc.world;
               m.petSky = -1.0F;
            }

            m.petStep(frameDt);
            CosmeticMesh.Drive d = DRIVE;
            m.pet(d);
            if (walking) {
               double sp = Math.hypot(m.petVel.x, m.petVel.z);
               m.petWalk = m.petWalk + ((float)MathHelper.clamp((sp - 0.3) / 2.5, 0.0, 1.0) - m.petWalk) * (1.0F - (float)Math.exp(-frameDt * 8.0F));
               m.petWalkT = m.petWalkT + frameDt * (0.75F + 0.35F * (float)Math.min(2.0, sp / 4.3));
               d.wIdle = 1.0F - m.petWalk;
               d.wWalk = m.petWalk;
               d.wFly = 0.0F;
               d.tWalk = m.petWalkT;
               d.roll *= 0.3F;
               d.pitch *= 0.3F;
            } else {
               m.petWalk = 0.0F;
            }

            Matrix4f[] bones = CosmeticMesh.pose(pet, d);
            float yawRad = (float)Math.toRadians(180.0F - m.petYaw);
            if (firstPerson) {
               double dist = m.petPos.squaredDistanceTo(camPos);
               m.petHidden = m.petHidden ? dist < 1.1 : dist < 0.8;
            } else {
               m.petHidden = false;
            }

            if ((!firstPerson || PET_FIRST_PERSON.get()) && !m.petHidden) {
               MatrixStack ms = context.matrices();
               ms.push();
               ms.translate(m.petPos.x - camPos.x, m.petPos.y - camPos.y, m.petPos.z - camPos.z);
               ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - m.petYaw));
               ms.scale(0.0625F, 0.0625F, 0.0625F);
               submit(pet, bones, IDENTITY, ms, context.commandQueue(), petLight(mc, m, player), t, true);
               ms.pop();
            }

            if (PARTICLES.get() && pet.emitters.length > 0) {
               emit(m, pet, bones, new Matrix4f().rotateY(yawRad).scale(0.0625F), m.petPos, yawRad, -2);
            }
         }
      } else {
         m.petPos = null;
      }
   }
}
