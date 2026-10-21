/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_746
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package a;

import a.EnchantNameUtil;
import a.qag;
import a.SlotUtil;
import flow.dev.StringDecryptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_746;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public final class BuyerSeller {
    private static final class_1792[] qak = new class_1792[]{class_1802.field_8725, class_1802.field_8759, class_1802.field_8713, class_1802.field_8620};
    private static final long qal = 6000L;
    private static final long qam = 4000L;
    private static final long qan = 12000L;
    private static final long qao = 1300L;
    private final Map<class_1792, Long> qap = new HashMap<class_1792, Long>();
    private final Map<class_1792, String> qaq = new HashMap<class_1792, String>();
    private qag qar = qag.IDLE;
    private long qas;
    private long qat;
    private int qau;
    private boolean qav;
    private String qaw = "";
    private static /* synthetic */ int qax;
    private static /* synthetic */ String qay;

    public boolean active() {
        return this.qar != qag.IDLE && this.qar != qag.DONE;
    }

    public boolean ok() {
        return this.qav;
    }

    public String result() {
        return this.qaw;
    }

    public void begin(class_310 class_3102, String string, long l) {
        this.qap.clear();
        this.qaq.clear();
        this.qau = 0;
        this.qav = false;
        this.qaw = "";
        this.qas = l;
        String string2 = string.trim();
        if (string2.startsWith("/")) {
            string2 = string2.substring(1);
        }
        if (class_3102.field_1724 != null && class_3102.field_1755 instanceof class_465) {
            class_3102.field_1724.method_7346();
        }
        if (string2.isEmpty() || class_3102.method_1562() == null) {
            this.qbb(class_3102, false, "нет команды скупщика");
            return;
        }
        class_3102.method_1562().method_45730(string2);
        this.qba(qag.MENU, l);
    }

    public void cancel(class_310 class_3102) {
        if (this.active() && class_3102.field_1724 != null && class_3102.field_1755 instanceof class_465) {
            class_3102.field_1724.method_7346();
        }
        this.qar = qag.IDLE;
    }

    public boolean tick(class_310 class_3102, class_746 class_7462, long l) {
        class_465 class_4652;
        if (!this.active()) {
            return true;
        }
        if (l - this.qas > 12000L) {
            this.qbb(class_3102, false, "скупщик не ответил вовремя");
            return true;
        }
        class_437 class_4372 = class_3102.field_1755;
        class_465 class_4653 = class_4372 instanceof class_465 && SlotUtil.isStorage((class_437)(class_4652 = (class_465)class_4372)) ? class_4652 : null;
        switch (this.qar.ordinal()) {
            case 1: {
                if (class_4653 == null) {
                    if (l - this.qat > 6000L) {
                        this.qbb(class_3102, false, "/buyer не открылся");
                    }
                    return !this.active();
                }
                class_4652 = class_4653.method_17577();
                if (BuyerSeller.qbc((class_1703)class_4652, class_7462) > 0) {
                    this.qba(qag.TOGGLE, l);
                    return false;
                }
                class_4372 = BuyerSeller.qbe((class_1703)class_4652, class_7462);
                if (class_4372 == null) {
                    if (l - this.qat > 6000L) {
                        this.qbb(class_3102, false, "нет раздела «Шахтёр» в /buyer");
                    }
                    return !this.active();
                }
                SlotUtil.click(class_3102, (class_1703)class_4652, class_4372.field_7874, 0, class_1713.field_7790);
                ++this.qau;
                this.qba(qag.SECTION, l);
                break;
            }
            case 2: {
                if (class_4653 != null && BuyerSeller.qbc(class_4653.method_17577(), class_7462) > 0) {
                    this.qba(qag.TOGGLE, l);
                    return this.qaz(class_3102, class_7462, class_4653, l);
                }
                if (l - this.qat <= 4000L) break;
                if (class_4653 != null && this.qau < 2) {
                    this.qba(qag.MENU, l);
                    break;
                }
                this.qbb(class_3102, false, "раздел «Шахтёр» не открылся");
                break;
            }
            case 3: {
                if (class_4653 == null) {
                    this.qbb(class_3102, false, "меню скупщика закрылось");
                    return true;
                }
                return this.qaz(class_3102, class_7462, class_4653, l);
            }
        }
        return !this.active();
    }

    private boolean qaz(class_310 class_3102, class_746 class_7462, class_465<?> class_4652, long l) {
        class_1703 class_17032 = class_4652.method_17577();
        int n = 0;
        int n2 = 0;
        for (class_1792 class_17922 : qak) {
            boolean bl;
            class_1735 class_17352 = BuyerSeller.qbd(class_17032, class_7462, class_17922);
            if (class_17352 == null) continue;
            ++n2;
            String string = BuyerSeller.loreLine(class_17352.method_7677());
            if (BuyerSeller.enabled(string)) {
                ++n;
                continue;
            }
            Long l2 = this.qap.get(class_17922);
            boolean bl2 = bl = l2 != null && !string.equals(this.qaq.get(class_17922));
            if (l2 != null && !bl && l - l2 <= 1300L) continue;
            SlotUtil.click(class_3102, class_17032, class_17352.field_7874, 0, class_1713.field_7795);
            this.qap.put(class_17922, l);
            this.qaq.put(class_17922, string);
        }
        if (n2 > 0 && n == n2 && (n2 == qak.length || l - this.qat > 1500L)) {
            this.qbb(class_3102, true, n + " из " + qak.length + " на авто-скупке");
            return true;
        }
        return false;
    }

    private void qba(qag qag2, long l) {
        this.qar = qag2;
        this.qat = l;
    }

    private void qbb(class_310 class_3102, boolean bl, String string) {
        this.qav = bl;
        this.qaw = string;
        this.qar = qag.DONE;
        if (class_3102.field_1724 != null && class_3102.field_1755 instanceof class_465) {
            class_3102.field_1724.method_7346();
        }
    }

    private static int qbc(class_1703 class_17032, class_746 class_7462) {
        int n = 0;
        for (class_1792 class_17922 : qak) {
            if (BuyerSeller.qbd(class_17032, class_7462, class_17922) == null) continue;
            ++n;
        }
        return n;
    }

    private static class_1735 qbd(class_1703 class_17032, class_746 class_7462, class_1792 class_17922) {
        for (class_1735 class_17352 : SlotUtil.own(class_17032, class_7462.method_31548())) {
            class_1799 class_17992 = class_17352.method_7677();
            if (!class_17992.method_31574(class_17922) || !BuyerSeller.loreLine(class_17992).contains("скупк")) continue;
            return class_17352;
        }
        return null;
    }

    private static class_1735 qbe(class_1703 class_17032, class_746 class_7462) {
        class_1735 class_17352 = null;
        for (class_1735 class_17353 : SlotUtil.own(class_17032, class_7462.method_31548())) {
            class_1799 class_17992 = class_17353.method_7677();
            if (class_17992.method_7960()) continue;
            String string = EnchantNameUtil.title(class_17992.method_7964().getString());
            if (string.contains("шахт")) {
                return class_17353;
            }
            if (class_17352 != null || !class_17992.method_31574(class_1802.field_8759)) continue;
            class_17352 = class_17353;
        }
        return class_17352;
    }

    static String loreLine(class_1799 class_17992) {
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 == null) {
            return "";
        }
        List list = class_92902.comp_2400();
        for (class_2561 class_25612 : list) {
            String string = EnchantNameUtil.title(class_25612.getString());
            if (!string.contains("скупк")) continue;
            return string;
        }
        return "";
    }

    static boolean enabled(String string) {
        return string.contains("включен") && !string.contains("выключ");
    }

    private static /* synthetic */ int bqo(int n, int n2) {
        return (n ^ n2) + 1965590547;
    }
}

