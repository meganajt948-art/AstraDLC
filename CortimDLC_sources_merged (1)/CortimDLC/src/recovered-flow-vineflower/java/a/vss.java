package a;

import flow.dev.a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.stb.STBVorbis;
import org.lwjgl.stb.STBVorbisInfo;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

public final class vss {
   static final String vst = a.d("添ᐃ黚¨譧ඎ랁㹬ꀩ⪃굚圼\ud9b7䁞쨟䳪\uf6b0祽\ue3c3斅\uec2f", -1688326928, 1339048241);
   static final String vsu = a.b("哣ⴜ\ua7cd㦽뉫", -1327475515);
   static final String[] vsv = new String[]{
      a.b("\u20f8奕펛䷱올䂜齃猄\ued6a某\ue007ᩥ钟ീ", 1995776130),
      a.d("ᬗ抺\ue874瘞ﷃ筳섷䣫횅尿\udbe8↊꽰㚬", 1099057152, -632597651),
      a.d("\ue56f鳂ᘌ衦λ蔋㽏뚓⣽ꉇ▐\udff2儈죕", -1586868824, 68200637),
      a.b("쟬빁㒏ꫥℸꞈ᷌鐐\u0a7e胄ܓﵱ王\uea51", -999897194)
   };
   static final String[] vsw = new String[]{
      a.c(-955375416, "₱夜폒䶸왥䃕晴獍\ued20枕\ue04bᨁ钸"), a.b("理ණ蝥ᤏ鋒ᑢ긦⟺릗㌢듼亶쀌", 1986950271), a.c(1505689712, "\n禧\uf369洃\ue6de恮\uda2a叶춘䜢샵㪗둭\u2db7")
   };
   static final String[] vsx = new String[]{
      a.d("驺\ue3d7椙\uf773粮羽䁚즆埠\udd56媖ꃊ\u2e73", 378718543, 431706956),
      a.c(1272690235, "뙂쿯䔡\udb4b傖혦汢\ue5be篘\uf16e皮賲Ɉ"),
      a.c(290758556, "鿥\ue648沆\uf2ec礱ﾁ䗅찙剿\ud8c9弉ꕕ⯮"),
      a.d("䫹㍔릚⟰갭⪝郙ᤅ蝨ෝ訃灉ﻳ", -2110018199, 723511273)
   };
   static final String[] vsy = new String[]{
      a.c(751298123, "\ue632龟ᕑ謻æ虖㰒뗎⮨ꄞ⛞\udc82刻"),
      a.b("襛\uf0f6稸\ue452澏\ue93f卻\udaa7䓁칷䦷돫㵑", 1010403618),
      a.b("산뤝㏓궹♤ꃔ᪐鍌ഡ螔J切璺", -1289568055),
      a.d("仇㝪붤⏎ꠓ⺣铧ᴻ荖ৣ踽瑷龜", -1230602999, -1891355721)
   };
   static final float[][] vsz = new float[][]{{0.7071F, 0.7071F}, {-0.7071F, 0.7071F}, {-0.7071F, -0.7071F}, {0.7071F, -0.7071F}};
   static final int vta = 4;
   static final int vtb = 6;
   static final int vtc = 787;
   static final BlockingQueue<vrs> vtd = new ArrayBlockingQueue<>(16);
   static final Random vte = new Random();
   static volatile float vtf;
   static volatile float vtg;
   static volatile float vth;
   static volatile float[] vti = new float[]{1.0F, 1.0F, 1.0F, 1.0F};
   static volatile float vtj;
   static volatile float vtk = 1.0F;
   static volatile long vtl;
   static volatile String vtm = "";
   static volatile boolean vtn;
   static volatile boolean vto;
   static volatile boolean vtp;
   static volatile String vtq = a.d("磃ſ认ᗜ", 1830770114, 1844194668);
   static Thread vtr;

   vss() {
   }

   public static void listener(float var0) {
      double var1 = Math.toRadians(var0);
      vtj = (float)(-Math.sin(var1));
      vtk = (float)Math.cos(var1);
   }

   public static void rain(float var0, float var1, float var2, float[] var3) {
      if (!vtp) {
         vtf = var0;
         vtg = var1;
         vth = var2;
         if (var3 != null && var3.length >= 4) {
            vti = (float[])var3.clone();
         }

         vtl = System.nanoTime();

         try {
            MinecraftClient var4 = MinecraftClient.getInstance();
            if (var4.options != null) {
               String var5 = var4.options.getSoundDevice().getValue();
               vtm = var5 == null ? "" : var5;
               vtn = Boolean.TRUE.equals(var4.options.getDirectionalAudio().getValue());
            }
         } catch (Throwable var6) {
         }

         if (var0 > 0.001F || var1 > 0.001F) {
            vtv();
         }
      }
   }

