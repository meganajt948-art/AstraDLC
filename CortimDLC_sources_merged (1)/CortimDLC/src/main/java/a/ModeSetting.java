/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Setting;
import java.util.Arrays;
import java.util.List;

public class ModeSetting
extends Setting {
    private final String vlw;
    private List<String> vlx;
    private int vly;
    private int vlz;
    private static /* synthetic */ long vma;
    private static /* synthetic */ long vmb;

    public ModeSetting(String string, String string2, String ... stringArray) {
        super(string);
        this.vlw = string2;
        this.vlx = Arrays.asList(stringArray);
        int n = this.vlx.indexOf(string2);
        this.vly = this.vlz = n < 0 ? 0 : n;
    }

    public void setModes(List<String> list) {
        if (list.isEmpty() || list.equals(this.vlx)) {
            return;
        }
        String string = this.get();
        this.vlx = List.copyOf(list);
        this.vlz = this.vly = Math.max(0, this.vlx.indexOf(this.vlw));
        this.set(string);
    }

    public int index() {
        return this.vlz;
    }

    public void reset() {
        this.vlz = this.vly;
    }

    public String get() {
        return this.vlx.get(this.vlz);
    }

    public boolean is(String string) {
        return this.get().equalsIgnoreCase(string);
    }

    public List<String> getModes() {
        return this.vlx;
    }

    public void set(String string) {
        for (int i = 0; i < this.vlx.size(); ++i) {
            if (!this.vlx.get(i).equalsIgnoreCase(string)) continue;
            this.vlz = i;
            return;
        }
    }

    public void cycle() {
        this.vlz = (this.vlz + 1) % this.vlx.size();
    }

    public void cyclePrev() {
        this.vlz = (this.vlz - 1 + this.vlx.size()) % this.vlx.size();
    }

    private static /* synthetic */ int dho(int n, int n2) {
        return n ^ n2 | 0x638B24FA;
    }
}

