/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
 *  net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents
 *  net.minecraft.class_2583
 *  net.minecraft.class_303
 *  net.minecraft.class_303$class_7590
 *  net.minecraft.class_310
 *  net.minecraft.class_338
 *  net.minecraft.class_3532
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_5481
 */
package a;

import a.Hud;
import a.ModuleCategory;
import a.Module;
import a.lqu;
import a.lqy;
import a.Icon;
import a.BoolSetting;
import a.NumberSetting;
import a.Lang;
import a.ChatCoordLinker;
import flow.dev.StringDecryptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.class_2583;
import net.minecraft.class_303;
import net.minecraft.class_310;
import net.minecraft.class_338;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_5481;

public class ChatPlus
extends Module {
    private static ChatPlus lrf;
    private final BoolSetting lrg = this.add(new BoolSetting("Long history", true));
    private final NumberSetting lrh = this.add(new NumberSetting("History", 1000.0, 200.0, 5000.0, 100.0));
    private final BoolSetting lri = this.add(new BoolSetting("Keep chat", true));
    private final BoolSetting lrj = this.add(new BoolSetting("Merge repeats", true));
    private final BoolSetting lrk = this.add(new BoolSetting("Copy on right click", true));
    private static final int lrl = 100;
    private static Field lrm;
    private static Field lrn;
    private static Field lro;
    private static boolean lrp;
    private static class_338 lrq;
    private static class_303 lrr;
    private static String lrs;
    private static int lrt;
    private static /* synthetic */ boolean lru;
    private static /* synthetic */ int lrv;

    public ChatPlus() {
        super("ChatTweaks", "Longer chat, merged repeats, copy on click", ModuleCategory.MISC);
        lrf = this;
        this.lrh.visibleWhen(this.lrg::get);
        try {
            ClientPlayConnectionEvents.JOIN.register((class_6342, packetSender, class_3102) -> class_3102.execute(() -> {
                if (ChatPlus.lrw() && ChatPlus.lrf.lri.get() && class_3102.field_1705 != null) {
                    class_3102.field_1705.method_1743().method_1817();
                }
            }));
        }
        catch (Throwable throwable) {
            System.out.println("join event unavailable, kept chat shows on the next message: " + throwable);
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
    public void onEndTick(class_310 class_3102) {
        if (!lrp && class_3102.field_1705 != null && class_3102.field_1705.method_1743() != lrq) {
            ChatPlus.lrx(class_3102.field_1705.method_1743());
        }
    }

    private static void lrx(class_338 class_3382) {
        try {
            if (lrm == null) {
                for (Field field : class_338.class.getDeclaredFields()) {
                    ParameterizedType parameterizedType;
                    Type type;
                    if (Modifier.isStatic(field.getModifiers())) continue;
                    if (field.getType() == Integer.TYPE && lro == null) {
                        field.setAccessible(true);
                        lro = field;
                    }
                    if (field.getType() != List.class || !((type = field.getGenericType()) instanceof ParameterizedType) || (parameterizedType = (ParameterizedType)type).getActualTypeArguments().length != 1) continue;
                    Type type2 = parameterizedType.getActualTypeArguments()[0];
                    if (type2 == class_303.class) {
                        field.setAccessible(true);
                        lrm = field;
                        continue;
                    }
                    if (type2 != class_303.class_7590.class) continue;
                    field.setAccessible(true);
                    lrn = field;
                }
                if (lrm == null || lrn == null) {
                    throw new IllegalStateException("chat lists not found");
                }
            }
            List throwable = (List)lrm.get(class_3382);
            List list = (List)lrn.get(class_3382);
            if (!(throwable instanceof lqy)) {
                lrm.set(class_3382, new lqy(throwable, class_3382));
            }
            if (!(list instanceof lqu)) {
                lrn.set(class_3382, new lqu(list));
            }
            lrq = class_3382;
        }
        catch (Throwable throwable) {
            lrp = true;
            System.out.println("chat tweaks unavailable: " + throwable);
        }
    }

    private static int lry() {
        return ChatPlus.lrw() && ChatPlus.lrf.lrg.get() ? ChatPlus.lrf.lrh.getInt() : 100;
    }

    private static void lrz(List<class_303.class_7590> list, class_303 class_3032) {
        class_310 class_3102 = class_310.method_1551();
        double d = (Double)class_3102.field_1690.method_42554().method_41753();
        int n = class_3532.method_15357((double)((double)class_338.method_1806((double)((Double)class_3102.field_1690.method_42556().method_41753())) / d));
        List list2 = class_3032.method_75757(class_3102.field_1772, n);
        for (int i = 0; i < list2.size(); ++i) {
            list.addFirst(new class_303.class_7590(class_3032.comp_892(), (class_5481)list2.get(i), class_3032.comp_894(), i == list2.size() - 1));
        }
    }

    private static String lsa(List<class_303.class_7590> list, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n3 - 1; i >= 0; --i) {
            list.get(i).comp_896().accept((n, class_25832, n2) -> {
                stringBuilder.appendCodePoint(n2);
                return true;
            });
        }
        return ChatPlus.lsb(stringBuilder.toString());
    }

    private static String lsb(String string) {
        return string.replaceAll("§.|\\s+", "");
    }

    private static int lsc(List<class_303.class_7590> list, int n) {
        if (n >= list.size() || !list.get(n).comp_898()) {
            return -1;
        }
        int n2 = 1;
        while (n + n2 < list.size() && !list.get(n + n2).comp_898()) {
            ++n2;
        }
        return n2;
    }

    public static void attach(class_437 class_4373) {
        if (!(class_4373 instanceof class_408)) {
            return;
        }
        ScreenMouseEvents.allowMouseClick((class_437)class_4373).register((class_4372, class_119092) -> {
            if (class_119092.method_74245() == 0) {
                return !ChatCoordLinker.click(ChatPlus.lse(class_119092.comp_4798(), class_119092.comp_4799()));
            }
            if (class_119092.method_74245() != 1 || !ChatPlus.lrw() || !ChatPlus.lrf.lrk.get()) {
                return true;
            }
            String string = ChatPlus.lsf(class_119092.comp_4798(), class_119092.comp_4799());
            if (string == null) {
                return true;
            }
            class_310.method_1551().field_1774.method_1455(string);
            Hud.alert(lrf.getName(), Lang.s("Copied", "Скопировано"), Icon.CHECK, true);
            return false;
        });
    }

    private static int lsd(List<class_303.class_7590> list, class_338 class_3382, double d, double d2) throws IllegalAccessException {
        class_310 class_3102 = class_310.method_1551();
        int n = lro.getInt(class_3382);
        double d3 = (Double)class_3102.field_1690.method_42554().method_41753();
        double d4 = (Double)class_3102.field_1690.method_42546().method_41753();
        int n2 = (int)(9.0 * (d4 + 1.0));
        int n3 = class_3532.method_15357((double)((double)(class_3102.method_22683().method_4502() - 40) / d3));
        double d5 = d / d3 - 4.0;
        double d6 = d2 / d3;
        int n4 = class_3532.method_15384((double)((double)class_338.method_1806((double)((Double)class_3102.field_1690.method_42556().method_41753())) / d3));
        if (d5 < -4.0 || d5 > (double)n4 + 8.0 || d6 > (double)n3) {
            return -1;
        }
        int n5 = (int)Math.floor(((double)n3 - d6) / (double)n2);
        if (n5 < 0 || n5 >= class_3382.method_1813()) {
            return -1;
        }
        int n6 = n5 + n;
        return n6 < list.size() ? n6 : -1;
    }

    private static class_2583 lse(double d, double d2) {
        class_310 class_3102 = class_310.method_1551();
        if (lrn == null || lro == null) {
            return null;
        }
        try {
            class_338 class_3382 = class_3102.field_1705.method_1743();
            List list = (List)lrn.get(class_3382);
            int n3 = ChatPlus.lsd(list, class_3382, d, d2);
            double d3 = d / (Double)class_3102.field_1690.method_42554().method_41753() - 4.0;
            if (n3 < 0 || d3 < 0.0) {
                return null;
            }
            float[] fArray = new float[]{0.0f};
            class_2583[] class_2583Array = new class_2583[]{null};
            ((class_303.class_7590)list.get(n3)).comp_896().accept((n, class_25832, n2) -> {
                float f = class_3102.field_1772.method_30880(class_5481.method_30741((int)n2, (class_2583)class_25832));
                if (d3 < (double)(fArray[0] + f)) {
                    class_2583Array[0] = class_25832;
                    return false;
                }
                fArray[0] = fArray[0] + f;
                return true;
            });
            return class_2583Array[0];
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static String lsf(double d, double d2) {
        class_310 class_3102 = class_310.method_1551();
        class_338 class_3382 = class_3102.field_1705.method_1743();
        if (lrn == null || lro == null) {
            return null;
        }
        try {
            int n3;
            List list = (List)lrn.get(class_3382);
            int n4 = ChatPlus.lsd(list, class_3382, d, d2);
            if (n4 < 0) {
                return null;
            }
            for (n3 = n4; n3 > 0 && !((class_303.class_7590)list.get(n3)).comp_898(); --n3) {
            }
            int n5 = ChatPlus.lsc(list, n3);
            if (n5 <= 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = n3 + n5 - 1; i >= n3; --i) {
                ((class_303.class_7590)list.get(i)).comp_896().accept((n, class_25832, n2) -> {
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

