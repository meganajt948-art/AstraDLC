/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.system.MemoryStack
 *  org.lwjgl.system.MemoryUtil
 */
package a;

import a.wjh;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

final class wet
implements AutoCloseable {
    private static final String weu = "ole32.dll";
    private static final String wev = "mfplat.dll";
    private static final String wew = "mfreadwrite.dll";
    private static final String wex = "shlwapi.dll";
    private static final String wey = "d3d11.dll";
    private static final long wez = 0xFFFFFFFCL;
    private static final long wfa = 0xFFFFFFFEL;
    private static final int wfb = 131184;
    private static final int wfc = 2;
    private static final int wfd = 1;
    private static final int wfe = 32;
    private static final int wff = 7;
    private static final int wfg = 8;
    private static final int wfh = 15;
    private static final int wfi = 21;
    private static final int wfj = 24;
    private static final int wfk = 25;
    private static final int wfl = 27;
    private static final int wfm = 4;
    private static final int wfn = 6;
    private static final int wfo = 7;
    private static final int wfp = 8;
    private static final int wfq = 9;
    private static final int wfr = 40;
    private static final int wfs = 3;
    private static final int wft = 4;
    private static final int wfu = 3;
    private static final int wfv = 4;
    private static final int wfw = 5;
    private static final int wfx = 7;
    private static final String wfy = "2cd2d921-c447-44a7-a13c-4adabfc247e3";
    private static final String wfz = "7dc9d5f9-9ed9-44ec-9bbf-0600bb589fbb";
    private static final String wga = "9b7e4e00-342c-4106-a19f-4f2704f689f0";
    private static final String wgb = "fc358289-3cb6-460c-a424-b6681260375a";
    private static final String wgc = "ec822da2-e1e9-4b29-a0d8-563c719f5269";
    private static final String wgd = "a634a91c-822b-41b9-a494-4de4643612b0";
    private static final String wge = "48eba18e-f8c9-4687-bf11-0a74c9f96a8f";
    private static final String wgf = "f7e34c9a-42e8-4714-b74b-cb29d72c35e5";
    private static final String wgg = "1652c33d-d6b2-4012-b834-72030849a37d";
    private static final String wgh = "644b4e48-1e02-4516-b0eb-c01ca9d49ac6";
    private static final String wgi = "d7388766-18fe-48c6-a177-ee894867c8c4";
    private static final String wgj = "73646976-0000-0010-8000-00aa00389b71";
    private static final String wgk = "3231564e-0000-0010-8000-00aa00389b71";
    private static final String wgl = "00000000-0000-0000-0000-000000000000";
    final boolean hardware;
    int width;
    int height;
    private int wgm;
    private int wgn;
    private int wgo;
    private int wgp;
    private long wgq;
    private long wgr;
    private long wgs;
    private long wgt;
    private long wgu;
    private long wgv;
    private long wgw;
    private static /* synthetic */ int wgx;
    private static /* synthetic */ int wgy;

    static void startThread() throws IOException {
        wjh.check((int)wjh.call(wjh.function(weu, "CoInitializeEx"), 0L, 0L), "CoInitializeEx");
        wjh.check((int)wjh.call(wjh.function(wev, "MFStartup"), 131184L, 0L), "MFStartup");
    }

    static void endThread() {
        try {
            wjh.call(wjh.function(wev, "MFShutdown"), new long[0]);
            wjh.call(wjh.function(weu, "CoUninitialize"), new long[0]);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    wet(byte[] byArray, boolean bl) throws IOException {
        this.hardware = bl;
        try {
            this.wgz(byArray);
        }
        catch (IOException | RuntimeException exception) {
            this.close();
            throw exception;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void wgz(byte[] byArray) throws IOException {
        long l = MemoryUtil.nmemAlloc((long)byArray.length);
        try {
            MemoryUtil.memByteBuffer((long)l, (int)byArray.length).put(byArray);
            this.wgq = wjh.call(wjh.function(wex, "SHCreateMemStream"), l, byArray.length);
        }
        finally {
            MemoryUtil.nmemFree((long)l);
        }
        if (this.wgq == 0L) {
            throw new IOException("SHCreateMemStream failed");
        }
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l2 = memoryStack.ncalloc(8, 1, 8);
            wjh.check((int)wjh.call(wjh.function(wev, "MFCreateMFByteStreamOnStream"), this.wgq, l2), "MFCreateMFByteStreamOnStream");
            this.wgr = MemoryUtil.memGetAddress((long)l2);
            long l3 = wjh.query(this.wgr, wfy);
            try {
                wjh.check(wjh.com(l3, 25, wjh.guid(wgb), MemoryUtil.memAddress((ByteBuffer)memoryStack.UTF16((CharSequence)"video/mp4"))), "content type");
            }
            finally {
                wjh.release(l3);
            }
            MemoryUtil.memPutAddress((long)l2, (long)0L);
            wjh.check((int)wjh.call(wjh.function(wev, "MFCreateAttributes"), l2, 4L), "MFCreateAttributes");
            this.wgs = MemoryUtil.memGetAddress((long)l2);
            if (this.hardware) {
                this.wha(memoryStack);
            }
            MemoryUtil.memPutAddress((long)l2, (long)0L);
            wjh.check((int)wjh.call(wjh.function(wew, "MFCreateSourceReaderFromByteStream"), this.wgr, this.wgs, l2), "MFCreateSourceReaderFromByteStream");
            this.wgt = MemoryUtil.memGetAddress((long)l2);
            wjh.check(wjh.com(this.wgt, 4, 0xFFFFFFFEL, 0L), "deselect streams");
            wjh.check(wjh.com(this.wgt, 4, 0xFFFFFFFCL, 1L), "select video");
            MemoryUtil.memPutAddress((long)l2, (long)0L);
            wjh.check((int)wjh.call(wjh.function(wev, "MFCreateMediaType"), l2), "MFCreateMediaType");
            long l4 = MemoryUtil.memGetAddress((long)l2);
            try {
                wjh.check(wjh.com(l4, 24, wjh.guid(wge), wjh.guid(wgj)), "major type");
                wjh.check(wjh.com(l4, 24, wjh.guid(wgf), wjh.guid(wgk)), "subtype");
                wjh.check(wjh.com(this.wgt, 7, 0xFFFFFFFCL, 0L, l4), "NV12 output");
            }
            finally {
                wjh.release(l4);
            }
        }
        this.whb();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void wha(MemoryStack memoryStack) throws IOException {
        long l = memoryStack.ncalloc(8, 1, 8);
        long l2 = memoryStack.ncalloc(4, 1, 4);
        long l3 = memoryStack.ncalloc(8, 1, 8);
        wjh.check((int)wjh.call(wjh.function(wey, "D3D11CreateDevice"), 0L, 1L, 0L, 2080L, 0L, 0L, 7L, l, l2, l3), "D3D11CreateDevice");
        this.wgu = MemoryUtil.memGetAddress((long)l);
        this.wgv = MemoryUtil.memGetAddress((long)l3);
        long l4 = wjh.query(this.wgu, wga);
        try {
            wjh.com(l4, 5, 1L);
        }
        finally {
            wjh.release(l4);
        }
        long l5 = memoryStack.ncalloc(4, 1, 4);
        MemoryUtil.memPutAddress((long)l, (long)0L);
        wjh.check((int)wjh.call(wjh.function(wev, "MFCreateDXGIDeviceManager"), l5, l), "MFCreateDXGIDeviceManager");
        this.wgw = MemoryUtil.memGetAddress((long)l);
        wjh.check(wjh.com(this.wgw, 7, this.wgu, (long)MemoryUtil.memGetInt((long)l5) & 0xFFFFFFFFL), "ResetDevice");
        wjh.check(wjh.com(this.wgs, 27, wjh.guid(wgc), this.wgw), "D3D manager");
        wjh.check(wjh.com(this.wgs, 21, wjh.guid(wgd), 1L), "hardware transforms");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void whb() throws IOException {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l = memoryStack.ncalloc(8, 1, 8);
            wjh.check(wjh.com(this.wgt, 6, 0xFFFFFFFCL, l), "GetCurrentMediaType");
            long l2 = MemoryUtil.memGetAddress((long)l);
            try {
                long l3 = memoryStack.ncalloc(8, 1, 8);
                wjh.check(wjh.com(l2, 8, wjh.guid(wgg), l3), "frame size");
                long l4 = MemoryUtil.memGetLong((long)l3);
                int n = (int)(l4 >>> 32);
                this.wgm = (int)l4;
                long l5 = memoryStack.ncalloc(4, 1, 4);
                this.wgn = wjh.com(l2, 7, wjh.guid(wgh), l5) >= 0 ? Math.abs(MemoryUtil.memGetInt((long)l5)) : n;
                long l6 = memoryStack.ncalloc(4, 4, 4);
                long l7 = memoryStack.ncalloc(4, 1, 4);
                if (wjh.com(l2, 15, wjh.guid(wgi), l6, 16L, l7) >= 0) {
                    this.wgo = MemoryUtil.memGetShort((long)(l6 + 2L));
                    this.wgp = MemoryUtil.memGetShort((long)(l6 + 6L));
                    this.width = MemoryUtil.memGetInt((long)(l6 + 8L));
                    this.height = MemoryUtil.memGetInt((long)(l6 + 12L));
                } else {
                    this.wgo = 0;
                    this.wgp = 0;
                    this.width = n;
                    this.height = this.wgm;
                }
                this.width &= 0xFFFFFFFE;
                this.height &= 0xFFFFFFFE;
                if (this.width <= 0 || this.height <= 0 || this.wgo + this.width > n || this.wgp + this.height > this.wgm) {
                    throw new IOException("odd frame " + n + "x" + this.wgm + " / " + this.width + "x" + this.height);
                }
            }
            finally {
                wjh.release(l2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    long read(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
        while (true) {
            MemoryStack memoryStack = MemoryStack.stackPush();
            try {
                long l;
                long l2;
                block17: {
                    block16: {
                        long l3;
                        long l4 = memoryStack.ncalloc(4, 1, 4);
                        long l5 = memoryStack.ncalloc(4, 1, 4);
                        l2 = memoryStack.ncalloc(8, 1, 8);
                        long l6 = memoryStack.ncalloc(8, 1, 8);
                        wjh.check(wjh.com(this.wgt, 9, 0xFFFFFFFCL, 0L, l4, l5, l2, l6), "ReadSample");
                        int n = MemoryUtil.memGetInt((long)l5);
                        l = MemoryUtil.memGetAddress((long)l6);
                        try {
                            if ((n & 1) != 0) {
                                throw new IOException("stream error");
                            }
                            if ((n & 0x20) != 0) {
                                this.whb();
                            }
                            if ((n & 2) == 0) break block16;
                            l3 = -1L;
                        }
                        catch (Throwable throwable) {
                            wjh.release(l);
                            throw throwable;
                        }
                        wjh.release(l);
                        return l3;
                    }
                    if (l != 0L) break block17;
                    wjh.release(l);
                    continue;
                }
                if (byteBuffer.capacity() < this.width * this.height || byteBuffer2.capacity() < this.width * this.height / 2) {
                    throw new IOException("frame buffers too small");
                }
                this.whc(l, MemoryUtil.memAddress0((Buffer)byteBuffer), MemoryUtil.memAddress0((Buffer)byteBuffer2));
                long l7 = MemoryUtil.memGetLong((long)l2);
                wjh.release(l);
                return l7;
            }
            finally {
                if (memoryStack == null) continue;
                memoryStack.close();
                continue;
            }
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void whc(long l, long l2, long l3) throws IOException {
        block21: {
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                long l4 = memoryStack.ncalloc(8, 1, 8);
                wjh.check(wjh.com(l, 40, 0L, l4), "GetBufferByIndex");
                long l5 = MemoryUtil.memGetAddress((long)l4);
                try {
                    long l6 = 0L;
                    try {
                        l6 = wjh.query(l5, wfz);
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                    long l7 = memoryStack.ncalloc(8, 1, 8);
                    if (l6 != 0L) {
                        try {
                            long l8 = memoryStack.ncalloc(4, 1, 4);
                            wjh.check(wjh.com(l6, 3, l7, l8), "Lock2D");
                            try {
                                this.whd(MemoryUtil.memGetAddress((long)l7), MemoryUtil.memGetInt((long)l8), l2, l3);
                                break block21;
                            }
                            finally {
                                wjh.com(l6, 4, new long[0]);
                            }
                        }
                        finally {
                            wjh.release(l6);
                        }
                    }
                    wjh.check(wjh.com(l5, 3, l7, 0L, 0L), "Lock");
                    try {
                        this.whd(MemoryUtil.memGetAddress((long)l7), this.wgn, l2, l3);
                    }
                    finally {
                        wjh.com(l5, 4, new long[0]);
                    }
                }
                finally {
                    wjh.release(l5);
                }
            }
        }
    }

    private void whd(long l, int n, long l2, long l3) throws IOException {
        if (n < this.width) {
            throw new IOException("pitch " + n);
        }
        long l4 = l + (long)this.wgp * (long)n + (long)this.wgo;
        for (int i = 0; i < this.height; ++i) {
            MemoryUtil.memCopy((long)(l4 + (long)i * (long)n), (long)(l2 + (long)i * (long)this.width), (long)this.width);
        }
        long l5 = l + (long)this.wgm * (long)n + (long)(this.wgp / 2) * (long)n + (long)this.wgo;
        for (int i = 0; i < this.height / 2; ++i) {
            MemoryUtil.memCopy((long)(l5 + (long)i * (long)n), (long)(l3 + (long)i * (long)this.width), (long)this.width);
        }
    }

    void rewind() throws IOException {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l = memoryStack.ncalloc(8, 3, 8);
            MemoryUtil.memPutShort((long)l, (short)20);
            wjh.check(wjh.com(this.wgt, 8, wjh.guid(wgl), l), "SetCurrentPosition");
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
        this.wgq = 0L;
        this.wgr = 0L;
        this.wgu = 0L;
        this.wgv = 0L;
        this.wgw = 0L;
        this.wgs = 0L;
        this.wgt = 0L;
    }

    private static /* synthetic */ int dqe(int n, int n2) {
        return n + n2 | 0x34688999;
    }

    private static /* synthetic */ int dqf(int n, int n2) {
        return n ^ n2 | 0x2686271B;
    }
}

