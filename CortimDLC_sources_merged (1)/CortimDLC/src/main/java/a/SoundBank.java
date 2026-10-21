/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.vpi;
import a.SoundLibrary;
import flow.dev.StringDecryptor;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

final class SoundBank {
    static final List<String> NAMES = List.of("Celestial", "Bubble", "Twinkle");
    private static /* synthetic */ long vnc;
    private static /* synthetic */ String vnd;

    private SoundBank() {
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
        String string2 = "/flow/sounds/" + string.toLowerCase(Locale.ROOT) + (bl ? "_on" : "_off") + ".ogg";
        try (InputStream inputStream = SoundBank.class.getResourceAsStream(string2);){
            if (inputStream == null) {
                vpi vpi3 = null;
                return vpi3;
            }
            vpi vpi2 = SoundLibrary.decode(inputStream.readAllBytes());
            return vpi2;
        }
        catch (Exception exception) {
            System.out.println("can't play the bundled sound " + string2 + ": " + exception);
            return null;
        }
    }

    private static /* synthetic */ int did(int n, int n2) {
        return n - n2 + -1198224410;
    }

    private static /* synthetic */ int die(int n, int n2) {
        return SoundBank.did(n, n2) * n2;
    }

    private static /* synthetic */ int dif(int n, int n2) {
        return n * n2 + -729773917;
    }
}

