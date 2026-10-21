package dev.dj.cortim.module;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.*;

public final class LootCatalog {
    private LootCatalog() {}

    public record Entry(String id, String name, Item icon, Set<Item> items, List<String> keys, boolean plainOnly) {
        public boolean matches(ItemStack st) {
            if (st.isEmpty()) return false;
            if (!keys.isEmpty()) {
                String n = st.getName().getString().toLowerCase(Locale.ROOT);
                for (String k : keys) if (n.contains(k)) return true;
            }
            if (items.contains(st.getItem())) {
                return !plainOnly || st.get(DataComponentTypes.CUSTOM_NAME) == null;
            }
            return false;
        }
    }

    public static final List<Entry> ALL = new ArrayList<>();
    private static final Map<String, Entry> BY_ID = new HashMap<>();

    /** Ванильный предмет: ищем по типу. */
    private static void v(String id, String name, Item icon, Item... items) {
        add(new Entry(id, name, icon, new HashSet<>(Arrays.asList(items)), List.of(), false));
    }

    /** Кастомный предмет: ищем по части названия (строчными). */
    private static void c(String id, String name, Item icon, String... keys) {
        add(new Entry(id, name, icon, Set.of(), List.of(keys), false));
    }

    private static void add(Entry e) { ALL.add(e); BY_ID.put(e.id(), e); }

    public static Entry byId(String id) { return BY_ID.get(id); }

    public static boolean matchesAny(Set<String> selectedIds, ItemStack st) {
        if (st.isEmpty()) return false;
        for (String id : selectedIds) {
            Entry e = BY_ID.get(id);
            if (e != null && e.matches(st)) return true;
        }
        return false;
    }

