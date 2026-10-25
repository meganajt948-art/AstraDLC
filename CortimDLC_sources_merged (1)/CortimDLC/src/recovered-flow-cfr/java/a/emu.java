/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  com.mojang.authlib.properties.PropertyMap
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.AttributeModifiersComponent
 *  net.minecraft.component.type.AttributeModifiersComponent$Entry
 *  net.minecraft.component.type.ItemEnchantmentsComponent
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.component.type.ProfileComponent
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.attribute.EntityAttribute
 *  net.minecraft.entity.attribute.EntityAttributeModifier$Operation
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$TooltipContext
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.tooltip.TooltipType
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.registry.entry.RegistryEntry
 */
package a;

import a.elw;
import a.emc;
import a.emi;
import a.emo;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
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
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

public final class emu {
    private static final String[] emv;
    private static final String emw;
    private static final String emx;
    private static final double emy = 9.9999942618434E-4;
    private final String emz;
    private final Item ena;
    private final List<elw> enb = new ArrayList<elw>();
    private final List<emi> enc = new ArrayList<emi>();
    private final List<emo> end = new ArrayList<emo>();
    private final List<emc> ene = new ArrayList<emc>();
    private int enf;
    private String eng;
    private static /* synthetic */ boolean enh;
    private static /* synthetic */ long eni;

    private emu(String string, Item item) {
        this.emz = string;
        this.ena = item;
    }

    public static emu of(String string, Item item) {
        return new emu(string, item);
    }

    public emu attr(RegistryEntry<EntityAttribute> registryEntry, double d, EntityAttributeModifier.Operation operation) {
        this.enb.add(new elw(registryEntry, d, operation));
        return this;
    }

