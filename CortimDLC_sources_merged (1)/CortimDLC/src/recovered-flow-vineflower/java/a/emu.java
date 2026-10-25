package a;

import com.google.common.collect.ImmutableMultimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

public final class emu {
   static final String[] emv = new String[]{
      a.c(1786727778, "䴊"),
      a.d("\uf653迢", -1021633131, -261559379),
      a.c(627735873, "紫Қ蹉"),
      a.b("㍫䫅", -1366084864),
      a.c(221346936, "簏"),
      a.b("䮺㈔", -314750002),
      a.d("\u088f無ﯲ", 306922275, -1259713575),
      a.b("͈竦\uf035湄", 1544291130),
      a.b("艻ﯛ", 1284145680),
      a.b("햗", 1636881902)
   };
   static final String emw = a.b("꧉큧媺쒃何짧玵暑搝\ueeaf楽錃ᷕ", 468953517);
   static final String emx = a.c(1096676702, "\uf56e賋؛롔㎄閖⿉ꚽ㢠뉐");
   static final double emy = 9.9999942618434E-4;
   final String emz;
   final Item ena;
   final List<elw> enb = new ArrayList<>();
   final List<emi> enc = new ArrayList<>();
   final List<emo> end = new ArrayList<>();
   final List<emc> ene = new ArrayList<>();
   int enf;
   String eng;

   emu(String var1, Item var2) {
      this.emz = var1;
      this.ena = var2;
   }

   public static emu of(String var0, Item var1) {
      return new emu(var0, var1);
   }

   public emu attr(RegistryEntry<EntityAttribute> var1, double var2, Operation var4) {
      this.enb.add(new elw(var1, var2, var4));
      return this;
   }

   public emu flat(RegistryEntry<EntityAttribute> var1, double var2) {
      return this.attr(var1, var2, Operation.ADD_VALUE);
   }

   public emu scaled(RegistryEntry<EntityAttribute> var1, double var2) {
      return this.attr(var1, var2, Operation.ADD_MULTIPLIED_BASE);
   }

   public emu ench(RegistryKey<Enchantment> var1, int var2) {
      this.enc.add(new emi(var1, var2, false));
      return this;
   }

   public emu denyEnch(RegistryKey<Enchantment> var1) {
      this.enc.add(new emi(var1, 0, true));
      return this;
   }

   public emu lore(String var1) {
      this.end.add(new emo(var1, 0, false));
      return this;
   }

   public emu lore(String var1, int var2) {
      this.end.add(new emo(var1, var2, false));
      return this;
   }

   public emu denyLore(String var1) {
      this.end.add(new emo(var1, 0, true));
      return this;
   }

   public emu effect(RegistryEntry<StatusEffect> var1, int var2, int var3) {
      this.ene.add(new emc(var1, var2, var3));
      return this;
   }

   public emu color(int var1) {
      this.enf = var1;
      return this;
   }

   public emu profile(String var1) {
      this.eng = var1;
      return this;
   }

   public String getName() {
      return this.emz;
   }

   public Item getItem() {
      return this.ena;
   }

   public String getSearchQuery() {
      return this.emz
         .replaceAll(a.b("ꍒ\udae4倰칹䗡쌃祴\uf0bd溭\ue46a", -2026462460), "")
         .replace(a.b("墷", -851214825), "")
         .replace(a.c(1829795111, "畜೭蘾"), "")
         .replace(a.b("፶", -704834772), "")
         .replace(a.c(-444200732, "ࢸ"), "")
         .replace(a.b("萪", -1903713746), "")
         .trim()
         .replaceAll(a.c(-1255031971, "묂슜䠗"), a.b("䜪", 1646806795));
   }

   public boolean matches(ItemStack var1) {
      return var1.isOf(this.ena) && this.enj(var1) && this.enk(var1) && this.enl(var1) && this.enm(var1);
   }

   boolean enj(ItemStack var1) {
      if (this.enb.isEmpty()) {
         return true;
      }

      AttributeModifiersComponent var2 = var1.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);

      for (elw var4 : this.enb) {
         boolean var5 = false;

         for (Entry var7 : var2.modifiers()) {
            if (var7.attribute().equals(var4.attribute())
               && Math.abs(var7.modifier().value() - var4.amount()) < 9.9999942618434E-4
               && var7.modifier().operation() == var4.operation()) {
               var5 = true;
               break;
            }
         }

         if (!var5) {
            return false;
         }
      }

