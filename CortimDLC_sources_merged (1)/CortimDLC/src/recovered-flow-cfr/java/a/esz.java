/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eso;
import a.est;
import flow.dev.a;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class esz {
    private static final int eta = 20;
    private static final int etb = 28;
    private static final int etc = 560;
    private static volatile est[] etd;
    private static /* synthetic */ boolean ete;
    private static /* synthetic */ int etf;

    private esz() {
    }

    public static eso solve(BufferedImage bufferedImage) {
        int n = 512;
        int n2 = Math.max(1, Math.round((float)bufferedImage.getHeight() * (float)n / (float)bufferedImage.getWidth()));
        int[] nArray2 = esz.etg(bufferedImage, n, n2);
        nArray2 = esz.eth(nArray2, n, n2);
        boolean[] blArray = new boolean[n * n2];
        for (int i = 0; i < nArray2.length; ++i) {
            blArray[i] = nArray2[i] < 175;
        }
        blArray = esz.eti(blArray, n, n2, 4);
        int[] nArray3 = new int[n * n2];
        List<int[]> list = esz.etj(blArray, n, n2, nArray3);
        list.removeIf(nArray -> nArray[4] < 2000 || nArray[3] < 80 || nArray[3] > 220 || nArray[2] < 20 || nArray[2] > 150);
        if (list.size() < 3 || list.size() > 8) {
            return new eso("", a.c(-1523318181, "\u067f\u7fc6\uf100\u6b12\ue0b2\u6607\udc5f\u55ab\ucb8b\u4137\uc288\u3ceb\ub245\u2b8b\ua1d9\u2726\u9d6a\u12c1\u887c\u0a41\u87d0\ufdff\u7330\ue8e5\u6e91"));
        }
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        int n5 = Integer.MAX_VALUE;
        int n6 = Integer.MIN_VALUE;
        for (int[] object2 : list) {
            int string = object2[0] + object2[2] / 2;
            int nArray4 = object2[1] + object2[3] / 2;
            if (string < n3) {
                n3 = string;
            }
            if (string > n4) {
                n4 = string;
            }
            if (nArray4 < n5) {
                n5 = nArray4;
            }
            if (nArray4 <= n6) continue;
            n6 = nArray4;
        }
        if (n6 - n5 > n4 - n3) {
            list.sort(Comparator.comparingInt(nArray -> nArray[1] + nArray[3] / 2));
        } else {
            list.sort(Comparator.comparingInt(nArray -> nArray[0] + nArray[2] / 2));
        }
        est[] estArray = esz.etq();
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] nArray4 : list) {
            boolean[] blArray2 = esz.etm(nArray3, n, nArray4);
            float[] fArray = esz.etn(blArray2, nArray4[2], nArray4[3]);
            int n7 = esz.etp(fArray, estArray);
            if (n7 < 0) {
                return new eso("", a.c(-1434848212, "\uf450\u8dfa\u0724\u9953\u1293\u9424\u2e62\ua79b\u39c3"));
            }
            stringBuilder.append(n7);
        }
        String string = stringBuilder.toString();
        return string.matches(a.d("\ubde9\uc433\u4efd\ud098\u5b2b\uddbc\u67a7\uee49\u7002\ufaf6", 79705504, -82278376)) ? new eso(string, a.d("\ub37d\ucac8", -1650428880, 1837614880)) : new eso("", a.c(981521190, "\ud35a\uaaf0\u202e\ube59\u3599\ub32e\u0968\u8091\u1ec9"));
    }

    private static int[] etg(BufferedImage bufferedImage, int n, int n2) {
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 1);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, n, n2);
        graphics2D.drawImage(bufferedImage, 0, 0, n, n2, null);
        graphics2D.dispose();
        int[] nArray = new int[n * n2];
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n3 = bufferedImage2.getRGB(j, i);
                nArray[i * n + j] = ((n3 >> 16 & 0xFF) * 299 + (n3 >> 8 & 0xFF) * 587 + (n3 & 0xFF) * 114) / 1000;
            }
        }
        return nArray;
    }

    private static int[] eth(int[] nArray, int n, int n2) {
        int[] nArray2 = new int[n * n2];
        int[] nArray3 = new int[9];
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n3 = 0;
                for (int k = -1; k <= 1; ++k) {
                    int n4 = Math.min(Math.max(i + k, 0), n2 - 1);
                    for (int i2 = -1; i2 <= 1; ++i2) {
                        nArray3[n3++] = nArray[n4 * n + Math.min(Math.max(j + i2, 0), n - 1)];
                    }
                }
                Arrays.sort(nArray3, 0, 9);
                nArray2[i * n + j] = nArray3[4];
            }
        }
        return nArray2;
    }

    private static boolean[] eti(boolean[] blArray, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9 = n4 * n4;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = -n4; i <= n4; ++i) {
            for (int j = -n4; j <= n4; ++j) {
                if (j * j + i * i > n9) continue;
                arrayList.add(new int[]{j, i});
            }
        }
        int[][] nArray = (int[][])arrayList.toArray(n -> new int[n][]);
        boolean[] blArray2 = new boolean[n2 * n3];
        for (int i = 0; i < n3; ++i) {
            for (n8 = 0; n8 < n2; ++n8) {
                n7 = 1;
                for (int[] nArray2 : nArray) {
                    n6 = n8 + nArray2[0];
                    n5 = i + nArray2[1];
                    if (n6 >= 0 && n6 < n2 && n5 >= 0 && n5 < n3 && blArray[n5 * n2 + n6]) continue;
                    n7 = 0;
                    break;
                }
                blArray2[i * n2 + n8] = n7;
            }
        }
        boolean[] blArray3 = new boolean[n2 * n3];
        for (n8 = 0; n8 < n3; ++n8) {
            block6: for (n7 = 0; n7 < n2; ++n7) {
                for (int[] nArray2 : nArray) {
                    n6 = n7 + nArray2[0];
                    n5 = n8 + nArray2[1];
                    if (n6 < 0 || n6 >= n2 || n5 < 0 || n5 >= n3 || !blArray2[n5 * n2 + n6]) continue;
                    blArray3[n8 * n2 + n7] = true;
                    continue block6;
                }
            }
        }
        return blArray3;
    }

    private static List<int[]> etj(boolean[] blArray, int n, int n3, int[] nArray) {
        int n4;
        int n5;
        int n6;
        int[] nArray2 = new int[n * n3 + 1];
        int n7 = 1;
        for (int i = 0; i < n3; ++i) {
            for (n6 = 0; n6 < n; ++n6) {
                int n8;
                n5 = i * n + n6;
                if (!blArray[n5]) continue;
                n4 = 0;
                for (int[] nArray3 : new int[][]{{n6 - 1, i}, {n6 - 1, i - 1}, {n6, i - 1}, {n6 + 1, i - 1}}) {
                    if (nArray3[0] < 0 || nArray3[0] >= n || nArray3[1] < 0 || nArray3[1] >= n3 || (n8 = nArray[nArray3[1] * n + nArray3[0]]) <= 0) continue;
                    int n9 = esz.etk(nArray2, n8);
                    if (n4 != 0 && n9 >= n4) continue;
                    n4 = n9;
                }
                if (n4 == 0) {
                    nArray[n5] = n7;
                    nArray2[n7] = n7;
                    ++n7;
                    continue;
                }
                nArray[n5] = n4;
                for (int[] nArray3 : new int[][]{{n6 - 1, i}, {n6 - 1, i - 1}, {n6, i - 1}, {n6 + 1, i - 1}}) {
                    if (nArray3[0] < 0 || nArray3[0] >= n || nArray3[1] < 0 || nArray3[1] >= n3 || (n8 = nArray[nArray3[1] * n + nArray3[0]]) <= 0) continue;
                    esz.etl(nArray2, n4, n8);
                }
            }
        }
        HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>();
        for (n6 = 0; n6 < n3; ++n6) {
            for (n5 = 0; n5 < n; ++n5) {
                int n10;
                n4 = n6 * n + n5;
                if (nArray[n4] <= 0) continue;
                nArray[n4] = n10 = esz.etk(nArray2, nArray[n4]);
                int[] nArray4 = hashMap.computeIfAbsent(n10, n2 -> new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, n10});
                if (n5 < nArray4[0]) {
                    nArray4[0] = n5;
                }
                if (n6 < nArray4[1]) {
                    nArray4[1] = n6;
                }
                if (n5 > nArray4[2]) {
                    nArray4[2] = n5;
                }
                if (n6 > nArray4[3]) {
                    nArray4[3] = n6;
                }
                nArray4[4] = nArray4[4] + 1;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int[] nArray5 : hashMap.values()) {
            arrayList.add(new int[]{nArray5[0], nArray5[1], nArray5[2] - nArray5[0] + 1, nArray5[3] - nArray5[1] + 1, nArray5[4], nArray5[5]});
        }
        return arrayList;
    }

    private static int etk(int[] nArray, int n) {
        while (nArray[n] != n) {
            nArray[n] = nArray[nArray[n]];
            n = nArray[n];
        }
        return n;
    }

    private static void etl(int[] nArray, int n, int n2) {
        int n3;
        int n4 = esz.etk(nArray, n);
        if (n4 != (n3 = esz.etk(nArray, n2))) {
            nArray[Math.max((int)n4, (int)n3)] = Math.min(n4, n3);
        }
    }

    private static boolean[] etm(int[] nArray, int n, int[] nArray2) {
        int n2 = nArray2[0];
        int n3 = nArray2[1];
        int n4 = nArray2[2];
        int n5 = nArray2[3];
        int n6 = nArray2[5];
        boolean[] blArray = new boolean[n4 * n5];
        for (int i = 0; i < n5; ++i) {
            for (int j = 0; j < n4; ++j) {
                blArray[i * n4 + j] = nArray[(n3 + i) * n + (n2 + j)] == n6;
            }
        }
        return blArray;
    }

    private static float[] etn(boolean[] blArray, int n, int n2) {
        float f = Math.min(20.0f / (float)n, 28.0f / (float)n2);
        int n3 = Math.max(1, Math.round((float)n * f));
        int n4 = Math.max(1, Math.round((float)n2 * f));
        int n5 = (20 - n3) / 2;
        int n6 = (28 - n4) / 2;
        float[] fArray = new float[560];
        for (int i = 0; i < n4; ++i) {
            int n7 = n2 * i / n4;
            int n8 = Math.max(n7 + 1, n2 * (i + 1) / n4);
            for (int j = 0; j < n3; ++j) {
                int n9 = n * j / n3;
                int n10 = Math.max(n9 + 1, n * (j + 1) / n3);
                int n11 = 0;
                int n12 = 0;
                for (int k = n7; k < n8; ++k) {
                    for (int i2 = n9; i2 < n10; ++i2) {
                        ++n12;
                        if (!blArray[k * n + i2]) continue;
                        ++n11;
                    }
                }
                fArray[(n6 + i) * 20 + (n5 + j)] = n12 > 0 ? (float)n11 / (float)n12 : 0.0f;
            }
        }
        return fArray;
    }

    private static float eto(float[] fArray) {
        float f = 0.0f;
        for (float f2 : fArray) {
            f += f2 * f2;
        }
        return (float)Math.sqrt(f);
    }

    private static int etp(float[] fArray, est[] estArray) {
        float f;
        float f2 = esz.eto(fArray);
        if (f2 < 1.0E-4f) {
            return -1;
        }
        float[] fArray2 = new float[10];
        Arrays.fill(fArray2, -1.0f);
        for (est est2 : estArray) {
            f = 0.0f;
            float[] fArray3 = est2.esv;
            for (int i = 0; i < 560; ++i) {
                f += fArray[i] * fArray3[i];
            }
            float f3 = f / (f2 * est2.esw);
            if (!(f3 > fArray2[est2.esu])) continue;
            fArray2[est2.esu] = f3;
        }
        int n = -1;
        float f4 = -1.0f;
        float f5 = -1.0f;
        for (int i = 0; i < 10; ++i) {
            f = fArray2[i];
            if (f > f4) {
                f5 = f4;
                f4 = f;
                n = i;
                continue;
            }
            if (!(f > f5)) continue;
            f5 = f;
        }
        if (f4 < 0.55f || f4 - f5 < 0.04f) {
            return -1;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static est[] etq() {
        est[] estArray = etd;
        if (estArray != null) {
            return estArray;
        }
        Class<esz> clazz = esz.class;
        synchronized (esz.class) {
            if (etd != null) {
                // ** MonitorExit[var1_1] (shouldn't be in output)
                return etd;
            }
            etd = esz.etr();
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return etd;
        }
    }

    private static est[] etr() {
        String[] stringArray = new String[]{a.b("\u9282\ueb00\u61c8\uffb1\u746b", 409244358), a.b("\ub823\uc1a1\u4b65\ud502\u5ed0\ud86e\u6232", 90093682), a.b("\u49f2\u3076\ubaac\u24da\uaf0f\u29b2", 97405344), a.d("\u09ae\u7029\ufaf8\u6481\uef5c\u69a8\ud38e\u5a63", 1199774138, 1290997839), a.c(-1217903313, "\u456b\u3cf8\ub626\u2852\ua38e\u252f\u9f67"), a.c(875692957, "\u03d2\u7a42\uf09e\u6ee4\ue504\u6396\ud990\u5012\uce7f\u44c1\uc30f")};
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
        ArrayList<Font> arrayList = new ArrayList<Font>();
        String[] objectArray = stringArray;
        int arrayList2 = objectArray.length;
        for (int i = 0; i < arrayList2; ++i) {
            String string = objectArray[i];
            if (!hashSet.contains(string)) continue;
            arrayList.add(new Font(string, 1, 96));
        }
        arrayList.add(new Font(a.b("\ubc9c\uc51f\u4fc3\ud1af\u5a58\udcdf\u669b\uef71\u7121", -901661498), 1, 96));
        arrayList.add(new Font(a.b("\ue375\u9ae9\u1032\u8e4e\u059a\u8323", -401022153), 1, 96));
        arrayList.add(new Font(a.b("\uaf1a\ud689\u5c5b\uc22b\u49e0\ucf52\u7510\ufce3\u62ba\ue80a", -810242211), 1, 96));
        double[] dArray = new double[17];
        for (arrayList2 = 0; arrayList2 < dArray.length; ++arrayList2) {
            dArray[arrayList2] = Math.toRadians(-80 + arrayList2 * 10);
        }
        ArrayList<est> arrayList3 = new ArrayList<est>(arrayList.size() * 10 * dArray.length);
        for (Font font : arrayList) {
            for (int i = 0; i < 10; ++i) {
                for (double d : dArray) {
                    float f;
                    float[] fArray = esz.ets(i, font, d);
                    if (fArray == null || !((f = esz.eto(fArray)) > 0.01f)) continue;
                    arrayList3.add(new est((byte)i, fArray, f));
                }
            }
        }
        return arrayList3.toArray(new est[0]);
    }

    private static float[] ets(int n, Font font, double d) {
        int n2;
        int n3;
        int n4 = 320;
        BufferedImage bufferedImage = new BufferedImage(n4, n4, 10);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, n4, n4);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(font);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        String string = String.valueOf(n);
        int n5 = fontMetrics.stringWidth(string);
        AffineTransform affineTransform = AffineTransform.getRotateInstance(d, (double)n4 / 2.0, (double)n4 / 2.0);
        graphics2D.setTransform(affineTransform);
        int n6 = n4 / 2 + (fontMetrics.getAscent() - fontMetrics.getDescent()) / 2;
        graphics2D.drawString(string, (n4 - n5) / 2, n6);
        graphics2D.dispose();
        byte[] byArray = ((DataBufferByte)bufferedImage.getRaster().getDataBuffer()).getData();
        int n7 = n4;
        int n8 = -1;
        int n9 = n4;
        int n10 = -1;
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = n3 * n4;
            for (int i = 0; i < n4; ++i) {
                if ((byArray[n2 + i] & 0xFF) >= 128) continue;
                if (i < n7) {
                    n7 = i;
                }
                if (i > n8) {
                    n8 = i;
                }
                if (n3 < n9) {
                    n9 = n3;
                }
                if (n3 <= n10) continue;
                n10 = n3;
            }
        }
        if (n8 < 0) {
            return null;
        }
        n3 = n8 - n7 + 1;
        n2 = n10 - n9 + 1;
        boolean[] blArray = new boolean[n3 * n2];
        for (int i = 0; i < n2; ++i) {
            int n11 = (n9 + i) * n4 + n7;
            for (int j = 0; j < n3; ++j) {
                blArray[i * n3 + j] = (byArray[n11 + j] & 0xFF) < 128;
            }
        }
        return esz.etn(blArray, n3, n2);
    }

    private static /* synthetic */ int kr(int n, int n2) {
        return n * n2 ^ 0xB2E4D097;
    }

    private static /* synthetic */ int ks(int n, int n2) {
        return n * n2 ^ 0x95C62171;
    }

    private static /* synthetic */ int kt(int n, int n2) {
        return esz.ks(n, n2) + n;
    }
}

