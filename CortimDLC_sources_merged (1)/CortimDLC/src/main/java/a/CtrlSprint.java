/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents
 *  net.minecraft.class_10260
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_342
 *  net.minecraft.class_364
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_507
 */
package a;

import a.ClickGuiScreen;
import a.WheelScreen;
import a.ModuleCategory;
import a.Module;
import a.BoolSetting;
import a.PacketGate;
import a.Reflect;
import a.IdleTracker;
import a.KeyUtil;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;
import net.minecraft.class_10260;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_507;

public class CtrlSprint
extends Module {
    private static final Field lwy = Reflect.find(class_10260.class, "net.minecraft.class_10260", "field_54474", "Lnet/minecraft/class_507;");
    private static final Field lwz = Reflect.find(class_507.class, "net.minecraft.class_507", "field_3089", "Lnet/minecraft/class_342;");
    private static CtrlSprint lxa;
    private final BoolSetting lxb = this.add(new BoolSetting("Sprint on Ctrl", true));
    private final BoolSetting lxc = this.add(new BoolSetting("Jump", true));
    private final BoolSetting lxd = this.add(new BoolSetting("In client menu", true));
    private final BoolSetting lxe = this.add(new BoolSetting("Anti MultiActions", true));
    private final IdleTracker lxf = new IdleTracker();
    private boolean lxg;
    private static /* synthetic */ long lxh;
    private static /* synthetic */ long lxi;

    public CtrlSprint() {
        super("GuiMove", "Move with the inventory or menu open", ModuleCategory.MOVEMENT);
        lxa = this;
    }

    public static void attach(class_437 class_4373) {
        CtrlSprint lwx2 = lxa;
        if (lwx2 == null) {
            return;
        }
        if (class_4373 instanceof class_465) {
            ScreenKeyboardEvents.allowKeyPress((class_437)class_4373).register((class_4372, class_119082) -> !lwx2.isEnabled() || !lwx2.lxc.get() || !lwx2.mc.field_1690.field_1903.method_1417(class_119082) || CtrlSprint.lxk(class_4372));
        }
        if (lwx2.isEnabled() && lwx2.lxj(class_4373) && !lwx2.lxf.isHeld()) {
            lwx2.lxl(lwx2.mc);
            lwx2.lxg = true;
        }
    }

    @Override
    protected void onDisable() {
        PacketGate.setActive(false);
        this.lxf.release(this.mc);
        if (this.mc.field_1755 != null && this.mc.field_1690 != null) {
            CtrlSprint.lxm(this.mc);
        }
        this.lxg = false;
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        PacketGate.setActive(this.lxe.get());
        if (this.lxe.get()) {
            PacketGate.ensure(class_3102);
            if (PacketGate.waiting()) {
                this.lxf.hold(class_3102);
                return;
            }
        }
        boolean bl = this.lxf.isHeld();
        this.lxf.release(class_3102);
        class_437 class_4372 = class_3102.field_1755;
        if (class_4372 == null) {
            if (this.lxg) {
                CtrlSprint.lxn(class_3102);
            }
            this.lxg = false;
        } else if (this.lxj(class_4372)) {
            this.lxl(class_3102);
            this.lxg = true;
        } else if (this.lxg || bl) {
            CtrlSprint.lxm(class_3102);
            this.lxg = false;
        }
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (this.lxe.get() && PacketGate.waiting()) {
            PacketGate.poke(false);
        }
    }

    private boolean lxj(class_437 class_4372) {
        if (class_4372 instanceof ClickGuiScreen) {
            ClickGuiScreen hlc2 = (ClickGuiScreen)class_4372;
            return this.lxd.get() && !hlc2.typing();
        }
        if (class_4372 instanceof WheelScreen) {
            return true;
        }
        return class_4372 instanceof class_465 && !CtrlSprint.lxk(class_4372);
    }

    private static boolean lxk(class_437 class_4372) {
        Object object;
        class_364 class_3642;
        Object object2 = class_4372.method_25396().iterator();
        while (object2.hasNext()) {
            class_3642 = (class_364)object2.next();
            if (!(class_3642 instanceof class_342) || !(object = (class_342)class_3642).method_25370() || !object.method_1885()) continue;
            return true;
        }
        if (class_4372 instanceof class_10260 && lwy != null && lwz != null) {
            try {
                object = lwy.get(class_4372);
                return object instanceof class_507 && (class_3642 = (class_507)object).method_2605() && (object = lwz.get(class_3642)) instanceof class_342 && (object2 = object).method_25370();
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        return false;
    }

    private void lxl(class_310 class_3102) {
        class_315 class_3152 = class_3102.field_1690;
        CtrlSprint.lxo(class_3102, class_3152.field_1894, true);
        CtrlSprint.lxo(class_3102, class_3152.field_1881, true);
        CtrlSprint.lxo(class_3102, class_3152.field_1913, true);
        CtrlSprint.lxo(class_3102, class_3152.field_1849, true);
        CtrlSprint.lxo(class_3102, class_3152.field_1903, this.lxc.get());
        if (!((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            CtrlSprint.lxo(class_3102, class_3152.field_1867, this.lxb.get());
        }
        if (!((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
            class_3152.field_1832.method_23481(false);
        }
        class_3152.field_1904.method_23481(false);
    }

    private static void lxm(class_310 class_3102) {
        class_315 class_3152 = class_3102.field_1690;
        for (class_304 class_3042 : new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903, class_3152.field_1904}) {
            class_3042.method_23481(false);
        }
        if (!((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            class_3152.field_1867.method_23481(false);
        }
        if (!((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
            class_3152.field_1832.method_23481(false);
        }
    }

    private static void lxn(class_310 class_3102) {
        class_315 class_3152 = class_3102.field_1690;
        for (class_304 class_3042 : new class_304[]{class_3152.field_1894, class_3152.field_1881, class_3152.field_1913, class_3152.field_1849, class_3152.field_1903}) {
            CtrlSprint.lxo(class_3102, class_3042, true);
        }
        if (!((Boolean)class_3152.method_42450().method_41753()).booleanValue()) {
            CtrlSprint.lxo(class_3102, class_3152.field_1867, true);
        }
        if (!((Boolean)class_3152.method_42449().method_41753()).booleanValue()) {
            CtrlSprint.lxo(class_3102, class_3152.field_1832, true);
        }
    }

    private static void lxo(class_310 class_3102, class_304 class_3042, boolean bl) {
        class_3042.method_23481(bl && KeyUtil.isPhysicallyDown(class_3102, class_3042));
    }

    private static /* synthetic */ int bad(int n, int n2) {
        return n - n2 | 0x368F1D42;
    }

    private static /* synthetic */ int bae(int n, int n2) {
        return CtrlSprint.bad(n, n2) + n;
    }
}

