/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2IntMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongListIterator
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_9779
 */
package a;

import a.ClickGuiScreen;
import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.DiamondEsp;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.Icon;
import a.PacketHooks;
import flow.dev.StringDecryptor;
import it.unimi.dsi.fastutil.longs.Long2IntMap;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongListIterator;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_9779;

public class AncientDebrisEsp
extends Module {
    private static final int lvq = -23296;
    private static final double lvr = 6400.0;
    private static final ConcurrentLinkedQueue<Long> lvs = new ConcurrentLinkedQueue();
    private static AncientDebrisEsp lvt;
    private static boolean lvu;
    private static volatile long[] lvv;
    private static long lvw;
    private final LongLinkedOpenHashSet lvx = new LongLinkedOpenHashSet();
    private final Long2IntOpenHashMap lvy = new Long2IntOpenHashMap();
    private final Long2IntOpenHashMap lvz = new Long2IntOpenHashMap();
    private boolean lwa;
    private int lwb;
    private int lwc;
    private static /* synthetic */ int lwd;
    private static /* synthetic */ boolean lwe;

    public AncientDebrisEsp() {
        super("XRay", "Highlights ancient debris revealed by TNT blasts", ModuleCategory.MISC);
        lvt = this;
        if (!lvu) {
            lvu = true;
            PacketHooks.listen(AncientDebrisEsp::lwf);
        }
    }

    public static AncientDebrisEsp get() {
        return lvt;
    }

    public LongLinkedOpenHashSet found() {
        return this.lvx;
    }

    private static void lwf(class_2596<?> class_25962) {
        class_2626 class_26262;
        AncientDebrisEsp lvp2 = lvt;
        if (lvp2 == null || !lvp2.isEnabled()) {
            return;
        }
        if (class_25962 instanceof class_2637) {
            class_2637 class_26372 = (class_2637)class_25962;
            class_26372.method_30621((class_23382, class_26802) -> {
                if (class_26802.method_27852(class_2246.field_22109)) {
                    lvs.add(class_23382.method_10063());
                }
            });
        } else if (class_25962 instanceof class_2626 && (class_26262 = (class_2626)class_25962).method_11308().method_27852(class_2246.field_22109)) {
            lvs.add(class_26262.method_11309().method_10063());
        }
    }

    @Override
    protected void onEnable() {
        this.lwg();
    }

    @Override
    protected void onDisable() {
        this.lwg();
    }

    private void lwg() {
        this.lvx.clear();
        this.lvy.clear();
        this.lvz.clear();
        lvs.clear();
        lvv = new long[0];
        this.lwa = false;
        this.lwb = 0;
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        Long2IntMap.Entry entry;
        Long l;
        ++this.lwc;
        PacketHooks.ensure(class_3102);
        class_638 class_6382 = class_3102.field_1687;
        class_746 class_7462 = class_3102.field_1724;
        if (class_6382 == null || class_7462 == null) {
            lvs.clear();
            return;
        }
        while ((l = lvs.poll()) != null) {
            if (this.lvx.contains(l.longValue()) || this.lvz.containsKey(l.longValue())) continue;
            this.lvz.put(l.longValue(), this.lwc);
        }
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        ObjectIterator objectIterator = this.lvz.long2IntEntrySet().iterator();
        while (objectIterator.hasNext()) {
            entry = (Long2IntMap.Entry)objectIterator.next();
            long l2 = entry.getLongKey();
            if (class_6382.method_8320((class_2338)class_23392.method_16363(l2)).method_27852(class_2246.field_22109)) {
                objectIterator.remove();
                if (!this.lvx.add(l2)) continue;
                this.lvy.put(l2, this.lwc);
                this.lwa = true;
                this.lwb = 0;
                continue;
            }
            if (this.lwc - entry.getIntValue() <= 40) continue;
            objectIterator.remove();
        }
        ++this.lwb;
        if (this.lwa && this.lwb >= 5) {
            this.lwa = false;
            Hud.alert(this.getName(), "Обнаружено " + this.lvx.size() + " древних обломков", Icon.INFO, true);
        }
        objectIterator = class_7462.method_73189();
        entry = new class_2338.class_2339();
        LongListIterator longListIterator = this.lvx.iterator();
        while (longListIterator.hasNext()) {
            boolean bl;
            long l3 = longListIterator.nextLong();
            entry.method_16363(l3);
            class_2680 class_26802 = class_6382.method_8320((class_2338)entry);
            boolean bl2 = bl = !class_26802.method_27852(class_2246.field_22109);
            if (!bl && !(entry.method_19770((class_2374)objectIterator) >= 6400.0) && class_6382.method_2935().method_12123(entry.method_10263() >> 4, entry.method_10260() >> 4)) continue;
            longListIterator.remove();
            this.lvy.remove(l3);
        }
        lvv = this.lvx.toLongArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        AncientDebrisEsp lvp2 = lvt;
        long[] lArray = lvp2 != null && lvp2.isEnabled() ? lvv : new long[]{};
        class_310 class_3102 = class_310.method_1551();
        if (lArray.length == 0 || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842 || class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        FrameDelta.observe(class_3322);
        if (FrameDelta.frame() == lvw) {
            return;
        }
        lvw = FrameDelta.frame();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), class_3322.method_51421(), class_3322.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        class_243 class_2432 = usn2.camera();
        DrawUtil.beginBatch();
        try {
            for (long l : lArray) {
                double d;
                double d2;
                double d3 = class_2338.method_10061((long)l);
                if (usn2.depth(d3 + 0.5, (d2 = (double)class_2338.method_10071((long)l)) + 0.5, (d = (double)class_2338.method_10083((long)l)) + 0.5) < -1.0f) continue;
                DiamondEsp.cube(class_3322, usn2, class_2432, d3, d2, d, -23296, 0, 1.0f, 0.16f);
            }
        }
        finally {
            DrawUtil.endBatch();
        }
    }

    static {
        lvv = new long[0];
        lvw = -1L;
    }

    private static /* synthetic */ int azq(int n, int n2) {
        return n + n2 + 860088056;
    }

    private static /* synthetic */ int azr(int n, int n2) {
        return AncientDebrisEsp.azq(n, n2) + n;
    }

    private static /* synthetic */ int azs(int n, int n2) {
        return (n ^ n2) + -2066412112;
    }
}

