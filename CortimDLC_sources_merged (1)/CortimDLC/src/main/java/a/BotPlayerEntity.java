/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_1297
 *  net.minecraft.class_2561
 *  net.minecraft.class_299
 *  net.minecraft.class_310
 *  net.minecraft.class_3469
 *  net.minecraft.class_4277
 *  net.minecraft.class_4897
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package a;

import a.Bot;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import net.minecraft.class_10185;
import net.minecraft.class_1297;
import net.minecraft.class_2561;
import net.minecraft.class_299;
import net.minecraft.class_310;
import net.minecraft.class_3469;
import net.minecraft.class_4277;
import net.minecraft.class_4897;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public final class BotPlayerEntity
extends class_746 {
    private final Bot eil;
    private static /* synthetic */ long eim;
    private static /* synthetic */ String ein;

    BotPlayerEntity(class_310 class_3102, class_638 class_6382, class_634 class_6342, class_3469 class_34692, class_299 class_2992, class_10185 class_101852, boolean bl, Bot dtv2) {
        super(class_3102, class_6382, class_6342, class_34692, class_2992, class_101852, bl);
        this.eil = dtv2;
        this.eio();
    }

    private void eio() {
        for (Field field : class_746.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || !List.class.isAssignableFrom(field.getType())) continue;
            try {
                field.setAccessible(true);
                Object object2 = field.get((Object)this);
                if (!(object2 instanceof List)) continue;
                List list = (List)object2;
                list.removeIf(object -> object instanceof class_4277 || object instanceof class_4897);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public Bot getBot() {
        return this.eil;
    }

    public void method_7353(class_2561 class_25612, boolean bl) {
        this.eil.onLocalMessage(class_25612, bl);
    }

    public void method_7277(class_1297 class_12972) {
    }

    public void method_7304(class_1297 class_12972) {
    }

    private static /* synthetic */ int er(int n, int n2) {
        return n * n2 ^ 0xB786C8FC;
    }

    private static /* synthetic */ int es(int n, int n2) {
        return n + n2 | 0xDD28BB31;
    }

    private static /* synthetic */ int et(int n, int n2) {
        return BotPlayerEntity.es(n, n2) ^ 0xE2382334;
    }
}

