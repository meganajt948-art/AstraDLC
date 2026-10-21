/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.AimModel;
import a.RecordingReader;
import a.tmk;
import a.tmt;
import a.tmw;
import a.NeuroWorker;
import a.tqj;
import a.BrainTrainer;
import a.trm;
import a.trp;
import a.LegsTrainer;
import a.tsl;
import a.tso;
import a.TrainingPrep;
import a.MineModelReader;
import a.MineRecordingReader;
import a.MineStyleStats;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class MineTrainer {
    public static final int MIN_EVENTS = 80;
    public static final int MIN_LEGS = 2000;
    private static final int tvg = 24;
    private static final int tvh = 600;
    private static final int tvi = 14000;
    private static final int tvj = 1500;
    private static /* synthetic */ int tvk;
    private static /* synthetic */ long tvl;

    private MineTrainer() {
    }

    public static double beta(int n) {
        return n <= 0 ? 0.0 : (n >= 20 ? 1.0 : 0.5);
    }

    public static MineModelReader run(List<MineRecordingReader> list, tmk tmk2, int n, int n2, int n3, tmw tmw2) {
        tmw2.phase = "data";
        List<tso> list2 = TrainingPrep.prepare(list, MineTrainer.beta(n3), tmw2);
        tsl tsl2 = TrainingPrep.events(list2, tmw2);
        if (tsl2.list.size() < 80) {
            throw new tmt("few");
        }
        trp trp2 = TrainingPrep.legs(list2, tmw2);
        List<RecordingReader> list3 = TrainingPrep.rotation(list);
        tqj tqj2 = BrainTrainer.train(tsl2.list, 24, n, tmk2.seed, tmw2);
        trm trm2 = trp2.n >= 2000 ? LegsTrainer.train(trp2, n2, tmk2.seed ^ 0x9E3779B9L, tmw2) : null;
        tmk2.track = false;
        tmk2.minWindow = 1;
        AimModel tck2 = NeuroWorker.run(list3, tmk2, tmw2);
        List<Integer> list4 = TrainingPrep.reactions(list);
        MineStyleStats tvq2 = TrainingPrep.style(list2, list4);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(list4);
        Collections.shuffle(arrayList, new Random(tmk2.seed ^ 0x2545F4914F6CDD1DL));
        int n4 = Math.min(600, arrayList.size());
        tck2.reactions = new int[n4];
        for (int i = 0; i < n4; ++i) {
            tck2.reactions[i] = Math.min(255, (Integer)arrayList.get(i));
        }
        tck2.turnCap = tvq2.turnCap;
        MineTrainer.tvm(tck2);
        MineModelReader ttb2 = new MineModelReader();
        ttb2.hand = tck2;
        ttb2.brain = tqj2.net;
        ttb2.style = tvq2;
        ttb2.top1 = tqj2.top1;
        ttb2.top3 = tqj2.top3;
        ttb2.base1 = tqj2.base1;
        ttb2.nll = tqj2.nll;
        ttb2.events = tsl2.list.size();
        ttb2.valEvents = tqj2.valEvents;
        if (trm2 != null) {
            ttb2.legs = trm2.legs;
            ttb2.legsAcc = trm2.accuracy;
            ttb2.legsBase = trm2.baseline;
            ttb2.legsJump = trm2.jumpAcc;
            ttb2.legsSprint = trm2.sprintAcc;
            ttb2.legsSamples = trm2.samples;
        }
        ttb2.boost = n3;
        ttb2.created = System.currentTimeMillis();
        tmw2.phase = "finish";
        return ttb2;
    }

    private static void tvm(AimModel tck2) {
        int n = tck2.resX.length;
        if (n > 14000) {
            tck2.resX = Arrays.copyOf(tck2.resX, 14000);
            tck2.resY = Arrays.copyOf(tck2.resY, 14000);
            tck2.resBin = Arrays.copyOf(tck2.resBin, 14000);
            tck2.resLink = Arrays.copyOf(tck2.resLink, 14000);
            tck2.resLink[13999] = false;
        }
        if (tck2.aimU.length > 1500) {
            tck2.aimU = Arrays.copyOf(tck2.aimU, 1500);
            tck2.aimV = Arrays.copyOf(tck2.aimV, 1500);
        }
    }

    private static /* synthetic */ int cro(int n, int n2) {
        return n ^ n2 | 0x98C31B63;
    }

    private static /* synthetic */ int crp(int n, int n2) {
        return MineTrainer.cro(n, n2) ^ 0x7EEBBA8;
    }

    private static /* synthetic */ int crq(int n, int n2) {
        return MineTrainer.cro(n, n2) ^ 0xD2050CD1;
    }
}

