/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.kfa;
import a.kfe;
import a.vkl;
import a.vmc;
import a.vxl;
import flow.dev.a;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.lwjgl.glfw.GLFW;

public class owo
extends kfe {
    private static owo owp;
    private final vkl owq = this.add(new vkl(a.c(677360224, "\ub239\ucbb3\u4161\udf1f\u54da\ud23f\u6828\ue1cf\u7f83\uf534"), true));
    private final vkl owr = this.add(new vkl(a.d("\u5099\u2917\ua3c9\u3db8\ub666", -1305334915, 1830058934), true));
    private final vmc ows = this.add(new vmc(a.d("\u0270\u7be2\uf124\u6f55\ue483", -84827491, -172187461), 2.0, 1.0, 6.0, 1.0).suffix(a.d("\u6f6b\u1681\u9c4f\u0234\u89eb", 1449612396, -627295443)));
    private final ArrayDeque<Integer> owt = new ArrayDeque();
    private final Set<Integer> owu = new HashSet<Integer>();
    private int owv = -1;
    private boolean oww;
    private static /* synthetic */ long owx;
    private static /* synthetic */ long owy;

    public owo() {
        super(a.b("\u8226\ufbaa\u7168\uef11\u64f8\ue279\u583b\ud1d7\u4f8b\uc53a\u42e0\ub886", -1402961309), a.c(1765240970, "\u70fa\u0970\u83a2\u1ddc\u9619\u10fc\uaaeb\u230c\ubd40\u37f7\ub063\u4a53\uc48b\u5d30\ud727\u5181\uebd1\u640d\ufebe\u78e6\uf15d\u8b58\u05f0\u9e6e\u185c\u928f\u2b25\ua567\u3fd5\ub9d7\u3263\ucca7\u46ea\udf13\u5958"), kfa.PLAYER);
        owp = this;
    }

    public static void attach(Screen screen2) {
        HandledScreen handledScreen;
        block3: {
            block2: {
                if (!(screen2 instanceof HandledScreen)) break block2;
                handledScreen = (HandledScreen)screen2;
                if (!(screen2 instanceof CreativeInventoryScreen)) break block3;
            }
            return;
        }
        ScreenMouseEvents.allowMouseScroll((Screen)screen2).register((screen, d, d2, d3, d4) -> owp == null || !owp.owz(handledScreen, d4));
        ScreenEvents.afterRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> {
            if (owp != null) {
                owp.oxa(handledScreen);
            }
        });
        ScreenEvents.remove((Screen)screen2).register(screen -> {
            if (owp != null) {
                owo.owp.owt.clear();
                owo.owp.owu.clear();
                owo.owp.oww = false;
            }
        });
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        HandledScreen handledScreen;
        Screen screen;
        block6: {
            block5: {
                if (this.owt.isEmpty()) {
                    return;
                }
                screen = minecraftClient.field_1755;
                if (!(screen instanceof HandledScreen)) break block5;
                handledScreen = (HandledScreen)screen;
                if (minecraftClient.field_1724 != null && handledScreen.method_17577().field_7763 == this.owv) break block6;
            }
            this.owt.clear();
            return;
        }
        screen = handledScreen.method_17577();
        for (int i = 0; i < this.ows.getInt() && !this.owt.isEmpty(); ++i) {
            int n = this.owt.poll();
            if (n < 0 || n >= screen.field_7761.size() || !((Slot)screen.field_7761.get(n)).method_7681() || !screen.method_34255().method_7960()) continue;
            minecraftClient.field_1761.method_2906(screen.field_7763, n, 0, SlotActionType.field_7794, (PlayerEntity)minecraftClient.field_1724);
        }
    }

    private boolean owz(HandledScreen<?> handledScreen, double d) {
        if (!this.isEnabled() || !this.owr.get() || d == 0.0) {
            return false;
        }
        Slot slot = vxl.hovered(handledScreen);
        if (slot == null || !slot.method_7681()) {
            return false;
        }
        this.oxb(handledScreen, slot);
        return true;
    }

    private void oxa(HandledScreen<?> handledScreen) {
        boolean bl;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (!this.isEnabled() || !this.owq.get() || minecraftClient.method_22683() == null) {
            this.oww = false;
            return;
        }
        long l = minecraftClient.method_22683().method_4490();
        boolean bl2 = GLFW.glfwGetKey((long)l, (int)340) == 1 || GLFW.glfwGetKey((long)l, (int)344) == 1;
        boolean bl3 = bl = GLFW.glfwGetMouseButton((long)l, (int)0) == 1;
        if (!(bl2 && bl && handledScreen.method_17577().method_34255().method_7960())) {
            this.oww = false;
            this.owu.clear();
            return;
        }
        Slot slot = vxl.hovered(handledScreen);
        if (!this.oww) {
            this.oww = true;
            this.owu.clear();
            if (slot != null) {
                this.owu.add(slot.field_7874);
            }
            return;
        }
        if (slot != null && slot.method_7681() && this.owu.add(slot.field_7874)) {
            this.oxb(handledScreen, slot);
        }
    }

    private void oxb(HandledScreen<?> handledScreen, Slot slot) {
        int n = handledScreen.method_17577().field_7763;
        if (n != this.owv) {
            this.owt.clear();
            this.owv = n;
        }
        if (!this.owt.contains(slot.field_7874)) {
            this.owt.add(slot.field_7874);
        }
    }

    private static /* synthetic */ int bfm(int n, int n2) {
        return n * n2 + 1489084710;
    }

    private static /* synthetic */ int bfn(int n, int n2) {
        return owo.bfm(n, n2) ^ 0xAAD5D4F7;
    }
}

