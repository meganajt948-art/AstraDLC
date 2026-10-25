/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.a;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public final class vjs {
    private static final AtomicBoolean vjt = new AtomicBoolean(false);
    private static final long vju = 2000000000L;
    private static final long vjv = 100000000L;
    private static final long vjw = 60000000000L;
    private static volatile long vjx;
    private static volatile Map<Class<?>, byte[]> vjy;
    private static volatile ClassLoader vjz;
    private static volatile Set<String> vka;
    private static volatile Set<String> vkb;
    private static volatile long vkc;
    private static volatile String vkd;
    private static /* synthetic */ String vke;
    private static /* synthetic */ long vkf;

    private vjs() {
    }

    public static void boot() {
        Thread thread = new Thread(vjs::vkg, a.b("\u1f7d\u66c6\uec16\u727f\uf9f2\u7f1d\uc558\u4caf\ud2be\u5840\udf9e\u25ef\uab23", 859250454));
        thread.setDaemon(true);
        thread.start();
    }

    /*
     * WARNING - void declaration
     */
    private static void vkg() {
        try {
            Thread.sleep(3000L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        try {
            void clazz;
            String[] stringArray = new String[]{a.d("\uc9e1\ub05a\u3a8a\ua4e3\u2f6d\ua987\u13d5\u9a39\u0463\u8e90\u0921\uf373\u7daa\ue41e\u6e4c\ue8aa\u52de\udd28\u4793\uc1cb", -10863791, 241758914), a.d("\uf3dc\u8a67\u00b7\u9ede\u1550\u9389\u29f0\ua002\u3e45", -124783787, -1098252058), a.c(1801729254, "\u348a\u4d31\uc7e1\u5988\ud206\u54c9\ueeab\u6755\uf90d\u73b6")};
            ArrayList arrayList = new ArrayList();
            Object linkedHashMap = stringArray;
            int n = ((String[])linkedHashMap).length;
            boolean bl = false;
            while (clazz < n) {
                String string = linkedHashMap[clazz];
                try {
                    arrayList.add(Class.forName(string));
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                ++clazz;
            }
            linkedHashMap = new LinkedHashMap();
            for (Class list : arrayList) {
                try {
                    linkedHashMap.put(list, vjs.vki(list));
                }
                catch (Throwable throwable) {}
            }
            vjy = linkedHashMap;
            try {
                vjz = Class.forName(a.b("\ufd02\u84b9\u0e69\u9000\u1b8e\u9d57\u272e\uaedc\u309b", 1815281005)).getClassLoader();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            HashSet hashSet = new HashSet();
            try {
                for (Thread thread : Thread.getAllStackTraces().keySet()) {
                    if (thread == null || thread.getName() == null) continue;
                    hashSet.add(thread.getName());
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            vka = hashSet;
            try {
                List<String> list = ManagementFactory.getRuntimeMXBean().getInputArguments();
                vkb = new HashSet<String>(list);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            vjx = System.nanoTime();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static void tick() {
        if (vjt.get()) {
            return;
        }
        long l = System.nanoTime();
        if (l < vkc) {
            return;
        }
        long l2 = vjx == 0L ? 0L : l - vjx;
        vkc = l + (l2 < 60000000000L ? 100000000L : 2000000000L);
        try {
            Object object;
            String[] stringArray;
            Object object2;
            Map<Class<?>, byte[]> map = vjy;
            if (map != null) {
                for (Map.Entry object32 : map.entrySet()) {
                    object2 = vjs.vki((Class)object32.getKey());
                    if (vjs.vkj(object2, (byte[])object32.getValue())) continue;
                    vjs.vkk(a.b("\u5a58\u23e1\ua923\u374e\ubc9e\u3a24\u8033\u0991\u97d4\u1d6b\u9aff\u60cd\uee11\u77a9\ufdf5\u7b0d\uc140\u4ece\ud467", 1607096870) + ((Class)object32.getKey()).getName());
                    return;
                }
            }
            try {
                Class<?> clazz;
                stringArray = vjz;
                if (stringArray != null && (clazz = Class.forName(a.b("\u95c2\uec79\u66a9\uf8c0\u734e\uf597\u4fee\uc61c\u585b", -1977772627))).getClassLoader() != stringArray) {
                    vjs.vkk(a.d("\ue3cb\u9a50\u1080\u8ee9\u0569\u83bb\u39e7\ub07a\u2e76\ua4c3\u2306\ud966\u57b1\uce15\u4447", 974993886, 1320082012));
                    return;
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            stringArray = new String[]{a.c(1608487794, "\u931c\ueab8\u606b\ufe0f\u75da\uf360\u497b\uc0c6\u5e9c\ud437\u53e3\ua983\u275f\ubee5\u34a1"), a.b("\u5eb9\u2714\uaddc\u33b4\ub87e", -510042410), a.d("\ud78f\uae30\u24f0\uba86", -1810061853, 1307996674), a.b("\u03b1\u7a06\uf0d7\u6ead\ue560\u6385\ud99b\u5066\uce31\u4487", -965606438), a.c(1617565240, "\u164e\u6fe0\ue537\u7b0f"), a.b("\u3740\u4efb\uc435\u5a47\ud199", -1338296543), a.d("\ud6f3\uaf49\u259f\ubbf2", -145154152, 1462749445), a.b("\u7192\u082d\u82b7\u1c8c\u9749\u11e4", 1936486910)};
            Map<Thread, StackTraceElement[]> map2 = Thread.getAllStackTraces();
            object2 = map2.keySet().iterator();
            while (object2.hasNext()) {
                Iterator<Map.Entry<Thread, StackTraceElement[]>> iterator;
                object = (Thread)object2.next();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> iterator2 = iterator = object == null ? null : object.getName();
                if (iterator == null) continue;
                String string = ((String)((Object)iterator)).toLowerCase(Locale.ROOT);
                for (String string2 : stringArray) {
                    if (!string.contains(string2)) continue;
                    vjs.vkk(a.d("\uf8f6\u8141\u0b94\u95e6\u1e61\u9884\u22cb\uab20\u3568\ubfdd\u380b\uc224\u4ce9", 195878624, 257631848) + (String)((Object)iterator));
                    return;
                }
            }
            if (a.b("\u14c3", -1474292493).equals(System.getProperty(a.b("\ub54b\uccc8\u4605\ud829\u53a3\ud504\u6f51", -1012353773)))) {
                vjs.vkk(a.c(-1972612373, "\u5297\u2b29\ua1ef\u3f83\ub44b\u32e9\u88ff\u015a\u9f10\u15ad\u9263\u6807\ue6c7\u7f24\uf531\u73ca\uc988\u465f"));
                return;
            }
            object2 = vkb;
            if (object2 != null) {
                object = ManagementFactory.getRuntimeMXBean().getInputArguments();
                for (String string : object) {
                    if (!vjs.vkh(string) || object2.contains(string)) continue;
                    vjs.vkk(a.b("\u666b\u1fdc\u955b\u0b60\u80ab\u0601\ubc1f\u35af\uabe3\u2147\ua6c9\u5ca2", -1300011499) + string);
                    return;
                }
            }
            object = new String[]{a.c(686706887, "\u50b0\u290d\ua3dc\u3dee\ub664\u30d3\u8a9b\u032a\u9d2f\u1785\u9056\u6a24\ue4ec\u7d00\uf71c\u71f8\ucbb7\u4473\udec2\u5898"), a.b("\u84e9\ufd5e\u7796\ue9a7\u622a\ue480\u5ed3\ud721\u4961\uc38d\u4411\ube75\u30a2\ua906\u2357\ua5ad", -1073970038), a.b("\u4b20\u329f\ub843\u2677\uadef\u2b4b\u9118\u18fc\u86a1\u0c1b", -532329664), a.c(-802634239, "\uc662\ubfce\u3508\uab30\u20ab\ua61d\u1c45\u95bc\u0bab\u8157\u0681\ufce4"), a.d("\ud532\uac88\u265e\ub833\u33b2", -825283840, 1147666013), a.c(-532209265, "\u21ec\u5855\ud2cd\u4cf1\uc72a\u4198\ufbc2\u722f\uec27\u66ca\ue10e\u1b79\u95ac\u0c1a")};
            for (Map.Entry<Thread, StackTraceElement[]> entry : map2.entrySet()) {
                Object[] objectArray = entry.getValue();
                if (objectArray == null) continue;
                for (Object object3 : objectArray) {
                    String string = ((StackTraceElement)object3).getClassName();
                    if (string == null) continue;
                    for (String string3 : object) {
                        if (!string.startsWith(string3)) continue;
                        vjs.vkk(a.d("\uff6c\u86db\u0c0e\u927c\u19fb\u9f0c\u254b\uaca9\u32fa\ub843\u3fcf\uc5a4", 811934306, -1002316431) + string);
                        return;
                    }
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static boolean vkh(String string) {
        if (string == null) {
            return false;
        }
        return string.startsWith(a.b("\u8482\ufd7f\u77aa\ue9d9\u6205\ue4ae\u5ee5\ud711\u4945\uc3ac\u442f\ube50\u3094\ua922", 1690535073)) || string.startsWith(a.c(-339249476, "\u769a\u0f6c\u85b4\u1bd2\u9012\u16a3\uacf6\u2505\ubb51\u31fa\ub667")) || string.startsWith(a.c(-265931766, "\u342c\u4dd1\uc704\u5977\ud2ab\u5400\uee57\u67b7\uf9fd\u7350\uf4d1")) || string.startsWith(a.d("\ua181\ud845\u52aa\uccda\u470a\uc1ac\u7bed", 1194690464, 70985227));
    }

    private static byte[] vki(Class<?> clazz) {
        try {
            Method[] methodArray = clazz.getDeclaredMethods();
            Arrays.sort(methodArray, (method, method2) -> {
                int n = method.getName().compareTo(method2.getName());
                if (n != 0) {
                    return n;
                }
                return Integer.compare(method.getParameterCount(), method2.getParameterCount());
            });
            StringBuilder stringBuilder = new StringBuilder();
            for (Method method3 : methodArray) {
                stringBuilder.append(method3.getName()).append('(');
                Class<?>[] classArray = method3.getParameterTypes();
                for (int i = 0; i < classArray.length; ++i) {
                    if (i > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append(classArray[i].getName());
                }
                stringBuilder.append(')').append(method3.getModifiers()).append('/').append(method3.getReturnType().getName()).append(';');
            }
            MessageDigest messageDigest = MessageDigest.getInstance(a.b("\ud0c2\ua968\u23b2\ubdaf\u3667\ub0d1\u0a81", 516214934));
            return messageDigest.digest(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        }
        catch (Throwable throwable) {
            return new byte[0];
        }
    }

    private static boolean vkj(byte[] byArray, byte[] byArray2) {
        if (byArray == null || byArray2 == null || byArray.length != byArray2.length) {
            return false;
        }
        int n = 0;
        for (int i = 0; i < byArray.length; ++i) {
            n |= byArray[i] ^ byArray2[i];
        }
        return n == 0;
    }

    public static void tripFromCallerGate(String string) {
        vjs.vkk(a.c(2061013130, "\u90e4\ue957\u6389\ufdf8\u7626\uf080\u4a81\uc337\u5d6e\ud7ca\u5008\uaa26\u24eb") + string);
    }

    private static void vkk(String string) {
        Object object;
        if (!vjt.compareAndSet(false, true)) {
            return;
        }
        vkd = string;
        try {
            object = Class.forName(a.d("\uf28e\u8b35\u01e5\u9f8c\u1402\u92cd\u28af\ua151\u3f09\ub5b2", 2022442473, -179833077));
            ((Class)object).getMethod(a.b("\u8f7e\uf6c9\u7c01\ue27e\u69a9\uef1a\u555e", -129659123), new Class[0]).invoke(null, new Object[0]);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        object = new Thread(() -> {
            try {
                int n = ThreadLocalRandom.current().nextInt(15000, 60000);
                Thread.sleep(n);
            }
            catch (InterruptedException interruptedException) {
            }
            finally {
                try {
                    System.exit(0);
                }
                catch (Throwable throwable) {}
            }
        });
        ((Thread)object).setDaemon(true);
        ((Thread)object).start();
    }

    private static /* synthetic */ int dgg(int n, int n2) {
        return (n ^ n2) + 383104833;
    }
}

