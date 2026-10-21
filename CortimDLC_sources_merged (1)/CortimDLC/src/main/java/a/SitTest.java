/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  net.minecraft.class_1132
 *  net.minecraft.class_1297
 *  net.minecraft.class_1531
 *  net.minecraft.class_1937
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_746
 */
package a;

import a.Box3;
import a.AutoMineController;
import a.TrackingError;
import a.AimModel;
import a.AimBrain;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.dev.StringDecryptor;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1132;
import net.minecraft.class_1297;
import net.minecraft.class_1531;
import net.minecraft.class_1937;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_746;

final class SitTest {
    private static final AtomicInteger gww = new AtomicInteger();
    private static AutoMineController gwx;
    private static final AimBrain gwy;
    private static final TrackingError gwz;
    private static class_2338 gxa;
    private static volatile class_2338 gxb;
    private static int gxc;
    private static /* synthetic */ long gxd;
    private static /* synthetic */ boolean gxe;

    private SitTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        class_746 class_7462 = class_3102.field_1724;
        if (n == 1) {
            class_3102.field_1690.field_1837 = false;
            class_3102.method_1562().method_45730("gamemode survival");
            class_2338 class_23382 = class_7462.method_24515();
            gxa = class_23382.method_10069(4, 0, 3);
            class_3102.method_1576().execute(() -> {
                class_1132 class_11322 = class_3102.method_1576();
                class_3218 class_32182 = class_11322.method_30002();
                for (int i = -2; i <= 7; ++i) {
                    for (int j = -2; j <= 6; ++j) {
                        class_32182.method_8501(class_23382.method_10069(i, -1, j), class_2246.field_10340.method_9564());
                        for (int k = 0; k <= 2; ++k) {
                            class_32182.method_8501(class_23382.method_10069(i, k, j), class_2246.field_10124.method_9564());
                        }
                    }
                }
                class_32182.method_8501(gxa, class_2246.field_10563.method_9564());
                class_11322.method_3734().method_9235().register((LiteralArgumentBuilder)class_2170.method_9247((String)"sit").executes(commandContext -> {
                    class_3222 class_32222 = ((class_2168)commandContext.getSource()).method_9207();
                    gww.incrementAndGet();
                    gxb = class_32222.method_24515();
                    class_1531 class_15312 = new class_1531((class_1937)class_32222.method_51469(), class_32222.method_23317(), class_32222.method_23318() - 0.3, class_32222.method_23321());
                    class_15312.method_5648(true);
                    class_15312.method_5875(true);
                    class_32222.method_51469().method_8649((class_1297)class_15312);
                    class_32222.method_5873((class_1297)class_15312, true, true);
                    return 1;
                }));
                class_3222 class_32222 = class_11322.method_3760().method_14566(class_7462.method_5477().getString());
                class_11322.method_3760().method_14576(class_32222);
            });
        }
        if (n == 30) {
            gwx = new AutoMineController();
            gwx.onSit(() -> class_3102.method_1562().method_45730("sit"));
            gwx.park(Box3.empty(gxa), gxa, true);
            System.out.println("sit test: stairs at " + gxa.method_23854() + ", player at " + class_7462.method_24515().method_23854());
        }
        if (gwx != null && gxc < 0) {
            gwy.newTick();
            gwy.use(AimModel.profile1());
            gwy.tune(1.0, 1.0, 1.0);
            gwy.cap(0.0);
            gwz.cap(110.0);
            gwx.configure(gwz, false, false);
            gwx.startTick(class_3102, class_7462);
            gwx.endTick(class_3102, class_7462, gwy);
            if (n % 10 == 0) {
                System.out.println("sit test t=" + n + " pos=" + class_7462.method_24515().method_23854() + " parked=" + gwx.parked() + " vehicle=" + class_7462.method_5765() + " sits=" + gww.get());
            }
            if (class_7462.method_5765()) {
                gxc = n;
                gwx.stop(class_3102);
            }
        }
        if (gxc > 0 && n == gxc + 10 || n > 530) {
            boolean bl = gxc > 0 && gww.get() >= 1 && gxb != null && (gxb.equals((Object)gxa) || gxb.equals((Object)gxa.method_10084()));
            System.out.println("sit test: /sit sent " + gww.get() + "x, stood at " + (gxb == null ? "-" : gxb.method_23854()) + " (stairs " + gxa.method_23854() + ")");
            System.out.println("sit test " + (bl ? "PASS" : "FAIL"));
            if (gwx != null) {
                gwx.stop(class_3102);
            }
            return true;
        }
        return false;
    }

    static {
        gwy = new AimBrain();
        gwz = new TrackingError();
        gxc = -1;
    }

    private static /* synthetic */ int xf(int n, int n2) {
        return n - n2 + 524443562;
    }

    private static /* synthetic */ int xg(int n, int n2) {
        return SitTest.xf(n, n2) * n2;
    }
}

