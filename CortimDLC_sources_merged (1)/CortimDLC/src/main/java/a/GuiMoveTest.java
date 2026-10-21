/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  net.minecraft.class_10185
 *  net.minecraft.class_1132
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_243
 *  net.minecraft.class_2535
 *  net.minecraft.class_2813
 *  net.minecraft.class_2815
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_2851
 *  net.minecraft.class_310
 *  net.minecraft.class_3222
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_746
 *  net.minecraft.class_8609
 */
package a;

import a.fyi;
import a.Module;
import a.BoolSetting;
import a.Setting;
import a.IdleTracker;
import a.KeyUtil;
import a.ForwardKeyHold;
import flow.Flow;
import flow.dev.StringDecryptor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_10185;
import net.minecraft.class_1132;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_243;
import net.minecraft.class_2535;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_2848;
import net.minecraft.class_2851;
import net.minecraft.class_310;
import net.minecraft.class_3222;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_746;
import net.minecraft.class_8609;

final class GuiMoveTest {
    private static final int fym = 170;
    private static final Set<Integer> fyn = ConcurrentHashMap.newKeySet();
    private static final AtomicInteger fyo = new AtomicInteger();
    private static final AtomicInteger fyp = new AtomicInteger();
    private static final AtomicInteger fyq = new AtomicInteger();
    private static final StringBuffer fyr = new StringBuffer();
    private static volatile boolean fys;
    private static volatile boolean fyt;
    private static volatile boolean fyu;
    private static int fyv;
    private static int fyw;
    private static int fyx;
    private static int fyy;
    private static double fyz;
    private static class_243 fza;
    private static int fzb;
    private static boolean fzc;
    private static /* synthetic */ long fzd;
    private static /* synthetic */ String fze;

    private GuiMoveTest() {
    }

    static boolean tick(class_310 class_3102, int n) throws Exception {
        if (n == 1) {
            KeyUtil.simulated = fyn::contains;
            Module kfe2 = Flow.getInstance().getModuleManager().getByName("GuiMove");
            kfe2.setEnabled(true);
            Module kfe3 = Flow.getInstance().getModuleManager().getByName("AutoSprint");
            if (kfe3 != null) {
                kfe3.setEnabled(false);
            }
            class_3102.method_1562().method_45730("gamemode survival");
            class_3102.method_1562().method_45730("effect give @s resistance 600 4 true");
            class_3102.method_1562().method_45730("effect give @s saturation 600 4 true");
        }
        if (n == 5) {
            GuiMoveTest.fzj(class_3102);
        }
        if (n < 10) {
            return false;
        }
        int n2 = n - 10;
        int n3 = n2 / 170;
        int n4 = n2 % 170;
        if (n3 >= 2) {
            KeyUtil.simulated = null;
            System.out.println("guimove test " + (fzb == 0 ? "PASS" : "FAIL (" + fzb + ")"));
            return true;
        }
        GuiMoveTest.fzf(class_3102, n3 == 0, n4);
        return false;
    }

