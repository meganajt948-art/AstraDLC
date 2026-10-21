/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1320
 *  net.minecraft.class_1802
 *  net.minecraft.class_1887
 *  net.minecraft.class_1893
 *  net.minecraft.class_5134
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 */
package a;

import a.CloudSync;
import a.CustomItemInfo;
import a.phj;
import a.ItemRule;
import a.ModifierFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import flow.dev.StringDecryptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1320;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_1893;
import net.minecraft.class_5134;
import net.minecraft.class_5321;
import net.minecraft.class_6880;

public final class CollectorState {
    private static final Gson pek = new GsonBuilder().setPrettyPrinting().create();
    private static List<CustomItemInfo> pel;
    private static int pem;
    private static /* synthetic */ long pen;
    private static /* synthetic */ int peo;

    private CollectorState() {
    }

    public static List<CustomItemInfo> items() {
        if (pel == null) {
            ArrayList<CustomItemInfo> arrayList = new ArrayList<CustomItemInfo>();
            for (CustomItemInfo pdr2 : CollectorState.pex()) {
                arrayList.add(pdr2.init());
            }
            pel = Collections.unmodifiableList(arrayList);
            CollectorState.peq();
        }
        return pel;
    }

    public static int version() {
        return pem;
    }

    public static int activeCount() {
        int n = 0;
        for (CustomItemInfo pdr2 : CollectorState.items()) {
            if (!pdr2.active()) continue;
            ++n;
        }
        return n;
    }

    public static void changed() {
        ++pem;
        CloudSync.put("collector", pek.toJson((JsonElement)CollectorState.pep()));
    }

    public static void resetAll() {
        for (CustomItemInfo pdr2 : CollectorState.items()) {
            pdr2.reset();
        }
        CollectorState.changed();
    }

