/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11902
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_742
 *  net.minecraft.class_757
 *  net.minecraft.class_7833
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector4f
 */
package a;

import a.FrameDelta;
import java.lang.reflect.Method;
import net.minecraft.class_11902;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_742;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector4f;

public final class ScreenProjection {
    private static Method uso;
    private static boolean usp;
    private final Matrix4f usq;
    private final Matrix4f usr;
    private final Matrix4f uss;
    private final class_243 ust;
    private final float usu;
    private final float usv;
    private static ScreenProjection usw;
    private static long usx;
    private static float usy;
    private final Vector4f usz = new Vector4f();
    private static /* synthetic */ boolean uta;
    private static /* synthetic */ int utb;

    private ScreenProjection(Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432, float f, float f2) {
        this.usq = matrix4f;
        this.usr = matrix4f2;
        this.uss = new Matrix4f((Matrix4fc)matrix4f).mul((Matrix4fc)matrix4f2);
        this.ust = class_2432;
        this.usu = f;
        this.usv = f2;
    }

    public static ScreenProjection capture(float f, float f2, float f3) {
        ScreenProjection usn2 = usw;
        if (usn2 != null && usx == FrameDelta.frame() && usy == f && usn2.usu == f2 && usn2.usv == f3) {
            return usn2;
        }
        usw = usn2 = ScreenProjection.utc(f, f2, f3);
        usx = FrameDelta.frame();
        usy = f;
        return usn2;
    }

    public static ScreenProjection fresh(float f, float f2, float f3) {
        return ScreenProjection.utc(f, f2, f3);
    }

    private static ScreenProjection utc(float f, float f2, float f3) {
        class_742 class_7422;
        class_1297 class_12972;
        class_310 class_3102 = class_310.method_1551();
        class_757 class_7572 = class_3102.field_1773;
        class_4184 class_41842 = class_7572.method_19418();
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)class_7572.method_22973(ScreenProjection.utd(class_7572, class_41842, f)));
        if (((Boolean)class_3102.field_1690.method_42448().method_41753()).booleanValue() && (class_12972 = class_3102.method_1560()) instanceof class_742) {
            class_7422 = (class_742)class_12972;
            matrix4f.mul((Matrix4fc)ScreenProjection.ute(class_7422, class_41842.method_55437()));
        }
        class_7422 = new Matrix4f().rotation((Quaternionfc)class_41842.method_23767().conjugate(new Quaternionf()));
        return new ScreenProjection(matrix4f, (Matrix4f)class_7422, class_41842.method_71156(), f2, f3);
    }

    private static float utd(class_757 class_7572, class_4184 class_41842, float f) {
        if (uso == null && !usp) {
            for (Method method : class_757.class.getDeclaredMethods()) {
                Class<?>[] classArray = method.getParameterTypes();
                if (method.getReturnType() != Float.TYPE || classArray.length != 3 || classArray[0] != class_4184.class || classArray[1] != Float.TYPE || classArray[2] != Boolean.TYPE) continue;
                method.setAccessible(true);
                uso = method;
                break;
            }
            boolean bl = usp = uso == null;
        }
        if (uso != null) {
            try {
                return ((Float)uso.invoke((Object)class_7572, class_41842, Float.valueOf(f), true)).floatValue();
            }
            catch (ReflectiveOperationException | RuntimeException exception) {
                usp = true;
                uso = null;
            }
        }
        return ((Integer)class_310.method_1551().field_1690.method_41808().method_41753()).floatValue();
    }

    private static Matrix4f ute(class_742 class_7422, float f) {
        class_11902 class_119022 = class_7422.method_74192();
        float f2 = class_119022.method_74205(f);
        float f3 = class_119022.method_74204(f);
        class_4587 class_45872 = new class_4587();
        class_45872.method_46416(class_3532.method_15374((double)(f2 * (float)Math.PI)) * f3 * 0.5f, -Math.abs(class_3532.method_15362((double)(f2 * (float)Math.PI)) * f3), 0.0f);
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(class_3532.method_15374((double)(f2 * (float)Math.PI)) * f3 * 3.0f));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(Math.abs(class_3532.method_15362((double)(f2 * (float)Math.PI - 0.2f)) * f3) * 5.0f));
        return class_45872.method_23760().method_23761();
    }

    public Vector4f viewSpace(double d, double d2, double d3) {
        Vector4f vector4f = new Vector4f((float)(d - this.ust.field_1352), (float)(d2 - this.ust.field_1351), (float)(d3 - this.ust.field_1350), 1.0f);
        return this.usr.transform(vector4f);
    }

    public float depth(double d, double d2, double d3) {
        float f = (float)(d - this.ust.field_1352);
        float f2 = (float)(d2 - this.ust.field_1351);
        float f3 = (float)(d3 - this.ust.field_1350);
        return -(this.usr.m02() * f + this.usr.m12() * f2 + this.usr.m22() * f3 + this.usr.m32());
    }

    public boolean project(double d, double d2, double d3, float[] fArray) {
        Vector4f vector4f = this.usz.set((float)(d - this.ust.field_1352), (float)(d2 - this.ust.field_1351), (float)(d3 - this.ust.field_1350), 1.0f);
        this.uss.transform(vector4f);
        if (vector4f.w <= 0.05f) {
            return false;
        }
        fArray[0] = (vector4f.x / vector4f.w * 0.5f + 0.5f) * this.usu;
        fArray[1] = (0.5f - vector4f.y / vector4f.w * 0.5f) * this.usv;
        return true;
    }

    public boolean project3(double d, double d2, double d3, float[] fArray) {
        Vector4f vector4f = this.usz.set((float)(d - this.ust.field_1352), (float)(d2 - this.ust.field_1351), (float)(d3 - this.ust.field_1350), 1.0f);
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
        Vector4f vector4f = this.usz.set((float)(d - this.ust.field_1352), (float)(d2 - this.ust.field_1351), (float)(d3 - this.ust.field_1350), 1.0f);
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

    public class_243 camera() {
        return this.ust;
    }

    public double distance(double d, double d2, double d3) {
        return Math.sqrt(this.ust.method_1028(d, d2, d3));
    }

    static {
        usx = -1L;
        usy = Float.NaN;
    }

    private static /* synthetic */ int dap(int n, int n2) {
        return n ^ n2 ^ 0x592EFC26;
    }

    private static /* synthetic */ int daq(int n, int n2) {
        return ScreenProjection.dap(n, n2) * n2;
    }
}

