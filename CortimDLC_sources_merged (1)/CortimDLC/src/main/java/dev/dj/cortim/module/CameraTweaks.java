package dev.dj.cortim.module;

public class CameraTweaks extends Module {

    public final FloatSetting cameraDistance = add(new FloatSetting(
            "Дистанция камеры",
            "Максимальное отдаление камеры от персонажа",
            4.0f, 1.0f, 20.0f, 0.5f
    ));

    public final BoolSetting clipThrough = add(new BoolSetting(
            "Сквозь стены",
            "Позволяет камере проходить сквозь стены",
            true
    ));

    public final IntSetting f5Animation = add(new IntSetting(
            "Анимация F5",
            "Длительность плавного перехода камеры в мс (0 — мгновенно)",
            250, 0, 1000
    ));

    public CameraTweaks() { super("CameraTweaks", Category.VISUAL); }

    @Override
    public void onTick() {}
}