/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.ItemEnchantmentsComponent
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.Registry
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.entry.RegistryEntry$Reference
 *  net.minecraft.text.Text
 */
package a;

import a.pey;
import a.pfl;
import a.phj;
import flow.dev.a;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;

public final class phm {
    private final RegistryKey<Enchantment> phn;
    private final String pho;
    private final String php;
    private final phj phq;
    private final int phr;
    private phj phs;
    private int pht;
    private static /* synthetic */ int phu;
    private static /* synthetic */ int phv;

    private phm(RegistryKey<Enchantment> registryKey, String string, phj phj2, int n) {
        this.phn = registryKey;
        this.pho = string;
        this.php = string == null ? null : pfl.normalize(string);
        this.phq = phj2;
        this.phr = n;
        this.phs = phj2;
        this.pht = n;
    }

    public static phm enchant(RegistryKey<Enchantment> registryKey, int n) {
        return new phm(registryKey, null, phj.ON, n);
    }

    public static phm denyEnchant(RegistryKey<Enchantment> registryKey) {
        return new phm(registryKey, null, phj.DENY, 0);
    }

    public static phm lore(String string, int n, boolean bl) {
        return new phm(null, string, bl ? phj.ON : phj.OFF, n);
    }

    public static phm denyLore(String string) {
        return new phm(null, string, phj.DENY, 0);
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
            return a.c(1146396690, "\ua405\udd90\u5741\uc949\u42e4\uc45b\u7e00\uf7f4\u69a6").equals(this.pho) || a.c(1895414591, "\ubf24\uc6b7\u4c68\ud21a\u59ca\udf03\u6528\uecd6\u7282").equals(this.pho) ? 2 : 3;
        }
        if (this.phn.equals((Object)Enchantments.field_9118)) {
            return 7;
        }
        if (this.phn.equals((Object)Enchantments.field_9111) || this.phn.equals((Object)Enchantments.field_9119)) {
            return 5;
        }
        Optional<RegistryEntry.Reference<Enchantment>> optional = this.phw();
        return optional.map(reference -> Math.max(1, ((Enchantment)reference.comp_349()).method_8183())).orElse(Math.max(1, this.phr));
    }

    public String label() {
        String string;
        String string2 = string = this.pho != null ? this.pho : Text.method_43471((String)(a.c(857770670, "\u8ac7\uf37d\u79a3\ue7d9\u6c07\ueab9\u50f0\ud918\u474f\ucdf5\u4a3c\ub017") + this.phn.method_29177().method_12836() + a.d("\u50c2", -1870339655, -458116780) + this.phn.method_29177().method_12832().replace('/', '.'))).getString();
        if (this.pht == 0) {
            return string;
        }
        return this.pho != null ? string + a.d("\u24bb", 1379570657, 736147323) + pfl.roman(this.pht) : string + a.b("\u45d1", 1651852784) + this.pht;
    }

    public boolean matches(ItemStack itemStack, pey pey2) {
        if (this.phs == phj.OFF) {
            return true;
        }
        if (this.phn != null) {
            Optional<RegistryEntry.Reference<Enchantment>> optional = this.phw();
            if (optional.isEmpty()) {
                return this.phs == phj.DENY;
            }
            ItemEnchantmentsComponent itemEnchantmentsComponent = (ItemEnchantmentsComponent)itemStack.method_58695(DataComponentTypes.field_49633, (Object)ItemEnchantmentsComponent.field_49385);
            int n = itemEnchantmentsComponent.method_57536((RegistryEntry)optional.get());
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
        return pfl.levelOf(string, this.php) >= this.pht;
    }

    private Optional<RegistryEntry.Reference<Enchantment>> phw() {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (minecraftClient.field_1687 == null) {
            return Optional.empty();
        }
        Registry registry = minecraftClient.field_1687.method_30349().method_30530(RegistryKeys.field_41265);
        return registry.method_46746(this.phn);
    }

    private static /* synthetic */ int bit(int n, int n2) {
        return n - n2 + -552601053;
    }

    private static /* synthetic */ int biu(int n, int n2) {
        return phm.bit(n, n2) ^ 0x4CB9DE08;
    }

    private static /* synthetic */ int biv(int n, int n2) {
        return n - n2 | 0x44A845B9;
    }
}

