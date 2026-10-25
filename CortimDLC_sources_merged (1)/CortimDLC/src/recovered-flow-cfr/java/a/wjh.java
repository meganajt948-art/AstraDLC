/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.PointerBuffer
 *  org.lwjgl.system.MemoryStack
 *  org.lwjgl.system.MemoryUtil
 *  org.lwjgl.system.SharedLibrary
 *  org.lwjgl.system.libffi.FFICIF
 *  org.lwjgl.system.libffi.LibFFI
 *  org.lwjgl.system.windows.WindowsLibrary
 */
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
    private static final Map<String, SharedLibrary> wjk = new HashMap<String, SharedLibrary>();
    private static final Map<String, Long> wjl = new HashMap<String, Long>();
    private static final Map<String, Long> wjm = new HashMap<String, Long>();
    static final int QUERY_INTERFACE = 0;
    static final int RELEASE = 2;
    private static /* synthetic */ String wjn;
    private static /* synthetic */ int wjo;

    private wjh() {
    }

    static boolean available() {
        return System.getProperty("os.name", "").toLowerCase().startsWith("windows") && "amd64".equals(System.getProperty("os.arch"));
    }

    static synchronized long function(String string, String string2) throws IOException {
        long l;
        String string3 = string + "!" + string2;
        Long l2 = wjl.get(string3);
        if (l2 != null) {
            return l2;
        }
        SharedLibrary sharedLibrary = wjk.get(string);
        if (sharedLibrary == null) {
            try {
                sharedLibrary = new WindowsLibrary(string);
            }
            catch (Throwable throwable) {
                throw new IOException("can't load " + string + ": " + throwable.getMessage());
            }
            wjk.put(string, sharedLibrary);
        }
        if ((l = sharedLibrary.getFunctionAddress((CharSequence)string2)) == 0L) {
            throw new IOException(string + " has no " + string2);
        }
        wjl.put(string3, l);
        return l;
    }

    static synchronized long guid(String string) {
        Long l = wjm.get(string);
        if (l != null) {
            return l;
        }
        String string2 = string.replace("-", "");
        long l2 = MemoryUtil.nmemAlloc((long)16L);
        MemoryUtil.memPutInt((long)l2, (int)((int)Long.parseLong(string2.substring(0, 8), 16)));
        MemoryUtil.memPutShort((long)(l2 + 4L), (short)((short)Integer.parseInt(string2.substring(8, 12), 16)));
        MemoryUtil.memPutShort((long)(l2 + 6L), (short)((short)Integer.parseInt(string2.substring(12, 16), 16)));
        for (int i = 0; i < 8; ++i) {
            MemoryUtil.memPutByte((long)(l2 + 8L + (long)i), (byte)((byte)Integer.parseInt(string2.substring(16 + i * 2, 18 + i * 2), 16)));
        }
        wjm.put(string, l2);
        return l2;
    }

    private static synchronized FFICIF wjp(int n) {
        FFICIF fFICIF = wjj[n];
        if (fFICIF == null) {
            int n2;
            fFICIF = FFICIF.calloc();
            PointerBuffer pointerBuffer = MemoryUtil.memAllocPointer((int)Math.max(1, n));
            for (n2 = 0; n2 < n; ++n2) {
                pointerBuffer.put(n2, LibFFI.ffi_type_uint64.address());
            }
            n2 = LibFFI.nffi_prep_cif((long)fFICIF.address(), (int)LibFFI.FFI_DEFAULT_ABI, (int)n, (long)LibFFI.ffi_type_sint64.address(), (long)pointerBuffer.address());
            if (n2 != 0) {
                throw new IllegalStateException("ffi_prep_cif " + n2);
            }
            wjh.wjj[n] = fFICIF;
        }
        return fFICIF;
    }

    static long call(long l, long ... lArray) {
        if (lArray.length > 12) {
            throw new IllegalArgumentException("too many arguments");
        }
        FFICIF fFICIF = wjh.wjp(lArray.length);
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l2 = memoryStack.nmalloc(8, Math.max(1, lArray.length) * 8);
            PointerBuffer pointerBuffer = memoryStack.mallocPointer(Math.max(1, lArray.length));
            for (int i = 0; i < lArray.length; ++i) {
                MemoryUtil.memPutLong((long)(l2 + 8L * (long)i), (long)lArray[i]);
                pointerBuffer.put(i, l2 + 8L * (long)i);
            }
            ByteBuffer byteBuffer = memoryStack.calloc(8, 8);
            LibFFI.ffi_call((FFICIF)fFICIF, (long)l, (ByteBuffer)byteBuffer, (PointerBuffer)pointerBuffer);
            long l3 = MemoryUtil.memGetLong((long)MemoryUtil.memAddress((ByteBuffer)byteBuffer));
            return l3;
        }
    }

    static int com(long l, int n, long ... lArray) {
        long[] lArray2 = new long[lArray.length + 1];
        lArray2[0] = l;
        System.arraycopy(lArray, 0, lArray2, 1, lArray.length);
        long l2 = MemoryUtil.memGetAddress((long)l);
        return (int)wjh.call(MemoryUtil.memGetAddress((long)(l2 + 8L * (long)n)), lArray2);
    }

    static long query(long l, String string) throws IOException {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l2 = memoryStack.ncalloc(8, 1, 8);
            wjh.check(wjh.com(l, 0, wjh.guid(string), l2), "QueryInterface " + string);
            long l3 = MemoryUtil.memGetAddress((long)l2);
            return l3;
        }
    }

    static void release(long l) {
        if (l != 0L) {
            wjh.com(l, 2, new long[0]);
        }
    }

    static void check(int n, String string) throws IOException {
        if (n < 0) {
            throw new IOException(string + " failed: 0x" + Integer.toHexString(n));
        }
    }

    private static /* synthetic */ int dqt(int n, int n2) {
        return n * n2 | 0x54EC6A7C;
    }

    private static /* synthetic */ int dqu(int n, int n2) {
        return wjh.dqt(n, n2) ^ 0x6E8D763C;
    }
}

