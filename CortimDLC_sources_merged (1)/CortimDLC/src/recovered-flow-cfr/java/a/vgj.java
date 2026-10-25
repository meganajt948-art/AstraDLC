/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.item.ItemModelManager
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.render.entity.EntityRenderManager
 *  net.minecraft.client.render.item.HeldItemRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.item.CrossbowItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RotationAxis
 *  org.joml.Quaternionfc
 */
package a;

import a.vhf;
import a.vhu;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionfc;

public final class vgj
extends HeldItemRenderer {
    private static Field vgk;
    private static Field vgl;
    private static Field vgm;
    private static Field vgn;
    private static Field vgo;
    private static Field vgp;
    private static Field vgq;
    private static MethodHandle vgr;
    private static boolean vgs;
    private static boolean vgt;
    private static Field vgu;
    private final MinecraftClient vgv;
    private final ItemModelManager vgw;
    private static /* synthetic */ int vgx;
    private static /* synthetic */ boolean vgy;

    private vgj(MinecraftClient minecraftClient, EntityRenderManager entityRenderManager, ItemModelManager itemModelManager) {
        super(minecraftClient, entityRenderManager, itemModelManager);
        this.vgv = minecraftClient;
        this.vgw = itemModelManager;
    }

    public static void ensureInstalled(MinecraftClient minecraftClient) {
        if (vgs || minecraftClient.field_1773 == null) {
            return;
        }
        try {
            Object object;
            Object object2;
            Field field = vgu;
            if (field == null) {
                object2 = GameRenderer.class.getDeclaredFields();
                int n = ((Field[])object2).length;
                for (int i = 0; i < n; ++i) {
                    object = object2[i];
                    if (Modifier.isStatic(object.getModifiers()) || object.getType() != HeldItemRenderer.class) continue;
                    field = object;
                    break;
                }
                if (field == null) {
                    throw new IllegalStateException("no hand renderer in GameRenderer");
                }
                field.setAccessible(true);
                vgu = field;
            }
            if ((object2 = field.get(minecraftClient.field_1773)) instanceof vgj) {
                return;
            }
            vgj.vgz();
            HeldItemRenderer heldItemRenderer = (HeldItemRenderer)object2;
            ItemModelManager itemModelManager = (ItemModelManager)vgq.get(heldItemRenderer);
            object = new vgj(minecraftClient, minecraftClient.method_1561(), itemModelManager);
            for (Field field2 : HeldItemRenderer.class.getDeclaredFields()) {
                int n = field2.getModifiers();
                if (Modifier.isStatic(n) || Modifier.isFinal(n)) continue;
                field2.setAccessible(true);
                field2.set(object, field2.get(heldItemRenderer));
            }
            field.set(minecraftClient.field_1773, object);
            if (!vgt) {
                vgt = true;
                System.out.println("hand renderer ready (view model, hand shaders)");
            }
        }
        catch (Throwable throwable) {
            vgs = true;
            System.out.println("hand tweaks unavailable, the game's hands stay: " + throwable);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void vgz() throws ReflectiveOperationException {
        void var2_5;
        if (vgr != null) {
            return;
        }
        ArrayList<Field> arrayList = new ArrayList<Field>();
        ArrayList<Field> arrayList2 = new ArrayList<Field>();
        for (Field field : HeldItemRenderer.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            field.setAccessible(true);
            if (field.getType() == ItemStack.class) {
                arrayList.add(field);
                continue;
            }
            if (field.getType() == Float.TYPE) {
                arrayList2.add(field);
                continue;
            }
            if (field.getType() != ItemModelManager.class) continue;
            vgq = field;
        }
        if (arrayList.size() != 2 || arrayList2.size() != 4 || vgq == null) {
            throw new IllegalStateException("unexpected hand renderer layout: " + arrayList.size() + " stacks, " + arrayList2.size() + " floats");
        }
        vgk = (Field)arrayList.get(0);
        vgl = (Field)arrayList.get(1);
        vgm = (Field)arrayList2.get(0);
        vgn = (Field)arrayList2.get(1);
        vgo = (Field)arrayList2.get(2);
        vgp = (Field)arrayList2.get(3);
        Object var2_3 = null;
        for (Method method : HeldItemRenderer.class.getDeclaredMethods()) {
            Class<?>[] classArray = method.getParameterTypes();
            if (method.getReturnType() != Void.TYPE || classArray.length != 10 || classArray[0] != AbstractClientPlayerEntity.class || classArray[3] != Hand.class || classArray[5] != ItemStack.class || classArray[7] != MatrixStack.class || classArray[8] != OrderedRenderCommandQueue.class || classArray[9] != Integer.TYPE) continue;
            Method method2 = method;
            break;
        }
        if (var2_5 == null) {
            throw new IllegalStateException("first-person item method not found");
        }
        var2_5.setAccessible(true);
        vgr = MethodHandles.lookup().unreflect((Method)var2_5);
    }

    public void method_22976(float f, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, ClientPlayerEntity clientPlayerEntity, int n) {
        if (!vhu.changesHands()) {
            super.method_22976(f, matrixStack, orderedRenderCommandQueue, clientPlayerEntity, n);
            vhf.afterHands(clientPlayerEntity, f);
            return;
        }
        try {
            this.vha(f, matrixStack, orderedRenderCommandQueue, clientPlayerEntity, n);
        }
        catch (Throwable throwable) {
            vgs = true;
            System.out.println("hand tweaks failed, back to the game's hands: " + throwable);
            super.method_22976(f, matrixStack, orderedRenderCommandQueue, clientPlayerEntity, n);
        }
        vhf.afterHands(clientPlayerEntity, f);
    }

    private void vha(float f, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, ClientPlayerEntity clientPlayerEntity, int n) throws Throwable {
        float f2;
        float f3 = clientPlayerEntity.method_6055(f);
        Hand hand = clientPlayerEntity.field_6266 != null ? clientPlayerEntity.field_6266 : Hand.field_5808;
        float f4 = clientPlayerEntity.method_61414(f);
        float f5 = MathHelper.method_16439((float)f, (float)clientPlayerEntity.field_3914, (float)clientPlayerEntity.field_3916);
        float f6 = MathHelper.method_16439((float)f, (float)clientPlayerEntity.field_3931, (float)clientPlayerEntity.field_3932);
        matrixStack.method_22907((Quaternionfc)RotationAxis.field_40714.rotationDegrees((clientPlayerEntity.method_5695(f) - f5) * 0.1f));
        matrixStack.method_22907((Quaternionfc)RotationAxis.field_40716.rotationDegrees((clientPlayerEntity.method_5705(f) - f6) * 0.1f));
        boolean[] blArray = vgj.vhc(clientPlayerEntity);
        ItemStack itemStack = (ItemStack)vgk.get((Object)this);
        ItemStack itemStack2 = (ItemStack)vgl.get((Object)this);
        if (blArray[0]) {
            f2 = this.vgw.method_75483(itemStack) * (1.0f - MathHelper.method_16439((float)f, (float)vgn.getFloat((Object)this), (float)vgm.getFloat((Object)this)));
            this.vhb((AbstractClientPlayerEntity)clientPlayerEntity, f, f4, Hand.field_5808, hand == Hand.field_5808 ? f3 : 0.0f, itemStack, f2, matrixStack, orderedRenderCommandQueue, n);
        }
        if (blArray[1]) {
            f2 = this.vgw.method_75483(itemStack2) * (1.0f - MathHelper.method_16439((float)f, (float)vgp.getFloat((Object)this), (float)vgo.getFloat((Object)this)));
            this.vhb((AbstractClientPlayerEntity)clientPlayerEntity, f, f4, Hand.field_5810, hand == Hand.field_5810 ? f3 : 0.0f, itemStack2, f2, matrixStack, orderedRenderCommandQueue, n);
        }
        this.vgv.field_1773.method_72911().method_73002();
        this.vgv.method_22940().method_23000().method_22993();
    }

    private void vhb(AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float f2, Hand hand, float f3, ItemStack itemStack, float f4, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int n) throws Throwable {
        Arm arm = hand == Hand.field_5808 ? abstractClientPlayerEntity.method_6068() : abstractClientPlayerEntity.method_6068().method_5928();
        boolean bl = itemStack.method_31574(Items.field_49814);
        boolean bl2 = vhu.swings(abstractClientPlayerEntity, hand, itemStack);
        matrixStack.method_22903();
        if (!bl) {
            vhu.viewModel(matrixStack, arm);
        }
        if (bl2) {
            vhu.swing(matrixStack, abstractClientPlayerEntity, arm, hand, f3, itemStack, f);
        }
        vgr.invoke(this, abstractClientPlayerEntity, f, f2, hand, bl2 ? 0.0f : f3, itemStack, bl2 && !bl ? 0.0f : f4, matrixStack, orderedRenderCommandQueue, n);
        matrixStack.method_22909();
    }

    private static boolean[] vhc(ClientPlayerEntity clientPlayerEntity) {
        boolean bl;
        ItemStack itemStack = clientPlayerEntity.method_6047();
        ItemStack itemStack2 = clientPlayerEntity.method_6079();
        boolean bl2 = itemStack.method_31574(Items.field_8102) || itemStack2.method_31574(Items.field_8102);
        boolean bl3 = bl = itemStack.method_31574(Items.field_8399) || itemStack2.method_31574(Items.field_8399);
        if (!bl2 && !bl) {
            return new boolean[]{true, true};
        }
        if (clientPlayerEntity.method_6115()) {
            ItemStack itemStack3 = clientPlayerEntity.method_6030();
            Hand hand = clientPlayerEntity.method_6058();
            if (!itemStack3.method_31574(Items.field_8102) && !itemStack3.method_31574(Items.field_8399)) {
                boolean bl4 = hand == Hand.field_5808 && vgj.vhd(itemStack2);
                return new boolean[]{true, !bl4};
            }
            return new boolean[]{hand == Hand.field_5808, hand == Hand.field_5810};
        }
        return new boolean[]{true, !vgj.vhd(itemStack)};
    }

    private static boolean vhd(ItemStack itemStack) {
        return itemStack.method_31574(Items.field_8399) && CrossbowItem.method_7781((ItemStack)itemStack);
    }

    private static /* synthetic */ int deu(int n, int n2) {
        return n - n2 ^ 0x8AEEDDA2;
    }
}

