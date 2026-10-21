/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Lang;
import flow.dev.StringDecryptor;

final class LangEntriesB {
    private static /* synthetic */ long wbm;
    private static /* synthetic */ long wbn;

    private LangEntriesB() {
    }

    static void fill() {
        LangEntriesB.wbo();
        LangEntriesB.wbp();
        LangEntriesB.wbq();
    }

    private static void wbo() {
        Lang.p("Hits whoever is in your crosshair at the right moment: vanilla timing, predicted crits, sprint reset, never friends", "Бьёт того, кто под прицелом, в нужный момент: ванильный тайминг, предикт критов, сброс спринта, друзей не трогает");
        Lang.p("Mace smash on the right tick of your fall: predicts the fall, turns onto the target and takes the mace", "Удар булавой в нужный тик падения: предугадывает падение, доводит прицел до цели и сам берёт булаву");
        Lang.p("Smooth aim help with a weapon in hand: the neural model turns like a real hand, never onto friends", "Плавная помощь в наводке с оружием в руке: нейро-модель доводит как живая рука, друзей не трогает");
        Lang.p("Puts a totem in the offhand when health drops to the threshold and gives the old item back afterwards", "Берёт тотем во вторую руку, когда здоровье падает до порога, а потом возвращает прежний предмет");
        Lang.p("Sprints while you walk forward, strafing too, works with TriggerBot's sprint reset", "Бег при ходьбе вперёд, и со стрейфом тоже, не мешает сбросу спринта TriggerBot");
        Lang.p("Faster /fly flight: 40 b/s without inertia, 25 b/s up and down on jump and sneak", "Ускоряет полёт по /fly: 40 б/с без инерции, 25 б/с вверх и вниз на пробел и шифт");
        Lang.p("Timers over traps and plasts until they disappear, and a boss bar countdown while you are inside one", "Таймеры над трапками и пластами до исчезновения, а внутри — отсчёт в боссбаре");
        Lang.p("Faster right click while held: XP bottles, blocks or everything", "Быстрый ПКМ при удержании: пузырьки опыта, блоки или всё подряд");
        Lang.p("Fast stack moving: Shift + drag over slots, or the mouse wheel over an item", "Быстрый перенос стаков: Shift + проведение по слотам или колесо мыши над предметом");
        Lang.p("Sorts the opened chest on a key: merges stacks, then lays them out by type, name or count", "Сортирует открытый сундук по кнопке: объединяет стаки и раскладывает по типу, названию или количеству");
        Lang.p("Accepts teleport requests by itself: from friends only or from everyone", "Сам принимает запросы на телепорт: только от друзей или от всех");
        Lang.p("Sells your inventory on the /ah auction a little under the market by itself, can take items from nearby chests", "Сам продаёт инвентарь на аукционе /ah чуть ниже рынка, может брать вещи из ближних сундуков");
        Lang.p("Highlights the cheapest /ah lots. Middle click a lot to bind it, the search key looks it up", "Подсвечивает самые дешёвые лоты /ah. СКМ по лоту запоминает его, кнопка поиска ищет его");
        Lang.p("Keys for FunTime, HolyWorld and ReallyWorld donate items: uses them straight from the inventory, plus a potion wheel", "Бинды на донат-предметы FunTime, HolyWorld и ReallyWorld: использует прямо из инвентаря, плюс колесо зелий");
        Lang.p("Farms ancient debris in flight: blows up TNT and digs out what the blast reveals", "Автоматически фармит древние обломки в режиме полёта: взрывает динамит и выкапывает найденное");
        Lang.p("Highlights ancient debris revealed by TNT blasts", "Подсвечивает найденные древние обломки при взрыве динамита");
        Lang.p("Hold a key to look around with the camera while your player keeps facing and running the same way", "По кнопке камера осматривается вокруг, а игрок продолжает смотреть и бежать в ту же сторону");
        Lang.p("Hides the screen effects and HUD parts you pick: fire, darkness, nausea, scoreboard, boss bars and more", "Скрывает выбранные эффекты и части HUD: огонь, тьму, тошноту, скорборд, боссбары и другое");
        Lang.p("Tags over dropped items: icon, name and count, one tag for a pile of the same item", "Подписи над выпавшими предметами: иконка, название и количество, одинаковые рядом — одной подписью");
        Lang.p("A glowing effect on your current target: ghosts, sparkles, a ring, comets or lightning", "Светящийся эффект на текущей цели: призраки, искры, кольцо, кометы или молния");
        Lang.p("Shows where pearls, potions, arrows and tridents will fly and land, other players' pearls too", "Показывает, куда полетят и упадут жемчуг, зелья, стрелы и трезубцы, в том числе чужой жемчуг");
        Lang.p("Arrows around the crosshair pointing at nearby players, friends in their own colour", "Стрелки вокруг прицела на ближайших игроков, друзья — своим цветом");
        Lang.p("Swing animations for the held item, the mace shows its smash charge", "Анимации взмаха для предмета в руке, булава показывает заряд удара");
        Lang.p("Brighter nights and caves: lifts only the dark places or everything at once", "Светлее ночью и в пещерах: осветляет только тёмные места или всё сразу");
        Lang.p("Light shader look: richer colour, soft glow, a sharper image and a vignette, from presets or your own", "Лёгкие шейдеры: сочные цвета, мягкое свечение, чёткая картинка и виньетка, пресеты или свои настройки");
        Lang.p("Dropped items lie flat on the ground and tumble through the air", "Выпавшие предметы лежат плашмя на земле и кувыркаются в полёте");
        Lang.p("Smooth zoom on a key: the wheel zooms further, the mouse slows down with it", "Плавный зум по кнопке: колесом можно приблизить сильнее, мышь замедляется вместе с ним");
        Lang.p("Sounds for toggles and hits. Your own go in flow2/sounds", "Звуки модулей и ударов. Свои — в папку flow2/sounds");
        Lang.p("Shows saturation on the hunger bar", "Показывает насыщение на полоске голода");
        Lang.p("Wet ground after rain: puddles with reflections, ripples and footprints", "Мокрая земля после дождя: лужи с отражениями, рябь и следы");
    }

