/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 */
package a;

import a.ItemRuleParser;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.class_1799;

public final class SelectionSet {
    private final Set<String> elr = new LinkedHashSet<String>();
    private final Supplier<List<ItemRuleParser>> els;
    private static /* synthetic */ String elt;
    private static /* synthetic */ long elu;

    SelectionSet(Supplier<List<ItemRuleParser>> supplier) {
        this.els = supplier;
    }

    public List<ItemRuleParser> entries() {
        return this.els.get();
    }

    public boolean isSelected(ItemRuleParser emu2) {
        return emu2 != null && this.elr.contains(emu2.getName());
    }

    public void toggle(ItemRuleParser emu2) {
        if (emu2 == null) {
            return;
        }
        if (!this.elr.remove(emu2.getName())) {
            this.elr.add(emu2.getName());
        }
    }

    public int selectedCount() {
        return this.elr.size();
    }

    public void selectAll(boolean bl) {
        this.elr.clear();
        if (bl) {
            for (ItemRuleParser emu2 : this.entries()) {
                this.elr.add(emu2.getName());
            }
        }
    }

    public int selectWhere(Predicate<ItemRuleParser> predicate) {
        this.elr.clear();
        for (ItemRuleParser emu2 : this.entries()) {
            if (!predicate.test(emu2)) continue;
            this.elr.add(emu2.getName());
        }
        return this.elr.size();
    }

    public ItemRuleParser match(class_1799 class_17992) {
        if (class_17992 == null || class_17992.method_7960() || this.elr.isEmpty()) {
            return null;
        }
        String string = null;
        for (ItemRuleParser emu2 : this.entries()) {
            String string2;
            if (!this.elr.contains(emu2.getName()) || !class_17992.method_31574(emu2.getItem())) continue;
            if (emu2.matches(class_17992)) {
                return emu2;
            }
            if (string == null) {
                string = SelectionSet.elv(class_17992.method_7964().getString());
            }
            if ((string2 = SelectionSet.elv(emu2.getSearchQuery())).isEmpty() || !string.contains(string2)) continue;
            return emu2;
        }
        return null;
    }

    private static String elv(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7') {
                ++i;
                continue;
            }
            if (!Character.isLetterOrDigit(c)) continue;
            stringBuilder.append((c = Character.toLowerCase(c)) == '\u0451' ? (char)'\u0435' : (char)c);
        }
        return stringBuilder.toString();
    }

    private static /* synthetic */ int hi(int n, int n2) {
        return n * n2 | 0x78CB656;
    }

    private static /* synthetic */ int hj(int n, int n2) {
        return n - n2 | 0x74DBB629;
    }
}

