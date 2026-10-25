/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.FoodComponent
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.HungerManager
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Hand
 *  net.minecraft.util.Identifier
 */
package a;

import a.kfa;
import a.kfe;
import a.ujt;
import a.uut;
import a.vdn;
import a.veo;
import a.vkl;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

public class rpj
extends kfe {
    private static rpj rpk;
    private final vkl rpl = this.add(new vkl("Food preview", true));
    private final vkl rpm = this.add(new vkl("Number", false));
    private static final Identifier rpn;
    private static final Identifier rpo;
    private static final int rpp = -670639;
    private static final vdn rpq;
    private static /* synthetic */ String rpr;
    private static /* synthetic */ String rps;

    public rpj() {
        super(new String(new char[]{'S', 'a', 't', 'u', 'r', 'a', 't', 'i', 'o', 'n'}), "Shows saturation on the hunger bar", kfa.RENDER);
        rpk = this;
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        float f;
        float f2;
        Object object;
        rpj rpj2 = rpk;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient.player;
        if (rpj2 == null || !rpj2.isEnabled() || clientPlayerEntity == null || minecraftClient.interactionManager == null || !minecraftClient.interactionManager.hasStatusBars() || clientPlayerEntity.getVehicle() instanceof LivingEntity) {
            return;
        }
        HungerManager hungerManager = clientPlayerEntity.getHungerManager();
        int n = hungerManager.getFoodLevel();
        float f3 = hungerManager.getSaturationLevel();
        int n2 = drawContext.getScaledWindowWidth() / 2 + 91;
        int n3 = drawContext.getScaledWindowHeight() - 39;
        FoodComponent foodComponent = null;
        if (rpj2.rpl.get()) {
            for (Hand hand : Hand.values()) {
                ItemStack itemStack = clientPlayerEntity.getStackInHand(hand);
                object = (FoodComponent)itemStack.get(DataComponentTypes.FOOD);
                if (object == null) continue;
                foodComponent = object;
                break;
            }
        }
        float f4 = 0.35f + 0.3f * (float)Math.sin((double)System.currentTimeMillis() / 180.0);
        if (foodComponent != null && n < 20) {
            int n4 = Math.min(20, n + foodComponent.nutrition());
            int n5 = ujt.withAlpha(-1, Math.round(255.0f * f4));
            for (int i = 0; i < 10; ++i) {
                int n6;
                int n7;
                int n8 = i * 2 + 1;
                int n9 = n8 < n ? 2 : (n7 = n8 == n ? 1 : 0);
                int n10 = n8 < n4 ? 2 : (n6 = n8 == n4 ? 1 : 0);
                if (n6 <= n7) continue;
                drawContext.drawGuiTexture(RenderPipelines.GUI_TEXTURED, n6 == 2 ? rpn : rpo, n2 - i * 8 - 9, n3, 9, 9, n5);
            }
        }
        uut.beginFrame();
        float f5 = 80.0f;
        float f6 = 1.3f;
        float f7 = (float)n3 - f6 - 0.6f;
        uut.round(drawContext, (float)n2 - f5 - 0.5f, f7, f5, f6, f6 * 0.5f, 0x55000000);
        float f8 = f5 * Math.max(0.0f, Math.min(20.0f, f3)) / 20.0f;
        if (foodComponent != null && (f2 = f5 * Math.max(0.0f, f = Math.min(Math.min(20.0f, (float)(n + foodComponent.nutrition())), f3 + foodComponent.saturation())) / 20.0f) > f8) {
            uut.round(drawContext, (float)n2 - f2 - 0.5f, f7, f2, f6, f6 * 0.5f, ujt.withAlpha(-670639, Math.round(255.0f * f4)));
        }
        if (f8 > 0.2f) {
            uut.round(drawContext, (float)n2 - f8 - 0.5f, f7, f8, f6, f6 * 0.5f, -670639);
        }
        if (rpj2.rpm.get()) {
            object = String.format(Locale.ROOT, "%.1f", Float.valueOf(f3));
            rpq.draw(drawContext, (String)object, (float)n2 + 3.0f, rpq.centerTop((float)n3 + 4.5f) + 0.5f, -1879048192);
            rpq.draw(drawContext, (String)object, (float)n2 + 2.5f, rpq.centerTop((float)n3 + 4.5f), -670639);
        }
    }

    static {
        rpn = Identifier.ofVanilla((String)"hud/food_full");
        rpo = Identifier.ofVanilla((String)"hud/food_half");
        rpq = veo.semibold(5.8f);
    }

    private static /* synthetic */ int cap(int n, int n2) {
        return n ^ n2 | 0xBD5FD127;
    }
}

