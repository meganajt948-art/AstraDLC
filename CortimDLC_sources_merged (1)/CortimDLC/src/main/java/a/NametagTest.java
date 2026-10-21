/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_124
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_268
 *  net.minecraft.class_269
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_745
 */
package a;

import a.Friends;
import a.GuiConfig;
import a.HealthBar;
import com.mojang.authlib.GameProfile;
import flow.dev.StringDecryptor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.class_124;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_745;

final class NametagTest {
    private static final List<class_1297> hdu = new ArrayList<class_1297>();
    private static class_268 hdv;
    private static /* synthetic */ String hdw;
    private static /* synthetic */ String hdx;

    private NametagTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        HealthBar rjy2 = HealthBar.get();
        NametagTest.hdy(class_3102);
        switch (n) {
            case 1: {
                rjy2.setEnabled(true);
                rjy2.background.set("Solid");
                rjy2.items.set("Above");
                rjy2.health.set("Text");
                rjy2.size.set(2.0);
                rjy2.shrink.set(0.0);
                class_1657 class_16572 = NametagTest.hdz(class_3102, "erergetjhert", 4.0, 0.9);
                NametagTest.hdz(class_3102, "Enemy", 4.6, -1.4);
                class_269 class_2692 = class_3102.field_1687.method_8428();
                hdv = class_2692.method_1171("flow2tag");
                hdv.method_1139((class_2561)class_2561.method_43470((String)" Grim").method_27692(class_124.field_1060));
                class_2692.method_1172(class_16572.method_7334().name(), hdv);
                Friends.add("erergetjhert");
                break;
            }
            case 30: {
                NametagTest.hea(class_3102, "tag-friend-solid-x2");
                break;
            }
            case 31: {
                rjy2.background.set("Glass");
                break;
            }
            case 45: {
                NametagTest.hea(class_3102, "tag-friend-glass-x2");
                break;
            }
            case 46: {
                rjy2.background.set("Liquid");
                break;
            }
            case 60: {
                NametagTest.hea(class_3102, "tag-friend-liquid-x2");
                break;
            }
            case 61: {
                rjy2.background.set("None");
                break;
            }
            case 75: {
                NametagTest.hea(class_3102, "tag-friend-none-x2");
                break;
            }
            case 76: {
                rjy2.background.set("Solid");
                rjy2.items.set("Inline");
                rjy2.size.set(1.0);
                break;
            }
            case 90: {
                NametagTest.hea(class_3102, "tag-friend-solid-x1");
                break;
            }
            case 91: {
                for (class_1297 class_12972 : hdu) {
                    class_3102.field_1687.method_2945(class_12972.method_5628(), class_1297.class_5529.field_26999);
                }
                hdu.clear();
                class_3102.field_1687.method_8428().method_1191(hdv);
                Friends.remove("erergetjhert");
                rjy2.background.set("Solid");
                rjy2.items.set("Inline");
                rjy2.size.set(1.0);
                rjy2.shrink.set(0.7);
                GuiConfig.save();
                return true;
            }
        }
        return false;
    }

    private static void hdy(class_310 class_3102) {
        class_3102.field_1724.method_36456(0.0f);
        class_3102.field_1724.method_36457(-4.0f);
        class_3102.field_1724.field_5982 = 0.0f;
        class_3102.field_1724.field_6004 = -4.0f;
    }

    private static class_1657 hdz(class_310 class_3102, String string, double d, double d2) {
        class_745 class_7452 = new class_745(class_3102.field_1687, new GameProfile(UUID.randomUUID(), string));
        class_243 class_2432 = class_3102.field_1724.method_73189().method_1019(new class_243(0.0, 0.0, 1.0).method_1021(d)).method_1019(new class_243(-1.0, 0.0, 0.0).method_1021(d2));
        class_7452.method_5808(class_2432.field_1352, class_3102.field_1724.method_23318(), class_2432.field_1350, 180.0f, 0.0f);
        class_7452.method_5636(180.0f);
        class_7452.method_5847(180.0f);
        class_7452.field_6220 = 180.0f;
        class_7452.field_6259 = 180.0f;
        class_7452.method_5673(class_1304.field_6169, new class_1799((class_1935)class_1802.field_22027));
        class_7452.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_22028));
        class_7452.method_5673(class_1304.field_6172, new class_1799((class_1935)class_1802.field_22029));
        class_7452.method_5673(class_1304.field_6166, new class_1799((class_1935)class_1802.field_22030));
        class_7452.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_22022));
        class_7452.method_5673(class_1304.field_6171, new class_1799((class_1935)class_1802.field_8367, 64));
        class_7452.method_6033(15.0f);
        class_3102.field_1687.method_53875((class_1297)class_7452);
        hdu.add((class_1297)class_7452);
        return class_7452;
    }

    private static void hea(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    private static /* synthetic */ int zc(int n, int n2) {
        return n + n2 + 2029322376;
    }

    private static /* synthetic */ int zd(int n, int n2) {
        return NametagTest.zc(n, n2) ^ 0x71EAF5E6;
    }

    private static /* synthetic */ int ze(int n, int n2) {
        return NametagTest.zc(n, n2) * n2;
    }
}

