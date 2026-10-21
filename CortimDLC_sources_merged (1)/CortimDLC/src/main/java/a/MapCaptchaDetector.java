/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1533
 *  net.minecraft.class_1799
 *  net.minecraft.class_1806
 *  net.minecraft.class_1937
 *  net.minecraft.class_22
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_310
 *  net.minecraft.class_3620
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_9209
 *  net.minecraft.class_9334
 */
package a;

import a.Bot;
import a.BotManager;
import a.BotTexture;
import a.MapWallUtil;
import a.erc;
import a.erh;
import a.OcrSolver;
import a.CaptchaResult;
import a.DigitCaptchaSolver;
import flow.dev.StringDecryptor;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1297;
import net.minecraft.class_1533;
import net.minecraft.class_1799;
import net.minecraft.class_1806;
import net.minecraft.class_1937;
import net.minecraft.class_22;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_310;
import net.minecraft.class_3620;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_9209;
import net.minecraft.class_9334;

public final class MapCaptchaDetector {
    private static final class_310 eap = class_310.method_1551();
    private static final int eaq = 128;
    private static final int ear = 8;
    private static final long eas = 120000L;
    private static final long eat = 60000L;
    private static final int eau = 40;
    private static final int eav = 3;
    private final Bot eaw;
    private long eax;
    private int eay;
    private int eaz;
    private boolean eba;
    private long ebb;
    private long ebc;
    private int[] ebd;
    private int ebe;
    private int ebf;
    private int ebg;
    private int ebh;
    private boolean ebi;
    private boolean ebj;
    private long ebk;
    private boolean ebl;
    private int ebm;
    private int ebn;
    private int ebo;
    private volatile String ebp = "";
    private volatile String ebq = "";
    private String ebr;
    private long ebs;
    private BotTexture ebt;
    private static /* synthetic */ int ebu;
    private static /* synthetic */ boolean ebv;

    MapCaptchaDetector(Bot dtv2) {
        this.eaw = dtv2;
    }

    static CaptchaResult recognize(BufferedImage bufferedImage) {
        try {
            erc erc2 = OcrSolver.solve(bufferedImage);
            if (!erc2.code().isEmpty()) {
                return new CaptchaResult(erc2.code(), erc2.message());
            }
            CaptchaResult eso2 = DigitCaptchaSolver.solve(bufferedImage);
            return eso2.code().isEmpty() ? new CaptchaResult("", erc2.message()) : eso2;
        }
        catch (erh erh2) {
            CaptchaResult eso3 = DigitCaptchaSolver.solve(bufferedImage);
            return eso3.code().isEmpty() ? new CaptchaResult("", erh2.getMessage()) : eso3;
        }
    }

    void arm() {
        this.eax = System.currentTimeMillis() + 120000L;
        this.reset();
    }

    void onHint(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        if (string2.contains("капч") || string2.contains("captcha")) {
            this.eax = Math.max(this.eax, System.currentTimeMillis() + 60000L);
        }
    }

    void onMap() {
        this.eba = true;
    }

    void reset() {
        this.ecd();
        this.ebd = null;
        this.ebe = 0;
        this.ebf = 0;
        this.ebg = 0;
        this.ebh = 0;
        this.ebi = false;
        this.ebj = false;
        this.ebb = 0L;
        this.ebc = 0L;
        this.eaz = 0;
        this.eba = true;
        this.ebn = 0;
        this.ebo = 0;
        this.ebr = null;
        this.ebp = "";
        this.ebq = "";
    }

    void tick() {
        boolean bl;
        if (++this.eay % 4 != 0) {
            return;
        }
        class_746 class_7462 = MapCaptchaDetector.eap.field_1724;
        class_638 class_6382 = MapCaptchaDetector.eap.field_1687;
        if (class_7462 == null || class_6382 == null) {
            return;
        }
        if (this.ebd == null && System.currentTimeMillis() > this.eax) {
            return;
        }
        boolean bl2 = bl = this.ebw(class_7462, class_6382) || this.eby(class_7462, class_6382);
        if (bl) {
            this.eaz = 0;
            return;
        }
        this.eaz += 4;
        if (this.ebd != null && this.eaz >= 40) {
            this.reset();
            this.eaw.onCaptchaGone();
        }
    }

    private boolean ebw(class_746 class_7462, class_638 class_6382) {
        for (List<class_1533> list : MapWallUtil.findWalls((class_1937)class_6382, (class_1297)class_7462, 16.0)) {
            if (!this.ebx(list, class_6382)) continue;
            return true;
        }
        return false;
    }

