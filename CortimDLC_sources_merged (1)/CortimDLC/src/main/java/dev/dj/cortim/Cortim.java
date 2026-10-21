package dev.dj.cortim;

import dev.dj.cortim.gui.CortimScreen;
import dev.dj.cortim.module.AimAssist;
import dev.dj.cortim.module.Ambience;
import dev.dj.cortim.module.AspectRatio;
import dev.dj.cortim.module.Atmosphere;
import dev.dj.cortim.module.AutoBuy;
import dev.dj.cortim.module.AutoMace;
import dev.dj.cortim.module.AutoSwap;
import dev.dj.cortim.module.AutoTotem;
import dev.dj.cortim.module.CameraTweaks;
import dev.dj.cortim.module.Enchancer;
import dev.dj.cortim.module.FakePlayer;
import dev.dj.cortim.module.Freecam;
import dev.dj.cortim.module.FullBright;
import dev.dj.cortim.module.FastUse;
import dev.dj.cortim.module.GuiMove;
import dev.dj.cortim.module.Hud;
import dev.dj.cortim.module.Module;
import dev.dj.cortim.module.ModuleRegistry;
import dev.dj.cortim.module.NoFriendDamage;
import dev.dj.cortim.module.NoRender;
import dev.dj.cortim.module.Saturation;
import dev.dj.cortim.module.ShowInvisible;
import dev.dj.cortim.module.Smoothness;
import dev.dj.cortim.module.TriggerBot;
import dev.dj.cortim.module.ViewModel;
// import dev.dj.cortim.module.AutoWarden;
import dev.dj.cortim.render.CortimHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallback;
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
    private static Hud hud;
    private static Enchancer enchancer;
    private static NoRender noRender;
    private static AspectRatio aspectRatio;
    private static Saturation saturation;
    private static CameraTweaks cameraTweaks;
    private static ViewModel viewModel;
    private static FakePlayer fakePlayer;
    private static FullBright fullBright;
    private static Ambience ambience;
   // private static AutoWarden autoWarden;
    private static ShowInvisible showInvisible;
    private static FastUse fastUse;

    private static AimAssist aimAssist;
    private static AutoTotem autoTotem;
    private static AutoMace autoMace;
    private static NoFriendDamage noFriendDamage;

    private boolean rshiftDown = false;
    private final boolean[] lastKeyState = new boolean[512];
    private boolean lastMouseLeft = false;
    private boolean scrollInstalled = false;
    private GLFWScrollCallback previousScrollCb = null;

    private static Module bindingModule = null;
    private int lastBindKey = -1;
    private boolean lastDelete = false;
    private boolean lastEsc = false;

    public static Module getBindingModule() { return bindingModule; }
    public static void setBindingModule(Module m) { bindingModule = m; }

    @Override
    public void onInitializeClient() {
        LOG.info("Cortim loaded");

        triggerBot   = new TriggerBot();
        autoSwap     = new AutoSwap();
        guiMove      = new GuiMove();
        autoBuy      = new AutoBuy();
        freecam      = new Freecam();
        atmosphere   = new Atmosphere();
        smoothness   = new Smoothness();
        hud          = new Hud();
        fastUse = new FastUse();
        enchancer    = new Enchancer();
        noRender     = new NoRender();
        aspectRatio  = new AspectRatio();
        saturation   = new Saturation();
        cameraTweaks = new CameraTweaks();
        viewModel    = new ViewModel();
        fakePlayer   = new FakePlayer();
        fullBright   = new FullBright();
        ambience     = new Ambience();
        // autoWarden   = new AutoWarden();
        showInvisible = new ShowInvisible();

        aimAssist      = new AimAssist();
        autoTotem      = new AutoTotem();
        autoMace       = new AutoMace();
        noFriendDamage = new NoFriendDamage();

        ModuleRegistry.add(triggerBot);
        ModuleRegistry.add(autoSwap);
        ModuleRegistry.add(guiMove);
        ModuleRegistry.add(autoBuy);
        ModuleRegistry.add(freecam);
        ModuleRegistry.add(atmosphere);
        ModuleRegistry.add(smoothness);
        ModuleRegistry.add(hud);
        ModuleRegistry.add(enchancer);
        ModuleRegistry.add(noRender);
        ModuleRegistry.add(aspectRatio);
        ModuleRegistry.add(saturation);
        ModuleRegistry.add(cameraTweaks);
        ModuleRegistry.add(viewModel);
        ModuleRegistry.add(fakePlayer);
        ModuleRegistry.add(fullBright);
        ModuleRegistry.add(ambience);
       // ModuleRegistry.add(autoWarden);
        ModuleRegistry.add(showInvisible);

        ModuleRegistry.add(aimAssist);
        ModuleRegistry.add(autoTotem);
        ModuleRegistry.add(autoMace);
        ModuleRegistry.add(noFriendDamage);
        ModuleRegistry.add(fastUse);

        BindManager.load();

        CortimHud.register();
        Atmosphere.registerParticles();

        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
    }

    private void installScrollCallback() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.getWindow() == null) return;
        long win = client.getWindow().getHandle();

        long prevPtr = 0L;
        try {
            prevPtr = GLFW.nglfwSetScrollCallback(win, 0L);
        } catch (Throwable t) {
            LOG.warn("scroll save failed", t);
        }

        if (prevPtr != 0L) {
            previousScrollCb = GLFWScrollCallback.create(prevPtr);
        }

        GLFW.glfwSetScrollCallback(win, (window, x, y) -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc == null || mc.player == null) {
                if (previousScrollCb != null) previousScrollCb.invoke(window, x, y);
                return;
            }

            double[] mxA = new double[1], myA = new double[1];
            GLFW.glfwGetCursorPos(window, mxA, myA);
            int[] ww = new int[1], wh = new int[1];
            GLFW.glfwGetWindowSize(window, ww, wh);
            double sx = mc.getWindow().getScaledWidth() / (double) ww[0];
            double sy = mc.getWindow().getScaledHeight() / (double) wh[0];
            double mx = mxA[0] * sx;
            double my = myA[0] * sy;

            if (mc.currentScreen instanceof CortimScreen screen) {
                screen.handleScroll(mx, my, y);
                return;
            }

            if (mc.currentScreen instanceof ChatScreen) {
                if (CortimHud.handleScroll(mc, mx, my, y)) {
                    return;
                }
            }

            if (previousScrollCb != null) previousScrollCb.invoke(window, x, y);
        });
    }

    private void onTick(MinecraftClient client) {
        long win = client.getWindow().getHandle();

        if (!scrollInstalled) {
            installScrollCallback();
            scrollInstalled = true;
        }

        boolean chatOpen = client.currentScreen instanceof ChatScreen;
        if (chatOpen) {
            double[] mxArr = new double[1];
            double[] myArr = new double[1];
            GLFW.glfwGetCursorPos(win, mxArr, myArr);
            int[] ww = new int[1], wh = new int[1];
            GLFW.glfwGetWindowSize(win, ww, wh);
            double scaleX = client.getWindow().getScaledWidth() / (double) ww[0];
            double scaleY = client.getWindow().getScaledHeight() / (double) wh[0];
            double mx = mxArr[0] * scaleX;
            double my = myArr[0] * scaleY;

            boolean leftDown = GLFW.glfwGetMouseButton(win, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;

            if (leftDown && !lastMouseLeft && CortimHud.draggingName == null) {
                String hit = CortimHud.hitTest(client, mx, my);
                if (hit != null) {
                    CortimHud.draggingName = hit;
                    float[] pos = Hud.HUD_POS.getOrDefault(hit, new float[]{0.5f, 0.5f});
                    int sw = client.getWindow().getScaledWidth();
                    int sh = client.getWindow().getScaledHeight();
                    CortimHud.dragOffsetX = (int) (mx - pos[0] * sw);
                    CortimHud.dragOffsetY = (int) (my - pos[1] * sh);
                }
            }
            if (leftDown && CortimHud.draggingName != null) {
                CortimHud.drag(mx, my,
                        client.getWindow().getScaledWidth(),
                        client.getWindow().getScaledHeight());
            }
            if (!leftDown) {
                CortimHud.draggingName = null;
            }
            lastMouseLeft = leftDown;
        } else {
            lastMouseLeft = false;
            CortimHud.draggingName = null;
        }

        boolean rshift = GLFW.glfwGetKey(win, GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS;
        if (rshift && !rshiftDown && client.currentScreen == null && !CortimConfig.isPanic()) {
            client.setScreen(new CortimScreen());
        }
        rshiftDown = rshift;

        if (bindingModule != null) {
            boolean del = GLFW.glfwGetKey(win, GLFW.GLFW_KEY_DELETE) == GLFW.GLFW_PRESS;
            boolean esc = GLFW.glfwGetKey(win, GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS;

            if (del && !lastDelete) {
                bindingModule.clearBind();
                BindManager.save();
                bindingModule = null;
            } else if (esc && !lastEsc) {
                bindingModule = null;
            } else if (!del && !esc) {
                for (int key = 32; key < 348; key++) {
                    if (key == GLFW.GLFW_KEY_ESCAPE || key == GLFW.GLFW_KEY_DELETE) continue;
                    if (key == GLFW.GLFW_KEY_LEFT_SHIFT || key == GLFW.GLFW_KEY_RIGHT_SHIFT) continue;
                    if (key == GLFW.GLFW_KEY_LEFT_CONTROL || key == GLFW.GLFW_KEY_RIGHT_CONTROL) continue;
                    if (key == GLFW.GLFW_KEY_LEFT_ALT || key == GLFW.GLFW_KEY_RIGHT_ALT) continue;
                    if (key == GLFW.GLFW_KEY_LEFT_SUPER || key == GLFW.GLFW_KEY_RIGHT_SUPER) continue;

                    if (GLFW.glfwGetKey(win, key) == GLFW.GLFW_PRESS) {
                        if (key == lastBindKey) break;

                        for (Module other : ModuleRegistry.all()) {
                            if (other != bindingModule && other.getBoundKey() == key) {
                                other.clearBind();
                            }
                        }

                        lastBindKey = key;
                        bindingModule.setBoundKey(key);
                        BindManager.save();
                        bindingModule = null;
                        break;
                    }
                }
            }
            lastDelete = del;
            lastEsc = esc;
        } else {
            lastBindKey = -1;
            lastDelete = false;
        }

        if (client.currentScreen == null) {
            for (Module m : ModuleRegistry.all()) {
                int key = m.getBoundKey();
                if (key == -1 || key >= lastKeyState.length) continue;
                boolean pressed = GLFW.glfwGetKey(win, key) == GLFW.GLFW_PRESS;
                if (pressed && !lastKeyState[key]) {
                    m.toggle();
                    BindManager.save();
                }
                lastKeyState[key] = pressed;
            }
        }

        safe(triggerBot::onTick);
        safe(autoSwap::onTick);
        safe(guiMove::onTick);
        safe(autoBuy::onTick);
        safe(freecam::onTick);
        safe(smoothness::onTick);

        safe(aimAssist::onTick);
        safe(autoTotem::onTick);
        safe(autoMace::onTick);
        safe(noFriendDamage::onTick);

        safe(fakePlayer::onTick);
        safe(fullBright::onTick);
        safe(ambience::onTick);
        // safe(autoWarden::onTick);
        safe(fastUse::onTick);
    }

    private static void safe(Runnable r) {
        try {
            r.run();
        } catch (Throwable t) {
            LOG.warn("tick", t);
        }
    }

    public static Hud getHud() { return hud; }
    public static TriggerBot getTriggerBot() { return triggerBot; }
    public static Freecam getFreecam() { return freecam; }
    public static AspectRatio getAspectRatio() { return aspectRatio; }
    public static Saturation getSaturation() { return saturation; }
    public static CameraTweaks getCameraTweaks() { return cameraTweaks; }
    public static ViewModel getViewModel() { return viewModel; }
    public static Ambience getAmbience() { return ambience; }
    public static AimAssist getAimAssist() { return aimAssist; }
    public static FastUse getFastUse() { return fastUse; }
}