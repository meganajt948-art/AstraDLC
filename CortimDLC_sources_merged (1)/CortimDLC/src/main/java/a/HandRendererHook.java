/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10442
 *  net.minecraft.class_11659
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  net.minecraft.class_1764
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_759
 *  net.minecraft.class_7833
 *  net.minecraft.class_898
 *  org.joml.Quaternionfc
 */
package a;

import a.HandFx;
import a.HandHooks;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import net.minecraft.class_10442;
import net.minecraft.class_11659;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import net.minecraft.class_1764;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_759;
import net.minecraft.class_7833;
import net.minecraft.class_898;
import org.joml.Quaternionfc;

public final class HandRendererHook
extends class_759 {
    private static Field vgk;
    private static Field vgl;
    private static Field vgm;
    private static Field vgn;
    private static Field vgo;
    private static Field vgp;
    private static Field vgq;
    private static MethodHandle vgr;
    private static boolean vgs;
    private static boolean vgt;
    private static Field vgu;
    private final class_310 vgv;
    private final class_10442 vgw;
    private static /* synthetic */ int vgx;
    private static /* synthetic */ boolean vgy;

    private HandRendererHook(class_310 class_3102, class_898 class_8982, class_10442 class_104422) {
        super(class_3102, class_8982, class_104422);
        this.vgv = class_3102;
        this.vgw = class_104422;
    }

    public static void ensureInstalled(class_310 class_3102) {
        if (vgs || class_3102.field_1773 == null) {
            return;
        }
        try {
            Object object;
            Object object2;
            Field field = vgu;
            if (field == null) {
                object2 = class_757.class.getDeclaredFields();
                int n = ((Field[])object2).length;
                for (int i = 0; i < n; ++i) {
                    object = object2[i];
                    if (Modifier.isStatic(object.getModifiers()) || object.getType() != class_759.class) continue;
                    field = object;
                    break;
                }
                if (field == null) {
                    throw new IllegalStateException("no hand renderer in GameRenderer");
                }
                field.setAccessible(true);
                vgu = field;
            }
            if ((object2 = field.get(class_3102.field_1773)) instanceof HandRendererHook) {
                return;
            }
            HandRendererHook.vgz();
            class_759 class_7592 = (class_759)object2;
            class_10442 class_104422 = (class_10442)vgq.get(class_7592);
            object = new HandRendererHook(class_3102, class_3102.method_1561(), class_104422);
            for (Field field2 : class_759.class.getDeclaredFields()) {
                int n = field2.getModifiers();
                if (Modifier.isStatic(n) || Modifier.isFinal(n)) continue;
                field2.setAccessible(true);
                field2.set(object, field2.get(class_7592));
            }
            field.set(class_3102.field_1773, object);
            if (!vgt) {
                vgt = true;
                System.out.println("hand renderer ready (view model, hand shaders)");
            }
        }
        catch (Throwable throwable) {
            vgs = true;
            System.out.println("hand tweaks unavailable, the game's hands stay: " + throwable);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void vgz() throws ReflectiveOperationException {
        void var2_5;
        if (vgr != null) {
            return;
        }
        ArrayList<Field> arrayList = new ArrayList<Field>();
        ArrayList<Field> arrayList2 = new ArrayList<Field>();
        for (Field field : class_759.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            field.setAccessible(true);
            if (field.getType() == class_1799.class) {
                arrayList.add(field);
                continue;
            }
            if (field.getType() == Float.TYPE) {
                arrayList2.add(field);
                continue;
            }
            if (field.getType() != class_10442.class) continue;
            vgq = field;
        }
        if (arrayList.size() != 2 || arrayList2.size() != 4 || vgq == null) {
            throw new IllegalStateException("unexpected hand renderer layout: " + arrayList.size() + " stacks, " + arrayList2.size() + " floats");
        }
        vgk = (Field)arrayList.get(0);
        vgl = (Field)arrayList.get(1);
        vgm = (Field)arrayList2.get(0);
        vgn = (Field)arrayList2.get(1);
        vgo = (Field)arrayList2.get(2);
        vgp = (Field)arrayList2.get(3);
        Object var2_3 = null;
        for (Method method : class_759.class.getDeclaredMethods()) {
            Class<?>[] classArray = method.getParameterTypes();
            if (method.getReturnType() != Void.TYPE || classArray.length != 10 || classArray[0] != class_742.class || classArray[3] != class_1268.class || classArray[5] != class_1799.class || classArray[7] != class_4587.class || classArray[8] != class_11659.class || classArray[9] != Integer.TYPE) continue;
            Method method2 = method;
            break;
        }
        if (var2_5 == null) {
            throw new IllegalStateException("first-person item method not found");
        }
        var2_5.setAccessible(true);
        vgr = MethodHandles.lookup().unreflect((Method)var2_5);
    }

    public void method_22976(float f, class_4587 class_45872, class_11659 class_116592, class_746 class_7462, int n) {
        if (!HandHooks.changesHands()) {
            super.method_22976(f, class_45872, class_116592, class_7462, n);
            HandFx.afterHands(class_7462, f);
            return;
        }
        try {
            this.vha(f, class_45872, class_116592, class_7462, n);
        }
        catch (Throwable throwable) {
            vgs = true;
            System.out.println("hand tweaks failed, back to the game's hands: " + throwable);
            super.method_22976(f, class_45872, class_116592, class_7462, n);
        }
        HandFx.afterHands(class_7462, f);
    }

    private void vha(float f, class_4587 class_45872, class_11659 class_116592, class_746 class_7462, int n) throws Throwable {
        float f2;
        float f3 = class_7462.method_6055(f);
        class_1268 class_12682 = class_7462.field_6266 != null ? class_7462.field_6266 : class_1268.field_5808;
        float f4 = class_7462.method_61414(f);
        float f5 = class_3532.method_16439((float)f, (float)class_7462.field_3914, (float)class_7462.field_3916);
        float f6 = class_3532.method_16439((float)f, (float)class_7462.field_3931, (float)class_7462.field_3932);
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees((class_7462.method_5695(f) - f5) * 0.1f));
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((class_7462.method_5705(f) - f6) * 0.1f));
        boolean[] blArray = HandRendererHook.vhc(class_7462);
        class_1799 class_17992 = (class_1799)vgk.get((Object)this);
        class_1799 class_17993 = (class_1799)vgl.get((Object)this);
        if (blArray[0]) {
            f2 = this.vgw.method_75483(class_17992) * (1.0f - class_3532.method_16439((float)f, (float)vgn.getFloat((Object)this), (float)vgm.getFloat((Object)this)));
            this.vhb((class_742)class_7462, f, f4, class_1268.field_5808, class_12682 == class_1268.field_5808 ? f3 : 0.0f, class_17992, f2, class_45872, class_116592, n);
        }
        if (blArray[1]) {
            f2 = this.vgw.method_75483(class_17993) * (1.0f - class_3532.method_16439((float)f, (float)vgp.getFloat((Object)this), (float)vgo.getFloat((Object)this)));
            this.vhb((class_742)class_7462, f, f4, class_1268.field_5810, class_12682 == class_1268.field_5810 ? f3 : 0.0f, class_17993, f2, class_45872, class_116592, n);
        }
        this.vgv.field_1773.method_72911().method_73002();
        this.vgv.method_22940().method_23000().method_22993();
    }

    private void vhb(class_742 class_7422, float f, float f2, class_1268 class_12682, float f3, class_1799 class_17992, float f4, class_4587 class_45872, class_11659 class_116592, int n) throws Throwable {
        class_1306 class_13062 = class_12682 == class_1268.field_5808 ? class_7422.method_6068() : class_7422.method_6068().method_5928();
        boolean bl = class_17992.method_31574(class_1802.field_49814);
        boolean bl2 = HandHooks.swings(class_7422, class_12682, class_17992);
        class_45872.method_22903();
        if (!bl) {
            HandHooks.viewModel(class_45872, class_13062);
        }
        if (bl2) {
            HandHooks.swing(class_45872, class_7422, class_13062, class_12682, f3, class_17992, f);
        }
        vgr.invoke(this, class_7422, f, f2, class_12682, bl2 ? 0.0f : f3, class_17992, bl2 && !bl ? 0.0f : f4, class_45872, class_116592, n);
        class_45872.method_22909();
    }

    private static boolean[] vhc(class_746 class_7462) {
        boolean bl;
        class_1799 class_17992 = class_7462.method_6047();
        class_1799 class_17993 = class_7462.method_6079();
        boolean bl2 = class_17992.method_31574(class_1802.field_8102) || class_17993.method_31574(class_1802.field_8102);
        boolean bl3 = bl = class_17992.method_31574(class_1802.field_8399) || class_17993.method_31574(class_1802.field_8399);
        if (!bl2 && !bl) {
            return new boolean[]{true, true};
        }
        if (class_7462.method_6115()) {
            class_1799 class_17994 = class_7462.method_6030();
            class_1268 class_12682 = class_7462.method_6058();
            if (!class_17994.method_31574(class_1802.field_8102) && !class_17994.method_31574(class_1802.field_8399)) {
                boolean bl4 = class_12682 == class_1268.field_5808 && HandRendererHook.vhd(class_17993);
                return new boolean[]{true, !bl4};
            }
            return new boolean[]{class_12682 == class_1268.field_5808, class_12682 == class_1268.field_5810};
        }
        return new boolean[]{true, !HandRendererHook.vhd(class_17992)};
    }

    private static boolean vhd(class_1799 class_17992) {
        return class_17992.method_31574(class_1802.field_8399) && class_1764.method_7781((class_1799)class_17992);
    }

    private static /* synthetic */ int deu(int n, int n2) {
        return n - n2 ^ 0x8AEEDDA2;
    }
}

