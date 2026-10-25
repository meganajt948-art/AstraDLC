package a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;
import org.lwjgl.system.windows.WindowsLibrary;

final class wjh {
   private static final int wji = 12;
   private static final FFICIF[] wjj = new FFICIF[13];
   private static final Map<String, SharedLibrary> wjk = new HashMap<>();
   private static final Map<String, Long> wjl = new HashMap<>();
   private static final Map<String, Long> wjm = new HashMap<>();
   static final int QUERY_INTERFACE = 0;
   static final int RELEASE = 2;

   private wjh() {
   }

   static boolean available() {
      return System.getProperty("os.name", "").toLowerCase().startsWith("windows") && "amd64".equals(System.getProperty("os.arch"));
   }

   static synchronized long function(String var0, String var1) throws IOException {
      String var2 = var0 + "!" + var1;
      Long var3 = wjl.get(var2);
      if (var3 != null) {
         return var3;
      }

      Object var4 = wjk.get(var0);
      if (var4 == null) {
         try {
            var4 = new WindowsLibrary(var0);
         } catch (Throwable var7) {
            throw new IOException("can't load " + var0 + ": " + var7.getMessage());
         }

         wjk.put(var0, (SharedLibrary)var4);
      }

      long var5 = var4.getFunctionAddress(var1);
      if (var5 == 0L) {
         throw new IOException(var0 + " has no " + var1);
      }

      wjl.put(var2, var5);
      return var5;
   }

   static synchronized long guid(String var0) {
      Long var1 = wjm.get(var0);
      if (var1 != null) {
         return var1;
      }

      String var2 = var0.replace("-", "");
      long var3 = MemoryUtil.nmemAlloc(16L);
      MemoryUtil.memPutInt(var3, (int)Long.parseLong(var2.substring(0, 8), 16));
      MemoryUtil.memPutShort(var3 + 4L, (short)Integer.parseInt(var2.substring(8, 12), 16));
      MemoryUtil.memPutShort(var3 + 6L, (short)Integer.parseInt(var2.substring(12, 16), 16));

      for (int var5 = 0; var5 < 8; var5++) {
         MemoryUtil.memPutByte(var3 + 8L + var5, (byte)Integer.parseInt(var2.substring(16 + var5 * 2, 18 + var5 * 2), 16));
      }

      wjm.put(var0, var3);
      return var3;
   }

   private static synchronized FFICIF wjp(int var0) {
      FFICIF var1 = wjj[var0];
      if (var1 == null) {
         var1 = FFICIF.calloc();
         PointerBuffer var2 = MemoryUtil.memAllocPointer(Math.max(1, var0));

         for (int var3 = 0; var3 < var0; var3++) {
            var2.put(var3, LibFFI.ffi_type_uint64.address());
         }

         int var4 = LibFFI.nffi_prep_cif(var1.address(), LibFFI.FFI_DEFAULT_ABI, var0, LibFFI.ffi_type_sint64.address(), var2.address());
         if (var4 != 0) {
            throw new IllegalStateException("ffi_prep_cif " + var4);
         }

         wjj[var0] = var1;
      }

      return var1;
   }

   static long call(long var0, long... var2) {
      if (var2.length > 12) {
         throw new IllegalArgumentException("too many arguments");
      }

      FFICIF var3 = wjp(var2.length);
      MemoryStack var4 = MemoryStack.stackPush();

      long var9;
      try {
         long var5 = var4.nmalloc(8, Math.max(1, var2.length) * 8);
         PointerBuffer var7 = var4.mallocPointer(Math.max(1, var2.length));

         for (int var8 = 0; var8 < var2.length; var8++) {
            MemoryUtil.memPutLong(var5 + 8L * var8, var2[var8]);
            var7.put(var8, var5 + 8L * var8);
         }

         ByteBuffer var13 = var4.calloc(8, 8);
         LibFFI.ffi_call(var3, var0, var13, var7);
         var9 = MemoryUtil.memGetLong(MemoryUtil.memAddress(var13));
      } catch (Throwable var12) {
         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var11) {
               var12.addSuppressed(var11);
            }
         }

         throw var12;
      }

      if (var4 != null) {
         var4.close();
      }

      return var9;
   }

   static int com(long var0, int var2, long... var3) {
      long[] var4 = new long[var3.length + 1];
      var4[0] = var0;
      System.arraycopy(var3, 0, var4, 1, var3.length);
      long var5 = MemoryUtil.memGetAddress(var0);
      return (int)call(MemoryUtil.memGetAddress(var5 + 8L * var2), var4);
   }

   static long query(long var0, String var2) throws IOException {
      MemoryStack var3 = MemoryStack.stackPush();

      long var6;
      try {
         long var4 = var3.ncalloc(8, 1, 8);
         check(com(var0, 0, guid(var2), var4), "QueryInterface " + var2);
         var6 = MemoryUtil.memGetAddress(var4);
      } catch (Throwable var9) {
         if (var3 != null) {
            try {
               var3.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }
         }

         throw var9;
      }

      if (var3 != null) {
         var3.close();
      }

      return var6;
   }

   static void release(long var0) {
      if (var0 != 0L) {
         com(var0, 2);
      }
   }

   static void check(int var0, String var1) throws IOException {
      if (var0 < 0) {
         throw new IOException(var1 + " failed: 0x" + Integer.toHexString(var0));
      }
   }
}
