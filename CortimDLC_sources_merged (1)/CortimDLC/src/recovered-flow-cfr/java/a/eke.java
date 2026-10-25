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

import a.dtv;
import a.ejs;
import a.ejz;
import a.ewk;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

final class eke {
    private static final byte[] ekf = a.b("\ue797\u9e2c\u14fc\u8a95\u0107\u87a9\u3db5\ub449\u2a0d\ua0bb", -1307187205).getBytes(StandardCharsets.UTF_8);
    private static /* synthetic */ String ekg;
    private static /* synthetic */ long ekh;

    private eke() {
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
            String string = ewk.get(a.c(-1460241541, "\u7b1d\u02a1\u8869\u161f"));
            if (string == null || string.isBlank()) {
                return new ejz(0, arrayList);
            }
            byte[] byArray = Base64.getDecoder().decode(string.trim());
            String string2 = new String(eke.eki(byArray), StandardCharsets.UTF_8);
            JsonElement jsonElement = JsonParser.parseString((String)string2);
            if (!jsonElement.isJsonObject()) {
                return new ejz(0, arrayList);
            }
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has(a.b("\u1f6a", 125837085))) {
                n = jsonObject.get(a.d("\ubd38", -1877114394, 769473705)).getAsInt();
            }
            if (jsonObject.has(a.d("\u15c0", -2099872564, 1619028335)) && jsonObject.get(a.d("\u5e1d", -783202492, -1145235142)).isJsonArray()) {
                for (JsonElement jsonElement2 : jsonObject.getAsJsonArray(a.c(-602604192, "\ufd03"))) {
                    JsonObject jsonObject2;
                    if (!jsonElement2.isJsonObject() || !(jsonObject2 = jsonElement2.getAsJsonObject()).has(a.c(663941316, "\uf0ab")) || !jsonObject2.has(a.b("\u1683", -1111877917))) continue;
                    String string3 = jsonObject2.has(a.c(-1840479440, "\u8341")) ? jsonObject2.get(a.c(367972735, "\ud10e")).getAsString() : null;
                    boolean bl = !jsonObject2.has(a.d("\udece", 98093091, 661526174)) || jsonObject2.get(a.b("\u9e7c", 932945423)).getAsBoolean();
                    arrayList.add(new ejs(jsonObject2.get(a.d("\ua7ba", 1826879479, 1947750434)).getAsString(), jsonObject2.get(a.b("\ucbc1", -1633104991)).getAsString(), string3, bl));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return new ejz(n, arrayList);
    }

    static void save(List<dtv> list, int n) {
        try {
            JsonArray jsonArray = new JsonArray();
            for (dtv object2 : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(a.b("\u1469", -2076306426), object2.getName());
                jsonObject.addProperty(a.d("\uf048", -1413176890, 198988270), object2.getAddress());
                String string = object2.loginPassword();
                if (string != null) {
                    jsonObject.addProperty(a.c(145779160, "\u69a9"), string);
                }
                jsonObject.addProperty(a.b("\u332d", -1717161122), Boolean.valueOf(object2.isAutoReconnect()));
                jsonArray.add((JsonElement)jsonObject);
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(a.c(-390160714, "\u9ec1"), (Number)n);
            jsonObject.add(a.c(1080072828, "\u9a1f"), (JsonElement)jsonArray);
            byte[] byArray = eke.eki(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
            ewk.put(a.c(-645095806, "\u9ee4\ue758\u6d90\uf3e6"), Base64.getEncoder().encodeToString(byArray));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static /* synthetic */ int fs(int n, int n2) {
        return n + n2 ^ 0x404B7F7B;
    }

    private static /* synthetic */ int ft(int n, int n2) {
        return eke.fs(n, n2) ^ 0xEEBBCF62;
    }
}

