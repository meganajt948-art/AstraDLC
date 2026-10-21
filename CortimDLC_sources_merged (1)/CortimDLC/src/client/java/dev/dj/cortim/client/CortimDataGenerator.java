// language: Java, file: src/main/java/dev/dj/cortim/Cortim.java
package dev.dj.cortim;

import dev.dj.cortim.gui.CortimScreen;
import dev.dj.cortim.module.*;
import dev.dj.cortim.render.CortimHud;
import dev.dj.cortim.render.EspRenderer;
import dev.dj.cortim.render.TracerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cortim implements ClientModInitializer {

    public static final Logger LOG = LoggerFactory.getLogger("cortim");

    private static TriggerBot triggerBot;
    private static AutoSwap autoSwap;
    private static GuiMove guiMove;
    private static AutoBuy autoBuy;
    private static Freecam freecam;
    private static Atmosphere atmosphere;
    private static Smoothness smoothness;

    private boolean rshiftDown = false;
    private final boolean[] lastKeyState = new boolean[512];

    @Override
    public void onInitializeClient() {
        LOG.info("Cortim loaded");

        triggerBot = new TriggerBot();
        autoSwap = new AutoSwap();
        guiMove = new GuiMove();
        autoBuy = new AutoBuy();
        freecam = new Freecam();
        atmosphere = new Atmosphere();
        smoothness = new Smoothness();

        // регистрация в реестре для GUI
        ModuleRegistry.add(triggerBot);
        ModuleRegistry.add(autoSwap);
        ModuleRegistry.add(guiMove);
        ModuleRegistry.add(autoBuy);
        ModuleRegistry.add(freecam);
        ModuleRegistry.add(atmosphere);
        ModuleRegistry.add(smoothness);

        BindManager.load();

        EspRenderer.register();
        TracerRenderer.register();
        CortimHud.register();
        Atmosphere.registerParticles();

        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
    }

    private void onTick(MinecraftClient client) {
        // RightShift — открыть меню
        long win = client.getWindow().getHandle();
        boolean rshift = GLFW.glfwGetKey(win, GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS;
        if (rshift && !rshiftDown && client.currentScreen == null && !CortimConfig.isPanic()) {
            client.setScreen(new CortimScreen());
        }
        rshiftDown = rshift;

        // обработка биндов модулей
        for (Module m : ModuleRegistry.all()) {
            int key = m.getBoundKey();
            if (key == -1 || key >= lastKeyState.length) continue;
            boolean pressed = GLFW.glfwGetKey(win, key) == GLFW.GLFW_PRESS;
            if (pressed && !lastKeyState[key] && client.currentScreen == null) {
                m.toggle();
                BindManager.save();
            }
            lastKeyState[key] = pressed;
        }

        safe(triggerBot::onTick);
        safe(autoSwap::onTick);
        safe(guiMove::onTick);
        safe(autoBuy::onTick);
        safe(freecam::onTick);
        safe(smoothness::onTick);
    }

    private static void safe(Runnable r) {
        try { r.run(); } catch (Throwable t) { LOG.warn("tick", t); }
    }
}