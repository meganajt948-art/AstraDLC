/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2672
 *  net.minecraft.class_2680
 *  net.minecraft.class_8038
 */
package a;

import a.qrh;
import flow.dev.StringDecryptor;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_8038;

final class GhostBlockTracker {
    private final Long2ObjectOpenHashMap<qrh> qrn = new Long2ObjectOpenHashMap();
    private final Set<Long> qro = ConcurrentHashMap.newKeySet();
    private final ConcurrentLinkedQueue<Long> qrp = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue<Long> qrq = new ConcurrentLinkedQueue();
    private class_1937 qrr;
    private int qrs;
    private int qrt;
    private static /* synthetic */ boolean qru;
    private static /* synthetic */ String qrv;

    GhostBlockTracker() {
    }

    void echo(class_2596<?> class_25962) {
        if (this.qro.isEmpty()) {
            return;
        }
        if (class_25962 instanceof class_2626) {
            class_2626 class_26262 = (class_2626)class_25962;
            this.qrw(class_26262.method_11309().method_10063());
        } else if (class_25962 instanceof class_2637) {
            class_2637 class_26372 = (class_2637)class_25962;
            class_26372.method_30621((class_23382, class_26802) -> this.qrw(class_23382.method_10063()));
        } else if (class_25962 instanceof class_2672) {
            class_2672 class_26722 = (class_2672)class_25962;
            this.qrq.add(class_1923.method_8331((int)class_26722.method_11523(), (int)class_26722.method_11524()));
        } else if (class_25962 instanceof class_8038) {
            class_8038 class_80382 = (class_8038)class_25962;
            for (class_2596 class_25963 : class_80382.method_48324()) {
                this.echo(class_25963);
            }
        }
    }

    private void qrw(long l) {
        if (this.qro.contains(l)) {
            this.qrp.add(l);
        }
    }

    boolean isGhost(long l) {
        return this.qrn.containsKey(l);
    }

    String describe() {
        return this.qrs + " predicted, " + this.qrt + " back";
    }

    void ghost(class_1937 class_19372, class_2338 class_23382, int n) {
        if (this.qrr != class_19372) {
            this.qry();
            this.qrr = class_19372;
        }
        long l = class_23382.method_10063();
        class_2680 class_26802 = class_19372.method_8320(class_23382);
        if (class_26802.method_26215() || this.qrn.containsKey(l)) {
            return;
        }
        class_2680 class_26803 = class_19372.method_8316(class_23382).method_15759();
        this.qrn.put(l, (Object)new qrh(class_26802, n));
        this.qro.add(l);
        class_19372.method_8652(class_23382, class_26803, 11);
        ++this.qrs;
    }

    void tick(class_1937 class_19372, int n) {
        if (this.qrr != class_19372) {
            this.qry();
            this.qrr = class_19372;
            return;
        }
        this.qrx();
        if (this.qrn.isEmpty()) {
            return;
        }
        ObjectIterator objectIterator = this.qrn.long2ObjectEntrySet().fastIterator();
        while (objectIterator.hasNext()) {
            Long2ObjectMap.Entry entry = (Long2ObjectMap.Entry)objectIterator.next();
            if (((qrh)entry.getValue()).until() > n) continue;
            class_2338 class_23382 = class_2338.method_10092((long)entry.getLongKey());
            if (class_19372.method_8320(class_23382).method_26215() && class_19372.method_8393(class_23382.method_10263() >> 4, class_23382.method_10260() >> 4)) {
                class_19372.method_8652(class_23382, ((qrh)entry.getValue()).was(), 11);
                ++this.qrt;
            }
            objectIterator.remove();
            this.qro.remove(class_23382.method_10063());
        }
    }

    private void qrx() {
        Long l;
        while ((l = this.qrp.poll()) != null) {
            if (this.qrn.remove(l.longValue()) == null) continue;
            this.qro.remove(l);
        }
        while ((l = this.qrq.poll()) != null) {
            long l2 = l;
            ObjectIterator objectIterator = this.qrn.long2ObjectEntrySet().fastIterator();
            while (objectIterator.hasNext()) {
                long l3 = ((Long2ObjectMap.Entry)objectIterator.next()).getLongKey();
                if (class_1923.method_8331((int)(class_2338.method_10061((long)l3) >> 4), (int)(class_2338.method_10083((long)l3) >> 4)) != l2) continue;
                objectIterator.remove();
                this.qro.remove(l3);
            }
        }
    }

    void restore(class_1937 class_19372) {
        if (this.qrr == class_19372 && class_19372 != null) {
            this.qrx();
            for (Long2ObjectMap.Entry entry : this.qrn.long2ObjectEntrySet()) {
                class_2338 class_23382 = class_2338.method_10092((long)entry.getLongKey());
                if (!class_19372.method_8320(class_23382).method_26215() || !class_19372.method_8393(class_23382.method_10263() >> 4, class_23382.method_10260() >> 4)) continue;
                class_19372.method_8652(class_23382, ((qrh)entry.getValue()).was(), 11);
            }
        }
        this.qry();
    }

    private void qry() {
        this.qrn.clear();
        this.qro.clear();
        this.qrp.clear();
        this.qrq.clear();
    }

    private static /* synthetic */ int bve(int n, int n2) {
        return n * n2 + 1531635246;
    }
}

