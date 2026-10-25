package a;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

final class wet implements AutoCloseable {
   static final String weu = "ole32.dll";
   static final String wev = "mfplat.dll";
   static final String wew = "mfreadwrite.dll";
   static final String wex = "shlwapi.dll";
   static final String wey = "d3d11.dll";
   static final long wez = 4294967292L;
   static final long wfa = 4294967294L;
   static final int wfb = 131184;
   static final int wfc = 2;
   static final int wfd = 1;
   static final int wfe = 32;
   static final int wff = 7;
   static final int wfg = 8;
   static final int wfh = 15;
   static final int wfi = 21;
   static final int wfj = 24;
   static final int wfk = 25;
   static final int wfl = 27;
   static final int wfm = 4;
   static final int wfn = 6;
   static final int wfo = 7;
   static final int wfp = 8;
   static final int wfq = 9;
   static final int wfr = 40;
   static final int wfs = 3;
   static final int wft = 4;
   static final int wfu = 3;
   static final int wfv = 4;
   static final int wfw = 5;
   static final int wfx = 7;
   static final String wfy = "2cd2d921-c447-44a7-a13c-4adabfc247e3";
   static final String wfz = "7dc9d5f9-9ed9-44ec-9bbf-0600bb589fbb";
   static final String wga = "9b7e4e00-342c-4106-a19f-4f2704f689f0";
   static final String wgb = "fc358289-3cb6-460c-a424-b6681260375a";
   static final String wgc = "ec822da2-e1e9-4b29-a0d8-563c719f5269";
   static final String wgd = "a634a91c-822b-41b9-a494-4de4643612b0";
   static final String wge = "48eba18e-f8c9-4687-bf11-0a74c9f96a8f";
   static final String wgf = "f7e34c9a-42e8-4714-b74b-cb29d72c35e5";
   static final String wgg = "1652c33d-d6b2-4012-b834-72030849a37d";
   static final String wgh = "644b4e48-1e02-4516-b0eb-c01ca9d49ac6";
   static final String wgi = "d7388766-18fe-48c6-a177-ee894867c8c4";
   static final String wgj = "73646976-0000-0010-8000-00aa00389b71";
   static final String wgk = "3231564e-0000-0010-8000-00aa00389b71";
   static final String wgl = "00000000-0000-0000-0000-000000000000";
   final boolean hardware;
   int width;
   int height;
   int wgm;
   int wgn;
   int wgo;
   int wgp;
   long wgq;
   long wgr;
   long wgs;
   long wgt;
   long wgu;
   long wgv;
   long wgw;

   static void startThread() throws IOException {
      wjh.check((int)wjh.call(wjh.function("ole32.dll", "CoInitializeEx"), 0L, 0L), "CoInitializeEx");
      wjh.check((int)wjh.call(wjh.function("mfplat.dll", "MFStartup"), 131184L, 0L), "MFStartup");
   }

   static void endThread() {
      try {
         wjh.call(wjh.function("mfplat.dll", "MFShutdown"));
         wjh.call(wjh.function("ole32.dll", "CoUninitialize"));
      } catch (IOException var1) {
      }
   }

   wet(byte[] var1, boolean var2) throws IOException {
      this.hardware = var2;

      try {
         this.wgz(var1);
      } catch (IOException | RuntimeException var4) {
         this.close();
         throw var4;
      }
   }