    private boolean ebx(List<class_1533> list, class_638 class_6382) {
        int n;
        class_2350 class_23502 = list.get(0).method_5735();
        boolean bl = class_23502.method_10166() == class_2350.class_2351.field_11051;
        boolean bl2 = class_23502 == class_2350.field_11043 || class_23502 == class_2350.field_11034;
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        long l = class_23502.ordinal();
        for (class_1533 class_15332 : list) {
            class_2338 class_23382 = class_15332.method_59940();
            n = bl ? class_23382.method_10263() : class_23382.method_10260();
            n2 = Math.min(n2, n);
            n3 = Math.max(n3, n);
            n4 = Math.min(n4, class_23382.method_10264());
            n5 = Math.max(n5, class_23382.method_10264());
            l = l * 31L + (long)class_15332.method_5628();
            l = l * 31L + class_23382.method_10063();
            l = l * 31L + (long)class_15332.method_6934();
            l = l * 31L + (long)MapCaptchaDetector.ebz(class_15332.method_6940());
        }
        int n6 = n3 - n2 + 1;
        int n7 = n5 - n4 + 1;
        if (n6 > 8 || n7 > 8) {
            return false;
        }
        if (l == this.ebb && !this.eba && this.ebd != null) {
            return true;
        }
        if (l == this.ebc && !this.eba) {
            return false;
        }
        int n8 = n6 * 128;
        n = n7 * 128;
        int[] nArray = new int[n8 * n];
        int n9 = 0;
        for (class_1533 class_15333 : list) {
            class_22 class_222 = class_1806.method_8001((class_1799)class_15333.method_6940(), (class_1937)class_6382);
            if (class_222 == null || class_222.field_122 == null || class_222.field_122.length != 16384) continue;
            ++n9;
            class_2338 class_23383 = class_15333.method_59940();
            int n10 = bl ? class_23383.method_10263() : class_23383.method_10260();
            int n11 = (bl2 ? n3 - n10 : n10 - n2) * 128;
            int n12 = (n5 - class_23383.method_10264()) * 128;
            MapCaptchaDetector.eca(class_222.field_122, class_15333.method_6934() & 3, nArray, n8, n11, n12);
        }
        if (n9 == list.size() && MapWallUtil.seamRatio(nArray, n8, n) > 2.0) {
            this.ebc = l;
            return false;
        }
        boolean bl3 = l != this.ebb;
        this.ebb = l;
        this.eba = false;
        this.ecb(nArray, n8, n, n9, list.size(), bl3);
        return true;
    }

    private boolean eby(class_746 class_7462, class_638 class_6382) {
        class_1799 class_17992 = class_7462.method_6047();
        if (!(class_17992.method_7909() instanceof class_1806)) {
            return false;
        }
        class_22 class_222 = class_1806.method_8001((class_1799)class_17992, (class_1937)class_6382);
        if (class_222 == null || class_222.field_122 == null || class_222.field_122.length != 16384) {
            return false;
        }
        long l = 55150044793L + (long)MapCaptchaDetector.ebz(class_17992);
        if (l == this.ebb && !this.eba && this.ebd != null) {
            return true;
        }
        boolean bl = l != this.ebb;
        this.ebb = l;
        this.eba = false;
        int[] nArray = new int[16384];
        MapCaptchaDetector.eca(class_222.field_122, 0, nArray, 128, 0, 0);
        this.ecb(nArray, 128, 128, 1, 1, bl);
        return true;
    }

    private static int ebz(class_1799 class_17992) {
        class_9209 class_92092 = (class_9209)class_17992.method_58694(class_9334.field_49646);
        return class_92092 == null ? -1 : class_92092.comp_2315();
    }

    private static void eca(byte[] byArray, int n, int[] nArray, int n2, int n3, int n4) {
        for (int i = 0; i < 128; ++i) {
            for (int j = 0; j < 128; ++j) {
                int n5 = byArray[i * 128 + j] & 0xFF;
                int n6 = n5 < 4 ? 0 : class_3620.method_38480((int)n5);
                switch (n) {
                    case 1: {
                        int n7 = 127 - i;
                        int n8 = j;
                        break;
                    }
                    case 2: {
                        int n7 = 127 - j;
                        int n8 = 127 - i;
                        break;
                    }
                    case 3: {
                        int n7 = i;
                        int n8 = 127 - j;
                        break;
                    }
                    default: {
                        int n7 = j;
                        int n8 = i;
                    }
                }
                nArray[(n4 + n8) * n2 + n3 + n7] = n6;
            }
        }
    }

