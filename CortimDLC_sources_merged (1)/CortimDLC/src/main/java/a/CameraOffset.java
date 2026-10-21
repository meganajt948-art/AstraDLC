/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_5134
 *  net.minecraft.class_757
 */
package a;

import a.PanicShutdown;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5134;
import net.minecraft.class_757;
import sun.misc.Unsafe;

public final class CameraOffset
extends class_4184 {
    private static Unsafe etu;
    private static long etv;
    private static class_4184 etw;
    private static boolean etx;
    private static boolean ety;
    private static float etz;
    private boolean eua;
    private static float eub;
    private static float euc;
    private static boolean eud;
    private static long eue;
    private static boolean euf;
    private static /* synthetic */ boolean eug;
    private static /* synthetic */ long euh;

    private CameraOffset() {
    }

    public static void distance(float f) {
        etz = Math.max(0.0f, f);
    }

    public static void viewOffset(float f, float f2) {
        eub = f;
        euc = f2;
        eud = true;
    }

    public static void releaseView() {
        eud = false;
    }

    private void eui() {
        long l = System.nanoTime();
        float f = eue == 0L ? 0.0f : Math.min(0.1f, (float)(l - eue) / 1.0E9f);
        eue = l;
        if (!(eud || eub == 0.0f && euc == 0.0f)) {
            float f2 = (float)Math.exp(-f * 14.0f);
            eub *= f2;
            euc *= f2;
            if (Math.abs(eub) < 0.02f && Math.abs(euc) < 0.02f) {
                eub = 0.0f;
                euc = 0.0f;
            }
        }
        if (eub != 0.0f || euc != 0.0f) {
            this.method_19325(this.method_19330() - eub, Math.max(-90.0f, Math.min(90.0f, this.method_19329() - euc)));
        }
    }

    public static void install(class_310 class_3102) {
        if (etx || etw != null || class_3102 == null || class_3102.field_1773 == null || PanicShutdown.armed()) {
            return;
        }
        try {
            class_757 class_7572 = class_3102.field_1773;
            Unsafe unsafe = CameraOffset.euk();
            long l = -1L;
            for (Field field : class_757.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != class_4184.class) continue;
                l = unsafe.objectFieldOffset(field);
                break;
            }
            if (l < 0L) {
                throw new IllegalStateException("camera field not found");
            }
            class_4184 class_41842 = (class_4184)unsafe.getObject(class_7572, l);
            if (class_41842 instanceof CameraOffset) {
                return;
            }
            etv = l;
            etw = class_41842;
            unsafe.putObject(class_7572, l, (Object)new CameraOffset());
        }
        catch (Throwable throwable) {
            etx = true;
            System.out.println("[Flow2] third-person camera stays vanilla: " + throwable);
        }
    }

    public static void uninstall(class_310 class_3102) {
        if (etw == null || class_3102 == null || class_3102.field_1773 == null) {
            return;
        }
        try {
            CameraOffset.euk().putObject(class_3102.field_1773, etv, etw);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        etw = null;
        CameraOffset.euj(class_3102, false);
    }

    public void method_19321(class_1937 class_19372, class_1297 class_12972, boolean bl, boolean bl2, float f) {
        class_1297 class_12973;
        class_1309 class_13092;
        class_310 class_3102 = class_310.method_1551();
        if (!bl || class_12972 == null || PanicShutdown.armed() || class_12972 instanceof class_1309 && (class_13092 = (class_1309)class_12972).method_6113()) {
            this.eua = bl;
            super.method_19321(class_19372, class_12972, bl, bl2, f);
            if (!bl && class_12972 == class_3102.field_1724) {
                this.eui();
            }
            CameraOffset.euj(class_3102, false);
            return;
        }
        super.method_19321(class_19372, class_12972, false, bl2, f);
        this.eua = true;
        if (class_12972 == class_3102.field_1724) {
            this.eui();
        }
        if (bl2) {
            this.method_19325(this.method_19330() + 180.0f, -this.method_19329());
        }
        float f2 = 4.0f;
        float f3 = 1.0f;
        if (class_12972 instanceof class_1309) {
            class_1309 class_13093 = (class_1309)class_12972;
            f3 = class_13093.method_55693();
            f2 = (float)class_13093.method_45325(class_5134.field_59674);
        }
        float f4 = f3;
        float f5 = f2;
        if (class_12972.method_5765() && (class_12973 = class_12972.method_5854()) instanceof class_1309) {
            class_1309 class_13094 = (class_1309)class_12973;
            f4 = class_13094.method_55693();
            f5 = (float)class_13094.method_45325(class_5134.field_59674);
        }
        float f6 = Math.max(f3 * f2, f4 * f5);
        this.method_19324(-(etz > 0.0f ? etz * f3 : f6), 0.0f, 0.0f);
        boolean bl3 = false;
        if (class_19372 != null) {
            class_2338 class_23382 = this.method_19328();
            class_2680 class_26802 = class_19372.method_8320(class_23382);
            bl3 = class_26802.method_26216();
        }
        CameraOffset.euj(class_3102, bl3);
    }

    public boolean method_19333() {
        return this.eua;
    }

    private static void euj(class_310 class_3102, boolean bl) {
        if (class_3102 == null || bl == ety) {
            return;
        }
        ety = bl;
        if (bl) {
            euf = class_3102.field_1730;
            class_3102.field_1730 = false;
        } else {
            class_3102.field_1730 = euf;
        }
    }

    private static Unsafe euk() throws ReflectiveOperationException {
        if (etu == null) {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            etu = (Unsafe)field.get(null);
        }
        return etu;
    }

    static {
        etv = -1L;
        euf = true;
    }

    private static /* synthetic */ int kw(int n, int n2) {
        return n + n2 + -1218004972;
    }

    private static /* synthetic */ int kx(int n, int n2) {
        return CameraOffset.kw(n, n2) + n;
    }

    private static /* synthetic */ int ky(int n, int n2) {
        return CameraOffset.kw(n, n2) * n2;
    }
}