   void wgz(byte[] var1) throws IOException {
      long var2 = MemoryUtil.nmemAlloc(var1.length);

      try {
         MemoryUtil.memByteBuffer(var2, var1.length).put(var1);
         this.wgq = wjh.call(wjh.function("shlwapi.dll", "SHCreateMemStream"), var2, var1.length);
      } finally {
         MemoryUtil.nmemFree(var2);
      }

      if (this.wgq == 0L) {
         throw new IOException("SHCreateMemStream failed");
      }

      MemoryStack var4 = MemoryStack.stackPush();

      try {
         long var5 = var4.ncalloc(8, 1, 8);
         wjh.check((int)wjh.call(wjh.function("mfplat.dll", "MFCreateMFByteStreamOnStream"), this.wgq, var5), "MFCreateMFByteStreamOnStream");
         this.wgr = MemoryUtil.memGetAddress(var5);
         long var7 = wjh.query(this.wgr, "2cd2d921-c447-44a7-a13c-4adabfc247e3");

         try {
            wjh.check(wjh.com(var7, 25, wjh.guid("fc358289-3cb6-460c-a424-b6681260375a"), MemoryUtil.memAddress(var4.UTF16("video/mp4"))), "content type");
         } finally {
            wjh.release(var7);
         }

         MemoryUtil.memPutAddress(var5, 0L);
         wjh.check((int)wjh.call(wjh.function("mfplat.dll", "MFCreateAttributes"), var5, 4L), "MFCreateAttributes");
         this.wgs = MemoryUtil.memGetAddress(var5);
         if (this.hardware) {
            this.wha(var4);
         }

         MemoryUtil.memPutAddress(var5, 0L);
         wjh.check(
            (int)wjh.call(wjh.function("mfreadwrite.dll", "MFCreateSourceReaderFromByteStream"), this.wgr, this.wgs, var5),
            "MFCreateSourceReaderFromByteStream"
         );
         this.wgt = MemoryUtil.memGetAddress(var5);
         wjh.check(wjh.com(this.wgt, 4, 4294967294L, 0L), "deselect streams");
         wjh.check(wjh.com(this.wgt, 4, 4294967292L, 1L), "select video");
         MemoryUtil.memPutAddress(var5, 0L);
         wjh.check((int)wjh.call(wjh.function("mfplat.dll", "MFCreateMediaType"), var5), "MFCreateMediaType");
         long var9 = MemoryUtil.memGetAddress(var5);

         try {
            wjh.check(wjh.com(var9, 24, wjh.guid("48eba18e-f8c9-4687-bf11-0a74c9f96a8f"), wjh.guid("73646976-0000-0010-8000-00aa00389b71")), "major type");
            wjh.check(wjh.com(var9, 24, wjh.guid("f7e34c9a-42e8-4714-b74b-cb29d72c35e5"), wjh.guid("3231564e-0000-0010-8000-00aa00389b71")), "subtype");
            wjh.check(wjh.com(this.wgt, 7, 4294967292L, 0L, var9), "NV12 output");
         } finally {
            wjh.release(var9);
         }
      } catch (Throwable var31) {
         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var27) {
               var31.addSuppressed(var27);
            }
         }

