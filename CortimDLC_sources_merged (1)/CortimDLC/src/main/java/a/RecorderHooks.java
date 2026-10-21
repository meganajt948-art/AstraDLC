/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents
 *  net.fabricmc.fabric.api.event.player.AttackBlockCallback
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3966
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.PanicShutdown;
import a.BotRuntime;
import a.Friends;
import a.Module;
import a.AutoMace;
import a.Aura;
import a.AutoMine;
import a.AncientFarmer;
import a.AutoMines;
import a.FreeCam;
import a.MineTools;
import a.AimTrace;
import a.AimModel;
import a.tct;
import a.tcw;
import a.StudioProfiles;
import a.AimRecorder;
import a.DummyPlayer;
import a.RecordingReader;
import a.tmk;
import a.tmt;
import a.NeuroWorker;
import a.MineRecorder;
import a.WardenRecorder;
import a.Reflect;
import a.FileWriter;
import a.KeyUtil;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3966;
import net.minecraft.class_638;
import net.minecraft.class_746;

public final class RecorderHooks {
    private static final int tda = -789577728;
    private static final String[] tdb = new String[]{"Dummy_Ace", "Dummy_Bolt", "Dummy_Crow", "Dummy_Dusk"};
    private static final List<DummyPlayer> tdc = new ArrayList<DummyPlayer>();
    private static final Random tdd = new Random();
    private static tcw tde = tcw.NONE;
    private static StudioProfiles tdf;
    private static AimRecorder tdg;
    private static MineRecorder tdh;
    private static WardenRecorder tdi;
    private static Module tdj;
    private static AimRecorder tdk;
    private static class_638 tdl;
    private static Field tdm;
    private static boolean tdn;
    private static boolean tdo;
    private static volatile tct tdp;
    private static volatile StudioProfiles tdq;
    private static /* synthetic */ long tdr;
    private static /* synthetic */ boolean tds;

    private RecorderHooks() {
    }

    public static void install() {
        ClientTickEvents.START_CLIENT_TICK.register(RecorderHooks::tea);
        ClientTickEvents.END_CLIENT_TICK.register(RecorderHooks::teb);
        try {
            AttackBlockCallback.EVENT.register((class_16572, class_19372, class_12682, class_23382, class_23502) -> {
                MineRecorder ttl2 = tdh;
                class_310 class_3102 = class_310.method_1551();
                if (ttl2 != null && class_19372.method_8608() && class_16572 == class_3102.field_1724 && !BotRuntime.isActive()) {
                    ttl2.attack(class_3102, class_23382, class_23502);
                }
                return class_1269.field_5811;
            });
            ClientPlayerBlockBreakEvents.AFTER.register((class_6382, class_7462, class_23382, class_26802) -> {
                MineRecorder ttl2 = tdh;
                if (ttl2 != null && class_7462 == class_310.method_1551().field_1724 && !BotRuntime.isActive()) {
                    ttl2.broken(class_26802);
                }
            });
        }
        catch (Throwable throwable) {
            System.out.println("mine recording hooks unavailable: " + throwable);
        }
    }

    public static MineRecorder mineRecorder() {
        return tdh;
    }

    public static WardenRecorder walkRecorder() {
        return tdi;
    }

    public static boolean walkGuide() {
        return tdi != null && !PanicShutdown.armed();
    }

