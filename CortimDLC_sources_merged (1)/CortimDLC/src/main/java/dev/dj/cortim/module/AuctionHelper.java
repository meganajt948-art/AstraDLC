package dev.dj.cortim.module;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuctionHelper extends Module {

    // ================= НАСТРОЙКИ =================
    private final KeySetting  searchBind       = add(new KeySetting("Поиск по бинду", "Принудительно пересканировать страницу", -1));
    private final BoolSetting noThorns         = add(new BoolSetting("Без шипов", "Пропускать предметы с шипами", true));
    private final BoolSetting onlyUnbreaking5  = add(new BoolSetting("Только Прочность 5", "Зачарованные: нужна Прочность 5", true));
    private final BoolSetting onlyProtection5  = add(new BoolSetting("Только Защита 5", "Зачарованные: нужна Защита 5", true));
    private final BoolSetting onlyDepth3       = add(new BoolSetting("Только Подводная ходьба 3", "Зачарованные: нужна Подводная ходьба 3", true));
    private final BoolSetting onlyFullDur      = add(new BoolSetting("Только полная прочность", "Пропускать повреждённые", true));
    private final BoolSetting pricePerItem     = add(new BoolSetting("Цена за штуку", "Сравнивать цену за 1 предмет", true));
    private final BoolSetting highlightBest    = add(new BoolSetting("Подсветка общего минимума", "Золотая подсветка самого дешёвого", true));
    private final IntSetting  searchesPerMin   = add(new IntSetting("Поисков в минуту", "Частота пересканирования страницы", 20, 1, 60));

    // модуль сам знает о себе: не нужен Cortim.getAuctionHelper()
    private static AuctionHelper INSTANCE;
    private static boolean tooltipRegistered = false;

    public AuctionHelper() {
        super("AuctionHelper", Category.PLAYER);
        INSTANCE = this;
        registerRender(); // идемпотентно: можно вызывать и из Cortim, дублей не будет
    }

    // ================= ПАТТЕРНЫ =================
    private static final Pattern PRICE = Pattern.compile(
            "(?iu)(?:цена|price|стоимость)\\D{0,8}(\\d[\\d.,\\s]*)");
    private static final Pattern PRICE_DOLLAR = Pattern.compile(
            "\\$\\s*(\\d[\\d.,]*)");

    private static final String HI = "(?:V|VI|VII|VIII|IX|X|[5-9]|\\d{2})(?!\\w)";
    private static final Pattern P_PROT   = Pattern.compile("(?iu)(?:защита|protection)\\s+" + HI);
    private static final Pattern P_UNB    = Pattern.compile("(?iu)(?:прочность|unbreaking)\\s+" + HI);
    private static final Pattern P_DEPTH  = Pattern.compile("(?iu)(?:подводная ходьба|depth strider)\\s+(?:III|IV|V|[3-9])(?!\\w)");
    private static final Pattern P_THORNS = Pattern.compile("(?iu)(?:шипы|thorns)\\s+(?:[IVX]+|\\d+)(?!\\w)");
    // любая строка вида "Острота VII" — признак зачарования в лоре
    private static final Pattern P_ENCH_LINE = Pattern.compile(
            "(?u)^\\s*[\\p{L}' ]{3,}\\s+(?:[IVX]{1,5}|\\d{1,2})\\s*$");

    // цвета слота: заливка + рамка
    private static final int[] TIER_FILL   = {0x6655FF77, 0x66FFAA33, 0x66FF5555};
    private static final int[] TIER_BORDER = {0xFF55FF77, 0xFFFFAA33, 0xFFFF5555};

    // ================= СОСТОЯНИЕ =================
    private static final Set<Integer> BEST = new HashSet<>();        // slot.id самого дешёвого лота (золотая рамка)
    private static final Map<Integer, Integer> TIER = new HashMap<>(); // slot.id -> 0 зелёный / 1 жёлтый / 2 красный
    private static long lastScan = 0;
    private static int lastRevision = -1;
    private static ScreenHandler lastHandler = null;
    private static int dbgTotal = 0, dbgMatched = 0, dbgPriced = 0;
    private boolean lastBindDown = false;

    // ================= ТИК =================
    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (!isEnabled() || !(mc.currentScreen instanceof GenericContainerScreen gs)) {
            BEST.clear();
            TIER.clear();
            lastRevision = -1;
            lastHandler = null;
            lastBindDown = false;
            return;
        }
        update(gs.getScreenHandler());
    }

    /** Пересканирует страницу при смене окна/содержимого, по бинду и по таймеру. Вызывается и из тика, и из рендера. */
    private void update(GenericContainerScreenHandler h) {
        boolean down = searchBind.isDown();
        boolean pressed = down && !lastBindDown;
        lastBindDown = down;

        long now = System.currentTimeMillis();
        long interval = 60_000L / Math.max(1, searchesPerMin.get());

        if (h != lastHandler || h.getRevision() != lastRevision || pressed || now - lastScan >= interval) {
            scan(h);
            lastHandler = h;
            lastRevision = h.getRevision();
            lastScan = now;
        }
    }

    // ================= СКАН ЛОТОВ =================
    private record Lot(int slotId, double price) {}

    /**
     * На странице красится ровно по одному лоту каждого цвета (среди подошедших по фильтрам):
     * зелёный — самый дешёвый, красный — самый дорогой, жёлтый — средний по цене.
     */
    private void scan(GenericContainerScreenHandler h) {
        BEST.clear();
        TIER.clear();
        dbgTotal = 0;
        dbgMatched = 0;
        dbgPriced = 0;

        List<Lot> lots = new ArrayList<>();

        for (Slot slot : h.slots) {
            if (slot.inventory instanceof PlayerInventory) continue; // только лоты
            ItemStack st = slot.getStack();
            if (st.isEmpty()) continue;
            dbgTotal++;
            if (!matches(st)) continue;
            dbgMatched++;

            double p = price(st);
            if (p <= 0) continue; // нет цены в лоре (кнопки, декор) — не красим
            dbgPriced++;

            lots.add(new Lot(slot.id, p));
        }
        if (lots.isEmpty()) return;

        lots.sort(Comparator.comparingDouble(Lot::price));

        Lot cheapest = lots.get(0);
        TIER.put(cheapest.slotId(), 0);
        BEST.add(cheapest.slotId());

        Lot priciest = lots.get(lots.size() - 1);
        if (priciest.price() > cheapest.price()) {
            TIER.put(priciest.slotId(), 2);
        }
        if (lots.size() >= 3) {
            Lot mid = lots.get(lots.size() / 2);
            // жёлтый только если цена строго между минимумом и максимумом
            if (mid.price() > cheapest.price() && mid.price() < priciest.price()) {
                TIER.put(mid.slotId(), 1);
            }
        }
    }

    // ================= ФИЛЬТРЫ =================
    private boolean matches(ItemStack st) {
        if (onlyFullDur.get() && st.isDamageable() && st.isDamaged()) return false;
        if (noThorns.get() && (level(st, Enchantments.THORNS) > 0 || loreHas(st, P_THORNS))) return false;

        boolean anyFilter = onlyUnbreaking5.get() || onlyProtection5.get() || onlyDepth3.get();
        // блоки, еда, зелья и прочее без зачарований проходят без условий
        if (!anyFilter || !hasEnchants(st)) return true;

        return (onlyProtection5.get() && (level(st, Enchantments.PROTECTION)    >= 5 || loreHas(st, P_PROT)))
                || (onlyUnbreaking5.get() && (level(st, Enchantments.UNBREAKING)    >= 5 || loreHas(st, P_UNB)))
                || (onlyDepth3.get()      && (level(st, Enchantments.DEPTH_STRIDER) >= 3 || loreHas(st, P_DEPTH)));
    }

    private static boolean hasEnchants(ItemStack st) {
        if (!st.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT).isEmpty()) return true;
        if (!st.getOrDefault(DataComponentTypes.STORED_ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT).isEmpty()) return true;
        return loreHas(st, P_ENCH_LINE);
    }

    private static boolean loreHas(ItemStack st, Pattern p) {
        for (Text t : st.getOrDefault(DataComponentTypes.LORE, LoreComponent.DEFAULT).lines()) {
            if (p.matcher(t.getString()).find()) return true;
        }
        return false;
    }

    private static int level(ItemStack st, RegistryKey<Enchantment> key) {
        return Math.max(
                levelIn(st.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT), key),
                levelIn(st.getOrDefault(DataComponentTypes.STORED_ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT), key));
    }

    private static int levelIn(ItemEnchantmentsComponent comp, RegistryKey<Enchantment> key) {
        for (Object2IntMap.Entry<RegistryEntry<Enchantment>> e : comp.getEnchantmentEntries()) {
            if (e.getKey().matchesKey(key)) return e.getIntValue();
        }
        return 0;
    }

    // ================= ЦЕНА ИЗ ЛОРА =================
    private double price(ItemStack st) {
        LoreComponent lore = st.getOrDefault(DataComponentTypes.LORE, LoreComponent.DEFAULT);
        for (Text line : lore.lines()) {
            String s = line.getString();
            Matcher m = PRICE.matcher(s);
            if (!m.find()) {
                m = PRICE_DOLLAR.matcher(s);
                if (!m.find()) continue;
            }
            String digits = m.group(1).replaceAll("[^0-9]", "");
            if (digits.isEmpty()) continue;
            try {
                double p = Double.parseDouble(digits);
                return pricePerItem.get() ? p / Math.max(1, st.getCount()) : p;
            } catch (NumberFormatException ignored) {}
        }
        return -1;
    }

    // ================= РЕНДЕР =================
    /** Вызывается из Cortim.onInitializeClient(): подсветка зачарований в тултипе. */
    public static void registerRender() {
        if (tooltipRegistered) return;
        tooltipRegistered = true;

        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, lines) -> {
            AuctionHelper ah = INSTANCE;
            if (ah == null || !ah.isEnabled()) return;

            for (int i = 0; i < lines.size(); i++) {
                String s = lines.get(i).getString();

                boolean good = (ah.onlyProtection5.get() && P_PROT.matcher(s).find())
                        || (ah.onlyUnbreaking5.get() && P_UNB.matcher(s).find())
                        || (ah.onlyDepth3.get()      && P_DEPTH.matcher(s).find());
                boolean bad  = ah.noThorns.get() && P_THORNS.matcher(s).find();

                if (good) {
                    lines.set(i, Text.literal("» " + s).formatted(Formatting.GREEN, Formatting.BOLD));
                } else if (bad) {
                    lines.set(i, Text.literal("x " + s).formatted(Formatting.RED, Formatting.BOLD));
                }
            }
        });
    }

    /**
     * Вызывается из AuctionScreenMixin. Красит слоты лотов по цене:
     * зелёный — дёшево, жёлтый — средне, красный — дорого; золотая рамка — самый дешёвый.
     */
    public static void render(DrawContext ctx, int guiX, int guiY, ScreenHandler handler) {
        AuctionHelper ah = INSTANCE;
        if (ah == null || !ah.isEnabled()) return;

        // скан запускаем отсюда же, чтобы не зависеть от вызова onTick из Cortim
        if (handler instanceof GenericContainerScreenHandler gh) ah.update(gh);

        // если ничего не покрасилось — показываем, почему
        if (TIER.isEmpty()) {
            MinecraftClient mc = MinecraftClient.getInstance();
            String msg = "AuctionHelper: слотов " + dbgTotal + ", подошло по фильтрам " + dbgMatched
                    + ", цена найдена " + dbgPriced;
            ctx.drawTextWithShadow(mc.textRenderer, Text.literal(msg), guiX, guiY - 12, 0xFFAAAAAA);
        }

        // 1) цветовая заливка по цене
        if (!TIER.isEmpty()) {
            for (Slot slot : handler.slots) {
                Integer tier = TIER.get(slot.id);
                if (tier == null) continue;

                int x = guiX + slot.x, y = guiY + slot.y;
                ctx.fill(x, y, x + 16, y + 16, TIER_FILL[tier]);
                outline(ctx, x, y, 16, TIER_BORDER[tier]);
            }
        }

        // 2) золотая подсветка самых дешёвых
        if (!ah.highlightBest.get() || BEST.isEmpty()) return;

        double pulse = 0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 220.0);
        int a = 150 + (int) (105 * pulse);
        int border = (a << 24) | 0xFFD700;

        for (Slot slot : handler.slots) {
            if (!BEST.contains(slot.id)) continue;
            int x = guiX + slot.x, y = guiY + slot.y;

            outline(ctx, x,     y,     16, border);
            outline(ctx, x - 1, y - 1, 18, border);
        }
    }

    private static void outline(DrawContext c, int x, int y, int s, int color) {
        c.fill(x - 1, y - 1, x + s + 1, y,         color);
        c.fill(x - 1, y + s, x + s + 1, y + s + 1, color);
        c.fill(x - 1, y,     x,         y + s,     color);
        c.fill(x + s, y,     x + s + 1, y + s,     color);
    }
}