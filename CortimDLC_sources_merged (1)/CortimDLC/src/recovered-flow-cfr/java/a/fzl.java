/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.util.ScreenshotRecorder
 */
package a;

import flow.Flow;
import flow.dev.a;
import java.io.File;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.util.ScreenshotRecorder;

public final class fzl {
    private static final String fzm = System.getenv(a.d("\u16b1\u6f0a\ue5da\u7bb3\uf001\u76dd\ucc95\u4565\udb29\u5191\ud654\u2c22\ua2f1\u3b4f\ub11a\u37fc", -847691455, -847423578));
    private static /* synthetic */ boolean fzn;
    private static /* synthetic */ String fzo;

    private fzl() {
    }

    public static boolean intercept(Flow flow) {
        int n;
        long l;
        if (fzm == null || fzm.isBlank()) {
            return false;
        }
        try {
            l = Long.parseLong(fzm.trim());
            n = Integer.parseInt(System.getenv().getOrDefault(a.d("\u9d78\ue4c3\u6e13\uf07a\u7bc8\ufd14\u475c\uceac\u50e0\uda58\u5d9d\ua7eb\u2938\ub086\u3ad3\ubc35\u0671\u89ac\u1304\u9552\u1cbe\u66e8", 706754157, -1394627771), a.c(-1506575550, "\u7b73\u02c1")).trim());
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        Thread thread = new Thread(() -> {
            fzl.fzp(l);
            long l2 = System.currentTimeMillis();
            System.out.println(a.d("\u6355\u1ae5\u9025\u0e02\u859c\u032a\ub97d\u3083\uaeda\u247c\ua3e1\u598a\ud70e\u4eb8\uc4fe\u421c\uf855\u77d8\ued6a\u6b32\ue28a\u98d2\u1661\u8df6\u0bdd\u8110\u38ae\ub6ba\u2c0a\uaa5d\u21e2\udf3b\u5536\ucc93\u4a93\uc076\u7fbd\uf5d6\u7312\ueaa7\u60fd", 515757330, 1529525770));
            flow.start();
            flow.injected();
            System.out.println(a.b("\ued2d\u949d\u1e5d\u807a\u0be4\u8d52\u3705\ubefb\u20a2\uaa04\u2d99\ud7f2\u5976\uc0c0\u4a86\ucc64\u762d\uf9a0\u6312\ue54a\u6cb6\u16ec\u9816\u03c0\u85bb\u0f65\ub6d0\u3896\ua270\u2420\uafdf\u510f\udb49\u42ea\uc4ae\u4e0e\uf1d8\u7bae\ufd61\u64db\uee85\u9030\u1a22\u9d94\u0751\u8931\u30f5\uba16", -1174606471) + (System.currentTimeMillis() - l2) + a.c(360838496, "\uf55c\u8ca0\u066d\u984f\u1390\u957d\u2f32\ua6ce\u38d4\ub229\u35f9\ucf86\u4154\ud8e4\u52a0\ud403\u6e05\ue1ce\u7b2e\ufd3b\u74c7\u0e97\u802f\u1bbb\u9d8a\u175a\uaef1\u20fe"));
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            int n2 = 0;
            while (n2 < n) {
                fzl.fzp(1000L);
                int n3 = n2++;
                minecraftClient.execute(() -> ScreenshotRecorder.saveScreenshot((File)minecraftClient.runDirectory, (String)(a.b("\u8d6b\uf4d0\u7e00\ue069\u6bfb\ued55\u5742\udeb4\u40ef\uca51\u4d84\ub7e2\u396c", 1400147200) + n3 + a.c(2027250248, "\u6262\u1b8d\u9140\u0f38")), (Framebuffer)minecraftClient.getFramebuffer(), (int)1, text -> {}));
            }
        }, a.d("\u6307\u1ab7\u9077\u0e50\u85ce\u0378\ub92f\u30d1\uae88\u242e", -1122929840, 1716129849));
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    private static void fzp(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    private static /* synthetic */ int sn(int n, int n2) {
        return n * n2 + -121230845;
    }
}

