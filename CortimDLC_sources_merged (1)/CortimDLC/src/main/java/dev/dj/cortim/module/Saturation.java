package dev.dj.cortim.module;

public class Saturation extends Module {

    public final ModeSetting preset = add(new ModeSetting(
            "Пресет",
            "Уровень насыщенности",
            1,
            "Низкий",
            "Средний",
            "Высокий"
    ));

    public final BoolSetting worldOnly = add(new BoolSetting(
            "Только мир",
            "Применять до интерфейса клиента: меню и HUD останутся обычными",
            false
    ));

    public Saturation() { super("Saturation", Category.VISUAL); }

    public String getPresetId() {
        return switch (preset.get()) {
            case 0 -> "saturation_low";
            case 2 -> "saturation_high";
            default -> "saturation_mid";
        };
    }

    public boolean isWorldOnly() { return worldOnly.get(); }

    @Override
    public void onTick() {}
}