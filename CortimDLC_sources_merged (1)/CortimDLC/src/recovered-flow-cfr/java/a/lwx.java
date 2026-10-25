/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.Element
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.RecipeBookScreen
 *  net.minecraft.client.gui.screen.recipebook.RecipeBookWidget
 *  net.minecraft.client.gui.widget.TextFieldWidget
 *  net.minecraft.client.option.GameOptions
 *  net.minecraft.client.option.KeyBinding
 */
package a;

import a.hlc;
import a.iwf;
import a.kfa;
import a.kfe;
import a.vkl;
import a.vwy;
import a.vxr;
import a.vyn;
import a.vzz;
import flow.dev.a;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public class lwx
extends kfe {
    private static final Field lwy = vxr.find(RecipeBookScreen.class, a.d("\ucd46\ub4fc\u3e3e\ua015\u2b81\uad34\u1760\u9e9a\u00c3\u8a63\u0da3\uf7d5\u7910\ue0fb\u6ae5\uec1b\u5659\ud99a\u4329\uc554\u4ccd\u369d\ub82c\u23f9\ua580", -1820797324, -558556347), a.d("\ue6d0\u9f6e\u15b1\u8bc9\u0016\u869c\u3ca5\ub555\u2b0a\ua1b8\u2668", 1736400144, -1498629203), a.d("\u87dc\ufe4f\u7497\ueaf7\u617b\ue788\u5ddf\ud429\u4a7d\uc0ca\u4708\ubd6a\u33ba\uaa19\u2011\ua6ac\u1cec\u9330\u0991\u8fc0\u061b\u7c20\uf296\u6940\uef33", -34768457, -1570636226));
    private static final Field lwz = vxr.find(RecipeBookWidget.class, a.c(-2006701995, "\u282c\u5196\udb54\u457f\uceeb\u485e\uf20a\u7bf0\ue5a9\u6f09\ue8c9\u12bf\u9c7a\u0591\u8f8f\u0971\ub333\u3cf0\ua643\u203e\ua9a3\ud3f7\u5d43"), a.d("\u43f4\u3a4a\ub095\u2eed\ua532\u23b8\u9987\u1075\u8e22\u0492", -1104652422, 569578722), a.b("\ub5fa\ucc69\u46b1\ud8d1\u535d\ud5ae\u6ff9\ue60f\u785b\uf2ec\u752e\u8f4c\u019c\u983f\u1237\u948a\u2eca\ua116\u3bb7\ubde6\u343d\u4e00\uc0b4\u5b63\udd15", 1739765167));
    private static lwx lxa;
    private final vkl lxb = this.add(new vkl(a.c(-181852024, "\u28d5\u5147\udb96\u45fc\uce2c\u4887\uf280\u7b3e\ue560\u6f9f\ue82f\u1269\u9cb8\u0517"), true));
    private final vkl lxc = this.add(new vkl(a.d("\u95d6\uec58\u6693\uf8ff", 138811725, -1000698667), true));
    private final vkl lxd = this.add(new vkl(a.b("\u16d5\u6f43\ue5de\u7bec\uf034\u7680\uccdf\u4525\udb60\u5185\ud61b\u2c62\ua2be\u3b14", -890300782), true));
    private final vkl lxe = this.add(new vkl(a.d("\ud8ae\ua130\u2bf9\ub595\u3e0b\ub8d7\u02bc\u8b54\u1513\u9fbf\u1844\ue217\u6cd7\uf57b\u7f2e\uf9de\u438c", -964803076, -1197040382), true));
    private final vyn lxf = new vyn();
    private boolean lxg;
    private static /* synthetic */ long lxh;
    private static /* synthetic */ long lxi;

    public lwx() {
        super(a.b("\u8d0a\uf489\u7e46\ue013\u6be6\ued4e\u570e", 1015582026), a.c(1246025295, "\ud626\uafb5\u257f\ubb1d\u308f\ub669\u0c24\u85c8\u1b8b\u9172\u16f5\uec98\u6242\ufbb6\u71ac\uf75a\u4d0d\uc2cf\u5877\ude3c\u57d0\u2d9c\ua324\u38ac\ube9c\u3450\u8db1\u03ad\u9952\u1f08\u94a0\u6a24\ue024\u79ca\uff8c\u7536"), kfa.MOVEMENT);
        lxa = this;
    }

    public static void attach(Screen screen2) {
        lwx lwx2 = lxa;
        if (lwx2 == null) {
            return;
        }
        if (screen2 instanceof HandledScreen) {
            ScreenKeyboardEvents.allowKeyPress((Screen)screen2).register((screen, keyInput) -> !lwx2.isEnabled() || !lwx2.lxc.get() || !lwx2.mc.options.jumpKey.matchesKey(keyInput) || lwx.lxk(screen));
        }
        if (lwx2.isEnabled() && lwx2.lxj(screen2) && !lwx2.lxf.isHeld()) {
            lwx2.lxl(lwx2.mc);
            lwx2.lxg = true;
        }
    }

    @Override
    protected void onDisable() {
        vwy.setActive(false);
        this.lxf.release(this.mc);
        if (this.mc.currentScreen != null && this.mc.options != null) {
            lwx.lxm(this.mc);
        }
        this.lxg = false;
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        vwy.setActive(this.lxe.get());
        if (this.lxe.get()) {
            vwy.ensure(minecraftClient);
            if (vwy.waiting()) {
                this.lxf.hold(minecraftClient);
                return;
            }
        }
        boolean bl = this.lxf.isHeld();
        this.lxf.release(minecraftClient);
        Screen screen = minecraftClient.currentScreen;
        if (screen == null) {
            if (this.lxg) {
                lwx.lxn(minecraftClient);
            }
            this.lxg = false;
        } else if (this.lxj(screen)) {
            this.lxl(minecraftClient);
            this.lxg = true;
        } else if (this.lxg || bl) {
            lwx.lxm(minecraftClient);
            this.lxg = false;
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (this.lxe.get() && vwy.waiting()) {
            vwy.poke(false);
        }
    }

    private boolean lxj(Screen screen) {
        if (screen instanceof hlc) {
            hlc hlc2 = (hlc)screen;
            return this.lxd.get() && !hlc2.typing();
        }
        if (screen instanceof iwf) {
            return true;
        }
        return screen instanceof HandledScreen && !lwx.lxk(screen);
    }

    private static boolean lxk(Screen screen) {
        Object object;
        Element element;
        Object object2 = screen.children().iterator();
        while (object2.hasNext()) {
            element = (Element)object2.next();
            if (!(element instanceof TextFieldWidget) || !(object = (TextFieldWidget)element).isFocused() || !object.isVisible()) continue;
            return true;
        }
        if (screen instanceof RecipeBookScreen && lwy != null && lwz != null) {
            try {
                object = lwy.get(screen);
                return object instanceof RecipeBookWidget && (element = (RecipeBookWidget)object).isOpen() && (object = lwz.get(element)) instanceof TextFieldWidget && (object2 = object).isFocused();
            }
            catch (IllegalAccessException | RuntimeException exception) {
                // empty catch block
            }
        }
        return false;
    }

    private void lxl(MinecraftClient minecraftClient) {
        GameOptions gameOptions = minecraftClient.options;
        lwx.lxo(minecraftClient, gameOptions.forwardKey, true);
        lwx.lxo(minecraftClient, gameOptions.backKey, true);
        lwx.lxo(minecraftClient, gameOptions.leftKey, true);
        lwx.lxo(minecraftClient, gameOptions.rightKey, true);
        lwx.lxo(minecraftClient, gameOptions.jumpKey, this.lxc.get());
        if (!((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            lwx.lxo(minecraftClient, gameOptions.sprintKey, this.lxb.get());
        }
        if (!((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
            gameOptions.sneakKey.setPressed(false);
        }
        gameOptions.useKey.setPressed(false);
    }

    private static void lxm(MinecraftClient minecraftClient) {
        GameOptions gameOptions = minecraftClient.options;
        for (KeyBinding keyBinding : new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey, gameOptions.useKey}) {
            keyBinding.setPressed(false);
        }
        if (!((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            gameOptions.sprintKey.setPressed(false);
        }
        if (!((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
            gameOptions.sneakKey.setPressed(false);
        }
    }

    private static void lxn(MinecraftClient minecraftClient) {
        GameOptions gameOptions = minecraftClient.options;
        for (KeyBinding keyBinding : new KeyBinding[]{gameOptions.forwardKey, gameOptions.backKey, gameOptions.leftKey, gameOptions.rightKey, gameOptions.jumpKey}) {
            lwx.lxo(minecraftClient, keyBinding, true);
        }
        if (!((Boolean)gameOptions.getSprintToggled().getValue()).booleanValue()) {
            lwx.lxo(minecraftClient, gameOptions.sprintKey, true);
        }
        if (!((Boolean)gameOptions.getSneakToggled().getValue()).booleanValue()) {
            lwx.lxo(minecraftClient, gameOptions.sneakKey, true);
        }
    }

    private static void lxo(MinecraftClient minecraftClient, KeyBinding keyBinding, boolean bl) {
        keyBinding.setPressed(bl && vzz.isPhysicallyDown(minecraftClient, keyBinding));
    }

    private static /* synthetic */ int bad(int n, int n2) {
        return n - n2 | 0x368F1D42;
    }

    private static /* synthetic */ int bae(int n, int n2) {
        return lwx.bad(n, n2) + n;
    }
}

