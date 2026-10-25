/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 */
package a;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class ljx {
    public static final int AHEAD = 16;
    public Entity target;
    public Box box;
    public float yawToTarget;
    public float pitchToTarget;
    public boolean attackReady;
    public int strikeIn;
    public final Vec3d[] eyeAt = new Vec3d[16];
    public final Vec3d[] targetAt = new Vec3d[16];
    private static /* synthetic */ boolean ljy;
    private static /* synthetic */ long ljz;

    private static /* synthetic */ int awu(int n, int n2) {
        return n * n2 + 1566880631;
    }

    private static /* synthetic */ int awv(int n, int n2) {
        return ljx.awu(n, n2) ^ 0x32BE3D19;
    }
}

