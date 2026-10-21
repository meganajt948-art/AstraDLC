package dev.dj.cortim;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.dj.cortim.module.Module;
import dev.dj.cortim.module.ModuleRegistry;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public final class BindManager {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("cortim_binds.json");

    private BindManager() {}

    /**
     * Сохраняет биндов модулей ("Модуль" -> клавиша) и клавиши из KeySetting ("Модуль:Настройка" -> клавиша).
     */
    public static void save() {
        Map<String, Integer> map = new HashMap<>();
        for (Module m : ModuleRegistry.all()) {
            if (m.getBoundKey() != -1) map.put(m.getName(), m.getBoundKey());
            for (Module.Setting<?> s : m.getSettings()) {
                if (s instanceof Module.KeySetting ks && ks.getKey() != -1) {
                    map.put(m.getName() + ":" + ks.getName(), ks.getKey());
                }
            }
        }
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(map));
        } catch (IOException e) {
            Cortim.LOG.warn("bind save failed", e);
        }
    }

    public static void load() {
        if (!Files.exists(FILE)) return;
        try {
            String json = Files.readString(FILE);
            Map<String, Integer> map = GSON.fromJson(json, new TypeToken<Map<String, Integer>>(){}.getType());
            if (map == null) return;
            for (var e : map.entrySet()) {
                String key = e.getKey();
                int colon = key.indexOf(':');
                if (colon < 0) {
                    Module m = ModuleRegistry.byName(key);
                    if (m != null) m.setBoundKey(e.getValue());
                } else {
                    Module m = ModuleRegistry.byName(key.substring(0, colon));
                    if (m == null) continue;
                    String settingName = key.substring(colon + 1);
                    for (Module.Setting<?> s : m.getSettings()) {
                        if (s instanceof Module.KeySetting ks && ks.getName().equals(settingName)) {
                            ks.set(e.getValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            Cortim.LOG.warn("bind load failed", e);
        }
    }
}