    private void ecb(int[] nArray, int n, int n2, int n3, int n4, boolean bl) {
        this.ebd = nArray;
        this.ebe = n;
        this.ebf = n2;
        this.ebg = n3;
        this.ebh = n4;
        this.ebl = true;
        if (bl) {
            this.ebi = true;
            this.ebk = System.currentTimeMillis();
            this.ebj = false;
            this.ebm = 0;
        }
        if (n3 == n4) {
            int n5 = Arrays.hashCode(nArray);
            if (n5 != this.ebm) {
                if (this.ebm != 0) {
                    this.ebi = true;
                    this.ebk = System.currentTimeMillis();
                    this.ebj = false;
                    if (this.ebr != null && System.currentTimeMillis() - this.ebs > 1500L) {
                        this.eaw.chat.system("Ответ " + this.ebr + " не принят, новая картинка");
                        this.ebr = null;
                    }
                }
                this.ebm = n5;
            }
            this.ecc(nArray, n, n2, n5);
        }
        if (!this.ebj && n3 * 2 >= n4) {
            this.ebj = true;
            this.eaw.onCaptcha();
        }
    }

    private void ecc(int[] nArray, int n, int n2, int n3) {
        if (n3 == this.ebn || !BotManager.get().isSolvingCaptcha()) {
            return;
        }
        this.ebn = n3;
        if (this.ebo >= 3) {
            this.ebp = "";
            this.ebq = "сеть промахнулась 3 раза - введи код сам";
            return;
        }
        this.ebp = "";
        this.ebq = "сеть читает картинку...";
        BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
        bufferedImage.setRGB(0, 0, n, n2, nArray, 0, n);
        Thread.ofVirtual().start(() -> {
            CaptchaResult eso2;
            try {
                eso2 = MapCaptchaDetector.recognize(bufferedImage);
            }
            catch (Throwable throwable) {
                eso2 = new CaptchaResult("", String.valueOf(throwable.getMessage()));
            }
            CaptchaResult eso3 = eso2;
            eap.execute(() -> {
                if (n3 != this.ebm) {
                    return;
                }
                if (!eso3.code().isEmpty()) {
                    ++this.ebo;
                    this.ebp = eso3.code();
                    this.ebq = "";
                    this.answered(eso3.code());
                    this.eaw.onCaptchaSolved(eso3.code());
                } else {
                    this.ebq = "";
                    this.eaw.onCaptchaUnsolved(eso3.message());
                }
            });
        });
    }

    private void ecd() {
        if (this.ebr != null && System.currentTimeMillis() - this.ebs < 60000L) {
            this.eaw.chat.system("Капча принята: " + this.ebr);
        }
        this.ebr = null;
    }

    public void answered(String string) {
        if (this.ebd == null || string == null || !string.matches("\\d{3,8}")) {
            return;
        }
        this.ebr = string;
        this.ebs = System.currentTimeMillis();
    }

    public String getAutoCode() {
        return this.ebp;
    }

    public String getAutoState() {
        return this.ebq;
    }

    public boolean isShown() {
        return this.ebd != null && this.ebi;
    }

    public boolean isPresent() {
        return this.ebd != null;
    }

    public void dismiss() {
        this.ebi = false;
    }

    public void show() {
        if (this.ebd != null) {
            this.ebi = true;
        }
    }

    public int getWidth() {
        return this.ebe;
    }

    public int getHeight() {
        return this.ebf;
    }

    public int getFilledTiles() {
        return this.ebg;
    }

    public int getTotalTiles() {
        return this.ebh;
    }

    public long getShownAt() {
        return this.ebk;
    }

    public BotTexture texture() {
        int[] nArray = this.ebd;
        if (nArray == null) {
            return null;
        }
        if (this.ebt != null && (this.ebt.width != this.ebe || this.ebt.height != this.ebf)) {
            this.close();
        }
        if (this.ebt == null) {
            this.ebt = new BotTexture("captcha", this.ebe, this.ebf);
            this.ebl = true;
        }
        if (this.ebl) {
            for (int i = 0; i < this.ebf; ++i) {
                for (int j = 0; j < this.ebe; ++j) {
                    int n = nArray[i * this.ebe + j];
                    this.ebt.set(j, i, n == 0 ? -15066078 : n);
                }
            }
            this.ebt.upload();
            this.ebl = false;
        }
        return this.ebt;
    }

    void close() {
        if (this.ebt != null) {
            this.ebt.close();
        }
        this.ebt = null;
    }

    private static /* synthetic */ int cf(int n, int n2) {
        return n + n2 | 0x4F646D07;
    }

    private static /* synthetic */ int cg(int n, int n2) {
        return MapCaptchaDetector.cf(n, n2) ^ 0xF59C6142;
    }

    private static /* synthetic */ int ch(int n, int n2) {
        return n + n2 ^ 0x6231C9A7;
    }
}

