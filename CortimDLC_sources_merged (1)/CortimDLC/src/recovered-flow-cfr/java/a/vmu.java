/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vmo;

public class vmu
extends vmo {
    private final String vmv;
    private final int vmw;
    private String vmx;
    private String vmy;
    private static /* synthetic */ int vmz;
    private static /* synthetic */ boolean vna;

    public vmu(String string, String string2, int n) {
        super(string);
        this.vmv = string2;
        this.vmw = n;
        this.vmx = string2;
    }

    public String get() {
        return this.vmx;
    }

    public void set(String string) {
        if (string == null) {
            string = "";
        }
        this.vmx = string.length() > this.vmw ? string.substring(0, this.vmw) : string;
    }

    public int maxLength() {
        return this.vmw;
    }

    public String defaultValue() {
        return this.vmv;
    }

    public vmu example(String string) {
        this.vmy = string;
        return this;
    }

    public String example() {
        return this.vmy;
    }

    public void reset() {
        this.vmx = this.vmv;
    }

    private static /* synthetic */ int dia(int n, int n2) {
        return n * n2 + 868092727;
    }
}

