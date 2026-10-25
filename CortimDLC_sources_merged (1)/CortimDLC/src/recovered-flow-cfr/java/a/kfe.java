/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package a;

import a.dry;
import a.kfa;
import a.vmo;
import flow.dev.a;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import sun.misc.Unsafe;

public abstract class kfe {
    private static Consumer<kfe> kff = kfe2 -> {};
    protected final MinecraftClient mc = MinecraftClient.getInstance();
    private final byte[] kfg;
    private final byte[] kfh;
    private final int kfi;
    private final int kfj;
    private transient SoftReference<String> kfk;
    private transient SoftReference<String> kfl;
    private final kfa kfm;
    private final List<vmo> kfn = new ArrayList<vmo>();
    private boolean kfo;
    private int kfp = -1;
    private boolean kfq;
    private static /* synthetic */ String kfr;
    private static /* synthetic */ boolean kfs;

    protected kfe(String string, String string2, kfa kfa2) {
        this.kfi = (int)(System.nanoTime() ^ (long)System.identityHashCode(this));
        this.kfg = kfe.kft(string, this.kfi);
        this.kfh = kfe.kft(string2, this.kfi);
        this.kfj = string == null ? 0 : string.hashCode();
        this.kfm = kfa2;
        kfe.kfv(string);
        kfe.kfv(string2);
    }

