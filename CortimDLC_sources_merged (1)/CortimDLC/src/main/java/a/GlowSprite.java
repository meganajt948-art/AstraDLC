/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  org.jspecify.annotations.Nullable
 */
package a;

import a.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.jspecify.annotations.Nullable;

public final class GlowSprite {
    private static GpuTexture unn;
    private static boolean uno;
    private static /* synthetic */ long unp;
    private static /* synthetic */ int unq;

    private GlowSprite() {
    }

    public static @Nullable GpuTextureView view() {
        if (unn == null && !uno) {
            try (InputStream inputStream = GlowSprite.class.getResourceAsStream("/flow/glow.png");){
                BufferedImage bufferedImage;
                BufferedImage bufferedImage2 = bufferedImage = inputStream == null ? null : ImageIO.read(inputStream);
                if (bufferedImage == null) {
                    throw new IllegalStateException("missing /flow/glow.png");
                }
                unn = GpuTexture.upload("glow", bufferedImage, false, true);
            }
            catch (Throwable throwable) {
                uno = true;
                System.out.println("glow sprite unavailable: " + throwable);
            }
        }
        return unn != null ? GlowSprite.unn.view : null;
    }

    private static /* synthetic */ int cyp(int n, int n2) {
        return n + n2 ^ 0x47912059;
    }

    private static /* synthetic */ int cyq(int n, int n2) {
        return (n ^ n2) + -800343550;
    }

    private static /* synthetic */ int cyr(int n, int n2) {
        return GlowSprite.cyp(n, n2) * n2;
    }
}

