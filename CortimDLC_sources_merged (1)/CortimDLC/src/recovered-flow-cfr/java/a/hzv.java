/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package a;

import a.hhf;
import a.hzq;
import a.iov;
import a.isv;
import a.izx;
import a.jgn;
import a.kfe;
import a.ucg;
import a.vkl;
import a.vlq;
import a.vmo;
import a.vzz;
import a.wap;
import a.wlk;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import net.minecraft.client.MinecraftClient;

public final class hzv {
    public static final List<hzq> ALL = List.of(new hzq(a.b("\ude50\ua7fc\u2d3e", 1503977019), a.d("\u9ca5\ue52f\u6ffb\uf192\u7a12\ufccb\u4685\ucf65", 2138001309, 432853859), () -> hzv.hzz(a.b("\ub88b\uc127\u4be5", 2119547072), izx.ENABLED)), new hzq(a.c(1349440162, "\ud2dc\uab7b\u21b0\ubfc8\u3400\ub2b7\u08e3\u8108\u1f50"), a.c(-288575655, "\uaf04\ud68e\u5c5a\uc233\u49b3\ucf55\u7510\ufcf9\u62af\ue801\u6fd4\u95a2\u1b6f\u82d9"), () -> hzv.hzz(wap.t(a.b("\u5cf7\u2570\uafbb\u31c3\uba0b\u3cbc\u86e8\u0f03\u915b", 1916558505)), wlk.ENABLED)), new hzq(a.c(-501256206, "\u6f88\u162f\u9ce4\u029c\u8954\u0fe3\ub5b7\u3c5c\ua259\u28ae\uaf70\u5516\udbd6"), a.b("\uffb8\u863f\u0cf4\u928c\u1944\u9ff3\u25a7\uac4c\u3247\ub8be\u3f60\uc506\u4bc6", -457703454), hzv::hzy), new hzq(a.c(2058614031, "\uf570\u8cdd\u0603\u987a\u13a5\u955f\u2f4e\ua6ba\u38eb\ub255\u359a"), a.d("\uc3c5\uba51\u308c\uaef2\u2539\ua3dc\u1980\u907e\u0e65\u84d1\u0311\uf979\u77e5\uee00\u644f\ue2b3\u58f4\ud72d", -262292331, 1739947790), () -> {
        iov.toggleLight();
        hzv.iaa(wap.t(a.c(-792170135, "\u7138\u08b5\u826b\u1c12\u97cd")) + a.b("\uf194\u8825", -1447431754) + iov.shownName(iov.presetName()));
    }), new hzq(a.d("\u7cc5\u0568\u8fb6\u11cf\u9a10\u1cea\ua6f9\u2f03\ub141\u3bfc", -2116819124, -1515217929), a.d("\u8d69\uf4f3\u7e3d\ue040\u6bc3\ued26\u5769\ude95\u40c2\uca7b", 721512737, -1570184180), () -> {
        iov.cycle(1);
        hzv.iaa(wap.t(a.d("\u3d35\u44b8\uce66\u501f\udbc0", -438028705, -1870460101)) + a.b("\u5e57\u27e6", -1620091275) + iov.shownName(iov.presetName()));
    }), new hzq(a.b("\u5f47\u26e0\uac3e\u324f\ub984\u3f24\u8566\u0c82\u92ca\u1827\u9fb4\u65ce\ueb04\u72b9", 998268734), a.d("\u4f5c\u36c6\ubc08\u2275\ua9f6\u2f10\u9555\u1ca9\u82f6\u085b\u8f99\u75f9\ufb3b\u629d", -1863417340, 1778896152), () -> hzv.iaa(wap.t(a.b("\u3d64\u44e3\uce3d\u504c\udb87\u5d27\ue765\u6e81\uf0c9", 551632186)) + a.d("\ue7ee\u9e5f", -473336638, -617049330) + isv.next())), new hzq(a.d("\u46f8\u3f51\ub584\u2bef\ua032\u26ce\u9cc7\u152d\u8b7a\u01cb\u8613\u7c6b", -1417798605, -575186262), a.c(1312762163, "\u2971\u50fc\uda22\u444b\ucfc5\u497b\uf327\u7a86\ue4c8\u6e6d\ue9b8\u13df\u9d4d\u04b1\u8efa\u080d\ub258\u3d83"), () -> jgn.command(a.d("\ufc04\u85ae\u0f75\u9104\u1ad8\u9c60", 2004529605, -301445709))), new hzq(a.b("\u08c0\u7169\ufbbc\u65d7\uee0a\u68f6\ud2e5\u5b1f\uc55d\u4fe0", -253622105), a.d("\u7556\u0ccc\u8602\u187f\u93fc\u1519\uaf4c\u26ae\ub8f3\u324a", -1700900214, -1128126568), () -> jgn.command(a.c(402363329, "\u93ab\uea11\u60df\ufea2"))), new hzq(a.d("\ued40\u94e5\u1e2d\u8050\u0b8c\u8d37", 659191548, 370318300), a.c(38960229, "\u7c37\u05a3\u8f70\u1145\u9a9d\u1c23\ua622\u2fc4\ub193\u3b20\ubcea\u4688\uc81a\u51ed\udbaa\u5d40\ue703\u68d9\uf260"), vzz.mouse(2), hhf::toggleAimed), new hzq(a.d("\u9aac\ue30c\u69cc\uf7bb\u7c61\ufa87\u4097\uc96a\u5726\udd8e", -1785227844, -555348118), a.b("\u7ce2\u0562\u8fa2\u11d5\u9a0f\u1ce7\ua6f9\u2f04\ub148\u3be0", 1710455992), vzz.mouse(3), ucg::markKey));
    private static /* synthetic */ boolean hzw;
    private static /* synthetic */ boolean hzx;

