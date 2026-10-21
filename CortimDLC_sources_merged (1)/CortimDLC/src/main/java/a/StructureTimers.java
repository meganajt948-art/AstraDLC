/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1259$class_1260
 *  net.minecraft.class_1259$class_1261
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3341
 *  net.minecraft.class_337
 *  net.minecraft.class_345
 *  net.minecraft.class_5250
 *  net.minecraft.class_638
 *  net.minecraft.class_9779
 */
package a;

import a.LiquidGlass;
import a.Theme;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.pbs;
import a.pbw;
import a.SceneCapture;
import a.ColorUtil;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.Easing;
import a.FontFace;
import a.Fonts;
import a.Lang;
import a.PacketHooks;
import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1259;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3341;
import net.minecraft.class_337;
import net.minecraft.class_345;
import net.minecraft.class_5250;
import net.minecraft.class_638;
import net.minecraft.class_9779;

public class StructureTimers
extends Module {
    private static final Set<class_2248> pca = Set.of(class_2246.field_10153, class_2246.field_10614, class_2246.field_10480, class_2246.field_10505, class_2246.field_10462, class_2246.field_10266, class_2246.field_23880, class_2246.field_10006, class_2246.field_10295, class_2246.field_10541, class_2246.field_23152, class_2246.field_22108, class_2246.field_10087, class_2246.field_10458, class_2246.field_23151);
    private static final int pcb = 2;
    private static final int pcc = 2;
    private static final long pcd = 200L;
    private static final long pce = 400L;
    private static final FontFace pcf = Fonts.semibold(6.4f);
    private static final float pcg = 13.0f;
    private static final float pch = 4.5f;
    private static final float pci = 9.0f;
    private static final float pcj = 3.5f;
    private static StructureTimers pck;
    private static Field pcl;
    private static boolean pcm;
    private final Set<class_2338> pcn = ConcurrentHashMap.newKeySet();
    private final Map<class_2338, Integer> pco = new HashMap<class_2338, Integer>();
    private final List<pbw> pcp = new ArrayList<pbw>();
    private volatile boolean pcq;
    private class_638 pcr;
    private int pcs;
    private static /* synthetic */ long pct;
    private static /* synthetic */ long pcu;

    public StructureTimers() {
        super("Structures", "Timers over traps and plasts", ModuleCategory.PLAYER);
        pck = this;
        PacketHooks.listen(this::pcw);
    }

    @Override
    protected void onEnable() {
        this.pcr = this.mc.field_1687;
        this.pcq = true;
        if (this.mc.field_1687 != null) {
            PacketHooks.ensure(this.mc);
        }
    }

    @Override
    protected void onDisable() {
        this.pcq = false;
        this.pcv();
        this.pcn.clear();
    }

    private void pcv() {
        for (pbw pbw2 : this.pcp) {
            StructureTimers.pdd(pbw2);
        }
        this.pcp.clear();
        this.pco.clear();
    }

    private void pcw(class_2596<?> class_25962) {
        if (!this.pcq) {
            return;
        }
        if (class_25962 instanceof class_2637) {
            class_2637 class_26372 = (class_2637)class_25962;
            class_26372.method_30621(this::pcx);
        } else if (class_25962 instanceof class_2626) {
            class_2626 class_26262 = (class_2626)class_25962;
            this.pcx(class_26262.method_11309(), class_26262.method_11308());
        }
    }

    private void pcx(class_2338 class_23382, class_2680 class_26802) {
        class_638 class_6382 = this.mc.field_1687;
        if (class_6382 == null || !pca.contains(class_26802.method_26204())) {
            return;
        }
        if (class_6382.method_8393(class_23382.method_10263() >> 4, class_23382.method_10260() >> 4) && !pca.contains(class_6382.method_8320(class_23382).method_26204())) {
            this.pcn.add(class_23382.method_10062());
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        PacketHooks.ensure(class_3102);
        ++this.pcs;
        if (class_3102.field_1687 != this.pcr) {
            this.pcv();
            this.pcr = class_3102.field_1687;
        }
        Iterator<class_2338> iterator = this.pcn.iterator();
        while (iterator.hasNext()) {
            this.pco.put(iterator.next(), this.pcs);
            iterator.remove();
        }
        if (!this.pco.isEmpty()) {
            this.pcy();
        }
        this.pda(class_3102);
    }

    private void pcy() {
        HashSet<class_2338> hashSet = new HashSet<class_2338>(this.pco.keySet());
        ArrayDeque<class_2338> arrayDeque = new ArrayDeque<class_2338>();
        while (!hashSet.isEmpty()) {
            class_2338 class_23382 = (class_2338)hashSet.iterator().next();
            hashSet.remove(class_23382);
            arrayDeque.add(class_23382);
            ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
            int n = Integer.MAX_VALUE;
            int n2 = Integer.MIN_VALUE;
            while (!arrayDeque.isEmpty()) {
                class_2338 class_23383 = (class_2338)arrayDeque.poll();
                arrayList.add(class_23383);
                int n3 = this.pco.get(class_23383);
                n = Math.min(n, n3);
                n2 = Math.max(n2, n3);
                for (int i = -2; i <= 2; ++i) {
                    for (int j = -2; j <= 2; ++j) {
                        for (int k = -2; k <= 2; ++k) {
                            class_2338 class_23384 = class_23383.method_10069(i, j, k);
                            if (!hashSet.remove(class_23384)) continue;
                            arrayDeque.add(class_23384);
                        }
                    }
                }
            }
            if (this.pcs - n2 < 2) continue;
            for (class_2338 class_23385 : arrayList) {
                this.pco.remove(class_23385);
            }
            this.pcz(arrayList, System.currentTimeMillis() - (long)(this.pcs - n) * 50L);
        }
    }

    private void pcz(List<class_2338> list, long l) {
        class_3341 class_33412 = class_3341.method_35411(list).orElse(null);
        if (class_33412 == null) {
            return;
        }
        for (pbs pbs2 : pbs.values()) {
            if (!pbs2.matches(class_33412, list)) continue;
            this.pcp.removeIf(pbw2 -> {
                if (pbw2.box.equals((Object)class_33412)) {
                    StructureTimers.pdd(pbw2);
                    return true;
                }
                return false;
            });
            this.pcp.add(new pbw(pbs2, class_33412, list, l));
            return;
        }
    }

    private void pda(class_310 class_3102) {
        long l = System.currentTimeMillis();
        class_2338 class_23382 = class_3102.field_1724.method_24515();
        Iterator<pbw> iterator = this.pcp.iterator();
        while (iterator.hasNext()) {
            pbw pbw2 = iterator.next();
            if (pbw2.deadAt == 0L && StructureTimers.pdb(class_3102.field_1687, pbw2)) {
                pbw2.deadAt = l;
            }
            if (pbw2.left(l) <= 0L || pbw2.deadAt != 0L && l - pbw2.deadAt > 400L) {
                StructureTimers.pdd(pbw2);
                iterator.remove();
                continue;
            }
            if (pbw2.deadAt == 0L && pbw2.box.method_14662((class_2382)class_23382)) {
                StructureTimers.pdc(pbw2, l);
                continue;
            }
            StructureTimers.pdd(pbw2);
        }
    }

    private static boolean pdb(class_638 class_6382, pbw pbw2) {
        int n = 0;
        for (class_2338 class_23382 : pbw2.blocks) {
            if (!class_6382.method_8393(class_23382.method_10263() >> 4, class_23382.method_10260() >> 4)) {
                return false;
            }
            if (pca.contains(class_6382.method_8320(class_23382).method_26204())) continue;
            ++n;
        }
        return n * 2 > pbw2.blocks.size();
    }

    private static void pdc(pbw pbw2, long l) {
        Map<UUID, class_345> map = StructureTimers.pde();
        if (map == null) {
            return;
        }
        long l2 = Math.max(0L, pbw2.left(l));
        class_5250 class_52502 = class_2561.method_43470((String)(Lang.t(pbw2.kind.title) + " — " + StructureTimers.pdf(l2) + Lang.s(" s", " сек")));
        float f = Math.min(1.0f, (float)l2 / (float)pbw2.kind.duration);
        if (pbw2.bar == null) {
            pbw2.bar = new class_345(UUID.randomUUID(), (class_2561)class_52502, f, class_1259.class_1260.field_5786, class_1259.class_1261.field_5795, false, false, false);
        } else {
            pbw2.bar.method_5413((class_2561)class_52502);
            pbw2.bar.method_5408(f);
        }
        map.putIfAbsent(pbw2.bar.method_5407(), pbw2.bar);
    }

    private static void pdd(pbw pbw2) {
        if (pbw2.bar == null) {
            return;
        }
        Map<UUID, class_345> map = StructureTimers.pde();
        if (map != null) {
            map.remove(pbw2.bar.method_5407());
        }
        pbw2.bar = null;
    }

    private static Map<UUID, class_345> pde() {
        class_310 class_3102 = class_310.method_1551();
        if (pcm || class_3102.field_1705 == null) {
            return null;
        }
        try {
            if (pcl == null) {
                for (Field field : class_337.class.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Map.class.isAssignableFrom(field.getType())) continue;
                    field.setAccessible(true);
                    pcl = field;
                    break;
                }
                if (pcl == null) {
                    throw new IllegalStateException("boss bar map not found");
                }
            }
            return (Map)pcl.get(class_3102.field_1705.method_1740());
        }
        catch (Throwable throwable) {
            pcm = true;
            System.out.println("boss bars unavailable: " + throwable);
            return null;
        }
    }

    private static String pdf(long l) {
        long l2 = Math.round((double)l / 100.0);
        return l2 / 10L + "." + l2 % 10L;
    }

    public static StructureTimers get() {
        return pck;
    }

    public int count() {
        return this.pcp.size();
    }

    public String describe() {
        StringBuilder stringBuilder = new StringBuilder();
        long l = System.currentTimeMillis();
        for (pbw pbw2 : this.pcp) {
            stringBuilder.append(pbw2.kind.name()).append('@').append(pbw2.box.method_22874().method_23854()).append(' ').append(StructureTimers.pdf(Math.max(0L, pbw2.left(l)))).append(pbw2.bar != null ? " bar" : "").append(pbw2.deadAt != 0L ? " dead" : "").append("; ");
        }
        return stringBuilder.toString();
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        StructureTimers pbz2 = pck;
        class_310 class_3102 = class_310.method_1551();
        if (pbz2 == null || !pbz2.isEnabled() || pbz2.pcp.isEmpty() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842) {
            return;
        }
        FrameDelta.observe(class_3322);
        float f = FrameDelta.delta();
        Theme.update(f * (float)Theme.ANIMATION.get());
        float f2 = class_3322.method_51421();
        float f3 = class_3322.method_51443();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), f2, f3);
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        GpuTextureView gpuTextureView = null;
        if (Hud.BACKGROUND.is("Glass") && LiquidGlass.ENABLED.get() && SceneCapture.HUD.capture(class_3322, LiquidGlass.FROST.getInt(), null)) {
            gpuTextureView = SceneCapture.HUD.result(class_3322);
        }
        long l = System.currentTimeMillis();
        ArrayList<pbw> arrayList = new ArrayList<pbw>(pbz2.pcp);
        arrayList.sort((pbw2, pbw3) -> Double.compare(StructureTimers.pdg(usn2, pbw3), StructureTimers.pdg(usn2, pbw2)));
        float f4 = Math.max(1, class_3102.method_22683().method_4495());
        float[] fArray = new float[2];
        for (pbw pbw4 : arrayList) {
            float f5 = pbw4.shown.step(pbw4.deadAt == 0L && pbw4.left(l) > 200L, f);
            class_2338 class_23382 = pbw4.box.method_22874();
            if (f5 < 0.01f || !usn2.project((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 0.5, (double)class_23382.method_10260() + 0.5, fArray)) continue;
            StructureTimers.pdh(class_3322, pbw4, (float)Math.round(fArray[0] * f4) / f4, (float)Math.round(fArray[1] * f4) / f4, f5, l, gpuTextureView);
        }
    }

    private static double pdg(ScreenProjection usn2, pbw pbw2) {
        class_2338 class_23382 = pbw2.box.method_22874();
        return usn2.distance((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 0.5, (double)class_23382.method_10260() + 0.5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void pdh(class_332 class_3322, pbw pbw2, float f, float f2, float f3, long l, GpuTextureView gpuTextureView) {
        long l2 = Math.max(0L, pbw2.left(l));
        String string = StructureTimers.pdf(l2);
        float f4 = 17.0f + pcf.width(string) + 4.5f;
        float f5 = Theme.r(4.0f);
        float f6 = Easing.outCubic(f3);
        float f7 = 0.8f + 0.2f * f6;
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().translate(f, f2);
        class_3322.method_51448().scale(f7, f7);
        class_3322.method_51448().translate(-f4 * 0.5f, -6.5f);
        DrawUtil.pushAlpha(f3);
        try {
            float f8 = (float)Hud.OPACITY.get();
            int n = ColorUtil.withAlpha(Theme.window, Math.round(255.0f * Math.min(1.0f, f8 * 0.55f)));
            if (gpuTextureView == null || !DrawUtil.glass(class_3322, gpuTextureView, 0.0f, 0.0f, f4, 13.0f, f5, n, 1.0f)) {
                DrawUtil.round(class_3322, 0.0f, 0.0f, f4, 13.0f, f5, ColorUtil.withAlpha(Theme.window, Math.round(255.0f * f8 * 0.6f)));
            }
            DrawUtil.outline(class_3322, 0.0f, 0.0f, f4, 13.0f, f5, 1.0f, ColorUtil.withAlpha(0xFFFFFF, Math.round(14.0f + 16.0f * Theme.lightness())));
            float f9 = 6.5f;
            float f10 = 0.5625f * f6;
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().translate(9.0f, f9);
            class_3322.method_51448().scale(f10, f10);
            class_3322.method_51427(pbw2.icon, -8, -8);
            class_3322.method_51448().popMatrix();
            pcf.draw(class_3322, string, 17.0f, pcf.centerTop(f9), Theme.text);
            float f11 = f4 - f5 * 2.0f;
            float f12 = Math.min(1.0f, (float)l2 / (float)pbw2.kind.duration);
            DrawUtil.round(class_3322, f5, 10.8f, f11, 1.2f, 0.6f, ColorUtil.withAlpha(0xFFFFFF, 30));
            DrawUtil.gradientH(class_3322, f5, 10.8f, Math.max(1.2f, f11 * f12), 1.2f, 0.6f, Theme.accent(), Theme.accent2());
        }
        finally {
            DrawUtil.popAlpha();
            class_3322.method_51448().popMatrix();
        }
    }

    private static /* synthetic */ int bgx(int n, int n2) {
        return n + n2 | 0xFE4FAC6E;
    }

    private static /* synthetic */ int bgy(int n, int n2) {
        return n * n2 | 0xFDB872CE;
    }
}

