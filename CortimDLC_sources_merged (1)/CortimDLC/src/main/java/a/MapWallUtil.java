/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1533
 *  net.minecraft.class_1799
 *  net.minecraft.class_1806
 *  net.minecraft.class_1937
 *  net.minecraft.class_22
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_243
 *  net.minecraft.class_3620
 */
package a;

import flow.dev.StringDecryptor;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.class_1297;
import net.minecraft.class_1533;
import net.minecraft.class_1799;
import net.minecraft.class_1806;
import net.minecraft.class_1937;
import net.minecraft.class_22;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_3620;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class MapWallUtil {
    private static final int enr = 128;
    private static final int ens = 16;
    private static final int ent = 4;
    public static final double SHUFFLED_SEAMS = 2.0;
    private static /* synthetic */ int enu;
    private static /* synthetic */ int env;

    private MapWallUtil() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static BufferedImage capture(class_1533 class_15333) {
        Object object;
        class_1937 class_19372 = class_15333.method_73183();
        class_2350 class_23502 = class_15333.method_5735();
        if (class_23502.method_10166() == class_2350.class_2351.field_11052 || !(class_15333.method_6940().method_7909() instanceof class_1806)) {
            return null;
        }
        boolean bl = class_23502.method_10166() == class_2350.class_2351.field_11051;
        boolean bl2 = class_23502 == class_2350.field_11043 || class_23502 == class_2350.field_11034;
        int n = MapWallUtil.eob(class_15333.method_59940(), bl);
        List list = class_19372.method_8390(class_1533.class, class_15333.method_5829().method_1014(16.0), class_15332 -> class_15332.method_5735() == class_23502 && MapWallUtil.eob(class_15332.method_59940(), bl) == n && class_15332.method_6940().method_7909() instanceof class_1806);
        List<class_1533> list2 = MapWallUtil.eoa(list, class_15333);
        if (list2.isEmpty()) {
            return null;
        }
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        HashSet<class_2338> hashSet = new HashSet<class_2338>();
        for (class_1533 class_15334 : list2) {
            object = class_15334.method_59940();
            if (!hashSet.add((class_2338)object)) {
                return null;
            }
            int n6 = bl ? object.method_10263() : object.method_10260();
            n2 = Math.min(n2, n6);
            n3 = Math.max(n3, n6);
            n4 = Math.min(n4, object.method_10264());
            n5 = Math.max(n5, object.method_10264());
        }
        int n7 = n3 - n2 + 1;
        int n8 = n5 - n4 + 1;
        if (n7 > 16 || n8 > 16 || list2.size() < 2 || list2.size() * 2 < n7 * n8) {
            return null;
        }
        object = new BufferedImage(n7 * 128, n8 * 128, 2);
        Graphics2D graphics2D = ((BufferedImage)object).createGraphics();
        try {
            for (class_1533 class_15335 : list2) {
                int n9;
                BufferedImage bufferedImage;
                class_22 class_222 = class_1806.method_8001((class_1799)class_15335.method_6940(), (class_1937)class_19372);
                if (class_222 == null || class_222.field_122 == null || class_222.field_122.length != 16384) {
                    bufferedImage = null;
                    return bufferedImage;
                }
                bufferedImage = new BufferedImage(128, 128, 2);
                boolean bl3 = false;
                for (int i = 0; i < class_222.field_122.length; ++i) {
                    n9 = class_222.field_122[i] & 0xFF;
                    bl3 |= n9 >= 4;
                    bufferedImage.setRGB(i % 128, i / 128, n9 < 4 ? 0 : class_3620.method_38480((int)n9));
                }
                if (!bl3) {
                    BufferedImage bufferedImage2 = null;
                    return bufferedImage2;
                }
                class_2338 class_23382 = class_15335.method_59940();
                n9 = bl ? class_23382.method_10263() : class_23382.method_10260();
                int n10 = (bl2 ? n3 - n9 : n9 - n2) * 128;
                int n11 = (n5 - class_23382.method_10264()) * 128;
                AffineTransform affineTransform = AffineTransform.getTranslateInstance(n10, n11);
                affineTransform.rotate((double)(class_15335.method_6934() & 3) * Math.PI / 2.0, 64.0, 64.0);
                graphics2D.drawImage(bufferedImage, affineTransform, null);
            }
        }
        finally {
            graphics2D.dispose();
        }
        return object;
    }

    public static BufferedImage captureNearest(class_1937 class_19372, class_1297 class_12972) {
        for (List<class_1533> list : MapWallUtil.findWalls(class_19372, class_12972, 24.0)) {
            BufferedImage bufferedImage = MapWallUtil.capture(list.stream().min(Comparator.comparingDouble(class_15332 -> class_15332.method_5858(class_12972))).orElseThrow());
            if (bufferedImage == null || MapWallUtil.isShuffled(bufferedImage)) continue;
            return bufferedImage;
        }
        return null;
    }

    public static List<List<class_1533>> findWalls(class_1937 class_19372, class_1297 class_12972, double d) {
        class_243 class_2432 = class_12972.method_33571();
        List list2 = class_19372.method_8390(class_1533.class, class_12972.method_5829().method_1014(d), class_15332 -> class_15332.method_5735().method_10166() != class_2350.class_2351.field_11052 && class_15332.method_6940().method_7909() instanceof class_1806 && MapWallUtil.enx(class_15332, class_2432));
        class_243 class_2433 = class_12972.method_5828(1.0f);
        List<List<class_1533>> list3 = MapWallUtil.enz(list2);
        list3.removeIf(list -> list.size() < 2);
        list3.sort(Comparator.comparingInt(list -> list.size() >= 4 ? 0 : 1).thenComparingDouble(list -> MapWallUtil.eny(list, class_2432, class_2433)));
        return list3;
    }

    public static double seamRatio(int[] nArray, int n, int n2) {
        double d = 0.0;
        double d2 = 0.0;
        long l = 0L;
        long l2 = 0L;
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                double d3;
                int n3 = nArray[i * n + j];
                if (n3 >>> 24 == 0) continue;
                if (j + 1 < n && nArray[i * n + j + 1] >>> 24 != 0) {
                    d3 = MapWallUtil.enw(n3, nArray[i * n + j + 1]);
                    if ((j + 1) % 128 == 0) {
                        d += d3;
                        ++l;
                    } else {
                        d2 += d3;
                        ++l2;
                    }
                }
                if (i + 1 >= n2 || nArray[(i + 1) * n + j] >>> 24 == 0) continue;
                d3 = MapWallUtil.enw(n3, nArray[(i + 1) * n + j]);
                if ((i + 1) % 128 == 0) {
                    d += d3;
                    ++l;
                    continue;
                }
                d2 += d3;
                ++l2;
            }
        }
        if (l == 0L || l2 == 0L || d2 <= 0.0) {
            return 0.0;
        }
        return d / (double)l / (d2 / (double)l2);
    }

    public static boolean isShuffled(BufferedImage bufferedImage) {
        int n;
        int n2 = bufferedImage.getWidth();
        return MapWallUtil.seamRatio(bufferedImage.getRGB(0, 0, n2, n = bufferedImage.getHeight(), null, 0, n2), n2, n) > 2.0;
    }

    private static double enw(int n, int n2) {
        return (double)(Math.abs((n >> 16 & 0xFF) - (n2 >> 16 & 0xFF)) + Math.abs((n >> 8 & 0xFF) - (n2 >> 8 & 0xFF)) + Math.abs((n & 0xFF) - (n2 & 0xFF))) / 3.0;
    }

    private static boolean enx(class_1533 class_15332, class_243 class_2432) {
        class_2350 class_23502 = class_15332.method_5735();
        class_243 class_2433 = class_2432.method_1020(class_15332.method_73189());
        return class_2433.field_1352 * (double)class_23502.method_10148() + class_2433.field_1350 * (double)class_23502.method_10165() > 0.25;
    }

    private static double eny(List<class_1533> list, class_243 class_2432, class_243 class_2433) {
        double d = Double.MAX_VALUE;
        class_243 class_2434 = class_243.field_1353;
        for (class_1533 class_15332 : list) {
            d = Math.min(d, class_15332.method_73189().method_1022(class_2432));
            class_2434 = class_2434.method_1019(class_15332.method_73189());
        }
        class_243 class_2435 = class_2434.method_1021(1.0 / (double)list.size()).method_1020(class_2432).method_1029();
        return d * (1.5 - 0.5 * class_2435.method_1026(class_2433));
    }

    private static List<List<class_1533>> enz(List<class_1533> list) {
        HashMap<Long, List> hashMap = new HashMap<Long, List>();
        for (class_1533 object : list) {
            boolean list2 = object.method_5735().method_10166() == class_2350.class_2351.field_11051;
            long arrayList2 = (long)object.method_5735().ordinal() << 32 | (long)MapWallUtil.eob(object.method_59940(), list2) & 0xFFFFFFFFL;
            hashMap.computeIfAbsent(arrayList2, l -> new ArrayList()).add(object);
        }
        ArrayList arrayList = new ArrayList();
        for (List list2 : hashMap.values()) {
            ArrayList<class_1533> arrayList2 = new ArrayList<class_1533>(list2);
            while (!arrayList2.isEmpty()) {
                List<class_1533> list3 = MapWallUtil.eoa(arrayList2, (class_1533)arrayList2.get(0));
                arrayList2.removeAll(list3);
                arrayList.add(list3);
            }
        }
        return arrayList;
    }

    private static List<class_1533> eoa(List<class_1533> list, class_1533 class_15332) {
        boolean bl = class_15332.method_5735().method_10166() == class_2350.class_2351.field_11051;
        ArrayList<class_1533> arrayList = new ArrayList<class_1533>();
        HashSet<class_1533> hashSet = new HashSet<class_1533>();
        ArrayDeque<class_1533> arrayDeque = new ArrayDeque<class_1533>();
        arrayDeque.add(class_15332);
        hashSet.add(class_15332);
        while (!arrayDeque.isEmpty()) {
            class_1533 class_15333 = (class_1533)arrayDeque.poll();
            arrayList.add(class_15333);
            class_2338 class_23382 = class_15333.method_59940();
            int n = bl ? class_23382.method_10263() : class_23382.method_10260();
            for (class_1533 class_15334 : list) {
                if (hashSet.contains(class_15334)) continue;
                class_2338 class_23383 = class_15334.method_59940();
                int n2 = Math.abs((bl ? class_23383.method_10263() : class_23383.method_10260()) - n);
                if (n2 > 1 || Math.abs(class_23383.method_10264() - class_23382.method_10264()) > 1) continue;
                hashSet.add(class_15334);
                arrayDeque.add(class_15334);
            }
        }
        return arrayList;
    }

    public static byte[] encodePng(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!ImageIO.write((RenderedImage)bufferedImage, "png", byteArrayOutputStream)) {
            throw new IOException("PNG encoder unavailable");
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int eob(class_2338 class_23382, boolean bl) {
        return bl ? class_23382.method_10260() : class_23382.method_10263();
    }

    private static /* synthetic */ int if(int n, int n2) {
        return n + n2 + 959484858;
    }

    private static /* synthetic */ int ig(int n, int n2) {
        return MapWallUtil.if(n, n2) + n;
    }

    private static /* synthetic */ int ih(int n, int n2) {
        return MapWallUtil.if(n, n2) * n2;
    }
}

