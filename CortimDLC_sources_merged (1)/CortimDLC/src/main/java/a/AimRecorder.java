/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_746
 */
package a;

import a.AngleUtil;
import a.StudioProfiles;
import a.tme;
import a.RecordingReader;
import flow.dev.StringDecryptor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_746;

public final class AimRecorder {
    private static final int tkd = 1200;
    private static final long tke = 180000L;
    public final StudioProfiles profile;
    private final RecordingReader tkf = new RecordingReader();
    private final List<tme> tkg = new ArrayList<tme>();
    private final String tkh;
    private final ArrayDeque<Integer> tki = new ArrayDeque();
    private boolean tkj = true;
    private int tkk;
    private int tkl;
    private float tkm;
    private float tkn;
    private int tko;
    private int tkp;
    private int tkq;
    private boolean tkr;
    private boolean tks;
    private long tkt = System.currentTimeMillis();
    public int hits;
    public int samples;
    public int failures;
    private int tku;
    public int recorded;
    public boolean paused;
    public String pauseReason = "";
    private static /* synthetic */ long tkv;
    private static /* synthetic */ int tkw;

    public AimRecorder(StudioProfiles tiq2, int n, class_243 class_2432, float f) {
        this.profile = tiq2;
        this.tkh = tiq2.newTapeName();
        this.tkf.created = System.currentTimeMillis();
        this.tkf.source = n;
        this.tkf.originX = Math.floor(class_2432.field_1352);
        this.tkf.originY = Math.floor(class_2432.field_1351);
        this.tkf.originZ = Math.floor(class_2432.field_1350);
        this.tkf.unit = f;
    }

    public void presses(int n) {
        this.tkk += n;
    }

    public void hit(class_1297 class_12972, class_243 class_2432, class_746 class_7462) {
        if (this.tkl != 0) {
            return;
        }
        class_238 class_2383 = class_12972.method_5829();
        double d = (class_2383.field_1323 + class_2383.field_1320) * 0.5;
        double d2 = (class_2383.field_1321 + class_2383.field_1324) * 0.5;
        class_243 class_2433 = class_7462.method_33571();
        this.tkl = class_12972.method_5628() == 0 ? 1 : class_12972.method_5628();
        this.tkm = (float)AngleUtil.hitU(class_2433.field_1352, class_2433.field_1350, d, d2, (class_2383.field_1320 - class_2383.field_1323) * 0.5, class_2432.field_1352, class_2432.field_1350);
        this.tkn = (float)AngleUtil.hitV(class_2383.field_1322, class_2383.field_1325 - class_2383.field_1322, class_2432.field_1351);
    }

