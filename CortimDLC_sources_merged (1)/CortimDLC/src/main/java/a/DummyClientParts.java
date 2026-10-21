/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1124
 *  net.minecraft.class_1144
 *  net.minecraft.class_312
 *  net.minecraft.class_702
 *  net.minecraft.class_761
 */
package a;

import a.UnsafeUtil;
import a.ekj;
import a.ekm;
import a.ekp;
import a.eks;
import a.ekv;
import net.minecraft.class_1124;
import net.minecraft.class_1144;
import net.minecraft.class_312;
import net.minecraft.class_702;
import net.minecraft.class_761;

final class DummyClientParts {
    static final class_1144 SOUND = UnsafeUtil.allocate(eks.class);
    static final class_702 PARTICLES = UnsafeUtil.allocate(ekm.class);
    static final class_312 MOUSE = UnsafeUtil.allocate(ekj.class);
    static final class_761 WORLD_RENDERER = UnsafeUtil.allocate(ekv.class);
    static final class_1124 SEARCH = UnsafeUtil.allocate(ekp.class);
    private static /* synthetic */ String ekz;
    private static /* synthetic */ boolean ela;

    private DummyClientParts() {
    }

    private static /* synthetic */ int gs(int n, int n2) {
        return (n ^ n2) + -385645329;
    }
}

