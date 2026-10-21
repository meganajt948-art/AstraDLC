/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.pfw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CollectorPages {
    public static final int PAGES = 16;
    public static final int SLOTS = 4;
    private static final double pgc = 0.03;
    private final List<pfw> pgd = new ArrayList<pfw>(4);
    private final Set<Integer> pge = new HashSet<Integer>();
    private boolean pgf;
    private static /* synthetic */ int pgg;
    private static /* synthetic */ long pgh;

    public boolean markPage(int n) {
        return this.pge.add(n);
    }

    public boolean enough() {
        return this.pgd.size() >= 4;
    }

    public void offer(int n, int n2) {
        int n3;
        if (this.pgf || n2 <= 0) {
            return;
        }
        for (n3 = 0; n3 < this.pgd.size() && this.pgd.get(n3).price() <= n2; ++n3) {
        }
        if (n3 >= 4) {
            return;
        }
        this.pgd.add(n3, new pfw(n, n2));
        while (this.pgd.size() > 4) {
            this.pgd.remove(this.pgd.size() - 1);
        }
    }

    public boolean choose(int n) {
        if (this.pgd.isEmpty()) {
            return false;
        }
        long l = (long)this.pgd.get(0).price() + Math.max(1L, Math.round((double)this.pgd.get(0).price() * 0.03));
        pfw pfw2 = this.pgd.get(0);
        for (pfw pfw3 : this.pgd) {
            if ((long)pfw3.price() > l) break;
            if (Math.abs(pfw3.page() - n) >= Math.abs(pfw2.page() - n)) continue;
            pfw2 = pfw3;
        }
        this.pgd.remove(pfw2);
        this.pgd.add(0, pfw2);
        this.pgf = true;
        return true;
    }

    public pfw target() {
        return this.pgf && !this.pgd.isEmpty() ? this.pgd.get(0) : null;
    }

    public pfw dropTarget() {
        if (!this.pgd.isEmpty()) {
            this.pgd.remove(0);
        }
        return this.target();
    }

    public void release() {
        this.pgd.clear();
        this.pge.clear();
        this.pgf = false;
    }

    private static /* synthetic */ int bie(int n, int n2) {
        return (n ^ n2) + -1750162306;
    }

    private static /* synthetic */ int bif(int n, int n2) {
        return n * n2 | 0x9C2B2F89;
    }

    private static /* synthetic */ int big(int n, int n2) {
        return CollectorPages.bie(n, n2) + n;
    }
}

