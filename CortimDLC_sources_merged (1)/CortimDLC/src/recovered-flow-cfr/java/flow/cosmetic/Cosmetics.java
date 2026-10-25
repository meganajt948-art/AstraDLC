/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents
 *  net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.model.ModelPart
 *  net.minecraft.client.model.ModelTransform
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.LightmapTextureManager
 *  net.minecraft.client.render.RenderLayers
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.render.entity.LivingEntityRenderer
 *  net.minecraft.client.render.entity.PlayerEntityRenderer
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.model.PlayerEntityModel
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package flow.cosmetic;

import a.rqv;
import a.ucg;
import a.vkl;
import a.vlv;
import a.vmc;
import a.vmo;
import flow.cosmetic.CosmeticFeature;
import flow.cosmetic.CosmeticGlow;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.CosmeticLoader;
import flow.cosmetic.CosmeticMesh;
import flow.cosmetic.CosmeticParticles;
import flow.cosmetic.Motion;
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
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
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
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.RaycastContext;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
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
    private static final Matrix4f MODEL_BASE = new Matrix4f().scale(0.0625f).translate(0.0f, 24.0f, 0.0f).scale(-1.0f, -1.0f, 1.0f);
    private static final Matrix4f IDENTITY = new Matrix4f();
    private static final long START = System.nanoTime();
    private static final double REMOTE_RANGE = 96.0;
    private static List<CosmeticItem> items;
    private static Map<String, CosmeticItem> byId;
    private static final Map<String, String> WORN;
    private static final Map<Integer, Motion> MOTIONS;
    private static final Set<EntityRenderState> HIDDEN;
    private static final ModelPart[] SHIFTED;
    private static final Set<CosmeticItem> VIDEO_SEEN;
    private static final float[] SHIFT_ORIGIN;
    private static final Map<String, Map<String, CosmeticItem>> PARSED;
    private static final CosmeticMesh.Drive DRIVE;
    private static boolean installed;
    private static boolean reloaded;
    private static boolean guiPending;
    private static boolean guiFlip;
    private static boolean inWorld;
    private static long lastFrame;
    private static float frameDt;
    private static Vec3d camPos;
    private static int version;
    private static Map<String, CosmeticItem> localWorn;
    private static int localVersion;
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
            HashMap<String, CosmeticItem> map = new HashMap<String, CosmeticItem>();
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
        Cosmetics.items();
        return id == null ? null : byId.get(id);
    }

    public static List<CosmeticItem> ofSlot(String slot) {
        ArrayList<CosmeticItem> out = new ArrayList<CosmeticItem>();
        for (CosmeticItem it : Cosmetics.items()) {
            if (!it.slot.equals(slot)) continue;
            out.add(it);
        }
        return out;
    }

    public static CosmeticItem worn(String slot) {
        return Cosmetics.get(WORN.get(slot));
    }

    public static boolean isWorn(CosmeticItem it) {
        return it != null && it.id.equals(WORN.get(it.slot));
    }

    public static void toggle(CosmeticItem it) {
        if (Cosmetics.isWorn(it)) {
            WORN.remove(it.slot);
        } else {
            WORN.put(it.slot, it.id);
        }
        ++version;
    }

    public static void clear(String slot) {
        WORN.remove(slot);
        ++version;
    }

    public static void clearAll() {
        WORN.clear();
        ++version;
        CosmeticParticles.clear();
    }

    public static int wornCount() {
        int n = 0;
        for (String slot : CosmeticItem.SLOTS) {
            if (Cosmetics.worn(slot) == null) continue;
            ++n;
        }
        return n;
    }

    public static String code() {
        return ENABLED.get() ? Cosmetics.shareCode() : "";
    }

    public static String shareCode() {
        StringBuilder sb = new StringBuilder();
        for (String slot : CosmeticItem.SLOTS) {
            CosmeticItem it = Cosmetics.worn(slot);
            if (it == null) continue;
            if (!sb.isEmpty()) {
                sb.append(',');
            }
            sb.append(slot).append(':').append(it.id);
        }
        return sb.toString();
    }

    static Map<String, CosmeticItem> parse(String code) {
        if (code == null || code.isBlank()) {
            return Map.of();
        }
        Map<String, CosmeticItem> cached = PARSED.get(code);
        if (cached != null) {
            return cached;
        }
        LinkedHashMap<String, CosmeticItem> out = new LinkedHashMap<String, CosmeticItem>();
        for (String part : code.split(",")) {
            CosmeticItem it;
            int colon = part.indexOf(58);
            if (colon <= 0 || (it = Cosmetics.get(part.substring(colon + 1).trim())) == null || !it.slot.equals(part.substring(0, colon).trim())) continue;
            out.put(it.slot, it);
        }
        if (PARSED.size() > 64) {
            PARSED.clear();
        }
        PARSED.put(code, out);
        return out;
    }

    public static void load(Properties p) {
        WORN.clear();
        for (String slot : CosmeticItem.SLOTS) {
            String id = p.getProperty("cosmetic." + slot);
            if (id == null || id.isBlank()) continue;
            WORN.put(slot, id.trim());
        }
        ++version;
    }

    public static void save(Properties p) {
        for (Map.Entry<String, String> e : WORN.entrySet()) {
            p.setProperty("cosmetic." + e.getKey(), e.getValue());
        }
    }

    public static void install() {
        if (installed) {
            return;
        }
        installed = true;
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((type, renderer, helper, context) -> {
            if (renderer instanceof PlayerEntityRenderer) {
                FeatureRendererContext ctx = (FeatureRendererContext)renderer;
                CosmeticFeature lead = new CosmeticFeature((FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel>)ctx, true);
                helper.register((FeatureRenderer)lead);
                helper.register((FeatureRenderer)new CosmeticFeature((FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel>)ctx, false));
                Cosmetics.lead(renderer, lead);
            }
        });
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(state -> !Cosmetics.hidesVanillaCape(state));
        WorldRenderEvents.BEFORE_ENTITIES.register(Cosmetics::beforeEntities);
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            inWorld = false;
        });
        WorldRenderEvents.END_MAIN.register(context -> CosmeticGlow.flush());
        ClientTickEvents.END_CLIENT_TICK.register(Cosmetics::endTick);
        ScreenEvents.BEFORE_INIT.register((client, screen, w, h) -> {
            ScreenEvents.beforeRender((Screen)screen).register((sc, ctx, mx, my, delta) -> Cosmetics.guiBegin());
            ScreenEvents.afterRender((Screen)screen).register((sc, ctx, mx, my, delta) -> Cosmetics.guiEnd());
        });
    }

    private static void refreshVideos(Map<String, CosmeticItem> worn) {
        for (CosmeticItem it : worn.values()) {
            if (it.videoTexture == null || !VIDEO_SEEN.add(it)) continue;
            it.videoTexture.refresh();
        }
    }

    private static void guiBegin() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (!ENABLED.get() || mc.player == null) {
            return;
        }
        Motion m = MOTIONS.get(mc.player.getId());
        if (m != null) {
            VIDEO_SEEN.clear();
            Cosmetics.refreshVideos(m.worn);
        }
        if (m == null || !m.worn.containsKey("avatar")) {
            return;
        }
        guiPending = true;
        if (!mc.player.isInvisible()) {
            mc.player.setInvisible(true);
            guiFlip = true;
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
        if (!ENABLED.get()) {
            return;
        }
        for (EntityRenderState s : world.entityRenderStates) {
            if (!(s instanceof PlayerEntityRenderState)) continue;
            PlayerEntityRenderState ps = (PlayerEntityRenderState)s;
            Motion m = MOTIONS.get(ps.id);
            if (m == null || !m.worn.containsKey("avatar")) continue;
            ps.invisible = true;
            ps.invisibleToPlayer = true;
            ps.capeVisible = false;
            ps.equippedHeadStack = ItemStack.EMPTY;
            ps.equippedChestStack = ItemStack.EMPTY;
            ps.equippedLegsStack = ItemStack.EMPTY;
            ps.equippedFeetStack = ItemStack.EMPTY;
            ps.headItemRenderState.clear();
            HIDDEN.add((EntityRenderState)ps);
        }
    }

    private static void endTick(MinecraftClient mc) {
        if (reloaded || mc.world == null) {
            return;
        }
        reloaded = true;
        try {
            mc.getEntityRenderDispatcher().reload(mc.getResourceManager());
        }
        catch (Throwable t) {
            System.out.println("cosmetics renderer reload failed: " + t);
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
        return (float)(System.nanoTime() - START) / 1.0E9f;
    }

    private static int frameOf(CosmeticItem it, float t) {
        if (it.frames <= 1 || it.frameTime <= 0.0f) {
            return 0;
        }
        return (int)(t / it.frameTime) % it.frames;
    }

    private static int glowColor(CosmeticItem it, float t) {
        float gain = 1.0f;
        if (it.glowPeriod > 0.0f) {
            gain = it.glowMin + (it.glowMax - it.glowMin) * (0.5f + 0.5f * (float)Math.sin(Math.PI * 2 * (double)t / (double)it.glowPeriod));
        }
        int g = Math.max(0, Math.min(255, Math.round(255.0f * gain)));
        return 0xFF000000 | g << 16 | g << 8 | g;
    }

    private static void submit(CosmeticItem it, Matrix4f[] bones, Matrix4f base, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, float t, boolean world) {
        Cosmetics.submit(it, bones, base, matrices, queue, light, t, world, -2);
    }

    private static void submit(CosmeticItem it, Matrix4f[] bones, Matrix4f base, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, float t, boolean world, int part) {
        boolean live;
        int frame = Cosmetics.frameOf(it, t);
        boolean blink = Cosmetics.DRIVE.blink;
        boolean bl = live = it.videoTexture != null && it.videoTexture.live();
        if (CosmeticMesh.hasSolid(it)) {
            queue.submitCustom(matrices, RenderLayers.entityCutoutNoCull((Identifier)it.albedo), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 0, light, -1, frame, part, blink, live));
        }
        if (live) {
            int vl = LightmapTextureManager.pack((int)Math.max(LightmapTextureManager.getBlockLightCoordinates((int)light), 11), (int)LightmapTextureManager.getSkyLightCoordinates((int)light));
            queue.submitCustom(matrices, RenderLayers.entityCutoutNoCull((Identifier)it.videoId), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 3, vl, -1, frame, part, blink, true));
        }
        if (CosmeticMesh.hasGlass(it)) {
            queue.submitCustom(matrices, RenderLayers.entityTranslucent((Identifier)it.albedo), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 1, light, -1, frame, part, blink));
        }
        if (it.emissive != null) {
            int color = Cosmetics.glowColor(it, t);
            queue.submitCustom(matrices, RenderLayers.eyes((Identifier)it.emissive), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 2, 0xF000F0, color, frame, part, blink));
            if (world && CosmeticGlow.active()) {
                CosmeticGlow.add(it, bones, new Matrix4f((Matrix4fc)matrices.peek().getPositionMatrix()).mul((Matrix4fc)base), color, frame, part, blink);
            }
        }
    }

    private static void renderAvatar(PlayerEntityModel model, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, PlayerEntityRenderState state, Motion motion, CosmeticItem it, float t, boolean world) {
        CosmeticLoader.ensureTextures(it);
        if (!it.loaded) {
            return;
        }
        Cosmetics.DRIVE.legL = model.leftLeg.pitch;
        Cosmetics.DRIVE.legR = model.rightLeg.pitch;
        Cosmetics.DRIVE.hurt = state.hurt;
        Cosmetics.DRIVE.wAttack = state.handSwingProgress > 0.0f ? MathHelper.sin((double)(state.handSwingProgress * (float)Math.PI)) : 0.0f;
        Matrix4f[] bones = CosmeticMesh.pose(it, DRIVE);
        ModelPart[] parts = new ModelPart[]{model.head, model.body, model.rightArm, model.leftArm, model.rightLeg, model.leftLeg};
        for (int p = 0; p < parts.length; ++p) {
            if (!Cosmetics.hasPart(it, p)) continue;
            matrices.push();
            Cosmetics.partTransform(matrices, parts[p], it.partPivots != null ? it.partPivots[p] : null, p >= 4 ? Cosmetics.stride(it, p) : 1.0f);
            Cosmetics.submit(it, bones, MODEL_BASE, matrices, queue, light, t, world, p);
            if (world && PARTICLES.get() && it.emitters.length > 0) {
                Cosmetics.emit(motion, it, bones, new Matrix4f((Matrix4fc)matrices.peek().getPositionMatrix()).mul((Matrix4fc)MODEL_BASE), camPos, (float)Math.toRadians(180.0f - state.bodyYaw), p);
            }
            matrices.pop();
        }
        Cosmetics.fitHands(model, state, it);
    }

    private static void lead(Object renderer, CosmeticFeature feature) {
        try {
            for (Field f : LivingEntityRenderer.class.getDeclaredFields()) {
                if (!List.class.isAssignableFrom(f.getType())) continue;
                f.setAccessible(true);
                List list = (List)f.get(renderer);
                if (list.remove((Object)feature)) {
                    list.add(0, feature);
                }
                return;
            }
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            // empty catch block
        }
    }

    private static void fitHands(PlayerEntityModel model, PlayerEntityRenderState state, CosmeticItem it) {
        for (int p = 2; p <= 3; ++p) {
            float[] h = Cosmetics.handOf(it, p);
            if (h == null) continue;
            ModelPart mp = p == 2 ? model.rightArm : model.leftArm;
            Arm arm = p == 2 ? Arm.RIGHT : Arm.LEFT;
            MatrixStack ms = new MatrixStack();
            Cosmetics.partTransform(ms, mp, it.partPivots != null ? it.partPivots[p] : null);
            Vector3f target = new Matrix4f((Matrix4fc)ms.peek().getPositionMatrix()).mul((Matrix4fc)MODEL_BASE).transformPosition(h[0], h[1], h[2], new Vector3f());
            ms = new MatrixStack();
            model.setArmAngle(state, arm, ms);
            ms.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(-90.0f));
            ms.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(180.0f));
            ms.translate((arm == Arm.LEFT ? -1.0f : 1.0f) / 16.0f, 0.125f, -0.625f);
            Vector3f cur = ms.peek().getPositionMatrix().transformPosition(0.0f, 0.0f, 0.0f, new Vector3f());
            int k = p - 2;
            Cosmetics.SHIFTED[k] = mp;
            Cosmetics.SHIFT_ORIGIN[k * 3] = mp.originX;
            Cosmetics.SHIFT_ORIGIN[k * 3 + 1] = mp.originY;
            Cosmetics.SHIFT_ORIGIN[k * 3 + 2] = mp.originZ;
            mp.originX += (target.x - cur.x) * 16.0f;
            mp.originY += (target.y - cur.y) * 16.0f;
            mp.originZ += (target.z - cur.z) * 16.0f;
        }
    }

    static void restoreArms() {
        for (int k = 0; k < SHIFTED.length; ++k) {
            ModelPart mp = SHIFTED[k];
            if (mp == null) continue;
            mp.originX = SHIFT_ORIGIN[k * 3];
            mp.originY = SHIFT_ORIGIN[k * 3 + 1];
            mp.originZ = SHIFT_ORIGIN[k * 3 + 2];
            Cosmetics.SHIFTED[k] = null;
        }
    }

    private static float[] handOf(CosmeticItem it, int part) {
        if (it.hands == null) {
            float[][] hands = new float[CosmeticItem.PARTS.length][];
            hands[2] = Cosmetics.hand(it, 2);
            hands[3] = Cosmetics.hand(it, 3);
            it.hands = hands;
        }
        return it.hands[part];
    }

    private static float[] hand(CosmeticItem it, int part) {
        Matrix4f[] rest = CosmeticLoader.rest(it.bones);
        float minY = Cosmetics.lowest(it, rest, part);
        if (minY == Float.MAX_VALUE) {
            return null;
        }
        float x0 = Float.MAX_VALUE;
        float x1 = -3.4028235E38f;
        float z0 = Float.MAX_VALUE;
        Vector3f p = new Vector3f();
        for (int i = 0; i < it.bones.length; ++i) {
            CosmeticItem.Bone b = it.bones[i];
            if (b.part != part) continue;
            for (float[] v : new float[][]{b.solid, b.glass}) {
                if (v == null) continue;
                int k = 0;
                while (k + 7 < v.length) {
                    rest[i].transformPosition(v[k], v[k + 1], v[k + 2], p);
                    if (p.y < minY + 3.0f) {
                        x0 = Math.min(x0, p.x);
                        x1 = Math.max(x1, p.x);
                        z0 = Math.min(z0, p.z);
                    }
                    k += 8;
                }
            }
        }
        return new float[]{(x0 + x1) / 2.0f, minY, z0};
    }

    private static boolean hasPart(CosmeticItem it, int part) {
        for (CosmeticItem.Bone b : it.bones) {
            if (b.part != part) continue;
            return true;
        }
        return false;
    }

    private static float stride(CosmeticItem it, int part) {
        if (it.stride == null) {
            float[] out = new float[CosmeticItem.PARTS.length];
            Matrix4f[] rest = CosmeticLoader.rest(it.bones);
            for (int p = 4; p < out.length; ++p) {
                float top = it.partPivots != null && it.partPivots[p] != null ? it.partPivots[p][1] : 12.0f;
                float low = Cosmetics.lowest(it, rest, p);
                float len = low == Float.MAX_VALUE ? 12.0f : top - low;
                out[p] = len > 12.5f ? Math.max(0.45f, 12.0f / len) : 1.0f;
            }
            it.stride = out;
        }
        return it.stride[part];
    }

    private static float lowest(CosmeticItem it, Matrix4f[] rest, int part) {
        float y = Float.MAX_VALUE;
        Vector3f v = new Vector3f();
        for (int i = 0; i < it.bones.length; ++i) {
            CosmeticItem.Bone b = it.bones[i];
            if (b.part != part) continue;
            for (float[] arr : new float[][]{b.solid, b.glass}) {
                if (arr == null) continue;
                int k = 0;
                while (k + 7 < arr.length) {
                    y = Math.min(y, rest[i].transformPosition((float)arr[k], (float)arr[k + 1], (float)arr[k + 2], (Vector3f)v).y);
                    k += 8;
                }
            }
        }
        return y;
    }

    private static void partTransform(MatrixStack matrices, ModelPart mp, float[] pivot) {
        Cosmetics.partTransform(matrices, mp, pivot, 1.0f);
    }

    private static void partTransform(MatrixStack matrices, ModelPart mp, float[] pivot, float stride) {
        ModelTransform def = mp.getDefaultTransform();
        float ax = pivot != null ? -pivot[0] : def.x();
        float ay = pivot != null ? 24.0f - pivot[1] : def.y();
        float az = pivot != null ? pivot[2] : def.z();
        matrices.translate((ax + mp.originX - def.x()) / 16.0f, (ay + mp.originY - def.y()) / 16.0f, (az + mp.originZ - def.z()) / 16.0f);
        if (mp.pitch != 0.0f || mp.yaw != 0.0f || mp.roll != 0.0f) {
            matrices.multiply((Quaternionfc)new Quaternionf().rotationZYX(mp.roll, mp.yaw, mp.pitch * stride));
        }
        if (mp.xScale != 1.0f || mp.yScale != 1.0f || mp.zScale != 1.0f) {
            matrices.scale(mp.xScale, mp.yScale, mp.zScale);
        }
        matrices.translate(-ax / 16.0f, -ay / 16.0f, -az / 16.0f);
    }

    static void renderWorn(PlayerEntityModel model, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, PlayerEntityRenderState state) {
        if (!ENABLED.get() || rqv.isFadedBody((EntityRenderState)state)) {
            return;
        }
        Motion motion = MOTIONS.get(state.id);
        if (motion == null || motion.worn.isEmpty()) {
            return;
        }
        MinecraftClient mc = MinecraftClient.getInstance();
        boolean hidden = HIDDEN.contains(state) || !inWorld && guiPending && mc.player != null && state.id == mc.player.getId();
        float t = Cosmetics.seconds();
        CosmeticMesh.Drive d = DRIVE;
        motion.body(d);
        CosmeticItem avatar = motion.worn.get("avatar");
        if (avatar != null && hidden) {
            Cosmetics.renderAvatar(model, matrices, queue, light, state, motion, avatar, t, inWorld);
        }
        CosmeticItem fitTo = avatar != null && hidden && avatar.loaded ? avatar : null;
        for (String slot : BODY_SLOTS) {
            float[] fArray;
            CosmeticItem it = motion.worn.get(slot);
            if (it == null || it.isPet() || it.isAvatar() || "wings".equals(slot) && state.equippedChestStack != null && state.equippedChestStack.isOf(Items.ELYTRA)) continue;
            CosmeticLoader.ensureTextures(it);
            if (!it.loaded) continue;
            if (it.isCape()) {
                float[] fArray2 = new float[3];
                fArray2[0] = -(6.0f + state.field_53537 / 2.0f + state.field_53536);
                fArray2[1] = 0.0f;
                fArray = fArray2;
                fArray2[2] = state.field_53538 / 2.0f;
            } else {
                fArray = null;
            }
            d.cape = fArray;
            Matrix4f[] bones = CosmeticMesh.pose(it, d);
            matrices.push();
            if (it.isCape() && state.equippedChestStack != null && !state.equippedChestStack.isEmpty()) {
                matrices.translate(0.0f, -0.053125f, 0.06875f);
            }
            Matrix4f base = MODEL_BASE;
            if (fitTo != null) {
                float[] f;
                int p = it.onHead() ? 0 : 1;
                Cosmetics.partTransform(matrices, p == 0 ? model.head : model.body, fitTo.partPivots != null ? fitTo.partPivots[p] : null);
                float[] fArray3 = f = p == 0 ? fitTo.headFit : fitTo.backFit;
                if (f != null) {
                    base = new Matrix4f((Matrix4fc)MODEL_BASE).mul((Matrix4fc)new Matrix4f().translation(f[0], f[1], f[2]).rotateZ((float)Math.toRadians(f[5])).rotateX((float)Math.toRadians(f[4])).scale(f[3]).translate(0.0f, p == 0 ? -32.0f : -24.0f, p == 0 ? 0.0f : -2.0f));
                }
            } else {
                (it.onHead() ? model.head : model.body).applyTransform(matrices);
            }
            Cosmetics.submit(it, bones, base, matrices, queue, light, t, inWorld);
            if (inWorld && PARTICLES.get() && it.emitters.length > 0) {
                Cosmetics.emit(motion, it, bones, new Matrix4f((Matrix4fc)matrices.peek().getPositionMatrix()).mul((Matrix4fc)base), camPos, (float)Math.toRadians(180.0f - state.bodyYaw), -2);
            }
            matrices.pop();
        }
        d.cape = null;
    }

    private static void emit(Motion motion, CosmeticItem it, Matrix4f[] bones, Matrix4f m, Vec3d origin, float yaw, int part) {
        for (int i = 0; i < it.emitters.length; ++i) {
            CosmeticItem.Emitter em = it.emitters[i];
            if (part != -2 && it.bones[em.bone].part != part) continue;
            float[] slot = motion.emit.computeIfAbsent(em, k -> new float[1]);
            float acc = slot[0] + em.rate * frameDt;
            if (acc >= 1.0f) {
                Vector3f p = new Matrix4f((Matrix4fc)m).mul((Matrix4fc)bones[em.bone]).transformPosition(em.ox, em.oy, em.oz, new Vector3f());
                while (acc >= 1.0f) {
                    acc -= 1.0f;
                    CosmeticParticles.spawn(em, origin.x + (double)p.x, origin.y + (double)p.y, origin.z + (double)p.z, yaw);
                }
            }
            slot[0] = Math.min(acc, 4.0f);
        }
    }

    private static Map<String, CosmeticItem> wornOf(MinecraftClient mc, PlayerEntity p) {
        if (p == mc.player) {
            if (localVersion != version) {
                LinkedHashMap<String, CosmeticItem> map = new LinkedHashMap<String, CosmeticItem>();
                for (String slot : CosmeticItem.SLOTS) {
                    CosmeticItem it = Cosmetics.worn(slot);
                    if (it == null) continue;
                    map.put(slot, it);
                }
                localWorn = map;
                localVersion = version;
            }
            return localWorn;
        }
        if (!PARTY.get() || !ucg.inParty()) {
            return Map.of();
        }
        return Cosmetics.parse(ucg.cosmeticsOf(p.getGameProfile().name()));
    }

    private static void beforeEntities(WorldRenderContext context) {
        inWorld = true;
        guiPending = false;
        long now = System.nanoTime();
        frameDt = lastFrame == 0L ? 0.0f : Math.min(0.1f, (float)(now - lastFrame) / 1.0E9f);
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
                    Map<String, CosmeticItem> worn;
                    boolean local;
                    boolean bl = local = p == mc.player;
                    if (!local && p.squaredDistanceTo(camPos) > 9216.0 || (worn = Cosmetics.wornOf(mc, (PlayerEntity)p)).isEmpty()) continue;
                    Motion m2 = MOTIONS.computeIfAbsent(p.getId(), Motion::new);
                    m2.worn = worn;
                    m2.seen = now;
                    m2.update((PlayerEntity)p, td, frameDt, local);
                    Cosmetics.refreshVideos(worn);
                    CosmeticItem pet = worn.get("pet");
                    if (pet == null) continue;
                    Cosmetics.pet(context, mc, (PlayerEntity)p, m2, pet, td, local);
                }
            }
            MOTIONS.values().removeIf(m -> now - m.seen > 2000000000L);
            if (PARTICLES.get()) {
                CosmeticParticles.render(context.matrices(), context.commandQueue(), camPos, camera.getRotation());
            } else {
                CosmeticParticles.clear();
            }
        }
        catch (Throwable t) {
            System.out.println("cosmetics world pass failed: " + t);
        }
    }

    private static int petLight(MinecraftClient mc, Motion m, PlayerEntity owner) {
        BlockPos[] at;
        ClientWorld w = mc.world;
        int sky = 0;
        int block = 0;
        for (BlockPos pos : at = new BlockPos[]{BlockPos.ofFloored((double)m.petPos.x, (double)(m.petPos.y + 0.25), (double)m.petPos.z), BlockPos.ofFloored((double)m.petPos.x, (double)(m.petPos.y + 0.9), (double)m.petPos.z), BlockPos.ofFloored((double)owner.getX(), (double)owner.getEyeY(), (double)owner.getZ())}) {
            int packed = WorldRenderer.getLightmapCoordinates((BlockRenderView)w, (BlockPos)pos);
            sky = Math.max(sky, LightmapTextureManager.getSkyLightCoordinates((int)packed));
            block = Math.max(block, LightmapTextureManager.getBlockLightCoordinates((int)packed));
        }
        if (m.petSky < 0.0f) {
            m.petSky = sky;
            m.petBlock = block;
        } else {
            float k = 1.0f - (float)Math.exp(-frameDt * 5.0f);
            m.petSky += ((float)sky - m.petSky) * k;
            m.petBlock += ((float)block - m.petBlock) * k;
        }
        int s = Math.round(m.petSky * 16.0f);
        int b = Math.round(m.petBlock * 16.0f);
        return Math.min(240, s) << 16 | Math.min(240, b);
    }

    static Vec3d groundSpot(MinecraftClient mc, PlayerEntity player, Vec3d pp, Motion m, CosmeticItem pet) {
        double yr = Math.toRadians(m.bodyYaw);
        double fx = -Math.sin(yr);
        double fz = Math.cos(yr);
        double side = pet.anchor[0] >= 0.0f ? 1.0 : -1.0;
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
        return new Vec3d(x, Cosmetics.groundY(mc, player, x, pp.y, z) - (double)(Cosmetics.petFoot(pet) / 16.0f), z);
    }

    private static double groundY(MinecraftClient mc, PlayerEntity player, double x, double y, double z) {
        BlockHitResult hit = mc.world.raycast(new RaycastContext(new Vec3d(x, y + 1.2, z), new Vec3d(x, y - 4.0, z), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)player));
        return hit.getType() == HitResult.Type.MISS ? y : hit.getPos().y;
    }

    private static float petFoot(CosmeticItem pet) {
        if (Float.isNaN(pet.petFoot)) {
            float low = Float.MAX_VALUE;
            Matrix4f[] rest = CosmeticLoader.rest(pet.bones);
            Vector3f v = new Vector3f();
            for (int i = 0; i < pet.bones.length; ++i) {
                CosmeticItem.Bone b = pet.bones[i];
                for (float[] arr : new float[][]{b.solid, b.glass}) {
                    if (arr == null) continue;
                    int k = 0;
                    while (k + 7 < arr.length) {
                        low = Math.min(low, rest[i].transformPosition((float)arr[k], (float)arr[k + 1], (float)arr[k + 2], (Vector3f)v).y);
                        k += 8;
                    }
                }
            }
            pet.petFoot = low == Float.MAX_VALUE ? 0.0f : low;
        }
        return pet.petFoot;
    }

    static void follow(Motion m, Vec3d target, float dt, boolean walking) {
        double dist = m.petPos.distanceTo(target);
        double w = walking ? Math.PI * 2 * (0.5 + 0.3 * Math.min(dist, 5.0)) : Math.PI * 2 * (1.35 + 0.4 * Math.min(dist, 4.0));
        double zeta = walking ? 0.95 : 0.66;
        int steps = Math.max(1, (int)Math.ceil(dt / 0.008f));
        double h = dt / (float)steps;
        double x = m.petPos.x;
        double y = m.petPos.y;
        double z = m.petPos.z;
        double vx = m.petVel.x;
        double vy = m.petVel.y;
        double vz = m.petVel.z;
        for (int k = 0; k < steps; ++k) {
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

    /*
     * Unable to fully structure code
     */
    private static void pet(WorldRenderContext context, MinecraftClient mc, PlayerEntity player, Motion m, CosmeticItem pet, float td, boolean local) {
        if (player.isSpectator() || pet.anchor == null) {
            m.petPos = null;
            return;
        }
        CosmeticLoader.ensureTextures(pet);
        if (!pet.loaded) {
            return;
        }
        pp = player.getLerpedPos(td);
        firstPerson = local != false && mc.options.getPerspective().isFirstPerson() != false;
        yaw = firstPerson != false ? MathHelper.lerpAngleDegrees((float)td, (float)player.lastYaw, (float)player.getYaw()) : m.bodyYaw;
        t = Cosmetics.seconds();
        v0 = walking = Cosmetics.PET_MODE.is("Follow") != false && player.getAbilities().flying == false && player.isGliding() == false && player.isTouchingWater() == false && player.hasVehicle() == false;
        if (walking) {
            target = Cosmetics.groundSpot(mc, player, pp, m, pet);
        } else {
            m.petRun = false;
            a = new Vector3f(pet.anchor);
            if (firstPerson) {
                a.set(a.x * 1.6f, a.y - 1.5f, a.z + 1.5f);
            }
            rest = (1.0f - m.walkW) * (1.0f - m.flyW);
            a.add(rest * 1.6f * (float)Math.sin(t * 0.53f), rest * 0.9f * (float)Math.sin(t * 0.81f + 1.3f), rest * 1.3f * (float)Math.cos(t * 0.37f));
            a.div(16.0f).rotateY((float)Math.toRadians(180.0f - yaw));
            target = pp.add((double)a.x, (double)a.y, (double)a.z);
        }
        if (m.petPos == null || m.petWorld != mc.world) ** GOTO lbl-1000
        v1 = m.petPos.squaredDistanceTo(target);
        v2 = walking != false ? 196 : 36;
        if (v1 > (double)v2) lbl-1000:
        // 2 sources

        {
            m.petPos = target;
            m.petVel = Vec3d.ZERO;
            m.petLast = null;
            m.petYaw = yaw;
            m.petWorld = mc.world;
            m.petSky = -1.0f;
        } else {
            Cosmetics.follow(m, target, Cosmetics.frameDt, walking);
            face = yaw;
            if (walking) {
                vx = m.petVel.x;
                vz = m.petVel.z;
                face = vx * vx + vz * vz > 0.36 ? (float)Math.toDegrees(Math.atan2(-vx, vz)) : (float)Math.toDegrees(Math.atan2(-(pp.x - m.petPos.x), pp.z - m.petPos.z));
            }
            m.petYaw = MathHelper.lerpAngleDegrees((float)(1.0f - (float)Math.exp(-Cosmetics.frameDt * (walking != false ? 7.0f : 4.0f))), (float)m.petYaw, (float)face);
        }
        m.petStep(Cosmetics.frameDt);
        d = Cosmetics.DRIVE;
        m.pet(d);
        if (walking) {
            sp = Math.hypot(m.petVel.x, m.petVel.z);
            m.petWalk += ((float)MathHelper.clamp((double)((sp - 0.3) / 2.5), (double)0.0, (double)1.0) - m.petWalk) * (1.0f - (float)Math.exp(-Cosmetics.frameDt * 8.0f));
            m.petWalkT += Cosmetics.frameDt * (0.75f + 0.35f * (float)Math.min(2.0, sp / 4.3));
            d.wIdle = 1.0f - m.petWalk;
            d.wWalk = m.petWalk;
            d.wFly = 0.0f;
            d.tWalk = m.petWalkT;
            d.roll *= 0.3f;
            d.pitch *= 0.3f;
        } else {
            m.petWalk = 0.0f;
        }
        bones = CosmeticMesh.pose(pet, d);
        yawRad = (float)Math.toRadians(180.0f - m.petYaw);
        if (firstPerson) {
            dist = m.petPos.squaredDistanceTo(Cosmetics.camPos);
            m.petHidden = m.petHidden ? dist < 1.1 : dist < 0.8;
        } else {
            m.petHidden = false;
        }
        if (!(firstPerson && !Cosmetics.PET_FIRST_PERSON.get() || m.petHidden)) {
            ms = context.matrices();
            ms.push();
            ms.translate(m.petPos.x - Cosmetics.camPos.x, m.petPos.y - Cosmetics.camPos.y, m.petPos.z - Cosmetics.camPos.z);
            ms.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - m.petYaw));
            ms.scale(0.0625f, 0.0625f, 0.0625f);
            Cosmetics.submit(pet, bones, Cosmetics.IDENTITY, ms, context.commandQueue(), Cosmetics.petLight(mc, m, player), t, true);
            ms.pop();
        }
        if (Cosmetics.PARTICLES.get() && pet.emitters.length > 0) {
            Cosmetics.emit(m, pet, bones, new Matrix4f().rotateY(yawRad).scale(0.0625f), m.petPos, yawRad, -2);
        }
    }

    static {
        WORN = new LinkedHashMap<String, String>();
        MOTIONS = new HashMap<Integer, Motion>();
        HIDDEN = Collections.newSetFromMap(new IdentityHashMap());
        SHIFTED = new ModelPart[2];
        VIDEO_SEEN = Collections.newSetFromMap(new IdentityHashMap());
        SHIFT_ORIGIN = new float[6];
        PARSED = new HashMap<String, Map<String, CosmeticItem>>();
        DRIVE = new CosmeticMesh.Drive();
        camPos = Vec3d.ZERO;
        localWorn = Map.of();
        localVersion = -1;
    }
}

