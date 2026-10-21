/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.class_1297
 *  net.minecraft.class_1531
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2940
 *  net.minecraft.class_2943
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_8113$class_8123
 *  net.minecraft.class_9779
 */
package a;

import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.rzv;
import a.SceneCapture;
import a.FrameDelta;
import a.ScreenProjection;
import a.DrawUtil;
import a.FontFace;
import a.Fonts;
import a.Icon;
import a.BoolSetting;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1297;
import net.minecraft.class_1531;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_8113;
import net.minecraft.class_9779;

public class WardenTimers
extends Module {
    private static final Pattern rzz = Pattern.compile("(\\d{1,2})\\s*:\\s*(\\d{2})");
    private static final Pattern saa = Pattern.compile("(?i)\u00a7.|&#[0-9a-f]{6}|<#?[0-9a-f]{6}>");
    private static final Pattern sab = Pattern.compile("(?i)(\u0433\u043e\u0442\u043e\u0432|\u0437\u0430\u0431\u0438\u0440\u0430\u0439|\u043d\u0430\u0433\u0440\u0430\u0434\u0430|\u0441\u043e\u0431\u0438\u0440\u0430\u0439)");
    private static final FontFace sac = Fonts.medium(6.5f);
    private static WardenTimers sad;
    private static class_2940<?> sae;
    private static boolean saf;
    private final BoolSetting sag = this.add(new BoolSetting("Hide timer", true));
    private final BoolSetting sah = this.add(new BoolSetting("Blur", true));
    private final List<rzv> sai = new ArrayList<rzv>();
    private final Map<Integer, String[]> saj = new HashMap<Integer, String[]>();
    private static final Map<class_2248, Boolean> sak;
    private final boolean sal;
    private static /* synthetic */ boolean sam;
    private static /* synthetic */ long san;

    public WardenTimers() {
        this(true);
    }

    public WardenTimers(boolean bl) {
        super(new String(new char[]{'W', 'a', 'r', 'd', 'e', 'n', 'H', 'e', 'l', 'p', 'e', 'r'}), "Timers over the Warden chests", ModuleCategory.RENDER);
        this.sal = bl;
        if (bl) {
            sad = this;
        }
    }

    @Override
    protected void onEnable() {
        this.sai.clear();
    }

    @Override
    protected void onDisable() {
        this.sai.clear();
        this.saj.clear();
    }

    @Override
    public void onStartTick(class_310 class_3102) {
        this.tickTimers(true);
    }

    private boolean sao() {
        return this.mc.field_1724 == null || this.mc.field_1687 == null;
    }

    public void tickTimers(boolean bl) {
        if (this.sao()) {
            return;
        }
        long l = System.currentTimeMillis();
        String string = this.mc.field_1687.method_27983().method_29177().toString();
        this.sai.removeIf(rzv2 -> {
            if (!rzv2.dimension.equals(string)) {
                return false;
            }
            if (this.mc.field_1724 != null) {
                double d = rzv2.pos.method_1025(this.mc.field_1724.method_73189());
                if (d > 40000.0) {
                    return true;
                }
                if (d < 2500.0 && !this.saq(class_2338.method_49637((double)rzv2.pos.field_1352, (double)(rzv2.pos.field_1351 - 1.0), (double)rzv2.pos.field_1350))) {
                    return true;
                }
            }
            if (rzv2.isReady && l - rzv2.lastSeen > 300000L) {
                return true;
            }
            return !rzv2.isReady && rzv2.expirationTime + 10000L <= l;
        });
        for (class_1297 object : this.mc.field_1687.method_18112()) {
            Object object2;
            Object object3;
            if (!(object instanceof class_1531) && !(object instanceof class_8113.class_8123)) continue;
            String l4 = "";
            if (object instanceof class_1531) {
                object3 = (class_1531)object;
                if (object3.method_16914() && object3.method_5797() != null) {
                    l4 = object3.method_5797().getString();
                }
            } else {
                object2 = WardenTimers.sar((class_8113.class_8123)object);
                if (object2 != null) {
                    l4 = object2.getString();
                }
            }
            if (l4.isEmpty() || (object3 = this.sap(object.method_5628(), l4)) == null) continue;
            object2 = rzz.matcher((CharSequence)object3);
            boolean bl2 = sab.matcher((CharSequence)object3).find();
            if (!((Matcher)object2).find() && !bl2) continue;
            if (bl && this.sag.get()) {
                object.method_5648(true);
                if (object instanceof class_1531) {
                    class_1531 class_15312 = (class_1531)object;
                    class_15312.method_5880(false);
                }
            }
            double d = object instanceof class_1531 ? 1.8 : 0.5;
            class_243 class_2432 = new class_243(object.method_23317(), object.method_23318() + d, object.method_23321());
            class_243 class_2433 = new class_243(Math.floor(class_2432.field_1352) + 0.5, class_2432.field_1351, Math.floor(class_2432.field_1350) + 0.5);
            if (!this.saq(class_2338.method_49637((double)class_2433.field_1352, (double)(class_2433.field_1351 - 1.0), (double)class_2433.field_1350))) continue;
            rzv rzv4 = null;
            for (rzv rzv5 : this.sai) {
                if (!rzv5.dimension.equals(string) || !(this.sau(rzv5.pos, class_2433) < 1.0)) continue;
                rzv4 = rzv5;
                break;
            }
            if (((Matcher)object2).find(0)) {
                int n = 0;
                int n2 = 0;
                try {
                    n = Integer.parseInt(((Matcher)object2).group(1));
                    n2 = Integer.parseInt(((Matcher)object2).group(2));
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
                long l2 = (long)n * 60L + (long)n2;
                long l3 = l + l2 * 1000L;
                rzv rzv6 = rzv4;
                if (rzv4 != null) {
                    rzv4.expirationTime = l3;
                    rzv4.isReady = false;
                    rzv4.lastSeen = l;
                    rzv4.lastNumericUpdate = l;
                } else {
                    rzv6 = new rzv(class_2433, l3, string, l);
                    rzv6.lastNumericUpdate = l;
                    this.sai.add(rzv6);
                }
                rzv6.untimed = false;
                if (l2 > 0L) {
                    rzv6.zeroSince = 0L;
                    continue;
                }
                if (rzv6.zeroSince != 0L) continue;
                rzv6.zeroSince = l;
                continue;
            }
            if (!bl2) continue;
            if (rzv4 != null) {
                if (l - rzv4.lastNumericUpdate <= 1000L) continue;
                if (!rzv4.isReady && !rzv4.notifiedReady) {
                    this.sav(bl, "Chest", "ready", true);
                    rzv4.notifiedReady = true;
                }
                rzv4.isReady = true;
                rzv4.untimed = false;
                rzv4.lastSeen = l;
                continue;
            }
            rzv rzv7 = new rzv(class_2433, l, string, l);
            rzv7.isReady = true;
            rzv7.notifiedReady = true;
            this.sai.add(rzv7);
            this.sav(bl, "Chest", "ready", true);
        }
        for (rzv rzv8 : this.sai) {
            long l4 = rzv8.expirationTime - l;
            if (!rzv8.isReady && l4 > 0L && l4 <= 10000L && !rzv8.notifiedTen) {
                this.sav(bl, "Chest", "10 sec", false);
                rzv8.notifiedTen = true;
            }
            if (rzv8.isReady || l4 > 0L || rzv8.countdownShown(l) || rzv8.notifiedReady) continue;
            this.sav(bl, "Chest", "ready", true);
            rzv8.notifiedReady = true;
            rzv8.isReady = true;
        }
        if (this.mc.field_1724 != null) {
            Iterator<Object> iterator = this.mc.field_1724.method_73189();
            this.sai.sort((rzv2, rzv3) -> Double.compare(rzv3.pos.method_1025(iterator), rzv2.pos.method_1025(iterator)));
        }
    }

    private String sap(int n, String string) {
        String[] stringArray = this.saj.get(n);
        if (stringArray != null && stringArray[0].equals(string)) {
            return stringArray[1];
        }
        String string2 = saa.matcher(string).replaceAll("");
        string2 = string2.replace("\u00d8", "0").replace("\u2205", "0");
        String string3 = string2.toLowerCase(Locale.ROOT);
        String string4 = string2;
        if (string3.contains("\u043a\u0435\u0439\u0441") || string3.contains("\u043a\u043b\u044e\u0447\u0435\u0439") || string3.contains("\u043d\u0430\u0436\u043c\u0438") || !rzz.matcher(string2).find() && !sab.matcher(string2).find()) {
            string4 = null;
        }
        if (this.saj.size() > 4096) {
            this.saj.clear();
        }
        this.saj.put(n, new String[]{string, string4});
        return string4;
    }

    private boolean saq(class_2338 class_23382) {
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -2; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    class_2248 class_22482 = this.mc.field_1687.method_8320((class_2338)class_23392.method_25504((class_2382)class_23382, i, j, k)).method_26204();
                    Boolean bl = sak.get(class_22482);
                    if (bl == null) {
                        String string = class_22482.method_63499().toLowerCase(Locale.ROOT);
                        bl = string.contains("chest") || string.contains("barrel") || string.contains("shulker");
                        sak.put(class_22482, bl);
                    }
                    if (!bl.booleanValue()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private static class_2561 sar(class_8113.class_8123 class_81232) {
        if (!saf) {
            saf = true;
            for (Field field : class_8113.class_8123.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != class_2940.class) continue;
                try {
                    field.setAccessible(true);
                    class_2940 exception = (class_2940)field.get(null);
                    if (exception == null || exception.comp_2328() != class_2943.field_13317) continue;
                    sae = exception;
                    break;
                }
                catch (ReflectiveOperationException | RuntimeException exception) {
                    // empty catch block
                }
            }
        }
        if (sae == null) {
            return null;
        }
        try {
            class_2561 class_25612;
            Object runtimeException = class_81232.method_5841().method_12789(sae);
            return runtimeException instanceof class_2561 ? (class_25612 = (class_2561)runtimeException) : null;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public static void render(class_332 class_3322, class_9779 class_97792) {
        ScreenProjection usn2;
        WardenTimers rzy2 = sad;
        class_310 class_3102 = class_310.method_1551();
        if (rzy2 == null || !rzy2.isEnabled() || rzy2.sai.isEmpty() || class_3102.field_1687 == null || class_3102.field_1724 == null || class_3102.field_1690.field_1842) {
            return;
        }
        FrameDelta.observe(class_3322);
        float f = class_3322.method_51421();
        float f2 = class_3322.method_51443();
        try {
            usn2 = ScreenProjection.capture(class_97792.method_60637(true), f, f2);
        }
        catch (Throwable throwable) {
            return;
        }
        DrawUtil.beginFrame();
        GpuTextureView gpuTextureView = null;
        boolean bl = false;
        long l = System.currentTimeMillis();
        String string = class_3102.field_1687.method_27983().method_29177().toString();
        float[] fArray = new float[2];
        int n = 0;
        for (rzv rzv2 : rzy2.sai) {
            int n2;
            if (!rzv2.dimension.equals(string) || n >= 30 || !usn2.project(rzv2.pos.field_1352, rzv2.pos.field_1351, rzv2.pos.field_1350, fArray) || fArray[0] < 0.0f || fArray[0] > f || fArray[1] < 0.0f || fArray[1] > f2) continue;
            if (!bl) {
                bl = true;
                if (rzy2.sah.get() && SceneCapture.HUD.capture(class_3322, 2, null)) {
                    gpuTextureView = SceneCapture.HUD.result(class_3322);
                }
            }
            long l2 = rzv2.expirationTime - l;
            boolean bl2 = rzv2.isReady || l2 <= 0L && !rzv2.countdownShown(l);
            long l3 = Math.abs(l2) / 1000L;
            String string2 = bl2 ? "READY" : WardenTimers.sat(l3 / 60L) + ":" + WardenTimers.sat(l3 % 60L);
            float f3 = bl2 ? 1.0f : Math.min((float)l2 / 180000.0f, 1.0f);
            int n3 = bl2 ? 60 : (int)(255.0f + -255.0f * f3);
            int n4 = bl2 ? 255 : (int)(40.0f + 215.0f * f3);
            int n5 = bl2 ? 90 : 0;
            int n6 = 0xFF000000 | WardenTimers.sas(n3) << 16 | WardenTimers.sas(n4) << 8 | WardenTimers.sas(n5);
            float f4 = sac.width(string2) + 10.0f;
            float f5 = 13.0f;
            float f6 = fArray[0] - f4 / 2.0f;
            float f7 = fArray[1] - 4.0f;
            int n7 = bl2 ? -938185186 : -1275068416;
            int n8 = n2 = bl2 ? -1944144836 : 0x78000000;
            if (gpuTextureView == null || !DrawUtil.glass(class_3322, gpuTextureView, f6, f7, f4, f5, 3.0f, n2, 1.0f)) {
                DrawUtil.round(class_3322, f6, f7, f4, f5, 3.0f, n7);
            }
            sac.draw(class_3322, string2, f6 + 5.0f, sac.centerTop(f7 + f5 / 2.0f), n6);
            ++n;
        }
    }

    private static int sas(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private static String sat(long l) {
        return l < 10L ? "0" + l : String.valueOf(l);
    }

    private double sau(class_243 class_2432, class_243 class_2433) {
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1350 - class_2433.field_1350;
        return d * d + d2 * d2;
    }

    private void sav(boolean bl, String string, String string2, boolean bl2) {
        if (bl && this.sal) {
            try {
                Hud.alert(string, string2, Icon.INFO, bl2);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public void clearTimers() {
        this.sai.clear();
    }

    public rzv markUntimedReady(class_2338 class_23382, String string) {
        long l = System.currentTimeMillis();
        class_243 class_2432 = new class_243((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 1.5, (double)class_23382.method_10260() + 0.5);
        for (rzv rzv2 : this.sai) {
            if (!rzv2.dimension.equals(string) || !(this.sau(rzv2.pos, class_2432) < 1.0) || !(Math.abs(rzv2.pos.field_1351 - class_2432.field_1351) < 4.0)) continue;
            return rzv2;
        }
        rzv rzv3 = new rzv(class_2432, l, string, l);
        rzv3.isReady = true;
        rzv3.notifiedReady = true;
        rzv3.untimed = true;
        this.sai.add(rzv3);
        return rzv3;
    }

    public List<rzv> getCachedTimers() {
        return this.sai;
    }

    static {
        sak = new IdentityHashMap<class_2248, Boolean>();
    }

    private static /* synthetic */ int ccs(int n, int n2) {
        return n * n2 | 0x7053A9A5;
    }

    private static /* synthetic */ int cct(int n, int n2) {
        return WardenTimers.ccs(n, n2) + n;
    }
}

