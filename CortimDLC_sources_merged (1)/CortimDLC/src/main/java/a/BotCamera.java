/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1011
 *  net.minecraft.class_1058
 *  net.minecraft.class_1092
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1542
 *  net.minecraft.class_1588
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_745
 *  net.minecraft.class_746
 *  net.minecraft.class_7764
 *  net.minecraft.class_8113
 */
package a;

import a.Bot;
import a.dxe;
import a.dxq;
import a.dxv;
import a.dxy;
import a.dye;
import a.UnsafeUtil;
import a.BotTexture;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.minecraft.class_1011;
import net.minecraft.class_1058;
import net.minecraft.class_1092;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1588;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_745;
import net.minecraft.class_746;
import net.minecraft.class_7764;
import net.minecraft.class_8113;

public final class BotCamera {
    public static final int WIDTH = 256;
    public static final int HEIGHT = 170;
    private static final double dyi = 56.0;
    private static final long dyj = 45000000L;
    private static final int dyk = Math.max(1, Math.min(6, Runtime.getRuntime().availableProcessors() - 1));
    private static final ExecutorService dyl = Executors.newFixedThreadPool(dyk, runnable -> {
        Thread thread = new Thread(runnable, "Flow2 bot camera");
        thread.setDaemon(true);
        thread.setPriority(5);
        return thread;
    });
    private static final Map<class_2680, dxq> dym = new ConcurrentHashMap<class_2680, dxq>();
    private static final Map<class_1058, dxy> dyn = new ConcurrentHashMap<class_1058, dxy>();
    private static final long dyo = BotCamera.ead();
    private static final class_2350[] dyp = class_2350.values();
    private static final class_310 dyq = class_310.method_1551();
    private static final Set<BotCamera> dyr = Collections.newSetFromMap(new IdentityHashMap());
    private static final double[] dys = BotCamera.eac();
    private final Bot dyt;
    private final int[] dyu = new int[43520];
    private final float[] dyv = new float[43520];
    private final List<dxe> dyw = new ArrayList<dxe>();
    private final dye[] dyx = new dye[dyk * 3];
    private final long[] dyy = new long[dyk * 3];
    private List<Future<?>> dyz;
    private class_638 dza;
    private class_746 dzb;
    private float dzc;
    private long dzd;
    private int dze;
    private BotTexture dzf;
    private long dzg;
    private long dzh;
    private boolean dzi;
    private String dzj = "камера включается...";
    private Object dzk;
    private float dzl;
    private float dzm;
    private double dzn;
    private double dzo;
    private double dzp;
    private double dzq;
    private double dzr;
    private double dzs;
    private double dzt;
    private double dzu;
    private double dzv;
    private double dzw;
    private double dzx;
    private double dzy;
    private double dzz;
    private static /* synthetic */ String eaa;
    private static /* synthetic */ String eab;

    BotCamera(Bot dtv2) {
        this.dyt = dtv2;
    }