   public static void thunder(float var0, boolean var1, float var2, float var3, float var4) {
      if (!vtp && !(var4 <= 0.001F)) {
         String[] var5 = var0 < 650.0F ? vsv : (var0 < 1400.0F ? vsw : vsx);
         if (!var1 && var5 == vsv) {
            var5 = vsw;
         }

         String var6 = var5[vte.nextInt(var5.length)];
         float var7 = var4 * Math.max(0.28F, Math.min(1.0F, 1.25F - var0 / 3600.0F));
         float var8 = 0.92F + 0.12F * vte.nextFloat() - Math.min(0.08F, var0 / 40000.0F);
         float var9 = Math.max(0.12F, Math.min(1.0F, 1.15F - var0 / 2600.0F));
         float var10 = vtu(300.0F, 3000.0F, var0);
         float var11 = 0.35F + 0.45F * var10;
         long var12 = System.nanoTime();
         vtv();
         vtd.offer(new vrs(var6, var7 * (1.0F - 0.25F * var10), var2, var3, var8, var9, var11, var12));
         if (var0 < 2200.0F) {
            double var14 = (vte.nextBoolean() ? 1.0 : -1.0) * (0.35 + 0.45 * vte.nextDouble());
            double var16 = Math.atan2(var3, var2) + var14;
            String var18 = vsy[vte.nextInt(vsy.length)];
            long var19 = (long)((0.3 + 0.25 * var10 + 0.6 * vte.nextDouble()) * 1.0E9);
            vtd.offer(
               new vrs(
                  var18,
                  var7 * (var1 ? 0.55F : 0.42F),
                  (float)Math.cos(var16),
                  (float)Math.sin(var16),
                  var8 * (0.8F + 0.06F * vte.nextFloat()),
                  var9 * 0.4F,
                  Math.min(1.0F, var11 + 0.25F),
                  var12 + var19
               )
            );
         }
      }
   }

   public static String report() {
      return vtq;
   }

   public static void shutdown() {
      Thread var0;
      synchronized (vss.class) {
         var0 = vtr;
         vto = true;
         vtp = true;
      }

      if (var0 != null) {
         try {
            var0.join(1000L);
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
         }
      }
   }

   static float vtu(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   static synchronized void vtv() {
      if (vtr == null && !vto) {
         vtr = new Thread(vss::vtw, a.d("沙ᔂ鿒ƻ訩ಊ뚎㽭ꄶ⮒걝嘡\ud8e1䄂쬂䷯\uf7ba硰\ue2c9撏", -526817547, -57996738));
         vtr.setDaemon(true);
         vtr.start();
      }
   }

   static void vtw() {
      vsj var0 = null;
      String var1 = null;
      boolean var2 = false;
      long var3 = System.nanoTime();
      long var5 = var3;

      while (!vto) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var20) {
            break;
         }

         long var7 = System.nanoTime();
         float var9 = Math.min(0.2F, (float)(var7 - var3) / 1.0E9F);
         var3 = var7;
         boolean var10 = var7 - vtl > 400000000L;
         float var11 = var10 ? 0.0F : vtf;
         float var12 = var10 ? 0.0F : vtg;

         try {
            if (var0 != null && (!var0.connected() || !vtm.equals(var1) || vtn != var2)) {
               var0.close();
               var0 = null;
            }

            if (var0 == null) {
               if (var11 <= 0.001F && var12 <= 0.001F && vtd.isEmpty()) {
                  continue;
               }

               var1 = vtm;
               var2 = vtn;
               var0 = vsj.open(var1, var2);
            }

            var0.update(var9, var11, var12, var10 ? 0.0F : vth, vti, vtj, vtk);

            vrs var13;
            while ((var13 = vtd.poll()) != null) {
               var0.pending.add(var13);
            }

            var0.fire(var7);
            vtq = var0.describe();
            if (!(var11 > 0.001F) && !(var12 > 0.001F) && !var0.busy()) {
               if (var7 - var5 > 20000000000L) {
                  var0.close();
                  var0 = null;
               }
            } else {
               var5 = var7;
            }
         } catch (Throwable var21) {
            if (var0 != null) {
               try {
                  var0.close();
               } catch (Throwable var18) {
               }

               var0 = null;
            }

            if (var21 instanceof LinkageError || var21 instanceof NullPointerException || var21 instanceof UnsupportedOperationException) {
               vtp = true;
               System.out.println(a.b("ヌ䥯쎸巜혗傫\ueaef捌﵀短\uf024\u0a4e蒓ᴵ霵ᆑꯅ␛뺿㣹넆쭒䗬\ude3e塏튗死\ue530", 1746808999) + var21);
               break;
            }

            System.out.println(a.c(2063479278, "\u318f䠬싻岟흔凨\uebac戏ﰃ皮\uf167\u0b0d藐ᰥ阰\u10c6ꪁ╕뿯㦿뀖쩝") + var21);

            try {
               Thread.sleep(3000L);
            } catch (InterruptedException var19) {
               break;
            }
         }
      }

