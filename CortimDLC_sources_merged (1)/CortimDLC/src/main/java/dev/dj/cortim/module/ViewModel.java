package dev.dj.cortim.module;

public class ViewModel extends Module {

    public final BoolSetting mirror = add(new BoolSetting(
            "Зеркало",
            "Левая рука зеркалит правую",
            false
    ));

    // ─── ПРАВАЯ РУКА ───
    public final FloatSetting rightX = add(new FloatSetting(
            "X",
            "Позиция руки по X",
            2.0f, -10.0f, 10.0f, 0.1f
    ));
    public final FloatSetting rightY = add(new FloatSetting(
            "Y",
            "Позиция руки по Y",
            -2.0f, -10.0f, 10.0f, 0.1f
    ));
    public final FloatSetting rightScale = add(new FloatSetting(
            "Размер",
            "Размер руки",
            0.753f, 0.1f, 2.0f, 0.001f
    ));

    // ─── ЛЕВАЯ РУКА (скрываются при зеркале) ───
    public final FloatSetting leftX = new FloatSetting(
            "L.X",
            "Левая рука позиция по X",
            0.0f, -10.0f, 10.0f, 0.1f
    ) {
        @Override public boolean isVisible() { return !mirror.get(); }
    };
    public final FloatSetting leftY = new FloatSetting(
            "L.Y",
            "Левая рука позиция по Y",
            0.0f, -10.0f, 10.0f, 0.1f
    ) {
        @Override public boolean isVisible() { return !mirror.get(); }
    };
    public final FloatSetting leftScale = new FloatSetting(
            "L.Scale",
            "Размер левой руки",
            1.0f, 0.1f, 2.0f, 0.001f
    ) {
        @Override public boolean isVisible() { return !mirror.get(); }
    };

    public final ButtonSetting resetBtn = add(new ButtonSetting(
            "Сброс",
            "Сбросить настройки руки",
            this::reset
    ));

    public ViewModel() {
        super("ViewModel", Category.VISUAL);
        add(leftX);
        add(leftY);
        add(leftScale);
    }

    private void reset() {
        rightX.set(2.0f);
        rightY.set(-2.0f);
        rightScale.set(0.753f);
        leftX.set(0.0f);
        leftY.set(0.0f);
        leftScale.set(1.0f);
    }

    public float getRightX() { return rightX.get(); }
    public float getRightY() { return rightY.get(); }
    public float getRightScale() { return rightScale.get(); }

    public float getLeftX() {
        if (mirror.get()) return -rightX.get();
        return leftX.get();
    }
    public float getLeftY() {
        if (mirror.get()) return rightY.get();
        return leftY.get();
    }
    public float getLeftScale() {
        if (mirror.get()) return rightScale.get();
        return leftScale.get();
    }

    @Override
    public void onTick() {}
}