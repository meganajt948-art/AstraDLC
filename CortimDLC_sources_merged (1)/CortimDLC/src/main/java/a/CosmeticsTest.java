/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_276
 *  net.minecraft.class_310
 *  net.minecraft.class_318
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_5498
 *  net.minecraft.server.MinecraftServer
 */
package a;

import a.TestBotSpawner;
import a.ClickGuiScreen;
import a.ubm;
import a.PartyClient;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.StringDecryptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_318;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_5498;
import net.minecraft.server.MinecraftServer;

final class CosmeticsTest {
    private static final String[][] fkn;
    private static final String fko;
    private static final int fkp = 60;
    private static double fkq;
    private static double fkr;
    private static double fks;
    private static boolean fkt;
    private static boolean fku;
    private static final int fkv = 50;
    private static final String fkw;
    private static /* synthetic */ String fkx;
    private static /* synthetic */ long fky;

    private CosmeticsTest() {
    }

    static boolean tick(class_310 class_3102, int n) {
        Object object;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        if (n == 1) {
            CosmeticsTest.flh(class_3102, "gamemode creative");
            CosmeticsTest.flh(class_3102, "time set 6000");
            CosmeticsTest.flh(class_3102, "weather clear");
            PartyClient.ENABLED.set(false);
            class_3102.field_1690.field_1842 = true;
            fkq = Math.floor(class_3102.field_1724.method_23317()) + 0.5;
            fkr = Math.floor(class_3102.field_1724.method_23318());
            fks = Math.floor(class_3102.field_1724.method_23321()) + 0.5;
            System.out.println("cosmetics loaded: " + Cosmetics.items().size());
        }
        int n7 = 20;
        boolean bl = "avatar".equals(System.getenv("FLOW2_COS_ONLY"));
        int n8 = n6 = bl ? n7 : n7 + fkn.length * 60;
        if (n >= n7 && n < n6) {
            n5 = (n - n7) / 60;
            n4 = (n - n7) % 60;
            CosmeticsTest.flg(class_3102, 30.0f, 8.0f);
            if (n4 == 0) {
                CosmeticsTest.flc(fkn[n5]);
                class_3102.field_1690.method_31043(class_5498.field_26665);
            }
            if (n4 == 24) {
                CosmeticsTest.fli(class_3102, "cos-" + String.format("%02d", n5) + "-back");
            }
            if (n4 == 26) {
                class_3102.field_1690.method_31043(class_5498.field_26666);
            }
            if (n4 == 44) {
                CosmeticsTest.fli(class_3102, "cos-" + String.format("%02d", n5) + "-front");
            }
        }
        if (n >= (n5 = n6) && n < n5 + CosmeticsTest.fla()) {
            CosmeticsTest.flb(class_3102, n - n5);
        }
        if (bl && n == n5 + CosmeticsTest.fla()) {
            class_3102.method_1507(null);
            Cosmetics.clearAll();
            System.out.println("cosmetics test avatar phase done");
            return true;
        }
        n4 = n5 + CosmeticsTest.fla();
        if (n == n4) {
            CosmeticsTest.flc(new String[]{"phoenix_wings", "cat_pack", "kitsune_pet", "neko_ears"});
            class_3102.field_1690.method_31043(class_5498.field_26665);
            CosmeticsTest.flg(class_3102, 30.0f, 8.0f);
        }
        if (n == n4 + 20) {
            CosmeticsTest.fli(class_3102, "cos-idle");
            class_3102.field_1690.field_1894.method_23481(true);
        }
        if (n > n4 && n < n4 + 160) {
            CosmeticsTest.flg(class_3102, 30.0f, 8.0f);
        }
        if (n == n4 + 45) {
            CosmeticsTest.fli(class_3102, "cos-walk");
            class_3102.field_1724.method_5728(true);
            class_3102.field_1690.field_1867.method_23481(true);
        }
        if (n == n4 + 70) {
            CosmeticsTest.fli(class_3102, "cos-sprint");
            class_3102.field_1690.field_1867.method_23481(false);
            class_3102.field_1724.method_5728(false);
            class_3102.field_1690.field_1894.method_23481(false);
        }
        if (n == n4 + 90) {
            class_3102.field_1690.field_1903.method_23481(true);
        }
        if (n == n4 + 92) {
            class_3102.field_1690.field_1903.method_23481(false);
        }
        if (n == n4 + 95) {
            CosmeticsTest.fli(class_3102, "cos-jump");
        }
        if (n == n4 + 110) {
            CosmeticsTest.flh(class_3102, String.format(Locale.ROOT, "tp @s %.1f %.1f %.1f", fkq, fkr + 9.0, fks));
        }
        if (n == n4 + 126) {
            CosmeticsTest.fli(class_3102, "cos-fall");
        }
        if (n == n4 + 140) {
            class_3102.field_1690.field_1832.method_23481(true);
        }
        if (n == n4 + 155) {
            CosmeticsTest.fli(class_3102, "cos-sneak");
            class_3102.field_1690.field_1832.method_23481(false);
        }
        if (n >= n4 + 160 && n < n4 + 175) {
            float f = 30.0f + (float)(n - n4 - 160) * 9.0f;
            CosmeticsTest.flg(class_3102, f, 8.0f);
        }
        if (n == n4 + 172) {
            CosmeticsTest.fli(class_3102, "cos-turn");
        }
        if (n == n4 + 180) {
            class_3102.field_1690.method_31043(class_5498.field_26664);
            CosmeticsTest.flg(class_3102, 75.0f, 4.0f);
        }
        if (n == n4 + 200) {
            CosmeticsTest.fli(class_3102, "cos-firstperson");
        }
        if (n == (n3 = n4 + 210)) {
            Cosmetics.clearAll();
            CosmeticsTest.flh(class_3102, String.format(Locale.ROOT, "tp @s %.1f %.1f %.1f 90 0", fkq, fkr, fks));
            double d = fkq - 3.5;
            double d2 = fkr;
            double d3 = fks;
            UUID uUID = class_3102.field_1724.method_5667();
            class_3102.method_1576().execute(() -> TestBotSpawner.spawn((MinecraftServer)class_3102.method_1576(), uUID, d, d2, d3));
        }
        if (n == n3 + 30) {
            fkt = CosmeticsTest.fld();
            System.out.println("cosmetics status code '" + Cosmetics.code() + "', party lookup " + PartyClient.cosmeticsOf("FlowBot"));
        }
        if (n > n3 && n < n3 + 120) {
            CosmeticsTest.flg(class_3102, 90.0f, 6.0f);
        }
        if (n == n3 + 1) {
            class_3102.field_1690.method_31043(class_5498.field_26664);
        }
        if (n == n3 + 70) {
            CosmeticsTest.fli(class_3102, "cos-remote");
            fku = CosmeticsTest.fle(class_3102);
        }
        if (n == n3 + 75) {
            class_3102.field_1690.method_31043(class_5498.field_26665);
        }
        if (n == n3 + 100) {
            CosmeticsTest.fli(class_3102, "cos-remote-far");
        }
        if (n == (n2 = n3 + 120)) {
            class_3102.field_1690.method_31043(class_5498.field_26665);
            class_3102.field_1690.field_1842 = false;
            try {
                object = ClickGuiScreen.class.getDeclaredField("tabKey");
                ((Field)object).setAccessible(true);
                ((Field)object).set(null, "Cosmetics");
            }
            catch (Exception exception) {
                System.out.println("tab field: " + exception);
            }
            class_3102.method_1507((class_437)new ClickGuiScreen());
        }
        if (n == n2 + 30) {
            CosmeticsTest.fli(class_3102, "cos-gui");
        }
        if (n >= n2 + 40) {
            class_3102.method_1507(null);
            object = Cosmetics.items();
            boolean bl2 = !CosmeticsTest.flf("flow.cosmetic.CosmeticGlow", "failed");
            boolean bl3 = object.size() >= 30 && fkt && fku && bl2;
            System.out.println("cosmetics test " + (bl3 ? "PASS" : "FAIL") + " (" + object.size() + " items, party " + fkt + ", remote " + fku + ", glow " + bl2 + ")");
            Cosmetics.clearAll();
            PartyClient.ENABLED.set(true);
            return true;
        }
        return false;
    }