    public void aim(class_310 class_3102, List<? extends class_1297> list) {
        class_746 class_7462 = class_3102.field_1724;
        if (this.tkl != 0 || class_7462 == null || class_3102.field_1687 == null) {
            return;
        }
        class_243 class_2432 = class_7462.method_33571();
        class_243 class_2433 = class_2432.method_1019(class_7462.method_5828(1.0f).method_1021(8.0));
        double d = 8.0;
        class_3965 class_39652 = class_3102.field_1687.method_17742(new class_3959(class_2432, class_2433, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)class_7462));
        if (class_39652.method_17783() != class_239.class_240.field_1333) {
            d = class_39652.method_17784().method_1022(class_2432);
        }
        class_1297 class_12972 = null;
        class_243 class_2434 = null;
        double d2 = d;
        for (class_1297 class_12973 : list) {
            class_238 class_2383 = class_12973.method_5829().method_1014((double)class_12973.method_5871());
            Optional optional = class_2383.method_992(class_2432, class_2433);
            if (!optional.isPresent() || !(((class_243)optional.get()).method_1022(class_2432) < d2)) continue;
            d2 = ((class_243)optional.get()).method_1022(class_2432);
            class_12972 = class_12973;
            class_2434 = (class_243)optional.get();
        }
        if (class_12972 != null) {
            this.hit(class_12972, class_2434, class_7462);
        }
    }

    public void pause(String string) {
        this.paused = true;
        this.pauseReason = string;
        this.tkj = true;
        this.tkk = 0;
        this.tkl = 0;
    }

    public void tick(class_310 class_3102, List<? extends class_1297> list) {
        int n;
        class_746 class_7462 = class_3102.field_1724;
        if (class_7462 == null) {
            return;
        }
        this.paused = false;
        this.pauseReason = "";
        tme tme2 = new tme();
        tme2.flags = 1 | (class_7462.method_24828() ? 2 : 0) | (this.tkj ? 4 : 0);
        this.tkj = false;
        tme2.yaw = class_7462.method_36454();
        tme2.pitch = class_7462.method_36455();
        class_243 class_2432 = class_7462.method_33571();
        tme2.eyeX = (float)(class_2432.field_1352 - this.tkf.originX);
        tme2.eyeY = (float)(class_2432.field_1351 - this.tkf.originY);
        tme2.eyeZ = (float)(class_2432.field_1350 - this.tkf.originZ);
        tme2.cooldown = class_7462.method_7261(0.5f);
        tme2.presses = this.tkk;
        tme2.hitId = this.tkl;
        tme2.hitU = this.tkm;
        tme2.hitV = this.tkn;
        int n2 = Math.min(list.size(), 6);
        tme2.ids = new int[n2];
        tme2.boxes = new float[n2 * 5];
        for (n = 0; n < n2; ++n) {
            class_1297 class_12972 = list.get(n);
            class_238 class_2383 = class_12972.method_5829();
            tme2.ids[n] = class_12972.method_5628() == 0 ? 1 : class_12972.method_5628();
            tme2.boxes[n * 5] = (float)((class_2383.field_1323 + class_2383.field_1320) * 0.5 - this.tkf.originX);
            tme2.boxes[n * 5 + 1] = (float)(class_2383.field_1322 - this.tkf.originY);
            tme2.boxes[n * 5 + 2] = (float)((class_2383.field_1321 + class_2383.field_1324) * 0.5 - this.tkf.originZ);
            tme2.boxes[n * 5 + 3] = (float)((class_2383.field_1320 - class_2383.field_1323) * 0.5);
            tme2.boxes[n * 5 + 4] = (float)(class_2383.field_1325 - class_2383.field_1322);
        }
        n = this.tkg.size();
        this.tkg.add(tme2);
        ++this.recorded;
        if ((tme2.flags & 4) != 0) {
            this.tku = n;
        }
        if (this.tkl != 0) {
            ++this.hits;
            this.samples += Math.max(0, Math.min(n - this.tku, 60));
            this.tku = n;
            this.tki.clear();
        }
        int n3 = this.tkk - (this.tkl != 0 ? 1 : 0);
        if (this.tkl == 0 && n3 > 0) {
            this.tki.add(n);
        }
        while (!this.tki.isEmpty() && n - this.tki.peekFirst() > 8) {
            this.tku = Math.max(this.tku, this.tki.pollFirst());
            ++this.failures;
        }
        this.tkk = 0;
        this.tkl = 0;
        if (this.tkg.size() - this.tko >= 1200) {
            this.save();
        }
    }

    public void save() {
        if (this.tkg.size() <= this.tko && this.failures == this.tkq && !this.tks) {
            return;
        }
        boolean bl = this.tkg.size() > this.tko || this.tks;
        ArrayList<tme> arrayList = new ArrayList<tme>(this.tkg);
        this.profile.add("ticks", arrayList.size() - this.tko);
        this.profile.add("hits", this.hits - this.tkp);
        this.profile.add("filtered", this.failures - this.tkq);
        this.tko = arrayList.size();
        this.tkp = this.hits;
        this.tkq = this.failures;
        this.profile.save();
        if (bl) {
            RecordingReader tmh2 = new RecordingReader();
            tmh2.created = this.tkf.created;
            tmh2.unit = this.tkf.unit;
            tmh2.originX = this.tkf.originX;
            tmh2.originY = this.tkf.originY;
            tmh2.originZ = this.tkf.originZ;
            tmh2.source = this.tkf.source;
            tmh2.ticks.addAll(arrayList);
            this.profile.putTape(this.tkh, tmh2);
            long l = System.currentTimeMillis();
            if (this.tks || l - this.tkt > 180000L) {
                this.tks = false;
                this.tkt = l;
                this.profile.uploadTape(this.tkh, tmh2);
            }
        }
    }

    public void finish() {
        while (!this.tki.isEmpty()) {
            this.tki.pollFirst();
            ++this.failures;
        }
        if (this.recorded > 0 && !this.tkr) {
            this.tkr = true;
            this.profile.add("sessions", 1L);
        }
        this.tks = this.recorded > 0;
        this.save();
    }

    public int seconds() {
        return this.recorded / 20;
    }

    private static /* synthetic */ int cly(int n, int n2) {
        return n + n2 | 0x9A3B4510;
    }
}