      if (var0 != null) {
         try {
            var0.close();
         } catch (Throwable var17) {
         }
      }

      synchronized (vss.class) {
         vtr = null;
      }
   }

   static vsd vtx(String var0) {
      try (InputStream var1 = ezj.open(a.b("鼴\ue6cc氕\uf267禨ａ䕎첣勦\ud84c徕ꗳ⭸늑㣐븥ѿ讲ᄌ靊Ỡ", 1083416334) + var0 + a.b("⽒嚢\udc79䈈", -28102792))) {
         if (var1 == null) {
            return null;
         }

         byte[] var2 = var1.readAllBytes();
         ByteBuffer var3 = MemoryUtil.memAlloc(var2.length);

         try {
            MemoryStack var4 = MemoryStack.stackPush();

            Object var38;
            label313: {
               vsd var13;
               label314: {
                  Object var11;
                  try {
                     var3.put(var2).flip();
                     IntBuffer var5 = var4.mallocInt(1);
                     long var6 = STBVorbis.stb_vorbis_open_memory(var3, var5, null);
                     if (var6 == 0L) {
                        var38 = null;
                        break label313;
                     }

                     try {
                        STBVorbisInfo var8 = STBVorbisInfo.malloc(var4);
                        STBVorbis.stb_vorbis_get_info(var6, var8);
                        int var9 = var8.channels();
                        int var10 = STBVorbis.stb_vorbis_stream_length_in_samples(var6);
                        if (var9 >= 1 && var9 <= 2 && var10 > 0) {
                           ShortBuffer var39 = MemoryUtil.memAllocShort(var10 * var9);
                           int var12 = STBVorbis.stb_vorbis_get_samples_short_interleaved(var6, var9, var39);
                           var39.limit(Math.max(0, var12) * var9);
                           var13 = new vsd(var39, var9, var8.sample_rate());
                           break label314;
                        }

                        var11 = null;
                     } finally {
                        STBVorbis.stb_vorbis_close(var6);
                     }
                  } catch (Throwable var33) {
                     if (var4 != null) {
                        try {
                           var4.close();
                        } catch (Throwable var31) {
                           var33.addSuppressed(var31);
                        }
                     }

                     throw var33;
                  }

                  if (var4 != null) {
                     var4.close();
                  }

                  return (vsd)var11;
               }

               if (var4 != null) {
                  var4.close();
               }

               return var13;
            }

            if (var4 != null) {
               var4.close();
            }

            return (vsd)var38;
         } finally {
            MemoryUtil.memFree(var3);
         }
      } catch (Exception var36) {
         System.out.println(a.c(679209354, "\ue9f0遃\u1a9f蒧༣视㏙먫⑺껎⥙퍿嶺쐏义좤狦ﴠ柁\ue1c3栨ባ鳋ܐ脫") + var0 + a.b("ං琩", -1217262150) + var36);
         return null;
      }
   }

   static vsd vty(vsd var0) {
      if (var0.channels() == 1) {
         return var0;
      }

      ShortBuffer var1 = var0.data();
      int var2 = var1.remaining() / 2;
      ShortBuffer var3 = MemoryUtil.memAllocShort(var2);

      for (int var4 = 0; var4 < var2; var4++) {
         var3.put(var4, (short)((var1.get(var4 * 2) + var1.get(var4 * 2 + 1)) / 2));
      }

      MemoryUtil.memFree(var1);
      return new vsd(var3, 1, var0.rate());
   }
}
