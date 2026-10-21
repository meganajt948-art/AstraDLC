/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.ClickGuiScreen;
import a.ProfilePopup;
import a.AimStudio;
import a.StudioProfiles;
import flow.dev.StringDecryptor;
import java.io.File;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;

final class AuraProfileTest {
    private static final String fdq = System.getenv().getOrDefault("FLOW2_AURA_PROFILE", "AuraTest");
    private static /* synthetic */ long fdr;
    private static /* synthetic */ boolean fds;

    private AuraProfileTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        if (n == 1) {
            GLFW.glfwSetWindowSize((long)class_3102.method_22683().method_4490(), (int)1600, (int)900);
        }
        if (n == 20) {
            StudioProfiles tiq2 = StudioProfiles.open(fdq);
            System.out.println("aura studio test profile " + fdq + ": " + (tiq2 == null ? "missing" : tiq2.purpose() + ", aura model " + (tiq2.auraModel() != null)));
            AimStudio.activate(tiq2);
            class_3102.method_1507((class_437)new ClickGuiScreen());
        }
        if (n == 32) {
            ProfilePopup.open();
        }
        if (n == 65) {
            System.out.println("self test aura-studio");
            class_318.method_22690((File)class_3102.field_1697, (String)"flow2-aura-studio.png", (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
        }
        if (n == 75) {
            class_3102.method_1507(null);
            return true;
        }
        return false;
    }

    private static /* synthetic */ int nt(int n, int n2) {
        return n ^ n2 | 0x1CB2367B;
    }

    private static /* synthetic */ int nu(int n, int n2) {
        return AuraProfileTest.nt(n, n2) ^ 0x12FA01D1;
    }

    private static /* synthetic */ int nv(int n, int n2) {
        return AuraProfileTest.nu(n, n2) + n;
    }
}

