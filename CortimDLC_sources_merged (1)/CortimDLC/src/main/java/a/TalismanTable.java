/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_9334
 */
package a;

import a.ppi;
import a.ppn;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_9334;

public final class TalismanTable {
    private static final List<ppn> ppv = new ArrayList<ppn>();
    public static final String[] WARDEN_DEFAULTS;
    public static final String[] END_DEFAULTS;
    private static /* synthetic */ boolean ppw;
    private static /* synthetic */ long ppx;

    private TalismanTable() {
    }

    private static void ppy(String string, String string2, String string3, class_1792 class_17922, Predicate<ppi> predicate) {
        ppv.add(new ppn(string, string2, string3, class_17922, null, predicate));
    }

    private static void ppz(String string, String string2, String string3, class_1792 class_17922, String string4, Predicate<ppi> predicate) {
        ppv.add(new ppn(string, string2, string3, class_17922, string4, predicate));
    }

    private static void pqa(String string, String string2, String string3, String string4) {
        TalismanTable.ppz(string, string2, string3, class_1802.field_8288, "[★] " + string2, ppi2 -> ppi2.is(class_1802.field_8288) && ppi2.named("талисман") && ppi2.named(string4));
    }

    private static void pqb(String string, String string2, String string3, String string4) {
        TalismanTable.ppz(string, string2, string3, class_1802.field_8575, "[★] " + string2, ppi2 -> ppi2.is(class_1802.field_8575) && ppi2.named("сфер") && ppi2.named(string4));
    }

    private static boolean pqc(ppi ppi2) {
        return ppi2.is(class_1802.field_8626) && (ppi2.named("вайт") || ppi2.lore().contains("в 10 раз сильнее")) && !ppi2.lore().contains("способен взорвать обсидиан");
    }

    private static boolean pqd(ppi ppi2) {
        return ppi2.is(class_1802.field_8626) && (ppi2.named("блэк") || ppi2.lore().contains("способен взорвать обсидиан"));
    }

