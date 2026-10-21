/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_337
 *  net.minecraft.class_345
 */
package a;

import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_310;
import net.minecraft.class_337;
import net.minecraft.class_345;

public final class TeleportTimer {
    private static final Pattern pjo = Pattern.compile("(\\d+)");
    private static Field pjp;
    private static boolean pjq;
    private static /* synthetic */ boolean pjr;
    private static /* synthetic */ int pjs;

    private TeleportTimer() {
    }

    public static Field field() {
        if (!pjq) {
            pjq = true;
            for (Field field : class_337.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || !Map.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                pjp = field;
                break;
            }
        }
        return pjp;
    }

    public static Map<UUID, class_345> of(class_310 class_3102) {
        Field field = TeleportTimer.field();
        if (field == null || class_3102.field_1705 == null) {
            return Collections.emptyMap();
        }
        try {
            Map map;
            Object object = field.get(class_3102.field_1705.method_1740());
            return object instanceof Map ? (map = (Map)object) : Collections.emptyMap();
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            return Collections.emptyMap();
        }
    }

    public static boolean contains(class_310 class_3102, String string) {
        for (class_345 class_3452 : TeleportTimer.of(class_3102).values()) {
            if (!class_3452.method_5414().getString().contains(string)) continue;
            return true;
        }
        return false;
    }

    public static int teleportSeconds(class_310 class_3102, String string) {
        for (class_345 class_3452 : TeleportTimer.of(class_3102).values()) {
            String string2 = class_3452.method_5414().getString();
            if (!string2.contains(string)) continue;
            Matcher matcher = pjo.matcher(string2);
            if (matcher.find()) {
                try {
                    return Integer.parseInt(matcher.group(1));
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
            }
            return 5;
        }
        return -1;
    }

    private static /* synthetic */ int bki(int n, int n2) {
        return n + n2 | 0xE4CCCD90;
    }

    private static /* synthetic */ int bkj(int n, int n2) {
        return TeleportTimer.bki(n, n2) * n2;
    }
}

