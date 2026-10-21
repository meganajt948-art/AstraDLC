package dev.dj.cortim.module;

public class NoJumpDelay extends Module {

    /** Нужен миксину, чтобы не искать модуль в реестре каждый тик. */
    public static NoJumpDelay instance;

    public NoJumpDelay() {
        super("NoJumpDelay", Category.MOVEMENT);
        instance = this;
    }
}