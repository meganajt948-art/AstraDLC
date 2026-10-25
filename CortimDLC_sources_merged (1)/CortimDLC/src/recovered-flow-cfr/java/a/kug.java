/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package a;

import a.ewk;
import a.kud;
import a.tbx;
import a.vza;
import flow.dev.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;

final class kug {
    static final int IN = 15;
    static final int OUT = 8;
    static final int READY = 400;
    private static final int kuh = 32;
    private static final int kui = 16;
    private static final int kuj = 20000;
    private static final int kuk = 16;
    private static final int kul = 6;
    private static final int kum = 64;
    private static final double kun = 0.001;
    private static final double kuo = 0.9;
    private static final double kup = 0.999;
    private static final double kuq = 1.0E-8;
    private static final int kur = 2000;
    private static final int kus = 1177700436;
    private tbx kut;
    private double[] kuu;
    private double[] kuv;
    private long kuw;
    private long kux;
    private double kuy = 0.5;
    private double kuz = 0.5;
    private int kva;
    private boolean kvb;
    private final float[] kvc = new float[300000];
    private final byte[] kvd = new byte[20000];
    private final byte[] kve = new byte[20000];
    private int kvf;
    private int kvg;
    private final ArrayDeque<kud> kvh = new ArrayDeque();
    private final double[] kvi = new double[32];
    private final double[] kvj = new double[16];
    private final double[] kvk = new double[8];
    private final double[] kvl = new double[8];
    private final double[] kvm = new double[32];
    private final double[] kvn = new double[16];
    private final double[] kvo = new double[15];
    private double[] kvp;
    private static final String kvq = a.c(-1344875438, "\ud43c\uad8c\u2742\ub929\u32f5\ub455");
    private static /* synthetic */ String kvr;
    private static /* synthetic */ boolean kvs;

    kug() {
    }

    boolean ready() {
        this.kvv();
        return this.kux >= 400L;
    }

    long seen() {
        this.kvv();
        return this.kux;
    }

    double accuracy() {
        return this.kuy;
    }

    double hitRate() {
        return this.kuz;
    }

    void predict(double[] dArray, double[] dArray2) {
        this.kvv();
        this.kut.forward(dArray, this.kvi, this.kvj, this.kvk);
        for (int i = 0; i < 8; ++i) {
            dArray2[i] = kug.kvy(this.kvk[i]);
        }
    }

    void observe(int n, Entity entity, double[] dArray, double[] dArray2) {
        this.kvv();
        this.kvh.addLast(new kud(n, entity, (double[])dArray.clone(), (double[])dArray2.clone()));
    }

    void censor(int n) {
        for (kud kud2 : this.kvh) {
            kud2.censorFrom = Math.min(kud2.censorFrom, n);
        }
    }

    void label(int n, Entity entity) {
        Iterator<kud> iterator = this.kvh.iterator();
        while (iterator.hasNext()) {
            kud kud2 = iterator.next();
            int n2 = n - kud2.tick;
            if (n2 < 1) continue;
            if (n < kud2.censorFrom && n2 <= 8) {
                kud2.mask |= 1 << n2 - 1;
                if (entity == kud2.target) {
                    kud2.labels |= 1 << n2 - 1;
                }
            }
            if (n2 < 8 && n < kud2.censorFrom) continue;
            iterator.remove();
            this.kvt(kud2);
        }
    }

