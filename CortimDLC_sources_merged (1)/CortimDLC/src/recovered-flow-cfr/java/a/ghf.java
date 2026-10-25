/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 */
package a;

import a.izx;
import a.kfe;
import a.kfx;
import a.rhs;
import a.vkl;
import a.vlv;
import a.vmo;
import flow.Flow;
import flow.cosmetic.PetFollowTest;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;

final class ghf {
    private static final String[] ghg = new String[]{a.b("A\u79d2\uf30c\u6d5a\ue69b\u6029", -2142765046), a.c(1784499189, "\u4bb3\u322d\ub8f2\u268b\uad4d\u2be9\u91bc\u1859"), a.d("\u994b\ue0c9\u6a1a\uf476\u7fb9\uf90c", 1554658804, 1363979512)};
    private static double ghh;
    private static double ghi;
    private static double ghj;
    private static /* synthetic */ int ghk;
    private static /* synthetic */ boolean ghl;

    private ghf() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfx kfx2 = Flow.getInstance().getModuleManager();
        switch (n) {
            case 1: {
                for (String string : ghg) {
                    ghf.ghq(kfx2, string, false);
                }
                ghf.ghw(minecraftClient, a.c(760693019, "\u416d\u38da\ub205\u2c7c\ua7a3\u2110\u9b48\u12b8\u8ca2\u0650\u8192\u7bf4\uf527\u6c83\ue6cd\u6023\uda7f"));
                ghf.ghw(minecraftClient, a.c(1471929188, "\udb1d\ua2b1\u2866\ub61f\u3d8d\ubb6f\u012a\u88ca\u16c1\u9c66\u1bb3\ue1c2\u6f15"));
                ghf.ghw(minecraftClient, a.d("\ucdb8\ub41b\u3ecc\ua0a8\u2b63\uaddf\u179b\u9e38$\u8a9a\u0d40\uf735\u79f1", -640066556, 596480454));
                ghf.ghw(minecraftClient, a.b("\uadd0\ud467\u5eb8\uc0c1\u4b01\ucdb7\u77fd\ufe05\u601f\ueaea\u6d32\u9761\u1994\u8028\u0a4a\u8c98\u36c6\ub901\u23ab\ua5fd\u2c0d\u5655\ud8a1\u4336\uc54e\u4f92\uf63e\u7879", 1565896107));
                ghh = Math.floor(minecraftClient.field_1724.method_23317()) + 0.5;
                ghi = Math.floor(minecraftClient.field_1724.method_23318());
                ghj = Math.floor(minecraftClient.field_1724.method_23321()) + 0.5;
                ghf.ghw(minecraftClient, ghf.ghp(a.b("\uf93f\u808a\u0a09\u9418\u1ffc\u991e\u2348\uaab2\u34f2\ube14\u3981\uc3f5\u4d29\ud487\u5e83\ud834\u627e\ueda4\u7708\uf10e\u78bf\u02fe\u8c5d\u179d\u91e1", 2038167890), ghh, ghi, ghj));
                minecraftClient.field_1690.field_1842 = false;
                izx.TARGET.enabled.set(false);
                break;
            }
            case 5: {
                ghf.ghw(minecraftClient, ghf.ghp(a.d("\uca7b\ub3c5\u3913\ua762\u2cf9\uaa4d\u105f\u99ea\u07b0\u8d40\u0ad7\uf0a3\u7e35\ue7c0\u6d96\ueb26\u512d\udef9\u440b\uc21e\u4bec\u31fc\ubf0b\u2497\ua2ec\u283a\u9182\u1fd5\u8533\u0371\u88c5\u7606\ufc07\u65ad\ue3f6\u695c", -681892628, 1845817045), -8, 0, 2, 8, 4, 20));
                ghf.ghw(minecraftClient, ghf.ghp(a.c(1488446, "\ub67e\ucfc0\u4516\udb67\u50fc\ud648\u6c5a\ue5ef\u7bb5\uf145\u76d2\u8ca6\u0230\u9bc5\u1193\u9723\u2d28\ua2fc\u380e\ube1b\u37e9\u4df9\uc30e\u5892\udee9\u543f\ued87\u63d0\uf936\u7f74\uf4c0\u0a03\u8002\u19ba\u9fee\u1544\uaa92\u20e8"), -7, 0, 9, 7, 3, 9));
                for (int i = 0; i < 30; ++i) {
                    int n2 = -6 + i % 10 * 4 / 3;
                    int n3 = 11 + i / 10 * 2;
                    ghf.ghw(minecraftClient, ghf.ghp(a.c(463908911, "\ub019\uc9ae\u4365\udd14\u56c1\ud071\u6a6c\ue3d0\u7d8b\uf73d\u70e5\u8a92\u0454\u9df6\u17a2\u9141\u2b40\ua4dd\u3e71\ub825\u31d2\u4b8e\uc53b\u5ee8\ud880\u5203\uebb5\u65ef\uff07\u7901\uf2f4\u0c20\u8664\u1f8a\u998e\u1379\uacab\u26d1\ua01d\u39fb\ub3e2\ucd48\u472e\uc0be\u5a47\ud43e\u6d9e\ue724\u6138\ufaa7\u74aa\u8e46\u07ea\u81ae\u1b48\u9504\u2ebd\ua86d\u224a\ubbfa\u3527\u4f7f\uc884\u4283\udc06\u55ab\uefae\u6964\ue313"), ghh + (double)n2, ghi, ghj + (double)n3));
                }
                ghf.gho(minecraftClient, a.c(1271669740, "\u238b\u5a36\ud0e3\u4e98\uc543\u43cc\uf9a3\u7044\uee0c\u64ba"), -3.0, 5.0, a.c(-1958119368, "\u7853\u01d7\u8b25\u157a\u9ea5\u1867\ua23f\u2b9d\ub58c\u3f42\ub8ab\u42c9\ucc01\u55ef\udfb7\u590a"));
                ghf.gho(minecraftClient, a.d("\uac11\ud5ac\u5f79\uc102\u4ad9\ucc56\u7639\uffde\u6196\ueb20", -1753739581, -774266187), -1.5, 6.0, a.d("\u06ae\u7f2a\uf5d8\u6b87\ue058\u669a\udcc2\u5560\ucb71\u41bf\uc656\u3c34\ub2fc\u2b12\ua14b\u27f7", -86581057, -2104760710));
                ghf.gho(minecraftClient, a.c(-998471120, "\u8a53\uf3f9\u7937\ue747\u6ca1\uea28\u5073\ud981\u47d7\ucd6e"), 3.0, 6.0, a.d("\u7730\u0eb4\u8446\u1a19\u91c6\u1704\uad5c\u24fe\ubaef\u3020\ub7ce\u4da4\uc366\u5ac2\ud08c\u567b\uec35\u63b0\uf962\u7f59\uf6a7\u8cfe\u021b\u9980\u1fe3\u9564\u2cec\ua29d", -1070391492, 1182885995));
                ghf.gho(minecraftClient, a.c(782400977, "\u7da2\u040b\u8edb\u10a0"), 1.5, 4.0, a.b("\uca4e\ub3ca\u3938\ua767\u2cb8\uaa7a\u1022\u9980\u0791\u8d5e\u0ab0\uf0da\u7e18\ue7bc\u6df2\ueb05\u514b\udece\u441c\uc227\u4bd9\u3180\ubf65\u24fe\ua29d\u281a\u9192\u1fe3", -190264791));
                ghf.gho(minecraftClient, a.d("\u1759\u6ee4\ue42f", 1921642464, 644675801), 0.0, 7.0, a.b("\uf9ce\u804a\u0ab8\u94e7\u1f38\u99fa\u23a2\uaa00\u3411\ubede\u3930\uc35a\u4d98\ud43c\u5e72\ud885\u62cb\ued4e\u779c\uf1a7\u7859\u0200\u8ce5\u177e\u911d\u1b9a\ua212\u2c63", 2031221161));
                ghf.gho(minecraftClient, a.c(-2147125373, "\u77fd\u0e53\u8485\u1af4\u912e\u1799\uadc8\u242e"), 5.0, 4.0, a.d("\ua39d\uda19\u50eb\uceb4\u456b\uc3a9\u79f1\uf053\u6e42\ue49c\u6379\u990e\u17de\u8e74\u0425\u82f7\u3897\ub74a\u2df1\uabff\u2215\u5841\ud692\u4d6e\ucb1c\u418d\uf83b\u7661\uece8\u6a84\ue12c\u1fe8\u95b2\u0c5e\u8a0b\u00bb\ubf38\u3528\ub391\u2a29\ua07e\uded9\u54c0\ud36d\u49ec\uc7a6\u7e55", -1260586558, 227498507));
                break;
            }
            case 60: {
                ghf.ghv(minecraftClient, 0.0f, 12.0f);
                ghf.ghx(minecraftClient, a.c(544767990, "\u7f92\u0621\u8cff\u12c1\u994b\u1fe6\ua5b8\u2c41\ub219"));
                ghf.ghq(kfx2, a.d("\u1b58\u62cb\ue815\u7643\ufd82\u7b30", -1257819768, -1941755237), true);
                break;
            }
            case 80: {
                ghf.ghx(minecraftClient, a.c(1088871888, "\uddb2\ua401\u2edf\ub0e1\u3b7e\ubdd9\u0789\u8e25\u1038\u9a93\u1d41\ue728\u69fa\uf04c\u7a14"));
                System.out.println(a.d("\u6650\u1fe3\u953d\u0b0e\u808d\u062d\ubc68\u359e\uab95\u2161\ua6b9\u5cd2\ud218\u4bb4\uc1ea\u4742\ufd4b\u7284\ue86f\u6e78\ue788\u9dd1\u1367\u88bf\u0ec1\u844e\u3de7", 1853002433, 1907422439) + ghf.ghu(a.d("\uf391\u8a2a\u00fa\u9e93\u151d\u93f0\u29b4\ua04e\u3e1b\ub4ab\u336f\uc942\u47fe\ude64\u542d\ud2c1\u6893\ue74f\u7dc3\ufbac", -1039141056, -153746269), a.d("\ue2da\u9b6c\u11b7\u8fc3\u041d\u82ad", -932461083, -1212078241)) + a.c(32471700, "\u7aa9\u0314\u8997\u17ff\u9c22\u1a9b\ua0c6\u2936\ub72d\u3ddd\uba1d\u4071\ucebc\u5716\udd4f\u5be0\ue1b5") + ghf.ghn(minecraftClient));
                ghf.ghs(kfx2.getByName(a.c(260534655, "\u7134\u08a7\u8279\u1c2f\u97ee\u115c")), a.c(548910206, "\ub437\ucda4\u477c\ud90c"), a.c(1885769971, "\u90b2\ue92e\u63ea"));
                break;
            }
            case 100: {
                ghf.ghx(minecraftClient, a.b("\u15cd\u6c7e\ue6a0\u789e\uf301\u75a6\ucff6\u465a\ud84a\u52f6\ud532", 1316951467));
                ghf.ghs(kfx2.getByName(a.c(-1592574368, "\u3e2b\u47b8\ucd66\u5330\ud8f1\u5e43")), a.d("\ufb14\u8287\u085f\u962f", -938554189, 188757998), a.d("\u472b\u3ea0\ub472\u2a1b\ua1c9\u277f\u9d27", -1698454477, 1470686032));
                ghf.ghr(kfx2.getByName(a.c(-1106186049, "\uf0f9\u8967\u03b8\u9dc1\u1607\u90a3\u2af6\ua313")), a.c(-2031568546, "\ub917\uc084\u4a5a\ud43a"), true);
                ghf.ghq(kfx2, a.b("\u9306\uea98\u6047\ufe3e\u75f8\uf35c\u4909\uc0ec", 213685056), true);
                break;
            }
            case 120: {
                ghf.ghx(minecraftClient, a.c(2093988516, "\ubac1\uc372\u49ac\ud792\u5c1c\udab8\u60ed\ue908"));
                ghf.ghr(kfx2.getByName(a.d("\u3f5a\u46d8\ucc0b\u5267\ud9a8\u5f1d", -1814249500, 1956479225)), a.b("\ue112\u9881\u125f\u8c3f", 1854136667), true);
                ghf.ghq(kfx2, a.c(-1835131614, "\u1d65\u64e7\uee34\u7058\ufb97\u7d22"), true);
                ghf.ghv(minecraftClient, 180.0f, 12.0f);
                break;
            }
            case 140: {
                ghf.ghv(minecraftClient, 180.0f, 12.0f);
                ghf.ghx(minecraftClient, a.b("\u0505\u7cb6\uf668\u6856\ue3cd\u656f\udf3c\u56d0\uc897\u4222", 646186338));
                break;
            }
            case 141: {
                for (String string : ghg) {
                    ghf.ghq(kfx2, string, false);
                }
                ghf.ghr(kfx2.getByName(a.b("\u3734\u4eaa\uc475\u5a0c\ud1ca\u576e\ued3b\u64de", 1568749426)), a.b("\u4631\u3fa2\ub57c\u2b1c", -1432467848), false);
                ghf.ghr(kfx2.getByName(a.d("\u4ab2\u3330\ub9e3\u278f\uac40\u2af5", 187039236, 899396849)), a.b("\ud66a\uaff9\u2527\ubb47", 209704483), false);
                ghf.ghw(minecraftClient, a.b("\u82fb\ufb48\u719e\uefef\u6474\ue2a5\u58d3\ud11c\u4f6c\uc5d0\u420a\ub86e\u36e1\uaf4c\u254e\ua3a3\u19e1\u9628\u0c87\u8ac1\u0319", -1169653115));
                ghf.ghw(minecraftClient, ghf.ghp(a.c(-359246212, "\u5610\u2fa5\ua526\u3b37\ub0d3\u3631\u8c67\u059d\u9bdd\u113b\u96ae\u6cda\ue206\u7ba8\uf1ac\u771b\ucd51\u428b\ud827\u5e21\ud790\uadd1\u2372\ub8b3"), ghh, ghi, ghj - 6.0));
                ghf.ghw(minecraftClient, ghf.ghp(a.b("\u02a4\u7b1a\uf1cc\u6fbd\ue426\u6292\ud880\u5135\ucf6f\u459f\uc208\u387c\ub6ea\u2f1f\ua549\u23f9\u99f2\u1626\u8cd4\u0ac1\u8333\uf923\u77d4\uec48\u6a33\ue0e5\u595d\ud70a\u4dec\ucbae\u401a\ubed9\u34d8\uad60\u2b34\ua19e\u1e48\u9432\u12db\u8b46\u0106\u7ffa\uf5aa", 186319593), -3, 0, -1, 3, 0, 6));
                izx.TARGET.enabled.set(true);
                break;
            }
            default: {
                if (n <= 141) break;
                return ghf.ghm(minecraftClient, n - 141);
            }
        }
        return false;
    }

    private static boolean ghm(MinecraftClient minecraftClient, int n) {
        String string = PetFollowTest.step(minecraftClient, 0.05f);
        if (n < 120) {
            ghf.ghv(minecraftClient, 0.0f, 0.0f);
        }
        switch (n) {
            case 20: {
                minecraftClient.field_1690.field_1894.method_23481(true);
                break;
            }
            case 60: {
                minecraftClient.field_1690.field_1894.method_23481(false);
                break;
            }
            case 100: {
                System.out.println(a.b("\ue5ee\u9c5d\u1683\u88b0\u0333\u8593\u3fd6\ub620\u282b\ua2ca\u250c\udf6c\u51f5\uc85e\u4259\uc4a9\u7ee1\uf12c\u6b98\uedce\u6430\u1e26\u90dc\u0b0a\u8d3b\u07ba\ube15\u3049\uaabc\u2ceb", -90446435));
                break;
            }
        }
        if (n >= 100 && n < 140) {
            ghf.ghv(minecraftClient, (float)(n - 100) * 9.0f, 0.0f);
        }
        if (n == 1 || n == 19 || n % 10 == 0 && n <= 160) {
            System.out.println(a.b("\u013e\u788d\uf253\u6c60\ue7e3\u6143\udb06\u52f0\uccfb\u461a\uc1dc\u3bbc\ub53f\u2cda", 151191901) + n + a.c(1881217556, "\u1a2c\u6387") + string + a.c(-1679736866, "\u3ff9\u4644\uccc7\u52aa\ud970\u5fd9\ue596\u6c70\uf27d\u7895\uff1f") + String.format(Locale.ROOT, a.b("\uf79a\u8e20\u04ef\u9aca", 2025256891), minecraftClient.field_1724.method_23318()));
        }
        if (n >= 170) {
            System.out.println(a.c(-744468686, "\u4f52\u36e1\ubc3f\u220c\ua98f\u2f2f\u956a\u1c9c\u8297\u0862\u8fba\u75ca\ufb16"));
            return true;
        }
        return false;
    }

    private static int ghn(MinecraftClient minecraftClient) {
        rhs rhs2 = rhs.get();
        int n = 0;
        for (Entity entity : minecraftClient.field_1687.method_18112()) {
            if (!rhs2.picks(entity)) continue;
            ++n;
        }
        return n;
    }

    private static void gho(MinecraftClient minecraftClient, String string, double d, double d2, String string2) {
        ghf.ghw(minecraftClient, ghf.ghp(a.d("\u106f\u69d8\ue313\u7d62\uf6b7\u7007\uca1a\u43a6\uddfd\u574b\ud093\u2ae4\ua422\u3d80\ub7d4\u3137\u8b36\u04f8\u9e1d\u181f\u91ed\uebb7\u651b\ufe9d\u78a4\uf270\u4bc8\uc586\u5f26\ud931\u5287\uac5d\u260d\ubfab\u39be\ub30a\u0c8b", 2120224008, -2130698959), string, ghh + d, ghi, ghj + d2, string2));
    }

    private static String ghp(String string, Object ... objectArray) {
        Object[] objectArray2 = (Object[])objectArray.clone();
        if (string.startsWith(a.d("\u825a\ufbe4\u7132\uef43", 666902432, 703896984))) {
            int n = (int)Math.floor(ghh);
            int n2 = (int)ghi;
            int n3 = (int)Math.floor(ghj);
            for (int i = 0; i < objectArray2.length; ++i) {
                int n4 = i % 3 == 0 ? n : (i % 3 == 1 ? n2 : n3);
                objectArray2[i] = n4 + (Integer)objectArray2[i];
            }
        }
        return String.format(Locale.ROOT, string, objectArray2);
    }

    private static void ghq(kfx kfx2, String string, boolean bl) {
        kfx2.getByName(string).setEnabled(bl);
    }

    private static void ghr(kfe kfe2, String string, boolean bl) {
        ((vkl)ghf.ght(kfe2, string)).set(bl);
    }

    private static void ghs(kfe kfe2, String string, String string2) {
        ((vlv)ghf.ght(kfe2, string)).set(string2);
    }

    private static vmo ght(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.c(-1353162658, "\u6076\u198f\u9355\u0d36\u86b2M\uba1f\u33a1") + string);
    }

    private static boolean ghu(String string, String string2) {
        try {
            Field field = Class.forName(string).getDeclaredField(string2);
            field.setAccessible(true);
            return field.getBoolean(null);
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static void ghv(MinecraftClient minecraftClient, float f, float f2) {
        minecraftClient.field_1724.method_36456(f);
        minecraftClient.field_1724.method_36457(f2);
        minecraftClient.field_1724.field_5982 = f;
        minecraftClient.field_1724.field_6004 = f2;
        minecraftClient.field_1724.method_5636(f);
        minecraftClient.field_1724.field_6220 = f;
        minecraftClient.field_1724.method_5847(f);
    }

    private static void ghw(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static void ghx(MinecraftClient minecraftClient, String string) {
        System.out.println(a.b("\ue237\u9b90\u114a\u8f31\u04a0\u8245\u3807\ub1e0\u2fb8\ua55d", -1822563762) + string + a.c(-1258235870, "\ud801\ua1d0\u2b63") + minecraftClient.method_47599() + a.c(1858616429, "\u3c49\u45be\ucf7b\u5109"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)(a.c(-1514074084, "\u107c\u69c7\ue317\u7d7e\uf6ec\u7042") + string + a.b("\ud514\uacfb\u2636\ub84e", 1915606334)), (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static /* synthetic */ int tt(int n, int n2) {
        return n ^ n2 ^ 0x41C69DF5;
    }

    private static /* synthetic */ int tu(int n, int n2) {
        return ghf.tt(n, n2) * n2;
    }

    private static /* synthetic */ int tv(int n, int n2) {
        return ghf.tu(n, n2) + n;
    }
}

