/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 */
package a;

import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;

public final class AimContext {
    public static final int AHEAD = 16;
    public class_1297 target;
    public class_238 box;
    public float yawToTarget;
    public float pitchToTarget;
    public boolean attackReady;
    public int strikeIn;
    public final class_243[] eyeAt = new class_243[16];
    public final class_243[] targetAt = new class_243[16];
    private static /* synthetic */ boolean ljy;
    private static /* synthetic */ long ljz;

    private static /* synthetic */ int awu(int n, int n2) {
        return n * n2 + 1566880631;
    }

    private static /* synthetic */ int awv(int n, int n2) {
        return AimContext.awu(n, n2) ^ 0x32BE3D19;
    }
}

