/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eqc;
import a.eqw;
import a.erc;
import a.erh;
import a.erk;
import a.ezj;
import flow.dev.a;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class erp {
    private static final int erq = 10;
    private static final double err = 0.35;
    private static final int ers = 5;
    private static final int ert = 22;
    private static final int eru = 0xECECE8;
    private static final double erv = Math.log(2.0);
    private static final String erw = new String(new char[]{'f', 'l', 'o', 'w'});
    private static final String erx = new String(new char[]{'c', 'a', 'p', 't', 'c', 'h', 'a', '/', 'd', 'i', 'g', 'i', 't', 's', '.', 'o', 'n', 'n', 'x'});
    private static final Object ery = new Object();
    private static volatile eqc erz;
    private static final ThreadPoolExecutor esa;
    private static /* synthetic */ int esb;
    private static /* synthetic */ int esc;

    private erp() {
    }

    private static ThreadPoolExecutor esd() {
        int n = Math.max(1, Math.min(6, Runtime.getRuntime().availableProcessors() - 1));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(n, n, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), runnable -> {
            Thread thread = Executors.defaultThreadFactory().newThread(runnable);
            thread.setDaemon(true);
            return thread;
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void preload() {
        try {
            eqc eqc2 = erp.esm();
            eqc2.logits(new float[3 * eqc2.inputH * eqc2.inputW]);
        }
        catch (erh | InterruptedException | RuntimeException exception) {
            // empty catch block
        }
    }

    public static erc solve(BufferedImage bufferedImage) throws erh {
        eqc eqc2 = erp.esm();
        try {
            erk erk2 = erp.read(bufferedImage, eqc2);
            if (!erk2.code().isEmpty() && erk2.strength() >= 0.35) {
                return new erc(erk2.code(), a.d("\ue046\u99f3", -1026138789, 2072952176));
            }
            return new erc("", a.c(2075820018, "\u7f8e\u0624\u8cfa\u128d\u994d\u1ffa\ua5bc\u2c45\ub21d"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return new erc("", illegalArgumentException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return new erc("", a.c(1993195927, "\uc1f5\ub843\u328a\uacea\u272a\ua19b\u1bcf\u923b\u0c60\u86c0\u0112"));
        }
        catch (RuntimeException | ExecutionException exception) {
            Exception exception2 = exception instanceof ExecutionException && exception.getCause() != null ? exception.getCause() : exception;
            return new erc("", a.c(1766866921, "\u3fad\u4610\uccd2\u52d1\ud943\u5fe5\ue5b6\u6c5a\uf218\u78e1\uff28") + exception2);
        }
    }

    static erk read(BufferedImage bufferedImage, eqc eqc2) throws InterruptedException, ExecutionException {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        if (n > 4096 || n2 > 4096 || Math.min(n, n2) < 16) {
            throw new IllegalArgumentException(a.d("\uae5b\ud7d1\u5d1f\uc368\u48ba\uce0b\u7447\ufdab\u63f2\ue952\u6e80\u94b5\u1a2b\u839e\u09c1\u8f36\u357b\ubaef\u200f\ua644\u2fa0\u55ee", -1073510822, 1330063426));
        }
        List<eqw> list = erp.views(erp.flatten(bufferedImage));
        ArrayList<Callable<float[][]>> arrayList = new ArrayList<Callable<float[][]>>(list.size());
        for (eqw object2 : list) {
            arrayList.add(() -> erp.esh(eqc2.logits(erp.tensor(erp.resize(object2, eqc2.inputW, eqc2.inputH)))));
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        List list2 = esa.invokeAll(arrayList);
        for (Future future : list2) {
            arrayList2.add((float[][])future.get());
        }
        return erp.vote(arrayList2);
    }

    static erk vote(List<float[][]> list) {
        String string;
        Object object2;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (Object object2 : list) {
            string = erp.ese(object2);
            if (string.length() < 3 || string.length() > 8) continue;
            linkedHashSet.add(string);
        }
        if (linkedHashSet.isEmpty()) {
            return new erk("", 0.0);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object2 = linkedHashSet.iterator();
        while (object2.hasNext()) {
            string = (String)object2.next();
            double d = 0.0;
            double d2 = 0.0;
            for (float[][] fArray : list) {
                double d3 = erp.esf(fArray, string);
                d += d3;
                d2 += Math.exp(d3);
            }
            if (string.length() != 5) {
                d -= 2.0;
            }
            linkedHashMap.put(string, new double[]{d, d2 / (double)list.size()});
        }
        object2 = null;
        double d = Double.NEGATIVE_INFINITY;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!(((double[])entry.getValue())[0] > d)) continue;
            d = ((double[])entry.getValue())[0];
            object2 = (String)entry.getKey();
        }
        double d4 = 0.0;
        Iterator iterator = linkedHashMap.values().iterator();
        while (iterator.hasNext()) {
            Object object3 = (double[])iterator.next();
            d4 += Math.exp((double)(object3[0] - d));
        }
        double d5 = Math.exp(((double[])linkedHashMap.get(object2))[0] - d) / d4;
        double d6 = ((double[])linkedHashMap.get(object2))[1];
        return new erk((String)object2, d5 * Math.min(1.0, d6 * 2.5));
    }

    private static String ese(float[][] fArray) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 10;
        for (float[] fArray2 : fArray) {
            int n2 = 0;
            for (int i = 1; i < fArray2.length; ++i) {
                if (!(fArray2[i] > fArray2[n2])) continue;
                n2 = i;
            }
            if (n2 != 10 && n2 != n) {
                stringBuilder.append((char)(48 + n2));
            }
            n = n2;
        }
        return stringBuilder.toString();
    }

    private static double esf(float[][] fArray, String string) {
        int n = string.length() * 2 + 1;
        int[] nArray = new int[n];
        nArray[0] = 10;
        for (int i = 0; i < string.length(); ++i) {
            nArray[2 * i + 1] = string.charAt(i) - 48;
            nArray[2 * i + 2] = 10;
        }
        double d = -1.0E30;
        double[] dArray = new double[n];
        double[] dArray2 = new double[n];
        Arrays.fill(dArray, d);
        dArray[0] = fArray[0][nArray[0]];
        dArray[1] = fArray[0][nArray[1]];
        for (int i = 1; i < fArray.length; ++i) {
            for (int j = 0; j < n; ++j) {
                double d2 = dArray[j];
                if (j >= 1) {
                    d2 = erp.esg(d2, dArray[j - 1]);
                }
                if (j >= 2 && nArray[j] != 10 && nArray[j] != nArray[j - 2]) {
                    d2 = erp.esg(d2, dArray[j - 2]);
                }
                dArray2[j] = d2 + (double)fArray[i][nArray[j]];
            }
            double[] dArray3 = dArray;
            dArray = dArray2;
            dArray2 = dArray3;
        }
        return erp.esg(dArray[n - 1], dArray[n - 2]);
    }

    private static double esg(double d, double d2) {
        if (d == d2) {
            return d + erv;
        }
        double d3 = d - d2;
        return d3 > 0.0 ? d + Math.log1p(Math.exp(-d3)) : d2 + Math.log1p(Math.exp(d3));
    }

    private static float[][] esh(float[][] fArray) {
        float[][] fArrayArray = new float[fArray.length][];
        for (int i = 0; i < fArray.length; ++i) {
            float[] fArray2 = fArray[i];
            float f = Float.NEGATIVE_INFINITY;
            for (float f2 : fArray2) {
                f = Math.max(f, f2);
            }
            double d = 0.0;
            for (float f3 : fArray2) {
                d += Math.exp(f3 - f);
            }
            double d2 = Math.log(d);
            float[] fArray3 = new float[fArray2.length];
            for (int j = 0; j < fArray2.length; ++j) {
                fArray3[j] = (float)((double)(fArray2[j] - f) - d2);
            }
            fArrayArray[i] = fArray3;
        }
        return fArrayArray;
    }

    static eqw flatten(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n, n2, null, 0, n);
        for (int i = 0; i < nArray.length; ++i) {
            int n3 = nArray[i];
            int n4 = n3 >>> 24;
            if (n4 == 0) {
                nArray[i] = 0xFFFFFF;
                continue;
            }
            int n5 = n4 * 128;
            int n6 = 32640 - n5;
            nArray[i] = erp.esi(n3 >> 16 & 0xFF, n5, n6) << 16 | erp.esi(n3 >> 8 & 0xFF, n5, n6) << 8 | erp.esi(n3 & 0xFF, n5, n6);
        }
        return new eqw(nArray, n, n2);
    }

    private static int esi(int n, int n2, int n3) {
        int n4 = n * n2 + 255 * n3 + 16384;
        return (n4 >> 8) + n4 >> 8 >> 7;
    }

    static List<eqw> views(eqw eqw2) {
        int n;
        int n2;
        int n3 = eqw2.w();
        int n4 = eqw2.h();
        ArrayList<eqw> arrayList = new ArrayList<eqw>(6);
        arrayList.add(eqw2);
        for (double d : new double[]{0.04, 0.08}) {
            n2 = (int)((double)n3 * d);
            n = (int)((double)n4 * d);
            arrayList.add(erp.esj(eqw2, n2, n, n3 - n2, n4 - n));
        }
        for (double d : new double[]{0.07, 0.12}) {
            n2 = (int)((double)n3 * d);
            n = (int)((double)n4 * d);
            int n5 = n3 + 2 * n2;
            int n6 = n4 + 2 * n;
            int[] nArray = new int[n5 * n6];
            Arrays.fill(nArray, 0xECECE8);
            for (int i = 0; i < n4; ++i) {
                System.arraycopy(eqw2.px(), i * n3, nArray, (i + n) * n5 + n2, n3);
            }
            arrayList.add(new eqw(nArray, n5, n6));
        }
        int n7 = (int)((double)n4 * 0.06);
        arrayList.add(erp.esj(eqw2, 0, n7, n3, n4 - n7));
        return arrayList;
    }

    private static eqw esj(eqw eqw2, int n, int n2, int n3, int n4) {
        int n5 = n3 - n;
        int n6 = n4 - n2;
        int[] nArray = new int[n5 * n6];
        for (int i = 0; i < n6; ++i) {
            System.arraycopy(eqw2.px(), (i + n2) * eqw2.w() + n, nArray, i * n5, n5);
        }
        return new eqw(nArray, n5, n6);
    }

    static eqw resize(eqw eqw2, int n, int n2) {
        eqw eqw3 = eqw2;
        if (n != eqw3.w()) {
            eqw3 = erp.esk(eqw3, n, true);
        }
        if (n2 != eqw3.h()) {
            eqw3 = erp.esk(eqw3, n2, false);
        }
        return eqw3;
    }

    private static eqw esk(eqw eqw2, int n, boolean bl) {
        int n2;
        int n3;
        int n4;
        int n5;
        double d;
        int n6 = bl ? eqw2.w() : eqw2.h();
        double d2 = (double)n6 / (double)n;
        double d3 = d = Math.max(1.0, d2);
        int n7 = (int)Math.ceil(d3) * 2 + 1;
        int[] nArray = new int[n * 2];
        int[] nArray2 = new int[n * n7];
        double[] dArray = new double[n7];
        for (n5 = 0; n5 < n; ++n5) {
            double d4;
            double d5 = ((double)n5 + 0.5) * d2;
            double d6 = 1.0 / d;
            n4 = (int)(d5 - d3 + 0.5);
            if (n4 < 0) {
                n4 = 0;
            }
            if ((n3 = (int)(d5 + d3 + 0.5)) > n6) {
                n3 = n6;
            }
            n3 -= n4;
            double d7 = 0.0;
            for (n2 = 0; n2 < n3; ++n2) {
                d4 = Math.abs(((double)(n2 + n4) - d5 + 0.5) * d6);
                dArray[n2] = d4 < 1.0 ? 1.0 - d4 : 0.0;
                d7 += dArray[n2];
            }
            for (n2 = 0; n2 < n3; ++n2) {
                d4 = d7 != 0.0 ? dArray[n2] / d7 : dArray[n2];
                nArray2[n5 * n7 + n2] = d4 < 0.0 ? (int)(-0.5 + d4 * 4194304.0) : (int)(0.5 + d4 * 4194304.0);
            }
            nArray[n5 * 2] = n4;
            nArray[n5 * 2 + 1] = n3;
        }
        n5 = bl ? n : eqw2.w();
        int n8 = bl ? eqw2.h() : n;
        int[] nArray3 = new int[n5 * n8];
        int[] nArray4 = eqw2.px();
        int n9 = bl ? 1 : eqw2.w();
        n4 = bl ? n8 : n5;
        for (n3 = 0; n3 < n4; ++n3) {
            for (int i = 0; i < n; ++i) {
                int n10;
                int n11;
                int n12 = nArray[i * 2];
                n2 = nArray[i * 2 + 1];
                int n13 = i * n7;
                int n14 = bl ? n3 * eqw2.w() + n12 : n12 * eqw2.w() + n3;
                int n15 = n11 = 0x200000;
                int n16 = n11;
                for (n10 = 0; n10 < n2; ++n10) {
                    int n17 = nArray4[n14 + n10 * n9];
                    int n18 = nArray2[n13 + n10];
                    n11 += (n17 >> 16 & 0xFF) * n18;
                    n15 += (n17 >> 8 & 0xFF) * n18;
                    n16 += (n17 & 0xFF) * n18;
                }
                n10 = bl ? n3 * n5 + i : i * n5 + n3;
                nArray3[n10] = erp.esl(n11) << 16 | erp.esl(n15) << 8 | erp.esl(n16);
            }
        }
        return new eqw(nArray3, n5, n8);
    }

    private static int esl(int n) {
        int n2 = n >> 22;
        return n2 < 0 ? 0 : Math.min(n2, 255);
    }

    static float[] tensor(eqw eqw2) {
        int n = eqw2.w() * eqw2.h();
        float[] fArray = new float[3 * n];
        int[] nArray = eqw2.px();
        for (int i = 0; i < n; ++i) {
            int n2 = nArray[i];
            fArray[i] = (float)(n2 >> 16 & 0xFF) / 127.5f - 1.0f;
            fArray[n + i] = (float)(n2 >> 8 & 0xFF) / 127.5f - 1.0f;
            fArray[2 * n + i] = (float)(n2 & 0xFF) / 127.5f - 1.0f;
        }
        return fArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static eqc esm() throws erh {
        eqc eqc2 = erz;
        if (eqc2 != null) {
            return eqc2;
        }
        Object object = ery;
        synchronized (object) {
            if (erz != null) {
                return erz;
            }
            byte[] byArray = erp.esn(erx);
            if (byArray == null) {
                throw new erh(a.c(-330721377, "\u9382\uea31\u60e8\ufe98\u7541\uf387\u4db8\uc053\u5e06\ud4b8\u5313\ua91d\u23d2\ube7d\u3452\ub2a0\u08ed\u873d\u1d8d\u9bdf\u1258\u6878\ue6bd\u7d1b\uff06\u71c5\ucc64\u4654\udcd3\u5a8d\ud140\u2feb\ua5ab"));
            }
            try {
                erz = eqc.parse(byArray);
            }
            catch (RuntimeException runtimeException) {
                throw new erh(a.b("\ud6d9\uaf6a\u25b3\ubbc3\u301a\ub6dc\u08e3\u8508\u1b5d\u91e3\u1648\uec46\u6689\ufb25\u717e\uf39a\u4db2\uc21c\u58d5\udef6\u5704\u2d22\ua392\u384d\uba47\u308c", -1965567233) + runtimeException.getMessage());
            }
            return erz;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] esn(String string) {
        try (InputStream inputStream = ezj.open(a.c(-1900730780, "\u264a") + erw + a.c(-1866488690, "\ua4a0") + string);){
            if (inputStream == null) {
                byte[] byArray2 = null;
                return byArray2;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream.transferTo(byteArrayOutputStream);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    static {
        esa = erp.esd();
    }

    private static /* synthetic */ int kg(int n, int n2) {
        return n + n2 + -947959374;
    }

    private static /* synthetic */ int kh(int n, int n2) {
        return erp.kg(n, n2) + n;
    }
}

