/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.wah;
import a.wam;
import a.LangEntriesA;
import a.LangEntriesB;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class Lang {
    private static wam waq;
    private static boolean war;
    private static final Map<Integer, String> was;
    private static final Map<Integer, String> wat;
    private static final Map<Integer, String> wau;
    private static final Map<Integer, String> wav;
    private static final Map<Integer, String> waw;
    private static final String wax;
    private static final String way;
    public static final int NAME_EXACT = 100;
    public static final int NAME_START = 90;
    public static final int NAME_SOUND = 88;
    public static final int ALIAS = 85;
    public static final int NAME = 80;
    public static final int SETTING = 60;
    public static final int DESCRIPTION = 40;
    private static /* synthetic */ long waz;
    private static /* synthetic */ int wba;

    private Lang() {
    }

    public static wam get() {
        return waq;
    }

    public static boolean ru() {
        return waq == wam.RU;
    }

    public static boolean chosen() {
        return war;
    }

    public static void set(wam wam2) {
        waq = wam2;
        war = true;
    }

    public static void load(String string) {
        if (string == null) {
            return;
        }
        waq = "ru".equalsIgnoreCase(string.trim()) ? wam.RU : wam.EN;
        war = true;
    }

    public static String code() {
        return waq == wam.RU ? "ru" : "en";
    }

    public static String s(String string, String string2) {
        return waq == wam.RU ? string2 : string;
    }

    public static String t(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        String string2 = (waq == wam.RU ? was : wat).get(string.hashCode());
        return string2 != null ? string2 : string;
    }

    public static String value(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        String string2 = (waq == wam.RU ? wau : wav).get(string.hashCode());
        return string2 != null ? string2 : Lang.t(string);
    }

    /*
     * Exception decompiling
     */
    public static String unit(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static String both(String string) {
        if (string == null) {
            return "";
        }
        int n = string.hashCode();
        String string2 = was.get(n);
        String string3 = wat.get(n);
        String string4 = wau.get(n);
        String string5 = wav.get(n);
        StringBuilder stringBuilder = new StringBuilder(string);
        if (string2 != null) {
            stringBuilder.append(' ').append(string2);
        }
        if (string3 != null) {
            stringBuilder.append(' ').append(string3);
        }
        if (string4 != null) {
            stringBuilder.append(' ').append(string4);
        }
        if (string5 != null) {
            stringBuilder.append(' ').append(string5);
        }
        return stringBuilder.toString();
    }

    public static String names(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n = string.hashCode();
        String string2 = was.get(n);
        String string3 = wat.get(n);
        if (string2 != null) {
            stringBuilder.append('\n').append(string2);
        }
        if (string3 != null) {
            stringBuilder.append('\n').append(string3);
        }
        return stringBuilder.toString();
    }

    public static String aliases(String string) {
        return waw.getOrDefault(string.hashCode(), "");
    }

    public static boolean matches(String string, String string2) {
        return string2 == null || string2.isBlank() || Lang.score(string2, string, null, null, null) > 0;
    }

    public static int score(String string, String string2, String string3, String string4, String string5) {
        if (string == null || string.isBlank()) {
            return 0;
        }
        String string6 = Lang.wbb(string).trim();
        wah wah2 = new wah(string2, string3, string4, string5);
        String string7 = Lang.wbe(string6, "йцукенгшщзхъфывапролджэячсмитьбюё", "qwertyuiop[]asdfghjkl;'zxcvbnm,.`");
        String string8 = Lang.wbe(string6, "qwertyuiop[]asdfghjkl;'zxcvbnm,.`", "йцукенгшщзхъфывапролджэячсмитьбюё");
        String string9 = Lang.wbg(string6);
        int n = wah2.score(string6);
        if (Lang.wbf(string6).length() < 2) {
            return n;
        }
        for (String string10 : new String[]{string7, string8, string9}) {
            if (string10.equals(string6)) continue;
            n = Math.max(n, wah2.score(string10) - 2);
        }
        return Math.max(0, n);
    }

    private static String wbb(String string) {
        return string.toLowerCase(Locale.ROOT).replace('\u0451', '\u0435');
    }

    private static String[] wbc(String string) {
        if (string == null || string.isEmpty()) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        char c = '\u0000';
        for (int i = 0; i < string.length(); ++i) {
            char c2 = string.charAt(i);
            if (!Character.isLetterOrDigit(c2)) {
                Lang.wbd(stringBuilder, arrayList);
            } else {
                if (Character.isUpperCase(c2) && Character.isLowerCase(c)) {
                    Lang.wbd(stringBuilder, arrayList);
                }
                stringBuilder.append(c2);
            }
            c = c2;
        }
        Lang.wbd(stringBuilder, arrayList);
        return arrayList.toArray(new String[0]);
    }

    private static void wbd(StringBuilder stringBuilder, List<String> list) {
        if (!stringBuilder.isEmpty()) {
            list.add(Lang.wbb(stringBuilder.toString()));
            stringBuilder.setLength(0);
        }
    }

    private static String wbe(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            int n = string2.indexOf(c);
            stringBuilder.append(n >= 0 ? string3.charAt(n) : c);
        }
        return stringBuilder.toString();
    }

    private static String wbf(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (!Character.isLetterOrDigit(c)) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static String wbg(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + 4);
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            stringBuilder.append(switch (c) {
                case '\u0430' -> "a";
                case '\u0431' -> "b";
                case '\u0432' -> "v";
                case '\u0433' -> "g";
                case '\u0434' -> "d";
                case '\u0435', '\u044d' -> "e";
                case '\u0436' -> "zh";
                case '\u0437' -> "z";
                case '\u0438' -> "i";
                case '\u0439' -> "y";
                case '\u043a' -> "k";
                case '\u043b' -> "l";
                case '\u043c' -> "m";
                case '\u043d' -> "n";
                case '\u043e' -> "o";
                case '\u043f' -> "p";
                case '\u0440' -> "r";
                case '\u0441' -> "s";
                case '\u0442' -> "t";
                case '\u0443' -> "u";
                case '\u0444' -> "f";
                case '\u0445' -> "h";
                case '\u0446' -> "c";
                case '\u0447' -> "ch";
                case '\u0448' -> "sh";
                case '\u0449' -> "sch";
                case '\u044b' -> "y";
                case '\u044e' -> "yu";
                case '\u044f' -> "ya";
                case '\u044a', '\u044c' -> "";
                default -> String.valueOf(c);
            });
        }
        return stringBuilder.toString();
    }

    private static String wbh(String string) {
        String string2 = string.replace("ck", "k").replace("ph", "f").replace("ee", "i").replace("ea", "i").replace("oo", "u").replace("au", "av").replace("ey", "ei").replace("ay", "ei").replace("x", "ks").replace("qu", "kv").replace('q', 'k').replace('c', 'k').replace('w', 'v').replace('y', 'i').replace("zh", "j").replace("sh", "s");
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        char c = '\u0000';
        for (int i = 0; i < string2.length(); ++i) {
            char c2 = string2.charAt(i);
            if (c2 != c) {
                stringBuilder.append(c2);
            }
            c = c2;
        }
        return stringBuilder.toString();
    }

    static void p(String string, String string2) {
        was.put(string.hashCode(), string2);
        wat.putIfAbsent(string2.hashCode(), string);
    }

    static void v(String string, String string2) {
        wau.put(string.hashCode(), string2);
        wav.putIfAbsent(string2.hashCode(), string);
    }

    static void alias(String string, String string2) {
        waw.put(string.hashCode(), string2);
    }

    static {
        wax = "йцукенгшщзхъфывапролджэячсмитьбюё";
        way = "qwertyuiop[]asdfghjkl;'zxcvbnm,.`";
        waq = wam.EN;
        was = new HashMap<Integer, String>();
        wat = new HashMap<Integer, String>();
        wau = new HashMap<Integer, String>();
        wav = new HashMap<Integer, String>();
        waw = new HashMap<Integer, String>();
        Lang.p("Combat", "Бой");
        Lang.p("Movement", "Движение");
        Lang.p("Player", "Игрок");
        Lang.p("Render", "Визуалы");
        Lang.p("Misc", "Разное");
        Lang.p("Theme", "Тема");
        Lang.p("Configs", "Конфиги");
        Lang.p("Waypoints", "Метки");
        Lang.p("Friends", "Друзья");
        Lang.p("Cosmetics", "Косметика");
        Lang.p("Wings", "Крылья");
        Lang.p("Pets", "Питомцы");
        Lang.p("Hats", "Шапки");
        Lang.p("Backpacks", "Рюкзаки");
        Lang.p("Capes", "Плащи");
        Lang.p("Cosmetic particles", "Частицы косметики");
        Lang.p("Pet in first person", "Питомец от первого лица");
        Lang.p("Take everything off", "Снять всё");
        Lang.p("Wings, pets, hats, backpacks and capes. Seen in F5, in the inventory and by your party", "Крылья, питомцы, шапки, рюкзаки и плащи. Видно в F5, в инвентаре и твоей пати");
        Lang.p("Party cosmetics", "Косметика пати");
        Lang.p("Avatars", "Облик");
        Lang.p("Replaces your whole player model: animations, physics and particles", "Заменяет всю модель игрока: анимации, физика и частицы");
        Lang.p("Click to put on, click again to take off", "Клик — надеть, ещё клик — снять");
        Lang.p("Floats by your shoulder and follows you", "Парит у плеча и следует за тобой");
        Lang.p("By your shoulder, or running after you on the ground: Pet mode above", "У плеча или бегает за тобой по земле: режим «Питомец» выше");
        Lang.p("Glasses", "Очки");
        Lang.p("On your face, worn together with any hat", "На лице, носятся вместе с любой шапкой");
        Lang.p("Animated and live video capes, replace your own cape while worn", "Анимированные и живые видео-плащи, заменяют твой плащ, пока надеты");
        Lang.p("On your head, turns with it", "На голове, поворачивается вместе с ней");
        Lang.p("On your back, with wings or without", "На спине, можно вместе с крыльями");
        Lang.p("Animated, replace your own cape while worn", "Анимированные, заменяют твой плащ, пока надеты");
        Lang.p("Search", "Поиск");
        Lang.p("Hits the target under your crosshair", "Бьёт цель под прицелом");
        Lang.p("Mace smash timed to your fall", "Удар булавой в тайминг падения");
        Lang.p("Smooth aim help with a weapon", "Плавная помощь в наводке с оружием");
        Lang.p("Offhand swap and a 3-item wheel on a key", "Свап во вторую руку и колесо из 3 предметов");
        Lang.p("Keeps a totem in the offhand", "Держит тотем во второй руке");
        Lang.p("Your hits never land on friends", "Удары не попадают по друзьям");
        Lang.p("Throws an ender pearl on a key", "Кидает эндер-жемчуг по кнопке");
        Lang.p("Move with the inventory or menu open", "Движение с открытым инвентарём или меню");
        Lang.p("Jump again the instant you land", "Прыжок сразу после приземления");
        Lang.p("Sprints while you walk forward", "Авто-бег при ходьбе вперёд");
        Lang.p("Look around without turning your player", "Осмотр без поворота игрока");
        Lang.p("Hides effects and HUD parts you pick", "Скрывает выбранные эффекты и части HUD");
        Lang.p("Tags above players: name, health, armour", "Теги над игроками: ник, здоровье, броня");
        Lang.p("Tags over dropped items", "Подписи над выпавшими предметами");
        Lang.p("An effect on your current target", "Эффект на текущей цели");
        Lang.p("Where throws and shots will land", "Куда прилетит бросок или выстрел");
        Lang.p("Arrows pointing at players around you", "Стрелки на игроков вокруг");
        Lang.p("A clean outline on the block you aim at", "Аккуратная обводка блока под прицелом");
        Lang.p("Chosen blocks seen through walls", "Выбранные блоки видно сквозь стены");
        Lang.p("Players through walls: outline or box", "Игроки сквозь стены: обводка или бокс");
        Lang.p("Friends turn see-through", "Друзья становятся прозрачными");
        Lang.p("Invisible players show up see-through", "Невидимых игроков видно прозрачными");
        Lang.p("A circle where you jump", "Круг в месте прыжка");
        Lang.p("A soul or glass copy on a kill", "Душа или стеклянная копия при убийстве");
        Lang.p("Move, turn and resize your hands", "Двигай, крути и меняй размер рук");
        Lang.p("Swing animations for the held item", "Анимации взмаха предметом в руке");
        Lang.p("A soft glow around your hands", "Мягкое свечение вокруг рук");
        Lang.p("Your colour instead of the red hit flash", "Свой цвет вместо красной вспышки при ударе");
        Lang.p("Brighter nights and caves", "Светлее ночью и в пещерах");
        Lang.p("Your own time of day, on your screen", "Своё время суток, только у вас");
        Lang.p("Animated shader sky", "Анимированное шейдерное небо");
        Lang.p("Seasons and weather effects", "Времена года и погода");
        Lang.p("Volumetric fog that curls around you", "Объёмный туман, клубится вокруг");
        Lang.p("Smooth motion blur, hand and HUD stay sharp", "Плавный моушен-блюр, рука и HUD чёткие");
        Lang.p("Richer colour, soft glow, crisp image", "Сочные цвета, мягкое свечение, чёткая картинка");
        Lang.p("Items lie flat and tumble", "Предметы лежат плашмя и кувыркаются");
        Lang.p("Smooth tab list, chat and inventories", "Плавные таб, чат и инвентари");
        Lang.p("Timers over the Warden chests", "Таймеры над сундуками Вардена");
        Lang.p("Timers over traps and plasts", "Таймеры над трапками и пластами");
        Lang.p("Fly the camera, your player stays", "Свободная камера, игрок стоит");
        Lang.p("Takes the best tool while you mine", "Берёт лучший инструмент при копке");
        Lang.p("Clears the anarchy auto-mines by itself", "Сам чистит авто-шахты анархий");
        Lang.p("Faster right click while held", "Быстрее ПКМ при удержании");
        Lang.p("Shift drag and wheel to move stacks", "Перенос стаков через Shift и колесо");
        Lang.p("See inside a shulker on hover", "Загляни в шалкер при наведении");
        Lang.p("Sorts the open chest on a key", "Сортирует открытый сундук по кнопке");
        Lang.p("Takes your listed items from chests", "Забирает из сундуков предметы из списка");
        Lang.p("Empties the chests you open", "Опустошает открытые сундуки");
        Lang.p("Accepts teleport requests by itself", "Сам принимает запросы телепорта");
        Lang.p("Buys your listed items on /ah", "Скупает предметы из списка на /ah");
        Lang.p("Sells your inventory on /ah under market", "Продаёт инвентарь на /ah ниже рынка");
        Lang.p("Highlights the cheapest /ah lots", "Подсвечивает самые дешёвые лоты /ah");
        Lang.p("Breaks End pots, keeps your loot", "Ломает энд-поты, берёт нужный лут");
        Lang.p("Loots the Warden town chests by timers", "Собирает сундуки города Варден по таймерам");
        Lang.p("Extra bot accounts for farming", "Доп-аккаунты-боты для фарма");
        Lang.p("Sounds for toggles and hits", "Звуки для модулей и ударов");
        Lang.p("Longer chat, merged repeats, copy on click", "Длиннее чат, склейка повторов, копия по клику");
        Lang.p("More FPS: uncaps frames, heavy effects off", "Больше FPS: без лимита кадров, тяжёлые эффекты off");
        Lang.p("Smooth zoom on a key", "Плавный зум по кнопке");
        Lang.p("Items lie flat and tumble", "Предметы лежат плашмя и кувыркаются");
        Lang.p("Hides effects and HUD parts", "Скрывает эффекты и части HUD");
        Lang.p("Timers over traps and plasts until they disappear", "Таймеры над трапками и пластами до исчезновения");
        Lang.p("Tags over dropped items", "Подписи над выпавшими предметами");
        Lang.p("Keys for server donate items: uses them straight from the inventory", "Бинды на донат-предметы сервера: использует прямо из инвентаря");
        Lang.p("Volumetric smoke fog that curls, drifts and parts around you", "Объёмный дымный туман: клубится, плывёт и расступается вокруг");
        Lang.p("Glass tags above players: name, health, armour, hands", "Теги над игроками: ник, здоровье, броня, руки");
        Lang.p("Where throws and shots land", "Куда прилетит бросок или выстрел");
        Lang.p("Your colour instead of the red flash on hits", "Свой цвет вместо красной вспышки при ударе");
        Lang.p("Accepts teleport requests from friends", "Принимает запросы на телепорт от друзей");
        Lang.p("Richer colour, soft glow, crisp image", "Сочные цвета, мягкое свечение, чёткая картинка");
        Lang.p("Shift drag and wheel to move stacks", "Перенос стаков через Shift и колесо мыши");
        Lang.p("Smooth aim help with weapons", "Плавная помощь в наводке с оружием");
        Lang.p("Helps your own mouse: faster to the target, softer on it", "Помогает твоей мыши: быстрее к цели, мягче на ней");
        Lang.p("Speed spread", "Разброс скорости");
        Lang.p("Slowdown", "Торможение на цели");
        Lang.p("Fights the nearest target with the neural rotation", "Бьёт ближайшую цель на нейро-ротации");
        Lang.p("Move fix", "Коррекция движения");
        Lang.p("Aim", "Наводка");
        Lang.v("Neural", "Нейро");
        Lang.v("Common", "Обычная");
        Lang.v("Fast", "Быстрая");
        Lang.v("Mythic", "Мифическая");
        Lang.v("Legendary", "Легендарная");
        Lang.v("Shard", "Шард");
        Lang.p("Neural model", "Нейро-модель");
        Lang.v("Profile 1", "Профиль 1");
        Lang.v("Studio", "Из студии");
        Lang.p("Aim height", "Высота прицела");
        Lang.p("Height from", "Высота от");
        Lang.p("Height to", "Высота до");
        Lang.v("Model", "Как у меня");
        Lang.p("Fly the camera, your player stays", "Свободная камера, игрок стоит на месте");
        Lang.p("Key: swaps the offhand between the From and To items", "По кнопке меняет предмет во второй руке");
        Lang.p("Offhand swap on a key, and a wheel of 3 items of your choice", "Свап во вторую руку по кнопке и колесо из 3 своих предметов");
        Lang.p("Swap key", "Кнопка свапа");
        Lang.p("Wheel key", "Кнопка колеса");
        Lang.p("Item wheel", "Колесо предметов");
        Lang.p("Animated shader sky: aurora, nebula, galaxy, sunset, clouds", "Анимированное шейдерное небо: аврора, туманность, галактика, закат, облака");
        Lang.p("Palette", "Палитра");
        Lang.p("Stars", "Звёзды");
        Lang.p("Horizon blend", "Слияние с горизонтом");
        Lang.p("Motion", "Движение");
        Lang.p("Menu background: live skies, moving photos, your own pictures", "Фон меню: живое небо, ожившие фото, свои картинки");
        Lang.p("Points at players around you", "Стрелки на игроков вокруг");
        Lang.p("A clean outline on the block you look at", "Аккуратная обводка блока под прицелом");
        Lang.p("Throws an ender pearl on a key, straight from the inventory", "Кидает эндер-жемчуг по кнопке прямо из инвентаря");
        Lang.p("Faster right click for XP bottles", "Быстрый ПКМ для пузырьков опыта");
        Lang.p("Brighter nights and caves", "Светлее ночью и в пещерах");
        Lang.p("Your hits never land on friends", "Удары никогда не попадают по друзьям");
        Lang.p("Apple sounds for toggles and hits. Originals go in flow2/sounds", "Звуки Apple для модулей и ударов. Оригиналы - в папку flow2/sounds");
        Lang.p("Your own time of day, only on your screen", "Своё время суток, только у вас на экране");
        Lang.p("Mace smashes in time: predicted fall, neural rotation onto the target", "Удары булавой в тайминг: предикт падения, нейро-ротация на цель");
        Lang.p("Attacks the entity in your crosshair (vanilla timing, predicted crits)", "Бьёт цель под прицелом (ванильный тайминг, предсказание критов)");
        Lang.p("An effect on the one you fight", "Эффект на цели, с которой деритесь");
        Lang.p("Look around without turning", "Осматривайтесь, не поворачивая игрока");
        Lang.p("Jump again the instant you land", "Прыжок сразу после приземления");
        Lang.p("Sprints while you walk straight forward", "Бег при ходьбе прямо вперёд");
        Lang.p("Seasons and weather: snow, petals, summer clouds and sun rays, falling leaves or a thunderstorm with rain", "Времена года и погода: снег, лепестки, летние облака и лучи солнца, листопад или гроза с дождём");
        Lang.p("Walk, run and jump with the inventory or the menu open", "Ходьба, бег и прыжки с открытым инвентарём или меню");
        Lang.p("More FPS: no frame cap, heavy vanilla effects off", "Больше FPS: без лимита кадров, тяжёлые эффекты ванилы выключены");
        Lang.p("Smooth motion blur: turning and moving smear the world, the hand and HUD stay sharp", "Плавное размытие в движении: при поворотах и беге мир смазывается, рука и HUD остаются чёткими");
        Lang.p("Puts a totem in the offhand when health drops low", "Берёт тотем во вторую руку, когда здоровье падает ниже порога");
        Lang.p("Takes the best tool while you mine, from the inventory too, and puts it back", "Берёт лучший инструмент при копании, в том числе из инвентаря, и возвращает обратно");
        Lang.p("Goes round the anarchies' auto-mines, waits for the best one to refresh and mines its ores", "Обходит анархии, ждёт обновления лучшей авто-шахты и копает её руды");
        Lang.p("Anarchies", "Анархии");
        Lang.p("Hop between anarchies", "Переходить по анархиям");
        Lang.p("Anarchy command", "Команда анархии");
        Lang.p("Mine command", "Команда шахты");
        Lang.p("Min. mine", "Мин. шахта");
        Lang.p("Wait if refresh within", "Ждать, если до обновления");
        Lang.p("Be there before", "Быть на месте за");
        Lang.p("Min. mining time", "Мин. время копания");
        Lang.p("Max. mining time", "Макс. время копания");
        Lang.p("Ores", "Руды");
        Lang.p("Turn speed", "Скорость поворота");
        Lang.p("Sprint", "Бег");
        Lang.p("Wait on the stairs", "Ждать на ступеньках");
        Lang.p("Stairs", "Ступеньки");
        Lang.p("Go down if refresh in more than", "Спускаться, если до обновления");
        Lang.p("Sit", "Садиться");
        Lang.p("3x3 pickaxe", "Кирка 3×3");
        Lang.p("Drop junk", "Выкидывать мусор");
        Lang.p("Junk", "Мусор");
        Lang.p("Diamonds only", "Только алмазы");
        Lang.p("Digging depth", "Глубина копания");
        Lang.p("Inventory layout", "Раскладка инвентаря");
        Lang.p("Eat golden carrots", "Есть золотую морковь");
        Lang.p("Turn on auto-selling", "Включать авто-скупку");
        Lang.p("Buyer command", "Команда скупщика");
        Lang.p("Stash anarchy", "Анка склада");
        Lang.p("Stash command", "Команда склада");
        Lang.p("To the stash if durability below", "На склад, если прочность ниже");
        Lang.p("To the stash if diamonds over", "На склад, если алмазов больше");
        Lang.p("To the stash if HP below", "На склад, если HP ниже");
        Lang.p("Repair the pickaxe to", "Чинить кирку до");
        Lang.p("Craft XP if the chest has less than", "Крафтить опыт, если в сундуке меньше");
        Lang.p("Respawn", "Возрождаться");
        Lang.p("Messages", "Сообщения");
        Lang.p("Auto-save", "Автосохранение");
        Lang.p("Load on start", "Загружать при запуске");
        Lang.p("Protect friends", "Защищать друзей");
        Lang.p("Show waypoints", "Показывать метки");
        Lang.p("Colour", "Цвет");
        Lang.p("Color", "Цвет");
        Lang.p("Coordinates", "Координаты");
        Lang.p("Distance", "Дистанция");
        Lang.p("Size", "Размер");
        Lang.p("Ping", "Пинг");
        Lang.p("Time", "Время");
        Lang.p("Toggle alerts", "Уведомления модулей");
        Lang.p("Account", "Аккаунт");
        Lang.p("Music", "Музыка");
        Lang.p("View", "Вид");
        Lang.p("Expand on new track", "Раскрывать на новом треке");
        Lang.p("Cover", "Обложка");
        Lang.p("Players only", "Только игроки");
        Lang.p("Armor and hands", "Броня и руки");
        Lang.p("Hide vanilla icons", "Скрыть ванильные иконки");
        Lang.p("Time bars", "Полоски времени");
        Lang.p("Bar colour", "Цвет полосок");
        Lang.p("Show", "Показывать");
        Lang.p("Background", "Фон");
        Lang.p("Opacity", "Непрозрачность");
        Lang.p("Arrange in chat", "Расставлять в чате");
        Lang.p("Layout", "Расположение");
        Lang.p("Durability", "Прочность");
        Lang.p("Hands", "Руки");
        Lang.p("Fit", "Масштаб");
        Lang.p("Darken", "Затемнение");
        Lang.p("Server", "Сервер");
        Lang.p("Background hue", "Оттенок фона");
        Lang.p("Background saturation", "Насыщенность фона");
        Lang.p("Background brightness", "Яркость фона");
        Lang.p("Contrast", "Контраст");
        Lang.p("Accent", "Акцент");
        Lang.p("Gradient", "Градиент");
        Lang.p("Hue", "Оттенок");
        Lang.p("Saturation", "Насыщенность");
        Lang.p("Brightness", "Яркость");
        Lang.p("Style", "Стиль");
        Lang.p("Scale", "Масштаб");
        Lang.p("Roundness", "Скругление");
        Lang.p("Animations", "Анимации");
        Lang.p("Blur world", "Размытие мира");
        Lang.p("Dim world", "Затемнение мира");
        Lang.p("Key", "Кнопка");
        Lang.p("Press", "Нажатие");
        Lang.p("Zoom", "Зум");
        Lang.p("Speed", "Скорость");
        Lang.p("Scroll", "Колесо мыши");
        Lang.p("Slow mouse", "Медленная мышь");
        Lang.p("Cinematic", "Кинематографично");
        Lang.p("Shift drag", "Перенос с Shift");
        Lang.p("Wheel", "Колесо");
        Lang.p("Smooth", "Плавность");
        Lang.p("Items", "Предметы");
        Lang.p("Every", "Каждые");
        Lang.p("Liquid Glass", "Жидкое стекло");
        Lang.p("Frost", "Матовость");
        Lang.p("Refraction", "Преломление");
        Lang.p("Edge", "Край");
        Lang.p("Dispersion", "Дисперсия");
        Lang.p("Highlight", "Блик");
        Lang.p("Light angle", "Угол света");
        Lang.p("Vibrancy", "Сочность");
        Lang.p("Tint", "Тонировка");
        Lang.p("Window", "Окно");
        Lang.p("Tab pill", "Выделение вкладки");
        Lang.p("Group boxes", "Карточки");
        Lang.p("Popups", "Всплывающие окна");
        Lang.p("From", "От");
        Lang.p("To", "На");
        Lang.p("Command", "Команда");
        Lang.p("Delay", "Задержка");
        Lang.p("Mode", "Режим");
        Lang.p("Hit color", "Цвет удара");
        Lang.p("Mobs", "Мобы");
        Lang.p("Strength", "Сила");
        Lang.p("Shimmer", "Мерцание");
        Lang.p("Toggle", "Включение");
        Lang.p("Hit", "Удар");
        Lang.p("Menu", "Меню");
        Lang.p("Sound files", "Файлы звуков");
        Lang.p("Volume", "Громкость");
        Lang.p("Pearls", "Жемчуг");
        Lang.p("Bows", "Луки и арбалеты");
        Lang.p("Tridents", "Трезубцы");
        Lang.p("Throwables", "Метательное");
        Lang.p("Flying pearls", "Летящий жемчуг");
        Lang.p("Path", "Траектория");
        Lang.p("Night", "Ночь");
        Lang.p("Caves", "Пещеры");
        Lang.p("Look", "Пресет");
        Lang.p("Warmth", "Теплота");
        Lang.p("Vignette", "Виньетка");
        Lang.p("Sharpen", "Резкость");
        Lang.p("Glow", "Свечение");
        Lang.p("FOV", "Угол обзора");
        Lang.p("Vertical", "По вертикали");
        Lang.p("Priority", "Приоритет");
        Lang.p("Click only", "Только с кликом");
        Lang.p("Players", "Игроки");
        Lang.p("Through walls", "Сквозь стены");
        Lang.p("Aim trained on your own rotation", "Аим, обученный на твоей ротации");
        Lang.p("Studio", "Студия");
        Lang.p("Open studio", "Открыть студию");
        Lang.p("New profile", "Новый профиль");
        Lang.p("Texture", "Живость");
        Lang.p("Preset", "Пресет");
        Lang.p("Activation", "Активация");
        Lang.p("Aim key", "Кнопка аима");
        Lang.p("Yield to mouse", "Уступать мышке");
        Lang.p("Stop stands", "Убрать стенды");
        Lang.v("On attack", "При атаке");
        Lang.v("On key", "По кнопке");
        Lang.p("Width", "Толщина");
        Lang.p("Fill", "Заливка");
        Lang.p("Spin", "Вращение");
        Lang.p("Fire", "Огонь");
        Lang.p("Lava", "Лава");
        Lang.p("Scoreboard", "Скорборд");
        Lang.p("Hurt shake", "Тряска от урона");
        Lang.p("View bobbing", "Покачивание камеры");
        Lang.p("Darkness", "Тьма");
        Lang.p("Blindness", "Слепота");
        Lang.p("Nausea", "Тошнота");
        Lang.p("Attack indicator", "Индикатор атаки");
        Lang.p("Effects", "Эффекты");
        Lang.p("Boss bar", "Боссбар");
        Lang.p("Bubbles", "Пузырьки воздуха");
        Lang.p("Glowing", "Подсветка");
        Lang.p("Rain", "Дождь");
        Lang.p("Pumpkin", "Тыква");
        Lang.p("Crits", "Криты");
        Lang.p("Predict", "Предугадывать");
        Lang.p("SprintReset", "Сброс спринта");
        Lang.p("Keep sprint", "Не сбрасывать спринт");
        Lang.p("Sprint reset", "Сброс спринта");
        Lang.p("Clear", "Очистить");
        Lang.p("Info", "Инфо");
        Lang.p("MaceSmash", "Удар булавой");
        Lang.p("Reaction", "Реакция");
        Lang.p("Range", "Дальность");
        Lang.p("Radius", "Радиус");
        Lang.p("Friend color", "Цвет друзей");
        Lang.p("Icon", "Иконка");
        Lang.p("Merge", "Объединять");
        Lang.p("Rarity colour", "Цвет редкости");
        Lang.p("Blur", "Размытие");
        Lang.p("Rounding", "Скругление");
        Lang.p("Shrink", "Меньше вдали");
        Lang.p("Health", "Здоровье");
        Lang.p("Self", "Себя");
        Lang.p("Menu key", "Кнопка меню");
        Lang.p("Friend key", "Кнопка друга");
        Lang.p("Season", "Сезон");
        Lang.p("Intensity", "Интенсивность");
        Lang.p("Particles", "Частицы");
        Lang.p("Ground cover", "Покров земли");
        Lang.p("Colour grade", "Цветокоррекция");
        Lang.p("Clouds", "Тучи");
        Lang.p("Cold", "Холод");
        Lang.p("Cumulus", "Облака");
        Lang.p("Sun rays", "Лучи солнца");
        Lang.p("Light shafts", "Свет в дымке");
        Lang.p("Cloud shadows", "Тени облаков");
        Lang.p("Sky", "Небо");
        Lang.p("Wetness", "Мокрость");
        Lang.p("Puddles", "Лужи");
        Lang.p("Reflections", "Отражения");
        Lang.p("Drops", "Капли");
        Lang.p("Rainfall", "Сила дождя");
        Lang.p("Lightning", "Молнии");
        Lang.p("Gloom", "Мрачность");
        Lang.p("Lens drops", "Капли на экране");
        Lang.p("Footprints", "Следы");
        Lang.p("Footprint time", "Время следов");
        Lang.p("Only under the sky", "Только под небом");
        Lang.p("Quality", "Качество");
        Lang.p("Frame limit", "Лимит кадров");
        Lang.p("No vsync", "Без VSync");
        Lang.p("No entity shadows", "Без теней сущностей");
        Lang.p("No clouds", "Без облаков");
        Lang.p("Fewer particles", "Меньше частиц");
        Lang.p("No biome blend", "Без смешивания биомов");
        Lang.p("No menu blur", "Без размытия меню");
        Lang.p("No improved transparency", "Без улучшенной прозрачности");
        Lang.p("Fewer far entities", "Меньше дальних сущностей");
        Lang.p("Light far players", "Лёгкие дальние игроки");
        Lang.p("Light from", "Облегчать дальше");
        Lang.p("Hide far displays", "Скрывать дальние дисплеи");
        Lang.p("Displays up to", "Дисплеи до");
        Lang.p("Fast leaves", "Быстрая листва");
        Lang.p("No smooth lighting", "Без мягкого освещения");
        Lang.p("Sprint on Ctrl", "Бег на Ctrl");
        Lang.p("Jump", "Прыжок");
        Lang.p("In client menu", "В меню клиента");
        Lang.p("Anti MultiActions", "Обход MultiActions");
        Lang.p("Config name", "Имя конфига");
        Lang.p("Player name", "Ник игрока");
        Lang.p("Name (optional)", "Название (необязательно)");
        Lang.p("none", "нет");
        Lang.p("Outline", "Обводка");
        Lang.p("Glow size", "Размер свечения");
        Lang.p("Animation", "Анимация");
        Lang.p("Health color", "Цвет по здоровью");
        Lang.p("Health bar", "Полоска здоровья");
        Lang.p("Item color", "Цвет предмета");
        Lang.p("Players through walls: a glowing outline or a box", "Игроки сквозь стены: светящаяся обводка или куб");
        Lang.p("Friends turn see-through, with an outline and a glow", "Друзья становятся прозрачными, с обводкой и свечением");
        Lang.p("Invisible players show up see-through", "Невидимые игроки видны полупрозрачными");
        Lang.p("A soft aura of light around your hands", "Мягкая аура света вокруг рук");
        Lang.p("The blocks you pick, seen through walls", "Выбранные блоки сквозь стены");
        Lang.p("A circle on the ground where you jump", "Круг на земле там, где вы прыгнули");
        Lang.p("A soul rises from the ones you kill or whose totem you pop, or a glass copy of them shatters", "Душа взлетает из тех, кого вы убили или кому сбили тотем, или их стеклянная копия разбивается");
        Lang.p("Move, turn and resize your hands", "Положение, поворот и размер рук");
        Lang.p("See what is inside a shulker box by hovering it", "Содержимое шалкера при наведении");
        Lang.p("Takes everything out of the chests you open", "Забирает всё из открытых сундуков");
        Lang.p("Sorts the opened chest on a key", "Сортирует открытый сундук по кнопке");
        Lang.p("Takes the items on your list out of chests on a key and marks looted chests", "Забирает предметы из списка по кнопке и отмечает обобранные сундуки");
        Lang.p("Longer chat history, repeats merged, right click copies", "Длинная история чата, повторы склеиваются, ПКМ копирует");
        Lang.p("Sounds for toggles and hits. Your own go in flow2/sounds", "Звуки модулей и ударов. Свои - в папку flow2/sounds");
        Lang.p("Notify", "Уведомления");
        Lang.p("Corner size", "Размер углов");
        Lang.p("Duration", "Длительность");
        Lang.p("On kill", "При убийстве");
        Lang.p("On totem pop", "При сносе тотема");
        Lang.p("Only my targets", "Только мои цели");
        Lang.p("Totem color", "Цвет тотема");
        Lang.p("Wings", "Крылья");
        Lang.p("Halo", "Нимб");
        Lang.p("Pieces", "Осколки");
        Lang.p("Sound", "Звук");
        Lang.v("Angel", "Ангел");
        Lang.v("Shards", "Острые");
        Lang.v("Cubes", "Кубики");
        Lang.p("Blocks", "Блоки");
        Lang.p("Block colors", "Цвета блоков");
        Lang.p("Limit", "Лимит");
        Lang.p("Chosen mobs through walls, each in its colour", "Выбранные мобы сквозь стены, у каждого свой цвет");
        Lang.p("Mob colors", "Цвета мобов");
        Lang.p("Only owned", "Только чьи-то");
        Lang.p("Mob color", "Цвет мобов");
        Lang.p("Tags above players and mobs: name, health, armour", "Теги над игроками и мобами: ник, здоровье, броня");
        Lang.p("Arrows pointing at players and mobs around you", "Стрелки на игроков и мобов вокруг");
        Lang.p("Click friend", "Друг по колёсику");
        Lang.p("Click range", "Дальность клика");
        Lang.p("The friend key adds or removes the player you aim at. Off: it does nothing", "Кнопка друга (колёсико) добавляет или убирает игрока под прицелом. Выкл — ничего не делает");
        Lang.p("Mob range", "Дальность мобов");
        Lang.p("Follow", "Бегает рядом");
        Lang.p("Pet mode", "Питомец");
        Lang.v("Shoulder", "На плече");
        Lang.v("Follow", "Бегает рядом");
        Lang.p("X", "X");
        Lang.p("Y", "Y");
        Lang.p("Z", "Z");
        Lang.p("Turn X", "Поворот X");
        Lang.p("Turn Y", "Поворот Y");
        Lang.p("Turn Z", "Поворот Z");
        Lang.p("Left mirrors right", "Левая как правая");
        Lang.p("Left X", "Левая X");
        Lang.p("Left Y", "Левая Y");
        Lang.p("Left Z", "Левая Z");
        Lang.p("Left size", "Размер левой");
        Lang.p("Left turn X", "Левая поворот X");
        Lang.p("Left turn Y", "Левая поворот Y");
        Lang.p("Left turn Z", "Левая поворот Z");
        Lang.p("Mace charge", "Заряд булавы");
        Lang.p("Only main hand", "Только в главной руке");
        Lang.p("Box color", "Цвет шалкера");
        Lang.p("Compact", "Компактно");
        Lang.p("Random", "Разброс");
        Lang.p("Auto close", "Закрывать сам");
        Lang.p("No hotbar", "Без хотбара");
        Lang.p("Order", "Порядок");
        Lang.p("Merge stacks", "Объединять стаки");
        Lang.p("Close chest", "Закрывать сундук");
        Lang.p("Mark chests", "Отмечать сундуки");
        Lang.p("Farms the decorated pots in the End", "Автоматически фармит вазы в Энде");
        Lang.p("Loots the Warden town chests by their timers", "Лутает сундуки в городе Вардена по их таймерам");
        Lang.p("Chest timers at /warp warden", "Таймеры сундуков на /warp warden");
        Lang.p("Bots in this same client: their own accounts", "Боты в этом же клиенте: свои аккаунты");
        Lang.p("Max vases", "Макс. ваз");
        Lang.p("Show route", "Показывать маршрут");
        Lang.p("Neuro walking", "Нейро-ходьба");
        Lang.p("Record and train", "Записать и обучить");
        Lang.p("Use brush", "Использовать кисть");
        Lang.p("Take speed", "Брать скорость");
        Lang.p("Save End", "Сейв Энд");
        Lang.p("Loot End", "Лут Энд");
        Lang.p("Teleport by", "Способ ТП");
        Lang.p("Warp name", "Название варпа");
        Lang.p("Home name", "Название хома");
        Lang.p("Max chests", "Макс. сундуков");
        Lang.p("Loot priority", "Приоритет лута");
        Lang.p("Loot delay", "Задержка лута");
        Lang.p("Save anarchy", "Анархия сейва");
        Lang.p("Loot anarchy", "Анархия лута");
        Lang.p("Hide timer", "Скрывать таймер");
        Lang.p("Solve captcha", "Решать капчу");
        Lang.v("Home", "Хом");
        Lang.v("Warp", "Варп");
        Lang.v("Low", "Низкий");
        Lang.v("Medium", "Средний");
        Lang.v("High", "Высокий");
        Lang.p("Buys the items on your list at the /ah auction, cheapest lots first", "Скупает предметы из списка на аукционе /ah, самые дешёвые лоты");
        Lang.p("Work", "Работа");
        Lang.p("Start", "Запустить");
        Lang.p("Stop", "Остановить");
        Lang.p("Item list", "Список предметов");
        Lang.p("Edit list", "Открыть список");
        Lang.p("Marks", "Отметки");
        Lang.p("Clear marks", "Снять отметки");
        Lang.p("Long history", "Длинная история");
        Lang.p("History", "История");
        Lang.p("Keep chat", "Не очищать чат");
        Lang.p("Merge repeats", "Склеивать повторы");
        Lang.p("Copy on right click", "Копировать ПКМ");
        Lang.p("Smooth tab list, chat and inventories", "Плавные таб, чат и инвентарь");
        Lang.p("Tab", "Таб");
        Lang.p("Chat", "Чат");
        Lang.p("Inventory", "Инвентарь");
        Lang.p("Through friends", "Сквозь друзей");
        Lang.p("Choose", "Выбрать");
        Lang.p("Mace after charge", "Булава после заряда");
        Lang.p("Mace while falling", "Булава в падении");
        Lang.p("Timed jump", "Прыжок в тайминг");
        Lang.p("Throw key", "Кнопка броска");
        Lang.p("Density", "Плотность");
        Lang.p("Transparency", "Прозрачность");
        Lang.p("Puffs", "Клубы");
        Lang.p("Height falloff", "Спад по высоте");
        Lang.p("Swirls", "Завихрения");
        Lang.p("Sunlight", "Свет солнца");
        Lang.p("Hide clouds", "Скрыть облака");
        Lang.p("Parts around you", "Расступается");
        Lang.p("From movement", "От движения");
        Lang.p("Health threshold", "Порог здоровья");
        Lang.p("Return item", "Возвращать предмет");
        Lang.p("Plain totems first", "Сначала обычные тотемы");
        Lang.p("Not while eating", "Не во время еды");
        Lang.p("Rotation", "Ротация");
        Lang.p("Speed from", "Скорость от");
        Lang.p("Speed to", "Скорость до");
        Lang.p("Spread", "Разброс");
        Lang.p("Return view", "Возврат взгляда");
        Lang.p("Swap to mace", "Свап на булаву");
        Lang.p("Swap back", "Вернуть слот");
        Lang.p("Strike height", "Высота удара");
        Lang.v("Client", "Клиентская");
        Lang.v("Silent", "Тихая");
        Lang.p("Smart swap", "Умное перемещение");
        Lang.p("From inventory", "Из инвентаря");
        Lang.p("Put back", "Возвращать");
        Lang.p("Return delay", "Задержка возврата");
        Lang.p("Save durability", "Беречь прочность");
        wat.put("Цвет".hashCode(), "Color");
        wat.put("Яркость".hashCode(), "Brightness");
        wat.put("Размер".hashCode(), "Size");
        wat.put("Скорость".hashCode(), "Speed");
        Lang.p("Wind charge", "Заряд ветра");
        Lang.p("God's aura", "Божья аура");
        Lang.p("Trap", "Трапка");
        Lang.p("Plast", "Пласт");
        Lang.p("Clear dust", "Явная пыль");
        Lang.p("Disorientation", "Дезориентация");
        Lang.p("Freeze snowball", "Снежок заморозка");
        Lang.p("Firecracker", "Хлопушка");
        Lang.p("Holy water", "Святая вода");
        Lang.p("Wrath potion", "Зелье гнева");
        Lang.p("Paladin potion", "Зелье паладина");
        Lang.p("Assassin potion", "Зелье ассасина");
        Lang.p("Radiation potion", "Зелье радиации");
        Lang.p("Sleeping potion", "Снотворное");
        Lang.p("Fireball", "Огненный шар");
        Lang.p("Dragon trap", "Драконья трапка");
        Lang.p("Dragon plast", "Драконий пласт");
        Lang.p("Explosive trap", "Взрывная трапка");
        Lang.p("Regular trap", "Обычная трапка");
        Lang.p("Stun", "Стан");
        Lang.p("Explosive thing", "Взрывная штучка");
        Lang.p("Freeze snowball HW", "Снежок заморозка HW");
        Lang.p("Jack o'Lantern", "Светильник Джека");
        Lang.p("XP bubble", "Пузырь опыта");
        Lang.p("Backpack level 1", "Рюкзак 1 уровня");
        Lang.p("Backpack level 2", "Рюкзак 2 уровня");
        Lang.p("Backpack level 3", "Рюкзак 3 уровня");
        Lang.p("Anti-flight", "Анти полет");
        Lang.p("XP scroll", "Свиток опыта");
        Lang.p("Presets. Glass ones let the picture through", "Пресеты. Стеклянные пропускают картинку");
        Lang.p("Auto takes the theme's own. Or pick your colour", "Авто берёт цвет темы. Или выберите свой");
        Lang.p("Custom theme", "Своя тема");
        Lang.p("Your colours. Editing switches to it", "Ваши цвета. Изменение включает её");
        Lang.p("Every colour of the menu and the HUD. Editing switches to it", "Любой цвет меню и HUD. Изменение включает её");
        Lang.p("From current", "Из текущей");
        Lang.p("Colours of", "Цвета для");
        Lang.p("Sidebar", "Боковая панель");
        Lang.p("Cards", "Карточки");
        Lang.p("Cards on hover", "Карточки при наведении");
        Lang.p("Borders", "Обводка");
        Lang.p("Fields and buttons", "Поля и кнопки");
        Lang.p("Fields on hover", "Поля при наведении");
        Lang.p("Switch track", "Дорожка переключателя");
        Lang.p("Switch knob", "Кружок переключателя");
        Lang.p("Text", "Текст");
        Lang.p("Secondary text", "Вторичный текст");
        Lang.p("Muted text", "Тусклый текст");
        Lang.p("Dividers", "Разделители");
        Lang.p("Hover", "Подсветка наведения");
        Lang.p("Shadow", "Тень");
        Lang.p("Accent 2", "Акцент 2");
        Lang.p("Bars", "Полоски");
        Lang.p("Fields", "Поля");
        Lang.v("Menu", "Меню");
        Lang.p("Reset", "Сброс");
        Lang.p("Wallpaper", "Обои");
        Lang.p("Menu background. Add pictures with Folder, then Reload", "Фон меню. Добавьте картинки через «Папка» и нажмите «Обновить»");
        Lang.p("Folder", "Папка");
        Lang.p("Reload", "Обновить");
        Lang.p("Refraction over the picture and the world", "Преломление поверх картинки и мира");
        Lang.p("Reset glass", "Сбросить стекло");
        Lang.p("Glass parts", "Стеклянные части");
        Lang.p("Which parts are glass", "Какие части из стекла");
        Lang.p("Interface", "Интерфейс");
        Lang.p("Size, corners, motion, the game behind", "Размер, углы, анимации, игра на фоне");
        Lang.p("In the chat: drag parts to move, right drag to size", "В чате: тащите элементы, ПКМ — размер");
        Lang.p("Edit layout", "Расставить");
        Lang.p("Watermark", "Ватермарка");
        Lang.p("FPS, ping, TPS, speed and position, top centre", "FPS, пинг, TPS, скорость и координаты сверху");
        Lang.p("Target", "Цель");
        Lang.p("Who you hit or look at: health, armour, hands", "Кого бьёте или на кого смотрите: здоровье, броня, руки");
        Lang.p("Spotify, Yandex Music, a browser. Controls in the chat", "Spotify, Яндекс Музыка, браузер. Управление в чате");
        Lang.p("Now", "Сейчас");
        Lang.p("Play / Pause", "Пуск / Пауза");
        Lang.p("Potions", "Зелья");
        Lang.p("Active effects and time left", "Активные эффекты и оставшееся время");
        Lang.p("Keybinds", "Бинды");
        Lang.p("Mines", "Шахты");
        Lang.p("Modules with a key. Middle click a module to bind", "Модули с кнопкой. СКМ по модулю — назначить");
        Lang.p("Cooldowns", "Кулдауны");
        Lang.p("Pearls, chorus, wind charges", "Жемчуг, хорус, заряды ветра");
        Lang.p("ServerHelper item keys: item, count, cooldown, key", "Бинды ServerHelper: предмет, количество, кулдаун, кнопка");
        Lang.p("Armor", "Броня");
        Lang.p("Your armour and how much of it is left", "Ваша броня и её прочность");
        Lang.p("Modules, settings and binds under a name", "Модули, настройки и бинды под одним именем");
        Lang.p("Modules, settings and binds. Share one with a code", "Модули, настройки и бинды. Делитесь по коду");
        Lang.p("Find a config by code", "Найти конфиг по коду");
        Lang.p("Options", "Настройки");
        Lang.p("Auto-save writes the active config when the menu closes", "Автосохранение записывает активный конфиг при закрытии меню");
        Lang.p("Files", "Файлы");
        Lang.p("Plain JSON in flow2/configs", "Обычный JSON в flow2/configs");
        Lang.p("Active", "Активный");
        Lang.p("Saved", "Сохранено");
        Lang.p("Open folder", "Открыть папку");
        Lang.p("Hotkeys", "Горячие клавиши");
        Lang.p("Client functions on keys. One key can run many things", "Функции клиента на кнопках. Одна кнопка может делать несколько вещей");
        Lang.p("New waypoint", "Новая метка");
        Lang.p("Coordinates or Here. Tab moves, Enter adds", "Координаты или «Здесь». Tab — дальше, Enter — добавить");
        Lang.p("Display", "Отображение");
        Lang.p("Markers in the world", "Метки в мире");
        Lang.p("This world. Click one to edit", "Этот мир. Нажмите, чтобы изменить");
        Lang.p("Add friend", "Добавить друга");
        Lang.p("Party", "Пати");
        Lang.p("Your code: send it to a friend. Or invite theirs", "Ваш код: отправьте другу. Или пригласите по его коду");
        Lang.p("Party members", "Участники пати");
        Lang.p("Invites and who is in. Marks: the mark key", "Приглашения и состав. Метки: кнопка метки");
        Lang.p("Party settings", "Настройки пати");
        Lang.p("Marks. Double press: danger. Everything is end-to-end encrypted", "Метки. Двойное нажатие: опасность. Всё зашифровано");
        Lang.p("Mark time", "Время метки");
        Lang.p("Sounds", "Звуки");
        Lang.p("Listen", "Прослушать");
        Lang.p("Mark", "Метка");
        Lang.p("Danger", "Опасность");
        Lang.p("Mark key", "Кнопка метки");
        Lang.p("Party mark", "Метка для пати");
        Lang.p("Friend's code", "Код друга");
        Lang.p("By name. Or middle click a player in the world", "По нику. Или СКМ по игроку в мире");
        Lang.p("Nearby", "Рядом");
        Lang.p("Players around you. Click one to add or remove", "Игроки вокруг. Нажмите, чтобы добавить или убрать");
        Lang.p("Combat modules never go for friends", "Боевые модули не трогают друзей");
        Lang.p("Everywhere, by name. Hover one to remove it", "Везде, по нику. Наведите, чтобы удалить");
        Lang.p("Show HUD", "Показать / скрыть HUD");
        Lang.p("Waypoint here", "Метка здесь");
        Lang.p("Light / dark theme", "Светлая / тёмная тема");
        Lang.p("Next theme", "Следующая тема");
        Lang.p("Next wallpaper", "Следующие обои");
        Lang.p("Play / pause music", "Музыка: пуск / пауза");
        Lang.p("Next track", "Следующий трек");
        Lang.p("Add / remove friend", "Добавить / убрать друга");
        Lang.p("Language", "Язык");
        Lang.p("Done", "Готово");
        Lang.p("Off", "Выкл");
        Lang.p("Windows only", "Только Windows");
        Lang.p("Unavailable", "Недоступно");
        Lang.p("Starting…", "Запуск…");
        Lang.p("Restarting…", "Перезапуск…");
        Lang.p("Nothing playing", "Ничего не играет");
        Lang.p("Playing", "Играет");
        Lang.p("Paused", "Пауза");
        Lang.p("Items", "Предметы");
        Lang.p("BPS", "Скорость (BPS)");
        Lang.p("Food preview", "Превью еды");
        Lang.p("Number", "Число");
        Lang.p("Profile", "Профиль");
        Lang.p("Aura profile", "Профиль ауры");
        Lang.v("Smart", "Умные");
        Lang.v("Random", "Рандом");
        Lang.v("Off", "Выкл");
        Lang.v("On", "Вкл");
        Lang.v("Hold", "Удержание");
        Lang.v("Toggle", "Переключение");
        Lang.v("Auto", "Авто");
        Lang.v("Full", "Полный");
        Lang.v("Back", "Сзади");
        Lang.v("Front", "Спереди");
        Lang.v("First person", "От первого лица");
        Lang.v("Soft", "Мягкий");
        Lang.v("Vivid", "Яркий");
        Lang.v("Warm", "Тёплый");
        Lang.v("Cold", "Холодный");
        Lang.v("Cinema", "Кино");
        Lang.v("Custom", "Свой");
        Lang.v("Classic", "Классика");
        Lang.v("Neuro1", "Нейро1");
        Lang.v("Weapons", "Оружие");
        Lang.v("Swords", "Мечи");
        Lang.v("Axes", "Топоры");
        Lang.v("Any", "Любое");
        Lang.v("Angle", "Угол");
        Lang.v("Distance", "Дистанция");
        Lang.v("Health", "Здоровье");
        Lang.v("Box", "Куб");
        Lang.v("Face", "Грань");
        Lang.v("Solid", "Сплошной");
        Lang.v("None", "Нет");
        Lang.v("Glass", "Стекло");
        Lang.v("Liquid", "Жидкое");
        Lang.v("Frosted", "Матовое");
        Lang.v("Dark", "Тёмный");
        Lang.v("Accent", "Акцент");
        Lang.v("Effect", "Эффект");
        Lang.v("Text", "Текст");
        Lang.v("Bar", "Полоска");
        Lang.v("Both", "Оба");
        Lang.v("Inline", "В строку");
        Lang.v("Above", "Сверху");
        Lang.v("Friends", "Друзья");
        Lang.v("Everyone", "Все");
        Lang.v("XP bottles", "Пузырьки опыта");
        Lang.v("Blocks", "Блоки");
        Lang.v("All", "Все");
        Lang.v("Active", "Активные");
        Lang.v("Row", "Строка");
        Lang.v("Column", "Столбец");
        Lang.v("Percent", "Проценты");
        Lang.v("Compact", "Компактный");
        Lang.v("Theme", "Тема");
        Lang.v("Own", "Свой");
        Lang.v("Always", "Всегда");
        Lang.v("On aim", "При наводке");
        Lang.v("Flat", "Плоский");
        Lang.v("Depth", "Объём");
        Lang.v("Fill", "Заполнить");
        Lang.v("Fit", "Вписать");
        Lang.v("Ghosts", "Призраки");
        Lang.v("Sparkles", "Искры");
        Lang.v("Ring", "Кольцо");
        Lang.v("Comets", "Кометы");
        Lang.v("Lightning", "Молния");
        Lang.v("Aurora", "Аврора");
        Lang.v("Nebula", "Туманность");
        Lang.v("Galaxy", "Галактика");
        Lang.v("Clouds", "Облака");
        Lang.v("Sakura", "Сакура");
        Lang.v("Ice", "Лёд");
        Lang.v("Violet", "Фиолет");
        Lang.v("Sunset", "Закат");
        Lang.v("Mint", "Мята");
        Lang.v("Crimson", "Алый");
        Lang.v("Gold", "Золото");
        Lang.v("Snow", "Снег");
        Lang.v("Mono", "Моно");
        Lang.v("Ocean", "Океан");
        Lang.v("Sky", "Небо");
        Lang.v("Lime", "Лайм");
        Lang.v("Rose", "Роза");
        Lang.v("World", "Мир");
        Lang.v("Celestial", "Селестиал");
        Lang.v("Bubble", "Пузырь");
        Lang.v("Twinkle", "Перезвон");
        Lang.v("Plain", "Обычный");
        Lang.v("Cosmos", "Космос");
        Lang.v("Neon", "Неон");
        Lang.v("Corners", "Углы");
        Lang.v("Type", "По типу");
        Lang.v("Name", "По названию");
        Lang.v("Count", "По количеству");
        Lang.v("Winter", "Зима");
        Lang.v("Spring", "Весна");
        Lang.v("Summer", "Лето");
        Lang.v("Autumn", "Осень");
        Lang.v("Rain", "Дождь");
        Lang.v("Low", "Низкое");
        Lang.v("Medium", "Среднее");
        Lang.v("High", "Высокое");
        Lang.v("Ultra", "Ультра");
        Lang.v("Monitor", "Монитор");
        Lang.v("Unlimited", "Без лимита");
        Lang.v("Game", "Как в игре");
        Lang.v("Flow Black", "Flow Чёрная");
        Lang.v("Flow White", "Flow Белая");
        Lang.v("Graphite", "Графит");
        Lang.v("Obsidian", "Обсидиан");
        Lang.v("Midnight", "Полночь");
        Lang.v("Frost", "Иней");
        Lang.v("Mist", "Туман");
        Lang.v("Crystal", "Кристалл");
        Lang.v("Neon Blue", "Синий неон");
        Lang.v("Emerald", "Изумруд");
        Lang.v("Arctic", "Арктика");
        Lang.v("Cyberpunk", "Киберпанк");
        Lang.v("Aquamarine", "Аквамарин");
        Lang.v("Royal", "Королевская");
        Lang.v("White", "Белая");
        wav.put("Низкое".hashCode(), "Low");
        wav.put("Среднее".hashCode(), "Medium");
        wav.put("Высокое".hashCode(), "High");
        wav.put("Ультра".hashCode(), "Ultra");
        Lang.alias("AimAssist", "аим ассист аимбот аим помощь наводка прицел мышь мышка маус сенса легит");
        Lang.alias("NeuroAim", "нейро аим нейроаим нейросеть нейронка обучение стенды ротация тренер модель");
        Lang.alias("NeuroRotation", "нейро ротация нейросеть нейронка обучение студия стенды тренер модель боты майн энд варден");
        Lang.alias("KillAura", "киллаура килаура кил аура аура килка нейро ротация");
        Lang.alias("TriggerBot", "триггербот триггер бот кликер автоудар");
        Lang.alias("AutoSwap", "автосвап свап тотем сфера вторая рука колесо");
        Lang.alias("NoFriendDamage", "друзья урон по друзьям");
        Lang.alias("AutoMace", "автобулава булава мейс мэйс смэш автомейс");
        Lang.alias("KeyPearl", "перл жемчуг эндер пёрл кипёрл");
        Lang.alias("AutoTotem", "автототем тотем бессмертия вторая рука");
        Lang.alias("AutoTool", "автотул инструмент кирка лопата топор копать");
        Lang.alias("AutoMine", "автошахта авто шахта копать руды майнер кирка анархия");
        Lang.alias("AncientFarmer", "древние обломки незерит фарм обломков анциент динамит тнт полёт флай");
        Lang.alias("XRay", "иксрей икс рей обломки древние незерит подсветка");
        Lang.alias("AutoSprint", "автоспринт спринт бег");
        Lang.alias("DragonFly", "драгон флай драгонфлай флай полёт полет ускорение полёта фантайм");
        Lang.alias("GuiMove", "гуи мув гуимув инвмув инвентарь мув ходьба в инвентаре движение в меню");
        Lang.alias("NoJumpDelay", "прыжок задержка прыжка ноу джамп");
        Lang.alias("NoRender", "норендер скрыть эффекты огонь");
        Lang.alias("Nametags", "неймтеги ники теги");
        Lang.alias("ItemESP", "итем есп предметы подписи");
        Lang.alias("TargetESP", "таргет есп цель эффект");
        Lang.alias("Predictions", "предикты предсказания траектория арбалет лук жемчуг");
        Lang.alias("Arrows", "стрелки указатели");
        Lang.alias("BlockOutline", "обводка блока аутлайн космос зима лава");
        Lang.alias("BlockESP", "блок есп блоки руды поиск блоков иксрей");
        Lang.alias("PlayerESP", "плеер есп есп игроки обводка аутлайн коробка бокс");
        Lang.alias("TransparentFriends", "прозрачные друзья призраки");
        Lang.alias("ShowInvisible", "невидимки невидимые показать невидимых");
        Lang.alias("JumpCircles", "джамп серклы круги прыжок кольца под ногами");
        Lang.alias("SoulESP", "соул есп душа душа убийство килл эффект тотем стекло осколки ангел");
        Lang.alias("ViewModel", "вьюмодел рука позиция рук руки");
        Lang.alias("SwingAnimations", "анимации удара взмах свинг анимация руки булава заряд");
        Lang.alias("ShaderHands", "шейдер руки руки свечение аура");
        Lang.alias("ShulkerPreview", "шалкер превью просмотр шалкера");
        Lang.alias("ChestStealer", "честстилер стилер сундук забрать всё");
        Lang.alias("ChestSorter", "сортировка сундука сортер");
        Lang.alias("ChestLooter", "лутер лут сундук обобрать");
        Lang.alias("ChatTweaks", "чат твикс история чата копировать");
        Lang.alias("HitColor", "цвет удара хит колор");
        Lang.alias("FullBright", "фулбрайт яркость гамма");
        Lang.alias("CustomTime", "время суток кастом тайм");
        Lang.alias("Weather", "погода времена года сезоны зима весна лето осень снег дождь гроза молнии гром ливень тучи мокрая земля листопад сакура");
        Lang.alias("VolumetricFog", "туман объёмный туман дым");
        Lang.alias("ShaderSky", "шейдер скай небо шейдерное небо аврора туманность галактика закат облака звёзды sky");
        Lang.alias("Shaders", "шейдеры цвета свечение");
        Lang.alias("MotionBlur", "моушн блюр моушен блюр размытие в движении смаз блюр");
        Lang.alias("ItemPhysics", "физика предметов");
        Lang.alias("Zoom", "зум приближение");
        Lang.alias("Animations", "анимации анимация таб чат инвентарь плавно");
        Lang.alias("FreeLook", "фрилук свободный обзор");
        Lang.alias("Structures", "структуры таймеры трапки");
        Lang.alias("FreeCam", "фрикам свободная камера");
        Lang.alias("FastUse", "фаст юз быстрое использование опыт");
        Lang.alias("ItemScroller", "итем скроллер перенос стаков");
        Lang.alias("AutoAccept", "автоакцепт принять тпа телепорт");
        Lang.alias("AutoCollector", "автоколлектор коллектор автосбор аукцион ах автобай закупка фантайм");
        Lang.alias("AutoSell", "автосел автопродажа аукцион ах продать выставить лоты фантайм");
        Lang.alias("AuctionHelper", "аукцион хелпер ах поиск бинд цена подсветка лоты фантайм");
        Lang.alias("AutoEnd", "автоэнд энд вазы кисть песок фарм");
        Lang.alias("AutoWarden", "автоварден варден сундуки город таймеры фарм");
        Lang.alias("WardenHelper", "варден таймер сундуков хелпер");
        Lang.alias("Bots", "боты бот аккаунты твинки фарм капча");
        Lang.alias("ClientSounds", "звуки клиента саунды");
        Lang.alias("ServerHelper", "сервер хелпер донат предметы фантайм холиворлд риливорлд");
        Lang.alias("Optimization", "оптимизация фпс буст производительность лаги");
        LangEntriesB.fill();
        LangEntriesA.fill();
    }

    private static /* synthetic */ int dny(int n, int n2) {
        return n - n2 + -827051713;
    }

    private static /* synthetic */ int dnz(int n, int n2) {
        return Lang.dny(n, n2) ^ 0x3F48859E;
    }
}

