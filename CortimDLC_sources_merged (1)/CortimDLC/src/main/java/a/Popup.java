/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package a;

import a.ClickGuiScreen;
import a.TextField;
import net.minecraft.class_332;

abstract class Popup {
    private static /* synthetic */ int ijz;
    private static /* synthetic */ String ika;

    Popup() {
    }

    abstract TextField field();

    abstract boolean gone();

    abstract boolean closing();

    abstract void close();

    abstract void render(class_332 var1, ClickGuiScreen var2, float var3, float var4, float var5, float var6, float var7);

    abstract boolean mouseClicked(ClickGuiScreen var1, float var2, float var3, int var4);

    abstract void scrolled(double var1);

    abstract boolean keyPressed(ClickGuiScreen var1, int var2, int var3);

    private static /* synthetic */ int agp(int n, int n2) {
        return n * n2 ^ 0x1FF641;
    }

    private static /* synthetic */ int agq(int n, int n2) {
        return n * n2 | 0x6F35F84B;
    }
}

