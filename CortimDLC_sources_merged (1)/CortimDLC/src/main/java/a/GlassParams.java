/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class GlassParams
extends Record {
    private final float uoz;
    private final float upa;
    private final float upb;
    private final float upc;
    private final float upd;
    private final float upe;
    private static /* synthetic */ boolean upf;
    private static /* synthetic */ boolean upg;

    public GlassParams(float f, float f2, float f3, float f4, float f5, float f6) {
        this.uoz = f;
        this.upa = f2;
        this.upb = f3;
        this.upc = f4;
        this.upd = f5;
        this.upe = f6;
    }

    public GlassParams withBezel(float f) {
        return new GlassParams(this.uoz, f, this.upb, this.upc, this.upd, this.upe);
    }

    int packShape(float f) {
        int n = Math.floorMod(Math.round(this.upe / 360.0f * 64.0f), 64);
        int n2 = Math.round(Math.max(0.5f, Math.min(this.upa, f)) * 2.0f);
        return GlassParams.uph(this.uoz, 63) | GlassParams.uph(this.upb, 63) << 6 | n << 12 | Math.max(1, Math.min(63, n2)) << 18;
    }

    int packLight(float f) {
        return GlassParams.uph(f, 255) | GlassParams.uph(this.upc, 255) << 8 | GlassParams.uph(this.upd * 0.5f, 255) << 16;
    }

    private static int uph(float f, int n) {
        return Math.round(Math.max(0.0f, Math.min(1.0f, f)) * (float)n);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{GlassParams.class, "refraction;bezel;dispersion;highlight;saturation;lightAngle", "uoz", "upa", "upb", "upc", "upd", "upe"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{GlassParams.class, "refraction;bezel;dispersion;highlight;saturation;lightAngle", "uoz", "upa", "upb", "upc", "upd", "upe"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{GlassParams.class, "refraction;bezel;dispersion;highlight;saturation;lightAngle", "uoz", "upa", "upb", "upc", "upd", "upe"}, this, object);
    }

    public float refraction() {
        return this.uoz;
    }

    public float bezel() {
        return this.upa;
    }

    public float dispersion() {
        return this.upb;
    }

    public float highlight() {
        return this.upc;
    }

    public float saturation() {
        return this.upd;
    }

    public float lightAngle() {
        return this.upe;
    }

    private static /* synthetic */ int czo(int n, int n2) {
        return n - n2 | 0x200F2EE1;
    }
}