    private static void fzf(class_310 class_3102, boolean bl, int n) {
        class_746 class_7462 = class_3102.field_1724;
        String string = bl ? "A(gate on)" : "B(gate off)";
        switch (n) {
            case 0: {
                GuiMoveTest.fzi(bl);
                class_3102.method_1562().method_45730("clear @s");
                class_3102.method_1562().method_45730("item replace entity @s hotbar.0 with minecraft:stone 64");
                class_3102.method_1562().method_45730("item replace entity @s hotbar.1 with minecraft:dirt 64");
                class_3102.method_1562().method_45730("item replace entity @s hotbar.2 with minecraft:oak_log 64");
                class_3102.method_1562().method_45730("item replace entity @s hotbar.3 with minecraft:cobblestone 64");
                class_7462.method_36456((float)class_7462.field_6012 * 37.0f % 360.0f);
                break;
            }
            case 5: {
                fyn.add(87);
                fyn.add(341);
                class_3102.field_1690.field_1894.method_23481(true);
                class_3102.field_1690.field_1867.method_23481(true);
                break;
            }
            case 20: {
                fyo.set(0);
                fyp.set(0);
                fyq.set(0);
                fyr.setLength(0);
                fyv = 0;
                fyw = 0;
                fyx = 0;
                fyy = 0;
                fyz = 0.0;
                fza = class_7462.method_73189();
                System.out.println("guimove " + string + " before open: sprinting=" + class_7462.method_5624() + " serverSprint=" + ForwardKeyHold.serverSprinting(class_7462));
                class_3102.method_1507((class_437)new class_490((class_1657)class_7462));
                break;
            }
            case 30: {
                GuiMoveTest.fzg(class_3102, 36, 0, class_1713.field_7790);
                break;
            }
            case 38: {
                GuiMoveTest.fzg(class_3102, 10, 0, class_1713.field_7790);
                break;
            }
            case 46: {
                GuiMoveTest.fzg(class_3102, 37, 0, class_1713.field_7790);
                break;
            }
            case 54: {
                GuiMoveTest.fzg(class_3102, 11, 0, class_1713.field_7790);
                break;
            }
            case 62: {
                GuiMoveTest.fzg(class_3102, 38, 0, class_1713.field_7790);
                GuiMoveTest.fzg(class_3102, 12, 0, class_1713.field_7790);
                GuiMoveTest.fzg(class_3102, 12, 0, class_1713.field_7790);
                GuiMoveTest.fzg(class_3102, 13, 0, class_1713.field_7790);
                break;
            }
            case 70: {
                fyn.add(340);
                break;
            }
            case 74: {
                GuiMoveTest.fzg(class_3102, 39, 0, class_1713.field_7794);
                break;
            }
            case 75: {
                GuiMoveTest.fzg(class_3102, 10, 0, class_1713.field_7794);
                break;
            }
            case 80: {
                fyn.remove(340);
                break;
            }
            case 86: 
            case 87: 
            case 88: 
            case 89: {
                GuiMoveTest.fzg(class_3102, 11 + (n - 86) % 2, 0, class_1713.field_7790);
                break;
            }
            case 100: {
                fyn.add(32);
                break;
            }
            case 104: {
                GuiMoveTest.fzg(class_3102, 13, 1, class_1713.field_7790);
                break;
            }
            case 106: {
                GuiMoveTest.fzg(class_3102, 14, 0, class_1713.field_7790);
                break;
            }
            case 110: {
                fyn.remove(32);
                break;
            }
            case 120: {
                if (class_7462.field_7512.method_34255().method_7960()) break;
                GuiMoveTest.fzg(class_3102, 15, 0, class_1713.field_7790);
                break;
            }
            case 125: {
                class_7462.method_7346();
                break;
            }
            case 145: {
                fyn.clear();
                class_3102.field_1690.field_1894.method_23481(false);
                class_3102.field_1690.field_1867.method_23481(false);
                break;
            }
            case 160: {
                GuiMoveTest.fzh(string, bl, class_7462);
                break;
            }
        }
        if (n > 20 && n <= 125 && class_3102.field_1755 instanceof class_490) {
            ++fyw;
            class_243 class_2432 = class_7462.method_73189();
            fyz += Math.hypot(class_2432.field_1352 - GuiMoveTest.fza.field_1352, class_2432.field_1350 - GuiMoveTest.fza.field_1350);
            fza = class_2432;
            if (ForwardKeyHold.serverSprinting(class_7462)) {
                ++fyx;
            }
            if (class_10185.field_54098.equals((Object)IdleTracker.lastSent(class_7462))) {
                ++fyy;
            }
        }
        if (n == 131 && class_3102.field_1755 == null) {
            System.out.println("guimove " + string + " after close: forward=" + class_3102.field_1690.field_1894.method_1434() + " sprinting=" + class_7462.method_5624() + " input=" + IdleTracker.lastSent(class_7462));
        }
    }

    private static void fzg(class_310 class_3102, int n, int n2, class_1713 class_17132) {
        class_746 class_7462 = class_3102.field_1724;
        class_3102.field_1761.method_2906(class_7462.field_7512.field_7763, n, n2, class_17132, (class_1657)class_7462);
        ++fyv;
    }

