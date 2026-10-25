/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.util.profiler.Recorder
 */
package a;

import a.egq;
import a.ejp;
import a.nxa;
import a.vxr;
import flow.dev.a;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.Recorder;

public final class ell
implements Recorder {
    private static final Field elm = vxr.find(MinecraftClient.class, a.d("\u6e34\u178e\u9d4c\u0367\u88f3\u0e46\ub412\u3de8\ua3b1\u2911\uaed1\u54a7\uda62\u4389\uc997\u4f69\uf52b\u7ae8\ue05b\u6626\uefbd\u95ee\u1b5c", -19234698, 1910828603), a.d("\uc041\ub9ff\u3320\uad58\u2687\ua00d\u1a33\u93c9\u0d9a\u8728\u00f4", -931353639, 1638689781), a.b("\u2282\u5b11\ud1c9\u4fa9\uc425\u42d6\uf881\u7177\uef23\u6594\ue256\u1834\u96e4\u0f47\u854f\u03f2\ub9b2\u366e\uaccf\u2a9e\ua345\ud97e\u57c1\ucc1f\u4a64\uc0bc", 778904276));
    private final Recorder eln;
    private static /* synthetic */ int elo;
    private static /* synthetic */ int elp;

    private ell(Recorder recorder) {
        this.eln = recorder;
    }

    public static void ensure(MinecraftClient minecraftClient) {
        if (elm == null || minecraftClient == null) {
            return;
        }
        try {
            Object object = elm.get(minecraftClient);
            if (object instanceof ell || !(object instanceof Recorder)) {
                return;
            }
            Recorder recorder = (Recorder)object;
            elm.set(minecraftClient, new ell(recorder));
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            // empty catch block
        }
    }

    public void stop() {
        this.eln.stop();
    }

    public void forceStop() {
        this.eln.forceStop();
    }

    public void startTick() {
        this.eln.startTick();
    }

    public boolean isActive() {
        return this.eln.isActive();
    }

    public Profiler getProfiler() {
        return this.eln.getProfiler();
    }

    public void endTick() {
        this.eln.endTick();
        if (ejp.isActive()) {
            return;
        }
        try {
            nxa.onFrame();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            egq.onFrame();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int he(int n, int n2) {
        return n + n2 | 0xB2EC016D;
    }

    private static /* synthetic */ int hf(int n, int n2) {
        return n + n2 ^ 0xBC6E05D;
    }
}

