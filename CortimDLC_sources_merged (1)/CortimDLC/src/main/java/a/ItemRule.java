/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_1887
 *  net.minecraft.class_1893
 *  net.minecraft.class_2378
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_6880$class_6883
 *  net.minecraft.class_7924
 *  net.minecraft.class_9304
 *  net.minecraft.class_9334
 */
package a;

import a.ItemSnapshot;
import a.EnchantNameUtil;
import a.phj;
import flow.dev.StringDecryptor;
import java.util.Optional;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1893;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_9304;
import net.minecraft.class_9334;

public final class ItemRule {
    private final class_5321<class_1887> phn;
    private final String pho;
    private final String php;
    private final phj phq;
    private final int phr;
    private phj phs;
    private int pht;
    private static /* synthetic */ int phu;
    private static /* synthetic */ int phv;

    private ItemRule(class_5321<class_1887> class_53212, String string, phj phj2, int n) {
        this.phn = class_53212;
        this.pho = string;
        this.php = string == null ? null : EnchantNameUtil.normalize(string);
        this.phq = phj2;
        this.phr = n;
        this.phs = phj2;
        this.pht = n;
    }

    public static ItemRule enchant(class_5321<class_1887> class_53212, int n) {
        return new ItemRule(class_53212, null, phj.ON, n);
    }

    public static ItemRule denyEnchant(class_5321<class_1887> class_53212) {
        return new ItemRule(class_53212, null, phj.DENY, 0);
    }

    public static ItemRule lore(String string, int n, boolean bl) {
        return new ItemRule(null, string, bl ? phj.ON : phj.OFF, n);
    }

    public static ItemRule denyLore(String string) {
        return new ItemRule(null, string, phj.DENY, 0);
    }

    public boolean isEnchant() {
        return this.phn != null;
    }

    public String key() {
        return this.phn != null ? this.phn.method_29177().toString() : this.pho;
    }

    public phj state() {
        return this.phs;
    }

    public void setState(phj phj2) {
        this.phs = phj2;
    }

    public int level() {
        return this.pht;
    }

    public void setLevel(int n) {
        this.pht = n <= 0 || this.phr == 0 ? this.phr : Math.max(1, Math.min(this.maxLevel(), n));
    }

    public boolean hasLevel() {
        return this.phr > 0;
    }

    public void reset() {
        this.phs = this.phq;
        this.pht = this.phr;
    }

    public boolean changed() {
        return this.phs != this.phq || this.pht != this.phr;
    }

    public int maxLevel() {
        if (this.phn == null) {
            return "Окисление".equals(this.pho) || "Вампиризм".equals(this.pho) ? 2 : 3;
        }
        if (this.phn.equals((Object)class_1893.field_9118)) {
            return 7;
        }
        if (this.phn.equals((Object)class_1893.field_9111) || this.phn.equals((Object)class_1893.field_9119)) {
            return 5;
        }
        Optional<class_6880.class_6883<class_1887>> optional = this.phw();
        return optional.map(class_68832 -> Math.max(1, ((class_1887)class_68832.comp_349()).method_8183())).orElse(Math.max(1, this.phr));
    }

    public String label() {
        String string;
        String string2 = string = this.pho != null ? this.pho : class_2561.method_43471((String)("enchantment." + this.phn.method_29177().method_12836() + "." + this.phn.method_29177().method_12832().replace('/', '.'))).getString();
        if (this.pht == 0) {
            return string;
        }
        return this.pho != null ? string + " " + EnchantNameUtil.roman(this.pht) : string + " " + this.pht;
    }

    public boolean matches(class_1799 class_17992, ItemSnapshot pey2) {
        if (this.phs == phj.OFF) {
            return true;
        }
        if (this.phn != null) {
            Optional<class_6880.class_6883<class_1887>> optional = this.phw();
            if (optional.isEmpty()) {
                return this.phs == phj.DENY;
            }
            class_9304 class_93042 = (class_9304)class_17992.method_58695(class_9334.field_49633, (Object)class_9304.field_49385);
            int n = class_93042.method_57536((class_6880)optional.get());
            int n2 = Math.max(1, this.pht);
            return this.phs == phj.DENY ? n < n2 : n >= n2;
        }
        String string = pey2.lore();
        if (this.phs == phj.DENY) {
            return !string.contains(this.php);
        }
        if (this.pht == 0) {
            return string.contains(this.php);
        }
        return EnchantNameUtil.levelOf(string, this.php) >= this.pht;
    }

    private Optional<class_6880.class_6883<class_1887>> phw() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1687 == null) {
            return Optional.empty();
        }
        class_2378 class_23782 = class_3102.field_1687.method_30349().method_30530(class_7924.field_41265);
        return class_23782.method_46746(this.phn);
    }

    private static /* synthetic */ int bit(int n, int n2) {
        return n - n2 + -552601053;
    }

    private static /* synthetic */ int biu(int n, int n2) {
        return ItemRule.bit(n, n2) ^ 0x4CB9DE08;
    }

    private static /* synthetic */ int biv(int n, int n2) {
        return n - n2 | 0x44A845B9;
    }
}