    static {
        v("elytra", "Элитры", Items.ELYTRA, Items.ELYTRA);
        v("netherite_armor", "Незеритовая броня", Items.NETHERITE_CHESTPLATE,
                Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS);
        v("charka", "Чарка", Items.ENCHANTED_GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE);
        v("gapple", "Гэпл", Items.GOLDEN_APPLE, Items.GOLDEN_APPLE);
        c("potion_assassin", "Зелье Ассасина", Items.POTION, "ассасин");
        c("potion_paladin", "Зелье Палладина", Items.POTION, "палладин");
        c("holy_water", "Святая вода", Items.POTION, "святая вода");
        c("potion_radiation", "Зелье Радиации", Items.POTION, "радиаци");
        v("diamond", "Алмаз", Items.DIAMOND, Items.DIAMOND);
        c("silver", "Серебро", Items.IRON_NUGGET, "серебро");
        v("netherite_scrap", "Незеритовый лом", Items.NETHERITE_SCRAP, Items.NETHERITE_SCRAP);
        v("netherite_ingot", "Незеритовый слиток", Items.NETHERITE_INGOT, Items.NETHERITE_INGOT);
        c("plast", "Пласт", Items.DRIED_KELP, "пласт");
        c("trapka", "Трапка", Items.NETHERITE_SCRAP, "трапка");
        c("disorientation", "Дезориентация", Items.ENDER_EYE, "дезориентац");
        c("yavnaya_pyl", "Явная пыль", Items.SUGAR, "явная пыль");
        v("netherite_sword", "Незеритовый меч", Items.NETHERITE_SWORD, Items.NETHERITE_SWORD);
        v("skeleton_skull", "Череп скелета", Items.SKELETON_SKULL, Items.SKELETON_SKULL);
        v("wither_skull", "Череп визер-скелета", Items.WITHER_SKELETON_SKULL, Items.WITHER_SKELETON_SKULL);
        v("dragon_head", "Голова дракона", Items.DRAGON_HEAD, Items.DRAGON_HEAD);

        v("creeper_head", "Голова крипера", Items.CREEPER_HEAD, Items.CREEPER_HEAD);
        v("zombie_head", "Голова зомби", Items.ZOMBIE_HEAD, Items.ZOMBIE_HEAD);
        c("tal_tyrant", "Талисман Тирана", Items.TOTEM_OF_UNDYING, "талисман тирана");
        c("tal_discord", "Талисман Раздора", Items.TOTEM_OF_UNDYING, "талисман раздора");
        c("tal_gloom", "Талисман Мрака", Items.TOTEM_OF_UNDYING, "талисман мрака");
        c("tal_whirl", "Талисман Вихря", Items.TOTEM_OF_UNDYING, "талисман вихря");
        c("tal_demon", "Талисман Демона", Items.TOTEM_OF_UNDYING, "талисман демона");
        c("sph_beast", "Сфера Бестии", Items.PLAYER_HEAD, "сфера бестии");
        c("sph_icarus", "Сфера Икара", Items.PLAYER_HEAD, "сфера икара");
        c("sph_satyr", "Сфера Сатира", Items.PLAYER_HEAD, "сфера сатира");
        c("sph_ares", "Сфера Ареса", Items.PLAYER_HEAD, "сфера ареса");
        c("sph_chaos", "Сфера Хаоса", Items.PLAYER_HEAD, "сфера хаоса");
        c("sph_hydra", "Сфера Гидры", Items.PLAYER_HEAD, "сфера гидры");
        c("arrow_ice", "Стрела обледенения", Items.ARROW, "стрела обледенения");
        v("golden_carrot", "Золотая морковь", Items.GOLDEN_CARROT, Items.GOLDEN_CARROT);
        c("god_aura", "Божья аура", Items.PHANTOM_MEMBRANE, "божья аура");
        v("xp_bottle", "Опыт (все пузыри)", Items.EXPERIENCE_BOTTLE, Items.EXPERIENCE_BOTTLE);
        c("mod_repair", "Модификатор починки", Items.AMETHYST_SHARD, "модификатор починки");
        c("mod_anvil", "Модификатор наковальни", Items.ANVIL, "модификатор наковальни");
        c("mod_flight", "Модификатор полёта", Items.FEATHER, "модификатор полёта", "модификатор полета");

        v("beacon", "Маяк", Items.BEACON, Items.BEACON);
        c("airdrop", "Аирдроп", Items.RED_BANNER, "аирдроп", "airdrop");
        c("undead_altar", "Алтарь нежити", Items.OBSIDIAN, "алтарь нежити");
        c("tnt_white", "Вайт", Items.TNT, "вайт");
        c("tnt_black", "Блэк", Items.TNT, "блэк");
        add(new Entry("tnt", "ТНТ", Items.TNT, Set.of(Items.TNT), List.of(), true));
        v("emerald_ore", "Изумрудная руда", Items.EMERALD_ORE, Items.EMERALD_ORE, Items.DEEPSLATE_EMERALD_ORE);
        v("gold_ingot", "Золотые слитки", Items.GOLD_INGOT, Items.GOLD_INGOT);
        c("lockpicks", "Отмычки (все)", Items.TRIPWIRE_HOOK, "отмычк");
        v("egg_zvillager", "Яйцо призыва зомби-крестьянина", Items.ZOMBIE_VILLAGER_SPAWN_EGG, Items.ZOMBIE_VILLAGER_SPAWN_EGG);
        v("egg_villager", "Яйцо призыва крестьянина", Items.VILLAGER_SPAWN_EGG, Items.VILLAGER_SPAWN_EGG);
        v("nether_star", "Звезда Незера", Items.NETHER_STAR, Items.NETHER_STAR);
        c("skin_dragon", "Драконий скин", Items.PHANTOM_MEMBRANE, "драконий скин");
        c("skin_inevitable", "Неизбежный скин", Items.PHANTOM_MEMBRANE, "неизбежный скин");
        v("gunpowder", "Порох", Items.GUNPOWDER, Items.GUNPOWDER);
        v("reinforced_deepslate", "Укреплённый глубинный сланец", Items.REINFORCED_DEEPSLATE, Items.REINFORCED_DEEPSLATE);
        c("pickled_eye", "Маринованный паучий глаз", Items.FERMENTED_SPIDER_EYE, "маринованный паучий глаз");
        c("tal_rage", "Талисман Ярости", Items.TOTEM_OF_UNDYING, "талисман ярости");
        c("mace_head", "Навершие булавы", Items.HEAVY_CORE, "навершие булавы");
    }
}