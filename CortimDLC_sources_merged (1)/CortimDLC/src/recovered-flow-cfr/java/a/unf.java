/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package a;

import net.minecraft.client.gui.DrawContext;

public final class unf {
    private static Object ung;
    private static long unh;
    private static long uni;
    private static float unj;
    private static /* synthetic */ String unk;
    private static /* synthetic */ long unl;

    private unf() {
    }

    public static void observe(DrawContext drawContext) {
        if (drawContext == ung) {
            return;
        }
        ung = drawContext;
        ++unh;
        long l = System.nanoTime();
        if (uni != 0L) {
            unj = Math.max(0.0f, Math.min(0.2f, (float)(l - uni) / 1.0E9f));
        }
        uni = l;
    }

    public static long frame() {
        return unh;
    }

    public static float delta() {
        return unj;
    }

    static {
        unj = 0.016666668f;
    }

    private static /* synthetic */ int cym(int n, int n2) {
        return n - n2 + 2007743731;
    }
}