    public static void startWalking(StudioProfiles tiq2, String string) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || tiq2 == null) {
            return;
        }
        RecorderHooks.stop();
        RecorderHooks.tdw();
        tdf = tiq2;
        tde = tcw.RECORD;
        tdl = class_3102.field_1687;
        String string2 = "AutoWarden".equals(string) ? "AutoWarden" : "AutoEnd";
        tdi = new WardenRecorder(tiq2, string2, (float)RecorderHooks.unit(class_3102));
        Module kfe2 = RecorderHooks.tee(string2);
        tdj = null;
        if (kfe2 != null && !kfe2.isEnabled()) {
            kfe2.setEnabled(true);
            tdj = kfe2;
        }
    }

    private static String tdt(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_3102.field_1755 != null) {
            return "screen";
        }
        if (!class_3102.method_1569()) {
            return "focus";
        }
        if (!class_7462.method_5805() || class_7462.method_7325()) {
            return "dead";
        }
        if (FreeCam.active()) {
            return "freecam";
        }
        return null;
    }

    public static boolean mining() {
        return tdh != null;
    }

    public static void startMining(StudioProfiles tiq2) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || tiq2 == null) {
            return;
        }
        RecorderHooks.stop();
        RecorderHooks.tdw();
        tdf = tiq2;
        tde = tcw.RECORD;
        tdl = class_3102.field_1687;
        tdh = new MineRecorder(tiq2, (float)RecorderHooks.unit(class_3102));
    }

    private static String tdu(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_3102.field_1755 != null) {
            return "screen";
        }
        if (!class_3102.method_1569()) {
            return "focus";
        }
        if (!class_7462.method_5805() || class_7462.method_7325()) {
            return "dead";
        }
        Module kfe2 = RecorderHooks.tee("AutoMine");
        if (AutoMines.busy() || kfe2 != null && kfe2.isEnabled()) {
            return "automine";
        }
        if (AncientFarmer.busy()) {
            return "farmer";
        }
        if (FreeCam.active()) {
            return "freecam";
        }
        if (!MineTools.holdsPickaxe(class_7462)) {
            return "pickaxe";
        }
        return null;
    }

    public static tcw mode() {
        return tde;
    }

    public static StudioProfiles sessionProfile() {
        return tdf;
    }

    public static AimRecorder recorder() {
        return tdg;
    }

    public static AimRecorder fightRecorder() {
        return tdk;
    }

    public static boolean recording() {
        return tde == tcw.RECORD || tdk != null;
    }

    public static boolean standsOut() {
        return tde != tcw.NONE;
    }

    public static List<DummyPlayer> stands() {
        return tdc;
    }

    public static tct job() {
        return tdp;
    }

    public static boolean training() {
        tct tct2 = tdp;
        return tct2 != null && !tct2.done;
    }

    public static void startRecording(StudioProfiles tiq2) {
        RecorderHooks.tdv(tiq2, tcw.RECORD);
    }

    public static void startTest(StudioProfiles tiq2) {
        RecorderHooks.tdv(tiq2, tcw.TEST);
    }

    private static void tdv(StudioProfiles tiq2, tcw tcw2) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || tiq2 == null) {
            return;
        }
        RecorderHooks.stop();
        RecorderHooks.tdw();
        tdf = tiq2;
        tde = tcw2;
        tdl = class_3102.field_1687;
        RecorderHooks.tdx(class_3102, tiq2);
        if (tcw2 == tcw.RECORD) {
            tdg = new AimRecorder(tiq2, 0, class_3102.field_1724.method_73189(), (float)RecorderHooks.unit(class_3102));
        }
    }

    public static void stop() {
        if (tdg != null) {
            tdg.finish();
            tdg = null;
        }
        if (tdh != null) {
            tdh.finish();
            tdh = null;
        }
        if (tdi != null) {
            tdi.finish();
            tdi = null;
            Module kfe2 = tdj;
            tdj = null;
            if (kfe2 != null && kfe2.isEnabled()) {
                kfe2.setEnabled(false);
            }
        }
        RecorderHooks.tdy(class_310.method_1551());
        tde = tcw.NONE;
        tdf = null;
    }

    private static void tdw() {
        if (tdk != null) {
            tdk.finish();
            tdk = null;
        }
    }

    public static double unit(class_310 class_3102) {
        double d = (Double)class_3102.field_1690.method_42495().method_41753() * 0.6 + 0.2;
        return d * d * d * 8.0 * 0.15;
    }

    private static void tdx(class_310 class_3102, StudioProfiles tiq2) {
        RecorderHooks.tdy(class_3102);
        int n = tiq2.standCount();
        for (int i = 0; i < n; ++i) {
            DummyPlayer tkx2 = new DummyPlayer(class_3102.field_1687, tdb[i % tdb.length], tdd.nextLong(), tiq2.standMode(), tiq2.standNear(), tiq2.standFar(), tiq2.standSpeed());
            tkx2.method_5838(-789577728 - i);
            tkx2.method_5673(class_1304.field_6169, new class_1799((class_1935)class_1802.field_8805));
            tkx2.method_5673(class_1304.field_6174, new class_1799((class_1935)class_1802.field_8058));
            tkx2.method_5673(class_1304.field_6172, new class_1799((class_1935)class_1802.field_8348));
            tkx2.method_5673(class_1304.field_6166, new class_1799((class_1935)class_1802.field_8285));
            tkx2.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8802));
            tkx2.relocate(class_3102.field_1724);
            class_3102.field_1687.method_53875((class_1297)tkx2);
            tdc.add(tkx2);
        }
    }

    private static void tdy(class_310 class_3102) {
        if (class_3102.field_1687 != null && class_3102.field_1687 == tdl) {
            for (DummyPlayer tkx2 : tdc) {
                if (tkx2.method_31481()) continue;
                class_3102.field_1687.method_2945(tkx2.method_5628(), class_1297.class_5529.field_26999);
            }
        }
        tdc.clear();
    }

    public static boolean onAttack(class_1657 class_16572, class_1297 class_12972, class_3966 class_39662) {
        class_243 class_2432;
        class_310 class_3102 = class_310.method_1551();
        if (!(class_16572 instanceof class_746)) {
            return false;
        }
        class_746 class_7462 = (class_746)class_16572;
        class_243 class_2433 = class_2432 = class_39662 != null ? class_39662.method_17784() : class_12972.method_5829().method_1005();
        if (class_12972 instanceof DummyPlayer) {
            DummyPlayer tkx2 = (DummyPlayer)class_12972;
            if (tdg != null) {
                tdg.hit(class_12972, class_2432, class_7462);
            }
            boolean bl = class_7462.field_6017 > 0.0 && !class_7462.method_24828() && !class_7462.method_6101() && !class_7462.method_5799() && !class_7462.method_5624();
            tkx2.knock(class_7462.method_73189(), class_7462.method_5624());
            class_7462.method_7350();
            if (class_3102.field_1687 != null) {
                class_3102.field_1687.method_8486(tkx2.method_23317(), tkx2.method_23320(), tkx2.method_23321(), bl ? class_3417.field_15016 : class_3417.field_14840, class_3419.field_15248, 0.8f, 0.95f + tdd.nextFloat() * 0.1f, false);
                class_3102.field_1687.method_8486(tkx2.method_23317(), tkx2.method_23320(), tkx2.method_23321(), class_3417.field_15115, class_3419.field_15248, 0.6f, 0.9f + tdd.nextFloat() * 0.2f, false);
                if (bl) {
                    class_3102.field_1713.method_3061((class_1297)tkx2, (class_2394)class_2398.field_11205);
                }
            }
            return true;
        }
        if (tdk != null && RecorderHooks.teg(class_7462, class_12972)) {
            tdk.hit(class_12972, class_2432, class_7462);
        }
        return false;
    }

    private static int tdz(class_310 class_3102) {
        if (!tdn) {
            tdn = true;
            tdm = Reflect.find(class_304.class, "net.minecraft.class_304", "field_1661", "I");
        }
        return Math.max(0, Reflect.getInt(tdm, class_3102.field_1690.field_1886, 0));
    }

    private static void tea(class_310 class_3102) {
        int n;
        if (class_3102.field_1724 == null || class_3102.field_1755 != null) {
            return;
        }
        int n2 = n = tdg != null || tdk != null ? RecorderHooks.tdz(class_3102) : 0;
        if (n <= 0) {
            return;
        }
        if (tdg != null) {
            tdg.presses(n);
            tdg.aim(class_3102, tdc);
        }
        if (tdk != null) {
            tdk.presses(n);
            tdk.aim(class_3102, RecorderHooks.teh(class_3102));
        }
    }

    private static void teb(class_310 class_3102) {
        Object object;
        Object object2;
        tct tct2;
        if ((tdh != null || tdi != null) && PanicShutdown.armed()) {
            RecorderHooks.stop();
        }
        if ((tdh != null || tdi != null) && class_3102.field_1687 != null && class_3102.field_1687 != tdl) {
            tdl = class_3102.field_1687;
        }
        if (class_3102.field_1687 != tdl && tde != tcw.NONE && tdh == null && tdi == null) {
            if (tdg != null) {
                tdg.finish();
                tdg = null;
            }
            tdc.clear();
            tde = tcw.NONE;
            tdf = null;
        }
        if (class_3102.field_1724 == null || class_3102.field_1687 == null) {
            RecorderHooks.tdw();
            return;
        }
        if (tde != tcw.NONE) {
            RecorderHooks.tec(class_3102);
        }
        if ((tct2 = tdp) != null && tct2.done && !tct2.applied) {
            tct2.applied = true;
            if (tct2.mineResult != null) {
                if (AutoMine.mineProfile() == null) {
                    AutoMine.activateMine(tct2.profile);
                }
            } else if (tct2.walkResult != null) {
                if (AutoMine.walkProfile() == null) {
                    AutoMine.activateWalk(tct2.profile);
                }
            } else if (tct2.result != null && tct2.aura && Aura.studioProfile() == null) {
                Aura.useStudio(tct2.profile);
            } else if (tct2.result != null && !tct2.aura && AutoMine.activeProfile() == null) {
                AutoMine.activate(tct2.profile);
            }
        }
        RecorderHooks.tei(class_3102);
        if (tdg != null) {
            object2 = RecorderHooks.ted(class_3102);
            if (object2 != null) {
                tdg.pause((String)object2);
            } else {
                tdg.tick(class_3102, tdc);
            }
        }
        if ((object2 = tdh) != null) {
            object = RecorderHooks.tdu(class_3102);
            if (object != null) {
                ((MineRecorder)object2).pause((String)object);
            } else {
                ((MineRecorder)object2).tick(class_3102);
            }
        }
        if ((object = tdi) != null) {
            String string = RecorderHooks.tdt(class_3102);
            if (string != null) {
                ((WardenRecorder)object).pause(string);
            } else {
                ((WardenRecorder)object).tick(class_3102);
            }
        }
        RecorderHooks.tef(class_3102);
    }

    private static void tec(class_310 class_3102) {
        for (int i = 0; i < tdc.size(); ++i) {
            DummyPlayer tkx2 = tdc.get(i);
            if (!tkx2.method_31481() && class_3102.field_1687.method_8469(tkx2.method_5628()) == tkx2) continue;
            DummyPlayer tkx3 = new DummyPlayer(class_3102.field_1687, tdb[i % tdb.length], tdd.nextLong(), tdf.standMode(), tdf.standNear(), tdf.standFar(), tdf.standSpeed());
            tkx3.method_5838(-789577728 - i);
            for (class_1304 class_13042 : class_1304.values()) {
                tkx3.method_5673(class_13042, tkx2.method_6118(class_13042).method_7972());
            }
            tkx3.relocate(class_3102.field_1724);
            class_3102.field_1687.method_53875((class_1297)tkx3);
            tdc.set(i, tkx3);
        }
    }

    private static String ted(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        if (class_3102.field_1755 != null) {
            return "screen";
        }
        if (!class_3102.method_1569()) {
            return "focus";
        }
        if (!class_7462.method_5805() || class_7462.method_7325()) {
            return "dead";
        }
        Module kfe2 = RecorderHooks.tee("AimAssist");
        if (kfe2 != null && kfe2.isEnabled()) {
            return "aimassist";
        }
        if (AutoMace.busy()) {
            return "mace";
        }
        return null;
    }

    private static Module tee(String string) {
        Flow flow = Flow.getInstance();
        return flow.getModuleManager() == null ? null : flow.getModuleManager().getByName(string);
    }

    private static void tef(class_310 class_3102) {
        boolean bl;
        StudioProfiles tiq2 = AutoMine.activeProfile();
        boolean bl2 = bl = tde == tcw.NONE && tiq2 != null && tiq2.fights() && !AutoMine.turning();
        if (!bl) {
            RecorderHooks.tdw();
            return;
        }
        if (tdk != null && RecorderHooks.tdk.profile != tiq2) {
            RecorderHooks.tdw();
        }
        if (tdk == null) {
            tdk = new AimRecorder(tiq2, 1, class_3102.field_1724.method_73189(), (float)RecorderHooks.unit(class_3102));
        }
        String string = RecorderHooks.ted(class_3102);
        List<class_1297> list = RecorderHooks.teh(class_3102);
        if (string != null) {
            tdk.pause(string);
        } else if (list.isEmpty()) {
            tdk.pause("idle");
        } else {
            tdk.tick(class_3102, list);
        }
    }

    private static boolean teg(class_746 class_7462, class_1297 class_12972) {
        class_1657 class_16572;
        return class_12972 instanceof class_1657 && (class_16572 = (class_1657)class_12972) != class_7462 && class_16572.method_5805() && !class_16572.method_7325() && !(class_12972 instanceof DummyPlayer) && !Friends.protects((class_1297)class_16572);
    }

    private static List<class_1297> teh(class_310 class_3102) {
        class_746 class_7462 = class_3102.field_1724;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (class_1657 class_16572 : class_3102.field_1687.method_18456()) {
            if (!RecorderHooks.teg(class_7462, (class_1297)class_16572) || !(class_16572.method_5858((class_1297)class_7462) < 64.0)) continue;
            arrayList.add(class_16572);
        }
        arrayList.sort(Comparator.comparingDouble(class_12972 -> class_12972.method_5858((class_1297)class_7462)));
        return arrayList.size() > 4 ? new ArrayList<Object>(arrayList.subList(0, 4)) : arrayList;
    }

    private static void tei(class_310 class_3102) {
        boolean bl;
        int n = AutoMine.stopKey();
        boolean bl2 = bl = class_3102.field_1755 == null && n != -1 && KeyUtil.isDown(class_3102, n);
        if (bl && !tdo && tde != tcw.NONE) {
            RecorderHooks.stop();
        }
        tdo = bl;
    }

    public static void train(StudioProfiles tiq2) {
        tct tct2;
        if (RecorderHooks.training() || tiq2 == null) {
            return;
        }
        if (tde == tcw.RECORD && tdf == tiq2) {
            RecorderHooks.stop();
        }
        if (tdk != null && RecorderHooks.tdk.profile == tiq2) {
            tdk.save();
        }
        tdp = tct2 = new tct(tiq2);
        if (tct2.mine) {
            RecorderHooks.tej(tct2);
            return;
        }
        if (tct2.walk) {
            RecorderHooks.tek(tct2);
            return;
        }
        Thread thread = new Thread(() -> {
            try {
                FileWriter.flush();
                tct2.progress.phase = "cloud";
                tiq2.loadRecordings(true);
                List<RecordingReader> list = tiq2.tapes();
                if (list.isEmpty()) {
                    throw new tmt("none");
                }
                tmk tmk2 = tiq2.trainerConfig();
                tmk2.track = tct2.aura;
                tmk2.dropOvershoot = !tct2.aura && tiq2.clean();
                AimModel tck2 = NeuroWorker.run(list, tmk2, tct2.progress);
                tiq2.saveModel(tck2, tct2.aura);
                tiq2.set(tct2.aura ? "aura.trained" : "model.trained", tck2.created);
                tiq2.save();
                tct2.result = tck2;
            }
            catch (tmt tmt2) {
                tct2.error = tmt2.code;
            }
            catch (Throwable throwable) {
                tct2.error = "error";
                System.out.println("neuro training failed: " + throwable);
                throwable.printStackTrace();
            }
            tct2.finished = System.currentTimeMillis();
            tct2.done = true;
        }, "Flow2 neuro trainer");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    private static void tej(tct tct2) {
        StudioProfiles tiq2 = tct2.profile;
        Thread thread = new Thread(() -> {
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
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }, "mine trainer");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    private static void tek(tct tct2) {
        StudioProfiles tiq2 = tct2.profile;
        Thread thread = new Thread(() -> {
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
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }, "walk trainer");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public static boolean analyzing(StudioProfiles tiq2) {
        return tdq == tiq2;
    }

    public static void analyze(StudioProfiles tiq2) {
        if (tiq2 == null || tdq != null) {
            return;
        }
        String string = tiq2.dataStamp();
        if (string.equals(tiq2.get("data.stamp", ""))) {
            return;
        }
        tdq = tiq2;
        Thread thread = new Thread(() -> {
            try {
                FileWriter.flush();
                List<RecordingReader> list = tiq2.tapes();
                AimTrace szk2 = tiq2.aura() ? AimTrace.track(list, false) : AimTrace.build(list, tiq2.clean());
                tiq2.set("data.samples", szk2.stats.steps);
                tiq2.set("data.flicks", szk2.stats.flicks);
                tiq2.set("data.tracking", szk2.stats.tracking);
                tiq2.set("data.vertical", szk2.stats.vertical);
                tiq2.set("data.used", szk2.stats.usedHits);
                tiq2.set("data.overshoots", szk2.stats.overshoots);
                tiq2.set("data.stamp", string);
                tiq2.save();
            }
            catch (Throwable throwable) {
                System.out.println("neuro data analysis failed: " + throwable);
            }
            finally {
                tdq = null;
            }
        }, "Flow2 neuro analysis");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public static void cancelTraining() {
        tct tct2 = tdp;
        if (tct2 != null && !tct2.done) {
            tct2.progress.cancel = true;
        }
    }

    private static /* synthetic */ int ckw(int n, int n2) {
        return n * n2 ^ 0x5A6BCA43;
    }

    private static /* synthetic */ int ckx(int n, int n2) {
        return n * n2 + -1809635349;
    }
}

