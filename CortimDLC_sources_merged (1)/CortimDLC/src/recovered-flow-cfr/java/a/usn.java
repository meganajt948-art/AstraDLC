/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerLikeState
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.util.math.Vec3d
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector4f
 */
package a;

import a.unf;
import java.lang.reflect.Method;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerLikeState;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector4f;

public final class usn {
    private static Method uso;
    private static boolean usp;
    private final Matrix4f usq;
    private final Matrix4f usr;
    private final Matrix4f uss;
    private final Vec3d ust;
    private final float usu;
    private final float usv;
    private static usn usw;
    private static long usx;
    private static float usy;
    private final Vector4f usz = new Vector4f();
    private static /* synthetic */ boolean uta;
    private static /* synthetic */ int utb;

    private usn(Matrix4f matrix4f, Matrix4f matrix4f2, Vec3d vec3d, float f, float f2) {
        this.usq = matrix4f;
        this.usr = matrix4f2;
        this.uss = new Matrix4f((Matrix4fc)matrix4f).mul((Matrix4fc)matrix4f2);
        this.ust = vec3d;
        this.usu = f;
        this.usv = f2;
    }

    public static usn capture(float f, float f2, float f3) {
        usn usn2 = usw;
        if (usn2 != null && usx == unf.frame() && usy == f && usn2.usu == f2 && usn2.usv == f3) {
            return usn2;
        }
        usw = usn2 = usn.utc(f, f2, f3);
        usx = unf.frame();
        usy = f;
        return usn2;
    }

    public static usn fresh(float f, float f2, float f3) {
        return usn.utc(f, f2, f3);
    }

