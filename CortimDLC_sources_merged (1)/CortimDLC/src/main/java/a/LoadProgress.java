/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package a;

import a.AssetStore;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.StringDecryptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class LoadProgress {
    private static final long eyy = 60L;
    private static final int eyz = 6;
    private static final String[] eza = new String[]{"menu/autumn.jpg", "menu/spring.jpg", "menu/summer.jpg", "menu/winter.jpg", "menu/waterfall.jpg", "menu/waterfall.png", "avatars/cat.png", "avatars/monkey.png", "avatars/pug.png", "video/flow-dark.mp4", "video/flow-light.mp4", "video/flow-dark.jpg", "video/flow-light.jpg", "video/autumn-cats.jpg", "video/castle.jpg", "video/cherry.jpg", "video/elf.jpg", "video/farm.jpg", "video/flowers.jpg", "video/hsr-sky.jpg", "video/samurai.jpg", "video/snow.jpg", "video/sparkle.jpg", "sounds/weather/rain_heavy.ogg", "sounds/weather/rain_light.ogg", "sounds/weather/thunder_far_1.ogg", "sounds/weather/thunder_far_2.ogg", "sounds/weather/thunder_far_3.ogg", "sounds/weather/thunder_mid_1.ogg", "sounds/weather/thunder_mid_2.ogg", "sounds/weather/thunder_near_1.ogg", "sounds/weather/thunder_near_2.ogg", "sounds/weather/thunder_near_3.ogg", "sounds/weather/thunder_near_4.ogg", "captcha/digits.onnx", "wallpapers/alpine-night.jpg", "wallpapers/aurora.jpg", "wallpapers/bloom.jpg", "wallpapers/cats.jpg", "wallpapers/dunes.jpg", "wallpapers/dusk.jpg", "wallpapers/earthrise.jpg", "wallpapers/eclipse.jpg", "wallpapers/ember.jpg", "wallpapers/emerald-lake.jpg", "wallpapers/glacier-lake.jpg", "wallpapers/golden-sea.jpg", "wallpapers/hanami.jpg", "wallpapers/isles.jpg", "wallpapers/lanterns.jpg", "wallpapers/liquid.jpg", "wallpapers/milky-coast.jpg", "wallpapers/misty-pines.jpg", "wallpapers/nebula.jpg", "wallpapers/night-alley.jpg", "wallpapers/peaks.jpg", "wallpapers/prism.jpg", "wallpapers/sakura-night.jpg", "wallpapers/shibuya.jpg", "wallpapers/starfall.jpg", "wallpapers/starlit-lake.jpg", "wallpapers/tokyo-tower.jpg", "wallpapers/waves.jpg"};
    private static volatile boolean ezb;
    private static final AtomicInteger ezc;
    private static volatile int ezd;
    private static /* synthetic */ boolean eze;
    private static /* synthetic */ boolean ezf;

    private LoadProgress() {
    }

    public static boolean done() {
        return ezb;
    }

    public static String progress() {
        return ezc.get() + "/" + Math.max(ezd, ezc.get());
    }

    public static int loaded() {
        return ezc.get();
    }

    public static int total() {
        return ezd;
    }

    public static float fraction() {
        int n = ezd;
        return ezb ? 1.0f : (n <= 0 ? 0.0f : Math.min(1.0f, (float)ezc.get() / (float)n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void run() {
        if (ezb) {
            return;
        }
        long l = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(6, runnable -> {
            Thread thread = new Thread(runnable, "Flow2 prefetch");
            thread.setDaemon(true);
            return thread;
        });
        try {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(List.of(eza));
            linkedHashSet.addAll(LoadProgress.ezg(l));
            ezd = linkedHashSet.size();
            ArrayList arrayList = new ArrayList();
            for (String object : linkedHashSet) {
                arrayList.add(executorService.submit(() -> {
                    try {
                        AssetStore.bytes(object);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    ezc.incrementAndGet();
                }));
            }
            for (Future future : arrayList) {
                long l2 = 60000L - (System.currentTimeMillis() - l);
                if (l2 <= 0L) break;
                try {
                    future.get(l2, TimeUnit.MILLISECONDS);
                }
                catch (Throwable throwable) {}
            }
            executorService.shutdownNow();
        }
        catch (Throwable throwable) {
            try {
                System.out.println("[Flow2] prefetch stopped: " + throwable);
                executorService.shutdownNow();
            }
            catch (Throwable throwable2) {
                executorService.shutdownNow();
                ezb = true;
                System.out.println("[Flow2] assets ready " + LoadProgress.progress() + " in " + (System.currentTimeMillis() - l) + " ms");
                throw throwable2;
            }
            ezb = true;
            System.out.println("[Flow2] assets ready " + LoadProgress.progress() + " in " + (System.currentTimeMillis() - l) + " ms");
        }
        ezb = true;
        System.out.println("[Flow2] assets ready " + LoadProgress.progress() + " in " + (System.currentTimeMillis() - l) + " ms");
    }

    private static Set<String> ezg(long l) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        try {
            JsonObject jsonObject = LoadProgress.ezh("cosmetics/index.json");
            if (jsonObject == null || !jsonObject.has("items")) {
                return linkedHashSet;
            }
            linkedHashSet.add("cosmetics/index.json");
            for (JsonElement jsonElement : jsonObject.getAsJsonArray("items")) {
                if (System.currentTimeMillis() - l <= 30000L) {
                    String string = jsonElement.getAsString();
                    linkedHashSet.add("cosmetics/" + string + ".json");
                    linkedHashSet.add("cosmetics/thumbs/" + string + ".png");
                    JsonObject jsonObject2 = LoadProgress.ezh("cosmetics/" + string + ".json");
                    if (jsonObject2 == null) continue;
                    LoadProgress.ezi((JsonElement)jsonObject2, linkedHashSet);
                    if (!jsonObject2.has("video") || !jsonObject2.get("video").isJsonObject() || !jsonObject2.getAsJsonObject("video").has("name")) continue;
                    String string2 = jsonObject2.getAsJsonObject("video").get("name").getAsString();
                    linkedHashSet.add("video/" + string2 + ".jpg");
                    linkedHashSet.add("video/" + string2 + ".mp4");
                    continue;
                }
                break;
            }
        }
        catch (Throwable throwable) {
            System.out.println("[Flow2] cosmetics list unavailable: " + throwable);
        }
        return linkedHashSet;
    }

    private static JsonObject ezh(String string) {
        try {
            return JsonParser.parseString((String)new String(AssetStore.bytes(string), StandardCharsets.UTF_8)).getAsJsonObject();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static void ezi(JsonElement jsonElement, Set<String> set) {
        String string;
        String string2;
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        if (jsonElement.isJsonObject()) {
            for (Map.Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                LoadProgress.ezi((JsonElement)entry.getValue(), set);
            }
        } else if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement jsonElement2 : jsonArray) {
                LoadProgress.ezi(jsonElement2, set);
            }
        } else if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString() && ((string2 = (string = jsonElement.getAsString().trim()).toLowerCase(Locale.ROOT)).endsWith(".png") || string2.endsWith(".jpg") || string2.endsWith(".mp4") || string2.endsWith(".ogg") || string2.endsWith(".json") || string2.endsWith(".webm"))) {
            while (string.startsWith("/")) {
                string = string.substring(1);
            }
            if (string.startsWith("flow/")) {
                string = string.substring(5);
            }
            set.add(string.startsWith("cosmetics/") ? string : "cosmetics/" + string);
        }
    }

    static {
        ezc = new AtomicInteger();
    }

    private static /* synthetic */ int mm(int n, int n2) {
        return (n ^ n2) + 2133302440;
    }

    private static /* synthetic */ int mn(int n, int n2) {
        return n - n2 | 0x9D524606;
    }
}