    private static double[] eac() {
        double[] dArray = new double[61];
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = 0.18 + 0.82 * Math.pow((double)i / 60.0, 1.25);
        }
        return dArray;
    }

    private static long ead() {
        try {
            return UnsafeUtil.offset(class_7764.class, class_1011.class);
        }
        catch (Throwable throwable) {
            return -1L;
        }
    }

    public void demand() {
        this.dzh = System.currentTimeMillis() + 1000L;
    }

    public boolean isReady() {
        return this.dzi;
    }

    public float getRenderMillis() {
        return this.dzl;
    }

    public float getTraceMillis() {
        return this.dzm;
    }

    public String getStatus() {
        return this.dzj;
    }

    public List<dxe> labels() {
        return this.dyw;
    }

    public BotTexture texture() {
        if (this.dyz != null) {
            for (Future<?> future : this.dyz) {
                if (future.isDone()) continue;
                return this.dzi ? this.dzf : null;
            }
            this.eaf();
        }
        long l = System.nanoTime();
        if (System.currentTimeMillis() <= this.dzh && l - this.dzg >= 45000000L) {
            this.dzg = l;
            try {
                this.eah();
            }
            catch (Throwable throwable) {
                this.dzj = "ошибка камеры: " + throwable.getClass().getSimpleName();
                this.dzi = false;
                this.dyz = null;
                dyr.remove(this);
            }
        }
        return this.dzi ? this.dzf : null;
    }

    static void awaitAll() {
        if (dyr.isEmpty()) {
            return;
        }
        for (BotCamera dyh2 : new ArrayList<BotCamera>(dyr)) {
            dyh2.eae();
        }
    }

    private void eae() {
        List<Future<?>> list = this.dyz;
        if (list == null) {
            dyr.remove(this);
            return;
        }
        for (Future<?> future : list) {
            try {
                future.get();
            }
            catch (Throwable throwable) {}
        }
    }

    private void eaf() {
        List<Future<?>> list = this.dyz;
        this.dyz = null;
        dyr.remove(this);
        try {
            for (Future<?> future : list) {
                future.get();
            }
            long l = this.dzd;
            for (long l2 : this.dyy) {
                l = Math.max(l, l2);
            }
            this.dzm = this.dzm * 0.8f + (float)(l - this.dzd) / 1000000.0f * 0.2f;
            long l3 = System.nanoTime();
            this.eak(this.dza, this.dzb, this.dzc);
            this.eag();
            this.dzl = this.dzl * 0.8f + (float)(System.nanoTime() - l3) / 1000000.0f * 0.2f;
            this.dzi = true;
        }
        catch (Throwable throwable) {
            Throwable throwable2 = throwable.getCause() != null ? throwable.getCause() : throwable;
            this.dzj = "ошибка камеры: " + throwable2.getClass().getSimpleName();
            this.dzi = false;
        }
        this.dza = null;
        this.dzb = null;
    }

    private void eag() {
        if (this.dzf == null) {
            this.dzf = new BotTexture("camera", 256, 170);
        }
        for (int i = 0; i < 170; ++i) {
            int n = i * 256;
            for (int j = 0; j < 256; ++j) {
                this.dzf.set(j, i, this.dyu[n + j]);
            }
        }
        this.dzf.upload();
    }

    void reset() {
        this.dzi = false;
        this.dzj = "камера включается...";
        this.dyw.clear();
    }

    void close() {
        this.eae();
        this.dyz = null;
        dyr.remove(this);
        if (this.dzf != null) {
            this.dzf.close();
            this.dzf = null;
        }
        this.dzi = false;
    }

    private boolean eah() {
        class_746 class_7462 = this.dyt.getPlayer();
        class_638 class_6382 = this.dyt.getWorld();
        if (class_7462 == null || class_6382 == null) {
            this.dzj = "бот не в игре";
            return false;
        }
        class_1092 class_10922 = dyq.method_1554();
        if (class_10922 != this.dzk) {
            this.dzk = class_10922;
            dym.clear();
            dyn.clear();
        }
        float f = this.dyt.partialTick();
        class_243 class_2432 = class_7462.method_5836(f);
        float f2 = class_7462.method_5705(f);
        float f3 = class_7462.method_5695(f);
        this.dzn = class_2432.field_1352;
        this.dzo = class_2432.field_1351;
        this.dzp = class_2432.field_1350;
        double d = Math.toRadians(f2);
        double d2 = Math.toRadians(f3);
        this.dzq = -Math.sin(d) * Math.cos(d2);
        this.dzr = -Math.sin(d2);
        this.dzs = Math.cos(d) * Math.cos(d2);
        this.dzt = -Math.cos(d);
        this.dzu = -Math.sin(d);
        this.dzv = -this.dzu * this.dzr;
        this.dzw = this.dzu * this.dzq - this.dzt * this.dzs;
        this.dzx = this.dzt * this.dzr;
        double d3 = BotCamera.dyq.field_1690 == null ? 70.0 : (double)((Integer)BotCamera.dyq.field_1690.method_41808().method_41753()).intValue();
        this.dzz = Math.tan(Math.toRadians(d3) * 0.5);
        this.dzy = this.dzz * 256.0 / 170.0;
        dxv dxv2 = new dxv(class_6382, class_7462, this.dyt.crosshair);
        int n = this.dyx.length;
        boolean bl = ++this.dze % 40 == 0;
        for (int i = 0; i < n; ++i) {
            if (this.dyx[i] == null) {
                this.dyx[i] = new dye();
            }
            this.dyx[i].begin(dxv2, bl);
        }
        this.dza = class_6382;
        this.dzb = class_7462;
        this.dzc = f;
        this.dzd = System.nanoTime();
        ArrayList arrayList = new ArrayList(n);
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            this.dyy[n3] = this.dzd;
            arrayList.add(dyl.submit(() -> {
                dye dye2 = this.dyx[n3];
                for (int i = n3; i < 170; i += n) {
                    this.eai(dye2, i);
                }
                this.dyy[n] = System.nanoTime();
            }));
        }
        this.dyz = arrayList;
        dyr.add(this);
        return true;
    }

    private void eai(dye dye2, int n) {
        double d = (1.0 - 2.0 * ((double)n + 0.5) / 170.0) * this.dzz;
        int n2 = n * 256;
        for (int i = 0; i < 256; ++i) {
            double d2 = (2.0 * ((double)i + 0.5) / 256.0 - 1.0) * this.dzy;
            double d3 = this.dzq + this.dzt * d2 + this.dzv * d;
            double d4 = this.dzr + this.dzw * d;
            double d5 = this.dzs + this.dzu * d2 + this.dzx * d;
            double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
            this.dyu[n2 + i] = dye2.trace(this.dzn, this.dzo, this.dzp, d3 /= d6, d4 /= d6, d5 /= d6);
            this.dyv[n2 + i] = (float)dye2.hitDistance;
        }
    }

    private boolean eaj(double d, double d2, double d3, double[] dArray) {
        double d4 = d - this.dzn;
        double d5 = d2 - this.dzo;
        double d6 = d3 - this.dzp;
        double d7 = d4 * this.dzq + d5 * this.dzr + d6 * this.dzs;
        if (d7 <= 0.05) {
            return false;
        }
        double d8 = d4 * this.dzt + d6 * this.dzu;
        double d9 = d4 * this.dzv + d5 * this.dzw + d6 * this.dzx;
        dArray[0] = (d8 / d7 / this.dzy + 1.0) * 0.5 * 256.0;
        dArray[1] = (1.0 - d9 / d7 / this.dzz) * 0.5 * 170.0;
        dArray[2] = d7;
        return true;
    }

    private void eak(class_638 class_6382, class_746 class_7462, float f) {
        this.dyw.clear();
        double[] dArray = new double[3];
        class_1297 class_12972 = class_7462.method_5668();
        for (class_1297 class_12973 : class_6382.method_18112()) {
            if (class_12973 == class_7462 || class_12973 == class_12972 || class_12973.method_31481() || class_12973 instanceof class_8113 || class_12973.method_5767()) continue;
            class_243 class_2432 = class_12973.method_30950(f);
            double d = class_2432.field_1352 - this.dzn;
            double d2 = class_2432.field_1351 - this.dzo;
            double d3 = class_2432.field_1350 - this.dzp;
            if (d * d + d2 * d2 + d3 * d3 > 3136.0) continue;
            class_238 class_2382 = class_12973.method_5829().method_997(class_2432.method_1020(class_12973.method_73189()));
            int n = BotCamera.eal(class_12973);
            if (class_12973 instanceof class_745) {
                int n2;
                double d4 = Math.min(0.5, class_2382.method_17940() * 0.28);
                this.eam(class_2382.method_35575(class_2382.field_1325 - d4).method_1009(0.02, 0.0, 0.02), -2050932);
                this.eam(class_2382.method_35578(class_2382.field_1325 - d4), n);
                if (!this.eaj(class_2432.field_1352, class_2382.field_1325 + 0.35, class_2432.field_1350, dArray) || !(dArray[0] >= 0.0) || !(dArray[0] < 256.0) || !(dArray[1] >= 0.0) || !(dArray[1] < 170.0) || !((double)this.dyv[n2 = (int)dArray[1] * 256 + (int)dArray[0]] + 0.5 >= dArray[2]) && !(dArray[2] < 6.0)) continue;
                this.dyw.add(new dxe(class_12973.method_5477().getString(), (float)(dArray[0] / 256.0), (float)(dArray[1] / 170.0), -1));
                continue;
            }
            this.eam(class_2382, n);
        }
    }

    private static int eal(class_1297 class_12972) {
        if (class_12972 instanceof class_745) {
            return -12685352;
        }
        if (class_12972 instanceof class_1542) {
            return -863670;
        }
        if (class_12972 instanceof class_1588) {
            return -8408516;
        }
        if (class_12972 instanceof class_1309) {
            return -3630230;
        }
        return -6249300;
    }

    private void eam(class_238 class_2382, int n) {
        double d;
        int n2;
        double[] dArray = new double[3];
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        double d5 = -1.7976931348623157E308;
        int n3 = 0;
        for (n2 = 0; n2 < 8; ++n2) {
            double d6 = (n2 & 1) == 0 ? class_2382.field_1323 : class_2382.field_1320;
            double d7 = (n2 & 2) == 0 ? class_2382.field_1322 : class_2382.field_1325;
            double d8 = d = (n2 & 4) == 0 ? class_2382.field_1321 : class_2382.field_1324;
            if (!this.eaj(d6, d7, d, dArray)) continue;
            ++n3;
            d2 = Math.min(d2, dArray[0]);
            d4 = Math.max(d4, dArray[0]);
            d3 = Math.min(d3, dArray[1]);
            d5 = Math.max(d5, dArray[1]);
        }
        if (n3 < 8) {
            return;
        }
        n2 = Math.max(0, (int)Math.floor(d2));
        int n4 = Math.min(255, (int)Math.ceil(d4));
        int n5 = Math.max(0, (int)Math.floor(d3));
        int n6 = Math.min(169, (int)Math.ceil(d5));
        for (int i = n5; i <= n6; ++i) {
            d = (1.0 - 2.0 * ((double)i + 0.5) / 170.0) * this.dzz;
            for (int j = n2; j <= n4; ++j) {
                double d9;
                double d10;
                int n7;
                double d11 = (2.0 * ((double)j + 0.5) / 256.0 - 1.0) * this.dzy;
                double d12 = this.dzq + this.dzt * d11 + this.dzv * d;
                double d13 = this.dzr + this.dzw * d;
                double d14 = this.dzs + this.dzu * d11 + this.dzx * d;
                double d15 = Math.sqrt(d12 * d12 + d13 * d13 + d14 * d14);
                double d16 = -1.7976931348623157E308;
                double d17 = Double.MAX_VALUE;
                int n8 = -1;
                double[] dArray2 = new double[]{this.dzn, this.dzo, this.dzp};
                double[] dArray3 = new double[]{d12 /= d15, d13 /= d15, d14 /= d15};
                double[] dArray4 = new double[]{class_2382.field_1323, class_2382.field_1322, class_2382.field_1321};
                double[] dArray5 = new double[]{class_2382.field_1320, class_2382.field_1325, class_2382.field_1324};
                boolean bl = false;
                for (n7 = 0; n7 < 3; ++n7) {
                    if (Math.abs(dArray3[n7]) < 1.0E-9) {
                        if (!(dArray2[n7] < dArray4[n7]) && !(dArray2[n7] > dArray5[n7])) continue;
                        bl = true;
                        break;
                    }
                    d10 = (dArray4[n7] - dArray2[n7]) / dArray3[n7];
                    d9 = (dArray5[n7] - dArray2[n7]) / dArray3[n7];
                    if (d10 > d9) {
                        double d18 = d10;
                        d10 = d9;
                        d9 = d18;
                    }
                    if (d10 > d16) {
                        d16 = d10;
                        n8 = n7;
                    }
                    d17 = Math.min(d17, d9);
                }
                if (bl || d16 > d17 || d16 <= 0.0 || d16 >= (double)this.dyv[n7 = i * 256 + j]) continue;
                d10 = n8 == 1 ? (dArray3[1] < 0.0 ? 1.0 : 0.55) : (n8 == 0 ? 0.72 : 0.86);
                d9 = Math.min(1.0, d16 / 56.0);
                int n9 = BotCamera.scale(n, d10);
                this.dyu[n7] = BotCamera.AutoTpAccept(n9, this.dyu[n7], d9 * d9 * 0.6);
                this.dyv[n7] = (float)d16;
            }
        }
    }

    static int scale(int n, double d) {
        int n2 = (int)Math.min(255.0, (double)(n >> 16 & 0xFF) * d);
        int n3 = (int)Math.min(255.0, (double)(n >> 8 & 0xFF) * d);
        int n4 = (int)Math.min(255.0, (double)(n & 0xFF) * d);
        return 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    static int mul(int n, int n2) {
        int n3 = (n >> 16 & 0xFF) * (n2 >> 16 & 0xFF) / 255;
        int n4 = (n >> 8 & 0xFF) * (n2 >> 8 & 0xFF) / 255;
        int n5 = (n & 0xFF) * (n2 & 0xFF) / 255;
        return n & 0xFF000000 | n3 << 16 | n4 << 8 | n5;
    }

    static int AutoTpAccept(int n, int n2, double d) {
        double d2 = 1.0 - d;
        int n3 = (int)((double)(n >> 16 & 0xFF) * d2 + (double)(n2 >> 16 & 0xFF) * d);
        int n4 = (int)((double)(n >> 8 & 0xFF) * d2 + (double)(n2 >> 8 & 0xFF) * d);
        int n5 = (int)((double)(n & 0xFF) * d2 + (double)(n2 & 0xFF) * d);
        return 0xFF000000 | n3 << 16 | n4 << 8 | n5;
    }

    private static dxy ean(class_1058 class_10583) {
        if (class_10583 == null || dyo < 0L) {
            return null;
        }
        return dyn.computeIfAbsent(class_10583, class_10582 -> {
            try {
                class_7764 class_77642 = class_10582.method_45851();
                class_1011 class_10112 = (class_1011)UnsafeUtil.get(class_77642, dyo);
                int n = class_77642.method_45807();
                int n2 = class_77642.method_45815();
                if (class_10112 == null || n <= 0 || n2 <= 0) {
                    return null;
                }
                int[] nArray = new int[n * n2];
                for (int i = 0; i < n2; ++i) {
                    for (int j = 0; j < n; ++j) {
                        nArray[i * n + j] = class_10112.method_61940(j, i);
                    }
                }
                return new dxy(n, n2, nArray);
            }
            catch (Throwable throwable) {
                return null;
            }
        });
    }

    private static /* synthetic */ int ca(int n, int n2) {
        return n + n2 + -241313394;
    }

    private static /* synthetic */ int cb(int n, int n2) {
        return BotCamera.ca(n, n2) * n2;
    }

    private static /* synthetic */ int cc(int n, int n2) {
        return BotCamera.ca(n, n2) ^ 0xF0551AA1;
    }
}

