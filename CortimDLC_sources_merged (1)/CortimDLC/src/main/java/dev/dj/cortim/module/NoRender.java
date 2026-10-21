package dev.dj.cortim.module;

public class NoRender extends Module {

    public final BoolSetting explosionParticles = add(new BoolSetting("Партиклы взрывов", "Отключить частицы взрывов", false));
    public final BoolSetting blockParticles = add(new BoolSetting("Партиклы блоков", "Отключить частицы разрушения блоков", false));
    public final BoolSetting witherHearts = add(new BoolSetting("Визер сердца", "Отключить визер-сердца", false));
    public final BoolSetting fog = add(new BoolSetting("Туман", "Отключить туман", false));
    public final BoolSetting shadows = add(new BoolSetting("Тени", "Отключить тени сущностей", false));
    public final BoolSetting xpBottles = add(new BoolSetting("Бутыли опыта", "Отключить бутыли опыта", false));
    public final BoolSetting glowing = add(new BoolSetting("Свечение", "Отключить эффект свечения", false));
    public final BoolSetting weather = add(new BoolSetting("Погода", "Отключить дождь и снег", false));
    public final BoolSetting barrier = add(new BoolSetting("Барьер", "Скрыть барьеры", false));
    public final BoolSetting vignette = add(new BoolSetting("Виньетка", "Убрать виньетку", false));
    public final BoolSetting blockOverlay = add(new BoolSetting("Оверлей блоков", "Убрать тёмный оверлей на блоках", false));
    public final BoolSetting effects = add(new BoolSetting("Эффекты", "Отключить частицы зелий", false));
    public final BoolSetting bossBar = add(new BoolSetting("Полоса босса", "Скрыть полосу босса", false));
    public final BoolSetting bubbles = add(new BoolSetting("Пузыри", "Скрыть пузыри воздуха", false));
    public final BoolSetting wardenDarkness = add(new BoolSetting("Тьма вардена", "Убрать тьму вардена", false));
    public final BoolSetting blindness = add(new BoolSetting("Слепота", "Убрать слепоту", false));
    public final BoolSetting nausea = add(new BoolSetting("Тошнота", "Убрать тошноту", false));
    public final BoolSetting snowFrost = add(new BoolSetting("Иней от снега", "Убрать иней по краям экрана", false));
    public final BoolSetting fireHud = add(new BoolSetting("Огонь в худе", "Убрать огонь поверх экрана при горении", false));
    public final BoolSetting scoreboard = add(new BoolSetting("Таблица очков", "Скрыть таблицу очков справа", false));

    public NoRender() { super("NoRender", Category.VISUAL); }

    public boolean explosionParticles_get() { return explosionParticles.get(); }
    public boolean blockParticles_get()     { return blockParticles.get(); }
    public boolean witherHearts_get()       { return witherHearts.get(); }
    public boolean fog_get()                { return fog.get(); }
    public boolean shadows_get()            { return shadows.get(); }
    public boolean xpBottles_get()          { return xpBottles.get(); }
    public boolean glowing_get()            { return glowing.get(); }
    public boolean weather_get()            { return weather.get(); }
    public boolean barrier_get()            { return barrier.get(); }
    public boolean vignette_get()           { return vignette.get(); }
    public boolean blockOverlay_get()       { return blockOverlay.get(); }
    public boolean effects_get()            { return effects.get(); }
    public boolean bossBar_get()            { return bossBar.get(); }
    public boolean bubbles_get()            { return bubbles.get(); }
    public boolean wardenDarkness_get()     { return wardenDarkness.get(); }
    public boolean blindness_get()          { return blindness.get(); }
    public boolean nausea_get()             { return nausea.get(); }
    public boolean snowFrost_get()          { return snowFrost.get(); }
    public boolean fireHud_get()            { return fireHud.get(); }
    public boolean scoreboard_get()         { return scoreboard.get(); }

    @Override
    public void onTick() {}
}