/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap
 *  it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet
 *  it.unimi.dsi.fastutil.ints.IntListIterator
 *  it.unimi.dsi.fastutil.ints.IntOpenHashSet
 *  net.minecraft.client.MinecraftClient
 */
package a;

import a.hzq;
import a.hzv;
import a.kfa;
import a.kfe;
import a.kgj;
import a.kmy;
import a.kqh;
import a.krd;
import a.kvz;
import a.lfa;
import a.lfu;
import a.lgc;
import a.lqq;
import a.lre;
import a.lsg;
import a.lsx;
import a.lub;
import a.lvp;
import a.lwh;
import a.lwq;
import a.lwx;
import a.lxp;
import a.mgl;
import a.mix;
import a.mjr;
import a.mkl;
import a.mpq;
import a.nfl;
import a.nmg;
import a.nuo;
import a.nxa;
import a.oqm;
import a.oqv;
import a.osq;
import a.otn;
import a.ouc;
import a.our;
import a.ovh;
import a.owo;
import a.oxw;
import a.pbe;
import a.pbz;
import a.qxi;
import a.qyk;
import a.qze;
import a.rae;
import a.rby;
import a.rdd;
import a.rds;
import a.reo;
import a.rfa;
import a.rfl;
import a.rfp;
import a.rfy;
import a.rhs;
import a.riv;
import a.rjy;
import a.rkh;
import a.rky;
import a.rmk;
import a.rnk;
import a.rpt;
import a.rqf;
import a.rqv;
import a.rrx;
import a.rug;
import a.ruv;
import a.rwo;
import a.rxa;
import a.rxv;
import a.rzy;
import a.sbp;
import a.shx;
import a.sjl;
import a.vlq;
import a.vmo;
import a.vzz;
import a.wap;
import it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.MinecraftClient;

public class kfx {
    private final List<kfe> kfy = new ArrayList<kfe>();
    private final Int2BooleanOpenHashMap kfz = new Int2BooleanOpenHashMap();
    private final IntLinkedOpenHashSet kga = new IntLinkedOpenHashSet();
    private final IntLinkedOpenHashSet kgb = new IntLinkedOpenHashSet();
    private final IntOpenHashSet kgc = new IntOpenHashSet();
    private static boolean kgd;
    private final rds kge = new rds();
    private static /* synthetic */ String kgf;
    private static /* synthetic */ String kgg;

    public kfx() {
        this.kgh(this.kge);
        this.kgh(new lwx());
        this.kgh(new lgc());
        this.kgh(new kmy());
        this.kgh(new kgj());
        this.kgh(new lfa());
        this.kgh(new kqh());
        this.kgh(new krd());
        this.kgh(new lfu());
        this.kgh(new lxp());
        this.kgh(new lwh());
        this.kgh(new lwq());
        this.kgh(new rkh());
        this.kgh(new rjy());
        this.kgh(new rfl());
        this.kgh(new ruv());
        this.kgh(new rnk());
        this.kgh(new qyk());
        this.kgh(new rby());
        this.kgh(new rae());
        this.kgh(new rky());
        this.kgh(new rhs());
        this.kgh(new rwo());
        this.kgh(new rqv());
        this.kgh(new rfy());
        this.kgh(new shx());
        this.kgh(new rrx());
        this.kgh(new rxa());
        this.kgh(new rug());
        this.kgh(new rpt());
        this.kgh(new rfa());
        this.kgh(new reo());
        this.kgh(new rdd());
        this.kgh(new rqf());
        this.kgh(new sbp());
        this.kgh(new rxv());
        this.kgh(new riv());
        this.kgh(new rmk());
        this.kgh(new rfp());
        this.kgh(new qxi());
        this.kgh(new sjl());
        this.kgh(new qze());
        this.kgh(new pbz());
        this.kgh(new ovh());
        this.kgh(new nuo());
        this.kgh(new nfl());
        this.kgh(new lvp());
        this.kgh(new lqq());
        this.kgh(new our());
        this.kgh(new mjr());
        this.kgh(new ouc());
        this.kgh(new owo());
        this.kgh(new pbe());
        this.kgh(new osq());
        this.kgh(new oqv());
        this.kgh(new otn());
        this.kgh(new mix());
        this.kgh(new mkl());
        this.kgh(new nmg());
        this.kgh(new mgl());
        this.kgh(new mpq());
        nxa nxa2 = new nxa();
        nxa2.registerAsMain();
        this.kgh(nxa2);
        this.kgh(new rzy());
        this.kgh(new oqm());
        this.kgh(new kvz());
        this.kgh(new lsg());
        this.kgh(new lre());
        this.kgh(new lsx());
        this.kgh(new lub());
        this.kgh(new oxw());
    }

    private void kgh(kfe kfe2) {
        this.kfy.add(kfe2);
    }

    public List<kfe> getModules() {
        return this.kfy;
    }

    public List<kfe> getByCategory(kfa kfa2) {
        ArrayList<kfe> arrayList = new ArrayList<kfe>();
        for (kfe kfe2 : this.kfy) {
            if (kfe2.getCategory() != kfa2) continue;
            arrayList.add(kfe2);
        }
        return arrayList;
    }

