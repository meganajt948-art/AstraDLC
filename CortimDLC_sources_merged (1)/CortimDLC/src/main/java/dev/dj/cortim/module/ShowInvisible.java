package dev.dj.cortim.module;

/**
 * Показывает невидимых игроков в виде полупрозрачного «призрака» (как их видит спектатор).
 * Сам рендер делает ванильный код: миксин ShowInvisibleMixin говорит ему, что игрок для нас не невидим.
 */
public class ShowInvisible extends Module {

    private static ShowInvisible INSTANCE;

    public ShowInvisible() {
        super("ShowInvisible", Category.RENDER);
        INSTANCE = this;
    }

    /** Включён ли модуль (вызывается миксином очень часто, поэтому без поиска по реестру). */
    public static boolean active() {
        return INSTANCE != null && INSTANCE.isEnabled();
    }
}