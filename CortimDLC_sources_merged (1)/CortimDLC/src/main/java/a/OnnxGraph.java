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
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class OnnxGraph {
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

    private OnnxGraph(int n, int n2, int n3) {
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
                fArray2 = OnnxGraph.eql(fArray2, n3, n4, eof2);
                n2 = eof2.eoi;
                n3 = eof2.eoq;
                n4 = eof2.eor;
                continue;
            }
            if (!(object2 instanceof eps)) continue;
            object = (eps)object2;
            n5 = (n3 - ((eps)object).ept) / ((eps)object).epv + 1;
            n = (n4 - ((eps)object).epu) / ((eps)object).epw + 1;
            fArray2 = OnnxGraph.eqo(fArray2, n2, n3, n4, (eps)object, n5, n);
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
            object3 = OnnxGraph.eqp((float[][])object3, eoz2);
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
                            OnnxGraph.eqm(fArray5, fArrayArray[n14], fArrayArray[n14 + 1], fArrayArray[n14 + 2], eof2.eog[n15], eof2.eog[n15 + 1], eof2.eog[n15 + 2], n10);
                            continue;
                        }
                        for (int i = 0; i < n11; ++i) {
                            OnnxGraph.eqn(fArray5, fArrayArray[n14 + i], eof2.eog[n15 + i], n10);
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
                    OnnxGraph.eqn(fArray3, eoz2.epa[i * eoz2.epe + n5], fArray7[n5], n3);
                }
                for (n5 = 0; n5 < n2; ++n5) {
                    OnnxGraph.eqn(fArray3, eoz2.epb[i * n2 + n5], fArray5[n5], n3);
                }
                float[] fArray8 = fArray2[n6];
                for (int k = 0; k < n2; ++k) {
                    float f = OnnxGraph.eqq(fArray3[k]);
                    float f2 = OnnxGraph.eqq(fArray3[n2 + k]);
                    float f3 = OnnxGraph.eqq(fArray3[2 * n2 + k]);
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

    static OnnxGraph parse(byte[] byArray) {
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
            throw new IllegalArgumentException("no graph");
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
            throw new IllegalArgumentException("input shape");
        }
        return OnnxGraph.eqr(arrayList, hashMap, (int)lArray[2], (int)lArray[3]);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private static OnnxGraph eqr(List<epj> var0, Map<String, epz> var1_1, int var2_2, int var3_3) {
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
                            if (!var15_15.equals("Conv")) break;
                            var16_16 = 0;
                            break;
                        }
                        case -768792413: {
                            if (!var15_15.equals("BatchNormalization")) break;
                            var16_16 = 1;
                            break;
                        }
                        case 2543388: {
                            if (!var15_15.equals("Relu")) break;
                            var16_16 = 2;
                            break;
                        }
                        case -1786316928: {
                            if (!var15_15.equals("MaxPool")) break;
                            var16_16 = 3;
                            break;
                        }
                        case 2346560: {
                            if (!var15_15.equals("LSTM")) break;
                            var16_16 = 4;
                            break;
                        }
                        case -1997407644: {
                            if (!var15_15.equals("MatMul")) break;
                            var16_16 = 5;
                            break;
                        }
                        case 2215710: {
                            if (!var15_15.equals("Gemm")) break;
                            var16_16 = 6;
                            break;
                        }
                        case 65665: {
                            if (!var15_15.equals("Add")) break;
                            var16_16 = 7;
                            break;
                        }
                        case -503167036: {
                            if (!var15_15.equals("Constant")) break;
                            var16_16 = 8;
                            break;
                        }
                        case -300349950: {
                            if (!var15_15.equals("Squeeze")) break;
                            var16_16 = 9;
                            break;
                        }
                        case 1750765897: {
                            if (!var15_15.equals("Unsqueeze")) break;
                            var16_16 = 10;
                            break;
                        }
                        case -1238034663: {
                            if (!var15_15.equals("Transpose")) break;
                            var16_16 = 11;
                            break;
                        }
                        case -1533165266: {
                            if (!var15_15.equals("Reshape")) break;
                            var16_16 = 12;
                            break;
                        }
                        case 79847297: {
                            if (!var15_15.equals("Shape")) break;
                            var16_16 = 13;
                            break;
                        }
                        case 2125810203: {
                            if (!var15_15.equals("Gather")) break;
                            var16_16 = 14;
                            break;
                        }
                        case 2024039220: {
                            if (!var15_15.equals("Concat")) break;
                            var16_16 = 15;
                            break;
                        }
                        case 963849126: {
                            if (!var15_15.equals("ConstantOfShape")) break;
                            var16_16 = 16;
                            break;
                        }
                        case 79973746: {
                            if (!var15_15.equals("Slice")) break;
                            var16_16 = 17;
                            break;
                        }
                        case -71117602: {
                            if (!var15_15.equals("Identity")) break;
                            var16_16 = 18;
                            break;
                        }
                        case 2092895: {
                            if (!var15_15.equals("Cast")) break;
                            var16_16 = 19;
                            break;
                        }
                        case -704578081: {
                            if (!var15_15.equals("Dropout")) break;
                            var16_16 = 20;
                            break;
                        }
                        case -2064276170: {
                            if (!var15_15.equals("LogSoftmax")) break;
                            var16_16 = 21;
                            break;
                        }
                    }
                    switch (var16_16) {
                        case 0: {
                            if (var12_12 >= 0 || var6_6 != null) {
                                throw new IllegalArgumentException("conv after cnn");
                            }
                            var17_17 = OnnxGraph.eqv(var1_1, var14_14, 1);
                            if (var17_17.dims.length != 4 || var17_17.dims[1] != (long)var9_9) {
                                throw new IllegalArgumentException("conv weight");
                            }
                            var18_18 = (int)var17_17.dims[0];
                            var19_24 = (int)var17_17.dims[2];
                            var20_28 = (int)var17_17.dims[3];
                            var21_32 /* !! */  = var14_14.inputs.size() > 2 && var14_14.inputs.get(2).isEmpty() == false ? OnnxGraph.eqv(var1_1, (epj)var14_14, (int)2).data : new float[var18_18];
                            var22_33 /* !! */  = var14_14.ints("pads", new long[]{0L, 0L, 0L, 0L});
                            var23_35 = var14_14.ints("strides", new long[]{1L, 1L});
                            var24_37 = var14_14.ints("dilations", new long[]{1L, 1L});
                            if (var21_32 /* !! */ .length != var18_18 || var22_33 /* !! */ .length != 4 || var23_35.length != 2 || var24_37[0] != 1L || var24_37[1] != 1L || var14_14.integer("group", 1L) != 1L || !var14_14.string("auto_pad", "NOTSET").equals("NOTSET")) {
                                throw new IllegalArgumentException("conv attributes");
                            }
                            var25_39 = (int)(((long)var10_10 + var22_33 /* !! */ [0] + var22_33 /* !! */ [2] - (long)var19_24) / var23_35[0] + 1L);
                            var26_41 = (int)(((long)var11_11 + var22_33 /* !! */ [1] + var22_33 /* !! */ [3] - (long)var20_28) / var23_35[1] + 1L);
                            if (var25_39 <= 0 || var26_41 <= 0) {
                                throw new IllegalArgumentException("conv shape");
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
                                var18_19 /* !! */  = (E)OnnxGraph.eqv(var1_1, (epj)var14_14, (int)1).data;
                                var19_25 = OnnxGraph.eqv(var1_1, (epj)var14_14, (int)2).data;
                                var20_29 = OnnxGraph.eqv(var1_1, (epj)var14_14, (int)3).data;
                                var21_32 /* !! */  = OnnxGraph.eqv(var1_1, (epj)var14_14, (int)4).data;
                                var22_34 = var14_14.floating("epsilon", 1.0E-5f);
                                var23_36 = var17_17.eoj * var17_17.eok * var17_17.eol;
                                var24_38 = 0;
                                break block57;
                            } else {
                                throw new IllegalArgumentException("bn without conv");
                            }
                        }
                        case 2: {
                            if (var12_12 >= 0) {
                                throw new IllegalArgumentException("relu after cnn");
                            }
                            var4_4.add(OnnxGraph.eqi);
                            break;
                        }
                        case 3: {
                            var17_17 = var14_14.ints("kernel_shape", null);
                            var18_20 = var14_14.ints("strides", (long[])var17_17);
                            var19_26 = var14_14.ints("pads", new long[]{0L, 0L, 0L, 0L});
                            if (var17_17 == null || ((long[])var17_17).length != 2 || var18_20.length != 2 || var19_26[0] != 0L || var19_26[1] != 0L || var19_26[2] != 0L || var19_26[3] != 0L || var14_14.integer("ceil_mode", 0L) != 0L || var12_12 >= 0) {
                                throw new IllegalArgumentException("pool attributes");
                            }
                            var20_30 = new eps((int)var17_17[0], (int)var17_17[1], (int)var18_20[0], (int)var18_20[1]);
                            var10_10 = (var10_10 - var20_30.ept) / var20_30.epv + 1;
                            var11_11 = (var11_11 - var20_30.epu) / var20_30.epw + 1;
                            var4_4.add(var20_30);
                            break;
                        }
                        case 4: {
                            if (var12_12 < 0) {
                                var12_12 = OnnxGraph.eqs(var9_9, var10_10);
                            }
                            if (var14_14.inputs.size() > 4 && !var14_14.inputs.get(4).isEmpty()) {
                                throw new IllegalArgumentException("sequence_lens");
                            }
                            if (var14_14.has("activations") || var14_14.has("clip") || var14_14.integer("input_forget", 0L) != 0L) {
                                throw new IllegalArgumentException("lstm attributes");
                            }
                            var17_17 = var14_14.string("direction", "forward");
                            var18_21 = var17_17.equals("bidirectional") != false ? 2 : 1;
                            var19_24 = (int)var14_14.integer("hidden_size", -1L);
                            var20_31 = OnnxGraph.eqv(var1_1, var14_14, 1);
                            var21_32 /* !! */  = (float[])OnnxGraph.eqv(var1_1, var14_14, 2);
                            var22_33 /* !! */  = (long[])(var14_14.inputs.size() > 3 && var14_14.inputs.get(3).isEmpty() == false ? OnnxGraph.eqv(var1_1, (epj)var14_14, (int)3).data : new float[var18_21 * 8 * var19_24]);
                            if (var19_24 <= 0 || var20_31.data.length != var18_21 * 4 * var19_24 * var12_12 || var21_32 /* !! */ .data.length != var18_21 * 4 * var19_24 * var19_24 || var22_33 /* !! */ .length != var18_21 * 8 * var19_24) {
                                throw new IllegalArgumentException("lstm shape");
                            }
                            var5_5.add(new eoz(OnnxGraph.eqt(var20_31.data, var18_21, var19_24, var12_12), OnnxGraph.eqt(var21_32 /* !! */ .data, var18_21, var19_24, var19_24), var22_33 /* !! */ , var19_24, var12_12, var18_21, var17_17.equals("reverse")));
                            var12_12 = var18_21 * var19_24;
                            break;
                        }
                        case 5: 
                        case 6: {
                            if (var6_6 != null) {
                                throw new IllegalArgumentException("second head");
                            }
                            if (var12_12 < 0) {
                                var12_12 = OnnxGraph.eqs(var9_9, var10_10);
                            }
                            var17_17 = OnnxGraph.eqv(var1_1, var14_14, 1);
                            v0 = var18_22 = var14_14.op.equals("Gemm") != false && var14_14.integer("transB", 0L) != 0L;
                            if (var14_14.op.equals("Gemm") && (var14_14.integer("transA", 0L) != 0L || var14_14.floating("alpha", 1.0f) != 1.0f || var14_14.floating("beta", 1.0f) != 1.0f)) {
                                throw new IllegalArgumentException("gemm attributes");
                            }
                            if (var17_17.dims.length != 2 || var17_17.dims[var18_22 != false ? 1 : 0] != (long)var12_12) {
                                throw new IllegalArgumentException("head shape");
                            }
                            var8_8 = (int)var17_17.dims[var18_22 != false ? 0 : 1];
                            v1 = var6_6 = var18_22 != false ? OnnxGraph.equ(var17_17.data, var8_8, var12_12) : var17_17.data;
                            if (!var14_14.op.equals("Gemm") || var14_14.inputs.size() <= 2 || var14_14.inputs.get(2).isEmpty()) continue block34;
                            var7_7 = OnnxGraph.eqv(var1_1, (epj)var14_14, (int)2).data;
                            break;
                        }
                        case 7: {
                            var17_17 = null;
                            for (String var19_27 : var14_14.inputs) {
                                if (!var1_1.containsKey(var19_27)) continue;
                                var17_17 = var1_1.get(var19_27);
                            }
                            if (var6_6 == null || var7_7 != null || var17_17 == null || var17_17.data == null || var17_17.data.length != var8_8) {
                                throw new IllegalArgumentException("add");
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
                            throw new IllegalArgumentException("op " + var14_14.op);
                        }
                    }
                    continue;
                }
                if (var6_6 == null || var4_4.isEmpty() || var8_8 <= 1) {
                    throw new IllegalArgumentException("incomplete graph");
                }
                var13_13 = new OnnxGraph(var2_2, var3_3, var8_8);
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
            throw new IllegalArgumentException("cnn height " + n2);
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
            throw new IllegalArgumentException(epj2.op + " input " + n);
        }
        return epz2;
    }

    private static /* synthetic */ int jo(int n, int n2) {
        return n * n2 ^ 0x112B5AAD;
    }
}

