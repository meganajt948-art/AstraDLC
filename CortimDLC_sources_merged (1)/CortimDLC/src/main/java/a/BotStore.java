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

import a.Bot;
import a.ejs;
import a.ejz;
import a.CloudSync;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.StringDecryptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

final class BotStore {
    private static final byte[] ekf = "flow2-bots".getBytes(StandardCharsets.UTF_8);
    private static /* synthetic */ String ekg;
    private static /* synthetic */ long ekh;

    private BotStore() {
    }

    private static byte[] eki(byte[] byArray) {
        byte[] byArray2 = new byte[byArray.length];
        for (int i = 0; i < byArray.length; ++i) {
            byArray2[i] = (byte)(byArray[i] ^ ekf[i % ekf.length] ^ i * 31);
        }
        return byArray2;
    }

    static ejz load() {
        ArrayList<ejs> arrayList = new ArrayList<ejs>();
        int n = 0;
        try {
            String string = CloudSync.get("bots");
            if (string == null || string.isBlank()) {
                return new ejz(0, arrayList);
            }
            byte[] byArray = Base64.getDecoder().decode(string.trim());
            String string2 = new String(BotStore.eki(byArray), StandardCharsets.UTF_8);
            JsonElement jsonElement = JsonParser.parseString((String)string2);
            if (!jsonElement.isJsonObject()) {
                return new ejz(0, arrayList);
            }
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("v")) {
                n = jsonObject.get("v").getAsInt();
            }
            if (jsonObject.has("b") && jsonObject.get("b").isJsonArray()) {
                for (JsonElement jsonElement2 : jsonObject.getAsJsonArray("b")) {
                    JsonObject jsonObject2;
                    if (!jsonElement2.isJsonObject() || !(jsonObject2 = jsonElement2.getAsJsonObject()).has("n") || !jsonObject2.has("a")) continue;
                    String string3 = jsonObject2.has("p") ? jsonObject2.get("p").getAsString() : null;
                    boolean bl = !jsonObject2.has("r") || jsonObject2.get("r").getAsBoolean();
                    arrayList.add(new ejs(jsonObject2.get("n").getAsString(), jsonObject2.get("a").getAsString(), string3, bl));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return new ejz(n, arrayList);
    }

    static void save(List<Bot> list, int n) {
        try {
            JsonArray jsonArray = new JsonArray();
            for (Bot object2 : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("n", object2.getName());
                jsonObject.addProperty("a", object2.getAddress());
                String string = object2.loginPassword();
                if (string != null) {
                    jsonObject.addProperty("p", string);
                }
                jsonObject.addProperty("r", Boolean.valueOf(object2.isAutoReconnect()));
                jsonArray.add((JsonElement)jsonObject);
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("v", (Number)n);
            jsonObject.add("b", (JsonElement)jsonArray);
            byte[] byArray = BotStore.eki(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
            CloudSync.put("bots", Base64.getEncoder().encodeToString(byArray));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static /* synthetic */ int fs(int n, int n2) {
        return n + n2 ^ 0x404B7F7B;
    }

    private static /* synthetic */ int ft(int n, int n2) {
        return BotStore.fs(n, n2) ^ 0xEEBBCF62;
    }
}

