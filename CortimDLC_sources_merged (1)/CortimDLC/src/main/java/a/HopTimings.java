/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.qqd;
import a.qqg;
import a.qqm;
import a.qqp;
import a.MineRarity;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HopTimings {
    private static final long qqt = 30000L;
    private final Map<Integer, qqm> qqu = new HashMap<Integer, qqm>();
    private final Map<Integer, Long> qqv = new HashMap<Integer, Long>();
    private List<Integer> qqw = List.of();
    private int qqx;
    private double qqy = 6000.0;
    private double qqz = 10000.0;
    private static /* synthetic */ int qra;
    private static /* synthetic */ long qrb;

    public void list(List<Integer> list) {
        if (!list.equals(this.qqw)) {
            this.qqw = List.copyOf(list);
            this.qqx = 0;
        }
    }

    public void clear() {
        this.qqu.clear();
        this.qqv.clear();
        this.qqx = 0;
    }

    public long hopMs() {
        return (long)this.qqy;
    }

    public long warpMs() {
        return (long)this.qqz;
    }

    public long goMs() {
        return (long)(this.qqy + this.qqz);
    }

    public void hopTook(long l) {
        this.qqy = this.qqy * 0.6 + Math.max(1500.0, Math.min(40000.0, (double)l)) * 0.4;
    }

    public void warpTook(long l) {
        this.qqz = this.qqz * 0.6 + Math.max(1000.0, Math.min(30000.0, (double)l)) * 0.4;
    }

    public void block(int n, long l) {
        this.qqv.put(n, l);
    }

    public qqm entry(int n) {
        return this.qqu.get(n);
    }

    public List<qqm> entries() {
        return new ArrayList<qqm>(this.qqu.values());
    }

    public qqm seen(int n, MineRarity qwj2, int n2, long l) {
        qqm qqm2 = this.qqu.computeIfAbsent(n, qqm::new);
        long l2 = l + (long)n2 * 1000L + 500L;
        if (qqm2.tier != null && qqm2.refreshAt <= l + 3000L && l2 > qqm2.refreshAt + 10000L) {
            qqm2.lastTier = qqm2.tier;
            qqm2.lastRefreshAt = Math.min(qqm2.refreshAt, l);
        }
        boolean bl = qqm2.tier != null && qqm2.refreshAt > l && Math.abs(qqm2.refreshAt - l2) < 4000L;
        qqm2.refreshAt = bl ? (qqm2.refreshAt * 3L + l2) / 4L : l2;
        qqm2.tier = qwj2;
        qqm2.seenAt = l;
        return qqm2;
    }

    public void forget(int n) {
        this.qqu.remove(n);
    }

    public void mined(int n) {
        qqm qqm2 = this.qqu.get(n);
        if (qqm2 != null) {
            qqm2.minedAt = qqm2.lastRefreshAt;
        }
    }

    public MineRarity fresh(int n, long l, qqd qqd2) {
        qqm qqm2 = this.qqu.get(n);
        if (qqm2 == null || qqm2.lastTier == null || !qqd2.tiers.contains((Object)qqm2.lastTier)) {
            return null;
        }
        if (qqm2.minedAt == qqm2.lastRefreshAt || l - qqm2.lastRefreshAt > 30000L || qqm2.lastRefreshAt > l + 3000L) {
            return null;
        }
        return qqm2.lastTier;
    }

    public void scanned(int n) {
        int n2 = this.qqw.indexOf(n);
        if (n2 >= 0) {
            this.qqx = (n2 + 1) % Math.max(1, this.qqw.size());
        }
    }

    public qqg decide(long l, int n, long l2, qqd qqd2) {
        qqm qqm2 = null;
        for (qqm qqm3 : this.qqu.values()) {
            if (!this.qrd(qqm3, l, n, l2, qqd2) || !HopTimings.qrg(qqm3, qqm2)) continue;
            qqm2 = qqm3;
        }
        int n2 = this.qrc(l, n);
        if (qqm2 == null) {
            return n2 >= 0 ? new qqg(qqp.SCAN, n2, null) : new qqg(qqp.IDLE, -1, null);
        }
        long l3 = qqm2.refreshAt - l;
        if (l3 <= qqd2.waitMs + this.qre(qqm2, n, l2)) {
            return new qqg(qqp.GO, qqm2.id, qqm2);
        }
        qqm qqm4 = null;
        for (qqm qqm5 : this.qqu.values()) {
            if (qqm5 == qqm2 || !this.qrd(qqm5, l, n, l2, qqd2) || n2 >= 0 && qqm5.refreshAt - l > qqd2.waitMs + this.qre(qqm5, n, l2) || qqm5.refreshAt + qqd2.minMineMs + this.goMs() + qqd2.leadMs > qqm2.refreshAt || !HopTimings.qrg(qqm5, qqm4)) continue;
            qqm4 = qqm5;
        }
        if (qqm4 != null) {
            return new qqg(qqp.GO, qqm4.id, qqm4);
        }
        if (n2 >= 0 && l + this.hopMs() + this.goMs() + qqd2.leadMs <= qqm2.refreshAt) {
            return new qqg(qqp.SCAN, n2, null);
        }
        return new qqg(qqp.GO, qqm2.id, qqm2);
    }

    public long leaveAt(long l, int n, MineRarity qwj2, long l2, qqd qqd2) {
        long l3 = Long.MAX_VALUE;
        for (qqm qqm2 : this.qqu.values()) {
            boolean bl;
            if (qqm2.id == n || qqm2.tier == null || !qqd2.tiers.contains((Object)qqm2.tier) || this.qrf(qqm2.id, l) || qqm2.refreshAt - this.goMs() <= l || !(bl = qwj2 == null || qqm2.tier.rank() > qwj2.rank() || qqm2.tier.rank() >= qwj2.rank() && l2 >= qqd2.minMineMs)) continue;
            l3 = Math.min(l3, qqm2.refreshAt - qqd2.leadMs - this.goMs());
        }
        return l3;
    }

    private int qrc(long l, int n) {
        int n2 = this.qqw.size();
        for (int i = 0; i < n2; ++i) {
            qqm qqm2;
            int n3 = this.qqw.get((this.qqx + i) % n2);
            if (n3 == n || this.qrf(n3, l) || (qqm2 = this.qqu.get(n3)) != null && qqm2.tier != null && qqm2.refreshAt > l) continue;
            return n3;
        }
        return -1;
    }

    private boolean qrd(qqm qqm2, long l, int n, long l2, qqd qqd2) {
        if (qqm2.tier == null || !qqd2.tiers.contains((Object)qqm2.tier)) {
            return false;
        }
        if (qqm2.id != n && this.qrf(qqm2.id, l)) {
            return false;
        }
        return qqm2.refreshAt - this.qre(qqm2, n, l2) > l;
    }

    private long qre(qqm qqm2, int n, long l) {
        return qqm2.id == n ? l : this.goMs();
    }

    private boolean qrf(int n, long l) {
        Long l2 = this.qqv.get(n);
        return l2 != null && l2 > l;
    }

    private static boolean qrg(qqm qqm2, qqm qqm3) {
        if (qqm3 == null) {
            return true;
        }
        if (qqm2.tier.rank() != qqm3.tier.rank()) {
            return qqm2.tier.rank() > qqm3.tier.rank();
        }
        return qqm2.refreshAt < qqm3.refreshAt;
    }

    public static List<Integer> parseList(String string) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (string == null) {
            return arrayList;
        }
        for (String string2 : string.replaceAll("\\s*[-–—]\\s*", "-").split("[,;\\s]+")) {
            String string3 = string2.trim();
            if (string3.isEmpty()) continue;
            try {
                int n;
                int n2 = string3.indexOf(45, 1);
                if (n2 > 0) {
                    n = Integer.parseInt(string3.substring(0, n2).trim());
                    int n3 = Integer.parseInt(string3.substring(n2 + 1).trim());
                    for (int i = Math.min(n, n3); i <= Math.max(n, n3) && arrayList.size() < 400; ++i) {
                        if (arrayList.contains(i)) continue;
                        arrayList.add(i);
                    }
                    continue;
                }
                n = Integer.parseInt(string3);
                if (arrayList.contains(n)) continue;
                arrayList.add(n);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        return arrayList;
    }

    private static /* synthetic */ int bux(int n, int n2) {
        return n + n2 | 0xA118FEE0;
    }

    private static /* synthetic */ int buy(int n, int n2) {
        return n * n2 + 217948415;
    }
}

