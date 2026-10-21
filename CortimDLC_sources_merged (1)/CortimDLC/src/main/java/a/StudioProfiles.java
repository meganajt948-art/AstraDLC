/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.CloudSync;
import a.eyg;
import a.CloudConfigs;
import a.AimModel;
import a.tij;
import a.tik;
import a.tin;
import a.RecordingReader;
import a.tmk;
import a.MineModelReader;
import a.MineRecordingReader;
import a.WalkModelReader;
import a.WalkRecordingReader;
import a.FileWriter;
import flow.dev.StringDecryptor;
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

public final class StudioProfiles {
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
    private static final Map<String, StudioProfiles> tiu;
    private static boolean tiv;
    public final String name;
    private final Properties tiw = new Properties();
    private final Map<String, RecordingReader> tix = new LinkedHashMap<String, RecordingReader>();
    private final Map<String, MineRecordingReader> tiy = new LinkedHashMap<String, MineRecordingReader>();
    private final Map<String, WalkRecordingReader> tiz = new LinkedHashMap<String, WalkRecordingReader>();
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

    private StudioProfiles(String string, String string2) {
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
        this.tja.put("aim", new tin());
        this.tja.put("aura", new tin());
        this.tja.put("mine", new tin());
        this.tja.put("walk", new tin());
    }

    public static synchronized List<StudioProfiles> list() {
        StudioProfiles.tjl();
        ArrayList<StudioProfiles> arrayList = new ArrayList<StudioProfiles>(tiu.values());
        arrayList.sort(Comparator.comparingLong(tiq2 -> tiq2.getLong("created", 0L)).thenComparing(tiq2 -> tiq2.name));
        return arrayList;
    }

    public static synchronized StudioProfiles open(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        StudioProfiles.tjl();
        return tiu.get(string);
    }

    private static void tjl() {
        if (tiv) {
            return;
        }
        tiv = true;
        String string = CloudSync.get("neuro.index");
        if (string == null) {
            return;
        }
        for (String string2 : string.split("\n")) {
            String string3;
            String string4 = string2.trim();
            if (string4.isEmpty() || tiu.containsKey(string4) || (string3 = CloudSync.get("neuro.p." + string4)) == null || string3.isEmpty()) continue;
            tiu.put(string4, new StudioProfiles(string4, string3));
        }
    }