    private static int fkz() {
        return fkw != null ? 1 : 24;
    }

    private static int fla() {
        return CosmeticsTest.fkz() * 50 + 240;
    }

    private static void flb(class_310 class_3102, int n) {
        List<CosmeticItem> list = fkw != null && Cosmetics.get(fkw) != null ? List.of(Cosmetics.get(fkw)) : Cosmetics.ofSlot("avatar");
        int n2 = n / 50;
        int n3 = n % 50;
        if (n2 < CosmeticsTest.fkz()) {
            if (n2 >= list.size()) {
                return;
            }
            CosmeticsTest.flg(class_3102, 30.0f, 8.0f);
            if (n3 == 0) {
                CosmeticsTest.flc(new String[]{list.get((int)n2).id});
                class_3102.field_1690.method_31043(class_5498.field_26666);
            }
            if (n3 == 18) {
                CosmeticsTest.fli(class_3102, "cos-av-" + list.get((int)n2).id + "-front");
                class_3102.field_1690.method_31043(class_5498.field_26665);
            }
            if (n3 == 36) {
                CosmeticsTest.fli(class_3102, "cos-av-" + list.get((int)n2).id + "-back");
            }
            return;
        }
        String string = fkw != null ? fkw : "rhino_girl";
        int n4 = n - CosmeticsTest.fkz() * 50;
        if (n4 == 0) {
            CosmeticsTest.flc(new String[]{string});
            CosmeticsTest.flh(class_3102, "item replace entity @s weapon.mainhand with diamond_sword");
            class_3102.field_1690.method_31043(class_5498.field_26666);
        }
        if (n4 >= 0 && n4 < 200) {
            CosmeticsTest.flg(class_3102, 30.0f, 8.0f);
        }
        if (n4 == 14) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-sword");
            class_3102.field_1690.field_1894.method_23481(true);
        }
        if (n4 == 34) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-walk");
            class_3102.field_1690.method_31043(class_5498.field_26665);
        }
        if (n4 == 50) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-walk-back");
            class_3102.field_1690.method_31043(class_5498.field_26666);
            class_3102.field_1724.method_5728(true);
            class_3102.field_1690.field_1867.method_23481(true);
        }
        if (n4 == 72) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-sprint");
            class_3102.field_1690.field_1867.method_23481(false);
            class_3102.field_1724.method_5728(false);
            class_3102.field_1690.field_1894.method_23481(false);
        }
        if (n4 == 84) {
            class_3102.field_1724.method_6104(class_1268.field_5808);
        }
        if (n4 == 86) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-swing");
            class_3102.field_1690.field_1832.method_23481(true);
        }
        if (n4 == 96) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-sneak");
            class_3102.field_1690.field_1832.method_23481(false);
            class_3102.field_1690.field_1903.method_23481(true);
        }
        if (n4 == 98) {
            class_3102.field_1690.field_1903.method_23481(false);
        }
        if (n4 == 101) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-jump");
            CosmeticsTest.flh(class_3102, "gamemode survival");
            CosmeticsTest.flh(class_3102, "damage @s 1 minecraft:generic");
        }
        if (n4 == 103) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-hurt");
            CosmeticsTest.flh(class_3102, "gamemode creative");
        }
        if (n4 == 104) {
            CosmeticsTest.flc(new String[]{string, "angel_wings"});
            class_3102.field_1690.method_31043(class_5498.field_26665);
        }
        if (n4 == 124) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-wings");
            CosmeticsTest.flc(new String[]{string});
            class_3102.field_1690.field_1842 = false;
            class_3102.method_1507((class_437)new class_490((class_1657)class_3102.field_1724));
        }
        if (n4 == 150) {
            CosmeticsTest.fli(class_3102, "cos-av-hero-inventory");
            class_3102.method_1507(null);
            class_3102.field_1690.field_1842 = true;
            CosmeticsTest.flc(new String[]{"ender_girl"});
            class_3102.field_1690.method_31043(class_5498.field_26666);
            class_3102.field_1690.field_1894.method_23481(true);
            class_3102.field_1724.method_5728(true);
            class_3102.field_1690.field_1867.method_23481(true);
        }
        if (n4 == 176) {
            CosmeticsTest.fli(class_3102, "cos-av-sprint-ender");
            class_3102.field_1690.field_1867.method_23481(false);
            class_3102.field_1724.method_5728(false);
            class_3102.field_1690.field_1894.method_23481(false);
            CosmeticsTest.flh(class_3102, "item replace entity @s weapon.mainhand with air");
        }
    }

    private static void flc(String[] stringArray) {
        Cosmetics.clearAll();
        for (String string : stringArray) {
            CosmeticItem cosmeticItem = Cosmetics.get(string);
            if (cosmeticItem != null) {
                Cosmetics.toggle(cosmeticItem);
                continue;
            }
            System.out.println("cosmetic missing " + string);
        }
    }

    private static boolean fld() {
        try {
            Field field = PartyClient.class.getDeclaredField("code");
            Field field2 = PartyClient.class.getDeclaredField("partyId");
            Field field3 = PartyClient.class.getDeclaredField("MEMBERS");
            field.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);
            field.set(null, "MEMEME");
            field2.set(null, "test-party");
            List list = (List)field3.get(null);
            list.clear();
            ubm ubm2 = new ubm();
            ubm2.code = "MEMEME";
            ubm2.name = class_310.method_1551().method_1548().method_1676();
            ubm2.online = true;
            list.add(ubm2);
            ubm ubm3 = new ubm();
            ubm3.code = "BOTBOT";
            ubm3.name = "FlowBot";
            ubm3.online = true;
            ubm3.cosmetics = "wings:demon_wings,pet:dragon_pet,hat:horns_hat,back:jetpack";
            list.add(ubm3);
            return "wings:demon_wings,pet:dragon_pet,hat:horns_hat,back:jetpack".equals(PartyClient.cosmeticsOf("FlowBot")) && PartyClient.cosmeticsOf("Nobody") == null;
        }
        catch (Exception exception) {
            System.out.println("party inject failed: " + exception);
            return false;
        }
    }

    private static boolean fle(class_310 class_3102) {
        try {
            class_1297 class_12972 = class_3102.field_1687.method_8469(TestBotSpawner.spawned);
            Field field = Cosmetics.class.getDeclaredField("MOTIONS");
            field.setAccessible(true);
            Map map = (Map)field.get(null);
            boolean bl = class_12972 != null && map.containsKey(class_12972.method_5628());
            System.out.println("cosmetics remote bot " + (class_12972 == null ? "missing" : class_12972.method_5477().getString()) + " motion " + bl);
            return bl;
        }
        catch (Exception exception) {
            System.out.println("motion check failed: " + exception);
            return false;
        }
    }

    private static boolean flf(String string, String string2) {
        try {
            Field field = Class.forName(string).getDeclaredField(string2);
            field.setAccessible(true);
            return field.getBoolean(null);
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static void flg(class_310 class_3102, float f, float f2) {
        class_3102.field_1724.method_36456(f);
        class_3102.field_1724.method_36457(f2);
        class_3102.field_1724.field_5982 = f;
        class_3102.field_1724.field_6004 = f2;
        class_3102.field_1724.method_5636(f);
        class_3102.field_1724.field_6220 = f;
        class_3102.field_1724.method_5847(f);
    }

    private static void flh(class_310 class_3102, String string) {
        class_3102.method_1562().method_45730(string);
    }

    private static void fli(class_310 class_3102, String string) {
        System.out.println("self test " + string + " @ " + class_3102.method_47599() + " fps");
        class_318.method_22690((File)class_3102.field_1697, (String)("flow2-" + string + ".png"), (class_276)class_3102.method_1522(), (int)1, class_25612 -> System.out.println("" + class_25612.getString()));
    }

    static {
        fko = "wings:demon_wings,pet:dragon_pet,hat:horns_hat,back:jetpack";
        fkn = new String[][]{{"aurora_wings", "crown_hat", "cat_pet"}, {"phoenix_wings", "horns_hat", "spark_pet"}, {"frost_wings", "neko_ears", "kitsune_pet"}, {"demon_wings", "witch_hat", "drone_pet"}, {"cyber_wings", "headset_hat", "whale_pet"}, {"void_wings", "halo_hat", "ghost_pet"}, {"sakura_wings", "flower_crown", "owl_pet", "cat_pack"}, {"angel_wings", "top_hat", "slime_pet"}, {"jetpack", "fox_mask", "jelly_pet"}, {"cat_pack", "neko_ears", "dragon_pet"}, {"adventure_pack", "crown_hat"}, {"twin_katanas", "horns_hat"}, {"aurora_cape", "crown_hat"}, {"nebula_cape", "witch_hat"}};
        fkw = System.getenv("FLOW2_COS_AV");
    }

    private static /* synthetic */ int pn(int n, int n2) {
        return n + n2 ^ 0x4640E757;
    }

    private static /* synthetic */ int po(int n, int n2) {
        return CosmeticsTest.pn(n, n2) * n2;
    }

    private static /* synthetic */ int pp(int n, int n2) {
        return CosmeticsTest.po(n, n2) + n;
    }
}

