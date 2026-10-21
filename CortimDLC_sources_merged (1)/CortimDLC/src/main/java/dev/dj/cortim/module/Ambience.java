package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;

public class Ambience extends Module {

    // ─── ВРЕМЯ ───
    public final BoolSetting timeEnabled = new BoolSetting(
            "Своё время",
            "Установить своё время суток",
            false
    );

    public final IntSetting timeOfDay = new IntSetting(
            "Время суток",
            "0 — рассвет, 6000 — полдень, 12000 — закат, 18000 — полночь",
            24000, 0, 24000
    ) {
        @Override public boolean isVisible() { return timeEnabled.get(); }
    };

    // ─── ЦВЕТ МИРА ───
    public final BoolSetting worldColorEnabled = new BoolSetting(
            "Свой цвет",
            "Наложить свой цвет на мир",
            false
    );

    public final ColorSetting worldColor = new ColorSetting(
            "Цвет мира",
            "Цвет, накладываемый на освещение мира",
            0xC896FF
    ) {
        @Override public boolean isVisible() { return worldColorEnabled.get(); }
    };

    // ─── ОБЪЁМНЫЙ ТУМАН ───
    public final BoolSetting volumetricFogEnabled = new BoolSetting(
            "Объёмный туман",
            "Объёмный слой тумана над землёй",
            false
    );

