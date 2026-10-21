/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package a;

import a.PanicShutdown;
import a.ModuleCategory;
import a.Setting;
import flow.dev.StringDecryptor;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_310;
import sun.misc.Unsafe;

public abstract class Module {
    private static Consumer<Module> kff = kfe2 -> {};
    protected final class_310 mc = class_310.method_1551();
    private final byte[] kfg;
    private final byte[] kfh;
    private final int kfi;
    private final int kfj;
    private transient SoftReference<String> kfk;
    private transient SoftReference<String> kfl;
    private final ModuleCategory kfm;
    private final List<Setting> kfn = new ArrayList<Setting>();
    private boolean kfo;
    private int kfp = -1;
    private boolean kfq;
    private static /* synthetic */ String kfr;
    private static /* synthetic */ boolean kfs;

    protected Module(String string, String string2, ModuleCategory kfa2) {
        this.kfi = (int)(System.nanoTime() ^ (long)System.identityHashCode(this));
        this.kfg = Module.kft(string, this.kfi);
        this.kfh = Module.kft(string2, this.kfi);
        this.kfj = string == null ? 0 : string.hashCode();
        this.kfm = kfa2;
        Module.kfv(string);
        Module.kfv(string2);
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
            Field field = String.class.getDeclaredField("value");
            Field field2 = Unsafe.class.getDeclaredField("theUnsafe");
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

    protected <T extends Setting> T add(T t) {
        this.kfn.add(t);
        return t;
    }

    public String getName() {
        return Module.kfu(this.kfg, this.kfi);
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
        string = Module.kfw(this.kfg, this.kfi);
        this.kfk = new SoftReference<String>(string);
        return string;
    }

    public String getDescription() {
        return Module.kfu(this.kfh, this.kfi);
    }

    public String getDisplayDescription() {
        String string;
        SoftReference<String> softReference = this.kfl;
        if (softReference != null && (string = softReference.get()) != null) {
            return string;
        }
        string = Module.kfw(this.kfh, this.kfi);
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
        Module.kfv((String)object);
        return stringBuilder.toString();
    }

    public ModuleCategory getCategory() {
        return this.kfm;
    }

    public List<Setting> getSettings() {
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
        if (this.kfo == bl || bl && (PanicShutdown.armed() || this.isLocked())) {
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
        if (this.kfo == bl || bl && (PanicShutdown.armed() || this.isLocked())) {
            return;
        }
        this.kfo = bl;
        if (bl) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public static void onToggle(Consumer<Module> consumer) {
        kff = kff.andThen(consumer);
    }

    protected void onEnable() {
    }

    protected void onDisable() {
    }

    public boolean ticksWhenOff() {
        return false;
    }

    public void onStartTick(class_310 class_3102) {
    }

    public void onEndTick(class_310 class_3102) {
    }

    public void onKey(class_310 class_3102, int n) {
    }

    public boolean keysAtStart() {
        return false;
    }

    public void onWorldRender(class_310 class_3102) {
    }

    public void onWorldRenderLate(class_310 class_3102) {
    }

    public void onWorldRenderFinal(class_310 class_3102) {
    }

    private static /* synthetic */ int ata(int n, int n2) {
        return n ^ n2 ^ 0x9EF9111D;
    }

    private static /* synthetic */ int atb(int n, int n2) {
        return Module.ata(n, n2) ^ 0xD1F24FA;
    }
}

