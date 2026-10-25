/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.EntityType
 */
package a;

import a.kfa;
import a.kfe;
import a.usj;
import a.vmc;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;

public class rfp
extends kfe {
    private static rfp rfq;
    private static boolean rfr;
    private final vmc rfs = this.add(new vmc("Spin", 1.0, 0.2, 2.0, 0.1).unit("x"));
    private static /* synthetic */ int rft;
    private static /* synthetic */ int rfu;

    public rfp() {
        super(new String(new char[]{'I', 't', 'e', 'm', 'P', 'h', 'y', 's', 'i', 'c', 's'}), "Items lie flat and tumble", kfa.RENDER);
        rfq = this;
    }

    public static boolean on() {
        return rfq != null && rfq.isEnabled();
    }

    public static float spin() {
        return rfq == null ? 1.0f : (float)rfp.rfq.rfs.get();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (rfr) {
            return;
        }
        rfr = true;
        try {
            EntityRendererRegistry.register((EntityType)EntityType.field_6052, usj::new);
            minecraftClient.method_1561().method_14491(minecraftClient.method_1478());
        }
        catch (Throwable throwable) {
            System.out.println("item physics unavailable: " + throwable);
        }
    }

    private static /* synthetic */ int byf(int n, int n2) {
        return n ^ n2 | 0x86372E47;
    }
}

