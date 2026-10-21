/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 */
package a;

import a.CloudSync;
import a.Friends;
import a.ClickGuiScreen;
import a.Hud;
import a.ubd;
import a.ubg;
import a.ubj;
import a.ubm;
import a.ubp;
import a.ubs;
import a.ubx;
import a.ucd;
import a.PartyCrypto;
import a.PartyMarkerRenderer;
import a.PartySocket;
import a.Icon;
import a.BoolSetting;
import a.vkq;
import a.ButtonSetting;
import a.NumberSetting;
import a.Setting;
import a.Sounds;
import a.Lang;
import a.Waypoints;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.cosmetic.Cosmetics;
import flow.dev.StringDecryptor;
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
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;

public final class PartyClient {
    public static final String DEFAULT_RELAY;
    public static final int MAX_MEMBERS = 8;
    public static final int CODE_LEN = 6;
    public static final String ALPHABET;
    public static final int DANGER = -1096636;
    public static final int[] COLORS;
    public static final BoolSetting ENABLED;
    public static final NumberSetting MARK_TIME;
    public static final BoolSetting SOUNDS;
    public static final NumberSetting VOLUME;
    public static final ButtonSetting LISTEN;
    public static final List<Setting> OPTIONS;
    public static final List<Setting> ALL;
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
    private static PartySocket udh;
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

    private PartyClient() {
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
        return PartyClient.pretty(udk);
    }

    public static String pretty(String string) {
        return string == null || string.length() != 6 ? string : string.substring(0, 3) + "-" + string.substring(3);
    }

    public static String fingerprint() {
        return udd == null ? null : PartyCrypto.fingerprint(udd);
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
        return System.getProperty("flow2.party.relay", DEFAULT_RELAY);
    }

    public static String normalize(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toUpperCase(Locale.ROOT).toCharArray()) {
            if ("ABCDEFGHJKLMNPQRSTUVWXYZ23456789".indexOf(c) >= 0) {
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
            if (ubm2.code.equals(udk) || !ubm2.online || ubm2.cosmetics == null || !string.equalsIgnoreCase(ubm2.name) || ubm2.world != null && !PartyClient.sameWorld(ubm2) && !PartyClient.onThisServer(ubm2.name)) continue;
            return ubm2.cosmetics;
        }
        return null;
    }

    static boolean onThisServer(String string) {
        return string != null && Friends.listEntry(string) != null;
    }

    public static ubm self() {
        return udk == null ? null : PartyClient.member(udk);
    }

    public static boolean sameWorld(ubm ubm2) {
        return ubm2.world != null && PartyClient.sameServer(ubm2.world, Waypoints.worldId());
    }

    public static boolean sameServer(String string, String string2) {
        return string != null && string2 != null && PartyClient.serverKey(string).equals(PartyClient.serverKey(string2));
    }

    static String serverKey(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (!string2.startsWith("mp:")) {
            return string2;
        }
        String string3 = string2.substring(3);
        int n = string3.indexOf(58);
        if (n > 0 && n == string3.lastIndexOf(58)) {
            string3 = string3.substring(0, n);
        }
        while (string3.endsWith(".")) {
            string3 = string3.substring(0, string3.length() - 1);
        }
        if (string3.matches("[0-9.]+") || string3.indexOf(58) >= 0) {
            return "mp:" + string3;
        }
        String[] stringArray = string3.split("[.]");
        if (stringArray.length > 2) {
            string3 = stringArray[stringArray.length - 2] + "." + stringArray[stringArray.length - 1];
        }
        return "mp:" + string3;
    }

    public static boolean visible(ubj ubj2) {
        if (!Objects.equals(ubj2.dim, Waypoints.dimensionId())) {
            return false;
        }
        if (ubj2.mine || PartyClient.sameServer(ubj2.world, Waypoints.worldId())) {
            return true;
        }
        return ubj2.name != null && (Friends.inWorld(ubj2.name) != null || PartyClient.onThisServer(ubj2.name));
    }