      return true;
   }

   boolean enk(ItemStack var1) {
      if (this.enc.isEmpty()) {
         return true;
      }

      MinecraftClient var2 = MinecraftClient.getInstance();
      ItemEnchantmentsComponent var3 = var1.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);

      for (emi var5 : this.enc) {
         if (var2.world != null) {
            Optional<RegistryEntry<Enchantment>> var6 = var2.world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).getOptional(var5.key());
            int var7 = var6.map(var3::getLevel).orElse(0);
            int var8 = var5.level() == 0 ? 1 : var5.level();
            if (!var5.deny()) {
               if (var3.isEmpty() || var7 < var8) {
                  return false;
               }
            } else if (var7 >= var8) {
               return false;
            }
         } else if (!var5.deny()) {
            return false;
         }
      }

      return true;
   }

   boolean enl(ItemStack var1) {
      if (this.end.isEmpty()) {
         return true;
      }

      MinecraftClient var2 = MinecraftClient.getInstance();

      String var3;
      try {
         var3 = var1.getTooltip(TooltipContext.DEFAULT, var2.player, TooltipType.BASIC)
            .stream()
            .skip(1L)
            .map(var0 -> normalize(var0.getString()))
            .collect(Collectors.joining(a.c(-1628386956, "쥿")));
      } catch (RuntimeException var7) {
         return false;
      }

      for (emo var5 : this.end) {
         String var6 = normalize(var5.text());
         if (var5.deny()) {
            if (var3.contains(var6)) {
               return false;
            }
         } else if (var5.level() == 0) {
            if (!var3.contains(var6)) {
               return false;
            }
         } else if (enn(var3, var6) < var5.level()) {
            return false;
         }
      }

      return true;
   }

   boolean enm(ItemStack var1) {
      if (this.ene.isEmpty()) {
         return true;
      }

      PotionContentsComponent var2 = var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var2 == null) {
         return false;
      }

      for (emc var4 : this.ene) {
         boolean var5 = StreamSupport.stream(var2.getEffects().spliterator(), false)
            .anyMatch(
               var1x -> var1x.getEffectType().equals(var4.effect()) && var1x.getAmplifier() + 1 == var4.level() && var1x.getDuration() >= var4.duration()
            );
         if (!var5) {
            return false;
         }
      }

      return StreamSupport.stream(var2.getEffects().spliterator(), false).count() == this.ene.size();
   }

   public ItemStack buildStack() {
      ItemStack var1 = new ItemStack(this.ena);
      if (this.enf != 0 && !this.ene.isEmpty()) {
         ArrayList var2 = new ArrayList();

         for (emc var4 : this.ene) {
            var2.add(new StatusEffectInstance(var4.effect(), Math.max(1, var4.duration()), Math.max(0, var4.level() - 1)));
         }

         var1.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.empty(), Optional.of(this.enf), var2, Optional.empty()));
      }

      if (this.eng != null) {
         GameProfile var5 = new GameProfile(
            UUID.nameUUIDFromBytes(this.eng.getBytes(StandardCharsets.UTF_8)),
            a.c(-437830553, "㰅") + Math.abs(this.emz.hashCode() % 100000),
            new PropertyMap(ImmutableMultimap.of(a.c(-818731191, "✵底푛䨦쇰䝆ﴂ瓥"), new Property(a.c(-1673893696, "梼ᄜ鯒֯蹹࣏늋㭬"), this.eng)))
         );
         var1.set(DataComponentTypes.PROFILE, ProfileComponent.ofStatic(var5));
      }

      return var1;
   }

   static String normalize(String var0) {
      return var0 == null ? "" : var0.replaceAll(a.b("첥떝", 66243584), "").toLowerCase(Locale.ROOT).replaceAll(a.c(1005132242, "ᦍ怓\uea98"), "").trim();
   }

   static int enn(String var0, String var1) {
      if (!var0.isEmpty() && !var1.isEmpty()) {
         int var2 = 0;

         for (int var3 = var0.indexOf(var1); var3 >= 0; var3 = var0.indexOf(var1, var3 + var1.length())) {
            var2 = Math.max(var2, Math.max(1, eno(var0, var3 + var1.length())));
         }

         return var2;
      } else {
         return 0;
      }
   }

   static int eno(String var0, int var1) {
      int var2 = var1;

      while (var2 < var0.length() && a.c(451769799, "痷\u0c52蚂㣍댝ᔏ꽐☤령㋉").indexOf(var0.charAt(var2)) >= 0) {
         var2++;
      }

      int var3 = var2;

      while (var2 < var0.length() && a.c(-1729785284, "鉘\uebf6愫２瓄\uf276䠤쇒後픾勬ꢒ♄").indexOf(var0.charAt(var2)) >= 0) {
         var2++;
      }

      return var2 == var3 ? 0 : enp(var0.substring(var3, var2));
   }

   static int enp(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = normalize(var0);

         for (int var2 = 0; var2 < emv.length; var2++) {
            if (var1.equals(emv[var2])) {
               return var2 + 1;
            }
         }

         String var5 = var1.replaceAll(a.b("⩋叿\ud942䜮쳭䨸", 2145921558), "");
         if (!var5.isEmpty()) {
            try {
               int var3 = Integer.parseInt(var5);
               if (var3 >= 1 && var3 <= 10) {
                  return var3;
               }
            } catch (NumberFormatException var4) {
            }
         }

         for (int var6 = emv.length - 1; var6 >= 0; var6--) {
            if (var1.contains(emv[var6])) {
               return var6 + 1;
            }
         }

         return 0;
      } else {
         return 0;
      }
   }
}