    static hzq friendKey() {
        for (hzq hzq2 : ALL) {
            if (!hzq2.id.equals(a.c(-1875024147, "\u668d\u1f28\u95e0\u0b9d\u8041\u06fa"))) continue;
            return hzq2;
        }
        throw new IllegalStateException(a.b("\ue0f8\u9948\u13d4\u8de3\u0620\u808a\u3ad5\ub32f\u2d7a\ua78f\u2014\uda62\u54ae\ucd00\u475d\uc1b0", 1096278150));
    }

    static hzq partyMarkKey() {
        for (hzq hzq2 : ALL) {
            if (!hzq2.id.equals(a.b("\u0000\u79a0\uf360\u6d17\ue6cd\u602b\uda3b\u53c6\ucd8a\u4722", -22085510))) continue;
            return hzq2;
        }
        throw new IllegalStateException(a.d("\u55cd\u2c7d\ua6e1\u38c0\ub306\u35a4\u8ff1\u060d\u980b\u12f7\u9528\u6f4a\ue184\u787e\uf265\u7493\ucec7\u4109\udbb4\u5df9", -1231193829, -1296814932));
    }

    private hzv() {
    }

    public static void run(int n) {
        for (hzq hzq2 : ALL) {
            if (hzq2.key != n) continue;
            try {
                hzq2.hzr.run();
            }
            catch (RuntimeException runtimeException) {
                System.out.println(a.c(-1410827792, "\u799f)\u8ae1\u148f\u9f56\u19fb\ua3f1") + hzq2.name + a.b("\u7df4\u0403\u8ed7\u10ae\u9b7c\u1dc4\ua796\u2e39\ub07c", -2019328547) + runtimeException);
            }
        }
    }

    static List<String> boundTo(int n, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (n == -1) {
            return arrayList;
        }
        for (kfe object : Flow.getInstance().getModuleManager().getModules()) {
            if (object.getKey() == n && !object.getName().equals(string) && !object.getDisplayName().equals(string)) {
                arrayList.add(object.getDisplayName());
            }
            for (vmo vmo2 : object.getSettings()) {
                vlq vlq2;
                if (!(vmo2 instanceof vlq) || (vlq2 = (vlq)vmo2).get() != n || vlq2.getName().equals(string)) continue;
                arrayList.add(object.getDisplayName() + a.d("\u1994", -1304769950, -1483615273) + wap.t(vlq2.getName()));
            }
        }
        for (hzq hzq2 : ALL) {
            if (hzq2.key != n || hzq2.name.equals(string)) continue;
            arrayList.add(wap.t(hzq2.name));
        }
        return arrayList;
    }

    private static void hzy() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null || minecraftClient.world == null) {
            return;
        }
        int n = wlk.inWorld().size();
        String string = wap.s(a.d("\u5d96\u2411\uaeda\u30a2\ubb6a\u3ddd\u8789\u0e62\u9069", -1021880999, -672069487), a.c(-1194970411, "\u36cf\u4f57\uc5f3\u5bfa\ud027\u5286")) + (n + 1);
        wlk.add(string, minecraftClient.player.getBlockX(), minecraftClient.player.getBlockY(), minecraftClient.player.getBlockZ(), wlk.COLORS[n % wlk.COLORS.length]);
        hzv.iaa(wap.s(a.d("\ub907\uc093\u4a40\ud430\u5fe6\ud913", -1115218932, -1284397748), a.b("\u3640\u4fdb\uc507\u5b77\ud0a2\u561a\uec47\u65be\ufbec\u754d", -1412222370)) + string + a.b("\u0feb\u765a", -1506013239) + minecraftClient.player.getBlockX() + a.d("\ud588", 1863008517, 1501009068) + minecraftClient.player.getBlockY() + a.d("\u6df1", 121919909, -471976843) + minecraftClient.player.getBlockZ());
    }

    private static void hzz(String string, vkl vkl2) {
        vkl2.toggle();
        hzv.iaa(string + a.c(1606273036, "\uc82e\ub19f") + wap.value(vkl2.get() ? a.c(-1163236512, "\u6b2d\u12bd") : a.d("\ubf53\uc6cb\u4c18", 1393738908, -1984201853)).toLowerCase(Locale.ROOT));
    }

    private static void iaa(String string) {
        izx.notify(a.c(-2141799571, "\ubb2f\uc2b4\u4864\ud60d"), string);
    }

    static void load(Properties properties) {
        for (hzq hzq2 : ALL) {
            try {
                hzq2.key = Integer.parseInt(properties.getProperty(a.b("\u6c3c\u158a\u9f42\u012c\u8af5\u0c58\ub65c", -151753645) + hzq2.id, String.valueOf(hzq2.hzs)).trim());
            }
            catch (NumberFormatException numberFormatException) {
                hzq2.key = hzq2.hzs;
            }
        }
    }

    static void save(Properties properties) {
        for (hzq hzq2 : ALL) {
            properties.setProperty(a.c(-1842833971, "\u95a2\uec14\u66dc\uf8b2\u736b\uf5c6\u4fc2") + hzq2.id, String.valueOf(hzq2.key));
        }
    }

    private static /* synthetic */ int aen(int n, int n2) {
        return n - n2 + -1863657296;
    }
}

