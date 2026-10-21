/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.Lang;
import flow.dev.StringDecryptor;

final class LangEntriesA {
    private static /* synthetic */ long wbj;
    private static /* synthetic */ int wbk;

    private LangEntriesA() {
    }

    static void fill() {
        Lang.p("Goes round the anarchies' auto-mines, waits for the best one to refresh and clears it, with trips to your stash anarchy", "Обходит анархии, ждёт обновления лучшей авто-шахты и выкапывает её, сам ходит на анку склада");
        Lang.p("Breaks the decorated pots in the End (and brushes suspicious sand), keeps only the items picked in its Loot list", "Бьёт вазы в Энде (и чистит кистью подозрительный песок), забирает только предметы из своего списка лута");
        Lang.p("Loots the Warden town chests by their timers, takes only the items picked in its Loot list", "Лутает сундуки в городе Вардена по их таймерам, забирает только предметы из своего списка лута");
        Lang.p("Opens the bot window: extra accounts in this client running AutoEnd, AutoWarden or AutoMine, at most 3 of them on one anarchy", "Открывает окно ботов: свои аккаунты в этом же клиенте с AutoEnd, AutoWarden или AutoMine, не больше 3 на одной анке");
        Lang.p("Clean timers over the Warden town chests at /warp warden, the server's own can be hidden", "Аккуратные таймеры над сундуками города Вардена на /warp warden, серверные можно скрыть");
        Lang.p("Loot list", "Список лута");
        Lang.p("Common mines", "Обычные шахты");
        Lang.p("Mythic mines", "Мифические шахты");
        Lang.p("Legendary mines", "Легендарные шахты");
        Lang.p("Break prediction", "Предикт ломания");
        Lang.p("Inventory full - to the save", "Инвентарь полон - на сейв");
        Lang.p("Chests done - to the save", "Сундуки собраны - на сейв");
        Lang.p("No invisibility - to the save", "Нет невидимости - на сейв");
        Lang.p("No invisibility at the base - waiting", "Нет невидимости на базе - ждём");
        Lang.p("No food - to the save", "Нет еды - на сейв");
        Lang.p("Died - to the save", "Смерть - на сейв");
        Lang.p("Warden nearby - leaving", "Варден рядом - уходим");
        Lang.p("Three of ours on the save already - waiting in line", "На сейве уже 3 наших - ждём очереди");
        Lang.p("Every loot anarchy is taken - waiting in line", "Все анки лута заняты - ждём очереди");
        Lang.p("The teleport into the city failed - trying another anarchy", "Не телепортировало в город - пробуем другую анку");
    }

    private static /* synthetic */ int doc(int n, int n2) {
        return n + n2 ^ 0x5FD6CEC5;
    }

    private static /* synthetic */ int dod(int n, int n2) {
        return n - n2 | 0xFBEC5102;
    }
}

