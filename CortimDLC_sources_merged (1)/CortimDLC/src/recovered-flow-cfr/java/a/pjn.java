/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.BossBarHud
 *  net.minecraft.client.gui.hud.ClientBossBar
 */
package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;

public final class pjn {
    private static final Pattern pjo = Pattern.compile(a.d("\u8712\ufed7\u743c\uea02\u61d7", -528009649, -1113018000));
    private static Field pjp;
    private static boolean pjq;
    private static /* synthetic */ boolean pjr;
    private static /* synthetic */ int pjs;

    private pjn() {
    }

    public static Field field() {
        if (!pjq) {
            pjq = true;
            for (Field field : BossBarHud.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || !Map.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                pjp = field;
                break;
            }
        }
        return pjp;
    }

    public static Map<UUID, ClientBossBar> of(MinecraftClient minecraftClient) {
        Field field = pjn.field();
        if (field == null || minecraftClient.field_1705 == null) {
            return Collections.emptyMap();
        }
        try {
            Map map;
            Object object = field.get(minecraftClient.field_1705.method_1740());
            return object instanceof Map ? (map = (Map)object) : Collections.emptyMap();
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            return Collections.emptyMap();
        }
    }

    public static boolean contains(MinecraftClient minecraftClient, String string) {
        for (ClientBossBar clientBossBar : pjn.of(minecraftClient).values()) {
            if (!clientBossBar.method_5414().getString().contains(string)) continue;
            return true;
        }
        return false;
    }

    public static int teleportSeconds(MinecraftClient minecraftClient, String string) {
        for (ClientBossBar clientBossBar : pjn.of(minecraftClient).values()) {
            String string2 = clientBossBar.method_5414().getString();
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
        return pjn.bki(n, n2) * n2;
    }
}

