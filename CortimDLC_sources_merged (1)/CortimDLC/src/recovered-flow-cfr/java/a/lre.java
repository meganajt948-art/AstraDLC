/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.ChatHud
 *  net.minecraft.client.gui.hud.ChatHudLine
 *  net.minecraft.client.gui.hud.ChatHudLine$Visible
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.text.OrderedText
 *  net.minecraft.text.Style
 *  net.minecraft.util.math.MathHelper
 */
package a;

import a.izx;
import a.kfa;
import a.kfe;
import a.lqu;
import a.lqy;
import a.vhz;
import a.vkl;
import a.vmc;
import a.wap;
import a.wjw;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.util.math.MathHelper;

public class lre
extends kfe {
    private static lre lrf;
    private final vkl lrg = this.add(new vkl(a.b("\u7b92\u0200\u88d2\u16aa\u9d3a\u1bc3\ua191\u287a\ub622\u3c88\ubb46\u413c", 1981709266), true));
    private final vmc lrh = this.add(new vmc(a.c(-603737482, "\ub239\ucba9\u4160\udf16\u54da\ud276\u682e"), 1000.0, 200.0, 5000.0, 100.0));
    private final vkl lri = this.add(new vkl(a.d("\u0fc3\u765c\ufc8f\u62eb\ue96c\u6f9e\ud5c6\u5c3e\uc274", 1755679320, -395475495), true));
    private final vkl lrj = this.add(new vkl(a.d("\u4184\u381d\ub2d9\u2cbd\ua768\u219c\u9b9d\u127b\u8c31\u0695\u8142\u7b26\uf5f6", 1314207725, 143095337), true));
    private final vkl lrk = this.add(new vkl(a.b("\u9c7a\ue5e7\u6f2b\uf153\u7add\ufc23\u4671\ucfce\u51c3\udb69\u5cb4\ua6ca\u2801\ub1e4\u3bf4\ubd0a\u0740\u889b\u1220", -1622565846), true));
    private static final int lrl = 100;
    private static Field lrm;
    private static Field lrn;
    private static Field lro;
    private static boolean lrp;
    private static ChatHud lrq;
    private static ChatHudLine lrr;
    private static String lrs;
    private static int lrt;
    private static /* synthetic */ boolean lru;
    private static /* synthetic */ int lrv;

    public lre() {
        super(a.d("\u9580\uec1a\u66c0\uf8a4\u7353\uf5c1\u4f80\uc675\u5820\ud289", -1538528471, 660045536), a.b("\ueb73\u92e1\u1833\u864b\u0d9e\u8b38\u3139\ub88b\u26df\uac67\u2ba1\ud188\u5f53\uc6af\u4cf4\uca12\u7048\uff9b\u6529\ue33c\u6a99\u10df\u9e79\u05bd\u83c6\u0902\ub0b6\u3eb8\ua443\u2251\ua9ee\u5720\udd66\u44ce\uc2d2\u4862\uf7fb\u7dc9\ufb15\u62a1\ue8f4\u960d", -1138758891), kfa.MISC);
        lrf = this;
        this.lrh.visibleWhen(this.lrg::get);
        try {
            ClientPlayConnectionEvents.JOIN.register((clientPlayNetworkHandler, packetSender, minecraftClient) -> minecraftClient.execute(() -> {
                if (lre.lrw() && lre.lrf.lri.get() && minecraftClient.field_1705 != null) {
                    minecraftClient.field_1705.method_1743().method_1817();
                }
            }));
        }
        catch (Throwable throwable) {
            System.out.println(a.c(-1023039319, "\ua8fe\ud14a\u5b9f\uc5e9\u4e70\uc884\u72c4\ufb26\u6572\uefd9\u685e\u927a\u1cb6\u8508\u0f4c\u89aa\u33ed\ubc39\u2687\ua0d5\u292c\u5374\udd8e\u4653\uc067\u4ab8\uf31e\u7d4b\ue7e8\u61fa\uea42\u149a\u9ec0\u0765\u8165\u0bcf\ub41f\u3e76\ub8a1\u2143\uab53\ud5a3\u5fbe\ud85b\u4290\uccec\u757a\uff85\u79c1\ue20d\u6c72\u96f7\u1f0d\u9954\u03b1\u8de0\u364d\ub09a\u3aeb\ua365\u2dc8") + throwable);
        }
    }

    private static boolean lrw() {
        return lrf != null && lrf.isEnabled();
    }

    @Override
    public boolean ticksWhenOff() {
        return true;
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        if (!lrp && minecraftClient.field_1705 != null && minecraftClient.field_1705.method_1743() != lrq) {
            lre.lrx(minecraftClient.field_1705.method_1743());
        }
    }

    private static void lrx(ChatHud chatHud) {
        try {
            if (lrm == null) {
                for (Field field : ChatHud.class.getDeclaredFields()) {
                    ParameterizedType parameterizedType;
                    Type type;
                    if (Modifier.isStatic(field.getModifiers())) continue;
                    if (field.getType() == Integer.TYPE && lro == null) {
                        field.setAccessible(true);
                        lro = field;
                    }
                    if (field.getType() != List.class || !((type = field.getGenericType()) instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments().length != 1) continue;
                    Type type2 = parameterizedType.getActualTypeArguments()[0];
                    if (type2 == ChatHudLine.class) {
                        field.setAccessible(true);
                        lrm = field;
                        continue;
                    }
                    if (type2 != ChatHudLine.Visible.class) continue;
                    field.setAccessible(true);
                    lrn = field;
                }
                if (lrm == null || lrn == null) {
                    throw new IllegalStateException(a.b("\uad64\ud4de\u5e04\uc060\u4be3\ucd1e\u7748\ufea3\u60fb\uea4d\u6dcd\u97f2\u1924\u808e\u0a89\u8c3e\u3678\ub9b3\u231b\ua540", -1383486189));
                }
            }
            List throwable = (List)lrm.get(chatHud);
            List list = (List)lrn.get(chatHud);
            if (!(throwable instanceof lqy)) {
                lrm.set(chatHud, new lqy(throwable, chatHud));
            }
            if (!(list instanceof lqu)) {
                lrn.set(chatHud, new lqu(list));
            }
            lrq = chatHud;
        }
        catch (Throwable throwable) {
            lrp = true;
            System.out.println(a.c(2026985386, "\u57d0\u2e6a\ua4b0\u3ad4\ub157\u37b2\u8de2\u0401\u9a5a\u10e1\u972a\u6d08\ue38a\u7a20\uf07c\u769a\uccc2\u431b\ud9ad\u5ff1\ud605\uac5a\u22e0\ub96e\u3f0b") + throwable);
        }
    }

    private static int lry() {
        return lre.lrw() && lre.lrf.lrg.get() ? lre.lrf.lrh.getInt() : 100;
    }

    private static void lrz(List<ChatHudLine.Visible> list, ChatHudLine chatHudLine) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        double d = (Double)minecraftClient.field_1690.method_42554().method_41753();
        int n = MathHelper.method_15357((double)((double)ChatHud.method_1806((double)((Double)minecraftClient.field_1690.method_42556().method_41753())) / d));
        List list2 = chatHudLine.method_75757(minecraftClient.field_1772, n);
        for (int i = 0; i < list2.size(); ++i) {
            list.addFirst(new ChatHudLine.Visible(chatHudLine.comp_892(), (OrderedText)list2.get(i), chatHudLine.comp_894(), i == list2.size() - 1));
        }
    }

    private static String lsa(List<ChatHudLine.Visible> list, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n3 - 1; i >= 0; --i) {
            list.get(i).comp_896().accept((n, style, n2) -> {
                stringBuilder.appendCodePoint(n2);
                return true;
            });
        }
        return lre.lsb(stringBuilder.toString());
    }

    private static String lsb(String string) {
        return string.replaceAll(a.d("\uda83\ua3bb\u293a\ub76b\u3c93\uba7a", 2018923283, 1440778545), "");
    }

    private static int lsc(List<ChatHudLine.Visible> list, int n) {
        if (n >= list.size() || !list.get(n).comp_898()) {
            return -1;
        }
        int n2 = 1;
        while (n + n2 < list.size() && !list.get(n + n2).comp_898()) {
            ++n2;
        }
        return n2;
    }

    public static void attach(Screen screen2) {
        if (!(screen2 instanceof ChatScreen)) {
            return;
        }
        ScreenMouseEvents.allowMouseClick((Screen)screen2).register((screen, click) -> {
            if (click.method_74245() == 0) {
                return !wjw.click(lre.lse(click.comp_4798(), click.comp_4799()));
            }
            if (click.method_74245() != 1 || !lre.lrw() || !lre.lrf.lrk.get()) {
                return true;
            }
            String string = lre.lsf(click.comp_4798(), click.comp_4799());
            if (string == null) {
                return true;
            }
            MinecraftClient.method_1551().field_1774.method_1455(string);
            izx.alert(lrf.getName(), wap.s(a.d("\ua066\ud9fb\u5337\ucd5f\u4684\uc034", 629863611, 686970008), a.d("\ue9a6\u900c\u1adb\u84ab\u0f7b\u89b2\u339f\uba62\u243f\uae83\u2953", -2046083955, -360132351)), vhz.CHECK, true);
            return false;
        });
    }

    private static int lsd(List<ChatHudLine.Visible> list, ChatHud chatHud, double d, double d2) throws IllegalAccessException {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        int n = lro.getInt(chatHud);
        double d3 = (Double)minecraftClient.field_1690.method_42554().method_41753();
        double d4 = (Double)minecraftClient.field_1690.method_42546().method_41753();
        int n2 = (int)(9.0 * (d4 + 1.0));
        int n3 = MathHelper.method_15357((double)((double)(minecraftClient.method_22683().method_4502() - 40) / d3));
        double d5 = d / d3 - 4.0;
        double d6 = d2 / d3;
        int n4 = MathHelper.method_15384((double)((double)ChatHud.method_1806((double)((Double)minecraftClient.field_1690.method_42556().method_41753())) / d3));
        if (d5 < -4.0 || d5 > (double)n4 + 8.0 || d6 > (double)n3) {
            return -1;
        }
        int n5 = (int)Math.floor(((double)n3 - d6) / (double)n2);
        if (n5 < 0 || n5 >= chatHud.method_1813()) {
            return -1;
        }
        int n6 = n5 + n;
        return n6 < list.size() ? n6 : -1;
    }

    private static Style lse(double d, double d2) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (lrn == null || lro == null) {
            return null;
        }
        try {
            ChatHud chatHud = minecraftClient.field_1705.method_1743();
            List list = (List)lrn.get(chatHud);
            int n3 = lre.lsd(list, chatHud, d, d2);
            double d3 = d / (Double)minecraftClient.field_1690.method_42554().method_41753() - 4.0;
            if (n3 < 0 || d3 < 0.0) {
                return null;
            }
            float[] fArray = new float[]{0.0f};
            Style[] styleArray = new Style[]{null};
            ((ChatHudLine.Visible)list.get(n3)).comp_896().accept((n, style, n2) -> {
                float f = minecraftClient.field_1772.method_30880(OrderedText.method_30741((int)n2, (Style)style));
                if (d3 < (double)(fArray[0] + f)) {
                    styleArray[0] = style;
                    return false;
                }
                fArray[0] = fArray[0] + f;
                return true;
            });
            return styleArray[0];
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static String lsf(double d, double d2) {
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        ChatHud chatHud = minecraftClient.field_1705.method_1743();
        if (lrn == null || lro == null) {
            return null;
        }
        try {
            int n3;
            List list = (List)lrn.get(chatHud);
            int n4 = lre.lsd(list, chatHud, d, d2);
            if (n4 < 0) {
                return null;
            }
            for (n3 = n4; n3 > 0 && !((ChatHudLine.Visible)list.get(n3)).comp_898(); --n3) {
            }
            int n5 = lre.lsc(list, n3);
            if (n5 <= 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = n3 + n5 - 1; i >= n3; --i) {
                ((ChatHudLine.Visible)list.get(i)).comp_896().accept((n, style, n2) -> {
                    stringBuilder.appendCodePoint(n2);
                    return true;
                });
            }
            String string = stringBuilder.toString().trim();
            return string.isEmpty() ? null : string;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static /* synthetic */ int azc(int n, int n2) {
        return n - n2 | 0x9F5CB768;
    }
}

