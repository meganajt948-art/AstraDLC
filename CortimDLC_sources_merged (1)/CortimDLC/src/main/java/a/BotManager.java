/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_642
 */
package a;

import a.dts;
import a.Bot;
import a.BotCamera;
import a.BotRuntime;
import a.ejs;
import a.ejz;
import a.BotStore;
import a.ModuleManager;
import a.BotsModule;
import flow.Flow;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import net.minecraft.class_310;
import net.minecraft.class_642;

public final class BotManager {
    private static final BotManager egr = new BotManager();
    private static final Pattern egs = Pattern.compile("[A-Za-z0-9_]{3,16}");
    private static final class_310 egt = class_310.method_1551();
    private static final long egu = 10000000L;
    private static final long egv = 2500L;
    private static final long egw = 20000L;
    private final List<Bot> egx = new CopyOnWriteArrayList<Bot>();
    private final Random egy = new Random();
    private final Set<Bot> egz = Collections.newSetFromMap(new IdentityHashMap());
    private int eha = 4;
    private boolean ehb;
    private int ehc;
    private volatile boolean ehd;
    private long ehe;
    private long ehf;
    private static /* synthetic */ long ehg;
    private static /* synthetic */ String ehh;

    private BotManager() {
    }

    public static BotManager get() {
        return egr;
    }

    public List<Bot> getBots() {
        this.ehj();
        return this.egx;
    }

    public static boolean isValidName(String string) {
        return string != null && egs.matcher(string).matches();
    }

    public Bot find(String string) {
        this.ehj();
        for (Bot dtv2 : this.egx) {
            if (!dtv2.getName().equalsIgnoreCase(string)) continue;
            return dtv2;
        }
        return null;
    }

    public Bot add(String string, String string2) {
        if (!BotManager.isValidName(string) || string2 == null || string2.isBlank()) {
            return null;
        }
        Bot dtv2 = this.find(string);
        if (dtv2 != null) {
            return dtv2;
        }
        Bot dtv3 = new Bot(string, string2.trim());
        this.egx.add(dtv3);
        BotRuntime.any = true;
        this.ehk();
        this.persist();
        dtv3.connect();
        return dtv3;
    }

    public void remove(Bot dtv2) {
        if (dtv2 != null && this.egx.remove(dtv2)) {
            this.egz.remove(dtv2);
            dtv2.release();
            BotRuntime.any = !this.egx.isEmpty();
            this.ehk();
            this.persist();
        }
    }

    private static ModuleManager ehi() {
        Flow flow = Flow.getInstance();
        return flow == null ? null : flow.getModuleManager();
    }

