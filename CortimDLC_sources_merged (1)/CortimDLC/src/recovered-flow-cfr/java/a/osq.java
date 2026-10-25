/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.EquippableComponent
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 */
package a;

import a.izx;
import a.kfa;
import a.kfe;
import a.oqv;
import a.vhz;
import a.vkl;
import a.vlq;
import a.vlv;
import a.vmc;
import a.vxl;
import a.vzz;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class osq
extends kfe {
    private static osq osr;
    private final vlq oss = this.add(new vlq(a.d("\u77f0\u0e6f\u84a0", -808112537, 232151519), 82));
    private final vlv ost = this.add(new vlv(a.b("\ub19b\uc817\u42d2\udca2\u5762", -1335053871), a.b("\uada3\ud43f\u5ee5\uc081", -1850429965), a.c(917678284, "\ua89c\ud100\u5bda\uc5be"), a.c(1141941567, "\ua575\udceb\u5634\uc84d"), a.c(-1297863666, "\u2c48\u55d5\udf1c\u4176\ucabb")));
    private final vkl osu = this.add(new vkl(a.b("\ud3f3\uaa6a\u20ae\ubeca\u351f\ub3eb\u09eb\u801d\u1e57\u94e4\u133f\ue956", 296539058), true));
    private final vmc osv = this.add(new vmc(a.b("\u6e26\u17b4\u9d72\u0303\u88d5", 1703177840), 3.0, 1.0, 8.0, 1.0).suffix(a.c(-1379208413, "\uf309\u8ae3-\u9e56\u1589")));
    private final vkl osw = this.add(new vkl(a.c(-973303991, "\u8f01\uf691\u7c59\ue235\u69ed\uef43"), true));
    private static final int osx = 600;
    private boolean osy;
    private boolean osz;
    private int ota = -1;
    private int otb;
    private static /* synthetic */ int otc;
    private static /* synthetic */ String otd;

    public osq() {
        super(a.d("\u0019\u7983\uf35d\u6d3a\ue6ea\u607c\uda13\u53ff\ucda6\u4706\uc0c2", -620719173, -1006398486), a.b("\u44ff\u3d72\ub7bc\u29cb\ua21b\u24f9\u9efe\u1713\u8941\u03b5\u8429\u7e47\uf085\u693f\ue322\u6590\udfd4\u5008\ucaad\u4cfb\uc558\ubf46\u31f4\uaa6b\u2c55\ua6c5\u1f3d\u9162\u0b89", -139311951), kfa.PLAYER);
        osr = this;
    }

    public static boolean busy() {
        return osr != null && osq.osr.osz;
    }

    @Override
    protected void onDisable() {
        this.osz = false;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        HandledScreen handledScreen;
        Screen screen;
        block10: {
            block9: {
                boolean bl;
                boolean bl2 = minecraftClient.currentScreen instanceof HandledScreen && vxl.isStorage(minecraftClient.currentScreen);
                boolean bl3 = bl = bl2 && this.oss.isBound() && vzz.isDown(minecraftClient, this.oss.get());
                if (bl && !this.osy && !this.osz && !oqv.busy()) {
                    this.ote(minecraftClient);
                }
                this.osy = bl;
                if (!this.osz) {
                    return;
                }
                screen = minecraftClient.currentScreen;
                if (!(screen instanceof HandledScreen)) break block9;
                handledScreen = (HandledScreen)screen;
                if (handledScreen.getScreenHandler().syncId == this.ota) break block10;
            }
            this.osz = false;
            return;
        }
        screen = handledScreen.getScreenHandler();
        List<Slot> list = vxl.own((ScreenHandler)screen, minecraftClient.player.getInventory());
        for (int i = 0; i < this.osv.getInt() && this.osz; ++i) {
            if (this.otb > 600) {
                this.otf(wap.s(a.d("\ud509\uac84\u264a\ub83d\u33f7\ub541\u0f1b\u86ad\u18a1\u9217\u15df\uefb1\u6166\uf8c2\u7290", -1688094631, 1760455948), a.d("\u5660\u2fce\ua563\u3b10\ub0bd\u3674\u8c59\u05a4\u9bf3\u1148\u928b\u6ce4\ue24c\u7bfe\uf1df\u7723\ucd6f\u42b2\ud808\u5e57\ud7a8\uadf4", -2093576034, 800047817)), false);
                return;
            }
            if (!screen.getCursorStack().isEmpty()) {
                Slot slot = osq.oth(list);
                if (slot == null) {
                    this.otf(wap.s(a.b("\ub5a7\ucc33\u46e1\ud8c4\u5347\ud5ea\u6fb4\ue600\u7816\uf2ba\u7578\u8f01\u019b\u9865\u1237\u9488\u2e93\ua15e\u3be0\ubdf4\u3440\u4e07\uc0b3\u5b63\udd00\u57cc\uee2d\u6038\ufac4\u7c8d\uf727", -240863768), a.b("\u403b\u3998\ub34f\u2d4b\ua6e4\u202f\u9a0b\u17ef\u8daf\u0761\u80c7\u7ab7\uf468\u6dd0\ue7f4\u6567\udb49\u50f9\uce50\u4878\uc18c\ubbdc\u3510\uaebf\u28b0", -1293335551)), false);
                    return;
                }
                this.otg(minecraftClient, (ScreenHandler)screen, slot);
                continue;
            }
            if (this.osu.get() && this.oti(minecraftClient, (ScreenHandler)screen, list) || this.otj(minecraftClient, (ScreenHandler)screen, list)) continue;
            this.otf(wap.s(a.d("\u6d7b\u14f6\u9e38O\u8b89\u0d39", -385113214, -18100564), a.c(-773539703, "\ubc9a\uc577\u4fa7\ud1a9\u5a00\udcb3\u669a\uef13\u7132\ufb8f\u7c5e\u8622\u08f6")) + a.d("\u3aea\u43cc\uc988", 555218415, -246034650) + this.otb + wap.s(a.b("\u545b\u2da9\ua775\u3901\ub2dc\u3465\u8e2e", -373140356), a.d("\u83cb\ufe60\u74b2\ueac0\u6115\ue7a0\u5dff", 1421585566, 223686514)), true);
        }
    }

    private void ote(MinecraftClient minecraftClient) {
        HandledScreen handledScreen = (HandledScreen)minecraftClient.currentScreen;
        if (!handledScreen.getScreenHandler().getCursorStack().isEmpty()) {
            if (this.osw.get()) {
                izx.alert(this.getName(), wap.s(a.d("\ucc29\ub5bd\u3f6f\ua14a\u2ac9\uac64\u163a\u9f8e\u0198\u8b34\u0cf6\uf68f\u7815\ue1eb\u6bb9\ued06\u571d\ud8d0\u426e\uc47a\u4dce\u3789\ub93d\u22ed\ua48e\u2e42\u97a3\u19b6\u834a\u0503\u8ea9\u7036\ufa3f\u63c1\ue589\u6f39\ud0e9", 2049591230, -731345950), a.d("\ucb33\ub29e\u3840\ua646\u2de6\uab5c\u1104\u9ce5\u06d9\u8c1a\u0bcd\uf1c9\u7f66\ue6ad\u6c89\uee6d\u503d\udf93\u4555\uc305\u4afa\u30a2\ube66\u21d5\ua3cb\u2d7b\u90d2\u1efa\u840e\u025e\u8992\u773d\ufd02", -619097225, -385115068)), vhz.INFO, false);
            }
            return;
        }
        this.osz = true;
        this.ota = handledScreen.getScreenHandler().syncId;
        this.otb = 0;
    }

    private void otf(String string, boolean bl) {
        this.osz = false;
        if (this.osw.get()) {
            izx.alert(this.getName(), string, bl ? vhz.CHECK : vhz.INFO, bl);
        }
    }

    private void otg(MinecraftClient minecraftClient, ScreenHandler screenHandler, Slot slot) {
        vxl.click(minecraftClient, screenHandler, slot.id, 0, SlotActionType.PICKUP);
        ++this.otb;
    }

    private static Slot oth(List<Slot> list) {
        for (Slot slot : list) {
            if (slot.hasStack()) continue;
            return slot;
        }
        return null;
    }

    private boolean oti(MinecraftClient minecraftClient, ScreenHandler screenHandler, List<Slot> list) {
        for (int i = 0; i < list.size(); ++i) {
            ItemStack itemStack = list.get(i).getStack();
            if (itemStack.isEmpty() || itemStack.getCount() >= itemStack.getMaxCount()) continue;
            for (int j = list.size() - 1; j > i; --j) {
                ItemStack itemStack2 = list.get(j).getStack();
                if (itemStack2.isEmpty() || itemStack2.getCount() >= itemStack2.getMaxCount() || !ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack, (ItemStack)itemStack2)) continue;
                this.otg(minecraftClient, screenHandler, list.get(j));
                this.otg(minecraftClient, screenHandler, list.get(i));
                if (!screenHandler.getCursorStack().isEmpty()) {
                    this.otg(minecraftClient, screenHandler, list.get(j));
                }
                return true;
            }
        }
        return false;
    }

    private boolean otj(MinecraftClient minecraftClient, ScreenHandler screenHandler, List<Slot> list) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (Slot slot : list) {
            if (!slot.hasStack()) continue;
            arrayList.add(slot.getStack());
        }
        arrayList.sort(this.otl());
        for (int i = 0; i < list.size(); ++i) {
            Slot slot;
            slot = i < arrayList.size() ? (ItemStack)arrayList.get(i) : ItemStack.EMPTY;
            ItemStack itemStack = list.get(i).getStack();
            if (osq.otk(itemStack, (ItemStack)slot)) continue;
            if (slot.isEmpty()) {
                return false;
            }
            for (int j = i + 1; j < list.size(); ++j) {
                if (!osq.otk(list.get(j).getStack(), (ItemStack)slot)) continue;
                this.otg(minecraftClient, screenHandler, list.get(j));
                this.otg(minecraftClient, screenHandler, list.get(i));
                if (!screenHandler.getCursorStack().isEmpty()) {
                    this.otg(minecraftClient, screenHandler, list.get(j));
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean otk(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack.isEmpty() || itemStack2.isEmpty()) {
            return itemStack.isEmpty() == itemStack2.isEmpty();
        }
        return itemStack.getCount() == itemStack2.getCount() && ItemStack.areItemsAndComponentsEqual((ItemStack)itemStack, (ItemStack)itemStack2);
    }

    /*
     * Exception decompiling
     */
    private Comparator<ItemStack> otl() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:404)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static int otm(ItemStack itemStack) {
        Item item = itemStack.getItem();
        String string = Registries.ITEM.getId((Object)item).getPath();
        if (string.endsWith(a.b("\u2071\u59ec\ud33b\u4d52\uc698\u403f", 1796415528)) || string.endsWith(a.c(1408812133, "\uc43e\ubdb1\u377b\ua917")) || item == Items.MACE || item == Items.TRIDENT || item == Items.BOW || item == Items.CROSSBOW || string.endsWith(a.b("\u516a\u28f7\ua227\u3c43\ub790\u3132", -700109))) {
            return 0;
        }
        if (string.endsWith(a.b("\u2eda\u5744\udd8e\u43f5\uc82a\u4e91\uf4db\u7d37", 1058877069)) || string.endsWith(a.c(1211581585, "\u44c9\u3d54\ub79c\u29ea\ua224\u2486\u9edc")) || string.endsWith(a.d("\ue3a0\u9a26\u10f2\u8e89", 1359669934, 59050325)) || item == Items.SHEARS || item == Items.FISHING_ROD || item == Items.FLINT_AND_STEEL || item == Items.BRUSH) {
            return 1;
        }
        EquippableComponent equippableComponent = (EquippableComponent)itemStack.get(DataComponentTypes.EQUIPPABLE);
        if (equippableComponent != null && equippableComponent.slot() != EquipmentSlot.MAINHAND && equippableComponent.slot() != EquipmentSlot.OFFHAND || item == Items.SHIELD || item == Items.TOTEM_OF_UNDYING) {
            return 2;
        }
        if (itemStack.contains(DataComponentTypes.FOOD)) {
            return 3;
        }
        if (itemStack.contains(DataComponentTypes.POTION_CONTENTS)) {
            return 4;
        }
        if (item instanceof BlockItem) {
            return 5;
        }
        return 6;
    }

    private static /* synthetic */ int lambda$comparator$1(ItemStack itemStack) {
        return Registries.ITEM.getRawId((Object)itemStack.getItem());
    }

    private static /* synthetic */ String lambda$comparator$0(ItemStack itemStack) {
        return itemStack.getName().getString().toLowerCase(Locale.ROOT);
    }

    private static /* synthetic */ int bes(int n, int n2) {
        return (n ^ n2) + 189364853;
    }
}

