/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.entity.state.BipedEntityRenderState
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.LivingEntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.item.ItemStack
 */
package a;

import a.kfa;
import a.kfe;
import a.ukl;
import a.vkl;
import a.vmc;
import flow.cosmetic.Cosmetics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.item.ItemStack;

public class rqv
extends kfe {
    private static rqv rqw;
    private static final Map<Class<?>, List<Field>> rqx;
    private static final Map<Class<?>, Constructor<?>> rqy;
    private static final Set<EntityRenderState> rqz;
    private static Field rra;
    private static boolean rrb;
    private final vmc rrc = this.add(new vmc("Transparency", 0.5, 0.0, 0.95, 0.05).percent());
    private final vkl rrd = this.add(new vkl("Mobs", false));
    private static /* synthetic */ int rre;
    private static /* synthetic */ String rrf;

    public rqv() {
        super(new String(new char[]{'S', 'h', 'o', 'w', 'I', 'n', 'v', 'i', 's', 'i', 'b', 'l', 'e'}), "Invisible players show up see-through", kfa.RENDER);
        rqw = this;
    }

    public static boolean isFadedBody(EntityRenderState entityRenderState) {
        return !rqz.isEmpty() && rqz.contains(entityRenderState);
    }

    /*
     * Unable to fully structure code
     */
    public static void afterExtraction(WorldRenderState var0) {
        rqv.rqz.clear();
        var1_1 = rqv.rqw;
        if (var1_1 == null || !var1_1.isEnabled() || MinecraftClient.getInstance().world == null) {
            return;
        }
        var2_2 = ukl.canFade();
        var3_3 = null;
        for (EntityRenderState var5_5 : var0.entityRenderStates) {
            if (!(var5_5 instanceof LivingEntityRenderState)) continue;
            var6_6 = (LivingEntityRenderState)var5_5;
            if (!var6_6.invisibleToPlayer || !(var5_5 instanceof PlayerEntityRenderState) && !var1_1.rrd.get() || Cosmetics.hidesBody(var5_5)) continue;
            var6_6.invisibleToPlayer = false;
            if (!var2_2) continue;
            var6_6.invisible = false;
            if (!(var5_5 instanceof PlayerEntityRenderState)) ** GOTO lbl-1000
            var8_8 = (PlayerEntityRenderState)var5_5;
            if (Cosmetics.wears(var8_8.id)) {
                v0 = true;
            } else lbl-1000:
            // 2 sources

            {
                v0 = var7_7 = false;
            }
            if (var5_5 instanceof BipedEntityRenderState) {
                var8_8 = (BipedEntityRenderState)var5_5;
                if ((var7_7 || rqv.rrg((BipedEntityRenderState)var8_8)) && (var9_9 = rqv.rrh((BipedEntityRenderState)var8_8)) != null) {
                    if (var3_3 == null) {
                        var3_3 = new ArrayList<BipedEntityRenderState>();
                    }
                    var3_3.add(var9_9);
                    if (var7_7) {
                        rqv.rqz.add(var5_5);
                    }
                    var8_8.equippedHeadStack = ItemStack.EMPTY;
                    var8_8.equippedChestStack = ItemStack.EMPTY;
                    var8_8.equippedLegsStack = ItemStack.EMPTY;
                    var8_8.equippedFeetStack = ItemStack.EMPTY;
                }
            }
            ukl.fade(var5_5, 1.0f - (float)var1_1.rrc.get());
        }
        if (var3_3 != null) {
            var0.entityRenderStates.addAll(var3_3);
        }
    }

    private static boolean rrg(BipedEntityRenderState bipedEntityRenderState) {
        return !bipedEntityRenderState.equippedHeadStack.isEmpty() || !bipedEntityRenderState.equippedChestStack.isEmpty() || !bipedEntityRenderState.equippedLegsStack.isEmpty() || !bipedEntityRenderState.equippedFeetStack.isEmpty();
    }

    private static BipedEntityRenderState rrh(BipedEntityRenderState bipedEntityRenderState) {
        if (rrb) {
            return null;
        }
        try {
            Class<?> clazz = bipedEntityRenderState.getClass();
            Constructor<?> constructor = rqy.get(clazz);
            if (constructor == null) {
                constructor = clazz.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                rqy.put(clazz, constructor);
            }
            BipedEntityRenderState bipedEntityRenderState2 = (BipedEntityRenderState)constructor.newInstance(new Object[0]);
            for (Field field : rqv.rri(clazz)) {
                field.set(bipedEntityRenderState2, field.get(bipedEntityRenderState));
            }
            bipedEntityRenderState2.invisible = true;
            bipedEntityRenderState2.invisibleToPlayer = true;
            bipedEntityRenderState2.outlineColor = 0;
            bipedEntityRenderState2.displayName = null;
            bipedEntityRenderState2.nameLabelPos = null;
            bipedEntityRenderState2.leashDatas = null;
            bipedEntityRenderState2.shadowRadius = 0.0f;
            if (rra != null) {
                rra.set(bipedEntityRenderState2, new ArrayList());
            }
            return bipedEntityRenderState2;
        }
        catch (Throwable throwable) {
            rrb = true;
            System.out.println(new String(new char[]{'[', 'F', 'l', 'o', 'w', '2', ']', ' ', 's', 'o', 'l', 'i', 'd', ' ', 'a', 'r', 'm', 'o', 'u', 'r', ' ', 'u', 'n', 'a', 'v', 'a', 'i', 'l', 'a', 'b', 'l', 'e', ':', ' '}) + throwable);
            return null;
        }
    }

    private static List<Field> rri(Class<?> clazz) {
        List<Field> list = rqx.get(clazz);
        if (list != null) {
            return list;
        }
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Class clazz2 = clazz; clazz2 != null && clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            for (Field field : clazz2.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                arrayList.add(field);
                if (clazz2 != EntityRenderState.class || field.getType() != List.class || !field.getName().equals("shadowPieces")) continue;
                rra = field;
            }
        }
        if (rra == null) {
            for (Field field : arrayList) {
                if (field.getDeclaringClass() != EntityRenderState.class || field.getType() != List.class || !Modifier.isFinal(field.getModifiers())) continue;
                rra = field;
            }
        }
        rqx.put(clazz, arrayList);
        return arrayList;
    }

    static {
        rqx = new HashMap();
        rqy = new HashMap();
        rqz = Collections.newSetFromMap(new IdentityHashMap());
    }

    private static /* synthetic */ int cba(int n, int n2) {
        return n * n2 + -43546301;
    }

    private static /* synthetic */ int cbb(int n, int n2) {
        return n * n2 + 1851339594;
    }
}

