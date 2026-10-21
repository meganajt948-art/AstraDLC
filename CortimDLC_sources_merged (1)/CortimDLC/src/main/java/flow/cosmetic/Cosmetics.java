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
 *  net.minecraft.class_10017
 *  net.minecraft.class_10055
 *  net.minecraft.class_1007
 *  net.minecraft.class_11658
 *  net.minecraft.class_11659
 *  net.minecraft.class_12249
 *  net.minecraft.class_1297
 *  net.minecraft.class_1306
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4184
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_5603
 *  net.minecraft.class_591
 *  net.minecraft.class_630
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 *  net.minecraft.class_761
 *  net.minecraft.class_765
 *  net.minecraft.class_7833
 *  net.minecraft.class_922
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package flow.cosmetic;

import a.SeeInvisible;
import a.PartyClient;
import a.BoolSetting;
import a.ModeSetting;
import a.NumberSetting;
import a.Setting;
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
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_11658;
import net.minecraft.class_11659;
import net.minecraft.class_12249;
import net.minecraft.class_1297;
import net.minecraft.class_1306;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_5603;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_761;
import net.minecraft.class_765;
import net.minecraft.class_7833;
import net.minecraft.class_922;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public final class Cosmetics {
    public static final BoolSetting ENABLED = new BoolSetting("Cosmetics", true);
    public static final NumberSetting GLOW = new NumberSetting("Glow", 1.0, 0.0, 2.0, 0.05).percent();
    public static final BoolSetting PARTICLES = new BoolSetting("Cosmetic particles", true);
    public static final BoolSetting PET_FIRST_PERSON = new BoolSetting("Pet in first person", true);
    public static final BoolSetting PARTY = new BoolSetting("Party cosmetics", true);
    public static final ModeSetting PET_MODE = new ModeSetting("Pet mode", "Shoulder", "Shoulder", "Follow");
    public static final List<Setting> OPTIONS = List.of(GLOW, PARTICLES, PET_MODE, PET_FIRST_PERSON, PARTY);
    public static final List<Setting> ALL = List.of(ENABLED, GLOW, PARTICLES, PET_MODE, PET_FIRST_PERSON, PARTY);
    private static final String[] BODY_SLOTS = new String[]{"wings", "back", "cape", "hat", "face"};
    private static final Matrix4f MODEL_BASE = new Matrix4f().scale(0.0625f).translate(0.0f, 24.0f, 0.0f).scale(-1.0f, -1.0f, 1.0f);
    private static final Matrix4f IDENTITY = new Matrix4f();
    private static final long START = System.nanoTime();
    private static final double REMOTE_RANGE = 96.0;
    private static List<CosmeticItem> items;
    private static Map<String, CosmeticItem> byId;
    private static final Map<String, String> WORN;
    private static final Map<Integer, Motion> MOTIONS;
    private static final Set<class_10017> HIDDEN;
    private static final class_630[] SHIFTED;
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
    private static class_243 camPos;
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
            if (renderer instanceof class_1007) {
                class_3883 ctx = (class_3883)renderer;
                CosmeticFeature lead = new CosmeticFeature((class_3883<class_10055, class_591>)ctx, true);
                helper.register((class_3887)lead);
                helper.register((class_3887)new CosmeticFeature((class_3883<class_10055, class_591>)ctx, false));
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
            ScreenEvents.beforeRender((class_437)screen).register((sc, ctx, mx, my, delta) -> Cosmetics.guiBegin());
            ScreenEvents.afterRender((class_437)screen).register((sc, ctx, mx, my, delta) -> Cosmetics.guiEnd());
        });
    }

    private static void refreshVideos(Map<String, CosmeticItem> worn) {
        for (CosmeticItem it : worn.values()) {
            if (it.videoTexture == null || !VIDEO_SEEN.add(it)) continue;
            it.videoTexture.refresh();
        }
    }

    private static void guiBegin() {
        class_310 mc = class_310.method_1551();
        if (!ENABLED.get() || mc.field_1724 == null) {
            return;
        }
        Motion m = MOTIONS.get(mc.field_1724.method_5628());
        if (m != null) {
            VIDEO_SEEN.clear();
            Cosmetics.refreshVideos(m.worn);
        }
        if (m == null || !m.worn.containsKey("avatar")) {
            return;
        }
        guiPending = true;
        if (!mc.field_1724.method_5767()) {
            mc.field_1724.method_5648(true);
            guiFlip = true;
        }
    }

    private static void guiEnd() {
        class_310 mc = class_310.method_1551();
        if (guiFlip && mc.field_1724 != null) {
            mc.field_1724.method_5648(false);
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

    public static boolean hidesBody(class_10017 state) {
        return !HIDDEN.isEmpty() && HIDDEN.contains(state);
    }

    public static void afterExtraction(class_11658 world) {
        HIDDEN.clear();
        if (!ENABLED.get()) {
            return;
        }
        for (class_10017 s : world.field_61735) {
            if (!(s instanceof class_10055)) continue;
            class_10055 ps = (class_10055)s;
            Motion m = MOTIONS.get(ps.field_53528);
            if (m == null || !m.worn.containsKey("avatar")) continue;
            ps.field_53333 = true;
            ps.field_53461 = true;
            ps.field_53532 = false;
            ps.field_55309 = class_1799.field_8037;
            ps.field_53418 = class_1799.field_8037;
            ps.field_53419 = class_1799.field_8037;
            ps.field_53420 = class_1799.field_8037;
            ps.field_53467.method_65605();
            HIDDEN.add((class_10017)ps);
        }
    }

    private static void endTick(class_310 mc) {
        if (reloaded || mc.field_1687 == null) {
            return;
        }
        reloaded = true;
        try {
            mc.method_1561().method_14491(mc.method_1478());
        }
        catch (Throwable t) {
            System.out.println("cosmetics renderer reload failed: " + t);
        }
    }

    private static boolean hidesVanillaCape(class_10055 state) {
        if (!ENABLED.get()) {
            return false;
        }
        Motion m = MOTIONS.get(state.field_53528);
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

    private static void submit(CosmeticItem it, Matrix4f[] bones, Matrix4f base, class_4587 matrices, class_11659 queue, int light, float t, boolean world) {
        Cosmetics.submit(it, bones, base, matrices, queue, light, t, world, -2);
    }

    private static void submit(CosmeticItem it, Matrix4f[] bones, Matrix4f base, class_4587 matrices, class_11659 queue, int light, float t, boolean world, int part) {
        boolean live;
        int frame = Cosmetics.frameOf(it, t);
        boolean blink = Cosmetics.DRIVE.blink;
        boolean bl = live = it.videoTexture != null && it.videoTexture.live();
        if (CosmeticMesh.hasSolid(it)) {
            queue.method_73483(matrices, class_12249.method_75994((class_2960)it.albedo), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 0, light, -1, frame, part, blink, live));
        }
        if (live) {
            int vl = class_765.method_23687((int)Math.max(class_765.method_24186((int)light), 11), (int)class_765.method_24187((int)light));
            queue.method_73483(matrices, class_12249.method_75994((class_2960)it.videoId), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 3, vl, -1, frame, part, blink, true));
        }
        if (CosmeticMesh.hasGlass(it)) {
            queue.method_73483(matrices, class_12249.method_76000((class_2960)it.albedo), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 1, light, -1, frame, part, blink));
        }
        if (it.emissive != null) {
            int color = Cosmetics.glowColor(it, t);
            queue.method_73483(matrices, class_12249.method_76014((class_2960)it.emissive), (entry, vc) -> CosmeticMesh.emit(it, bones, base, entry, vc, 2, 0xF000F0, color, frame, part, blink));
            if (world && CosmeticGlow.active()) {
                CosmeticGlow.add(it, bones, new Matrix4f((Matrix4fc)matrices.method_23760().method_23761()).mul((Matrix4fc)base), color, frame, part, blink);
            }
        }
    }

    private static void renderAvatar(class_591 model, class_4587 matrices, class_11659 queue, int light, class_10055 state, Motion motion, CosmeticItem it, float t, boolean world) {
        CosmeticLoader.ensureTextures(it);
        if (!it.loaded) {
            return;
        }
        Cosmetics.DRIVE.legL = model.field_3397.field_3654;
        Cosmetics.DRIVE.legR = model.field_3392.field_3654;
        Cosmetics.DRIVE.hurt = state.field_53460;
        Cosmetics.DRIVE.wAttack = state.field_63604 > 0.0f ? class_3532.method_15374((double)(state.field_63604 * (float)Math.PI)) : 0.0f;
        Matrix4f[] bones = CosmeticMesh.pose(it, DRIVE);
        class_630[] parts = new class_630[]{model.field_3398, model.field_3391, model.field_3401, model.field_27433, model.field_3392, model.field_3397};
        for (int p = 0; p < parts.length; ++p) {
            if (!Cosmetics.hasPart(it, p)) continue;
            matrices.method_22903();
            Cosmetics.partTransform(matrices, parts[p], it.partPivots != null ? it.partPivots[p] : null, p >= 4 ? Cosmetics.stride(it, p) : 1.0f);
            Cosmetics.submit(it, bones, MODEL_BASE, matrices, queue, light, t, world, p);
            if (world && PARTICLES.get() && it.emitters.length > 0) {
                Cosmetics.emit(motion, it, bones, new Matrix4f((Matrix4fc)matrices.method_23760().method_23761()).mul((Matrix4fc)MODEL_BASE), camPos, (float)Math.toRadians(180.0f - state.field_53446), p);
            }
            matrices.method_22909();
        }
        Cosmetics.fitHands(model, state, it);
    }

    private static void lead(Object renderer, CosmeticFeature feature) {
        try {
            for (Field f : class_922.class.getDeclaredFields()) {
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

    private static void fitHands(class_591 model, class_10055 state, CosmeticItem it) {
        for (int p = 2; p <= 3; ++p) {
            float[] h = Cosmetics.handOf(it, p);
            if (h == null) continue;
            class_630 mp = p == 2 ? model.field_3401 : model.field_27433;
            class_1306 arm = p == 2 ? class_1306.field_6183 : class_1306.field_6182;
            class_4587 ms = new class_4587();
            Cosmetics.partTransform(ms, mp, it.partPivots != null ? it.partPivots[p] : null);
            Vector3f target = new Matrix4f((Matrix4fc)ms.method_23760().method_23761()).mul((Matrix4fc)MODEL_BASE).transformPosition(h[0], h[1], h[2], new Vector3f());
            ms = new class_4587();
            model.method_72859(state, arm, ms);
            ms.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(-90.0f));
            ms.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(180.0f));
            ms.method_46416((arm == class_1306.field_6182 ? -1.0f : 1.0f) / 16.0f, 0.125f, -0.625f);
            Vector3f cur = ms.method_23760().method_23761().transformPosition(0.0f, 0.0f, 0.0f, new Vector3f());
            int k = p - 2;
            Cosmetics.SHIFTED[k] = mp;
            Cosmetics.SHIFT_ORIGIN[k * 3] = mp.field_3657;
            Cosmetics.SHIFT_ORIGIN[k * 3 + 1] = mp.field_3656;
            Cosmetics.SHIFT_ORIGIN[k * 3 + 2] = mp.field_3655;
            mp.field_3657 += (target.x - cur.x) * 16.0f;
            mp.field_3656 += (target.y - cur.y) * 16.0f;
            mp.field_3655 += (target.z - cur.z) * 16.0f;
        }
    }

    static void restoreArms() {
        for (int k = 0; k < SHIFTED.length; ++k) {
            class_630 mp = SHIFTED[k];
            if (mp == null) continue;
            mp.field_3657 = SHIFT_ORIGIN[k * 3];
            mp.field_3656 = SHIFT_ORIGIN[k * 3 + 1];
            mp.field_3655 = SHIFT_ORIGIN[k * 3 + 2];
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

    private static void partTransform(class_4587 matrices, class_630 mp, float[] pivot) {
        Cosmetics.partTransform(matrices, mp, pivot, 1.0f);
    }

    private static void partTransform(class_4587 matrices, class_630 mp, float[] pivot, float stride) {
        class_5603 def = mp.method_41921();
        float ax = pivot != null ? -pivot[0] : def.comp_2997();
        float ay = pivot != null ? 24.0f - pivot[1] : def.comp_2998();
        float az = pivot != null ? pivot[2] : def.comp_2999();
        matrices.method_46416((ax + mp.field_3657 - def.comp_2997()) / 16.0f, (ay + mp.field_3656 - def.comp_2998()) / 16.0f, (az + mp.field_3655 - def.comp_2999()) / 16.0f);
        if (mp.field_3654 != 0.0f || mp.field_3675 != 0.0f || mp.field_3674 != 0.0f) {
            matrices.method_22907((Quaternionfc)new Quaternionf().rotationZYX(mp.field_3674, mp.field_3675, mp.field_3654 * stride));
        }
        if (mp.field_37938 != 1.0f || mp.field_37939 != 1.0f || mp.field_37940 != 1.0f) {
            matrices.method_22905(mp.field_37938, mp.field_37939, mp.field_37940);
        }
        matrices.method_46416(-ax / 16.0f, -ay / 16.0f, -az / 16.0f);
    }

    static void renderWorn(class_591 model, class_4587 matrices, class_11659 queue, int light, class_10055 state) {
        if (!ENABLED.get() || SeeInvisible.isFadedBody((class_10017)state)) {
            return;
        }
        Motion motion = MOTIONS.get(state.field_53528);
        if (motion == null || motion.worn.isEmpty()) {
            return;
        }
        class_310 mc = class_310.method_1551();
        boolean hidden = HIDDEN.contains(state) || !inWorld && guiPending && mc.field_1724 != null && state.field_53528 == mc.field_1724.method_5628();
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
            if (it == null || it.isPet() || it.isAvatar() || "wings".equals(slot) && state.field_53418 != null && state.field_53418.method_31574(class_1802.field_8833)) continue;
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
            matrices.method_22903();
            if (it.isCape() && state.field_53418 != null && !state.field_53418.method_7960()) {
                matrices.method_46416(0.0f, -0.053125f, 0.06875f);
            }
            Matrix4f base = MODEL_BASE;
            if (fitTo != null) {
                float[] f;
                int p = it.onHead() ? 0 : 1;
                Cosmetics.partTransform(matrices, p == 0 ? model.field_3398 : model.field_3391, fitTo.partPivots != null ? fitTo.partPivots[p] : null);
                float[] fArray3 = f = p == 0 ? fitTo.headFit : fitTo.backFit;
                if (f != null) {
                    base = new Matrix4f((Matrix4fc)MODEL_BASE).mul((Matrix4fc)new Matrix4f().translation(f[0], f[1], f[2]).rotateZ((float)Math.toRadians(f[5])).rotateX((float)Math.toRadians(f[4])).scale(f[3]).translate(0.0f, p == 0 ? -32.0f : -24.0f, p == 0 ? 0.0f : -2.0f));
                }
            } else {
                (it.onHead() ? model.field_3398 : model.field_3391).method_22703(matrices);
            }
            Cosmetics.submit(it, bones, base, matrices, queue, light, t, inWorld);
            if (inWorld && PARTICLES.get() && it.emitters.length > 0) {
                Cosmetics.emit(motion, it, bones, new Matrix4f((Matrix4fc)matrices.method_23760().method_23761()).mul((Matrix4fc)base), camPos, (float)Math.toRadians(180.0f - state.field_53446), -2);
            }
            matrices.method_22909();
        }
        d.cape = null;
    }

    private static void emit(Motion motion, CosmeticItem it, Matrix4f[] bones, Matrix4f m, class_243 origin, float yaw, int part) {
        for (int i = 0; i < it.emitters.length; ++i) {
            CosmeticItem.Emitter em = it.emitters[i];
            if (part != -2 && it.bones[em.bone].part != part) continue;
            float[] slot = motion.emit.computeIfAbsent(em, k -> new float[1]);
            float acc = slot[0] + em.rate * frameDt;
            if (acc >= 1.0f) {
                Vector3f p = new Matrix4f((Matrix4fc)m).mul((Matrix4fc)bones[em.bone]).transformPosition(em.ox, em.oy, em.oz, new Vector3f());
                while (acc >= 1.0f) {
                    acc -= 1.0f;
                    CosmeticParticles.spawn(em, origin.field_1352 + (double)p.x, origin.field_1351 + (double)p.y, origin.field_1350 + (double)p.z, yaw);
                }
            }
            slot[0] = Math.min(acc, 4.0f);
        }
    }

    private static Map<String, CosmeticItem> wornOf(class_310 mc, class_1657 p) {
        if (p == mc.field_1724) {
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
        if (!PARTY.get() || !PartyClient.inParty()) {
            return Map.of();
        }
        return Cosmetics.parse(PartyClient.cosmeticsOf(p.method_7334().name()));
    }

    private static void beforeEntities(WorldRenderContext context) {
        inWorld = true;
        guiPending = false;
        long now = System.nanoTime();
        frameDt = lastFrame == 0L ? 0.0f : Math.min(0.1f, (float)(now - lastFrame) / 1.0E9f);
        lastFrame = now;
        CosmeticGlow.begin();
        class_310 mc = class_310.method_1551();
        class_4184 camera = mc.field_1773.method_19418();
        camPos = camera.method_71156();
        CosmeticParticles.step(frameDt);
        try {
            VIDEO_SEEN.clear();
            if (ENABLED.get() && mc.field_1724 != null && mc.field_1687 != null) {
                float td = mc.method_61966().method_60637(true);
                for (class_742 p : mc.field_1687.method_18456()) {
                    Map<String, CosmeticItem> worn;
                    boolean local;
                    boolean bl = local = p == mc.field_1724;
                    if (!local && p.method_5707(camPos) > 9216.0 || (worn = Cosmetics.wornOf(mc, (class_1657)p)).isEmpty()) continue;
                    Motion m2 = MOTIONS.computeIfAbsent(p.method_5628(), Motion::new);
                    m2.worn = worn;
                    m2.seen = now;
                    m2.update((class_1657)p, td, frameDt, local);
                    Cosmetics.refreshVideos(worn);
                    CosmeticItem pet = worn.get("pet");
                    if (pet == null) continue;
                    Cosmetics.pet(context, mc, (class_1657)p, m2, pet, td, local);
                }
            }
            MOTIONS.values().removeIf(m -> now - m.seen > 2000000000L);
            if (PARTICLES.get()) {
                CosmeticParticles.render(context.matrices(), context.commandQueue(), camPos, camera.method_23767());
            } else {
                CosmeticParticles.clear();
            }
        }
        catch (Throwable t) {
            System.out.println("cosmetics world pass failed: " + t);
        }
    }

    private static int petLight(class_310 mc, Motion m, class_1657 owner) {
        class_2338[] at;
        class_638 w = mc.field_1687;
        int sky = 0;
        int block = 0;
        for (class_2338 pos : at = new class_2338[]{class_2338.method_49637((double)m.petPos.field_1352, (double)(m.petPos.field_1351 + 0.25), (double)m.petPos.field_1350), class_2338.method_49637((double)m.petPos.field_1352, (double)(m.petPos.field_1351 + 0.9), (double)m.petPos.field_1350), class_2338.method_49637((double)owner.method_23317(), (double)owner.method_23320(), (double)owner.method_23321())}) {
            int packed = class_761.method_23794((class_1920)w, (class_2338)pos);
            sky = Math.max(sky, class_765.method_24187((int)packed));
            block = Math.max(block, class_765.method_24186((int)packed));
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

    static class_243 groundSpot(class_310 mc, class_1657 player, class_243 pp, Motion m, CosmeticItem pet) {
        double yr = Math.toRadians(m.bodyYaw);
        double fx = -Math.sin(yr);
        double fz = Math.cos(yr);
        double side = pet.anchor[0] >= 0.0f ? 1.0 : -1.0;
        double rx = -fz * side;
        double rz = fx * side;
        double sx = pp.field_1352 + rx * 0.85 - fx * 0.9;
        double sz = pp.field_1350 + rz * 0.85 - fz * 0.9;
        double x = sx;
        double z = sz;
        if (m.petPos != null && m.petWorld == mc.field_1687) {
            double hd = Math.hypot(m.petPos.field_1352 - pp.field_1352, m.petPos.field_1350 - pp.field_1350);
            if (hd > 2.3 || hd < 0.55) {
                m.petRun = true;
            } else if (m.petRun && Math.hypot(m.petPos.field_1352 - sx, m.petPos.field_1350 - sz) < 0.3) {
                m.petRun = false;
            }
            if (!m.petRun) {
                x = m.petPos.field_1352;
                z = m.petPos.field_1350;
            }
        }
        return new class_243(x, Cosmetics.groundY(mc, player, x, pp.field_1351, z) - (double)(Cosmetics.petFoot(pet) / 16.0f), z);
    }

    private static double groundY(class_310 mc, class_1657 player, double x, double y, double z) {
        class_3965 hit = mc.field_1687.method_17742(new class_3959(new class_243(x, y + 1.2, z), new class_243(x, y - 4.0, z), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)player));
        return hit.method_17783() == class_239.class_240.field_1333 ? y : hit.method_17784().field_1351;
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

    static void follow(Motion m, class_243 target, float dt, boolean walking) {
        double dist = m.petPos.method_1022(target);
        double w = walking ? Math.PI * 2 * (0.5 + 0.3 * Math.min(dist, 5.0)) : Math.PI * 2 * (1.35 + 0.4 * Math.min(dist, 4.0));
        double zeta = walking ? 0.95 : 0.66;
        int steps = Math.max(1, (int)Math.ceil(dt / 0.008f));
        double h = dt / (float)steps;
        double x = m.petPos.field_1352;
        double y = m.petPos.field_1351;
        double z = m.petPos.field_1350;
        double vx = m.petVel.field_1352;
        double vy = m.petVel.field_1351;
        double vz = m.petVel.field_1350;
        for (int k = 0; k < steps; ++k) {
            vx += (w * w * (target.field_1352 - x) - 2.0 * zeta * w * vx) * h;
            vy += (w * w * (target.field_1351 - y) - 2.0 * zeta * w * vy) * h;
            vz += (w * w * (target.field_1350 - z) - 2.0 * zeta * w * vz) * h;
            x += vx * h;
            y += vy * h;
            z += vz * h;
        }
        m.petPos = new class_243(x, y, z);
        m.petVel = new class_243(vx, vy, vz);
    }

    /*
     * Unable to fully structure code
     */
    private static void pet(WorldRenderContext context, class_310 mc, class_1657 player, Motion m, CosmeticItem pet, float td, boolean local) {
        if (player.method_7325() || pet.anchor == null) {
            m.petPos = null;
            return;
        }
        CosmeticLoader.ensureTextures(pet);
        if (!pet.loaded) {
            return;
        }
        pp = player.method_30950(td);
        firstPerson = local != false && mc.field_1690.method_31044().method_31034() != false;
        yaw = firstPerson != false ? class_3532.method_17821((float)td, (float)player.field_5982, (float)player.method_36454()) : m.bodyYaw;
        t = Cosmetics.seconds();
        v0 = walking = Cosmetics.PET_MODE.is("Follow") != false && player.method_31549().field_7479 == false && player.method_6128() == false && player.method_5799() == false && player.method_5765() == false;
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
            target = pp.method_1031((double)a.x, (double)a.y, (double)a.z);
        }
        if (m.petPos == null || m.petWorld != mc.field_1687) ** GOTO lbl-1000
        v1 = m.petPos.method_1025(target);
        v2 = walking != false ? 196 : 36;
        if (v1 > (double)v2) lbl-1000:
        // 2 sources

        {
            m.petPos = target;
            m.petVel = class_243.field_1353;
            m.petLast = null;
            m.petYaw = yaw;
            m.petWorld = mc.field_1687;
            m.petSky = -1.0f;
        } else {
            Cosmetics.follow(m, target, Cosmetics.frameDt, walking);
            face = yaw;
            if (walking) {
                vx = m.petVel.field_1352;
                vz = m.petVel.field_1350;
                face = vx * vx + vz * vz > 0.36 ? (float)Math.toDegrees(Math.atan2(-vx, vz)) : (float)Math.toDegrees(Math.atan2(-(pp.field_1352 - m.petPos.field_1352), pp.field_1350 - m.petPos.field_1350));
            }
            m.petYaw = class_3532.method_17821((float)(1.0f - (float)Math.exp(-Cosmetics.frameDt * (walking != false ? 7.0f : 4.0f))), (float)m.petYaw, (float)face);
        }
        m.petStep(Cosmetics.frameDt);
        d = Cosmetics.DRIVE;
        m.pet(d);
        if (walking) {
            sp = Math.hypot(m.petVel.field_1352, m.petVel.field_1350);
            m.petWalk += ((float)class_3532.method_15350((double)((sp - 0.3) / 2.5), (double)0.0, (double)1.0) - m.petWalk) * (1.0f - (float)Math.exp(-Cosmetics.frameDt * 8.0f));
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
            dist = m.petPos.method_1025(Cosmetics.camPos);
            m.petHidden = m.petHidden ? dist < 1.1 : dist < 0.8;
        } else {
            m.petHidden = false;
        }
        if (!(firstPerson && !Cosmetics.PET_FIRST_PERSON.get() || m.petHidden)) {
            ms = context.matrices();
            ms.method_22903();
            ms.method_22904(m.petPos.field_1352 - Cosmetics.camPos.field_1352, m.petPos.field_1351 - Cosmetics.camPos.field_1351, m.petPos.field_1350 - Cosmetics.camPos.field_1350);
            ms.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(180.0f - m.petYaw));
            ms.method_22905(0.0625f, 0.0625f, 0.0625f);
            Cosmetics.submit(pet, bones, Cosmetics.IDENTITY, ms, context.commandQueue(), Cosmetics.petLight(mc, m, player), t, true);
            ms.method_22909();
        }
        if (Cosmetics.PARTICLES.get() && pet.emitters.length > 0) {
            Cosmetics.emit(m, pet, bones, new Matrix4f().rotateY(yawRad).scale(0.0625f), m.petPos, yawRad, -2);
        }
    }

    static {
        WORN = new LinkedHashMap<String, String>();
        MOTIONS = new HashMap<Integer, Motion>();
        HIDDEN = Collections.newSetFromMap(new IdentityHashMap());
        SHIFTED = new class_630[2];
        VIDEO_SEEN = Collections.newSetFromMap(new IdentityHashMap());
        SHIFT_ORIGIN = new float[6];
        PARSED = new HashMap<String, Map<String, CosmeticItem>>();
        DRIVE = new CosmeticMesh.Drive();
        camPos = class_243.field_1353;
        localWorn = Map.of();
        localVersion = -1;
    }
}

