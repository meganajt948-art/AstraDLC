/*
 * Decompiled with CFR 0.152.
 */
package a;

import flow.dev.StringDecryptor;
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

public final class SecurityGate {
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

    private SecurityGate() {
    }

    public static void boot() {
        Thread thread = new Thread(SecurityGate::vkg, "flow-sec-boot");
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
            String[] stringArray = new String[]{"flow.util.LoaderInfo", "flow.Flow", "flow.Panic"};
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
                    linkedHashMap.put(list, SecurityGate.vki(list));
                }
                catch (Throwable throwable) {}
            }
            vjy = linkedHashMap;
            try {
                vjz = Class.forName("flow.Flow").getClassLoader();
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
                    object2 = SecurityGate.vki((Class)object32.getKey());
                    if (SecurityGate.vkj(object2, (byte[])object32.getValue())) continue;
                    SecurityGate.vkk("method sig change: " + ((Class)object32.getKey()).getName());
                    return;
                }
            }
            try {
                Class<?> clazz;
                stringArray = vjz;
                if (stringArray != null && (clazz = Class.forName("flow.Flow")).getClassLoader() != stringArray) {
                    SecurityGate.vkk("Flow CL swapped");
                    return;
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            stringArray = new String[]{"attach listener", "jvmti", "jdwp", "agent main", "rmi ", "dnspy", "jadx", "jd-gui"};
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
                    SecurityGate.vkk("susp thread: " + (String)((Object)iterator));
                    return;
                }
            }
            if ("1".equals(System.getProperty("_ms.sec"))) {
                SecurityGate.vkk("native tamper flag");
                return;
            }
            object2 = vkb;
            if (object2 != null) {
                object = ManagementFactory.getRuntimeMXBean().getInputArguments();
                for (String string : object) {
                    if (!SecurityGate.vkh(string) || object2.contains(string)) continue;
                    SecurityGate.vkk("rt jvm arg: " + string);
                    return;
                }
            }
            object = new String[]{"com.sun.tools.attach", "sun.tools.attach", "jdk.attach", "org.benf.cfr", "jadx.", "me.coley.recaf"};
            for (Map.Entry<Thread, StackTraceElement[]> entry : map2.entrySet()) {
                Object[] objectArray = entry.getValue();
                if (objectArray == null) continue;
                for (Object object3 : objectArray) {
                    String string = ((StackTraceElement)object3).getClassName();
                    if (string == null) continue;
                    for (String string3 : object) {
                        if (!string.startsWith(string3)) continue;
                        SecurityGate.vkk("susp frame: " + string);
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
        return string.startsWith("-agentlib:jdwp") || string.startsWith("-javaagent:") || string.startsWith("-agentpath:") || string.startsWith("-Xdebug");
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
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
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
        SecurityGate.vkk("caller gate: " + string);
    }

    private static void vkk(String string) {
        Object object;
        if (!vjt.compareAndSet(false, true)) {
            return;
        }
        vkd = string;
        try {
            object = Class.forName("flow.Panic");
            ((Class)object).getMethod("trigger", new Class[0]).invoke(null, new Object[0]);
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

