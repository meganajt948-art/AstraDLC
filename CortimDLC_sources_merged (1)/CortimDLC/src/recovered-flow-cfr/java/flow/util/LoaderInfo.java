/*
 * Decompiled with CFR 0.152.
 */
package flow.util;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class LoaderInfo {
    private static volatile Map<String, String> cache;
    private static final Set<String> API_HOSTS;
    private static final Map<String, String> ALIAS;

    private LoaderInfo() {
    }

    public static void boot() {
    }

    public static String login() {
        return "ProgrammData";
    }

    public static long uid() {
        return 0L;
    }

    public static String token() {
        return "";
    }

    public static String api() {
        return "";
    }

    public static String combo() {
        return null;
    }

    public static byte[] encKey() {
        return null;
    }

    private static void gateCaller() {
        Class caller;
        try {
            caller = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).walk(s -> s.skip(2L).findFirst().map(StackWalker.StackFrame::getDeclaringClass).orElse(null));
        }
        catch (Throwable ignored) {
            return;
        }
        if (caller == null) {
            return;
        }
        String cn = caller.getName();
        if (cn.startsWith("flow.") || cn.startsWith("a.") || cn.startsWith("boot.")) {
            return;
        }
        if (cn.startsWith("java.") || cn.startsWith("jdk.") || cn.startsWith("sun.")) {
            return;
        }
        if (cn.startsWith("net.fabricmc") || cn.startsWith("net.minecraft")) {
            return;
        }
        try {
            Class<?> ic = Class.forName("flow.sec.Integrity");
            ic.getMethod("tripFromCallerGate", String.class).invoke(null, cn);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        throw new SecurityException();
    }

    private static String str(String key) {
        String v;
        Map<String, String> m = cache;
        if (m == null) {
            cache = m = LoaderInfo.resolve();
        }
        return (v = m.get(key)) == null ? "" : v;
    }

    private static Map<String, String> resolve() {
        HashMap<String, String> out = new HashMap<String, String>();
        for (Map.Entry<String, String> e : ALIAS.entrySet()) {
            String msKey = "_ms." + e.getValue();
            String legacyKey = "flow2." + e.getKey();
            String v = System.getProperty(msKey);
            if (v == null || v.isBlank()) {
                v = System.getProperty(legacyKey);
            }
            if (v != null && !v.isBlank()) {
                out.put(e.getKey(), v.trim());
            }
            try {
                System.clearProperty(msKey);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                System.clearProperty(legacyKey);
            }
            catch (Throwable throwable) {}
        }
        LoaderInfo.fromGuiIni(out);
        String api = (String)out.get("api");
        if (api != null && !LoaderInfo.isTrustedApi(api)) {
            out.remove("api");
        }
        return out;
    }

    private static boolean isTrustedApi(String url) {
        if (url == null || url.length() > 256) {
            return false;
        }
        try {
            URI uri = URI.create(url);
            if (!"https".equalsIgnoreCase(uri.getScheme())) {
                return false;
            }
            String host = uri.getHost();
            return host != null && API_HOSTS.contains(host.toLowerCase(Locale.ROOT));
        }
        catch (Exception e) {
            return false;
        }
    }

    private static void fromGuiIni(Map<String, String> out) {
        try {
            String appdata = System.getenv("APPDATA");
            if (appdata == null || appdata.isEmpty()) {
                return;
            }
            Path file = Paths.get(appdata, new String(new char[]{'F', 'l', 'o', 'w', 'C', 'l', 'i', 'e', 'n', 't'}), "gui.ini");
            if (!Files.isRegularFile(file, new LinkOption[0])) {
                return;
            }
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String raw : lines) {
                int eq;
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#") || line.startsWith(";") || (eq = line.indexOf(61)) <= 0) continue;
                String key = line.substring(0, eq).trim().toLowerCase();
                String value = line.substring(eq + 1).trim();
                if (value.isEmpty() || out.containsKey(key)) continue;
                if (key.equals("open_combo")) {
                    key = "combo";
                }
                if (!key.equals("login") && !key.equals("uid") && !key.equals("token") && !key.equals("api") && !key.equals("combo") && !key.equals("enc_key")) continue;
                out.put(key, value);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    static {
        API_HOSTS = Set.of(new String(new char[]{'f', 'l', 'o', 'w', '2', '-', 'a', 'u', 't', 'h', '.', 'f', 'l', 'o', 'w', '-', 'c', '0', 'd', '8', '7', '.', 'w', 'o', 'r', 'k', 'e', 'r', 's', '.', 'd', 'e', 'v'}));
        ALIAS = Map.of("login", "l", "uid", "u", "token", "t", "api", "a", "combo", "c", "enc_key", "k");
    }
}

