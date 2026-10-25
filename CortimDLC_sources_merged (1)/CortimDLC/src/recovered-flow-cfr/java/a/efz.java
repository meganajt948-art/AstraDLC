/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.option.KeyBinding
 */
package a;

import net.minecraft.client.option.KeyBinding;

public interface efz {
    public static final /* synthetic */ int dk = 0;
    public static final /* synthetic */ boolean dl = false;

    public void look(float var1, float var2);

    public double mouseStep();

    public boolean heldByHuman(KeyBinding var1);

    public String getName();

    default public void report(String string, boolean bl) {
    }

    default public int pendingPackets() {
        return 0;
    }

    default public void halted() {
    }
}

