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
}