    private void ehj() {
        if (this.ehd || !egt.method_18854() || BotManager.egt.field_1697 == null || BotManager.ehi() == null) {
            return;
        }
        this.ehd = true;
        ejz ejz2 = BotStore.load();
        if (ejz2.viewDistance() > 0) {
            this.eha = Math.max(2, Math.min(12, ejz2.viewDistance()));
        }
        for (ejs ejs2 : ejz2.bots()) {
            if (!BotManager.isValidName(ejs2.name()) || ejs2.address() == null || ejs2.address().isBlank() || this.find(ejs2.name()) != null) continue;
            try {
                Bot dtv2 = new Bot(ejs2.name(), ejs2.address().trim());
                dtv2.restore(ejs2.password(), ejs2.autoReconnect());
                this.egx.add(dtv2);
            }
            catch (Throwable throwable) {}
        }
        BotRuntime.any = !this.egx.isEmpty();
        this.ehk();
        try {
            Runtime.getRuntime().addShutdownHook(new Thread(this::persist, "Flow2 bots"));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void persist() {
        if (this.ehd) {
            BotStore.save(this.egx, this.eha);
        }
    }

    public int connectAll() {
        int n = 0;
        for (Bot dtv2 : this.egx) {
            if (dtv2.getStatus() != dts.OFFLINE && dtv2.getStatus() != dts.FAILED) continue;
            dtv2.connect();
            ++n;
        }
        return n;
    }

    private void ehk() {
        long l = System.nanoTime();
        int n = this.egx.size();
        for (int i = 0; i < n; ++i) {
            this.egx.get(i).stagger(l, i, n);
        }
    }

    boolean tryStartJoin(Bot dtv2) {
        long l = System.currentTimeMillis();
        if (l - this.ehe < 2500L) {
            return false;
        }
        for (Bot dtv3 : this.egx) {
            if (dtv3 == dtv2 || !dtv3.isJoining() || l - dtv3.getStatusTime() >= 20000L) continue;
            return false;
        }
        this.ehe = l;
        return true;
    }

    private List<Bot> ehl() {
        ArrayList<Bot> arrayList = new ArrayList<Bot>();
        for (Bot dtv2 : this.egx) {
            if (dtv2.getStatus() != dts.ONLINE || dtv2.getPlayer() == null) continue;
            arrayList.add(dtv2);
        }
        Collections.shuffle(arrayList, this.egy);
        return arrayList;
    }

    public int broadcast(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string.trim();
        if (string2.isEmpty()) {
            return 0;
        }
        List<Bot> list = this.ehl();
        long l = 0L;
        for (Bot dtv2 : list) {
            dtv2.schedule(l, () -> dtv2.sendChat(string2));
            l += 400L + (long)this.egy.nextInt(900);
        }
        this.ehf = System.currentTimeMillis();
        this.egz.clear();
        this.egz.addAll(list);
        return list.size();
    }

    public long getLastBroadcast() {
        return this.ehf;
    }

    public boolean wasBroadcastTarget(Bot dtv2) {
        return this.egz.contains(dtv2);
    }

    public int setF0All(boolean bl) {
        List<Bot> list = this.ehl();
        long l = 0L;
        int n = 0;
        for (Bot dtv2 : list) {
            if (dtv2.f0Run() == bl && dtv2.f0Want() == bl) continue;
            dtv2.schedule(l, () -> dtv2.setF0(bl));
            l += bl ? 1500L + (long)this.egy.nextInt(2500) : 150L + (long)this.egy.nextInt(450);
            ++n;
        }
        return n;
    }

    public int setF1All(boolean bl) {
        List<Bot> list = this.ehl();
        long l = 0L;
        int n = 0;
        int n2 = 0;
        for (Bot dtv2 : list) {
            if (dtv2.f1Run() == bl && dtv2.f1Want() == bl) continue;
            if (bl) {
                dtv2.f1ref().setLootStart(n2++);
            }
            dtv2.schedule(l, () -> dtv2.setF1(bl));
            l += bl ? 1500L + (long)this.egy.nextInt(2500) : 150L + (long)this.egy.nextInt(450);
            ++n;
        }
        return n;
    }

    public int setF2All(boolean bl) {
        List<Bot> list = this.ehl();
        long l = 0L;
        int n = 0;
        for (Bot dtv2 : list) {
            if (dtv2.f2Run() == bl && dtv2.f2Want() == bl) continue;
            dtv2.schedule(l, () -> dtv2.setF2(bl));
            l += bl ? 1500L + (long)this.egy.nextInt(2500) : 150L + (long)this.egy.nextInt(450);
            ++n;
        }
        return n;
    }

    public int setF3All(boolean bl) {
        List<Bot> list = this.ehl();
        long l = 0L;
        int n = 0;
        for (Bot dtv2 : list) {
            if (dtv2.f3Run() == bl && dtv2.f3Want() == bl || bl && dtv2.f3ref().isLocked()) continue;
            dtv2.schedule(l, () -> dtv2.setF3(bl));
            l += bl ? 1500L + (long)this.egy.nextInt(2500) : 150L + (long)this.egy.nextInt(450);
            ++n;
        }
        return n;
    }

    public int stopAll() {
        int n = 0;
        long l = 0L;
        for (Bot dtv2 : this.egx) {
            if (!dtv2.isActive() && !dtv2.f0Want() && !dtv2.f1Want() && !dtv2.f2Want() && !dtv2.f3Want()) continue;
            dtv2.schedule(l, dtv2::stopAutomation);
            l += 150L + (long)this.egy.nextInt(450);
            ++n;
        }
        return n;
    }

    public void resetFarmStats() {
        for (Bot dtv2 : this.egx) {
            dtv2.f0ref().resetFarmStats();
            dtv2.f1ref().resetFarmStats();
        }
    }

    public int getViewDistance() {
        return this.eha;
    }

    public void setViewDistance(int n) {
        int n2 = Math.max(2, Math.min(12, n));
        if (n2 != this.eha) {
            this.eha = n2;
            this.persist();
        }
    }

    public boolean isSolvingCaptcha() {
        ModuleManager kfx2 = BotManager.ehi();
        BotsModule oqm2 = kfx2 == null ? null : kfx2.get(BotsModule.class);
        return oqm2 == null || oqm2.solvesCaptcha();
    }

    public String suggestAddress() {
        class_642 class_6422 = egt.method_1558();
        if (class_6422 != null && class_6422.field_3761 != null && !class_6422.field_3761.isBlank()) {
            return class_6422.field_3761;
        }
        return this.egx.isEmpty() ? "" : this.egx.get(this.egx.size() - 1).getAddress();
    }

    public static void onFrame() {
        egr.ehm();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void ehm() {
        this.ehj();
        BotCamera.awaitAll();
        if (this.ehb || this.egx.isEmpty() || BotRuntime.isActive()) {
            return;
        }
        this.ehb = true;
        try {
            long l = System.nanoTime();
            int n = this.egx.size();
            int n2 = this.ehc++ % Math.max(1, n);
            for (int i = 0; i < n; ++i) {
                if (i > 0 && System.nanoTime() - l > 10000000L) {
                    break;
                }
                try {
                    this.egx.get((n2 + i) % n).frame(l);
                    continue;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
        finally {
            this.ehb = false;
        }
    }

    private static /* synthetic */ int dy(int n, int n2) {
        return n + n2 ^ 0x67812AFF;
    }
}

