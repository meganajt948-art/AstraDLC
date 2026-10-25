/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package a;

import a.emu;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.item.ItemStack;

public final class elq {
    private final Set<String> elr = new LinkedHashSet<String>();
    private final Supplier<List<emu>> els;
    private static /* synthetic */ String elt;
    private static /* synthetic */ long elu;

    elq(Supplier<List<emu>> supplier) {
        this.els = supplier;
    }

    public List<emu> entries() {
        return this.els.get();
    }

    public boolean isSelected(emu emu2) {
        return emu2 != null && this.elr.contains(emu2.getName());
    }

    public void toggle(emu emu2) {
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
            for (emu emu2 : this.entries()) {
                this.elr.add(emu2.getName());
            }
        }
    }

    public int selectWhere(Predicate<emu> predicate) {
        this.elr.clear();
        for (emu emu2 : this.entries()) {
            if (!predicate.test(emu2)) continue;
            this.elr.add(emu2.getName());
        }
        return this.elr.size();
    }

    public emu match(ItemStack itemStack) {
        if (itemStack == null || itemStack.method_7960() || this.elr.isEmpty()) {
            return null;
        }
        String string = null;
        for (emu emu2 : this.entries()) {
            String string2;
            if (!this.elr.contains(emu2.getName()) || !itemStack.method_31574(emu2.getItem())) continue;
            if (emu2.matches(itemStack)) {
                return emu2;
            }
            if (string == null) {
                string = elq.elv(itemStack.method_7964().getString());
            }
            if ((string2 = elq.elv(emu2.getSearchQuery())).isEmpty() || !string.contains(string2)) continue;
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

