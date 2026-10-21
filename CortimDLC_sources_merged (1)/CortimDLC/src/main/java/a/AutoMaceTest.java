/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_310
 *  net.minecraft.class_3222
 *  net.minecraft.class_746
 */
package a;

import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.Locale;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_310;
import net.minecraft.class_3222;
import net.minecraft.class_746;

final class AutoMaceTest {
    private static final int hgf = 20;
    private static final int hgg = 5;
    private static int hgh;
    private static boolean hgi;
    private static /* synthetic */ int hgj;
    private static /* synthetic */ int hgk;

    private AutoMaceTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        class_1661 class_16612;
        class_746 class_7462 = class_3102.field_1724;
        if (n == 1) {
            AutoMaceTest.hgp(class_3102, "gamemode survival");
            AutoMaceTest.hgp(class_3102, "time set 6000");
            AutoMaceTest.hgp(class_3102, "effect give @s minecraft:resistance 120 10 true");
        }
        if (n == 20) {
            AutoMaceTest.hgl(class_3102, 20);
            Flow.getInstance().getModuleManager().getByName("AutoMace").setEnabled(true);
        }
        if (n == 30) {
            AutoMaceTest.hgm(class_3102);
        }
        if (n > 30 && n < 110) {
            AutoMaceTest.hgn(class_7462, "inventory", n);
        }
        if (n == 110) {
            class_16612 = class_7462.method_31548();
            AutoMaceTest.hgo(hgi, "inventory: the mace never came into the hand");
            AutoMaceTest.hgo(class_16612.method_5438(20).method_31574(class_1802.field_49814), "inventory: the mace didn't go back to 20 (there: " + class_16612.method_5438(20) + ")");
            AutoMaceTest.hgo(class_16612.method_5438(0).method_31574(class_1802.field_49098), "inventory: slot 0 isn't the wind charge: " + class_16612.method_5438(0));
            hgi = false;
            AutoMaceTest.hgl(class_3102, 5);
        }
        if (n == 125) {
            AutoMaceTest.hgm(class_3102);
        }
        if (n > 125 && n < 205) {
            AutoMaceTest.hgn(class_7462, "hotbar", n);
        }
        if (n == 205) {
            class_16612 = class_7462.method_31548();
            AutoMaceTest.hgo(hgi, "hotbar: the mace never came into the hand");
            AutoMaceTest.hgo(class_16612.method_67532() == 0, "hotbar: the slot didn't come back to 0: " + class_16612.method_67532());
            AutoMaceTest.hgo(class_16612.method_5438(5).method_31574(class_1802.field_49814), "hotbar: the mace moved");
            Flow.getInstance().getModuleManager().getByName("AutoMace").setEnabled(false);
            System.out.println("wind mace test " + (hgh == 0 ? "PASS" : "FAIL (" + hgh + ")"));
            return true;
        }
        return false;
    }

    private static void hgl(class_310 class_3102, int n) {
        class_3102.method_1576().execute(() -> {
            class_3222 class_32222 = class_3102.method_1576().method_3760().method_14566(class_3102.field_1724.method_5477().getString());
            class_32222.method_31548().method_5448();
            class_32222.method_31548().method_5447(0, new class_1799((class_1935)class_1802.field_49098, 16));
            class_32222.method_31548().method_5447(1, new class_1799((class_1935)class_1802.field_8802));
            class_32222.method_31548().method_5447(n, new class_1799((class_1935)class_1802.field_49814));
        });
        class_3102.field_1724.method_31548().method_61496(0);
    }

    private static void hgm(class_310 class_3102) {
        class_3102.field_1724.method_36457(89.0f);
        class_3102.field_1724.field_6004 = 89.0f;
        class_3102.field_1761.method_2919((class_1657)class_3102.field_1724, class_1268.field_5808);
        class_3102.field_1724.method_6104(class_1268.field_5808);
        System.out.println("wind mace test: thrown, cooldown " + class_3102.field_1724.method_7357().method_7904(new class_1799((class_1935)class_1802.field_49098)));
    }

    private static void hgn(class_746 class_7462, String string, int n) {
        boolean bl = class_7462.method_6047().method_31574(class_1802.field_49814);
        hgi |= bl && !class_7462.method_24828();
        if (n % 5 == 0) {
            System.out.println("wind mace test " + string + " t=" + n + " ground=" + class_7462.method_24828() + " y=" + String.format(Locale.ROOT, "%.2f", class_7462.method_23318()) + " held=" + class_7462.method_31548().method_67532() + " hand=" + class_7462.method_6047().method_7909());
        }
    }

    private static void hgo(boolean bl, String string) {
        if (!bl) {
            ++hgh;
            System.out.println("wind mace test check failed: " + string);
        }
    }

    private static void hgp(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static /* synthetic */ int zt(int n, int n2) {
        return n * n2 | 0xCA5D47A0;
    }
}

