/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class FabricAddonsBridge {
    private static final Field[] egb = FabricAddonsBridge.ege();
    private static /* synthetic */ boolean egc;
    private static /* synthetic */ boolean egd;

    private FabricAddonsBridge() {
    }

    private static Field[] ege() {
        try {
            Class<?> clazz = Class.forName("net.fabricmc.fabric.impl.networking.client.ClientNetworkingImpl");
            ArrayList<Field> arrayList = new ArrayList<Field>();
            for (Field field : clazz.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()) || !field.getType().getSimpleName().contains("Addon")) continue;
                field.setAccessible(true);
                arrayList.add(field);
            }
            return arrayList.toArray(new Field[0]);
        }
        catch (Throwable throwable) {
            return new Field[0];
        }
    }

    static Object[] saveAddons() {
        if (egb.length == 0) {
            return null;
        }
        Object[] objectArray = new Object[egb.length];
        try {
            for (int i = 0; i < egb.length; ++i) {
                objectArray[i] = egb[i].get(null);
            }
            return objectArray;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static void restoreAddons(Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        for (int i = 0; i < egb.length && i < objectArray.length; ++i) {
            try {
                egb[i].set(null, objectArray[i]);
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static void clearConfiguration() {
        for (Field field : egb) {
            if (!field.getType().getSimpleName().contains("Configuration")) continue;
            try {
                field.set(null, null);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static Object[] created(Object[] objectArray, Object[] objectArray2) {
        Object[] objectArray3 = FabricAddonsBridge.saveAddons();
        if (objectArray3 == null) {
            return objectArray2;
        }
        Object[] objectArray4 = new Object[objectArray3.length];
        for (int i = 0; i < objectArray3.length; ++i) {
            boolean bl;
            boolean bl2 = bl = objectArray == null || i >= objectArray.length || objectArray3[i] != objectArray[i];
            objectArray4[i] = bl ? objectArray3[i] : (objectArray2 == null || i >= objectArray2.length ? null : objectArray2[i]);
        }
        return objectArray4;
    }

    private static /* synthetic */ int do(int n, int n2) {
        return n ^ n2 | 0x5A776E5D;
    }

    private static /* synthetic */ int dp(int n, int n2) {
        return FabricAddonsBridge.do(n, n2) ^ 0x87A766D2;
    }
}

