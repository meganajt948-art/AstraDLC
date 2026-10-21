package dev.dj.cortim.module;

public class Enchancer extends Module {

    public final MultiSetting chat = add(new MultiSetting(
            "Чат",
            "Настройки чата",
            0b11,
            "Бесконечный чат",
            "Не очищать чат"
    ));

    public final BoolSetting cleanF3 = add(new BoolSetting(
            "Чистый F3",
            "Отключает ванильный экран отладки и рисует компактный оверлей",
            false
    ));

    public Enchancer() { super("Enchancer", Category.VISUAL); }

    public boolean infiniteChat() { return chat.isOn(0); }
    public boolean keepHistory() { return chat.isOn(1); }

    @Override
    public void onTick() {}
}