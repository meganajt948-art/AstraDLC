/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 */
package a;

import net.minecraft.class_304;

public interface BotHost {
    public static final /* synthetic */ int dk = 0;
    public static final /* synthetic */ boolean dl = false;

    public void look(float var1, float var2);

    public double mouseStep();

    public boolean heldByHuman(class_304 var1);

    public String getName();

    default public void report(String string, boolean bl) {
    }

    default public int pendingPackets() {
        return 0;
    }

    default public void halted() {
    }
}

