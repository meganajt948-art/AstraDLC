/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ewk;
import a.eyg;
import a.eyn;
import a.tck;
import a.tij;
import a.tik;
import a.tin;
import a.tmh;
import a.tmk;
import a.ttb;
import a.tvc;
import a.txs;
import a.tzs;
import a.vza;
import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public final class tiq {
    public static final String[] STAND_MODES;
    public static final String[] QUALITIES;
    public static final String[] SIZES;
    public static final String[] PURPOSES;
    public static final int[] BOOSTS;
    public static final String AIM;
    public static final String AURA;
    public static final String MINE;
    public static final String WALK;
    private static final String tir;
    private static final String tis;
    private static final String[] tit;
    private static final Map<String, tiq> tiu;
    private static boolean tiv;
    public final String name;
    private final Properties tiw = new Properties();
    private final Map<String, tmh> tix = new LinkedHashMap<String, tmh>();
    private final Map<String, tvc> tiy = new LinkedHashMap<String, tvc>();
    private final Map<String, tzs> tiz = new LinkedHashMap<String, tzs>();
    private final Map<String, tin> tja = new LinkedHashMap<String, tin>();
    private final Set<String> tjb = new HashSet<String>();
    private volatile List<eyg> tjc = List.of();
    private volatile long tjd;
    private volatile boolean tje;
    private volatile int tjf = -1;
    private volatile int tjg;
    private volatile boolean tjh;
    private volatile CompletableFuture<Void> tji;
    private static /* synthetic */ int tjj;
    private static /* synthetic */ boolean tjk;

    private tiq(String string, String string2) {
        this.name = string;
        if (string2 != null && !string2.isEmpty()) {
            try {
                this.tiw.load(new StringReader(string2));
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        for (String string3 : tit) {
            this.tiw.remove(string3);
        }
        this.tja.put(a.b("\u2158\u58e1\ud236", -616750790), new tin());
        this.tja.put(a.d("\u909f\ue93a\u63ee\ufd8c", -37485955, 1229820551), new tin());
        this.tja.put(a.c(-1575776998, "\u8d73\uf4c6\u7e12\ue068"), new tin());
        this.tja.put(a.b("\u42cb\u3b6c\ub1b2\u2fc4", -498449736), new tin());
    }

    public static synchronized List<tiq> list() {
        tiq.tjl();
        ArrayList<tiq> arrayList = new ArrayList<tiq>(tiu.values());
        arrayList.sort(Comparator.comparingLong(tiq2 -> tiq2.getLong(a.d("\uaa05\ud3a5\u5961\uc714\u4cd6\uca76\u7024", -283848049, 851540206), 0L)).thenComparing(tiq2 -> tiq2.name));
        return arrayList;
    }

    public static synchronized tiq open(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        tiq.tjl();
        return tiu.get(string);
    }

    private static void tjl() {
        if (tiv) {
            return;
        }
        tiv = true;
        String string = ewk.get(a.b("\u402b\u3991\ub352\u2d24\ua6ee\u201e\u9a0a\u13fc\u8da9\u0719\u80d7", 920731726));
        if (string == null) {
            return;
        }
        for (String string2 : string.split(a.d("\ufac4", -1670556772, 45197651))) {
            String string3;
            String string4 = string2.trim();
            if (string4.isEmpty() || tiu.containsKey(string4) || (string3 = ewk.get(a.b("\uf84c\u81f6\u0b35\u9543\u1e89\u9879\u2274\uabdb", -582027222) + string4)) == null || string3.isEmpty()) continue;
            tiu.put(string4, new tiq(string4, string3));
        }
    }

    private static void tjm() {
        ewk.put(a.c(1661195665, "\ud5f4\uac4e\u268d\ub8fb\u3331\ub5c1\u0fd5\u8623\u1876\u92c6\u1508"), String.join((CharSequence)a.d("\u2edf", -669535535, -330130427), tiu.keySet()));
    }

    public static String clean(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.trim().toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ' && c != '-' && c != '_') continue;
            stringBuilder.append(c);
        }
        Object object = stringBuilder.toString().trim();
        return ((String)object).length() > 24 ? ((String)object).substring(0, 24).trim() : object;
    }

    public static synchronized tiq create(String string) throws IOException {
        String string2 = tiq.clean(string);
        if (string2.isEmpty()) {
            throw new IOException(a.d("\u88ce\uf177\u7bb9\ue5cc\u6e16", -2025652906, 599356920));
        }
        tiq.tjl();
        if (tiu.containsKey(string2)) {
            throw new IOException(a.c(-524366033, "\ucf4c\ub6e0\u3c22\ua249\u2999\uaf2f"));
        }
        tiq tiq2 = new tiq(string2, null);
        tiq2.set(a.b("\u292c\u508c\uda48\u443d\ucfff\u495f\uf30d", -1691080376), System.currentTimeMillis());
        tiq2.id();
        tiu.put(string2, tiq2);
        tiq.tjm();
        tiq2.saveNow();
        return tiq2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized void delete(tiq tiq2) throws IOException {
        if (tiq2 == null || tiu.remove(tiq2.name) == null) {
            return;
        }
        tiq.tjm();
        ewk.put(a.c(-1995015756, "\u79d2h\u8aab\u14dd\u9f17\u19e7\ua3ea\u2a45") + tiq2.name, "");
        String string = tiq2.id();
        eyn.delete(null, a.d("\u52ee\u2b00", 1275229792, -1100208900) + string + a.c(683397036, "\ucf82")).exceptionally(throwable -> false);
        eyn.delete(null, a.c(1788165606, "\u3d96\u447a") + string + a.d("\u27f9", 709960583, -230947760)).exceptionally(throwable -> false);
        tiq tiq3 = tiq2;
        synchronized (tiq3) {
            tiq2.tix.clear();
            tiq2.tiy.clear();
            tiq2.tiz.clear();
        }
    }

    public synchronized String id() {
        String string = this.tiw.getProperty(a.c(646700316, "\udd77\ua4cb"));
        if (string == null || !string.matches(a.b("\u9fc8\ue612\u6cdc\uf2b9\u7936\uffcb\u45d3\ucc19\u5260\ud89b\u5f4b\ua575", -133193825))) {
            string = String.format(Locale.ROOT, a.c(2140544107, "\u1c4b\u65ef\uef3d\u714f\ufad2"), new SecureRandom().nextLong() & 0xFFFFFFFFFFFFL);
            this.tiw.setProperty(a.c(-680354530, "\u9d75\ue4c9"), string);
            this.save();
        }
        return string;
    }

    public String purpose() {
        String string = this.get(a.b("\ua1fa\ud84e\u529a\ucce9\u4721\uc18c\u7bc9", 1575461261), a.c(-510745178, "\ua5e4\udc7d\u56aa"));
        return string.equalsIgnoreCase(a.b("\u0173\u78f6\uf222\u6c40", -70319818)) ? a.d("\u58d0\u2155\uab81\u35e3", 1023131792, -1668114427) : (string.equalsIgnoreCase(a.b("\u4d95\u3400\ubed4\u20ae", 1234128348)) ? a.d("\u06c7\u7f52\uf586\u6bfc", 1264114334, 356572176) : (string.equalsIgnoreCase(a.d("\u0958\u70df\ufa01\u6477", 352925755, 1488531760)) ? a.c(-1518855434, "\u1aa5\u6322\ue9fc\u778a") : a.c(-1900459237, "\u4b59\u32c0\ub817")));
    }

    public boolean aura() {
        return this.purpose().equals(a.b("\ud529\uacac\u2678\ub81a", -477506196));
    }

    public boolean mine() {
        return this.purpose().equals(a.b("\u3480\u4d15\uc7c1\u59bb", -1416809271));
    }

    public boolean walk() {
        return this.purpose().equals(a.d("\u0679\u7ffe\uf520\u6b56", 742740286, -422291692));
    }

    public String kind() {
        return this.aura() ? a.d("\ub075\uc9d0\u4304\udd66", 1376639233, -255694575) : (this.mine() ? a.c(1890417392, "\u7a99\u032c\u89f8\u1782") : (this.walk() ? a.d("\uc09c\ub93b\u33e5\uad93", -739278935, 1197850438) : a.c(-1145304177, "\u0bed\u7254\uf883")));
    }

    public synchronized List<tzs> walkTapes() {
        return new ArrayList<tzs>(this.tiz.values());
    }

    public synchronized void putWalkTape(String string, tzs tzs2) {
        this.tiz.put(string, tzs2);
    }

    public void uploadWalkTape(String string, tzs tzs2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(a.c(-1565600200, "\ud657\uafe4\u2530\ubb4b"), a.c(-196229532, "\uc617\ubfb0\u356e\uab18"));
        linkedHashMap.put(a.b("\u95d6\uec65\u66ab\uf8d3\u730b\uf5bf\u4fe5", 1828361633), this.name);
        linkedHashMap.put(a.d("\u2016\u59ba\ud363\u4d1a\uc6d5", -118673187, -2126966598), String.valueOf(tzs2.ticks.size()));
        linkedHashMap.put(a.d("\uc28a\ubb36\u31ea\uaf90\u2451", 1908193975, 1012168788), String.valueOf(tzs2.lanes.size()));
        this.tjn(a.d("\u2420\u5dcc", 1138090501, 1248904789) + this.id() + a.b("\u3d4c", 378092898) + string, tzs2::bytes, linkedHashMap);
    }

    public synchronized List<tvc> mineTapes() {
        return new ArrayList<tvc>(this.tiy.values());
    }

    public synchronized void putMineTape(String string, tvc tvc2) {
        this.tiy.put(string, tvc2);
    }

    public synchronized List<tmh> tapes() {
        return new ArrayList<tmh>(this.tix.values());
    }

    public synchronized void putTape(String string, tmh tmh2) {
        this.tix.put(string, tmh2);
    }

    public void uploadTape(String string, tmh tmh2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(a.c(763723078, "\u7d29\u049a\u8e4e\u1035"), a.d("\u8dab\uf40f\u7ecd\ue0a9", -9721957, -1193530816));
        linkedHashMap.put(a.b("\u48bf\u310c\ubbc2\u25ba\uae62\u28d6\u928c", -125744952), this.name);
        linkedHashMap.put(a.b("\ue5cd\u9c61\u16b8\u88c1\u030e", 1365501372), String.valueOf(tmh2.ticks.size()));
        this.tjn(a.d("\ucdf2\ub41e", -607764113, -527201043) + this.id() + a.d("\u4ed7", -1829497613, -1688380918) + string, tmh2::bytes, linkedHashMap);
    }

    public void uploadMineTape(String string, tvc tvc2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(a.c(848136781, "\u8a22\uf391\u7945\ue73e"), a.d("\u8db8\uf40d\u7ed9\ue0a3", 2140676203, -1379029574));
        linkedHashMap.put(a.b("\ua76c\udedf\u5411\uca69\u41b1\uc705\u7d5f", 1694476059), this.name);
        linkedHashMap.put(a.c(-1023636954, "\u8a57\uf3fb\u7922\ue75b\u6c94"), String.valueOf(tvc2.ticks.size()));
        linkedHashMap.put(a.b("\u6404\u1db4\u977a\u090c", -1491049368), String.valueOf(tvc2.hits.size()));
        this.tjn(a.d("\u9188\ue864", 1458554316, -1267575756) + this.id() + a.b("\u86a7", 1821148809) + string, tvc2::bytes, linkedHashMap);
    }

    private void tjn(String string, tij tij2, Map<String, String> map) {
        if (!eyn.online()) {
            return;
        }
        CompletableFuture.runAsync(() -> {
            try {
                byte[] byArray = tij2.get();
                eyn.put(string, byArray, map).exceptionally(throwable -> false);
            }
            catch (IOException iOException) {
                // empty catch block
            }
        });
    }

    public void prefetch() {
        this.loadRecordings(false);
        this.refreshVersions(false);
    }

    public int recordingsTotal() {
        return this.tjf;
    }

    public int recordingsLoaded() {
        return this.tjg;
    }

    public boolean recordingsLoading() {
        return this.tjh;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void loadRecordings(boolean bl) {
        CompletableFuture<Void> completableFuture;
        tiq tiq2 = this;
        synchronized (tiq2) {
            if (this.tji == null || this.tji.isCompletedExceptionally()) {
                if (!eyn.online()) {
                    return;
                }
                this.tjh = true;
                String string = a.b("\u5d92\u247e", -375366174) + this.id() + a.d("\uf958", -1101908915, 1980681531);
                this.tji = ((CompletableFuture)eyn.list(string).thenCompose(list -> {
                    this.tjf = list.size();
                    ArrayList<CompletionStage> arrayList = new ArrayList<CompletionStage>();
                    for (eyg eyg2 : list) {
                        String string2 = eyg2.key().substring(string.length());
                        tiq tiq2 = this;
                        synchronized (tiq2) {
                            if (this.tix.containsKey(string2) || this.tiy.containsKey(string2) || this.tiz.containsKey(string2) || !this.tjb.add(string2)) {
                                ++this.tjg;
                                continue;
                            }
                        }
                        boolean bl = a.b("\u4e6d\u37d8\ubd0c\u2376", -118731260).equals(eyg2.meta().get(a.b("\uab80\ud233\u58e7\uc69c", -1546867729)));
                        boolean bl2 = a.d("\u0510\u7cb7\uf669\u681f", -1482623788, 1593831863).equals(eyg2.meta().get(a.c(1178722652, "\ue133\u9880\u1254\u8c2f")));
                        arrayList.add(((CompletableFuture)eyn.get(eyg2.key()).thenAccept(byArray -> {
                            block13: {
                                try {
                                    if (bl) {
                                        tvc tvc2 = tvc.read(new ByteArrayInputStream((byte[])byArray));
                                        tiq tiq2 = this;
                                        synchronized (tiq2) {
                                            this.tiy.putIfAbsent(string2, tvc2);
                                            break block13;
                                        }
                                    }
                                    if (bl2) {
                                        tzs tzs2 = tzs.read(new ByteArrayInputStream((byte[])byArray));
                                        tiq tiq3 = this;
                                        synchronized (tiq3) {
                                            this.tiz.putIfAbsent(string2, tzs2);
                                            break block13;
                                        }
                                    }
                                    tmh tmh2 = tmh.read(new ByteArrayInputStream((byte[])byArray));
                                    tiq tiq4 = this;
                                    synchronized (tiq4) {
                                        this.tix.putIfAbsent(string2, tmh2);
                                    }
                                }
                                catch (IOException | RuntimeException exception) {
                                    // empty catch block
                                }
                            }
                            ++this.tjg;
                        })).exceptionally(throwable -> null));
                    }
                    return CompletableFuture.allOf(arrayList.toArray(new CompletableFuture[0]));
                })).whenComplete((void_, throwable) -> {
                    this.tjh = false;
                });
            }
            completableFuture = this.tji;
        }
        if (bl) {
            try {
                completableFuture.get(180L, TimeUnit.SECONDS);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public List<eyg> versions() {
        return this.tjc;
    }

    public boolean versionsLoading() {
        return this.tje;
    }

    public void refreshVersions(boolean bl) {
        long l = System.currentTimeMillis();
        if (this.tje || !bl && l - this.tjd < 30000L || !eyn.online()) {
            return;
        }
        this.tje = true;
        this.tjd = l;
        eyn.list(a.c(1357005596, "\u436e\u3a80")).whenComplete((list, throwable) -> {
            if (list != null) {
                ArrayList<eyg> arrayList = new ArrayList<eyg>((Collection<eyg>)list);
                arrayList.sort(Comparator.comparingLong(eyg::uploaded).reversed());
                this.tjc = arrayList;
            }
            this.tje = false;
        });
    }

    public boolean ownVersion(eyg eyg2) {
        return eyg2.key().startsWith(a.b("\uadc1\ud42f", 790212019) + this.id() + a.c(1260879211, "\u7d45"));
    }

    public String activeKey(String string) {
        return this.get(a.b("\u6958\u10eb\u9a33\u0443\u8f9d\u096e", 1089431859) + string, "");
    }

    public synchronized tik cloud(String string) {
        return this.tja.get((Object)string).cloud;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void useVersion(eyg eyg2) {
        String string = eyg2.meta().getOrDefault(a.c(1188281822, "\ubdb1\uc402\u4ed6\ud0ad"), this.kind());
        if (this.ownVersion(eyg2)) {
            this.set(a.b("\ub532\ucc81\u4659\ud829\u53f7\ud504", -1615940263) + string, eyg2.key());
            this.save();
            tiq tiq2 = this;
            synchronized (tiq2) {
                tin tin2 = this.tja.get(string);
                if (tin2 != null) {
                    tin2.key = null;
                    tin2.cloud = tik.SAVED;
                }
            }
            return;
        }
        ((CompletableFuture)eyn.get(eyg2.key()).thenAccept(byArray -> {
            String string2 = a.d("\u31ed\u4803", -1017956678, -1077278939) + this.id() + a.d("\u35b5", 370849568, 532710075) + string + a.c(1839649552, "\ud33e") + System.currentTimeMillis();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(eyg2.meta());
            linkedHashMap.put(a.c(-1683324403, "\u827a\ufbc9\u7107\uef7f\u64a7\ue213\u5849"), this.name);
            linkedHashMap.put(a.d("\u7853\u01f6\u8b38\u154b", -1118507602, 1747621279), eyg2.meta().getOrDefault(a.b("\u9314\ueaa7\u6069\ufe11\u75c9\uf37d\u4927", -293235869), ""));
            eyn.put(string2, byArray, linkedHashMap).thenAccept(bl -> {
                this.set(a.c(-1978569401, "\u6d2c\u149f\u9e477\u8be9\u0d1a") + string, string2);
                this.save();
                tiq tiq2 = this;
                synchronized (tiq2) {
                    tin tin2 = this.tja.get(string);
                    if (tin2 != null) {
                        tin2.key = null;
                        tin2.cloud = tik.SAVED;
                    }
                }
                this.refreshVersions(true);
            });
        })).exceptionally(throwable -> null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deleteVersion(eyg eyg2) {
        Object object;
        if (!this.ownVersion(eyg2)) {
            return;
        }
        String string = eyg2.meta().getOrDefault(a.b("\u2a52\u53e1\ud935\u474e", -1365562819), this.kind());
        if (eyg2.key().equals(this.activeKey(string))) {
            this.set(a.c(-37335931, "\u4cee\u355d\ubf85\u21f5\uaa2b\u2cd8") + string, "");
            this.save();
            object = this;
            synchronized (object) {
                tin tin2 = this.tja.get(string);
                if (tin2 != null) {
                    tin2.model = null;
                    tin2.key = null;
                    tin2.cloud = tik.NONE;
                }
            }
        }
        object = new ArrayList<eyg>(this.tjc);
        object.removeIf(eyg3 -> eyg3.key().equals(eyg2.key()));
        this.tjc = object;
        eyn.delete(List.of(eyg2.key()), null).whenComplete((bl, throwable) -> this.refreshVersions(true));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearRecordings() throws IOException {
        tiq tiq2 = this;
        synchronized (tiq2) {
            this.tix.clear();
            this.tiy.clear();
            this.tiz.clear();
            this.tjb.clear();
            this.tji = null;
            this.tjf = 0;
            this.tjg = 0;
        }
        eyn.delete(null, a.d("\u7059\u09b5", 1432763628, -46445371) + this.id() + a.d("\uf865", 1543416720, 1262048219)).exceptionally(throwable -> false);
        this.set(a.d("\ua7ac\ude1c\u54d2\ucaa4", -980692008, 651129880), 0);
        this.set(a.b("\ucb48\ub2f6\u3820\ua649\u2d8f\uab29\u116d\u989d", 183028518), 0);
        this.set(a.d("\u5f25\u2689\uac50\u3229\ub9e6", 267263412, 1969242848), 0);
        this.set(a.b("\u1293\u6b34\ue1f1\u7f80\uf44d\u72fa\uc8a8\u4144", -1536748824), 0);
        this.set(a.d("\u576c\u2ed9\ua40d\u3a77\ub1eb\u3716\u8d4b\u04b9\u9aea\u1053\u9798", -263271357, -1787061431), 0);
        this.set(a.c(201243991, "\ubd34\uc481\u4e55\ud02f\u5bb3\udd48\u671a\ueeed\u70b8\ufa13\u7dda\u87ad\u097b\u90d7"), 0);
        this.set(a.d("\u83bf\ufa0a\u70de\ueea4\u6538\ue3d3\u599d\ud066\u4e31\uc498", 429348554, -196422382), 0);
        this.set(a.d("\u20c2\u5977\ud3a3\u4dd9\uc645\u40be\ufae0\u7319\ued4a\u67f9\ue02b\u1a50\u9490", -1489106829, 838674641), 0);
        this.set(a.b("\ub50c\uccb9\u466d\ud817\u538b\ud572\u6f26\ue6c4\u7884\uf23d\u75ef", 1605809514), 0);
        this.set(a.d("\u9a64\ue3c3\u691d\uf76b\u7cf9\ufa12\u405c\uc9a7\u57f0\udd59", -1127158206, 1505719387), 0);
        this.set(a.b("\ue4b4\u9d13\u17cd\u89bb\u0229\u84db\u3e80\ub760\u292e\ua388\u245a", 1436411080), 0);
        this.set(a.b("\uee15\u97b2\u1d6c\u831a\u0888\u8e65\u342b\ubdc0\u239e\ua93e\u2efb", -775819671), 0);
        this.set(a.b("\u3319\u4abe\uc060\u5e16\ud584\u5371\ue93d\u60d4\ufe96\u7424", 2022847332), 0);
        this.save();
    }

    public int mineBoost() {
        int n = this.getInt(a.b("\u277f\u5eca\ud41e\u4a64\uc1f8\u4705\ufd5b\u74aa\ueae9\u605f", 248784664), 10);
        return n >= 20 ? 20 : (n >= 10 ? 10 : 0);
    }

    public tck model() {
        return (tck)this.tjo(a.c(1756416358, "\uc904\ub0bd\u3a6a"));
    }

    public tck auraModel() {
        return (tck)this.tjo(a.d("\u3ab3\u4316\uc9c2\u57a0", -1694031378, 1534270264));
    }

    public tck model(boolean bl) {
        return bl ? this.auraModel() : this.model();
    }

    public ttb mineModel() {
        return (ttb)this.tjo(a.d("\u8798\ufe2d\u74f9\uea83", -98668667, 1159719028));
    }

    public txs walkModel() {
        return (txs)this.tjo(a.d("\u5ad8\u237f\ua9a1\u37d7", -55819186, -132636955));
    }

    public synchronized String walkIssue() {
        this.tjo(a.d("\u607b\u19dc\u9302\u0d74", 1864286154, 1775755202));
        return this.tja.get((Object)a.d((String)"\uf3d7\u8a70\u00ae\u9ed8", (int)473141132, (int)1554938920)).issue;
    }

    public synchronized String modelIssue(boolean bl) {
        this.tjo(bl ? a.b("\uadc2\ud467\u5eb3\uc0d1", -568611417) : a.c(-1352913341, "\u2e21\u5798\udd4f"));
        return this.tja.get((Object)(bl ? a.c((int)-1108886205, (String)"\ubd26\uc483\u4e57\ud035") : a.d((String)"\u8042\uf9fb\u732c", (int)-1658015775, (int)433008577))).issue;
    }

    public synchronized String mineIssue() {
        this.tjo(a.c(1436060964, "\u8d4d\uf4f8\u7e2c\ue056"));
        return this.tja.get((Object)a.d((String)"\u2802\u51b7\udb63\u4519", (int)1665687304, (int)988706659)).issue;
    }

    public synchronized boolean modelLoading(String string) {
        return this.tja.get((Object)string).loading;
    }

    private synchronized Object tjo(String string) {
        tin tin2 = this.tja.get(string);
        String string2 = this.activeKey(string);
        if (string2.isEmpty() || string2.equals(tin2.key) || tin2.loading || System.currentTimeMillis() < tin2.retryAt) {
            return tin2.model;
        }
        if (!eyn.online()) {
            return tin2.model;
        }
        tin2.loading = true;
        eyn.get(string2).whenComplete((byArray, throwable) -> {
            ttb ttb2 = null;
            String string3 = "";
            if (byArray != null) {
                try {
                    ttb2 = a.b("\u637c\u1ac9\u901d\u0e67", -689741035).equals(string) ? ttb.read(new ByteArrayInputStream((byte[])byArray)) : (a.b("\udf04\ua6a3\u2c7d\ub20b", 912318327).equals(string) ? txs.read(new ByteArrayInputStream((byte[])byArray)) : tck.read(new ByteArrayInputStream((byte[])byArray)));
                }
                catch (IOException | RuntimeException exception) {
                    string3 = String.valueOf(exception.getMessage()).startsWith(a.d("\u0122\u7890\uf24b\u6c7e\ue7e4\u6157\udb0f\u52ff\ucca9", -2022362133, 2130129583)) ? a.d("\uf926\u8094\u0a4f", 147274160, 497271034) : a.c(-184036973, "\ud1f7\ua856\u2298\ubced\u3734\ub18e");
                }
            } else {
                string3 = a.d("\u70ab\u091e\u83d7\u1da6\u966b\u10dd\uaa87", -1749288695, 635013576);
            }
            tiq tiq2 = this;
            synchronized (tiq2) {
                tin2.loading = false;
                if (byArray == null) {
                    tin2.retryAt = System.currentTimeMillis() + 30000L;
                    tin2.issue = string3;
                } else if (string2.equals(this.activeKey(string))) {
                    tin2.key = string2;
                    tin2.issue = string3;
                    if (ttb2 != null) {
                        tin2.model = ttb2;
                        tin2.cloud = tik.SAVED;
                    }
                }
            }
        });
        return tin2.model;
    }

    public String dataStamp() {
        long l = 0L;
        List<tmh> list = this.tapes();
        for (tmh tmh2 : list) {
            l += (long)tmh2.ticks.size();
        }
        return list.size() + a.b("\u1199", -618917470) + l + a.d("\udb71", -1335435073, 39926773) + this.clean() + a.d("\udb13", -1503161413, 317147283) + 60 + a.b("\ub75b", -37374112) + this.purpose();
    }

    /*
     * Exception decompiling
     */
    public int needSamples() {
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

    /*
     * Exception decompiling
     */
    public int needFlicks() {
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

    /*
     * Exception decompiling
     */
    public int needTracking() {
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

    public void saveModel(tck tck2, boolean bl) throws IOException {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(a.b("\u79ac\u0007\u8ad0\u14a5\u9f77\u19cb\ua38b\u2a61\ub423\u3e9f", -1891337771), String.valueOf(Math.round(tck2.similarity)));
        this.tjp(bl ? a.b("\uebc0\u9265\u18b1\u86d3", -1720390747) : a.d("\u87e6\ufe5f\u7488", 223986326, -1290779374), tck2, tck2.bytes(), linkedHashMap, tck2.created);
    }

    public void saveMineModel(ttb ttb2) throws IOException {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(a.b("\u3fcb\u4661\uccad\u529d", -1957937221), String.valueOf(Math.round(ttb2.top1)));
        linkedHashMap.put(a.b("\u1c4d\u65f5\uef29\u7152", -1244914655), String.valueOf(Math.round(ttb2.hand.similarity)));
        linkedHashMap.put(a.c(-1786798455, "\u9ee1\ue759\u6d88\uf3ed"), ttb2.legs == null ? "" : String.valueOf(Math.round(ttb2.legsAcc)));
        linkedHashMap.put(a.d("\u6f63\u16df\u9c0c\u0261\u89b1", -37230266, 1505658434), String.valueOf(ttb2.boost));
        this.tjp(a.b("\u6242\u1bf7\u9123\u0f59", -2081398229), ttb2, ttb2.bytes(), linkedHashMap, ttb2.created);
    }

    public void saveWalkModel(txs txs2) throws IOException {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(a.c(1126803187, "\ua69c\udf23\u55ec\ucb97"), String.valueOf(Math.round(txs2.keysAcc)));
        linkedHashMap.put(a.d("\u698d\u103d\u9ae9\u0484", -14755708, -1152798343), String.valueOf(Math.round(txs2.yawSim)));
        linkedHashMap.put(a.b("\ub42a\ucd89\u4756\ud93a\u52f1\ud449\u6e0c", 562082910), String.valueOf(txs2.samples));
        this.tjp(a.d("\uc1f3\ub854\u328a\uacfc", 1375617296, -579501936), txs2, txs2.bytes(), linkedHashMap, txs2.created);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void tjp(String string, Object object, byte[] byArray, Map<String, String> map, long l) {
        String string2 = a.b("\u4267\u3b89", -380026347) + this.id() + a.d("\u381d", 188684499, -1589436192) + string + a.d("\u3308", 1693892526, 548244616) + l;
        map.put(a.b("\u7e19\u07aa\u8d7e\u1305", -1427734922), string);
        map.put(a.c(-849418035, "\ue8ba\u9109\u1bc7\u85bf\u0e67\u88d3\u3289"), this.name);
        map.put(a.b("\u318f\u482f\uc2eb\u5c9e\ud75c\u51fc\uebae", -1029688853), String.valueOf(l));
        tiq tiq2 = this;
        synchronized (tiq2) {
            tin tin2 = this.tja.get(string);
            tin2.model = object;
            tin2.key = string2;
            tin2.issue = "";
            tin2.loading = false;
            tin2.cloud = eyn.online() ? tik.SAVING : tik.NONE;
        }
        if (!eyn.online()) {
            return;
        }
        eyn.put(string2, byArray, map).whenComplete((bl, throwable) -> {
            boolean bl2;
            boolean bl3 = bl2 = bl != null && bl != false;
            if (bl2) {
                this.set(a.b("\u05f7\u7c44\uf69c\u68ec\ue332\u65c1", -2000091748) + string, string2);
                this.save();
            }
            tiq tiq2 = this;
            synchronized (tiq2) {
                tin tin2 = this.tja.get(string);
                if (string2.equals(tin2.key)) {
                    tin2.cloud = bl2 ? tik.SAVED : tik.FAILED;
                }
            }
            this.refreshVersions(true);
        });
    }

    public String get(String string, String string2) {
        String string3 = this.tiw.getProperty(string);
        return string3 == null ? string2 : string3;
    }

    public int getInt(String string, int n) {
        try {
            return Integer.parseInt(this.tiw.getProperty(string, String.valueOf(n)).trim());
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public long getLong(String string, long l) {
        try {
            return Long.parseLong(this.tiw.getProperty(string, String.valueOf(l)).trim());
        }
        catch (NumberFormatException numberFormatException) {
            return l;
        }
    }

    public double getDouble(String string, double d) {
        try {
            return Double.parseDouble(this.tiw.getProperty(string, String.valueOf(d)).trim());
        }
        catch (NumberFormatException numberFormatException) {
            return d;
        }
    }

    public boolean getBool(String string, boolean bl) {
        String string2 = this.tiw.getProperty(string);
        return string2 == null ? bl : Boolean.parseBoolean(string2.trim());
    }

    public synchronized void set(String string, Object object) {
        this.tiw.setProperty(string, String.valueOf(object));
    }

    public void add(String string, long l) {
        this.set(string, this.getLong(string, 0L) + l);
    }

    public int standCount() {
        return Math.max(1, Math.min(4, this.getInt(a.c(-577448753, "\ud4b0\uad06\u27c0\ub9be\u3263\ub4c5\u0ecb\u8777\u1924\u938f\u1447\uee2c"), 2)));
    }

    public String standMode() {
        String string = this.get(a.c(-1563874357, "\u2bb3\u5205\ud8c3\u46bd\ucd60\u4bc6\uf1c8\u787a\ue627\u6c9d\ueb4f"), a.c(1536221333, "\ue0db\u994e\u138c"));
        for (String string2 : STAND_MODES) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return a.b("\ua8d6\ud143\u5b81", -1164007272);
    }

    public double standNear() {
        return Math.max(2.0, Math.min(6.0, this.getDouble(a.d("\u7ee6\u0750\u8d96\u13e8\u9835\u1e93\ua49d\u2d2c\ub378\u39cd\ube0d", -36564154, 889548248), 2.3)));
    }

    public double standFar() {
        return Math.max(this.standNear(), Math.min(7.0, this.getDouble(a.c(-1411967840, "\u14d9\u6d6f\ue7a9\u79d7\uf20a\u74ac\ucea2\u471b\ud943\u53e1"), 3.5)));
    }

    public double standSpeed() {
        return Math.max(0.3, Math.min(1.6, this.getDouble(a.c(-1462535373, "\u7b4c\u02fa\u883c\u1642\u9d9f\u1b39\ua137\u289b\ub6c7\u3c63\ubbb0\u41c0"), 1.0)));
    }

    public String quality() {
        String string = this.get(a.b("\uf990\u8027\u0ae7\u949e\u1f4e\u99f4\u23b0\uaa1d\u341d\ubea8\u396f\uc313\u4dc1\ud46d\u5e33", 1042610667), a.c(-468626219, "\u549d\u2d0d\ua7c3\u39ad\ub276\u34ca"));
        for (String string2 : QUALITIES) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return a.b("\u94f6\ued66\u67a8\uf9c6\u721d\uf4a1", -1597139778);
    }

    public String size() {
        String string = this.get(a.b("\u1e25\u6792\ued52\u732b\uf8fb\u7e41\uc405\u4da8\ud3aa\u5901\udec1\u24af", 460136029), a.c(377851639, "\u8ebc\uf725\u7df7\ue38b\u6840\ueee9"));
        for (String string2 : SIZES) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return a.d("\uced3\ub74a\u3d98\ua3e4\u282f\uae86", -663971051, -1042131571);
    }

    public boolean mirror() {
        return this.getBool(a.d("\u8cc9\uf57e\u7fbe\ue1c7\u6a17\uecad\u56e9\udf44\u4158\ucbed\u4c25\ub654\u389e\ua132", -1747340207, -487114526), true);
    }

    public boolean clean() {
        return this.getBool(a.d("\u9adb\ue36c\u69ac\uf7d5\u7c05\ufabf\u40fb\uc956\u5744\uddfa\u5a20\ua055\u2e8d", 844367052, -1475699090), true);
    }

    public boolean fights() {
        return this.getBool(a.d("\u04a5\u7d1b\uf7c6\u69b8\ue273\u64c5", -2019782119, -1957062948), false);
    }

    /*
     * Exception decompiling
     */
    public tmk trainerConfig() {
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

    public void save() {
        String string = this.tjr();
        vza.later(a.b("\ua7df\ude65\u54a6\ucad0\u411a\uc7e4\u7de7\uf414\u6a56\ue0ee\u6732\u9d46\u1398\u8a6c", -471095361) + this.name, () -> this.tjq(string));
    }

    public void saveNow() throws IOException {
        this.tjq(this.tjr());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void tjq(String string) {
        Class<tiq> clazz = tiq.class;
        synchronized (tiq.class) {
            if (tiu.get(this.name) == this) {
                ewk.put(a.d("\u7865\u01df\u8b1c\u156a\u9ea0\u1850\ua25d\u2bf2", 250720199, 1750390724) + this.name, string);
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    private synchronized String tjr() {
        StringBuilder stringBuilder = new StringBuilder();
        this.tiw.stringPropertyNames().stream().sorted().forEach(string -> stringBuilder.append((String)string).append('=').append(this.tiw.getProperty((String)string).replace(a.b("\u7f59", -1151041788), a.d("\u8d0f\uf4be", 405367201, -416750352))).append('\n'));
        return stringBuilder.toString();
    }

    public String newTapeName() {
        return String.format(Locale.ROOT, a.c(-1063314654, "\u1b02\u62f2\ue868\u7611\ufd87"), System.currentTimeMillis(), System.nanoTime() & 0xFFFFL);
    }

    static {
        AIM = a.b("\u2691\u5f28\ud5ff", -466737421);
        AURA = a.b("\u589f\u213a\uabee\u358c", -281454342);
        MINE = a.d("\u4bd4\u3261\ub8b5\u26cf", -748936263, -1389926396);
        WALK = a.b("\u5bde\u2279\ua8a7\u36d1", 318790573);
        tir = a.b("\uc27b\ubbc1\u3102\uaf74\u24be\ua24e\u185a\u91ac\u0ff9\u8549\u0287", 335069726);
        tis = a.b("\u3fcf\u4675\uccb6\u52c0\ud90a\u5ffa\ue5f7\u6c58", -544653399);
        STAND_MODES = new String[]{a.c(1448350795, "\u1405\u6d90\ue752"), a.d("\uc94b\ub0cb\u3a08\ua470", -1386301318, -1696042639), a.d("\uf68a\u8f1c\u05c9\u9bab\u107b\u96c9", 95415482, 1708923493), a.c(-1277893349, "\ue554\u9cda\u1611\u887d\u03a3"), a.b("\u1350\u6ad7\ue009\u7e7f", -1004530941), a.b("\u2291\u5b07\ud1c9\u4fbd\uc46a", -1697504569)};
        QUALITIES = new String[]{a.b("\ucfe4\ub672\u3cb3\ua2c5", 284151718), a.b("\u216e\u58fe\ud230\u4c5e\uc785\u4139", 1386422566), a.b("\u8a04\uf399\u7953", -1195079094)};
        SIZES = new String[]{a.c(1516049024, "\u12d6\u6b59\ue186\u7ffa\uf42d"), a.c(311310460, "\u3837\u41ae\ucb7c\u5500\udecb\u5862"), a.c(1029090452, "\uacdd\ud541\u5f81\uc1e5\u4a30")};
        PURPOSES = new String[]{a.d("\u4f22\u36bb\ubc6c", 2146427560, -1210470968), a.b("\u822b\ufbae\u717a\uef18", -1961196946), a.c(902521595, "\u62b2\u1b27\u91f3\u0f89"), a.c(1198959546, "\uabe9\ud26e\u58b0\uc6c6")};
        BOOSTS = new int[]{0, 10, 20};
        tit = new String[]{a.c(457859688, "\u6206\u1bb2\u9174\u0f10\u8488\u0264\ub830\u31d4\uaf87\u252b")};
        tiu = new LinkedHashMap<String, tiq>();
    }

    private static /* synthetic */ int clp(int n, int n2) {
        return n + n2 + 1433623867;
    }
}

