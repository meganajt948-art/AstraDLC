/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.ewk;
import a.hhf;
import a.hlc;
import a.izx;
import a.ubd;
import a.ubg;
import a.ubj;
import a.ubm;
import a.ubp;
import a.ubs;
import a.ubx;
import a.ucd;
import a.ufw;
import a.ugg;
import a.uhg;
import a.vhz;
import a.vkl;
import a.vkq;
import a.vkw;
import a.vmc;
import a.vmo;
import a.voa;
import a.wap;
import a.wlk;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.cosmetic.Cosmetics;
import flow.dev.a;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

public final class ucg {
    public static final String DEFAULT_RELAY;
    public static final int MAX_MEMBERS = 8;
    public static final int CODE_LEN = 6;
    public static final String ALPHABET;
    public static final int DANGER = -1096636;
    public static final int[] COLORS;
    public static final vkl ENABLED;
    public static final vmc MARK_TIME;
    public static final vkl SOUNDS;
    public static final vmc VOLUME;
    public static final vkw LISTEN;
    public static final List<vmo> OPTIONS;
    public static final List<vmo> ALL;
    private static final double uch = 400.0;
    private static final long uci = 400L;
    private static final int ucj = 3;
    private static final long uck = 25000L;
    private static final long ucl = 1000L;
    private static final long ucm = 10000L;
    private static final int ucn = 3;
    private static final int uco = 1000;
    private static final long ucp = 15000L;
    private static final int ucq = 32;
    private static final List<ubm> ucr;
    private static final List<ubg> ucs;
    private static final List<ubj> uct;
    private static final Map<Integer, byte[]> ucu;
    private static final Set<String> ucv;
    private static final List<ubs> ucw;
    private static final List<ubx> ucx;
    private static final Set<String> ucy;
    private static final Map<String, ubg> ucz;
    private static final Map<String, Long> uda;
    private static String udb;
    private static PrivateKey udc;
    private static String udd;
    private static String ude;
    private static int udf;
    private static byte[] udg;
    private static uhg udh;
    private static String udi;
    private static ucd udj;
    private static String udk;
    private static String udl;
    private static String udm;
    private static String udn;
    private static long udo;
    private static int udp;
    private static long udq;
    private static long udr;
    private static String uds;
    private static long udt;
    private static long udu;
    private static long udv;
    private static ubj udw;
    private static int udx;
    private static String udy;
    private static String udz;
    private static boolean uea;
    private static int ueb;
    private static /* synthetic */ int uec;
    private static /* synthetic */ String ued;

    private ucg() {
    }

    public static int version() {
        return udx;
    }

    public static ucd status() {
        return udj;
    }

    public static String lastError() {
        return udn;
    }

    public static String code() {
        return udk;
    }

    public static String prettyCode() {
        return ucg.pretty(udk);
    }

    public static String pretty(String string) {
        return string == null || string.length() != 6 ? string : string.substring(0, 3) + a.b("\uf229", -346951163) + string.substring(3);
    }

    public static String fingerprint() {
        return udd == null ? null : ufw.fingerprint(udd);
    }

    public static boolean inParty() {
        return udl != null;
    }

    public static boolean secured() {
        return udl != null && udl.equals(ude) && ucu.containsKey(udf);
    }

    public static String leader() {
        return udm;
    }

    public static boolean isLeader() {
        return udk != null && udk.equals(udm);
    }

    public static List<ubm> members() {
        return Collections.unmodifiableList(ucr);
    }

    public static List<ubg> invites() {
        long l = System.currentTimeMillis();
        ucs.removeIf(ubg2 -> ubg2.until < l);
        return Collections.unmodifiableList(ucs);
    }

    public static List<ubj> marks() {
        return uct;
    }

    public static int noticeSeq() {
        return ueb;
    }

    public static String notice() {
        return udz;
    }

    public static boolean noticeError() {
        return uea;
    }

    public static boolean online() {
        return udj == ucd.ONLINE;
    }

    public static String relay() {
        return System.getProperty(a.b("\u7a50\u03eb\u893b\u1752\u9cc0\u1a6d\ua060\u2980\ub7cc\u3d7b\ubaa5\u4083\uce08\u57ae\uddf4\u5b08\ue15f", -1630832089), DEFAULT_RELAY);
    }

