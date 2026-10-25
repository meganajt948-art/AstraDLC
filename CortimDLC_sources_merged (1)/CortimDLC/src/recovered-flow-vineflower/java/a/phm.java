package a;

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
import net.minecraft.registry.entry.RegistryEntry.Reference;
import net.minecraft.text.Text;

public final class phm {
   final RegistryKey<Enchantment> phn;
   final String pho;
   final String php;
   final phj phq;
   final int phr;
   phj phs;
   int pht;

   phm(RegistryKey<Enchantment> var1, String var2, phj var3, int var4) {
      this.phn = var1;
      this.pho = var2;
      this.php = var2 == null ? null : pfl.normalize(var2);
      this.phq = var3;
      this.phr = var4;
      this.phs = var3;
      this.pht = var4;
   }

   public static phm enchant(RegistryKey<Enchantment> var0, int var1) {
      return new phm(var0, null, phj.ON, var1);
   }

   public static phm denyEnchant(RegistryKey<Enchantment> var0) {
      return new phm(var0, null, phj.DENY, 0);
   }

   public static phm lore(String var0, int var1, boolean var2) {
      return new phm(null, var0, var2 ? phj.ON : phj.OFF, var1);
   }

   public static phm denyLore(String var0) {
      return new phm(null, var0, phj.DENY, 0);
   }

   public boolean isEnchant() {
      return this.phn != null;
   }

   public String key() {
      return this.phn != null ? this.phn.getValue().toString() : this.pho;
   }

   public phj state() {
      return this.phs;
   }

   public void setState(phj var1) {
      this.phs = var1;
   }

   public int level() {
      return this.pht;
   }

   public void setLevel(int var1) {
      this.pht = var1 > 0 && this.phr != 0 ? Math.max(1, Math.min(this.maxLevel(), var1)) : this.phr;
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
      if (this.phn != null) {
         if (this.phn.equals(Enchantments.SHARPNESS)) {
            return 7;
         } else if (!this.phn.equals(Enchantments.PROTECTION) && !this.phn.equals(Enchantments.UNBREAKING)) {
            Optional<RegistryEntry<Enchantment>> var1 = this.phw();
            return var1.<Integer>map(var0 -> Math.max(1, ((Enchantment)var0.value()).getMaxLevel())).orElse(Math.max(1, this.phr));
         } else {
            return 5;
         }
      } else {
         return !a.c(1146396690, "ꐅ\udd90坁쥉䋤쑛縀\uf7f4榦").equals(this.pho) && !a.c(1895414591, "뼤욷䱨툚姊\udf03攨\uecd6犂").equals(this.pho) ? 3 : 2;
      }
   }

   public String label() {
      String var1 = this.pho != null
         ? this.pho
         : Text.translatable(
               a.c(857770670, "談\uf37d禣\ue7d9氇\ueab9僰\ud918䝏췵䨼뀗")
                  + this.phn.getValue().getNamespace()
                  + a.d("僂", -1870339655, -458116780)
                  + this.phn.getValue().getPath().replace('/', '.')
            )
            .getString();
      if (this.pht == 0) {
         return var1;
      } else {
         return this.pho != null ? var1 + a.d("Ⓕ", 1379570657, 736147323) + pfl.roman(this.pht) : var1 + a.b("䗑", 1651852784) + this.pht;
      }
   }

   public boolean matches(ItemStack var1, pey var2) {
      if (this.phs == phj.OFF) {
         return true;
      }

      if (this.phn != null) {
         Optional var7 = this.phw();
         if (var7.isEmpty()) {
            return this.phs == phj.DENY;
         }

         ItemEnchantmentsComponent var4 = var1.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);
         int var5 = var4.getLevel((RegistryEntry<Enchantment>)var7.get());
         int var6 = Math.max(1, this.pht);
         return this.phs == phj.DENY ? var5 < var6 : var5 >= var6;
      } else {
         String var3 = var2.lore();
         if (this.phs == phj.DENY) {
            return !var3.contains(this.php);
         } else {
            return this.pht == 0 ? var3.contains(this.php) : pfl.levelOf(var3, this.php) >= this.pht;
         }
      }
   }

   Optional<Reference<Enchantment>> phw() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world == null) {
         return Optional.empty();
      }

      Registry var2 = var1.world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
      return var2.getOptional(this.phn);
   }
}