    public final ColorSetting fogColor = new ColorSetting(
            "Цвет тумана",
            "Цвет объёмного тумана",
            0xCDD2DC
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final FloatSetting fogDensity = new FloatSetting(
            "Плотность", "Плотность тумана", 90f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final FloatSetting fogCoverage = new FloatSetting(
            "Покрытие", "Процент покрытия горизонта", 55f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final FloatSetting fogDistance = new FloatSetting(
            "Дальность", "Дальность видимости тумана", 96f, 0f, 256f, 1f
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final FloatSetting fogStart = new FloatSetting(
            "Начало", "На какой высоте начинается туман", 8f, 0f, 256f, 1f
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final FloatSetting fogHeight = new FloatSetting(
            "Высота", "Высота верхней границы тумана", 66f, 0f, 256f, 1f
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final FloatSetting fogThickness = new FloatSetting(
            "Толщина", "Толщина слоя тумана", 6f, 0f, 64f, 1f
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final BoolSetting fogQuality = new BoolSetting(
            "Качество", "Повышенное качество рендера тумана", false
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final ModeSetting fogColorSource = new ModeSetting(
            "Цвет слоя", "Откуда берётся цвет объёмного тумана",
            0, "Свой", "Биом"
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    public final ButtonSetting fogApplyBtn = new ButtonSetting(
            "Применить туман",
            "Перезагрузить шейдер тумана с новыми настройками",
            this::applyFog
    ) {
        @Override public boolean isVisible() { return volumetricFogEnabled.get(); }
    };

    // ─── МОКРЫЙ МИР ───
    public final BoolSetting wetWorldEnabled = new BoolSetting(
            "Мокрый мир",
            "Отражения и влажность поверхностей",
            false
    );

    public final FloatSetting wetReflection = new FloatSetting(
            "Отражение", "Сила отражений на мокрых поверхностях", 70f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return wetWorldEnabled.get(); }
    };

    public final FloatSetting wetHumidity = new FloatSetting(
            "Влажность", "Насколько поверхности выглядят мокрыми", 60f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return wetWorldEnabled.get(); }
    };

    public final ModeSetting wetQuality = new ModeSetting(
            "Качество", "Длина марша отражений",
            1, "Низкое", "Среднее", "Высокое"
    ) {
        @Override public boolean isVisible() { return wetWorldEnabled.get(); }
    };

    // ─── ДОЖДЬ ───
    public final BoolSetting rainEnabled = new BoolSetting(
            "Дождь",
            "Капли на экране и всплески на земле",
            false
    );

    public final FloatSetting rainDensity = new FloatSetting(
            "Плотность", "Количество капель", 100f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return rainEnabled.get(); }
    };

    public final FloatSetting rainVisibility = new FloatSetting(
            "Заметность капель", "Насколько видны капли на экране", 45f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return rainEnabled.get(); }
    };

    public final FloatSetting rainDrops = new FloatSetting(
            "Капли", "Частота капель на экране", 60f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return rainEnabled.get(); }
    };

    public final FloatSetting rainSplashes = new FloatSetting(
            "Всплески", "Частота всплесков на земле", 60f, 0f, 100f, 1f
    ) {
        @Override public boolean isVisible() { return rainEnabled.get(); }
    };

    // ─── состояние тумана ───
    private boolean fogInitDone = false;
    private long lastFogReloadMs = 0;

    public Ambience() {
        super("Ambience", Category.VISUAL);

        // ─── ВРЕМЯ ───
        add(timeEnabled);
        add(timeOfDay);

        // ─── ЦВЕТ МИРА ───
        add(worldColorEnabled);
        add(worldColor);

        // ─── ОБЪЁМНЫЙ ТУМАН ───
        add(volumetricFogEnabled);
        add(fogColor);
        add(fogDensity);
        add(fogCoverage);
        add(fogDistance);
        add(fogStart);
        add(fogHeight);
        add(fogThickness);
        add(fogQuality);
        add(fogColorSource);
        add(fogApplyBtn);

        // ─── МОКРЫЙ МИР ───
        add(wetWorldEnabled);
        add(wetReflection);
        add(wetHumidity);
        add(wetQuality);

        // ─── ДОЖДЬ ───
        add(rainEnabled);
        add(rainDensity);
        add(rainVisibility);
        add(rainDrops);
        add(rainSplashes);
    }

    private void applyFog() {
        dev.dj.cortim.render.AmbienceFogPack.update(
                getFogColor(),
                getFogDensity(),
                getFogCoverage(),
                getFogDistance(),
                getFogStart(),
                getFogHeight(),
                getFogThickness()
        );
        lastFogReloadMs = System.currentTimeMillis();
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) mc.reloadResources();
    }

    @Override
    public void onTick() {
            // ВРЕМЕННО ОТКЛЮЧЕНО
     /*
    MinecraftClient mc = MinecraftClient.getInstance();
    if (mc == null || mc.world == null || mc.player == null) return;
    if (!isEnabled() || !isFogEnabled()) return;
    if (fogInitDone) return;
    if (lastFogReloadMs != 0 && System.currentTimeMillis() - lastFogReloadMs < 5000) return;

    fogInitDone = true;
    lastFogReloadMs = System.currentTimeMillis();
    dev.dj.cortim.render.AmbienceFogPack.update(
            getFogColor(),
            getFogDensity(),
            getFogCoverage(),
            getFogDistance(),
            getFogStart(),
            getFogHeight(),
            getFogThickness()
    );
    mc.reloadResources();
    */
        }

    // ─── геттеры ───
    public boolean isTimeEnabled() { return timeEnabled.get(); }
    public long getTimeOfDay() { return timeOfDay.get(); }

    public boolean isWorldColorEnabled() { return worldColorEnabled.get(); }
    public int getWorldColor() { return worldColor.getColor(); }

    public boolean isFogEnabled() { return volumetricFogEnabled.get(); }
    public int getFogColor() { return fogColor.getColor(); }
    public float getFogDensity() { return fogDensity.get() / 100f; }
    public float getFogCoverage() { return fogCoverage.get() / 100f; }
    public float getFogDistance() { return fogDistance.get(); }
    public float getFogStart() { return fogStart.get(); }
    public float getFogHeight() { return fogHeight.get(); }
    public float getFogThickness() { return fogThickness.get(); }
    public boolean isFogQuality() { return fogQuality.get(); }
    public int getFogColorSource() { return fogColorSource.get(); }

    public boolean isWetEnabled() { return wetWorldEnabled.get(); }
    public float getWetReflection() { return wetReflection.get() / 100f; }
    public float getWetHumidity() { return wetHumidity.get() / 100f; }
    public int getWetQuality() { return wetQuality.get(); }

    public boolean isRainEnabled() { return rainEnabled.get(); }
    public float getRainDensity() { return rainDensity.get() / 100f; }
    public float getRainVisibility() { return rainVisibility.get() / 100f; }
    public float getRainDrops() { return rainDrops.get() / 100f; }
    public float getRainSplashes() { return rainSplashes.get() / 100f; }
}