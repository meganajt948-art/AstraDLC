package dev.dj.cortim.module;

public class AspectRatio extends Module {

    public final ModeSetting preset = add(new ModeSetting(
            "Пресет",
            "Соотношение сторон",
            3, // по умолчанию "Своё"
            "16:9",
            "16:10",
            "4:3",
            "Своё"
    ));

    public final FloatSetting ratio = add(new FloatSetting(
            "Соотношение",
            "Ширина, делённая на высоту",
            1.34f, 0.5f, 3.0f, 0.01f
    ));

    public AspectRatio() { super("AspectRatio", Category.VISUAL); }

    /**
     * Возвращает текущее выбранное соотношение.
     * Если preset != Своё — берём из пресета, иначе — из слайдера.
     */
    public float getEffectiveRatio() {
        return switch (preset.get()) {
            case 0 -> 16f / 9f;
            case 1 -> 16f / 10f;
            case 2 -> 4f / 3f;
            default -> ratio.get();
        };
    }

    /**
     * Автоматически синхронизирует слайдер, когда выбрали пресет.
     */
    @Override
    public void onTick() {
        if (preset.get() != 3) {
            float r = getEffectiveRatio();
            if (Math.abs(ratio.get() - r) > 0.001f) {
                ratio.set(r);
            }
        }
    }
}