    private void kvt(kud kud2) {
        int n;
        int n2;
        if (kud2.mask == 0) {
            return;
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (n2 = 0; n2 < 8; ++n2) {
            if ((kud2.mask & 1 << n2) == 0) continue;
            n = (kud2.labels & 1 << n2) != 0 ? 1 : 0;
            if (n == kud2.p[n2] >= 0.5) {
                ++n3;
            }
            if (n != 0) {
                ++n5;
            }
            ++n4;
        }
        this.kuy += 0.01 * ((double)n3 / (double)n4 - this.kuy);
        this.kuz += 0.01 * ((double)n5 / (double)n4 - this.kuz);
        n2 = this.kvg;
        for (n = 0; n < 15; ++n) {
            this.kvc[n2 * 15 + n] = (float)kud2.x[n];
        }
        this.kvd[n2] = (byte)kud2.labels;
        this.kve[n2] = (byte)kud2.mask;
        this.kvg = (this.kvg + 1) % 20000;
        this.kvf = Math.min(20000, this.kvf + 1);
        ++this.kux;
    }

    void train() {
        this.kvv();
        if (this.kvf < 64) {
            return;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 6; ++i) {
            Arrays.fill(this.kvp, 0.0);
            for (int j = 0; j < 16; ++j) {
                int n;
                int n2 = threadLocalRandom.nextInt(this.kvf);
                for (n = 0; n < 15; ++n) {
                    this.kvo[n] = this.kvc[n2 * 15 + n];
                }
                this.kut.forward(this.kvo, this.kvi, this.kvj, this.kvk);
                n = this.kvd[n2];
                byte by = this.kve[n2];
                for (int k = 0; k < 8; ++k) {
                    if ((by & 1 << k) == 0) {
                        this.kvl[k] = 0.0;
                        continue;
                    }
                    double d = (n & 1 << k) != 0 ? 1.0 : 0.0;
                    this.kvl[k] = (kug.kvy(this.kvk[k]) - d) / 16.0;
                }
                this.kut.backward(this.kvo, this.kvi, this.kvj, this.kvl, this.kvp, null, this.kvm, this.kvn);
            }
            this.kvu();
        }
        if (++this.kva >= 2000) {
            this.kva = 0;
            this.save();
        }
    }

    private void kvu() {
        ++this.kuw;
        double d = 1.0 - Math.pow(0.9, this.kuw);
        double d2 = 1.0 - Math.pow(0.999, this.kuw);
        double[] dArray = this.kut.p;
        for (int i = 0; i < dArray.length; ++i) {
            this.kuu[i] = 0.9 * this.kuu[i] + 0.09999999999999998 * this.kvp[i];
            this.kuv[i] = 0.999 * this.kuv[i] + 0.0010000000000000009 * this.kvp[i] * this.kvp[i];
            int n = i;
            dArray[n] = dArray[n] - 0.001 * (this.kuu[i] / d) / (Math.sqrt(this.kuv[i] / d2) + 1.0E-8);
        }
    }

    void reset() {
        this.kvv();
        this.kvw();
        this.kvf = 0;
        this.kvg = 0;
        this.kvh.clear();
        this.save();
    }

    void save() {
        if (this.kut == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(1177700436);
            dataOutputStream.writeLong(this.kux);
            dataOutputStream.writeDouble(this.kuy);
            dataOutputStream.writeDouble(this.kuz);
            this.kut.write(dataOutputStream);
            dataOutputStream.flush();
            byte[] byArray = byteArrayOutputStream.toByteArray();
            vza.later(a.c(117273160, "\u720e\u0b99\u8151\u1f2e\u94f9\u124a\ua80e\u21cf\ubfbd\u3517\ub290\u48af\uc673\u5fd3\ud583\u536a\ue938\u66f0"), () -> ewk.putBytes(a.c(-2130004419, "\ub653\ucfe3\u452d\udb46\u509a\ud63a"), byArray));
        }
        catch (Exception exception) {
            System.out.println(a.d("\u1fcf\u667c\ueca0\u7298\uf91c\u7ff9\uc5f9\u4c1a\ud252\u58f0\udf66\u2543\uab88\u3234\ub822\u3ea7\u84ce\u0b04\u91b9\u17e8\u9e1d\ue45b\u6ad8\uf124\u7740\ufdc5\u4438\uca62\u5084\ud6d6\u5d7d\ua3b1\u29e7\ub047\u360e", -1252507720, 510009399) + exception);
        }
    }

    private void kvv() {
        if (this.kvb) {
            return;
        }
        this.kvb = true;
        try {
            DataInputStream dataInputStream;
            byte[] byArray = ewk.getBytes(a.b("\u86ab\uff1b\u75d5\uebbe\u6062\ue6c2", -554989883));
            if (byArray != null && byArray.length > 0 && (dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray))).readInt() == 1177700436) {
                long l = dataInputStream.readLong();
                double d = dataInputStream.readDouble();
                double d2 = dataInputStream.readDouble();
                tbx tbx2 = tbx.read(dataInputStream);
                if (tbx2.in == 15 && tbx2.h1 == 32 && tbx2.h2 == 16 && tbx2.out == 8) {
                    this.kvx(tbx2);
                    this.kux = l;
                    this.kuy = d;
                    this.kuz = d2;
                    return;
                }
            }
        }
        catch (Exception exception) {
            System.out.println(a.d("\u7cd2\u0561\u8fbd\u1185\u9a01\u1ce4\ua6e5\u2f03\ub158\u3bec\ubc7b\u465e\uc895\u5129\udb3f\u5dba\ue7d3\u6819\uf2a4\u74f5\ufd00\u8746\u09c5\u9239\u145d\u9ed8\u2725\ua97f\u3399\ub5cb\u3e60\uc0ac\u4afa\ud35a\u5513", -700514834, 1629585788) + exception);
        }
        this.kvw();
    }

    private void kvw() {
        tbx tbx2 = new tbx(15, 32, 16, 8);
        tbx2.init(new Random(), new double[8]);
        this.kvx(tbx2);
        this.kux = 0L;
        this.kuy = 0.5;
        this.kuz = 0.5;
        this.kuw = 0L;
    }

    private void kvx(tbx tbx2) {
        this.kut = tbx2;
        this.kuu = new double[tbx2.size()];
        this.kuv = new double[tbx2.size()];
        this.kvp = new double[tbx2.size()];
        this.kuw = 0L;
    }

    private static double kvy(double d) {
        return 1.0 / (1.0 + Math.exp(-d));
    }

    private static /* synthetic */ int ave(int n, int n2) {
        return n - n2 + 1109588455;
    }

    private static /* synthetic */ int avf(int n, int n2) {
        return kug.ave(n, n2) ^ 0x5E2B3139;
    }
}

