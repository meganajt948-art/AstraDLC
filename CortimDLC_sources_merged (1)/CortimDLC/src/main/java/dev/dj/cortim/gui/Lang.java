package dev.dj.cortim.gui;

import dev.dj.cortim.CortimConfig;

import java.util.Map;

public final class Lang {
    private Lang() {}

    private static final Map<String, String> EN = Map.ofEntries(
            Map.entry("tab.combat", "Combat"),
            Map.entry("tab.movement", "Movement"),
            Map.entry("tab.player", "Player"),
            Map.entry("tab.render", "Render"),
            Map.entry("tab.misc", "Misc"),
            Map.entry("tab.hud", "HUD"),
            Map.entry("tab.configs", "Configs"),
            Map.entry("tab.waypoints", "Waypoints"),
            Map.entry("tab.friends", "Friends"),
            Map.entry("tab.cosmetics", "Cosmetics"),
            Map.entry("search", "Search  (Ctrl+F)"),
            Map.entry("search.results", "Search results"),
            Map.entry("lang.title", "Language"),
            Map.entry("lang.sub", "Choose the client language"),
            Map.entry("lang.hint", "You can change it any time: the globe button in the menu"),
            Map.entry("apply", "Apply")
    );

    private static final Map<String, String> RU = Map.ofEntries(
            Map.entry("tab.combat", "Бой"),
            Map.entry("tab.movement", "Движение"),
            Map.entry("tab.player", "Игрок"),
            Map.entry("tab.render", "Рендер"),
            Map.entry("tab.misc", "Разное"),
            Map.entry("tab.hud", "HUD"),
            Map.entry("tab.configs", "Конфиги"),
            Map.entry("tab.waypoints", "Метки"),
            Map.entry("tab.friends", "Друзья"),
            Map.entry("tab.cosmetics", "Косметика"),
            Map.entry("search", "Поиск  (Ctrl+F)"),
            Map.entry("search.results", "Результаты поиска"),
            Map.entry("lang.title", "Язык"),
            Map.entry("lang.sub", "Выберите язык клиента"),
            Map.entry("lang.hint", "Язык можно сменить в любое время: кнопка в меню"),
            Map.entry("apply", "Применить")
    );

    public static boolean ru() {
        return "RU".equalsIgnoreCase(CortimConfig.language);
    }

    public static String tr(String key) {
        String v = (ru() ? RU : EN).get(key);
        return v != null ? v : key;
    }

    public static String count(int enabled, int total) {
        return ru() ? enabled + " из " + total + " вкл"
                : enabled + " of " + total + " on";
    }
}