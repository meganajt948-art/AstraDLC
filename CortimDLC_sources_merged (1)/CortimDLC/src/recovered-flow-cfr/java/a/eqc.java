/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.eof;
import a.eou;
import a.eoz;
import a.epj;
import a.epm;
import a.eps;
import a.epz;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class eqc {
    final int inputH;
    final int inputW;
    final int classes;
    private final List<Object> eqd = new ArrayList<Object>();
    private final List<eoz> eqe = new ArrayList<eoz>();
    private float[] eqf;
    private float[] eqg;
    private int eqh;
    private static final Object eqi = new Object();
    private static /* synthetic */ String eqj;
    private static /* synthetic */ boolean eqk;

    private eqc(int n, int n2, int n3) {
        this.inputH = n;
        this.inputW = n2;
        this.classes = n3;
    }

    float[][] logits(float[] fArray) throws InterruptedException {
        int n;
        Object object;
        float[] fArray2 = fArray;
        int n2 = 3;
        int n3 = this.inputH;
        int n4 = this.inputW;
        for (Object object2 : this.eqd) {
            int n5;
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
            if (object2 == eqi) {
                for (n5 = 0; n5 < fArray2.length; ++n5) {
                    if (!(fArray2[n5] < 0.0f)) continue;
                    fArray2[n5] = 0.0f;
                }
                continue;
            }
            if (object2 instanceof eof) {
                eof eof2 = (eof)object2;
                fArray2 = eqc.eql(fArray2, n3, n4, eof2);
                n2 = eof2.eoi;
                n3 = eof2.eoq;
                n4 = eof2.eor;
                continue;
            }
            if (!(object2 instanceof eps)) continue;
            object = (eps)object2;
            n5 = (n3 - ((eps)object).ept) / ((eps)object).epv + 1;
            n = (n4 - ((eps)object).epu) / ((eps)object).epw + 1;
            fArray2 = eqc.eqo(fArray2, n2, n3, n4, (eps)object, n5, n);
            n3 = n5;
            n4 = n;
        }
        Object object3 = new float[n4][n2];
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n4; ++j) {
                object3[j][i] = fArray2[i * n4 + j];
            }
        }
        for (eoz eoz2 : this.eqe) {
            object3 = eqc.eqp((float[][])object3, eoz2);
        }
        Object object4 = new float[((Object)object3).length][this.classes];
        for (int i = 0; i < ((Object)object3).length; ++i) {
            object = object3[i];
            Object object5 = object4[i];
            for (n = 0; n < this.classes; ++n) {
                object5[n] = this.eqg[n];
            }
            for (n = 0; n < this.eqh; ++n) {
                Object object6 = object[n];
                int n6 = n * this.classes;
                for (int j = 0; j < this.classes; ++j) {
                    Object object7 = object5;
                    int n7 = j;
                    object7[n7] = object7[n7] + object6 * this.eqf[n6 + j];
                }
            }
        }
        return object4;
    }

    private static float[] eql(float[] fArray, int n, int n2, eof eof2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9 = eof2.eoq;
        int n10 = eof2.eor;
        int n11 = eof2.eol;
        int n12 = (n9 - 1) * eof2.eoo + eof2.eok;
        float[] fArray2 = new float[n10];
        float[][] fArrayArray = new float[eof2.eoj * n12 * n11][];
        for (n8 = 0; n8 < eof2.eoj; ++n8) {
            for (int i = 0; i < n12; ++i) {
                int n13 = i - eof2.eom;
                for (n7 = 0; n7 < n11; ++n7) {
                    float[] fArray3 = fArray2;
                    if (n13 >= 0 && n13 < n) {
                        fArray3 = new float[n10];
                        n6 = n8 * n * n2 + n13 * n2;
                        n5 = n7 - eof2.eon;
                        if (eof2.eop == 1) {
                            n4 = Math.max(0, -n5);
                            if (n4 < (n3 = Math.min(n10, n2 - n5))) {
                                System.arraycopy(fArray, n6 + n4 + n5, fArray3, n4, n3 - n4);
                            }
                        } else {
                            for (n4 = 0; n4 < n10; ++n4) {
                                n3 = n4 * eof2.eop + n5;
                                if (n3 < 0 || n3 >= n2) continue;
                                fArray3[n4] = fArray[n6 + n3];
                            }
                        }
                    }
                    fArrayArray[(n8 * n12 + i) * n11 + n7] = fArray3;
                }
            }
        }
        n8 = eof2.eok * n11;
        float[] fArray4 = new float[eof2.eoi * n9 * n10];
        float[] fArray5 = new float[n10];
        for (n7 = 0; n7 < eof2.eoi; ++n7) {
            float f = eof2.eoh[n7];
            for (n6 = 0; n6 < n9; ++n6) {
                Arrays.fill(fArray5, f);
                for (n5 = 0; n5 < eof2.eoj; ++n5) {
                    n4 = (n7 * eof2.eoj + n5) * n8;
                    for (n3 = 0; n3 < eof2.eok; ++n3) {
                        int n14 = (n5 * n12 + n6 * eof2.eoo + n3) * n11;
                        int n15 = n4 + n3 * n11;
                        if (n11 == 3) {
                            eqc.eqm(fArray5, fArrayArray[n14], fArrayArray[n14 + 1], fArrayArray[n14 + 2], eof2.eog[n15], eof2.eog[n15 + 1], eof2.eog[n15 + 2], n10);
                            continue;
                        }
                        for (int i = 0; i < n11; ++i) {
                            eqc.eqn(fArray5, fArrayArray[n14 + i], eof2.eog[n15 + i], n10);
                        }
                    }
                }
                System.arraycopy(fArray5, 0, fArray4, (n7 * n9 + n6) * n10, n10);
            }
        }
        return fArray4;
    }

    private static void eqm(float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float f, float f2, float f3, int n) {
        for (int i = 0; i < n; ++i) {
            int n2 = i;
            fArray[n2] = fArray[n2] + (f * fArray2[i] + f2 * fArray3[i] + f3 * fArray4[i]);
        }
    }

    private static void eqn(float[] fArray, float[] fArray2, float f, int n) {
        for (int i = 0; i < n; ++i) {
            int n2 = i;
            fArray[n2] = fArray[n2] + f * fArray2[i];
        }
    }

    private static float[] eqo(float[] fArray, int n, int n2, int n3, eps eps2, int n4, int n5) {
        float[] fArray2 = new float[n * n4 * n5];
        for (int i = 0; i < n; ++i) {
            int n6 = i * n2 * n3;
            int n7 = i * n4 * n5;
            for (int j = 0; j < n4; ++j) {
                for (int k = 0; k < n5; ++k) {
                    float f = Float.NEGATIVE_INFINITY;
                    for (int i2 = 0; i2 < eps2.ept; ++i2) {
                        int n8 = n6 + (j * eps2.epv + i2) * n3 + k * eps2.epw;
                        for (int i3 = 0; i3 < eps2.epu; ++i3) {
                            float f2 = fArray[n8 + i3];
                            if (!(f2 > f)) continue;
                            f = f2;
                        }
                    }
                    fArray2[n7 + j * n5 + k] = f;
                }
            }
        }
        return fArray2;
    }

    private static float[][] eqp(float[][] fArray, eoz eoz2) {
        int n = fArray.length;
        int n2 = eoz2.epd;
        int n3 = 4 * n2;
        float[][] fArray2 = new float[n][eoz2.epf * n2];
        float[] fArray3 = new float[n3];
        float[] fArray4 = new float[n3];
        for (int i = 0; i < eoz2.epf; ++i) {
            boolean bl = eoz2.epg || i == 1;
            int n4 = i * 2 * n3;
            for (int j = 0; j < n3; ++j) {
                fArray4[j] = eoz2.epc[n4 + j] + eoz2.epc[n4 + n3 + j];
            }
            float[] fArray5 = new float[n2];
            float[] fArray6 = new float[n2];
            for (int j = 0; j < n; ++j) {
                int n5;
                int n6 = bl ? n - 1 - j : j;
                float[] fArray7 = fArray[n6];
                System.arraycopy(fArray4, 0, fArray3, 0, n3);
                for (n5 = 0; n5 < eoz2.epe; ++n5) {
                    eqc.eqn(fArray3, eoz2.epa[i * eoz2.epe + n5], fArray7[n5], n3);
                }
                for (n5 = 0; n5 < n2; ++n5) {
                    eqc.eqn(fArray3, eoz2.epb[i * n2 + n5], fArray5[n5], n3);
                }
                float[] fArray8 = fArray2[n6];
                for (int k = 0; k < n2; ++k) {
                    float f = eqc.eqq(fArray3[k]);
                    float f2 = eqc.eqq(fArray3[n2 + k]);
                    float f3 = eqc.eqq(fArray3[2 * n2 + k]);
                    float f4 = (float)Math.tanh(fArray3[3 * n2 + k]);
                    fArray6[k] = f3 * fArray6[k] + f * f4;
                    fArray5[k] = f2 * (float)Math.tanh(fArray6[k]);
                    fArray8[i * n2 + k] = fArray5[k];
                }
            }
        }
        return fArray2;
    }

    private static float eqq(float f) {
        return (float)(1.0 / (1.0 + Math.exp(-f)));
    }

    static eqc parse(byte[] byArray) {
        epm epm2 = new epm(byArray, 0, byArray.length);
        epm epm3 = null;
        while (epm2.more()) {
            int n = epm2.tag();
            if (n >>> 3 == 7 && (n & 7) == 2) {
                epm3 = epm2.sub();
                continue;
            }
            epm2.skip(n & 7);
        }
        if (epm3 == null) {
            throw new IllegalArgumentException(a.c(-1373751528, "\u377e\u4ece\uc452\u5a64\ud1a6\u5704\ued46\u64af"));
        }
        ArrayList<epj> arrayList = new ArrayList<epj>();
        HashMap<String, epz> hashMap = new HashMap<String, epz>();
        ArrayList<epm> arrayList2 = new ArrayList<epm>();
        while (epm3.more()) {
            int n = epm3.tag();
            int n2 = n >>> 3;
            if (n2 == 1 && (n & 7) == 2) {
                arrayList.add(epj.read(epm3.sub()));
                continue;
            }
            if (n2 == 5 && (n & 7) == 2) {
                epz object = epz.read(epm3.sub());
                hashMap.put(object.name, object);
                continue;
            }
            if (n2 == 11 && (n & 7) == 2) {
                arrayList2.add(epm3.sub());
                continue;
            }
            epm3.skip(n & 7);
        }
        long[] lArray = null;
        for (epm epm4 : arrayList2) {
            eou eou2 = eou.read(epm4);
            if (hashMap.containsKey(eou2.eov)) continue;
            lArray = eou2.eow;
            break;
        }
        if (lArray == null || lArray.length != 4 || lArray[1] != 3L || lArray[2] <= 0L || lArray[3] <= 0L) {
            throw new IllegalArgumentException(a.d("\u2c4d\u55fb\udf36\u4142\uca94\u4c71\uf671\u7f9b\ue1cd\u6b6d\uecab", -200490044, 1818292203));
        }
        return eqc.eqr(arrayList, hashMap, (int)lArray[2], (int)lArray[3]);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private static eqc eqr(List<epj> var0, Map<String, epz> var1_1, int var2_2, int var3_3) {
        var4_4 = new ArrayList<Object>();
        var5_5 = new ArrayList<eoz>();
        var6_6 = null;
        var7_7 = null;
        var8_8 = 0;
        var9_9 = 3;
        var10_10 = var2_2;
        var11_11 = var3_3;
        var12_12 = -1;
        var13_13 = var0.iterator();
        block34: while (true) {
            block57: {
                if (var13_13.hasNext()) {
                    var14_14 = var13_13.next();
                    var15_15 = var14_14.op;
                    var16_16 = -1;
                    switch (var15_15.hashCode()) {
                        case 2106196: {
                            if (!var15_15.equals(a.c(2077393181, "\u815a\uf8c7\u7215\uec7c"))) break;
                            var16_16 = 0;
                            break;
                        }
                        case -768792413: {
                            if (!var15_15.equals(a.b("\u42bd\u3b2f\ub1e9\u2f8f\ua453\u22c4\u98b6\u115a\u8f1a\u05a7\u8279\u780d\uf6c9\u6f63\ue525\u63c9\ud980\u5650", -1652014355))) break;
                            var16_16 = 1;
                            break;
                        }
                        case 2543388: {
                            if (!var15_15.equals(a.c(679795488, "\udb76\ua2f0\u282a\ub642"))) break;
                            var16_16 = 2;
                            break;
                        }
                        case -1786316928: {
                            if (!var15_15.equals(a.c(2073383087, "\u50e5\u2978\ua3b2\u3deb\ub603\u30b2\u8ae2"))) break;
                            var16_16 = 3;
                            break;
                        }
                        case 2346560: {
                            if (!var15_15.equals(a.b("\u7cd7\u0579\u8fad\u11c5", 62880927))) break;
                            var16_16 = 4;
                            break;
                        }
                        case -1997407644: {
                            if (!var15_15.equals(a.b("\u3ebc\u4721\ucde7\u53af\ud840\u5ee8", 1371487991))) break;
                            var16_16 = 5;
                            break;
                        }
                        case 2215710: {
                            if (!var15_15.equals(a.d("\uf473\u8de0\u073b\u994a", 253881502, -645982034))) break;
                            var16_16 = 6;
                            break;
                        }
                        case 65665: {
                            if (!var15_15.equals(a.b("\u6d4a\u14de\u9e0d", 1291611400))) break;
                            var16_16 = 7;
                            break;
                        }
                        case -503167036: {
                            if (!var15_15.equals(a.d("\u8dd3\uf44e\u7e9c\ue0f0\u6b20\ued84\u57d8\ude33", 654278586, 771289634))) break;
                            var16_16 = 8;
                            break;
                        }
                        case -300349950: {
                            if (!var15_15.equals(a.b("\u637a\u1ae9\u903e\u0e5f\u8588\u0326\ub96a", 163930926))) break;
                            var16_16 = 9;
                            break;
                        }
                        case 1750765897: {
                            if (!var15_15.equals(a.d("\uecd7\u955d\u1f93\u81e0\u0a33\u8c92\u36c1\ubf2f\u216f", -1618512148, 1031314023))) break;
                            var16_16 = 10;
                            break;
                        }
                        case -1238034663: {
                            if (!var15_15.equals(a.b("\uc880\ub117\u3bd7\ua5a9\u2e63\ua8d1\u129d\u9b70\u0539", 742508765))) break;
                            var16_16 = 11;
                            break;
                        }
                        case -1533165266: {
                            if (!var15_15.equals(a.b("\u9031\ue9b7\u6372\ufd18\u76c6\uf066\u4a20", -1240952732))) break;
                            var16_16 = 12;
                            break;
                        }
                        case 79847297: {
                            if (!var15_15.equals(a.b("\ub15b\uc8d1\u420b\udc6b\u57a9", 2073604365))) break;
                            var16_16 = 13;
                            break;
                        }
                        case 2125810203: {
                            if (!var15_15.equals(a.c(522763692, "\ubded\uc47a\u4ebc\ud0d1\u5b0b\uddad"))) break;
                            var16_16 = 14;
                            break;
                        }
                        case 2024039220: {
                            if (!var15_15.equals(a.d("\u9988\ue015\u6ac7\uf4bb\u7f6e\uf9ca", 1364202793, -2088923932))) break;
                            var16_16 = 15;
                            break;
                        }
                        case 963849126: {
                            if (!var15_15.equals(a.b("\uf3ac\u8a31\u00e3\u9e8f\u155f\u93fb\u29a7\ua04c\u3e28\ub4b0\u3356\uc91c\u47c2\ude62\u5424", -1621363744))) break;
                            var16_16 = 16;
                            break;
                        }
                        case 79973746: {
                            if (!var15_15.equals(a.b("\ufb79\u82f7\u0821\u965a\u1d8b", 588643119))) break;
                            var16_16 = 17;
                            break;
                        }
                        case -71117602: {
                            if (!var15_15.equals(a.c(-791360599, "\ucbe8\ub274\u38a6\ua6dc\u2d11\uabbd\u11f3\u980f"))) break;
                            var16_16 = 18;
                            break;
                        }
                        case 2092895: {
                            if (!var15_15.equals(a.d("\uca2c\ub3bf\u397e\ua708", -944125810, 769589989))) break;
                            var16_16 = 19;
                            break;
                        }
                        case -704578081: {
                            if (!var15_15.equals(a.d("\u14c8\u6d4f\ue781\u79ef\uf227\u748c\ucede", -1281877129, 41422844))) break;
                            var16_16 = 20;
                            break;
                        }
                        case -2064276170: {
                            if (!var15_15.equals(a.b("\ua12f\ud8bd\u5266\ucc23\u47c8\uc170\u7b31\uf2d9\u6c8a\ue622", 2083168617))) break;
                            var16_16 = 21;
                            break;
                        }
                    }
                    switch (var16_16) {
                        case 0: {
                            if (var12_12 >= 0 || var6_6 != null) {
                                throw new IllegalArgumentException(a.b("\u1580\u6c3d\ue6ef\u7886\uf307\u75f7\ucfa3\u4640\ud80e\u52a8\ud529\u2f1b\ua1c1\u3870", -853928467));
                            }
                            var17_17 = eqc.eqv(var1_1, var14_14, 1);
                            if (var17_17.dims.length != 4 || var17_17.dims[1] != (long)var9_9) {
                                throw new IllegalArgumentException(a.b("\u8e74\uf7c9\u7d1b\ue372\u68f3\uee15\u5454\udda9\u43f8\uc946\u4e89", -123302372));
                            }
                            var18_18 = (int)var17_17.dims[0];
                            var19_24 = (int)var17_17.dims[2];
                            var20_28 = (int)var17_17.dims[3];
                            var21_32 /* !! */  = var14_14.inputs.size() > 2 && var14_14.inputs.get(2).isEmpty() == false ? eqc.eqv(var1_1, (epj)var14_14, (int)2).data : new float[var18_18];
                            var22_33 /* !! */  = var14_14.ints(a.b("\uccf3\ub553\u3f85\ua1e3", 1330564231), new long[]{0L, 0L, 0L, 0L});
                            var23_35 = var14_14.ints(a.b("\u857d\ufccb\u761e\ue874\u63ae\ue51e\u5f5b", 429294857), new long[]{1L, 1L});
                            var24_37 = var14_14.ints(a.c(-1521960616, "\ub935\uc089\u4a5f\ud423\u5fe1\ud94d\u6318\ueae8\u74aa"), new long[]{1L, 1L});
                            if (var21_32 /* !! */ .length != var18_18 || var22_33 /* !! */ .length != 4 || var23_35.length != 2 || var24_37[0] != 1L || var24_37[1] != 1L || var14_14.integer(a.c(238640072, "\u5baa\u220e\ua8c0\u36ab\ubd79"), 1L) != 1L || !var14_14.string(a.d("\ucfb9\ub61c\u3cce\ua2a4\u2943\uafdd\u159f\u9c6b", -748372204, -1380159292), a.b("\uead4\u9364\u19ac\u87da\u0c1b\u8abb", 1170270876)).equals(a.c(-930882293, "\udd43\ua4f3\u2e3b\ub04d\u3b8c\ubd2c"))) {
                                throw new IllegalArgumentException(a.c(-886293644, "\u3b18\u42a5\uc877\u561e\udd9f\u5b6f\ue129\u68d8\uf681\u7c2b\ufbf3\u0195\u8f43\u16e3\u9ca6"));
                            }
                            var25_39 = (int)(((long)var10_10 + var22_33 /* !! */ [0] + var22_33 /* !! */ [2] - (long)var19_24) / var23_35[0] + 1L);
                            var26_41 = (int)(((long)var11_11 + var22_33 /* !! */ [1] + var22_33 /* !! */ [3] - (long)var20_28) / var23_35[1] + 1L);
                            if (var25_39 <= 0 || var26_41 <= 0) {
                                throw new IllegalArgumentException(a.c(990541153, "\u7508\u0cb5\u8667\u180e\u938f\u156d\uaf25\u26dd\ub893\u3237"));
                            }
                            var4_4.add(new eof(var17_17.data, (float[])var21_32 /* !! */ .clone(), var18_18, var9_9, var19_24, var20_28, (int)var22_33 /* !! */ [0], (int)var22_33 /* !! */ [1], (int)var23_35[0], (int)var23_35[1], var25_39, var26_41));
                            var9_9 = var18_18;
                            var10_10 = var25_39;
                            var11_11 = var26_41;
                            break;
                        }
                        case 1: {
                            if (!var4_4.isEmpty() && (var18_19 /* !! */  = var4_4.get(var4_4.size() - 1)) instanceof eof) {
                                var17_17 = (eof)var18_19 /* !! */ ;
                                var18_19 /* !! */  = (E)eqc.eqv(var1_1, (epj)var14_14, (int)1).data;
                                var19_25 = eqc.eqv(var1_1, (epj)var14_14, (int)2).data;
                                var20_29 = eqc.eqv(var1_1, (epj)var14_14, (int)3).data;
                                var21_32 /* !! */  = eqc.eqv(var1_1, (epj)var14_14, (int)4).data;
                                var22_34 = var14_14.floating(a.b("\u9889\ue12d\u6bfd\uf596\u7e44\uf8f6\u42a4", -2031773461), 1.0E-5f);
                                var23_36 = var17_17.eoj * var17_17.eok * var17_17.eol;
                                var24_38 = 0;
                                break block57;
                            } else {
                                throw new IllegalArgumentException(a.b("\u0c1b\u75a6\uff3b\u611d\uead4\u6c78\ud637\u5fc1\uc184\u4b34\uccb3\u3681\ub85a\u21ea\uaba1", -2027680650));
                            }
                        }
                        case 2: {
                            if (var12_12 >= 0) {
                                throw new IllegalArgumentException(a.d("\u16b5\u6f13\ue5c9\u7ba1\uf023\u76d3\ucc87\u4564\udb2a\u518c\ud60d\u2c3f\ua2e5\u3b54", -2013250838, -657511389));
                            }
                            var4_4.add(eqc.eqi);
                            break;
                        }
                        case 3: {
                            var17_17 = var14_14.ints(a.d("\u312d\u4892\uc256\u5c3b\ud7e7\u515f\ueb3f\u62e2\ufca6\u761e\uf1dc\u0bb8", -2091769260, 1398149918), null);
                            var18_20 = var14_14.ints(a.b("\u6a85\u1333\u99e6\u078c\u8c56\u0ae6\ub0a3", -1693619471), (long[])var17_17);
                            var19_26 = var14_14.ints(a.c(-1339760515, "\ue009\u99a9\u137f\u8d19"), new long[]{0L, 0L, 0L, 0L});
                            if (var17_17 == null || ((long[])var17_17).length != 2 || var18_20.length != 2 || var19_26[0] != 0L || var19_26[1] != 0L || var19_26[2] != 0L || var19_26[3] != 0L || var14_14.integer(a.b("\ue1ce\u9879\u12a6\u8cd2\u0736\u81b5\u3be4\ub21e\u2c40", -669589084), 0L) != 0L || var12_12 >= 0) {
                                throw new IllegalArgumentException(a.d("\ue724\u9e8a\u1459\u8a2b\u01b0\u8740\u3d06\ub4f7\u2aae\ua004\u27dc\uddba\u536c\ucacc\u4089", 702617025, 1401680538));
                            }
                            var20_30 = new eps((int)var17_17[0], (int)var17_17[1], (int)var18_20[0], (int)var18_20[1]);
                            var10_10 = (var10_10 - var20_30.ept) / var20_30.epv + 1;
                            var11_11 = (var11_11 - var20_30.epu) / var20_30.epw + 1;
                            var4_4.add(var20_30);
                            break;
                        }
                        case 4: {
                            if (var12_12 < 0) {
                                var12_12 = eqc.eqs(var9_9, var10_10);
                            }
                            if (var14_14.inputs.size() > 4 && !var14_14.inputs.get(4).isEmpty()) {
                                throw new IllegalArgumentException(a.b("\ub757\ucef0\u4437\uda42\u5185\ud73f\u6d61\ue496\u7af3\uf071\u77ab\u8dd1\u031b", -212814039));
                            }
                            if (var14_14.has(a.d("\u97e3\uee50\u6494\ufaf8\u7130\uf796\u4dd0\uc43c\u5a65\ud0d5\u571b", -1328233887, 860050920)) || var14_14.has(a.c(651126394, "\u661d\u1fa3\u9575\u0b1d")) || var14_14.integer(a.b("\udfe3\ua655\u2c98\ub2ec\u393a\ubfa0\u05ca\u8c32\u1270\u98d4\u1f05\ue565", 1503715206), 0L) != 0L) {
                                throw new IllegalArgumentException(a.d("\u7c73\u05dd\u8f09\u1161\u9afb\u1c0b\ua64d\u2fbc\ub1e5\u3b4f\ubc97\u46f1\uc827\u5187\udbc2", 1495423430, 1553671638));
                            }
                            var17_17 = var14_14.string(a.b("\ucfba\ub606\u3cce\ua2a8\u2979\uafdf\u1591\u9c66\u0238", -1652633641), a.d("\ucaeb\ub353\u399d\ua7e9\u2c28\uaa8a\u10cf", -228308837, 1593410065));
                            var18_21 = var17_17.equals(a.c(1375513552, "\uabbf\ud205\u58db\uc6a7\u4d6b\ucbcd\u7198\uf87e\u663c\uec8b\u6b59\u9127\u1ffd")) != false ? 2 : 1;
                            var19_24 = (int)var14_14.integer(a.b("\u6ec9\u1779\u9da7\u03d6\u8800\u0eba\ub4d8\u3d05\ua340\u29e2\uae2e", -559649110), -1L);
                            var20_31 = eqc.eqv(var1_1, var14_14, 1);
                            var21_32 /* !! */  = (float[])eqc.eqv(var1_1, var14_14, 2);
                            var22_33 /* !! */  = (long[])(var14_14.inputs.size() > 3 && var14_14.inputs.get(3).isEmpty() == false ? eqc.eqv(var1_1, (epj)var14_14, (int)3).data : new float[var18_21 * 8 * var19_24]);
                            if (var19_24 <= 0 || var20_31.data.length != var18_21 * 4 * var19_24 * var12_12 || var21_32 /* !! */ .data.length != var18_21 * 4 * var19_24 * var19_24 || var22_33 /* !! */ .length != var18_21 * 8 * var19_24) {
                                throw new IllegalArgumentException(a.b("\u8997\uf039\u7aed\ue485\u6f1f\ue9fd\u53b5\uda4d\u4403\ucea7", -1363768847));
                            }
                            var5_5.add(new eoz(eqc.eqt(var20_31.data, var18_21, var19_24, var12_12), eqc.eqt(var21_32 /* !! */ .data, var18_21, var19_24, var19_24), var22_33 /* !! */ , var19_24, var12_12, var18_21, var17_17.equals(a.b("\u1551\u6cf7\ue637\u7855\uf395\u7525\ucf60", -479193820))));
                            var12_12 = var18_21 * var19_24;
                            break;
                        }
                        case 5: 
                        case 6: {
                            if (var6_6 != null) {
                                throw new IllegalArgumentException(a.c(-1086056784, "\u16c8\u6f6f\ue5ba\u7bc7\uf011\u76aa\uccbd\u4504\udb56\u51e3\ud635"));
                            }
                            if (var12_12 < 0) {
                                var12_12 = eqc.eqs(var9_9, var10_10);
                            }
                            var17_17 = eqc.eqv(var1_1, var14_14, 1);
                            v0 = var18_22 = var14_14.op.equals(a.d("\u64f2\u1d61\u97ba\u09cb", 610490933, -760463740)) != false && var14_14.integer(a.b("\u792d\u009a\u8a5a\u1424\u9fee\u196e", -113280673), 0L) != 0L;
                            if (var14_14.op.equals(a.c(419863253, "\u9a96\ue305\u69de\uf7af")) && (var14_14.integer(a.d("\u27db\u5e6c\ud4ac\u4ad2\uc118\u479b", 1505687238, 1696846191), 0L) != 0L || var14_14.floating(a.d("\u078a\u7e36\uf4f9\u6a90\ue14e", -1741935006, 340470156), 1.0f) != 1.0f || var14_14.floating(a.d("\ua37c\udaca\u5008\uce6c", 1743653042, -1205949528), 1.0f) != 1.0f)) {
                                throw new IllegalArgumentException(a.b("\u15e6\u6c55\ue68e\u78ff\uf365\u7595\ucfd3\u4622\ud87b\u52d1\ud509\u2f6f\ua1b9\u3819\ub25c", -654043762));
                            }
                            if (var17_17.dims.length != 2 || var17_17.dims[var18_22 != false ? 1 : 0] != (long)var12_12) {
                                throw new IllegalArgumentException(a.b("\ud7ee\uae52\u2485\ubaf1\u3162\ub780\u0dc8\u8430\u1a7e\u90da", 937482124));
                            }
                            var8_8 = (int)var17_17.dims[var18_22 != false ? 0 : 1];
                            v1 = var6_6 = var18_22 != false ? eqc.equ(var17_17.data, var8_8, var12_12) : var17_17.data;
                            if (!var14_14.op.equals(a.c(-1901079201, "\ud51c\uac8f\u2654\ub825")) || var14_14.inputs.size() <= 2 || var14_14.inputs.get(2).isEmpty()) continue block34;
                            var7_7 = eqc.eqv(var1_1, (epj)var14_14, (int)2).data;
                            break;
                        }
                        case 7: {
                            var17_17 = null;
                            for (String var19_27 : var14_14.inputs) {
                                if (!var1_1.containsKey(var19_27)) continue;
                                var17_17 = var1_1.get(var19_27);
                            }
                            if (var6_6 == null || var7_7 != null || var17_17 == null || var17_17.data == null || var17_17.data.length != var8_8) {
                                throw new IllegalArgumentException(a.c(140789673, "\u47cb\u3e7f\ub4ac"));
                            }
                            var7_7 = var17_17.data;
                            break;
                        }
                        case 8: 
                        case 9: 
                        case 10: 
                        case 11: 
                        case 12: 
                        case 13: 
                        case 14: 
                        case 15: 
                        case 16: 
                        case 17: 
                        case 18: 
                        case 19: 
                        case 20: 
                        case 21: {
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException(a.d("\u9d91\ue43f\u6ebc", -1888559261, 960578206) + var14_14.op);
                        }
                    }
                    continue;
                }
                if (var6_6 == null || var4_4.isEmpty() || var8_8 <= 1) {
                    throw new IllegalArgumentException(a.b("\u8366\ufad0\u700e\uee73\u65a6\ue30a\u5945\ud0bd\u4ef3\uc453\u43c5\ub9f3\u3731\uae93\u24d1\ua238", -1662876897));
                }
                var13_13 = new eqc(var2_2, var3_3, var8_8);
                var13_13.eqd.addAll(var4_4);
                var13_13.eqe.addAll(var5_5);
                var13_13.eqf = var6_6;
                var13_13.eqg = var7_7 != null ? var7_7 : new float[var8_8];
                var13_13.eqh = var12_12;
                return var13_13;
            }
            while (true) {
                if (var24_38 < var17_17.eoi) ** break;
                continue block34;
                var25_40 = (float)((double)var18_19 /* !! */ [var24_38] / Math.sqrt(var21_32 /* !! */ [var24_38] + var22_34));
                for (var26_41 = 0; var26_41 < var23_36; ++var26_41) {
                    v2 = var24_38 * var23_36 + var26_41;
                    var17_17.eog[v2] = var17_17.eog[v2] * var25_40;
                }
                var17_17.eoh[var24_38] = (var17_17.eoh[var24_38] - var20_29[var24_38]) * var25_40 + var19_25[var24_38];
                ++var24_38;
            }
            break;
        }
    }

    private static int eqs(int n, int n2) {
        if (n2 != 1) {
            throw new IllegalArgumentException(a.d("\u1f3c\u6680\uec53\u726c\uf9f3\u7f4f\uc510\u4cef\ud2bf\u5812\udf95", -1324712268, 1724932576) + n2);
        }
        return n;
    }

    private static float[][] eqt(float[] fArray, int n, int n2, int n3) {
        int n4 = 4 * n2;
        float[][] fArray2 = new float[n * n3][n4];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n4; ++j) {
                int n5 = (i * n4 + j) * n3;
                for (int k = 0; k < n3; ++k) {
                    fArray2[i * n3 + k][j] = fArray[n5 + k];
                }
            }
        }
        return fArray2;
    }

    private static float[] equ(float[] fArray, int n, int n2) {
        float[] fArray2 = new float[fArray.length];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                fArray2[j * n + i] = fArray[i * n2 + j];
            }
        }
        return fArray2;
    }

    private static epz eqv(Map<String, epz> map, epj epj2, int n) {
        epz epz2;
        epz epz3 = epz2 = n < epj2.inputs.size() ? map.get(epj2.inputs.get(n)) : null;
        if (epz2 == null || epz2.data == null) {
            throw new IllegalArgumentException(epj2.op + a.c(-68838459, "\u9be2\ue21a\u68ce\uf6a1\u7d73\ufbc3\u41c4") + n);
        }
        return epz2;
    }

    private static /* synthetic */ int jo(int n, int n2) {
        return n * n2 ^ 0x112B5AAD;
    }
}

