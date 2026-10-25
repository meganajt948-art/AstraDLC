/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.util.ScreenshotRecorder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Entity$RemovalReason
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.gqu;
import a.hlc;
import a.hyz;
import a.ubg;
import a.ubm;
import a.ucg;
import a.ufw;
import a.wlk;
import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

final class grd {
    private static final String gre = System.getenv().getOrDefault(a.d("\u8ced\uf556\u7f86\ue1ef\u6a5d\uec81\u56dd\udf3d\u4171\ucbc6\u4c18\ub66f\u38b5\ua113\u2b49\uadb5\u17e2", 636141468, 1158230822), a.b("\u3d33\u4486\uce1c\u5078\udbaf\u5d00\ue750\u6ea4\uf0e2\u7a4d\ufd80\u07ef\u8926\u1088\u9ad0\u1c23\ua663\u29bd\ub301", -999604905));
    private static gqu grf;
    private static gqu grg;
    private static OtherClientPlayerEntity grh;
    private static int gri;
    private static int grj;
    private static int grk;
    private static String grl;
    private static int grm;
    private static /* synthetic */ long grn;
    private static /* synthetic */ String gro;

    private grd() {
    }

    static boolean tick(MinecraftClient minecraftClient, int n) {
        if (minecraftClient.player == null) {
            return false;
        }
        if (gri != 6 || n - grj < 41) {
            minecraftClient.player.setYaw(0.0f);
            minecraftClient.player.lastYaw = 0.0f;
        }
        if (gri < 6) {
            minecraftClient.player.setPitch(10.0f);
            minecraftClient.player.lastPitch = 10.0f;
        }
        switch (gri) {
            case 0: {
                grl = System.getProperty(a.d("\ub4f6\ucd4d\u479d\ud9f4\u5266\ud4cb\u6ec6\ue726\u796a\uf3dd\u7403\u8e25\u00ae\u9908\u1352\u95ae\u2ff9", -347989485, -1854230894));
                System.setProperty(a.b("\u8545\ufcfe\u762e\ue847\u63d5\ue578\u5f75\ud695\u48d9\uc26e\u45b0\ubf96\u311d\ua8bb\u22e1\ua41d\u1e4a", -730823374), gre);
                grd.grr(ucg.sameServer(a.b("\u7089\u0925\u83bc\u1da4\u964b\u10e8\uaab6\u235a\ubd01\u37b8\ub020\u4a0c\uc4dd", 1162178793), a.b("\u44ac\u3d00\ub799\u29bf\ua266\u249a\u9e94\u177d\u8930\u038c\u8442\u7e37\uf0e8\u6912\ue31c\u65eb\udfeb\u5032\uca86\u4cd7\uc523\ubf71", 438060247)), a.b("\u7a20\u03a9\u8968\u1714\u9cde\u1a6b\ua030\u298a\ub788\u3d3f\ubab9\u40d5\uce1f\u57e3\uddbe\u5b02\ue110\u6ed9\uf478\u7224\ufbce\u819b\u0f20\u94ba\u1298\u984f\u21b3\uafea\u351a\ub34b\u38fb\uc629", 268991059));
                grd.grr(!ucg.sameServer(a.b("\u6d6c\u14c0\u9e59t\u8bb0\u0d1a\ub753\u3ebf\ua0e4\u2a5d\uadc5\u57e9\ud938", -995660532), a.c(-718851104, "\u3380\u4a2c\uc0b5\u5e8d\ud542\u53e1\ue9bf\u6053\ufe08\u74b1\uf329\u0905\u87d4")), a.d("\u227c\u5bde\ud116\u4f7d\uc4b7\u4202\uf859\u71e3\uefe1\u6556\ue2d0\u18a0\u966b\u0fc7\u85c7\u032e\ub973\u36af\uac01\u2a54\ua3ab\ud9b1\u575f\ucc88", -2037514651, -944251801));
                grd.grr(ucg.sameServer(a.c(808902453, "\udf4b\ua6e7\u2c7e\ub245\u398e\ubf32\u0579\u8cdf\u12cb\u9867\u1fad\ue5d0\u6b1a\uf2b7\u78ed\ufe57\u4455\ucb88\u5139"), a.c(-1857349272, "\u190a\u60a6\uea3f\u7431\ufffb\u7953\uc30c\u4ae0\ud4a3\u5e1b\ud9a3\u239f\uad44\u34f7\ubee7")), a.d("\ua3ff\uda52\u508c\ucee5\u4565\uc39f\u79d1\uf039\u6e6a\ue4c6\u6309\u9971\u17ed\u8e11\u044e\u82bd\u38bf\ub773\u2ddd\uabe9\u2203\u584b\ud6f4\u4d38\ucb5b\u4183\uf85b\u7647\uecbc\u6aef\ue11f", 1812745021, -1021974355));
                ucg.ENABLED.set(true);
                ucg.reconnect();
                grd.grp(n);
                break;
            }
            case 1: {
                if (ucg.code() != null) {
                    grd.grs(a.c(772065183, "\uc7f9\ube52\u3486\uaaa5\u2131\ua78c\u1dd4\u9424\u0a3e") + ucg.prettyCode() + a.d("\u654b\u1cf6\u966e\u0811\u83da\u0532", 546202852, -1570831995) + ucg.fingerprint());
                    grf = new gqu(a.b("\u0db3\u7420\ufee8\u6082\ueb50\u6de1\ud781\u5e7f\uc006\u4a91", 318377458));
                    grg = new gqu(a.c(-674777803, "\ub563\ucce0\u4621\ud84b\u5395"));
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 300) break;
                return grd.grq(a.c(-1196166559, "\uf21a\u8baa\u0136\u9f0f\u14d5\u926d\u283e\ua1cc\u3fdc\ub52b\u32ec\uc880\u4655\udfa9\u55a8\ud34e\u6908\ue6d4\u7c7f\ufa6d\u7380") + (Object)((Object)ucg.status()) + a.d("\u9e03", 283720835, -189029727) + ucg.lastError());
            }
            case 2: {
                if (grd.grf.code != null && grd.grg.code != null) {
                    grf.send(a.b("\uef25\u96cd\u1c48\u826f\u09a0\u8f09\u3514\ubce6\u22b9\ua80c\u2fc1\ud5b5\u5b30\uc28f\u48d2\uce62\u7421\ufbfb\u6149\ue75f\u6eb0\u14f9", -488050872) + ucg.code() + a.d("\u85e5\ufc0b", 2039525003, -215471282));
                    grf.send(a.b("\u9bd9\ue231\u68b4\uf693\u7d5c\ufbf5\u41e8\uc81a\u5645\udcf0\u5b3d\ua149\u2fcc\ub673\u3c2e\uba9e\u00dd\u8f07\u15b5\u93a3\u1a4c\u6005", 32283572) + grd.grg.code + a.b("\u7a55\u03bb", -642024843));
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return grd.grq(a.c(121859461, "\u6de4\u1440\u9e93\u00f5\u8b23\u0dc1\ub7d5\u3e2c\ua068\u2a8d\uad10\u5760\ud9f8\u400a\uca55\u4caf\uf6e1"));
            }
            case 3: {
                if (!ucg.invites().isEmpty()) {
                    ubg ubg2 = ucg.invites().get(0);
                    grd.grr(ubg2.name.equals(a.c(-719603602, "\ub82f\uc1bc\u4b74\ud51e\u5ecc\ud87d\u621d\uebe3\u759a\uff0d")), a.d("\ud81c\ua1aa\u2b61\ub50f\u3ec5\ub865\u0273\u8bcc\u159c\u9f21\u18fa\ue2ce\u6c5d\uf5ed\u7fb8\uf958\u431c\uccc4\u5673\ud033\u59c5\u23d0\uad25\u36e0\ub082\u3a51\u83af\u0daa\u9741\u111d\u9aeb\u6478\uee3a\u77dc\uf1d7\u7b6e", -1238344263, 208897512) + ubg2.name + a.c(1902383877, "\u132d"));
                    grd.grr(ubg2.fingerprint.equals(ufw.fingerprint(grd.grf.pub)), a.b("\ub070\uc9c6\u430d\udd63\u56a9\ud009\u6a1f\ue3a8\u7df8\uf74e\u7094\u8ae7\u0427\u9d94\u17c5\u912f\u2b67\ua4ac\u3e4b\ub857\u31ac\u4be8\uc54c\u5e96\ud8e4\u5223", -313544701));
                    grd.grr(grd.grf.raw.stream().noneMatch(string -> string.contains(a.d("\u8bff\uf26c\u78a4\ue6ce\u6d1c\uebad\u51cd\ud833\u464a\uccdd", -1821868532, -131992142))), a.b("\ub6e5\ucf43\u4599\udbe5\u502a\ud6c2\u6cdf\ue525\u7b69\uf1cb\u760f\u8c2c\u02a8\u9b0b\u114e\u97e8\u2df3\ua23e\u3880\ube94\u372d\u4d73\uc3cc\u5815", 748664463));
                    grd.grt(minecraftClient);
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return grd.grq(a.d("\uf383\u8a33\u00af\u9e97\u1547\u93ee\u29a2\ua04e\u3e00\ub4f4\u3366\uc904\u47d3\ude79\u5435\ud2d7\u6899", -358673776, -1787109012));
            }
            case 4: {
                if (n - grj == 40) {
                    grd.grv(minecraftClient, a.b("\u8adb\uf37b\u79bb\ue7cc\u6c16\ueaf3\u50e4\ud912\u4755\ucdfb\u4a35\ub055", -1802204505));
                    ucg.accept(ucg.invites().get(0));
                }
                if (n - grj > 40 && ucg.members().size() == 2 && ucg.secured()) {
                    grd.grr(ucg.leader().equals(grd.grf.code), a.d("\u7e32\u0797\u8d5f\u1322\u98fe\u1e45\ua452\u2dea\ub3af\u394d\ubed2\u44aa\uca79\u53cd\ud99f\u5f79\ue568\u6ab5\uf056\u7616\ufff2\u85a5\u0b1b\u9093\u16a7\u9c78\u25d7\uabdf\u3169\ub73d\u3c85\uc24b\u4800\ud1e0\u57b2", -673029832, 308617039));
                    grf.sendStatus();
                    grg.acceptPending();
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 240) break;
                return grd.grq(a.c(578573897, "\u5636\u2f82\ua557\u3b21\ub0b8\u364f\u8c1b\u05e2\u9bb8\u1100\u96d2\u6ce7\ue238\u7bd2\uf197\u7760\ucd39\u42ef\ud84b\u5e1b\ud7b5") + ucg.secured() + a.c(-685454174, "\ucc8a"));
            }
            case 5: {
                if (ucg.members().size() == 3 && n - grj == 30) {
                    grg.sendStatus();
                }
                if (n - grj != 50) break;
                ubm ubm2 = ucg.member(grd.grf.code);
                grd.grr(ubm2 != null && a.b("\u8a94\uf307\u79cf\ue7a5\u6c77\ueac6\u50a6\ud958\u4721\ucdb6", -141587755).equals(ubm2.name) && wlk.worldId().equals(ubm2.world), a.d("\u76f2\u0f57\u859f\u1be2\u903e\u1685\uac95\u2530\ubb3c\u31c8\ub610\u4c6c\uc2aa\u5b10\ud14a\u57bf\uede1\u6231\uf8c6\u7ec4\uf734\u8d70\u03d6\u9806\u1e7f\u94fd\u2d0a\ua35a\u39ab\ubfeb\u3453\uca8b\u40c0\ud920\u5f72\ud587\u6a58", 2088342378, 1091429851) + (ubm2 != null ? ubm2.name : null) + a.c(-988069135, "\u42d9"));
                grd.grr(ucg.members().size() == 3, a.c(-739757558, "\u3257\u4bd4\uc115\u5f7f\ud4a1\u5251\ue848\u61bc\uffe5\u7553\uf28b\u08fb\u8668\u1fd1") + ucg.members().size() + a.b("\u09fc", 1381108180));
                grd.grv(minecraftClient, a.b("\ua42a\udd8a\u574a\uc93d\u42e7\uc402\u7e11\uf7e8\u69bf\ue301\u64d5\u9eb3\u1065", -1954634665));
                minecraftClient.setScreen(null);
                minecraftClient.options.getGuiScale().setValue((Object)grm);
                minecraftClient.onResolutionChanged();
                grd.gru(minecraftClient);
                Vec3d vec3d = minecraftClient.player.getEntityPos();
                double d = Math.floor(vec3d.y);
                grf.mark(1, vec3d.x - 4.0, d, vec3d.z + 14.0, 0, null);
                grf.mark(2, vec3d.x + 6.0, d, vec3d.z + 22.0, 1, null);
                grf.mark(3, vec3d.x + 2.0, d, vec3d.z - 30.0, 0, null);
                grd.grf.world = wlk.worldId().toUpperCase(Locale.ROOT);
                grf.mark(4, grh.getX(), grh.getY(), grh.getZ(), 0, a.d("\u8b9c\uf206\u78de\ue6a7\u6d64\uebf3\u51ce\ud83c\u4662", 1719492828, -972362996));
                grd.grp(n);
                break;
            }
            case 6: {
                minecraftClient.player.setPitch(18.0f);
                minecraftClient.player.lastPitch = 18.0f;
                if (n - grj == 10) {
                    grd.grr(ucg.marks().size() == 3, a.d("\u73ef\u0a4d\u80d0\u1eaa\u956f\u13cc\ua989\u207f\ube74\u348a\ub350\u4967\uc7a4\u5e01\ud417\u52ed\ue8af\u676f\ufdd7\u7b8f\uf27c\u883c\u068e\u9d1b\u1b29\u91f4\u2854\ua61c\u3cf3\ubaf1\u3109\ucfd6\u458c\udc79\u5a7e\ud0c7", 1782170486, 1166192782) + ucg.marks().size() + a.d("\u8ce9", -807549251, 1513704060));
                    grd.grr(ucg.marks().stream().allMatch(ucg::visible), a.b("\ubc53\uc5ee\u4f2e\ud146\u5a89\udc6b\u666e\uef80\u71c5\ufb6e\u7cb6\u86c9\u0817\u91ef\u1bb0\u9d08\u2740\ua89c\u3220\ub433\u3dca\u47df\uc961\u52bf\ud4c0\u5e12\ue7b6\u69f0\uf30c\u7547\ufeec(\u8a3e\u1398\u95ce\u1f64\ua0ae\u2adf\uac1d\u35a7\ubfb6\uc106\u4b50\ucce1\u5620\ud846\u6183\ueb32", 1617411086));
                    ucg.markKey();
                }
                if (n - grj == 25) {
                    grd.grv(minecraftClient, a.c(-95160246, "\uf831\u8191\u0b51\u9526\u1efc\u9819\u220a\uabf7\u35bb\ubf13\u38d8"));
                }
                if (n - grj == 40) {
                    grd.grr(grf.plainHas(a.c(-988628317, "\ubaca\uc377\u49b7\ud7df")), a.d("\ub702\ucea7\u446f\uda12\u51ce\ud775\u6d62\ue4d7\u7a89\uf03e\u77fc\u8d86\u0358\u9aed\u10af\u965f\u2c54\ua3ca\u3963\ubf35\u3690\u4c8c\uc233\u59f1\udf97", 336335244, -1404066063));
                    grd.grr(grd.grf.raw.stream().filter(string -> string.contains(a.c(1277670447, "\ub408\ucdf6\u473b\ud95e\u52cc"))).noneMatch(string -> string.contains(a.d("\uda87\ua33a\u29fa\ub792", -336331136, 2020680814))), a.c(721917538, "\u9609\uefaf\u6575\ufb09\u70c6\uf62e\u4c2e\uc5cd\u5b84\ud162\u56fe\uac8e\u225b\ubbff\u31f5\ub747\u0d02\u82ca\u1861\u9e3d\u17dd\u6d8a\ue328\u78e4\ufe97"));
                    ucg.markKey();
                }
                if (n - grj == 41) {
                    minecraftClient.player.setYaw(-25.0f);
                    minecraftClient.player.lastYaw = -25.0f;
                }
                if (n - grj == 42) {
                    ucg.markKey();
                    ucg.markKey();
                }
                if (n - grj == 50) {
                    grd.grr(grf.plainHas(a.b("\u7d3d\u0497\u8e47\u103a\u9bfe\u1d56", 1298562382)), a.b("\uc67d\ubfce\u350a\uab6d\u20ba\ua658\u1c44\u95b4\u0ba5\u815b\u0690\ufcf8\u7261\ueb9d\u61c2\ue720\u5d76\ud2ec\u480d\uce4b\u47b4\u3de7\ub34d\u288f\uaee6\u2464\u9d9e\u13d2", -1228945903));
                    grd.grr(grf.plainHas(a.c(-1747119822, "\u1115\u68ed\ue277\u7c1e\uf7c2")), a.b("\ufce4\u855e\u0f97\u91f1\u1a28\u9c90\u2686\uaf27\u317a\ubbdc\u3c19\uc668\u48ec\ud10e\u5b4b\uddb1\u67e4\ue861\u7296\uf4c2\u7d3a\u0762\u89d3\u1215", 1623260312));
                    grd.grv(minecraftClient, a.b("\u3f4c\u46ec\ucc2c\u525b\ud981\u5f64\ue57e\u6c8a\uf2da\u7862\uffb3\u05d5", 1582382896));
                }
                if (n - grj != 60) break;
                grd.grp(n);
                break;
            }
            case 7: {
                minecraftClient.player.setYaw(160.0f);
                minecraftClient.player.lastYaw = 160.0f;
                if (n - grj == 15) {
                    grd.grv(minecraftClient, a.d("\u8205\ufba5\u7165\uef12\u64c8\ue22d\u5836\ud1c6\u4f9a\uc529", 1530695197, -904917918));
                    grf.send(a.b("\u5f72\u269a\uac1f\u3238\ub9f7\u3f5e\u8543\u0cbb\u92e0\u1846\u9f86\u65b0\ueb38", 525229828));
                }
                if (n - grj > 15 && ucg.members().size() == 2 && ucg.isLeader()) {
                    grd.grr(true, a.c(-444316058, "\u4614\u3fb1\ub579\u2b04\ua0d8\u2663\u9c74\u15c9\u8b9f\u012d\u86ec\u7cc5\uf21e\u6bf8\ue1b9\u670d\udd0e\u52d6\uc861\u4e35"));
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return grd.grq(a.b("\u7d5d\u04e5\u8e32\u1054\u9b90\u1d64\ua779\u2e89\ub0cd\u3a28\ubda8\u47cf\uc918\u50a2", 1431141695));
            }
            case 8: {
                if (grd.grg.epoch == 2 && grd.grg.keyBoxes > 0) {
                    grd.grr(true, a.b("\u4fe3\u3660\ubca1\u22cb\ua915\u2fe5\u95f1\u1c08\u824c\u08a9\u8f2e\u7543\ufb99\u626d\ue870\u6e8a\ud4d7\u5b51\uc1a9\u47f6\uce1d\ub415\u3aae\ua132\u2758\uad96\u1429\u9a73\u00cc\u868f\u0d27\uf3ff\u79f6\ue013\u665d\uecee\u5374\ud950\u5f85", 13782935));
                    minecraftClient.player.setYaw(30.0f);
                    minecraftClient.player.lastYaw = 30.0f;
                    grd.grg.plain.clear();
                    ucg.markKey();
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return grd.grq(a.c(552365243, "\u6cc1\u1571\u9fed\u01ce\u8a0e\u0cb1\ub6ec\u3f01\ua107\u2bf7\uac23\u5640\ud886\u4120\ucb21\u4d9c\uf7da\u780f\ue2ab\u64e9"));
            }
            case 9: {
                if (grg.plainHas(a.d("\u6f0a\u16b7\u9c77\u021f", 999172139, -1508554936))) {
                    grd.grr(true, a.c(-348872756, "\u9fba\ue639\u6cf8\uf292\u794c\uffbc\u45ab\ucc5b\u5202\ud8a2\u5f7a\ua502\u2bd1\ub267\u3867\ubedb\u0498\u8b5a\u11f0\u97b9\u1e1d\u641b\ueab6\u717a\uf719\u7d80\uc467\u4a2a\ud0d0\u56c4\udd39\u23e3\ua9be\u3018\ub600\u3cbf\u8374"));
                    grd.grr(!grd.grf.keys.containsKey(2), a.c(-1090424186, "\u72d0\u0b7d\u81a3\u1f97\u9406\u12a3\ua8eb\u2116\ubf42\u35f9\ub26e\u4848\uc680\u5f36\ud52a\u5397\ue9d1\u6603\ufca2\u7aa7\uf318\u8940\u07e1\u9c63\u1a52\u9082\u297e\ua761\u3d9d\ubbde\u303a\ucea0\u44e1\udd0c"));
                    grd.grg.keys.put(2, ufw.randomKey());
                    grd.grg.keyBoxes = 0;
                    grd.grg.plain.clear();
                    Vec3d vec3d = minecraftClient.player.getEntityPos();
                    grg.mark(7, vec3d.x + 3.0, Math.floor(vec3d.y), vec3d.z + 9.0, 0, null);
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return grd.grq(a.b("\ua011\ud992\u5353\ucd39\u46e7\uc017\u7a07\uf3f4\u6da4\ue75c\u60dc\u9af9\u147c\u8dda\u078d\u8179\u3b72\ub4e6\u2e40\ua80e\u21f5\u5baf\ud554\u4e97", 14917722));
            }
            case 10: {
                if (grd.grg.keyBoxes > 0 && n - grj > 5 && n - grj < 100 && grd.grg.lastMarkAt == 0) {
                    grd.grr(true, a.c(-1500163963, "\u50d7\u296f\ua3b8\u3dcc\ub61a\u30bc\u8abd\u031c\u9d46\u17f1\u9039\u6a45\ue493\u7d66\uf761\u718c\ucbce\u445a\udebb\u58f1\ud108\uab56\u25f9\ube7c\u3848\ub297\u0b38\u8530\u1f93\u99d9\u1225\uec87\u66fa\uff19\u7951\uf3e9\u4c7f\uc64f\u409b\ud938\u5376\u2d90\ua791\u2068\ubab2\u34d4\u8d55\u07b1\u81e5\u1a28\u944c\u6e99\ue72b\u617f\ufb8f\u75d0\uce66\u48f2\uc2cc\u5b11\ud5b5\uaffd"));
                    Vec3d vec3d = minecraftClient.player.getEntityPos();
                    grg.mark(8, vec3d.x - 3.0, Math.floor(vec3d.y), vec3d.z + 9.0, 0, null);
                    grd.grg.lastMarkAt = n;
                }
                if (grd.grg.lastMarkAt > 0 && n - grd.grg.lastMarkAt == 20) {
                    grd.grr(ucg.marks().stream().anyMatch(ubj2 -> ubj2.id == 8), a.b("\u71fa\u0879\u82b8\u1cd2\u970c\u11fb\uabfc\u225e\ubc4c\u36f1\ub131\u4b59\uc5c5\u5c26\ud662\u5097\ueadd\u6509\uffb9\u79e6\uf018\u8a0c\u04fe\u9f28\u1945\u9385\u2a21\ua422\u3e81\ub8cc\u3372\ucde6\u47ef\ude11\u5853", -139169398));
                    grd.grr(ucg.marks().stream().noneMatch(ubj2 -> ubj2.id == 7), a.d("\ue80c\u91b0\u1b74\u8557\u0ec2\u8863\u322d\ubbd8\u2589\uaf33\u28ae\ud292\u5c49\uc5eb\u4fa1\uc91b\u7303\ufcc4\u6665\ue067\u69d4\u1393\u9d3d\u06f3\u808c\u0a48\ub3fa", 632354234, 858332613));
                    minecraftClient.player.setYaw(55.0f);
                    minecraftClient.player.lastYaw = 55.0f;
                    ucg.markKey();
                }
                if (grd.grg.lastMarkAt > 0 && n - grd.grg.lastMarkAt == 40) {
                    grd.grr(grg.plainHas(a.d("\u1519\u6ce3\ue63d\u780a", 564811536, 116539951)), a.c(1020107732, "\u9b9c\ue21f\u68de\uf6b4\u7d6a\ufb9a\u419b\uc87d\u5626\udc92\u5b56\ua174\u2fec\ub647\u3c13\ubab0\u00b2\u8f6f\u15cf\u9387\u1a68\u606a\uee98\u754f\uf336\u79ef\uc05b"));
                    grd.grp(n);
                    break;
                }
                if (n - grj <= 200) break;
                return grd.grq(a.b("\u889c\uf123\u7bec\ue5c4\u6e5e\ue8eb\u52a2\udb4d\u451e\ucfba\u487e\ub204\u3c9b\ua564\u2f36\ua9dc\u13c7\u9c5e\u06e0\u80b5\u094f\u7317\ufda5\u6630\ue047\u6adc\ud362\u5d24\uc7ce\u4189\uca69", 2024442088) + grd.grg.keyBoxes + a.b("\u7587", 1060926895));
            }
            case 11: {
                ucg.leave();
                grf.close();
                grg.close();
                if (grh != null) {
                    minecraftClient.world.removeEntity(grh.getId(), Entity.RemovalReason.DISCARDED);
                }
                if (grl == null) {
                    System.clearProperty(a.d("\ue5e9\u9c52\u1682\u88eb\u0379\u85d4\u3fd9\ub639\u2875\ua2c2\u251c\udf3a\u51b1\uc817\u424d\uc4b1\u7ee6", -479145804, -1809107670));
                } else {
                    System.setProperty(a.c(74375914, "\ue29d\u9b26\u11f6\u8f9f\u040d\u82a0\u38ad\ub14d\u2f01\ua5b6\u2268\ud84e\u56c5\ucf63\u4539\uc3c5\u7992"), grl);
                }
                ucg.reconnect();
                hyz.save();
                System.out.println(a.b("\uf444\u8de4\u0724\u9953\u1289\u9461\u2e66\ua786\u39cf\ub379\u34fe", -1321798593) + (grk == 0 ? a.c(-835032905, "\u68e3\u1143\u9b82\u05f3") : a.c(-1602072281, "\u5164\u28d2\ua209\u3c7d\ub7c6") + grk));
                return true;
            }
        }
        return false;
    }

    private static void grp(int n) {
        ++gri;
        grj = n;
    }

    private static boolean grq(String string) {
        ++grk;
        grd.grs(a.c(1838124791, "\u8eb4\uf702\u7dd9\ue3ad\u6816") + string);
        gri = 11;
        return false;
    }

    private static void grr(boolean bl, String string) {
        if (!bl) {
            ++grk;
        }
        grd.grs((bl ? a.d("\ue8df\u916a\u1bf2", -677187390, -369747855) : a.d("\u1dad\u641b\ueec0\u70b4\ufb0f", -1253918060, -1242126470)) + string);
    }

    private static void grs(String string) {
        System.out.println(a.c(-1176557621, "\u27b7\u5e17\ud4d7\u4aa0\uc17a\u4792\ufd95\u7475\uea3c\u608a\ue717\u1d7c") + string);
    }

    private static void grt(MinecraftClient minecraftClient) {
        grm = (Integer)minecraftClient.options.getGuiScale().getValue();
        minecraftClient.options.getGuiScale().setValue((Object)1);
        minecraftClient.onResolutionChanged();
        try {
            Method method = hlc.class.getDeclaredMethod(a.c(-2092456402, "\ua654\udff3\u5531\ucb60\u4082\uc630\u7c4a\uf595\u6bd6"), String.class);
            method.setAccessible(true);
            method.invoke(null, a.d("\u1829\u61ac\ueb64\u7519\ufec5\u787e\uc23a", 348247764, -35336516));
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            grd.grs(a.c(261307740, "\u3d2b\u4498\uce44\u507c\udbf8\u5d1d\ue71e\u6ef6\uf0a3\u7a1a\ufd82\u07a7\u896c\u10d0\u9ac6\u1c63\ua639\u29eb\ub300\u354b") + reflectiveOperationException);
        }
        minecraftClient.setScreen((Screen)new hlc());
    }

    private static void gru(MinecraftClient minecraftClient) {
        grh = new OtherClientPlayerEntity(minecraftClient.world, new GameProfile(UUID.randomUUID(), a.d("\u6435\u1daf\u9777\u090e\u82cd\u045a\ube67\u3795\ua9cb", 1445288478, 869875303)));
        Vec3d vec3d = minecraftClient.player.getEntityPos().add(5.0, 0.0, 11.0);
        grh.refreshPositionAndAngles(vec3d.x, minecraftClient.player.getY(), vec3d.z, 180.0f, 0.0f);
        minecraftClient.world.addEntity((Entity)grh);
    }

    private static void grv(MinecraftClient minecraftClient, String string) {
        ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.c(331466319, "\uc62f\ubf94\u3544\uab2d\u20bf\ua611") + string + a.d("\u403d\u39d2\ub31f\u2d67", 983932876, 2032132059)), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> System.out.println("" + text.getString()));
    }

    static {
        grm = -1;
    }

    private static /* synthetic */ int wg(int n, int n2) {
        return n - n2 | 0x9981293E;
    }

    private static /* synthetic */ int wh(int n, int n2) {
        return n - n2 + 159413610;
    }

    private static /* synthetic */ int wi(int n, int n2) {
        return grd.wg(n, n2) + n;
    }
}