         throw var31;
      }

      if (var4 != null) {
         var4.close();
      }

      this.whb();
   }

   void wha(MemoryStack var1) throws IOException {
      long var2 = var1.ncalloc(8, 1, 8);
      long var4 = var1.ncalloc(4, 1, 4);
      long var6 = var1.ncalloc(8, 1, 8);
      wjh.check((int)wjh.call(wjh.function("d3d11.dll", "D3D11CreateDevice"), 0L, 1L, 0L, 2080L, 0L, 0L, 7L, var2, var4, var6), "D3D11CreateDevice");
      this.wgu = MemoryUtil.memGetAddress(var2);
      this.wgv = MemoryUtil.memGetAddress(var6);
      long var8 = wjh.query(this.wgu, "9b7e4e00-342c-4106-a19f-4f2704f689f0");

      try {
         wjh.com(var8, 5, 1L);
      } finally {
         wjh.release(var8);
      }

      long var10 = var1.ncalloc(4, 1, 4);
      MemoryUtil.memPutAddress(var2, 0L);
      wjh.check((int)wjh.call(wjh.function("mfplat.dll", "MFCreateDXGIDeviceManager"), var10, var2), "MFCreateDXGIDeviceManager");
      this.wgw = MemoryUtil.memGetAddress(var2);
      wjh.check(wjh.com(this.wgw, 7, this.wgu, MemoryUtil.memGetInt(var10) & 4294967295L), "ResetDevice");
      wjh.check(wjh.com(this.wgs, 27, wjh.guid("ec822da2-e1e9-4b29-a0d8-563c719f5269"), this.wgw), "D3D manager");
      wjh.check(wjh.com(this.wgs, 21, wjh.guid("a634a91c-822b-41b9-a494-4de4643612b0"), 1L), "hardware transforms");
   }

   void whb() throws IOException {
      MemoryStack var1 = MemoryStack.stackPush();

      try {
         long var2 = var1.ncalloc(8, 1, 8);
         wjh.check(wjh.com(this.wgt, 6, 4294967292L, var2), "GetCurrentMediaType");
         long var4 = MemoryUtil.memGetAddress(var2);

         try {
            long var6 = var1.ncalloc(8, 1, 8);
            wjh.check(wjh.com(var4, 8, wjh.guid("1652c33d-d6b2-4012-b834-72030849a37d"), var6), "frame size");
            long var8 = MemoryUtil.memGetLong(var6);
            int var10 = (int)(var8 >>> 32);
            this.wgm = (int)var8;
            long var11 = var1.ncalloc(4, 1, 4);
            this.wgn = wjh.com(var4, 7, wjh.guid("644b4e48-1e02-4516-b0eb-c01ca9d49ac6"), var11) >= 0 ? Math.abs(MemoryUtil.memGetInt(var11)) : var10;
            long var13 = var1.ncalloc(4, 4, 4);
            long var15 = var1.ncalloc(4, 1, 4);
            if (wjh.com(var4, 15, wjh.guid("d7388766-18fe-48c6-a177-ee894867c8c4"), var13, 16L, var15) >= 0) {
               this.wgo = MemoryUtil.memGetShort(var13 + 2L);
               this.wgp = MemoryUtil.memGetShort(var13 + 6L);
               this.width = MemoryUtil.memGetInt(var13 + 8L);
               this.height = MemoryUtil.memGetInt(var13 + 12L);
            } else {
               this.wgo = 0;
               this.wgp = 0;
               this.width = var10;
               this.height = this.wgm;
            }

            this.width &= -2;
            this.height &= -2;
            if (this.width <= 0 || this.height <= 0 || this.wgo + this.width > var10 || this.wgp + this.height > this.wgm) {
               throw new IOException("odd frame " + var10 + "x" + this.wgm + " / " + this.width + "x" + this.height);
            }
         } finally {
            wjh.release(var4);
         }
      } catch (Throwable var23) {
         if (var1 != null) {
            try {
               var1.close();
            } catch (Throwable var21) {
               var23.addSuppressed(var21);
            }
         }

         throw var23;
      }

      if (var1 != null) {
         var1.close();
      }
   }

   long read(ByteBuffer var1, ByteBuffer var2) throws IOException {
      while (true) {
         MemoryStack var3 = MemoryStack.stackPush();

         long var24;
         label130: {
            label131: {
               try {
                  long var4 = var3.ncalloc(4, 1, 4);
                  long var6 = var3.ncalloc(4, 1, 4);
                  long var8 = var3.ncalloc(8, 1, 8);
                  long var10 = var3.ncalloc(8, 1, 8);
                  wjh.check(wjh.com(this.wgt, 9, 4294967292L, 0L, var4, var6, var8, var10), "ReadSample");
                  int var12 = MemoryUtil.memGetInt(var6);
                  long var13 = MemoryUtil.memGetAddress(var10);

                  try {
                     if ((var12 & 1) != 0) {
                        throw new IOException("stream error");
                     }

                     if ((var12 & 32) != 0) {
                        this.whb();
                     }

                     if ((var12 & 2) != 0) {
                        var24 = -1L;
                        break label130;
                     }

                     if (var13 == 0L) {
                        break label131;
                     }

                     if (var1.capacity() < this.width * this.height || var2.capacity() < this.width * this.height / 2) {
                        throw new IOException("frame buffers too small");
                     }

                     this.whc(var13, MemoryUtil.memAddress0(var1), MemoryUtil.memAddress0(var2));
                     var24 = MemoryUtil.memGetLong(var8);
                  } finally {
                     wjh.release(var13);
                  }
               } catch (Throwable var23) {
                  if (var3 != null) {
                     try {
                        var3.close();
                     } catch (Throwable var21) {
                        var23.addSuppressed(var21);
                     }
                  }

                  throw var23;
               }

               if (var3 != null) {
                  var3.close();
               }

               return var24;
            }

            if (var3 != null) {
               var3.close();
            }
            continue;
         }

         if (var3 != null) {
            var3.close();
         }

         return var24;
      }
   }

   void whc(long var1, long var3, long var5) throws IOException {
      MemoryStack var7 = MemoryStack.stackPush();

      try {
         long var8 = var7.ncalloc(8, 1, 8);
         wjh.check(wjh.com(var1, 40, 0L, var8), "GetBufferByIndex");
         long var10 = MemoryUtil.memGetAddress(var8);

         try {
            long var12 = 0L;

            try {
               var12 = wjh.query(var10, "7dc9d5f9-9ed9-44ec-9bbf-0600bb589fbb");
            } catch (IOException var54) {
            }

            long var14 = var7.ncalloc(8, 1, 8);
            if (var12 != 0L) {
               try {
                  long var16 = var7.ncalloc(4, 1, 4);
                  wjh.check(wjh.com(var12, 3, var14, var16), "Lock2D");

                  try {
                     this.whd(MemoryUtil.memGetAddress(var14), MemoryUtil.memGetInt(var16), var3, var5);
                  } finally {
                     wjh.com(var12, 4);
                  }
               } finally {
                  wjh.release(var12);
               }
            } else {
               wjh.check(wjh.com(var10, 3, var14, 0L, 0L), "Lock");

               try {
                  this.whd(MemoryUtil.memGetAddress(var14), this.wgn, var3, var5);
               } finally {
                  wjh.com(var10, 4);
               }
            }
         } finally {
            wjh.release(var10);
         }
      } catch (Throwable var56) {
         if (var7 != null) {
            try {
               var7.close();
            } catch (Throwable var50) {
               var56.addSuppressed(var50);
            }
         }

         throw var56;
      }

      if (var7 != null) {
         var7.close();
      }
   }

   void whd(long var1, int var3, long var4, long var6) throws IOException {
      if (var3 < this.width) {
         throw new IOException("pitch " + var3);
      }

      long var8 = var1 + (long)this.wgp * var3 + this.wgo;

      for (int var10 = 0; var10 < this.height; var10++) {
         MemoryUtil.memCopy(var8 + (long)var10 * var3, var4 + (long)var10 * this.width, this.width);
      }

      long var13 = var1 + (long)this.wgm * var3 + (long)(this.wgp / 2) * var3 + this.wgo;

      for (int var12 = 0; var12 < this.height / 2; var12++) {
         MemoryUtil.memCopy(var13 + (long)var12 * var3, var6 + (long)var12 * this.width, this.width);
      }
   }

   void rewind() throws IOException {
      MemoryStack var1 = MemoryStack.stackPush();

      try {
         long var2 = var1.ncalloc(8, 3, 8);
         MemoryUtil.memPutShort(var2, (short)20);
         wjh.check(wjh.com(this.wgt, 8, wjh.guid("00000000-0000-0000-0000-000000000000"), var2), "SetCurrentPosition");
      } catch (Throwable var5) {
         if (var1 != null) {
            try {
               var1.close();
            } catch (Throwable var4) {
               var5.addSuppressed(var4);
            }
         }

         throw var5;
      }

      if (var1 != null) {
         var1.close();
      }
   }

   @Override
   public void close() {
      wjh.release(this.wgt);
      wjh.release(this.wgs);
      wjh.release(this.wgw);
      wjh.release(this.wgv);
      wjh.release(this.wgu);
      wjh.release(this.wgr);
      wjh.release(this.wgq);
      this.wgt = this.wgs = this.wgw = this.wgv = this.wgu = this.wgr = this.wgq = 0L;
   }
}