    public <T extends kfe> T get(Class<T> clazz) {
        for (kfe kfe2 : this.kfy) {
            if (!clazz.isInstance(kfe2)) continue;
            return (T)((kfe)clazz.cast(kfe2));
        }
        return null;
    }

    public kfe getByName(String string) {
        for (kfe kfe2 : this.kfy) {
            if (!kfe2.getName().equalsIgnoreCase(string)) continue;
            return kfe2;
        }
        return null;
    }

    public void onStartTick(MinecraftClient minecraftClient) {
        for (kfe kfe2 : this.kfy) {
            if (!kfe2.isEnabled() && !kfe2.ticksWhenOff()) continue;
            kfe2.onStartTick(minecraftClient);
        }
    }

    public void onEndTick(MinecraftClient minecraftClient) {
        for (kfe kfe2 : this.kfy) {
            if (!kfe2.isEnabled() && !kfe2.ticksWhenOff() || kfe2 == this.kge) continue;
            kfe2.onEndTick(minecraftClient);
        }
        if (this.kge.isEnabled()) {
            this.kge.onEndTick(minecraftClient);
        }
    }

    public void onWorldRender(MinecraftClient minecraftClient) {
        for (kfe kfe2 : this.kfy) {
            if (!kfe2.isEnabled()) continue;
            kfe2.onWorldRender(minecraftClient);
        }
        for (kfe kfe2 : this.kfy) {
            if (!kfe2.isEnabled()) continue;
            kfe2.onWorldRenderLate(minecraftClient);
        }
        for (kfe kfe2 : this.kfy) {
            if (!kfe2.isEnabled()) continue;
            kfe2.onWorldRenderFinal(minecraftClient);
        }
    }

    public void pollKeys(MinecraftClient minecraftClient) {
        if (minecraftClient.method_22683() == null) {
            return;
        }
        IntLinkedOpenHashSet intLinkedOpenHashSet = this.kgb;
        intLinkedOpenHashSet.clear();
        for (kfe object : this.kfy) {
            intLinkedOpenHashSet.add(object.getKey());
            if (!object.isEnabled()) continue;
            for (vmo vmo2 : object.getSettings()) {
                if (!(vmo2 instanceof vlq)) continue;
                vlq vlq2 = (vlq)vmo2;
                intLinkedOpenHashSet.add(vlq2.get());
            }
        }
        for (hzq hzq2 : hzv.ALL) {
            intLinkedOpenHashSet.add(hzq2.key());
        }
        intLinkedOpenHashSet.remove(-1);
        Iterator<Object> iterator = intLinkedOpenHashSet.iterator();
        while (iterator.hasNext()) {
            int n = iterator.nextInt();
            boolean bl = vzz.isDown(minecraftClient, n);
            boolean bl2 = this.kfz.put(n, bl);
            if (!bl || bl2) continue;
            this.kga.add(n);
        }
    }

    public void onKeys(MinecraftClient minecraftClient) {
        this.pollKeys(minecraftClient);
        IntListIterator intListIterator = this.kga.iterator();
        while (intListIterator.hasNext()) {
            int n = intListIterator.nextInt();
            for (kfe kfe2 : this.kfy) {
                if (kfe2.getKey() != n) continue;
                kfe2.toggle();
            }
            boolean bl = this.kgc.contains(n);
            for (kfe kfe3 : this.kfy) {
                if (!kfe3.isEnabled() || !kfx.kgi(kfe3, n) || bl && kfe3.keysAtStart()) continue;
                kfe3.onKey(minecraftClient, n);
            }
            hzv.run(n);
        }
        this.kga.clear();
        this.kgc.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onStartKeys(MinecraftClient minecraftClient) {
        this.pollKeys(minecraftClient);
        if (this.kga.isEmpty()) {
            return;
        }
        kgd = true;
        try {
            IntListIterator intListIterator = this.kga.iterator();
            while (intListIterator.hasNext()) {
                int n = intListIterator.nextInt();
                if (this.kgc.contains(n)) continue;
                for (kfe kfe2 : this.kfy) {
                    if (!kfe2.keysAtStart() || !kfe2.isEnabled() || !kfx.kgi(kfe2, n)) continue;
                    this.kgc.add(n);
                    kfe2.onKey(minecraftClient, n);
                }
            }
        }
        finally {
            kgd = false;
        }
    }

    public static boolean startPhase() {
        return kgd;
    }

    private static boolean kgi(kfe kfe2, int n) {
        for (vmo vmo2 : kfe2.getSettings()) {
            vlq vlq2;
            if (!(vmo2 instanceof vlq) || (vlq2 = (vlq)vmo2).get() != n) continue;
            return true;
        }
        return false;
    }

    public void dropKeys() {
        this.kga.clear();
        this.kgc.clear();
    }

    static {
        wap.get();
    }

    private static /* synthetic */ int ate(int n, int n2) {
        return n - n2 + 821234885;
    }
}