    private static usn utc(float f, float f2, float f3) {
        AbstractClientPlayerEntity abstractClientPlayerEntity;
        Entity entity;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        GameRenderer gameRenderer = minecraftClient.gameRenderer;
        Camera camera = gameRenderer.getCamera();
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)gameRenderer.getBasicProjectionMatrix(usn.utd(gameRenderer, camera, f)));
        if (((Boolean)minecraftClient.options.getBobView().getValue()).booleanValue() && (entity = minecraftClient.getCameraEntity()) instanceof AbstractClientPlayerEntity) {
            abstractClientPlayerEntity = (AbstractClientPlayerEntity)entity;
            matrix4f.mul((Matrix4fc)usn.ute(abstractClientPlayerEntity, camera.getLastTickProgress()));
        }
        abstractClientPlayerEntity = new Matrix4f().rotation((Quaternionfc)camera.getRotation().conjugate(new Quaternionf()));
        return new usn(matrix4f, (Matrix4f)abstractClientPlayerEntity, camera.getCameraPos(), f2, f3);
    }

    private static float utd(GameRenderer gameRenderer, Camera camera, float f) {
        if (uso == null && !usp) {
            for (Method method : GameRenderer.class.getDeclaredMethods()) {
                Class<?>[] classArray = method.getParameterTypes();
                if (method.getReturnType() != Float.TYPE || classArray.length != 3 || classArray[0] != Camera.class || classArray[1] != Float.TYPE || classArray[2] != Boolean.TYPE) continue;
                method.setAccessible(true);
                uso = method;
                break;
            }
            boolean bl = usp = uso == null;
        }
        if (uso != null) {
            try {
                return ((Float)uso.invoke((Object)gameRenderer, camera, Float.valueOf(f), true)).floatValue();
            }
            catch (ReflectiveOperationException | RuntimeException exception) {
                usp = true;
                uso = null;
            }
        }
        return ((Integer)MinecraftClient.getInstance().options.getFov().getValue()).floatValue();
    }

    private static Matrix4f ute(AbstractClientPlayerEntity abstractClientPlayerEntity, float f) {
        ClientPlayerLikeState clientPlayerLikeState = abstractClientPlayerEntity.getState();
        float f2 = clientPlayerLikeState.getReverseLerpedDistanceMoved(f);
        float f3 = clientPlayerLikeState.lerpMovement(f);
        MatrixStack matrixStack = new MatrixStack();
        matrixStack.translate(MathHelper.sin((double)(f2 * (float)Math.PI)) * f3 * 0.5f, -Math.abs(MathHelper.cos((double)(f2 * (float)Math.PI)) * f3), 0.0f);
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.sin((double)(f2 * (float)Math.PI)) * f3 * 3.0f));
        matrixStack.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(Math.abs(MathHelper.cos((double)(f2 * (float)Math.PI - 0.2f)) * f3) * 5.0f));
        return matrixStack.peek().getPositionMatrix();
    }

    public Vector4f viewSpace(double d, double d2, double d3) {
        Vector4f vector4f = new Vector4f((float)(d - this.ust.x), (float)(d2 - this.ust.y), (float)(d3 - this.ust.z), 1.0f);
        return this.usr.transform(vector4f);
    }

    public float depth(double d, double d2, double d3) {
        float f = (float)(d - this.ust.x);
        float f2 = (float)(d2 - this.ust.y);
        float f3 = (float)(d3 - this.ust.z);
        return -(this.usr.m02() * f + this.usr.m12() * f2 + this.usr.m22() * f3 + this.usr.m32());
    }

    public boolean project(double d, double d2, double d3, float[] fArray) {
        Vector4f vector4f = this.usz.set((float)(d - this.ust.x), (float)(d2 - this.ust.y), (float)(d3 - this.ust.z), 1.0f);
        this.uss.transform(vector4f);
        if (vector4f.w <= 0.05f) {
            return false;
        }
        fArray[0] = (vector4f.x / vector4f.w * 0.5f + 0.5f) * this.usu;
        fArray[1] = (0.5f - vector4f.y / vector4f.w * 0.5f) * this.usv;
        return true;
    }

    public boolean project3(double d, double d2, double d3, float[] fArray) {
        Vector4f vector4f = this.usz.set((float)(d - this.ust.x), (float)(d2 - this.ust.y), (float)(d3 - this.ust.z), 1.0f);
        this.uss.transform(vector4f);
        if (vector4f.w <= 0.05f) {
            return false;
        }
        fArray[0] = (vector4f.x / vector4f.w * 0.5f + 0.5f) * this.usu;
        fArray[1] = (0.5f - vector4f.y / vector4f.w * 0.5f) * this.usv;
        fArray[2] = 1.0f / vector4f.w;
        return true;
    }

    public void direction(double d, double d2, double d3, float[] fArray) {
        Vector4f vector4f = this.usz.set((float)(d - this.ust.x), (float)(d2 - this.ust.y), (float)(d3 - this.ust.z), 1.0f);
        this.uss.transform(vector4f);
        float f = vector4f.x * this.usu;
        float f2 = -vector4f.y * this.usv;
        float f3 = (float)Math.hypot(f, f2);
        if (f3 < 1.0E-4f) {
            fArray[0] = 0.0f;
            fArray[1] = 1.0f;
            return;
        }
        fArray[0] = f / f3;
        fArray[1] = f2 / f3;
    }

    public float unitsPerBlock(double d, double d2, double d3) {
        float f = this.depth(d, d2, d3);
        return f <= 0.05f ? 0.0f : 0.5f * this.usv * this.usq.m11() / f;
    }

    public float width() {
        return this.usu;
    }

    public float height() {
        return this.usv;
    }

    public boolean projectSegment(double d, double d2, double d3, double d4, double d5, double d6, float f, float[] fArray, float[] fArray2) {
        float f2 = this.depth(d, d2, d3);
        float f3 = this.depth(d4, d5, d6);
        if (f2 <= f && f3 <= f) {
            return false;
        }
        if (f2 < f) {
            double d7 = (f - f2) / (f3 - f2);
            d += (d4 - d) * d7;
            d2 += (d5 - d2) * d7;
            d3 += (d6 - d3) * d7;
        } else if (f3 < f) {
            double d8 = (f - f3) / (f2 - f3);
            d4 += (d - d4) * d8;
            d5 += (d2 - d5) * d8;
            d6 += (d3 - d6) * d8;
        }
        if (!this.project(d, d2, d3, fArray2)) {
            return false;
        }
        fArray[0] = fArray2[0];
        fArray[1] = fArray2[1];
        if (!this.project(d4, d5, d6, fArray2)) {
            return false;
        }
        fArray[2] = fArray2[0];
        fArray[3] = fArray2[1];
        return true;
    }

    public Vec3d camera() {
        return this.ust;
    }

    public double distance(double d, double d2, double d3) {
        return Math.sqrt(this.ust.squaredDistanceTo(d, d2, d3));
    }

    static {
        usx = -1L;
        usy = Float.NaN;
    }

    private static /* synthetic */ int dap(int n, int n2) {
        return n ^ n2 ^ 0x592EFC26;
    }

    private static /* synthetic */ int daq(int n, int n2) {
        return usn.dap(n, n2) * n2;
    }
}