    private static void tjm() {
        CloudSync.put("neuro.index", String.join((CharSequence)"\n", tiu.keySet()));
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

    public static synchronized StudioProfiles create(String string) throws IOException {
        String string2 = StudioProfiles.clean(string);
        if (string2.isEmpty()) {
            throw new IOException("empty");
        }
        StudioProfiles.tjl();
        if (tiu.containsKey(string2)) {
            throw new IOException("exists");
        }
        StudioProfiles tiq2 = new StudioProfiles(string2, null);
        tiq2.set("created", System.currentTimeMillis());
        tiq2.id();
        tiu.put(string2, tiq2);
        StudioProfiles.tjm();
        tiq2.saveNow();
        return tiq2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized void delete(StudioProfiles tiq2) throws IOException {
        if (tiq2 == null || tiu.remove(tiq2.name) == null) {
            return;
        }
        StudioProfiles.tjm();
        CloudSync.put("neuro.p." + tiq2.name, "");
        String string = tiq2.id();
        CloudConfigs.delete(null, "p/" + string + "/").exceptionally(throwable -> false);
        CloudConfigs.delete(null, "r/" + string + "/").exceptionally(throwable -> false);
        StudioProfiles tiq3 = tiq2;
        synchronized (tiq3) {
            tiq2.tix.clear();
            tiq2.tiy.clear();
            tiq2.tiz.clear();
        }
    }

    public synchronized String id() {
        String string = this.tiw.getProperty("id");
        if (string == null || !string.matches("[0-9a-f]{12}")) {
            string = String.format(Locale.ROOT, "%012x", new SecureRandom().nextLong() & 0xFFFFFFFFFFFFL);
            this.tiw.setProperty("id", string);
            this.save();
        }
        return string;
    }

    public String purpose() {
        String string = this.get("purpose", "Aim");
        return string.equalsIgnoreCase("Aura") ? "Aura" : (string.equalsIgnoreCase("Mine") ? "Mine" : (string.equalsIgnoreCase("Walk") ? "Walk" : "Aim"));
    }

    public boolean aura() {
        return this.purpose().equals("Aura");
    }

    public boolean mine() {
        return this.purpose().equals("Mine");
    }

    public boolean walk() {
        return this.purpose().equals("Walk");
    }

    public String kind() {
        return this.aura() ? "aura" : (this.mine() ? "mine" : (this.walk() ? "walk" : "aim"));
    }

    public synchronized List<WalkRecordingReader> walkTapes() {
        return new ArrayList<WalkRecordingReader>(this.tiz.values());
    }

    public synchronized void putWalkTape(String string, WalkRecordingReader tzs2) {
        this.tiz.put(string, tzs2);
    }

    public void uploadWalkTape(String string, WalkRecordingReader tzs2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("kind", "walk");
        linkedHashMap.put("profile", this.name);
        linkedHashMap.put("ticks", String.valueOf(tzs2.ticks.size()));
        linkedHashMap.put("lanes", String.valueOf(tzs2.lanes.size()));
        this.tjn("r/" + this.id() + "/" + string, tzs2::bytes, linkedHashMap);
    }

    public synchronized List<MineRecordingReader> mineTapes() {
        return new ArrayList<MineRecordingReader>(this.tiy.values());
    }

    public synchronized void putMineTape(String string, MineRecordingReader tvc2) {
        this.tiy.put(string, tvc2);
    }

    public synchronized List<RecordingReader> tapes() {
        return new ArrayList<RecordingReader>(this.tix.values());
    }

    public synchronized void putTape(String string, RecordingReader tmh2) {
        this.tix.put(string, tmh2);
    }

    public void uploadTape(String string, RecordingReader tmh2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("kind", "tape");
        linkedHashMap.put("profile", this.name);
        linkedHashMap.put("ticks", String.valueOf(tmh2.ticks.size()));
        this.tjn("r/" + this.id() + "/" + string, tmh2::bytes, linkedHashMap);
    }

    public void uploadMineTape(String string, MineRecordingReader tvc2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("kind", "mine");
        linkedHashMap.put("profile", this.name);
        linkedHashMap.put("ticks", String.valueOf(tvc2.ticks.size()));
        linkedHashMap.put("hits", String.valueOf(tvc2.hits.size()));
        this.tjn("r/" + this.id() + "/" + string, tvc2::bytes, linkedHashMap);
    }

    private void tjn(String string, tij tij2, Map<String, String> map) {
        if (!CloudConfigs.online()) {
            return;
        }
        CompletableFuture.runAsync(() -> {
            try {
                byte[] byArray = tij2.get();
                CloudConfigs.put(string, byArray, map).exceptionally(throwable -> false);
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
        StudioProfiles tiq2 = this;
        synchronized (tiq2) {
            if (this.tji == null || this.tji.isCompletedExceptionally()) {
                if (!CloudConfigs.online()) {
                    return;
                }
                this.tjh = true;
                String string = "r/" + this.id() + "/";
                this.tji = ((CompletableFuture)CloudConfigs.list(string).thenCompose(list -> {
                    this.tjf = list.size();
                    ArrayList<CompletionStage> arrayList = new ArrayList<CompletionStage>();
                    for (eyg eyg2 : list) {
                        String string2 = eyg2.key().substring(string.length());
                        StudioProfiles tiq2 = this;
                        synchronized (tiq2) {
                            if (this.tix.containsKey(string2) || this.tiy.containsKey(string2) || this.tiz.containsKey(string2) || !this.tjb.add(string2)) {
                                ++this.tjg;
                                continue;
                            }
                        }
                        boolean bl = "mine".equals(eyg2.meta().get("kind"));
                        boolean bl2 = "walk".equals(eyg2.meta().get("kind"));
                        arrayList.add(((CompletableFuture)CloudConfigs.get(eyg2.key()).thenAccept(byArray -> {
                            block13: {
                                try {
                                    if (bl) {
                                        MineRecordingReader tvc2 = MineRecordingReader.read(new ByteArrayInputStream((byte[])byArray));
                                        StudioProfiles tiq2 = this;
                                        synchronized (tiq2) {
                                            this.tiy.putIfAbsent(string2, tvc2);
                                            break block13;
                                        }
                                    }
                                    if (bl2) {
                                        WalkRecordingReader tzs2 = WalkRecordingReader.read(new ByteArrayInputStream((byte[])byArray));
                                        StudioProfiles tiq3 = this;
                                        synchronized (tiq3) {
                                            this.tiz.putIfAbsent(string2, tzs2);
                                            break block13;
                                        }
                                    }
                                    RecordingReader tmh2 = RecordingReader.read(new ByteArrayInputStream((byte[])byArray));
                                    StudioProfiles tiq4 = this;
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
        if (this.tje || !bl && l - this.tjd < 30000L || !CloudConfigs.online()) {
            return;
        }
        this.tje = true;
        this.tjd = l;
        CloudConfigs.list("p/").whenComplete((list, throwable) -> {
            if (list != null) {
                ArrayList<eyg> arrayList = new ArrayList<eyg>((Collection<eyg>)list);
                arrayList.sort(Comparator.comparingLong(eyg::uploaded).reversed());
                this.tjc = arrayList;
            }
            this.tje = false;
        });
    }

    public boolean ownVersion(eyg eyg2) {
        return eyg2.key().startsWith("p/" + this.id() + "/");
    }

    public String activeKey(String string) {
        return this.get("model." + string, "");
    }

    public synchronized tik cloud(String string) {
        return this.tja.get((Object)string).cloud;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void useVersion(eyg eyg2) {
        String string = eyg2.meta().getOrDefault("kind", this.kind());
        if (this.ownVersion(eyg2)) {
            this.set("model." + string, eyg2.key());
            this.save();
            StudioProfiles tiq2 = this;
            synchronized (tiq2) {
                tin tin2 = this.tja.get(string);
                if (tin2 != null) {
                    tin2.key = null;
                    tin2.cloud = tik.SAVED;
                }
            }
            return;
        }
        ((CompletableFuture)CloudConfigs.get(eyg2.key()).thenAccept(byArray -> {
            String string2 = "p/" + this.id() + "/" + string + "/" + System.currentTimeMillis();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(eyg2.meta());
            linkedHashMap.put("profile", this.name);
            linkedHashMap.put("from", eyg2.meta().getOrDefault("profile", ""));
            CloudConfigs.put(string2, byArray, linkedHashMap).thenAccept(bl -> {
                this.set("model." + string, string2);
                this.save();
                StudioProfiles tiq2 = this;
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
        String string = eyg2.meta().getOrDefault("kind", this.kind());
        if (eyg2.key().equals(this.activeKey(string))) {
            this.set("model." + string, "");
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
        CloudConfigs.delete(List.of(eyg2.key()), null).whenComplete((bl, throwable) -> this.refreshVersions(true));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearRecordings() throws IOException {
        StudioProfiles tiq2 = this;
        synchronized (tiq2) {
            this.tix.clear();
            this.tiy.clear();
            this.tiz.clear();
            this.tjb.clear();
            this.tji = null;
            this.tjf = 0;
            this.tjg = 0;
        }
        CloudConfigs.delete(null, "r/" + this.id() + "/").exceptionally(throwable -> false);
        this.set("hits", 0);
        this.set("filtered", 0);
        this.set("ticks", 0);
        this.set("sessions", 0);
        this.set("mine.blocks", 0);
        this.set("mine.decisions", 0);
        this.set("mine.ticks", 0);
        this.set("mine.diamonds", 0);
        this.set("mine.farmed", 0);
        this.set("walk.ticks", 0);
        this.set("walk.meters", 0);
        this.set("walk.routes", 0);
        this.set("walk.jumps", 0);
        this.save();
    }

    public int mineBoost() {
        int n = this.getInt("mine.boost", 10);
        return n >= 20 ? 20 : (n >= 10 ? 10 : 0);
    }

    public AimModel model() {
        return (AimModel)this.tjo("aim");
    }

    public AimModel auraModel() {
        return (AimModel)this.tjo("aura");
    }

    public AimModel model(boolean bl) {
        return bl ? this.auraModel() : this.model();
    }

    public MineModelReader mineModel() {
        return (MineModelReader)this.tjo("mine");
    }

    public WalkModelReader walkModel() {
        return (WalkModelReader)this.tjo("walk");
    }

    public synchronized String walkIssue() {
        this.tjo("walk");
        return this.tja.get((Object)"walk").issue;
    }

    public synchronized String modelIssue(boolean bl) {
        this.tjo(bl ? "aura" : "aim");
        return this.tja.get((Object)(bl ? "aura" : "aim")).issue;
    }

    public synchronized String mineIssue() {
        this.tjo("mine");
        return this.tja.get((Object)"mine").issue;
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
        if (!CloudConfigs.online()) {
            return tin2.model;
        }
        tin2.loading = true;
        CloudConfigs.get(string2).whenComplete((byArray, throwable) -> {
            MineModelReader ttb2 = null;
            String string3 = "";
            if (byArray != null) {
                try {
                    ttb2 = "mine".equals(string) ? MineModelReader.read(new ByteArrayInputStream((byte[])byArray)) : ("walk".equals(string) ? WalkModelReader.read(new ByteArrayInputStream((byte[])byArray)) : AimModel.read(new ByteArrayInputStream((byte[])byArray)));
                }
                catch (IOException | RuntimeException exception) {
                    string3 = String.valueOf(exception.getMessage()).startsWith("old model") ? "old" : "broken";
                }
            } else {
                string3 = "missing";
            }
            StudioProfiles tiq2 = this;
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
        List<RecordingReader> list = this.tapes();
        for (RecordingReader tmh2 : list) {
            l += (long)tmh2.ticks.size();
        }
        return list.size() + ":" + l + ":" + this.clean() + ":" + 60 + ":" + this.purpose();
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

    public void saveModel(AimModel tck2, boolean bl) throws IOException {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("similarity", String.valueOf(Math.round(tck2.similarity)));
        this.tjp(bl ? "aura" : "aim", tck2, tck2.bytes(), linkedHashMap, tck2.created);
    }

    public void saveMineModel(MineModelReader ttb2) throws IOException {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("top1", String.valueOf(Math.round(ttb2.top1)));
        linkedHashMap.put("hand", String.valueOf(Math.round(ttb2.hand.similarity)));
        linkedHashMap.put("legs", ttb2.legs == null ? "" : String.valueOf(Math.round(ttb2.legsAcc)));
        linkedHashMap.put("boost", String.valueOf(ttb2.boost));
        this.tjp("mine", ttb2, ttb2.bytes(), linkedHashMap, ttb2.created);
    }

    public void saveWalkModel(WalkModelReader txs2) throws IOException {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("keys", String.valueOf(Math.round(txs2.keysAcc)));
        linkedHashMap.put("turn", String.valueOf(Math.round(txs2.yawSim)));
        linkedHashMap.put("samples", String.valueOf(txs2.samples));
        this.tjp("walk", txs2, txs2.bytes(), linkedHashMap, txs2.created);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void tjp(String string, Object object, byte[] byArray, Map<String, String> map, long l) {
        String string2 = "p/" + this.id() + "/" + string + "/" + l;
        map.put("kind", string);
        map.put("profile", this.name);
        map.put("created", String.valueOf(l));
        StudioProfiles tiq2 = this;
        synchronized (tiq2) {
            tin tin2 = this.tja.get(string);
            tin2.model = object;
            tin2.key = string2;
            tin2.issue = "";
            tin2.loading = false;
            tin2.cloud = CloudConfigs.online() ? tik.SAVING : tik.NONE;
        }
        if (!CloudConfigs.online()) {
            return;
        }
        CloudConfigs.put(string2, byArray, map).whenComplete((bl, throwable) -> {
            boolean bl2;
            boolean bl3 = bl2 = bl != null && bl != false;
            if (bl2) {
                this.set("model." + string, string2);
                this.save();
            }
            StudioProfiles tiq2 = this;
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
        return Math.max(1, Math.min(4, this.getInt("stands.count", 2)));
    }

    public String standMode() {
        String string = this.get("stands.mode", "Mix");
        for (String string2 : STAND_MODES) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return "Mix";
    }

    public double standNear() {
        return Math.max(2.0, Math.min(6.0, this.getDouble("stands.near", 2.3)));
    }

    public double standFar() {
        return Math.max(this.standNear(), Math.min(7.0, this.getDouble("stands.far", 3.5)));
    }

    public double standSpeed() {
        return Math.max(0.3, Math.min(1.6, this.getDouble("stands.speed", 1.0)));
    }

    public String quality() {
        String string = this.get("trainer.quality", "Normal");
        for (String string2 : QUALITIES) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return "Normal";
    }

    public String size() {
        String string = this.get("trainer.size", "Medium");
        for (String string2 : SIZES) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return "Medium";
    }

    public boolean mirror() {
        return this.getBool("trainer.mirror", true);
    }

    public boolean clean() {
        return this.getBool("trainer.clean", true);
    }

    public boolean fights() {
        return this.getBool("fights", false);
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
        FileWriter.later("neuro profile " + this.name, () -> this.tjq(string));
    }

    public void saveNow() throws IOException {
        this.tjq(this.tjr());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void tjq(String string) {
        Class<StudioProfiles> clazz = StudioProfiles.class;
        synchronized (StudioProfiles.class) {
            if (tiu.get(this.name) == this) {
                CloudSync.put("neuro.p." + this.name, string);
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    private synchronized String tjr() {
        StringBuilder stringBuilder = new StringBuilder();
        this.tiw.stringPropertyNames().stream().sorted().forEach(string -> stringBuilder.append((String)string).append('=').append(this.tiw.getProperty((String)string).replace("\\", "\\\\")).append('\n'));
        return stringBuilder.toString();
    }

    public String newTapeName() {
        return String.format(Locale.ROOT, "%d-%d", System.currentTimeMillis(), System.nanoTime() & 0xFFFFL);
    }

    static {
        AIM = "aim";
        AURA = "aura";
        MINE = "mine";
        WALK = "walk";
        tir = "neuro.index";
        tis = "neuro.p.";
        STAND_MODES = new String[]{"Mix", "Duel", "Strafe", "Jumpy", "Walk", "Still"};
        QUALITIES = new String[]{"Fast", "Normal", "Max"};
        SIZES = new String[]{"Small", "Medium", "Large"};
        PURPOSES = new String[]{"Aim", "Aura", "Mine", "Walk"};
        BOOSTS = new int[]{0, 10, 20};
        tit = new String[]{"data.stamp"};
        tiu = new LinkedHashMap<String, StudioProfiles>();
    }

    private static /* synthetic */ int clp(int n, int n2) {
        return n + n2 + 1433623867;
    }
}