    public static String normalize(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toUpperCase(Locale.ROOT).toCharArray()) {
            if (a.d("\ub7cd\uce7f\u44ad\udadb\u510d\ud7bf\u6ded\ue413\u7a4e\uf0fe\u772a\u8d5a\u038e\u9a21\u1073\u9681\u2ccf\ua319\u39ab\ubff9\u360f\u4c51\uc2e3\u5931\udf26\u55f6\uec42\u6212\uf8e6\u7eb6\uf50a\u0bda", 1691561230, 1900911266).indexOf(c) >= 0) {
                stringBuilder.append(c);
                continue;
            }
            if (!Character.isLetterOrDigit(c)) continue;
            return null;
        }
        return stringBuilder.length() == 6 ? stringBuilder.toString() : null;
    }

    public static ubm member(String string) {
        for (ubm ubm2 : ucr) {
            if (!ubm2.code.equals(string)) continue;
            return ubm2;
        }
        return null;
    }

    public static String cosmeticsOf(String string) {
        if (string == null || udk == null) {
            return null;
        }
        for (ubm ubm2 : ucr) {
            if (ubm2.code.equals(udk) || !ubm2.online || ubm2.cosmetics == null || !string.equalsIgnoreCase(ubm2.name) || ubm2.world != null && !ucg.sameWorld(ubm2) && !ucg.onThisServer(ubm2.name)) continue;
            return ubm2.cosmetics;
        }
        return null;
    }

    static boolean onThisServer(String string) {
        return string != null && hhf.listEntry(string) != null;
    }

    public static ubm self() {
        return udk == null ? null : ucg.member(udk);
    }

    public static boolean sameWorld(ubm ubm2) {
        return ubm2.world != null && ucg.sameServer(ubm2.world, wlk.worldId());
    }

    public static boolean sameServer(String string, String string2) {
        return string != null && string2 != null && ucg.serverKey(string).equals(ucg.serverKey(string2));
    }

    static String serverKey(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (!string2.startsWith(a.d("\u5875\u21d9\uab40", -1084236287, 2018412058))) {
            return string2;
        }
        String string3 = string2.substring(3);
        int n = string3.indexOf(58);
        if (n > 0 && n == string3.lastIndexOf(58)) {
            string3 = string3.substring(0, n);
        }
        while (string3.endsWith(a.d("\u4e14", 352354821, 278580286))) {
            string3 = string3.substring(0, string3.length() - 1);
        }
        if (string3.matches(a.b("\uc715\ubecf\u3401\uaa64\u21a4\ua766\u1d43", -2125412535)) || string3.indexOf(58) >= 0) {
            return a.b("\u9f40\ue6ec\u6c75", 980524846) + string3;
        }
        String[] stringArray = string3.split(a.c(-1424519500, "\u8eec\uf728\u7d88"));
        if (stringArray.length > 2) {
            string3 = stringArray[stringArray.length - 2] + a.d("\ue3c9", 751045315, 226027813) + stringArray[stringArray.length - 1];
        }
        return a.d("\ucb85\ub229\u38b0", -1927787039, -1108179446) + string3;
    }

    public static boolean visible(ubj ubj2) {
        if (!Objects.equals(ubj2.dim, wlk.dimensionId())) {
            return false;
        }
        if (ubj2.mine || ucg.sameServer(ubj2.world, wlk.worldId())) {
            return true;
        }
        return ubj2.name != null && (hhf.inWorld(ubj2.name) != null || ucg.onThisServer(ubj2.name));
    }

    public static void invite(String string) {
        String string2 = ucg.normalize(string);
        if (string2 == null) {
            ucg.ufb(wap.s(a.c(-1620059397, "\udaaf\ua332\u29ea\ub79a\u3c5b\ubab9\u00a6\u8954\u170b\u9dbe\u1a26\ue01b\u6ec9\uf77a\u7d27\ufb93\u41bd\uce6f\u54dd\ud2e2\u5b0a\u215a\uafee"), a.c(-1777579415, "\u4e6b\u37fe\ubd27\u2742\ua887\u2e4f\u9464\u1d9d\u83b6\u097c\u8ea3\u74a8\ufe1d\u63b6\ue9ef\u6f14\ud141\u5ef1\uc441\u4211\ucb88\ub1c6\u3f74\ua4a2")), true);
            return;
        }
        if (string2.equals(udk)) {
            ucg.ufb(wap.s(a.c(-1108440088, "\u8ba8\uf225\u78ff\ue69b\u6d1f\uebfa\u51fa\ud852\u461b\uccb0\u4b64\ub147\u3fdf\ua676\u2c3c\uaa83\u108f\u9f52\u05ea\u83ba"), a.c(-631557808, "\u3576\u4ca8\uc607\u5c68\ud3ad\u551e\uef35\u62ac\uf8e9\u725c\uf585")), true);
            return;
        }
        if (ucg.inParty() && !ucg.secured()) {
            ucg.uev();
            ucg.ufb(wap.s(a.b("\u7717\u0e90\u844b\u1a27\u91ed\u175b\uad01\u24b7\ubaae\u3016\ub7d8\u4dfb\uc378\u5ad5\ud08b\u563f\uec20\u63e0\uf940\u7f17\uf6ed\u8ce5\u021d\u99c2\u1fa1\u9525\u2c9a\ua29f\u386e\ube34\u35de\ucb4e\u4107\ud8f0\u5eab\ud41d", -762480796), a.b("\u4d5e\u34cd\ube7b\u2067\uafac\u2d07\u9755\u1ed1\u8087\u0e51\u8d9d\u77e3\uf946\u608d\ueeca\u6837\ud667\u59b7\uc305\u452b\ucca2\ub6fc\u383d\ua396\u2592\uaf34\u1292\u98d6\u025d\u8414\u0bd6\uf167\u7b58\ue2ae", 77285738)), true);
            return;
        }
        if (!ucg.ufn(ucg.ufm(a.b("\ue572\u9cc0\u1613\u8866\u03af\u851b", 1555752216)).put(a.c(943068775, "\u1600\u6fbd\ue565\u7b15"), string2))) {
            ucg.ufb(ucg.ufa(), true);
            return;
        }
        ucv.add(string2);
    }

    public static void accept(ubg ubg2) {
        ucs.remove(ubg2);
        if (ubg2.key != null) {
            ucz.put(ubg2.party, ubg2);
        }
        ++udx;
        ucg.ufn(ucg.ufm(a.d("\u2f24\u5697\udc44\u4233\uc9f1\u4f44", 249660738, 100772353)).put(a.d("\u6cac\u150c\u9fcc\u01bb\u8a61", -1171721546, -106389905), ubg2.party));
    }

    public static void decline(ubg ubg2) {
        ucs.remove(ubg2);
        ++udx;
        ucg.ufn(ucg.ufm(a.c(-1850897683, "\u8a8e\uf33e\u79eb\ue795\u6c47\ueaf1\u50a9")).put(a.d("\u795a\u00fa\u8a3a\u144d\u9f97", 1358596396, 1460137987), ubg2.party));
    }

    public static void leave() {
        if (ucg.ufn(ucg.ufm(a.b("\u9ebc\ue704\u6dd3\uf3b5\u7871", -641949995)))) {
            ucg.uek();
            ucg.ufb(wap.s(a.b("\u3fe0\u4667\uccae\u528a\ud911\u5fa9\ue5f9\u6c1a\uf211\u78f4\uff3b\u0547\u8bd5\u1234\u9876\u1e94\ua4dd\u2b01", -1934999637), a.c(-625457952, "\u40e2\u390a\ub7b2\u2dd1\ua67f\u20cd\u9aed\u131f\u8958\u07f1\u802d\u7e4b\uf483\u6d3d\ue71c\u6197")), false);
        }
    }

    public static void kick(ubm ubm2) {
        ucg.ufn(ucg.ufm(a.d("\u72c8\u0b7b\u81a2\u1fdb", -1669726946, -878473287)).put(a.b("\uf490\u8d2d\u07f5\u9985", 142931191), ubm2.code));
    }

    public static void newCode() {
        if (!ucg.ufn(ucg.ufm(a.d("\ucf0d\ub6b7\u3c76\ua213\u29c8\uaf72\u1520", 1205723358, 1522741178)))) {
            ucg.ufb(ucg.ufa(), true);
        }
    }

    public static void reconnect() {
        ucg.uej();
        udj = ucd.OFF;
        udo = 0L;
        udp = 0;
    }

    public static void markKey() {
        Object object;
        Object object2;
        ubj ubj22;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        Entity entity = minecraftClient.method_1560();
        if (minecraftClient.field_1724 == null || minecraftClient.field_1687 == null || entity == null) {
            return;
        }
        if (!ucg.inParty()) {
            ucg.ufc(wap.s(a.c(-1455420972, "\u09b8\u7028\ufae0\u64c5\uef5b\u69ed\ud3f0\u5a40\uc45e\u4ebf\uc97d\u331f\ubdce\u2472\uae62\u2889\u92a0\u1d45\u87ed\u01b0\u884c\uf217\u7cb3\ue731\u611a\uebde\u526e\udc71\u468a\uc0ab\u4b29\ub5eb\u3fa2\ua65e"), a.d("\uda84\ua36c\u2dd4\ub7b8\u3c67\ubec3\u0082\u8d61\u1721\u9d9f\u1a3e\ue035\u6ae0\uf34b\u7d0a\ufbf3\u41bd\uce67\u54d0\ud28f\u5b72\u2533\uafb4\u3431\ub24d\u38e8\u8120\u0f72\u91e6\u17bb\u9837\u66c9\uecf4\u757f", 130464024, 1311008684)));
            return;
        }
        if (!ucg.secured()) {
            ucg.uev();
            ucg.ufc(wap.s(a.d("\u2230\u5bb7\ud16c\u4f00\uc4ca\u427c\uf826\u7190\uef89\u6531\ue2ff\u18dc\u965f\u0ff2\u85ac\u0318\ub907\u36c7\uac67\u2a30\ua3ca\ud9c2\u573a\ucce5\u4a86", -764912477, -150241571), a.b("\uaabc\ud32f\u5999\uc785\u484e\ucae5\u70b7\uf933\u6765\ue9b3\u6a7f\u9001\u1ea4\u876f", -960909660)));
            return;
        }
        long l = System.currentTimeMillis();
        String string = wlk.worldId();
        String string2 = wlk.dimensionId();
        if (udw != null && !udw.danger() && l - udv < 400L && uct.contains(udw)) {
            ucg.udw.kind = 1;
            ucg.udw.born = l;
            ucg.udw.color = -1096636;
            udv = 0L;
            ucg.uee(udw);
            ucg.ueg(a.c(1192402223, "\u9d6d\ue4f9\u6e25\uf05d\u7b88\ufd2e"), null);
            return;
        }
        Vec3d vec3d = entity.method_5836(1.0f);
        Vec3d vec3d2 = entity.method_5828(1.0f);
        ubj ubj3 = null;
        double d = Math.cos(Math.toRadians(2.5));
        for (ubj ubj22 : uct) {
            double d2;
            double d3;
            if (!ubj22.mine || !ucg.visible(ubj22) || (d3 = (object2 = ugg.anchor(ubj22, 1.0f).method_1020(vec3d)).method_1033()) < 0.001 || !((d2 = object2.method_1026(vec3d2) / d3) > d)) continue;
            d = d2;
            ubj3 = ubj22;
        }
        if (ubj3 != null) {
            uct.remove(ubj3);
            object = new JsonObject();
            object.addProperty(a.b("\u3c6f", 1922382874), a.c(924666675, "\u4b40\u32ea\ub83a\u2647\uad83\u2b2b"));
            object.addProperty(a.b("\ubf6a\uc6d6", -262357247), (Number)ubj3.id);
            ucg.ufj((JsonObject)object);
            udw = null;
            ucg.ueg(a.c(2050216759, "\ud364\uaaee\u2023\ube4b\u359b\ub323"), null);
            return;
        }
        object = new ubj();
        ubj22 = hhf.aimed(minecraftClient, 160.0);
        if (ubj22 != null) {
            ((ubj)object).target = hhf.nameOf((PlayerEntity)ubj22);
            ((ubj)object).x = ubj22.method_23317();
            ((ubj)object).y = ubj22.method_23318();
            ((ubj)object).z = ubj22.method_23321();
        } else {
            object2 = entity.method_5745(400.0, 1.0f, false);
            if (object2 == null || object2.method_17783() == HitResult.Type.field_1333) {
                ucg.ufc(wap.s(a.d("\u2fa4\u562e\udcfd\u42c3\uc952\u4fe4\uf5a4\u7c07\ue20c\u68a6\uef3a\u1506\u9bdd\u027f\u8835", 119151263, 1794061664), a.d("\ubff4\uc65f\u4c8f\ud28e\u592b\udf9e\u65cf\ue822\u7269\uf8dc\u7f04\u857b\u0ba3\u9216\u1c5b\u9ebe\u24fe\uab5b\u3587\ub7ca\u3e34\u4412\ucad9\u510a", -2128539552, -774263891)));
                return;
            }
            Vec3d vec3d3 = object2.method_17784();
            ((ubj)object).x = vec3d3.field_1352;
            ((ubj)object).y = vec3d3.field_1351;
            ((ubj)object).z = vec3d3.field_1350;
        }
        ((ubj)object).from = udk;
        ((ubj)object).name = minecraftClient.method_1548().method_1676();
        ((ubj)object).id = ufw.RANDOM.nextInt(Integer.MAX_VALUE);
        ((ubj)object).world = string;
        ((ubj)object).dim = string2;
        ((ubj)object).born = l;
        ((ubj)object).life = Math.round(MARK_TIME.get() * 1000.0);
        ((ubj)object).mine = true;
        object2 = ucg.self();
        ((ubj)object).color = object2 != null ? object2.color : COLORS[0];
        ucg.uef((ubj)object);
        ucg.uee((ubj)object);
        System.out.println(a.c(-1179129077, "\ueb6e\u92ce\u180e\u8679\u0da3\u8b4b\u3155\ub8a8\u26e4\uac4c\u2bd4\ud1f5\u5f3e\uc682\u4cd3\uca24\u706a\uffff\u650d\ue349\u6aea") + Math.round(((ubj)object).x) + a.c(-2010279857, "\u906e") + Math.round(((ubj)object).y) + a.c(1191341364, "\u6d15") + Math.round(((ubj)object).z) + (((ubj)object).target != null ? a.b("\u6ee2\u171c\u9dce\u03f1", -1544851770) + ((ubj)object).target : "") + a.c(-1132331781, "\ufcdf\u8527\u0ff3\u91cc") + string + a.b("\u86e4", 645039813) + string2);
        udw = object;
        udv = l;
        ucg.ueg(((ubj)object).target != null ? a.c(1633200831, "\uaaf7\ud365\u59ba\uc7c3") : a.c(-2016494012, "\ube10\uc798\u4d4c\ud334"), null);
    }

    private static void uee(ubj ubj2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(a.b("\ufd9b", 1478426094), a.b("\u7da6\u041b\u8edb\u10b3", -1413382705));
        jsonObject.addProperty(a.d("\uccb5\ub509", -1667400072, 346862246), (Number)ubj2.id);
        jsonObject.addProperty(a.c(-110346972, "\u3d5d"), (Number)ubj2.x);
        jsonObject.addProperty(a.b("\ubedc", 1546043044), (Number)ubj2.y);
        jsonObject.addProperty(a.b("\u93a2", -857697319), (Number)ubj2.z);
        jsonObject.addProperty(a.b("\u9657", -877488607), ubj2.world);
        jsonObject.addProperty(a.c(2139100089, "\u13dc"), ubj2.dim);
        jsonObject.addProperty(a.d("\u5d3d", -561629143, -51223170), (Number)ubj2.kind);
        jsonObject.addProperty(a.b("\u3511", 832124286), ubj2.name);
        if (ubj2.target != null) {
            jsonObject.addProperty(a.b("\u52dd", 214717100), ubj2.target);
        }
        ucg.ufj(jsonObject);
    }

    private static void uef(ubj ubj2) {
        uct.removeIf(ubj3 -> ubj3.from.equals(ubj2.from) && ubj3.id == ubj2.id);
        int n = 0;
        for (ubj ubj4 : uct) {
            if (!ubj4.from.equals(ubj2.from)) continue;
            ++n;
        }
        if (n >= 3) {
            for (ubj ubj4 : uct) {
                if (!ubj4.from.equals(ubj2.from)) continue;
                uct.remove(ubj4);
                break;
            }
        }
        uct.add(ubj2);
    }

    private static void ueg(String string, Vec3d vec3d) {
        if (!SOUNDS.get()) {
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (vec3d != null && minecraftClient.field_1724 != null) {
            double d;
            Vec3d vec3d2 = minecraftClient.field_1724.method_33571();
            double d2 = vec3d.field_1352 - vec3d2.field_1352;
            double d3 = vec3d.field_1350 - vec3d2.field_1350;
            double d4 = Math.toRadians(minecraftClient.field_1724.method_36454());
            double d5 = -d2 * Math.cos(d4) - d3 * Math.sin(d4);
            double d6 = Math.hypot(d5, d = -d2 * Math.sin(d4) + d3 * Math.cos(d4));
            if (d6 > 1.5) {
                f = (float)(d5 / d6 * 0.85);
                f2 = (float)(-d / d6);
            }
        }
        voa.cue(string, (float)VOLUME.get(), f, f2);
    }

    public static void tick(MinecraftClient minecraftClient) {
        long l = System.currentTimeMillis();
        uct.removeIf(ubj2 -> l - ubj2.born > ubj2.life);
        String string = ucg.relay();
        if (!ENABLED.get() || string.isEmpty()) {
            if (udh != null) {
                ucg.uej();
            }
            udj = ENABLED.get() ? ucd.NO_SERVER : ucd.OFF;
            return;
        }
        if (udh != null && !string.equals(udi)) {
            ucg.uej();
            udo = 0L;
            udp = 0;
            udj = ucd.OFF;
        }
        if (udj == ucd.REPLACED) {
            return;
        }
        if (udh == null) {
            if (l >= udo) {
                ucg.uei(string);
            }
            return;
        }
        if (udj != ucd.ONLINE) {
            return;
        }
        if (l - udq > 25000L) {
            udq = l;
            udh.send(a.c(-816469766, "\ua88e\ud126\u5bf2\uc58a"));
        }
        if (l - udr > 1000L) {
            udr = l;
            ucg.ueh(minecraftClient);
        }
    }

    private static void ueh(MinecraftClient minecraftClient) {
        String string;
        if (!ucg.secured()) {
            return;
        }
        String string2 = minecraftClient.method_1548().method_1676();
        String string3 = wlk.worldId();
        String string4 = wlk.dimensionId();
        String string5 = Cosmetics.shareCode();
        String string6 = udl + a.c(288595394, "\u9dbf") + udf + a.c(760738530, "\uf29f") + string2 + a.c(1609173600, "\u0a1d") + string3 + a.b("\u0d82", -1977283073) + string4 + a.d("\ud480", 269737888, 117312349) + string5;
        if (string6.equals(uds)) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(a.d("\u88cf", 1881689319, 1385677895), string2);
        jsonObject.addProperty(a.b("\u52d8", 2014991022), string3);
        jsonObject.addProperty(a.d("\u5367", -370634754, -348005124), string4);
        if (!string5.isEmpty()) {
            jsonObject.addProperty(a.b("\u48aa", 189614280), string5);
        }
        if ((string = ucg.ufh(a.c(-661584550, "\u052a\u7c9c\uf647") + udl + a.c(92065336, "\uce45") + udk, jsonObject)) != null && ucg.ufn(ucg.ufm(a.b("\u369c\u4f2a\uc5ec\u5b88\ud05e\u56e9", 546256617)).put(a.c(-188813788, "\uee56"), string))) {
            uds = string6;
        }
    }

    private static void uei(String string) {
        URI uRI;
        try {
            ucg.ufu();
            uRI = ucg.uri(string, udb, udd);
        }
        catch (Exception exception) {
            udj = ucd.RETRY;
            udn = wap.s(a.d("\u2efd\u576f\uddb9\u438c\uc808\u4eaf\uf4eb\u7d1e\ue352\u69f4\uee75\u1445\u9a97\u0326\u8963\u0f85\ub5dc\u3a0d", 627487357, -1087267632), a.c(896299574, "\u763d\u0fa4\u8570\u1b06\u90a4\u1668\uac4d\u25ce\ubf88\u3129\ub6fe\u4cfb\uc259\u5b9c\ud5ae\u573e\ued05\u62a1\uf860\u7e36\uf7b4\u8d95")) + a.c(-2079809720, "\u9f70\ue6db") + exception.getMessage();
            udo = System.currentTimeMillis() + 60000L;
            return;
        }
        udj = ucd.CONNECTING;
        udi = string;
        uds = null;
        udh = new uhg(uRI, new ubd());
        ++udx;
    }

    static URI uri(String string, String string2, String string3) {
        String string4 = string.trim();
        while (string4.endsWith(a.d("\u218c", 857071688, -1719287318))) {
            string4 = string4.substring(0, string4.length() - 1);
        }
        if (string4.startsWith(a.c(1575317668, "\u70c4\u0969\u83ba\u1dcf\u961b\u10e3\uaaa5\u2354"))) {
            string4 = a.b("\u428c\u3b39\ub1ea\u2fd2\ua410\u22a1", -797097219) + string4.substring(8);
        } else if (string4.startsWith(a.d("\uca64\ub3c9\u391a\ua76f\u2cf2\uaa56\u1005", -1667171017, 2056206140))) {
            string4 = a.d("\u99e1\ue054\u6ace\uf4aa\u7f7d", -1656623614, 133003153) + string4.substring(7);
        } else if (!string4.startsWith(a.b("\u151e\u6cab\ue678\u7840\uf382\u7533", -335604369)) && !string4.startsWith(a.c(1974744584, "\u367a\u4fcf\uc555\u5b31\ud0e6"))) {
            string4 = a.b("\u04ba\u7d0f\uf7dc\u69e4\ue226\u6497", 112592075) + string4;
        }
        if (!string4.endsWith(a.d("\u0f68\u7681\ufc56", 2094417396, -1788261712))) {
            string4 = string4 + a.b("\u1374\u6a9d\ue04a", 392631128);
        }
        return URI.create(string4 + a.c(-827551249, "\u91d9\ue821\u62b9\ufcc7\u7704\uf1f8\u4ba5\uc248\u5c53") + string2 + a.b("\ub59f\ucc78\u46ae\ud8c8\u5340", 504411580) + string3);
    }

    private static void uej() {
        if (udh != null) {
            uhg uhg2 = udh;
            udh = null;
            uhg2.close();
        }
        udk = null;
        udl = null;
        udm = null;
        ucr.clear();
        uct.removeIf(ubj2 -> !ubj2.mine);
        ucs.clear();
        ucv.clear();
        ucw.clear();
        ucx.clear();
        ++udx;
    }

    private static void uek() {
        udl = null;
        udm = null;
        ucr.clear();
        uct.removeIf(ubj2 -> !ubj2.mine);
        ucw.clear();
        ucx.clear();
        ucy.clear();
        udy = null;
        ucu.clear();
        ude = null;
        udf = 0;
        uds = null;
        ucg.ufv();
        ++udx;
    }

    /*
     * Exception decompiling
     */
    private static void uel(JsonObject var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static void uem(JsonObject jsonObject) {
        boolean bl;
        ubm ubm2;
        String string = ucg.ufq(jsonObject, a.c(232011783, "\u386c\u41d0"));
        if (string == null) {
            if (udl != null || ude != null) {
                ucg.uek();
            }
            return;
        }
        boolean bl2 = !string.equals(udl);
        HashSet<String> hashSet = new HashSet<String>();
        if (!bl2) {
            for (ubm object22 : ucr) {
                hashSet.add(object22.code);
            }
        }
        udl = string;
        udm = ucg.ufq(jsonObject, a.d("\u9d44\ue4fc\u6e2b\uf05f\u7b89\ufd2f", -1794037002, -602949672));
        if (!string.equals(ude)) {
            ubg ubg2 = ucz.remove(string);
            if (ubg2 != null) {
                ucg.ufd(string, ubg2.epoch, ubg2.key);
            } else if (udg != null && udk != null && udk.equals(udm)) {
                ucg.ufd(string, 1, udg);
            } else {
                ucu.clear();
                ude = null;
                udf = 0;
            }
            udg = null;
            ucz.clear();
        }
        ucr.clear();
        int n = 0;
        for (JsonElement jsonElement : ucg.ufp(jsonObject, a.c(1209103821, "\u75a7\u0c1e\u86c5\u18bb\u936b\u15cd\uaf9f"))) {
            if (!jsonElement.isJsonObject()) continue;
            JsonObject jsonObject2 = jsonElement.getAsJsonObject();
            ubm ubm3 = new ubm();
            ubm3.code = ucg.ufq(jsonObject2, a.d("\uffe4\u8659\u0c81\u92f1", 1257698033, 464063858));
            if (ubm3.code == null) continue;
            ubm3.online = ucg.ufr(jsonObject2, a.d("\uf981\u8031\u0ae0\u9494\u1f44\u99fe", 2019226283, 1642990403));
            ubm3.pub = ucg.ufq(jsonObject2, a.c(-1795488763, "\u0476\u7dc2\uf706"));
            ubm3.fingerprint = ubm3.pub != null ? ufw.fingerprint(ubm3.pub) : null;
            ubm3.color = COLORS[n++ % COLORS.length];
            ucg.ueo(ubm3, ucg.ufq(jsonObject2, a.d("\u7fe7", -1412333055, -1509687916)));
            if (ubm3.code.equals(udk)) {
                ubm3.name = MinecraftClient.method_1551().method_1548().method_1676();
            }
            if (ubm3.name == null) {
                ubm3.name = ucg.pretty(ubm3.code);
            }
            ucr.add(ubm3);
        }
        for (ubj ubj2 : uct) {
            ubm ubm4 = ucg.member(ubj2.from);
            if (ubm4 == null || ubj2.danger()) continue;
            ubj2.color = ubm4.color;
        }
        ucg.uer();
        for (ubm ubm5 : ucr) {
            if (!ubm5.sealed || ubm5.code.equals(udk)) continue;
            ucg.ueo(ubm5, ubm5.blob);
            if (ubm5.name != null) continue;
            ubm5.name = ucg.pretty(ubm5.code);
        }
        if (!ucg.secured() && ucr.size() > 1) {
            ucg.uev();
        }
        if (ucg.isLeader() && ucg.secured()) {
            for (ubm ubm6 : ucr) {
                if (!ubm6.sealed || !ubm6.online || ubm6.code.equals(udk)) continue;
                ucg.uet(ubm6);
            }
        } else if (ucg.secured() && (ubm2 = ucg.member(udm)) != null && ubm2.sealed && ubm2.online) {
            ucg.uev();
        }
        boolean bl3 = false;
        for (String string2 : hashSet) {
            if (ucg.member(string2) != null) continue;
            bl = true;
            break;
        }
        if (bl && ucg.isLeader() && ucg.secured()) {
            ucg.ueu();
        }
        if (bl2 && ucr.size() > 1) {
            ucg.ufb(wap.s(a.b("\uaee5\ud762\u5dab\uc38f\u4819\ucebb\u74ff\ufd4b\u635d\ue9eb\u6e76\u9446\u1ad0\u8331\u0973\u8f91\u35d8\uba04", 540323502), a.b("\uab4c\ud2a4\u5c1c\uc67f\u49ba\ucb14\u7148\uf8cb\u66ee", 721334103)), false);
            ucg.ueg(a.d("\ua88f\ud11b\u5bce\uc5b8", -1872309860, -447186595), null);
        } else if (!bl2) {
            for (ubm ubm7 : ucr) {
                if (hashSet.contains(ubm7.code) || ubm7.code.equals(udk)) continue;
                ucg.ufb(wap.s(a.d("\u5fc2\u264f\uac9e\u32e7\ub93a\u3f8a\u85d2\u0c66\u9273\u18c7\u9f12\u6564\uebb8\u7208\uf81f\u7eba\uc4e9\u4b35\ud1c3\u57c2\ude24\ua466\u2ad3\ub10f", -1732892488, 661288753), a.d("\u33fa\u4e79\uc0b5\u5ecb\ud56e\u53a5\uedee\u6002\ufe5e\u74e3\uf349\u094a\u8384\u1e56\u9401\u1287\ua8b9\u276b\ubda7\u3bf3\ub206", 1010525076, 1309627497)), false);
                ucg.ueg(a.b("\ucbb4\ub220\u38f5\ua683", 394185722), null);
            }
        }
        ucg.uex();
        ucg.uen();
    }

    private static void uen() {
        if (udl == null) {
            return;
        }
        if (!udl.equals(udy)) {
            ucy.clear();
            udy = udl;
        }
        for (ubm ubm2 : ucr) {
            if (ubm2.code.equals(udk) || ubm2.sealed || ubm2.blob == null || ubm2.name == null || ubm2.name.equals(ucg.pretty(ubm2.code)) || !ucy.add(ubm2.name.toLowerCase(Locale.ROOT)) || !hhf.add(ubm2.name)) continue;
            System.out.println(a.b("\ufff9\u8659\u0c99\u92ee\u1934\u9fdc\u25c2\uac3b\u326c\ub8d2\u3f06\uc560\u4be5", -1725169788) + ubm2.name + a.d("\ub639\ucfc9\u451f\udb6e\u50b8\ud608\u6c1f\ue5ba\u7bfe\uf100\u7695\u8cf0\u023c\u9b81\u11d9\u9722\u2d7a", -1160025395, 785177797));
            izx.alert(ubm2.name, wap.s(a.c(-1839272840, "\uec30\u95b5\u1f7d\u8100\u0adc\u8c67\u3670\ubf89\u218e\uab2e\u2cee\ud699\u5843\uc1a2"), a.d("\uebc1\u9224\u18f4\u86f5\u0931\u8f88\u31cc\ub832\u261f\uacd4\u2f16", 1228766420, 1596756746)), vhz.FRIENDS, true);
        }
    }

    private static void ueo(ubm ubm2, String string) {
        ubm2.blob = string;
        if (string == null) {
            return;
        }
        JsonObject jsonObject = ucg.ufi(a.d("\u2349\u5aff\ud024", -2131953694, -1070213925) + udl + a.c(-934315034, "\u7b9b") + ubm2.code, string);
        if (jsonObject == null) {
            ubm2.sealed = true;
            return;
        }
        ubm2.sealed = false;
        ubm2.name = ucg.ufk(ucg.ufq(jsonObject, a.d("\ubf3b", 866537257, 1266020477)));
        ubm2.world = ucg.ufq(jsonObject, a.d("\udd50", 1672495030, -906960240));
        ubm2.dim = ucg.ufq(jsonObject, a.c(-454085540, "\u3439"));
        String string2 = ucg.ufl(ucg.ufq(jsonObject, a.b("\u0eec", 634523278)));
        ubm2.cosmetics = string2 != null && string2.length() <= 1000 ? string2 : null;
    }

    private static void uep(JsonObject jsonObject) {
        int n;
        byte[] byArray;
        String string = ucg.ufq(jsonObject, a.c(480155086, "\u95a9\uec14\u66cc\uf8bc"));
        String string2 = ucg.ufq(jsonObject, a.d("\u9eae\ue71a\u6dde", -238690597, 1506557958));
        if (string == null || string2 == null || !ucv.remove(string)) {
            return;
        }
        if (ucg.inParty()) {
            if (!ucg.secured()) {
                ucg.uev();
                ucg.ufb(wap.s(a.b("\uf8f6\u8171\u0baa\u95c6\u1e0c\u98ba\u22e0\uab56\u354f\ubff7\u3839\uc21a\u4c99\ud534\u5f6a\ud9de\u63c1\uec01\u76a1\uf0f6\u790c\u0304\u8dfc\u1623\u9040\u1ac4\ua37b\u2d7e\ub78f\u31d5\uba3f\u44af\ucee6\u5711\ud14a\u5bfc", 1387853957), a.d("\ub638\ucfab\u451d\udb01\u54ca\ud661\u6c33\ue5b7\u7be1\uf537\u76fb\u8c85\u0220\u9beb\u15ac\u9351\u2d01\ua2d1\u3863\ube4d\u37c4\u4d9a\uc35b\u58f0\udef4\u5452\ue9f4\u63b0\uf93b\u7f72\uf0b0\u0a01\u803e\u19c8", 1267966958, -1048768030)), true);
                return;
            }
            byArray = ucu.get(udf);
            n = udf;
        } else {
            if (udg == null) {
                udg = ufw.randomKey();
            }
            byArray = udg;
            n = 1;
        }
        String string3 = ucg.uff(string, string2, byArray, n);
        if (string3 == null) {
            ucg.ufb(wap.s(a.b("\u5385\u2a1f\ua0c1\u3ea1\ub57d\u33c5\u8992~\u9e27\u1497\u930a\u693d\ue7ed\u7e54\uf402\u72fa\uc8b4", 121918417), a.c(1060484968, "\ub367\uca80\u4023\ude5b\u5587\ud33c\u6d7f\ue0e6\u7ec9\uf404\u73d3\u89dc\u0707\u9eb4\u14ea\u921e\u2826")), true);
            return;
        }
        ucg.ufn(ucg.ufm(a.c(1845064652, "\u73a3\u0a15\u80de\u1eb0\u957a\u13da")).put(a.d("\uaf70\ud6cd\u5c15\uc265", -916492147, -410132582), string).put(a.d("\uf123\u889f\u025b", 1390307510, 1703451124), string3));
    }

    private static ubg ueq(JsonObject jsonObject) {
        String string = ucg.ufq(jsonObject, a.d("\uf1dd\u887d\u02bd\u9cca\u1710", 692882414, -1739883962));
        String string2 = ucg.ufq(jsonObject, a.c(710334805, "\ud937\ua092\u2a5c\ub42f"));
        String string3 = ucg.ufq(jsonObject, a.d("\u46f8\u3f4c\ub588", 1564022613, -414494242));
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        ubg ubg2 = new ubg();
        ubg2.party = string;
        ubg2.from = string2;
        ubg2.pub = string3;
        ubg2.fingerprint = ufw.fingerprint(string3);
        long l = jsonObject.has(a.c(-51630087, "\u2f96\u5639")) ? jsonObject.get(a.c(-1477948808, "\u4a17\u33b8")).getAsLong() : 120000L;
        ubg2.until = System.currentTimeMillis() + Math.min(l, 120000L);
        JsonObject jsonObject2 = ucg.ufg(string2, string3, ucg.ufq(jsonObject, a.d("\u0e5e\u77e2\ufd26", -703467185, -838074512)));
        if (jsonObject2 != null) {
            ubg2.name = ucg.ufk(ucg.ufq(jsonObject2, a.b("\ubfcf", 631095200)));
            ubg2.key = ucg.uft(jsonObject2, a.b("\u67d8", 1877108658));
            int n = ubg2.epoch = jsonObject2.has(a.c(-1087966319, "\uf3f5")) ? jsonObject2.get(a.b("\u7ad6", 1477081778)).getAsInt() : 1;
        }
        if (ubg2.name == null) {
            ubg2.name = ucg.pretty(string2);
        }
        return ubg2;
    }

    private static void uer() {
        if (ucw.isEmpty() || udl == null) {
            return;
        }
        ArrayList<ubs> arrayList = new ArrayList<ubs>(ucw);
        ucw.clear();
        for (ubs ubs2 : arrayList) {
            ubm ubm2 = ucg.member(ubs2.from());
            if (ubm2 == null || ubm2.pub == null) {
                if (!ucr.isEmpty()) continue;
                ucw.add(ubs2);
                continue;
            }
            JsonObject jsonObject = ucg.ufg(ubm2.code, ubm2.pub, ubs2.box());
            byte[] byArray = jsonObject != null ? ucg.uft(jsonObject, a.d("\u463c", -626217581, 1104931781)) : null;
            if (byArray == null || byArray.length != 32) continue;
            int n = jsonObject.has(a.d("\ued9f", 222481316, -219732385)) ? jsonObject.get(a.b("\u046a", -329579506)).getAsInt() : 1;
            boolean bl = ubm2.code.equals(udm);
            if (ucg.secured() && !bl && n <= udf) {
                System.out.println(a.d("\uad17\ud4b7\u5e77\uc000\u4bda\ucd32\u772a\ufed5\u6096\uea7e\u6deb\u978e\u1944\u80f7\u0ae9", -1961329465, -7024209) + ubm2.name + a.c(-1193532603, "\u2375\u5a8d\ud050\u4e28\uc5fe\u4352\uf916\u70e6\ueee7\u644c\ue3da\u19be\u9776\u0ecb\u8493\u022a") + n + a.d("\ue47d\u9dc0\u175c\u8937\u02e7\u8457\u3e57", -951616276, 1306892474) + udf);
                continue;
            }
            System.out.println(a.b("\u0601\u7fa1\uf561\u6b16\ue0cc\u6624\udc3c\u55c3\ucb80\u4168\uc6fd\u3c98\ub252\u2be1\ua1ff", -1288960386) + ubm2.name + (bl ? a.d("\u94cf\ued76\u67e1\uf999\u724a\uf4fe\u4eac\uc74a\u594e", 54935476, 1167174482) : "") + a.d("\u4a88\u3335\ub9a3\u27c7\uac0f\u2ab2\u90ea\u1953", 1293059768, -1912484844) + n);
            if (!udl.equals(ude)) {
                ucu.clear();
                udf = 0;
            }
            ude = udl;
            ucu.put(n, byArray);
            if (n >= udf) {
                udf = n;
            }
            ucg.ufe();
            uds = null;
            ucg.ufv();
        }
    }

    private static void ues(String string) {
        ubm ubm22;
        if (string == null || !ucg.secured() || ucg.member(string) == null) {
            return;
        }
        String string2 = null;
        ubm ubm3 = ucg.member(udm);
        if (ubm3 != null && ubm3.online && !ubm3.code.equals(string)) {
            string2 = ubm3.code;
        } else {
            for (ubm ubm22 : ucr) {
                if (!ubm22.online || ubm22.code.equals(string)) continue;
                string2 = ubm22.code;
                break;
            }
        }
        if (!Objects.equals(string2, udk)) {
            return;
        }
        ubm ubm4 = ucg.member(string);
        ubm ubm5 = ubm22 = ubm4.pub != null ? ucg.uff(ubm4.code, ubm4.pub, ucu.get(udf), udf) : null;
        if (ubm22 != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.c(718353779, "\u3505\u4caf"), ubm4.code);
            jsonObject.addProperty(a.d("\uf4ba\u8d06\u07c2", 638702489, -351459518), (String)((Object)ubm22));
            JsonArray jsonArray = new JsonArray();
            jsonArray.add((JsonElement)jsonObject);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(a.b("\ue1cb", -618470978), a.d("\u4723\u3e9c\ub453\u2a28", 88882088, 1933540580));
            jsonObject2.add(a.b("\uf101\u88bd\u0279\u9c15\u17d4", -1606553242), (JsonElement)jsonArray);
            ucg.ufo(jsonObject2);
        }
    }

    private static void uet(ubm ubm2) {
        long l = System.currentTimeMillis();
        Long l2 = uda.get(ubm2.code);
        if (ubm2.pub == null || l2 != null && l - l2 < 5000L) {
            return;
        }
        uda.put(ubm2.code, l);
        String string = ucg.uff(ubm2.code, ubm2.pub, ucu.get(udf), udf);
        if (string == null) {
            return;
        }
        System.out.println(a.b("\u5afc\u235c\ua99c\u37eb\ubc31\u3ad9\u80c1\u093e\u977d\u1d95\u9a15\u6072\ueeae\u7705\ufd02\u7ba7\uc1f3\u4e6d", 163338910) + ubm2.name + a.c(209410092, "\u5808\u21b5\uab23\u3547\ube8f\u3832\u826a\u0bd3") + udf);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(a.d("\ufe10\u87ba", -789603430, 1647535612), ubm2.code);
        jsonObject.addProperty(a.d("\u9714\ueea8\u646c", 244818284, -2055653863), string);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement)jsonObject);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(a.d("\u09db", -1127566947, -1806583757), a.c(493089885, "\uf432\u8d8d\u0742\u9939"));
        jsonObject2.add(a.d("\u5505\u2cb9\ua67d\u3811\ub3d0", -708313941, 1786423753), (JsonElement)jsonArray);
        ucg.ufo(jsonObject2);
    }

    private static void ueu() {
        byte[] byArray = ufw.randomKey();
        int n = udf + 1;
        JsonArray jsonArray = new JsonArray();
        for (ubm ubm2 : ucr) {
            String string;
            if (ubm2.code.equals(udk) || ubm2.pub == null || (string = ucg.uff(ubm2.code, ubm2.pub, byArray, n)) == null) continue;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.b("\ub2da\ucb70", 1370206892), ubm2.code);
            jsonObject.addProperty(a.b("\ua247\udbfb\u513f", 1503437350), string);
            jsonArray.add((JsonElement)jsonObject);
        }
        ucu.put(n, byArray);
        udf = n;
        ucg.ufe();
        uds = null;
        ucg.ufv();
        if (!jsonArray.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.b("\u8184", 461275633), a.d("\ue6c2\u9f7d\u15b2\u8bc9", -1253718917, -1449319722));
            jsonObject.add(a.c(-1469888047, "\u49b6\u300a\ubace\u24a2\uaf63"), (JsonElement)jsonArray);
            ucg.ufo(jsonObject);
        }
    }

    private static void uev() {
        long l = System.currentTimeMillis();
        if (ucg.inParty() && l - udt > 10000L) {
            udt = l;
            ucg.ufn(ucg.ufm(a.c(-1368825945, "\u5fce\u2674\uaca7\u32d7\ub90f\u3fb0\u85ff")));
        }
    }

    private static void uew(String string, String string2) {
        if (string == null || string2 == null) {
            return;
        }
        if (!ucg.uey(string, string2, System.currentTimeMillis())) {
            ucx.add(new ubx(string, string2, System.currentTimeMillis()));
            while (ucx.size() > 32) {
                ucx.removeFirst();
            }
        }
    }

    private static void uex() {
        if (ucx.isEmpty()) {
            return;
        }
        long l = System.currentTimeMillis();
        ArrayList<ubx> arrayList = new ArrayList<ubx>(ucx);
        ucx.clear();
        for (ubx ubx2 : arrayList) {
            if (l - ubx2.at() < 15000L && ucg.ufi(a.d("\u5aab\u2304\ua9c3\u37a9", 1240828612, -693448698) + udl + a.b("\u29fa", 1916021127) + ubx2.from(), ubx2.c()) != null) {
                System.out.println(a.d("\ufdbb\u841b\u0edb\u90ac\u1b76\u9d9e\u2780\uae79\u3030\uba81\u3d40\uc737\u49e2\ud016\u5a03\udce6\u66b4\ue967\u7399", -725496307, -925158443) + ucg.pretty(ubx2.from()) + a.c(-2085343544, "\u2ee4\u5707\uddc3\u43b6\uc864\u4e91\uf48e\u7d72\ue338\u6998\uee02\u147f") + (l - ubx2.at()) + a.d("\u1c2b\u65d7\uef1a\u7138\ufaae\u7c18\uc659\u4fb9\ud1f1\u5b12\udc88\u26e4\ua867\u3195\ubbc4\u3d39\u877e", 933241639, -1999945923));
                ucg.uey(ubx2.from(), ubx2.c(), ubx2.at());
                continue;
            }
            if (l - ubx2.at() >= 15000L) continue;
            ucx.add(ubx2);
        }
    }

    private static boolean uey(String string, String string2, long l) {
        JsonObject jsonObject;
        ubm ubm2 = ucg.member(string);
        if (ubm2 == null) {
            System.out.println(a.d("\ud7b9\uae19\u24d9\ubaae\u3174\ub79c\u0d82\u847b\u1a32\u9083\u1742\ued35\u63e0\ufa14\u7001\uf6e4\u4cb6\uc365\u599b", 1481048882, -887827224) + ucg.pretty(string) + a.d("\uf635\u8fd3\u051f\u9b69\u10f1\u9609\u2c40\ua5ac\u3bba\ub158\u36df\ucce7\u4237\udbc8\u51d4\ud73f\u6d77\ue2f4\u780b\ufe5f\u77b2\u0de4\u830f\u18d2\u9eec\u142f\uad84\u23d7\ub927\u3f7f\ub48b\u4a1c\uc05a\u59b6\udfb7\u554f\uea85", -1317949243, 1105020661));
            uds = null;
            udr = 0L;
        }
        if ((jsonObject = ucg.ufi(a.b("\u9b33\ue29c\u685b\uf631", -445605030) + udl + a.b("\u819d", 1687716320) + string, string2)) == null) {
            long l2 = System.currentTimeMillis();
            if (l2 - udu > 3000L) {
                udu = l2;
                System.out.println(a.c(1064012635, "\u8b3a\uf29a\u785a\ue62d\u6df7\ueb1f\u510f\ud8fc\u46ac\ucc54\u4bd4\ub1f1\u3f74\ua6d2\u2c85\uaa71\u107a") + (ubm2 != null ? ubm2.name : ucg.pretty(string)) + a.b("\u435b\u3abe\ub03e\u2e02\ua5dd\u237a\u9929\u10ca\u8e93\u0420\u83b6", 76497783) + string2.substring(0, Math.max(0, string2.indexOf(46))) + a.b("\u6cfb\u1546\u9fda\u01b1\u8a61\u0cd1\ub6d1\u3f65\ua12f\u2b81\uac5e\u5624\ud8bb", 908487898) + udf + a.c(1993638936, "\u8439") + ucu.keySet() + (udl != null && udl.equals(ude) ? "" : a.c(1310200806, "\u13d1\u6a68\ue0f8\u7e87\uf54c\u73a4\uc9b8\u4040\ude59\u54a9\ud375\u2905\ua7c9\u3e64\ub43a\u32dc\u88c1\u0740\u9de2\u1ba0\u9251\ue80d\u66ee")));
            }
            if (ubm2 != null && ucg.isLeader() && ucg.secured()) {
                ucg.uet(ubm2);
            } else {
                ucg.uev();
            }
            return false;
        }
        if (ubm2 == null) {
            ubm2 = new ubm();
            ubm2.code = string;
            ubm2.name = ucg.pretty(string);
            ubm2.color = COLORS[ucr.size() % COLORS.length];
        }
        String string3 = ucg.ufq(jsonObject, a.b("\u3d24", -1102234287));
        if (a.c(1888864260, "\uc877\ub1dd\u3b0d\ua570\u2eb4\ua81c").equals(string3)) {
            int n = jsonObject.has(a.b("\u818e\uf832", 2081849829)) ? jsonObject.get(a.c(-1138001272, "\u7ae3\u035f")).getAsInt() : -1;
            uct.removeIf(ubj2 -> !ubj2.mine && ubj2.from.equals(string) && ubj2.id == n);
            return true;
        }
        if (!a.c(1163071052, "\u0e25\u7798\ufd58\u6330").equals(string3)) {
            return true;
        }
        ubj ubj3 = new ubj();
        ubj3.from = string;
        ubj3.name = Objects.requireNonNullElse(ucg.ufk(ucg.ufq(jsonObject, a.c(2031128102, "\u8e49"))), ubm2.name);
        ubj3.id = jsonObject.has(a.b("\uec36\u958a", 1583148125)) ? jsonObject.get(a.d("\u03a3\u7a1f", 1673600585, -1482154623)).getAsInt() : 0;
        ubj3.x = ucg.ufs(jsonObject, a.b("\ud7fb", 1022547842));
        ubj3.y = ucg.ufs(jsonObject, a.d("\u4afa", 1457857990, 790785860));
        ubj3.z = ucg.ufs(jsonObject, a.b("\ue1fa", 1703338369));
        if (!Double.isFinite(ubj3.x) || !Double.isFinite(ubj3.y) || !Double.isFinite(ubj3.z) || Math.abs(ubj3.x) > 3.1E7 || Math.abs(ubj3.z) > 3.1E7 || Math.abs(ubj3.y) > 100000.0) {
            return true;
        }
        ubj3.world = ucg.ufq(jsonObject, a.d("\u74eb", 874631018, -83772425));
        ubj3.dim = ucg.ufq(jsonObject, a.b("\ufb82", 624819175));
        ubj3.kind = jsonObject.has(a.c(887694828, "\u2586")) && jsonObject.get(a.c(1534983530, "\ufd00")).getAsInt() == 1 ? 1 : 0;
        ubj3.target = ucg.ufk(ucg.ufq(jsonObject, a.c(22947168, "\u2511")));
        ubj3.born = l;
        ubj3.life = Math.round(MARK_TIME.get() * 1000.0);
        ubj3.color = ubj3.danger() ? -1096636 : ubm2.color;
        String string4 = MinecraftClient.method_1551().method_1548().method_1676();
        if (ubj3.target != null && ubj3.target.equalsIgnoreCase(string4)) {
            ucg.ufc(ubj3.name + (ubj3.danger() ? wap.s(a.c(-912299550, "\u69db\u103d\u9af8\u049a\u8f51\u09fd\ub3e7\u3a0c\ua40a\u2ead\ua964\u5340\uddd6\u4474\uce30\u4884\uf282\u7d54\ue7a9\u61bc\ue84e\u9210\u1caa\u8779\u0111"), a.d("\ub5f6\uc858\u42f4\udcf0\u5726\ud1e0\u6bcf\ue241\u7c6b\uf6d9\u7108\u8b7d\u05af\u9c69\u1242\u94a9\u2af4\ua55c\u3b84\ub9c7\u3422\u4a6d\uc4df\u5f01\ud90f\u53a2\uea12\u643c\ufec8\u78e3", -449334283, -1490614723)) : wap.s(a.c(1734139359, "\uddf4\ua408\u2ed7\ub0b5\u3b7b\ubdc4\u0796\u8e23\u1025\u9a82\u1d4b"), a.d("\u318a\u4c25\uc68a\u5885\ud35b\u559d\uefb4\u6646\ufc02\u72a1\uf570\u0f70", -381938098, -1965021208))));
            ucg.ueg(ubj3.danger() ? a.d("\u4b09\u329d\ub841\u2639\uadec\u2b4a", -1702779158, 1913515425) : a.d("\ufb73\u82e1\u083e\u9647", 2099081318, -452162723), null);
            return true;
        }
        ucg.uef(ubj3);
        boolean bl = ucg.visible(ubj3);
        System.out.println(a.c(-1276939888, "\u71f0\u0850\u8290\u1ce7\u973d\u11d5\uabcb\u2236\ubc7a\u36d2\ub14a\u4b7d\uc5be\u5c12\ud643\u50ff") + ubj3.name + (bl ? a.b("\u1cad\u654f\uef87\u71f1\ufa3e\u7c96", 1606098059) : a.d("\ue2ad\u9b54\u1186\u8ffa\u042d\u829d\u38c5\ub160\u2f25\ua5c0\u220f\ud873\u56a8\ucf02\u4550\uc3f2", -677880369, 399097682) + ubj3.world + a.c(2078797588, "\uef35") + ubj3.dim + a.b("\u66ef\u1f52\u95ce\u0ba5\u8075\u06c5\ubcc5", 838166212) + wlk.worldId() + a.b("\ub261", -12406208) + wlk.dimensionId()));
        if (bl) {
            ucg.ueg(ubj3.danger() ? a.d("\u68dd\u1149\u9b95\u05ed\u8e38\u089e", -250277879, -684033898) : (ubj3.target != null ? a.c(-799743579, "\ue1ed\u987f\u12a0\u8cd9") : a.d("\ude06\ua78e\u2d5a\ub322", 680133214, 841538572)), ugg.anchor(ubj3, 1.0f));
        } else if (!Objects.equals(ubj3.dim, wlk.dimensionId())) {
            ucg.ufc(ubj3.name + wap.s(a.d("\u8b4a\uf2b6\u7869\ue60b\u6dc5\ueb7a\u5128\ud89d\u4691\ucc3c\u4bed\ub194\u3f52\ua6ff\u2cad\uaa5b\u101d\u9f8b\u0571\u8327\u0a9e\u708e\ufe32\u65e2\ue386\u694b\ud0f5\u5eb3\uc416\u4203\uc9bd\u3768\ubd2f\u24d5\ua29b\u2830\u97e1\u1d91", 1846823731, 776781951), a.d("\u214d\u5ce3\ud631\u483f\uc3eb\u4528\uff79\u7682\ue8de\u6674\ue5bb\u1fc3\u9163\u08aa\u8280\u0012\ube4f\u358c\uab2b\u2d0e\ua4fa\udedb\u5065\ucbb6\u49d5\uc71c\u7ea0\uf0fa\u6a04\uec20\u67e6\u993f\u1375\u8a84", -2080034760, 928649591)));
        } else {
            ucg.ufc(ubj3.name + wap.s(a.d("\ub4d9\ucd25\u47fa\ud998\u5256\ud4e9\u6ebb\ue70e\u7902\uf3af\u747e\u8e07\u00c1\u996c\u133e\u95c8\u2f8e\ua018\u3ae4\ubcb4\u350d\u4f1d\uc1a1\u5a71\udc15\u56d8\uef66\u6120\ufb85\u7d87\uf622\u08e4\u82af\u1b4d\u9d09", -740283824, -1599103350), a.b("\ub302\uceac\u447e\uda70\u51a4\ud767\u6d36\ue4cd\u7a91\uf43b\u77f4\u8d8c\u032c\u9ae5\u10cf\u925d\u2c0f\ua3d3\u3d70\ubf35\u36b6\u4ce4\uc227\u59fb\udf86\u514b\uec99\u62bc\uf83e\u7e1d\uf5a9\u0b0d\u8137", -2116177149)));
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    private static String uez(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static String ufa() {
        return udj == ucd.NO_SERVER ? wap.s(a.d("\u107a\u69fd\ue33f\u7d1a\uf699\u7034\uca6a\u43de\uddd1\u5771\ud0b1\u2ac6\ua41c\u3df4\ub7f4\u3113\u8b4b\u049e\u9e3e\u1878\u91dd\uebca\u6576\ufebc\u78c2\uf214", -1612297663, 1967020658), a.c(911845268, "\ua3ae\uda03\u50dd\ucedb\u457b\uc3c1\u7999\uf478\u6e44\ue48c\u6355\u9922\u17fb\u8e30\u0414\u86f0\u38de\ub77b\u2dbd\uab9e\u226e\u584a\ud299\u4d57\ucb27\u4184\uf84d")) : wap.s(a.c(-1600476692, "\ua983\ud013\u5adb\uc4fe\u4f6a\uc9d7\u7385\ufa74\u6420\uee97\u6953\u9333\u1de5\u8410\u0e17\u88fd\u32fd\ubd78\u27d7\ua18b\u2839\u5238\udc9a\u4758\uc121\u4bfd\uf217\u7c15\ue6f4\u60b2\ueb05\u15c7\u9f9f"), a.d("\u7042\u09db\u837f\u196c\u96da\u1018\uaa36\u23bf\ubdef\u3346\ub0f4\u4ee4\uc452\u5d97\ud7b1\u5132\ueb7a\u64de\ufe13\u7840\uf5ab\u8be5\u0559\u9efa\u18ff", 392071030, -899812560));
    }

    private static void ufb(String string, boolean bl) {
        udz = string;
        uea = bl;
        ++ueb;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (!(minecraftClient.field_1755 instanceof hlc) && minecraftClient.field_1687 != null) {
            izx.alert(wap.s(a.d("\u896f\uf0ef\u7a2f\ue458\u6f82", -1940308102, 1139062336), a.d("\uab53\ud2cd\u586c\uc667", -1262502738, 297341926)), string, vhz.FRIENDS, !bl);
        }
    }

    private static void ufc(String string) {
        izx.alert(wap.s(a.c(-568203025, "\ue8ba\u913a\u1bfa\u858d\u0e57"), a.d("\uee8e\u9710\u1db1\u83ba", 2116546724, -391636431)), string, vhz.FRIENDS, true);
    }

    private static void ufd(String string, int n, byte[] byArray) {
        ucu.clear();
        ude = string;
        udf = n;
        ucu.put(n, byArray);
        uds = null;
        ucg.ufv();
    }

    private static void ufe() {
        while (ucu.size() > 3) {
            ucu.remove(((TreeMap)ucu).firstKey());
        }
    }

    private static String uff(String string, String string2, byte[] byArray, int n) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.d("\u3c89", -1628388570, 664338373), ufw.b64(byArray));
            jsonObject.addProperty(a.d("\u88a0", 1904953047, -1038889453), (Number)n);
            jsonObject.addProperty(a.b("\u31d7", -1492635208), MinecraftClient.method_1551().method_1548().method_1676());
            byte[] byArray2 = ufw.boxKey(udc, udd, string2);
            return ufw.seal(byArray2, a.c(-1790445640, "\uf7de\u8e62\u04a6\u9ad3") + udk + a.c(-178260090, "\uf7fb") + string, jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception exception) {
            System.out.println(a.c(1280651134, "\u2f1c\u56bc\udc7c\u420b\uc9d1\u4f39\uf528\u7cd4\ue29c\u6875\uefe0\u1596\u9b49\u02fd\u88a7\u0e57\ub446\u3b8d") + exception);
            return null;
        }
    }

    private static JsonObject ufg(String string, String string2, String string3) {
        if (string3 == null || udc == null) {
            return null;
        }
        try {
            byte[] byArray = ufw.boxKey(udc, udd, string2);
            byte[] byArray2 = ufw.open(byArray, a.d("\u7f6d\u06d1\u8c15\u1260", -239002140, -1935252753) + string + a.b("\u46a4", 2072528601) + udk, string3);
            return byArray2 == null ? null : JsonParser.parseString((String)new String(byArray2, StandardCharsets.UTF_8)).getAsJsonObject();
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static String ufh(String string, JsonObject jsonObject) {
        byte[] byArray = ucu.get(udf);
        if (byArray == null || !ucg.secured()) {
            ucg.uev();
            return null;
        }
        try {
            return udf + a.c(1730819222, "\u34b9") + ufw.seal(byArray, string + a.d("\u8c71", -2067285017, 937244651) + udf, jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        }
        catch (GeneralSecurityException generalSecurityException) {
            return null;
        }
    }

    private static JsonObject ufi(String string, String string2) {
        int n;
        int n2 = string2.indexOf(46);
        if (n2 <= 0 || udl == null || !udl.equals(ude)) {
            return null;
        }
        try {
            n = Integer.parseInt(string2.substring(0, n2));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        byte[] byArray = ucu.get(n);
        if (byArray == null) {
            return null;
        }
        byte[] byArray2 = ufw.open(byArray, string + a.c(1193674539, "\u0756") + n, string2.substring(n2 + 1));
        if (byArray2 == null) {
            return null;
        }
        try {
            return JsonParser.parseString((String)new String(byArray2, StandardCharsets.UTF_8)).getAsJsonObject();
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    private static void ufj(JsonObject jsonObject) {
        String string = ucg.ufh(a.d("\u74c0\u0d6f\u87a8\u19c2", -196674301, -1225815638) + udl + a.b("\u9b12", -1756259473) + udk, jsonObject);
        if (string != null) {
            ucg.ufn(ucg.ufm(a.d("\u999b\ue034\u6af3", 1465524378, -573589137)).put(a.c(1802278384, "\u9592"), string));
        }
    }

    private static String ufk(String string) {
        String string2 = ucg.ufl(string);
        if (string2 != null && string2.length() > 20) {
            string2 = string2.substring(0, 20);
        }
        return string2;
    }

    private static String ufl(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (c < ' ' || c == '\u007f' || c == '\u00a7') continue;
            stringBuilder.append(c);
        }
        Object object = stringBuilder.toString().trim();
        return ((String)object).isEmpty() ? null : object;
    }

    private static ubp ufm(String string) {
        return new ubp().put(a.d("k", 1310780117, -477173045), string);
    }

    private static boolean ufn(ubp ubp2) {
        return ucg.ufo(ubp2.json);
    }

    private static boolean ufo(JsonObject jsonObject) {
        if (udh == null || udj != ucd.ONLINE) {
            return false;
        }
        udh.send(jsonObject.toString());
        return true;
    }

    private static JsonArray ufp(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement != null && jsonElement.isJsonArray() ? jsonElement.getAsJsonArray() : new JsonArray();
    }

    private static String ufq(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement != null && jsonElement.isJsonPrimitive() ? jsonElement.getAsString() : null;
    }

    private static boolean ufr(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsBoolean();
    }

    private static double ufs(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement != null && jsonElement.isJsonPrimitive() ? jsonElement.getAsDouble() : Double.NaN;
    }

    private static byte[] uft(JsonObject jsonObject, String string) {
        String string2 = ucg.ufq(jsonObject, string);
        if (string2 == null) {
            return null;
        }
        try {
            return ufw.unb64(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static void ufu() throws GeneralSecurityException {
        Object object;
        if (udb != null && udc != null) {
            return;
        }
        try {
            object = ewk.get(a.c(1787517127, "\u58b2\u2112\uabd2\u35a5\ube7f"));
            if (object != null && !((String)object).isBlank()) {
                JsonObject jsonObject = JsonParser.parseString((String)object).getAsJsonObject();
                String string = ucg.ufq(jsonObject, a.c(571179594, "\u8222\ufb9d\u7152"));
                String string2 = ucg.ufq(jsonObject, a.d("\u7289\u0b3a\u81f2\u1f9c", 813051247, 1869832082));
                String string3 = ucg.ufq(jsonObject, a.b("\ud097\ua923\u23e7", 1077792996));
                if (string != null && string.matches(a.c(9408076, "\u8e18\uf7c2\u7d0c\ue369\u68e6\uee1b\u5403\uddc9\u43b0\uc949\u4e9b\ub4f4\u3a39\ua38a\u2990")) && string2 != null && string3 != null) {
                    udc = ufw.privateKey(string2);
                    ufw.publicKey(string3);
                    udb = string;
                    udd = string3;
                    ude = ucg.ufq(jsonObject, a.d("\u739f\u0a3f\u80ff\u1e88\u9552", 1407920835, -1487906519));
                    udf = jsonObject.has(a.b("\u7114\u08b0\u827c\u1c01\u97dd", 521498996)) ? jsonObject.get(a.c(-1525678925, "\ufcd3\u8577\u0fbb\u91c6\u1a1a")).getAsInt() : 0;
                    ucu.clear();
                    JsonElement jsonElement = jsonObject.get(a.c(-2067369153, "\u7350\u0aef\u8020\u1e5b"));
                    if (jsonElement != null && jsonElement.isJsonObject()) {
                        for (Map.Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                            ucu.put(Integer.parseInt((String)entry.getKey()), ufw.unb64(((JsonElement)entry.getValue()).getAsString()));
                        }
                    }
                    return;
                }
                if (string != null && string.matches(a.b("\u83ee\ufa34\u70fa\uee9f\u6510\ue3ed\u59f5\ud03f\u4e46\uc4bf\u436d\ub902\u37cf\uae7c\u2466", -200834118))) {
                    udb = string;
                }
            }
        }
        catch (Exception exception) {
            System.out.println(a.c(1080872504, "\uce4c\ub7ff\u3d23\ua31b\u289f\uae7a\u147b\u9d9d\u03c6\u8972\u0ee5\uf4c4\u7a02\ue3a0\u69f5\uef09\u5511\uda84\u402e\uc663\u4f95\u3590\ubb39") + exception);
        }
        if (udb == null) {
            object = new byte[32];
            ufw.RANDOM.nextBytes((byte[])object);
            udb = HexFormat.of().formatHex((byte[])object);
        }
        object = ufw.generate();
        udc = ((KeyPair)object).getPrivate();
        udd = ufw.b64(((KeyPair)object).getPublic().getEncoded());
        ucu.clear();
        ude = null;
        udf = 0;
        ucg.ufv();
    }

    private static void ufv() {
        if (udb == null || udc == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(a.d("\ue7e6\u9e59\u1496", 2039475014, 1497697480), udb);
        jsonObject.addProperty(a.b("\uaacb\ud378\u59b0\uc7de", 1798613695), ufw.b64(udc.getEncoded()));
        jsonObject.addProperty(a.b("\ud042\ua9f6\u2332", 1589694513), udd);
        if (ude != null) {
            jsonObject.addProperty(a.d("\u063c\u7f9c\uf55c\u6b2b\ue0f1", -856379613, 1219602794), ude);
            jsonObject.addProperty(a.b("\uc484\ubd20\u37ec\ua991\u224d", -1408776988), (Number)udf);
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry<Integer, byte[]> entry : ucu.entrySet()) {
                jsonObject2.addProperty(String.valueOf(entry.getKey()), ufw.b64(entry.getValue()));
            }
            jsonObject.add(a.c(1312137900, "\ua2c3\udb7c\u51b3\ucfc8"), (JsonElement)jsonObject2);
        }
        ewk.put(a.d("\ud1d2\ua872\u22b2\ubcc5\u371f", -1570721030, 1748394845), jsonObject.toString());
    }

    private static /* synthetic */ boolean lambda$handle$8(ubg ubg2, ubg ubg3) {
        return ubg3.party.equals(ubg2.party);
    }

    static {
        ALPHABET = a.d("\uf4a2\u8d10\u07c2\u99b4\u1262\u94d0\u2e82\ua77c\u3921\ub391\u3445\uce35\u40e1\ud94e\u531c\ud5ee\u6fa0\ue076\u7ac4\ufc96\u7560\u0f3e\u818c\u1a5e\u9c49\u1699\uaf2d\u217d\ubb89\u3dd9\ub665\u48b5", 1253873194, -2119015703);
        DEFAULT_RELAY = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'f', 'l', 'o', 'w', '2', '-', 'r', 'e', 'l', 'a', 'y', '.', 'f', 'l', 'o', 'w', '-', 'c', '0', 'd', '8', '7', '.', 'w', 'o', 'r', 'k', 'e', 'r', 's', '.', 'd', 'e', 'v'});
        COLORS = new int[]{-14494738, -340971, -5796870, -11870592, -290244, -757066, -10443270, -1906448};
        ENABLED = new vkl(a.c(-1905978108, "\u1551\u6cd1\ue611\u7866\uf3bc"), true);
        MARK_TIME = new vmc(a.d("\u14c3\u6d5e\ue79e\u79f6\uf26a\u748f\ucec1\u4734\ud963", -1408149912, 1505575663), 20.0, 5.0, 60.0, 1.0).unit(a.b("\ud471", -1856842749));
        SOUNDS = new vkl(a.c(754926299, "\u428e\u3b03\ub1ca\u2fa0\ua47d\u22db"), true);
        VOLUME = new vmc(a.b("\udda2\ua42a\u2efa\ub092\u3b5d\ubde4", -86974990), 0.7, 0.05, 1.5, 0.05).percent();
        LISTEN = new vkw(a.d("\u4d97\u3403\ubeca\u20bc\uab7a\u2dc0", -431682840, 1737115445), new vkq(a.c(1372051355, "\ud7d2\uae4f\u248f\ubae7"), vhz.PIN, () -> ucg.ueg(a.c(766393945, "\u3e0d\u4785\ucd51\u5329"), null)), new vkq(a.c(-1986211021, "\ud371\uaae5\u2039\ube41\u3594\ub332"), vhz.ALERT, () -> ucg.ueg(a.b("\u4b1d\u3289\ub855\u262d\uadf8\u2b5e", 1254050655), null)), new vkq(a.b("\uece2\u956f\u1fb1\u81d8\u0a13\u8cb5", 383118516), vhz.COMBAT, () -> ucg.ueg(a.d("\u3a63\u43f1\uc92e\u5757", -1432095208, 1896270899), null)));
        OPTIONS = List.of(MARK_TIME, SOUNDS, VOLUME, LISTEN);
        ALL = List.of(ENABLED, MARK_TIME, SOUNDS, VOLUME);
        VOLUME.visibleWhen(SOUNDS::get);
        LISTEN.visibleWhen(SOUNDS::get);
        ucr = new ArrayList<ubm>();
        ucs = new ArrayList<ubg>();
        uct = new ArrayList<ubj>();
        ucu = new TreeMap<Integer, byte[]>();
        ucv = new HashSet<String>();
        ucw = new ArrayList<ubs>();
        ucx = new ArrayList<ubx>();
        ucy = new HashSet<String>();
        ucz = new HashMap<String, ubg>();
        uda = new HashMap<String, Long>();
        udj = ucd.OFF;
    }

    private static /* synthetic */ int cvz(int n, int n2) {
        return n * n2 ^ 0xE830282C;
    }

    private static /* synthetic */ int cwa(int n, int n2) {
        return ucg.cvz(n, n2) * n2;
    }
}