    private static void fzh(String string, boolean bl, class_746 class_7462) {
        double d = fyw == 0 ? 0.0 : fyz / (double)fyw * 20.0;
        System.out.println("guimove " + string + ": clicks made=" + fyv + " seen=" + fyo.get() + " closes=" + fyp.get() + " violations=" + fyq.get() + " guiTicks=" + fyw + " sprintTicks=" + fyx + " idleTicks=" + fyy + String.format(" speed=%.2f b/s", d) + " cursor=" + class_7462.field_7512.method_34255());
        if (!fyr.isEmpty()) {
            System.out.println("guimove " + string + " violations:" + fyr);
        }
        if (fyo.get() != fyv || fyp.get() != 1) {
            ++fzb;
            System.out.println("guimove " + string + " FAIL packets lost or duplicated");
        }
        if (bl) {
            if (fyq.get() != 0) {
                ++fzb;
                System.out.println("guimove " + string + " FAIL MultiActions would flag");
            }
            if (d < 4.0 || (double)fyx < (double)fyw * 0.7) {
                ++fzb;
                System.out.println("guimove " + string + " FAIL too slow in the inventory");
            }
        } else if (fyq.get() == 0) {
            ++fzb;
            System.out.println("guimove " + string + " FAIL control run saw no violations (recorder broken?)");
        }
    }

    private static void fzi(boolean bl) {
        Module kfe2 = Flow.getInstance().getModuleManager().getByName("GuiMove");
        for (Setting vmo2 : kfe2.getSettings()) {
            BoolSetting vkl2;
            if (!(vmo2 instanceof BoolSetting) || !(vkl2 = (BoolSetting)vmo2).getName().equals("Anti MultiActions")) continue;
            vkl2.set(bl);
        }
    }

    private static void fzj(class_310 class_3102) throws Exception {
        if (fzc) {
            return;
        }
        class_1132 class_11322 = class_3102.method_1576();
        class_3222 class_32222 = class_11322.method_3760().method_14602(class_3102.field_1724.method_5667());
        class_2535 class_25352 = null;
        for (Field field : class_8609.class.getDeclaredFields()) {
            if (field.getType() != class_2535.class) continue;
            field.setAccessible(true);
            class_25352 = (class_2535)field.get(class_32222.field_13987);
        }
        Channel channel = null;
        for (Field field : class_2535.class.getDeclaredFields()) {
            if (!Channel.class.isAssignableFrom(field.getType())) continue;
            field.setAccessible(true);
            channel = (Channel)field.get(class_25352);
        }
        channel.pipeline().addBefore("packet_handler", "flow2_test_recorder", (ChannelHandler)new fyi());
        fzc = true;
        System.out.println("guimove recorder on " + channel.getClass().getSimpleName());
    }

    private static void fzk(Object object) {
        if (object instanceof class_2851) {
            class_2851 class_28512 = (class_2851)object;
            class_10185 class_101852 = class_28512.comp_3139();
            fys = class_101852.comp_3159() || class_101852.comp_3160() || class_101852.comp_3161() || class_101852.comp_3162() || class_101852.comp_3163();
            fyt = class_101852.comp_3164();
        } else if (object instanceof class_2848) {
            class_2848 class_28482 = (class_2848)object;
            if (class_28482.method_12365() == class_2848.class_2849.field_12981) {
                fyu = true;
            } else if (class_28482.method_12365() == class_2848.class_2849.field_12985) {
                fyu = false;
            }
        } else if (object instanceof class_2813 || object instanceof class_2815) {
            if (object instanceof class_2813) {
                fyo.incrementAndGet();
            } else {
                fyp.incrementAndGet();
            }
            if (fys || fyt || fyu) {
                fyq.incrementAndGet();
                if (fyr.length() < 400) {
                    fyr.append(" [").append(object.getClass().getSimpleName()).append(" moving=").append(fys).append(" sneak=").append(fyt).append(" sprint=").append(fyu).append(']');
                }
            }
        }
    }

    private static /* synthetic */ int sj(int n, int n2) {
        return n + n2 | 0x67C5FAC1;
    }

    private static /* synthetic */ int sk(int n, int n2) {
        return GuiMoveTest.sj(n, n2) + n;
    }
}