    private static JsonObject pep() {
        JsonObject jsonObject = new JsonObject();
        for (CustomItemInfo pdr2 : pel) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("active", Boolean.valueOf(pdr2.active()));
            jsonObject2.addProperty("count", (Number)pdr2.count());
            JsonObject jsonObject3 = new JsonObject();
            for (ItemRule phm2 : pdr2.rules()) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("state", phm2.state().name());
                jsonObject4.addProperty("level", (Number)phm2.level());
                jsonObject3.add(phm2.key(), (JsonElement)jsonObject4);
            }
            jsonObject2.add("rules", (JsonElement)jsonObject3);
            jsonObject.add(pdr2.name(), (JsonElement)jsonObject2);
        }
        return jsonObject;
    }

    private static void peq() {
        String string = CloudSync.get("collector");
        if (string == null || string.isBlank()) {
            return;
        }
        try {
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            for (CustomItemInfo pdr2 : pel) {
                JsonObject jsonObject2;
                JsonElement jsonElement = jsonObject.get(pdr2.name());
                if (jsonElement == null || !jsonElement.isJsonObject()) continue;
                JsonObject jsonObject3 = jsonElement.getAsJsonObject();
                if (jsonObject3.has("active")) {
                    pdr2.setActive(jsonObject3.get("active").getAsBoolean());
                }
                if (jsonObject3.has("count")) {
                    pdr2.setCount(jsonObject3.get("count").getAsInt());
                }
                JsonObject jsonObject4 = jsonObject2 = jsonObject3.has("rules") && jsonObject3.get("rules").isJsonObject() ? jsonObject3.getAsJsonObject("rules") : null;
                if (jsonObject2 == null) continue;
                for (ItemRule phm2 : pdr2.rules()) {
                    JsonElement jsonElement2 = jsonObject2.get(phm2.key());
                    if (jsonElement2 == null || !jsonElement2.isJsonObject()) continue;
                    JsonObject jsonObject5 = jsonElement2.getAsJsonObject();
                    for (Map.Entry entry : jsonObject5.entrySet()) {
                        if (((String)entry.getKey()).equals("state")) {
                            try {
                                phm2.setState(phj.valueOf(((JsonElement)entry.getValue()).getAsString()));
                            }
                            catch (IllegalArgumentException illegalArgumentException) {}
                            continue;
                        }
                        if (!((String)entry.getKey()).equals("level")) continue;
                        phm2.setLevel(((JsonElement)entry.getValue()).getAsInt());
                    }
                }
            }
        }
        catch (Exception exception) {
            System.out.println("can't read collector list: " + exception);
        }
    }

    private static ItemRule[] per(ItemRule ... phmArray) {
        ItemRule[] phmArray2 = new ItemRule[phmArray.length + 4];
        System.arraycopy(phmArray, 0, phmArray2, 0, phmArray.length);
        phmArray2[phmArray.length] = ItemRule.denyEnchant((class_5321<class_1887>)class_1893.field_9097);
        phmArray2[phmArray.length + 1] = ItemRule.denyEnchant((class_5321<class_1887>)class_1893.field_9121);
        phmArray2[phmArray.length + 2] = ItemRule.denyEnchant((class_5321<class_1887>)class_1893.field_9113);
        phmArray2[phmArray.length + 3] = ItemRule.denyEnchant((class_5321<class_1887>)class_1893.field_9109);
        return phmArray2;
    }

    private static ItemRule[] pes(ItemRule ... phmArray) {
        ItemRule[] phmArray2 = new ItemRule[phmArray.length + 2];
        System.arraycopy(phmArray, 0, phmArray2, 0, phmArray.length);
        phmArray2[phmArray.length] = ItemRule.denyLore("Попрыгун");
        phmArray2[phmArray.length + 1] = ItemRule.denyLore("Нестабильный ");
        return phmArray2;
    }

    private static ItemRule[] pet(ItemRule[] phmArray, ItemRule[] phmArray2) {
        ItemRule[] phmArray3 = new ItemRule[phmArray.length + phmArray2.length];
        System.arraycopy(phmArray, 0, phmArray3, 0, phmArray.length);
        System.arraycopy(phmArray2, 0, phmArray3, phmArray.length, phmArray2.length);
        return phmArray3;
    }

    private static ItemRule peu(class_5321<class_1887> class_53212, int n) {
        return ItemRule.enchant(class_53212, n);
    }

    private static ItemRule pev(String string, int n) {
        return ItemRule.lore(string, n, true);
    }

    private static ItemRule pew(String string) {
        return ItemRule.lore(string, 0, true);
    }

    private static List<CustomItemInfo> pex() {
        return List.of(CustomItemInfo.of(class_1802.field_22022, 1, "Незеритовый меч").deep().rules(CollectorState.pet(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9118, 7), CollectorState.peu((class_5321<class_1887>)class_1893.field_9124, 2)), CollectorState.pes(CollectorState.pev("Яд", 3), CollectorState.pev("Вампиризм", 2), CollectorState.pev("Окисление", 2), ItemRule.lore("Опытный", 3, false), CollectorState.pev("Детекция", 3)))), CustomItemInfo.of(class_1802.field_49814, 1, "Булава").deep().rules(CollectorState.pet(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9118, 7), CollectorState.peu((class_5321<class_1887>)class_1893.field_50158, 3), CollectorState.peu((class_5321<class_1887>)class_1893.field_50157, 5)), CollectorState.pes(new ItemRule[0]))), CustomItemInfo.of(class_1802.field_8547, 1, "Трезубец").deep().rules(CollectorState.pes(CollectorState.pev("Ступор", 3), CollectorState.pev("Притяжение", 2), CollectorState.pev("Скаут", 3), CollectorState.pew("Возвращение"), CollectorState.pew("Подрывник"))), CustomItemInfo.of(class_1802.field_22027, 1, "Незеритовый шлем").deep().rules(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9111, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9119, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9127, 3), CollectorState.peu((class_5321<class_1887>)class_1893.field_9101, 1))), CustomItemInfo.of(class_1802.field_22028, 1, "Незеритовый нагрудник").deep().rules(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9111, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9119, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9101, 1))), CustomItemInfo.of(class_1802.field_22029, 1, "Незеритовые поножи").deep().rules(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9111, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9119, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9101, 1))), CustomItemInfo.of(class_1802.field_22030, 1, "Незеритовые ботинки").deep().rules(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9111, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9119, 5), CollectorState.peu((class_5321<class_1887>)class_1893.field_9128, 3), CollectorState.peu((class_5321<class_1887>)class_1893.field_9101, 1))), CustomItemInfo.of(class_1802.field_22021, 8, "Трапка").rules(CollectorState.pes(CollectorState.pew("Каст: Нерушимая клетка"))), CustomItemInfo.of(class_1802.field_8479, 12, "Явная пыль").rules(CollectorState.pes(CollectorState.pew("Каст: Световая вспышка"))), CustomItemInfo.of(class_1802.field_8614, 4, "Божья аура").rules(CollectorState.pes(CollectorState.pew("Каст: Божественная аура"))), CustomItemInfo.of(class_1802.field_8449, 16, "Дезориентация").rules(CollectorState.pes(CollectorState.pew("Каст: Звуковая волна"))), CustomItemInfo.of(class_1802.field_49098, 32, "Заряд ветра"), CustomItemInfo.of(class_1802.field_8551, 16, "Пласт").rules(CollectorState.pes(CollectorState.pew("Каст: Нерушимая стена"))), CustomItemInfo.of(class_1802.field_8543, 4, "Снежок заморозка").rules(CollectorState.pes(CollectorState.pew("Каст: Ледяная сфера"))), CustomItemInfo.of(class_1802.field_8288, 1, "Тотем бессмертия"), CustomItemInfo.of(class_1802.field_8399, 1, "Арбалет").rules(CollectorState.per(CollectorState.peu((class_5321<class_1887>)class_1893.field_9098, 3), CollectorState.peu((class_5321<class_1887>)class_1893.field_9101, 1), CollectorState.peu((class_5321<class_1887>)class_1893.field_9108, 1))), CustomItemInfo.of(class_1802.field_8463, 16, "Золотое яблоко"), CustomItemInfo.of(class_1802.field_8367, 8, "Зачарованное золотое яб"), CustomItemInfo.of(class_1802.field_8071, 64, "Золотая морковь"), CustomItemInfo.of(class_1802.field_8233, 64, "Хорус"), CustomItemInfo.of(class_1802.field_8833, 1, "Элитры"), CustomItemInfo.of(class_1802.field_8639, 64, "Фейерверк"), CustomItemInfo.of(class_1802.field_8436, 1, "Хлопушка").color(0xFF0000).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5909, 10, 200), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5904, 5, 300), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5919, 10, 100), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5912, 1, 3600)), CustomItemInfo.of(class_1802.field_8436, 1, "Святая вода").color(0xFFFFFF).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5924, 2, 900), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5905, 2, 12000), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5915, 2, 0)), CustomItemInfo.of(class_1802.field_8436, 1, "Зелье Гнева").deep().color(0x993333).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5910, 5, 600), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5909, 4, 600)), CustomItemInfo.of(class_1802.field_8436, 1, "Зелье Палладина").color(65535).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5907, 1, 12000), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5918, 1, 12000), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5914, 3, 1200), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5905, 1, 18000)), CustomItemInfo.of(class_1802.field_8436, 1, "Зелье Ассасина").color(0x333333).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5910, 4, 1200), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5904, 3, 6000), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5917, 1, 1200), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5921, 2, 0)), CustomItemInfo.of(class_1802.field_8436, 1, "Зелье Радиации").color(3329330).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5899, 2, 300), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5920, 2, 300), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5909, 3, 300), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5903, 5, 300), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5912, 1, 300)), CustomItemInfo.of(class_1802.field_8436, 1, "Снотворное").color(0x484848).effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5911, 2, 1800), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5901, 2, 200), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5920, 3, 1800), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5919, 1, 200)), CustomItemInfo.of(class_1802.field_8574, 1, "Зелье").query("силка").effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5910, 3, 3600), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5904, 3, 3600)), CustomItemInfo.of(class_1802.field_8574, 1, "Зелье регенерации").query("исцел").effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5915, 2, 0), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5924, 1, 900)), CustomItemInfo.of(class_1802.field_8087, 32, "Кровавая стрела").effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5911, 3, 60), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5919, 1, 40), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5901, 1, 40), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5916, 1, 100)), CustomItemInfo.of(class_1802.field_8087, 64, "Стрела обледенения").off().effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5909, 10, 100), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5901, 3, 40)), CustomItemInfo.of(class_1802.field_8087, 64, "Мучительная стрела").off().effects(ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5909, 3, 100), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5920, 3, 100), ModifierFactory.effect((class_6880<class_1291>)class_1294.field_5899, 3, 100)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Крушителя").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 4.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 3.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23725, 2.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 2.0)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Раздора").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 4.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 2.0), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23719, 0.10000001817743467), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23723, 0.10000001817743467), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, -3.0)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Тирана").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 2.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 2.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, -4.0)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Ярости").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 5.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, -4.0)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Вихря").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 2.0), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23719, 0.1500000347540806), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23723, 0.1500000347540806)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Мрака").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 1.5), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 1.5)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Демона").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 2.5), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23723, 0.10000001817743467)), CustomItemInfo.of(class_1802.field_8288, 1, "Талисман Карателя").off().deep().attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 7.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, -4.0), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23719, 0.10000001817743467)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Хаоса").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODY0MTkwMCwKICAicHJvZmlsZUlkIiA6ICIxNzRjZmRiNGEzY2I0M2I1YmZjZGU0MjRjM2JiMmM2ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJtYXJhZWwxOCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lN2E3YWU3Y2RjZjYxNmU4YjdhNDIyMWE2MjFiMjQzNTc1M2M2MGVkNmEyNThlYTA2MGRhZTMwMDJmZmU5ZTI4IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, -4.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 1.5), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 2.5), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23719, 0.07000004566537438), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23723, 0.13000000024761527), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_49078, 0.09000001839414021)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Сатира").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODYwODUyOCwKICAicHJvZmlsZUlkIiA6ICJkMTQ4NjFiM2UwZmM0Njk5OTFlMTcyNTllMzdiZjZhZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJyYXhpdG9jbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83NzFhOWE0OThiNGZhNWVjNDkzNjJmOWJjODhlZGE0ZjUyYjA0ZGU0OWQ3NWFhM2NhMzMyYTFmZWExYWEwZTU3IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 2.0), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23728, -0.10000000768432185), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23723, 0.1500000347540806)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Бестии").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM0MzgzNDkzMCwKICAicHJvZmlsZUlkIiA6ICI1MzUzNWIxN2M0ZDY0NWQ0YWUwY2U2ZjM4Zjk0NTFjYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJVYml2aXMiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQxMWFjMTczODFiOWZjZTliYWIzYzcyYWZkYjdmMTk4NTcwZGFmNDczMmJkODExZDMxYzIyN2Q4MGZhMzliMSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 1.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 4.0), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23719, 0.10000001817743467), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23723, 0.10000001817743467)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Ареса").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM0Mzc3NDI1NSwKICAicHJvZmlsZUlkIiA6ICJhYWMxYjA2OWNkMjE0NWE2ODNlNzQxNzE4MDcxMGU4MiIsCiAgInByb2ZpbGVOYW1lIiA6ICJqdXNhbXUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzE2YWRjNmJhZmNiNTdmZDcwN2RlZTdkZDZhNzM2ZmUxMjY3MTFkNTNhMWZkNmNlNzg5ZGE0MWIzYmUxM2YyYSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 6.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, -2.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, -2.0)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Гидры").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODUzMjE4MywKICAicHJvZmlsZUlkIiA6ICI1OGZmZWI5NTMxNGQ0ODcwYTQwYjVjYjQyZDRlYTU5OCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTa2luREJuZXQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UzYzExOGQ2OTZkOTEwZTU0ZGUwMmNhNGQ4MDc1NDNmOWIxOGMwMDhjOTgzOGQyZmY2OTM3NzYyMmZiMWQzMiIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 4.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 2.0), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_51576, 0.5), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_51583, 0.5)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Икара").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODU4MjQ5MSwKICAicHJvZmlsZUlkIiA6ICJhZWNkODIxZTQyYzE0ZDJlOThmNTA1OTg1MWI5OWMzNyIsCiAgInByb2ZpbGVOYW1lIiA6ICJSb2RyaVgyMDc1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2M2ODAzZTZkNTY2N2EyZDYxMDYyOGJjM2IzMmY4NjNjZGE0OTVjNDY1NjE2ZGU2NTVjYjMyOTkzM2I2MWFmNzciLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23721, 2.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 2.0)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Эрида").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM0Mzg2MTE4NywKICAicHJvZmlsZUlkIiA6ICJlZGUyYzdhMGFjNjM0MTNiYjA5ZDNmMGJlZTllYzhlYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJ0aGVEZXZKYWRlIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzZlNGUyZjEwNDdmM2VjNmU5ZTQ1OTE4NDczOWUzM2I3YzFmYzYzYWQ4MjAyYmRhYjlmMDI0NTA4YWRkMjNlNWIiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23726, 1.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23716, 2.0), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_47758, 1.0)), CustomItemInfo.of(class_1802.field_8575, 1, "Сфера Титана").off().deep().skin("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM1NDQ1NTE5MiwKICAicHJvZmlsZUlkIiA6ICJkOTcwYzEzZTM4YWI0NzlhOTY1OGM1ZDQ1MjZkMTM0YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJDcmltcHlMYWNlODUxMjciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODFlOTY5ODQ1OGI3ODQxYzk2YWU0ZjI0ZWM4NGFlMDE3MjQxMDA2NDFjNTY0ZTJhN2IxODVmNDA2ZThlZDIzIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=").attrs(ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23724, 2.5), ModifierFactory.flat((class_6880<class_1320>)class_5134.field_23725, 2.5), ModifierFactory.scaled((class_6880<class_1320>)class_5134.field_23719, -0.15000007945819008)));
    }

    private static /* synthetic */ int bhl(int n, int n2) {
        return n + n2 + 722371117;
    }
}

