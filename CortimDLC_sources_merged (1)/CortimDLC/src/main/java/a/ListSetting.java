/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vlg;
import a.Setting;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListSetting
extends Setting {
    private final vlg vlk;
    private final List<String> vll;
    private final Set<String> vlm = new LinkedHashSet<String>();
    private int vln;
    private static /* synthetic */ long vlo;
    private static /* synthetic */ int vlp;

    public ListSetting(String string, vlg vlg2, String ... stringArray) {
        super(string);
        this.vlk = vlg2;
        this.vll = List.of(stringArray);
        this.vlm.addAll(this.vll);
    }

    public vlg kind() {
        return this.vlk;
    }

    public int version() {
        return this.vln;
    }

    public Set<String> ids() {
        return Collections.unmodifiableSet(this.vlm);
    }

    public boolean contains(String string) {
        return this.vlm.contains(string);
    }

    public int size() {
        return this.vlm.size();
    }

    public boolean toggle(String string) {
        boolean bl;
        boolean bl2 = bl = !this.vlm.remove(string);
        if (bl) {
            this.vlm.add(string);
        }
        ++this.vln;
        return bl;
    }

    public void set(Collection<String> collection) {
        this.vlm.clear();
        for (String string : collection) {
            if (string == null || string.isBlank()) continue;
            this.vlm.add(string.trim());
        }
        ++this.vln;
    }

    public void clear() {
        this.vlm.clear();
        ++this.vln;
    }

    public void reset() {
        this.vlm.clear();
        this.vlm.addAll(this.vll);
        ++this.vln;
    }

    private static /* synthetic */ int dhg(int n, int n2) {
        return n - n2 + -748465749;
    }

    private static /* synthetic */ int dhh(int n, int n2) {
        return ListSetting.dhg(n, n2) * n2;
    }

    private static /* synthetic */ int dhi(int n, int n2) {
        return n ^ n2 | 0x435BEE63;
    }
}

