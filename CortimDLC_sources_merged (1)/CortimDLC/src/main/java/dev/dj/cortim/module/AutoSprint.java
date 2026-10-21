package dev.dj.cortim.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;

public class AutoSprint extends Module {

    private boolean forced = false;

    public AutoSprint() { super("AutoSprint", Category.MOVEMENT); }

    /** В окнах бежим, только если GuiMove включён и разрешает движение в этом окне. */
    private static boolean screenOk(MinecraftClient mc) {
        Screen s = mc.currentScreen;
        if (s == null) return true;
        Module m = ModuleRegistry.byName("GuiMove");
        return m instanceof GuiMove g && g.isEnabled() && g.screenAllowed(s);
    }

    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity p = mc.player;

        boolean want = isEnabled()
                && p != null
                && mc.world != null
                && screenOk(mc)
                && mc.options.forwardKey.isPressed()
                && !mc.options.backKey.isPressed()
                && !p.isSneaking();

        if (want) {
            mc.options.sprintKey.setPressed(true);
            forced = true;
        } else if (forced) {
            mc.options.sprintKey.setPressed(false);
            forced = false;
        }
    }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        if (!v && forced) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc != null && mc.options != null) mc.options.sprintKey.setPressed(false);
            forced = false;
        }
    }
}