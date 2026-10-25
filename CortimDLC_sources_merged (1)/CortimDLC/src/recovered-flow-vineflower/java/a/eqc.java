package a;

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
   final List<Object> eqd = new ArrayList<>();
   final List<eoz> eqe = new ArrayList<>();
   float[] eqf;
   float[] eqg;
   int eqh;
   static final Object eqi = new Object();

   eqc(int var1, int var2, int var3) {
      this.inputH = var1;
      this.inputW = var2;
      this.classes = var3;
   }

   float[][] logits(float[] var1) throws InterruptedException {
      float[] var2 = var1;
      int var3 = 3;
      int var4 = this.inputH;
      int var5 = this.inputW;

      for (Object var7 : this.eqd) {
         if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
         }

         if (var7 == eqi) {
            for (int var23 = 0; var23 < var2.length; var23++) {
               if (var2[var23] < 0.0F) {
                  var2[var23] = 0.0F;
               }
            }
         } else if (var7 instanceof eof var8) {
            var2 = eql(var2, var4, var5, var8);
            var3 = var8.eoi;
            var4 = var8.eoq;
            var5 = var8.eor;
         } else if (var7 instanceof eps var9) {
            int var10 = (var4 - var9.ept) / var9.epv + 1;
            int var11 = (var5 - var9.epu) / var9.epw + 1;
            var2 = eqo(var2, var3, var4, var5, var9, var10, var11);
            var4 = var10;
            var5 = var11;
         }
      }

      float[][] var15 = new float[var5][var3];

      for (int var16 = 0; var16 < var3; var16++) {
         for (int var19 = 0; var19 < var5; var19++) {
            var15[var19][var16] = var2[var16 * var5 + var19];
         }
      }

      for (eoz var20 : this.eqe) {
         var15 = eqp(var15, var20);
      }

      float[][] var18 = new float[var15.length][this.classes];

      for (int var21 = 0; var21 < var15.length; var21++) {
         float[] var22 = var15[var21];
         float[] var24 = var18[var21];

         for (int var25 = 0; var25 < this.classes; var25++) {
            var24[var25] = this.eqg[var25];
         }

         for (int var26 = 0; var26 < this.eqh; var26++) {
            float var12 = var22[var26];
            int var13 = var26 * this.classes;

            for (int var14 = 0; var14 < this.classes; var14++) {
               var24[var14] += var12 * this.eqf[var13 + var14];
            }
         }
      }

      return var18;
   }

   static float[] eql(float[] var0, int var1, int var2, eof var3) {
      int var4 = var3.eoq;
      int var5 = var3.eor;
      int var6 = var3.eol;
      int var7 = (var4 - 1) * var3.eoo + var3.eok;
      float[] var8 = new float[var5];
      float[][] var9 = new float[var3.eoj * var7 * var6][];

      for (int var10 = 0; var10 < var3.eoj; var10++) {
         for (int var11 = 0; var11 < var7; var11++) {
            int var12 = var11 - var3.eom;

            for (int var13 = 0; var13 < var6; var13++) {
               float[] var14 = var8;
               if (var12 >= 0 && var12 < var1) {
                  var14 = new float[var5];
                  int var15 = var10 * var1 * var2 + var12 * var2;
                  int var16 = var13 - var3.eon;
                  if (var3.eop == 1) {
                     int var29 = Math.max(0, -var16);
                     int var31 = Math.min(var5, var2 - var16);
                     if (var29 < var31) {
                        System.arraycopy(var0, var15 + var29 + var16, var14, var29, var31 - var29);
                     }
                  } else {
                     for (int var17 = 0; var17 < var5; var17++) {
                        int var18 = var17 * var3.eop + var16;
                        if (var18 >= 0 && var18 < var2) {
                           var14[var17] = var0[var15 + var18];
                        }
                     }
                  }
               }

               var9[(var10 * var7 + var11) * var6 + var13] = var14;
            }
         }
      }

      int var22 = var3.eok * var6;
      float[] var23 = new float[var3.eoi * var4 * var5];
      float[] var24 = new float[var5];

      for (int var25 = 0; var25 < var3.eoi; var25++) {
         float var26 = var3.eoh[var25];

         for (int var27 = 0; var27 < var4; var27++) {
            Arrays.fill(var24, var26);

            for (int var28 = 0; var28 < var3.eoj; var28++) {
               int var30 = (var25 * var3.eoj + var28) * var22;

               for (int var32 = 0; var32 < var3.eok; var32++) {
                  int var19 = (var28 * var7 + var27 * var3.eoo + var32) * var6;
                  int var20 = var30 + var32 * var6;
                  if (var6 == 3) {
                     eqm(var24, var9[var19], var9[var19 + 1], var9[var19 + 2], var3.eog[var20], var3.eog[var20 + 1], var3.eog[var20 + 2], var5);
                  } else {
                     for (int var21 = 0; var21 < var6; var21++) {
                        eqn(var24, var9[var19 + var21], var3.eog[var20 + var21], var5);
                     }
                  }
               }
            }

            System.arraycopy(var24, 0, var23, (var25 * var4 + var27) * var5, var5);
         }
      }

      return var23;
   }

   static void eqm(float[] var0, float[] var1, float[] var2, float[] var3, float var4, float var5, float var6, int var7) {
      for (int var8 = 0; var8 < var7; var8++) {
         var0[var8] += var4 * var1[var8] + var5 * var2[var8] + var6 * var3[var8];
      }
   }

   static void eqn(float[] var0, float[] var1, float var2, int var3) {
      for (int var4 = 0; var4 < var3; var4++) {
         var0[var4] += var2 * var1[var4];
      }
   }

   static float[] eqo(float[] var0, int var1, int var2, int var3, eps var4, int var5, int var6) {
      float[] var7 = new float[var1 * var5 * var6];

      for (int var8 = 0; var8 < var1; var8++) {
         int var9 = var8 * var2 * var3;
         int var10 = var8 * var5 * var6;

         for (int var11 = 0; var11 < var5; var11++) {
            for (int var12 = 0; var12 < var6; var12++) {
               float var13 = Float.NEGATIVE_INFINITY;

               for (int var14 = 0; var14 < var4.ept; var14++) {
                  int var15 = var9 + (var11 * var4.epv + var14) * var3 + var12 * var4.epw;

                  for (int var16 = 0; var16 < var4.epu; var16++) {
                     float var17 = var0[var15 + var16];
                     if (var17 > var13) {
                        var13 = var17;
                     }
                  }
               }

               var7[var10 + var11 * var6 + var12] = var13;
            }
         }
      }

      return var7;
   }

   static float[][] eqp(float[][] var0, eoz var1) {
      int var2 = var0.length;
      int var3 = var1.epd;
      int var4 = 4 * var3;
      float[][] var5 = new float[var2][var1.epf * var3];
      float[] var6 = new float[var4];
      float[] var7 = new float[var4];

      for (int var8 = 0; var8 < var1.epf; var8++) {
         boolean var9 = var1.epg || var8 == 1;
         int var10 = var8 * 2 * var4;

         for (int var11 = 0; var11 < var4; var11++) {
            var7[var11] = var1.epc[var10 + var11] + var1.epc[var10 + var4 + var11];
         }

         float[] var22 = new float[var3];
         float[] var12 = new float[var3];

         for (int var13 = 0; var13 < var2; var13++) {
            int var14 = var9 ? var2 - 1 - var13 : var13;
            float[] var15 = var0[var14];
            System.arraycopy(var7, 0, var6, 0, var4);

            for (int var16 = 0; var16 < var1.epe; var16++) {
               eqn(var6, var1.epa[var8 * var1.epe + var16], var15[var16], var4);
            }

            for (int var23 = 0; var23 < var3; var23++) {
               eqn(var6, var1.epb[var8 * var3 + var23], var22[var23], var4);
            }

            float[] var24 = var5[var14];

            for (int var17 = 0; var17 < var3; var17++) {
               float var18 = eqq(var6[var17]);
               float var19 = eqq(var6[var3 + var17]);
               float var20 = eqq(var6[2 * var3 + var17]);
               float var21 = (float)Math.tanh(var6[3 * var3 + var17]);
               var12[var17] = var20 * var12[var17] + var18 * var21;
               var22[var17] = var19 * (float)Math.tanh(var12[var17]);
               var24[var8 * var3 + var17] = var22[var17];
            }
         }
      }

      return var5;
   }

   static float eqq(float var0) {
      return (float)(1.0 / (1.0 + Math.exp(-var0)));
   }

   static eqc parse(byte[] var0) {
      epm var1 = new epm(var0, 0, var0.length);
      epm var2 = null;

      while (var1.more()) {
         int var3 = var1.tag();
         if (var3 >>> 3 == 7 && (var3 & 7) == 2) {
            var2 = var1.sub();
         } else {
            var1.skip(var3 & 7);
         }
      }

      if (var2 == null) {
         throw new IllegalArgumentException(a.c(-1373751528, "㝾从쑒婤톦圄\ued46撯"));
      }

      ArrayList var10 = new ArrayList();
      HashMap var4 = new HashMap();
      ArrayList var5 = new ArrayList();

      while (var2.more()) {
         int var6 = var2.tag();
         int var7 = var6 >>> 3;
         if (var7 == 1 && (var6 & 7) == 2) {
            var10.add(epj.read(var2.sub()));
         } else if (var7 == 5 && (var6 & 7) == 2) {
            epz var8 = epz.read(var2.sub());
            var4.put(var8.name, var8);
         } else if (var7 == 11 && (var6 & 7) == 2) {
            var5.add(var2.sub());
         } else {
            var2.skip(var6 & 7);
         }
      }

      long[] var11 = null;

      for (epm var13 : var5) {
         eou var9 = eou.read(var13);
         if (!var4.containsKey(var9.eov)) {
            var11 = var9.eow;
            break;
         }
      }

      if (var11 != null && var11.length == 4 && var11[1] == 3L && var11[2] > 0L && var11[3] > 0L) {
         return eqr(var10, var4, (int)var11[2], (int)var11[3]);
      } else {
         throw new IllegalArgumentException(a.d("ⱍ嗻\udf36䅂쪔䱱\uf671羛\ue1cd歭\uecab", -200490044, 1818292203));
      }
   }

   static eqc eqr(List<epj> var0, Map<String, epz> var1, int var2, int var3) {
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      float[] var6 = null;
      float[] var7 = null;
      int var8 = 0;
      int var9 = 3;
      int var10 = var2;
      int var11 = var3;
      int var12 = -1;

      for (epj var14 : var0) {
                  if (java.util.Objects.equals(var14.op, a.c(2077393181, "腚\uf8c7爕\uec7c"))) {
            if (var12 < 0 && var6 == null) {
                              epz var32 = eqv(var1, var14, 1);
                              if (var32.dims.length == 4 && var32.dims[1] == var9) {
                                 int var38 = (int)var32.dims[0];
                                 int var42 = (int)var32.dims[2];
                                 int var45 = (int)var32.dims[3];
                                 float[] var47 = var14.inputs.size() > 2 && !var14.inputs.get(2).isEmpty() ? eqv(var1, var14, 2).data : new float[var38];
                                 long[] var49 = var14.ints(a.b("쳳땓㾅ꇣ", 1330564231), new long[]{0L, 0L, 0L, 0L});
                                 long[] var50 = var14.ints(a.b("蕽ﳋ瘞\ue874掮\ue51e彛", 429294857), new long[]{1L, 1L});
                                 long[] var51 = var14.ints(a.c(-1521960616, "뤵삉䩟퐣忡\ud94d挘\ueae8璪"), new long[]{1L, 1L});
                                 if (var47.length == var38
                                    && var49.length == 4
                                    && var50.length == 2
                                    && var51[0] == 1L
                                    && var51[1] == 1L
                                    && var14.integer(a.c(238640072, "宪∎ꣀ㚫뵹"), 1L) == 1L
                                    && var14.string(a.d("쾹똜㳎ꊤ⥃꿝ᖟ鱫", -748372204, -1380159292), a.b("\uead4鍤\u19ac蟚ఛ誻", 1170270876)).equals(a.c(-930882293, "\udd43ꓳ⸻끍㮌봬"))) {
                                    int var52 = (int)((var10 + var49[0] + var49[2] - var42) / var50[0] + 1L);
                                    int var53 = (int)((var11 + var49[1] + var49[3] - var45) / var50[1] + 1L);
                                    if (var52 > 0 && var53 > 0) {
                                       var4.add(
                                          new eof(
                                             var32.data,
                                             (float[])var47.clone(),
                                             var38,
                                             var9,
                                             var42,
                                             var45,
                                             (int)var49[0],
                                             (int)var49[1],
                                             (int)var50[0],
                                             (int)var50[1],
                                             var52,
                                             var53
                                          )
                                       );
                                       var9 = var38;
                                       var10 = var52;
                                       var11 = var53;
                                       break;
                                    }
            
                                    throw new IllegalArgumentException(a.c(990541153, "甈ವ虧\u180e鎏ᕭ꼥⛝뢓㈷"));
                                 }
            
                                 throw new IllegalArgumentException(a.c(-886293644, "㬘䊥졷嘞\udd9f孯\ue129棘\uf681簫ﯳƕ轃ᛣ鲦"));
                              }
            
                              throw new IllegalArgumentException(a.b("蹴\uf7c9紛\ue372棳\uee15呔\udda9䏸쥆争", -123302372));
                           }
            
                           throw new IllegalArgumentException(a.b("ᖀ氽\ue6ef碆\uf307痷쾣䙀\ud80e动픩⼛ꇁ㡰", -853928467));
         }
         else if (java.util.Objects.equals(var14.op, a.b("䊽㬯뇩⾏ꑓ⋄颶ᅚ輚֧艹砍\uf6c9潣\ue525揉\ud980噐", -1652014355))) {
            if (!var4.isEmpty() && var4.get(var4.size() - 1) instanceof eof var31) {
                              float[] var37 = eqv(var1, var14, 1).data;
                              float[] var41 = eqv(var1, var14, 2).data;
                              float[] var44 = eqv(var1, var14, 3).data;
                              float[] var46 = eqv(var1, var14, 4).data;
                              float var48 = var14.floating(a.b("颉\ue12d毽\uf596繄\uf8f6䊤", -2031773461), 1.0E-5F);
                              int var23 = var31.eoj * var31.eok * var31.eol;
            
                              for (int var24 = 0; var24 < var31.eoi; var24++) {
                                 float var25 = (float)(var37[var24] / Math.sqrt(var46[var24] + var48));
            
                                 for (int var26 = 0; var26 < var23; var26++) {
                                    var31.eog[var24 * var23 + var26] = var31.eog[var24 * var23 + var26] * var25;
                                 }
            
                                 var31.eoh[var24] = (var31.eoh[var24] - var44[var24]) * var25 + var41[var24];
                              }
                              break;
                           }
            
                           throw new IllegalArgumentException(a.b("ఛ疦［愝\uead4汸혷忁솄䬴첳㚁롚⇪ꮡ", -2027680650));
         }
         else if (java.util.Objects.equals(var14.op, a.c(679795488, "\udb76ꋰ⠪뙂"))) {
            if (var12 >= 0) {
                              throw new IllegalArgumentException(a.d("ᚵ漓\ue5c9管\uf023盓첇䕤\udb2a册혍ⰿꋥ㭔", -2013250838, -657511389));
                           }
            
                           var4.add(eqi);
         }
         else if (java.util.Objects.equals(var14.op, a.c(2073383087, "僥⥸ꎲ㷫똃ゲ諢"))) {
            long[] var30 = var14.ints(a.d("ㄭ䢒쉖尻ퟧ兟\ueb3f拢ﲦ瘞\uf1dcஸ", -2091769260, 1398149918), null);
                           long[] var35 = var14.ints(a.b("檅ጳ駦ތ豖૦낣", -1693619471), var30);
                           long[] var40 = var14.ints(a.c(-1339760515, "\ue009馩\u137f贙"), new long[]{0L, 0L, 0L, 0L});
                           if (var30 != null
                              && var30.length == 2
                              && var35.length == 2
                              && var40[0] == 0L
                              && var40[1] == 0L
                              && var40[2] == 0L
                              && var40[3] == 0L
                              && var14.integer(a.b("\ue1ce项ኦ賒ܶ膵㯤눞ⱀ", -669589084), 0L) == 0L
                              && var12 < 0) {
                              eps var43 = new eps((int)var30[0], (int)var30[1], (int)var35[0], (int)var35[1]);
                              var10 = (var10 - var43.ept) / var43.epv + 1;
                              var11 = (var11 - var43.epu) / var43.epw + 1;
                              var4.add(var43);
                              break;
                           }
            
                           throw new IllegalArgumentException(a.d("\ue724麊ᑙ訫ư蝀㴆듷⪮ꀄ⟜\uddba卬쫌䂉", 702617025, 1401680538));
         }
         else if (java.util.Objects.equals(var14.op, a.b("糗չ辭ᇅ", 62880927))) {
            if (var12 < 0) {
                              var12 = eqs(var9, var10);
                           }
            
                           if (var14.inputs.size() > 4 && !var14.inputs.get(4).isEmpty()) {
                              throw new IllegalArgumentException(a.b("띗컰䐷\uda42内휿浡\ue496竳\uf071瞫跑̛", -212814039));
                           }
            
                           if (!var14.has(a.d("韣\uee50撔\ufaf8焰\uf796䷐쐼婥탕圛", -1328233887, 860050920))
                              && !var14.has(a.c(651126394, "昝ᾣ镵ଝ"))
                              && var14.integer(a.b("\udfe3ꙕⲘ달㤺뾠\u05ca谲ተ飔ἅ\ue565", 1503715206), 0L) == 0L) {
                              String var29 = var14.string(a.b("쾺똆㳎ꊨ⥹꿟ᖑ鱦ȸ", -1652633641), a.d("쫫덓㦝\ua7e9Ⱘꪊ\u10cf", -228308837, 1593410065));
                              int var34 = var29.equals(a.c(1375513552, "ꮿ툅壛욧䵫쯍熘\uf87e昼\uec8b歙鄧´")) ? 2 : 1;
                              int var39 = (int)var14.integer(a.b("滉\u1779鶧ϖ蠀຺듘㴅ꍀ⧢긮", -559649110), -1L);
                              epz var20 = eqv(var1, var14, 1);
                              epz var21 = eqv(var1, var14, 2);
                              float[] var22 = var14.inputs.size() > 3 && !var14.inputs.get(3).isEmpty() ? eqv(var1, var14, 3).data : new float[var34 * 8 * var39];
                              if (var39 > 0
                                 && var20.data.length == var34 * 4 * var39 * var12
                                 && var21.data.length == var34 * 4 * var39 * var39
                                 && var22.length == var34 * 8 * var39) {
                                 var5.add(
                                    new eoz(
                                       eqt(var20.data, var34, var39, var12),
                                       eqt(var21.data, var34, var39, var39),
                                       var22,
                                       var39,
                                       var12,
                                       var34,
                                       var29.equals(a.b("ᕑ泷\ue637硕\uf395甥콠", -479193820))
                                    )
                                 );
                                 var12 = var34 * var39;
                                 break;
                              }
            
                              throw new IllegalArgumentException(a.b("覗\uf039竭\ue485漟\ue9fd厵\uda4d䐃캧", -1363768847));
                           }
            
                           throw new IllegalArgumentException(a.d("米ם載ᅡ髻ᰋꙍ⾼뇥㭏벗䛱젧冇\udbc2", 1495423430, 1553671638));
         }
         else if (java.util.Objects.equals(var14.op, a.b("㺼䜡췧厯\ud840廨", 1371487991))) {
         }
         else if (java.util.Objects.equals(var14.op, a.d("\uf473跠ܻ饊", 253881502, -645982034))) {
            if (var6 != null) {
                              throw new IllegalArgumentException(a.c(-1086056784, "ᛈ潯\ue5ba篇\uf011皪첽䔄\udb56凣혵"));
                           }
            
                           if (var12 < 0) {
                              var12 = eqs(var9, var10);
                           }
            
                           epz var28 = eqv(var1, var14, 1);
                           boolean var33 = var14.op.equals(a.d("擲ᵡ鞺ো", 610490933, -760463740)) && var14.integer(a.b("礭\u009a詚ᐤ鿮\u196e", -113280673), 0L) != 0L;
                           if (!var14.op.equals(a.c(419863253, "骖\ue305槞\uf7af"))
                              || var14.integer(a.d("⟛幬풬䫒섘䞛", 1505687238, 1696846191), 0L) == 0L
                                 && var14.floating(a.d("ފ縶\uf4f9檐\ue14e", -1741935006, 340470156), 1.0F) == 1.0F
                                 && var14.floating(a.d("ꍼ\udaca倈칬", 1743653042, -1205949528), 1.0F) == 1.0F) {
                              if (var28.dims.length == 2 && var28.dims[var33 ? 1 : 0] == var12) {
                                 var8 = (int)var28.dims[var33 ? 0 : 1];
                                 var6 = var33 ? equ(var28.data, var8, var12) : var28.data;
                                 if (var14.op.equals(a.c(-1901079201, "픜겏♔력")) && var14.inputs.size() > 2 && !var14.inputs.get(2).isEmpty()) {
                                    var7 = eqv(var1, var14, 2).data;
                                 }
                                 break;
                              }
            
                              throw new IllegalArgumentException(a.b("ퟮ깒⒅뫱ㅢ란\u0dc8萰\u1a7e郚", 937482124));
                           }
            
                           throw new IllegalArgumentException(a.b("ᗦ汕\ue68e磿\uf365疕쿓䘢\ud87b勑픉⽯ꆹ㠙뉜", -654043762));
         }
         else if (java.util.Objects.equals(var14.op, a.b("浊ᓞ鸍", 1291611400))) {
            epz var17 = null;
            
                           for (String var19 : var14.inputs) {
                              if (var1.containsKey(var19)) {
                                 var17 = (epz)var1.get(var19);
                              }
                           }
            
                           if (var6 == null || var7 != null || var17 == null || var17.data == null || var17.data.length != var8) {
                              throw new IllegalArgumentException(a.c(140789673, "䟋㹿뒬"));
                           }
            
                           var7 = var17.data;
         }
         else if (java.util.Objects.equals(var14.op, a.d("跓\uf44e纜\ue0f0欠\ued84埘\ude33", 654278586, 771289634))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("捺\u1ae9逾\u0e5f薈̦륪", 163930926))) {
         }
         else if (java.util.Objects.equals(var14.op, a.d("\uecd7镝ᾓ臠ਲ਼貒㛁뼯Ⅿ", -1618512148, 1031314023))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("좀넗㯗ꖩ\u2e63꣑ኝ魰Թ", 742508765))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("週\ue9b7捲ﴘ盆\uf066䨠", -1240952732))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("녛죑䈋\udc6b垩", 2073604365))) {
         }
         else if (java.util.Objects.equals(var14.op, a.c(522763692, "뷭쑺亼탑嬋\uddad"))) {
         }
         else if (java.util.Objects.equals(var14.op, a.d("馈\ue015櫇\uf4bb置流", 1364202793, -2088923932))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("\uf3ac許ã麏ᕟ鏻⦧ꁌ㸨뒰㍖줜䟂\ude62吤", -1621363744))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("ﭹ苷ࠡ陚ᶋ", 588643119))) {
         }
         else if (java.util.Objects.equals(var14.op, a.c(-791360599, "쯨뉴㢦ꛜⴑꮽᇳ頏"))) {
         }
         else if (java.util.Objects.equals(var14.op, a.d("쨬뎿㥾꜈", -944125810, 769589989))) {
         }
         else if (java.util.Objects.equals(var14.op, a.d("ᓈ浏\ue781积\uf227璌컞", -1281877129, 41422844))) {
         }
         else if (java.util.Objects.equals(var14.op, a.b("ꄯ\ud8bd剦찣䟈셰笱\uf2d9沊\ue622", 2083168617))) {
         }
         else {
            throw new IllegalArgumentException(a.d("鶑\ue43f溼", -1888559261, 960578206) + var14.op);
         }
      }

      if (var6 != null && !var4.isEmpty() && var8 > 1) {
         eqc var27 = new eqc(var2, var3, var8);
         var27.eqd.addAll(var4);
         var27.eqe.addAll(var5);
         var27.eqf = var6;
         var27.eqg = var7 != null ? var7 : new float[var8];
         var27.eqh = var12;
         return var27;
      } else {
         throw new IllegalArgumentException(a.b("荦𢡄瀎\uee73斦\ue30a奅킽仳쑓䏅맳㜱꺓ⓑꈸ", -1662876897));
      }
   }

   static int eqs(int var0, int var1) {
      if (var1 != 1) {
         throw new IllegalArgumentException(a.d("Ἴ暀\uec53牬麟罏씐䳯튿堒\udf95", -1324712268, 1724932576) + var1);
      } else {
         return var0;
      }
   }

   static float[][] eqt(float[] var0, int var1, int var2, int var3) {
      int var4 = 4 * var2;
      float[][] var5 = new float[var1 * var3][var4];

      for (int var6 = 0; var6 < var1; var6++) {
         for (int var7 = 0; var7 < var4; var7++) {
            int var8 = (var6 * var4 + var7) * var3;

            for (int var9 = 0; var9 < var3; var9++) {
               var5[var6 * var3 + var9][var7] = var0[var8 + var9];
            }
         }
      }

      return var5;
   }

   static float[] equ(float[] var0, int var1, int var2) {
      float[] var3 = new float[var0.length];

      for (int var4 = 0; var4 < var1; var4++) {
         for (int var5 = 0; var5 < var2; var5++) {
            var3[var5 * var1 + var4] = var0[var4 * var2 + var5];
         }
      }

      return var3;
   }

   static epz eqv(Map<String, epz> var0, epj var1, int var2) {
      epz var3 = var2 < var1.inputs.size() ? (epz)var0.get(var1.inputs.get(var2)) : null;
      if (var3 != null && var3.data != null) {
         return var3;
      } else {
         throw new IllegalArgumentException(var1.op + a.c(-68838459, "鯢\ue21a棎\uf6a1絳\ufbc3䇄") + var2);
      }
   }
}
