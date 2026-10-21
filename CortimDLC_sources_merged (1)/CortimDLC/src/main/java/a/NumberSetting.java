/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Setting;
import a.FormatUtil;
import a.Lang;
import flow.dev.StringDecryptor;
import java.util.function.DoubleFunction;

public class NumberSetting
extends Setting {
    private double vmd;
    private final double vme;
    private final double vmf;
    private final double vmg;
    private final double vmh;
    private String vmi = "";
    private boolean vmj;
    private boolean vmk;
    private DoubleFunction<String> vml;
    private static /* synthetic */ int vmm;
    private static /* synthetic */ boolean vmn;

    public NumberSetting(String string, double d, double d2, double d3, double d4) {
        super(string);
        this.vmf = d2;
        this.vmg = d3;
        this.vmh = d4;
        this.set(d);
        this.vme = this.vmd;
    }

    public double get() {
        return this.vmd;
    }

    public int getInt() {
        return (int)Math.round(this.vmd);
    }

    public double getMin() {
        return this.vmf;
    }

    public double getMax() {
        return this.vmg;
    }

    public double getStep() {
        return this.vmh;
    }

    public void set(double d) {
        if (d < this.vmf) {
            d = this.vmf;
        }
        if (d > this.vmg) {
            d = this.vmg;
        }
        if (this.vmh > 0.0) {
            d = this.vmf + (double)Math.round((d - this.vmf) / this.vmh) * this.vmh;
        }
        this.vmd = d;
    }

    public NumberSetting suffix(String string) {
        this.vmi = string;
        return this;
    }

    public NumberSetting unit(String string) {
        this.vmi = string;
        this.vmj = true;
        return this;
    }

    public double getDefault() {
        return this.vme;
    }

    public void reset() {
        this.set(this.vme);
    }

    public NumberSetting percent() {
        this.vmk = true;
        return this;
    }

    public NumberSetting format(DoubleFunction<String> doubleFunction) {
        this.vml = doubleFunction;
        return this;
    }

    public String display() {
        String string;
        if (this.vml != null) {
            return this.vml.apply(this.vmd);
        }
        if (this.vmk) {
            return Math.round(this.vmd * 100.0) + "%";
        }
        if (this.vmh >= 1.0) {
            string = String.valueOf(this.getInt());
        } else {
            int n = this.vmh >= 0.099999999 ? 1 : 2;
            string = FormatUtil.fixed(this.vmd, n);
        }
        return this.vmi.isEmpty() ? string : string + (this.vmj ? "" : " ") + Lang.unit(this.vmi);
    }

    public double getFraction() {
        return this.vmg <= this.vmf ? 0.0 : (this.vmd - this.vmf) / (this.vmg - this.vmf);
    }

    public void setFromFraction(double d) {
        d = Math.max(0.0, Math.min(1.0, d));
        this.set(this.vmf + (this.vmg - this.vmf) * d);
    }

    private static /* synthetic */ int dhr(int n, int n2) {
        return n * n2 + 102163158;
    }

    private static /* synthetic */ int dhs(int n, int n2) {
        return NumberSetting.dhr(n, n2) ^ 0x6305015F;
    }
}

