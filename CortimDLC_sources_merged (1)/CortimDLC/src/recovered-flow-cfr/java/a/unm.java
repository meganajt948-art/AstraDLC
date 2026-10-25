/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.uok;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.jspecify.annotations.Nullable;

public final class unm {
    private static uok unn;
    private static boolean uno;
    private static /* synthetic */ long unp;
    private static /* synthetic */ int unq;

    private unm() {
    }

    public static @Nullable GpuTextureView view() {
        if (unn == null && !uno) {
            try (InputStream inputStream = unm.class.getResourceAsStream("/flow/glow.png");){
                BufferedImage bufferedImage;
                BufferedImage bufferedImage2 = bufferedImage = inputStream == null ? null : ImageIO.read(inputStream);
                if (bufferedImage == null) {
                    throw new IllegalStateException("missing /flow/glow.png");
                }
                unn = uok.upload("glow", bufferedImage, false, true);
            }
            catch (Throwable throwable) {
                uno = true;
                System.out.println("glow sprite unavailable: " + throwable);
            }
        }
        return unn != null ? unm.unn.view : null;
    }

    private static /* synthetic */ int cyp(int n, int n2) {
        return n + n2 ^ 0x47912059;
    }

    private static /* synthetic */ int cyq(int n, int n2) {
        return (n ^ n2) + -800343550;
    }

    private static /* synthetic */ int cyr(int n, int n2) {
        return unm.cyp(n, n2) * n2;
    }
}

