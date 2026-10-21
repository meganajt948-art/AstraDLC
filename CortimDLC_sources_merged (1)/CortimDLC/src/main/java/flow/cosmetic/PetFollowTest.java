/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package flow.cosmetic;

import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.cosmetic.Motion;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;

public final class PetFollowTest {
    private static CosmeticItem pet;
    private static Motion m;

    private PetFollowTest() {
    }

    public static String step(class_310 mc, float dt) {
        if (pet == null) {
            CosmeticItem.Bone bone = new CosmeticItem.Bone("body", -1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            bone.solid = new float[]{-3.0f, -4.0f, -3.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 3.0f, 4.0f, 3.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            pet = new CosmeticItem("test_pet", "test", "test", "", "", "pet", "pet", 0, 1, 0.0f, new float[]{6.0f, 22.0f, 0.0f}, 0.0f, 0.0f, 0.0f, new CosmeticItem.Bone[]{bone}, Map.of(), new CosmeticItem.Emitter[0], null, null);
            m = new Motion(-1);
        }
        class_746 p = mc.field_1724;
        PetFollowTest.m.bodyYaw = p.method_73188();
        class_243 pp = p.method_73189();
        class_243 target = Cosmetics.groundSpot(mc, (class_1657)p, pp, m, pet);
        if (PetFollowTest.m.petPos == null || PetFollowTest.m.petWorld != mc.field_1687 || PetFollowTest.m.petPos.method_1025(target) > 196.0) {
            PetFollowTest.m.petPos = target;
            PetFollowTest.m.petVel = class_243.field_1353;
            PetFollowTest.m.petWorld = mc.field_1687;
        } else {
            Cosmetics.follow(m, target, dt, true);
        }
        double feet = PetFollowTest.m.petPos.field_1351 - 0.25;
        return String.format(Locale.ROOT, "feet-over-player-floor %.2f, distance %.2f, speed %.2f, running %s", feet - pp.field_1351, Math.hypot(PetFollowTest.m.petPos.field_1352 - pp.field_1352, PetFollowTest.m.petPos.field_1350 - pp.field_1350), Math.hypot(PetFollowTest.m.petVel.field_1352, PetFollowTest.m.petVel.field_1350), PetFollowTest.m.petRun);
    }
}