    private static boolean pqe(class_1799 class_17992) {
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 == null) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = false;
        for (class_1293 class_12932 : class_18442.method_57397()) {
            if (class_12932.method_5579() == class_1294.field_5909 && class_12932.method_5578() >= 5) {
                bl = true;
                continue;
            }
            if (class_12932.method_5579() != class_1294.field_5901) continue;
            bl2 = true;
        }
        return bl && bl2;
    }

    static String norm(String string) {
        return string == null ? "" : string.replaceAll("§.", "").toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
    }

    public static List<ppn> entries() {
        return Collections.unmodifiableList(ppv);
    }

    public static ppn byId(String string) {
        for (ppn ppn2 : ppv) {
            if (!ppn2.id.equals(string)) continue;
            return ppn2;
        }
        return null;
    }

    public static boolean known(class_1799 class_17992) {
        if (class_17992 == null || class_17992.method_7960()) {
            return false;
        }
        ppi ppi2 = new ppi(class_17992);
        for (ppn ppn2 : ppv) {
            if (!ppn2.test(ppi2)) continue;
            return true;
        }
        return false;
    }

    public static boolean picked(class_1799 class_17992, Collection<String> collection) {
        if (class_17992 == null || class_17992.method_7960() || collection == null || collection.isEmpty()) {
            return false;
        }
        ppi ppi2 = new ppi(class_17992);
        for (ppn ppn2 : ppv) {
            if (!collection.contains(ppn2.id) || !ppn2.test(ppi2)) continue;
            return true;
        }
        return false;
    }

    static {
        TalismanTable.ppy("elytra", "Элитры", "Elytra", class_1802.field_8833, ppi2 -> ppi2.is(class_1802.field_8833));
        TalismanTable.ppy("netherite_armor", "Незеритовая броня", "Netherite armour", class_1802.field_22028, ppi2 -> ppi2.is(class_1802.field_22027, class_1802.field_22028, class_1802.field_22029, class_1802.field_22030));
        TalismanTable.ppy("enchanted_apple", "Чарка", "Enchanted golden apple", class_1802.field_8367, ppi2 -> ppi2.is(class_1802.field_8367));
        TalismanTable.ppy("golden_apple", "Гэпл", "Golden apple", class_1802.field_8463, ppi2 -> ppi2.is(class_1802.field_8463));
        TalismanTable.ppz("potion_assassin", "Зелье Ассасина", "Assassin potion", class_1802.field_8436, "[★] Зелье Ассасина", ppi2 -> ppi2.potion() && ppi2.named("ассасин"));
        TalismanTable.ppz("potion_paladin", "Зелье Палладина", "Paladin potion", class_1802.field_8436, "[★] Зелье Палладина", ppi2 -> ppi2.potion() && ppi2.named("аладин"));
        TalismanTable.ppz("holy_water", "Святая вода", "Holy water", class_1802.field_8436, "[★] Святая вода", ppi2 -> ppi2.potion() && ppi2.named("свят", "вод"));
        TalismanTable.ppz("potion_radiation", "Зелье Радиации", "Radiation potion", class_1802.field_8436, "[★] Зелье Радиации", ppi2 -> ppi2.potion() && ppi2.named("радиац"));
        TalismanTable.ppy("diamond", "Алмаз", "Diamond", class_1802.field_8477, ppi2 -> ppi2.is(class_1802.field_8477));
        TalismanTable.ppy("silver", "Серебро", "Silver", class_1802.field_8675, ppi2 -> ppi2.is(class_1802.field_8675) || ppi2.named("серебр"));
        TalismanTable.ppy("netherite_scrap", "Незеритовый лом", "Netherite scrap", class_1802.field_22021, ppi2 -> ppi2.is(class_1802.field_22021) && !ppi2.says("трапк") && !ppi2.says("нерушимая клетка"));
        TalismanTable.ppy("netherite_ingot", "Незеритовый слиток", "Netherite ingot", class_1802.field_22020, ppi2 -> ppi2.is(class_1802.field_22020));
        TalismanTable.ppz("plast", "Пласт", "Plast", class_1802.field_8551, "[★] Пласт", ppi2 -> ppi2.named("пласт") || ppi2.lore().contains("нерушимая стена"));
        TalismanTable.ppz("trap", "Трапка", "Trap", class_1802.field_22021, "[★] Трапка", ppi2 -> ppi2.named("трапк") || ppi2.lore().contains("нерушимая клетка"));
        TalismanTable.ppz("disorient", "Дезориентация", "Disorientation", class_1802.field_8449, "[★] Дезориентация", ppi2 -> ppi2.named("дезориент") || ppi2.lore().contains("звуковая волна"));
        TalismanTable.ppz("dust", "Явная пыль", "Clear dust", class_1802.field_8479, "[★] Явная пыль", ppi2 -> ppi2.named("явная пыль") || ppi2.lore().contains("световая вспышка"));
        TalismanTable.ppy("netherite_sword", "Незеритовый меч", "Netherite sword", class_1802.field_22022, ppi2 -> ppi2.is(class_1802.field_22022));
        TalismanTable.ppy("skeleton_skull", "Череп скелета", "Skeleton skull", class_1802.field_8398, ppi2 -> ppi2.is(class_1802.field_8398));
        TalismanTable.ppy("wither_skull", "Череп визер-скелета", "Wither skeleton skull", class_1802.field_8791, ppi2 -> ppi2.is(class_1802.field_8791));
        TalismanTable.ppy("dragon_head", "Голова дракона", "Dragon head", class_1802.field_8712, ppi2 -> ppi2.is(class_1802.field_8712));
        TalismanTable.ppy("creeper_head", "Голова крипера", "Creeper head", class_1802.field_8681, ppi2 -> ppi2.is(class_1802.field_8681));
        TalismanTable.ppy("zombie_head", "Голова зомби", "Zombie head", class_1802.field_8470, ppi2 -> ppi2.is(class_1802.field_8470));
        TalismanTable.pqa("talisman_tyrant", "Талисман Тирана", "Tyrant talisman", "тиран");
        TalismanTable.pqa("talisman_discord", "Талисман Раздора", "Discord talisman", "раздор");
        TalismanTable.pqa("talisman_gloom", "Талисман Мрака", "Gloom talisman", "мрак");
        TalismanTable.pqa("talisman_whirl", "Талисман Вихря", "Whirl talisman", "вихр");
        TalismanTable.pqa("talisman_demon", "Талисман Демона", "Demon talisman", "демон");
        TalismanTable.pqb("sphere_beast", "Сфера Бестии", "Beast sphere", "бести");
        TalismanTable.pqb("sphere_icarus", "Сфера Икара", "Icarus sphere", "икар");
        TalismanTable.pqb("sphere_satyr", "Сфера Сатира", "Satyr sphere", "сатир");
        TalismanTable.pqb("sphere_ares", "Сфера Ареса", "Ares sphere", "арес");
        TalismanTable.pqb("sphere_chaos", "Сфера Хаоса", "Chaos sphere", "хаос");
        TalismanTable.pqb("sphere_hydra", "Сфера Гидры", "Hydra sphere", "гидр");
        TalismanTable.ppz("ice_arrow", "Стрела обледенения", "Ice arrow", class_1802.field_8087, "Стрела обледенения", ppi2 -> ppi2.is(class_1802.field_8087, class_1802.field_8107, class_1802.field_8236) && (ppi2.named("обледен") || TalismanTable.pqe(ppi2.stack)));
        TalismanTable.ppy("golden_carrot", "Золотая морковь", "Golden carrot", class_1802.field_8071, ppi2 -> ppi2.is(class_1802.field_8071));
        TalismanTable.ppz("god_aura", "Божья аура", "God's aura", class_1802.field_8614, "[★] Божья аура", ppi2 -> ppi2.named("божья аура") || ppi2.lore().contains("божественная аура"));
        TalismanTable.ppy("xp_bottle", "Опыт (все пузыри)", "XP (all bottles)", class_1802.field_8287, ppi2 -> ppi2.is(class_1802.field_8287) || ppi2.named("пузыр", "опыт"));
        TalismanTable.ppz("mod_fix", "Модификатор починки", "Repair modifier", class_1802.field_27063, "[⚡] Модификатор починки", ppi2 -> ppi2.named("модиф", "починк") || ppi2.lore().contains("/fix"));
        TalismanTable.ppy("mod_anvil", "Модификатор наковальни", "Anvil modifier", class_1802.field_8782, ppi2 -> ppi2.named("модиф", "наковальн") || ppi2.lore().contains("/anvil"));
        TalismanTable.ppz("mod_fly", "Модификатор полёта", "Flight modifier", class_1802.field_8153, "[⚡] Модификатор полёта", ppi2 -> ppi2.named("модиф", "полет") || ppi2.lore().contains("/fly"));
        TalismanTable.ppy("beacon", "Маяк", "Beacon", class_1802.field_8668, ppi2 -> ppi2.is(class_1802.field_8668));
        TalismanTable.ppz("airdrop", "Аирдроп", "Airdrop", class_1802.field_8530, "[★] Аирдроп", ppi2 -> ppi2.says("аирдроп") || ppi2.says("airdrop"));
        TalismanTable.ppy("undead_altar", "Алтарь нежити", "Undead altar", class_1802.field_23141, ppi2 -> ppi2.named("алтар"));
        TalismanTable.ppz("white_tnt", "Вайт", "White TNT", class_1802.field_8626, "[★] Вайт", TalismanTable::pqc);
        TalismanTable.ppz("black_tnt", "Блэк", "Black TNT", class_1802.field_8626, "[★] Блэк", TalismanTable::pqd);
        TalismanTable.ppy("tnt", "ТНТ", "TNT", class_1802.field_8626, ppi2 -> ppi2.is(class_1802.field_8626) && !TalismanTable.pqc(ppi2) && !TalismanTable.pqd(ppi2));
        TalismanTable.ppy("emerald_ore", "Изумрудная руда", "Emerald ore", class_1802.field_8837, ppi2 -> ppi2.is(class_1802.field_8837, class_1802.field_29216));
        TalismanTable.ppy("gold_ingot", "Золотые слитки", "Gold ingots", class_1802.field_8695, ppi2 -> ppi2.is(class_1802.field_8695));
        TalismanTable.ppz("lockpick", "Отмычки (все)", "Lockpicks (all)", class_1802.field_8366, "[★] Отмычка к Сферам", ppi2 -> ppi2.named("отмычк"));
        TalismanTable.ppy("zombie_villager_egg", "Яйцо призыва зомби-крестьянина", "Zombie villager spawn egg", class_1802.field_8136, ppi2 -> ppi2.is(class_1802.field_8136));
        TalismanTable.ppy("villager_egg", "Яйцо призыва крестьянина", "Villager spawn egg", class_1802.field_8086, ppi2 -> ppi2.is(class_1802.field_8086));
        TalismanTable.ppy("nether_star", "Звезда Незера", "Nether star", class_1802.field_8137, ppi2 -> ppi2.is(class_1802.field_8137));
        TalismanTable.ppz("dragon_skin", "Драконий скин", "Dragon skin", class_1802.field_8407, "[★] Драконий скин", ppi2 -> ppi2.says("драконий скин"));
        TalismanTable.ppz("inevitable_skin", "Неизбежный скин", "Inevitable skin", class_1802.field_8407, "[★] Неизбежный скин", ppi2 -> ppi2.says("неизбежный скин"));
        TalismanTable.ppy("gunpowder", "Порох", "Gunpowder", class_1802.field_8054, ppi2 -> ppi2.is(class_1802.field_8054));
        TalismanTable.ppy("reinforced_deepslate", "Укреплённый глубинный сланец", "Reinforced deepslate", class_1802.field_38418, ppi2 -> ppi2.is(class_1802.field_38418));
        TalismanTable.ppy("fermented_eye", "Маринованный паучий глаз", "Fermented spider eye", class_1802.field_8711, ppi2 -> ppi2.is(class_1802.field_8711));
        TalismanTable.pqa("talisman_fury", "Талисман Ярости", "Fury talisman", "ярост");
        TalismanTable.ppy("mace_head", "Навершие булавы", "Mace head", class_1802.field_49813, ppi2 -> ppi2.is(class_1802.field_49813) || ppi2.named("навершие"));
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (ppn ppn2 : ppv) {
            if (!ppn2.id.equals("talisman_fury") && !ppn2.id.equals("mace_head")) {
                arrayList.add(ppn2.id);
            }
            arrayList2.add(ppn2.id);
        }
        WARDEN_DEFAULTS = arrayList.toArray(new String[0]);
        END_DEFAULTS = arrayList2.toArray(new String[0]);
    }

    private static /* synthetic */ int bmk(int n, int n2) {
        return n ^ n2 ^ 0x4314B8CE;
    }

    private static /* synthetic */ int bml(int n, int n2) {
        return TalismanTable.bmk(n, n2) * n2;
    }
}