    private static void wbp() {
        Lang.p("Toward target", "К цели");
        Lang.p("Away from target", "От цели");
        Lang.p("Naked", "Голые");
        Lang.p("Invisible", "Невидимые");
        Lang.p("Armored", "В броне");
        Lang.p("Instant hit", "Мгновенный удар");
        Lang.p("Your own trained rotation for AutoMine, AutoEnd and AutoWarden", "Твоя обученная ротация для AutoMine, AutoEnd и AutoWarden");
        Lang.p("Search key", "Поиск по биндy");
        Lang.p("No Thorns", "Без шипов");
        Lang.p("Unbreaking 5 only", "Только Прочность 5");
        Lang.p("Protection 5 only", "Только Защита 5");
        Lang.p("Depth Strider 3 only", "Только Подводная ходьба 3");
        Lang.p("Full durability only", "Только полная прочность");
        Lang.p("Price per item", "Цена за штуку");
        Lang.p("Highlight cheapest total", "Подсветка общего минимума");
        Lang.p("Searches per minute", "Поисков в минуту");
        Lang.p("Under market", "Ниже рынка");
        Lang.p("Enchant similarity", "Схожесть чар");
        Lang.p("Hotbar too", "Хотбар тоже");
        Lang.p("From chests", "Из сундуков");
        Lang.p("Min strike height", "Мин. высота удара");
        Lang.p("Max strike height", "Макс. высота удара");
        Lang.p("Notifications", "Уведомления");
        Lang.p("Client notices: party, friends, modules", "Сообщения клиента: пати, друзья, модули");
        Lang.p("Stretched resolution: change the screen's width with a slider", "Растяг экрана: ширина картинки меняется ползунком");
        Lang.p("Ratio", "Соотношение");
        Lang.alias("AspectRatio", "аспект ратио растяг растянуть соотношение сторон ширина экрана стретч");
        Lang.p("Sensitivity", "Чувствительность");
        Lang.p("Aim away from target", "Наводка: от цели");
        Lang.p("Aim max speed", "Наводка: макс. скорость");
        Lang.p("Aim only while moving", "Наводка только в движении");
        Lang.p("Aim reaction", "Наводка: реакция");
        Lang.p("Aim smooth", "Наводка: плавность");
        Lang.p("Aim toward target", "Наводка: к цели");
        Lang.p("Aim yield to mouse", "Наводка: уступать мышке");
        Lang.p("Loot anarchy no.", "Анка лута");
        Lang.p("TNT from the stash", "Динамит со склада");
        Lang.p("Hub command", "Команда хаба");
        Lang.p("Carrots from the stash", "Морковь со склада");
        Lang.p("Fire resistance from the stash", "Огнестойкость со склада");
        Lang.p("Area search mode", "Режим поиска территории");
        Lang.p("Stacks before the stash", "Стаков до склада");
        Lang.p("Sells the inventory on the auction under the market by itself", "Сам продаёт инвентарь на аукционе ниже рынка");
        Lang.p("Neuro mining", "Нейро-копание");
        Lang.p("Wheel item 1", "Предмет колеса 1");
        Lang.p("Wheel item 2", "Предмет колеса 2");
        Lang.p("Wheel item 3", "Предмет колеса 3");
        Lang.p("Speeds the mouse up towards the target and slows it down away from it", "Ускоряет мышь к цели и замедляет от неё");
        Lang.p("Threshold", "Порог");
        Lang.p("Chat coordinates", "Координаты из чата");
        Lang.p("Mine profile", "Профиль копания");
        Lang.p("Walk profile", "Профиль ходьбы");
        Lang.p("Puts on netherite or diamond armour at once, swaps a breaking piece for a repaired one", "Сразу надевает незеритовую или алмазную броню, меняет ломающуюся на починенную");
        Lang.p("Swap below durability", "Менять при прочности до");
        Lang.p("From bundles", "Из мешков");
        Lang.p("Keep elytra", "Не снимать элитры");
        Lang.alias("AutoArmor", "автоброня броня авто армор надеть броню незерит алмаз мешок");
        Lang.p("Swaps the chestplate and the elytra on one key, uses a firework on the other", "Меняет нагрудник и элитры по одной кнопке, запускает фейерверк по другой");
        Lang.p("Swap key", "Кнопка свапа");
        Lang.p("Firework key", "Кнопка фейерверка");
        Lang.p("Bind the keys in its settings", "Назначь кнопки в настройках");
        Lang.p("No fireworks", "Нет фейерверков");
        Lang.alias("ElytraSwap", "элитры элитра свап элитр нагрудник крылья фейерверк феерверк");
        Lang.p("Hides your nickname everywhere on your screen: chat, tab, scoreboard, nametags, HUD", "Скрывает твой ник везде на экране: чат, таб, скорборд, ники над головой, HUD");
        Lang.p("Fake name", "Подменный ник");
        Lang.p("Friends too", "И друзей");
        Lang.p("Friends' name", "Ник друзей");
        Lang.alias("NameProtect", "нейм протект скрыть ник защита ника стрим");
        Lang.p("The words of the song you are listening to appear in the world in front of you", "Слова песни, которую ты слушаешь, красиво появляются в мире перед тобой");
        Lang.p("Anchor", "Привязка");
        Lang.p("Cover color", "Цвет обложки");
        Lang.p("Song title", "Название песни");
        Lang.p("Sync offset", "Сдвиг текста");
        Lang.alias("Lyrics", "лирика слова песни текст песни музыка караоке трек спотифай яндекс музыка");
    }

    private static void wbq() {
        Lang.v("Totem", "Тотем");
        Lang.v("EnchTotem", "Зачар. тотем");
        Lang.v("Sphere", "Сфера");
        Lang.v("Smooth", "Плавная");
        Lang.v("Static", "Статичная");
        Lang.v("Down", "Вниз");
        Lang.v("Poke", "Тычок");
        Lang.v("SelfBack", "На себя");
        Lang.v("ToBack", "Назад");
        Lang.v("Block", "Блок");
        Lang.v("Break", "Излом");
        Lang.v("Slant", "Наклон");
        Lang.v("Follow view", "За взглядом");
    }

    private static /* synthetic */ int dog(int n, int n2) {
        return (n ^ n2) + -939034772;
    }

    private static /* synthetic */ int doh(int n, int n2) {
        return n ^ n2 | 0xDA9A3E27;
    }
}