    private static byte[] kft(String string, int n) {
        if (string == null || string.isEmpty()) {
            return new byte[0];
        }
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < byArray.length; ++i) {
            int n2 = i;
            byArray[n2] = (byte)(byArray[n2] ^ (byte)(n >>> (i & 3) * 8));
        }
        return byArray;
    }

    private static String kfu(byte[] byArray, int n) {
        if (byArray == null || byArray.length == 0) {
            return "";
        }
        byte[] byArray2 = new byte[byArray.length];
        for (int i = 0; i < byArray.length; ++i) {
            byArray2[i] = (byte)(byArray[i] ^ (byte)(n >>> (i & 3) * 8));
        }
        return new String(byArray2, StandardCharsets.UTF_8);
    }

    private static void kfv(String string) {
        if (string == null || string.isEmpty()) {
            return;
        }
        try {
            Field field = String.class.getDeclaredField(a.d("\udfc3\ua665\u2cbb\ub2d3\u3914", -1992117635, -1157075507));
            Field field2 = Unsafe.class.getDeclaredField(a.c(-1497305792, "\ued3d\u9490\u1e4e\u800f\u0be3\u8d4f\u370e\ubef8\u20a4"));
            field2.setAccessible(true);
            Unsafe unsafe = (Unsafe)field2.get(null);
            Object object = unsafe.getObject(string, unsafe.objectFieldOffset(field));
            if (object instanceof byte[]) {
                byte[] byArray = (byte[])object;
                Arrays.fill(byArray, (byte)0);
            } else if (object instanceof char[]) {
                char[] cArray = (char[])object;
                Arrays.fill(cArray, '\u0000');
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    protected <T extends vmo> T add(T t) {
        this.kfn.add(t);
        return t;
    }

    public String getName() {
        return kfe.kfu(this.kfg, this.kfi);
    }

    public int getNameHash() {
        return this.kfj;
    }

    public String getDisplayName() {
        String string;
        SoftReference<String> softReference = this.kfk;
        if (softReference != null && (string = softReference.get()) != null) {
            return string;
        }
        string = kfe.kfw(this.kfg, this.kfi);
        this.kfk = new SoftReference<String>(string);
        return string;
    }

    public String getDescription() {
        return kfe.kfu(this.kfh, this.kfi);
    }

    public String getDisplayDescription() {
        String string;
        SoftReference<String> softReference = this.kfl;
        if (softReference != null && (string = softReference.get()) != null) {
            return string;
        }
        string = kfe.kfw(this.kfh, this.kfi);
        this.kfl = new SoftReference<String>(string);
        return string;
    }

    public void wipeCache() {
        this.kfk = null;
        this.kfl = null;
    }

    private static String kfw(byte[] byArray, int n) {
        Object object;
        int n2;
        if (byArray == null || byArray.length == 0) {
            return "";
        }
        byte[] byArray2 = new byte[byArray.length];
        for (n2 = 0; n2 < byArray.length; ++n2) {
            byArray2[n2] = (byte)(byArray[n2] ^ (byte)(n >>> (n2 & 3) * 8));
        }
        n2 = 1;
        for (byte by : byArray2) {
            if ((by & 0x80) == 0) continue;
            n2 = 0;
            break;
        }
        if (n2 != 0) {
            object = new StringBuilder(byArray2.length * 2 - 1);
            for (int i = 0; i < byArray2.length; ++i) {
                if (i > 0) {
                    ((StringBuilder)object).append('\u200c');
                }
                ((StringBuilder)object).append((char)(byArray2[i] & 0xFF));
            }
            Arrays.fill(byArray2, (byte)0);
            return ((StringBuilder)object).toString();
        }
        object = new String(byArray2, StandardCharsets.UTF_8);
        Arrays.fill(byArray2, (byte)0);
        StringBuilder stringBuilder = new StringBuilder(((String)object).length() * 2 - 1);
        for (int i = 0; i < ((String)object).length(); ++i) {
            if (i > 0) {
                stringBuilder.append('\u200c');
            }
            stringBuilder.append(((String)object).charAt(i));
        }
        kfe.kfv((String)object);
        return stringBuilder.toString();
    }

    public kfa getCategory() {
        return this.kfm;
    }

    public List<vmo> getSettings() {
        return this.kfn;
    }

    public boolean isEnabled() {
        return this.kfo;
    }

    public int getKey() {
        return this.kfp;
    }

    public void setKey(int n) {
        this.kfp = n;
    }

    public boolean isExpanded() {
        return this.kfq;
    }

    public void setExpanded(boolean bl) {
        this.kfq = bl;
    }

    public boolean isAction() {
        return false;
    }

    public boolean isVip() {
        return false;
    }

    public boolean isMaintenance() {
        return false;
    }

    public final boolean isLocked() {
        return this.isVip() || this.isMaintenance();
    }

    public boolean isHidden() {
        return false;
    }

    public void onConfigLoaded(boolean bl) {
    }

    public void toggle() {
        this.setEnabled(!this.kfo);
    }

    public void setEnabled(boolean bl) {
        if (this.kfo == bl || bl && (dry.armed() || this.isLocked())) {
            return;
        }
        this.kfo = bl;
        if (bl) {
            this.onEnable();
        } else {
            this.onDisable();
        }
        kff.accept(this);
    }

    public void setEnabledSilently(boolean bl) {
        if (this.kfo == bl || bl && (dry.armed() || this.isLocked())) {
            return;
        }
        this.kfo = bl;
        if (bl) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public static void onToggle(Consumer<kfe> consumer) {
        kff = kff.andThen(consumer);
    }

    protected void onEnable() {
    }

    protected void onDisable() {
    }

    public boolean ticksWhenOff() {
        return false;
    }

    public void onStartTick(MinecraftClient minecraftClient) {
    }

    public void onEndTick(MinecraftClient minecraftClient) {
    }

    public void onKey(MinecraftClient minecraftClient, int n) {
    }

    public boolean keysAtStart() {
        return false;
    }

    public void onWorldRender(MinecraftClient minecraftClient) {
    }

    public void onWorldRenderLate(MinecraftClient minecraftClient) {
    }

    public void onWorldRenderFinal(MinecraftClient minecraftClient) {
    }

    private static /* synthetic */ int ata(int n, int n2) {
        return n ^ n2 ^ 0x9EF9111D;
    }

    private static /* synthetic */ int atb(int n, int n2) {
        return kfe.ata(n, n2) ^ 0xD1F24FA;
    }
}

