/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.kfe;
import a.riv;
import a.urc;
import a.vlv;
import a.vmc;
import a.vmo;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Locale;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.ScreenshotRecorder;

final class ghy {
    private static float ghz;
    private static float gia;
    private static double gib;
    private static int gic;
    private static int gid;
    private static boolean gie;
    private static boolean gif;
    private static float gig;
    private static float gih;
    private static float gii;
    private static float gij;
    private static long gik;
    private static final float gil = 0.15f;
    private static final StringBuilder gim;
    private static /* synthetic */ int gin;
    private static /* synthetic */ boolean gio;

    private ghy() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(1070381688, "\uba3f\uc3ac\u4964\ud708\u5cd9\uda69\u6016\ue9c9\u778f\ufd39"));
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (!gie) {
            gie = true;
            WorldRenderEvents.END_MAIN.register(worldRenderContext -> ghy.giq(MinecraftClient.method_1551()));
        }
        switch (n) {
            case 1: {
                ghy.giu(minecraftClient, a.c(1014420970, "\ud59c\uac2b\u26f4\ub88d\u3352\ub5e1\u0fb9\u8649\u1853\u92a1\u1563\uef05\u61d6\uf872\u723c\uf4d2\u4e8e"));
                ghy.giu(minecraftClient, a.b("\u9e7f\ue7d3\u6d04\uf37d\u78ef\ufe0d\u4448\ucda8\u53a3\ud904\u5ed1\ua4a0\u2a77", -1978294778));
                ghy.giu(minecraftClient, a.c(-1433232252, "\u9cfe\ue55d\u6f8a\uf1ee\u7a25\ufc99\u46dd\ucf7e\u5162\udbdc\u5c06\ua673\u28b7"));
                ghy.giu(minecraftClient, a.d("\uaa33\ud386\u5905\uc714\u4cf0\uca12\u7051\uf9b0\u67b1\ued5e\u6a9d", -1514894822, -121298858));
                ghy.giu(minecraftClient, a.b("\u0ed4\u7778\ufdba\u63c3\ue859\u6eba\ud4fe\u5d1a\uc359\u49e5\uce34\u3443\ubad1\u2325\ua97d\u2f96\u95c4\u1a08\u80b6\u06be\u8f29\uf54b\u7bab\ue02d\u6640\uec95\u5537\udb79\u418f\uc79e\u4c6e\ub2b3\u38f4\ua102\u2757\uadef\u1237\u984c\u1edb\u873d\u0d7c\u7390\uf9df\u7e26\ue4bc\u6ac9\ud31d\u59a7\udfee\u442e\uca4e\u3098\ub93d\u3f22\ua58f\u2bd3\u9064\u16b9\u9cc8\u0518\u8ba5\uf1cf\u7610\ufc45\u6292\ueb3e\u517b", 748293886));
                break;
            }
            case 3: {
                ghy.giu(minecraftClient, a.d("\uc0bb\ub905\u33d3\uada2\u2639\ua085\u1ac8\u933a\u0d75\u879a\u0017\ufa6b\u74a2\ued10\u6753\ue1b1\u5bfd\ud43c\u4ed1\uc8c6\u4129\u3b6b\ub5db\u2e1a\ua828\u22fd\u9b49\u1513\u8fe2\u09a2\u8202\u7cd4\uf689\u6f36\ue93e\u6387\udc4b", -1923836034, -237021306));
                break;
            }
            case 4: {
                ghy.giu(minecraftClient, a.d("\u53e4\u2a5a\ua08c\u3efd\ub566\u33da\u8997e\u9e2a\u14c5\u9345\u6928\ue7ee\u7e52\uf41f\u72ed\uc8b2\u4770\uddc0\u5b81\ud228\ua82a\u2685\ubd45\u3b29\ub1fb\u0858\u8644\u1cb7\u9ae1\u1159\uef8e\u65d0\ufc32\u7a66\uf0c5\u4f5c\uc570\u43b6\uda14\u5059\u2ea8\ua4d7\u235b\ub982\u37f0\u8e2f\u0496", -683152936, 848411242));
                break;
            }
            case 5: {
                for (int i = -14; i <= 14; ++i) {
                    String string = (i & 1) == 0 ? a.b("\u26e4\u5f5b\ud585\u4bf6\uc029\u46ac\ufcc3\u753e\ueb60\u61dc\ue61e\u1c78\u92be\u0b1e", 1384982152) : a.b("\uced0\ub77e\u3dac\ua3c0\u2806\uae8d\u14e2\u9d1f\u0341\u89fd\u0e3f\uf459\u7a9f\ue33f", 1136119465);
                    ghy.giu(minecraftClient, a.c(-685307199, "\u0aad\u7313\uf9c5\u67b4\uec2f\u6a8f\ud0df\u593c\uc73d\u4dd2") + i + a.b("\u7cdd\u057d\u8fad\u11ce\u9a47\u1cbf\ua6fb", -615351046) + i + a.c(-1475593712, "\u3a3b\u43c7\uc910\u5766\udcba\u5a0d\ue04f\u69ad\uf7f5\u7d56\ufacb") + string);
                }
                break;
            }
            case 6: {
                for (int i = 0; i <= 7; ++i) {
                    String string = (i & 1) == 0 ? a.b("\u7394\u0a38\u80f8\u1e86\u9558\u13eb\ua982\u204f\ube1c\u34ac\ub372\u4912\uc7d2\u5e72\ud430", 747271156) : a.c(1445271974, "\u19c9\u6076\ueabc\u74dd\uff30\u79bd\uc3e2\u4a12\ud440\u5ee0\ud924\u2344\uad82");
                    ghy.giu(minecraftClient, a.c(-1546215721, "\u9ebb\ue705\u6dd3\uf3a2\u7839\ufe85\u44ca\ucd3a\u5375\ud99a") + i + a.c(-1749663166, "\u426b\u3bd7\ub118\u2f6a\ua4af\u220f\u985d\u11bc\u8fbd") + i + a.b("\u87c1\ufe7d\u74b2\ueac0\u6105\ue7f9\u5dae\ud458\u4a0c\uc0bb\u4779\ubd1b\u33cb\uaa68\u2075", -1944418322) + string);
                }
                break;
            }
            case 7: {
                ghy.giu(minecraftClient, a.b("\uc4fe\ubd40\u3796\ua9e7\u227c\ua4db\u1e9e\u9731\u0930\u8397\u0452\ufe35\u70f4\ue91b\u6303\ue5e7\u5fbe\ud079\u4a87\uccd2\u4522\u3f78\ub1cd\u2a0d\uac61\u26b7\u9f16\u1109\u8bb5\u0de0\u8647\u7885\uf2cc\u6b33\ued45\u67db\ud815\u5261\ud4b2\u4d0e\uc742", -1558199119));
                ghy.giu(minecraftClient, a.d("\u9ae5\ue35b\u698d\uf7fc\u7c67\ufadb\u4093\uc974\u5775\udd9a\u5a5e\ua038\u2ee2\ub748\u3d0d\ubba2\u01a7\u8e62\u14c6\u9280\u1b3a\u616f\uefdb\u7401\uf278\u78b8\uc118\u4f4e\ud5ab\u53b4\ud85a\u2683\uaccf\u3536\ub35e\u39d2\u860b\u0c79\u8aa6\u131f", 1387115156, 334178367));
                ghy.giu(minecraftClient, a.b("\u2066\u59d8\ud30e\u4d7f\uc6e4\u4042\ufa06\u73a9\ueda8\u6714\ue0df\u1abb\u947b\u0ddd\u87d0\u016c\ubb30\u34ec\uae47\u2803\ua1b9\udbec\u5558\uce82\u48fb\uc23b\u7b9b\uf5cd\u6f28\ue937\u62cc\u9c0a\u1644\u8f8e\u09e1\u835c\u3c8a\ub6f6\u3034\ua992\u23dc\u5d3c", 648093738));
                ghy.giu(minecraftClient, a.d("\u22d0\u5b6e\ud1b8\u4fc9\uc452\u42ee\uf8a8\u7141\uef40\u65af\ue271\u1819\u96da\u0f66\u8520\u03c9\ub9d8\u3641\uace4\u2ab8\ua356\ud913\u57ed\ucc38\u4a40\uc09a\u792f\uf76f\u6d8b\uebdd\u607c\u9ee3\u14f9\u8d06\u0b5f\u81da\u3e3e\ub44c\u3297", 1987830775, 1332986214));
                break;
            }
            case 40: {
                kfe2.setEnabled(true);
                urc.timing(true);
                ghy.gir(clientPlayerEntity, -90.0f, 0.0f);
                break;
            }
            case 60: {
                urc.gpuMillis();
                ghy.git(minecraftClient, a.d("\uf539\u8c8f\u0641\u9835\u13e2", -996438597, -1145865996));
                break;
            }
            case 62: {
                urc.gpuMillis();
                break;
            }
            case 65: {
                System.out.println(a.c(-726881534, "\uab7e\ud2cd\u5805\uc669\u4db8\ucb08\u7115\uf8b7\u66ef\uec43\u6b95\u91e4\u1f7f\u8689\u0ccd\u8a39\u3023") + ghy.giv(urc.gpuMillis()) + a.b("\ue7f6\u9e0a\u14c7\u8ae5\u013a\u87d3\u3d91\ub472\u2a2d\ua0cf\u274f\udd26\u53f3\uca5b\u4008\uc6ec\u7ca2\uf33e", 195553220));
                break;
            }
        }
        ghy.gip(minecraftClient, n, 70, 110, 6.0f, 0.0f, a.c(-295454181, "\uba67\uc3d7\u4903\ud76e\u5cfa\uda57\u6007\ue9f4"));
        ghy.gip(minecraftClient, n, 120, 160, 12.0f, 0.0f, a.c(483513023, "\ud2c3\uab73\u21a7\ubfca\u345e\ub2f0\u08a5\u8150"));
        ghy.gip(minecraftClient, n, 170, 205, 36.0f, 0.0f, a.d("\u1851\u61ea\ueb3c\u7547\ufe98\u786f\uc226\u4bd2\ud58f", 947603969, -1367322049));
        if (n == 215) {
            ((vmc)ghy.gis(kfe2, a.c(-1575486476, "\uffd1\u8679\u0ca9\u92d3"))).set(1.0);
        }
        ghy.gip(minecraftClient, n, 220, 260, 12.0f, 0.0f, a.c(940598438, "\u64dd\u1d6d\u97b9\u09d4\u8240\u04ee\ubebb\u374e\ua90c\u23e3\ua437\u5e40\ud08a\u493a\uc360"));
        if (n == 265) {
            ((vmc)ghy.gis(kfe2, a.b("\u4299\u3b31\ub1e1\u2f9b", -1934211396))).set(0.5);
            ghy.gir(clientPlayerEntity, 180.0f, -40.0f);
        }
        ghy.gip(minecraftClient, n, 270, 286, 0.0f, 5.0f, a.c(1256181356, "\uce15\ub7bd\u3d73\ua315\u28c9\uae3d\u1472\u9d82\u03dd"));
        if (n == 295) {
            ghy.giu(minecraftClient, a.c(-531684243, "\u2414\u5da1\ud722\u4933\uc2d7\u4435\ufe6b\u7786\ue9da\u6379\ue4f4\u1edb\u901c"));
            ghy.gir(clientPlayerEntity, -90.0f, 8.0f);
        }
        if (n == 300) {
            minecraftClient.field_1690.field_1894.method_23481(true);
            minecraftClient.field_1690.field_1867.method_23481(true);
            urc.gpuMillis();
        }
        if (n == 330) {
            System.out.println(a.b("\u9ebf\ue70c\u6dc4\uf3a8\u7879\ufec9\u44d4\ucd72\u533b\ud987\u5e53\ua469\u2af9\ub35f\u3909\ubfad", 138911426) + ghy.giv(urc.gpuMillis()) + a.b("\u8ef3\uf70f\u7dc2\ue3ec\u6837\ueed5\u5485\udd61\u433e\uc98e\u4e19", 503484120) + ghy.giv(clientPlayerEntity.method_18798().method_37267() * 20.0) + a.b("\u130f\u6afc\ue062\u7e4f", -1151266005));
            ghy.git(minecraftClient, a.b("\u62bf\u1b18\u91c6\u0fb0", 52912844));
        }
        if (n == 332) {
            minecraftClient.field_1690.field_1894.method_23481(false);
            minecraftClient.field_1690.field_1867.method_23481(false);
            ghy.giu(minecraftClient, a.b("\u3301\u4ab4\uc037\u5e26\ud5c2\u5320\ue963\u6082\ufe83\u746c\uf3af", 817771390));
        }
        if (n == 338) {
            ((vlv)ghy.gis(kfe2, a.c(-748769457, "\uab5d\ud2c6\u5862\uc661\u4dc2\ucb70\u7153\uf8ae"))).set(a.b("\uf8e3\u814a\u0bee\u9591\u1e44\u9885", 1659763910));
        }
        ghy.gip(minecraftClient, n, 340, 370, 12.0f, 0.0f, a.b("\u3556\u4cfe\uc635\u5842\ud386\u557b\uef37\u66c0\uf89b", -1443482326));
        if (n == 375) {
            ((vlv)ghy.gis(kfe2, a.d("\ud278\uabe3\u2147\ubf44\u34e7\ub255\u0876\u818b", -1250633046, -483849024))).set(a.b("\uba73\uc3e7\u493b\ud747\u5c94\uda2e", -1878933912));
        }
        ghy.gip(minecraftClient, n, 378, 408, 12.0f, 0.0f, a.b("\ucfca\ub678\u3cb3\ua298\u2950\uafe7\u15b0", 1320472481));
        if (n == 412) {
            ((vlv)ghy.gis(kfe2, a.d("\u61e5\u187e\u92da\u0cd9\u877a\u01c8\ubbeb\u3216", -2052287137, 1525936296))).set(a.d("\u99ae\ue046\u6a9f\uf491\u7f42\uf9f7\u43af", -1757604428, -643266545));
            kfe2.setEnabled(false);
        }
        ghy.gip(minecraftClient, n, 415, 445, 12.0f, 0.0f, a.c(1657264279, "\ud8ff\ua147\u2b94\ub5ae\u3e66\ub8d1\u0286"));
        if (n == 450) {
            urc.timing(false);
            return true;
        }
        return false;
    }

    private static void gip(MinecraftClient minecraftClient, int n, int n2, int n3, float f, float f2, String string) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (n == n2) {
            gig = f == 0.0f ? clientPlayerEntity.method_36454() : -90.0f - f * (float)(n3 - n2);
            gih = f2 == 0.0f ? 0.0f : clientPlayerEntity.method_36455();
            gii = f * 20.0f;
            gij = f2 * 20.0f;
            gik = System.nanoTime();
            ghy.gir(clientPlayerEntity, gig, gih);
            ghz = Float.MAX_VALUE;
            gia = 0.0f;
            gib = 0.0;
            gic = 0;
            urc.gpuMillis();
            gim.setLength(0);
            gif = true;
        } else if (n > n2 && n <= n3) {
            if (n > n2 + 12) {
                float f3 = riv.turnSpeed();
                ghz = Math.min(ghz, f3);
                gia = Math.max(gia, f3);
                gib += (double)f3;
                ++gic;
            }
            if (n == n3) {
                System.out.println(a.b("\ue170\u98c3\u120b\u8c67\u07b6\u8106\u3b1b", -1337532134) + string + a.b("\u043f\u7dc9\uf70d\u6979\ue2fb", 1812005914) + ghy.giv(urc.gpuMillis()) + a.b("\ua698\udf64\u55a9\ucb87\u405c\uc6af\u7cf2\uf51a\u6b42\ue1a1\u6621\u9c53\u1291\u8b20\u0172\u87c7", 1548592808) + ghy.giv(ghz) + a.c(-1311789812, "\uad20\ud491") + ghy.giv(gia) + a.d("\uae33\ud7c3\u5d07\uc367\u48f7", -1268359498, 2046750880) + ghy.giv(gib / (double)Math.max(1, gic)) + a.b("\u0ca5\u7550\uff82\u61f1\uea6e\u6c83\ud683\u5f7a\uc16e\u4bdd\ucc02\u367b\ub8bb\u2119\uab0b", -1353577334) + ghy.giv(Math.hypot(f, f2) * 20.0) + a.d("\u354f", -1768537696, -53119801));
                ghy.git(minecraftClient, string);
                gif = false;
                try {
                    Files.writeString(minecraftClient.field_1697.toPath().resolve(a.c(-1896587730, "\u5e45\u27fe\uad2e\u3347\ub8d5\u3e7b\u8468\u0d9b\u93df\u1973\u9ea6\u64d6\uea42") + string + a.c(-596126777, "\ud3ed\uaa11\u20d2\ubea6")), (CharSequence)gim, new OpenOption[0]);
                }
                catch (IOException iOException) {
                    System.out.println(a.d("\u8af5\uf346\u798e\ue7e2\u6c33\uea83\u509e\ud92c\u4763\ucdd7\u4a52\ub065\u3eb5\ua70c\u2d5a\uaba2\u11ec\u9e63\u04ca", 458334318, 764619493) + iOException);
                }
            }
        }
    }

    private static void giq(MinecraftClient minecraftClient) {
        if (!gif || minecraftClient.field_1724 == null) {
            return;
        }
        Camera camera = minecraftClient.field_1773.method_19418();
        long l = System.nanoTime();
        gim.append(l).append(',').append(camera.method_19330()).append(',').append(camera.method_19329()).append(',').append(riv.turnSpeed()).append('\n');
        float f = (float)(l - gik) / 1.0E9f;
        float f2 = gig + (float)Math.floor(gii * f / 0.15f) * 0.15f;
        float f3 = gih + (float)Math.floor(gij * f / 0.15f) * 0.15f;
        ghy.gir(minecraftClient.field_1724, f2, f3);
    }

    private static void gir(ClientPlayerEntity clientPlayerEntity, float f, float f2) {
        clientPlayerEntity.method_36456(f);
        clientPlayerEntity.method_36457(f2);
        clientPlayerEntity.field_5982 = f;
        clientPlayerEntity.field_6004 = f2;
    }

    private static vmo gis(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(a.c(-33051776, "\uabe5\ud255\u58c9\uc6eb\u4d2a\ucb8a\u71d9\uf835\u666d\uecd5\u6b41") + string);
    }

    private static void git(MinecraftClient minecraftClient, String string) {
        String string2 = a.b("\ub97a\uc0c1\u4a11\ud478\u5fea\ud944\u6357\ueaa4\u74e0\ufe4c\u7999\u83e9\u0d7d", -604718831) + ++gid + a.c(-1202541947, "\uaaa9") + string + a.b("\ue665\u9f8a\u1547\u8b3f", 241821263);
        System.out.println(a.b("\ue9aa\u9019\u1ad1\u84bd\u0f6c\u89dc\u33c1\uba63\u2427\uae91\u2959\ud37c", 177007051) + string2 + a.c(862984866, "\u1a81\u6350\ue9e3") + minecraftClient.method_47599() + a.c(-1330071925, "\ub6af\ucf58\u459d\udbef"));
        ScreenshotRecorder.method_22690((File)minecraftClient.field_1697, (String)string2, (Framebuffer)minecraftClient.method_1522(), (int)1, text -> System.out.println("" + text.getString()));
    }

    private static void giu(MinecraftClient minecraftClient, String string) {
        minecraftClient.method_1562().method_45730(string);
    }

    private static String giv(double d) {
        return String.format(Locale.ROOT, a.b("\uafb1\ud60b\u5cc4\uc2e1", 699838352), d);
    }

    static {
        gim = new StringBuilder();
    }

    private static /* synthetic */ int ty(int n, int n2) {
        return n * n2 + 1264696875;
    }
}