    public emu flat(RegistryEntry<EntityAttribute> registryEntry, double d) {
        return this.attr(registryEntry, d, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    public emu scaled(RegistryEntry<EntityAttribute> registryEntry, double d) {
        return this.attr(registryEntry, d, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }

    public emu ench(RegistryKey<Enchantment> registryKey, int n) {
        this.enc.add(new emi(registryKey, n, false));
        return this;
    }

    public emu denyEnch(RegistryKey<Enchantment> registryKey) {
        this.enc.add(new emi(registryKey, 0, true));
        return this;
    }

    public emu lore(String string) {
        this.end.add(new emo(string, 0, false));
        return this;
    }

    public emu lore(String string, int n) {
        this.end.add(new emo(string, n, false));
        return this;
    }

    public emu denyLore(String string) {
        this.end.add(new emo(string, 0, true));
        return this;
    }

    public emu effect(RegistryEntry<StatusEffect> registryEntry, int n, int n2) {
        this.ene.add(new emc(registryEntry, n, n2));
        return this;
    }

    public emu color(int n) {
        this.enf = n;
        return this;
    }

    public emu profile(String string) {
        this.eng = string;
        return this;
    }

    public String getName() {
        return this.emz;
    }

    public Item getItem() {
        return this.ena;
    }

    public String getSearchQuery() {
        return this.emz.replaceAll(a.b("\ua352\udae4\u5030\uce79\u45e1\uc303\u7974\uf0bd\u6ead\ue46a", -2026462460), "").replace(a.b("\u58b7", -851214825), "").replace(a.c(1829795111, "\u755c\u0ced\u863e"), "").replace(a.b("\u1376", -704834772), "").replace(a.c(-444200732, "\u08b8"), "").replace(a.b("\u842a", -1903713746), "").trim().replaceAll(a.c(-1255031971, "\ubb02\uc29c\u4817"), a.b("\u472a", 1646806795));
    }

    public boolean matches(ItemStack itemStack) {
        return itemStack.isOf(this.ena) && this.enj(itemStack) && this.enk(itemStack) && this.enl(itemStack) && this.enm(itemStack);
    }

    private boolean enj(ItemStack itemStack) {
        if (this.enb.isEmpty()) {
            return true;
        }
        AttributeModifiersComponent attributeModifiersComponent = (AttributeModifiersComponent)itemStack.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, (Object)AttributeModifiersComponent.DEFAULT);
        for (elw elw2 : this.enb) {
            boolean bl = false;
            for (AttributeModifiersComponent.Entry entry : attributeModifiersComponent.modifiers()) {
                if (!entry.attribute().equals(elw2.attribute()) || !(Math.abs(entry.modifier().value() - elw2.amount()) < 9.9999942618434E-4) || entry.modifier().operation() != elw2.operation()) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    private boolean enk(ItemStack itemStack) {
        if (this.enc.isEmpty()) {
            return true;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ItemEnchantmentsComponent itemEnchantmentsComponent = (ItemEnchantmentsComponent)itemStack.getOrDefault(DataComponentTypes.ENCHANTMENTS, (Object)ItemEnchantmentsComponent.DEFAULT);
        for (emi emi2 : this.enc) {
            int n;
            if (minecraftClient.world == null) {
                if (emi2.deny()) continue;
                return false;
            }
            Optional optional = minecraftClient.world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).getOptional(emi2.key());
            int n2 = optional.map(arg_0 -> ((ItemEnchantmentsComponent)itemEnchantmentsComponent).getLevel(arg_0)).orElse(0);
            int n3 = n = emi2.level() == 0 ? 1 : emi2.level();
            if (!(emi2.deny() ? n2 >= n : itemEnchantmentsComponent.isEmpty() || n2 < n)) continue;
            return false;
        }
        return true;
    }

    private boolean enl(ItemStack itemStack) {
        String string;
        if (this.end.isEmpty()) {
            return true;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        try {
            string = itemStack.getTooltip(Item.TooltipContext.DEFAULT, (PlayerEntity)minecraftClient.player, (TooltipType)TooltipType.BASIC).stream().skip(1L).map(text -> emu.normalize(text.getString())).collect(Collectors.joining(a.c(-1628386956, "\uc97f")));
        }
        catch (RuntimeException runtimeException) {
            return false;
        }
        for (emo emo2 : this.end) {
            String string2 = emu.normalize(emo2.text());
            if (!(emo2.deny() ? string.contains(string2) : (emo2.level() == 0 ? !string.contains(string2) : emu.enn(string, string2) < emo2.level()))) continue;
            return false;
        }
        return true;
    }

    private boolean enm(ItemStack itemStack) {
        if (this.ene.isEmpty()) {
            return true;
        }
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.get(DataComponentTypes.POTION_CONTENTS);
        if (potionContentsComponent == null) {
            return false;
        }
        for (emc emc2 : this.ene) {
            boolean bl = StreamSupport.stream(potionContentsComponent.getEffects().spliterator(), false).anyMatch(statusEffectInstance -> statusEffectInstance.getEffectType().equals(emc2.effect()) && statusEffectInstance.getAmplifier() + 1 == emc2.level() && statusEffectInstance.getDuration() >= emc2.duration());
            if (bl) continue;
            return false;
        }
        return StreamSupport.stream(potionContentsComponent.getEffects().spliterator(), false).count() == (long)this.ene.size();
    }

    public ItemStack buildStack() {
        GameProfile gameProfile;
        ItemStack itemStack = new ItemStack((ItemConvertible)this.ena);
        if (this.enf != 0 && !this.ene.isEmpty()) {
            gameProfile = new ArrayList();
            for (emc emc2 : this.ene) {
                gameProfile.add(new StatusEffectInstance(emc2.effect(), Math.max(1, emc2.duration()), Math.max(0, emc2.level() - 1)));
            }
            itemStack.set(DataComponentTypes.POTION_CONTENTS, (Object)new PotionContentsComponent(Optional.empty(), Optional.of(this.enf), gameProfile, Optional.empty()));
        }
        if (this.eng != null) {
            gameProfile = new GameProfile(UUID.nameUUIDFromBytes(this.eng.getBytes(StandardCharsets.UTF_8)), a.c(-437830553, "\u3c05") + Math.abs(this.emz.hashCode() % 100000), new PropertyMap((Multimap)ImmutableMultimap.of((Object)a.c(-818731191, "\u2735\u5e95\ud45b\u4a26\uc1f0\u4746\ufd02\u74e5"), (Object)new Property(a.c(-1673893696, "\u68bc\u111c\u9bd2\u05af\u8e79\u08cf\ub28b\u3b6c"), this.eng))));
            itemStack.set(DataComponentTypes.PROFILE, (Object)ProfileComponent.ofStatic((GameProfile)gameProfile));
        }
        return itemStack;
    }

    static String normalize(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll(a.b("\ucca5\ub59d", 66243584), "").toLowerCase(Locale.ROOT).replaceAll(a.c(1005132242, "\u198d\u6013\uea98"), "").trim();
    }

    private static int enn(String string, String string2) {
        if (string.isEmpty() || string2.isEmpty()) {
            return 0;
        }
        int n = 0;
        int n2 = string.indexOf(string2);
        while (n2 >= 0) {
            n = Math.max(n, Math.max(1, emu.eno(string, n2 + string2.length())));
            n2 = string.indexOf(string2, n2 + string2.length());
        }
        return n;
    }

    private static int eno(String string, int n) {
        int n2;
        for (n2 = n; n2 < string.length() && a.c(451769799, "\u75f7\u0c52\u8682\u38cd\ub31d\u150f\uaf50\u2624\ub839\u32c9").indexOf(string.charAt(n2)) >= 0; ++n2) {
        }
        int n3 = n2;
        while (n2 < string.length() && a.c(-1729785284, "\u9258\uebf6\u612b\uff12\u74c4\uf276\u4824\uc1d2\u5f8c\ud53e\u52ec\ua892\u2644").indexOf(string.charAt(n2)) >= 0) {
            ++n2;
        }
        return n2 == n3 ? 0 : emu.enp(string.substring(n3, n2));
    }

    private static int enp(String string) {
        int n;
        if (string == null || string.isBlank()) {
            return 0;
        }
        String string2 = emu.normalize(string);
        for (int i = 0; i < emv.length; ++i) {
            if (!string2.equals(emv[i])) continue;
            return i + 1;
        }
        String string3 = string2.replaceAll(a.b("\u2a4b\u53ff\ud942\u472e\ucced\u4a38", 2145921558), "");
        if (!string3.isEmpty()) {
            try {
                n = Integer.parseInt(string3);
                if (n >= 1 && n <= 10) {
                    return n;
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        for (n = emv.length - 1; n >= 0; --n) {
            if (!string2.contains(emv[n])) continue;
            return n + 1;
        }
        return 0;
    }

    static {
        emw = a.b("\ua9c9\ud067\u5aba\uc483\u4f55\uc9e7\u73b5\ufa43\u641d\ueeaf\u697d\u9303\u1dd5", 468953517);
        emx = a.c(1096676702, "\uf56e\u8ccb\u061b\ub854\u3384\u9596\u2fc9\ua6bd\u38a0\ub250");
        emv = new String[]{a.c(1786727778, "\u4d0a"), a.d("\uf653\u8fe2", -1021633131, -261559379), a.c(627735873, "\u7d2b\u049a\u8e49"), a.b("\u336b\u4ac5", -1366084864), a.c(221346936, "\u7c0f"), a.b("\u4bba\u3214", -314750002), a.d("\u088f\u7121\ufbf2", 306922275, -1259713575), a.b("\u0348\u7ae6\uf035\u6e44", 1544291130), a.b("\u827b\ufbdb", 1284145680), a.b("\ud597", 1636881902)};
    }

    private static /* synthetic */ int ia(int n, int n2) {
        return n ^ n2 ^ 0xBB3EA316;
    }

    private static /* synthetic */ int ib(int n, int n2) {
        return n * n2 | 0xCA8E8BBD;
    }

    private static /* synthetic */ int ic(int n, int n2) {
        return emu.ia(n, n2) * n2;
    }
}

