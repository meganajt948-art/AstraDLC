/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.client.MinecraftClient
 */
package flow.config;

import a.dry;
import a.evy;
import a.ewk;
import a.kfe;
import a.vkl;
import a.vlj;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vmo;
import a.vmu;
import a.wap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.Flow;
import flow.config.ConfigShare;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

public final class ConfigManager {
    public static final vkl AUTO_SAVE = new vkl("Auto-save", true);
    public static final vkl LOAD_ON_START = new vkl("Load on start", true);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final int MAX_NAME = 32;
    private static String active;
    private static volatile int version;

    private ConfigManager() {
    }

    public static Path gameDir() {
        try {
            return FabricLoader.getInstance().getGameDir();
        }
        catch (Throwable t) {
            return MinecraftClient.getInstance().runDirectory.toPath();
        }
    }

    public static int version() {
        return version;
    }

    public static String active() {
        return active;
    }

    public static void setActive(String name) {
        active = name == null || name.isBlank() ? null : name;
        ++version;
    }

    public static String sanitize(String name) {
        if (name == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        name.codePoints().filter(c -> Character.isLetterOrDigit(c) || c == 32 || c == 45 || c == 95 || c == 46).forEach(sb::appendCodePoint);
        String s = sb.toString().trim();
        while (s.startsWith(".")) {
            s = s.substring(1).trim();
        }
        if (s.length() > 32) {
            s = s.substring(0, 32).trim();
        }
        return s.isEmpty() ? null : s;
    }

    public static boolean exists(String name) {
        return ewk.hasConfig(name);
    }

    public static List<Info> list() {
        ArrayList<Info> list = new ArrayList<Info>();
        for (Map.Entry<String, evy> e : ewk.configs().entrySet()) {
            evy c = e.getValue();
            list.add(new Info(e.getKey(), c.updated() * 1000L, c.enabled(), c.modules()));
        }
        list.sort(Comparator.comparingLong(Info::modified).reversed());
        return list;
    }

    public static void save(String name) throws IOException {
        ewk.putConfig(name, ConfigManager.json(), ConfigManager.enabledCount(), ConfigManager.moduleCount());
        ConfigManager.setActive(name);
        ConfigShare.refresh(name);
    }

    static void addImported(String name, String data, int enabled, int modules) {
        ewk.putConfig(name, data, enabled, modules);
        ++version;
    }

    private static int moduleCount() {
        return Flow.getInstance().getModuleManager().getModules().size();
    }

    private static int enabledCount() {
        int n = 0;
        for (kfe m : Flow.getInstance().getModuleManager().getModules()) {
            if (m.isAction() || !m.isEnabled()) continue;
            ++n;
        }
        return n;
    }

    private static String json() {
        JsonObject root = new JsonObject();
        root.addProperty("version", (Number)1);
        root.addProperty("saved", (Number)System.currentTimeMillis());
        JsonObject mods = new JsonObject();
        for (kfe m : Flow.getInstance().getModuleManager().getModules()) {
            JsonObject o = new JsonObject();
            if (!m.isAction()) {
                o.addProperty("enabled", Boolean.valueOf(m.isEnabled()));
            }
            o.addProperty("key", (Number)m.getKey());
            JsonObject settings = new JsonObject();
            for (vmo s : m.getSettings()) {
                if (s instanceof vkl) {
                    vkl b = (vkl)s;
                    settings.addProperty(s.getName(), Boolean.valueOf(b.get()));
                    continue;
                }
                if (s instanceof vmc) {
                    vmc n = (vmc)s;
                    settings.addProperty(s.getName(), (Number)n.get());
                    continue;
                }
                if (s instanceof vlv) {
                    vlv mode = (vlv)s;
                    settings.addProperty(s.getName(), mode.get());
                    continue;
                }
                if (s instanceof vlq) {
                    vlq key = (vlq)s;
                    settings.addProperty(s.getName(), (Number)key.get());
                    continue;
                }
                if (s instanceof vmu) {
                    vmu text = (vmu)s;
                    settings.addProperty(s.getName(), text.get());
                    continue;
                }
                if (!(s instanceof vlj)) continue;
                vlj list = (vlj)s;
                JsonArray ids = new JsonArray();
                list.ids().forEach(arg_0 -> ((JsonArray)ids).add(arg_0));
                settings.add(s.getName(), (JsonElement)ids);
            }
            o.add("settings", (JsonElement)settings);
            mods.add(m.getName(), (JsonElement)o);
        }
        root.add("modules", (JsonElement)mods);
        return GSON.toJson((JsonElement)root);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void load(String name) throws IOException {
        JsonObject root;
        String raw = ewk.getConfig(name);
        if (raw == null) {
            throw new IOException(wap.s("no config ", "\u043d\u0435\u0442 \u043a\u043e\u043d\u0444\u0438\u0433\u0430 ") + name);
        }
        byte[] fileBytes = raw.getBytes(StandardCharsets.UTF_8);
        try (InputStreamReader r = new InputStreamReader((InputStream)new ByteArrayInputStream(fileBytes), StandardCharsets.UTF_8);){
            root = JsonParser.parseReader((Reader)r).getAsJsonObject();
        }
        finally {
            Arrays.fill(fileBytes, (byte)0);
        }
        JsonObject mods = root.getAsJsonObject("modules");
        if (mods == null) {
            throw new IOException(wap.s("no modules in ", "\u043d\u0435\u0442 \u043c\u043e\u0434\u0443\u043b\u0435\u0439 \u0432 ") + name);
        }
        for (kfe m : Flow.getInstance().getModuleManager().getModules()) {
            JsonElement el = mods.get(m.getName());
            if (el == null || !el.isJsonObject()) continue;
            JsonObject o = el.getAsJsonObject();
            JsonObject settings = o.getAsJsonObject("settings");
            if (settings != null) {
                for (vmo s : m.getSettings()) {
                    JsonElement v = settings.get(s.getName());
                    if (v == null) continue;
                    try {
                        if (s instanceof vkl) {
                            vkl b = (vkl)s;
                            b.set(v.getAsBoolean());
                            continue;
                        }
                        if (s instanceof vmc) {
                            vmc n = (vmc)s;
                            n.set(v.getAsDouble());
                            continue;
                        }
                        if (s instanceof vlv) {
                            vlv mode = (vlv)s;
                            mode.set(v.getAsString());
                            continue;
                        }
                        if (s instanceof vlq) {
                            vlq key = (vlq)s;
                            key.set(v.getAsInt());
                            continue;
                        }
                        if (s instanceof vmu) {
                            vmu text = (vmu)s;
                            text.set(v.getAsString());
                            continue;
                        }
                        if (!(s instanceof vlj)) continue;
                        vlj list = (vlj)s;
                        if (!v.isJsonArray()) continue;
                        ArrayList<String> ids = new ArrayList<String>();
                        v.getAsJsonArray().forEach(e -> ids.add(e.getAsString()));
                        list.set(ids);
                    }
                    catch (RuntimeException runtimeException) {}
                }
            }
            if (o.has("key")) {
                m.setKey(o.get("key").getAsInt());
            }
            m.onConfigLoaded(o.has("enabled"));
            if (!o.has("enabled") || m.isAction()) continue;
            m.setEnabled(o.get("enabled").getAsBoolean());
        }
        ConfigManager.setActive(name);
    }

    public static void delete(String name) throws IOException {
        ewk.deleteConfig(name);
        ConfigShare.forget(name);
        if (name.equals(active)) {
            active = null;
        }
        ++version;
    }

    public static void rename(String from, String to) throws IOException {
        if (from.equals(to)) {
            return;
        }
        if (ConfigManager.exists(to)) {
            throw new IOException(wap.s("\"" + to + "\" already exists", "\u00ab" + to + "\u00bb \u0443\u0436\u0435 \u0435\u0441\u0442\u044c"));
        }
        ewk.renameConfig(from, to);
        ConfigShare.forget(to);
        ConfigShare.renamed(from, to);
        if (from.equals(active)) {
            active = to;
        }
        ++version;
    }

    public static void autoSaveLater() {
        if (AUTO_SAVE.get() && active != null && !dry.armed()) {
            ewk.putConfig(active, ConfigManager.json(), ConfigManager.enabledCount(), ConfigManager.moduleCount());
            ++version;
            ConfigShare.refresh(active);
        }
    }

    public static void autoSave() {
        if (AUTO_SAVE.get() && active != null && !dry.armed()) {
            try {
                ConfigManager.save(active);
            }
            catch (IOException e) {
                System.out.println("auto-save of " + active + " failed: " + e);
            }
        }
    }

    public record Info(String name, long modified, int enabled, int modules) {
    }
}

