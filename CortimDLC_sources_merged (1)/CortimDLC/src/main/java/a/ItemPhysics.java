/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.class_1299
 *  net.minecraft.class_310
 */
package a;

import a.ModuleCategory;
import a.Module;
import a.ItemEntityRenderer;
import a.NumberSetting;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.class_1299;
import net.minecraft.class_310;

public class ItemPhysics
extends Module {
    private static ItemPhysics rfq;
    private static boolean rfr;
    private final NumberSetting rfs = this.add(new NumberSetting("Spin", 1.0, 0.2, 2.0, 0.1).unit("x"));
    private static /* synthetic */ int rft;
    private static /* synthetic */ int rfu;

    public ItemPhysics() {
        super(new String(new char[]{'I', 't', 'e', 'm', 'P', 'h', 'y', 's', 'i', 'c', 's'}), "Items lie flat and tumble", ModuleCategory.RENDER);
        rfq = this;
    }

    public static boolean on() {
        return rfq != null && rfq.isEnabled();
    }

    public static float spin() {
        return rfq == null ? 1.0f : (float)ItemPhysics.rfq.rfs.get();
    }

    @Override
    public void onEndTick(class_310 class_3102) {
        if (rfr) {
            return;
        }
        rfr = true;
        try {
            EntityRendererRegistry.register((class_1299)class_1299.field_6052, ItemEntityRenderer::new);
            class_3102.method_1561().method_14491(class_3102.method_1478());
        }
        catch (Throwable throwable) {
            System.out.println("item physics unavailable: " + throwable);
        }
    }

    private static /* synthetic */ int byf(int n, int n2) {
        return n ^ n2 | 0x86372E47;
    }
}

