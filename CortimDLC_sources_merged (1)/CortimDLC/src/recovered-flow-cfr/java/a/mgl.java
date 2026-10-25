/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.GenericContainerScreen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.ItemEnchantmentsComponent
 *  net.minecraft.component.type.LoreComponent
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.Registries
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  org.lwjgl.glfw.GLFW
 */
package a;

import a.izx;
import a.kfa;
import a.kfe;
import a.mgg;
import a.pdi;
import a.pfd;
import a.pfl;
import a.vhz;
import a.vkl;
import a.vlq;
import a.vmc;
import a.vxl;
import a.wap;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class mgl
extends kfe {
    private static final String[] mgm = mgl.mil(a.b("\uae39\ud78a\u5d27\uc35f\u48ff\uce37", -1699894658), a.d("\u2c08\u55b2\udf6c\u410b\ucadb", 1549428332, -1373943294), a.c(-501856924, "\u4155\u38e1\ub23d\u2c4b\ua794\u215a\u9b7b\u12fa\u8ca9"), a.d("Z\u79ec\uf327\u6d45\ue699\u6032\uda7a\u5396\ucdc2", 1940162698, 945326256), a.b("\u4bd5\u326b\ub8c1\u26cd\uad10", -1503834143), a.c(1333841394, "\ucd96\ub424\u3ee4\ua095\u2b55\uaded"), a.d("\uf61e\u8fb4\u057a\u9b12\u10c2\u967d\u2c39", 1879978402, -263665720), a.b("\u82d6\ufb1f\u71c7\uefb7\u646f\ue2ab", -1705212264));
    private static final String[] mgn = mgl.mil(a.d("\u20cc\u590e\ud3a4\u4da9\uc600\u40b7\ufae7", 73553294, -882282123), a.d("\udb51\ua2f4\u2831\ub657\u3d9d\ubb2a\u0178", 928332889, 1487988590), a.d("\u73b1\u0a0b\u80ae\u1edc\u950f", -1030424861, -908164841), a.c(-625441604, "\u84d7\ufd6a\u77aa\ue9c2\u621b\ue4bb"), a.c(341076834, "\u6f5a\u16ea\u9c49\u0248\u89ea\u0f20\ub576\u3c86\ua2d3"));
    private static final String[] mgo = mgl.mil(a.d("\u1f7e\u66ca\uec69\u7215\uf9c7\u7f75\uc525\u4ca5\ud286", -1531460758, -2086283176), a.b("\ufcd1\u856d\u0fb9\u91cf\u1a1c", -1611073303), a.b("\u584c\u21f0\uab29\u352d\ube8f\u383f", -1824695176), a.d("\u2e19\u57a5\udd7c\u4378\uc8be\u4e6a", -700579097, 2006198474), a.c(-236048234, "\u34ac\u4d1c\uc7c9\u59c1\ud26d"), a.d("\u4631\u3f83\ub552\u2b53\ua089\u263d\u9c10", 1052481280, -1937123977), a.b("\u2e9b\u5725\uddfa\u4388\uc853\u4ee8\uf4c1\u7d3e", 75377325), a.c(-89106608, "\u5363\u2ad8\ua079\u3e7f\ub5ae\u3312\u893f\u00b6\u9ee9"), a.c(-1864491677, "\u1951\u60e5\uea4f\u7444\uffed\u7920\uc37f\u4af8\ud4d9\u5e1f"), a.c(1898666972, "\u5fe8\u2655\uac87\u3289\ub920\u3fee"));
    private static final String[] mgp = mgl.mil(a.c(463964444, "\u8d25\uf4eb\u7e46\ue03d\u6bee\ued5d"), a.d("\ue991\u9059\u1a89\u848f\u0f57", 1141578203, 1656353911), a.b("\ub682\ucf4a\u459a\udbf8\u5044", 648655551), a.c(805961385, "\ufa9d\u8325\u09fd\u9788\u1c5e\u9ae1"), a.b("\u43bf\u3a71\ub0a1\u2ea2\ua57e\u23ca\u99e6\u101a", -1654044791), a.b("\ubb9f\uc238\u48e2\ud693\u5d4d\udbeb", -1393574934), a.d("\u8783\ufe2f\u74f4\uea9c\u6150\ue7f6", -1780167643, -2121970747));
    private static final String[] mgq = mgl.mil(a.d("\u7887\u0144\u8be2\u15e6\u9e33", -1804951348, -1844126711), a.c(2086678681, "\u34db\u4d1e\uc7c2"), a.d("\ua64f\udffa\u552c", -1459795198, 2059266418), a.c(-1412124009, "\ub6d3\ucf15\u45b7"), a.d("\u8ab4\uf30c", 364700285, -1524929281));
    private static final String[] mgr = mgl.mil(a.b("\ub369\ucad0\u4416\ude77\u55aa\ud363\u6931\ue0b3\u7ee7", -1201096867), a.b("\ufcc0\u850e\u0fa3\u91d8\u1a0b\u9cb7\u26e7", -841746184), a.b("\uf4fa\u8d4c\u079d\u99eb\u1249\u94f0\u2ede\ua727", 829026501), a.d("\uaa8a\ud33c\u59ed\uc79b\u4c39\uca80\u70ca\uf957", -817246295, 880042268));
    private static final String[] mgs = mgl.mil(a.b("\u2f36\u56fe\udc2e\u4228\uc9f0", 1934437131), a.d("\u2f7f\u56b7\udc67\u4205\uc9b9", -1590878761, -968345963));
    private static final String mgt = pfl.title(a.c(-78853994, "\ucca6\ub56e\u3fbe\ua1b8\u2a60\uacdb\u168d\u9f0b"));
    private static final int mgu = -16711936;
    private static final int mgv = -29696;
    private static final int mgw = -52429;
    private static final int mgx = -16711681;
    private static final int mgy = 75;
    private static final int mgz = 153;
    private static mgl mha;
    private final vlq mhb = this.add(new vlq(a.c(1364434846, "\u9b8f\ue21f\u68ca\uf6c2\u7d6e\uffc5\u4189\uc879\u5238\udc98\u5b42\ua136\u2fe8\ub214"), -1));
    private final vkl mhc = this.add(new vkl(a.c(-1946309766, "\uaf62\ud6f7\u5c26\uc640\u49ff\ucf3e\u756a\ufc9a\u62c9"), true));
    private final vkl mhd = this.add(new vkl(a.c(1252869609, "\u41d9\u3874\ub2a2\u2ca4\ua705\u21b0\u9ffd\u1233\u8c33\u06fc\u8156\u7b5d\uf589\u6c47\ue617\u60e8\udecb\u510f"), false));
    private final vkl mhe = this.add(new vkl(a.d("\u09ad\u7000\ufad6\u64d0\uef71\u69c4\ud789\u5a4f\uc437\u4eff\uc95d\u3356\ubdf3\u2052\uaa14", 1103173673, -1211689559), false));
    private final vkl mhf = this.add(new vkl(a.b("\ua68f\udf22\u55f4\ucbf2\u4053\uc6e6\u78ab\uf565\u6b1b\ue1a0\u6675\u9c08\u12d5\u8b6d\u0133\u87bd\u399d\ub229\u28e1\uaeba\u2735\u5d19\ud3ab\u4c6a\uca06", 53650100), false));
    private final vkl mhg = this.add(new vkl(a.d("\u2830\u519d\udb4b\u454d\uceec\u4859\uf614\u7bfa\ue5a4\u6f10\ue8c5\u12b9\u9c11\u01cf\u8f83\u090d\ub33c\u3c94\ua65d\u200f\ua987\ud3d5\u5d68", -939559462, -1568515617), false));
    private final vkl mhh = this.add(new vkl(a.b("\ue13a\u9898\u1243\u8c3f\u03f8\u815e\u3b0a\ub6eb\u2cdc\ua667\u21b5\udbbd\u5513", 312665361), false));
    private final vkl mhi = this.add(new vkl(a.b("\u63fd\u1a6d\u90b4\u0eb0\u8514\u03a2\ub986\u300f\uae5a\u20fb\ua336\u5948\ud7e7\u4e2a\uc47f\u4283\ufcd2\u771f\ueda8\u6bfc\ue20e\u985b\u1697\u8d39\u0b4a", 154429435), true));
    private final vmc mhj = this.add(new vmc(a.d("\uba6b\uc3fb\u492e\ud726\u5c8a\uda3f\u6060\ued83\u77ce\uf96d\u7aa2\u80d7\u0e05\u97ca\u1d98\u9b68", 486382694, -1367989758), 20.0, 4.0, 40.0, 1.0));
    private String mhk = "";
    private long mhl;
    private Slot mhm;
    private Slot mhn;
    private Slot mho;
    private Slot mhp;
    private int mhq = -1;
    private int mhr;
    private long mhs;
    private boolean mht;
    private boolean mhu;
    private boolean mhv;
    private static /* synthetic */ String mhw;
    private static /* synthetic */ String mhx;

    public mgl() {
        super(a.c(1955199244, "\uf940\u80c5\u0a00\u9466\u1fac\u991b\u2349\uaa9e\u34ec\ube54\u399b\uc3ff\u4d3f"), a.c(-456709628, "\u2a6c\u53fc\ud921\u475f\ucc8c\u4a38\uf065\u799b\ue7d8\u6d6e\ueaee\u10cb\u9e00\u07bc\u8daa\u0b18\ub15c\u3e80\ua437\u2277\uab95\ud1d2\u5f66\uc4e3\u4293\uc80c\u71b6\uffaf\u6514\ue346\u68ee\u9638"), kfa.PLAYER);
        mha = this;
    }

    @Override
    protected void onEnable() {
        this.mih();
        this.mhq = -1;
        this.mhr = 0;
        this.mhs = 0L;
    }

    @Override
    protected void onDisable() {
        this.mih();
    }

    public static void onMessage(Text text) {
    }

    public static void attach(Screen screen2) {
        if (!(screen2 instanceof GenericContainerScreen)) {
            return;
        }
        GenericContainerScreen genericContainerScreen = (GenericContainerScreen)screen2;
        ScreenEvents.afterRender((Screen)screen2).register((screen, drawContext, n, n2, f) -> {
            mgl mgl2 = mha;
            if (mgl2 != null && mgl2.isEnabled() && mgl2.mid(genericContainerScreen, drawContext)) {
                mgl2.mhy(genericContainerScreen, drawContext, n, n2);
            }
        });
    }

    private void mhy(GenericContainerScreen genericContainerScreen, DrawContext drawContext, int n, int n2) {
        if (!((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getCursorStack().isEmpty()) {
            genericContainerScreen.renderCursorStack(drawContext, n, n2);
            return;
        }
        Slot slot = vxl.hovered(genericContainerScreen);
        if (slot == null || !slot.hasStack()) {
            return;
        }
        ItemStack itemStack = slot.getStack();
        drawContext.drawTooltip(this.mc.textRenderer, Screen.getTooltipFromItem((MinecraftClient)this.mc, (ItemStack)itemStack), itemStack.getTooltipData(), n, n2, (Identifier)itemStack.get(DataComponentTypes.TOOLTIP_STYLE));
        drawContext.drawDeferredElements();
    }

    @Override
    public void onKey(MinecraftClient minecraftClient, int n) {
        if (n != this.mhb.get()) {
            return;
        }
        this.mia(minecraftClient);
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (minecraftClient.player == null) {
            return;
        }
        this.mhz(minecraftClient);
    }

    private void mhz(MinecraftClient minecraftClient) {
        if (minecraftClient.getWindow() == null) {
            this.mhv = false;
            return;
        }
        boolean bl = GLFW.glfwGetMouseButton((long)minecraftClient.getWindow().getHandle(), (int)2) == 1;
        boolean bl2 = bl && !this.mhv && minecraftClient.currentScreen instanceof GenericContainerScreen;
        this.mhv = bl;
        if (!bl2) {
            return;
        }
        GenericContainerScreen genericContainerScreen = (GenericContainerScreen)minecraftClient.currentScreen;
        String string = pfl.title(genericContainerScreen.getTitle().getString());
        if (mgl.mij(string)) {
            return;
        }
        Slot slot = vxl.hovered(genericContainerScreen);
        if (slot == null || !slot.hasStack()) {
            return;
        }
        String string2 = mgl.cleanQuery(slot.getStack().getName().getString());
        if (string2.isEmpty()) {
            return;
        }
        this.mhk = string2;
        izx.alert(this.getName(), wap.s(a.b("\u11e0\u687c\ue2b5\u7cdf\uf702\u71ed\ucba4", 1057362341), a.b("\uaa8f\ud319\u59cb\uc7b3\u4c61\ucadb\u708b\uf972\u632a\ue981", -1549816174)) + this.mhk, vhz.PIN, true);
    }

    private void mia(MinecraftClient minecraftClient) {
        if (minecraftClient.player == null || minecraftClient.getNetworkHandler() == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.mhl < 500L) {
            return;
        }
        if (!this.mib(l)) {
            izx.alert(this.getName(), wap.s(a.d("\u127e\u6bfc\ue13a\u7f5a\uf4c8\u7235\uc863\u4196\udfcd\u5561", -1126204088, -646484114), a.c(1479946693, "\u35e9\u4c42\uc692\u5893\ud336\u5583\uefd2\u623f\uf807\u72c1\uf563\u0f11\u81ba")), vhz.CLOCK, false);
            return;
        }
        String string = this.mic(minecraftClient.player);
        if (string.isEmpty()) {
            izx.alert(this.getName(), wap.s(a.d("\udbff\ua26f\u28a7\ub6ca\u3d1c\ubbaa\u01f0\u8846\u164d\u9ce7\u1b7b\ue159\u6f98\uf62d\u7c6d\ufa8d\u40c9", 1204759264, 2038100288), a.c(316499322, "\u6176\u18ef\u9629\u0c4a\u87e4\u012f\ubb0d\u328c\uacde\u2272\ua1be\u5bb0\ud512\u4ca2\uc6f9\u4001\ufa39")), vhz.INFO, false);
            return;
        }
        this.mhl = l;
        minecraftClient.getNetworkHandler().sendChatCommand(a.b("\u931d\ueaa5\u603e\ufe1c\u75dd\uf368\u4928\uc0c8\u5e9c\ud465", -569339018) + string);
    }

    private boolean mib(long l) {
        return pdi.nextFree(0, this.mhj.getInt(), l) <= l;
    }

    private String mic(ClientPlayerEntity clientPlayerEntity) {
        String string;
        HandledScreen handledScreen;
        Object object = this.mc.currentScreen;
        if (object instanceof HandledScreen && (object = vxl.hovered(handledScreen = (HandledScreen)object)) != null && object.hasStack() && !(string = mgl.cleanQuery(object.getStack().getName().getString())).isEmpty()) {
            return string;
        }
        handledScreen = clientPlayerEntity.getMainHandStack();
        if (handledScreen != null && !handledScreen.isEmpty() && !((String)(object = mgl.cleanQuery(handledScreen.getName().getString()))).isEmpty()) {
            return object;
        }
        return this.mhk;
    }

    public static String cleanQuery(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        String string2 = string.replaceAll(a.d("\uc0be\ub986", -665444366, -659103767), "");
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        boolean bl = true;
        for (int i = 0; i < string2.length(); ++i) {
            boolean bl2;
            char c = string2.charAt(i);
            boolean bl3 = bl2 = c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '\u0400' && c <= '\u04ff' || c >= '0' && c <= '9';
            if (bl2) {
                stringBuilder.append(Character.toLowerCase(c));
                bl = false;
                continue;
            }
            if (bl) continue;
            stringBuilder.append(' ');
            bl = true;
        }
        return stringBuilder.toString().trim();
    }

    public String getBound() {
        return this.mhk;
    }

    private boolean mid(GenericContainerScreen genericContainerScreen, DrawContext drawContext) {
        String string;
        int n = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).syncId;
        if (n != this.mhq) {
            this.mih();
            this.mhq = n;
            this.mhr = 0;
            this.mhs = 0L;
        }
        if (mgl.mij(string = pfl.title(genericContainerScreen.getTitle().getString()))) {
            this.mih();
            return false;
        }
        boolean bl = this.mhh.get() != this.mht || this.mhi.get() != this.mhu;
        int n2 = this.mif(genericContainerScreen);
        long l = System.currentTimeMillis();
        if (bl || n2 != this.mhr || l - this.mhs > 500L) {
            this.mie(genericContainerScreen, string);
            this.mhr = n2;
            this.mhs = l;
            this.mht = this.mhh.get();
            this.mhu = this.mhi.get();
        }
        int[] nArray = this.mii(genericContainerScreen);
        boolean bl2 = this.mhi.get() && this.mig(drawContext, this.mhp, nArray, -16711681);
        bl2 |= this.mig(drawContext, this.mhm, nArray, -16711936);
        bl2 |= this.mig(drawContext, this.mhn, nArray, -29696);
        return bl2 |= this.mig(drawContext, this.mho, nArray, -52429);
    }

    private void mie(GenericContainerScreen genericContainerScreen, String string) {
        ArrayList<mgg> arrayList = new ArrayList<mgg>();
        Slot slot = null;
        int n = Integer.MAX_VALUE;
        int n2 = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getRows();
        int n3 = n2 * 9;
        boolean bl = mgl.mik(string);
        for (Slot slot2 : ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).slots) {
            int n4;
            List<String> list;
            ItemStack itemStack;
            if (slot2.id >= n3 || (itemStack = slot2.getStack()).isEmpty() || (list = pfd.lines(itemStack)).isEmpty() || mgl.mim(list.get(0), mgo) || (n4 = pfd.total(itemStack)) <= 0 || !bl && !mgl.min(list, mgp) || this.mhc.get() && mgl.mip(itemStack, list, a.c(689709357, "\u2561\u5ca0\ud674\u4871"), a.d("\u96e4\uef49\u659d\ufbf1\u703a\uf696", -534221121, -2065500119)) || this.mhd.get() && mgl.mis(itemStack) && !mgl.miq(list, a.b("\u435d\u3a93\ub03e\u2e36\ua59b\u2329\u9905\u10f7\u8ea6", -1228978325), a.c(-2105282421, "\uf0f4\u895e\u0381\u9de0\u1620\u9095\u2acc\ua33f\u3d67\ub7df"), 5) || this.mhe.get() && mgl.mis(itemStack) && !mgl.miq(list, a.b("\u8510\ufca6\u760c\ue80c\u63a1\ue562", 340885793), a.d("\udd39\ua48a\u2e44\ub02e\u3be8\ubd5f\u071b\u8ef7\u10ae\u9a1e", 1366089607, 415826628), 5) || this.mhf.get() && mgl.miw(itemStack) && !mgl.miq(list, a.c(-1470047695, "\ude1e\ua7ae\u2d77\ub300\u38db\ube60\u043a\u8dc6\u13e6\u9d38\u1e8e\ue484\u6a59\uf390\u79be\uff4e"), a.d("\u5f39\u2689\uac4f\u323a\ub9f1\u3f08\u8508\u0cfe\u92a7\u180d\u9fd3\u65a3\ueb63", -1457165316, -647351124), 3) || this.mhg.get() && itemStack.isDamageable() && itemStack.isDamaged() || mgl.mio(list)) continue;
            if (n4 < n) {
                n = n4;
                slot = slot2;
            }
            int n5 = this.mhh.get() && itemStack.getCount() > 1 ? n4 / itemStack.getCount() : n4;
            arrayList.add(new mgg(slot2, n5));
        }
        Collections.sort(arrayList);
        this.mhm = arrayList.isEmpty() ? null : ((mgg)arrayList.get((int)0)).mgh;
        this.mhn = arrayList.size() > 1 ? ((mgg)arrayList.get((int)1)).mgh : null;
        this.mho = arrayList.size() > 2 ? ((mgg)arrayList.get((int)2)).mgh : null;
        this.mhp = slot;
    }

    private int mif(GenericContainerScreen genericContainerScreen) {
        int n = 1;
        int n2 = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getRows();
        int n3 = n2 * 9;
        for (Slot slot : ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).slots) {
            ItemStack itemStack;
            if (slot.id >= n3 || (itemStack = slot.getStack()).isEmpty()) continue;
            n = 31 * n + Registries.ITEM.getRawId((Object)itemStack.getItem());
            n = 31 * n + itemStack.getCount();
            if (itemStack.contains(DataComponentTypes.CUSTOM_NAME)) {
                n = 31 * n + itemStack.getName().hashCode();
            }
            if (!itemStack.contains(DataComponentTypes.LORE)) continue;
            n = 31 * n + ((LoreComponent)itemStack.get(DataComponentTypes.LORE)).hashCode();
        }
        return n;
    }

    private boolean mig(DrawContext drawContext, Slot slot, int[] nArray, int n) {
        if (slot == null || slot.getStack().isEmpty()) {
            return false;
        }
        int n2 = 0x4B000000 | n & 0xFFFFFF;
        int n3 = 0x99000000 | n & 0xFFFFFF;
        int n4 = nArray[0] + slot.x;
        int n5 = nArray[1] + slot.y;
        int n6 = n4 + 16;
        int n7 = n5 + 16;
        drawContext.fill(n4, n5, n6, n7, n2);
        drawContext.fill(n4 - 1, n5 - 1, n6 + 1, n5, n3);
        drawContext.fill(n4 - 1, n7, n6 + 1, n7 + 1, n3);
        drawContext.fill(n4 - 1, n5, n4, n7, n3);
        drawContext.fill(n6, n5, n6 + 1, n7, n3);
        return true;
    }

    private void mih() {
        this.mhm = null;
        this.mhn = null;
        this.mho = null;
        this.mhp = null;
    }

    private int[] mii(GenericContainerScreen genericContainerScreen) {
        int n = ((GenericContainerScreenHandler)genericContainerScreen.getScreenHandler()).getRows();
        int n2 = 176;
        int n3 = 114 + n * 18;
        int n4 = (genericContainerScreen.width - n2) / 2;
        int n5 = (genericContainerScreen.height - n3) / 2;
        return new int[]{n4, n5};
    }

    private static boolean mij(String string) {
        return mgl.mim(string, mgm);
    }

    private static boolean mik(String string) {
        return mgl.mim(string, mgn);
    }

    private static String[] mil(String ... stringArray) {
        String[] stringArray2 = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray2[i] = pfl.title(stringArray[i]);
        }
        return stringArray2;
    }

    private static boolean mim(String string, String[] stringArray) {
        for (String string2 : stringArray) {
            if (!string.contains(string2)) continue;
            return true;
        }
        return false;
    }

    private static boolean min(List<String> list, String[] stringArray) {
        for (String string : list) {
            if (!mgl.mim(string, stringArray)) continue;
            return true;
        }
        return false;
    }

    private static boolean mio(List<String> list) {
        for (String string : list) {
            if (mgl.mim(string, mgq) || !mgl.mim(string, mgr) && (!mgl.mim(string, mgs) || string.contains(mgt))) continue;
            return true;
        }
        return false;
    }

    private static boolean mip(ItemStack itemStack, List<String> list, String string, String string2) {
        if (mgl.min(list, mgl.mil(string, string2))) {
            return true;
        }
        try {
            ItemEnchantmentsComponent itemEnchantmentsComponent = (ItemEnchantmentsComponent)itemStack.get(DataComponentTypes.ENCHANTMENTS);
            if (itemEnchantmentsComponent != null && itemEnchantmentsComponent.toString().toLowerCase(Locale.ROOT).contains(string2)) {
                return true;
            }
            ItemEnchantmentsComponent itemEnchantmentsComponent2 = (ItemEnchantmentsComponent)itemStack.get(DataComponentTypes.STORED_ENCHANTMENTS);
            if (itemEnchantmentsComponent2 != null && itemEnchantmentsComponent2.toString().toLowerCase(Locale.ROOT).contains(string2)) {
                return true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    private static boolean miq(List<String> list, String string, String string2, int n) {
        String string3 = mgl.mir(n);
        return mgl.min(list, mgl.mil(string + a.c(1336492141, "\u404c") + n, string2 + a.b("\u2bdd", 415640572) + n, string + a.d("\ue739", 255596838, -1669988802) + string3, string2 + a.d("\u57fb", 720464742, 2106866876) + string3));
    }

    private static String mir(int n) {
        return switch (n) {
            case 1 -> a.b("\ue9d2", 82897338);
            case 2 -> a.d("\u7ae8\u0359", -1291992651, 1824897846);
            case 3 -> a.c(-708144682, "\u91bc\ue80d\u62de");
            case 4 -> a.d("\uda73\ua3dd", -574700615, 887626145);
            case 5 -> a.d("\uac47", 1171017352, -2047155528);
            default -> String.valueOf(n);
        };
    }

    private static boolean mis(ItemStack itemStack) {
        return mgl.mit(itemStack) || mgl.miu(itemStack) || mgl.miv(itemStack) || mgl.miw(itemStack);
    }

    private static boolean mit(ItemStack itemStack) {
        return itemStack.isOf(Items.NETHERITE_HELMET) || itemStack.isOf(Items.DIAMOND_HELMET) || itemStack.isOf(Items.IRON_HELMET) || itemStack.isOf(Items.GOLDEN_HELMET) || itemStack.isOf(Items.CHAINMAIL_HELMET) || itemStack.isOf(Items.LEATHER_HELMET) || itemStack.isOf(Items.TURTLE_HELMET);
    }

    private static boolean miu(ItemStack itemStack) {
        return itemStack.isOf(Items.NETHERITE_CHESTPLATE) || itemStack.isOf(Items.DIAMOND_CHESTPLATE) || itemStack.isOf(Items.IRON_CHESTPLATE) || itemStack.isOf(Items.GOLDEN_CHESTPLATE) || itemStack.isOf(Items.CHAINMAIL_CHESTPLATE) || itemStack.isOf(Items.LEATHER_CHESTPLATE);
    }

    private static boolean miv(ItemStack itemStack) {
        return itemStack.isOf(Items.NETHERITE_LEGGINGS) || itemStack.isOf(Items.DIAMOND_LEGGINGS) || itemStack.isOf(Items.IRON_LEGGINGS) || itemStack.isOf(Items.GOLDEN_LEGGINGS) || itemStack.isOf(Items.CHAINMAIL_LEGGINGS) || itemStack.isOf(Items.LEATHER_LEGGINGS);
    }

    private static boolean miw(ItemStack itemStack) {
        return itemStack.isOf(Items.NETHERITE_BOOTS) || itemStack.isOf(Items.DIAMOND_BOOTS) || itemStack.isOf(Items.IRON_BOOTS) || itemStack.isOf(Items.GOLDEN_BOOTS) || itemStack.isOf(Items.CHAINMAIL_BOOTS) || itemStack.isOf(Items.LEATHER_BOOTS);
    }

    private static /* synthetic */ int bba(int n, int n2) {
        return n * n2 | 0xED112588;
    }

    private static /* synthetic */ int bbb(int n, int n2) {
        return mgl.bba(n, n2) + n;
    }
}