    public static void invite(String string) {
        String string2 = PartyClient.normalize(string);
        if (string2 == null) {
            PartyClient.ufb(Lang.s("Codes look like ABC-234", "Код выглядит как ABC-234"), true);
            return;
        }
        if (string2.equals(udk)) {
            PartyClient.ufb(Lang.s("That's your own code", "Это ваш код"), true);
            return;
        }
        if (PartyClient.inParty() && !PartyClient.secured()) {
            PartyClient.uev();
            PartyClient.ufb(Lang.s("Waiting for the party key, try again", "Ждём ключ пати, попробуйте ещё раз"), true);
            return;
        }
        if (!PartyClient.ufn(PartyClient.ufm("lookup").put("code", string2))) {
            PartyClient.ufb(PartyClient.ufa(), true);
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
        PartyClient.ufn(PartyClient.ufm("accept").put("party", ubg2.party));
    }

    public static void decline(ubg ubg2) {
        ucs.remove(ubg2);
        ++udx;
        PartyClient.ufn(PartyClient.ufm("decline").put("party", ubg2.party));
    }

    public static void leave() {
        if (PartyClient.ufn(PartyClient.ufm("leave"))) {
            PartyClient.uek();
            PartyClient.ufb(Lang.s("You left the party", "Вы вышли из пати"), false);
        }
    }

    public static void kick(ubm ubm2) {
        PartyClient.ufn(PartyClient.ufm("kick").put("code", ubm2.code));
    }

    public static void newCode() {
        if (!PartyClient.ufn(PartyClient.ufm("newcode"))) {
            PartyClient.ufb(PartyClient.ufa(), true);
        }
    }

    public static void reconnect() {
        PartyClient.uej();
        udj = ucd.OFF;
        udo = 0L;
        udp = 0;
    }

    public static void markKey() {
        Object object;
        Object object2;
        ubj ubj22;
        class_310 class_3102 = class_310.method_1551();
        class_1297 class_12972 = class_3102.method_1560();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || class_12972 == null) {
            return;
        }
        if (!PartyClient.inParty()) {
            PartyClient.ufc(Lang.s("Not in a party: Friends tab, Party", "Вы не в пати: вкладка Друзья, Пати"));
            return;
        }
        if (!PartyClient.secured()) {
            PartyClient.uev();
            PartyClient.ufc(Lang.s("Waiting for the party key", "Ждём ключ пати"));
            return;
        }
        long l = System.currentTimeMillis();
        String string = Waypoints.worldId();
        String string2 = Waypoints.dimensionId();
        if (udw != null && !udw.danger() && l - udv < 400L && uct.contains(udw)) {
            PartyClient.udw.kind = 1;
            PartyClient.udw.born = l;
            PartyClient.udw.color = -1096636;
            udv = 0L;
            PartyClient.uee(udw);
            PartyClient.ueg("Danger", null);
            return;
        }
        class_243 class_2432 = class_12972.method_5836(1.0f);
        class_243 class_2433 = class_12972.method_5828(1.0f);
        ubj ubj3 = null;
        double d = Math.cos(Math.toRadians(2.5));
        for (ubj ubj22 : uct) {
            double d2;
            double d3;
            if (!ubj22.mine || !PartyClient.visible(ubj22) || (d3 = (object2 = PartyMarkerRenderer.anchor(ubj22, 1.0f).method_1020(class_2432)).method_1033()) < 0.001 || !((d2 = object2.method_1026(class_2433) / d3) > d)) continue;
            d = d2;
            ubj3 = ubj22;
        }
        if (ubj3 != null) {
            uct.remove(ubj3);
            object = new JsonObject();
            object.addProperty("t", "unmark");
            object.addProperty("id", (Number)ubj3.id);
            PartyClient.ufj((JsonObject)object);
            udw = null;
            PartyClient.ueg("Unping", null);
            return;
        }
        object = new ubj();
        ubj22 = Friends.aimed(class_3102, 160.0);
        if (ubj22 != null) {
            ((ubj)object).target = Friends.nameOf((class_1657)ubj22);
            ((ubj)object).x = ubj22.method_23317();
            ((ubj)object).y = ubj22.method_23318();
            ((ubj)object).z = ubj22.method_23321();
        } else {
            object2 = class_12972.method_5745(400.0, 1.0f, false);
            if (object2 == null || object2.method_17783() == class_239.class_240.field_1333) {
                PartyClient.ufc(Lang.s("Too far to mark", "Слишком далеко для метки"));
                return;
            }
            class_243 class_2434 = object2.method_17784();
            ((ubj)object).x = class_2434.field_1352;
            ((ubj)object).y = class_2434.field_1351;
            ((ubj)object).z = class_2434.field_1350;
        }
        ((ubj)object).from = udk;
        ((ubj)object).name = class_3102.method_1548().method_1676();
        ((ubj)object).id = PartyCrypto.RANDOM.nextInt(Integer.MAX_VALUE);
        ((ubj)object).world = string;
        ((ubj)object).dim = string2;
        ((ubj)object).born = l;
        ((ubj)object).life = Math.round(MARK_TIME.get() * 1000.0);
        ((ubj)object).mine = true;
        object2 = PartyClient.self();
        ((ubj)object).color = object2 != null ? object2.color : COLORS[0];
        PartyClient.uef((ubj)object);
        PartyClient.uee((ubj)object);
        System.out.println("party mark placed at " + Math.round(((ubj)object).x) + " " + Math.round(((ubj)object).y) + " " + Math.round(((ubj)object).z) + (((ubj)object).target != null ? " on " + ((ubj)object).target : "") + " in " + string + " " + string2);
        udw = object;
        udv = l;
        PartyClient.ueg(((ubj)object).target != null ? "Lock" : "Ping", null);
    }

