/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10039
 *  net.minecraft.class_10428
 *  net.minecraft.class_11659
 *  net.minecraft.class_12075
 *  net.minecraft.class_1542
 *  net.minecraft.class_238
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_5819
 *  net.minecraft.class_7833
 *  net.minecraft.class_916
 *  org.joml.Quaternionfc
 */
package a;

import a.ItemPhysics;
import a.usg;
import net.minecraft.class_10039;
import net.minecraft.class_10428;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_1542;
import net.minecraft.class_238;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import net.minecraft.class_5819;
import net.minecraft.class_7833;
import net.minecraft.class_916;
import org.joml.Quaternionfc;

public final class ItemEntityRenderer
extends class_916 {
    private final class_5819 usk = class_5819.method_43047();
    private static /* synthetic */ long usl;
    private static /* synthetic */ boolean usm;

    public ItemEntityRenderer(class_5617.class_5618 class_56182) {
        super(class_56182);
    }

    public class_10039 method_62469() {
        return new usg();
    }

    public void method_62470(class_1542 class_15422, class_10039 class_100392, float f) {
        super.method_62470(class_15422, class_100392, f);
        if (class_100392 instanceof usg) {
            usg usg2 = (usg)class_100392;
            usg2.onGround = class_15422.method_24828();
            usg2.inWater = class_15422.method_5799();
            usg2.id = class_15422.method_5628();
        }
    }

    public void method_3996(class_10039 class_100392, class_4587 class_45872, class_11659 class_116592, class_12075 class_120752) {
        usg usg2;
        block8: {
            block7: {
                if (!ItemPhysics.on() || !(class_100392 instanceof usg)) break block7;
                usg2 = (usg)class_100392;
                if (!class_100392.field_55310.method_65606()) break block8;
            }
            super.method_3996(class_100392, class_45872, class_116592, class_120752);
            return;
        }
        class_238 class_2383 = class_100392.field_55310.method_72173();
        boolean bl = class_2383.method_17941() <= 0.0625;
        float f = (float)usg2.id * 137.508f % 360.0f;
        int n = Math.max(1, class_100392.field_55311);
        class_45872.method_22903();
        if (usg2.onGround && !usg2.inWater) {
            if (bl) {
                float f2 = (float)(class_2383.method_17941() * 0.5) + (float)(n - 1) * 0.046875f + 0.004f;
                class_45872.method_46416(0.0f, f2, 0.0f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f));
                class_45872.method_22907((Quaternionfc)class_7833.field_40713.rotationDegrees(90.0f));
                class_45872.method_46416((float)(-class_2383.method_1005().field_1352), (float)(-class_2383.method_1005().field_1351), 0.0f);
            } else {
                class_45872.method_46416(0.0f, (float)(-class_2383.field_1322), 0.0f);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f));
            }
        } else {
            float f3 = class_100392.field_53328 * (usg2.inWater ? 4.0f : 14.0f) * ItemPhysics.spin();
            class_45872.method_46416(0.0f, (float)(-class_2383.field_1322 + 0.0625), 0.0f);
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f + f3));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f3 * 0.8f));
        }
        class_916.method_72986((class_4587)class_45872, (class_11659)class_116592, (int)class_100392.field_61820, (class_10428)class_100392, (class_5819)this.usk, (class_238)class_2383);
        class_45872.method_22909();
    }

    private static /* synthetic */ int dam(int n, int n2) {
        return n + n2 + 1674332874;
    }
}

