/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_481
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.NumberSetting;
import a.SlotUtil;
import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_481;
import org.lwjgl.glfw.GLFW;

public class ItemScroller
extends Module {
    private static ItemScroller owp;
    private final BoolSetting owq = this.add(new BoolSetting("Shift drag", true));
    private final BoolSetting owr = this.add(new BoolSetting("Wheel", true));
    private final NumberSetting ows = this.add(new NumberSetting("Speed", 2.0, 1.0, 6.0, 1.0).suffix("/tick"));
    private final ArrayDeque<Integer> owt = new ArrayDeque();
    private final Set<Integer> owu = new HashSet<Integer>();
    private int owv = -1;
    private boolean oww;
    private static /* synthetic */ long owx;
    private static /* synthetic */ long owy;

    public ItemScroller() {
        super("ItemScroller", "Shift drag and wheel to move stacks", ModuleCategory.PLAYER);
        owp = this;
    }

    public static void attach(class_437 class_4373) {
        class_465 class_4652;
        block3: {
            block2: {
                if (!(class_4373 instanceof class_465)) break block2;
                class_4652 = (class_465)class_4373;
                if (!(class_4373 instanceof class_481)) break block3;
            }
            return;
        }
        ScreenMouseEvents.allowMouseScroll((class_437)class_4373).register((class_4372, d, d2, d3, d4) -> owp == null || !owp.owz(class_4652, d4));
        ScreenEvents.afterRender((class_437)class_4373).register((class_4372, class_3322, n, n2, f) -> {
            if (owp != null) {
                owp.oxa(class_4652);
            }
        });
        ScreenEvents.remove((class_437)class_4373).register(class_4372 -> {
            if (owp != null) {
                ItemScroller.owp.owt.clear();
                ItemScroller.owp.owu.clear();
                ItemScroller.owp.oww = false;
            }
        });
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        class_465 class_4652;
        class_437 class_4372;
        block6: {
            block5: {
                if (this.owt.isEmpty()) {
                    return;
                }
                class_4372 = class_3102.field_1755;
                if (!(class_4372 instanceof class_465)) break block5;
                class_4652 = (class_465)class_4372;
                if (class_3102.field_1724 != null && class_4652.method_17577().field_7763 == this.owv) break block6;
            }
            this.owt.clear();
            return;
        }
        class_4372 = class_4652.method_17577();
        for (int i = 0; i < this.ows.getInt() && !this.owt.isEmpty(); ++i) {
            int n = this.owt.poll();
            if (n < 0 || n >= class_4372.field_7761.size() || !((class_1735)class_4372.field_7761.get(n)).method_7681() || !class_4372.method_34255().method_7960()) continue;
            class_3102.field_1761.method_2906(class_4372.field_7763, n, 0, class_1713.field_7794, (class_1657)class_3102.field_1724);
        }
    }

    private boolean owz(class_465<?> class_4652, double d) {
        if (!this.isEnabled() || !this.owr.get() || d == 0.0) {
            return false;
        }
        class_1735 class_17352 = SlotUtil.hovered(class_4652);
        if (class_17352 == null || !class_17352.method_7681()) {
            return false;
        }
        this.oxb(class_4652, class_17352);
        return true;
    }

    private void oxa(class_465<?> class_4652) {
        boolean bl;
        class_310 class_3102 = class_310.method_1551();
        if (!this.isEnabled() || !this.owq.get() || class_3102.method_22683() == null) {
            this.oww = false;
            return;
        }
        long l = class_3102.method_22683().method_4490();
        boolean bl2 = GLFW.glfwGetKey((long)l, (int)340) == 1 || GLFW.glfwGetKey((long)l, (int)344) == 1;
        boolean bl3 = bl = GLFW.glfwGetMouseButton((long)l, (int)0) == 1;
        if (!(bl2 && bl && class_4652.method_17577().method_34255().method_7960())) {
            this.oww = false;
            this.owu.clear();
            return;
        }
        class_1735 class_17352 = SlotUtil.hovered(class_4652);
        if (!this.oww) {
            this.oww = true;
            this.owu.clear();
            if (class_17352 != null) {
                this.owu.add(class_17352.field_7874);
            }
            return;
        }
        if (class_17352 != null && class_17352.method_7681() && this.owu.add(class_17352.field_7874)) {
            this.oxb(class_4652, class_17352);
        }
    }

    private void oxb(class_465<?> class_4652, class_1735 class_17352) {
        int n = class_4652.method_17577().field_7763;
        if (n != this.owv) {
            this.owt.clear();
            this.owv = n;
        }
        if (!this.owt.contains(class_17352.field_7874)) {
            this.owt.add(class_17352.field_7874);
        }
    }

    private static /* synthetic */ int bfm(int n, int n2) {
        return n * n2 + 1489084710;
    }

    private static /* synthetic */ int bfn(int n, int n2) {
        return ItemScroller.bfm(n, n2) ^ 0xAAD5D4F7;
    }
}