    private static void uee(ubj ubj2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("t", "mark");
        jsonObject.addProperty("id", (Number)ubj2.id);
        jsonObject.addProperty("x", (Number)ubj2.x);
        jsonObject.addProperty("y", (Number)ubj2.y);
        jsonObject.addProperty("z", (Number)ubj2.z);
        jsonObject.addProperty("w", ubj2.world);
        jsonObject.addProperty("d", ubj2.dim);
        jsonObject.addProperty("k", (Number)ubj2.kind);
        jsonObject.addProperty("n", ubj2.name);
        if (ubj2.target != null) {
            jsonObject.addProperty("p", ubj2.target);
        }
        PartyClient.ufj(jsonObject);
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

    private static void ueg(String string, class_243 class_2432) {
        if (!SOUNDS.get()) {
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        class_310 class_3102 = class_310.method_1551();
        if (class_2432 != null && class_3102.field_1724 != null) {
            double d;
            class_243 class_2433 = class_3102.field_1724.method_33571();
            double d2 = class_2432.field_1352 - class_2433.field_1352;
            double d3 = class_2432.field_1350 - class_2433.field_1350;
            double d4 = Math.toRadians(class_3102.field_1724.method_36454());
            double d5 = -d2 * Math.cos(d4) - d3 * Math.sin(d4);
            double d6 = Math.hypot(d5, d = -d2 * Math.sin(d4) + d3 * Math.cos(d4));
            if (d6 > 1.5) {
                f = (float)(d5 / d6 * 0.85);
                f2 = (float)(-d / d6);
            }
        }
        Sounds.cue(string, (float)VOLUME.get(), f, f2);
    }

    public static void tick(class_310 class_3102) {
        long l = System.currentTimeMillis();
        uct.removeIf(ubj2 -> l - ubj2.born > ubj2.life);
        String string = PartyClient.relay();
        if (!ENABLED.get() || string.isEmpty()) {
            if (udh != null) {
                PartyClient.uej();
            }
            udj = ENABLED.get() ? ucd.NO_SERVER : ucd.OFF;
            return;
        }
        if (udh != null && !string.equals(udi)) {
            PartyClient.uej();
            udo = 0L;
            udp = 0;
            udj = ucd.OFF;
        }
        if (udj == ucd.REPLACED) {
            return;
        }
        if (udh == null) {
            if (l >= udo) {
                PartyClient.uei(string);
            }
            return;
        }
        if (udj != ucd.ONLINE) {
            return;
        }
        if (l - udq > 25000L) {
            udq = l;
            udh.send("ping");
        }
        if (l - udr > 1000L) {
            udr = l;
            PartyClient.ueh(class_3102);
        }
    }

    private static void ueh(class_310 class_3102) {
        String string;
        if (!PartyClient.secured()) {
            return;
        }
        String string2 = class_3102.method_1548().method_1676();
        String string3 = Waypoints.worldId();
        String string4 = Waypoints.dimensionId();
        String string5 = Cosmetics.shareCode();
        String string6 = udl + "|" + udf + "|" + string2 + "|" + string3 + "|" + string4 + "|" + string5;
        if (string6.equals(uds)) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("n", string2);
        jsonObject.addProperty("w", string3);
        jsonObject.addProperty("d", string4);
        if (!string5.isEmpty()) {
            jsonObject.addProperty("c", string5);
        }
        if ((string = PartyClient.ufh("st|" + udl + "|" + udk, jsonObject)) != null && PartyClient.ufn(PartyClient.ufm("status").put("s", string))) {
            uds = string6;
        }
    }

    private static void uei(String string) {
        URI uRI;
        try {
            PartyClient.ufu();
            uRI = PartyClient.uri(string, udb, udd);
        }
        catch (Exception exception) {
            udj = ucd.RETRY;
            udn = Lang.s("Bad server address", "Неверный адрес сервера") + ": " + exception.getMessage();
            udo = System.currentTimeMillis() + 60000L;
            return;
        }
        udj = ucd.CONNECTING;
        udi = string;
        uds = null;
        udh = new PartySocket(uRI, new ubd());
        ++udx;
    }

    static URI uri(String string, String string2, String string3) {
        String string4 = string.trim();
        while (string4.endsWith("/")) {
            string4 = string4.substring(0, string4.length() - 1);
        }
        if (string4.startsWith("https://")) {
            string4 = "wss://" + string4.substring(8);
        } else if (string4.startsWith("http://")) {
            string4 = "ws://" + string4.substring(7);
        } else if (!string4.startsWith("wss://") && !string4.startsWith("ws://")) {
            string4 = "wss://" + string4;
        }
        if (!string4.endsWith("/ws")) {
            string4 = string4 + "/ws";
        }
        return URI.create(string4 + "?v=2&key=" + string2 + "&pub=" + string3);
    }

    private static void uej() {
        if (udh != null) {
            PartySocket uhg2 = udh;
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
        PartyClient.ufv();
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
        String string = PartyClient.ufq(jsonObject, "id");
        if (string == null) {
            if (udl != null || ude != null) {
                PartyClient.uek();
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
        udm = PartyClient.ufq(jsonObject, "leader");
        if (!string.equals(ude)) {
            ubg ubg2 = ucz.remove(string);
            if (ubg2 != null) {
                PartyClient.ufd(string, ubg2.epoch, ubg2.key);
            } else if (udg != null && udk != null && udk.equals(udm)) {
                PartyClient.ufd(string, 1, udg);
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
        for (JsonElement jsonElement : PartyClient.ufp(jsonObject, "members")) {
            if (!jsonElement.isJsonObject()) continue;
            JsonObject jsonObject2 = jsonElement.getAsJsonObject();
            ubm ubm3 = new ubm();
            ubm3.code = PartyClient.ufq(jsonObject2, "code");
            if (ubm3.code == null) continue;
            ubm3.online = PartyClient.ufr(jsonObject2, "online");
            ubm3.pub = PartyClient.ufq(jsonObject2, "pub");
            ubm3.fingerprint = ubm3.pub != null ? PartyCrypto.fingerprint(ubm3.pub) : null;
            ubm3.color = COLORS[n++ % COLORS.length];
            PartyClient.ueo(ubm3, PartyClient.ufq(jsonObject2, "s"));
            if (ubm3.code.equals(udk)) {
                ubm3.name = class_310.method_1551().method_1548().method_1676();
            }
            if (ubm3.name == null) {
                ubm3.name = PartyClient.pretty(ubm3.code);
            }
            ucr.add(ubm3);
        }
        for (ubj ubj2 : uct) {
            ubm ubm4 = PartyClient.member(ubj2.from);
            if (ubm4 == null || ubj2.danger()) continue;
            ubj2.color = ubm4.color;
        }
        PartyClient.uer();
        for (ubm ubm5 : ucr) {
            if (!ubm5.sealed || ubm5.code.equals(udk)) continue;
            PartyClient.ueo(ubm5, ubm5.blob);
            if (ubm5.name != null) continue;
            ubm5.name = PartyClient.pretty(ubm5.code);
        }
        if (!PartyClient.secured() && ucr.size() > 1) {
            PartyClient.uev();
        }
        if (PartyClient.isLeader() && PartyClient.secured()) {
            for (ubm ubm6 : ucr) {
                if (!ubm6.sealed || !ubm6.online || ubm6.code.equals(udk)) continue;
                PartyClient.uet(ubm6);
            }
        } else if (PartyClient.secured() && (ubm2 = PartyClient.member(udm)) != null && ubm2.sealed && ubm2.online) {
            PartyClient.uev();
        }
        boolean bl3 = false;
        for (String string2 : hashSet) {
            if (PartyClient.member(string2) != null) continue;
            bl = true;
            break;
        }
        if (bl && PartyClient.isLeader() && PartyClient.secured()) {
            PartyClient.ueu();
        }
        if (bl2 && ucr.size() > 1) {
            PartyClient.ufb(Lang.s("You are in a party", "Вы в пати"), false);
            PartyClient.ueg("Join", null);
        } else if (!bl2) {
            for (ubm ubm7 : ucr) {
                if (hashSet.contains(ubm7.code) || ubm7.code.equals(udk)) continue;
                PartyClient.ufb(Lang.s("Someone joined the party", "В пати новый участник"), false);
                PartyClient.ueg("Join", null);
            }
        }
        PartyClient.uex();
        PartyClient.uen();
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
            if (ubm2.code.equals(udk) || ubm2.sealed || ubm2.blob == null || ubm2.name == null || ubm2.name.equals(PartyClient.pretty(ubm2.code)) || !ucy.add(ubm2.name.toLowerCase(Locale.ROOT)) || !Friends.add(ubm2.name)) continue;
            System.out.println("party member " + ubm2.name + " added to friends");
            Hud.alert(ubm2.name, Lang.s("Friend (party)", "Друг (пати)"), Icon.FRIENDS, true);
        }
    }

    private static void ueo(ubm ubm2, String string) {
        ubm2.blob = string;
        if (string == null) {
            return;
        }
        JsonObject jsonObject = PartyClient.ufi("st|" + udl + "|" + ubm2.code, string);
        if (jsonObject == null) {
            ubm2.sealed = true;
            return;
        }
        ubm2.sealed = false;
        ubm2.name = PartyClient.ufk(PartyClient.ufq(jsonObject, "n"));
        ubm2.world = PartyClient.ufq(jsonObject, "w");
        ubm2.dim = PartyClient.ufq(jsonObject, "d");
        String string2 = PartyClient.ufl(PartyClient.ufq(jsonObject, "c"));
        ubm2.cosmetics = string2 != null && string2.length() <= 1000 ? string2 : null;
    }

    private static void uep(JsonObject jsonObject) {
        int n;
        byte[] byArray;
        String string = PartyClient.ufq(jsonObject, "code");
        String string2 = PartyClient.ufq(jsonObject, "pub");
        if (string == null || string2 == null || !ucv.remove(string)) {
            return;
        }
        if (PartyClient.inParty()) {
            if (!PartyClient.secured()) {
                PartyClient.uev();
                PartyClient.ufb(Lang.s("Waiting for the party key, try again", "Ждём ключ пати, попробуйте ещё раз"), true);
                return;
            }
            byArray = ucu.get(udf);
            n = udf;
        } else {
            if (udg == null) {
                udg = PartyCrypto.randomKey();
            }
            byArray = udg;
            n = 1;
        }
        String string3 = PartyClient.uff(string, string2, byArray, n);
        if (string3 == null) {
            PartyClient.ufb(Lang.s("Encryption failed", "Ошибка шифрования"), true);
            return;
        }
        PartyClient.ufn(PartyClient.ufm("invite").put("code", string).put("box", string3));
    }

    private static ubg ueq(JsonObject jsonObject) {
        String string = PartyClient.ufq(jsonObject, "party");
        String string2 = PartyClient.ufq(jsonObject, "from");
        String string3 = PartyClient.ufq(jsonObject, "pub");
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        ubg ubg2 = new ubg();
        ubg2.party = string;
        ubg2.from = string2;
        ubg2.pub = string3;
        ubg2.fingerprint = PartyCrypto.fingerprint(string3);
        long l = jsonObject.has("ms") ? jsonObject.get("ms").getAsLong() : 120000L;
        ubg2.until = System.currentTimeMillis() + Math.min(l, 120000L);
        JsonObject jsonObject2 = PartyClient.ufg(string2, string3, PartyClient.ufq(jsonObject, "box"));
        if (jsonObject2 != null) {
            ubg2.name = PartyClient.ufk(PartyClient.ufq(jsonObject2, "n"));
            ubg2.key = PartyClient.uft(jsonObject2, "k");
            int n = ubg2.epoch = jsonObject2.has("e") ? jsonObject2.get("e").getAsInt() : 1;
        }
        if (ubg2.name == null) {
            ubg2.name = PartyClient.pretty(string2);
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
            ubm ubm2 = PartyClient.member(ubs2.from());
            if (ubm2 == null || ubm2.pub == null) {
                if (!ucr.isEmpty()) continue;
                ucw.add(ubs2);
                continue;
            }
            JsonObject jsonObject = PartyClient.ufg(ubm2.code, ubm2.pub, ubs2.box());
            byte[] byArray = jsonObject != null ? PartyClient.uft(jsonObject, "k") : null;
            if (byArray == null || byArray.length != 32) continue;
            int n = jsonObject.has("e") ? jsonObject.get("e").getAsInt() : 1;
            boolean bl = ubm2.code.equals(udm);
            if (PartyClient.secured() && !bl && n <= udf) {
                System.out.println("party key from " + ubm2.name + " ignored: epoch " + n + ", ours " + udf);
                continue;
            }
            System.out.println("party key from " + ubm2.name + (bl ? " (leader)" : "") + ", epoch " + n);
            if (!udl.equals(ude)) {
                ucu.clear();
                udf = 0;
            }
            ude = udl;
            ucu.put(n, byArray);
            if (n >= udf) {
                udf = n;
            }
            PartyClient.ufe();
            uds = null;
            PartyClient.ufv();
        }
    }

    private static void ues(String string) {
        ubm ubm22;
        if (string == null || !PartyClient.secured() || PartyClient.member(string) == null) {
            return;
        }
        String string2 = null;
        ubm ubm3 = PartyClient.member(udm);
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
        ubm ubm4 = PartyClient.member(string);
        ubm ubm5 = ubm22 = ubm4.pub != null ? PartyClient.uff(ubm4.code, ubm4.pub, ucu.get(udf), udf) : null;
        if (ubm22 != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("to", ubm4.code);
            jsonObject.addProperty("box", (String)((Object)ubm22));
            JsonArray jsonArray = new JsonArray();
            jsonArray.add((JsonElement)jsonObject);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("t", "keys");
            jsonObject2.add("boxes", (JsonElement)jsonArray);
            PartyClient.ufo(jsonObject2);
        }
    }

    private static void uet(ubm ubm2) {
        long l = System.currentTimeMillis();
        Long l2 = uda.get(ubm2.code);
        if (ubm2.pub == null || l2 != null && l - l2 < 5000L) {
            return;
        }
        uda.put(ubm2.code, l);
        String string = PartyClient.uff(ubm2.code, ubm2.pub, ucu.get(udf), udf);
        if (string == null) {
            return;
        }
        System.out.println("party key sent to " + ubm2.name + ", epoch " + udf);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("to", ubm2.code);
        jsonObject.addProperty("box", string);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement)jsonObject);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("t", "keys");
        jsonObject2.add("boxes", (JsonElement)jsonArray);
        PartyClient.ufo(jsonObject2);
    }

    private static void ueu() {
        byte[] byArray = PartyCrypto.randomKey();
        int n = udf + 1;
        JsonArray jsonArray = new JsonArray();
        for (ubm ubm2 : ucr) {
            String string;
            if (ubm2.code.equals(udk) || ubm2.pub == null || (string = PartyClient.uff(ubm2.code, ubm2.pub, byArray, n)) == null) continue;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("to", ubm2.code);
            jsonObject.addProperty("box", string);
            jsonArray.add((JsonElement)jsonObject);
        }
        ucu.put(n, byArray);
        udf = n;
        PartyClient.ufe();
        uds = null;
        PartyClient.ufv();
        if (!jsonArray.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("t", "keys");
            jsonObject.add("boxes", (JsonElement)jsonArray);
            PartyClient.ufo(jsonObject);
        }
    }

    private static void uev() {
        long l = System.currentTimeMillis();
        if (PartyClient.inParty() && l - udt > 10000L) {
            udt = l;
            PartyClient.ufn(PartyClient.ufm("needkey"));
        }
    }

    private static void uew(String string, String string2) {
        if (string == null || string2 == null) {
            return;
        }
        if (!PartyClient.uey(string, string2, System.currentTimeMillis())) {
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
            if (l - ubx2.at() < 15000L && PartyClient.ufi("msg|" + udl + "|" + ubx2.from(), ubx2.c()) != null) {
                System.out.println("party message from " + PartyClient.pretty(ubx2.from()) + " read late, " + (l - ubx2.at()) + " ms after it came");
                PartyClient.uey(ubx2.from(), ubx2.c(), ubx2.at());
                continue;
            }
            if (l - ubx2.at() >= 15000L) continue;
            ucx.add(ubx2);
        }
    }

    private static boolean uey(String string, String string2, long l) {
        JsonObject jsonObject;
        ubm ubm2 = PartyClient.member(string);
        if (ubm2 == null) {
            System.out.println("party message from " + PartyClient.pretty(string) + " who isn't in AutoRepair list, asking for it");
            uds = null;
            udr = 0L;
        }
        if ((jsonObject = PartyClient.ufi("msg|" + udl + "|" + string, string2)) == null) {
            long l2 = System.currentTimeMillis();
            if (l2 - udu > 3000L) {
                udu = l2;
                System.out.println("party can't read " + (ubm2 != null ? ubm2.name : PartyClient.pretty(string)) + "'s message " + string2.substring(0, Math.max(0, string2.indexOf(46))) + ", ours epoch " + udf + " " + ucu.keySet() + (udl != null && udl.equals(ude) ? "" : " (key of another party)"));
            }
            if (ubm2 != null && PartyClient.isLeader() && PartyClient.secured()) {
                PartyClient.uet(ubm2);
            } else {
                PartyClient.uev();
            }
            return false;
        }
        if (ubm2 == null) {
            ubm2 = new ubm();
            ubm2.code = string;
            ubm2.name = PartyClient.pretty(string);
            ubm2.color = COLORS[ucr.size() % COLORS.length];
        }
        String string3 = PartyClient.ufq(jsonObject, "t");
        if ("unmark".equals(string3)) {
            int n = jsonObject.has("id") ? jsonObject.get("id").getAsInt() : -1;
            uct.removeIf(ubj2 -> !ubj2.mine && ubj2.from.equals(string) && ubj2.id == n);
            return true;
        }
        if (!"mark".equals(string3)) {
            return true;
        }
        ubj ubj3 = new ubj();
        ubj3.from = string;
        ubj3.name = Objects.requireNonNullElse(PartyClient.ufk(PartyClient.ufq(jsonObject, "n")), ubm2.name);
        ubj3.id = jsonObject.has("id") ? jsonObject.get("id").getAsInt() : 0;
        ubj3.x = PartyClient.ufs(jsonObject, "x");
        ubj3.y = PartyClient.ufs(jsonObject, "y");
        ubj3.z = PartyClient.ufs(jsonObject, "z");
        if (!Double.isFinite(ubj3.x) || !Double.isFinite(ubj3.y) || !Double.isFinite(ubj3.z) || Math.abs(ubj3.x) > 3.1E7 || Math.abs(ubj3.z) > 3.1E7 || Math.abs(ubj3.y) > 100000.0) {
            return true;
        }
        ubj3.world = PartyClient.ufq(jsonObject, "w");
        ubj3.dim = PartyClient.ufq(jsonObject, "d");
        ubj3.kind = jsonObject.has("k") && jsonObject.get("k").getAsInt() == 1 ? 1 : 0;
        ubj3.target = PartyClient.ufk(PartyClient.ufq(jsonObject, "p"));
        ubj3.born = l;
        ubj3.life = Math.round(MARK_TIME.get() * 1000.0);
        ubj3.color = ubj3.danger() ? -1096636 : ubm2.color;
        String string4 = class_310.method_1551().method_1548().method_1676();
        if (ubj3.target != null && ubj3.target.equalsIgnoreCase(string4)) {
            PartyClient.ufc(ubj3.name + (ubj3.danger() ? Lang.s(" warns: you are in danger", " предупреждает: вы в опасности") : Lang.s(" marked you", " отметил вас")));
            PartyClient.ueg(ubj3.danger() ? "Danger" : "Lock", null);
            return true;
        }
        PartyClient.uef(ubj3);
        boolean bl = PartyClient.visible(ubj3);
        System.out.println("party mark from " + ubj3.name + (bl ? " shown" : " hidden: theirs " + ubj3.world + " " + ubj3.dim + ", ours " + Waypoints.worldId() + " " + Waypoints.dimensionId()));
        if (bl) {
            PartyClient.ueg(ubj3.danger() ? "Danger" : (ubj3.target != null ? "Lock" : "Ping"), PartyMarkerRenderer.anchor(ubj3, 1.0f));
        } else if (!Objects.equals(ubj3.dim, Waypoints.dimensionId())) {
            PartyClient.ufc(ubj3.name + Lang.s(" marked something in another dimension", " поставил метку в другом измерении"));
        } else {
            PartyClient.ufc(ubj3.name + Lang.s(" marked something on another server", " поставил метку на другом сервере"));
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
        return udj == ucd.NO_SERVER ? Lang.s("Set the party server first", "Сначала укажите сервер пати") : Lang.s("Not connected to the party server", "Нет связи с сервером пати");
    }

    private static void ufb(String string, boolean bl) {
        udz = string;
        uea = bl;
        ++ueb;
        class_310 class_3102 = class_310.method_1551();
        if (!(class_3102.field_1755 instanceof ClickGuiScreen) && class_3102.field_1687 != null) {
            Hud.alert(Lang.s("Party", "Пати"), string, Icon.FRIENDS, !bl);
        }
    }

    private static void ufc(String string) {
        Hud.alert(Lang.s("Party", "Пати"), string, Icon.FRIENDS, true);
    }

    private static void ufd(String string, int n, byte[] byArray) {
        ucu.clear();
        ude = string;
        udf = n;
        ucu.put(n, byArray);
        uds = null;
        PartyClient.ufv();
    }

    private static void ufe() {
        while (ucu.size() > 3) {
            ucu.remove(((TreeMap)ucu).firstKey());
        }
    }

    private static String uff(String string, String string2, byte[] byArray, int n) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("k", PartyCrypto.b64(byArray));
            jsonObject.addProperty("e", (Number)n);
            jsonObject.addProperty("n", class_310.method_1551().method_1548().method_1676());
            byte[] byArray2 = PartyCrypto.boxKey(udc, udd, string2);
            return PartyCrypto.seal(byArray2, "box|" + udk + "|" + string, jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception exception) {
            System.out.println("party box failed: " + exception);
            return null;
        }
    }

    private static JsonObject ufg(String string, String string2, String string3) {
        if (string3 == null || udc == null) {
            return null;
        }
        try {
            byte[] byArray = PartyCrypto.boxKey(udc, udd, string2);
            byte[] byArray2 = PartyCrypto.open(byArray, "box|" + string + "|" + udk, string3);
            return byArray2 == null ? null : JsonParser.parseString((String)new String(byArray2, StandardCharsets.UTF_8)).getAsJsonObject();
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static String ufh(String string, JsonObject jsonObject) {
        byte[] byArray = ucu.get(udf);
        if (byArray == null || !PartyClient.secured()) {
            PartyClient.uev();
            return null;
        }
        try {
            return udf + "." + PartyCrypto.seal(byArray, string + "|" + udf, jsonObject.toString().getBytes(StandardCharsets.UTF_8));
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
        byte[] byArray2 = PartyCrypto.open(byArray, string + "|" + n, string2.substring(n2 + 1));
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
        String string = PartyClient.ufh("msg|" + udl + "|" + udk, jsonObject);
        if (string != null) {
            PartyClient.ufn(PartyClient.ufm("msg").put("c", string));
        }
    }

    private static String ufk(String string) {
        String string2 = PartyClient.ufl(string);
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
        return new ubp().put("t", string);
    }

    private static boolean ufn(ubp ubp2) {
        return PartyClient.ufo(ubp2.json);
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
        String string2 = PartyClient.ufq(jsonObject, string);
        if (string2 == null) {
            return null;
        }
        try {
            return PartyCrypto.unb64(string2);
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
            object = CloudSync.get("party");
            if (object != null && !((String)object).isBlank()) {
                JsonObject jsonObject = JsonParser.parseString((String)object).getAsJsonObject();
                String string = PartyClient.ufq(jsonObject, "key");
                String string2 = PartyClient.ufq(jsonObject, "priv");
                String string3 = PartyClient.ufq(jsonObject, "pub");
                if (string != null && string.matches("[0-9a-f]{32,64}") && string2 != null && string3 != null) {
                    udc = PartyCrypto.privateKey(string2);
                    PartyCrypto.publicKey(string3);
                    udb = string;
                    udd = string3;
                    ude = PartyClient.ufq(jsonObject, "party");
                    udf = jsonObject.has("epoch") ? jsonObject.get("epoch").getAsInt() : 0;
                    ucu.clear();
                    JsonElement jsonElement = jsonObject.get("keys");
                    if (jsonElement != null && jsonElement.isJsonObject()) {
                        for (Map.Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                            ucu.put(Integer.parseInt((String)entry.getKey()), PartyCrypto.unb64(((JsonElement)entry.getValue()).getAsString()));
                        }
                    }
                    return;
                }
                if (string != null && string.matches("[0-9a-f]{32,64}")) {
                    udb = string;
                }
            }
        }
        catch (Exception exception) {
            System.out.println("can't read party.json: " + exception);
        }
        if (udb == null) {
            object = new byte[32];
            PartyCrypto.RANDOM.nextBytes((byte[])object);
            udb = HexFormat.of().formatHex((byte[])object);
        }
        object = PartyCrypto.generate();
        udc = ((KeyPair)object).getPrivate();
        udd = PartyCrypto.b64(((KeyPair)object).getPublic().getEncoded());
        ucu.clear();
        ude = null;
        udf = 0;
        PartyClient.ufv();
    }

    private static void ufv() {
        if (udb == null || udc == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("key", udb);
        jsonObject.addProperty("priv", PartyCrypto.b64(udc.getEncoded()));
        jsonObject.addProperty("pub", udd);
        if (ude != null) {
            jsonObject.addProperty("party", ude);
            jsonObject.addProperty("epoch", (Number)udf);
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry<Integer, byte[]> entry : ucu.entrySet()) {
                jsonObject2.addProperty(String.valueOf(entry.getKey()), PartyCrypto.b64(entry.getValue()));
            }
            jsonObject.add("keys", (JsonElement)jsonObject2);
        }
        CloudSync.put("party", jsonObject.toString());
    }

    private static /* synthetic */ boolean lambda$handle$8(ubg ubg2, ubg ubg3) {
        return ubg3.party.equals(ubg2.party);
    }

    static {
        ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        DEFAULT_RELAY = new String(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'f', 'l', 'o', 'w', '2', '-', 'r', 'e', 'l', 'a', 'y', '.', 'f', 'l', 'o', 'w', '-', 'c', '0', 'd', '8', '7', '.', 'w', 'o', 'r', 'k', 'e', 'r', 's', '.', 'd', 'e', 'v'});
        COLORS = new int[]{-14494738, -340971, -5796870, -11870592, -290244, -757066, -10443270, -1906448};
        ENABLED = new BoolSetting("Party", true);
        MARK_TIME = new NumberSetting("Mark time", 20.0, 5.0, 60.0, 1.0).unit("s");
        SOUNDS = new BoolSetting("Sounds", true);
        VOLUME = new NumberSetting("Volume", 0.7, 0.05, 1.5, 0.05).percent();
        LISTEN = new ButtonSetting("Listen", new vkq("Mark", Icon.PIN, () -> PartyClient.ueg("Ping", null)), new vkq("Danger", Icon.ALERT, () -> PartyClient.ueg("Danger", null)), new vkq("Player", Icon.COMBAT, () -> PartyClient.ueg("Lock", null)));
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
        return PartyClient.cvz(n, n2) * n2;
    }
}

