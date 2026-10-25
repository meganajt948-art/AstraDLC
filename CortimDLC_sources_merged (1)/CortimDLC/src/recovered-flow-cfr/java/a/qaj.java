/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.text.Text
 */
package a;

import a.pfl;
import a.qag;
import a.vxl;
import flow.dev.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public final class qaj {
    private static final Item[] qak = new Item[]{Items.field_8725, Items.field_8759, Items.field_8713, Items.field_8620};
    private static final long qal = 6000L;
    private static final long qam = 4000L;
    private static final long qan = 12000L;
    private static final long qao = 1300L;
    private final Map<Item, Long> qap = new HashMap<Item, Long>();
    private final Map<Item, String> qaq = new HashMap<Item, String>();
    private qag qar = qag.IDLE;
    private long qas;
    private long qat;
    private int qau;
    private boolean qav;
    private String qaw = "";
    private static /* synthetic */ int qax;
    private static /* synthetic */ String qay;

    public boolean active() {
        return this.qar != qag.IDLE && this.qar != qag.DONE;
    }

    public boolean ok() {
        return this.qav;
    }

    public String result() {
        return this.qaw;
    }

    public void begin(MinecraftClient minecraftClient, String string, long l) {
        this.qap.clear();
        this.qaq.clear();
        this.qau = 0;
        this.qav = false;
        this.qaw = "";
        this.qas = l;
        String string2 = string.trim();
        if (string2.startsWith(a.d("\u3276", -2117650585, 1868367167))) {
            string2 = string2.substring(1);
        }
        if (minecraftClient.field_1724 != null && minecraftClient.field_1755 instanceof HandledScreen) {
            minecraftClient.field_1724.method_7346();
        }
        if (string2.isEmpty() || minecraftClient.method_1562() == null) {
            this.qbb(minecraftClient, false, a.b("\u2b42\u52fb\ud85f\u424c\ucd81\u4b34\uf165\u7898\ue6ca\u6c72\uebde\u15c4\u9f72\u06b8\u8c92\u0a1f\ub026\u3f86\ua537\u236c", -799527061));
            return;
        }
        minecraftClient.method_1562().method_45730(string2);
        this.qba(qag.MENU, l);
    }

    public void cancel(MinecraftClient minecraftClient) {
        if (this.active() && minecraftClient.field_1724 != null && minecraftClient.field_1755 instanceof HandledScreen) {
            minecraftClient.field_1724.method_7346();
        }
        this.qar = qag.IDLE;
    }

    public boolean tick(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, long l) {
        HandledScreen handledScreen;
        if (!this.active()) {
            return true;
        }
        if (l - this.qas > 12000L) {
            this.qbb(minecraftClient, false, a.b("\u1f04\u66ce\uec64\u7269\uf9c8\u7f08\uc559\u48b2\ud2f0\u5849\udb8f\u25e0\uab4b\u328a\ub8de\u3e58\u846d\u0bbf\u9517\u1754\u9eaf\ue4f2\u6a33\uf197\u77e1\ufd43", 1952127839));
            return true;
        }
        Screen screen = minecraftClient.field_1755;
        HandledScreen handledScreen2 = screen instanceof HandledScreen && vxl.isStorage((Screen)(handledScreen = (HandledScreen)screen)) ? handledScreen : null;
        switch (this.qar.ordinal()) {
            case 1: {
                if (handledScreen2 == null) {
                    if (l - this.qat > 6000L) {
                        this.qbb(minecraftClient, false, a.c(748480639, "\ue842\u91be\u1b7a\u8507\u0ecc\u886a\u326b\ubf87\u21d0\uaf74\u2cb9\ud6b4\u581b\uc1d0\u4b88\ucd09\u773c\uf8e3"));
                    }
                    return !this.active();
                }
                handledScreen = handledScreen2.method_17577();
                if (qaj.qbc((ScreenHandler)handledScreen, clientPlayerEntity) > 0) {
                    this.qba(qag.TOGGLE, l);
                    return false;
                }
                screen = qaj.qbe((ScreenHandler)handledScreen, clientPlayerEntity);
                if (screen == null) {
                    if (l - this.qat > 6000L) {
                        this.qbb(minecraftClient, false, a.d("\u527a\u2bc3\ua167\u3b74\ub4c3\u3202\u8856\u01a4\u9ffa\u1545\u929d\u6cfc\ue2a0\u7f92\uf5d9\u735d\uc915\u46d7\udc75\u5edf\ud7b3\ua9f0\u2351\ub88f\u3ebd\ub47b\u0dc4\u8389\u1969", -226063115, -344991057));
                    }
                    return !this.active();
                }
                vxl.click(minecraftClient, (ScreenHandler)handledScreen, screen.field_7874, 0, SlotActionType.field_7790);
                ++this.qau;
                this.qba(qag.SECTION, l);
                break;
            }
            case 2: {
                if (handledScreen2 != null && qaj.qbc(handledScreen2.method_17577(), clientPlayerEntity) > 0) {
                    this.qba(qag.TOGGLE, l);
                    return this.qaz(minecraftClient, clientPlayerEntity, handledScreen2, l);
                }
                if (l - this.qat <= 4000L) break;
                if (handledScreen2 != null && this.qau < 2) {
                    this.qba(qag.MENU, l);
                    break;
                }
                this.qbb(minecraftClient, false, a.c(-87497882, "\ue73d\u9efc\u1428\u8a5a\u018c\u8733\u397b\ub001\u2add\ua074\u27d2\udda4\u5360\ucac0\u4468\uc202\u7c50\uf389\u6d2f\uef60\u66eb\u1cc2\u920b\u09d1\u8fde\u0575\ubcc8"));
                break;
            }
            case 3: {
                if (handledScreen2 == null) {
                    this.qbb(minecraftClient, false, a.d("\ub968\uc0d0\u4a0b\ud409\u5bb0\ud960\u6348\ueac0\u74e3\ufe24\u7986\u83f5\u0d28\u9089\u1ecd\u983b\u227e\uadd5\u376d\ub14c\u38be\u4290\ucc2e", -1858643312, 1644881875));
                    return true;
                }
                return this.qaz(minecraftClient, clientPlayerEntity, handledScreen2, l);
            }
        }
        return !this.active();
    }

    private boolean qaz(MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, HandledScreen<?> handledScreen, long l) {
        ScreenHandler screenHandler = handledScreen.method_17577();
        int n = 0;
        int n2 = 0;
        for (Item item : qak) {
            boolean bl;
            Slot slot = qaj.qbd(screenHandler, clientPlayerEntity, item);
            if (slot == null) continue;
            ++n2;
            String string = qaj.loreLine(slot.method_7677());
            if (qaj.enabled(string)) {
                ++n;
                continue;
            }
            Long l2 = this.qap.get(item);
            boolean bl2 = bl = l2 != null && !string.equals(this.qaq.get(item));
            if (l2 != null && !bl && l - l2 <= 1300L) continue;
            vxl.click(minecraftClient, screenHandler, slot.field_7874, 0, SlotActionType.field_7795);
            this.qap.put(item, l);
            this.qaq.put(item, string);
        }
        if (n2 > 0 && n == n2 && (n2 == qak.length || l - this.qat > 1500L)) {
            this.qbb(minecraftClient, true, n + a.b("\u196e\u64c7\uee1b\u747d", 1976703306) + qak.length + a.c(1910294584, "\uc817\ub5bb\u3f65\ua504\u2ac3\uac70\u1653\u9fde\u0592\u8b4f\u0ce7\uf6ef\u7844\ue1f0\u6bac"));
            return true;
        }
        return false;
    }

    private void qba(qag qag2, long l) {
        this.qar = qag2;
        this.qat = l;
    }

    private void qbb(MinecraftClient minecraftClient, boolean bl, String string) {
        this.qav = bl;
        this.qaw = string;
        this.qar = qag.DONE;
        if (minecraftClient.field_1724 != null && minecraftClient.field_1755 instanceof HandledScreen) {
            minecraftClient.field_1724.method_7346();
        }
    }

    private static int qbc(ScreenHandler screenHandler, ClientPlayerEntity clientPlayerEntity) {
        int n = 0;
        for (Item item : qak) {
            if (qaj.qbd(screenHandler, clientPlayerEntity, item) == null) continue;
            ++n;
        }
        return n;
    }

    private static Slot qbd(ScreenHandler screenHandler, ClientPlayerEntity clientPlayerEntity, Item item) {
        for (Slot slot : vxl.own(screenHandler, clientPlayerEntity.method_31548())) {
            ItemStack itemStack = slot.method_7677();
            if (!itemStack.method_31574(item) || !qaj.loreLine(itemStack).contains(a.d("\u9bc1\ue20b\u68a1\uf6ac\u7d7e", 960845424, -1930769931))) continue;
            return slot;
        }
        return null;
    }

    private static Slot qbe(ScreenHandler screenHandler, ClientPlayerEntity clientPlayerEntity) {
        Slot slot = null;
        for (Slot slot2 : vxl.own(screenHandler, clientPlayerEntity.method_31548())) {
            ItemStack itemStack = slot2.method_7677();
            if (itemStack.method_7960()) continue;
            String string = pfl.title(itemStack.method_7964().getString());
            if (string.contains(a.c(-16408195, "\ua531\udcf8\u565e\uc828"))) {
                return slot2;
            }
            if (slot != null || !itemStack.method_31574(Items.field_8759)) continue;
            slot = slot2;
        }
        return slot;
    }

    static String loreLine(ItemStack itemStack) {
        LoreComponent loreComponent = (LoreComponent)itemStack.method_58694(DataComponentTypes.field_49632);
        if (loreComponent == null) {
            return "";
        }
        List list = loreComponent.comp_2400();
        for (Text text : list) {
            String string = pfl.title(text.getString());
            if (!string.contains(a.d("\uf7a5\u8e6f\u04c5\u9ac8\u111a", -441072656, 1379348497))) continue;
            return string;
        }
        return "";
    }

    static boolean enabled(String string) {
        return string.contains(a.c(-1180267091, "\u8998\uf021\u7af3\ue4f7\u6f29\ue9ea\u53b1")) && !string.contains(a.b("\u093c\u70f4\ufa56\u6426\uef84\u693c", -1867117304));
    }

    private static /* synthetic */ int bqo(int n, int n2) {
        return (n ^ n2) + 1965590547;
    }
}

