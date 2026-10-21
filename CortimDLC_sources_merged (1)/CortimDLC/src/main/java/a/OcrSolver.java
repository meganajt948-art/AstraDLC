/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.OnnxGraph;
import a.eqw;
import a.erc;
import a.erh;
import a.erk;
import a.AssetPaths;
import flow.dev.StringDecryptor;
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

public final class OcrSolver {
    private static final int erq = 10;
    private static final double err = 0.35;
    private static final int ers = 5;
    private static final int ert = 22;
    private static final int eru = 0xECECE8;
    private static final double erv = Math.log(2.0);
    private static final String erw = new String(new char[]{'f', 'l', 'o', 'w'});
    private static final String erx = new String(new char[]{'c', 'a', 'p', 't', 'c', 'h', 'a', '/', 'd', 'i', 'g', 'i', 't', 's', '.', 'o', 'n', 'n', 'x'});
    private static final Object ery = new Object();
    private static volatile OnnxGraph erz;
    private static final ThreadPoolExecutor esa;
    private static /* synthetic */ int esb;
    private static /* synthetic */ int esc;

    private OcrSolver() {
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
            OnnxGraph eqc2 = OcrSolver.esm();
            eqc2.logits(new float[3 * eqc2.inputH * eqc2.inputW]);
        }
        catch (erh | InterruptedException | RuntimeException exception) {
            // empty catch block
        }
    }

    public static erc solve(BufferedImage bufferedImage) throws erh {
        OnnxGraph eqc2 = OcrSolver.esm();
        try {
            erk erk2 = OcrSolver.read(bufferedImage, eqc2);
            if (!erk2.code().isEmpty() && erk2.strength() >= 0.35) {
                return new erc(erk2.code(), "ok");
            }
            return new erc("", "uncertain");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return new erc("", illegalArgumentException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return new erc("", "interrupted");
        }
        catch (RuntimeException | ExecutionException exception) {
            Exception exception2 = exception instanceof ExecutionException && exception.getCause() != null ? exception.getCause() : exception;
            return new erc("", "OCR error: " + exception2);
        }
    }

    static erk read(BufferedImage bufferedImage, OnnxGraph eqc2) throws InterruptedException, ExecutionException {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        if (n > 4096 || n2 > 4096 || Math.min(n, n2) < 16) {
            throw new IllegalArgumentException("Unsupported image size");
        }
        List<eqw> list = OcrSolver.views(OcrSolver.flatten(bufferedImage));
        ArrayList<Callable<float[][]>> arrayList = new ArrayList<Callable<float[][]>>(list.size());
        for (eqw object2 : list) {
            arrayList.add(() -> OcrSolver.esh(eqc2.logits(OcrSolver.tensor(OcrSolver.resize(object2, eqc2.inputW, eqc2.inputH)))));
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        List list2 = esa.invokeAll(arrayList);
        for (Future future : list2) {
            arrayList2.add((float[][])future.get());
        }
        return OcrSolver.vote(arrayList2);
    }

    static erk vote(List<float[][]> list) {
        String string;
        Object object2;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (Object object2 : list) {
            string = OcrSolver.ese(object2);
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
                double d3 = OcrSolver.esf(fArray, string);
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
                    d2 = OcrSolver.esg(d2, dArray[j - 1]);
                }
                if (j >= 2 && nArray[j] != 10 && nArray[j] != nArray[j - 2]) {
                    d2 = OcrSolver.esg(d2, dArray[j - 2]);
                }
                dArray2[j] = d2 + (double)fArray[i][nArray[j]];
            }
            double[] dArray3 = dArray;
            dArray = dArray2;
            dArray2 = dArray3;
        }
        return OcrSolver.esg(dArray[n - 1], dArray[n - 2]);
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
            nArray[i] = OcrSolver.esi(n3 >> 16 & 0xFF, n5, n6) << 16 | OcrSolver.esi(n3 >> 8 & 0xFF, n5, n6) << 8 | OcrSolver.esi(n3 & 0xFF, n5, n6);
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
            arrayList.add(OcrSolver.esj(eqw2, n2, n, n3 - n2, n4 - n));
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
        arrayList.add(OcrSolver.esj(eqw2, 0, n7, n3, n4 - n7));
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
            eqw3 = OcrSolver.esk(eqw3, n, true);
        }
        if (n2 != eqw3.h()) {
            eqw3 = OcrSolver.esk(eqw3, n2, false);
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
                nArray3[n10] = OcrSolver.esl(n11) << 16 | OcrSolver.esl(n15) << 8 | OcrSolver.esl(n16);
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
    private static OnnxGraph esm() throws erh {
        OnnxGraph eqc2 = erz;
        if (eqc2 != null) {
            return eqc2;
        }
        Object object = ery;
        synchronized (object) {
            if (erz != null) {
                return erz;
            }
            byte[] byArray = OcrSolver.esn(erx);
            if (byArray == null) {
                throw new erh("модель капчи отсутствует в сборке");
            }
            try {
                erz = OnnxGraph.parse(byArray);
            }
            catch (RuntimeException runtimeException) {
                throw new erh("модель капчи не читается: " + runtimeException.getMessage());
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
        try (InputStream inputStream = AssetPaths.open("/" + erw + "/" + string);){
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
        esa = OcrSolver.esd();
    }

    private static /* synthetic */ int kg(int n, int n2) {
        return n + n2 + -947959374;
    }

    private static /* synthetic */ int kh(int n, int n2) {
        return OcrSolver.kg(n, n2) + n;
    }
}

