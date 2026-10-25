/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.decoration.DisplayEntity$TextDisplayEntity
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.pfl;
import a.pzk;
import a.pzp;
import a.qwj;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public final class pzw {
    private static final Pattern pzx = Pattern.compile(a.b("\u4347\u3a82\ub069\u2e07\ua59a\u2336\u997b\u10c5\u8ece\u046c\u83ad\u79a8\uf747\u6ee9\ue4f3\u624d\ud856\u5794\ucd35\u4b10\uc2df\ub891\u366b\uadf5\u2bde", -753384586));
    private static final Pattern pzy = Pattern.compile(a.c(539086795, "\ucff2\ub637\u3cdc\ua2b2\u292f\uaf83\u15cf\u9c70\u027b\u88d9\u0f18\uf51d\u7bf2\ue25c\u6846\ueef8\u54e3"));
    private static final Pattern pzz = Pattern.compile(a.b("\u4301\u3ac4\ub02f\u2e11\ua5c4\u2300\u997c\u10d4\u8a9d(\u87fe", 1357595426));
    private static final Pattern qaa = Pattern.compile(a.b("\ue0fb\u993e\u13d5\u8deb\u063e\u80fa\u3a86\ub32e\u291a\ua3df\u2403", 1589567704));
    private static TrackedData<?> qab;
    private static boolean qac;
    private static /* synthetic */ int qad;
    private static /* synthetic */ long qae;

    private pzw() {
    }

    /*
     * WARNING - void declaration
     */
    public static pzp read(MinecraftClient minecraftClient, double d) {
        void var11_16;
        void var11_14;
        Object object222;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null || minecraftClient.field_1687 == null) {
            return null;
        }
        Vec3d vec3d = clientPlayerEntity.method_73189();
        ArrayList<pzk> arrayList = new ArrayList<pzk>();
        pzk pzk4 = null;
        double d2 = Double.MAX_VALUE;
        block0: for (Object object222 : minecraftClient.field_1687.method_18112()) {
            List<String> list;
            Vec3d object3;
            if (object222 == clientPlayerEntity || (object3 = object222.method_73189()).method_1025(vec3d) > d * d || (list = pzw.lines((Entity)object222)).isEmpty()) continue;
            pzk pzk5 = new pzk(object3, list);
            arrayList.add(pzk5);
            for (String string : list) {
                if (!pfl.title(string).contains(a.d("\ua317\udade\u5078\uce0e", 373595790, -2000078379))) continue;
                double d3 = object3.method_1025(vec3d);
                if (!(d3 < d2)) continue block0;
                d2 = d3;
                pzk4 = pzk5;
                continue block0;
            }
        }
        if (pzk4 == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (pzk pzk6 : arrayList) {
            double d4 = pzk6.pzl.field_1352 - pzk4.pzl.field_1352;
            double d5 = pzk6.pzl.field_1350 - pzk4.pzl.field_1350;
            if (!(d4 * d4 + d5 * d5 <= 9.0) || !(Math.abs(pzk6.pzl.field_1351 - pzk4.pzl.field_1351) <= 5.0)) continue;
            arrayList2.add(pzk6);
        }
        arrayList2.sort((pzk2, pzk3) -> Double.compare(pzk3.pzl.field_1351, pzk2.pzl.field_1351));
        object222 = new ArrayList();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            pzk pzk7 = (pzk)iterator.next();
            for (String string : pzk7.pzm) {
                object222.add(pfl.title(string));
            }
        }
        Object var11_13 = null;
        String string = "";
        for (int i = 0; i < object222.size() && var11_14 == null; ++i) {
            String string2;
            String string3 = (String)object222.get(i);
            int n = string3.indexOf(a.c(-429870435, "\ub6db\ucf10\u45cd\udbbd\u501d\ud6a1\u6cf5"));
            if (n < 0) continue;
            int n2 = string3.indexOf(58, n);
            String string4 = string2 = n2 >= 0 ? string3.substring(n2 + 1) : string3.substring(n + 7);
            if (qwj.parse(string2) == null && string2.replaceAll(a.b("\u592b\u209f\uaa4e\u3413\ubfcf\u3949\u832b\u0afa", -2017961608), "").length() < 3 && i + 1 < object222.size()) {
                string2 = (String)object222.get(i + 1);
            }
            string = string2.replaceAll(a.c(-741177950, "\u85f0\ufc44\u7695\ue8c8\u6314\ue592\u5ff0\ud65c\u487e"), "").trim();
            qwj qwj2 = qwj.parse(string2);
        }
        if (var11_14 == null) {
            String string5;
            qwj qwj3;
            Iterator iterator2 = object222.iterator();
            while (iterator2.hasNext() && (qwj3 = qwj.parse(string5 = (String)iterator2.next())) == null) {
            }
        }
        int n = -1;
        for (int i = 0; i < object222.size() && n < 0; ++i) {
            String string6 = (String)object222.get(i);
            if (!string6.contains(a.b("\uccb3\ub50d\u3fd2\ua1a0\u2a7b\uacc3\u169e\u9f67", -222967675)) && !string6.contains(a.d("\u96b9\uef7a\u65dc\ufbd8\u700d", 1740039021, 1272148374))) continue;
            for (int j = i; j < Math.min(object222.size(), i + 3) && n < 0; ++j) {
                n = pzw.seconds((String)object222.get(j));
            }
        }
        if (n < 0) {
            String string7;
            Iterator iterator3 = object222.iterator();
            while (iterator3.hasNext() && (n = pzw.clock(string7 = (String)iterator3.next())) < 0) {
            }
        }
        if (n < 0) {
            return null;
        }
        return new pzp((qwj)var11_16, string, n, pzk4.pzl);
    }

    static int clock(String string) {
        Matcher matcher = pzx.matcher(string);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1)) * 3600 + Integer.parseInt(matcher.group(2)) * 60 + Integer.parseInt(matcher.group(3));
        }
        matcher = pzy.matcher(string);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) * 60 + Integer.parseInt(matcher.group(2)) : -1;
    }

    static int seconds(String string) {
        int n = pzw.clock(string);
        if (n >= 0) {
            return n;
        }
        int n2 = -1;
        Matcher matcher = pzz.matcher(string);
        if (matcher.find()) {
            n2 = Integer.parseInt(matcher.group(1)) * 60;
        }
        if ((matcher = qaa.matcher(string)).find()) {
            n2 = Math.max(0, n2) + Integer.parseInt(matcher.group(1));
        }
        return n2;
    }

    static List<String> lines(Entity entity) {
        Object object;
        Text text;
        ArrayList<String> arrayList = new ArrayList<String>();
        if (entity instanceof DisplayEntity.TextDisplayEntity && (text = pzw.qaf((DisplayEntity.TextDisplayEntity)(object = (DisplayEntity.TextDisplayEntity)entity))) != null) {
            for (String string : text.getString().split(a.b("\u2f3e", -1129304267))) {
                if (string.isBlank()) continue;
                arrayList.add(string);
            }
        }
        if (entity.method_16914() && entity.method_5797() != null && !((String)(object = entity.method_5797().getString())).isBlank()) {
            arrayList.add((String)object);
        }
        return arrayList;
    }

    private static Text qaf(DisplayEntity.TextDisplayEntity textDisplayEntity) {
        if (!qac) {
            qac = true;
            for (Field field : DisplayEntity.TextDisplayEntity.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != TrackedData.class) continue;
                try {
                    field.setAccessible(true);
                    TrackedData exception = (TrackedData)field.get(null);
                    if (exception == null || exception.comp_2328() != TrackedDataHandlerRegistry.field_13317) continue;
                    qab = exception;
                    break;
                }
                catch (ReflectiveOperationException | RuntimeException exception) {
                    // empty catch block
                }
            }
        }
        if (qab == null) {
            return null;
        }
        try {
            Text text;
            Object runtimeException = textDisplayEntity.method_5841().method_12789(qab);
            return runtimeException instanceof Text ? (text = (Text)runtimeException) : null;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    private static /* synthetic */ int bqi(int n, int n2) {
        return n - n2 ^ 0x87AEAFB8;
    }
}

