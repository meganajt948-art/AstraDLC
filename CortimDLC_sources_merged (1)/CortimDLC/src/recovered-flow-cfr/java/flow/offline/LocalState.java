/*
 * Decompiled with CFR 0.152.
 */
package flow.offline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public final class LocalState {
    private static boolean ready;
    private static Map<String, String> slots;
    private static Map<String, Object> configs;
    private static Class<?> configType;
    private static Path file;

    private LocalState() {
    }

    private static String encode(String s) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    private static String decode(String s) {
        return new String(Base64.getUrlDecoder().decode(s), StandardCharsets.UTF_8);
    }

    public static synchronized void init() {
        if (ready) {
            return;
        }
        ready = true;
        try {
            ClassLoader loader = LocalState.class.getClassLoader();
            Class<?> cloud = Class.forName("a.ewk", false, loader);
            Field sf = cloud.getDeclaredField("ewo");
            Field cf = cloud.getDeclaredField("ewp");
            sf.setAccessible(true);
            cf.setAccessible(true);
            slots = (Map)sf.get(null);
            configs = (Map)cf.get(null);
            configType = Class.forName("a.evy", false, loader);
            Path game = Path.of(System.getProperty("user.dir"), new String[0]);
            try {
                Class<?> fabric = Class.forName("net.fabricmc.loader.api.FabricLoader");
                Object instance = fabric.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                game = (Path)fabric.getMethod("getGameDir", new Class[0]).invoke(instance, new Object[0]);
            }
            catch (ReflectiveOperationException fabric) {
                // empty catch block
            }
            file = game.resolve("config").resolve("flow2-offline").resolve("state.properties");
            if (Files.isRegularFile(file, new LinkOption[0])) {
                Properties p = new Properties();
                try (BufferedReader r = Files.newBufferedReader(file, StandardCharsets.UTF_8);){
                    p.load(r);
                }
                Constructor<?> ctor = configType.getConstructor(String.class, Integer.TYPE, Integer.TYPE, Long.TYPE);
                for (String key : p.stringPropertyNames()) {
                    if (key.startsWith("slot.")) {
                        slots.put(LocalState.decode(key.substring(5)), p.getProperty(key));
                        continue;
                    }
                    if (!key.startsWith("config.") || !key.endsWith(".data")) continue;
                    String prefix = key.substring(0, key.length() - 5);
                    configs.put(LocalState.decode(prefix.substring(7)), ctor.newInstance(p.getProperty(key), Integer.parseInt(p.getProperty(prefix + ".enabled", "0")), Integer.parseInt(p.getProperty(prefix + ".modules", "0")), Long.parseLong(p.getProperty(prefix + ".updated", "0"))));
                }
            }
            Runtime.getRuntime().addShutdownHook(new Thread(LocalState::save, "Flow2 local save"));
        }
        catch (Exception ex) {
            System.err.println("[Flow2] Local settings: " + String.valueOf(ex));
        }
    }

    public static synchronized void save() {
        if (!ready || file == null || slots == null || configs == null) {
            return;
        }
        try {
            Properties p = new Properties();
            slots.forEach((key, value) -> p.setProperty("slot." + LocalState.encode(key), (String)value));
            for (Map.Entry<String, Object> e : configs.entrySet()) {
                String prefix = "config." + LocalState.encode(e.getKey());
                Object value2 = e.getValue();
                for (String field : List.of("data", "enabled", "modules", "updated")) {
                    p.setProperty(prefix + "." + field, String.valueOf(configType.getMethod(field, new Class[0]).invoke(value2, new Object[0])));
                }
            }
            Files.createDirectories(file.getParent(), new FileAttribute[0]);
            Path temp = file.resolveSibling("state.properties.tmp");
            try (BufferedWriter writer = Files.newBufferedWriter(temp, StandardCharsets.UTF_8, new OpenOption[0]);){
                p.store(writer, "Flow2 local settings");
            }
            try {
                Files.move(temp, file, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            }
            catch (AtomicMoveNotSupportedException ex) {
                Files.move(temp, file, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (Exception ex) {
            System.err.println("[Flow2] Could not save local settings: " + String.valueOf(ex));
        }
    }
}

