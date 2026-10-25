/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vpi;
import a.vpo;
import flow.dev.a;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

final class vnb {
    static final List<String> NAMES = List.of(a.c(-1980250628, "\uc5b6\ubc21\u36fb\ua883\u2342\ua5f4\u1fba\u9643\u0811"), a.d("\u1348\u6ace\ue00a\u7e7b\uf5a2\u731a", -1710906119, 1216198645), a.b("\uddb6\ua424\u2ee9\ub09f\u3b4d\ubdfb\u07a1", 2099633637));
    private static /* synthetic */ long vnc;
    private static /* synthetic */ String vnd;

    private vnb() {
    }

    static boolean has(String string) {
        return NAMES.contains(string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static vpi load(String string, boolean bl) {
        String string2 = a.c(764142521, "\ue39b\u9a63\u10ba\u8ec8\u0507\u83ee\u39e1\ub00c\u2e49\ua4e3\u233a\ud95c\u57d7") + string.toLowerCase(Locale.ROOT) + (bl ? a.c(-2066750377, "\ue40b\u9d8a\u1758") : a.d("\ufe1e\u879f\u0d45\u9334", -1242686201, -486939838)) + a.c(-505650787, "\u61b7\u1847\u929c\u0ced");
        try (InputStream inputStream = vnb.class.getResourceAsStream(string2);){
            if (inputStream == null) {
                vpi vpi3 = null;
                return vpi3;
            }
            vpi vpi2 = vpo.decode(inputStream.readAllBytes());
            return vpi2;
        }
        catch (Exception exception) {
            System.out.println(a.c(-10428349, "\ue03d\u998e\u1352\u8d6a\u06ee\u800b\u3a08\ub3e5\u2db7\ua71e\u2094\udab1\u547a\ucdc6\u47d0\uc163\u7b3b\uf4f1\u6e48\ue811\u61ef\u1bbf\u9548\u0eca\u88a9\u0262\ubbca\u3591\uaf22") + string2 + a.b("\uf1be\u8815", -1790578298) + exception);
            return null;
        }
    }

    private static /* synthetic */ int did(int n, int n2) {
        return n - n2 + -1198224410;
    }

    private static /* synthetic */ int die(int n, int n2) {
        return vnb.did(n, n2) * n2;
    }

    private static /* synthetic */ int dif(int n, int n2) {
        return n * n2 + -729773917;
    }
}

