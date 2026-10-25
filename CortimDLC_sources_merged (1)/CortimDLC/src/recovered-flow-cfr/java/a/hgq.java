/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import a.kfe;
import a.vbb;
import a.vlv;
import a.vmc;
import a.vmo;
import flow.Flow;
import flow.dev.a;
import java.io.File;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.util.ScreenshotRecorder;

final class hgq {
    private static String hgr;
    private static int hgs;
    private static /* synthetic */ long hgt;
    private static /* synthetic */ int hgu;

    private hgq() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        kfe kfe2 = Flow.getInstance().getModuleManager().getByName(a.c(-1321686410, "\uaa26\ud3a5\u5972\uc716\u4cdd\uca61\u7025"));
        if (n == hgs) {
            hgq.hgy(minecraftClient, a.d("\u5adf\u2370\ua9a4\u37cf\ubc09\u3aaf\u80fe\u0913\u9741\u1dff\u9a36\u6040\ueec9", 721189120, -659348571) + hgr);
        }
        switch (n) {
            case 1: {
                hgq.hgx(minecraftClient, a.d("\u3db1\u4406\uced9\u50a0\udb7f\u5dcc\ue794\u6e64\uf07e\u7a8c\ufd4e\u0728\u89fb\u105f\u9a11\u1cff\ua6a3", -1349585201, -1642083576));
                hgq.hgx(minecraftClient, a.d("\u9910\ue0bc\u6a6b\uf412\u7f80\uf962\u4327\ucac7\u54cc\ude6f\u59bb\ua3cf\u2d18", 971967302, 49058351));
                hgq.hgx(minecraftClient, a.d("\ue7d4\u9e77\u14a0\u8ac4\u010f\u87b3\u3df7\ub454\u2a48\ua0f6\u272c\udd59\u539d", 940820672, -630837394));
                hgq.hgx(minecraftClient, a.c(-1443769256, "\ud421\uad96\u2749\ub930\u32f0\ub446\u0e0c\u87f4\u19ee\u931b\u14c3\uee99\u606b\uf9c2\u7384\uf570\u4f31\uc0ef\u5a40\udc26\u55eb\u2fa0\ua11c\u3ac4\ubcfe\u3669\u8fdd\u0181\u9b69\u1d2e"));
                hgq.hgx(minecraftClient, a.d("\u3f0c\u46b9\ucc3a\u522b\ud9cf\u5f2d\ue56e\u6c8f\uf28e\u7861\uffa2", -493578007, -1921996902));
                break;
            }
            case 3: {
                hgq.hgx(minecraftClient, a.b("\u0a2e\u7390\uf946\u6737\uecac\u6a10\ud05f\u59ad\uc7e0\u4d0f\uca82\u30fe\ube30\u2795\uadd7\u2b25\u9178\u1ef7\u8402\u024b\u8bad\uf1fb\u7f5e\ue4c2\u62b9\ue86f\u51d7\udf80\u4566\uc324\u4890\ub653\u3c52\ua5f8\u23a3\ua909", 474352236));
                break;
            }
            case 4: {
                hgq.hgx(minecraftClient, a.b("\u0ea2\u771c\ufdca\u63bb\ue820\u6e9c\ud4d3\u5d21\uc36c\u4983\uce03\u346e\ubaa8\u2314\ua95e\u2fbb\u95e5\u1a37\u8096\u0699\u8f3d\uf570\u7bd2\ue012\u666a\uecad\u5553\udb06\u41f6\uc7ac\u4c19\ub2d9\u3885\ua173\u2732\uadcd\u1247\u9823\u1ee3\u8740\u0d1f\u73c2\uf9ac\u7e13\ue4c7\u6aba\ud361", -488829205));
                break;
            }
            case 5: {
                hgq.hgx(minecraftClient, a.b("\ue8cc\u9172\u1ba4\u85d5\u0e4e\u88f2\u32b9\ubb5d\u255c\uafb3\u2873\ud211\u5ccb\uc566\u4f24\uc98b\u739a\ufc5c\u66f8\ue0e4\u6917\u1341\u9df9\u062e\u8040\u0a82\ub336\u3d75\ua7cc\u21d4\uaa7c\u54aa\udef8\u470f\uc177\u4bfe\uf43c\u7e5e\uf89f\u612e", 115927170));
                break;
            }
            case 6: {
                hgq.hgx(minecraftClient, a.d("\u370e\u4ea9\uc46b\u5a0c\ud1d5\u5767\ued38\u64c1\ufad5\u7075\uf7b7\u0d98\u8311\u1ab4\u90f3\u164f\uac04\u23d2\ub96a\u3f3d\ub6db\ucc99\u422d\ud9ee\u5fdf\ud544\u6ce8\ue2a6\u7851\ufe09", 1975615151, -122467892));
                hgq.hgx(minecraftClient, a.d("\ua4fe\udd59\u579b\uc9fc\u4225\uc497\u7ec8\uf731\u6925\ue386\u6447\u9e68\u10e1\u8945\u0303\u85bf\u3ff4\ub022\u2a9a\uaccd\u252b\u5f69\ud1dd\u4a1e\ucc2f\u46a0\uff16\u7148\uebb5\u6de5\ue65f\u188b\u92c2\u0b32", 445001074, -906262051));
                hgq.hgx(minecraftClient, a.b("\u8737\ufe90\u7452\uea35\u61ec\ue75e\u5d01\ud4f8\u4aec\uc04c\u478e\ubda1\u3328\uaa8f\u20ca\ua676\u1c3d\u93eb\u0953\u8f04\u06e2\u7ca0\uf214\u69d7\uefe6\u656e\udcd1\u529d\uc876\u4e2f\uc596\u3b44\ub113\u28f0\uaeb4", -112359577));
                hgq.hgx(minecraftClient, a.b("\uff1d\u86ba\u0c78\u921f\u19c6\u9f74\u252b\uacd2\u32c6\ub864\u3fa4\uc58b\u4b02\ud2a0\u58e0\ude5c\u6417\uebc1\u7179\uf72e\u7ec8\u048a\u8a3e\u11fd\u97cc\u1d41\ua4f1\u2ab7\ub05c", -489095309));
                hgq.hgx(minecraftClient, a.c(863654243, "\u5136\u2891\ua253\u3c34\ub7ed\u315f\u8b00\u02f9\u9ced\u164c\u918f\u6ba0\ue529\u7c81\uf6cb\u7077\uca3c\u45ea\udf52\u5905\ud0e3\uaaa1\u2415\ubfd6\u39e7\ub36e\u0ad6\u849c\u1e7a\u9820\u13a4\ued59\u6704\ufee4\u78ab\uf21f\u4dcf\uc7b7"));
                break;
            }
            case 7: {
                hgq.hgx(minecraftClient, a.d("\u2731\u5e96\ud454\u4a33\uc1ea\u4758\ufd07\u74fe\ueaea\u6049\ue788\u1da7\u932e\u0a88\u80cc\u0670\ubc3b\u33ed\ua955\u2f02\ua6e4\udca6\u5212\uc9d1\u4fe0\uc57f\u7cd9\uf285\u6872\uee10\u659b\u9b5f\u1103\u88e0\u0eb3\u842a\u3bce\ub1b6\u3768\uaed3\u24d7\u5a77\ud027\u578e\ucd4b\u432d\ufad1", 1277056932, -40472375));
                hgq.hgx(minecraftClient, a.b("\u6393\u1a34\u90f6\u0e91\u8548\u03fa\ub9a5\u305c\uae48\u24eb\ua32a\u5905\ud79d\u4e3d\uc479\u429f\uf89d\u7748\uedfc\u6ba6\ue257\u9817\u16b7\u8d61\u0b0c\u8193\u386e\ub62a\u2cd0\uaa81\u2101\udfe8\u55b2\ucc50\u4a11\uc0a0\u7f5f\uf51d\u73c7\uea7b\u602e\u1e84\u949f\u132b\u89fc\u0798\ube5c\u34c2", -453155888));
                break;
            }
            case 8: {
                hgq.hgx(minecraftClient, a.b("\u9861\ue1df\u6b09\uf578\u7ee3\uf844\u4201\ucbae\u55a2\udf0f\u58cd\ua2a4\u2c6b\ub5cc\u3f89\ub926\u033a\u8cf7\u1655\u9015\u19e3\u63a2\ued5c\u7689\uf0f1\u7a2b\uc39e\u4dde\ud73a\u516c\udacd\u2452\uae50\u37b7\ub1f1\u3b51\u8491", -1400858590));
                hgq.hgx(minecraftClient, a.d("\uaee1\ud75f\u5d89\uc3f8\u4863\ucec7\u7481\ufd2e\u632f\ue986\u6e4d\u9429\u1aeb\u8304\u091b\u8ff8\u35a6\uba76\u20d5\ua6c9\u2f3a\u556c\udbd4\u4003\uc66d\u4caf\uf51b\u7b58\ue1e1\u67f9\uec4c\u128f\u98c6\u0124\u875a\u0dd7\ub202\u387c\ubea4", -1597043236, -1647598724));
                break;
            }
            case 9: {
                hgq.hgx(minecraftClient, a.c(-1942102983, "\udc65\ua5db\u2f0d\ub17c\u3ae7\ubc5b\u061d\u8ff4\u11f5\u9b1a\u1cd1\ue6b8\u6862\uf1c8\u7b8d\ufd22\u4722\uc8e2\u5240\ud410\u5df7\u27eb\ua95c\u328a\ub4fe\u3e29\u878b\u09c9\u9339\u157a\u9e87\u6003\uea42\u73b9\uf5de\u7f5c\uc082\u4af7\ucc33\u5591\udfd8\ua101\u2b79\uacdd\u361d\ub86d\u01a4\u8b0f\u0d47\u9687\u18ff\ue234\u6bca\uedd2\u7727\uf971\u42de\uc437"));
                break;
            }
            case 10: {
                hgq.hgx(minecraftClient, a.d("\u705a\u09e4\u8332\u1d43\u96d8\u1071\uaa3a\u2395\ubd94\u3731\ub0f6\u4a96\uc440\u5de1\ud7ec\u5151\ueb0c\u64cb\ufe6e\u7872\uf181\u8bd7\u056f\u9eb8\u18d6\u9214\u2ba0\ua5e3\u3f5a\ub942\u32f2\ucc21\u4669\udf8e\u59db\ud350\u6cb4\ue6cc\u601b\uf9bd\u73f1\u0d16\u876d\u00f7\u9a35\u1453\uad81\u272a\ua17f\u3aa9\ub4cb\u4e11\uc7bc\u41a4\udb1e\u5549\ueef1\u6830\ue27b", 176007581, 262003098));
                break;
            }
            case 11: {
                hgq.hgx(minecraftClient, a.b("\u9617\uefa9\u657f\ufb0e\u7095\uf629\u4c6f\uc586\u5b87\ud168\u56a9\uacca\u2210\ubbba\u31ff\ub750\u0d50\u8290\u1837\u9e72\u17c8\u6d9d\ue329\u78f3\ufe8a\u744a\ucdea\u43bc\ud959\u5f46\ud4ad\u2a77\ua023\u39c3\ubf9b\u351d\u8af9\u0081\u8656\u1ff0\u95bc\ueb5b\u6120\ue6ba\u7c78\uf21e\u4bcc\uc167\u4732\udce4\u5286\ua85c\u21f1\ua7e9\u3d53\ub304\u08bc\u8e7d\u0436", -450587062));
                break;
            }
            case 12: {
                hgq.hgx(minecraftClient, a.d("\u3269\u4bd7\uc101\u5f70\ud4eb\u5257\ue81a\u61f8\ufff9\u7516\uf2d4\u08a6\u8663\u1fdf\u9592\u1370\ua961\u26fd\ubc5d\u3a1d\ub3e9\uc9aa\u4754\udc81\u5af9\ud023\u6996\ue7d6\u7d32\ufb64\u70c5\u8e5a\u0440\u9dbf\u1be6\u9163\u2e87\ua4f5\u222e", 235702216, 541636064));
                break;
            }
            case 13: {
                hgq.hgx(minecraftClient, a.d("\u3abd\u4303\uc9d5\u57a4\udc3f\u5a83\ue0c8\u692c\uf72d\u7dd1\ufa11q\u8ea7\u1706\u9d58\u1bb5\ua1eb\u2e64\ub49d\u32d8\ubb3e\uc16a\u4fcd\ud451\u522a\ud8fc\u6144\uef13\u75f5\uf3b7\u7803\u86c0\u0cc1\u9565\u1338\u9983\u2660\uac22\u2af8\ub34d\u3905\u47e7\ucda2\u4a3b\ud0c7\u5ea3\ue767\u6dd7\ueb82\u7049\ufe3d\u04fd\u8d41\u0b0a\u91b0\u1fa8\ua411\u22c7\ua8a4\u314d\ubf87\uc59d\u4260\uc831\u56eb", 1619839565, -323489577));
                break;
            }
            case 30: {
                hgq.hgv(minecraftClient, 0.0f, 28.0f, a.d("\ufc73\u85d5\u0f09\u917f\u1aad\u9c1c\u2642\uafff\u31e9\ubb5d\u3c96", 1528626036, 362415994), n);
                break;
            }
            case 40: {
                ((vlv)hgq.hgw(kfe2, a.c(-683447802, "\u6a53\u13d4\u9903\u0760\u8cab\u0a1b"))).set(a.b("\u9000\ue98f\u635b\ufd30\u76f6\uf050", 132091985));
                ((vmc)hgq.hgw(kfe2, a.b("\ub89b\uc11b\u4bdb\ud5ac\u5e66\ud8dd\u6281\ueb79\u7530", -19220286))).set(0.25);
                kfe2.setEnabled(true);
                vbb.timing(true);
                break;
            }
            case 60: {
                vbb.gpuMillis();
                break;
            }
            case 70: {
                System.out.println(a.c(-1951830764, "\u6d76\u14d9\u9e0df\u8ba0\u0d06\ub757\u3eba\ua0e8\u2a56\uad9f\u57e9\ud96d\u409b\ucadf\u4c2b\uf631\u79a4\ue312\u655b\uecf5") + vbb.gpuMillis() + a.c(1897626196, "\u7a77\u038b\u8946"));
                hgq.hgv(minecraftClient, 0.0f, 28.0f, a.d("\ud72a\uae9e\u2455", 1344712251, -937461386), n);
                break;
            }
            case 85: {
                hgq.hgx(minecraftClient, a.b("\uf5f1\u8c44\u06c7\u98d6\u1332\u95d0\u2f93\ua672\u3873\ub29c\u355d", -1117915762));
                hgq.hgv(minecraftClient, 0.0f, 42.0f, a.d("\uad3a\ud48e\u5e45\uc060\u4bf9\ucd47\u7717\ufefa\u60b3", -1723897859, -1137784150), n);
                break;
            }
            case 105: {
                hgq.hgv(minecraftClient, 45.0f, 18.0f, a.b("\u0bba\u720e\uf8c5\u66e0\ued76\u6bce\ud199\u587f\uc633\u4c94", -1837036588), n);
                break;
            }
            case 120: {
                hgq.hgv(minecraftClient, -35.0f, 4.0f, a.d("\ue0d7\u9963\u13a8\u8d8d\u0614\u80a7\u3afb\ub301", 1576823067, 190351776), n);
                break;
            }
            case 135: {
                hgq.hgv(minecraftClient, 20.0f, -5.0f, a.d("\u78a9\u011d\u8bd6\u15f3\u9e7d\u18ca\ua28e\u2b7f", 1301724055, 549897042), n);
                break;
            }
            case 150: {
                hgq.hgv(minecraftClient, -78.0f, 8.0f, a.d("\ue0be\u990a\u13c1\u8de4\u066d\u80df\u3a8e\ub378\u2d31\ua786", -2014324854, -1701693606), n);
                break;
            }
            case 165: {
                hgq.hgv(minecraftClient, 92.0f, 14.0f, a.c(-1953344779, "\u5298\u2b2c\ua1e7\u3fc2\ub45a\u32e0\u88a8\u0148\u9f1c"), n);
                break;
            }
            case 180: {
                hgq.hgx(minecraftClient, a.c(-548480031, "\udb9b\ua237\u28e0\ub699\u3d0b\ubbe9\u01ac\u884c\u1647\u9ce7\u1b3d\ue144\u6f93\uf622"));
                hgq.hgx(minecraftClient, a.b("\uf7bc\u8e0b\u04c0\u9ab1\u1164\u97d4\u2dc9\ua475\u3a2e\ub098\u3740\ucd37\u43f1\uda53\u5007\ud6e4\u6ce5\ue374\u79d2\uff81\u7679\u0c23\u829c\u1908\u9f67\u15a6\uac4b\u2244\ub8a5\u3ee2\ub50a\u4bee\uc180\u585f\ude04\u54c6\ueb1a\u6138\ue7a5\u7e68\uf402\u8ae4\u00b6\u871d\u1dd0\u93a6\u2a64\ua0de\u269c\ubd4b\u330f\uc9e9\u404a\uc61f\u5cf0\ud2ba\u6912\uefc2\u65ef\ufc35\u72d1\u08ce\u8f43\u052f\u9bfb\u125f\ua819\u2ef5\ua4a4\u3b14\ub193\u3783\uce36\u448e\udad5\u5172\ud76f\u6dc2\ue447\u7a0d\uf0e2", -542378082));
                hgq.hgx(minecraftClient, a.b("\u8b90\uf227\u78ec\ue69d\u6d48\uebf8\u51e5\ud859\u4602\uccb4\u4b6c\ub11b\u3fdd\ua67f\u2c2b\uaac8\u10c9\u9f41\u05e3\u83a5\u0a52\u7016\ufeb0\u6576\ue35b\u6998\ud039\u5e36\uc49f\u42d6\uc97d\u37f7\ubd8d\u245d\ua220\u2899\u973d\u1d47\u9bc7\u0238\u881b\uf6df\u7c9b\ufb2b\u61e6\uef8d\u5659\udcf9\u5abd\uc161\u4f14\ub5f2\u3c72\uba37\u20c0\uae8d\u1529\u93ef\u199d\u8012\u0eae\u74ac\uf311\u793e\ue7cc\u6e66\ud420\u52c4\ud88e\u4739\ucdeb\u4bce\ub270\u38a8\ua6f9\u2d08\uab09\u11f2\u983d\u061a\u8cee\u0a9f", 805145521));
                hgq.hgx(minecraftClient, a.d("\u20d0\u5967\ud3ac\u4ddd\uc608\u40b8\ufaa5\u7319\ued42\u67f4\ue02c\u1a5b\u949d\u0d3f\u876b\u0188\ubb89\u3412\uaeb8\u28e7\ua157\udb0b\u55a7\uce64\u4845\uc2ca\u7b6e\uf528\u6f84\ue9e0\u6272\u9c8d\u16ca\u8f48\u0910\u83f2\u3c6b\ub666\u3080\ua926\u2378\u5d93\ud7da\u506c\ucaaa\u44d0\ufd0e\u77b9\uf1c1\u6a27\ue440\u1e95\u973e\u1174\u8b90\u05c0\ube21\u38fb\ub2db\u2b44\ua58d\udfe1\u5809\ud24d\u4c97\uc53b\u7f6e\uf99e\u739d\uec4d\u66f4\ue081\u195b\u93bc\u0da5\u8648I\ubac3\u3330", -184826870, -2016942874));
                break;
            }
            case 190: {
                vbb.gpuMillis();
                break;
            }
            case 200: {
                System.out.println(a.b("\u39c7\u4068\ucabc\u54d7\udf11\u59b7\ue3e6\u6a0b\uf459\u7ee7\uf92e\u0358\u8ddc\u142a\u9e6e\u189a\ua280\u2d1f\ub7ab\u31f4\ub80c\uc241\u4ca6", -1694877273) + vbb.gpuMillis() + a.b("\u7c27\u05db\u8f16", 875133956));
                hgq.hgv(minecraftClient, 0.0f, 20.0f, a.d("\u30e0\u4956\uc38b\u5df5\ud63e\u50d6\ueac5\u6336\ufd64\u77c4", -511572819, -1439157207), n);
                break;
            }
            case 215: {
                hgq.hgx(minecraftClient, a.c(1081675953, "\u10c8\u697d\ue3fe\u7def\uf60b\u70e9\ucaaa\u434b\udd4a\u57a5\ud065\u2a09\ua4c5"));
                hgq.hgv(minecraftClient, 0.0f, 12.0f, a.b("\u49a0\u3016\ubacb\u24b5\uaf7e\u2996\u9392\u1a76\u842b\u0e95\u894d\u7330", 510544322), n);
                break;
            }
            case 230: {
                hgq.hgv(minecraftClient, 60.0f, 14.0f, a.d("\ue264\u9bd2\u110f\u8f71\u04ba\u8252\u3840\ub1b8\u2fe3\ua545\u2285\ud8e2", 1615152920, -727997154), n);
                break;
            }
            case 245: {
                hgq.hgv(minecraftClient, 22.0f, -5.0f, a.b("\u4fc5\u3673\ubcae\u22d0\ua91b\u2ff3\u95f9\u1c0e\u8246\u08f7", 2127908769), n);
                break;
            }
            case 260: {
                hgq.hgx(minecraftClient, a.b("\ub9fd\uc051\u4a86\ud4ff\u5f6d\ud98f\u63ca\uea2a\u7421\ufe82\u7956\u8322\u0df5", 145799556));
                hgq.hgv(minecraftClient, 0.0f, 12.0f, a.c(1462093835, "\uc865\ub1d1\u3b1a\ua53f\u2ebf\ua81b\u124a\u9bb4\u05e0\u8f5d"), n);
                break;
            }
            case 262: {
                vbb.gpuMillis();
                break;
            }
            case 274: {
                System.out.println(a.d("\uc7d1\ube7e\u34aa\uaac1\u2107\ua7a1\u1df0\u941d\u0a4f\u80f1\u0738\ufd4e\u73ca\uea3c\u6078\ue68c\u5c96\ud303\u49b5\ucffc\u4640\u3c03", -1576511714, -1565355858) + vbb.gpuMillis() + a.d("\u7681\u0f7d\u85b0", 1028822286, 299688876));
                break;
            }
            case 275: {
                kfe2.setEnabled(false);
                hgq.hgv(minecraftClient, 0.0f, 12.0f, a.c(915994229, "\uf61f\u8fab\u0560\u9b45\u10c5\u9661\u2c30\ua5ce\u3b9a\ub127\u36bc\ucc8f\u4251\udbe0"), n);
                break;
            }
            case 290: {
                vbb.timing(false);
                hgq.hgx(minecraftClient, a.c(-181299074, "\u9804\ue1b3\u6b6c\uf515\u7ed5\uf863\u4229\ucbd1\u55cb\udf3e\u58e6\ua2bc\u2c4e\ub5e7\u3fa1\ub955\u0314\u8cca\u1665\u9003\u19ce\u6385\ued39\u76e1\uf0db\u7a5e\uc3eb\u4dbd\ud75a"));
                return true;
            }
        }
        return false;
    }

    private static void hgv(MinecraftClient minecraftClient, float f, float f2, String string, int n) {
        minecraftClient.player.setYaw(f);
        minecraftClient.player.setPitch(f2);
        minecraftClient.player.lastYaw = f;
        minecraftClient.player.lastPitch = f2;
        hgr = string;
        hgs = n + 10;
    }

    private static vmo hgw(kfe kfe2, String string) {
        for (vmo vmo2 : kfe2.getSettings()) {
            if (!vmo2.getName().equals(string)) continue;
            return vmo2;
        }
        throw new IllegalStateException(kfe2.getName() + a.d("\udeac\ua755\u2d8f\ub3ec\u3868\ube97\u04c5\u8d7b", -396659611, -2106610975) + string);
    }

    private static void hgx(MinecraftClient minecraftClient, String string) {
        minecraftClient.getNetworkHandler().sendChatCommand(string);
    }

    private static void hgy(MinecraftClient minecraftClient, String string) {
        System.out.println(a.c(118715274, "\u73f3\u0a54\u808e\u1ef5\u9564\u1381\ua9c3\u2024\ube7c\u3499") + string + a.b("\uc100\ub8d1\u3262", -1503739613) + minecraftClient.getCurrentFps() + a.b("\u2586\u5c71\ud6b4\u48c6", -87480926));
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\ua9b2\ud009\u5ad9\uc4b0\u4f22\uc98c", -812537390) + string + a.d("\u034d\u7aa2\uf06f\u6e17", -883199394, -1723895495)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        hgs = -1;
    }

    private static /* synthetic */ int zw(int n, int n2) {
        return n + n2 | 0x93706DC;
    }
}

