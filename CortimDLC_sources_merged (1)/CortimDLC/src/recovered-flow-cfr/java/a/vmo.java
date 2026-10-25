/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.util.function.BooleanSupplier;

public abstract class vmo {
    private final String vmp;
    private BooleanSupplier vmq;
    private BooleanSupplier vmr;
    private static /* synthetic */ int vms;
    private static /* synthetic */ long vmt;

    protected vmo(String string) {
        this.vmp = string;
    }

    public String getName() {
        return this.vmp;
    }

    public void activeWhen(BooleanSupplier booleanSupplier) {
        this.vmq = booleanSupplier;
    }

    public BooleanSupplier activeCondition() {
        return this.vmq;
    }

    public void visibleWhen(BooleanSupplier booleanSupplier) {
        this.vmr = booleanSupplier;
    }

    public BooleanSupplier visibleCondition() {
        return this.vmr;
    }

    private static /* synthetic */ int dhv(int n, int n2) {
        return n + n2 ^ 0x7620C595;
    }

    private static /* synthetic */ int dhw(int n, int n2) {
        return n + n2 | 0x79258EFD;
    }

    private static /* synthetic */ int dhx(int n, int n2) {
        return vmo.dhv(n, n2) * n2;
    }
}

